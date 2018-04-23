
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

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanSjServiceCodeManager;
import jp.nichicom.ac.text.ACTextUtilities;
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
	
	
	// [H27.4改正対応][Yoichiro Kamei] 2015/4/3 add - begin サービス提供体制加算の自己負担対応
	// 回数算定時点ごとに公費種類別のカウントを保持しておく
	private Map<Integer, Object> kohiApplicationTimesPerCount = new HashMap<Integer, Object>();
	// [H27.4改正対応][Yoichiro Kamei] 2015/4/3 add - end
	
	// [H30.4改正対応][Yoichiro Kamei] 2018/4/9 add - begin
	private QP001PercentageAddInfo percentageAddInfo;
    public QP001PercentageAddInfo getPercentageAddInfo() {
    	return percentageAddInfo;
    }
	// [H30.4改正対応][Yoichiro Kamei] 2018/4/9 add - end
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
		
        // 2017/6 [Yoichiro Kamei] add - begin AF対応
        // AFで生保単独でない場合は、公費適用しない
		if (QkanSjServiceCodeManager.afCodes.contains(String.valueOf(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL")))) {
			if (!patientState.isSeihoOnly(targetDate)) {
				return;
			}
		}
		// 2017/6 [Yoichiro Kamei] add - end
        
		//公費の取得
//		VRList list = patientState.getKohiDataFromServiceKind(targetDate,systemServiceKindDetail,applicationType,1,medicalFlag);
        VRList list = patientState.getKohiDataFromServiceKind(targetDate,String.valueOf(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL")),applicationType,1,medicalFlag,manager);
		
        // [H30.4改正対応][Yoichiro Kamei] 2018/4/16 add - begin
        // 緊急時治療管理のコードの場合、applicationType=「2:緊急時施設療養管理」を指定して適用可能な公費を取得
        String serviceCodeKind = ACCastUtilities.toString(serviceCode.get("SERVICE_CODE_KIND"), "");
        String serviceCodeItem = ACCastUtilities.toString(serviceCode.get("SERVICE_CODE_ITEM"), "");
        if (QP001SpecialCase.isEmergencyCode(serviceCodeKind, serviceCodeItem)) {
            list = patientState.getKohiDataFromServiceKind(targetDate,String.valueOf(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL")),"2",1,medicalFlag,manager);
        }
        // [H30.4改正対応][Yoichiro Kamei] 2018/4/16 add - end
        
		//未知のパタンであるか確認
		//シリアルを取得して同じ公費の適用パタンがないか参照
		String serial = QP001RecordSupporterCalc.getSerialId(list,patientState,targetDate,1);
		QP001RecordSupporterCalc calc = null;
		
        for(int i = 0; i < list.getDataSize(); i++) {
            VRMap kohi = (VRMap)list.getData(i);
            // [H30.4改正対応][Yoichiro Kamei] 2018/4/6 add - begin            
            String kohiType = ACCastUtilities.toString(kohi.get("KOHI_TYPE"), "");
            // 生保単独と月途中難病のパターンに対応（記載例１２－３）
            // 対象の公費タイプが100%公費の最優先順では無い場合、serialに含まれていないので
            // 含まれていない場合は適用対象外としてスキップする
            if (!serial.contains(kohiType)) {
            	continue;
            }
            // [H30.4改正対応][Yoichiro Kamei] 2018/4/6 add - end
            //公費適用順位への追加を行う
            QP001KohiKey kohiKey = new QP001KohiKey(kohi);
            if (!kohiRankMap.containsKey(kohiKey)) {
                kohiRankMap.put(kohiKey,kohi);
            }
        }
        
		//未知の公費パタンである場合
		if(!kohiPattern.containsKey(serial)){
			calc = new QP001RecordSupporterCalc(service_unit);
			//公費計算オブジェクトの追加を行う。
			kohiPattern.setData(serial,calc);
		} else {
			calc = (QP001RecordSupporterCalc)kohiPattern.getData(serial);
		}
// [Yoichiro Kamei] [公費関連修正] 2015/4/27 comment out - begin 使われていない処理をコメント化
//		calc.addTime(serviceDetail,serviceCode);
// [Yoichiro Kamei] [公費関連修正] 2015/4/27 comment out - end
		
		// [H30.4改正対応][Yoichiro Kamei] 2018/4/9 add - begin
		if (percentageAddInfo == null) {
			percentageAddInfo = new QP001PercentageAddInfo(service_unit);
		}
		percentageAddInfo.parseService(serviceCode);
		percentageAddInfo.addKihonCount(serviceCode, count);
		// [H30.4改正対応][Yoichiro Kamei] 2018/4/9 add - end
		
		//特定の公費パタンで何回適用があるかが知りたい
		for(int i = 0; i < list.getDataSize(); i++){
			VRMap kohi = (VRMap)list.getData(i);
			// [H30.4改正対応][Yoichiro Kamei] 2018/4/6 add - begin
            String kohiType = ACCastUtilities.toString(kohi.get("KOHI_TYPE"), "");
            // 生保単独と月途中難病のパターンに対応（記載例１２－３）
            // 対象の公費タイプが100%公費の最優先順では無い場合、serialに含まれていないので
            // 含まれていない場合は適用対象外としてスキップする
            if (!serial.contains(kohiType)) {
            	continue;
            }
            // [H30.4改正対応][Yoichiro Kamei] 2018/4/6 add - end
			int countTemp = count;
			//公費の設定がある場合
			QP001KohiKey kohiKey = new QP001KohiKey(kohi);
			if(kohiApplicationTimes.containsKey(kohiKey)){
                countTemp = ((Integer)kohiApplicationTimes.get(kohiKey)).intValue();
                countTemp += count;
			}
			kohiApplicationTimes.setData(kohiKey,new Integer(countTemp));
			
			// [H30.4改正対応][Yoichiro Kamei] 2018/4/9 add - begin
			percentageAddInfo.addKohiCount(serviceCode, kohiKey, count);
			// [H30.4改正対応][Yoichiro Kamei] 2018/4/9 add - end
		}
		
		// [H27.4改正対応][Yoichiro Kamei] 2015/4/3 add - begin サービス提供体制加算の自己負担対応
		// 回数算定時点の公費種類別のカウントを保持しておく
		int nowCount =  0;
		if (!kohiApplicationTimesPerCount.isEmpty()) {
			//現在保持している回数の最大値を取得
			nowCount = Collections.max(kohiApplicationTimesPerCount.keySet());
		}
		int nextCount = nowCount + count;
		kohiApplicationTimesPerCount.put(new Integer(nextCount), new VRHashMap(kohiApplicationTimes));
		// [H27.4改正対応][Yoichiro Kamei] 2015/4/3 add - end
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
	 * 指定された公費IDの公費適用日数・回数を返却します。
	 * @param kohiType
	 * @return
	 */
	protected int getKohiCount(QP001KohiKey kohiKey){
		int result = 0;
		if(kohiApplicationTimes.containsKey(kohiKey)){
			result = ((Integer)(kohiApplicationTimes.getData(kohiKey))).intValue();
		}
		return result;
	}
	
	
	// [H27.4改正対応][Yoichiro Kamei] 2015/4/3 add - begin サービス提供体制加算の自己負担対応
	/**
	 * 指定回数算定時点における指定公費番号の公費適用日数・回数を返却します。
	 * 
	 * @param kohiType 公費番号
	 * @param atTime 何回目の算定時における公費適用カウントを取得するか
	 * @return 指定回数算定時点における指定された公費番号の公費適用日数・回数
	 */
	protected int getKohiCountAtTime(String kohiType, int atTime){
		int result = 0;
		if (ACTextUtilities.isNullText(kohiType)) {
			return result;
		}
		Map<QP001KohiKey, Integer> kohiTimes = (Map) kohiApplicationTimesPerCount.get(atTime);
		if (kohiTimes != null && !kohiTimes.isEmpty()) {
	        for (QP001KohiKey kohiKey : kohiTimes.keySet()) {
	            if (kohiType.equals(kohiKey.getKohiType())) {
	                result = kohiTimes.get(kohiKey).intValue();
	                break;
	            }
	        }
		}
		return result;
	}
	// [H27.4改正対応][Yoichiro Kamei] 2015/4/3 add - end
	
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
