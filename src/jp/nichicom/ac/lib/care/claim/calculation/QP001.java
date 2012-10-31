/*
 * Project code name "ORCA"
 * 給付管理台帳ソフト QKAACHO（JMA care benefit management software）
 * Copyright(C) 2002 JMA (Japan Medical Association)
 *
 * This program is part of "QKANCHO (JMA care benefit management software)".
 *
 * This program is distributed in the hope that it will be useful
 * for further advancement in medical care, according to JMA Open
 * Source License, but WITHOUT ANY WARRANTY.
 * Everyone is granted permission to use, copy, modify and
 * redistribute this program, but only under the conditions described
 * in the JMA Open Source License. You should have received a copy of
 * this license along with this program. If not, stop using this
 * program and contact JMA, 2-28-16 Honkomagome, Bunkyo-ku, Tokyo,
 * 113-8621, Japan.
 *****************************************************************
 * アプリ: QKANCHO
 * 開発者: 藤原　伸
 * 作成日: 2005/12/06  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 実績確定/請求書出力 (P)
 * プロセス 請求処理 (001)
 * プログラム 利用者一覧（請求） (QP001)
 *
 *****************************************************************
 */
package jp.nichicom.ac.lib.care.claim.calculation;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.Qkan10011_ServiceCodeManager;
import jp.nichicom.ac.lib.care.claim.servicecode.Qkan10011_ServiceUnitGetter;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanValidServiceCommon;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.adapter.ACComboBoxModelAdapter;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.ac.util.splash.ACSplash;
import jp.nichicom.ac.util.splash.ACSplashable;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.component.table.VRSortableTableModelar;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRLinkedHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.adapter.VRHashMapArrayToConstKeyArrayAdapter;
import jp.nichicom.vr.util.logging.VRLogger;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.affair.qp.qp002.QP002;
import jp.or.med.orca.qkan.affair.qp.qp007.QP007;
import jp.or.med.orca.qkan.affair.qp.qp008.QP008;
import jp.or.med.orca.qkan.text.QkanClaimStateFormat;
import jp.or.med.orca.qkan.text.QkanClaimStyleFormat;
import jp.or.med.orca.qkan.text.QkanInsureTypeFormat;
import jp.or.med.orca.qkan.text.QkanJotaiCodeFormat;

/**
 * 利用者一覧（請求）(QP001)
 */
@SuppressWarnings("serial")
public class QP001 extends QP001Event {
    
    QP001CSVCreator creator = new QP001CSVCreator();

    /**
     * コンストラクタです。
     */
    public QP001() {
    }

    public void initAffair(ACAffairInfo affair) throws Exception {
        super.initAffair(affair);
        initAction(affair);
    }

    /**
     * 初期化処理を行ないます。
     * 
     * @param affair
     *            業務情報
     * @throws Exception
     *             処理例外
     */
    protected void initAction(ACAffairInfo affair) throws Exception {
        VRList loginProviderInfo= QkanCommon.getProviderInfo(getDBManager(), QkanSystemInformation.getInstance().getLoginProviderID());
        if((loginProviderInfo==null)||(loginProviderInfo.isEmpty())){
            QkanMessageList.getInstance().QP001_ERROR_OF_NO_LOGIN_PROVIDER();
            ACFrame.getInstance().back();
            return;
        }else{
            Map map = (Map)loginProviderInfo.getData();
            getLoginProviderInfo()
                    .setText("「" + map.get("PROVIDER_NAME") + "」に関する集計・請求処理を行ないます。他の事業所を対象とする場合は、ログアウトを行い事業所を選択しなおしてください。");
        }
        

        setAffair(ACCastUtilities.toString(affair.getParameters().get("NEXT_AFFAIR")));
        // 業務のウィンドウタイトル等の情報を格納するためのVRHashMap affairInfoMapを定義する。
        VRMap affairInfoMap = null;
        // 画面の初期状態を設定する。affairの値によって、設定が分岐する。
        // 「01」の場合
        if ("01".equals(getAffair())) {
            // 利用者一覧（実績確定・請求データ作成）用の設定を行う。
            setState_INIT_01();
            getInfoTableColumn2().setHeaderValue("確定");
            // 業務情報を取得し、affairInfoMapに格納する。
            affairInfoMap = QkanCommon.getAffairInfo(getDBManager(), "QP001",
                    "01");
            
            // [ID:0000612][Shin Fujihara] 2010/11 add begin 2010年度対応
            // サービス種類ごとに請求書・領収書を発行するかのフラグを設定
            //FIXME [0000612]
            setServiceByReceipt(false);
            /*
            if (ACFrame.getInstance().hasProperty("PrintConfig/ServiceByReceipt")
                	&& ACCastUtilities.toInt(getProperty("PrintConfig/ServiceByReceipt")) == 1) {
            	setServiceByReceipt(true);
            } else {
            	setServiceByReceipt(false);
            }
            */
            // [ID:0000612][Shin Fujihara] 2010/11 add end 2010年度対応
            
            setState_CLAIM_DATE_DISABLE();
        }
        // 「02」の場合
        else if ("02".equals(getAffair())) {
            // 利用者一覧（給付管理票）用の設定を行う。
            setState_INIT_02();
            // 業務情報を取得し、affairInfoMapに格納する。
            affairInfoMap = QkanCommon.getAffairInfo(getDBManager(), "QP001", "02");
        }
        // 「03」の場合
        else if ("03".equals(getAffair())) {
            // 利用者一覧（在宅サービス支援事業所請求）用の設定を行う。
            setState_INIT_03();
            // 業務情報を取得し、affairInfoMapに格納する。
            affairInfoMap = QkanCommon.getAffairInfo(getDBManager(), "QP001", "03");
        }
        // 「04」の場合
        else if ("04".equals(getAffair())) {
            // 利用者一覧（在宅サービス提供事業所請求）用の設定を行う。
            setState_INIT_04();
            // 業務情報を取得し、affairInfoMapに格納する。
            affairInfoMap = QkanCommon.getAffairInfo(getDBManager(), "QP001", "04");
        }
        // 「05」の場合
        else if ("05".equals(getAffair())) {
            //出荷直前の仕様変更に伴い未使用項目
            // 利用者一覧（施設サービス提供事業者請求）用の設定を行う。
            setState_INIT_05();
            // 業務情報を取得し、affairInfoMapに格納する。
            affairInfoMap = QkanCommon.getAffairInfo(getDBManager(), "QP001", "05");
        }
        // 「06」の場合
        else if ("06".equals(getAffair())) {
            // 利用者一覧（医療請求）用の設定を行う。
            setState_INIT_06();
            // 業務情報を取得し、affairInfoMapに格納する。
            affairInfoMap = QkanCommon.getAffairInfo(getDBManager(), "QP001", "06");
        }
        // 「07」の場合
        else if ("07".equals(getAffair())) {
            // 利用者一覧(利用者向け印刷)用の設定を行う。
            setState_INIT_07();
            // 業務情報を取得し、affairInfoMapに格納する。
            affairInfoMap = QkanCommon.getAffairInfo(getDBManager(), "QP001", "07");
        }
        // 「08」の場合
        else if ("08".equals(getAffair())) {
            // 利用者一覧（介護給付費請求書）用の設定を行う。
            setState_INIT_08();
            // 業務情報を取得し、affairInfoMapに格納する。
            affairInfoMap = QkanCommon.getAffairInfo(getDBManager(), "QP001", "08");
        }
        
        // ウィンドウタイトルとして、affairInfoMapの KEY : WINDOW_TITLE の VALUE を設定する。
        setTitle(ACCastUtilities.toString(affairInfoMap.get("WINDOW_TITLE")));
        // システムから、「システム日付」を取得する。
        // 画面の「対象年月(targetDate)」に、取得したシステム日付の前月を設定する。
        getTargetDate().setDate(ACDateUtilities.addMonth(QkanSystemInformation.getInstance().getSystemDate(),-1));
        

        // 保険者情報を取得し、以下のKEYでthis.mapに設定する。（パラメータ省略）
        setInsureData( QkanCommon.getInsurerInfo(getDBManager()));

        if ((getInsureData() != null) && (getInsureData().size() > 0)) {
            //先頭に空白を入れる。
            VRMap insurerTemp = new VRHashMap();
            insurerTemp.put("INSURER_NAME","");
            insurerTemp.put("INSURER_ID","");
            getInsureData().add(0,insurerTemp);
            getInsurerNoConbo().setModel(
                    new ACComboBoxModelAdapter(
                            new VRHashMapArrayToConstKeyArrayAdapter(
                                    getInsureData(), "INSURER_NAME")));
        }

        // カラムのフォーマットを指定する。
        // 印刷状態
        //getInfoTableColumn2().setFormat(QkanClaimStateFormat.getInstance());
        getInfoTableColumn2().setFormat(new QkanClaimStateFormat(getAffair()));
        // 様式
        getInfoTableColumn14().setFormat(QkanClaimStyleFormat.getInstance());
        // 要介護度
        getInfoTableColumn15().setFormat(QkanJotaiCodeFormat.getInstance());
        // 保険区分
        getInfoTableColumn16().setFormat(QkanInsureTypeFormat.getInstance());
        // 計画単位数
        getInfoTableColumn17().setFormat(NumberFormat.getInstance());
        // サービス単位数
        getInfoTableColumn18().setFormat(NumberFormat.getInstance());
        //サービス合計金額
        getInfoTableColumn19().setFormat(NumberFormat.getInstance());
        //保険請求額
        getInfoTableColumn20().setFormat(NumberFormat.getInstance());
        //公費負担額
        getInfoTableColumn21().setFormat(NumberFormat.getInstance());
        //利用者負担額
        getInfoTableColumn22().setFormat(NumberFormat.getInstance());
        
        //区分カラムの設定
        VRList kubun = new VRArrayList();
        kubun.add("新規");
        kubun.add("修正");
        kubun.add("取消");
        getInfoTableColumn23().setEditorModel(kubun);

        
        //チェックを有効にする
        getNotOutputDistinction().setSelected(true);

        setPatientTableModel(new ACTableModelAdapter(new String[] { "NO",// No
                "PRINT",// 印刷
                "CHOISE",// 選択
                "DELETE",// 削除
                "KUBUN",// 区分
                "TARGET_DATE",// 年月度
                "CLAIM_STYLE_TYPE",// 様式
                "INSURER_ID",// 保険者番号
                "INSURER_NAME",// 保険者名称
                "PATIENT_CODE",// 利用者コード
                "INSURED_ID",// 被保険者番号
                "PATIENT_NAME",// 利用者氏名
                "PATIENT_KANA",// ふりがな
                "PATIENT_SEX",// 性別
                "PATIENT_BIRTHDAY",// 年齢
                
                "JOTAI_CODE",// 要介護度
                "INSURE_TYPE",// 保険区分
                "PLAN_RATE",// 計画単位
                "SERVICE_UNIT",// サービス単位
                "SERVICE_TOTAL",// サービス合計金額
                "HOKEN",// 保険請求額
                "KOUHI",// 公費負担額
                "RIYOUSYA"// 利用者負担額
        }));
        // データの設定を行う。
        getInfoTable().setModel(getPatientTableModel());
        
        // [ID:0000630][Shin Fujihara] 2011/02 add begin 2010年度対応
        // 保険者の列を非表示に
        getInfoTableColumn16().setVisible(false);
        // [ID:0000630][Shin Fujihara] 2011/02 add end 2010年度対応
        
        // [ID:0000599][Shin Fujihara] 2010/11 edit begin 2010年度対応
        /*
        //検索対象日付をログイン日付にする
        getTargetDate().setDate(ACDateUtilities.addMonth(QkanSystemInformation.getInstance().getSystemDate(),-1));
        //請求月の日付を設定する。
        getClaimDate().setDate(QkanSystemInformation.getInstance().getSystemDate());
        getClaimDateUpdate().setDate(QkanSystemInformation.getInstance().getSystemDate());
        */
        
        /*
			請求年月の初期表示に関する修正
			システム日付が20日以前(20日も含む)であれば、請求年月をシステム日付の年月
			システム日付が21日以降であれば、請求年月をシステム日付の翌月の年月
			に設定する。
			また、対象年月は上記ルールで判定した請求年月の前月とする。
		*/
        
        Date initSeikyuDate = QkanSystemInformation.getInstance().getSystemDate();
        // 21日以降であれば、次月にする
        if (21 <= ACDateUtilities.getDayOfMonth(QkanSystemInformation.getInstance().getSystemDate())) {
        	initSeikyuDate = ACDateUtilities.addMonth(initSeikyuDate, 1);
        }
        
        // 請求年月関連の設定
        getClaimDate().setDate(initSeikyuDate);
        getClaimDateUpdate().setDate(initSeikyuDate);
        
        // [ID:0000727][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 edit begin
        // 2012年4月未満になる場合はそのままとする
        if(ACDateUtilities.compareOnMonth(initSeikyuDate, ACDateUtilities.createDate(2012, 4)) <= 0) {
            getTargetDate().setDate(initSeikyuDate);
        } else {
            // 対象年月の設定
            getTargetDate().setDate(ACDateUtilities.addMonth(initSeikyuDate, -1));
        }
        // [ID:0000727][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 edit end
        // [ID:0000599][Shin Fujihara] 2010/11 edit end 2010年度対応
        
        
        //請求書日付をログイン日付にする。
        getClaimDatePrint().setDate(QkanSystemInformation.getInstance().getSystemDate());
        
        //詳細編集画面から戻ってきた場合の再描画処理
        VRMap param = affair.getParameters();
        if( VRBindPathParser.has("QP001_DATA", param) ){
            VRMap memory = (VRMap)VRBindPathParser.get("QP001_DATA", param);
            this.setSource( memory );
            this.bindSource();
            param.removeData("QP001_DATA");
            
            doFind();
            
            String patient_id = ACCastUtilities.toString(param.get("PATIENT_ID"));
            
            for(int i = 0; i < getPatientData().size(); i++){
                VRMap map = (VRMap)getPatientData().get(i);
                if(ACCastUtilities.toString(map.get("PATIENT_ID")).equals(patient_id)){
                    getPatientTableModel().setAdaptee(getPatientData());
                    getInfoTable().setSelectedModelRow(
                            ((VRSortableTableModelar) getInfoTable().getModel())
                                    .getReverseTranslateIndex(i));
                    getInfoTable().scrollSelectedToVisible();
                    break;
                }
            }
        } else {
            //起動時に検索するよう修正
            doFind();
        }
    }

    // コンポーネントイベント


    /**
     * 「チェック付加」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void allSelectActionPerformed(ActionEvent e) throws Exception {
        // 画面の「利用者一覧(infoTable)」に表示している利用者の「選択(列(infoTableColumn3)」のチェックをつける。
        for (int i = 0; i < getPatientData().getDataSize(); i++) {
            ((VRLinkedHashMap) getPatientData().get(i)).setData("CHOISE",
                    new Boolean(true));
        }
        infoTableSelectionChanged(null);
        getPatientTableModel().setAdaptee(getPatientData());
        getInfoTable().setSelectedModelRow(
                ((VRSortableTableModelar) getInfoTable().getModel())
                        .getReverseTranslateIndex(0));
        getInfoTable().requestFocus();
    }


    /**
     * テーブルがダブルクリックされた時のイベントです。
     * @param e
     */
    protected void infoTableSelectionchangedDouble(MouseEvent e) throws Exception {
        moveQP002();
    }
    
