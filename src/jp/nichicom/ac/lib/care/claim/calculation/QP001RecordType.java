
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
 * プログラム 集計情報レコード (QP001RecordType)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;
import jp.nichicom.ac.lib.care.claim.calculation.QP001SjClaimCalc.KohiyusenType;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon; //20140210 add
import jp.nichicom.ac.lib.care.claim.servicecode.QkanSjLimitOverUnitException;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanSjServiceCodeManager;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanSjTankaManager;

/**
 * 集計情報レコード
 * @author shin fujihara
 *
 */
public class QP001RecordType extends QP001RecordAbstract {

	//交換情報識別番号4桁
	private String _701001 = "";
	//レコード種別コード2桁
	private static final String _701002 = "10";
	//サービス提供年月6桁(YYYYMM)
	private String _701003 = "";
	//事業所番号10桁
	private String _701004 = "";
	//証記載保険者番号8桁
	private String _701005 = "";
	//被保険者番号10桁
	private String _701006 = "";
	//サービス種類コード2桁
	private String _701007 = "";
	//サービス実日数2桁
	private int _701008 = 0;
	//計画単位数6桁
	private int _701009 = 0;
	//限度額管理対象単位数6桁
	private int _701010 = 0;
	//限度額管理対象外単位数6桁
	private int _701011 = 0;
	//短期入所計画日数2桁
	private int _701012 = 0;
	//短期入所実日数2桁
	private int _701013 = 0;
	//(保険)単位数合計8桁
	private int _701014 = 0;
	//(保険)単位数単価4桁
	private double _701015 = 0;
	//(保険)請求額9桁
	private int _701016 = 0;
	//(保険)利用者負担額8桁
	private int _701017 = 0;
	//(公費1)単位数合計6桁
	private int _701018 = 0;
	//(公費1)請求額9桁
	private int _701019 = 0;
	//(公費1)本人負担額6桁
	private int _701020 = 0;
	//(公費2)単位数合計6桁
	private int _701021 = 0;
	//(公費2)請求額9桁
	private int _701022 = 0;
	//(公費2)本人負担額6桁
	private int _701023 = 0;
	//(公費3)単位数合計6桁
	private int _701024 = 0;
	//(公費3)請求額9桁
	private int _701025 = 0;
	//(公費3)本人負担額6桁
	private int _701026 = 0;
	//(保険分出来高医療費)単位数合計8桁
	private int _701027 = 0;
	//(保険分出来高医療費)請求額9桁
	private int _701028 = 0;
	//(保険分出来高医療費)出来高医療費利用者負担額8桁
	private int _701029 = 0;
	//(公費1分出来高医療費)単位数合計8桁
	private int _701030 = 0;
	//(公費1分出来高医療費)請求額9桁
	private int _701031 = 0;
	//(公費1分出来高医療費)出来高医療費本人負担額8桁
	private int _701032 = 0;
	//(公費2分出来高医療費)単位数合計8桁
	private int _701033 = 0;
	//(公費2分出来高医療費)請求額9桁
	private int _701034 = 0;
	//(公費2分出来高医療費)出来高医療費本人負担額8桁
	private int _701035 = 0;
	//(公費3分出来高医療費)単位数合計8桁
	private int _701036 = 0;
	//(公費3分出来高医療費)請求額9桁
	private int _701037 = 0;
	//(公費3分出来高医療費)出来高医療費本人負担額8桁
	private int _701038 = 0;
	//サービス名称
	private String _701039 = "";
	//給付割合
	private int _701040 = 0;
	//公費１公費番号
	private String _701041 = "";
	//公費２公費番号
	private String _701042 = "";
	//公費３公費番号
	private String _701043 = "";	
	//システム内サービス種類コード(SYSTEM_SERVICE_KIND_DETAIL)
	//private String _701044 = "";
    private VRList _701044 = new VRArrayList();
	//システム内サービス項目コード(SYSTEM_SERVICE_CODE_ITEM)
	private String _701045 = "";
	
	//[ID:0000525][Shin Fujihara] 2009/07 add begin 2009年度対応
	//予定、または実績入力で入力された計画単位数
	private String _701046 = "";
	//[ID:0000525][Shin Fujihara] 2009/07 add end 2009年度対応

	// 2016/10/11 [Yoichiro Kamei] add - begin 総合事業対応
	//総合事業の区分支給超単位数
	private String _701047 = "";
	// 2016/10/11 [Yoichiro Kamei] add - end
	
	//サービス実日数
	private VRList serviceRealDays = new VRArrayList();
	//入所サービス実日数
	private VRList entranceRealDays = new VRArrayList();
    //退院(退所)実日数
    private VRList outEntranceRealDays = new VRArrayList();
	//公費適用パタン
	private VRMap kohiPattern = new VRHashMap();
    
    //外部利用型使用フラグ
    private boolean externalUse = false;
    
    /* 2006.06.02 小久保さんとのやり取りにより、対応しないことに
    //外部利用型未使用フラグ
    private boolean externalNoUse = false;
    */
    
    //[ID:0000699][Shin Fujihara] 2012/03 add begin 2012年度法改正対応
    //様式第六の三、様式第六の四の退避用限度額管理対象外単位数
    //※外部利用型以外の単位数積み上げ
    private int _701011_temp = 0;
    //[ID:0000699][Shin Fujihara] 2012/03 add end 2012年度法改正対応
    
    
    // 2016/10/11 [Yoichiro Kamei] add - begin 総合事業対応
    // 独自・独自定率、独自定額用の計算
    private QP001SjClaimCalc sjClaimCalc;
    
    /**
     * 総合事業の独自・独自定率・独自定額かどうかを返します。
     * @return
     */
    protected boolean isDokujiTeiritsuTeigaku() {
		if (QP001StyleAbstract.IDENTIFICATION_NO_2_3_201504.equals(get_701001())
				&& QkanSjServiceCodeManager.dokujiTeiritsuTeigakuKinds.contains(get_701007())) {
			return true;
		}
		return false;
    }

    /**
     * 総合事業の独自かどうかを返します。
     * @return
     */
    protected boolean isDokuji() {
		if (QP001StyleAbstract.IDENTIFICATION_NO_2_3_201504.equals(get_701001())
				&& QkanSjServiceCodeManager.dokujiKinds.contains(get_701007())) {
			return true;
		}
		return false;
    }
    
    /**
     * 総合事業の独自定率かどうかを返します。
     * @return
     */
    protected boolean isDokujiTeiritsu() {
		if (QP001StyleAbstract.IDENTIFICATION_NO_2_3_201504.equals(get_701001())
				&& QkanSjServiceCodeManager.teiritsuKinds.contains(get_701007())) {
			return true;
		}
		return false;
    }
    
    /**
     * 総合事業の独自定額かどうかを返します。
     * @return 
     */
    protected boolean isDokujiTeigaku() {
		if (QP001StyleAbstract.IDENTIFICATION_NO_2_3_201504.equals(get_701001())
				&& QkanSjServiceCodeManager.teigakuKinds.contains(get_701007())) {
			return true;
		}
		return false;
    }
    // 2016/10/11 [Yoichiro Kamei] add - end
    
