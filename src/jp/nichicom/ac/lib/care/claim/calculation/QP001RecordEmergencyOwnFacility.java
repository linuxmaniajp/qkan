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
 * 作成日: 2012/01/17  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス 請求処理 (001)
 * プログラム 緊急時施設療養・所定疾患設療養費情報レコード (QP001RecordEmergencyOwnFacility)
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
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

/**
 * 緊急時施設療養レコード
 * 
 */
public class QP001RecordEmergencyOwnFacility extends QP001RecordAbstract {
    // 交換情報識別番号4桁
    private String _1701001 = "";
    // レコード種別コード2桁
    private static final String _1701002 = "13";
    // サービス提供年月6桁(YYYYMM)
    private String _1701003 = "";
    // 事業所番号10桁
    private String _1701004 = "";
    // 証記載保険者番号8桁
    private String _1701005 = "";
    // 被保険者番号10桁
    private String _1701006 = "";
    // 緊急時施設療養情報レコード順次番号2桁
    private int _1701007 = 0;
    // 緊急時傷病名1 40桁
    private String _1701008 = "";
    // 緊急時傷病名2 40桁
    private String _1701009 = "";
    // 緊急時傷病名3 40桁
    private String _1701010 = "";
    // 緊急時治療開始年月日1 8桁(YYYYMMDD)
    private String _1701011 = "";
    // 緊急時治療開始年月日2 8桁(YYYYMMDD)
    private String _1701012 = "";
    // 緊急時治療開始年月日3 8桁(YYYYMMDD)
    private String _1701013 = "";
    // 往診日数2桁
    private int _1701014 = 0;
    // 往診医療機関名40桁
    private String _1701015 = "";
    // 通院日数2桁
    private int _1701016 = 0;
    // 通院医療機関名40桁
    private String _1701017 = "";
    // 緊急時治療管理単位数6桁
    private int _1701018 = 0;
    // 緊急時治療管理日数2桁
    private int _1701019 = 0;
    // 緊急時治療管理小計7桁
    private int _1701020 = 0;
    // リハビリテーション点数7桁
    private int _1701021 = 0;
    // 処置点数7桁
    private int _1701022 = 0;
    // 手術点数7桁
    private int _1701023 = 0;
    // 麻酔点数7桁
    private int _1701024 = 0;
    // 放射線治療点数7桁
    private int _1701025 = 0;
    // 摘要1 64桁
    private String _1701026 = "";
    // 摘要2 64桁
    private String _1701027 = "";
    // 摘要3 64桁
    private String _1701028 = "";
    // 摘要4 64桁
    private String _1701029 = "";
    // 摘要5 64桁
    private String _1701030 = "";
    // 摘要6 64桁
    private String _1701031 = "";
    // 摘要7 64桁
    private String _1701032 = "";
    // 摘要8 64桁
    private String _1701033 = "";
    // 摘要9 64桁
    private String _1701034 = "";
    // 摘要10 64桁
    private String _1701035 = "";
    // 摘要11 64桁
    private String _1701036 = "";
    // 摘要12 64桁
    private String _1701037 = "";
    // 摘要13 64桁
    private String _1701038 = "";
    // 摘要14 64桁
    private String _1701039 = "";
    // 摘要15 64桁
    private String _1701040 = "";
    // 摘要16 64桁
    private String _1701041 = "";
    // 摘要17 64桁
    private String _1701042 = "";
    // 摘要18 64桁
    private String _1701043 = "";
    // 摘要19 64桁
    private String _1701044 = "";
    // 摘要20 64桁
    private String _1701045 = "";
    // 緊急時施設療養費合計点数8桁
    private int _1701046 = 0;

    // 所定疾患設療養費傷病名1 40桁
    private String _1701047 = "";
    // 所定疾患設療養費傷病名2 40桁
    private String _1701048 = "";
    // 所定疾患設療養費傷病名3 40桁
    private String _1701049 = "";
    // 所定疾患設療養費開始年月日1 8桁(YYYYMMDD)
    private String _1701050 = "";
    // 所定疾患設療養費開始年月日2 8桁(YYYYMMDD)
    private String _1701051 = "";
    // 所定疾患設療養費開始年月日3 8桁(YYYYMMDD)
    private String _1701052 = "";
    // 所定疾患設療養費単位数6桁
    private int _1701053 = 0;
    // 所定疾患設療養費日数2桁
    private int _1701054 = 0;
    // 所定疾患設療養費小計7桁
    private int _1701055 = 0;

