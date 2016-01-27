package jp.or.med.orca.qkan;

import java.awt.Component;
import java.awt.Container;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.core.ACDBManagerCreatable;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.core.ACFrameEventProcesser;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.sql.ACSeparateTableManager;
import jp.nichicom.ac.text.ACNowAgeFormat;
import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACSQLSafeIntegerFormat;
import jp.nichicom.ac.text.ACSQLSafeNullToZeroIntegerFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.bridge.sql.BridgeFirebirdSeparateTable;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.bind.VRBindable;
import jp.nichicom.vr.component.AbstractVRCheckBox;
import jp.nichicom.vr.component.AbstractVRComboBox;
import jp.nichicom.vr.component.AbstractVRTextField;
import jp.nichicom.vr.component.VRRadioButtonGroup;
import jp.nichicom.vr.container.VRLabelContainer;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRLinkedHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.logging.VRLogger;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;

/**
 * 給管帳システム全体から利用可能な共通関数群です。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2005/12/01
 */
public class QkanCommon {
    /**
     * すべての保険者を対象とする検索モード定数です。
     */
    public static final int INSURER_FIND_ALL = 0;
    /**
     * 介護保険もしくは指定なしの保険者を対象とする検索モード定数です。
     */
    public static final int INSURER_FIND_CARE_ONLY = 1;

    /**
     * 医療保険もしくは指定なしの保険者を対象とする検索モード定数です。
     */
    public static final int INSURER_FIND_MEDICAL_ONLY = 2;

    private static ACNowAgeFormat ageFormat = new ACNowAgeFormat();

    private static ACSeparateTableManager separateTableManager;

    /**
     * ログイン日付を基準として、誕生日から現在年齢を返します。
     * 
     * @param birthDay 誕生日
     * @return 現在年齢
     */
    public static int calcAge(Date birthDay) {
        ageFormat.setBaseDate(QkanSystemInformation.getInstance()
                .getSystemDate());
        return Integer.parseInt(ageFormat.format(birthDay));
    }

    /**
     * 引数の日付を基準として、誕生日から現在年齢を返します。
     * 
     * @param birthDay 誕生日
     * @param baseDate 基準日
     * @return 現在年齢
     */
    public static int calcAge(Date birthDay, Date baseDate) {
        ageFormat.setBaseDate(baseDate);
        return Integer.parseInt(ageFormat.format(birthDay));
    }

    /**
     * 指定画面項目以下のラジオグループ/テキスト/チェックのEnabled状態を引数のMapに退避します。
     * 
     * @param target 対象
     * @param map バックアップ先マップ
     */
    public static void captureEnabled(Component target, Map map) {
        if ((target instanceof VRRadioButtonGroup)
                || (target instanceof JTextField)
                || (target instanceof JCheckBox)
                || (target instanceof JComboBox)) {
            map.put(target, new Boolean(target.isEnabled()));
        } else if (target instanceof Container) {
            if (target instanceof VRLabelContainer) {
                // ラベルコンテナ
                map.put(target, new Boolean(target.isEnabled()));
            }
            int end = ((Container) target).getComponentCount();
            for (int i = 0; i < end; i++) {
                // 再帰
                captureEnabled(((Container) target).getComponent(i), map);
            }
        }

    }

    /**
     * 「指定キーのデータ型をStringからIntegerに変換」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public static void convertValueFromStringToInteger(VRMap map, Object[] keys)
            throws Exception {
        // 指定KEYのデータ型の変換関数
        if ((map != null) && (keys != null)) {
            int end = keys.length;
            for (int i = 0; i < end; i++) {
                Object targetKey = keys[i];
                Object targetData = VRBindPathParser.get(targetKey, map);
                VRBindPathParser.set(targetKey, map,
                        ACCastUtilities.toInteger(targetData, null));
            }
        }
    }

    /**
     * デバッグ実行用に最低限の初期化を行ないます。
     */
    public static void debugInitialize() {
        try {
            ACDBManager dbm;
            // 2006/10/04 replace-begin Tozo TANAKA システムプロセッサにDB生成処理を委譲
            // dbm = new BridgeFirebirdDBManager();
            dbm = ((ACDBManagerCreatable) ACFrame.getInstance()
                    .getFrameEventProcesser()).createDBManager();
            // 2006/10/04 replace-end Tozo TANAKA システムプロセッサにDB生成処理を委譲
            VRList list;

            // コードマスタの取得と変換
            list = dbm
                    .executeQuery("SELECT * FROM M_CODE ORDER BY CODE_ID, CONTENT_SORT");
            if (list != null) {
                VRMap fullCodeM = new VRHashMap();
                Integer lastKey = null;
                VRList codeM = null;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    VRMap row = (VRMap) it.next();
                    Integer key = Integer.valueOf(String
                            .valueOf(VRBindPathParser.get("CODE_ID", row)));
                    if (key != null) {
                        if (!key.equals(lastKey)) {
                            codeM = new VRArrayList();
                            fullCodeM.setData(key, codeM);
                            lastKey = key;
                        }
                        codeM.addData(row);
                    }
                }
                // コードマスタをシステム共通に設定
                QkanSystemInformation.getInstance().setMasterCode(fullCodeM);
            }

            // バージョン
            QkanSystemInformation.getInstance().setMasterDataVersion("4.5");
            QkanSystemInformation.getInstance().setSchemeVersion("4.5");
            QkanSystemInformation.getInstance().setSystemVersion("4.5");

            // ログイン日付
            QkanSystemInformation.getInstance().setSystemDate(new Date());

            // ログイン事業者ID
            QkanSystemInformation.getInstance()
                    .setLoginProviderID("9999999999");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 認定履歴から非該当をフィルタリングします。
     * 
     * @param list 認定履歴
     * @return フィルタリング結果
     */
    public static VRList filterNotCorrespond(VRList list) {
        int size = list.size();
        if (size > 1) {
            // 非該当も含めて認定履歴が2件以上存在する場合
            VRList dest = new VRArrayList(size);

            // 認定履歴を全走査し、非該当以外を抽出する・
            for (int i = 0; i < size; i++) {
                Map map = (Map) list.get(i);
                if (!"1".equals(ACCastUtilities.toString(map.get("JOTAI_CODE"),
                        ""))) {
                    // 非該当でなければ追加
                    dest.add(map);
                }
            }
            if (!dest.isEmpty()) {
                // 要介護認定が1件以上あれば要介護履歴のみを返す。
                return dest;
            }
        }
        return list;
    }

    /**
     * 業務情報取得関数です。
     * <p>
     * ウィンドウタイトル等の情報を管理するマスタから情報を返します。
     * </p>
     * 
     * @param dbm DBManager
     * @param affairID 業務ID
     * @return 業務情報
     * @throws Exception 処理例外
     */
    public static VRMap getAffairInfo(ACDBManager dbm, String affairID)
            throws Exception {
        return getAffairInfo(dbm, affairID, null);
    }

    /**
     * 業務情報取得関数です。
     * <p>
     * ウィンドウタイトル等の情報を管理するマスタから情報を返します。
     * </p>
     * 
     * @param dbm DBManager
     * @param affairID 業務ID
     * @param mode モード
     * @return 業務情報
     * @throws Exception 処理例外
     */
    public static VRMap getAffairInfo(ACDBManager dbm, String affairID,
            String mode) throws Exception {
        StringBuilder sb;

        sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" M_AFFAIR_INFO.AFFAIR_ID,");
        sb.append(" M_AFFAIR_INFO.MODE,");
        sb.append(" M_AFFAIR_INFO.WINDOW_TITLE,");
        sb.append(" M_AFFAIR_INFO.AFFAIR_TITLE,");
        sb.append(" M_AFFAIR_INFO.LAST_TIME");
        sb.append(" FROM");
        sb.append(" M_AFFAIR_INFO");
        sb.append(" WHERE");
        sb.append(" (M_AFFAIR_INFO.AFFAIR_ID = '" + affairID + "')");
        if (mode != null) {
            sb.append(" AND(M_AFFAIR_INFO.MODE = '" + mode + "')");
        }

        if (dbm != null) {
            VRList list = dbm.executeQuery(sb.toString());
            if ((list != null) && (!list.isEmpty())) {
                return (VRMap) list.getData();
            }
        }
        return new VRHashMap();
    }

    /**
     * 地域単価取得関数です。
     * <p>
     * 利用票・提供票、実績集計時に、金額計算のために地域単価を取得します。
     * </p>
     * 
     * @param dbm DBManager
     * @param serviceKind 独自サービス種類コード
     * @param area 地域区分
     * @param targetDate 対象年月日
     * @return 地域単価
     * @throws Exception 処理例外
     */
    public static double getAreaUnitPrice(ACDBManager dbm, int serviceKind,
            int area, Date targetDate) throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.setTime(targetDate);
        String ym = VRDateParser.format(cal, "yyyy/MM/dd");

        StringBuilder sb;

        sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" M_AREA_UNIT_PRICE.UNIT_PRICE_VALUE");
        sb.append(" FROM");
        sb.append(" M_AREA_UNIT_PRICE");
        sb.append(" WHERE");
        sb.append(" (M_AREA_UNIT_PRICE.SERVICE_TYPE = '" + serviceKind + "')");
        sb.append(" AND(UNIT_PRICE_TYPE = " + area + ")");
        sb.append(" AND(M_AREA_UNIT_PRICE.UNIT_VALID_START <= '" + ym + "')");
        sb.append(" AND(M_AREA_UNIT_PRICE.UNIT_VALID_END >= '" + ym + "')");

        if (dbm != null) {
            VRList ret = dbm.executeQuery(sb.toString());
            if (ret.getDataSize() > 0) {
                return Double.parseDouble(String.valueOf(VRBindPathParser.get(
                        "UNIT_PRICE_VALUE", (VRMap) ret.getData())));
            }
        }
        return 0;
    }

    /**
     * コードマスタデータ取得関数です。
     * <p>
     * 本来コンテンツIDのフィールド名はCONTENTS_IDに固定ですが、このフィールド名を別のフィールド名に置換したVRArrayListを返します
     * 。
     * </p>
     * 
     * @param codeID コードID
     * @param newContentsID コンテンツIDの翻訳キー名
     * @return コードマスタデータ
     * @throws Exception 処理例外
     */
    public static VRList getArrayFromMasterCode(int codeID, String newContentsID)
            throws Exception {
        Object contents = QkanSystemInformation.getInstance().getMasterCode()
                .getData(new Integer(codeID));

        if (contents instanceof VRList) {
            ACBindUtilities.copyBindPath((VRList) contents, "CONTENT_KEY",
                    newContentsID);
            return (VRList) contents;
        }
        return new VRArrayList();
    }

    /**
     * 番号予約関数です。
     * <p>
     * データ登録に使用する番号を取得し、登録データ数分番号を更新します。 <br/>
     * ※サービスや請求など一度に多くのデータを登録する場合に番号の予約として使用します。
     * </p>
     * <p>
     * 失敗した場合、-1(0未満) もしくは例外が返ります。
     * </p>
     * 
     * @param dbm DBManager
     * @param table 番号管理テーブル名
     * @param field 番号フィールド名
     * @param count 確保件数
     * @return 使用可能な開始番号
     * @throws Exception 処理例外
     */
    public static int getBookingNumber(ACDBManager dbm, String table,
            String field, int count) throws Exception {
        StringBuilder sb;

        sb = new StringBuilder();
        sb.append("UPDATE");
        sb.append(" M_NO_CONTROL");
        sb.append(" SET");
        sb.append(" CONTROL_NO = (");
        sb.append(" SELECT");
        sb.append(" MAX(CONTROL_NO) + " + count);
        sb.append(" FROM");
        sb.append(" M_NO_CONTROL");
        sb.append(" WHERE");
        sb.append(" (TABLE_NAME = '" + table + "')");
        sb.append(" AND(FIELD_NAME = '" + field + "')");
        sb.append(" )");
        sb.append(" WHERE");
        sb.append(" (TABLE_NAME = '" + table + "')");
        sb.append(" AND(FIELD_NAME = '" + field + "')");

        if (dbm == null) {
            return -1;
        }

        int maxNo = 0;
        dbm.executeUpdate(sb.toString());

        sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" CONTROL_NO");
        sb.append(" FROM");
        sb.append(" M_NO_CONTROL");
        sb.append(" WHERE");
        sb.append(" (TABLE_NAME = '" + table + "')");
        sb.append(" AND(FIELD_NAME = '" + field + "')");
        VRList nos = dbm.executeQuery(sb.toString());
        if (nos.getDataSize() > 0) {
            maxNo = Integer.parseInt(String.valueOf(VRBindPathParser.get(
                    "CONTROL_NO", (VRMap) nos.getData())));
        }

        int beginNo = maxNo - count;
        if (beginNo < 0) {
            return -1;
        }
        return beginNo;
    }

    /**
     * 請求詳細情報取得関数です。
     * <p>
     * 帳票出力時に、請求テーブルの詳細情報を取得します。指定請求年月日における全利用者の請求情報を取得します。
     * </p>
     * <p>
     * 検索キーは請求日(CLAIM_DATE)です。
     * </p>
     * <p>
     * 返り値 <br />
     * <code>List{ <br />
     * Map(請求親情報・詳細情報) <br />
     * key:フィールド名・詳細種類 <br />
     * val:値 <br />
     * }</code><br />
     * ASC 利用者ID
     * </p>
     * <p>
     * 分割管理テーブルを更新する可能性があるため、トランザクションの中で実行してください。
     * </p>
     * 
     * @param dbm DBManager
     * @param claimDate 請求年月日
     * @return 請求詳細情(利用者ID順)
     * @throws Exception 処理例外
     */
    public static VRList getClaimDetail(ACDBManager dbm, Date claimDate)
            throws Exception {
        return getClaimDetail(dbm, claimDate, -1);
    }

    /**
     * 請求詳細情報取得関数です。
     * <p>
     * 帳票出力時に、請求テーブルの詳細情報を取得します。
     * </p>
     * <p>
     * 検索キーは請求日(CLAIM_DATE)です。
     * </p>
     * <p>
     * 返り値 <br />
     * <code>List{ <br />
     * Map(請求親情報・詳細情報) <br />
     * key:フィールド名・詳細種類 <br />
     * val:値 <br />
     * }</code><br />
     * ASC 利用者ID
     * </p>
     * <p>
     * 分割管理テーブルを更新する可能性があるため、トランザクションの中で実行してください。
     * </p>
     * 
     * @param dbm DBManager
     * @param claimDate 請求年月日
     * @param patientID 利用者ID
     * @return 請求詳細情(利用者ID順)
     * @throws Exception 処理例外
     */
    public static VRList getClaimDetail(ACDBManager dbm, Date claimDate,
            int patientID) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(" AND(CLAIM.CLAIM_DATE = '"
                + VRDateParser.format(claimDate, "yyyy/MM/dd") + "')");
        if (patientID >= 0) {
            // 利用者IDを指定しているならば特定の利用者のみ。未指定ならば全利用者を対象とする。
            sb.append(" AND(CLAIM.PATIENT_ID = " + patientID + ")");
        }
        return getClaimDetailCustom(dbm, claimDate, sb.toString());

    }

    /**
     * 請求詳細情報取得関数です。
     * <p>
     * 帳票出力時に、請求テーブルの詳細情報を取得します。
     * </p>
     * <p>
     * 返り値 <br />
     * <code>List{ <br />
     * Map(請求親情報・詳細情報) <br />
     * key:フィールド名・詳細種類 <br />
     * val:値 <br />
     * }</code><br />
     * ASC 利用者ID
     * </p>
     * <p>
     * 分割管理テーブルを更新する可能性があるため、トランザクションの中で実行してください。
     * </p>
     * 
     * @param dbm DBManager
     * @param claimDate 請求年月日
     * @param where 親情報のwhere句
     * @throws Exception 処理例外
     */
    public static VRList getClaimDetailCustom(ACDBManager dbm, Date claimDate,
            String where) throws Exception {

        if (dbm == null) {
            return new VRArrayList();
        }
        where = appendFrontWhere(where);

        // テーブル分割後の修飾語を取得
        int modify = getSeparateTableManager().getTableModifyFromDate(dbm,
                "CLAIM_DETAIL", claimDate);
        if (modify < 0) {
            return new VRArrayList();
        }
        // 作成したテーブル名は「元のテーブル名_年度」となる
        String tableSaffix = "_" + modify;
        StringBuilder sb;

        TreeMap result = new TreeMap();
        final String[] shareFields = new String[] { "CLAIM_ID",
                "CLAIM_STYLE_TYPE", "CATEGORY_NO", "PATIENT_ID", "INSURED_ID",
                "TARGET_DATE", "CLAIM_DATE", "INSURER_ID", "PROVIDER_ID",
                "CLAIM_FINISH_FLAG", "LAST_TIME", };
        // 文字列型、数値型、日付型
        String[] tableNames = new String[] { "CLAIM_DETAIL_TEXT",
                "CLAIM_DETAIL_INTEGER", "CLAIM_DETAIL_DATE" };
        // SQL文の共通部分を構築
        sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" CLAIM.CLAIM_ID,");
        sb.append(" CLAIM.CLAIM_STYLE_TYPE,");
        sb.append(" CLAIM.CATEGORY_NO,");
        sb.append(" CLAIM.PATIENT_ID,");
        sb.append(" CLAIM.INSURED_ID,");
        sb.append(" CLAIM.TARGET_DATE,");
        sb.append(" CLAIM.CLAIM_DATE,");
        sb.append(" CLAIM.INSURER_ID,");
        sb.append(" CLAIM.PROVIDER_ID,");
        sb.append(" CLAIM.CLAIM_FINISH_FLAG,");
        sb.append(" CLAIM.LAST_TIME,");
        String header = sb.toString();
        int end = tableNames.length;
        for (int i = 0; i < end; i++) {
            String tableName = tableNames[i] + tableSaffix;
            sb = new StringBuilder(header);
            sb.append(" " + tableName + ".SYSTEM_BIND_PATH,");
            sb.append(" " + tableName + ".DETAIL_VALUE");
            sb.append(" FROM");
            sb.append(" CLAIM");
            sb.append(" LEFT JOIN ");
            sb.append(tableName);
            sb.append(" ON");
            sb.append(" (CLAIM.CLAIM_ID = " + tableName + ".CLAIM_ID)");
            // sb.append("," + tableName);
            // sb.append(" WHERE");
            // sb.append(" (CLAIM.CLAIM_ID = " + tableName + ".CLAIM_ID)");
            sb.append(where);

            // 共通部分の合致するレコードをマージ
            restractureDetail(result, dbm.executeQuery(sb.toString()),
                    "CLAIM_ID", shareFields);
        }
        return new VRArrayList(result.values());

    }

    /**
     * コードマスタ内名称取得関数です。
     * <p>
     * システム共通領域のコードマスタから指定コードID、コンテンツIDに対応した内容(CONTENT)を返します。
     * </p>
     * <p>
     * 該当しなければ空文字""を返します。
     * </p>
     * 
     * @param codeID コードID
     * @param contentID コンテンツID
     * @return 内容
     * @throws Exception 処理例外
     */
    public static String getContentFromMasterCode(int codeID, int contentID)
            throws Exception {
        Object contents = QkanSystemInformation.getInstance().getMasterCode()
                .getData(new Integer(codeID));
        if (contents instanceof ArrayList) {
            String contentIDText = String.valueOf(contentID);
            Iterator it = ((ArrayList) contents).iterator();
            while (it.hasNext()) {
                VRMap row = (VRMap) it.next();
                if (contentIDText.equals(String.valueOf(VRBindPathParser.get(
                        "CONTENT_KEY", row)))) {
                    return String.valueOf(VRBindPathParser.get("CONTENT", row));
                }
            }
        }
        return "";

    }

    /**
     * コードマスタ内ID取得関数です。
     * <p>
     * システム共通領域のコードマスタから指定コードID、内容(CONTENT)に対応したコンテンツIDを返します。
     * </p>
     * <p>
     * 該当しなければ-1を返します。
     * </p>
     * 
     * @param codeID コードID
     * @param content 内容
     * @return コンテンツID
     * @throws Exception 処理例外
     */
    public static int getContentIDFromMasterCode(int codeID, String content)
            throws Exception {
        Object contents = QkanSystemInformation.getInstance().getMasterCode()
                .getData(new Integer(codeID));
        if (contents instanceof ArrayList) {
            Iterator it = ((ArrayList) contents).iterator();
            while (it.hasNext()) {
                VRMap row = (VRMap) it.next();
                if (content.equals(String.valueOf(VRBindPathParser.get(
                        "CONTENT", row)))) {
                    return Integer.parseInt(String.valueOf(VRBindPathParser
                            .get("CONTENT_KEY", row)));
                }
            }
        }
        return -1;

    }

    /**
     * 保険者基本情報取得関数です。
     * <p>
     * 保険者基本情報を取得します。
     * </p>
     * <p>
     * 返り値 <br />
     * <code>List{ <br />
     * Map(保険者情報) <br />
     * key:フィールド名 <br />
     * val:値 <br />
     * }</code><br />
     * ASC 保険者番号
     * </p>
     * 
     * @param dbm DBManager
     * @return 保険者情報(保険者番号順)
     * @throws Exception 処理例外
     */
    public static VRList getInsurerInfo(ACDBManager dbm) throws Exception {
        return getInsurerInfo(dbm, null);
    }

    /**
     * 保険者基本情報取得関数です。
     * <p>
     * modeに応じた保険者基本情報を取得します。
     * </p>
     * <p>
     * modeの値は以下のいずれかを取ります。<br/>
     * <br/>
     * <br/>
     * <br/>
     * </p>
     * <p>
     * 返り値 <br />
     * <code>List{ <br />
     * Map(保険者情報) <br />
     * key:フィールド名 <br />
     * val:値 <br />
     * }</code><br />
     * ASC 保険者番号
     * </p>
     * 
     * @param dbm DBManager
     * @param mode 検索対象
     * @return 保険者情報(保険者番号順)
     * @throws Exception 処理例外
     */
    public static VRList getInsurerInfo(ACDBManager dbm, int mode)
            throws Exception {
        switch (mode) {
        case INSURER_FIND_CARE_ONLY:
            return getInsurerInfoCareOnly(dbm);
        case INSURER_FIND_MEDICAL_ONLY:
            return getInsurerInfoMedicalOnly(dbm);
        }
        return getInsurerInfo(dbm);
    }

    /**
     * 保険者基本情報取得関数です。
     * <p>
     * 保険者基本情報を取得します。
     * </p>
     * <p>
     * 返り値 <br />
     * <code>List{ <br />
     * Map(保険者情報) <br />
     * key:フィールド名 <br />
     * val:値 <br />
     * }</code><br />
     * ASC 保険者番号
     * </p>
     * 
     * @param dbm DBManager
     * @param insurerID 保険者番号
     * @return 保険者情報(保険者番号順)
     * @throws Exception 処理例外
     */
    public static VRList getInsurerInfo(ACDBManager dbm, String insurerID)
            throws Exception {
        return getInsurerInfo(dbm, insurerID, "");
    }

    /**
     * 保険者基本情報取得関数です。
     * <p>
     * 保険者基本情報を取得します。
     * </p>
     * <p>
     * 返り値 <br />
     * <code>List{ <br />
     * Map(保険者情報) <br />
     * key:フィールド名 <br />
     * val:値 <br />
     * }</code><br />
     * ASC 保険者番号
     * </p>
     * 
     * @param dbm DBManager
     * @param insurerID 保険者番号
     * @param where 追加の検索条件
     * @return 保険者情報(保険者番号順)
     * @throws Exception 処理例外
     */
    public static VRList getInsurerInfo(ACDBManager dbm, String insurerID,
            String where) throws Exception {
        StringBuilder sb;

        sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" INSURER.INSURER_ID,");
        // del sta shin fujihara 2005.12.7
        // INSURER.INSURER_KANAは存在しないため、結果セットから削除
        // sb.append(" INSURER.INSURER_KANA,");
        // del end shin fujihara 2005.12.7
        sb.append(" INSURER.INSURER_NAME,");
        sb.append(" INSURER.INSURER_TYPE,");
        sb.append(" INSURER.INSURER_ZIP_FIRST,");
        sb.append(" INSURER.INSURER_ZIP_SECOND,");
        sb.append(" INSURER.INSURER_ADDRESS,");
        sb.append(" INSURER.INSURER_TEL_FIRST,");
        sb.append(" INSURER.INSURER_TEL_SECOND,");
        sb.append(" INSURER.INSURER_TEL_THIRD,");
        sb.append(" INSURER.LAST_TIME");
        sb.append(" FROM");
        sb.append(" INSURER");
        // edit sta shin fujihara 2005.12.7
        // null のときではなく、!nullのとき、whereを付加する。
        // if (NCCommon.getInstance().isNullText(insurerID)) {
        sb.append(" WHERE");
        if (!ACTextUtilities.isNullText(insurerID)) {
            // edit end shin fujihara 2005.12.7
            sb.append(" (INSURER.INSURER_ID = '" + insurerID + "')");
        } else {
            sb.append(" (INSURER.DELETE_FLAG = 0)");
        }
        if ((where != null) && (!"".equals(where))) {
            // 追加の検索条件
            sb.append(where);
        }
        sb.append(" ORDER BY");
        sb.append(" INSURER.INSURER_ID ASC");

        if (dbm == null) {
            return new VRArrayList();
        }
        return dbm.executeQuery(sb.toString());
    }

    /**
     * 保険者基本情報取得関数です。
     * <p>
     * 介護保険もしくは指定なしの保険者基本情報を取得します。
     * </p>
     * <p>
     * 返り値 <br />
     * <code>List{ <br />
     * Map(保険者情報) <br />
     * key:フィールド名 <br />
     * val:値 <br />
     * }</code><br />
     * ASC 保険者番号
     * </p>
     * 
     * @param dbm DBManager
     * @param insurerID 保険者番号
     * @return 保険者情報(保険者番号順)
     * @throws Exception 処理例外
     */
    public static VRList getInsurerInfoCareOnly(ACDBManager dbm)
            throws Exception {
        return getInsurerInfo(dbm, null,
                " AND((INSURER.INSURER_TYPE IS NULL)OR(INSURER.INSURER_TYPE IN(0,1)))");
    }

    // /**
    // * 利用者要介護情報取得関数です。
    // * <p>
    // * すべての利用者の要介護情報を取得します。
    // * </p>
    // * <p>
    // * 利用者の基本情報は取得しません。
    // * </p>
    // * <p>
    // * ※同月内に要介護情報が2つ以上存在する場合、月末に近く最も大きく履歴番号が新しいものを取得します。
    // * </p>
    // * <p>
    // * 返り値 <br />
    // * <code>List{ <br />
    // * Map(利用者要介護情報) <br />
    // * key:フィールド名 <br />
    // * val:値 <br />
    // * }</code><br />
    // * ASC 利用者ID
    // * </p>
    // *
    // * @param dbm DBManager
    // * @param targetMonth 対象年月
    // * @param patientID 利用者番号
    // * @return 検索結果
    // * @throws Exception 処理例外
    // */
    // public static VRList getPatientInsureInfoOnEndOfMonth(ACDBManager dbm,
    // Date targetMonth) throws Exception {
    // // 同一期間内で開始日の一番大きいもの
    // return getPatientInsureInfoImpl(
    // dbm,
    // targetMonth,
    // -1,
    // " AND(PATIENT_NINTEI_HISTORY.INSURE_VALID_START = (SELECT
    // MAX(PATIENT_NINTEI_HISTORY.INSURE_VALID_START)",
    // "))");
    // }

    /**
     * 保険者基本情報取得関数です。
     * <p>
     * 医療保険もしくは指定なしの保険者基本情報を取得します。
     * </p>
     * <p>
     * 返り値 <br />
     * <code>List{ <br />
     * Map(保険者情報) <br />
     * key:フィールド名 <br />
     * val:値 <br />
     * }</code><br />
     * ASC 保険者番号
     * </p>
     * 
     * @param dbm DBManager
     * @param insurerID 保険者番号
     * @return 保険者情報(保険者番号順)
     * @throws Exception 処理例外
     */
    public static VRList getInsurerInfoMedicalOnly(ACDBManager dbm)
            throws Exception {
        return getInsurerInfo(dbm, null,
                " AND((INSURER.INSURER_TYPE IS NULL)OR(INSURER.INSURER_TYPE IN(0,2)))");
    }

    /**
     * サービスコードマスタ取得関数です。
     * <p>
     * 対象年月を渡した場合：ある期間において有効なサービスを取得します。<br/>
     * 対象年月を省略した場合：期間に関係なく全てのサービス種類を取得します。
     * </p>
     * 
     * @param dbm DBManager
     * @return サービス種類をキー、サービス定義情報集合を値にしたマップ
     * @throws Exception 処理例外
     */
    public static VRMap getMasterService(ACDBManager dbm) throws Exception {
        return getMasterService(dbm, null);
    }

    /**
     * サービスコードマスタ取得関数です。
     * <p>
     * 対象年月を渡した場合：ある期間において有効なサービスを取得します。<br/>
     * 対象年月を省略した場合：期間に関係なく全てのサービス種類を取得します。
     * </p>
     * 
     * @param dbm DBManager
     * @param targetDate 対象年月
     * @return サービス種類をキー、サービス定義情報集合を値にしたマップ
     * @throws Exception 処理例外
     */
    public static VRMap getMasterService(ACDBManager dbm, Date targetDate)
            throws Exception {
        StringBuilder sb;

        sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" M_SERVICE.SYSTEM_SERVICE_KIND_DETAIL,");
        sb.append(" M_SERVICE.SERVICE_VALID_START,");
        sb.append(" M_SERVICE.SERVICE_VALID_END,");
        sb.append(" M_SERVICE.SERVICE_CODE_KIND,");
        sb.append(" M_SERVICE.SERVICE_NAME,");
        sb.append(" M_SERVICE.SERVICE_ABBREVIATION,");
        sb.append(" M_SERVICE.SERVICE_KIND_NAME,");
        sb.append(" M_SERVICE.SERVICE_CALENDAR_ABBREVIATION,");
        sb.append(" M_SERVICE.CLAIM_STYLE_TYPE,");
        sb.append(" M_SERVICE.BUSINESS_TYPE,");
        sb.append(" M_SERVICE.CALENDAR_PASTE_FLAG,");
        sb.append(" M_SERVICE.CHANGES_CONTENT_TYPE,");
        sb.append(" M_SERVICE.CLAIM_LAYER,");
        sb.append(" M_SERVICE.SERVICE_SORT");
        sb.append(" FROM");
        sb.append(" M_SERVICE");
        sb.append(" WHERE");
        sb.append(" (M_SERVICE.SYSTEM_SERVICE_KIND_DETAIL IN(");
        sb.append(" SELECT DISTINCT");
        sb.append(" M_SERVICE.SYSTEM_SERVICE_KIND_DETAIL");
        sb.append(" FROM");
        sb.append(" M_SERVICE");
        if (targetDate != null) {
            String date = VRDateParser.format(targetDate, "yyyy/MM/dd");
            sb.append(" WHERE");
            sb.append(" (M_SERVICE.SERVICE_VALID_START<='" + date + "')");
            sb.append(" AND (M_SERVICE.SERVICE_VALID_END>='" + date + "')");
        }
        sb.append(" )");
        sb.append(" )");
        sb.append(" ORDER BY");
        sb.append(" M_SERVICE.SERVICE_SORT ASC");

        VRMap map = new VRLinkedHashMap();
        if (dbm != null) {
            VRList list = dbm.executeQuery(sb.toString());
            // SYSTEM_SERVICE_KIND_DETAILをキーにListをMapに変換
            ACBindUtilities.setMapFromArray(list, map,
                    "SYSTEM_SERVICE_KIND_DETAIL");
        }
        return map;
    }

    /**
     * 利用者基本情報取得関数です。
     * <p>
     * 全利用者の利用者の基本情報を取得します。
     * </p>
     * <p>
     * 返り値 <br />
     * <code>List{ <br />
     * Map(利用者基本情報) <br />
     * key:フィールド名 <br />
     * val:値 <br />
     * }</code><br />
     * ASC 利用者ID
     * </p>
     * 
     * @param dbm DBManager
     * @return 検索結果
     * @throws Exception 処理例外
     */
    public static VRList getPatientInfo(ACDBManager dbm) throws Exception {
        return getPatientInfo(dbm, -1);
    }

    /**
     * 利用者基本情報取得関数です。
     * <p>
     * 指定の利用者の基本情報を取得します。
     * </p>
     * <p>
     * 返り値 <br />
     * <code>List{ <br />
     * Map(利用者基本情報) <br />
     * key:フィールド名 <br />
     * val:値 <br />
     * }</code><br />
     * ASC 利用者ID
     * </p>
     * 
     * @param dbm DBManager
     * @param patientID 利用者番号
     * @return 検索結果
     * @throws Exception 処理例外
     */
    public static VRList getPatientInfo(ACDBManager dbm, int patientID)
            throws Exception {
        StringBuilder sb;

        sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" PATIENT.PATIENT_ID,");
        sb.append(" PATIENT.PATIENT_CODE,");
        sb.append(" PATIENT.PATIENT_FAMILY_NAME,");
        sb.append(" PATIENT.PATIENT_FIRST_NAME,");
        sb.append(" PATIENT.PATIENT_FAMILY_KANA,");
        sb.append(" PATIENT.PATIENT_FIRST_KANA,");
        sb.append(" PATIENT.PATIENT_SEX,");
        sb.append(" PATIENT.PATIENT_BIRTHDAY,");
        sb.append(" PATIENT.PATIENT_TEL_FIRST,");
        sb.append(" PATIENT.PATIENT_TEL_SECOND,");
        sb.append(" PATIENT.PATIENT_TEL_THIRD,");
        sb.append(" PATIENT.PATIENT_ZIP_FIRST,");
        sb.append(" PATIENT.PATIENT_ZIP_SECOND,");
        sb.append(" PATIENT.PATIENT_ADDRESS,");
        sb.append(" PATIENT.SHOW_FLAG,");
        sb.append(" PATIENT.BELONG_TYPE,");
        sb.append(" PATIENT.AREA_TYPE,");
        sb.append(" PATIENT.LAST_TIME");
        sb.append(" FROM");
        sb.append(" PATIENT");
        sb.append(" WHERE");
        if (patientID >= 0) {
            sb.append(" (PATIENT.PATIENT_ID = " + patientID + ")");
        } else {
            sb.append(" (PATIENT.DELETE_FLAG = 0)");
        }
        sb.append(" ORDER BY");
        sb.append(" PATIENT_ID ASC");

        if (dbm == null) {
            return new VRArrayList();
        }
        return dbm.executeQuery(sb.toString());
    }

    /**
     * 利用者の要介護情報履歴取得関数です。
     * <p>
     * 指定の利用者の要介護情報の履歴をすべて取得します。
     * </p>
     * <p>
     * 返り値 <br />
     * <code>List{ <br />
     * Map(利用者要介護情報) <br />
     * key:フィールド名 <br />
     * val:値 <br />
     * }</code><br />
     * ASC 有効期間開始日
     * </p>
     * 
     * @param dbm DBManager
     * @param targetMonth 対象年月
     * @param patientID 利用者番号
     * @return 検索結果
     * @throws Exception 処理例外
     */
    public static VRList getPatientInsureInfoHistory(ACDBManager dbm,
            Date targetMonth, int patientID) throws Exception {

        StringBuilder sb;

        // メインSQL文を構築
        sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" PATIENT_NINTEI_HISTORY.PATIENT_ID,");
        sb.append(" PATIENT_NINTEI_HISTORY.NINTEI_HISTORY_ID,");
        sb.append(" PATIENT_NINTEI_HISTORY.INSURER_ID,");
        sb.append(" PATIENT_NINTEI_HISTORY.INSURED_ID,");
        sb.append(" PATIENT_NINTEI_HISTORY.INSURE_RATE,");
        sb.append(" PATIENT_NINTEI_HISTORY.PLANNER,");
        sb.append(" PATIENT_NINTEI_HISTORY.PROVIDER_ID,");
        sb.append(" PATIENT_NINTEI_HISTORY.SHUBETSU_CODE,");
        sb.append(" PATIENT_NINTEI_HISTORY.CHANGE_CODE,");
        sb.append(" PATIENT_NINTEI_HISTORY.JOTAI_CODE,");
        sb.append(" PATIENT_NINTEI_HISTORY.SHINSEI_DATE,");
        sb.append(" PATIENT_NINTEI_HISTORY.NINTEI_DATE,");
        sb.append(" PATIENT_NINTEI_HISTORY.INSURE_VALID_START,");
        sb.append(" PATIENT_NINTEI_HISTORY.INSURE_VALID_END,");
// 2014/12/17 [Yoichiro Kamei] add - begin システム有効期間対応
        sb.append(" PATIENT_NINTEI_HISTORY.SYSTEM_INSURE_VALID_START,");
        sb.append(" PATIENT_NINTEI_HISTORY.SYSTEM_INSURE_VALID_END,");
// 2014/12/17 [Yoichiro Kamei] add - end
        sb.append(" PATIENT_NINTEI_HISTORY.STOP_DATE,");
        sb.append(" PATIENT_NINTEI_HISTORY.STOP_REASON,");
        sb.append(" PATIENT_NINTEI_HISTORY.REPORTED_DATE,");
        sb.append(" PATIENT_NINTEI_HISTORY.LIMIT_RATE,");
        sb.append(" PATIENT_NINTEI_HISTORY.EXTERNAL_USE_LIMIT,");
// 2015/4/15 [H27.04改正対応][Yoichiro Kamei] add - begin 短期入所日数の初期値対応
        sb.append(" PATIENT_NINTEI_HISTORY.SHORTSTAY_USE_INIT_COUNT,");
// 2015/4/15 [H27.04改正対応][Yoichiro Kamei] add - end
        sb.append(" PATIENT_NINTEI_HISTORY.LAST_TIME");
        sb.append(" FROM");
        sb.append(" PATIENT_NINTEI_HISTORY");
        sb.append(" WHERE");
        sb.append(createWhereStatementOfNinteiHistory(targetMonth));
        sb.append(" AND(PATIENT_NINTEI_HISTORY.PATIENT_ID = " + patientID + ")");
        sb.append(" ORDER BY");
// 2014/12/17 [Yoichiro Kamei] mod - begin システム有効期間対応
//        sb.append(" PATIENT_NINTEI_HISTORY.INSURE_VALID_START ASC");
        sb.append(" PATIENT_NINTEI_HISTORY.SYSTEM_INSURE_VALID_START ASC");
// 2014/12/17 [Yoichiro Kamei] mod - end

        if (dbm == null) {
            return new VRArrayList();
        }

        //2014/01/24 [Shinobu Hitaka] edit - begin 【2014.4 区分支給限度額改定対応】
        //利用者毎の限度額を、対象年月の厚生労働省規定の区分支給限度額に差し替える
        //del - begin
        //return filterNotCorrespond(dbm.executeQuery(sb.toString()));
        //del - end
        VRList list = dbm.executeQuery(sb.toString());
        for (int j = 0; j < list.size(); j++) {
            VRMap record = (VRMap) list.get(j);
            int limitRate = -1;
            
            // 厚生労働省規定の区分支給限度額を取得する。
            limitRate = getOfficialLimitRate(dbm, targetMonth, new Integer(1), record.getData("JOTAI_CODE").toString());
            if (limitRate > 0) {
                record.setData("LIMIT_RATE", limitRate);
            }
            // 厚生労働省規定の外部利用型給付上限単位数を取得する。
            limitRate = getOfficialLimitRate(dbm, targetMonth, new Integer(2), record.getData("JOTAI_CODE").toString());
            if (limitRate > 0) {
                record.setData("EXTERNAL_USE_LIMIT", limitRate);
            }
        }
        return filterNotCorrespond(list);
        //2014/01/24 [Shinobu Hitaka] edit - end 【2014.4 区分支給限度額改定対応】

    }

    /**
     * 利用者要介護情報取得関数です。
     * <p>
     * 指定の利用者の要介護情報を取得します。
     * </p>
     * <p>
     * 利用者の基本情報は取得しません。
     * </p>
     * <p>
     * ※同月内に要介護情報が2つ以上存在する場合、月末に近く最も大きく履歴番号が新しいものを取得します。
     * </p>
     * <p>
     * 返り値 <br />
     * <code>List{ <br />
     * Map(利用者要介護情報) <br />
     * key:フィールド名 <br />
     * val:値 <br />
     * }</code><br />
     * ASC 利用者ID
     * </p>
     * 
     * @param dbm DBManager
     * @param targetMonth 対象年月
     * @param patientID 利用者番号
     * @return 検索結果
     * @throws Exception 処理例外
     */
    public static VRList getPatientInsureInfoOnEndOfMonth(ACDBManager dbm,
            Date targetMonth, int patientID) throws Exception {
        // 同一期間内で開始日の一番大きいもの
        // return getPatientInsureInfoImpl(
        // dbm,
        // targetMonth,
        // patientID,
        // " AND(PATIENT_NINTEI_HISTORY.INSURE_VALID_START = (SELECT
        // MAX(PATIENT_NINTEI_HISTORY.INSURE_VALID_START)",
        // "))");

        if (dbm == null) {
            return new VRArrayList();
        }

        StringBuilder sb;

        // メインSQL文を構築
        sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" PATIENT_NINTEI_HISTORY.PATIENT_ID,");
        sb.append(" PATIENT_NINTEI_HISTORY.NINTEI_HISTORY_ID,");
        sb.append(" PATIENT_NINTEI_HISTORY.INSURER_ID,");
        sb.append(" PATIENT_NINTEI_HISTORY.INSURED_ID,");
        sb.append(" PATIENT_NINTEI_HISTORY.INSURE_RATE,");
        sb.append(" PATIENT_NINTEI_HISTORY.PLANNER,");
        sb.append(" PATIENT_NINTEI_HISTORY.PROVIDER_ID,");
        sb.append(" PATIENT_NINTEI_HISTORY.SHUBETSU_CODE,");
        sb.append(" PATIENT_NINTEI_HISTORY.CHANGE_CODE,");
        sb.append(" PATIENT_NINTEI_HISTORY.JOTAI_CODE,");
        sb.append(" PATIENT_NINTEI_HISTORY.SHINSEI_DATE,");
        sb.append(" PATIENT_NINTEI_HISTORY.NINTEI_DATE,");
        sb.append(" PATIENT_NINTEI_HISTORY.INSURE_VALID_START,");
        sb.append(" PATIENT_NINTEI_HISTORY.INSURE_VALID_END,");
        sb.append(" PATIENT_NINTEI_HISTORY.STOP_DATE,");
        sb.append(" PATIENT_NINTEI_HISTORY.STOP_REASON,");
        sb.append(" PATIENT_NINTEI_HISTORY.REPORTED_DATE,");
        sb.append(" PATIENT_NINTEI_HISTORY.LIMIT_RATE,");
        sb.append(" PATIENT_NINTEI_HISTORY.EXTERNAL_USE_LIMIT,");
        sb.append(" PATIENT_NINTEI_HISTORY.LAST_TIME");
        sb.append(" FROM");
        sb.append(" PATIENT_NINTEI_HISTORY");
        sb.append(" WHERE");
        sb.append(createWhereStatementOfNinteiHistory(targetMonth));
        sb.append(" AND(PATIENT_NINTEI_HISTORY.PATIENT_ID = " + patientID + ")");
        sb.append(" ORDER BY");
