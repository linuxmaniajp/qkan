package jp.nichicom.ac.lib.care.claim.print.schedule;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.lib.care.claim.servicecode.Qkan10011_ServiceCodeManager;
import jp.nichicom.ac.lib.care.claim.servicecode.Qkan10011_ServiceUnitGetter;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanValidServiceCommon;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.logging.VRLogger;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.text.QkanServiceAbbreviationFormat;

/**
 * サービス単位計算クラスです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/02/21
 */
public class CareServiceCodeCalcurater {

    /**
     * 給付管理対象を表す計算モード定数です。
     */
    public static final int CALC_MODE_IN_LIMIT_AMOUNT = 1;

    /**
     * 給付管理対象外を表す計算モード定数です。
     */
    public static final int CALC_MODE_OUT_LIMIT_AMOUNT = 2;

    /**
     * 外部利用型を表す計算モード定数です。
     */
    public static final int CALC_MODE_OUTER_SERVICE_LIMIT_AMOUNT = 3;

    /**
     * 給付管理対象もしくは外部利用型を表す計算モード定数です。
     */
    public static final int CALC_MODE_IN_LIMIT_AMOUNT_OR_OUTER_SERVICE = 4;

    /**
     * 制限なしを表す計算モード定数です。
     */
    public static final int CALC_MODE_FREE = 0;

    private boolean calcWithPublicExpense;

    private ACDBManager dbm;

    private VRMap hashedAreaUnitPrices;

    private VRMap hashedProviders;

    private Map hashedProviderServices = new HashMap();

    private VRMap hashedServiceKinds;

    private int inSpecialFacilityFlag;

    private int patientID;

    private VRMap patientInfo;

    private VRList patientInsureInfoHistoryList;

    private HashMap publicExpenseMap = new HashMap();

    private VRList serviceKindsList;

    private Date targetDate;

    private final DecimalFormat UNIT_PRICE_FORMAT = new DecimalFormat("##.00");

    private boolean oncePerMonthOfAddEmergencyNursingAndSpecialManagement = true;

    /**
     * 対象の利用者が旧措置入所者であるかをあらわすフラグ を返します。
     * 
     * @return 対象の利用者が旧措置入所者
     */
    public int getOldFacilityUserFlag() {
        return oldFacilityUserFlag;
    }

    /**
     * 対象の利用者が旧措置入所者であるかをあらわすフラグ を設定します。
     * 
     * @param oldFacilityUserFlag 対象の利用者が旧措置入所者であるかをあらわすフラグ
     */
    public void setOldFacilityUserFlag(int oldFacilityUserFlag) {
        this.oldFacilityUserFlag = oldFacilityUserFlag;
    }

    /**
     * 緊急時訪問看護加算・特別管理加算は月1回算定とするか を返します。
     * <p>
     * デフォルトはtrueです。
     * </p>
     * 
     * @return 緊急時訪問看護加算・特別管理加算は月1回算定とするか
     */
    public boolean isOncePerMonthOfAddEmergencyNursingAndSpecialManagement() {
        return oncePerMonthOfAddEmergencyNursingAndSpecialManagement;
    }

    /**
     * 緊急時訪問看護加算・特別管理加算は月1回算定とするか を設定します。
     * <p>
     * デフォルトはtrueです。
     * </p>
     * 
     * @param oncePerMonthOfAddEmergencyNursingAndSpecialManagement
     *            緊急時訪問看護加算・特別管理加算は月1回算定とするか
     */
    public void setOncePerMonthOfAddEmergencyNursingAndSpecialManagement(
            boolean oncePerMonthOfAddEmergencyNursingAndSpecialManagement) {
        this.oncePerMonthOfAddEmergencyNursingAndSpecialManagement = oncePerMonthOfAddEmergencyNursingAndSpecialManagement;
    }

    /**
     * コンストラクタです。
     */
    public CareServiceCodeCalcurater() {
        super();
    }

    /**
     * サービスコードのマスタ上でユニークなキーを文字列表現で返します。
     * 
     * @param code サービスコード
     * @param mode 支給限度額内を対象としたキャッシュキーか
     * @return ユニークキー
     * @throws Exception 処理例外
     */
    // [ID:0000615][Shin Fujihara] 2010/08/18 edit begin
    // public String getServiceCodeUniqueKey(Map code, int mode) throws
    // Exception{
    public String getServiceCodeUniqueKey(Map code, int mode, Map service)
            throws Exception {
        return ACCastUtilities.toString(mode)
                + " "
                + ACCastUtilities.toString(code
                        .get("SYSTEM_SERVICE_KIND_DETAIL"))
                + " "
                + ACCastUtilities
                        .toString(code.get("SYSTEM_SERVICE_CODE_ITEM"))
                + " "
                + ACCastUtilities.toString(service.get("PROVIDER_ID")
                        // [ID:0000734][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 add begin
                        + " "
                        + ACCastUtilities.toString(CareServiceCommon
                                .is30DayOver((VRMap) service))
                        // [ID:0000734][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 add end
                        );

        // + ACCastUtilities.toString(code.get("SERVICE_CODE_KIND")) + " "
        // + ACCastUtilities.toString(code.get("SERVICE_CODE_ITEM"));
    }

