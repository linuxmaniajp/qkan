package jp.nichicom.ac.lib.care.claim.print.schedule;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.core.ACDBManagerCreatable;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.calculation.QP001SpecialCase;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanValidServiceCommon;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanValidServiceManager;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.text.ACBorderBlankDateFormat;
import jp.nichicom.ac.text.ACKanaConvert;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.text.QkanJotaiCodeUnapplicableFormat;

/**
 * サービス予定・実績の帳票印刷管理クラスです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/03/31
 */
public class CareServiceSchedulePrintManager extends HashMap {

    /**
     * 保険給付額をあらわす添字定数です。
     */
    public final static int INDEX_OF_INSURE_COST = 6;
    /**
     * 区分支給限度基準内単位数をあらわす添字定数です。
     */
    public final static int INDEX_OF_LIMIT_IN_UNIT = 4;
    /**
     * 区分支給限度基準を超える単位数をあらわす添字定数です。
     */
    public final static int INDEX_OF_LIMIT_OVER_UNIT = 3;
    /**
     * 区分支給限度基準を超える単位数の内容別小計をあらわす添字定数です。
     */
    public final static int INDEX_OF_LIMIT_OVER_UNIT_FOR_DETAIL = 2;
    /**
     * サービス単位/金額をあらわす添字定数です。
     */
    public final static int INDEX_OF_SERVICE_UNIT = 1;
    /**
     * サービス単位/金額の内容別小計をあらわす添字定数です。
     */
    public final static int INDEX_OF_SERVICE_UNIT_FOR_DETAIL = 0;
    /**
     * 30日超となる利用者自己負担をあらわす添字定数です。
     */
    public final static int INDEX_OF_USER_COST_ON_30OVER = 9;
    /**
     * 別表用の配列個数定数です。
     */
    public final static int INDEX_OF_TOTAL_ARRAY_SIZE = 10;
    /**
     * 費用総額をあらわす添字定数です。
     */
    public final static int INDEX_OF_TOTAL_COST = 5;
    /**
     * 利用者負担（全額対象分）をあらわす添字定数です。
     */
    public final static int INDEX_OF_USER_COST_ON_FULL = 8;
    /**
     * 利用者負担（保険対象分）をあらわす添字定数です。
     */
    public final static int INDEX_OF_USER_COST_ON_INSURE = 7;
    /**
     * 直後に小計を出力すべき明細をあらわすサービス内容状態定数です。
     */
    public final static int ITEM_STATE_MULTI_LAST = 3;
    /**
     * 明細をあらわすサービス内容状態定数です。
     */
    public final static int ITEM_STATE_MULTI_NOT_LAST = 2;
    /**
     * 給付管理対象限度額外をあらわすサービス内容状態定数です。
     */
    public final static int ITEM_STATE_OUT_LIMIT_AMOUNT = 4;
    /**
     * 小計を含む明細をあらわすサービス内容状態定数です。
     */
    public final static int ITEM_STATE_SINGLE = 1;

    private CareServiceCodeCalcurater calcurater;

    /**
     * 事業所単位に分割して出力するか
     */
    private boolean buildDivedProvider = true;
    /**
     * 施設系サービスを本表に印刷するか
     */
    private boolean printFacilities;
    /**
     * グループホーム/特定施設系サービスを本表に印刷するか
     */
    private boolean printLifeCare;
    /**
     * 本票の自費に△を記載するか
     */
    private boolean printTriangle;
    /**
     * 居宅療養管理指導を本表に印刷するか
     */
    private boolean printHomeMedicalAdvice = false;
    // [H27.4改正対応][Shinobu Hitaka] 2015/3/16 add - begin
    /**
     * 特別地域加算・小規模事業所加算を本表に印刷するか
     */
    private boolean printSpecialArea = false;
    /**
     * 中山間地域等提供加算を本表に印刷するか
     */
    private boolean printChusankanArea = false;
    /**
     * 介護職員処遇改善加算を本表に印刷するか
     */
    private boolean printSyoguKaizen = false;
    // [H27.4改正対応][Shinobu Hitaka] 2015/3/16 add - end

    private boolean subParse = true;

    private int targetDayShortStayCount;

    private int userMainTableRowCount = 14;
    
    // [ID:0000745][Masahiko.Higuchi] 処遇改善加算を含む計算対応 add - begin
    // 外部から無理矢理デバッグモードに設定するフラグ
    private boolean ultimateDebugFlag = false;
    // [ID:0000745][Masahiko.Higuchi] add - end

    //2006/06/09 tozo TANAKA begin-replace 別表法改正のため
    //private int userSubTableRowCount = 17;
    //2006/06/09 tozo TANAKA end-replace 別表法改正のため
    
    // [H27.4改正対応][Shinobu Hitaka] 2015/1/23 edit - begin 別表様式変更
    private int userSubTableRowCount = 19;
    // [H27.4改正対応][Shinobu Hitaka] 2015/1/23 edit - end    
    
    // [ID:0000682] 2012/01 start 介護職員処遇改善加算の追加処理
    private Map<String,Integer> regulationHash = null; // 自己負担額
    private Map<String,Integer> diagnosisHash = null; //特定診療費・特別療養費
    // [ID:0000682] 2012/01 end
    // [ID:0000734][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 add begin
    private VRMap over30UnitSyoguHash = null; //30日超の処遇改善対象単位数ハッシュ
    // [ID:0000734][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 add end
    
    // [2014年要望][Shinobu Hitaka] 2014/10/23 add begin 敬称表示
    private String printKeisyo = "";
    // [2014年要望][Shinobu Hitaka] 2014/10/23 add end   敬称表示
    
    private ACBorderBlankDateFormat yearMonthFormat = new ACBorderBlankDateFormat(
            "ggge年MM月");

    // [H27.4改正対応][Yoichiro Kamei] 2015/4/3 add - begin サービス提供体制加算の自己負担対応
    private SelfPaymentNumberCalcurater selfPaymentNumberCalcurater;
    // [H27.4改正対応][Yoichiro Kamei] 2015/4/3 add - end
    
// 2016/7/19 [総合事業対応][Yoichiro Kamei] add - begin
    private int jigyotaishoLimitRate; // 事業対象者のときに表示する区分支給限度額
    private static final Date MAX_DATE = ACCastUtilities.toDate("9999/12/31", null);
    
    // 事業対象者の国基準の区分支給限度額を取得します
    private int getJigyotaishoLimitRate() throws Exception {
        if (jigyotaishoLimitRate > 0) {
            return jigyotaishoLimitRate;
        }
        Date targetDate = getCalcurater().getTargetDate();
        jigyotaishoLimitRate = QkanCommon.getOfficialLimitRate(getCalcurater().getDBManager(),
                targetDate, new Integer(1), String.valueOf(QkanConstants.YOUKAIGODO_JIGYOTAISHO));
        
        return jigyotaishoLimitRate;
    }
// 2016/7/19 [総合事業対応][Yoichiro Kamei] add - end
    
    /**
     * 本票の自費に△を記載するか を返します。
     * 
     * @return 本票の自費に△を記載するか
     */
    protected boolean isPrintTriangle() {
        return printTriangle;
    }

    /**
     * 本票の自費に△を記載するか を設定します。
     * 
     * @param printTriangle 本票の自費に△を記載するか
     */
    protected void setPrintTriangle(boolean printTriangle) {
        this.printTriangle = printTriangle;
    }

    /**
     * コンストラクタです。
     */
    public CareServiceSchedulePrintManager() {
        super();
    }

    /**
     * サービスを追加解析します。
     * 
     * @param services サービス
     * @param subParse 別表情報としても解析するか
     * @throws Exception 処理例外
     */
    public int addParse(List services, boolean subParse) throws Exception {
        setSubParse(subParse);

        // 2008/06/01 [Masahiko.Higuchi] add - begin 2007年度対応
        /*  
         * 月途中で要支援→要介護の場合の
         * 定額報酬サービス→日割サービスへの変換処理
         **/
        QkanValidServiceCommon parser = new QkanValidServiceCommon();
        // データベースマネージャを生成する。
        ACDBManager dbm = ((ACDBManagerCreatable)ACFrame.getInstance().getFrameEventProcesser()).createDBManager();
        // データのクローンを作成する。
        VRList cloneServices = new VRArrayList();
        cloneServices.addAll(services);
        services = new ArrayList();
        if(cloneServices != null && !cloneServices.isEmpty()){
            // 対象日付
            Date targetDate = getCalcurater().getTargetDate();
            // 変換解析処理
            services = parser.createValidService(dbm, targetDate,
                    cloneServices, getCalcurater().getPatientID());
        }
        // 2008/06/01 [Masahiko.Higuchi] add - end 
        
        
        // [ID:0000734][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 add begin
        // 30日超のサービスは後ろに持ってくる
        ArrayList<VRMap> baseList = new ArrayList<VRMap>();
        ArrayList<VRMap> over30List = new ArrayList<VRMap>();
        for(int i=0; i < services.size(); i++) {
            VRMap service = (VRMap)services.get(i);
            if(CareServiceCommon.is30DayOver(service)) {
                over30List.add(service);
            } else {
                baseList.add(service);
            }
        }
        services = new ArrayList();
        services.addAll(baseList);
        services.addAll(over30List);
        // [ID:0000734][Masahiko.Higuchi] 2012/04 add end
        
        // [H27.4改正対応][Yoichiro Kamei] 2015/4/3 add - begin サービス提供体制加算の自己負担対応
        this.selfPaymentNumberCalcurater = new SelfPaymentNumberCalcurater(getCalcurater(), services);
        // [H27.4改正対応][Yoichiro Kamei] 2015/4/3 add - end
        
        int shortStayCount = 0;
        // 保険者番号-被保険者番号の階層以下にサービス情報の階層を構築する。
        // サービスが0件ならば、要介護認定履歴の階層だけが構築される。
        Iterator it = services.iterator();
        while (it.hasNext()) {
            VRMap service = (VRMap) it.next();

            // TODO デバッグモード begin ★★★★★★★★★★★★★★★★★
            if(isDebugMode()){
               
            }else{
            //TODO デバッグモード end ★★★★★★★★★★★★★★★★★★
            
            if (CareServiceCommon.isFacility(service)
                    && !isPrintFacilityService()) {
                // 施設系を出力しない設定ならばスキップ
                continue;
            }
            if (CareServiceCommon.isLifeCare(service) && !isPrintLifeCare()) {
                // グループホームとケアハウスを出力しない設定ならばスキップ
                continue;
            }
            if (CareServiceCommon.isCareManagement(service)) {
                // 居宅介護支援はスキップ
                continue;
            }
            if (CareServiceCommon.isHomeMedicalAdvice(service)&& !isPrintHomeMedicalAdvice()) {
                // 居宅療養管理指導を出力しない設定ならばスキップ
                continue;
            }
            
            // TODO デバッグモード begin ★★★★★★★★★★★★★★★★★
            }
            //TODO デバッグモード end ★★★★★★★★★★★★★★★★★★

            Date date = ACCastUtilities.toDate(service.get("SERVICE_DATE"),
                    null);
            if (date != null) {
                // サービス提供日は必須
                // サービス対象年月日から該当する要介護認定履歴を取得する。
                VRMap insureInfo = getCalcurater()
                        .getPatientInsureInfoOnTargetDay(date);
                if (insureInfo != null) {
                    Object key = insureInfo.get("INSURER_ID");
                    if (ACTextUtilities.isNullText(key)) {
                        // 保険者番号なしなら無視
                        continue;
                    }
                    Object val = CareServiceSchedulePrintManager.this.get(key);
                    DivedInsurer page;
                    // 保険者番号で分岐
                    if (val instanceof DivedInsurer) {
                        page = (DivedInsurer) val;
                    } else {
                        page = new DivedInsurer();
                        CareServiceSchedulePrintManager.this.put(key, page);
                    }
                    // 同一保険者番号内で分類
                    page.parse(service, insureInfo);
                }

                // [ID:0000764][Masahiko.Higuchi] edit - begin 30日超の別表印字障害対応
                if (CareServiceCommon.isShortStay(service) && !CareServiceCommon.is30DayOver(service)) {
                // [ID:0000764][Masahiko.Higuchi] edit - end
                    shortStayCount++;
                }
            }
        }
        //2次解析
        parseSubSecond();
        setSubParse(true);
        return shortStayCount;
    }
    
    /**
     * %加算等に対応するため、別表用の2段階解析を行います。
     * @throws Exception 処理例外
     */
    protected void parseSubSecond() throws Exception{
        Iterator it = CareServiceSchedulePrintManager.this.entrySet().iterator();
        while (it.hasNext()) {
            ((DivedInsurer) ((Map.Entry) it.next()).getValue()).parseSubSecond();
        }
    }