// 2014/12/17 [Yoichiro Kamei] mod - begin システム有効期間対応
//        sb.append(" PATIENT_NINTEI_HISTORY.INSURE_VALID_START DESC");
        sb.append(" PATIENT_NINTEI_HISTORY.SYSTEM_INSURE_VALID_START DESC");
// 2014/12/17 [Yoichiro Kamei] mod - end

        //2014/01/24 [Shinobu Hitaka] edit - begin 【2014.4 区分支給限度額改定対応】
        //利用者毎の限度額を、対象年月の厚生労働省規定の区分支給限度額に差し替える
        //del - begin
        //return filterNotCorrespond(dbm.executeQuery(sb.toString()));
        //del - end
        VRList list = dbm.executeQuery(sb.toString());
        for (int j = 0; j < list.size(); j++) {
            VRMap record = (VRMap) list.get(j);
            int limitRate = -1;
            
            // 厚生労働省規定の区分支給限度額を取得する。
            limitRate = getOfficialLimitRate(dbm, targetMonth, new Integer(1), record.getData("JOTAI_CODE").toString());
            if (limitRate > 0) {
                record.setData("LIMIT_RATE", limitRate);
            }
            // 厚生労働省規定の外部利用型給付上限単位数を取得する。
            limitRate = getOfficialLimitRate(dbm, targetMonth, new Integer(2), record.getData("JOTAI_CODE").toString());
            if (limitRate > 0) {
                record.setData("EXTERNAL_USE_LIMIT", limitRate);
            }
        }
        return filterNotCorrespond(list);
        //2014/01/24 [Shinobu Hitaka] edit - end 【2014.4 区分支給限度額改定対応】
    }

    /**
     * 要介護認定情報取得関数です。
     * <p>
     * 指定の要介護認定履歴から最も支給限度額の大きい介護認定情報を返します。
     * </p>
     * <p>
     * 要介護認定履歴(history) <br />
     * <code>List{ <br />
     * Map(利用者要介護情報) <br />
     * key:フィールド名 <br />
     * val:値 <br />
     * }</code>
     * </p>
     * <p>
     * 該当しない場合、nullを返します。
     * </p>
     * 
     * @param history 要介護認定履歴
     * @return 要介護認定情報
     * @throws Exception 処理例外
     */
    public static VRMap getPatientInsureInfoOnMostHeavy(VRList history)
            throws Exception {
        int maxVal = 0;
        VRMap maxRow = null;
        Iterator it = history.iterator();
        while (it.hasNext()) {
            VRMap row = (VRMap) it.next();
            Object obj = VRBindPathParser.get("LIMIT_RATE", row);
            if (obj instanceof Integer) {
                int val = ((Integer) obj).intValue();
                if (val > maxVal) {
                    // 支給限度額の最大値を更新
                    maxRow = row;
                    maxVal = val;
                }
            }
        }
        return maxRow;
    }

    /**
     * 要介護認定情報取得関数です。
     * <p>
     * 指定の要介護認定履歴から指定日の要介護認定情報を返します。
     * </p>
     * <p>
     * 要介護認定履歴(history) <br />
     * <code>List{ <br />
     * Map(利用者要介護情報) <br />
     * key:フィールド名 <br />
     * val:値 <br />
     * }</code>
     * </p>
     * <p>
     * 該当しない場合、nullを返します。
     * </p>
     * 
     * @param history 要介護認定履歴
     * @param targetDay 対象年月日
     * @return 要介護認定情報
     * @throws Exception 処理例外
     */
    public static VRMap getPatientInsureInfoOnTargetDay(VRList history,
            Date targetDay) throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.setTime(targetDay);
        int targetDate = cal.get(Calendar.YEAR) * 1000
                + cal.get(Calendar.DAY_OF_YEAR);

        Iterator it = history.iterator();
        while (it.hasNext()) {
            VRMap row = (VRMap) it.next();
// 2014/12/17 [Yoichiro Kamei] mod - begin システム有効期間対応
//            Object obj = VRBindPathParser.get("INSURE_VALID_START", row);
            Object obj = VRBindPathParser.get("SYSTEM_INSURE_VALID_START", row);
// 2014/12/17 [Yoichiro Kamei] mod - end
            if (obj instanceof Date) {
                Calendar cmp = Calendar.getInstance();
                cmp.setTime((Date) obj);
                int beginDate = cmp.get(Calendar.YEAR) * 1000
                        + cmp.get(Calendar.DAY_OF_YEAR);
                if (targetDate >= beginDate) {
                    // 開始日以後
// 2014/12/17 [Yoichiro Kamei] mod - begin システム有効期間対応
//                    obj = VRBindPathParser.get("INSURE_VALID_END", row);
                    obj = VRBindPathParser.get("SYSTEM_INSURE_VALID_END", row);
// 2014/12/17 [Yoichiro Kamei] mod - end
                    if (obj instanceof Date) {
                        cmp.setTime((Date) obj);
                        int endDate = cmp.get(Calendar.YEAR) * 1000
                                + cmp.get(Calendar.DAY_OF_YEAR);
                        if (targetDate <= endDate) {
                            // 終了日以前
                            return row;
                        }
                    }
                }
            }
        }

        return null;
    }

    // /**
    // * 事業所情報取得関数です。
    // * <p>
    // * 事業所サービス情報から事業所の提供しているサービス情報を取得する。 <br />
    // * <code>例：予定入力画面の「サービスの選択」リストにサービスをセット<br />
    // * ※居宅介護支援事業所の場合、施設系サービス以外を全て取得する。<br />
    // * ※主として提供事業者でログインした場合に使う。</code>
    // * </p>
    // * <p>
    // * 返り値 <br />
    // * <code>List{ <br />
    // * Map(サービス情報) <br />
    // * key:フィールド名 <br />
    // * val:値 <br />
    // * }</code><br />
    // * ASC サービス種類
    // * </p>
    // *
    // * @param dbm DBManager
    // * @return 事業所情報(サービス種類)
    // * @throws Exception 処理例外
    // */
    // public static VRList getProviderServiceType(ACDBManager dbm)
    // throws Exception {
    //
    // return getProviderServiceType(dbm, QkanSystemInformation.getInstance()
    // .getLoginProviderID());
    // }

    /**
     * 事業所情報取得関数です。
     * <p>
     * 事業所情報編集時、選択事業所情報を取得します。
     * </p>
     * <p>
     * 返り値 <br />
     * <code>List{ <br />
     * Map(事業所情報) <br />
     * key:フィールド名 <br />
     * val:値 <br />
     * }</code><br />
     * ASC 事業所番号
     * </p>
     * 
     * @param dbm DBManager
     * @return 事業所情報(事業所番号順)
     * @throws Exception 処理例外
     */
    public static VRList getProviderInfo(ACDBManager dbm) throws Exception {
        return getProviderInfoImpl(dbm, " WHERE (PROVIDER.DELETE_FLAG = 0)");
    }

    /**
     * 事業所情報取得関数です。
     * <p>
     * 指定したサービスを提供している事業所の情報を取得します。 <br />
     * <code>例：居宅介護支援事業所のみをコンボにセット</code>
     * </p>
     * <p>
     * 返り値 <br />
     * <code>List{ <br />
     * Map(事業所情報) <br />
     * key:フィールド名 <br />
     * val:値 <br />
     * }</code><br />
     * ASC 事業所番号
     * </p>
     * 
     * @param dbm DBManager
     * @param serviceKind 独自サービス種類コード
     * @return 事業所情報(事業所番号順)
     * @throws Exception 処理例外
     */
    public static VRList getProviderInfo(ACDBManager dbm, int serviceKind)
            throws Exception {
        return getProviderInfo(dbm, new int[] { serviceKind });
    }

    /**
     * 事業所情報取得関数です。
     * <p>
     * 指定したサービスを提供している事業所の情報を取得します。 <br />
     * <code>例：居宅介護支援事業所のみをコンボにセット</code>
     * </p>
     * <p>
     * 返り値 <br />
     * <code>List{ <br />
     * Map(事業所情報) <br />
     * key:フィールド名 <br />
     * val:値 <br />
     * }</code><br />
     * ASC 事業所番号
     * </p>
     * 
     * @param dbm DBManager
     * @param serviceKind 独自サービス種類コード
     * @return 事業所情報(事業所番号順)
     * @throws Exception 処理例外
     */
    public static VRList getProviderInfo(ACDBManager dbm, int[] serviceKind)
            throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(" ,PROVIDER_SERVICE");
        sb.append(" WHERE");
        sb.append(" (PROVIDER.PROVIDER_ID = PROVIDER_SERVICE.PROVIDER_ID)");
        if (serviceKind != null) {
            int end = serviceKind.length;
            if (end > 0) {
                sb.append(" AND(PROVIDER_SERVICE.SYSTEM_SERVICE_KIND_DETAIL IN(");
                sb.append(serviceKind[0]);
                for (int i = 1; i < end; i++) {
                    sb.append(",");
                    sb.append(serviceKind[i]);
                }
                sb.append("))");
            }
        }
        sb.append(" AND(PROVIDER.DELETE_FLAG = 0)");
        return getProviderInfoImpl(dbm, sb.toString());

    }

    /**
     * 事業所情報取得関数です。
     * <p>
     * 指定したサービスを提供している事業所の情報を取得します。 <br />
     * <code>例：居宅介護支援事業所のサービス予定画面の事業所コンボにセット</code>
     * </p>
     * <p>
     * 返り値 <br />
     * <code>List{ <br />
     * Map(事業所情報) <br />
     * key:フィールド名 <br />
     * val:値 <br />
     * }</code><br />
     * ASC 事業所番号
     * </p>
     * 
     * @param dbm DBManager
     * @param serviceKind 独自サービス種類コード集合
     * @return 事業所情報(事業所番号順)
     * @throws Exception 処理例外
     */
    public static VRList getProviderInfo(ACDBManager dbm, List serviceKinds)
            throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(" ,PROVIDER_SERVICE");
        sb.append(" WHERE");
        sb.append(" (PROVIDER.PROVIDER_ID = PROVIDER_SERVICE.PROVIDER_ID)");
        int last = serviceKinds.size() - 1;
        if (last >= 0) {
            sb.append(" AND(PROVIDER_SERVICE.SYSTEM_SERVICE_KIND_DETAIL IN(");
            for (int i = 0; i < last; i++) {
                sb.append(String.valueOf(serviceKinds.get(i)) + ",");
            }
            sb.append(String.valueOf(serviceKinds.get(last)) + "))");
        }
        sb.append(" AND(PROVIDER.DELETE_FLAG = 0)");
        return getProviderInfoImpl(dbm, sb.toString());
    }

    /**
     * 事業所情報取得関数です。
     * <p>
     * 事業所情報編集時、選択事業所情報を取得します。
     * </p>
     * <p>
     * 返り値 <br />
     * <code>List{ <br />
     * Map(事業所情報) <br />
     * key:フィールド名 <br />
     * val:値 <br />
     * }</code><br />
     * ASC 事業所番号
     * </p>
     * 
     * @param dbm DBManager
     * @param providerID 事業所番号
     * @return 事業所情報(事業所番号順)
     * @throws Exception 処理例外
     */
    public static VRList getProviderInfo(ACDBManager dbm, String providerID)
            throws Exception {
        if (ACTextUtilities.isNullText(providerID)) {
            return getProviderInfoImpl(dbm, null);
        }
        return getProviderInfoImpl(dbm, " WHERE (PROVIDER.PROVIDER_ID = '"
                + providerID + "')");
    }

    // /**
    // * 利用者要介護情報取得関数です。
    // * <p>
    // * 指定の利用者の要介護情報を取得します。
    // * </p>
    // * <p>
    // * 利用者の基本情報は取得しません。
    // * </p>
    // * <p>
    // * ※同月内に要介護情報が2つ以上存在する場合、支給限度額が最も大きく履歴番号が新しいものを取得します。
    // * </p>
    // * <p>
    // * 返り値 <br />
    // * <code>List{ <br />
    // * Map(利用者要介護情報) <br />
    // * key:フィールド名 <br />
    // * val:値 <br />
    // * }</code><br />
    // * ASC 利用者ID
    // * </p>
    // *
    // * @param dbm DBManager
    // * @param targetMonth 対象年月
    // * @param patientID 利用者番号
    // * @param filterSubQueryBegin 絞込み条件のサブクエリのWHERE句までのSQL文
    // * @param filterSubQueryEnd 絞込み条件のサブクエリのWHERE句以降のSQL文
    // * @return 検索結果
    // * @throws Exception 処理例外
    // */
    // protected static VRList getPatientInsureInfoImpl(ACDBManager dbm,
    // Date targetMonth, int patientID, String filterSubQueryBegin,
    // String filterSubQueryEnd) throws Exception {
    // if (dbm == null) {
    // return new VRArrayList();
    // }
    //
    // StringBuilder sb;
    //
    // // FROM～要介護度以外のWHERE句まで
    // sb = new StringBuilder();
    // sb.append(" FROM");
    // sb.append(" PATIENT_NINTEI_HISTORY");
    // sb.append(" WHERE");
    //
    // // 有効期間をチェックするSQL文
    // sb.append(createWhereStatementOfNinteiHistory(targetMonth));
    //
    // if (patientID >= 0) {
    // // 利用者で絞り込む場合
    // sb.append(" AND(PATIENT_NINTEI_HISTORY.PATIENT_ID = " + patientID
    // + ")");
    // }
    // String fromWhere = sb.toString();
    //
    // // メインSQL文を構築
    // sb = new StringBuilder();
    // sb.append("SELECT");
    // sb.append(" PATIENT_NINTEI_HISTORY.PATIENT_ID,");
    // sb.append(" PATIENT_NINTEI_HISTORY.NINTEI_HISTORY_ID,");
    // sb.append(" PATIENT_NINTEI_HISTORY.INSURER_ID,");
    // sb.append(" PATIENT_NINTEI_HISTORY.INSURED_ID,");
    // sb.append(" PATIENT_NINTEI_HISTORY.INSURE_RATE,");
    // sb.append(" PATIENT_NINTEI_HISTORY.PLANNER,");
    // sb.append(" PATIENT_NINTEI_HISTORY.PROVIDER_ID,");
    // sb.append(" PATIENT_NINTEI_HISTORY.SHUBETSU_CODE,");
    // sb.append(" PATIENT_NINTEI_HISTORY.CHANGE_CODE,");
    // sb.append(" PATIENT_NINTEI_HISTORY.JOTAI_CODE,");
    // sb.append(" PATIENT_NINTEI_HISTORY.SHINSEI_DATE,");
    // sb.append(" PATIENT_NINTEI_HISTORY.NINTEI_DATE,");
    // sb.append(" PATIENT_NINTEI_HISTORY.INSURE_VALID_START,");
    // sb.append(" PATIENT_NINTEI_HISTORY.INSURE_VALID_END,");
    // sb.append(" PATIENT_NINTEI_HISTORY.STOP_DATE,");
    // sb.append(" PATIENT_NINTEI_HISTORY.STOP_REASON,");
    // sb.append(" PATIENT_NINTEI_HISTORY.REPORTED_DATE,");
    // sb.append(" PATIENT_NINTEI_HISTORY.LIMIT_RATE,");
    // sb.append(" PATIENT_NINTEI_HISTORY.EXTERNAL_USE_LIMIT");
    // sb.append(fromWhere);
    //
    // if (!ACTextUtilities.isNullText(filterSubQueryBegin)) {
    // // サブクエリによる絞込み
    // // 主に支給限度額や月末を基準にする
    // sb.append(filterSubQueryBegin);
    // sb.append(fromWhere);
    // if (filterSubQueryEnd != null) {
    // sb.append(filterSubQueryEnd);
    // }
    //
    // }
    //
    // sb.append(" ORDER BY");
    // sb.append(" PATIENT_NINTEI_HISTORY.PATIENT_ID ASC,");
    // sb.append(" PATIENT_NINTEI_HISTORY.NINTEI_HISTORY_ID DESC");
    //
    // VRList result = dbm.executeQuery(sb.toString());
    //
    // // 前回認定優先を考慮しつつ検索結果から対象月の履歴と結合された利用者情報を抽出する
    // VRList filteredResult = new VRArrayList();
    // boolean mustNextPatient = false;
    // VRMap targetRow = null;
    // Object processPatientID = null;
    // Iterator it = result.iterator();
    // while (it.hasNext()) {
    // VRMap row = (VRMap) it.next();
    // Object obj = VRBindPathParser.get("PATIENT_ID", row);
    // // 利用者番号の変化を比較
    // if (!obj.equals(processPatientID)) {
    // if (processPatientID == null) {
    // // 初回
    // processPatientID = obj;
    // } else {
    // // 次の利用者に切り替わったので既存の利用者を確定
    // filteredResult.addData(targetRow);
    // }
    // mustNextPatient = false;
    // } else if (mustNextPatient) {
    // // 適用する認定が確定済みにつき次の利用者を探す
    // continue;
    // }
    // targetRow = row;
    // // 同一利用者・期間・要介護度のうち、最初の行(最新の認定履歴)を当該優先認定履歴とする
    // mustNextPatient = true;
    //
    // }
    //
    // if (targetRow != null) {
    // // 最後に発見した利用者を確定する
    // filteredResult.addData(targetRow);
    // }
    //
    // return filteredResult;
    // }
    /**
     * 事業所情報取得関数です。
     * <p>
     * 事業所情報編集時、選択事業所情報を取得します。
     * </p>
     * <p>
     * 返り値 <br />
     * <code>List{ <br />
     * Map(事業所情報) <br />
     * key:フィールド名 <br />
     * val:値 <br />
     * }</code><br />
     * ASC 事業所番号
     * </p>
     * 
     * @param dbm DBManager
     * @param where 絞込み句
     * @return 事業所情報(事業所番号順)
     * @throws Exception 処理例外
     */
    public static VRList getProviderInfoCustom(ACDBManager dbm, String where)
            throws Exception {
        return getProviderInfoImpl(dbm, where);
    }

    /**
     * 事業所請求詳細情報取得関数です。
     * <p>
     * 事業所情報編集画面、利用票・提供票、実績集計時に、事業所の提供サービスの詳細情報を取得します。
     * </p>
     * <p>
     * 返り値 <br />
     * <code>List{ <br />
     * Map(事業請求親情報・事業請求詳細情報) <br />
     * key:フィールド名・詳細種類 <br />
     * val:値 <br />
     * }</code><br />
     * ASC サービス種類
     * </p>
     * 
     * @param dbm DBManager
     * @param providerID 事業所番号
     * @return 事業所請求詳細情報(サービス種類順)
     * @throws Exception 処理例外
     */
    public static VRList getProviderServiceDetail(ACDBManager dbm,
            String providerID) throws Exception {
        StringBuilder sb = new StringBuilder();
        // sb.append(" AND(PROVIDER_SERVICE.PROVIDER_ID = '" + providerID +
        // "')");
        sb.append(" (PROVIDER_SERVICE.PROVIDER_ID = '" + providerID + "')");
        return getProviderServiceDetailCustom(dbm, sb.toString());
    }

    /**
     * 事業所請求詳細情報取得関数です。
     * <p>
     * 事業所情報編集画面、利用票・提供票、実績集計時に、事業所の提供サービスの詳細情報を取得します。
     * </p>
     * <p>
     * 返り値 <br />
     * <code>List{ <br />
     * Map(事業請求親情報・事業請求詳細情報) <br />
     * key:フィールド名・詳細種類 <br />
     * val:値 <br />
     * }</code><br />
     * ASC サービス種類
     * </p>
     * 
     * @param dbm DBManager
     * @param providerID 事業所番号
     * @param serviceKind 独自サービス種類コード
     * @return 事業所請求詳細情報(サービス種類順)
     * @throws Exception 処理例外
     */
    public static VRList getProviderServiceDetail(ACDBManager dbm,
            String providerID, int serviceKind) throws Exception {
        StringBuilder sb = new StringBuilder();
        // sb.append(" AND(PROVIDER_SERVICE.PROVIDER_ID = '" + providerID +
        // "')");
        sb.append(" (PROVIDER_SERVICE.PROVIDER_ID = '" + providerID + "')");
        sb.append(" AND(PROVIDER_SERVICE.SYSTEM_SERVICE_KIND_DETAIL = "
                + serviceKind + ")");
        return getProviderServiceDetailCustom(dbm, sb.toString());
    }

    /**
     * 事業所請求詳細情報取得関数です。
     * <p>
     * 事業所情報編集画面、利用票・提供票、実績集計時に、事業所の提供サービスの詳細情報を取得します。
     * </p>
     * <p>
     * 返り値 <br />
     * <code>List{ <br />
     * Map(事業請求親情報・事業請求詳細情報) <br />
     * key:フィールド名・詳細種類 <br />
     * val:値 <br />
     * }</code><br />
     * ASC サービス種類
     * </p>
     * 
     * @param dbm DBManager
     * @param where 親情報のwhere句
     * @return 事業所請求詳細情報(サービス種類順)
     * @throws Exception 処理例外
     */
    public static VRArrayList getProviderServiceDetailCustom(ACDBManager dbm,
            String where) throws Exception {
        if (dbm == null) {
            return new VRArrayList();
        }

        // where = appendFrontAnd(where);
        if (ACTextUtilities.isNullText(where)) {
            where = "";
        } else {
            where = " WHERE" + where;
        }

        StringBuilder sb;

        TreeMap result = new TreeMap();
        final String[] shareFields = new String[] { "PROVIDER_ID",
                "PROVIDER_SERVICE_ID", "SYSTEM_SERVICE_KIND_DETAIL",
                "REDUCT_RATE", "LAST_TIME" };

        // 文字列型、数値型、日付型
        // 割引率は必ず存在するため、親情報はINTテーブルからのみ取得
        String[] tableNames = new String[] { "PROVIDER_SERVICE_DETAIL_INTEGER",
                "PROVIDER_SERVICE_DETAIL_TEXT", "PROVIDER_SERVICE_DETAIL_DATE" };

        // SQL文の共通部分を構築
        sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" PROVIDER_SERVICE.PROVIDER_SERVICE_ID,");
        sb.append(" PROVIDER_SERVICE.PROVIDER_ID,");
        sb.append(" PROVIDER_SERVICE.SYSTEM_SERVICE_KIND_DETAIL,");
        sb.append(" PROVIDER_SERVICE.REDUCT_RATE,");
        sb.append(" PROVIDER_SERVICE.LAST_TIME,");
        String header = sb.toString();
        int end = tableNames.length;
        for (int i = 0; i < end; i++) {
            String tableName = tableNames[i];
            sb = new StringBuilder(header);
            sb.append(" " + tableName + ".SYSTEM_BIND_PATH,");
            sb.append(" " + tableName + ".DETAIL_VALUE");
            sb.append(" FROM");
            sb.append(" PROVIDER_SERVICE");
            sb.append(" LEFT JOIN ");
            sb.append(tableName);
            sb.append(" ON");
            sb.append(" (PROVIDER_SERVICE.PROVIDER_SERVICE_ID = " + tableName
                    + ".PROVIDER_SERVICE_ID)");
            // sb.append("," + tableName);
            // sb.append(" WHERE");
            // sb.append(" (PROVIDER_SERVICE.PROVIDER_SERVICE_ID = " + tableName
            // + ".PROVIDER_SERVICE_ID)");
            sb.append(where);

            // 共通部分の合致するレコードをマージ
            restractureDetail(result, dbm.executeQuery(sb.toString()),
                    "PROVIDER_SERVICE_ID", shareFields);
        }
        return new VRArrayList(result.values());

    }

    /**
     * 事業所情報取得関数です。
     * <p>
     * 事業所サービス情報から事業所の提供しているサービス情報を取得する。 <br />
     * <code>例：予定入力画面の「サービスの選択」リストにサービスをセット<br />
     * ※居宅介護支援事業所の場合、施設系サービス以外を全て取得する。<br />
     * ※主として提供事業者でログインした場合に使う。</code>
     * </p>
     * <p>
     * 返り値 <br />
     * <code>List{ <br />
     * Map(サービス情報) <br />
     * key:フィールド名 <br />
     * val:値 <br />
     * }</code><br />
     * ASC サービス種類
     * </p>
     * 
     * @param dbm DBManager
     * @param providerID 事業所番号
     * @return 事業所情報(サービス種類)
     * @throws Exception 処理例外
     */
    public static VRList getProviderServiceType(ACDBManager dbm,
            String providerID) throws Exception {
        StringBuilder sb;

        sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" PROVIDER.PROVIDER_ID,");
        sb.append(" PROVIDER.PROVIDER_TYPE,");
        sb.append(" PROVIDER.MEDICAL_FLAG,");
        // sb.append(" PROVIDER.PROVIDER_KANA,");
        sb.append(" PROVIDER.PROVIDER_NAME,");
        sb.append(" PROVIDER.PROVIDER_ZIP_FIRST,");
        sb.append(" PROVIDER.PROVIDER_ZIP_SECOND,");
        sb.append(" PROVIDER.PROVIDER_ADDRESS,");
        sb.append(" PROVIDER.PROVIDER_TEL_FIRST,");
        sb.append(" PROVIDER.PROVIDER_TEL_SECOND,");
        sb.append(" PROVIDER.PROVIDER_TEL_THIRD,");
        sb.append(" PROVIDER.PROVIDER_FAX_FIRST,");
        sb.append(" PROVIDER.PROVIDER_FAX_SECOND,");
        sb.append(" PROVIDER.PROVIDER_FAX_THIRD,");
        sb.append(" PROVIDER.PROVIDER_JIJIGYOUSHO_TYPE,");
        sb.append(" PROVIDER.PROVIDER_JIGYOU_TYPE,");
        sb.append(" PROVIDER.PROVIDER_AREA_TYPE,");
        sb.append(" PROVIDER.SPECIAL_AREA_FLAG,");
        sb.append(" PROVIDER.SHAFUKU_GENMEN_FLAG,");
        sb.append(" PROVIDER.PROVIDER_OWNER_NAME,");
        sb.append(" PROVIDER.BANK_NAME,");
        sb.append(" PROVIDER.BANK_BRANCH_NAME,");
        sb.append(" PROVIDER.ACCOUNT_NUMBER,");
        sb.append(" PROVIDER.ACCOUNT_TYPE,");
        sb.append(" PROVIDER.ACCOUNT_HOLDER,");
        sb.append(" PROVIDER_SERVICE.PROVIDER_SERVICE_ID,");
        sb.append(" PROVIDER_SERVICE.SYSTEM_SERVICE_KIND_DETAIL,");
        sb.append(" PROVIDER_SERVICE.REDUCT_RATE");
        sb.append(" FROM");
        sb.append(" PROVIDER_SERVICE,");
        sb.append(" PROVIDER");
        sb.append(" WHERE");
        sb.append(" (PROVIDER_SERVICE.PROVIDER_ID = '" + providerID + "')");
        sb.append(" AND(PROVIDER_SERVICE.PROVIDER_ID = PROVIDER.PROVIDER_ID)");
        sb.append(" ORDER BY");
        sb.append(" SYSTEM_SERVICE_KIND_DETAIL ASC");

        if (dbm == null) {
            return new VRArrayList();
        }
        return dbm.executeQuery(sb.toString());
    }

    /**
     * サービス詳細情報取得関数です。
     * <p>
     * ログイン事業所のサービス予定・実績画面表示時に、サービスの詳細情報を取得します。
     * </p>
     * <p>
     * 返り値 <br />
     * サービスID{ <br />
     * Map(サービス親情報・詳細情報) <br />
     * key:フィールド名・詳細種類 <br />
     * val:値</code><br />
     * ASC サービスID
     * </p>
     * <p>
     * 引数「取得区分」には以下の値を指定します。 <br />
     * 101-予定(SERVICE_DETAIL_GET_PLAN) <br />
     * 102-実績(SERVICE_DETAIL_GET_RESULT)<br/>
     * 103-予定の月間部分のみ(SERVICE_DETAIL_GET_PLAN_OF_MONTHLY_ONLY)
     * </p>
     * <p>
     * 分割管理テーブルを更新する可能性があるため、トランザクションの中で実行してください。
     * </p>
     * 
     * @param dbm DBManager
     * @param patientID 利用者ID
     * @param targetMonth 対象年月
     * @param useType 取得区分
     * @return サービス詳細情報(サービスID順)
     * @throws Exception 処理例外
     */
    public static VRList getServiceDetail(ACDBManager dbm, int patientID,
            Date targetMonth, int useType) throws Exception {
        return getServiceDetail(dbm, patientID, targetMonth, useType,
                QkanSystemInformation.getInstance().getLoginProviderID());
    }

    /**
     * サービス詳細情報取得関数です。
     * <p>
     * サービス予定・実績画面表示時に、サービスの詳細情報を取得します。
     * </p>
     * <p>
     * 返り値 <br />
     * サービスID{ <br />
     * Map(サービス親情報・詳細情報) <br />
     * key:フィールド名・詳細種類 <br />
     * val:値</code><br />
     * ASC サービスID
     * </p>
     * <p>
     * 引数「取得区分」には以下の値を指定します。 <br />
     * 101-予定(SERVICE_DETAIL_GET_PLAN) <br />
     * 102-実績(SERVICE_DETAIL_GET_RESULT)<br/>
     * 103-予定の月間部分のみ(SERVICE_DETAIL_GET_PLAN_OF_MONTHLY_ONLY)
     * </p>
     * <p>
     * 分割管理テーブルを更新する可能性があるため、トランザクションの中で実行してください。
     * </p>
     * 
     * @param dbm DBManager
     * @param patientID 利用者ID
     * @param targetMonth 対象年月
     * @param useType 取得区分
     * @param providerID 事業所番号
     * @return サービス詳細情報(サービスID順)
     * @throws Exception 処理例外
     */
    public static VRList getServiceDetail(ACDBManager dbm, int patientID,
            Date targetMonth, int useType, String providerID) throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.setTime(targetMonth);
        String ym = VRDateParser.format(cal, "yyyy/MM");

        StringBuilder sb = new StringBuilder();
        // sb.append(" AND(SERVICE.LOGIN_PROVIDER_ID = '" + providerID + "')");
        sb.append(" AND(SERVICE.PATIENT_ID = " + patientID + ")");
        sb.append(" AND(SERVICE.SERVICE_DATE >= '" + ym + "/01')");
        sb.append(" AND(SERVICE.SERVICE_DATE <= '" + ym + "/"
                + cal.getActualMaximum(Calendar.DAY_OF_MONTH) + "')");

        sb.append(" AND");
        sb.append(getServiceUseTypeSQLWithoutAnd(useType));

        return getServiceDetailCustom(dbm, targetMonth, sb.toString());
    }

    /**
     * 指定のWHERE句を条件に検索したサービス詳細情報を返します。
     * <p>
     * 返り値 <br />
     * サービスID{ <br />
     * Map(サービス親情報・詳細情報) <br />
     * key:フィールド名・詳細種類 <br />
     * val:値</code><br />
     * ASC サービスID
     * </p>
     * <p>
     * 分割管理テーブルを更新する可能性があるため、トランザクションの中で実行してください。
     * </p>
     * 
     * @param dbm DBManager
     * @param where 検索条件
     * @return 検索結果
     * @throws Exception 処理例外
     */
    public static VRList getServiceDetailCustom(ACDBManager dbm,
            Date targetMonth, String where) throws Exception {
        StringBuilder sb;

        if (dbm == null) {
            return new VRArrayList();
        }
        where = appendFrontWhere(where);

        String tableSaffix;
        // テーブル分割後の修飾語を取得
        if (targetMonth == null) {
            targetMonth = ACDateUtilities.createDate(2006, 4);
        }
        int modify = getSeparateTableManager().getTableModifyFromDate(dbm,
                "SERVICE_DETAIL", targetMonth);
        // 管理テーブルの更新がありうるのでトランザクションをコミット
        if (modify < 0) {
            return new VRArrayList();
        }
        // 作成したテーブル名は「元のテーブル名_年度」となる
        tableSaffix = "_" + modify;

        TreeMap result = new TreeMap();
        // 3テーブルの値を取得し、共通部分の合致するレコードをマージ
        final String[] shareFields = new String[] {
                "SERVICE_ID",
                // "LOGIN_PROVIDER_ID",
                "SERVICE_USE_TYPE", "PATIENT_ID", "PROVIDER_ID",
                "SYSTEM_SERVICE_KIND_DETAIL", "SERVICE_DATE", "WEEK_DAY",
                "LAST_TIME",
                // "SERVICE_CODE_ITEM",
                // "EXPENSES_FLAG",
                "REGULATION_RATE" };
        // 文字列型、数値型、日付型
        String[] tableNames = new String[] { "SERVICE_DETAIL_TEXT",
                "SERVICE_DETAIL_INTEGER", "SERVICE_DETAIL_DATE" };
        // SQL文の共通部分を構築
        sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" SERVICE.SERVICE_ID,");
        // sb.append(" SERVICE.LOGIN_PROVIDER_ID,");
        sb.append(" SERVICE.SERVICE_USE_TYPE,");
        sb.append(" SERVICE.PATIENT_ID,");
        sb.append(" SERVICE.PROVIDER_ID,");
        sb.append(" SERVICE.SYSTEM_SERVICE_KIND_DETAIL,");
        sb.append(" SERVICE.SERVICE_DATE,");
        sb.append(" SERVICE.WEEK_DAY,");
        // sb.append(" SERVICE.EXPENSES_FLAG,");
        sb.append(" SERVICE.REGULATION_RATE,");
        // sb.append(" SERVICE.LAST_TIME,");
        // sb.append(" SERVICE_EXPENSES.SERVICE_CODE_ITEM,");
        // sb.append(" SERVICE_EXPENSES.EXPENSES_FLAG,");
        // sb.append(" SERVICE_EXPENSES.REGULATION_RATE,");
        String header = sb.toString();
        int end = tableNames.length;
        for (int i = 0; i < end; i++) {
            String tableName = tableNames[i] + tableSaffix;
            sb = new StringBuilder(header);
            sb.append(" " + tableName + ".SYSTEM_BIND_PATH,");
            sb.append(" " + tableName + ".DETAIL_VALUE");
            sb.append(" FROM");
            sb.append(" SERVICE");
            // sb.append(",SERVICE_EXPENSES");
            sb.append(" LEFT JOIN ");
            sb.append(tableName);
            sb.append(" ON (SERVICE.SERVICE_ID = " + tableName + ".SERVICE_ID)");
            // sb.append(" WHERE");
            // sb.append(" AND(SERVICE.SERVICE_ID =
            // SERVICE_EXPENSES.SERVICE_ID)");
            sb.append(where);
            // 共通部分の合致するレコードをマージ
            restractureDetail(result, dbm.executeQuery(sb.toString()),
                    "SERVICE_ID", shareFields);
        }

        return new VRArrayList(result.values());
    }

    /**
     * サービスパターン詳細情報取得関数です。
     * <p>
     * ログイン事業所のサービス予定・実績画面表示時に、サービスパターンの詳細情報を取得します。
     * </p>
     * <p>
     * 返り値 <br />
     * <code>List{ <br />
     * Map(サービスパターン親情報・詳細情報) <br />
     * key:フィールド名・詳細種類 <br />
     * val:値<br />
     * }</code><br />
     * ASC サービスID
     * </p>
     * <p>
     * 分割管理テーブルを更新する可能性があるため、トランザクションの中で実行してください。
     * </p>
     * 
     * @param dbm DBManager
     * @return サービスパターン詳細情報(サービスID順)
     * @throws Exception 処理例外
     */
    public static VRList getServicePatternDetail(ACDBManager dbm)
            throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(" AND(SERVICE.SERVICE_USE_TYPE = "
                + QkanConstants.SERVICE_USE_TYPE_PATTERN + ")");
        // sb.append(" AND(SERVICE.LOGIN_PROVIDER_ID = '"
        // + QkanSystemInformation.getInstance().getLoginProviderID()
        // + "')");

        return getServiceDetailCustom(dbm, null, sb.toString());
    }

    /**
     * サービスパターン詳細情報取得関数です。
     * <p>
     * ログイン事業所のサービス予定・実績画面表示時に、サービスパターンの詳細情報を取得します。
     * </p>
     * <p>
     * 返り値 <br />
     * <code>List{ <br />
     * Map(サービスパターン親情報・詳細情報) <br />
     * key:フィールド名・詳細種類 <br />
     * val:値<br />
     * }</code><br />
     * ASC サービスID
     * </p>
     * <p>
     * 分割管理テーブルを更新する可能性があるため、トランザクションの中で実行してください。
     * </p>
     * 
     * @param dbm DBManager
     * @param serviceKind 独自サービス種類コード
     * @return サービスパターン詳細情報(サービスID順)
     * @throws Exception 処理例外
     */
    public static VRList getServicePatternDetail(ACDBManager dbm,
            int serviceKind) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(" AND(SERVICE.SERVICE_USE_TYPE = "
                + QkanConstants.SERVICE_USE_TYPE_PATTERN + ")");
        // sb.append(" AND(SERVICE.LOGIN_PROVIDER_ID = '"
        // + QkanSystemInformation.getInstance().getLoginProviderID()
        // + "')");
        sb.append(" AND(SERVICE.SYSTEM_SERVICE_KIND_DETAIL = " + serviceKind
                + ")");
        return getServiceDetailCustom(dbm, null, sb.toString());
    }

    /**
     * サービスパターン詳細情報取得関数です。
     * <p>
     * サービス予定・実績画面表示時に、サービスパターンの詳細情報を取得します。
     * </p>
     * <p>
     * 返り値 <br />
     * <code>List{ <br />
     * Map(サービスパターン親情報・詳細情報) <br />
     * key:フィールド名・詳細種類 <br />
     * val:値<br />
     * }</code><br />
     * ASC サービスID
     * </p>
     * <p>
     * 分割管理テーブルを更新する可能性があるため、トランザクションの中で実行してください。
     * </p>
     * 
     * @param dbm DBManager
     * @param where 親情報に対するwhere句
     * @return サービスパターン詳細情報(サービスID順)
     * @throws Exception 処理例外
     */
    public static VRList getServicePatternDetailCustom(ACDBManager dbm,
            String where) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(" AND(SERVICE.SERVICE_USE_TYPE = "
                + QkanConstants.SERVICE_USE_TYPE_PATTERN + ")");
        sb.append(where);
        return getServiceDetailCustom(dbm, null, sb.toString());
    }

    /**
     * 指定画面項目以下の無効なラジオグループ/テキスト/チェックのバインドパスを引数のMapから除外します。
     * 
     * @param target 対象
     * @param map キーマップ
     */
    public static void removeDisabledBindPath(Component target, Map map) {
        if ((target instanceof VRRadioButtonGroup)
                || (target instanceof AbstractVRTextField)
                || (target instanceof AbstractVRCheckBox)
                || (target instanceof AbstractVRComboBox)) {
            if (!target.isEnabled()) {
                map.remove(((VRBindable) target).getBindPath());
            }
        } else if (target instanceof Container) {
            int end = ((Container) target).getComponentCount();
            for (int i = 0; i < end; i++) {
                // 再帰
                removeDisabledBindPath(((Container) target).getComponent(i),
                        map);
            }
        }

    }

    /**
     * [key=Component,value=Boolean]形式のMapから画面項目のEnabled状態を復元します。
     * 
     * @param map リストア元マップ
     */
    public static void restoreEnabled(Map map) {
        if (map != null) {
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                if (ent.getKey() instanceof Component) {
                    if (ent.getValue() instanceof Boolean) {
                        ((Component) ent.getKey()).setEnabled(((Boolean) ent
                                .getValue()).booleanValue());
                    }
                }
            }
        }
    }

    /**
     * 指定画面項目以下のラジオグループに対し、すべて最初のラジオを選択させます。
     * 
     * @param target 対象
     */
    public static void selectFirstRadioItem(Component target) {
        if (target instanceof VRRadioButtonGroup) {
            // 一つ目の項目を選択する
            if (((VRRadioButtonGroup) target).getButtonCount() > 0) {
                ((VRRadioButtonGroup) target).getButton(1).setSelected(true);
            }
        } else if (target instanceof JCheckBox) {
            ((JCheckBox) target).setSelected(false);
        } else if (target instanceof Container) {
            int end = ((Container) target).getComponentCount();
            for (int i = 0; i < end; i++) {
                // 再帰
                selectFirstRadioItem(((Container) target).getComponent(i));
            }
        }

    }

    /**
     * 一覧の検索条件となる文字列にTrim等の処理を行なって返します。
     * <p>
     * システム全体として統一の挙動をさせるために通す関数です。現時点ではそのまま返します。
     * </p>
     * 
     * @param text 変換元
     * @return 変換結果
     */
    public static String toFindString(String text) {
        return text;
    }

    /**
     * 姓名を" "で連結して返します。
     * <p>
     * 引数がすべてnullもしくは空文字の場合は空文字を返します。
     * </p>
     * 
     * @param firstName 姓
     * @param secondName 名
     * @return 連結結果
     */
    public static String toFullName(Object firstName, Object secondName) {
        if (ACTextUtilities.isNullText(firstName)) {
            if (ACTextUtilities.isNullText(secondName)) {
                return "";
            }
            return "　" + secondName;
        }
        if (ACTextUtilities.isNullText(secondName)) {
            return firstName + "　";
        }
        return firstName + "　" + secondName;
    }

    /**
     * 電話番号を"-"で連結して返します。
     * <p>
     * 引数がすべてnullもしくは空文字の場合は空文字を返します。
     * </p>
     * 
     * @param tel1 市外局番
     * @param tel2 市内局番
     * @param tel3 加入者番号
     * @return 連結結果
     */
    public static String toTel(Object tel1, Object tel2, Object tel3) {
        if (ACTextUtilities.isNullText(tel1)) {
            if (ACTextUtilities.isNullText(tel2)) {
                if (ACTextUtilities.isNullText(tel3)) {
                    return "";
                }
                return "--" + tel3;
            }
            if (ACTextUtilities.isNullText(tel3)) {
                return "-" + tel2 + "-";
            }
            return "-" + tel2 + "-" + tel3;
        }
        if (ACTextUtilities.isNullText(tel2)) {
            if (ACTextUtilities.isNullText(tel3)) {
                return tel1 + "--";
            }
            return tel1 + "--" + tel3;
        }
        if (ACTextUtilities.isNullText(tel3)) {
            return tel1 + "-" + tel2 + "-";
        }
        return tel1 + "-" + tel2 + "-" + tel3;
    }

    /**
     * 郵便番号を"-"で連結して返します。
     * <p>
     * 引数がすべてnullもしくは空文字の場合は空文字を返します。
     * </p>
     * 
     * @param zip1 配達局番号
     * @param zip2 町域番号
     * @return 連結結果
     */
    public static String toZip(Object zip1, Object zip2) {
        if (ACTextUtilities.isNullText(zip1)) {
            if (ACTextUtilities.isNullText(zip2)) {
                return "";
            }
            return "-" + zip2;
        }
        if (ACTextUtilities.isNullText(zip2)) {
            return zip1 + "-";
        }
        return zip1 + "-" + zip2;
    }

    /**
     * 請求詳細情報更新関数です。
     * <p>
     * 帳票出力用に、請求テーブルの詳細情報を登録・更新します。
     * </p>
     * <p>
     * トランザクションの開始・コミット・ロールバックは呼び出しもとで行なってください。
     * </p>
     * <p>
     * 検索キーは対象年月(TARGET_DATE)です。
     * </p>
     * <p>
     * 引数details <br />
     * <code>List{ <br />
     * Map(請求親情報・詳細情報) <br />
     * key:フィールド名・詳細種類 <br />
     * val:値 <br />
     * }</code><br />
     * 同一のCLAIM_IDからなるレコードは連続して配置してください。また、
     * 全てのレコードもしくは連続するCLAIM_IDの最初のレコードには詳細情報だけでなく親情報も格納してください。
     * </p>
     * 
     * @param dbm DBManager
     * @param details 登録データ
     * @param targetDate 対象年月
     * @param patientID 利用者ID
     * @return 更新レコード数
     * @throws Exception 処理例外
     */
    public static int updateClaimDetail(ACDBManager dbm, VRList details,
            Date targetDate, int patientID) throws Exception {
        return updateClaimDetail(dbm, details, targetDate, patientID, null);
    }

    /**
     * 請求詳細情報更新関数です。
     * <p>
     * 帳票出力用に、請求テーブルの詳細情報を登録・更新します。
     * </p>
     * <p>
     * トランザクションの開始・コミット・ロールバックは呼び出しもとで行なってください。
     * </p>
     * <p>
     * 検索キーは対象年月(TARGET_DATE)です。
     * </p>
     * <p>
     * 引数details <br />
     * <code>List{ <br />
     * Map(請求親情報・詳細情報) <br />
     * key:フィールド名・詳細種類 <br />
     * val:値 <br />
     * }</code><br />
     * 同一のCLAIM_IDからなるレコードは連続して配置してください。また、
     * 全てのレコードもしくは連続するCLAIM_IDの最初のレコードには詳細情報だけでなく親情報も格納してください。
     * </p>
     * 
     * @param dbm DBManager
     * @param details 登録データ
     * @param targetDate 対象年月
     * @param patientID 利用者ID
     * @param providerId 事業所ID
     * @return 更新レコード数
     * @throws Exception 処理例外
     */
    public static int updateClaimDetail(ACDBManager dbm, VRList details,
            Date targetDate, int patientID, String providerId) throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.setTime(targetDate);
        String ym = VRDateParser.format(cal, "yyyy/MM");
        // 親情報特定のためのSQL文

        StringBuilder sb;
        sb = new StringBuilder();
        sb.append(" (CLAIM.TARGET_DATE >= '" + ym + "/01')");
        sb.append(" AND(CLAIM.TARGET_DATE <= '" + ym + "/"
                + cal.getActualMaximum(Calendar.DAY_OF_MONTH) + "')");
        sb.append(" AND(CLAIM.PATIENT_ID = " + patientID + ")");
        if (!ACTextUtilities.isNullText(providerId)) {
            sb.append(" AND(CLAIM.PROVIDER_ID = '" + providerId + "')");
        }
        return updateClaimDetailCustom(dbm, details, targetDate, sb.toString());
    }

    /**
     * 請求詳細情報更新関数です。
     * <p>
     * 帳票出力用に、請求テーブルの詳細情報を登録・更新します。
     * </p>
     * <p>
     * トランザクションの開始・コミット・ロールバックは呼び出しもとで行なってください。
     * </p>
     * <p>
     * 引数details <br />
     * <code>List{ <br />
     * Map(請求親情報・詳細情報) <br />
     * key:フィールド名・詳細種類 <br />
     * val:値 <br />
     * }</code><br />
     * 同一のCLAIM_IDからなるレコードは連続して配置してください。また、
     * 全てのレコードもしくは連続するCLAIM_IDの最初のレコードには詳細情報だけでなく親情報も格納してください。
     * </p>
     * 
     * @param dbm DBManager
     * @param details 登録データ
     * @param targetDate 対象年月
     * @param where 親情報に対するwhere句
     * @return 更新レコード数
     * @throws Exception 処理例外
     */
    public static int updateClaimDetailCustom(ACDBManager dbm, VRList details,
            Date targetDate, String where) throws Exception {

        if (dbm == null) {
            return 0;
        }
        int updateCount = 0;
        // テーブル分割後の修飾語を取得
        if (targetDate == null) {
            targetDate = ACDateUtilities.createDate(2006, 4);
        }

        // 2006/06/06 tozo TANAKA begin edit 請求テーブルの年度別生成対応のため
        StringBuilder sb;
        if ((where == null) || ("".equals(where))) {
            where = "";
        } else {
            where = appendFrontWhere(where);
        }

        // 2007/03/19 tozo TANAKA begin move-to 年度またぎ対応のため
        // 親情報特定のためのSQL文
        sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" CLAIM.CLAIM_ID");
        sb.append(" FROM");
        sb.append(" CLAIM");
        sb.append(where);
        VRList ids = dbm.executeQuery(sb.toString());

        int end = ids.size();
        if (end > 0) {
            // 既存の親IDをIN句として連結
            sb = new StringBuilder();
            sb.append(".CLAIM_ID IN (");
            sb.append(((Map) ids.get(0)).get("CLAIM_ID"));
            for (int i = 1; i < end; i++) {
                sb.append(",");
                sb.append(((Map) ids.get(i)).get("CLAIM_ID"));
            }
            sb.append(")");
            String parentIDSQL = sb.toString();
            // 2007/03/19 tozo TANAKA end move-to 年度またぎ対応のため

            // 親情報特定のためのSQL文
            sb = new StringBuilder();
            sb.append("SELECT");
            sb.append(" DISTINCT");
            sb.append(" CLAIM.CLAIM_DATE");
            sb.append(" FROM");
            sb.append(" CLAIM");
            sb.append(" WHERE");
            sb.append("(TARGET_DATE = '");
            sb.append(VRDateParser.format(targetDate, "yyyy-MM-dd"));
            sb.append("')");
            VRList claimDates = dbm.executeQuery(sb.toString());
            Iterator it = claimDates.iterator();
            while (it.hasNext()) {
                // 対象年月が一致する既存データの請求年月を全走査し、詳細データの実テーブルを検出する
                int modify = getSeparateTableManager().getTableModifyFromDate(
                        dbm,
                        "CLAIM_DETAIL",
                        ACCastUtilities.toDate(VRBindPathParser.get(
                                "CLAIM_DATE", (VRMap) it.next())));
                if (modify < 0) {
                    continue;
                }

                // 作成したテーブル名は「元のテーブル名_年度」となる
                String tableSaffix = "_" + modify;

                // 一括削除 開始 ====================================================
                // // 親情報特定のためのSQL文
                // sb = new StringBuilder();
                // sb.append("SELECT");
                // sb.append(" CLAIM.CLAIM_ID");
                // sb.append(" FROM");
                // sb.append(" CLAIM");
                // sb.append(where);
                // VRList ids = dbm.executeQuery(sb.toString());
                //
                // int end = ids.size();
                // if (end > 0) {
                // // 既存の親IDをIN句として連結
                // sb = new StringBuilder();
                // sb.append(".CLAIM_ID IN (");
                // sb.append(((Map) ids.get(0)).get("CLAIM_ID"));
                // for (int i = 1; i < end; i++) {
                // sb.append(",");
                // sb.append(((Map) ids.get(i)).get("CLAIM_ID"));
                // }
                // sb.append(")");
                // String parentIDSQL = sb.toString();

                // 詳細文字列/数値/日付情報
                String[] tableNames = new String[] { "CLAIM_DETAIL_TEXT",
                        "CLAIM_DETAIL_INTEGER", "CLAIM_DETAIL_DATE" };
                for (int i = 0; i < tableNames.length; i++) {
                    String tableName = tableNames[i] + tableSaffix;
                    sb = new StringBuilder();
                    sb.append("DELETE FROM ");
                    sb.append(tableName);
                    sb.append(" WHERE ");
                    sb.append(tableName);
                    sb.append(parentIDSQL);
                    dbm.executeUpdate(sb.toString());
                }

                // // 親情報
                // sb = new StringBuilder();
                // sb.append("DELETE FROM");
                // sb.append(" CLAIM");
                // sb.append(" WHERE ");
                // sb.append(" CLAIM");
                // sb.append(parentIDSQL);
                // //add sta 2006.05.25 fujihara.shin
                // //再集計時、利用者向け請求の情報を消さないよう修整
                // sb.append(" AND CLAIM.CATEGORY_NO <> 16");
                // //add end 2006.05.25 fujihara.shin
                // dbm.executeUpdate(sb.toString());
                // }
            }
            // 2007/03/19 tozo TANAKA begin move-to 年度またぎ対応のため
            // 親情報
            sb = new StringBuilder();
            sb.append("DELETE FROM");
            sb.append(" CLAIM");
            sb.append(" WHERE ");
            sb.append(" CLAIM");
            sb.append(parentIDSQL);
            // add sta 2006.05.25 fujihara.shin
            // 再集計時、利用者向け請求の情報を消さないよう修整
            sb.append(" AND CLAIM.CATEGORY_NO <> 16");
            // add end 2006.05.25 fujihara.shin
            dbm.executeUpdate(sb.toString());
            // 2007/03/19 tozo TANAKA end move-to 年度またぎ対応のため
        }
        // 一括削除 終了 ====================================================
        // 2006/06/06 tozo TANAKA end edit 請求テーブルの年度別生成対応のため

        if (!details.isEmpty()) {

            // 登録に使うIDは、新たに振りなおしたBooking防止済ID
            int uniqueID = getDetailParentBookingID(dbm, details, "CLAIM",
                    "CLAIM_ID");
            if (uniqueID < 0) {
                throw new IllegalAccessError("番号管理マスタからの番号取得に失敗");
            }

            Set exclusiveKeys = new HashSet();
            exclusiveKeys.addAll(Arrays.asList(new String[] { "CLAIM_ID",
                    "CLAIM_STYLE_TYPE", "CATEGORY_NO", "PATIENT_ID",
                    "INSURED_ID", "TARGET_DATE", "CLAIM_DATE", "INSURER_ID",
                    "PROVIDER_ID", "CLAIM_FINISH_FLAG", "LAST_TIME", }));

            VRMap detailMaster = getDetailMaster(dbm,
                    QkanConstants.DETAIL_MASTER_CLAIM);

            // 2006/06/06 tozo TANAKA begin add 請求テーブルの年度別生成対応のため
            // 登録データの請求年月をもとに詳細情報の実テーブルを求める
            int modify = getSeparateTableManager().getTableModifyFromDate(
                    dbm,
                    "CLAIM_DETAIL",
                    ACCastUtilities.toDate(VRBindPathParser.get("CLAIM_DATE",
                            (VRMap) details.getData())));
            if (modify < 0) {
                return 0;
            }

            // 作成したテーブル名は「元のテーブル名_年度」となる
            String tableSaffix = "_" + modify;
            // 2006/06/06 tozo TANAKA end add 請求テーブルの年度別生成対応のため

            Iterator it = details.iterator();
            while (it.hasNext()) {
                VRMap row = (VRMap) it.next();
                // 主キーの存在確認
                Object idVal = VRBindPathParser.get("CLAIM_ID", row);
                String id;
                if (idVal != null) {
                    id = String.valueOf(idVal);
                } else {
                    Integer newID = new Integer(uniqueID++);
                    VRBindPathParser.set("CLAIM_ID", row, newID);
                    id = String.valueOf(newID);
                }

                // 基本情報の登録
                sb = new StringBuilder();
                sb.append("INSERT INTO");
                sb.append(" CLAIM");
                sb.append(" (");
                sb.append(" CLAIM_ID");
                sb.append(" ,CLAIM_STYLE_TYPE");
                sb.append(" ,CATEGORY_NO");
                sb.append(" ,PATIENT_ID");
                sb.append(" ,INSURED_ID");
                sb.append(" ,TARGET_DATE");
                sb.append(" ,CLAIM_DATE");
                sb.append(" ,INSURER_ID");
                sb.append(" ,PROVIDER_ID");
                sb.append(" ,CLAIM_FINISH_FLAG");
                sb.append(" ,LAST_TIME");
                sb.append(" )VALUES(");
                sb.append(id);
                sb.append(" ," + VRBindPathParser.get("CLAIM_STYLE_TYPE", row));
                sb.append(" ," + VRBindPathParser.get("CATEGORY_NO", row));
                sb.append(" ," + VRBindPathParser.get("PATIENT_ID", row));
                sb.append(" ,'" + VRBindPathParser.get("INSURED_ID", row) + "'");
                sb.append(" ,'"
                        + VRDateParser.format(
                                (Date) VRBindPathParser.get("TARGET_DATE", row),
                                "yyyy/MM") + "/01'");
                sb.append(" ,'"
                        + VRDateParser.format(
                                (Date) VRBindPathParser.get("CLAIM_DATE", row),
                                "yyyy/MM/dd") + "'");
                sb.append(" ,'" + VRBindPathParser.get("INSURER_ID", row) + "'");
                sb.append(" ,'" + VRBindPathParser.get("PROVIDER_ID", row)
                        + "'");
                sb.append(" ," + VRBindPathParser.get("CLAIM_FINISH_FLAG", row));
                sb.append(" ,CURRENT_TIMESTAMP");
                sb.append(")");
                dbm.executeUpdate(sb.toString());

                // 詳細情報の登録

                String detailValue;
                Iterator rowIt = row.entrySet().iterator();
                while (rowIt.hasNext()) {
                    java.util.Map.Entry ent = (java.util.Map.Entry) rowIt
                            .next();
                    String key = String.valueOf(ent.getKey());
                    if (exclusiveKeys.contains(key)) {
                        // 親テーブルのキーは処理しない
                        continue;
                    }
                    Object val = ent.getValue();

                    sb = new StringBuilder();
                    sb.append("INSERT INTO");

                    int mode = Integer.MAX_VALUE;

                    try {
                        if ((key != null) && (!"".equals(key))
                                && (key.replaceAll("[0-9]", "").length() == 0)) {
                            mode = Integer.parseInt(String.valueOf(detailMaster
                                    .getData(new Integer(key))));
                        } else {
                            continue;
                        }

                    } catch (Exception e) {
                        throw new IllegalArgumentException(
                                "未対応のデータ型を指定するバインドパス「" + key + "」が指定されました。");
                    }

                    // 型によって振り分ける
                    switch (mode) {
                    case QkanConstants.DETAIL_DATA_INTEGER:
                        sb.append(" CLAIM_DETAIL_INTEGER" + tableSaffix);
                        detailValue = ACConstants.FORMAT_SQL_INTEGER
                                .format(val);
                        break;
                    case QkanConstants.DETAIL_DATA_STRING:
                        sb.append(" CLAIM_DETAIL_TEXT" + tableSaffix);
                        detailValue = ACConstants.FORMAT_SQL_STRING.format(val);
                        break;
                    case QkanConstants.DETAIL_DATA_DATE:
                        sb.append(" CLAIM_DETAIL_DATE" + tableSaffix);
                        detailValue = ACConstants.FORMAT_SQL_FULL_YMD_HMS
                                .format(val);
                        break;
                    default:
                        throw new IllegalArgumentException(
                                "未対応のデータ型を指定するバインドパス「" + key + "」が指定されました。");

                    }
                    sb.append(" (");
                    sb.append(" CLAIM_ID");
                    sb.append(" ,SYSTEM_BIND_PATH");
                    sb.append(" ,DETAIL_VALUE");
                    sb.append(" ,LAST_TIME");
                    sb.append(" )VALUES(");
                    sb.append(id);
                    sb.append(" ," + key);
                    sb.append(" ," + detailValue);
                    sb.append(" ,CURRENT_TIMESTAMP");
                    sb.append(")");
                    updateCount += dbm.executeUpdate(sb.toString());
                }
            }
        }

        return updateCount;
    }

    /**
     * 事業所提供サービス詳細情報更新関数です。
     * <p>
     * 事業所画面保存時に、事業所提供サービスの詳細情報を登録・更新します。
     * </p>
     * <p>
     * トランザクションの開始・コミット・ロールバックは呼び出しもとで行なってください。
     * </p>
     * <p>
     * 引数details <br />
     * <code>List{ <br />
     * Map(事業所提供サービス親情報・詳細情報) <br />
     * key:フィールド名・詳細種類 <br />
     * val:値 <br />
     * }</code><br />
     * 同一のPROVIDER_SERVICE_IDからなるレコードは連続して配置してください。また、
     * 全てのレコードもしくは連続するPROVIDER_SERVICE_IDの最初のレコードには詳細情報だけでなく親情報も格納してください。
     * </p>
     * 
     * @param dbm DBManager
     * @param details 登録データ
     * @param providerID 事業所ID
     * @return 更新レコード数
     * @throws Exception 処理例外
     */
    public static int updateProviderServiceDetail(ACDBManager dbm,
            VRList details, String providerID) throws Exception {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append(" (PROVIDER_SERVICE.PROVIDER_ID = '" + providerID + "')");
        return updateProviderServiceDetailCustom(dbm, details, sb.toString());
    }

    /**
     * 事業所提供サービス詳細情報更新関数です。
     * <p>
     * 事業所画面保存時に、事業所提供サービスの詳細情報を登録・更新します。
     * </p>
     * <p>
     * トランザクションの開始・コミット・ロールバックは呼び出しもとで行なってください。
     * </p>
     * <p>
     * 引数details <br />
     * <code>List{ <br />
     * Map(事業所提供サービス親情報・詳細情報) <br />
     * key:フィールド名・詳細種類 <br />
     * val:値 <br />
     * }</code><br />
     * 同一のPROVIDER_SERVICE_IDからなるレコードは連続して配置してください。また、
     * 全てのレコードもしくは連続するPROVIDER_SERVICE_IDの最初のレコードには詳細情報だけでなく親情報も格納してください。
     * </p>
     * 
     * @param dbm DBManager
     * @param details 登録データ
     * @param where 親情報のwhere句
     * @return 更新レコード数
     * @throws Exception 処理例外
     */
    public static int updateProviderServiceDetailCustom(ACDBManager dbm,
            VRList details, String where) throws Exception {

        if (dbm == null) {
            return 0;
        }
        int updateCount = 0;

        StringBuilder sb;

        // 一括削除 開始 ====================================================
        // 親情報特定のためのSQL文
        sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" PROVIDER_SERVICE.PROVIDER_SERVICE_ID");
        sb.append(" FROM");
        sb.append(" PROVIDER_SERVICE");
        sb.append(" WHERE");
        sb.append(where);
        VRList ids = dbm.executeQuery(sb.toString());

        int end = ids.size();
        if (end > 0) {
            // 既存の親IDをIN句として連結
            sb = new StringBuilder();
            sb.append(".PROVIDER_SERVICE_ID IN (");
            sb.append(((Map) ids.get(0)).get("PROVIDER_SERVICE_ID"));
            for (int i = 1; i < end; i++) {
                sb.append(",");
                sb.append(((Map) ids.get(i)).get("PROVIDER_SERVICE_ID"));
            }
            sb.append(")");
            String parentIDSQL = sb.toString();

            // 詳細文字列/数値/日付情報
            String[] tableNames = new String[] {
                    "PROVIDER_SERVICE_DETAIL_TEXT",
                    "PROVIDER_SERVICE_DETAIL_INTEGER",
                    "PROVIDER_SERVICE_DETAIL_DATE" };
            for (int i = 0; i < tableNames.length; i++) {
                String tableName = tableNames[i];
                sb = new StringBuilder();
                sb.append("DELETE FROM ");
                sb.append(tableName);
                sb.append(" WHERE ");
                sb.append(tableName);
                sb.append(parentIDSQL);
                dbm.executeUpdate(sb.toString());
            }

            // 親情報
            sb = new StringBuilder();
            sb.append("DELETE FROM");
            sb.append(" PROVIDER_SERVICE");
            sb.append(" WHERE ");
            sb.append("PROVIDER_SERVICE");
            sb.append(parentIDSQL);
            dbm.executeUpdate(sb.toString());
        }
        // 一括削除 終了 ====================================================

        if (!details.isEmpty()) {

            // 登録に使うIDは、新たに振りなおしたBooking防止済ID
            int uniqueID = getDetailParentBookingID(dbm, details,
                    "PROVIDER_SERVICE", "PROVIDER_SERVICE_ID");
            if (uniqueID < 0) {
                throw new IllegalAccessException("番号管理マスタからの番号取得に失敗");
            }

            Set exclusiveKeys = new HashSet();
            exclusiveKeys.addAll(Arrays
                    .asList(new String[] { "PROVIDER_SERVICE_ID",
                            "PROVIDER_ID", "SYSTEM_SERVICE_KIND_DETAIL",
                            "REDUCT_RATE", "LAST_TIME", }));
            VRMap detailMaster = getDetailMaster(dbm,
                    QkanConstants.DETAIL_MASTER_PROVIDER);

            Iterator it = details.iterator();
            while (it.hasNext()) {
                VRMap row = (VRMap) it.next();
                // 主キーの存在確認
                Object idVal = VRBindPathParser.get("PROVIDER_SERVICE_ID", row);
                String id;
                if (idVal != null) {
                    id = String.valueOf(idVal);
                } else {
                    Integer newID = new Integer(uniqueID++);
                    VRBindPathParser.set("PROVIDER_SERVICE_ID", row, newID);
                    id = String.valueOf(newID);
                }
                // 基本情報の登録
                sb = new StringBuilder();
                sb.append("INSERT INTO");
                sb.append(" PROVIDER_SERVICE");
                sb.append(" (");
                sb.append(" PROVIDER_SERVICE_ID");
                sb.append(" ,PROVIDER_ID");
                sb.append(" ,SYSTEM_SERVICE_KIND_DETAIL");
                sb.append(" ,REDUCT_RATE");
                sb.append(" ,LAST_TIME");
                sb.append(" )VALUES(");
                sb.append(id);
                sb.append(" ,'" + VRBindPathParser.get("PROVIDER_ID", row)
                        + "'");
                sb.append(" ,"
                        + VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL",
                                row));
                sb.append(" ," + VRBindPathParser.get("REDUCT_RATE", row));
                sb.append(" ,CURRENT_TIMESTAMP");
                sb.append(")");
                dbm.executeUpdate(sb.toString());

                // 詳細情報の登録

                Iterator rowIt = row.entrySet().iterator();
                while (rowIt.hasNext()) {
                    java.util.Map.Entry ent = (java.util.Map.Entry) rowIt
                            .next();
                    String key = String.valueOf(ent.getKey());
                    if (exclusiveKeys.contains(key)) {
                        // 親テーブルのキーは処理しない
                        continue;
                    }
                    Object val = ent.getValue();

                    String detailValue;

                    sb = new StringBuilder();
                    sb.append("INSERT INTO");
                    // 型によって振り分ける
                    int type = -1;
                    Object obj = detailMaster.getData(Integer.valueOf(key));
                    if (obj != null) {
                        type = Integer.parseInt(String.valueOf(obj));
                    }
                    switch (type) {
                    case QkanConstants.DETAIL_DATA_INTEGER:
                        sb.append(" PROVIDER_SERVICE_DETAIL_INTEGER");
                        detailValue = ACConstants.FORMAT_SQL_INTEGER
                                .format(val);
                        break;
                    case QkanConstants.DETAIL_DATA_STRING:
                        sb.append(" PROVIDER_SERVICE_DETAIL_TEXT");
                        detailValue = ACConstants.FORMAT_SQL_STRING.format(val);
                        break;
                    case QkanConstants.DETAIL_DATA_DATE:
                        sb.append(" PROVIDER_SERVICE_DETAIL_DATE");
                        detailValue = ACConstants.FORMAT_SQL_FULL_YMD_HMS
                                .format(val);
                        break;
                    default:
                        VRLogger.info("未対応のデータ型を指定するバインドパス「" + key
                                + "」が指定されました。");
                        continue;
                        // throw new IllegalArgumentException(
                        // "未対応のデータ型を指定するバインドパス「"
                        // + VRBindPathParser.get(
                        // "SYSTEM_BIND_PATH", row)
                        // + "」が指定されました。");

                    }
                    sb.append(" (");
                    sb.append(" PROVIDER_SERVICE_ID");
                    sb.append(" ,SYSTEM_BIND_PATH");
                    sb.append(" ,DETAIL_VALUE");
                    sb.append(" ,LAST_TIME");
                    sb.append(" )VALUES(");
                    sb.append(id);
                    sb.append(" ," + key);
                    sb.append(" ," + detailValue);
                    sb.append(" ,CURRENT_TIMESTAMP");
                    sb.append(")");
                    updateCount += dbm.executeUpdate(sb.toString());

                }
            }
        }

        return updateCount;
    }

    /**
     * サービス詳細情報更新関数です。
     * <p>
     * サービス予定・実績画面保存時に、サービスの詳細情報を登録・更新します。
     * </p>
     * <p>
     * トランザクションの開始・コミット・ロールバックは呼び出しもとで行なってください。
     * </p>
     * <p>
     * パッシブチェックテーブル(SERVICE_PASSIVE_CHECK)の更新は呼び出しもとで行なってください。
     * </p>
     * <p>
     * 引数details <br />
     * <code>List{ <br />
     * Map(サービス親情報・詳細情報) <br />
     * key:フィールド名・詳細種類 <br />
     * val:値 <br />
     * }</code><br />
     * 同一のSERVICE_IDからなるレコードは連続して配置してください。また、
     * 全てのレコードもしくは連続するSERVICE_IDの最初のレコードには詳細情報だけでなく親情報も格納してください。
     * </p>
     * <p>
     * 引数「取得区分」には以下の値を指定します。 <br />
     * 101-予定(SERVICE_DETAIL_GET_PLAN) <br />
     * 102-実績(SERVICE_DETAIL_GET_RESULT)
     * </p>
     * 
     * @param dbm DBManager
     * @param details 登録データ
     * @param patientID 利用者ID
     * @param targetDate 対象年月
     * @param useType 取得区分
     * @return 更新レコード数
     * @throws Exception 処理例外
     */
    public static int updateServiceDetail(ACDBManager dbm, VRList details,
            int patientID, Date targetDate, int useType) throws Exception {

        // 一括削除準備
        StringBuilder sb;
        Calendar cal = Calendar.getInstance();
        cal.setTime(targetDate);
        String ym = VRDateParser.format(cal, "yyyy/MM");

        // 親情報検索条件
        sb = new StringBuilder();
        sb.append(" (SERVICE.SERVICE_DATE >= '" + ym + "/01')");
        sb.append(" AND(SERVICE.SERVICE_DATE <= '" + ym + "/"
                + cal.getActualMaximum(Calendar.DAY_OF_MONTH) + "')");
        sb.append(" AND(SERVICE.PATIENT_ID = " + patientID + ")");
        sb.append(" AND");
        sb.append(getServiceUseTypeSQLWithoutAnd(useType));

        return updateServiceDetailCustom(dbm, details, targetDate,
                sb.toString());
    }

    /**
     * サービス詳細情報更新関数です。
     * <p>
     * サービス予定・実績画面保存時に、サービスの詳細情報を登録・更新します。
     * </p>
     * <p>
     * トランザクションの開始・コミット・ロールバックは呼び出しもとで行なってください。
     * </p>
     * <p>
     * パッシブチェックテーブル(SERVICE_PASSIVE_CHECK)の更新は呼び出しもとで行なってください。
     * </p>
     * <p>
     * 引数details <br />
     * <code>List{ <br />
     * Map(サービス親情報・詳細情報) <br />
     * key:フィールド名・詳細種類 <br />
     * val:値 <br />
     * }</code><br />
     * 同一のSERVICE_IDからなるレコードは連続して配置してください。また、
     * 全てのレコードもしくは連続するSERVICE_IDの最初のレコードには詳細情報だけでなく親情報も格納してください。
     * </p>
     * 
     * @param dbm DBManager
     * @param details 登録データ
     * @param targetDate 対象年月
     * @param where 親情報のwhere句
     * @return 更新レコード数
     * @throws Exception 処理例外
     */
    public static int updateServiceDetailCustom(ACDBManager dbm,
            VRList details, Date targetDate, String where) throws Exception {
        if (dbm == null) {
            return 0;
        }
        int updateCount = 0;
        // テーブル分割後の修飾語を取得
        if (targetDate == null) {
            targetDate = ACDateUtilities.createDate(2006, 4);
        }
        int modify = getSeparateTableManager().getTableModifyFromDate(dbm,
                "SERVICE_DETAIL", targetDate);
        if (modify < 0) {
            return 0;
        }
        String tableSaffix = "_" + modify;

        StringBuilder sb;

        // 一括削除 開始 ====================================================
        if ((where == null) || ("".equals(where))) {
            where = "";
        } else {
            where = " WHERE " + where;
        }
        // 親情報検索SQL文
        sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" SERVICE.SERVICE_ID");
        sb.append(" FROM");
        sb.append(" SERVICE");
        sb.append(where);
        VRList ids = dbm.executeQuery(sb.toString());

        int end = ids.size();
        if (end > 0) {
            // 既存の親IDをIN句として連結
            sb = new StringBuilder();
            sb.append(".SERVICE_ID IN (");
            sb.append(((Map) ids.get(0)).get("SERVICE_ID"));
            for (int i = 1; i < end; i++) {
                sb.append(",");
                sb.append(((Map) ids.get(i)).get("SERVICE_ID"));
            }
            sb.append(")");
            String parentIDSQL = sb.toString();

            // 詳細文字列/数値/日付情報
            String[] tableNames = new String[] { "SERVICE_DETAIL_TEXT",
                    "SERVICE_DETAIL_INTEGER", "SERVICE_DETAIL_DATE", };
            for (int i = 0; i < tableNames.length; i++) {
                String tableName = tableNames[i] + tableSaffix;
                sb = new StringBuilder();
                sb.append("DELETE FROM ");
                sb.append(tableName);
                sb.append(" WHERE ");
                sb.append(tableName);
                sb.append(parentIDSQL);
                dbm.executeUpdate(sb.toString());
            }

            // 親情報 削除
            sb = new StringBuilder();
            sb.append("DELETE FROM");
            sb.append(" SERVICE");
            sb.append(" WHERE ");
            sb.append("SERVICE");
            sb.append(parentIDSQL);
            dbm.executeUpdate(sb.toString());
        }

        // 一括削除 終了 ====================================================

        if (!details.isEmpty()) {
            // 登録に使うIDは、新たに振りなおしたBooking防止済ID
            int uniqueID = getDetailParentBookingID(dbm, details, "SERVICE",
                    "SERVICE_ID");
            if (uniqueID < 0) {
                throw new IllegalAccessError("番号管理マスタからの番号取得に失敗");
            }

            Set exclusiveKeys = new HashSet();
            exclusiveKeys.addAll(Arrays.asList(new String[] { "SERVICE_ID",
                    // "LOGIN_PROVIDER_ID",
                    "SERVICE_USE_TYPE", "PATIENT_ID", "PROVIDER_ID",
                    "SYSTEM_SERVICE_KIND_DETAIL", "SERVICE_DATE", "WEEK_DAY",
                    // "EXPENSES_FLAG",
                    "REGULATION_RATE", "LAST_TIME", }));

            VRMap detailMaster = getDetailMaster(dbm,
                    QkanConstants.DETAIL_MASTER_SERVICE);

            Iterator it = details.iterator();
            while (it.hasNext()) {
                VRMap row = (VRMap) it.next();
                // 主キーの存在確認
                Object idVal = row.get("SERVICE_ID");
                String id;
                if (idVal != null) {
                    id = String.valueOf(idVal);
                } else {
                    Integer newID = new Integer(uniqueID++);
                    try {
                        row.put("SERVICE_ID", newID);
                    } catch (java.util.ConcurrentModificationException ex) {
                        // イテレーションの同期例外は無視
                    }
                    id = String.valueOf(newID);
                }
                // 基本情報の登録
                sb = new StringBuilder();
                sb.append("INSERT INTO");
                sb.append(" SERVICE");
                sb.append(" (");
                sb.append(" SERVICE_ID");
                // sb.append(" ,LOGIN_PROVIDER_ID");
                sb.append(" ,SERVICE_USE_TYPE");
                sb.append(" ,PATIENT_ID");
                sb.append(" ,PROVIDER_ID");
                sb.append(" ,SYSTEM_SERVICE_KIND_DETAIL");
                sb.append(" ,SERVICE_DATE");
                sb.append(" ,WEEK_DAY");
                // sb.append(" ,EXPENSES_FLAG");
                sb.append(" ,REGULATION_RATE");
                sb.append(" ,LAST_TIME");
                sb.append(" )VALUES(");
                sb.append(id);
                // sb.append(" ,'"
                // + VRBindPathParser.get("LOGIN_PROVIDER_ID", row) + "'");
                sb.append(" ," + row.get("SERVICE_USE_TYPE"));
                sb.append(" ," + row.get("PATIENT_ID"));
                sb.append(" ,'" + row.get("PROVIDER_ID") + "'");
                sb.append(" ," + row.get("SYSTEM_SERVICE_KIND_DETAIL"));
                Object serviceData = row.get("SERVICE_DATE");
                if (serviceData instanceof Date) {
                    sb.append(" ,'"
                            + VRDateParser.format((Date) serviceData,
                                    "yyyy/MM/dd") + "'");
                } else {
                    sb.append(" ,NULL");
                }
                sb.append(" ,"
                        + ACSQLSafeNullToZeroIntegerFormat.getInstance()
                                .format(row.get("WEEK_DAY")));
                // sb.append(" ,"
                // + ACSQLSafeNullToZeroIntegerFormat.getInstance()
                // .format(
                // VRBindPathParser.get("EXPENSES_FLAG",
                // row)));
                sb.append(" ,"
                        + ACSQLSafeNullToZeroIntegerFormat.getInstance()
                                .format(row.get("REGULATION_RATE")));
                sb.append(" ,CURRENT_TIMESTAMP");
                sb.append(")");
                dbm.executeUpdate(sb.toString());

                // 詳細情報の登録

                Iterator rowIt = row.entrySet().iterator();
                while (rowIt.hasNext()) {
                    java.util.Map.Entry ent = (java.util.Map.Entry) rowIt
                            .next();
                    String key = String.valueOf(ent.getKey());
                    if (exclusiveKeys.contains(key)) {
                        // 親テーブルのキーは処理しない
                        continue;
                    }
                    Object val = ent.getValue();

                    String detailValue;
                    sb = new StringBuilder();
                    sb.append("INSERT INTO");
                    // 型によって振り分ける
                    int type = -1;
                    Object obj = detailMaster.getData(ACCastUtilities
                            .toInteger(key, null));
                    if (obj != null) {
                        type = ACCastUtilities.toInt(obj, 0);
                    }
                    switch (type) {
                    case QkanConstants.DETAIL_DATA_INTEGER:
                        sb.append(" SERVICE_DETAIL_INTEGER" + tableSaffix);
                        detailValue = ACSQLSafeIntegerFormat.getInstance()
                                .format(val);
                        break;
                    case QkanConstants.DETAIL_DATA_STRING:
                        sb.append(" SERVICE_DETAIL_TEXT" + tableSaffix);
                        detailValue = ACConstants.FORMAT_SQL_STRING.format(val);
                        break;
                    case QkanConstants.DETAIL_DATA_DATE:
                        sb.append(" SERVICE_DETAIL_DATE" + tableSaffix);
                        detailValue = ACConstants.FORMAT_SQL_FULL_YMD_HMS
                                .format(val);
                        break;
                    default:
                        VRLogger.info("未対応のデータ型を指定するバインドパス「" + key
                                + "」が指定されました。");
                        continue;
                        // throw new IllegalArgumentException(
                        // "未対応のデータ型を指定するバインドパス「"
                        // + key
                        // + "」が指定されました。");

                    }
                    sb.append(" (");
                    sb.append(" SERVICE_ID");
                    sb.append(" ,SYSTEM_BIND_PATH");
                    sb.append(" ,DETAIL_VALUE");
                    sb.append(" ,LAST_TIME");
                    sb.append(" )VALUES(");
                    sb.append(id);
                    sb.append(" ," + key);
                    sb.append(" ," + detailValue);
                    sb.append(" ,CURRENT_TIMESTAMP");
                    sb.append(")");
                    updateCount += dbm.executeUpdate(sb.toString());

                }

            }
        }

        return updateCount;
    }

    /**
     * サービスパターン詳細情報更新関数です。
     * <p>
     * サービスパターン保存時に、サービスパターンの詳細情報を登録・更新します。
     * </p>
     * <p>
     * トランザクションの開始・コミット・ロールバックは呼び出しもとで行なってください。
     * </p>
     * <p>
     * パッシブチェックテーブル(SERVICE_PASSIVE_CHECK)の更新は呼び出しもとで行なってください。
     * </p>
     * <p>
     * 引数details <br />
     * <code>List{ <br />
     * Map(サービスパターン親情報・詳細情報) <br />
     * key:フィールド名・詳細種類 <br />
     * val:値 <br />
     * }</code><br />
     * 同一のSERVICE_IDからなるレコードは連続して配置してください。また、
     * 全てのレコードもしくは連続するSERVICE_IDの最初のレコードには詳細情報だけでなく親情報も格納してください。
     * </p>
     * 
     * @param dbm DBManager
     * @param serviceKind 独自サービス種類コード
     * @param details 登録データ
     * @return 更新レコード数
     * @throws Exception 処理例外
     */
    public static int updateServicePatternDetail(ACDBManager dbm,
            int serviceKind, VRList details) throws Exception {
        return updateServicePatternDetailCustom(dbm, details,
                " (SERVICE.SYSTEM_SERVICE_KIND_DETAIL = " + serviceKind + ")");
    }

    /**
     * サービスパターン詳細情報更新関数です。
     * <p>
     * サービスパターン保存時に、サービスパターンの詳細情報を登録・更新します。
     * </p>
     * <p>
     * トランザクションの開始・コミット・ロールバックは呼び出しもとで行なってください。
     * </p>
     * <p>
     * パッシブチェックテーブル(SERVICE_PASSIVE_CHECK)の更新は呼び出しもとで行なってください。
     * </p>
     * <p>
     * 引数details <br />
     * <code>List{ <br />
     * Map(サービスパターン親情報・詳細情報) <br />
     * key:フィールド名・詳細種類 <br />
     * val:値 <br />
     * }</code><br />
     * 同一のSERVICE_IDからなるレコードは連続して配置してください。また、
     * 全てのレコードもしくは連続するSERVICE_IDの最初のレコードには詳細情報だけでなく親情報も格納してください。
     * </p>
     * 
     * @param dbm DBManager
     * @param details 登録データ
     * @return 更新レコード数
     * @throws Exception 処理例外
     */
    public static int updateServicePatternDetail(ACDBManager dbm, VRList details)
            throws Exception {
        return updateServicePatternDetailCustom(dbm, details, null);
    }

    /**
     * サービスパターン詳細情報更新関数です。
     * <p>
     * サービスパターン保存時に、サービスパターンの詳細情報を登録・更新します。
     * </p>
     * <p>
     * トランザクションの開始・コミット・ロールバックは呼び出しもとで行なってください。
     * </p>
     * <p>
     * パッシブチェックテーブル(SERVICE_PASSIVE_CHECK)の更新は呼び出しもとで行なってください。
     * </p>
     * <p>
     * 引数details <br />
     * <code>List{ <br />
     * Map(サービスパターン親情報・詳細情報) <br />
     * key:フィールド名・詳細種類 <br />
     * val:値 <br />
     * }</code><br />
     * 同一のSERVICE_IDからなるレコードは連続して配置してください。また、
     * 全てのレコードもしくは連続するSERVICE_IDの最初のレコードには詳細情報だけでなく親情報も格納してください。
     * </p>
     * 
     * @param dbm DBManager
     * @param details 登録データ
     * @param where 親情報のwhere句
     * @return 更新レコード数
     * @throws Exception 処理例外
     */
    public static int updateServicePatternDetailCustom(ACDBManager dbm,
            VRList details, String where) throws Exception {
        StringBuilder sb;
        sb = new StringBuilder();
        if (!ACTextUtilities.isNullText(where)) {
            sb.append(where);
            sb.append(" AND");
        }
        sb.append(" (SERVICE.SERVICE_USE_TYPE = "
                + QkanConstants.SERVICE_USE_TYPE_PATTERN + ")");
        return updateServiceDetailCustom(dbm, details, null, sb.toString());
    }

    /**
     * 引数のWHERE文の先頭にAND句を付加して返します。
     * 
     * @param where 変換元
     * @return 変換結果
     */
    protected static String appendFrontAnd(String where) {
        if (where.startsWith(" AND") || where.startsWith("AND")
                || where.startsWith(" OR") || where.startsWith("OR")) {
            return where;
        }
        return " AND" + where;
    }

    /**
     * 引数の条件文の先頭にWHERE句を付加して返します。
     * 
     * @param where 変換元
     * @return 変換結果
     */
    protected static String appendFrontWhere(String where) {
        if (ACTextUtilities.isNullText(where)) {
            return where;
        }
        if (where.startsWith(" AND")) {
            where = where.substring(4);
        } else if (where.startsWith(" OR")) {
            where = where.substring(3);
        } else if (where.startsWith("AND")) {
            where = where.substring(3);
        } else if (where.startsWith("OR")) {
            where = where.substring(2);
        } else if ((where.startsWith(" WHERE")) || (where.startsWith("WHERE"))) {
            return where;
        }
        return " WHERE " + where;
    }

    /**
     * 特定年月にかぶる要介護認定履歴を抽出するWHERE条件を返します。
     * <p>
     * "WHERE"や連結する際の"AND"は含みません。
     * </p>
     * 
     * @param targetDate 対象年月
     * @return SQL条件文
     * @throws Exception 処理例外
     */
    protected static String createWhereStatementOfNinteiHistory(Date targetDate)
            throws Exception {

        Calendar cal = Calendar.getInstance();
        cal.setTime(targetDate);
        String ym = VRDateParser.format(cal, "yyyy/MM");

        StringBuilder sb = new StringBuilder();

        // -- 有効期間をチェックするSQL文 開始----------------------------------------
        // 有効期間内もしくはかぶっているパターンは複数あり、そのいずれか一つに該当すれば許容する
        sb.append(" (");

        String targetDateBegin = ym + "/01";
        String targetDateEnd = ym + "/"
                + cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        sb.append(" (");
        // 1.有効期間開始日が対象年月以前の場合
// 2014/12/17 [Yoichiro Kamei] mod - begin システム有効期間対応
//        sb.append(" (PATIENT_NINTEI_HISTORY.INSURE_VALID_START <= '"
//                + targetDateEnd + "')");
        sb.append(" (PATIENT_NINTEI_HISTORY.SYSTEM_INSURE_VALID_START <= '"
                + targetDateEnd + "')");
// 2014/12/17 [Yoichiro Kamei] mod - end
        // 1-1.かつ有効期間終了日は対象年月の初日と同じか超えているならば期間がかぶるのでOK
// 2014/12/17 [Yoichiro Kamei] mod - begin システム有効期間対応
//        sb.append(" AND(PATIENT_NINTEI_HISTORY.INSURE_VALID_END >= '"
//                + targetDateBegin + "')");
        sb.append(" AND(PATIENT_NINTEI_HISTORY.SYSTEM_INSURE_VALID_END >= '"
                + targetDateBegin + "')");
// 2014/12/17 [Yoichiro Kamei] mod - end
        sb.append(" )OR(");

        // 2.有効期間開始日が対象年月内ならば期間がかぶるのでOK
// 2014/12/17 [Yoichiro Kamei] mod - begin システム有効期間対応
//        sb.append(" (PATIENT_NINTEI_HISTORY.INSURE_VALID_START <= '"
//                + targetDateBegin + "')");
//      sb.append(" AND(PATIENT_NINTEI_HISTORY.INSURE_VALID_START >= '"
//      + targetDateEnd + "')");
        sb.append(" (PATIENT_NINTEI_HISTORY.SYSTEM_INSURE_VALID_START <= '"
                + targetDateBegin + "')");
        sb.append(" AND(PATIENT_NINTEI_HISTORY.SYSTEM_INSURE_VALID_START >= '"
                + targetDateEnd + "')");
// 2014/12/17 [Yoichiro Kamei] mod - end
        sb.append(" )");

        sb.append(" )");
        // -- 有効期間をチェックするSQL文 終了----------------------------------------

        return sb.toString();
    }

    /**
     * 詳細マスタハッシュを返します。
     * <p>
     * バインドパスをキーにデータタイプを参照するハッシュを返します。
     * </p>
     * 
     * @param dbm DBManager
     * @param type 詳細マスタタイプ
     * @return 詳細マスタハッシュ
     * @throws Exception 処理例外
     * @see QkanConstants.DETAIL_MASTER_SERVICE
     * @see QkanConstants.DETAIL_MASTER_PROVIDER
     * @see QkanConstants.DETAIL_MASTER_STAFF
     * @see QkanConstants.DETAIL_MASTER_CLAIM
     */
    protected static VRMap getDetailMaster(ACDBManager dbm, int type)
            throws Exception {
        StringBuilder sb;

        sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" M_DETAIL.SYSTEM_BIND_PATH,");
        sb.append(" M_DETAIL.DATA_TYPE");
        sb.append(" FROM");
        sb.append(" M_DETAIL");
        sb.append(" WHERE");
        sb.append(" (M_DETAIL.DETAIL_PROPERTY = " + type + ")");

        VRList detailMasterArray = dbm.executeQuery(sb.toString());
        VRMap detailMaster = new VRHashMap();
        Iterator it = detailMasterArray.iterator();
        while (it.hasNext()) {
            VRMap row = (VRMap) it.next();
            detailMaster.setData(VRBindPathParser.get("SYSTEM_BIND_PATH", row),
                    VRBindPathParser.get("DATA_TYPE", row));
        }
        return detailMaster;
    }

    /**
     * 詳細の親レコード数を計算し、衝突しないBooking防止済開始番号を返します。
     * 
     * @param dbm DBManager
     * @param details 詳細レコード集合
     * @param tableName テーブル名
     * @param fieldName キーフィールド名
     * @return Booking防止済開始番号
     * @throws Exception
     */
    protected static int getDetailParentBookingID(ACDBManager dbm,
            VRList details, String tableName, String fieldName)
            throws Exception {
        // 親レコード数を計上
        // 初回の比較で必ず一致するよう、存在しないIDで初期化
        // String nowID = "";
        int detailParentCount = 0;
        Iterator it = details.iterator();
        while (it.hasNext()) {
            VRMap row = (VRMap) it.next();
            if (!VRBindPathParser.has(fieldName, row)) {
                detailParentCount++;
            }
        }

        // 登録に使うIDは、新たに振りなおしたBooking防止済開始番号を返します。
        return QkanCommon.getBookingNumber(dbm, tableName, fieldName,
                detailParentCount);
    }


    /**
     * 事業所情報取得関数です。
     * <p>
     * 事業所情報編集時、選択事業所情報を取得します。
     * </p>
     * <p>
     * 返り値 <br />
     * <code>List{ <br />
     * Map(事業所情報) <br />
     * key:フィールド名 <br />
     * val:値 <br />
     * }</code><br />
     * ASC 事業所番号
     * </p>
     * 
     * @param dbm DBManager
     * @param where 絞込み句
     * @return 事業所情報(事業所番号順)
     * @throws Exception 処理例外
     */
    protected static VRList getProviderInfoImpl(ACDBManager dbm, String where)
            throws Exception {
        StringBuilder sb;

        sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" DISTINCT PROVIDER.PROVIDER_ID,");
        sb.append(" PROVIDER.PROVIDER_TYPE,");
        sb.append(" PROVIDER.MEDICAL_FLAG,");
        sb.append(" PROVIDER.PROVIDER_TYPE,");
        sb.append(" PROVIDER.PROVIDER_NAME,");
        sb.append(" PROVIDER.PROVIDER_ZIP_FIRST,");
        sb.append(" PROVIDER.PROVIDER_ZIP_SECOND,");
        sb.append(" PROVIDER.PROVIDER_ADDRESS,");
        sb.append(" PROVIDER.PROVIDER_TEL_FIRST,");
        sb.append(" PROVIDER.PROVIDER_TEL_SECOND,");
        sb.append(" PROVIDER.PROVIDER_TEL_THIRD,");
        sb.append(" PROVIDER.PROVIDER_FAX_FIRST,");
        sb.append(" PROVIDER.PROVIDER_FAX_SECOND,");
        sb.append(" PROVIDER.PROVIDER_FAX_THIRD,");
        sb.append(" PROVIDER.PROVIDER_JIJIGYOUSHO_TYPE,");
        sb.append(" PROVIDER.PROVIDER_JIGYOU_TYPE,");
        sb.append(" PROVIDER.PROVIDER_AREA_TYPE,");
        sb.append(" PROVIDER.SPECIAL_AREA_FLAG,");
        // sb.append(" PROVIDER.SHAFUKU_GENMEN_FLAG,");
        sb.append(" PROVIDER.PROVIDER_OWNER_NAME,");
        sb.append(" PROVIDER.BANK_NAME,");
        sb.append(" PROVIDER.BANK_BRANCH_NAME,");
        sb.append(" PROVIDER.ACCOUNT_NUMBER,");
        sb.append(" PROVIDER.ACCOUNT_TYPE,");
        sb.append(" PROVIDER.ACCOUNT_HOLDER,");
        sb.append(" PROVIDER.LAST_TIME");
        sb.append(" FROM");
        sb.append(" PROVIDER");
        // edit sta shin.fujihara 2005.12.13
        // nullの場合は条件を付加しない。
        // if (ACTextUtilities.isNullText(where)) {
        if (!ACTextUtilities.isNullText(where)) {
            // edit end shin.fujihara 2005.12.13
            sb.append(where);
        }
        sb.append(" ORDER BY");
        sb.append(" PROVIDER.PROVIDER_ID ASC");

        if (dbm == null) {
            return new VRArrayList();
        }
        return dbm.executeQuery(sb.toString());
    }

    /**
     * テーブル分割管理クラスを返します。
     * 
     * @return テーブル分割管理クラス
     */
    protected static ACSeparateTableManager getSeparateTableManager() {
        if (separateTableManager == null) {
            separateTableManager = new ACSeparateTableManager();

            separateTableManager.setManageTableName("M_DETAIL_CONTROL");
            separateTableManager.setManagedTableNameFieldName("TABLE_NAME");
            separateTableManager.setMaximumModifierFieldName("MAXIMUM_YEAR");
            separateTableManager.setMinimumModifierFieldName("MINIMUM_YEAR");
            separateTableManager.setTimeStampFieldName("LAST_TIME");
            separateTableManager.setUseManagementTable(true);
            separateTableManager.setUseTimestampField(true);
            separateTableManager.setFiscalYear(true);

            ArrayList tables;
            // サービス
            tables = new ArrayList();
            tables.add(new BridgeFirebirdSeparateTable(
                    "SERVICE_DETAIL_INTEGER", "SERVICE_ID INTEGER NOT NULL"
                            + ", SYSTEM_BIND_PATH INTEGER NOT NULL"
                            + ", DETAIL_VALUE INTEGER"
                            + ", LAST_TIME TIMESTAMP"
                            + ", PRIMARY KEY(SERVICE_ID ,SYSTEM_BIND_PATH)"));
            tables.add(new BridgeFirebirdSeparateTable("SERVICE_DETAIL_DATE",
                    "SERVICE_ID INTEGER NOT NULL"
                            + ", SYSTEM_BIND_PATH INTEGER NOT NULL"
                            + ", DETAIL_VALUE TIMESTAMP"
                            + ", LAST_TIME TIMESTAMP"
                            + ", PRIMARY KEY(SERVICE_ID ,SYSTEM_BIND_PATH)"));
            tables.add(new BridgeFirebirdSeparateTable("SERVICE_DETAIL_TEXT",
                    "SERVICE_ID INTEGER NOT NULL"
                            + ", SYSTEM_BIND_PATH INTEGER NOT NULL"
                            + ", DETAIL_VALUE VARCHAR(600)"
                            + ", LAST_TIME TIMESTAMP"
                            + ", PRIMARY KEY(SERVICE_ID ,SYSTEM_BIND_PATH)"));
            separateTableManager.addSeparateTable("SERVICE_DETAIL", tables);

            // 請求
            tables = new ArrayList();
            tables.add(new BridgeFirebirdSeparateTable("CLAIM_DETAIL_INTEGER",
                    "CLAIM_ID INTEGER NOT NULL"
                            + ", SYSTEM_BIND_PATH INTEGER NOT NULL"
                            + ", DETAIL_VALUE INTEGER"
                            + ", LAST_TIME TIMESTAMP"
                            + ", PRIMARY KEY(CLAIM_ID ,SYSTEM_BIND_PATH)"));
            tables.add(new BridgeFirebirdSeparateTable("CLAIM_DETAIL_DATE",
                    "CLAIM_ID INTEGER NOT NULL"
                            + ", SYSTEM_BIND_PATH INTEGER NOT NULL"
                            + ", DETAIL_VALUE TIMESTAMP"
                            + ", LAST_TIME TIMESTAMP"
                            + ", PRIMARY KEY(CLAIM_ID ,SYSTEM_BIND_PATH)"));
            tables.add(new BridgeFirebirdSeparateTable("CLAIM_DETAIL_TEXT",
                    "CLAIM_ID INTEGER NOT NULL"
                            + ", SYSTEM_BIND_PATH INTEGER NOT NULL"
                            + ", DETAIL_VALUE VARCHAR(600)"
                            + ", LAST_TIME TIMESTAMP"
                            + ", PRIMARY KEY(CLAIM_ID ,SYSTEM_BIND_PATH)"));
            separateTableManager.addSeparateTable("CLAIM_DETAIL", tables);

        }
        return separateTableManager;
    }

    /**
     * サービス取得区分に応じてSERVICE_USE_TYPEを特定するSQL文を返します。
     * <p>
     * 引数「取得区分」には以下の値を指定します。 <br />
     * 101-予定(SERVICE_DETAIL_GET_PLAN) <br />
     * 102-実績(SERVICE_DETAIL_GET_RESULT)<br/>
     * 103-予定の月間部分のみ(SERVICE_DETAIL_GET_PLAN_OF_MONTHLY_ONLY)
     * </p>
     * 
     * @param useType 取得区分
     * @return SERVICE_USE_TYPEを特定するSQL文
     */
    protected static String getServiceUseTypeSQLWithoutAnd(int useType) {
        switch (useType) {
        case QkanConstants.SERVICE_DETAIL_GET_PLAN:
            return " (SERVICE.SERVICE_USE_TYPE IN("
                    + QkanConstants.SERVICE_USE_TYPE_PLAN_MONTHLY_DAY + ", "
                    + QkanConstants.SERVICE_USE_TYPE_PLAN_MONTHLY_FREE_DAY
                    + ", " + QkanConstants.SERVICE_USE_TYPE_PLAN_WEEKLY_DAY
                    + ", "
                    + QkanConstants.SERVICE_USE_TYPE_PLAN_WEEKLY_FREE_DAY
                    + "))";
        case QkanConstants.SERVICE_DETAIL_GET_RESULT:
            return " (SERVICE.SERVICE_USE_TYPE IN("
                    + QkanConstants.SERVICE_USE_TYPE_RESULT_MONTHLY_DAY + ", "
                    + QkanConstants.SERVICE_USE_TYPE_RESULT_MONTHLY_FREE_DAY
                    + ", " + QkanConstants.SERVICE_USE_TYPE_RESULT_WEEKLY_DAY
                    + ", "
                    + QkanConstants.SERVICE_USE_TYPE_RESULT_WEEKLY_FREE_DAY
                    + "))";
        case QkanConstants.SERVICE_DETAIL_GET_PLAN_OF_MONTHLY_ONLY:
            return " (SERVICE.SERVICE_USE_TYPE IN("
                    + QkanConstants.SERVICE_USE_TYPE_PLAN_MONTHLY_DAY + ", "
                    + QkanConstants.SERVICE_USE_TYPE_PLAN_MONTHLY_FREE_DAY
                    + "))";
        case QkanConstants.SERVICE_DETAIL_GET_PLAN_OF_WEEKLY_ONLY:
            return " (SERVICE.SERVICE_USE_TYPE IN("
                    + QkanConstants.SERVICE_USE_TYPE_PLAN_WEEKLY_DAY + ", "
                    + QkanConstants.SERVICE_USE_TYPE_PLAN_WEEKLY_FREE_DAY
                    + "))";
        default:
            return " (SERVICE.SERVICE_USE_TYPE = " + useType + ")";
        }

    }

    /**
     * 特定診療費情報取得関数です。
     * <p>
     * 詳細情報が、特定診療費なのかどうかを判別するために使用します。 <br />
     * ※存在する場合は特定診療費マスタから識別番号と特定診療費名、単位数などを取得する。
     * </p>
     * 
     * @param dbm DBManager
     * @param systemBindPath 詳細種類
     * @param targetDate 対象年月日
     * @return 特定診療費情報。非該当ならばnull
     * @throws Exception 処理例外
     */
    protected static VRMap getSpecialClinicInfo(ACDBManager dbm,
            int systemBindPath, Date targetDate) throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.setTime(targetDate);
        String ym = VRDateParser.format(cal, "yyyy/MM/dd");

        StringBuilder sb;

        sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" M_SPECIAL_CLINIC.SPECIAL_CLINIC_TYPE,");
        sb.append(" M_SPECIAL_CLINIC.SPECIAL_CLINIC_HISTORY_ID,");
        sb.append(" M_SPECIAL_CLINIC.SPECIAL_CLINIC_NAME,");
        sb.append(" M_SPECIAL_CLINIC.SPECIAL_CLINIC_UNIT,");
        sb.append(" M_SPECIAL_CLINIC.SPECIAL_CLINIC_VALID_START,");
        sb.append(" M_SPECIAL_CLINIC.SPECIAL_CLINIC_VALID_END");
        sb.append(" FROM");
        sb.append(" M_SPECIAL_CLINIC,");
        sb.append(" M_SPECIAL_CLINIC_CONNECTION");
        sb.append(" WHERE");
        sb.append(" (M_SPECIAL_CLINIC_CONNECTION.DETAIL_PROPERTY = "
                + QkanConstants.SPECIAL_CLINIC_TYPE_SERVICE + ")");
        sb.append(" AND(M_SPECIAL_CLINIC_CONNECTION.SYSTEM_BIND_PATH = "
                + systemBindPath + ")");
        sb.append(" AND(M_SPECIAL_CLINIC.SPECIAL_CLINIC_TYPE = M_SPECIAL_CLINIC_CONNECTION.SPECIAL_CLINIC_TYPE)");
        sb.append(" AND(M_SPECIAL_CLINIC.SPECIAL_CLINIC_VALID_START <= '" + ym
                + "')");
        sb.append(" AND(M_SPECIAL_CLINIC.SPECIAL_CLINIC_VALID_END >= '" + ym
                + "')");

        if (dbm != null) {
            VRList ret = dbm.executeQuery(sb.toString());
            if (ret.getDataSize() > 0) {
                return (VRMap) ret.getData();
            }
        }
        return null;
    }

    /**
     * SQL発行結果の詳細情報を縦罫から横罫に変換してツリーマップに格納します。
     * 
     * @param result 格納先
     * @param src SQL文の結果
     * @param orderField 並び替えの基準となるフィールド名
     * @param shareFields 共通する親情報フィールド名の配列
     * @throws Exception 処理例外
     */
    protected static void restractureDetail(TreeMap result, VRList src,
            final String orderField, final String[] shareFields)
            throws Exception {
        Iterator it = src.iterator();
        while (it.hasNext()) {
            VRMap row = (VRMap) it.next();
            Object typeObj = VRBindPathParser.get(orderField, row);
            String type = String.valueOf(typeObj);

            // 基本情報
            VRMap adder;
            Object map = result.get(type);
            if (map == null) {
                adder = new VRHashMap();
                result.put(type, adder);
                VRBindPathParser.set(orderField, adder, typeObj);
                int end = shareFields.length;
                for (int i = 0; i < end; i++) {
                    VRBindPathParser.set(shareFields[i], adder,
                            VRBindPathParser.get(shareFields[i], row));
                }
            } else {
                adder = (VRMap) map;
            }

            Object path = VRBindPathParser.get("SYSTEM_BIND_PATH", row);
            if (path != null) {
                // SYSTEM_BIND_PATHがnullでない場合
                // キー+値
                VRBindPathParser.set(String.valueOf(path), adder,
                        VRBindPathParser.get("DETAIL_VALUE", row));
            }
        }
    }

    /**
     * 「利用者の当月の認定履歴のうち、申請中の履歴がないかチェックします。」に関する処理を行います。
     * 
     * @param ACDBManager dbm
     * @param Date targetDate 対象年月
     * @param int patientId 利用者ID
     * @return 申請中の履歴が存在しない場合true 存在する場合false
     * @throws Exception 処理例外
     */
    public static boolean isFullDecisionPatientInsureInfo(ACDBManager dbm,
            Date targetDate, int patientId) throws Exception {

        // 当月の要介護認定履歴を取得する。
        VRList list = QkanCommon.getPatientInsureInfoHistory(dbm, targetDate,
                patientId);

        if (list == null || list.size() < 1) {
            return false;
        }

        for (int i = 0; i < list.size(); i++) {
            VRMap record = (VRMap) list.get(i);
            int changeFlag = ACCastUtilities
                    .toInt(record.get("CHANGE_CODE"), 1);
            // 申請中の履歴があった場合はfalseを返す。
            if (changeFlag == 1) {
                return false;
            }
        }

        // 申請中の履歴が存在しない場合はtrueを返す。
        return true;

    }

    /**
     * 消費税率取得関数です。
     * <p>
     * 取得に失敗した場合、-1が返ります。
     * </p>
     * 
     * @param dbm DBManager
     * @return 消費税率
     * @throws Exception 処理例外
     */
    public static double getTax(ACDBManager dbm) throws Exception {
        try {
            VRList list = dbm.executeQuery("SELECT TAX FROM TAX");
            if (!list.isEmpty()) {
                return ACCastUtilities
                        .toDouble(
                                VRBindPathParser.get("TAX",
                                        (VRMap) list.getData()), -1);
            }
        } catch (SQLException ex) {
        }
        return -1;
    }

    /**
     * 消費税率設定関数です。
     * 
     * @param dbm DBManager
     * @return 消費税率
     * @throws Exception 処理例外
     */
    public static void setTax(ACDBManager dbm, double val) throws Exception {
        dbm.executeUpdate("UPDATE TAX SET TAX=" + val
                + ", LAST_TIME=CURRENT_TIMESTAMP");
    }


    /**
     * 外部連携用にプロパティファイルフォルダを設定して初期化します。
     * 
     * @param propertyXMLDir プロパティファイルフォルダ
     */
    public static void initializeForBackgroundCall(String propertyXMLDir) {
        QkanFrameEventProcesser fp = new QkanFrameEventProcesser();
        fp.setPropertyXMLPath(propertyXMLDir + "property.xml");
        ACFrame.getInstance().setFrameEventProcesser(fp);
        QkanCommon.debugInitialize();
    }

    /**
     * 外部連携用のDBマネージャを返します。
     * 
     * @return DBマネージャ
     * @throws Exception 処理例外
     */
    public static ACDBManager createDBManagerForBackgroundCall()
            throws Exception {
        return ((ACDBManagerCreatable) ACFrame.getInstance()
                .getFrameEventProcesser()).createDBManager();
    }

    /**
     * 外部連携用のシステムイベント処理クラスを返します。
     * 
     * @return システムイベント処理クラス
     */
    public static ACFrameEventProcesser getFrameEventProcesserForBackgroundCall() {
        return ACFrame.getInstance().getFrameEventProcesser();
    }

    /**
     * 法改正区分判定用の文字列を返却します。
     * 
     * @param systemServiceKindDetail
     * @param targetDate
     * @param dbm
     * @author Masahiko.Higuchi
     * @since V6.0.0
     * @return
     */
    public static String getServiceLowVersion(String systemServiceKindDetail,
            Date targetDate, ACDBManager dbm) throws Exception {
        String lowVersion = QkanCommon.getAffairLowVersion("", targetDate);

        switch (ACCastUtilities.toInt(systemServiceKindDetail)) {
        case 11111:// 訪問介護
            return lowVersion;
        case 11211:// 訪問入浴介護
            return lowVersion;
        case 11311:// 訪問看護(介護保険)
            return lowVersion;
        case 11411:// 訪問リハビリテーション
            return lowVersion;
        case 11511:// 通所介護
            return lowVersion;
        case 11611:// 通所リハビリテーション
            return lowVersion;
        case 11711:// 福祉用具貸与
            return lowVersion;
        case 12111:// 短期入所生活介護
            return lowVersion;
        case 12211:// 短期入所療養介護(老健)
            return lowVersion;
        case 12311:// 短期入所療養介護(療養病床を有する病院)
            return lowVersion;
        case 12312:// 短期入所療養介護(療養病床を有する診療所)
            return lowVersion;
        case 12313:// 短期入所療養介護(老人性認知症疾患療養病棟を有する病院)
            return lowVersion;
        case 12314:// 短期入所療養介護(基準適合診療所)
            return lowVersion;
        case 13111:// 居宅療養管理指導
            return lowVersion;
        case 13211:// 認知症対応型共同生活介護(短期利用以外)
            return lowVersion;
        case 13311:// 特定施設入居者生活介護
            return lowVersion;
        case 13611:// 地域密着型特定施設入居者生活介護
            return lowVersion;
        case 13811:// 認知症対応型共同生活介護(短期利用)
            return lowVersion;
        case 14311:// 居宅介護支援
            return lowVersion;
        case 15111:// 介護老人福祉施設
            return lowVersion;
        case 15211:// 介護老人保健施設
            return lowVersion;
        case 15311:// 介護療養型医療施設(療養病床を有する病院)
            return lowVersion;
        case 15312:// 介護療養型医療施設(療養病床を有する診療所)
            return lowVersion;
        case 15313:// 介護療養型医療施設(老人性認知症疾患療養病棟を有する病院)
            return lowVersion;
        case 15411:// 地域密着型介護福祉施設
            return lowVersion;
        case 17111:// 夜間対応型訪問介護
            return lowVersion;
        case 17211:// 認知症対応型通所介護
            return lowVersion;
        case 17311:// 小規模多機能型居宅介護（短期利用以外）
            return lowVersion;
        case 16811:// 小規模多機能型居宅介護（短期利用）[H27.4法改正対応] add
            return lowVersion;
        case 90101:// その他
            return lowVersion;
        case 90201:// 主な日常生活上の活動
            return lowVersion;
        case 16111: // 介護予防訪問介護
            return lowVersion;
        case 16211: // 介護予防訪問入浴介護
            return lowVersion;
        case 16311: // 介護予防訪問看護
            return lowVersion;
        case 16411: // 介護予防訪問リハ
            return lowVersion;
        case 16511: // 介護予防通所介護
            return lowVersion;
        case 16611: // 介護予防通所リハ
            return lowVersion;
        case 16711: // 介護予防福祉用具貸与
            return lowVersion;
        case 12411: // 介護予防短期入所生活介護
            return lowVersion;
        case 12511: // 介護予防短期入所療養介護（老健）
            return lowVersion;
        case 12611: // 介護予防短期入所療養介護（病院）
            return lowVersion;
        case 12612: // 介護予防短期入所療養介護（診療所）
            return lowVersion;
        case 12613: // 介護予防短期入所療養介護（認知症疾患型）
            return lowVersion;
        case 12614: // 介護予防短期入所療養介護（基準適合型診療所）
            return lowVersion;
        case 13411: // 介護予防居宅療養管理指導
            return lowVersion;
        case 13511: // 介護予防特定施設入居者生活介護
            return lowVersion;
        case 14611: // 介護予防支援
            return lowVersion;
        case 17411: // 介護予防認知症対応型通所介護
            return lowVersion;
        case 17511: // 介護予防小規模多機能型居宅介護（短期利用以外）
            return lowVersion;
        case 16911: // 介護予防小規模多機能型居宅介護（短期利用）[H27.4法改正対応] add
            return lowVersion;
        case 13711: // 介護予防認知症対応型共同生活介護（短期利用以外）
            return lowVersion;
        case 13911: // 介護予防認知症対応型共同生活介護（短期利用）
            return lowVersion;
        case 12711: // 特定施設入居者生活介護（短期利用）
            return lowVersion;
        case 17611: // 定期巡回・随時対応型訪問介護看護
            return lowVersion;
        case 12811: // 地域密着型特定施設入居者生活介護（短期利用）
            return lowVersion;
        case 17711: // 複合型サービス（短期利用以外）
            return lowVersion;
        case 17911: // 複合型サービス（短期利用）[H27.4法改正対応] add
            return lowVersion;
        }

        return lowVersion;
    }

    /**
     * 業務やパネルなどの法改正区分を判定し取得します。
     * 
     * @param className
     * @param targetDate
     * @return
     * @throws Exception
     */
    public static String getAffairLowVersion(String className, Date targetDate)
            throws Exception {
        // パネルで使用する文字列を返却する
        // パネルに応じて返却する文字列を変更できるように分岐させる
// 2014/1/9 [Yoichiro Kamei] edit - begin H27.4改正対応時
        //int lowVersion = QkanConstants.SERVICE_LOW_VERSION_H2404;
        int lowVersion = QkanConstants.SERVICE_LOW_VERSION_H2704;
// ここは切替テスト用
//        if (targetDate != null && ACDateUtilities.getDifferenceOnDay(QkanConstants.H2704, targetDate) < 1) {
//            lowVersion = QkanConstants.SERVICE_LOW_VERSION_H2704;
//        }
// 2014/1/9 [Yoichiro Kamei] edit - end
        String lowVersionString = ACCastUtilities.toString(lowVersion, "");
        lowVersionString = lowVersionString.substring(0, 6);

        if ("QS001S01".equals(className)) {
            return lowVersionString;
        } else if ("QS001S02".equals(className)) {
            return lowVersionString;
        }

        return lowVersionString;
    }
    
    /**
     * 妥当なデータベーススキーマのバージョンであるか判定します。
     * @param version M_QKAN_VERSION.SCHEME_VERSION
     * @return システムの運用に問題ないスキーマバージョンである場合true
     * @throws Exception
     */
    public static boolean isValidSchemaVersion(String version) throws Exception {
        
        if (ACTextUtilities.isNullText(version)){
            return false;
        }
        
        String[] ary = version.split("\\.");
        
        if (ary.length < 3) {
            return false;
        }
// 2015/4/17 [H27.4改正対応][Yoichiro Kamei] edit - begin
//        //メジャーバージョンが6未満は不正なスキーマ
//        if (ACCastUtilities.toInt(ary[0], 0) < 6) {
        //メジャーバージョンが7未満は不正なスキーマ
        if (ACCastUtilities.toInt(ary[0], 0) < 7) {
// 2015/4/17 [H27.4改正対応][Yoichiro Kamei] edit - end
            return false;
        }
        
        return true;
    }
    
    /**
     * 厚労省規定の支給限度額・外部利用型給付上限単位数を取得する
     * @param dbm
     * @param targetDate    対象年月
     * @param limitRateType 支給限度額区分（1:支給限度額、2:外部利用型）
     * @param jotaiCode     介護度
     * @throws Exception 処理例外
     * @return SQL文
     * 2014/01/24 [Shinobu Hitaka] 【2014.4 区分支給限度額改定対応】のため追加
     */
    public static int getOfficialLimitRate(ACDBManager dbm, Date targetDate, int limitRateType, String jotaiCode) throws Exception{
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(targetDate);
        String ym = VRDateParser.format(cal, "yyyy/MM");

        StringBuilder sb = new StringBuilder();

        //対象年月の開始終了日を設定
        String targetDateBegin = ym + "/01";
        String targetDateEnd = ym + "/" + cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        //SQL作成
        sb.append("SELECT");
        sb.append(" LIMIT_RATE_VALUE");
        sb.append(" FROM");
        sb.append(" M_LIMIT_RATE_DETAIL");
        sb.append(" WHERE");
        sb.append("     (M_LIMIT_RATE_DETAIL.JOTAI_CODE = " + jotaiCode + ")");
        sb.append(" AND (M_LIMIT_RATE_DETAIL.LIMIT_RATE_TYPE = " + ACCastUtilities.toString(limitRateType) + ")");
        sb.append(" AND (M_LIMIT_RATE_DETAIL.LIMIT_RATE_HISTORY_ID = ");
        sb.append(" (SELECT");
        sb.append("  MAX(M_LIMIT_RATE.LIMIT_RATE_HISTORY_ID)");
        sb.append("  FROM");
        sb.append("  M_LIMIT_RATE");
        sb.append("  WHERE");
        sb.append("      (M_LIMIT_RATE.LIMIT_RATE_TYPE =" + ACCastUtilities.toString(limitRateType) + ")");
        sb.append("  AND (M_LIMIT_RATE.LIMIT_RATE_VALID_START <='" + targetDateEnd + "')");
        sb.append("  AND (M_LIMIT_RATE.LIMIT_RATE_VALID_END >='" + targetDateBegin + "')");
        sb.append(" ))");
        
        VRList limitList = dbm.executeQuery(sb.toString());
        int limitRate = -1;
        if (!(limitList == null || limitList.size() == 0)) {
            limitRate = ACCastUtilities.toInt(VRBindPathParser.get(
                    "LIMIT_RATE_VALUE", (VRMap) limitList.get(0)));
        }
        return limitRate;
    }
    
