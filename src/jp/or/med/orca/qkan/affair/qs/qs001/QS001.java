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
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.component.dnd.event.ACDraggableListener;
import jp.nichicom.ac.component.dnd.event.ACDropEvent;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.core.ACFrameEventProcesser;
import jp.nichicom.ac.core.debugger.ACStaticDebugger;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServiceCodeCalcurater;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServiceSummaryManager;
import jp.nichicom.ac.lib.care.claim.print.schedule.QkanSjAfChecker;
import jp.nichicom.ac.lib.care.claim.print.schedule.QkanSjAfException;
import jp.nichicom.ac.lib.care.claim.print.schedule.QkanSjInsurerChecker;
import jp.nichicom.ac.lib.care.claim.print.schedule.QkanSjInsurerException;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.lib.care.claim.servicecode.Qkan10011_ServiceCodeManager;
import jp.nichicom.ac.lib.care.claim.servicecode.Qkan10011_ServiceUnitGetter;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanSjServiceCodeManager;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanSjTankaManager;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanSjTankaNotFoundException;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanValidServiceCommon;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.ac.util.splash.ACSplashChaine;
import jp.nichicom.ac.util.splash.ACSplashable;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.bind.VRBindSource;
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
@SuppressWarnings("serial")
public class QS001 extends QS001Event {
    /**
     * コンストラクタです。
     */
    public QS001() {
    }

    private int correctKey = 0;

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
        // [ID:0000749][Masahiko.Higuchi] del - begin 2012年度対応 施設情報の履歴管理に関する修正
//        VRList specialFacilities = getDBManager().executeQuery(
//                getSQL_GET_PATIENT_FACILITY_FLAG(getPatientInfo()));
//        if (!specialFacilities.isEmpty()) {
//            // 施設履歴情報の特定入所者フラグを内部変数(inSpecialFacilityFlag)に退避する。
//            Object obj = ((Map) specialFacilities.getData())
//                    .get("TOKUTEI_NYUSHO_FLAG");
//            setInSpecialFacilityFlag(ACCastUtilities.toInt(obj, 0));
//            obj = ((Map) specialFacilities.getData()).get("KYUSOCHI_FLAG");
//            setOldFacilityUserFlag(ACCastUtilities.toInt(obj, 0));
//        }
        // [ID:0000749][Masahiko.Higuchi] del - end
        // [ID:0000749][Masahiko.Higuchi] add - begin 2012年度対応 施設情報の履歴管理に関する修正
        VRMap facilityParam = new VRHashMap();
        facilityParam.setData("PATIENT_ID",getPatientInfo().getData("PATIENT_ID"));
        facilityParam.setData("TARGET_DATE",getTargetDate());
        
        VRList specialFacilities = getDBManager().executeQuery(
        		getSQL_GET_PATIENT_FACILITY_FLAG(facilityParam));
        if (!specialFacilities.isEmpty()) {
            // 施設履歴情報の特定入所者フラグを内部変数(inSpecialFacilityFlag)に退避する。
            Object obj = ((Map) specialFacilities.getData())
                    .get("TOKUTEI_NYUSHO_FLAG");
            setInSpecialFacilityFlag(ACCastUtilities.toInt(obj, 1));
            obj = ((Map) specialFacilities.getData()).get("KYUSOCHI_FLAG");
            setOldFacilityUserFlag(ACCastUtilities.toInt(obj, 1));

        } else {
        	// 特定入所者フラグと旧措置フラグの初期値を設定
        	setInSpecialFacilityFlag(1);
        	setOldFacilityUserFlag(1);

        }
        // [ID:0000749][Masahiko.Higuchi] add - end

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
            param.setData("PATIENT_ID",
                    ACCastUtilities.toInteger(getPatientID()));
            VRList list = getDBManager().executeQuery(
                    getSQL_CHECK_NINTEI_HISTORY_EXISTS(sqlParam));
            if ((list == null) || (list.isEmpty())) {
                getYokaigodo().setText("認定履歴なし");
            } else {
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
            
// 2015/03/06 [Yoichiro Kamei] mod - begin システム有効期間対応 
// 月初と月末の要介護度名が違う場合のみ「(月初の要介護度名)→(月末の要介護度名)」を設定
//          getYokaigodo().setText(
//          QkanJotaiCodeUnapplicableFormat.getInstance().format(
//                  VRBindPathParser.get("JOTAI_CODE",
//                          patientInsureInfoFirst))
//                  + "→"
//                  + QkanJotaiCodeUnapplicableFormat.getInstance()
//                          .format(VRBindPathParser.get("JOTAI_CODE",
//                                  patientInsureInfoLast)));
            
            String beginYokaigodo = ACCastUtilities.toString(VRBindPathParser.get(
                    "JOTAI_CODE", patientInsureInfoFirst));
            String endYokaigodo = ACCastUtilities.toString(VRBindPathParser.get(
                    "JOTAI_CODE", patientInsureInfoLast));
            if (ACTextUtilities.isNullText(endYokaigodo) || beginYokaigodo.equals(endYokaigodo)) {
                getYokaigodo().setText(
                        QkanJotaiCodeUnapplicableFormat.getInstance().format(
                                VRBindPathParser.get("JOTAI_CODE",
                                		patientInsureInfoFirst)));
            } else {
                getYokaigodo().setText(
                QkanJotaiCodeUnapplicableFormat.getInstance().format(
                        VRBindPathParser.get("JOTAI_CODE",
                            patientInsureInfoFirst))
                    + "→"
                    + QkanJotaiCodeUnapplicableFormat.getInstance()
                            .format(VRBindPathParser.get("JOTAI_CODE",
                                    patientInsureInfoLast)));
            }
// 2015/03/06 [Yoichiro Kamei] mod - end

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
        getYokaigodo().setColumns(getYokaigodo().getText().length() + 1);

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

// 2016/7/5 [Yoichiro Kamei] add - begin 総合事業対応

//下記は不要なのでコメントアウト（ver7以降では既にM_SERVICEに該当データが無いため）
//        // 平成21年4月法改正対応
//        if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104,
//                getTargetDate()) < 1) {
//            // 基準適合診療所は除外する。
//            // 12314 : 短期入所療養介護(基準適合診療所)
//            // 13411 : 介護予防短期入所療養介護(基準適合診療所)
//            int[] h2104RemoveServices = { 12314, 12614 };
//            for (int i = 0; i < services.size(); i++) {
//                VRMap row = (VRMap) services.get(i);
//                for (int j = 0; j < h2104RemoveServices.length; j++) {
//                    int removeSystemServiceKindDetail = h2104RemoveServices[j];
//                    if (ACCastUtilities.toInt(
//                            row.get("SYSTEM_SERVICE_KIND_DETAIL"), 0) == removeSystemServiceKindDetail) {
//                        services.remove(i);
//                        break;
//                    }
//                }
//            }
//        }

// 2017/6/19 [Yoichiro Kamei] mod - begin 介護予防ケアマネジメント対応
//        // AF:介護予防ケアマネジメントには対応していないので除外
//        for (int i = 0; i < services.size(); i++) {
//            VRMap row = (VRMap) services.get(i);
//            if (ACCastUtilities.toInt(
//                    row.get("SYSTEM_SERVICE_KIND_DETAIL"), 0) == 51511) {
//                services.remove(i);
//                break;
//            }
//        }
// 2017/6/19 [Yoichiro Kamei] mod - end
// 2016/7/5 [Yoichiro Kamei] add - end 
        
        
        // 2016/01/28 [Shinobu Hitaka] add - begin サービス種類番号を一覧に表示
        for (int i = 0; i < services.size(); i++) {
            VRMap row = (VRMap) services.get(i);
            if (row.get("SERVICE_CODE_KIND") != null) {
            	row.setData("SERVICE_ABBREVIATION", row.get("SERVICE_CODE_KIND") + ":" + row.get("SERVICE_ABBREVIATION"));
            }
        }
        // 2016/01/28 [Shinobu Hitaka] add - end 
        
        setServiceKindsList(services);
        getServiceKindList().setModel(new ACListModelAdapter(services));
        getServiceKindList().setCellRenderer(
                new QS001ServiceKindListCellRenderer());

        // ※ユーザ登録済みサービスパターンを取得
        services = QkanCommon.getServicePatternDetail(getDBManager());
        VRMap patterns = new VRHashMap();
        Iterator<Object> it = services.iterator();
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
            // TODO パターン番号を採番済みであるか調べる
            if (!isExistingData) {
                for (int i = 0; i < ((VRList) targetPatterns).size(); i++) {
                    // Mapに格納する
                    VRMap map = (VRMap) ((VRList) targetPatterns).getData(i);
                    if (VRBindPathParser
                            .has(ACCastUtilities
                                    .toString(QkanConstants.INTERNAL_SERVICE_PATTERN_NO_BIND_PATH),
                                    map)) {
                        // 一度でも該当すれば以降は通らない
                        isExistingData = true;
                        break;
                    }
                }
            }
        }
        setServicePatternHash(patterns);

        if (!isExistingData) {
            // 採番済みでなかった場合
            // パターン番号を採番する。
            it = patterns.values().iterator();
            while (it.hasNext()) {
                Object row = it.next();
                if (row instanceof VRList) {
                    VRList targetPatterns = (VRList) row;
                    for (int i = 0; i < ((VRList) targetPatterns).size(); i++) {
                        VRMap inMap = new VRHashMap();
                        inMap = (VRMap) ((VRList) targetPatterns).getData(i);
                        // 削除対象に追加
                        getDeleteReseveServicePatterns().add(inMap);
                        // 追加対象に追加
                        getInsertReserveServicePatterns().add(inMap);
                        // 存在しなかった場合（既存データ）
                        VRBindPathParser
                                .set(ACCastUtilities
                                        .toString(QkanConstants.INTERNAL_SERVICE_PATTERN_NO_BIND_PATH),
                                        inMap, ACCastUtilities.toInteger(i + 1));
                    }
                }
            }

        } else {
            // 採番済みだった場合
            // パターン番号を採番する。
            it = patterns.values().iterator();
            while (it.hasNext()) {
                // サービス種類単位でパターンをソートする。
                Object row = it.next();
                if (row instanceof VRList) {
                    VRList targetPatterns = (VRList) row;
                    Map<Object, VRMap> treeMap = new TreeMap<Object, VRMap>();
                    ArrayList<VRMap> keyNullList = new ArrayList<VRMap>();

                    // パターン番号をキーにしてソートする。
                    Iterator<VRMap> it2 = targetPatterns.iterator();
                    while (it2.hasNext()) {
                        VRMap inMap = it2.next();
                        // パターン番号をキーにしてTreeMapに入れる。自動的にソートがかかる。
                        Object key = inMap
                                .get(ACCastUtilities
                                        .toString(QkanConstants.INTERNAL_SERVICE_PATTERN_NO_BIND_PATH));
                        if (key == null) {
                            // なぜかサービスパターン番号が存在しなかった場合
                            keyNullList.add(inMap);
                            // 削除対象に追加
                            getDeleteReseveServicePatterns().add(inMap);
                            // 追加対象に追加
                            getInsertReserveServicePatterns().add(inMap);
                        } else {
                            treeMap.put(key, inMap);
                        }
                    }
                    // サービスパターン番号が存在しなかったものに採番する。
                    it2 = keyNullList.iterator();
                    while (it2.hasNext()) {
                        VRMap inMap = it2.next();
                        // 現在の登録数+1を採番する。
                        Integer key = ACCastUtilities
                                .toInteger(treeMap.size() + 1);
                        VRBindPathParser
                                .set(ACCastUtilities
                                        .toString(QkanConstants.INTERNAL_SERVICE_PATTERN_NO_BIND_PATH),
                                        inMap, key);
                        treeMap.put(key, inMap);
                    }

                    // ソート結果に差し替える。
                    targetPatterns.clear();
                    targetPatterns.addAll(treeMap.values());
                }
            }
        }

