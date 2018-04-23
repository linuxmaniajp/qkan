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
package jp.nichicom.ac.lib.care.claim.print.schedule;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanSjServiceCodeManager;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanValidServiceCommon;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRLinkedHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.qs.qs001.QS001009Event;

/**
 * 集計明細表示データ管理クラス
 * 
 * @author Yoichiro Kamei
 * 
 */
public class CareServiceSummaryManager {

	private CareServiceCodeCalcurater calcurater;
	private VRMap patientInsureInfoHeaviest;
	private VRMap masterService;

	// このクラスで追加した単位数を格納するKEY文字列
	// （既に設定済みのキーと重複しないようにクラス名を付けています）
	private static String ADD_UNIT_NAME = CareServiceSummaryManager.class
			.getSimpleName() + "_SERVICE_UNIT";

	// このクラスでサービスの調整額を設定した際に、trueを格納するKEY文字列
	private static String REGULATION_RATE_MODIFIED = CareServiceSummaryManager.class
			.getSimpleName() + "_REGULATION_RATE_MODIFIED";
	
	// このクラスで計画単位数を設定した際に、trueを格納するKEY文字列
	private static String PLAN_UNIT_SETUPED = CareServiceSummaryManager.class
			.getSimpleName() + "_PLAN_UNIT_SETUPED";
	

	// 限度額管理対象外の別表データ
	private List<Map<String, Object>> gendogaiBeppyoList = new VRArrayList();
	// 限度額管理対象の別表データ
	private Map<String, Map<String, Object>> parsedData = new VRLinkedHashMap();

	// 総合事業 限度額超単位設定用のマップ
	private Map<String, VRList> sogoOverAdjustMap = new HashMap<String, VRList>();

	private VRList beppyoList = new VRArrayList(); // 別表データのリスト
	private VRList limitList = new VRArrayList(); // 限度額管理対象のリスト
	private VRList gaibuList = new VRArrayList(); // 外部利用型のリスト

	private int limitUnit = 0; // 限度額管理対象の単位数
	private int adjustUnit = 0; // 調整単位数
	private int afterAdjustUnit = 0; // 調整後単位数

	private int gaibuUnit = 0; // 外部利用型の単位数
	private int gaibuAdjustUnit = 0; // 外部利用型の調整単位数
	private int gaibuAfterAdjustUnit = 0; // 外部利用型の調整後単位数
	
	private int outLimitUnit = 0; // 給付管理対象外の単位数
	private int patientCost = 0; // 利用者負担額概算

	/**
	 * コンストラクタ。
	 * 
	 * @param calcurater
	 *            生成、初期化済みのCareServiceCodeCalcurater
	 * @param patientInsureInfoHeaviest
	 *            最も重い要介護度履歴情報格納用レコード
	 * @param masterService
	 *            サービスマスタ
	 */
	public CareServiceSummaryManager(CareServiceCodeCalcurater calcurater,
			VRMap patientInsureInfoHeaviest, VRMap masterService)
			throws Exception {
		this.calcurater = calcurater;
		this.patientInsureInfoHeaviest = patientInsureInfoHeaviest;
		this.masterService = masterService;
	}

	
	/**
	 * このクラスの初期化処理を行います。
	 * 集計明細の行データを作成します。
	 * 
	 * @param calcurater
	 * @param services
	 * @throws Exception
	 */
	public void initialize(CareServiceCodeCalcurater calcurater,
			VRList services) throws Exception {

		this.outLimitUnit = 0;
		this.patientCost = 0;
		this.beppyoList.clear();
		
		// 別表の集計ロジックを通して、別表に記載される給付管理対象外単位数と利用者負担額を取得する。
		CareServiceSchedulePrintManager mng = new CareServiceSchedulePrintManager();
		mng.setUltimateDebugFlag(true);
		mng.initialize(calcurater);
		mng.parse(services);
		mng.setBuildDivedProvider(false);

		int lastRow = mng.getUserSubTableRowCount();
		CareServicePrintParameter buildParam = new CareServicePrintParameter();
		buildParam.setPrintParameter(new VRHashMap());
		List list = new ArrayList();
		mng.buildUserSubTable(buildParam, list);
		mng.setUltimateDebugFlag(false);

		Iterator it = list.iterator();
		while (it.hasNext()) {
			Iterator provIt = ((List) it.next()).iterator();
			while (provIt.hasNext()) {
				List ins = (List) provIt.next();
				if (!ins.isEmpty()) {
					Map page = (Map) ins.get(0);
					patientCost += ACCastUtilities.toInt(
							page.get("main.total.x18"), 0)
							+ ACCastUtilities.toInt(page.get("main.total.x19"),
									0);
					Iterator insIt = ins.iterator();
					while (insIt.hasNext()) {
						page = (Map) insIt.next();
						for (int i = 1; i < lastRow; i++) {
							VRMap row = new VRHashMap();

							row.put("PROVIDER_NAME",
									ACCastUtilities.toString(
											page.get("main.y" + i + ".x1"), ""));
							row.put("PROVIDER_ID",
									ACCastUtilities.toString(
											page.get("main.y" + i + ".x2"), ""));

							String serviceName = ACCastUtilities.toString(
									page.get("main.y" + i + ".x3"), "");
							row.put("SERVICE_NAME", serviceName);

							String serviceCode = ACCastUtilities.toString(
									page.get("main.y" + i + ".x4"), "");

							row.put("SERVICE_CODE", serviceCode);

							row.put("UNIT",
									ACCastUtilities.toString(
											page.get("main.y" + i + ".x5"), ""));
							row.put("REDUCE_RATE",
									ACCastUtilities.toString(
											page.get("main.y" + i + ".x6"), ""));
							row.put("REDUCED_UNIT",
									ACCastUtilities.toString(
											page.get("main.y" + i + ".x7"), ""));
							row.put("SERVICE_COUNT",
									ACCastUtilities.toString(
											page.get("main.y" + i + ".x8"), ""));
							String serviceUnit = ACCastUtilities.toString(
									page.get("main.y" + i + ".x9"), "");
							row.put("SERVICE_UNIT", serviceUnit);

							String unit = ACCastUtilities.toString(page
									.get("main.y" + i + ".x12"));
							row.put("OVER_UNIT", unit);

							row.put("IN_UNIT", ACCastUtilities.toString(
									page.get("main.y" + i + ".x13"), ""));

							row.put("UNIT_PRICE", ACCastUtilities.toString(
									page.get("main.y" + i + ".x14"), ""));
							row.put("TOTAL_COST", ACCastUtilities.toString(
									page.get("main.y" + i + ".x15"), ""));
							row.put("PAYMENT_RATE", ACCastUtilities.toString(
									page.get("main.y" + i + ".x16"), ""));
							row.put("HOKEN_COST", ACCastUtilities.toString(
									page.get("main.y" + i + ".x17"), ""));
							row.put("TEIGAKU_FUTAN_TANKA", ACCastUtilities.toString(
									page.get("main.y" + i + ".x20"), ""));
							row.put("FUTAN_HOKEN", ACCastUtilities.toString(
									page.get("main.y" + i + ".x18"), ""));
							row.put("FUTAN_ZENGAKU", ACCastUtilities.toString(
									page.get("main.y" + i + ".x19"), ""));

							row.put("SERVICE_KIND", ACCastUtilities.toString(
									page.get("main.y" + i + ".skind"), ""));
							
							row.put("SOGO_KYUFURITSU", ACCastUtilities.toString(
									page.get("main.y" + i + ".sogokyufuritsu"), ""));

							row.put("LIMIT_AMOUNT_OBJECT", ACCastUtilities.toString(
									page.get("main.y" + i + ".limitAmountObject"), ""));
							
							if (!"".equals(serviceName)) {
								this.beppyoList.add(row);
							}
							
							if (isGendogaiBeppyoRow(row)) {
								if (!"".equals(serviceUnit) 
										&& serviceUnit.charAt(0) == '(') {
									outLimitUnit += ACCastUtilities.toInt(
											serviceUnit.substring(1,
													serviceUnit.length() - 1),
											0);
								}
							}

						}
					}
				}
			}
		}

		//取得した別表データの解析
		parseBeppyoData(this.beppyoList);
		//サービスの解析
		parseServices(services);
	}
	
