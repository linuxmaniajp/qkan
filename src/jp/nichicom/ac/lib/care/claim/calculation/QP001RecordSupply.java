
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
 * プログラム 給付管理票レコード (QP001RecordSupply)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

public class QP001RecordSupply extends QP001RecordAbstract {
    
    // 交換情報識別番号4桁(平成18年4月以前8221固定　平成18年4月以降8222固定)
    private String _1201001 = "";
    // 対象年月6桁(YYYYMM)
    private String _1201002 = "";
    // 証記載保険者番号8桁
    private String _1201003 = "";
    //事業所番号10桁(居宅介護支援事業所、もしくは介護予防支援事業所)
    private String _1201004 = "";
    // 給付管理票情報作成区分コード1桁　1-新規 2-修正 3-取消
    private int _1201005 = 0;
    // 給付管理票作成年月日8桁(YYYYMMDD)
    private String _1201006 = "";
    // 給付管理票種別区分コード1桁　1-訪問通所サービス給付管理票 2-短期入所サービス給付管理票 3-居宅サービス区分給付管理票
    private int _1201007 = 0;
    // 給付管理票明細行番号2桁
    private int _1201008 = 0;
    // 被保険者番号10桁
    private String _1201009 = "";
    // 被保険者生年月日8桁(YYYYMMDD)
    private String _1201010 = "";
    // 性別コード1桁　1-男 2-女
    private String _1201011 = "";
    // 要介護状態区分コード2桁　01-非該当 11-要支援(経過的要介護) 12-要支援1 13-要支援2 21-要介護1 22-要介護2 23-要介護3 24-要介護4 25-要介護5
    private String _1201012 = "";
    // 限度額適用期間(開始)6桁(YYYYMM)
    private String _1201013 = "";
    // 限度額適用期間(終了)6桁(YYYYMM)
    private String _1201014 = "";
    // 居宅・介護予防支給限度額6桁
    private String _1201015 = "";
    // 居宅サービス計画作成区分コード1桁　1-居宅介護支援事業所作成　2-自己作成　3-介護予防支援事業所作成
    private int _1201016 = 0;
    // 事業所番号(サービス事業所)10桁
    private String _1201017 = "";
    // 指定/基準該当等事業所区分コード1桁　1-指定事業所 2-基準該当事業所 3-相当サービス事業所 4-その他 5-地域密着型サービス
    private int _1201018 = 0;
    // サービス種類コード2桁
    private String _1201019 = "";
    // 給付計画単位数/日数6桁
    private int _1201020 = 0;
    // 限度額管理期間における前月までの給付計画日数3桁
    private String _1201021 = "";
    // 指定サービス分小計6桁
    private String _1201022 = "";
    // 基準該当サービス分小計6桁
    private String _1201023 = "";
    // 給付計画合計単位数/日数6桁
    private int _1201024 = 0;
    // 担当介護支援専門員番号
    private String _1201025 = "";
    // 委託先の居宅介護支援事業所番号
    private String _1201026 = "";
    // 委託先の担当介護支援専門員番号
    private String _1201027 = "";
    // 保険者名
    private String _1201028 = "";
    // サービス種類名
    private String _1201029 = "";
    
    // 集計タイプ
    //private int totalGroupintType = 0;
    private VRMap totalGroupintType = new VRHashMap();
    // 集計完了フラグ
    private boolean commited = false;
    
    //自費調整額
    private int individualPayment = 0;

    /**
     * 交換情報識別番号4桁(平成18年4月以前8221固定　平成18年4月以降8222固定)を取得します。
     * @return
     */
    protected String get_1201001() {
        return _1201001;
    }

    /**
     * 交換情報識別番号4桁(平成18年4月以前8221固定　平成18年4月以降8222固定)を設定します。
     * @param _1201001
     */
    protected void set_1201001(String _1201001) {
        this._1201001 = _1201001;
    }

    /**
     * 対象年月6桁(YYYYMM)を取得します。
     * @return
     */
    protected String get_1201002() {
        return _1201002;
    }
    
    /**
     * 対象年月6桁(YYYYMM)を設定します。
     * @param _1201002
     */
    protected void set_1201002(String _1201002) {
        this._1201002 = _1201002;
    }

    /**
     * 証記載保険者番号8桁を取得します。
     * @return
     */
    protected String get_1201003() {
        return _1201003;
    }

    /**
     * 証記載保険者番号8桁を設定します。
     * @param _1201003
     */
    protected void set_1201003(String _1201003) {
        this._1201003 = _1201003;
    }

    /**
     * 事業所番号10桁(居宅介護支援事業所、もしくは介護予防支援事業所)を取得します。
     * @return
     */
    protected String get_1201004() {
        return _1201004;
    }
    
    /**
     * 事業所番号10桁(居宅介護支援事業所、もしくは介護予防支援事業所)を設定します。
     * @param _1201004
     */
    protected void set_1201004(String _1201004) {
        this._1201004 = _1201004;
    }

    /**
     * 給付管理票情報作成区分コード1桁　1-新規 2-修正 3-取消を取得します。
     * @return
     */
    protected int get_1201005() {
        return _1201005;
    }

    /**
     * 給付管理票情報作成区分コード1桁　1-新規 2-修正 3-取消を設定します。
     * @param _1201005
     */
    protected void set_1201005(int _1201005) {
        this._1201005 = _1201005;
    }

