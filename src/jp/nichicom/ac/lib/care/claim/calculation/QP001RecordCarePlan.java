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
 * 開発者: 藤原　伸
 * 作成日: 2006/01/24  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス 請求処理 (001)
 * プログラム 様式第七レコード (QP001RecordCarePlan)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;

/**
 * 様式第七用レコード
 * 介護給付費請求明細書（居宅サービス計画費）情報
 */
public class QP001RecordCarePlan extends QP001RecordAbstract {
    // 交換情報識別番号4桁
    private String _1001001 = "";
    // 事業所番号10桁
    private String _1001002 = "";
    // 指定/基準該当等事業所区分コード1桁
    // 1-指定事業所 2-基準該当事業所 3-相当サービス事業所 4-その他"
    private int _1001003 = 0;
    // サービス提供年月6桁(YYYYMM)
    private String _1001004 = "";
    // 証記載保険者番号8桁
    private String _1001005 = "";
    // 単位数単価4桁
    private double _1001006 = 0;
    // 被保険者番号10桁
    private String _1001007 = "";
    // 公費負担者番号8桁
    private String _1001008 = "";
    // 公費受給者番号7桁
    private String _1001009 = "";
    // 被保険者生年月日8桁(YYYYMMDD)
    private String _1001010 = "";
    // 性別コード1桁 1-男 2-女
    private String _1001011 = "";
    // 要介護状態区分コード2桁
    // 01-非該当 11-要支援 21-要介護1 22-要介護2 23-要介護3 24-要介護4 25-要介護5"
    private String _1001012 = "";
    // 認定有効期間(開始)8桁(YYYYMMDD)
    private String _1001013 = "";
    // 認定有効期間(終了)8桁(YYYYMMDD)
    private String _1001014 = "";
    // 居宅サービス計画作成依頼届出年月日8桁(YYYYMMDD)
    private String _1001015 = "";
    // サービスコード6桁
    private String _1001016 = "";
    // 単位数6桁
    private int _1001017 = 0;
    // 請求金額6桁
    private int _1001018 = 0;
    //公費種類(KOHI_TYPE)
    private String _1001019 = "";
    //システムサービス種類コード
    private String _1001020 = "";
    //システムサービス項目コード
    private String _1001021 = "";
    //担当介護支援専門員番号(交換情報識別番号が8122の場合、必須)
    private String _1001022 = "";
    //摘要
    private String _1001023 = "";
    
    //ID:0000447][Shin Fujihara] 2009/02 add begin 平成21年4月法改正対応
    //サービス計画費明細行番号
    private int _1001024 = 0;
    //単位数
    private int _1001025 = 0;
    //回数
    private int _1001026 = 0;
    //サービス単位数合計
    private int _1001027 = 0;
    //サービス名称
    private String _1001028 = "";
    //ID:0000447][Shin Fujihara] 2009/02 add end 平成21年4月法改正対応
    
    //サービス提供日　※月の始めにおかれたサービスの介護支援専門員番号を採用するため、退避
    private Date serviceDate = null;
    

    /**
     * 交換情報識別番号4桁を取得します。
     * 
     * @return
     */
    protected String get_1001001() {
        return _1001001;
    }
    /**
     * 交換情報識別番号4桁を設定します。
     * @param _1001001
     */
    protected void set_1001001(String _1001001) {
        this._1001001 = _1001001;
    }

    /**
     * 事業所番号10桁を取得します。
     * 
     * @return
     */
    protected String get_1001002() {
        return _1001002;
    }

    /**
     * 事業所番号10桁を設定します。
     * 
     * @param _1001002
     */
    protected void set_1001002(String _1001002) {
        this._1001002 = _1001002;
    }

    /**
     * 指定/基準該当等事業所区分コード1桁 1-指定事業所 2-基準該当事業所 3-相当サービス事業所 4-その他 を取得します。
     * 
     * @return
     */
    protected int get_1001003() {
        return _1001003;
    }

    /**
     * 指定/基準該当等事業所区分コード1桁 1-指定事業所 2-基準該当事業所 3-相当サービス事業所 4-その他 を設定します。
     * 
     * @param _1001003
     */
    protected void set_1001003(int _1001003) {
        this._1001003 = _1001003;
    }

