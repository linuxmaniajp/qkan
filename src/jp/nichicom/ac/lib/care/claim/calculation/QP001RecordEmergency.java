
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
 * プログラム 緊急時施設療養レコード (QP001RecordEmergency)
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
public class QP001RecordEmergency extends QP001RecordAbstract {
	//交換情報識別番号4桁
	private String _401001 = "";
	//レコード種別コード2桁
	private static final String _401002 = "03";
	//サービス提供年月6桁(YYYYMM)
	private String _401003 = "";
	//事業所番号10桁
	private String _401004 = "";
	//証記載保険者番号8桁
	private String _401005 = "";
	//被保険者番号10桁
	private String _401006 = "";
	//緊急時施設療養情報レコード順次番号2桁
	private int _401007 = 0;
	//緊急時傷病名1 40桁
	private String _401008 = "";
	//緊急時傷病名2 40桁
	private String _401009 = "";
	//緊急時傷病名3 40桁
	private String _401010 = "";
	//緊急時治療開始年月日1 8桁(YYYYMMDD)
	private String _401011 = "";
	//緊急時治療開始年月日2 8桁(YYYYMMDD)
	private String _401012 = "";
	//緊急時治療開始年月日3 8桁(YYYYMMDD)
	private String _401013 = "";
	//往診日数2桁
	private int _401014 = 0;
	//往診医療機関名40桁
	private String _401015 = "";
	//通院日数2桁
	private int _401016 = 0;
	//通院医療機関名40桁
	private String _401017 = "";
	//緊急時治療管理単位数6桁
	private int _401018 = 0;
	//緊急時治療管理日数2桁
	private int _401019 = 0;
	//緊急時治療管理小計7桁
	private int _401020 = 0;
	//リハビリテーション点数7桁
	private int _401021 = 0;
	//処置点数7桁
	private int _401022 = 0;
	//手術点数7桁
	private int _401023 = 0;
	//麻酔点数7桁
	private int _401024 = 0;
	//放射線治療点数7桁
	private int _401025 = 0;
	//摘要1 64桁
	private String _401026 = "";
	//摘要2 64桁
	private String _401027 = "";
	//摘要3 64桁
	private String _401028	= "";
	//摘要4 64桁
	private String _401029 = "";
	//摘要5 64桁
	private String _401030 = "";
	//摘要6 64桁
	private String _401031 = "";
	//摘要7 64桁
	private String _401032 = "";
	//摘要8 64桁
	private String _401033 = "";
	//摘要9 64桁
	private String _401034 = "";
	//摘要10 64桁
	private String _401035 = "";
	//摘要11 64桁
	private String _401036 = "";
	//摘要12 64桁
	private String _401037 = "";
	//摘要13 64桁
	private String _401038 = "";
	//摘要14 64桁
	private String _401039 = "";
	//摘要15 64桁
	private String _401040 = "";
	//摘要16 64桁
	private String _401041 = "";
	//摘要17 64桁
	private String _401042 = "";
	//摘要18 64桁
	private String _401043 = "";
	//摘要19 64桁
	private String _401044 = "";
	//摘要20 64桁
	private String _401045 = "";
	//緊急時施設療養費合計点数8桁
	private int _401046 = 0;


