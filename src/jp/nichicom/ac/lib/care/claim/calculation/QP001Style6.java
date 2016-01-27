
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
 * �v���O���� �l����Z (QP001Style6)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * �l����Z�@�꒠�[���̏��
 * @author shin fujihara
 *
 */
public class QP001Style6  extends QP001StyleAbstract{

	/**
	 * ��{��񃌃R�[�h(�꒠�[�ɂЂƂ�)
	 */
	private QP001RecordBase base = new QP001RecordBase();
	/**
	 * ���׏�񃌃R�[�h�W��
	 */
	private VRMap detailMap = new VRHashMap();
	/**
	 * �W�v��񃌃R�[�h�W��(�꒠�[�ɂЂƂ�)
	 */
	private QP001RecordType type = new QP001RecordType();
    
    /**
     * �����l���ԍ�
     */
    private int claimStyleFormat = 0;
    /**
     * �������ʔԍ�
     */
    private String identificationNo = "";
    
    private QP001Manager manager = null;
    
    /**
     * �f�t�H���g�R���X�g���N�^
     *�@@deprecated
     */
    public QP001Style6(){
    }
    
    public QP001Style6(int claimStyleFormat,QP001Manager manager){
        this.claimStyleFormat = claimStyleFormat;
        //[H20.4 �@�����Ή�] fujihara edit start
        //this.identificationNo = getIdentificationNo(claimStyleFormat);
        this.identificationNo = getIdentificationNo(claimStyleFormat,manager.getTargetDate());
        //[H20.4 �@�����Ή�] fujihara edit end
        this.manager = manager;
    }
	
    public static String getSerialId(
			Date targetDate,
			VRMap serviceDetail,
			QP001PatientState patientState,
            int claimStyleFormat) throws Exception {
		StringBuilder serial = new StringBuilder();
		//201001	������񎯕ʔԍ�4��
		
		//[H20.4 �@�����Ή�] fujihara edit start
		//serial.append(getIdentificationNo(claimStyleFormat));
		serial.append(getIdentificationNo(claimStyleFormat,targetDate));
		//[H20.4 �@�����Ή�] fujihara edit end
		
		//�T�[�r�X�񋟔N��6��(YYYYMM)
		serial.append(VRDateParser.format(targetDate,"yyyyMM"));
		//���Ə��ԍ�10��
		serial.append(VRBindPathParser.get("PROVIDER_ID",serviceDetail));
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
    public void parse(VRMap serviceDetail,
						 Date targetDate,
						 QP001PatientState patientState,
						 VRMap serviceCode) throws Exception {
		
		Object targetServiceDate = VRBindPathParser.get("SERVICE_DATE",serviceDetail);
        /* ���׏�񃌃R�[�h�W�v���� */
        QP001RecordDetail detail = QP001RecordDetail.getInstance(identificationNo,
                targetDate,
                targetServiceDate,
                serviceDetail,
                serviceCode,
                patientState,
                detailMap,
                manager);
        
        //���R�[�h���쐬����Ă����
        if(detail != null){
            //���׏��f�[�^���
            detail.parse(serviceDetail,targetDate,patientState,serviceCode,identificationNo,manager);
        }
  	
	}
	
	/**
	 * ���̊m����s���B
	 */
    public void commitRecords(QP001PatientState patientState,VRMap styles, VRMap planUnitMap) throws Exception {
// 2015/5/12 [Yoichiro Kamei] mod - begin ����֘A������
//		VRMap kohiMap;
//		TreeMap kohiRank = new TreeMap();
		QP001RecordDetail detail = null;
		Iterator it;
		
//		//�{���[�ɂ��������ʂ̊m����s���B
//		//TODO ���������������������肳�������B
//		
//		Iterator it = detailMap.keySet().iterator();
//		while(it.hasNext()){
//			detail = (QP001RecordDetail)detailMap.get(it.next());
//			//�쐬�������׏�񃌃R�[�h�̌���K�p�󋵂��擾����B
//			kohiMap = detail.getKohiList();
//			Iterator itKohi = kohiMap.keySet().iterator();
//			//����̏��ʂ�o�^����B
//			while(itKohi.hasNext()){
//				Object key = itKohi.next();
//				if(!kohiRank.containsKey(key)){
//					kohiRank.put(key,kohiMap.get(key));
//				}
//			}
//		}
//		
//		//����K�p����
//		QP001KohiKey[] kohiTypes = new QP001KohiKey[3];
//		it = kohiRank.keySet().iterator();
//		int count = 0;
//		while(it.hasNext()){
//			VRMap temp = (VRMap)kohiRank.get(it.next());
//			kohiTypes[count] = new QP001KohiKey(temp);
//			count++;
//		}
		
        List<Map> records = new ArrayList<Map>();
        records.add(detailMap);
        QP001KohiKey[] kohiTypes = getKohiApplyArray(records);
// 2015/5/12 [Yoichiro Kamei] mod - end
        
		//���׏�񃌃R�[�h�̊m�菈��
		//[ID:0000721][Shin Fujihara] 2012/04 delete start 2012�N�x�Ή�
//		it = detailMap.keySet().iterator();
//		while(it.hasNext()){
//			//�쐬�������׏�񃌃R�[�h�̊m����s���B
//			((QP001RecordDetail)detailMap.get(it.next())).commitRecord(kohiTypes,patientState);
//		}
		//[ID:0000721][Shin Fujihara] 2012/04 delete end 2012�N�x�Ή�
        //[ID:0000721][Shin Fujihara] 2012/04 add start 2012�N�x�Ή�
        //�Ŏ��E�^�[�~�i�����Z�̓E�v���]�L���l�����Ȃ���̖��׊m�菈��
        commitDetails(detailMap, kohiTypes, patientState);
        //[ID:0000721][Shin Fujihara] 2012/04 add end 2012�N�x�Ή�
		
		//[ID:0000682][Shin Fujihara] add begin �y�@�����Ή��z���E���������P���Z
		commitTreatmentImprovement(detailMap, patientState, styles, planUnitMap);
		//[ID:0000682][Shin Fujihara] add end �y�@�����Ή��z���E���������P���Z
		
		it = detailMap.keySet().iterator();
		//�W�v��񃌃R�[�h�̍쐬(���׏����)
		while(it.hasNext()){
			detail = ((QP001RecordDetail)detailMap.get(it.next()));
			type.parse(detail,patientState,manager);
		}
		
		//�W�v��񃌃R�[�h�̊m�菈��
		type.commitRecord(kohiTypes,patientState,styles,planUnitMap);
		
		
		//��{��񃌃R�[�h�̊m�菈��
		base.parse(type,patientState,kohiTypes,manager);
		
	}

	/**
	 * DB�o�^�p�̃f�[�^�擾���s���B
	 */
    public VRList getRecords(int patient_id, Date claimDate) throws Exception {
		VRList list = new VRArrayList();
		VRHashMap style = new VRHashMap();
        
        if(ACTextUtilities.isNullText(base.get_201003())){
            return list;
        }
		
		//���[�̗l���ԍ�
		style.put("CLAIM_STYLE_TYPE",ACCastUtilities.toString(claimStyleFormat));
		//���p�҂h�c
		style.put("PATIENT_ID",Integer.toString(patient_id));
		//��{��񃌃R�[�h����擾
		//���p�Ҕԍ�(��ی��Ҕԍ�)
		style.put("INSURED_ID",base.get_201006());
		//�����̑ΏۂƂȂ�N��(�T�[�r�X�񋟔N��)
		style.put("TARGET_DATE",ACCastUtilities.toDate(base.get_201003() + "01"));
		//�������s���N����
		style.put("CLAIM_DATE",claimDate);
		//���������Ə�
		style.put("PROVIDER_ID",base.get_201004());
        
        //�ی��Ҕԍ�
        style.put("INSURER_ID",base.get_201005());
        //��ی��Ҕԍ�
        style.put("INSURED_ID",base.get_201006());
		
		style.put("CLAIM_FINISH_FLAG","0");
		
		//���׏�񃌃R�[�h
		Iterator it = detailMap.keySet().iterator();
		while(it.hasNext()){
			list.add(((QP001RecordDetail)detailMap.get(it.next())).getRecord(style));
		}		
		//�W�v��񃌃R�[�h
		list.add(type.getRecord(style));
		
		//��{��񃌃R�[�h
		list.add(base.getRecord(style));
		
		return list;
	}

}
