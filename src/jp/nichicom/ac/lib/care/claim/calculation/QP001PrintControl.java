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
 * プログラム 印刷部品制御モジュール (QP001CSVCreator)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRLinkedHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.logging.VRLogger;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanMessageList;

public class QP001PrintControl {

    /**
     * DB接続マネージャ
     */
    private ACDBManager dbm = null;
    /**
     * PDF生成ライブラリ
     */
    private ACChotarouXMLWriter writer = null;
    /**
     * 業務起動モード
     */
    private String affair = null;
    /**
     * 出力対象利用者一覧
     */
    private VRList patientList = null;
    /**
     * 事業所一覧
     */
    private VRMap providerMap = null;
    /**
     * 印刷オプション
     */
    private String yoshikiBango = "0";

    /**
     * 特定入所者の利用者負担額が0円の場合に明細書に印字するオプション
     */
    private String printNursingZero = "0";

    /**
     * 特定入所者の負担限度額が0円の場合に明細書に印字するオプション
     */
    private String printNursingLimitZero = "0";

    /**
     * 請求書印刷日付
     */
    private Date printDate = null;

    private QP001Manager manager = null;

    // 利用者負担未発生者スキップ用フラグ
    private int patientClaimPdfCount = 0;
    private int patientClaimPdfEmptyCount = 0;
    
    // 利用者向け請求書情報（自己負担が０円）をスキップするか
    private boolean skipEmptyPatientClaim = true;
    // 利用者負担の発生しない利用者管理用
    private ArrayList noPatientSelfList = new VRArrayList();
    

    //月途中で認定情報が変化する場合の給付管理票で、小計と合計金額のチェック
    private QP001ErrorControl errorControl = null;

    /**
     * デフォルトコンストラクタ
     * 
     */
    public QP001PrintControl() {
    }

    /**
     * 使用するDBマネージャを設定する。
     * 
     * @param dbm
     * @throws Exception
     */
    public void setDBManager(ACDBManager dbm) throws Exception {
        this.dbm = dbm;
    }

    /**
     * 使用するPDF生成ライブラリを設定する。
     * 
     * @param writer
     * @throws Exception
     */
    public void setWriter(ACChotarouXMLWriter writer) throws Exception {
        this.writer = writer;
    }

    /**
     * 業務の起動モードを設定する。
     * 
     * @param affair
     * @throws Exception
     */
    public void setAffair(String affair) throws Exception {
        this.affair = affair;
    }

    /**
     * 処理に使用する利用者の一覧を登録する。
     * 
     * @param patientList
     * @throws Exception
     */
    public void setPatientList(VRList patientList) throws Exception {
        this.patientList = patientList;
    }

    /**
     * 事業所の一覧を設定する。
     * 
     * @param providerMap
     * @throws Exception
     */
    public void setProviderMap(VRMap providerMap) throws Exception {
        this.providerMap = providerMap;
    }

    /**
     * 印刷オプション（様式番号の印字）を表示する。
     * 
     * @param yoshikiBango
     * @throws Exception
     */
    public void setPrintOption(String yoshikiBango) throws Exception {
        this.yoshikiBango = yoshikiBango;
    }

    /**
     * 特定入所者の利用者負担額が0円の場合に明細書に印字するオプションを設定する
     * 
     * @param printNursingZero
     * @throws Exception
     */
    public void setPrintNursingZero(String printNursingZero) throws Exception {
        this.printNursingZero = printNursingZero;
    }

    /**
     * 特定入所者の負担限度額が0円の場合に明細書に印字するオプションを設定する
     * 
     * @param printNursingLimitZero
     * @throws Exception
     */
    public void setPrintNursingLimitZero(String printNursingLimitZero)
            throws Exception {
        this.printNursingLimitZero = printNursingLimitZero;
    }

    /**
     * 請求書の印刷日を設定します。
     * 
     * @param printDate
     * @throws Exception
     */
    public void setPrintDate(Date printDate) throws Exception {
        this.printDate = printDate;
    }

    public void setManager(QP001Manager manager) throws Exception {
        this.manager = manager;
    }

    private boolean isInit() throws Exception {

        if (dbm == null) {
            VRLogger.warning("DB接続マネージャが登録されていません。");
            return false;
        }
        if (writer == null) {
            VRLogger.warning("PDF生成ライブラリが登録されていません。");
            return false;
        }
        if (affair == null) {
            VRLogger.warning("業務起動モードが登録されていません。");
            return false;
        }
        if (patientList == null) {
            VRLogger.warning("出力対象利用者一覧が登録されていません。");
            return false;
        }
        if (providerMap == null) {
            VRLogger.warning("事業所一覧が登録されていません。");
            return false;
        }

        if (manager == null) {
            VRLogger.warning("マスタデータオブジェクトが登録されていません。");
            return false;
        }

        return true;
    }

