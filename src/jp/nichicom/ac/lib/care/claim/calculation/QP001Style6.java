
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
 * プログラム 様式第六 (QP001Style6)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * 様式第六　一帳票分の情報
 * @author shin fujihara
 *
 */
public class QP001Style6  extends QP001StyleAbstract{

	/**
	 * 基本情報レコード(一帳票にひとつ)
	 */
	private QP001RecordBase base = new QP001RecordBase();
	/**
	 * 明細情報レコード集合
	 */
	private VRMap detailMap = new VRHashMap();
	/**
	 * 集計情報レコード集合(一帳票にひとつ)
	 */
	private QP001RecordType type = new QP001RecordType();
    
    /**
     * 内部様式番号
     */
    private int claimStyleFormat = 0;
    /**
     * 交換識別番号
     */
    private String identificationNo = "";
    
    private QP001Manager manager = null;
    
    /**
     * デフォルトコンストラクタ
     *　@deprecated
     */
    public QP001Style6(){
    }
    
    public QP001Style6(int claimStyleFormat,QP001Manager manager){
        this.claimStyleFormat = claimStyleFormat;
        //[H20.4 法改正対応] fujihara edit start
        //this.identificationNo = getIdentificationNo(claimStyleFormat);
        this.identificationNo = getIdentificationNo(claimStyleFormat,manager.getTargetDate());
        //[H20.4 法改正対応] fujihara edit end
        this.manager = manager;
    }
	
    public static String getSerialId(
			Date targetDate,
			VRMap serviceDetail,
			QP001PatientState patientState,
            int claimStyleFormat) throws Exception {
		StringBuilder serial = new StringBuilder();
		//201001	交換情報識別番号4桁
		
		//[H20.4 法改正対応] fujihara edit start
		//serial.append(getIdentificationNo(claimStyleFormat));
		serial.append(getIdentificationNo(claimStyleFormat,targetDate));
		//[H20.4 法改正対応] fujihara edit end
		
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
        /* 明細情報レコード集計処理 */
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
  	
	}
	
	/**
	 * 情報の確定を行う。
	 */
    public void commitRecords(QP001PatientState patientState,VRMap styles, VRMap planUnitMap) throws Exception {
// 2015/5/12 [Yoichiro Kamei] mod - begin 公費関連見直し
//		VRMap kohiMap;
//		TreeMap kohiRank = new TreeMap();
		QP001RecordDetail detail = null;
		Iterator it;
		
//		//本帳票における公費順位の確定を行う。
//		//TODO もう少し処理をすっきりさせたい。
//		
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
//		}
		
        List<Map> records = new ArrayList<Map>();
        records.add(detailMap);
        QP001KohiKey[] kohiTypes = getKohiApplyArray(records);
// 2015/5/12 [Yoichiro Kamei] mod - end
        
		//明細情報レコードの確定処理
		//[ID:0000721][Shin Fujihara] 2012/04 delete start 2012年度対応
//		it = detailMap.keySet().iterator();
//		while(it.hasNext()){
//			//作成した明細情報レコードの確定を行う。
//			((QP001RecordDetail)detailMap.get(it.next())).commitRecord(kohiTypes,patientState);
//		}
		//[ID:0000721][Shin Fujihara] 2012/04 delete end 2012年度対応
        //[ID:0000721][Shin Fujihara] 2012/04 add start 2012年度対応
        //看取り・ターミナル加算の摘要欄転記を考慮しながらの明細確定処理
        commitDetails(detailMap, kohiTypes, patientState);
        //[ID:0000721][Shin Fujihara] 2012/04 add end 2012年度対応
		
		//[ID:0000682][Shin Fujihara] add begin 【法改正対応】介護職員処遇改善加算
		commitTreatmentImprovement(detailMap, patientState, styles, planUnitMap);
		//[ID:0000682][Shin Fujihara] add end 【法改正対応】介護職員処遇改善加算
		
		it = detailMap.keySet().iterator();
		//集計情報レコードの作成(明細情報より)
		while(it.hasNext()){
			detail = ((QP001RecordDetail)detailMap.get(it.next()));
			type.parse(detail,patientState,manager);
		}
		
		//集計情報レコードの確定処理
		type.commitRecord(kohiTypes,patientState,styles,planUnitMap);
		
		
		//基本情報レコードの確定処理
		base.parse(type,patientState,kohiTypes,manager);
		
	}

	/**
	 * DB登録用のデータ取得を行う。
	 */
    public VRList getRecords(int patient_id, Date claimDate) throws Exception {
		VRList list = new VRArrayList();
		VRHashMap style = new VRHashMap();
        
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
		//集計情報レコード
		list.add(type.getRecord(style));
		
		//基本情報レコード
		list.add(base.getRecord(style));
		
		return list;
	}

}
