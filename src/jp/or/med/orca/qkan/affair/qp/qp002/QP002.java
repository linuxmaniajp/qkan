/*
 * Project code name "ORCA"
 * 給付管理台帳ソフト QKANCHO（JMA care benefit management software）
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
 * 開発者: 上司　和善
 * 作成日: 2006/02/17  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求データ作成 (P)
 * プロセス 確認・修正 (002)
 * プログラム 帳票(様式)・事業所選択 (QP002)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qp.qp002;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.calculation.QP001;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRLinkedHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.affair.qp.qp003.QP003;
import jp.or.med.orca.qkan.affair.qp.qp004.QP004;
import jp.or.med.orca.qkan.affair.qp.qp005.QP005;
import jp.or.med.orca.qkan.text.QkanClaimStyleFormat;
import jp.or.med.orca.qkan.text.QkanInsureTypeDivision;

/**
 * 帳票(様式)・事業所選択(QP002)
 */
public class QP002 extends QP002Event {

	/**
     * コンストラクタです。
     */
    public QP002() {
    }

    public void initAffair(ACAffairInfo affair) throws Exception {
        super.initAffair(affair);
        initAction(affair);
    }

    /**
     * 初期化処理を行ないます。
     * 
     * @param affair 業務情報
     * @throws Exception 処理例外
     */
    protected void initAction(ACAffairInfo affair) throws Exception {
        // 下記の渡りパラメータを退避する。
        VRMap parameters = affair.getParameters();
        
        // ・this.patientId KEY：PATIENT_ID
        if(VRBindPathParser.has("PATIENT_ID", parameters)){
        	setPatientId(ACCastUtilities.toInt(parameters.getData("PATIENT_ID")));
        }
        // ・this.claimDate KEY：CLAIM_DATE
        if(VRBindPathParser.has("CLAIM_DATE", parameters)){
        	setClaimDate(ACCastUtilities.toDate(parameters.getData("CLAIM_DATE")));
        }
        // ・this.listIndex KEY：LIST_INDEX
        if(VRBindPathParser.has("LIST_INDEX", parameters)){
        	setListIndex(ACCastUtilities.toInt(parameters.getData("LIST_INDEX")));
        }else{
        	setListIndex(-1);
        }
        
        // 業務情報マスタより、データを取得する。
        // QkanCommon.getAffairInfo(getDBManager(), "QP002");
        // 取得したデータのウィンドウタイトル（WINDOW_TITLE）をウィンドウに設定する。
        // 取得したデータの業務タイトル（AFFAIR_TITLE）を業務ボタンバーに設定する。
        setAffairTitle("QP002", getButtons());
        // 利用者基本情報を取得する。
        VRList patientList = QkanCommon.getPatientInfo(getDBManager(),
                getPatientId());
        VRMap patientMap = (VRMap) patientList.getData(0);
        // 取得した利用者基本情報の値を、this.sourceMapに設定する。
        // ・PATIENT_CODEを、KEY：PATIENT_CODEで設定する。
        // ・PATIENT_FAMILY_NAMEとPATIENT_FIRST_NAMEの文字列を結合し、KEY：PATIENT_NAMEで設定する。
        // toFullName();
        getSourceMap().setData("PATIENT_CODE",
                patientMap.getData("PATIENT_CODE"));
        getSourceMap().setData(
                "PATIENT_NAME",
                QkanCommon.toFullName(
                        patientMap.getData("PATIENT_FAMILY_NAME"), patientMap
                                .getData("PATIENT_FIRST_NAME")));
        // this.sourceMapを「クライアント領域（contents）」のソースとして設定する。
        // setSource(contents, sourceMap);
        getContents().setSource(getSourceMap());
        // 画面に展開する。
        // bindSource(contents);
        getContents().bindSource();

        doFind();

    }
    