	/**
	 * 別表データを解析して、Mapに格納する。
	 * 
	 * @param beppyoData
	 *            別表データが格納されたリスト
	 */
	private void parseBeppyoData(List<Map<String, Object>> beppyoData)
			throws Exception {
		for (Map<String, Object> row : beppyoData) {
			if (isGendogaiBeppyoRow(row)) {
				gendogaiBeppyoList.add(row);
				continue;
			}
			if (isOver30DaysBeppyoRow(row)) {
				continue;
			}
			if (isTaishoRow(row)) {
				// 限度額管理対象の場合
				// 集計キーを作成する
				String key = createSummaryKeyFromBeppyoData(row);
				Map<String, Object> parsedRow;
				if (parsedData.containsKey(key)) {
					parsedRow = parsedData.get(key);
				} else {
					parsedRow = new VRHashMap();
					parsedRow.put("KEY", key);
					String providerId = ACCastUtilities.toString(
							row.get("PROVIDER_ID"), "");
					String providerName = ACCastUtilities.toString(
							row.get("PROVIDER_NAME"), "");
					parsedRow.put("PROVIDER_ID", providerId);
					parsedRow.put("PROVIDER_NAME", providerId + " " + providerName);

					String sysKind = ACCastUtilities.toString(
							row.get("SERVICE_KIND"), "");
					parsedRow.put("SERVICE_CODE_KIND",
							getServiceCodeKindFromSystemCode(sysKind));
					parsedRow.put("SERVICE_KIND_NAME",
							createServiceKindNameFromBeppyoData(row));
					parsedRow.put("SOGO_KYUFURITSU", ACCastUtilities.toString(
							row.get("SOGO_KYUFURITSU"), "xxx"));
					parsedRow.put("TEIGAKU_UNIT", ACCastUtilities.toString(
							row.get("UNIT"), "xxx"));
					parsedRow.put("TEIGAKU_FUTAN_TANKA", ACCastUtilities.toString(
							row.get("TEIGAKU_FUTAN_TANKA"), "xxx"));
					parsedRow.put("GAIBU_UNIT", new Integer(0)); // 外部利用型の単位数
					parsedRow.put("BEPPYO_ROWS", new VRArrayList()); // 解析した別表を格納するリスト
					parsedRow.put("WARIFURI_SERVICES", new VRArrayList()); // 割振り対象のサービスを格納するリスト
					parsedData.put(key, parsedRow);
				}
				// 限度額管理対象の単位数を積み上げ
				int addUnit = ACCastUtilities.toInt(row.get("SERVICE_UNIT"), 0);
				int unit = ACCastUtilities.toInt(parsedRow.get("UNIT"), 0);
				parsedRow.put("UNIT", unit + addUnit);

				// 対象の別表データを格納しておく
				((List) parsedRow.get("BEPPYO_ROWS")).add(row);
			}
		}
	}

