
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

import java.util.Iterator;

import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.vr.bind.VRBindPathParser;
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
        
		//����̎擾
//		VRList list = patientState.getKohiDataFromServiceKind(targetDate,systemServiceKindDetail,applicationType,1,medicalFlag);
        VRList list = patientState.getKohiDataFromServiceKind(targetDate,String.valueOf(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL")),applicationType,1,medicalFlag,manager);
		
		//���m�̃p�^���ł��邩�m�F
		//�V���A�����擾���ē�������̓K�p�p�^�����Ȃ����Q��
		String serial = QP001RecordSupporterCalc.getSerialId(list,patientState,targetDate,1);
		QP001RecordSupporterCalc calc = null;
		
		//���m�̌���p�^���ł���ꍇ
		if(!kohiPattern.containsKey(serial)){
			for(int i = 0; i < list.getDataSize(); i++) {
				VRMap kohi = (VRMap)list.getData(i);
				//����K�p���ʂւ̒ǉ����s��
				kohiRankMap.put(VRBindPathParser.get("KOHI_SORT",kohi),kohi);
			}
			calc = new QP001RecordSupporterCalc(service_unit);
			//����v�Z�I�u�W�F�N�g�̒ǉ����s���B
			kohiPattern.setData(serial,calc);
		} else {
			calc = (QP001RecordSupporterCalc)kohiPattern.getData(serial);
		}
		calc.addTime(serviceDetail,serviceCode);
		//����̌���p�^���ŉ���K�p�����邩���m�肽��
		for(int i = 0; i < list.getDataSize(); i++){
			VRMap kohi = (VRMap)list.getData(i);
			int countTemp = count;
			//����̐ݒ肪����ꍇ
			if(kohiApplicationTimes.containsKey(VRBindPathParser.get("KOHI_TYPE",kohi))){
                countTemp = ((Integer)kohiApplicationTimes.get(VRBindPathParser.get("KOHI_TYPE",kohi))).intValue();
                countTemp += count;
			}
			kohiApplicationTimes.setData(VRBindPathParser.get("KOHI_TYPE",kohi),new Integer(countTemp));
		}
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
	 * �w�肳�ꂽ����ԍ��̌���K�p�����E�񐔂�ԋp���܂��B
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