    /**
     * サービス提供年月6桁(YYYYMM)を取得します。
     * 
     * @return
     */
    protected String get_1001004() {
        return _1001004;
    }

    /**
     * サービス提供年月6桁(YYYYMM)を設定します。
     * 
     * @param _1001004
     */
    protected void set_1001004(String _1001004) {
        this._1001004 = _1001004;
    }

    /**
     * 証記載保険者番号8桁を取得します。
     * 
     * @return
     */
    protected String get_1001005() {
        return _1001005;
    }

    /**
     * 証記載保険者番号8桁を設定します。
     * 
     * @param _1001005
     */
    protected void set_1001005(String _1001005) {
        this._1001005 = _1001005;
    }

    /**
     * 単位数単価4桁を取得します。
     * 
     * @return
     */
    protected double get_1001006() {
        return _1001006;
    }

    /**
     * 単位数単価4桁を設定します。
     * 
     * @param _1001006
     */
    protected void set_1001006(double _1001006) {
        this._1001006 = _1001006;
    }

    /**
     * 被保険者番号10桁を取得します。
     * 
     * @return
     */
    protected String get_1001007() {
        return _1001007;
    }

    /**
     * 被保険者番号10桁を設定します。
     * 
     * @param _1001007
     */
    protected void set_1001007(String _1001007) {
        this._1001007 = _1001007;
    }

    /**
     * 公費負担者番号8桁を取得します。
     * 
     * @return
     */
    protected String get_1001008() {
        return _1001008;
    }

    /**
     * 公費負担者番号8桁を設定します。
     * 
     * @param _1001008
     */
    protected void set_1001008(String _1001008) {
        this._1001008 = _1001008;
    }

    /**
     * 公費受給者番号7桁を取得します。
     * 
     * @return
     */
    protected String get_1001009() {
        return _1001009;
    }

    /**
     * 公費受給者番号7桁を設定します。
     * 
     * @param _1001009
     */
    protected void set_1001009(String _1001009) {
        this._1001009 = _1001009;
    }

    /**
     * 被保険者生年月日8桁(YYYYMMDD)を取得します。
     * 
     * @return
     */
    protected String get_1001010() {
        return _1001010;
    }

    /**
     * 被保険者生年月日8桁(YYYYMMDD)を設定します。
     * 
     * @param _1001010
     */
    protected void set_1001010(String _1001010) {
        this._1001010 = _1001010;
    }

    /**
     * 性別コード1桁1-男 2-女を取得します。
     * 
     * @return
     */
    protected String get_1001011() {
        return _1001011;
    }

    /**
     * 性別コード1桁1-男 2-女を設定します。
     * 
     * @param _1001011
     */
    protected void set_1001011(String _1001011) {
        this._1001011 = _1001011;
    }

    /**
     * 要介護状態区分コード2桁 01-非該当 11-要支援 21-要介護1 22-要介護2 23-要介護3 24-要介護4 25-要介護5
     * を取得します。
     * 
     * @return
     */
    protected String get_1001012() {
        return _1001012;
    }

    /**
     * 要介護状態区分コード2桁 01-非該当 11-要支援 21-要介護1 22-要介護2 23-要介護3 24-要介護4 25-要介護5
     * を設定します。
     * 
     * @param _1001012
     */
    protected void set_1001012(String _1001012) {
        this._1001012 = _1001012;
    }

    /**
     * 認定有効期間(開始)8桁(YYYYMMDD)を取得します。
     * 
     * @return
     */
    protected String get_1001013() {
        return _1001013;
    }

    /**
     * 認定有効期間(開始)8桁(YYYYMMDD)を設定します。
     * 
     * @param _1001013
     */
    protected void set_1001013(String _1001013) {
        this._1001013 = _1001013;
    }

    /**
     * 認定有効期間(終了)8桁(YYYYMMDD)を取得します。
     * 
     * @return
     */
    protected String get_1001014() {
        return _1001014;
    }

    /**
     * 認定有効期間(終了)8桁(YYYYMMDD)を設定します。
     * 
     * @param _1001014
     */
    protected void set_1001014(String _1001014) {
        this._1001014 = _1001014;
    }