    // [ID:0000615][Shin Fujihara] 2010/08/18 edit end
    /**
     * 「サービス単位計算」に関する処理を行ないます。
     * 
     * @param code サービスコード
     * @param mode 除外モード
     * @param service サービス
     * @param totalGroupingCache 月/日単位算定キャシュ
     * @throws Exception 処理例外
     * @return int 単位数
     */
    public int getServiceUnit(Map code, int mode, Map service,
            Map[] totalGroupingCache) throws Exception {
        if (code != null) {

            String group = ACCastUtilities.toString(
                    code.get("TOTAL_GROUPING_TYPE"), "1");
            if (!isOncePerMonthOfAddEmergencyNursingAndSpecialManagement()) {
                // 緊急時訪問看護加算および特別管理加算を1月算定としない場合
                if (CareServiceCommon.isAddEmergencyNursing(code)
                        || CareServiceCommon.isAddSpecialManagement(code)) {
                    // 緊急時訪問看護加算もしくは特別管理加算の場合
                    // 回単位の算定とする。
                    group = "1";
                }
            }

            if ("2".equals(group)) {
                // 日単位
                if ((totalGroupingCache != null)
                        && (totalGroupingCache.length >= 1)
                        && (totalGroupingCache[0] != null)) {
                    Object date = service.get("SERVICE_DATE");
                    if (date instanceof Date) {
                        // [ID:0000615][Shin Fujihara] 2010/08/18 edit begin
                        // Object key = getServiceCodeUniqueKey(code, mode);
                        Object key = getServiceCodeUniqueKey(code, mode,
                                service);
                        // [ID:0000615][Shin Fujihara] 2010/08/18 edit end
                        Object obj = totalGroupingCache[0].get(key);
                        if (obj instanceof Date) {
                            if (ACDateUtilities.getDifferenceOnDay((Date) obj,
                                    (Date) date) == 0) {
                                // 同日既出につき算定しない
                                return 0;
                            }
                        }
                        // key:サービスコード、val:提供日
                        totalGroupingCache[0].put(key, date);
                    }
                }
            } else if ("3".equals(group)) {
                // 月単位
                if ((totalGroupingCache != null)
                        && (totalGroupingCache.length >= 2)
                        && (totalGroupingCache[1] != null)) {
                    // [ID:0000615][Shin Fujihara] 2010/08/18 edit begin
                    // Object key = getServiceCodeUniqueKey(code, mode);
                    Object key = getServiceCodeUniqueKey(code, mode, service);
                    // [ID:0000615][Shin Fujihara] 2010/08/18 edit end
                    Object obj = totalGroupingCache[1].get(key);
                    if (obj instanceof Date) {
                        // 既出につき算定しない
                        return 0;
                    } else {
                        // key:サービスコード、val:提供日
                        totalGroupingCache[1].put(key,
                                service.get("SERVICE_DATE"));
                    }
                }
            }

            // 管理限度対象をあらわす定数
            if (!QkanConstants.SERVICE_KIND_LIFE_CARE_AT_SPECIAL_FACILITIY
                    .equals(ACCastUtilities.toString(code
                            .get("SERVICE_CODE_KIND")))) {
                // 特定施設入所者に関するコードは除外

                // 給付管理限度額対象フラグを取得する。
                // 0：食費等、単位数で管理しないサービス
                // 1：給付管理限度額対象
                // 2：給付管理限度額対象外

                switch (mode) {
                case CALC_MODE_IN_LIMIT_AMOUNT:
                    // 給付管理限度額対象に限定する場合
                    if (!CareServiceCommon.isInLimitAmount(code)) {
                        // 給付管理限度額対象ではない場合
                        return 0;
                    }
                    break;
                case CALC_MODE_OUT_LIMIT_AMOUNT:
                    // 給付管理限度額対象外に限定する場合
                    if (!CareServiceCommon.isOutLimitAmount(code)) {
                        // 給付管理限度額対象の場合
                        return 0;
                    }
                    break;
                case CALC_MODE_OUTER_SERVICE_LIMIT_AMOUNT:
                    // 外部利用型に限定する場合
                    if (!CareServiceCommon.isOuterServiceLimitAmount(code)) {
                        // 給付管理限度額対象の場合
                        return 0;
                    }
                    break;
                case CALC_MODE_IN_LIMIT_AMOUNT_OR_OUTER_SERVICE:
                    // 給付管理限度対象もしくは外部利用型に限定する場合
                    if (!(CareServiceCommon.isInLimitAmount(code) || CareServiceCommon
                            .isOuterServiceLimitAmount(code))) {
                        // 給付管理限度額対象の場合
                        return 0;
                    }
                    break;
                }

                // 管理対象サービスコードに限定していないかもしくは給付管理限度額対象のサービスコードの場合
                // 該当サービス提供により給付される単位数を取得する。
                return ACCastUtilities.toInt(code.get("SERVICE_UNIT"), 0);
            }
        }
        // 合算を返す。
        return 0;
    }

    /**
     * 「サービス単位計算」に関する処理を行ないます。
     * 
     * @param codes List サービスコード集合
     * @param mode 計算モード
     * @param reductRate 割引率
     * @param service サービス
     * @param totalGroupingCache 月/日単位算定キャシュ
     * @throws Exception 処理例外
     * @return int
     */
    public int getServiceUnit(List codes, int mode, int reductRate,
            Map service, Map[] totalGroupingCache) throws Exception {
        // 合算を0で初期化する。
        int total = 0;
        // 管理限度対象をあらわす定数

        if (codes != null) {
            Iterator it = codes.iterator();
            while (it.hasNext()) {
                // サービスコードの単位算定項目を全走査する。
                VRMap code = (VRMap) it.next();

                int unit = getServiceUnit(code, mode, service,
                        totalGroupingCache);
                total += getReductedServiceCodeUnit(code, unit, total,
                        reductRate);
            }
        }
        // 合算を返す。
        return (int) total;
    }