	// システムサービス種類コード(5桁)からサービス種類コードを取得する
	private String getServiceCodeKindFromSystemCode(
			String systemServiceKindDetail) throws Exception {
		String kind = "";
		int sysCode = ACCastUtilities.toInt(systemServiceKindDetail, 0);
		VRMap row = (VRMap) masterService.get(sysCode);
		if (row != null) {
			kind = ACCastUtilities.toString(row.get("SERVICE_CODE_KIND"));
		}
		return kind;
	}

	// システムサービス種類コード(5桁)からサービス種類名称を取得する
	private String getServiceKindNameFromSystemCode(
			String systemServiceKindDetail) throws Exception {
		String kind = "";
		int sysCode = ACCastUtilities.toInt(systemServiceKindDetail, 0);
		VRMap row = (VRMap) masterService.get(sysCode);
		if (row != null) {
			kind = ACCastUtilities.toString(row.get("SERVICE_KIND_NAME"));
		}
		return kind;
	}

	// 別表データから集計するためのキーを作成する
	private String createSummaryKeyFromBeppyoData(Map<String, Object> row)
			throws Exception {
		StringBuilder sb = new StringBuilder();
		// 事業所
		sb.append(ACCastUtilities.toString(row.get("PROVIDER_ID"), ""));
		sb.append("-");

		// サービス種類
		String sysKind = ACCastUtilities.toString(row.get("SERVICE_KIND"), "");
		String kind = getServiceCodeKindFromSystemCode(sysKind);
		sb.append(kind);
		sb.append("-");

		// 総合事業の独自定率の場合
		if (QkanSjServiceCodeManager.teiritsuCodes.contains(sysKind)) {
			// 給付率
			sb.append(ACCastUtilities.toString(row.get("SOGO_KYUFURITSU"),
					"xxx"));
			sb.append("-");
		}

		// 総合事業の独自定額の場合
		if (QkanSjServiceCodeManager.teigakuCodes.contains(sysKind)) {
			// サービスコード
			sb.append(ACCastUtilities.toString(row.get("SERVICE_CODE"),
					"xxxxxx"));
			sb.append("-");
		}

		return sb.toString();
	}

	// 別表データからサービス列の表示内容を作成する
	private String createServiceKindNameFromBeppyoData(Map<String, Object> row)
			throws Exception {
		StringBuilder sb = new StringBuilder();
		// サービス種類名称
		String sysKind = ACCastUtilities.toString(row.get("SERVICE_KIND"), "");
		String kind = getServiceCodeKindFromSystemCode(sysKind);
		sb.append(kind);
		sb.append(":");
		sb.append(getServiceKindNameFromSystemCode(sysKind));

		// 総合事業の独自定率の場合
		if (QkanSjServiceCodeManager.teiritsuCodes.contains(sysKind)) {
			sb.append(" ");
			// 給付率
			sb.append(ACCastUtilities.toString(row.get("SOGO_KYUFURITSU"),
					"xxx"));
			sb.append("%");
		}

		// 総合事業の独自定額の場合
		if (QkanSjServiceCodeManager.teigakuCodes.contains(sysKind)) {
			sb.append(" ");
			// サービスコード
			sb.append(ACCastUtilities.toString(row.get("SERVICE_CODE"), ""));
			sb.append(" ");
			sb.append(ACCastUtilities.toString(row.get("SERVICE_NAME"), ""));
		}

		return sb.toString();
	}

	// 別表データが限度額管理対象外かどうかを返す
	private boolean isGendogaiBeppyoRow(Map<String, Object> row) {
		int limitAmountObject = ACCastUtilities.toInt(row.get("LIMIT_AMOUNT_OBJECT"), 0);
		if (CareServiceCommon.OUT_LIMIT_AMOUNT_SERVICE.equals(limitAmountObject)) {
			return true;
		}
		return false;
	}
	
	// 別表データが解析対象かどうかを返す
	private boolean isTaishoRow(Map<String, Object> row) {
		// コードが無い場合は、集計行なので対象外
		String code = ACCastUtilities.toString(row.get("SERVICE_CODE"), "");
		if ("".equals(code)) {
			return false;
		}
		// 給付管理限度額対象か外部利用型の給付管理限度額対象
		int limitAmountObject = ACCastUtilities.toInt(row.get("LIMIT_AMOUNT_OBJECT"), 0);
		if (CareServiceCommon.IN_LIMIT_AMOUNT_SERVICE.equals(limitAmountObject)
				|| CareServiceCommon.OUTER_SERVICE_LIMIT_AMOUNT.equals(limitAmountObject)) {
			return true;
		}
		return false;
	}
	
	
	// 別表データが30日超の行かどうかを返す
	private boolean isOver30DaysBeppyoRow(Map<String, Object> row) {
		boolean isOver30Days = ACCastUtilities.toBoolean(row.get("isOver30Days"), false);
		if (isOver30Days) {
			return true;
		}
		return false;
	}

