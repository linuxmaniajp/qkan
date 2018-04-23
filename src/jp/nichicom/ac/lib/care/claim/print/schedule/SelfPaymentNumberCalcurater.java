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
 */
package jp.nichicom.ac.lib.care.claim.print.schedule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.calculation.QP001PatientState;
import jp.nichicom.ac.lib.care.claim.calculation.QP001SpecialCase;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanValidServiceCommon;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;

/**
 * �敪�x�����x�Ǘ��O�̉񐔁i�����j�P�ʎ��ȕ��S�Z��N���X
 * 
 * [H27.04�����Ή�]
 * �T�[�r�X�񋟑̐����Z���敪�x�����x�z�Ǘ��̑ΏۊO�ƂȂ�������
 * ���x�z�𒴂��ė��p�������͎��ȕ��S�ƂȂ�B
 * ���ȕ��S���̒P�ʐ���񐔂��Z�肷�邽�߂̃N���X
 * 
 * @author Yoichiro Kamei
 *
 */
public class SelfPaymentNumberCalcurater {
	
	private CareServiceCodeCalcurater calcurater;
	
	//�敪�x�����x�̊Ǘ����s��Ȃ��T�[�r�X���
	private static List<String> taishogaiKindList = Arrays.asList(new String[]{
		"31", "32", "34", "36", "37", "43", "51", "52", "53", "54"
		, "55" //2018.04
	});
	
	//���̃N���X�Œǉ������P�ʐ����i�[����KEY������
	//�i���ɐݒ�ς݂̃L�[�Əd�����Ȃ��悤�ɃN���X����t���Ă��܂��j
	private static String ADD_UNIT_NAME = SelfPaymentNumberCalcurater.class.getSimpleName() + "_SERVICE_UNIT";
	
	//��͑Ώۂ̃T�[�r�X�S�̂̃��X�g
	private List<Map<String, Object>> serviceAllList;
	
	//�P�ʐ��ςݏグ�Ώۂ̃T�[�r�X�̃��X�g
	private List<Map<String, Object>> targetServiceList;
	
	//���ȕ��S�ƂȂ�P�ʐ�
	private int selfPayUnit = 0;
	
	//�敪�x���Ǘ����x���Ƃ��Ẳ񐔁i���ۘA�ɐ����ł���񐔁j
	private int limitInNumber = 0;
	
	//�ΏۃT�[�r�X�R�[�h�̒P�ʐ�
	private int reductedUnit = 0;
	
	//�񐔂̌v��^�C�v
	private enum KeijoType {ALL,                  //���ׂČv��
	                        ONLY_JUSHOTI_TOKUREI, //�Z���n���ᕪ�̂݌v��
	                        NOT_JUSHOTI_TOKUREI   //�Z���n����łȂ����̂݌v��
	};
	
	/**
	 * �R���X�g���N�^�B
	 * 
	 * @param calcurater �����A�������ς݂�CareServiceCodeCalcurater
	 * @param serviceList ��͑ΏۂƂȂ�T�[�r�X�̃��X�g
	 */
	public SelfPaymentNumberCalcurater(CareServiceCodeCalcurater calcurater,
			List services) throws Exception {
		this.calcurater = calcurater;
		// �Q�Ɗ֌W�̂Ȃ��f�[�^���쐬����
		this.serviceAllList = QkanValidServiceCommon.deepCopyVRList(new VRArrayList(services));
	}
	