    /**
     * サービスコードの演算結果を返します。
     * 
     * @param code 対象のサービスコード
     * @param codeUnit 対象サービスコードの単位フィールドの値
     * @param total ここまでの合算
     * @return 演算後の合算
     * @throws Exception 処理例外
     */
    public int getServiceCodeUnit(Map code, int codeUnit, long total)
            throws Exception {

        if (code != null) {
            // 該当サービス提供により給付される単位数を取得する。

            // サービス加算フラグを取得する。
            Object add = code.get("SERVICE_ADD_FLAG");

            // サービス加算フラグをチェックする。
            switch (ACCastUtilities.toInt(add, 0)) {
            case 1: // 1:単位の場合
            case 2:// 2:単位加算の場合
                   // 合算に単位数を加算する。
                return codeUnit;
            case 3:// 3:％加算の場合
                   // 合算に単位数を乗算し、100で割った単位数%を加算する。
                return (int) Math.round(total * codeUnit / 100.0);
            case 4:// 4:単位減算の場合
                   // 合算に単位数を減算する。
                   // ※マスタ上に負の値で格納されている
                return codeUnit;
            case 5:// 5:％減算の場合
                   // 合算に単位数を乗算し、100で割った単位数%を減算する。
                return (int) -Math.round(total * codeUnit / 100.0);
            case 9:// 9:円の場合
                   // 円の加算は認めない
                return 0;
            }
        }
        return codeUnit;
    }

    /**
     * サービスコードの演算結果に割引率をかけて返します。
     * 
     * @param code 対象のサービスコード
     * @param codeUnit 対象サービスコードの単位フィールドの値
     * @param total ここまでの合算
     * @param reductRate 割引率
     * @return 演算後の合算
     * @throws Exception 処理例外
     */
    public int getReductedServiceCodeUnit(Map code, int codeUnit, long total,
            int reductRate) throws Exception {
        return toReductedUnit(getServiceCodeUnit(code, codeUnit, total),
                reductRate);
    }

    /**
     * 「サービス単位計算」に関する処理を行ないます。
     * 
     * @param service サービス
     * @param check30Over 30日超を0単位と見なすか
     * @param totalGroupingCache 月/日単位算定キャシュ
     * @throws Exception 処理例外
     * @return int 単位
     */
    public int getServiceUnit(VRMap service, boolean check30Over,
            Map[] totalGroupingCache) throws Exception {
        if (check30Over && CareServiceCommon.is30DayOver(service)) {
            // 引数の30日超除外(remove30Over)が真でかつ引数のサービスも30日超に該当していれば、0を返す。
            return 0;
        }
        // 同名の関数を間接的に呼び出してサービス単位を返す。

        return getServiceUnit(getServiceCodes(service),
                CALC_MODE_IN_LIMIT_AMOUNT,
                getReductRate(getProviderID(service), service), service,
                totalGroupingCache);
    }

    /**
     * 「サービス単位計算」に関する処理を行ないます。
     * 
     * @param service サービス
     * @param check30Over 30日超を0単位と見なすか
     * @param code サービスコード
     * @param mode 計算モード
     * @throws Exception 処理例外
     * @return int 単位
     */
    public int getServiceCodeUnitField(VRMap service, boolean check30Over,
            Map code, int mode, Map[] totalGroupingCache) throws Exception {
        if (check30Over && CareServiceCommon.is30DayOver(service)) {
            // 引数の30日超除外(remove30Over)が真でかつ引数のサービスも30日超に該当していれば、0を返す。
            return 0;
        }
        // 同名の関数を間接的に呼び出してサービス単位を返す。

        return getServiceUnit(code, mode, service, totalGroupingCache);
    }

    /**
     * 「サービス単位計算」に関する処理を行ないます。
     * 
     * @param service サービス
     * @param check30Over 30日超を0単位と見なすか
     * @param code サービスコード
     * @throws Exception 処理例外
     * @return int 単位
     */
    public int getServiceUnit(VRMap service, boolean check30Over, Map code,
            Map[] totalGroupingCache) throws Exception {
        return getServiceCodeUnitField(service, check30Over, code,
                CALC_MODE_IN_LIMIT_AMOUNT, totalGroupingCache);
    }

    /**
     * サービス種類をもとに、保険給付と公費のうち適切な給付率を返します。
     * 
     * @param insureRate 保険給付率
     * @param serviceKind サービス種類
     * @param provider 事業所
     * @return 給付率
     * @throws Exception 処理例外
     */
    public int checkPublicExpense(int insureRate, Object serviceKind,
            Map provider) throws Exception {
        if (isCalcWithPublicExpense()) {
            int pe = getPublicExpense(ACCastUtilities.toInt(serviceKind, 0),
                    provider);
            if (pe > 0) {
                // 公費で支払う
                insureRate = pe;
            }
        }
        return insureRate;
    }

    /**
     * 対象の利用者が特定入居者であるかをあらわすフラグ を返します。
     * 
     * @return 対象の利用者が特定入居者であるかをあらわすフラグ
     */
    public int getInSpecialFacilityFlag() {
        return inSpecialFacilityFlag;
    }

    private int oldFacilityUserFlag;

    /**
     * 保険者情報を返します。
     * 
     * @param insurerID 保険者番号
     * @return 保険者情報
     * @throws Exception 処理例外
     */
    public Map getInsurerInfo(String insurerID) throws Exception {
        VRList insurers = QkanCommon.getInsurerInfo(getDBManager(), insurerID);
        if (!insurers.isEmpty()) {
            return (VRMap) insurers.getData();
        }
        return null;
    }

    /**
     * 当月の最終日付を返します。
     * 
     * @return 当月の最終日付
     */
    public Date getLastDayOfMonth() {
        return ACDateUtilities.toLastDayOfMonth(getTargetDate());
    }

    /**
     * 当月初日の曜日を返します。
     * 
     * @return 当月初日の曜日
     */
    public int getDayOfWeekOnTargetFirstDay() {
        return ACDateUtilities.getDayOfWeek(ACDateUtilities
                .toFirstDayOfMonth(getTargetDate()));
    }

    /**
     * 利用者のフルネームを返します。
     * 
     * @return 利用者のフルネーム
     * @throws Exception 処理例外
     */
    public String getPatientFullName() throws Exception {
        return QkanCommon.toFullName(
                ACCastUtilities.toString(getPatientInfo().get(
                        "PATIENT_FAMILY_NAME")),
                ACCastUtilities.toString(getPatientInfo().get(
                        "PATIENT_FIRST_NAME")));
    }