	/**
	 * サービスを解析して、Mapに格納する。
	 * 
	 * @param services
	 *            サービスが格納されたリスト
	 * @throws Exception
	 */
	private void parseServices(List<Map<String, Object>> services)
			throws Exception {
		Map[] totalGroupingCache = new Map[] { new HashMap(), new HashMap() };
		Map[] totalGroupingCacheGaibu = new Map[] { new HashMap(),
				new HashMap() };
		// [H30.4改正対応][Yoichiro Kamei] 2018/3/14 add - begin 共生型減算対応
		KyouseiUnitCalcurater kyouseiCalc = new KyouseiUnitCalcurater();
		// 時系列でソートする
		Collections.sort(services, new ServiceDateTimeLineComparator(ADD_UNIT_NAME));
		// [H30.4改正対応][Yoichiro Kamei] 2018/3/14 add - end
		
		for (Map<String, Object> service : services) {
			// このサービスの単位数を求める
			// [H30.4改正対応][Yoichiro Kamei] 2018/3/14 mod - begin 共生型減算対応
//			int unit = calcurater
//					.getReductedUnit(
//							(VRMap) service,
//							false,
//							CareServiceCodeCalcurater.CALC_MODE_IN_LIMIT_AMOUNT_OR_OUTER_SERVICE,
//							totalGroupingCache);
			int unit = calcurater
					.getReductedUnit(
							(VRMap) service,
							false,
							CareServiceCodeCalcurater.CALC_MODE_IN_LIMIT_AMOUNT_OR_OUTER_SERVICE,
							totalGroupingCache,
							kyouseiCalc);
			// [H30.4改正対応][Yoichiro Kamei] 2018/3/14 mod - end
			// サービスに追加する
			service.put(ADD_UNIT_NAME, unit);
			if (unit == 0) {
				// 限度額管理対象の単位数がなければ、スキップ
				continue;
			}
			// 限度額管理対象の場合
			// 集計キーを作成する
			String key = createSummaryKeyFromServiceData(service);
			Map<String, Object> parsedRow;
			if (parsedData.containsKey(key)) {
				parsedRow = parsedData.get(key);
			} else {
				System.out.println("割り当て先の別表データがありません: " + key);
				continue;
			}
			// 調整額を積み上げ
			int regRate = ACCastUtilities.toInt(service.get("REGULATION_RATE"),
					0);
			int adjust = ACCastUtilities.toInt(parsedRow.get("ADJUST"), 0);
			parsedRow.put("ADJUST", regRate + adjust);

			// 外部利用型の単位数があるか確認
			// [H30.4改正対応][Yoichiro Kamei] 2018/3/14 mod - begin 共生型減算対応
//			int gaibuUnit = calcurater
//					.getReductedUnit(
//							(VRMap) service,
//							false,
//							CareServiceCodeCalcurater.CALC_MODE_OUTER_SERVICE_LIMIT_AMOUNT,
//							totalGroupingCacheGaibu);
			int gaibuUnit = calcurater
					.getReductedUnit(
							(VRMap) service,
							false,
							CareServiceCodeCalcurater.CALC_MODE_OUTER_SERVICE_LIMIT_AMOUNT,
							totalGroupingCacheGaibu, null);
			// [H30.4改正対応][Yoichiro Kamei] 2018/3/14 mod - end
			if (gaibuUnit != 0) {
				int nowGaibuUnit = ACCastUtilities.toInt(
						parsedRow.get("GAIBU_UNIT"), 0);
				parsedRow.put("GAIBU_UNIT", nowGaibuUnit + gaibuUnit);
			}

			// 対象のサービスを格納しておく
			((List) parsedRow.get("WARIFURI_SERVICES")).add(service);
		}
		// [H30.4改正対応][Yoichiro Kamei] 2018/3/14 mod - begin 共生型減算対応
		// 共生型減算の減算単位数をADD_UNIT_NAMEに保持している単位数へ反映する
		if (kyouseiCalc.hasService()) {
			kyouseiCalc.calcKyouseiUnit(ADD_UNIT_NAME);
			kyouseiCalc.removeServiceKey();
		}
		// [H30.4改正対応][Yoichiro Kamei] 2018/3/14 mod - end
		
		// 単位数の計算
		calcTotalUnit();
	}

	/**
	 * 単位数の計算を行います。 （parseBeppyoData、parseServicesの実行後に呼ぶ）
	 */
	private void calcTotalUnit() {
		// 現在値をクリア
		this.limitList.clear();
		this.gaibuList.clear();
		this.limitUnit = 0;
		this.adjustUnit = 0;
		this.afterAdjustUnit = 0;
		this.gaibuUnit = 0;
		this.gaibuAdjustUnit = 0;
		this.gaibuAfterAdjustUnit = 0;

		// 調整後単位数を算出して、給付管理対象、外部利用型のリストに分ける
		for (Map<String, Object> parsedRow : parsedData.values()) {
			int unit = ACCastUtilities.toInt(parsedRow.get("UNIT"), 0);
			int adjust = ACCastUtilities.toInt(parsedRow.get("ADJUST"), 0);
			int result = unit - adjust;
			parsedRow.put("UNIT", unit);
			parsedRow.put("ADJUST", adjust);
			parsedRow.put("RESULT", result);
			int gaibuUnit = ACCastUtilities.toInt(parsedRow.get("GAIBU_UNIT"),
					0);
			if (gaibuUnit != 0) {
				this.gaibuUnit += gaibuUnit;
				this.gaibuAdjustUnit += adjust;
				this.gaibuAfterAdjustUnit += result;
				this.gaibuList.add(parsedRow);
			} else {
				this.limitUnit += unit;
				this.adjustUnit += adjust;
				this.afterAdjustUnit += result;
				this.limitList.add(parsedRow);
			}
		}
	}