	protected String getSerialId() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	/**
	 * レコード種別コード2桁を取得する。
	 * @return
	 */
	protected static String get_401002() {
		return _401002;
	}
	/**
	 * 交換情報識別番号4桁を取得する。
	 * @return
	 */
	protected String get_401001() {
		return _401001;
	}
	/**
	 * 交換情報識別番号4桁を設定する。
	 * @param _401001
	 */
	protected void set_401001(String _401001) {
		this._401001 = _401001;
	}
	/**
	 * サービス提供年月6桁(YYYYMM)を取得する。
	 * @return
	 */
	protected String get_401003() {
		return _401003;
	}
	/**
	 * サービス提供年月6桁(YYYYMM)を設定する。
	 * @param _401003
	 */
	protected void set_401003(String _401003) {
		this._401003 = _401003;
	}
	/**
	 * 事業所番号10桁を取得する。
	 * @return
	 */
	protected String get_401004() {
		return _401004;
	}
	/**
	 * 事業所番号10桁を設定する。
	 * @param _401004
	 */
	protected void set_401004(String _401004) {
		this._401004 = _401004;
	}
	/**
	 * 証記載保険者番号8桁を取得する。
	 */
	protected String get_401005() {
		return _401005;
	}
	/**
	 * 証記載保険者番号8桁を設定する。
	 * @param _401005
	 */
	protected void set_401005(String _401005) {
		this._401005 = _401005;
	}
	/**
	 * 被保険者番号10桁を取得する。
	 * @return
	 */
	protected String get_401006() {
		return _401006;
	}
	/**
	 * 被保険者番号10桁を設定する。
	 * @param _401006
	 */
	protected void set_401006(String _401006) {
		this._401006 = _401006;
	}
	/**
	 * 緊急時施設療養情報レコード順次番号2桁を取得する。
	 * @return
	 */
	protected int get_401007() {
		return _401007;
	}
	/**
	 * 緊急時施設療養情報レコード順次番号2桁を設定する。
	 * @param _401007
	 */
	protected void set_401007(int _401007) {
		this._401007 = _401007;
	}
	/**
	 * 緊急時傷病名1 40桁を取得する。
	 * @return
	 */
	protected String get_401008() {
		return _401008;
	}
	/**
	 * 緊急時傷病名1 40桁を設定する。
	 * @param _401008
	 */
	protected void set_401008(String _401008) {
		this._401008 = _401008;
	}
	/**
	 * 緊急時傷病名2 40桁を取得する。
	 * @return
	 */
	protected String get_401009() {
		return _401009;
	}
	/**
	 * 緊急時傷病名2 40桁を設定する。
	 * @param _401009
	 */
	protected void set_401009(String _401009) {
		this._401009 = _401009;
	}
	/**
	 * 緊急時傷病名3 40桁を取得する。
	 * @return
	 */
	protected String get_401010() {
		return _401010;
	}
	/**
	 * 緊急時傷病名3 40桁を設定する。
	 * @param _401010
	 */
	protected void set_401010(String _401010) {
		this._401010 = _401010;
	}
	/**
	 * 緊急時治療開始年月日1 8桁(YYYYMMDD)を取得する。
	 * @return
	 */
	protected String get_401011() {
		return _401011;
	}
	/**
	 * 緊急時治療開始年月日1 8桁(YYYYMMDD)を設定する。
	 * @param _401011
	 */
	protected void set_401011(String _401011) {
		this._401011 = _401011;
	}
	/**
	 * 緊急時治療開始年月日2 8桁(YYYYMMDD)を取得する。
	 * @return
	 */
	protected String get_401012() {
		return _401012;
	}
	/**
	 * 緊急時治療開始年月日2 8桁(YYYYMMDD)を設定する。
	 * @param _401012
	 */
	protected void set_401012(String _401012) {
		this._401012 = _401012;
	}
	/**
	 * 緊急時治療開始年月日3 8桁(YYYYMMDD)を取得する。
	 * @return
	 */
	protected String get_401013() {
		return _401013;
	}
	/**
	 * 緊急時治療開始年月日3 8桁(YYYYMMDD)を設定する。
	 * @param _401013
	 */
	protected void set_401013(String _401013) {
		this._401013 = _401013;
	}
	/**
	 * 往診日数2桁を取得する。
	 * @return
	 */
	protected int get_401014() {
		return _401014;
	}
	/**
	 * 往診日数2桁を設定する。
	 * @param _401014
	 */
	protected void set_401014(int _401014) {
		this._401014 = _401014;
	}
	/**
	 * 往診医療機関名40桁を取得する。
	 * @return
	 */
	protected String get_401015() {
		return _401015;
	}
	/**
	 * 往診医療機関名40桁を設定する。
	 * @param _401015
	 */
	protected void set_401015(String _401015) {
		this._401015 = _401015;
	}
	/**
	 * 通院日数2桁を取得する。
	 * @return
	 */
	protected int get_401016() {
		return _401016;
	}
	/**
	 * 通院日数2桁を設定する。
	 * @param _401016
	 */
	protected void set_401016(int _401016) {
		this._401016 = _401016;
	}
	/**
	 * 通院医療機関名40桁を取得する。
	 * @return
	 */
	protected String get_401017() {
		return _401017;
	}
	/**
	 * 通院医療機関名40桁を設定する。
	 * @param _401017
	 */
	protected void set_401017(String _401017) {
		this._401017 = _401017;
	}
	/**
	 * 緊急時治療管理単位数6桁を取得する。
	 * @return
	 */
	protected int get_401018() {
		return _401018;
	}
	/**
	 * 緊急時治療管理単位数6桁を設定する。
	 * @param _401018
	 */
	protected void set_401018(int _401018) {
		this._401018 = _401018;
	}
	/**
	 * 緊急時治療管理日数2桁を取得する。
	 * @return
	 */
	protected int get_401019() {
		return _401019;
	}
	/**
	 * 緊急時治療管理日数2桁を設定する。
	 * @param _401019
	 */
	protected void set_401019(int _401019) {
		this._401019 = _401019;
	}
	/**
	 * 緊急時治療管理小計7桁を取得する。
	 * @return
	 */
	protected int get_401020() {
		return _401020;
	}
	/**
	 * 緊急時治療管理小計7桁を設定する。
	 * @param _401020
	 */
	protected void set_401020(int _401020) {
		this._401020 = _401020;
	}
	/**
	 * リハビリテーション点数7桁を取得する。
	 * @return
	 */
	protected int get_401021() {
		return _401021;
	}
	/**
	 * リハビリテーション点数7桁を設定する。
	 * @param _401021
	 */
	protected void set_401021(int _401021) {
		this._401021 = _401021;
	}
	/**
	 * 処置点数7桁を取得する。
	 * @return
	 */
	protected int get_401022() {
		return _401022;
	}
	/**
	 * 処置点数7桁を設定する。
	 * @param _401022
	 */
	protected void set_401022(int _401022) {
		this._401022 = _401022;
	}
	/**
	 * 手術点数7桁を取得する。
	 * @return
	 */
	protected int get_401023() {
		return _401023;
	}
	/**
	 * 手術点数7桁を設定する。
	 * @param _401023
	 */
	protected void set_401023(int _401023) {
		this._401023 = _401023;
	}
	/**
	 * 麻酔点数7桁を取得する。
	 * @return
	 */
	protected int get_401024() {
		return _401024;
	}
	/**
	 * 麻酔点数7桁を設定する。
	 * @param _401024
	 */
	protected void set_401024(int _401024) {
		this._401024 = _401024;
	}
	/**
	 * 放射線治療点数7桁を取得する。
	 */
	protected int get_401025() {
		return _401025;
	}
	/**
	 * 放射線治療点数7桁を設定する。
	 * @param _401025
	 */
	protected void set_401025(int _401025) {
		this._401025 = _401025;
	}
	/**
	 * 摘要1 64桁を取得する。
	 * @return
	 */
	protected String get_401026() {
		return _401026;
	}
	/**
	 * 摘要1 64桁を設定する。
	 * @param _401026
	 */
	protected void set_401026(String _401026) {
		this._401026 = _401026;
	}
	/**
	 * 摘要2 64桁を取得する。
	 * @return
	 */
	protected String get_401027() {
		return _401027;
	}
	/**
	 * 摘要2 64桁を設定する。
	 * @param _401027
	 */
	protected void set_401027(String _401027) {
		this._401027 = _401027;
	}
	/**
	 * 摘要3 64桁を取得する。
	 * @return
	 */
	protected String get_401028() {
		return _401028;
	}
	/**
	 * 摘要3 64桁を設定する。
	 * @param _401028
	 */
	protected void set_401028(String _401028) {
		this._401028 = _401028;
	}
	/**
	 * 摘要4 64桁を取得する。
	 * @return
	 */
	protected String get_401029() {
		return _401029;
	}
	/**
	 * 摘要4 64桁を設定する。
	 * @param _401029
	 */
	protected void set_401029(String _401029) {
		this._401029 = _401029;
	}
	/**
	 * 摘要5 64桁を取得する。
	 * @return
	 */
	protected String get_401030() {
		return _401030;
	}
	/**
	 * 摘要5 64桁を設定する。
	 * @param _401030
	 */
	protected void set_401030(String _401030) {
		this._401030 = _401030;
	}
	/**
	 * 摘要6 64桁を取得する。
	 * @return
	 */
	protected String get_401031() {
		return _401031;
	}
	/**
	 * 摘要6 64桁を設定する。
	 * @param _401031
	 */
	protected void set_401031(String _401031) {
		this._401031 = _401031;
	}
	/**
	 * 摘要7 64桁を取得する。
	 * @return
	 */
	protected String get_401032() {
		return _401032;
	}
	/**
	 * 摘要7 64桁を設定する。
	 * @param _401032
	 */
	protected void set_401032(String _401032) {
		this._401032 = _401032;
	}
	/**
	 * 摘要8 64桁を取得する。
	 * @return
	 */
	protected String get_401033() {
		return _401033;
	}
	/**
	 * 摘要8 64桁を設定する。
	 * @param _401033
	 */
	protected void set_401033(String _401033) {
		this._401033 = _401033;
	}
	/**
	 * 摘要9 64桁を取得する。
	 * @return
	 */
	protected String get_401034() {
		return _401034;
	}
	/**
	 * 摘要9 64桁を設定する。
	 * @param _401034
	 */
	protected void set_401034(String _401034) {
		this._401034 = _401034;
	}
	/**
	 * 摘要10 64桁を取得する。
	 * @return
	 */
	protected String get_401035() {
		return _401035;
	}
	/**
	 * 摘要10 64桁を設定する。
	 * @param _401035
	 */
	protected void set_401035(String _401035) {
		this._401035 = _401035;
	}
	/**
	 * 摘要11 64桁を取得する。
	 * @return
	 */
	protected String get_401036() {
		return _401036;
	}
	/**
	 * 摘要11 64桁を設定する。
	 * @param _401036
	 */
	protected void set_401036(String _401036) {
		this._401036 = _401036;
	}
	/**
	 * 摘要12 64桁を取得する。
	 * @return
	 */
	protected String get_401037() {
		return _401037;
	}
	/**
	 * 摘要12 64桁を設定する。
	 * @param _401037
	 */
	protected void set_401037(String _401037) {
		this._401037 = _401037;
	}
	/**
	 * 摘要13 64桁を取得する。
	 * @return
	 */
	protected String get_401038() {
		return _401038;
	}
	/**
	 * 摘要13 64桁を設定する。
	 * @param _401038
	 */
	protected void set_401038(String _401038) {
		this._401038 = _401038;
	}
	/**
	 * 摘要14 64桁を取得する。
	 * @return
	 */
	protected String get_401039() {
		return _401039;
	}
	/**
	 * 摘要14 64桁を設定する。
	 * @param _401039
	 */
	protected void set_401039(String _401039) {
		this._401039 = _401039;
	}
	/**
	 * 摘要15 64桁を取得する。
	 * @return
	 */
	protected String get_401040() {
		return _401040;
	}
	/**
	 * 摘要15 64桁を設定する。
	 * @param _401040
	 */
	protected void set_401040(String _401040) {
		this._401040 = _401040;
	}
	/**
	 * 摘要16 64桁を取得する。
	 * @return
	 */
	protected String get_401041() {
		return _401041;
	}
	/**
	 * 摘要16 64桁を設定する。
	 * @param _401041
	 */
	protected void set_401041(String _401041) {
		this._401041 = _401041;
	}
	/**
	 * 摘要17 64桁を取得する。
	 * @return
	 */
	protected String get_401042() {
		return _401042;
	}
	/**
	 * 摘要17 64桁を設定する。
	 * @param _401042
	 */
	protected void set_401042(String _401042) {
		this._401042 = _401042;
	}
	/**
	 * 摘要18 64桁を取得する。
	 * @return
	 */
	protected String get_401043() {
		return _401043;
	}
	/**
	 * 摘要18 64桁を設定する。
	 * @param _401043
	 */
	protected void set_401043(String _401043) {
		this._401043 = _401043;
	}
	/**
	 * 摘要19 64桁を取得する。
	 * @return
	 */
	protected String get_401044() {
		return _401044;
	}
	/**
	 * 摘要19 64桁を設定する。
	 * @param _401044
	 */
	protected void set_401044(String _401044) {
		this._401044 = _401044;
	}
	/**
	 * 摘要20 64桁を取得する。
	 * @return
	 */
	protected String get_401045() {
		return _401045;
	}
	/**
	 * 摘要20 64桁を設定する。
	 * @param _401045
	 */
	protected void set_401045(String _401045) {
		this._401045 = _401045;
	}
	/**
	 * 緊急時施設療養費合計点数8桁を取得する。
	 * @return
	 */
	protected int get_401046() {
		return _401046;
	}
	/**
	 * 緊急時施設療養費合計点数8桁を設定する。
	 * @param _401046
	 */
	protected void set_401046(int _401046) {
		this._401046 = _401046;
	}
	/**
	 * 既に情報が登録されているか返却します。
	 * @return 新規:true 追加:false
	 */
	private boolean isNew(){
		//交換情報レコードに登録が無ければ新規とみなす。
		return ((get_401001() == null) || ("".equals(get_401001())));
	}