    /**
     * 利用者情報を返します。
     * 
     * @return 利用者情報
     * @throws Exception 処理例外
     */
    public VRMap getPatientInfo() throws Exception {
        if (patientInfo == null) {
            VRList list = QkanCommon.getPatientInfo(getDBManager(),
                    getPatientID());
            if (!list.isEmpty()) {
                patientInfo = (VRMap) list.getData();
            }
        }
        return patientInfo;
    }

    /**
     * 当月の要介護認定履歴 を返します。
     * 
     * @return 当月の要介護認定履歴
     */
    public VRList getPatientInsureInfoHistoryList() {
        return patientInsureInfoHistoryList;
    }

    /**
     * 対象年月日から該当する要介護認定履歴を返します。
     * 
     * @param date 対象年月
     * @return 要介護認定履歴
     * @throws Exception 処理例外
     */
    public VRMap getPatientInsureInfoOnTargetDay(Date date) throws Exception {
        return QkanCommon.getPatientInsureInfoOnTargetDay(
                getPatientInsureInfoHistoryList(), date);
    }

    /**
     * 事業所情報を返します。
     * 
     * @param providerID 事業所番号
     * @return 事業所情報
     * @throws Exception 処理例外
     */
    public Map getProvider(String providerID) throws Exception {
        Object obj = getHashedProviders().get(providerID);
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    /**
     * 事業所情報を返します。
     * 
     * @param service サービス
     * @return 事業所情報
     * @throws Exception 処理例外
     */
    public Map getProvider(VRMap service) throws Exception {
        return getProvider(getProviderID(service));
    }

    /**
     * 事業所IDを返します。
     * 
     * @param service サービス
     * @return 事業所ID
     * @throws Exception 処理例外
     */
    public String getProviderID(Map service) throws Exception {
        return ACCastUtilities.toString(service.get("PROVIDER_ID"));
    }

    /**
     * 事業所名を返します。
     * 
     * @param service サービス
     * @return 事業所名
     * @throws Exception 処理例外
     */
    public String getProviderName(VRMap service) throws Exception {
        Map val = getProvider(service);
        if (val != null) {
            return ACCastUtilities.toString((val).get("PROVIDER_NAME"));
        }
        return "";
    }

    /**
     * 事業所提供サービスを返します。
     * 
     * @param providerID 事業所ID
     * @param service サービス
     * @return 事業所提供サービス
     * @throws Exception 処理例外
     */
    public Map getProviderService(String providerID, Map service)
            throws Exception {
        return getProviderService(providerID,
                service.get("SYSTEM_SERVICE_KIND_DETAIL"));
    }

    /**
     * 事業所提供サービスを返します。
     * 
     * @param providerID 事業所ID
     * @param serviceKind サービス種類
     * @return 事業所提供サービス
     * @throws Exception 処理例外
     */
    public Map getProviderService(String providerID, Object serviceKind)
            throws Exception {
        // 事業所提供サービスをキャッシュから取得
        String key = providerID + "-" + ACCastUtilities.toString(serviceKind);
        Map providerService = null;
        Object val = getHashedProviderServices().get(key);
        if (val instanceof Map) {
            providerService = (Map) val;
        } else {
            // キャッシュになければ取得
            List list = QkanCommon.getProviderServiceDetail(getDBManager(),
                    providerID, ACCastUtilities.toInt(serviceKind, 0));
            if (!list.isEmpty()) {
                providerService = (Map) list.get(0);
                getHashedProviderServices().put(key, providerService);
            }
        }
        return providerService;
    }

    /**
     * 事業所提供サービスを返します。
     * 
     * @param service サービス
     * @return 事業所提供サービス
     * @throws Exception 処理例外
     */
    public Map getProviderService(VRMap service) throws Exception {
        Map provider = getProvider(service);
        if (provider != null) {
            return getProviderService(getProviderID(provider), service);
        }
        return null;
    }

    /**
     * 割引率演算後のサービス単位を返します。
     * 
     * @param service サービス
     * @param check30Over 30日超を0単位と見なすか
     * @param totalGroupingCache 月/日単位算定キャッシュ
     * @param 計算モード
     * @throws Exception 処理例外
     * @return int 割引率演算後のサービス単位
     */
    public int getReductedUnit(VRMap service, boolean check30Over, int mode,
            Map[] totalGroupingCache) throws Exception {
        if (check30Over && CareServiceCommon.is30DayOver(service)) {
            // 引数の30日超除外(remove30Over)が真でかつ引数のサービスも30日超に該当していれば、0を返す。
            return 0;
        }
        // 割引率
        int reductRate = getReductRate(getProviderService(service));
        if (reductRate > 0) {
            List codes = getServiceCodes(service);
            return getServiceUnit(codes, mode, reductRate, service,
                    totalGroupingCache);
        }
        return 0;
    }

    /**
     * サービス種類ごとに集計した結果を返します。
     * 
     * @param services サービス集合
     * @param mode 計算モード
     * @return 集計結果
     * @throws Exception
     */
    public CareServiceUnitCalcurateResult getServiceUnitCalcurateResult(
            VRList services, int mode) throws Exception {

        VRMap serviceMaster = QkanServiceAbbreviationFormat.getInstance()
                .getMasterService();
        TreeMap sorter = new TreeMap();

        Map[] totalGroupingCache = new Map[] { new HashMap(), new HashMap() };
        Iterator it = services.iterator();
        while (it.hasNext()) {
            // サービスコードデータを取得
            VRMap service = (VRMap) it.next();
            int reductedUnit = getReductedUnit(service, true, mode,
                    totalGroupingCache);
            
            // [CCCX:1626][Shinobu Hitaka] 2014/05/08 replace begin 減算の単位数対応（定期巡回通所利用減算・複合型訪問看護など）
            //if (reductedUnit > 0) {
            if (reductedUnit != 0) {
            // [CCCX:1626][Shinobu Hitaka] 2014/05/08 replace begin 減算の単位数対応

                // 管理対象内のサービスのみ以降の処理を実行する
                Object key = service.getData("SYSTEM_SERVICE_KIND_DETAIL");
                Object order = key;
                if (serviceMaster != null) {
                    Object obj = serviceMaster.get(ACCastUtilities.toInteger(
                            key, 0));
                    if (obj instanceof Map) {
                        // サービスのソート順に置換
                        obj = ((Map) obj).get("SERVICE_SORT");
                        if (obj != null) {
                            order = obj;
                        }
                    }
                }
                Object obj = sorter.get(order);
                VRMap val;
                int adjustPoint = 0;
                if (obj instanceof VRMap) {
                    // 既出なら特定完了
                    val = (VRMap) obj;
                    reductedUnit += ACCastUtilities.toInt(val.getData("UNIT"),
                            0);
                    adjustPoint += ACCastUtilities.toInt(val.getData("ADJUST"),
                            0);
                } else {
                    // 新規なら生成して代入
                    val = new VRHashMap();
                    sorter.put(order, val);
                    val.setData("SYSTEM_SERVICE_KIND_DETAIL", key);
                }

                adjustPoint += ACCastUtilities.toInt(
                        service.getData("REGULATION_RATE"), 0);
                val.setData("UNIT", new Integer(reductedUnit));
                val.setData("ADJUST", new Integer(adjustPoint));
                val.setData("RESULT", new Integer(reductedUnit - adjustPoint));
            }
        }

        return new CareServiceUnitCalcurateResult(sorter.values());
    }

    /**
     * 事業所提供サービスの割引率を返します。
     * <p>
     * 割引率が設定されていなければ0が返ります。
     * </p>
     * 
     * @param providerService 事業所提供サービス
     * @return 割引率
     */
    public int getReductRate(Map providerService) {
        if (providerService != null) {
            // 割引率
            return 100 - ACCastUtilities.toInt(
                    providerService.get("REDUCT_RATE"), 0);
        }
        return 0;
    }

    /**
     * 事業所提供サービスの割引率を返します。
     * <p>
     * 割引率が設定されていなければ0が返ります。
     * </p>
     * 
     * @param providerID 事業所ID
     * @param service サービス
     * @throws Exception 処理例外
     * @return 割引率
     */
    public int getReductRate(String providerID, Map service) throws Exception {
        return getReductRate(getProviderService(providerID, service));
    }

    /**
     * 割引率後の単位数を返します。
     * 
     * @param providerID 事業所ID
     * @param code サービスコード
     * @param unit
     * @throws Exception 処理例外
     * @return 割引率
     */
    public int getReductedUnit(String providerID, Map code, int unit)
            throws Exception {
        int reductRate = getReductRate(providerID, code);
        if (reductRate < 100) {
            unit = toReductedUnit(unit, reductRate);
        }
        return unit;
    }

    /**
     * サービス種類名を返します。
     * 
     * @param service サービス
     * @return サービス種類名
     */
    public String getServiceKindName(VRMap service) {
        if (service != null) {
            Object kind = getHashedServiceKinds().get(
                    service.get("SYSTEM_SERVICE_KIND_DETAIL"));
            if (kind instanceof Map) {
                return ACCastUtilities.toString(
                        ((Map) kind).get("SERVICE_KIND_NAME"), "");
            }
        }
        return "";
    }

    /**
     * 帳票に印字するサービスコードを文字列表現で返します。
     * 
     * @param serviceCode サービスコード
     * @return サービスコード
     * @throws Exception 処理例外
     */
    public String getTextOfServiceCode(Map serviceCode) throws Exception {
        return ACTextUtilities.trim(ACCastUtilities.toString(serviceCode
                .get("SERVICE_CODE_KIND")))
                + ACTextUtilities.trim(ACCastUtilities.toString(serviceCode
                        .get("SERVICE_CODE_ITEM")));
    }

    /**
     * 対象年月を「～月分」に書式化した文字列表現を返します。
     * 
     * @return 対象年月
     * @throws Exception 処理例外
     */
    public String getTextOfTargetYearMonth() throws Exception {
        return ACConstants.FORMAT_FULL_ERA_YM.format(getTargetDate()) + "分";
    }

    /**
     * 帳票印字用の単位数単価の文字列表現を返します。
     * 
     * @param unitPrice 単位数単価
     * @return 単位数単価
     */
    public String getTextOfUnitPrice(double unitPrice) {
        return UNIT_PRICE_FORMAT.format(unitPrice);
    }

    /**
     * 地域単価を返します。
     * 
     * @param serviceKindDetail サービス種類
     * @param provider 事業所
     * @return 地域単価
     * @throws Exception 処理例外
     */
    public double getUnitPrice(Object serviceKindDetail, Map provider)
            throws Exception {
        Object val = getHashedAreaUnitPrices().get(serviceKindDetail);
        if (val instanceof Map) {
            val = ((Map) val).get(provider.get("PROVIDER_AREA_TYPE"));
            if ((val instanceof List) && (!((List) val).isEmpty())) {
                val = ((List) val).get(0);
                if (val instanceof Map) {
                    return ACCastUtilities.toDouble(((Map) val)
                            .get("UNIT_PRICE_VALUE"));
                }
            }
        }
        VRLogger.info("該当する地域単価が存在しません。[" + serviceKindDetail + "-"
                + provider.get("PROVIDER_AREA_TYPE") + "]");
        // デフォルトの10.0を返却する。
        return 10.0;
    }

    /**
     * 必用情報を初期化します。
     * 
     * @param targetDate 対象年月
     * @param patientInfo 利用者情報
     * @param patientInsureInfoHistoryList 当月の要介護認定履歴
     * @param hashedProviders 事業者IDでハッシュ化した事業者集合
     * @param dbm DBManager
     * @param serviceKinds サービス種類集合
     * @param inSpecialFacilityFlag 特定入居者であるかをあらわすフラグ
     * @parm oldFaclityUserFlag 旧措置入所者であるかをあらわすフラグ
     * @throws Exception 処理例外
     */
    public void initialize(Date targetDate, VRMap patientInfo,
            VRList patientInsureInfoHistoryList, VRMap hashedProviders,
            ACDBManager dbm, VRList serviceKinds, int inSpecialFacilityFlag,
            int oldFacilityUserFlag) throws Exception {
        setTargetDate(targetDate);
        setDBManager(dbm);
        setPatientInfo(patientInfo);
        setPatientID(ACCastUtilities.toInt(patientInfo.get("PATIENT_ID")));
        setPatientInsureInfoHistoryList(patientInsureInfoHistoryList);
        setHashedProviders(hashedProviders);
        setInSpecialFacilityFlag(inSpecialFacilityFlag);
        setOldFacilityUserFlag(oldFacilityUserFlag);
        setServiceKindsList(serviceKinds);
        VRMap map = new VRHashMap();
        ACBindUtilities.setMapFromArray(serviceKinds, map,
                "SYSTEM_SERVICE_KIND_DETAIL");
        setHashedServiceKinds(map);
        getHashedProviderServices().clear();
    }

    /**
     * 公費給付率も含めて計算するか を返します。
     * 
     * @return 公費給付率も含めて計算するか
     */
    public boolean isCalcWithPublicExpense() {
        return calcWithPublicExpense;
    }

    /**
     * 特定施設入居者に関するコードであるかを返します。
     * 
     * @param code サービスコード
     * @return 特定施設入居者に関するコードであるか
     * @throws Exception 処理例外
     */
    public boolean isInSpecialFacility(Map code) throws Exception {
        if (QkanConstants.SERVICE_KIND_LIFE_CARE_AT_SPECIAL_FACILITIY
                .equals(ACCastUtilities.toString(code.get("SERVICE_CODE_KIND")))) {
            // 特定施設入所者に関するコードは除外
            return true;
        }
        return false;
    }

    /**
     * 特定施設入居者に関するコードかもしくは空であるかを返します。
     * 
     * @param codes サービスコード集合
     * @return 特定施設入居者に関するコードかもしくは空であるか
     * @throws Exception 処理例外
     */
    public boolean isInSpecialFacilityOrBlank(List codes) throws Exception {
        if (codes.isEmpty()) {
            // 空
            return true;
        }
        return isInSpecialFacility((Map) codes.get(0));
    }

    /**
     * 対象の利用者が特定入居者であるかをあらわすフラグ を設定します。
     * 
     * @param inSpecialFacilityFlag 対象の利用者が特定入居者であるかをあらわすフラグ
     */
    public void setInSpecialFacilityFlag(int inSpecialFacilityFlag) {
        this.inSpecialFacilityFlag = inSpecialFacilityFlag;
    }

    /**
     * 利用者情報 を設定します。
     * 
     * @param patientInfo 利用者情報
     */
    public void setPatientInfo(VRMap patientInfo) {
        this.patientInfo = patientInfo;
    }

    /**
     * 割引後の単位数を返します。
     * 
     * @param unit 単位
     * @param reductRate 割引率
     * @return 割引後の単位数
     */
    public int toReductedUnit(int unit, int reductRate) {
        if (reductRate < 100) {
            if (unit > 0) {
                // 単位数が負の値(減算)は割り引かない

                // 割引後の率%は100より小さい(割り引く)
                reductRate = Math.max(reductRate, 0);
                // 四捨五入
                return (int) Math.round(unit * reductRate / 100.0);
            }
        }
        return unit;
    }

    /**
     * DBManager を返します。
     * 
     * @return DBManager
     */
    public ACDBManager getDBManager() {
        return dbm;
    }

    /**
     * ハッシュ化された地域区分別単位単価情報 を返します。
     * 
     * @return ハッシュ化された地域区分別単位単価情報
     * @throws Exception 処理例外
     */
    protected Map getHashedAreaUnitPrices() throws Exception {
        if (hashedAreaUnitPrices == null) {

            StringBuilder sb = new StringBuilder();
            // 地域単価をハッシュ化して取得
            sb.append("SELECT");
            sb.append(" M_AREA_UNIT_PRICE.SYSTEM_SERVICE_KIND_DETAIL");
            sb.append(",M_AREA_UNIT_PRICE.UNIT_PRICE_TYPE");
            sb.append(",M_AREA_UNIT_PRICE.UNIT_PRICE_VALUE");
            sb.append(" FROM");
            sb.append(" M_AREA_UNIT_PRICE");
            sb.append(" WHERE");
            String targetDateText = ACConstants.FORMAT_SQL_FULL_YMD
                    .format(getTargetDate());
            sb.append(" (M_AREA_UNIT_PRICE.UNIT_VALID_START <= "
                    + targetDateText + ")");
            sb.append(" AND(M_AREA_UNIT_PRICE.UNIT_VALID_END >= "
                    + targetDateText + ")");
            sb.append(" ORDER BY");
            sb.append(" SYSTEM_SERVICE_KIND_DETAIL");
            sb.append(",UNIT_PRICE_TYPE");
            VRList list = getDBManager().executeQuery(sb.toString());
            // サービス種類でハッシュ化
            VRMap fullMap = new VRHashMap();
            ACBindUtilities.setHashListFromArray(list, fullMap,
                    "SYSTEM_SERVICE_KIND_DETAIL");
            // 地域区分でハッシュ化
            VRMap convedMap = new VRHashMap();
            Iterator it = fullMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                VRMap map = new VRHashMap();
                ACBindUtilities.setHashListFromArray((VRList) ent.getValue(),
                        map, "UNIT_PRICE_TYPE");
                convedMap.put(ent.getKey(), map);
            }
            // 内部変数に転記
            hashedAreaUnitPrices = convedMap;

        }
        return hashedAreaUnitPrices;
    }