    private void doFind() throws Exception {
        // 利用者の請求データを取得する。
        // SQLを取得するためのHashMap：paramを生成し、下記のKEY/VALUEを設定する。
        VRMap param = new VRHashMap();
        // ・KEY：PATIENT_ID VALUE：this.patientId
        // ・KEY：TARGET_DATE VALUE：this.targetDate
        // ・KEY：CLAIM_STYLE_TYPE VALUE：CLAIM_STYLE_TYPE
        // ・KEY：LOGIN_PROVIDER_ID VALUE：ログイン事業所番号
        param.setData("PATIENT_ID", new Integer(getPatientId()));
        param.setData("CLAIM_DATE", getClaimDate());
        param.setData("LOGIN_PROVIDER_ID", QkanSystemInformation.getInstance().getLoginProviderID());
        // 請求データを取得し、this.claimListに格納する。
        // getSql(GET_CLAIM, param);
        setClaimList(getDBManager().executeQuery(getSQL_GET_CLAIM(param)));
        

        // 取得したデータを画面表示用に編集する。
        editRecord();

        ACTableModelAdapter providerTableModel = new ACTableModelAdapter();
        String[] ada = { "NO", "DELETE", "TARGET_DATE", "INSURER_ID", "UNIT_INSURED_ID" 
                        , "PROVIDER_ID", "PROVIDER_NAME", "INSURED_ID", "CLAIM_STYLE_TYPE"};
        
        getProviderTableColumn6().setFormat(QkanClaimStyleFormat.getInstance());
        getProviderTableColumn5().setFormat(new QkanInsureTypeDivision());
        
        providerTableModel.setColumns(ada);

        setTableModel(providerTableModel);

        // 事業所一覧テーブル（providerTable）にthis.tableModelを設定する。
        getProviderTable().setModel(getTableModel());
        // 請求レコード集合（this.claimList）をthis.tableModelに設定する。
        getTableModel().setAdaptee(getClaimList());

        if (getListIndex() == -1) {
            // 事業所一覧テーブル（providerTable）の一行目を選択した状態にする。
            getProviderTable().setSelectedSortedFirstRow();
            
        } else {
            // 利用者一覧（請求）（QP001）以外から遷移してきた場合
            // 事業所一覧テーブル（providerTable）の遷移前に選択されていた行（this.listIndex）を選択した状態にする。
            getProviderTable().setSelectedModelRow(getListIndex());
            getProviderTable().scrollSelectedToVisible();
        }
        
        // 画面状態制御
        checkState();

    }

    public boolean canBack(VRMap parameters) throws Exception {
        if (!super.canBack(parameters)) {
            return false;
        }
        // 下記を渡りパラメータとして、利用者一覧（請求）画面（QP001）に遷移する。
        // ・KEY：PATIENT_ID VALUE：this.patientId
        // ・KEY：CLAIM_DATE VALUE：this.targetDate
        parameters.setData("PATIENT_ID", new Integer(getPatientId()));
        parameters.setData("CLAIM_DATE", getClaimDate());
        

        // TODO 前画面への遷移を許可するならばtrueを返す。
        return true;
    }

    // コンポーネントイベント

