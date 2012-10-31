
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

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

/**
 * 様式第十一 帳票情報
 * @author shin fujihara
 *
 */
public class QP001Style11 extends QP001StyleAbstract {

	/**
	 * 様式第十一　交換識別番号
	 */
	private static final String IDENTIFICATION_NO = "8222";

	/**
	 * 様式第十一
	 */
	private Map<String, QP001RecordSupply> supplyMap = new TreeMap<String, QP001RecordSupply>();
	
	/**
	 * 交換識別番号を返却する。
	 * @return
	 */
	protected static String getSerialId(){
		return IDENTIFICATION_NO;
	}
	
    //担当介護支援専門員番号
    private String _1201025 = "";
    //委託先の居宅介護支援事業所番号
    private String _1201026 = "";
    //委託先の担当介護支援専門員番号
    private String _1201027 = "";
    
    private boolean makeLastRecord = false;
    
    public static String getSerialId(
            Date targetDate,
            VRMap serviceDetail,
            QP001PatientState patientState) throws Exception {
        
        StringBuilder serial = new StringBuilder();
        //201001    交換情報識別番号4桁
        serial.append(IDENTIFICATION_NO);
        //サービス提供年月6桁(YYYYMM)
        serial.append(VRDateParser.format(targetDate,"yyyyMM"));
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
    public boolean parse(VRMap serviceDetail,
			 Date targetDate,
			 QP001PatientState patientState,
			 VRMap serviceCode,
            boolean first,QP001Manager manager) throws Exception {
        
        
    	boolean result = first;
    	
        Object targetServiceDate = VRBindPathParser.get("SERVICE_DATE",serviceDetail);
        
        //明細情報レコードを取得
        QP001RecordSupply supply = QP001RecordSupply.getInstance(IDENTIFICATION_NO,
                                                                targetDate,
                                                                targetServiceDate,
                                                                serviceDetail,
                                                                serviceCode,
                                                                patientState,
                                                                supplyMap);
        
        //レコードが作成されていれば
        if(supply != null){
            //明細情報データ解析
        	result = supply.parse(serviceDetail,targetDate,patientState,serviceCode,IDENTIFICATION_NO,first,manager);
        }
        
        //専門員番号の設定
        setPersonInChargeNo(serviceDetail);
        
        return result;
	}
    
    /**
     * 実績のデータより介護支援専門員番号を取得する。
     * @param serviceDetail
     * @throws Exception
     */
    public void parse(VRMap serviceDetail) throws Exception {
    	//専門員番号の設定
    	setPersonInChargeNo(serviceDetail);
    }
    
    public void setPersonInChargeNo(VRMap serviceDetail) throws Exception {
        
    	if(serviceDetail.containsKey("1430107")){
        	//担当介護支援専門員番号
        	_1201025 = ACCastUtilities.toString(serviceDetail.get("1430107"),"");
        	_1201026 = "";
        	_1201027 = "";
        
    	} else if(serviceDetail.containsKey("1730104")){
            //小規模多機能型
        	_1201025 = ACCastUtilities.toString(serviceDetail.get("1730104"),"");
        	_1201026 = "";
        	_1201027 = "";
        
    	} else if(serviceDetail.containsKey("1750104")){
        	//介護小規模多機能
        	_1201025 = ACCastUtilities.toString(serviceDetail.get("1750104"),"");
        	_1201026 = "";
        	_1201027 = "";
        	
        } else if(serviceDetail.containsKey("1770116")) {
            //複合型
            _1201025 = ACCastUtilities.toString(serviceDetail.get("1770116"),"");
            _1201026 = "";
            _1201027 = "";
        }
        
        //ID:0000184 居宅介護支援専門員がいるときでも委託は出来るよう修整
    	if(serviceDetail.containsKey("1460103")){
        	//介護予防支援(委託)
        	//委託先の居宅介護支援事業所番号
        	_1201026 = ACCastUtilities.toString(serviceDetail.get("1460102"),"");
        	//委託先の担当介護支援専門員番号
        	_1201027 = ACCastUtilities.toString(serviceDetail.get("1460103"),"");
    	}
    }
    
	/**
     * レコード内容の確定を行う。
     * @param patientState 利用者情報
     * @param styles 請求情報
     * @throws Exception 実行時例外
	 */
    public void commitRecords(QP001PatientState patientState,VRMap styles, VRMap planUnitMap) throws Exception {
        makeLastRecord = true;
        commitRecords();
	}
    
    /**
     * レコード内容の確定を行う。
     * @throws Exception 実行時例外
     */
    public void commitRecords() throws Exception {
        QP001RecordSupply supply = null;
        VRList removeList = new VRArrayList();
        Iterator<String> it = supplyMap.keySet().iterator();
        while(it.hasNext()){
            Object key = it.next();
            supply = (QP001RecordSupply)supplyMap.get(key);
            //担当介護支援専門員番号
            supply.set_1201025(_1201025);
            //委託先の居宅介護支援事業所番号
            supply.set_1201026(_1201026);
            //委託先の担当介護支援専門員番号
            supply.set_1201027(_1201027);
            
            //レコードの内容を確定
            supply.commitRecord();
            
            //計画単位数が0点のものは除外する。
            if(supply.get_1201020() == 0){
                removeList.add(key);
            }
        }
        for(int i = 0; i < removeList.size(); i++){
            supplyMap.remove(removeList.get(i));
        }
        
        //最終の集計の場合、最終レコードの作成を行う。
        if(makeLastRecord){
            supply = new QP001RecordSupply();
            supply.commitRecord(supplyMap);
            supplyMap.put(supply.getSerialId(),supply);
        }
        
    }
    
    public String getProviderId() throws Exception{
        if((supplyMap == null) || (supplyMap.size() == 0)){
            return "";
        }
        QP001RecordSupply supply = null;
        
        Iterator<String> it = supplyMap.keySet().iterator();
        
        while(it.hasNext()){
            supply = (QP001RecordSupply)supplyMap.get(it.next());
            break;
        }
        if(supply == null){
            return "";
        } else {
            return supply.get_1201004();
        }
        
    }

    public VRList getRecords(int patient_id, Date claimDate) throws Exception {
		VRList list = new VRArrayList();
		VRHashMap style = new VRHashMap();
		
        if((supplyMap == null) || (supplyMap.size() == 0)){
            return list;
        }
        
        QP001RecordSupply supply = null;
        
        Iterator<String> it = supplyMap.keySet().iterator();
        
        while(it.hasNext()){
            supply = (QP001RecordSupply)supplyMap.get(it.next());
            break;
        }
        
		//帳票の様式番号
		style.put("CLAIM_STYLE_TYPE", ACCastUtilities.toString(QkanConstants.CLAIM_STYLE_BENEFIT_MANAGEMENT));
		//利用者ＩＤ
		style.put("PATIENT_ID", Integer.toString(patient_id));
		//請求の対象となる年月(サービス提供年月)
		style.put("TARGET_DATE", ACCastUtilities.toDate(supply.get_1201002() + "01"));
		//請求を行う年月日
		style.put("CLAIM_DATE", claimDate);
		//請求元事業所
		style.put("PROVIDER_ID", supply.get_1201004());
        
        //保険者番号
        style.put("INSURER_ID", supply.get_1201003());
        //style.put("INSURER_ID", QkanSystemInformation.getInstance().getLoginProviderID());
        //被保険者番号
        style.put("INSURED_ID", supply.get_1201009());
		
		style.put("CLAIM_FINISH_FLAG","0");		
		
        it = supplyMap.keySet().iterator();
        while(it.hasNext()){
            list.add(((QP001RecordSupply)supplyMap.get(it.next())).getRecord(style));
        }
        
		return list;
	}
    
    public String toString(){
        StringBuilder result = new StringBuilder();
        Iterator<String> it = supplyMap.keySet().iterator();
        while(it.hasNext()){
            result.append("Supply\n");
            result.append(((QP001RecordSupply)supplyMap.get(it.next())));
        }
        return result.toString();
    }
    
    protected Map<String, QP001RecordSupply> getSupplyMap() throws Exception {
        return supplyMap;
    }

}
