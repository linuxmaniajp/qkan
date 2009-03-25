
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
 * 開発者: 小笠　貴志
 * 作成日: 2006/01/08  日本コンピューター株式会社 小笠　貴志 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービス予定 (QS001)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.dnd.DragGestureEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.Format;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.lowagie.text.pdf.hyphenation.TernaryTree;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.component.dnd.event.ACDraggableListener;
import jp.nichicom.ac.component.dnd.event.ACDropEvent;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.core.ACFrameEventProcesser;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServiceCodeCalcurater;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.lib.care.claim.servicecode.Qkan10011_ServiceCodeManager;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanValidServiceManager;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACDateFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.ac.util.splash.ACSplashChaine;
import jp.nichicom.ac.util.splash.ACSplashable;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.adapter.VRListModelAdapter;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.text.QkanJotaiCodeUnapplicableFormat;
import jp.or.med.orca.qkan.text.QkanServiceAbbreviationFormat;
import jp.or.med.orca.qkan.text.QkanServiceKindNameFormat;

/**
 * サービス予定(QS001)
 */
public class QS001 extends QS001Event {
    /**
     * コンストラクタです。
     */
    public QS001() {
    }
    
    // 2008/01/24 [Masahiko_Higuchi] add - begin サービスパターン設定ボタン操作実行時エラー対応
    private int correctKey = 0;
    // 2008/01/24 [Masahiko_Higuchi] add - end
    
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
        getPatternList().setHeaderVisible(false);

        Qkan10011_ServiceCodeManager.getInstance().clearServiceCodeCache();

        // ■各種情報を取得・設定
        // 渡りパラメータの KEY : PROCESS_TYPE の VALUE を取得する。
        // 取得した値は処理タイプ(processType)に退避する。
        setProcessType(ACCastUtilities.toInt(VRBindPathParser.get(
                "PROCESS_TYPE", affair.getParameters())));

        // 渡りパラメータの KEY : PATIENT_ID の VALUE を取得する。
        // 取得した値は利用者ID(patientID)に退避する。
        setPatientID(ACCastUtilities.toInt(VRBindPathParser.get("PATIENT_ID",
                affair.getParameters())));
        // 渡りパラメータの KEY : TARGET_DATE の VALUE を取得する。
        // 取得した値は対象年月(targetDate)に退避する。
        setTargetDate(ACCastUtilities.toDate(VRBindPathParser.get(
                "TARGET_DATE", affair.getParameters())));

        // ※パッシブチェック用のキーを生成する。
        // 以下の設定でパッシブチェックキーを生成する。
        // テーブル名： SERVICE_PASSIVE_CHECK
        // フィールド名：
        // PATIENT_ID
        // LOGIN_PROVIDER_ID
        // TARGET_DATE
        // CHECK_TYPE
        // フォーマット：
        // なし
        // 文字列
        // 日付(yyyy-MM-dd)
        // なし
        // 退避データにおけるタイムスタンプフィールド名： LAST_TIME
        // DBデータにおけるタイムスタンプフィールド名： LAST_TIME
        // 生成したパッシブチェックキーをサービスパッシブチェックテーブル用のパッシブキー(ERVICE_PASSIVE_CHECK_KEY)に退避する。
        setSERVICE_PASSIVE_CHECK_KEY(new ACPassiveKey("SERVICE_PASSIVE_CHECK",
                new String[] { "PATIENT_ID",
                // "LOGIN_PROVIDER_ID",
                        "TARGET_DATE", "CHECK_TYPE", }, new Format[] { null,
                // ACConstants.FORMAT_SQL_STRING,
                        ACConstants.FORMAT_SQL_FULL_YMD, null, }, "LAST_TIME",
                "LAST_TIME"));
        // パッシブチェックテーブル用のSQLパラメタを生成し、パッシブチェックテーブル用のSQLパラメタ(passiveCheckSQLParam)に退避する。
        VRMap sqlParam = new VRHashMap();
        VRBindPathParser.set("PATIENT_ID", sqlParam,
                new Integer(getPatientID()));
        // VRBindPathParser.set("LOGIN_PROVIDER_ID", sqlParam,
        // QkanSystemInformation.getInstance().getLoginProviderID());
        VRBindPathParser.set("TARGET_DATE", sqlParam, getTargetDate());
        VRBindPathParser.set("CHECK_TYPE", sqlParam, new Integer(
                getProcessType()));
        setPassiveCheckSQLParam(sqlParam);

        // ※既存レコードの有無を基準に、更新モードか登録モードかを判断
        // ※既存レコードの有無を基準に、更新モードか登録モードかを判断する。
        checkProcessMode();

        // ※対象年月の設定
        // 「利用者情報」内の日付項目に対象年月(targetDate)を設定する。
        getTargetYearMonth().setText(
                VRDateParser.format(getTargetDate(), "ggge年M月"));
        // ※利用者情報(基本情報)の設定
        // 利用者ID(patientID) を元に、利用者の基本情報を取得する。
        // 取得した値は利用者情報(patientInfo)に設定する。
        VRList patients = QkanCommon.getPatientInfo(getDBManager(),
                getPatientID());
        if (patients.isEmpty()) {
            // 利用者情報が存在しない場合
            // 戻る
            ACFrame.getInstance().back();
            return;
        }
        setPatientInfo((VRMap) patients.getData());
        // 利用者情報を「利用者情報」内に設定する。
        getPatientName().setText(
                QkanCommon.toFullName(VRBindPathParser.get(
                        "PATIENT_FAMILY_NAME", getPatientInfo()),
                        VRBindPathParser.get("PATIENT_FIRST_NAME",
                                getPatientInfo())));

        // ※利用者情報(施設履歴情報)の設定
        // 利用者ID(patientID) を元に、利用者の施設履歴情報を取得する。
        VRList specialFacilities = getDBManager().executeQuery(
                getSQL_GET_PATIENT_FACILITY_FLAG(getPatientInfo()));
        if (!specialFacilities.isEmpty()) {
            // 施設履歴情報の特定入所者フラグを内部変数(inSpecialFacilityFlag)に退避する。
            Object obj = ((Map) specialFacilities.getData())
                    .get("TOKUTEI_NYUSHO_FLAG");
            setInSpecialFacilityFlag(ACCastUtilities.toInt(obj, 0));
            obj = ((Map) specialFacilities.getData()).get("KYUSOCHI_FLAG");
            setOldFacilityUserFlag(ACCastUtilities.toInt(obj, 0));
        }

        // ※利用者情報(要介護度情報)の設定
        // 要介護度履歴情報格納用のレコード集合 patientInsureInfoHistoryListを宣言する。
        VRList patientInsureInfoHistoryList;
        // 対象年月内の利用者要介護度認定履歴レコード集合を取得し、patientInsureInfoHistoryListに設定する。
        // patientInsurerInfoHistory(DBManager, targetDateSource, patinetID);
        patientInsureInfoHistoryList = QkanCommon.getPatientInsureInfoHistory(
                getDBManager(), getTargetDate(), getPatientID());

        // 対象年月内の利用者要介護度認定履歴レコード集合が1件の場合
        if (patientInsureInfoHistoryList.size() == 1) {
            // 取得した履歴情報から、要介護度(フィールドJOTAI_CODE)を取得し、日本語名に変換する。
            // 変換した要介護度名を、画面の「要介護度(yokaigodo)」に設定する。
            VRMap patientInsurereInfo = (VRMap) patientInsureInfoHistoryList
                    .getData();
            getYokaigodo().setText(
                    QkanJotaiCodeUnapplicableFormat.getInstance().format(
                            VRBindPathParser.get("JOTAI_CODE",
                                    patientInsurereInfo)));
            // 画面の「被保険者番号(patientInsuredID)」に、取得した履歴情報の被保険者番号(フィールドINSURED_ID)を設定する。
            getPatientInsuredID().setText(
                    ACCastUtilities.toString(VRBindPathParser.get("INSURED_ID",
                            patientInsurereInfo)));
        } else if (patientInsureInfoHistoryList.isEmpty()) {
            VRMap param = new VRHashMap();
            param.setData("PATIENT_ID", ACCastUtilities.toInteger(getPatientID()));
            VRList list=getDBManager().executeQuery(getSQL_CHECK_NINTEI_HISTORY_EXISTS(sqlParam));
            if((list==null)||(list.isEmpty())){
                getYokaigodo().setText("認定履歴なし");
            }else{
                getYokaigodo().setText("有効期間外");
            }
            getPatientInsuredID().setText("");
        } else {
            // 対象年月内の利用者要介護度認定履歴レコード集合が複数件ある場合
            // 月初の要介護度履歴情報格納用レコード patientInsureInfoFirst を宣言する。
            VRMap patientInsureInfoFirst;
            // 月末の要介護度履歴情報格納用レコード patientInsureInfoLast を宣言する。
            VRMap patientInsureInfoLast;

            // patientInsureInfoFirstに、patientInsureInfoHistoryListの最初のレコードを設定する。
            patientInsureInfoFirst = (VRMap) patientInsureInfoHistoryList
                    .getData(0);
            // patientInsureInfoLastに、patientInsureInfoHistoryListの最後のレコードを設定する。
            patientInsureInfoLast = (VRMap) patientInsureInfoHistoryList
                    .getData(patientInsureInfoHistoryList.size() - 1);
            // 月初、月末共に、履歴レコードから要介護度(フィールドJOTAI_CODE)を取得し、日本語名に変換する。
            // 画面の「要介護度(yokaigodo)」には、「(月初の要介護度名)→(月末の要介護度名)」を設定する。
            getYokaigodo().setText(
                    QkanJotaiCodeUnapplicableFormat.getInstance().format(
                            VRBindPathParser.get("JOTAI_CODE",
                                    patientInsureInfoFirst))
                            + "→"
                            + QkanJotaiCodeUnapplicableFormat.getInstance()
                                    .format(
                                            VRBindPathParser.get("JOTAI_CODE",
                                                    patientInsureInfoLast)));
            // 画面の「被保険者番号(patientInsuredID)」には、「(月初の被保険者番号)→(月末の被保険者番号)」を設定する。
            String beginID = ACCastUtilities.toString(VRBindPathParser.get(
                    "INSURED_ID", patientInsureInfoFirst));
            String endID = ACCastUtilities.toString(VRBindPathParser.get(
                    "INSURED_ID", patientInsureInfoLast));
            if (ACTextUtilities.isNullText(beginID)) {
                beginID = "なし";
            }
            if (ACTextUtilities.isNullText(endID) || beginID.equals(endID)) {
                getPatientInsuredID().setText(beginID);
            } else {
                getPatientInsuredID().setText(beginID + "→" + endID);
            }

        }
        getYokaigodo().setColumns(getYokaigodo().getText().length()+1);

        // ※事業者が提供するサービス種類の設定
        // 登録されている事業所が提供するサービスを「サービス種類」に設定する。(どの事業所も提供しないサービスは表示しない)
        VRList services;
        sqlParam = new VRHashMap();
        sqlParam.setData("TARGET_DATE", getTargetDate());
        if (getProcessType() == QkanConstants.PROCESS_TYPE_PLAN) {
            // 処理タイプ(processType)がPROCESS_TYPE_PLANの場合
            // サービス種類に「その他」と「主な日常生活上の活動」を追加する。
            services = getDBManager()
                    .executeQuery(
                            getSQL_GET_USED_PROVIDER_SERVICE_WITH_WEEKLY_SERVICE(sqlParam));
        } else {
            services = getDBManager()
                    .executeQuery(
                            getSQL_GET_USED_PROVIDER_SERVICE_WITHOUT_WEEKLY_SERVICE(sqlParam));
        }
        
        //医療系非表示対応 fujihara.shin 2009.1.13 add start
        if (!QkanCommon.isShowOldIryo()){
	        for (int i = 0; i < services.size(); i++){
	        	VRMap row = (VRMap)services.get(i);
	        	if (ACCastUtilities.toInt(row.get("SYSTEM_SERVICE_KIND_DETAIL"), 0) == 20101){
	        		services.remove(i);
	        		break;
	        	}
	        }
        }
        //医療系非表示対応 fujihara.shin 2009.1.13 add end
        
        // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
        if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, getTargetDate())<1){
            // 基準適合診療所は除外する。
            // 12314 : 短期入所療養介護(基準適合診療所)
            // 13411 : 介護予防短期入所療養介護(基準適合診療所)
            int[] h2104RemoveServices = { 12314, 12614 };
            for (int i = 0; i < services.size(); i++){
                VRMap row = (VRMap)services.get(i);
                for(int j=0; j < h2104RemoveServices.length;j++) {
                    int removeSystemServiceKindDetail = h2104RemoveServices[j];
                    if (ACCastUtilities.toInt(row.get("SYSTEM_SERVICE_KIND_DETAIL"), 0) == removeSystemServiceKindDetail){
                        services.remove(i);
                        break;
                    }
                }
            }            
        }
        // [ID:0000444][Masahiko Higuchi] 2009/02 add end
        
        setServiceKindsList(services);
        getServiceKindList().setModel(new ACListModelAdapter(services));
        getServiceKindList().setCellRenderer(
                new QS001ServiceKindListCellRenderer());

        // ※ユーザ登録済みサービスパターンを取得
        services = QkanCommon.getServicePatternDetail(getDBManager());
        VRMap patterns = new VRHashMap();
        Iterator it = services.iterator();
        boolean isExistingData = false;
        while (it.hasNext()) {
            VRMap row = (VRMap) it.next();
            Object kind = VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL",
                    row);
            Object targetPatterns = patterns.get(kind);
            if (!(targetPatterns instanceof VRList)) {
                // 最初のパターン
                targetPatterns = new VRArrayList();
                patterns.put(kind, targetPatterns);
            }
            ((VRList) targetPatterns).add(row);
            // 予防時対応（要望対応）
            //TODO パターン番号を採番済みであるか調べる
            if(!isExistingData){
                for(int i = 0;i<((VRList)targetPatterns).size();i++){
                    // Mapに格納する
                    VRMap map = (VRMap)((VRList)targetPatterns).getData(i);
                    if (VRBindPathParser.has(ACCastUtilities.toString(QkanConstants.INTERNAL_SERVICE_PATTERN_NO_BIND_PATH),map)){
                        // 一度でも該当すれば以降は通らない
                        isExistingData = true;
                        break;
                    }
                }
            }
        }
        setServicePatternHash(patterns);
        
        if(!isExistingData){
            // 採番済みでなかった場合
            //  パターン番号を採番する。
            it = patterns.values().iterator();
            while (it.hasNext()) {
                Object row = it.next();
                if (row instanceof VRList) {
                    VRList targetPatterns = (VRList)row;
                    for(int i = 0;i<((VRList)targetPatterns).size();i++){
                        VRMap inMap = new VRHashMap();
                        inMap = (VRMap)((VRList)targetPatterns).getData(i);
                        // 削除対象に追加
                        getDeleteReseveServicePatterns().add(inMap);
                        // 追加対象に追加
                        getInsertReserveServicePatterns().add(inMap);                        
                        // 存在しなかった場合（既存データ）
                        VRBindPathParser.set(ACCastUtilities.toString(QkanConstants.INTERNAL_SERVICE_PATTERN_NO_BIND_PATH),inMap,ACCastUtilities.toInteger(i+1));
                    }
                }
            }
            
        }else{
            // 採番済みだった場合
            // パターン番号を採番する。
            it = patterns.values().iterator();
            while (it.hasNext()) {
                //サービス種類単位でパターンをソートする。
                Object row = it.next();
                if (row instanceof VRList) {
                    VRList targetPatterns = (VRList)row;
                    Map treeMap = new TreeMap();
                    ArrayList keyNullList = new ArrayList();
                    
                    //パターン番号をキーにしてソートする。
                    Iterator it2= targetPatterns.iterator();
                    while(it2.hasNext()){
                        VRMap  inMap = (VRMap)it2.next();
                        //パターン番号をキーにしてTreeMapに入れる。自動的にソートがかかる。
                        Object key = inMap.get(ACCastUtilities.toString(QkanConstants.INTERNAL_SERVICE_PATTERN_NO_BIND_PATH));
                        if(key==null){
                            //なぜかサービスパターン番号が存在しなかった場合
                            keyNullList.add(inMap);
                            // 削除対象に追加
                            getDeleteReseveServicePatterns().add(inMap);
                            // 追加対象に追加
                            getInsertReserveServicePatterns().add(inMap);                        
                        }else{
                            treeMap.put(key,inMap);
                        }
                    }
                    //サービスパターン番号が存在しなかったものに採番する。
                    it2= keyNullList.iterator();
                    while(it2.hasNext()){
                        VRMap  inMap = (VRMap)it2.next();
                        //現在の登録数+1を採番する。
                        Integer key = ACCastUtilities
                                .toInteger(treeMap.size() + 1);
                        VRBindPathParser
                                .set(
                                        ACCastUtilities
                                                .toString(QkanConstants.INTERNAL_SERVICE_PATTERN_NO_BIND_PATH),
                                        inMap, key);
                        treeMap.put(key,inMap);
                    }
                    
                    
                    //ソート結果に差し替える。
                    targetPatterns.clear();
                    targetPatterns.addAll(treeMap.values());
                }
            }
        }

        // サービス単位計算クラスを生成する。
        VRMap hashedProviders = new VRHashMap();
        // PROVIDER_IDをキーにハッシュ化し、内部変数(hashedProviders)に退避する。
        ACBindUtilities.setMapFromArray(QkanCommon
                .getProviderInfo(getDBManager()), hashedProviders,
                "PROVIDER_ID");
        setCalcurater(new CareServiceCodeCalcurater());
        getCalcurater().initialize(getTargetDate(), getPatientInfo(),
                patientInsureInfoHistoryList, hashedProviders, getDBManager(),
                getServiceKindsList(), getInSpecialFacilityFlag(),
                getOldFacilityUserFlag());

        // ※ウィンドウタイトルの設定
        // 業務情報レコードを取得する。
        // ウィンドウタイトルに、取得レコードのKEY : WINDOW_TITLEのVALUEを設定する。
        // 業務ボタンバーのテキストに、取得レコードのKEY : AFFAIR_TITLEのVALUEを設定する。
        setAffairTitle("QS001", ACCastUtilities.toString(getProcessType()),
                getButtons());

        // ※選択された利用者の、対象年月分の予定または実績情報の設定
        // 月間表（QS001002）を生成してmonthlyPanelとして設定する。
        setMonthlyPanel(new QS001002());
        getCharts().add(getMonthlyPanel(), VRLayout.CLIENT);
        getMonthlyPanel().setTargetDate(getTargetDate());
        getMonthlyPanel().setOwnerAffair(this);

        // サービス描画用のセルレンダラ(QS001ServicePatternListCellRenderer)を宣言・生成する。
        QS001ServicePatternListCellRenderer cellRenderer = new QS001ServicePatternListCellRenderer();
        VRMap masterService = QkanCommon.getMasterService(getDBManager(),
                getTargetDate());
        cellRenderer.setMasterService(masterService);
        // [ID:0000444][Tozo TANAKA] 2009/03/14 add begin 平成21年4月法改正対応
        cellRenderer.setTargetDate(getTargetDate());
        // [ID:0000444][Tozo TANAKA] 2009/03/14 add end
        setSharedFocusCellRenderer(cellRenderer);
        // パターンパネルへセルレンダラを設定する。
        getPatternList().setCellRenderer(cellRenderer);
        getPatternList().setMasterService(masterService);
        cellRenderer.setPatternList(getPatternList());
        // 月間表へセルレンダラを設定する。
        getMonthlyPanel().setCellRenderer(cellRenderer);
        getMonthlyPanel().setMasterService(masterService);
        
        QkanServiceAbbreviationFormat.getInstance().setMasterService(masterService);
        QkanServiceKindNameFormat.getInstance().setMasterService(masterService);
        

        // 「手」ボタンにドラッグイベントを関連付ける。
        getPicture().addDraggableListener(new ACDraggableListener() {
            public void beginDrag(DragGestureEvent event) {
                try {
                    pictureDragAndDrop();
                } catch (Throwable ex) {
                    ACCommon.getInstance().showExceptionMessage(ex);
                }
            }

        });

        // ※週間表/月間表の生成
        // 週間表（QS001001）を生成してweeklyPanelとして設定する。
        setWeeklyPanel(new QS001001());
        getCharts().add(getWeeklyPanel(), VRLayout.CLIENT);
        // 週間表へセルレンダラを設定する。
        getWeeklyPanel().setCellRenderer(cellRenderer);
        getWeeklyPanel().setTargetDate(getTargetDate());
        getWeeklyPanel().setMasterService(masterService);
        // 週間表の開始時刻を引数として、開始時刻の連動リスナを生成し、定義変数beginTimeFollowListenerに退避。
        setBeginTimeFollowListener(new QS001FollowTimeComboDocumentListener(
                getWeeklyPanel().getBeginCombo(), null));
        // 週間表の終了時刻を引数として、終了時刻の連動リスナを生成し、定義変数endTimeFollowListenerに退避。
        setEndTimeFollowListener(new QS001FollowTimeComboDocumentListener(
                getWeeklyPanel().getEndCombo(), null));
        getWeeklyPanel().initialize(this);

        if (getProcessType() == QkanConstants.PROCESS_TYPE_PLAN) {
            // 処理タイプ(processType)が予定（PROCESS_TYPE_PLAN）の場合
            // ※予定/実績に関係する業務ボタンの切り替え
            // 予定用の業務ボタンを表示し、実績用の業務ボタンを非表示にする。
            setState_AFFIR_MODE_PLAN();
        } else if (getProcessType() == QkanConstants.PROCESS_TYPE_RESULT) {
            // 処理タイプ(processType)が実績（PROCESS_TYPE_RESULT）の場合
            // ※予定/実績に関係する業務ボタンの切り替え
            // 実績用の業務ボタンを表示し、予定用の業務ボタンを非表示にする。
            setState_AFFIR_MODE_RESULT();

        }
        // ※月間/週間表のイベントを関連付ける。
        // 月間/週間表のサービス選択イベントをserviceListSelectionChangedに関連付ける。
        // 月間/週間表のキー押下イベントをserviceListKeyDownに関連付ける。
        ListSelectionListener selListener;
        selListener = new ListSelectionListener() {
            private boolean lockFlag = false;

            public void valueChanged(ListSelectionEvent e) {
                if (lockFlag) {
                    return;
                }
                lockFlag = true;
                try {
                    serviceListSelectionChanged(e);
                } catch (Throwable ex) {
                    ACCommon.getInstance().showExceptionMessage(ex);
                } finally {
                    lockFlag = false;
                }
            }
        };
        KeyAdapter keyListener;
        keyListener = new KeyAdapter() {
            private boolean lockFlag = false;

            public void keyPressed(KeyEvent e) {
                if (lockFlag) {
                    return;
                }
                lockFlag = true;
                try {
                    serviceListKeyDown(e);
                } catch (Throwable ex) {
                    ACCommon.getInstance().showExceptionMessage(ex);
                } finally {
                    lockFlag = false;
                }
            }
        };
        getMonthlyPanel().addListSelectionListener(selListener);
        getMonthlyPanel().addKeyListener(keyListener);
        if (getWeeklyPanel() != null) {
            getWeeklyPanel().addListSelectionListener(selListener);
            getWeeklyPanel().addKeyListener(keyListener);
        }

        // ※初期表示データを取得
        // 検索処理を行なう。
        doFind();

        getMonthlyPanel().initialize(this);
        if (getServiceKindList().getItemCount() > 0) {
            getServiceKindList().setSelectedIndex(0);
        }

        boolean modifiedFlag = false; 
        
        // ※週間表/月間表の表示切替
        if (getProcessType() == QkanConstants.PROCESS_TYPE_PLAN) {
            // 処理タイプ(processType)が予定（PROCESS_TYPE_PLAN）の場合
            // 月間表情報の件数をチェックする。
            if (getMonthlyPanel().getScheduleCount() <= 0) {
                // 0件の場合
                // 週間表を表示する。
                showWeekly();

                if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
                    // 登録モードの場合
                    doOpenPlan();
                }
            } else {
                // 0件より多い場合
                // 月間表を表示する。
                showMonthly();
            }
        } else if (getProcessType() == QkanConstants.PROCESS_TYPE_RESULT) {
            // 処理タイプ(processType)が実績（PROCESS_TYPE_RESULT）の場合

            // 月間表を表示する。
            showMonthly();
            if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
                // 登録モードの場合
                doOpenPlan();
            }

            VRMap splParam = new VRHashMap();
            splParam.setData("PROVIDER_ID", QkanSystemInformation.getInstance()
                    .getLoginProviderID());
            VRList list = getDBManager().executeQuery(
                    getSQL_GET_LOGIN_PROVIDER_CARE_MANAGEMENT(splParam));
            if (list.isEmpty()) {
                // 居宅介護支援は提供していない
                setState_NOT_PROVIDE_CARE_MANAGEMENT();
            } else {
                // 居宅介護支援を提供している
                setState_PROVIDE_CARE_MANAGEMENT();

                // 月間表情報の件数をチェックする。
                if (getMonthlyPanel().getScheduleCount() <= 0) {
                    // 0件の場合
                    // 予定読み込みを行なうかの確認メッセージを表示する。※メッセージID = QS001_NO_RESULT
                    if (QkanMessageList.getInstance()
                            .QS001_QUESTION_OF_NO_RESULT() == ACMessageBox.RESULT_YES) {
                        // 「はい」選択時
                        // 予定データ読込を行なう。
                        doOpenResult();
                        modifiedFlag = getMonthlyPanel().getScheduleCount()>0;
                    }
                }
            }
            
            // 予防時対応
            // 週間計画表印刷ボタンを無効にする。
            setState_RESULT_PRINT_WEEKLY();
        }

        setServiceModify(modifiedFlag);
    }
    

  public boolean canBack(VRMap parameters) throws Exception {
        if (!super.canBack(parameters)) {
            return false;
        }
        // ■戻り処理
        // ※スナップショットチェック(対象は「月間表/週間表(chartsパネル)」)
        if (getServiceModify()) {
            // ※戻り処理確認(ID = WARNING_OF_UPDATE_ON_MODIFIED)
            switch (QkanMessageList.getInstance()
                    .WARNING_OF_UPDATE_ON_MODIFIED()) {
            case ACMessageBox.RESULT_YES:
                // ※保存処理
                
                // [ID:0000456][Tozo TANAKA] 2009/03/12 add begin 平成21年4月法改正対応
                // ※入力チェック
                // 入力チェックを行う。
                if (!checkValidInput()) {
                    // 戻り値がfalseの場合
                    // 戻り値としてfalseを返し、処理を中断する。
                    return false;
                }
                // [ID:0000456][Tozo TANAKA] 2009/03/12 add end
                
                if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
                    doInsert();
                } else {
                    doUpdate();
                }
                break;
            case ACMessageBox.RESULT_NO:
                break;
            default:
                return false;
            }
        }
        // サービスパターンの追加削除を実行する。
        saveServicePattern();
        // ※戻り処理

        Qkan10011_ServiceCodeManager.getInstance().clearServiceCodeCache();
        
        // 前画面への遷移を許可するならばtrueを返す。
        return true;
    }

    public boolean canClose() throws Exception {
        if (!super.canClose()) {
            return false;
        }
        // ■業務終了時のイベント
        // ※スナップショットチェック(対象は「月間表/週間表(chartsパネル)」)
        // スナップショットの更新チェックを行う。
        // 更新されていない場合
        // サービスパターンの追加削除を実行する。
        // システムを終了する。
        if (getServiceModify()) {
            // 更新されている場合
            // 処理を継続する。

            // ※終了確認
            // 終了確認のメッセージを表示する。※メッセージID = WARNING_OF_CLOSE_ON_MODIFIED
            // 「OK」選択時
            // 処理を継続する。
            if (QkanMessageList.getInstance().WARNING_OF_CLOSE_ON_MODIFIED() != ACMessageBox.RESULT_OK) {
                // 「キャンセル」選択時
                // 処理を中断する。
                return false;
            }
        }

        //サービスパターンの追加削除を実行する。
        saveServicePattern();

        // 終了を許可するならばtrueを返す。
        return true;
    }

  //コンポーネントイベント

  /**
   * 「印刷処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void printWeeklyActionPerformed(ActionEvent e) throws Exception{
    // ■週間サービス計画表印刷
    // 　※週間サービス計画表を印刷する。
    // 　　渡り用パラメータ printParam(レコード)を生成し、下記の値を設定する。
    VRMap printParam = new VRHashMap();
    // 　　　KEY : PATIENT_NAME, VALUE : 利用者氏名
    VRBindPathParser.set("PATIENT_NAME",printParam, getPatientName().getText());
    // 　　　KEY : PATIENT_ID, VALUE : 利用者番号(渡りパラメータ KEY : PATIENT_IDのVALUE)
    VRBindPathParser.set("PATIENT_CODE",printParam, getPatientInfo().get("PATIENT_CODE"));
    // 　　　KEY : CREATE_DATE, VALUE : 作成年月日(週間表から取得)
    // 　　　KEY : TARGET_DATE, VALUE : 対象年月(渡りパラメータ KEY : TARGET_DATEのVALUE)
    VRBindPathParser.set("TARGET_DATE",printParam, getTargetDate());
    // 　　　KEY : WEEKLY_SERVICE, VALUE : 週間表・週単位のサービス(レコード集合)
    VRBindPathParser.set("WEEKLY_SERVICE",printParam, getWeeklyPanel().getAllWeeklySchedule());
    // 　　　KEY : NON_WEEKLY_SERVICE, VALUE : 週間表・週単位以外のサービス（レコード集合)
    VRBindPathParser.set("NON_WEEKLY_SERVICE",printParam, getWeeklyPanel().getAllFreedaySchedule());
    
    Date date=null;
    if((!ACTextUtilities.isNullText(getWeeklyPanel().getCreateDate().getText()))&&  
            getWeeklyPanel().getCreateDate().isValidDate()){
        date = getWeeklyPanel().getCreateDate().getDate();
    }
    VRBindPathParser.set("CREATE_DATE",printParam, date);
    
    VRBindPathParser.set("M_SERVICE",printParam, QkanCommon.getMasterService(getDBManager(), getTargetDate()));
    // 　　印刷を行う。
    //     doPrint(QS00101, printParam);
    ACChotarouXMLWriter writer=new ACChotarouXMLWriter();
    writer.beginPrintEdit();
    new QS001P01().doPrint(writer, printParam);
    writer.endPrintEdit();
    ACChotarouXMLUtilities.openPDF(writer);
   
  }

  /**
   * 「印刷処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void printMonthlyActionPerformed(ActionEvent e) throws Exception{
    // ■利用票・計画票印刷

      if(!getMonthlyPanel().checkPrintable()){
          return;
      }
      
      // ※「QS001031:利用・提供票印刷」画面を開く。
    // 　渡り用パラメータとして下記の値を取得する。
    // 　　処理タイプ（processType）
    // 　その他、paramに下記の情報を設定する。
    // 　　利用者情報(PATIENT_ID、氏名など)
    // 　　利用者要介護度情報(要介護度、限度額など)
    // 要介護度情報（いつの？月末？）
    // 　　対象年月(TARGET_DATE)
    // 　　月間表情報(レコード集合)
    // 　「QS001031:利用・提供票印刷」画面を生成し、affairで初期化後に表示する。
      int mode;
      if(getProcessType()==QkanConstants.PROCESS_TYPE_PLAN){
          mode = QkanConstants.SERVICE_DETAIL_GET_PLAN;
      }else{
          mode = QkanConstants.SERVICE_DETAIL_GET_RESULT;
      }
    new QS001031().showModal(getCalcurater(), 
                getMonthlyPanel().getSchedule(mode, false),
                getProcessType());

  }

  /**
     * 「DBへの登録」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void insertActionPerformed(ActionEvent e) throws Exception {
        // ■画面の情報をDBに登録する
        // ※入力チェック
        // 入力チェックを行う。
        // 戻り値がtrueの場合
        // 処理を継続する。
        if (!checkValidInput()) {
            // 戻り値がfalseの場合
            // 処理を中断する。
            return;
        }
        // ※登録処理
        // 週間表・月間表の情報をDBに登録する。
        if(doInsert()){
            //登録成功のメッセージを表示する。※ID=INSERT_SUCCESSED
            QkanMessageList.getInstance().INSERT_SUCCESSED();
            if (getProcessType() == QkanConstants.PROCESS_TYPE_PLAN) {
                // サービス予定の場合
                getMonthlyPanel().recalcServiceTotal();
            }
        }

    }

    /**
     * 「DBへの更新」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void updateActionPerformed(ActionEvent e) throws Exception {
        // ■画面の情報をDBに更新する
        // ※入力チェック
        // 入力チェックを行う。

        // 戻り値がtrueの場合
        // 処理を継続する。
        if (!checkValidInput()) {
            // 戻り値がfalseの場合
            // 　　　処理を中断する。
            return;
        }
        // ※更新処理
        // 　週間表・月間表の情報をDBに更新する。
        if(doUpdate()){
            // 登録成功のメッセージを表示する。※ID=INSERT_SUCCESSED
            QkanMessageList.getInstance().UPDATE_SUCCESSED();
            if (getProcessType() == QkanConstants.PROCESS_TYPE_PLAN) {
                // サービス予定の場合
            getMonthlyPanel().recalcServiceTotal();
            }
        }
    }

  /**
     * 「過去データ読込」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void openPlanActionPerformed(ActionEvent e) throws Exception {
        // ■過去データの中で最新のデータを画面に展開
        // ※処理実行確認
        // 処理実行の確認のため、メッセージを表示する。※メッセージID =
        // QC001_WARNING_ON_READ_OF_MOST_NEW_DATA
        // 「OK」選択時
        // 処理を継続する。
        if (QkanMessageList.getInstance()
                .QC001_WARNING_ON_READ_OF_MOST_NEW_DATA() != ACMessageBox.RESULT_OK) {
            // 「キャンセル」選択時
            // 処理を中断する。
            return;
        }
        // ※過去の直近の情報を取得
        VRMap param = new VRHashMap();
        VRBindPathParser.set("PATIENT_ID", param, new Integer(getPatientID()));
//        VRBindPathParser.set("LOGIN_PROVIDER_ID", param, QkanSystemInformation
//                .getInstance().getLoginProviderID());
        VRBindPathParser.set("TARGET_DATE", param, getTargetDate());
        VRList schedules = null;
        ACDBManager dbm = getDBManager();
        try {
            dbm.beginTransaction();
            VRList list = dbm.executeQuery(getSQL_GET_LAST_PLAN_DATE(param));
            if (list.size() > 0) {
                Object obj = VRBindPathParser.get("TARGET_DATE", (VRMap) list
                        .getData());
                if (obj instanceof Date) {
                    schedules = QkanCommon.getServiceDetail(dbm,
                            getPatientID(), (Date) obj,
                            QkanConstants.SERVICE_DETAIL_GET_PLAN_OF_WEEKLY_ONLY);
                    //ユニークキーの削除
                    Iterator it=schedules.iterator();
                    while(it.hasNext()){
                        Map service=(Map)it.next();
                        service.remove("SERVICE_ID");
                    }
                }
            }
            dbm.commitTransaction();
        } catch (Exception ex) {
            dbm.rollbackTransaction();
            throw ex;
        }
        if (schedules != null) {
//            getMonthlyPanel().setSchedule(schedules);
            getWeeklyPanel().setSchedule(schedules);
        }
    }

  /**
     * 「画面クリア」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void clearPlanActionPerformed(ActionEvent e) throws Exception {
        // ■週間表・月間表の情報をクリア(removeAll)
        // 週間表・月間表のうち、表示されている方の情報をクリアする。
        if (getMonthlyPanel().isVisible()) {
            if (QkanMessageList.getInstance().QS001_WARNING_OF_CLEAR_MONTHLY() == ACMessageBox.RESULT_OK) {
                getMonthlyPanel().clearSchedule();
            }
        } else {
            if (QkanMessageList.getInstance().QS001_WARNING_OF_CLEAR_WEEKLY() == ACMessageBox.RESULT_OK) {
                getWeeklyPanel().clearSchedule();
            }
        }
    }

    /**
     * 「予定データ読込」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void openResultActionPerformed(ActionEvent e) throws Exception {
        // ■同一対象年月の予定情報を画面に展開
        // ※処理実行確認
        // 処理実行の確認のため、メッセージを表示する。※メッセージID = QR001_READ_PLAN

        // 「OK」選択時
        // 処理を継続する。
        if (QkanMessageList.getInstance().QS001_READ_PLAN() != ACMessageBox.RESULT_OK) {
            // 「キャンセル」選択時
            // 処理を中断する。
            return;
        }
        // 予定データ読込を行なう。
        doOpenResult();
    }

    /**
     * 「画面クリア」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void clearResultActionPerformed(ActionEvent e) throws Exception {
        // ■月間表の情報をクリア
        // 月間表の情報をクリアする。
//        if (QkanMessageList.getInstance().QS001_WARNING_OF_CLEAR_MONTHLY() == ACMessageBox.RESULT_OK) {
//            getMonthlyPanel().clearSchedule();
//        }
        if (getMonthlyPanel().isVisible()) {
            if (QkanMessageList.getInstance().QS001_WARNING_OF_CLEAR_MONTHLY() == ACMessageBox.RESULT_OK) {
                getMonthlyPanel().clearSchedule();
            }
        } else {
            if (QkanMessageList.getInstance().QS001_WARNING_OF_CLEAR_WEEKLY() == ACMessageBox.RESULT_OK) {
                getWeeklyPanel().clearSchedule();
            }
        }
    }

    /**
     * 「サービス種類選択時イベント」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void serviceKindListSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // ■サービスパターン・事業所コンボの設定
        if (e.getValueIsAdjusting()) {
            return;
        }
        // ※サービスパターンの設定
        refleshServiceKind();
        int idx = getServiceKindList().getSelectedIndex();
        if(idx>=0){
            getServiceKindList().ensureIndexIsVisible(idx);
        }
        //最大パネル幅の維持
        Dimension newDM=getServiceContentSettings().getPreferredSize();
        if(newDM!=null){
            Dimension oldDM=getServicePreferredSize();
            if((oldDM==null)||(oldDM.getWidth()<newDM.getWidth())){
                    //より大きな幅を要求された
                getServuceDetails().setPreferredSize(newDM);
                setServicePreferredSize(newDM);
            }
        }
    }

    /**
     * 「サービスパターン登録」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void patternAddActionPerformed(ActionEvent e) throws Exception {
        // ■サービスパターンの登録
        VRMap service = createServiceData();
        int emptyNo = -1;
        if (service != null) {
            service = (VRMap)service.clone();
            service.setData("SERVICE_USE_TYPE",
                    QkanConstants.SERVICE_USE_TYPE_PATTERN);
            
            // 予防時対応（要望対応）
            // 2006/05 TODO
            boolean isEmptyNo = false;
            Object obj = getPatternList().getModelAtBindSource(); 
            while(obj instanceof VRListModelAdapter){
                obj = ((VRListModelAdapter)obj).getAdaptee();
            }
            if(obj instanceof VRList){                
                // リストの数ループ処理
                VRList list = ((VRList)obj);
                VRMap inMap = new VRHashMap();
                // リスト内の内部番号をinMapに格納する。
                for(int k= 0; k<list.size();k++ ){
                    VRMap map = new VRHashMap();
                    map = (VRMap)list.getData(k);
                    if(VRBindPathParser.has(ACCastUtilities.toString(QkanConstants.INTERNAL_SERVICE_PATTERN_NO_BIND_PATH),map)){
                        inMap.put(ACCastUtilities.toString(map.getData(ACCastUtilities.toString(QkanConstants.INTERNAL_SERVICE_PATTERN_NO_BIND_PATH))),"");
                    }else{
                        inMap.put(ACCastUtilities.toString(k+1),"");
                    }
                }
                
                // 採番に使う番号を取得する
                int count = 0;
                for(int j = 0;j<list.size()+1;j++){
                    count++;
                    if(!VRBindPathParser.has(ACCastUtilities.toString(j+1),inMap)){
                        // 空き番号
                        emptyNo = j+1;
                        break;
                    }
                }
                // 空き番号があるのか
                if(count <= list.size()){
                    isEmptyNo = true;
                }
                
                service.setData(ACCastUtilities.toString(QkanConstants.INTERNAL_SERVICE_PATTERN_NO_BIND_PATH),new Integer(emptyNo));
            }
            
            service.setData("REGULATION_RATE", new Integer(0));
            
            // 設定内容でサービスパターンを追加
            if(isEmptyNo){
                getNowServicePatterns().add(emptyNo-1,service);
            }else{
                getNowServicePatterns().add(service);
            }
            //ユニークキーの削除
            service.remove("SERVICE_ID");
            
            // 2008/01/24 [Masahiko_Higuchi] add - begin version 5.3.8
            service.remove("CORRECT_KEY");
            service.setData("CORRECT_KEY",new Integer(correctKey));
            correctKey++;
            // 2008/01/24 [Masahiko_Higuchi] add - end
            getInsertReserveServicePatterns().add(service);

            // サービスパターンリストを更新する。
            getPatternList().setModel(
                    new ACListModelAdapter(getNowServicePatterns()));
            // サービスパターンの選択/未選択チェックを行う。
            checkServicePatternSelected();
        }

    }

    /**
     * 「サービスパターン削除」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void patternDeleteActionPerformed(ActionEvent e) throws Exception {
        // ■サービスパターンの削除
        if (!(getPatternList().getSelectedValue() instanceof VRMap)) {
            return;
        }
        VRMap pattern = (VRMap) getPatternList().getSelectedValue();
        getNowServicePatterns().remove(pattern);
        getDeleteReseveServicePatterns().add(pattern);
        // 追加対象から削る
        getInsertReserveServicePatterns().remove(pattern);
        
        // 2008/01/24 [Masahiko_Higuchi] add - begin サービスパターン設定ボタン操作実行時エラー対応
        if(pattern.containsKey("CORRECT_KEY")){
        	// メインのキー
        	String mainKey = ACCastUtilities.toString(pattern.getData("CORRECT_KEY"),"");
        	
        	for(int i=getInsertReserveServicePatterns().size(); i>0;i--){
        		// チェック用のキー情報
        		Map checkMap = (Map)getInsertReserveServicePatterns().getData(i-1);
        		
        		if(checkMap.containsKey("CORRECT_KEY")){
        			// パターン追加で増やした情報を削るためのキー
        			String delKey = ACCastUtilities.toString(checkMap.get("CORRECT_KEY"),"-1");
        			
        			if(delKey.equals(mainKey)){
        				// 一致した場合は登録用のデータ集合がから削る
        				getInsertReserveServicePatterns().remove(i-1);
        				
        			}
        		}        		
        	}
        }
        // 2008/01/24 [Masahiko_Higuchi] add - end
        
        // サービスパターンリストを更新する。
        getPatternList().setModel(
                new ACListModelAdapter(getNowServicePatterns()));

        // サービスパターンの選択/未選択チェックを行う。
        checkServicePatternSelected();

    }

    /**
     * 「サービス内容の設定」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void serviceOfferEntrepreneurActionPerformed(ActionEvent e)
            throws Exception {
        // ■事業所コンボ選択時イベント
        // ※選択した事業所情報に応じた、サービス内容の項目の状態設定
        // 　現在設定されている「詳細項目(サービスのパネル)」に対し、選択した事業所に応じた状態設定を行う。(providerSelected)
        if (getServiceOfferEntrepreneur().isSelected()) {
            QS001Service service =  getSelectedServiceClass();
            if (service != null) {
                if (service.isUseProvider()) {
                    VRMap provider =(VRMap) getServiceOfferEntrepreneur()
                    .getSelectedModelItem(); 
                    if(service instanceof QS001ServicePanel){
                        ((QS001ServicePanel)service).setSelectedProvider(provider);
                    }
//                    getSelectedServiceClass().initialize();
                    getSelectedServiceClass().providerSelected(provider);
                }
            }
        }
    }

  /**
     * 「サービス情報上書」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void serviceSetActionPerformed(ActionEvent e) throws Exception {
        // ■週間表・月間表上のサービス情報の上書
        // ※週間表・月間表上で選択されている、サービス情報を上書する。
        VRMap service = getNowSelectedService();
        if (service != null) {
            // 選択サービスの更新
            VRMap data = createServiceData();
            if (data != null) {
                if(CareServiceCommon.isOtherService(data)){
                    //その他のサービスの場合
                    if ((!getWeeklyPanel().isWeeklyServiceList(
                            getSelectedServiceListBox()))
                            || (getWeeklyPanel()
                                    .isDailyServiceList(getSelectedServiceListBox()))) {
                        //週間のリストではない、または日常生活上の活動リストの場合
                        //何もしない。
                        return;
                    }
                }
                if(CareServiceCommon.isDailyAction(data)){
                    //主な日常生活上の活動の場合
                    if (!getWeeklyPanel().isDailyServiceList(
                            getSelectedServiceListBox())) {
                        //日常生活上の活動リストではない場合
                        //何もしない。
                        return;
                    }
                }

                if (getSelectedServiceListBox() == getWeeklyPanel()
                        .getFreedayServices()) {
                    // 週単位以外のサービスの場合

                    // サービスの期間の未入力をチェックする。
                    if ((!getWeeklyPanel().getExceptionEndCombo().isSelected())
                            || (!(getWeeklyPanel().getExceptionEndCombo()
                                    .getSelectedModelItem() instanceof VRMap))) {
                        QkanMessageList.getInstance()
                                .QS001_ERROR_OF_NO_PASTE_DAY();
                        return;
                    }

                    // サービスの開始日と期間も更新する。
                    Object obj = getWeeklyPanel().getExceptionBeginCombo()
                            .getSelectedModelItem();
                    if (obj instanceof VRMap) {
                        // 開始日
                        data.setData("WEEK_DAY", VRBindPathParser.get(
                                "CONTENT_KEY", (VRMap) obj));
                        // 日数
                        data.setData(
                                QkanConstants.SERVICE_SYSTEM_BIND_PATH_SPAN,
                                VRBindPathParser.get("CONTENT_KEY",
                                        (VRMap) getWeeklyPanel()
                                                .getExceptionEndCombo()
                                                .getSelectedModelItem()));
                    }
                } else if (getSelectedServiceListBox() == getMonthlyPanel()
                        .getDayFreeServices()) {
                    // 開始日の特定されないサービスの場合
                    // 期間を維持する
                    // 期間
                    data
                            .setData(
                                    QkanConstants.SERVICE_SYSTEM_BIND_PATH_SPAN,
                                    VRBindPathParser
                                            .get(
                                                    QkanConstants.SERVICE_SYSTEM_BIND_PATH_SPAN,
                                                    service));
                } else if (getSelectedServiceListBox() == getPatternList()) {
                    // 予防時対応（要望対応） 
                    // 2005/06
                    data
                            .setData(
                                    ACCastUtilities.toString(QkanConstants.INTERNAL_SERVICE_PATTERN_NO_BIND_PATH),
                                    VRBindPathParser
                                            .get(
                                                    ACCastUtilities.toString(QkanConstants.INTERNAL_SERVICE_PATTERN_NO_BIND_PATH),
                                                    service));
                    
                    // 2008/01/25 [Masahiko_Higuchi] add - begin サービスパターン設定ボタン操作実行時エラー対応
                    if(service.containsKey("SERVICE_USE_TYPE")){
                        Integer useType = ACCastUtilities.toInteger(service.getData("SERVICE_USE_TYPE"),-1);
                        // サービスパターンの区分は保持する
                       if(!new Integer(-1).equals(useType)){
                    	   data.setData("SERVICE_USE_TYPE",useType);
                       }
                       // サービスIDが消し去られるので保持する
                       if(service.containsKey("SERVICE_ID")){
                    	   data.setData("SERVICE_ID",service.getData("SERVICE_ID"));
                           
                    	   // 比較用のサービスIDを取得する
                           String mainServiceID = ACCastUtilities.toString(service.getData("SERVICE_ID"),"");
                           // サービスパターン追加用のデータ集合を全てチェックする。
                           for (int i = getInsertReserveServicePatterns().size(); i > 0; i--) {
                        	   Map serviceIDCheckMap = (Map)getInsertReserveServicePatterns().get(i-1);
                        	   // 格納されているキーを取得する
                        	   int idCheckKey = ACCastUtilities.toInt(serviceIDCheckMap.get("SERVICE_ID"),-2);
                        	   
                        	   String checkKey = ACCastUtilities.toString(idCheckKey);
                               // KEYが既に登録されている場合
                               if(checkKey.equals(mainServiceID)){
                            	   // クリアする
                            	   getInsertReserveServicePatterns().remove(i-1);
                               }                        	   
                           }
                       }
                       
                       // 追加したサービスパターン変更に備え内部で振ったKEYを元に登録データの重複を防ぐ
                       if(service.containsKey("CORRECT_KEY")){
                    	   
	                       data.setData("CORRECT_KEY",service.getData("CORRECT_KEY"));
	                       // 削除して追加対称にする
	                       String serviceInKey = ACCastUtilities.toString(service.getData("CORRECT_KEY"),""); 
	
	                       for(int j=getInsertReserveServicePatterns().size();j>0;j--){
	                    	   Map maps = (Map)getInsertReserveServicePatterns().getData(j-1);
	                    	   // キーを取り出す
	                           int checkKey = ACCastUtilities.toInt(maps.get("CORRECT_KEY"),-1);
	                           
	                           String strKey = ACCastUtilities.toString(checkKey);
	                           // KEYが既に登録されている場合
	                           if(strKey.equals(serviceInKey)){
	                        	   // クリアする
	                        	   getInsertReserveServicePatterns().remove(j-1);
	                           }
	                       }
                       }
                       
                       getDeleteReseveServicePatterns().add(service);
                	   // 再追加
                	   getInsertReserveServicePatterns().add(service);
                    } 
                    // サービスパターンの再設定処理
                    if(service.containsKey("11")){
                        String patternName = ACCastUtilities.toString(service.getData("11"),"");
                        if(!"".equals(patternName)){
                            data.setData("11",patternName);
                        }
                    }
                    // 2008/01/25 [Masahiko_Higuchi] add - End
                }
                
                int selectedIndex=-1;
                if(getSelectedServiceListBox()!=null){
                    selectedIndex=getSelectedServiceListBox().getSelectedIndex();
                }
                
                int rate = ACCastUtilities.toInt(
                        service.get("REGULATION_RATE"), 0);
                Object oldDate = service.get("SERVICE_DATE");

                setServiceListLockFlag(true);
                service.clear();
                service.putAll(data);
                setServiceListLockFlag(false);
                
                service.put("SERVICE_DATE", oldDate);
                
                // 変更後の割引後単位数が自費調整額を超える場合、自費調整額を割引後単位数にする。
                if (rate > 0) {
                    // 1日や1月単位の算定項目（基本夜間対応型訪問介護費など）も自費調整の対象
                    int limit = getCalcurater()
                            .getReductedUnit(
                                    service,
                                    true,
                                    CareServiceCodeCalcurater.CALC_MODE_IN_LIMIT_AMOUNT_OR_OUTER_SERVICE,
                                    null);
                    if (rate > limit) {
                        service.put("REGULATION_RATE", new Integer(limit));
                    }else{
                        service.put("REGULATION_RATE", new Integer(rate));
                    }
                }
                // 2008/01/25 [Masahiko_Higuchi] del - begin サービスパターン設定ボタン操作実行時エラー対応
                //setServiceModify(true);
                // 2008/01/25 [Masahiko_Higuchi] del - end
                
                if(getSelectedServiceListBox()!=null){
                    getSelectedServiceListBox().setSelectedIndex(selectedIndex);
                    // 2008/01/25 [Masahiko_Higuchi] add - begin サービスパターン設定ボタン操作実行時エラー対応
                    if(getSelectedServiceListBox() != getPatternList()){
                    	setServiceModify(true);
                    }
                    // 2008/01/25 [Masahiko_Higuchi] add - end
                }
                
                if (getWeeklyPanel() != null) {
                    getWeeklyPanel().invalidate();
                    getWeeklyPanel().repaint();
                }
                if (getMonthlyPanel() != null) {
                    getMonthlyPanel().invalidate();
                    getMonthlyPanel().repaint();
                }
                if (getPatternList() != null) {
                    getPatternList().invalidate();
                    getPatternList().repaint();
                }
                
            }
        }

    }

  /**
     * 「サービス情報削除」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
  protected void serviceDeleteActionPerformed(ActionEvent e) throws Exception{
    // ■週間表・月間表上のサービス情報の削除
    // ※週間表・月間表上で選択されている、サービス情報を削除する。
      removeSelectedService();
  }

  /**
   * 「週間表・月間表の切替」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void changeChartActionPerformed(ActionEvent e) throws Exception{
    // ■週間表・月間表の表示切替
      if(getWeeklyPanel().isVisible()){
    // 　現在表示されているのが週間表の場合
    // 　　月間表表示処理を行う。
    showMonthly();
      }else{
    // 　現在表示されているのが月間表の場合
    // 　　週間表表示処理を行う。
    showWeekly();
      }
      clearServiceSelection();
  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();

    //テストパラメタ
    VRMap param = new VRHashMap();
//    param.setData("TARGET_DATE", new Date(106,0,8));
    QkanSystemInformation.getInstance().setLoginProviderID("5555555555");
    param.setData("TARGET_DATE", new Date(106,3,1));
//    param.setData("PATIENT_ID", new Integer(38));
    param.setData("PATIENT_ID", new Integer(51));
    param.setData("PROCESS_TYPE", new Integer(QkanConstants.PROCESS_TYPE_PLAN));
//    param.setData("PROCESS_TYPE", new Integer(QkanConstants.PROCESS_TYPE_RESULT));
    
    ACFrame.debugStart(new ACAffairInfo(QS001.class.getName(), param));
  }

  //内部関数

  /**
     * 「入力チェック」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public boolean checkValidInput() throws Exception {
        VRList list = new VRArrayList();
        list.addAll(getMonthlyPanel().getSchedule(
                QkanConstants.SERVICE_DETAIL_GET_RESULT, false));
        Iterator it = list.iterator();
        
        // 2008/03/21 [Masahiko_Higuchi] add - begin 平成20年度4月法改正対応（介護療養型老人保健施設）
        // バインドパスの変更により追加
        // 療養環境減算バインドパス郡
        final String[] RYOYO_TYPE = new String[] {"1230205","1260205","1530205"};
        // 設備基準バインドバス郡
        final String[] SETUBI_BASE_TYPE = new String[] {"1230252","1260212","1530260"};
        // H20年4月以降が対象年月の処理であるか
        boolean isH2004 = false;
        if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2004,
                getCalcurater().getTargetDate()) < 1) {
            isH2004 = true;
        }
        // 2008/03/21 [Masahiko_Higuchi] add - end
        
        // 2008/04/21 [Masahiko_Higuchi] add - begin 平成20年度5月法改正対応（介護療養型老人保健施設）
        boolean isH2005 = false;
        if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2005,
                getCalcurater().getTargetDate()) < 1) {
            isH2005 = true;
        }
        final String[] SHISETUKUBUN_TAISEI = new String[] {"1220120","1520132","1250113"};
        final String[] RYOYOTAISEIIJI = new String[] {"1220121","1520134","1250114"};
        final String[] TERMINAlCARE = new String[] {"1520133"};
        // 2008/04/21 [Masahiko_Higuchi] add - end
        
        // [ID:0000444][Masahiko Higuchi] 2009/03 add begin 平成21年4月法改正対応
        boolean isH2104  =false;
        if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104,
                getCalcurater().getTargetDate()) < 1) {
            isH2104 = true;
        }
        // [ID:0000444][Masahiko Higuchi] 2009/03 add end        
        
        // ■入力チェック
        final String[] SENMONIN_NO_TYPE = new String[] { "1430107", "1730104",
                "1750104","1460103" };
        // 予防時対応（要望）
        // 2005/05/31
        // ※介護支援専門員番号が未入力の場合の未入力チェック
        while (it.hasNext()) {
            VRMap row = (VRMap) it.next();
            if(CareServiceCommon.isCareManagement(row)||CareServiceCommon.isFacilityVisitMultifunction(row)){
                // 初期化＋宣言
                boolean isInputSenmoninNo = false;
                // 介護支援専門員番号の数だけループ処理
                for (int i = 0; i < SENMONIN_NO_TYPE.length; i++) {
                Object obj = VRBindPathParser.get(SENMONIN_NO_TYPE[i], row);
                    // 介護支援専門員番号テキストの状態を走査
                    if (!ACTextUtilities.isNullText(obj)) {
                        isInputSenmoninNo = true;
                        // 処理を抜ける
                        break;
                    }
                }
                // 専門員番号が入力されていなかった場合
                if(!isInputSenmoninNo){
                    // エラーメッセージを表示する。
                    if(QkanMessageList.getInstance().QS001_WARNING_OF_SENMONIN_NO()==ACMessageBox.RESULT_OK){
                        // 1度メッセージを出したらもう出さない
                        break;
                    }else{
                        // OK以外は処理を中止
                        return false;
                    }

                }
            }
            
            // [ID:0000456][Masahiko Higuchi] 2009/03 edit begin 平成21年4月法改正対応
            // 平成21年4月以降の処理は分岐させる
            int lowVer = CareServiceCommon.getServiceLowVersion(row);
            if(isH2104) {
                //平成21年4月以降の場合
                // 法改正区分による過去データの判別
                if(lowVer != QkanConstants.SERVICE_LOW_VERSION_H2104){
                    //法改正区分が20090401以外のサービスの場合
                    Date serviceDate = ACCastUtilities.toDate(VRBindPathParser
                            .get("SERVICE_DATE", row), null);
                    String dayOfMonth = "";
                    if (serviceDate != null) {
                        dayOfMonth = ACDateUtilities.getDayOfMonth(serviceDate)
                                + "日の";
                    }
                    VRMap serviceKind = ACBindUtilities.getMatchRowFromValue(
                            getServiceKindsList(),
                            "SYSTEM_SERVICE_KIND_DETAIL", row
                                    .get("SYSTEM_SERVICE_KIND_DETAIL"));
                    String serviceKindName = "サービス";
                    if (serviceKind != null) {
                        serviceKindName = ACCastUtilities.toString(serviceKind
                                .get("SERVICE_ABBREVIATION"));
                    }
                    // エラーメッセージ
                    QkanMessageList.getInstance().QS001_ERROR_OF_INVALID_SERVICE_LOW_VERSION(dayOfMonth, serviceKindName);
                    return false;
                } 
            } else {
                //平成21年4月より前の場合
                // 法改正区分による過去データの判別
                if(lowVer == QkanConstants.SERVICE_LOW_VERSION_H2104) {
                    //法改正区分が20090401のサービスの場合
                    Date serviceDate = ACCastUtilities.toDate(VRBindPathParser
                            .get("SERVICE_DATE", row), null);
                    String dayOfMonth = "";
                    if (serviceDate != null) {
                        dayOfMonth = ACDateUtilities.getDayOfMonth(serviceDate)
                                + "日の";
                    }
                    VRMap serviceKind = ACBindUtilities.getMatchRowFromValue(
                            getServiceKindsList(),
                            "SYSTEM_SERVICE_KIND_DETAIL", row
                                    .get("SYSTEM_SERVICE_KIND_DETAIL"));
                    String serviceKindName = "サービス";
                    if (serviceKind != null) {
                        serviceKindName = ACCastUtilities.toString(serviceKind
                                .get("SERVICE_ABBREVIATION"));
                    }
                    // エラーメッセージ
                    QkanMessageList.getInstance().QS001_ERROR_OF_INVALID_SERVICE_LOW_VERSION(dayOfMonth, serviceKindName);
                    return false;
                } 
                
                // 2008/03/21 [Masahiko_Higuchi] add - begin 平成20年度4月法改正対応（介護療養型老人保健施設）
                // 過去データからの不正データを残さないようにチェックする
                if(isH2004){
                    // 療養病床を有する診療所のサービスであるか
                    if(CareServiceCommon.isPracticeToHealthFacilityServices(row)){
                        // 療養環境減算が存在するか。
                        boolean isRyoyoGensan = false;
                        boolean isSetubiGensan = false;
                        for(int j=0; j< RYOYO_TYPE.length; j++){
                            // 療養環境減算が設定されているか。
                            Object obj = VRBindPathParser.get(RYOYO_TYPE[j], row);
                            // 未設定、減算型Ⅰ以外の場合は正常
                            if (obj != null && ACCastUtilities.toInt(obj) != 2
                                    && ACCastUtilities.toInt(obj) != 0) {
                                isRyoyoGensan = true;
                                break;
                            }
                        }
                        // 設備基準減算が存在するか。
                        for(int k=0; k< SETUBI_BASE_TYPE.length; k++){
                            // 設備基準減算が設定されているか。
                            Object obj = VRBindPathParser.get(SETUBI_BASE_TYPE[k], row);
                            // 設備基準に値が設定されている場合は
                            if(ACCastUtilities.toInt(obj,0) != 0){
                                isSetubiGensan = true;
                                break;                            
                            }
                        }
                        // どちらか一方でも不正データである場合
                        if(!(isRyoyoGensan && isSetubiGensan)){
                            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                            return false;
                        }
                    }
                }
                // 2008/03/21 [Masahiko_Higuchi] add - end
                // 2008/04/21 [Masahiko_Higuchi] add - begin 平成20年度5月法改正対応（介護療養型老人保健施設）
                if(isH2005){
                    // 老健施設のサービスである場合
                    if(CareServiceCommon.isElderlyToHealthFacilityServices(row)){
                        boolean isShisetuTaisei = false;
                        boolean isRyoyoTaisei = false;
                        isRyoyoTaisei = checkValidSysteBindPath(RYOYOTAISEIIJI, row);
                        // 日帰りショートステイ選択時は施設等の区分のチェックはスルー
                        if(row != null && ACCastUtilities.toInt(row.getData("1220101"),0) == 3){
                            isShisetuTaisei = true;
                        }else{
                            // 施設等の区分（体制）のチェック処理
                            isShisetuTaisei = checkValidSysteBindPath(SHISETUKUBUN_TAISEI, row);
                        }
                        // エラーメッセージ
                        if(!isShisetuTaisei && !isRyoyoTaisei){
                            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                            return false;
                        }
                        
                    }
                    // 個別に取り出す
                    int code = -1;
                    if(row==null){
                        code = -1;
                    }else{
                        code = ACCastUtilities.toInt(row.get("SYSTEM_SERVICE_KIND_DETAIL"),-1);
                    }
                    // 介護老人保健施設であるか
                    switch(code){
                    case 15211:
                        boolean isTerminalAdd = false;
                        isTerminalAdd = checkValidSysteBindPath(TERMINAlCARE, row);
                        // ターミナルケア加算のみ個別チェック
                        if(!isTerminalAdd){
                            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                            return false;
                        }
                        
                        int index = ACCastUtilities.toInt(row.getData("1520101"), 0);
                        if (index != 1 && index != 3) {
                            // 施設等の区分で小規模のデータ登録を行おうとした場合
                            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                            return false;
                        }
                        break;
                    }
                    
                }
                // 2008/04/21 [Masahiko_Higuchi] add - end            
                
            }
            // [ID:0000456][Masahiko Higuchi] 2009/03 edit end
        }

        // [ID:0000456][Tozo TANAKA] 2009/03/12 add begin 平成21年4月法改正対応
        //※回数チェック
        if (isH2104) {
            //対象年月が、平成21年4月以降の場合
            //※居宅介護支援・回数チェック
            
            //居宅介護支援の検出回数を表す数値変数countOf14311を定義し、0で初期化する。
            int countOf14311 = 0;
            //介護予防支援の検出回数を表す数値変数countOf14611を定義し、0で初期化する。
            int countOf14611 = 0;
            final String BIND_PATH_OF_SYSTEM_SERVICE_KIND_DETAIL = "SYSTEM_SERVICE_KIND_DETAIL";
    
            //月間表上のサービスを全走査する。
            it = list.iterator();
            while (it.hasNext()) {
                VRMap row = (VRMap) it.next();
                //エラーとなったサービス名を表す文字列変数errorServiceを定義し、nullで初期化する。
                String errorService=null;
                switch (ACCastUtilities.toInt(VRBindPathParser.get(
                        BIND_PATH_OF_SYSTEM_SERVICE_KIND_DETAIL, row), 0)) {
                case 14311:
                    //サービスが居宅介護支援の場合
                    //countOf14311に1を加算する。
                    if(++countOf14311>=2){
                        //countOf14311が2以上の場合
                        //errorServiceに"居宅介護支援"を代入する。
                        errorService = "居宅介護支援";
                    }
                    break;
                case 14611:
                    //サービスが介護予防支援の場合
                    //countOf14611に1を加算する。
                    if(++countOf14611>=2){
                        //countOf14611が2以上の場合
                        //errorServiceに"介護予防支援"を代入する。
                        errorService = "介護予防支援";
                    }
                    break;
                }
                if(errorService!=null){
                    //errorServiceがnullではない場合
                    //上限回数を超えている旨のエラー(ERROR_OF_SERVICE_COUNT_OVER)を表示する。
                    QkanMessageList.getInstance().QS001_ERROR_OF_SERVICE_COUNT_OVER(errorService, new Integer(1));
                    //戻り値falseを返して処理を終了する。
                    return false;
                }
            }
            
            //※その他の回数超過警告チェック

            //月n回を上限とする加算
            String[][] monthlyAddCountChecks = new String[][]{
                    //SERVICE_NAME,SYSTEM_SERVICE_KIND_DETAIL,加算名,SYSTEM_BIND_PATH,計上する値,上限
                    //※通所介護・通所リハ
                    //栄養改善加算：月2回
                    //口腔機能：月2回
                    {"通所介護","11511","栄養改善加算","1150116","2","2",},
                    {"通所介護","11511","口腔機能向上加算","1150112","2","2",},
                    {"通所リハ","11611","栄養改善加算","1160114","2","2",},
                    {"通所リハ","11611","口腔機能向上加算","1160115","2","2",},
                    {"認知症対応型通所介護","17211","栄養改善加算","1720105","2","2",},
                    {"認知症対応型通所介護","17211","口腔機能向上加算","1720108","2","2",},
                    //※通所リハ
                    //個別リハ加算：月13回
                    {"通所リハ","11611","個別リハビリ実施加算","1160118","2","13",},
                    //※居宅介護支援
                    //医療連携加算：月1回(居宅介護支援自体、ひと月に2個配置したらエラーになる)
                    //{"居宅介護支援","14311","医療機関連携加算","1430109","2","1",},
            };
            //週n回を上限とするサービス
            String[][] weeklyServiceCountChecks = new String[][]{
                    //SERVICE_NAME,SYSTEM_SERVICE_KIND_DETAIL,上限
                    //※訪問リハ
                    //1週間に6回
                    {"訪問リハ","11411","6",},
            };
            
            //月n日を上限とする加算
            String[][] monthlyDayAddCountChecks = new String[][]{
                    //SERVICE_NAME,SYSTEM_SERVICE_KIND_DETAIL,加算名,SYSTEM_BIND_PATH,計上する値,上限
                    //※特養・老健・療養型
                    //外泊：月6日
                    {"介護老人福祉施設","15111","外泊加算","1510111","2","6",},
                    {"介護老人保健施設","15211","外泊加算","1520107","2","6",},
                    {"介護療養型医療施設(病院療養型)","15311","外泊加算","1530108","2","6",},
                    {"介護療養型医療施設(診療所型)","15312","外泊加算","1530206","2","6",},
                    {"介護療養型医療施設(認知症疾患型)","15313","外泊加算","1530305","2","6",},
            };
            int[] monthlyAddCountResults = new int[monthlyAddCountChecks.length];
            int[][] weeklyServiceCountResults = new int[weeklyServiceCountChecks.length][6];
            int[] monthlyDayAddCountResults = new int[monthlyDayAddCountChecks.length];
            boolean[][] monthlyDayAddFindFlags = new boolean[monthlyDayAddCountChecks.length][32];

            int end;
            end = monthlyAddCountChecks.length;
            for(int i=0; i<end; i++){
                monthlyAddCountResults[i] = ACCastUtilities.toInt(monthlyAddCountChecks[i][5]);
            }
            end = weeklyServiceCountChecks.length;
            for(int i=0; i<end; i++){
                int limit = ACCastUtilities.toInt(weeklyServiceCountChecks[i][2]);
                for(int j=0; j<6; j++){
                    weeklyServiceCountResults[i][j] = limit;
                }
            }
            end = monthlyDayAddCountChecks.length;
            for(int i=0; i<end; i++){
                monthlyDayAddCountResults[i] = ACCastUtilities.toInt(monthlyDayAddCountChecks[i][5]);
            }
            
            //月間表上のサービスを全走査する。
            it = list.iterator();
            while (it.hasNext()) {
                VRMap row = (VRMap) it.next();
                
                String systemServiceKindDetail = ACCastUtilities.toString(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL", row));
                Date visitDay = ACCastUtilities.toDate(VRBindPathParser.get("SERVICE_DATE", row), null);

                //警告メッセージの要素として以下の文字列変数を定義しnullで初期化する。
                //warningTargetName
                String warningTargetName = null;
                //warningTargetSpan
                String warningTargetSpan = null;
                //warningTargetLimit
                String warningTargetLimit = null;
                
                //月n回を上限とする加算をチェックする。
                end = monthlyAddCountChecks.length;
                for(int i=0; i<end; i++){
                    if(monthlyAddCountChecks[i][1].equals(systemServiceKindDetail)){
                        //システムサービス種類が該当した場合
                        Object val=VRBindPathParser.get(monthlyAddCountChecks[i][3], row);
                        if(val != null){
                            //BindPathも該当した場合
                            if(monthlyAddCountChecks[i][4].equals(ACCastUtilities.toString(val))){
                                //計上すべき値も該当した場合
                                //月単位加算残回数に1を減算する。
                                monthlyAddCountResults[i]--;
                                if(monthlyAddCountResults[i]==-1){
                                    //月単位加算残回数が0を下回った場合
                                    
                                    //警告メッセージの要素として以下の変数を代入する。
                                    //warningTargetName = SERVICE_NAME+"の"+加算名
                                    warningTargetName = monthlyAddCountChecks[i][0]+"の"+monthlyAddCountChecks[i][2];
                                    //warningTargetName = "ひと月に"
                                    warningTargetSpan = "ひと月に";
                                    //warningTargetLimit = 上限+"回まで"
                                    warningTargetLimit = monthlyAddCountChecks[i][5]+"回まで";

                                    //警告メッセージQS001_WARNING_OF_SERVICE_COUNT_OVERを表示する。
                                    if (QkanMessageList.getInstance()
                                            .QS001_WARNING_OF_SERVICE_COUNT_OVER(
                                                    warningTargetName, warningTargetSpan,
                                                    warningTargetLimit) != ACMessageBox.RESULT_OK) {
                                        // 「OK」以外選択時
                                        // 戻り値としてfalseを返す。
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }

                //週n回を上限とするサービスをチェックする。
                end = weeklyServiceCountChecks.length;
                for(int i=0; i<end; i++){
                    if(weeklyServiceCountChecks[i][1].equals(systemServiceKindDetail)){
                        //システムサービス種類が該当した場合
                        if (visitDay != null) {
                            //週単位加算残回数の当該週目に1を減算する。
                            int week = ACDateUtilities.getWeekOfMonth(visitDay);
                            weeklyServiceCountResults[i][week]--;
                            if(weeklyServiceCountResults[i][week]==-1){
                                //週単位残回数が0を下回った場合
                                
                                //警告メッセージの要素として以下の変数を代入する。
                                //warningTargetName = SERVICE_NAME
                                warningTargetName = weeklyServiceCountChecks[i][0];
                                //warningTargetName = "各週に"
                                warningTargetSpan = "各週に";
                                //warningTargetLimit = 上限+"回まで"
                                warningTargetLimit = weeklyServiceCountChecks[i][2]+"回まで";

                                //警告メッセージQS001_WARNING_OF_SERVICE_COUNT_OVERを表示する。
                                if (QkanMessageList.getInstance()
                                        .QS001_WARNING_OF_SERVICE_COUNT_OVER(
                                                warningTargetName, warningTargetSpan,
                                                warningTargetLimit) != ACMessageBox.RESULT_OK) {
                                    // 「OK」以外選択時
                                    // 戻り値としてfalseを返す。
                                    return false;
                                }
                            }
                        }
                    }
                }
                
                //月n日を上限とする加算をチェックする。
                end = monthlyDayAddCountChecks.length;
                for(int i=0; i<end; i++){
                    if(monthlyDayAddCountChecks[i][1].equals(systemServiceKindDetail)){
                        //システムサービス種類が該当した場合
                        Object val=VRBindPathParser.get(monthlyDayAddCountChecks[i][3], row);
                        if(val != null){
                            //BindPathも該当した場合
                            if(monthlyDayAddCountChecks[i][4].equals(ACCastUtilities.toString(val))){
                                //計上すべき値も該当した場合
                                int mday = ACDateUtilities.getDayOfMonth(visitDay);
                                if (!monthlyDayAddFindFlags[i][mday]) {
                                    //月単位日別加算発見フラグの当該日が偽(未発見)の場合
                                    //月単位日別加算発見フラグの当該日を真(発見済)にする。
                                    monthlyDayAddFindFlags[i][mday] = true;
                                    //月単位日別加算残回数に1を減算する。
                                    monthlyDayAddCountResults[i]--;
                                    if(monthlyDayAddCountResults[i]==-1){
                                        //月単位日別加算残回数が0を下回った場合
                                        
                                        //警告メッセージの要素として以下の変数を代入する。
                                        //warningTargetName = SERVICE_NAME+"の"+加算名
                                        warningTargetName = monthlyDayAddCountChecks[i][0]+"の"+monthlyDayAddCountChecks[i][2];
                                        //warningTargetName = "ひと月に"
                                        warningTargetSpan = "ひと月に";
                                        //warningTargetLimit = 上限+"日まで"
                                        warningTargetLimit = monthlyDayAddCountChecks[i][5]+"日まで";

                                        //警告メッセージQS001_WARNING_OF_SERVICE_COUNT_OVERを表示する。
                                        if (QkanMessageList.getInstance()
                                                .QS001_WARNING_OF_SERVICE_COUNT_OVER(
                                                        warningTargetName, warningTargetSpan,
                                                        warningTargetLimit) != ACMessageBox.RESULT_OK) {
                                            // 「OK」以外選択時
                                            // 戻り値としてfalseを返す。
                                            return false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                
            }
        }
        // [ID:0000456][Tozo TANAKA] 2009/03/12 add end
        
        
        it = list.iterator();

        // [ID:0000456][Masahiko Higuchi] 2009/03 edit begin 平成21年4月法改正対応
        int overFlowCount = 0;
        int overflowIndex = -1;
        
        if (isH2104) {
            // ※居宅療養管理指導・回数チェック
            // 居宅療養管理指導サービスのサービス回数をチェックする(月間表)。それぞれの上限回数は下記のとおりとする。
            // 医師・歯科医師 : 2回
            // 薬剤師(医療機関) : 2回
            // 薬剤師(薬局) : 2回
            // 管理栄養士 : 2回
            // 歯科衛生士等 : 4回
            // 看護職員：1回
            // ガン末期の場合は以下を上限とする。
            // 薬剤師(医療機関)ガン末期 : 4回
            // 薬剤師(薬局)ガン末期 : 8回
            // かつ週2回まで
    
            final Integer VISITOR_TYPE_PATH = new Integer(1310111);
            final Integer GAN_PATH = new Integer(1310110);
    
            final int VISITOR_TYPE_COUNT = 8;
            // [職員区分][第n週]の訪問回数
            int[][] weeklyCounts = new int[VISITOR_TYPE_COUNT][8];
            // [職員区分]の月間訪問回数
            int[] visitCounts = new int[VISITOR_TYPE_COUNT];
            // [職員区分]のがん末期フラグ
            int[] ganFlags = new int[VISITOR_TYPE_COUNT];
    
            while (it.hasNext()) {
                VRMap row = (VRMap) it.next();
                // 居宅療養管理指導の職員区分を取得
                Object obj = VRBindPathParser.get(VISITOR_TYPE_PATH, row);
                if (obj != null) {
                    int idx = ACCastUtilities.toInt(obj, 0);
                    // 月単位の訪問回数
                    visitCounts[idx]++;
    
                    Object gan = VRBindPathParser.get(GAN_PATH, row);
                    if ("2".equals(ACCastUtilities.toString(gan))) {
                        // ガン末期
                        ganFlags[idx] = 1;
                    }
    
                    Date visitDay = ACCastUtilities.toDate(VRBindPathParser.get(
                            "SERVICE_DATE", row), null);
                    if (visitDay != null) {
                        // 第n週の訪問回数
                        weeklyCounts[idx][ACDateUtilities.getWeekOfMonth(visitDay)]++;
                    }
                }
            }

            int[][] limits = new int[][] { {// ガン末期を含まない場合
                    0,// ダミー
                            2, // 医師
                            2, // 歯科医師
                            2, // 薬剤師(医療機関)
                            4, // 薬剤師(薬局)
                            2, // 管理栄養士
                            4, // 歯科衛生士等
                            1, // 看護職員
                    }, {// ガン末期を含む場合
                    0,// ダミー
                            2, // 医師
                            2, // 歯科医師
                            2, // 薬剤師(医療機関)
                            8, // 薬剤師(薬局)
                            2, // 管理栄養士
                            4, // 歯科衛生士等
                            1, // 看護職員
                    } };
            int end = visitCounts.length;
            for (int i = 1; i < end; i++) {
                if ((visitCounts[i] > limits[ganFlags[i]][i])) {
                    // 月内の上限訪問回数を超えたサービス
                    overFlowCount = visitCounts[i];
                    overflowIndex = i;
                    break;
                } else {
                    // 週単位でチェック
                    int end2 = weeklyCounts[i].length;
                    for (int j = 1; j < end2; j++) {
                        if (weeklyCounts[i][j] > 2) {
                            // 週単位の上限訪問回数を超えたサービス
                            overFlowCount = visitCounts[i];
                            overflowIndex = i;
                            break;
                        }
                    }
                }
            }   
            
        } else {
                
            // ※居宅療養管理指導・回数チェック
            // 居宅療養管理指導サービスのサービス回数をチェックする(月間表)。それぞれの上限回数は下記のとおりとする。
            // 医師・歯科医師 : 2回
            // 薬剤師(医療機関) : 2回
            // 薬剤師(薬局) : 4回
            // 管理栄養士 : 2回
            // 歯科衛生士等 : 4回
            // H18年4月法改正により、ガン末期の場合は以下を上限とする。
            // 薬剤師(医療機関)ガン末期 : 8回
            // 薬剤師(薬局)ガン末期 : 8回
            // かつ週2回まで
    
            final Integer VISITOR_TYPE_PATH = new Integer(1310103);
            final Integer GAN_PATH = new Integer(1310110);
    
            final int VISITOR_TYPE_COUNT = 7;
            // [職員区分][第n週]の訪問回数
            int[][] weeklyCounts = new int[VISITOR_TYPE_COUNT][7];
            // [職員区分]の月間訪問回数
            int[] visitCounts = new int[VISITOR_TYPE_COUNT];
            // [職員区分]のがん末期フラグ
            int[] ganFlags = new int[VISITOR_TYPE_COUNT];
    
            while (it.hasNext()) {
                VRMap row = (VRMap) it.next();
                // 居宅療養管理指導の職員区分を取得
                Object obj = VRBindPathParser.get(VISITOR_TYPE_PATH, row);
                if (obj != null) {
                    int idx = ACCastUtilities.toInt(obj, 0);
                    // 月単位の訪問回数
                    visitCounts[idx]++;
    
                    Object gan = VRBindPathParser.get(GAN_PATH, row);
                    if ("2".equals(ACCastUtilities.toString(gan))) {
                        // ガン末期
                        ganFlags[idx] = 1;
                    }
    
                    Date visitDay = ACCastUtilities.toDate(VRBindPathParser.get(
                            "SERVICE_DATE", row), null);
                    if (visitDay != null) {
                        // 第n週の訪問回数
                        weeklyCounts[idx][ACDateUtilities.getWeekOfMonth(visitDay)]++;
                    }
                }
            }

            int[][] limits = new int[][] { {// ガン末期を含まない場合
                    0,// ダミー
                            2, // 医師
                            2, // 歯科医師
                            2, // 薬剤師(医療機関)
                            4, // 薬剤師(薬局)
                            2, // 管理栄養士
                            4, // 歯科衛生士等
                    }, {// ガン末期を含む場合
                    0,// ダミー
                            2, // 医師
                            2, // 歯科医師
                            8, // 薬剤師(医療機関)
                            8, // 薬剤師(薬局)
                            2, // 管理栄養士
                            4, // 歯科衛生士等
                    } };
            int end = visitCounts.length;
            for (int i = 1; i < end; i++) {
                if ((visitCounts[i] > limits[ganFlags[i]][i])) {
                    // 月内の上限訪問回数を超えたサービス
                    overFlowCount = visitCounts[i];
                    overflowIndex = i;
                    break;
                } else {
                    // 週単位でチェック
                    int end2 = weeklyCounts[i].length;
                    for (int j = 1; j < end2; j++) {
                        if (weeklyCounts[i][j] > 2) {
                            // 週単位の上限訪問回数を超えたサービス
                            overFlowCount = visitCounts[i];
                            overflowIndex = i;
                            break;
                        }
                    }
                }
            }
        }
        // [ID:0000456][Masahiko Higuchi] 2009/03 edit end
        
        if (overflowIndex < 0) {
            // 上限を超えたものがない場合
            // 戻り値としてtrueを返す。
            return true;
        } else {
            // 上限を超えたものがある場合
            // ※メッセージを表示する。
            // メッセージを表示する。(例)管理栄養士(上限2回)が、3回設定されている場合、VALUEは「管理栄養士 3回」となる。)
            // showMsg(QS001_LIMIT_OVER_KYOTAKU_RYOYO_KANRI_SHIDO,
            // ((上限回数を超えた項目名) + (回数) + 回));
            // [ID:0000456][Masahiko Higuchi] 2009/03 edit begin 平成21年4月法改正対応
            String[] names = {""};
            if(isH2104) {
                // 平成21年4月以降は区分が追加される
                names = new String[] {"", "医師", "歯科医師", "薬剤師(医療機関)",
                        "薬剤師(薬局)", "管理栄養士", "歯科衛生士等", "看護職員" , };                
            } else { 
                names = new String[] {"", "医師", "歯科医師", "薬剤師(医療機関)",
                    "薬剤師(薬局)", "管理栄養士", "歯科衛生士等", };
            }
            // [ID:0000456][Masahiko Higuchi] 2009/03 edit end
            if (QkanMessageList.getInstance()
                    .QS001_LIMIT_OVER_KYOTAKU_RYOYO_KANRI_SHIDO(
                            names[overflowIndex] + " " + overFlowCount + "回") == ACMessageBox.RESULT_OK) {
                // 「OK」選択時
                // 戻り値としてtrueを返す。
                return true;
            } else {
                // 「キャンセル」選択時
                // 戻り値としてfalseを返す。
                return false;
            }
        }
    }

  /**
     * 「検索処理」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void doFind() throws Exception {
        // ■DBから週間表・月間表情報を取得

        if (getProcessType() == QkanConstants.PROCESS_TYPE_PLAN) {
            // 処理タイプ(processType)が予定（PROCESS_TYPE_PLAN）の場合
            // ※選択された利用者の、対象年月分の予定情報の設定
            // 選択された利用者の、対象年月分の予定情報を取得する。
            ACDBManager dbm = getDBManager();
            VRList schedules;
            try {
                dbm.beginTransaction();
                schedules = QkanCommon.getServiceDetail(dbm, getPatientID(),
                        getTargetDate(), QkanConstants.SERVICE_DETAIL_GET_PLAN);
                dbm.commitTransaction();
            } catch (Exception ex) {
                dbm.rollbackTransaction();
                throw ex;
            }
            // 取得した情報を「週間表」「月間表」に設定する。
            getMonthlyPanel().setSchedule(schedules);
            getWeeklyPanel().setSchedule(schedules);
        } else if (getProcessType() == QkanConstants.PROCESS_TYPE_RESULT) {
            // 処理タイプ(processType)が実績（PROCESS_TYPE_RESULT）の場合
            // ※選択された利用者の、対象年月分の実績情報の設定
            // 選択された利用者の、対象年月分の実績情報を取得する。
            ACDBManager dbm = getDBManager();
            VRList schedules;
            try {
                dbm.beginTransaction();
                schedules = QkanCommon.getServiceDetail(dbm, getPatientID(),
                        getTargetDate(),
                        QkanConstants.SERVICE_DETAIL_GET_RESULT);
                dbm.commitTransaction();
            } catch (Exception ex) {
                dbm.rollbackTransaction();
                throw ex;
            }
            // 取得した情報を「月間表」に設定する。

            getMonthlyPanel().setSchedule(schedules);
            getWeeklyPanel().setSchedule(schedules);
            

            // ※計画単位数を取得
            VRMap planUnits = new VRHashMap();
            Iterator it = schedules.iterator();
            while (it.hasNext()) {
                // 取得した情報を走査し、システム管理サービスを含むかを調べる。
                VRMap row = (VRMap) it.next();
                if (CareServiceCommon.isPlanUnitService(row)) {
                    // システム管理サービスを発見した場合
                    Object obj  = VRBindPathParser.get("PROVIDER_ID", row);
                    if(obj != null){
                        //事業所番号がnullでない場合
                        planUnits.setData(obj, row);
                    }
                }
            }
            getMonthlyPanel().setServicePlanUnits(planUnits);
        }
    }

    /**
     * 「登録処理」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
   * @return boolean
     */
    public boolean doInsert() throws Exception {
        return doUpdateImpl(true);
    }
    
    /**
     * 「データ更新処理」に関する処理を行ないます。
     *
     * @param isInsert boolean
     * @throws Exception 処理例外
     * @return boolean
     */
    public boolean doUpdateImpl(boolean insertMode) throws Exception {
        // ■週間表・月間表情報をDBに登録

        try {
            ACFrameEventProcesser processer = ACFrame.getInstance()
                    .getFrameEventProcesser();
            ACSplashable splash;
            if (processer != null) {
                splash = processer.createSplash("保存処理");
            }

            VRList details = new VRArrayList();
            int insertUseType = 0;
            if (getProcessType() == QkanConstants.PROCESS_TYPE_PLAN) {
                insertUseType = QkanConstants.SERVICE_DETAIL_GET_PLAN;
                // 月間表・週間表からdetailsを取る
                details.addAll(getWeeklyPanel().getSchedule());
                details.addAll(getMonthlyPanel().getSchedule(
                        QkanConstants.SERVICE_DETAIL_GET_PLAN, true));
            } else if (getProcessType() == QkanConstants.PROCESS_TYPE_RESULT) {
                insertUseType = QkanConstants.SERVICE_DETAIL_GET_RESULT;
                // 月間表からdetailsを取る
                details.addAll(getWeeklyPanel().getSchedule());
                details.addAll(getMonthlyPanel().getSchedule(
                        QkanConstants.SERVICE_DETAIL_GET_RESULT, true));
                
                // 計画単位数を保存する。
                Iterator it = getMonthlyPanel().getServicePlanUnits().values().iterator();
                while (it.hasNext()) {
                    VRMap planUnits = (VRMap) it.next();
                    if ((planUnits != null) && (!planUnits.isEmpty())) {
                        final Integer zero = new Integer(0);
                        VRMap systemService = new VRHashMap();
                        VRBindPathParser
                                .set(
                                        "SERVICE_USE_TYPE",
                                        systemService,
                                        QkanConstants.SERVICE_USE_TYPE_RESULT_MONTHLY_DAY);
                        VRBindPathParser.set("PROVIDER_ID", systemService, "");
                        VRBindPathParser
                                .set(
                                        "SYSTEM_SERVICE_KIND_DETAIL",
                                        systemService,
                                        QkanConstants.SERVICE_KIND_DETAIL_SYSTEM_SERVICE);
                        VRBindPathParser.set("SERVICE_DATE", systemService,
                                getTargetDate());
                        VRBindPathParser.set("WEEK_DAY", systemService, zero);
                        VRBindPathParser.set("REGULATION_RATE", systemService,
                                zero);
                        systemService.putAll(planUnits);
                        details.add(systemService);
                    }
                }
            }

            // 共通パラメタを設定する。
            Iterator it = details.iterator();
            while (it.hasNext()) {
                VRMap row = (VRMap) it.next();
                try{
                    VRBindPathParser.set("PATIENT_ID", row, new Integer(
                        getPatientID()));
                }catch(java.util.ConcurrentModificationException ex){
                    //イテレーションの同期例外は無視
                }
            }

            ACDBManager dbm = getDBManager();
            try {
                dbm.beginTransaction();
                getPassiveChecker().clearPassiveTask();
                if (insertMode) {
                    // 登録モードの場合
                    getPassiveChecker().addPassiveInsertTask(
                            getSERVICE_PASSIVE_CHECK_KEY(),
                            getPassiveCheckSQLParam());
                } else {
                    // 更新モードの場合
                    getPassiveChecker().addPassiveUpdateTask(
                            getSERVICE_PASSIVE_CHECK_KEY());
                }
                if (!getPassiveChecker().passiveCheck(dbm)) {
                    QkanMessageList.getInstance()
                            .ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
                    dbm.rollbackTransaction();
                    return false;
                }
                
                // 2007/12/25 [Masahiko_Higuchi] add - begin Version 5.3.8　2007年度対応
                for(int i=0;i<details.size();i++){
                    VRMap delMap = (VRMap)details.getData(i);
                    // 2008/06/24 [Masahiko.Higuchi] V5.4.1 edit - begin 同期例外が発生することがあるようなので対応
                    try{
                        // 解析用のキーは消す
                        delMap.remove("ANALYZE");
                        delMap.remove("CORRECT_KEY");
                    }catch(java.util.ConcurrentModificationException ex){
                        //同期例外は無視                        
                    }
                    // 2008/06/24 [Masahiko.Higuchi] edit - end
                }
                // 2007/12/25 [Masahiko_Higuchi] add - End
                
                QkanCommon.updateServiceDetail(dbm, details, getPatientID(),
                        getTargetDate(), insertUseType);
                // パッシブチェック用テーブルに処理対象の利用者・年月のレコードを登録する。※SQL
                // ID=INSERT_PASSIVE_CHECK_RECORD
                if (insertMode) {
                    // 登録モードの場合
                    dbm
                            .executeUpdate(getSQL_INSERT_PASSIVE_CHECK_RECORD(getPassiveCheckSQLParam()));
                } else {
                    // 更新モードの場合
                    dbm
                            .executeUpdate(getSQL_UPDATE_PASSIVE_CHECK_RECORD(getPassiveCheckSQLParam()));
                    //実績確定情報の破棄
                    QkanCommon.updateClaimDetail(dbm, new VRArrayList(), getTargetDate(), getPatientID());
                }
                dbm.commitTransaction();
            } catch (Exception ex) {
                dbm.rollbackTransaction();
                throw ex;
            }
            setServiceModify(false);

            // ※モード再確認
            // 既存レコードの有無を基準に、更新モードか登録モードかを判断する。
            checkProcessMode();

        } finally {
            ACSplashChaine.getInstance().closeAll();
        }
        return true;
    }

    /**
     * 「更新処理」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
   * @return boolean
     */
    public boolean doUpdate() throws Exception {
        return doUpdateImpl(false);
    }

    /**
     * 「週間表表示」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void showWeekly() throws Exception {
        // ■週間表を表示
        // 週間表を表示する。
        getMonthlyPanel().setVisible(false);
        getWeeklyPanel().setVisible(true);
        // 週間サービス計画表印刷ボタンを表示する。
        setState_PRINT_WEEKLY();
        // changeChartのキャプションを「月間表示」にする。
        getChangeChart().setText("月間表示");
    }

    /**
     * 「月間表表示」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void showMonthly() throws Exception {
        // ■月間表を表示
        // 月間表を表示する。
        getMonthlyPanel().setVisible(true);
        if (getWeeklyPanel() != null) {
            getWeeklyPanel().setVisible(false);
        }
        // 利用票・提供票印刷ボタンを表示する。
        setState_PRINT_MONTHLY();
        // changeChartのキャプションを「週間表示」にする。
        getChangeChart().setText("週間表示");

    }

    /**
     * 「サービスパターン選択/未選択チェック」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void checkServicePatternSelected() throws Exception {
        // ■サービスパターンの選択/未選択チェック
        // 「サービスパターン(patternList)」内の項目が選択されているかどうかをチェックする。
        if ((!getPatternList().isSelectionEmpty())
                && (getSelectedServiceListBox() == getPatternList())) {
            // 選択されている場合
            // 「サービスパターン削除(patternDelete)」を有効にする。
            setState_SERVICE_PATTERN_SELECTED();
        } else {
            // 選択されていない場合
            // 「サービスパターン削除(patternDelete)」を無効にする。
            setState_SERVICE_PATTERN_UNSELECTED();
        }
    }

    /**
     * 「詳細内容D&D」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void pictureDragAndDrop() throws Exception {
        // ■手アイコンによるドラッグ＆ドロップ処理
        // ※ドロップ先(週間表、月間表)に、内容詳細情報を設定
        getPicture().setDragData(createServiceData());
    }

    /**
     * 「予定データ読込」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void doOpenResult() throws Exception {
        // ■同一対象年月の予定情報を画面に展開

        // ※同一対象年月の予定情報を画面に展開
        ACDBManager dbm = getDBManager();
        dbm.beginTransaction();
        VRList plans = QkanCommon.getServiceDetail(dbm, getPatientID(),
                getTargetDate(),
                QkanConstants.SERVICE_DETAIL_GET_PLAN_OF_MONTHLY_ONLY);
        dbm.commitTransaction();
        Iterator it = plans.iterator();
        while (it.hasNext()) {
            // USE_TYPEが予定のものになっているので、実績に差し替える
            VRMap row = (VRMap) it.next();
            Integer useType = new Integer(ACCastUtilities
                    .toString(VRBindPathParser.get("SERVICE_USE_TYPE", row)));
            if (QkanConstants.SERVICE_USE_TYPE_PLAN_MONTHLY_DAY.equals(useType)) {
                VRBindPathParser.set("SERVICE_USE_TYPE", row,
                        QkanConstants.SERVICE_USE_TYPE_RESULT_MONTHLY_DAY);
            } else if (QkanConstants.SERVICE_USE_TYPE_PLAN_MONTHLY_FREE_DAY
                    .equals(useType)) {
                VRBindPathParser.set("SERVICE_USE_TYPE", row,
                        QkanConstants.SERVICE_USE_TYPE_RESULT_MONTHLY_FREE_DAY);
            }
            //キーを削除
            row.remove("SERVICE_ID");
        }
        // 同一対象年月の予定情報を画面に展開
        getMonthlyPanel().setSchedule(plans);

    }

    /**
     * 「サービスパターン選択イベント」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void patternListSelectionChanged(ListSelectionEvent e)
            throws Exception {
        //■サービスパターンの情報を展開 
        //サービス内容登録・選択領域(servuceDetails)に選択したパターンの情報をバインドする。
        serviceListSelectionChanged(e);
    }

    /**
     * 「サービスクラスの生成」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     * @return ACPanel
     */
    // 2008/03/18 [Masahiko_Higuchi] edit - begin 平成20年度診療報酬単価変更対応
    public ACPanel createServicePatternClass(Date targetDate) throws Exception {
    // 2008/03/18 [Masahiko_Higuchi] edit - end
        // ■現在選択中の独自サービス種類コードに対応するサービスパターンクラスを生成
        // ※現在選択中の独自サービス種類コード(selectedServiceKind)をもとにサービスパターンクラス(QS001003～)を生成して返す。
        switch (getSelectedServiceKind()) {
        //平成18年4月改正分
        case 11111://訪問介護
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate) < 1) {
                return new QS001101_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            
            return new QS001101();
            
        case 11211://訪問入浴介護
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate) < 1) {
                return new QS001102_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            
            return new QS001102();
            
        case 11311://訪問看護(介護保険)
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate) < 1) {
                return new QS001103_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            
            return new QS001103();
            
//        case 20101://訪問看護(医療保険)
//            return new QS001104();  
        case 11411://訪問リハビリテーション
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate) < 1) {
                return new QS001105_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            
            return new QS001105();
            
        case 11511://通所介護
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate) < 1) {
                return new QS001107_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            
            return new QS001107();  
            
        case 11611://通所リハビリテーション
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate) < 1) {
                return new QS001108_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            
            return new QS001108();  
        case 11711://福祉用具貸与
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate) < 1) {
                return new QS001116_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            
            return new QS001116();  
        case 12111://短期入所生活介護
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate) < 1) {
                return new QS001109_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            
            return new QS001109();
            
        case 12211://短期入所療養介護(老健)
            // [ID:0000444][Masahiko Higuchi] edit begin 平成21年4月法改正対応
            if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate) < 1) {
                return new QS001110_H2104();
                
            } else if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2005, targetDate)<1){
                // 2008/04/14 [Masahiko_Higuchi] edit - begin 平成20年5月法改正対応
                return new QS001110_H2005();
                
            }else{
                return new QS001110();
            }
            // 2008/04/14 [Masahiko_Higuchi] edit - end
            // [ID:0000444][Masahiko Higuchi] edit end
            
        case 12311://短期入所療養介護(療養病床を有する病院)
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate) < 1) {
                return new QS001111_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001111();
            
        case 12312://短期入所療養介護(療養病床を有する診療所)
            // [ID:0000444][Masahiko Higuchi] edit begin 平成21年4月法改正対応
            if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate) < 1) {
                return new QS001112_H2104();
                
            } else if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2004, targetDate)<1){
                // 2008/03/18 [Masahiko_Higuchi] edit - begin 平成20年4月法改正対応
                // 平成20年4月以降は生成先を変更する
        		return new QS001112_H2004();
                
        	}else{
        		return new QS001112();
        	}
        	// 2008/03/18 [Masahiko_Higuchi] edit - end
            // [ID:0000444][Masahiko Higuchi] edit end
            
        case 12313://短期入所療養介護(老人性認知症疾患療養病棟を有する病院)
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate) < 1) {
                return new QS001113_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end            
            return new QS001113();
            
        case 12314://短期入所療養介護(基準適合診療所)
            return new QS001114();  
            
        case 13111:// 居宅療養管理指導
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001106_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end            
            return new QS001106();
            
        case 13211://認知症対応型共同生活介護(短期利用以外)
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001126_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001126();  
            
        case 13311://特定施設入居者生活介護
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001115_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001115();
            
        case 13611://地域密着型特定施設入居者生活介護
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001128_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001128();
            
        case 13811://認知症対応型共同生活介護(短期利用)
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001127_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001127();  
            
        case 14311://居宅介護支援
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001117_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001117();
            
        case 15111://介護老人福祉施設
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001118_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001118();  
            
        case 15211://介護老人保健施設
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001119_H2104();
                
            } else if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2005, targetDate)<1){
                // 2008/04/14 [Masahiko_Higuchi] edit - begin 平成20年5月法改正対応
                return new QS001119_H2005();
            }else{
                return new QS001119();
            }
            // 2008/04/14 [Masahiko_Higuchi] edit - end
            // [ID:0000444][Masahiko Higuchi] add end
            
        case 15311://介護療養型医療施設(療養病床を有する病院)
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001120_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001120();  
            
        case 15312://介護療養型医療施設(療養病床を有する診療所)
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001121_H2104();
            } else if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2004, targetDate)<1){
                // 2008/03/18 [Masahiko_Higuchi] edit - begin 平成20年4月法改正対応
                // 平成20年4月以降は生成先を変更する
        		return new QS001121_H2004();
        	}else{
        		return new QS001121();
        	}
        	// 2008/03/18 [Masahiko_Higuchi] edit - end
            // [ID:0000444][Masahiko Higuchi] add end
        	
        case 15313://介護療養型医療施設(老人性認知症疾患療養病棟を有する病院)
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001122_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001122();
            
        case 15411://地域密着型介護福祉施設
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001129_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001129();  
            
        case 17111://夜間対応型訪問介護
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001123_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001123();  
            
        case 17211://認知症対応型通所介護
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001124_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001124();  
            
        case 17311://小規模多機能型居宅介護
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001125_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001125();  
            
        case 90101:// その他
            return new QS001026(); 
        case 90201:// 主な日常生活上の活動
            return new QS001027(); 
            //平成18年4月予防
        case 16111: //介護予防訪問介護
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001130_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001130();
            
        case 16211: //介護予防訪問入浴介護
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001131_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001131();
            
        case 16311: //介護予防訪問看護
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001132_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001132();
            
        case 16411: //介護予防訪問リハ
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001133_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001133();
            
        case 16511: //介護予防通所介護
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001135_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001135();
            
        case 16611: //介護予防通所リハ
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001136_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001136();
            
        case 16711: //介護予防福祉用具貸与
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001144_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001144();
            
        case 12411: //介護予防短期入所生活介護
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001137_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001137();
            
        case 12511: //介護予防短期入所療養介護（老健）
            // [ID:0000444][Masahiko Higuchi] 2009/02 edit begin 平成21年4月法改正対応
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001138_H2104();
                
            }
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2005, targetDate)<1){
                // 2008/04/14 [Masahiko_Higuchi] edit - begin 平成20年5月法改正対応
                return new QS001138_H2005();
                
            }else{
                return new QS001138();
            }
            // 2008/04/14 [Masahiko_Higuchi] edit - end
            // [ID:0000444][Masahiko Higuchi] edit end
            
        case 12611: //介護予防短期入所療養介護（病院）
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001139_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001139();
            
        case 12612: //介護予防短期入所療養介護（診療所）
            // [ID:0000444][Masahiko Higuchi] 2009/02 edit begin 平成21年4月法改正対応
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001140_H2104();
                
            } else if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2004, targetDate)<1){
                // 2008/03/18 [Masahiko_Higuchi] edit - begin 平成20年4月法改正対応
                // 平成20年4月以降は生成先を変更する
        		return new QS001140_H2004();
                
        	}else{
        		return new QS001140();
        	}
        	// 2008/03/18 [Masahiko_Higuchi] edit - end
            // [ID:0000444][Masahiko Higuchi] edit end
        	
        case 12613: //介護予防短期入所療養介護（認知症疾患型）
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001141_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001141();
            
        case 12614: //介護予防短期入所療養介護（基準適合型診療所）
            return new QS001142();
        case 13411: //介護予防居宅療養管理指導
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001134_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001134();
            
        case 13511: //介護予防特定施設入居者生活介護
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001143_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001143();
            
        case 14611: //介護予防支援
            // [ID:0000444][Tozo TANAKA] 2009/03/02 add begin 平成21年4月法改正対応
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001145_H2104();
            }
            // [ID:0000444][Tozo TANAKA] add end
            return new QS001145();
        case 17411: //介護予防認知症対応型通所介護
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001146_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001146();
            
        case 17511: //介護予防小規模多機能型居宅介護
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001147_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001147();
            
        case 13711: //介護予防認知症対応型共同生活介護（短期利用以外）
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001148_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001148();
            
        case 13911: //介護予防認知症対応型共同生活介護（短期利用）
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001149_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001149();
            
            //平成17年10月改正分
        case 11101:// 訪問介護
            return new QS001003(); 
        case 11201:// 訪問入浴介護
            return new QS001004(); 
        case 11301:// 訪問看護(介護保険)
            return new QS001005(); 
        case 20101:// 訪問看護(医療保険)
            return new QS001006(); 
        case 11401:// 訪問リハビリテーション
            return new QS001007(); 
        case 11501:// 通所介護
            return new QS001008(); 
        case 11601:// 通所リハビリテーション
            return new QS001009(); 
        case 11701:// 福祉用具貸与
            return new QS001010(); 
        case 12101:// 短期入所生活介護
            return new QS001011(); 
        case 12201:// 短期入所療養介護(老健)
            return new QS001012(); 
        case 12301:// 短期入所療養介護(療養病床を有する病院)
            return new QS001013(); 
        case 12302:// 短期入所療養介護(療養病床を有する診療所)
            return new QS001014(); 
        case 12303:// 短期入所療養介護(老人性認知症疾患療養病棟を有する病院)
            return new QS001015(); 
        case 12304:// 短期入所療養介護(基準適合診療所)
            return new QS001016(); 
        case 13101:// 居宅療養管理指導
            return new QS001017(); 
        case 13201:// 認知症対応型共同生活介護
            return new QS001018(); 
        case 13301:// 特定施設入所者生活介護
            return new QS001019(); 
        case 14301:// 居宅介護支援
            return new QS001020(); 
        case 15101:// 介護老人福祉施設
            return new QS001021(); 
        case 15201:// 介護老人保健施設
            return new QS001022(); 
        case 15301:// 介護療養型医療施設(療養病床を有する病院)
            return new QS001023(); 
        case 15302:// 介護療養型医療施設(療養病床を有する診療所)
            return new QS001024(); 
        case 15303:// 介護療養型医療施設(老人性認知症疾患療養病棟を有する病院)
            return new QS001025(); 
        }

        return null;
    }

    /**
     * 「サービスパネルのデータ取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public VRMap createServiceData() throws Exception {
        // ■選択しているサービスの情報を取得
        if (getSelectedServiceClass() != null) {
            // 現在選択しているサービスクラス(selectedServiceClass)がnullでない場合
            
            if(getSelectedServiceClass().isUseProvider()){
                // 現在選択しているサービスクラス(selectedServiceClass)が事業所情報を必要とする(isUseProvider)場合

                if(!getServiceOfferEntrepreneur().isSelected()){
                    // 事業所を選択してない場合
                    // 事業所未選択のエラーメッセージを表示する。※ID=QS001_EROOR_OF_UNSELECTED_PROVIDER
                    QkanMessageList.getInstance().QS001_EROOR_OF_UNSELECTED_PROVIDER();
                    // 入力に不備があったと見なし、nullを返す。
                    return null;
                }
            }

            VRMap data =getSelectedServiceClass().getValidData();
            if (data!=null) {
                // 現在選択しているサービスクラス(selectedServiceClass)のエラーチェック(getValidData)にnull以外が返ってきた場合
                // 現在表示しているサービスクラスを含むサービス内容設定領域(serviceContentSettings)から情報を収集して返す。

//                VRBindPathParser.set("LOGIN_PROVIDER_ID", data, QkanSystemInformation.getInstance().getLoginProviderID());
                VRBindPathParser.set("PATIENT_ID", data, new Integer(getPatientID()));
                Object provider = getServiceOfferEntrepreneur().getSelectedModelItem();
                if(provider instanceof VRMap){
                    VRBindPathParser.set("PROVIDER_ID", data, VRBindPathParser.get("PROVIDER_ID", (VRMap)provider));
                }else{
                    VRBindPathParser.set("PROVIDER_ID", data, "");
                }
                VRBindPathParser.set("SYSTEM_SERVICE_KIND_DETAIL", data, new Integer(getSelectedServiceKind()));
                // SERVICE_USE_TYPEなどの情報は必要に応じて呼び出し元で設定すること。
                

                // [ID:0000444][Tozo TANAKA] 2009/03/07 add begin 平成21年4月法改正対応
                if(getSelectedServiceClass() instanceof QS001ServicePanel){
                    //サービスの法改正区分を設定します。
                    VRBindPathParser
                            .set(
                                    QkanConstants.SERVICE_SYSTEM_BIND_PATH_LOW_VERSION,
                                    data,
                                    new Integer(
                                            ((QS001ServicePanel) getSelectedServiceClass())
                                                    .getServiceLowVersion()));
                }
                // [ID:0000444][Tozo TANAKA] 2009/03/07 add end
                
                return data;
            }
        }
        // 入力に不備があったと見なし、nullを返す。
        return null;
    }

    /**
     * 「処理モードの確認」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void checkProcessMode() throws Exception {
        // ■パッシブチェック用のテーブルを確認し、現在の処理モードを設定

        // パッシブチェック用テーブルに処理対象の利用者・年月のレコードが存在するかを確認する。※SQL
        // ID=GET_PASSIVE_CHECK_RECORD
        VRList passive = getDBManager().executeQuery(
                getSQL_GET_PASSIVE_CHECK_RECORD(getPassiveCheckSQLParam()));
        if (!passive.isEmpty()) {
            // レコードが存在する場合
            // 処理モードを更新モードとする。
            setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);
            // 業務ボタンの更新ボタンを表示し、登録ボタンを非表示にする。
            setState_PROCESS_MODE_UPDATE();
            // パッシブチェック用のレコードとしてパッシブチェッカーに退避する。
            getPassiveChecker().reservedPassive(getSERVICE_PASSIVE_CHECK_KEY(),
                    passive);
        } else {
            // レコードが存在しない場合
            // 処理モードを登録モードとする。
            setProcessMode(QkanConstants.PROCESS_MODE_INSERT);
            // 業務ボタンの登録ボタンを表示し、更新ボタンを非表示にする。
            setState_PROCESS_MODE_INSERT();
        }

    }

    /**
     * 「週間サービスリスト選択」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void weeklyPanelSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // ■週間表のサービス選択イベント
        // 月間/週間表のサービス選択イベントを処理する。
        serviceListSelectionChanged(e);
    }

    /**
     * 「月間サービスリスト選択」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void monthlyPanelSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // ■月間表のサービス選択イベント
        // 月間/週間表のサービス選択イベントを処理する。
        serviceListSelectionChanged(e);
    }

    /**
     * 「週間サービスリストキー押下」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void weeklyPanelKeyPressed(KeyEvent e) throws Exception {
        // ■週間表のキー押下イベント
        // 月間/週間表のキー押下イベントを処理する。
        serviceListKeyDown(e);
    }

    /**
     * 「月間サービスリストキー押下」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void monthlyPanelKeyPressed(KeyEvent e) throws Exception {
        // ■月間表のサービス選択イベント
        // 月間/週間表のキー押下イベントを処理する。
        serviceListKeyDown(e);

    }

    /**
     * 「月間/週間サービスリスト選択変更」に関する処理を行ないます。
     * 
     * @param e ListSelectionEvent
     * @throws Exception 処理例外
     */
    public void serviceListSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // イベント発生もとのリストをサービス選択中のリスト(serviceSelectedListBox)に退避する。
        if (e.getValueIsAdjusting()) {
            return;
        }
        if(getServiceListLockFlag()){
            //多重再帰防止
            return;
        }
        QS001DaySchedule oldSelectedList = getSelectedServiceListBox();
        Object lock = oldSelectedList;
        if (lock == null) {
            lock = new Integer(0);
        }
        synchronized (lock) {
            setSelectedServiceListBox((QS001DaySchedule) e.getSource());
            
            if ((getSelectedServiceListBox() != null)
                    && (getSelectedServiceListBox().isSelected())) {
                // サービスを選択している場合
                // サービス選択状態にする。
                setState_SERVICE_SELECTED();
                VRMap service = getSelectedServiceListBox()
                        .getSelectedService();
                if (service != null) {
                    Object selectedKind = VRBindPathParser.get(
                            "SYSTEM_SERVICE_KIND_DETAIL", service);
                    if (selectedKind != null) {
                        int end = getServiceKindList().getItemCount();
                        for (int i = 0; i < end; i++) {
                            Object kindItem = getServiceKindList().getItemAt(i);
                            if (kindItem instanceof VRMap) {
                                if (selectedKind.equals(VRBindPathParser.get(
                                        "SYSTEM_SERVICE_KIND_DETAIL",
                                        (VRMap) kindItem))) {
                                    setNowSelectedService(service);
                                    getServiceKindList().setSelectedIndex(i);
                                    getSelectedServiceClass().initialize();

                                    // 先に事業所をバインドする。
                                    getServiceOfferEntrepreneur().setSource(
                                            service);
                                    getServiceOfferEntrepreneur().bindSource();

                                    // あとで詳細パネルにバインドする。
                                    getServiceContentSettings().setSource(
                                            service);
                                    getServiceContentSettings().bindSource();
                                    if (getSelectedServiceClass() instanceof QS001ServicePanel) {
                                        ((QS001ServicePanel) getSelectedServiceClass())
                                                .binded();
                                    }
                                    break;
                                }
                            }
                        }
                    }
                    // 週間表におけるサービスの開始日と期間を設定する。
                    getWeeklyPanel().setServiceSpan(service);
                }

                // 月間表に選択されたサービスパネルを設定する。
                getMonthlyPanel().setSelectedService(getSelectedServiceClass(),
                        getSelectedServiceListBox());
            } else {
                // サービスを選択していない場合
                // サービス未選択状態にする。
                clearServiceSelection();
            }
            if (oldSelectedList != null) {
                if (oldSelectedList != getSelectedServiceListBox()) {
                    if (oldSelectedList.isSelected()) {
                        // 過去に選択していたリストの選択を解除する。
                        setServiceListLockFlag(true);
                        oldSelectedList.clearSelection();
                        setServiceListLockFlag(false);
                    }
                }
            }
        }

        // パターンの選択状態をチェックする。
        checkServicePatternSelected();

    }

    /**
     * 「月間/週間サービスリストキー押下」に関する処理を行ないます。
     * 
     * @param e KeyEventListener *
     * @throws Exception 処理例外 *
     */
    public void serviceListKeyDown(KeyEvent e) throws Exception {
        // ■月間/週間表のサービスリストキー押下
        if (e.getKeyCode() == KeyEvent.VK_DELETE) {
            // 押下したキーがDeleteキーの場合
            // サービス選択中のリスト(serviceSelectedListBox)に選択サービスの削除を指示する。
            removeSelectedService();
        }
    }

    /**
     * 「選択サービスの削除」に関する処理を行ないます。 
     * 
     * @throws Exception 処理例外 
     */
    public void removeSelectedService() throws Exception {
        // ■選択サービスの削除
        if (getSelectedServiceListBox() != null) {
            // サービス選択中のリスト(serviceSelectedListBox)がnullでない場合
            //            サービス選択中のリスト(serviceSelectedListBox)に選択サービスの削除を指示する。
            Component oldSelectCmp=null;
            if(getSharedFocusCellRenderer()!=null){
                oldSelectCmp = getSharedFocusCellRenderer().getSharedFocusedOwner();
            }
            getSelectedServiceListBox().removeSelectedSchedule();
            //                サービス未選択状態にする。   
            if((!getSelectedServiceListBox().isSelected())||(getSelectedServiceListBox().getSelectedValue()==null)){
                setState_SERVICE_UNSELECTED();
            }else{
                if(oldSelectCmp!=null){
                    getSharedFocusCellRenderer().setSharedFocusedOwner(oldSelectCmp);
                }
            }
            setServiceModify(true);
        }
    }

    /**
     * 「サービスパターンの追加削除を実行」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void saveServicePattern() throws Exception {
        // ■サービスパターンの追加削除を実行
        // 予約したサービスパターンの追加削除を実行する。
        if ((!getDeleteReseveServicePatterns().isEmpty())
                || (!getInsertReserveServicePatterns().isEmpty())) {
            ACDBManager dbm = getDBManager();
            try {
                dbm.beginTransaction();
                // 最新のサービスパターンを取得する。
                VRList pattenrs = QkanCommon.getServicePatternDetail(dbm);
                // 削除予定のサービスパターンを取得結果から除外する。
                Iterator it=getDeleteReseveServicePatterns().iterator();
                while(it.hasNext()){
                    Map service=(Map)it.next();
                    Object obj = service.get("SERVICE_ID");
                    if(obj != null){
                        String id=ACCastUtilities.toString(obj);
                        
                        int end = pattenrs.size();
                        for(int i=0; i<end; i++){
                            if(id.equals(ACCastUtilities.toString(((Map)pattenrs.get(i)).get("SERVICE_ID")))){
                                pattenrs.remove(i);
                                break;
                            }
                        }
                    }
                }
//                pattenrs.removeAll(getDeleteReseveServicePatterns());
                // 追加予定のサービスパターンを取得結果に追加する。
                it=getInsertReserveServicePatterns().iterator();
                while(it.hasNext()){
                    Map service=(Map)it.next();
                    service.remove("SERVICE_ID");
                }
                pattenrs.addAll(getInsertReserveServicePatterns());
                //念のためユニークキーの重複チェックを行う。
                Set keySet = new HashSet();
                it=pattenrs.iterator();
                while (it.hasNext()) {
                    Map row = (Map) it.next();
                    Object key = row.get("SERVICE_ID");
                    // 2008/01/24 [Masahiko_Higuchi] add - begin サービスパターン設定ボタン操作実行時エラー対応
                    // 処理用のキー情報を削除する
                    row.remove("CORRECT_KEY");
                    // 2008/01/24 [Masahiko_Higuchi] add - end
                    if (key != null) {
                        if (keySet.contains(key)) {
                            // キーの衝突
                            row.remove("SERVICE_ID");
                        } else {
                            keySet.add(key);
                        }
                    }
                }                
                // マージ後のサービスパターンをDBに再登録する。
                QkanCommon.updateServicePatternDetail(dbm, pattenrs);
                dbm.commitTransaction();
            } catch (Exception ex) {
                dbm.rollbackTransaction();
                throw ex;
            }
        }

    }

    /**
     * 「サービス種類の選択設定」に関する処理を行ないます。
     *
     * @throws Exception 処理例外
     *
     */
    public void refleshServiceKind() throws Exception {
        // ※サービスパターンの設定
        if (!(getServiceKindList().getSelectedValue() instanceof VRMap)) {
            return;
        }
        VRMap service = (VRMap) getServiceKindList().getSelectedValue();
        int serviceKind = ACCastUtilities.toInt(VRBindPathParser.get(
                "SYSTEM_SERVICE_KIND_DETAIL", service));
        // 選択中の独自サービス種類コード(selectedServiceKind)に選択されたサービスの
        // KEY:SYSTEM_SERVICE_KIND_DETAIL の値を設定する。
        setSelectedServiceKind(serviceKind);

        // 選択中の独自サービス種類コード(selectedServiceKind)に対応したサービスパターンクラスを生成する。
        // 2008/03/18 [Masahiko_Higuchi] edit - begin 平成20年4月法改正対応（介護療養型老人保健施設対応）
        ACPanel serviceClass = createServicePatternClass(getCalcurater().getTargetDate());
        // 2008/03/18 [Masahiko_Higuchi] edit - end
        if(serviceClass instanceof QS001ServicePanel){
            ((QS001ServicePanel)serviceClass).setDBManager(getDBManager());
            ((QS001ServicePanel)serviceClass).setOldFacilityUser(getOldFacilityUserFlag()==2);
            ((QS001ServicePanel)serviceClass).setPlanMode(getProcessType()==QkanConstants.PROCESS_TYPE_PLAN);
            ((QS001ServicePanel)serviceClass).setCalculater(getCalcurater());
        }
        // サービス内容設定領域(serviceContentSettings)の子項目を破棄し、生成したサービスパターンクラスを子項目として追加する。
        getServiceContentSettings().removeAll();
        if (serviceClass != null) {
            setSelectedServiceClass((QS001Service) serviceClass);
            
            if(getBeginTimeFollowListener()!=null){
                getBeginTimeFollowListener().setB(getSelectedServiceClass().getBeginTimeCombo());
                getEndTimeFollowListener().setB(getSelectedServiceClass().getEndTimeCombo());
            }
            getSelectedServiceClass().initialize();
            getServiceContentSettings().add(serviceClass, VRLayout.CLIENT);
        } else {
            setSelectedServiceClass(null);
        }


        if (serviceKind == DAYLY_LIFE_SERVICE) {
            // 取得されたサービスが「主な日常生活上の活動」である場合
            // 「週間表」の「月」～「日」のチェックボックスを非表示に、「週単位以外のサービス」以下を無効にする。
            // setDailylifeCheckEnabled(true);
            getWeeklyPanel().setDailylifeCheckEnabled(true);
        } else {
            // 取得されたサービスが「主な日常生活上の活動」以外の場合
            // 「週間表」の「月」～「日」のチェックボックスを表示し、「週単位以外のサービス」以下を有効にする。
            // setDailylifeCheckEnabled(false);
            getWeeklyPanel().setDailylifeCheckEnabled(false);

            if(CareServiceCommon.isWelfareEquipment(service)){
                //福祉用具貸与の場合
                //期間は常に1日とし、期間コンボを操作不可とする。
                getWeeklyPanel().getExceptionEndCombo().setSelectedIndex(1);
                getWeeklyPanel().setState_WELFARE_EQUIPMENT_SELECTED();
            }else{
                //福祉用具貸与以外の場合
                //期間コンボを操作可能とする。
                getWeeklyPanel().getExceptionEndCombo().setSelectedIndex(0);
                getWeeklyPanel().setState_WELFARE_EQUIPMENT_UNSELECTED();
            }
        }

        // ※登録済みパターンの設定
        // 選択されたサービスの、登録済みパターンを取得・設定する。
        Object patterns = getServicePatternHash().get(
                new Integer(getSelectedServiceKind()));
        if (!(patterns instanceof VRList)) {
            patterns = new VRArrayList();
            getServicePatternHash().put(new Integer(getSelectedServiceKind()),
                    patterns);
        }
        setNowServicePatterns((VRList) patterns);
        getPatternList().setModel(
                new ACListModelAdapter(getNowServicePatterns()));

        // ※事業所コンボのアイテム設定
        // 事業所の選択済みフラグを宣言する。
        boolean providerSelected = false;
        // 現在選択しているサービスクラス(selectedServiceClass)が事業所情報を必要とする(isUseProvider=true)場合
        if ((getSelectedServiceClass() != null)
                && getSelectedServiceClass().isUseProvider()) {
            // 事業所コンボを有効にする。
            setState_USE_PROVIDER_SERVICE();

            // 選択されたサービスを提供する事業所を、事業所コンボのアイテムに設定する。
            VRList providers = QkanCommon.getProviderInfo(getDBManager(),
                    serviceKind);

            // 絞り込まれた事業所の詳細サービスをここで取得する。
            // ★通信によるレスポンス低下が気になるようであれば、画面展開時に1回だけすべての事業所・詳細を取得しておき、
            // 絞込みはキャッシュしたリストから行なう方式が考えられる。
            Iterator it = providers.iterator();
            while (it.hasNext()) {
                VRMap row = (VRMap) it.next();
                VRList details = QkanCommon.getProviderServiceDetail(
                        getDBManager(), ACCastUtilities
                                .toString(VRBindPathParser.get("PROVIDER_ID",
                                        row)), serviceKind);
                if (details.size() > 0) {
                    // 詳細をマージ
                    row.putAll((VRMap) details.getData());
                }
            }

            getServiceOfferEntrepreneur().setModel(providers);
            // ※事業所コンボの選択
            it = providers.iterator();
            while (it.hasNext()) {
                VRMap row = (VRMap) it.next();
                if (QkanSystemInformation.getInstance().getLoginProviderID()
                        .equals(VRBindPathParser.get("PROVIDER_ID", row))) {
                    // ログイン事業所がコンボ内にある場合は、ログイン事業所を選択する。
                    getServiceOfferEntrepreneur().setSelectedItem(row);
                    // 事業所の選択済みフラグをtrueにする。
                    providerSelected = true;
                    break;
                }
            }
            // ログイン事業所がコンボ内にない場合は、未選択とする。
        } else {
            // 現在選択しているサービスクラス(selectedServiceClass)が事業所情報を必要としない(isUseProvider=false)場合
            // 事業所コンボを無効にする。
            setState_NOT_USE_PROVIDER_SERVICE();
            // 事業所コンボの選択候補を空にする。
            getServiceOfferEntrepreneur().setModel(new VRArrayList());
        }

        if (!providerSelected) {
            // 事業所の選択済みフラグがfalseの場合
            if (getSelectedServiceClass() != null) {
                // ※サービス内容を初期状態にする
                // 選択しているサービスクラス(selectedServiceClass)に事業所情報としてnullを送る。
                getSelectedServiceClass().providerSelected(null);
            }
        }

        // ■サービスパターンの選択/未選択チェック
        // サービスパターンの選択/未選択チェックを行う。
        checkServicePatternSelected();     
        
        if(getBeginTimeFollowListener()!=null){
            QS001FollowTimeComboDocumentListener.followValue(getBeginTimeFollowListener().getB(), getBeginTimeFollowListener().getA());
        }
        if(getEndTimeFollowListener()!=null){
            QS001FollowTimeComboDocumentListener.followValue(getEndTimeFollowListener().getB(), getEndTimeFollowListener().getA());
        }
    }

    /**
     * 「サービス未選択状態設定」に関する処理を行ないます。
     *
     * @throws Exception 処理例外
     *
     */
    public void clearServiceSelection() throws Exception {
        setNowSelectedService(null);
        setState_SERVICE_UNSELECTED();
        //セルレンダラの表示も更新
        Component cmp=getSharedFocusCellRenderer().getSharedFocusedOwner();
        if(cmp!=null){
            getSharedFocusCellRenderer().setSharedFocusedOwner(null);
            cmp.repaint();
        }
        getMonthlyPanel().setState_SERVICE_UNSELECTED();
    }

    public void dropSuccess(ACDropEvent e) {
        setServiceModify(true);
    }

    public void dropReject(ACDropEvent e) {
    }

    /**
     * 「最新週間予定読み込み」に関する処理を行ないます。
     *
     * @throws Exception 処理例外
     *
     */
    public void doOpenPlan() throws Exception {

        // ※過去の直近の情報を取得
        VRList schedules = null;
        ACDBManager dbm = getDBManager();
        try {
            dbm.beginTransaction();
            
            //TODO ★
            int mode;
            if(getProcessType()==QkanConstants.PROCESS_TYPE_PLAN){
                mode = QkanConstants.SERVICE_DETAIL_GET_PLAN_OF_WEEKLY_ONLY;
            }else{
                mode = QkanConstants.SERVICE_DETAIL_GET_RESULT;
            }

            schedules = QkanCommon.getServiceDetail(dbm, getPatientID(),
                    ACDateUtilities.addMonth(getTargetDate(), -1), mode);
            
            dbm.commitTransaction();
        } catch (Exception ex) {
            dbm.rollbackTransaction();
            throw ex;
        }
        if (schedules != null) {
            //ユニークキーを削除
            Iterator it=schedules.iterator();
            while(it.hasNext()){
                Map map=(Map)it.next();
                map.remove("SERVICE_ID");
            }
            getWeeklyPanel().setSchedule(schedules);
        }
        
    }
    /**
     * 該当Map内に該当バインドパスの値が存在するかチェックします。
     * 
     * @return サービスの有無
     * 
     * @author Masahiko Higuchi
     * @since V5.4.0
     * 
     */
    public boolean checkValidSysteBindPath(String[] bindPaths, VRMap service)
            throws Exception {
        Object obj = null;
        // 引数の数ループ
        for(int i=0;i<bindPaths.length;i++){
            obj = VRBindPathParser.get(bindPaths[i], service);
            // 比較処理
            if(ACCastUtilities.toInt(obj,0)!=0){
                return true;
            }
        }
        
        return false;
    }
    /**
     * 名称ボタン押下時の処理
     * 
     * @since Version 5.4.1
     * @author Masahiko Higuchi
     */
    protected void patternNameChangeActionPerformed(ActionEvent e) throws Exception {
        // VRMap以外は処理対象外にする。
        if (!(getPatternList().getSelectedValue() instanceof VRMap)) {
            return;
        }
        VRMap pattern = (VRMap) getPatternList().getSelectedValue();
        QS001033 qs001033 = new QS001033();
        // パターンダイアログの表示
        qs001033.showModel(pattern,getDBManager());
        // パターン名称が変更されている場合
        if(qs001033.isPatternNameChange()){
            // 既存登録サービスパターンであるか
            if(pattern.containsKey("SERVICE_ID")){
                // 既存のサービスパターンである場合はDelete - Insertで処理する。
                getDeleteReseveServicePatterns().add(pattern);
                // サービスIDの取得
                int serviceID = ACCastUtilities.toInt(pattern.getData("SERVICE_ID"),-1);
                // 登録予定リスト内に既に同一のデータがないか走査する
                for (int i = getInsertReserveServicePatterns().size(); i > 0 ; i--) {
                    VRMap insertPattern = (VRMap)getInsertReserveServicePatterns().get(i-1);
                    int insertPatternServiceID = ACCastUtilities.toInt(insertPattern.getData("SERVICE_ID"),-2);
                    // 多重登録防止（同一のデータである場合は削ってから足す）
                    if(serviceID == insertPatternServiceID){
                        getInsertReserveServicePatterns().remove(i-1);
                    }
                }
                // 最後に追加
                getInsertReserveServicePatterns().add(pattern);
            }
        }
    }

}