    /**
     * 居宅サービス計画作成依頼届出年月日8桁(YYYYMMDD)を取得します。
     * 
     * @return
     */
    protected String get_1001015() {
        return _1001015;
    }

    /**
     * 居宅サービス計画作成依頼届出年月日8桁(YYYYMMDD)を設定します。
     * 
     * @param _1001015
     */
    protected void set_1001015(String _1001015) {
        this._1001015 = _1001015;
    }

    /**
     * サービスコード6桁を取得します。
     * 
     * @return
     */
    protected String get_1001016() {
        return _1001016;
    }

    /**
     * サービスコード6桁を設定します。
     * 
     * @param _1001016
     */
    protected void set_1001016(String _1001016) {
        this._1001016 = _1001016;
    }

    /**
     * 単位数6桁を取得します。
     * 
     * @return
     */
    protected int get_1001017() {
        return _1001017;
    }

    /**
     * 単位数6桁を設定します。
     * 
     * @param _1001017
     */
    protected void set_1001017(int _1001017) {
        this._1001017 = _1001017;
    }

    /**
     * 請求金額6桁を取得します。
     * 
     * @return
     */
    protected int get_1001018() {
        return _1001018;
    }

    /**
     * 請求金額6桁を設定します。
     * 
     * @param _1001018
     */
    protected void set_1001018(int _1001018) {
        this._1001018 = _1001018;
    }
    
    /**
     * 公費種類(KOHI_TYPE)を取得します。
     * @return
     */
    protected String get_1001019(){
        return _1001019;
    }
    
    /**
     * 公費種類(KOHI_TYPE)を設定します。
     * @param _1001019
     */
    protected void set_1001019(String _1001019){
        this._1001019 = _1001019;
    }

    /**
     * システムサービス種類コードを取得します。
     * @return
     */
    protected String get_1001020(){
        return _1001020;
    }
    
    /**
     * システムサービス種類コードを設定します。
     * @param _1001020
     */
    protected void set_1001020(String _1001020){
        this._1001020 = _1001020;
    }
    
    /**
     * システムサービス項目コードを取得します。
     * @return
     */
    protected String get_1001021(){
        return _1001021;
    }
    
    /**
     * システムサービス項目コードを設定します。
     * @param _1001021
     */
    protected void set_1001021(String _1001021){
        this._1001021 = _1001021;
    }
    
    /**
     * 担当介護支援専門員番号(交換情報識別番号が8122の場合、必須)を取得します。
     * @return
     */
    protected String get_1001022() {
        return _1001022;
    }
    
    /**
     * 担当介護支援専門員番号(交換情報識別番号が8122の場合、必須)を設定します。
     * @param _1001022
     */
    protected void set_1001022(String _1001022){
        this._1001022 = _1001022;
    }
    
    /**
     * 摘要を取得します。
     * @return
     */
    protected String get_1001023() {
        return _1001023;
    }
    
    /**
     * 摘要を設定します。
     * @param _1001023
     */
    protected void set_1001023(String _1001023){
        this._1001023 = _1001023;
    }
    
    //ID:0000447][Shin Fujihara] 2009/02 add begin 平成21年4月法改正対応
    /**
     * サービス計画費明細行番号を取得します。
     * @return
     */
    protected int get_1001024() {
        return _1001024;
    }
    /**
     * サービス計画費明細行番号を設定します。
     * @param _1001024
     */
    protected void set_1001024(int _1001024){
    	this._1001024 = _1001024;
    }
    /**
     * 単位数を取得します。
     * @return
     */
    protected int get_1001025() {
        return _1001025;
    }
    
    /**
     * 単位数を設定します。
     * @param _1001025
     */
    protected void set_1001025(int _1001025){
    	this._1001025 = _1001025;
    }
    
    /**
     * 回数を取得します。
     * @return
     */
    protected int get_1001026() {
        return _1001026;
    }
    
    /**
     * 回数を設定します。
     * @param _1001026
     */
    protected void set_1001026(int _1001026){
    	this._1001026 = _1001026;
    }
    
    /**
     * サービス単位数合計を取得します。
     * @return
     */
    protected int get_1001027() {
        return _1001027;
    }
    