    /**
     * 事業所番号でハッシュ化した事業所集合 を返します。
     * 
     * @return 事業所番号でハッシュ化した事業所集合
     */
    public VRMap getHashedProviders() {
        return hashedProviders;
    }

    /**
     * "事業所ID"+"サービス種類"でハッシュ化された事業所提供サービス を返します。
     * 
     * @return ハッシュ化された事業所提供サービス集合
     */
    protected Map getHashedProviderServices() {
        return hashedProviderServices;
    }

    /**
     * サービス種類でハッシュ化したサービス種類集合 を返します。
     * 
     * @return サービス種類集合
     */
    protected VRMap getHashedServiceKinds() {
        return hashedServiceKinds;
    }

    /**
     * patientID を返します。
     * 
     * @return patientID
     */
    public int getPatientID() {
        return patientID;
    }

    /**
     * 指定サービスに適用される公費支給率を返します。
     * 
     * @param serviceKind サービス種類
     * @param provider 事業所
     * @return 公費支給率
     * @throws Exception 処理例外
     */
    protected int getPublicExpense(int serviceKind, Map provider)
            throws Exception {
        Integer key = new Integer(serviceKind);
        Object val = publicExpenseMap.get(key);
        if (val instanceof Integer) {
            return ((Integer) val).intValue();
        }

        // boolean filterMedicalProvider = (provider != null)
        // && ("0".equals(ACCastUtilities.toString(provider
        // .get("MEDICAL_FLAG"))));

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" PATIENT_KOHI.BENEFIT_RATE");
        sb.append(" FROM");
        sb.append(" PATIENT_KOHI");
        sb.append(" LEFT JOIN");
        sb.append(" M_KOHI_SERVICE");
        sb.append(" ON");
        sb.append(" (M_KOHI_SERVICE.KOHI_TYPE=PATIENT_KOHI.KOHI_TYPE)");
        sb.append(" AND(M_KOHI_SERVICE.SYSTEM_SERVICE_KIND_DETAIL=M_KOHI_SERVICE.SYSTEM_SERVICE_KIND_DETAIL)");