    /**
     * 帳票印刷を実行する。
     * 
     * @param param
     *            印刷パラメタ
     * @return
     * @throws Exception
     */
    public boolean doPrint(VRMap param) throws Exception {

        if (!isInit()) {
            throw new Exception("初期設定が行われていません。");
        }
        
        boolean printResult = false;
        
        // 印刷クラスへ引き渡す情報の共通部分を定義
        VRHashMap printParam = new VRHashMap();
        
        // 事業所情報
        printParam.put("PROVIDERS", providerMap);
        // 様式番号印刷オプション
        printParam.put("YOSHIKI_BANGO", yoshikiBango);
        // 特定入所者の利用者負担額が0円の場合に明細書に印字するオプション
        printParam.put("PRINT_NURSING_ZERO", printNursingZero);
        // 特定入所者の負担限度額が0円の場合に明細書に印字するオプション
        printParam.put("PRINT_NURSING_LIMIT_ZERO", printNursingLimitZero);
        // データキャッシュ
        printParam.put("MANAGER", manager);
        
        // 「02」の場合 ※利用者一覧（給付管理票　様式第十一）
        if ("02".equals(affair)) {
            printResult = doPrintMode02(printParam);
            
        // 「03」の場合 ※利用者一覧（在宅サービス支援事業所請求　様式第七）
        } else if ("03".equals(affair)) {
            printResult = doPrintMode03(printParam);

        // 「04」の場合 ※利用者一覧（在宅サービス提供事業所請求　様式第二～六、八～十）
        } else if ("04".equals(affair)) {

            // サービスの名称を付加
            printParam.put("SERVICE_NAME", manager.getServices());
            
            printResult = doPrintMode04(printParam);

        // 「05」は欠番
        // 「06」は医療だったが廃止

        // 「07」の場合 ※利用者一覧(利用者向け印刷)
        } else if ("07".equals(affair)) {
            printResult = doPrintMode07(printParam, param);

        // 「08」の場合 ※利用者一覧(介護給付費明細書印刷　様式第一)
        } else if ("08".equals(affair)) {
            printResult = doPrintMode08(printParam);
            
        }
        
        printParam.clearData();
        printParam = null;
        
        return printResult;
    }
    
    
    // モードが「02」の場合の印刷処理 ※利用者一覧（給付管理票　様式第十一）
    private boolean doPrintMode02(VRHashMap printParam) throws Exception {
        
        errorControl = new QP001ErrorControl();
        
        // patientDataの件数分ループする。
        for (int i = 0; i < patientList.size(); i++) {
            VRMap map = (VRMap) patientList.getData(i);

            // 未選択の場合処理をスキップする。
            if (!isCheckedRow(map)) {
                continue;
            }
            
            // 請求年月
            Date claimDate = ACCastUtilities.toDate(map.get("CLAIM_DATE"));
            // 利用者ID退避用にint patient_id を生成し、patientDataの KEY : PATIENT_ID を設定する。
            int patient_id = ACCastUtilities.toInt(VRBindPathParser.get("PATIENT_ID", map));
            // 様式番号を取得する。
            int claimStyleType = ACCastUtilities.toInt(VRBindPathParser.get("CLAIM_STYLE_TYPE", map), 0);

            // 請求詳細情報を取得し、VRArrayList claimList に格納する。
            StringBuilder sb = getClaimDetailWhere(map, patient_id, claimDate);
            sb.append(" AND(CLAIM.CLAIM_STYLE_TYPE = " + claimStyleType + ")");

            VRList claimList = QkanCommon.getClaimDetailCustom(dbm, claimDate, sb.toString());

            if ((claimList == null) || (claimList.size() == 0)) {
                VRLogger.warning("集計データ取得エラー:" + sb.toString());
                continue;
            }

            // 請求対象日
            printParam.put("SEIKYU_DATE", claimDate);
            // 帳票データ
            printParam.put("STYLE_DATA", claimList);
            // 利用者情報
            VRMap patient = (VRLinkedHashMap) QkanCommon.getPatientInfo(dbm, patient_id).get(0);
            printParam.put("PATIENT", patient);
            // 様式番号
            printParam.put("CLAIM_STYLE_TYPE", String.valueOf(claimStyleType));

            // 給付管理票の印刷を行う
            if (QkanConstants.CLAIM_STYLE_BENEFIT_MANAGEMENT == claimStyleType) {
                // 平成21年4月法改正対応 ここで妥当性を判断
                if (!errorControl.isValidBenefitManagement(claimList, patient)) {
                    continue;
                }

                new QP001P11_201204().doPrint(writer, printParam);
            }
            
        }
        
        errorControl.showBenefitManagementError();
        if (errorControl.isAllError()) {
            return false;
        }
        
        return true;
    }
    
    
    
    
    // モードが「03」の場合 ※利用者一覧（在宅サービス支援事業所請求　様式第七）
    @SuppressWarnings("unchecked")
    private boolean doPrintMode03(VRHashMap printParam) throws Exception {
        
        // 様式第七印刷オブジェクト
        Map<String, VRList> style7 = new TreeMap<String, VRList>();
        
        for (int i = 0; i < patientList.size(); i++) {
            VRMap map = (VRMap) patientList.getData(i);

            // 未選択の場合処理をスキップする。
            if (!isCheckedRow(map)) {
                continue;
            }

            // 請求年月
            Date claimDate = ACCastUtilities.toDate(map.get("CLAIM_DATE"));
            // 利用者ID退避用にint patient_id を生成し、patientDataの KEY : PATIENT_ID を設定する。
            int patient_id = ACCastUtilities.toInt(VRBindPathParser.get("PATIENT_ID", map));
            // 様式番号を取得する。
            int claimStyleType = ACCastUtilities.toInt(VRBindPathParser.get("CLAIM_STYLE_TYPE", map), 0);

            // 請求詳細情報を取得し、VRArrayList claimList に格納する。
            StringBuilder sb = getClaimDetailWhere(map, patient_id, claimDate);
            sb.append(" AND(CLAIM.CLAIM_STYLE_TYPE = " + claimStyleType + ")");

            VRList claimList = QkanCommon.getClaimDetailCustom(dbm, claimDate, sb.toString());

            if ((claimList == null) || (claimList.size() == 0)) {
                VRLogger.warning("集計データ取得エラー:" + sb.toString());
                continue;
            }

            // 利用者情報
            VRMap patient = (VRLinkedHashMap) QkanCommon.getPatientInfo(dbm, patient_id).get(0);

            // 在宅介護支援介護給付費明細書-様式第七(QP00108)の印刷を行う。
            // 様式第七は最後にまとめて出力する必用がある。
            VRMap style7Map = (VRMap) claimList.get(0);

            // 事業所番号 + 対象年月 + 保険者番号 + 公費負担者番号+対象年月をキーにする
            String key = String.valueOf(style7Map.get("1001002")) + "-"
                    + String.valueOf(style7Map.get("1001004")) + "-"
                    + String.valueOf(style7Map.get("1001005")) + "-";

            if (!ACTextUtilities.isNullText(style7Map.get("1001008"))) {
                key += String.valueOf(style7Map.get("1001008"));
            }

            // 予防対応開始
            key += String.valueOf(claimStyleType);
            // 予防対応終了

            // 様式第七が複数レコードを保持するようになったので、
            // ロジックを大幅に変更
            VRMap style7DataMap = new VRHashMap();

            style7DataMap.put("PATIENT_FAMILY_KANA", patient.get("PATIENT_FAMILY_KANA"));
            style7DataMap.put("PATIENT_FIRST_KANA", patient.get("PATIENT_FIRST_KANA"));
            style7DataMap.put("PATIENT_FAMILY_NAME", patient.get("PATIENT_FAMILY_NAME"));
            style7DataMap.put("PATIENT_FIRST_NAME",patient.get("PATIENT_FIRST_NAME"));
            style7DataMap.put("CLAIM_DATA", claimList);

            VRList style7List = null;
            if (style7.containsKey(key)) {
                style7List = style7.get(key);
            } else {
                style7List = new VRArrayList();
                style7.put(key, style7List);
            }
            style7List.add(style7DataMap);
        }
        
        
        Iterator<String> it = style7.keySet().iterator();
        while (it.hasNext()) {
            
            // 予防対応
            String key =it.next();
            // 帳票データ
            printParam.put("STYLE_DATA", style7.get(key));

            // 様式第七
            if (key.endsWith(String
                    .valueOf(QkanConstants.CLAIM_STYLE_FORMAT_7))) {
                new QP001P071_201204().doPrint(writer, printParam);
                // 様式第七の二
            } else if (key.endsWith(String
                    .valueOf(QkanConstants.CLAIM_STYLE_FORMAT_7_2))) {
                new QP001P072_201204().doPrint(writer, printParam);
            }
        }
        
        return true;
    }
    
    
    
    
    // 処理モードが「04」の場合 ※利用者一覧（在宅サービス提供事業所請求　様式第二～六、八～十）
    private boolean doPrintMode04(VRHashMap printParam) throws Exception {
        // patientDataの件数分ループする。
        for (int i = 0; i < patientList.size(); i++) {
            VRMap map = (VRMap) patientList.getData(i);

            // 未選択の場合処理をスキップする。
            if (!isCheckedRow(map)) {
                continue;
            }

            // 請求年月
            Date claimDate = ACCastUtilities.toDate(map.get("CLAIM_DATE"));
            // 利用者ID退避用にint patient_id を生成し、patientDataの KEY : PATIENT_ID を設定する。
            int patient_id = ACCastUtilities.toInt(VRBindPathParser.get("PATIENT_ID", map));
            // 様式番号を取得する。
            int claimStyleType = ACCastUtilities.toInt(VRBindPathParser.get("CLAIM_STYLE_TYPE", map), 0);

            // 請求詳細情報を取得し、VRArrayList claimList に格納する。
            StringBuilder sb = getClaimDetailWhere(map, patient_id, claimDate);
            sb.append(" AND(CLAIM.CLAIM_STYLE_TYPE = " + claimStyleType + ")");

            VRList claimList = QkanCommon.getClaimDetailCustom(dbm, claimDate, sb.toString());

            if ((claimList == null) || (claimList.size() == 0)) {
                VRLogger.warning("集計データ取得エラー:" + sb.toString());
                continue;
            }

            // 請求対象日
            printParam.put("SEIKYU_DATE", claimDate);
            // 帳票データ
            printParam.put("STYLE_DATA", claimList);
            // 利用者情報
            VRMap patient = (VRLinkedHashMap) QkanCommon.getPatientInfo(dbm, patient_id).get(0);
            printParam.put("PATIENT", patient);
            // 様式番号
            printParam.put("CLAIM_STYLE_TYPE", String.valueOf(claimStyleType));

            switch (claimStyleType) {
            // 在宅サービス介護給付費明細書（居宅）(QP001P021)の印刷を行う。
            case QkanConstants.CLAIM_STYLE_FORMAT_2:
                new QP001P021_201204().doPrint(writer, printParam);
                break;

            // 在宅サービス介護給付費明細書（居宅）(QP001P022)の印刷を行う。
            case QkanConstants.CLAIM_STYLE_FORMAT_2_2:
                new QP001P022_201204().doPrint(writer, printParam);
                break;

            // 介護予防・日常生活支援総合事業費明細書（訪問型・通所型・その他の生活支援）(QP001P023)の印刷を行う。
            case QkanConstants.CLAIM_STYLE_FORMAT_2_3:
                new QP001P023_201504().doPrint(writer, printParam);
                break;

            // 在宅サービス介護給付費明細書（短期入所生活介護）(QP001P031)の印刷を行う。
            case QkanConstants.CLAIM_STYLE_FORMAT_3:
                new QP001P031_201204().doPrint(writer, printParam);
                break;

            // 在宅サービス介護給付費明細書（短期入所生活介護）(QP001P032)の印刷を行う。
            case QkanConstants.CLAIM_STYLE_FORMAT_3_2:
                new QP001P032_201204().doPrint(writer, printParam);
                break;

            // 在宅サービス介護給付費明細書（介護老人保健施設）(QP001P041)の印刷を行う。
            case QkanConstants.CLAIM_STYLE_FORMAT_4:
                new QP001P041_201204().doPrint(writer, printParam);
                break;

            // 在宅サービス介護給付費明細書（介護老人保健施設）(QP001P042)の印刷を行う。
            case QkanConstants.CLAIM_STYLE_FORMAT_4_2:
                new QP001P042_201204().doPrint(writer, printParam);
                break;

            // 在宅サービス介護給付費明細書（病院又は診療所）(QP001P051)の印刷を行う。
            case QkanConstants.CLAIM_STYLE_FORMAT_5:
                new QP001P051_201204().doPrint(writer, printParam);
                break;

            // 在宅サービス介護給付費明細書（病院又は診療所）(QP001P052)の印刷を行う。
            case QkanConstants.CLAIM_STYLE_FORMAT_5_2:
                new QP001P052_201204().doPrint(writer, printParam);
                break;

            // 在宅サービス介護給付費明細書（認知症対応型・特定施設入所者）(QP001P061)の印刷を行う。
            case QkanConstants.CLAIM_STYLE_FORMAT_6:
                new QP001P061_201204().doPrint(writer, printParam);
                break;

            // 在宅サービス介護給付費明細書（認知症対応型・特定施設入所者）(QP001P062)の印刷を行う。
            case QkanConstants.CLAIM_STYLE_FORMAT_6_2:
                new QP001P062_201204().doPrint(writer, printParam);
                break;

            // 在宅サービス介護給付費明細書（認知症対応型・特定施設入所者）(QP001P063)の印刷を行う。
            case QkanConstants.CLAIM_STYLE_FORMAT_6_3:
                new QP001P063_201204().doPrint(writer, printParam);
                break;

            // 在宅サービス介護給付費明細書（認知症対応型・特定施設入所者）(QP001P064)の印刷を行う。
            case QkanConstants.CLAIM_STYLE_FORMAT_6_4:
                new QP001P064_201204().doPrint(writer, printParam);
                break;

            // 在宅サービス介護給付費明細書（認知症対応型・特定施設入所者）(QP001P065)の印刷を行う。
            case QkanConstants.CLAIM_STYLE_FORMAT_6_5:
                new QP001P065_201204().doPrint(writer, printParam);
                break;

            // 在宅サービス介護給付費明細書（認知症対応型・特定施設入所者）(QP001P066)の印刷を行う。
            case QkanConstants.CLAIM_STYLE_FORMAT_6_6:
                new QP001P066_201204().doPrint(writer, printParam);
                break;
                
            // 在宅サービス介護給付費明細書（認知症対応型・特定施設入所者）(QP001P067)の印刷を行う。
            case QkanConstants.CLAIM_STYLE_FORMAT_6_7:
                new QP001P067_201204().doPrint(writer, printParam);
                break;

            // 施設サービス等介護給付費明細書（介護福祉施設）(QP001P08)の印刷を行う。
            case QkanConstants.CLAIM_STYLE_FORMAT_8:
                new QP001P08_201204().doPrint(writer, printParam);
                break;

            // 在宅サービス介護給付費明細書（介護老人保健施設）(QP001P09)の印刷を行う。
            case QkanConstants.CLAIM_STYLE_FORMAT_9:
                new QP001P09_201204().doPrint(writer, printParam);
                break;

            // 施設サービス等介護給付費明細書（介護療養施設）(QP001P10)の印刷を行う。
            case QkanConstants.CLAIM_STYLE_FORMAT_10:
                new QP001P10_201204().doPrint(writer, printParam);
                break;

            }
        }
        
        return true;
        
    }
    
    
    
    
    // 処理モードが「07」の場合 ※利用者一覧(利用者向け印刷)
    private boolean doPrintMode07(VRHashMap printParam, VRMap param) throws Exception {
        
        // 利用者負担未発生者スキップ機能変数の初期化
        patientClaimPdfCount = 0;
        patientClaimPdfEmptyCount = 0;
        noPatientSelfList = new VRArrayList();
        
        // patientDataの件数分ループする。
        for (int i = 0; i < patientList.size(); i++) {
            VRMap map = (VRMap) patientList.getData(i);

            // 未選択の場合処理をスキップする。
            if (!isCheckedRow(map)) {
                continue;
            }

            // 請求年月
            Date claimDate = ACCastUtilities.toDate(map.get("CLAIM_DATE"));
            // 利用者ID退避用にint patient_id を生成し、patientDataの KEY : PATIENT_ID を設定する。
            int patient_id = ACCastUtilities.toInt(VRBindPathParser.get("PATIENT_ID", map));
            // 様式番号を取得する。
            int claimStyleType = ACCastUtilities.toInt(VRBindPathParser.get("CLAIM_STYLE_TYPE", map), 0);

            // 請求詳細情報を取得し、VRArrayList claimList に格納する。
            StringBuilder sb = getClaimDetailWhere(map, patient_id, claimDate);

            VRList claimList = QkanCommon.getClaimDetailCustom(dbm, claimDate, sb.toString());

            if ((claimList == null) || (claimList.size() == 0)) {
                VRLogger.warning("集計データ取得エラー:" + sb.toString());
                continue;
            }

            // [2015年1月改正][Shinobu Hitaka] 2015/02/04 add start 公費54追加に伴う様式修正に対応
            // １行目の対象年月でマスタ取得しているので異なる対象年月になったら再取得する
            Date targetDate = ACCastUtilities.toDate(map.get("TARGET_DATE"));
            if (ACDateUtilities.compareOnDay(manager.getTargetDate(), targetDate) != 0){
                manager = new QP001Manager(dbm, targetDate);
            }
            // [2015年1月改正][Shinobu Hitaka] 2015/02/04 add end   公費54追加に伴う様式修正に対応
            
            // 請求対象日
            printParam.put("SEIKYU_DATE", claimDate);
            // 帳票データ
            printParam.put("STYLE_DATA", claimList);
            // 利用者情報
            VRMap patient = (VRLinkedHashMap) QkanCommon.getPatientInfo(dbm, patient_id).get(0);
            printParam.put("PATIENT", patient);
            // 様式番号
            printParam.put("CLAIM_STYLE_TYPE", String.valueOf(claimStyleType));

            doPrintAffair07Selecter(patient, claimList, param, claimDate,
                    ACCastUtilities.toDate(map.get("TARGET_DATE")));
        }
        
        
        // 再印刷処理を行うかを判定
        boolean isAllPrintRetry = false;
        // 利用者負担額の存在しない帳票のみ印刷しようとした場合は確認
        if (patientClaimPdfEmptyCount >= patientClaimPdfCount) {
            int msgID = QkanMessageList.getInstance().QU001_WARNING_OF_EMPTY_DATA_REPORT_ONLY();
            // 「はい」が選択された場合
            if (msgID == ACMessageBox.RESULT_YES) {
                // 全帳票印刷
                isAllPrintRetry = true;
            } else {
                // 「いいえ」が選択された場合
                return false;
            }

        }
        // 利用者負担額の存在しない帳票が含まれている場合
        // 全てが利用者負担額なしの帳票ではない かつ 1枚以上利用者負担額なしの帳票が存在する場合
        if (patientClaimPdfEmptyCount < patientClaimPdfCount
                && patientClaimPdfEmptyCount >= 1) {
            int msgID = QkanMessageList.getInstance().QP001_WARNING_OF_CUSTOM_PRINT();
            // メッセージ選択による分岐
            if (msgID == ACMessageBox.RESULT_YES) {
                // 全帳票印刷
                isAllPrintRetry = true;
            } else if (msgID == ACMessageBox.RESULT_NO) {
                // そのまま印刷
                // 利用者負担未発生のものは印刷済みとしない
                for (int i = 0; i < noPatientSelfList.size(); i++) {
                    // 利用者負担未発生の利用者を特定
                    Integer noPatientSelfId = ACCastUtilities.toInteger(
                            noPatientSelfList.get(i), new Integer(-1));
                    // リスト数ループ処理
                    for (int j = 0; j < patientList.size(); j++) {
                        VRMap map = (VRMap) patientList.getData(j);
                        if (noPatientSelfId.equals(ACCastUtilities
                                .toInteger(map.getData("PATIENT_ID"),
                                        new Integer(0)))) {
                            // 印刷対象外なので印刷していない事として扱う
                            map.setData("CHOISE", new Boolean(false));
                            break;
                        }
                    }
                }
            } else {
                // キャンセルボタン押下時は印刷しない
                return false;
            }
        }

        // 再印刷処理を行う場合
        if (isAllPrintRetry) {
            // 全てを印刷するため再生成
            ACChotarouXMLWriter newWriter = new ACChotarouXMLWriter();
            // writerを再設定
            setWriter(newWriter);
            // 印刷内容の編集開始を宣言
            newWriter.beginPrintEdit();
            // setWriter(null);
            // スキップ禁止
            setSkipEmptyPatientClaim(false);
            // 利用者向け請求書データの再生成
            buildPatientClaim(patientList, param);
            // 初期化
            setSkipEmptyPatientClaim(true);
        }
        
        return true;

    }
    
    
    