	/**
	 * 交換情報識別番号4桁を取得する。
	 * @return
	 */
	protected String get_701001() {
		return _701001;
	}
	/**
	 * 交換情報識別番号4桁を設定する。
	 * @param _701001
	 */
	protected void set_701001(String _701001) {
		this._701001 = _701001;
	}	
	/**
	 * レコード種別コード2桁を取得する。
	 * @return
	 */
	protected static String get_701002() {
		return _701002;
	}
	/**
	 * サービス提供年月6桁(YYYYMM)を取得する。
	 * @return
	 */
	protected String get_701003() {
		return _701003;
	}
	/**
	 * サービス提供年月6桁(YYYYMM)を設定する。
	 * @param _701003
	 */
	protected void set_701003(String _701003) {
		this._701003 = _701003;
	}
	/**
	 * 事業所番号10桁を取得する。
	 * @return
	 */
	protected String get_701004() {
		return _701004;
	}
	/**
	 * 事業所番号10桁を設定する。
	 * @param _701004
	 */
	protected void set_701004(String _701004) {
		this._701004 = _701004;
	}
	/**
	 * 証記載保険者番号8桁を取得する。
	 * @return
	 */
	protected String get_701005() {
		return _701005;
	}
	/**
	 * 証記載保険者番号8桁を設定する。
	 * @param _701005
	 */
	protected void set_701005(String _701005) {
		this._701005 = _701005;
	}
	/**
	 * 被保険者番号10桁を取得する。
	 * @return
	 */
	protected String get_701006() {
		return _701006;
	}
	/**
	 * 被保険者番号10桁を設定する。
	 * @param _701006
	 */
	protected void set_701006(String _701006) {
		this._701006 = _701006;
	}
	/**
	 * サービス種類コード2桁を取得する。
	 * @return
	 */
	protected String get_701007() {
		return _701007;
	}
	/**
	 * サービス種類コード2桁を設定する。
	 * @param _701007
	 */
	protected void set_701007(String _701007) {
		this._701007 = _701007;
	}
	/**
	 * サービス実日数2桁を取得する。
	 * @return
	 */
	protected int get_701008() {
		return _701008;
	}
	/**
	 * サービス実日数2桁を設定する。
	 * @param _701008
	 */
	protected void set_701008(int _701008) {
		this._701008 = _701008;
	}
	/**
	 * 計画単位数6桁を取得する。
	 * @return
	 */
	protected int get_701009() {
		return _701009;
	}
	/**
	 * 計画単位数6桁を設定する。
	 * @param _701009
	 */
	protected void set_701009(int _701009) {
		this._701009 = _701009;
	}
	/**
	 * 限度額管理対象単位数6桁を取得する。
	 * @return
	 */
	protected int get_701010() {
		return _701010;
	}
	/**
	 * 限度額管理対象単位数6桁を設定する。
	 * @param _701010
	 */
	protected void set_701010(int _701010) {
		this._701010 = _701010;
	}
	/**
	 * 限度額管理対象外単位数6桁を取得する。
	 * @return
	 */
	protected int get_701011() {
		return _701011;
	}
	/**
	 * 限度額管理対象外単位数6桁を設定する。
	 * @param _701011
	 */
	protected void set_701011(int _701011) {
		this._701011 = _701011;
	}
	/**
	 * 短期入所計画日数2桁を取得する。
	 * @return
	 */
	protected int get_701012() {
		return _701012;
	}
	/**
	 * 短期入所計画日数2桁を設定する。
	 * @param _701012
	 */
	protected void set_701012(int _701012) {
		this._701012 = _701012;
	}
	/**
	 * 短期入所実日数2桁を取得する。
	 * @return
	 */
	protected int get_701013() {
		return _701013;
	}
	/**
	 * 短期入所実日数2桁を設定する。
	 * @param _701013
	 */
	protected void set_701013(int _701013) {
		this._701013 = _701013;
	}
	/**
	 * (保険)単位数合計8桁を取得する。
	 * @return
	 */
	protected int get_701014() {
		return _701014;
	}
	/**
	 * (保険)単位数合計8桁を設定する。
	 * @param _701014
	 */
	protected void set_701014(int _701014) {
		this._701014 = _701014;
	}
	/**
	 * (保険)単位数単価4桁を取得する。
	 * @return
	 */
	protected double get_701015() {
		return _701015;
	}
	/**
	 * (保険)単位数単価4桁を設定する。
	 * @param _701015
	 */
	protected void set_701015(double _701015) {
		this._701015 = _701015;
	}
	/**
	 * (保険)請求額9桁を取得する
	 * @return
	 */
	protected int get_701016() {
		return _701016;
	}
	/**
	 * (保険)請求額9桁を設定する。
	 * @param _701016
	 */
	protected void set_701016(int _701016) {
		this._701016 = _701016;
	}
	/**
	 * (保険)利用者負担額8桁を取得する。
	 * @return
	 */
	protected int get_701017() {
		return _701017;
	}
	/**
	 * (保険)利用者負担額8桁を設定する。
	 * @param _701017
	 */
	protected void set_701017(int _701017) {
		this._701017 = _701017;
	}
	/**
	 * (公費1)単位数合計6桁を取得する。
	 * @return
	 */
	protected int get_701018() {
		return _701018;
	}
	/**
	 * (公費1)単位数合計6桁を設定する。
	 * @param _701018
	 */
	protected void set_701018(int _701018) {
		this._701018 = _701018;
	}
	/**
	 * (公費1)請求額9桁を取得する。
	 * @return
	 */
	protected int get_701019() {
		return _701019;
	}
	/**
	 * (公費1)請求額9桁を設定する。
	 * @param _701019
	 */
	protected void set_701019(int _701019) {
		this._701019 = _701019;
	}
	/**
	 * (公費1)本人負担額6桁を取得する。
	 * @return
	 */
	protected int get_701020() {
		return _701020;
	}
	/**
	 * (公費1)本人負担額6桁を設定する。
	 * @param _701020
	 */
	protected void set_701020(int _701020) {
		this._701020 = _701020;
	}
	/**
	 * (公費2)単位数合計6桁を取得する。
	 * @return
	 */
	protected int get_701021() {
		return _701021;
	}
	/**
	 * (公費2)単位数合計6桁を設定する。
	 * @param _701021
	 */
	protected void set_701021(int _701021) {
		this._701021 = _701021;
	}
	/**
	 * (公費2)請求額9桁を取得する。
	 * @return
	 */
	protected int get_701022() {
		return _701022;
	}
	/**
	 * (公費2)請求額9桁を設定する。
	 * @param _701022
	 */
	protected void set_701022(int _701022) {
		this._701022 = _701022;
	}
	/**
	 * (公費2)本人負担額6桁を取得する。
	 * @return
	 */
	protected int get_701023() {
		return _701023;
	}
	/**
	 * (公費2)本人負担額6桁を設定する。
	 * @param _701023
	 */
	protected void set_701023(int _701023) {
		this._701023 = _701023;
	}
	/**
	 * (公費3)単位数合計6桁を取得する。
	 * @return
	 */
	protected int get_701024() {
		return _701024;
	}
	/**
	 * (公費3)単位数合計6桁を設定する。
	 * @param _701024
	 */
	protected void set_701024(int _701024) {
		this._701024 = _701024;
	}
	/**
	 * (公費3)請求額9桁を取得する。
	 * @return
	 */
	protected int get_701025() {
		return _701025;
	}
	/**
	 * (公費3)請求額9桁を設定する。
	 * @param _701025
	 */
	protected void set_701025(int _701025) {
		this._701025 = _701025;
	}
	/**
	 * (公費3)本人負担額6桁を取得する。
	 * @return
	 */
	protected int get_701026() {
		return _701026;
	}
	/**
	 * (公費3)本人負担額6桁を設定する。
	 * @param _701026
	 */
	protected void set_701026(int _701026) {
		this._701026 = _701026;
	}
	/**
	 * (保険分出来高医療費)単位数合計8桁を取得する。
	 * @return
	 */
	protected int get_701027() {
		return _701027;
	}
	/**
	 * (保険分出来高医療費)単位数合計8桁を設定する。
	 * @param _701027
	 */
	protected void set_701027(int _701027) {
		this._701027 = _701027;
	}
	/**
	 * (保険分出来高医療費)請求額9桁を取得する。
	 * @return
	 */
	protected int get_701028() {
		return _701028;
	}
	/**
	 * (保険分出来高医療費)請求額9桁を設定する。
	 * @param _701028
	 */
	protected void set_701028(int _701028) {
		this._701028 = _701028;
	}
	/**
	 * (保険分出来高医療費)出来高医療費利用者負担額8桁を取得する。
	 * @return
	 */
	protected int get_701029() {
		return _701029;
	}
	/**
	 * (保険分出来高医療費)出来高医療費利用者負担額8桁を設定する。
	 * @param _701029
	 */
	protected void set_701029(int _701029) {
		this._701029 = _701029;
	}
	/**
	 * (公費1分出来高医療費)単位数合計8桁を取得する。
	 * @return
	 */
	protected int get_701030() {
		return _701030;
	}
	/**
	 * (公費1分出来高医療費)単位数合計8桁を設定する。
	 * @param _701030
	 */
	protected void set_701030(int _701030) {
		this._701030 = _701030;
	}
	/**
	 * (公費1分出来高医療費)請求額9桁を取得する。
	 * @return
	 */
	protected int get_701031() {
		return _701031;
	}
	/**
	 * (公費1分出来高医療費)請求額9桁を設定する。
	 * @param _701031
	 */
	protected void set_701031(int _701031) {
		this._701031 = _701031;
	}
	/**
	 * (公費1分出来高医療費)出来高医療費本人負担額8桁を取得する。
	 * @return
	 */
	protected int get_701032() {
		return _701032;
	}
	/**
	 * (公費1分出来高医療費)出来高医療費本人負担額8桁を設定する。
	 * @param _701032
	 */
	protected void set_701032(int _701032) {
		this._701032 = _701032;
	}
	/**
	 * (公費2分出来高医療費)単位数合計8桁を取得する。
	 * @return
	 */
	protected int get_701033() {
		return _701033;
	}
	/**
	 * (公費2分出来高医療費)単位数合計8桁を設定する。
	 * @param _701033
	 */
	protected void set_701033(int _701033) {
		this._701033 = _701033;
	}
	/**
	 * (公費2分出来高医療費)請求額9桁を取得する。
	 * @return
	 */
	protected int get_701034() {
		return _701034;
	}
	/**
	 * (公費2分出来高医療費)請求額9桁を設定する。
	 * @param _701034
	 */
	protected void set_701034(int _701034) {
		this._701034 = _701034;
	}
	/**
	 * (公費2分出来高医療費)出来高医療費本人負担額8桁を取得する。
	 * @return
	 */
	protected int get_701035() {
		return _701035;
	}
	/**
	 * (公費2分出来高医療費)出来高医療費本人負担額8桁を設定する。
	 * @param _701035
	 */
	protected void set_701035(int _701035) {
		this._701035 = _701035;
	}
	/**
	 * (公費3分出来高医療費)単位数合計8桁を取得する。
	 * @return
	 */
	protected int get_701036() {
		return _701036;
	}
	/**
	 * (公費3分出来高医療費)単位数合計8桁を設定する。
	 * @param _701036
	 */
	protected void set_701036(int _701036) {
		this._701036 = _701036;
	}
	/**
	 * (公費3分出来高医療費)請求額9桁を取得する。
	 * @return
	 */
	protected int get_701037() {
		return _701037;
	}
	/**
	 * (公費3分出来高医療費)請求額9桁を設定する。
	 * @param _701037
	 */
	protected void set_701037(int _701037) {
		this._701037 = _701037;
	}
	/**
	 * (公費3分出来高医療費)出来高医療費本人負担額8桁を取得する。
	 * @return
	 */
	protected int get_701038() {
		return _701038;
	}
	/**
	 * (公費3分出来高医療費)出来高医療費本人負担額8桁を設定する。
	 * @param _701038
	 */
	protected void set_701038(int _701038) {
		this._701038 = _701038;
	}
	/**
	 * サービス名称を取得する。
	 * @return
	 */
	protected String get_701039() {
		return _701039;
	}
	/**
	 * サービス名称を設定する。
	 * @param _701039
	 */
	protected void set_701039(String _701039) {
		this._701039 = _701039;
	}
	/**
	 * 給付割合を取得する。
	 * @return
	 */
	protected int get_701040() {
		return _701040;
	}
	/**
	 * 給付割合を設定する。
	 * @param _701040
	 */
	protected void set_701040(int _701040) {
		this._701040 = _701040;
	}
	/**
	 * 公費１公費番号を取得する。
	 * @return
	 */
	protected String get_701041() {
		return _701041;
	}
	/**
	 * 公費１公費番号を設定する。
	 * @param _701041
	 */
	protected void set_701041(String _701041) {
		this._701041 = _701041;
	}	
	/**
	 * 公費２公費番号を取得する。
	 * @return
	 */
	protected String get_701042() {
		return _701042;
	}
	/**
	 * 公費２公費番号を設定する。
	 * @param _701042
	 */
	protected void set_701042(String _701042) {
		this._701042 = _701042;
	}
	/**
	 * 公費３公費番号を取得する。
	 * @return
	 */
	protected String get_701043() {
		return _701043;
	}
	/**
	 * 公費３公費番号を設定する。
	 * @param _701043
	 */
	protected void set_701043(String _701043) {
		this._701043 = _701043;
	}
	/**
	 * システム内サービス種類コード(SYSTEM_SERVICE_KIND_DETAIL)を取得する。
	 * @return
	 */
	protected String get_701044() {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < _701044.size(); i++){
            result.append(String.valueOf(_701044.get(i)));
            result.append(",");
        }
		return result.toString();
	}
	/**
	 *システム内サービス種類コード(SYSTEM_SERVICE_KIND_DETAIL)を設定する。
	 * @param _701044
	 */
	protected void set_701044(String _701044) {
        if(!this._701044.contains(_701044)){
            this._701044.add(_701044);
        }
	}
	/**
	 * システム内サービス項目コード(SYSTEM_SERVICE_CODE_ITEM)を取得する。
	 * @return
	 */
	protected String get_701045() {
		return _701045;
	}
	/**
	 *システム内サービス項目コード(SYSTEM_SERVICE_CODE_ITEM)を設定する。
	 * @param _701044
	 */
	protected void set_701045(String _701045) {
		this._701045 = _701045;
	}
    
	//[ID:0000525][Shin Fujihara] 2009/07 add begin 2009年度対応
	/**
	 * システム内サービス項目コード(SYSTEM_SERVICE_CODE_ITEM)を取得する。
	 * @return
	 */
	protected String get_701046() {
		return _701046;
	}
	/**
	 *システム内サービス項目コード(SYSTEM_SERVICE_CODE_ITEM)を設定する。
	 * @param _701044
	 */
	protected void set_701046(String _701046) {
		this._701046 = _701046;
	}
	//[ID:0000525][Shin Fujihara] 2009/07 add end 2009年度対応
	
	
	// 2016/10/11 [Yoichiro Kamei] add - begin 総合事業対応
	/**
	 * 総合事業 区分支給超単位数の情報を取得する。
	 * @return
	 */
	protected String get_701047() {
		return _701047;
	}
	/**
	 * 総合事業 区分支給超単位数の情報を設定する。
	 * @param _701043
	 */
	protected void set_701047(String _701047) {
		this._701047 = _701047;
	}
	// 2016/10/11 [Yoichiro Kamei] add - end
	
	
    protected int get_701015Multiplies100() {
        BigDecimal temp = new BigDecimal(String.valueOf(get_701015()));
        temp = temp.multiply(new BigDecimal("100"));
        return temp.intValue();
    }
    