	/**
	 * データのパースを実行します。
	 * @param serviceDetail
	 * @param targetDate
	 * @param patientState
	 * @param serviceCode
	 * @throws Exception
	 */
	protected void parse(
			VRMap serviceDetail,
			Date targetDate,
			QP001PatientState patientState,
            VRMap serviceCode,
			String identificationNo,
            QP001Manager manager) throws Exception {
		
		Object targetServiceDate = VRBindPathParser.get("SERVICE_DATE",serviceDetail);
		if(isNew()){
			//type の KEY : 401001(交換情報識別番号4桁) に VALUE : 第６引数を設定する。
			set_401001(identificationNo);
  		
			
			//type の KEY : 401003(サービス提供年月) に
			//VALUE : yyyyMM形式にフォーマットしたtargetDateを設定する。
			set_401003(VRDateParser.format(targetDate,"yyyyMM"));
  		
			//type の KEY : 401004(事業所番号) に
			//VALUE : 10桁フォーマットした事業所番号(serviceDetailより取得)を設定する。
			set_401004(ACCastUtilities.toString(VRBindPathParser.get("PROVIDER_ID",serviceDetail)));
  		
			//type の KEY : 401005(証記載保険者番号) に
			//VALUE : 8桁フォーマットした利用者の保険者番号(patientより取得)を設定する。
			set_401005(patientState.getInsurerId(targetServiceDate));
  		
			//type の KEY : 401006(被保険者番号) に
			//VALUE : 10桁フォーマットした利用者の被保険者番号(patientより取得)を設定する。
			set_401006(patientState.getInsuredId(targetServiceDate));
			//レコード順次番号
			set_401007(99);
			//緊急治療管理単位数
			//set_401018(QP001Manager.getInstance().getServiceUnit(get_401004(),serviceCode));
            set_401018(manager.getServiceUnit(get_401004(),serviceCode));
			//緊急時治療管理日数
			set_401019(1);

			
		} else {
			//緊急時治療管理日数に１を加える。
			set_401019(get_401019() + 1);
		}
		
	}
	
