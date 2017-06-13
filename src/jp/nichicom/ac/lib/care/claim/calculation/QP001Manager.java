
/*
 * Project code name "ORCA"
 * ���t�Ǘ��䒠�\�t�g QKANCHO�iJMA care benefit management software�j
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
 * �A�v��: QKANCHO
 * �J����: �����@�L
 * �쐬��: 2006/01/24  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X �������� (001)
 * �v���O���� �����f�[�^�쐬���}�X�^�f�[�^�Ǘ� (QP001Manager)
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
 * ���яW�v���̃}�X�^�f�[�^���Ǘ�����B
 * ������
 * ���Ə����
 * ����f�Ô���
 * �𓝊�����B
 *
 */
public class QP001Manager {

	/**
	 * ������
	 */
	private VRMap kohiData = new VRLinkedHashMap();
	/**
	 * ����-�T�[�r�X�R�[�h�Ή��\
	 */
	private VRMap kohiServiceData = new VRLinkedHashMap();
	/**
	 * ���Ə����
	 */
	private VRMap providerMap = new VRHashMap();
	/**
	 * �P�ʐ��P���}�X�^���擾
	 */
	private VRMap areaUnitMap = new VRHashMap();
	
	/**
	 * ���Ǝҏڍ׏��
	 */
	private VRMap providerDetailMap = new VRHashMap();
	
	/**
	 * ���Ə����������
	 */
	private VRMap providerServiceMap = new VRHashMap();
	
	/**
	 * ����f�Ô���
	 */
	//[ID:0000454][Shin Fujihara] 2009/05/01 edit begin ��Q�Ή�
	//private VRMap specialClinicData = new VRLinkedHashMap();
	private VRList specialClinicData = new VRArrayList();
	//[ID:0000454][Shin Fujihara] 2009/05/01 edit end ��Q�Ή�
    
    /**
     * �T�[�r�X����
     */
    private VRMap serviceName = new VRHashMap();
    
    /**
     * �ی��Җ���
     */
    private VRMap insurer = new VRHashMap();
	
    //[H20.4 �@�����Ή�] fujihara add start
    //�T�[�r�X�񋟔N��
    private Date targetDate = null;
    //[H20.4 �@�����Ή�] fujihara add end
    
    // [ID:0000641][Shin Fujihara] 2011/04/14 add begin
    // M_RESIDENCE_FOOD_COST����擾�����A�H��E���Z��̏��
    private VRMap residenceFoodCost = new VRHashMap();
    // [ID:0000641][Shin Fujihara] 2011/04/14 add end
	
    
// 2016/8/16 [�������ƑΉ�][Yoichiro Kamei] add - begin
    private int jigyotaishoLimitRate = 0; // ���ƑΏێ҂̍���̋敪�x�����x�z
    
    private void setJigyotaishoLimitRate(ACDBManager dbm,Date targetDate) throws Exception {
        this.jigyotaishoLimitRate = QkanCommon.getOfficialLimitRate(dbm,
            targetDate, new Integer(1), String.valueOf(QkanConstants.YOUKAIGODO_JIGYOTAISHO));
    }
    
    // ���ƑΏێ҂̍���̋敪�x�����x�z���擾���܂�
    public int getJigyotaishoLimitRate() {
        return this.jigyotaishoLimitRate;
    }
// 2016/8/16 [�������ƑΉ�][Yoichiro Kamei] add - end
    
	/**
	 * �R���X�g���N�^
	 * �}�X�^�f�[�^�̏��������s���B
	 * @param dbm
	 */
	public QP001Manager(ACDBManager dbm,Date targetDate) throws Exception {
		//������̏�����
		//[ID:0000465][Shin Fujihara] 2009/04 add begin ����21�N4���@�����Ή�
		//initializationKohi(dbm);
		initializationKohi(dbm,targetDate);
		//[ID:0000465][Shin Fujihara] 2009/04 add end ����21�N4���@�����Ή�
		
		//���Ə����̏�����
		//[ID:0000458][Shin Fujihara] 2009/03/13 edit begin ��Q�Ή�
		//initializationProvider(dbm);
		initializationProvider(dbm,targetDate);
		//[ID:0000458][Shin Fujihara] 2009/03/13 edit end ��Q�Ή�
		
		//����f�Ô���̏�����
		initializationSpecialClinic(dbm,targetDate);
        
        //�T�[�r�X���̂̏�����
        initializationServiceName(dbm);
        
        //�ی��Җ��̂̏�����
        initializationInsurerName(dbm);
        
        //[H20.4 �@�����Ή�] fujihara add start
        this.targetDate = targetDate;
        //[H20.4 �@�����Ή�] fujihara add end
        
        // 2016/8/16 [�������ƑΉ�][Yoichiro Kamei] add - begin
        setJigyotaishoLimitRate(dbm, targetDate);
        // 2016/8/16 [�������ƑΉ�][Yoichiro Kamei] add - end
	}
	
