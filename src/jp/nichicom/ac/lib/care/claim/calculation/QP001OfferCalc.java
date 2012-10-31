/*
 * Project code name "ORCA"
 * 給付管理台帳ソフト QKAACHO（JMA care benefit management software）
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
 * 作成日: 2009/07/24  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 実績確定/請求書出力 (P)
 * プロセス 請求処理 (001)
 * プログラム 利用者一覧（請求） (QP001)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.text.QkanWelfareToolFormat;

/**
 * 
 * 提供日判定クラス
 * [ID:0000435][Shin Fujihara] 2009/07 2009年度対応
 *
 */
public class QP001OfferCalc {

	private Map offer = new TreeMap();
	private Map serviceNameYogu = new VRHashMap();
	
	/**
	 * 提供日の解析を実行する
	 * @param serviceDetail　サービス提供詳細
	 * @param serviceCode　生成したサービスコード
	 * @throws Exception
	 */
	public void analize(VRMap serviceDetail, VRMap serviceCode) throws Exception {
		//提供日
		Date serviceDate = ACCastUtilities.toDate(serviceDetail.get("SERVICE_DATE"), null);
		//サービス種類コード
		String serviceKind = ACCastUtilities.toString(serviceCode.get("SERVICE_CODE_KIND"), null);
		//取得できなければ、処理中断
		if ((serviceDate == null) || (serviceKind == null)) {
			return;
		}
		
		//自動的に展開された日割りデータの場合は、計上しない
		//[ID:0000586][Shin Fujihara] 2010/01 edit begin 2009年度対応
		//if (!QP001SpecialCase.isRealDay(serviceDetail)){
		if (!QP001SpecialCase.isRealDay(serviceDetail, serviceCode)){
		//[ID:0000586][Shin Fujihara] 2010/01 edit end 2009年度対応
			return;
		}
		
		//※外泊を除きたい場合にはCareServiceCommon.isGaihaku(serviceDetail)を使用する
		
		int offerDays = 0;
		StringBuilder key = new StringBuilder(serviceKind);;
		
		//訪問介護例外処理
		if ("11".equals(serviceKind)) {
			//身体介護、生活援助、身体生活、乗降介助に分類する
			key.append(ACCastUtilities.toString(serviceDetail.get("1110101"), ""));
		
		//福祉用具例外処理
		} else if ("17".equals(serviceKind)) {
			//福祉用具は、用具名称表示＋月を通して提供とする
			key.append(ACCastUtilities.toString(serviceCode.get("SERVICE_CODE_ITEM"), ""));
			offerDays = 0xFFFFFFFF;
			
			//用具名称キャッシュ
			serviceNameYogu.put(key.toString(), QkanWelfareToolFormat.getInstance().format(serviceDetail.get("1170101")));
			
		//予防福祉用具例外処理
		} else if ("67".equals(serviceKind)) {
			//福祉用具は、用具名称表示＋月を通して提供とする
			key.append(ACCastUtilities.toString(serviceCode.get("SERVICE_CODE_ITEM"), ""));
			offerDays = 0xFFFFFFFF;
			
			//用具名称キャッシュ
			serviceNameYogu.put(key.toString(), QkanWelfareToolFormat.getInstance().format(serviceDetail.get("1670101")));
		}
		
		if (offerDays == 0) {
			int day = ACDateUtilities.getDayOfMonth(serviceDate);
			offerDays = getOfferDays(key.toString());
			offerDays |= (1 << (day - 1));
		}
		
		offer.put(key.toString(), new Integer(offerDays));
	}
	
	private int getOfferDays(String serviceKind) throws Exception {
		Integer offerDays = new Integer(0);
		if (offer.containsKey(serviceKind)){
			offerDays = (Integer)offer.get(serviceKind);
		}
		return offerDays.intValue();
	}
	