    // 「08」の場合 ※利用者一覧(介護給付費明細書印刷)
    private boolean doPrintMode08(VRHashMap printParam) throws Exception {
        
        // 介護給付費請求書印刷用
        Map<String, QP001Style1> style1Sorter = new TreeMap<String, QP001Style1>();
        
// 2016/7/11 [Yoichiro Kamei] add - begin 総合事業対応
        // 介護給付費請求書（様式１－２）印刷用
        Map<String, QP001Style1> style1_2Sorter = new TreeMap<String, QP001Style1>();
// 2016/7/11 [Yoichiro Kamei] add - end
        
        // patientDataの件数分ループする。
        for (int i = 0; i < patientList.size(); i++) {
            VRMap map = (VRMap) patientList.getData(i);

            // 未選択の場合処理をスキップする。
            if (!isCheckedRow(map)) {
                continue;
            }

            // 請求年月
            Date claimDate = ACCastUtilities.toDate(map.get("CLAIM_DATE"));
            // 利用者ID退避用にint patient_id を生成し、patientDataの KEY : PATIENT_ID を設定する。
            int patient_id = ACCastUtilities.toInt(VRBindPathParser.get("PATIENT_ID", map));

            // 請求詳細情報を取得し、VRArrayList claimList に格納する。
            StringBuilder sb = getClaimDetailWhere(map, patient_id, claimDate);

            VRList claimList = QkanCommon.getClaimDetailCustom(dbm, claimDate, sb.toString());

            if ((claimList == null) || (claimList.size() == 0)) {
                VRLogger.warning("集計データ取得エラー:" + sb.toString());
                continue;
            }
            
            // [2015年1月改正][Shinobu Hitaka] 2014/12/11 add start 公費54追加に伴う様式修正に対応
            // １行目の対象年月でマスタ取得しているので異なる対象年月になったら再取得する
            Date targetDate = ACCastUtilities.toDate(map.get("TARGET_DATE"));
            if (ACDateUtilities.compareOnDay(manager.getTargetDate(), targetDate) != 0){
                manager = new QP001Manager(dbm, targetDate);
            }
            // [2015年1月改正][Shinobu Hitaka] 2014/12/11 add end   公費54追加に伴う様式修正に対応
            
            
            
            
            // 介護給付費請求書(QP00102)のデータを設定する。
            String style1Target = QP001Style1.getSerialId(claimList);
            
// 2016/7/11 [Yoichiro Kamei] add - begin 総合事業対応
            //総合事業対象用の請求に分ける
            VRList claimListTmp = new VRArrayList();
            VRList claimListSogo = new VRArrayList();
            for (int k = 0; k < claimList.size(); k++) {
            	VRMap row = (VRMap)claimList.get(k);
            	int claimStypeType = ACCastUtilities.toInt(row.get("CLAIM_STYLE_TYPE"), 0);
            	if (QkanConstants.CLAIM_STYLE_BILL_FOR_PATIENT == claimStypeType ||
            		QkanConstants.CLAIM_STYLE_BENEFIT_MANAGEMENT == claimStypeType) {
            		// 利用者向け請求・給付管理票のデータは不要なのでスキップ
            		continue;
            	}
            	if (QkanConstants.CLAIM_STYLE_FORMAT_2_3 == claimStypeType) {
            		claimListSogo.add(row);
            	} else {
            		claimListTmp.add(row);
            	}
            }
            claimList = claimListTmp; //総合事業を除いた分
            
// 2016/7/11 [Yoichiro Kamei] add - end
// 2016/7/11 [Yoichiro Kamei] mod - begin 総合事業対応
//            // 既に設定している場合
//            if (style1Sorter.containsKey(style1Target)) {
//                ((QP001Style1) style1Sorter.get(style1Target))
//                        .parse(claimList);
//            } else {
//                QP001Style1 style1 = new QP001Style1(manager);
//                style1.parse(claimList);
//                style1Sorter.put(style1Target, style1);
//            }
            if (claimList.size() > 0) {
                // 既に設定している場合
                if (style1Sorter.containsKey(style1Target)) {
                    ((QP001Style1) style1Sorter.get(style1Target))
                            .parse(claimList);
                } else {
                    QP001Style1 style1 = new QP001Style1(QkanConstants.CLAIM_STYLE_BENEFIT_BILL, manager);
                    style1.parse(claimList);
                    style1Sorter.put(style1Target, style1);
                }
            }
            
            // 様式１－２の分
            if (claimListSogo.size() > 0) {
                if (style1_2Sorter.containsKey(style1Target)) {
                    ((QP001Style1) style1_2Sorter.get(style1Target))
                            .parse(claimListSogo);
                } else {
                    QP001Style1 style1 = new QP001Style1(QkanConstants.CLAIM_STYLE_BENEFIT_BILL_2, manager);
                    style1.parse(claimListSogo);
                    style1_2Sorter.put(style1Target, style1);
                }
            }
// 2016/7/11 [Yoichiro Kamei] mod - end
        }
        
        
        
        Iterator<String> it = style1Sorter.keySet().iterator();
        while (it.hasNext()) {
            // 帳票データ
            printParam.put("STYLE_DATA", style1Sorter.get(it.next()).getRecords());
            printParam.put("SEIKYU_DATE", printDate);
            
            new QP001P01_201204().doPrint(writer, printParam);
        }
        
// 2016/7/11 [Yoichiro Kamei] add - begin 総合事業対応
        it = style1_2Sorter.keySet().iterator();
        while (it.hasNext()) {
            // 帳票データ
            printParam.put("STYLE_DATA", style1_2Sorter.get(it.next()).getRecords());
            printParam.put("SEIKYU_DATE", printDate);
            
            new QP001P012_201504().doPrint(writer, printParam);
        }
// 2016/7/11 [Yoichiro Kamei] add - end
        
        return true;
    }
    
    
    
