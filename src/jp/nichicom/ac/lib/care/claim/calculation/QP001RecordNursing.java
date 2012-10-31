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
 * プログラム 特定入所者介護サービス費用情報レコード (QP001RecordNursing)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Date;
import java.util.Iterator;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

/**
 * 特定入所者介護サービス費用情報レコード
 * 
 */
public class QP001RecordNursing extends QP001RecordAbstract {

    // 交換情報識別番号4桁
    private String _801001 = "";

    // レコード種別コード2桁(11を設定)
    private static final String _801002 = "11";

    // サービス提供年月6桁(YYYYMM)
    private String _801003 = "";

    // 事業所番号10桁
    private String _801004 = "";

    // 証記載保険者番号8桁
    private String _801005 = "";

    // 被保険者番号10桁
    private String _801006 = "";

    // 特定入所者介護サービス費用情報レコード順次番号2桁
    private int _801007 = 0;

    // サービス種類コード2桁
    private String _801008 = "";

    // サービス項目コード4桁
    private String _801009 = "";

    // 費用単価4桁
    private int _801010 = 0;

    // 負担限度額4桁
    private int _801011 = 0;

    // 日数2桁
    private int _801012 = 0;

    // 公費1日数2桁
    private int _801013 = 0;

    // 公費2日数2桁
    private int _801014 = 0;

    // 公費3日数2桁
    private int _801015 = 0;

    // 費用額6桁
    private int _801016 = 0;

    // 保険分請求額6桁
    private int _801017 = 0;

    // 公費1負担額(明細)6桁
    private int _801018 = 0;

    // 公費2負担額(明細)6桁
    private int _801019 = 0;

    // 公費3負担額(明細)6桁
    private int _801020 = 0;

    // 利用者負担額5桁
    private int _801021 = 0;

    // 費用額合計6桁
    private int _801022 = 0;

    // 保険分請求額合計6桁
    private int _801023 = 0;

    // 利用者負担額合計6桁
    private int _801024 = 0;

    // (公費1)負担額合計6桁
    private int _801025 = 0;

    // (公費1)請求額6桁
    private int _801026 = 0;

    // (公費1)本人負担額5桁
    private int _801027 = 0;

    // (公費2)負担額合計6桁
    private int _801028 = 0;

    // (公費2)請求額6桁
    private int _801029 = 0;

    // (公費2)本人負担額5桁
    private int _801030 = 0;

    // (公費3)負担額合計6桁
    private int _801031 = 0;

    // (公費3)請求額6桁
    private int _801032 = 0;

    // (公費3)本人負担額5桁
    private int _801033 = 0;

    // サービス名称(サービスコードマスタTBLのSERVICE_NAME)
    private String _801034 = "";

    // システム内サービス種類コード(SYSTEM_SERVICE_KIND_DETAIL)
    private String _801035 = "";

    // システム内サービス項目コード(SYSTEM_SERVICE_CODE_ITEM)
    private String _801036 = "";
    
    // 提供サービス区分 1-食費 2-ユニット型個室 3-ユニット型準個室 4-従来型個室(特養等) 5-従来型個室(老健・療養等) 6-多床室
    private int _801037 = 0;

    // 公費順位決定オブジェクト
    private QP001RecordSupporter kohiManager = new QP001RecordSupporter();

    protected String getSerialId() {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }

    /**
     * レコード種別コード2桁(11を設定)を取得する。
     * 
     * @return
     */
    protected static String get_801002() {
        return _801002;
    }

    /**
     * 交換情報識別番号4桁を取得する。
     * 
     * @return
     */
    protected String get_801001() {
        return _801001;
    }

    /**
     * 交換情報識別番号4桁を設定する。
     * 
     * @param _801001
     */
    protected void set_801001(String _801001) {
        this._801001 = _801001;
    }

    /**
     * サービス提供年月6桁(YYYYMM)を取得する。
     * 
     * @return
     */
    protected String get_801003() {
        return _801003;
    }

    /**
     * サービス提供年月6桁(YYYYMM)を設定する。
     * 
     * @param _801003
     */
    protected void set_801003(String _801003) {
        this._801003 = _801003;
    }

    /**
     * 事業所番号10桁を取得する。
     * 
     * @return
     */
    protected String get_801004() {
        return _801004;
    }

    /**
     * 事業所番号10桁を設定する。
     * 
     * @param _801004
     */
    protected void set_801004(String _801004) {
        this._801004 = _801004;
    }

    /**
     * 証記載保険者番号8桁を取得する。
     * 
     * @return
     */
    protected String get_801005() {
        return _801005;
    }

    /**
     * 証記載保険者番号8桁を設定する。
     * 
     * @param _801005
     */
    protected void set_801005(String _801005) {
        this._801005 = _801005;
    }

    /**
     * 被保険者番号10桁を取得する。
     * 
     * @return
     */
    protected String get_801006() {
        return _801006;
    }

    /**
     * 被保険者番号10桁を設定する。
     * 
     * @param _801006
     */
    protected void set_801006(String _801006) {
        this._801006 = _801006;
    }

    /**
     * 特定入所者介護サービス費用情報レコード順次番号2桁を取得する。
     * 
     * @return
     */
    protected int get_801007() {
        return _801007;
    }

    /**
     * 特定入所者介護サービス費用情報レコード順次番号2桁を設定する。
     * 
     * @param _801007
     */
    protected void set_801007(int _801007) {
        this._801007 = _801007;
    }

    /**
     * サービス種類コード2桁を取得する。
     * 
     * @return
     */
    protected String get_801008() {
        return _801008;
    }