    /**
     * 利用票本表を構築します。
     * 
         * @param buildParam 印字内容集合
     * @param insuredPageList 被保険者別ページ集合
     * @throws Exception 処理例外
     * @return 1件以上データがあるか
     */
    public boolean buildUserMainTable(CareServicePrintParameter buildParam, List insuredPageList)
            throws Exception {
        
        VRMap formPage = createUserMainTablePageFormat(buildParam);
        buildParam.setFormPage(formPage);

        boolean exists = false;
        Iterator it = CareServiceSchedulePrintManager.this.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry ent = (Map.Entry) it.next();
            DivedInsurer services = (DivedInsurer) ent.getValue();
            // 下位情報構築
            exists |= services.buildUserMainTable(buildParam, insuredPageList);
        }
        return exists;
    }

    /**
     * 利用票別表を構築します。
     * 
         * @param buildParam 印字内容集合
     * @param insuredPageList 被保険者別ページ集合
     * @throws Exception 処理例外
     * @return 1件以上データがあるか
     */
    public boolean buildUserSubTable(CareServicePrintParameter buildParam, List insuredPageList) throws Exception {
        VRMap formPage = createUserSubTablePageFormat(buildParam);
        buildParam.setFormPage(formPage);

        boolean exists = false;
        Iterator it = CareServiceSchedulePrintManager.this.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry ent = (Map.Entry) it.next();
            DivedInsurer services = (DivedInsurer) ent.getValue();
            // 下位情報構築
            exists |= services.buildUserSubTable(buildParam, insuredPageList);
        }
        return exists;
    }

    /**
     * 1つめのサービス情報を返します。
     * 
     * @return 1つめのサービス情報
     */
    public VRMap getFirstService() {
        if (CareServiceSchedulePrintManager.this.size() > 0) {
            return ((DivedInsurer) CareServiceSchedulePrintManager.this.values()
                    .iterator().next()).getFirstService();
        }
        return null;
    }

    /**
     * 必用情報を初期化します。
     * 
     * @param calcurater サービス単位計算クラス
     * @throws Exception 処理例外
     */
    public void initialize(CareServiceCodeCalcurater calcurater)
            throws Exception {
        setCalcurater(calcurater);
        CareServiceSchedulePrintManager.this.clear();

        // グループホーム/特定施設を本表に記載するかの設定をチェック
        if (ACFrame.getInstance().hasProperty(
                "PrintConfig/NinchishoTokuteiShisetsu")) {
            setPrintLifeCare(!"0".equals(ACFrame.getInstance().getProperty(
                    "PrintConfig/NinchishoTokuteiShisetsu")));
        } else {
            setPrintLifeCare(true);
        }

        // 施設系を本表に記載するかの設定をチェック
        if (ACFrame.getInstance().hasProperty("PrintConfig/ShisetsuService")) {
            setPrintFacilities(!"0".equals(ACFrame.getInstance().getProperty(
                    "PrintConfig/ShisetsuService")));
        } else {
            setPrintFacilities(true);
        }

        // 居宅療養管理指導を本表に記載するかの設定をチェック
        if (ACFrame.getInstance().hasProperty("PrintConfig/HomeMedicalAdvice")) {
            setPrintHomeMedicalAdvice(!"0".equals(ACFrame.getInstance().getProperty(
                    "PrintConfig/HomeMedicalAdvice")));
        } else {
            setPrintHomeMedicalAdvice(false);
        }

        // 特別地域加算・小規模事業所加算を本表に記載するかの設定をチェック
        if (ACFrame.getInstance().hasProperty("PrintConfig/PrintSpecialArea")) {
            setPrintSpecialArea(!"0".equals(ACFrame.getInstance().getProperty(
                    "PrintConfig/PrintSpecialArea")));
        } else {
            setPrintHomeMedicalAdvice(false);
        }
        
        // 中山間地域等提供加算を本表に記載するかの設定をチェック
        if (ACFrame.getInstance().hasProperty("PrintConfig/PrintChusankanArea")) {
            setPrintChusankanArea(!"0".equals(ACFrame.getInstance().getProperty(
                    "PrintConfig/PrintChusankanArea")));
        } else {
            setPrintHomeMedicalAdvice(false);
        }
        
        // 介護職員処遇改善加算を本表に記載するかの設定をチェック
        if (ACFrame.getInstance().hasProperty("PrintConfig/PrintSyoguKaizen")) {
            setPrintSyoguKaizen(!"0".equals(ACFrame.getInstance().getProperty(
                    "PrintConfig/PrintSyoguKaizen")));
        } else {
            setPrintHomeMedicalAdvice(false);
        }
        
        // 本票の自費に△を記載するかの設定をチェック
        if (ACFrame.getInstance().hasProperty("PrintConfig/PrivateExpenses")) {
            setPrintTriangle(!"0".equals(ACFrame.getInstance().getProperty(
                    "PrintConfig/PrivateExpenses")));
        } else {
            setPrintTriangle(false);
        }

        // 緊急時訪問看護加算・特別管理加算は月1回算定とするか の設定をチェック
        if (ACFrame.getInstance().hasProperty("PrintConfig/OncePerMonth")) {
            getCalcurater()
                    .setOncePerMonthOfAddEmergencyNursingAndSpecialManagement(
                            !"0".equals(ACFrame.getInstance().getProperty(
                                    "PrintConfig/OncePerMonth")));
        } else {
            getCalcurater()
                    .setOncePerMonthOfAddEmergencyNursingAndSpecialManagement(
                            true);
        }
    }

    /**
     * 事業所単位に分割して出力するかを返します。
     * 
     * @return 事業所単位に分割して出力するか
     */
    public boolean isBuildDivedProvider() {
        return buildDivedProvider;
    }

    /**
     * サービスを解析します。
     * 
     * @param services サービス
     * @throws Exception 処理例外
     */
    public void parse(List services) throws Exception {
        // [ID:0000682] 2012/01 start 介護職員処遇改善加算の追加処理
        // 特定診療費・特別療養費の単位数の合成用に退避する
        ACDBManager dbm = ((ACDBManagerCreatable)ACFrame.getInstance().getFrameEventProcesser()).createDBManager();
        CareServicePrecomputed diagnoClass = new CareServicePrecomputed();
        regulationHash = new HashMap<String, Integer>();
        diagnosisHash = new HashMap<String, Integer>();
        diagnoClass.setPrecomputedResult(dbm, services, regulationHash, diagnosisHash);
        // [ID:0000682] 2012/01 end
        // [ID:0000734][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 add begin
        over30UnitSyoguHash = new VRHashMap();
        // [ID:0000734][Masahiko.Higuchi] 2012/04 add end
        
        // 要介護認定履歴から保険者番号-被保険者番号の階層を構築する。
        parseInsureInfo();

        int shortStayCount = addParse(services, true);
        setTargetDayShortStayCount(shortStayCount);
    }

    /**
     * 事業所単位に分割して出力するかを設定します。
     * 
     * @param divedProvider 事業所単位に分割して出力するか
     */
    public void setBuildDivedProvider(boolean divedProvider) {
        this.buildDivedProvider = divedProvider;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator it = CareServiceSchedulePrintManager.this.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry ent = (Map.Entry) it.next();
            sb.append(ACConstants.LINE_SEPARATOR);
            sb.append("保険者番号：");
            sb.append(ent.getKey());
            sb.append(ACConstants.LINE_SEPARATOR);
            sb.append(ent.getValue());
        }
        return sb.toString();
    }

    /**
     * 利用票本表の雛形を生成します。
     * 
         * @param buildParam 印字内容集合
     * @return 利用票本表の雛形
     * @throws Exception 処理例外
     */
    protected VRMap createUserMainTablePageFormat(CareServicePrintParameter buildParam)
            throws Exception {
        VRMap formPage = new VRHashMap();

        VRMap patient = getCalcurater().getPatientInfo();
        if (patient != null) {
            // [2014年要望][Shinobu Hitaka] 2014/10/23 add begin 敬称表示
            // 被保険者氏名
            //formPage.put("upper.h5.w15", QkanCommon.toFullName(patient
            //        .get("PATIENT_FAMILY_NAME"), patient
            //        .get("PATIENT_FIRST_NAME")));
            formPage.put("upper.h5.w15", QkanCommon.toFullName(patient
                    .get("PATIENT_FAMILY_NAME"), patient
                    .get("PATIENT_FIRST_NAME")) + this.printKeisyo);
            // [2014年要望][Shinobu Hitaka] 2014/10/23 add end   敬称表示
            
            // カナ氏名
            formPage.put("upper.h4.w15", ACKanaConvert.toKatakana(QkanCommon
                    .toFullName(patient.get("PATIENT_FAMILY_KANA"), patient
                            .get("PATIENT_FIRST_KANA"))));
            // 性別
            formPage.put("upper.h6.w12", QkanConstants.FORMAT_SEX
                    .format(patient.get("PATIENT_SEX")));
            // 生年月日
            Date birth = ACCastUtilities
                    .toDate(patient.get("PATIENT_BIRTHDAY"));
            formPage.put("patientBirthDay", VRDateParser
                    .format(birth, "e年M月d日"));
            formPage.put("patientBirthDayEra", ACDateUtilities
                    .getEraFull(birth));
        }

        Object obj;
        // 対象年月
        formPage.put("targetDate", getCalcurater().getTextOfTargetYearMonth());

        //2006/06/09 tozo TANAKA begin-delete 法改正による枠外削除
//        // 作成年月日(枠外)
//        String createDate =ACConstants.FORMAT_FULL_ERA_YMD.format(buildParam.getPrintParameter()
//                .get("CREATE_DATE_OUTER")); 
//        if(ACTextUtilities.isNullText(createDate)){
//            createDate = "　　　　　　　　";
//        }
//        formPage.put("createDateOuter", "作成年月日： " + createDate);
        //2006/06/09 tozo TANAKA end-delete
        
        // 作成年月日
        formPage.put("upper.h1.w28", ACConstants.FORMAT_FULL_ERA_YMD
                .format(buildParam.getPrintParameter().get("CREATE_DATE_INNER")));
        // 届出年月日
        obj = buildParam.getPrintParameter().get("DATE_OF_WRITTEN_REPORT");
        if (!ACTextUtilities.isNullText(obj)) {
            formPage.put("upper.h4.w28", ACConstants.FORMAT_FULL_ERA_YMD
                    .format(obj));
        }
        // 前月までの短期入所利用日数
        formPage.put("shortStayUseDay", buildParam.getPrintParameter().get("SHORT_STAY_USE_DAY"));

        // 事業者が作成した場合
        Map provider = getCalcurater().getProvider(buildParam.getPrintParameter());
        if (provider != null) {
            StringBuilder sb = new StringBuilder();

            // 居宅介護支援事業者事業所名
            sb.append(provider.get("PROVIDER_NAME"));
            // 居宅介護支援事業者事連絡先
            String fax = QkanCommon.toTel(provider.get("PROVIDER_FAX_FIRST"),
                    provider.get("PROVIDER_FAX_SECOND"), provider
                            .get("PROVIDER_FAX_THIRD"));
            if (!"".equals(fax)) {
                fax = "FAX:" + fax;
            }
            String tel = QkanCommon.toTel(provider.get("PROVIDER_TEL_FIRST"),
                    provider.get("PROVIDER_TEL_SECOND"), provider
                            .get("PROVIDER_TEL_THIRD"));
            if (!"".equals(tel)) {
                tel += " ";
            }
            if ((tel.length() > 0) || (fax.length() > 0)) {
                sb.append(ACConstants.LINE_SEPARATOR);
                sb.append(tel);
                sb.append(fax);
            }
            // 居宅介護支援事業者担当者名
            obj = buildParam.getPrintParameter().get("STAFF_NAME");
            if (obj != null) {
                String staffName = ACCastUtilities.toString(obj);
                if (staffName.length() > 0) {
                    sb.append(ACConstants.LINE_SEPARATOR);
                    sb.append(staffName);
                }
            }

            formPage.put("upper.h1.w23", sb.toString());
        }

        // 曜日の日以外は丸をはずす
        final String[] wdays = new String[] { "日", "月", "火", "水", "木", "金", "土" };
        Date last = getCalcurater().getLastDayOfMonth();
        int lastDay = ACDateUtilities.getDayOfMonth(last);
        int wday = getCalcurater().getDayOfWeekOnTargetFirstDay() - 1;
        for (int i = 1; i <= lastDay; i++) {
            formPage.put("lowerValue.y.x" + i, wdays[wday]);
            if (wday == 0) {
                formPage.put("lowerValueTriangle.y.x" + i, "○");
            }
            wday = (wday + 1) % 7;
        }
        // 不要な日付を消す
        for (int i = lastDay + 1; i <= 31; i++) {
            formPage.put("lowerValue.d.x" + i, "");
        }

        return formPage;
    }

    /**
     * 利用票別表の雛形を生成します。
     * 
         * @param buildParam 印字内容集合
     * @return 利用票別表の雛形
     * @throws Exception 処理例外
     */
    protected VRMap createUserSubTablePageFormat(CareServicePrintParameter buildParam) throws Exception {
        VRMap formPage = new VRHashMap();
        VRMap patient = getCalcurater().getPatientInfo();
        if (patient != null) {
            // [2014年要望][Shinobu Hitaka] 2014/10/23 add begin 敬称表示
            // 被保険者氏名
            //formPage.put("insured.h1.insuredName", QkanCommon.toFullName(
            //        patient.get("PATIENT_FAMILY_NAME"), patient
            //                .get("PATIENT_FIRST_NAME")));
            formPage.put("insured.h1.insuredName", QkanCommon.toFullName(
                    patient.get("PATIENT_FAMILY_NAME"), patient
                            .get("PATIENT_FIRST_NAME")) + this.printKeisyo);
            // [2014年要望][Shinobu Hitaka] 2014/10/23 add end   敬称表示
        }

        // 対象年月
        formPage.put("targetDate", "("
                + getCalcurater().getTextOfTargetYearMonth() + ")");

        String createDate =ACConstants.FORMAT_FULL_ERA_YMD.format(buildParam.getPrintParameter()
                .get("CREATE_DATE_OUTER")); 
        if(ACTextUtilities.isNullText(createDate)){
            createDate = "　　　　　　　　";
        }
        // 作成年月日(枠外)
        formPage.put("createDateOuter", "作成年月日： " + createDate);

        // 短期入処理用日数
        // 前月までの短期入所利用日数
        Object obj = buildParam.getPrintParameter().get("SHORT_STAY_USE_DAY");
        formPage.put("shortStay.h2.pastMonth", obj);
        int prevShortStay = ACCastUtilities.toInt(obj, 0);
        // 当月の計画利用日数
        formPage.put("shortStay.h2.thisMonth", new Integer(
                getTargetDayShortStayCount()));
        // 累積利用日数
        formPage.put("shortStay.h2.totalDays", new Integer(
                getTargetDayShortStayCount() + prevShortStay));

        // 公費給付率も含めて計算するか
        obj = buildParam.getPrintParameter().getData("WITH_PUBLIC_EXPENSE");
        if ("1".equals(ACCastUtilities.toString(obj))
                || Boolean.TRUE.equals(obj)) {
            getCalcurater().setCalcWithPublicExpense(true);
        } else {
            getCalcurater().setCalcWithPublicExpense(false);
        }

        return formPage;
    }

    /**
     * サービス単位計算クラス を返します。
     * 
     * @return サービス単位計算クラス
     */
    protected CareServiceCodeCalcurater getCalcurater() {
        return calcurater;
    }

    /**
     * 当月の短期入所利用日数 を返します。
     * 
     * @return 当月の短期入所利用日数
     */
    protected int getTargetDayShortStayCount() {
        return targetDayShortStayCount;
    }

    /**
     * 本表1枚あたりのサービス記載件数を返します。
     * 
     * @return 本表1枚あたりのサービス記載件数
     */
    public int getUserMainTableRowCount() {
        return userMainTableRowCount;
    }

    /**
     * 別表1枚あたりのサービス記載件数 を返します。
     * 
     * @return 別表1枚あたりのサービス記載件数
     */
    public int getUserSubTableRowCount() {
        return userSubTableRowCount;
    }

    /**
     * 施設系サービスを本表に印刷するか を返します。
     * 
     * @return 施設系サービスを本表に印刷するか
     */
    protected boolean isPrintFacilityService() {
        return printFacilities;
    }

    /**
     * グループホーム/特定施設系サービスを本表に印刷するか を返します。
     * 
     * @return グループホーム/特定施設系サービスを本表に印刷するか
     */
    protected boolean isPrintLifeCare() {
        return printLifeCare;
    }

    /**
     * 居宅療養管理指導を本表に印刷するか を返します。
     * @return 居宅療養管理指導を本表に印刷するか
     */
    protected boolean isPrintHomeMedicalAdvice() {
        return printHomeMedicalAdvice;
    }

    /**
     * 居宅療養管理指導を本表に印刷するか を返します。
     * @param printHomeMedicalAdvice 居宅療養管理指導を本表に印刷するか
     */
    protected void setPrintHomeMedicalAdvice(boolean printHomeMedicalAdvice) {
        this.printHomeMedicalAdvice = printHomeMedicalAdvice;
    }

    // [H27.4改正対応][Shinobu Hitaka] 2015/3/10 add - begin 
    /**
     * 特別地域加算・小規模事業所加算を本表に印刷するか を返します。
     * @return 特別地域加算・小規模事業所加算を本表に印刷するか
     */
    protected boolean isPrintSpecialArea() {
        return printSpecialArea;
    }

    /**
     * 特別地域加算・小規模事業所加算を本表に印刷するか を返します。
     * @param printSpecialArea 特別地域加算・小規模事業所加算を本表に印刷するか
     */
    protected void setPrintSpecialArea(boolean printSpecialArea) {
        this.printSpecialArea = printSpecialArea;
    }
    /**
     * 中山間地域等提供加算を本表に印刷するか を返します。
     * @return 中山間地域等提供加算を本表に印刷するか
     */
    protected boolean isPrintChusankanArea() {
        return printChusankanArea;
    }

    /**
     * 中山間地域等提供加算を本表に印刷するか を返します。
     * @param printChusankanArea 中山間地域等提供加算を本表に印刷するか
     */
    protected void setPrintChusankanArea(boolean printChusankanArea) {
        this.printChusankanArea = printChusankanArea;
    }
    /**
     * 介護職員処遇改善加算を本表に印刷するか を返します。
     * @return 介護職員処遇改善加算を本表に印刷するか
     */
    protected boolean isPrintSyoguKaizen() {
        return printSyoguKaizen;
    }

    /**
     * 介護職員処遇改善加算を本表に印刷するか を返します。
     * @param printSyoguKaizen 介護職員処遇改善加算を本表に印刷するか
     */
    protected void setPrintSyoguKaizen(boolean printSyoguKaizen) {
        this.printSyoguKaizen = printSyoguKaizen;
    }
    // [H27.4改正対応][Shinobu Hitaka] 2015/3/10 add - end
    
    /**
     * 別表情報としても解析するか を返します。
     * 
     * @return 別表情報としても解析するか
     */
    protected boolean isSubParse() {
        return subParse;
    }

    /**
     * 要介護認定履歴を解析します。
     * 
     * @throws Exception 処理例外
     */
    protected void parseInsureInfo() throws Exception {
        Iterator it = getCalcurater().getPatientInsureInfoHistoryList()
                .iterator();
        while (it.hasNext()) {
            VRMap insureInfo = (VRMap) it.next();
            Object key = insureInfo.get("INSURER_ID");
            if (ACTextUtilities.isNullText(key)) {
                // 保険者番号なし
                continue;
            }
            Object val = CareServiceSchedulePrintManager.this.get(key);
            DivedInsurer page;
            // 保険者番号で分岐
            if (val instanceof DivedInsurer) {
                page = (DivedInsurer) val;
            } else {
                page = new DivedInsurer();
                CareServiceSchedulePrintManager.this.put(key, page);
            }
            // 同一保険者番号内で分類
            page.parseInsureInfo(insureInfo);
        }
    }

    /**
     * サービス単位計算クラス を設定します。
     * 
     * @param calcurater サービス単位計算クラス
     */
    protected void setCalcurater(CareServiceCodeCalcurater calcurater) {
        this.calcurater = calcurater;
    }

    /**
     * 施設系サービスを本表に印刷するか を設定します。
     * 
     * @param printFacilities 施設系サービスを本表に印刷するか
     */
    protected void setPrintFacilities(boolean printFacilities) {
        this.printFacilities = printFacilities;
    }

    /**
     * グループホーム/特定施設系サービスを本表に印刷するか を設定します。
     * 
     * @param printGroupHome グループホーム/特定施設系サービスを本表に印刷するか
     */
    protected void setPrintLifeCare(boolean printGroupHome) {
        this.printLifeCare = printGroupHome;
    }

    /**
     * 別表情報としても解析するか を設定します。
     * 
     * @param subParse 別表情報としても解析するか
     */
    protected void setSubParse(boolean subParse) {
        this.subParse = subParse;
    }

    /**
     * 当月の短期入所利用日数 を設定します。
     * 
     * @param targetDayShortStayCount 当月の短期入所利用日数
     */
    protected void setTargetDayShortStayCount(int targetDayShortStayCount) {
        this.targetDayShortStayCount = targetDayShortStayCount;
    }

    /**
     * 本表1枚あたりのサービス記載件数を返します。
     * 
     * @param userMainTableRowCount 本表1枚あたりのサービス記載件数
     */
    public void setUserMainTableRowCount(int userMainTableRowCount) {
        this.userMainTableRowCount = userMainTableRowCount;
    }

    /**
     * 別表1枚あたりのサービス記載件数を返します。
     * 
     * @param userSubTableRowCount 別表1枚あたりのサービス記載件数
     */
    public void setUserSubTableRowCount(int userSubTableRowCount) {
        this.userSubTableRowCount = userSubTableRowCount;
    }
    public boolean isDebugMode(){
    // TODO デバッグモード begin ★★★★★★★★★★★★★★★★★
    	
        // [ID:0000745][Masahiko.Higuchi] 処遇改善加算を含む計算対応 add - begin
    	if(ultimateDebugFlag) {
    		return true;
    	}
        // [ID:0000745][Masahiko.Higuchi] add - end
    	
	    try {
	        if (ACFrame.getInstance().hasProperty("FullServicePrint")
	                && "true".equalsIgnoreCase(ACCastUtilities
	                        .toString(ACFrame.getInstance().getProperty(
	                                "FullServicePrint")))) {
	            return true;
	        }
	    } catch (Exception ex) {
	    }
	    return false;
    //TODO デバッグモード end ★★★★★★★★★★★★★★★★★★
    }

    /**
     * 強制デバッグモードフラグを設定します。
     * @since 6.1.1
     * @param ultimateDebugFlag 強制デバッグモードを使用するか
     */
    public void setUltimateDebugFlag(boolean ultimateDebugFlag) {
		this.ultimateDebugFlag = ultimateDebugFlag;
	}

	/**
     * 被保険者番号単位で切り替わるページデータです。
     * <p>
     * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
     * </p>
     * 
     * @author Tozo Tanaka
     * @version 1.0 2006/02/15
     */
    protected class DivedInsured extends TreeMap {
        private List insureInfos = new ArrayList();
        private TreeMap mainParseMap = new TreeMap();

        /**
         * 利用票本表を構築します。
         * 
         * @param buildParam 印字内容集合
         * @throws Exception 処理例外
         * @return 1件以上データがあるか
         */
        public boolean buildUserMainTable(CareServicePrintParameter buildParam)
                throws Exception {
            buildParam.setTargetPage((VRMap) buildParam.getFormPage().clone());
            buildParam.setCurrentRow(1);
            Iterator it = DivedInsured.this.mainParseMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                DivedServiceTime services = (DivedServiceTime) ent.getValue();
                // 下位情報構築
                buildParam.setCurrentRow(services
                        .buildUserMainTable(buildParam));
            }

            if (buildParam.getFormPage().size() < buildParam.getTargetPage()
                    .size()) {
                // 最終ページ追加分を登録
                buildParam.getPages().add(buildParam.getTargetPage());
            } else if (buildParam.getPages().isEmpty()) {
                // 空帳票
                buildParam.getPages().add(buildParam.getTargetPage());
                return false;
            }
            
            return true;
        }

        /**
         * %加算等に対応するため、別表用の2段階解析を行います。
         * @throws Exception 処理例外
         */
        public void parseSubSecond() throws Exception{
            Iterator it = DivedInsured.this.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                ((DivedProvider) ent.getValue()).parseSubSecond(ACCastUtilities.toString(ent.getKey()));
            }
        }
        /**
         * 利用票別表を構築します。
         * 
         * @param buildParam 印字内容集合
         * @return 次の出力対象行
         * @throws Exception 処理例外
         * @return 1件以上データがあるか
         */
        public boolean buildUserSubTable(CareServicePrintParameter buildParam)
                throws Exception {

            // ページ追加前の件数を退避
            int oldSize = buildParam.getPages().size();

            // 保険給付率を取得
            int insureRate = 0;
            VRMap ins = getMostHeavyInsureInfo();
            if (ins != null) {
                insureRate = ACCastUtilities.toInt(ins.get("INSURE_RATE"), 0);
            }

            int[] totals = new int[INDEX_OF_TOTAL_ARRAY_SIZE];

            if (isBuildDivedProvider()) {
                // 事業所単位に出力(提供票)
                int provSize = DivedInsured.this.size();
                int[][] otherTotals = new int[provSize][INDEX_OF_TOTAL_ARRAY_SIZE];
                int[] endPoses = new int[provSize];

                // 全体ページ集合を退避
                List masterPages = buildParam.getPages();
                int provPos = 0;
                Iterator it = DivedInsured.this.entrySet().iterator();
                while (it.hasNext()) {
                    // 事業所別ページ集合を全体ページ集合と偽装する
                    buildParam.setPages(new ArrayList());
                    buildParam.setCurrentRow(1);
                    buildParam.setTargetPage((VRMap) buildParam.getFormPage()
                            .clone());

                    Map.Entry ent = (Map.Entry) it.next();
                    DivedProvider services = (DivedProvider) ent.getValue();
                    // 下位情報構築
                    Map provider = getCalcurater().getProvider(
                            ACCastUtilities.toString(ent
                                    .getKey()));
                    // 給付管理対象
                    buildParam.setCurrentRow(services
                            .buildUserSubTableInLimitAmount(buildParam,
                                    provider, insureRate,
                                    otherTotals[provPos]));
                    // 給付管理対象外
                    buildParam.setCurrentRow(services
                            .buildUserSubTableOutLimitAmount(buildParam,
                                    provider, insureRate,
                                    otherTotals[provPos]));
                    //30日超
                    buildParam.setCurrentRow(services
                            .buildUserSubTable30Over(buildParam,
                                    provider, insureRate,
                                    otherTotals[provPos]));
                    endPoses[provPos] = buildParam.getCurrentRow()-1;

                    if (buildParam.getFormPage().size() < buildParam
                            .getTargetPage().size()) {
                        // 最終ページ追加分を登録
                        buildParam.getPages().add(buildParam.getTargetPage());
                    }
                    if (!buildParam.getPages().isEmpty()) {
                        // 空帳票でなければ事業所別帳票として追加
                        masterPages.add(buildParam.getPages());
                    } else {
                        // 空帳票
                        endPoses[provPos] = -1;
                    }
                    provPos++;
                }
                // 全体ページ集合を復帰
                buildParam.setPages(masterPages);

                // 最終的な合計に他事業所分を加算
                for (int j = 0; j < provSize; j++) {
                    for (int i = 0; i < INDEX_OF_TOTAL_ARRAY_SIZE; i++) {
                        totals[i] += otherTotals[j][i];
                    }
                }
                // 他事業所合計を追記
                provPos = 0;
                int end = provSize;
                for (int j = 0; j < end; j++) {
                     int endPos = endPoses[j] + 1;
                     if (endPos > 0) {
                        // 出力可能な事業所
                        List provPages = (List) buildParam.getPages().get(
                                oldSize + provPos);
                        int size = provPages.size();
                        if (size > 0) {
                            int unit = totals[INDEX_OF_SERVICE_UNIT]
                                    - otherTotals[j][INDEX_OF_SERVICE_UNIT];
                            if (unit > 0) {
                                // 他事業所のサービス単位数が0より大きい場合

                                Map targetPage = (Map) provPages.get(size - 1);
                                
                                // [CCCX:1959][Shinobu Hitaka] 2014/08/22 add begin サービス最終行がMAX行数丁度の場合は１行目に上書きするので、改ページする
                                if (endPos == 1){
                                    provPages.add(buildParam.getFormPage().clone());
                                    targetPage = (Map) provPages.get(size);
                                }
                                // [CCCX:1959][Shinobu Hitaka] 2014/08/22 add begin サービス最終行がMAX行数丁度の場合は１行目に上書きするので、改ページする
                                
                                // 事業所名
                                targetPage.put("main.y" + endPos + ".x1",
                                        "他事業所");
                                // サービス内容/種類
                                targetPage.put("main.y" + endPos + ".x3",
                                        "他事業所合計");
                                // サービス単位/金額
                                targetPage.put("main.y" + endPos + ".x9",
                                        new Integer(unit));
                                int overUnit = totals[INDEX_OF_USER_COST_ON_FULL]
                                        - otherTotals[j][INDEX_OF_USER_COST_ON_FULL];
                                if (overUnit > 0) {

                                    // 区分支給限度基準を超える単位数が設定されているとき
                                    // [ID:0000587][Tozo TANAKA] 2010/01/22 replace begin 提供表別表における利用者負担分単位数の地域単価の未考慮
//                                    targetPage.put("main.y" + endPos + ".x12",
//                                            new Integer(overUnit / 10));
                                    targetPage.put("main.y" + endPos + ".x12",
                                            new Integer(totals[INDEX_OF_LIMIT_OVER_UNIT]
                                                               - otherTotals[j][INDEX_OF_LIMIT_OVER_UNIT]));
                                    // [ID:0000587][Tozo TANAKA] 2010/01/22 replace end 提供表別表における利用者負担分単位数の地域単価の未考慮

                                    // 利用者負担（全額負担分）
                                    // 区分支給限度基準を超える単位数*単位数単価
                                    targetPage.put("main.y" + endPos + ".x19",
                                            new Integer(overUnit));

                                }
                                // 区分支給限度基準内単位数
                                targetPage
                                        .put(
                                                "main.y" + endPos + ".x13",
                                                new Integer(
                                                        totals[INDEX_OF_LIMIT_IN_UNIT]
                                                                - otherTotals[j][INDEX_OF_LIMIT_IN_UNIT]));

                                // 費用総額
                                targetPage
                                        .put(
                                                "main.y" + endPos + ".x15",
                                                new Integer(
                                                        totals[INDEX_OF_TOTAL_COST]
                                                                - otherTotals[j][INDEX_OF_TOTAL_COST]));

                                // 保険給付額(切捨て)
                                targetPage
                                        .put(
                                                "main.y" + endPos + ".x17",
                                                new Integer(
                                                        totals[INDEX_OF_INSURE_COST]
                                                                - otherTotals[j][INDEX_OF_INSURE_COST]));

                                // 利用者負担（保険対象分）
                                targetPage
                                        .put(
                                                "main.y" + endPos + ".x18",
                                                new Integer(
                                                        totals[INDEX_OF_USER_COST_ON_INSURE]
                                                                - otherTotals[j][INDEX_OF_USER_COST_ON_INSURE]));
                            }
                        }
                        provPos++;
                    }
                }

            } else {
                // 一括出力(利用票)
                buildParam.setTargetPage((VRMap) buildParam.getFormPage()
                        .clone());

                // 全体ページ集合を退避
                List masterPages = buildParam.getPages();
                // 事業所別ページ集合を全体ページ集合と偽装する
                buildParam.setPages(new ArrayList());
                buildParam.setCurrentRow(1);
                Iterator it;
                // 給付管理対象
                it = DivedInsured.this.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry ent = (Map.Entry) it.next();
                    DivedProvider services = (DivedProvider) ent.getValue();
                    // 下位情報構築
                    buildParam.setCurrentRow(services
                            .buildUserSubTableInLimitAmount(buildParam,
                                    getCalcurater().getProvider(
                                            ACCastUtilities.toString(ent
                                                    .getKey())), insureRate,
                                    totals));
                }
                // 給付管理対象外
                it = DivedInsured.this.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry ent = (Map.Entry) it.next();
                    DivedProvider services = (DivedProvider) ent.getValue();
                    // 下位情報構築
                    buildParam.setCurrentRow(services
                            .buildUserSubTableOutLimitAmount(buildParam,
                                    getCalcurater().getProvider(
                                            ACCastUtilities.toString(ent
                                                    .getKey())), insureRate,
                                    totals));
                }
                //30日超
                it = DivedInsured.this.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry ent = (Map.Entry) it.next();
                    DivedProvider services = (DivedProvider) ent.getValue();
                    // 下位情報構築
                    buildParam.setCurrentRow(services
                            .buildUserSubTable30Over(buildParam,
                                    getCalcurater().getProvider(
                                            ACCastUtilities.toString(ent
                                                    .getKey())), insureRate,
                                    totals));
                  }
                
                if (buildParam.getFormPage().size() < buildParam
                        .getTargetPage().size()) {
                    // 最終ページ追加分を登録
                    buildParam.getPages().add(buildParam.getTargetPage());
                }
                if (!buildParam.getPages().isEmpty()) {
                    // 空帳票でなければ事業所別帳票として追加
                    masterPages.add(buildParam.getPages());
                }
                // 全体ページ集合を復帰
                buildParam.setPages(masterPages);
            }

            // ページ追加後の件数を取得し、本被保険者番号における合計を登録
            int newSize = buildParam.getPages().size();
            for (int i = oldSize; i < newSize; i++) {
                // 事業所単位であってもすべてに合計を付加
                Iterator provIt = ((List) buildParam.getPages().get(i))
                        .iterator();
                while (provIt.hasNext()) {
                    Map page = (Map) provIt.next();
                    // 合計情報を追加
                    // サービス単価/金額
                    page.put("main.total.x9", new Integer(
                            totals[INDEX_OF_SERVICE_UNIT]));
                    // 区分支給限度基準を超える単位数
                    if (totals[INDEX_OF_LIMIT_OVER_UNIT] > 0) {
                        page.put("main.total.x12", new Integer(
                                totals[INDEX_OF_LIMIT_OVER_UNIT]));
                    }
                    // 区分支給限度基準内単位数
                    page.put("main.total.x13", new Integer(
                            totals[INDEX_OF_LIMIT_IN_UNIT]));
                    // 費用総額（保険対象分）
                    page.put("main.total.x15", new Integer(
                            totals[INDEX_OF_TOTAL_COST]));
                    // 保険給付額
                    page.put("main.total.x17", new Integer(
                            totals[INDEX_OF_INSURE_COST]));
                    // 利用者負担（保険対象分）
                    page.put("main.total.x18", new Integer(
                            totals[INDEX_OF_USER_COST_ON_INSURE]));
                    // 利用者負担（全額負担分）
                    if (totals[INDEX_OF_USER_COST_ON_FULL] > 0) {
                        page.put("main.total.x19", new Integer(
                                totals[INDEX_OF_USER_COST_ON_FULL]));
                    }
                }
            }

            if (buildParam.getPages().isEmpty()) {
                // 空帳票
                List provPages = new ArrayList();
                provPages.add(buildParam.getFormPage().clone());
                buildParam.getPages().add(provPages);
                return false;
            }
            return true;

        }

        /**
         * 当月内の最初の要介護認定情報を返します。
         * 
         * @return 要介護認定情報
         */
        public VRMap getFirstInsureInfo() {
            if (getInsureInfos().isEmpty()) {
                return null;
            }
            return (VRMap) getInsureInfos().get(0);
        }

        /**
         * 1つめのサービス情報を返します。
         * 
         * @return 1つめのサービス情報
         */
        public VRMap getMainFormatFirstService() {
            if (DivedInsured.this.size() > 0) {
                Iterator it = DivedInsured.this.mainParseMap.values().iterator();
                while (it.hasNext()) {
                    VRMap result = ((DivedServiceTime) it.next())
                            .getFirstService();
                    if (result != null) {
                        return result;
                    }
                }
            }
            return null;
        }
        /**
         * 1つめのサービス情報を返します。
         * 
         * @return 1つめのサービス情報
         */
        public VRMap getSubFormatFirstService() {
            if (DivedInsured.this.size() > 0) {
                Iterator it = DivedInsured.this.values().iterator();
                while (it.hasNext()) {
                    VRMap result = ((DivedProvider) it.next())
                            .getSubFormatFirstService();
                    if (result != null) {
                        return result;
                    }
                }
            }
            return null;
        }

        /**
         * 要介護認定情報 を返します。
         * 
         * @return 要介護認定情報
         */
        public List getInsureInfos() {
            return insureInfos;
        }

        /**
         * 当月内の最後に追加された要介護認定情報を返します。
         * <p>
         * 要介護認定履歴が1件以下の場合はnullを返します。
         * </p>
         * 
         * @return 当月内の最後に追加された要介護認定情報
         */
        public VRMap getLastChangeInsureInfo() {
            if (getInsureInfos().size() < 2) {
                return null;
            }
            return (VRMap) getInsureInfos().get(getInsureInfos().size() - 1);
        }

        /**
         * 当月内の最も支給限度額の大きい要介護認定情報を返します。
         * 
         * @return 当月内の最も支給限度額の大きい要介護認定情報
         */
        public VRMap getMostHeavyInsureInfo() {
            if (getInsureInfos().isEmpty()) {
                return null;
            }
            int max = -1;
            VRMap maxInfo = null;
            Iterator it = getInsureInfos().iterator();
            while (it.hasNext()) {
                VRMap row = (VRMap) it.next();
                int rate = ACCastUtilities.toInt(row.get("LIMIT_RATE"), 0);
                if (rate > max) {
                    // 最大の支給限度額を更新
                    max = rate;
                    maxInfo = row;
                }
            }
            return maxInfo;
        }

        /**
         * サービスを解析します。
         * 
         * @param services サービス
         * @throws Exception 処理例外
         */
        public void parse(VRMap service) throws Exception {

            //別表は事業所番号で分岐
            parseSub(service);
            //本表は時間帯で分岐
            parseMain(service);
            
        }
        
        /**
         * 本表用に解析します。
         * 
         * @param services サービス
         * @param code サービスコード
         * @throws Exception 処理例外
         */
        protected void parseMain(VRMap service) throws Exception {

                  Date begin = ACCastUtilities.toDate(service.get("3"), null);
                  Date end = ACCastUtilities.toDate(service.get("4"), null);
                  String key = "";
                  if (begin != null) {
                      key += VRDateParser.format(begin, "HH:mm");
                  }
                  if (end != null) {
                      key += VRDateParser.format(end, "-HH:mm");
                  }
                  if("".equals(key)){
                      //ソート結果を末尾とする
                      key = "99:99-99:99";
                  }

                  Object val = mainParseMap.get(key);
                  DivedServiceTime page;
                  // 提供時間単位で分岐
                  if (val instanceof DivedServiceTime) {
                      page = (DivedServiceTime) val;
                  } else {
                      page = new DivedServiceTime();
                      mainParseMap.put(key, page);
                  }

                  // 同一提供時間単位で集合化
                  page.parseMainTable(service);
        }
        
        /**
         * 別表用に解析します。
         * 
         * @param services サービス
         * @param code サービスコード
         * @throws Exception 処理例外
         */
        protected void parseSub(VRMap service) throws Exception {

            Object key = service.get("PROVIDER_ID");
            if (key == null) {
                key = "";
            }
            Object val = DivedInsured.this.get(key);
            DivedProvider page;
            // 事業所番号で分岐
            if (val instanceof DivedProvider) {
                page = (DivedProvider) val;
            } else {
                page = new DivedProvider();
                DivedInsured.this.put(key, page);
            }
            // 同一事業所番号内で分類
            page.parseSubTable(service, ACCastUtilities.toString(key));

        }
        
        /**
         * 要介護認定履歴を解析します。
         * 
         * @param insureInfo 要介護認定情報
         * @throws Exception 処理例外
         */
        public void parseInsureInfo(VRMap insureInfo) throws Exception {
            getInsureInfos().add(insureInfo);
        }

        /**
         * 要介護認定情報 を設定します。
         * 
         * @param insureInfo 要介護認定情報
         */
        public void setInsureInfos(List insureInfo) {
            this.insureInfos = insureInfo;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Iterator it = DivedInsured.this.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                sb.append("│├事業者番号：");
                sb.append(ent.getKey());
                sb.append(ent.getValue());
            }
            return sb.toString();
        }
    }
    
    // === 日割りロジック変更に伴い、削除 ===