    /**
     * 「利用者向け請求詳細編集画面に遷移」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void seikyuActionPerformed(ActionEvent e) throws Exception {
        // 下記を渡りパラメータとして、利用者向け請求詳細編集画面（QP003）に遷移する。
        VRMap param = new VRHashMap();
        // ・KEY：PATIENT_ID VALUE：this.patientId
        // ・KEY：CLAIM_DATE VALUE：this.claimDate
        // ・KEY：TARGET_DATE VALUE：選択されているレコードの対象年月
        // ・KEY：LIST_INDEX VALUE：選択されているレコードのインデックス
        // ・KEY：PROVIDER_ID VALUE：選択されているレコードの事業所ID
        // ・KEY：INSURED_ID VALUE：選択されているレコードの被保険者番号
        // ・KEY：INSURER_ID VALUE：選択されているレコードの保険者番号
        if (getProviderTable().getSelectedRow() == -1) {
            return;
        }

        VRMap map = new VRHashMap();
        if (getProviderTable().getSelectedModelRowValue() instanceof VRMap) {
            map = (VRMap) getProviderTable().getSelectedModelRowValue();

        } else {
            return;

        }
        param.setData("PATIENT_ID", new Integer(getPatientId()));
        param.setData("CLAIM_DATE", getClaimDate());
        param.setData("TARGET_DATE", map.getData("TARGET_DATE"));
        param.setData("LIST_INDEX", new Integer(getProviderTable()
                .getSelectedModelRow()));
        param.setData("PROVIDER_ID", map.getData("PROVIDER_ID"));
        param.setData("INSURER_ID", map.getData("INSURER_ID"));
        
        //カラム判別で用いたパラメーターを再度分割
        String findInsurer = ACCastUtilities.toString(map.getData("INSURED_ID"));
        //分割
        String[] findCut = findInsurer.split("-");
        if(findCut != null){
            if(findCut.length > 0){
                findInsurer = findCut[0];
            }
        }
        param.setData("INSURED_ID", findInsurer);
//        param.setData("INSURED_ID", map.getData("INSURED_ID"));

        ACAffairInfo affair = new ACAffairInfo(QP003.class.getName(), param);

        ACFrame.getInstance().next(affair);

    }

    /**
     * 「画面遷移処理」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void selectActionPerformed(ActionEvent e) throws Exception {
        transferAffair();
    }

    /**
     * 「画面遷移処理」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void providerTableMouseClicked(MouseEvent e) throws Exception {
        // 選択ボタン（select）クリック時と同様の処理を行う。
        transferAffair();
    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        param.setData("PATIENT_ID", new Integer(1));
        param.setData("DEBUG_BACK", QP001.class.getName());
        param.setData("CLAIM_DATE", new Date(106, 2, 1));
        param.setData("PROVIDER_ID", "0000000005");
        param.setData("TARGET_DATE", new Date(106, 1, 1));
        param.setData("LIST_INDEX", new Integer(0));
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QP002.class.getName(), param));
    }

    // 内部関数

    /**
     * 「レコード編集」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void editRecord() throws Exception {
        // 請求レコード集合（this.claimList）を順に見ていく。（ループ開始）
        VRList claimList = getClaimList();


    }
    
    /**
     * 画面遷移処理を行います。
     * @throws Exception
     */
    public void transferAffair() throws Exception {

        VRMap map = new VRHashMap();
        if (getProviderTable().isSelected()) {
            if (getProviderTable().getSelectedModelRowValue() instanceof VRMap) {
                map = (VRMap) getProviderTable().getSelectedModelRowValue();

            } else {
                return;

            }
            // 事業所一覧テーブルで、選択されているレコードが介護請求のレコードの場合（(CLAIM_STYLE_TYPE <> 20101)
            // AND
            // (CLAIM_STYLE_TYPE <> 20102)）
            if (!new Integer(20101).equals(map.getData("CLAIM_STYLE_TYPE"))
                    && !new Integer(20102).equals((map
                            .getData("CLAIM_STYLE_TYPE")))) {
                VRMap param = new VRHashMap();
                // 下記を渡りパラメータとして、明細書基本情報編集画面（QP004）に遷移する。
                // ・KEY：PATIENT_ID VALUE：this.patientId
                // ・KEY：CLAIM_DATE VALUE：this.claimDate
                // ・KEY：TARGET_DATE VALUE：選択されているレコードの対象年月
                // ・KEY：LIST_INDEX VALUE：選択されているレコードのインデックス
                // ・KEY：PROVIDER_ID VALUE：選択されているレコードの事業所ID
                // ・KEY：CLAIM_STYLE_TYPE VALUE：選択されているレコードの請求帳票様式
                // ・KEY：INSURED_ID VALUE：選択されているレコードの被保険者番号
                param.setData("PATIENT_ID", new Integer(getPatientId()));
                param.setData("CLAIM_DATE", getClaimDate());
                param.setData("TARGET_DATE", map.getData("TARGET_DATE"));
                param.setData("LIST_INDEX", new Integer(getProviderTable()
                        .getSelectedModelRow()));
                param.setData("PROVIDER_ID", map.getData("PROVIDER_ID"));
                param.setData("INSURER_ID", map.getData("INSURER_ID"));
                
                //カラム判別で用いたパラメーターを再度分割
                String findInsurer = ACCastUtilities.toString(map.getData("INSURED_ID"));
                //分割
                String[] findCut = findInsurer.split("-");
                if(findCut != null){
                    if(findCut.length > 0){
                        findInsurer = findCut[0];
                    }
                }
                param.setData("INSURED_ID", findInsurer);
                param.setData("CLAIM_STYLE_TYPE", map
                        .getData("CLAIM_STYLE_TYPE"));
                // ACAffairInfo affair = new ACAffairInfo(QP004.class.getName(),
                // param);

                
                // 居宅支援の場合次画面の遷移は基本QP004では無くQP005の詳細編集画面に遷移する
                // 居宅予防支援の場合次画面の遷移は基本QP004では無くQP005の詳細編集画面に遷移する 
                ACAffairInfo affair;
                if(new Integer(10711).equals(map.getData("CLAIM_STYLE_TYPE"))
                		|| new Integer(10712).equals(map.getData("CLAIM_STYLE_TYPE"))){
                	affair = new ACAffairInfo(QP005.class.getName(), param);
                }else{                
                	affair = new ACAffairInfo(QP004.class.getName(), param);
                }
                	
                ACFrame.getInstance().next(affair);

            }

        }
    }

