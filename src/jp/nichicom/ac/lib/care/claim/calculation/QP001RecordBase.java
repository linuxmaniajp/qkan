
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
 * プログラム 基本情報レコード (QP001RecordBase)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Date;
import java.util.Iterator;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

/**
 * 基本情報レコード
 *
 */
public class QP001RecordBase extends QP001RecordAbstract {

	//交換情報識別番号4桁
	private String _201001 = "";
	//レコード種別コード2桁(01を設定)
	private static final String _201002 = "01";
	//サービス提供年月6桁(YYYYMM)
	private String _201003 = "";
	//事業所番号10桁
	private String _201004 = "";
	//証記載保険者番号8桁
	private String _201005 = "";
	//被保険者番号10桁
	private String _201006 = "";
	//(公費1)負担者番号8桁
	private String _201007 = "";
	//(公費1)受給者番号7桁
	private String _201008 = "";
	//(公費2)負担者番号8桁
	private String _201009 = "";
	//(公費2)受給者番号7桁
	private String _201010 = "";
	//(公費3)負担者番号8桁
	private String _201011 = "";
	//(公費3)受給者番号7桁
	private String _201012 = "";
	//(被保険者情報)生年月日8桁YYYYMMDD
	private String _201013 = "";
	//(被保険者情報)性別コード1桁1-男 2-女
	private String _201014 = "";
	//(被保険者情報)要介護状態区分コード2桁01-非該当 11-要支援 21-要介護1 22-要介護2 23-要介護3 24-要介護4 25-要介護5
	private String _201015 = "";
	//(被保険者情報)旧措置入所者特例コード1桁1-なし 2-あり
	private String _201016 = "";
	//(被保険者情報)認定有効期間 開始年月日8桁(YYYYMMDD)
	private String _201017 = "";
	//(被保険者情報)認定有効期間 終了年月日8桁(YYYYMMDD)
	private String _201018 = "";
	//(居宅サービス計画)居宅サービス計画作成区分コード1桁1-居宅介護支援事業所作成 2-自己作成
	private int _201019 = 0;
	//(居宅サービス計画)事業所番号10桁(居宅介護支援事業所)
	private String _201020 = "";
	//開始年月日8桁(YYYYMMDD)
	private String _201021 = "";
	//中止年月日8桁(YYYYMMDD)
	private String _201022 = "";
	//中止理由コード1桁1-非該当 2-介護施設 3-医療機関入院 4-死亡 5-その他
	private int _201023 = 0;
	//入所(院)年月日8桁(YYYYMMDD)
	private String _201024 = "";
	//退所(院)年月日8桁(YYYYMMDD)
	private String _201025 = "";
	//入所(院)実日数2桁
	private String _201026 = "";
	//外泊日数2桁
	private String _201027 = "";
	//退所(院)後の状態コード1桁1-居宅 2-介護施設 3-医療機関入院 4-死亡 5-その他
	private int _201028 = 0;
	//保険給付率3桁
	private int _201029 = 0;
	//公費1給付率
	private int _201030 = 0;
	//公費2給付率
	private int _201031 = 0;
	//公費3給付率
	private int _201032 = 0;
	//(合計情報 保険)サービス単位数8桁
	private int _201033 = 0;
	//(合計情報 保険)請求額9桁
	private int _201034 = 0;
	//(合計情報 保険)利用者負担額8桁
	private int _201035 = 0;
	//(合計情報 保険)緊急時施設療養費請求額9桁
	private int _201036 = 0;
	//(合計情報 保険)特定診療費請求額9桁
	private int _201037 = 0;
	//(合計情報 保険)特定入所者介護サービス費等請求額8桁
	private int _201038 = 0;
	//(合計情報 公費1)サービス単位数8桁
	private int _201039 = 0;
	//(合計情報 公費1)請求額8桁
	private int _201040 = 0;
	//(合計情報 公費1)本人負担額8桁
	private int _201041 = 0;
	//(合計情報 公費1)緊急時施設療養費請求額8桁
	private int _201042 = 0;
	//(合計情報 公費1)特定診療費請求額8桁
	private int _201043 = 0;
	//(合計情報 公費1)特定入所者介護サービス費等請求額8桁
	private int _201044 = 0;
	//(合計情報 公費2)サービス単位数8桁
	private int _201045 = 0;
	//(合計情報 公費2)請求額8桁
	private int _201046 = 0;
	//(合計情報 公費2)本人負担額8桁
	private int _201047 = 0;
	//(合計情報 公費2)緊急時施設療養費請求額8桁
	private int _201048 = 0;
	//(合計情報 公費2)特定診療費請求額8桁
	private int _201049 = 0;
	//(合計情報 公費2)特定入所者介護サービス費等請求額8桁
	private int _201050 = 0;
	//(合計情報 公費3)サービス単位数8桁
	private int _201051 = 0;
	//(合計情報 公費3)請求額8桁
	private int _201052 = 0;
	//(合計情報 公費3)本人負担額8桁
	private int _201053 = 0;
	//(合計情報 公費3)緊急時施設療養費請求額8桁
	private int _201054 = 0;
	//(合計情報 公費3)特定診療費請求額8桁
	private int _201055 = 0;
	//(合計情報 公費3)特定入所者介護サービス費等請求額8桁
	private int _201056 = 0;
	//居宅サービス計画者事業所名
	private String _201057 = "";
	//公費1 公費種類(KOHI_TYPE)
	private String _201058 = "";
	//公費2 公費種類(KOHI_TYPE)
	private String _201059 = "";
	//公費3 公費種類(KOHI_TYPE)
	private String _201060 = "";
	//主傷病名
	private String _201061 = "";
	
