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
 */
package jp.nichicom.ac.lib.care.claim.calculation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanSjServiceCodeManager;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanSjTankaManager;

/**
 * 総合事業 独自・独自定率・独自定額算定クラス
 * 
 * サービス種類ごとの事業費請求額、公費請求額、利用者負担額等を計算します
 * 
 * @author Yoichiro Kamei
 * 
 */
public class QP001SjClaimCalc {

	// 公費優先順タイプ
	public enum KohiyusenType {
		NONE, // 無し
		KOHI1, // 公費１
		KOHI2, // 公費２
		KOHI3 // 公費３
	};

	private String skind; // サービス種類コード(2桁)

	// 区分支給限度超単位数の格納されたマップ
	// キーは、
	// 独自定率：サービス種類-単位数単価-給付率
	// 独自定額：サービス種類-単位数単価-サービス項目コード
	private Map<String, Integer> sogoLimitOverMap;

	private Integer hokenKyufuritsu = null;// 保険給付率
	private Boolean isSeihotandoku = null; // 生保単独かどうか
	private int dokujiTotalSeikyugaku; // 独自の全体の請求額
	private int dokujiJigyohiSeikyugaku;// 独自の事業費請求額
	
	private int teiritsuTotalSeikyugaku; // 独自定率の全体の請求額
	private int teiritsuJigyohiSeikyugaku; // 独自定率の事業費請求額

	private int teigakuTotalSeikyugaku; // 独自定額の全体の請求額
	private int teigakuRiyoshaFutangaku; // 独自定額の利用者負担額
	private int teigakuKohi1Seikyugaku; // 独自定額の公費１請求額
	private int teigakuKohi2Seikyugaku; // 独自定額の公費２請求額
	private int teigakuKohi3Seikyugaku; // 独自定額の公費３請求額

	private static final String SERVICE_ITEM_CODE = "SERVICE_ITEM_CODE"; // サービス項目コード(4桁)
	private static final String TEIGAKU_FUTAN_TANKA = "TEIGAKU_FUTAN_TANKA"; // 独自定額の定額負担単価金額
	private static final String SOGO_KYUFURITSU = "SOGO_KYUFURITSU"; // 独自定率の給付率

	private static final String UNIT = "UNIT"; // 単位数
	private static final String SERVICE_COUNT = "SERVICE_COUNT"; // 回数
	private static final String SERVICE_UNIT = "SERVICE_UNIT"; // サービス単位数

	private static final String KOHI1_COUNT = "KOHI1_COUNT"; // 公費１分回数
	private static final String KOHI1_SERVICE_UNIT = "KOHI1_SERVICE_UNIT"; // 公費１対象単位数

	private static final String KOHI2_COUNT = "KOHI2_COUNT"; // 公費２分回数
	private static final String KOHI2_SERVICE_UNIT = "KOHI2_SERVICE_UNIT"; // 公費２対象単位数

	private static final String KOHI3_COUNT = "KOHI3_COUNT"; // 公費３分回数
	private static final String KOHI3_SERVICE_UNIT = "KOHI3_SERVICE_UNIT"; // 公費３対象単位数

	private Map<Double, List<Map<String, Object>>> dokujiMap = new HashMap<Double, List<Map<String, Object>>>();
	private Map<Double, Map<Integer, List<Map<String, Object>>>> teiritsuMap = new HashMap<Double, Map<Integer, List<Map<String, Object>>>>();
	private Map<Double, List<Map<String, Object>>> teigakuMap = new HashMap<Double, List<Map<String, Object>>>();

	/**
	 * コンストラクタ。
	 * 
	 * @param skind
	 *            サービス種類コード
	 * @param sogoLimitOverMap
	 *            区分支給超単位数マップ
	 */
	public QP001SjClaimCalc(String skind,
			Map sogoLimitOverMap) throws Exception {
		this.skind = skind;
		this.sogoLimitOverMap = sogoLimitOverMap;
	}

