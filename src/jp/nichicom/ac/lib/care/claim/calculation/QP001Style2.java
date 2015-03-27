
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

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

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
        
// 2014/12/24 [Yoichiro Kamei] add - begin 住所地特例対応
        //明細情報レコードを取得
        QP001RecordDetailJushotiTokurei detailJushotiTokurei = QP001RecordDetailJushotiTokurei.getInstance(identificationNo,
                                                                targetDate,
                                                                targetServiceDate,
                                                                serviceDetail,
                                                                serviceCode,
                                                                patientState,
                                                                detailMap,
                                                                manager);
        
        //レコードが作成されていれば
        if(detailJushotiTokurei != null){
            //明細情報データ解析
        	detailJushotiTokurei.parse(serviceDetail,targetDate,patientState,serviceCode,identificationNo,manager);
        }        
// 2014/12/24 [Yoichiro Kamei] add - end
        
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
    	//様式第二の二以外は処理を行なわない。
    	if(!"7132".equals(identificationNo)){
    		return;
    	}
    	
    	int unit = Integer.MAX_VALUE;
    	
		//明細情報レコードの確定処理
		Iterator it = detailMap.keySet().iterator();
		while(it.hasNext()){
			//作成した明細情報レコードの確定を行う。
			QP001RecordDetail detail = ((QP001RecordDetail)detailMap.get(it.next()));
			if(QP001SpecialCase.isArrangementData(detail.get_301007(),detail.get_301008())){
				//単位数を比較
				if(detail.get_301009() < unit){
					unit = detail.get_301009();
				} else {
					it.remove();
				}
			}
		}
		
		it = detailMap.keySet().iterator();
		while(it.hasNext()){
			//作成した明細情報レコードの確定を行う。
			QP001RecordDetail detail = ((QP001RecordDetail)detailMap.get(it.next()));
			if(QP001SpecialCase.isArrangementData(detail.get_301007(),detail.get_301008())){
				if(detail.get_301009() != unit){
					it.remove();
				}
			}
			
			//特地加算のレコードであるか確認
			// [H27.4改正対応][Shinobu Hitaka] 2015/1/22 edit - begin サービスコード英数化 
			//if(ACCastUtilities.toInt(detail.get_301007(),0) == 61){
			//	if(ACCastUtilities.toInt(detail.get_301008(),0) == 8000){
			if("61".equals(detail.get_301007())){
				if("8000".equals(detail.get_301008())){
			// [H27.4改正対応][Shinobu Hitaka] 2015/1/22 edit - begin サービスコード英数化 
					VRMap mainMap = new VRHashMap();
					VRMap map = new VRHashMap();
					map.put("UNIT",new Integer(unit));
					map.put("TIMES",new Integer(1));
					mainMap.put(detail.get_301007() + "-" + detail.get_301008(),map);
					detail.setServiceUnitMap(mainMap);
				}
			}
		}
    }
    
	
	/**
	 * データの確定を行う。
	 */
    public void commitRecords(QP001PatientState patientState,VRMap styles, VRMap planUnitMap) throws Exception {
		String serial = "";
		VRMap kohiMap;
		TreeMap kohiRank = new TreeMap();
		QP001RecordDetail detail = null;
		
		//本帳票における公費順位の確定を行う。
		Iterator it = detailMap.keySet().iterator();
		while(it.hasNext()){
			detail = (QP001RecordDetail)detailMap.get(it.next());
			//作成した明細情報レコードの公費適用状況を取得する。
			kohiMap = detail.getKohiList();
			Iterator itKohi = kohiMap.keySet().iterator();
			//公費の順位を登録する。
			while(itKohi.hasNext()){
				Object key = itKohi.next();
				if(!kohiRank.containsKey(key)){
					kohiRank.put(key,kohiMap.get(key));
				}
			}
		}
		
		//公費適用順位
		String[] kohiTypes = new String[3];
		it = kohiRank.keySet().iterator();
		int count = 0;
		while(it.hasNext()){
			VRMap temp = (VRMap)kohiRank.get(it.next());
			kohiTypes[count] = ACCastUtilities.toString(VRBindPathParser.get("KOHI_TYPE",temp));
			count++;
			if(count > kohiTypes.length - 1) break;
		}
		
		//明細情報レコードの確定処理
		it = detailMap.keySet().iterator();
		while(it.hasNext()){
			//作成した明細情報レコードの確定を行う。
			((QP001RecordDetail)detailMap.get(it.next())).commitRecord(kohiTypes,patientState);
		}
		
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