    /**
     * サービス種類コード2桁を設定する。
     * 
     * @param _801008
     */
    protected void set_801008(String _801008) {
        this._801008 = _801008;
    }

    /**
     * サービス項目コード4桁
     * 
     * @return
     */
    protected String get_801009() {
        return _801009;
    }

    /**
     * サービス項目コード4桁を設定する。
     * 
     * @param _801009
     */
    protected void set_801009(String _801009) {
        this._801009 = _801009;
    }

    /**
     * 費用単価4桁を取得する。
     * 
     * @return
     */
    protected int get_801010() {
        return _801010;
    }

    /**
     * 費用単価4桁を設定する。
     * 
     * @param _801010
     */
    protected void set_801010(int _801010) {
        this._801010 = _801010;
    }

    /**
     * 負担限度額4桁を取得する。
     * 
     * @return
     */
    protected int get_801011() {
        return _801011;
    }

    /**
     * 負担限度額4桁を設定する。
     * 
     * @param _801011
     */
    protected void set_801011(int _801011) {
        this._801011 = _801011;
    }

    /**
     * 日数2桁を取得する。
     * 
     * @return
     */
    protected int get_801012() {
        return _801012;
    }

    /**
     * 日数2桁を設定する。
     */
    protected void set_801012(int _801012) {
        this._801012 = _801012;
    }

    /**
     * 公費1日数2桁を取得する。
     * 
     * @return
     */
    protected int get_801013() {
        return _801013;
    }

    /**
     * 公費1日数2桁を設定する。
     * 
     * @param _801013
     */
    protected void set_801013(int _801013) {
        this._801013 = _801013;
    }

    /**
     * 公費2日数2桁を取得する。
     * 
     * @return
     */
    protected int get_801014() {
        return _801014;
    }

    /**
     * 公費2日数2桁を設定する。
     * 
     * @param _801014
     */
    protected void set_801014(int _801014) {
        this._801014 = _801014;
    }

    /**
     * 公費3日数2桁を取得する。
     * 
     * @return
     */
    protected int get_801015() {
        return _801015;
    }

    /**
     * 公費3日数2桁を設定する。
     * 
     * @param _801015
     */
    protected void set_801015(int _801015) {
        this._801015 = _801015;
    }

    /**
     * 費用額6桁を取得する。
     * 
     * @return
     */
    protected int get_801016() {
        return _801016;
    }

    /**
     * 費用額6桁を設定する。
     * 
     * @param _801016
     */
    protected void set_801016(int _801016) {
        this._801016 = _801016;
    }

    /**
     * 保険分請求額6桁を取得する。
     * 
     * @return
     */
    protected int get_801017() {
        return _801017;
    }

    /**
     * 保険分請求額6桁を設定する。
     * 
     * @param _801017
     */
    protected void set_801017(int _801017) {
        this._801017 = _801017;
    }

    /**
     * 公費1負担額(明細)6桁を取得する。
     * 
     * @return
     */
    protected int get_801018() {
        return _801018;
    }

    /**
     * 公費1負担額(明細)6桁を設定する。
     * 
     * @param _801018
     */
    protected void set_801018(int _801018) {
        this._801018 = _801018;
    }

    /**
     * 公費2負担額(明細)6桁を取得する。
     * 
     * @return
     */
    protected int get_801019() {
        return _801019;
    }

    /**
     * 公費2負担額(明細)6桁を設定する。
     * 
     * @param _801019
     */
    protected void set_801019(int _801019) {
        this._801019 = _801019;
    }

    /**
     * 公費3負担額(明細)6桁を取得する。
     * 
     * @return
     */
    protected int get_801020() {
        return _801020;
    }

    /**
     * 公費3負担額(明細)6桁を設定する。
     * 
     * @param _801020
     */
    protected void set_801020(int _801020) {
        this._801020 = _801020;
    }

    /**
     * 利用者負担額5桁を取得する。
     * 
     * @return
     */
    protected int get_801021() {
        return _801021;
    }

    /**
     * 利用者負担額5桁を設定する。
     * 
     * @param _801021
     */
    protected void set_801021(int _801021) {
        this._801021 = _801021;
    }

    /**
     * 費用額合計6桁を取得する。
     * 
     * @return
     */
    protected int get_801022() {
        return _801022;
    }

    /**
     * 費用額合計6桁を設定する。
     * 
     * @param _801022
     */
    protected void set_801022(int _801022) {
        this._801022 = _801022;
    }

    /**
     * 保険分請求額合計6桁を取得する。
     * 
     * @return
     */
    protected int get_801023() {
        return _801023;
    }

    /**
     * 保険分請求額合計6桁を設定する。
     * 
     * @param _801023
     */
    protected void set_801023(int _801023) {
        this._801023 = _801023;
    }

    /**
     * 利用者負担額合計6桁を取得する。
     * 
     * @return
     */
    protected int get_801024() {
        return _801024;
    }

    /**
     * 利用者負担額合計6桁を設定する。
     * 
     * @param _801024
     */
    protected void set_801024(int _801024) {
        this._801024 = _801024;
    }

    /**
     * (公費1)負担額合計6桁を取得する。
     * 
     * @return
     */
    protected int get_801025() {
        return _801025;
    }

    /**
     * (公費1)負担額合計6桁を設定する。
     * 
     * @param _801025
     */
    protected void set_801025(int _801025) {
        this._801025 = _801025;
    }