	/**
	 * レコード内容の確定を行う。
	 */
	protected void commitRecord() throws Exception {
        set_401007(99);
		//合計を算出する。
		set_401020(get_401018() * get_401019());
        
        //総合計を算出する。
//        set_401046(get_401020()
//                + get_401021()
//                + get_401022()
//                + get_401023()
//                + get_401024()
//                + get_401025());
        //401020は再掲なので合計に含めてはいけない。
        set_401046(get_401021()
                + get_401022()
                + get_401023()
                + get_401024()
                + get_401025());
        
	}
	
	/**
	 * データ作成
	 * @param style
	 * @return
	 */
	protected VRMap getRecord(VRMap style) throws Exception {
		VRMap result = copyStyle(style);
		
		setData(result,"401001",get_401001());
		setData(result,"401002",get_401002());
		setData(result,"401003",get_401003());
		setData(result,"401004",get_401004());
		setData(result,"401005",get_401005());
		setData(result,"401006",get_401006());
		setData(result,"401007",get_401007());
		setData(result,"401008",get_401008());
		setData(result,"401009",get_401009());
		
		setData(result,"401010",get_401010());
		setData(result,"401011",get_401011());
		setData(result,"401012",get_401012());
		setData(result,"401013",get_401013());
		setData(result,"401014",get_401014());
		setData(result,"401015",get_401015());
		setData(result,"401016",get_401016());
		setData(result,"401017",get_401017());
		setData(result,"401018",get_401018());
		setData(result,"401019",get_401019());

		setData(result,"401020",get_401020());
		setData(result,"401021",get_401021());
		setData(result,"401022",get_401022());
		setData(result,"401023",get_401023());
		setData(result,"401024",get_401024());
		setData(result,"401025",get_401025());
		setData(result,"401026",get_401026());
		setData(result,"401027",get_401027());
		setData(result,"401028",get_401028());
		setData(result,"401029",get_401029());
		
		setData(result,"401030",get_401030());
		setData(result,"401031",get_401031());
		setData(result,"401032",get_401032());
		setData(result,"401033",get_401033());
		setData(result,"401034",get_401034());
		setData(result,"401035",get_401035());
		setData(result,"401036",get_401036());
		setData(result,"401037",get_401037());
		setData(result,"401038",get_401038());
		setData(result,"401039",get_401039());
		
		setData(result,"401040",get_401040());
		setData(result,"401041",get_401041());
		setData(result,"401042",get_401042());
		setData(result,"401043",get_401043());
		setData(result,"401044",get_401044());
		setData(result,"401045",get_401045());
		setData(result,"401046",get_401046());
		
		return result;
	}
	