    /**
     * 「帳票（様式）・事業所選択に遷移」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void entryActionPerformed(ActionEvent e) throws Exception {
        moveQP002();
    }
    
    private void moveQP002() throws Exception {
        
        //詳細編集ボタンの表示を確認
        if(!getEntry().isVisible() || !getEntry().isEnabled()){
            return;
        }
        
        //画面情報の退避
        VRHashMap memory = new VRHashMap();
        this.setSource( memory );
        this.applySource();
        ACFrame.getInstance().addNowAffairParameter("QP001_DATA", memory);
        
        // 次画面への渡りパラメータ格納用にレコード paramを生成する。
        VRMap param = new VRHashMap();

        // 次画面遷移のためのパラメータ ACAffairInfo affair を定義する。
        ACAffairInfo affair = null;
        
        //選択列番号を取得
        int select = getInfoTable().getSelectedModelRow();
        //未選択であれば処理を中断
        if(select < 0){
            return;
        }
        //選択列のデータを取得
        VRMap map = (VRMap)getPatientData().get(select);
        
        // paramに下記パラメータを設定する。
        // KEY : PATIENT_ID
        param.put("PATIENT_ID", map.get("PATIENT_ID"));
        // KEY :
        param.put("CLAIM_DATE", map.get("CLAIM_DATE"));

        // 下記パラメータにてaffairを生成する。
        //className : QP002.class.getName();
        affair = new ACAffairInfo(QP002.class.getName(), param);
        // ※渡り処理
        // 次画面に遷移する。
        ACFrame.getInstance().next(affair);
    }

    /**
     * 「検索」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void findActionPerformed(ActionEvent e) throws Exception {
        
        // 検索を行ってよいか確認を行う。
        if (!checkFind()) {
            return;
        }

        // 検索を行う。
        doFind();
    }

    /**
     * 「削除」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void deleteActionPerformed(ActionEvent e) throws Exception {
        // 削除確認メッセージを表示する。
        if (QkanMessageList.getInstance().WARNING_OF_DELETE_SELECTION() == ACMessageBox.RESULT_OK) {
            // 選択された利用者の集計データを削除する。
            String choise;
            Date targetDate = getTargetDate().getDate();
            VRMap map;
            
            //[ID:0000612][Shin Fujihara] 2010/11 add begin 2010年度対応
            /* FIXME [0000612]
            VRMap sqlParam = new VRHashMap();
            VRDateParser.format(ACDateUtilities.toFirstDayOfMonth(targetDate), "yyyy/MM/dd");
            VRDateParser.format(ACDateUtilities.toLastDayOfMonth(targetDate), "yyyy/MM/dd");
            sqlParam.put("TARGET_DATE_START", VRDateParser.format(ACDateUtilities.toFirstDayOfMonth(targetDate), "yyyy/MM/dd"));
            sqlParam.put("TARGET_DATE_END", VRDateParser.format(ACDateUtilities.toLastDayOfMonth(targetDate), "yyyy/MM/dd"));
            sqlParam.put("PROVIDER_ID", QkanSystemInformation.getInstance().getLoginProviderID());
            */
            //[ID:0000612][Shin Fujihara] 2010/11 add end 2010年度対応
            
            for (int i = 0; i < getPatientData().getDataSize(); i++) {
                map = (VRMap) getPatientData().get(i);
                choise = String.valueOf(VRBindPathParser.get("DELETE", map));
                // 選択されていれば削除実行
                if ("TRUE".equalsIgnoreCase(choise)) {
                    // コレで削除
                    QkanCommon.updateClaimDetail(getDBManager(),
                            new VRArrayList(), targetDate, ACCastUtilities
                                    .toInt(VRBindPathParser.get("PATIENT_ID",map)),QkanSystemInformation.getInstance().getLoginProviderID());
                    
                    
                    //[ID:0000612][Shin Fujihara] 2010/11 add begin 2010年度対応
                    //削除ボタンが押されたときは、ちゃんと利用者向け請求のデータも削除する。
                    /* FIXME [0000612]
                    sqlParam.put("PATIENT_ID", VRBindPathParser.get("PATIENT_ID",map));
                    VRList list = getDBManager().executeQuery(getSQL_GET_CLAIM_ID(sqlParam));
                    for (int j = 0; j < list.size(); j++) {
                    	VRMap row = (VRMap)list.get(j);
                    	row.put("MODE", "ALL");
                    	getDBManager().executeUpdate(getSQL_GET_CLAIM_PATIENT_DETAIL_DELETE(row));
                    	getDBManager().executeUpdate(getSQL_DELETE_CLAIM(row));
                    }
                    */
                    //[ID:0000612][Shin Fujihara] 2010/11 add end 2010年度対応
                }
            }