    /**
     * (公費1)請求額6桁を取得する。
     * 
     * @return
     */
    protected int get_801026() {
        return _801026;
    }

    /**
     * (公費1)請求額6桁を設定する。
     * 
     * @param _801026
     */
    protected void set_801026(int _801026) {
        this._801026 = _801026;
    }

    /**
     * (公費1)本人負担額5桁を取得する。
     * 
     * @return
     */
    protected int get_801027() {
        return _801027;
    }

    /**
     * (公費1)本人負担額5桁を設定する。
     * 
     * @param _801027
     */
    protected void set_801027(int _801027) {
        this._801027 = _801027;
    }

    /**
     * (公費2)負担額合計6桁を取得する。
     * 
     * @return
     */
    protected int get_801028() {
        return _801028;
    }

    /**
     * (公費2)負担額合計6桁を設定する。
     * 
     * @param _801028
     */
    protected void set_801028(int _801028) {
        this._801028 = _801028;
    }

    /**
     * (公費2)請求額6桁を取得する。
     * 
     * @return
     */
    protected int get_801029() {
        return _801029;
    }

    /**
     * (公費2)請求額6桁を設定する。
     * 
     * @param _801029
     */
    protected void set_801029(int _801029) {
        this._801029 = _801029;
    }

    /**
     * (公費2)本人負担額5桁を取得する。
     * 
     * @return
     */
    protected int get_801030() {
        return _801030;
    }

    /**
     * (公費2)本人負担額5桁を設定する。
     * 
     * @param _801030
     */
    protected void set_801030(int _801030) {
        this._801030 = _801030;
    }

    /**
     * (公費3)負担額合計6桁を取得する。
     * 
     * @return
     */
    protected int get_801031() {
        return _801031;
    }

    /**
     * (公費3)負担額合計6桁を設定する。
     * 
     * @param _801031
     */
    protected void set_801031(int _801031) {
        this._801031 = _801031;
    }

    /**
     * (公費3)請求額6桁を取得する。
     * 
     * @return
     */
    protected int get_801032() {
        return _801032;
    }

    /**
     * (公費3)請求額6桁を設定する。
     * 
     * @param _801032
     */
    protected void set_801032(int _801032) {
        this._801032 = _801032;
    }

    /**
     * (公費3)本人負担額5桁を取得する。
     * 
     * @return
     */
    protected int get_801033() {
        return _801033;
    }

    /**
     * (公費3)本人負担額5桁を設定する。
     * 
     * @param _801033
     */
    protected void set_801033(int _801033) {
        this._801033 = _801033;
    }

    /**
     * サービス名称(サービスコードマスタTBLのSERVICE_NAME)を取得する。
     * 
     * @return
     */
    protected String get_801034() {
        return _801034;
    }

    /**
     * サービス名称(サービスコードマスタTBLのSERVICE_NAME)を設定する。
     * 
     * @param _801034
     */
    protected void set_801034(String _801034) {
        this._801034 = _801034;
    }

    /**
     * システム内サービス種類コード(SYSTEM_SERVICE_KIND_DETAIL)を取得する。
     * 
     * @return
     */
    protected String get_801035() {
        return _801035;
    }

    /**
     * システム内サービス種類コード(SYSTEM_SERVICE_KIND_DETAIL)を設定する。
     * 
     * @param _801035
     */
    protected void set_801035(String _801035) {
        this._801035 = _801035;
    }

    /**
     * システム内サービス項目コード(SYSTEM_SERVICE_CODE_ITEM)を取得する。
     * 
     * @return
     */
    protected String get_801036() {
        return _801036;
    }

    /**
     * システム内サービス項目コード(SYSTEM_SERVICE_CODE_ITEM)を設定する。
     * 
     * @param _801036
     */
    protected void set_801036(String _801036) {
        this._801036 = _801036;
    }

    /**
     * 提供サービス区分を取得する。
     * 1-食費 2-ユニット型個室 3-ユニット型準個室 4-従来型個室(特養等) 5-従来型個室(老健・療養等) 6-多床室
     * 
     * @return
     */
    protected int get_801037() {
        return _801037;
    }

    /**
     * 提供サービス区分を設定する。
     * 1-食費 2-ユニット型個室 3-ユニット型準個室 4-従来型個室(特養等) 5-従来型個室(老健・療養等) 6-多床室
     * 
     * @param _801037
     */
    protected void set_801037(int _801037) {
        this._801037 = _801037;
    }
    
    
    protected static QP001RecordNursing getInstance(String identificationNo,
            Date targetDate, Object targetServiceDate, VRMap serviceDetail,
            VRMap serviceCode, QP001PatientState patientState,VRMap nursingMap,QP001Manager manager) throws Exception {
        
        QP001RecordNursing nursing = null;
        
        //レコードの作成可否を判断
        if(!isMakeRecord(identificationNo,serviceCode,patientState,targetServiceDate,serviceDetail)){
            return nursing;
        }
        
        String serial = getSerialId(identificationNo,
                                    targetDate,
                                    targetServiceDate,
                                    serviceDetail,
                                    serviceCode,
                                    patientState,
                                    manager);
        
        //条件に合致するレコードが存在しない場合
        if(!nursingMap.containsKey(serial)){
            nursing = new QP001RecordNursing();
            nursingMap.put(serial,nursing);
        //条件に合致するレコードが存在する場合
        } else {
            nursing = (QP001RecordNursing)nursingMap.get(serial);
        }
        
        return nursing;
    }
    