	protected String getSerialId() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	/**
	 * 交換情報識別番号4桁を取得する。
	 */
	protected String get_201001() {
		return _201001;
	}
	/**
	 * 交換情報識別番号4桁を設定する。
	 * @param _201001
	 */
	protected void set_201001(String _201001) {
		this._201001 = _201001;
	}
	/**
	 * レコード種別コード2桁(01を設定)を取得する。
	 * @return
	 */
	protected String get_201002() {
		return _201002;
	}
	/**
	 * サービス提供年月6桁(YYYYMM)を取得する。
	 * @return
	 */
	protected String get_201003() {
		return _201003;
	}
	/**
	 * サービス提供年月6桁(YYYYMM)を設定する。
	 * @param _201003
	 */
	protected void set_201003(String _201003) {
		this._201003 = _201003;
	}
	/**
	 * 事業所番号10桁を取得する。
	 * @return
	 */
	protected String get_201004() {
		return _201004;
	}
	/**
	 * 事業所番号10桁を設定する。
	 * @param _201004
	 */
	protected void set_201004(String _201004) {
		this._201004 = _201004;
	}
	/**
	 * 証記載保険者番号8桁を取得する。
	 * @return
	 */
	protected String get_201005() {
		return _201005;
	}
	/**
	 * 証記載保険者番号8桁を設定する。
	 * @param _201005
	 */
	protected void set_201005(String _201005) {
		this._201005 = _201005;
	}
	/**
	 * 被保険者番号10桁を取得する。
	 * @return
	 */
	protected String get_201006() {
		return _201006;
	}
	/**
	 * 被保険者番号10桁を設定する。
	 * @param _201006
	 */
	protected void set_201006(String _201006) {
		this._201006 = _201006;
	}
	/**
	 * (公費1)負担者番号8桁を取得する。
	 * @return
	 */
	protected String get_201007() {
		return _201007;
	}
	/**
	 * (公費1)負担者番号8桁を設定する。
	 * @param _201007
	 */
	protected void set_201007(String _201007) {
		this._201007 = _201007;
	}
	/**
	 * (公費1)受給者番号7桁を取得する。
	 * @return
	 */
	protected String get_201008() {
		return _201008;
	}
	/**
	 * (公費1)受給者番号7桁を設定する。
	 * @param _201008
	 */
	protected void set_201008(String _201008) {
		this._201008 = _201008;
	}
	/**
	 * (公費2)負担者番号8桁を取得する。
	 * @return
	 */
	protected String get_201009() {
		return _201009;
	}
	/**
	 * (公費2)負担者番号8桁を設定する。
	 * @param _201009
	 */
	protected void set_201009(String _201009) {
		this._201009 = _201009;
	}
	/**
	 * (公費2)受給者番号7桁を取得する。
	 * @return
	 */
	protected String get_201010() {
		return _201010;
	}
	/**
	 * (公費2)受給者番号7桁を設定する。
	 * @param _201010
	 */
	protected void set_201010(String _201010) {
		this._201010 = _201010;
	}
	/**
	 * (公費3)負担者番号8桁を取得する。
	 * @return
	 */
	protected String get_201011() {
		return _201011;
	}
	/**
	 * (公費3)負担者番号8桁を設定する。
	 * @param _201011
	 */
	protected void set_201011(String _201011) {
		this._201011 = _201011;
	}
	/**
	 * (公費3)受給者番号7桁を取得する。
	 * @return
	 */
	protected String get_201012() {
		return _201012;
	}
	/**
	 * (公費3)受給者番号7桁を設定する。
	 * @param _201012
	 */
	protected void set_201012(String _201012) {
		this._201012 = _201012;
	}
	/**
	 * (被保険者情報)生年月日8桁YYYYMMDDを取得する。
	 * @return
	 */
	protected String get_201013() {
		return _201013;
	}
	/**
	 * (被保険者情報)生年月日8桁YYYYMMDDを設定する。
	 * @param _201013
	 */
	protected void set_201013(String _201013) {
		this._201013 = _201013;
	}
	/**
	 * (被保険者情報)性別コード1桁を取得する。
	 * @return 1-男 2-女
	 */
	protected String get_201014() {
		return _201014;
	}
	/**
	 * (被保険者情報)性別コード1桁を設定する。
	 * @param _201014 1-男 2-女
	 */
	protected void set_201014(String _201014) {
		this._201014 = _201014;
	}
	/**
	 * (被保険者情報)要介護状態区分コード2桁を取得する。
	 * @return 01-非該当 11-要支援 21-要介護1 22-要介護2 23-要介護3 24-要介護4 25-要介護5
	 */
	protected String get_201015() {
		return _201015;
	}
	/**
	 * (被保険者情報)要介護状態区分コード2桁を設定する。
	 * @param _201015 01-非該当 11-要支援 21-要介護1 22-要介護2 23-要介護3 24-要介護4 25-要介護5
	 */
	protected void set_201015(String _201015) {
		this._201015 = _201015;
	}
	/**
	 * (被保険者情報)旧措置入所者特例コード1桁を取得する。
	 * @return 1-なし 2-あり
	 */
	protected String get_201016() {
		return _201016;
	}
	/**
	 * (被保険者情報)旧措置入所者特例コード1桁を取得する。
	 * @param _201016 1-なし 2-あり
	 */
	protected void set_201016(String _201016) {
		this._201016 = _201016;
	}
	/**
	 * (被保険者情報)認定有効期間 開始年月日8桁(YYYYMMDD)を取得する。
	 * @return
	 */
	protected String get_201017() {
		return _201017;
	}
	/**
	 * (被保険者情報)認定有効期間 開始年月日8桁(YYYYMMDD)を設定する。
	 * @param _201017
	 */
	protected void set_201017(String _201017) {
		this._201017 = _201017;
	}
	/**
	 * (被保険者情報)認定有効期間 終了年月日8桁(YYYYMMDD)を取得する。
	 * @return
	 */
	protected String get_201018() {
		return _201018;
	}
	/**
	 * (被保険者情報)認定有効期間 終了年月日8桁(YYYYMMDD)を設定する。
	 * @param _201018
	 */
	protected void set_201018(String _201018) {
		this._201018 = _201018;
	}
	/**
	 * (居宅サービス計画)居宅サービス計画作成区分コード1桁を取得する。
	 * @return 1-居宅介護支援事業所作成 2-自己作成
	 */
	protected int get_201019() {
		return _201019;
	}
	/**
	 * (居宅サービス計画)居宅サービス計画作成区分コード1桁を設定する。
	 * @param _201019 1-居宅介護支援事業所作成 2-自己作成
	 */
	protected void set_201019(int _201019) {
		this._201019 = _201019;
	}
	/**
	 * (居宅サービス計画)事業所番号10桁(居宅介護支援事業所)を取得する。
	 * @return
	 */
	protected String get_201020() {
		return _201020;
	}
	/**
	 * (居宅サービス計画)事業所番号10桁(居宅介護支援事業所)を設定する。
	 * @param _201020
	 */
	protected void set_201020(String _201020) {
		this._201020 = _201020;
	}
	/**
	 * 開始年月日8桁(YYYYMMDD)を取得する。
	 * @return
	 */
	protected String get_201021() {
		return _201021;
	}
	/**
	 * 開始年月日8桁(YYYYMMDD)を設定する。
	 * @param _201021
	 */
	protected void set_201021(String _201021) {
		this._201021 = _201021;
	}
	/**
	 * 中止年月日8桁(YYYYMMDD)を取得する。
	 * @return
	 */
	protected String get_201022() {
		return _201022;
	}
	/**
	 * 中止年月日8桁(YYYYMMDD)を設定する。
	 * @param _201022
	 */
	protected void set_201022(String _201022) {
		this._201022 = _201022;
	}
	/**
	 * 中止理由コード1桁を取得する。
	 * @return 1-非該当 2-介護施設 3-医療機関入院 4-死亡 5-その他
	 */
	protected int get_201023() {
		return _201023;
	}
	/**
	 * 中止理由コード1桁を設定する。
	 * @param _201023 1-非該当 2-介護施設 3-医療機関入院 4-死亡 5-その他
	 */
	protected void set_201023(int _201023) {
		this._201023 = _201023;
	}
	/**
	 * 入所(院)年月日8桁(YYYYMMDD)を取得する。
	 * @return
	 */
	protected String get_201024() {
		return _201024;
	}
	/**
	 * 入所(院)年月日8桁(YYYYMMDD)を設定する。
	 * @param _201024
	 */
	protected void set_201024(String _201024) {
		this._201024 = _201024;
	}
	/**
	 * 退所(院)年月日8桁(YYYYMMDD)を取得する。
	 * @return
	 */
	protected String get_201025() {
		return _201025;
	}
	/**
	 * 退所(院)年月日8桁(YYYYMMDD)を設定する。
	 * @param _201025
	 */
	protected void set_201025(String _201025) {
		this._201025 = _201025;
	}
	/**
	 * 入所(院)実日数2桁を取得する。
	 * @return
	 */
	protected String get_201026() {
		return _201026;
	}
	/**
	 * 入所(院)実日数2桁を設定する。
	 * @param _201026
	 */
	protected void set_201026(String _201026) {
		this._201026 = _201026;
	}
	/**
	 * 外泊日数2桁を取得する。
	 * @return
	 */
	protected String get_201027() {
		return _201027;
	}
	/**
	 * 外泊日数2桁を設定する。
	 * @param _201027
	 */
	protected void set_201027(String _201027) {
		this._201027 = _201027;
	}
	/**
	 * 退所(院)後の状態コード1桁を取得する。
	 * @return 1-居宅 2-介護施設 3-医療機関入院 4-死亡 5-その他
	 */
	protected int get_201028() {
		return _201028;
	}
	/**
	 * 退所(院)後の状態コード1桁を設定する。
	 * @param _201028 1-居宅 2-介護施設 3-医療機関入院 4-死亡 5-その他
	 */
	protected void set_201028(int _201028) {
		this._201028 = _201028;
	}
	/**
	 * 保険給付率3桁を取得する。
	 * @return
	 */
	protected int get_201029() {
		return _201029;
	}
	/**
	 * 保険給付率3桁を設定する。
	 * @param _201029
	 */
	protected void set_201029(int _201029) {
		this._201029 = _201029;
	}
	/**
	 * 公費1給付率を取得する。
	 * @return
	 */
	protected int get_201030() {
		return _201030;
	}
	/**
	 * 公費1給付率を設定する。
	 * @param _201030
	 */
	protected void set_201030(int _201030) {
		this._201030 = _201030;
	}
	/**
	 * 公費2給付率を取得する。
	 * @return
	 */
	protected int get_201031() {
		return _201031;
	}
	/**
	 * 公費2給付率を設定する。
	 * @param _201031
	 */
	protected void set_201031(int _201031) {
		this._201031 = _201031;
	}
	/**
	 * 公費3給付率を取得する。
	 * @return
	 */
	protected int get_201032() {
		return _201032;
	}
	/**
	 * 公費3給付率を設定する。
	 * @param _201032
	 */
	protected void set_201032(int _201032) {
		this._201032 = _201032;
	}
	/**
	 * (合計情報 保険)サービス単位数8桁を取得する。
	 * @return
	 */
	protected int get_201033() {
		return _201033;
	}
	/**
	 * (合計情報 保険)サービス単位数8桁を設定する。
	 * @param _201033
	 */
	protected void set_201033(int _201033) {
		this._201033 = _201033;
	}
	/**
	 * (合計情報 保険)請求額9桁を取得する。
	 * @return
	 */
	protected int get_201034() {
		return _201034;
	}
	/**
	 * (合計情報 保険)請求額9桁を設定する。
	 * @param _201034
	 */
	protected void set_201034(int _201034) {
		this._201034 = _201034;
	}
	/**
	 * (合計情報 保険)利用者負担額8桁を取得する。
	 * @return
	 */
	protected int get_201035() {
		return _201035;
	}
	/**
	 * (合計情報 保険)利用者負担額8桁を設定する。
	 * @param _201035
	 */
	protected void set_201035(int _201035) {
		this._201035 = _201035;
	}
	/**
	 * (合計情報 保険)緊急時施設療養費請求額9桁を取得する。
	 * @return
	 */
	protected int get_201036() {
		return _201036;
	}
	/**
	 * (合計情報 保険)緊急時施設療養費請求額9桁を設定する。
	 * @param _201036
	 */
	protected void set_201036(int _201036) {
		this._201036 = _201036;
	}
	/**
	 * (合計情報 保険)特定診療費請求額9桁を取得する。
	 * @return
	 */
	protected int get_201037() {
		return _201037;
	}
	/**
	 * (合計情報 保険)特定診療費請求額9桁を設定する。
	 * @param _201037
	 */
	protected void set_201037(int _201037) {
		this._201037 = _201037;
	}
	/**
	 * (合計情報 保険)特定入所者介護サービス費等請求額8桁を取得する。
	 * @return
	 */
	protected int get_201038() {
		return _201038;
	}
	/**
	 * (合計情報 保険)特定入所者介護サービス費等請求額8桁を設定する。
	 * @param _201038
	 */
	protected void set_201038(int _201038) {
		this._201038 = _201038;
	}
	/**
	 * (合計情報 公費1)サービス単位数8桁を取得する。
	 * @return
	 */
	protected int get_201039() {
		return _201039;
	}
	/**
	 * (合計情報 公費1)サービス単位数8桁を設定する。
	 * @param _201039
	 */
	protected void set_201039(int _201039) {
		this._201039 = _201039;
	}
	/**
	 * (合計情報 公費1)請求額8桁を取得する。
	 * @return
	 */
	protected int get_201040() {
		return _201040;
	}
	/**
	 * (合計情報 公費1)請求額8桁を設定する。
	 * @param _201040
	 */
	protected void set_201040(int _201040) {
		this._201040 = _201040;
	}
	/**
	 * (合計情報 公費1)本人負担額8桁を取得する。
	 * @return
	 */
	protected int get_201041() {
		return _201041;
	}
	/**
	 * (合計情報 公費1)本人負担額8桁を設定する。
	 * @param _201041
	 */
	protected void set_201041(int _201041) {
		this._201041 = _201041;
	}
	/**
	 * (合計情報 公費1)緊急時施設療養費請求額8桁を取得する。
	 * @return
	 */
	protected int get_201042() {
		return _201042;
	}
	/**
	 * (合計情報 公費1)緊急時施設療養費請求額8桁を設定する。
	 * @param _201042
	 */
	protected void set_201042(int _201042) {
		this._201042 = _201042;
	}
	/**
	 * (合計情報 公費1)特定診療費請求額8桁を取得する。
	 * @return
	 */
	protected int get_201043() {
		return _201043;
	}
	/**
	 * (合計情報 公費1)特定診療費請求額8桁を設定する。
	 * @param _201043
	 */
	protected void set_201043(int _201043) {
		this._201043 = _201043;
	}
	/**
	 * (合計情報 公費1)特定入所者介護サービス費等請求額8桁を取得する。
	 * @return
	 */
	protected int get_201044() {
		return _201044;
	}
	/**
	 * (合計情報 公費1)特定入所者介護サービス費等請求額8桁を設定する。
	 * @param _201044
	 */
	protected void set_201044(int _201044) {
		this._201044 = _201044;
	}
	/**
	 * (合計情報 公費2)サービス単位数8桁を取得する。
	 * @return
	 */
	protected int get_201045() {
		return _201045;
	}
	/**
	 * (合計情報 公費2)サービス単位数8桁を設定する。
	 * @param _201045
	 */
	protected void set_201045(int _201045) {
		this._201045 = _201045;
	}
	/**
	 * (合計情報 公費2)請求額8桁を取得する。
	 * @return
	 */
	protected int get_201046() {
		return _201046;
	}
	/**
	 * (合計情報 公費2)請求額8桁を設定する。
	 * @param _201046
	 */
	protected void set_201046(int _201046) {
		this._201046 = _201046;
	}
	/**
	 * (合計情報 公費2)本人負担額8桁を取得する。
	 * @return
	 */
	protected int get_201047() {
		return _201047;
	}
	/**
	 * (合計情報 公費2)本人負担額8桁を設定する。
	 * @param _201047
	 */
	protected void set_201047(int _201047) {
		this._201047 = _201047;
	}
	/**
	 * (合計情報 公費2)緊急時施設療養費請求額8桁を取得する。
	 * @return
	 */
	protected int get_201048() {
		return _201048;
	}
	/**
	 * (合計情報 公費2)緊急時施設療養費請求額8桁を設定する。
	 * @param _201048
	 */
	protected void set_201048(int _201048) {
		this._201048 = _201048;
	}
	/**
	 * (合計情報 公費2)特定診療費請求額8桁を取得する。
	 * @return
	 */
	protected int get_201049() {
		return _201049;
	}
	/**
	 * (合計情報 公費2)特定診療費請求額8桁を設定する。
	 * @param _201049
	 */
	protected void set_201049(int _201049) {
		this._201049 = _201049;
	}
	/**
	 * (合計情報 公費2)特定入所者介護サービス費等請求額8桁を取得する。
	 * @return
	 */
	protected int get_201050() {
		return _201050;
	}
	/**
	 * (合計情報 公費2)特定入所者介護サービス費等請求額8桁を設定する。
	 * @param _201050
	 */
	protected void set_201050(int _201050) {
		this._201050 = _201050;
	}
	/**
	 * (合計情報 公費3)サービス単位数8桁を取得する。
	 * @return
	 */
	protected int get_201051() {
		return _201051;
	}
	/**
	 * (合計情報 公費3)サービス単位数8桁を設定する。
	 * @param _201051
	 */
	protected void set_201051(int _201051) {
		this._201051 = _201051;
	}
	/**
	 * (合計情報 公費3)請求額8桁を取得する。
	 * @return
	 */
	protected int get_201052() {
		return _201052;
	}
	/**
	 * (合計情報 公費3)請求額8桁を設定する。
	 * @param _201052
	 */
	protected void set_201052(int _201052) {
		this._201052 = _201052;
	}
	/**
	 * (合計情報 公費3)本人負担額8桁を取得する。
	 * @return
	 */
	protected int get_201053() {
		return _201053;
	}
	/**
	 * (合計情報 公費3)本人負担額8桁を設定する。
	 * @param _201053
	 */
	protected void set_201053(int _201053) {
		this._201053 = _201053;
	}
	/**
	 * (合計情報 公費3)緊急時施設療養費請求額8桁を取得する。
	 * @return
	 */
	protected int get_201054() {
		return _201054;
	}
	/**
	 * (合計情報 公費3)緊急時施設療養費請求額8桁を設定する。
	 * @param _201054
	 */
	protected void set_201054(int _201054) {
		this._201054 = _201054;
	}
	/**
	 * (合計情報 公費3)特定診療費請求額8桁を取得する。
	 * @return
	 */
	protected int get_201055() {
		return _201055;
	}
	/**
	 * (合計情報 公費3)特定診療費請求額8桁を設定する。
	 * @param _201055
	 */
	protected void set_201055(int _201055) {
		this._201055 = _201055;
	}
	/**
	 * (合計情報 公費3)特定入所者介護サービス費等請求額8桁を取得する。
	 * @return
	 */
	protected int get_201056() {
		return _201056;
	}
	/**
	 * (合計情報 公費3)特定入所者介護サービス費等請求額8桁を設定する。
	 * @param _201056
	 */
	protected void set_201056(int _201056) {
		this._201056 = _201056;
	}
	/**
	 * 居宅サービス計画者事業所名を取得する。
	 * @return
	 */
	protected String get_201057() {
		return _201057;
	}
	/**
	 * 居宅サービス計画者事業所名を設定する。
	 * @param _201057
	 */
	protected void set_201057(String _201057) {
		this._201057 = _201057;
	}
	/**
	 * 公費1 公費種類(KOHI_TYPE)を取得する。
	 * @return
	 */
	protected String get_201058() {
		return _201058;
	}
	/**
	 * 公費1 公費種類(KOHI_TYPE)を設定する。
	 * @param _201058
	 */
	protected void set_201058(String _201058) {
		this._201058 = _201058;
	}
	/**
	 * 公費2 公費種類(KOHI_TYPE)を取得する。
	 * @return
	 */
	protected String get_201059() {
		return _201059;
	}
	/**
	 * 公費2 公費種類(KOHI_TYPE)を設定する。
	 * @param _201059
	 */
	protected void set_201059(String _201059) {
		this._201059 = _201059;
	}
	/**
	 * 公費3 公費種類(KOHI_TYPE)を取得する。
	 * @return
	 */
	protected String get_201060() {
		return _201060;
	}
	/**
	 * 公費3 公費種類(KOHI_TYPE)を設定する。
	 * @param _201060
	 */
	protected void set_201060(String _201060) {
		this._201060 = _201060;
	}
	/**
	 * 主傷病名を取得する。
	 * @return
	 */
	protected String get_201061() {
		return _201061;
	}
	/**
	 * 主傷病名を設定する。
	 * @param _201061
	 */
	protected void set_201061(String _201061) {
		this._201061 = _201061;
	}
	
