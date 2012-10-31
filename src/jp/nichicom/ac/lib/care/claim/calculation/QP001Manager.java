
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
 * プログラム 請求データ作成時マスタデータ管理 (QP001Manager)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Date;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRLinkedHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;

/**
 * 実績集計時のマスタデータを管理する。
 * 公費情報
 * 事業所情報
 * 特定診療費情報
 * を統括する。
 *
 */
public class QP001Manager {

	/**
	 * 公費情報
	 */
	private VRMap kohiData = new VRLinkedHashMap();
	/**
	 * 公費-サービスコード対応表
	 */
	private VRMap kohiServiceData = new VRLinkedHashMap();
	/**
	 * 事業所情報
	 */
	private VRMap providerMap = new VRHashMap();
	/**
	 * 単位数単価マスタを取得
	 */
	private VRMap areaUnitMap = new VRHashMap();
	
	/**
	 * 事業者詳細情報
	 */
	private VRMap providerDetailMap = new VRHashMap();
	
	/**
	 * 事業所割引率情報
	 */
	private VRMap providerServiceMap = new VRHashMap();
	
	/**
	 * 特定診療費情報
	 */
	//[ID:0000454][Shin Fujihara] 2009/05/01 edit begin 障害対応
	//private VRMap specialClinicData = new VRLinkedHashMap();
	private VRList specialClinicData = new VRArrayList();
	//[ID:0000454][Shin Fujihara] 2009/05/01 edit end 障害対応
    
    /**
     * サービス名称
     */
    private VRMap serviceName = new VRHashMap();
    
    /**
     * 保険者名称
     */
    private VRMap insurer = new VRHashMap();
	
    //[H20.4 法改正対応] fujihara add start
    //サービス提供年月
    private Date targetDate = null;
    //[H20.4 法改正対応] fujihara add end
    
    // [ID:0000641][Shin Fujihara] 2011/04/14 add begin
    // M_RESIDENCE_FOOD_COSTから取得した、食費・居住費の情報
    private VRMap residenceFoodCost = new VRHashMap();
    // [ID:0000641][Shin Fujihara] 2011/04/14 add end
	
    
    
	/**
	 * コンストラクタ
	 * マスタデータの初期化を行う。
	 * @param dbm
	 */
	public QP001Manager(ACDBManager dbm,Date targetDate) throws Exception {
		//公費情報の初期化
		//[ID:0000465][Shin Fujihara] 2009/04 add begin 平成21年4月法改正対応
		//initializationKohi(dbm);
		initializationKohi(dbm,targetDate);
		//[ID:0000465][Shin Fujihara] 2009/04 add end 平成21年4月法改正対応
		
		//事業所情報の初期化
		//[ID:0000458][Shin Fujihara] 2009/03/13 edit begin 障害対応
		//initializationProvider(dbm);
		initializationProvider(dbm,targetDate);
		//[ID:0000458][Shin Fujihara] 2009/03/13 edit end 障害対応
		
		//特定診療費情報の初期化
		initializationSpecialClinic(dbm,targetDate);
        
        //サービス名称の初期化
        initializationServiceName(dbm);
        
        //保険者名称の初期化
        initializationInsurerName(dbm);
        
        //[H20.4 法改正対応] fujihara add start
        this.targetDate = targetDate;
        //[H20.4 法改正対応] fujihara add end
	}
	
	/**
	 * 公費情報の初期化を行います。
	 * @param dbm
	 * @throws Exception
	 */
	//[ID:0000465][Shin Fujihara] 2009/04 add begin 平成21年4月法改正対応
	//private void initializationKohi(ACDBManager dbm) throws Exception {
	private void initializationKohi(ACDBManager dbm, Date targetDate) throws Exception {
	//[ID:0000465][Shin Fujihara] 2009/04 add end 平成21年4月法改正対応
		
      	//[ID:0000465][Shin Fujihara] 2009/04 add begin 平成21年4月法改正対応
		String targetStart = VRDateParser.format(ACDateUtilities.toFirstDayOfMonth(targetDate), "yyyy/MM/dd");
		String targetEnd = VRDateParser.format(ACDateUtilities.toLastDayOfMonth(targetDate), "yyyy/MM/dd");
      	//[ID:0000465][Shin Fujihara] 2009/04 add end 平成21年4月法改正対応
		
		
		StringBuilder sb = new StringBuilder();
		//公費マスタ取得
		sb.append(" SELECT");
		sb.append(" KOHI_TYPE,");
		sb.append(" KOHI_LAW_NO,");
		sb.append(" KOHI_NAME,");
		sb.append(" KOHI_ABBREVIATION,");
		sb.append(" KOHI_SORT,");
		sb.append(" BENEFIT_RATE,");
		sb.append(" CITY_CLAIM_FLAG,");
		sb.append(" INSURE_TYPE");
		sb.append(" FROM");
		sb.append(" M_KOHI");
		//[ID:0000465][Shin Fujihara] 2009/04 add begin 平成21年4月法改正対応
		sb.append(" WHERE");
		sb.append(" (KOHI_VALID_START  <='" + targetEnd + "')");
		sb.append(" AND (KOHI_VALID_END  >= '" + targetStart + "')");
		//[ID:0000465][Shin Fujihara] 2009/04 add end 平成21年4月法改正対応
		sb.append(" ORDER BY KOHI_SORT ASC");
		
		VRList list = dbm.executeQuery(sb.toString());
		
		
		ACBindUtilities.setMapFromArray(list,kohiData,"KOHI_TYPE");
		
		//公費-サービスマスタ取得
		sb = new StringBuilder();
		
		sb.append(" SELECT");
		sb.append(" KOHI_TYPE || SYSTEM_SERVICE_KIND_DETAIL || APPLICATION_TYPE AS CODE,");
		sb.append(" KOHI_TYPE,");
		sb.append(" SYSTEM_SERVICE_KIND_DETAIL,");
		sb.append(" APPLICATION_TYPE,");
		sb.append(" BY_MEDICAL_FLAG");
		sb.append(" FROM");
		sb.append(" M_KOHI_SERVICE");
		//[ID:0000465][Shin Fujihara] 2009/04 add begin 平成21年4月法改正対応
		sb.append(" WHERE");
		sb.append(" (KOHI_SERVICE_VALID_START  <='" + targetEnd + "')");
		sb.append(" AND (KOHI_SERVICE_VALID_END  >= '" + targetStart + "')");
		//[ID:0000465][Shin Fujihara] 2009/04 add end 平成21年4月法改正対応
		
		list = dbm.executeQuery(sb.toString());
		
		ACBindUtilities.setMapFromArray(list,kohiServiceData,"CODE");
	}
	