    protected String getSerialId() {
        return null;
    }

    /**  @return レコード種別コード2桁 */
    protected static String get_1701002() {
        return _1701002;
    }

    /**  @return 交換情報識別番号4桁 */
    protected String get_1701001() {
        return _1701001;
    }
    /**  @param _1701001 交換情報識別番号4桁 */
    protected void set_1701001(String _1701001) {
        this._1701001 = _1701001;
    }
    /** @return サービス提供年月6桁(YYYYMM) */
    protected String get_1701003() {
        return _1701003;
    }
    /** @param _1701003 サービス提供年月6桁(YYYYMM) */
    protected void set_1701003(String _1701003) {
        this._1701003 = _1701003;
    }
    /** @return 事業所番号10桁 */
    protected String get_1701004() {
        return _1701004;
    }
    /** @param _1701004 事業所番号10桁 */
    protected void set_1701004(String _1701004) {
        this._1701004 = _1701004;
    }
    /** @return 証記載保険者番号8桁 */
    protected String get_1701005() {
        return _1701005;
    }
    /** @param _1701005 証記載保険者番号8桁 */
    protected void set_1701005(String _1701005) {
        this._1701005 = _1701005;
    }
    /** @return 被保険者番号10桁 */
    protected String get_1701006() {
        return _1701006;
    }
    /** @param _1701006 被保険者番号10桁 */
    protected void set_1701006(String _1701006) {
        this._1701006 = _1701006;
    }
    /** @return 緊急時施設療養情報レコード順次番号2桁 */
    protected int get_1701007() {
        return _1701007;
    }
    /** @param _1701007 緊急時施設療養情報レコード順次番号2桁 */
    protected void set_1701007(int _1701007) {
        this._1701007 = _1701007;
    }
    /** @return 緊急時傷病名1 40桁 */
    protected String get_1701008() {
        return _1701008;
    }
    /** @param _1701008 緊急時傷病名1 40桁 */
    protected void set_1701008(String _1701008) {
        this._1701008 = _1701008;
    }
    /** @return 緊急時傷病名2 40桁 */
    protected String get_1701009() {
        return _1701009;
    }
    /** @param _1701009 緊急時傷病名2 40桁 */
    protected void set_1701009(String _1701009) {
        this._1701009 = _1701009;
    }
    /** @return 緊急時傷病名3 40桁 */
    protected String get_1701010() {
        return _1701010;
    }
    /** @param _1701010 緊急時傷病名3 40桁 */
    protected void set_1701010(String _1701010) {
        this._1701010 = _1701010;
    }
    /** @return 緊急時治療開始年月日1 8桁(YYYYMMDD) */
    protected String get_1701011() {
        return _1701011;
    }
    /** @param _1701011 緊急時治療開始年月日1 8桁(YYYYMMDD) */
    protected void set_1701011(String _1701011) {
        this._1701011 = _1701011;
    }
    /** @return  緊急時治療開始年月日2 8桁(YYYYMMDD) */
    protected String get_1701012() {
        return _1701012;
    }
    /** @param _1701012 緊急時治療開始年月日2 8桁(YYYYMMDD) */
    protected void set_1701012(String _1701012) {
        this._1701012 = _1701012;
    }
    /** @return 緊急時治療開始年月日3 8桁(YYYYMMDD) */
    protected String get_1701013() {
        return _1701013;
    }
    /** @param _1701013 緊急時治療開始年月日3 8桁(YYYYMMDD) */
    protected void set_1701013(String _1701013) {
        this._1701013 = _1701013;
    }
    /** @return 往診日数2桁 */
    protected int get_1701014() {
        return _1701014;
    }
    /** @param _1701014 往診日数2桁 */
    protected void set_1701014(int _1701014) {
        this._1701014 = _1701014;
    }
    /** @return 往診医療機関名40桁 */
    protected String get_1701015() {
        return _1701015;
    }
    /** @param _1701015 往診医療機関名40桁 */
    protected void set_1701015(String _1701015) {
        this._1701015 = _1701015;
    }
    /** @return 通院日数2桁 */
    protected int get_1701016() {
        return _1701016;
    }
    /** @param _1701016 通院日数2桁 */
    protected void set_1701016(int _1701016) {
        this._1701016 = _1701016;
    }
    /** @return 通院医療機関名40桁 */
    protected String get_1701017() {
        return _1701017;
    }
    /** @param _1701017 通院医療機関名40桁 */
    protected void set_1701017(String _1701017) {
        this._1701017 = _1701017;
    }
    /** @return 緊急時治療管理単位数6桁 */
    protected int get_1701018() {
        return _1701018;
    }
    /** @param _1701018 緊急時治療管理単位数6桁 */
    protected void set_1701018(int _1701018) {
        this._1701018 = _1701018;
    }
    /** @return 緊急時治療管理日数2桁 */
    protected int get_1701019() {
        return _1701019;
    }
    /** @param _1701019 緊急時治療管理日数2桁 */
    protected void set_1701019(int _1701019) {
        this._1701019 = _1701019;
    }
    /** @return 緊急時治療管理小計7桁 */
    protected int get_1701020() {
        return _1701020;
    }
    /** @param _1701020 緊急時治療管理小計7桁 */
    protected void set_1701020(int _1701020) {
        this._1701020 = _1701020;
    }
    /** @return リハビリテーション点数7桁 */
    protected int get_1701021() {
        return _1701021;
    }
    /** @param _1701021 リハビリテーション点数7桁 */
    protected void set_1701021(int _1701021) {
        this._1701021 = _1701021;
    }
    /** @return 処置点数7桁 */
    protected int get_1701022() {
        return _1701022;
    }
    /** @param _1701022 処置点数7桁 */
    protected void set_1701022(int _1701022) {
        this._1701022 = _1701022;
    }
    /** @return 手術点数7桁 */
    protected int get_1701023() {
        return _1701023;
    }
    /** @param _1701023 手術点数7桁 */
    protected void set_1701023(int _1701023) {
        this._1701023 = _1701023;
    }
    /** @return 麻酔点数7桁 */
    protected int get_1701024() {
        return _1701024;
    }
    /** @param _1701024 麻酔点数7桁 */
    protected void set_1701024(int _1701024) {
        this._1701024 = _1701024;
    }
    /** @return 放射線治療点数7桁 */
    protected int get_1701025() {
        return _1701025;
    }
    /** @param _1701025 放射線治療点数7桁 */
    protected void set_1701025(int _1701025) {
        this._1701025 = _1701025;
    }
    /** @return 摘要1 64桁 */
    protected String get_1701026() {
        return _1701026;
    }
    /** @param _1701026 摘要1 64桁 */
    protected void set_1701026(String _1701026) {
        this._1701026 = _1701026;
    }
    /** @return 摘要2 64桁 */
    protected String get_1701027() {
        return _1701027;
    }
    /** @param _1701027 摘要2 64桁 */
    protected void set_1701027(String _1701027) {
        this._1701027 = _1701027;
    }
    /** @return 摘要3 64桁 */
    protected String get_1701028() {
        return _1701028;
    }
    /** @param _1701028 摘要3 64 */
    protected void set_1701028(String _1701028) {
        this._1701028 = _1701028;
    }
    /** @return 摘要4 64桁 */
    protected String get_1701029() {
        return _1701029;
    }
    /** @param _1701029 摘要4 64桁 */
    protected void set_1701029(String _1701029) {
        this._1701029 = _1701029;
    }
    /** @return 摘要5 64桁 */
    protected String get_1701030() {
        return _1701030;
    }
    /** @param _1701030 摘要5 64桁 */
    protected void set_1701030(String _1701030) {
        this._1701030 = _1701030;
    }
    /** @return 摘要6 64桁 */
    protected String get_1701031() {
        return _1701031;
    }
    /** @param _1701031 摘要6 64桁 */
    protected void set_1701031(String _1701031) {
        this._1701031 = _1701031;
    }
    /** @return 摘要7 64桁 */
    protected String get_1701032() {
        return _1701032;
    }
    /** @param _1701032 摘要7 64桁 */
    protected void set_1701032(String _1701032) {
        this._1701032 = _1701032;
    }
    /** @return 摘要8 64桁 */
    protected String get_1701033() {
        return _1701033;
    }
    /** @param _1701033 摘要8 64桁 */
    protected void set_1701033(String _1701033) {
        this._1701033 = _1701033;
    }
    /** @return 摘要9 64桁 */
    protected String get_1701034() {
        return _1701034;
    }
    /** @param _1701034 摘要9 64桁 */
    protected void set_1701034(String _1701034) {
        this._1701034 = _1701034;
    }
    /** @return 摘要10 64桁 */
    protected String get_1701035() {
        return _1701035;
    }
    /** @param _1701035 摘要10 64桁*/
    protected void set_1701035(String _1701035) {
        this._1701035 = _1701035;
    }
    /** @return 摘要11 64桁 */
    protected String get_1701036() {
        return _1701036;
    }
    /** @param _1701036 摘要11 64桁 */
    protected void set_1701036(String _1701036) {
        this._1701036 = _1701036;
    }
    /** @return 摘要12 64桁 */
    protected String get_1701037() {
        return _1701037;
    }
    /** @param _1701037 摘要12 64桁 */
    protected void set_1701037(String _1701037) {
        this._1701037 = _1701037;
    }
    /** @return 摘要13 64桁 */
    protected String get_1701038() {
        return _1701038;
    }
    /** @param _1701038 摘要13 64桁 */
    protected void set_1701038(String _1701038) {
        this._1701038 = _1701038;
    }
    /** @return 摘要14 64桁 */
    protected String get_1701039() {
        return _1701039;
    }
    /** @param _1701039 摘要14 64桁 */
    protected void set_1701039(String _1701039) {
        this._1701039 = _1701039;
    }
    /** @return 摘要15 64桁 */
    protected String get_1701040() {
        return _1701040;
    }
    /** @param _1701040 摘要15 64桁 */
    protected void set_1701040(String _1701040) {
        this._1701040 = _1701040;
    }
    /** @return 摘要16 64桁 */
    protected String get_1701041() {
        return _1701041;
    }
    /** @param _1701041 摘要16 64桁 */
    protected void set_1701041(String _1701041) {
        this._1701041 = _1701041;
    }
    /** @return 摘要17 64桁 */
    protected String get_1701042() {
        return _1701042;
    }
    /** @param _1701042 摘要17 64桁 */
    protected void set_1701042(String _1701042) {
        this._1701042 = _1701042;
    }
    /** @return 摘要18 64桁 */
    protected String get_1701043() {
        return _1701043;
    }
    /** @param _1701043 摘要18 64桁 */
    protected void set_1701043(String _1701043) {
        this._1701043 = _1701043;
    }
    /** @return 摘要19 64桁 */
    protected String get_1701044() {
        return _1701044;
    }
    /** @param _1701044 摘要19 64桁 */
    protected void set_1701044(String _1701044) {
        this._1701044 = _1701044;
    }
    /** @return 摘要20 64桁 */
    protected String get_1701045() {
        return _1701045;
    }
    /** @param _1701045 摘要20 64桁 */
    protected void set_1701045(String _1701045) {
        this._1701045 = _1701045;
    }
    /** @return 緊急時施設療養費合計点数8桁 */
    protected int get_1701046() {
        return _1701046;
    }
    /** @param _1701046 緊急時施設療養費合計点数8桁 */
    protected void set_1701046(int _1701046) {
        this._1701046 = _1701046;
    }
    /** @return 所定疾患設療養費傷病名1 40桁 */
    protected String get_1701047() {
        return _1701047;
    }
    /** @param _1701047 所定疾患設療養費傷病名1 40桁 */
    protected void set__1701047(String _1701047) {
        this._1701047 = _1701047;
    }
    /** @return 所定疾患設療養費傷病名2 40桁 */
    protected String get_1701048() {
        return _1701048;
    }
    /** @param _1701048 所定疾患設療養費傷病名2 40桁 */
    protected void set_1701048(String _1701048) {
        this._1701048 = _1701048;
    }
    /**  @return 所定疾患設療養費傷病名3 40桁 */
    protected String get_1701049() {
        return _1701049;
    }
    /** @param _1701049 所定疾患設療養費傷病名3 40桁 */
    protected void set_1701049(String _1701049) {
        this._1701049 = _1701049;
    }
    /** @return 所定疾患設療養費開始年月日1 8桁(YYYYMMDD) */
    protected String get_1701050() {
        return _1701050;
    }
    /** @param _1701050 所定疾患設療養費開始年月日1 8桁(YYYYMMDD) */
    protected void set_1701050(String _1701050) {
        this._1701050 = _1701050;
    }
    /** @return 所定疾患設療養費開始年月日2 8桁(YYYYMMDD) */
    protected String get_1701051() {
        return _1701051;
    }
    /** @param _1701051 所定疾患設療養費開始年月日2 8桁(YYYYMMDD) */
    protected void set_1701051(String _1701051) {
        this._1701051 = _1701051;
    }
    /** @return 所定疾患設療養費開始年月日3 8桁(YYYYMMDD) */
    protected String get_1701052() {
        return _1701052;
    }
    /** @param _1701052所定疾患設療養費開始年月日3 8桁(YYYYMMDD) */
    protected void set_1701052(String _1701052) {
        this._1701052 = _1701052;
    }
    /** @return 所定疾患設療養費単位数6桁 */
    protected int get_1701053() {
        return _1701053;
    }
    /** @param _1701053 所定疾患設療養費単位数6桁 */
    protected void set_1701053(int _1701053) {
        this._1701053 = _1701053;
    }
    /** @return 所定疾患設療養費日数2桁 */
    protected int get_1701054() {
        return _1701054;
    }
    /** @param _1701054 所定疾患設療養費日数2桁 */
    protected void set_1701054(int _1701054) {
        this._1701054 = _1701054;
    }
    /** @return 所定疾患設療養費小計7桁 */
    protected int get_1701055() {
        return _1701055;
    }
    /** @param _1701055 所定疾患設療養費小計7桁 */
    protected void set_1701055(int _1701055) {
        this._1701055 = _1701055;
    }

