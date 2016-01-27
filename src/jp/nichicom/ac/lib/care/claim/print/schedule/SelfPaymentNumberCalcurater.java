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
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.calculation.QP001PatientState;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanValidServiceCommon;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;

/**
 * 区分支給限度管理外の回数（日数）単位自己負担算定クラス
 * 
 * [H27.04改正対応]
 * サービス提供体制加算が区分支給限度額管理の対象外となったため
 * 限度額を超えて利用した分は自己負担となる。
 * 自己負担分の単位数や回数を算定するためのクラス
 * 
 * @author Yoichiro Kamei
 *
 */
public class SelfPaymentNumberCalcurater {
	
	private CareServiceCodeCalcurater calcurater;
	
	//区分支給限度の管理を行わないサービス種類
	private static List<String> taishogaiKindList = Arrays.asList(new String[]{
		"31", "32", "33", "34", "35", "36", "37", "43", "51", "52", "53", "54"
	});
	
	//このクラスで追加した単位数を格納するKEY文字列
	//（既に設定済みのキーと重複しないようにクラス名を付けています）
	private static String ADD_UNIT_NAME = SelfPaymentNumberCalcurater.class.getSimpleName() + "_SERVICE_UNIT";
	
	//解析対象のサービス全体のリスト
	private List<Map<String, Object>> serviceAllList;
	
	//単位数積み上げ対象のサービスのリスト
	private List<Map<String, Object>> targetServiceList;
	
	//自己負担となる単位数
	private int selfPayUnit = 0;
	
	//区分支給管理限度内としての回数（国保連に請求できる回数）
	private int limitInNumber = 0;
	
	//対象サービスコードの単位数
	private int reductedUnit = 0;
	
	/**
	 * コンストラクタ。
	 * 
	 * @param calcurater 生成、初期化済みのCareServiceCodeCalcurater
	 * @param serviceList 解析対象となるサービスのリスト
	 */
	public SelfPaymentNumberCalcurater(CareServiceCodeCalcurater calcurater,
			List services) throws Exception {
		this.calcurater = calcurater;
		// 参照関係のないデータを作成する
		this.serviceAllList = QkanValidServiceCommon.deepCopyVRList(new VRArrayList(services));
	}
	
	/**
	 * コンストラクタ。
	 * 
	 * @param dbm ACDBManager
	 * @param targetDate 対象年月
	 * @param patientInfo patientInfo
	 * @param patientState QP001PatientState
	 * @param services 解析対象となるサービスのリスト
	 */
	public SelfPaymentNumberCalcurater(ACDBManager dbm, 
			Date targetDate,
			VRMap patientInfo,
			QP001PatientState patientState,
			List services) throws Exception {
		// サービス単位計算クラスを生成
		this.calcurater = new CareServiceCodeCalcurater();
		
		VRMap hashedProviders = new VRHashMap();
		ACBindUtilities.setMapFromArray(QkanCommon.getProviderInfo(dbm), hashedProviders, "PROVIDER_ID");
		int inSpecialFacilityFlag =  ACCastUtilities.toInt(patientState.getShisetsuData("TOKUTEI_NYUSHO_FLAG"), 0);
		int oldFacilityUserFlag = ACCastUtilities.toInt(patientState.getShisetsuData("KYUSOCHI_FLAG"), 0);
		VRList insureInfoHistory = QkanCommon.getPatientInsureInfoHistory(dbm, targetDate, patientState.getPatientId());
		//serviceKindsは使用していないので空のリストをセットしている
		this.calcurater.initialize(targetDate, patientInfo, insureInfoHistory, hashedProviders, dbm, new VRArrayList(), inSpecialFacilityFlag, oldFacilityUserFlag);
		
		// 参照関係のないデータを作成する
		this.serviceAllList = QkanValidServiceCommon.deepCopyVRList(new VRArrayList(services));
	}