	private boolean isNew(){
		//交換情報レコードに登録が無ければ新規とみなす。
		return ((get_201001() == null) || ("".equals(get_201001())));
	}
	
	/**
	 * 情報の確定処理を行う。
	 * @param type
	 * @throws Exception
	 */
	protected void parse(QP001RecordType type,QP001PatientState patientState,QP001KohiKey[] kohiTypes,QP001Manager manager) throws Exception {
        
		//[ID:0000567][Shin Fujihara] 2009/12/10 del begin 2009年度対応
		/*
        int history_id = 0;
        String history_id_temp = "";
        
        history_id_temp = patientState.getChangeData(type.get_701044(),"1","CHANGES_HISTORY_ID","1");
        
        if(!ACTextUtilities.isNullText(history_id_temp)){
            history_id = ACCastUtilities.toInt(history_id_temp);
        }
        //現在保持しているIDよりも大きい場合
        if(history_id > _201021_id){
            //開始年月日8桁(YYYYMMDD)
            set_201021(patientState.getChangeData(type.get_701044(),"1","CHANGES_DATE","1").replaceAll("-",""));
            _201021_id = history_id;
        }
        
        history_id = 0;
        history_id_temp = patientState.getChangeData(type.get_701044(),"2","CHANGES_HISTORY_ID","1");
        if(!ACTextUtilities.isNullText(history_id_temp)){
            history_id = ACCastUtilities.toInt(history_id_temp);
        }
        if(history_id > _201022_id){
            //中止年月日8桁(YYYYMMDD)
            set_201022(patientState.getChangeData(type.get_701044(),"2","CHANGES_DATE","1").replaceAll("-",""));
            //中止理由コード1桁1-非該当 2-介護施設 3-医療機関入院 4-死亡 5-その他
            set_201023(patientState.getChangeDatatoInt(type.get_701044(),"2","CHANGES_REASON","1"));
            _201022_id = history_id;
        }
        */
        //[ID:0000567][Shin Fujihara] 2009/12/10 del end 2009年度対応
		
		//[ID:0000567][Shin Fujihara] 2009/12/10 add begin 2009年度対応
		//異動情報の最新データ採用という仕様から、登録されている
		//日付が若い者を開始年月日として採用する仕様に変更
		//終了日は、日付の古いほうを採用
		
		//開始年月日のデータを確認
		int value_temp = ACCastUtilities.toInt(
				patientState.getChangeData(type.get_701044(),"1","CHANGES_DATE","1").replaceAll("-",""), Integer.MAX_VALUE);
		
		if (value_temp < ACCastUtilities.toInt(get_201021(), Integer.MAX_VALUE)) {
			// 開始年月日8桁(YYYYMMDD)
			set_201021(ACCastUtilities.toString(value_temp));
		}
		
		//中止年月日のデータを確認
		value_temp = ACCastUtilities.toInt(
				patientState.getChangeData(type.get_701044(),"2","CHANGES_DATE","1").replaceAll("-",""), Integer.MIN_VALUE);
		
		
		if (ACCastUtilities.toInt(get_201022(), Integer.MIN_VALUE) < value_temp) {
			// 中止年月日8桁(YYYYMMDD)
			set_201022(ACCastUtilities.toString(value_temp));
			//中止理由コード1桁1-非該当 2-介護施設 3-医療機関入院 4-死亡 5-その他
			set_201023(patientState.getChangeDatatoInt(type.get_701044(),"2","CHANGES_REASON","1"));
		}
		//[ID:0000567][Shin Fujihara] 2009/12/10 add end 2009年度対応
        
        
        //[ID:0000447][Shin Fujihara] 2009/02 add begin 平成21年4月法改正対応
        //入所(院)前の状態コード　前回情報引継ぎ
        //様式が第六～六の四、八、九、十に限る
		if (QP001SpecialCase.isAdmissionStatusCodeTakeover(type.get_701001())) {
	        Object _201023temp = patientState.getLastDataCategory2(type.get_701001(), "201023");
	        if ((_201023temp != null) && (ACCastUtilities.toInt(_201023temp, 0) != 0)) {
	        	set_201023(ACCastUtilities.toInt(_201023temp, 0));
	        } else {
	        	//[ID:0000567][Shin Fujihara] 2009/12/10 del begin 2009年度対応
	        	/*
	            history_id = 0;
	            history_id_temp = patientState.getChangeData(type.get_701044(),"1","CHANGES_HISTORY_ID","2,3,5");
	            if(!ACTextUtilities.isNullText(history_id_temp)){
	                history_id = ACCastUtilities.toInt(history_id_temp);
	            }
	            if(history_id > _201022_id){
	                //中止理由・入所（院）前の状況コード
	            	//1:居宅 2:医療機関 3:介護老人福祉施設 4:介護老人保健施設
	            	//5:介護療養型医療施設 6:認知症対応型共生活介護 7:特定施設入居者生活介護 8:その他 
	                set_201023(patientState.getChangeDatatoInt(type.get_701044(),"1","CHANGES_REASON","2,3,5"));
	                _201022_id = history_id;
	            }
	            */
	            //[ID:0000567][Shin Fujihara] 2009/12/10 del end 2009年度対応
	        	
	        	//[ID:0000567][Shin Fujihara] 2009/12/10 add begin 2009年度対応
	    		value_temp = ACCastUtilities.toInt(
	    				patientState.getChangeData(type.get_701044(),"1","CHANGES_DATE","2,3,5").replaceAll("-",""), Integer.MIN_VALUE);
	        	
	    		if (ACCastUtilities.toInt(get_201022(), Integer.MIN_VALUE) < value_temp) {
	                //中止理由・入所（院）前の状況コード
	            	//1:居宅 2:医療機関 3:介護老人福祉施設 4:介護老人保健施設
	            	//5:介護療養型医療施設 6:認知症対応型共生活介護 7:特定施設入居者生活介護 8:その他
	    			set_201023(patientState.getChangeDatatoInt(type.get_701044(),"1","CHANGES_REASON","2,3,5"));
	    		} 
                //[ID:0000567][Shin Fujihara] 2009/12/10 add end 2009年度対応
	        }
        }
        //[ID:0000447][Shin Fujihara] 2009/02 add end 平成21年4月法改正対応
        
        //退所年月日、退所後の状態コードは無視する仕様に変更
        //一転、参照する仕様に変更
        set_201025("");
        set_201028(0);
        
        //入所年月日を決定する
        setHospitalization(patientState, type);
        
		if(isNew()){
			//交換情報識別番号
			set_201001(type.get_701001());
			//サービス提供年月6桁(YYYYMM)
			set_201003(type.get_701003());
			//事業所番号10桁
			set_201004(type.get_701004());
			//証記載保険者番号8桁
			set_201005(type.get_701005());
			//被保険者番号
			set_201006(type.get_701006());

            if(!ACTextUtilities.isNullText(kohiTypes[0])){
                //(公費1)負担者番号8桁
                set_201007(patientState.getKohiData(kohiTypes[0],"KOHI_PAYER_NO",1));
                //(公費1)受給者番号7桁
                set_201008(patientState.getKohiData(kohiTypes[0],"KOHI_RECIPIENT_NO",1));
            }
            if(!ACTextUtilities.isNullText(kohiTypes[1])){
                //(公費2)負担者番号8桁
                set_201009(patientState.getKohiData(kohiTypes[1],"KOHI_PAYER_NO",1));
                //(公費2)受給者番号7桁
                set_201010(patientState.getKohiData(kohiTypes[1],"KOHI_RECIPIENT_NO",1));
            }
            if(!ACTextUtilities.isNullText(kohiTypes[2])){
                //(公費3)負担者番号8桁
                set_201011(patientState.getKohiData(kohiTypes[2],"KOHI_PAYER_NO",1));
                //(公費3)受給者番号7桁
                set_201012(patientState.getKohiData(kohiTypes[2],"KOHI_RECIPIENT_NO",1));
            }
			
			//(被保険者情報)生年月日8桁YYYYMMDD
			set_201013(patientState.getPatientData("PATIENT_BIRTHDAY").replaceAll("-",""));
			//(被保険者情報)性別コード1桁1-男 2-女
			set_201014(patientState.getPatientData("PATIENT_SEX"));
			//(被保険者情報)要介護状態区分コード2桁01-非該当 11-要支援 21-要介護1 22-要介護2 23-要介護3 24-要介護4 25-要介護5
			set_201015(patientState.getNinteiDataLast(get_201005(),get_201006(),"JOTAI_CODE"));
			//(被保険者情報)旧措置入所者特例コード1桁1-なし 2-あり
            set_201016(patientState.getShisetsuData("KYUSOCHI_FLAG"));
			//(被保険者情報)認定有効期間 開始年月日8桁(YYYYMMDD)
			set_201017(patientState.getNinteiDataLast(get_201005(),get_201006(),"INSURE_VALID_START").replaceAll("-",""));
			//(被保険者情報)認定有効期間 終了年月日8桁(YYYYMMDD)
			set_201018(patientState.getNinteiDataLast(get_201005(),get_201006(),"INSURE_VALID_END").replaceAll("-",""));
            
            //居宅介護支援専門員番号が必用な様式であれば設定する。
            if(QP001SpecialCase.isServicePlanMakerLiving(get_201001())){
                //(居宅サービス計画)居宅サービス計画作成区分コード1桁1-居宅介護支援事業所作成 2-自己作成
                if(!ACTextUtilities.isNullText(patientState.getNinteiDataLast(get_201005(),get_201006(),"PLANNER"))){
                    set_201019(ACCastUtilities.toInt(patientState.getNinteiDataLast(get_201005(),get_201006(),"PLANNER")));
                }
                //(居宅サービス計画)事業所番号10桁(居宅介護支援事業所)
                set_201020(patientState.getNinteiDataLast(get_201005(),get_201006(),"PROVIDER_ID"));
            }
            
			//保険給付率3桁
			set_201029(type.get_701040());
			
			//居宅サービス計画者事業所名
			//set_201057(QP001Manager.getInstance().getProviderName(get_201004()));
			// edit sta 2006.5.17 fujihara.shin
			// 一律ログイン事業所が表示されていた。計画事業所の名称を設定するよう変更
            //set_201057(manager.getProviderName(get_201004()));
			if(!ACTextUtilities.isNullText(get_201020()) && !"null".equalsIgnoreCase(get_201020())){
				set_201057(manager.getProviderName(get_201020()));
			}
            // edit end 2006.5.17 fujihara.shin
            

			//主傷病名
			set_201061(patientState.getShisetsuData("DISEASE"));

		}
        
        //(合計情報 保険)サービス単位数8桁
        set_201033(get_201033() + type.get_701014());
        //(合計情報 保険)請求額9桁
        set_201034(get_201034() + type.get_701016());
        //(合計情報 保険)利用者負担額8桁
        set_201035(get_201035() + type.get_701017());
        
        //(合計情報 公費1)サービス単位数8桁
        set_201039(get_201039() + type.get_701018());
        //(合計情報 公費1)請求額8桁
        set_201040(get_201040() + type.get_701019());
        //(合計情報 公費1)本人負担額8桁
        set_201041(get_201041() + type.get_701020());
        
        //(合計情報 公費2)サービス単位数8桁
        set_201045(get_201045() + type.get_701021());
        //(合計情報 公費2)請求額8桁
        set_201046(get_201046() + type.get_701022());
        //(合計情報 公費2)本人負担額8桁
        set_201047(get_201047() + type.get_701023());
        
        //(合計情報 公費3)サービス単位数8桁
        set_201051(get_201051() + type.get_701024());
        //(合計情報 公費3)請求額8桁
        set_201052(get_201052() + type.get_701025());
        //(合計情報 公費3)本人負担額8桁
        set_201053(get_201053() + type.get_701026());
        
        
        //様式の種別により、設定する値を変更する。
     if(QP001SpecialCase.isIncludingDiagnosis(get_201001())) {
            //様式第五、第十の場合は特定診療費情報として扱う
            //(合計情報 保険)特定診療費請求額9桁
            set_201037(get_201037() + type.get_701028());
            //(合計情報 公費1)特定診療費請求額8桁
            set_201043(get_201043() + type.get_701031());
            //(合計情報 公費2)特定診療費請求額8桁
            set_201049(get_201049() + type.get_701034());
            //(合計情報 公費3)特定診療費請求額8桁
            set_201055(get_201055() + type.get_701037());
            //(合計情報 公費3)本人負担額8桁
        }
        
        
        //公費使用の確定
        //公費１を使用していれば値を設定する。
        if(get_201039() > 0){
            if(!ACTextUtilities.isNullText(kohiTypes[0])){
                //公費1給付率
                set_201030(ACCastUtilities.toInt(patientState.getKohiData(kohiTypes[0],"BENEFIT_RATE",1),0));
                //公費1 公費種類(KOHI_TYPE)
                set_201058(kohiTypes[0].getKohiType());
            }
        }
        //公費２を使用していれば値を設定する。
        if(get_201045() > 0){
            if(!ACTextUtilities.isNullText(kohiTypes[1])){
                //公費2給付率
                set_201031(ACCastUtilities.toInt(patientState.getKohiData(kohiTypes[1],"BENEFIT_RATE",1),0));
                //公費2 公費種類(KOHI_TYPE)
                set_201059(kohiTypes[1].getKohiType());
            }
        }
        //公費３を使用していれば値を設定する。
        if(get_201051() > 0){
            if(!ACTextUtilities.isNullText(kohiTypes[2])){
                //公費3給付率
                set_201032(ACCastUtilities.toInt(patientState.getKohiData(kohiTypes[2],"BENEFIT_RATE",1),0));
                //公費3 公費種類(KOHI_TYPE)
                set_201060(kohiTypes[2].getKohiType());
            }
        }
        
        
        //平成１８年４月制度改正にかかる請求明細書・給付管理票の記載例について
        //要介護度が変更されている場合は、変更日の前日（システム的には変更前の要介護度の終了日）
        //を終了日として設定する。
        setStopDate(patientState);
        
	}
    