	/**
	 * �R���X�g���N�^�B
	 * 
	 * @param dbm ACDBManager
	 * @param targetDate �Ώ۔N��
	 * @param patientInfo patientInfo
	 * @param patientState QP001PatientState
	 * @param services ��͑ΏۂƂȂ�T�[�r�X�̃��X�g
	 */
	public SelfPaymentNumberCalcurater(ACDBManager dbm, 
			Date targetDate,
			VRMap patientInfo,
			QP001PatientState patientState,
			List services) throws Exception {
		// �T�[�r�X�P�ʌv�Z�N���X�𐶐�
		this.calcurater = new CareServiceCodeCalcurater();
		
		VRMap hashedProviders = new VRHashMap();
		ACBindUtilities.setMapFromArray(QkanCommon.getProviderInfo(dbm), hashedProviders, "PROVIDER_ID");
		int inSpecialFacilityFlag =  ACCastUtilities.toInt(patientState.getShisetsuData("TOKUTEI_NYUSHO_FLAG"), 0);
		int oldFacilityUserFlag = ACCastUtilities.toInt(patientState.getShisetsuData("KYUSOCHI_FLAG"), 0);
		VRList insureInfoHistory = QkanCommon.getPatientInsureInfoHistory(dbm, targetDate, patientState.getPatientId());
		//serviceKinds�͎g�p���Ă��Ȃ��̂ŋ�̃��X�g���Z�b�g���Ă���
		this.calcurater.initialize(targetDate, patientInfo, insureInfoHistory, hashedProviders, dbm, new VRArrayList(), inSpecialFacilityFlag, oldFacilityUserFlag);
		
		// �Q�Ɗ֌W�̂Ȃ��f�[�^���쐬����
		this.serviceAllList = QkanValidServiceCommon.deepCopyVRList(new VRArrayList(services));
	}

