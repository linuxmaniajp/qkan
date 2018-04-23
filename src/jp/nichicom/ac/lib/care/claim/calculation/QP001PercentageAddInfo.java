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
import java.util.Map;
import java.util.Set;

import jp.nichicom.ac.lang.ACCastUtilities;

/**
 * %加減、%減算の対象単位数を保持するクラス（公費対応）
 * 
 * @author Yoichiro Kamei
 *
 */
public class QP001PercentageAddInfo {
	
	public static final String PARCENTAGE_ADD_TARGET_KEY_3 = "PARCENTAGE_ADD_TARGET_3";
	public static final String PARCENTAGE_ADD_TARGET_KEY_3_UNIT = "PARCENTAGE_ADD_TARGET_3_UNIT";
	public static final String PARCENTAGE_ADD_TARGET_KEY_6 = "PARCENTAGE_ADD_TARGET_6";
	public static final String PARCENTAGE_ADD_TARGET_KEY_6_UNIT = "PARCENTAGE_ADD_TARGET_6_UNIT";
	public static final String PARCENTAGE_ADD_TARGET_KEY_5 = "PARCENTAGE_ADD_TARGET_5";
	public static final String PARCENTAGE_ADD_TARGET_KEY_5_UNIT = "PARCENTAGE_ADD_TARGET_5_UNIT";
	public static final String PARCENTAGE_ADD_TARGET_KEY_7 = "PARCENTAGE_ADD_TARGET_7";
	public static final String PARCENTAGE_ADD_TARGET_KEY_7_UNIT = "PARCENTAGE_ADD_TARGET_7_UNIT";
	public static final String PARCENTAGE_ADD_TARGET_KEY_8 = "PARCENTAGE_ADD_TARGET_8";

	// 加算の対象となる基本サービスの単位数
	private int kihonUnit = 0;

	// ％加算のサービスコードをキーに加算の対象となる基本サービスの回数を保持
	// <加算のサービスコード, 基本サービスの回数>
	private Map<String, Integer> kihonCountMap = new HashMap<String, Integer>();

	// 対象となる％加算のサービスコードをキーに<QP001KohiKey, 回数>を保持するマップ
	private Map<String, Map<QP001KohiKey, Integer>> kohiCountMap = new HashMap<String, Map<QP001KohiKey, Integer>>();

	//算定の際に計算に含める関連加算の情報
	// <加算のサービスコード, <加算フラグ, <加算率, 基本サービスの回数>>>
	private Map<String, Map<Integer, Map<Integer, Integer>>> relationMap 
		= new HashMap<String, Map<Integer, Map<Integer, Integer>>>();
	
	//算定の際に計算に含める関連加算の情報（公費分）
	// <加算のサービスコード, <KohiKey, <加算フラグ, <加算率, 基本サービスの回数>>>>
	private Map<String, Map<QP001KohiKey, Map<Integer, Map<Integer, Integer>>>> relationKohiMap 
		= new HashMap<String, Map<QP001KohiKey, Map<Integer, Map<Integer, Integer>>>>();
	
	public static Integer SERVICE_ADD_FLAG_KYOUSEI = new Integer(5);
	public static Integer SERVICE_ADD_FLAG_SAME_BUILDING = new Integer(7);
	public static Integer SERVICE_ADD_FLAG_TOKUCHI = new Integer(3);
	public static Integer SERVICE_ADD_FLAG_CHUSAN = new Integer(6);
	
	/**
	 * コンストラクタ。
	 * 
	 * @param kihonUnit
	 *            加算の対象となる基本サービスの単位数
	 */
	public QP001PercentageAddInfo(int kihonUnit) {
		this.kihonUnit = kihonUnit;
	}
	
	/**
	 * このクラスが保持する加算情報のサービスコードセットを返します。
	 * 
	 * @return このクラスが保持する加算情報のサービスコードセット
	 */
	public Set<String> getHoldSvCodeSet() {
		return kihonCountMap.keySet();
	}
	
	
	//%加算のサービスコードをKEYに加算率を値に保持するマップ
	private Map<String, Integer> perMap = new HashMap<String, Integer>();
	//%加算のサービスコードをKEYに加算フラグを値に保持するマップ
	private Map<String, Integer> addFlgMap = new HashMap<String, Integer>();
	