	/**
	 * 確定済みのQP001RecordDetailを解析します。
	 * 
	 * 独自定率：単位数単価、給付率ごとに格納 独自定額：単位数単価、システムサービス項目コードごとに格納
	 * 
	 * @param detail
	 *            QP001RecordDetail
	 * @throws Exception
	 */
	public void parseRecordDetail(QP001RecordDetail detail) throws Exception {
		// 保険給付率
		if (hokenKyufuritsu == null) {
			hokenKyufuritsu = ACCastUtilities.toInt(detail.get_301026(), 0);
		}
		// 生保単独かどうか
		if (isSeihotandoku == null) {
			String hihoban = ACCastUtilities.toString(detail.get_301006(), "");
			isSeihotandoku = hihoban.startsWith("H");
		}
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

		Integer kyufuritsu = ACCastUtilities.toInteger(detail.get_301028(),
				0);
		Integer teigakuFutan = ACCastUtilities.toInteger(detail.get_301029(),
				0);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put(SERVICE_ITEM_CODE, detail.get_301008());
		map.put(SOGO_KYUFURITSU, kyufuritsu);
		map.put(TEIGAKU_FUTAN_TANKA, teigakuFutan);
		map.put(UNIT, detail.get_301009());
		map.put(SERVICE_COUNT, detail.get_301010());
		map.put(SERVICE_UNIT, detail.get_301014());
		map.put(KOHI1_COUNT, detail.get_301011());
		map.put(KOHI1_SERVICE_UNIT, detail.get_301015());
		map.put(KOHI2_COUNT, detail.get_301012());
		map.put(KOHI2_SERVICE_UNIT, detail.get_301016());
		map.put(KOHI3_COUNT, detail.get_301013());
		map.put(KOHI3_SERVICE_UNIT, detail.get_301017());

		// 独自
		// 単価-明細レコードListの階層で格納
		if (QkanSjServiceCodeManager.dokujiKinds.contains(skind)) {
			addDokujiMap(unitPrice, map);
		}
		
		// 独自定率
		// 単価-給付率-明細レコードListの階層で格納
		if (QkanSjServiceCodeManager.teiritsuKinds.contains(skind)) {
			addTeiritsuMap(unitPrice, kyufuritsu, map);
		}

		// 独自定額
		// 単価-明細レコードListの階層で格納
		if (QkanSjServiceCodeManager.teigakuKinds.contains(skind)) {
			addTeigakuMap(unitPrice, map);
		}
	}
	
	
	/**
	 * 再集計時の明細レコードを解析します。
	 * 
	 * 独自定率：単位数単価、給付率ごとに格納 独自定額：単位数単価、システムサービス項目コードごとに格納
	 * 
	 * @param detail 再集計時の明細レコード
	 * @param rate 保険給付率
	 *            
	 * @throws Exception
	 */
	public void parseDetailForReTotal(Map detail, int rate) throws Exception {
		// 保険給付率
		if (hokenKyufuritsu == null) {
			hokenKyufuritsu = rate;
		}
		// 生保単独かどうか
		if (isSeihotandoku == null) {
			String hihoban = ACCastUtilities.toString(detail.get("301006"), "");
			isSeihotandoku = hihoban.startsWith("H");
		}
		// 保険者番号
		String insurerId;
		if (detail.get("1801018") != null) {
			insurerId = ACCastUtilities.toString(detail.get("1801018"));
		} else {
			insurerId = ACCastUtilities.toString(detail.get("301005"));
		}
		
		String systemServiceKindDetail = ACCastUtilities.toString(detail.get("301021"));
		// 総合事業の単位数単価
		Double unitPrice = QkanSjTankaManager.getUnitPrice(insurerId,
				systemServiceKindDetail);

		Integer kyufuritsu = ACCastUtilities.toInteger(detail.get("301028"),
				0);
		Integer teigakuFutan = ACCastUtilities.toInteger(detail.get("301029"),
				0);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put(SERVICE_ITEM_CODE, detail.get("301008"));
		map.put(SOGO_KYUFURITSU, kyufuritsu);
		map.put(TEIGAKU_FUTAN_TANKA, teigakuFutan);
		map.put(UNIT, detail.get("301009"));
		map.put(SERVICE_COUNT, detail.get("301010"));
		map.put(SERVICE_UNIT, detail.get("301014"));
		map.put(KOHI1_COUNT, detail.get("301011"));
		map.put(KOHI1_SERVICE_UNIT, detail.get("301015"));
		map.put(KOHI2_COUNT, detail.get("301012"));
		map.put(KOHI2_SERVICE_UNIT, detail.get("301016"));
		map.put(KOHI3_COUNT, detail.get("301013"));
		map.put(KOHI3_SERVICE_UNIT, detail.get("301017"));

		// 独自
		// 単価-明細レコードListの階層で格納
		if (QkanSjServiceCodeManager.dokujiKinds.contains(skind)) {
			addDokujiMap(unitPrice, map);
		}
		
		// 独自定率
		// 単価-給付率-明細レコードListの階層で格納
		if (QkanSjServiceCodeManager.teiritsuKinds.contains(skind)) {
			addTeiritsuMap(unitPrice, kyufuritsu, map);
		}

		// 独自定額
		// 単価-明細レコードListの階層で格納
		if (QkanSjServiceCodeManager.teigakuKinds.contains(skind)) {
			addTeigakuMap(unitPrice, map);
		}
	}