        // サービス単位計算クラスを生成する。
        VRMap hashedProviders = new VRHashMap();
        // PROVIDER_IDをキーにハッシュ化し、内部変数(hashedProviders)に退避する。
        ACBindUtilities.setMapFromArray(
                QkanCommon.getProviderInfo(getDBManager()), hashedProviders,
                "PROVIDER_ID");
        setCalcurater(new CareServiceCodeCalcurater());
        getCalcurater().initialize(getTargetDate(), getPatientInfo(),
                patientInsureInfoHistoryList, hashedProviders, getDBManager(),
                getServiceKindsList(), getInSpecialFacilityFlag(),
                getOldFacilityUserFlag());

        // 2016/9/27 [総合事業対応][Yoichiro Kamei] add - begin
        QkanSjTankaManager.initialize(getDBManager(), getTargetDate());
        QkanSjServiceCodeManager.clearCacheIfUpdated(getDBManager());
        // 2016/9/27 [総合事業対応][Yoichiro Kamei] add - end
        
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
        // [ID:0000472][Masahiko Higuchi] 2009/04 edit begin 平成21年4月法改正対応
        cellRenderer.setProcessType(getProcessType());
        // [ID:0000472][Masahiko Higuchi] 2009/04 edit end
        setSharedFocusCellRenderer(cellRenderer);
        // パターンパネルへセルレンダラを設定する。
        getPatternList().setCellRenderer(cellRenderer);
        getPatternList().setMasterService(masterService);
        cellRenderer.setPatternList(getPatternList());
        // 月間表へセルレンダラを設定する。
        getMonthlyPanel().setCellRenderer(cellRenderer);
        getMonthlyPanel().setMasterService(masterService);

        QkanServiceAbbreviationFormat.getInstance().setMasterService(
                masterService);
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
                        modifiedFlag = getMonthlyPanel().getScheduleCount() > 0;
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

        // サービスパターンの追加削除を実行する。
        saveServicePattern();