	/**
	 * 登録用のデータに対し、確定したデータを追加する
	 * @param patientClaimMap
	 * @throws Exception
	 */
	public void marge(ACDBManager dbm, Date targetDate, VRMap patientClaimMap) throws Exception {
		
		//サービス名称翻訳取得
		VRMap serviceName = getMasterServiceAbbreviation(dbm, targetDate);
		
		//介護と予防のサービスを提供している（月途中要介護度変更）の場合は
		//介護サービスの名称に寄せる
		String[][] rule = new String[][]{
				{"11","61"},
				{"12","62"},
				{"13","63"},
				{"14","64"},
				{"15","65"},
				{"16","66"},
				{"171001","671001"},
				{"171002","671002"},
				{"171003","671003"},
				{"171004","671004"},
				{"171005","671005"},
				{"171006","671006"},
				{"171007","671007"},
				{"171008","671008"},
				{"171009","671009"},
				{"171010","671010"},
				{"171011","671011"},
				{"171012","671012"},
				{"21","24"},
				{"22","25"},
				{"23","26"},
				{"31","34"},
				{"33","35"},
				{"43","46"},
				{"72","74"},
				{"73","75"},
				{"32","37"},
				{"38","39"}
				};
		
		VRList margedKind = new VRArrayList();
		
		for (int i = 0; i < rule.length; i++) {
			String[] keys = rule[i];
			
			//介護・予防のサービスを受給しているか確認
			if (!offer.containsKey(keys[0])
				|| !offer.containsKey(keys[1])){
				continue;
			}
			
			int kaigo = getOfferDays(keys[0]);
			int yobo = getOfferDays(keys[1]);
			
			kaigo |= yobo;
			offer.put(keys[0], new Integer(kaigo));
			offer.remove(keys[1]);
			
			margedKind.add(keys[0]);
		}
		
		int count = 1;
		int etcDays = 0;
		boolean etcMarged = false;
		
		Iterator it = offer.keySet().iterator();
		while(it.hasNext()) {
			String num = String.valueOf(count);
			String kind = it.next().toString();
			int days = getOfferDays(kind);
			
			//[ID:0000589][Shin Fujihara] 2010/01 edit begin 2009年度対応
			//サービス名称のマスタに登録されていないサービス種類コードの場合は
			//提供日として算定しない。
			//特定入所者介護サービス費等の対応
			if (!serviceName.containsKey(kind)) {
				continue;
			}
			//[ID:0000589][Shin Fujihara] 2010/01 edit begin 2009年度対応
			
			//8個以上サービスを受給している場合は、
			//7つめ以上を「その他」としてまとめる
			if (6 < count){
				num = "7";
				if (etcDays != 0) {
					kind = String.valueOf(Integer.MAX_VALUE);
				}
				if (!etcMarged) {
					etcMarged = margedKind.contains(kind);
				}
				etcDays |= days;
				days = etcDays;
			}
			patientClaimMap.put("MARK" + num + "_SERVICE_DATE_BIT", String.valueOf(days));
			
			if (etcMarged || margedKind.contains(kind)) {
				patientClaimMap.put("MARK" + num + "_SERVICE_NAME", serviceName.get(kind) + "(予防)");
			} else {
				patientClaimMap.put("MARK" + num + "_SERVICE_NAME", serviceName.get(kind));
			}

			count++;
		}
		
		//サービス数が7未満の場合、空白埋め
		for (int i = count; i <= 7; i++) {
			patientClaimMap.put("MARK" + i + "SERVICE_NAME", null);
			patientClaimMap.put("MARK" + i + "_SERVICE_DATE_BIT", null);
		}
	}
	