	// サービスデータから集計するためのキーを作成する
	private String createSummaryKeyFromServiceData(Map<String, Object> service)
			throws Exception {
		StringBuilder sb = new StringBuilder();
		// 事業所
		sb.append(ACCastUtilities.toString(service.get("PROVIDER_ID"), ""));
		sb.append("-");

		// サービス種類
		String sysKind = ACCastUtilities.toString(
				service.get("SYSTEM_SERVICE_KIND_DETAIL"), "");
		String sKind = getServiceCodeKindFromSystemCode(sysKind);
		sb.append(sKind);
		sb.append("-");

		// 総合事業の独自定率の場合
		if (QkanSjServiceCodeManager.teiritsuCodes.contains(sysKind)) {
			String codeKey = ACCastUtilities.toString(service.get("501"), "");
			VRMap ret = QkanSjServiceCodeManager.getSjServiceCodeByKey(
					calcurater.getDBManager(), codeKey,
					calcurater.getTargetDate());
			// 給付率
			sb.append(ACCastUtilities.toString(ret.get("KYUFURITSU"), "xxx"));
			sb.append("-");
		}

		// 総合事業の独自定額の場合
		if (QkanSjServiceCodeManager.teigakuCodes.contains(sysKind)) {
			String codeKey = ACCastUtilities.toString(service.get("501"), "");
			VRMap ret = QkanSjServiceCodeManager.getSjServiceCodeByKey(
					calcurater.getDBManager(), codeKey,
					calcurater.getTargetDate());

			// サービスコード
			sb.append(ACCastUtilities.toString(ret.get("SERVICE_CODE_KIND"),
					"xx"));
			sb.append(ACCastUtilities.toString(ret.get("SERVICE_CODE_ITEM"),
					"xxxx"));
			sb.append("-");
		}

		return sb.toString();
	}

	/**
	 * 計画単位数を解析して、明細行に設定する。
	 * 
	 * @param planUnits
	 *            計画単位数が格納されたマップ
	 * @throws Exception
	 */
	public void parsePlanUnits(VRMap planUnits) throws Exception {
		if (planUnits.isEmpty()) {
			// 計画単位数が設定されていなければ、何もしない
			return;
		}
		for (Map<String, Object> parsedRow : parsedData.values()) {
			String providerId = ACCastUtilities.toString(
					parsedRow.get("PROVIDER_ID"), "");
			String kind = ACCastUtilities.toString(
					parsedRow.get("SERVICE_CODE_KIND"), "");
			String path = CareServiceCommon.getPlanUnitBindPath(kind);

			if (planUnits.containsKey(providerId)) {
				VRMap unitMap = (VRMap) planUnits.get(providerId);
				if (unitMap.containsKey(path)) {
					String planUnit = ACCastUtilities.toString(
							unitMap.get(path), "");

					// 計画単位数の設定がある場合
					if (!ACTextUtilities.isNullText(planUnit)) {
						parsedRow.put("PLAN_UNIT", planUnit);
						parsedRow.put("PLAN_UNIT_BIND_PATH", path);
					}

				}
			}
		}
	}
	
	
	/**
	 * 調整額をもとに計画単位数を設定します。
	 * （予定読込時に呼ばれます。）
	 * 
	 * @param planUnits 設定対象の計画単位数
	 * @throws Exception
	 */
	public void setupPlanUnitsFromAdjusts(VRMap planUnits)  throws Exception {
		// 総合事業の独自定率・独自定額のサービス種類ごとのリストを作成
		createSogoOverAdjustMap();
		
		for (Map<String, Object> parsedRow : parsedData.values()) {
			if (Boolean.TRUE.equals(parsedRow.get(PLAN_UNIT_SETUPED))) {
				continue; //設定済みの行はスキップ
			}
			String providerId = ACCastUtilities.toString(
					parsedRow.get("PROVIDER_ID"), "");
			String kind = ACCastUtilities.toString(
					parsedRow.get("SERVICE_CODE_KIND"), "");
			String path = CareServiceCommon.getPlanUnitBindPath(kind);
			
			// 総合事業の独自定率・独自定額の場合
			// 対象となるサービスに調整額を割り振る
			if (parsedRow.containsKey("SOGO_OVER_ADJUST_KEY")) {

				// キーを取得
				String adjustKey = ACCastUtilities.toString(
						parsedRow.get("SOGO_OVER_ADJUST_KEY"), "");

				// 単位数、調整額の合計を求める
				int totalUnit = 0;
				int totalAdjust = 0;
				VRList list = sogoOverAdjustMap.get(adjustKey);
				for (int index = 0; index < list.size(); index++) {
					Map row = (Map) list.get(index);
					int unit = ACCastUtilities.toInt(row.get("UNIT"), 0);
					int adjust = ACCastUtilities.toInt(row.get("ADJUST"), 0);
					totalUnit += unit;
					totalAdjust += adjust;
					// この行は設定済とする
					row.put(PLAN_UNIT_SETUPED, true);
				}
				// 調整額が設定されていれば
				if (totalAdjust > 0) {
					// 計画単位数を登録
					int planUnit = totalUnit - totalAdjust;
					setPlanUnit(planUnits, providerId, path, planUnit);
				}
				
			} else {
				// 総合事業の独自定率・独自定額でなければ
				int unit = ACCastUtilities.toInt(
						parsedRow.get("UNIT"), 0);
				int adjust = ACCastUtilities.toInt(
						parsedRow.get("ADJUST"), 0);
				// 調整額が設定されていれば
				if (adjust > 0) {
					int planUnit = unit - adjust;
					// 計画単位数を登録
					setPlanUnit(planUnits, providerId, path, planUnit);
				}
				// この行は設定済とする
				parsedRow.put(PLAN_UNIT_SETUPED, true);
			}
		}
	}
	