        // 終了を許可するならばtrueを返す。
        return true;
    }

    // コンポーネントイベント

    /**
     * 「印刷処理」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void printWeeklyActionPerformed(ActionEvent e) throws Exception {
        // ■週間サービス計画表印刷
        // 　※週間サービス計画表を印刷する。
        // 　　渡り用パラメータ printParam(レコード)を生成し、下記の値を設定する。
        VRMap printParam = new VRHashMap();
        // 　　　KEY : PATIENT_NAME, VALUE : 利用者氏名
        VRBindPathParser.set("PATIENT_NAME", printParam, getPatientName()
                .getText());
        // 　　　KEY : PATIENT_ID, VALUE : 利用者番号(渡りパラメータ KEY : PATIENT_IDのVALUE)
        VRBindPathParser.set("PATIENT_CODE", printParam,
                getPatientInfo().get("PATIENT_CODE"));
        // 　　　KEY : CREATE_DATE, VALUE : 作成年月日(週間表から取得)
        // 　　　KEY : TARGET_DATE, VALUE : 対象年月(渡りパラメータ KEY : TARGET_DATEのVALUE)
        VRBindPathParser.set("TARGET_DATE", printParam, getTargetDate());
        // 　　　KEY : WEEKLY_SERVICE, VALUE : 週間表・週単位のサービス(レコード集合)
        VRBindPathParser.set("WEEKLY_SERVICE", printParam, getWeeklyPanel()
                .getAllWeeklySchedule());
        // 　　　KEY : NON_WEEKLY_SERVICE, VALUE : 週間表・週単位以外のサービス（レコード集合)
        VRBindPathParser.set("NON_WEEKLY_SERVICE", printParam, getWeeklyPanel()
                .getAllFreedaySchedule());

        Date date = null;
        if ((!ACTextUtilities.isNullText(getWeeklyPanel().getCreateDate()
                .getText())) && getWeeklyPanel().getCreateDate().isValidDate()) {
            date = getWeeklyPanel().getCreateDate().getDate();
        }
        VRBindPathParser.set("CREATE_DATE", printParam, date);

        VRBindPathParser.set("M_SERVICE", printParam,
                QkanCommon.getMasterService(getDBManager(), getTargetDate()));
        // 　　印刷を行う。
        // doPrint(QS00101, printParam);
        ACChotarouXMLWriter writer = new ACChotarouXMLWriter();
        writer.beginPrintEdit();
        new QS001P01().doPrint(writer, printParam);
        writer.endPrintEdit();
        ACChotarouXMLUtilities.openPDF(writer);

    }

    /**
     * 「印刷処理」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void printMonthlyActionPerformed(ActionEvent e) throws Exception {
        // ■利用票・計画票印刷

        if (!getMonthlyPanel().checkPrintable()) {
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
        if (getProcessType() == QkanConstants.PROCESS_TYPE_PLAN) {
            mode = QkanConstants.SERVICE_DETAIL_GET_PLAN;
        } else {
            mode = QkanConstants.SERVICE_DETAIL_GET_RESULT;
        }
        new QS001003().showModal(getCalcurater(), getMonthlyPanel()
                .getSchedule(mode, false), getProcessType());

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
        if (doInsert()) {
            // 登録成功のメッセージを表示する。※ID=INSERT_SUCCESSED
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
        if (doUpdate()) {
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
        // VRBindPathParser.set("LOGIN_PROVIDER_ID", param,
        // QkanSystemInformation
        // .getInstance().getLoginProviderID());
        VRBindPathParser.set("TARGET_DATE", param, getTargetDate());
        VRList schedules = null;
        ACDBManager dbm = getDBManager();
        try {
            dbm.beginTransaction();
            VRList list = dbm.executeQuery(getSQL_GET_LAST_PLAN_DATE(param));
            if (list.size() > 0) {
                Object obj = VRBindPathParser.get("TARGET_DATE",
                        (VRMap) list.getData());
                if (obj instanceof Date) {
                    schedules = QkanCommon
                            .getServiceDetail(
                                    dbm,
                                    getPatientID(),
                                    (Date) obj,
                                    QkanConstants.SERVICE_DETAIL_GET_PLAN_OF_WEEKLY_ONLY);
                    // ユニークキーの削除
                    Iterator it = schedules.iterator();
                    while (it.hasNext()) {
                        Map service = (Map) it.next();
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
            // getMonthlyPanel().setSchedule(schedules);
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
        // if (QkanMessageList.getInstance().QS001_WARNING_OF_CLEAR_MONTHLY() ==
        // ACMessageBox.RESULT_OK) {
        // getMonthlyPanel().clearSchedule();
        // }
        if (getMonthlyPanel().isVisible()) {
            if (QkanMessageList.getInstance().QS001_WARNING_OF_CLEAR_MONTHLY() == ACMessageBox.RESULT_OK) {
                getMonthlyPanel().clearSchedule();
                
                // [CCCX: 03987][Shinobu Hitaka] 2017/07/25 add begin 計画単位数クリア
                getMonthlyPanel().getPlanUnits().clear();
                // [CCCX: 03987][Shinobu Hitaka] 2017/07/25 add end
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
        if (idx >= 0) {
            getServiceKindList().ensureIndexIsVisible(idx);
        }
        // 最大パネル幅の維持
        Dimension newDM = getServiceContentSettings().getPreferredSize();
        if (newDM != null) {
            Dimension oldDM = getServicePreferredSize();
            if ((oldDM == null) || (oldDM.getWidth() < newDM.getWidth())) {
                // より大きな幅を要求された
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
            service = (VRMap) service.clone();
            service.setData("SERVICE_USE_TYPE",
                    QkanConstants.SERVICE_USE_TYPE_PATTERN);

            // 予防時対応（要望対応）
            // 2006/05 TODO
            boolean isEmptyNo = false;
            Object obj = getPatternList().getModelAtBindSource();
            while (obj instanceof VRListModelAdapter) {
                obj = ((VRListModelAdapter) obj).getAdaptee();
            }
            if (obj instanceof VRList) {
                // リストの数ループ処理
                VRList list = ((VRList) obj);
                VRMap inMap = new VRHashMap();
                // リスト内の内部番号をinMapに格納する。
                for (int k = 0; k < list.size(); k++) {
                    VRMap map = new VRHashMap();
                    map = (VRMap) list.getData(k);
                    if (VRBindPathParser
                            .has(ACCastUtilities
                                    .toString(QkanConstants.INTERNAL_SERVICE_PATTERN_NO_BIND_PATH),
                                    map)) {
                        inMap.put(
                                ACCastUtilities
                                        .toString(map.getData(ACCastUtilities
                                                .toString(QkanConstants.INTERNAL_SERVICE_PATTERN_NO_BIND_PATH))),
                                "");
                    } else {
                        inMap.put(ACCastUtilities.toString(k + 1), "");
                    }
                }

                // 採番に使う番号を取得する
                int count = 0;
                for (int j = 0; j < list.size() + 1; j++) {
                    count++;
                    if (!VRBindPathParser.has(ACCastUtilities.toString(j + 1),
                            inMap)) {
                        // 空き番号
                        emptyNo = j + 1;
                        break;
                    }
                }
                // 空き番号があるのか
                if (count <= list.size()) {
                    isEmptyNo = true;
                }

                service.setData(
                        ACCastUtilities
                                .toString(QkanConstants.INTERNAL_SERVICE_PATTERN_NO_BIND_PATH),
                        new Integer(emptyNo));
            }

            service.setData("REGULATION_RATE", new Integer(0));

            // 設定内容でサービスパターンを追加
            if (isEmptyNo) {
                getNowServicePatterns().add(emptyNo - 1, service);
            } else {
                getNowServicePatterns().add(service);
            }
            // ユニークキーの削除
            service.remove("SERVICE_ID");

            // 2008/01/24 [Masahiko_Higuchi] add - begin version 5.3.8
            service.remove("CORRECT_KEY");
            service.setData("CORRECT_KEY", new Integer(correctKey));
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
        if (pattern.containsKey("CORRECT_KEY")) {
            // メインのキー
            String mainKey = ACCastUtilities.toString(
                    pattern.getData("CORRECT_KEY"), "");

            for (int i = getInsertReserveServicePatterns().size(); i > 0; i--) {
                // チェック用のキー情報
                Map checkMap = (Map) getInsertReserveServicePatterns().getData(
                        i - 1);

                if (checkMap.containsKey("CORRECT_KEY")) {
                    // パターン追加で増やした情報を削るためのキー
                    String delKey = ACCastUtilities.toString(
                            checkMap.get("CORRECT_KEY"), "-1");

                    if (delKey.equals(mainKey)) {
                        // 一致した場合は登録用のデータ集合がから削る
                        getInsertReserveServicePatterns().remove(i - 1);

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
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void serviceOfferEntrepreneurActionPerformed(ActionEvent e)
            throws Exception {
        // ■事業所コンボ選択時イベント
        // ※選択した事業所情報に応じた、サービス内容の項目の状態設定
        // 　現在設定されている「詳細項目(サービスのパネル)」に対し、選択した事業所に応じた状態設定を行う。(providerSelected)
        if (getServiceOfferEntrepreneur().isSelected()) {
            QS001Service service = getSelectedServiceClass();
            QS001ServicePanel servicePanel = (QS001ServicePanel) service;
            if (service != null) {
                if (service.isUseProvider()) {
                    VRMap provider = (VRMap) getServiceOfferEntrepreneur()
                            .getSelectedModelItem();
                    if (service instanceof QS001ServicePanel) {
                        // パネル全体を有効に
                        servicePanel.setFollowChildEnabled(true);
                        servicePanel.setEnabled(true);

                        if (servicePanel.checkProvider(provider)) {
                            servicePanel.setSelectedProvider(provider);
                            // getSelectedServiceClass().initialize();
                            service.providerSelected(provider);

                            // 設定ボタン等を有効に
                            setState_USABLE_PROVIDER();

                            // 利用できる事業所フラグ
                            setUsableProvider(true);
                        } else {
                            // 無効な事業所が選択された場合はパネルの値をすべてクリア
                            service.initialize();
                            servicePanel.setSource((VRBindSource) servicePanel
                                    .createSource());
                            servicePanel.bindSource();
                            QkanCommon.selectFirstRadioItem(servicePanel);

                            // パネル全体を無効に
                            servicePanel.setFollowChildEnabled(true);
                            servicePanel.setEnabled(false);

                            // 設定ボタン等を無効に
                            setState_NOT_USABLE_PROVIDER();
                            // 利用できない事業所フラグ
                            setUsableProvider(false);
                            return;
                        }
                    }
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
                if (CareServiceCommon.isOtherService(data)) {
                    // その他のサービスの場合
                    if ((!getWeeklyPanel().isWeeklyServiceList(
                            getSelectedServiceListBox()))
                            || (getWeeklyPanel()
                                    .isDailyServiceList(getSelectedServiceListBox()))) {
                        // 週間のリストではない、または日常生活上の活動リストの場合
                        // 何もしない。
                        return;
                    }
                }
                if (CareServiceCommon.isDailyAction(data)) {
                    // 主な日常生活上の活動の場合
                    if (!getWeeklyPanel().isDailyServiceList(
                            getSelectedServiceListBox())) {
                        // 日常生活上の活動リストではない場合
                        // 何もしない。
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
                    data.setData(
                            QkanConstants.SERVICE_SYSTEM_BIND_PATH_SPAN,
                            VRBindPathParser
                                    .get(QkanConstants.SERVICE_SYSTEM_BIND_PATH_SPAN,
                                            service));
                } else if (getSelectedServiceListBox() == getPatternList()) {
                    // 予防時対応（要望対応）
                    // 2005/06
                    data.setData(
                            ACCastUtilities
                                    .toString(QkanConstants.INTERNAL_SERVICE_PATTERN_NO_BIND_PATH),
                            VRBindPathParser.get(
                                    ACCastUtilities
                                            .toString(QkanConstants.INTERNAL_SERVICE_PATTERN_NO_BIND_PATH),
                                    service));

                    // 2008/01/25 [Masahiko_Higuchi] add - begin
                    // サービスパターン設定ボタン操作実行時エラー対応
                    if (service.containsKey("SERVICE_USE_TYPE")) {
                        Integer useType = ACCastUtilities.toInteger(
                                service.getData("SERVICE_USE_TYPE"), -1);
                        // サービスパターンの区分は保持する
                        if (!new Integer(-1).equals(useType)) {
                            data.setData("SERVICE_USE_TYPE", useType);
                        }
                        // サービスIDが消し去られるので保持する
                        if (service.containsKey("SERVICE_ID")) {
                            data.setData("SERVICE_ID",
                                    service.getData("SERVICE_ID"));

                            // 比較用のサービスIDを取得する
                            String mainServiceID = ACCastUtilities.toString(
                                    service.getData("SERVICE_ID"), "");
                            // サービスパターン追加用のデータ集合を全てチェックする。
                            for (int i = getInsertReserveServicePatterns()
                                    .size(); i > 0; i--) {
                                Map serviceIDCheckMap = (Map) getInsertReserveServicePatterns()
                                        .get(i - 1);
                                // 格納されているキーを取得する
                                int idCheckKey = ACCastUtilities
                                        .toInt(serviceIDCheckMap
                                                .get("SERVICE_ID"), -2);

                                String checkKey = ACCastUtilities
                                        .toString(idCheckKey);
                                // KEYが既に登録されている場合
                                if (checkKey.equals(mainServiceID)) {
                                    // クリアする
                                    getInsertReserveServicePatterns().remove(
                                            i - 1);
                                }
                            }
                        }

                        // 追加したサービスパターン変更に備え内部で振ったKEYを元に登録データの重複を防ぐ
                        if (service.containsKey("CORRECT_KEY")) {

                            data.setData("CORRECT_KEY",
                                    service.getData("CORRECT_KEY"));
                            // 削除して追加対称にする
                            String serviceInKey = ACCastUtilities.toString(
                                    service.getData("CORRECT_KEY"), "");

                            for (int j = getInsertReserveServicePatterns()
                                    .size(); j > 0; j--) {
                                Map maps = (Map) getInsertReserveServicePatterns()
                                        .getData(j - 1);
                                // キーを取り出す
                                int checkKey = ACCastUtilities.toInt(
                                        maps.get("CORRECT_KEY"), -1);

                                String strKey = ACCastUtilities
                                        .toString(checkKey);
                                // KEYが既に登録されている場合
                                if (strKey.equals(serviceInKey)) {
                                    // クリアする
                                    getInsertReserveServicePatterns().remove(
                                            j - 1);
                                }
                            }
                        }

                        getDeleteReseveServicePatterns().add(service);
                        // 再追加
                        getInsertReserveServicePatterns().add(service);
                    }
                    // サービスパターンの再設定処理
                    if (service.containsKey("11")) {
                        String patternName = ACCastUtilities.toString(
                                service.getData("11"), "");
                        if (!"".equals(patternName)) {
                            data.setData("11", patternName);
                        }
                    }
                    // 2008/01/25 [Masahiko_Higuchi] add - End
                }

                int selectedIndex = -1;
                if (getSelectedServiceListBox() != null) {
                    selectedIndex = getSelectedServiceListBox()
                            .getSelectedIndex();
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
                    } else {
                        service.put("REGULATION_RATE", new Integer(rate));
                    }
                }
                
                
                // 2013/10/12 [Shinobu_Hitaka] add - begin
                // 同日同サービスがリストの下にある時、SERVICE_IDをクリアして順位を保持する（登録時にIDを振りなおさせる為）
                if (getSelectedServiceListBox() != null) {
	                VRList selServices = getSelectedServiceListBox().getSchedule();
	                if (selectedIndex >= 0){
	                	Object selDate = service.get("SERVICE_DATE");
	                	if (selDate != null) {
			                Date srcDate = ACCastUtilities.toDate(selDate);
			                String srcSystemServiceKindDetail = ACCastUtilities.toString(service.get("SYSTEM_SERVICE_KIND_DETAIL"), "");
			                // 配列の後方を検索
			                for (int i = selectedIndex+1; i < selServices.size(); i++) {
			                    VRMap destService = (VRMap) selServices.get(i);
			                    Object destServiceDate = destService.get("SERVICE_DATE"); // 2017/06/26 add
			                    if (destServiceDate == null) continue; // 2017/06/26 add
			                    Date destDate = ACCastUtilities.toDate(destServiceDate);
			                    String destSystemServiceKindDetail = ACCastUtilities.toString(destService.get("SYSTEM_SERVICE_KIND_DETAIL"), "");
			                    // 日付とサービス種類コードが同じ場合
			                    if (srcDate.equals(destDate) && srcSystemServiceKindDetail.equals(destSystemServiceKindDetail)){
			                    	// サービスIDを削除
			                    	destService.remove("SERVICE_ID");
			                    }
			                }
	                	}
	                }
                }
                // 2013/10/12 [Shinobu_Hitaka] add - end
                
                
                // 2008/01/25 [Masahiko_Higuchi] del - begin
                // サービスパターン設定ボタン操作実行時エラー対応
                // setServiceModify(true);
                // 2008/01/25 [Masahiko_Higuchi] del - end

                if (getSelectedServiceListBox() != null) {
                    getSelectedServiceListBox().setSelectedIndex(selectedIndex);
                    // 2008/01/25 [Masahiko_Higuchi] add - begin
                    // サービスパターン設定ボタン操作実行時エラー対応
                    if (getSelectedServiceListBox() != getPatternList()) {
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
    protected void serviceDeleteActionPerformed(ActionEvent e) throws Exception {
        // ■週間表・月間表上のサービス情報の削除
        // ※週間表・月間表上で選択されている、サービス情報を削除する。
        removeSelectedService();
    }

    /**
     * 「週間表・月間表の切替」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void changeChartActionPerformed(ActionEvent e) throws Exception {
        // ■週間表・月間表の表示切替
        if (getWeeklyPanel().isVisible()) {
            // 　現在表示されているのが週間表の場合
            // 　　月間表表示処理を行う。
            showMonthly();
        } else {
            // 　現在表示されているのが月間表の場合
            // 　　週間表表示処理を行う。
            showWeekly();
        }
        clearServiceSelection();
    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();

        // テストパラメタ
        VRMap param = new VRHashMap();
        // param.setData("TARGET_DATE", new Date(106,0,8));
        QkanSystemInformation.getInstance().setLoginProviderID("5555555555");
        param.setData("TARGET_DATE", new Date(106, 3, 1));
        // param.setData("PATIENT_ID", new Integer(38));
        param.setData("PATIENT_ID", new Integer(51));
        param.setData("PROCESS_TYPE", new Integer(
                QkanConstants.PROCESS_TYPE_PLAN));
        // param.setData("PROCESS_TYPE", new
        // Integer(QkanConstants.PROCESS_TYPE_RESULT));

        ACFrame.debugStart(new ACAffairInfo(QS001.class.getName(), param));
    }

    // 内部関数

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

        // ■入力チェック
        final String[] SENMONIN_NO_TYPE = new String[] { "1430107", "1730104",
                "1750104", "1460103", "1770116" };
        
        // 複数回チェックの防止
        boolean doubleCheck_15111 = false;
        boolean doubleCheck_15411 = false;
        
        
        // 2016/10 [Yoichiro Kamei] add - begin 総合事業独自対応
        QkanSjInsurerChecker sjInsurerChecker = new QkanSjInsurerChecker(getCalcurater());
        boolean isSogoAdjudtUnitCheck = false; //総合事業の調整額のチェックを行うかどうか
        // 2016/10 [Yoichiro Kamei] add - begin 総合事業独自対応
        
        // 2017/06 [Yoichiro Kamei] add - begin AF対応
        boolean isAfExists = false; //AFが登録されているかどうか
        boolean isGendogakuYoboSvExists = false; //限度額管理対象の予防サービスが登録されているかどうか
        // 2017/06 [Yoichiro Kamei] add - end AF対応
        
        // 予防時対応（要望）
        // 2005/05/31
        // ※介護支援専門員番号が未入力の場合の未入力チェック
        while (it.hasNext()) {
            // [ID:0000483][Masahiko Higuchi] 2009/04 edit begin 平成21年4月法改正対応
            Object loopObj = it.next();
            // 不正データチェック
            if (!(loopObj instanceof VRMap)) {
                continue;
            }
            // VRMapで取得
            VRMap row = (VRMap) loopObj;
            // [ID:0000483][Masahiko Higuchi] 2009/04 edit end
            if (CareServiceCommon.isCareManagement(row)
                    || CareServiceCommon.isFacilityVisitMultifunction(row)) {
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
                if (!isInputSenmoninNo) {
                    // エラーメッセージを表示する。
                    if (QkanMessageList.getInstance()
                            .QS001_WARNING_OF_SENMONIN_NO() == ACMessageBox.RESULT_OK) {
                        // 1度メッセージを出したらもう出さない
                        break;
                    } else {
                        // OK以外は処理を中止
                        return false;
                    }

                }
            }
            int lowVer = CareServiceCommon.getServiceLowVersion(row);
            
// 2014/1/9 [Yoichiro Kamei] mod - begin H27.4改正対応
//            // 平成24年4月以降の場合
//            // 法改正区分による過去データの判別
//            if (lowVer != QkanConstants.SERVICE_LOW_VERSION_H2404) {
//                // 法改正区分が20090401以外のサービスの場合
            // 平成27年4月以降の場合
            // 法改正区分による過去データの判別
            if (lowVer != QkanConstants.SERVICE_LOW_VERSION_H2704) {
                // 法改正区分が20150401以外のサービスの場合
// 2014/1/9 [Yoichiro Kamei] mod - end
                Date serviceDate = ACCastUtilities.toDate(
                        VRBindPathParser.get("SERVICE_DATE", row), null);
                String dayOfMonth = "";
                if (serviceDate != null) {
                    dayOfMonth = ACDateUtilities.getDayOfMonth(serviceDate)
                            + "日の";
                }
                VRMap serviceKind = ACBindUtilities.getMatchRowFromValue(
                        getServiceKindsList(), "SYSTEM_SERVICE_KIND_DETAIL",
                        row.get("SYSTEM_SERVICE_KIND_DETAIL"));
                String serviceKindName = "サービス";
                if (serviceKind != null) {
                    serviceKindName = ACCastUtilities.toString(serviceKind
                            .get("SERVICE_ABBREVIATION"));
                }
                // エラーメッセージ
                QkanMessageList.getInstance()
                        .QS001_ERROR_OF_INVALID_SERVICE_LOW_VERSION(dayOfMonth,
                                serviceKindName);
                return false;
            }

            // 介護老人福祉施設の場合
            if ("15111".equals(ACCastUtilities.toString(VRBindPathParser.get(
                    "SYSTEM_SERVICE_KIND_DETAIL", row)))) {
                // 日常生活継続支援
                if (ACCastUtilities.toInt(row.getData("1510133"), 0) > 1 && !doubleCheck_15111) {
                    // サービス提供体制強化加算が算定されている
                    if (ACCastUtilities.toInt(row.getData("1510141"), 0) > 1) {
                        if (QkanMessageList.getInstance()
                                .QO004_WARNING_OF_DOUBLE_CHECK(
                                        "日常生活継続支援加算とサービス提供体制強化加算の両方") != ACMessageBox.RESULT_OK) {
                            // エラー
                            return false;

                        }
                        doubleCheck_15111 = true;
                    }
                }
            } else if ("15411".equals(ACCastUtilities.toString(VRBindPathParser
                    .get("SYSTEM_SERVICE_KIND_DETAIL", row)))) {
                // 地域密着型介護老人福祉施設
                // 日常生活継続支援
                if (ACCastUtilities.toInt(row.getData("1540129"), 0) > 1 && !doubleCheck_15411) {
                    // サービス提供体制強化加算が算定されている
                    if (ACCastUtilities.toInt(row.getData("1540136"), 0) > 1) {
                        if (QkanMessageList.getInstance()
                                .QO004_WARNING_OF_DOUBLE_CHECK(
                                        "日常生活継続支援加算とサービス提供体制強化加算の両方") != ACMessageBox.RESULT_OK) {
                            // エラー
                            return false;

                        }
                        doubleCheck_15411 = true;
                    }
                }
            }
            // [H28.4法改正対応][Shinobu Hitaka] 2016/01/29 add begin 
            // 対象年月がH28.4以降は、下記サービス種類にて 1:小規模型,5:療養 はNGとする
            // 15:通所介護の施設区分(115113), 33:外部利用通所介護の施設区分(1330126)
            if (ACDateUtilities.getDifferenceOnMonth(getTargetDate(),ACDateUtilities.createDate(2016, 4)) >= 0) {
                int kubun = 0;
                if ("11511".equals(ACCastUtilities.toString(VRBindPathParser
                        .get("SYSTEM_SERVICE_KIND_DETAIL", row)))) {
                    kubun = ACCastUtilities.toInt(row.getData("1150113"), 0);
                }
                if ("13311".equals(ACCastUtilities.toString(VRBindPathParser
                        .get("SYSTEM_SERVICE_KIND_DETAIL", row)))) {
                    kubun = ACCastUtilities.toInt(row.getData("1330126"), 0);
                }

                // 施設区分が「1:小規模型」「5:療養」は設定不可
                if (kubun == 1 || kubun == 5) {
                    Date serviceDate = ACCastUtilities.toDate(
                    	    VRBindPathParser.get("SERVICE_DATE", row), null);
                    String dayOfMonth = "";
                    if (serviceDate != null) {
                        dayOfMonth = ACDateUtilities.getDayOfMonth(serviceDate) + "日の";
                    }
                    VRMap serviceKind = ACBindUtilities.getMatchRowFromValue(
                            getServiceKindsList(), "SYSTEM_SERVICE_KIND_DETAIL",
                            row.get("SYSTEM_SERVICE_KIND_DETAIL"));
                    String serviceKindName = "サービス";
                    if (serviceKind != null) {
                        serviceKindName = ACCastUtilities.toString(serviceKind
                                .get("SERVICE_ABBREVIATION"));
                        }
                    // エラーメッセージ
                    QkanMessageList.getInstance()
                        .QS001_ERROR_OF_INVALID_SERVICE_LOW_VERSION(dayOfMonth,
                                serviceKindName);
                    return false;
                    }
            }
            // [H28.4法改正対応][Shinobu Hitaka] 2016/01/29 add end 
            
            // 2016/10 [Yoichiro Kamei] add - begin 総合事業独自対応
            String skind = ACCastUtilities.toString(row.get("SYSTEM_SERVICE_KIND_DETAIL"), "");
            if (QkanSjServiceCodeManager.dokujiTeiritsuTeigakuCodes.contains(skind)) {
                // 算定可能な保険者のコードかチェック
                try {
                    sjInsurerChecker.checkCodes(row);
                } catch (QkanSjInsurerException e) {
                    Date serviceDate = ACCastUtilities.toDate(row.get("SERVICE_DATE"), null);
                    String dayOfMonth = "";
                    if (serviceDate != null) {
                        dayOfMonth = ACDateUtilities.getDayOfMonth(serviceDate) + "日の";
                    }
                    // サービスコード
                    Map code = e.getCode();
                    String svCode = 
                    ACCastUtilities.toString(code.get("SERVICE_CODE_KIND"), "") + "-" +
                    ACCastUtilities.toString(code.get("SERVICE_CODE_ITEM"), "");

                    String svCodedName = "コード: [" + svCode+ "] ";
                    String addMsg =  "内容を確認してください。";
                    if (e.isTukitotyuJushotiTokurei()) {
                        if ("3".equals(ACCastUtilities.toString(code.get("TOTAL_GROUPING_TYPE"), ""))) {
                            addMsg = "月途中住所地特例の場合、月額サービスは、月末時点の保険者のサービスを設定してください。";
                        }
                    }
                    // エラーメッセージ
                    QkanMessageList.getInstance().QS001_ERROR_OF_INVALID_INSURER_ID(dayOfMonth, svCodedName, addMsg);
                    return false;
                }
                // 独自・独自定率・独自定額サービスの登録があって、
                // 計画単位数が入力されている場合、実績保存時に調整額のチェックを行う
                VRMap planUnits = getMonthlyPanel().getPlanUnits();
                if ((planUnits != null) && (!planUnits.isEmpty())) {
                    isSogoAdjudtUnitCheck = true;
                }
            }
            // 2016/10 [Yoichiro Kamei] add - end
            
            
            // 2017/06 [Yoichiro Kamei] add - begin AF対応
            // AFが登録されている場合
            if (QkanSjServiceCodeManager.afCodes.contains(skind)) {
            	isAfExists = true;
            }            
            // 2017/06 [Yoichiro Kamei] add - end
            
        }

        // ※回数チェック
        // 対象年月が、平成21年4月以降の場合
        // ※居宅介護支援・回数チェック

        // 居宅介護支援の検出回数を表す数値変数countOf14311を定義し、0で初期化する。
        int countOf14311 = 0;
        // 介護予防支援の検出回数を表す数値変数countOf14611を定義し、0で初期化する。
        int countOf14611 = 0;
        final String BIND_PATH_OF_SYSTEM_SERVICE_KIND_DETAIL = "SYSTEM_SERVICE_KIND_DETAIL";

        // 月間表上のサービスを全走査する。
        it = list.iterator();
        while (it.hasNext()) {
            VRMap row = (VRMap) it.next();
            // エラーとなったサービス名を表す文字列変数errorServiceを定義し、nullで初期化する。
            String errorService = null;
            switch (ACCastUtilities.toInt(VRBindPathParser.get(
                    BIND_PATH_OF_SYSTEM_SERVICE_KIND_DETAIL, row), 0)) {
            case 14311:
                // [ID:0000702][Masahiko.Higuchi] 2012/03 平成24年4月法改正対応 edit begin
                // サービスが居宅介護支援の場合 かつ 基本算定の場合
                // countOf14311に1を加算する。
                if ((ACCastUtilities.toInt(row.getData("9"),1) == 1) && ++countOf14311 >= 2) {
                    // countOf14311が2以上の場合
                    // errorServiceに"居宅介護支援"を代入する。
                    errorService = "居宅介護支援";
                }
                // [ID:0000702][Masahiko.Higuchi] 2012/03 edit end
                break;
            case 14611:
                // サービスが介護予防支援の場合
                // countOf14611に1を加算する。
                if (++countOf14611 >= 2) {
                    // countOf14611が2以上の場合
                    // errorServiceに"介護予防支援"を代入する。
                    errorService = "介護予防支援";
                }
                break;
            }
            if (errorService != null) {
                // errorServiceがnullではない場合
                // 上限回数を超えている旨のエラー(ERROR_OF_SERVICE_COUNT_OVER)を表示する。
                QkanMessageList.getInstance()
                        .QS001_ERROR_OF_SERVICE_COUNT_OVER(errorService,
                                new Integer(1));
                // 戻り値falseを返して処理を終了する。
                return false;
            }
        }

        // ※その他の回数超過警告チェック
        int[] countOf50111 = {0, 0, 0, 0};
        int[] countOf50211 = {0, 0, 0, 0};
        int[] countOf50511 = {0, 0};
        int[] countOf50611 = {0, 0};
        String sogoErrorService = null;

        // 月n回を上限とする加算
        String[][] monthlyAddCountChecks = new String[][] {
                // SERVICE_NAME,SYSTEM_SERVICE_KIND_DETAIL,加算名,SYSTEM_BIND_PATH,計上する値,上限
                // ※通所介護・通所リハ・認知症対応型通所介護・地域密着型通所介護（H28.4 改正）
                // 栄養改善加算：月2回
                // 口腔機能：月2回
                { "通所介護", "11511", "栄養改善加算", "1150116", "2", "2", },
                { "通所介護", "11511", "口腔機能向上加算", "1150112", "2", "2", },
                { "通所リハ", "11611", "栄養改善加算", "1160114", "2", "2", },
                { "通所リハ", "11611", "口腔機能向上加算", "1160115", "2", "2", },
                { "認知症対応型通所介護", "17211", "栄養改善加算", "1720105", "2", "2", },
                { "認知症対応型通所介護", "17211", "口腔機能向上加算", "1720108", "2", "2", },
                { "地域密着型通所介護", "17811", "栄養改善加算", "1780110", "2", "2", },
                { "地域密着型通所介護", "17811", "口腔機能向上加算", "1780111", "2", "2", },
                // ※通所リハ
                // 個別リハ加算：月13回
                { "通所リハ", "11611", "個別リハビリ実施加算", "1160118", "2", "13", },
        // ※居宅介護支援
        // 医療連携加算：月1回(居宅介護支援自体、ひと月に2個配置したらエラーになる)
        // {"居宅介護支援","14311","医療機関連携加算","1430109","2","1",},
        };
        // 週n回を上限とするサービス
        String[][] weeklyServiceCountChecks = new String[][] {
        // SERVICE_NAME,SYSTEM_SERVICE_KIND_DETAIL,上限
        // ※訪問リハ
        // 1週間に6回
        { "訪問リハ", "11411", "6", }, };

        // 月n日を上限とする加算
        String[][] monthlyDayAddCountChecks = new String[][] {
                // SERVICE_NAME,SYSTEM_SERVICE_KIND_DETAIL,加算名,SYSTEM_BIND_PATH,計上する値,上限
                // ※特養・老健・療養型
                // 外泊：月6日
                { "介護老人福祉施設", "15111", "外泊加算", "1510111", "2", "6", },
                { "介護老人保健施設", "15211", "外泊加算", "1520107", "2", "6", },
                { "介護療養型医療施設(病院療養型)", "15311", "外泊加算", "1530108", "2", "6", },
                { "介護療養型医療施設(診療所型)", "15312", "外泊加算", "1530206", "2", "6", },
                { "介護療養型医療施設(認知症疾患型)", "15313", "外泊加算", "1530305", "2", "6", }, };
        int[] monthlyAddCountResults = new int[monthlyAddCountChecks.length];
        int[][] weeklyServiceCountResults = new int[weeklyServiceCountChecks.length][7];
        int[] monthlyDayAddCountResults = new int[monthlyDayAddCountChecks.length];
        boolean[][] monthlyDayAddFindFlags = new boolean[monthlyDayAddCountChecks.length][32];

        int end;
        end = monthlyAddCountChecks.length;
        for (int i = 0; i < end; i++) {
            monthlyAddCountResults[i] = ACCastUtilities
                    .toInt(monthlyAddCountChecks[i][5]);
        }
        end = weeklyServiceCountChecks.length;
        for (int i = 0; i < end; i++) {
            int limit = ACCastUtilities.toInt(weeklyServiceCountChecks[i][2]);
            for (int j = 0; j < 7; j++) {
                weeklyServiceCountResults[i][j] = limit;
            }
        }
        end = monthlyDayAddCountChecks.length;
        for (int i = 0; i < end; i++) {
            monthlyDayAddCountResults[i] = ACCastUtilities
                    .toInt(monthlyDayAddCountChecks[i][5]);
        }

        // 月間表上のサービスを全走査する。
        it = list.iterator();
        while (it.hasNext()) {
            VRMap row = (VRMap) it.next();

            String systemServiceKindDetail = ACCastUtilities
                    .toString(VRBindPathParser.get(
                            "SYSTEM_SERVICE_KIND_DETAIL", row));
            Date visitDay = ACCastUtilities.toDate(
                    VRBindPathParser.get("SERVICE_DATE", row), null);

            // 警告メッセージの要素として以下の文字列変数を定義しnullで初期化する。
            // warningTargetName
            String warningTargetName = null;
            // warningTargetSpan
            String warningTargetSpan = null;
            // warningTargetLimit
            String warningTargetLimit = null;

            // 月n回を上限とする加算をチェックする。
            end = monthlyAddCountChecks.length;
            for (int i = 0; i < end; i++) {
                if (monthlyAddCountChecks[i][1].equals(systemServiceKindDetail)) {
                    // システムサービス種類が該当した場合
                    Object val = VRBindPathParser.get(
                            monthlyAddCountChecks[i][3], row);
                    if (val != null) {
                        // BindPathも該当した場合
                        if (monthlyAddCountChecks[i][4].equals(ACCastUtilities
                                .toString(val))) {
                            // 計上すべき値も該当した場合
                            // 月単位加算残回数に1を減算する。
                            monthlyAddCountResults[i]--;
                            if (monthlyAddCountResults[i] == -1) {
                                // 月単位加算残回数が0を下回った場合

                                // 警告メッセージの要素として以下の変数を代入する。
                                // warningTargetName = SERVICE_NAME+"の"+加算名
                                warningTargetName = monthlyAddCountChecks[i][0]
                                        + "の" + monthlyAddCountChecks[i][2];
                                // warningTargetName = "ひと月に"
                                warningTargetSpan = "ひと月に";
                                // warningTargetLimit = 上限+"回まで"
                                warningTargetLimit = monthlyAddCountChecks[i][5]
                                        + "回まで";

                                // 警告メッセージQS001_WARNING_OF_SERVICE_COUNT_OVERを表示する。
                                if (QkanMessageList.getInstance()
                                        .QS001_WARNING_OF_SERVICE_COUNT_OVER(
                                                warningTargetName,
                                                warningTargetSpan,
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

            // 週n回を上限とするサービスをチェックする。
            end = weeklyServiceCountChecks.length;
            for (int i = 0; i < end; i++) {
                if (weeklyServiceCountChecks[i][1]
                        .equals(systemServiceKindDetail)) {
                    // システムサービス種類が該当した場合
                    if (visitDay != null) {
                        // 週単位加算残回数の当該週目に1を減算する。
                        int week = ACDateUtilities.getWeekOfMonth(visitDay);
                        weeklyServiceCountResults[i][week]--;
                        if (weeklyServiceCountResults[i][week] == -1) {
                            // 週単位残回数が0を下回った場合

                            // 警告メッセージの要素として以下の変数を代入する。
                            // warningTargetName = SERVICE_NAME
                            warningTargetName = weeklyServiceCountChecks[i][0];
                            // warningTargetName = "各週に"
                            warningTargetSpan = "各週に";
                            // warningTargetLimit = 上限+"回まで"
                            warningTargetLimit = weeklyServiceCountChecks[i][2]
                                    + "回まで";

                            // 警告メッセージQS001_WARNING_OF_SERVICE_COUNT_OVERを表示する。
                            if (QkanMessageList.getInstance()
                                    .QS001_WARNING_OF_SERVICE_COUNT_OVER(
                                            warningTargetName,
                                            warningTargetSpan,
                                            warningTargetLimit) != ACMessageBox.RESULT_OK) {
                                // 「OK」以外選択時
                                // 戻り値としてfalseを返す。
                                return false;
                            }
                        }
                    }
                }
            }

            // 月n日を上限とする加算をチェックする。
            end = monthlyDayAddCountChecks.length;
            for (int i = 0; i < end; i++) {
                if (monthlyDayAddCountChecks[i][1]
                        .equals(systemServiceKindDetail)) {
                    // システムサービス種類が該当した場合
                    Object val = VRBindPathParser.get(
                            monthlyDayAddCountChecks[i][3], row);
                    if (val != null) {
                        // BindPathも該当した場合
                        if (monthlyDayAddCountChecks[i][4]
                                .equals(ACCastUtilities.toString(val))) {
                            // 計上すべき値も該当した場合
                            int mday = ACDateUtilities.getDayOfMonth(visitDay);
                            if (!monthlyDayAddFindFlags[i][mday]) {
                                // 月単位日別加算発見フラグの当該日が偽(未発見)の場合
                                // 月単位日別加算発見フラグの当該日を真(発見済)にする。
                                monthlyDayAddFindFlags[i][mday] = true;
                                // 月単位日別加算残回数に1を減算する。
                                monthlyDayAddCountResults[i]--;
                                if (monthlyDayAddCountResults[i] == -1) {
                                    // 月単位日別加算残回数が0を下回った場合

                                    // 警告メッセージの要素として以下の変数を代入する。
                                    // warningTargetName =
                                    // SERVICE_NAME+"の"+加算名
                                    warningTargetName = monthlyDayAddCountChecks[i][0]
                                            + "の"
                                            + monthlyDayAddCountChecks[i][2];
                                    // warningTargetName = "ひと月に"
                                    warningTargetSpan = "ひと月に";
                                    // warningTargetLimit = 上限+"日まで"
                                    warningTargetLimit = monthlyDayAddCountChecks[i][5]
                                            + "日まで";

                                    // 警告メッセージQS001_WARNING_OF_SERVICE_COUNT_OVERを表示する。
                                    if (QkanMessageList
                                            .getInstance()
                                            .QS001_WARNING_OF_SERVICE_COUNT_OVER(
                                                    warningTargetName,
                                                    warningTargetSpan,
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
            
            // [H27.4法改正対応][Shinobu Hitaka] 2016/07/19 add begin 総合事業（みなし・独自）対応
            if ("50111".equals(systemServiceKindDetail)) {
                // 訪問型サービス（みなし）の回数チェック
                if (ACCastUtilities.toInt(row.getData("5010101"),1) == 4) {
                    countOf50111[0]++;
                    if (countOf50111[0] > 4) {
                        warningTargetName = "訪問型サービスIV ";
                        warningTargetSpan = "ひと月に";
                        warningTargetLimit = "4回まで";
                    }
                } else if (ACCastUtilities.toInt(row.getData("5010101"),1) == 5) {
                    countOf50111[1]++;
                    if (countOf50111[1] > 8) {
                        warningTargetName = "訪問型サービスV ";
                        warningTargetSpan = "ひと月に";
                        warningTargetLimit = "5回から8回まで";
                    }
                } else if (ACCastUtilities.toInt(row.getData("5010101"),1) == 6) {
                    countOf50111[2]++;
                    if (countOf50111[2] > 12) {
                        warningTargetName = "訪問型サービスVI ";
                        warningTargetSpan = "ひと月に";
                        warningTargetLimit = "9回から12回まで";
                    }
                } else if (ACCastUtilities.toInt(row.getData("5010101"),1) == 7) {
                    countOf50111[3]++;
                    if (countOf50111[3] > 22) {
                        warningTargetName = "訪問型短時間サービス";
                        warningTargetSpan = "ひと月に";
                        warningTargetLimit = "22回まで";
                    }
                }
            } else if ("50211".equals(systemServiceKindDetail)) {
                // 訪問型サービス（独自）の回数チェック
                // 算定区分：通常
                if (ACCastUtilities.toInt(row.getData("9"),1) == 1) {
                    if (ACCastUtilities.toInt(row.getData("5020101"),1) == 4) {
                        countOf50211[0]++;
                        if (countOf50211[0] > 4) {
                            warningTargetName = "訪問型独自サービスIV ";
                            warningTargetSpan = "ひと月に";
                            warningTargetLimit = "4回まで";
                        }
                    } else if (ACCastUtilities.toInt(row.getData("5020101"),1) == 5) {
                        countOf50211[1]++;
                        if (countOf50211[1] > 8) {
                            warningTargetName = "訪問型独自サービスV ";
                            warningTargetSpan = "ひと月に";
                            warningTargetLimit = "5回から8回まで";
                        }
                    } else if (ACCastUtilities.toInt(row.getData("5020101"),1) == 6) {
                        countOf50211[2]++;
                        if (countOf50211[2] > 12) {
                            warningTargetName = "訪問型独自サービスVI ";
                            warningTargetSpan = "ひと月に";
                            warningTargetLimit = "9回から12回まで";
                        }
                    } else if (ACCastUtilities.toInt(row.getData("5020101"),1) == 7) {
                        countOf50211[3]++;
                        if (countOf50211[3] > 22) {
                            warningTargetName = "訪問型独自短時間サービス";
                            warningTargetSpan = "ひと月に";
                            warningTargetLimit = "22回まで";
                        }
                    }
                }
            } else if ("50511".equals(systemServiceKindDetail)) {
                // 通所型サービス（みなし）の回数チェック
                // 算定区分：通常 ＆ 回数
                if (ACCastUtilities.toInt(row.getData("9"),1) == 1 && ACCastUtilities.toInt(row.getData("5050102"),1) == 2) {
                    if (ACCastUtilities.toInt(row.getData("5050101"),1) == 1) {
                        // サービス１
                        countOf50511[0]++;
                        if (countOf50511[0] > 4) {
                            warningTargetName = "通所型サービス１回数";
                            warningTargetSpan = "ひと月に";
                            warningTargetLimit = "4回まで";
                        }
                    } else if (ACCastUtilities.toInt(row.getData("5050101"),1) == 2) {
                        // サービス２
                        countOf50511[1]++;
                        if (countOf50511[1] > 8) {
                            warningTargetName = "通所型サービス２回数";
                            warningTargetSpan = "ひと月に";
                            warningTargetLimit = "5回から8回まで";
                        }
                    }
                }
            } else if ("50611".equals(systemServiceKindDetail)) {
                // 通所型サービス（独自）の回数チェック
                // 算定区分：通常 ＆ 回数
                if (ACCastUtilities.toInt(row.getData("9"),1) == 1 && ACCastUtilities.toInt(row.getData("5060102"),1) == 2) {
                    if (ACCastUtilities.toInt(row.getData("5060101"),1) == 1) {
                        // サービス１
                        countOf50611[0]++;
                        if (countOf50611[0] > 4) {
                            warningTargetName = "通所型独自サービス１回数";
                            warningTargetSpan = "ひと月に";
                            warningTargetLimit = "4回まで";
                        }
                    } else if (ACCastUtilities.toInt(row.getData("5060101"),1) == 2) {
                        // サービス２
                        countOf50611[1]++;
                        if (countOf50611[1] > 8) {
                            warningTargetName = "通所型独自サービス２回数";
                            warningTargetSpan = "ひと月に";
                            warningTargetLimit = "5回から8回まで";
                        }
                    }
                }
            }
            // 警告メッセージQS001_WARNING_OF_SERVICE_COUNT_OVERを表示する。
            if  (warningTargetName != null) {
                if (QkanMessageList.getInstance()
                        .QS001_WARNING_OF_SERVICE_COUNT_OVER(
                                warningTargetName,
                                warningTargetSpan,
                                warningTargetLimit) != ACMessageBox.RESULT_OK) {
                    // 「OK」以外選択時
                    // 戻り値としてfalseを返す。
                    return false;
                }
            }
            // [H27.4法改正対応][Shinobu Hitaka] 2016/07/19 add end
        }

        // 回数関連のチェックが全て終わった後に認定履歴の絡むチェック
        VRList patientInsureInfoHistory = null;
        // 要介護認定履歴の取得
        patientInsureInfoHistory = QkanCommon.getPatientInsureInfoHistory(
                getDBManager(), getTargetDate(), getPatientID());
        // 当月内に複数履歴存在しない場合は処理終了
        if (patientInsureInfoHistory.size() >= 2) {
            VRList checkList = new VRArrayList();
            for (int i = 0; i < patientInsureInfoHistory.size(); i++) {
                // 履歴を取得する
                VRMap history = (VRMap) patientInsureInfoHistory.getData(i);
                // 要介護認定履歴を格納して突合する
                checkList.add(ACCastUtilities.toString(
                        history.getData("JOTAI_CODE"), ""));
            }
            // 要介護度変化のチェック
            boolean isCheck = false;
            // ループ処理
            for (int i = 1; i < checkList.size(); i++) {
                int beforeHistory = ACCastUtilities.toInt(checkList.get(i - 1),
                        0);
                int afterHistory = ACCastUtilities.toInt(checkList.get(i), 0);
                switch (beforeHistory) {
                case 12: // 要支援１
                    switch (afterHistory) {
                    case 13: // 要支援２
                        isCheck = true;
                        break;
                    }
                    break;

                case 13: // 要支援２
                    switch (afterHistory) {
                    case 12: // 要支援１
                        isCheck = true;
                        break;
                    }
                }
            }
            // 要介護度の変化が確定した段階で履歴取得
            if (isCheck) {
                VRMap history = (VRMap) patientInsureInfoHistory.getData(0);
                Date dayEndInsurer = null;
                Date dayEnd = ACCastUtilities.toDate(history
                        .getData("INSURE_VALID_END"));
                // 終了日の取得
                if (ACDateUtilities.getMonth(getTargetDate()) == ACDateUtilities
                        .getMonth(dayEnd)) {
                    // 同月の場合は採用する
                    dayEndInsurer = ACCastUtilities.toDate(dayEnd);
                } else {
                    // 最終日に変換
                    dayEndInsurer = ACDateUtilities
                            .toLastDayOfMonth(getTargetDate());
                }

                boolean yoboTsukai[][] = new boolean[1][3];
                boolean yoboTsuri[][] = new boolean[1][3];
                // 月間表上のサービスを全走査する。
                it = list.iterator();
                while (it.hasNext()) {
                    VRMap row = (VRMap) it.next();

                    String systemServiceKindDetail = ACCastUtilities
                            .toString(VRBindPathParser.get(
                                    "SYSTEM_SERVICE_KIND_DETAIL", row));
                    Date visitDay = ACCastUtilities.toDate(
                            VRBindPathParser.get("SERVICE_DATE", row), null);
                    // 予防通所介護
                    if ("16511".equals(systemServiceKindDetail)
                            && !yoboTsukai[0][2]) {
                        // 1650109 サービス提供体制強化加算がありの場合
                        if (ACCastUtilities.toInt(row.getData("1650109"), 0) > 1) {
                            if (ACDateUtilities.getDifferenceOnDay(visitDay,
                                    dayEndInsurer) <= 0) {
                                // 同月内最初の履歴
                                yoboTsukai[0][0] = true;
                            } else {
                                // 同月内後方の履歴
                                yoboTsukai[0][1] = true;
                            }
                        }
                        // 警告出力
                        if (yoboTsukai[0][0] && yoboTsukai[0][1]) {
                            if (QkanMessageList.getInstance()
                                    .QS001_WARNING_OF_NINTEI_SERVICE("要支援",
                                            "サービス提供体制強化加算") == ACMessageBox.RESULT_OK) {
                                // OK押下時は何度も出ないようにする。
                                yoboTsukai[0][2] = true;
                            } else {
                                // キャンセル・×ボタン押下時
                                return false;
                            }
                        }
                    } else if ("16611".equals(systemServiceKindDetail)
                            && !yoboTsuri[0][2]) {
                        // 予防通所リハ
                        // 1660108 サービス提供体制強化加算がありの場合
                        if (ACCastUtilities.toInt(row.getData("1660108"), 0) > 1) {
                            if (ACDateUtilities.getDifferenceOnDay(visitDay,
                                    dayEndInsurer) <= 0) {
                                // 同月内最初の履歴
                                yoboTsuri[0][0] = true;
                            } else {
                                // 同月内後方の履歴
                                yoboTsuri[0][1] = true;
                            }
                        }
                        // 警告出力
                        if (yoboTsuri[0][0] && yoboTsuri[0][1]) {
                            if (QkanMessageList.getInstance()
                                    .QS001_WARNING_OF_NINTEI_SERVICE("要支援",
                                            "サービス提供体制強化加算") == ACMessageBox.RESULT_OK) {
                                // OK押下時は何度も出ないようにする。
                                yoboTsuri[0][2] = true;
                            } else {
                                // キャンセル・×ボタン押下時
                                return false;
                            }
                        }
                    }
                }
            }
        }
        
        // [H27.4法改正対応][Shinobu Hitaka] 2015/02/27 add begin 68,69,79のサービス種類は5,6月請求不可 --> 2017/06/16 del
        // 対象年月が4月・5月、かつ、システム日付が7月より前の場合チェックする
//        if ((ACDateUtilities.getDifferenceOnMonth(getTargetDate(),ACDateUtilities.createDate(2015, 6)) < 0)
//        		&& ACDateUtilities.getDifferenceOnMonth(QkanSystemInformation.getInstance().getSystemDate(), ACDateUtilities.createDate(2015, 7)) < 0) {
//	        // 月間表上のサービスを全走査する。
//	        it = list.iterator();
//	        int errorServiceKind = 0;
//	        while (it.hasNext()) {
//	            VRMap row = (VRMap) it.next();
//	            // エラーとなった場合フラグをたてる。
//	            switch (ACCastUtilities.toInt(VRBindPathParser.get(
//	                    BIND_PATH_OF_SYSTEM_SERVICE_KIND_DETAIL, row), 0)) {
//	            case 16811:
//	            case 16911:
//	            case 17911:
//	            	errorServiceKind = 1;
//	            	break;
//	            }
//	        }
//	        if (errorServiceKind != 0) {
//		        if (QkanMessageList.getInstance()
//		                .QS001_WARNING_OF_CLAIM_STARTDATE() == ACMessageBox.RESULT_OK) {
//		        	// OK押下時は処理続行
//		        } else {
//		            // キャンセル・×ボタン押下時
//		            return false;
//		        }
//	        }
//        }
        // [H27.4法改正対応][Shinobu Hitaka] 2015/02/27 add end

        // 2017/06 [Yoichiro Kamei] add - begin AF対応
        // AFが登録されている場合
        if (isAfExists) {
        	QkanSjAfChecker afChecker = new QkanSjAfChecker(getCalcurater(), QkanSjAfChecker.Mode.SERVICE_UPDATE);
        	it = list.iterator();

        	try {
            	while (it.hasNext()) {
                    VRMap row = (VRMap) it.next();
                    afChecker.checkCodes(row);
            	}
        	} catch (QkanSjAfException e) {
        		if (QkanSjAfException.Type.YOBO_GENDOGAKU_SV.equals(e.getType())) {
        	        // エラーメッセージを表示する。
        	        if (QkanMessageList.getInstance()
        	                .QS001_WARNING_OF_SJ_AF_YOBO_GENDOGAKU_SV() != ACMessageBox.RESULT_OK) {
        	            // OK以外は処理を中止
        	            return false;
        	        }      			
        		} else if (QkanSjAfException.Type.YOBO_SHIEN_SV.equals(e.getType())) {
        	        // エラーメッセージを表示する。
        	        if (QkanMessageList.getInstance()
        	                .QS001_ERROR_OF_SJ_AF_YOBO_SHIEN_SV() == ACMessageBox.RESULT_OK) {
        	            // 処理を中止
        	            return false;
        	        }
        		}
        	}
        }            
        // 2017/06 [Yoichiro Kamei] add - end
        
        // 2016/10 [Yoichiro Kamei] add - begin 総合事業独自対応
        // 実績保存時に計画単位数が入力されている場合
        if ((getProcessType() == QkanConstants.PROCESS_TYPE_RESULT) 
            && isSogoAdjudtUnitCheck) {
            try {
                // 調整額を設定するための一時的なIDを付ける
                Map<String, Object> updateKeyMap = new HashMap<String, Object>();
                for (int i = 0; i < list.size(); i++) {
                    VRMap service = (VRMap) list.get(i);
                    String id = String.valueOf(i); //IDは連番
                    service.put(QS001009Event.QS001009_UPDATE_KEY, id);
                    //後で更新対象のサービスをIDから取得するために格納
                    updateKeyMap.put(id, service);
                }
                
                // 総合事業 独自・独自定率・独自定額サービスの調整額と計画単位数の整合性チェック
                CareServiceSummaryManager summary = new CareServiceSummaryManager(
                        getCalcurater(), getMonthlyPanel().getPatientInsureInfoHeaviest(),
                        getMonthlyPanel().getMonthlySchedule().getMasterService());
                
                // データのクローンを作成する。
                VRList cloneServices = new VRArrayList();
                cloneServices.addAll(QkanValidServiceCommon.deepCopyVRList(list));
                summary.initialize(getCalcurater(), cloneServices);
                summary.parsePlanUnits(getMonthlyPanel().getPlanUnits());
                List<Map<String, Object>> ret = summary.checkAndAdjustUnits();
                if (!ret.isEmpty()) {
                    if (ACMessageBox.RESULT_OK == QkanMessageList.getInstance().QS001_WARNING_OF_SJ_LIMIT_OVER_UNIT_INCONSISTENT()) {
                        for (Map item : ret) {
                            Map source = (Map) item.get("PARSED_ROW");
                            int planUnit = ACCastUtilities.toInt(item.get("PLAN_UNIT"), 0);
                            summary.applyPlanUnit(source, planUnit);
                        }
                    } else {
                        QkanMessageList.getInstance().QS001_WARNING_OF_INPUT_SJ_LIMIT_OVER_UNIT();
                        return false;
                    }
                }
                Map<String, Integer> results = summary.getAdjustResults();
                // サービスが更新された場合
                if (!results.isEmpty()) {
                    // 入力された調整額をサービスに反映させる
                    for (String id : results.keySet()) {
                        int adjust = results.get(id);
                        VRMap service = (VRMap) updateKeyMap.get(id);
                        service.put("REGULATION_RATE", adjust);
                    }
                }
            } finally {
                // 調整額を設定するための一時的なIDを削除する
                for (int i = 0; i < list.size(); i++) {
                    VRMap service = (VRMap) list.get(i);
                    service.remove(QS001009Event.QS001009_UPDATE_KEY);
                }
            }
        }
        // 2016/10 [Yoichiro Kamei] add - end
        
        it = list.iterator();

        // [ID:0000456][Masahiko Higuchi] 2009/03 edit begin 平成21年4月法改正対応
        int overFlowCount = 0;
        int overflowIndex = -1;

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

                Date visitDay = ACCastUtilities.toDate(
                        VRBindPathParser.get("SERVICE_DATE", row), null);
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
        end = visitCounts.length;
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
            String[] names = { "" };
            // 平成21年4月以降は区分が追加される
            names = new String[] { "", "医師", "歯科医師", "薬剤師(医療機関)", "薬剤師(薬局)",
                    "管理栄養士", "歯科衛生士等", "看護職員", };

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
                    Object obj = VRBindPathParser.get("PROVIDER_ID", row);
                    if (obj != null) {
                        // 事業所番号がnullでない場合
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

                // [CCCX: 03987][Shinobu Hitaka] 2017/07/25 add begin
                // 実績がなくても計画単位数がクリアされないと実績集計一覧に利用者名が表示される 
                VRList monthlyList = getMonthlyPanel().getSchedule(QkanConstants.SERVICE_DETAIL_GET_RESULT, true);

                // 月間実績がない場合は計画単位数をクリア
                if (monthlyList.size() == 0) {
                    getMonthlyPanel().getPlanUnits().clear();
                }
                // [CCCX: 03987] add end

                // 月間表からdetailsを取る
                details.addAll(getWeeklyPanel().getSchedule());
//                details.addAll(getMonthlyPanel().getSchedule(
//                        QkanConstants.SERVICE_DETAIL_GET_RESULT, true));
                details.addAll(monthlyList);

                // 計画単位数を保存する。
                Iterator it = getMonthlyPanel().getServicePlanUnits().values()
                        .iterator();
                while (it.hasNext()) {
                    VRMap planUnits = (VRMap) it.next();
                    if ((planUnits != null) && (!planUnits.isEmpty())) {
                        final Integer zero = new Integer(0);
                        VRMap systemService = new VRHashMap();
                        VRBindPathParser
                                .set("SERVICE_USE_TYPE",
                                        systemService,
                                        QkanConstants.SERVICE_USE_TYPE_RESULT_MONTHLY_DAY);
                        VRBindPathParser.set("PROVIDER_ID", systemService, "");
                        VRBindPathParser
                                .set("SYSTEM_SERVICE_KIND_DETAIL",
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
            Iterator<VRMap> it = details.iterator();
            while (it.hasNext()) {
                VRMap row = it.next();
                try {
                    VRBindPathParser.set("PATIENT_ID", row, new Integer(
                            getPatientID()));
                } catch (java.util.ConcurrentModificationException ex) {
                    // イテレーションの同期例外は無視
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

                // 2007/12/25 [Masahiko_Higuchi] add - begin Version
                // 5.3.8　2007年度対応
                for (int i = 0; i < details.size(); i++) {
                    VRMap delMap = (VRMap) details.getData(i);
                    // 2008/06/24 [Masahiko.Higuchi] V5.4.1 edit - begin
                    // 同期例外が発生することがあるようなので対応
                    try {
                        // 解析用のキーは消す
                        delMap.remove("ANALYZE");
                        delMap.remove("CORRECT_KEY");
                    } catch (java.util.ConcurrentModificationException ex) {
                        // 同期例外は無視
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
                    dbm.executeUpdate(getSQL_INSERT_PASSIVE_CHECK_RECORD(getPassiveCheckSQLParam()));
                } else {
                    // 更新モードの場合
                    dbm.executeUpdate(getSQL_UPDATE_PASSIVE_CHECK_RECORD(getPassiveCheckSQLParam()));
                    // [ID:0000491][Masahiko Higuchi] 2009/07 edit begin
                    // 再集計時に情報を引き継ぐ機能
                    // 実績確定情報の破棄
                    // QkanCommon.updateClaimDetail(dbm, new VRArrayList(),
                    // getTargetDate(), getPatientID());
                    VRMap sqlParam = new VRHashMap();
                    sqlParam.setData("PATIENT_ID",
                            ACCastUtilities.toInteger(getPatientID()));
                    sqlParam.setData("TARGET_DATE_FIRST",
                            ACDateUtilities.toFirstDayOfMonth(getTargetDate()));
                    sqlParam.setData("TARGET_DATE_LAST",
                            ACDateUtilities.toLastDayOfMonth(getTargetDate()));
                    // 請求番号取得
                    VRList claimList = dbm
                            .executeQuery(getSQL_GET_CLAIM_ID(sqlParam));
                    if (!claimList.isEmpty()) {
                        // 請求情報数ループ処理
                        for (int i = 0; i < claimList.size(); i++) {
                            VRMap claim = (VRMap) claimList.getData(i);
                            Integer claimID = ACCastUtilities.toInteger(claim
                                    .getData("CLAIM_ID"));
                            // 一旦クリア
                            sqlParam = new VRHashMap();
                            sqlParam.setData("CLAIM_ID", claimID);
                            // 請求テーブルの更新処理
                            dbm.executeUpdate(getSQL_UPDATE_CLAIM_ID(sqlParam));
                        }
                    }
                    // [ID:0000491][Masahiko Higuchi] 2009/07 edit end
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
        
        // 2016/9/14 [Yoichiro Kamei] mod - begin 総合事業対応
        // 調整額をもとに計画単位数を設定
        boolean existsRegulationRate = false;
        // 2016/9/14 [Yoichiro Kamei] mod - end
        Iterator it = plans.iterator();
        while (it.hasNext()) {
            // USE_TYPEが予定のものになっているので、実績に差し替える
            VRMap row = (VRMap) it.next();
            Integer useType = new Integer(
                    ACCastUtilities.toString(VRBindPathParser.get(
                            "SERVICE_USE_TYPE", row)));
            if (QkanConstants.SERVICE_USE_TYPE_PLAN_MONTHLY_DAY.equals(useType)) {
                VRBindPathParser.set("SERVICE_USE_TYPE", row,
                        QkanConstants.SERVICE_USE_TYPE_RESULT_MONTHLY_DAY);
            } else if (QkanConstants.SERVICE_USE_TYPE_PLAN_MONTHLY_FREE_DAY
                    .equals(useType)) {
                VRBindPathParser.set("SERVICE_USE_TYPE", row,
                        QkanConstants.SERVICE_USE_TYPE_RESULT_MONTHLY_FREE_DAY);
            }
            // キーを削除
            row.remove("SERVICE_ID");
            
            // 2016/9/14 [Yoichiro Kamei] mod - begin 総合事業対応
            // 調整額が設定されているか確認
            int rate = ACCastUtilities.toInt(row.get("REGULATION_RATE"), 0);
            if (rate > 0) {
                existsRegulationRate = true;
            }
            // 2016/9/14 [Yoichiro Kamei] mod - end
        }
        
        // 2016/12/08 [Shinobu Hitaka] add 登録済みの計画単位数をクリア 
        getMonthlyPanel().getPlanUnits().clear();
        
        // 2016/9/14 [Yoichiro Kamei] mod - begin 総合事業対応
        if (existsRegulationRate) {
            // 調整額をもとに計画単位数の設定を行いますか？
            if (QkanMessageList.getInstance().QS001_READ_PLAN_SAVE_PLAN_UNITS() == ACMessageBox.RESULT_OK) {
                // 「OK」選択時
                // 調整額をもとに計画単位数の登録を行う
                CareServiceSummaryManager summary = new CareServiceSummaryManager(
                    getCalcurater(), getMonthlyPanel().getPatientInsureInfoHeaviest(),
                    getMonthlyPanel().getMonthlySchedule().getMasterService());
                
                // データのクローンを作成する。
                VRList cloneServices = new VRArrayList();
                cloneServices.addAll(QkanValidServiceCommon.deepCopyVRList(plans));
                
                // 登録済みの計画単位数を設定
                summary.initialize(getCalcurater(), cloneServices);
                summary.setupPlanUnitsFromAdjusts(getMonthlyPanel().getPlanUnits());
            } else {
                // 「キャンセル」選択時
                // 予定で設定された調整額をクリアする
                it = plans.iterator();
                while (it.hasNext()) {
                    VRMap row = (VRMap) it.next();
                    row.put("REGULATION_RATE", 0);
                }
            }
        }
        // 2016/9/14 [Yoichiro Kamei] add - end
        
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
        // ■サービスパターンの情報を展開
        // サービス内容登録・選択領域(servuceDetails)に選択したパターンの情報をバインドする。
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

        // クラス名を構築する
        Class<QS001ServicePanel> serviceClass = null;
        String serviceKindDetailVal = ACCastUtilities
                .toString(getSelectedServiceKind());
        ACPanel servicePanel = null;
        StringBuilder sb = new StringBuilder();
        sb.append("jp.or.med.orca.qkan.affair.qs.qs001.");
        sb.append("QS001_");
        sb.append(serviceKindDetailVal);
        sb.append("_");
        sb.append(QkanCommon.getServiceLowVersion(serviceKindDetailVal,
                targetDate, getDBManager()));

        try {
            // クラス生成
            serviceClass = (Class<QS001ServicePanel>) Class.forName(sb
                    .toString());
            // クラス取得
            if (serviceClass != null) {
                servicePanel = (QS001ServicePanel) serviceClass.newInstance();
            }
            // 2016/8/23 [Yoichiro Kamei] add - begin 総合事業対応
            if (servicePanel != null) {
                if (servicePanel instanceof QS001ServicePanelSogo) {
                    ((QS001ServicePanelSogo) servicePanel).setSystemServiceKindDetail(serviceKindDetailVal);
                }
            }
            // 2016/8/23 [Yoichiro Kamei] add - end
        } catch (ClassNotFoundException e) { // by Class.forName
            // 指定した名称のクラス存在しなかった場合
            e.printStackTrace();

        } catch (InstantiationException e) { // by newInstance()
            // インスタンス作成不可の場合（パラメータなしのコンストラクタ存在しない場合 - new Xxxx()でエラーの場合）
            e.printStackTrace();

        } catch (IllegalAccessException e) { // by newInstance()
            // 権限はないとき
            e.printStackTrace();

        }

        return servicePanel;

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

            if (getSelectedServiceClass().isUseProvider()) {
                // 現在選択しているサービスクラス(selectedServiceClass)が事業所情報を必要とする(isUseProvider)場合

                if (!getServiceOfferEntrepreneur().isSelected()) {
                    // 事業所を選択してない場合
                    // 事業所未選択のエラーメッセージを表示する。※ID=QS001_EROOR_OF_UNSELECTED_PROVIDER
                    QkanMessageList.getInstance()
                            .QS001_EROOR_OF_UNSELECTED_PROVIDER();
                    // 入力に不備があったと見なし、nullを返す。
                    return null;
                }
            }

            VRMap data = getSelectedServiceClass().getValidData();
            if (data != null) {
                // 現在選択しているサービスクラス(selectedServiceClass)のエラーチェック(getValidData)にnull以外が返ってきた場合
                // 現在表示しているサービスクラスを含むサービス内容設定領域(serviceContentSettings)から情報を収集して返す。

                // VRBindPathParser.set("LOGIN_PROVIDER_ID", data,
                // QkanSystemInformation.getInstance().getLoginProviderID());
                VRBindPathParser.set("PATIENT_ID", data, new Integer(
                        getPatientID()));
                Object provider = getServiceOfferEntrepreneur()
                        .getSelectedModelItem();
                if (provider instanceof VRMap) {
                    VRBindPathParser.set("PROVIDER_ID", data, VRBindPathParser
                            .get("PROVIDER_ID", (VRMap) provider));
                } else {
                    VRBindPathParser.set("PROVIDER_ID", data, "");
                }
                VRBindPathParser.set("SYSTEM_SERVICE_KIND_DETAIL", data,
                        new Integer(getSelectedServiceKind()));
                // SERVICE_USE_TYPEなどの情報は必要に応じて呼び出し元で設定すること。

                // [ID:0000444][Tozo TANAKA] 2009/03/07 add begin 平成21年4月法改正対応
                if (getSelectedServiceClass() instanceof QS001ServicePanel) {
                    // サービスの法改正区分を設定します。
                    VRBindPathParser
                            .set(QkanConstants.SERVICE_SYSTEM_BIND_PATH_LOW_VERSION,
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
        if (getServiceListLockFlag()) {
            // 多重再帰防止
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
                if (getUsableProvider()) {
                    // 利用できない事業所が選択されている場合はスキップ
                    setState_SERVICE_SELECTED();
                }
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

                        // for debug
                        try {
                            debugService(service);
                        } catch (Exception ex) {
                        }
                        // for dbuug
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
            // サービス選択中のリスト(serviceSelectedListBox)に選択サービスの削除を指示する。
            Component oldSelectCmp = null;
            if (getSharedFocusCellRenderer() != null) {
                oldSelectCmp = getSharedFocusCellRenderer()
                        .getSharedFocusedOwner();
            }
            getSelectedServiceListBox().removeSelectedSchedule();
            // サービス未選択状態にする。
            if ((!getSelectedServiceListBox().isSelected())
                    || (getSelectedServiceListBox().getSelectedValue() == null)) {
                setState_SERVICE_UNSELECTED();
            } else {
                if (oldSelectCmp != null) {
                    getSharedFocusCellRenderer().setSharedFocusedOwner(
                            oldSelectCmp);
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
                Iterator<Object> it = getDeleteReseveServicePatterns()
                        .iterator();
                while (it.hasNext()) {
                    Map service = (Map) it.next();
                    Object obj = service.get("SERVICE_ID");
                    if (obj != null) {
                        String id = ACCastUtilities.toString(obj);

                        int end = pattenrs.size();
                        for (int i = 0; i < end; i++) {
                            if (id.equals(ACCastUtilities
                                    .toString(((Map) pattenrs.get(i))
                                            .get("SERVICE_ID")))) {
                                pattenrs.remove(i);
                                break;
                            }
                        }
                    }
                }
                // pattenrs.removeAll(getDeleteReseveServicePatterns());
                // 追加予定のサービスパターンを取得結果に追加する。
                it = getInsertReserveServicePatterns().iterator();
                while (it.hasNext()) {
                    Map service = (Map) it.next();
                    service.remove("SERVICE_ID");
                }
                pattenrs.addAll(getInsertReserveServicePatterns());
                // 念のためユニークキーの重複チェックを行う。
                Set<Object> keySet = new HashSet<Object>();
                it = pattenrs.iterator();
                while (it.hasNext()) {
                    Map row = (Map) it.next();
                    Object key = row.get("SERVICE_ID");
                    // 2008/01/24 [Masahiko_Higuchi] add - begin
                    // サービスパターン設定ボタン操作実行時エラー対応
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
        // 2008/03/18 [Masahiko_Higuchi] edit - begin
        // 平成20年4月法改正対応（介護療養型老人保健施設対応）
        ACPanel serviceClass = createServicePatternClass(getCalcurater()
                .getTargetDate());
        // 2008/03/18 [Masahiko_Higuchi] edit - end
        if (serviceClass instanceof QS001ServicePanel) {
            ((QS001ServicePanel) serviceClass).setDBManager(getDBManager());
            ((QS001ServicePanel) serviceClass)
                    .setOldFacilityUser(getOldFacilityUserFlag() == 2);
            ((QS001ServicePanel) serviceClass)
                    .setPlanMode(getProcessType() == QkanConstants.PROCESS_TYPE_PLAN);
            ((QS001ServicePanel) serviceClass).setCalculater(getCalcurater());
        }
        // サービス内容設定領域(serviceContentSettings)の子項目を破棄し、生成したサービスパターンクラスを子項目として追加する。
        getServiceContentSettings().removeAll();
        if (serviceClass != null) {
            setSelectedServiceClass((QS001Service) serviceClass);

            if (getBeginTimeFollowListener() != null) {
                getBeginTimeFollowListener().setB(
                        getSelectedServiceClass().getBeginTimeCombo());
                getEndTimeFollowListener().setB(
                        getSelectedServiceClass().getEndTimeCombo());
            }
            getSelectedServiceClass().initialize();
            getServiceContentSettings().add(serviceClass, VRLayout.CLIENT);
            // 2016/10/13 [Yoichiro Kamei] add - begin 総合事業対応
            if (serviceClass instanceof QS001ServicePanelSogo) {
                try {
                    // 総合事業の単位数単価が設定されていなければ、警告ダイアログを表示
                    String insurerId = ((QS001ServicePanelSogo) serviceClass).getInitialInsurerId();
                    QkanSjTankaManager.getUnitPrice(insurerId, String.valueOf(serviceKind));
                } catch (QkanSjTankaNotFoundException e) {
                    QkanMessageList.getInstance().QS001_SJ_TANKA_NOT_FOUND();
                }
            }
            // 2016/10/13 [Yoichiro Kamei] add - end
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

            if (CareServiceCommon.isWelfareEquipment(service)) {
                // 福祉用具貸与の場合
                // 期間は常に1日とし、期間コンボを操作不可とする。
                getWeeklyPanel().getExceptionEndCombo().setSelectedIndex(1);
                getWeeklyPanel().setState_WELFARE_EQUIPMENT_SELECTED();
            } else {
                // 福祉用具貸与以外の場合
                // 期間コンボを操作可能とする。
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
            // * 裏機能としてデバッグがオンなら初期選択
            if (ACStaticDebugger.getInstance().isVisible()) {
                if (!providerSelected) {
                    getServiceOfferEntrepreneur().setSelectedIndex(0);
                    providerSelected = true;
                }
            }

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

        if (getBeginTimeFollowListener() != null) {
            QS001FollowTimeComboDocumentListener.followValue(
                    getBeginTimeFollowListener().getB(),
                    getBeginTimeFollowListener().getA());
        }
        if (getEndTimeFollowListener() != null) {
            QS001FollowTimeComboDocumentListener.followValue(
                    getEndTimeFollowListener().getB(),
                    getEndTimeFollowListener().getA());
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
        // セルレンダラの表示も更新
        Component cmp = getSharedFocusCellRenderer().getSharedFocusedOwner();
        if (cmp != null) {
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

            // TODO ★
            int mode;
            if (getProcessType() == QkanConstants.PROCESS_TYPE_PLAN) {
                mode = QkanConstants.SERVICE_DETAIL_GET_PLAN_OF_WEEKLY_ONLY;
            } else {
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
            // ユニークキーを削除
            Iterator it = schedules.iterator();
            while (it.hasNext()) {
                Map map = (Map) it.next();
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
        for (int i = 0; i < bindPaths.length; i++) {
            obj = VRBindPathParser.get(bindPaths[i], service);
            // 比較処理
            if (ACCastUtilities.toInt(obj, 0) != 0) {
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
    protected void patternNameChangeActionPerformed(ActionEvent e)
            throws Exception {
        // VRMap以外は処理対象外にする。
        if (!(getPatternList().getSelectedValue() instanceof VRMap)) {
            return;
        }
        VRMap pattern = (VRMap) getPatternList().getSelectedValue();
        QS001007 qs001007 = new QS001007();
        // パターンダイアログの表示
        qs001007.showModel(pattern, getDBManager());
        // パターン名称が変更されている場合
        if (qs001007.isPatternNameChange()) {
            // 既存登録サービスパターンであるか
            if (pattern.containsKey("SERVICE_ID")) {
                // 既存のサービスパターンである場合はDelete - Insertで処理する。
                getDeleteReseveServicePatterns().add(pattern);
                // サービスIDの取得
                int serviceID = ACCastUtilities.toInt(
                        pattern.getData("SERVICE_ID"), -1);
                // 登録予定リスト内に既に同一のデータがないか走査する
                for (int i = getInsertReserveServicePatterns().size(); i > 0; i--) {
                    VRMap insertPattern = (VRMap) getInsertReserveServicePatterns()
                            .get(i - 1);
                    int insertPatternServiceID = ACCastUtilities.toInt(
                            insertPattern.getData("SERVICE_ID"), -2);
                    // 多重登録防止（同一のデータである場合は削ってから足す）
                    if (serviceID == insertPatternServiceID) {
                        getInsertReserveServicePatterns().remove(i - 1);
                    }
                }
                // 最後に追加
                getInsertReserveServicePatterns().add(pattern);
            }
        }
    }

    private void debugService(VRMap service) throws Exception {
        // デバッガが表示されていないときは、処理を行わない
        if (!ACStaticDebugger.getInstance().isVisible()) {
            return;
        }

        VRMap row = new VRHashMap(service);
        // サービス対象年月日を取得する。
        Date serviceDate = ACCastUtilities.toDate(row.getData("SERVICE_DATE"),
                null);
        if (serviceDate == null) {
            return;
        }
        // サービス対象年月日から該当する要介護認定履歴を取得する。
        VRMap history = getCalcurater().getPatientInsureInfoOnTargetDay(
                serviceDate);
        if ((history == null) || (history.isEmpty())) {
            return;
        }
        // 該当する要介護度を取得する。
        Object jotaiCode = history.getData("JOTAI_CODE");
        if (ACCastUtilities.toInt(jotaiCode, 1) == 1) {
            // 非該当の場合はサービスコードを返さない
            return;
        }
        row.setData(Qkan10011_ServiceUnitGetter.YOKAIGODO, jotaiCode);

        // 事業所番号から対応する事業所を取得する。
        Object provider = getCalcurater().getHashedProviders().get(
                row.getData("PROVIDER_ID"));
        if (provider instanceof VRMap) {
            // 該当する事業所の特別地域有無を取得する。
            row.setData(Qkan10011_ServiceUnitGetter.TOKUCHI_KASAN,
                    ((VRMap) provider).getData("SPECIAL_AREA_FLAG"));
            String providerID = ACCastUtilities.toString(
                    ((VRMap) provider).getData("PROVIDER_ID"), "");
            VRList serviceInfo = QkanCommon.getProviderServiceDetail(
                    getDBManager(),
                    providerID,
                    ACCastUtilities.toInt(
                            service.getData("SYSTEM_SERVICE_KIND_DETAIL"), 0));
            // 初期は中山間ではない
            row.setData(Qkan10011_ServiceUnitGetter.CHUSANKANCHIIKI_KASAN, "1");
            if (serviceInfo != null) {
                if (serviceInfo.getData(0) instanceof VRMap) {
                    VRMap providerServiceInfo = (VRMap) serviceInfo.getData(0);
                    if (CareServiceCommon
                            .isMountainousArea(providerServiceInfo)) {
                        // 中山間地域の小規模事業所である。
                        row.setData(
                                Qkan10011_ServiceUnitGetter.CHUSANKANCHIIKI_KASAN,
                                "2");
                    }
                }
            }
        }

        // 特定入居者
        row.setData(QkanConstants.SERVICE_SYSTEM_KIND_DETAIL_SPECIAL_FACILITIY,
                new Integer(getInSpecialFacilityFlag()));

        // 旧措置入所者
        if (!VRBindPathParser.has(
                QkanConstants.SERVICE_SYSTEM_KIND_DETAIL_OLD_FACILITIY_USER,
                row)) {
            // サービスの情報として設定されていない場合は利用者の情報を使用する。
            row.setData(
                    QkanConstants.SERVICE_SYSTEM_KIND_DETAIL_OLD_FACILITIY_USER,
                    new Integer(getOldFacilityUserFlag()));
        }

        // 算定項目と取得した情報からサービスコードデータを取得して返す。
        String kind = ACCastUtilities.toString(row
                .getData("SYSTEM_SERVICE_KIND_DETAIL"));
        java.util.List serviceCodes = Qkan10011_ServiceCodeManager
                .getInstance().getServiceCode(kind, (HashMap) row, serviceDate,
                        getDBManager());
        VRList list = new VRArrayList();

        for (int i = 0; i < serviceCodes.size(); i++) {
            Map tmp = (Map) serviceCodes.get(i);
            VRMap map = new VRHashMap();
            map.put("SERVICE_CODE",
                    String.valueOf(tmp.get("SERVICE_CODE_KIND"))
                            + String.valueOf(tmp.get("SERVICE_CODE_ITEM")));
            map.put("SERVICE_NAME", tmp.get("SERVICE_NAME"));
            map.put("SERVICE_UNIT", tmp.get("SERVICE_UNIT"));
            list.add(map);
        }

        String[] fields = new String[] { "SERVICE_CODE", "SERVICE_UNIT",
                "SERVICE_NAME" };
        ACStaticDebugger.getInstance().setResultTable("", fields, list);

    }

}