    /**
     * サービス単位数合計を設定します。
     * @param _1001027
     */
    protected void set_1001027(int _1001027){
    	this._1001027 = _1001027;
    }
    /**
     * サービス名称を取得します。
     * @return
     */
    protected String get_1001028() {
        return _1001028;
    }
    
    /**
     * サービス名称を設定します。
     * @param _1001028
     */
    protected void set_1001028(String _1001028){
    	this._1001028 = _1001028;
    }
    //ID:0000447][Shin Fujihara] 2009/02 add add 平成21年4月法改正対応
    
    /**
     * サービス提供日を取得します。
     * @return
     */
    protected Date getServiceDate() {
        return serviceDate;
    }
    /**
     * サービス提供日を設定します。
     * @param serviceDate
     */
    protected void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    protected String getSerialId() {
        StringBuilder result = new StringBuilder();

        // 交換情報識別番号4桁
        result.append(get_1001001());
        // 事業所番号10桁
        result.append(get_1001002());
        // サービス提供年月6桁(YYYYMM)
        result.append(get_1001004());
        // 証記載保険者番号8桁
        result.append(get_1001005());

        return result.toString();
    }
    
    //[ID:0000447][Shin Fujihara] 2009/02 edit begin 平成21年4月法改正対応
/*    protected static QP001RecordCarePlan getInstance(String identificationNo,
                                                        VRMap serviceDetail,
                                                        QP001PatientState patientState) throws Exception {*/
    protected static QP001RecordCarePlan getInstance(String identificationNo,
            VRMap serviceDetail,
            Date targetDate,
            QP001PatientState patientState,
            VRMap serviceCode,
            Map carePlanMap) throws Exception {
    //[ID:0000447][Shin Fujihara] 2009/02 edit end 平成21年4月法改正対応
    	
        QP001RecordCarePlan care = null;
        
        //レコードの作成可否を判断
        if(!isMakeRecord(serviceDetail,VRBindPathParser.get("SERVICE_DATE",serviceDetail),patientState)){
            return care;
        }
        
        //[ID:0000447][Shin Fujihara] 2009/02 edit begin 平成21年4月法改正対応
        //H21.4～の様式である場合
        String serial = "20090331-before";
        if ("8124,8125".indexOf(identificationNo) != -1){
        	serial = getSerialId(identificationNo, targetDate, patientState,serviceCode);
        }
        
    	if (carePlanMap.containsKey(serial)){
    		care = (QP001RecordCarePlan)carePlanMap.get(serial);
    	} else {
    		care = new QP001RecordCarePlan();
    		carePlanMap.put(serial, care);
    	}
        //[ID:0000447][Shin Fujihara] 2009/02 edit end 平成21年4月法改正対応
        
        return care;
    }
    
    private static boolean isMakeRecord(VRMap serviceDetail,Object targetServiceDate,QP001PatientState patientState) throws Exception {
        
        // 居宅サービス計画作成者の区分を取得する。
        // 被保険者が作成していれば処理を行わない。
        if ("2".equals(patientState.getNinteiData(targetServiceDate, "PLANNER"))){
            return false;
        }
        
        //ログイン事業所と認定事業所が異なっている場合、処理を中断する。
        if(!QkanSystemInformation.getInstance().getLoginProviderID().equals(patientState.getNinteiData(targetServiceDate, "PROVIDER_ID"))){
            return false;
        }
        
        //ログイン事業所と作成事業所が異なっている場合、処理を中断する。
        if(!QkanSystemInformation.getInstance().getLoginProviderID().equals(String.valueOf(serviceDetail.get("PROVIDER_ID")))){
            return false;
        }
        
        return true;
    }

