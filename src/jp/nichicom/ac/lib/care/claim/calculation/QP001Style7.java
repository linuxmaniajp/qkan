
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
 * プログラム 様式第七 (QP001Style7)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * 様式第七 帳票情報
 * @author shin fujihara
 *
 */
public class QP001Style7 extends QP001StyleAbstract {

	/*
	 * ID:0000447][Shin Fujihara] 2009/02 edit begin 平成21年4月法改正対応
	 * 
	 * 様式第七が複数レコードを保持する（加算算定有）仕様変更が発生したため、
	 * プログラム全体を大幅修正。
	 * 
	 * 変更履歴はCVSを参照
	 */
	
	
	
   /**
    * 内部様式番号
    */
   private int claimStyleFormat = 0;
   /**
    * 交換識別番号
    */
   private String identificationNo = "";
	
	/**
	 * 様式第七
	 */
	//private QP001RecordCarePlan carePlan = null;
	private Map carePlanMap = new TreeMap();
    
    public QP001Style7(int claimStyleFormat,QP001Manager manager) {
        this.claimStyleFormat = claimStyleFormat;
        this.identificationNo = getIdentificationNo(claimStyleFormat,manager.getTargetDate());
    }
    
	/**
	 * レコード特有の情報を返却します
	 * @return
	 */
    public static String getSerialId(int claimStyleFormat,Date targetDate){
    	return getIdentificationNo(claimStyleFormat,targetDate);
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
							 VRMap serviceCode,
                             QP001Manager manager) throws Exception {
        
        
    	QP001RecordCarePlan carePlan = null;
    	carePlan = QP001RecordCarePlan.getInstance(identificationNo, serviceDetail, targetDate, 
    			patientState, serviceCode, carePlanMap);
    	
    	
    	if (carePlan == null){
    		return;
    	}
    	
    	
    	//[ID:0000702][Shin Fujihara] 2012/04 add start 平成21年4月法改正対応
    	//様式第七、加算のみ算定に対応
    	carePlan.parse(serviceDetail,patientState,serviceCode,identificationNo,manager);
    	
        //支援が２つ以上はられている場合は、月初の介護保険専門員番号を採用する。
        if (!carePlan.isNew()) {
            Date serviceDate = ACCastUtilities.toDate(serviceDetail.get("SERVICE_DATE"),null);
            
            //サービス提供日が取得できた場合
            if(serviceDate != null){
                boolean replace = false;
                //サービス提供日が明確な場合
                if(carePlan.getServiceDate() != null){
                    //現在読み取っているレコードの日付が新しい場合
                    if(ACDateUtilities.compareOnDay(serviceDate,carePlan.getServiceDate()) < 0){
                        replace = true;
                    }
                } else {
                    replace = true;
                }
                if(replace){
                    carePlan.setServiceDate(serviceDate);
                    if(!ACTextUtilities.isNullText(serviceDetail.get("1430107"))){
                        carePlan.set_1001022(String.valueOf(serviceDetail.get("1430107")));
                    } else {
                        carePlan.set_1001022("");
                    }
                }
                
            }
        }
    	//[ID:0000702][Shin Fujihara] 2012/04 add end 平成21年4月法改正対応
    	//[ID:0000702][Shin Fujihara] 2012/04 delete start 平成21年4月法改正対応
    	//様式第七、加算のみ算定に対応
//        if(carePlan.isNew()){
//        	carePlan.parse(serviceDetail,patientState,serviceCode,identificationNo,manager);
//        } else {
//            //支援が２つ以上はられている場合は、月初の介護保険専門員番号を採用する。
//            Date serviceDate = ACCastUtilities.toDate(serviceDetail.get("SERVICE_DATE"),null);
//            
//            //サービス提供日が取得できた場合
//            if(serviceDate != null){
//                boolean replace = false;
//                //サービス提供日が明確な場合
//                if(carePlan.getServiceDate() != null){
//                    //現在読み取っているレコードの日付が新しい場合
//                    if(ACDateUtilities.compareOnDay(serviceDate,carePlan.getServiceDate()) < 0){
//                        replace = true;
//                    }
//                } else {
//                    replace = true;
//                }
//                if(replace){
//                    carePlan.setServiceDate(serviceDate);
//                    if(!ACTextUtilities.isNullText(serviceDetail.get("1430107"))){
//                        carePlan.set_1001022(String.valueOf(serviceDetail.get("1430107")));
//                    } else {
//                        carePlan.set_1001022("");
//                    }
//                }
//                
//            }
//        }
        //[ID:0000702][Shin Fujihara] 2012/04 delete end 平成21年4月法改正対応
		
	}
	
    public void commitRecords(QP001PatientState patientState,VRMap styles, VRMap planUnitMap) throws Exception {
		
		int data_size = carePlanMap.size();
		//データの取得が行なえていない場合、処理停止
		if (data_size == 0){
			return;
		}
		
		QP001RecordCarePlan carePlan = null;
		
		int _1001027 = 0;
		int count = 1;
		Iterator it = carePlanMap.keySet().iterator();
		while(it.hasNext()){
			carePlan = (QP001RecordCarePlan)carePlanMap.get(it.next());
			carePlan.commitRecord();
			carePlan.set_1001024(count);
			_1001027 += carePlan.get_1001017();
			//請求金額をリセット
			carePlan.set_1001018(0);
			count++;
		}
		
		//サービス計画日明細行番号
		carePlan.set_1001024(99);
		//サービス単位数合計
		carePlan.set_1001027(_1001027);
		
        BigDecimal temp = new BigDecimal(String.valueOf(carePlan.get_1001006()));
        temp = temp.multiply(new BigDecimal("100"));
        carePlan.set_1001018((int)Math.floor((double)(_1001027 * temp.intValue()) / 100d));
		
	}

    public VRList getRecords(int patient_id, Date claimDate) throws Exception {
		VRList list = new VRArrayList();
		VRHashMap style = new VRHashMap();
		QP001RecordCarePlan carePlan = null;
		
		Iterator it = carePlanMap.keySet().iterator();
		while(it.hasNext()){
			carePlan = (QP001RecordCarePlan)carePlanMap.get(it.next());
			
            //帳票の様式番号
            style.put("CLAIM_STYLE_TYPE",ACCastUtilities.toString(claimStyleFormat));
            //利用者ＩＤ
            style.put("PATIENT_ID",Integer.toString(patient_id));
            //請求の対象となる年月(サービス提供年月)
            style.put("TARGET_DATE",ACCastUtilities.toDate(carePlan.get_1001004() + "01"));
            //請求を行う年月日
            style.put("CLAIM_DATE",claimDate);
            //請求元事業所
            style.put("PROVIDER_ID",carePlan.get_1001002());
            
            //保険者番号
            style.put("INSURER_ID", carePlan.get_1001005());
            //被保険者番号
            style.put("INSURED_ID", carePlan.get_1001007());
            
            style.put("CLAIM_FINISH_FLAG","0");     
            
            list.add(carePlan.getRecord(style));
		}
        
		return list;
	}

}