	/**
	 * 事業所情報の初期化
	 * @param dbm
	 * @throws Exception
	 */
	//[ID:0000458][Shin Fujihara] 2009/03/13 edit begin 障害対応
	//private void initializationProvider(ACDBManager dbm) throws Exception {
	private void initializationProvider(ACDBManager dbm, Date targetDate) throws Exception {
	//[ID:0000458][Shin Fujihara] 2009/03/13 edit end 障害対応
		//事業所情報の取得
		VRList providerList = QkanCommon.getProviderInfo(dbm);
		//事業所情報を検索用にMapに展開
      	ACBindUtilities.setMapFromArray(providerList,providerMap,"PROVIDER_ID");
      	//事業所情報詳細
      	for(int i = 0; i < providerList.getDataSize(); i++){
      		VRMap providerTemp = (VRMap)providerList.getData(i);
      		String providerId = ACCastUtilities.toString(VRBindPathParser.get("PROVIDER_ID",providerTemp));
      		//
      		VRList list = QkanCommon.getProviderServiceDetail(dbm, providerId);
      		VRMap map = new VRHashMap();
            ACBindUtilities.setMapFromArray(list,map,"SYSTEM_SERVICE_KIND_DETAIL");
      		providerDetailMap.put(providerId,map);
      	}
      	
      	//[ID:0000458][Shin Fujihara] 2009/03/13 add begin 障害対応
		Date targetDateStart = ACDateUtilities.toFirstDayOfMonth(targetDate);
		Date targetDateEnd = ACDateUtilities.toLastDayOfMonth(targetDate);
      	//[ID:0000458][Shin Fujihara] 2009/03/13 add end 障害対応
      	
      	//単価マスタの取得
      	StringBuilder sb = new StringBuilder();
      	sb.append(" SELECT");
      	sb.append(" (SYSTEM_SERVICE_KIND_DETAIL || UNIT_PRICE_TYPE) AS CODE,");
      	sb.append(" SYSTEM_SERVICE_KIND_DETAIL,");
      	sb.append(" UNIT_PRICE_TYPE,");
      	sb.append(" UNIT_VALID_START,");
      	sb.append(" UNIT_VALID_END,");
      	sb.append(" UNIT_PRICE_VALUE");
      	sb.append(" FROM");
      	sb.append(" M_AREA_UNIT_PRICE");
      	
      	//[ID:0000458][Shin Fujihara] 2009/03/13 add begin 障害対応
		sb.append(" WHERE");
		sb.append(" (UNIT_VALID_START  <='" + VRDateParser.format(targetDateEnd,"yyyy/MM/dd") + "')");
		sb.append(" AND (UNIT_VALID_END  >= '" + VRDateParser.format(targetDateStart,"yyyy/MM/dd") + "')");
		//[ID:0000458][Shin Fujihara] 2009/03/13 add end 障害対応
      	
      	ACBindUtilities.setMapFromArray(dbm.executeQuery(sb.toString()),areaUnitMap,"CODE");
      	
      	//事業所の割引率の取得
      	sb = new StringBuilder();
      	sb.append(" SELECT");
      	sb.append(" PROVIDER_ID || SYSTEM_SERVICE_KIND_DETAIL AS CODE");
      	sb.append(" ,PROVIDER_ID");
      	sb.append(" ,SYSTEM_SERVICE_KIND_DETAIL");
      	sb.append(" ,REDUCT_RATE");
      	sb.append(" FROM");
      	sb.append(" PROVIDER_SERVICE");
      	
      	ACBindUtilities.setMapFromArray(dbm.executeQuery(sb.toString()),providerServiceMap,"CODE");
      	
      	// [ID:0000641][Shin Fujihara] 2011/04/14 add begin
      	// 食費・居住費の基準額を取得
      	sb = new StringBuilder();
      	sb.append(" SELECT");
      	sb.append(" RESIDENCE_FOOD_COST_ID");
      	sb.append(" ,RESIDENCE_FOOD_COST");
      	sb.append(" FROM");
      	sb.append(" M_RESIDENCE_FOOD_COST");
        sb.append(" WHERE");
        sb.append("(");
        sb.append(" RESIDENCE_FOOD_COST_VALID_START");
        sb.append(" <='");
        sb.append(VRDateParser.format(targetDateEnd,"yyyy/MM/dd"));
        sb.append("')");
        sb.append("AND");
        sb.append("(");
        sb.append(" RESIDENCE_FOOD_COST_VALID_END");
        sb.append(" >='");
        sb.append(VRDateParser.format(targetDateStart,"yyyy/MM/dd"));
        sb.append("')");
      	
      	ACBindUtilities.setMapFromArray(dbm.executeQuery(sb.toString()),residenceFoodCost,"RESIDENCE_FOOD_COST_ID");
      	// [ID:0000641][Shin Fujihara] 2011/04/14 add end
  	
	}
	