	//パラメータで指定した事業所、サービス種類に計画単位数を設定
	private void setPlanUnit(VRMap planUnits, String providerId, String path, int planUnit) {
		if (planUnit > 0) {
			if (planUnits.containsKey(providerId)) {
				// 事業所のデータがあれば、その中に追加
				VRMap providerPlanUnits = (VRMap) planUnits.get(providerId);
				providerPlanUnits.put(path, planUnit);
			} else {
				// 事業所のデータが無かったら作成
				VRMap units = new VRHashMap();
				units.put(path, planUnit);
				units.put("PROVIDER_ID", providerId);
				planUnits.put(providerId, units);
			}
		}
	}

	/**
	 * 給付管理対象のリストを返します。
	 * 
	 * @return 給付管理対象のリスト
	 */
	public VRList getLimitList() {
		return this.limitList;
	}

	/**
	 * 外部利用型のリストを返します。
	 * 
	 * @return 外部利用型のリスト
	 */
	public VRList getGaibuList() {
		return this.gaibuList;
	}
	
	/**
	 * 別表データのリストを返します。
	 * 
	 * @return 別表データのリスト
	 */
	public VRList getBeppyoList() {
		return this.beppyoList;
	}

	/**
	 * 入力された調整額をサービスに割り振ります。
	 * 
	 * @param row
	 *            調整額の変更対象行データ
	 */
	public void applyAdjustUnit(Map row) {

		String key = ACCastUtilities.toString(row.get("KEY"), "");
		Map<String, Object> parsedRow = parsedData.get(key);
		// 割振り対象の調整額
		int zan = ACCastUtilities.toInt(row.get("ADJUST"), 0);
		// 割振り対象のサービス
		List<Map<String, Object>> services = (List<Map<String, Object>>) parsedRow
				.get("WARIFURI_SERVICES");

		// 日付の最後のものから割り当てるために逆順にする
		List<Map<String, Object>> list = new ArrayList(services);
		Collections.reverse(list);
		for (Map<String, Object> service : list) {
			if (CareServiceCommon.is30DayOver((VRMap) service)) {
				// 30日超のサービスは全額自己負担なので、スキップ
				continue;
			}
			// サービスに割振り可能な単位数
			int kano = ACCastUtilities.toInt(service.get(ADD_UNIT_NAME), 0);
			int wariate = 0;
			if (zan <= kano) {
				// 割り当て残がサービスに割振り可能な単位数よりも小さいか、等しい場合、残りを全部割り当て
				wariate = zan;
			} else {
				// 割り当て残がサービスに割振り可能な単位数よりも大きい場合、割り当て可能な分を割り当て
				wariate = kano;
			}
			service.put("REGULATION_RATE", wariate);
			service.put(REGULATION_RATE_MODIFIED, true); // 修正したことを設定

			// 割り当てた分を残から引く
			zan = zan - wariate;
		}
	}

	/**
	 * 調整額の設定値を取得します。
	 * 
	 * @return 更新対象のIDと調整額が格納されたマップ
	 */
	public VRMap getAdjustResults() {
		VRMap results = new VRHashMap();
		for (Map<String, Object> parsedRow : parsedData.values()) {
			List<Map<String, Object>> services = (List<Map<String, Object>>) parsedRow
					.get("WARIFURI_SERVICES");
			for (Map<String, Object> service : services) {
				if (Boolean.TRUE.equals(service.get(REGULATION_RATE_MODIFIED))) {
					String id = ACCastUtilities.toString(
							service.get(QS001009Event.QS001009_UPDATE_KEY), "");
					int adjust = ACCastUtilities.toInt(
							service.get("REGULATION_RATE"), 0);
					results.put(id, adjust);
				}
			}
		}
		return results;
	}

	/**
	 * 単位数の結果情報を返します。
	 * 
	 * @return 単位数の結果情報
	 */
	public VRMap getUnitInfoResults() {
		VRMap results = new VRHashMap();
		// 限度額管理対象
		int kubunLimit = ACCastUtilities.toInt(
				this.patientInsureInfoHeaviest.get("LIMIT_RATE"), 0);
		results.put("LIMIT_RATE", kubunLimit); // 限度額
		results.put("LIMIT_AMOUNT", this.limitUnit); // 給付管理対象の単位数
		results.put("AFTER_ADJUSTMENT", this.afterAdjustUnit); // 調整後単位数
		results.put("ADJUSTMENT", this.adjustUnit); // 調整単位数
		int limitOver = this.afterAdjustUnit - kubunLimit;
		if (limitOver < 0) {
			limitOver = 0;
		}
		results.put("LIMIT_OVER", limitOver); // 超過単位数

		// 外部利用型
		int gaibuLimit = ACCastUtilities.toInt(
				this.patientInsureInfoHeaviest.get("EXTERNAL_USE_LIMIT"), 0);
		results.put("EXTERNAL_USE_LIMIT", gaibuLimit); // 限度額
		results.put("OUTER_LIMIT_AMOUNT", this.gaibuUnit); // 給付管理対象の単位数
		results.put("OUTER_AFTER_ADJUSTMENT", this.gaibuAfterAdjustUnit); // 調整後単位数
		results.put("OUTER_ADJUSTMENT", this.gaibuAdjustUnit); // 調整単位数
		int outerLimitOver = this.gaibuAfterAdjustUnit - gaibuLimit;
		if (outerLimitOver < 0) {
			outerLimitOver = 0;
		}
		results.put("OUTER_LIMIT_OVER", outerLimitOver); // 超過単位数
		
		
		// 給付管理対象外
		results.put("OUT_LIMIT_AMOUNT", this.outLimitUnit);
		// 負担額概算
		results.put("FUTAN_GAKU", this.patientCost);

		return results;
	}