    /**
     * 特定診療費情報レコードの費用を設定する。
     * @param diagnosis
     * @throws Exception
     */
    protected void parse(QP001RecordDiagnosis diagnosis,QP001PatientState patientState, QP001KohiKey[] kohiTypes) throws Exception {
        
        if(diagnosis == null) return;
        
        //公費使用の確定
        //公費１を使用していれば値を設定する。
        if((diagnosis.get_501016() > 0) && (get_201030() == 0)){
            if(!ACTextUtilities.isNullText(kohiTypes[0])){
                //公費1給付率
                set_201030(ACCastUtilities.toInt(patientState.getKohiData(kohiTypes[0],"BENEFIT_RATE",1),0));
                //公費1 公費種類(KOHI_TYPE)
                set_201058(kohiTypes[0].getKohiType());
            }
        }
        //公費２を使用していれば値を設定する。
        if((diagnosis.get_501019() > 0) && (get_201031() == 0)){
            if(!ACTextUtilities.isNullText(kohiTypes[1])){
                //公費2給付率
                set_201031(ACCastUtilities.toInt(patientState.getKohiData(kohiTypes[1],"BENEFIT_RATE",1),0));
                //公費2 公費種類(KOHI_TYPE)
                set_201059(kohiTypes[1].getKohiType());
            }
        }
        //公費３を使用していれば値を設定する。
        if((diagnosis.get_501022() > 0) && (get_201032() == 0)){
            if(!ACTextUtilities.isNullText(kohiTypes[2])){
                //公費3給付率
                set_201032(ACCastUtilities.toInt(patientState.getKohiData(kohiTypes[2],"BENEFIT_RATE",1),0));
                //公費3 公費種類(KOHI_TYPE)
                set_201060(kohiTypes[2].getKohiType());
            }
        }
        
        //特定診療費情報レコードを使用した処理の拡張用
    }
    
    
    /**
     * 緊急時情報レコードの費用を設定する。
     * @param emergency
     * @throws Exception
     */
    protected void parse(QP001RecordEmergency emergency) throws Exception {
        
        if(emergency == null) return;
        //緊急時情報レコードを対象とした処理の拡張用
        // add sta 2006.05.20 fujihara.shin
        // 緊急時情報レコードが空白の場合、値を設定する処理を追加
        // 交換識別番号が空白の場合、基本情報レコードの値をコピーする
        if(ACTextUtilities.isNullText(emergency.get_401001())){
        	//交換識別番号
        	emergency.set_401001(get_201001());
        	//サービス提供年月6桁(YYYYMM)
        	emergency.set_401003(get_201003());
        	//事業所番号
        	emergency.set_401004(get_201004());
        	//証記載保険者番号8桁
        	emergency.set_401005(get_201005());
        	//被保険者番号10桁
        	emergency.set_401006(get_201006());
        }
        // add end 2006.05.20 fujihara.shin
        
    }
    
    
    /**
     * 緊急時情報レコードの費用を設定する。
     * @param emergency
     * @throws Exception
     */
    protected void parse(QP001RecordEmergencyOwnFacility emergencyOwnFacility) throws Exception {
        
        if(emergencyOwnFacility == null) return;
        //緊急時情報レコードを対象とした処理の拡張用
        // 緊急時情報レコードが空白の場合、値を設定する処理を追加
        // 交換識別番号が空白の場合、基本情報レコードの値をコピーする
        if(ACTextUtilities.isNullText(emergencyOwnFacility.get_1701001())){
            //交換識別番号
            emergencyOwnFacility.set_1701001(get_201001());
            //サービス提供年月6桁(YYYYMM)
            emergencyOwnFacility.set_1701003(get_201003());
            //事業所番号
            emergencyOwnFacility.set_1701004(get_201004());
            //証記載保険者番号8桁
            emergencyOwnFacility.set_1701005(get_201005());
            //被保険者番号10桁
            emergencyOwnFacility.set_1701006(get_201006());
        }
        
    }
    