	/**
	 * 特定診療費情報の初期化を行います。
	 * @param dbm
	 * @param targetDate
	 * @throws Exception
	 */
	private void initializationSpecialClinic(ACDBManager dbm,Date targetDate) throws Exception {
		//[ID:0000454][Shin Fujihara] 2009/05/01 delete begin 障害対応
		/*
		StringBuilder sb = new StringBuilder();
		Date targetDateStart = ACDateUtilities.toFirstDayOfMonth(targetDate);
		Date targetDateEnd = ACDateUtilities.toLastDayOfMonth(targetDate);
		
		sb.append(" SELECT");
		//[H20.5 法改正対応] fujihara edit start
		//sb.append(" SPECIAL_CLINIC_TYPE");
		sb.append(" RECORD_TYPE || '-' || SPECIAL_CLINIC_TYPE AS KEY_VALUE");
		//[H20.5 法改正対応] fujihara edit end
		sb.append(" ,SPECIAL_CLINIC_NAME");
		sb.append(" ,SPECIAL_CLINIC_UNIT");
		sb.append(" FROM");
		sb.append(" M_SPECIAL_CLINIC");
		sb.append(" WHERE");
		sb.append(" (SPECIAL_CLINIC_VALID_START <='" + VRDateParser.format(targetDateEnd,"yyyy/MM/dd") + "')");
		sb.append(" AND (SPECIAL_CLINIC_VALID_END >= '" + VRDateParser.format(targetDateStart,"yyyy/MM/dd") + "')");
		//[H20.5 法改正対応] fujihara edit start
		//ACBindUtilities.setMapFromArray(dbm.executeQuery(sb.toString()),specialClinicData,"SPECIAL_CLINIC_TYPE");
		ACBindUtilities.setMapFromArray(dbm.executeQuery(sb.toString()),specialClinicData,"KEY_VALUE");
		//[H20.5 法改正対応] fujihara edit end
		*/
		//[ID:0000454][Shin Fujihara] 2009/05/01 delete end 障害対応
		//[ID:0000454][Shin Fujihara] 2009/05/01 add begin 障害対応
		StringBuilder sb = new StringBuilder();
		
		sb.append(" SELECT");
		sb.append(" SPECIAL_CLINIC_TYPE");
		sb.append(" ,RECORD_TYPE");
		sb.append(" ,SPECIAL_CLINIC_NAME");
		sb.append(" ,SPECIAL_CLINIC_UNIT");
		sb.append(" ,SPECIAL_CLINIC_VALID_START");
		sb.append(" ,SPECIAL_CLINIC_VALID_END");
		sb.append(" FROM");
		sb.append(" M_SPECIAL_CLINIC");
		specialClinicData = dbm.executeQuery(sb.toString());
		//[ID:0000454][Shin Fujihara] 2009/05/01 add end 障害対応
	}
    
    private void initializationServiceName(ACDBManager dbm) throws Exception {
        StringBuilder sb = new StringBuilder();
        
        sb.append(" SELECT");
        sb.append(" SERVICE_CODE_KIND,");
        sb.append(" SERVICE_NAME,");
        sb.append(" SERVICE_ABBREVIATION,");
        sb.append(" SERVICE_KIND_NAME,");
        sb.append(" SERVICE_CALENDAR_ABBREVIATION");
        sb.append(" FROM");
        sb.append(" M_SERVICE");
        sb.append(" WHERE");
        sb.append(" SERVICE_CODE_KIND IS NOT NULL");
        
        ACBindUtilities.setMapFromArray(dbm.executeQuery(sb.toString()),serviceName,"SERVICE_CODE_KIND");
    }
    
    private void initializationInsurerName(ACDBManager dbm) throws Exception {
        StringBuilder sb = new StringBuilder();
        
        sb.append(" SELECT");
        sb.append(" INSURER_ID,");
        sb.append(" INSURER_NAME");
        sb.append(" FROM");
        sb.append(" INSURER");
        
        ACBindUtilities.setMapFromArray(dbm.executeQuery(sb.toString()),insurer,"INSURER_ID");
    }
	
	/*==================================================
	    公費関連
	====================================================*/
	/**
	 * 指定された公費タイプの給付率を返却します。
	 * @param kohiType 取得する公費タイプ
	 * @return
	 * @throws Exception
	 */
    /* 利用者の情報から取得するよう変更
	public int getBenefitRate(String kohiType) throws Exception{
		int result = 0;
		
		VRMap map = getKohiMap(kohiType);
		if(map != null){
			result = Integer.parseInt(String.valueOf(VRBindPathParser.get("BENEFIT_RATE", map)));
		}
		return result;
	}
    */
	
	/**
	 * 公費タイプとシステム内のサービスコードから該当する公費の情報を返却します。
	 * 該当公費が存在しない場合はnullを返却します。
	 * @param kohiType
	 * @param systemServiceKindDetail
	 * @param applicationType
	 * @return
	 * @throws Exception
	 */
	public VRMap getKohiMatchData(String kohiType, String systemServiceKindDetail,String applicationType) throws Exception {
        VRMap result = null;
		String key = kohiType + systemServiceKindDetail + applicationType;
		//M_KOHI_SERVICEのKOHI_TYPE,SYSTEM_SERVICE_KIND_DETAILを
		//参照し、該当サービスが存在するかチェック
		if(kohiServiceData.containsKey(key)){
            result = (VRMap)VRBindPathParser.get(new Integer(kohiType),kohiData);
            result.put("BY_MEDICAL_FLAG", ((VRMap)kohiServiceData.get(key)).get("BY_MEDICAL_FLAG"));
            result.put("APPLICATION_TYPE", ((VRMap)kohiServiceData.get(key)).get("APPLICATION_TYPE"));
        }
		//公費の詳細情報を取得
		return result;
		
	}
	/**
	 * 公費順位を取得する。
	 * @param kohiType
	 * @return
	 * @throws Exception
	 */
	public int getKohiSortNo(String kohiType) throws Exception {
		int result = Integer.MAX_VALUE;
		
		VRMap map = getKohiMap(kohiType);
		if(map != null){
			result = Integer.parseInt(String.valueOf(VRBindPathParser.get("KOHI_SORT", map)));
		}
		return result;
	}
    