    /**
     * レコード作成の可否を判断する。
     * @param identificationNo
     * @param serviceCode
     * @param patientState
     * @param targetServiceDate
     * @return
     * @throws Exception
     */
    protected static boolean isMakeRecord(String identificationNo,VRMap serviceCode,QP001PatientState patientState,Object targetServiceDate,VRMap serviceDetail) throws Exception {
        String shotokuDankai = patientState.getShisetsuData("TOKUTEI_NYUSHO_FLAG");
        // patient の 所得段階が選択されていない場合、処理を行わない。
        if (("".equals(shotokuDankai)) || ("0".equals(shotokuDankai))) {
            return false;
        }
        // サービス種類コードが59(特定入所者介護サービス等)で無い場合、処理を行わない。
        if (!"59".equals(ACCastUtilities.toString(VRBindPathParser.get(
                "SERVICE_CODE_KIND", serviceCode)))) {
            return false;
        }
        
        //30日超であればレコードの作成を中断する。
        if(ACCastUtilities.toInt(serviceDetail.get("5"),0) == 2){
            return false;
        }
        
        //生保単独利用者の場合
        //if(patientState.isSeihoOnly(patientState.getInsuredId(targetServiceDate))){
        if(patientState.isSeihoOnly(targetServiceDate)){
            //様式第三または四の場合レコードの作成を行わない
            if(identificationNo.equals(QP001StyleAbstract.IDENTIFICATION_NO_3_201204)
               || identificationNo.equals(QP001StyleAbstract.IDENTIFICATION_NO_3_2_201204)
               || identificationNo.equals(QP001StyleAbstract.IDENTIFICATION_NO_4_201204)
               || identificationNo.equals(QP001StyleAbstract.IDENTIFICATION_NO_4_2_201204)
               || identificationNo.equals(QP001StyleAbstract.IDENTIFICATION_NO_5_201204)
               || identificationNo.equals(QP001StyleAbstract.IDENTIFICATION_NO_5_2_201204)
            	){
                return false;
            }
            
            //食費、多床室以外のサービスの場合、記載を行わない。
            switch(QP001SpecialCase.getServiceKind(serviceCode)){
            //食費
            case 1:
            //多床室
            case 6:
                return true;
            default:
                return false;
            }
        }
        
        return true;
    }
    
    
    private static String getSerialId(String identificationNo,
            Date targetDate, Object targetServiceDate, VRMap serviceDetail,
            VRMap serviceCode, QP001PatientState patientState,QP001Manager manager) throws Exception {

        StringBuilder serial = new StringBuilder();
        // 交換識別番号
        serial.append(identificationNo);
        // レコード種別コード2桁(11固定)
        serial.append(_801002);
        // サービス提供年月6桁(YYYYMM)
        serial.append(VRDateParser.format(targetDate, "yyyyMM"));
        // 事業所番号10桁
        serial.append(VRBindPathParser.get("PROVIDER_ID", serviceDetail));
        // 証記載保険者番号8桁
        serial.append(patientState.getInsurerId(targetServiceDate));
        // 被保険者番号10桁
        serial.append(patientState.getInsuredId(targetServiceDate));
//        // システム内サービス種類コード
//        serial.append(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL",
//                serviceCode));
//        // システム内サービス項目コード
//        serial.append(VRBindPathParser.get("SYSTEM_SERVICE_CODE_ITEM",
//                serviceCode));
        
        // サービス種類コード
        serial.append(VRBindPathParser.get("SERVICE_CODE_KIND", serviceCode));
        // サービス項目コード
        serial.append(VRBindPathParser.get("SERVICE_CODE_ITEM", serviceCode));
        
        // 費用単価
        serial.append(QP001SpecialCase.getUnit(serviceDetail,serviceCode,manager));

        return serial.toString();
    }

