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
 * プログラム 明細集計レコード (QP001RecordDetail)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

/**
 * 明細集計レコード情報
 * 
 * @author shin fujihara
 * 
 */
public class QP001RecordDetail extends QP001RecordAbstract {

    // 交換情報識別番号4桁
    private String _301001 = "";

    // レコード種別コード2桁(02固定)
    private static final String _301002 = "02";

    // サービス提供年月6桁(YYYYMM)
    private String _301003 = "";

    // 事業所番号10桁
    private String _301004 = "";

    // 証記載保険者番号8桁
    private String _301005 = "";

    // 被保険者番号10桁
    private String _301006 = "";

    // サービス種類コード2桁
    private String _301007 = "";

    // サービス項目コード4桁
    private String _301008 = "";

    // 単位数4桁
    private int _301009 = 0;

    // 日数･回数2桁
    private int _301010 = 0;

    // 公費1対象日数・回数2桁
    private int _301011 = 0;

    // 公費2対象日数・回数2桁
    private int _301012 = 0;

    // 公費3対象日数・回数2桁
    private int _301013 = 0;

    // サービス単位数6桁
    private int _301014 = 0;

    // 公費1対象サービス単位数6桁
    private int _301015 = 0;

    // 公費2対象サービス単位数6桁
    private int _301016 = 0;

    // 公費3対象サービス単位数6桁
    private int _301017 = 0;

    // 摘要20桁
    private String _301018 = "";

    // サービス名称(サービスコードマスタTBLのSERVICE_NAME)
    private String _301019 = "";

    // 限度額管理対象フラグ
    private String _301020 = "";

    // システム内サービス種類コード(SYSTEM_SERVICE_KIND_DETAIL)
    private String _301021 = "";

    // システム内サービス項目コード(SYSTEM_SERVICE_CODE_ITEM)
    private String _301022 = "";

    // 公費1公費タイプ
    private String _301023 = "";

    // 公費2公費タイプ
    private String _301024 = "";

    // 公費3公費タイプ
    private String _301025 = "";

    // 給付割合
    private int _301026 = 0;
    
    // 集計タイプ
    private int totalGroupintType = 0;
    
    //特別地域加算用
    private VRMap serviceUnitMap = new VRHashMap();

    // 公費順位決定オブジェクト
    private QP001RecordSupporter kohiManager = new QP001RecordSupporter();
    
    // 摘要記載事項作成オブジェクト
    private QP001Recapitulation recapitulation = new QP001Recapitulation();
    
    //[ID:0000467][Shin Fujihara] 2009/04 add begin 平成21年4月法改正対応
    //中山間地域加算算定オブジェクト
    private QP001MountainousAreaAdder mountainousAreaAdder = new QP001MountainousAreaAdder();
    //[ID:0000467][Shin Fujihara] 2009/04 add end 平成21年4月法改正対応
    
    //[ID:0000682][Shin Fujihara] add begin 【法改正対応】介護職員処遇改善加算
    //処遇改善単位数の計算に使用する割合
    private int serviceUnit = 0;
    private int serviceStaffUnit = 0;
    //レコード種別 3-特別地域 6-中山間 8-処遇改善
    private int serviceAddFlag = 0;
    //[ID:0000682][Shin Fujihara] add end 【法改正対応】介護職員処遇改善加算
    
    //[ID:0000730][Shin Fujihara] add begin  【サービス利用票別表・実績集計】自己負担発生時の％系加算の計算について
    //特別地域、中山間加算の根拠となる単位数
    private int additionBasisUnit = 0;
    //[ID:0000730][Shin Fujihara] add end
    /**
     * 交換情報識別番号4桁を取得します。
     * 
     * @return
     */
    protected String get_301001() {
        return _301001;
    }

    /**
     * 交換情報識別番号4桁を設定します。
     * 
     * @param _301001
     */
    protected void set_301001(String _301001) {
        this._301001 = _301001;
    }

    /**
     * レコード種別コード2桁を取得します。
     * 
     * @return
     */
    protected String get_301002() {
        return _301002;
    }

    /**
     * サービス提供年月6桁(YYYYMM)を取得します。
     * 
     * @return
     */
    protected String get_301003() {
        return _301003;
    }

    /**
     * サービス提供年月6桁(YYYYMM)を設定します。
     * 
     * @param _301003
     */
    protected void set_301003(String _301003) {
        this._301003 = _301003;
    }

    /**
     * 事業所番号10桁を取得します。
     * 
     * @return
     */
    protected String get_301004() {
        return _301004;
    }

    /**
     * 事業所番号10桁を設定します。
     * 
     * @param _301004
     */
    protected void set_301004(String _301004) {
        this._301004 = _301004;
    }

    /**
     * 証記載保険者番号8桁を取得します。
     * 
     * @return
     */
    protected String get_301005() {
        return _301005;
    }

    /**
     * 証記載保険者番号8桁を設定します。
     * 
     * @param _301005
     */
    protected void set_301005(String _301005) {
        this._301005 = _301005;
    }

    /**
     * 被保険者番号10桁を取得します。
     * 
     * @return
     */
    protected String get_301006() {
        return _301006;
    }

    /**
     * 被保険者番号10桁を設定します。
     * 
     * @param _301006
     */
    protected void set_301006(String _301006) {
        this._301006 = _301006;
    }

    /**
     * サービス種類コード2桁を取得します。
     * 
     * @return
     */
    protected String get_301007() {
        return _301007;
    }

    /**
     * サービス種類コード2桁を設定します。
     * 
     * @param _301007
     */
    protected void set_301007(String _301007) {
        this._301007 = _301007;
    }

    /**
     * サービス項目コード4桁を取得します。
     * 
     * @return
     */
    protected String get_301008() {
        return _301008;
    }

    /**
     * サービス項目コード4桁を設定します。
     */
    protected void set_301008(String _301008) {
        this._301008 = _301008;
    }

    /**
     * 単位数4桁を取得します。
     * 
     * @return
     */
    protected int get_301009() {
        return _301009;
    }