    // 提供内容を取得するSQL文のWhere句作成
    private StringBuilder getClaimDetailWhere(VRMap row, int patient_id, Date claimDate) throws Exception {
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(" AND(CLAIM.CLAIM_DATE = '" + VRDateParser.format(claimDate, "yyyy/MM/dd") + "')");
        sb.append(" AND(CLAIM.TARGET_DATE = '" + VRDateParser.format(ACCastUtilities.toDate(row.get("TARGET_DATE")), "yyyy/MM/dd") + "')");
        // 利用者IDを指定しているならば特定の利用者のみ。未指定ならば全利用者を対象とする。
        sb.append(" AND(CLAIM.PATIENT_ID = " + patient_id + ")");

        // 保険者番号、被保険者番号の検索条件を追加する。
        sb.append(" AND(CLAIM.INSURER_ID = '" + VRBindPathParser.get("INSURER_ID", row) + "')");

        if (VRBindPathParser.get("INSURED_ID", row) != null) {
            sb.append(" AND(CLAIM.INSURED_ID = '" + VRBindPathParser.get("INSURED_ID", row) + "')");
        } else {
            sb.append(" AND(CLAIM.INSURED_ID = '')");
        }

        sb.append(" AND(CLAIM.PROVIDER_ID = '" + QkanSystemInformation.getInstance().getLoginProviderID() + "')");
        
        return sb;
    }
    
    
    