    //[ID:0000447][Shin Fujihara] 2009/02 edit begin 平成21年4月法改正対応
    protected static String getSerialId(String identificationNo,
            Date targetServiceDate, QP001PatientState patientState,
            VRMap serviceCode)
            throws Exception {
    //[ID:0000447][Shin Fujihara] 2009/02 edit end 平成21年4月法改正対応

        StringBuilder serial = new StringBuilder();
        // 交換識別番号
        serial.append(identificationNo);
        // 事業所番号10桁
        serial.append(patientState.getNinteiData(targetServiceDate,
                "PROVIDER_ID"));
        // サービス提供年月日
        serial.append(VRDateParser.format(targetServiceDate, "yyyyMM"));
        // 証記載保険者番号8桁
        serial.append(patientState.getInsurerId(targetServiceDate));
        
        //[ID:0000447][Shin Fujihara] 2009/02 add begin 平成21年4月法改正対応
        // サービス種類コード
        serial.append(VRBindPathParser.get("SERVICE_CODE_KIND", serviceCode));
        // サービス項目コード
        serial.append(VRBindPathParser.get("SERVICE_CODE_ITEM", serviceCode));
        //[ID:0000447][Shin Fujihara] 2009/02 add end 平成21年4月法改正対応
        
        return serial.toString();
    }

    protected boolean isNew() {
        return ACTextUtilities.isNullText(get_1001002());
    }

