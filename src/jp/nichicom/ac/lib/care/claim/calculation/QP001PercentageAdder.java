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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.vr.text.parsers.VRDateParser;

/**
 * %加減算の算定クラス
 * 
 * @author Yoichiro Kamei
 *
 */
public class QP001PercentageAdder {
	
	//対象となる加算の算定対象となる基本サービス情報
	private Map<String, Object> serviceUnitMap = new HashMap<String, Object>();

	//算定の際に計算に含める関連加算の情報
	private Map<Integer, Map<Integer, Map<String, Object>>> relationAddMap 
		= new HashMap<Integer, Map<Integer, Map<String, Object>>>();
	
	private static Integer SERVICE_ADD_FLAG_KYOUSEI = new Integer(5);
	private static Integer SERVICE_ADD_FLAG_SAME_BUILDING = new Integer(7);
	private static Integer SERVICE_ADD_FLAG_TOKUCHI = new Integer(3);
	

	//算定対象となる基本サービスのKeySetを取得します。
	public Set<String> getKihonKeySet() {
		return serviceUnitMap.keySet();	
	}
	
	protected void parse(Map serviceCode, Object targetServiceDate) throws Exception {
	    
	    String offer = VRDateParser.format(ACCastUtilities.toDate(targetServiceDate), "yyyyMMdd");
	    	    
	    if (CareServiceCommon.isAddPercentageForKyousei(serviceCode)) {
	    	//共生型減算の場合
            Map unitMap = (Map)serviceCode.get("SERVICE_UNIT_MAP_5");
            parseMap(offer, unitMap, serviceUnitMap);
	    } else if (CareServiceCommon.isAddPercentageForDoitu(serviceCode)) {
	    	//同一建物減算の場合
            Map unitMap = (Map)serviceCode.get("SERVICE_UNIT_MAP_7");
            parseMap(offer, unitMap, serviceUnitMap);
            //関連加算の解析
            parseRelations(serviceCode, offer);
	    } else if (CareServiceCommon.isAddPercentageForSimple(serviceCode)) {
	    	//特別地域加算、小規模事業所加算の場合
            Map unitMap = (Map)serviceCode.get("SERVICE_UNIT_MAP");
            parseMap(offer, unitMap, serviceUnitMap);
            //関連加算の解析
            parseRelations(serviceCode, offer);
	    } else if (CareServiceCommon.isAddPercentageForArea(serviceCode)) {
	    	//中山間地域等提供加算の場合
            Map unitMap = (Map)serviceCode.get("SERVICE_UNIT_MAP");
            parseMap(offer, unitMap, serviceUnitMap);
            //関連加算の解析
            parseRelations(serviceCode, offer);
	    }
	    
	}
	
	private void parseRelations(Map serviceCode, String offer) throws Exception {
        //共生型減算の関連情報を保持している場合
        if (serviceCode.containsKey("SERVICE_UNIT_ADD_MAP_5")) {
        	Map addMap = (Map) serviceCode.get("SERVICE_UNIT_ADD_MAP_5");
        	int addFlg = ACCastUtilities.toInt(addMap.get("SERVICE_ADD_FLAG"), 0);
        	int relateAddRate = ACCastUtilities.toInt(addMap.get("SERVICE_UNIT"), 0);
        	if (addMap.containsKey("SERVICE_UNIT_MAP_5")){
        		Map unitMapKyousei = (Map) addMap.get("SERVICE_UNIT_MAP_5");
        		parseAddMap(offer, unitMapKyousei, addFlg, relateAddRate);
        	}
        }
        //同一建物減算の関連情報を保持している場合
        if (serviceCode.containsKey("SERVICE_UNIT_ADD_MAP_7")) {
        	Map addMap = (Map) serviceCode.get("SERVICE_UNIT_ADD_MAP_7");
        	int addFlg = ACCastUtilities.toInt(addMap.get("SERVICE_ADD_FLAG"), 0);
        	int relateAddRate = ACCastUtilities.toInt(addMap.get("SERVICE_UNIT"), 0);
        	if (addMap.containsKey("SERVICE_UNIT_MAP_7")){
        		Map unitMapDouitu = (Map) addMap.get("SERVICE_UNIT_MAP_7");
        		parseAddMap(offer, unitMapDouitu, addFlg, relateAddRate);
        	}
        }
        //特別地域加算、小規模事業所加算のの関連情報を保持している場合
        if (serviceCode.containsKey("SERVICE_UNIT_ADD_MAP")) {
        	Map addMap = (Map) serviceCode.get("SERVICE_UNIT_ADD_MAP");
        	int addFlg = ACCastUtilities.toInt(addMap.get("SERVICE_ADD_FLAG"), 0);
        	int relateAddRate = ACCastUtilities.toInt(addMap.get("SERVICE_UNIT"), 0);
        	if (addMap.containsKey("SERVICE_UNIT_MAP")){
        		Map unitMap = (Map) addMap.get("SERVICE_UNIT_MAP");
        		parseAddMap(offer, unitMap, addFlg, relateAddRate);
        	}
        }
	}
	