	// 独自の明細レコード格納
	private void addDokujiMap(Double unitPrice, Map<String, Object> detail) {
		// 単価
		List<Map<String, Object>> details;
		if (this.dokujiMap.containsKey(unitPrice)) {
			details = this.dokujiMap.get(unitPrice);
		} else {
			details = new ArrayList<Map<String, Object>>();
			this.dokujiMap.put(unitPrice, details);
		}
		details.add(detail);
	}
	
	// 独自定率の明細レコード格納
	private void addTeiritsuMap(Double unitPrice, Integer kyufuritsu,
			Map<String, Object> detail) {
		// 単価
		Map<Integer, List<Map<String, Object>>> kyufuritsuMap;
		if (this.teiritsuMap.containsKey(unitPrice)) {
			kyufuritsuMap = this.teiritsuMap.get(unitPrice);
		} else {
			kyufuritsuMap = new HashMap<Integer, List<Map<String, Object>>>();
			this.teiritsuMap.put(unitPrice, kyufuritsuMap);
		}
		// 給付率
		List<Map<String, Object>> details;
		if (kyufuritsuMap.containsKey(kyufuritsu)) {
			details = kyufuritsuMap.get(kyufuritsu);
		} else {
			details = new ArrayList<Map<String, Object>>();
			kyufuritsuMap.put(kyufuritsu, details);
		}
		details.add(detail);
	}

	// 独自定額の明細レコード格納
	private void addTeigakuMap(Double unitPrice, Map<String, Object> detail) {
		// 単価
		List<Map<String, Object>> details;
		if (this.teigakuMap.containsKey(unitPrice)) {
			details = this.teigakuMap.get(unitPrice);
		} else {
			details = new ArrayList<Map<String, Object>>();
			this.teigakuMap.put(unitPrice, details);
		}
		details.add(detail);
	}

	/**
	 * サービス種類ごとの事業費請求額、公費請求額、利用者負担額等を計算します。
	 * @throws Exception
	 */
	public void calculate() throws Exception {
		if (!this.dokujiMap.isEmpty()) {
			calcDokuji();
		} else if (!this.teiritsuMap.isEmpty()) {
			calcTeiritsu();
		} else if (!this.teigakuMap.isEmpty()) {
			calcTeigaku();
		}
	}
	
	/**
	 * 独自を計算します。
	 * 
	 */
	private void calcDokuji() {
		this.dokujiTotalSeikyugaku = 0;
		this.dokujiJigyohiSeikyugaku = 0;

		// 単価ごとに全体の請求額を計算して合算後、保険給付率を掛ける
		for (Double unitPrice : this.dokujiMap.keySet()) {
			List<Map<String, Object>> details = dokujiMap.get(unitPrice);
			int serviceUnit = 0;
			for (Map<String, Object> detail : details) {
				serviceUnit += ACCastUtilities.toInt(
						detail.get(SERVICE_UNIT), 0);
			}
			// 超過分の単位数を引く
			int limitOverUnit = getDokujiLimitOverUnit(unitPrice);
			serviceUnit = serviceUnit - limitOverUnit;

			// 対象単位数×単位数単価(小数点以下切捨て)
			int totalUnit = (int) Math
					.floor((double) (serviceUnit * getUnitPriceMultiplies100(unitPrice)) / 100d);
			this.dokujiTotalSeikyugaku += totalUnit;
		}
		// 保険給付率
		this.dokujiJigyohiSeikyugaku = (int) Math.floor((this.dokujiTotalSeikyugaku * hokenKyufuritsu.intValue()) / 100d);
		// 生保単独の場合
		if (isSeihotandoku) {
			this.dokujiJigyohiSeikyugaku = 0;
		}
	}
	
	/**
	 * 独自の全体の請求額を取得します。 （calculate後に呼ぶ）
	 * 
	 * @return 独自の全体の請求額
	 */
	public int getDokujiTotalSeikyugaku() {
		return dokujiTotalSeikyugaku;
	}

	/**
	 * 独自の事業費請求額を取得します。 （calculate後に呼ぶ）
	 * 
	 * @return 独自の事業費請求額
	 */
	public int getDokujiJigyohiSeikyugaku() {
		return dokujiJigyohiSeikyugaku;
	}
	