    /**
     * テーブル選択時のイベント
     */
    protected void providerTableSelectionChanged(ListSelectionEvent e) throws Exception {
        //画面状態をチェックする。
        checkState();
    }

    /**
     * 画面状態制御
     */
    public void checkState() throws Exception {
        //テーブルが選択されているかチェックする。
        if (getProviderTable().getSelectedModelRow() == -1){
            //選択されていなかった場合
            setState_AFFAIR_BUTTON_ENABLE_FALSE();
        }else{
            //選択されていた場合
            setState_AFFAIR_BUTTON_ENABLE_TRUE();
        }
    }

 // 2016/2/3 [2015年要望][Yoichiro Kamei] add - begin 削除機能追加
    /**
     * 「請求データ削除」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void deleteActionPerformed(ActionEvent e) throws Exception {
        // 削除確認メッセージを表示する。
        if (QkanMessageList.getInstance().WARNING_OF_DELETE_SELECTION() != ACMessageBox.RESULT_OK) {
            return;
        }
        // 選択された様式の集計データを削除する。
        for (int i = 0; i < getClaimList().getDataSize(); i++) {
            VRMap map = (VRMap) getClaimList().get(i);
            String choise = String.valueOf(VRBindPathParser.get("DELETE", map));
            // 選択されていれば削除実行
            if ("TRUE".equalsIgnoreCase(choise)) {
                // 条件
                String condition = createCondition(map, QkanSystemInformation.getInstance().getLoginProviderID(), getPatientId());
                Date targetDate = ACCastUtilities.toDate(VRBindPathParser.get("TARGET_DATE",map));
                try {
                    getDBManager().beginTransaction();
                    QkanCommon.updateClaimDetailCustom(getDBManager(), new VRArrayList(), targetDate, condition);
                    getDBManager().commitTransaction();
                } catch (Exception e1) {
                    getDBManager().rollbackTransaction();
                    throw e1;
                }
            }
        }
        // 再検索
        doFind();
    }
    
    //削除条件構築
    private String createCondition(VRMap param, String providerId, int patientID) throws Exception {
        String styleType = ACCastUtilities.toString(VRBindPathParser.get("CLAIM_STYLE_TYPE",param));
        String insurerId = ACCastUtilities.toString(VRBindPathParser.get("INSURER_ID",param));
        String insuredId = ACCastUtilities.toString(VRBindPathParser.get("UNIT_INSURED_ID",param));
        Date targetDate = ACCastUtilities.toDate(VRBindPathParser.get("TARGET_DATE",param));
        Date claimDate = ACCastUtilities.toDate(VRBindPathParser.get("CLAIM_DATE",param));
        
        StringBuilder sb = new StringBuilder();
        sb.append(" (CLAIM.CLAIM_DATE = '" + VRDateParser.format(claimDate, "yyyy-MM-dd") + "')");
        sb.append(" AND(CLAIM.PATIENT_ID = " + patientID + ")");
        if (!ACTextUtilities.isNullText(insuredId)) {
            sb.append(" AND(CLAIM.INSURED_ID = '" + insuredId + "')");
        }
        sb.append(" AND(CLAIM.TARGET_DATE = '" + VRDateParser.format(targetDate, "yyyy-MM-dd") + "')");
        if (!ACTextUtilities.isNullText(providerId)) {
            sb.append(" AND(CLAIM.PROVIDER_ID = '" + providerId + "')");
        }
        sb.append(" AND(CLAIM.CLAIM_STYLE_TYPE = " + styleType + ")");
        if (!ACTextUtilities.isNullText(insurerId)) {
            sb.append(" AND(CLAIM.INSURER_ID = '" + insurerId + "')");
        }
        return sb.toString();
    }
    
    /**
     * 「選択操作メニュークリック」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void providerTableColumn9CheckMenuActionPerformed(ActionEvent e)
            throws Exception {
        if(getClaimList() == null) return;
        String choise;
        for (int i = 0; i < getClaimList().getDataSize(); i++) {
            choise = String.valueOf(VRBindPathParser.get("DELETE",
                    (VRLinkedHashMap) getClaimList().get(i)));
            // 選択されていれば押下可能
            if ("TRUE".equalsIgnoreCase(choise)) {
                getDelete().setEnabled(true);
                return;
            }
        }
        getDelete().setEnabled(false);
        
    }
 // 2016/2/3 add - end
    
}