    /**
     * データの解析を行う。
     * 
     * @param targetServiceDate
     * @param patientState
     * @throws Exception
     */
    protected void parse(VRMap serviceDetail, QP001PatientState patientState,
            VRMap serviceCode,String identificationNo,QP001Manager manager) throws Exception {
        
        // サービス提供日
        Date targetServiceDate = ACCastUtilities.toDate(VRBindPathParser.get(
                "SERVICE_DATE", serviceDetail));
        // サービス提供月(yyyyMM型式)
        String targetMonth = VRDateParser.format(targetServiceDate, "yyyyMM");
        
        // 居宅サービス計画作成者の区分を取得する。
        // 被保険者が作成していれば処理を行わない。
        if ("2".equals(patientState.getNinteiData(targetServiceDate, "PLANNER"))){
            return;
        }
        
        /*
         * [ID:0000702][Shin Fujihara] 2012/04 edit 平成21年4月法改正対応
         *  加算のみ算定追加に伴い、大幅に修正
         */
        
        // データの解析が初回の場合
        if (isNew()){
            //交換情報識別番号4桁を設定します。
            set_1001001(identificationNo);
            
            // plan の KEY : 1001002(事業所番号) に VALUE : 10桁フォーマットした事業所番号を設定する。
            set_1001002(patientState
                    .getNinteiData(targetServiceDate, "PROVIDER_ID"));

            // plan の KEY : 1001003(指定/基準該当等事業所区分コード1桁) に VALUE : 該当事業所の事業区分を設定する。
            set_1001003(manager.getProviderJigyouType(get_1001002()));

            // plan の KEY : 1001004(サービス提供年月)に VALUE :
            // yyyyMM形式にフォーマットしたtargetDateを設定する。
            set_1001004(VRDateParser.format(ACCastUtilities
                    .toDate(targetServiceDate), "yyyyMM"));

            // plan の KEY : 1001005(証記載保険者番号)に VALUE :
            // 8桁フォーマットした利用者の保険者番号(patientより取得)を設定する。
            set_1001005(patientState.getInsurerId(targetServiceDate));

            // plan の KEY : 1001006(単位数単価)に VALUE : 地域単価(共通関数より取得)を設定する。
            set_1001006(manager.getAreaUnitPrice(
                    get_1001002(),
                    ACCastUtilities.toString(VRBindPathParser.get(
                            "SYSTEM_SERVICE_KIND_DETAIL", serviceCode)),
                    targetMonth));

            // plan の KEY : 1001007(被保険者番号)に VALUE :
            // 10桁フォーマットした利用者の被保険者番号(patientより取得)を設定する。
            set_1001007(patientState.getInsuredId(targetServiceDate));
            
            //利用者が生保単独の場合、公費の設定を行う。
            if(patientState.isSeihoOnly(targetServiceDate)){
                VRList list = patientState.getKohiDataFromServiceKind(
                        targetServiceDate,
                        String.valueOf(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL")),
                        "1",
                        1,
                        manager.getProviderMedicalFlag(get_1001002()),
                        manager);
                
                if((list != null) && (list.size() != 0)){
                    VRMap kohi = (VRMap)list.get(0);
                    set_1001019(String.valueOf(kohi.get("KOHI_TYPE")));
// 2015/5/12 [Yoichiro Kamei] mod - begin 公費関連見直し
//                    set_1001008(patientState.getKohiData(get_1001019(),"KOHI_PAYER_NO",1));
//                    set_1001009(patientState.getKohiData(get_1001019(),"KOHI_RECIPIENT_NO",1));
                    QP001KohiKey kohiKey = new QP001KohiKey(kohi);
                    set_1001008(patientState.getKohiData(kohiKey,"KOHI_PAYER_NO",1));
                    set_1001009(patientState.getKohiData(kohiKey,"KOHI_RECIPIENT_NO",1));
// 2015/5/12 [Yoichiro Kamei] mod - end
                }
            }

            // plan の KEY : 1001010(被保険者生年月日)に VALUE :
            // yyyyMMdd形式にフォーマットした被保険者の生年月日(patientより取得)を設定する。
            set_1001010(patientState.getPatientData("PATIENT_BIRTHDAY").replaceAll(
                    "-", ""));

            // plan の KEY : 1001011(性別コード)に VALUE : 被保険者の性別(patinetより取得)を設定する。
            set_1001011(patientState.getPatientData("PATIENT_SEX"));

            // plan の KEY : 1001012(要介護状態区分コード)に VALUE :
            // 被保険者の要介護区分コード(patientより取得)を設定する。
            set_1001012(patientState.getNinteiDataLast(get_1001005(), get_1001007(),
                    "JOTAI_CODE"));

            // plan の KEY : 1001013(認定有効期間(開始))に VALUE :
            // yyyyMMdd形式にフォーマットした認定期間の開始日(patientより取得)を設定する。
            set_1001013(patientState.getNinteiDataLast(get_1001005(), get_1001007(),
                    "INSURE_VALID_START").replaceAll("-", ""));

            // plan の KEY : 1001014(認定有効期間(終了))に VALUE :
            // yyyyMMdd形式にフォーマットした認定期間の終了日(patientより取得)を設定する。
            set_1001014(patientState.getNinteiDataLast(get_1001005(), get_1001007(),
                    "INSURE_VALID_END").replaceAll("-", ""));

            // plan の KEY : 1001015(居宅サービス計画作成依頼届出年月日)に VALUE : yyyyMMdd
            // 形式にフォーマットした認定期間の提出日(patient)を設定する。
            //※生保単独の場合は、設定しなくてよい
            if(!QP001SpecialCase.isSeihoOnly(get_1001007())){
                set_1001015(patientState.getNinteiDataLast(get_1001005(), get_1001007(),
                "REPORTED_DATE").replaceAll("-", ""));
            }


            // plan の KEY : 1001016(サービスコード)に VALUE : サービスコード(serviceCode
            // より取得)を設定する。
            set_1001016(ACCastUtilities.toString(ACCastUtilities
                    .toString(VRBindPathParser
                            .get("SERVICE_CODE_KIND", serviceCode))
                    + ACCastUtilities.toString(VRBindPathParser.get(
                            "SERVICE_CODE_ITEM", serviceCode))));

            // plan の KEY : 1001017(単位数)に VALUE : 単位数単価(serviceCode より取得)を設定する。
            set_1001017(manager.getServiceUnit(get_1001002(),
                    serviceCode));

            // plan の KEY : 1001018(請求金額)に VALUE : 地域単価*単位数単価を設定する。
            BigDecimal temp = new BigDecimal(String.valueOf(get_1001006()));
            temp = temp.multiply(new BigDecimal("100"));
            //set_1001018((int) Math.floor((double)get_1001017() * get_1001006()));
            set_1001018((int)Math.floor((double)(get_1001017() * temp.intValue()) / 100d));

            //システムサービス種類コード
            set_1001020(String.valueOf(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL")));
            //システムサービス項目コード
            set_1001021(String.valueOf(serviceCode.get("SYSTEM_SERVICE_CODE_ITEM")));
            //担当介護支援専門員番号(交換情報識別番号が8122の場合、必須)
            if(!ACTextUtilities.isNullText(serviceDetail.get("1430107"))){
                set_1001022(String.valueOf(serviceDetail.get("1430107")));
            }
            
            //摘要
            set_1001023("");
            
            //サービスの提供日を設定する。
            setServiceDate(ACCastUtilities.toDate(serviceDetail.get("SERVICE_DATE"),null));
            
            //単位数
            set_1001025(manager.getServiceUnit(get_1001002(),serviceCode));
            //回数
            set_1001026(1);
            //サービス名称を設定する
            set_1001028(ACCastUtilities.toString(VRBindPathParser.get("SERVICE_NAME", serviceCode)));
            
        } else {
            
            //交換識別番号が様式第七で、かつ加算のみ算定の場合は、回数を増やす
            if (QP001StyleAbstract.IDENTIFICATION_NO_7_201204.equals(identificationNo)
                && (ACCastUtilities.toInt(VRBindPathParser.get("9", serviceDetail), 0) == 2)) {
                //回数
                set_1001026(get_1001026() + 1);
            }
        }

    }
    
    protected void commitRecord() throws Exception {
        //単位数合計 = 単位数 * 回数
        set_1001017(get_1001025() * get_1001026());
    }

    /**
     * データ作成
     * 
     * @param style
     * @return
     */
    protected VRMap getRecord(VRMap style) throws Exception {
        VRMap result = copyStyle(style);

        // 交換情報識別番号4桁(8121固定)
        setData(result, "1001001", get_1001001());
        // 事業所番号10桁
        setData(result, "1001002", get_1001002());
        // 指定/基準該当等事業所区分コード1桁
        setData(result, "1001003", get_1001003());
        // サービス提供年月6桁(YYYYMM)
        setData(result, "1001004", get_1001004());
        // 証記載保険者番号8桁
        setData(result, "1001005", get_1001005());
        // 単位数単価4桁
        setData(result, "1001006", get_1001006());
        // 被保険者番号10桁
        setData(result, "1001007", get_1001007());
        // 公費負担者番号8桁
        setData(result, "1001008", get_1001008());
        // 公費受給者番号7桁
        setData(result, "1001009", get_1001009());

        // 被保険者生年月日8桁(YYYYMMDD)
        setData(result, "1001010", get_1001010());
        // 性別コード1桁1-男 2-女
        setData(result, "1001011", get_1001011());
        // 要介護状態区分コード2桁
        setData(result, "1001012", get_1001012());
        // 認定有効期間(開始)8桁(YYYYMMDD)
        setData(result, "1001013", get_1001013());
        // 認定有効期間(終了)8桁(YYYYMMDD)
        setData(result, "1001014", get_1001014());
        // 居宅サービス計画作成依頼届出年月日8桁(YYYYMMDD)
        setData(result, "1001015", get_1001015());
        // サービスコード6桁
        setData(result, "1001016", get_1001016());
        // 単位数6桁
        setData(result, "1001017", get_1001017());
        // 請求金額6桁
        setData(result, "1001018", get_1001018());
        //公費種類(KOHI_TYPE)
        setData(result, "1001019", get_1001019());
        //システムサービス種類コード
        setData(result, "1001020", get_1001020());
        //システムサービス項目コード
        setData(result, "1001021", get_1001021());
        //担当介護支援専門員番号(交換情報識別番号が8122の場合、必須)
        setData(result, "1001022", get_1001022());
        //摘要
        setData(result, "1001023", get_1001023());
        
		setData(result, "1001024", get_1001024());
		setData(result, "1001025", get_1001025());
		setData(result, "1001026", get_1001026());
		setData(result, "1001027", get_1001027());
		setData(result, "1001028", get_1001028());
		
		return result;
    }

    private VRMap copyStyle(VRMap style) throws Exception {
        VRMap result = new VRHashMap();
        Object key;
        // ディープコピー
        Iterator it = style.keySet().iterator();
        while (it.hasNext()) {
            key = it.next();
            result.put(key, style.get(key));
        }
        // 介護給付費請求明細書(居宅サービス計画費)情報
        //result.put("CATEGORY_NO", "10");
        result.put("CATEGORY_NO", QkanConstants.CATEGORY_NO_DETAILED_BENEFIT);
        // 利用者番号(被保険者番号)
        result.put("INSURED_ID", get_1001007());
        // 請求の対象となる年月(サービス提供年月)
        result.put("TARGET_DATE", ACCastUtilities.toDate(get_1001004() + "01"));
        // 保険者番号
        result.put("INSURER_ID", get_1001005());
        // 請求元事業所
        result.put("PROVIDER_ID", get_1001002());

        return result;
    }
}