    /**
     * 給付管理票作成年月日8桁(YYYYMMDD)を取得します。
     * @return
     */
    protected String get_1201006() {
        return _1201006;
    }

    /**
     * 給付管理票作成年月日8桁(YYYYMMDD)を設定します。
     * @param _1201006
     */
    protected void set_1201006(String _1201006) {
        this._1201006 = _1201006;
    }

    /**
     * 給付管理票種別区分コード1桁
     * 1-訪問通所サービス給付管理票 2-短期入所サービス給付管理票 3-居宅サービス区分給付管理票
     * を取得します。
     * @return
     */
    protected int get_1201007() {
        return _1201007;
    }

    /**
     * 給付管理票種別区分コード1桁
     * 1-訪問通所サービス給付管理票 2-短期入所サービス給付管理票 3-居宅サービス区分給付管理票
     * を設定します。
     * @param _1201007
     */
    protected void set_1201007(int _1201007) {
        this._1201007 = _1201007;
    }

    /**
     * 給付管理票明細行番号2桁を取得します。
     * @return
     */
    protected int get_1201008() {
        return _1201008;
    }

    /**
     * 給付管理票明細行番号2桁を設定します。
     * @param _1201008
     */
    protected void set_1201008(int _1201008) {
        this._1201008 = _1201008;
    }

    /**
     * 被保険者番号10桁を取得します。
     * @return
     */
    protected String get_1201009() {
        return _1201009;
    }

    /**
     * 被保険者番号10桁を設定します。
     * @param _1201009
     */
    protected void set_1201009(String _1201009) {
        this._1201009 = _1201009;
    }

    /**
     * 被保険者生年月日8桁(YYYYMMDD)を取得します。
     * @return
     */
    protected String get_1201010() {
        return _1201010;
    }

    /**
     * 被保険者生年月日8桁(YYYYMMDD)を設定します。
     * @param _1201010
     */
    protected void set_1201010(String _1201010) {
        this._1201010 = _1201010;
    }

    /**
     * 性別コード1桁　1-男 2-女を取得します。
     * @return
     */
    protected String get_1201011() {
        return _1201011;
    }

    /**
     * 性別コード1桁　1-男 2-女を設定します。
     * @param _1201011
     */
    protected void set_1201011(String _1201011) {
        this._1201011 = _1201011;
    }

    /**
     *  要介護状態区分コード2桁
     * 01-非該当 11-要支援(経過的要介護) 12-要支援1 13-要支援2 21-要介護1 22-要介護2 23-要介護3 24-要介護4 25-要介護5
     * を取得します。
     * @return
     */
    protected String get_1201012() {
        return _1201012;
    }

    /**
     *  要介護状態区分コード2桁
     * 01-非該当 11-要支援(経過的要介護) 12-要支援1 13-要支援2 21-要介護1 22-要介護2 23-要介護3 24-要介護4 25-要介護5
     * を設定します。
     * @param _1201012
     */
    protected void set_1201012(String _1201012) {
        this._1201012 = _1201012;
    }

    /**
     * 限度額適用期間(開始)6桁(YYYYMM)を取得します。
     * @return
     */
    protected String get_1201013() {
        return _1201013;
    }

    /**
     * 限度額適用期間(開始)6桁(YYYYMM)を設定します。
     * @param _1201013
     */
    protected void set_1201013(String _1201013) {
        this._1201013 = _1201013;
    }

    /**
     * 限度額適用期間(終了)6桁(YYYYMM)を取得します。
     * @return
     */
    protected String get_1201014() {
        return _1201014;
    }

    /**
     * 限度額適用期間(終了)6桁(YYYYMM)を設定します。
     * @param _1201014
     */
    protected void set_1201014(String _1201014) {
        this._1201014 = _1201014;
    }

    /**
     * 居宅・介護予防支給限度額6桁を取得します。
     * @return
     */
    protected String get_1201015() {
        return _1201015;
    }

    /**
     * 居宅・介護予防支給限度額6桁を設定します。
     * @param _1201015
     */
    protected void set_1201015(String _1201015) {
        this._1201015 = _1201015;
    }

    /**
     * 居宅サービス計画作成区分コード1桁
     * 1-居宅介護支援事業所作成　2-自己作成　3-介護予防支援事業所作成
     * を取得します。
     * @return
     */
    protected int get_1201016() {
        return _1201016;
    }

    /**
     * 居宅サービス計画作成区分コード1桁
     * 1-居宅介護支援事業所作成　2-自己作成　3-介護予防支援事業所作成
     * を設定します。
     * @param _1201016
     */
    protected void set_1201016(int _1201016) {
        this._1201016 = _1201016;
    }

    /**
     * 事業所番号(サービス事業所)10桁を取得します。
     * @return
     */
    protected String get_1201017() {
        return _1201017;
    }

    /**
     *事業所番号(サービス事業所)10桁を設定します。 
     * @param _1201017
     */
    protected void set_1201017(String _1201017) {
        this._1201017 = _1201017;
    }

    /**
     * 指定/基準該当等事業所区分コード1桁
     * 1-指定事業所 2-基準該当事業所 3-相当サービス事業所 4-その他 5-地域密着型サービス
     * を取得します。
     * @return
     */
    protected int get_1201018() {
        return _1201018;
    }