    /**
     * 単位数4桁を設定します。
     * 
     * @param _301009
     */
    protected void set_301009(int _301009) {
        this._301009 = _301009;
    }

    /**
     * 日数･回数2桁を取得します。
     * 
     * @return
     */
    protected int get_301010() {
        return _301010;
    }

    /**
     * 日数･回数2桁を設定します。
     * 
     * @param _301010
     */
    protected void set_301010(int _301010) {
        this._301010 = _301010;
    }

    /**
     * 公費1対象日数・回数2桁を取得します。
     * 
     * @return
     */
    protected int get_301011() {
        return _301011;
    }

    /**
     * 公費1対象日数・回数2桁を設定します。
     * 
     * @param _301011
     */
    protected void set_301011(int _301011) {
        this._301011 = _301011;
    }

    /**
     * 公費2対象日数・回数2桁を取得します。
     * 
     * @return
     */
    protected int get_301012() {
        return _301012;
    }

    /**
     * 公費2対象日数・回数2桁を設定します。
     * 
     * @param _301012
     */
    protected void set_301012(int _301012) {
        this._301012 = _301012;
    }

    /**
     * 公費3対象日数・回数2桁を取得します。
     * 
     * @return
     */
    protected int get_301013() {
        return _301013;
    }

    /**
     * 公費3対象日数・回数2桁を設定します。
     * 
     * @param _301013
     */
    protected void set_301013(int _301013) {
        this._301013 = _301013;
    }

    /**
     * サービス単位数6桁を取得します。
     * 
     * @return
     */
    protected int get_301014() {
        return _301014;
    }

    /**
     * サービス単位数6桁を設定します。
     * 
     * @param _301014
     */
    protected void set_301014(int _301014) {
        this._301014 = _301014;
    }

    /**
     * 公費1対象サービス単位数6桁を取得します。
     * 
     * @return
     */
    protected int get_301015() {
        return _301015;
    }

    /**
     * 公費1対象サービス単位数6桁を設定します。
     * 
     * @param _301015
     */
    protected void set_301015(int _301015) {
        this._301015 = _301015;
    }

    /**
     * 公費2対象サービス単位数6桁を取得します。
     * 
     * @return
     */
    protected int get_301016() {
        return _301016;
    }

    /**
     * 公費2対象サービス単位数6桁を設定します。
     * 
     * @param _301016
     */
    protected void set_301016(int _301016) {
        this._301016 = _301016;
    }

    /**
     * 公費3対象サービス単位数6桁を取得します。
     * 
     * @return
     */
    protected int get_301017() {
        return _301017;
    }

    /**
     * 公費3対象サービス単位数6桁を設定します。
     * 
     * @param _301017
     */
    protected void set_301017(int _301017) {
        this._301017 = _301017;
    }

    /**
     * 摘要20桁を取得します。
     * 
     * @return
     */
    protected String get_301018() {
        return _301018;
    }

    /**
     * 摘要20桁を設定します。
     * 
     * @param _301018
     */
    protected void set_301018(String _301018) {
        this._301018 = _301018;
    }

    /**
     * サービス名称(サービスコードマスタTBLのSERVICE_NAME)を取得します。
     * 
     * @return
     */
    protected String get_301019() {
        return _301019;
    }

    /**
     * サービス名称(サービスコードマスタTBLのSERVICE_NAME)を設定します。
     * 
     * @param _301019
     */
    protected void set_301019(String _301019) {
        this._301019 = _301019;
    }

    /**
     * 限度額管理対象フラグを取得します。
     * 
     * @return
     */
    protected String get_301020() {
        return _301020;
    }

    /**
     * 限度額管理対象フラグを設定します。
     * 
     * @param _301020
     */
    protected void set_301020(String _301020) {
        this._301020 = _301020;
    }

    /**
     * システム内サービス種類コード(SYSTEM_SERVICE_KIND_DETAIL)を取得します。
     * 
     * @return
     */
    protected String get_301021() {
        return _301021;
    }

    /**
     * システム内サービス種類コード(SYSTEM_SERVICE_KIND_DETAIL)を設定します。
     * 
     * @param _301021
     */
    protected void set_301021(String _301021) {
        this._301021 = _301021;
    }

    /**
     * システム内サービス項目コード(SYSTEM_SERVICE_CODE_ITEM)を取得します。
     * 
     * @return
     */
    protected String get_301022() {
        return _301022;
    }

    /**
     * システム内サービス項目コード(SYSTEM_SERVICE_CODE_ITEM)を設定します。
     * 
     * @param _301022
     */
    protected void set_301022(String _301022) {
        this._301022 = _301022;
    }

    /**
     * 公費1公費タイプを取得します。
     * 
     * @return
     */
    protected String get_301023() {
        return _301023;
    }

    /**
     * 公費1公費タイプを設定します。
     * 
     * @param _301023
     */
    protected void set_301023(String _301023) {
        this._301023 = _301023;
    }

    /**
     * 公費2公費タイプを取得します。
     * 
     * @return
     */
    protected String get_301024() {
        return _301024;
    }

    /**
     * 公費2公費タイプを設定します。
     * 
     * @param _301024
     */
    protected void set_301024(String _301024) {
        this._301024 = _301024;
    }

    /**
     * 公費3公費タイプを取得します。
     * 
     * @return
     */
    protected String get_301025() {
        return _301025;
    }

    /**
     * 公費3公費タイプを設定します。
     * 
     * @param _301025
     */
    protected void set_301025(String _301025) {
        this._301025 = _301025;
    }

    /**
     * 給付割合を取得します。
     * 
     * @return
     */
    protected int get_301026() {
        return _301026;
    }

    /**
     * 給付割合を設定します。
     * 
     * @param _301026
     */
    protected void set_301026(int _301026) {
        this._301026 = _301026;
    }
    
    /**
     * 特地加算算出用のMapを取得する。
     * @return
     */
    protected VRMap getServiceUnitMap(){
    	return serviceUnitMap;
    }
    
