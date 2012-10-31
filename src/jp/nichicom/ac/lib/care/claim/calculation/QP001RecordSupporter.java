
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
 * プログラム 公費順位確定クラス (QP001RecordSupporter)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Iterator;

import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * レコードに付属の情報全般を管理します。
 * （公費順位、サービス実日数など）
 * @author shin fujihara
 */
public class QP001RecordSupporter {

	//公費順位を保持します。
	//キー:公費適用順位　値:公費番号
	private VRMap kohiRankMap =new VRHashMap();
	//サービス実日数を管理します。
	private VRList realDays = new VRArrayList();
    //入所(入院)日数を管理します。
    private VRList hospitalizationDays = new VRArrayList();
    //外泊日数を管理します。
    private VRList leavingHospitalDays = new VRArrayList();

    
	//公費の適用パタンを管理します。
	private VRMap kohiPattern = new VRHashMap();
	//指定の公費番号の公費適用回数が何回であったか算出します。
	private VRMap kohiApplicationTimes = new VRHashMap();
    
	//add start fujihara.shin 2008.6.23 自動日割り展開に対応
	//サービスの実提供日数を管理します。
	private VRList offerDays = new VRArrayList();
	//add end fujihara.shin 
	
    /**
     * 
     * @param targetDate
     * @param patientState
     * @param systemServiceKindDetail
     * @param applicationType
     * @throws Exception
     */
    protected void setExtraData(
            Object targetDate,
            VRMap serviceDetail,
            QP001PatientState patientState,
            //String systemServiceKindDetail,
            VRMap serviceCode,
            String applicationType,
            int service_unit,
            int medicalFlag,QP001Manager manager) throws Exception {
//        setExtraData(targetDate,serviceDetail,patientState,systemServiceKindDetail,applicationType,service_unit,medicalFlag,1);
        
        setExtraData(targetDate,serviceDetail,patientState,serviceCode,applicationType,service_unit,medicalFlag,1,manager);
    }
	
