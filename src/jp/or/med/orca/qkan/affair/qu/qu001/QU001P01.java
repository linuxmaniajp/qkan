
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
 * �J����: �� ����
 * �쐬��: 2005/12/20  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���p�ҊǗ� (U)
 * �v���Z�X ���p�҈ꗗ (001)
 * �v���O���� ���p�҈ꗗ (QU00101)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qu.qu001;

import java.util.Date;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.text.ACNullToBlankFormat;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;

/**
 * ���p�҈ꗗ(QU00101) 
 * ���[��`�̃t�@�C���� �F QU00101.xml
 */
public class QU001P01 extends QU001P01Event {
	
	private static final int jotaiCodeId = 204;
	
  /**
   * �R���X�g���N�^�ł��B
   */
  public QU001P01(){
  }

  /**
   * ���[�𐶐����܂��B
   * @param writer ����Ǘ��N���X
   * @param printParam ����p�����^
   * @throws Exception ������O
   */
  public boolean doPrint(ACChotarouXMLWriter writer, VRMap printParam) throws Exception {
      final Date MAX_DATE = ACCastUtilities.toDate("9999/12/31", null);
      
  	// ���[ID��K�v�ɉ�����"mainFormat"����K�؂Ȃ��̂ɏ��������邱�ƁB
    ACChotarouXMLUtilities.addFormat(writer, "QU001P01", "QU001P01.xml");    
    
    // ����p���i�[�p��VRArrayList printArray���`����B
    VRList printArray = new VRArrayList();    
    
    // printArray�ɁA�n��p�����[�^�� KEY : PARAM �� VALUE ��ݒ肷��B
    // ���ȉ��AprintArray�Ɋi�[����Ă��郌�R�[�h���Q�Ƃ���B
    printArray = (VRList)printParam.get("PARAM");

    // ���݂̓��t���擾����B(�V�X�e�����t�ł͂Ȃ�)
    Date nowDate = new Date();

    // ����Ő����Z�o����B�i1�ł�����̗��p�Ҍ�����24��)
    int pages;
    
    if(printArray.size() % 24 == 0){
    	pages = printArray.size() / 24;
    }else{
    	pages = printArray.size() / 24 + 1;
    }
    
    // �o�͂������p�҃f�[�^�̌������J�E���g����J�E���^
    int dataCount = 0;
    // ����y�[�W�����J�E���g����J�E���^
    int pageCount = 0;
    
    do{
    
    	// �y�[�W�J�n
	    writer.beginPageEdit("QU001P01");    	
	    
	    // ������t���󎚂���B
	    ACChotarouXMLUtilities.setValue(
	    		writer, 
				"Date", 
				VRDateParser.format(nowDate, "ggge�NMM��dd��"));
	    
	    // 1�ł�����̈��������24���ɂȂ�A�������͑S�Ă̗��p�҂��������܂Ń��[�v����B
    	for(int j = 0; j < 24; j++){
    		
    		// ���p�҂̃f�[�^���Ȃ��ꍇ�I���B
    		if(dataCount >= printArray.size()){
    			break;
    		}
    		
	    	// ������闘�p�ҏ��(1����)���AVRHashMap patientMap�ɑޔ�����B
	    	VRMap patientMap = (VRMap)printArray.get(dataCount);
    	
	    	// ���p�҃R�[�h��ݒ肷��B
	    	if(VRBindPathParser.has("PATIENT_CODE", patientMap)){
		    	ACChotarouXMLUtilities.setValue(
		    			writer, 
						patientMap, 
						"PATIENT_CODE", 
						"patients.h" + (j + 1) + ".patientCd");
	    	}
	    	
		    // ��ی��Ҕԍ���ݒ肷��B
	    	if(VRBindPathParser.has("INSURED_ID", patientMap)){
		    	ACChotarouXMLUtilities.setValue(
		    			writer, 
						patientMap, 
						"INSURED_ID", 
						"patients.h" + (j + 1) + ".patientInsuredId");
	    	}

		    // ������ݒ肷��B	
	    	String familyName = ACCastUtilities.toString(VRBindPathParser.get("PATIENT_FAMILY_NAME", patientMap));
	    	String firstName = ACCastUtilities.toString(VRBindPathParser.get("PATIENT_FIRST_NAME", patientMap));
	    	
	    	ACChotarouXMLUtilities.setValue(
	    			writer, 
					"patients.h" + (j + 1) + ".patientName", 
					QkanCommon.toFullName(familyName, firstName));

	    	// ���ʂ�ݒ肷��BpatientMap��KEY : SEX �� VALUE �Őݒ肷�镶�����ύX����B	    		
    		if(VRBindPathParser.get("PATIENT_SEX", patientMap) instanceof Integer){
    		
	    		int sex = ACCastUtilities.toInt(VRBindPathParser.get("PATIENT_SEX", patientMap));
	    		    		
		    	if(sex == 1){
		    		// 1(�j)�̏ꍇ
			    	// �u�j�v��ݒ肷��B
		    		ACChotarouXMLUtilities.setValue(
			    			writer, 
							"patients.h" + (j + 1) + ".patientSex", 
							"�j");
		    	}else{
				    // 2(��)�̏ꍇ
				    // �u���v��ݒ肷��B
		    		ACChotarouXMLUtilities.setValue(
			    			writer, 
							"patients.h" + (j + 1) + ".patientSex", 
							"��");
		    	}			    	
    		}
	    	
	    	//���N�������擾����B
	    	Date birthDay = null;
	    	
    		if(VRBindPathParser.get("PATIENT_BIRTHDAY", patientMap) instanceof Date){
    		
	    		birthDay = ACCastUtilities.toDate(VRBindPathParser
	    				.get("PATIENT_BIRTHDAY", patientMap));
	    	
		    	// �N����v�Z����B
		    	int age = QkanCommon.calcAge(birthDay, nowDate);
		    	
			    // �N���ݒ肷��B
		    	ACChotarouXMLUtilities.setValue(
		    			writer, 
						"patients.h" + (j + 1) + ".patientAge",
						new Integer(age));
    		}
		    	
		    // patientMap�� KEY : JOTAI_CODE �� VALUE ���A�v���x��\��������ɕϊ�����B
	    	if(VRBindPathParser.has("JOTAI_CODE", patientMap)){
			    String yokaigodo = QkanCommon.getContentFromMasterCode(
			    		jotaiCodeId, 
						ACCastUtilities.toInt(VRBindPathParser.get("JOTAI_CODE", patientMap)));
			    
			    // �ϊ������������ݒ肷��B
			    ACChotarouXMLUtilities.setValue(
		    			writer, 
						"patients.h" + (j + 1) + ".yokaigodo",
						yokaigodo);
	    	}
			    
		    // �L��������ݒ肷��B
	    	if(VRBindPathParser.get("INSURE_VALID_END", patientMap) instanceof Date){
    	
	    		Date insureValidEnd = ACCastUtilities.toDate(VRBindPathParser.get("INSURE_VALID_END", patientMap));

			    // �L��������9999/12/31�̏ꍇ�󎚂��Ȃ��B���v���x���u��Y���v�̏ꍇ
			    if(ACDateUtilities.getDifferenceOnTotalDay(insureValidEnd, MAX_DATE) != 0){
			    		
		    		ACChotarouXMLUtilities.setValue(
			    			writer, 
							"patients.h" + (j + 1) + ".validDate",
							VRDateParser.format(insureValidEnd, "ggge�NMM��dd��"));
			    }
		    		
	    	}

		    // �L�������J�n��ݒ肷��B
	    	if(VRBindPathParser.get("INSURE_VALID_START", patientMap) instanceof Date){
    	
	    		Date insureValidStart = ACCastUtilities.toDate(VRBindPathParser.get("INSURE_VALID_START", patientMap));

			    // �L��������9999/12/31�̏ꍇ�󎚂��Ȃ��B���v���x���u��Y���v�̏ꍇ
			    if(ACDateUtilities.getDifferenceOnTotalDay(insureValidStart, MAX_DATE) != 0){
			    		
		    		ACChotarouXMLUtilities.setValue(
			    			writer, 
							"patients.h" + (j + 1) + ".validDateStart",
							VRDateParser.format(insureValidStart, "ggge�NMM��dd��"));
			    }
		    		
	    	}
	    	
		    // �Z����ݒ肷��B
	    	if(VRBindPathParser.has("PATIENT_ADDRESS", patientMap)){
			    ACChotarouXMLUtilities.setValue(
		    			writer, 
						patientMap, 
						"PATIENT_ADDRESS", 
						"patients.h" + (j + 1) + ".patientAddress");
	    	}

		    // �ϐ�telFirst(String�^)�𐶐����ApatientMap�� KEY : PATIENT_TEL_FIRST �� VALUE ��ݒ肷��B
		    // �ϐ�telSecond(String�^)�𐶐����ApatientMap�� KEY : PATIENT_TEL_SECOND �� VALUE ��ݒ肷��B
		    // �ϐ�telThird(String�^)�𐶐����ApatientMap�� KEY : PATIENT_TEL_THIRD �� VALUE ��ݒ肷��B
		    String telFirst = ACCastUtilities.toString(VRBindPathParser.get("PATIENT_TEL_FIRST", patientMap));
		    String telSecond = ACCastUtilities.toString(VRBindPathParser.get("PATIENT_TEL_SECOND", patientMap));
		    String telThird = ACCastUtilities.toString(VRBindPathParser.get("PATIENT_TEL_THIRD", patientMap));

		    // �d�b�ԍ��Ƃ��āAtel�̒l��ݒ肷��B
		    ACChotarouXMLUtilities.setValue(
	    			writer, 
					"patients.h" + (j + 1) + ".patientTel",
					QkanCommon.toTel(telFirst, telSecond, telThird));

		    // ����x�����Ə�����ݒ肷��B
		    ACChotarouXMLUtilities.setValue(
	    			writer, 
					patientMap, 
					"PROVIDER_NAME", 
					"patients.h" + (j + 1) + ".providerName");

		    // �L���������擾����B(patientMap��KEY : INSURE_VALID_END �� VALUE)
		    if(VRBindPathParser.get("INSURE_VALID_END", patientMap) instanceof Date){
		    
			    Date insureValidEnd = ACCastUtilities.toDate(VRBindPathParser
			    		.get("INSURE_VALID_END", patientMap));
		    
			    // ���ݓ��t+�񃖌�
			    Date addDate = ACDateUtilities.addDay(nowDate, 59);
			    
			    // �l���`�F�b�N����B
			    // ���ݓ��t+�񃖌������O�̓��t�̏ꍇ
			    if(ACDateUtilities.getDifferenceOnTotalDay(insureValidEnd, addDate) < 0){
			    	
				    // ���̑��Ɂu*�v��ݒ肷��B
			    	ACChotarouXMLUtilities.setValue(
			    			writer, 
							"patients.h" + (j + 1) + ".extra",
							"*");
			    	
			    }			    
		    }
		    
		    //�f�[�^�J�E���g��1���Z����B
		    dataCount += 1;

    	}
    	
	    //�y�[�W�����I��
	    writer.endPageEdit();
	    //�y�[�W�J�E���g��1���Z����B
	    pageCount += 1;
    
    }while(pageCount < pages);		//�y�[�W�J�E���g���o�͗\��̃y�[�W���𒴂����ꍇ
    
    // ��������s�����Ȃ��true��Ԃ��B
    return true;
    
  }
}