	/**
	 * 指定したキーの解析済みの行データを返します。
	 * 
	 * @return 指定したキーの解析済みの行データ
	 */
	public VRMap getParsedRowByKey(String key) {
		return (VRMap) this.parsedData.get(key);
	}

	/**
	 * 総合事業 限度額超単位設定用のマップを作成します。
	 * 
	 */
	public void createSogoOverAdjustMap() {
		sogoOverAdjustMap.clear();
		for (Map<String, Object> parsedRow : parsedData.values()) {
			String providerId = ACCastUtilities.toString(
					parsedRow.get("PROVIDER_ID"), "");
			String kind = ACCastUtilities.toString(
					parsedRow.get("SERVICE_CODE_KIND"), "");
			// 総合事業の独自定額・独自定率のサービス種類でなければスキップ
			if (!QkanSjServiceCodeManager.teiritsuTeigakuKinds.contains(kind)) {
				continue;
			}
			// 事業所、サービス種類毎にリストとして保持する
			String key = providerId + "-" + kind;
			parsedRow.put("SOGO_OVER_ADJUST_KEY", key);
			VRList list;
			if (!sogoOverAdjustMap.containsKey(key)) {
				list = new VRArrayList();
				sogoOverAdjustMap.put(key, list);
			} else {
				list = sogoOverAdjustMap.get(key);
			}
			list.add(parsedRow);
		}
	}

	/**
	 * 総合事業 限度額超単位設定編集用のリストを取得します。
	 * 
	 * @return 総合事業 限度額超単位設定編集用のリスト
	 * @throws Exception
	 */
	public VRList getSogoOverAdjustList(VRMap source) throws Exception {
		// キーを取得
		String key = ACCastUtilities.toString(
				source.get("SOGO_OVER_ADJUST_KEY"), "");
		// 編集用にリストのコピーを返す。
		VRList clone = new VRArrayList();
		// データのクローンを作成する。
		clone.addAll(QkanValidServiceCommon.deepCopyVRList(sogoOverAdjustMap
				.get(key)));
		return clone;
	}

	/**
	 * 入力された計画単位数をもとに区分支給超単位数を設定します。
	 * 
	 * @param source
	 *            調整額の変更対象行データ
	 * @param planUnit
	 *            計画単位数
	 */
	public void applyPlanUnit(Map source, int planUnit) {
		String key = ACCastUtilities.toString(source.get("KEY"), "");
		Map<String, Object> parsedRow = parsedData.get(key);

		// 総合事業の独自定率・独自定額以外のとき
		if (!parsedRow.containsKey("SOGO_OVER_ADJUST_KEY")) {
			int unit = ACCastUtilities.toInt(parsedRow.get("UNIT"), 0);
			int adjust = unit - planUnit;
			if (adjust < 0) {
				adjust = 0;
			}
			//計画単位数が0のときは未設定として調整額も0とする
			if (planUnit == 0) {
				adjust = 0;
			}
			parsedRow.put("ADJUST", adjust);
			
			// 調整額をサービスに割り振る
			applyAdjustUnit(parsedRow);
			return;
		}
		
		// 総合事業の独自定率・独自定額の場合
		// 対象となるサービスに調整額を割り振る
		if (parsedRow.containsKey("SOGO_OVER_ADJUST_KEY")) {

			// キーを取得
			String adjustKey = ACCastUtilities.toString(
					parsedRow.get("SOGO_OVER_ADJUST_KEY"), "");

			// 単位数の合計を求める
			int totalUnit = 0;
			VRList list = sogoOverAdjustMap.get(adjustKey);
			for (int index = 0; index < list.size(); index++) {
				Map row = (Map) list.get(index);
				int unit = ACCastUtilities.toInt(row.get("UNIT"), 0);
				totalUnit += unit;
			}
			// 割振り対象の調整額
			// 単位数の合計から計画単位数を引く
			int zan = totalUnit - planUnit;
			if (zan < 0) {
				zan = 0;
			}
			//計画単位数が0のときは未設定として調整額も0とする
			if (planUnit == 0) {
				zan = 0;
			}

			// 自己負担額が少なくなるように並び替え
			List<Map<String, Object>> sortedList = new ArrayList(list);
			String kind = ACCastUtilities.toString(
					parsedRow.get("SERVICE_CODE_KIND"), "");
			if (QkanSjServiceCodeManager.teiritsuKinds.contains(kind)) {
				// 独自定率の場合は、給付率の低いものを優先
				Collections.sort(sortedList, new SogoKyufuritsuComparator());
			} else if (QkanSjServiceCodeManager.teigakuKinds.contains(kind)) {
				// 独自定額の場合は、１単位あたりの利用者負担額が高いものを優先
				Collections.sort(sortedList, new SogoTeigakuComparator());
			}

			for (Map<String, Object> row : sortedList) {
				// サービスに割振り可能な単位数
				int kano = ACCastUtilities.toInt(row.get("UNIT"), 0);
				int wariate = 0;
				if (zan <= kano) {
					// 割り当て残がサービスに割振り可能な単位数よりも小さいか、等しい場合、残りを全部割り当て
					wariate = zan;
				} else {
					// 割り当て残がサービスに割振り可能な単位数よりも大きい場合、割り当て可能な分を割り当て
					wariate = kano;
				}
				row.put("ADJUST", wariate);

				// 割り当てた分を残から引く
				zan = zan - wariate;

				// 調整額をサービスに割り振る
				applyAdjustUnit(row);
			}
		}
	}
	
