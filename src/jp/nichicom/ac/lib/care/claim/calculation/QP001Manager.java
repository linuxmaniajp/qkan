
/*
 * Project code name "ORCA"
 * ‹‹•tŠÇ—‘ä’ ƒ\ƒtƒg QKANCHOiJMA care benefit management softwarej
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
 * ƒAƒvƒŠ: QKANCHO
 * ŠJ”­Ò: “¡Œ´@L
 * ì¬“ú: 2006/01/24  “ú–{ƒRƒ“ƒsƒ…[ƒ^[Š”®‰ïĞ “¡Œ´@L V‹Kì¬
 * XV“ú: ----/--/--
 * ƒVƒXƒeƒ€ ‹‹•tŠÇ—‘ä’  (Q)
 * ƒTƒuƒVƒXƒeƒ€ ¿‹‘o—Í (P)
 * ƒvƒƒZƒX ¿‹ˆ— (001)
 * ƒvƒƒOƒ‰ƒ€ ¿‹ƒf[ƒ^ì¬ƒ}ƒXƒ^ƒf[ƒ^ŠÇ— (QP001Manager)
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
import jp.or.med.orca.qkan.QkanConstants;

/**
 * ÀÑWŒv‚Ìƒ}ƒXƒ^ƒf[ƒ^‚ğŠÇ—‚·‚éB
 * Œö”ïî•ñ
 * –‹ÆŠî•ñ
 * “Á’èf—Ã”ïî•ñ
 * ‚ğ“Š‡‚·‚éB
 *
 */
public class QP001Manager {

	/**
	 * Œö”ïî•ñ
	 */
	private VRMap kohiData = new VRLinkedHashMap();
	/**
	 * Œö”ï-ƒT[ƒrƒXƒR[ƒh‘Î‰•\
	 */
	private VRMap kohiServiceData = new VRLinkedHashMap();
	/**
	 * –‹ÆŠî•ñ
	 */
	private VRMap providerMap = new VRHashMap();
	/**
	 * ’PˆÊ”’P‰¿ƒ}ƒXƒ^‚ğæ“¾
	 */
	private VRMap areaUnitMap = new VRHashMap();
	
	/**
	 * –‹ÆÒÚ×î•ñ
	 */
	private VRMap providerDetailMap = new VRHashMap();
	
	/**
	 * –‹ÆŠŠ„ˆø—¦î•ñ
	 */
	private VRMap providerServiceMap = new VRHashMap();
	
	/**
	 * “Á’èf—Ã”ïî•ñ
	 */
	//[ID:0000454][Shin Fujihara] 2009/05/01 edit begin áŠQ‘Î‰
	//private VRMap specialClinicData = new VRLinkedHashMap();
	private VRList specialClinicData = new VRArrayList();
	//[ID:0000454][Shin Fujihara] 2009/05/01 edit end áŠQ‘Î‰
    
    /**
     * ƒT[ƒrƒX–¼Ì
     */
    private VRMap serviceName = new VRHashMap();
    
    /**
     * •ÛŒ¯Ò–¼Ì
     */
    private VRMap insurer = new VRHashMap();
	
    //[H20.4 –@‰ü³‘Î‰] fujihara add start
    //ƒT[ƒrƒX’ñ‹Ÿ”NŒ
    private Date targetDate = null;
    //[H20.4 –@‰ü³‘Î‰] fujihara add end
    
    // [ID:0000641][Shin Fujihara] 2011/04/14 add begin
    // M_RESIDENCE_FOOD_COST‚©‚çæ“¾‚µ‚½AH”ïE‹Z”ï‚Ìî•ñ
    private VRMap residenceFoodCost = new VRHashMap();
    // [ID:0000641][Shin Fujihara] 2011/04/14 add end
	
    
// 2016/8/16 [‘‡–‹Æ‘Î‰][Yoichiro Kamei] add - begin
    private int jigyotaishoLimitRate = 0; // –‹Æ‘ÎÛÒ‚Ì‘Šî€‚Ì‹æ•ªx‹‹ŒÀ“xŠz
    
    private void setJigyotaishoLimitRate(ACDBManager dbm,Date targetDate) throws Exception {
        this.jigyotaishoLimitRate = QkanCommon.getOfficialLimitRate(dbm,
            targetDate, new Integer(1), String.valueOf(QkanConstants.YOUKAIGODO_JIGYOTAISHO));
    }
    
    // –‹Æ‘ÎÛÒ‚Ì‘Šî€‚Ì‹æ•ªx‹‹ŒÀ“xŠz‚ğæ“¾‚µ‚Ü‚·
    public int getJigyotaishoLimitRate() {
        return this.jigyotaishoLimitRate;
    }
// 2016/8/16 [‘‡–‹Æ‘Î‰][Yoichiro Kamei] add - end
    
