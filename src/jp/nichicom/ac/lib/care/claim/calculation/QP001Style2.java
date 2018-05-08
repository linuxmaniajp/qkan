
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
 * プログラム 様式第二 (QP001Style2)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanSjServiceCodeManager;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * 様式第二　一帳票分の情報
 * @author shin fujihara
 *
 */
public class QP001Style2 extends QP001StyleAbstract{
	
	/**
	 * 明細情報レコード集合
	 */
	private VRMap detailMap = new VRHashMap();
	/**
	 * 集計情報レコード集合
	 */
	private Map<String, QP001RecordType> typeMap = new TreeMap<String, QP001RecordType>();
	/**
	 * 基本情報レコード(一帳票にひとつ)
	 */
	private QP001RecordBase base = new QP001RecordBase();
	/**
	 * 社会福祉減免レコード集合
	 */
	private VRMap reductionMap = new VRHashMap();
    
    /**
     * 内部様式番号
     */
    private int claimStyleFormat = 0;
    /**
     * 交換識別番号
     */
    private String identificationNo = "";
    
    private QP001Manager manager = null;
    
    public QP001Style2(int claimStyleFormat,QP001Manager manager){
        this.claimStyleFormat = claimStyleFormat;
        this.identificationNo = getIdentificationNo(claimStyleFormat,manager.getTargetDate());
        this.manager = manager;
    }

	
    public static String getSerialId(
			Date targetDate,
			VRMap serviceDetail,
			QP001PatientState patientState,
            int claimStyleFormat) throws Exception {
		StringBuilder serial = new StringBuilder();
		//201001	交換情報識別番号4桁
		serial.append(getIdentificationNo(claimStyleFormat,targetDate));
		//サービス提供年月6桁(YYYYMM)
		serial.append(VRDateParser.format(targetDate,"yyyyMM"));
		//事業所番号10桁
		serial.append(VRBindPathParser.get("PROVIDER_ID",serviceDetail));
		//証記載保険者番号8桁
		serial.append(patientState.getInsurerId(VRBindPathParser.get("SERVICE_DATE",serviceDetail)));
		//被保険者番号10桁
		serial.append(patientState.getInsuredId(VRBindPathParser.get("SERVICE_DATE",serviceDetail)));
		
		return serial.toString();
	}
	