            // 再検索
            doFind();
        }
    }

    /**
     * 「印刷」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void printActionPerformed(ActionEvent e) throws Exception {
        // 入力チェックを行なう。
        if (!checkSelect("選択", "帳票を印刷")) {
            return;
        }
        
        //2006/05/01 add-begin Tozo TANAKA
        VRMap printParam = null;
        // 利用者請求印刷時は印刷オプションを取得
        if ("07".equals(getAffair())) {
            QP007 qp007 = new QP007();
            qp007.setVisible(true);
            
            printParam = qp007.getResult(); 
            if(printParam== null){
                return;
            }
        }
        //2006/05/01 add-end Tozo TANAKA

        
        //印刷データ作成までスプラッシュを表示
        ACSplash splash = (ACSplash)ACFrame.getInstance().getFrameEventProcesser().createSplash("印刷データ");
        
        try{
            // 事業所情報を取得する。
            VRMap providerMap = new VRHashMap();
            ACBindUtilities.setMapFromArray(QkanCommon
                    .getProviderInfo(getDBManager()), providerMap, "PROVIDER_ID");
            
            
            //[H20.5 法改正対応] fujihara add start
            //TODO
            //暫定的に表示されているデータの先頭の対象年月を取得し、
            //マスタデータの取得を行っている。
            //厳密には、出力する帳票ごとに日付を変更する必要がある。
            //[H20.5 法改正対応] fujihara add end
            Date target = ACCastUtilities.toDate(((VRMap)getPatientData().get(0)).get("TARGET_DATE"));
            // データマネージャの初期化
            QP001Manager manager = new QP001Manager(getDBManager(), target);
            

            // 印刷用クラスを宣言
            ACChotarouXMLWriter writer = new ACChotarouXMLWriter();
            
            //印刷内容の編集開始を宣言
            writer.beginPrintEdit();
            

            QP001PrintControl printer = new QP001PrintControl();
            //必用なオブジェクトを設定
            printer.setDBManager(getDBManager());
            printer.setWriter(writer);
            printer.setAffair(getAffair());
            
            //2009/1/6 fujihara edit start
            //利用者向け請求の場合は、画面に表示されている順で印字する
            if ("07".equals(getAffair())){
            	printer.setPatientList(getSortedTableList());
            
            //それ以外は通常通り
            } else {
            	printer.setPatientList(getPatientData());
            }
            //printer.setPatientList(getPatientData());
            //2009/1/6 fujihara edit end
            
            printer.setPrintDate(getClaimDatePrint().getDate());
            
            if(hasProperty("PrintConfig/YoshikiBango")){
                printer.setPrintOption(getProperty("PrintConfig/YoshikiBango"));
            }
            
            if(hasProperty("PrintConfig/printNursingZero")){
                printer.setPrintNursingZero(getProperty("PrintConfig/printNursingZero"));
            }
            
            if(hasProperty("PrintConfig/printNursingLimitZero")){
                printer.setPrintNursingLimitZero(getProperty("PrintConfig/printNursingLimitZero"));
            }
            
            //画面上の請求つきではなく、表示している実データから請求日付を取得するよう変更
//            printer.setClaimDate(getClaimDate().getDate());
            printer.setProviderMap(providerMap);
            printer.setManager(manager);
            
            // 印刷実行
            if (!printer.doPrint(printParam)) {
                return;
            }
            
            // 印刷終了を宣言
            printer.getWriter().endPrintEdit();
            
            if (splash != null) {
                splash.close();
                splash = null;
            }
            
            // PDFファイルを生成して開く。
            ACChotarouXMLUtilities.openPDF(printer.getWriter());
            
        } finally {
            // ウェイティングフォームを終了する。
            if (splash != null) {
                splash.close();
                splash = null;
            }
        }

        // 2008/06/13 [Masahiko Higuchi] add - begin Version 5.4.1対応 利用者向け請求書印刷
        // 印刷対象チェックの画面描画処理を行う
        getInfoTable().revalidate();
        getInfoTable().repaint();
        // 2008/06/13 [Masahiko Higuchi] add - end
        
        // 印刷履歴確定確認メッセージを表示する。。
        // 「はい」が選択された場合
        if (QkanMessageList.getInstance().QP001_PRINT_COMMIT() == ACMessageBox.RESULT_OK) {
            // トランザクションを開始する。
            getDBManager().beginTransaction();
            // getSQL_GET_PATIENT(param);
            // SQL文を実行する。
            try {
                for(int i = 0; i < getPatientData().size(); i++){
                    VRMap map = (VRMap)getPatientData().get(i);
                    if (!"TRUE".equalsIgnoreCase(ACCastUtilities
                            .toString(VRBindPathParser.get("CHOISE", map)))){
                        continue;
                    }
                    
                    //印刷フラグ更新対象となるデータを取得する。
                    VRList printFlagList = getDBManager().executeQuery(getSQL_GET_UPDATE_TARGET_CLAIMSTATE(map));
                    
                    for(int j = 0; j < printFlagList.size(); j++){
                        VRMap printFlag = (VRMap)printFlagList.get(j);
                        printFlag.put("PRINT",QkanClaimStateFormat.getPrintedCode(getAffair(),printFlag.get("CLAIM_FINISH_FLAG")));
                        printFlag.put("PROVIDER_ID",QkanSystemInformation.getInstance().getLoginProviderID());
                        //印刷履歴の更新用のSQL文を取得する。
                        //SQL文を実行する。
                        getDBManager().executeUpdate(getSQL_GET_UPDATE_CLAIMSTATE(printFlag));
                    }
                    
                    //フラグを印刷済に変更
                    map.put("PRINT",QkanClaimStateFormat.getPrintedCode(getAffair(),map.get("PRINT")));
                }

                // 更新が成功した場合、コミットを実行する。
                getDBManager().commitTransaction();
            } catch (Exception sqlEx) {
                // 更新が失敗した場合、ロールバックを実行する。
                getDBManager().rollbackTransaction();
            }

        }

        

        //テーブルの再描画を行う
        getInfoTable().repaint();

        //インスタンスを破棄
//        QP001Manager.dispose();
    }
    
    /**
     * 「実績集計処理」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void commitActionPerformed(ActionEvent e) throws Exception {
        // 入力チェックを行う。
        if (!checkSelect("集計", "実績を確定・集計")) {
            return;
        }

        // 実績集計を行なう。
        doTotal();

    }

    /**
     * 「CSVファイル出力」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void csvOutActionPerformed(ActionEvent e) throws Exception {
        // 入力チェックを行なう。
        if (!checkSelect("選択", "CSVを出力")) {
            return;
        }
        
        // フォルダ選択画面(QP008)を表示する。
        QP008 qp008 = new QP008(this);
        qp008.setVisible(true);

    }
    private void setPrintInfoPanel() throws Exception {
        int[] printCount = new int[18];
        // 合計単位数
        int service_unit = 0;
        // 合計金額
        int service_total = 0;
        // 保険請求額
        int hoken = 0;
        // 利用者請求額
        int kouhi = 0;
        // 公費請求額
        int riyousya = 0;

        String choise;
        for (int i = 0; i < getPatientData().getDataSize(); i++) {
            choise = String.valueOf(VRBindPathParser.get("CHOISE",
                    (VRLinkedHashMap) getPatientData().get(i)));
            // 未選択の場合処理をスキップする。
            if (!"TRUE".equalsIgnoreCase(choise))
                continue;

            VRMap map = (VRMap) getPatientData().get(i);
            int claimStyleType = ACCastUtilities.toInt(VRBindPathParser.get(
                    "CLAIM_STYLE_TYPE", map),0);
            
            
            switch(claimStyleType){
                case QkanConstants.CLAIM_STYLE_BENEFIT_BILL:
                    printCount[1]++;
                    break;
                case QkanConstants.CLAIM_STYLE_FORMAT_2:
                case QkanConstants.CLAIM_STYLE_FORMAT_2_2:
                    printCount[2]++;
                    printCount[1] = 1;
                    break;
                case QkanConstants.CLAIM_STYLE_FORMAT_3:
                case QkanConstants.CLAIM_STYLE_FORMAT_3_2:
                    printCount[3]++;
                    printCount[1] = 1;
                    break;
                case QkanConstants.CLAIM_STYLE_FORMAT_4:
                case QkanConstants.CLAIM_STYLE_FORMAT_4_2:
                    printCount[4]++;
                    printCount[1] = 1;
                    break;
                case QkanConstants.CLAIM_STYLE_FORMAT_5:
                case QkanConstants.CLAIM_STYLE_FORMAT_5_2:
                    printCount[5]++;
                    printCount[1] = 1;
                    break;
                case QkanConstants.CLAIM_STYLE_FORMAT_6:
                case QkanConstants.CLAIM_STYLE_FORMAT_6_2:
                case QkanConstants.CLAIM_STYLE_FORMAT_6_3:
                case QkanConstants.CLAIM_STYLE_FORMAT_6_4:
                case QkanConstants.CLAIM_STYLE_FORMAT_6_5:
                case QkanConstants.CLAIM_STYLE_FORMAT_6_6:
                    printCount[6]++;
                    printCount[1] = 1;
                    break;
                case QkanConstants.CLAIM_STYLE_FORMAT_7:
                //[ID:0000476][Shin Fujihara] 2009/04 add begin 平成21年4月法改正対応
                //既存障害　様式第七の二を選択しても、帳票枚数がカウントアップされない
                case QkanConstants.CLAIM_STYLE_FORMAT_7_2:
                //[ID:0000476][Shin Fujihara] 2009/04 add end 平成21年4月法改正対応
                    printCount[7]++;
                    printCount[1] = 1;
                    break;
                case QkanConstants.CLAIM_STYLE_FORMAT_8:
                    printCount[8]++;
                    printCount[1] = 1;
                    break;
                case QkanConstants.CLAIM_STYLE_FORMAT_9:
                    printCount[9]++;
                    printCount[1] = 1;
                    break;
                case QkanConstants.CLAIM_STYLE_FORMAT_10:
                    printCount[10]++;
                    printCount[1] = 1;
                    break;
                case QkanConstants.CLAIM_STYLE_BENEFIT_SUMMARY:
                case QkanConstants.CLAIM_STYLE_BENEFIT_MANAGEMENT:
                    printCount[11]++;
                    break;
                case QkanConstants.CLAIM_STYLE_VISIT_DETAILED_SOCIAL_INSURANCE:
                    printCount[13]++;
                    printCount[15] = 1;
                    break;
                case QkanConstants.CLAIM_STYLE_VISIT_DETAILE_NATIONAL_INSURANCE:
                    printCount[13]++;
                    printCount[16] = 1;
                    break;
                case QkanConstants.CLAIM_STYLE_VISIT_BILL_SOCIAL_INSURANCE:
                    printCount[15]++;
                    printCount[16] = 1;
                    break;
                case QkanConstants.CLAIM_STYLE_VISIT_BILL_NATIONAL_INSURANCE:
                    printCount[16]++;
                    break;
            }
            //利用表の枚数
            printCount[17]++;
    
            if (!ACTextUtilities.isNullText(VRBindPathParser.get(
                    "SERVICE_UNIT", map))) {
                // 合計単位数
                service_unit += ACCastUtilities.toDouble(VRBindPathParser.get(
                        "SERVICE_UNIT", map));
            }

            if (!ACTextUtilities.isNullText(VRBindPathParser.get(
                    "SERVICE_TOTAL", map))) {
                // 合計金額
                service_total += ACCastUtilities.toDouble(VRBindPathParser.get(
                        "SERVICE_TOTAL", map));
            }

            if (!ACTextUtilities.isNullText(VRBindPathParser.get("HOKEN", map))) {
                // 保険請求額
                hoken += ACCastUtilities.toDouble(VRBindPathParser.get("HOKEN",
                        map));
            }

            if (!ACTextUtilities.isNullText(VRBindPathParser.get("KOUHI", map))) {
                // 利用者請求額
                kouhi += ACCastUtilities.toDouble(VRBindPathParser.get("KOUHI",
                        map));
            }

            if (!ACTextUtilities.isNullText(VRBindPathParser.get("RIYOUSYA",
                    map))) {
                // 公費請求額
                riyousya += ACCastUtilities.toDouble(VRBindPathParser.get(
                        "RIYOUSYA", map));
            }

        }

        getNursingCount().setText(ACCastUtilities.toString(printCount[1]));
        getType2Count().setText(ACCastUtilities.toString(printCount[2]));
        getType3Count().setText(ACCastUtilities.toString(printCount[3]));
        getType4Count().setText(ACCastUtilities.toString(printCount[4]));
        getType5Count().setText(ACCastUtilities.toString(printCount[5]));
        getType6Count().setText(ACCastUtilities.toString(printCount[6]));
        getType7Count().setText(ACCastUtilities.toString(printCount[7]));
        getType8Count().setText(ACCastUtilities.toString(printCount[8]));
        getType9Count().setText(ACCastUtilities.toString(printCount[9]));
        getType10Count().setText(ACCastUtilities.toString(printCount[10]));
        getSupplyCount().setText(ACCastUtilities.toString(printCount[11]));
        getVisitCount().setText(ACCastUtilities.toString(printCount[13]));
        
        getSyahoCount().setText(ACCastUtilities.toString(printCount[15]));
        getKokuhoCount().setText(ACCastUtilities.toString(printCount[16]));
        getServiceCount().setText(ACCastUtilities.toString(printCount[17]));

        getTotalDenominationText().setText(NumberFormat.getInstance().format(service_unit));
        getTotalMoneyText().setText(NumberFormat.getInstance().format(service_total));
        getDemandMoneyInsuranceMoneyText().setText(
                NumberFormat.getInstance().format(hoken));
        getDemandMoneyPatientMoneyText().setText(
                NumberFormat.getInstance().format(riyousya));
        getTotalDenominationPublicExpenseMoneyText().setText(
                NumberFormat.getInstance().format(kouhi));

    }

    /**
     * 「保険者名称コンボボックス選択時の処理」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void insurerNoConboActionPerformed(ActionEvent e)
            throws Exception {
        // 選択されたコンボのインデックス
        int index = getInsurerNoConbo().getSelectedIndex();

        if (index < 0)
            return;

        // 退避している保険者情報から保険者IDを取得する。
        String insureNo = (String) ((VRMap) getInsureData().getData(index))
                .get("INSURER_ID");
        if (insureNo == null)
            return;

        // 画面上に設定する。
        getInsurerNoText().setText(insureNo);
    }

    // 内部関数

    /**
     * 「検索条件の取得」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public void doFind() throws Exception {
        ACSplashable splash = ACFrame.getInstance().getFrameEventProcesser().createSplash("検索結果");

        // SQL文取得関数に渡すVRHashMap paramを生成する。
        VRMap param = new VRHashMap();
        
        //SQL文生成クラスに渡すパラメータを設定する。
        setSQLParams(param);

        // 検索用SQL文を取得する。
        String query = getSQL_GET_PATIENT(param);

        // 取得したSQL文を発行し、結果をpatientDataに格納する。
        setPatientData(getDBManager().executeQuery(query));

        //取得したデータを表示用に加工する。
        editSelectData(param);

        // 画面の「利用者一覧(infoTable)」に、patientDataを設定する。
        getPatientTableModel().setAdaptee(getPatientData());
        
        getStatusBar().setText(getPatientData().size() + " 件抽出されました。");

        // patientDataの件数が0件より多い場合
        if (getPatientData().size() > 0) {
            // 画面の「利用者一覧(infoTable)」の1行目を選択する。
            // 先頭行を選択状態に
            getPatientTableModel().setAdaptee(getPatientData());
            getInfoTable().setSelectedModelRow(
                    ((VRSortableTableModelar) getInfoTable().getModel())
                            .getReverseTranslateIndex(0));
            getInfoTable().requestFocus();
            
            //業務ボタンの状態を変更する。
            setButtonState();
            
        } else {
            // patientDataの件数が0件の場合
            // 画面の「利用者一覧(infoTable)」の行は未選択とする。
            // 業務ボタンの状態を変更する。
            setState_UNSELECTED();
        }

        if (!"01".equals(getAffair())) {
            setPrintInfoPanel();
        }

        // パッシブデータをクリアする。
        getPassiveChecker().clearReservedPassive();

        // パッシブデータを登録する。
        getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY(), getPatientData());

        if(splash!=null){
            splash.close();
            splash = null;
        }
        
        //[ID:0000455][Shin Fujihara] 2009/02 add begin 平成21年4月法改正対応
        //40件以上プランを作成している人が存在するかチェック
        checkOver40Plan();
        //[ID:0000455][Shin Fujihara] 2009/02 add end 平成21年4月法改正対応
    }
    
    //[ID:0000455][Shin Fujihara] 2009/02 add begin 平成21年4月法改正対応
    /**
     * 40件以上プランを作成している人が存在するかチェックする
     * @throws Exception
     */
    private void checkOver40Plan() throws Exception {
        
    	VRMap optionParam = new VRHashMap();
    	optionParam.put("START", VRDateParser.format(getTargetDate().getDate(), "yyyy/MM/dd"));
    	optionParam.put("END", VRDateParser.format(ACDateUtilities.toLastDayOfMonth(getTargetDate().getDate()), "yyyy/MM/dd"));
    	
    	//テーブルのプレフィックスは年ではなく、年度で判定
    	//optionParam.put("YEAR", VRDateParser.format(getTargetDate().getDate(), "yyyy"));
    	optionParam.put("YEAR", VRDateParser.format(ACDateUtilities.addMonth(getTargetDate().getDate(), -3), "yyyy"));
    	
    	String query = getSQL_MAKE_OVER_40_PLAN_STAFF(optionParam);
    	
    	VRList over40list = null;
    	
    	try {
    		over40list = getDBManager().executeQuery(query);
    	} catch (Exception e) {
    		//データの存在しない未来日検索時、必ずエラーになる。
    		//オマケ機能なので、エラーは無視する
    		VRLogger.warning(e);
    	}
    	
    	//件数0件の場合は処理中断
		if ((over40list == null) || (over40list.size() == 0)) {
			return;
		}
		
		StringBuilder msg = new StringBuilder();
		for (int i = 0; i < over40list.size(); i++){
			VRMap map = (VRMap)over40list.get(i);
			msg.append(map.get("CARE_MANAGER_NO"));
			msg.append("：");
			msg.append(QkanCommon.toFullName(map.get("STAFF_FAMILY_NAME"),map.get("STAFF_FIRST_NAME")));
			msg.append("\n");
		}
		
		//警告メッセージを表示する
		QkanMessageList.getInstance().QP001_WARNING_OVER_40_PLAN(msg.toString());
    	
    }
    //[ID:0000455][Shin Fujihara] 2009/02 add end 平成21年4月法改正対応
    
    /**
     * SQL文生成クラスに送るパラメータを設定する。
     * @param param
     * @throws Exception
     */
    private void setSQLParams(VRMap param) throws Exception {

        // 画面の「対象年月(targetDate)」に入力された日付を、「yyyyMMdd」形式の数値に変換する。
        param.put("TARGET_DATE_VALUE", VRDateParser.format(getTargetDate().getDate(), "yyyyMMdd"));

        // 画面の「未出力の利用者だけを表示(notOutputDistinction)」の値を取得する。
        // 選択されている場合(キーが含まれているか否かで判断)
        if (getNotOutputDistinction().isSelected()) {
            // paramに KEY : OUTPUT_FLG, VALUE : null を設定する。
            param.put("OUTPUT_FLG", null);
        }

        // 画面上の「利用者コード(patienCodeText)」のTextを取得し、全角スペースと半角スペースを抜いておく。
        // 取得した文字列が存在する場合(文字列長が0より大きい場合)
        if (!ACTextUtilities.isNullText(getPatientCodeText().getText())) {
            // 取得した文字列をparamの KEY : PATIENT_ID の VALUE として設定する。
            param.put("PATIENT_CODE", getPatientCodeText().getText());
        }

        if (!ACTextUtilities.isNullText(
                getPatientFuriganaText().getText())) {
            param.put("PATIENT_KANA", getPatientFuriganaText().getText());
        }

        // 画面上の国保処理月をyyyyMMdd型式で param の KEY : SEIKYU_DATE に設定する。
        param.put("SEIKYU_DATE", VRDateParser.format(getClaimDate().getDate(),
                "yyyyMMdd"));

        // 処理モードを追加する。
        param.put("AFFAIR", getAffair());
    }
    
    /**
     * 取得したデータを表示用に加工する。
     * @param param SQL発行に使用したパラメータ
     * @throws Exception
     */
    private void editSelectData(VRMap param) throws Exception {
        // 計画単位数格納用
        VRMap planMap = new VRHashMap();
        // サービス単位
        VRMap serviceUnitMap = new VRHashMap();
        // 合計金額
        VRMap serviceTotalMap = new VRHashMap();
        // 保険請求額
        VRMap hokenUnitMap = new VRHashMap();
        // 公費請求額
        VRMap kohiUnitMap = new VRHashMap();
        // 利用者負担額
        VRMap riyousyaUnitMap = new VRHashMap();
        // 請求テーブル情報
        VRMap claimMap = new VRHashMap();
        
        //保険区分
        VRMap insureTypeMap = new VRHashMap();
        
        //保険者の名称
        VRMap insurerMap = new VRHashMap();
        ACBindUtilities.setMapFromArray(QkanCommon.getInsurerInfo(getDBManager()), insurerMap, "INSURER_ID");
        
        //印刷済フラグ確認用
        int printed = (QkanClaimStateFormat.getPrintedCode(getAffair()) | QkanClaimStateFormat.getCSVOutCode(getAffair()));
        
        // 実績集計以外のモードであれば、個別データの取得を行う。
        if (!"01".equals(getAffair())) {
            if(getPatientData().size() > 0){
                try{
                    Date target = ACCastUtilities.toDate(((VRMap)getPatientData().get(0)).get("TARGET_DATE"));
                    param.put("TARGET_DATE_VALUE",target);
                } catch(Exception e){}

            }
            //テーブルが作成されていないことを考慮し、1テーブルずつtry-catch
            //計画単位数を取得する。
            try{
                ACBindUtilities.setMapFromArray(getDBManager().executeQuery(
                        getSQL_GET_PLAN_UNIT(param)), planMap, "CODE");
            } catch (Exception e){
                VRLogger.warning(e);
            }
            //サービス単位数を取得する。
            try{
                ACBindUtilities.setMapFromArray(getDBManager().executeQuery(
                        getSQL_GET_SERVICE_UNIT(param)), serviceUnitMap, "CODE");
            } catch(Exception e) {
                VRLogger.warning(e);
            }
            //サービス合計金額を取得する。
            try {
                ACBindUtilities.setMapFromArray(getDBManager().executeQuery(
                        getSQL_GET_SERVICE_TOTAL(param)), serviceTotalMap, "CODE");
            } catch(Exception e) {
                VRLogger.warning(e);
            }
            //保険請求額を取得する。
            try{
                ACBindUtilities.setMapFromArray(getDBManager().executeQuery(
                        getSQL_GET_HOKEN_UNIT(param)), hokenUnitMap, "CODE");
            } catch(Exception e) {
                VRLogger.warning(e);
            }
            //公費負担額を取得する。
            try{
                ACBindUtilities.setMapFromArray(getDBManager().executeQuery(
                        getSQL_GET_KOHI_UNIT(param)), kohiUnitMap, "CODE");
            } catch(Exception e) {
                VRLogger.warning(e);
            }
            //利用者負担額を取得する。
            try{
                ACBindUtilities.setMapFromArray(getDBManager().executeQuery(
                        getSQL_GET_RIYOUSYA_UNIT(param)), riyousyaUnitMap, "CODE");
            } catch(Exception e){
                VRLogger.warning(e);
            }
            
            //保険区分を取得する。
            try{
                ACBindUtilities.setMapFromArray(getDBManager().executeQuery(
                        getSQL_GET_INSURE_TYPE(param)), insureTypeMap, "CODE");
            } catch(Exception e){
                VRLogger.warning(e);
            }
        }
        //印刷済フラグの取得
        try{
            param.put("CLAIM_DATE",getClaimDate().getDate());
            ACBindUtilities.setMapFromArray(getDBManager().executeQuery(
                    getSQL_GET_CLAIM(param)), claimMap, "CODE");
        } catch(Exception e){
            VRLogger.warning(e);
        }

        // どうしてもSQLで絞れなかったので。
        // 保険者番号チェック
        boolean insurerCheck = !ACTextUtilities.isNullText(
                getInsurerNoText().getText());
        // 利用者かな氏名チェック
        boolean patientKanaCheck = !ACTextUtilities.isNullText(
                getPatientFuriganaText().getText());
        // 被保険者番号チェック
        boolean insureredCheck = !ACTextUtilities.isNullText(
                getInsuredNoText().getText());

        String insurer = getInsurerNoText().getText();
        String patient = getPatientFuriganaText().getText();
        String insurered = getInsuredNoText().getText();

        VRMap record = null;
        String comp = null;

        for (int i = getPatientData().getDataSize() - 1; i >= 0; i--) {
            record = (VRMap) getPatientData().getData(i);
            // 保険者番号チェックを行う。
            if (insurerCheck) {
                comp = String.valueOf(VRBindPathParser
                        .get("INSURER_ID", record));
                // DB取得文字列が検索対象文字列で始まっていなけれ、データを抜く
                if("06".equals(getAffair())){
                    if (!comp.endsWith(insurer)) {
                        getPatientData().removeData(i);
                        continue;
                    }
                } else {
                    if (!comp.startsWith(insurer)) {
                        getPatientData().removeData(i);
                        continue;
                    }
                }

            }
            // かな氏名チェックを行う。
            if (patientKanaCheck) {
//                comp = String.valueOf(VRBindPathParser.get("PATIENT_KANA",record));
                comp = QkanCommon.toFullName(record.get("PATIENT_FAMILY_KANA"),record.get("PATIENT_FIRST_KANA"));
                
                if (!comp.startsWith(patient)) {
                    getPatientData().removeData(i);
                    continue;
                }

            }
            // 被保険者番号チェック
            if (insureredCheck) {
                comp = String.valueOf(VRBindPathParser.get("INSURED_ID", record));
                if (!comp.startsWith(insurered)) {
                    getPatientData().removeData(i);
                    continue;
                }

            }
            
            //印刷済みフラグの確認と解決
            String printKey = ACCastUtilities.toString(VRBindPathParser.get("PATIENT_ID", record)) + "-"
                    + QkanSystemInformation.getInstance().getLoginProviderID() + "-";
                
                
            if("01".equals(getAffair())){
                printKey += VRDateParser.format(getTargetDate().getDate(),"yyyy-MM-dd");
            } else {
                //printKey += VRDateParser.format(getClaimDate().getDate(),"yyyy-MM-dd");
                printKey += VRDateParser.format(ACCastUtilities.toDate(VRBindPathParser.get("TARGET_DATE", record)),"yyyy-MM-dd");
                printKey += "-" + ACCastUtilities.toString(VRBindPathParser.get("INSURER_ID", record));
                printKey += "-" + ACCastUtilities.toString(VRBindPathParser.get("INSURED_ID", record));
            }
            
            if("01".equals(getAffair()) || "07".equals(getAffair()) || "08".equals(getAffair())){
                //全件検索系のオプション
            } else {
                //個別検索系のオプション
                printKey += "-" + ACCastUtilities.toString(VRBindPathParser.get("CLAIM_STYLE_TYPE", record));
            }
            
            if("01".equals(getAffair())){
            	//[ID:0000491][Shin Fujihara] 2009/07 edit begin 2009年度対応
                //if(claimMap.containsKey(printKey)){
            	if((claimMap.containsKey(printKey))
            			&& (((VRMap)claimMap.get(printKey)).get("CLAIM_FINISH_FLAG") != null)){
                //[ID:0000491][Shin Fujihara] 2009/07 edit end 2009年度対応
                    //未出力のチェック
                    if(getNotOutputDistinction().isSelected()){
                        getPatientData().removeData(i);
                        continue;
                    } else {
                        VRMap claimData = (VRMap)claimMap.get(printKey);
                        record.put("TARGET_DATE",claimData.get("TARGET_DATE"));
                        record.put("PRINT",claimData.get("CLAIM_FINISH_FLAG"));
                        record.put("CLAIM_DATE",claimData.get("CLAIM_DATE"));
                    }

                } else {
                    record.put("TARGET_DATE",null);
                    record.put("PRINT",null);
                }
                //次画面遷移に使用する請求年月日
                //record.put("CLAIM_DATE",getClaimDateUpdate().getDate());
                
            } else {
                if(claimMap.containsKey(printKey)){
                    VRMap claimData = (VRMap)claimMap.get(printKey);
                    //[ID:0000491][Shin Fujihara] 2009/07 edit begin 2009年度対応
                    //CLAIM_FINISH_FLAGがnullの場合は、未集計として扱う
                    if (claimData.get("CLAIM_FINISH_FLAG") == null){
                    	getPatientData().removeData(i);
                    	continue;
                    }
                    //[ID:0000491][Shin Fujihara] 2009/07 edit end 2009年度対応
                    //未出力のチェック
                    if(getNotOutputDistinction().isSelected()){
                        if((ACCastUtilities.toInt(claimData.get("CLAIM_FINISH_FLAG"),0) & printed) > 0 ){
                            getPatientData().removeData(i);
                            continue;
                        }
                    }
//                    record.put("TARGET_DATE",claimData.get("TARGET_DATE"));
                    record.put("PRINT",claimData.get("CLAIM_FINISH_FLAG"));
                } else {
                    //印刷フラグが取得できない場合はレコードを抜く
                    VRLogger.warning("印刷進捗フラグ取得エラー:" + record);
                    getPatientData().removeData(i);
                    continue;
                }
            }
            
            //保険者名称を解決
            String insurerId = ACCastUtilities.toString(record.get("INSURER_ID"));
            //取得した保険者番号が6桁以上(医療保険)の場合は、後半6桁を採用する。
            if(insurerId.length() > 6){
                insurerId = insurerId.substring(insurerId.length() - 6);
            }
            VRMap insureNameMap = (VRMap)insurerMap.get(insurerId);
            if(insureNameMap != null){
                record.put("INSURER_NAME", insureNameMap.get("INSURER_NAME"));
            }
            
            if (!"01".equals(getAffair())) {
                
                //単位数等、SQL文で取得できなかったデータをマッピング
                String key = ACCastUtilities.toString(VRBindPathParser.get("PATIENT_ID", record))
                        + "-"
                        + ACCastUtilities.toString(VRBindPathParser.get("INSURED_ID", record))
                        + "-"
                        + ACCastUtilities.toString(VRBindPathParser.get("CLAIM_STYLE_TYPE", record))
                        + "-"
                        + ACCastUtilities.toString(VRBindPathParser.get("TARGET_DATE", record));
                
                if(planMap.containsKey(key)){
                    record.put("PLAN_RATE", new Double(ACCastUtilities.toDouble(((VRMap)planMap.get(key)).get("UNIT"),0)));
                } else {
                    record.put("PLAN_RATE", new Double(0));
                }
                
                if(serviceUnitMap.containsKey(key)){
                    record.put("SERVICE_UNIT",new Double(ACCastUtilities.toDouble (((VRMap)serviceUnitMap.get(key)).get("UNIT"),0)));
                } else {
                    record.put("SERVICE_UNIT",new Double(0));
                }
                
                if(serviceTotalMap.containsKey(key)){
                    record.put("SERVICE_TOTAL",new Double(ACCastUtilities.toDouble(((VRMap)serviceTotalMap.get(key)).get("UNIT"),0)));
                } else {
                    record.put("SERVICE_TOTAL",new Double(0));
                }
                
                if(hokenUnitMap.containsKey(key)){
                    record.put("HOKEN",new Double(ACCastUtilities.toDouble (((VRMap)hokenUnitMap.get(key)).get("UNIT"),0)));
                } else {
                    record.put("HOKEN",new Double(0));
                }
                
                
                if(kohiUnitMap.containsKey(key)){
                    record.put("KOUHI",new Double(ACCastUtilities.toDouble (((VRMap)kohiUnitMap.get(key)).get("UNIT"),0)));
                } else {
                    record.put("KOUHI",new Double(0));
                }
                
                
                if(riyousyaUnitMap.containsKey(key)){
                    record.put("RIYOUSYA",new Double(ACCastUtilities.toDouble (((VRMap)riyousyaUnitMap.get(key)).get("UNIT"),0)));
                } else {
                    record.put("RIYOUSYA",new Double(0));
                }
                
                if(insureTypeMap.containsKey(key)){
                    record.put("INSURE_TYPE",((VRMap)insureTypeMap.get(key)).get("INSURE_TYPE"));
                }
            }
            
            //氏名、かな氏名を結合し表示用に変換する
            record.put("PATIENT_NAME",QkanCommon.toFullName(record.get("PATIENT_FAMILY_NAME"),record.get("PATIENT_FIRST_NAME")));
            record.put("PATIENT_KANA",QkanCommon.toFullName(record.get("PATIENT_FAMILY_KANA"),record.get("PATIENT_FIRST_KANA")));
            
            record.put("KUBUN","新規");
            record.put("CHOISE",new Boolean(false));
            record.put("DELETE",new Boolean(false));
        }
    }

    private void setButtonState() throws Exception {
        //選択列番号を取得
        int select = getInfoTable().getSelectedModelRow();
        //未選択であれば処理を中断
        if(select < 0){
            return;
        }
        //選択列のデータを取得
        VRMap map = (VRMap)getPatientData().get(select);
        
        //集計後の列が選択されていれば
        if(!ACTextUtilities.isNullText(map.get("PRINT"))){
            setState_SELECTED_CLAIM();
        } else {
            setState_SELECTED_NO_CLAIM();
        }
        
        if ("01".equals(getAffair())) {
            if(getPatientData() == null) return;
            String choise;
            for (int i = 0; i < getPatientData().getDataSize(); i++) {
                choise = String.valueOf(VRBindPathParser.get("DELETE",
                        (VRLinkedHashMap) getPatientData().get(i)));
                // 選択されていれば押下可能
                if ("TRUE".equalsIgnoreCase(choise)) {
                    getDelete().setEnabled(true);
                    return;
                }
            }
            getDelete().setEnabled(false);

        }
    }
    
    /**
     * 「実績データの取得」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public void doTotal() throws Exception {

        // 集計の確認メッセージを表示する。
        if (QkanMessageList.getInstance().QP001_CONFIRMATION_PRINT() == ACMessageBox.RESULT_CANCEL) {
            return;
        }
        // 処理中であることを示すウェイティングフォームを表示する。
        ACSplash splash = (ACSplash)ACFrame.getInstance().getFrameEventProcesser().createSplash("実績集計");

        // トランザクションを開始する。
        getDBManager().beginTransaction();

        // targetDateに検索対象月を設定する。
        getTargetDate().setDate( getTargetDate().getDate());

        // データマネージャの初期化
        QP001Manager manager = new QP001Manager(getDBManager(), getTargetDate().getDate());

        String choise;
        int patient_id;
        
        //[ID:0000561][Shin Fujihara] 2009/12/14 edit begin 2009年度対応
        //エラーの詳細表示対応に伴い、判定フラグを変更
        //boolean allCommit = true;
        QP001TotalErrors errors = new QP001TotalErrors();
        
        //サービス名称マスタの取得位置を変更
        setMasterServiceCache(QkanCommon.getMasterService(getDBManager(),getTargetDate().getDate()));
        //[ID:0000561][Shin Fujihara] 2009/12/14 edit end 2009年度対応

        try {
            // patientDataの件数分ループする。
            for (int i = 0; i < getPatientData().getDataSize(); i++) {
                VRMap map = (VRMap)getPatientData().get(i);
                
                choise = String.valueOf(VRBindPathParser.get("CHOISE",map));
                // 未選択の場合処理をスキップする。
                if (!"TRUE".equalsIgnoreCase(choise))
                    continue;

                // 利用者ID退避用にint patient_id を生成し、patientDataの KEY : PATIENT_ID
                // を設定する。
                patient_id = Integer.parseInt(String.valueOf(VRBindPathParser
                        .get("PATIENT_ID", map)));
                
                // 当月に申請中の履歴が存在する場合は集計処理を行わない。
                //[ID:0000561][Shin Fujihara] 2010/01 edit begin 2009年度対応
                //共通関数QkanCommon.isFullDecisionPatientInsureInfoでは
                //判定できないので、独自処理採用
                VRList patientHistory = QkanCommon.getPatientInsureInfoHistory(getDBManager(), getTargetDate().getDate(), patient_id);
                
        		if (patientHistory == null || patientHistory.size() < 1) {
                    map.put("PRINT",null);
                    map.put("TARGET_DATE", null);
                    errors.addOutOfTermError(map);
                    continue;
        		}

        		for (int j = 0; j < patientHistory.size(); j++) {
        			VRMap record = (VRMap) patientHistory.get(j);
        			int changeFlag = ACCastUtilities.toInt(record.get("CHANGE_CODE"), 1);
        			// 申請中の履歴があった場合はfalseを返す。
        			if (changeFlag == 1) {
                        map.put("PRINT",null);
                        map.put("TARGET_DATE", null);
                        errors.addApplyingError(map);
        				continue;
        			}
        		}
                //[ID:0000561][Shin Fujihara] 2010/01 edit end 2009年度対応
                
                // 利用者情報詳細取得用にVRArrayList patient を生成し、共通関数を使用して利用者情報詳細を取得する。
                VRMap patient = (VRLinkedHashMap) QkanCommon.getPatientInfo(
                        getDBManager(), patient_id).get(0);

                // 月次予定データ退避用の VRArrayList servicePlanList
                // 処理対象の利用者の検索月予定データを取得する。
                VRList servicePlanList = QkanCommon.getServiceDetail(
                        getDBManager(), patient_id, getTargetDate().getDate(),
                        QkanConstants.SERVICE_USE_TYPE_PLAN_MONTHLY_DAY.intValue());
                

                // 月次実績データ退避用の VRArrayList serviceDetailList
                // 処理対象の利用者の検索月実績データを取得する。
                VRList serviceDetailList = QkanCommon.getServiceDetail(
                        getDBManager(), patient_id, getTargetDate().getDate(),
                        QkanConstants.SERVICE_USE_TYPE_RESULT_MONTHLY_DAY.intValue());
                
                // 2008/01/07 [Masahiko Higuchi] add - begin 日割変換対応 (V5.4.1)
                // 変換クラスの生成
                QkanValidServiceCommon parser = new QkanValidServiceCommon();
                // 予定データコピー用
                VRList cloneServicePlanList = new VRArrayList();
                cloneServicePlanList.addAll(QkanValidServiceCommon.deepCopyVRList(servicePlanList));
                // 実績データコピー用
                VRList cloneServiceDetailList = new VRArrayList();
                cloneServiceDetailList.addAll(QkanValidServiceCommon.deepCopyVRList(serviceDetailList));
                
                servicePlanList = parser
                        .createValidService(getDBManager(), getTargetDate().getDate(),cloneServicePlanList,
                                patient_id);
                serviceDetailList = parser
                .createValidService(getDBManager(), getTargetDate().getDate(),cloneServiceDetailList,
                        patient_id);
                // 2008/01/07 [Masahiko Higuchi] add - end

                
                //サービス提供日で並び替え
                Collections.sort(serviceDetailList, new DateComparator());
                
                //[ID:0000561][Shin Fujihara] 2009/12/14 edit begin 2009年度対応
                //int result = doTotalDetail(patient, servicePlanList, serviceDetailList,manager);
                int result = doTotalDetail(patient, servicePlanList, serviceDetailList,manager, errors);
                //[ID:0000561][Shin Fujihara] 2009/12/14 edit end 2009年度対応
                
                // 介護保険分の実績集計を行なう。
                if(result == 0){
                    //集計済にフラグを変更する。
                    map.put("PRINT","0");
                    map.put("TARGET_DATE", getTargetDate().getDate());
                    map.put("CLAIM_DATE", getClaimDateUpdate().getDate());
                } else if(result == 1){
                    //集計済にフラグを変更する。
                    map.put("PRINT","0");
                    map.put("TARGET_DATE", getTargetDate().getDate());
                    map.put("CLAIM_DATE", getClaimDateUpdate().getDate());
                    //[ID:0000561][Shin Fujihara] 2009/12/14 delete begin 2009年度対応
                    //allCommit = false;
                    //[ID:0000561][Shin Fujihara] 2009/12/14 delete end 2009年度対応
                } else if(result == 2){
                    //集計に失敗した場合は、表示を消去する。
                    map.put("PRINT",null);
                    map.put("TARGET_DATE", null);
                    //[ID:0000561][Shin Fujihara] 2009/12/14 delete begin 2009年度対応
                    //allCommit = false;
                    //[ID:0000561][Shin Fujihara] 2009/12/14 delete end 2009年度対応
                }
            }

            // トランザクションを終了する。
            getDBManager().commitTransaction();

        } catch (Exception e) {
            getDBManager().rollbackTransaction();
            throw e;

        } finally {
            // ウェイティングフォームを終了する。
            if (splash != null) {
                splash.close();
                splash = null;
            }
        }
        
        //集計できない情報が存在する場合、メッセージを表示する。
        //[ID:0000561][Shin Fujihara] 2009/12/14 edit begin 2009年度対応
        //if(!allCommit){
        //	QkanMessageList.getInstance().QP001_ERROR_OF_NURSING_NECESSARY_LEVEL();
        if (errors.hasError()) {
        	errors.show();
        }
        //[ID:0000561][Shin Fujihara] 2009/12/14 edit end 2009年度対応
        
        // 集計が終了したことを示すメッセージを表示する。
        QkanMessageList.getInstance().QP001_INSERT_SUCCESSED();
        //テーブルの再描画を行う
        getInfoTable().repaint();
        //ボタンの表示を変更
        setButtonState();
        
    }

    /**
     * 「事業者毎の実績集計」に関する処理を行ないます。
     * 
     * @return 0:正常終了 1:不正なサービスコードを得たが、登録は実行 2:サービスコード不正で登録も未実行
     * @throws Exception
     *             処理例外
     */
    public int doTotalDetail(VRMap patient, VRList servicePlanList,
            VRList serviceDetailList,QP001Manager manager, QP001TotalErrors errors) throws Exception {
        
        //集計結果報告用
        int update = 0;
        
        // 様式データ格納用
        VRMap styles = new VRHashMap();
        String serial = "";
        boolean firstRecord = false;
        
        // 実績データ
        VRMap serviceDetail = null;
        // サービスコード集合
        List serviceCodeList = null;
        // サービスコード
        VRMap serviceCode = null;
        // 様式判別オブジェクト
        VRMap checkType = null;
        
        // 実績画面で入力された計画単位数
        VRMap planUnitMap = null;
        
        // 提供日判定用
        QP001OfferCalc offerCalc = new QP001OfferCalc();
        
        // 利用者の情報を取得する。
        QP001PatientState patientState = new QP001PatientState(getDBManager(), patient, getTargetDate().getDate());
        
        //サービスコード生成ロジックのキャッシュをクリアする。
        Qkan10011_ServiceCodeManager.getInstance().clearServiceCodeCache();

        // 月次予定データ分ループする
        for(int i = 0; i < servicePlanList.size(); i++){
            serviceDetail = (VRMap)servicePlanList.get(i);
            // サービス情報退避用のVRArrayList serviceCode を生成し、
            // 実績データからサービス情報を取得する。
            //[H20.4 法改正対応] fujihara edit start
            Qkan10011_ServiceUnitGetter ug = Qkan10011_ServiceCodeManager.getInstance()
                    .getService(
                            String.valueOf(VRBindPathParser
                                    .get("SYSTEM_SERVICE_KIND_DETAIL",
                                            serviceDetail)),getTargetDate().getDate());
            //[H20.4 法改正対応] fujihara edit end
            
            //サービスコード取得部品がNULLで帰ってきたら、処理をスキップする。
            if(ug == null){
                VRLogger.info("患者ID:" + patientState.getPatientId() + "　予定データのサービスコード取得に失敗しました。");
                continue;
            }
            
            // サービス実施日を設定
            ug.setSysYmd(ACCastUtilities.toDate(VRBindPathParser.get("SERVICE_DATE", serviceDetail)));
            
            String jotaiCode = patientState.getJotaiCode(VRBindPathParser.get("SERVICE_DATE",serviceDetail));
            //要介護度のチェック
            if(ACTextUtilities.isNullText(jotaiCode) || "1".equals(jotaiCode)){
                continue;
            }

            // 要介護度
            VRBindPathParser.set("1", serviceDetail, patientState.getJotaiCode(VRBindPathParser.get("SERVICE_DATE",serviceDetail)));
            // 特別地域加算
            VRBindPathParser.set("2", serviceDetail, manager
                    .getSpecialAreaFlag(
                            ACCastUtilities.toString(VRBindPathParser.get(
                                    "PROVIDER_ID", serviceDetail))));
            
            //特定入所者
            VRBindPathParser.set("7",serviceDetail,patientState.getShisetsuData("TOKUTEI_NYUSHO_FLAG"));
            
            //旧措置入所者
            if(!serviceDetail.containsKey("8")){
                VRBindPathParser.set("8",serviceDetail,patientState.getShisetsuData("KYUSOCHI_FLAG"));
            }
            
            //中山間地域
            VRBindPathParser.set("13",serviceDetail, manager.getChusankanChiikiCode(serviceDetail));
            
            //[ID:0000682][Shin Fujihara] add begin 【法改正対応】介護職員処遇改善加算
            VRBindPathParser.set(Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, serviceDetail, manager.getSyoguFlag(serviceDetail));
            //[ID:0000682][Shin Fujihara] add end 【法改正対応】介護職員処遇改善加算
            
            if(!isProcessingTotal(patientState, serviceDetail)){
                continue;
            }

            // サービスコードを取得する
            serviceCodeList = ug.getServiceCode(serviceDetail, getDBManager());
            
            boolean first = true;
            // サービス情報分ループする。
            for (int j = 0; j < serviceCodeList.size(); j++) {
                serviceCode = (VRMap) serviceCodeList.get(j);
                
                //サービスコード取得チェック
                if((serviceCode == null) || (serviceCode.size() == 0)){
                    continue;
                }
                
                QP001Style11 style11 = null;
                serial = QP001Style11.getSerialId(getTargetDate().getDate(), serviceDetail,patientState);
                
                if (!styles.containsKey(serial)) {
                    style11 = new QP001Style11();
                    styles.put(serial, style11);
                } else {
                    style11 = (QP001Style11) styles.getData(serial);
                }
                
                //2007.2.8 fujihara.shin 夜間訪問型の障害対応
                first = style11.parse(serviceDetail, getTargetDate().getDate(), patientState,
                        serviceCode,first,manager);
                
                //first = false;
            }
        }
        
        // 一旦、予定データの確定を行う
        Iterator<String> it = styles.keySet().iterator();
        while (it.hasNext()) {
            ((QP001Style11) styles.getData(it.next())).commitRecords();
        }
        
        
        // 月次実績データ分ループする。
        for (int i = 0; i < serviceDetailList.getDataSize(); i++) {
            // サービス毎の実績データ退避用の VRHashMap serviceDetail
            // を生成し、データを退避する。
            serviceDetail = (VRMap) serviceDetailList.getData(i);
            
            //実績データがログイン事業所のものであるか確認する。
            if(!QkanSystemInformation.getInstance().getLoginProviderID().equals(String.valueOf(serviceDetail.get("PROVIDER_ID")))){
                continue;
            }
            
            //計画単位数を事業所ごとに保持するよう変更
            //実績登録画面で入力された計画単位数のデータであるか確認
            if(ACCastUtilities.toString(serviceDetail.get("SYSTEM_SERVICE_KIND_DETAIL"),"").equals("1")){
                planUnitMap = serviceDetail;
                continue;
            }

            // サービス情報退避用のVRArrayList serviceCode を生成し、
            // 実績データからサービス情報を取得する。
            //[H20.4 法改正対応] fujihara edit start
            Qkan10011_ServiceUnitGetter ug = Qkan10011_ServiceCodeManager.getInstance()
                    .getService(
                            String.valueOf(VRBindPathParser
                                    .get("SYSTEM_SERVICE_KIND_DETAIL",
                                            serviceDetail)),getTargetDate().getDate());
            //[H20.4 法改正対応] fujihara edit end
            
            //サービスコード取得部品がNULLで帰ってきたら、次の集計を行う
            if(ug == null){
                continue;
            }
            
            String jotaiCode = patientState.getJotaiCode(VRBindPathParser.get("SERVICE_DATE",serviceDetail));
            //要介護度のチェック
            if(ACTextUtilities.isNullText(jotaiCode) || "1".equals(jotaiCode)){
            	//[ID:0000561][Shin Fujihara] 2010/01 edit begin 2009年度対応
            	errors.addOutOfTermError(patient);
            	//[ID:0000561][Shin Fujihara] 2010/01 edit end 2009年度対応
                continue;
            }
            
            // サービス実施日を設定
            ug.setSysYmd(ACCastUtilities.toDate(VRBindPathParser.get(
                    "SERVICE_DATE", serviceDetail)));

            // 要介護度
            VRBindPathParser.set("1", serviceDetail, patientState
                    .getJotaiCode(VRBindPathParser.get("SERVICE_DATE",
                            serviceDetail)));
            
            // 特別地域加算
            VRBindPathParser.set("2", serviceDetail, manager
                    .getSpecialAreaFlag(
                            ACCastUtilities.toString(VRBindPathParser.get(
                                    "PROVIDER_ID", serviceDetail))));
            
            //特定入所者
            VRBindPathParser.set("7",serviceDetail,patientState.getShisetsuData("TOKUTEI_NYUSHO_FLAG"));
            
            //旧措置入所者
            if(!serviceDetail.containsKey("8")){
                VRBindPathParser.set("8",serviceDetail,patientState.getShisetsuData("KYUSOCHI_FLAG"));
            }
            
            //中山間地域
            VRBindPathParser.set("13",serviceDetail, manager.getChusankanChiikiCode(serviceDetail));
            
            //[ID:0000682][Shin Fujihara] add begin 【法改正対応】介護職員処遇改善加算
            VRBindPathParser.set(Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, serviceDetail, manager.getSyoguFlag(serviceDetail));
            //[ID:0000682][Shin Fujihara] add end 【法改正対応】介護職員処遇改善加算
            
            if(!isProcessingTotal(patientState, serviceDetail)){
                continue;
            }

            // サービスコードを取得する
            serviceCodeList = ug.getServiceCode(serviceDetail, getDBManager());

            firstRecord = true;
            
            //サービスコードの変換を行う。
            if(!serviceCodeConvert(serviceCodeList,manager,serviceDetail)){
                update = 1;
                //[ID:0000561][Shin Fujihara] 2009/12/14 add begin 2009年度対応
                errors.addServiceError(patient, serviceDetail, getMasterServiceCache());
                //[ID:0000561][Shin Fujihara] 2009/12/14 add end 2009年度対応
                continue;
            }
            
            // サービス情報分ループする。
            lbl:for (int j = 0; j < serviceCodeList.size(); j++) {
                serviceCode = (VRMap) serviceCodeList.get(j);
                
                //サービスコード取得チェック
                if((serviceCode == null) || (serviceCode.size() == 0)){
                	//[ID:0000561][Shin Fujihara] 2009/12/14 add begin 2009年度対応
                	errors.addServiceError(patient, serviceDetail, getMasterServiceCache());
                	//[ID:0000561][Shin Fujihara] 2009/12/14 add end 2009年度対応
                    continue;
                }

                // 様式判別データ退避用の VRArrayList checkType を生成し、サービス様式情報を取得する。
                //[ID:0000561][Shin Fujihara] 2009/12/14 edit begin 2009年度対応
                //キャッシュしたサービス名称マスタから名称を取得するように変更
                //checkType = (VRMap)QkanCommon.getMasterService(getDBManager(),getTargetDate().getDate()).get(new Integer(String.valueOf(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL"))));
                checkType = (VRMap)getMasterServiceCache().get(new Integer(String.valueOf(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL"))));
                //[ID:0000561][Shin Fujihara] 2009/12/14 edit end 2009年度対応

                int type = ACCastUtilities.toInt(VRBindPathParser.get("CLAIM_STYLE_TYPE", checkType));
                
                switch(type){
                    //(様式第2)の場合
                    case QkanConstants.CLAIM_STYLE_FORMAT_2:
                    case QkanConstants.CLAIM_STYLE_FORMAT_2_2:
                        QP001Style2 style2 = null;
                        serial = QP001Style2.getSerialId(getTargetDate().getDate(), serviceDetail,
                                patientState,type);
                        if (!styles.containsKey(serial)) {
                            style2 = new QP001Style2(type,manager);
                            styles.put(serial, style2);
                        } else {
                            style2 = (QP001Style2) styles.getData(serial);
                        }
                        // 様式第二の解析
                        style2.parse(serviceDetail, getTargetDate().getDate(), patientState,
                                serviceCode);
                        break;
                        
                    //(様式第3)の場合
                    case QkanConstants.CLAIM_STYLE_FORMAT_3:
                    case QkanConstants.CLAIM_STYLE_FORMAT_3_2:
                        QP001Style3 style3 = null;
                        serial = QP001Style3.getSerialId(getTargetDate().getDate(), serviceDetail,
                                patientState,type);
                        if (!styles.containsKey(serial)) {
                            style3 = new QP001Style3(type,manager);
                            styles.put(serial, style3);
                        } else {
                            style3 = (QP001Style3) styles.getData(serial);
                        }
                        // 様式第三の解析
                        style3.parse(serviceDetail, getTargetDate().getDate(), patientState,
                                serviceCode);
                        break;
                    
                    //(様式第4)の場合
                    case QkanConstants.CLAIM_STYLE_FORMAT_4:
                    case QkanConstants.CLAIM_STYLE_FORMAT_4_2:
                        QP001Style4 style4 = null;
                        serial = QP001Style4.getSerialId(getTargetDate().getDate(), serviceDetail,
                                patientState,type);
                        if (!styles.containsKey(serial)) {
                            style4 = new QP001Style4(type,manager);
                            styles.put(serial, style4);
                        } else {
                            style4 = (QP001Style4) styles.getData(serial);
                        }
                        // 様式第四の解析
                        //[H20.5 法改正対応] fujihara edit start
//                        style4.parse(serviceDetail, getTargetDate().getDate(), patientState,
//                                serviceCode);
                        style4.parse(serviceDetail, getTargetDate().getDate(), patientState,
                                serviceCode,firstRecord);
                        //[H20.5 法改正対応] fujihara edit end
                        break;
                        
                    //(様式第5)の場合
                    case QkanConstants.CLAIM_STYLE_FORMAT_5:
                    case QkanConstants.CLAIM_STYLE_FORMAT_5_2:
                        QP001Style5 style5 = null;
                        serial = QP001Style5.getSerialId(getTargetDate().getDate(), serviceDetail,
                                patientState,type);
                        if (!styles.containsKey(serial)) {
                            style5 = new QP001Style5(type,manager);
                            styles.put(serial, style5);
                        } else {
                            style5 = (QP001Style5) styles.getData(serial);
                        }
                        // 様式第五の解析
                        style5.parse(serviceDetail, getTargetDate().getDate(), patientState,
                                serviceCode,firstRecord);
                        break;
                    
                    //(様式第6)の場合
                    case QkanConstants.CLAIM_STYLE_FORMAT_6:
                    case QkanConstants.CLAIM_STYLE_FORMAT_6_2:
                    case QkanConstants.CLAIM_STYLE_FORMAT_6_3:
                    case QkanConstants.CLAIM_STYLE_FORMAT_6_4:
                    case QkanConstants.CLAIM_STYLE_FORMAT_6_5:
                    case QkanConstants.CLAIM_STYLE_FORMAT_6_6:
                    case QkanConstants.CLAIM_STYLE_FORMAT_6_7:
                        QP001Style6 style6 = null;
                        serial = QP001Style6.getSerialId(getTargetDate().getDate(), serviceDetail,
                                patientState,type);
                        if (!styles.containsKey(serial)) {
                            style6 = new QP001Style6(type,manager);
                            styles.put(serial, style6);
                        } else {
                            style6 = (QP001Style6) styles.getData(serial);
                        }
                        // 様式第六の解析
                        style6.parse(serviceDetail, getTargetDate().getDate(), patientState,
                                serviceCode);
                        break;
                        
                    //(様式題7)の場合
                    case QkanConstants.CLAIM_STYLE_FORMAT_7:
                    case QkanConstants.CLAIM_STYLE_FORMAT_7_2:
                        //例外処理
                        //様式第七の場合は、月末のサービスコードを取得する必要があるため、
                        //サービスコードを取得しなおす。
                        Date targetServiceDate = ACCastUtilities.toDate(VRBindPathParser.get("SERVICE_DATE", serviceDetail));
                        VRBindPathParser.set("1",
                                serviceDetail,
                                patientState.getNinteiDataLast(patientState.getInsurerId(targetServiceDate), patientState.getInsuredId(targetServiceDate),"JOTAI_CODE"));
                        List serviceCodeListTemp = ug.getServiceCode(serviceDetail, getDBManager());
                        if((serviceCodeListTemp == null) || (serviceCodeListTemp.size() == 0)){
                            break;
                        }
                        //[ID:0000447][Shin Fujihara] 2009/02 delete begin 平成21年4月法改正対応
                        //serviceCode = (VRMap) serviceCodeListTemp.get(0);
                        //[ID:0000447][Shin Fujihara] 2009/02 delete end 平成21年4月法改正対応
                        
                        QP001Style7 style7 = null;
                        //[H20.4 法改正対応] fujihara edit start
                        if (styles.containsKey(QP001Style7.getSerialId(type,getTargetDate().getDate()))) {
                            style7 = (QP001Style7) styles.getData(QP001Style7.getSerialId(type,getTargetDate().getDate()));
                        } else {
                            style7 = new QP001Style7(type,manager);
                            styles.put(QP001Style7.getSerialId(type,getTargetDate().getDate()), style7);
                        }
                        //[H20.4 法改正対応] fujihara edit end
                        
                        //[ID:0000447][Shin Fujihara] 2009/02 edit begin 平成21年4月法改正対応
                        for (int k = 0; k < serviceCodeListTemp.size(); k++) {
                            serviceCode = (VRMap) serviceCodeListTemp.get(k);
                            style7.parse(serviceDetail, getTargetDate().getDate(), patientState,
                                    serviceCode,manager);
                        }
                        break lbl;
                        //[ID:0000447][Shin Fujihara] 2009/02 edit end 平成21年4月法改正対応
                        
                    //(様式第8)の場合
                    case QkanConstants.CLAIM_STYLE_FORMAT_8:
                        QP001Style8 style8 = null;
                        serial = QP001Style8.getSerialId(getTargetDate().getDate(), serviceDetail,
                                patientState,type);
                        if (!styles.containsKey(serial)) {
                            style8 = new QP001Style8(type,manager);
                            styles.put(serial, style8);
                        } else {
                            style8 = (QP001Style8) styles.getData(serial);
                        }
                        // 様式第八の解析
                        style8.parse(serviceDetail, getTargetDate().getDate(), patientState,
                                serviceCode);
                        break;
                        
                    //(様式第9)の場合
                    case QkanConstants.CLAIM_STYLE_FORMAT_9:
                        QP001Style9 style9 = null;
                        serial = QP001Style9.getSerialId(getTargetDate().getDate(), serviceDetail,
                                patientState,type);
                        if (!styles.containsKey(serial)) {
                            style9 = new QP001Style9(type,manager);
                            styles.put(serial, style9);
                        } else {
                            style9 = (QP001Style9) styles.getData(serial);
                        }
                        // 様式第九の解析
                        //[H20.5 法改正対応] fujihara edit start
//                        style9.parse(serviceDetail, getTargetDate().getDate(), patientState,
//                                serviceCode);
                        style9.parse(serviceDetail, getTargetDate().getDate(), patientState,
                                serviceCode,firstRecord);
                        //[H20.5 法改正対応] fujihara edit end
                        break;
                        
                    //10(様式第10)の場合
                    case QkanConstants.CLAIM_STYLE_FORMAT_10:
                        QP001Style10 style10 = null;
                        serial = QP001Style10.getSerialId(getTargetDate().getDate(),
                                serviceDetail, patientState,type);
                        if (!styles.containsKey(serial)) {
                            style10 = new QP001Style10(type,manager);
                            styles.put(serial, style10);
                        } else {
                            style10 = (QP001Style10) styles.getData(serial);
                        }
                        // 様式第十の解析
                        style10.parse(serviceDetail, getTargetDate().getDate(), patientState,
                                serviceCode,firstRecord);
                        break;
                        
                }
                //[ID:0000435][Shin Fujihara] 2009/07 add begin 2009年度対応
                offerCalc.analize(serviceDetail, serviceCode);
                //[ID:0000435][Shin Fujihara] 2009/07 add end 2009年度対応
                firstRecord = false;
            }
            
            //給付管理票に支援専門員番号の設定を行う
            serial = QP001Style11.getSerialId(getTargetDate().getDate(), serviceDetail,patientState);
            if (styles.containsKey(serial)) {
                QP001Style11 style11 = (QP001Style11) styles.getData(serial);
                style11.parse(serviceDetail);
            }
        }

        // データの確定を行う
        it = styles.keySet().iterator();
        while (it.hasNext()) {
            
            QP001StyleAbstract commitData = (QP001StyleAbstract) styles.getData(it.next());
            if(commitData instanceof QP001Style2){
                //様式第二の場合、不要なレコードがないか確認する。
                ((QP001Style2)commitData).arrangement();
            }
            commitData.commitRecords(patientState,styles,planUnitMap);
        }
        
        // データの登録実行
        it = styles.keySet().iterator();
        VRList updateList = new VRArrayList();
        while (it.hasNext()) {
            QP001StyleAbstract updateData = (QP001StyleAbstract) styles.getData(it.next());
            //給付管理データの場合
            if(updateData instanceof QP001Style11){
                //請求元事業所番号とログイン事業所番号が等しくなければ更新処理を行わない。
                if(!QkanSystemInformation.getInstance().getLoginProviderID().equals(((QP001Style11)updateData).getProviderId())){
                    continue;
                }
            //[ID:0000561][Shin Fujihara] 2010/01 edit begin 2009年度対応
            //様式第七データの場合
            } else if (updateData instanceof QP001Style7) {
            	VRList updateListTemp = updateData.getRecords(patientState.getPatientId(), getClaimDateUpdate().getDate()); 
            	if (updateListTemp.size() == 0){
            		errors.addSelfPlanStyle7(patient);
            	} else {
            		updateList.addAll(updateListTemp);
            	}
            	continue;
            }
            //[ID:0000561][Shin Fujihara] 2010/01 edit end 2009年度対応
            updateList.addAll(updateData.getRecords(patientState.getPatientId(), getClaimDateUpdate().getDate()));
        }
        
        //[ID:0000491][Shin Fujihara] 2009/07 add begin 2009年度対応
        QP001InformationProcessing hold = new QP001InformationProcessing(getDBManager(), patientState, getTargetDate().getDate());
        hold.reflect(updateList);
        hold = null;
        //[ID:0000491][Shin Fujihara] 2009/07 add end 2009年度対応
        
        QkanCommon.updateClaimDetail(getDBManager(), updateList, getTargetDate().getDate(),
                patientState.getPatientId(),QkanSystemInformation.getInstance().getLoginProviderID());
        
        
        // 2008/01/07 [Masahiko Higuchi] add - begin 全額自己負担分の算出処理
        //[ID:0000435][Shin Fujihara] 2009/07 edit begin 2009年度対応
        //doTotalDetailPatientSelf(updateList,manager,patientState);
        
        //[ID:0000612][Shin Fujihara] 2010/11 edit begin 2010年度対応
        //サービス種類ごとに利用者への請求書・領収書発行対応
        //重複する処理内容もあるが、既存処理はそのまま残し、新たなロジックを作成する。
        
        if (isServiceByReceipt()){
        	//新規処理(提供したサービス種類ごとに、CLAIM_PATIENT_DETAILへレコードを作成)
        	doTotalDetailPatientSelfService(updateList,manager,patientState, offerCalc);
        	
        } else {
        	//既存処理
            doTotalDetailPatientSelf(updateList,manager,patientState, offerCalc);
            
        }
        offerCalc = null;
        
        //[ID:0000612][Shin Fujihara] 2010/11 edit end 2010年度対応
        
        //[ID:0000435][Shin Fujihara] 2009/07 edit end 2009年度対応
        // 2008/01/07 [Masahiko Higuchi] add - end
        
        if((updateList == null) || (updateList.size() <= 0)){
            update = 2;
        }
        
        return update;
    }
    
    // add sta 2006.05.20 fujihara.shin
    
    // 2008/01/07 [Masahiko Higuchi] add - begin 全額自己負担自動集計機能
    /**
     * 小数点以下を考慮した厳密な額を返します
     * 
     * @author Masahiko Higuchi
     * @since Ver 5.4.1
     */
    protected int get_701015Multiplies100(double _701015) {
        BigDecimal temp = new BigDecimal(String.valueOf(_701015));
        temp = temp.multiply(new BigDecimal("100"));
        return temp.intValue();
    }
    // 2008/01/07 [Masahiko Higuchi] add - end
    
    /**
     * 集計を行ってよいかの判断を行う。
     * @param patientState
     * @param serviceDetail
     * @return
     * @throws Exception
     */
    private boolean isProcessingTotal(QP001PatientState patientState, VRMap serviceDetail) throws Exception {
        
        Date targetDate = ACCastUtilities.toDate(VRBindPathParser.get("SERVICE_DATE", serviceDetail));
        
        //生保単独者でなければ、処理の続行を許可する
        if(!QP001SpecialCase.isSeihoOnly(patientState.getInsuredId(targetDate))){
            return true;
        }
        
        //対象日の公費一覧を取得
        VRList list = patientState.getKohiData(targetDate,1,ACCastUtilities.toString(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL", serviceDetail)));
        
        //公費がついていない場合は、処理を中断する
        if((list == null) || (list.size() == 0)){
            return false;
        }
        
        for(int i = 0; i < list.size(); i++){
            VRMap map = (VRMap)list.get(i);
            if(map != null){
                String kohi = ACCastUtilities.toString(map.get("KOHI_LAW_NO"));
                if("12".equals(kohi)){
                    return true;
                }
            }
        }
        
        return false;
    }
    // add end 2006.05.20 fujihara.shin
    
    /**
     * サービスコードの変換を行う。
     * @param serviceCode
     * @return true:コンバート成功 false:コンバート失敗（加算のみのチェックが無いのに、加算のみのレコードで構成されているetc）
     * @throws Exception
     */
    private boolean serviceCodeConvert(List serviceCodeList,QP001Manager manager, VRMap serviceDetail) throws Exception {
        
        // H24.04 特別地域加算、中山間地域加算の計算方法を改善
        
        boolean result = false;
        Integer unit = null;
        VRMap addMap = null;
        VRMap chusanAddMap = null;
        VRMap unitMap = new VRHashMap();
        
        for (int j = 0; j < serviceCodeList.size(); j++) {
            VRMap serviceCode = (VRMap) serviceCodeList.get(j);
            
            //本体報酬であれば、単位数を退避
            if (ACCastUtilities.toInt(serviceCode.get("SERVICE_MAIN_FLAG"),0) == 1) {
                
                //キーの最後に
                String key = String.valueOf(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL")) + "-"
                + String.valueOf(serviceCode.get("SYSTEM_SERVICE_CODE_ITEM")) + "-"
                + String.valueOf(serviceCode.get("TOTAL_GROUPING_TYPE"));
                
                unit = new Integer(manager.getServiceUnit(String.valueOf(serviceDetail.get("PROVIDER_ID")),serviceCode));
                unitMap.put(key,unit);
                result = true;
                continue;
            }
            
            switch(ACCastUtilities.toInt(serviceCode.get("SERVICE_ADD_FLAG"),0)){
            case 1: //通常請求
                result = true;
                break;
            case 3: //特別地域加算
                addMap = (VRMap) serviceCodeList.get(j);
                break;
            case 6: //中山間地域加算
            	chusanAddMap = (VRMap) serviceCodeList.get(j);
            	break;
            }
        }
        
        if(addMap != null){
            addMap.put("SERVICE_UNIT_MAP",unitMap);
        }
        
        if (chusanAddMap != null) {
        	chusanAddMap.put("SERVICE_UNIT_MAP",unitMap);
        	if(addMap != null){
        		chusanAddMap.put("SERVICE_UNIT_ADD_MAP",addMap);
        	}
        }
        
        if(!result){
            //加算のみのチェックを確認
            if(serviceDetail.containsKey("9")){
                if(ACCastUtilities.toInt(serviceDetail.get("9"),0) == 2){
                    result = true;
                }
            }
        }
        
        return result;
    }

    /**
     * 「検索条件のチェック」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public boolean checkFind() throws Exception {
        // 検索日付未入力チェック
        if (ACTextUtilities.isNullText(getTargetDate().getText())) {
            QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT("対象年月");
            getTargetDate().requestFocus();
            return false;
        }
        // 検索日付妥当性チェック
        if (!getTargetDate().isValidDate()) {
            QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("対象年月の");
            getTargetDate().requestFocus();
            return false;
        }

        // 請求年月日未入力チェック
        if (ACTextUtilities.isNullText(getClaimDateUpdate().getText())) {
            QkanMessageList.getInstance()
                    .ERROR_OF_NEED_CHECK_FOR_INPUT("請求年月日");
            getClaimDateUpdate().requestFocus();
            return false;
        }
        // 請求日付妥当性チェック
        if (!getClaimDateUpdate().isValidDate()) {
            QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("請求年月日の");
            getClaimDateUpdate().requestFocus();
            return false;
        }
        
        //検索用請求年月日未入力チェック
        if (ACTextUtilities.isNullText(getClaimDate().getText())) {
            QkanMessageList.getInstance()
                    .ERROR_OF_NEED_CHECK_FOR_INPUT("請求年月日");
            getClaimDate().requestFocus();
            return false;
        }
        
        //検索用請求年月日妥当性チェック
        if (!getClaimDate().isValidDate()) {
            QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("請求年月日の");
            getClaimDate().requestFocus();
            return false;
        }

        return true;

    }

    /**
     * 「利用者選択の確認」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public boolean checkSelect(String fieldName, String processName) throws Exception {
        // 検索日付未入力チェック
        if (ACTextUtilities.isNullText(getTargetDate().getText())) {
            QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT("対象年月");
            getTargetDate().requestFocus();
            return false;
        }
        // 検索日付妥当性チェック
        if (!getTargetDate().isValidDate()) {
            QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("対象年月の");
            getTargetDate().requestFocus();
            return false;
        }

        // 請求年月日未入力チェック
        if (ACTextUtilities.isNullText(getClaimDateUpdate().getText())) {
            QkanMessageList.getInstance()
                    .ERROR_OF_NEED_CHECK_FOR_INPUT("請求年月日");
            getClaimDateUpdate().requestFocus();
            return false;
        }
        // 請求日付妥当性チェック
        if (!getClaimDateUpdate().isValidDate()) {
            QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("請求年月日の");
            getClaimDateUpdate().requestFocus();
            return false;
        }
        
        // [ID:0000599][Shin Fujihara] 2010/11 edit begin 2010年度対応
        // 対象年月と請求年月の妥当性チェック
        //[ID:0000727][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 edit begin
        // 実績集計の時のみチェックを行うよう修正
        //if (ACDateUtilities.getDifferenceOnMonth(getClaimDateUpdate().getDate(), getTargetDate().getDate()) <= 0) {
        if ("01".equals(getAffair()) && ACDateUtilities.getDifferenceOnMonth(getClaimDateUpdate().getDate(), getTargetDate().getDate()) <= 0) {
        //[ID:0000727][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 edit end
        	//[ID:0000629]実績集計のメッセージ表示等について追加
        	String targetMonth = getTargetDate().getText();
        	String claimMonthUsually = VRDateParser.format(ACDateUtilities.addMonth(getTargetDate().getDate(), 1), "ggge年M月");
        	
            if (QkanMessageList.getInstance().QP001_WARNING_CLAIMDATE_COMP(
            		targetMonth,
            		claimMonthUsually) == ACMessageBox.RESULT_CANCEL) {
            	return false;
            }
        }
        // [ID:0000599][Shin Fujihara] 2010/11 edit end 2010年度対応
        
        
        String choise;
        boolean select = false;
        // patientDataの件数分ループする。
        for (int i = 0; i < getPatientData().getDataSize(); i++) {
            choise = String.valueOf(VRBindPathParser.get("CHOISE",
                    (VRLinkedHashMap) getPatientData().get(i)));
            if ("TRUE".equalsIgnoreCase(choise)) {
                select = true;
                break;
            }
        }
        if (!select) {
            if (QkanMessageList.getInstance().QP001_WARGNING_TOTAL(fieldName,processName) == ACMessageBox.RESULT_CANCEL) {
                return false;
            }
            // 全選択
            allSelectActionPerformed(null);
        }
        return true;
    }


    /**
     * 「CSVファイルの作成」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public String makeCSV(VRMap settings) throws Exception {
        String result = "";
        // 処理中であることを示すウェイティングフォームを表示する。
        ACSplash splash = (ACSplash)ACFrame.getInstance().getFrameEventProcesser().createSplash("CSVデータ");
        
        try{
            QP001Manager manager = new QP001Manager(getDBManager(), getTargetDate().getDate());
            result = creator.create(getDBManager(),getAffair(),getPatientData(),getClaimDate().getDate(),settings,QkanSystemInformation.getInstance().getSystemDate(),manager);
        } finally {
            // ウェイティングフォームを終了する。
            if (splash != null) {
                splash.close();
                splash = null;
            }
        }
        
        // 2006/08/28 add begin kamitsukasa
        // 訪問看護療養費領収書対応
        if(result == null){
            return null;
        }
        // 2006/08/28 add end kamitsukasa
        
        
        // CSV履歴確定確認メッセージを表示する。
        if(QkanMessageList.getInstance().QP001_CSV_COMMIT() == ACMessageBox.RESULT_OK){
            splash = (ACSplash)ACFrame.getInstance().getFrameEventProcesser().createSplash("フラグ更新処理");
            //「はい」が選択された場合
            try{
                //トランザクションを開始する。
                getDBManager().beginTransaction();
                
                for(int i = 0; i < getPatientData().size(); i++){
                    VRMap map = (VRMap)getPatientData().get(i);
                    if (!"TRUE".equalsIgnoreCase(ACCastUtilities
                            .toString(VRBindPathParser.get("CHOISE", map)))){
                        continue;
                    }
                    
                    //印刷フラグ更新対象となるデータを取得する。
                    VRList printFlagList = getDBManager().executeQuery(getSQL_GET_UPDATE_TARGET_CLAIMSTATE(map));
                    
                    
                    for(int j = 0; j < printFlagList.size(); j++){
                        VRMap printFlag = (VRMap)printFlagList.get(j);
                        printFlag.put("PRINT",QkanClaimStateFormat.getCSVOutCode(getAffair(),printFlag.get("CLAIM_FINISH_FLAG")));
                        printFlag.put("PROVIDER_ID",QkanSystemInformation.getInstance().getLoginProviderID());
                        //印刷履歴の更新用のSQL文を取得する。
                        //SQL文を実行する。
                        getDBManager().executeUpdate(getSQL_GET_UPDATE_CLAIMSTATE(printFlag));
                    }
                    
                    //フラグをCSVに変更
                    map.put("PRINT",QkanClaimStateFormat.getCSVOutCode(getAffair(),map.get("PRINT")));
                    
                }
                
                //更新が成功した場合
                //コミットを実行する。
                getDBManager().commitTransaction();
            } catch(Exception e){
                //更新が失敗した場合
                //ロールバックを実行する。
                getDBManager().rollbackTransaction();
                
                throw e;
            } finally {
                // ウェイティングフォームを終了する。
                if (splash != null) {
                    splash.close();
                    splash = null;
                }
            }
            
        }
        
        //テーブルの再描画を行う
        getInfoTable().repaint();
        
        return result;
    }
    
    public static void main(String[] args) {
        VRMap param = new VRHashMap();

        /*
        Object[] selection = { "01", "02", "03", "04", "05", "06", "07"};
        Object answer = JOptionPane.showInputDialog(null, "起動モードを選択", "モード選択",
                JOptionPane.QUESTION_MESSAGE, null, selection, selection[6]);

        if (answer == null) {
            System.exit(0);
            return;
        }
        */ 
        
        Object answer = "07";
        //モードを設定
        param.setData("AFFAIR", answer);
        //ログイン日付を設定(暫定的に本日日付)
        QkanSystemInformation.getInstance().setSystemDate(new Date());
        //デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        QkanSystemInformation.getInstance().setLoginProviderID("0000000001");
        ACFrame.debugStart(new ACAffairInfo(QP001.class.getName(), param));
    }
    /**
     * 「テーブル選択時の処理」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void infoTableSelectionChanged(MouseEvent e) throws Exception {
        
        setButtonState();

//      if ("01".equals(getAffair())) {
//      if(getPatientData() == null) return;
//          String choise;
//          for (int i = 0; i < getPatientData().getDataSize(); i++) {
//              choise = String.valueOf(VRBindPathParser.get("DELETE",
//                  (VRLinkedHashMap) getPatientData().get(i)));
//              // 選択されていれば押下可能
//              if ("TRUE".equalsIgnoreCase(choise)) {
//                  getDelete().setEnabled(true);
//                  return;
//              }
//          }
//          getDelete().setEnabled(false);
//
//      } else if ("02".equals(getAffair())) {
        if ("02".equals(getAffair())) {
            setPrintInfoPanel();
        } else if ("03".equals(getAffair())) {
            setPrintInfoPanel();
        } else if ("04".equals(getAffair())) {
            setPrintInfoPanel();
        } else if ("05".equals(getAffair())) {
            setPrintInfoPanel();
        } else if ("06".equals(getAffair())) {
            setPrintInfoPanel();
        }
    }

    protected void insurerNoTextFocusLost(FocusEvent e) throws Exception {
        // TODO 自動生成されたメソッド・スタブ
        
    }

    

    protected void infoTableColumn3CheckMenuActionPerformed(ActionEvent e) throws Exception {
        infoTableSelectionChanged(null);
        
    }

    protected void infoTableColumn4CheckMenuActionPerformed(ActionEvent e) throws Exception {
        infoTableSelectionChanged(null);
    }
    
    /**
     * 日付で実績をソートする。
     */
    private class DateComparator implements java.util.Comparator {
        public int compare(Object object1, Object object2) {
            //日付で並び替えるクラス
            Date date1 = ACCastUtilities.toDate(((Map)object1).get("SERVICE_DATE"), null);
            Date date2 = ACCastUtilities.toDate(((Map)object2).get("SERVICE_DATE"), null);
            if(date1==null){
                if(date2==null){
                    return 0;
                }
                return -1;
            }else if(date2==null){
                return 1;
            }
            return date1.compareTo(date2);
        }
    }

    /**
     * 利用者向け請求書の全額自己負担分を算出します。
     * 
     * @param updateList 請求データ群
     * @param manager QP001Manager（管理クラス）
     * @param patientState　QP001PatientState（利用者情報管理クラス）
     * @throws Exception 処理例外
     * 
     * @author Masahiko Higuchi
     * @since Ver 5.4.1
     */
    //[ID:0000435][Shin Fujihara] 2009/07 edit begin 2009年度対応
    //利用者向け請求の仕様変更に伴い修正
    //※変更履歴のコメントが多すぎてソースが追えないので、削除しました。
    //履歴はソースコード管理ツールで参照してください。
    protected void doTotalDetailPatientSelf(VRList updateList,QP001Manager manager,QP001PatientState patientState, QP001OfferCalc offerCalc) throws Exception{
        
        //利用者向け請求書の作成処理
        // コミット、ロールバックは上位のdoTotalで行うため当メソッド内では行わず
        if(updateList == null){
        	return;
        }
        
        VRMap patientClaimMap = new VRHashMap();
        
        // 全額自己負担の計算
        // 計算結果は、引数のpatientClaimMapに挿入される
        boolean isCalcSelfPay = clacPatientSelf(updateList,patientClaimMap,manager,patientState);
        
        //利用者向け請求登録用データに、サービスの提供情報データをマージする
        offerCalc.marge(getDBManager(), getTargetDate().getDate(), patientClaimMap);
        
        VRMap sqlParam = new VRHashMap();
        Date targetDate = getTargetDate().getDate();
        Date claimDate = getClaimDateUpdate().getDate();
        
        VRBindPathParser.set("PATIENT_ID", sqlParam,new Integer(patientState.getPatientId()));
        VRBindPathParser.set("TARGET_DATE", sqlParam, targetDate);
        VRBindPathParser.set("CLAIM_DATE", sqlParam, claimDate);
        VRBindPathParser.set("PROVIDER_ID", sqlParam,QkanSystemInformation.getInstance().getLoginProviderID());
        VRBindPathParser.set("CLAIM_STYLE_TYPE", sqlParam, new Integer(QkanConstants.CLAIM_STYLE_BILL_FOR_PATIENT));
        VRBindPathParser.set("CATEGORY_NO", sqlParam,QkanConstants.CATEGORY_NO_BILL_FOR_PATIENT);
        
        // CLAIMテーブルにデータが存在するか(再集計であるか)チェックする。
        VRList claimCheckList = getDBManager().executeQuery(getSQL_GET_NEW_CLAIM_PATIENT_DETAIL(sqlParam));
        
        int claimId = 0;
        // 未登録の場合、CLAIMテーブルに親データを作成する
        if (claimCheckList.isEmpty()) {
            // 登録用のCLAIM_IDを取得する。
            claimId = QkanCommon.getBookingNumber(getDBManager(), "CLAIM", "CLAIM_ID", 1);
            VRMap claimInsertSqlParam = new VRHashMap();
            // 検索に使用したキー情報を全部足す
            claimInsertSqlParam.putAll(sqlParam);
            // 請求書番号
            claimInsertSqlParam.setData("CLAIM_ID", new Integer(claimId));
            // 被保険者番号
            claimInsertSqlParam.setData("INSURED_ID", patientState.getInsuredId(targetDate));
            // 保険者番号
            claimInsertSqlParam.setData("INSURER_ID", patientState.getInsurerId(targetDate));
            // 処理フラグ
            claimInsertSqlParam.setData("CLAIM_FINISH_FLAG", new Integer(0));
            // CLAIMテーブルにデータを作成する
            getDBManager().executeUpdate(getSQL_INSERT_CLAIM(claimInsertSqlParam));
            
        }else{
            VRMap claimData = (VRMap)claimCheckList.getData(0);
            claimId = ACCastUtilities.toInt(claimData.getData("CLAIM_ID"),0);
            //CLAIM.CLAIM_FINISH_FLAGを0でアップデート
            sqlParam.put("PRINT", "0");
            getDBManager().executeUpdate(getSQL_GET_UPDATE_CLAIMSTATE(sqlParam));
        }
        
        // CLAIM_IDの設定
        VRBindPathParser.set("CLAIM_ID",patientClaimMap,ACCastUtilities.toInteger(claimId));
        
        
        //[ID:0000612][Shin Fujihara] 2010/11 add begin 2010年度対応
        //モードが途中で変更されたことを考慮
        //一旦不要レコード('00'以外)を削除する
        /* FIXME [0000612]
        VRBindPathParser.set("MODE",patientClaimMap, "MULTI");
        getDBManager().executeUpdate(getSQL_GET_CLAIM_PATIENT_DETAIL_DELETE(patientClaimMap));
        */
        //[ID:0000612][Shin Fujihara] 2010/11 add end 2010年度対応
        
        
        // 利用者向け請求書データの存在チェック
        VRList claimPatientCheckList = getDBManager().executeQuery(getSQL_GET_CLAIM_PATIENT_TARGET_DATA_COUNT(patientClaimMap));

        if(claimPatientCheckList.isEmpty()){
            // CLAIM_PATIENT_DETAIL Insert処理
            getDBManager().executeUpdate(getSQL_INSERT_CLAIM_PATIENT_DETAIL_ONLY_SELF(patientClaimMap));
            
        }else{
            // CLAIM_PATIENT_DETAIL Update処理
            getDBManager().executeUpdate(getSQL_UPDATE_CLAIM_PATIENT_DETAIL_ONLY_SELF(patientClaimMap));
        }
        
        // 全額自己負担が発生していなければ処理終了
        if(!isCalcSelfPay){
        	return;
        }
        	
        // 全額自己負担が発生している場合は
        // 定型文登録処理を実行する
        VRMap fixedParam = new VRHashMap();
        VRList fixedList = new VRArrayList();
        for (int i = 1; i <= 3; i++) {
            // 全額自己負担対象の名称を取得する。
            String fixedKey = ACCastUtilities.toString(
            		patientClaimMap.get("SELF_SERVICE_NO" + ACCastUtilities.toString(i))
            		);
            // nullと空白の場合は無理
            if (ACTextUtilities.isNullText(fixedKey)) {
                continue;
            }
            fixedParam.setData("FIXED_FORM_ID", new Integer(1));
            fixedParam.setData("CONTENT", fixedKey);
            
            // 登録用のCONTENT_KEYを取得する
            fixedList = (VRList) getDBManager().executeQuery(getSQL_GET_COUNT_SELF_PAY(fixedParam));
            
            VRMap contentKeyMap = (VRMap) fixedList.getData(0);
            // 取得した件数が0件の場合
            if (ACCastUtilities.toInt(contentKeyMap.getData("CONTENT_SELF_PAY")) == 0) {
                fixedParam = new VRHashMap();
                // ・KEY：FIXED_FORM_ID VALUE：1
                fixedParam.setData("FIXED_FORM_ID", new Integer(1));
                // 登録に使用するCONTENT_KEYを取得するためのSQL文を取得する。
                // SQL文を実行する。
                fixedList = getDBManager().executeQuery(getSQL_GET_NEW_CONTENT_KEY(fixedParam));

                contentKeyMap = (VRMap) fixedList.getData(0);
                
                // 登録に使用するCONTENT_SORTを取得するためのSQL文を取得する。
                // SQL文を実行する。
                fixedList = getDBManager().executeQuery(getSQL_GET_NEW_CONTENT_SORT(fixedParam));
                
                VRMap contentSortMap = (VRMap) fixedList.getData(0);

                // paramを初期化し、以下のKEY/VALUEを設定する。
                // ・KEY：TABLE_TYPE VALUE：1
                // ・KEY：FIXED_FORM_ID VALUE：1
                // ・KEY：CONTENT_KEY VALUE：（取得した新たなCONTENT_KEY）
                // ・KEY：CONTENT VALUE：（選択候補）
                // ・KEY：CONTENT_SORT VALUE：（取得した新たなCONTENT_SORT）
                fixedParam = new VRHashMap();
                fixedParam.setData("TABLE_TYPE", new Integer(1));
                fixedParam.setData("FIXED_FORM_ID", new Integer(1));
                fixedParam.setData("CONTENT_KEY", contentKeyMap.getData("NEW_CONTENT_KEY"));
                fixedParam.setData("CONTENT", fixedKey);
                fixedParam.setData("CONTENT_SORT", contentSortMap.getData("NEW_CONTENT_SORT"));

                // 定型文登録用SQL文を取得する。
                // SQL文を実行する。
                getDBManager().executeUpdate(getSQL_INSERT_FIXED_FORM(fixedParam));
            }
        }
    }
    //[ID:0000435][Shin Fujihara] 2009/07 edit end 2009年度対応
    
    /**
     * 全額自己負担の計算処理
     * @param updateList 集計データ群
     * @param patientClaimMap 結果格納要変数
     * @param manager QP001Manager（管理クラス）
     * @param isDetailCalc 簡易版計算、詳細版計算判別要フラグ
     * @param patientState 利用者情報管理クラス
     * @return int 全額自己負担対象サービス数
     * 
     * @throws Exception 処理例外
     * @since 5.4.1 
     * @author Masahiko Higuchi
     */
    // 2008/09/03 [Masahiko Higuchi] replace - begin 全額自己負担計算式障害（V5.4.3） 引数にpatientStateを追加
    public boolean clacPatientSelf(VRList updateList,VRMap patientClaimMap,QP001Manager manager, QP001PatientState patientState)throws Exception{
    // 2008/09/03 [Masahiko Higuchi] replace - end
        // 空で値を生成しておく
        for(int i=1;i<=3;i++){
            patientClaimMap.setData("SELF_PAY_NO" + Integer.toString(i),null);
            patientClaimMap.setData("SELF_SERVICE_NO" + Integer.toString(i),"");
        }
        
        // 全額自己負担カウント用
        int serviceCount = 1;
        
        try{
            for(int i=0;i<updateList.size();i++){
                VRMap claimMap = new VRHashMap();
                claimMap = (VRMap)updateList.getData(i);
                // 701009   計画単位数6桁
                // 701010   限度額管理対象単位数6桁
                // 701015   単位数単価
                // 701007   サービス種類コード
                // 集計情報レコードである場合
                if (claimMap.getData("CATEGORY_NO") != null
                        && QkanConstants.CATEGORY_NO_RECORD_TOTAL.equals(claimMap
                                .getData("CATEGORY_NO"))) {
                    // 限度額管理対象単位数
                    int gendogakuTani = ACCastUtilities.toInt(claimMap.getData("701010"),0);
                    // 計画単位数
                    int keikakuTani = ACCastUtilities.toInt(claimMap.getData("701009"),0);
                    // 超過単位数
                    int overTani = gendogakuTani - keikakuTani;
                    // 2008/09/03 [Masahiko Higuchi] add - begin 全額自己負担計算式障害（V5.4.3）
                    // サービス種類コード
                    String serviceCodeKind = ACCastUtilities.toString(claimMap
                            .getData("701007"));
                    int over30Tani = patientState.getAbandonedUnit(serviceCodeKind);
                    
                    //[ID:0000682][Shin Fujihara] add begin 【法改正対応】介護職員処遇改善加算
                    overTani += patientState.getAddSelfpay(serviceCodeKind);
                    //[ID:0000682][Shin Fujihara] add end 【法改正対応】介護職員処遇改善加算
                    
                    // 2008/09/03 [Masahiko Higuchi] add - end
                    // 超過していない場合は次のループに
                    // 2008/09/03 [Masahiko Higuchi] replace - begin 全額自己負担計算式障害（V5.4.3）
                    // 30日超も比較時に考慮する
                    if(overTani + over30Tani <= 0){
                    // 2008/09/03 [Masahiko Higuchi] replace - end
                        continue;
                    }
                    // 2008/09/03 [Masahiko Higuchi] del - begin 全額自己負担計算式障害（V5.4.3）
                    /*
                    // 単位数調整前の総額
                    int gendogakuTotal = (int) Math
                    .floor((double) (gendogakuTani * get_701015Multiplies100(ACCastUtilities
                            .toDouble(claimMap.getData("701015")))) / 100d);
                    // 調整後単位数での総額
                    int tyoseiTotal = (int) Math
                    .floor((double) (keikakuTani * get_701015Multiplies100(ACCastUtilities
                            .toDouble(claimMap.getData("701015")))) / 100d);
                    // 調整前の総額から調整後の金額を引いた値を利用者の全額自己負担とする。
                    int zengakuJikofutan = gendogakuTotal - tyoseiTotal;
                     */
                    // 2008/09/03 [Masahiko Higuchi] del - end
                    // 2008/09/03 [Masahiko Higuchi] add - begin 全額自己負担計算式障害（V5.4.3）
                    // 超過分単位数 * 単位数単価（円未満切捨て）
                    int zengakuJikofutan = (int) Math
                            .floor((double) (overTani * get_701015Multiplies100(ACCastUtilities
                                    .toDouble(claimMap.getData("701015")))) / 100d);
                    // 30日超の金額は個別計算
                    int over30ZengakuJikofutan = (int) Math
                            .floor((double) (over30Tani * get_701015Multiplies100(ACCastUtilities
                                    .toDouble(claimMap.getData("701015")))) / 100d);
                    // 超過分の金額 + 30日超の金額を合算する
                    zengakuJikofutan += over30ZengakuJikofutan;
                    // 2008/09/03 [Masahiko Higuchi] add - end
                    
                    // 全額自己負担が3つを超えた場合の対応（マージ処理）
                    if(serviceCount >= 4){
                        // 合計する
                        zengakuJikofutan = ACCastUtilities
                                .toInt(patientClaimMap.getData("SELF_PAY_NO3"))
                                + zengakuJikofutan;
                        patientClaimMap.setData("SELF_SERVICE_NO3","その他");
                        // その他として合計値に変更する
                        patientClaimMap.setData("SELF_PAY_NO3",ACCastUtilities.toString(zengakuJikofutan));
                    }else{
                        // ★通常処理
                        // サービス種類コード
                        // 2008/09/03 [Masahiko Higuchi] del - begin 全額自己負担計算式障害（V5.4.3）
                        //String serviceCodeKind = ACCastUtilities.toString(claimMap
                        //        .getData("701007"));
                        // 2008/09/03 [Masahiko Higuchi] del - end
                        // サービス種類名称に翻訳して格納
                        patientClaimMap.setData("SELF_SERVICE_NO"
                                + ACCastUtilities.toString(serviceCount), manager
                                .getServiceName(serviceCodeKind));
                        // 全額自己負担を格納
                        patientClaimMap.setData("SELF_PAY_NO"
                                + ACCastUtilities.toString(serviceCount),ACCastUtilities.toString(zengakuJikofutan));
                    }
                    // 全額自己負担項目カウントアップ
                    serviceCount++;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
            
        }
        
        // 全額自己負担数を返却
        if(serviceCount >= 2){
            return true;
        }else{
            return false;
        }
    }
    
    
    //2009/1/6 fujihara add start
    private VRList getSortedTableList(){
    	VRList result = new VRArrayList();
    	VRList targetList = getPatientData();
    	
    	jp.nichicom.vr.component.table.VRSortableTableModel sorterModel;
    	//ソータであるかチェックする
    	if(getInfoTable().getModel() instanceof jp.nichicom.vr.component.table.VRSortableTableModel){
    		result = new VRArrayList();
    		sorterModel = (jp.nichicom.vr.component.table.VRSortableTableModel)getInfoTable().getModel();
    		for(int j=0; j < targetList.getDataSize(); j++){
    			//ソーターを利用してモデルから画面上の順にデータ格納しなおす
    			int row = sorterModel.getTranslateIndex(j);
    			//ソート順を並べ替える
    			result.add(getPatientTableModel().getData(row));
    		}
    	}
    	return result;
    }
    //2009/1/6 fujihara add end
    
    // [ID:0000614][Shin Fujihara] 2010/11 add begin 2010年度対応
    // 一覧印刷処理
	protected void printListActionPerformed(ActionEvent e) throws Exception {

		// 入力チェックを行う。
        if (!checkSelect("選択", "帳票を印刷")) {
            return;
        }
        
        // 印刷データ作成
        VRMap printParam = new VRHashMap();
        
        // フォーマット済みシステム日付を設定
        //VRBindPathParser.set("DATE", printParam, VRDateParser.format(QkanSystemInformation.getInstance().getSystemDate(), "ggge年MM月dd日"));
        VRBindPathParser.set("DATE", printParam, VRDateParser.format(new Date(), "ggge年MM月dd日"));
        
        //追加要望で、画面上に表示している合計単位数等も印字
        //合計単位数
        VRBindPathParser.set("SERVICE_UNIT", printParam, getTotalDenominationText().getText());
        //合計金額
        VRBindPathParser.set("SERVICE_TOTAL", printParam, getTotalMoneyText().getText());
        //保険請求額
        VRBindPathParser.set("HOKEN", printParam, getDemandMoneyInsuranceMoneyText().getText());
        //公費
        VRBindPathParser.set("KOUHI", printParam, getTotalDenominationPublicExpenseMoneyText().getText());
        //利用者
        VRBindPathParser.set("RIYOUSYA", printParam, getDemandMoneyPatientMoneyText().getText());
        
        int service_count = 0;
        
        // 表示順でリストを作る
        VRList sortedPatientList = getSortedTableList();
        VRList list = new VRArrayList();
        VRMap row = null;
        
        for (int i = 0; i < sortedPatientList.size(); i++) {
        	row = (VRMap)sortedPatientList.get(i);
        	
        	// チェックされている行であるか確認
        	if(ACCastUtilities.toBoolean(VRBindPathParser.get("CHOISE", row))){
        		list.add(row);
        		service_count++;
        	}
        }
        
        VRBindPathParser.set("LIST", printParam, list);
        
        //合計件数
        VRBindPathParser.set("SERVICE_COUNT", printParam, NumberFormat.getInstance().format(service_count));
        
        
        // ※印刷
        // 印刷する。
        QP001P300 qp001p083 = new QP001P300();
        ACChotarouXMLWriter writer = new ACChotarouXMLWriter();
        
        // 印刷開始を宣言
        writer.beginPrintEdit();
        
        // 印刷クラスへ処理を渡す。
        qp001p083.doPrint(writer, printParam);
        
        // 印刷終了を宣言
        writer.endPrintEdit();

        // PDFファイルを生成して開く。
        ACChotarouXMLUtilities.openPDF(writer);
	}
	// [ID:0000614][Shin Fujihara] 2010/11 add end 2010年度対応
	
	
	// [ID:0000612][Shin Fujihara] 2010/11 add begin 2010年度対応
    protected void doTotalDetailPatientSelfService(VRList updateList,QP001Manager manager,QP001PatientState patientState, QP001OfferCalc offerCalc) throws Exception{
        
        //利用者向け請求書の作成処理
        if(updateList == null){
        	return;
        }
        
        //CLAIM_PATIENT_DETAILへの登録に使用する枠を取得
        //※既に提供日等の情報は設定済みの状態。自己負担額を設定すればよい。
        VRList claimDetailList = offerCalc.getOfferServiceList(getDBManager(), getTargetDate().getDate());
        
        //作成後のレコードに対し、全額自己負担額を算出し設定する。
        VRList updateWordList = clacPatientSelfService(updateList, claimDetailList, manager, patientState);
        
        
        
        VRMap sqlParam = new VRHashMap();
        Date targetDate = getTargetDate().getDate();
        Date claimDate = getClaimDateUpdate().getDate();
        
        sqlParam.put("PATIENT_ID", new Integer(patientState.getPatientId()));
        sqlParam.put("TARGET_DATE", targetDate);
        sqlParam.put("CLAIM_DATE", claimDate);
        sqlParam.put("PROVIDER_ID", QkanSystemInformation.getInstance().getLoginProviderID());
        sqlParam.put("CLAIM_STYLE_TYPE", new Integer(QkanConstants.CLAIM_STYLE_BILL_FOR_PATIENT));
        sqlParam.put("CATEGORY_NO", QkanConstants.CATEGORY_NO_BILL_FOR_PATIENT);
        
        // CLAIMテーブルにデータが存在するか(再集計であるか)チェックする。
        VRList claimCheckList = getDBManager().executeQuery(getSQL_GET_NEW_CLAIM_PATIENT_DETAIL(sqlParam));
        int claimId = 0;
        // 未登録の場合、CLAIMテーブルに親データを作成する
        if (claimCheckList.isEmpty()) {
            // 登録用のCLAIM_IDを取得する。
            claimId = QkanCommon.getBookingNumber(getDBManager(), "CLAIM", "CLAIM_ID", 1);
            // 請求書番号
            sqlParam.put("CLAIM_ID", new Integer(claimId));
            // 被保険者番号
            sqlParam.put("INSURED_ID", patientState.getInsuredId(targetDate));
            // 保険者番号
            sqlParam.put("INSURER_ID", patientState.getInsurerId(targetDate));
            // 処理フラグ
            sqlParam.put("CLAIM_FINISH_FLAG", new Integer(0));
            // CLAIMテーブルにデータを作成する
            getDBManager().executeUpdate(getSQL_INSERT_CLAIM(sqlParam));
            
        }else{
            VRMap claimData = (VRMap)claimCheckList.getData(0);
            claimId = ACCastUtilities.toInt(claimData.getData("CLAIM_ID"), 0);
            //CLAIM.CLAIM_FINISH_FLAGを0でアップデート
            sqlParam.put("CLAIM_ID", new Integer(claimId));
            sqlParam.put("PRINT", "0");
            getDBManager().executeUpdate(getSQL_GET_UPDATE_CLAIMSTATE(sqlParam));
        }
        
        
        //一旦、不要レコードの削除
        sqlParam.put("MODE", "SINGLE");
        getDBManager().executeUpdate(getSQL_GET_CLAIM_PATIENT_DETAIL_DELETE(sqlParam));
        
        //登録済み情報の取得
        VRMap claimPatientCheckMap = new VRHashMap();
        VRList list = getDBManager().executeQuery(getSQL_GET_CLAIM_PATIENT_TARGET_DATA_KIND(sqlParam));
        ACBindUtilities.setMapFromArray(list, claimPatientCheckMap, "SERVICE_CODE_KIND");
        
        // 一行ずつアップデート・インサートを判定
        for (int i = 0; i < claimDetailList.size(); i++) {
        	VRMap map = (VRMap)claimDetailList.get(i);
        	map.put("CLAIM_ID", new Integer(claimId));
        	
        	// UPDATE
        	if (claimPatientCheckMap.containsKey(map.get("SERVICE_CODE_KIND"))) {
                // CLAIM_PATIENT_DETAIL Update処理
                getDBManager().executeUpdate(getSQL_UPDATE_CLAIM_PATIENT_DETAIL_ONLY_SELF(map));
        	
        	// INSERT
        	} else {
                // CLAIM_PATIENT_DETAIL Insert処理
                getDBManager().executeUpdate(getSQL_INSERT_CLAIM_PATIENT_DETAIL_ONLY_SELF(map));
                
        	}
        }
        
        // 全額自己負担として登録した文言を、定型分テーブルに登録
        VRMap fixedParam = new VRHashMap();
        VRList fixedList = new VRArrayList();
        
        fixedParam.put("FIXED_FORM_ID", new Integer(1));
        fixedParam.setData("TABLE_TYPE", new Integer(1));
        
        for (int i = 0; i < updateWordList.size(); i++) {
        	
            fixedParam.put("CONTENT", updateWordList.get(i));
            // 登録用のCONTENT_KEYを取得する
            fixedList = (VRList) getDBManager().executeQuery(getSQL_GET_COUNT_SELF_PAY(fixedParam));
            
            VRMap contentKeyMap = (VRMap) fixedList.getData(0);
            // 取得した件数が0件では場合は、既に登録済み
            if (ACCastUtilities.toInt(contentKeyMap.getData("CONTENT_SELF_PAY")) != 0) {
            	continue;
            }
            
            // 登録に使用するCONTENT_KEYを取得するためのSQL文を取得する。
            // SQL文を実行する。
            fixedList = getDBManager().executeQuery(getSQL_GET_NEW_CONTENT_KEY(fixedParam));
            contentKeyMap = (VRMap) fixedList.getData(0);
            
            // 登録に使用するCONTENT_SORTを取得するためのSQL文を取得する。
            // SQL文を実行する。
            fixedList = getDBManager().executeQuery(getSQL_GET_NEW_CONTENT_SORT(fixedParam));
            VRMap contentSortMap = (VRMap) fixedList.getData(0);
            
            fixedParam.setData("CONTENT_KEY", contentKeyMap.getData("NEW_CONTENT_KEY"));
            fixedParam.setData("CONTENT_SORT", contentSortMap.getData("NEW_CONTENT_SORT"));

            // 定型文登録用SQL文を取得する。
            // SQL文を実行する。
            getDBManager().executeUpdate(getSQL_INSERT_FIXED_FORM(fixedParam));
        }
    }
    
    
    public VRList clacPatientSelfService(
    		VRList updateList,
    		VRList claimDetailList,
    		QP001Manager manager,
    		QP001PatientState patientState) throws Exception{
    	
    	
    	
        // 全額自己負担算定フラグ
        VRList updateWordList = new VRArrayList();
    	
        lbl:for(int i=0;i<updateList.size();i++){
            VRMap claimMap = (VRMap)updateList.getData(i);
            /*
             701009   計画単位数6桁
             701010   限度額管理対象単位数6桁
             701015   単位数単価
             701007   サービス種類コード
            */
            
            // 集計情報レコード以外であれば、処理を行なわない
            if (!QkanConstants.CATEGORY_NO_RECORD_TOTAL.equals(claimMap.getData("CATEGORY_NO"))) {
            	continue;
            }
            
            // 限度額管理対象単位数
            int gendogakuTani = ACCastUtilities.toInt(claimMap.getData("701010"), 0);
            // 計画単位数
            int keikakuTani = ACCastUtilities.toInt(claimMap.getData("701009"), 0);
            // 超過単位数
            int overTani = gendogakuTani - keikakuTani;
            
            // サービス種類コード
            String serviceCodeKind = ACCastUtilities.toString(claimMap.getData("701007"));
            int over30Tani = patientState.getAbandonedUnit(serviceCodeKind);
            
            //[ID:0000682][Shin Fujihara] add begin 【法改正対応】介護職員処遇改善加算
            overTani += patientState.getAddSelfpay(serviceCodeKind);
            //[ID:0000682][Shin Fujihara] add end 【法改正対応】介護職員処遇改善加算
            
            // 30日超も比較時に考慮する
            if(overTani + over30Tani <= 0){
                continue;
            }
            
            double _701015 = get_701015Multiplies100(ACCastUtilities.toDouble(claimMap.getData("701015")));
            // 超過分単位数 * 単位数単価（円未満切捨て）
            int zengakuJikofutan = (int) Math.floor((double) (overTani * _701015) / 100d);
            // 30日超の金額は個別計算
            int over30ZengakuJikofutan = (int) Math.floor((double) (over30Tani * _701015) / 100d);
            // 超過分の金額 + 30日超の金額を合算する
            zengakuJikofutan += over30ZengakuJikofutan;
            
            
            VRMap targetMap = null;
            //対象となるマップを探す
            for (int j = 0; j < claimDetailList.size(); j++) {
            	targetMap = (VRMap)claimDetailList.get(j);
            	if (serviceCodeKind.equals(targetMap.get("SERVICE_CODE_KIND")) ){
            		break;
            	}
            	targetMap = null;
            }
            
            if (targetMap == null) {
            	continue;
            }
            
            //値を設定できる箇所を探す
            for (int j = 1; j <= 3; j++) {
            	if (targetMap.get("SELF_SERVICE_NO" + j) == null) {
            		targetMap.put("SELF_SERVICE_NO" + j, manager.getServiceName(serviceCodeKind));
            		targetMap.put("SELF_PAY_NO" + j, String.valueOf(zengakuJikofutan));
            		
            		updateWordList.add(manager.getServiceName(serviceCodeKind));
            		continue lbl;
            	}
            }
            
            //名称をその他に変更
            targetMap.setData("SELF_SERVICE_NO3", "その他");
            int etcSelfPay = ACCastUtilities.toInt(targetMap.get("SELF_PAY_NO3"), 0);
            targetMap.put("SELF_PAY_NO3", String.valueOf(etcSelfPay + zengakuJikofutan));
        }
        
        // 全額自己負担に登録した文言リストをリターン
        return updateWordList;
    }
	// [ID:0000612][Shin Fujihara] 2010/11 add end 2010年度対応
    
    // [ID:0000629][Shin Fujihara] 2011/02 add start 2010年度対応
    //請求年月を変更する(C)チェック変更時のイベント
	protected void claimDateChangePermitPerformed(ActionEvent e) throws Exception {
		if (getClaimDateUpdateChangePermit().isSelected()) {
			setState_CLAIM_DATE_ENABLE();
		} else {
			setState_CLAIM_DATE_DISABLE();
		}
	}
	// [ID:0000629][Shin Fujihara] 2011/02 add end 2010年度対応
	
}