//    /**
//     * 別表で解析するかを判断します。
//     * 定額報酬サービス→日割サービスへの変換時専用
//     * 
//     * @param service 判断対象のサービス
//     * @return True:解析対象 False:解析対象外
//     * @throws 処理例外
//     * @since Version 5.4.1
//     * @author Masahiko Higuchi
//     */
//    public boolean isSubParseCustom(VRMap service) throws Exception{
//       
//        if(service == null) return false;
//        // 変換対象となったサービスは対象外
//        if (QkanValidServiceManager.getInstance().containsAnalyzeKey(service,
//                "ORIGINAL")) {
//            return false;
//        }
//        // 有効期間外変換対象となったサービスも対象外
//        // ※現在は解析処理をコメントアウト中なのでこちらは使われないはず
//        if (QkanValidServiceManager.getInstance().containsAnalyzeKey(service,
//                "NON_ORIGINAL")) {
//            return false;
//        }
//        
//        return true;
//    }
    
    /**
     * 本票で解析するかを判断します。
     * 
     * @param service 判断対象のサービス
     * @return True:解析対象 False:解析対象外 
     * @throws 処理例外
     * @since Version 5.4.1
     * @author Masahiko Higuchi
     */
    public boolean isParseCustom(VRMap service) throws Exception{
        
        if(service == null) return false;
        
        // === 日割りロジック変更に伴い、条件変更 ===
//        // 変換後のサービスである場合は解析対象外
//        if (QkanValidServiceManager.getInstance().containsAnalyzeKey(service,
//        "DUMMY")) {
//            return false;
//        }
        
        // 変換後のサービスである場合は解析対象外
        if (service.containsKey("DUMMY")) {
            return false;
        }
        
        return true;
    }
    
    

    /**
     * 保険者番号単位で切り替わるページデータです。
     * <p>
     * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
     * </p>
     * 
     * @author Tozo Tanaka
     * @version 1.0 2006/02/15
     */
    protected class DivedInsurer extends TreeMap {
        /**
         * 利用票本表を構築します。
         * 
         * @param buildParam 印字内容集合
         * @param insuredPageList 追加先被保険者別ページ集合
         * @throws Exception 処理例外
         * @return 1件以上データがあるか
         */
        public boolean buildUserMainTable(CareServicePrintParameter buildParam, List insuredPageList)
                throws Exception {
            boolean exists = false;
            Iterator it = DivedInsurer.this.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                DivedInsured services = (DivedInsured) ent.getValue();

                // 対象認定履歴の変更
                buildUserMainTableInsureInfo(services, buildParam);

                // 下位情報構築
                buildParam.setPages(new ArrayList());
                exists |= services.buildUserMainTable(buildParam);
                insuredPageList.add(buildParam.getPages());
            }
            return exists;
        }

        /**
         * 利用票別表を構築します。
         * 
         * @param buildParam 印字内容集合
         * @param insuredPageList 追加先被保険者別ページ集合
         * @return 次の出力対象行
         * @throws Exception 処理例外
         * @return 1件以上データがあるか
         */
        public boolean buildUserSubTable(CareServicePrintParameter buildParam, List insuredPageList)
                throws Exception {
            boolean exists = false;
            Iterator it = DivedInsurer.this.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                DivedInsured services = (DivedInsured) ent.getValue();

                // 対象認定履歴の変更
                buildUserSubTableInsureInfo(services, buildParam);

                // 下位情報構築
                buildParam.setPages(new ArrayList());
                exists |= services.buildUserSubTable(buildParam);
                insuredPageList.add(buildParam.getPages());
            }
            return exists;
        }
        
        /**
         * %加算等に対応するため、別表用の2段階解析を行います。
         * @throws Exception 処理例外
         */
        public void parseSubSecond() throws Exception{
            Iterator it = DivedInsurer.this.entrySet().iterator();
            while (it.hasNext()) {
                ((DivedInsured) ((Map.Entry) it.next()).getValue()).parseSubSecond();
            }
        }

        /**
         * 1つめのサービス情報を返します。
         * 
         * @return 1つめのサービス情報
         */
        public VRMap getFirstService() {
            if (DivedInsurer.this.size() > 0) {
                return ((DivedInsured) DivedInsurer.this.values().iterator()
                        .next()).getSubFormatFirstService();
            }
            return null;
        }
        /**
         * サービスを解析します。
         * 
         * @param services サービス
         * @throws Exception 処理例外
         */
        public void parse(VRMap service, VRMap insureInfo) throws Exception {
            Object key = insureInfo.get("INSURED_ID");
            if (ACTextUtilities.isNullText(key)) {
                // 被保険者番号なしなら無視
                return;
            }
            Object val = DivedInsurer.this.get(key);
            DivedInsured page;
            // 被保険者番号で分岐
            if (val instanceof DivedInsured) {
                page = (DivedInsured) val;
            } else {
                page = new DivedInsured();
                DivedInsurer.this.put(key, page);
            }
            // 同一被保険者番号内で分類
            page.parse(service);
        }

        /**
         * 要介護認定履歴を解析します。
         * 
         * @param insureInfo 要介護認定情報
         * @throws Exception 処理例外
         */
        public void parseInsureInfo(VRMap insureInfo) throws Exception {
            Object key = insureInfo.get("INSURED_ID");
            if (ACTextUtilities.isNullText(key)) {
                // 被保険者番号なし
                return;
            }
            Object val = DivedInsurer.this.get(key);
            DivedInsured page;
            // 被保険者番号で分岐
            if (val instanceof DivedInsured) {
                page = (DivedInsured) val;
            } else {
                page = new DivedInsured();
                DivedInsurer.this.put(key, page);
            }
            // 同一被保険者番号内で分類
            page.parseInsureInfo(insureInfo);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Iterator it = DivedInsurer.this.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                sb.append("├被保険者番号：");
                sb.append(ent.getKey());
                sb.append(ACConstants.LINE_SEPARATOR);
                sb.append(ent.getValue());
            }
            return sb.toString();
        }

        /**
         * 本表雛形に要介護認定情報を設定します。
         * 
         * @param target 要介護認定情報保持クラス
         * @param formPage 本表雛形
         * @param invisibles 全ページ非表示化するID集合
         */
        protected void buildUserMainTableInsureInfo(DivedInsured target,
                CareServicePrintParameter buildParam) throws Exception {
            // 月初の認定履歴
            VRMap firstInsureInfo = target.getFirstInsureInfo();
            if (firstInsureInfo != null) {

                // 保険者番号
                String insurerID = ACCastUtilities.toString(firstInsureInfo
                        .get("INSURER_ID"));
                buildParam.getFormPage().put("insurerNo", insurerID);
                // 保険者名
                Map insurer = getCalcurater().getInsurerInfo(insurerID);
                if (insurer != null) {
                    buildParam.getFormPage().put("upper.h1.w15",
                            insurer.get("INSURER_NAME"));
                }

                // 被保険者番号
                buildParam.getFormPage().put("insuredNo",
                        firstInsureInfo.get("INSURED_ID"));
                // 要介護状態区分
                Object firstCode = firstInsureInfo.get("JOTAI_CODE");
                buildParam.getFormPage().put(
                        "upper.h6.w15",
                        QkanJotaiCodeUnapplicableFormat.getInstance().format(
                                firstCode));

                VRMap insureInfo = firstInsureInfo;

                // 変更後の要介護度
                VRMap lastInsureInfo = target.getLastChangeInsureInfo();
                if (lastInsureInfo != null) {
                    // 変更後要介護状態区分
                    Object lastCode = lastInsureInfo.get("JOTAI_CODE");
                    if ((firstCode == null) || !firstCode.equals(lastCode)) {
                        buildParam.getFormPage().put(
                                "upper.h7.w15",
                                QkanJotaiCodeUnapplicableFormat.getInstance()
                                        .format(lastCode));

                        // 変更日
                        buildParam.getFormPage().put(
                                "upper.h9.w19",
                                ACConstants.FORMAT_FULL_ERA_YMD
                                        .format(lastInsureInfo
                                                .get("INSURE_VALID_START")));
                    }
                    insureInfo = lastInsureInfo;
                }

                // 月末の要介護度を確定
                if ("0".equals(ACCastUtilities.toString(insureInfo
                        .get("CHANGE_CODE")))) {
                    // 認定決定済み
                    buildParam.getInvisibles().add("requesting");
                } else {
                    // 認定申請中
                    buildParam.getInvisibles().add("authorized");
                }
            }

            // 最も重い要介護度
            VRMap insureInfo = target.getMostHeavyInsureInfo();
            if (insureInfo != null) {

// 2016/7/19 [総合事業対応][Yoichiro Kamei] mod - begin
//              // 区分支給限度基準額
//              buildParam.getFormPage().put(
//                      "limitAmountContent",
//                      NumberFormat.getIntegerInstance().format(
//                              ACCastUtilities.toInt(insureInfo
//                                      .get("LIMIT_RATE"), 0)));
                // 事業対象者で要支援１の基準額を超える場合は、国基準の額を表示する
                int limitRate = ACCastUtilities.toInt(insureInfo.get("LIMIT_RATE"), 0);
                int jotaiCode = ACCastUtilities.toInt(insureInfo.get("JOTAI_CODE"), 0);
                if (jotaiCode == QkanConstants.YOUKAIGODO_JIGYOTAISHO) {
                    if (limitRate > getJigyotaishoLimitRate()) {
                        limitRate = getJigyotaishoLimitRate();
                    }
                }
                // 区分支給限度基準額
                buildParam.getFormPage().put(
                        "limitAmountContent",
                        NumberFormat.getIntegerInstance().format(limitRate));
// 2016/7/19 [総合事業対応][Yoichiro Kamei] mod - end


                // 限度額適用期間開始
                buildParam.getFormPage().put(
                        "validDateStart",
                        yearMonthFormat.format(ACCastUtilities
                                .toDate(insureInfo.get("INSURE_VALID_START"))));
                
// 2016/7/19 [総合事業対応][Yoichiro Kamei] mod - begin
//                // 限度額適用期間終了
//                buildParam.getFormPage().put(
//                        "validDateEnd",
//                        yearMonthFormat.format(ACCastUtilities
//                                .toDate(insureInfo.get("INSURE_VALID_END"))));
                
                Date end = ACCastUtilities.toDate(insureInfo.get("INSURE_VALID_END"));
                if (MAX_DATE.equals(end)) {
                    // 9999-12-31の場合は空欄
                    buildParam.getFormPage().put("validDateEnd", "");
                } else {
                  buildParam.getFormPage().put(
                  "validDateEnd",
                  yearMonthFormat.format(ACCastUtilities
                          .toDate(insureInfo.get("INSURE_VALID_END"))));
                }
// 2016/7/19 [総合事業対応][Yoichiro Kamei] mod - end
            }
        }

        /**
         * 本表雛形に要介護認定情報を設定します。
         * 
         * @param target 要介護認定情報保持クラス
         * @param formPage 本表雛形
         * @param invisibles 全ページ非表示化するID集合
         */
        protected void buildUserSubTableInsureInfo(DivedInsured target,
                CareServicePrintParameter buildParam) throws Exception {
            // 月初の要介護度
            VRMap insureInfo = target.getFirstInsureInfo();
            if (insureInfo != null) {

                // 被保険者番号
                buildParam.getFormPage().put("insured.h1.insuredID",
                        insureInfo.get("INSURED_ID"));

            }

            // 最も重い要介護度
            insureInfo = target.getMostHeavyInsureInfo();
            if (insureInfo != null) {
// 2016/7/19 [総合事業対応][Yoichiro Kamei] mod - begin
//                // 区分支給限度基準額
//                buildParam.getFormPage().put("main.total.x5",
//                        insureInfo.get("LIMIT_RATE"));
                // 事業対象者で要支援１の基準額を超える場合は、国基準の額を表示する
                int limitRate = ACCastUtilities.toInt(insureInfo.get("LIMIT_RATE"), 0);
                int jotaiCode = ACCastUtilities.toInt(insureInfo.get("JOTAI_CODE"), 0);
                if (jotaiCode == QkanConstants.YOUKAIGODO_JIGYOTAISHO) {
                    if (limitRate > getJigyotaishoLimitRate()) {
                        limitRate = getJigyotaishoLimitRate();
                    }
                }
                // 区分支給限度基準額
                buildParam.getFormPage().put("main.total.x5",limitRate);
// 2016/7/19 [総合事業対応][Yoichiro Kamei] mod - end
            }
        }
    }

    /**
     * 事業所番号単位で切り替わるページデータです。
     * <p>
     * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
     * </p>
     * 
     * @author Tozo Tanaka
     * @version 1.0 2006/02/15
     */
    protected class DivedProvider extends TreeMap {
        private Map[] totalGroupingCache = new Map[] { new HashMap(),
                new HashMap() };
        private TreeMap mainParseOver30DaysMap = new TreeMap();

        /**
         * 利用票本表を構築します。
         * 
         * @param pages ページ集合
         * @param formPage 基本情報を設定した雛形ページ
         * @param targetPage 出力対象ページ
         * @param beginRow 出力対象開始行
         * @throws Exception 処理例外
         */
        public int buildUserMainTable(CareServicePrintParameter buildParam) throws Exception {
            buildUserMainTableImpl(buildParam, false);
            buildUserMainTableImpl(buildParam, true);
            return buildParam.getCurrentRow();
        }
        /**
         * 利用票本表を構築します。
         * 
         * @param buildParam 印字内容集合
         * @param isOver30Days 30日超のサービスとして出力するか 
         * @return 次の出力対象行
         * @throws Exception 処理例外
         */
        protected int buildUserMainTableImpl(CareServicePrintParameter buildParam, boolean isOver30Days) throws Exception {
            //2006/08/30 begin-add Tozo TANAKA 本表の30日超対応のため
            TreeMap tableMap;
            if(isOver30Days){
                //30日超の場合は
                tableMap = mainParseOver30DaysMap;
            }else{
                tableMap = DivedProvider.this;
            }
            //2006/08/30 end-add Tozo TANAKA 本表の30日超対応のため
            
            Iterator it = tableMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                DivedServiceKind services = (DivedServiceKind) ent.getValue();
                // 下位情報構築
                buildParam.setCurrentRow(services
                        .buildUserMainTable(buildParam, isOver30Days));
            }
            return buildParam.getCurrentRow();
        }

        /**
         * 利用票別表(給付管理対象)を構築します。
         * 
         * @param buildParam 印字内容集合
         * @param provider 事業所情報
         * @param insureRate 保険給付率
         * @param totals 集計情報
         * @return 次の出力対象行
         * @throws Exception 処理例外
         */
        public int buildUserSubTableInLimitAmount(CareServicePrintParameter buildParam,
                Map provider, int insureRate, int[] totals) throws Exception {
            Iterator it;
            // 給付管理限度額対象
            it = DivedProvider.this.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                DivedServiceKind services = (DivedServiceKind) ent.getValue();
                // 下位情報構築
                buildParam.setCurrentRow(services.buildUserSubTable(buildParam,
                        provider, insureRate, totals, true, false));
            }

            return buildParam.getCurrentRow();
        }

        /**
         * 利用票別表(30日超)を構築します。
         * 
         * @param buildParam 印字内容集合
         * @param provider 事業所情報
         * @param insureRate 保険給付率
         * @param totals 集計情報
         * @return 次の出力対象行
         * @throws Exception 処理例外
         */
        public int buildUserSubTable30Over(CareServicePrintParameter buildParam,
                Map provider, int insureRate, int[] totals) throws Exception {
            Iterator it;
            // 給付管理限度額対象
            it = DivedProvider.this.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                DivedServiceKind services = (DivedServiceKind) ent.getValue();
                // 下位情報構築
                buildParam.setCurrentRow(services.buildUserSubTable(buildParam,
                        provider, insureRate, totals, true, true));
            }

            return buildParam.getCurrentRow();
        }

        /**
         * %加算等に対応するため、別表用の2段階解析を行います。
         * @param providerID 事業所ID
         * @throws Exception 処理例外
         */
        public void parseSubSecond(String providerID) throws Exception{
            Iterator it = DivedProvider.this.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                ((DivedServiceKind) ent.getValue()).parseSubSecond(providerID, ACCastUtilities.toInt(ent.getKey(),0));
            }
        }
        /**
         * 利用票別表(給付管理対象外)を構築します。
         * 
         * @param buildParam 印字内容集合
         * @param provider 事業所情報
         * @param insureRate 保険給付率
         * @param totals 集計情報
         * @return 次の出力対象行
         * @throws Exception 処理例外
         */
        public int buildUserSubTableOutLimitAmount(CareServicePrintParameter buildParam,
                Map provider, int insureRate, int[] totals) throws Exception {
            Iterator it;
            // 給付管理限度額対象外
            int[] dummyTotal = new int[totals.length];
            it = DivedProvider.this.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                DivedServiceKind services = (DivedServiceKind) ent.getValue();
                // 下位情報構築
                buildParam.setCurrentRow(services.buildUserSubTable(buildParam,
                        provider, insureRate, dummyTotal, false, false));
            }
            //費用総額、保険給付額、利用者負担（保険対象分）は給付管理対象外でも合算する
            totals[INDEX_OF_TOTAL_COST] += dummyTotal[INDEX_OF_TOTAL_COST];
            totals[INDEX_OF_INSURE_COST] += dummyTotal[INDEX_OF_INSURE_COST];
            totals[INDEX_OF_USER_COST_ON_INSURE] += dummyTotal[INDEX_OF_USER_COST_ON_INSURE];
            // 利用者負担（全額負担分）も合算する
            totals[INDEX_OF_USER_COST_ON_FULL] += dummyTotal[INDEX_OF_USER_COST_ON_FULL];
           
            return buildParam.getCurrentRow();
        }

        /**
         * 本表における1つめのサービス情報を返します。
         * 
         * @return 1つめのサービス情報
         */
        public VRMap getMainFormatFirstService() {
            VRMap result = getMainFormatFirstServiceImpl(DivedProvider.this);
            if(result==null){
                result = getMainFormatFirstServiceImpl(mainParseOver30DaysMap);
            }
            return result;
        }
        
        /**
         * 本表における1つめのサービス情報を返します。
         *
         * @param map 検索もと
         * @return 1つめのサービス情報
         */
        protected VRMap getMainFormatFirstServiceImpl(Map map) {
            if (map.size() > 0) {
                Iterator it = map.values().iterator();
                while (it.hasNext()) {
                    VRMap result = ((DivedServiceKind) it.next())
                            .getMainFormatFirstService();
                    if (result != null) {
                        return result;
                    }
                }
            }
            return null;
        } 
        
        /**
         * 別表における1つめのサービス情報を返します。
         * 
         * @return 1つめのサービス情報
         */
        public VRMap getSubFormatFirstService() {
            if (DivedProvider.this.size() > 0) {
                Iterator it = DivedProvider.this.values().iterator();
                while (it.hasNext()) {
                    VRMap result = ((DivedServiceKind) it.next())
                            .getSubFormatFirstService();
                    if (result != null) {
                        return result;
                    }
                }
            }
            return null;
        }

        /**
         * サービスを解析します。
         * 
         * @param services サービス
         * @param providerID 事業所ID
         * @throws Exception 処理例外
         */
        public void parseMainTable(VRMap service, String providerID) throws Exception {
            //2006/08/30 begin-add Tozo TANAKA 本表の30日超対応のため
            TreeMap tableMap;
            if(CareServiceCommon.is30DayOver(service)){
                //30日超の場合は
                tableMap = mainParseOver30DaysMap;
            }else{
                tableMap = DivedProvider.this;
            }
            //2006/08/30 end-add Tozo TANAKA 本表の30日超対応のため
            
            
            Object key = service.get("SYSTEM_SERVICE_KIND_DETAIL");
            if (key == null) {
                key = "";
            }
            Object val = tableMap.get(key);
            DivedServiceKind page;
            // サービス種類で分岐
            if (val instanceof DivedServiceKind) {
                page = (DivedServiceKind) val;
            } else {
                // 割引率を計算し、退避させる
                page = new DivedServiceKind(getCalcurater().getReductRate(
                        providerID, service));
                tableMap.put(key, page);
            }
            // 同一サービス種類内で分類
            page.parseMainTable(service, totalGroupingCache);
        }

        /**
         * サービスを解析します。
         * 
         * @param services サービス
         * @param providerID 事業所ID
         * @throws Exception 処理例外
         */
        public void parseSubTable(VRMap service, String providerID) throws Exception {

            Object key = service.get("SYSTEM_SERVICE_KIND_DETAIL");
            if (key == null) {
                key = "";
            }
            Object val = DivedProvider.this.get(key);
            DivedServiceKind page;
            // サービス種類で分岐
            if (val instanceof DivedServiceKind) {
                page = (DivedServiceKind) val;
            } else {
                // 割引率を計算し、退避させる
                page = new DivedServiceKind(getCalcurater().getReductRate(
                        providerID, service));
                DivedProvider.this.put(key, page);
            }
            // 同一サービス種類内で分類
            page.parseSubTable(service, totalGroupingCache);
        }
        
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Iterator it = DivedProvider.this.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                sb.append(ACConstants.LINE_SEPARATOR);
                sb.append("││├サービス種類：");
                sb.append(ent.getKey());
                sb.append(ACConstants.LINE_SEPARATOR);
                sb.append(ent.getValue());
            }
            it = mainParseOver30DaysMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                sb.append(ACConstants.LINE_SEPARATOR);
                sb.append("││├サービス種類：");
                sb.append(ent.getKey());
                sb.append(ACConstants.LINE_SEPARATOR);
                sb.append(ent.getValue());
            }
            return sb.toString();
        }
    }

    /**
     * サービス内容単位で切り替わるページデータです。
     * <p>
     * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
     * </p>
     * 
     * @author Tozo Tanaka
     * @version 1.0 2006/02/15
     */
    protected class DivedServiceItem {
        private Map mainFormatCode;
        private Map subFormatCode;
        private TreeMap inInsureUnits = new TreeMap();
        private TreeMap outInsureUnits = new TreeMap();
        private TreeMap inInsureOver30Units = new TreeMap();
        private TreeMap outInsureOver30Units = new TreeMap();
        private TreeMap plan = new TreeMap();
        private TreeMap result = new TreeMap();

        /**
         * 利用票本表を構築します。
         * 
         * @param texts 印字内容集合
         * @param row 出力対象行
         * @param isOver30Days 30日超のサービスとして出力するか 
         * @throws Exception 処理例外
         */
        public void buildUserMainTable(Map texts, int row, boolean isOver30Days) throws Exception {
            buildUserMainTable(texts, row, plan, "y");
            texts.put("lower.y" + row + ".w13", "予定");
            buildUserMainTable(texts, row, result, "j");
            texts.put("lower.j" + row + ".w13", "実績");

            // サービスコード名
            if (mainFormatCode != null) {
                String serviceItemName ="";
                if(isOver30Days){
                    serviceItemName ="30日超";
                }
                serviceItemName += ACCastUtilities.toString(
                        mainFormatCode.get("SERVICE_NAME"), "");
                
                //[H27.4改正対応][Shinobu Hitaka] 2015/4/2 add - begin
                // 11:訪問介護20分未満の頻回表示対応
                if ("11".equals(ACCastUtilities.toString(mainFormatCode.get("SERVICE_CODE_KIND")))
                		&& "1".equals(ACCastUtilities.toString(mainFormatCode.get("SERVICE_MAIN_FLAG")))) {
                	
                	// システムサービスコードの最後の文字が頻回フラグ=2の場合に【頻回】を付加する。
                	String tmpSystemServiceCodeItem = ACCastUtilities.toString(mainFormatCode.get("SYSTEM_SERVICE_CODE_ITEM"));
                	if ("2".equals(tmpSystemServiceCodeItem.substring(tmpSystemServiceCodeItem.length() - 1))) {
                		serviceItemName += "【頻回】";
                	}
                }
                //[H27.4改正対応][Shinobu Hitaka] 2015/4/2 add - end
                
                // サービス内容
                texts.put("lowerHeader.row" + row + "Upper.service",
                        serviceItemName);
            }

        }

        /**
         * 利用票本表を構築します。
         * 
         * @param texts 印字内容集合
         * @param row 出力対象行
         * @param targetMap 対象とするマップ
         * @param rowType 行形式
         * @throws Exception 処理例外
         */
        protected void buildUserMainTable(Map texts, int row, Map targetMap,
                String rowType) throws Exception {
            int total = 0;
            Iterator it = targetMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                // 指定日に印字する回数を追加
                List services = (List) ent.getValue();
                String path = rowType + row + ".x" + ent.getKey();
                texts.put("lowerValue." + path, ACCastUtilities.toString(
                        services.size(), ""));
                total += services.size();

                if (isPrintTriangle()) {
                    Iterator sit = services.iterator();
                    while (sit.hasNext()) {
                        if (ACCastUtilities.toInt(((Map) sit.next())
                                .get("REGULATION_RATE"), 0) > 0) {
                            // 自費調整有り
                            texts.put("lowerValueTriangle." + path, "△");
                            break;
                        }
                    }
                }
            }
            // 合計
            if (total > 0) {
                texts.put("lower." + rowType + row + ".g", ACCastUtilities
                        .toString(total, ""));
            }

            // サービスの提供時間帯
            VRMap service = getMainFormatFirstService();

            boolean lowerOut = false;
            Date begin = ACCastUtilities.toDate(service.get("3"), null);
            Date end = ACCastUtilities.toDate(service.get("4"), null);
            if (end != null) {
                // 提供終了時刻あり
                String lowerTime = VRDateParser.format(end, "HH:mm");
                texts.put("lowerHeader.row" + row + "Lower.time", lowerTime);
                lowerOut = true;
            }

            if (begin != null) {
                // 提供開始時刻あり
                String upperTime = VRDateParser.format(begin, "HH:mm") + " から";
                texts.put("lowerHeader.row" + row + "Upper.time", upperTime);
            } else if (lowerOut) {
                // 提供終了時刻のみあり
                texts.put("lowerHeader.row" + row + "Upper.time", "     　から");
            }
        }

        // [ID:0000444][Tozo TANAKA] 2009/03/20 remove begin 平成21年4月法改正対応