	/**
	 * データの解析を実行する。
	 * @param serviceDetail
	 * @param targetDate
	 * @param patientState
	 * @param serviceCode
	 * @throws Exception
	 */
    public void parse(VRMap serviceDetail,
    						 Date targetDate,
    						 QP001PatientState patientState,
    						 VRMap serviceCode) throws Exception {
		
		Object targetServiceDate = VRBindPathParser.get("SERVICE_DATE",serviceDetail);

// 2015/3/30 [Yoichiro Kamei] mod - begin 住所地特例対応
		//住所地特例の施設所在保険者番号
		String jushotiTokureiInsurerId = getJushotiTokureiInsurerId(targetServiceDate, patientState, serviceCode);
		
		if (ACTextUtilities.isNullText(jushotiTokureiInsurerId)) {
			//住所地特例ではない（通常の明細レコード）
			
	        //明細情報レコードを取得
	        QP001RecordDetail detail = QP001RecordDetail.getInstance(identificationNo,
	                                                                targetDate,
	                                                                targetServiceDate,
	                                                                serviceDetail,
	                                                                serviceCode,
	                                                                patientState,
	                                                                detailMap,
	                                                                manager);
	        
	        //レコードが作成されていれば
	        if(detail != null){
	            //明細情報データ解析
	            detail.parse(serviceDetail,targetDate,patientState,serviceCode,identificationNo,manager);
	        }
		} else {
	        //住所地特例の明細情報レコードを取得
	        QP001RecordDetailJushotiTokurei detailJushotiTokurei = QP001RecordDetailJushotiTokurei.getInstance(identificationNo,
	                                                                targetDate,
	                                                                targetServiceDate,
	                                                                serviceDetail,
	                                                                serviceCode,
	                                                                patientState,
	                                                                detailMap,
	                                                                manager,
	                                                                jushotiTokureiInsurerId);
	        
	        //レコードが作成されていれば
	        if(detailJushotiTokurei != null){
	            //明細情報データ解析
	        	detailJushotiTokurei.parse(serviceDetail,targetDate,patientState,serviceCode,identificationNo,manager);
	        }

		}
// 2015/3/30 [Yoichiro Kamei] mod - end 住所地特例対応
        
      	/* 社福減免レコード集計処理 */
      	//社福レコードを取得
      	QP001RecordReduction reduction = QP001RecordReduction.getInstance(identificationNo,
                                                                        targetDate,
                                                                        targetServiceDate,
                                                                        serviceDetail,
                                                                        serviceCode,
                                                                        patientState,
                                                                        reductionMap,
                                                                        manager);
      	
        if(reduction != null){
            //社会福祉減免データ解析
            reduction.parse(serviceDetail,targetDate,patientState,serviceCode,identificationNo,manager);
        }

		
	}
    
    
    /**
     * 不要なレコードを整理する。
     * @throws Exception
     */
    public void arrangement() throws Exception {
// 2016/7/21 [Yoichiro Kamei] mod - begin 総合事業対応 
// 中山間地域等提供加算の計算値がおかしかったので処理を見直した
//
//    	//様式第二の二以外は処理を行なわない。
//    	if(!"7132".equals(identificationNo)){
//    		return;
//    	}
//    	
//    	int unit = Integer.MAX_VALUE;
//    	
//		//明細情報レコードの確定処理
//		Iterator it = detailMap.keySet().iterator();
//		while(it.hasNext()){
//			//作成した明細情報レコードの確定を行う。
//			QP001RecordDetail detail = ((QP001RecordDetail)detailMap.get(it.next()));
//			if(QP001SpecialCase.isArrangementData(detail.get_301007(),detail.get_301008())){
//				//単位数を比較
//				if(detail.get_301009() < unit){
//					unit = detail.get_301009();
//				} else {
//					it.remove();
//				}
//			}
//		}
//		
//		it = detailMap.keySet().iterator();
//		while(it.hasNext()){
//			//作成した明細情報レコードの確定を行う。
//			QP001RecordDetail detail = ((QP001RecordDetail)detailMap.get(it.next()));
//			if(QP001SpecialCase.isArrangementData(detail.get_301007(),detail.get_301008())){
//				if(detail.get_301009() != unit){
//					it.remove();
//				}
//			}
//			
//			//特地加算のレコードであるか確認
//			// [H27.4改正対応][Shinobu Hitaka] 2015/1/22 edit - begin サービスコード英数化 
//			//if(ACCastUtilities.toInt(detail.get_301007(),0) == 61){
//			//	if(ACCastUtilities.toInt(detail.get_301008(),0) == 8000){
//			if("61".equals(detail.get_301007())){
//				if("8000".equals(detail.get_301008())){
//			// [H27.4改正対応][Shinobu Hitaka] 2015/1/22 edit - begin サービスコード英数化 
//					VRMap mainMap = new VRHashMap();
//					VRMap map = new VRHashMap();
//					map.put("UNIT",new Integer(unit));
//					map.put("TIMES",new Integer(1));
//					mainMap.put(detail.get_301007() + "-" + detail.get_301008(),map);
//					detail.setServiceUnitMap(mainMap);
//				}
//			}
//		}
		
    	//様式第二の二、様式第二の三以外は処理を行なわない。
    	if(!IDENTIFICATION_NO_2_2_201204.equals(identificationNo)
    		&& !IDENTIFICATION_NO_2_3_201504.equals(identificationNo)){
    		return;
    	}
    	
    	// [Yoichiro Kamei] 2018/5/2 mod - begin サービス種類を考慮するよう修正
//    	int unit = Integer.MAX_VALUE;
//		Iterator it = detailMap.keySet().iterator();
//		while(it.hasNext()){
//			QP001RecordDetail detail = ((QP001RecordDetail)detailMap.get(it.next()));
//			if(QP001SpecialCase.isArrangementData(detail.get_301007(),detail.get_301008())){
//				// 対象の単位数の中で最小のものを取得する
//				if(detail.get_301009() < unit){
//					unit = detail.get_301009();
//				}
//			}
//		}
//		if (unit == Integer.MAX_VALUE) {
//			return;
//		}
    	
    	Map<String, Integer> minUnitMap = new HashMap<String, Integer>();
    	Iterator it = detailMap.keySet().iterator();
    	while(it.hasNext()) {
    		QP001RecordDetail detail = ((QP001RecordDetail)detailMap.get(it.next()));
    		String kind = detail.get_301007();
    		String item = detail.get_301008();
    		if (QP001SpecialCase.isArrangementData(kind, item)) {
    			int minUnit = ACCastUtilities.toInt(minUnitMap.get(kind), 0);
    			int unit = detail.get_301009();
    			if ((minUnit == 0) || (unit < minUnit)) {
    				minUnit = unit;
    				minUnitMap.put(kind, minUnit);
    			}
    		}
    	}
    	if (minUnitMap.isEmpty()) {
    		return;
    	}
    	// [Yoichiro Kamei] 2018/5/2 mod - end
    	
		// 上記で取得した単位数以外のものは削除する
		List<String> removeKeys = new ArrayList<String>();
		it = detailMap.keySet().iterator();
		while(it.hasNext()){
			//作成した明細情報レコードの確定を行う。
			QP001RecordDetail detail = ((QP001RecordDetail)detailMap.get(it.next()));
			if(QP001SpecialCase.isArrangementData(detail.get_301007(),detail.get_301008())){
				// [Yoichiro Kamei] 2018/5/2 mod - begin サービス種類を考慮するよう修正
				int unit = ACCastUtilities.toInt(minUnitMap.get(detail.get_301007()), 0);
				if (unit == 0) {
					continue;
				}
				// [Yoichiro Kamei] 2018/5/2 mod - end
				if(detail.get_301009() != unit){
	                String key = String.valueOf(detail.get_301021()) + "-"
	                        + String.valueOf(detail.get_301022()) + "-"
	                        + String.valueOf(3);
	                
	                // 2016/10/20 [Yoichiro Kamei] add - begin 総合事業独自対応
	                // 独自の場合はkeyの先頭に保険者番号を付ける
	                if (QkanSjServiceCodeManager.dokujiKinds.contains(detail.get_301007())) {
		        		// 保険者番号
		        		String insurerId;
		        		if (detail instanceof QP001RecordDetailJushotiTokurei) {
		        			insurerId = ((QP001RecordDetailJushotiTokurei) detail).get_1801018();
		        		} else {
		        			insurerId = ACCastUtilities.toString(detail.get_301005());
		        		}
		        		key = insurerId + "-" + key;
	                }
	                // 2016/10/20 [Yoichiro Kamei] add - end
	                removeKeys.add(key);
					it.remove();
				}
			}
		}
		if (removeKeys.isEmpty()) {
			return;
		}
		// %加算のために保持している情報から削除したサービス分を除外する
		it = detailMap.keySet().iterator();
		while(it.hasNext()){
			QP001RecordDetail detail = ((QP001RecordDetail)detailMap.get(it.next()));
			for (String key : removeKeys) {
				// [H30.4改正対応][Yoichiro Kamei] 2018/3/20 mod - begin
//				// 特別地域加算
//				detail.getServiceUnitMap().remove(key);
//				// 中山間地域等提供加算
//				detail.getMountainousAreaAdder().removeService(key);
				List<QP001PercentageAdder> adderList = detail.getPercentageAdderList();
				for (QP001PercentageAdder adder : adderList) {
					adder.removeService(key);
				}
				// [H30.4改正対応][Yoichiro Kamei] 2018/3/20 mod - end
			}
		}
// 2016/7/21 [Yoichiro Kamei] mod - end
    }
    
// [H30.4改正対応][Yoichiro Kamei] 2018/3/27 add - begin
    /**
     * 住所地特例レコードの変換を行う
     * ％加算の対象となる基本サービスの算定状況により住所地特例レコードと通常レコードを変換
     * @throws Exception
     */
    public void convertJushotiTokureiRecord() throws Exception {
    	//住所地特例対象のサービス種類で％加算、％減算があるか確認
    	List<String> parsentageAddSerials = new ArrayList<String>();
		Iterator it = detailMap.keySet().iterator();
		while (it.hasNext()) {
			String serial = (String) it.next();
			QP001RecordDetail detail = ((QP001RecordDetail)detailMap.get(serial));
			//住所地特例対象のサービス種類
			if (QP001SpecialCase.isRegionStickingServiceForJushotiTokurei(detail.get_301007())) {
				// %加算、減算の場合
				if (detail.getServiceAddFlag() == 3 
						|| detail.getServiceAddFlag() == 6 
						|| detail.getServiceAddFlag() == 5
						|| detail.getServiceAddFlag() == 7) {
					parsentageAddSerials.add(serial);
				}
			}
		}
		if (parsentageAddSerials.isEmpty()) {
			//対象の％加算、％減算が１件もない場合は処理不要
			return;
		}
    	
    	Map<String, QP001RecordDetailJushotiTokurei> jushotiTokureiRecs 
    		= new HashMap<String, QP001RecordDetailJushotiTokurei>();
    	Map<String, QP001RecordDetail> nomalRecs = new HashMap<String, QP001RecordDetail>();
		it = detailMap.keySet().iterator();
		while (it.hasNext()) {
			QP001RecordDetail detail = ((QP001RecordDetail) detailMap.get(it.next()));
			
			//住所地特例対象のサービス種類ではない場合
			if (!QP001SpecialCase.isRegionStickingServiceForJushotiTokurei(detail.get_301007())) {
				continue;
			}
			
			//通常レコードと住所地特例レコードに分けてサービスコードを保持する
            String key = String.valueOf(detail.get_301021()) + "-"
                    + String.valueOf(detail.get_301022()) + "-"
                    + String.valueOf(detail.get_301027());
            
			if (detail instanceof QP001RecordDetailJushotiTokurei) {
                // 独自の場合はkeyの先頭に保険者番号を付ける
                if (QkanSjServiceCodeManager.dokujiKinds.contains(detail.get_301007())) {
                	String insurerId = ((QP001RecordDetailJushotiTokurei) detail).get_1801018();
                	key = insurerId + "-" + key;
                }
                jushotiTokureiRecs.put(key, (QP001RecordDetailJushotiTokurei) detail);
			} else {
				nomalRecs.put(key, detail);
			}
		}
		if (jushotiTokureiRecs.isEmpty()) {
			//住所地特例レコードが１件もない場合は処理不要
			return;
		}
		
		//処理対象の％加算、％減算の分ループ
		for (String serial : parsentageAddSerials) {
			QP001RecordDetail detail = (QP001RecordDetail) detailMap.get(serial);
			String addSvCode = detail.get_301007() + detail.get_301008();
			//変換が必要か確認
			if (detail instanceof QP001RecordDetailJushotiTokurei) {
				//処理対象の％加算、％減算が住所地特例のレコードの場合
				boolean doConvert = true;
				//対象となる基本サービスのkeySetを取得する
				Set<String> kihonKeySet = detail.getPercentageAdderKihonSet();
				for (String kihonKey : kihonKeySet) {
					//加算の対象となる基本サービスが住所地特例のレコードにあれば変換しない
					if (jushotiTokureiRecs.containsKey(kihonKey)) {
						QP001RecordDetail kihonRec = jushotiTokureiRecs.get(kihonKey);
						if (kihonRec.getParcentageTargetAddCodeSet().contains(addSvCode)) {
							doConvert = false;
						}						
					}
				}
				if (doConvert) {
					//住所地特例⇒通常レコードへ変換
					detailMap.put(serial, convertToNomal((QP001RecordDetailJushotiTokurei) detail));
				}
				
			} else {
				//処理対象の％加算、％減算が	通常のレコードの場合
				boolean doConvert = true;
				String insurerId = "";
				//対象となる基本サービスのkeySetを取得する
				Set<String> kihonKeySet = detail.getPercentageAdderKihonSet();
				for (String kihonKey : kihonKeySet) {
					//加算の対象となる基本サービスが通常のレコードにあれば変換しない
					if (nomalRecs.containsKey(kihonKey)) {
						QP001RecordDetail kihonRec = nomalRecs.get(kihonKey);
						if (kihonRec.getParcentageTargetAddCodeSet().contains(addSvCode)) {
							doConvert = false;
						}
					}
					//加算の対象となる基本サービスが住所地特例のレコードにある場合
					if (jushotiTokureiRecs.containsKey(kihonKey)) {
						QP001RecordDetailJushotiTokurei kihonDetail = jushotiTokureiRecs.get(kihonKey);
						//住所地特例の施設所在保険者番号を取得
						insurerId = kihonDetail.get_1801018();
					}
				}
				if (doConvert) {
					//通常⇒住所地特例レコードへ変換
					if (!"".equals(insurerId)) {
						//住所地特例⇒通常レコードへ変換
						detailMap.put(serial, convertToJushotiTokurei(detail, insurerId));
					}
				}
			}
		}
    }
    