    /**
     * 対象のサービスコードであるかどうかを返す。
     * 
     * 区分支給限度額の管理を行うサービス種類のうち、
     * 区分支給限度管理外のサービスコードでサービス加算フラグ（単位加算、単位減算）、
     * 算定単位が「1回につき」、「１日につき」の場合に対象となる。
     * 
     * @param serviceCode M_SERVICE_CODEのレコードが格納されたマップ
     * @return 対象のサービスコードであるかどうか
     */
	public static boolean isTaisho(Map<String, Object> serviceCode) {
		try {
			String serviceCodeKind = ACCastUtilities.toString(serviceCode.get("SERVICE_CODE_KIND"));

	        //区分支給限度の管理を行わないサービス種類の場合
	        if (taishogaiKindList.contains(serviceCodeKind)) {
	        	return false;
	        }
	        
	        int serviceAddFlg = ACCastUtilities.toInt(serviceCode.get("SERVICE_ADD_FLAG"));
	        int limitAmountObject = ACCastUtilities.toInt(serviceCode.get("LIMIT_AMOUNT_OBJECT"));
	        int serviceMainFlg = ACCastUtilities.toInt(serviceCode.get("SERVICE_MAIN_FLAG"));
	        int totalGroupingType = ACCastUtilities.toInt(serviceCode.get("TOTAL_GROUPING_TYPE"));
	        
	        if (   (limitAmountObject == 2) //区分支給限度額外
	        	&& (serviceAddFlg == 2 || serviceAddFlg == 4) //サービス加算フラグ（単位加算、単位減算）
	        	&& (serviceMainFlg == 0) //本体報酬以外
	        	&& (totalGroupingType == 1 || totalGroupingType == 2) //集計集合化区分（回、日）
	        ) {
	        	return true;
	        }
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
    /**
     * 解析済みの対象サービスコードについて単位数を取得する。
     * （parseServiceCode実行後に呼ぶ）
     * 
     * @return 解析済みの対象サービスコードについての単位数
     */
	public int getReductedUnit() {
		return this.reductedUnit;
	}
	
    /**
     * 単位数の積み上げ結果について自己負担となる単位数を取得する。
     * （parseServiceCode実行後に呼ぶ）
     * 
     * @return 自己負担となる単位数
     */
	public int getSelfPayUnit() {
		return this.selfPayUnit;
	}
	
    /**
     * 単位数の積み上げ結果について区分支給限度内としての回数を取得する。
     * （parseServiceCode実行後に呼ぶ）
     * 
     * @return 区分支給限度内としての回数
     * */
	public int getLimitInNumber() {
		return this.limitInNumber;
	}
	
    /**
     * 対象のサービスコードについて単位数の積み上げ処理を行う。
     * 
     * @param serviceCode M_SERVICE_CODEのレコードが格納されたマップ
     * @param targetProviderId 事業所コード
     * @param limitOverUnit 超過分の単位数
     */
	public void parseServiceCode(Map<String, Object> serviceCode, String targetProviderId, int limitOverUnit) throws Exception {
		
		String serviceCodeKind = ACCastUtilities.toString(serviceCode.get("SERVICE_CODE_KIND"));
		String serviceCodeItem = ACCastUtilities.toString(serviceCode.get("SERVICE_CODE_ITEM"));
		int serviceUnit = ACCastUtilities.toInt(serviceCode.get("SERVICE_UNIT"));
		int reductedUnit = calcurater.getReductedUnit(targetProviderId, serviceCode, serviceUnit);
		
		//積み上げ対象となるサービスの総単位数
		int totalUnit = parseServiceList(serviceCode, targetProviderId);
		
		// サービスを時系列でソートする
		Collections.sort(this.targetServiceList, new ServiceDateTimeLineComparator());
		
		//限度額オーバーを判定する単位数
		int limitPoint = totalUnit - limitOverUnit;
		
		int limitInNum = 0; //限度内としての回数
		int limitOverNum = 0; //限度外としての回数
		int tumiageUnit = 0; //積み上げ中の単位数
		boolean overFlg = false;
		if (limitPoint == 0) {
			//限度額を使い切っているのでオーバーとみなす
			overFlg = true;
		}
		for (Map<String, Object> service : targetServiceList) {
			//単位数の積み上げ
			int unit = ACCastUtilities.toInt(service.get(ADD_UNIT_NAME));
			
			tumiageUnit += unit;
			
			List<Map<String, Object>> codes = calcurater.getServiceCodes((VRMap) service);
			if (isExistsCode(codes, serviceCodeKind, serviceCodeItem)) {
				//対象のサービスが算定されている場合、限度内、限度外の回数を計上
				if (overFlg) {
					//すでにオーバーしている場合
					limitOverNum++;
				} else {
					//オーバーしていないか、このサービスでオーバーする場合
					limitInNum++;
				}
			}
			//積み上げた結果が基準単位数をオーバーしていた場合（等しい場合も限度額を使い切ったので、オーバーとする）
			if (tumiageUnit >= limitPoint) {
				overFlg = true;
			}
		}
		
		this.reductedUnit = reductedUnit;
		this.selfPayUnit = reductedUnit * limitOverNum;
		this.limitInNumber = limitInNum;
	}
	
	//codesで指定したサービスのなかに対象のコードが存在するかどうかを返す
	private boolean isExistsCode(List<Map<String, Object>> codes,  String kind, String item) throws Exception {
		for (Map<String, Object> code : codes) {
			String serviceCodeKind = ACCastUtilities.toString(code.get("SERVICE_CODE_KIND"));
			String serviceCodeItem = ACCastUtilities.toString(code.get("SERVICE_CODE_ITEM"));
			if (kind.equals(serviceCodeKind) && item.equals(serviceCodeItem)) {
				return true;
			}
		}
		return false;
	}
	
	// 全体のサービスリストから積み上げ対象となるサービスのリストに移す。
	// 積み上げ対象となるサービスの単位数を合計して返す。
	private int parseServiceList(Map<String, Object> serviceCode, String targetProviderId) throws Exception {
		int totalUnit = 0;
		targetServiceList = new ArrayList<Map<String, Object>>();
		
		String targetServiceKind = ACCastUtilities.toString(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL"));
		Map[] totalGroupingCache = new Map[] { new HashMap(), new HashMap() };
		for (Map<String, Object> service : serviceAllList) {
			String serviceKind = ACCastUtilities.toString(service.get("SYSTEM_SERVICE_KIND_DETAIL"), "");
			String providerId = ACCastUtilities.toString(service.get("PROVIDER_ID"), "");
			
			if (!providerId.equals(targetProviderId) || !serviceKind.equals(targetServiceKind)) {
				//事業所かサービス種類が異なれば対象外なのでスキップ
				continue;
			}
			
			if (CareServiceCommon.is30DayOver((VRMap) service)) {
				//30日超であれば、対象外なのでスキップ
				continue;
			}
			
			//サービスからコード集合を取得して、支給限度額管理対象の単位数の合計を求める
			int unit = calcurater.getReductedUnit((VRMap) service, false, CareServiceCodeCalcurater.CALC_MODE_IN_LIMIT_AMOUNT_OR_OUTER_SERVICE, totalGroupingCache);
			//単位数0の場合は、算定単位「1日につき」を1日に2回以上算定している場合等なので、
			//算定対象外のサービスとみなして、0でなければ積み上げ対象に追加
			if (unit != 0) {
				service.put(ADD_UNIT_NAME, unit);
				totalUnit += unit;
				
				//積み上げ対象となるサービスのリストに移す
				targetServiceList.add(service);
			}
		}
		return totalUnit;
	}
	
    /**
     * 時系列でサービスをソートする。
     * サービス提供日、開始時刻、単位数の昇順でソート
     */
    private class ServiceDateTimeLineComparator implements java.util.Comparator<Map<String, Object>> {
        public int compare(Map<String, Object> object1, Map<String, Object> object2) {
            Date date1 = ACCastUtilities.toDate(object1.get("SERVICE_DATE"), null);
            Date date2 = ACCastUtilities.toDate(object2.get("SERVICE_DATE"), null);
            
            if (date1 != null && date2 == null) {
            	return 1;
            } else if (date1 == null && date2 != null) {
            	return -1;
            }
            int dateResult = date1.compareTo(date2);
            if (dateResult != 0) {
            	return dateResult;
            }
            
            //日付が同じ場合、開始時刻を見る
            date1 = ACCastUtilities.toDate(object1.get("3"), null);
            date2 = ACCastUtilities.toDate(object2.get("3"), null);
            //どちらかが未入力の場合、未入力の方が先
            if (date1 != null && date2 == null) {
                return 1;
            } else if (date1 == null && date2 != null) {
                return -1;
            }
            if (date1 != null && date2 != null) {
                Integer hour1 = ACDateUtilities.getHourOfDay(date1);
                Integer hour2 = ACDateUtilities.getHourOfDay(date2);
                int hourResult = hour1.compareTo(hour2);
                if (hourResult != 0) {
                	return hourResult;
                }
                
                Integer minute1 = ACDateUtilities.getMinute(date1);
                Integer minute2 = ACDateUtilities.getMinute(date2);
                int minuteResult = minute1.compareTo(minute2);
                if (minuteResult != 0) {
                	return minuteResult;
                }
            }
            
            //開始時刻が同じ場合、単位数でソート
            Integer unit1 = ACCastUtilities.toInt(object1.get(ADD_UNIT_NAME), 0);
            Integer unit2 = ACCastUtilities.toInt(object2.get(ADD_UNIT_NAME), 0);
            return unit1.compareTo(unit2);
        }
    }

}