// 2015/4/13 [H27.04改正対応][Yoichiro Kamei] add - begin 住所地特例対応
	private static final Integer JUSHOTI_TOKUREI_CATEGORY_NO = new Integer(18);
    /**
     * 明細情報（住所地特例）のバインドパスを明細情報のパスにコピーする
     * 
     * @param claimDataMap 処理対象のマップ
     * @throws Exception 処理例外
     */
	public static void convertPathJushotiTokureiToDetail(VRMap claimDataMap) throws Exception {
		// 明細情報（住所地特例）のバインドパスを明細情報のパスにコピー
		if (JUSHOTI_TOKUREI_CATEGORY_NO.equals(claimDataMap.getData("CATEGORY_NO"))) {
			VRBindPathParser.set("301001", claimDataMap, VRBindPathParser.get("1801001", claimDataMap));
			VRBindPathParser.set("301002", claimDataMap, VRBindPathParser.get("1801002", claimDataMap));
			VRBindPathParser.set("301003", claimDataMap, VRBindPathParser.get("1801003", claimDataMap));
			VRBindPathParser.set("301004", claimDataMap, VRBindPathParser.get("1801004", claimDataMap));
			VRBindPathParser.set("301005", claimDataMap, VRBindPathParser.get("1801005", claimDataMap));
			VRBindPathParser.set("301006", claimDataMap, VRBindPathParser.get("1801006", claimDataMap));
			VRBindPathParser.set("301007", claimDataMap, VRBindPathParser.get("1801007", claimDataMap));
			VRBindPathParser.set("301008", claimDataMap, VRBindPathParser.get("1801008", claimDataMap));
			VRBindPathParser.set("301009", claimDataMap, VRBindPathParser.get("1801009", claimDataMap));
			VRBindPathParser.set("301010", claimDataMap, VRBindPathParser.get("1801010", claimDataMap));
			VRBindPathParser.set("301011", claimDataMap, VRBindPathParser.get("1801011", claimDataMap));
			VRBindPathParser.set("301012", claimDataMap, VRBindPathParser.get("1801012", claimDataMap));
			VRBindPathParser.set("301013", claimDataMap, VRBindPathParser.get("1801013", claimDataMap));
			VRBindPathParser.set("301014", claimDataMap, VRBindPathParser.get("1801014", claimDataMap));
			VRBindPathParser.set("301015", claimDataMap, VRBindPathParser.get("1801015", claimDataMap));
			VRBindPathParser.set("301016", claimDataMap, VRBindPathParser.get("1801016", claimDataMap));
			VRBindPathParser.set("301017", claimDataMap, VRBindPathParser.get("1801017", claimDataMap));
			VRBindPathParser.set("301018", claimDataMap, VRBindPathParser.get("1801019", claimDataMap));
			VRBindPathParser.set("301019", claimDataMap, VRBindPathParser.get("1801020", claimDataMap));
			VRBindPathParser.set("301020", claimDataMap, VRBindPathParser.get("1801021", claimDataMap));
			VRBindPathParser.set("301021", claimDataMap, VRBindPathParser.get("1801022", claimDataMap));
			VRBindPathParser.set("301022", claimDataMap, VRBindPathParser.get("1801023", claimDataMap));
		}
	}
	
    /**
     * 明細情報（住所地特例）レコードについて、変換しているバインドパスを元に戻す
     * 
     * @param claimDataMap 処理対象のマップ
     * @throws Exception 処理例外
     */
	public static void convertPathJushotiTokureiToOriginal(VRMap claimDataMap) throws Exception {
		
		if (JUSHOTI_TOKUREI_CATEGORY_NO.equals(claimDataMap.getData("CATEGORY_NO"))) {
			//明細情報（住所地特例）レコードについて、変換しているバインドパスを元に戻す
			VRBindPathParser.set("1801001", claimDataMap, VRBindPathParser.get("301001", claimDataMap));
			VRBindPathParser.set("1801002", claimDataMap, VRBindPathParser.get("301002", claimDataMap));
			VRBindPathParser.set("1801003", claimDataMap, VRBindPathParser.get("301003", claimDataMap));
			VRBindPathParser.set("1801004", claimDataMap, VRBindPathParser.get("301004", claimDataMap));
			VRBindPathParser.set("1801005", claimDataMap, VRBindPathParser.get("301005", claimDataMap));
			VRBindPathParser.set("1801006", claimDataMap, VRBindPathParser.get("301006", claimDataMap));
			VRBindPathParser.set("1801007", claimDataMap, VRBindPathParser.get("301007", claimDataMap));
			VRBindPathParser.set("1801008", claimDataMap, VRBindPathParser.get("301008", claimDataMap));
			VRBindPathParser.set("1801009", claimDataMap, VRBindPathParser.get("301009", claimDataMap));
			VRBindPathParser.set("1801010", claimDataMap, VRBindPathParser.get("301010", claimDataMap));
			VRBindPathParser.set("1801011", claimDataMap, VRBindPathParser.get("301011", claimDataMap));
			VRBindPathParser.set("1801012", claimDataMap, VRBindPathParser.get("301012", claimDataMap));
			VRBindPathParser.set("1801013", claimDataMap, VRBindPathParser.get("301013", claimDataMap));
			VRBindPathParser.set("1801014", claimDataMap, VRBindPathParser.get("301014", claimDataMap));
			VRBindPathParser.set("1801015", claimDataMap, VRBindPathParser.get("301015", claimDataMap));
			VRBindPathParser.set("1801016", claimDataMap, VRBindPathParser.get("301016", claimDataMap));
			VRBindPathParser.set("1801017", claimDataMap, VRBindPathParser.get("301017", claimDataMap));
			VRBindPathParser.set("1801019", claimDataMap, VRBindPathParser.get("301018", claimDataMap));
			VRBindPathParser.set("1801020", claimDataMap, VRBindPathParser.get("301019", claimDataMap));
			VRBindPathParser.set("1801021", claimDataMap, VRBindPathParser.get("301020", claimDataMap));
			VRBindPathParser.set("1801022", claimDataMap, VRBindPathParser.get("301021", claimDataMap));
			VRBindPathParser.set("1801023", claimDataMap, VRBindPathParser.get("301022", claimDataMap));
			
			// 明細情報レコードのバインドパスを除く
			claimDataMap.removeData("301001");
			claimDataMap.removeData("301002");
			claimDataMap.removeData("301003");
			claimDataMap.removeData("301004");
			claimDataMap.removeData("301005");
			claimDataMap.removeData("301006");
			claimDataMap.removeData("301007");
			claimDataMap.removeData("301008");
			claimDataMap.removeData("301009");
			claimDataMap.removeData("301010");
			claimDataMap.removeData("301011");
			claimDataMap.removeData("301012");
			claimDataMap.removeData("301013");
			claimDataMap.removeData("301014");
			claimDataMap.removeData("301015");
			claimDataMap.removeData("301016");
			claimDataMap.removeData("301017");
			claimDataMap.removeData("301018");
			claimDataMap.removeData("301019");
			claimDataMap.removeData("301020");
			claimDataMap.removeData("301021");
			claimDataMap.removeData("301022");
		}
	}
// 2015/4/13 [H27.04改正対応] add - end
	

}