	private VRMap copyStyle(VRMap style){
		VRMap result = new VRHashMap();
		Object key;
		//ディープコピー
		Iterator it = style.keySet().iterator();
		while(it.hasNext()){
			key = it.next();
			result.put(key,style.get(key));
		}
		//緊急時施設療養情報レコード
		//result.put("CATEGORY_NO","4");
        result.put("CATEGORY_NO",QkanConstants.CATEGORY_NO_RECORD_EMERGENCY_INSTITUTION);
		return result;
	}
	
	public String toString(){
		StringBuilder result = new StringBuilder();
		result.append("[401001=" + get_401001() + "]\n");
		result.append("[401002=" + get_401002() + "]\n");
		result.append("[401003=" + get_401003() + "]\n");
		result.append("[401004=" + get_401004() + "]\n");
		result.append("[401005=" + get_401005() + "]\n");
		result.append("[401006=" + get_401006() + "]\n");
		result.append("[401007=" + get_401007() + "]\n");
		result.append("[401008=" + get_401008() + "]\n");
		result.append("[401009=" + get_401009() + "]\n");
		
		result.append("[401010=" + get_401010() + "]\n");
		result.append("[401011=" + get_401011() + "]\n");
		result.append("[401012=" + get_401012() + "]\n");
		result.append("[401013=" + get_401013() + "]\n");
		result.append("[401014=" + get_401014() + "]\n");
		result.append("[401015=" + get_401015() + "]\n");
		result.append("[401016=" + get_401016() + "]\n");
		result.append("[401017=" + get_401017() + "]\n");
		result.append("[401018=" + get_401018() + "]\n");
		result.append("[401019=" + get_401019() + "]\n");

		result.append("[401020=" + get_401020() + "]\n");
		result.append("[401021=" + get_401021() + "]\n");
		result.append("[401022=" + get_401022() + "]\n");
		result.append("[401023=" + get_401023() + "]\n");
		result.append("[401024=" + get_401024() + "]\n");
		result.append("[401025=" + get_401025() + "]\n");
		result.append("[401026=" + get_401026() + "]\n");
		result.append("[401027=" + get_401027() + "]\n");
		result.append("[401028=" + get_401028() + "]\n");
		result.append("[401029=" + get_401029() + "]\n");
		
		result.append("[401030=" + get_401030() + "]\n");
		result.append("[401031=" + get_401031() + "]\n");
		result.append("[401032=" + get_401032() + "]\n");
		result.append("[401033=" + get_401033() + "]\n");
		result.append("[401034=" + get_401034() + "]\n");
		result.append("[401035=" + get_401035() + "]\n");
		result.append("[401036=" + get_401036() + "]\n");
		result.append("[401037=" + get_401037() + "]\n");
		result.append("[401038=" + get_401038() + "]\n");
		result.append("[401039=" + get_401039() + "]\n");
		
		result.append("[401040=" + get_401040() + "]\n");
		result.append("[401041=" + get_401041() + "]\n");
		result.append("[401042=" + get_401042() + "]\n");
		result.append("[401043=" + get_401043() + "]\n");
		result.append("[401044=" + get_401044() + "]\n");
		result.append("[401045=" + get_401045() + "]\n");
		result.append("[401046=" + get_401046() + "]\n");
		
		return result.toString();
		
	}
}
