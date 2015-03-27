
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
 * �v���O���� �l����� (QP001Style2)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

/**
 * �l�����@�꒠�[���̏��
 * @author shin fujihara
 *
 */
public class QP001Style2 extends QP001StyleAbstract{
	
	/**
	 * ���׏�񃌃R�[�h�W��
	 */
	private VRMap detailMap = new VRHashMap();
	/**
	 * �W�v��񃌃R�[�h�W��
	 */
	private Map<String, QP001RecordType> typeMap = new TreeMap<String, QP001RecordType>();
	/**
	 * ��{��񃌃R�[�h(�꒠�[�ɂЂƂ�)
	 */
	private QP001RecordBase base = new QP001RecordBase();
	/**
	 * �Љ�����ƃ��R�[�h�W��
	 */
	private VRMap reductionMap = new VRHashMap();
    
    /**
     * �����l���ԍ�
     */
    private int claimStyleFormat = 0;
    /**
     * �������ʔԍ�
     */
    private String identificationNo = "";
    
    private QP001Manager manager = null;
    
    public QP001Style2(int claimStyleFormat,QP001Manager manager){
        this.claimStyleFormat = claimStyleFormat;
        this.identificationNo = getIdentificationNo(claimStyleFormat,manager.getTargetDate());
        this.manager = manager;
    }

	
    public static String getSerialId(
			Date targetDate,
			VRMap serviceDetail,
			QP001PatientState patientState,
            int claimStyleFormat) throws Exception {
		StringBuilder serial = new StringBuilder();
		//201001	������񎯕ʔԍ�4��
		serial.append(getIdentificationNo(claimStyleFormat,targetDate));
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

        //���׏�񃌃R�[�h���擾
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
        
// 2014/12/24 [Yoichiro Kamei] add - begin �Z���n����Ή�
        //���׏�񃌃R�[�h���擾
        QP001RecordDetailJushotiTokurei detailJushotiTokurei = QP001RecordDetailJushotiTokurei.getInstance(identificationNo,
                                                                targetDate,
                                                                targetServiceDate,
                                                                serviceDetail,
                                                                serviceCode,
                                                                patientState,
                                                                detailMap,
                                                                manager);
        
        //���R�[�h���쐬����Ă����
        if(detailJushotiTokurei != null){
            //���׏��f�[�^���
        	detailJushotiTokurei.parse(serviceDetail,targetDate,patientState,serviceCode,identificationNo,manager);
        }        
// 2014/12/24 [Yoichiro Kamei] add - end
        
      	/* �Е����ƃ��R�[�h�W�v���� */
      	//�Е����R�[�h���擾
      	QP001RecordReduction reduction = QP001RecordReduction.getInstance(identificationNo,
                                                                        targetDate,
                                                                        targetServiceDate,
                                                                        serviceDetail,
                                                                        serviceCode,
                                                                        patientState,
                                                                        reductionMap,
                                                                        manager);
      	
        if(reduction != null){
            //�Љ�����ƃf�[�^���
            reduction.parse(serviceDetail,targetDate,patientState,serviceCode,identificationNo,manager);
        }

		
	}
    
    
    /**
     * �s�v�ȃ��R�[�h�𐮗�����B
     * @throws Exception
     */
    public void arrangement() throws Exception {
    	//�l�����̓�ȊO�͏������s�Ȃ�Ȃ��B
    	if(!"7132".equals(identificationNo)){
    		return;
    	}
    	
    	int unit = Integer.MAX_VALUE;
    	
		//���׏�񃌃R�[�h�̊m�菈��
		Iterator it = detailMap.keySet().iterator();
		while(it.hasNext()){
			//�쐬�������׏�񃌃R�[�h�̊m����s���B
			QP001RecordDetail detail = ((QP001RecordDetail)detailMap.get(it.next()));
			if(QP001SpecialCase.isArrangementData(detail.get_301007(),detail.get_301008())){
				//�P�ʐ����r
				if(detail.get_301009() < unit){
					unit = detail.get_301009();
				} else {
					it.remove();
				}
			}
		}
		
		it = detailMap.keySet().iterator();
		while(it.hasNext()){
			//�쐬�������׏�񃌃R�[�h�̊m����s���B
			QP001RecordDetail detail = ((QP001RecordDetail)detailMap.get(it.next()));
			if(QP001SpecialCase.isArrangementData(detail.get_301007(),detail.get_301008())){
				if(detail.get_301009() != unit){
					it.remove();
				}
			}
			
			//���n���Z�̃��R�[�h�ł��邩�m�F
			// [H27.4�����Ή�][Shinobu Hitaka] 2015/1/22 edit - begin �T�[�r�X�R�[�h�p���� 
			//if(ACCastUtilities.toInt(detail.get_301007(),0) == 61){
			//	if(ACCastUtilities.toInt(detail.get_301008(),0) == 8000){
			if("61".equals(detail.get_301007())){
				if("8000".equals(detail.get_301008())){
			// [H27.4�����Ή�][Shinobu Hitaka] 2015/1/22 edit - begin �T�[�r�X�R�[�h�p���� 
					VRMap mainMap = new VRHashMap();
					VRMap map = new VRHashMap();
					map.put("UNIT",new Integer(unit));
					map.put("TIMES",new Integer(1));
					mainMap.put(detail.get_301007() + "-" + detail.get_301008(),map);
					detail.setServiceUnitMap(mainMap);
				}
			}
		}
    }
    
	
	/**
	 * �f�[�^�̊m����s���B
	 */
    public void commitRecords(QP001PatientState patientState,VRMap styles, VRMap planUnitMap) throws Exception {
		String serial = "";
		VRMap kohiMap;
		TreeMap kohiRank = new TreeMap();
		QP001RecordDetail detail = null;
		
		//�{���[�ɂ��������ʂ̊m����s���B
		Iterator it = detailMap.keySet().iterator();
		while(it.hasNext()){
			detail = (QP001RecordDetail)detailMap.get(it.next());
			//�쐬�������׏�񃌃R�[�h�̌���K�p�󋵂��擾����B
			kohiMap = detail.getKohiList();
			Iterator itKohi = kohiMap.keySet().iterator();
			//����̏��ʂ�o�^����B
			while(itKohi.hasNext()){
				Object key = itKohi.next();
				if(!kohiRank.containsKey(key)){
					kohiRank.put(key,kohiMap.get(key));
				}
			}
		}
		
		//����K�p����
		String[] kohiTypes = new String[3];
		it = kohiRank.keySet().iterator();
		int count = 0;
		while(it.hasNext()){
			VRMap temp = (VRMap)kohiRank.get(it.next());
			kohiTypes[count] = ACCastUtilities.toString(VRBindPathParser.get("KOHI_TYPE",temp));
			count++;
			if(count > kohiTypes.length - 1) break;
		}
		
		//���׏�񃌃R�[�h�̊m�菈��
		it = detailMap.keySet().iterator();
		while(it.hasNext()){
			//�쐬�������׏�񃌃R�[�h�̊m����s���B
			((QP001RecordDetail)detailMap.get(it.next())).commitRecord(kohiTypes,patientState);
		}
		
		//[ID:0000682][Shin Fujihara] add begin �y�@�����Ή��z���E���������P���Z
		commitTreatmentImprovement(detailMap, patientState, styles, planUnitMap);
		//[ID:0000682][Shin Fujihara] add end �y�@�����Ή��z���E���������P���Z
		
		it = detailMap.keySet().iterator();
		//�W�v��񃌃R�[�h�̍쐬
		while(it.hasNext()){
			detail = ((QP001RecordDetail)detailMap.get(it.next()));
			serial = QP001RecordType.getSerialId(detail);
			QP001RecordType type = null;
			if(!typeMap.containsKey(serial)){
				type = new QP001RecordType();
				typeMap.put(serial,type);
			} else {
				type = (QP001RecordType)typeMap.get(serial);
			}
			type.parse(detail,patientState,manager);
		}
		
    	it = typeMap.keySet().iterator();
		QP001RecordType type;
		//�W�v��񃌃R�[�h�̊m�菈��
		while(it.hasNext()){
			type = ((QP001RecordType)typeMap.get(it.next()));
			type.commitRecord(kohiTypes,patientState,styles,planUnitMap);
		}
		
		//�Е����ƃ��R�[�h�̊m�菈��
		it = reductionMap.keySet().iterator();
		QP001RecordReduction reduction = null;
		while(it.hasNext()){
			reduction = (QP001RecordReduction)reductionMap.get(it.next());
			Iterator itType = typeMap.keySet().iterator();
			while(itType.hasNext()){
				type = (QP001RecordType)typeMap.get(itType.next());
				//�T�[�r�X��ރR�[�h�������W�v��񃌃R�[�h���擾����B
				if(reduction.get_901008().equals(type.get_701007())){
					reduction.commitRecord(type.get_701017());
					break;
				}
			}
		}
		
		it = typeMap.keySet().iterator();
		while(it.hasNext()){
			base.parse((QP001RecordType)typeMap.get(it.next()),patientState,kohiTypes,manager);
		}
		
	}
    
	
	/**
	 * DB�o�^�p�̃��R�[�h�W�����쐬���܂��B
	 * @param patient_id
	 * @param targetDate
	 * @return
	 * @throws Exception
	 */
    public VRList getRecords(int patient_id, Date claimDate) throws Exception {
		VRList list = new VRArrayList();
		VRHashMap style = new VRHashMap();
		
		//�f�[�^������ɐ�������Ă��Ȃ��ꍇ�͏������I������B
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
		//�Е����ƃ��R�[�h
		it = reductionMap.keySet().iterator();
		while(it.hasNext()){
			list.add(((QP001RecordReduction)reductionMap.get(it.next())).getRecord(style));
		}
		//�W�v��񃌃R�[�h
		it = typeMap.keySet().iterator();
		while(it.hasNext()){
			list.add(((QP001RecordType)typeMap.get(it.next())).getRecord(style));
		}
		list.add(base.getRecord(style));
		
		return list;
	}
	
	public String toString(){
		StringBuilder result = new StringBuilder();
		//���׏�񃌃R�[�h
		Iterator it = detailMap.keySet().iterator();
		while(it.hasNext()){
			result.append("Detail\n");
			result.append(((QP001RecordDetail)detailMap.get(it.next())));
		}
		//�Е����ƃ��R�[�h
		it = reductionMap.keySet().iterator();
		while(it.hasNext()){
			result.append("Reduction\n");
			result.append((QP001RecordReduction)reductionMap.get(it.next()));
		}
		//�W�v��񃌃R�[�h
		it = typeMap.keySet().iterator();
		while(it.hasNext()){
			result.append("Type\n");
			result.append((QP001RecordType)typeMap.get(it.next()));
		}
		//��{��񃌃R�[�h
		result.append("Base\n");
		result.append(base);
		
		return result.toString();
	}
	

}