    /**
     * サービス名（略称）を取得する。
     * @param targetDate サービス提供日付
     * @return VRMap
     */
    private VRMap getMasterServiceAbbreviation(ACDBManager dbm, Date targetDate) throws Exception {
    	VRMap result = new VRHashMap();
    	VRMap master = QkanCommon.getMasterService(dbm, targetDate);
    	Iterator it = master.keySet().iterator();
    	while(it.hasNext()) {
    		VRMap map = (VRMap)master.get(it.next());
    		String key = ACCastUtilities.toString(map.get("SERVICE_CODE_KIND"), "");
    		if (!result.containsKey(key)) {
    			result.put(map.get("SERVICE_CODE_KIND"), map.get("SERVICE_CALENDAR_ABBREVIATION"));
    		}
    	}
    	
    	//サービス名称例外処理対応
    	result.put("13", "訪看");
    	result.put("31", "居宅療養");
    	result.put("63", "予訪看 ");
    	
    	result.put("111", "身体介護");
    	result.put("112", "生活援助");
    	result.put("113", "身体生活");
    	result.put("114", "乗降介助");
    	
    	result.put(String.valueOf(Integer.MAX_VALUE), "その他");
    	
    	it = serviceNameYogu.keySet().iterator();
    	while(it.hasNext()) {
    		String key = it.next().toString();
    		String kind = key.substring(0, 2);
    		result.put(key, result.get(kind) + " " + serviceNameYogu.get(key));
    	}
    	
    	return result;
    }
    
    
    //[ID:0000612][Shin Fujihara] 2010/11 add begin 2010年度対応
    /**
     * 集計結果情報を取得する
     * @return Map
     */
    public VRList getOfferServiceList(ACDBManager dbm, Date targetDate) throws Exception {
    	VRList result = new VRArrayList();
		VRMap serviceName = getMasterServiceAbbreviation(dbm, targetDate);
    	
    	Iterator it = offer.keySet().iterator();
    	lbl:while(it.hasNext()) {
    		String kind = it.next().toString();
			
			//サービス名称のマスタに登録されていないサービス種類コードの場合は提供日として算定しない。
			//特定入所者介護サービス費等の対応
			if (!serviceName.containsKey(kind)) {
				continue;
			}
    		
			int days = getOfferDays(kind);
			
			VRMap map = getSameKindRecord(kind, result);
			
			//取得したmapの中で、提供日データを導入可能な位置を探す
			for (int i = 1; i <= 7; i++) {
				if (map.get("MARK" + i + "_SERVICE_NAME") == null) {
					map.put("MARK" + i + "_SERVICE_NAME", serviceName.get(kind));
					map.put("MARK" + i + "_SERVICE_DATE_BIT", String.valueOf(days));
					continue lbl;
				}
			}
			
			//上記ループでcontinueするので、ここに到達したときは7までデータが充填されている
			//サービス名称をその他に変更
			map.put("MARK7_SERVICE_NAME", serviceName.get(String.valueOf(Integer.MAX_VALUE)));
			//提供日付をマージ
			int etcDays = ACCastUtilities.toInt(map.get("MARK7_SERVICE_DATE_BIT"), 0);
			map.put("MARK7_SERVICE_DATE_BIT", String.valueOf(etcDays | days));
			
    	}
    	
    	return result;
    }
    
    
    private VRMap getSameKindRecord(String kind, VRList list) {
    	VRMap map = null;
    	kind = kind.substring(0, 2);
    	
    	for (int i = 0; i < list.size(); i++) {
    		map = (VRMap)list.get(i);
    		if (kind.equals(ACCastUtilities.toString(map.get("SERVICE_CODE_KIND"), ""))) {
    			return map;
    		}
    	}
    	
    	map = getEmptyRecord();
    	map.put("SERVICE_CODE_KIND", kind);
    	list.add(map);
    	
    	return map;
    }
    
    //CLAIM_PATIENT_DETAILに対応する空レコードを生成する
    private VRMap getEmptyRecord() {
    	VRMap map = new VRHashMap();
    	
    	//自己負担用
    	for (int i = 1; i <= 3; i++) {
    		map.put("SELF_SERVICE_NO" + i, null);
    		map.put("SELF_PAY_NO" + i, null);
    	}
    	
    	//提供日用
		for (int i = 1; i <= 7; i++) {
			map.put("MARK" + i + "_SERVICE_NAME", null);
			map.put("MARK" + i + "_SERVICE_DATE_BIT", null);
		}
    	
    	return map;
    }
    //[ID:0000612][Shin Fujihara] 2010/11 add end 2010年度対応
}