    /**
     * 特地加算算出用のMapを設定する。
     * @param serviceUnitMap
     */
    protected void setServiceUnitMap(VRMap serviceUnitMap){
    	this.serviceUnitMap = serviceUnitMap;
    }
    
    
    //[ID:0000682][Shin Fujihara] add begin 【法改正対応】介護職員処遇改善加算
    /**
     * 特別地域、中山間の加算割合（％）
     * 処遇改善の加算割合（‰）
     * @return
     */
    public int getServiceUnit() {
        return serviceUnit;
    }
    /**
     * 処遇改善のキャリアパス要件等の適合状況に応じた交付率（％）
     * @return
     */
    public int getServiceStaffUnit() {
        return serviceStaffUnit;
    }
    
    /**
     * サービスの加算フラグ
     * 3-特別地域加算 6-中山間 8-処遇改善
     * @return
     */
    public int getServiceAddFlag() {
        return serviceAddFlag;
    }
    
    /**
     * 処遇改善レコードであるか
     * @return
     */
    public boolean isSyoguRecoed() {
        return serviceAddFlag == 8;
    }
    
    /**
     * 特地加算レコードであるか
     * @return
     */
    public boolean isTokuchi() {
        return serviceAddFlag == 3;
    }
    
    /**
     * 中山間加算レコードであるか
     * @return
     */
    public boolean isMountainsArea() {
        return serviceAddFlag == 6;
    }
    //[ID:0000682][Shin Fujihara] add end 【法改正対応】介護職員処遇改善加算
    //[ID:0000730][Shin Fujihara] add begin  【サービス利用票別表・実績集計】自己負担発生時の％系加算の計算について
    /**
     * 特別地域、中山間、処遇改善加算の根拠となる単位数
     * @return
     */
    public int getAdditionBasisUnit() {
        return additionBasisUnit;
    }
    
    /**
     * 特別地域、中山間、処遇改善加算の根拠となる単位数
     * @return
     */
    public void setAdditionBasisUnit(int additionBasisUnit) {
        this.additionBasisUnit = additionBasisUnit;
    }
    //[ID:0000730][Shin Fujihara] add end
    

    /**
     * 既に情報が登録されているか返却します。
     * 
     * @return 新規:true 追加:false
     */
    private boolean isNew() {
        // 交換情報レコードに登録が無ければ新規とみなす。
        return ((get_301001() == null) || ("".equals(get_301001())));
    }