    /**
     * 指定/基準該当等事業所区分コード1桁
     * 1-指定事業所 2-基準該当事業所 3-相当サービス事業所 4-その他 5-地域密着型サービス
     * を設定します。
     * @param _1201018
     */
    protected void set_1201018(int _1201018) {
        this._1201018 = _1201018;
    }

    /**
     * サービス種類コード2桁を取得します。
     * @return
     */
    protected String get_1201019() {
        return _1201019;
    }

    /**
     * サービス種類コード2桁を設定します。
     * @param _1201019
     */
    protected void set_1201019(String _1201019) {
        this._1201019 = _1201019;
    }

    /**
     * 給付計画単位数/日数6桁を取得します。
     * @return
     */
    protected int get_1201020() {
        return _1201020;
    }

    /**
     * 給付計画単位数/日数6桁を設定します。
     * @param _1201020
     */
    protected void set_1201020(int _1201020) {
        this._1201020 = _1201020;
    }

    /**
     * 限度額管理期間における前月までの給付計画日数3桁を取得します。
     * @return
     */
    protected String get_1201021() {
        return _1201021;
    }

    /**
     * 限度額管理期間における前月までの給付計画日数3桁を設定します。
     * @param _1201021
     */
    protected void set_1201021(String _1201021) {
        this._1201021 = _1201021;
    }

    /**
     * 指定サービス分小計6桁を取得します。
     * @return
     */
    protected String get_1201022() {
        return _1201022;
    }

    /**
     * 指定サービス分小計6桁を設定します。
     * @param _1201022
     */
    protected void set_1201022(String _1201022) {
        this._1201022 = _1201022;
    }

    /**
     * 基準該当サービス分小計6桁を取得します。
     * @return
     */
    protected String get_1201023() {
        return _1201023;
    }

    /**
     * 基準該当サービス分小計6桁を設定します。
     * @param _1201023
     */
    protected void set_1201023(String _1201023) {
        this._1201023 = _1201023;
    }

    /**
     * 給付計画合計単位数/日数6桁を取得します。
     * @return
     */
    protected int get_1201024() {
        return _1201024;
    }

    /**
     * 給付計画合計単位数/日数6桁を設定します。
     * @param _1201024
     */
    protected void set_1201024(int _1201024) {
        this._1201024 = _1201024;
    }

    /**
     * 担当介護支援専門員番号を取得します。
     * @return
     */
    protected String get_1201025() {
        return _1201025;
    }

    /**
     * 担当介護支援専門員番号を設定します。
     * @param _1201025
     */
    protected void set_1201025(String _1201025) {
        this._1201025 = _1201025;
    }

    /**
     * 委託先の居宅介護支援事業所番号を取得します。
     * @return
     */
    protected String get_1201026() {
        return _1201026;
    }

    /**
     * 委託先の居宅介護支援事業所番号を設定します。
     * @param _1201026
     */
    protected void set_1201026(String _1201026) {
        this._1201026 = _1201026;
    }

    /**
     * 委託先の担当介護支援専門員番号を取得する。
     * @return
     */
    protected String get_1201027() {
        return _1201027;
    }

    /**
     * 委託先の担当介護支援専門員番号を設定する。
     * @param _1201027
     */
    protected void set_1201027(String _1201027) {
        this._1201027 = _1201027;
    }
    
    /**
     * 保険者名を取得します。
     * @return
     */
    protected String get_1201028(){
        return _1201028;
    }
    
    /**
     * 保険者名を設定します。
     * @param _1201028
     */
    protected void set_1201028(String _1201028){
        this._1201028 = _1201028;
    }
    
    /**
     * サービス種類名を取得します。
     * @return
     */
    protected String get_1201029(){
        return _1201029;
    }
    
    /**
     * サービス種類名を設定します。
     * @param _1201029
     */
    protected void set_1201029(String _1201029){
        this._1201029 = _1201029;
    }
    
    /**
     * 既に情報が登録されているか返却します。
     * 
     * @return 新規:true 追加:false
     */
    protected boolean isNew() {
        // 交換情報レコードに登録が無ければ新規とみなす。
        return ((get_1201001() == null) || ("".equals(get_1201001())));
    }
    /**
     * 自費調整を本レコードに反映させたかフラグ
     */
    private boolean individualPaymentFlag = false;
    