    /**
     * 公費マスタより情報を取得する。
     * @param kohiType 公費タイプ
     * @param key 取得するフィールド名称
     * @return
     * @throws Exception
     */
    public String getKohiData(String kohiType,String key) throws Exception {
        VRMap map = getKohiMap(kohiType);
        if(map == null) return "";
        if(!map.containsKey(key)) return "";
        
        return String.valueOf(map.get(key));
    }
	
	private VRMap getKohiMap(String kohiType) throws Exception {
		
		if((kohiType == null) || ("".equals(kohiType))) return null;
		
		return (VRMap)VRBindPathParser.get(new Integer(kohiType), kohiData);
	}
	
	/*==============================================================
	   事業所関連
	================================================================*/
	/**
	 * 指定した事業所の特別地域加算フラグを取得する。
	 * @param providerId
	 * @return
	 * @throws Exception
	 */
    public String getSpecialAreaFlag(String providerId) throws Exception {
		return ACCastUtilities.toString(VRBindPathParser.get((providerId) + "/SPECIAL_AREA_FLAG",providerMap));
	}
	/**
	 * 指定した事業所の事業所名称を取得する。
	 * @param providerId
	 * @return
	 * @throws Exception
	 */
	
	protected String getProviderName(String providerId) throws Exception {
		return ACCastUtilities.toString(VRBindPathParser.get((providerId) + "/PROVIDER_NAME",providerMap));
	}
	/**
	 * 指定した事業所の住所を取得する。
	 * @param providerId
	 * @return
	 * @throws Exception
	 */
	protected String getProviderAddress(String providerId) throws Exception {
		return ACCastUtilities.toString(VRBindPathParser.get((providerId) + "/PROVIDER_ADDRESS",providerMap));
	}
	/**
	 * 指定した事業所の電話番号を取得する。
	 * @param providerId
	 * @return
	 * @throws Exception
	 */
	protected String getProviderTel(String providerId) throws Exception {
		return ACCastUtilities.toString(VRBindPathParser.get((providerId) + "/PROVIDER_TEL_FIRST",providerMap)) + "-" +
		ACCastUtilities.toString(VRBindPathParser.get((providerId) + "/PROVIDER_TEL_SECOND",providerMap)) + "-" +
		ACCastUtilities.toString(VRBindPathParser.get((providerId) + "/PROVIDER_TEL_THIRD",providerMap));
	}
	/**
	 * 指定した事業所の事業区分を取得する。<br>
	 * 1-指定 2-基準該当
	 * @param providerId
	 * @return
	 * @throws Exception
	 */
	protected int getProviderJigyouType(String providerId) throws Exception {
		return ACCastUtilities.toInt(VRBindPathParser.get((providerId) + "/PROVIDER_JIGYOU_TYPE",providerMap));
	}
    
    /**
     * 指定した事業所の入用期間フラグを取得する。<br>
     * 1-医療機関 0-それ以外
     * @param providerId 事業所番号
     * @return 取得した医療機関フラグ
     * @throws Exception
     */
    protected int getProviderMedicalFlag(String providerId) throws Exception {
        return ACCastUtilities.toInt(VRBindPathParser.get((providerId) + "/MEDICAL_FLAG",providerMap));
    }
	
	/**
	 * 事業所のステーションコードを取得する。
	 * @param providerId
	 * @return
	 * @throws Exception
	 */
	protected String getStationCode(String providerId) throws Exception {
		String result = "";
		if(providerDetailMap == null) return result;
		if(!providerDetailMap.containsKey(providerId)) return result;
		
		VRMap map = (VRMap)providerDetailMap.get(providerId);
		
		if(map == null) return result;
        
        if(!map.containsKey(new Integer("11311"))) return result;
        
		return ACCastUtilities.toString(((VRMap)map.get(new Integer("11311"))).get("2010101"));
	}
    