	/**
	 * ƒRƒ“ƒXƒgƒ‰ƒNƒ^
	 * ƒ}ƒXƒ^ƒf[ƒ^‚Ì‰Šú‰»‚ğs‚¤B
	 * @param dbm
	 */
	public QP001Manager(ACDBManager dbm,Date targetDate) throws Exception {
		//Œö”ïî•ñ‚Ì‰Šú‰»
		//[ID:0000465][Shin Fujihara] 2009/04 add begin •½¬21”N4Œ–@‰ü³‘Î‰
		//initializationKohi(dbm);
		initializationKohi(dbm,targetDate);
		//[ID:0000465][Shin Fujihara] 2009/04 add end •½¬21”N4Œ–@‰ü³‘Î‰
		
		//–‹ÆŠî•ñ‚Ì‰Šú‰»
		//[ID:0000458][Shin Fujihara] 2009/03/13 edit begin áŠQ‘Î‰
		//initializationProvider(dbm);
		initializationProvider(dbm,targetDate);
		//[ID:0000458][Shin Fujihara] 2009/03/13 edit end áŠQ‘Î‰
		
		//“Á’èf—Ã”ïî•ñ‚Ì‰Šú‰»
		initializationSpecialClinic(dbm,targetDate);
        
        //ƒT[ƒrƒX–¼Ì‚Ì‰Šú‰»
        initializationServiceName(dbm);
        
        //•ÛŒ¯Ò–¼Ì‚Ì‰Šú‰»
        initializationInsurerName(dbm);
        
        //[H20.4 –@‰ü³‘Î‰] fujihara add start
        this.targetDate = targetDate;
        //[H20.4 –@‰ü³‘Î‰] fujihara add end
        
        // 2016/8/16 [‘‡–‹Æ‘Î‰][Yoichiro Kamei] add - begin
        setJigyotaishoLimitRate(dbm, targetDate);
        // 2016/8/16 [‘‡–‹Æ‘Î‰][Yoichiro Kamei] add - end
	}
	
	/**
	 * Œö”ïî•ñ‚Ì‰Šú‰»‚ğs‚¢‚Ü‚·B
	 * @param dbm
	 * @throws Exception
	 */
	//[ID:0000465][Shin Fujihara] 2009/04 add begin •½¬21”N4Œ–@‰ü³‘Î‰
	//private void initializationKohi(ACDBManager dbm) throws Exception {
	private void initializationKohi(ACDBManager dbm, Date targetDate) throws Exception {
	//[ID:0000465][Shin Fujihara] 2009/04 add end •½¬21”N4Œ–@‰ü³‘Î‰
		
      	//[ID:0000465][Shin Fujihara] 2009/04 add begin •½¬21”N4Œ–@‰ü³‘Î‰
		String targetStart = VRDateParser.format(ACDateUtilities.toFirstDayOfMonth(targetDate), "yyyy/MM/dd");
		String targetEnd = VRDateParser.format(ACDateUtilities.toLastDayOfMonth(targetDate), "yyyy/MM/dd");
      	//[ID:0000465][Shin Fujihara] 2009/04 add end •½¬21”N4Œ–@‰ü³‘Î‰
		
		
		StringBuilder sb = new StringBuilder();
		//Œö”ïƒ}ƒXƒ^æ“¾
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
		//[ID:0000465][Shin Fujihara] 2009/04 add begin •½¬21”N4Œ–@‰ü³‘Î‰
		sb.append(" WHERE");
		sb.append(" (KOHI_VALID_START  <='" + targetEnd + "')");
		sb.append(" AND (KOHI_VALID_END  >= '" + targetStart + "')");
		//[ID:0000465][Shin Fujihara] 2009/04 add end •½¬21”N4Œ–@‰ü³‘Î‰
		sb.append(" ORDER BY KOHI_SORT ASC");
		
		VRList list = dbm.executeQuery(sb.toString());
		
		
		ACBindUtilities.setMapFromArray(list,kohiData,"KOHI_TYPE");
		
		//Œö”ï-ƒT[ƒrƒXƒ}ƒXƒ^æ“¾
		sb = new StringBuilder();
		
		sb.append(" SELECT");
		sb.append(" KOHI_TYPE || SYSTEM_SERVICE_KIND_DETAIL || APPLICATION_TYPE AS CODE,");
		sb.append(" KOHI_TYPE,");
		sb.append(" SYSTEM_SERVICE_KIND_DETAIL,");
		sb.append(" APPLICATION_TYPE,");
		sb.append(" BY_MEDICAL_FLAG");
		sb.append(" FROM");
		sb.append(" M_KOHI_SERVICE");
		//[ID:0000465][Shin Fujihara] 2009/04 add begin •½¬21”N4Œ–@‰ü³‘Î‰
		sb.append(" WHERE");
		sb.append(" (KOHI_SERVICE_VALID_START  <='" + targetEnd + "')");
		sb.append(" AND (KOHI_SERVICE_VALID_END  >= '" + targetStart + "')");
		//[ID:0000465][Shin Fujihara] 2009/04 add end •½¬21”N4Œ–@‰ü³‘Î‰
		
		list = dbm.executeQuery(sb.toString());
		
		ACBindUtilities.setMapFromArray(list,kohiServiceData,"CODE");
	}
	