    /**
     * �Ώۂ̃T�[�r�X�R�[�h�ł��邩�ǂ�����Ԃ��B
     * 
     * �敪�x�����x�z�̊Ǘ����s���T�[�r�X��ނ̂����A
     * �敪�x�����x�Ǘ��O�̃T�[�r�X�R�[�h�ŃT�[�r�X���Z�t���O�i�P�ʉ��Z�A�P�ʌ��Z�j�A
     * �Z��P�ʂ��u1��ɂ��v�A�u�P���ɂ��v�̏ꍇ�ɑΏۂƂȂ�B
     * 
     * @param serviceCode M_SERVICE_CODE�̃��R�[�h���i�[���ꂽ�}�b�v
     * @return �Ώۂ̃T�[�r�X�R�[�h�ł��邩�ǂ���
     */
	public static boolean isTaisho(Map<String, Object> serviceCode) {
		try {
			String serviceCodeKind = ACCastUtilities.toString(serviceCode.get("SERVICE_CODE_KIND"));

	        //�敪�x�����x�̊Ǘ����s��Ȃ��T�[�r�X��ނ̏ꍇ
	        if (taishogaiKindList.contains(serviceCodeKind)) {
	        	return false;
	        }
	        
	        int serviceAddFlg = ACCastUtilities.toInt(serviceCode.get("SERVICE_ADD_FLAG"));
	        int limitAmountObject = ACCastUtilities.toInt(serviceCode.get("LIMIT_AMOUNT_OBJECT"));
	        int serviceMainFlg = ACCastUtilities.toInt(serviceCode.get("SERVICE_MAIN_FLAG"));
	        int totalGroupingType = ACCastUtilities.toInt(serviceCode.get("TOTAL_GROUPING_TYPE"));
	        
	        if (   (limitAmountObject == 2) //�敪�x�����x�z�O
	        	&& (serviceAddFlg == 2 || serviceAddFlg == 4) //�T�[�r�X���Z�t���O�i�P�ʉ��Z�A�P�ʌ��Z�j
	        	&& (serviceMainFlg == 0) //�{�̕�V�ȊO
	        	&& (totalGroupingType == 1 || totalGroupingType == 2) //�W�v�W�����敪�i��A���j
	        ) {
	        	return true;
	        }
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
    /**
     * ��͍ς݂̑ΏۃT�[�r�X�R�[�h�ɂ��ĒP�ʐ����擾����B
     * �iparseServiceCode���s��ɌĂԁj
     * 
     * @return ��͍ς݂̑ΏۃT�[�r�X�R�[�h�ɂ��Ă̒P�ʐ�
     */
	public int getReductedUnit() {
		return this.reductedUnit;
	}
	
    /**
     * �P�ʐ��̐ςݏグ���ʂɂ��Ď��ȕ��S�ƂȂ�P�ʐ����擾����B
     * �iparseServiceCode���s��ɌĂԁj
     * 
     * @return ���ȕ��S�ƂȂ�P�ʐ�
     */
	public int getSelfPayUnit() {
		return this.selfPayUnit;
	}
	
    /**
     * �P�ʐ��̐ςݏグ���ʂɂ��ċ敪�x�����x���Ƃ��Ẳ񐔂��擾����B
     * �iparseServiceCode���s��ɌĂԁj
     * 
     * @return �敪�x�����x���Ƃ��Ẳ�
     * */
	public int getLimitInNumber() {
		return this.limitInNumber;
	}
	
    /**
     * �Ώۂ̃T�[�r�X�R�[�h�ɂ��ĒP�ʐ��̐ςݏグ�������s���B
     * 
     * @param serviceCode M_SERVICE_CODE�̃��R�[�h���i�[���ꂽ�}�b�v
     * @param targetProviderId ���Ə��R�[�h
     * @param limitOverUnit ���ߕ��̒P�ʐ�
     */
	public void parseServiceCode(Map<String, Object> serviceCode, String targetProviderId, int limitOverUnit) throws Exception {
	    parseServiceCodeImpl(serviceCode, targetProviderId, limitOverUnit, KeijoType.ALL, null);
	}
	
    /**
     * �Ώۂ̃T�[�r�X�R�[�h�ɂ��ĒP�ʐ��̐ςݏグ�������s���B�i�������חp�j�i�Z���n����ł͂Ȃ����j
     * 
     * @param serviceCode M_SERVICE_CODE�̃��R�[�h���i�[���ꂽ�}�b�v
     * @param targetProviderId ���Ə��R�[�h
     * @param limitOverUnit ���ߕ��̒P�ʐ�
     * @param patientState QP001PatientState
     */
    public void parseServiceCodeForSeikyu(Map<String, Object> serviceCode, String targetProviderId, int limitOverUnit, QP001PatientState patientState) throws Exception {
        parseServiceCodeImpl(serviceCode, targetProviderId, limitOverUnit, KeijoType.NOT_JUSHOTI_TOKUREI, patientState);
    }
    
    /**
     * �Ώۂ̃T�[�r�X�R�[�h�ɂ��ĒP�ʐ��̐ςݏグ�������s���B�i�������חp�j�i�Z���n����̑Ώە��j
     * 
     * @param serviceCode M_SERVICE_CODE�̃��R�[�h���i�[���ꂽ�}�b�v
     * @param targetProviderId ���Ə��R�[�h
     * @param limitOverUnit ���ߕ��̒P�ʐ�
     * @param patientState QP001PatientState
     */
    public void parseServiceCodeForSeikyuJushotiTokurei(Map<String, Object> serviceCode, String targetProviderId, int limitOverUnit, QP001PatientState patientState) throws Exception {
        parseServiceCodeImpl(serviceCode, targetProviderId, limitOverUnit, KeijoType.ONLY_JUSHOTI_TOKUREI, patientState);
    }
	
    private void parseServiceCodeImpl(Map<String, Object> serviceCode, String targetProviderId, int limitOverUnit, KeijoType keijoType, QP001PatientState patientState) throws Exception {
        String serviceCodeKind = ACCastUtilities.toString(serviceCode.get("SERVICE_CODE_KIND"));
        String serviceCodeItem = ACCastUtilities.toString(serviceCode.get("SERVICE_CODE_ITEM"));
        int serviceUnit = ACCastUtilities.toInt(serviceCode.get("SERVICE_UNIT"));
        int reductedUnit = calcurater.getReductedUnit(targetProviderId, serviceCode, serviceUnit);
        Set<Date> keijosumiDates = new HashSet<Date>();
        
        //�ςݏグ�ΏۂƂȂ�T�[�r�X�̑��P�ʐ�
        int totalUnit = parseServiceList(serviceCode, targetProviderId);
        
        // [H30.4�����Ή�][Yoichiro Kamei] 2018/3/14 mod - begin �����^���Z�Ή�
        // �\�[�g��parseServiceList���\�b�h���ōs���悤�ύX
//        // �T�[�r�X�����n��Ń\�[�g����
//        Collections.sort(this.targetServiceList, new ServiceDateTimeLineComparator());
        // [H30.4�����Ή�][Yoichiro Kamei] 2018/3/14 mod - end
        
        //���x�z�I�[�o�[�𔻒肷��P�ʐ�
        int limitPoint = totalUnit - limitOverUnit;
        
        int limitInNum = 0; //���x���Ƃ��Ẳ�
        int limitOverNum = 0; //���x�O�Ƃ��Ẳ�
        int tumiageUnit = 0; //�ςݏグ���̒P�ʐ�
        boolean overFlg = false;
        if (limitPoint == 0) {
            //���x�z���g���؂��Ă���̂ŃI�[�o�[�Ƃ݂Ȃ�
            overFlg = true;
        }
        for (Map<String, Object> service : targetServiceList) {
            //�P�ʐ��̐ςݏグ
            int unit = ACCastUtilities.toInt(service.get(ADD_UNIT_NAME));
            
            tumiageUnit += unit;
            
            List<Map<String, Object>> codes = calcurater.getServiceCodes((VRMap) service);
            //�T�[�r�X�ɑΏۂ̉��Z�i�T�[�r�X�񋟑̐��������Z�j���t���Ă��āA�񐔂��v�シ��ꍇ
            if (isExistsCode(codes, serviceCodeKind, serviceCodeItem)
                    && isKeijo(service, serviceCode, keijosumiDates)
                    && isKeijoType(service, serviceCode, keijoType, patientState)) {
                //���x���A���x�O�̉񐔂��v��
                if (overFlg) {
                    //���łɃI�[�o�[���Ă���ꍇ
                    limitOverNum++;
                } else {
                    //�I�[�o�[���Ă��Ȃ����A���̃T�[�r�X�ŃI�[�o�[����ꍇ
                    limitInNum++;
                }
            }
            //�ςݏグ�����ʂ���P�ʐ����I�[�o�[���Ă����ꍇ�i�������ꍇ�����x�z���g���؂����̂ŁA�I�[�o�[�Ƃ���j
            if (tumiageUnit >= limitPoint) {
                overFlg = true;
            }
        }
        
        this.reductedUnit = reductedUnit;
        this.selfPayUnit = reductedUnit * limitOverNum;
        this.limitInNumber = limitInNum;
    }
    
	//codes�Ŏw�肵���T�[�r�X�̂Ȃ��ɑΏۂ̃R�[�h�����݂��邩�ǂ�����Ԃ�
	private boolean isExistsCode(List<Map<String, Object>> codes,  String kind, String item) throws Exception {
		for (Map<String, Object> code : codes) {
			String serviceCodeKind = ACCastUtilities.toString(code.get("SERVICE_CODE_KIND"));
			String serviceCodeItem = ACCastUtilities.toString(code.get("SERVICE_CODE_ITEM"));
			if (kind.equals(serviceCodeKind) && item.equals(serviceCodeItem)) {
				return true;
			}
		}
		return false;
	}
	
	//�񐔂��v�シ�邩�ǂ�����Ԃ�
	private boolean isKeijo(Map<String, Object> service, Map<String, Object> serviceCode,  Set<Date> keijosumiDates) throws Exception {
	    Date serviceDate = ACCastUtilities.toDate(service.get("SERVICE_DATE"), null);
	    int totalGroupingType = ACCastUtilities.toInt(serviceCode.get("TOTAL_GROUPING_TYPE"));
	    //���P�ʂ̃R�[�h�̏ꍇ�A���ɓ������ɉ񐔂��v�サ�Ă�����v�サ�Ȃ�
	    if (totalGroupingType == 2) { //���P�ʂ̉��Z
	        //�v��ς̏ꍇ
	        if (keijosumiDates.contains(serviceDate)) {
	            return false;
	        }
	    }
	    keijosumiDates.add(serviceDate);
	    return true;
	}
	
	//�񐔂̌v��^�C�v�ɉ����āA�v�シ�邩�ǂ�����Ԃ�
	private boolean isKeijoType(Map<String, Object> service, Map<String, Object> serviceCode, KeijoType keijoType, QP001PatientState patientState) throws Exception {
        if (keijoType == KeijoType.ALL) {
            //���ׂČv��
            return true;
        }
        String serviceCodeKind = ACCastUtilities.toString(serviceCode.get("SERVICE_CODE_KIND"));
        if (!QP001SpecialCase.isRegionStickingServiceForJushotiTokurei(serviceCodeKind)) {
            //�Z���n����Ώۂ̒n�斧���^�T�[�r�X�łȂ���΁A�Z���n����Ɋ֌W�Ȃ��̂ł��ׂČv��
            return true;
        }
        //�Ώۓ����Z���n���Ⴉ�ǂ���
        Date serviceDate = ACCastUtilities.toDate(service.get("SERVICE_DATE"), null);
        boolean isJushotiTokurei = !ACTextUtilities.isNullText(patientState.getJushotiTokureiInsurerId(serviceDate));
	    if (keijoType == KeijoType.NOT_JUSHOTI_TOKUREI) {
	        //�Z���n����łȂ���΁A�v��
	        if (!isJushotiTokurei) {
                return true;
	        }
	    }
	    if (keijoType == KeijoType.ONLY_JUSHOTI_TOKUREI) {
	        //�Z���n����ł���΁A�v��
	        if (isJushotiTokurei) {
	            return true;
	        }
	    }
	    return false;
	}
	
	// �S�̂̃T�[�r�X���X�g����ςݏグ�ΏۂƂȂ�T�[�r�X�̃��X�g�Ɉڂ��B
	// �ςݏグ�ΏۂƂȂ�T�[�r�X�̒P�ʐ������v���ĕԂ��B
	private int parseServiceList(Map<String, Object> serviceCode, String targetProviderId) throws Exception {
		int totalUnit = 0;
		targetServiceList = new ArrayList<Map<String, Object>>();
		// [H30.4�����Ή�][Yoichiro Kamei] 2018/3/14 add - begin �����^���Z�Ή�
		List<Map<String, Object>> filteredList = new ArrayList<Map<String, Object>>();
		// [H30.4�����Ή�][Yoichiro Kamei] 2018/3/14 add - end
		
		String targetServiceKind = ACCastUtilities.toString(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL"));
		Map[] totalGroupingCache = new Map[] { new HashMap(), new HashMap() };
		for (Map<String, Object> service : serviceAllList) {
			String serviceKind = ACCastUtilities.toString(service.get("SYSTEM_SERVICE_KIND_DETAIL"), "");
			String providerId = ACCastUtilities.toString(service.get("PROVIDER_ID"), "");
			
			if (!providerId.equals(targetProviderId) || !serviceKind.equals(targetServiceKind)) {
				//���Ə����T�[�r�X��ނ��قȂ�ΑΏۊO�Ȃ̂ŃX�L�b�v
				continue;
			}
			
			if (CareServiceCommon.is30DayOver((VRMap) service)) {
				//30�����ł���΁A�ΏۊO�Ȃ̂ŃX�L�b�v
				continue;
			}
			// [H30.4�����Ή�][Yoichiro Kamei] 2018/3/14 mod - begin �����^���Z�Ή�
//			//�T�[�r�X����R�[�h�W�����擾���āA�x�����x�z�Ǘ��Ώۂ̒P�ʐ��̍��v�����߂�
//			int unit = calcurater.getReductedUnit((VRMap) service, false, CareServiceCodeCalcurater.CALC_MODE_IN_LIMIT_AMOUNT_OR_OUTER_SERVICE, totalGroupingCache);
//			//�P�ʐ�0�̏ꍇ�́A�Z��P�ʁu1���ɂ��v��1����2��ȏ�Z�肵�Ă���ꍇ���Ȃ̂ŁA
//			//�Z��ΏۊO�̃T�[�r�X�Ƃ݂Ȃ��āA0�łȂ���ΐςݏグ�Ώۂɒǉ�
//			if (unit != 0) {
//				service.put(ADD_UNIT_NAME, unit);
//				totalUnit += unit;
//				
//				//�ςݏグ�ΏۂƂȂ�T�[�r�X�̃��X�g�Ɉڂ�
//				targetServiceList.add(service);
//			}
			//��U�A�ΏۃT�[�r�X���i�[����
			filteredList.add(service);
			// [H30.4�����Ή�][Yoichiro Kamei] 2018/3/14 mod - end
		}
		// [H30.4�����Ή�][Yoichiro Kamei] 2018/3/14 add - begin �����^���Z�Ή�
		// ���n��Ń\�[�g����
		Collections.sort(filteredList, new ServiceDateTimeLineComparator(ADD_UNIT_NAME));
		
		// �P�ʐ����擾����
		KyouseiUnitCalcurater kyouseiCalc = new KyouseiUnitCalcurater();
		for (Map<String, Object> service : filteredList) {
			//�T�[�r�X����R�[�h�W�����擾���āA�x�����x�z�Ǘ��Ώۂ̒P�ʐ��̍��v�����߂�
			int unit = calcurater.getReductedUnit((VRMap) service, false
					, CareServiceCodeCalcurater.CALC_MODE_IN_LIMIT_AMOUNT_OR_OUTER_SERVICE
					, totalGroupingCache, kyouseiCalc);
			//�P�ʐ�0�̏ꍇ�́A�Z��P�ʁu1���ɂ��v��1����2��ȏ�Z�肵�Ă���ꍇ���Ȃ̂ŁA
			//�Z��ΏۊO�̃T�[�r�X�Ƃ݂Ȃ��āA0�łȂ���ΐςݏグ�Ώۂɒǉ�
			if (unit != 0) {
				service.put(ADD_UNIT_NAME, unit);
				totalUnit += unit;
				
				//�ςݏグ�ΏۂƂȂ�T�[�r�X�̃��X�g�Ɉڂ�
				targetServiceList.add(service);
			}
		}
		// �����^���Z�̌��Z�P�ʐ���ADD_UNIT_NAME�ɕێ����Ă���P�ʐ��֔��f����
		if (kyouseiCalc.hasService()) {
			kyouseiCalc.calcKyouseiUnit(ADD_UNIT_NAME);
			//���v�P�ʐ����Čv�Z����
			totalUnit = 0;
			for (Map<String, Object> service : targetServiceList) {
				int unit = ACCastUtilities.toInt(service.get(ADD_UNIT_NAME), 0);
				totalUnit += unit;
			}			
		}
		// [H30.4�����Ή�][Yoichiro Kamei] 2018/3/14 add - end
		
		return totalUnit;
	}
	
	// [H30.4�����Ή�][Yoichiro Kamei] 2018/3/14 mod - begin
	//�@���̃N���X������g�p���邽�߁Apublic�N���X�Ɉړ�
//    /**
//     * ���n��ŃT�[�r�X���\�[�g����B
//     * �T�[�r�X�񋟓��A�J�n�����A�P�ʐ��̏����Ń\�[�g
//     */
//    private class ServiceDateTimeLineComparator implements java.util.Comparator<Map<String, Object>> {
//        public int compare(Map<String, Object> object1, Map<String, Object> object2) {
//            Date date1 = ACCastUtilities.toDate(object1.get("SERVICE_DATE"), null);
//            Date date2 = ACCastUtilities.toDate(object2.get("SERVICE_DATE"), null);
//            
//            if (date1 != null && date2 == null) {
//            	return 1;
//            } else if (date1 == null && date2 != null) {
//            	return -1;
//            }
//            int dateResult = date1.compareTo(date2);
//            if (dateResult != 0) {
//            	return dateResult;
//            }
//            
//            //���t�������ꍇ�A�J�n����������
//            date1 = ACCastUtilities.toDate(object1.get("3"), null);
//            date2 = ACCastUtilities.toDate(object2.get("3"), null);
//            //�ǂ��炩�������͂̏ꍇ�A�����͂̕�����
//            if (date1 != null && date2 == null) {
//                return 1;
//            } else if (date1 == null && date2 != null) {
//                return -1;
//            }
//            if (date1 != null && date2 != null) {
//                Integer hour1 = ACDateUtilities.getHourOfDay(date1);
//                Integer hour2 = ACDateUtilities.getHourOfDay(date2);
//                int hourResult = hour1.compareTo(hour2);
//                if (hourResult != 0) {
//                	return hourResult;
//                }
//                
//                Integer minute1 = ACDateUtilities.getMinute(date1);
//                Integer minute2 = ACDateUtilities.getMinute(date2);
//                int minuteResult = minute1.compareTo(minute2);
//                if (minuteResult != 0) {
//                	return minuteResult;
//                }
//            }
//            
//            //�J�n�����������ꍇ�A�P�ʐ��Ń\�[�g
//            Integer unit1 = ACCastUtilities.toInt(object1.get(ADD_UNIT_NAME), 0);
//            Integer unit2 = ACCastUtilities.toInt(object2.get(ADD_UNIT_NAME), 0);
//            return unit1.compareTo(unit2);
//        }
//    }
 // [H30.4�����Ή�][Yoichiro Kamei] 2018/3/14 mod - end
}