	/**
	 * 指定したサービスコードを解析して加算情報等を保持します。
	 * 
	 * @param serviceCode
	 *            サービスコード情報
	 * 
	 * @return ％加算のサービス項目コードセット
	 */
	public void parseService(Map serviceCode) {
		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_3)) {
			String svCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_3), "");
			int per = ACCastUtilities.toInt(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_3_UNIT), 0);
			addFlgMap.put(svCode, SERVICE_ADD_FLAG_TOKUCHI);
			perMap.put(svCode, per);
		}
		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_6)) {
			String svCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_6), "");
			int per = ACCastUtilities.toInt(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_6_UNIT), 0);
			addFlgMap.put(svCode, SERVICE_ADD_FLAG_CHUSAN);
			perMap.put(svCode, per);
		}
		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_5)) {
			String svCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_5), "");
			int per = ACCastUtilities.toInt(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_5_UNIT), 0);
			addFlgMap.put(svCode, SERVICE_ADD_FLAG_KYOUSEI);
			perMap.put(svCode, per);
		}
		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_7)) {
			String svCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_7), "");
			int per = ACCastUtilities.toInt(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_7_UNIT), 0);
			addFlgMap.put(svCode, SERVICE_ADD_FLAG_SAME_BUILDING);
			perMap.put(svCode, per);
		}
	}