    /**
     * 事業所に登録されているホテルコストを取得します。
     * @param providerId 事業所番号
     * @param serviceCodeItem サービスコード 
     * @return 登録されているホテルコスト
     * @throws Exception
     */
    protected int getHotelUnit(String providerId,String systemServiceKindDetail, String serviceCodeItem) throws Exception {
        int unit = Integer.MIN_VALUE;
        
        if(providerDetailMap == null) return unit;
        if(!providerDetailMap.containsKey(providerId)) return unit;
        
        VRMap map = (VRMap)providerDetailMap.get(providerId);
        
        if(map == null) return unit;
        
        if(!map.containsKey(new Integer(systemServiceKindDetail))) return unit;
        
        VRMap detail = (VRMap)map.get(new Integer(systemServiceKindDetail));
        
        Object unitData = null;
        
        switch(ACCastUtilities.toInt(serviceCodeItem,0)){
        //短期生活ユニット型個室
        case 2121:
        //短期老健ユニット型個室
        case 2221:
        //短期療養ユニット型個室
        case 2321:
        //福祉施設ユニット型個室
        case 5121:
        //保健施設ユニット型個室
        case 5221:
        //療養施設ユニット型個室
        case 5321:
        //地域福祉施設ユニット型個室
        case 5421:
            if(detail.containsKey("1210112")){
                unitData = detail.get("1210112");
            } else if(detail.containsKey("1220113")){
                unitData = detail.get("1220113");
            } else if(detail.containsKey("1230114")){
                unitData = detail.get("1230114");
            } else if(detail.containsKey("1230212")){
                unitData = detail.get("1230212");
            } else if(detail.containsKey("1230311")){
                unitData = detail.get("1230311");
            } else if(detail.containsKey("1230409")){
                unitData = detail.get("1230409");
            } else if(detail.containsKey("1510117")){
                unitData = detail.get("1510117");
            } else if(detail.containsKey("1520114")){
                unitData =detail.get("1520114");
            } else if(detail.containsKey("1530115")){
                unitData = detail.get("1530115");
            } else if(detail.containsKey("1530213")){
                unitData = detail.get("1530213");
            } else if(detail.containsKey("1530312")){
                unitData = detail.get("1530312");
            } else if(detail.containsKey("1540121")){
                unitData = detail.get("1540121");
            }
            break;
            
            
        //短期生活ユニット型準個室
        case 2122:
        //短期老健ユニット型準個室
        case 2222:
        //短期療養ユニット型準個室
        case 2322:
        //福祉施設ユニット型準個室
        case 5122:
        //保健施設ユニット型準個室
        case 5222:
        //療養施設ユニット型準個室
        case 5322:
        //地域福祉施設ユニット型準個室
        case 5422:
            if(detail.containsKey("1210113")){
                unitData = detail.get("1210113");
            } else if(detail.containsKey("1220114")){
                unitData = detail.get("1220114");
            } else if(detail.containsKey("1230115")){
                unitData = detail.get("1230115");
            } else if(detail.containsKey("1230213")){
                unitData = detail.get("1230213");
            } else if(detail.containsKey("1230312")){
                unitData = detail.get("1230312");
            } else if(detail.containsKey("1230410")){
                unitData = detail.get("1230410");
            } else if(detail.containsKey("1510118")){
                unitData = detail.get("1510118");
            } else if(detail.containsKey("1520115")){
                unitData = detail.get("1520115");
            } else if(detail.containsKey("1530116")){
                unitData = detail.get("1530116");
            } else if(detail.containsKey("1530214")){
                unitData = detail.get("1530214");
            } else if(detail.containsKey("1530313")){
                unitData = detail.get("1530313");
            } else if(detail.containsKey("1540122")){
                unitData = detail.get("1540122");
            }
            
            break;
        //短期生活従来型個室
        case 2123:
        //短期老健従来型個室
        case 2223:
        //短期療養従来型個室
        case 2323:
        //福祉施設従来型個室
        case 5123:
        //保健施設従来型個室
        case 5223:
        //療養施設従来型個室
        case 5323:
        //地域福祉施設従来型個室
        case 5423:
            if(detail.containsKey("1210114")){
                unitData = detail.get("1210114");
            } else if(detail.containsKey("1220115")){
                unitData = detail.get("1220115");
            } else if(detail.containsKey("1230116")){
                unitData = detail.get("1230116");
            } else if(detail.containsKey("1230214")){
                unitData = detail.get("1230214");
            } else if(detail.containsKey("1230313")){
                unitData = detail.get("1230313");
            } else if(detail.containsKey("1230411")){
                unitData = detail.get("1230411");
            } else if(detail.containsKey("1510119")){
                unitData = detail.get("1510119");
            } else if(detail.containsKey("1520116")){
                unitData = detail.get("1520116");
            } else if(detail.containsKey("1530117")){
                unitData = detail.get("1530117");
            } else if(detail.containsKey("1530215")){
                unitData = detail.get("1530215");
            } else if(detail.containsKey("1530314")){
                unitData = detail.get("1530314");
            } else if(detail.containsKey("1540123")){
                unitData = detail.get("1540123");
            }
            
            break;
            
        //短期生活多床室
        case 2124:
        //短期老健多床室
        case 2224:
        //短期療養多床室
        case 2324:
        //福祉施設多床室
        case 5124:
        //保健施設多床室
        case 5224:
        //療養施設多床室
        case 5324:
        //地域福祉施設多床室
        case 5424:
            if(detail.containsKey("1210115")){
                unitData = detail.get("1210115");
            } else if(detail.containsKey("1220116")){
                unitData = detail.get("1220116");
            } else if(detail.containsKey("1230117")){
                unitData = detail.get("1230117");
            } else if(detail.containsKey("1230215")){
                unitData = detail.get("1230215");
            } else if(detail.containsKey("1230314")){
                unitData = detail.get("1230314");
            } else if(detail.containsKey("1230412")){
                unitData = detail.get("1230412");
            } else if(detail.containsKey("1510120")){
                unitData = detail.get("1510120");
            } else if(detail.containsKey("1520117")){
                unitData = detail.get("1520117");
            } else if(detail.containsKey("1530118")){
                unitData = detail.get("1530118");
            } else if(detail.containsKey("1530216")){
                unitData = detail.get("1530216");
            } else if(detail.containsKey("1530315")){
                unitData = detail.get("1530315");
            } else if(detail.containsKey("1540124")){
                unitData = detail.get("1540124");
            }
            
            break;
            
            
        //[ID:0000641][Shin Fujihara] 2011/04/13 add begin 予防サービスの室料取得漏れ
        // 予防短期生活ユニット型個室
        case 2421:
        	if(detail.containsKey("1240112")){
                unitData = detail.get("1240112");
            }
        	break;
        // 予防短期生活ユニット型準個室
        case 2422:
        	if(detail.containsKey("1240113")){
                unitData = detail.get("1240113");
            }
        	break;
        // 予防短期生活従来型個室
        case 2423:
        	if(detail.containsKey("1240114")){
                unitData = detail.get("1240114");
            }
        	break;
        // 予防短期生活多床室
        case 2424:
        	if(detail.containsKey("1240115")){
                unitData = detail.get("1240115");
            }
        	break;
        	
        	
        // 予防短期老健ユニット型個室
        case 2521:
        	if(detail.containsKey("1250112")){
                unitData = detail.get("1250112");
            }
        	break;
        // 予防短期老健ユニット型準個室
        case 2522:
        	if(detail.containsKey("1250113")){
                unitData = detail.get("1250113");
            }
        	break;
        // 予防短期生活従来型個室
        case 2523:
        	if(detail.containsKey("1250114")){
                unitData = detail.get("1250114");
            }
        	break;
        // 予防短期生活多床室
        case 2524:
        	if(detail.containsKey("1250115")){
                unitData = detail.get("1250115");
            }
        	break;
        	
        	
        // 予防短期療養ユニット型個室
        case 2621:
        	// 介護予防短期入所療養介護_病院療養
        	if(detail.containsKey("1260114")){
                unitData = detail.get("1260114");
            // 短期入所療養介護_診療所療養
            } else if(detail.containsKey("1260211")){
                unitData = detail.get("1260211");
            // 短期入所療養介護_認知症疾患
            } else if(detail.containsKey("1260311")){
                unitData = detail.get("1260311");
            }
        	break;
        // 予防短期療養ユニット型準個室
        case 2622:
        	// 介護予防短期入所療養介護_病院療養
        	if(detail.containsKey("1260115")){
                unitData = detail.get("1260115");
            // 短期入所療養介護_診療所療養
            } else if(detail.containsKey("1260212")){
                unitData = detail.get("1260212");
            // 短期入所療養介護_認知症疾患
            } else if(detail.containsKey("1260312")){
                unitData = detail.get("1260312");
            }
        	break;
        // 予防短期療養従来型個室
        case 2623:
        	// 介護予防短期入所療養介護_病院療養
        	if(detail.containsKey("1260116")){
                unitData = detail.get("1260116");
            // 短期入所療養介護_診療所療養
            } else if(detail.containsKey("1260213")){
                unitData = detail.get("1260213");
            // 短期入所療養介護_認知症疾患
            } else if(detail.containsKey("1260313")){
                unitData = detail.get("1260313");
            }
        	break;
        // 予防短期療養多床室
        case 2624:
        	// 介護予防短期入所療養介護_病院療養
        	if(detail.containsKey("1260117")){
                unitData = detail.get("1260117");
            // 短期入所療養介護_診療所療養
            } else if(detail.containsKey("1260214")){
                unitData = detail.get("1260214");
            // 短期入所療養介護_認知症疾患
            } else if(detail.containsKey("1260314")){
                unitData = detail.get("1260314");
            }
        	break;
        //[ID:0000641][Shin Fujihara] 2011/04/13 add end 予防サービスの室料取得漏れ
        }
        
        if(unitData != null){
            unit = ACCastUtilities.toInt(unitData,Integer.MIN_VALUE);
        }
        
        return unit;
    }
    