	/**
	 * 
	 * @param targetDate
	 * @param patientState
	 * @param systemServiceKindDetail
	 * @param applicationType
	 * @throws Exception
	 */
	protected void setExtraData(
			Object targetDate,
            VRMap serviceDetail,
			QP001PatientState patientState,
			//String systemServiceKindDetail,
            VRMap serviceCode,
			String applicationType,
			int service_unit,
            int medicalFlag,
            int count,
            QP001Manager manager) throws Exception {
		

        //日付データの設定
		//[ID:0000586][Shin Fujihara] 2010/01 edit begin 2009年度対応
        //setDate(targetDate,serviceDetail);
		setDate(targetDate,serviceDetail, serviceCode);
        //[ID:0000586][Shin Fujihara] 2010/01 edit end 2009年度対応
        
		//公費の取得
//		VRList list = patientState.getKohiDataFromServiceKind(targetDate,systemServiceKindDetail,applicationType,1,medicalFlag);
        VRList list = patientState.getKohiDataFromServiceKind(targetDate,String.valueOf(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL")),applicationType,1,medicalFlag,manager);
		
		//未知のパタンであるか確認
		//シリアルを取得して同じ公費の適用パタンがないか参照
		String serial = QP001RecordSupporterCalc.getSerialId(list,patientState,targetDate,1);
		QP001RecordSupporterCalc calc = null;
		
		//未知の公費パタンである場合
		if(!kohiPattern.containsKey(serial)){
			for(int i = 0; i < list.getDataSize(); i++) {
				VRMap kohi = (VRMap)list.getData(i);
				//公費適用順位への追加を行う
				kohiRankMap.put(VRBindPathParser.get("KOHI_SORT",kohi),kohi);
			}
			calc = new QP001RecordSupporterCalc(service_unit);
			//公費計算オブジェクトの追加を行う。
			kohiPattern.setData(serial,calc);
		} else {
			calc = (QP001RecordSupporterCalc)kohiPattern.getData(serial);
		}
		calc.addTime(serviceDetail,serviceCode);
		//特定の公費パタンで何回適用があるかが知りたい
		for(int i = 0; i < list.getDataSize(); i++){
			VRMap kohi = (VRMap)list.getData(i);
			int countTemp = count;
			//公費の設定がある場合
			if(kohiApplicationTimes.containsKey(VRBindPathParser.get("KOHI_TYPE",kohi))){
                countTemp = ((Integer)kohiApplicationTimes.get(VRBindPathParser.get("KOHI_TYPE",kohi))).intValue();
                countTemp += count;
			}
			kohiApplicationTimes.setData(VRBindPathParser.get("KOHI_TYPE",kohi),new Integer(countTemp));
		}
	}
    
    /**
     * 日付にまつわるデータを設定します。
     * @param targetDate
     * @param serviceDetail
     * @param serviceCode
     * @throws Exception
     */
	//[ID:0000586][Shin Fujihara] 2010/01 edit begin 2009年度対応
	//日付判定の仕様追加に対応するため、serviceCodeの引数を追加
	//それに伴い、メソッド内の処理を大きく変更しています。
	//コードの可読性向上のため、変更コメントは記載していません。
	//差分はCVSで確認してください
	public void setDate(Object targetDate,VRMap serviceDetail, VRMap serviceCode) throws Exception {
        //実日数の算出
        //未登録の日付、かつ実日数として算定すべき項目であれば追加
		if(!realDays.contains(targetDate) && QP001SpecialCase.isRealDay(serviceDetail, serviceCode)){
            realDays.add(targetDate);
        }

    	//根本的に日付計算の概念を変更
    	//サービス実日数と、提供日数を分けて保持するよう変更
    	if (!offerDays.contains(targetDate)){
    		offerDays.add(targetDate);
    	}
        
        //外泊日数の算出
        switch(CareServiceCommon.isGaihaku(serviceDetail)){
            //宿泊
            case 1:
                // 集計欄の日付だけ実日数にする対策
                if (!hospitalizationDays.contains(targetDate)
                	&& QP001SpecialCase.isRealDay(serviceDetail, serviceCode)) {
                    hospitalizationDays.add(targetDate);
                }
                break;
            //外泊
            case 2:
                if(!leavingHospitalDays.contains(targetDate)){
                    leavingHospitalDays.add(targetDate);
                }
                break;
        }
    }
	//[ID:0000586][Shin Fujihara] 2010/01 edit end 2009年度対応
	
	/**
	 * 公費情報のリストを返却する。
	 * @return
	 */
	protected VRMap getKohiList(){
		return this.kohiRankMap;
	}
	
	/**
	 * 公費の適用パタンを返却します。
	 * @return
	 */
	protected VRMap getKohiPattern(){
		return this.kohiPattern;
	}
	
    /**
     * 公費対象単位数
     * @param service_unit
     */
    protected void replaceCalcRate(int service_unit){
        Iterator it = kohiPattern.keySet().iterator();
        while(it.hasNext()){
            QP001RecordSupporterCalc calc = (QP001RecordSupporterCalc)kohiPattern.get(it.next());
            calc.replaceServiceUnit(service_unit);
        }
        
    }
    
	/**
	 * 指定された公費番号の公費適用日数・回数を返却します。
	 * @param kohiType
	 * @return
	 */
	protected int getKohiCount(String kohiType){
		int result = 0;
		if(kohiApplicationTimes.containsKey(new Integer(kohiType))){
			result = ((Integer)(kohiApplicationTimes.getData(new Integer(kohiType)))).intValue();
		}
		return result;
	}
	/**
	 * サービスの実日数リストを取得します。
	 * @return
	 */
	protected VRList getRealDays(){
		return realDays;
	}
	/**
     * 入院(入所)実日数リストを返します。 
     * @return
	 */
    protected VRList getHospitalizationDays(){
        return hospitalizationDays;
    }
    /**
     * 退院(退所)実日数リストを返します。
     * @return
     */
    protected VRList getLeavingHospitalDays() {
        return leavingHospitalDays;
    }
    
    //add start fujihara.shin 2008.6.23 自動日割り展開対応
    /**
     * サービス提供実日数リストを取得します。
     */
    protected VRList getOfferDays() {
    	return offerDays;
    }
    //add end fujihara.shin 2008.6.23
    
	public String toString(){
		StringBuilder result = new StringBuilder();
		result.append("KOHI RANK\n");
		result.append(kohiRankMap);
		result.append("\n");
		result.append("SERVICE DAYS\n");
		result.append(realDays);
		result.append("\n");
		result.append("KOHI PATTERN\n");
		result.append(kohiPattern);
		result.append("\n");
		return result.toString();
	}
	
}