//	/**
//	 * 指定したサービスコードより％加算のサービスコードセットを生成します。
//	 * 
//	 * @param serviceCode
//	 *            サービスコード情報
//	 * 
//	 * @return ％加算のサービス項目コードセット
//	 */
//	public Set<String> createPercentageAddCodeSet(Map serviceCode) {		
//		Set<String> ret = new HashSet<String>();
//		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_3)) {
//			ret.add((String) serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_3));
//		}
//		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_6)) {
//			ret.add((String) serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_6));
//		}
//		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_5)) {
//			ret.add((String) serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_5));
//		}
//		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_7)) {
//			ret.add((String) serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_7));
//		}
//		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_8)) {
//			ret.add((String) serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_8));
//		}
//		return ret;
//	}
	
	/**
	 * 指定したサービスコードについて、％加算の基本サービスの回数を追加します。
	 * 
	 * @param percentageAddCodeSet
	 *            ％加算のサービスコードセット
	 * @param count
	 *            回数
	 */
	public void addKihonCount(Map serviceCode, int count) {
		//共生型減算
		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_5)) {
			String svCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_5), "");
			addKihonCountMap(svCode, count);
		}
		//同一建物減算
		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_7)) {
			String svCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_7), "");
			addKihonCountMap(svCode, count);
			
			//関連加算の回数追加
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_5)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_5), "");
				addRelationMap(svCode, count, relateSvCode);
			}
		}
		//特地加算
		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_3)) {
			String svCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_3), "");
			addKihonCountMap(svCode, count);
			
			//関連加算の回数追加
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_5)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_5), "");
				addRelationMap(svCode, count, relateSvCode);
			}
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_7)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_7), "");
				addRelationMap(svCode, count, relateSvCode);
			}
		}
		//中山間地域等提供加算
		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_6)) {
			String svCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_6), "");
			addKihonCountMap(svCode, count);
			
			//関連加算の回数追加
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_5)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_5), "");
				addRelationMap(svCode, count, relateSvCode);
			}
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_7)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_7), "");
				addRelationMap(svCode, count, relateSvCode);
			}
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_3)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_3), "");
				addRelationMap(svCode, count, relateSvCode);
			}
		}
		//処遇改善加算
		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_8)) {
			String svCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_8), "");
			addKihonCountMap(svCode, count);
			
			//関連加算の回数追加
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_5)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_5), "");
				addRelationMap(svCode, count, relateSvCode);
			}
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_7)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_7), "");
				addRelationMap(svCode, count, relateSvCode);
			}
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_3)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_3), "");
				addRelationMap(svCode, count, relateSvCode);
			}
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_6)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_6), "");
				addRelationMap(svCode, count, relateSvCode);
			}
		}
	}
	//指定された%加算サービスコードついて基本サービスの回数を追加します。
	private void addKihonCountMap(String svCode, int count) {
		int nowCount = ACCastUtilities.toInt(kihonCountMap.get(svCode), 0);
		kihonCountMap.put(svCode, nowCount + count);
	}
	
	//指定された%加算サービスコードに関連する%加算コードについて、基本サービスの回数を追加します。
	private void addRelationMap(String svCode, int count, String relateSvCode) {
		if (!relationMap.containsKey(svCode)) {
			relationMap.put(svCode, new HashMap<Integer, Map<Integer, Integer>>());
		}
		Map<Integer, Map<Integer, Integer>> flMap = relationMap.get(svCode);
		addFlgMapCount(flMap, relateSvCode, count);
	}
	
	//指定された関連%加算コードについて、flMap<加算フラグ, <加算率, 基本サービスの回数>>の回数を追加します。
	private void addFlgMapCount(Map<Integer, Map<Integer, Integer>> flMap,
			String relateSvCode, int count ) {
		//関連加算コードの加算フラグと加算率を取得
		int addFlg = addFlgMap.get(relateSvCode);
		int per = perMap.get(relateSvCode);
		
		if (!flMap.containsKey(addFlg)) {
			flMap.put(addFlg, new HashMap<Integer, Integer>());
		}
		Map<Integer, Integer> prMap = flMap.get(addFlg);
		int nowCount = ACCastUtilities.toInt(prMap.get(per), 0);
		prMap.put(per, nowCount + count);
	}
	
	
	/**
	 * 指定したサービスコードについて、指定したKohiKeyの回数を追加します。
	 * 
	 * @param serviceCode
	 *            サービスコード
	 * @param kohiKey
	 *            KohiKey
	 * @param count
	 *            回数
	 */
	public void addKohiCount(Map serviceCode, QP001KohiKey kohiKey, int count) {
		//共生型減算
		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_5)) {
			String svCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_5), "");
			addKohiCountMap(svCode, kohiKey, count);
		}
		//同一建物減算
		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_7)) {
			String svCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_7), "");
			addKohiCountMap(svCode, kohiKey, count);
			
			//関連加算の回数追加
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_5)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_5), "");
				addRelationKohiMap(svCode, kohiKey, count, relateSvCode);
			}
		}
		//特地加算
		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_3)) {
			String svCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_3), "");
			addKohiCountMap(svCode, kohiKey, count);
			
			//関連加算の回数追加
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_5)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_5), "");
				addRelationKohiMap(svCode, kohiKey, count, relateSvCode);
			}
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_7)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_7), "");
				addRelationKohiMap(svCode, kohiKey, count, relateSvCode);
			}
		}
		//中山間地域等提供加算
		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_6)) {
			String svCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_6), "");
			addKohiCountMap(svCode, kohiKey, count);
			
			//関連加算の回数追加
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_5)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_5), "");
				addRelationKohiMap(svCode, kohiKey, count, relateSvCode);
			}
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_7)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_7), "");
				addRelationKohiMap(svCode, kohiKey, count, relateSvCode);
			}
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_3)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_3), "");
				addRelationKohiMap(svCode, kohiKey, count, relateSvCode);
			}
		}
		//処遇改善加算
		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_8)) {
			String svCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_8), "");
			addKohiCountMap(svCode, kohiKey, count);
			
			//関連加算の回数追加
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_5)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_5), "");
				addRelationKohiMap(svCode, kohiKey, count, relateSvCode);
			}
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_7)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_7), "");
				addRelationKohiMap(svCode, kohiKey, count, relateSvCode);
			}
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_3)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_3), "");
				addRelationKohiMap(svCode, kohiKey, count, relateSvCode);
			}
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_6)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_6), "");
				addRelationKohiMap(svCode, kohiKey, count, relateSvCode);
			}
		}
	}
	
	//指定した%加算サービスコード、KohiKeyついて、基本サービスの回数を追加します。
	private void addKohiCountMap(String svCode, QP001KohiKey kohiKey, int count) {
		if (!kohiCountMap.containsKey(svCode)) {
			kohiCountMap.put(svCode, new HashMap<QP001KohiKey, Integer>());
		}
		Map<QP001KohiKey, Integer> kohiCountKeyMap = kohiCountMap.get(svCode);
		int nowCount = ACCastUtilities.toInt(kohiCountKeyMap.get(kohiKey), 0);
		kohiCountKeyMap.put(kohiKey, nowCount + count);
	}
	
	//指定された%加算サービスコードに関連する%加算コード、KohiKeyについて、基本サービスの回数を追加します。
	private void addRelationKohiMap(String svCode, QP001KohiKey kohiKey, int count, String relateSvCode) {
		if (!relationKohiMap.containsKey(svCode)) {
			relationKohiMap.put(svCode, new HashMap<QP001KohiKey, Map<Integer, Map<Integer, Integer>>>());
		}
		Map<QP001KohiKey, Map<Integer,Map<Integer,Integer>>> rKohiMap = relationKohiMap.get(svCode);
		if (!rKohiMap.containsKey(kohiKey)) {
			rKohiMap.put(kohiKey, new HashMap<Integer, Map<Integer, Integer>>());
		}
		Map<Integer, Map<Integer, Integer>> flMap = rKohiMap.get(kohiKey);
		addFlgMapCount(flMap, relateSvCode, count);
	}
	
	/**
	 * 指定した％加算のサービスコードが対象とする基本サービスの単位数を取得します。
	 * 
	 * @param svCode
	 *            ％加算のサービスコード
	 * @return 指定した％加算のサービスコードが対象とする基本サービスの単位数
	 */
	public int getKasanBaseUnit(String svCode) {
		int count = ACCastUtilities.toInt(kihonCountMap.get(svCode), 0);
		return count * kihonUnit;
	}

	/**
	 * 指定した％加算のサービスコード、KohiKeyが対象とする基本サービスの公費対象単位数を取得します。
	 * 
	 * @param svCode
	 *            ％加算のサービスコード
	 * @param kohiKey
	 *            QP001KohiKey
	 * 
	 * @return 指定した％加算のサービス項目コード、KohiKeyが対象とする基本サービスの公費対象単位数
	 */
	public int getKasanBaseKohiUnit(String svCode, QP001KohiKey kohiKey) {
		Map<QP001KohiKey, Integer> kohiCountKeyMap = kohiCountMap.get(svCode);
		int count = ACCastUtilities.toInt(kohiCountKeyMap.get(kohiKey), 0);
		return count * kihonUnit;
	}
	
	
	
	//関連加算分
	/**
	 * 指定した％加算のサービスコード、関連加算フラグが対象とする加算率と基本サービスの対象単位数を取得します。
	 * 
	 * @param svCode
	 *            ％加算のサービスコード
	 * @param addFlg
	 *            サービス加算フラグ
	 * 
	 * @return 加算率と基本サービスの対象単位数のマップ
	 */
	public Map<Integer, Integer> getRelateAddUnit(String svCode, int addFlg) {
		Map<Integer, Integer> ret = new HashMap<Integer, Integer>();
		if (!relationMap.containsKey(svCode)) {
			return ret;
		}
		Map<Integer, Map<Integer, Integer>> flMap = relationMap.get(svCode);
		if (!flMap.containsKey(addFlg)) {
			return ret;
		}
		Map<Integer, Integer> prMap = flMap.get(addFlg);
		for (int per : prMap.keySet()) {
			int count = ACCastUtilities.toInt(prMap.get(per), 0);
			//回数×単位数で対象単位数をセット
			ret.put(per, count * kihonUnit);
		}
		return ret;
	}

	/**
	 * 指定したKohiKey、％加算のサービスコード、関連加算フラグが対象とする加算率と基本サービスの対象単位数を取得します。
	 * 
	 * @param kohiKey QP001KohiKey
	 * 
	 * @param svCode
	 *            ％加算のサービスコード
	 * @param addFlg
	 *            サービス加算フラグ
	 * 
	 * @return 加算率と基本サービスの対象単位数のマップ
	 */
	public Map<Integer, Integer> getRelateAddKohiUnit(QP001KohiKey kohiKey, String svCode, int addFlg) {
		Map<Integer, Integer> ret = new HashMap<Integer, Integer>();
		if (!relationKohiMap.containsKey(svCode)) {
			return ret;
		}
		Map<QP001KohiKey, Map<Integer,Map<Integer,Integer>>> rKohiMap = relationKohiMap.get(svCode);
		if (!rKohiMap.containsKey(kohiKey)) {
			return ret;
		}
		Map<Integer, Map<Integer, Integer>> flMap = rKohiMap.get(kohiKey);
		if (!flMap.containsKey(addFlg)) {
			return ret;
		}
		Map<Integer, Integer> prMap = flMap.get(addFlg);
		for (int per : prMap.keySet()) {
			int count = ACCastUtilities.toInt(prMap.get(per), 0);
			//回数×単位数で対象単位数をセット
			ret.put(per, count * kihonUnit);
		}
		return ret;
	}

}