    //住所地特例⇒通常レコードへ変換
    private QP001RecordDetail convertToNomal(QP001RecordDetailJushotiTokurei detail) {
    	QP001RecordDetail dest = new QP001RecordDetail();
    	dest.set_301001(detail.get_301001());
    	dest.set_301003(detail.get_301003());
    	dest.set_301004(detail.get_301004());
    	dest.set_301005(detail.get_301005());
    	dest.set_301006(detail.get_301006());
    	dest.set_301007(detail.get_301007());
    	dest.set_301008(detail.get_301008());
    	dest.set_301009(detail.get_301009());
    	dest.set_301010(detail.get_301010());    	
    	dest.set_301011(detail.get_301011());
    	dest.set_301012(detail.get_301012());
    	dest.set_301013(detail.get_301013());
    	dest.set_301014(detail.get_301014());
    	dest.set_301015(detail.get_301015());
    	dest.set_301016(detail.get_301016());
    	dest.set_301017(detail.get_301017());
    	dest.set_301018(detail.get_301018());
    	dest.set_301019(detail.get_301019());
    	dest.set_301020(detail.get_301020());    	
    	dest.set_301021(detail.get_301021());
    	dest.set_301022(detail.get_301022());
    	dest.set_301023(detail.get_301023());
    	dest.set_301024(detail.get_301024());
    	dest.set_301025(detail.get_301025());
    	dest.set_301026(detail.get_301026());
    	dest.set_301027(detail.get_301027());
    	dest.set_301028(detail.get_301028());
    	dest.set_301029(detail.get_301029());
    	return dest;
    }
    //通常⇒住所地特例レコードへ変換
    private QP001RecordDetailJushotiTokurei convertToJushotiTokurei(QP001RecordDetail detail, String insurerId) {
    	QP001RecordDetailJushotiTokurei dest = new QP001RecordDetailJushotiTokurei();
    	dest.set_301001(detail.get_301001());
    	dest.set_301003(detail.get_301003());
    	dest.set_301004(detail.get_301004());
    	dest.set_301005(detail.get_301005());
    	dest.set_301006(detail.get_301006());
    	dest.set_301007(detail.get_301007());
    	dest.set_301008(detail.get_301008());
    	dest.set_301009(detail.get_301009());
    	dest.set_301010(detail.get_301010());    	
    	dest.set_301011(detail.get_301011());
    	dest.set_301012(detail.get_301012());
    	dest.set_301013(detail.get_301013());
    	dest.set_301014(detail.get_301014());
    	dest.set_301015(detail.get_301015());
    	dest.set_301016(detail.get_301016());
    	dest.set_301017(detail.get_301017());
    	dest.set_301018(detail.get_301018());
    	dest.set_301019(detail.get_301019());
    	dest.set_301020(detail.get_301020());    	
    	dest.set_301021(detail.get_301021());
    	dest.set_301022(detail.get_301022());
    	dest.set_301023(detail.get_301023());
    	dest.set_301024(detail.get_301024());
    	dest.set_301025(detail.get_301025());
    	dest.set_301026(detail.get_301026());
    	dest.set_301027(detail.get_301027());
    	dest.set_301028(detail.get_301028());
    	dest.set_301029(detail.get_301029());    	
    	dest.set_1801018(insurerId);
    	return dest;
    }
// [H30.4改正対応][Yoichiro Kamei] 2018/3/27 add - end
	
