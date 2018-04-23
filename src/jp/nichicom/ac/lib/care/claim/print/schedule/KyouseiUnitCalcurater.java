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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;

/**
 * 共生型の減算の単位数算定クラス
 * 
 * [H30.04改正対応]
 * 給付限度額管理対象の積み上げ計算や、負担額調整分の単位数の各サービスへの割り振り
 * を行う際に日数や回数でのサービス算定時点に対して減算単位数の計算を行う。
 * 
 * @author Yoichiro Kamei
 *
 */
public class KyouseiUnitCalcurater {
	
	//このクラスで追加した共生型サービスの単位数
	//（既に設定済みのキーと重複しないようにクラス名を付けています）
	private static String KYOUSEI_UNIT = KyouseiUnitCalcurater.class.getSimpleName() + "_KYOUSEI_UNIT";
	
	//このクラスで追加した共生型サービスのサービスコードを格納するKEY文字列
	//（既に設定済みのキーと重複しないようにクラス名を付けています）
	private static String KYOUSEI_SERVICE_CODE = KyouseiUnitCalcurater.class.getSimpleName() + "_KYOUSEI_SERVICE_CODE";
	
	//このクラスで追加した共生型サービスが対象とする基本サービス単位数を格納するKEY文字列
	//（既に設定済みのキーと重複しないようにクラス名を付けています）
	private static String KYOUSEI_KIHON_UNIT = KyouseiUnitCalcurater.class.getSimpleName() + "_KYOUSEI_KIHON_UNIT";
	
	//<共生型サービスのサービス項目コード、サービスコードマスタ情報>
	private Map<String, Map<String, Object>> kyouseiCodes = new HashMap<String, Map<String, Object>>();
	
	//<共生型サービスのサービス項目コード、計算済みの基本サービス単位数の合算>
	private Map<String, Integer> sumKihonUnitMap = new HashMap<String, Integer>();
	
	//<共生型サービスのサービス項目コード、計算済みの共生型減算の単位数の合算>
	private Map<String, Integer> sumKyouseiUnitMap = new HashMap<String, Integer>();
	
	//共生型減算が算定されているサービスのリスト（時系列でソートされていること）
	private List<Map<String, Object>> services = new ArrayList<Map<String, Object>>();

	
    /**
     * 指定したサービスに共生型減算の対象となる基本サービス単位数を設定します。
     */
	public void putKihonUnit(Map<String, Object> service, int unit) {
		service.put(KYOUSEI_KIHON_UNIT, new Integer(unit));
	}
	
    /**
     * 指定したサービスに共生型減算のサービス項目コードを設定します。
     * @throws Exception 
     */
	public void putKyouseiCode(Map<String, Object> service, Map<String, Object> code) throws Exception {
		String kyouseiKind = ACCastUtilities.toString(code.get("SERVICE_CODE_KIND"));
		String kyouseiItemCode = ACCastUtilities.toString(code.get("SERVICE_CODE_ITEM"));
		String svCode = kyouseiKind + kyouseiItemCode;
		service.put(KYOUSEI_SERVICE_CODE, svCode);
		//計算用にマスタ情報を格納
		if (!kyouseiCodes.containsKey(svCode)) {
			kyouseiCodes.put(svCode, code);			
		}
	}
	
    /**
     * 指定したサービスがこのクラスでの計算対象となるかどうかを返します。
     * （共生型減算のサービス項目コードと生型減算の対象となる基本サービス単位数がこのクラスにより設定されているかどうか）
     */
	public boolean isKyouseiCalcService(Map<String, Object> service) {
		return service.containsKey(KYOUSEI_KIHON_UNIT) && service.containsKey(KYOUSEI_SERVICE_CODE);
	}
	
    /**
     * このクラスでの計算対象となるサービスを保持しているかどうかを返します。
     */
	public boolean hasService() {
		return !services.isEmpty();
	}
	
    /**
     * 共生型減算の計算対象となるサービスを追加します。
     */
	public void addKyouseiService(Map<String, Object> service) {
		services.add(service);
	}
	
    /**
     * 共生型減算の計算を行います。
     * @throws Exception 
     */
	public void calcKyouseiUnit() throws Exception {
		calcKyouseiUnit(null);
	}
	
    /**
     * 共生型減算の計算を行います。
     * @param serviceUnitKey サービスに保持している単位数に減算を反映する場合にそのKEYを指定する
     * @throws Exception 
     */
	public void calcKyouseiUnit(String serviceUnitKey) throws Exception {
		for (Map<String, Object> service : services) {
			String svCode = ACCastUtilities.toString(service.get(KYOUSEI_SERVICE_CODE), "");
			int kihonUnit = ACCastUtilities.toInt(service.get(KYOUSEI_KIHON_UNIT), 0);
			int sumKyouseiUnit = ACCastUtilities.toInt(sumKyouseiUnitMap.get(svCode), 0);
			int sumKihonUnit = ACCastUtilities.toInt(sumKihonUnitMap.get(svCode), 0);
			
			if (kihonUnit == 0 || "".equals(svCode)) {
				continue;
			}
			
			//共生型減算のサービスコードマスタ情報
			Map<String, Object> kyouseiCode = kyouseiCodes.get(svCode);			
			int per = ACCastUtilities.toInt(kyouseiCode.get("SERVICE_UNIT"), 0);//減算率
			
			//このサービス算定時点での共生型減算の単位数
			int nowKihonUnit = sumKihonUnit + kihonUnit;
			int nowKyouseiUnit = CareServiceCommon.calcPercentageUnit(nowKihonUnit, per);
			int diffKyouseiUnit = nowKyouseiUnit - sumKyouseiUnit;
			//共生型減算単位数の前回値との差分を減算単位数としてサービスに設定
			service.put(KYOUSEI_UNIT, diffKyouseiUnit);
			
			//serviceUnitKeyが指定されている場合、そのKEYに減算単位数を反映する
			if (serviceUnitKey != null && !"".equals(serviceUnitKey)) {
				if (service.containsKey(serviceUnitKey)) {
					int nowUnit = ACCastUtilities.toInt(service.get(serviceUnitKey), 0);
					service.put(serviceUnitKey, nowUnit + diffKyouseiUnit);
				} else {
					service.put(serviceUnitKey, diffKyouseiUnit);
				}
			}
			
			//合算値の更新
			sumKyouseiUnitMap.put(svCode, nowKyouseiUnit);
			sumKihonUnitMap.put(svCode, nowKihonUnit);
		}
	}
	
    /**
     * このクラスで計算用に追加したサービスのマップKEYを削除します。
     * （このクラスで計算した共生型減算の単位数を使用した後、サービスに不要なKEYが残っていると不都合がある場合に呼ぶ）
     */
	public void removeServiceKey() {
		for (Map<String, Object> service : services) {
			service.remove(KYOUSEI_UNIT);
			service.remove(KYOUSEI_SERVICE_CODE);
			service.remove(KYOUSEI_KIHON_UNIT);
		}
	}

}