    /**
     * 指定された事業所が指定されたサービスを社福減免の対象としているか。
     * @param providerId
     * @param systemServiceCode
     * @return
     * @throws Exception
     */
    protected boolean isReduction(String providerId, String systemServiceCode) throws Exception {
        VRMap map = (VRMap)providerDetailMap.get(providerId);
        //事業所詳細情報の取得確認
        if(map == null){
            return false;
        }
        
        VRMap detail = (VRMap)map.get(new Integer(systemServiceCode));
        
        //該当のシステムサービスコードの詳細取得確認
        if(detail == null){
            return false;
        }
        
        //社福減免チェックのデータを保持しているか確認
        if(!detail.containsKey("1")) return false;
        
        if(ACCastUtilities.toInt(detail.get("1"),1) != 2){
            return false;
        }
        
        return true;
    }
	
	
	/**
	 * 指定した事業所の地域単価を取得します。
	 * @return
	 * @throws Exception
	 */
	protected double getAreaUnitPrice(String providerId,String systemServiceKindDetail, String targetDateMonth) throws Exception {
		
		//事業所のPROVIDER_AREA_TYPEを取得し、検索キーとする
		String key = systemServiceKindDetail + ACCastUtilities.toString(VRBindPathParser.get((providerId) + "/PROVIDER_AREA_TYPE",providerMap));
		//int target = Integer.parseInt(targetDateMonth) * 100 + 1;
		
		if(!areaUnitMap.containsKey(key)) {
			return 0;
		}
		VRMap map = (VRMap)VRBindPathParser.get(key,areaUnitMap);
		return Double.parseDouble(String.valueOf(VRBindPathParser.get("UNIT_PRICE_VALUE",map)));
		
		//[ID:0000458][Shin Fujihara] 2009/03/13 delete begin 障害対応
		/*
		while(true){
			if(!areaUnitMap.containsKey(key)) break;
			VRMap map = (VRMap)VRBindPathParser.get(key,areaUnitMap);
			
			int start = getInt("UNIT_VALID_START",map);
			int end = getInt("UNIT_VALID_END",map);
			
			//発見
			if((start <= target) && (target <= end)){
				return Double.parseDouble(String.valueOf(VRBindPathParser.get("UNIT_PRICE_VALUE",map)));
			}
		}
		
		return 0;
		*/
		//[ID:0000458][Shin Fujihara] 2009/03/13 delete end 障害対応
	}
	