    /**
     * 特定入所者の費用を設定する。
     * @param nursing
     * @throws Exception
     */
    protected void parse(QP001RecordNursing nursing,QP001PatientState patientState, QP001KohiKey[] kohiTypes) throws Exception {
        if(nursing == null) return;
        
        //(合計情報 保険)特定入所者介護サービス費等請求額8桁
        set_201038(get_201038() + nursing.get_801023());
        
        //(合計情報 公費1)特定入所者介護サービス費等請求額8桁
        if((nursing.get_801025()) > 0){
            set_201044(get_201044() + nursing.get_801026());
            if(get_201030() == 0){
                if(!ACTextUtilities.isNullText(kohiTypes[0])){
                    //公費1給付率
                    set_201030(ACCastUtilities.toInt(patientState.getKohiData(kohiTypes[0],"BENEFIT_RATE",1),0));
                    //公費1 公費種類(KOHI_TYPE)
                    set_201058(kohiTypes[0].getKohiType());
                }
            }
        }
        //(合計情報 公費2)特定入所者介護サービス費等請求額8桁
        if(nursing.get_801028() > 0){
            set_201050(get_201050() + nursing.get_801029());
            if(get_201031() == 0){
                if(!ACTextUtilities.isNullText(kohiTypes[1])){
                    //公費2給付率
                    set_201031(ACCastUtilities.toInt(patientState.getKohiData(kohiTypes[1],"BENEFIT_RATE",1),0));
                    //公費2 公費種類(KOHI_TYPE)
                    set_201059(kohiTypes[1].getKohiType());
                }
            }
        }
        //(合計情報 公費3)特定入所者介護サービス費等請求額8桁
        if(nursing.get_801031() > 0){
            set_201056(get_201056() + nursing.get_801032());
            if(get_201032() == 0){
                if(!ACTextUtilities.isNullText(kohiTypes[2])){
                    //公費3給付率
                    set_201032(ACCastUtilities.toInt(patientState.getKohiData(kohiTypes[2],"BENEFIT_RATE",1),0));
                    //公費3 公費種類(KOHI_TYPE)
                    set_201060(kohiTypes[2].getKohiType());
                }
            }
        }
        
        
    }
    