        sb.append(" WHERE");
        sb.append(" (PATIENT_KOHI.PATIENT_ID = ");
        sb.append(getPatientID());
        sb.append(")");
        sb.append(" AND(M_KOHI_SERVICE.SYSTEM_SERVICE_KIND_DETAIL=");
        sb.append(serviceKind);
        sb.append(")");
        sb.append(" AND(PATIENT_KOHI.INSURE_TYPE = 1) ");

        // -- 有効期間をチェックするSQL文 開始----------------------------------------
        // 有効期間内もしくはかぶっているパターンは複数あり、そのいずれか一つに該当すれば許容する
        sb.append(" AND(");

        String targetDateBegin = VRDateParser.format(getTargetDate(),
                "yyyy-MM-01");
        String targetDateEnd = VRDateParser
                .format(ACDateUtilities.toLastDayOfMonth(getTargetDate()),
                        "yyyy-MM-dd");

        sb.append(" (");
        // 1.有効期間開始日が対象年月以前の場合
        sb.append(" (PATIENT_KOHI.KOHI_VALID_START <= '" + targetDateEnd + "')");
        // 1-1.かつ有効期間終了日は対象年月の初日と同じか超えているならば期間がかぶるのでOK
        sb.append(" AND(PATIENT_KOHI.KOHI_VALID_END >= '" + targetDateBegin
                + "')");