//        /**
//         * %加算の対象となる単位数を返します。
//         * @param providerID 事業所ID
//         * @return %加算の対象となる単位数
//         * @throws Exception 処理例外
//         */
//        public int getSubPersentageUnit(String providerID) throws Exception{
//            int units = 0;
//            Iterator it = DivedServiceItem.this.inInsureUnits.entrySet().iterator();
//            while (it.hasNext()) {
//                Map.Entry ent = (Map.Entry) it.next();
//                DivedServiceUnit item = (DivedServiceUnit) ent.getValue();
//                
//                if(CareServiceCommon.isSimpleUnit(item.code)){
//                    units += getCalcurater().getReductedUnit(providerID,
//                            item.code, ACCastUtilities.toInt(ent.getKey(), 0))
//                            * item.size();
//                }
//            }
//            return units;
//        }
        // [ID:0000444][Tozo TANAKA] 2009/03/18 remove end
        /**
         * %加算の単位数を設定します。
         * @param units %加算の単位数
         * @throws Exception 処理例外
         */
        public void setSubPersentageUnit(int units) throws Exception{
            Object removeKey = null;
            Object replaceValue = null;
            String serviceAddFlag = "";
            String findKey = "";
            Iterator it = DivedServiceItem.this.outInsureUnits.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                DivedServiceUnit item = (DivedServiceUnit) ent.getValue();
                VRMap rec = (VRHashMap)item.get(0);
                findKey = ACCastUtilities.toString(rec.getData("PROVIDER_ID")) + "-" + ACCastUtilities.toString(rec.getData("SYSTEM_SERVICE_KIND_DETAIL"));
                if(CareServiceCommon.isAddPercentage(item.code)){
                    // 処遇改善加算の自己負担分を計算する
                    serviceAddFlag = ACCastUtilities.toString((item.code.get("SERVICE_ADD_FLAG")),"");
                    removeKey = ent.getKey();
                    replaceValue = item;
                    break;
                }
            }
            if(removeKey!=null){
                int per=ACCastUtilities.toInt(removeKey, 0);
                DivedServiceItem.this.outInsureUnits.remove(removeKey);
                //%加算
                DivedServiceItem.this.outInsureUnits.put(new Integer((int)Math.round(units*per/100.0)), replaceValue);
                
                // 特別地域・小規模の場合の自己負担額を退避
                int regulationUnit = 0;
                // [ID:0000728][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 add begin
                int adjustUnit = 0;
                int calcUnit = 0;
                int totalUnit = 0;
                int result = 0;
                // [ID:0000728][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 add end
                if("3".equals(serviceAddFlag) && regulationHash.containsKey(findKey)) {
                    regulationUnit = ACCastUtilities.toInt(regulationHash.get(findKey), 0);
                    // [ID:0000728][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 edit begin
                    adjustUnit = units - regulationUnit;
                    calcUnit = new Integer((int)Math.round(adjustUnit*per/100.0));
                    totalUnit = new Integer((int)Math.round(units*per/100.0));
                    result = totalUnit - calcUnit;
                    regulationHash.put(findKey + "_" + serviceAddFlag, new Integer(result));
                    // [ID:0000728][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 edit end
                }
                
                if("6".equals(serviceAddFlag)) {
                    regulationUnit = ACCastUtilities.toInt(regulationHash.get(findKey), 0);
                    // 特別地域加算の自己負担も合計する
                    regulationUnit += ACCastUtilities.toInt(regulationHash.get(findKey + "_3"),0);
                    // [ID:0000728][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 edit begin
                    adjustUnit = units - regulationUnit;
                    calcUnit = new Integer((int)Math.round(adjustUnit*per/100.0));
                    totalUnit = new Integer((int)Math.round(units*per/100.0));
                    result = totalUnit - calcUnit;
                    regulationHash.put(findKey + "_" + serviceAddFlag, new Integer(result));
                    // [ID:0000728][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 edit end
                }
            }
        }
        

        /**
         * 利用票別表を構築します。
         * 
         * @param buildParam 印字内容集合
         * @param provider 事業所情報
         * @param insureRate 保険給付率
         * @param totals 集計情報
         * @param itemState サービス内容状態
         * @param isOver30Days 30日超
         * @return 次の出力対象行
         * @throws Exception 処理例外
         */
        public void buildUserSubTableOver30Days(
                CareServicePrintParameter buildParam, Map provider,
                int insureRate, int[] totals) throws Exception {

            // [ID:0000734][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 add begin
            // 30日超の印字直前に単位数を％から計算後の結果に差し替える
            // 給付限度額管理対象内の単位数から対象を取得
            String systemServiceKindDetail = "";
            int totalUnit = 0;
            Iterator itInsurerOver = inInsureOver30Units.entrySet().iterator();
            while (itInsurerOver.hasNext()) {
                Map.Entry ent = (Map.Entry) itInsurerOver.next();
                int unit = ACCastUtilities.toInt(ent.getKey());
                if (unit == 0) {
                    continue;
                }
                DivedServiceUnit services = (DivedServiceUnit) ent.getValue();
                int count = ((DivedServiceUnit) ent.getValue()).size();
                // 回数を含めて計算
                int units = unit * count;
                VRMap service = (VRMap)services.code;
                systemServiceKindDetail = ACCastUtilities.toString(service.getData("SYSTEM_SERVICE_KIND_DETAIL"),"");
                // %系加算を除外する
                if(!CareServiceCommon.isAddPercentage(service)) {
                    totalUnit = ACCastUtilities.toInt(over30UnitSyoguHash.getData(systemServiceKindDetail),0);
                    totalUnit+=units;
                    over30UnitSyoguHash.setData(systemServiceKindDetail, totalUnit);
                }
            }
            
            // 給付限度額管理対象外の単位数から対象を取得
            itInsurerOver = outInsureOver30Units.entrySet().iterator();
            while (itInsurerOver.hasNext()) {
                Map.Entry ent = (Map.Entry) itInsurerOver.next();
                int unit = ACCastUtilities.toInt(ent.getKey());
                if (unit == 0) {
                    continue;
                }
                DivedServiceUnit services = (DivedServiceUnit) ent.getValue();
                int count = ((DivedServiceUnit) ent.getValue()).size();
                // 回数を含めて計算
                int units = unit * count;
                VRMap service = (VRMap)services.code;
                systemServiceKindDetail = ACCastUtilities.toString(service.getData("SYSTEM_SERVICE_KIND_DETAIL"),"");
                // %系加算を除外する
                if(!CareServiceCommon.isAddPercentage(service)) {
                    totalUnit = ACCastUtilities.toInt(over30UnitSyoguHash.getData(systemServiceKindDetail),0);
                    totalUnit+=units;
                    over30UnitSyoguHash.setData(systemServiceKindDetail, totalUnit);
                }
            }
            
            // 単位数差し替えようのループ
            itInsurerOver = inInsureOver30Units.entrySet().iterator();
            while (itInsurerOver.hasNext()) {
                Map.Entry ent = (Map.Entry) itInsurerOver.next();
                int unit = ACCastUtilities.toInt(ent.getKey());
                if (unit == 0) {
                    continue;
                }
                DivedServiceUnit services = (DivedServiceUnit) ent.getValue();
                VRMap code = (VRMap)services.code;
                systemServiceKindDetail = ACCastUtilities.toString(code.getData("SYSTEM_SERVICE_KIND_DETAIL"),"");
                // 処遇改善加算の場合
                if(CareServiceCommon.isAddPercentageForSyogu(code)) {
                    int serviceUnit = ACCastUtilities.toInt(code.get("SERVICE_UNIT"),0);
                    // 処遇改善割合
                    int serviceStaffUnit = ACCastUtilities.toInt(code.get("SERVICE_STAFF_UNIT"),0);
                    totalUnit = ACCastUtilities.toInt(over30UnitSyoguHash.getData(systemServiceKindDetail),0);
                    // 管理用マップから一度削除
                    inInsureOver30Units.remove(ent.getKey());
                     // 計算処理本体
                    unit = CareServiceCommon.calcSyogu(totalUnit, serviceUnit, serviceStaffUnit);
                    inInsureOver30Units.put(unit, (DivedServiceUnit) ent.getValue());
                }
            }
            // [ID:0000734][Masahiko.Higuchi] 2012/04 add end

            
            // 支給限度額外の30日超コードは利用者全額負担分として最初に合算
            Iterator it = outInsureOver30Units.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                int unit = ACCastUtilities.toInt(ent.getKey());
                if (unit == 0) {
                    // 単位0は無視
                    continue;
                }
                DivedServiceUnit services = (DivedServiceUnit) ent.getValue();
                services.buildUserSubTableDetailRow(buildParam, provider, unit,
                        totals, true);
            }
        }

        /**
         * 利用票別表を構築します。
         * 
         * @param buildParam 印字内容集合
         * @param provider 事業所情報
         * @param insureRate 保険給付率
         * @param totals 集計情報
         * @param itemState サービス内容状態
         * @param isOver30Days 30日超
         * @return 次の出力対象行
         * @throws Exception 処理例外
         */
        public int buildUserSubTable(CareServicePrintParameter buildParam, Map provider,
                int insureRate, int[] totals, int itemState, Set regulationCache, boolean isOver30Days) throws Exception {

            Map targetMap;
            if (itemState != ITEM_STATE_OUT_LIMIT_AMOUNT) {
                if(isOver30Days){
                    targetMap = inInsureOver30Units;
                }else{
                    targetMap = inInsureUnits;
                }
                //2006/6/20 Tozo TANAKA 同サービスコード異単位数の福祉用具貸与の対応-begin
                if(itemState == ITEM_STATE_SINGLE) {
                    //単一行と指定されたが、サービスコードは同一でも単位数は2種類というケースを考慮
                    if(targetMap.size()>1){
                        itemState = ITEM_STATE_MULTI_LAST;
                    }
                }
                //2006/6/20 Tozo TANAKA 同サービスコード異単位数の福祉用具貸与のお試し対応-end
            } else {
                targetMap = outInsureUnits;
            }
            DivedServiceUnit services = null;
            boolean totalPrinted = false;
            boolean canTotalPrint = (itemState == ITEM_STATE_MULTI_LAST)
                    && CareServiceCommon.isInLimitAmount(subFormatCode);

            // [ID:0000734][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 add begin
            if(isOver30Days && !canTotalPrint) {
                canTotalPrint =  (itemState == ITEM_STATE_MULTI_LAST)
                        && CareServiceCommon.isOutLimitAmount(subFormatCode);
            }
            // [ID:0000734][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 add end

            // ページ基本情報を登録
            Iterator it = targetMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                int unit = ACCastUtilities.toInt(ent.getKey());
                if (unit == 0) {
                    // 単位0は無視
                    continue;
                }
                
                services = (DivedServiceUnit) ent.getValue();
                
                // 特別地域加算と処遇改善加算の自己負担分を一時的に上書きしてから再度差し戻す
                int mainRegulationRate = 0;
                int etcRegulationRate = 0;
                VRMap rec = (VRHashMap)services.get(0);
                String findKey = "";
                mainRegulationRate = ACCastUtilities.toInt(rec.getData("REGULATION_RATE"),0);
                
                // ※※※　再設定することで、Objectの参照を固定する　※※※
                // こうしておかないと、addRedulationRate内での比較に失敗する
                rec.setData("REGULATION_RATE", mainRegulationRate);
                
                if(CareServiceCommon.isAddPercentage(services.code)) {
                    // ここで自己負担分を挿入する
                    findKey = ACCastUtilities.toString(rec.getData("PROVIDER_ID")) + "-" + ACCastUtilities.toString(rec.getData("SYSTEM_SERVICE_KIND_DETAIL"));
                    String serviceAddFlag = ACCastUtilities.toString(services.code.get("SERVICE_ADD_FLAG"));
                    if("3".equals(serviceAddFlag) || "6".equals(serviceAddFlag) || "8".equals(serviceAddFlag)) {
                        findKey += "_" + serviceAddFlag;
                        etcRegulationRate = ACCastUtilities.toInt(regulationHash.get(findKey),0);
                        rec.setData("REGULATION_RATE",etcRegulationRate);
                    }
                }
                
                // [H27.4改正対応][Yoichiro Kamei] 2015/4/3 add - begin サービス提供体制加算の自己負担対応
                boolean teikyoAddFlg = false;
                if (SelfPaymentNumberCalcurater.isTaisho(services.code)) {
                    findKey = ACCastUtilities.toString(rec.getData("PROVIDER_ID")) + "-" + ACCastUtilities.toString(rec.getData("SYSTEM_SERVICE_KIND_DETAIL"));
                    String serviceAddFlag = ACCastUtilities.toString(services.code.get("SERVICE_ADD_FLAG"));
                    findKey += "_" + serviceAddFlag;
                    etcRegulationRate = ACCastUtilities.toInt(regulationHash.get(findKey),0);
                    teikyoAddFlg = true;
                    totals[INDEX_OF_LIMIT_OVER_UNIT_FOR_DETAIL] += etcRegulationRate;
                    totals[INDEX_OF_LIMIT_OVER_UNIT] += etcRegulationRate;
                }
                // [H27.4改正対応][Yoichiro Kamei] 2015/4/3 add - end
                
                // [ID:0000764][Masahiko.Higuchi] edit - begin 30日超の別表印字障害対応
                
                // [H27.4改正対応][Yoichiro Kamei] 2015/4/3 mod - begin サービス提供体制加算の自己負担対応
                //if(!isOver30Days)
                if(!isOver30Days && !teikyoAddFlg) {
                // [H27.4改正対応][Yoichiro Kamei] 2015/4/3 mod - end
                // 自費調整分を合算
                	addRedulationRate(totals, services, regulationCache);
                }
                // [ID:0000764][Masahiko.Higuchi] edit - end
                
                // 特別地域加算と処遇改善加算で変更されているので自己負担分を再度差し戻す
                rec.setData("REGULATION_RATE", mainRegulationRate);

                if (itemState == ITEM_STATE_SINGLE) {
                    // 単一行で明細と小計
                    services.buildUserSubTableTotalDetailRow(buildParam,
                            provider, insureRate, unit, totals, false, false, isOver30Days);
                } else if (itemState == ITEM_STATE_OUT_LIMIT_AMOUNT) {
                    // 給付管理限度額対象外
                	
                	// [H27.4改正対応][Yoichiro Kamei] 2015/4/3 add - begin サービス提供体制加算の自己負担対応
                	// 対象の加算であれば印字
                	if (etcRegulationRate > 0 && (SelfPaymentNumberCalcurater.isTaisho(services.code))) {
                        services.buildUserSubTableTotalDetailRow(buildParam,
                                provider, insureRate, unit, totals, true, false, isOver30Days);
                	} else //下のif文へづづく(else if)
                	// [H27.4改正対応][Yoichiro Kamei] 2015/4/3 add - end
                	
                    // 特別地域・中山間地域と処遇改善加算系で自己負担がある場合のみ小計に印字する
                    if(etcRegulationRate > 0 && CareServiceCommon.isAddPercentage(services.code)) {
                        services.buildUserSubTableTotalDetailRow(buildParam,
                                provider, insureRate, unit, totals, true, false, isOver30Days);
                    } else {
                        services.buildUserSubTableTotalDetailRow(buildParam,
                                provider, insureRate, unit, totals, true, true, isOver30Days);                        
                    }
                    // 回数
                    if(CareServiceCommon.isCountPrintableServiceCode(services.code)){
                        buildParam.getTargetPage().put(
                            "main.y" + buildParam.getCurrentRow() + ".x8",
                            new Integer(services.size()));
                    }
                } else {

                    // 明細行
                    services.buildUserSubTableDetailRow(buildParam, provider,
                            unit, totals, isOver30Days);
                }

                buildParam.setCurrentRow(buildParam.getCurrentRow() + 1);
                if (buildParam.getCurrentRow() >= getUserSubTableRowCount()) {
                    // ページ送り
                    if ((!it.hasNext()) && canTotalPrint) {
                        // ページの折り返し地点でちょうど最後の項目となり、
                        // 同種類のサービスとしては最後の項目で、
                        // 小計行の追加を許す場合
                        // →末行に小計を表示                        
                        services.buildUserSubTableTotalRow(buildParam,
                                provider, insureRate, totals, isOver30Days);
                        totalPrinted = true;
                    }
                    buildParam.getPages().add(buildParam.getTargetPage());
                    buildParam.setTargetPage((VRMap) buildParam.getFormPage()
                            .clone());
                    buildParam.setCurrentRow(1);
                }
                
            }
            if ((services != null) && (!totalPrinted) && canTotalPrint) {
                // 小計行を出力
                services.buildUserSubTableTotalRow(buildParam, provider,
                        insureRate, totals, isOver30Days);
                buildParam.setCurrentRow(buildParam.getCurrentRow() + 1);
                if (buildParam.getCurrentRow() >= getUserSubTableRowCount()) {
                    // ページ送り
                    buildParam.getPages().add(buildParam.getTargetPage());
                    buildParam.setTargetPage((VRMap) buildParam.getFormPage()
                            .clone());
                    buildParam.setCurrentRow(1);
                }
            }

            return buildParam.getCurrentRow();
        }
        /**
         * 自費調整分を合算します。
         * @param totals 集計情報
         * @param services 単位数別サービス集合
         */
        protected void addRedulationRate(int[] totals, DivedServiceUnit services, Set regulationCache){
            // 自費調整分を合算
            Iterator it = services.iterator();
            while (it.hasNext()) {
                Map service = (Map) it.next();
                if(!regulationCache.contains(service)){
                    int over = ACCastUtilities.toInt(service
                        .get("REGULATION_RATE"), 0);
                    totals[INDEX_OF_LIMIT_OVER_UNIT_FOR_DETAIL] += over;
                    totals[INDEX_OF_LIMIT_OVER_UNIT] += over;
                    regulationCache.add(service);
                }
            }            
        }

        /**
         * 本表における1つめのサービス情報を返します。
         * 
         * @return 本表における1つめのサービス情報
         */
        public VRMap getMainFormatFirstService() {
            if (result.size() > 0) {
                List list = (List) result.values().iterator().next();
                if ((list instanceof List) && (!((List) list).isEmpty())) {
                    return (VRMap) ((List) list).get(0);
                }
            }
            if (plan.size() > 0) {
                List list = (List) plan.values().iterator().next();
                if ((list instanceof List) && (!((List) list).isEmpty())) {
                    return (VRMap) ((List) list).get(0);
                }
            }
            return null;
        }

        /**
         * 別表における1つめのサービス情報を返します。
         * 
         * @return 別表における1つめのサービス情報
         */
        public VRMap getSubFormatFirstService() {
            if (inInsureUnits.size() > 0) {
                List list = (List) inInsureUnits.values().iterator().next();
                if ((list instanceof List) && (!((List) list).isEmpty())) {
                    return (VRMap) ((List) list).get(0);
                }
            }
            if (outInsureUnits.size() > 0) {
                List list = (List) outInsureUnits.values().iterator().next();
                if ((list instanceof List) && (!((List) list).isEmpty())) {
                    return (VRMap) ((List) list).get(0);
                }
            }
            return null;
        }

        /**
         * 別表へ印字可能なサービスであるかを返します。
         * 
         * @return 別表へ印字可能なサービスであるか
         */
        public boolean isSubFormatPrintable() {
            // 施設系/準施設系サービスではなければ別表に印字する。

            // TODO デバッグモード begin ★★★★★★★★★★★★★★★★★
            if(isDebugMode()){
                return true;
            }
            //TODO デバッグモード end ★★★★★★★★★★★★★★★★★★
            
            VRMap service = DivedServiceItem.this.getSubFormatFirstService();

            // 施設系/準施設系サービス/居宅療養管理指導は別表に印字しない。
            return CareServiceCommon.isServiceUseTablePrintable(service);
        }

        /**
         * サービスを解析します。
         * 
         * @param services サービス
         * @param code サービスコード
         * @param totalGroupingCache 月/日単位算定キャシュ
         * @param calcurateUnit ここまでの計算単位数
         * @param reductRate 割引率
         * @throws Exception 処理例外
         * @return 当該サービスコード演算後の単位数
         */
        public void parseMain(VRMap service, Map code) throws Exception {
            Date date = ACCastUtilities.toDate(service.get("SERVICE_DATE"),
                    null);
            if (date != null) {
                mainFormatCode = code;
                // サービスの提供日を取得
                Integer key = new Integer(ACDateUtilities.getDayOfMonth(date));

                // 予定か実績か
                Map targetMap;
                if (QkanConstants.SERVICE_USE_TYPE_RESULT_MONTHLY_DAY
                        .equals(service.get("SERVICE_USE_TYPE"))) {
                    targetMap = result;
                } else {
                    targetMap = plan;
                }

                Object val = targetMap.get(key);
                List services;
                if (val instanceof List) {
                    services = (List) val;
                } else {
                    services = new ArrayList();
                    targetMap.put(key, services);
                }
                // 同一提供日のデータを追加
                services.add(service);
            }
        }

        /**
         * サービスを解析します。
         * 
         * @param services サービス
         * @param code サービスコード
         * @param totalGroupingCache 月/日単位算定キャシュ
         * @param calcurateUnit ここまでの計算単位数
         * @param reductRate 割引率
         * @throws Exception 処理例外
         * @return 当該サービスコード演算後の単位数
         */
        public int parseSub(VRMap service, Map code, Map[] totalGroupingCache,
                int calcurateUnit, int reductRate) throws Exception {
            
            // 2008/01/07 [Masahiko Higuchi] edit - begin 定額報酬サービス日割対応
            // === 日割りロジック変更に伴い、条件変更
            //if (isSubParse() && isSubParseCustom(service)) {
            if (isSubParse()) {
            // 2008/01/07 [Masahiko Higuchi] edit -end
                // 別表情報としても解析する場合
                subFormatCode = code;
                int unit;
                
                int IN_TARGET_FLAG =  CareServiceCodeCalcurater.CALC_MODE_IN_LIMIT_AMOUNT;
                // TODO デバッグモード begin ★★★★★★★★★★★★★★★★★
                if(isDebugMode()){
                    IN_TARGET_FLAG = CareServiceCodeCalcurater.CALC_MODE_IN_LIMIT_AMOUNT_OR_OUTER_SERVICE;
                }
                // TODO デバッグモード end ★★★★★★★★★★★★★★★★★
                
                Map targetMap = null;

                // 給付管理対象
                unit = getCalcurater().getServiceCodeUnitField(service, true,
                        code,
                        IN_TARGET_FLAG,
                        totalGroupingCache);
                if (unit != 0) {
                    targetMap = inInsureUnits;
                } else {
                    // 給付管理対象外
                    unit = getCalcurater()
                            .getServiceCodeUnitField(
                                    service,
                                    true,
                                    code,
                                    CareServiceCodeCalcurater.CALC_MODE_OUT_LIMIT_AMOUNT,
                                    totalGroupingCache);

                    if (unit != 0) {
                        targetMap = outInsureUnits;
                    } else {
                        // 30日超給付管理対象
                        unit = getCalcurater()
                                .getServiceCodeUnitField(
                                        service,
                                        false,
                                        code,
                                        IN_TARGET_FLAG,
                                        totalGroupingCache);
                        if (unit != 0) {
                            targetMap = inInsureOver30Units;
                        } else {
                            // 30日超給付管理対象外
                            unit = getCalcurater()
                                    .getServiceCodeUnitField(
                                            service,
                                            false,
                                            code,
                                            CareServiceCodeCalcurater.CALC_MODE_OUT_LIMIT_AMOUNT,
                                            totalGroupingCache);

                            if (unit != 0) {
                                
                                // [ID:0000734][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 add begin
                                if(CareServiceCommon.isAddPercentageForSyogu(code) && CareServiceCommon.is30DayOver(service)){
                                    targetMap = inInsureOver30Units;
                                } else {
                                    targetMap = outInsureOver30Units;
                                }
                                // [ID:0000734][Masahiko.Higuchi] 2012/04 add end
                            }
                        }
                    }

                }
                if (targetMap != null) {
                    // ここまでの合算をもとに加算形式に応じた割引済み単位数に変換
                    Object key = new Integer(unit);

                    unit = getCalcurater().getReductedServiceCodeUnit(code,
                            unit, calcurateUnit, reductRate);
                    calcurateUnit += unit;

                    Object val = targetMap.get(key);
                    DivedServiceUnit page;
                    // 提供単位で分岐
                    if (val instanceof DivedServiceUnit) {
                        page = (DivedServiceUnit) val;
                    } else {
                        page = new DivedServiceUnit();
                        targetMap.put(key, page);
                    }

// [H27.4改正対応][Yoichiro Kamei] 2015/3/19 mod - begin 看取り加算日数の対応
//                  // 同一提供単位で集合化
//                  page.parse(service, code);                    
                    String serviceCodeKind = ACCastUtilities.toString(code.get("SERVICE_CODE_KIND"));
                    String serviceCodeItem = ACCastUtilities.toString(code.get("SERVICE_CODE_ITEM"));
                    int serviceCount = QP001SpecialCase.getServiceCount(serviceCodeKind
                        , serviceCodeItem
                        , service);
                    for (int i = 1; i <= serviceCount; i++) {
                        page.parse(service, code);
                    }
// [H27.4改正対応][Yoichiro Kamei] 2015/3/19 mod - end
                }
            }
            return calcurateUnit;

        }
        
        protected void checkAddPercentage(Map code) throws Exception{
            if(CareServiceCommon.isAddPercentage(code)){
                //%加算は単位別で分けない
                addPercentages.add(this);
            }            
        }
        //%加算系はサービス種類単位で統合する
        
        private Set addPercentages = new HashSet();

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Iterator it = result.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                sb.append("│││││├サービス提供日：");
                sb.append(ent.getKey());
                sb.append(ACConstants.LINE_SEPARATOR);
                sb.append("││││││└サービス：");
                sb.append(ent.getValue());
            }
            return sb.toString();
        }

    }

    /**
     * サービス種類単位で切り替わるページデータです。
     * <p>
     * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
     * </p>
     * 
     * @author Tozo Tanaka
     * @version 1.0 2006/02/15
     */
    protected class DivedServiceKind {
        private List codes;
        private int reductRate;
        private int limitAmoutSize;
        
        private int limitAmoutSizeOver30;
        private HashSet hadItemSet = new HashSet();
        
        private TreeMap mainParseMap = new TreeMap();
        private TreeMap subParseMap = new TreeMap();
        // [ID:0000444][Tozo TANAKA] 2009/03/18 add begin 平成21年4月法改正対応
        private Map addPersentageTargetCounts = new HashMap();
        // [ID:0000444][Tozo TANAKA] 2009/03/18 add end
        // [ID:0000734][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 add begin
        private Map syoguMap = new HashMap();
        // [ID:0000734][Masahiko.Higuchi] 2012/04 add end

        /**
         * コンストラクタです。
         * 
         * @param reductRate 割引率
         */
        public DivedServiceKind(int reductRate) {
            this.reductRate = reductRate;
        }

        /**
         * 利用票本表を構築します。
         * 
         * @param buildParam 印字内容集合
         * @param isOver30Days 30日超のサービスとして出力するか 
         * @return 次の出力対象行
         * @throws Exception 処理例外
         */
        public int buildUserMainTable(CareServicePrintParameter buildParam, boolean isOver30Days) throws Exception {
            // 行の分割単位なので改ページを考慮する
            // 本票には管理対象内のコードのみ掲載
            VRMap service = DivedServiceKind.this.getMainFormatFirstService();
            if (service != null) {
                String providerName = getCalcurater().getProviderName(service);
                // ページ基本情報を登録
                Iterator it = DivedServiceKind.this.mainParseMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry ent = (Map.Entry) it.next();
                    DivedServiceItem services = (DivedServiceItem) ent
                            .getValue();

                    services.buildUserMainTable(buildParam.getTargetPage(),
                            buildParam.getCurrentRow(), isOver30Days);

                    // 事業者
                    buildParam.getTargetPage().put(
                            "lowerHeader.row" + buildParam.getCurrentRow()
                                    + "Upper.provider", providerName);

                    buildParam.setCurrentRow(buildParam.getCurrentRow() + 1);
                    if (buildParam.getCurrentRow() > getUserMainTableRowCount()) {
                        // ページ送り
                        buildParam.getPages().add(buildParam.getTargetPage());
                        buildParam.setTargetPage((VRMap) buildParam
                                .getFormPage().clone());
                        buildParam.setCurrentRow(1);
                    }
                }
            }
            return buildParam.getCurrentRow();
        }
        /**
         * %加算等に対応するため、別表用の2段階解析を行います。
         * @param providerID 事業所ID
         * @param systemServiceKindDetail サービス種類
         * @throws Exception 処理例外
         */
        public void parseSubSecond(String providerID, int systemServiceKindDetail) throws Exception{
            //2006/06/21 Tozo TANAKA edit-begin 予防訪問介護3級対応のため
            if(CareServiceCommon.isHomeVisitCare(systemServiceKindDetail)&&
                // 2016/7/21 [Yoichiro Kamei] mod - begin 総合事業対応
                    //CareServiceCommon.isPreventService(systemServiceKindDetail)){
                   (CareServiceCommon.isPreventService(systemServiceKindDetail)
                    || CareServiceCommon.isSogojigyoService(systemServiceKindDetail))){
                // 2016/7/21 [Yoichiro Kamei] mod - begin 総合事業対応
                
                //予防訪問介護の場合
                int minUnit = 9999999;
                Object minKey=null;
                List removeKeys = new ArrayList();
                Iterator it = DivedServiceKind.this.subParseMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry ent = (Map.Entry) it.next();
                    Map code = ((DivedServiceItem) ent.getValue()).subFormatCode;
                    if((code!=null)&&(CareServiceCommon.isAddPreventHomeVisitNotDailyBasicCode(code))){
                        //予防訪問介護の日割でない合成単位を意味するサービスコード
                        int unit=ACCastUtilities.toInt(code.get("SERVICE_UNIT"),0);
                        if(unit>0){
                            if(unit<minUnit){
                                //最小単位数を更新
                                if(minKey!=null){
                                    //これまで最小と目されていたコードを除外
                                    removeKeys.add(minKey);
                                }
                                minKey = ent.getKey();
                                minUnit = unit;
                            }else{
                                //最小でないコードを除外
                                removeKeys.add(ent.getKey());
                            }
                        }
                    }
                }
                it = removeKeys.iterator();
                while (it.hasNext()) {
                    //除外対象のコードを省く
                    DivedServiceKind.this.subParseMap.remove(it.next());
                 // 2016/7/30 [CCCX:2865][Yoichiro Kamei] add - begin 
                 // 除外したコードの集計列が表示されていないのを修正
                    DivedServiceKind.this.limitAmoutSize--;
                 // 2016/7/30 [CCCX:2865] add - end
                }
            }
            //2006/06/21 Tozo TANAKA edit-end 予防訪問介護3級対応のため

            // [ID:0000444][Tozo TANAKA] 2009/03/17 replace begin 平成21年4月法改正対応
            Iterator it;
            it = DivedServiceKind.this.subParseMap.entrySet().iterator();
            //基本単価のサービスコードから、コードと単位数を参照するハッシュを構築する。
            Map simpleUnitHash = new HashMap(); 
            
            while (it.hasNext()) {
                Iterator it2 = ((DivedServiceItem) ((Map.Entry) it.next()).getValue()).inInsureUnits.entrySet().iterator();
                while(it2.hasNext()){
                    Map.Entry ent = (Map.Entry)it2.next();
                    Map code = ((DivedServiceUnit) ent.getValue()).code;
                    if(CareServiceCommon.isSimpleUnit(code)){
                        //基本単価のSERVICE_CODE_ITEM : {コード,単位数}
                        simpleUnitHash.put(ACCastUtilities.toString(code.get("SERVICE_CODE_ITEM")), new Object[]{code, ent.getKey()});
                    }
                }
            }            
            //基本単価へサービスコードごとに集計した%加算対象回数を乗じたものを%加算対象単位数として設定する。
            it = DivedServiceKind.this.subParseMap.entrySet().iterator();
            while (it.hasNext()) {
                DivedServiceItem item = (DivedServiceItem) ((Map.Entry) it.next()).getValue();
                int units = 0;
                //給付管理対象外の下位コードを全走査
                Iterator it2 = item.outInsureUnits.entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry ent = (Map.Entry) it2.next();
                    Map code = ((DivedServiceUnit) ent.getValue()).code;
                    if(CareServiceCommon.isAddPercentage(code)){
                        //%加算の対象回数ハッシュから、%加算のコードでハッシュ検索
                        String addServiceCodeItem = ACCastUtilities.toString(code.get("SERVICE_CODE_ITEM"));
                        Object obj;
                        //加算サービスコード : 回数等ハッシュ
                        obj = addPersentageTargetCounts.get(addServiceCodeItem);
                        if(obj instanceof Map){
                            //既出の%加算コード
                            Iterator it3 = ((Map)obj).entrySet().iterator();
                            while (it3.hasNext()) {
                                Map.Entry ent3 = (Map.Entry) it3.next();
                                //基本単位のSERVICE_CODE_ITEM : {回数, 地域系%加算ハッシュ }
                                String simpleCodeItem = ACCastUtilities.toString(ent3.getKey());
                                //{回数, 地域系%加算ハッシュ}
                                Object[] unitParam = (Object[])ent3.getValue();
                                int addCount = ACCastUtilities.toInt(unitParam[0], 0);
                                Map addAreaHash =(Map)unitParam[1];
                                
                                //基本単価のSERVICE_CODE_ITEM : {コード,単位数}
                                obj = simpleUnitHash.get(simpleCodeItem);
                                if(obj instanceof Object[]){
                                    //基本単価を取得する。
                                    //{コード,単位数}
                                    Object[] simpleUnitParams = (Object[])obj;
                                    Map simpleCode = (Map)simpleUnitParams[0];
                                    int simpleUnit = ACCastUtilities.toInt(simpleUnitParams[1], 0);
                                    
                                    int targetUnit = getCalcurater().getReductedUnit(providerID, simpleCode, simpleUnit);
                                    units += targetUnit * addCount;
                                    
                                    if(CareServiceCommon.isAddPercentageForArea(code)){
                                        //所定単位＋地域系%加算を対象とする%加算の場合
                                        int areaTargetUnit = targetUnit;
                                        targetUnit = 0;
                                        Iterator it4 = addAreaHash.entrySet().iterator();
                                        while (it4.hasNext()) {
                                            Map.Entry ent4 = (Map.Entry) it4.next();
                                            //地域系%加算SERVICE_CODE_ITEM : {コード,回数}
                                            Object[] forAreaTargetCodeParam = (Object[])ent4.getValue();
                                            Map forAreaTargetCode = (Map)forAreaTargetCodeParam[0];
                                            int forAreaTargetCodeCount = ((Integer)forAreaTargetCodeParam[1]).intValue();

                                            int per = ACCastUtilities.toInt(forAreaTargetCode.get("SERVICE_UNIT"),0);
                                            // [ID:0000485][Tozo TANAKA] 2009/04/16 replace begin 利用票・別表において中山間地域加算が対象とする単位の集合化区分考慮
                                            //所定単価＋地域系%加算になるよう、地域系%加算分を合算する。
                                            targetUnit += (int)Math.round(areaTargetUnit*forAreaTargetCodeCount*per/100.0);
                                            // [ID:0000485][Tozo TANAKA] 2009/04/16 replace end
                                            
                                        }
                                        //所定単位のみを対象とする%加算の場合は、新たに加えることはしない。
                                        units += targetUnit;
                                    }
                                }
                            }
                        }
                    }
                    // [ID:0000682] 2012/01 start 介護職員処遇改善加算の追加処理
                    if(CareServiceCommon.isAddPercentageForSyogu(code)){
                        // 処遇改善は単位数登録しない
                        continue;
                    }
                    // [ID:0000682] 2012/01 end
                }
                item.setSubPersentageUnit(units);
                // [H27.4改正対応][Yoichiro Kamei] 2015/4/3 add - begin サービス提供体制加算の自己負担対応
                it2 = item.outInsureUnits.entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry ent = (Map.Entry) it2.next();
                    Map code = ((DivedServiceUnit) ent.getValue()).code;
                    VRMap rec = (VRHashMap)((DivedServiceUnit) ent.getValue()).get(0);
                    
                    String providerId = ACCastUtilities.toString(rec.getData("PROVIDER_ID"));
                    String findKey = providerId + "-" + ACCastUtilities.toString(rec.getData("SYSTEM_SERVICE_KIND_DETAIL"));
                    
                    if (regulationHash.containsKey(findKey) && SelfPaymentNumberCalcurater.isTaisho(code)) {
                        String serviceAddFlag = ACCastUtilities.toString((code.get("SERVICE_ADD_FLAG")),"");
                        //自己負担分の単位数を求める
                        int limitOverUnit = ACCastUtilities.toInt(regulationHash.get(findKey));
                        selfPaymentNumberCalcurater.parseServiceCode(code, providerId, limitOverUnit);
                        int selfPayUnit = selfPaymentNumberCalcurater.getSelfPayUnit();
                        regulationHash.put(findKey + "_" + serviceAddFlag, new Integer(selfPayUnit));
                    }
                }
                // [H27.4改正対応][Yoichiro Kamei] 2015/4/3 add - end
            
            }
            // [ID:0000444][Tozo TANAKA] 2009/03/17 replace end
            
            // [ID:0000682] 2012/01 start 介護職員処遇改善加算の追加処理
            // ①給付管理対象内＋給付管理対象外含めてすべての単位数を合計した値を作成する。
            //   ％加算、％減算含めて計算後の値を使用する
            // ②処遇改善加算が存在する場合のみ上記の合計単位数を利用＋特定診療費の値も合計して利用する
            // 処遇改善加算の対象サービスを保持する
            Map syoguUnitHash = new HashMap();
            syoguUnitHash.put(ACCastUtilities.toString(systemServiceKindDetail), 0);
            it = DivedServiceKind.this.subParseMap.entrySet().iterator();
            while (it.hasNext()) {
                DivedServiceItem item = (DivedServiceItem) ((Map.Entry) it.next()).getValue();
                int units = 0;
                int count = 0;
                // 管理対象内
                Iterator it10 = item.inInsureUnits.entrySet().iterator();
                while (it10.hasNext()) {
                    Map.Entry ent = (Map.Entry) it10.next();
                    count = ((DivedServiceUnit) ent.getValue()).size();
                    Map code = ((DivedServiceUnit) ent.getValue()).code;
                    units = ACCastUtilities.toInt(ent.getKey());
                    int reductRate = getCalcurater()
                            .getReductRate(providerID, code);
                    if (reductRate < 100){
                        //割引されている場合
                        if(!CareServiceCommon.isAddPercentage(code)) {
                            units = getCalcurater().toReductedUnit(units, reductRate);
                        }
                    }
                    // 回数を含めて計算
                    units = units * count;
                    if(!CareServiceCommon.isAddPercentageForSyogu(code)){
                      int calcUnit = ACCastUtilities.toInt(syoguUnitHash.get(ACCastUtilities.toString(systemServiceKindDetail)));
                      syoguUnitHash.put(ACCastUtilities.toString(code.get("SYSTEM_SERVICE_KIND_DETAIL")), calcUnit + units);
                    }
                }
                //給付管理対象外の下位コードを全走査
                Iterator it20 = item.outInsureUnits.entrySet().iterator();
                while (it20.hasNext()) {
                    Map.Entry ent = (Map.Entry) it20.next();
                    Map code = ((DivedServiceUnit) ent.getValue()).code;
                    units = ACCastUtilities.toInt(ent.getKey());
                    count = ((DivedServiceUnit) ent.getValue()).size();
                    int reductRate = getCalcurater()
                            .getReductRate(providerID, code);
                    if (reductRate < 100){
                        //割引されている場合
                        if(!CareServiceCommon.isAddPercentage(code)) {
                            units = getCalcurater().toReductedUnit(units, reductRate);
                        }
                    }
                    // 回数を含めて計算
                    units = units * count;
                    if(!CareServiceCommon.isAddPercentageForSyogu(code)){
                        int calcUnit = ACCastUtilities.toInt(syoguUnitHash.get(ACCastUtilities.toString(systemServiceKindDetail)));
                        syoguUnitHash.put(ACCastUtilities.toString(code.get("SYSTEM_SERVICE_KIND_DETAIL")), calcUnit + units);                        
                    }
                }
            }
            
            // ★サービスコードを準備したうえで再度計算を開始する
            ConcurrentHashMap copySubParseMap = new ConcurrentHashMap(DivedServiceKind.this.subParseMap);
            it = copySubParseMap.entrySet().iterator();
            while (it.hasNext()) {
                DivedServiceItem item = (DivedServiceItem) ((Map.Entry) it.next()).getValue();
                int units = 0;
                //給付管理対象外の下位コードを全走査
                //同期処理例外がでるのでHashMapを変更
                ConcurrentHashMap copyOutInsureUnits = new ConcurrentHashMap(item.outInsureUnits);
                Iterator it2 = copyOutInsureUnits.entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry ent = (Map.Entry) it2.next();
                    Map code = ((DivedServiceUnit) ent.getValue()).code;
                    // 介護の処遇改善加算があったら
                    if(CareServiceCommon.isAddPercentageForSyogu(code)){
                        int totalUnit = ACCastUtilities.toInt(syoguUnitHash.get(ACCastUtilities.toString(systemServiceKindDetail)));
                        int totalRegulation = 0;
                        // ％
                        int serviceUnit = ACCastUtilities.toInt(code.get("SERVICE_UNIT"),0);
                        // 処遇改善割合
                        int serviceStaffUnit = ACCastUtilities.toInt(code.get("SERVICE_STAFF_UNIT"),0);
                        // 特定診療費・特別療養費の単位数を合計
                        // 計算処理クラスから値を取得 "事業所番号-内部サービス種類コード" 
                        String serchKey = providerID + "-" + ACCastUtilities.toString(systemServiceKindDetail);
                        if(diagnosisHash.containsKey(serchKey)) {
                            // Debug デバッグ
                            System.out.println("特定診療費・特別療養費 = " + diagnosisHash.get(serchKey));
                            // Debug デバッグ
                            totalUnit += diagnosisHash.get(serchKey);
                        }
                        // 自己負担計算
                        if(regulationHash.containsKey(serchKey)) {
                            // サービス設定自己負担分
                            totalRegulation = regulationHash.get(serchKey);
                            // 特別地域加算
                            if(regulationHash.containsKey(serchKey + "_3")) {
                                totalRegulation += regulationHash.get(serchKey + "_3");
                            }
                            // 中山間地域加算
                            if(regulationHash.containsKey(serchKey + "_6")) {
                                totalRegulation += regulationHash.get(serchKey + "_6");
                            }
                            // [H27.4改正対応][Yoichiro Kamei] 2015/4/3 add - begin サービス提供体制加算の自己負担対応
                            if (regulationHash.containsKey(serchKey + "_2")) {
                                totalRegulation += regulationHash.get(serchKey + "_2");
                            }
                            if (regulationHash.containsKey(serchKey + "_4")) {
                                totalRegulation += regulationHash.get(serchKey + "_4");
                            }
                            // [H27.4改正対応][Yoichiro Kamei] 2015/4/3 add - end
                            
                            // [ID:0000728][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 edit begin
                            int result = CareServiceCommon.calcSyoguPatientSelf(totalUnit, totalRegulation, serviceUnit, serviceStaffUnit);
                            regulationHash.put(serchKey + "_8", result);
                            // [ID:0000728][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 edit end
                        }
                        units = CareServiceCommon.calcSyogu(totalUnit, serviceUnit, serviceStaffUnit);
                        // 計算後の単位数を登録する
                        item.outInsureUnits.put(units, ((DivedServiceUnit) ent.getValue()));

                    }
                }
            }
            
            // [ID:0000682] 2012/01 end
            
        }
        /**
         * 利用票別表を構築します。
         * 
         * @param buildParam 印字内容集合
         * @param provider 事業所情報
         * @param insureRate 保険給付率
         * @param totals 集計情報
         * @param inLimitAmount 給付管理限度額対象を出力するか
         * @param isOver30Days 30日超
         * @return 次の出力対象行
         * @throws Exception 処理例外
         */
        public int buildUserSubTable(CareServicePrintParameter buildParam, Map provider,
                int insureRate, int[] totals, boolean inLimitAmount, boolean isOver30Days)
                throws Exception {

            int limitAmount = isOver30Days? getLimitAmountSizeOver30(): getLimitAmountSize();
            
            Set regulationCache = new HashSet();
            int itemState;
            if (!inLimitAmount) {
                itemState = ITEM_STATE_OUT_LIMIT_AMOUNT;
            } else if (limitAmount > 1) {
                itemState = ITEM_STATE_MULTI_NOT_LAST;
            } else {
                itemState = ITEM_STATE_SINGLE;
            }

            // [ID:0000734][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 add begin
            int over30Count = 0;
            int temp30Count = 0;
            // [ID:0000734][Masahiko.Higuchi] 2012/04 add end
            // 30日超かつ給付管理対象外を計上
            if (isOver30Days) {
                Iterator it = subParseMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry ent = (Map.Entry) it.next();
                    
                    // [ID:0000734][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 add begin
                    // 処遇改善は一度はじく
                    if(syoguMap.containsKey(ent.getKey())){
                        over30Count = temp30Count+1;
                        continue;
                    }
                    // [ID:0000734][Masahiko.Higuchi] 2012/04 add end
                    
                    DivedServiceItem services = (DivedServiceItem) ent
                            .getValue();
                    if (!services.isSubFormatPrintable()) {
                        continue;
                    }
                    // 下位情報構築
                    services.buildUserSubTableOver30Days(buildParam, provider,
                            insureRate, totals);
                    temp30Count++;
                }
                // [ID:0000734][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 add begin
                // 処遇改善を最後に処理したいので、一度はじいてから最終的に処理する
                it = syoguMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry ent = (Map.Entry) it.next();
                    DivedServiceItem services = (DivedServiceItem) ent
                            .getValue();
                    if (!services.isSubFormatPrintable()) {
                        continue;
                    }
                    // 下位情報構築
                    services.buildUserSubTableOver30Days(buildParam, provider,
                            insureRate, totals);
                }
                // [ID:0000734][Masahiko.Higuchi] 2012/04 add end
            }
            
            // [ID:0000734][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 add begin
            temp30Count = 0;
            // [ID:0000734][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 add end
            //メインコード
            int buildIndex = 0;
            Iterator it = subParseMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                DivedServiceItem services = (DivedServiceItem) ent.getValue();
                if (!services.isSubFormatPrintable()) {
                    continue;
                }
                
                if (itemState == ITEM_STATE_MULTI_NOT_LAST) {
                    // 小計出力対象の場合
                    if (++buildIndex >= limitAmount) {
                        // 給付管理対象としては最後のサービスの場合は出力モードを変更
                        itemState = ITEM_STATE_MULTI_LAST;

                    }
                }
                
                // [ID:0000734][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 add begin
                if(isOver30Days) {
                    temp30Count++;
                }
                if(temp30Count >= subParseMap.size()) {
                    if(over30Count == temp30Count) {
                        itemState = ITEM_STATE_MULTI_LAST;
                    }
                }
                // [ID:0000734][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 add end
                
                // 下位情報構築
                int beforeIndex = buildParam.getCurrentRow();
                int afterIndex = services.buildUserSubTable(buildParam,
                        provider, insureRate, totals, itemState, regulationCache, isOver30Days);
                if(beforeIndex!=afterIndex){
                    buildParam.setCurrentRow(afterIndex);
                }else{
                    buildIndex--;
                }
