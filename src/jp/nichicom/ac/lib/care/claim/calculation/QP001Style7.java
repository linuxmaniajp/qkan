
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
 * �v���O���� �l���掵 (QP001Style7)
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
 * �l���掵 ���[���
 * @author shin fujihara
 *
 */
public class QP001Style7 extends QP001StyleAbstract {

	/*
	 * ID:0000447][Shin Fujihara] 2009/02 edit begin ����21�N4���@�����Ή�
	 * 
	 * �l���掵���������R�[�h��ێ�����i���Z�Z��L�j�d�l�ύX�������������߁A
	 * �v���O�����S�̂�啝�C���B
	 * 
	 * �ύX������CVS���Q��
	 */
	
	
	
   /**
    * �����l���ԍ�
    */
   private int claimStyleFormat = 0;
   /**
    * �������ʔԍ�
    */
   private String identificationNo = "";
	
	/**
	 * �l���掵
	 */
	//private QP001RecordCarePlan carePlan = null;
	private Map carePlanMap = new TreeMap();
    
    public QP001Style7(int claimStyleFormat,QP001Manager manager) {
        this.claimStyleFormat = claimStyleFormat;
        this.identificationNo = getIdentificationNo(claimStyleFormat,manager.getTargetDate());
    }
    
	/**
	 * ���R�[�h���L�̏���ԋp���܂�
	 * @return
	 */
    public static String getSerialId(int claimStyleFormat,Date targetDate){
    	return getIdentificationNo(claimStyleFormat,targetDate);
	}
	
	/**
	 * �f�[�^�̉�͂����s����B
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
    	
    	
    	//[ID:0000702][Shin Fujihara] 2012/04 add start ����21�N4���@�����Ή�
    	//�l���掵�A���Z�̂ݎZ��ɑΉ�
    	carePlan.parse(serviceDetail,patientState,serviceCode,identificationNo,manager);
    	
        //�x�����Q�ȏ�͂��Ă���ꍇ�́A�����̉��ی������ԍ����̗p����B
        if (!carePlan.isNew()) {
            Date serviceDate = ACCastUtilities.toDate(serviceDetail.get("SERVICE_DATE"),null);
            
            //�T�[�r�X�񋟓����擾�ł����ꍇ
            if(serviceDate != null){
                boolean replace = false;
                //�T�[�r�X�񋟓������m�ȏꍇ
                if(carePlan.getServiceDate() != null){
                    //���ݓǂݎ���Ă��郌�R�[�h�̓��t���V�����ꍇ
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
    	//[ID:0000702][Shin Fujihara] 2012/04 add end ����21�N4���@�����Ή�
    	//[ID:0000702][Shin Fujihara] 2012/04 delete start ����21�N4���@�����Ή�
    	//�l���掵�A���Z�̂ݎZ��ɑΉ�
//        if(carePlan.isNew()){
//        	carePlan.parse(serviceDetail,patientState,serviceCode,identificationNo,manager);
//        } else {
//            //�x�����Q�ȏ�͂��Ă���ꍇ�́A�����̉��ی������ԍ����̗p����B
//            Date serviceDate = ACCastUtilities.toDate(serviceDetail.get("SERVICE_DATE"),null);
//            
//            //�T�[�r�X�񋟓����擾�ł����ꍇ
//            if(serviceDate != null){
//                boolean replace = false;
//                //�T�[�r�X�񋟓������m�ȏꍇ
//                if(carePlan.getServiceDate() != null){
//                    //���ݓǂݎ���Ă��郌�R�[�h�̓��t���V�����ꍇ
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
        //[ID:0000702][Shin Fujihara] 2012/04 delete end ����21�N4���@�����Ή�
		
	}
	
    public void commitRecords(QP001PatientState patientState,VRMap styles, VRMap planUnitMap) throws Exception {
		
		int data_size = carePlanMap.size();
		//�f�[�^�̎擾���s�Ȃ��Ă��Ȃ��ꍇ�A������~
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
			//�������z�����Z�b�g
			carePlan.set_1001018(0);
			count++;
		}
		
		//�T�[�r�X�v������׍s�ԍ�
		carePlan.set_1001024(99);
		//�T�[�r�X�P�ʐ����v
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
			
            //���[�̗l���ԍ�
            style.put("CLAIM_STYLE_TYPE",ACCastUtilities.toString(claimStyleFormat));
            //���p�҂h�c
            style.put("PATIENT_ID",Integer.toString(patient_id));
            //�����̑ΏۂƂȂ�N��(�T�[�r�X�񋟔N��)
            style.put("TARGET_DATE",ACCastUtilities.toDate(carePlan.get_1001004() + "01"));
            //�������s���N����
            style.put("CLAIM_DATE",claimDate);
            //���������Ə�
            style.put("PROVIDER_ID",carePlan.get_1001002());
            
            //�ی��Ҕԍ�
            style.put("INSURER_ID", carePlan.get_1001005());
            //��ی��Ҕԍ�
            style.put("INSURED_ID", carePlan.get_1001007());
            
            style.put("CLAIM_FINISH_FLAG","0");     
            
            list.add(carePlan.getRecord(style));
		}
        
		return list;
	}

}