	/**
	 * ������̏��������s���܂��B
	 * @param dbm
	 * @throws Exception
	 */
	//[ID:0000465][Shin Fujihara] 2009/04 add begin ����21�N4���@�����Ή�
	//private void initializationKohi(ACDBManager dbm) throws Exception {
	private void initializationKohi(ACDBManager dbm, Date targetDate) throws Exception {
	//[ID:0000465][Shin Fujihara] 2009/04 add end ����21�N4���@�����Ή�
		
      	//[ID:0000465][Shin Fujihara] 2009/04 add begin ����21�N4���@�����Ή�
		String targetStart = VRDateParser.format(ACDateUtilities.toFirstDayOfMonth(targetDate), "yyyy/MM/dd");
		String targetEnd = VRDateParser.format(ACDateUtilities.toLastDayOfMonth(targetDate), "yyyy/MM/dd");
      	//[ID:0000465][Shin Fujihara] 2009/04 add end ����21�N4���@�����Ή�
		
		
		StringBuilder sb = new StringBuilder();
		//����}�X�^�擾
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
		//[ID:0000465][Shin Fujihara] 2009/04 add begin ����21�N4���@�����Ή�
		sb.append(" WHERE");
		sb.append(" (KOHI_VALID_START  <='" + targetEnd + "')");
		sb.append(" AND (KOHI_VALID_END  >= '" + targetStart + "')");
		//[ID:0000465][Shin Fujihara] 2009/04 add end ����21�N4���@�����Ή�
		sb.append(" ORDER BY KOHI_SORT ASC");
		
		VRList list = dbm.executeQuery(sb.toString());
		
		
		ACBindUtilities.setMapFromArray(list,kohiData,"KOHI_TYPE");
		
		//����-�T�[�r�X�}�X�^�擾
		sb = new StringBuilder();
		
		sb.append(" SELECT");
		sb.append(" KOHI_TYPE || SYSTEM_SERVICE_KIND_DETAIL || APPLICATION_TYPE AS CODE,");
		sb.append(" KOHI_TYPE,");
		sb.append(" SYSTEM_SERVICE_KIND_DETAIL,");
		sb.append(" APPLICATION_TYPE,");
		sb.append(" BY_MEDICAL_FLAG");
		sb.append(" FROM");
		sb.append(" M_KOHI_SERVICE");
		//[ID:0000465][Shin Fujihara] 2009/04 add begin ����21�N4���@�����Ή�
		sb.append(" WHERE");
		sb.append(" (KOHI_SERVICE_VALID_START  <='" + targetEnd + "')");
		sb.append(" AND (KOHI_SERVICE_VALID_END  >= '" + targetStart + "')");
		//[ID:0000465][Shin Fujihara] 2009/04 add end ����21�N4���@�����Ή�
		
		list = dbm.executeQuery(sb.toString());
		
		ACBindUtilities.setMapFromArray(list,kohiServiceData,"CODE");
	}
	