    // 対象行にチェックがついているか判定する
    private boolean isCheckedRow(VRMap row) throws Exception {
        return "TRUE".equalsIgnoreCase(ACCastUtilities.toString(VRBindPathParser.get("CHOISE", row)));
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    // [ID:0000612][Shin Fujihara] 2010/11 add begin 2010年度対応
    private void doPrintAffair07Selecter(VRMap patient, VRList claimList,
            VRMap printSetting, Date claimDate, Date targetDate)
            throws Exception {

        doPrintAffair07(patient, claimList, printSetting, claimDate, targetDate);
        /*
         * FIXME [0000612] if (printSetting.get("PROVIDER_NAMES") == null) {
         * doPrintAffair07(patient, claimList, printSetting, claimDate,
         * targetDate); } else { doPrintAffair07Service(patient, claimList,
         * printSetting, claimDate, targetDate); }
         */
    }

    // [ID:0000612][Shin Fujihara] 2010/11 add end 2010年度対応

    /**
     * 利用者向け請求　印刷の設定を行う。
     * 
     * @param writer
     * @param patient
     * @param claimList
     * @param providerMap
     * @param printSetting
     * @throws Exception
     */
    private void doPrintAffair07(VRMap patient, VRList claimList, VRMap printSetting, Date claimDate, Date targetDate) throws Exception {
        
        VRMap printParam = new VRHashMap();
        // SQL発行用にデータを作成する。
        VRMap sqlParam = new VRHashMap();
        sqlParam.put("PATIENT_ID", patient.get("PATIENT_ID"));
        sqlParam.put("CLAIM_DATE", VRDateParser.format(claimDate, "yyyy/MM/dd"));
        sqlParam.put("PROVIDER_ID", QkanSystemInformation.getInstance().getLoginProviderID());
        // 単件に絞り込めるよう対象年月日を検索条件に追加
        sqlParam.put("TARGET_DATE", VRDateParser.format(targetDate, "yyyy/MM/dd"));

        // SQL文を発行し、データを取得する。
        VRList detailList = dbm.executeQuery(getSQL_GET_CLAIM_DETAIL_PATIENT(sqlParam));
        VRMap detail = null;
        if (detailList.size() > 0) {
            detail = (VRMap) detailList.get(0);
        }

        // データをパースし、利用表フォーマットを得る
        // [利用者向け請求書・領収書　詳細版対応] fujihara edit start
        // 帳票印刷スキップ判定用
        // 利用者
        int riyousya = 0;

        VRMap useClaimMap = null;
        switch (ACCastUtilities.toInt(printSetting.get("DETAILS_CHECK"), 0)) {
        // 詳細版出力にチェックなし
        case 0:
            QP001RecordUserClaim userClaim = new QP001RecordUserClaim();
            // [2014年要望][Shinobu Hitaka] 2015/04/15 add begin 利用者負担額0円も印刷可能にする
            userClaim.setZeroPrint(ACCastUtilities.toInt(printSetting.get("ZERO_CHECK"), 0));
            // [2014年要望][Shinobu Hitaka] 2015/04/15 add end
            userClaim.parse(claimList, manager);
            // 利用者支払い金額を取得
            riyousya = userClaim.getClaimTotal();
            useClaimMap = userClaim.getRecord();
            // 給付率
            useClaimMap.put("FUTAN_WARIAI", calc_futanwariai(userClaim.get_kyufuritsu(), userClaim.get_dokujiFlag()));
            break;
        // 詳細版出力にチェックあり
        case 1:
            QP001RecordUserClaimDetails userClaimDetails = new QP001RecordUserClaimDetails();
            // [2014年要望][Shinobu Hitaka] 2015/04/15 add begin 利用者負担額0円も印刷可能にする
            userClaimDetails.setZeroPrint(ACCastUtilities.toInt(printSetting.get("ZERO_CHECK"), 0));
            // [2014年要望][Shinobu Hitaka] 2015/04/15 add end
            userClaimDetails.parse(claimList, manager);
            // 利用者支払い金額を取得
            riyousya = userClaimDetails.getClaimTotal();
            useClaimMap = userClaimDetails.getRecord();
            // 給付率
            useClaimMap.put("FUTAN_WARIAI", calc_futanwariai(userClaimDetails.get_kyufuritsu(), userClaimDetails.get_dokujiFlag()));
            break;
        }

        if (ACTextUtilities.isNullText(useClaimMap.get("TARGET_DATE"))) {
            useClaimMap.put("TARGET_DATE", targetDate);
        }

        // 印刷クラス用に転送するデータを設定する。
        printParam.put("STYLE_DATA", useClaimMap);

        if (detail != null) {
            printParam.put("CLAIM_PATIENT_DETAIL", detail);
            riyousya += ACCastUtilities.toInt(detail.get("SELF_PAY_NO1"), 0);
            riyousya += ACCastUtilities.toInt(detail.get("SELF_PAY_NO2"), 0);
            riyousya += ACCastUtilities.toInt(detail.get("SELF_PAY_NO3"), 0);
            riyousya += ACCastUtilities.toInt(detail.get("OTHER_PAY_NO1"), 0);
            riyousya += ACCastUtilities.toInt(detail.get("OTHER_PAY_NO2"), 0);
            riyousya += ACCastUtilities.toInt(detail.get("OTHER_PAY_NO3"), 0);
            riyousya += ACCastUtilities.toInt(detail.get("OTHER_PAY_NO4"), 0);
            riyousya += ACCastUtilities.toInt(detail.get("OTHER_PAY_NO5"), 0);
            riyousya += ACCastUtilities.toInt(detail.get("OTHER_PAY_NO6"), 0);
        }

        // 印刷対象の帳票数
        patientClaimPdfCount++;

        if ((riyousya) == 0) {
            // 印刷スキップ対象の帳票数
            patientClaimPdfEmptyCount++;
            // スキップが許可されている場合のみ
            if (isSkipEmptyPatientClaim()) {
                // 現在の処理対象とメインのリストを突合する
                int patientId = ACCastUtilities.toInt(
                        patient.getData("PATIENT_ID"), -1);
                // 利用者負担の発生しない利用者としてリスト登録
                if (patientId != -1) {
                    noPatientSelfList.add(new Integer(patientId));
                }
                return;
            }
        }

        //

        printParam.put("PATIENT_NAME", QkanCommon.toFullName(
                patient.get("PATIENT_FAMILY_NAME"),
                patient.get("PATIENT_FIRST_NAME")));
        printParam.put("SEIKYU_DATE", claimDate);
        printParam.put("PROVIDER", providerMap.get(QkanSystemInformation
                .getInstance().getLoginProviderID()));
        printParam.put("PRINT_SETTING", printSetting);
        // 様式番号印刷オプション
        printParam.put("YOSHIKI_BANGO", yoshikiBango);

        // 居宅介護支援事業所
        VRList careProvider = dbm
                .executeQuery(getSQL_GET_CARE_PROVIDER(sqlParam));
        if (careProvider != null && careProvider.size() > 0) {
            String careProviderId = String
                    .valueOf(((VRMap) careProvider.get(0)).get("PROVIDER_ID"));
            printParam.put("CARE_PROVIDER", providerMap.get(careProviderId));
        }

        boolean isPrintableInnerTax = false;
        final Date innerTaxStart = ACCastUtilities.toDate("2007/04/01", null);
        if (ACDateUtilities.compareOnDay(innerTaxStart, claimDate) <= 0) {
            isPrintableInnerTax = true;
        }

        // 大幅改修
        // 出力する帳票を判別
        int target_radio = ACCastUtilities.toInt(
                printSetting.get("TARGET_RADIO"), 0);

        // 請求書にチェックあり
        if ((target_radio & 1) == 1) {
            // 振込先なし
            if (ACCastUtilities.toInt(printSetting.get("PRINT_CHECK"), 0) == 0) {
                if (isPrintableInnerTax) {
                    if (ACCastUtilities.toInt(
                            printSetting.get("DETAILS_CHECK"), 0) == 0) {
                        QP001P211 qp00123 = new QP001P211();
                        qp00123.doPrint(writer, printParam);
                    } else {
                        QP001P221 qp00123_1 = new QP001P221();
                        qp00123_1.doPrint(writer, printParam);
                    }
                } else {
                    // [Masahiko Higuchi] edit - start 詳細版に関してはうち消費税なしも同様の印字
                    if (ACCastUtilities.toInt(
                            printSetting.get("DETAILS_CHECK"), 0) == 0) {
                        QP001P201 qp00115 = new QP001P201();
                        qp00115.doPrint(writer, printParam);
                    } else {
                        QP001P221 qp00123_1 = new QP001P221();
                        qp00123_1.doPrint(writer, printParam);
                    }
                    // [Masahiko Higuchi] edit - end
                }
                // 振込先なし
            } else {
                if (isPrintableInnerTax) {
                    if (ACCastUtilities.toInt(
                            printSetting.get("DETAILS_CHECK"), 0) == 0) {
                        QP001P212 qp00124 = new QP001P212();
                        qp00124.doPrint(writer, printParam);
                    } else {
                        QP001P222 qp00124_1 = new QP001P222();
                        qp00124_1.doPrint(writer, printParam);
                    }
                } else {
                    // [Masahiko Higuchi] edit - start 詳細版に関してはうち消費税なしも同様の印字
                    if (ACCastUtilities.toInt(
                            printSetting.get("DETAILS_CHECK"), 0) == 0) {
                        QP001P202 qp00116 = new QP001P202();
                        qp00116.doPrint(writer, printParam);
                    } else {
                        QP001P222 qp00124_1 = new QP001P222();
                        qp00124_1.doPrint(writer, printParam);
                    }
                    // [Masahiko Higuchi] edit - end
                }
            }
        }

        // 領収書にチェックあり
        if ((target_radio & 2) == 2) {
            // 医療費控除対応版なし
            if (ACCastUtilities.toInt(printSetting.get("STYLE_CHECK"), 0) == 0) {
                // 振込先なし
                if (ACCastUtilities.toInt(printSetting.get("PRINT_CHECK"), 0) == 0) {
                    if (isPrintableInnerTax) {
                        if (ACCastUtilities.toInt(
                                printSetting.get("DETAILS_CHECK"), 0) == 0) {
                            QP001P213 qp00125 = new QP001P213();
                            qp00125.doPrint(writer, printParam);
                        } else {
                            QP001P223 qp00125_1 = new QP001P223();
                            qp00125_1.doPrint(writer, printParam);
                        }
                    } else {
                        // [Masahiko Higuchi] edit - start 詳細版に関してはうち消費税なしも同様の印字
                        if (ACCastUtilities.toInt(
                                printSetting.get("DETAILS_CHECK"), 0) == 0) {
                            QP001P203 qp00117 = new QP001P203();
                            qp00117.doPrint(writer, printParam);
                        } else {
                            QP001P223 qp00125_1 = new QP001P223();
                            qp00125_1.doPrint(writer, printParam);
                        }
                        // [Masahiko Higuchi] edit - end
                    }
                    // 振込先有
                } else {
                    if (isPrintableInnerTax) {
                        if (ACCastUtilities.toInt(
                                printSetting.get("DETAILS_CHECK"), 0) == 0) {
                            QP001P214 qp00126 = new QP001P214();
                            qp00126.doPrint(writer, printParam);
                        } else {
                            QP001P224 qp00126_1 = new QP001P224();
                            qp00126_1.doPrint(writer, printParam);
                        }
                    } else {
                        // [Masahiko Higuchi] edit - start 詳細版に関してはうち消費税なしも同様の印字
                        if (ACCastUtilities.toInt(
                                printSetting.get("DETAILS_CHECK"), 0) == 0) {
                            QP001P204 qp00118 = new QP001P204();
                            qp00118.doPrint(writer, printParam);
                        } else {
                            QP001P224 qp00126_1 = new QP001P224();
                            qp00126_1.doPrint(writer, printParam);
                        }
                        // [Masahiko Higuchi] edit - end
                    }
                }
                // 医療費控除対応版あり
            } else {
                if (isPrintableInnerTax) {
                    if (ACCastUtilities.toInt(
                            printSetting.get("DETAILS_CHECK"), 0) == 0) {
                        QP001P215 qp00127 = new QP001P215();
                        qp00127.doPrint(writer, printParam);
                    } else {
                        QP001P225 qp00127_1 = new QP001P225();
                        qp00127_1.doPrint(writer, printParam);
                    }
                } else {
                    // [Masahiko Higuchi] edit - start 詳細版に関してはうち消費税なしも同様の印字
                    if (ACCastUtilities.toInt(
                            printSetting.get("DETAILS_CHECK"), 0) == 0) {
                        QP001P205 qp00119 = new QP001P205();
                        qp00119.doPrint(writer, printParam);
                    } else {
                        QP001P225 qp00127_1 = new QP001P225();
                        qp00127_1.doPrint(writer, printParam);
                    }
                    // [Masahiko Higuchi] edit - end
                }
            }
        }

    }

    // [ID:0000612][Shin Fujihara] 2010/11 add begin 2010年度対応
    private void doPrintAffair07Service(VRMap patient, VRList claimList,
            VRMap printSetting, Date claimDate, Date targetDate)
            throws Exception {

        // ------ 印字に必要なデータの準備

        // SQL発行用にデータを作成する。
        VRMap sqlParam = new VRHashMap();
        sqlParam.put("PATIENT_ID", patient.get("PATIENT_ID"));
        sqlParam.put("CLAIM_DATE", VRDateParser.format(claimDate, "yyyy/MM/dd"));
        sqlParam.put("PROVIDER_ID", QkanSystemInformation.getInstance()
                .getLoginProviderID());
        sqlParam.put("TARGET_DATE",
                VRDateParser.format(targetDate, "yyyy/MM/dd"));

        // SQL文を発行し、利用者向け請求個別のデータを取得。さーびす種類コードをキーにHashMapに格納
        VRMap detailMap = new VRHashMap();
        ACBindUtilities.setMapFromArray(
                dbm.executeQuery(getSQL_GET_CLAIM_DETAIL_PATIENT(sqlParam)),
                detailMap, "SERVICE_CODE_KIND");

        VRMap printParam = new VRHashMap();
        printParam.put("PATIENT_NAME", QkanCommon.toFullName(
                patient.get("PATIENT_FAMILY_NAME"),
                patient.get("PATIENT_FIRST_NAME")));
        printParam.put("SEIKYU_DATE", claimDate);
        printParam.put("PROVIDER", providerMap.get(QkanSystemInformation
                .getInstance().getLoginProviderID()));
        printParam.put("PRINT_SETTING", printSetting);
        // 様式番号印刷オプション
        printParam.put("YOSHIKI_BANGO", yoshikiBango);

        // 居宅介護支援事業所
        VRList careProvider = dbm
                .executeQuery(getSQL_GET_CARE_PROVIDER(sqlParam));
        if (careProvider != null && careProvider.size() > 0) {
            String careProviderId = String
                    .valueOf(((VRMap) careProvider.get(0)).get("PROVIDER_ID"));
            printParam.put("CARE_PROVIDER", providerMap.get(careProviderId));
        }

        boolean isPrintableInnerTax = false;
        final Date innerTaxStart = ACCastUtilities.toDate("2007/04/01", null);
        if (ACDateUtilities.compareOnDay(innerTaxStart, claimDate) <= 0) {
            isPrintableInnerTax = true;
        }

        // ログイン事業所名を取得
        String defaultProviderName = ACCastUtilities
                .toString(((VRMap) printParam.get("PROVIDER"))
                        .get("PROVIDER_NAME"));

        // 変換する事業所名を取得
        VRMap providerNames = new VRHashMap();
        ACBindUtilities.setMapFromArray(
                (VRList) printSetting.get("PROVIDER_NAMES"), providerNames,
                "SERVICE_CODE_KIND");

        // ------ 印字帳票ごとにデータを分割

        Map claimMap = new TreeMap();
        VRMap baseMap = new VRHashMap();
        VRMap diagnosisMap = new VRHashMap();
        VRMap nursingMap = new VRHashMap();
        VRMap claim = null;

        for (int i = 0; i < claimList.size(); i++) {
            claim = (VRMap) claimList.get(i);

            // キーの存在チェック
            if (!claim.containsKey("CATEGORY_NO")) {
                continue;
            }

            switch (ACCastUtilities.toInt(claim.get("CATEGORY_NO"), 0)) {
            // 基本情報レコード
            case 2:
                baseMap.put(claim.get("201001"), claim);
                break;

            // 明細情報レコード
            case 3:
                pushClaimMap(claimMap, claim.get("301001"),
                        claim.get("301007"), claim);

                // 特定診療費情報レコード
            case 5:
                // 特定診療費情報レコード順次番号が99の場合のみ有効
                if ("99".equals(ACCastUtilities.toString(claim.get("501007"),
                        ""))) {
                    diagnosisMap.put(claim.get("501001"), claim);
                }
                break;

            // 集計情報レコード
            case 7:
                pushClaimMap(claimMap, claim.get("701001"),
                        claim.get("701007"), claim);
                break;

            // 特定入所者介護サービス費用情報レコード
            case 8:
                // pushClaimMap(claimMap, claim.get("801001"),
                // claim.get("801008"), claim);
                VRList nursingList = null;
                if (nursingMap.containsKey(claim.get("801001"))) {
                    nursingList = (VRList) nursingMap.get(claim.get("801001"));
                } else {
                    nursingList = new VRArrayList();
                    nursingMap.put(claim.get("801001"), nursingList);
                }
                nursingList.add(claim);
                break;

            // 社会福祉法人軽減額情報レコード
            case 9:
                pushClaimMap(claimMap, claim.get("901001"),
                        claim.get("901008"), claim);
                break;
            }
        }

        // サービス種類ごとにループしならが呼び出し
        Iterator it = claimMap.keySet().iterator();
        while (it.hasNext()) {
            VRMap detail = null;

            String key = it.next().toString();
            VRList list = (VRList) claimMap.get(key);

            // キーから交換識別番号とサービス種類コードを取得
            String[] keys = key.split("-");

            // 基本情報を取得
            if (baseMap.containsKey(keys[0])) {
                list.add(baseMap.get(keys[0]));
            }

            // 特定診療費情報を取得
            if (diagnosisMap.containsKey(keys[0])) {
                list.add(diagnosisMap.get(keys[0]));
            }

            // 食費・居住費の情報を取得
            if (nursingMap.containsKey(keys[0])) {
                list.addAll((VRList) nursingMap.get(keys[0]));
            }

            // 個別の利用者向け請求設定を取得
            if (detailMap.containsKey(keys[1])) {
                detail = (VRMap) detailMap.get(keys[1]);
            }

            // 変換対象の事業所名称が存在するか確認
            if (providerNames.containsKey(new Integer(keys[1]))) {
                VRMap convertProviderName = (VRMap) providerNames
                        .get(new Integer(keys[1]));
                ((VRMap) printParam.get("PROVIDER")).put("PROVIDER_NAME",
                        convertProviderName.get("PROVIDER_NAME"));
            } else {
                ((VRMap) printParam.get("PROVIDER")).put("PROVIDER_NAME",
                        defaultProviderName);
            }

            // 変動項目を初期化
            printParam.put("STYLE_DATA", null);
            printParam.put("CLAIM_PATIENT_DETAIL", null);
            doPrintAffair07ServiceDetail(patient, list, printSetting,
                    targetDate, detail, printParam, isPrintableInnerTax);
        }

    }

    private void pushClaimMap(Map claimMap, Object key1, Object key2, VRMap map)
            throws Exception {
        VRList list = null;
        String key = String.valueOf(key1) + "-" + String.valueOf(key2);
        if (claimMap.containsKey(key)) {
            list = (VRList) claimMap.get(key);
        } else {
            list = new VRArrayList();
            claimMap.put(key, list);
        }
        list.add(map);
    }

    private void doPrintAffair07ServiceDetail(VRMap patient, VRList claimList,
            VRMap printSetting, Date targetDate, VRMap detail,
            VRMap printParam, boolean isPrintableInnerTax) throws Exception {

        // データをパースし、利用表フォーマットを得る
        // [利用者向け請求書・領収書　詳細版対応] fujihara edit start
        // 帳票印刷スキップ判定用
        // 利用者
        int riyousya = 0;

        VRMap useClaimMap = null;
        switch (ACCastUtilities.toInt(printSetting.get("DETAILS_CHECK"), 0)) {
        // 詳細版出力にチェックなし
        case 0:
            QP001RecordUserClaim userClaim = new QP001RecordUserClaim();
            // [2014年要望][Shinobu Hitaka] 2015/04/15 add begin 利用者負担額0円も印刷可能にする
            userClaim.setZeroPrint(ACCastUtilities.toInt(printSetting.get("ZERO_CHECK"), 0));
            // [2014年要望][Shinobu Hitaka] 2015/04/15 add end
            userClaim.parse(claimList, manager);
            // 利用者支払い金額を取得
            riyousya = userClaim.getClaimTotal();
            useClaimMap = userClaim.getRecord();
            // 給付率
            useClaimMap.put("FUTAN_WARIAI", calc_futanwariai(userClaim.get_kyufuritsu(), userClaim.get_dokujiFlag()));
            break;
        // 詳細版出力にチェックあり
        case 1:
            QP001RecordUserClaimDetails userClaimDetails = new QP001RecordUserClaimDetails();
            // [2014年要望][Shinobu Hitaka] 2015/04/15 add begin 利用者負担額0円も印刷可能にする
            userClaimDetails.setZeroPrint(ACCastUtilities.toInt(printSetting.get("ZERO_CHECK"), 0));
            // [2014年要望][Shinobu Hitaka] 2015/04/15 add end
            userClaimDetails.parse(claimList, manager);
            // 利用者支払い金額を取得
            riyousya = userClaimDetails.getClaimTotal();
            useClaimMap = userClaimDetails.getRecord();
            // 給付率
            useClaimMap.put("FUTAN_WARIAI", calc_futanwariai(userClaimDetails.get_kyufuritsu(), userClaimDetails.get_dokujiFlag()));
            break;
        }

        if (ACTextUtilities.isNullText(useClaimMap.get("TARGET_DATE"))) {
            useClaimMap.put("TARGET_DATE", targetDate);
        }

        // 印刷クラス用に転送するデータを設定する。
        printParam.put("STYLE_DATA", useClaimMap);

        if (detail != null) {
            printParam.put("CLAIM_PATIENT_DETAIL", detail);
            riyousya += ACCastUtilities.toInt(detail.get("SELF_PAY_NO1"), 0);
            riyousya += ACCastUtilities.toInt(detail.get("SELF_PAY_NO2"), 0);
            riyousya += ACCastUtilities.toInt(detail.get("SELF_PAY_NO3"), 0);
            riyousya += ACCastUtilities.toInt(detail.get("OTHER_PAY_NO1"), 0);
            riyousya += ACCastUtilities.toInt(detail.get("OTHER_PAY_NO2"), 0);
            riyousya += ACCastUtilities.toInt(detail.get("OTHER_PAY_NO3"), 0);
            riyousya += ACCastUtilities.toInt(detail.get("OTHER_PAY_NO4"), 0);
            riyousya += ACCastUtilities.toInt(detail.get("OTHER_PAY_NO5"), 0);
            riyousya += ACCastUtilities.toInt(detail.get("OTHER_PAY_NO6"), 0);
        }

        // 印刷対象の帳票数
        patientClaimPdfCount++;

        if ((riyousya) == 0) {
            // 印刷スキップ対象の帳票数
            patientClaimPdfEmptyCount++;
            // スキップが許可されている場合のみ
            if (isSkipEmptyPatientClaim()) {
                // 現在の処理対象とメインのリストを突合する
                int patientId = ACCastUtilities.toInt(
                        patient.getData("PATIENT_ID"), -1);
                // 利用者負担の発生しない利用者としてリスト登録
                if (patientId != -1) {
                    noPatientSelfList.add(new Integer(patientId));
                }
                return;
            }
        }

        // 出力する帳票を判別
        int target_radio = ACCastUtilities.toInt(
                printSetting.get("TARGET_RADIO"), 0);

        // 請求書にチェックあり
        if ((target_radio & 1) == 1) {
            // 振込先なし
            if (ACCastUtilities.toInt(printSetting.get("PRINT_CHECK"), 0) == 0) {
                if (isPrintableInnerTax) {
                    if (ACCastUtilities.toInt(
                            printSetting.get("DETAILS_CHECK"), 0) == 0) {
                        QP001P211 qp00123 = new QP001P211();
                        qp00123.doPrint(writer, printParam);
                    } else {
                        QP001P221 qp00123_1 = new QP001P221();
                        qp00123_1.doPrint(writer, printParam);
                    }
                } else {
                    if (ACCastUtilities.toInt(
                            printSetting.get("DETAILS_CHECK"), 0) == 0) {
                        QP001P201 qp00115 = new QP001P201();
                        qp00115.doPrint(writer, printParam);
                    } else {
                        QP001P221 qp00123_1 = new QP001P221();
                        qp00123_1.doPrint(writer, printParam);
                    }
                }
                // 振込先なし
            } else {
                if (isPrintableInnerTax) {
                    if (ACCastUtilities.toInt(
                            printSetting.get("DETAILS_CHECK"), 0) == 0) {
                        QP001P212 qp00124 = new QP001P212();
                        qp00124.doPrint(writer, printParam);
                    } else {
                        QP001P222 qp00124_1 = new QP001P222();
                        qp00124_1.doPrint(writer, printParam);
                    }
                } else {
                    if (ACCastUtilities.toInt(
                            printSetting.get("DETAILS_CHECK"), 0) == 0) {
                        QP001P202 qp00116 = new QP001P202();
                        qp00116.doPrint(writer, printParam);
                    } else {
                        QP001P222 qp00124_1 = new QP001P222();
                        qp00124_1.doPrint(writer, printParam);
                    }
                }
            }
        }

        // 領収書にチェックあり
        if ((target_radio & 2) == 2) {
            // 医療費控除対応版なし
            if (ACCastUtilities.toInt(printSetting.get("STYLE_CHECK"), 0) == 0) {
                // 振込先なし
                if (ACCastUtilities.toInt(printSetting.get("PRINT_CHECK"), 0) == 0) {
                    if (isPrintableInnerTax) {
                        if (ACCastUtilities.toInt(
                                printSetting.get("DETAILS_CHECK"), 0) == 0) {
                            QP001P213 qp00125 = new QP001P213();
                            qp00125.doPrint(writer, printParam);
                        } else {
                            QP001P223 qp00125_1 = new QP001P223();
                            qp00125_1.doPrint(writer, printParam);
                        }
                    } else {
                        if (ACCastUtilities.toInt(
                                printSetting.get("DETAILS_CHECK"), 0) == 0) {
                            QP001P203 qp00117 = new QP001P203();
                            qp00117.doPrint(writer, printParam);
                        } else {
                            QP001P223 qp00125_1 = new QP001P223();
                            qp00125_1.doPrint(writer, printParam);
                        }
                    }
                    // 振込先有
                } else {
                    if (isPrintableInnerTax) {
                        if (ACCastUtilities.toInt(
                                printSetting.get("DETAILS_CHECK"), 0) == 0) {
                            QP001P214 qp00126 = new QP001P214();
                            qp00126.doPrint(writer, printParam);
                        } else {
                            QP001P224 qp00126_1 = new QP001P224();
                            qp00126_1.doPrint(writer, printParam);
                        }
                    } else {
                        if (ACCastUtilities.toInt(
                                printSetting.get("DETAILS_CHECK"), 0) == 0) {
                            QP001P204 qp00118 = new QP001P204();
                            qp00118.doPrint(writer, printParam);
                        } else {
                            QP001P224 qp00126_1 = new QP001P224();
                            qp00126_1.doPrint(writer, printParam);
                        }
                    }
                }
                // 医療費控除対応版あり
            } else {
                if (isPrintableInnerTax) {
                    if (ACCastUtilities.toInt(
                            printSetting.get("DETAILS_CHECK"), 0) == 0) {
                        QP001P215 qp00127 = new QP001P215();
                        qp00127.doPrint(writer, printParam);
                    } else {
                        QP001P225 qp00127_1 = new QP001P225();
                        qp00127_1.doPrint(writer, printParam);
                    }
                } else {
                    if (ACCastUtilities.toInt(
                            printSetting.get("DETAILS_CHECK"), 0) == 0) {
                        QP001P205 qp00119 = new QP001P205();
                        qp00119.doPrint(writer, printParam);
                    } else {
                        QP001P225 qp00127_1 = new QP001P225();
                        qp00127_1.doPrint(writer, printParam);
                    }
                }
            }
        }
    }

    // [ID:0000612][Shin Fujihara] 2010/11 add end 2010年度対応

    /**
     * 利用者請求　利用者負担額等を取得するためのSQLを取得します。
     * 
     * @param sqlParam
     * @return
     * @throws Exception
     */
    public String getSQL_GET_CLAIM_DETAIL_PATIENT(VRMap sqlParam)
            throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT");
        sb.append(" CLAIM.TARGET_DATE,");
        sb.append(" CLAIM_PATIENT_DETAIL.*");
        sb.append(" FROM");
        sb.append(" CLAIM,");
        sb.append(" CLAIM_PATIENT_DETAIL");
        sb.append(" WHERE");
        sb.append(" (CLAIM.CLAIM_ID = CLAIM_PATIENT_DETAIL.CLAIM_ID)");
        sb.append(" AND(CLAIM.CLAIM_STYLE_TYPE = 30101)");
        sb.append(" AND(CLAIM.CATEGORY_NO = 16)");

        sb.append(" AND(CLAIM.PATIENT_ID = " + sqlParam.get("PATIENT_ID") + ")");
        sb.append(" AND(CLAIM.CLAIM_DATE = '" + sqlParam.get("CLAIM_DATE")
                + "')");
        // 単件に絞り込むため、条件を追加
        sb.append(" AND(CLAIM.TARGET_DATE = '" + sqlParam.get("TARGET_DATE")
                + "')");

        sb.append(" AND(CLAIM.PROVIDER_ID = '" + sqlParam.get("PROVIDER_ID")
                + "')");

        return sb.toString();
    }