//    protected int getOutEntranceRealDays(){
//        return outEntranceRealDays.size();
//    }
    
    
    //[ID:0000699][Shin Fujihara] 2012/03 add begin 2012年度法改正対応
    //様式第六の三、様式第六の四の退避用限度額管理対象外単位数
    //※外部利用型以外の単位数積み上げ
    
    /**
     * 外部利用型以外の単位数（様式第六の三、様式第六の四用）を設定する。
     * @param _701011_temp
     */
    protected void set_701011_temp(int _701011_temp) {
        this._701011_temp = _701011_temp;
    }
    /**
     * 外部利用型以外の単位数（様式第六の三、様式第六の四用）を取得する。
     * @return
     */
    protected int get_701011_temp() {
        return _701011_temp;
    }
    //[ID:0000699][Shin Fujihara] 2012/03 add end 2012年度法改正対応

	private boolean isNew(){
		//交換情報レコードに登録が無ければ新規とみなす。
		return ((get_701001() == null) || ("".equals(get_701001())));
	}
	/**
	 * データの解析を実行する。
	 * @param detail
	 * @throws Exception
	 */
	protected void parse(QP001RecordDetail detail,QP001PatientState patientState,QP001Manager manager) throws Exception {
		
		/* 2006.06.02 小久保さんとのやり取りにより、対応しないことに
		if(detail.get_301020().equals("1")
				|| detail.get_301020().equals("2")){
			externalNoUse = true;
		}
		*/
		
		//新規登録の場合
		if(isNew()){
			//交換識別番号
			set_701001(detail.get_301001());
			//サービス提供年月
			set_701003(detail.get_301003());
			//事業所番号
			set_701004(detail.get_301004());
			//証記載保険者番号
			set_701005(detail.get_301005());
			//被保険者番号
			set_701006(detail.get_301006());
			//サービス種類コード
			set_701007(detail.get_301007());
			
            //限度額管理対象フラグが1(限度額管理対象)の場合
			if(detail.get_301020().equals("1")){
                //計画単位数
                set_701009(detail.get_301014());
				//限度額管理対象単位数
				set_701010(detail.get_301014());
                
            //限度額管理対象フラグが2(限度額管理対象外)の場合
			} else if(detail.get_301020().equals("2")){
			    //[ID:0000699][Shin Fujihara] 2012/03 edit begin 2012年度法改正対応
//				//限度額管理対象外単位数
//                set_701011(detail.get_301014());
			    
			    // 様式第六の三、六の四の例外処理
			    if (QP001StyleAbstract.IDENTIFICATION_NO_6_3_201204.equals(get_701001())
			        || QP001StyleAbstract.IDENTIFICATION_NO_6_4_201204.equals(get_701001())) {
			        set_701011_temp(detail.get_301014());
			        
			    } else {
	               //限度額管理対象外単位数
	                set_701011(detail.get_301014());
			    }
                //[ID:0000699][Shin Fujihara] 2012/03 edit end 2012年度法改正対応
                
            //限度額管理対象フラグが3(外部利用型)の場合
			} else if(detail.get_301020().equals("3")){
                //計画単位数
                set_701009(ACCastUtilities.toInt(patientState.getNinteiDataHeavy(get_701005(),get_701006(),"EXTERNAL_USE_LIMIT"),0));
                
                //限度額管理対象単位数
                set_701010(detail.get_301014());
                
                //外部利用型フラグをtrueにする
                externalUse = true;
                //[ID:0000525][Shin Fujihara] 2009/07 add begin 2009年度対応
                set_701046(String.valueOf(get_701009()));
                //[ID:0000525][Shin Fujihara] 2009/07 add end 2009年度対応
            }
			
			//短期入所計画日数
			set_701012(0);
			//短期入所実日数
			set_701013(0);
			
			//保険単位数合計
			set_701014(detail.get_301014());
			//単位数単価(double)
			set_701015(manager.getAreaUnitPrice(get_701004(),detail.get_301021(),get_701003()));
			
			// 2017/06 [Yoichiro Kamei] add - begin AF対応
			if (QkanSjServiceCodeManager.afKinds.contains(get_701007())) {
				// 保険者番号
				String insurerId;
				if (detail instanceof QP001RecordDetailJushotiTokurei) {
					insurerId = ((QP001RecordDetailJushotiTokurei) detail).get_1801018();
				} else {
					insurerId = ACCastUtilities.toString(detail.get_301005());
				}
				String systemServiceKindDetail = ACCastUtilities.toString(detail.get_301021());
				// 総合事業の単位数単価
				Double unitPrice = QkanSjTankaManager.getUnitPrice(insurerId,
						systemServiceKindDetail);
				// AFの保険者の単位数単価が0でなければ、こちらを使用する
				if (unitPrice != 0.0d) {
					set_701015(unitPrice);
				}
			}
			// 2017/06 [Yoichiro Kamei] add - end
			
			//detail の KEY : 701018((公費1)単位数合計)に
			//VALUE : type の KEY :301015(公費1対象サービス単位数)を設定する。
			set_701018(detail.get_301015());
			
			//detail の KEY : 701021((公費2)単位数合計)に
			//VALUE : type の KEY : 301016(公費2対象サービス単位数)を設定する。
			set_701021(detail.get_301016());
			
			//detail の KEY : 701024((公費3)単位数合計)に
			//VALUE : type の KEY : 301017(公費3対象サービス単位数)を設定する。
			set_701024(detail.get_301017());
			
			//給付割合を退避する
			set_701040(detail.get_301026());

			// 2016/10/11 [Yoichiro Kamei] add - begin 総合事業対応
			// 独自定率・独自定額の場合給付率は設定しない
			if (isDokujiTeiritsu() || isDokujiTeigaku()) {
				set_701040(0);
			}
			// 2016/10/11 [Yoichiro Kamei] add - end
			
//			//システム内のサービス種類コードを退避する
//			set_701044(detail.get_301021());
//			set_701045(detail.get_301022());
			
			// 2016/10/11 [Yoichiro Kamei] add - begin 総合事業対応
			if (isDokujiTeiritsuTeigaku()) {
				this.sjClaimCalc = new QP001SjClaimCalc(get_701007(), manager.getSogoLimitOverMap());
			}
			// 2016/10/11 [Yoichiro Kamei] add - end

		//既存情報が存在する場合
		} else {
            //外部利用型サービスでは無い場合
            if(!externalUse){
                //限度額管理対象フラグが1(限度額管理対象)の場合
                if(detail.get_301020().equals("1")){
                    //計画単位数
                    set_701009(get_701009() + detail.get_301014());
                    //限度額管理対象単位数
                    set_701010(get_701010() + detail.get_301014());
                    
                //限度額管理対象フラグが2(限度額管理対象外)の場合
                } else if(detail.get_301020().equals("2")){
                    //[ID:0000699][Shin Fujihara] 2012/03 edit begin 2012年度法改正対応
//                    //限度額管理対象外単位数
//                    set_701011(get_701011() + detail.get_301014());
                    
                    // 様式第六の三、六の四の例外処理
                    if (QP001StyleAbstract.IDENTIFICATION_NO_6_3_201204.equals(get_701001())
                        || QP001StyleAbstract.IDENTIFICATION_NO_6_4_201204.equals(get_701001())) {
                        set_701011_temp(get_701011_temp() + detail.get_301014());
                        
                    } else {
                       //限度額管理対象外単位数
                        set_701011(get_701011() + detail.get_301014());
                    }
                    //[ID:0000699][Shin Fujihara] 2012/03 edit end 2012年度法改正対応
                    
                //限度額管理対象フラグが3(外部利用型)の場合
                } else if(detail.get_301020().equals("3")){
                    //計画単位数
                    set_701009(ACCastUtilities.toInt(patientState.getNinteiDataHeavy(get_701005(),get_701006(),"EXTERNAL_USE_LIMIT"),0));
                    
                    //限度額管理対象単位数
                    //set_701011(get_701011() + detail.get_301014());
                    set_701010(get_701010() + get_701011() + detail.get_301014());
                    set_701011(0);
                    
                    //外部利用型フラグをtrueにする
                    externalUse = true;
                    
                    //[ID:0000525][Shin Fujihara] 2009/07 add begin 2009年度対応
                    set_701046(String.valueOf(get_701009()));
                    //[ID:0000525][Shin Fujihara] 2009/07 add end 2009年度対応
                }
            } else {
                //[ID:0000699][Shin Fujihara] 2012/03 add begin 2012年度法改正対応
//                //限度額管理対象単位数
//                set_701010(get_701010() + detail.get_301014());

// [H27.4改正対応][Yoichiro Kamei] 2015/05/14 mod - begin サービス提供体制強化加算は外部利用型外単位数に記載する
//                if (detail.isSyoguRecoed()) {
                if (detail.isSyoguRecoed() || detail.get_301020().equals("2")) {
// [H27.4改正対応][Yoichiro Kamei] 2015/05/14 mod - end

                    //限度額管理対象外単位数(以前の処理ではゼロクリアしているので、積み上げではなく設定)
                    set_701011_temp(get_701011_temp() + detail.get_301014());
                    
                } else {
                    //限度額管理対象単位数
                    set_701010(get_701010() + detail.get_301014());
                }
                //[ID:0000699][Shin Fujihara] 2012/03 add end 2012年度法改正対応
            }
            
			//保険単位数合計
			set_701014(get_701014() + detail.get_301014());
			//detail の KEY : 701018((公費1)単位数合計)に
			//VALUE : type の KEY :301015(公費1対象サービス単位数)を設定する。
			set_701018(get_701018() + detail.get_301015());
			
  		//detail の KEY : 701021((公費2)単位数合計)に
			//VALUE : type の KEY : 301016(公費2対象サービス単位数)を設定する。
			set_701021(get_701021() + detail.get_301016());
			
			//detail の KEY : 701024((公費3)単位数合計)に
			//VALUE : type の KEY : 301017(公費3対象サービス単位数)を設定する。
			set_701024(get_701024() + detail.get_301017());
			
		}
        //システム内のサービス種類コードを退避する
        set_701044(detail.get_301021());
        set_701045(detail.get_301022());
        
		//サービス実日数を転送
		for(int i = 0; i < detail.getRealDays().getDataSize(); i++){
			//未登録であれば
			if(!this.serviceRealDays.contains(detail.getRealDays().getData(i))){
				this.serviceRealDays.add(detail.getRealDays().getData(i));
			}
		}
        //入院（入所）実日数を転送
        for(int i = 0; i < detail.getHospitalizationDays().size(); i++){
            //未登録であれば
              if (!this.entranceRealDays.contains(detail.getHospitalizationDays().getData(i))) {
                this.entranceRealDays.add(detail.getHospitalizationDays().getData(i));
            }
        }
        //退院(退所)実日数を転送
        for(int i = 0; i < detail.getLeavingHospitalDays().size(); i++){
            //未登録であれば
              if (!this.outEntranceRealDays.contains(detail.getLeavingHospitalDays().getData(i))) {
                this.outEntranceRealDays.add(detail.getLeavingHospitalDays().getData(i));
            }
        }
        
		//公費パタンの転送(commit時計算用)
		//key:(公費１番号)(公費２番号)(公費３番号) value:SERVICE_UNIT,SERVICE_TIMES
		//ここで必用な情報は、どの公費適用パタンで、何単位分計算すればよいか
		Object key;
		Iterator it = detail.getKohiPattern().keySet().iterator();
		while(it.hasNext()){
			key = it.next();
			QP001RecordSupporterCalc pattern = (QP001RecordSupporterCalc)detail.getKohiPattern().getData(key);
			int value = 0;
			
// [Yoichiro Kamei] [公費関連修正] 2015/4/27 comment out - begin 使われていない処理をコメント化
//			//登録がある場合
//			if(kohiPattern.containsKey(key)){
//				value = ((Integer)kohiPattern.getData(key)).intValue();
//			}
//			value += pattern.getServiceUnitTotal();
// [Yoichiro Kamei] [公費関連修正] 2015/4/27 comment out - end
			
			kohiPattern.put(key,new Integer(value));
		}
		
		// 2016/10/11 [Yoichiro Kamei] add - begin 総合事業対応
		if (isDokujiTeiritsuTeigaku()) {
			this.sjClaimCalc.parseRecordDetail(detail);
		}
		// 2016/10/11 [Yoichiro Kamei] add - end
	}
	
	/**
	 * データの解析を実行する。
	 * @param diagnosis
	 * @throws Exception
	 */
	//[ID:0000523][Shin Fujihara] 2009/07 edit begin 2009年度対応
	//protected void parse(QP001RecordDiagnosis diagnosis,String[] kohi,QP001PatientState patientState) throws Exception {
	protected void parse(QP001RecordDiagnosis diagnosis,QP001KohiKey[] kohi,QP001PatientState patientState, QP001RecordNursing nursing) throws Exception {
	//[ID:0000523][Shin Fujihara] 2009/07 edit begin 2009年度対応
		if(diagnosis == null) return;
		//順次番号は99を期待
		if(diagnosis.get_501007() != 99) return;
		
        //detail の KEY : 701027((保険分出来高医療費)単位数合計)に
        //VALUE : diagnosis のレコード順次番号が99のデータの合計単位数を設定する。
        set_701027(diagnosis.get_501013());
        
        //利用者の状態により処理を分岐する
        //公費単独受給者の場合
        if(QP001SpecialCase.isSeihoOnly(get_701005())){
            //detail の KEY :701028((保険分出来高医療費)請求額)に VALUE : 0を設定する。
            set_701028(0);
        } else {
            //(保険分出来高医療費)請求額を算出する。
            set_701028( (int)Math.floor( (double)(get_701027() * 10 * get_701040()) / 100d));
        }
		
		//detail の KEY : 701030((公費1分出来高医療費)単位数合計) に VALUE : diagnosisの公費１合計単位数を設定する。
		set_701030(diagnosis.get_501016());
        //detail の KEY : 701033((公費2分出来高医療費)単位数合計) に VALUE : diagnosisの公費２合計単位数を設定する。
		set_701033(diagnosis.get_501019());
        //detail の KEY : 701036((公費3分出来高医療費)単位数合計) に VALUE : diagnosisの公費３合計単位数を設定する。
		set_701036(diagnosis.get_501022());
		
		//test change start fujihara
		/*
		int totalRate  = get_701027() * 10;
        
		int kohiRate1 = 0;
		int kohiRate2 = 0;
        int kohiRate3 = 0;
        
        kohiRate1 = ACCastUtilities.toInt(patientState.getKohiData(kohi[0],"BENEFIT_RATE",1),0);
        //公費1の適用があるか確認
        if(kohiRate1 != 0){
            //公費１給付率が100の場合
            if(kohiRate1 == 100){
                //detail の KEY : 701031((公費1分出来高医療費)請求額)に
                //VALUE : 高額医療合計金額-保険請求額を設定する。
                set_701031(totalRate - get_701028());
            } else {
                set_701031((int)Math.floor(totalRate * (kohiRate1 - get_701040()) / 100));                
            }
        }
        //公費の対象となる自己負担額が残っているか確認
        if(totalRate >= (get_701028() + get_701031())){
            kohiRate2 = ACCastUtilities.toInt(patientState.getKohiData(kohi[1],"BENEFIT_RATE",1),0);
            //公費2の適用があるか確認
            if(kohiRate2 != 0){
                //公費２の給付率が100の場合
                if(kohiRate2 == 100){
                    set_701034(totalRate - get_701028() - get_701031());
                } else {
                    set_701034((int)Math.floor(totalRate * (kohiRate2 - kohiRate1) / 100));
                }
            }
        }
        //公費の対象となる自己負担が残っているか確認
        if(totalRate >= (get_701028() + get_701031()) + get_701034()){
            kohiRate3 = ACCastUtilities.toInt(patientState.getKohiData(kohi[2],"BENEFIT_RATE",1),0);
            if(kohiRate3 != 0){
                if(kohiRate3 == 100){
                    set_701037(totalRate - get_701028() - get_701031() - get_701034());
                    
                } else {
                    set_701037((int)Math.floor(totalRate * (kohiRate3 - kohiRate2) / 100));
                }
            }
        }
        */
		int totalRate  = get_701027() * 10;
        
		int kohiRate1 = 0;
		int kohiRate2 = 0;
        int kohiRate3 = 0;
        int amendsRate = get_701040();
        
        kohiRate1 = ACCastUtilities.toInt(patientState.getKohiData(kohi[0],"BENEFIT_RATE",1),0);
        //公費1の適用があるか確認
// 2015/5/12 [Yoichiro Kamei] mod - begin 公費関連見直し
//        if(kohiRate1 != 0){
        if(kohiRate1 != 0 && get_701030() != 0){
// 2015/5/12 [Yoichiro Kamei] mod - end
        	//月途中公費を疑う
        	if (get_701027() == get_701030()) {
	            //公費１給付率が100の場合
	            if(kohiRate1 == 100){
	                //detail の KEY : 701031((公費1分出来高医療費)請求額)に
	                //VALUE : 高額医療合計金額-保険請求額を設定する。
	                set_701031(totalRate - get_701028());
	            } else {
	                set_701031((int)Math.floor(totalRate * (kohiRate1 - get_701040()) / 100));
// 2015/5/12 [Yoichiro Kamei] add - begin 公費関連見直し
	                amendsRate = kohiRate1;
// 2015/5/12 [Yoichiro Kamei] add - end
	            }
	            
	        //月途中公費の場合
        	} else {
        		set_701031((int)Math.floor(get_701030() * 10 * (kohiRate1 - amendsRate) / 100));
        		amendsRate = kohiRate1;
        	}
        }
        //公費の対象となる自己負担額が残っているか確認
        if(totalRate >= (get_701028() + get_701031())){
            kohiRate2 = ACCastUtilities.toInt(patientState.getKohiData(kohi[1],"BENEFIT_RATE",1),0);
            //公費2の適用があるか確認
// 2015/5/12 [Yoichiro Kamei] mod - begin 公費関連見直し
//            if(kohiRate2 != 0){
            if(kohiRate2 != 0 && get_701033() != 0){
// 2015/5/12 [Yoichiro Kamei] mod - end
            	//月途中を疑う
            	if (get_701027() == get_701033()) {
	                //公費２の給付率が100の場合
	                if(kohiRate2 == 100){
	                    set_701034(totalRate - get_701028() - get_701031());
	                } else {
	                    set_701034((int)Math.floor(totalRate * (kohiRate2 - kohiRate1) / 100));
// 2015/5/12 [Yoichiro Kamei] add - begin 公費関連見直し
	                    amendsRate = kohiRate2;
// 2015/5/12 [Yoichiro Kamei] add - end
	                }
	                
	            //月途中の場合
            	} else {
            		set_701034((int)Math.floor(get_701033() * 10 * (kohiRate2 - amendsRate) / 100));
            		amendsRate = kohiRate2;
            	}
            }
        }
        //公費の対象となる自己負担が残っているか確認
        if(totalRate >= (get_701028() + get_701031()) + get_701034()){
            kohiRate3 = ACCastUtilities.toInt(patientState.getKohiData(kohi[2],"BENEFIT_RATE",1),0);
// 2015/5/12 [Yoichiro Kamei] mod - begin 公費関連見直し
//            if(kohiRate3 != 0){
            if(kohiRate3 != 0 && get_701036() != 0){
// 2015/5/12 [Yoichiro Kamei] mod - end
            	//月途中を疑う
            	if (get_701027() == get_701036()) {
	                if(kohiRate3 == 100){
	                    set_701037(totalRate - get_701028() - get_701031() - get_701034());
	                    
	                } else {
	                    set_701037((int)Math.floor(totalRate * (kohiRate3 - kohiRate2) / 100));
	                }
            	} else {
            		set_701037((int)Math.floor(get_701036() * 10 * (kohiRate3 - amendsRate) / 100));
            	}
            }
        }
		//test change end fujihara
        
        //公費本人負担額の算出を行う
        int selfPay = 0; 
        //公費１の本人負担額を取得
        if(get_701031() != 0){
            
            selfPay = patientState.getKohiSelfPay(kohi[0],1);
            
            if(selfPay != 0){
                
                //本体報酬とみなして公費自己負担を算出するよう修正
            	//[ID:0000523][Shin Fujihara] 2009/07 edit begin 2009年度対応
                //selfPay = QP001SpecialCase.getApplicationIndividualPayment(get_701001(),get_701006(),selfPay,get_701020());
            	selfPay = QP001SpecialCase.getApplicationIndividualPayment(
            			get_701001(),
            			get_701006(),
            			selfPay,get_701020(),
            			kohi[0].getKohiType(),
            			nursing);
            	//[ID:0000523][Shin Fujihara] 2009/07 edit end 2009年度対応
                
                //公費１請求額と本人負担額を比較し、本人負担額が大きい場合
                if (get_701031() < selfPay) {
                    // 公費１本人負担額に公費１請求額を設定する
                    set_701032(get_701031());
                    // 公費１請求額を0とする
                    set_701031(0);
                    //使用した公費自己負担額を設定する。
                    patientState.setKohiSelfPayUse(kohi[0],get_701032());
                } else {
                    set_701032(selfPay);
                    set_701031(get_701031() - get_701032());
                    //使用した公費自己負担額を設定する。
                    patientState.setKohiSelfPayUse(kohi[0],selfPay);
                }
            }

        }
        //公費２の本人負担額を取得
        if(get_701034() != 0){
            selfPay = patientState.getKohiSelfPay(kohi[1],1);
            
            if(selfPay != 0){
                
                //本体報酬とみなして公費自己負担を算出するよう修正
            	//[ID:0000523][Shin Fujihara] 2009/07 edit begin 2009年度対応
                //selfPay = QP001SpecialCase.getApplicationIndividualPayment(get_701001(),get_701006(),selfPay,get_701023());
            	selfPay = QP001SpecialCase.getApplicationIndividualPayment(
            			get_701001(),
            			get_701006(),
            			selfPay,get_701023(), 
            			kohi[1].getKohiType(),
            			nursing);
                //[ID:0000523][Shin Fujihara] 2009/07 edit end 2009年度対応
            	
                //公費２請求額と本人負担額を比較し、本人負担が大きい場合
                if(get_701034() < selfPay){
                    //公費２本人負担額に公費２請求額を設定する。
                    set_701035(get_701034());
                    //公費２請求額を0とする
                    set_701034(0);
                    //使用した公費自己負担額を設定する。
                    patientState.setKohiSelfPayUse(kohi[1],get_701035());
                } else {
                    set_701035(selfPay);
                    set_701034(get_701034() - get_701035());
                    //使用した公費自己負担額を設定する。
                    patientState.setKohiSelfPayUse(kohi[1],selfPay);
                }
            }
        }
        //公費３の本人負担額を取得
        if(get_701037() != 0){
            selfPay = patientState.getKohiSelfPay(kohi[2],1);
            
            if(selfPay != 0){
                
                //本体報酬とみなして公費自己負担を算出するよう修正
            	//[ID:0000523][Shin Fujihara] 2009/07 edit begin 2009年度対応
                //selfPay = QP001SpecialCase.getApplicationIndividualPayment(get_701001(),get_701006(),selfPay,get_701026());
            	selfPay = QP001SpecialCase.getApplicationIndividualPayment(
            			get_701001(),
            			get_701006(),
            			selfPay,
            			get_701026(), 
            			kohi[2].getKohiType(),
            			nursing);
                //[ID:0000523][Shin Fujihara] 2009/07 edit end 2009年度対応
            	
                //公費３請求額と本人負担額を比較し、本人負担額が大きい場合
                if(get_701037() < selfPay){
                    //公費３本人負担額に公費３請求額を設定する。
                    set_701038(get_701037());
                    //公費３請求額を0とする
                    set_701037(0);
                    //使用した公費自己負担額を設定する。
                    patientState.setKohiSelfPayUse(kohi[2], get_701038());
                } else {
                    set_701038(selfPay);
                    set_701037(get_701037() - get_701038());
                    //使用した公費自己負担額を設定する。
                    patientState.setKohiSelfPayUse(kohi[2], selfPay);
                }
            }
        }
        
        //利用者負担額を設定する。
        set_701029(totalRate - get_701028() - get_701031() - get_701034() - get_701037()
                - get_701032() - get_701035() - get_701038());
        
        if(get_701029() < 0){
            //公費適用順位の低いものから利用者負担額分引く
            if(get_701037() > 0){
                set_701037(get_701037() + get_701029());
            } else {
                if(get_701034() > 0){
                    set_701034(get_701034() + get_701029());
                } else {
                    if(get_701031() > 0){
                        set_701031(get_701031() + get_701029());
                    }
                }
            }
            set_701029(0);
        }

	}
    
    /**
     * データの解析を実行する。
     * @param diagnosis
     * @throws Exception
     */
    protected void parse(QP001RecordEmergency emergency,QP001KohiKey[] kohi,QP001PatientState patientState) throws Exception {
        if(emergency == null) return;
        //順次番号は99を期待
        if(emergency.get_401007() != 99) return;
        
        //detail の KEY : 701027((保険分出来高医療費)単位数合計)に
        //VALUE : diagnosis のレコード順次番号が99のデータの合計単位数を設定する。
        set_701027(emergency.get_401046());
        
        //利用者の状態により処理を分岐する
        //公費単独受給者の場合
        if(QP001SpecialCase.isSeihoOnly(get_701005())){
            //detail の KEY :701028((保険分出来高医療費)請求額)に VALUE : 0を設定する。
            set_701028(0);
        } else {
            //(保険分出来高医療費)請求額を算出する。
            set_701028( (int)Math.floor( (double)(get_701027() * 10 * get_701040()) / 100d));
        }

    }
    
    /**
     * データの解析を実行する。
     * @param diagnosis
     * @throws Exception
     */
    protected void parse(QP001RecordEmergencyOwnFacility emergencyOwnFacility,QP001KohiKey[] kohi,QP001PatientState patientState) throws Exception {
        if(emergencyOwnFacility == null) return;
        //順次番号は99を期待
        if(emergencyOwnFacility.get_1701007() != 99) return;
        
        //detail の KEY : 701027((保険分出来高医療費)単位数合計)に
        //VALUE : diagnosis のレコード順次番号が99のデータの合計単位数を設定する。
        set_701027(emergencyOwnFacility.get_1701046());
        
        //利用者の状態により処理を分岐する
        //公費単独受給者の場合
        if(QP001SpecialCase.isSeihoOnly(get_701005())){
            //detail の KEY :701028((保険分出来高医療費)請求額)に VALUE : 0を設定する。
            set_701028(0);
        } else {
            //(保険分出来高医療費)請求額を算出する。
            set_701028( (int)Math.floor( (double)(get_701027() * 10 * get_701040()) / 100d));
        }

    }

	/**
	 * 集計情報確定処理
	 * @param kohi
	 * @throws Exception
	 */
	protected void commitRecord(QP001KohiKey kohi[],QP001PatientState patientState,VRMap styles,VRMap planUnitMap) throws Exception {
		commitRecord(kohi,patientState,styles,planUnitMap,null);
	}
    
	/**
	 * 集計情報確定処理
	 * @param kohi
	 * @throws Exception
	 */
	protected void commitRecord(QP001KohiKey kohi[],QP001PatientState patientState,VRMap styles,VRMap planUnitMap,QP001RecordNursing nursing) throws Exception {
		
        //計画単位数を取得
        int planUnit = getPlanUnit(styles, planUnitMap);
        
        //計画単位数が取得できた場合
        if(planUnit != 0){
            //計画単位数を上書きする
            set_701009(planUnit);
            //[ID:0000525][Shin Fujihara] 2009/07 add begin 2009年度対応
            set_701046(String.valueOf(planUnit));
            //[ID:0000525][Shin Fujihara] 2009/07 add end 2009年度対応
        }
        
        // 2016/10 [Yoichiro Kamei] add - begin 総合事業独自対応
        // 計画単位数と総合事業の区分支給超単位数の整合性チェック
        if (isDokujiTeiritsuTeigaku()) {
            int gendoTaishoUnit = get_701010();
            int limitOverUnit = this.sjClaimCalc.getTotalLimitOverUnit();
            
            if (planUnit > 0) {
                // 限度額管理対象単位数＞計画単位数のとき
                if (gendoTaishoUnit > planUnit) {
                    if (gendoTaishoUnit !=  (planUnit + limitOverUnit)) {
                        throw new QkanSjLimitOverUnitException(get_701007(), "区分支給超単位数の不整合");
                    }
                }
            } else if (planUnit == 0) {
                // 計画単位数が0だが調整額のみ設定されている場合
                if (limitOverUnit > 0) {
                    throw new QkanSjLimitOverUnitException(get_701007(), "区分支給超単位数の不整合");
                }
            }
        }
        // 2016/10 [Yoichiro Kamei] add - end
        
        // 計画単位数と限度額対象管理数の少ないほうを採用する
        int unit = get_701010();
        if(get_701009() < unit){
            unit = get_701009();
        }
        
        //[ID:0000699][Shin Fujihara] 2012/03 add begin 2012年度法改正対応
//        //給付単位数を設定する。
//        set_701014(unit + get_701011());
        //給付単位数を設定する。
        set_701014(unit + get_701011() + get_701011_temp());
        
        //外部利用型使用の場合、処遇改善単位数を転記
        if (externalUse) {
            set_701011(get_701011_temp());
        }
        //[ID:0000699][Shin Fujihara] 2012/03 add end 2012年度法改正対応
        
        //公費対象単位数を算出しなおす
        //公費１
        if(get_701018() > get_701014()){
            set_701018(get_701014());
        }
        //公費２
        if(get_701021() > get_701014()){
            set_701021(get_701014());
        }
        //公費３
        if(get_701024() > get_701014()){
            set_701024(get_701014());
        }
        
		//サービス実日数確定
		set_701008(this.serviceRealDays.getDataSize());
		//入所実日数確定
        //基本情報レコードで設定するよう変更
//		set_701013(this.entranceRealDays.getDataSize());

        // 2016/10/11 [Yoichiro Kamei] add - begin 総合事業対応
        if (isDokujiTeiritsuTeigaku()) {
            // 独自・独自定率・独自定額の計算
            this.sjClaimCalc.calculate();
        }
        // 2016/10/11 [Yoichiro Kamei] add - end
        
		//あとは、合算時に一括計算(commitRecord)
		//利用者の給付割合により処理を分岐する。
        //生保単独
        if(get_701006().toUpperCase().startsWith("H")){
            //detail の KEY : 701016((保険)請求額)に VALUE : 0を設定する。
            set_701016(0);
        } else {
            //set_701016( (int)Math.floor( Math.floor(get_701014() * get_701015() ) * ((double)get_701040() / 100d)));
            //対象単位数×単位数単価(小数点以下切捨て)
            int totalUnit = (int)Math.floor((double)(get_701014() * get_701015Multiplies100()) / 100d);
            //保険給付率
            totalUnit = (int)Math.floor((totalUnit * get_701040()) / 100d); 
            
            set_701016(totalUnit);
            
            // 2016/10/11 [Yoichiro Kamei] add - begin 総合事業対応
            if (isDokuji()) {
                set_701016(this.sjClaimCalc.getDokujiJigyohiSeikyugaku());
            } else if (isDokujiTeiritsu()) {
                set_701016(this.sjClaimCalc.getTeiritsuJigyohiSeikyugaku());
            }
            // 2016/10/11 [Yoichiro Kamei] add - end
        }
		
		//公費の算出を行う。
		Iterator it = kohiPattern.keySet().iterator();
		String key = "";
		int value = 0;
		int kohiRate = 0;
		int reduction = 0;
		int kohiClaim = 0;
		
//		//感染症公費計算フラグ add 2014/03/11
//		//感染症の場合本体に公費は適用されないが処遇改善加算にだけは適用できる
//		//この計算をした場合、自己負担計算は飛ばす必要がある
//		boolean kansenFlg = false;
//		String tmpKohiType = "0";
        
        set_701041("0");
        set_701042("0");
        set_701043("0");
        
// 2015/6/18 [Shinobu Hitaka] mod - begin 公費関連見直し（ループの範囲変更によりコメント化）
//		while(it.hasNext()){
//		    
//            //[CCCX:1470][Shinobu Hitaka] 2014/03/14 add - start 老健の一部公費対象の対応
//            tmpKohiType = key.replaceAll("-", "");
//            //[CCCX:1470][Shinobu Hitaka] 2014/03/14 add - end 老健の一部公費対象の対応
//            
//			key = String.valueOf(it.next());
//			
//			//[CCCX:1592][Shinobu Hitaka] 2014/03/09 edit - start 感染症公費の処遇改善加算対応
//			//del - start
//			//公費適用なしなら処理を行わない
//			//if("NONE".equalsIgnoreCase(key)) continue;
//			//del - end
//			//add - start
//			//公費適用なし＆kohi[0]が感染症の場合、特定診療費・特別療養費の処遇改善加算分だけ公費対応として計算する
//            if ("NONE".equalsIgnoreCase(key)) {
//                if (!ACTextUtilities.isNullText(kohi[0])) {
//                    if ("1001".equals(kohi[0].getKohiType()) && ("22".equals(get_701007()) || "23".equals(get_701007()) || "52".equals(get_701007()) || "53".equals(get_701007()) || "25".equals(get_701007()) || "26".equals(get_701007())) && (get_701018() != 0)) {
//                        //公費給付率を取得
//                        kohiRate = ACCastUtilities.toInt(patientState.getKohiData(kohi[0],"BENEFIT_RATE",1),0);
//                        //公費請求額を計算
//                        kohiClaim = getKohiClaim(get_701018(),kohiRate,0,get_701040(), 0);
//                        //detail の KEY : 701019((公費1)請求額)に値を設定する。
//                        set_701019(get_701019() + kohiClaim);
//                        //適用した公費を退避する。
//                        set_701041(kohi[0].getKohiType());
//                        //感染症公費計算フラグを設定
//                        kansenFlg = true;
//                    }
//                }
//                continue;
//            }
//            //
//            if (!("0".equals(tmpKohiType)) && CareServiceCommon.isKouhiService(get_701007(), tmpKohiType)) continue;
//            //add - end
//            //[CCCX:1592][Shinobu Hitaka] 2014/03/09 edit - end   感染症公費の処遇改善加算対応
//            
//// 2015/5/12 [Yoichiro Kamei] add - begin 公費関連見直し
//        //以下はkohiPatternのkeyを参照してないのでループ外にした
//		}
//// 2015/5/12 [Yoichiro Kamei] add - end
// 2015/6/18 [Shinobu Hitaka] mod - end 
        
        
			//減額を初期化
			reduction = 0;
			//適用対象の点数を取得
// [Yoichiro Kamei] [公費関連修正] 2015/4/27 comment out - begin 使われていない処理をコメント化
//			value = ((Integer)kohiPattern.getData(key)).intValue();
//			if(value > get_701014()){
//                value = get_701014();
//            }
// [Yoichiro Kamei] [公費関連修正] 2015/4/27 comment out - end
            
            //補償された割合
            int usedRate = get_701040();
            
            //老健公費適用フラグ add 2014/02/08
            boolean roukenFlg = false;
            
			//公費１が適用対象に含まれている場合
// 2015/5/12 [Yoichiro Kamei] mod - begin 公費関連見直し
//            if ((!ACTextUtilities.isNullText(kohi[0]) && key.indexOf(kohi[0]) != -1) 
//                    || (get_701018() != 0)){
			if ((!ACTextUtilities.isNullText(kohi[0]) && !"".equals(kohi[0].getKohiType())) 
			        || (get_701018() != 0)){
// 2015/5/12 [Yoichiro Kamei] mod - end
				//kohiRate = QP001Manager.getInstance().getBenefitRate(kohi[0]);
                kohiRate = ACCastUtilities.toInt(patientState.getKohiData(kohi[0],"BENEFIT_RATE",1),0);
                //お試し版
				//kohiClaim = getKohiClaim(value,kohiRate,0,usedRate);
                kohiClaim = getKohiClaim(get_701018(),kohiRate,0,usedRate, 0);
                
                // 2016/10/11 [Yoichiro Kamei] add - begin 総合事業対応
                if (isDokuji()) {
                    kohiClaim = this.sjClaimCalc.calcDokujiKohiSeikyugaku(KohiyusenType.KOHI1,
                            get_701014(), get_701018(), kohiRate, reduction, usedRate, 0);
                } else if (isDokujiTeiritsu()) {
                    //生保単独ではない場合
                    if (!get_701006().toUpperCase().startsWith("H")) {
                        usedRate = -1; //サービスの給付率を使用するため
                    }
                    kohiClaim = this.sjClaimCalc.calcTeiritsuKohiSeikyugaku(KohiyusenType.KOHI1,
                        get_701014(), get_701018(), kohiRate, reduction, usedRate, 0);
                } else if (isDokujiTeigaku()) {
                    kohiClaim = this.sjClaimCalc.getTeigakuKohi1Seikyugaku();
                }
                // 2016/10/11 [Yoichiro Kamei] add - end
                
				reduction += kohiClaim;
				//detail の KEY : 701019((公費1)請求額)に値を設定する。
				set_701019(get_701019() + kohiClaim);
                //適用した公費を退避する。
                set_701041(kohi[0].getKohiType());
                usedRate = kohiRate;
                
// 2015/6/18 [Shinobu Hitaka] del - begin 公費関連見直し（ループの範囲変更によりコメント化）
//                //[CCCX:1470][Shinobu Hitaka] 2014/02/07 edit - start 老健の一部公費対象の対応
//                //老健一部適用公費の場合は処理を終了しない
//				//公費1の給付率が100%の場合処理を終了する。
//				//if(kohiRate == 100) continue;
//                roukenFlg = CareServiceCommon.isKouhiService(get_701007(), kohi[0].getKohiType());
//// 2015/5/12 [Yoichiro Kamei] mod - begin 公費関連見直し
////                if (!roukenFlg && (kohiRate == 100)) continue;
////                if (!roukenFlg && (get_701014() <= get_701018())) continue;
//// 2015/5/12 [Yoichiro Kamei] mod - end
//                //[CCCX:1470][Shinobu Hitaka] 2014/02/07 edit - end 老健の一部公費対象の対応
// 2015/6/18 [Shinobu Hitaka] del - end

			}
			//公費２が適用対象に含まれている場合
// 2015/5/12 [Yoichiro Kamei] mod - begin 公費関連見直し
//	         if((!ACTextUtilities.isNullText(kohi[1]) && key.indexOf(kohi[1]) != -1)
//	                    || (get_701021() != 0)){
			if((!ACTextUtilities.isNullText(kohi[1]) && !"".equals(kohi[1].getKohiType())) 
			        || (get_701021() != 0)){
// 2015/5/12 [Yoichiro Kamei] mod - end
				//kohiRate = QP001Manager.getInstance().getBenefitRate(kohi[1]);
                kohiRate = ACCastUtilities.toInt(patientState.getKohiData(kohi[1],"BENEFIT_RATE",1),0);
                
// 2015/6/18 [Shinobu Hitaka] del - begin 公費関連見直し（下方の判定条件変更によりコメント化）
//                //[CCCX:1470][Shinobu Hitaka] 2014/02/07 add - start 老健の一部公費対象の対応
//                if(roukenFlg){
//                    //割合は初期値で渡す
//                    kohiClaim = getKohiClaim(get_701021(),kohiRate,reduction,get_701040(), get_701018());
//                    
//                    reduction += kohiClaim;
//                    //detail の KEY : 701022((公費2)請求額)に値を設定する。
//                    set_701022(get_701022() + kohiClaim);
//                    //適用した公費を退避する。
//                    set_701042(kohi[1].getKohiType());
//                    usedRate = kohiRate;
//                    //老健一部適用公費の場合は処理を終了しない
//                    roukenFlg = CareServiceCommon.isKouhiService(get_701007(), kohi[1].getKohiType());
//// 2015/5/12 [Yoichiro Kamei] mod - begin 公費関連見直し
////                    if (!roukenFlg && (kohiRate == 100)) continue;
////                    if (!roukenFlg && (get_701014() <= get_701018() + get_701021())) continue;
//// 2015/5/12 [Yoichiro Kamei] mod - end
//                }
//                //[CCCX:1470][Shinobu Hitaka] 2014/02/07 add - end 老健の一部公費対象の対応
// 2015/6/18 [Shinobu Hitaka] del - end
                
                //ありえないが、第一公費よりも第二公費の割合が低い場合を考慮
// 2015/5/12 [Yoichiro Kamei] mod - begin 公費関連見直し
//                if(kohiRate > usedRate){
                if(kohiRate >= usedRate){
// 2015/5/12 [Yoichiro Kamei] mod - end
                    
                    //[CCCX:1592][Shinobu Hitaka] 2014/03/12 add - start 感染症公費の処遇改善加算対応
                    //公費1=10感染症、公費2=老健一部公費の場合、公費給付率を初期化する
                    //roukenFlg = CareServiceCommon.isKouhiService(get_701007(), kohi[1].getKohiType());
                    roukenFlg = CareServiceCommon.isKouhiService(get_701007(), kohi[0].getKohiType());
                    
// 2015/6/18 [Shinobu Hitaka] mod - begin 公費関連見直し（老健一部公費または10感染症の場合に公費給付率を初期化）
                    //if (roukenFlg && ("1001".equals(kohi[0].getKohiType()))){
                    if (roukenFlg || ("1001".equals(kohi[0].getKohiType()))){
// 2015/6/18 [Shinobu Hitaka] mod - end
                    	usedRate = get_701040();
                    }
                    //[CCCX:1592][Shinobu Hitaka] 2014/03/12 add - end   感染症公費の処遇改善加算対応
                    
                    //お試し版
                    //kohiClaim = getKohiClaim(value,kohiRate,reduction,usedRate);
                    kohiClaim = getKohiClaim(get_701021(),kohiRate,reduction,usedRate, get_701018());
                    
                    // 2016/10/11 [Yoichiro Kamei] add - begin 総合事業対応
                    if (isDokuji()) {
                        kohiClaim = this.sjClaimCalc.calcDokujiKohiSeikyugaku(KohiyusenType.KOHI2,
                                get_701014(), get_701021(), kohiRate, reduction, usedRate, get_701018());
                    } else if (isDokujiTeiritsu()) {
                        kohiClaim = this.sjClaimCalc.calcTeiritsuKohiSeikyugaku(KohiyusenType.KOHI2,
                            get_701014(), get_701021(), kohiRate, reduction, usedRate, get_701018());
                    } else if (isDokujiTeigaku()) {
                        kohiClaim = this.sjClaimCalc.getTeigakuKohi2Seikyugaku();
                    }
                    // 2016/10/11 [Yoichiro Kamei] add - end
                    
                    reduction += kohiClaim;
                    //detail の KEY : 701022((公費2)請求額)に値を設定する。
                    set_701022(get_701022() + kohiClaim);
                    //適用した公費を退避する。
                    set_701042(kohi[1].getKohiType());
                    usedRate = kohiRate;

                    //[CCCX:1470][Shinobu Hitaka] 2014/02/07 edit - start 老健の一部公費対象の対応
                    //老健一部適用公費の場合は処理を終了しない
                    //公費2の給付率が100%の場合処理を終了する。
                    //if(kohiRate == 100) continue;
// 2015/5/12 [Yoichiro Kamei] mod - begin 公費関連見直し
//                    if (!roukenFlg && (kohiRate == 100)) continue;
//                    if (!roukenFlg && (get_701014() <= get_701018() + get_701021())) continue;
// 2015/5/12 [Yoichiro Kamei] mod - end
                    //[CCCX:1470][Shinobu Hitaka] 2014/02/07 edit - end 老健の一部公費対象の対応

                }

			}
			
			//公費３が適用対象に含まれている場合
// 2015/5/12 [Yoichiro Kamei] mod - begin 公費関連見直し
//	         if((!ACTextUtilities.isNullText(kohi[2]) && key.indexOf(kohi[2]) != -1)
//	                 || (get_701024() != 0)){
			if((!ACTextUtilities.isNullText(kohi[2]) && !"".equals(kohi[2].getKohiType())) 
			    || (get_701024() != 0)){
// 2015/5/12 [Yoichiro Kamei] mod - end
				//kohiRate = QP001Manager.getInstance().getBenefitRate(kohi[2]);
                kohiRate = ACCastUtilities.toInt(patientState.getKohiData(kohi[2],"BENEFIT_RATE",1),0);
                
// 2015/6/18 [Shinobu Hitaka] del - begin 公費関連見直し（下方の判定条件変更によりコメント化）
//                //[CCCX:1470][Shinobu Hitaka] 2014/02/07 add - start 老健の一部公費対象の対応
//                if(roukenFlg){
//                    //割合は初期値で渡す
//                    kohiClaim = getKohiClaim(get_701024(),kohiRate,reduction,get_701040(), get_701018() + get_701021());
//                    
//                    reduction += kohiClaim;
//                    //detail の KEY : 701025((公費3)請求額)に値を設定する。
//                    set_701025(get_701025() + kohiClaim);
//                    //適用した公費を退避する。
//                    set_701043(kohi[2].getKohiType());
//                }
//                //[CCCX:1470][Shinobu Hitaka] 2014/02/07 add - end 老健の一部公費対象の対応
// 2015/6/18 [Shinobu Hitaka] del - end
                
// 2015/5/12 [Yoichiro Kamei] mod - begin 公費関連見直し
//                if(kohiRate > usedRate){
                if(kohiRate >= usedRate){
// 2015/5/12 [Yoichiro Kamei] mod - end
                	
// 2015/6/18 [Shinobu Hitaka] add - begin 公費関連見直し（老健の一部公費対象の対応はここで行う）
                	roukenFlg = CareServiceCommon.isKouhiService(get_701007(), kohi[1].getKohiType());
                    if(roukenFlg){
                        usedRate = get_701040();
                    }
// 2015/6/18 [Shinobu Hitaka] add - end
                    
                    //お試し版
                    kohiClaim = getKohiClaim(get_701024(),kohiRate,reduction,usedRate, get_701018() + get_701021());
                    
                    // 2016/10/11 [Yoichiro Kamei] add - begin 総合事業対応
                    if (isDokuji()) {
                        kohiClaim = this.sjClaimCalc.calcDokujiKohiSeikyugaku(KohiyusenType.KOHI3,
                                get_701014(), get_701024(), kohiRate, reduction, usedRate, get_701018() + get_701021());
                    } else if (isDokujiTeiritsu()) {
                        kohiClaim = this.sjClaimCalc.calcTeiritsuKohiSeikyugaku(KohiyusenType.KOHI3,
                            get_701014(), get_701024(), kohiRate, reduction, usedRate, get_701018() + get_701021());
                    } else if (isDokujiTeigaku()) {
                        kohiClaim = this.sjClaimCalc.getTeigakuKohi3Seikyugaku();
                    }
                    // 2016/10/11 [Yoichiro Kamei] add - end
                    
// 2015/6/18 [Shinobu Hitaka] add - begin 公費関連見直し（公費1=10感染症の場合、請求額を調整する）
                    if ("1001".equals(kohi[0].getKohiType()) && kohiClaim > get_701019()){
                    	kohiClaim -= get_701019();
                    }
// 2015/6/18 [Shinobu Hitaka] add - end
                    
                    reduction += kohiClaim;
                    //detail の KEY : 701025((公費3)請求額)に値を設定する。
                    set_701025(get_701025() + kohiClaim);
                    //適用した公費を退避する。
                    set_701043(kohi[2].getKohiType());
                }
            }
// 2015/5/12 [Yoichiro Kamei] mod - begin 公費関連見直し
//		}
// 2015/5/12 [Yoichiro Kamei] mod - end
		
        //公費本人負担額の算出を行う
        int selfPay = 0;
        int kohiCost = 0;
        //公費１の本人負担額を取得
// 2015/6/18 [Shinobu Hitaka] mod - begin kansenFlg削除により判定を元に戻す
        if(!"0".equals(get_701041())){
        //if(!"0".equals(get_701041()) && !kansenFlg){
// 2015/6/18 [Shinobu Hitaka] mod - end
            
            selfPay = patientState.getKohiSelfPay(kohi[0],1);
            
            if(selfPay != 0){
                //様式第八、第九、第十の場合で且つ生保単独者で無い場合は、自己負担額の使用に制限をかける
            	kohiCost = 0;
            	if(nursing != null){
            		kohiCost = nursing.get_801026();
            	}
                selfPay = QP001SpecialCase.convertSelfPay(get_701001(),get_701006(),selfPay,kohi[0],kohiCost);
                
                //公費１請求額と本人負担額を比較し、本人負担額が大きい場合
                if (get_701019() < selfPay) {
                    // 公費１本人負担額に公費１請求額を設定する
                    set_701020(get_701019());
                    // 公費１請求額を0とする
                    set_701019(0);
                    //使用した公費自己負担額を設定する。
                    patientState.setKohiSelfPayUse(kohi[0],get_701020());
                } else {
                    set_701020(selfPay);
                    set_701019(get_701019() - get_701020());
                    //使用した公費自己負担額を設定する。
                    patientState.setKohiSelfPayUse(kohi[0],selfPay);
                }
            }

        }
        //公費２の本人負担額を取得
        if(!"0".equals(get_701042())){
            selfPay = patientState.getKohiSelfPay(kohi[1],1);
            
            if(selfPay != 0){
            	kohiCost = 0;
            	if(nursing != null){
            		kohiCost = nursing.get_801029();
            	}
                selfPay = QP001SpecialCase.convertSelfPay(get_701001(),get_701006(),selfPay,kohi[1],kohiCost);
                
                //公費２請求額と本人負担額を比較し、本人負担が大きい場合
                if(get_701022() < selfPay){
                    //公費２本人負担額に公費２請求額を設定する。
                    set_701023(get_701022());
                    //公費２請求額を0とする
                    set_701022(0);
                    //使用した公費自己負担額を設定する。
                    patientState.setKohiSelfPayUse(kohi[1],get_701023());
                } else {
                    set_701023(selfPay);
                    set_701022(get_701022() - get_701023());
                    //使用した公費自己負担額を設定する。
                    patientState.setKohiSelfPayUse(kohi[1],selfPay);
                }
            }
        }
        //公費３の本人負担額を取得
        if(!"0".equals(get_701043())){
            selfPay = patientState.getKohiSelfPay(kohi[2],1);
            
            if(selfPay != 0){
            	kohiCost = 0;
            	if(nursing != null){
            		kohiCost = nursing.get_801032();
            	}
                selfPay = QP001SpecialCase.convertSelfPay(get_701001(),get_701006(),selfPay,kohi[2],kohiCost);
                
                //公費３請求額と本人負担額を比較し、本人負担額が大きい場合
                if(get_701025() < selfPay){
                    //公費３本人負担額に公費３請求額を設定する。
                    set_701026(get_701025());
                    //公費３請求額を0とする
                    set_701025(0);
                    //使用した公費自己負担額を設定する。
                    patientState.setKohiSelfPayUse(kohi[2], get_701026());
                } else {
                    set_701026(selfPay);
                    set_701025(get_701025() - get_701026());
                    //使用した公費自己負担額を設定する。
                    patientState.setKohiSelfPayUse(kohi[2], selfPay);
                }
            }
        }
        
		//利用者負担額の確定を行う。
		//総額-介護保険負担-公費１-公費２-公費３-公費１本人負担-公費２本人負担-公費３本人負担
		set_701017((int)Math.floor((double)(get_701014() * get_701015Multiplies100()) / 100d)
		                    - get_701016()
		                    - get_701019()
		                    - get_701022()
                            - get_701025()
                            - get_701020()
                            - get_701023()
                            - get_701026());
        
        // 2016/10/11 [Yoichiro Kamei] add - begin 総合事業対応
        if (isDokujiTeiritsuTeigaku()) {
            if (isDokuji()) {
                // 独自
                // 利用者負担額
                set_701017(this.sjClaimCalc.getDokujiTotalSeikyugaku()
                        - get_701016()
                        - get_701019()
                        - get_701022()
                        - get_701025()
                        - get_701020()
                        - get_701023()
                        - get_701026());
            } else if (isDokujiTeiritsu()) {
                // 独自定率
                // 利用者負担額
                set_701017(this.sjClaimCalc.getTeiritsuTotalSeikyugaku()
                        - get_701016()
                        - get_701019()
                        - get_701022()
                        - get_701025()
                        - get_701020()
                        - get_701023()
                        - get_701026());
                
            } else if (isDokujiTeigaku()) {
                // 独自定額
                // 事業費請求額
                if (!get_701006().toUpperCase().startsWith("H")) {
                    set_701016(this.sjClaimCalc.getTeigakuJigyohiSeikyugaku(get_701019() + get_701022() + get_701025()
                        , get_701020() + get_701023() + get_701026()));
                }
                // 利用者負担額
                set_701017(this.sjClaimCalc.getTeigakuRiyoshaFutangaku());
            }
            
            //総合事業の単位数単価を設定
            set_701015(this.sjClaimCalc.getUnitPrice());
            //総合事業の区分限度超単位数情報を設定
            set_701047(this.sjClaimCalc.getSogoLimitOverInfo());
        }
        // 2016/10/11 [Yoichiro Kamei] add - end
        
        
        //念のため
        //利用者負担額がマイナスになった場合
        if(get_701017() < 0){
            //公費適用順位の低いものから利用者負担額分引く
            if(get_701025() > 0){
                set_701025(get_701025() + get_701017());
            } else {
                if(get_701022() > 0){
                    set_701022(get_701022() + get_701017());
                } else {
                    if(get_701019() > 0){
                        set_701019(get_701019() + get_701017());
                    }
                }
            }
            set_701017(0);
        }
        
        //居宅療養管理指導は限度額管理対象として計上しない例外処理
        //介護予防居宅療養管理指導にも同様の処理を行なう。
        //if(get_701007().equals("31")){
        if(get_701007().equals("31") || get_701007().equals("34")){
            set_701011(0);
        }
        
        //福祉用具であれば、回数を変更
        if(get_701007().equals("17") || get_701007().equals("67")){
            set_701008(ACDateUtilities.getLastDayOfMonth(ACCastUtilities.toDate(get_701003() + "01")));
        }
        
        
        //請求書集計欄　様式第六の三、第六の四の例外処理
        /*
         * １．外部利用型給付上限単位数
         * 特定施設入居者生活介護（介護予防を含む）において外部サービス利用型の
         * サービスを実施した場合は、要介護状態・要支援状態ごとに定められた外部
         * サービス利用型にかかる限度単位数を記載すること。
         * 　特定入居者生活介護（介護予防を含む）において一般型のサービスを実施した
         * 場合、及び地域密着型特定施設入居者生活介護のサービスを実施した場合は、
         * 記載不要であること。
         * 
         * ２．外部利用型上限管理対象単位数
         * 特定施設入居者生活介護（介護予防を含む）において外部サービス利用型の
         * サービスを実施した場合は、給付費明細欄のサービス単位数の合計を記載
         * すること。
         * 　特定入居者生活介護（介護予防を含む）において一般型のサービスを実施した
         * 場合、及び地域密着型特定施設入居者生活介護のサービスを実施した場合は、
         * 記載不要であること。
         * 
         * ３．給付単位数
         * 特定施設入居者生活介護（介護予防を含む）において外部サービス利用型の
         * サービスを実施した場合は、１．外部利用型給付上限単位数と２．外部利用型
         * 上限管理対象単位数のいずれか低いほうの単位数を記載すること。
         * 　特定施設入居者生活介護（介護予防を含む）において一般型のサービスを
         * 実施した場合は、給付悲鳴採卵のサービス単位数の合計を記載すること。
         */
        
        /* 2006.06.02 小久保さんとのやり取りにより、対応しないことに
        if(QP001StyleAbstract.IDENTIFICATION_NO_6_3.equals(get_701001())
        	|| QP001StyleAbstract.IDENTIFICATION_NO_6_4.equals(get_701001())){
        	
        	//外部利用型以外のサービスを利用している場合
        	if(externalNoUse && externalUse){
        		//給付単位数
        		//限度額管理対象単位数をコピー
        		set_701014(get_701010());
        		//給付上限単位数
                set_701009(0);
                //限度額管理対象単位数
                set_701010(0);
        	}
        }
        */
        
	}
    
    /**
     * 計画単位数を取得する。
     * @param styles
     * @param planUnitMap
     * @return
     * @throws Exception
     */
    private int getPlanUnit(VRMap styles,VRMap planUnitMap) throws Exception {
        int result = 0;
        
        //実績登録画面で入力された計画単位数を参照する。
        if(planUnitMap != null){
// 2016/7/15 [Yoichiro Kamei] mod - begin 総合事業対応
//        	String key = "10" + get_701007();
//        	// 10 + サービス種類コードのキーが存在するか確認
            String key = CareServiceCommon.getPlanUnitBindPath(get_701007());
// 2016/7/15 [Yoichiro Kamei] mod - end
        	
        	if(planUnitMap.containsKey(key)){
        		result = ACCastUtilities.toInt(planUnitMap.get(key),0);
        		
        		if(result != 0){
        			return result;
        		}
        	}
        }
// 2016/10/18 [Yoichiro Kamei] del - begin 総合事業対応
// 予定読込時に計画単位数を設定するよう変更したため、予定のデータは見ない
//        
//        //実績登録画面で計画単位数の入力が無い場合、予定のデータを見に行く
//        
//        if(styles == null) return result;
//        
//        Iterator it = styles.keySet().iterator();
//        while(it.hasNext()){
//            QP001StyleAbstract style = (QP001StyleAbstract)styles.get(it.next());
//            if(style instanceof QP001Style11){
//                QP001Style11 target = (QP001Style11)style;
//                
//                Map supplyMap = (Map)target.getSupplyMap();
//                
//                Iterator supplyIt = supplyMap.keySet().iterator();
//                while(supplyIt.hasNext()){
//                    QP001RecordSupply supply = (QP001RecordSupply)supplyMap.get(supplyIt.next());
//                  //事業所番号と保険者番号,被保険者番号とサービス種類コードが等しいものを探す
//                  if(String.valueOf(supply.get_1201017()).equals(get_701004())
//                          && (String.valueOf(supply.get_1201003()).equals(get_701005()))
//                          && (String.valueOf(supply.get_1201009()).equals(get_701006()))
//                          && (String.valueOf(supply.get_1201019()).equals(get_701007()))){
//                      result = supply.get_1201020();
//                      break;
//                  }
//                }
//            }
//        }
// 2016/10/18 [Yoichiro Kamei] del - end
        return result;
        
    }
	
    /**
     * 入所(入院)実日数管理リストを取得します。
     * @return
     */
    protected VRList getEntranceRealDays() {
        return entranceRealDays;
    }
    /**
     * 退所(退院)実日数管理リストを取得します。
     * @return
     */
    protected VRList getOutEntranceRealDays() {
        return outEntranceRealDays;
    }
 