    /**
     * 既に情報が登録されているか返却します。
     * 
     * @return 新規:true 追加:false
     */
    private boolean isNew() {
        // 交換情報レコードに登録が無ければ新規とみなす。
        return ((get_801001() == null) || ("".equals(get_801001())));
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

        if (isNew()) {
            // nursing の KEY : 801001(交換情報識別番号) に VALUE : 第六引数を設定する。
            set_801001(identificationNo);
            // nursing の KEY : 801003(サービス提供年月) に
            // VALUE : yyyyMM形式にフォーマットしたtargetDateを設定する。
            set_801003(VRDateParser.format(targetDate, "yyyyMM"));
            // nursing の KEY : 801004(事業所番号) に
            // VALUE : 10桁フォーマットした事業所番号(serviceDetailより取得)を設定する。
            set_801004(ACCastUtilities.toString(VRBindPathParser.get(
                    "PROVIDER_ID", serviceDetail)));
            // nursing の KEY : 801005(証記載保険者番号) に
            // VALUE : 8桁フォーマットした利用者の保険者番号(patientより取得)を設定する。
            set_801005(patientState.getInsurerId(targetServiceDate));
            // nursing の KEY : 801006(被保険者番号) に
            // VALUE : 10桁フォーマットした利用者の被保険者番号(patientより取得)を設定する。
            set_801006(patientState.getInsuredId(targetServiceDate));

            // nursing の KEY : 801008(サービス種類コード) に
            // VALUE : 2桁フォーマットしたサービス種類コード(serviceCodeより取得))を設定する。
            // (59固定となるはず)
            set_801008(ACCastUtilities.toString(VRBindPathParser.get(
                    "SERVICE_CODE_KIND", serviceCode)));
            // nursing の KEY : 801009(サービス項目コード) に
            // VALUE : 4桁フォーマットしたサービス項目コード(serviceCodeより取得する)を設定する。
            set_801009(ACCastUtilities.toString(VRBindPathParser.get(
                    "SERVICE_CODE_ITEM", serviceCode)));

            // nursing の KEY : 801010(費用単価) に
            // VALUE : 利用者情報画面 - 利用者の所得段階により決定した費用単価を設定する。
            set_801010(QP001SpecialCase.getUnit(serviceDetail,serviceCode,manager));

            // nursing の KEY : 801011(負担限度額) に
            // VALUE : 利用者の負担限度額を設定する。(利用者情報画面 - 利用者の所得段階により決定した費用単価を設定する。)
            set_801011(QP001SpecialCase.getRiyosyaFutan(serviceCode,patientState));

            // nursing の KEY : 801012(日数) に
            // VALUE : 1 を設定する。
            set_801012(1);

            // サービスコードマスタTBLのSERVICE_NAMEを設定する。
            set_801034(ACCastUtilities.toString(VRBindPathParser.get(
                    "SERVICE_NAME", serviceCode)));
            // システム内サービス種類コード(SYSTEM_SERVICE_KIND_DETAIL)を設定する。
            set_801035(ACCastUtilities.toString(VRBindPathParser.get(
                    "SYSTEM_SERVICE_KIND_DETAIL", serviceCode)));
            // システム内サービス項目コード(SYSTEM_SERVICE_CODE_ITEM)
            set_801036(ACCastUtilities.toString(VRBindPathParser.get(
                    "SYSTEM_SERVICE_CODE_ITEM", serviceCode)));
            // 提供サービス区分
            set_801037(QP001SpecialCase.getServiceKind(serviceCode));

        } else {
            // nursing の KEY : 801012(日数) の値に1を加える。
            set_801012(get_801012() + 1);
        }

        // 公費順位の登録を行う。
//        kohiManager.setExtraData(targetServiceDate,serviceDetail, patientState, get_801035(),
//                "4", get_801010(),QP001Manager.getInstance().getProviderMedicalFlag(get_801004()));
//        kohiManager.setExtraData(targetServiceDate,serviceDetail, patientState, serviceCode,
//                "4", get_801010(),QP001Manager.getInstance().getProviderMedicalFlag(get_801004()));
        kohiManager.setExtraData(targetServiceDate,serviceDetail, patientState, serviceCode,
                "4", get_801010(),manager.getProviderMedicalFlag(get_801004()),manager);

    }
    