	/**
	 * 独自の公費請求額を計算して返します。
	 * 
	 * @param type
	 *            公費優先順タイプ
	 * @param hokenUnit
	 *            保険対象単位数 (701014)
	 * @param kohiUnit
	 *            公費対象単位数
	 * @param ratio
	 *            公費給付率（例：95-100)
	 * @param reduction
	 *            上位優先順の公費請求額として計上済の金額
	 * @param usedRate
	 *            上位優先順の公費給付率
	 * @param tumiageUnit
	 *            上位優先順の公費対象単位数として計上済の単位数
	 * 
	 * @return 独自定率の公費請求額
	 */
	public int calcDokujiKohiSeikyugaku(KohiyusenType type, int hokenUnit,
			int kohiUnit, int ratio, int reduction, int usedRate,
			int tumiageUnit) {
		// 公費給付率が100%で公費対象単位数＝保険単位数の場合
		// または、公費給付率が100%で公費対象単位数を積み上げた結果がサービス単位数と等しい場合
		if (((ratio == 100) && (hokenUnit == kohiUnit))
				|| ((ratio == 100) && (hokenUnit == (kohiUnit + tumiageUnit)))) {
			// 全体の請求額から事業費請求額を引いたもの
			return this.dokujiTotalSeikyugaku
					- this.dokujiJigyohiSeikyugaku - reduction;
		} else {
			return calcDokujiKohiSeikyugaku(type, ratio,
					usedRate);
		}
	}
	
	/**
	 * 独自の公費請求額を計算して返します。 上位優先順の公費給付率を使用
	 * 
	 * @param type
	 *            公費優先順タイプ
	 * @param ratio
	 *            公費給付率（例：95-100)
	 * @param usedRate
	 *            上位優先順の公費給付率
	 * 
	 * @return 独自の公費請求額
	 */
	private int calcDokujiKohiSeikyugaku(KohiyusenType type,
			int ratio, int usedRate) {
		String unitKey = getKohiUnitKeyFromType(type);
		// usedRateを使用する
		// 単価ごとに計算して、合算
		int totalUnit = 0;
		for (Double unitPrice : this.dokujiMap.keySet()) {
			List<Map<String, Object>> details = dokujiMap.get(unitPrice);

			int serviceUnit = 0;
			int kohiUnit = 0;
			for (Map<String, Object> detail : details) {
				serviceUnit += ACCastUtilities.toInt(detail.get(SERVICE_UNIT), 0);
				kohiUnit += ACCastUtilities.toInt(detail.get(unitKey), 0);
			}
			// 超過分の単位数を引く
			int limitOverUnit = getDokujiLimitOverUnit(unitPrice);
			serviceUnit = serviceUnit - limitOverUnit;
			if (serviceUnit < 0) {
				serviceUnit = 0;
			}
			// 公費対象単位数の調整（超過分の単位数のはみ出た分を引く）
			if (kohiUnit > serviceUnit) {
				kohiUnit = serviceUnit;
			}
			
			// 公費対象単位数×単位数単価(小数点以下切捨て)
			totalUnit += (int) Math
					.floor((double) (kohiUnit * getUnitPriceMultiplies100(unitPrice)) / 100d);
		}
		// ×（公費給付率 - 給付率）
		return (int) Math.floor((totalUnit * (ratio - usedRate)) / 100d);
	}
	
	
	/**
	 * 独自定率を計算します。
	 * 
	 */
	private void calcTeiritsu() {
		this.teiritsuTotalSeikyugaku = 0;
		this.teiritsuJigyohiSeikyugaku = 0;

		// 単価、給付率ごとに計算して、合算
		for (Double unitPrice : this.teiritsuMap.keySet()) {
			Map<Integer, List<Map<String, Object>>> kyufuritsuMap = this.teiritsuMap
					.get(unitPrice);
			for (Integer kyufuritsu : kyufuritsuMap.keySet()) {
				List<Map<String, Object>> details = kyufuritsuMap
						.get(kyufuritsu);
				int serviceUnit = 0;
				for (Map<String, Object> detail : details) {
					serviceUnit += ACCastUtilities.toInt(
							detail.get(SERVICE_UNIT), 0);
				}
				// 超過分の単位数を引く
				int limitOverUnit = getTeiritsuLimitOverUnit(unitPrice,
						kyufuritsu);
				serviceUnit = serviceUnit - limitOverUnit;

				// 対象単位数×単位数単価(小数点以下切捨て)
				int totalUnit = (int) Math
						.floor((double) (serviceUnit * getUnitPriceMultiplies100(unitPrice)) / 100d);
				this.teiritsuTotalSeikyugaku += totalUnit;
				// 保険給付率
				totalUnit = (int) Math.floor((totalUnit * kyufuritsu) / 100d);
				this.teiritsuJigyohiSeikyugaku += totalUnit;
			}
		}
		// 生保単独の場合
		if (isSeihotandoku) {
			this.teiritsuJigyohiSeikyugaku = 0;
		}
	}