	/**
	 * データの確定を行う。
	 */
    public void commitRecords(QP001PatientState patientState,VRMap styles, VRMap planUnitMap) throws Exception {
// 2015/5/12 [Yoichiro Kamei] mod - begin 公費関連見直し
        String serial = "";
		QP001RecordDetail detail = null;
		Iterator it;
//		VRMap kohiMap;
//		TreeMap kohiRank = new TreeMap();
//		QP001RecordDetail detail = null;
//		
//		//本帳票における公費順位の確定を行う。
//		Iterator it = detailMap.keySet().iterator();
//		while(it.hasNext()){
//			detail = (QP001RecordDetail)detailMap.get(it.next());
//			//作成した明細情報レコードの公費適用状況を取得する。
//			kohiMap = detail.getKohiList();
//			Iterator itKohi = kohiMap.keySet().iterator();
//			//公費の順位を登録する。
//			while(itKohi.hasNext()){
//				Object key = itKohi.next();
//				if(!kohiRank.containsKey(key)){
//					kohiRank.put(key,kohiMap.get(key));
//				}
//			}
//		}
//		
//		//公費適用順位
//		QP001KohiKey[] kohiTypes = new QP001KohiKey[3];
//		it = kohiRank.keySet().iterator();
//		int count = 0;
//		while(it.hasNext()){
//			VRMap temp = (VRMap)kohiRank.get(it.next());
//			kohiTypes[count] = new QP001KohiKey(temp);
//			count++;
//			if(count > kohiTypes.length - 1) break;
//		}
		
		List<Map> records = new ArrayList<Map>();
		records.add(detailMap);
		QP001KohiKey[] kohiTypes = getKohiApplyArray(records);
// 2015/5/12 [Yoichiro Kamei] mod - end
		
		//明細情報レコードの確定処理
		it = detailMap.keySet().iterator();
		while(it.hasNext()){
			//作成した明細情報レコードの確定を行う。
			((QP001RecordDetail)detailMap.get(it.next())).commitRecord(kohiTypes,patientState);
		}
		
		// [H30.4改正対応][Yoichiro Kamei] 2018/4/10 add - begin
		// %加算レコードの確定処理
		commitParcentageAddRecord(detailMap, kohiTypes);
		// [H30.4改正対応][Yoichiro Kamei] 2018/4/10 add - end
		
		//[ID:0000682][Shin Fujihara] add begin 【法改正対応】介護職員処遇改善加算
		commitTreatmentImprovement(detailMap, patientState, styles, planUnitMap);
		//[ID:0000682][Shin Fujihara] add end 【法改正対応】介護職員処遇改善加算
		
		it = detailMap.keySet().iterator();
		//集計情報レコードの作成
		while(it.hasNext()){
			detail = ((QP001RecordDetail)detailMap.get(it.next()));
			serial = QP001RecordType.getSerialId(detail);
			QP001RecordType type = null;
			if(!typeMap.containsKey(serial)){
				type = new QP001RecordType();
				typeMap.put(serial,type);
			} else {
				type = (QP001RecordType)typeMap.get(serial);
			}
			type.parse(detail,patientState,manager);
		}
		
    	it = typeMap.keySet().iterator();
		QP001RecordType type;
		//集計情報レコードの確定処理
		while(it.hasNext()){
			type = ((QP001RecordType)typeMap.get(it.next()));
			type.commitRecord(kohiTypes,patientState,styles,planUnitMap);
		}
		
		//社福減免レコードの確定処理
		it = reductionMap.keySet().iterator();
		QP001RecordReduction reduction = null;
		while(it.hasNext()){
			reduction = (QP001RecordReduction)reductionMap.get(it.next());
			Iterator itType = typeMap.keySet().iterator();
			while(itType.hasNext()){
				type = (QP001RecordType)typeMap.get(itType.next());
				//サービス種類コードが同じ集計情報レコードを取得する。
				if(reduction.get_901008().equals(type.get_701007())){
					reduction.commitRecord(type.get_701017());
					break;
				}
			}
		}
		
		it = typeMap.keySet().iterator();
		while(it.hasNext()){
			base.parse((QP001RecordType)typeMap.get(it.next()),patientState,kohiTypes,manager);
		}
		
	}
    