// 2015/5/12 [Yoichiro Kamei] mod - begin 公費関連見直し
//    /**
//     * 公費の請求額を算出する。
//     * @param unit
//     * @param ratio
//     * @param reduction
//     * @return
//     */
//    private int getKohiClaim(int unit,int ratio,int reduction,int usedRate){
//        int result = 0;
//        int kyufu = 0;
//        //int total =(int)Math.floor((double)(get_701014() * get_701015Multiplies100()) / 100d);
//        int total =(int)Math.floor((double)(unit * get_701015Multiplies100()) / 100d);
//        
//        kyufu = (int)Math.floor(total * ((double)get_701040() / 100d));
//        //保険給付率が100%の場合
////      if(ratio == 100){
//        if((ratio == 100) && (get_701014() == unit)){
//            //利用者請求から介護保険負担額を引いたもの
//            result = total - kyufu - reduction;
//        } else {
//            //合計金額*(公費給付率-保険給付率-)
//            //result = (int)Math.floor((total * (ratio - get_701040()))/100);
//            result = (int)Math.floor((total * (ratio - usedRate))/100);
//        }
//        return result;
//    }
	/**
	 * 公費の請求額を算出する。
	 * @param unit 公費対象単位数
	 * @param ratio 公費給付率（例：95-100)
	 * @param reduction 上位優先順の公費請求額として計上済の金額
	 * @param usedRate 上位優先順の公費給付率
	 * @param tumiageUnit 上位優先順の公費対象単位数として計上済の単位数
	 * @return
	 */
	private int getKohiClaim(int unit,int ratio,int reduction,int usedRate, int tumiageUnit){
		int result = 0;
		int kyufu = 0;
		int hokenTotal =(int)Math.floor((double)(get_701014() * get_701015Multiplies100()) / 100d);
        int total =(int)Math.floor((double)(unit * get_701015Multiplies100()) / 100d); //全体の請求額
		
        kyufu = (int)Math.floor(total * ((double)get_701040() / 100d));//保険請求額
		//公費給付率が100%で公費対象単位数＝保険単位数の場合
        if((ratio == 100) && (get_701014() == unit)){
			//全体の請求額から介護保険請求額を引いたもの
			result = total - kyufu - reduction;
		} else if ((ratio == 100) && (get_701014() == (unit + tumiageUnit))) {
		    //公費給付率が100%で公費対象単位数を積み上げた結果がサービス単位数と等しい場合
		    result = hokenTotal - kyufu - reduction;
		}else {
			//合計金額*(公費給付率-保険給付率-)
		    if (usedRate != 100) {
		        result = (int)Math.floor((total * (ratio - usedRate))/100);
		    } else {
		        //上位の公費に100%が適用済の場合
		        //月の一部の期間が公費適用の場合などはこちら
		        result = (int)Math.floor((total * (ratio - get_701040()))/100);
		    }
		}
		return result;
	}