    /**
     * 利用者の居宅介護支援事業所IDを取得する。
     * 
     * @param sqlParam
     * @return
     * @throws Exception
     */
    public String getSQL_GET_CARE_PROVIDER(VRMap sqlParam) throws Exception {
        StringBuilder sb = new StringBuilder();

        // 請求年月ではなく対象年月で居宅介護支援事業所を取得するよう変更
        Date target = ACCastUtilities.toDate(sqlParam.get("TARGET_DATE"), null);

        sb.append(" SELECT PROVIDER_ID FROM PATIENT_NINTEI_HISTORY");
        sb.append(" WHERE");
        sb.append(" (PATIENT_ID = " + sqlParam.get("PATIENT_ID") + ")");
        if (target != null) {
// 2014/12/17 [Yoichiro Kamei] mod - begin システム有効期間対応
//            sb.append(" AND(INSURE_VALID_START <= '"
            sb.append(" AND(SYSTEM_INSURE_VALID_START <= '"
// 2014/12/17 [Yoichiro Kamei] mod - end
                    + VRDateParser.format(
                            ACDateUtilities.toLastDayOfMonth(target),
                            "yyyy/MM/dd") + "')");
// 2014/12/17 [Yoichiro Kamei] mod - begin システム有効期間対応
//            sb.append(" AND(INSURE_VALID_END >= '"
            sb.append(" AND(SYSTEM_INSURE_VALID_END >= '"
//2014/12/17 [Yoichiro Kamei] mod - end
                    + VRDateParser.format(
                            ACDateUtilities.toFirstDayOfMonth(target),
                            "yyyy/MM/dd") + "')");
        }
// 2014/12/17 [Yoichiro Kamei] mod - begin システム有効期間対応
//        sb.append(" ORDER BY INSURE_VALID_END DESC");
        sb.append(" ORDER BY SYSTEM_INSURE_VALID_END DESC");
//2014/12/17 [Yoichiro Kamei] mod - end
        return sb.toString();
    }