    /**
     * データのパースを実行します。
     * 
     * @param serviceDetail
     * @param targetDate
     * @param patientState
     * @param serviceCode
     * @throws Exception
     */
    protected void parse(VRMap serviceDetail, Date targetDate,
            QP001PatientState patientState, VRMap serviceCode,
            String identificationNo,QP001Manager manager) throws Exception {

        Object targetServiceDate = VRBindPathParser.get("SERVICE_DATE",
                serviceDetail);
        
        // データ設定の可否を判定する。
        if(!isSetData(targetServiceDate,serviceCode)){
            //日付の設定のみ行う。
        	//[ID:0000586][Shin Fujihara] 2010/01 edit begin 2009年度対応
        	//サービスコードの情報も必要になるため、引数に追加
            //kohiManager.setDate(targetServiceDate,serviceDetail);
        	kohiManager.setDate(targetServiceDate,serviceDetail,serviceCode);
            //[ID:0000586][Shin Fujihara] 2010/01 edit end 2009年度対応
            return;
        }
        
        int serviceCount = 1;
        
        // レコードが新規作成であるか確認
        if (isNew()) {
            
            // type の KEY : 301001(交換情報識別番号4桁) に VALUE : 第６引数を設定する。
            set_301001(identificationNo);

            // type の KEY : 301003(サービス提供年月) に
            // VALUE : yyyyMM形式にフォーマットしたtargetDateを設定する。
            set_301003(VRDateParser.format(targetDate, "yyyyMM"));

            // type の KEY : 301004(事業所番号) に
            // VALUE : 10桁フォーマットした事業所番号(serviceDetailより取得)を設定する。
            set_301004(ACCastUtilities.toString(VRBindPathParser.get(
                    "PROVIDER_ID", serviceDetail)));

            // type の KEY : 301005(証記載保険者番号) に
            // VALUE : 8桁フォーマットした利用者の保険者番号(patientより取得)を設定する。
            set_301005(patientState.getInsurerId(targetServiceDate));

            // type の KEY : 301006(被保険者番号) に
            // VALUE : 10桁フォーマットした利用者の被保険者番号(patientより取得)を設定する。
            set_301006(patientState.getInsuredId(targetServiceDate));

            // type の KEY : 301007(サービス種類コード) に
            // VALUE : 2桁フォーマットしたサービス種類コード(serviceCodeより取得)を設定する。
            set_301007(ACCastUtilities.toString(VRBindPathParser.get(
                    "SERVICE_CODE_KIND", serviceCode)));

            // type の KEY : 301008(サービス項目コード) に
            // VALUE : 4桁フォーマットしたサービス項目コード(serviceCodeより取得)を設定する。
            set_301008(ACCastUtilities.toString(VRBindPathParser.get(
                    "SERVICE_CODE_ITEM", serviceCode)));

            // type の KEY : 301009(単位数) に
            // VALUE : 4桁フォーマットした単位数(serviceDetailより取得)を設定する。
            // set_301009(ACCastUtilities.toInt(VRBindPathParser.get("SERVICE_UNIT",serviceCode)));
            //[ID:0000682][Shin Fujihara] delete begin 【法改正対応】介護職員処遇改善加算
//            //加算を確認
//            if(ACCastUtilities.toInt(serviceCode.get("SERVICE_ADD_FLAG"),0) != 3){
//                set_301009(manager.getServiceUnit(get_301004(),
//                        serviceCode));
//            } else {
//                set_301009(ACCastUtilities.toInt(serviceCode.get("SERVICE_UNIT"),0));
//            }
            //[ID:0000682][Shin Fujihara] delete end 【法改正対応】介護職員処遇改善加算
            
            //[ID:0000682][Shin Fujihara] add begin 【法改正対応】介護職員処遇改善加算
            serviceAddFlag = ACCastUtilities.toInt(serviceCode.get("SERVICE_ADD_FLAG"),0);
            //加算を確認
            if(serviceAddFlag != 3){
                set_301009(manager.getServiceUnit(get_301004(), serviceCode));
            } else {
                set_301009(ACCastUtilities.toInt(serviceCode.get("SERVICE_UNIT"),0));
            }
            //[ID:0000682][Shin Fujihara] add end 【法改正対応】介護職員処遇改善加算

            // type の KEY : 301019(サービス名称) に
            // VALUE : サービスコードマスタTBLのSERVICE_NAMEを設定する。
            set_301019(ACCastUtilities.toString(VRBindPathParser.get(
                    "SERVICE_NAME", serviceCode)));

            // type の KEY : 301020(限度額管理対象フラグ) に
            // VALUE : 限度額管理対象フラグ(serviceCodeより取得)を設定する。
            set_301020(ACCastUtilities.toString(VRBindPathParser.get(
                    "LIMIT_AMOUNT_OBJECT", serviceCode)));

            // tyep の KEY : 301021(システム内サービス種類コード)に
            // VALUE システム内サービス種類コード(serviceCodeより取得)を設定する。
            set_301021(ACCastUtilities.toString(VRBindPathParser.get(
                    "SYSTEM_SERVICE_KIND_DETAIL", serviceCode)));

            // type の KEY : 301022(システム内サービス項目コード)に
            // VALUE システム内サービス項目コード(serviceCodeより取得)を設定する。
            set_301022(ACCastUtilities.toString(VRBindPathParser.get(
                    "SYSTEM_SERVICE_CODE_ITEM", serviceCode)));

            // 給付割合を設定する。
            if(!ACTextUtilities.isNullText(patientState.getNinteiData(targetServiceDate,"INSURE_RATE"))){
                set_301026(Integer.parseInt(patientState.getNinteiData(targetServiceDate,
                "INSURE_RATE")));
            } else {
                set_301026(0);
            }
            
            //サービスの回数を設定(見取り看護加算対応)
            //[ID:0000720][Shin Fujihara] 2012/04 delete start 2012年度対応
            // QP001SpecialCaseに処理を移動
//            if("Z6276".equals(get_301022()) || "Z6277".equals(get_301022())){
//                if("51".equals(get_301007())){
//                    serviceCount = ACCastUtilities.toInt(serviceDetail.get("1510132"),1);
//                } else if("54".equals(get_301007())){
//                    serviceCount = ACCastUtilities.toInt(serviceDetail.get("1540128"),1);
//                }
//            }
            //[ID:0000720][Shin Fujihara] 2012/04 delete end 2012年度対応
            //[ID:0000720][Shin Fujihara] 2012/04 add start 2012年度対応
            serviceCount = QP001SpecialCase.getServiceCount(get_301007(), get_301008(), serviceDetail);
            //[ID:0000720][Shin Fujihara] 2012/04 delete end 2012年度対応
            
            set_301010(serviceCount);
            
            //[ID:0000561][Shin Fujihara] 2010/01 del begin 2009年度対応
            // 摘要記載事項のデータ作成を行う
            //recapitulation.setRecapitulation(serviceDetail,serviceCode,manager);
            //[ID:0000561][Shin Fujihara] 2010/01 del begin 2009年度対応
            
            //福祉用具の適用設定
            //シリアル生成のため、暫定的に入れておく
            //レコード確定時にデータを本物の摘要に変更する。
            if(serviceDetail.containsKey("1170104")){
                //画面上の福祉用具摘要欄に入力がある場合
                if(!ACTextUtilities.isNullText(serviceDetail.get("1170104"))){
                    //摘要欄に福祉用具の摘要欄に入力された値を入力する。
                    set_301018(ACCastUtilities.toString(serviceDetail.get("1170104")));
                }
            }

        } else {
            //見取り看護加算対応
            // type の KEY : 301010(日数・回数) の VALUE : に1を加える。
            //set_301010(get_301010() + 1);
            //[ID:0000720][Shin Fujihara] 2012/04 delete start 2012年度対応
            //QP001SpecialCaseに処理を移動
//            if("Z6276".equals(get_301022()) || "Z6277".equals(get_301022())){
//                if("51".equals(get_301007())){
//                    serviceCount = ACCastUtilities.toInt(serviceDetail.get("1510132"),1);
//                } else if("54".equals(get_301007())){
//                    serviceCount = ACCastUtilities.toInt(serviceDetail.get("1540128"),1);
//                }
//            }
            //[ID:0000720][Shin Fujihara] 2012/04 delete end 2012年度対応
            //[ID:0000720][Shin Fujihara] 2012/04 add start 2012年度対応
            serviceCount = QP001SpecialCase.getServiceCount(get_301007(), get_301008(), serviceDetail);
            //[ID:0000720][Shin Fujihara] 2012/04 delete end 2012年度対応
            
            set_301010(get_301010() + serviceCount);
            
        }
        
        //[ID:0000561][Shin Fujihara] 2010/01 edit begin 2009年度対応
        // 摘要記載事項のデータ作成を行う
        recapitulation.setRecapitulation(serviceDetail,serviceCode,manager);
        //[ID:0000561][Shin Fujihara] 2010/01 edit end 2009年度対応
        
        //[ID:0000467][Shin Fujihara] 2009/04 edit begin 平成21年4月法改正対応
        //if(ACCastUtilities.toInt(serviceCode.get("SERVICE_ADD_FLAG"),0) == 3){
        //[ID:0000682][Shin Fujihara] edit begin 【法改正対応】介護職員処遇改善加算
        //switch (ACCastUtilities.toInt(serviceCode.get("SERVICE_ADD_FLAG"),0)) {
        switch (serviceAddFlag) {
        //[ID:0000682][Shin Fujihara] edit end 【法改正対応】介護職員処遇改善加算
        //特別地域加算対応
        case 3:
            //[ID:0000682][Shin Fujihara] add begin 【法改正対応】介護職員処遇改善加算
            serviceUnit = ACCastUtilities.toInt(serviceCode.get("SERVICE_UNIT"), 0);
            //[ID:0000682][Shin Fujihara] add end 【法改正対応】介護職員処遇改善加算
            //リストを保持していない場合は処理終了
            if(!serviceCode.containsKey("SERVICE_UNIT_MAP")){
                break;
            }
            
            VRMap unitMap = (VRMap)serviceCode.get("SERVICE_UNIT_MAP");
            Iterator it = unitMap.keySet().iterator();
            String key = "";
            String offer = VRDateParser.format(ACCastUtilities.toDate(targetServiceDate), "yyyyMMdd");
            
            //特別地域加算の単位数、回数を退避する。
            //レコード確定時に一括集計
            while(it.hasNext()){
                key = String.valueOf(it.next());
                VRMap map = null;
                Integer times = null;
                Set<String> offerDay = null;
                
                //登録済みのサービスの場合
                if(serviceUnitMap.containsKey(key)){
                    map = (VRMap)serviceUnitMap.get(key);
                    times = (Integer)map.get("TIMES");
                    offerDay = (Set)map.get("OFFER");
                } else {
                    map = new VRHashMap();
                    map.put("UNIT",unitMap.get(key));
                    serviceUnitMap.put(key,map);
                    times = new Integer(0);
                    offerDay = new HashSet<String>();
                }
                
                //グループ化フラグを参照
                //日単位
                if (key.endsWith("2")) {
                    //既に提供済であればスキップ
                    if (offerDay.contains(offer)) {
                        continue;
                    }
                    
                //月単位
                } else if (key.endsWith("3")) {
                    //既に提供済であればスキップ
                    if (!offerDay.isEmpty()) {
                        continue;
                    }
                }
                
                //提供日を設定
                offerDay.add(offer);
                times = new Integer(times.intValue() + 1);
                map.put("TIMES",times);
                map.put("OFFER",offerDay);
            }
            break;
        //中山間地域加算対応
        case 6:
            //[ID:0000682][Shin Fujihara] add begin 【法改正対応】介護職員処遇改善加算
            serviceUnit = ACCastUtilities.toInt(serviceCode.get("SERVICE_UNIT"), 0);
            //[ID:0000682][Shin Fujihara] add end 【法改正対応】介護職員処遇改善加算
        	mountainousAreaAdder.parse(serviceCode, targetServiceDate);
        	break;
        	
        //[ID:0000682][Shin Fujihara] add begin 【法改正対応】介護職員処遇改善加算
        //処遇改善
        case 8:
            //割合を退避
            serviceUnit = ACCastUtilities.toInt(serviceCode.get("SERVICE_UNIT"), 0);
            serviceStaffUnit = ACCastUtilities.toInt(serviceCode.get("SERVICE_STAFF_UNIT"), 0);
            break;
        //[ID:0000682][Shin Fujihara] add end 【法改正対応】介護職員処遇改善加算        	
        }
        //[ID:0000467][Shin Fujihara] 2009/04 edit end 平成21年4月法改正対応
        
        
        // 公費順位の登録を行う。
        kohiManager.setExtraData(targetServiceDate,serviceDetail, patientState, serviceCode,
                "1", get_301009(),manager.getProviderMedicalFlag(get_301004()),serviceCount,manager);

    }

