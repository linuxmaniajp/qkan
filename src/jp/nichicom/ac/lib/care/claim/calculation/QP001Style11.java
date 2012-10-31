
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
 * �l����\�� ���[���
 * @author shin fujihara
 *
 */
public class QP001Style11 extends QP001StyleAbstract {

	/**
	 * �l����\��@�������ʔԍ�
	 */
	private static final String IDENTIFICATION_NO = "8222";

	/**
	 * �l����\��
	 */
	private Map<String, QP001RecordSupply> supplyMap = new TreeMap<String, QP001RecordSupply>();
	
	/**
	 * �������ʔԍ���ԋp����B
	 * @return
	 */
	protected static String getSerialId(){
		return IDENTIFICATION_NO;
	}
	
    //�S�����x�������ԍ�
    private String _1201025 = "";
    //�ϑ���̋�����x�����Ə��ԍ�
    private String _1201026 = "";
    //�ϑ���̒S�����x�������ԍ�
    private String _1201027 = "";
    
    private boolean makeLastRecord = false;
    
    public static String getSerialId(
            Date targetDate,
            VRMap serviceDetail,
            QP001PatientState patientState) throws Exception {
        
        StringBuilder serial = new StringBuilder();
        //201001    ������񎯕ʔԍ�4��
        serial.append(IDENTIFICATION_NO);
        //�T�[�r�X�񋟔N��6��(YYYYMM)
        serial.append(VRDateParser.format(targetDate,"yyyyMM"));
        //�؋L�ڕی��Ҕԍ�8��
        serial.append(patientState.getInsurerId(VRBindPathParser.get("SERVICE_DATE",serviceDetail)));
        //��ی��Ҕԍ�10��
        serial.append(patientState.getInsuredId(VRBindPathParser.get("SERVICE_DATE",serviceDetail)));
        
        return serial.toString();
    }
    
	/**
	 * �f�[�^�̉�͂����s����B
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
        
        //���׏�񃌃R�[�h���擾
        QP001RecordSupply supply = QP001RecordSupply.getInstance(IDENTIFICATION_NO,
                                                                targetDate,
                                                                targetServiceDate,
                                                                serviceDetail,
                                                                serviceCode,
                                                                patientState,
                                                                supplyMap);
        
        //���R�[�h���쐬����Ă����
        if(supply != null){
            //���׏��f�[�^���
        	result = supply.parse(serviceDetail,targetDate,patientState,serviceCode,IDENTIFICATION_NO,first,manager);
        }
        
        //�����ԍ��̐ݒ�
        setPersonInChargeNo(serviceDetail);
        
        return result;
	}
    
    /**
     * ���т̃f�[�^�����x�������ԍ����擾����B
     * @param serviceDetail
     * @throws Exception
     */
    public void parse(VRMap serviceDetail) throws Exception {
    	//�����ԍ��̐ݒ�
    	setPersonInChargeNo(serviceDetail);
    }
    
    public void setPersonInChargeNo(VRMap serviceDetail) throws Exception {
        
    	if(serviceDetail.containsKey("1430107")){
        	//�S�����x�������ԍ�
        	_1201025 = ACCastUtilities.toString(serviceDetail.get("1430107"),"");
        	_1201026 = "";
        	_1201027 = "";
        
    	} else if(serviceDetail.containsKey("1730104")){
            //���K�͑��@�\�^
        	_1201025 = ACCastUtilities.toString(serviceDetail.get("1730104"),"");
        	_1201026 = "";
        	_1201027 = "";
        
    	} else if(serviceDetail.containsKey("1750104")){
        	//��쏬�K�͑��@�\
        	_1201025 = ACCastUtilities.toString(serviceDetail.get("1750104"),"");
        	_1201026 = "";
        	_1201027 = "";
        	
        } else if(serviceDetail.containsKey("1770116")) {
            //�����^
            _1201025 = ACCastUtilities.toString(serviceDetail.get("1770116"),"");
            _1201026 = "";
            _1201027 = "";
        }
        
        //ID:0000184 ������x������������Ƃ��ł��ϑ��͏o����悤�C��
    	if(serviceDetail.containsKey("1460103")){
        	//���\�h�x��(�ϑ�)
        	//�ϑ���̋�����x�����Ə��ԍ�
        	_1201026 = ACCastUtilities.toString(serviceDetail.get("1460102"),"");
        	//�ϑ���̒S�����x�������ԍ�
        	_1201027 = ACCastUtilities.toString(serviceDetail.get("1460103"),"");
    	}
    }
    
	/**
     * ���R�[�h���e�̊m����s���B
     * @param patientState ���p�ҏ��
     * @param styles �������
     * @throws Exception ���s����O
	 */
    public void commitRecords(QP001PatientState patientState,VRMap styles, VRMap planUnitMap) throws Exception {
        makeLastRecord = true;
        commitRecords();
	}
    
    /**
     * ���R�[�h���e�̊m����s���B
     * @throws Exception ���s����O
     */
    public void commitRecords() throws Exception {
        QP001RecordSupply supply = null;
        VRList removeList = new VRArrayList();
        Iterator<String> it = supplyMap.keySet().iterator();
        while(it.hasNext()){
            Object key = it.next();
            supply = (QP001RecordSupply)supplyMap.get(key);
            //�S�����x�������ԍ�
            supply.set_1201025(_1201025);
            //�ϑ���̋�����x�����Ə��ԍ�
            supply.set_1201026(_1201026);
            //�ϑ���̒S�����x�������ԍ�
            supply.set_1201027(_1201027);
            
            //���R�[�h�̓��e���m��
            supply.commitRecord();
            
            //�v��P�ʐ���0�_�̂��̂͏��O����B
            if(supply.get_1201020() == 0){
                removeList.add(key);
            }
        }
        for(int i = 0; i < removeList.size(); i++){
            supplyMap.remove(removeList.get(i));
        }
        
        //�ŏI�̏W�v�̏ꍇ�A�ŏI���R�[�h�̍쐬���s���B
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
        
		//���[�̗l���ԍ�
		style.put("CLAIM_STYLE_TYPE", ACCastUtilities.toString(QkanConstants.CLAIM_STYLE_BENEFIT_MANAGEMENT));
		//���p�҂h�c
		style.put("PATIENT_ID", Integer.toString(patient_id));
		//�����̑ΏۂƂȂ�N��(�T�[�r�X�񋟔N��)
		style.put("TARGET_DATE", ACCastUtilities.toDate(supply.get_1201002() + "01"));
		//�������s���N����
		style.put("CLAIM_DATE", claimDate);
		//���������Ə�
		style.put("PROVIDER_ID", supply.get_1201004());
        
        //�ی��Ҕԍ�
        style.put("INSURER_ID", supply.get_1201003());
        //style.put("INSURER_ID", QkanSystemInformation.getInstance().getLoginProviderID());
        //��ی��Ҕԍ�
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