    /**
     * 既に情報が登録されているか返却します。
     * @return 新規:true 追加:false
     */
    private boolean isNew() {
        // 交換情報レコードに登録が無ければ新規とみなす。
        return ((get_1701001() == null) || ("".equals(get_1701001())));
    }
    
    // 緊急時パターン
    private static final int TYPE_EMERGENCY = 1;
    // 所定疾患パターン
    private static final int TYPE_PRESCRIBED = 2;

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
            String identificationNo, QP001Manager manager) throws Exception {
        
        
        int mode = 0;
        
        String systemServiceCode = String.valueOf(serviceCode.get("SYSTEM_SERVICE_CODE_ITEM"));
        // 保健施設緊急時治療管理１、保健施設緊急時治療管理２の場合は緊急時治療管理
        if("Z9000".equals(systemServiceCode)|| "Z6000".equals(systemServiceCode)){
            mode = TYPE_EMERGENCY;
            
        // 保健施設所定疾患施設療養費１、保健施設所定疾患施設療養費２の場合は所定疾患
        } else if ("Z9100".equals(systemServiceCode)|| "Z6100".equals(systemServiceCode)) {
            mode = TYPE_PRESCRIBED;
            
        // 上記加算以外の場合
        } else {
            return;
        }

        Object targetServiceDate = VRBindPathParser.get("SERVICE_DATE",
                serviceDetail);
        if (isNew()) {
            // type の KEY : 401001(交換情報識別番号4桁) に VALUE : 第６引数を設定する。
            set_1701001(identificationNo);

            // type の KEY : 401003(サービス提供年月) に
            // VALUE : yyyyMM形式にフォーマットしたtargetDateを設定する。
            set_1701003(VRDateParser.format(targetDate, "yyyyMM"));

            // type の KEY : 401004(事業所番号) に
            // VALUE : 10桁フォーマットした事業所番号(serviceDetailより取得)を設定する。
            set_1701004(ACCastUtilities.toString(VRBindPathParser.get(
                    "PROVIDER_ID", serviceDetail)));

            // type の KEY : 401005(証記載保険者番号) に
            // VALUE : 8桁フォーマットした利用者の保険者番号(patientより取得)を設定する。
            set_1701005(patientState.getInsurerId(targetServiceDate));

            // type の KEY : 401006(被保険者番号) に
            // VALUE : 10桁フォーマットした利用者の被保険者番号(patientより取得)を設定する。
            set_1701006(patientState.getInsuredId(targetServiceDate));
            // レコード順次番号
            set_1701007(99);
            
            
            if (mode == TYPE_EMERGENCY) {
                // 緊急治療管理単位数
                set_1701018(manager.getServiceUnit(get_1701004(), serviceCode));
                // 緊急時治療管理日数
                set_1701019(1);
                
            } else if (mode == TYPE_PRESCRIBED) {
                //所定疾患設療養費単位数
                set_1701053(manager.getServiceUnit(get_1701004(), serviceCode));
                //所定疾患設療養費日数
                set_1701054(1);
            }

        } else {
            if (mode == TYPE_EMERGENCY) {
                // 緊急時の単位数が入っていない場合は設定する 
                if (get_1701019() == 0) {
                    // 緊急治療管理単位数
                    set_1701018(manager.getServiceUnit(get_1701004(), serviceCode));
                }
                // 緊急時治療管理日数に１を加える。
                set_1701019(get_1701019() + 1);
                
            } else if (mode == TYPE_PRESCRIBED) {
                //所定疾患の単位数が入っていない場合は設定する
                if (get_1701053() == 0) {
                    //所定疾患設療養費単位数
                    set_1701053(manager.getServiceUnit(get_1701004(), serviceCode));
                }
                //所定疾患設療養費日数
                set_1701054(get_1701054() + 1);
                
            }
        }

    }

    /**
     * レコード内容の確定を行う。
     */
    protected void commitRecord() throws Exception {
        set_1701007(99);
        // 緊急時の合計を算出する。
        set_1701020(get_1701018() * get_1701019());
        
        // 所定疾患の合計金額を算出する
        set_1701055(get_1701053() * get_1701054());
        
        // 総合計を算出する。
        // 1701020は再掲なので合計に含めてはいけない。
        set_1701046(get_1701021() + get_1701022() + get_1701023()
                + get_1701024() + get_1701025());

    }

    /**
     * データ作成
     * 
     * @param style
     * @return
     */
    protected VRMap getRecord(VRMap style) throws Exception {
        VRMap result = copyStyle(style);

        setData(result, "1701001", get_1701001());
        setData(result, "1701002", get_1701002());
        setData(result, "1701003", get_1701003());
        setData(result, "1701004", get_1701004());
        setData(result, "1701005", get_1701005());
        setData(result, "1701006", get_1701006());
        setData(result, "1701007", get_1701007());
        setData(result, "1701008", get_1701008());
        setData(result, "1701009", get_1701009());

        setData(result, "1701010", get_1701010());
        setData(result, "1701011", get_1701011());
        setData(result, "1701012", get_1701012());
        setData(result, "1701013", get_1701013());
        setData(result, "1701014", get_1701014());
        setData(result, "1701015", get_1701015());
        setData(result, "1701016", get_1701016());
        setData(result, "1701017", get_1701017());
        setData(result, "1701018", get_1701018());
        setData(result, "1701019", get_1701019());

        setData(result, "1701020", get_1701020());
        setData(result, "1701021", get_1701021());
        setData(result, "1701022", get_1701022());
        setData(result, "1701023", get_1701023());
        setData(result, "1701024", get_1701024());
        setData(result, "1701025", get_1701025());
        setData(result, "1701026", get_1701026());
        setData(result, "1701027", get_1701027());
        setData(result, "1701028", get_1701028());
        setData(result, "1701029", get_1701029());

        setData(result, "1701030", get_1701030());
        setData(result, "1701031", get_1701031());
        setData(result, "1701032", get_1701032());
        setData(result, "1701033", get_1701033());
        setData(result, "1701034", get_1701034());
        setData(result, "1701035", get_1701035());
        setData(result, "1701036", get_1701036());
        setData(result, "1701037", get_1701037());
        setData(result, "1701038", get_1701038());
        setData(result, "1701039", get_1701039());

        setData(result, "1701040", get_1701040());
        setData(result, "1701041", get_1701041());
        setData(result, "1701042", get_1701042());
        setData(result, "1701043", get_1701043());
        setData(result, "1701044", get_1701044());
        setData(result, "1701045", get_1701045());
        setData(result, "1701046", get_1701046());
        setData(result, "1701047", get_1701047());
        setData(result, "1701048", get_1701048());
        setData(result, "1701049", get_1701049());
        
        setData(result, "1701050", get_1701050());
        setData(result, "1701051", get_1701051());
        setData(result, "1701052", get_1701052());
        setData(result, "1701053", get_1701053());
        setData(result, "1701054", get_1701054());
        setData(result, "1701055", get_1701055());

        return result;
    }

    private VRMap copyStyle(VRMap style) {
        VRMap result = new VRHashMap();
        Object key;
        // ディープコピー
        Iterator it = style.keySet().iterator();
        while (it.hasNext()) {
            key = it.next();
            result.put(key, style.get(key));
        }
        // 緊急時施設療養・所定疾患設療養費情報レコード
        result.put("CATEGORY_NO", QkanConstants.CATEGORY_NO_RECORD_EMERGENCY_OWN_FACILITY_INSTITUTION);
        
        return result;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[1701001=" + get_1701001() + "]\n");
        result.append("[1701002=" + get_1701002() + "]\n");
        result.append("[1701003=" + get_1701003() + "]\n");
        result.append("[1701004=" + get_1701004() + "]\n");
        result.append("[1701005=" + get_1701005() + "]\n");
        result.append("[1701006=" + get_1701006() + "]\n");
        result.append("[1701007=" + get_1701007() + "]\n");
        result.append("[1701008=" + get_1701008() + "]\n");
        result.append("[1701009=" + get_1701009() + "]\n");

        result.append("[1701010=" + get_1701010() + "]\n");
        result.append("[1701011=" + get_1701011() + "]\n");
        result.append("[1701012=" + get_1701012() + "]\n");
        result.append("[1701013=" + get_1701013() + "]\n");
        result.append("[1701014=" + get_1701014() + "]\n");
        result.append("[1701015=" + get_1701015() + "]\n");
        result.append("[1701016=" + get_1701016() + "]\n");
        result.append("[1701017=" + get_1701017() + "]\n");
        result.append("[1701018=" + get_1701018() + "]\n");
        result.append("[1701019=" + get_1701019() + "]\n");

        result.append("[1701020=" + get_1701020() + "]\n");
        result.append("[1701021=" + get_1701021() + "]\n");
        result.append("[1701022=" + get_1701022() + "]\n");
        result.append("[1701023=" + get_1701023() + "]\n");
        result.append("[1701024=" + get_1701024() + "]\n");
        result.append("[1701025=" + get_1701025() + "]\n");
        result.append("[1701026=" + get_1701026() + "]\n");
        result.append("[1701027=" + get_1701027() + "]\n");
        result.append("[1701028=" + get_1701028() + "]\n");
        result.append("[1701029=" + get_1701029() + "]\n");

        result.append("[1701030=" + get_1701030() + "]\n");
        result.append("[1701031=" + get_1701031() + "]\n");
        result.append("[1701032=" + get_1701032() + "]\n");
        result.append("[1701033=" + get_1701033() + "]\n");
        result.append("[1701034=" + get_1701034() + "]\n");
        result.append("[1701035=" + get_1701035() + "]\n");
        result.append("[1701036=" + get_1701036() + "]\n");
        result.append("[1701037=" + get_1701037() + "]\n");
        result.append("[1701038=" + get_1701038() + "]\n");
        result.append("[1701039=" + get_1701039() + "]\n");

        result.append("[1701040=" + get_1701040() + "]\n");
        result.append("[1701041=" + get_1701041() + "]\n");
        result.append("[1701042=" + get_1701042() + "]\n");
        result.append("[1701043=" + get_1701043() + "]\n");
        result.append("[1701044=" + get_1701044() + "]\n");
        result.append("[1701045=" + get_1701045() + "]\n");
        result.append("[1701046=" + get_1701046() + "]\n");
        result.append("[1701047=" + get_1701047() + "]\n");
        result.append("[1701048=" + get_1701048() + "]\n");
        result.append("[1701049=" + get_1701049() + "]\n");
        
        result.append("[1701050=" + get_1701050() + "]\n");
        result.append("[1701051=" + get_1701051() + "]\n");
        result.append("[1701052=" + get_1701052() + "]\n");
        result.append("[1701053=" + get_1701053() + "]\n");
        result.append("[1701054=" + get_1701054() + "]\n");
        result.append("[1701055=" + get_1701055() + "]\n");

        return result.toString();

    }
}