        sb.append(" )OR(");

        // 2.有効期間開始日が対象年月内ならば期間がかぶるのでOK
        sb.append(" (PATIENT_KOHI.KOHI_VALID_START <= '" + targetDateBegin
                + "')");
        sb.append(" AND(PATIENT_KOHI.KOHI_VALID_START >= '" + targetDateEnd
                + "')");
        sb.append(" )");

        sb.append(" )");
        // -- 有効期間をチェックするSQL文 終了----------------------------------------

        // [ID:0000469][Tozo TANAKA] 2009/03/27 add begin 平成21年4月法改正対応(請求)
        sb.append(" AND(");
        // 1.公費マスタの有効期間開始日が対象年月以前の場合
        sb.append(" (M_KOHI_SERVICE.KOHI_SERVICE_VALID_START <= '"
                + targetDateEnd + "')");
        // 1-1.かつ公費マスタの有効期間終了日は対象年月の初日と同じか超えている場合
        sb.append(" AND(M_KOHI_SERVICE.KOHI_SERVICE_VALID_END >= '"
                + targetDateBegin + "')");
        sb.append(" )");
        // 別表に記載されるサービス提供費と緊急時施設療養管理を対象とした公費の場合
        sb.append(" AND(M_KOHI_SERVICE.APPLICATION_TYPE IN(1,2))");
        // [ID:0000469][Tozo TANAKA] 2009/03/27 add end

        sb.append(" ORDER BY");
        sb.append(" BENEFIT_RATE");
        sb.append(" DESC");
        VRList list = getDBManager().executeQuery(sb.toString());

