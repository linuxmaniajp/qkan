
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
 * �v���O���� ����ʊm��N���X (QP001RecordSupporter)
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
 * ���R�[�h�ɕt���̏��S�ʂ��Ǘ����܂��B
 * �i����ʁA�T�[�r�X�������Ȃǁj
 * @author shin fujihara
 */
public class QP001RecordSupporter {

	//����ʂ�ێ����܂��B
	//�L�[:����K�p���ʁ@�l:����ԍ�
	private VRMap kohiRankMap =new VRHashMap();
	//�T�[�r�X���������Ǘ����܂��B
	private VRList realDays = new VRArrayList();
    //����(���@)�������Ǘ����܂��B
    private VRList hospitalizationDays = new VRArrayList();
    //�O���������Ǘ����܂��B
    private VRList leavingHospitalDays = new VRArrayList();

    
	//����̓K�p�p�^�����Ǘ����܂��B
	private VRMap kohiPattern = new VRHashMap();
	//�w��̌���ԍ��̌���K�p�񐔂�����ł��������Z�o���܂��B
	private VRMap kohiApplicationTimes = new VRHashMap();
    
	//add start fujihara.shin 2008.6.23 ����������W�J�ɑΉ�
	//�T�[�r�X�̎��񋟓������Ǘ����܂��B
	private VRList offerDays = new VRArrayList();
	//add end fujihara.shin 
	
	
	// [H27.4�����Ή�][Yoichiro Kamei] 2015/4/3 add - begin �T�[�r�X�񋟑̐����Z�̎��ȕ��S�Ή�
	// �񐔎Z�莞�_���ƂɌ����ޕʂ̃J�E���g��ێ����Ă���
	private Map<Integer, Object> kohiApplicationTimesPerCount = new HashMap<Integer, Object>();
	// [H27.4�����Ή�][Yoichiro Kamei] 2015/4/3 add - end
	
	// [H30.4�����Ή�][Yoichiro Kamei] 2018/4/9 add - begin
	private QP001PercentageAddInfo percentageAddInfo;
    public QP001PercentageAddInfo getPercentageAddInfo() {
    	return percentageAddInfo;
    }
	// [H30.4�����Ή�][Yoichiro Kamei] 2018/4/9 add - end
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
		

        //���t�f�[�^�̐ݒ�
		//[ID:0000586][Shin Fujihara] 2010/01 edit begin 2009�N�x�Ή�
        //setDate(targetDate,serviceDetail);
		setDate(targetDate,serviceDetail, serviceCode);
        //[ID:0000586][Shin Fujihara] 2010/01 edit end 2009�N�x�Ή�
		
        // 2017/6 [Yoichiro Kamei] add - begin AF�Ή�
        // AF�Ő��ےP�ƂłȂ��ꍇ�́A����K�p���Ȃ�
		if (QkanSjServiceCodeManager.afCodes.contains(String.valueOf(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL")))) {
			if (!patientState.isSeihoOnly(targetDate)) {
				return;
			}
		}
		// 2017/6 [Yoichiro Kamei] add - end
        
		//����̎擾
//		VRList list = patientState.getKohiDataFromServiceKind(targetDate,systemServiceKindDetail,applicationType,1,medicalFlag);
        VRList list = patientState.getKohiDataFromServiceKind(targetDate,String.valueOf(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL")),applicationType,1,medicalFlag,manager);
		
        // [H30.4�����Ή�][Yoichiro Kamei] 2018/4/16 add - begin
        // �ً}�����ÊǗ��̃R�[�h�̏ꍇ�AapplicationType=�u2:�ً}���{�ݗ×{�Ǘ��v���w�肵�ēK�p�\�Ȍ�����擾
        String serviceCodeKind = ACCastUtilities.toString(serviceCode.get("SERVICE_CODE_KIND"), "");
        String serviceCodeItem = ACCastUtilities.toString(serviceCode.get("SERVICE_CODE_ITEM"), "");
        if (QP001SpecialCase.isEmergencyCode(serviceCodeKind, serviceCodeItem)) {
            list = patientState.getKohiDataFromServiceKind(targetDate,String.valueOf(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL")),"2",1,medicalFlag,manager);
        }
        // [H30.4�����Ή�][Yoichiro Kamei] 2018/4/16 add - end
        
		//���m�̃p�^���ł��邩�m�F
		//�V���A�����擾���ē�������̓K�p�p�^�����Ȃ����Q��
		String serial = QP001RecordSupporterCalc.getSerialId(list,patientState,targetDate,1);
		QP001RecordSupporterCalc calc = null;
		
        for(int i = 0; i < list.getDataSize(); i++) {
            VRMap kohi = (VRMap)list.getData(i);
            // [H30.4�����Ή�][Yoichiro Kamei] 2018/4/6 add - begin            
            String kohiType = ACCastUtilities.toString(kohi.get("KOHI_TYPE"), "");
            // ���ےP�Ƃƌ��r����a�̃p�^�[���ɑΉ��i�L�ڗ�P�Q�|�R�j
            // �Ώۂ̌���^�C�v��100%����̍ŗD�揇�ł͖����ꍇ�Aserial�Ɋ܂܂�Ă��Ȃ��̂�
            // �܂܂�Ă��Ȃ��ꍇ�͓K�p�ΏۊO�Ƃ��ăX�L�b�v����
            if (!serial.contains(kohiType)) {
            	continue;
            }
            // [H30.4�����Ή�][Yoichiro Kamei] 2018/4/6 add - end
            //����K�p���ʂւ̒ǉ����s��
            QP001KohiKey kohiKey = new QP001KohiKey(kohi);
            if (!kohiRankMap.containsKey(kohiKey)) {
                kohiRankMap.put(kohiKey,kohi);
            }
        }
        
		//���m�̌���p�^���ł���ꍇ
		if(!kohiPattern.containsKey(serial)){
			calc = new QP001RecordSupporterCalc(service_unit);
			//����v�Z�I�u�W�F�N�g�̒ǉ����s���B
			kohiPattern.setData(serial,calc);
		} else {
			calc = (QP001RecordSupporterCalc)kohiPattern.getData(serial);
		}
// [Yoichiro Kamei] [����֘A�C��] 2015/4/27 comment out - begin �g���Ă��Ȃ��������R�����g��
//		calc.addTime(serviceDetail,serviceCode);
// [Yoichiro Kamei] [����֘A�C��] 2015/4/27 comment out - end
		
		// [H30.4�����Ή�][Yoichiro Kamei] 2018/4/9 add - begin
		if (percentageAddInfo == null) {
			percentageAddInfo = new QP001PercentageAddInfo(service_unit);
		}
		percentageAddInfo.parseService(serviceCode);
		percentageAddInfo.addKihonCount(serviceCode, count);
		// [H30.4�����Ή�][Yoichiro Kamei] 2018/4/9 add - end
		
		//����̌���p�^���ŉ���K�p�����邩���m�肽��
		for(int i = 0; i < list.getDataSize(); i++){
			VRMap kohi = (VRMap)list.getData(i);
			// [H30.4�����Ή�][Yoichiro Kamei] 2018/4/6 add - begin
            String kohiType = ACCastUtilities.toString(kohi.get("KOHI_TYPE"), "");
            // ���ےP�Ƃƌ��r����a�̃p�^�[���ɑΉ��i�L�ڗ�P�Q�|�R�j
            // �Ώۂ̌���^�C�v��100%����̍ŗD�揇�ł͖����ꍇ�Aserial�Ɋ܂܂�Ă��Ȃ��̂�
            // �܂܂�Ă��Ȃ��ꍇ�͓K�p�ΏۊO�Ƃ��ăX�L�b�v����
            if (!serial.contains(kohiType)) {
            	continue;
            }
            // [H30.4�����Ή�][Yoichiro Kamei] 2018/4/6 add - end
			int countTemp = count;
			//����̐ݒ肪����ꍇ
			QP001KohiKey kohiKey = new QP001KohiKey(kohi);
			if(kohiApplicationTimes.containsKey(kohiKey)){
                countTemp = ((Integer)kohiApplicationTimes.get(kohiKey)).intValue();
                countTemp += count;
			}
			kohiApplicationTimes.setData(kohiKey,new Integer(countTemp));
			
			// [H30.4�����Ή�][Yoichiro Kamei] 2018/4/9 add - begin
			percentageAddInfo.addKohiCount(serviceCode, kohiKey, count);
			// [H30.4�����Ή�][Yoichiro Kamei] 2018/4/9 add - end
		}
		
		// [H27.4�����Ή�][Yoichiro Kamei] 2015/4/3 add - begin �T�[�r�X�񋟑̐����Z�̎��ȕ��S�Ή�
		// �񐔎Z�莞�_�̌����ޕʂ̃J�E���g��ێ����Ă���
		int nowCount =  0;
		if (!kohiApplicationTimesPerCount.isEmpty()) {
			//���ݕێ����Ă���񐔂̍ő�l���擾
			nowCount = Collections.max(kohiApplicationTimesPerCount.keySet());
		}
		int nextCount = nowCount + count;
		kohiApplicationTimesPerCount.put(new Integer(nextCount), new VRHashMap(kohiApplicationTimes));
		// [H27.4�����Ή�][Yoichiro Kamei] 2015/4/3 add - end
	}
    
    /**
     * ���t�ɂ܂��f�[�^��ݒ肵�܂��B
     * @param targetDate
     * @param serviceDetail
     * @param serviceCode
     * @throws Exception
     */
	//[ID:0000586][Shin Fujihara] 2010/01 edit begin 2009�N�x�Ή�
	//���t����̎d�l�ǉ��ɑΉ����邽�߁AserviceCode�̈�����ǉ�
	//����ɔ����A���\�b�h���̏�����傫���ύX���Ă��܂��B
	//�R�[�h�̉ǐ�����̂��߁A�ύX�R�����g�͋L�ڂ��Ă��܂���B
	//������CVS�Ŋm�F���Ă�������
	public void setDate(Object targetDate,VRMap serviceDetail, VRMap serviceCode) throws Exception {
        //�������̎Z�o
        //���o�^�̓��t�A���������Ƃ��ĎZ�肷�ׂ����ڂł���Βǉ�
		if(!realDays.contains(targetDate) && QP001SpecialCase.isRealDay(serviceDetail, serviceCode)){
            realDays.add(targetDate);
        }

    	//���{�I�ɓ��t�v�Z�̊T�O��ύX
    	//�T�[�r�X�������ƁA�񋟓����𕪂��ĕێ�����悤�ύX
    	if (!offerDays.contains(targetDate)){
    		offerDays.add(targetDate);
    	}
        
        //�O�������̎Z�o
        switch(CareServiceCommon.isGaihaku(serviceDetail)){
            //�h��
            case 1:
                // �W�v���̓��t�����������ɂ���΍�
                if (!hospitalizationDays.contains(targetDate)
                	&& QP001SpecialCase.isRealDay(serviceDetail, serviceCode)) {
                    hospitalizationDays.add(targetDate);
                }
                break;
            //�O��
            case 2:
                if(!leavingHospitalDays.contains(targetDate)){
                    leavingHospitalDays.add(targetDate);
                }
                break;
        }
    }
	//[ID:0000586][Shin Fujihara] 2010/01 edit end 2009�N�x�Ή�
	
	/**
	 * ������̃��X�g��ԋp����B
	 * @return
	 */
	protected VRMap getKohiList(){
		return this.kohiRankMap;
	}
	
	/**
	 * ����̓K�p�p�^����ԋp���܂��B
	 * @return
	 */
	protected VRMap getKohiPattern(){
		return this.kohiPattern;
	}
	
    /**
     * ����ΏےP�ʐ�
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
	 * �w�肳�ꂽ����ID�̌���K�p�����E�񐔂�ԋp���܂��B
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
	
	
	// [H27.4�����Ή�][Yoichiro Kamei] 2015/4/3 add - begin �T�[�r�X�񋟑̐����Z�̎��ȕ��S�Ή�
	/**
	 * �w��񐔎Z�莞�_�ɂ�����w�����ԍ��̌���K�p�����E�񐔂�ԋp���܂��B
	 * 
	 * @param kohiType ����ԍ�
	 * @param atTime ����ڂ̎Z�莞�ɂ��������K�p�J�E���g���擾���邩
	 * @return �w��񐔎Z�莞�_�ɂ�����w�肳�ꂽ����ԍ��̌���K�p�����E��
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
	// [H27.4�����Ή�][Yoichiro Kamei] 2015/4/3 add - end
	
	/**
	 * �T�[�r�X�̎��������X�g���擾���܂��B
	 * @return
	 */
	protected VRList getRealDays(){
		return realDays;
	}
	/**
     * ���@(����)���������X�g��Ԃ��܂��B 
     * @return
	 */
    protected VRList getHospitalizationDays(){
        return hospitalizationDays;
    }
    /**
     * �މ@(�ޏ�)���������X�g��Ԃ��܂��B
     * @return
     */
    protected VRList getLeavingHospitalDays() {
        return leavingHospitalDays;
    }
    
    //add start fujihara.shin 2008.6.23 ����������W�J�Ή�
    /**
     * �T�[�r�X�񋟎��������X�g���擾���܂��B
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