    /**
     * レコード内容の確定を行う。
     */
    protected void commitRecord(String[] kohi,QP001PatientState patientState,QP001Manager manager) throws Exception {
        //生保単独フラグ
        boolean seihoOnly = QP001SpecialCase.isSeihoOnly(get_801006());
        //種類種別(1.食費)
        int serviceKind = get_801037();    
    
        // 費用額
        set_801016(get_801010() * get_801012());
        
//        //生保単独であれば、保険分請求を行わず、全額公費負担とする。
//        if(seihoOnly){
//            //保険分請求額を0に設定
//            set_801017(0);
//            //公費１請求額に費用額の全額を設定する。
//            set_801018(get_801016());
//            //利用者負担額に0を設定する。
//            set_801021(0);
//            //処理を終了
//            return;
//            
//        //生保単独でなければ、保険分の請求金額を設定する。
//        } else {
//            //保険分請求額 費用額-(負担限度額*日数)
//            set_801017(get_801016() - (get_801011() * get_801012()));
//            
//            //負数になったら(利用者請求のほうが多ければ)0に戻す。
//            if(get_801017() < 0){
//                set_801017(0);
//            }
//        }
        //保険分請求額 費用額-(負担限度額*日数)
        set_801017(get_801016() - (get_801011() * get_801012()));
        
        //負数になったら(利用者請求のほうが多ければ)0に戻す。
        if(get_801017() < 0){
            set_801017(0);
        }
        
        // 様式８，９，１０でないと公費の適用は行われない。
        if(QP001SpecialCase.isShisetsuDiscriminationNo(get_801001())){
            
            //生保単独であれば、保険分請求を行わず、全額公費負担とする。
            if(seihoOnly){
                //保険分請求額を0に設定
                set_801017(0);
                //公費１請求額に費用額の全額を設定する。
                set_801018(get_801016());
                //利用者負担額に0を設定する。
                set_801021(0);
                
                // add sta 2006.05.18 fujihara.shin
                if(isUsingKohi(kohi[0],manager) && kohi[0].startsWith("12")){
                	set_801013(kohiManager.getKohiCount(kohi[0]));
                } else if(isUsingKohi(kohi[1],manager) && kohi[1].startsWith("12")){
                	set_801013(kohiManager.getKohiCount(kohi[1]));
                } else if(isUsingKohi(kohi[2],manager) && kohi[2].startsWith("12")){
                	set_801013(kohiManager.getKohiCount(kohi[2]));
                }
                // add end 2006.05.18 fujihara.shin
                
                //処理を終了
                return;
            }
            
            // 公費１の適用があるか確認
            //if ((kohi[0] != null) && (!"".equals(kohi[0]))) {
            if(isUsingKohi(kohi[0],manager)){
                
                int kohiRate = ACCastUtilities.toInt(patientState.getKohiData(kohi[0],"BENEFIT_RATE",1),0);
                //公費の給付有
                if(kohiRate != 0){
                    // 公費１対象日数を設定する。
                    set_801013(kohiManager.getKohiCount(kohi[0]));
                    //食費提供、または多床室である場合のみ公費を適用する。
                    //(日数は設定を行う)
                    if((serviceKind == 1) || (serviceKind == 6)){
                        // 公費1負担額(明細)6桁を設定する。(負担限度額*公費1日数)
                        set_801018(get_801011() * get_801013());
                        //公費分１が費用額と保険分の合算を超える場合
                        if(get_801018() > (get_801016() + get_801017())){
                            //公費分に費用額から保険分を引いた値を適用する。
                            set_801018(get_801016() - get_801017()); 
                        }
                        
                        // add sta 2006.05.18 fujihara.shin
                        //公費分１の金額が0の場合、公費対象日数を0とする
                        if(get_801018() == 0){
                        	set_801013(0);
                        }
                        // add end 2006.05.18 fujihara.shin
                    } else {
                        //食費、多床室以外は公費日数を0として計上
                        set_801013(0);
                    }
                }
                // 全額給付したら処理を終了
                if (get_801016() == (get_801017() + get_801018()))
                    return;
            }
            // 公費２の適用があるか確認
            //if ((kohi[1] != null) && (!"".equals(kohi[1]))) {
            if(isUsingKohi(kohi[1],manager)){
                //公費２の適用があるか確認
                int kohiRate = ACCastUtilities.toInt(patientState.getKohiData(kohi[1],"BENEFIT_RATE",1),0);
                //公費の給付有
                if(kohiRate != 0){
                    //公費２の対象日を設定する。
                    set_801014(kohiManager.getKohiCount(kohi[1]));
                    //食費提供、または多床室である場合のみ公費を適用する。
                    if((serviceKind == 1) || (serviceKind == 6)){
                        //公費２負担額(明細)6桁を設定する。（負担限度額*公費2日数）
                        set_801019(get_801011() * get_801014());
                        //公費２が費用額と保険分の合算を超える場合
                        if(get_801019() > (get_801016() + get_801017())){
                            //公費分に費用額から保険分を引いた値を適用する。
                            set_801019(get_801016() - get_801017()); 
                        }
                        
                        // add sta 2006.05.18 fujihara.shin
                        //公費分１の金額が0の場合、公費対象日数を0とする
                        if(get_801019() == 0){
                        	set_801014(0);
                        }
                        // add end 2006.05.18 fujihara.shin
                    } else {
                        set_801014(0);
                    }
                        
                }
                // 全額給付したら処理を終了
                if (get_801016() == (get_801017() + get_801018() + get_801019()))
                    return;
            }
            // 公費３の適用があるか確認
            //if ((kohi[2] != null) && (!"".equals(kohi[2]))) {
            if(isUsingKohi(kohi[2],manager)){
                //公費３の適用があるか確認
                int kohiRate = ACCastUtilities.toInt(patientState.getKohiData(kohi[2],"BENEFIT_RATE",1),0);
                //公費の給付有
                if(kohiRate != 0){
                    //公費３の対象日を設定する。
                    set_801015(kohiManager.getKohiCount(kohi[2]));
                    //食費提供、または多床室である場合のみ公費を適用する。
                    if((serviceKind == 1) || (serviceKind == 6)){
                        //公費３負担額(明細)6桁を設定する。
                        set_801020(get_801011() * get_801015());
                        //公費３が費用額と保険分の合算を超える場合
                        if(get_801020() > (get_801016() + get_801017())){
                            //公費分に費用額から保険分を引いた値を適用する。
                            set_801020(get_801016() - get_801017());
                        }
                        // add sta 2006.05.18 fujihara.shin
                        //公費分１の金額が0の場合、公費対象日数を0とする
                        if(get_801020() == 0){
                        	set_801015(0);
                        }
                        // add end 2006.05.18 fujihara.shin
                    } else {
                        set_801015(0);
                    }
                }
                
            }
        }
        // 利用者負担額を設定する。
        set_801021(get_801016() - get_801017() - get_801018() - get_801019() - get_801020());

    }

    private boolean isUsingKohi(String kohi, QP001Manager manager) throws Exception {
        
        if((kohi == null) || "".equals(kohi)){
            return false;
        }
        
        VRMap map = (VRMap)manager.getKohiMatchData(kohi,get_801035(),"4");
        if(map == null){
            return false;
        }
        
        if(ACCastUtilities.toInt(map.get("APPLICATION_TYPE"),0) != 4){
            return false;
        }
        
        return true;
    }
    
    /**
     * レコード順次番号99の集計を行う。
     * 
     * @param nursingMap
     * @throws Exception
     */
    protected void commitRecord(VRMap nursingMap) throws Exception {
        QP001RecordNursing nursing = null;
        Iterator it = nursingMap.keySet().iterator();
        int count = 1;
        while (it.hasNext()) {
            nursing = (QP001RecordNursing) nursingMap.get(it.next());
            
            //2006.04.28 全額自己負担対応
            //保険・公費の負担が無い場合には、帳票に計上しない。
            if((nursing.get_801017() + nursing.get_801018() + nursing.get_801019() + nursing.get_801020()) <= 0){
                continue;
            }
            
            //レコード順次番号を設定する。
            nursing.set_801007(count);
            
            // 費用額合計6桁
            set_801022(get_801022() + nursing.get_801016());
            // 保険分請求額合計6桁
            set_801023(get_801023() + nursing.get_801017());
            // 利用者負担額合計6桁
            set_801024(get_801024() + nursing.get_801021());
            // (公費1)負担額合計6桁
            set_801025(get_801025() + nursing.get_801018());
            // (公費1)請求額6桁
            set_801026(get_801026() + nursing.get_801018());
            // (公費1)本人負担額5桁
            set_801027(0);
            // (公費2)負担額合計6桁
            set_801028(get_801028() + nursing.get_801019());
            // (公費2)請求額6桁
            set_801029(get_801029() + nursing.get_801019());
            // (公費2)本人負担額5桁
            set_801030(0);
            // (公費3)負担額合計6桁
            set_801031(get_801031() + nursing.get_801020());
            // (公費3)請求額6桁
            set_801032(get_801032() + nursing.get_801020());
            // (公費3)本人負担額5桁
            set_801033(0);
            count++;
        }
        // 自分自身のレコード順次番号を99に変更する。
        set_801007(99);
    }
    