	/**
	 * 独自定率の全体の請求額を取得します。 （calcTeiritsu後に呼ぶ）
	 * 
	 * @return 独自定率の全体の請求額
	 */
	public int getTeiritsuTotalSeikyugaku() {
		return teiritsuTotalSeikyugaku;
	}

	/**
	 * 独自定率の事業費請求額を取得します。 （calcTeiritsu後に呼ぶ）
	 * 
	 * @return 独自定率の事業費請求額
	 */
	public int getTeiritsuJigyohiSeikyugaku() {
		return teiritsuJigyohiSeikyugaku;
	}

	/**
	 * 独自定率の公費請求額を計算して返します。
	 * 
	 * @param type
	 *            公費優先順タイプ
	 * @param hokenUnit
	 *            保険対象単位数 (701014)
	 * @param kohiUnit
	 *            公費対象単位数
	 * @param ratio
	 *            公費給付率（例：95-100)
	 * @param reduction
	 *            上位優先順の公費請求額として計上済の金額
	 * @param usedRate
	 *            上位優先順の公費給付率
	 * @param tumiageUnit
	 *            上位優先順の公費対象単位数として計上済の単位数
	 * 
	 * @return 独自定率の公費請求額
	 */
	public int calcTeiritsuKohiSeikyugaku(KohiyusenType type, int hokenUnit,
			int kohiUnit, int ratio, int reduction, int usedRate,
			int tumiageUnit) {
		// 公費給付率が100%で公費対象単位数＝保険単位数の場合
		// または、公費給付率が100%で公費対象単位数を積み上げた結果がサービス単位数と等しい場合
		if (((ratio == 100) && (hokenUnit == kohiUnit))
				|| ((ratio == 100) && (hokenUnit == (kohiUnit + tumiageUnit)))) {
			// 全体の請求額から事業費請求額を引いたもの
			return this.teiritsuTotalSeikyugaku
					- this.teiritsuJigyohiSeikyugaku - reduction;
		} else {
			if ((usedRate == -1) || (usedRate == 100)) {
				return calcTeiritsuKohiSeikyugakuByServiceRate(type, ratio);
			} else {
				return calcTeiritsuKohiSeikyugakuByUsedRate(type, ratio,
						usedRate);
			}
		}
	}

	// 公費優先順タイプに対応する公費対象単位数のキーを取得します。
	private String getKohiUnitKeyFromType(KohiyusenType type) {
		String unitKey;
		if (KohiyusenType.KOHI1.equals(type)) {
			unitKey = KOHI1_SERVICE_UNIT;
		} else if (KohiyusenType.KOHI2.equals(type)) {
			unitKey = KOHI2_SERVICE_UNIT;
		} else if (KohiyusenType.KOHI3.equals(type)) {
			unitKey = KOHI3_SERVICE_UNIT;
		} else {
			throw new RuntimeException("KohiyusenTypeの指定が正しくありません。:" + type);
		}
		return unitKey;
	}

	/**
	 * 独自定率の公費請求額を計算して返します。 サービスコードの給付率を使用
	 * 
	 * @param type
	 *            公費優先順タイプ
	 * @param ratio
	 *            公費給付率（例：95-100)
	 * 
	 * @return 独自定率の公費請求額
	 */
	private int calcTeiritsuKohiSeikyugakuByServiceRate(KohiyusenType type,
			int ratio) {
		int result = 0;
		String unitKey = getKohiUnitKeyFromType(type);
		// サービスコードの給付率を使用する
		// 単価、給付率ごとに計算して、合算
		for (Double unitPrice : this.teiritsuMap.keySet()) {
			Map<Integer, List<Map<String, Object>>> kyufuritsuMap = this.teiritsuMap
					.get(unitPrice);
			for (Integer kyufuritsu : kyufuritsuMap.keySet()) {
				List<Map<String, Object>> details = kyufuritsuMap
						.get(kyufuritsu);
				
				int serviceUnit = 0;
				int kohiUnit = 0;
				for (Map<String, Object> detail : details) {
					serviceUnit += ACCastUtilities.toInt(detail.get(SERVICE_UNIT), 0);
					kohiUnit += ACCastUtilities.toInt(detail.get(unitKey), 0);
				}
				// 超過分の単位数を引く
				int limitOverUnit = getTeiritsuLimitOverUnit(unitPrice,
						kyufuritsu);
				serviceUnit = serviceUnit - limitOverUnit;
				if (serviceUnit < 0) {
					serviceUnit = 0;
				}
				// 公費対象単位数の調整（超過分の単位数のはみ出た分を引く）
				if (kohiUnit > serviceUnit) {
					kohiUnit = serviceUnit;
				}
				// 公費対象単位数×単位数単価(小数点以下切捨て)
				int totalUnit = (int) Math
						.floor((double) (kohiUnit * getUnitPriceMultiplies100(unitPrice)) / 100d);
				// ×（公費給付率 - 給付率）
				totalUnit = (int) Math
						.floor((totalUnit * (ratio - kyufuritsu)) / 100d);
				result += totalUnit;
			}
		}
		return result;
	}