    /**
     * 入所（入院）日等を設定する。
     * @param patientState
     * @param type
     * @throws Exception
     */
	private void setHospitalization(QP001PatientState patientState,QP001RecordType type) throws Exception {
        
        /*
         * ■様式第三、第四、第五、第六の五の場合
         * ※予防対応
         * 様式第六の六
         * 【入所日】
         * 対象月の一番初めに実績が入力されている日が入所日とする。
         * 
         * 【退所日】
         * 入所日から入所の実績が途切れた日を退所日とする。
         * 
         * ※異動情報は参照せず、実績のみで判定する。
         */
	    if (QP001SpecialCase.isShortStay(type.get_701001())) {
            //異動事由は無視する。
            
            //日付格納用
            int dayMap = 0;
            Date temp = null;
            boolean hit = false;
//            int days = 0;
            
            //実績の日付データを展開
            for (int i = 0; i < type.getEntranceRealDays().size(); i++) {
                temp = (Date) type.getEntranceRealDays().get(i);
                dayMap = dayMap | (1 << (ACDateUtilities.getDayOfMonth(temp) - 1));
            }
            for(int i = 0; i < 31; i++){
                //ビットがたっている
                if((dayMap & 1) == 1){
                    //初ヒットなら、入所日とする。
                    if(!hit){
                        if(i < 9){
                            set_201024(type.get_701003() + "0" + (i + 1));
                        } else {
                            set_201024(type.get_701003() + (i + 1));
                        }
                        hit = true;
                    }
                    //入所日数をカウント
//                    days++;
                //ビットがたっていない
                } else {
                    //既にhitしていれば終了する
                    if(hit){
                        //終了するときが退所日
                        if(i < 10){
                            set_201025(type.get_701003() + "0" + i);
                        } else {
                            set_201025(type.get_701003() + i);
                        }
                        break;
                    }
                }
                //ビットを右にシフト
                dayMap = dayMap >>> 1;
            }
            //実日数は実績に貼り付けた個数とする
            //set_201026(String.valueOf(days));
            //set_201026(String.valueOf(type.getEntranceRealDays().size()));
            //基本情報レコードの入所実日数は0とする。
            set_201026("0");
            //集計情報レコードの短期入所実日数に設定する。
            type.set_701013(type.getEntranceRealDays().size());
            //外泊日数は0とする
            set_201027("0");
        }
        /*
         * ■様式第六と第六の三、様式八から十の場合
         * 　※予防対応
         * 　様式第六の二、六の四を追加
         * 【入所日】
         * 対象月の直前の入所年月日を取得する。
         *  取得できた場合
         *      取得した日付を入所日とする。
         *  取得できなかった場合
         *      対象月の一番初めに実績が入力されている日を入所日とする。
         * 
         * 【退所日】
         * 取得した入所日と月末の間にある退所の移動情報を取得する。
         *  取得できた場合
         *      取得した日付を退所日とする。
         *  ※退所日が来月以降に存在する場合には、退所日を設定しない。
         *      かつ、当月は入所中とみなす
         *      
         *  退所日が存在しない場合
         *  →実績の終了が退所日
         *  月末に実績が存在する場合は、退所日を設定しない。
         *  
         *  ※退所日が取得できた場合には、退所後の情況反映させる。
         */
        else if(QP001SpecialCase.isLongStay(type.get_701001())){
            //処理対象月
            Date nowDate = ACCastUtilities.toDate(type.get_701003() + "01");
            
            //入所日
            Date entryDate = null;
            //退所日
            Date endDate = null;
            //実績の最終日
            Date realEndDate = null;
            //日付テンポラリ領域
            Date temp = null;
            //退所日確定フラグ
            boolean commitOut = false;
            
            //============入所日確定スタート================
            //異動事由データより入所日を取得する。
            //[ID:0000750][Shin Fujihara] 2012/09 edit 2012年度対応 異動情報から入・退院日の取得方法変更
            //大幅修正の為、過去コメントを削除しつつ修正　履歴はCVS参照
            
            VRMap entry = patientState.getChangeDataAll(type.get_701044(), type.get_701003());
            VRMap in = (VRMap)entry.get("IN");
            VRMap out = (VRMap)entry.get("OUT");
            
            
            //入所日が取得できた場合、入所年月日と入所理由を確定する。
            if (in != null) {
            	entryDate = ACCastUtilities.toDate(in.get("CHANGES_DATE"),null);
                set_201023(ACCastUtilities.toInt(in.get("CHANGES_REASON"),0));
            }
            
            //前回情報の入所日を設定する。
            if ((entryDate == null)
            	&& ACTextUtilities.isNullText(patientState.getLastDataCategory2(type.get_701001(), "201025"))) {
            	Object _201024 = patientState.getLastDataCategory2(type.get_701001(), "201024");
            	if (!ACTextUtilities.isNullText(_201024)) {
            		entryDate = ACCastUtilities.toDate(_201024);
            	}
            }
            
            //履歴が取れなければ、実績を見に行く
            if (entryDate == null) {
                for (int i = 0; i < type.getEntranceRealDays().size(); i++) {
                    if (entryDate == null) {
                        entryDate = (Date) type.getEntranceRealDays().get(i);
                    }
                    if (ACDateUtilities.compareOnDay((Date) type.getEntranceRealDays().get(i), entryDate) < 0) {
                        entryDate = (Date) type.getEntranceRealDays().get(i);
                    }
                }
            }
            
            //入所日を設定する。
            if(entryDate != null){
                set_201024(VRDateParser.format(entryDate,"yyyyMMdd"));
            }
            //============入所日確定エンド================
            
            //============退所日確定スタート================
            //実績の最終日を取得する。
            temp = null;
            //実績の日付データを展開し、実績の入力されている最終日を取得する。
            for (int i = 0; i < type.getEntranceRealDays().size(); i++) {
                temp = (Date) type.getEntranceRealDays().get(i);
                if(realEndDate == null){
                    realEndDate = temp;
                }
                if(ACDateUtilities.compareOnDay(realEndDate,temp) < 0){
                    realEndDate = temp;
                }
            }
            //外泊データも展開
            for(int i = 0; i < type.getOutEntranceRealDays().size(); i++){
                temp = (Date) type.getOutEntranceRealDays().get(i);
                if(realEndDate == null){
                    realEndDate = temp;
                }
                if(ACDateUtilities.compareOnDay(realEndDate,temp) < 0){
                    realEndDate = temp;
                }
            }
            
            //退所日が取得できた場合
            if(out != null){
                //退所日と退所理由を確定する。
                temp = ACCastUtilities.toDate(out.get("CHANGES_DATE"),null);
                if(temp != null){
                    //入所日以降であることを確認
                    if(ACDateUtilities.compareOnDay(entryDate,temp) < 0){
                        //当月であることを確認
                        if(ACDateUtilities.compareOnMonth(ACCastUtilities.toDate(type.get_701003() + "01"),temp) == 0){
                            //一旦、退所日を確定とする。(実績を見る必要なし)
                            commitOut = true;
                            //設定されている退所日が実績の最終日以降であることを確認する。
                            if(ACDateUtilities.compareOnDay(realEndDate,temp) <= 0){
                                //退所日として確定する。
                                endDate = temp;
                                set_201025(VRDateParser.format(endDate,"yyyyMMdd"));
                                //異動事由を設定する。
                                set_201028(ACCastUtilities.toInt(out.get("CHANGES_REASON"),0));
                            } else{
                                //異動情報の退所日以降に実績が存在する場合は、実績を採用する
                                //実績を採用するため、フラグを戻す
                                commitOut = false;
                            }
                        }
                    }
                }
            }
            //退所日未確定の場合は、実績の最終日を退所日として採用する
            if(!commitOut && realEndDate != null){
                //実績の最終日が月末でなければ、退所日として確定する。
                if(ACDateUtilities.getLastDayOfMonth(nowDate) != ACDateUtilities.getDayOfMonth(realEndDate)){
                    endDate = realEndDate;
                    set_201025(VRDateParser.format(endDate,"yyyyMMdd"));
                    
                 //実績の最終日が月末であれば、継続入所とみなす。
                } else {
                    endDate = null;
                }                
            }
            //============退所日確定エンド================
            
            
            //入所（入院）実日数の設定
            int dateCount = 0;
            for (int i = 0; i < type.getEntranceRealDays().size(); i++) {
                //入所日以降の入所実績をカウント
                if(ACDateUtilities.compareOnDay(entryDate,(Date) type.getEntranceRealDays().get(i)) <= 0){
                    dateCount++;
                }
            }
            type.set_701013(dateCount);
            set_201026(String.valueOf(dateCount));
            
            
            //外泊の自動判定を廃止　外泊加算が算定されている日のみを外泊として扱う
//            //nullチェック
//            if(entryDate != null){
//                //入所日が当月以前であれば
//                if(ACDateUtilities.compareOnMonth(entryDate,nowDate) < 0){
//                    if(endDate == null){
//                        set_201027(String.valueOf(ACDateUtilities.getLastDayOfMonth(nowDate) - dateCount));
//                    } else {
//                        set_201027(String.valueOf(ACDateUtilities.getDifferenceOnTotalDay(endDate,nowDate) - dateCount + 1));
//                    }
//                    
//                } else {
//                    //外泊日数2桁
//                    if(endDate == null){
//                        set_201027(String.valueOf(ACDateUtilities.getLastDayOfMonth(entryDate) - ACDateUtilities.getDayOfMonth(entryDate) - dateCount + 1));
//                    } else {
//                        set_201027(String.valueOf(ACDateUtilities.getDifferenceOnTotalDay(endDate,entryDate) - dateCount + 1));
//                    }
//                }
//            } else {
//                //外泊日数は設定されている値を参照する。
//                set_201027(String.valueOf(type.getOutEntranceRealDays().size()));
//            }
            
            //[CCCX:1456][Shinobu Hitaka] 2014/01/21 edit - begin GHの外泊日数取得対応
            //GH外泊は加算がないので外泊日数が集計されていなかった
            //----- del - begin
            //外泊日数は設定されている値を参照する。
            //set_201027(String.valueOf(type.getOutEntranceRealDays().size()));
            //----- del - end
            //----- add - begin
            //様式六　　（32：認知症対応型共同生活介護_短期利用以外）
            //様式六の二（37：認知症対応型共同生活介護_短期利用以外）
            //様式六の三（33：特定施設入居者生活介護_短期利用以外，36：地域密着型特定施設入居者生活介護_短期利用以外）
            //様式六の四（35：介護予防特定施設入居者生活介護）
            if (QP001StyleAbstract.IDENTIFICATION_NO_6_201204.equals(type.get_701001()) 
                    || QP001StyleAbstract.IDENTIFICATION_NO_6_2_201204.equals(type.get_701001())
                    || QP001StyleAbstract.IDENTIFICATION_NO_6_3_201204.equals(type.get_701001())
                    || QP001StyleAbstract.IDENTIFICATION_NO_6_4_201204.equals(type.get_701001())
                    ) {
                //nullチェック
                if(entryDate != null){
                    //入所日が当月以前であれば
                    if(ACDateUtilities.compareOnMonth(entryDate,nowDate) < 0){
                        if(endDate == null){
                            set_201027(String.valueOf(ACDateUtilities.getLastDayOfMonth(nowDate) - dateCount));
                        } else {
                            set_201027(String.valueOf(ACDateUtilities.getDifferenceOnTotalDay(endDate,nowDate) - dateCount + 1));
                        }
                    } else {
                        //外泊日数2桁
                        if(endDate == null){
                            set_201027(String.valueOf(ACDateUtilities.getLastDayOfMonth(entryDate) - ACDateUtilities.getDayOfMonth(entryDate) - dateCount + 1));
                        } else {
                            set_201027(String.valueOf(ACDateUtilities.getDifferenceOnTotalDay(endDate,entryDate) - dateCount + 1));
                        }
                    }
                } else {
                    //外泊日数は設定されている値を参照する。
                    set_201027(String.valueOf(type.getOutEntranceRealDays().size()));
                }
            } else {
                //外泊日数は設定されている値を参照する。
                set_201027(String.valueOf(type.getOutEntranceRealDays().size()));
            }
            //----- add - end
            //[CCCX:1456][Shinobu Hitaka] 2014/01/21 edit - end GHの外泊日数取得対応（GH外泊は加算がないので外泊日数が集計されていなかった）
        }
    }
	