    /**
     * データのパースを実行します。
     * 
     * @param serviceDetail
     * @param targetDate
     * @param patientState
     * @param serviceCode
     * @throws Exception
     */
    //2007.2.8 fujihara.shin 夜間訪問型の障害対応
//    protected void parse(VRMap serviceDetail, Date targetDate,
//            QP001PatientState patientState, VRMap serviceCode,
//            String identificationNo,boolean first,QP001Manager manager) throws Exception {
    protected boolean parse(VRMap serviceDetail, Date targetDate,
            QP001PatientState patientState, VRMap serviceCode,
            String identificationNo,boolean first,QP001Manager manager) throws Exception {
    	
    	boolean result = first;

        Object targetServiceDate = VRBindPathParser.get("SERVICE_DATE",serviceDetail);
        
        // データ設定の可否を判定する。
        if(!isSetData(targetServiceDate,serviceCode)){
            return result;
        }
        
        //限度額適用期間が取得可能であるかチェックを行う。
        //開始日
        if(ACTextUtilities.isNullText(patientState.getNinteiDataLast(patientState.getInsurerId(targetServiceDate), patientState.getInsuredId(targetServiceDate),"INSURE_VALID_START"))){
            return result;
        }
        //終了日
        if(ACTextUtilities.isNullText(patientState.getNinteiDataLast(patientState.getInsurerId(targetServiceDate), patientState.getInsuredId(targetServiceDate),"INSURE_VALID_END"))){
            return result;
        }
        
// [H27.4改正対応][Yoichiro Kamei] 看取り加算関連の加算日数に対応 2015/3/19 mod - begin
        // [CCCX:2915][Shinobu Hitaka] 2015/10/7 edit - begin  1回目の割引率が計算されない
        //int reducedUnit = manager.getServiceUnit(get_1201017(),serviceCode);
        String providerID = get_1201017();
        if (ACTextUtilities.isNullText(providerID)) {
        	providerID = ACCastUtilities.toString(VRBindPathParser.get("PROVIDER_ID", serviceDetail));
        }
        int reducedUnit = manager.getServiceUnit(providerID,serviceCode);
        // [CCCX:2915][Shinobu Hitaka] 2015/10/7 edit - end  1回目の割引率が計算されない
        
        String serviceCodeKind = ACCastUtilities.toString(serviceCode.get("SERVICE_CODE_KIND"));
        String serviceCodeItem = ACCastUtilities.toString(serviceCode.get("SERVICE_CODE_ITEM"));
        //看取り関連の加算コードであれば、単位数×加算日数とする
        int serviceCount = QP001SpecialCase.getServiceCount(serviceCodeKind
            , serviceCodeItem
            , serviceDetail);                                                
        if (serviceCount > 1) {
            reducedUnit = reducedUnit * serviceCount;
        }
// [H27.4改正対応][Yoichiro Kamei] 看取り加算関連の加算日数に対応 2015/3/19 mod - end
        
        if (isNew()) {
            // 交換識別番号を設定する。
            set_1201001(identificationNo);
            
            // 対象年月日を設定する。
            set_1201002(VRDateParser.format(targetDate, "yyyyMM"));
            
            // 証記載保険者番号8桁を設定します。
            set_1201003(patientState.getInsurerId(targetServiceDate));
            
            //被保険者番号10桁
            set_1201009(patientState.getInsuredId(targetServiceDate));
            
            //事業所番号10桁(居宅介護支援事業所、もしくは介護予防支援事業所)を設定します。
            //set_1201004(patientState.getNinteiData(targetServiceDate, "PROVIDER_ID"));
            set_1201004(patientState.getNinteiDataLast(get_1201003(),get_1201009(),"PROVIDER_ID"));
            
            //給付管理票情報作成区分コード1桁　1-新規 2-修正 3-取消を設定します。
            set_1201005(1);
            
            //給付管理票作成年月日8桁(YYYYMMDD)を設定します。
            //※印刷・CSV出力時に決定
            set_1201006("");
            
            //給付管理票種別区分コード1桁　1-訪問通所サービス給付管理票 2-短期入所サービス給付管理票 3-居宅サービス区分給付管理票
            //3固定
            set_1201007(3);
            
            //給付管理票明細行番号2桁
            set_1201008(0);
            
//            //被保険者番号10桁
//            set_1201009(patientState.getInsuredId(targetServiceDate));
            
            //被保険者生年月日8桁(YYYYMMDD)
            set_1201010(patientState.getPatientData("PATIENT_BIRTHDAY").replaceAll("-", ""));
            
            //性別コード1桁　1-男 2-女
            set_1201011(patientState.getPatientData("PATIENT_SEX"));
            
            //要介護状態区分コード2桁　01-非該当 06-事業対象者 11-要支援(経過的要介護) 12-要支援1 13-要支援2 21-要介護1 22-要介護2 23-要介護3 24-要介護4 25-要介護5
            //set_1201012(patientState.getNinteiDataLast(get_1201003(), get_1201009(),"JOTAI_CODE"));
            //要介護度は当月の一番重いものを採用する。
            set_1201012(patientState.getNinteiDataHeavy(get_1201003(), get_1201009(),"JOTAI_CODE"));
                        
            //限度額適用期間(開始)6桁(YYYYMM)
            //Date start = ACCastUtilities.toDate(patientState.getNinteiDataLast(get_1201003(), get_1201009(),"INSURE_VALID_START"));
            // [H27.4改正対応][Shinobu Hitaka] 2016/7/27 edit 当月の一番重いものを採用する。
            Date start = ACCastUtilities.toDate(patientState.getNinteiDataHeavy(get_1201003(), get_1201009(),"INSURE_VALID_START"));
            set_1201013(VRDateParser.format(start, "yyyyMM"));
            
            //限度額適用期間(終了)6桁(YYYYMM)
            //Date end = ACCastUtilities.toDate(patientState.getNinteiDataLast(get_1201003(), get_1201009(),"INSURE_VALID_END"));
            // [H27.4改正対応][Shinobu Hitaka] 2016/7/27 edit 当月の一番重いものを採用する。
            Date end = ACCastUtilities.toDate(patientState.getNinteiDataHeavy(get_1201003(), get_1201009(),"INSURE_VALID_END"));
            if (ACCastUtilities.toDate("9999/12/31").equals(end)) {
                // 9999-12-31の場合は空欄
            	set_1201014("");
            } else {
                set_1201014(VRDateParser.format(end, "yyyyMM"));
            }
            
            // [H27.4改正対応][Shinobu Hitaka] 2016/7/26 del - begin 総合事業対応によりコメント化
            // [H27.4改正対応][Shinobu Hitaka] 2015/3/31 add - begin 事業対象者から要支援１へ変更時の対応
            // 要支援１
            //if (get_1201012().equals("12")) {
            //    // 対象年月と限度額適用期間(開始)年月が同じ
            //    if (get_1201002().equals(get_1201013())) {
            //        // 月途中
            //        String tmpDay = VRDateParser.format(start, "dd");
            //        if (!"01".equals(tmpDay)) {
            //            String tmpJigyoFlg = patientState.getNinteiDataLast(get_1201003(), get_1201009(), "JIGYOTAISYO_FLAG");
            //            // 事業対象者フラグがON
            //            if ("2".equals(tmpJigyoFlg)) {
            //                // 要介護状態区分を 06-事業対象者 に差替える
            //                set_1201012("06");
            //            }
            //        }
            //    }
            //}
            // [H27.4改正対応][Shinobu Hitaka] 事業対象者から要支援１へ変更時の対応 2015/3/31 add - end
            // [H27.4改正対応][Shinobu Hitaka] 2016/7/26 del - end 総合事業対応によりコメント化
            
            //居宅・介護予防支給限度額6桁
            //set_1201015(patientState.getNinteiDataLast(get_1201003(), get_1201009(),"LIMIT_RATE"));
            //限度額は当月の一番重いものを採用する。
            set_1201015(patientState.getNinteiDataHeavy(get_1201003(), get_1201009(),"LIMIT_RATE"));
            
            
// 2016/8/16 [総合事業対応][Yoichiro Kamei] add - begin
            // 事業対象者で要支援１の基準額を超える場合は、国基準の要支援１の基準額を設定する
            int limitRate = ACCastUtilities.toInt(get_1201015(), 0);
            int jotaiCode = ACCastUtilities.toInt(get_1201012(), 0);
            if (jotaiCode == QkanConstants.YOUKAIGODO_JIGYOTAISHO) {
                int jigyoTaishoLimitRate = manager.getJigyotaishoLimitRate();
                if (limitRate > jigyoTaishoLimitRate) {
                    //居宅・介護予防支給限度額6桁
                    set_1201015(String.valueOf(jigyoTaishoLimitRate));
                }
            }
//2016/8/16 [総合事業対応][Yoichiro Kamei] add - end
            
            //居宅サービス計画作成区分コード1桁　1-居宅介護支援事業所作成　2-自己作成　3-介護予防支援事業所作成
            set_1201016(ACCastUtilities.toInt(patientState.getNinteiDataLast(get_1201003(), get_1201009(),"PLANNER")));
            
            //事業所番号(サービス事業所)10桁
            set_1201017(ACCastUtilities.toString(VRBindPathParser.get("PROVIDER_ID", serviceDetail)));
            
            //指定/基準該当等事業所区分コード1桁　1-指定事業所 2-基準該当事業所 3-相当サービス事業所 4-その他 5-地域密着型サービス
            //地域密着のサービスであるか確認する。
            if(QP001SpecialCase.isRegionStickingService(ACCastUtilities.toString(VRBindPathParser.get("SERVICE_CODE_KIND", serviceCode)))){
                //地域密着のサービスであれば、5-地域密着型サービスを出力する。
                set_1201018(5);
            } else if (CareServiceCommon.isSogojigyoService(ACCastUtilities.toInt(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL", serviceCode)))) {
                //総合事業のサービスであれば、6-総合事業を出力する。
                set_1201018(6);
            } else {
                set_1201018(manager.getProviderJigyouType(get_1201017()));
            }
            
            //サービス種類コード2桁
            set_1201019(ACCastUtilities.toString(VRBindPathParser.get("SERVICE_CODE_KIND", serviceCode)));
            
            //給付計画単位数/日数6桁
            //set_1201020(QP001Manager.getInstance().getServiceUnit(get_1201017(),serviceCode) - ACCastUtilities.toInt(serviceDetail.get("REGULATION_RATE"),0));
// [H27.4改正対応][Yoichiro Kamei] 看取り加算関連の加算日数に対応 2015/3/19 mod - begin
//            set_1201020(manager.getServiceUnit(get_1201017(),serviceCode));
            set_1201020(reducedUnit);
// [H27.4改正対応][Yoichiro Kamei] 看取り加算関連の加算日数に対応 2015/3/19 mod - end
            
            //限度額管理期間における前月までの給付計画日数3桁
            set_1201021("");
            //指定サービス分小計6桁
            set_1201022("");
            //基準該当サービス分小計6桁
            set_1201023("");
            //給付計画合計単位数/日数6桁
            set_1201024(0);
            
            // 保険者名称
            set_1201028(manager.getInsurerName(get_1201003()));
            
            // サービス種類名
            set_1201029(manager.getServiceName(get_1201019()));


        } else {
// [H27.4改正対応][Yoichiro Kamei] 看取り加算関連の加算日数に対応 2015/3/19 mod - begin
//            set_1201020(get_1201020() + (manager.getServiceUnit(get_1201017(),serviceCode)));
        set_1201020(get_1201020() + reducedUnit);
// [H27.4改正対応][Yoichiro Kamei] 看取り加算関連の加算日数に対応 2015/3/19 mod - end
        }
        
        //自費調整を反映させる。
        if(first){
            individualPayment += ACCastUtilities.toInt(serviceDetail.get("REGULATION_RATE"),0);
            result = false;
        }
        
        return result;
    }
    
    //データ設定の可否を判定する。
    private boolean isSetData(Object targetServiceDate,VRMap serviceCode) throws Exception {
        
        boolean result = true;
        
        int type = ACCastUtilities.toInt(serviceCode.get("TOTAL_GROUPING_TYPE"),0);
        
        String key = String.valueOf(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL")) + "-"
                   + String.valueOf(serviceCode.get("SERVICE_CODE_KIND")) + "-"
                   + String.valueOf(serviceCode.get("SERVICE_CODE_ITEM"));
        
        //未登録のサービスであればデータを設定する。
        if(!totalGroupintType.containsKey(key)){
            VRList days = new VRArrayList();
            days.add(targetServiceDate);
            totalGroupintType.put(key,days);
            return result;
        }
        
        //算定モードの確認
        switch(type){
            //1-回数単位
            case 1:
                break;
            //2-日単位
            case 2:
                //既に同じ日に入力されているか確認
                VRList days = (VRList)totalGroupintType.get(key);
                if(days.contains(targetServiceDate)){
                    result = false;
                } else {
                    days.add(targetServiceDate);
                    totalGroupintType.put(key,days);
                }
                break;
            //3-月単位
            case 3:
                result = false;
                break;
            default:
                result = false;
                break;
        }
        
        return result;
    }

    /**
     * レコードのユニークなキーを返却します。
     */
    protected String getSerialId() {
        StringBuilder serial = new StringBuilder();
        // 交換情報識別番号4桁
        serial.append(get_1201001());
        // サービス提供年月6桁(YYYYMM)
        serial.append(get_1201002());
        // 事業所番号10桁
        serial.append(get_1201004());
        // 提供事業所番号
        serial.append(get_1201017());
        // サービス種類コード
        serial.append(get_1201019());
        return serial.toString();
    }
    
    /**
     * レコード作成の可否を判断する
     * @param identificationNo
     * @param targetDate
     * @param targetServiceDate
     * @param serviceDetail
     * @param serviceCode
     * @param patientState
     * @param supplyMap
     * @return
     * @throws Exception
     */
    protected static QP001RecordSupply getInstance(String identificationNo,
            Date targetDate, Object targetServiceDate, VRMap serviceDetail,
            VRMap serviceCode, QP001PatientState patientState,Map supplyMap) throws Exception {
        
        QP001RecordSupply supply = null;
        
        //レコードの作成可否を判断
        if(!isMakeRecord(serviceCode,serviceDetail)){
            return supply;
        }
        
        String serial = getSerialId(identificationNo,
                                    targetDate,
                                    targetServiceDate,
                                    serviceDetail,
                                    patientState,
                                    serviceCode);
        
        //条件に合致するレコードが存在しない場合
        if(!supplyMap.containsKey(serial)){
            supply = new QP001RecordSupply();
            supplyMap.put(serial,supply);
        //条件に合致するレコードが存在する場合
        } else {
            supply = (QP001RecordSupply)supplyMap.get(serial);
        }
        
        return supply;
    }
    
    private static boolean isMakeRecord(VRMap serviceCode,VRMap serviceDetail) throws Exception {
        
        //給付管理限度額対象フラグを確認する。
        //フラグが1(給付管理限度額対象)以外の場合は、レコードの作成を中断する。
        if(!String.valueOf(serviceCode.get("LIMIT_AMOUNT_OBJECT")).equals("1")){
            return false;
        }
        //30日超であればレコードの作成を中断する。
        if(ACCastUtilities.toInt(serviceDetail.get("5"),0) == 2){
            return false;
        }
        return true;
    }
    
    private static String getSerialId(String identificationNo,
            Date targetDate, Object targetServiceDate, VRMap serviceDetail,
            QP001PatientState patientState,VRMap serviceCode) throws Exception {
        //レコードのシリアルIDを作成
        StringBuilder serial = new StringBuilder();
//        // 交換識別番号
//        serial.append(identificationNo);
//        // サービス提供年月6桁(YYYYMM)
//        serial.append(VRDateParser.format(targetDate, "yyyyMM"));
//        // 事業所番号10桁
//        serial.append(patientState.getNinteiData(targetServiceDate, "PROVIDER_ID"));
//        // 提供事業所番号10桁
//        serial.append(serviceDetail.get("PROVIDER_ID"));
//        // サービス種類コード
//        serial.append(serviceCode.get("SERVICE_CODE_KIND"));
        
        // 交換識別番号
        serial.append(identificationNo);
        // サービス提供年月6桁(YYYYMM)
        serial.append(VRDateParser.format(targetDate, "yyyyMM"));
        // サービス種類コード
        serial.append(serviceCode.get("SERVICE_CODE_KIND"));
        // 提供事業所番号10桁
        serial.append(serviceDetail.get("PROVIDER_ID"));
        // 事業所番号10桁
        serial.append(patientState.getNinteiData(targetServiceDate, "PROVIDER_ID"));
        
        return serial.toString();
    }

    /**
     * レコード内容の確定を行う。
     */
    protected void commitRecord() throws Exception {
        //自費調整額を反映させたか確認する。
        if(!individualPaymentFlag){
            //自費調整総額を反映
            set_1201020(get_1201020() - individualPayment);
            individualPaymentFlag = true;
        }
    }
    
    /**
     * レコード番号99の決定を行う。
     * @param supplyMap
     * @throws Exception
     */
    protected void commitRecord(Map supplyMap) throws Exception {
        
        if(!commited){
            QP001RecordSupply supply = null;
            Iterator it = supplyMap.keySet().iterator();
            int count = 1;
            while(it.hasNext()){
                supply = (QP001RecordSupply)supplyMap.get(it.next());
                
                //初回ループ時、必用なデータをコピーする。
                if(count == 1){
                    //交換識別番号
                    set_1201001(supply.get_1201001());
                    //対象年月
                    set_1201002(supply.get_1201002());
                    //証記載保険者番号
                    set_1201003(supply.get_1201003());
                    //事業所番号
                    set_1201004(supply.get_1201004());
                    //給付管理票作成区分コード
                    set_1201005(supply.get_1201005());
                    //給付管理票作成年月日
                    set_1201006(supply.get_1201006());
                    //給付管理票種別コード
                    set_1201007(supply.get_1201007());
                    //給付管理票明細行番号
                    set_1201008(99);
                    //被保険者番号
                    set_1201009(supply.get_1201009());
                    //被保険者生年月日
                    set_1201010(supply.get_1201010());
                    //性別コード
                    set_1201011(supply.get_1201011());
                    //要介護状態区分コード
                    set_1201012(supply.get_1201012());
                    //限度額摘要期間(開始)
                    set_1201013(supply.get_1201013());
                    //限度額適用期間(終了)
                    set_1201014(supply.get_1201014());
                    //居宅・介護予防支給限度額
                    set_1201015(supply.get_1201015());
                    //居宅サービス計画作成区分コード
                    set_1201016(supply.get_1201016());
                    //担当介護支援専門員番号
                    set_1201025(supply.get_1201025());
                    //委託先の居宅介護支援事業所番号
                    set_1201026(supply.get_1201026());
                    //委託先の担当介護支援専門員番号
                    set_1201027(supply.get_1201027());
                    
                    //保険者名称
                    set_1201028(supply.get_1201028());
                    
                    
                }
                //設定値
                //明細書行番号を設定
                supply.set_1201008(count);
                //給付計画合計単位数/日数6桁
                set_1201024(get_1201024() + supply.get_1201020());
                
                //不要値
                //居宅・介護予防支給限度額
                supply.set_1201015("");
                //担当介護支援専門員番号
                supply.set_1201025("");
                //委託先の居宅介護支援事業所番号
                supply.set_1201026("");
                //委託先の担当介護支援専門員番号
                supply.set_1201027("");
                
                
                count++;
            }
            
            commited = true;
        }

    }
    
    /**
     * データ作成
     * 
     * @param style
     * @return
     */
    protected VRMap getRecord(VRMap style) throws Exception {
        VRMap result = copyStyle(style);
        
        //交換情報識別番号4桁(平成18年4月以前8221固定　平成18年4月以降8222固定)
        setData(result, "1201001", get_1201001());
        //対象年月6桁(YYYYMM)
        setData(result, "1201002", get_1201002());
        //証記載保険者番号8桁
        setData(result, "1201003", get_1201003());
        //事業所番号10桁(居宅介護支援事業所、もしくは介護予防支援事業所)
        setData(result, "1201004", get_1201004());
        //給付管理票情報作成区分コード1桁　1-新規 2-修正 3-取消
        setData(result, "1201005", get_1201005());
        //給付管理票作成年月日8桁(YYYYMMDD)
        setData(result, "1201006", get_1201006());
        //給付管理票種別区分コード1桁　1-訪問通所サービス給付管理票 2-短期入所サービス給付管理票 3-居宅サービス区分給付管理票
        setData(result, "1201007", get_1201007());
        //給付管理票明細行番号2桁
        setData(result, "1201008", get_1201008());
        //被保険者番号10桁
        setData(result, "1201009", get_1201009());
        
        //被保険者生年月日8桁(YYYYMMDD)
        setData(result, "1201010", get_1201010());
        //性別コード1桁　1-男 2-女
        setData(result, "1201011", get_1201011());
        //要介護状態区分コード2桁　01-非該当 11-要支援(経過的要介護) 12-要支援1 13-要支援2 21-要介護1 22-要介護2 23-要介護3 24-要介護4 25-要介護5
        setData(result, "1201012", get_1201012());
        //限度額適用期間(開始)6桁(YYYYMM)
        setData(result, "1201013", get_1201013());
        //限度額適用期間(終了)6桁(YYYYMM)
        setData(result, "1201014", get_1201014());
        //居宅・介護予防支給限度額6桁
        setData(result, "1201015", get_1201015());
        //居宅サービス計画作成区分コード1桁　1-居宅介護支援事業所作成　2-自己作成　3-介護予防支援事業所作成
        setData(result, "1201016", get_1201016());
        //事業所番号(サービス事業所)10桁
        setData(result, "1201017", get_1201017());
        //指定/基準該当等事業所区分コード1桁　1-指定事業所 2-基準該当事業所 3-相当サービス事業所 4-その他 5-地域密着型サービス
        setData(result, "1201018", get_1201018());
        //サービス種類コード2桁
        setData(result, "1201019", get_1201019());
        
        //給付計画単位数/日数6桁
        setData(result, "1201020", get_1201020());
        //限度額管理期間における前月までの給付計画日数3桁
        setData(result, "1201021", get_1201021());
        //指定サービス分小計6桁
        setData(result, "1201022", get_1201022());
        //基準該当サービス分小計6桁
        setData(result, "1201023", get_1201023());
        //給付計画合計単位数/日数6桁
        setData(result, "1201024", get_1201024());
        //担当介護支援専門員番号
        setData(result, "1201025", get_1201025());
        //委託先の居宅介護支援事業所番号
        setData(result, "1201026", get_1201026());
        //委託先の担当介護支援専門員番号
        setData(result, "1201027", get_1201027());
        setData(result, "1201028", get_1201028());
        setData(result, "1201029", get_1201029());
        
        return result;
    }

    private VRMap copyStyle(VRMap style) {
        VRMap result = new VRHashMap();
        Object key;
        //ディープコピー
        Iterator it = style.keySet().iterator();
        while (it.hasNext()) {
            key = it.next();
            result.put(key, style.get(key));
        }
        //給付管理票情報レコード
        //result.put("CATEGORY_NO", "12");
        result.put("CATEGORY_NO", QkanConstants.CATEGORY_NO_MANAGEMENT);
        return result;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        
        //交換情報識別番号4桁(平成18年4月以前8221固定　平成18年4月以降8222固定)
        result.append("[1201001=" + get_1201001() + "]\n");
        //対象年月6桁(YYYYMM)
        result.append("[1201002=" + get_1201002() + "]\n");
        //証記載保険者番号8桁
        result.append("[1201003=" + get_1201003() + "]\n");
        //事業所番号10桁(居宅介護支援事業所、もしくは介護予防支援事業所)
        result.append("[1201004=" + get_1201004() + "]\n");
        //給付管理票情報作成区分コード1桁　1-新規 2-修正 3-取消
        result.append("[1201005=" + get_1201005() + "]\n");
        //給付管理票作成年月日8桁(YYYYMMDD)
        result.append("[1201006=" + get_1201006() + "]\n");
        //給付管理票種別区分コード1桁　1-訪問通所サービス給付管理票 2-短期入所サービス給付管理票 3-居宅サービス区分給付管理票
        result.append("[1201007=" + get_1201007() + "]\n");
        //給付管理票明細行番号2桁
        result.append("[1201008=" + get_1201008() + "]\n");
        //被保険者番号10桁
        result.append("[1201009=" + get_1201009() + "]\n");
        
        //被保険者生年月日8桁(YYYYMMDD)
        result.append("[1201010=" + get_1201010() + "]\n");
        //性別コード1桁　1-男 2-女
        result.append("[1201011=" + get_1201011() + "]\n");
        //要介護状態区分コード2桁　01-非該当 11-要支援(経過的要介護) 12-要支援1 13-要支援2 21-要介護1 22-要介護2 23-要介護3 24-要介護4 25-要介護5
        result.append("[1201012=" + get_1201012() + "]\n");
        //限度額適用期間(開始)6桁(YYYYMM)
        result.append("[1201013=" + get_1201013() + "]\n");
        //限度額適用期間(終了)6桁(YYYYMM)
        result.append("[1201014=" + get_1201014() + "]\n");
        //居宅・介護予防支給限度額6桁
        result.append("[1201015=" + get_1201015() + "]\n");
        //居宅サービス計画作成区分コード1桁　1-居宅介護支援事業所作成　2-自己作成　3-介護予防支援事業所作成
        result.append("[1201016=" + get_1201016() + "]\n");
        //事業所番号(サービス事業所)10桁
        result.append("[1201017=" + get_1201017() + "]\n");
        //指定/基準該当等事業所区分コード1桁　1-指定事業所 2-基準該当事業所 3-相当サービス事業所 4-その他 5-地域密着型サービス
        result.append("[1201018=" + get_1201018() + "]\n");
        //サービス種類コード2桁
        result.append("[1201019=" + get_1201019() + "]\n");

        //給付計画単位数/日数6桁
        result.append("[1201020=" + get_1201020() + "]\n");
        //限度額管理期間における前月までの給付計画日数3桁
        result.append("[1201021=" + get_1201021() + "]\n");
        //指定サービス分小計6桁
        result.append("[1201022=" + get_1201022() + "]\n");
        //基準該当サービス分小計6桁
        result.append("[1201023=" + get_1201023() + "]\n");
        //給付計画合計単位数/日数6桁
        result.append("[1201024=" + get_1201024() + "]\n");
        //担当介護支援専門員番号
        result.append("[1201025=" + get_1201025() + "]\n");
        //委託先の居宅介護支援事業所番号
        result.append("[1201026=" + get_1201026() + "]\n");
        //委託先の担当介護支援専門員番号
        result.append("[1201027=" + get_1201027() + "]\n");
        result.append("[1201028=" + get_1201028() + "]\n");
        result.append("[1201029=" + get_1201029() + "]\n");
        
        return result.toString();
    }
    
}