    /**
     * レコード順次番号が99のレコードに対し、公費自己負担額の確定を行う。
     * ※集計情報レコードの確定をおこない、公費自己負担額の残額を確定する必要がある。
     * @param kohi 公費番号
     * @param patientState 利用者情報
     * @throws Exception
     */
    protected void commitRecordKohiSelfPay(String[] kohi,QP001PatientState patientState) throws Exception{
        //レコード順次番号を確認し、99でなければ処理を中断する。
        if(get_801007() != 99){
            return;
        }
        //様式第八、第九、第十以外の場合は処理を中断する。
        if(!QP001SpecialCase.isShisetsuDiscriminationNo(get_801001())){
            return;
        }
        
        // 公費１の適用があるか確認
        if ((kohi[0] != null) && (!"".equals(kohi[0]))) {
            int kohiRate = ACCastUtilities.toInt(patientState.getKohiData(kohi[0],"BENEFIT_RATE",1),0);
            //公費の給付有
            if(kohiRate != 0){
                //公費１自己負担額の設定を行う。
                int selfPay = patientState.getKohiSelfPay(kohi[0],1);
                //公費自己負担額の方が大きければ
                if(get_801026() < selfPay){
                    //(公費1)本人負担額5桁に請求額を設定する。
                    set_801027(get_801026());
                    //公費1請求額を0に設定する。
                    set_801026(0);
                    //使用した自己負担を報告する。
                    patientState.setKohiSelfPayUse(kohi[0],get_801027());
                    
                } else {
                    //公費１請求額から公費自己負担分を減算する
                    set_801026(get_801026() - selfPay);
                    //公費１自己負担額を設定する。
                    set_801027(selfPay);
                    //使用した自己負担を報告する。
                    patientState.setKohiSelfPayUse(kohi[0],selfPay);
                }
            }
        }
        // 公費２の適用があるか確認
        if ((kohi[1] != null) && (!"".equals(kohi[1]))) {
            //公費２の適用があるか確認
            int kohiRate = ACCastUtilities.toInt(patientState.getKohiData(kohi[1],"BENEFIT_RATE",1),0);
            //公費の給付有
            if(kohiRate != 0){
                //公費２自己負担額の設定を行う。
                int selfPay = patientState.getKohiSelfPay(kohi[1],1);
                //公費自己負担額の方が大きければ
                if(get_801029() < selfPay){
                    //(公費2)本人負担額5桁に請求額を設定する。
                    set_801030(get_801029());
                    //公費2請求額を0に設定する。
                    set_801029(0);
                    //使用した自己負担を報告する。
                    patientState.setKohiSelfPayUse(kohi[1],get_801030());
                    
                } else {
                    //公費2請求額から公費自己負担分を減算する
                    set_801029(get_801029() - selfPay);
                    //公費2自己負担額を設定する。
                    set_801030(selfPay);
                    //使用した自己負担を報告する。
                    patientState.setKohiSelfPayUse(kohi[1],selfPay);
                }
            }
        }
        // 公費３の適用があるか確認
        if ((kohi[2] != null) && (!"".equals(kohi[2]))) {
            //公費３の適用があるか確認
            int kohiRate = ACCastUtilities.toInt(patientState.getKohiData(kohi[2],"BENEFIT_RATE",1),0);
            //公費の給付有
            if(kohiRate != 0){
                //公費３自己負担額の設定を行う。
                int selfPay = patientState.getKohiSelfPay(kohi[2],1);
                //[ID:0000538][Shin Fujihara] 2009/07 edit begin 2009年度対応
                //公費自己負担額の方が大きければ
                if(get_801032() < selfPay){
                    //(公費1)本人負担額5桁に請求額を設定する。
                    set_801033(get_801032());
                    //公費1請求額を0に設定する。
                    set_801032(0);
                    //使用した自己負担を報告する。
                    patientState.setKohiSelfPayUse(kohi[2],get_801033());
                    
                } else {
                    //公費１請求額から公費自己負担分を減算する
                    set_801032(get_801032() - selfPay);
                    //公費１自己負担額を設定する。
                    set_801033(selfPay);
                    //使用した自己負担を報告する。
                    patientState.setKohiSelfPayUse(kohi[2],selfPay);
                }
                /*
                //公費自己負担額の方が大きければ
                if(get_801032() < selfPay){
                    //(公費1)本人負担額5桁に請求額を設定する。
                    set_801032(get_801031());
                    //公費1請求額を0に設定する。
                    set_801031(0);
                    //使用した自己負担を報告する。
                    patientState.setKohiSelfPayUse(kohi[2],get_801032());
                    
                } else {
                    //公費１請求額から公費自己負担分を減算する
                    set_801031(get_801031() - selfPay);
                    //公費１自己負担額を設定する。
                    set_801032(selfPay);
                    //使用した自己負担を報告する。
                    patientState.setKohiSelfPayUse(kohi[2],selfPay);
                }
                */
                //[ID:0000538][Shin Fujihara] 2009/07 edit end 2009年度対応
            }
        }
    }