    //データ設定の可否を判定する。
    private boolean isSetData(Object targetServiceDate,VRMap serviceCode) throws Exception {
        
        boolean result = true;
        
        //新規作成レコードであれば集計を許可する。
        if(isNew()){
            totalGroupintType = ACCastUtilities.toInt(serviceCode.get("TOTAL_GROUPING_TYPE"),0); 
            return result;
        }
        
        //特別地域加算、中山間地域加算であれば、一律ture
        switch(ACCastUtilities.toInt(serviceCode.get("SERVICE_ADD_FLAG"),0)) {
        case 3: //特別地域加算
        case 6: //中山間地域加算
            return result;
        }
        
        //算定モードの確認
        switch(totalGroupintType){
            //1-回数単位
            case 1:
                break;
            //2-日単位
            case 2:
                //既に計上していれば、レコードの作成を行わない。
            	//edit start fujihara.shin 2008.6.23 自動日割り展開対応
            	/*
                if(kohiManager.getRealDays().contains(targetServiceDate)){
                    result = false;
                }
                */
                if(kohiManager.getOfferDays().contains(targetServiceDate)){
                    result = false;
                }
                //edit end fujihara.shin 2008.6.23
                break;
            //3-月単位
            case 3:
                //サービスコードの確認
                //訪問看護、緊急時訪問看護加算、特別管理加算であるか確認
                switch(ACCastUtilities.toInt(serviceCode.get("SERVICE_CODE_KIND"),0)){
                //訪問看護
                case 13:
                //介護予防訪問看護
                case 63:
                	//サービス項目コードの確認
                	switch(ACCastUtilities.toInt(serviceCode.get("SERVICE_CODE_ITEM"),0)){
                	//緊急時訪問看護加算１
                	case 3100:
                	//緊急時訪問看護加算２
                	case 3200:
                	//特別管理加算
                	case 4000:
                        //設定ファイルの値を確認する。
                        if(ACFrame.getInstance().hasProperty("PrintConfig/OncePerMonth")){
                        	if(ACCastUtilities.toInt(ACFrame.getInstance().getProperty("PrintConfig/OncePerMonth"),1) == 0){
                        		result = true;
                        		return result;
                        	}
                        }
                		break;
                	}
                	break;
                
                }
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
        serial.append(get_301001());
        // レコード種別コード2桁(02固定)
        serial.append(get_301002());
        // サービス提供年月6桁(YYYYMM)
        serial.append(get_301003());
        // 事業所番号10桁
        serial.append(get_301004());
        // 証記載保険者番号8桁
        serial.append(get_301005());
        // 被保険者番号10桁
        serial.append(get_301006());
        // システム内サービス種類コード
        serial.append(get_301021());
        // システム内サービス項目コード
        serial.append(get_301022());
        
//        //福祉用具対応
//        serial.append(get_301009());
//        serial.append(get_301018());
        
        return serial.toString();
    }
    
    protected static QP001RecordDetail getInstance(String identificationNo,
            Date targetDate, Object targetServiceDate, VRMap serviceDetail,
            VRMap serviceCode, QP001PatientState patientState,VRMap detailMap,QP001Manager manager) throws Exception {
        
        QP001RecordDetail detail = null;
        
        //レコードの作成可否を判断
        //2008/09/03 [Shin Fujihara] edit - begin 30日超の単位数をPatientStateに保持するよう変更
        //if(!isMakeRecord(serviceDetail,serviceCode)){
        if(!isMakeRecord(serviceDetail,serviceCode, patientState)){
        //2008/09/03 [Shin Fujihara] edit - end 30日超の単位数をPatientStateに保持するよう変更
            return detail;
        }
        
        String serial = getSerialId(identificationNo,
                                    targetDate,
                                    targetServiceDate,
                                    serviceDetail,
                                    serviceCode,
                                    patientState,
                                    manager);
        
        //条件に合致するレコードが存在しない場合
        if(!detailMap.containsKey(serial)){
            detail = new QP001RecordDetail();
            detailMap.put(serial,detail);
        //条件に合致するレコードが存在する場合
        } else {
            detail = (QP001RecordDetail)detailMap.get(serial);
        }
        
        return detail;
    }
    
    //2008/09/03 [Shin Fujihara] edit - begin 30日超の単位数をPatientStateに保持するよう変更
    //private static boolean isMakeRecord(VRMap serviceDetail,VRMap serviceCode) throws Exception {
    private static boolean isMakeRecord(VRMap serviceDetail,VRMap serviceCode, QP001PatientState patientState) throws Exception {
    //2008/09/03 [Shin Fujihara] edit - end 30日超の単位数をPatientStateに保持するよう変更
        
        //給付管理限度額対象フラグを確認する。
        //フラグが0(食費等、単位数で管理しないサービス)の場合は、レコードの作成を中断する。
        if(String.valueOf(serviceCode.get("LIMIT_AMOUNT_OBJECT")).equals("0")){
            return false;
        }
        //30日超であればレコードの作成を中断する。
        if(ACCastUtilities.toInt(serviceDetail.get("5"),0) == 2){
        	//2008/09/03 [Shin Fujihara] add - begin 30日超の単位数をPatientStateに保持するよう変更
        	patientState.putAbandonedUnit(serviceDetail, serviceCode);
        	//2008/09/03 [Shin Fujihara] add - end 30日超の単位数をPatientStateに保持するよう変更
            return false;
        }
        return true;
    }
    
    private static String getSerialId(String identificationNo,
            Date targetDate, Object targetServiceDate, VRMap serviceDetail,
            VRMap serviceCode, QP001PatientState patientState,QP001Manager manager) throws Exception {
        //レコードのシリアルIDを作成
        StringBuilder serial = new StringBuilder();
        // 交換識別番号
        serial.append(identificationNo);
        // レコード種別コード2桁(02固定)
        serial.append(_301002);
        // サービス提供年月6桁(YYYYMM)
        serial.append(VRDateParser.format(targetDate, "yyyyMM"));
        // 事業所番号10桁
        serial.append(serviceDetail.get("PROVIDER_ID"));
        // 証記載保険者番号8桁
        serial.append(patientState.getInsurerId(targetServiceDate));
        // 被保険者番号10桁
        serial.append(patientState.getInsuredId(targetServiceDate));
        // システム内サービス種類コード
        serial.append(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL"));
        //サービス種類コード
        serial.append(serviceCode.get("SERVICE_CODE_KIND"));
        //サービス項目コード
        serial.append(serviceCode.get("SERVICE_CODE_ITEM"));
        
        //福祉用具対応
        if(ACCastUtilities.toInt(serviceCode.get("SERVICE_ADD_FLAG"),0) != 3){
            //serial.append(QP001Manager.getInstance().getServiceUnit(String.valueOf(serviceDetail.get("PROVIDER_ID")),serviceCode));
            serial.append(manager.getServiceUnit(String.valueOf(serviceDetail.get("PROVIDER_ID")),serviceCode));
        } else {
            serial.append(ACCastUtilities.toInt(serviceCode.get("SERVICE_UNIT"),0));
        }
        
        serial.append(QP001SpecialCase.getDetailSerial(serviceDetail,serviceCode));
        
        
//        // サービス種類コード
//        String serviceCodeKind = ACCastUtilities.toString(VRBindPathParser.get("SERVICE_CODE_KIND", serviceCode),"");
//        //システム内サービス項目コード
//        String systemServiceCodeItem = ACCastUtilities.toString(VRBindPathParser.get("SYSTEM_SERVICE_CODE_ITEM", serviceCode),"");
//        
//        //福祉用具の適用設定
//        if("17".equals(serviceCodeKind) || "67".equals(serviceCodeKind)){
//	        if(serviceDetail.containsKey("1170104")){
//	            //システム内サービス種類コードが2から始まっている場合は、
//	            //特別地域加算のレコード
//	            if(!systemServiceCodeItem.startsWith("2")){
//	                //画面上の福祉用具摘要欄に入力がある場合
//	                if(!ACTextUtilities.isNullText(serviceDetail.get("1170104"))){
//	                    //摘要欄に福祉用具の摘要欄に入力された値を入力する。
//	                	serial.append(ACCastUtilities.toString(serviceDetail.get("1170104")));
//	                }
//	            }
//	        }
//        }
//        
//        /*
//         * ■特定施設入居者生活介護、介護予防特定施設入居者生活介護
//         * ・外部サービス利用型における福祉用具貸与、介護予防福祉用具貸与
//         * 【プログラム中の解釈】
//         * 画面上に入力された値を参照
//         */
//        //サービス種類コードが33であり
//        if("33".equals(serviceCodeKind)){
//            //システム内サービス種類コードが27から始まり
//            if(systemServiceCodeItem.startsWith("27")){
//                //摘要欄に入力されている項目がある場合
//                if(serviceDetail.containsKey("1330120")){
//                    //摘要欄に外部利用福祉用具の摘要欄に入力された値を設定する。
//                	serial.append(ACCastUtilities.toString(serviceDetail.get("1330120")));
//                }
//            }
//        }
//        
//        //サービス種類コードが35であり
//        if("35".equals(serviceCodeKind)){
//            //システム内サービス種類コードが27から始まり
//            if(systemServiceCodeItem.startsWith("27")){
//                //摘要欄に入力されている項目がある場合
//                if(serviceDetail.containsKey("1170104")){
//                    //摘要欄に外部利用福祉用具の摘要欄に入力された値を設定する。
//                	serial.append(ACCastUtilities.toString(serviceDetail.get("1170104")));
//                }
//            }
//        }
        
        return serial.toString();
    }

    /**
     * レコード内容の確定を行う。
     */
    protected void commitRecord(String[] kohi, QP001PatientState patientState) throws Exception {
        
        //摘要欄の内容を確定
        set_301018(recapitulation.getRecapitulation(getRealDays(),patientState));
        
        //特別地域加算レコードの処理
        if(serviceUnitMap.size() > 0){
            int specialUnit = 0;
            int ratio = get_301009();
            
            Iterator it = serviceUnitMap.keySet().iterator();
            while(it.hasNext()){
                String key = String.valueOf(it.next());
                //単位数-回数
                VRMap map = (VRMap)serviceUnitMap.get(key);
                Integer unit = (Integer)map.get("UNIT");
                Integer times = (Integer)map.get("TIMES");
                
                //四捨五入
                //合算を四捨五入するよう変更
                //specialUnit += (int)Math.round((double)(unit.intValue() * times.intValue() * ratio) / 100d);
                specialUnit += unit.intValue() * times.intValue();
            }
            
            //set_301009(specialUnit);
            set_301009((int)Math.round((double)(specialUnit * ratio) / 100d));
            set_301010(1);
            
            kohiManager.replaceCalcRate(specialUnit);
            
            //[ID:0000730][Shin Fujihara] add begin  【サービス利用票別表・実績集計】自己負担発生時の％系加算の計算について
            //根拠となる単位数を退避
            setAdditionBasisUnit(specialUnit);
            //[ID:0000730][Shin Fujihara] add end   
        }
        
        //[ID:0000467][Shin Fujihara] 2009/04 add begin 平成21年4月法改正対応
        if (mountainousAreaAdder.hasData()){
        	int specialUnit = mountainousAreaAdder.getUnit();
            set_301009((int)Math.round((double)(specialUnit * get_301009()) / 100d));
            set_301010(1);
            kohiManager.replaceCalcRate(specialUnit);
            
            //[ID:0000730][Shin Fujihara] add begin  【サービス利用票別表・実績集計】自己負担発生時の％系加算の計算について
            //根拠となる単位数を退避
            setAdditionBasisUnit(specialUnit);
            //[ID:0000730][Shin Fujihara] add end
        }
        //[ID:0000467][Shin Fujihara] 2009/04 add end 平成21年4月法改正対応
        
        //公費の給付率が100%になったかの判定フラグ
        boolean kohiLimit = false; 
        
        // サービス単位数
        set_301014(get_301009() * get_301010());
        
        // 公費１の適用があるか確認
        if ((kohi[0] != null) && (!"".equals(kohi[0]))) {
            // 適用がある場合
            // 公費1対象日数・回数2桁を設定する。
            set_301011(kohiManager.getKohiCount(kohi[0]));
            
            //特別地域加算対応により、回数が変更された場合を考慮して公費摘要回数との比較を行なう
            if(get_301010() < get_301011()){
                set_301011(get_301010());
            }
            
            // 公費1対象サービス単位数6桁(単位数*公費１適用回数)
            set_301015(get_301009() * get_301011());
            // 公費1公費タイプ
            set_301023(kohi[0]);
            // 給付率が100%になったら処理を終了する。
            if(ACCastUtilities.toInt(patientState.getKohiData(kohi[0],"BENEFIT_RATE",1)) == 100){
                //公費１で全単位数でまかなえれば公費計算を終了
                if(get_301014() <= get_301015()){
                    kohiLimit = true;
                }
            }
            
        }
        // 公費２の適用があるか確認
        if ((!kohiLimit) && (kohi[1] != null) && (!"".equals(kohi[1]))) {
            // 適用がある場合
            // 公費2対象日数・回数2桁を設定する。
            set_301012(kohiManager.getKohiCount(kohi[1]));
            
            //特別地域加算対応により、回数が変更された場合を考慮して公費摘要回数との比較を行なう
            if(get_301010() < get_301012()){
                set_301012(get_301010());
            }
            
            // 公費2対象サービス単位数6桁(単位数*公費２適用回数)
            set_301016(get_301009() * get_301012());
            // 公費2公費タイプ
            set_301024(kohi[1]);
            // 給付率が100%になったら処理を終了する。
            if(ACCastUtilities.toInt(patientState.getKohiData(kohi[1],"BENEFIT_RATE",1)) == 100){
                //公費２で全単位数でまかなえれば公費計算を終了
                if(get_301014() <= get_301016()){
                    kohiLimit = true;
                }
            }
        }
        // 公費３の適用があるか確認
        if ((!kohiLimit) && (kohi[2] != null) && (!"".equals(kohi[2]))) {
            // 適用がある場合
            // 公費3対象日数・回数2桁を設定する。
            set_301013(kohiManager.getKohiCount(kohi[2]));
            
            //特別地域加算対応により、回数が変更された場合を考慮して公費摘要回数との比較を行なう
            if(get_301010() < get_301013()){
                set_301013(get_301010());
            }
            
            // 公費3対象サービス単位数6桁(単位数*公費３適用回数)
            set_301017(get_301009() * get_301013());
            // 公費3公費タイプ
            set_301025(kohi[2]);
            // 給付率が100%になったら処理を終了する。
//            if (ACCastUtilities.toInt(patientState.getKohiData(kohi[0],"BENEFIT_RATE",2)) == 100)
//                return;
        }
        
        //加算であれば処理を終了する。
        if(serviceUnitMap.size() > 0){
            return;
        }
        
        //特定のサービスのみ単位数を0回に変更する。
        if(QP001SpecialCase.isUnitNoCountService(get_301007(),get_301008())){
            //単位数を0回に変更
            set_301009(0);
        }
        if(QP001SpecialCase.isMaxCountService(get_301007(),get_301008())){
            int count = ACDateUtilities.getLastDayOfMonth(ACCastUtilities.toDate(get_301003() + "01"));
            //回数は当月の日数に変更
            set_301010(count);
            //公費回数も変更
            if(get_301011() > 0){
                set_301011(count);
            }
            if(get_301012() > 0){
                set_301012(count);
            }
            if(get_301013() > 0){
                set_301013(count);
            }
        }
        
        //小規模多機能型の例外
        //月単位集計で加算・減算系以外で回数を1回とするサービスであるか。
        if(QP001SpecialCase.isSingleCountService(get_301007(),get_301008())){
            //回数を1回に変更
            set_301010(1);
            //公費回数も変更
            if(get_301011() > 0){
                set_301011(1);
            }
            if(get_301012() > 0){
                set_301012(1);
            }
            if(get_301013() > 0){
                set_301013(1);
            }
        }
        
    }

    /**
     * 公費リストを取得する。
     * @return
     */
    protected VRMap getKohiList() {
        return this.kohiManager.getKohiList();
    }
    /**
     * サービス実日数リストを取得する。
     * @return
     */
    protected VRList getRealDays() {
        return this.kohiManager.getRealDays();
    }
    /**
     * 入院(入所)実日数リストを取得する。
     * @return
     */
    protected VRList getHospitalizationDays(){
        return this.kohiManager.getHospitalizationDays();
    }
    /**
     * 退院(退所)実日数リストを取得する。
     * @return
     */
    protected VRList getLeavingHospitalDays(){
        return this.kohiManager.getLeavingHospitalDays();
    }
    /**
     * 公費のパタンを取得する。
     * @return
     */
    protected VRMap getKohiPattern() {
        return this.kohiManager.getKohiPattern();
    }

    /**
     * データ作成
     * 
     * @param style
     * @return
     */
    protected VRMap getRecord(VRMap style) throws Exception {
        VRMap result = copyStyle(style);

        // 交換情報識別番号4桁
        setData(result, "301001", get_301001());
        // レコード種別コード2桁(02を設定)
        setData(result, "301002", get_301002());
        // サービス提供年月6桁(YYYYMM)
        setData(result, "301003", get_301003());
        // 事業所番号10桁
        setData(result, "301004", get_301004());
        // 証記載保険者番号8桁
        setData(result, "301005", get_301005());
        // 被保険者番号10桁
        setData(result, "301006", get_301006());
        // サービス種類コード2桁
        setData(result, "301007", get_301007());
        // サービス項目コード4桁
        setData(result, "301008", get_301008());
        // 単位数4桁
        setData(result, "301009", get_301009());

        //日数･回数2桁
        setData(result, "301010", get_301010());
        //公費1対象日数・回数2桁
        setData(result, "301011", get_301011());
        //公費2対象日数・回数2桁
        setData(result, "301012", get_301012());
        //公費3対象日数・回数2桁
        setData(result, "301013", get_301013());
        //サービス単位数6桁
        setData(result, "301014", get_301014());
        //公費1対象サービス単位数6桁
        setData(result, "301015", get_301015());
        //公費2対象サービス単位数6桁
        setData(result, "301016", get_301016());
        //公費3対象サービス単位数6桁
        setData(result, "301017", get_301017());
        //摘要20桁
        setData(result, "301018", get_301018());
        //サービス名称(サービスコードマスタTBLのSERVICE_NAME)
        setData(result, "301019", get_301019());

        //限度額管理対象フラグ
        setData(result, "301020", get_301020());
		//システム内サービス種類コード(SYSTEM_SERVICE_KIND_DETAIL)
		setData(result,"301021",get_301021());
		//システム内サービス項目コード(SYSTEM_SERVICE_CODE_ITEM)
		setData(result,"301022",get_301022());

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
        //明細情報レコード
        //result.put("CATEGORY_NO", "3");
        result.put("CATEGORY_NO", QkanConstants.CATEGORY_NO_RECORD_DETAILED);
        return result;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[301001=" + get_301001() + "]\n");
        result.append("[301002=" + get_301002() + "]\n");
        result.append("[301003=" + get_301003() + "]\n");
        result.append("[301004=" + get_301004() + "]\n");
        result.append("[301005=" + get_301005() + "]\n");
        result.append("[301006=" + get_301006() + "]\n");
        result.append("[301007=" + get_301007() + "]\n");
        result.append("[301008=" + get_301008() + "]\n");
        result.append("[301009=" + get_301009() + "]\n");
        result.append("[301010=" + get_301010() + "]\n");
        result.append("[301011=" + get_301011() + "]\n");
        result.append("[301012=" + get_301012() + "]\n");
        result.append("[301013=" + get_301013() + "]\n");
        result.append("[301014=" + get_301014() + "]\n");
        result.append("[301015=" + get_301015() + "]\n");
        result.append("[301016=" + get_301016() + "]\n");
        result.append("[301017=" + get_301017() + "]\n");
        result.append("[301018=" + get_301018() + "]\n");
        result.append("[301019=" + get_301019() + "]\n");
        result.append("[301020=" + get_301020() + "]\n");
        result.append("[301021=" + get_301021() + "]\n");
        result.append("[301022=" + get_301022() + "]\n");
        result.append("[301023=" + get_301023() + "]\n");
        result.append("[301024=" + get_301024() + "]\n");
        result.append("[301025=" + get_301025() + "]\n");
        result.append(kohiManager);
        return result.toString();
    }
}
