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
 * 作成日: 2009/03/26  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス 請求処理 (001)
 * プログラム 中山間地域加算算定クラス（QP001MountainousAreaAdder）
 *
 *****************************************************************
 */
package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;

/**
 * 中山間地域加算の算定クラス
 * 
 * 処理が複雑なので、この加算のみ特別に切り出してクラス化
 * 
 * @author Shin Fujihara
 *
 */
public class QP001MountainousAreaAdder {
	
	//通常の基本単位退避用
	private VRMap serviceUnitMap = new VRHashMap();
	//特別地域加算算定用
	private VRMap serviceUnitAddMap = new VRHashMap();
	//特別地域加算の掛け率
	private int serviceUnitAddRaito = Integer.MIN_VALUE;
	
	
	protected void parse(VRMap serviceCode, Object targetServiceDate) throws Exception {
	    
	    String offer = VRDateParser.format(ACCastUtilities.toDate(targetServiceDate), "yyyyMMdd");
	    
        //リストを保持している場合
        if(serviceCode.containsKey("SERVICE_UNIT_MAP")){
            VRMap unitMap = (VRMap)serviceCode.get("SERVICE_UNIT_MAP");
            parseMap(offer, unitMap, serviceUnitMap);
        }
        if (serviceCode.containsKey("SERVICE_UNIT_ADD_MAP")){
        	VRMap addMap = (VRMap)serviceCode.get("SERVICE_UNIT_ADD_MAP");
        	if (serviceUnitAddRaito == Integer.MIN_VALUE){
        		serviceUnitAddRaito = ACCastUtilities.toInt(addMap.get("SERVICE_UNIT"), 0);
        	}
        	
        	if (addMap.containsKey("SERVICE_UNIT_MAP")){
        		VRMap unitMap = (VRMap)serviceCode.get("SERVICE_UNIT_MAP");
        		parseMap(offer, unitMap, serviceUnitAddMap);
        	}
        }
	}
	
	private void parseMap(String offer, VRMap unitMap, VRMap target) throws Exception {
        Iterator it = unitMap.keySet().iterator();
        String key = "";
        //レコード確定時に一括集計
        while(it.hasNext()){
            key = String.valueOf(it.next());
            VRMap map = null;
            Integer times = null;
            Set<String> offerDay = null;
            
            //登録済みのサービスの場合
            if(target.containsKey(key)){
                map = (VRMap)target.get(key);
                times = (Integer)map.get("TIMES");
                offerDay = (Set)map.get("OFFER");
                
            } else {
                map = new VRHashMap();
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
		int specialUnit = 0;
		
		if (!serviceUnitAddMap.isEmpty()){
			int tmp = getUnitTotal(serviceUnitAddMap);
			specialUnit = (int)Math.round((double)(tmp * serviceUnitAddRaito) / 100d);
		}
		
		return (baseUnit + specialUnit);
	}
	
	private int getUnitTotal(VRMap target) throws Exception {
		int totalUnit = 0;
		
        Iterator it = target.keySet().iterator();
        while(it.hasNext()){
            String key = String.valueOf(it.next());
            //単位数-回数
            VRMap map = (VRMap)target.get(key);
            Integer unit = (Integer)map.get("UNIT");
            Integer times = (Integer)map.get("TIMES");
            totalUnit += unit.intValue() * times.intValue();
        }
        return totalUnit;
	}
	
// 2016/7/21 [Yoichiro Kamei] add - begin 総合事業対応
	/**
	 * 保持しているサービスからkeyに指定したサービスを除外します。
	 * 
	 * keyは以下の結合文字列となります。
	 * "SYSTEM_SERVICE_KIND_DETAIL"-"SYSTEM_SERVICE_CODE_ITEM"-"TOTAL_GROUPING_TYPE"
	 * 総合事業の独自の場合は、
	 * "INSURER_ID-SYSTEM_SERVICE_KIND_DETAIL"-"SYSTEM_SERVICE_CODE_ITEM"-"TOTAL_GROUPING_TYPE"
	 */
	public void removeService(String key) {
		if (!serviceUnitAddMap.isEmpty()){
			serviceUnitAddMap.remove(key);
		}
		if (!serviceUnitMap.isEmpty()){
			serviceUnitMap.remove(key);
		}
	}
// 2016/7/21 [Yoichiro Kamei] add - end

}