	/**
	 * 中止年月日を設定する。
	 * @param patientState 利用者状態オブジェクト
	 * @throws Exception
	 */
	private void setStopDate(QP001PatientState patientState) throws Exception {

		//[ID:0000539][Shin Fujihara] 2009/08 add begin 2009年度障害対応
		//様式第二、第二の二以外の様式であれば、処理を中断する
		if (!QP001StyleAbstract.IDENTIFICATION_NO_2_201204.equals(get_201001())
			&& !QP001StyleAbstract.IDENTIFICATION_NO_2_2_201204.equals(get_201001())) {
			return;
		}
		//[ID:0000539][Shin Fujihara] 2009/08 add end 2009年度障害対応
		
		/*
		 * 既に中止年月日が設定されている場合は処理を実行中断する。
		 */
		if(!ACTextUtilities.isNullText(get_201022())){
			return;
		}
		
		/*
		 * 様式第二、様式第二の二の場合で、且つつじつまが合わない帳票の場合のみ
		 * 中止年月日の設定を行う。
		 */
		
		//様式第二
		if(QP001StyleAbstract.IDENTIFICATION_NO_2_201204.equals(get_201001())){
			//要介護状態区分
			//要支援１、要支援２ではない場合は正常な帳票とみなす
			if(!"12".equals(get_201015()) && !"13".equals(get_201015())){
				return;
			}
		}
		
		//様式第二の二
		if(QP001StyleAbstract.IDENTIFICATION_NO_2_2_201204.equals(get_201001())){
			//要介護状態区分
			//要支援１、要支援２の場合は正常な帳票とみなす
			if("12".equals(get_201015()) || "13".equals(get_201015())){
				return;
			}
		}
		
		Date startDate = ACCastUtilities.toDate(patientState.getNinteiDataLast(get_201005(),get_201006(),"INSURE_VALID_START"),null);
		
		if(startDate == null){
			return;
		}
		
		Date endDate = ACDateUtilities.setDayOfMonth(startDate,ACDateUtilities.getDayOfMonth(startDate) - 1);
		
		//算出した日付と、認定履歴情報から取得した日付の月がことなれば、設定を行わない
		//(入力値のエラー)
		if(ACDateUtilities.getMonth(startDate) != ACDateUtilities.getMonth(endDate)){
			return;
		}
		
		//中止年月日8桁(YYYYMMDD)
		set_201022(VRDateParser.format(endDate,"yyyyMMdd"));
		//中止理由コード1桁1-非該当 2-介護施設 3-医療機関入院 4-死亡 5-その他
		//※中止理由コードは5固定
		set_201023(5);
		
	}
    