 // 2015/3/30 [Yoichiro Kamei] add - begin 住所地特例対応
    //明細情報（住所地特例）の対象レコードであれば、施設所在保険者番号を返します。
    //対象外の場合は空文字をかえします。
    private String getJushotiTokureiInsurerId(Object targetServiceDate
    		, QP001PatientState patientState
    		, VRMap serviceCode)  throws Exception {
    	//住所地特例対象の地域密着型サービスか
    	if (!QP001SpecialCase.isRegionStickingServiceForJushotiTokurei(ACCastUtilities.toString(VRBindPathParser.get("SERVICE_CODE_KIND", serviceCode)))) {
    		return "";
    	}
    	//月額サービス、月額加算、地域系%加算の場合
    	//月末時点で住所地特例の対象かどうか
    	if (ACCastUtilities.toInt(VRBindPathParser.get("TOTAL_GROUPING_TYPE", serviceCode)) == 3 //1月につき
    		|| ACCastUtilities.toInt(VRBindPathParser.get("SERVICE_ADD_FLAG", serviceCode)) == 3 //％加算(地域系加算)
    		|| ACCastUtilities.toInt(VRBindPathParser.get("SERVICE_ADD_FLAG", serviceCode)) == 6 //％加算(対象に地域系加算を含む)
    		|| ACCastUtilities.toInt(VRBindPathParser.get("SERVICE_ADD_FLAG", serviceCode)) == 8 //処遇改善加算
    	) {
    		//対象日を月末日にセット
    		targetServiceDate = ACDateUtilities.toLastDayOfMonth(ACCastUtilities.toDate(targetServiceDate));
    	}
    	
    	//対象日時点の住所地特例の施設所在保険者番号
    	return patientState.getJushotiTokureiInsurerId(targetServiceDate);
    }
 // 2015/3/30 [Yoichiro Kamei] add - end 住所地特例対応
    
    
	/**
	 * DB登録用のレコード集合を作成します。
	 * @param patient_id
	 * @param targetDate
	 * @return
	 * @throws Exception
	 */
    public VRList getRecords(int patient_id, Date claimDate) throws Exception {
		VRList list = new VRArrayList();
		VRHashMap style = new VRHashMap();
		
		//データが正常に生成されていない場合は処理を終了する。
		if(ACTextUtilities.isNullText(base.get_201003())){
			return list;
		}
		
		//帳票の様式番号
		style.put("CLAIM_STYLE_TYPE",ACCastUtilities.toString(claimStyleFormat));
		//利用者ＩＤ
		style.put("PATIENT_ID",Integer.toString(patient_id));
		//基本情報レコードから取得
		//利用者番号(被保険者番号)
		style.put("INSURED_ID",base.get_201006());
		//請求の対象となる年月(サービス提供年月)
		style.put("TARGET_DATE",ACCastUtilities.toDate(base.get_201003() + "01"));
		//請求を行う年月日
		style.put("CLAIM_DATE",claimDate);
		//請求元事業所
		style.put("PROVIDER_ID",base.get_201004());
        
        //保険者番号
        style.put("INSURER_ID",base.get_201005());
        //被保険者番号
        style.put("INSURED_ID",base.get_201006());
		
		style.put("CLAIM_FINISH_FLAG","0");		
		
		//明細情報レコード
		Iterator it = detailMap.keySet().iterator();
		while(it.hasNext()){
			list.add(((QP001RecordDetail)detailMap.get(it.next())).getRecord(style));
		}
		//社福減免レコード
		it = reductionMap.keySet().iterator();
		while(it.hasNext()){
			list.add(((QP001RecordReduction)reductionMap.get(it.next())).getRecord(style));
		}
		//集計情報レコード
		it = typeMap.keySet().iterator();
		while(it.hasNext()){
			list.add(((QP001RecordType)typeMap.get(it.next())).getRecord(style));
		}
		list.add(base.getRecord(style));
		
		return list;
	}
	
	public String toString(){
		StringBuilder result = new StringBuilder();
		//明細情報レコード
		Iterator it = detailMap.keySet().iterator();
		while(it.hasNext()){
			result.append("Detail\n");
			result.append(((QP001RecordDetail)detailMap.get(it.next())));
		}
		//社福減免レコード
		it = reductionMap.keySet().iterator();
		while(it.hasNext()){
			result.append("Reduction\n");
			result.append((QP001RecordReduction)reductionMap.get(it.next()));
		}
		//集計情報レコード
		it = typeMap.keySet().iterator();
		while(it.hasNext()){
			result.append("Type\n");
			result.append((QP001RecordType)typeMap.get(it.next()));
		}
		//基本情報レコード
		result.append("Base\n");
		result.append(base);
		
		return result.toString();
	}
	

}