	/**
	 * 総合事業の独自サービスで計画単位数と調整額に不整合がないかチェックします。
	 * 不整合があった場合は、対象行と計画単位数の情報を返します。
	 * 
	 * @return チェック結果
	 * @throws Exception
	 */
	public List<Map<String, Object>> checkAndAdjustUnits() throws Exception {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
		// 総合事業の独自定率・独自定額のサービス種類ごとのリストを作成
		createSogoOverAdjustMap();
		
		for (Map<String, Object> parsedRow : parsedData.values()) {
			
			String kind = ACCastUtilities.toString(parsedRow.get("SERVICE_CODE_KIND"), "");
			if (!QkanSjServiceCodeManager.dokujiTeiritsuTeigakuKinds.contains(kind)) {
				//独自・独自定率・定額でなければスキップ
				continue;
			}
			if (Boolean.TRUE.equals(parsedRow.get(PLAN_UNIT_SETUPED))) {
				continue; //チェック済みの行はスキップ
			}
			
			// 総合事業の独自定率・独自定額の場合
			// 対象となるサービスに調整額を割り振る
			if (parsedRow.containsKey("SOGO_OVER_ADJUST_KEY")) {
				// キーを取得
				String adjustKey = ACCastUtilities.toString(
						parsedRow.get("SOGO_OVER_ADJUST_KEY"), "");

				int planUnit = ACCastUtilities.toInt(parsedRow.get("PLAN_UNIT"), 0);
				// 単位数の合計を求める
				int totalUnit = 0;
				int totalAdjust = 0;
				VRList list = sogoOverAdjustMap.get(adjustKey);
				for (int index = 0; index < list.size(); index++) {
					Map row = (Map) list.get(index);
					int unit = ACCastUtilities.toInt(row.get("UNIT"), 0);
					int adjust = ACCastUtilities.toInt(row.get("ADJUST"), 0);
					totalUnit += unit;
					totalAdjust += adjust;
					
					// この行はチェック済とする
					row.put(PLAN_UNIT_SETUPED, true);
				}
				if (planUnit > 0) {
					if (totalUnit > planUnit) {
						if (totalUnit != (totalAdjust + planUnit)) {
							// 不整合な対象行と計画単位数を返す
							Map<String, Object> ret = new HashMap<String, Object>();
							ret.put("PARSED_ROW", parsedRow);
							ret.put("PLAN_UNIT", planUnit);
							results.add(ret);
						}
					}
				} else if (planUnit == 0) {
					// 計画単位数が0だが調整額のみ設定されている場合
					if (totalAdjust != 0) {
						// 不整合な対象行と計画単位数を返す
						Map<String, Object> ret = new HashMap<String, Object>();
						ret.put("PARSED_ROW", parsedRow);
						ret.put("PLAN_UNIT", planUnit);
						results.add(ret);
					}
				}
			} else {
				// 独自の場合、計画単位数を再設定することで自動的に調整する。
				int unit = ACCastUtilities.toInt(parsedRow.get("UNIT"), 0);
				int adjust = ACCastUtilities.toInt(parsedRow.get("ADJUST"), 0);
				int planUnit = ACCastUtilities.toInt(parsedRow.get("PLAN_UNIT"), 0);
				if (planUnit > 0) {
					if (unit > planUnit) {
						if (unit != (adjust + planUnit)) {
							// 計画単位数から調整額の再設定
							applyPlanUnit(parsedRow, planUnit);
						}
					}
				} else if (planUnit == 0) {
					// 計画単位数が0だが調整額のみ設定されている場合
					if (adjust != 0) {
						// 計画単位数から調整額の再設定
						applyPlanUnit(parsedRow, planUnit);
					}
				}
			}
		}
		return results;
	}

	// 給付率でソートするComparator
	private class SogoKyufuritsuComparator implements
			java.util.Comparator<Map<String, Object>> {
		public int compare(Map<String, Object> object1,
				Map<String, Object> object2) {
			Integer int1 = ACCastUtilities.toInt(
					object1.get("SOGO_KYUFURITSU"), 0);
			Integer int2 = ACCastUtilities.toInt(
					object2.get("SOGO_KYUFURITSU"), 0);
			return int1.compareTo(int2);
		}
	}
	
	// １単位あたりの利用者負担額の降順でソートするComparator
	private class SogoTeigakuComparator implements
			java.util.Comparator<Map<String, Object>> {
		public int compare(Map<String, Object> object1,
				Map<String, Object> object2) {
			BigDecimal unit1 = new BigDecimal(ACCastUtilities.toInt(
					object1.get("TEIGAKU_UNIT"), 0));
			BigDecimal futan1 = new BigDecimal(ACCastUtilities.toInt(
					object1.get("TEIGAKU_FUTAN_TANKA"), 0));
			BigDecimal cost1 = futan1.divide(unit1, 7, BigDecimal.ROUND_HALF_UP);
			
			BigDecimal unit2 = new BigDecimal(ACCastUtilities.toInt(
					object2.get("TEIGAKU_UNIT"), 0));
			BigDecimal futan2 = new BigDecimal(ACCastUtilities.toInt(
					object2.get("TEIGAKU_FUTAN_TANKA"), 0));
			BigDecimal cost2 = futan2.divide(unit2, 7, BigDecimal.ROUND_HALF_UP);
			
			return cost1.compareTo(cost2) * -1;
		}
	}

}