	/**
	 * 独自定率の公費請求額を計算して返します。 上位優先順の公費給付率を使用
	 * 
	 * @param type
	 *            公費優先順タイプ
	 * @param ratio
	 *            公費給付率（例：95-100)
	 * @param usedRate
	 *            上位優先順の公費給付率
	 * 
	 * @return 独自定率の公費請求額
	 */
	private int calcTeiritsuKohiSeikyugakuByUsedRate(KohiyusenType type,
			int ratio, int usedRate) {
		int result = 0;
		String unitKey = getKohiUnitKeyFromType(type);
		// usedRateを使用する
		// 単価ごとに計算して、合算
		for (Double unitPrice : this.teiritsuMap.keySet()) {
			Map<Integer, List<Map<String, Object>>> kyufuritsuMap = this.teiritsuMap
					.get(unitPrice);

			int kohiUnitTotal = 0;
			for (Integer kyufuritsu : kyufuritsuMap.keySet()) {
				List<Map<String, Object>> details = kyufuritsuMap
						.get(kyufuritsu);
				
				int serviceUnit = 0;
				int kohiUnit = 0;
				for (Map<String, Object> detail : details) {
					serviceUnit += ACCastUtilities.toInt(detail.get(SERVICE_UNIT), 0);
					kohiUnit += ACCastUtilities.toInt(detail.get(unitKey), 0);
				}
				// 超過分の単位数を引く
				int limitOverUnit = getTeiritsuLimitOverUnit(unitPrice,
						kyufuritsu);
				serviceUnit = serviceUnit - limitOverUnit;
				if (serviceUnit < 0) {
					serviceUnit = 0;
				}
				// 公費対象単位数の調整（超過分の単位数のはみ出た分を引く）
				if (kohiUnit > serviceUnit) {
					kohiUnit = serviceUnit;
				}
				kohiUnitTotal += kohiUnit;
			}
			// 公費対象単位数×単位数単価(小数点以下切捨て)
			int totalUnit = (int) Math
					.floor((double) (kohiUnitTotal * getUnitPriceMultiplies100(unitPrice)) / 100d);
			// ×（公費給付率 - 給付率）
			totalUnit = (int) Math
					.floor((totalUnit * (ratio - usedRate)) / 100d);
			result += totalUnit;
		}
		return result;
	}