	/**
	 * ���Ə����̏�����
	 * @param dbm
	 * @throws Exception
	 */
	//[ID:0000458][Shin Fujihara] 2009/03/13 edit begin ��Q�Ή�
	//private void initializationProvider(ACDBManager dbm) throws Exception {
	private void initializationProvider(ACDBManager dbm, Date targetDate) throws Exception {
	//[ID:0000458][Shin Fujihara] 2009/03/13 edit end ��Q�Ή�
		//���Ə����̎擾
		VRList providerList = QkanCommon.getProviderInfo(dbm);
		//���Ə����������p��Map�ɓW�J
      	ACBindUtilities.setMapFromArray(providerList,providerMap,"PROVIDER_ID");
      	//���Ə����ڍ�
      	for(int i = 0; i < providerList.getDataSize(); i++){
      		VRMap providerTemp = (VRMap)providerList.getData(i);
      		String providerId = ACCastUtilities.toString(VRBindPathParser.get("PROVIDER_ID",providerTemp));
      		//
      		VRList list = QkanCommon.getProviderServiceDetail(dbm, providerId);
      		VRMap map = new VRHashMap();
            ACBindUtilities.setMapFromArray(list,map,"SYSTEM_SERVICE_KIND_DETAIL");
      		providerDetailMap.put(providerId,map);
      	}
      	
      	//[ID:0000458][Shin Fujihara] 2009/03/13 add begin ��Q�Ή�
		Date targetDateStart = ACDateUtilities.toFirstDayOfMonth(targetDate);
		Date targetDateEnd = ACDateUtilities.toLastDayOfMonth(targetDate);
      	//[ID:0000458][Shin Fujihara] 2009/03/13 add end ��Q�Ή�
      	
      	//�P���}�X�^�̎擾
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
      	
      	//[ID:0000458][Shin Fujihara] 2009/03/13 add begin ��Q�Ή�
		sb.append(" WHERE");
		sb.append(" (UNIT_VALID_START  <='" + VRDateParser.format(targetDateEnd,"yyyy/MM/dd") + "')");
		sb.append(" AND (UNIT_VALID_END  >= '" + VRDateParser.format(targetDateStart,"yyyy/MM/dd") + "')");
		//[ID:0000458][Shin Fujihara] 2009/03/13 add end ��Q�Ή�
      	
      	ACBindUtilities.setMapFromArray(dbm.executeQuery(sb.toString()),areaUnitMap,"CODE");
      	
      	//���Ə��̊������̎擾
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
      	// �H��E���Z��̊�z���擾
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
	 * ����f�Ô���̏��������s���܂��B
	 * @param dbm
	 * @param targetDate
	 * @throws Exception
	 */
	private void initializationSpecialClinic(ACDBManager dbm,Date targetDate) throws Exception {
		//[ID:0000454][Shin Fujihara] 2009/05/01 delete begin ��Q�Ή�
		/*
		StringBuilder sb = new StringBuilder();
		Date targetDateStart = ACDateUtilities.toFirstDayOfMonth(targetDate);
		Date targetDateEnd = ACDateUtilities.toLastDayOfMonth(targetDate);
		
		sb.append(" SELECT");
		//[H20.5 �@�����Ή�] fujihara edit start
		//sb.append(" SPECIAL_CLINIC_TYPE");
		sb.append(" RECORD_TYPE || '-' || SPECIAL_CLINIC_TYPE AS KEY_VALUE");
		//[H20.5 �@�����Ή�] fujihara edit end
		sb.append(" ,SPECIAL_CLINIC_NAME");
		sb.append(" ,SPECIAL_CLINIC_UNIT");
		sb.append(" FROM");
		sb.append(" M_SPECIAL_CLINIC");
		sb.append(" WHERE");
		sb.append(" (SPECIAL_CLINIC_VALID_START <='" + VRDateParser.format(targetDateEnd,"yyyy/MM/dd") + "')");
		sb.append(" AND (SPECIAL_CLINIC_VALID_END >= '" + VRDateParser.format(targetDateStart,"yyyy/MM/dd") + "')");
		//[H20.5 �@�����Ή�] fujihara edit start
		//ACBindUtilities.setMapFromArray(dbm.executeQuery(sb.toString()),specialClinicData,"SPECIAL_CLINIC_TYPE");
		ACBindUtilities.setMapFromArray(dbm.executeQuery(sb.toString()),specialClinicData,"KEY_VALUE");
		//[H20.5 �@�����Ή�] fujihara edit end
		*/
		//[ID:0000454][Shin Fujihara] 2009/05/01 delete end ��Q�Ή�
		//[ID:0000454][Shin Fujihara] 2009/05/01 add begin ��Q�Ή�
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
		//[ID:0000454][Shin Fujihara] 2009/05/01 add end ��Q�Ή�
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
	    ����֘A
	====================================================*/
	/**
	 * �w�肳�ꂽ����^�C�v�̋��t����ԋp���܂��B
	 * @param kohiType �擾�������^�C�v
	 * @return
	 * @throws Exception
	 */
    /* ���p�҂̏�񂩂�擾����悤�ύX
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
	 * ����^�C�v�ƃV�X�e�����̃T�[�r�X�R�[�h����Y���������̏���ԋp���܂��B
	 * �Y��������݂��Ȃ��ꍇ��null��ԋp���܂��B
	 * @param kohiType
	 * @param systemServiceKindDetail
	 * @param applicationType
	 * @return
	 * @throws Exception
	 */
	public VRMap getKohiMatchData(String kohiType, String systemServiceKindDetail,String applicationType) throws Exception {
        VRMap result = null;
		String key = kohiType + systemServiceKindDetail + applicationType;
		//M_KOHI_SERVICE��KOHI_TYPE,SYSTEM_SERVICE_KIND_DETAIL��
		//�Q�Ƃ��A�Y���T�[�r�X�����݂��邩�`�F�b�N
		if(kohiServiceData.containsKey(key)){
            result = (VRMap)VRBindPathParser.get(new Integer(kohiType),kohiData);
            result.put("BY_MEDICAL_FLAG", ((VRMap)kohiServiceData.get(key)).get("BY_MEDICAL_FLAG"));
            result.put("APPLICATION_TYPE", ((VRMap)kohiServiceData.get(key)).get("APPLICATION_TYPE"));
        }
		//����̏ڍ׏����擾
		return result;
		
	}
	/**
	 * ����ʂ��擾����B
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
     * ����}�X�^�������擾����B
     * @param kohiType ����^�C�v
     * @param key �擾����t�B�[���h����
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
	   ���Ə��֘A
	================================================================*/
	/**
	 * �w�肵�����Ə��̓��ʒn����Z�t���O���擾����B
	 * @param providerId
	 * @return
	 * @throws Exception
	 */
    public String getSpecialAreaFlag(String providerId) throws Exception {
		return ACCastUtilities.toString(VRBindPathParser.get((providerId) + "/SPECIAL_AREA_FLAG",providerMap));
	}
	/**
	 * �w�肵�����Ə��̎��Ə����̂��擾����B
	 * @param providerId
	 * @return
	 * @throws Exception
	 */
	
	protected String getProviderName(String providerId) throws Exception {
		return ACCastUtilities.toString(VRBindPathParser.get((providerId) + "/PROVIDER_NAME",providerMap));
	}
	/**
	 * �w�肵�����Ə��̏Z�����擾����B
	 * @param providerId
	 * @return
	 * @throws Exception
	 */
	protected String getProviderAddress(String providerId) throws Exception {
		return ACCastUtilities.toString(VRBindPathParser.get((providerId) + "/PROVIDER_ADDRESS",providerMap));
	}
	/**
	 * �w�肵�����Ə��̓d�b�ԍ����擾����B
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
	 * �w�肵�����Ə��̎��Ƌ敪���擾����B<br>
	 * 1-�w�� 2-��Y��
	 * @param providerId
	 * @return
	 * @throws Exception
	 */
	protected int getProviderJigyouType(String providerId) throws Exception {
		return ACCastUtilities.toInt(VRBindPathParser.get((providerId) + "/PROVIDER_JIGYOU_TYPE",providerMap));
	}
    
    /**
     * �w�肵�����Ə��̓��p���ԃt���O���擾����B<br>
     * 1-��Ë@�� 0-����ȊO
     * @param providerId ���Ə��ԍ�
     * @return �擾������Ë@�փt���O
     * @throws Exception
     */
    protected int getProviderMedicalFlag(String providerId) throws Exception {
        return ACCastUtilities.toInt(VRBindPathParser.get((providerId) + "/MEDICAL_FLAG",providerMap));
    }
	
	/**
	 * ���Ə��̃X�e�[�V�����R�[�h���擾����B
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
     * ���Ə��ɓo�^����Ă���z�e���R�X�g���擾���܂��B
     * @param providerId ���Ə��ԍ�
     * @param serviceCodeItem �T�[�r�X�R�[�h 
     * @return �o�^����Ă���z�e���R�X�g
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
        
        // [H27.4�����Ή�][Shinobu Hitaka] 2015/1/20 edit - begin �T�[�r�X�R�[�h�p����
        /*
        switch(ACCastUtilities.toInt(serviceCodeItem,0)){
        //�Z���������j�b�g�^��
        case 2121:
        //�Z���V�����j�b�g�^��
        case 2221:
        //�Z���×{���j�b�g�^��
        case 2321:
        //�����{�݃��j�b�g�^��
        case 5121:
        //�ی��{�݃��j�b�g�^��
        case 5221:
        //�×{�{�݃��j�b�g�^��
        case 5321:
        //�n�敟���{�݃��j�b�g�^��
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
            
            
        //�Z���������j�b�g�^����
        case 2122:
        //�Z���V�����j�b�g�^����
        case 2222:
        //�Z���×{���j�b�g�^����
        case 2322:
        //�����{�݃��j�b�g�^����
        case 5122:
        //�ی��{�݃��j�b�g�^����
        case 5222:
        //�×{�{�݃��j�b�g�^����
        case 5322:
        //�n�敟���{�݃��j�b�g�^����
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
        //�Z�������]���^��
        case 2123:
        //�Z���V���]���^��
        case 2223:
        //�Z���×{�]���^��
        case 2323:
        //�����{�ݏ]���^��
        case 5123:
        //�ی��{�ݏ]���^��
        case 5223:
        //�×{�{�ݏ]���^��
        case 5323:
        //�n�敟���{�ݏ]���^��
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
            
        //�Z������������
        case 2124:
        //�Z���V��������
        case 2224:
        //�Z���×{������
        case 2324:
        //�����{�ݑ�����
        case 5124:
        //�ی��{�ݑ�����
        case 5224:
        //�×{�{�ݑ�����
        case 5324:
        //�n�敟���{�ݑ�����
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
            
            
        //[ID:0000641][Shin Fujihara] 2011/04/13 add begin �\�h�T�[�r�X�̎����擾�R��
        // �\�h�Z���������j�b�g�^��
        case 2421:
        	if(detail.containsKey("1240112")){
                unitData = detail.get("1240112");
            }
        	break;
        // �\�h�Z���������j�b�g�^����
        case 2422:
        	if(detail.containsKey("1240113")){
                unitData = detail.get("1240113");
            }
        	break;
        // �\�h�Z�������]���^��
        case 2423:
        	if(detail.containsKey("1240114")){
                unitData = detail.get("1240114");
            }
        	break;
        // �\�h�Z������������
        case 2424:
        	if(detail.containsKey("1240115")){
                unitData = detail.get("1240115");
            }
        	break;
        	
        	
        // �\�h�Z���V�����j�b�g�^��
        case 2521:
        	if(detail.containsKey("1250112")){
                unitData = detail.get("1250112");
            }
        	break;
        // �\�h�Z���V�����j�b�g�^����
        case 2522:
        	if(detail.containsKey("1250113")){
                unitData = detail.get("1250113");
            }
        	break;
        // �\�h�Z�������]���^��
        case 2523:
        	if(detail.containsKey("1250114")){
                unitData = detail.get("1250114");
            }
        	break;
        // �\�h�Z������������
        case 2524:
        	if(detail.containsKey("1250115")){
                unitData = detail.get("1250115");
            }
        	break;
        	
        	
        // �\�h�Z���×{���j�b�g�^��
        case 2621:
        	// ���\�h�Z�������×{���_�a�@�×{
        	if(detail.containsKey("1260114")){
                unitData = detail.get("1260114");
            // �Z�������×{���_�f�Ï��×{
            } else if(detail.containsKey("1260211")){
                unitData = detail.get("1260211");
            // �Z�������×{���_�F�m�ǎ���
            } else if(detail.containsKey("1260311")){
                unitData = detail.get("1260311");
            }
        	break;
        // �\�h�Z���×{���j�b�g�^����
        case 2622:
        	// ���\�h�Z�������×{���_�a�@�×{
        	if(detail.containsKey("1260115")){
                unitData = detail.get("1260115");
            // �Z�������×{���_�f�Ï��×{
            } else if(detail.containsKey("1260212")){
                unitData = detail.get("1260212");
            // �Z�������×{���_�F�m�ǎ���
            } else if(detail.containsKey("1260312")){
                unitData = detail.get("1260312");
            }
        	break;
        // �\�h�Z���×{�]���^��
        case 2623:
        	// ���\�h�Z�������×{���_�a�@�×{
        	if(detail.containsKey("1260116")){
                unitData = detail.get("1260116");
            // �Z�������×{���_�f�Ï��×{
            } else if(detail.containsKey("1260213")){
                unitData = detail.get("1260213");
            // �Z�������×{���_�F�m�ǎ���
            } else if(detail.containsKey("1260313")){
                unitData = detail.get("1260313");
            }
        	break;
        // �\�h�Z���×{������
        case 2624:
        	// ���\�h�Z�������×{���_�a�@�×{
        	if(detail.containsKey("1260117")){
                unitData = detail.get("1260117");
            // �Z�������×{���_�f�Ï��×{
            } else if(detail.containsKey("1260214")){
                unitData = detail.get("1260214");
            // �Z�������×{���_�F�m�ǎ���
            } else if(detail.containsKey("1260314")){
                unitData = detail.get("1260314");
            }
        	break;
        //[ID:0000641][Shin Fujihara] 2011/04/13 add end �\�h�T�[�r�X�̎����擾�R��
        }
        */
        
        if ("2121".equals(serviceCodeItem)  	//�Z���������j�b�g�^��
        	|| "2221".equals(serviceCodeItem)	//�Z���V�����j�b�g�^��
        	|| "2321".equals(serviceCodeItem)	//�Z���×{���j�b�g�^��
        	|| "5121".equals(serviceCodeItem)	//�����{�݃��j�b�g�^��
        	|| "5221".equals(serviceCodeItem)	//�ی��{�݃��j�b�g�^��
        	|| "5321".equals(serviceCodeItem)	//�×{�{�݃��j�b�g�^��
        	|| "5421".equals(serviceCodeItem)	//�n�敟���{�݃��j�b�g�^��
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
        
        if ("2122".equals(serviceCodeItem)  	//�Z���������j�b�g�^����
        	|| "2222".equals(serviceCodeItem)	//�Z���V�����j�b�g�^����
        	|| "2322".equals(serviceCodeItem)	//�Z���×{���j�b�g�^����
        	|| "5122".equals(serviceCodeItem)	//�����{�݃��j�b�g�^����
        	|| "5222".equals(serviceCodeItem)	//�ی��{�݃��j�b�g�^����
        	|| "5322".equals(serviceCodeItem)	//�×{�{�݃��j�b�g�^����
        	|| "5422".equals(serviceCodeItem)	//�n�敟���{�݃��j�b�g�^����
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
        
        if ("2123".equals(serviceCodeItem)   	//�Z�������]���^��
        	|| "2223".equals(serviceCodeItem)	//�Z���V���]���^��
        	|| "2323".equals(serviceCodeItem)	//�Z���×{�]���^��
        	|| "5123".equals(serviceCodeItem)	//�����{�ݏ]���^��
        	|| "5223".equals(serviceCodeItem)	//�ی��{�ݏ]���^��
        	|| "5323".equals(serviceCodeItem)	//�×{�{�ݏ]���^��
        	|| "5423".equals(serviceCodeItem)	//�n�敟���{�ݏ]���^��
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

        if ("2124".equals(serviceCodeItem)   	//�Z������������
        	|| "2224".equals(serviceCodeItem)	//�Z���V��������
        	|| "2324".equals(serviceCodeItem)	//�Z���×{������
        	|| "5124".equals(serviceCodeItem)	//�����{�ݑ�����
        	|| "5224".equals(serviceCodeItem)	//�ی��{�ݑ�����
        	|| "5324".equals(serviceCodeItem)	//�×{�{�ݑ�����
        	|| "5424".equals(serviceCodeItem)	//�n�敟���{�ݑ�����
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
        
        //�\�h�Z���������j�b�g�^��
        if ("2421".equals(serviceCodeItem)) {
            if(detail.containsKey("1240112")){
                unitData = detail.get("1240112");
            }
        }
        //�\�h�Z���������j�b�g�^����
        if ("2422".equals(serviceCodeItem)) {
            if(detail.containsKey("1240113")){
                unitData = detail.get("1240113");
            }
        }
        //�\�h�Z�������]���^��
        if ("2423".equals(serviceCodeItem)) {
            if(detail.containsKey("1240114")){
                unitData = detail.get("1240114");
            }
        }
        //�\�h�Z������������
        if ("2424".equals(serviceCodeItem)) {
            if(detail.containsKey("1240115")){
                unitData = detail.get("1240115");
            }
        }
        //�\�h�Z���V�����j�b�g�^��
        if ("2521".equals(serviceCodeItem)) {
            if(detail.containsKey("1250112")){
                unitData = detail.get("1250112");
            }
        }
        //�\�h�Z���V�����j�b�g�^����
        if ("2522".equals(serviceCodeItem)) {
        	if(detail.containsKey("1250113")){
                unitData = detail.get("1250113");
            }
        }
        //�\�h�Z�������]���^��
        if ("2523".equals(serviceCodeItem)) {
        	if(detail.containsKey("1250114")){
                unitData = detail.get("1250114");
            }
        }
        //�\�h�Z������������
        if ("2524".equals(serviceCodeItem)) {
        	if(detail.containsKey("1250115")){
                unitData = detail.get("1250115");
            }
        }
        // �\�h�Z���×{���j�b�g�^��
        if ("2621".equals(serviceCodeItem)) {
        	// ���\�h�Z�������×{���_�a�@�×{
        	if(detail.containsKey("1260114")){
                unitData = detail.get("1260114");
            // �Z�������×{���_�f�Ï��×{
            } else if(detail.containsKey("1260211")){
                unitData = detail.get("1260211");
            // �Z�������×{���_�F�m�ǎ���
            } else if(detail.containsKey("1260311")){
                unitData = detail.get("1260311");
            }
        }
        // �\�h�Z���×{���j�b�g�^����
        if ("2622".equals(serviceCodeItem)) {
        	// ���\�h�Z�������×{���_�a�@�×{
        	if(detail.containsKey("1260115")){
                unitData = detail.get("1260115");
            // �Z�������×{���_�f�Ï��×{
            } else if(detail.containsKey("1260212")){
                unitData = detail.get("1260212");
            // �Z�������×{���_�F�m�ǎ���
            } else if(detail.containsKey("1260312")){
                unitData = detail.get("1260312");
            }
        }
        // �\�h�Z���×{�]���^��
        if ("2623".equals(serviceCodeItem)) {
        	// ���\�h�Z�������×{���_�a�@�×{
        	if(detail.containsKey("1260116")){
                unitData = detail.get("1260116");
            // �Z�������×{���_�f�Ï��×{
            } else if(detail.containsKey("1260213")){
                unitData = detail.get("1260213");
            // �Z�������×{���_�F�m�ǎ���
            } else if(detail.containsKey("1260313")){
                unitData = detail.get("1260313");
            }
        }
        // �\�h�Z���×{������
        if ("2624".equals(serviceCodeItem)) {
        	// ���\�h�Z�������×{���_�a�@�×{
        	if(detail.containsKey("1260117")){
                unitData = detail.get("1260117");
            // �Z�������×{���_�f�Ï��×{
            } else if(detail.containsKey("1260214")){
                unitData = detail.get("1260214");
            // �Z�������×{���_�F�m�ǎ���
            } else if(detail.containsKey("1260314")){
                unitData = detail.get("1260314");
            }
        }
        // [H27.4�����Ή�][Shinobu Hitaka] 2015/1/20 edit - end �T�[�r�X�R�[�h�p����
        
        if(unitData != null){
            unit = ACCastUtilities.toInt(unitData,Integer.MIN_VALUE);
        }
        
        return unit;
    }
    
    /**
     * �w�肳�ꂽ���Ə����w�肳�ꂽ�T�[�r�X���Е����Ƃ̑ΏۂƂ��Ă��邩�B
     * @param providerId
     * @param systemServiceCode
     * @return
     * @throws Exception
     */
    protected boolean isReduction(String providerId, String systemServiceCode) throws Exception {
        VRMap map = (VRMap)providerDetailMap.get(providerId);
        //���Ə��ڍ׏��̎擾�m�F
        if(map == null){
            return false;
        }
        
        VRMap detail = (VRMap)map.get(new Integer(systemServiceCode));
        
        //�Y���̃V�X�e���T�[�r�X�R�[�h�̏ڍ׎擾�m�F
        if(detail == null){
            return false;
        }
        
        //�Е����ƃ`�F�b�N�̃f�[�^��ێ����Ă��邩�m�F
        if(!detail.containsKey("1")) return false;
        
        if(ACCastUtilities.toInt(detail.get("1"),1) != 2){
            return false;
        }
        
        return true;
    }
	
	
	/**
	 * �w�肵�����Ə��̒n��P�����擾���܂��B
	 * @return
	 * @throws Exception
	 */
	protected double getAreaUnitPrice(String providerId,String systemServiceKindDetail, String targetDateMonth) throws Exception {
		
		//���Ə���PROVIDER_AREA_TYPE���擾���A�����L�[�Ƃ���
		String key = systemServiceKindDetail + ACCastUtilities.toString(VRBindPathParser.get((providerId) + "/PROVIDER_AREA_TYPE",providerMap));
		//int target = Integer.parseInt(targetDateMonth) * 100 + 1;
		
		if(!areaUnitMap.containsKey(key)) {
			return 0;
		}
		VRMap map = (VRMap)VRBindPathParser.get(key,areaUnitMap);
		return Double.parseDouble(String.valueOf(VRBindPathParser.get("UNIT_PRICE_VALUE",map)));
		
		//[ID:0000458][Shin Fujihara] 2009/03/13 delete begin ��Q�Ή�
		/*
		while(true){
			if(!areaUnitMap.containsKey(key)) break;
			VRMap map = (VRMap)VRBindPathParser.get(key,areaUnitMap);
			
			int start = getInt("UNIT_VALID_START",map);
			int end = getInt("UNIT_VALID_END",map);
			
			//����
			if((start <= target) && (target <= end)){
				return Double.parseDouble(String.valueOf(VRBindPathParser.get("UNIT_PRICE_VALUE",map)));
			}
		}
		
		return 0;
		*/
		//[ID:0000458][Shin Fujihara] 2009/03/13 delete end ��Q�Ή�
	}
	
	/**
	 * ���������l�������T�[�r�X�P�ʐ���ԋp���܂��B
	 * @return �T�[�r�X�P�ʐ�
	 */
	protected int getServiceUnit(String providerId, VRMap serviceCode) throws Exception {
		//providerServiceMap
		int reductRate = getReductRate(providerId,serviceCode);
		int unit = ACCastUtilities.toInt(VRBindPathParser.get("SERVICE_UNIT",serviceCode));
        
        /*�ʊ֐��ɐ؂�o��(�E�v���Ɋ��������L�ڂ���K�v�����邽��)
		String key = providerId +
			           ACCastUtilities.toString(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL",serviceCode));
		
		if(providerServiceMap.containsKey(key)){
			VRMap map = (VRMap)providerServiceMap.get(key);
            if(!ACTextUtilities.isNullText(map.get("REDUCT_RATE"))){
                reductRate = ACCastUtilities.toInt(map.get("REDUCT_RATE"));
            }
		}
        */
        //�l�̌ܓ��̌��
		//return (int)Math.ceil(unit * ((double)(100 - reductRate)/100));
        return (int)Math.round((double)unit * ((double)(100 - reductRate)/100d));
	}
    
    
    /**
     * �T�[�r�X�̊��������擾����B
     * @param providerId ���Ə��ԍ�
     * @param serviceCode �T�[�r�X�R�[�h�I�u�W�F�N�g
     * @return �擾����������
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
    
    
    //[ID:0000462][Shin Fujihara] 2009/04 add begin ����21�N4���@�����Ή�
    /**
     * ���Ə������R�Ԓn��̏��K�͎��Ə��ł��邩�̃R�[�h���擾����B
     * @param serviceDetail
     * @return
     * 1:���R�ԂłȂ�
     * 2:���R�Ԃł���
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
    //[ID:0000462][Shin Fujihara] 2009/04 add end ����21�N4���@�����Ή�
    
	//[ID:0000682][Shin Fujihara] add begin �y�@�����Ή��z���E���������P���Z
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
    //[ID:0000682][Shin Fujihara] add end �y�@�����Ή��z���E���������P���Z
    
	/**
	 * �����I��int�ɕϊ�����B
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
	    ����f�Ô���
	=============================================================*/
	//[ID:0000454][Shin Fujihara] 2009/05/01 delete begin ��Q�Ή�
	//[H20.5 �@�����Ή�] fujihara edit start
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
//	//[H20.5 �@�����Ή�] fujihara edit end
	//[ID:0000454][Shin Fujihara] 2009/05/01 delete end ��Q�Ή�
	
	//[ID:0000454][Shin Fujihara] 2009/05/01 add begin ��Q�Ή�
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
				
				//���t��r
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
	//[ID:0000454][Shin Fujihara] 2009/05/01 add end ��Q�Ή�
    
    /*=============================================================
         �T�[�r�X���̊֘A
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
         �ی��Җ��̊֘A
    =============================================================*/
    protected String getInsurerName(String insurerId) throws Exception {
        String result = "";
        if(insurer.containsKey(insurerId)){
            result = String.valueOf(((VRMap)insurer.get(insurerId)).get("INSURER_NAME"));
        }
        return result;
    }
	
    
    //[H20.4 �@�����Ή�] fujihara add start
    public Date getTargetDate(){
    	return this.targetDate;
    }
    //[H20.4 �@�����Ή�] fujihara add end
    
    //[ID:0000641][Shin Fujihara] 2011/04/14 add begin
    //�H��̊�z���擾
    public int getDefaultFoodCost() {
    	//�H��̃R�[�h�́u1�v
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
