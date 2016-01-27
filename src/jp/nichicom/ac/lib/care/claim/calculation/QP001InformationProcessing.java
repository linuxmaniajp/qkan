
/*
 * Project code name "ORCA"
 * 給付管理台帳ソフト QKAACHO（JMA care benefit management software）
 * Copyright(C) 2002 JMA (Japan Medical Association)
 *
 * This program is part of "QKAACHO (JMA care benefit management software)".
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
 * 作成日: 2009/07/22  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 実績確定/請求書出力 (P)
 * プロセス 請求処理 (001)
 * プログラム 前回集計結果保持処理 (QP001InformationHold)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Date;
import java.util.Iterator;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACSQLSafeStringFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanSystemInformation;

public class QP001InformationProcessing {
	
	/**
	 * 下記二件の案件に対応するため、クラスを追加
	 * [ID:0000434][Shin Fujihara] 2009/07 add begin 2009年度対応
	 * [ID:0000491][Shin Fujihara] 2009/07 add begin 2009年度対応
	 */
	
	private VRList claim = null;
	
	private ACDBManager dbm = null;
	private QP001PatientState patient = null;
	
	private VRMap diagnosisQueue = new VRHashMap();
	private VRList detailsDivision = new VRArrayList();
	private VRList serviceKindListLastMonth = new VRArrayList();
	private VRList serviceKindListThisMonth = new VRArrayList();
	
	/**
	 * 代入条件　空白以外
	 */
	private final int NOT_EMPTY = 1;
	/**
	 * 代入条件　ゼロ以外
	 */
	private final int NOT_ZERO = 2;
	
	/**
	 * コンストラクタで、再集計前のデータを退避しておく
	 */
	public QP001InformationProcessing(ACDBManager dbm, QP001PatientState patient, Date targetDate) throws Exception {
		
        this.patient = patient;
        this.dbm = dbm;
		
        // 請求詳細情報を取得し、VRArrayList claimList に格納する。
        StringBuilder sb = new StringBuilder();
        
        //請求月を取得
        sb.append(" SELECT");
        sb.append(" DISTINCT");
        sb.append(" CLAIM_DATE");
        sb.append(" FROM");
        sb.append(" CLAIM");
        sb.append(" WHERE");
        sb.append(" (CLAIM.PATIENT_ID = " + patient.getPatientId() + ")");
        sb.append(" AND (CLAIM.TARGET_DATE = '" + VRDateParser.format(targetDate,"yyyy/MM/dd") + "')");
        sb.append(" AND (CLAIM.PROVIDER_ID = '" + QkanSystemInformation.getInstance().getLoginProviderID() + "')");
        sb.append(" ORDER BY CLAIM.LAST_TIME DESC");
        
        VRList list = dbm.executeQuery(sb.toString());
        
        if((list == null) || (list.size() == 0)){
        	return;
        }
        
        Date claimDate = ACCastUtilities.toDate(((VRMap)list.get(0)).get("CLAIM_DATE"),null);
        
        if(claimDate == null){
        	return;
        }
        
        sb = new StringBuilder();
        
        sb.append(" AND(CLAIM.TARGET_DATE = '" + VRDateParser.format(targetDate,"yyyy/MM/dd") + "')");
        sb.append(" AND(CLAIM.PATIENT_ID = " + patient.getPatientId() + ")");
        sb.append(" AND(CLAIM.PROVIDER_ID = '" + QkanSystemInformation.getInstance().getLoginProviderID() + "')");
        sb.append(" AND (CLAIM.CATEGORY_NO IN (2,3,5,7))");
        
        //請求情報を退避
        claim = QkanCommon.getClaimDetailCustom(dbm, claimDate, sb.toString());
	}
	
	/**
	 * 集計結果に、再集計前の結果を反映させる。
	 * @param updateList
	 * @throws Exception
	 */
	public void reflect(VRList updateList) throws Exception {
		if (updateList == null) {
			return;
		}
		
		//先月提供したサービス種類コードを退避
		setServiceKind(patient.claim, serviceKindListLastMonth);
		//今月提供したサービス種類コードを退避
		setServiceKind(updateList, serviceKindListThisMonth);
		
		for (int i = 0; i < updateList.size(); i++){
			VRMap map = (VRMap)updateList.get(i);
			reflectStyle(map);
		}
		
		//傷病名コピー例外処理
		Iterator it = diagnosisQueue.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next().toString();
			if (key.endsWith("99")) {
				if (diagnosisQueue.containsKey(key.substring(0, key.length() - 3) + "-1")) {
					continue;
				}
			}
			// コピー処理
			setInvalidName((VRMap)diagnosisQueue.get(key));
		}
		
		if (detailsDivision.size() > 0) {
			updateList.addAll(detailsDivision);
		}
	}
	
	private void setServiceKind(VRList targetList, VRList serviceKindList) throws Exception {
		
		if ((targetList == null) || (targetList.size() == 0)) {
			return;
		}
		
		for (int i = 0; i < targetList.size(); i++) {
    		VRMap map = (VRMap)targetList.get(i);
    		
    		//レコード種別が3(明細情報)以外のレコードは読み飛ばす
    		if(ACCastUtilities.toInt(map.get("CATEGORY_NO"),0) != 3){
    			continue;
    		}
    		
    		String serviceCoceKind = ACCastUtilities.toString(map.get("301007"), "");
    		
    		if (!serviceKindList.contains(serviceCoceKind)) {
    			serviceKindList.add(serviceCoceKind);
    		}
		}
	}
	
	/**
	 * 提供回数が99回を超える場合、レコードを分割する
	 * @param map
	 * @throws Exception
	 */
	private void reflectDetails(VRMap map) throws Exception {
		//日数、回数を確認
		int count = ACCastUtilities.toInt(map.get("301010"), 0);
		if (count <= 99){
			return;
		}
		
		int kohi1 = ACCastUtilities.toInt(map.get("301011"), 0);
		int kohi2 = ACCastUtilities.toInt(map.get("301012"), 0);
		int kohi3 = ACCastUtilities.toInt(map.get("301013"), 0);
		
		int[] counts = new int[]{count, kohi1, kohi2, kohi3};
		
		//自分自身のレコードを更新
		//日数、回数
		map.put("301010", stealCount(counts, 0));
		//公費１
		map.put("301011", stealCount(counts, 1));
		//公費２
		map.put("301012", stealCount(counts, 2));
		//公費３
		map.put("301013", stealCount(counts, 3));
		reCalcDetails(map);
		
		while(true){
			VRMap split = copyDetails(map);
			
			//日数、回数
			split.put("301010", stealCount(counts, 0));
			//公費１
			split.put("301011", stealCount(counts, 1));
			//公費２
			split.put("301012", stealCount(counts, 2));
			//公費３
			split.put("301013", stealCount(counts, 3));
			reCalcDetails(split);
			
			detailsDivision.add(split);
			if (counts[0] <= 0) {
				break;
			}
		}
	}
	
	private String stealCount(int[] counts, int index) throws Exception {
		String result = "";
		int target = counts[index];
		if (target < 99) {
			result = String.valueOf(counts[index]);
			counts[index] = 0;
		} else {
			result = "99";
			counts[index] -= 99;
		}
		return result;
	}
	
	private void reCalcDetails(VRMap map) throws Exception {
		
		int _301009 = ACCastUtilities.toInt(map.get("301009"), 0);
		
		//サービス単位数 = 単位数 * 回数
		map.put("301014", 
				String.valueOf(
				_301009 * ACCastUtilities.toInt(map.get("301010"), 0)));
		
		//公費１対象サービス単位数 = 単位数 * 公費１日数・回数
		map.put("301015", 
				String.valueOf(
				_301009 * ACCastUtilities.toInt(map.get("301011"), 0)));
		
		//公費２対象サービス単位数 = 単位数 * 公費２日数・回数
		map.put("301016", 
				String.valueOf(
				_301009 * ACCastUtilities.toInt(map.get("301012"), 0)));
		
		//公費３対象サービス単位数 = 単位数 * 公費３日数・回数
		map.put("301017", 
				String.valueOf(
				_301009 * ACCastUtilities.toInt(map.get("301013"), 0)));
	}
	
	private VRMap copyDetails(VRMap map) throws Exception {
		VRMap result = new VRHashMap();
		
		Iterator it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next().toString();
			result.put(key, map.get(key));
		}
		
		return result;
	}
	
	
	/**
	 * 様式第二(基本情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect2base(VRMap map) throws Exception {
		
		//開始年月日
		//異動情報が設定されていない場合
		if (ACTextUtilities.isNullText(map.get("201021"))) {
			//小規模多機能、複合型の場合
			if (isSyokiboTakinou()){
				
				//前回集計中止年月日取得
				Object _201022 = patient.getLastDataCategory2(String.valueOf(map.get("201001")), "201022");
				//前回の中止年月日が設定されていない場合
				if (ACTextUtilities.isNullText(_201022)) {
					//集計前、開始日が設定されていない場合
					//前回集計結果から、開始年月日を設定する
					Object _201021 = patient.getLastDataCategory2(String.valueOf(map.get("201001")), "201021");
					if (!ACTextUtilities.isNullText(_201021)) {
						map.put("201021", _201021);
					} else {
						//集計前のデータが設定できれば、設定する
						setSameBase(map,"201021");
					}
				}
			} else { 
				//集計前のデータが設定できれば、設定する
				setSameBase(map,"201021");
			}
		}
		
		//中止年月日
		if (ACTextUtilities.isNullText(map.get("201022"))) {
			setSameBase(map,"201022");
		}
		
		//中止理由コード
		if (ACCastUtilities.toInt(map.get("201023"), 0) == 0) {
			setSameBase(map,"201023", NOT_ZERO);
		}
	}
	
	/**
	 * 様式第二(明細情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect2details(VRMap map) throws Exception {
		
		// [H27.4改正対応][Shinobu Hitaka] 2015/2/27 edit - begin 廃止＆追加コード対応
		/*
		int serviceCode = getServiceCode(map);
		boolean changed = false;
		
		//集計保持機能
		switch(serviceCode) {
		//短期集中リハビリテーション加算
		case 145001:
		case 145002:
		//通所リハビリテーション
		case 165602:
		case 165603:
		case 165604:
		//[CCCX:1616,2096][Shinobu Hitaka] 2014/11/25 add 「16 5610：通所リハ重度療養管理加算」を追加
		case 165610:
		//小規模多機能　事業所開始時加算
		case 736139:
		case 736140:
			changed = setSameDetails(map);
			break;
		}
		*/
		
		String serviceCode = getServiceCode(map);
		boolean changed = false;
		
		//集計保持機能
		//訪問リハ          145001:廃止　145002:廃止　145003:短期集中リハ加算
		//通所リハ          165602:廃止　165603:廃止　165604:廃止
		//                  165610:重度療養管理加算 　165613:短期集中個別リハ加算（追加）
		//短期入所生活介護  216116:医療連携強化加算
		//小規模多機能      736139:廃止　736140:廃止
		//複合型サービス    776139:事業開始時支援加算
		if ("145003".equals(serviceCode)
			|| "165610".equals(serviceCode) || "165613".equals(serviceCode)
			|| "216116".equals(serviceCode) || "776139".equals(serviceCode)
			) {
			changed = setSameDetails(map);
		}
		// [H27.4改正対応][Shinobu Hitaka] 2015/2/27 edit - end

		if (changed) {
			return;
		}
		
		//前月読み込み機能
		/*
		14 5002のサービスが存在しており、かつ前月のデータに 14 5001がある場合は14 5001 の摘要欄のデータを設定。
		■訪問リハ
		14 5001 訪問リハ短期集中加算１⇒14 5002 訪問リハ短期集中加算２

		訪問リハの場合と振り替えの方針は同様
		■通所リハ
		16 5602 通所リハ短期集中リハ加算１⇒16 5603 通所リハ短期集中リハ加算２
		*/
		
		// [H27.4改正対応][Shinobu Hitaka] 2015/2/27 edit - begin 廃止によりコメント化
		/*
		Object _301018 = null;
		
		switch(serviceCode) {
		//短期集中リハビリテーション加算
		case 145002:
			_301018 = patient.getLastRecapitulationCategory3("145001");
			break;
		//通所リハビリテーション
		case 165603:
			_301018 = patient.getLastRecapitulationCategory3("165602");
			break;
		}
		
		if (!ACTextUtilities.isNullText(_301018)){
			map.put("301018", _301018);
		}
		*/
		// [H27.4改正対応][Shinobu Hitaka] 2015/1/27 edit - end
	}
	
	/**
	 * 様式第二の二(基本情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect22base(VRMap map) throws Exception {
		//開始年月日
		//異動情報が設定されていない場合
		if (ACTextUtilities.isNullText(map.get("201021"))) {
			//小規模多機能の場合
			if (isSyokiboTakinouYobou()){
				
				//前回集計中止年月日取得
				Object _201022 = patient.getLastDataCategory2(String.valueOf(map.get("201001")), "201022");
				//前回の中止年月日が設定されていない場合
				if (ACTextUtilities.isNullText(_201022)) {
					//集計前、開始日が設定されていない場合
					//前回集計結果から、開始年月日を設定する
					Object _201021 = patient.getLastDataCategory2(String.valueOf(map.get("201001")), "201021");
					if (!ACTextUtilities.isNullText(_201021)) {
						map.put("201021", _201021);
					} else {
						//集計前のデータが設定できれば、設定する
						setSameBase(map,"201021");
					}
				}
			} else {
				//集計前のデータが設定できれば、設定する
				setSameBase(map,"201021");
			}
		}
		
		//中止年月日
		if (ACTextUtilities.isNullText(map.get("201022"))) {
			setSameBase(map,"201022");
		}
		
		//中止理由コード
		if (ACCastUtilities.toInt(map.get("201023"), 0) == 0) {
			setSameBase(map,"201023", NOT_ZERO);
		}
	}
	
	/**
	 * 様式第二の二(明細情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect22details(VRMap map) throws Exception {
		// [H27.4改正対応][Shinobu Hitaka] 2015/1/20 edit - begin サービスコード英数化
		/*
		switch(getServiceCode(map)) {
		//短期集中リハビリテーション加算
		case 645001:
		//小規模多機能　事業所開始時加算
		case 756139:
		case 756140:
			setSameDetails(map);
			break;
		}
		*/
		//集計保持機能
		//訪問リハ　　　645001:短期集中リハ加算
		//小規模多機能　756139:廃止　756140:廃止
		String serviceCode = getServiceCode(map);
		if ("645001".equals(serviceCode)) {
			setSameDetails(map);
		}
		// [H27.4改正対応][Shinobu Hitaka] 2015/1/20 edit - end
	}
	
	/**
	 * 様式第三(基本情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect3base(VRMap map) throws Exception {
		//nothing
	}
	
	/**
	 * 様式第三(明細情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect3details(VRMap map) throws Exception {
		//多床室
		setMultiRoom(map);
		
		// [H27.4改正対応][Shinobu Hitaka] 2015/3/19 add - begin 
		//集計保持機能
		//短期生活　　　216116:医療連携強化加算
		String serviceCode = getServiceCode(map);
		if ("216116".equals(serviceCode)) {
			setSameDetails(map);
		}
		// [H27.4改正対応][Shinobu Hitaka] 2015/3/19 add - end
	}
	
	/**
	 * 様式第三の二(基本情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect32base(VRMap map) throws Exception {
		//nothing
	}
	
	/**
	 * 様式第三の二(明細情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect32details(VRMap map) throws Exception {
		//多床室
		setMultiRoom(map);
	}
	
	/**
	 * 様式第四(基本情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect4base(VRMap map) throws Exception {
		//nothing
	}
	
	/**
	 * 様式第四(特定診療費情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect4diagnosis(VRMap map) throws Exception {
		setSameDiagnosis(map);
	}
	
	/**
	 * 様式第四(明細情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect4details(VRMap map) throws Exception {
		//多床室
		setMultiRoom(map);
		
		// [H27.4改正対応][Shinobu Hitaka] 2015/1/20 edit - begin サービスコード英数化
		/*
		//[CCCX:1616,2096][Shinobu Hitaka] 2014/12/11 add begin「22 6278，22 6278：短期入所療養介護（老健）の重度療養管理加算１，２」を追加
		switch(getServiceCode(map)) {
		case 226278:
		case 226279:
			setSameDetails(map);
			break;
		}
		//[CCCX:1616,2096][Shinobu Hitaka] 2014/12/11 add end  「22 6278，22 6278：短期入所療養介護（老健）の重度療養管理加算１，２」を追加
		*/
		String serviceCode = getServiceCode(map);
		
		//集計保持機能
		//短期入所療養介護（老健）　226278:重度療養管理加算１　226279:重度療養管理加算２
		if ("226278".equals(serviceCode) || "226279".equals(serviceCode)) {
			setSameDetails(map);
		}
		// [H27.4改正対応][Shinobu Hitaka] 2015/1/20 edit - end

	}
	
	/**
	 * 様式第四の二(基本情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect42base(VRMap map) throws Exception {
		//nothing
	}
	
	/**
	 * 様式第四の二(特定診療費情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect42diagnosis(VRMap map) throws Exception {
		setSameDiagnosis(map);
	}
	
	/**
	 * 様式第四の二(明細情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect42details(VRMap map) throws Exception {
		//多床室
		setMultiRoom(map);
	}
	
	/**
	 * 様式第五(基本情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect5base(VRMap map) throws Exception {
		//nothing
	}
	
	/**
	 * 様式第五(特定診療費情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect5diagnosis(VRMap map) throws Exception {
		setSameDiagnosis(map);
	}
	
	/**
	 * 様式第五(明細情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect5details(VRMap map) throws Exception {
		//多床室
		setMultiRoom(map);
	}
	
	/**
	 * 様式第五の二(基本情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect52base(VRMap map) throws Exception {
		//nothing
	}
	
	/**
	 * 様式第五の二(特定診療費情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect52diagnosis(VRMap map) throws Exception {
		setSameDiagnosis(map);
	}
	
	/**
	 * 様式第五の二(明細情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect52details(VRMap map) throws Exception {
		//多床室
		setMultiRoom(map);
	}
	
	/**
	 * 様式第六(基本情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect6base(VRMap map) throws Exception {
		reflectBaseCommon(map);
	}
	
	/**
	 * 様式第六(特定診療費情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect6diagnosis(VRMap map) throws Exception {
		setSameDiagnosis(map);
	}
	
	/**
	 * 様式第六(明細情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect6details(VRMap map) throws Exception {
		//nothing
	}
	
	/**
	 * 様式第六の二(基本情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect62base(VRMap map) throws Exception {
		reflectBaseCommon(map);
	}
	
	/**
	 * 様式第六の二(特定診療費情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect62diagnosis(VRMap map) throws Exception {
		setSameDiagnosis(map);
	}
	
	/**
	 * 様式第六の二(明細情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect62details(VRMap map) throws Exception {
		//nothing
	}
	
	/**
	 * 様式第六の三(基本情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect63base(VRMap map) throws Exception {
		reflectBaseCommon(map);
	}
	
	/**
	 * 様式第六の三(特定診療費情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect63diagnosis(VRMap map) throws Exception {
		setSameDiagnosis(map);
	}
	
	/**
	 * 様式第六の三(明細情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect63details(VRMap map) throws Exception {
		//nothing
	}
	
	/**
	 * 様式第六の四(基本情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect64base(VRMap map) throws Exception {
		reflectBaseCommon(map);
	}
	
	/**
	 * 様式第六の四(特定診療費情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect64diagnosis(VRMap map) throws Exception {
		setSameDiagnosis(map);
	}
	
	/**
	 * 様式第六の四(明細情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect64details(VRMap map) throws Exception {
		//nothing
	}
	
	/**
	 * 様式第六の五(基本情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect65base(VRMap map) throws Exception {
		//nothing
	}
	
	/**
	 * 様式第六の五(特定診療費情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect65diagnosis(VRMap map) throws Exception {
		setSameDiagnosis(map);
	}
	
	/**
	 * 様式第六の五(明細情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect65details(VRMap map) throws Exception {
		//nothing
	}
	
	/**
	 * 様式第六の六(基本情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect66base(VRMap map) throws Exception {
		//nothing
	}
	
	/**
	 * 様式第六の六(特定診療費情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect66diagnosis(VRMap map) throws Exception {
		setSameDiagnosis(map);
	}
	
	/**
	 * 様式第六の六(明細情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect66details(VRMap map) throws Exception {
		//nothing
	}

	   /**
     * 様式第六の七(基本情報)の結果反映処理
     * @param map
     * @throws Exception
     */
    private void reflect67base(VRMap map) throws Exception {
        //nothing
    }
    
    /**
     * 様式第六の七(特定診療費情報)の結果反映処理
     * @param map
     * @throws Exception
     */
    private void reflect67diagnosis(VRMap map) throws Exception {
        setSameDiagnosis(map);
    }
    
    /**
     * 様式第六の七(明細情報)の結果反映処理
     * @param map
     * @throws Exception
     */
    private void reflect67details(VRMap map) throws Exception {
        //nothing
    }

	
	/**
	 * 様式第八(基本情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect8base(VRMap map) throws Exception {
		reflectBaseCommon(map);
	}
	
	/**
	 * 様式第八(特定診療費情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect8diagnosis(VRMap map) throws Exception {
		setSameDiagnosis(map);
	}
	
	/**
	 * 様式第八(明細情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect8details(VRMap map) throws Exception {
		//多床室
		setMultiRoom(map);
	}
	
	/**
	 * 様式第九(基本情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect9base(VRMap map) throws Exception {
		reflectBaseCommon(map);
	}
	
	/**
	 * 様式第九(特定診療費情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect9diagnosis(VRMap map) throws Exception {
        setSameDiagnosis(map);
	}
	
	/**
	 * 様式第九(明細情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect9details(VRMap map) throws Exception {
		//多床室
		if (setMultiRoom(map)){
			return;
		}
		
		// [H27.4改正対応][Shinobu Hitaka] 2015/1/20 edit - begin サービスコード英数化
		/*
		switch(getServiceCode(map)) {
		//短期集中リハビリテーション実施加算
		case 526252:
		//認知症短期集中リハビリテーション実施加算
		case 526253:
			setSameDetails(map);
			break;
		}
		*/
		String serviceCode = getServiceCode(map);
		
		//集計保持機能
		//老健　526252:短期集中リハビリテーション実施加算　526253:認知症短期集中リハビリテーション実施加算
		if ("526252".equals(serviceCode) || "526253".equals(serviceCode)) {
			setSameDetails(map);
		}
		// [H27.4改正対応][Shinobu Hitaka] 2015/1/20 edit - end
	}

	/**
	 * 様式第十(基本情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect10base(VRMap map) throws Exception {
		reflectBaseCommon(map);
	}
	
	/**
	 * 様式第十(特定診療費情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect10diagnosis(VRMap map) throws Exception {
		setSameDiagnosis(map);
	}
	
	/**
	 * 様式第十(明細情報)の結果反映処理
	 * @param map
	 * @throws Exception
	 */
	private void reflect10details(VRMap map) throws Exception {
		setMultiRoom(map);
	}
	
	/**
	 * 基本情報レコード　コピー処理
	 * @param map
	 * @param key
	 * @return
	 * @throws Exception
	 */
	private boolean setSameBase(VRMap map, String key) throws Exception {
		return setSameBase(map, key, NOT_EMPTY);
	}
	
	/**
	 * 基本情報反映共通処理
	 * @param map
	 * @throws Exception
	 */
	private void reflectBaseCommon(VRMap map) throws Exception {
		
		//中止理由コード
		if (ACCastUtilities.toInt(map.get("201023"), 0) == 0) {
			setSameBase(map,"201023", NOT_ZERO);
		}

		//退所(院)後の状態コード
		if (ACCastUtilities.toInt(map.get("201028"), 0) == 0) {
			setSameBase(map,"201028", NOT_ZERO);
		}
	}
	
	
	/**
	 * 基本情報レコード　コピー処理
	 * @param map
	 * @param key
	 * @param conditions
	 * @return
	 * @throws Exception
	 */
	private boolean setSameBase(VRMap map, String key, int conditions) throws Exception {
		
		if (claim == null) {
			return false;
		}
		//登録しようとする値が空白であれば、処理を行わない			
		if (isValueExist(map, key, conditions)) {
			return false;
		}
		
		for (int i = 0; i < claim.size(); i++) {
			VRMap tmp = (VRMap)claim.get(i);
			
			if (!tmp.containsKey(key)){
				continue;
			}
			
			//201001 交換情報識別番号4桁
			if (!isEquals(map,tmp,"201001")) {
				continue;
			}
			//201002 レコード種別コード2桁(01を設定)
			if (!isEquals(map,tmp,"201002")) {
				continue;
			}
			//201003 サービス提供年月6桁(YYYYMM)
			if (!isEquals(map,tmp,"201003")) {
				continue;
			}
			//201004 事業所番号10桁
			if (!isEquals(map,tmp,"201004")) {
				continue;
			}
			//201005 証記載保険者番号8桁
			if (!isEquals(map,tmp,"201005")) {
				continue;
			}
			//201006 被保険者番号10桁
			if (!isEquals(map,tmp,"201006")) {
				continue;
			}
			
			//登録しようとする値が空白であれば、処理を行わない			
			if (isValueEmpty(tmp, key, conditions)) {
				return false;
			}
			
			map.put(key, tmp.get(key));
			return true;
		}
		return false;
	}
	
	/**
	 * 多床室設定処理
	 * @param map
	 * @throws Exception
	 */
	private boolean setMultiRoom(VRMap map) throws Exception {
		ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
		
		String kind = ACCastUtilities.toString(map.get("301021"), "");
		String item = ACCastUtilities.toString(map.get("301022"), "");
		Date targetDate = ACCastUtilities.toDate(map.get("301003") + "01");
		
	    StringBuilder sb = new StringBuilder();

	    sb.append("SELECT");
	    sb.append(" CODE_ID");
	    sb.append(" FROM");
	    sb.append(" M_SERVICE_CODE");
	    sb.append(" WHERE");
	    sb.append("(");
	    sb.append(" SYSTEM_SERVICE_KIND_DETAIL");
	    sb.append(" =");
	    sb.append(ACSQLSafeStringFormat.getInstance().format(kind));
	    sb.append(")");
	    sb.append("AND");
	    sb.append("(");
	    sb.append(" SYSTEM_SERVICE_CODE_ITEM");
	    sb.append(" =");
	    sb.append(ACSQLSafeStringFormat.getInstance().format(item));
	    sb.append(")");
	    sb.append("AND");
	    sb.append("(");
	    sb.append(" SERVICE_VALID_START");
	    sb.append(" <=");
	    sb.append(dateFormat.format(targetDate, "yyyy-MM-dd"));
	    sb.append(")");
	    sb.append("AND");
	    sb.append("(");
	    sb.append(" SERVICE_VALID_END");
	    sb.append(" >=");
	    sb.append(dateFormat.format(targetDate, "yyyy-MM-dd"));
	    sb.append(")");
	    
	    VRList list = dbm.executeQuery(sb.toString());
		
		if ((list != null) && (list.size() > 0)){
			VRMap service = (VRMap)list.get(0);
			//多床室サービスの場合
			switch(ACCastUtilities.toInt(service.get("CODE_ID"), 0)){
			case 197:
			case 243:
				setSameDetails(map);
				return true;
			}
			
		}
		return false;
	}
	
	/**
	 * 特定診療費、特別療養費レコード　コピー処理
	 * @param map
	 * @return
	 * @throws Exception
	 */
	private boolean setSameDiagnosis(VRMap map) throws Exception {
		//追加仕様なのでここで・・・
		//傷病名を退避しておく
		setInvalidNameQueue(map);
		
        switch(ACCastUtilities.toInt(map.get("501009"),0)) {
        //重度療養管理
        case 35:
        //短期集中リハビリ加算
        case 52:
        	return setSameDiagnosis(map, "501023");
        }
		//摘要欄を指定
		return false;
	}
	
	/**
	 * 特定診療費、特別療養費レコード　コピー処理
	 * @param map
	 * @param key
	 * @return
	 * @throws Exception
	 */
	private boolean setSameDiagnosis(VRMap map, String key) throws Exception {
		return setSameDiagnosis(map, key, NOT_EMPTY);
	}
	

	private boolean setSameDiagnosis(VRMap map, String key, int conditions) throws Exception {
		
		if (claim == null) {
			return false;
		}
		
		//既に実績集計で結果が登録されている場合は、処理を行わない
		/* 仕様変更に伴い、当月の実績集計結果を強制的に反映する
		if (isValueExist(map, key, conditions)){
			return false;
		}
		*/
		
		for (int i = 0; i < claim.size(); i++) {
			VRMap tmp = (VRMap)claim.get(i);
			
			if (!tmp.containsKey(key)){
				continue;
			}
			
			//501001 交換情報識別番号4桁
			if (!isEquals(map,tmp,"501001")) {
				continue;
			}
			//501002 レコード種別コード2桁(04を設定)
			if (!isEquals(map,tmp,"501002")) {
				continue;
			}
			//501003 サービス提供年月6桁(YYYYMM)
			if (!isEquals(map,tmp,"501003")) {
				continue;
			}
			//501004 事業所番号10桁
			if (!isEquals(map,tmp,"501004")) {
				continue;
			}
			//501005 証記載保険者番号8桁
			if (!isEquals(map,tmp,"501005")) {
				continue;
			}
			//501006 被保険者番号10桁
			if (!isEquals(map,tmp,"501006")) {
				continue;
			}
			//501009 識別番号2桁　特定診療費の識別番号
			if (!isEquals(map,tmp,"501009")) {
				continue;
			}
			//登録しようとする値が空白であれば、処理を行わない
			/* 仕様変更に伴い、当月の実績集計結果を強制的に反映する
			if (isValueEmpty(tmp, key, conditions)) {
				return false;
			}
			*/
			
			//集計前のデータを反映
			map.put(key, tmp.get(key));
			return true;
		}
		return false;

	}
	
	/**
	 * 傷病名コピー処理
	 * @param map
	 * @throws Exception
	 */
	private void setInvalidNameQueue(VRMap map) throws Exception {
		String num = ACCastUtilities.toString(map.get("501007"), "");
		
		if ("1".equals(num) || "99".equals(num)) {
			//傷病名コピー処理のキューに入れる
			StringBuilder key = new StringBuilder();
			key.append(map.get("501001"));
			key.append(map.get("501002"));
			key.append(map.get("501003"));
			key.append(map.get("501004"));
			key.append(map.get("501005"));
			key.append(map.get("501006"));
			key.append("-");
			key.append(map.get("501007"));
			diagnosisQueue.put(key.toString(), map);
		}
	}
	
	/**
	 * 傷病名コピー処理
	 * @param map
	 * @throws Exception
	 */
	private void setInvalidName(VRMap map) throws Exception {
		
		if (claim == null) {
			return;
		}
		
		//既に前月の傷病名が設定されている場合は、前月データを優先する	
		/* 仕様変更に伴い、当月の実績集計結果を強制的に反映する
		if (!isValueEmpty(map, "501008", NOT_EMPTY)) {
			return;
		}
		*/
		
		for (int i = 0; i < claim.size(); i++) {
			VRMap tmp = (VRMap)claim.get(i);
			
			if (!tmp.containsKey("501008")){
				continue;
			}
			
			String invalidName = ACCastUtilities.toString(tmp.get("501008"), "");
			if (ACTextUtilities.isNullText(invalidName)){
				continue;
			}
			
			//501001 交換情報識別番号4桁
			if (!isEquals(map,tmp,"501001")) {
				continue;
			}
			//501002 レコード種別コード2桁(02を設定)
			if (!isEquals(map,tmp,"501002")) {
				continue;
			}
			//501003 サービス提供年月6桁(YYYYMM)
			if (!isEquals(map,tmp,"501003")) {
				continue;
			}
			//501004 事業所番号10桁
			if (!isEquals(map,tmp,"501004")) {
				continue;
			}
			//501005 証記載保険者番号8桁
			if (!isEquals(map,tmp,"501005")) {
				continue;
			}
			//501006 被保険者番号10桁
			if (!isEquals(map,tmp,"501006")) {
				continue;
			}
			
			//登録しようとする値が空白であれば、処理を行わない
			/* 仕様変更に伴い、当月の実績集計結果を強制的に反映する
			if (isValueEmpty(tmp, "501008", NOT_EMPTY)) {
				return;
			}
			*/
			
			map.put("501008", invalidName);
			
			break;
		}
	}
	
	
	/**
	 * 明細情報レコード　コピー処理
	 * @param map
	 * @return
	 * @throws Exception
	 */
	private boolean setSameDetails(VRMap map) throws Exception {
		//摘要欄を指定
		return setSameDetails(map, "301018");
	}
	
	/**
	 * 明細情報レコード　コピー処理
	 * @param map
	 * @param key
	 * @return
	 * @throws Exception
	 */
	private boolean setSameDetails(VRMap map, String key) throws Exception {
		return setSameDetails(map, key, NOT_EMPTY);
	}
	
	/**
	 * 明細情報レコード　コピー処理
	 * @param map
	 * @param key
	 * @param conditions
	 * @return
	 * @throws Exception
	 */
	private boolean setSameDetails(VRMap map, String key, int conditions) throws Exception {
		
		if (claim == null) {
			return false;
		}
		
		/* 仕様変更に伴い、強制的に前回集計の値を採用
		if (isValueExist(map, key, conditions)){
			return false;
		}
		*/
		
		for (int i = 0; i < claim.size(); i++) {
			VRMap tmp = (VRMap)claim.get(i);
			
			if (!tmp.containsKey(key)){
				continue;
			}
			
			//301001 交換情報識別番号4桁
			if (!isEquals(map,tmp,"301001")) {
				continue;
			}
			//301002 レコード種別コード2桁(02を設定)
			if (!isEquals(map,tmp,"301002")) {
				continue;
			}
			//301003 サービス提供年月6桁(YYYYMM)
			if (!isEquals(map,tmp,"301003")) {
				continue;
			}
			//301004 事業所番号10桁
			if (!isEquals(map,tmp,"301004")) {
				continue;
			}
			//301005 証記載保険者番号8桁
			if (!isEquals(map,tmp,"301005")) {
				continue;
			}
			//301006 被保険者番号10桁
			if (!isEquals(map,tmp,"301006")) {
				continue;
			}
			//301007 サービス種類コード2桁
			if (!isEquals(map,tmp,"301007")) {
				continue;
			}
			//301008 サービス項目コード4桁
			if (!isEquals(map,tmp,"301008")) {
				continue;
			}
			//登録しようとする値が空白であれば、処理を行わない
			/* 仕様変更に伴い、強制的に前回集計の値を採用
			if (isValueEmpty(tmp, key, conditions)) {
				return false;
			}
			*/
			
			//集計前のデータを反映
			map.put(key, tmp.get(key));
			return true;
		}
		return false;
	}
	
	private boolean isEquals(VRMap map, VRMap tmp, String key) throws Exception {
		return isEquals(map, tmp, key, key);
	}
	
	private boolean isEquals(VRMap map, VRMap tmp, String mapkey, String tmpkey) throws Exception {
		if (!map.containsKey(mapkey)){
			return false;
		}
		if (!tmp.containsKey(tmpkey)){
			return false;
		}
		return map.get(mapkey).equals(tmp.get(tmpkey));
	}
	
	/**
	 * 小規模多機能の集計情報レコードを持つか
	 * @param map
	 * @return
	 * @throws Exception
	 */
	private boolean isSyokiboTakinou() throws Exception {
	    //[ID:0000722][Shin Fujihara] 2012/04 edit begin 2012年度対応
//		return (serviceKindListLastMonth.contains("73")
//				&& serviceKindListThisMonth.contains("73"));
        
	    //小規模多機能提供
	    if (serviceKindListLastMonth.contains("73")
                && serviceKindListThisMonth.contains("73")) {
	        return true;
	    }
	    
	    //複合型提供
        if (serviceKindListLastMonth.contains("77")
                && serviceKindListThisMonth.contains("77")) {
            return true;
        }
	    
	    return false;
		//[ID:0000722][Shin Fujihara] 2012/04 edit end 2012年度対応
	}
	/**
	 * 予防小規模多機能の集計情報レコードを持つか
	 * @return
	 * @throws Exception
	 */
	private boolean isSyokiboTakinouYobou() throws Exception {
		return (serviceKindListLastMonth.contains("75")
				&& serviceKindListThisMonth.contains("75"));
	}
	
	// [H27.4改正対応][Shinobu Hitaka] 2015/1/20 edit - begin 
	/* サービスコード英数化に伴い、返り値を数値から文字列へ変更
	private int getServiceCode(VRMap map) throws Exception {
		int code = 0;
		
		//サービス種類コード
		if (!map.containsKey("301007")) {
			return code;
		}
		//サービス項目コード
		if (!map.containsKey("301008")) {
			return code;
		}
		
		return ACCastUtilities.toInt(String.valueOf(map.get("301007")) + String.valueOf(map.get("301008")), 0);
	}
	*/
	private String getServiceCode(VRMap map) throws Exception {
		String code = "";
		
		//サービス種類コード
		if (!map.containsKey("301007")) {
			return code;
		}
		//サービス項目コード
		if (!map.containsKey("301008")) {
			return code;
		}
		
		return String.valueOf(map.get("301007")) + String.valueOf(map.get("301008"));
	}
	// [H27.4改正対応][Shinobu Hitaka] 2015/1/20 edit - end
	
	private boolean isValueExist(VRMap map, String key, int conditions) {
		//空白以外チェック
		if ((conditions & NOT_EMPTY) == NOT_EMPTY) {
			//集計後、空白以外が設定されていたら、処理を行わない
			if (!ACTextUtilities.isNullText(map.get(key))){
				return true;
			}
		}
		//ゼロ以外
		if ((conditions & NOT_ZERO) == NOT_ZERO) {
			//集計後、0以外が設定されていたら、処理を行わない
			if (ACCastUtilities.toInt(map.get(key), 0) != 0) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isValueEmpty(VRMap map, String key, int conditions) {
		//空白以外チェック
		if ((conditions & NOT_EMPTY) == NOT_EMPTY) {
			if (ACTextUtilities.isNullText(map.get(key))){
				return true;
			}
		}
		//ゼロ以外
		if ((conditions & NOT_ZERO) == NOT_ZERO) {
			//集計後、0以外が設定されていたら、処理を行わない
			if (ACCastUtilities.toInt(map.get(key), 0) == 0) {
				return true;
			}
		}
		return false;
	}
	
	private String[] getStyleCode(VRMap map) throws Exception {
		String header = "235";
		String[] style = new String[]{null, null};
		
		for (int i = 0; i < header.length(); i++) {
			String key = header.charAt(i) + "01001";
			if (map.containsKey(key)) {
				style[0] = ACCastUtilities.toString(map.get(key), null);
				style[1] = String.valueOf(header.charAt(i));
				break;
			}
		}
		
		return style;
	}

	public void reflectStyle(VRMap map) throws Exception {
		String[] style = getStyleCode(map);
		
		if (style[0] == null) {
			return;
		}
		
		if (QP001StyleAbstract.IDENTIFICATION_NO_2_201204.equals(style[0])) {
			if ("2".equals(style[1])){
				reflect2base(map);
			} else if ("3".equals(style[1])){
				reflect2details(map);
				reflectDetails(map);
			}
		} else if (QP001StyleAbstract.IDENTIFICATION_NO_2_2_201204.equals(style[0])){
			if ("2".equals(style[1])){
				reflect22base(map);
			} else if ("3".equals(style[1])){
				reflect22details(map);
				reflectDetails(map);
			}
		} else if (QP001StyleAbstract.IDENTIFICATION_NO_3_201204.equals(style[0])){
			if ("2".equals(style[1])){
				reflect3base(map);
			} else if ("3".equals(style[1])){
				reflect3details(map);
				reflectDetails(map);
			}
		} else if (QP001StyleAbstract.IDENTIFICATION_NO_3_2_201204.equals(style[0])){
			if ("2".equals(style[1])){
				reflect32base(map);
			} else if ("3".equals(style[1])){
				reflect32details(map);
				reflectDetails(map);
			}
		} else if (QP001StyleAbstract.IDENTIFICATION_NO_4_201204.equals(style[0])){
			if ("2".equals(style[1])){
				reflect4base(map);
			} else if ("3".equals(style[1])){
				reflect4details(map);
				reflectDetails(map);
			} else if ("5".equals(style[1])){
				reflect4diagnosis(map);
			}
		} else if (QP001StyleAbstract.IDENTIFICATION_NO_4_2_201204.equals(style[0])){
			if ("2".equals(style[1])){
				reflect42base(map);
			} else if ("3".equals(style[1])){
				reflect42details(map);
				reflectDetails(map);
			} else if ("5".equals(style[1])){
				reflect42diagnosis(map);
			}
		} else if (QP001StyleAbstract.IDENTIFICATION_NO_5_201204.equals(style[0])){
			if ("2".equals(style[1])){
				reflect5base(map);
			} else if ("3".equals(style[1])){
				reflect5details(map);
				reflectDetails(map);
			} else if ("5".equals(style[1])){
				reflect5diagnosis(map);
			}
		} else if (QP001StyleAbstract.IDENTIFICATION_NO_5_2_201204.equals(style[0])){
			if ("2".equals(style[1])){
				reflect52base(map);
			} else if ("3".equals(style[1])){
				reflect52details(map);
				reflectDetails(map);
			} else if ("5".equals(style[1])){
				reflect52diagnosis(map);
			}
		} else if (QP001StyleAbstract.IDENTIFICATION_NO_6_201204.equals(style[0])){
			if ("2".equals(style[1])){
				reflect6base(map);
			} else if ("3".equals(style[1])){
				reflect6details(map);
				reflectDetails(map);
			} else if ("5".equals(style[1])){
				reflect6diagnosis(map);
			}
		} else if (QP001StyleAbstract.IDENTIFICATION_NO_6_2_201204.equals(style[0])){
			if ("2".equals(style[1])){
				reflect62base(map);
			} else if ("3".equals(style[1])){
				reflect62details(map);
				reflectDetails(map);
			} else if ("5".equals(style[1])){
				reflect62diagnosis(map);
			}
		} else if (QP001StyleAbstract.IDENTIFICATION_NO_6_3_201204.equals(style[0])){
			if ("2".equals(style[1])){
				reflect63base(map);
			} else if ("3".equals(style[1])){
				reflect63details(map);
				reflectDetails(map);
			} else if ("5".equals(style[1])){
				reflect63diagnosis(map);
			}
		} else if (QP001StyleAbstract.IDENTIFICATION_NO_6_4_201204.equals(style[0])){
			if ("2".equals(style[1])){
				reflect64base(map);
			} else if ("3".equals(style[1])){
				reflect64details(map);
				reflectDetails(map);
			} else if ("5".equals(style[1])){
				reflect64diagnosis(map);
			}
		} else if (QP001StyleAbstract.IDENTIFICATION_NO_6_5_201204.equals(style[0])){
			if ("2".equals(style[1])){
				reflect65base(map);
			} else if ("3".equals(style[1])){
				reflect65details(map);
				reflectDetails(map);
			} else if ("5".equals(style[1])){
				reflect65diagnosis(map);
			}
		} else if (QP001StyleAbstract.IDENTIFICATION_NO_6_6_201204.equals(style[0])){
			if ("2".equals(style[1])){
				reflect66base(map);
			} else if ("3".equals(style[1])){
				reflect66details(map);
				reflectDetails(map);
			} else if ("5".equals(style[1])){
				reflect66diagnosis(map);
			}
        } else if (QP001StyleAbstract.IDENTIFICATION_NO_6_7_201204.equals(style[0])){
            if ("2".equals(style[1])){
                reflect67base(map);
            } else if ("3".equals(style[1])){
                reflect67details(map);
                reflectDetails(map);
            } else if ("5".equals(style[1])){
                reflect67diagnosis(map);
            }
		} else if (QP001StyleAbstract.IDENTIFICATION_NO_8_201204.equals(style[0])){
			if ("2".equals(style[1])){
				reflect8base(map);
			} else if ("3".equals(style[1])){
				reflect8details(map);
				reflectDetails(map);
			} else if ("5".equals(style[1])){
				reflect8diagnosis(map);
			}
		} else if (QP001StyleAbstract.IDENTIFICATION_NO_9_201204.equals(style[0])){
			if ("2".equals(style[1])){
				reflect9base(map);
			} else if ("3".equals(style[1])){
				reflect9details(map);
				reflectDetails(map);
			} else if ("5".equals(style[1])){
				reflect9diagnosis(map);
			}
		} else if (QP001StyleAbstract.IDENTIFICATION_NO_10_201204.equals(style[0])){
			if ("2".equals(style[1])){
				reflect10base(map);
			} else if ("3".equals(style[1])){
				reflect10details(map);
				reflectDetails(map);
			} else if ("5".equals(style[1])){
				reflect10diagnosis(map);
			}
		}
	}
	
}