	private void parseAddMap(String offer, Map unitMap, int addFlg, int rate) throws Exception {
		//relationAddMapは加算フラグ、加算減算率ごとに情報を保持
		if (!relationAddMap.containsKey(addFlg)) {
			relationAddMap.put(addFlg, new HashMap<Integer, Map<String, Object>>());
		}
		Map<Integer, Map<String, Object>> serviceUnitAddRateMap = relationAddMap.get(addFlg);
		if (!serviceUnitAddRateMap.containsKey(rate)) {
			serviceUnitAddRateMap.put(rate, new HashMap<String, Object>());
		}
		Map<String, Object> serviceUnitAddMap = serviceUnitAddRateMap.get(rate);
				
		parseMap(offer, unitMap, serviceUnitAddMap);
	}
	
	private void parseMap(String offer, Map unitMap, Map<String, Object> target) throws Exception {
        Iterator it = unitMap.keySet().iterator();
        String key = "";
        //レコード確定時に一括集計
        while(it.hasNext()){
            key = String.valueOf(it.next());
            Map map = null;
            Integer times = null;
            Set<String> offerDay = null;
            
            //登録済みのサービスの場合
            if(target.containsKey(key)){
                map = (Map)target.get(key);
                times = (Integer)map.get("TIMES");
                offerDay = (Set)map.get("OFFER");
                
            } else {
                map = new HashMap();
                map.put("UNIT",unitMap.get(key));
                target.put(key,map);
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
	}
	
	protected boolean hasData() {
		return !serviceUnitMap.isEmpty();
	}
	
	protected int getUnit() throws Exception {
		
		int baseUnit = getUnitTotal(serviceUnitMap);
		int diffUnit = 0;
		
		//関連加算の単位数を計算して対象単位数に反映
		if (!relationAddMap.isEmpty()) {
			Map<Integer, Map<String, Object>> serviceUnitAddRateMap;
			//共生型減算の計算
			int kyouseiUnit = 0;
			if (relationAddMap.containsKey(SERVICE_ADD_FLAG_KYOUSEI)) {
				serviceUnitAddRateMap = relationAddMap.get(SERVICE_ADD_FLAG_KYOUSEI);
				for (int rate : serviceUnitAddRateMap.keySet()) {
					Map<String, Object> serviceUnitAddMap = serviceUnitAddRateMap.get(rate);
					int tmp = getUnitTotal(serviceUnitAddMap);
					kyouseiUnit += CareServiceCommon.calcPercentageUnit(tmp, rate);
				}
				diffUnit += kyouseiUnit;
			}
			//同一建物減算の計算
			int douituUnit = 0;
			if (relationAddMap.containsKey(SERVICE_ADD_FLAG_SAME_BUILDING)) {
				serviceUnitAddRateMap = relationAddMap.get(SERVICE_ADD_FLAG_SAME_BUILDING);
				for (int rate : serviceUnitAddRateMap.keySet()) {
					Map<String, Object> serviceUnitAddMap = serviceUnitAddRateMap.get(rate);
					int tmp = getUnitTotal(serviceUnitAddMap);
					douituUnit += CareServiceCommon.calcPercentageUnit(tmp + diffUnit, rate);
				}
				diffUnit += douituUnit;
			}
			//特別地域加算、小規模事業所加算の計算
			int areaUnit = 0;
			if (relationAddMap.containsKey(SERVICE_ADD_FLAG_TOKUCHI)) {
				serviceUnitAddRateMap = relationAddMap.get(SERVICE_ADD_FLAG_TOKUCHI);
				for (int rate : serviceUnitAddRateMap.keySet()) {
					Map<String, Object> serviceUnitAddMap = serviceUnitAddRateMap.get(rate);
					int tmp = getUnitTotal(serviceUnitAddMap);
					areaUnit += CareServiceCommon.calcPercentageUnit(tmp + diffUnit, rate);
				}
				diffUnit += areaUnit;
			}
		}
		
		return (baseUnit + diffUnit);
	}
	
	private int getUnitTotal(Map<String, Object> target) throws Exception {
		int totalUnit = 0;
		for (String key : target.keySet()) {
            //単位数-回数
            Map map = (Map) target.get(key);
            Integer unit = (Integer) map.get("UNIT");
            Integer times = (Integer) map.get("TIMES");
            totalUnit += unit.intValue() * times.intValue();
		}
        return totalUnit;
	}
	

	/**
	 * 保持しているサービスからkeyに指定したサービスを除外します。
	 * 
	 * keyは以下の結合文字列となります。
	 * "SYSTEM_SERVICE_KIND_DETAIL"-"SYSTEM_SERVICE_CODE_ITEM"-"TOTAL_GROUPING_TYPE"
	 * 総合事業の独自の場合は、
	 * "INSURER_ID-SYSTEM_SERVICE_KIND_DETAIL"-"SYSTEM_SERVICE_CODE_ITEM"-"TOTAL_GROUPING_TYPE"
	 */
	public void removeService(String key) {
		if (!relationAddMap.isEmpty()) {
			for (Map<Integer, Map<String, Object>> serviceUnitAddRateMap : relationAddMap.values()) {
				for (Map<String, Object> serviceUnitAddMap : serviceUnitAddRateMap.values()) {
					serviceUnitAddMap.remove(key);
				}
			}
		}
		if (!serviceUnitMap.isEmpty()) {
			serviceUnitMap.remove(key);
		}
	}


}