    /*
     * // 2007/12/4 [Masahiko Higuchi] add - begin
     */
    /**
     * スキップを許可するかを返却します。
     * 
     * @return True:スキップ許可 False:スキップ不許可
     * @author Masahiko Higuchi
     * @since Ver 5.4.1
     */
    public boolean isSkipEmptyPatientClaim() {
        return skipEmptyPatientClaim;
    }

    /**
     * スキップの有無を設定します。
     * 
     * @param skipEmptyPatientClaim
     * @author Masahiko Higuchi
     * @since Ver 5.4.1
     */
    public void setSkipEmptyPatientClaim(boolean skipEmptyPatientClaim) {
        this.skipEmptyPatientClaim = skipEmptyPatientClaim;
    }

    /**
     * XMLWriterを取得します。
     * 
     * @return
     * @author Masahiko Higuchi
     * @since Ver 5.4.1
     */
    public ACChotarouXMLWriter getWriter() {
        return writer;
    }

    private void buildPatientClaim(VRList patientList, VRMap param)
            throws Exception {
        Date claimDate = null;

        // patientDataの件数分ループする。
        for (int j = 0; j < patientList.size(); j++) {
            // 再集計ロジックを通す
            VRMap map = (VRMap) patientList.getData(j);
            // 未選択の場合処理をスキップする。
            if (!"TRUE".equalsIgnoreCase(ACCastUtilities
                    .toString(VRBindPathParser.get("CHOISE", map)))) {
                continue;
            }
            claimDate = ACCastUtilities.toDate(map.get("CLAIM_DATE"));
            // 利用者ID退避用にint patient_id を生成し、patientDataの KEY : PATIENT_ID を設定する。
            int patient_id = ACCastUtilities.toInt(VRBindPathParser.get(
                    "PATIENT_ID", map));
            // 様式番号を取得する。
            int claimStyleType = ACCastUtilities.toInt(
                    VRBindPathParser.get("CLAIM_STYLE_TYPE", map), 0);

            // 請求詳細情報を取得し、VRArrayList claimList に格納する。
            StringBuilder sb = new StringBuilder();
            sb.append(" AND(CLAIM.CLAIM_DATE = '"
                    + VRDateParser.format(claimDate, "yyyy/MM/dd") + "')");
            sb.append(" AND(CLAIM.TARGET_DATE = '"
                    + VRDateParser.format(
                            ACCastUtilities.toDate(map.get("TARGET_DATE")),
                            "yyyy/MM/dd") + "')");
            // 利用者IDを指定しているならば特定の利用者のみ。未指定ならば全利用者を対象とする。
            sb.append(" AND(CLAIM.PATIENT_ID = " + patient_id + ")");

            // 保険者番号、被保険者番号の検索条件を追加する。
            sb.append(" AND(CLAIM.INSURER_ID = '"
                    + VRBindPathParser.get("INSURER_ID", map) + "')");

            if (VRBindPathParser.get("INSURED_ID", map) != null) {
                sb.append(" AND(CLAIM.INSURED_ID = '"
                        + VRBindPathParser.get("INSURED_ID", map) + "')");
            } else {
                sb.append(" AND(CLAIM.INSURED_ID = '')");
            }

            sb.append(" AND(CLAIM.PROVIDER_ID = '"
                    + QkanSystemInformation.getInstance().getLoginProviderID()
                    + "')");

            if (!"07".equals(affair) && !"08".equals(affair)) {
                sb.append(" AND(CLAIM.CLAIM_STYLE_TYPE = " + claimStyleType
                        + ")");
            }

            VRList claimList = QkanCommon.getClaimDetailCustom(dbm, claimDate,
                    sb.toString());

            if ((claimList == null) || (claimList.size() == 0)) {
                VRLogger.warning("集計データ取得エラー:" + sb.toString());
                continue;
            }

            // 初期化
            VRHashMap printParam = new VRHashMap();
            // 請求対象日
            printParam.put("SEIKYU_DATE", claimDate);
            // 帳票データ
            printParam.put("STYLE_DATA", claimList);
            // 利用者情報
            VRMap patient = (VRLinkedHashMap) QkanCommon.getPatientInfo(dbm,
                    patient_id).get(0);
            printParam.put("PATIENT", patient);
            // 事業所情報
            printParam.put("PROVIDERS", providerMap);
            // 様式番号
            printParam.put("CLAIM_STYLE_TYPE", String.valueOf(claimStyleType));
            // 様式番号印刷オプション
            printParam.put("YOSHIKI_BANGO", yoshikiBango);

            printParam.put("MANAGER", manager);

            // [ID:0000612][Shin Fujihara] 2010/11 edit begin 2010年度対応
            // doPrintAffair07(patient,claimList,param,claimDate,ACCastUtilities.toDate(map.get("TARGET_DATE")));
            doPrintAffair07Selecter(patient, claimList, param, claimDate,
                    ACCastUtilities.toDate(map.get("TARGET_DATE")));
            // [ID:0000612][Shin Fujihara] 2010/11 edit end 2010年度対応

            if (!"06".equals(affair)) {
                // 明示的に解放
                printParam.clear();
                printParam = null;
            }
        }
    }
    // 2007/12/4 [Masahiko Higuchi] add - end
    
    //[2016年要望][Shinobu Hitaka] 2016/12/02 add begin 負担割合の表示文字列を取得します
    /**
     * 負担割合の表示文字列を取得する。
     * @return
     */
    public String calc_futanwariai(int kyufuritsu, int dokujiFlag) {
        int wariai = 100 - kyufuritsu;
        String strWariai = "";
        if (wariai > 0) {
            if (wariai == 100) {
                if (dokujiFlag == 1) {
                    strWariai = "独自/定率";
                } else if (dokujiFlag == 2) {
                    strWariai = "独自/定額";
                } else if (dokujiFlag == 3) {
                    strWariai = "独自/定率定額";
                }
            } else {
                strWariai = "負担割合:" + ACCastUtilities.toString(wariai, "") + "%";
            }
        }
        return strWariai;
    }
    //[2016年要望][Shinobu Hitaka] 2016/12/02 add end

}