	/**
	 * 割引率を考慮したサービス単位数を返却します。
	 * @return サービス単位数
	 */
	protected int getServiceUnit(String providerId, VRMap serviceCode) throws Exception {
		//providerServiceMap
		int reductRate = getReductRate(providerId,serviceCode);
		int unit = ACCastUtilities.toInt(VRBindPathParser.get("SERVICE_UNIT",serviceCode));
        
        /*別関数に切り出し(摘要欄に割引率を記載する必要があるため)
		String key = providerId +
			           ACCastUtilities.toString(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL",serviceCode));
		
		if(providerServiceMap.containsKey(key)){
			VRMap map = (VRMap)providerServiceMap.get(key);
            if(!ACTextUtilities.isNullText(map.get("REDUCT_RATE"))){
                reductRate = ACCastUtilities.toInt(map.get("REDUCT_RATE"));
            }
		}
        */
        //四捨五入の誤り
		//return (int)Math.ceil(unit * ((double)(100 - reductRate)/100));
        return (int)Math.round((double)unit * ((double)(100 - reductRate)/100d));
	}
    
    
    /**
     * サービスの割引率を取得する。
     * @param providerId 事業所番号
     * @param serviceCode サービスコードオブジェクト
     * @return 取得した割引率
     * @throws Exception
     */
    protected int getReductRate(String providerId, VRMap serviceCode) throws Exception {
        int reductRate = 0;
        String key = providerId
                + ACCastUtilities.toString(VRBindPathParser.get(
                        "SYSTEM_SERVICE_KIND_DETAIL", serviceCode));

        if (providerServiceMap.containsKey(key)) {
            VRMap map = (VRMap) providerServiceMap.get(key);
            if (!ACTextUtilities.isNullText(map.get("REDUCT_RATE"))) {
                reductRate = ACCastUtilities.toInt(map.get("REDUCT_RATE"));
            }
        }
        return reductRate;
    }
    
    
    //[ID:0000462][Shin Fujihara] 2009/04 add begin 平成21年4月法改正対応
    /**
     * 事業所が中山間地域の小規模事業所であるかのコードを取得する。
     * @param serviceDetail
     * @return
     * 1:中山間でない
     * 2:中山間である
     * @throws Exception
     */
    protected String getChusankanChiikiCode(VRMap serviceDetail) throws Exception {
    	/*
		String result = "";
		if(providerDetailMap == null) return result;
		if(!providerDetailMap.containsKey(providerId)) return result;
		
		VRMap map = (VRMap)providerDetailMap.get(providerId);
		
		if(map == null) return result;
        
        if(!map.containsKey(new Integer("11311"))) return result;
        
		return ACCastUtilities.toString(((VRMap)map.get(new Integer("11311"))).get("2010101"));
    	*/
    	
    	String result = "1";
    	if (providerDetailMap == null) return result;
    	if (!serviceDetail.containsKey("PROVIDER_ID")) return result;
    	if (!providerDetailMap.containsKey(serviceDetail.get("PROVIDER_ID"))) return result;
    	
    	VRMap providerDetail = (VRMap)providerDetailMap.get(serviceDetail.get("PROVIDER_ID"));
    	
    	if (providerDetail == null) return result;
    	
    	if (!providerDetail.containsKey(serviceDetail.get("SYSTEM_SERVICE_KIND_DETAIL"))) return result;
    	
    	VRMap map = (VRMap)providerDetail.get(serviceDetail.get("SYSTEM_SERVICE_KIND_DETAIL"));
    	
    	if (map == null) return result;
    	
        if ((ACCastUtilities.toInt(map.get("2"), 0) == 2)
                && (ACCastUtilities.toInt(map.get("3"), 0) == 2)) {
        	result = "2";
        }
    	
    	
    	return result;
    }
    //[ID:0000462][Shin Fujihara] 2009/04 add end 平成21年4月法改正対応
    
	//[ID:0000682][Shin Fujihara] add begin 【法改正対応】介護職員処遇改善加算
    protected String getSyoguFlag(VRMap serviceDetail) throws Exception {
        
        String result = "1";
        if (providerDetailMap == null) return result;
        if (!serviceDetail.containsKey("PROVIDER_ID")) return result;
        if (!providerDetailMap.containsKey(serviceDetail.get("PROVIDER_ID"))) return result;
        
        VRMap providerDetail = (VRMap)providerDetailMap.get(serviceDetail.get("PROVIDER_ID"));
        
        if (providerDetail == null) return result;
        
        if (!providerDetail.containsKey(serviceDetail.get("SYSTEM_SERVICE_KIND_DETAIL"))) return result;
        
        VRMap map = (VRMap)providerDetail.get(serviceDetail.get("SYSTEM_SERVICE_KIND_DETAIL"));
        
        if (map == null) return result;
        
        if (map.containsKey("4")){
            result = ACCastUtilities.toString(map.get("4"), result);
        }
        
        
        return result;
    }
    //[ID:0000682][Shin Fujihara] add end 【法改正対応】介護職員処遇改善加算
    