	/**
	 * 独自定額を計算します。
	 * 
	 * @throws Exception
	 */
	private void calcTeigaku() throws Exception {
		this.teigakuTotalSeikyugaku = 0;
		this.teigakuRiyoshaFutangaku = 0;
		this.teigakuKohi1Seikyugaku = 0;
		this.teigakuKohi2Seikyugaku = 0;
		this.teigakuKohi3Seikyugaku = 0;

		for (Double unitPrice : this.teigakuMap.keySet()) {
			List<Map<String, Object>> details = teigakuMap.get(unitPrice);
			int totalServiceUnit = 0;
			for (Map<String, Object> detail : details) {
				
				int serviceUnit = ACCastUtilities.toInt(
						detail.get(SERVICE_UNIT), 0);
				

				int futan = ACCastUtilities.toInt(
						detail.get(TEIGAKU_FUTAN_TANKA), 0);
				int kohi1Count = ACCastUtilities.toInt(detail.get(KOHI1_COUNT),
						0);
				int kohi1Unit = ACCastUtilities.toInt(
						detail.get(KOHI1_SERVICE_UNIT), 0);

				int kohi2Count = ACCastUtilities.toInt(detail.get(KOHI2_COUNT),
						0);
				int kohi2Unit = ACCastUtilities.toInt(
						detail.get(KOHI2_SERVICE_UNIT), 0);

				int kohi3Count = ACCastUtilities.toInt(detail.get(KOHI3_COUNT),
						0);
				int kohi3Unit = ACCastUtilities.toInt(
						detail.get(KOHI3_SERVICE_UNIT), 0);

				// 公費請求額を求める
				int tmpKohiSeikyugaku = 0;
				// 給付率の考え方ではないので、併用はしない。
				// 公費回数・・公費１、公費２、公費３と順に見て、最初に設定されている回数の公費を計算対象とする
				KohiyusenType type = KohiyusenType.NONE;
				int useKohiCount = 0;
				int useKohiUnit = 0;
				if (kohi1Count > 0) {
					useKohiCount = kohi1Count;
					useKohiUnit = kohi1Unit;
					type = KohiyusenType.KOHI1;
				} else if (kohi2Count > 0) {
					useKohiCount = kohi2Count;
					useKohiUnit = kohi2Unit;
					type = KohiyusenType.KOHI2;
				} else if (kohi3Count > 0) {
					useKohiCount = kohi3Count;
					useKohiUnit = kohi3Unit;
					type = KohiyusenType.KOHI3;
				}

				String itemCode = ACCastUtilities.toString(detail
						.get(SERVICE_ITEM_CODE));
				int limitOverUnit = getTeigakuLimitOverUnit(unitPrice, itemCode);
				// 超過分の単位数がある場合
				if (limitOverUnit > 0) {
					//サービス単位数から引く
					serviceUnit = serviceUnit - limitOverUnit;
					if (serviceUnit < 0) {
						serviceUnit = 0;
					}
					//公費対象単位数の調整（超過分の単位数のはみ出た分を引く）
					if (useKohiUnit > serviceUnit) {
						useKohiUnit = serviceUnit;
					}
					
					// １単位あたりの利用者負担額を求める
					// １単位あたりの利用者負担額＝利用者負担単価金額／１回あたりの単位数
					int unit = ACCastUtilities.toInt(detail.get(UNIT), 0);
					if (unit == 0) {
						// 月額サービスの時は記載省略のため０になっているので、サービス単位数を見る
						unit = ACCastUtilities.toInt(detail.get(SERVICE_UNIT), 0);
					}
					BigDecimal unitBig = new BigDecimal(unit);
					BigDecimal futanBig = new BigDecimal(futan);
					// 公費請求額＝公費対象単位数×１単位あたりの利用者負担額
					tmpKohiSeikyugaku = new BigDecimal(useKohiUnit).multiply(futanBig)
							.divide(unitBig, 0, BigDecimal.ROUND_DOWN)
							.intValue();
					// 利用者負担額＝(サービス単位数 - 公費対象単位数)×１単位あたりの利用者負担額
					this.teigakuRiyoshaFutangaku += new BigDecimal(
							serviceUnit - useKohiUnit)
							.multiply(futanBig)
							.divide(unitBig, 0, BigDecimal.ROUND_DOWN)
							.intValue();
				} else {
					// 超過分の単位数が無い場合
					// 公費請求額＝利用者負担単価金額×公費分回数
					tmpKohiSeikyugaku = futan * useKohiCount;
					// 利用者負担額＝利用者負担単価金額×（回数 - 公費分回数）
					int serviceCount = ACCastUtilities.toInt(
							detail.get(SERVICE_COUNT), 0);
					this.teigakuRiyoshaFutangaku += futan
							* (serviceCount - useKohiCount);
				}

				if (KohiyusenType.KOHI1.equals(type)) {
					this.teigakuKohi1Seikyugaku += tmpKohiSeikyugaku;
				} else if (KohiyusenType.KOHI2.equals(type)) {
					this.teigakuKohi2Seikyugaku += tmpKohiSeikyugaku;
				} else if (KohiyusenType.KOHI3.equals(type)) {
					this.teigakuKohi3Seikyugaku += tmpKohiSeikyugaku;
				}
				
				// サービス単位数の積み上げ
				totalServiceUnit += serviceUnit;
			}
			// 対象単位数×単位数単価(小数点以下切捨て)
			int totalUnit = (int) Math
					.floor((double) (totalServiceUnit * getUnitPriceMultiplies100(unitPrice)) / 100d);
			this.teigakuTotalSeikyugaku += totalUnit;
		}
		// 生保単独の場合
		if (isSeihotandoku) {
			// 総費用を公費１負担にする
			this.teigakuKohi1Seikyugaku = this.teigakuTotalSeikyugaku;
			this.teigakuKohi2Seikyugaku = 0;
			this.teigakuKohi3Seikyugaku = 0;
			this.teigakuRiyoshaFutangaku = 0;
		}
	}

	/**
	 * 独自定額の公費１請求額を取得します。 （calcTeigaku後に呼ぶ）
	 * 
	 * @return 独自定額の公費１請求額
	 */
	public int getTeigakuKohi1Seikyugaku() {
		return teigakuKohi1Seikyugaku;
	}