// 2015/5/12 [Yoichiro Kamei] mod - end
	
	/**
	 * レコード固有の値を作成します。
	 */
	protected String getSerialId() {
		StringBuilder serial = new StringBuilder();
		//交換情報識別番号4桁
		serial.append(get_701001());
		//レコード種別コード
		serial.append(get_701002());
		//サービス提供年月6桁(YYYYMM)
		serial.append(get_701003());
		//事業所番号10桁
		serial.append(get_701004());
		//証記載保険者番号8桁
		serial.append(get_701005());
		//被保険者番号10桁
		serial.append(get_701006());
		//サービス種類コード2桁
		serial.append(get_701007());
		return serial.toString();
	}

	/**
	 * レコード固有の値を作成します。
	 * @param detail
	 * @return
	 * @throws Exception
	 */
	protected static String getSerialId(QP001RecordDetail detail) throws Exception {
		StringBuilder serial = new StringBuilder();
		//交換情報識別番号4桁
		serial.append(detail.get_301001());
		//レコード種別コード
		serial.append(get_701002());
		//サービス提供年月6桁(YYYYMM)
		serial.append(detail.get_301003());
		//事業所番号10桁
		serial.append(detail.get_301004());
		//証記載保険者番号8桁
		serial.append(detail.get_301005());
		//被保険者番号10桁
		serial.append(detail.get_301006());
		//サービス種類コード2桁
		serial.append(detail.get_301007());
		return serial.toString();
	}
	
	/**
	 * データ作成
	 * @param style
	 * @return
	 */
	protected VRMap getRecord(VRMap style) throws Exception {
		VRMap result = copyStyle(style);
		
		//交換情報識別番号4桁
		setData(result,"701001",get_701001());
		//レコード種別コード2桁(10を設定)
		setData(result,"701002",get_701002());
		//サービス提供年月6桁(YYYYMM)
		setData(result,"701003",get_701003());
		//事業所番号10桁
		setData(result,"701004",get_701004());
		//証記載保険者番号8桁
		setData(result,"701005",get_701005());
		//被保険者番号10桁
		setData(result,"701006",get_701006());
		//サービス種類コード2桁
		setData(result,"701007",get_701007());
		//サービス実日数2桁
		setData(result,"701008",get_701008());
		//計画単位数6桁
		setData(result,"701009",get_701009());
		//限度額管理対象単位数6桁
		setData(result,"701010",Integer.toString(get_701010()));
		//限度額管理対象外単位数6桁
		setData(result,"701011",Integer.toString(get_701011()));
		//短期入所計画日数2桁
		setData(result,"701012",get_701012());
		//短期入所実日数2桁
		setData(result,"701013",get_701013());
		//(保険)単位数合計8桁
		setData(result,"701014",get_701014());
		//(保険)単位数単価4桁
		setData(result,"701015",get_701015());
		//(保険)請求額9桁
		setData(result,"701016",get_701016());
		//(保険)利用者負担額8桁
		setData(result,"701017",get_701017());
		//(公費1)単位数合計6桁
		setData(result,"701018",get_701018());
		//(公費1)請求額9桁
		setData(result,"701019",get_701019());
		//(公費1)本人負担額6桁
		setData(result,"701020",get_701020());
		//(公費2)単位数合計6桁
		setData(result,"701021",get_701021());
		//(公費2)請求額9桁
		setData(result,"701022",get_701022());
		//(公費2)本人負担額6桁
		setData(result,"701023",get_701023());
		//(公費3)単位数合計6桁
		setData(result,"701024",get_701024());
		//(公費3)請求額9桁
		setData(result,"701025",get_701025());
		//(公費3)本人負担額6桁
		setData(result,"701026",get_701026());
		//(保険分出来高医療費)単位数合計8桁
		setData(result,"701027",get_701027());
		//(保険分出来高医療費)請求額9桁
		setData(result,"701028",get_701028());
		//(保険分出来高医療費)出来高医療費利用者負担額8桁
		setData(result,"701029",get_701029());
		//(公費1分出来高医療費)単位数合計8桁
		setData(result,"701030",get_701030());
		//(公費1分出来高医療費)請求額9桁
		setData(result,"701031",get_701031());
		//(公費1分出来高医療費)出来高医療費本人負担額8桁
		setData(result,"701032",get_701032());
		//(公費2分出来高医療費)単位数合計8桁
		setData(result,"701033",get_701033());
		//(公費2分出来高医療費)請求額9桁
		setData(result,"701034",get_701034());
		//(公費2分出来高医療費)出来高医療費本人負担額8桁
		setData(result,"701035",get_701035());
		//(公費3分出来高医療費)単位数合計8桁
		setData(result,"701036",get_701036());
		//(公費3分出来高医療費)請求額9桁
		setData(result,"701037",get_701037());
		//(公費3分出来高医療費)出来高医療費本人負担額8桁
		setData(result,"701038",get_701038());
		//サービス名称
//		setData(result,"701039",get_701039());
		
		//[ID:0000525][Shin Fujihara] 2009/07 add begin 2009年度対応
		setData(result,"701046",get_701046());
		//[ID:0000525][Shin Fujihara] 2009/07 add end 2009年度対応
		
		setData(result,"701047",get_701047()); // 2016/10 add 総合事業独自対応
		
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
		//集計情報レコード
		//result.put("CATEGORY_NO","7");
        result.put("CATEGORY_NO",QkanConstants.CATEGORY_NO_RECORD_TOTAL);
		return result;
	}
	
	public String toString(){
		StringBuilder result = new StringBuilder();
		result.append("[701001=" + get_701001() + "]\n");
		result.append("[701002=" + get_701002() + "]\n");
		result.append("[701003=" + get_701003() + "]\n");
		result.append("[701004=" + get_701004() + "]\n");
		result.append("[701005=" + get_701005() + "]\n");
		result.append("[701006=" + get_701006() + "]\n");
		result.append("[701007=" + get_701007() + "]\n");
		result.append("[701008=" + get_701008() + "]\n");
		result.append("[701009=" + get_701009() + "]\n");
		result.append("[701010=" + get_701010() + "]\n");
		result.append("[701011=" + get_701011() + "]\n");
		result.append("[701012=" + get_701012() + "]\n");
		result.append("[701013=" + get_701013() + "]\n");
		result.append("[701014=" + get_701014() + "]\n");
		result.append("[701015=" + get_701015() + "]\n");
		result.append("[701016=" + get_701016() + "]\n");
		result.append("[701017=" + get_701017() + "]\n");
		result.append("[701018=" + get_701018() + "]\n");
		result.append("[701019=" + get_701019() + "]\n");
		result.append("[701020=" + get_701020() + "]\n");
		result.append("[701021=" + get_701021() + "]\n");
		result.append("[701022=" + get_701022() + "]\n");
		result.append("[701023=" + get_701023() + "]\n");
		result.append("[701024=" + get_701024() + "]\n");
		result.append("[701025=" + get_701025() + "]\n");
		result.append("[701026=" + get_701026() + "]\n");
		result.append("[701027=" + get_701027() + "]\n");
		result.append("[701028=" + get_701028() + "]\n");
		result.append("[701029=" + get_701029() + "]\n");
		result.append("[701030=" + get_701030() + "]\n");
		result.append("[701031=" + get_701031() + "]\n");
		result.append("[701032=" + get_701032() + "]\n");
		result.append("[701033=" + get_701033() + "]\n");
		result.append("[701034=" + get_701034() + "]\n");
		result.append("[701035=" + get_701035() + "]\n");
		result.append("[701036=" + get_701036() + "]\n");
		result.append("[701037=" + get_701037() + "]\n");
		result.append("[701038=" + get_701038() + "]\n");
		result.append("[701039=" + get_701039() + "]\n");
		return result.toString();
	}
	
	
}