	/**
	 * 強制的にintに変換する。
	 * @param key
	 * @param map
	 * @return
	 * @throws Exception
	 */
	private int getInt(String key,VRMap map) throws Exception {
		String target = String.valueOf(VRBindPathParser.get(key,map));
		target = target.replaceAll("-|/","");
		
		return Integer.parseInt(target);
	}
	
	
	/*=============================================================
	    特定診療費情報
	=============================================================*/
	//[ID:0000454][Shin Fujihara] 2009/05/01 delete begin 障害対応
	//[H20.5 法改正対応] fujihara edit start
//    public String getSpecialClinicName(String specialClinicType) throws Exception {
//    	return getSpecialClinicName(specialClinicType,1);
//    }
//    public String getSpecialClinicName(String specialClinicType, int recordType) throws Exception {
//		VRMap map = getData(specialClinicType, recordType);
//		if(map == null) return "";
//		return ACCastUtilities.toString(map.get("SPECIAL_CLINIC_NAME"));
//	}
//    /*
//    protected int getSpecialClinicUnit(String specialClinicType) throws Exception {
//    	return getSpecialClinicUnit(specialClinicType,1);
//    }
//    */
//	protected int getSpecialClinicUnit(String specialClinicType, int recordType) throws Exception {
//		VRMap map = getData(specialClinicType, recordType);
//		if(map == null) return 0;
//		return ACCastUtilities.toInt(map.get("SPECIAL_CLINIC_UNIT"));
//	}
//	protected VRMap getData(String specialClinicType, int recordType) throws Exception {
//		return (VRMap)specialClinicData.get(Integer.toString(recordType) + "-" + specialClinicType);
//	}
//	//[H20.5 法改正対応] fujihara edit end
	//[ID:0000454][Shin Fujihara] 2009/05/01 delete end 障害対応
	
	//[ID:0000454][Shin Fujihara] 2009/05/01 add begin 障害対応
    public String getSpecialClinicName(String specialClinicType, Object targetDate) throws Exception {
    	return getSpecialClinicName(specialClinicType,1, targetDate);
    }
    public String getSpecialClinicName(String specialClinicType, int recordType, Object targetDate) throws Exception {
		VRMap map = getSpecialClinicRecord(specialClinicType, recordType, targetDate);
		if(map == null) return "";
		return ACCastUtilities.toString(map.get("SPECIAL_CLINIC_NAME"));
	}
	protected int getSpecialClinicUnit(String specialClinicType, int recordType, String targetDate) throws Exception {
		VRMap map = getSpecialClinicRecord(specialClinicType, recordType, targetDate);
		if(map == null) return 0;
		return ACCastUtilities.toInt(map.get("SPECIAL_CLINIC_UNIT"));
	}
	protected VRMap getSpecialClinicRecord(String specialClinicType, int recordType, Object targetDate) throws Exception {
		VRMap map = null;
		
		String tmp = ACCastUtilities.toString(targetDate, "");
		if (tmp.length() != 6){
			return map;
		}
		
		Date target = ACCastUtilities.toDate(tmp + "01", null);
		if (target == null){
			return map; 
		}
		
		for (int i = 0; i < specialClinicData.size(); i++) {
			map = (VRMap)specialClinicData.get(i);
			if (specialClinicType.equals(ACCastUtilities.toString(map.get("SPECIAL_CLINIC_TYPE"), ""))
				&& (ACCastUtilities.toInt(map.get("RECORD_TYPE"), 0) == recordType)) {
				
				//日付比較
				switch (ACDateUtilities.getDuplicateTermCheck(
						ACCastUtilities.toDate(map.get("SPECIAL_CLINIC_VALID_START"),null),
						ACCastUtilities.toDate(map.get("SPECIAL_CLINIC_VALID_END"),null),
						target,
						target)){
				case ACDateUtilities.DUPLICATE_FIRST_INCLUDE_SECOND:
				case ACDateUtilities.DUPLICATE_FIRST_EQUALS_SECOND:
				case ACDateUtilities.DUPLICATE_FIRST_INCLUDE_SECOND_EQUALS_BOTH_END:
				case ACDateUtilities.DUPLICATE_FIRST_INCLUDE_SECOND_EQUALS_BOTH_BEGIN:
					return map;
				}
			}
		}
		return null;
	}
	//[ID:0000454][Shin Fujihara] 2009/05/01 add end 障害対応
    
    /*=============================================================
         サービス名称関連
    =============================================================*/
    protected String getServiceName(String serviceCodeKind) throws Exception {
        String result = "";
        if(serviceName.containsKey(serviceCodeKind)){
            //result = String.valueOf(((VRMap)serviceName.get(serviceCodeKind)).get("SERVICE_NAME"));
            result = String.valueOf(((VRMap)serviceName.get(serviceCodeKind)).get("SERVICE_KIND_NAME"));
        }
        return result;
    }
    
    
    public VRMap getServices() throws Exception {
        return serviceName;
    }
    /*=============================================================
         保険者名称関連
    =============================================================*/
    protected String getInsurerName(String insurerId) throws Exception {
        String result = "";
        if(insurer.containsKey(insurerId)){
            result = String.valueOf(((VRMap)insurer.get(insurerId)).get("INSURER_NAME"));
        }
        return result;
    }
	
    
    //[H20.4 法改正対応] fujihara add start
    public Date getTargetDate(){
    	return this.targetDate;
    }
    //[H20.4 法改正対応] fujihara add end
    
    //[ID:0000641][Shin Fujihara] 2011/04/14 add begin
    //食費の基準額を取得
    public int getDefaultFoodCost() {
    	//食費のコードは「1」
    	return getResidenceFoodCost(1);
    }
    
    private int getResidenceFoodCost(int id) {
    	Integer objID  = new Integer(id);
    	
    	if (!residenceFoodCost.containsKey(objID)) {
    		return Integer.MAX_VALUE;
    	}
    	
    	VRMap target = (VRMap)residenceFoodCost.get(objID);
    	
    	if (!target.containsKey("RESIDENCE_FOOD_COST")) {
    		return Integer.MAX_VALUE;
    	}
    	
    	return ACCastUtilities.toInt(target.get("RESIDENCE_FOOD_COST"), Integer.MAX_VALUE);
    }
    //[ID:0000641][Shin Fujihara] 2011/04/14 add end
	
}