    protected VRMap getKohiList() {
        return this.kohiManager.getKohiList();
    }

    protected VRList getRealDays() {
        return this.kohiManager.getRealDays();
    }

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
        setData(result, "801001", get_801001());
        // レコード種別コード2桁(11を設定)
        setData(result, "801002", get_801002());
        // サービス提供年月6桁(YYYYMM)
        setData(result, "801003", get_801003());
        // 事業所番号10桁
        setData(result, "801004", get_801004());
        // 証記載保険者番号8桁
        setData(result, "801005", get_801005());
        // 被保険者番号10桁
        setData(result, "801006", get_801006());
        // 特定入所者介護サービス費用情報レコード順次番号2桁
        setData(result, "801007", get_801007());
        // サービス種類コード2桁
        setData(result, "801008", get_801008());
        // サービス項目コード4桁
        setData(result, "801009", get_801009());

        // 費用単価4桁
        setData(result, "801010", get_801010());
        // 負担限度額4桁
        setData(result, "801011", get_801011());
        // 日数2桁
        setData(result, "801012", get_801012());
        // 公費1日数2桁
        setData(result, "801013", get_801013());
        // 公費2日数2桁
        setData(result, "801014", get_801014());
        //公費3日数2桁
        setData(result, "801015", get_801015());
        //費用額6桁
        setData(result, "801016", get_801016());
        //保険分請求額6桁
        setData(result, "801017", get_801017());
        //公費1負担額(明細)6桁
        setData(result, "801018", get_801018());
        //公費2負担額(明細)6桁
        setData(result, "801019", get_801019());

        //公費3負担額(明細)6桁
        setData(result, "801020", get_801020());
        //利用者負担額5桁
        setData(result, "801021", get_801021());
        //費用額合計6桁
        setData(result, "801022", get_801022());
        //保険分請求額合計6桁
        setData(result, "801023", get_801023());
        //利用者負担額合計6桁
        setData(result, "801024", get_801024());
        //(公費1)負担額合計6桁
        setData(result, "801025", get_801025());
        //(公費1)請求額6桁
        setData(result, "801026", get_801026());
        //(公費1)本人負担額5桁
        setData(result, "801027", get_801027());
        //(公費2)負担額合計6桁
        setData(result, "801028", get_801028());
        //(公費2)請求額6桁
        setData(result, "801029", get_801029());

        //(公費2)本人負担額5桁
        setData(result, "801030", get_801030());
        //(公費3)負担額合計6桁
        setData(result, "801031", get_801031());
        //(公費3)請求額6桁
        setData(result, "801032", get_801032());
        //(公費3)本人負担額5桁
        setData(result, "801033", get_801033());
        //サービス名称(サービスコードマスタTBLのSERVICE_NAME)
        setData(result, "801034", get_801034());

        //		setData(result,style,"801035",get_801035());
        //		setData(result,style,"801036",get_801036());
        setData(result, "801037", get_801037());

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
        //特定入所者介護サービス費用情報レコード
        //result.put("CATEGORY_NO", "8");
        result.put("CATEGORY_NO", QkanConstants.CATEGORY_NO_RECODE_SPECIAL_ENTER_SERVICE);
        return result;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("[801001=" + get_801001() + "]\n");
        result.append("[801002=" + get_801002() + "]\n");
        result.append("[801003=" + get_801003() + "]\n");
        result.append("[801004=" + get_801004() + "]\n");
        result.append("[801005=" + get_801005() + "]\n");
        result.append("[801006=" + get_801006() + "]\n");
        result.append("[801007=" + get_801007() + "]\n");
        result.append("[801008=" + get_801008() + "]\n");
        result.append("[801009=" + get_801009() + "]\n");

        result.append("[801010=" + get_801010() + "]\n");
        result.append("[801011=" + get_801011() + "]\n");
        result.append("[801012=" + get_801012() + "]\n");
        result.append("[801013=" + get_801013() + "]\n");
        result.append("[801014=" + get_801014() + "]\n");
        result.append("[801015=" + get_801015() + "]\n");
        result.append("[801016=" + get_801016() + "]\n");
        result.append("[801017=" + get_801017() + "]\n");
        result.append("[801018=" + get_801018() + "]\n");
        result.append("[801019=" + get_801019() + "]\n");

        result.append("[801020=" + get_801020() + "]\n");
        result.append("[801021=" + get_801021() + "]\n");
        result.append("[801022=" + get_801022() + "]\n");
        result.append("[801023=" + get_801023() + "]\n");
        result.append("[801024=" + get_801024() + "]\n");
        result.append("[801025=" + get_801025() + "]\n");
        result.append("[801026=" + get_801026() + "]\n");
        result.append("[801027=" + get_801027() + "]\n");
        result.append("[801028=" + get_801028() + "]\n");
        result.append("[801029=" + get_801029() + "]\n");

        result.append("[801030=" + get_801030() + "]\n");
        result.append("[801031=" + get_801031() + "]\n");
        result.append("[801032=" + get_801032() + "]\n");
        result.append("[801033=" + get_801033() + "]\n");
        result.append("[801034=" + get_801034() + "]\n");
        result.append("[801035=" + get_801035() + "]\n");
        result.append("[801036=" + get_801036() + "]\n");
        result.append("[801037=" + get_801037() + "]\n");

        return result.toString();
    }

}