//                buildParam.setCurrentRow(services.buildUserSubTable(buildParam,
//                        provider, insureRate, totals, itemState, regulationCache, isOver30Days));
                
                //[H27.4改正対応][Shinobu Hitaka] 2015/3/30 add - begin
                //30日超の場合に支給限度額対象外の項目を出力する（サービス提供体制強化加算が限度額管理外になったため）
            	if (isOver30Days){
	                int[] dummyTotal = new int[totals.length];
	                Map outMap = ((DivedServiceItem) ent.getValue()).outInsureOver30Units;
	                Iterator outIt = outMap.entrySet().iterator();
	                while (outIt.hasNext()) {
	                    Map.Entry outEnt = (Map.Entry) outIt.next();
	                    DivedServiceUnit outService = (DivedServiceUnit)outEnt.getValue();
	                    outService.buildUserSubTableDetailRow(buildParam, provider,
	                        0, dummyTotal, isOver30Days);
	                    buildParam.setCurrentRow(buildParam.getCurrentRow() + 1);
	                }
                }
            	//[H27.4改正対応][Shinobu Hitaka] 2015/3/30 add - end
            }
        	
            return buildParam.getCurrentRow();
        }

        /**
         * 支給管理限度額内のサービス数を返します。
         * 
         * @return 支給管理限度額内のサービス数
         */
        protected int getLimitAmountSize() {
            return limitAmoutSize;
        }

        /**
         * 30日超の支給管理限度額内のサービス数を返します。
         * 
         * @return 30日超の支給管理限度額内のサービス数
         */
        protected int getLimitAmountSizeOver30() {
            return limitAmoutSizeOver30;
        }

        /**
         * 1つめのサービス情報を返します。
         * 
         * @return 1つめのサービス情報
         */
        public VRMap getMainFormatFirstService() {
            if (mainParseMap.size() > 0) {
                Iterator it = mainParseMap.values().iterator();
                while (it.hasNext()) {
                    VRMap result = ((DivedServiceItem) it.next())
                            .getMainFormatFirstService();
                    if (result != null) {
                        return result;
                    }
                }
            }
            return null;
        }

        /**
         * 1つめのサービス情報を返します。
         * 
         * @return 1つめのサービス情報
         */
        public VRMap getSubFormatFirstService() {
            if (subParseMap.size() > 0) {
                Iterator it = subParseMap.values().iterator();
                while (it.hasNext()) {
                    VRMap result = ((DivedServiceItem) it.next())
                            .getSubFormatFirstService();
                    if (result != null) {
                        return result;
                    }
                }
            }
            return null;
        }

        /**
         * サービスを解析します。
         * 
         * @param services サービス
         * @param totalGroupingCache 月/日単位算定キャシュ
         * @throws Exception 処理例外
         */
        public void parseMainTable(VRMap service, Map[] totalGroupingCache)
                throws Exception {
            // サービスコード取得
            codes = getCalcurater().getServiceCodes(service);


            Iterator it = codes.iterator();
            while (it.hasNext()) {
                Map code = (Map) it.next();
                if (getCalcurater().isInSpecialFacility(code)) {
                    // [ID:0000627][Masahiko Higuchi] 2011/03 replace begin 他科受診・外泊加算等の本票への印字
                    // 特定施設入居者に関するコードは除外
                    continue;
                    // [ID:0000627][Masahiko Higuchi] 2011/03 replace end
                }

                if (isMainFormatPrintable(service, code)) {
                    // 本表に印字可能なサービスコードのみ追加
                    Object key = code.get("SERVICE_CODE_ITEM");
                    if (key == null) {
                        key = "";
                    }
                    Object val = DivedServiceKind.this.mainParseMap.get(key);
                    DivedServiceItem page;
                    // サービス内容で分岐
                    if (val instanceof DivedServiceItem) {
                        page = (DivedServiceItem) val;
                    } else {
                        page = new DivedServiceItem();
                        DivedServiceKind.this.mainParseMap.put(key, page);
                    }

                    // 同一サービス内容内で分類
                    page.parseMain(service, code);
                }

            }
        }
        /**
         * 本表へ印字可能なサービスであるかを返します。
         * 
         * @return 本表へ印字可能なサービスであるか
         */
        protected boolean isMainFormatPrintable(VRMap service, Map code)
        		throws Exception {
            
            // [ID:0000532][Masahiko Higuchi] 2009/08 add begin 2009年度対応
            boolean isNotPrint = false;
            // 本票に印字するのキーがない場合はサービス提供データとして扱う
            // 予防特定入居者生活介護のみ異なるバインドパス
            String[] checkBindPath = { "15", "1350129", "1350130", "1350131" };
            
            for (int i = 0; i < checkBindPath.length; i++) {
                // 本票に印字するチェックが存在する場合
                if (ACCastUtilities.toInt(service.getData(checkBindPath[i]), 0) == 1) {
                    // チェックがない場合のみ提供日以外のデータとする
                    isNotPrint = true;
                    break;
                }   
            }
            
            if(isNotPrint) {
                return false;
            }
            // [ID:0000532][Masahiko Higuchi] 2009/08 add end
            
            // TODO
            // [H27.4改正対応][Shinobu Hitaka] 2015/3/10 edit - begin 区分支給基準限度額管理対象外の印字ON/OFFに対応。
            // 施設系/準施設系サービスか給付管理限度額対象内の場合は本表に印字する。
            // ※施設系や居宅療養管理指導を印字しない場合は、parseの時点で削られている。
            // del - begin
            //return CareServiceCommon.isServiceUseTableMainFormatPrintableCode(code)
            //        || CareServiceCommon.isFacility(service)
            //        || CareServiceCommon.isLifeCare(service)
            //        || CareServiceCommon.isHomeMedicalAdvice(service)
            //        ;
            // del - end
            // add - start
            // 以下を印刷対象とする。
            // 支給限度額管理対象外・緊急時訪問看護加算・特別管理加算・ターミナルケア加算・緊急時治療管理
            // ただし、以下は設定画面のON/OFFに従う
            // 特別地域加算・小規模事業所加算、中山間地域提供加算、介護職員処遇改善加算
            return (!CareServiceCommon.isAddSpecialAreaOfWelfareEquipment(code)	// 福祉用具の特別地域加算以外
                    && !CareServiceCommon.isAddPercentageForSimple(code)		// 特別地域加算・小規模事業所加算以外
                    && !CareServiceCommon.isAddPercentageForArea(code))			// 中山間地域提供加算以外
                    && !CareServiceCommon.isAddPercentageForSyogu(code)			// 介護職員処遇改善加算以外
                    || (CareServiceCommon.isAddSpecialAreaOfWelfareEquipment(code) && isPrintSpecialArea())	// 福祉用具の特別地域加算
                    || (CareServiceCommon.isAddPercentageForSimple(code) && isPrintSpecialArea())			// 特別地域加算・小規模事業所加算
                    || (CareServiceCommon.isAddPercentageForArea(code) && isPrintChusankanArea())			// 中山間地域提供加算
                    || (CareServiceCommon.isAddPercentageForSyogu(code) && isPrintSyoguKaizen())			// 介護職員処遇改善加算
                    || CareServiceCommon.isFacility(service)			// 施設
                    || CareServiceCommon.isLifeCare(service)			// 準施設
                    || CareServiceCommon.isHomeMedicalAdvice(service)	// 居宅療養管理指導
                    ;
            // add - end
            // [H27.4改正対応][Shinobu Hitaka] 2015/3/10 edit - end 
        }

        /**
         * サービスを解析します。
         * 
         * @param services サービス
         * @param totalGroupingCache 月/日単位算定キャシュ
         * @throws Exception 処理例外
         */
        public void parseSubTable(VRMap service, Map[] totalGroupingCache)
                throws Exception {
            VRMap serviceAddFlagMap = new VRHashMap();
            
            // サービスコード取得
            codes = getCalcurater().getServiceCodes(service);

            // [ID:0000444][Tozo TANAKA] 2009/03/18 add begin 平成21年4月法改正対応
            List simpleServiceCodeItems = new ArrayList();
            // [ID:0000444][Tozo TANAKA] 2009/03/18 add end
            // 合算単位
            int calcurateUnit = 0;
            Iterator it = codes.iterator();
            while (it.hasNext()) {
                Map code = (Map) it.next();
                if (getCalcurater().isInSpecialFacility(code)) {
                    // 特定施設入居者に関するコードは除外
                    // [CCCX:1647][Shinobu Hitaka] 2014/05/08 replace begin 他科受診・外泊加算等の計上
                    //return;
                    continue;
                    // [CCCX:1647][Shinobu Hitaka] 2014/05/08 replace end   他科受診・外泊加算等の計上
                }

                // 別表用階層解析
                calcurateUnit = parseSub(service, totalGroupingCache, code,
                        calcurateUnit);

                // [ID:0000444][Tozo TANAKA] 2009/03/18 add begin 平成21年4月法改正対応
                if(CareServiceCommon.isSimpleUnit(code)){
                    //このサービスの基本単価
                    simpleServiceCodeItems.add(ACCastUtilities.toString(code.get("SERVICE_CODE_ITEM")));
                    serviceAddFlagMap.setData(ACCastUtilities.toString(code.get("SERVICE_CODE_ITEM")), code.get("TOTAL_GROUPING_TYPE"));
                }
                // [ID:0000444][Tozo TANAKA] 2009/03/18 add end
            }
            
            // [ID:0000444][Tozo TANAKA] 2009/03/18 add begin 平成21年4月法改正対応
            //コードごとに基本単価を乗じたものを累積していく
            
            //【仕様説明】
            //「中山間地域等でのサービス提供加算」は、%加算のサービスコードである。
            //同様に%加算のサービスコードとして、「特別地域加算」や(中山間地域等の)「小規模事業所加算」がある。
            //後者は事業所体制の一種であり、「所定単位数(基本単位数)」に対して任意の%を加算するもので、他の加算の有無には影響を受けない。
            //しかし前者は利用者の状況に依存する提供加算であり、「所定単位数(基本単位数)＋地域系%加算」に対して任意の%を加算するものである。
            //ここでは、前者を「%加算(対象に地域系加算を含む)」と称する。
            //後者の「%加算(対象に地域系加算を含まない)」は、今のところ「特別地域加算」や(中山間地域等の)「小規模事業所加算」のみであるが、
            //その両方を「地域系%加算」と称する。
            //＜ポイント1＞
            //　「%加算(対象に地域系加算を含む)」が対象とする単位数は、「地域系%加算」を求めた後でないと計算できない。
            //
            //提供加算は、画面上、ラジオであり・なしを切り替えることが多く、同月内・同利用者・同事業所であっても、算定するときと算定しないときがある。
            //したがって、「%加算(対象に地域系加算を含む)」が対象とする基本単位は、同加算を提供したときの基本単位に限らねばならない。
            //また、事業所体制である「地域系%加算」は、通常、同一事業所であれば提供分すべてが対象になる加算だが、
            //「%加算(対象に地域系加算を含む)」が対象とする「地域系%加算」は、このうち同加算を提供したときの「地域系%加算」に限らねばならない。
            //＜ポイント2＞
            //　「%加算(対象に地域系加算を含む)」が対象とする「地域系%加算」は、提供分すべてにかかる「地域系%加算」とは別に、
            //　「%加算(対象に地域系加算を含む)」を提供したときに限って集計せねばならない。
            //
            //別表用の解析処理「parseSub～」は、サービスの提供情報を解析し、サービスコード単位にばらす処理を行う。
            //ばらし終わったあとは「加算Aを提供したときに加算Bを提供したか」というサービスコード同士の関連性を辿ることはできない。
            //このため、サービスコード単位にばらす処理と同時に、%加算の対象となる「所定単位数(基本単位数)」やそのサービスコードを、
            //%加算のサービスコードと関連付けて退避しておかねばならない。
            //※この関連付けを退避したものが、クラス内変数addPersentageTargetCountsである。
            //
            //関連付けの退避は、以下の手順で実装される。
            //(1)まず最初に「%加算(対象に地域系加算を含む)」のサービスコードがあるかを走査する。
            //　(2)「%加算(対象に地域系加算を含む)」が対象とすべき「基本単位(所定単位)」のサービスコードと提供回数を蓄積する。
            //　(3)「地域系%加算」と関連付けるべき「%加算(対象に地域系加算を含む)」としてストックする。
            //(4)続いて「%加算(対象に地域系加算を含まない)」のサービスコードがあるかを走査する。
            //　(5)「%加算(対象に地域系加算を含まない)」が対象とすべき「基本単位(所定単位)」のサービスコードと提供回数を蓄積する。
            //　(6)関連付けるべき「%加算(対象に地域系加算を含む)」がストックされているかを確認する。
            //　　(7)「%加算(対象に地域系加算を含む)」が対象とすべき「地域系%加算」のサービスコードと提供回数を蓄積する。
            //
            
            // [ID:0000485][Tozo TANAKA] 2009/04/15 add begin 利用票・別表において中山間地域加算が対象とする単位の集合化区分考慮
            int serviceDayOfMonth = 100;
            Date serviceDate = ACCastUtilities.toDate(VRBindPathParser.get(
                    "SERVICE_DATE", service), null);
            if (serviceDate != null) {
                serviceDayOfMonth = ACDateUtilities
                        .getDayOfMonth((Date) serviceDate);
            }
            // [ID:0000485][Tozo TANAKA] 2009/04/15 add end
            
            //(1)まず最初に「%加算(対象に地域系加算を含む)」のサービスコードがあるかを走査する。
            Map forAreaCodes = new HashMap();
            it = codes.iterator();
            while (it.hasNext()) {
                Map code = (Map) it.next();
                if(CareServiceCommon.isAddPercentageForArea(code)){
                    //%加算のサービスコードの場合
                    
                    //%加算の対象回数ハッシュから、%加算のコードでハッシュ検索
                    String addServiceCodeItem = ACCastUtilities.toString(code.get("SERVICE_CODE_ITEM"));

                    Object obj;
                    Map simpleUnits;
                    obj = addPersentageTargetCounts.get(addServiceCodeItem);
                    if(obj instanceof Map){
                        //既出の%加算コード
                        simpleUnits = (Map)obj;
                    }else{
                        //新規の%加算コード
                        simpleUnits = new HashMap();
                        addPersentageTargetCounts.put(addServiceCodeItem, simpleUnits);
                    }
                    //当該%加算コードが対象とする基本単位コードで下位ハッシュ検索
                    Iterator it2 = simpleServiceCodeItems.iterator();
                    while(it2.hasNext()){
                        //(2)「%加算(対象に地域系加算を含む)」が対象とすべき「基本単位(所定単位)」のサービスコードと提供回数を蓄積する。
                        String simpleServiceCodeItem = ACCastUtilities.toString(it2.next());
                        
                        int totalGroupingType = ACCastUtilities.toInt(serviceAddFlagMap.get(simpleServiceCodeItem), 0);
                        
                        //基本SERVICE_CODE_ITEM : {回数, 地域系%加算ハッシュ} 
                        obj = simpleUnits.get(simpleServiceCodeItem);
                        Object[] unitParam;
                        if(obj instanceof Object[]){
                            //この%加算コードにおいて、既出の基本単位コード
                            unitParam = (Object[])obj;

                            // [ID:0000485][Tozo TANAKA] 2009/04/15 replace begin 利用票・別表において中山間地域加算が対象とする単位の集合化区分考慮
                            //unitParam[0] = new Integer( ((Integer)unitParam[0]).intValue() +1);
                            boolean canCountUp = true;
                            switch(totalGroupingType){
                            case 2:
                                //日単位算定
                                boolean[] groupingFlags = (boolean[])unitParam[2];
                                if(groupingFlags.length > serviceDayOfMonth){
                                    if(groupingFlags[serviceDayOfMonth]){
                                        //当該サービス提供日のフラグがtrueならば、同日提供済みなのでカウントアップを許さずcontinueする。
                                        canCountUp = false;
                                    }else{
                                        //当該サービス提供日のフラグをtrueにする。
                                        groupingFlags[serviceDayOfMonth] = true;
                                    }
                                }
                                break;
                            case 3:
                                //月単位算定
                                //月単位で既出ということはカウントアップを許さずcontinueする。
                                canCountUp = false;
                                break;
                            }
                            if(canCountUp){
                                unitParam[0] = new Integer( ((Integer)unitParam[0]).intValue() +1);
                            }
                            // [ID:0000485][Tozo TANAKA] 2009/04/15 replace end

                        }else{
                            // [ID:0000485][Tozo TANAKA] 2009/04/15 replace begin 利用票・別表において中山間地域加算が対象とする単位の集合化区分考慮
                            //unitParam = new Object[]{new Integer(1), new HashMap()};
                            unitParam = new Object[]{new Integer(1), new HashMap(), new boolean[33]};
                            switch(totalGroupingType){
                            case 2:
                                //日単位算定
                                boolean[] groupingFlags = (boolean[])unitParam[2];
                                if(groupingFlags.length > serviceDayOfMonth){
                                    //当該サービス提供日のフラグをtrueにしておく。
                                    groupingFlags[serviceDayOfMonth] = true;
                                }
                                break;
                            }
                            // [ID:0000485][Tozo TANAKA] 2009/04/15 add end
                        }
                        //この%加算コードにおいて、当該基本単位コードが対象となった回数を更新する。
                        simpleUnits.put(simpleServiceCodeItem, unitParam);
                        
                        //(3)「地域系%加算」と関連付けるべき「%加算(対象に地域系加算を含む)」としてストックする。
                        //所定単位＋地域等加算を対象にする%加算のハッシュに追加する。
                        forAreaCodes.put(simpleServiceCodeItem, unitParam);
                    }
                    
                }
            }
            
            //(4)続いて「%加算(対象に地域系加算を含まない)」のサービスコードがあるかを走査する。
            it = codes.iterator();
            while (it.hasNext()) {
                Map code = (Map) it.next();
                if(CareServiceCommon.isAddPercentageForSimple(code)){
                    //%加算のサービスコードの場合
                    
                    //%加算の対象回数ハッシュから、%加算のコードでハッシュ検索
                    String addServiceCodeItem = ACCastUtilities.toString(code.get("SERVICE_CODE_ITEM"));
                    
                    Object obj;
                    //加算サービスコード : 回数等ハッシュ
                    Map simpleUnits;
                    obj = addPersentageTargetCounts.get(addServiceCodeItem);
                    if(obj instanceof Map){
                        //既出の%加算コード
                        simpleUnits = (Map)obj;
                    }else{
                        //新規の%加算コード
                        simpleUnits = new HashMap();
                        addPersentageTargetCounts.put(addServiceCodeItem, simpleUnits);
                    }
                    //当該%加算コードが対象とする基本単位コードで下位ハッシュ検索
                    Iterator it2 = simpleServiceCodeItems.iterator();
                    while(it2.hasNext()){
                        //(5)「%加算(対象に地域系加算を含まない)」が対象とすべき「基本単位(所定単位)」のサービスコードと提供回数を蓄積する。
                        String simpleServiceCodeItem = ACCastUtilities.toString(it2.next());
                        
                        int totalGroupingType = ACCastUtilities.toInt(serviceAddFlagMap.get(simpleServiceCodeItem), 0);
                        
                        //基本SERVICE_CODE_ITEM : {回数, 地域系%加算ハッシュ} 
                        obj = simpleUnits.get(simpleServiceCodeItem);
                        Object[] unitParam;
                        if(obj instanceof Object[]){
                            //この%加算コードにおいて、既出の基本単位コード
                            unitParam = (Object[])obj;
                            
                            // [ID:0000485][Tozo TANAKA] 2009/04/15 replace begin 利用票・別表において中山間地域加算が対象とする単位の集合化区分考慮
                            //unitParam[0] = new Integer( ((Integer)unitParam[0]).intValue() +1);
                            boolean canCountUp = true;
                            switch(totalGroupingType){
                            case 2:
                                //日単位算定
                                boolean[] groupingFlags = (boolean[])unitParam[2];
                                if(groupingFlags.length > serviceDayOfMonth){
                                    if(groupingFlags[serviceDayOfMonth]){
                                        //当該サービス提供日のフラグがtrueならば、同日提供済みなのでカウントアップを許さずcontinueする。
                                        canCountUp = false;
                                    }else{
                                        //当該サービス提供日のフラグをtrueにする。
                                        groupingFlags[serviceDayOfMonth] = true;
                                    }
                                }
                                break;
                            case 3:
                                //月単位算定
                                //月単位で既出ということはカウントアップを許さずcontinueする。
                                canCountUp = false;
                                break;
                            }
                            if(canCountUp){
                                unitParam[0] = new Integer( ((Integer)unitParam[0]).intValue() +1);
                            }
                            // [ID:0000485][Tozo TANAKA] 2009/04/15 replace end
                            
                        }else{
                            // [ID:0000485][Tozo TANAKA] 2009/04/15 replace begin 利用票・別表において中山間地域加算が対象とする単位の集合化区分考慮
                            //unitParam = new Object[]{new Integer(1), new HashMap()};
                            unitParam = new Object[]{new Integer(1), new HashMap(), new boolean[33]};
                            switch(totalGroupingType){
                            case 2:
                                //日単位算定
                                boolean[] groupingFlags = (boolean[])unitParam[2];
                                if(groupingFlags.length > serviceDayOfMonth){
                                    //当該サービス提供日のフラグをtrueにしておく。
                                    groupingFlags[serviceDayOfMonth] = true;
                                }
                                break;
                            }
                            // [ID:0000485][Tozo TANAKA] 2009/04/15 replace end
                        }
                        //この%加算コードにおいて、当該基本単位コードが対象となった回数を更新する。
                        simpleUnits.put(simpleServiceCodeItem, unitParam);
                        
                        //さらに「地域系%加算」でもあるかを確認する。
                        if(CareServiceCommon.isAddPercentageForAreaTarget(code)){
                            //地域系加算サービスコード(特別地域、中山間等小規模)の場合
                            //(6)関連付けるべき「%加算(対象に地域系加算を含む)」がストックされているかを確認する。
                            obj = forAreaCodes.get(simpleServiceCodeItem);
                            if (obj instanceof Object[]) {
                                Object[] forAreaCodeParam = (Object[]) obj;
                                if ((forAreaCodeParam.length >= 2)
                                        && (forAreaCodeParam[1] instanceof Map)) {
                                    //(7)「%加算(対象に地域系加算を含む)」が対象とすべき「地域系%加算」のサービスコードと提供回数を蓄積する。
                                    //「%加算(対象に地域系加算を含む)」の対象
                                    
                                    // 所定単位＋地域等加算を対象にする%加算も指定されている場合
                                    // 所定単位＋地域等加算を対象にする%加算に対し、対応する地域系加算の指定回数を蓄積する。
                                    Map forAreaTargetCodes = (Map) forAreaCodeParam[1];
                                    Object[] forAreaTargetCodeParam;
                                    //地域系%加算SERVICE_CODE_ITEM : {コード,回数}
                                    obj = forAreaTargetCodes
                                            .get(addServiceCodeItem);
                                    if (obj instanceof Object[]) {
                                        forAreaTargetCodeParam = (Object[])obj;

                                        // [ID:0000485][Tozo TANAKA] 2009/04/16 replace begin 利用票・別表において中山間地域加算が対象とする単位の集合化区分考慮
                                        //forAreaTargetCodeParam[1] = new Integer(((Integer) forAreaTargetCodeParam[1]).intValue() + 1);
                                        boolean canCountUp = true;
                                        switch(totalGroupingType){
                                        case 2:
                                            //日単位算定
                                            boolean[] groupingFlags = (boolean[])forAreaTargetCodeParam[2];
                                            if(groupingFlags.length > serviceDayOfMonth){
                                                if(groupingFlags[serviceDayOfMonth]){
                                                    //当該サービス提供日のフラグがtrueならば、同日提供済みなのでカウントアップを許さずcontinueする。
                                                    canCountUp = false;
                                                }else{
                                                    //当該サービス提供日のフラグをtrueにする。
                                                    groupingFlags[serviceDayOfMonth] = true;
                                                }
                                            }
                                            break;
                                        case 3:
                                            //月単位算定
                                            //月単位で既出ということはカウントアップを許さずcontinueする。
                                            canCountUp = false;
                                            break;
                                        }
                                        if(canCountUp){
                                            forAreaTargetCodeParam[1] = new Integer(((Integer) forAreaTargetCodeParam[1]).intValue() + 1);
                                        }
                                        // [ID:0000485][Tozo TANAKA] 2009/04/16 replace end
                                    } else {
                                        
                                        // [ID:0000485][Tozo TANAKA] 2009/04/16 replace begin 利用票・別表において中山間地域加算が対象とする単位の集合化区分考慮
                                        //forAreaTargetCodeParam = new Object[]{code, new Integer(1)};
                                        forAreaTargetCodeParam = new Object[]{code, new Integer(1), new boolean[33]};
                                        switch(totalGroupingType){
                                        case 2:
                                            //日単位算定
                                            boolean[] groupingFlags = (boolean[])forAreaTargetCodeParam[2];
                                            if(groupingFlags.length > serviceDayOfMonth){
                                                //当該サービス提供日のフラグをtrueにしておく。
                                                groupingFlags[serviceDayOfMonth] = true;
                                            }
                                            break;
                                        }
                                        // [ID:0000485][Tozo TANAKA] 2009/04/16 replace end
                                        forAreaTargetCodes.put(addServiceCodeItem, forAreaTargetCodeParam);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            // [ID:0000444][Tozo TANAKA] 2009/03/18 add end
            
        }
        
        /**
         * 別表用に解析します。
         * 
         * @param services サービス
         * @param totalGroupingCache 月/日単位算定キャシュ
         * @param code サービスコード
         * @param calcurateUnit ここまでの計算単位数
         * @return 当該サービスコード演算後の単位数
         * @throws Exception 処理例外
         */
        protected int parseSub(VRMap service, Map[] totalGroupingCache,
                Map code, int calcurateUnit) throws Exception {

            // === 日割りロジック変更に伴い削除
//            // 2008/06/19 [Masahiko Higuchi] add - begin 定額報酬サービス日割対応
//            // 解析後のサービスと元のMapの同期を取る
//            if (QkanValidServiceManager.getInstance().containsAnalyzeKey(
//                    service, "ORIGINAL")) {
//                // 解析が行われており尚且つユーザーが設定したデータは解析対象外にする。
//                return calcurateUnit;
//            }
//            // 2008/06/19 [Masahiko Higuchi] add - end
            
            Object key = code.get("SERVICE_CODE_ITEM");
            if (key == null) {
                key = "";
            }
            Object val = subParseMap.get(key);
            DivedServiceItem page;
            // サービス内容で分岐
            if (val instanceof DivedServiceItem) {
                //既出
                if(CareServiceCommon.isAddPercentage(code)){
                    // [ID:0000734][Masahiko.Higuchi] 2012/04 ％系加算の30日超対応 edit begin
                    // 30日超の場合はスキップを解除する
                    if(!CareServiceCommon.is30DayOver(service)) {
                        //%加算は1回だけ計上するのでスキップ
                        return calcurateUnit;
                    }
                    // [ID:0000734][Masahiko.Higuchi] 2012/04 edit end
                }                
                page = (DivedServiceItem) val;
            } else {
                //新規
                page = new DivedServiceItem();
                subParseMap.put(key, page);
                // [ID:0000734][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 add begin
                // 処遇改善加算を退避
                if(CareServiceCommon.isAddPercentageForSyogu(code)) {
                    syoguMap.put(key, page);
                }
                // [ID:0000734][Masahiko.Higuchi] 2012/04 add end
            }

            if (CareServiceCommon.isInLimitAmount(code)) {
                //給付管理限度額対象のコードの場合
                //30日超とそれ以外を区別しつつ、給付管理限度額対象の項目数を重複なく計算する。
                String hadImteSetKey = ACCastUtilities.toString(key);
                if(CareServiceCommon.is30DayOver(service)){
                    //30日超ならばキーを連結して別のコードとみなす。
                    hadImteSetKey = hadImteSetKey+"&30";
                    if(!hadItemSet.contains(hadImteSetKey)){
                        //新規な項目であれば30日超の給付管理限度額対象の項目数を加算する。
                        hadItemSet.add(hadImteSetKey);
                        limitAmoutSizeOver30++;
                    }
                }else{
                    // 2008/01/07 [Masahiko Higuchi] edit - begin 定額報酬サービス日割対応
                    // === 日割りロジック変更に伴い、条件変更 ===
                    //if(!hadItemSet.contains(hadImteSetKey) && isSubParseCustom(service)){
                    if(!hadItemSet.contains(hadImteSetKey)){
                    // 2008/01/07 [Masahiko Higuchi] edit - end
                        //新規な項目であれば給付管理限度額対象の項目数を加算する。
                        hadItemSet.add(hadImteSetKey);
                        limitAmoutSize++;
                    }
                }
            } else {
                // [ID:0000734][Masahiko.Higuchi] 2012/04 30日超処遇改善加算対応 add begin
                String hadImteSetKey = ACCastUtilities.toString(key);
                if(CareServiceCommon.is30DayOver(service) && CareServiceCommon.isAddPercentageForSyogu(code)){
                    //30日超ならばキーを連結して別のコードとみなす。
                    hadImteSetKey = hadImteSetKey+"&30";
                    if(!hadItemSet.contains(hadImteSetKey)){
                        //新規な項目であれば30日超の給付管理限度額対象の項目数を加算する。
                        hadItemSet.add(hadImteSetKey);
                        limitAmoutSizeOver30++;
                    }
                }
                // [ID:0000734][Masahiko.Higuchi] 2012/04 add end
            }

            // 同一サービス内容内で分類
            return page.parseSub(service, code, totalGroupingCache,
                    calcurateUnit, reductRate);
        }
        
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Iterator it = subParseMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                sb.append("│││├サービス内容：");
                sb.append(ent.getKey());
                sb.append(ACConstants.LINE_SEPARATOR);
                sb.append(ent.getValue());
            }
            sb.append(ACConstants.LINE_SEPARATOR);
            sb.append("││││└サービスコード：");
            sb.append(codes);
            return sb.toString();
        }

    }

    /**
     * サービス提供時間単位で切り替わるページデータです。
     * <p>
     * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
     * </p>
     * 
     * @author Tozo Tanaka
     * @version 1.0 2006/02/15
     */
    protected class DivedServiceTime extends TreeMap {
        
        /**
         * 新規にサービスを追加します。
         * 
         * @param service サービス
         * @throws Exception 処理例外
         */
        public void parseMainTable(VRMap service) throws Exception {
            Object key = service.get("PROVIDER_ID");
            if (key == null) {
                key = "";
            }
            
            // 2008/01/07 [Masahiko Higuchi] edit - begin 定額報酬サービス日割対応
            if(isParseCustom(service)){
            // 2008/01/07 [Masahiko Higuchi] edit - end
            
                Object val = DivedServiceTime.this.get(key);
                DivedProvider page;
                // 事業所番号で分岐
                if (val instanceof DivedProvider) {
                    page = (DivedProvider) val;
                } else {
                    page = new DivedProvider();
                    DivedServiceTime.this.put(key, page);
                }
                // 同一事業所番号内で分類
                page.parseMainTable(service, ACCastUtilities.toString(key));
                
            }

        }

      /**
      * 利用票本表を構築します。
      * 
         * @param buildParam 印字内容集合
         * @return 次の出力対象行
      * @throws Exception 処理例外
      */
     public int buildUserMainTable(CareServicePrintParameter buildParam) throws Exception {
         Iterator it = DivedServiceTime.this.entrySet().iterator();
         while (it.hasNext()) {
             Map.Entry ent = (Map.Entry) it.next();
             DivedProvider services = (DivedProvider) ent.getValue();

             // 下位情報構築
             buildParam.setCurrentRow(services
                     .buildUserMainTable(buildParam));
         }
         return buildParam.getCurrentRow();
     }

        /**
         * 1つめのサービス情報を返します。
         * 
         * @return 1つめのサービス情報
         */
        public VRMap getFirstService() {
            if (DivedServiceTime.this.size() > 0) {
                Iterator it = DivedServiceTime.this.values().iterator();
                while (it.hasNext()) {
                    VRMap result = ((DivedProvider) it.next())
                            .getMainFormatFirstService();
                    if (result != null) {
                        return result;
                    }
                }
            }
            return null;
        }
                
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Iterator it = DivedServiceTime.this.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                sb.append("││││├サービス提供時刻：");
                sb.append(ent.getKey());
                sb.append(ACConstants.LINE_SEPARATOR);
                sb.append(ent.getValue());
            }
            return sb.toString();
        }
    }

    /**
     * サービス単位で切り替わるページデータです。
     * <p>
     * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
     * </p>
     * 
     * @author Tozo Tanaka
     * @version 1.0 2006/02/15
     */
    protected class DivedServiceUnit extends ArrayList {
        private Map code;

        /**
         * 利用票別表を構築します。
         * <p>
         * 小計を含まない明細行を構築します。
         * </p>
         * 
         * @param buildParam 印字内容集合
         * @param provider 事業所
         * @param unit 単位
         * @param totals 集計情報
         * @param isOver30Days 30日超
         * @throws Exception 処理例外
         */
        public void buildUserSubTableDetailRow(CareServicePrintParameter buildParam,
                Map provider, int unit, int[] totals, boolean isOver30Days) throws Exception {
            // 事業所情報を構築
            String providerID = buildUserSubTableProviderFields(buildParam,
                    provider);
            buildUserSubTableDetailFields(buildParam, unit, totals, providerID, isOver30Days);
        }

        /**
         * 利用票別表を構築します。
         * <p>
         * 小計を含む明細行を構築します。
         * </p>
         * 
         * @param buildParam 印字内容集合
         * @param provider 事業所
         * @param insureRate 保険給付率
         * @param unit 単位
         * @param totals 集計情報
         * @param addHesesOnName 括弧を付けて表示するか
         * @param outOfLimitAmount 給付管理限度額対象外か
         * @throws Exception 処理例外
         */
        public void buildUserSubTableTotalDetailRow(CareServicePrintParameter buildParam,
                Map provider, int insureRate, int unit, int[] totals,
                boolean addHesesOnName, boolean outOfLimitAmount, boolean isOver30Days)
                throws Exception {

            // 事業所情報を構築
            String providerID = buildUserSubTableProviderFields(buildParam,
                    provider);
            // 明細列を構築
            buildUserSubTableDetailFields(buildParam, unit, totals, providerID,isOver30Days);

            if (outOfLimitAmount) {
                // 給付管理対象外などで自費調整を無視する場合
                totals[INDEX_OF_LIMIT_OVER_UNIT_FOR_DETAIL] = 0;
            }
            // 小計列を構築
            buildUserSubTableTotalFields(buildParam, provider, insureRate,
                    totals, addHesesOnName, isOver30Days);

            // サービス単位/金額
            String unitText = String
                    .valueOf(totals[INDEX_OF_SERVICE_UNIT_FOR_DETAIL]);
            if (addHesesOnName) {
                unitText = "(" + unitText + ")";
            }
            printCell(buildParam, 9, unitText, isOver30Days);
            totals[INDEX_OF_SERVICE_UNIT_FOR_DETAIL] = 0;
        }

        /**
         * 利用票別表を構築します。
         * <p>
         * 小計行を構築します。
         * </p>
         * 
         * @param buildParam 印字内容集合
         * @param provider 事業所
         * @param insureRate 保険給付率
         * @param unit 単位
         * @param totals 集計情報
         * @param isOver30Days 30日超
         * @throws Exception 処理例外
         */
        public void buildUserSubTableTotalRow(CareServicePrintParameter buildParam,
                Map provider, int insureRate, int[] totals, boolean isOver30Days) throws Exception {
            // 事業所情報を構築
            buildUserSubTableProviderFields(buildParam, provider);

            String serviceName = getCalcurater().getServiceKindName(
                    getFirstService())
                    + "計";
            if(isOver30Days){
                serviceName = "30日超"+ serviceName;
            }
            // サービス内容/種類
            buildParam.getTargetPage()
                    .put(
                            "main.y" + buildParam.getCurrentRow() + ".x3",
                            serviceName);

            // サービス単位/金額
            printCell(buildParam, 9, "(" + totals[INDEX_OF_SERVICE_UNIT_FOR_DETAIL] + ")", isOver30Days);

            // 小計列
            buildUserSubTableTotalFields(buildParam, provider, insureRate,
                    totals, true, isOver30Days);

            totals[INDEX_OF_SERVICE_UNIT_FOR_DETAIL] = 0;
        }

        /**
         * 1つめのサービス情報を返します。
         * 
         * @return 1つめのサービス情報
         */
        public VRMap getFirstService() {
            if (!DivedServiceUnit.this.isEmpty()) {
                return (VRMap) DivedServiceUnit.this.get(0);
            }
            return null;
        }

        /**
         * サービスを解析します。
         * 
         * @param service サービス
         * @param code サービスコード
         */
        public void parse(VRMap service, Map code) {
            DivedServiceUnit.this.add(service);
            this.code = code;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Iterator it = DivedServiceUnit.this.iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                sb.append("│││││├サービス単位数：");
                sb.append(ent.getKey());
                sb.append(ACConstants.LINE_SEPARATOR);
                sb.append("││││││└サービス：");
                sb.append(ent.getValue());
            }
            return sb.toString();
        }

        /**
         * 利用票別表を構築します。
         * <p>
         * 明細列を構築します。
         * </p>
         * 
         * @param buildParam 印字内容集合
         * @param unit 単位
         * @param totals 集計情報
         * @param providerID 事業所ID
         * @throws Exception 処理例外
         */
        protected void buildUserSubTableDetailFields(CareServicePrintParameter buildParam,
                int unit, int[] totals, String providerID, boolean isOver30Days) throws Exception {

            if (code != null) {
                String serviceName = ACCastUtilities.toString(code.get("SERVICE_NAME")); 
                if(isOver30Days){
                    //30日超なら名称に30日超をつける
                    serviceName = "30日超" + serviceName;
                }
                // 2016/7/30 [CCCX:2865][Yoichiro Kamei] add - begin
                // 集計明細を別表のデータをもとに出力するためにサービス種類を追加
                // サービス種類
                String skind = ACTextUtilities.trim(ACCastUtilities.toString(code
                        .get("SYSTEM_SERVICE_KIND_DETAIL")));
                buildParam.getTargetPage().put(
                        "main.y" + buildParam.getCurrentRow() + ".skind",
                        skind);
                // 2016/7/30 [CCCX:2865] add - end
                
                // サービス内容/種類
                buildParam.getTargetPage().put(
                        "main.y" + buildParam.getCurrentRow() + ".x3",
                        serviceName);
                // サービスコード
                printCell(buildParam, 4, getCalcurater().getTextOfServiceCode(code), isOver30Days);
                // 単位
                printCell(buildParam, 5, ACCastUtilities.toString(unit), isOver30Days);

                int reducted = unit;
                int reductRate = getCalcurater()
                        .getReductRate(providerID, code);
                if (reductRate < 100){
                    //割引されている場合
                    if(!CareServiceCommon.isAddPercentage(code)) {
                        //%加算(特地加算)ではない場合
                        if(CareServiceCommon.isAddSpecialAreaOfWelfareEquipment(code)){
                            //福祉用具貸与の特地加算の場合は、割引後単位を単位数に記載
                            reducted = getCalcurater().toReductedUnit(unit, reductRate);
                            printCell(buildParam, 5, new Integer(reducted), isOver30Days);
                        }else{
                            // 割引率
                            printCell(buildParam, 6, new Integer(reductRate), isOver30Days);
                            reducted = getCalcurater().toReductedUnit(unit, reductRate);
                            //割引後単位数
                            printCell(buildParam, 7, new Integer(reducted), isOver30Days);
                        }
                    }
                }

                // 回数
                int count = DivedServiceUnit.this.size();
                // [ID:0000734][Masahiko.Higuchi] 2012/04 30日超処遇改善加算対応 del begin
                //if(CareServiceCommon.isCountPrintableServiceCode(code)){
                // [ID:0000734][Masahiko.Higuchi] 2012/04 30日超処遇改善加算対応 del end
                // [ID:0000734][Masahiko.Higuchi] 2012/04 30日超処遇改善加算対応 add begin
                // 30日超処遇改善加算を考慮してフラグがTRUEなら回数を印字する
                if(CareServiceCommon.isCountPrintableServiceCode(code) || isOver30Days){
                // [ID:0000734][Masahiko.Higuchi] 2012/04 30日超処遇改善加算対応 add end
                    buildParam.getTargetPage().put(
                        "main.y" + buildParam.getCurrentRow() + ".x8",
                        new Integer(count));
                }

                // サービス単位/金額
                int reducedCost = reducted * count;
                printCell(buildParam, 9, new Integer(reducedCost), isOver30Days);

                if(isOver30Days){
                    //30日超は保険給付単位数には合算せず全額自費として計上
                    totals[INDEX_OF_USER_COST_ON_30OVER] += reducedCost;
                }else{
                    totals[INDEX_OF_SERVICE_UNIT_FOR_DETAIL] += reducedCost;
                    totals[INDEX_OF_SERVICE_UNIT] += reducedCost;
                }
                
            }

        }
        /**
         * 30日超を考慮してセルの値を印字します。
         * @param buildParam 印字内容集合
         * @param x セルX位置
         * @param value 印字値
         * @param is30OverDays 30日超(印字対象外)であるか
         */
        protected void printCell(CareServicePrintParameter buildParam, int x, Object value, boolean is30OverDays){
            if(!is30OverDays){
                buildParam.getTargetPage().put(
                        "main.y" + buildParam.getCurrentRow() + ".x" + x,
                        value);
            }
        }

        /**
         * 利用票別表を構築します。
         * <p>
         * 事業所情報列を構築します。
         * </p>
         * 
         * @param buildParam 印字内容集合
         * @param provider 事業所
         * @return 事業所ID
         * @throws Exception 処理例外
         */
        protected String buildUserSubTableProviderFields(CareServicePrintParameter buildParam,
                Map provider) throws Exception {
            if (provider == null) {
                return "";
            }
            String providerID = ACCastUtilities.toString(provider
                    .get("PROVIDER_ID"));
            // 事業所名
            buildParam.getTargetPage().put(
                    "main.y" + buildParam.getCurrentRow() + ".x1",
                    provider.get("PROVIDER_NAME"));
            // 事業所番号
            buildParam.getTargetPage().put(
                    "main.y" + buildParam.getCurrentRow() + ".x2", providerID);
            return providerID;
        }

        /**
         * 利用票別表を構築します。
         * <p>
         * 小計列を構築します。
         * </p>
         * 
         * @param buildParam 印字内容集合
         * @param provider 事業所
         * @param insureRate 保険給付率
         * @param totals 集計情報
         * @param addHesesOnUnit 区分支給限度基準内単位数を括弧で括るか
         * @throws Exception 処理例外
         */
        protected void buildUserSubTableTotalFields(CareServicePrintParameter buildParam,
                Map provider, int insureRate, int[] totals,
                boolean addHesesOnUnit, boolean isOver30Days) throws Exception {

            if (code != null) {
                // 2016/7/30 [CCCX:2865][Yoichiro Kamei] add - begin
                // 集計明細を別表のデータをもとに出力するためにサービス種類を追加
                // サービス種類
                String skind = ACTextUtilities.trim(ACCastUtilities.toString(code
                        .get("SYSTEM_SERVICE_KIND_DETAIL")));
                buildParam.getTargetPage().put(
                        "main.y" + buildParam.getCurrentRow() + ".skind",
                        skind);
                // 2016/7/30 [CCCX:2865] add - end
                
                // 区分支給限度基準を超える単位数
                int overUnit = totals[INDEX_OF_LIMIT_OVER_UNIT_FOR_DETAIL];

                // [ID:0000764][Masahiko.Higuchi] add - begin 30日超サービスの印字障害
                if(isOver30Days) {
                    //30日超の場合は超過単位数を初期化する
                    overUnit = 0;
                }
                // [ID:0000764][Masahiko.Higuchi] add - end
                
                // 区分支給限度基準内単位数
                int totalUnit = totals[INDEX_OF_SERVICE_UNIT_FOR_DETAIL]
                        - overUnit;
                String totalUnitText = String.valueOf(totalUnit);
                if (addHesesOnUnit) {
                    totalUnitText = "(" + totalUnitText + ")";
                }
                printCell(buildParam, 13, totalUnitText, isOver30Days);

                totals[INDEX_OF_LIMIT_IN_UNIT] += totalUnit;

                // 単位数単価
                Object serviceKind = code.get("SYSTEM_SERVICE_KIND_DETAIL");
                double unitPrice = getCalcurater().getUnitPrice(serviceKind,
                        provider);
                buildParam.getTargetPage().put(
                        "main.y" + buildParam.getCurrentRow() + ".x14",
                        getCalcurater().getTextOfUnitPrice(unitPrice));

                // 2008/09/03 [Masahiko Higuchi] add - begin 全額自己負担計算式障害（V5.4.3）
                // 何か丸め計算がおかしいので請求と同様の計算式に変更する
                BigDecimal bigDeci = new BigDecimal(String.valueOf(unitPrice));
                bigDeci = bigDeci.multiply(new BigDecimal("100"));
                // 2008/09/03 [Masahiko Higuchi] add - end
                
                // 費用総額
                // 切捨て
                // [ID:0000441][Masahiko Higuchi] del begin 費用総額の丸め計算障害対応
                //int cost = (int) Math.floor(unitPrice * totalUnit);
                // [ID:0000441][Masahiko Higuchi] del end
                // [ID:0000441][Masahiko Higuchi] add begin 費用総額の丸め計算障害対応
                int cost = (int) Math.floor((double) ((totalUnit * bigDeci
                        .intValue()) / 100d));
                // [ID:0000441][Masahiko Higuchi] add end
                printCell(buildParam, 15, new Integer(cost), isOver30Days);
                totals[INDEX_OF_TOTAL_COST] += cost;

                // 給付率
                insureRate = getCalcurater().checkPublicExpense(insureRate,
                        serviceKind, provider);
                printCell(buildParam, 16, new Integer(insureRate), isOver30Days);

                // 保険給付額(切捨て)
                int insureCost = (int) Math.floor(cost * insureRate / 100.0);
                printCell(buildParam, 17, new Integer(insureCost), isOver30Days);
                totals[INDEX_OF_INSURE_COST] += insureCost;

                // 利用者負担（保険対象分）
                int userCost = cost - insureCost;
                printCell(buildParam, 18, new Integer(userCost), isOver30Days);
                totals[INDEX_OF_USER_COST_ON_INSURE] += userCost;

                // [ID:0000441][Masahiko Higuchi] del begin 費用総額の丸め計算障害対応
                // 2008/09/03 [Masahiko Higuchi] add - begin 全額自己負担計算式障害（V5.4.3）
                // 何か丸め計算がおかしいので請求と同様の計算式に変更する
                // BigDecimal bigDeci = new BigDecimal(String.valueOf(unitPrice));
                // bigDeci = bigDeci.multiply(new BigDecimal("100"));
                // 2008/09/03 [Masahiko Higuchi] add - end
                // [ID:0000441][Masahiko Higuchi] del end
                
                int overCost = 0;
                // [ID:0000764][Masahiko.Higuchi] del - begin　30日超サービスの印字障害
                // [ID:0000734][Masahiko.Higuchi] 2012/04 30日超処遇改善加算対応 add begin
                //if(isOver30Days) {
                //    //30日超の場合は超過単位数を初期化する
                //    overUnit = 0;
                //}
                // [ID:0000734][Masahiko.Higuchi] 2012/04 30日超処遇改善加算対応 add end
                // [ID:0000764][Masahiko.Higuchi] del - end
                if (overUnit > 0) {

                    // 区分支給限度基準を超える単位数が設定されているとき
                    printCell(buildParam, 12, new Integer(overUnit), isOver30Days);

                    // 2008/09/03 [Masahiko Higuchi] del - begin 全額自己負担計算式障害（V5.4.3）
                    // サービス計画費用総額=計画単位数*単位数単価
                    //int planCost = (int) Math.floor((overUnit + totalUnit)
                    //* unitPrice);
                    // 利用者負担（全額負担分）=サービス計画費用総額-費用総額（保険対象分）
                    //overCost += planCost - cost;
                    // 2008/09/03 [Masahiko Higuchi] del - end
                    // 2008/09/03 [Masahiko Higuchi] add - begin 全額自己負担計算式障害（V5.4.3）
                    // 30日超でない場合のみ通るかつ30日超の値が合算されることはない。
                    overCost = (int) Math.floor((double) ((overUnit * bigDeci
                            .intValue()) / 100d));
                    // 2008/09/03 [Masahiko Higuchi] add - end
                    // 小計分をクリア
                    totals[INDEX_OF_LIMIT_OVER_UNIT_FOR_DETAIL] = 0;
                }
                // 2008/09/03 [Masahiko Higuchi] del - begin 全額自己負担計算式障害（V5.4.3）
                //overCost += (int) Math.floor(totals[INDEX_OF_USER_COST_ON_30OVER]*unitPrice);
                // 2008/09/03 [Masahiko Higuchi] del - end
                // 2008/09/03 [Masahiko Higuchi] add - begin 全額自己負担計算式障害（V5.4.3）
                // 丸め計算の問題に対応
                overCost += (int) Math
                        .floor((double) ((totals[INDEX_OF_USER_COST_ON_30OVER] * bigDeci
                                .intValue()) / 100d));
                // 念のため明示的に開放する
                bigDeci = null;
                // 2008/09/03 [Masahiko Higuchi] add - end
                if(overCost>0){
                    //// 利用者負担（全額負担分）
                    buildParam.getTargetPage().put(
                        "main.y" + buildParam.getCurrentRow() + ".x19",
                        new Integer(overCost));
                    totals[INDEX_OF_USER_COST_ON_FULL] += overCost;
                    totals[INDEX_OF_USER_COST_ON_30OVER] = 0;
                }
            }

        }

    }
    
    // [2014年要望][Shinobu Hitaka] 2014/10/23 add begin 敬称表示
    /**
     * 被保険者名の敬称を設定します。
     * 
     * @param printKeisyo 敬称（様、殿　など）
     */
    public void setPrintKeisyo(String printKeisyo) {
        this.printKeisyo = printKeisyo;
    }
    // [2014年要望][Shinobu Hitaka] 2014/10/23 add end 敬称表示

}
