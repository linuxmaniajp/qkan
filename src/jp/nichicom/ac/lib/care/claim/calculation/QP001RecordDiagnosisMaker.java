
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
 * �v���O���� ���莾�����R�[�h (QP001RecordDiagnosisMaker)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Date;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRMap;

/**
 * ���莾�����R�[�h�̍쐬���s���܂��B
 *
 */
public class QP001RecordDiagnosisMaker {
	
	private String serialHeader = "";
	private String identificationNo = "";
	private VRMap serviceDetail = null;
	private Date targetDate = null;
	private QP001PatientState patientState = null;
	private VRMap serviceCode = null;
	private Map<String, QP001RecordDiagnosis> diagnosisMap = null;
    
    /**
     * �O���t���O
     */
    private int gaihaku = 0;
    
    private QP001Manager manager = null;
    
    /**
     * 30�����t���O
     * (30�Β��t���O�ł͂Ȃ��B)
     */
	private boolean over30 = false;

	protected QP001RecordDiagnosisMaker(
			 String identificationNo,
			 VRMap serviceDetail,
			 Date targetDate,
			 Object targetServiceDate,
			 QP001PatientState patientState,
			 VRMap serviceCode,
			 Map<String, QP001RecordDiagnosis> diagnosisMap,
             QP001Manager manager) throws Exception {
        
        gaihaku = CareServiceCommon.isGaihaku(serviceDetail);
        
        //30�����ł���΃��R�[�h�̍쐬�𒆒f����B
        if(ACCastUtilities.toInt(serviceDetail.get("5"),0) == 2){
            over30 = true;
        }
		
		StringBuilder sb = new StringBuilder();
		//�������ʔԍ�
		sb.append(identificationNo);
		//���R�[�h��ʃR�[�h2��
		sb.append(QP001RecordDiagnosis.get_501002());
		//�T�[�r�X�񋟔N��6��(YYYYMM)
		sb.append(VRDateParser.format(targetDate,"yyyyMM"));
		//���Ə��ԍ�10��
		sb.append(VRBindPathParser.get("PROVIDER_ID",serviceDetail));
		//�؋L�ڕی��Ҕԍ�8��
		sb.append(patientState.getInsurerId(targetServiceDate));
		//��ی��Ҕԍ�10��
		sb.append(patientState.getInsuredId(targetServiceDate));
		//�V�X�e�����T�[�r�X��ރR�[�h
		sb.append(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL", serviceDetail));
		
		//�V���A���ԍ���ݒ�B
		serialHeader = sb.toString();
		
		this.identificationNo = identificationNo;
		this.serviceDetail = serviceDetail;
		this.targetDate = targetDate;
		this.patientState = patientState;
		this.serviceCode = serviceCode;
		this.diagnosisMap = diagnosisMap;
        this.manager = manager;
	}
	
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	protected Map<String, QP001RecordDiagnosis> make() throws Exception{
        
        //�O���Ȃ�΍쐬�𒆒f����B
        if(gaihaku == 2){
            return diagnosisMap;
        }
        
        //30�����Ȃ�쐬�𒆒f����B
        if(over30){
            return diagnosisMap;
        }
        
		int result = 0;
		//(����f�Ô� �w���Ǘ���)�����΍�w���Ǘ��`�F�b�N
		result = getValue("3010101");
		if(result != 0){
			parseRecord("01",result);
		}
		//(����f�Ô� �w���Ǘ���)��጑΍�w���Ǘ��`�F�b�N
		result = getValue("3010102");
		if(result != 0){
			parseRecord("34",result);
		}
		//(����f�Ô� �w���Ǘ���)�������@�f�ÊǗ��`�F�b�N
		result = getValue("3010103");
		if(result != 0){
			parseRecord("05",result);
		}
		//(����f�Ô� �w���Ǘ���)�d�v�×{�Ǘ��`�F�b�N
		result = getValue("3010104");
		if(result != 0){
			parseRecord("35",result);
		}
		//(����f�Ô� �w���Ǘ���)����{�݊Ǘ��`�F�b�N
		result = getValue("3010105");
		if(result != 0){
			parseRecord("02",result);
		}
		//(����f�Ô� �w���Ǘ���)����{�݊Ǘ������Z�`�F�b�N
		result = getValue("3010106");
		if(result != 0){
			parseRecord("03",result);
		}
		//(����f�Ô� �w���Ǘ���)����{�݊Ǘ��Q�l�������Z�`�F�b�N
		result = getValue("3010107");
		if(result != 0){
			parseRecord("04",result);
		}
		//(����f�Ô� �w���Ǘ���)�d�ǔ畆��ᇊǗ��w���`�F�b�N
		result = getValue("3010108");
		if(result != 0){
			parseRecord("06",result);
		}
        //�܂�܂䂪����Ȃ��ƌ����܂����B
//		//(����f�Ô� �w���Ǘ���)���h�{�H���w���`�F�b�N
//		result = getValue("3010109");
//		if(result != 0){
//			parseRecord("08",result);
//		}
		//(����f�Ô� �w���Ǘ���)��܊Ǘ��w���`�F�b�N
		result = getValue("3010110");
		if(result != 0){
			parseRecord("09",result);
		}
		//(����f�Ô� �w���Ǘ���)���ʖ�܊Ǘ��w�����Z�`�F�b�N
		result = getValue("3010111");
		if(result != 0){
			parseRecord("10",result);
		}
		//(����f�Ô� �w���Ǘ���)��w����(�T)�`�F�b�N
		result = getValue("3010112");
		if(result != 0){
			parseRecord("11",result);
		}
		//(����f�Ô� �w���Ǘ���)��w����(�U)�`�F�b�N
		result = getValue("3010113");
		if(result != 0){
			parseRecord("12",result);
		}
		//(����f�Ô� ���n�r���e�[�V����)���w�Ö@(�T)��-0�E1�E2�E3
		result = getValue("3010114");
		if(result != 0){
			parseRecord("14",result);
		}
		//(����f�Ô� ���n�r���e�[�V����)���w�Ö@(�U)��-0�E1�E2�E3
		result = getValue("3010115");
		if(result != 0){
			parseRecord("16",result);
		}
		//(����f�Ô� ���n�r���e�[�V����)���w�Ö@(�V)��-0�E1�E2�E3
		result = getValue("3010116");
		if(result != 0){
			parseRecord("18",result);
		}
		//(����f�Ô� ���n�r���e�[�V����)���w�Ö@(�W)��-0�E1�E2�E3
		result = getValue("3010117");
		if(result != 0){
			parseRecord("19",result);
		}
		//(����f�Ô� ���n�r���e�[�V����)���w�Ö@(�T)(���Z)��-0�E1�E2�E3
		result = getValue("3010118");
		if(result != 0){
			parseRecord("40",result);
		}
		//(����f�Ô� ���n�r���e�[�V����)���w�Ö@(�U)(���Z)��-0�E1�E2�E3
		result = getValue("3010119");
		if(result != 0){
			parseRecord("41",result);
		}
		//(����f�Ô� ���n�r���e�[�V����)���w�Ö@(�V)(���Z)��-0�E1�E2�E3
		result = getValue("3010120");
		if(result != 0){
			parseRecord("42",result);
		}
		//(����f�Ô� ���n�r���e�[�V����)���w�Ö@(�W)(���Z)��-0�E1�E2�E3
		result = getValue("3010121");
		if(result != 0){
			parseRecord("43",result);
		}
		//(����f�Ô� ���n�r���e�[�V����)���w�Ö@���퐶�������P�����Z��-0�E1�E2�E3
		result = getValue("3010122");
		if(result != 0){
			parseRecord("36",result);
		}
		//(����f�Ô� ���n�r���e�[�V����)���w�Ö@���n�r���v����Z�`�F�b�N
		result = getValue("3010123");
		if(result != 0){
			parseRecord("20",result);
		}
		//(����f�Ô� ���n�r���e�[�V����)���w�Ö@���퓮��P���w�����Z�`�F�b�N
		result = getValue("3010124");
		if(result != 0){
			parseRecord("22",result);
		}
		//(����f�Ô� ���n�r���e�[�V����)��ƗÖ@(�T)��-0�E1�E2�E3
		result = getValue("3010125");
		if(result != 0){
			parseRecord("23",result);
		}
		//(����f�Ô� ���n�r���e�[�V����)��ƗÖ@(�U)��-0�E1�E2�E3
		result = getValue("3010126");
		if(result != 0){
			parseRecord("25",result);
		}
		//(����f�Ô� ���n�r���e�[�V����)��ƗÖ@(�T)(���Z)��-0�E1�E2�E3
		result = getValue("3010127");
		if(result != 0){
			parseRecord("44",result);
		}
		//(����f�Ô� ���n�r���e�[�V����)��ƗÖ@(�U)(���Z)��-0�E1�E2�E3
		result = getValue("3010128");
		if(result != 0){
			parseRecord("45",result);
		}
		//(����f�Ô� ���n�r���e�[�V����)��ƗÖ@���퐶�������P�����Z��-0�E1�E2�E3
		result = getValue("3010129");
		if(result != 0){
			parseRecord("37",result);
		}
		//(����f�Ô� ���n�r���e�[�V����)��ƗÖ@���n�r���v����Z�`�F�b�N
		result = getValue("3010130");
		if(result != 0){
			parseRecord("27",result);
		}
		//(����f�Ô� ���n�r���e�[�V����)��ƗÖ@���퓮��P���w�����Z�`�F�b�N
		result = getValue("3010131");
		if(result != 0){
			parseRecord("29",result);
		}
		//(����f�Ô� ���n�r���e�[�V����)���꒮�o�Ö@(�T)��-0�E1�E2�E3
		result = getValue("3010132");
		if(result != 0){
			parseRecord("38",result);
		}
		//(����f�Ô� ���n�r���e�[�V����)���꒮�o�Ö@(�U)��-0�E1�E2�E3
		result = getValue("3010133");
		if(result != 0){
			parseRecord("39",result);
		}
		//(����f�Ô� ���n�r���e�[�V����)���꒮�o�Ö@(�T)(���Z)��-0�E1�E2�E3
		result = getValue("3010134");
		if(result != 0){
			parseRecord("46",result);
		}
		//(����f�Ô� ���n�r���e�[�V����)���꒮�o�Ö@(�U)(���Z)��-0�E1�E2�E3
		result = getValue("3010135");
		if(result != 0){
			parseRecord("47",result);
		}
		//(����f�Ô� ���n�r���e�[�V����)�ېH�@�\�Ö@�`�F�b�N
		result = getValue("3010136");
		if(result != 0){
			parseRecord("31",result);
		}
		//(����f�Ô� ���_�Ȑ��Ö@)���_�ȍ�ƗÖ@�`�F�b�N
		result = getValue("3010137");
		if(result != 0){
			parseRecord("32",result);
		}
		//(����f�Ô� ���_�Ȑ��Ö@)�F�m�ǐ��V�l���@���_�Ö@�`�F�b�N
		result = getValue("3010138");
		if(result != 0){
			parseRecord("33",result);
		}
        //(����f�Ô� ���n�r���e�[�V����)���w�Ö@���n�r���̐��������Z�`�F�b�N
        result = getValue("3010139");
        if(result != 0){
            parseRecord("48",result);
        }
        //(����f�Ô� ���n�r���e�[�V����)��ƗÖ@���n�r���̐��������Z�`�F�b�N
        result = getValue("3010140");
        if(result != 0){
            parseRecord("49",result);
        }
        //(����f�Ô� ���n�r���e�[�V����)���꒮�o�Ö@���n�r���̐��������Z�`�F�b�N
        result = getValue("3010141");
        if(result != 0){
            parseRecord("50",result);
        }
        //���n�r���}�l�W�����g���Z
        result = getValue("3010142");
        if(result != 0){
            parseRecord("51",result);
        }
        //�Z���W�����n�r�����Z
        result = getValue("3010143");
        if(result != 0){
            parseRecord("52",result);
        }
		
        //[ID:0000454][Shin Fujihara] 2009/02 add begin ����21�N4���@�����Ή�
        //�W�c�R�~���j�P�[�V�����Ö@
        result = getValue("3010150");
        if(result != 0){
            parseRecord("54",result);
        }
        //�F�m�ǒZ���W�����n�r�����Z
        result = getValue("3010151");
        if(result != 0){
            parseRecord("55",result);
        }
        //[ID:0000454][Shin Fujihara] 2009/02 add end ����21�N4���@�����Ή�
        
		return diagnosisMap;
	}
	
	//[H20.5 �@�����Ή�] fujihara add start
	protected Map<String, QP001RecordDiagnosis> makeRecuperation() throws Exception{
        
        //�O���Ȃ�΍쐬�𒆒f����B
        if(gaihaku == 2){
            return diagnosisMap;
        }
        
        //30�����Ȃ�쐬�𒆒f����B
        if(over30){
            return diagnosisMap;
        }
        
		int result = 0;
		//(���ʗ×{�� �w���Ǘ���)�����΍�w���Ǘ��`�F�b�N
		result = getValue("3010101");
		if(result != 0){
			parseRecord("01",result, 2);
		}
		//(���ʗ×{�� �w���Ǘ���)����{�݊Ǘ��`�F�b�N
		result = getValue("3010105");
		if(result != 0){
			parseRecord("02",result, 2);
		}
		//(���ʗ×{�� �w���Ǘ���)����{�݊Ǘ������Z�`�F�b�N
		result = getValue("3010106");
		if(result != 0){
			parseRecord("03",result, 2);
		}
		//(���ʗ×{�� �w���Ǘ���)����{�݊Ǘ��Q�l�������Z�`�F�b�N
		result = getValue("3010107");
		if(result != 0){
			parseRecord("04",result, 2);
		}
		//(���ʗ×{�� �w���Ǘ���)���������f�ÊǗ��`�F�b�N
		result = getValue("3010144");
		if(result != 0){
			parseRecord("05",result, 2);
		}
		//(���ʗ×{�� �w���Ǘ���)�d�ǔ畆��ᇊǗ��w���`�F�b�N
		result = getValue("3010108");
		if(result != 0){
			parseRecord("06",result, 2);
		}
		//(���ʗ×{�� �w���Ǘ���)��܊Ǘ��w���`�F�b�N
		result = getValue("3010110");
		if(result != 0){
			parseRecord("09",result, 2);
		}
		//(���ʗ×{�� �w���Ǘ���)���ʖ�܊Ǘ��w�����Z�`�F�b�N
		result = getValue("3010111");
		if(result != 0){
			parseRecord("10",result, 2);
		}
		//(���ʗ×{�� �w���Ǘ���)��w���񋟃`�F�b�N
		result = getValue("3010145");
		if(result != 0){
			parseRecord("11",result, 2);
		}
		//(���ʗ×{�� ���n�r���e�[�V����)�ېH�@�\�Ö@�`�F�b�N
		result = getValue("3010136");
		if(result != 0){
			parseRecord("31",result, 2);
		}
		//(���ʗ×{�� ���_�Ȑ��Ö@)���_�ȍ�ƗÖ@�`�F�b�N
		result = getValue("3010137");
		if(result != 0){
			parseRecord("32",result, 2);
		}
		//(���ʗ×{�� ���_�Ȑ��Ö@)�F�m�ǐ��V�l�������_�Ö@�`�F�b�N
		result = getValue("3010149");
		if(result != 0){
			parseRecord("33",result, 2);
		}
		//(���ʗ×{�� �w���Ǘ���)��጑΍�w���Ǘ��`�F�b�N
		result = getValue("3010102");
		if(result != 0){
			parseRecord("34",result, 2);
		}
		//(���ʗ×{�� �w���Ǘ���)�d�v�×{�Ǘ��`�F�b�N
		result = getValue("3010104");
		if(result != 0){
			parseRecord("35",result, 2);
		}
		//(���ʗ×{�� ���n�r���e�[�V����)���꒮�o�Ö@
		result = getValue("3010147");
		if(result != 0){
			parseRecord("39",result, 2);
		}
		//(���ʗ×{�� ���n�r���e�[�V����)���꒮�o�Ö@(���Z)
		result = getValue("3010148");
		if(result != 0){
			parseRecord("47",result, 2);
		}
        //(���ʗ×{�� ���n�r���e�[�V����)���꒮�o�Ö@���n�r���̐��������Z�`�F�b�N
        result = getValue("3010141");
        if(result != 0){
            parseRecord("50",result, 2);
        }
        //���n�r���e�[�V�����w���Ǘ�
        result = getValue("3010146");
        if(result != 0){
            parseRecord("53",result, 2);
        }
		
		return diagnosisMap;
	}
	//[H20.5 �@�����Ή�] fujihara add end
	
	private int getValue(String key) throws Exception {
		int result = 0;
		//�L�[�����݂��邩�m�F
		if(serviceDetail.containsKey(key)){
			result = ACCastUtilities.toInt(VRBindPathParser.get(key,serviceDetail), 0);
		}
		return result;
	}
	//[H20.5 �@�����Ή�] fujihara edit start
	private void parseRecord(String specialClinicType, int count) throws Exception {
		parseRecord(specialClinicType, count, 1);
	}
	private void parseRecord(String specialClinicType, int count, int recordType) throws Exception {
	
		QP001RecordDiagnosis diagnosis = getRecord(specialClinicType);
		diagnosis.parse(serviceDetail,targetDate,patientState,serviceCode,identificationNo,specialClinicType,count,manager,recordType);
	}
	
	private QP001RecordDiagnosis getRecord(String specialClinicType) throws Exception {
		QP001RecordDiagnosis diagnosis = null;
		String serial = this.serialHeader + specialClinicType;
		if(diagnosisMap.containsKey(serial)){
			diagnosis = (QP001RecordDiagnosis)diagnosisMap.get(serial);
		} else {
			diagnosis = new QP001RecordDiagnosis();
			diagnosisMap.put(serial,diagnosis);
			//���R�[�h�����ԍ���ݒ�
			diagnosis.set_501007(diagnosisMap.size());
			//
			diagnosis.set_501009(specialClinicType);
		}
		return diagnosis;
	}
	//[H20.5 �@�����Ή�] fujihara edit start
}