	/**
	 * データ作成
	 * @param style
	 * @return
	 */
	protected VRMap getRecord(VRMap style) throws Exception {
		VRMap result = copyStyle(style);
		
		//交換情報識別番号4桁
		setData(result,"201001",get_201001());
		//レコード種別コード2桁(01を設定)
		setData(result,"201002",get_201002());
		//サービス提供年月6桁(YYYYMM)
		setData(result,"201003",get_201003());
		//事業所番号10桁
		setData(result,"201004",get_201004());
		//証記載保険者番号8桁
		setData(result,"201005",get_201005());
		//被保険者番号10桁
		setData(result,"201006",get_201006());
		//(公費1)負担者番号8桁
		setData(result,"201007",get_201007());
		//(公費1)受給者番号7桁
		setData(result,"201008",get_201008());
		//(公費2)負担者番号8桁
		setData(result,"201009",get_201009());
		
		//(公費2)受給者番号7桁
		setData(result,"201010",get_201010());
		//(公費3)負担者番号8桁
		setData(result,"201011",get_201011());
		//(公費3)受給者番号7桁
		setData(result,"201012",get_201012());
		//(被保険者情報)生年月日8桁YYYYMMDD
		setData(result,"201013",get_201013());
		//(被保険者情報)性別コード1桁1-男 2-女
		setData(result,"201014",get_201014());
		//(被保険者情報)要介護状態区分コード2桁01-非該当 11-要支援 21-要介護1 22-要介護2 23-要介護3 24-要介護4 25-要介護5
		setData(result,"201015",get_201015());
		//(被保険者情報)旧措置入所者特例コード1桁1-なし 2-あり
		setData(result,"201016",get_201016());
		//(被保険者情報)認定有効期間 開始年月日8桁(YYYYMMDD)
		setData(result,"201017",get_201017());
		//(被保険者情報)認定有効期間 終了年月日8桁(YYYYMMDD)
		setData(result,"201018",get_201018());
		//(居宅サービス計画)居宅サービス計画作成区分コード1桁1-居宅介護支援事業所作成 2-自己作成
		setData(result,"201019",get_201019());
		
		//(居宅サービス計画)事業所番号10桁(居宅介護支援事業所)
		setData(result,"201020",get_201020());
		//開始年月日8桁(YYYYMMDD)
		setData(result,"201021",get_201021());
		//中止年月日8桁(YYYYMMDD)
		setData(result,"201022",get_201022());
		//中止理由コード1桁1-非該当 2-介護施設 3-医療機関入院 4-死亡 5-その他
		setData(result,"201023",get_201023());
		//入所(院)年月日8桁(YYYYMMDD)
		setData(result,"201024",get_201024());
		//退所(院)年月日8桁(YYYYMMDD)
		setData(result,"201025",get_201025());
		//入所(院)実日数2桁
		setData(result,"201026",get_201026());
		//外泊日数2桁
		setData(result,"201027",get_201027());
		//退所(院)後の状態コード1桁1-居宅 2-介護施設 3-医療機関入院 4-死亡 5-その他
		setData(result,"201028",get_201028());
		//保険給付率3桁
		setData(result,"201029",get_201029());
		
		//公費1給付率
		setData(result,"201030",get_201030());
		//公費2給付率
		setData(result,"201031",get_201031());
		//公費3給付率
		setData(result,"201032",get_201032());
		//(合計情報 保険)サービス単位数8桁
		setData(result,"201033",get_201033());
		//(合計情報 保険)請求額9桁
		setData(result,"201034",get_201034());
		//(合計情報 保険)利用者負担額8桁
		setData(result,"201035",get_201035());
		//(合計情報 保険)緊急時施設療養費請求額9桁
		setData(result,"201036",get_201036());
		//(合計情報 保険)特定診療費請求額9桁
		setData(result,"201037",get_201037());
		//(合計情報 保険)特定入所者介護サービス費等請求額8桁
		setData(result,"201038",get_201038());
		//(合計情報 公費1)サービス単位数8桁
		setData(result,"201039",get_201039());
		
		//(合計情報 公費1)請求額8桁
		setData(result,"201040",get_201040());
		//(合計情報 公費1)本人負担額8桁
		setData(result,"201041",get_201041());
		//(合計情報 公費1)緊急時施設療養費請求額8桁
		setData(result,"201042",get_201042());
		//(合計情報 公費1)特定診療費請求額8桁
		setData(result,"201043",get_201043());
		//(合計情報 公費1)特定入所者介護サービス費等請求額8桁
		setData(result,"201044",get_201044());
		//(合計情報 公費2)サービス単位数8桁
		setData(result,"201045",get_201045());
		//(合計情報 公費2)請求額8桁
		setData(result,"201046",get_201046());
		//(合計情報 公費2)本人負担額8桁
		setData(result,"201047",get_201047());
		//(合計情報 公費2)緊急時施設療養費請求額8桁
		setData(result,"201048",get_201048());
		//(合計情報 公費2)特定診療費請求額8桁
		setData(result,"201049",get_201049());
		
		//(合計情報 公費2)特定入所者介護サービス費等請求額8桁
		setData(result,"201050",get_201050());
		//(合計情報 公費3)サービス単位数8桁
		setData(result,"201051",get_201051());
		//(合計情報 公費3)請求額8桁
		setData(result,"201052",get_201052());
		//(合計情報 公費3)本人負担額8桁
		setData(result,"201053",get_201053());
		//(合計情報 公費3)緊急時施設療養費請求額8桁
		setData(result,"201054",get_201054());
		//(合計情報 公費3)特定診療費請求額8桁
		setData(result,"201055",get_201055());
		//(合計情報 公費3)特定入所者介護サービス費等請求額8桁
		setData(result,"201056",get_201056());
		//居宅サービス計画者事業所名
		setData(result,"201057",get_201057());
		//公費1 公費種類(KOHI_TYPE)
		setData(result,"201058",get_201058());
		//公費2 公費種類(KOHI_TYPE)
		setData(result,"201059",get_201059());
		
		//公費3 公費種類(KOHI_TYPE)
		setData(result,"201060",get_201060());
		//主傷病名
		setData(result,"201061",get_201061());
		
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
		//基本情報レコード
		result.put("CATEGORY_NO",QkanConstants.CATEGORY_NO_RECORD_BASIC_INFOMATION);
        
		return result;
	}
	
	public String toString(){
		StringBuilder result = new StringBuilder();
		result.append("[201001=" + get_201001() + "]\n");
		result.append("[201002=" + get_201002() + "]\n");
		result.append("[201003=" + get_201003() + "]\n");
		result.append("[201004=" + get_201004() + "]\n");
		result.append("[201005=" + get_201005() + "]\n");
		result.append("[201006=" + get_201006() + "]\n");
		result.append("[201007=" + get_201007() + "]\n");
		result.append("[201008=" + get_201008() + "]\n");
		result.append("[201009=" + get_201009() + "]\n");
		result.append("[201010=" + get_201010() + "]\n");
		result.append("[201011=" + get_201011() + "]\n");
		result.append("[201012=" + get_201012() + "]\n");
		result.append("[201013=" + get_201013() + "]\n");
		result.append("[201014=" + get_201014() + "]\n");
		result.append("[201015=" + get_201015() + "]\n");
		result.append("[201016=" + get_201016() + "]\n");
		result.append("[201017=" + get_201017() + "]\n");
		result.append("[201018=" + get_201018() + "]\n");
		result.append("[201019=" + get_201019() + "]\n");
		result.append("[201020=" + get_201020() + "]\n");
		result.append("[201021=" + get_201021() + "]\n");
		result.append("[201022=" + get_201022() + "]\n");
		result.append("[201023=" + get_201023() + "]\n");
		result.append("[201024=" + get_201024() + "]\n");
		result.append("[201025=" + get_201025() + "]\n");
		result.append("[201026=" + get_201026() + "]\n");
		result.append("[201027=" + get_201027() + "]\n");
		result.append("[201028=" + get_201028() + "]\n");
		result.append("[201029=" + get_201029() + "]\n");
		result.append("[201030=" + get_201030() + "]\n");
		result.append("[201031=" + get_201031() + "]\n");
		result.append("[201032=" + get_201032() + "]\n");
		result.append("[201033=" + get_201033() + "]\n");
		result.append("[201034=" + get_201034() + "]\n");
		result.append("[201035=" + get_201035() + "]\n");
		result.append("[201036=" + get_201036() + "]\n");
		result.append("[201037=" + get_201037() + "]\n");
		result.append("[201038=" + get_201038() + "]\n");
		result.append("[201039=" + get_201039() + "]\n");
		result.append("[201040=" + get_201040() + "]\n");
		result.append("[201041=" + get_201041() + "]\n");
		result.append("[201042=" + get_201042() + "]\n");
		result.append("[201043=" + get_201043() + "]\n");
		result.append("[201044=" + get_201044() + "]\n");
		result.append("[201045=" + get_201045() + "]\n");
		result.append("[201046=" + get_201046() + "]\n");
		result.append("[201047=" + get_201047() + "]\n");
		result.append("[201048=" + get_201048() + "]\n");
		result.append("[201049=" + get_201049() + "]\n");
		result.append("[201050=" + get_201050() + "]\n");
		result.append("[201051=" + get_201051() + "]\n");
		result.append("[201052=" + get_201052() + "]\n");
		result.append("[201053=" + get_201053() + "]\n");
		result.append("[201054=" + get_201054() + "]\n");
		result.append("[201055=" + get_201055() + "]\n");
		result.append("[201056=" + get_201056() + "]\n");
		result.append("[201057=" + get_201057() + "]\n");
		result.append("[201058=" + get_201058() + "]\n");
		result.append("[201059=" + get_201059() + "]\n");
		result.append("[201060=" + get_201060() + "]\n");
		result.append("[201061=" + get_201061() + "]\n");
		return result.toString();
	}
	
}