        int result = 0;
        if (!list.isEmpty()) {
            Object obj = ((Map) list.getData()).get("BENEFIT_RATE");
            if (obj instanceof Integer) {
                result = ((Integer) obj).intValue();
            }
        }
        publicExpenseMap.put(key, new Integer(result));
        return result;
    }

    /**
     * サービス種類でハッシュ化した公費給付率マップ を返します。
     * 
     * @return サービス種類でハッシュ化した公費給付率マップ
     */
    protected HashMap getPublicExpenseMap() {
        return publicExpenseMap;
    }

    /**
     * 「サービスコード生成」に関する処理を行ないます。
     * 
     * @param service VRMap
     * @throws Exception 処理例外
     * @return List
     */
    protected List getServiceCodes(VRMap service) throws Exception {
        VRMap row = new VRHashMap(service);
        // サービス対象年月日を取得する。
        Date serviceDate = ACCastUtilities.toDate(row.getData("SERVICE_DATE"),
                null);
        if (serviceDate == null) {
            return new ArrayList();
        }
        // サービス対象年月日から該当する要介護認定履歴を取得する。
        VRMap history = QkanCommon.getPatientInsureInfoOnTargetDay(
                getPatientInsureInfoHistoryList(), serviceDate);
        if ((history == null) || (history.isEmpty())) {
            return new ArrayList();
        }
        // 該当する要介護度を取得する。
        Object jotaiCode = history.getData("JOTAI_CODE");
        if (ACCastUtilities.toInt(jotaiCode, 1) == 1) {
            // 非該当の場合はサービスコードを返さない
            return new ArrayList();
        }
        row.setData(Qkan10011_ServiceUnitGetter.YOKAIGODO, jotaiCode);
        // 事業所番号から対応する事業所を取得する。
        Object provider = getHashedProviders().get(row.getData("PROVIDER_ID"));
        if (provider instanceof VRMap) {
            // 該当する事業所の特別地域有無を取得する。
            row.setData(Qkan10011_ServiceUnitGetter.TOKUCHI_KASAN,
                    ((VRMap) provider).getData("SPECIAL_AREA_FLAG"));
            // [ID:0000445][Masahiko Higuchi] 2009/02 add begin 平成21年4月法改正対応
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
                    // [ID:0000682] 2012/01 start 介護職員処遇改善加算の追加処理
                    if (CareServiceCommon.getProviderSyogukaizenValue(providerServiceInfo) > 1) {
                        // 介護職員処遇改善加算あり
                        row.setData(
                                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN,
                                CareServiceCommon
                                        .getProviderSyogukaizenValue(providerServiceInfo));
                    }
                    // [ID:0000682] 2012/01 end
                }
            }
            // [ID:0000445][Masahiko Higuchi] 2009/02 add end

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

        // [ID:0000734][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 add begin
        // 一度コピーして参照状態を切る
        ArrayList<VRMap> baseCodeList = Qkan10011_ServiceCodeManager.getInstance()
                .getServiceCode(kind, (HashMap) row, serviceDate,
                        getDBManager());
        ArrayList<VRMap> result = new ArrayList<VRMap>();
        for (int i = 0; i < baseCodeList.size(); i++) {
            VRMap rec = baseCodeList.get(i);
            result.add(QkanValidServiceCommon.deepCopyVRMap(rec));
        }
        // [ID:0000734][Masahiko.Higuchi] 2012/04 add end

        return result;
    }

    /**
     * サービス種類集合を返します。
     * 
     * @return サービス種類集合
     */
    public VRList getServiceKindsList() {
        return serviceKindsList;
    }

    /**
     * targetDate を返します。
     * 
     * @return targetDate
     */
    public Date getTargetDate() {
        return targetDate;
    }

    /**
     * 公費給付率も含めて計算するか を設定します。
     * 
     * @param calcWithPublicExpense 公費給付率も含めて計算するか
     */
    protected void setCalcWithPublicExpense(boolean calcWithPublicExpense) {
        this.calcWithPublicExpense = calcWithPublicExpense;
    }

    /**
     * DBManager を設定します。
     * 
     * @param dbm DBManager
     */
    protected void setDBManager(ACDBManager dbm) {
        this.dbm = dbm;
    }

    /**
     * ハッシュ化された地域区分別単位単価情報 を設定します。
     * 
     * @param hashedAreaUnitPrices ハッシュ化された地域区分別単位単価情報
     */
    protected void setHashedAreaUnitPrices(VRMap hashedAreaUnitPrices) {
        this.hashedAreaUnitPrices = hashedAreaUnitPrices;
    }

    /**
     * 事業所番号でハッシュ化した事業所集合 を設定します。
     * 
     * @param hashedProviders 事業所番号でハッシュ化した事業所集合
     */
    protected void setHashedProviders(VRMap hashedProviders) {
        this.hashedProviders = hashedProviders;
    }

    /**
     * "事業所ID"+"サービス種類"でハッシュ化された事業所提供サービス を設定します。
     * 
     * @param hashedProviderServices ハッシュ化された事業所提供サービス集合
     */
    protected void setHashedProviderServices(HashMap hashedProviderServices) {
        this.hashedProviderServices = hashedProviderServices;
    }

    /**
     * サービス種類でハッシュ化したサービス種類集合 を設定します。
     * 
     * @param hashedServiceKinds サービス種類集合
     */
    protected void setHashedServiceKinds(VRMap hashedServiceKinds) {
        this.hashedServiceKinds = hashedServiceKinds;
    }

    /**
     * patientID を設定します。
     * 
     * @param patientID patientID
     */
    protected void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    /**
     * 当月の要介護認定履歴 を設定します。
     * 
     * @param patientInsureInfoHistoryList 当月の要介護認定履歴
     */
    protected void setPatientInsureInfoHistoryList(
            VRList patientInsureInfoHistoryList) {
        this.patientInsureInfoHistoryList = patientInsureInfoHistoryList;
    }

    /**
     * サービス種類でハッシュ化した公費給付率マップ を設定します。
     * 
     * @param publicExpenseMap サービス種類でハッシュ化した公費給付率マップ
     */
    protected void setPublicExpenseMap(HashMap publicExpenseMap) {
        this.publicExpenseMap = publicExpenseMap;
    }

    /**
     * サービス種類集合を設定します。
     * 
     * @param serviceKindsList サービス種類集合
     */
    protected void setServiceKindsList(VRList serviceKindsList) {
        this.serviceKindsList = serviceKindsList;
    }

    /**
     * 対象年月 を設定します。
     * 
     * @param targetDate 対象年月
     */
    protected void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

}