	/**
	 * –‹ÆŠî•ñ‚Ì‰Šú‰»
	 * @param dbm
	 * @throws Exception
	 */
	//[ID:0000458][Shin Fujihara] 2009/03/13 edit begin áŠQ‘Î‰
	//private void initializationProvider(ACDBManager dbm) throws Exception {
	private void initializationProvider(ACDBManager dbm, Date targetDate) throws Exception {
	//[ID:0000458][Shin Fujihara] 2009/03/13 edit end áŠQ‘Î‰
		//–‹ÆŠî•ñ‚Ìæ“¾
		VRList providerList = QkanCommon.getProviderInfo(dbm);
		//–‹ÆŠî•ñ‚ğŒŸõ—p‚ÉMap‚É“WŠJ
      	ACBindUtilities.setMapFromArray(providerList,providerMap,"PROVIDER_ID");
      	//–‹ÆŠî•ñÚ×
      	for(int i = 0; i < providerList.getDataSize(); i++){
      		VRMap providerTemp = (VRMap)providerList.getData(i);
      		String providerId = ACCastUtilities.toString(VRBindPathParser.get("PROVIDER_ID",providerTemp));
      		//
      		VRList list = QkanCommon.getProviderServiceDetail(dbm, providerId);
      		VRMap map = new VRHashMap();
            ACBindUtilities.setMapFromArray(list,map,"SYSTEM_SERVICE_KIND_DETAIL");
      		providerDetailMap.put(providerId,map);
      	}
      	
      	//[ID:0000458][Shin Fujihara] 2009/03/13 add begin áŠQ‘Î‰
		Date targetDateStart = ACDateUtilities.toFirstDayOfMonth(targetDate);
		Date targetDateEnd = ACDateUtilities.toLastDayOfMonth(targetDate);
      	//[ID:0000458][Shin Fujihara] 2009/03/13 add end áŠQ‘Î‰
      	
      	//’P‰¿ƒ}ƒXƒ^‚Ìæ“¾
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
      	
      	//[ID:0000458][Shin Fujihara] 2009/03/13 add begin áŠQ‘Î‰
		sb.append(" WHERE");
		sb.append(" (UNIT_VALID_START  <='" + VRDateParser.format(targetDateEnd,"yyyy/MM/dd") + "')");
		sb.append(" AND (UNIT_VALID_END  >= '" + VRDateParser.format(targetDateStart,"yyyy/MM/dd") + "')");
		//[ID:0000458][Shin Fujihara] 2009/03/13 add end áŠQ‘Î‰
      	
      	ACBindUtilities.setMapFromArray(dbm.executeQuery(sb.toString()),areaUnitMap,"CODE");
      	
      	//–‹ÆŠ‚ÌŠ„ˆø—¦‚Ìæ“¾
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
      	// H”ïE‹Z”ï‚ÌŠî€Šz‚ğæ“¾
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
	 * “Á’èf—Ã”ïî•ñ‚Ì‰Šú‰»‚ğs‚¢‚Ü‚·B
	 * @param dbm
	 * @param targetDate
	 * @throws Exception
	 */
	private void initializationSpecialClinic(ACDBManager dbm,Date targetDate) throws Exception {
		//[ID:0000454][Shin Fujihara] 2009/05/01 delete begin áŠQ‘Î‰
		/*
		StringBuilder sb = new StringBuilder();
		Date targetDateStart = ACDateUtilities.toFirstDayOfMonth(targetDate);
		Date targetDateEnd = ACDateUtilities.toLastDayOfMonth(targetDate);
		
		sb.append(" SELECT");
		//[H20.5 –@‰ü³‘Î‰] fujihara edit start
		//sb.append(" SPECIAL_CLINIC_TYPE");
		sb.append(" RECORD_TYPE || '-' || SPECIAL_CLINIC_TYPE AS KEY_VALUE");
		//[H20.5 –@‰ü³‘Î‰] fujihara edit end
		sb.append(" ,SPECIAL_CLINIC_NAME");
		sb.append(" ,SPECIAL_CLINIC_UNIT");
		sb.append(" FROM");
		sb.append(" M_SPECIAL_CLINIC");
		sb.append(" WHERE");
		sb.append(" (SPECIAL_CLINIC_VALID_START <='" + VRDateParser.format(targetDateEnd,"yyyy/MM/dd") + "')");
		sb.append(" AND (SPECIAL_CLINIC_VALID_END >= '" + VRDateParser.format(targetDateStart,"yyyy/MM/dd") + "')");
		//[H20.5 –@‰ü³‘Î‰] fujihara edit start
		//ACBindUtilities.setMapFromArray(dbm.executeQuery(sb.toString()),specialClinicData,"SPECIAL_CLINIC_TYPE");
		ACBindUtilities.setMapFromArray(dbm.executeQuery(sb.toString()),specialClinicData,"KEY_VALUE");
		//[H20.5 –@‰ü³‘Î‰] fujihara edit end
		*/
		//[ID:0000454][Shin Fujihara] 2009/05/01 delete end áŠQ‘Î‰
		//[ID:0000454][Shin Fujihara] 2009/05/01 add begin áŠQ‘Î‰
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
		//[ID:0000454][Shin Fujihara] 2009/05/01 add end áŠQ‘Î‰
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
	    Œö”ïŠÖ˜A
	====================================================*/
	/**
	 * w’è‚³‚ê‚½Œö”ïƒ^ƒCƒv‚Ì‹‹•t—¦‚ğ•Ô‹p‚µ‚Ü‚·B
	 * @param kohiType æ“¾‚·‚éŒö”ïƒ^ƒCƒv
	 * @return
	 * @throws Exception
	 */
    /* —˜—pÒ‚Ìî•ñ‚©‚çæ“¾‚·‚é‚æ‚¤•ÏX
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
	 * Œö”ïƒ^ƒCƒv‚ÆƒVƒXƒeƒ€“à‚ÌƒT[ƒrƒXƒR[ƒh‚©‚çŠY“–‚·‚éŒö”ï‚Ìî•ñ‚ğ•Ô‹p‚µ‚Ü‚·B
	 * ŠY“–Œö”ï‚ª‘¶İ‚µ‚È‚¢ê‡‚Ínull‚ğ•Ô‹p‚µ‚Ü‚·B
	 * @param kohiType
	 * @param systemServiceKindDetail
	 * @param applicationType
	 * @return
	 * @throws Exception
	 */
	public VRMap getKohiMatchData(String kohiType, String systemServiceKindDetail,String applicationType) throws Exception {
        VRMap result = null;
		String key = kohiType + systemServiceKindDetail + applicationType;
		//M_KOHI_SERVICE‚ÌKOHI_TYPE,SYSTEM_SERVICE_KIND_DETAIL‚ğ
		//QÆ‚µAŠY“–ƒT[ƒrƒX‚ª‘¶İ‚·‚é‚©ƒ`ƒFƒbƒN
		if(kohiServiceData.containsKey(key)){
            result = (VRMap)VRBindPathParser.get(new Integer(kohiType),kohiData);
            result.put("BY_MEDICAL_FLAG", ((VRMap)kohiServiceData.get(key)).get("BY_MEDICAL_FLAG"));
            result.put("APPLICATION_TYPE", ((VRMap)kohiServiceData.get(key)).get("APPLICATION_TYPE"));
        }
		//Œö”ï‚ÌÚ×î•ñ‚ğæ“¾
		return result;
		
	}
	/**
	 * Œö”ï‡ˆÊ‚ğæ“¾‚·‚éB
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
     * Œö”ïƒ}ƒXƒ^‚æ‚èî•ñ‚ğæ“¾‚·‚éB
     * @param kohiType Œö”ïƒ^ƒCƒv
     * @param key æ“¾‚·‚éƒtƒB[ƒ‹ƒh–¼Ì
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
	   –‹ÆŠŠÖ˜A
	================================================================*/
	/**
	 * w’è‚µ‚½–‹ÆŠ‚Ì“Á•Ê’nˆæ‰ÁZƒtƒ‰ƒO‚ğæ“¾‚·‚éB
	 * @param providerId
	 * @return
	 * @throws Exception
	 */
    public String getSpecialAreaFlag(String providerId) throws Exception {
		return ACCastUtilities.toString(VRBindPathParser.get((providerId) + "/SPECIAL_AREA_FLAG",providerMap));
	}
	/**
	 * w’è‚µ‚½–‹ÆŠ‚Ì–‹ÆŠ–¼Ì‚ğæ“¾‚·‚éB
	 * @param providerId
	 * @return
	 * @throws Exception
	 */
	
	protected String getProviderName(String providerId) throws Exception {
		return ACCastUtilities.toString(VRBindPathParser.get((providerId) + "/PROVIDER_NAME",providerMap));
	}
	/**
	 * w’è‚µ‚½–‹ÆŠ‚ÌZŠ‚ğæ“¾‚·‚éB
	 * @param providerId
	 * @return
	 * @throws Exception
	 */
	protected String getProviderAddress(String providerId) throws Exception {
		return ACCastUtilities.toString(VRBindPathParser.get((providerId) + "/PROVIDER_ADDRESS",providerMap));
	}
	/**
	 * w’è‚µ‚½–‹ÆŠ‚Ì“d˜b”Ô†‚ğæ“¾‚·‚éB
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
	 * w’è‚µ‚½–‹ÆŠ‚Ì–‹Æ‹æ•ª‚ğæ“¾‚·‚éB<br>
	 * 1-w’è 2-Šî€ŠY“–
	 * @param providerId
	 * @return
	 * @throws Exception
	 */
	protected int getProviderJigyouType(String providerId) throws Exception {
		return ACCastUtilities.toInt(VRBindPathParser.get((providerId) + "/PROVIDER_JIGYOU_TYPE",providerMap));
	}
    
    /**
     * w’è‚µ‚½–‹ÆŠ‚Ì“ü—pŠúŠÔƒtƒ‰ƒO‚ğæ“¾‚·‚éB<br>
     * 1-ˆã—Ã‹@ŠÖ 0-‚»‚êˆÈŠO
     * @param providerId –‹ÆŠ”Ô†
     * @return æ“¾‚µ‚½ˆã—Ã‹@ŠÖƒtƒ‰ƒO
     * @throws Exception
     */
    protected int getProviderMedicalFlag(String providerId) throws Exception {
        return ACCastUtilities.toInt(VRBindPathParser.get((providerId) + "/MEDICAL_FLAG",providerMap));
    }
	
	/**
	 * –‹ÆŠ‚ÌƒXƒe[ƒVƒ‡ƒ“ƒR[ƒh‚ğæ“¾‚·‚éB
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
     * –‹ÆŠ‚É“o˜^‚³‚ê‚Ä‚¢‚éƒzƒeƒ‹ƒRƒXƒg‚ğæ“¾‚µ‚Ü‚·B
     * @param providerId –‹ÆŠ”Ô†
     * @param serviceCodeItem ƒT[ƒrƒXƒR[ƒh 
     * @return “o˜^‚³‚ê‚Ä‚¢‚éƒzƒeƒ‹ƒRƒXƒg
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
        
        // [H27.4‰ü³‘Î‰][Shinobu Hitaka] 2015/1/20 edit - begin ƒT[ƒrƒXƒR[ƒh‰p”‰»
        /*
        switch(ACCastUtilities.toInt(serviceCodeItem,0)){
        //’ZŠú¶Šˆƒ†ƒjƒbƒgŒ^ŒÂº
        case 2121:
        //’ZŠú˜VŒ’ƒ†ƒjƒbƒgŒ^ŒÂº
        case 2221:
        //’ZŠú—Ã—{ƒ†ƒjƒbƒgŒ^ŒÂº
        case 2321:
        //•Ÿƒ{İƒ†ƒjƒbƒgŒ^ŒÂº
        case 5121:
        //•ÛŒ’{İƒ†ƒjƒbƒgŒ^ŒÂº
        case 5221:
        //—Ã—{{İƒ†ƒjƒbƒgŒ^ŒÂº
        case 5321:
        //’nˆæ•Ÿƒ{İƒ†ƒjƒbƒgŒ^ŒÂº
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
            
            
        //’ZŠú¶Šˆƒ†ƒjƒbƒgŒ^€ŒÂº
        case 2122:
        //’ZŠú˜VŒ’ƒ†ƒjƒbƒgŒ^€ŒÂº
        case 2222:
        //’ZŠú—Ã—{ƒ†ƒjƒbƒgŒ^€ŒÂº
        case 2322:
        //•Ÿƒ{İƒ†ƒjƒbƒgŒ^€ŒÂº
        case 5122:
        //•ÛŒ’{İƒ†ƒjƒbƒgŒ^€ŒÂº
        case 5222:
        //—Ã—{{İƒ†ƒjƒbƒgŒ^€ŒÂº
        case 5322:
        //’nˆæ•Ÿƒ{İƒ†ƒjƒbƒgŒ^€ŒÂº
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
        //’ZŠú¶Šˆ]—ˆŒ^ŒÂº
        case 2123:
        //’ZŠú˜VŒ’]—ˆŒ^ŒÂº
        case 2223:
        //’ZŠú—Ã—{]—ˆŒ^ŒÂº
        case 2323:
        //•Ÿƒ{İ]—ˆŒ^ŒÂº
        case 5123:
        //•ÛŒ’{İ]—ˆŒ^ŒÂº
        case 5223:
        //—Ã—{{İ]—ˆŒ^ŒÂº
        case 5323:
        //’nˆæ•Ÿƒ{İ]—ˆŒ^ŒÂº
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
            
        //’ZŠú¶Šˆ‘½°º
        case 2124:
        //’ZŠú˜VŒ’‘½°º
        case 2224:
        //’ZŠú—Ã—{‘½°º
        case 2324:
        //•Ÿƒ{İ‘½°º
        case 5124:
        //•ÛŒ’{İ‘½°º
        case 5224:
        //—Ã—{{İ‘½°º
        case 5324:
        //’nˆæ•Ÿƒ{İ‘½°º
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
            
            
        //[ID:0000641][Shin Fujihara] 2011/04/13 add begin —\–hƒT[ƒrƒX‚Ìº—¿æ“¾˜R‚ê
        // —\–h’ZŠú¶Šˆƒ†ƒjƒbƒgŒ^ŒÂº
        case 2421:
        	if(detail.containsKey("1240112")){
                unitData = detail.get("1240112");
            }
        	break;
        // —\–h’ZŠú¶Šˆƒ†ƒjƒbƒgŒ^€ŒÂº
        case 2422:
        	if(detail.containsKey("1240113")){
                unitData = detail.get("1240113");
            }
        	break;
        // —\–h’ZŠú¶Šˆ]—ˆŒ^ŒÂº
        case 2423:
        	if(detail.containsKey("1240114")){
                unitData = detail.get("1240114");
            }
        	break;
        // —\–h’ZŠú¶Šˆ‘½°º
        case 2424:
        	if(detail.containsKey("1240115")){
                unitData = detail.get("1240115");
            }
        	break;
        	
        	
        // —\–h’ZŠú˜VŒ’ƒ†ƒjƒbƒgŒ^ŒÂº
        case 2521:
        	if(detail.containsKey("1250112")){
                unitData = detail.get("1250112");
            }
        	break;
        // —\–h’ZŠú˜VŒ’ƒ†ƒjƒbƒgŒ^€ŒÂº
        case 2522:
        	if(detail.containsKey("1250113")){
                unitData = detail.get("1250113");
            }
        	break;
        // —\–h’ZŠú¶Šˆ]—ˆŒ^ŒÂº
        case 2523:
        	if(detail.containsKey("1250114")){
                unitData = detail.get("1250114");
            }
        	break;
        // —\–h’ZŠú¶Šˆ‘½°º
        case 2524:
        	if(detail.containsKey("1250115")){
                unitData = detail.get("1250115");
            }
        	break;
        	
        	
        // —\–h’ZŠú—Ã—{ƒ†ƒjƒbƒgŒ^ŒÂº
        case 2621:
        	// ‰îŒì—\–h’ZŠú“üŠ—Ã—{‰îŒì_•a‰@—Ã—{
        	if(detail.containsKey("1260114")){
                unitData = detail.get("1260114");
            // ’ZŠú“üŠ—Ã—{‰îŒì_f—ÃŠ—Ã—{
            } else if(detail.containsKey("1260211")){
                unitData = detail.get("1260211");
            // ’ZŠú“üŠ—Ã—{‰îŒì_”F’mÇ¾Š³
            } else if(detail.containsKey("1260311")){
                unitData = detail.get("1260311");
            }
        	break;
        // —\–h’ZŠú—Ã—{ƒ†ƒjƒbƒgŒ^€ŒÂº
        case 2622:
        	// ‰îŒì—\–h’ZŠú“üŠ—Ã—{‰îŒì_•a‰@—Ã—{
        	if(detail.containsKey("1260115")){
                unitData = detail.get("1260115");
            // ’ZŠú“üŠ—Ã—{‰îŒì_f—ÃŠ—Ã—{
            } else if(detail.containsKey("1260212")){
                unitData = detail.get("1260212");
            // ’ZŠú“üŠ—Ã—{‰îŒì_”F’mÇ¾Š³
            } else if(detail.containsKey("1260312")){
                unitData = detail.get("1260312");
            }
        	break;
        // —\–h’ZŠú—Ã—{]—ˆŒ^ŒÂº
        case 2623:
        	// ‰îŒì—\–h’ZŠú“üŠ—Ã—{‰îŒì_•a‰@—Ã—{
        	if(detail.containsKey("1260116")){
                unitData = detail.get("1260116");
            // ’ZŠú“üŠ—Ã—{‰îŒì_f—ÃŠ—Ã—{
            } else if(detail.containsKey("1260213")){
                unitData = detail.get("1260213");
            // ’ZŠú“üŠ—Ã—{‰îŒì_”F’mÇ¾Š³
            } else if(detail.containsKey("1260313")){
                unitData = detail.get("1260313");
            }
        	break;
        // —\–h’ZŠú—Ã—{‘½°º
        case 2624:
        	// ‰îŒì—\–h’ZŠú“üŠ—Ã—{‰îŒì_•a‰@—Ã—{
        	if(detail.containsKey("1260117")){
                unitData = detail.get("1260117");
            // ’ZŠú“üŠ—Ã—{‰îŒì_f—ÃŠ—Ã—{
            } else if(detail.containsKey("1260214")){
                unitData = detail.get("1260214");
            // ’ZŠú“üŠ—Ã—{‰îŒì_”F’mÇ¾Š³
            } else if(detail.containsKey("1260314")){
                unitData = detail.get("1260314");
            }
        	break;
        //[ID:0000641][Shin Fujihara] 2011/04/13 add end —\–hƒT[ƒrƒX‚Ìº—¿æ“¾˜R‚ê
        }
        */
        
        if ("2121".equals(serviceCodeItem)  	//’ZŠú¶Šˆƒ†ƒjƒbƒgŒ^ŒÂº
        	|| "2221".equals(serviceCodeItem)	//’ZŠú˜VŒ’ƒ†ƒjƒbƒgŒ^ŒÂº
        	|| "2321".equals(serviceCodeItem)	//’ZŠú—Ã—{ƒ†ƒjƒbƒgŒ^ŒÂº
        	|| "5121".equals(serviceCodeItem)	//•Ÿƒ{İƒ†ƒjƒbƒgŒ^ŒÂº
        	|| "5221".equals(serviceCodeItem)	//•ÛŒ’{İƒ†ƒjƒbƒgŒ^ŒÂº
        	|| "5321".equals(serviceCodeItem)	//—Ã—{{İƒ†ƒjƒbƒgŒ^ŒÂº
        	|| "5421".equals(serviceCodeItem)	//’nˆæ•Ÿƒ{İƒ†ƒjƒbƒgŒ^ŒÂº
    		) {
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
        }
        
        if ("2122".equals(serviceCodeItem)  	//’ZŠú¶Šˆƒ†ƒjƒbƒgŒ^€ŒÂº
        	|| "2222".equals(serviceCodeItem)	//’ZŠú˜VŒ’ƒ†ƒjƒbƒgŒ^€ŒÂº
        	|| "2322".equals(serviceCodeItem)	//’ZŠú—Ã—{ƒ†ƒjƒbƒgŒ^€ŒÂº
        	|| "5122".equals(serviceCodeItem)	//•Ÿƒ{İƒ†ƒjƒbƒgŒ^€ŒÂº
        	|| "5222".equals(serviceCodeItem)	//•ÛŒ’{İƒ†ƒjƒbƒgŒ^€ŒÂº
        	|| "5322".equals(serviceCodeItem)	//—Ã—{{İƒ†ƒjƒbƒgŒ^€ŒÂº
        	|| "5422".equals(serviceCodeItem)	//’nˆæ•Ÿƒ{İƒ†ƒjƒbƒgŒ^€ŒÂº
        	) {
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
        }
        
        if ("2123".equals(serviceCodeItem)   	//’ZŠú¶Šˆ]—ˆŒ^ŒÂº
        	|| "2223".equals(serviceCodeItem)	//’ZŠú˜VŒ’]—ˆŒ^ŒÂº
        	|| "2323".equals(serviceCodeItem)	//’ZŠú—Ã—{]—ˆŒ^ŒÂº
        	|| "5123".equals(serviceCodeItem)	//•Ÿƒ{İ]—ˆŒ^ŒÂº
        	|| "5223".equals(serviceCodeItem)	//•ÛŒ’{İ]—ˆŒ^ŒÂº
        	|| "5323".equals(serviceCodeItem)	//—Ã—{{İ]—ˆŒ^ŒÂº
        	|| "5423".equals(serviceCodeItem)	//’nˆæ•Ÿƒ{İ]—ˆŒ^ŒÂº
            ) {
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
        }

        if ("2124".equals(serviceCodeItem)   	//’ZŠú¶Šˆ‘½°º
        	|| "2224".equals(serviceCodeItem)	//’ZŠú˜VŒ’‘½°º
        	|| "2324".equals(serviceCodeItem)	//’ZŠú—Ã—{‘½°º
        	|| "5124".equals(serviceCodeItem)	//•Ÿƒ{İ‘½°º
        	|| "5224".equals(serviceCodeItem)	//•ÛŒ’{İ‘½°º
        	|| "5324".equals(serviceCodeItem)	//—Ã—{{İ‘½°º
        	|| "5424".equals(serviceCodeItem)	//’nˆæ•Ÿƒ{İ‘½°º
            ) {
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
        }
        
        //—\–h’ZŠú¶Šˆƒ†ƒjƒbƒgŒ^ŒÂº
        if ("2421".equals(serviceCodeItem)) {
            if(detail.containsKey("1240112")){
                unitData = detail.get("1240112");
            }
        }
        //—\–h’ZŠú¶Šˆƒ†ƒjƒbƒgŒ^€ŒÂº
        if ("2422".equals(serviceCodeItem)) {
            if(detail.containsKey("1240113")){
                unitData = detail.get("1240113");
            }
        }
        //—\–h’ZŠú¶Šˆ]—ˆŒ^ŒÂº
        if ("2423".equals(serviceCodeItem)) {
            if(detail.containsKey("1240114")){
                unitData = detail.get("1240114");
            }
        }
        //—\–h’ZŠú¶Šˆ‘½°º
        if ("2424".equals(serviceCodeItem)) {
            if(detail.containsKey("1240115")){
                unitData = detail.get("1240115");
            }
        }
        //—\–h’ZŠú˜VŒ’ƒ†ƒjƒbƒgŒ^ŒÂº
        if ("2521".equals(serviceCodeItem)) {
            if(detail.containsKey("1250112")){
                unitData = detail.get("1250112");
            }
        }
        //—\–h’ZŠú˜VŒ’ƒ†ƒjƒbƒgŒ^€ŒÂº
        if ("2522".equals(serviceCodeItem)) {
        	if(detail.containsKey("1250113")){
                unitData = detail.get("1250113");
            }
        }
        //—\–h’ZŠú¶Šˆ]—ˆŒ^ŒÂº
        if ("2523".equals(serviceCodeItem)) {
        	if(detail.containsKey("1250114")){
                unitData = detail.get("1250114");
            }
        }
        //—\–h’ZŠú¶Šˆ‘½°º
        if ("2524".equals(serviceCodeItem)) {
        	if(detail.containsKey("1250115")){
                unitData = detail.get("1250115");
            }
        }
        // —\–h’ZŠú—Ã—{ƒ†ƒjƒbƒgŒ^ŒÂº
        if ("2621".equals(serviceCodeItem)) {
        	// ‰îŒì—\–h’ZŠú“üŠ—Ã—{‰îŒì_•a‰@—Ã—{
        	if(detail.containsKey("1260114")){
                unitData = detail.get("1260114");
            // ’ZŠú“üŠ—Ã—{‰îŒì_f—ÃŠ—Ã—{
            } else if(detail.containsKey("1260211")){
                unitData = detail.get("1260211");
            // ’ZŠú“üŠ—Ã—{‰îŒì_”F’mÇ¾Š³
            } else if(detail.containsKey("1260311")){
                unitData = detail.get("1260311");
            }
        }
        // —\–h’ZŠú—Ã—{ƒ†ƒjƒbƒgŒ^€ŒÂº
        if ("2622".equals(serviceCodeItem)) {
        	// ‰îŒì—\–h’ZŠú“üŠ—Ã—{‰îŒì_•a‰@—Ã—{
        	if(detail.containsKey("1260115")){
                unitData = detail.get("1260115");
            // ’ZŠú“üŠ—Ã—{‰îŒì_f—ÃŠ—Ã—{
            } else if(detail.containsKey("1260212")){
                unitData = detail.get("1260212");
            // ’ZŠú“üŠ—Ã—{‰îŒì_”F’mÇ¾Š³
            } else if(detail.containsKey("1260312")){
                unitData = detail.get("1260312");
            }
        }
        // —\–h’ZŠú—Ã—{]—ˆŒ^ŒÂº
        if ("2623".equals(serviceCodeItem)) {
        	// ‰îŒì—\–h’ZŠú“üŠ—Ã—{‰îŒì_•a‰@—Ã—{
        	if(detail.containsKey("1260116")){
                unitData = detail.get("1260116");
            // ’ZŠú“üŠ—Ã—{‰îŒì_f—ÃŠ—Ã—{
            } else if(detail.containsKey("1260213")){
                unitData = detail.get("1260213");
            // ’ZŠú“üŠ—Ã—{‰îŒì_”F’mÇ¾Š³
            } else if(detail.containsKey("1260313")){
                unitData = detail.get("1260313");
            }
        }
        // —\–h’ZŠú—Ã—{‘½°º
        if ("2624".equals(serviceCodeItem)) {
        	// ‰îŒì—\–h’ZŠú“üŠ—Ã—{‰îŒì_•a‰@—Ã—{
        	if(detail.containsKey("1260117")){
                unitData = detail.get("1260117");
            // ’ZŠú“üŠ—Ã—{‰îŒì_f—ÃŠ—Ã—{
            } else if(detail.containsKey("1260214")){
                unitData = detail.get("1260214");
            // ’ZŠú“üŠ—Ã—{‰îŒì_”F’mÇ¾Š³
            } else if(detail.containsKey("1260314")){
                unitData = detail.get("1260314");
            }
        }
        // [H27.4‰ü³‘Î‰][Shinobu Hitaka] 2015/1/20 edit - end ƒT[ƒrƒXƒR[ƒh‰p”‰»
        
        if(unitData != null){
            unit = ACCastUtilities.toInt(unitData,Integer.MIN_VALUE);
        }
        
        return unit;
    }
    
    /**
     * w’è‚³‚ê‚½–‹ÆŠ‚ªw’è‚³‚ê‚½ƒT[ƒrƒX‚ğĞ•ŸŒ¸–Æ‚Ì‘ÎÛ‚Æ‚µ‚Ä‚¢‚é‚©B
     * @param providerId
     * @param systemServiceCode
     * @return
     * @throws Exception
     */
    protected boolean isReduction(String providerId, String systemServiceCode) throws Exception {
        VRMap map = (VRMap)providerDetailMap.get(providerId);
        //–‹ÆŠÚ×î•ñ‚Ìæ“¾Šm”F
        if(map == null){
            return false;
        }
        
        VRMap detail = (VRMap)map.get(new Integer(systemServiceCode));
        
        //ŠY“–‚ÌƒVƒXƒeƒ€ƒT[ƒrƒXƒR[ƒh‚ÌÚ×æ“¾Šm”F
        if(detail == null){
            return false;
        }
        
        //Ğ•ŸŒ¸–Æƒ`ƒFƒbƒN‚Ìƒf[ƒ^‚ğ•Û‚µ‚Ä‚¢‚é‚©Šm”F
        if(!detail.containsKey("1")) return false;
        
        if(ACCastUtilities.toInt(detail.get("1"),1) != 2){
            return false;
        }
        
        return true;
    }
	
	
	/**
	 * w’è‚µ‚½–‹ÆŠ‚Ì’nˆæ’P‰¿‚ğæ“¾‚µ‚Ü‚·B
	 * @return
	 * @throws Exception
	 */
	protected double getAreaUnitPrice(String providerId,String systemServiceKindDetail, String targetDateMonth) throws Exception {
		
		//–‹ÆŠ‚ÌPROVIDER_AREA_TYPE‚ğæ“¾‚µAŒŸõƒL[‚Æ‚·‚é
		String key = systemServiceKindDetail + ACCastUtilities.toString(VRBindPathParser.get((providerId) + "/PROVIDER_AREA_TYPE",providerMap));
		//int target = Integer.parseInt(targetDateMonth) * 100 + 1;
		
		if(!areaUnitMap.containsKey(key)) {
			return 0;
		}
		VRMap map = (VRMap)VRBindPathParser.get(key,areaUnitMap);
		return Double.parseDouble(String.valueOf(VRBindPathParser.get("UNIT_PRICE_VALUE",map)));
		
		//[ID:0000458][Shin Fujihara] 2009/03/13 delete begin áŠQ‘Î‰
		/*
		while(true){
			if(!areaUnitMap.containsKey(key)) break;
			VRMap map = (VRMap)VRBindPathParser.get(key,areaUnitMap);
			
			int start = getInt("UNIT_VALID_START",map);
			int end = getInt("UNIT_VALID_END",map);
			
			//”­Œ©
			if((start <= target) && (target <= end)){
				return Double.parseDouble(String.valueOf(VRBindPathParser.get("UNIT_PRICE_VALUE",map)));
			}
		}
		
		return 0;
		*/
		//[ID:0000458][Shin Fujihara] 2009/03/13 delete end áŠQ‘Î‰
	}
	
	/**
	 * Š„ˆø—¦‚ğl—¶‚µ‚½ƒT[ƒrƒX’PˆÊ”‚ğ•Ô‹p‚µ‚Ü‚·B
	 * @return ƒT[ƒrƒX’PˆÊ”
	 */
	protected int getServiceUnit(String providerId, VRMap serviceCode) throws Exception {
		//providerServiceMap
		int reductRate = getReductRate(providerId,serviceCode);
		int unit = ACCastUtilities.toInt(VRBindPathParser.get("SERVICE_UNIT",serviceCode));
        
        /*•ÊŠÖ”‚ÉØ‚èo‚µ(“E—v—“‚ÉŠ„ˆø—¦‚ğ‹LÚ‚·‚é•K—v‚ª‚ ‚é‚½‚ß)
		String key = providerId +
			           ACCastUtilities.toString(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL",serviceCode));
		
		if(providerServiceMap.containsKey(key)){
			VRMap map = (VRMap)providerServiceMap.get(key);
            if(!ACTextUtilities.isNullText(map.get("REDUCT_RATE"))){
                reductRate = ACCastUtilities.toInt(map.get("REDUCT_RATE"));
            }
		}
        */
        //lÌŒÜ“ü‚ÌŒë‚è
		//return (int)Math.ceil(unit * ((double)(100 - reductRate)/100));
        return (int)Math.round((double)unit * ((double)(100 - reductRate)/100d));
	}
    
    
    /**
     * ƒT[ƒrƒX‚ÌŠ„ˆø—¦‚ğæ“¾‚·‚éB
     * @param providerId –‹ÆŠ”Ô†
     * @param serviceCode ƒT[ƒrƒXƒR[ƒhƒIƒuƒWƒFƒNƒg
     * @return æ“¾‚µ‚½Š„ˆø—¦
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
    
    
    //[ID:0000462][Shin Fujihara] 2009/04 add begin •½¬21”N4Œ–@‰ü³‘Î‰
    /**
     * –‹ÆŠ‚ª’†RŠÔ’nˆæ‚Ì¬‹K–Í–‹ÆŠ‚Å‚ ‚é‚©‚ÌƒR[ƒh‚ğæ“¾‚·‚éB
     * @param serviceDetail
     * @return
     * 1:’†RŠÔ‚Å‚È‚¢
     * 2:’†RŠÔ‚Å‚ ‚é
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
    //[ID:0000462][Shin Fujihara] 2009/04 add end •½¬21”N4Œ–@‰ü³‘Î‰
    
	//[ID:0000682][Shin Fujihara] add begin y–@‰ü³‘Î‰z‰îŒìEˆõˆ‹ö‰ü‘P‰ÁZ
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
    //[ID:0000682][Shin Fujihara] add end y–@‰ü³‘Î‰z‰îŒìEˆõˆ‹ö‰ü‘P‰ÁZ
    
	/**
	 * ‹­§“I‚Éint‚É•ÏŠ·‚·‚éB
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
	    “Á’èf—Ã”ïî•ñ
	=============================================================*/
	//[ID:0000454][Shin Fujihara] 2009/05/01 delete begin áŠQ‘Î‰
	//[H20.5 –@‰ü³‘Î‰] fujihara edit start
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
//	//[H20.5 –@‰ü³‘Î‰] fujihara edit end
	//[ID:0000454][Shin Fujihara] 2009/05/01 delete end áŠQ‘Î‰
	
	//[ID:0000454][Shin Fujihara] 2009/05/01 add begin áŠQ‘Î‰
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
				
				//“ú•t”äŠr
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
	//[ID:0000454][Shin Fujihara] 2009/05/01 add end áŠQ‘Î‰
    
    /*=============================================================
         ƒT[ƒrƒX–¼ÌŠÖ˜A
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
         •ÛŒ¯Ò–¼ÌŠÖ˜A
    =============================================================*/
    protected String getInsurerName(String insurerId) throws Exception {
        String result = "";
        if(insurer.containsKey(insurerId)){
            result = String.valueOf(((VRMap)insurer.get(insurerId)).get("INSURER_NAME"));
        }
        return result;
    }
	
    
    //[H20.4 –@‰ü³‘Î‰] fujihara add start
    public Date getTargetDate(){
    	return this.targetDate;
    }
    //[H20.4 –@‰ü³‘Î‰] fujihara add end
    
    //[ID:0000641][Shin Fujihara] 2011/04/14 add begin
    //H”ï‚ÌŠî€Šz‚ğæ“¾
    public int getDefaultFoodCost() {
    	//H”ï‚ÌƒR[ƒh‚Íu1v
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