	/**
	 * 独自定額の公費２請求額を取得します。 （calcTeigaku後に呼ぶ）
	 * 
	 * @return 独自定額の公費２請求額
	 */
	public int getTeigakuKohi2Seikyugaku() {
		return teigakuKohi2Seikyugaku;
	}

	/**
	 * 独自定額の公費３請求額を取得します。 （calcTeigaku後に呼ぶ）
	 * 
	 * @return 独自定額の公費３請求額
	 */
	public int getTeigakuKohi3Seikyugaku() {
		return teigakuKohi3Seikyugaku;
	}

	/**
	 * 独自定額の事業費請求額を取得します。 （calcTeigaku後に呼ぶ）
	 * 
	 * @param kohiSeikyugaku
	 *            公費請求額（１～３の合算）
	 * @param kohiFutan
	 *            公費自己負担額（１～３の合算）
	 * @return 独自定額の事業費請求額
	 */
	public int getTeigakuJigyohiSeikyugaku(int kohiSeikyugaku, int kohiFutan) {
		return this.teigakuTotalSeikyugaku - this.teigakuRiyoshaFutangaku
				- kohiSeikyugaku - kohiFutan;
	}
	
	/**
	 * 独自定額の利用者負担額を取得します。 （calcTeigaku後に呼ぶ）
	 * 
	 * @return 独自定額の利用者負担額
	 */
	public int getTeigakuRiyoshaFutangaku() {
		return this.teigakuRiyoshaFutangaku;
	}
	
	/**
	 * 総合事業の単位数単価を取得します。
	 * 複数の場合は、最大の単価を返します。
	 * 
	 * @return 総合事業の単位数単価
	 */
	public double getUnitPrice() {
		if (!this.dokujiMap.isEmpty()) {
			return Collections.max(this.dokujiMap.keySet());
		} else if (!this.teiritsuMap.isEmpty()) {
			return Collections.max(this.teiritsuMap.keySet());
		} else if (!this.teigakuMap.isEmpty()) {
			return Collections.max(this.teigakuMap.keySet());
		}
		return 10.0d;
	}
	
	/**
	 * 区分支給限度超単位数のDB格納用の文字情報を取得します。
	 * @return 区分支給限度超単位数のDB格納用の文字情報
	 */
	public String getSogoLimitOverInfo() {
		if (this.sogoLimitOverMap.isEmpty()) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		//マップのキー＝値のカンマ区切りで格納する
		for (String key : this.sogoLimitOverMap.keySet()) {
			// 対象のサービス種類のものだけ格納
			if (key.startsWith(this.skind)) {
				if (!first) {
					sb.append(",");
				}
				sb.append(key);
				sb.append("=");
				sb.append(this.sogoLimitOverMap.get(key));
				first = false;
			}
		}
		return sb.toString();
	}
	
	/**
	 * 区分支給限度超単位数の合計値を取得します。
	 * 
	 * @return 区分支給限度超単位数の合計値
	 */
	public int getTotalLimitOverUnit() {
		int result = 0;
		if (this.sogoLimitOverMap.isEmpty()) {
			return result;
		}
		for (String key : this.sogoLimitOverMap.keySet()) {
			// 対象のサービス種類のものだけ合計
			if (key.startsWith(this.skind)) {
				result += ACCastUtilities.toInt(this.sogoLimitOverMap.get(key), 0);
			}
		}
		return result;
	}
	
	// 独自の区分支給超単位数を取得します
	private int getDokujiLimitOverUnit(Double unitPrice) {
		String key = QP001Manager.getDokujiLimitOverUnitKey(skind, unitPrice);
		return ACCastUtilities.toInt(this.sogoLimitOverMap.get(key),
				0);
	}
	
	// 独自定率の区分支給超単位数を取得します
	private int getTeiritsuLimitOverUnit(Double unitPrice, int kyufuritsu) {
		String key = QP001Manager.getTeiritsuLimitOverUnitKey(skind, unitPrice, kyufuritsu);
		return ACCastUtilities.toInt(this.sogoLimitOverMap.get(key),
				0);
	}

	// 独自定額の区分支給超単位数を取得します
	private int getTeigakuLimitOverUnit(Double unitPrice, String itemCode) {
		String key = QP001Manager.getTeigakuLimitOverUnitKey(skind, unitPrice, itemCode);
		return ACCastUtilities.toInt(this.sogoLimitOverMap.get(key),
				0);
	}

	// 単位数単価×100を取得します。
	private int getUnitPriceMultiplies100(Double unitPrice) {
		BigDecimal temp = new BigDecimal(String.valueOf(unitPrice));
		temp = temp.multiply(new BigDecimal("100"));
		return temp.intValue();
	}

}
