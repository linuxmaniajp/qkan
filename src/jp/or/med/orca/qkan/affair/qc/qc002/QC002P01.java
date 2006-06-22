
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
 * �쐬��: 2006/01/17  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���[�Ǘ� (C)
 * �v���Z�X �K��Ō�񍐏� (00201)
 * �v���O���� �K��Ō�񍐏� (QC00201)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qc.qc002;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.VRDateFormat;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;

/**
 * �K��Ō�񍐏�(QC00201) 
 * ���[��`�̃t�@�C���� �F QC00201.xml
 */
public class QC002P01 extends QC002P01Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QC002P01(){
  }

  /**
   * ���[�𐶐����܂��B
   * @param writer ����Ǘ��N���X
   * @param printParameters ����p�����^
   * @throws Exception ������O
   */
  public boolean doPrint(ACChotarouXMLWriter writer, VRMap printParam) throws Exception {
    //�K�v�ł���Β��[ID�����������邱�ƁB
    ACChotarouXMLUtilities.addFormat(writer, "QC002P01", "QC002P01.xml");
    //�y�[�W�J�n
    writer.beginPageEdit("QC002P01");
    
    VRMap printParameters = (VRMap)printParam.getData("HOUKOKUSYO_INFO");
    VRMap printCalendar = (VRMap)printParam.getData("CALENDAR"); 
    
      // ���p�Ҏ�����ݒ肷��B
    ACChotarouXMLUtilities.setValue(writer, printParameters, "PATIENT_NAME", "patient.patientName.value");
    Date patientBirthDay = null;
    String era = "";
    // �n��p�����[�^printParam��KEY:PATIENT_BIRTHDAY��VALUE���擾����B
    if(VRBindPathParser.has("PATIENT_BIRTHDAY",printParameters)){
    	patientBirthDay = (Date)VRBindPathParser.get("PATIENT_BIRTHDAY",printParameters);
    	//�擾�����l��a��ɕϊ�����B
    	era = ACDateUtilities.getEraFull(patientBirthDay);
    }
    // �N���ɂ���ĕ��򂷂�B
    // �@�����̏ꍇ
    if("����".equals(era)){
    	//�u�吳�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "patientBirth2");
	    //�u���a�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "patientBirth3");
	    //�u�����v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "patientBirth4");
	    
    // �@�吳�̏ꍇ
    }else if("�吳".equals(era)){
    	//�u�����v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "patientBirth1");
	    //�u���a�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "patientBirth3");
	    //�u�����v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "patientBirth4");
    
    // �@���a�̏ꍇ
    }else if("���a".equals(era)){
    	//�u�����v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "patientBirth1");
	    //�u�吳�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "patientBirth2");
	    //�u�����v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "patientBirth4");
    
    // �@�����̏ꍇ
    }else if("����".equals(era)){
	    //�u�����v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "patientBirth1");
	    //�u�吳�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "patientBirth2");
	    //�u���a�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "patientBirth3");
    } else {
        //�u�����v�̃V�F�C�v���\���ɂ���B
        ACChotarouXMLUtilities.setInvisible(writer, "patientBirth1");
        //�u�吳�v�̃V�F�C�v���\���ɂ���B
        ACChotarouXMLUtilities.setInvisible(writer, "patientBirth2");
        //�u���a�v�̃V�F�C�v���\���ɂ���B
        ACChotarouXMLUtilities.setInvisible(writer, "patientBirth3");
        //�u�����v�̃V�F�C�v���\���ɂ���B
        ACChotarouXMLUtilities.setInvisible(writer, "patientBirth4");
    }
    
    // �N��ݒ肷��B
    ACChotarouXMLUtilities.setValue(writer,"patientBirthDay.h1.year",new Integer(ACDateUtilities.getEraYear(patientBirthDay)));
    
    // ����ݒ肷��B
    ACChotarouXMLUtilities.setValue(writer,"patientBirthDay.h1.month",new Integer(ACDateUtilities.getMonth(patientBirthDay)));

    // ����ݒ肷��B
    ACChotarouXMLUtilities.setValue(writer,"patientBirthDay.h1.day",new Integer(ACDateUtilities.getDayOfMonth(patientBirthDay)));

    // ���p�ҔN���ݒ肷��B
    int patientAge = QkanCommon.calcAge(patientBirthDay);
    ACChotarouXMLUtilities.setValue(writer,"patientBirthDay.h1.age",new Integer(patientAge));
    
    // �v���x
    int jotaiCode = ACCastUtilities.toInt(printParameters.getData("JOTAI_CODE"), 1);
    
    // �n��p�����[�^printParam�̂�KEY:JOTAI_CODE��VALUE�ɂ���ĕ��򂷂�B
    switch(jotaiCode){
    // �@�u�����v�̏ꍇ
    case 1:
	    //�u�o�ߓI�v���v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState11");
	    //�u�v���P�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState21");
	    //�u�v���Q�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState22");
	    //�u�v���R�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState23");
	    //�u�v���S�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState24");
	    //�u�v���T�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState25");
        //��v�x��1��̃V�F�C�v���\���ɂ���B
        ACChotarouXMLUtilities.setInvisible(writer, "nursState12");
        //��v�x��2��̃V�F�C�v���\���ɂ���B
        ACChotarouXMLUtilities.setInvisible(writer, "nursState13");        
        break;

	    
    // �@�u�o�ߓI�v���v�̏ꍇ
    case 11:
	    //�u�����v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState1");
	    //�u�v���P�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState21");
	    //�u�v���Q�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState22");
	    //�u�v���R�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState23");
	    //�u�v���S�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState24");
	    //�u�v���T�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState25");
	    //��v�x��1��̃V�F�C�v���\���ɂ���B
        ACChotarouXMLUtilities.setInvisible(writer, "nursState12");
        //��v�x��2��̃V�F�C�v���\���ɂ���B
        ACChotarouXMLUtilities.setInvisible(writer, "nursState13");        
    	break;

        //��v�x��1�v�̏ꍇ
    case 12:
//      �u�����v�̃V�F�C�v���\���ɂ���B
        ACChotarouXMLUtilities.setInvisible(writer, "nursState1");
        //��o�ߓI�v��죂̃V�F�C�v���\���ɂ���B
        ACChotarouXMLUtilities.setInvisible(writer, "nursState11");
//      ��v�x��2��̃V�F�C�v���\���ɂ���B
        ACChotarouXMLUtilities.setInvisible(writer, "nursState13");
        //�u�v���P�v�̃V�F�C�v���\���ɂ���B
        ACChotarouXMLUtilities.setInvisible(writer, "nursState21");
        //�u�v���Q�v�̃V�F�C�v���\���ɂ���B
        ACChotarouXMLUtilities.setInvisible(writer, "nursState22");
        //�u�v���R�v�̃V�F�C�v���\���ɂ���B
        ACChotarouXMLUtilities.setInvisible(writer, "nursState23");
        //�u�v���S�v�̃V�F�C�v���\���ɂ���B
        ACChotarouXMLUtilities.setInvisible(writer, "nursState24");
        //�u�v���T�v�̃V�F�C�v���\���ɂ���B
        ACChotarouXMLUtilities.setInvisible(writer, "nursState25");
        //�������I������B
        break;
        //��v�x��2��̏ꍇ
    case 13:
//      �u�����v�̃V�F�C�v���\���ɂ���B
        ACChotarouXMLUtilities.setInvisible(writer, "nursState1");
        //��o�ߓI�v��죂̃V�F�C�v���\���ɂ���B
        ACChotarouXMLUtilities.setInvisible(writer, "nursState11");
//      ��v�x��1��̃V�F�C�v���\���ɂ���B
        ACChotarouXMLUtilities.setInvisible(writer, "nursState12");
        //�u�v���P�v�̃V�F�C�v���\���ɂ���B
        ACChotarouXMLUtilities.setInvisible(writer, "nursState21");
        //�u�v���Q�v�̃V�F�C�v���\���ɂ���B
        ACChotarouXMLUtilities.setInvisible(writer, "nursState22");
        //�u�v���R�v�̃V�F�C�v���\���ɂ���B
        ACChotarouXMLUtilities.setInvisible(writer, "nursState23");
        //�u�v���S�v�̃V�F�C�v���\���ɂ���B
        ACChotarouXMLUtilities.setInvisible(writer, "nursState24");
        //�u�v���T�v�̃V�F�C�v���\���ɂ���B
        ACChotarouXMLUtilities.setInvisible(writer, "nursState25");
        //�������I������B
        break;

    // �@�u�v���P�v�̏ꍇ
    case 21:
	    //�u�����v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState1");
	    //�u�o�ߓI�v���v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState11");
	    //�u�v���Q�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState22");
	    //�u�v���R�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState23");
	    //�u�v���S�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState24");
	    //�u�v���T�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState25");
        //��v�x��1��̃V�F�C�v���\���ɂ���B
        ACChotarouXMLUtilities.setInvisible(writer, "nursState12");
        //��v�x��2��̃V�F�C�v���\���ɂ���B
        ACChotarouXMLUtilities.setInvisible(writer, "nursState13");        
        break;

    // �@�u�v���Q�v�̏ꍇ
    case 22:
	    //�u�����v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState1");
	    //�u�o�ߓI�v���v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState11");
	    //�u�v���P�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState21");
	    //�u�v���R�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState23");
	    //�u�v���S�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState24");
	    //�u�v���T�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState25");
        //��v�x��1��̃V�F�C�v���\���ɂ���B
        ACChotarouXMLUtilities.setInvisible(writer, "nursState12");
        //��v�x��2��̃V�F�C�v���\���ɂ���B
        ACChotarouXMLUtilities.setInvisible(writer, "nursState13");        
        break;

    // �@�u�v���R�v�̏ꍇ
    case 23:
	    //�u�����v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState1");
	    //�u�o�ߓI�v���v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState11");
	    //�u�v���P�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState21");
	    //�u�v���Q�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState22");
	    //�u�v���S�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState24");
	    //�u�v���T�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState25");
        //��v�x��1��̃V�F�C�v���\���ɂ���B
        ACChotarouXMLUtilities.setInvisible(writer, "nursState12");
        //��v�x��2��̃V�F�C�v���\���ɂ���B
        ACChotarouXMLUtilities.setInvisible(writer, "nursState13");        
        break;

    // �@�u�v���S�v�̏ꍇ
    case 24:
	    //�u�����v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState1");
	    //�u�o�ߓI�v���v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState11");
	    //�u�v���P�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState21");
	    //�u�v���Q�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState22");
	    //�u�v���R�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState23");
	    //�u�v���T�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState25");
        //��v�x��1��̃V�F�C�v���\���ɂ���B
        ACChotarouXMLUtilities.setInvisible(writer, "nursState12");
        //��v�x��2��̃V�F�C�v���\���ɂ���B
        ACChotarouXMLUtilities.setInvisible(writer, "nursState13");        
        break;
        
    // �@�u�v���T�v�̏ꍇ
    case 25:
    	//�u�����v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState1");
	    //�u�o�ߓI�v���v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState11");
	    //�u�v���P�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState21");
	    //�u�v���Q�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState22");
	    //�u�v���R�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState23");
	    //�u�v���S�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState24");
        //��v�x��1��̃V�F�C�v���\���ɂ���B
        ACChotarouXMLUtilities.setInvisible(writer, "nursState12");
        //��v�x��2��̃V�F�C�v���\���ɂ���B
        ACChotarouXMLUtilities.setInvisible(writer, "nursState13");        
        break;
        
    default:
//    	//�u�����v�̃V�F�C�v���\���ɂ���B
//	    ACChotarouXMLUtilities.setInvisible(writer, "nursState1");
	    //�u�o�ߓI�v���v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState11");
	    //�u�v���P�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState21");
	    //�u�v���Q�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState22");
	    //�u�v���R�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState23");
	    //�u�v���S�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState24");
	    //�u�v���T�v�̃V�F�C�v���\���ɂ���B
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState25");
        //��v�x��1��̃V�F�C�v���\���ɂ���B
        ACChotarouXMLUtilities.setInvisible(writer, "nursState12");
        //��v�x��2��̃V�F�C�v���\���ɂ���B
        ACChotarouXMLUtilities.setInvisible(writer, "nursState13");        
        break;

    }
    
    // ���p�ҏZ����ݒ肷��B
    ACChotarouXMLUtilities.setValue(writer, printParameters, "PATIENT_ADDRESS", "patient.address.value");
    // �n��p�����[�^printParam��KEY:PRINT_CALENDAR_LEFT_MONTH��VALUE���擾����B
    Date leftDate = (Date)printParameters.getData("PRINT_CALENDAR_LEFT_MONTH");
    // �擾�����l���uggge�NM���v(�a��)�̌`���ɂ���B
    VRDateFormat vf = new VRDateFormat("ggge�NM��");
    
    String strLeftDate = vf.format(leftDate);    
    
    // �K���(��)�N����ݒ肷��B
    //     setValue(visitDateLeft);
    ACChotarouXMLUtilities.setValue(writer,"visitDateLeft",strLeftDate);

    // �n��p�����[�^printParam��KEY:PRINT_CALENDAR_RIGHT_MONTH��VALUE���擾����B
    Date rightDate = (Date)printParameters.getData("PRINT_CALENDAR_RIGHT_MONTH");
    // �擾�����l���uggge�NM���v(�a��)�̌`���ɂ���B
    String strRighrDate = vf.format(rightDate);
    // �K���(�E)�N����ݒ肷��B   
    ACChotarouXMLUtilities.setValue(writer,"visitDateRight",strRighrDate);       
    
    int maxLeftDay = ACDateUtilities.getDayOfMonth(ACDateUtilities.toLastDayOfMonth(leftDate));
    
    switch (maxLeftDay) {
	case 28:
	    // �@�@�@28���̏ꍇ
	    // �@�@�@�@28���p�̓��t�R���{�̕\���ݒ���s���B
		 ACChotarouXMLUtilities.setValue(writer,"calendarLeft.h5.w1","");
		 ACChotarouXMLUtilities.setValue(writer,"calendarLeft.h5.w2","");
		 ACChotarouXMLUtilities.setValue(writer,"calendarLeft.h5.w3","");

		break;
    
	case 29:
	    // �@�@�@29���̏ꍇ
	    // �@�@�@�@29���p�̓��t�R���{�̕\���ݒ���s���B		
		 ACChotarouXMLUtilities.setValue(writer,"calendarLeft.h5.w2","");
		 ACChotarouXMLUtilities.setValue(writer,"calendarLeft.h5.w3","");
		 
		 break;
	case 30:
	    // �@�@�@30���̏ꍇ
	    // �@�@�@�@30���p�̓��t�R���{�̕\���ݒ���s���B
		 ACChotarouXMLUtilities.setValue	(writer,"calendarLeft.h5.w3","");

		 break;
	}
    
    int maxRightDay = ACDateUtilities.getDayOfMonth(ACDateUtilities.toLastDayOfMonth(rightDate));
    
    switch (maxRightDay) {
	case 28:
	    // �@�@�@28���̏ꍇ
	    // �@�@�@�@28���p�̓��t�O���b�h�̕\���ݒ���s���B
		 ACChotarouXMLUtilities.setValue(writer,"calendarRight.h5.w1","");
		 ACChotarouXMLUtilities.setValue(writer,"calendarRight.h5.w2","");
		 ACChotarouXMLUtilities.setValue(writer,"calendarRight.h5.w3","");

		 break;
    
	case 29:
	    // �@�@�@29���̏ꍇ
	    // �@�@�@�@29���p�̓��t�O���b�h�̕\���ݒ���s���B		
		 ACChotarouXMLUtilities.setValue(writer,"calendarRight.h5.w2","");
		 ACChotarouXMLUtilities.setValue(writer,"calendarRight.h5.w3","");


		 break;
	case 30:
	    // �@�@�@30���̏ꍇ
	    // �@�@�@�@30���p�̓��t�O���b�h�̕\���ݒ���s���B
		 ACChotarouXMLUtilities.setValue(writer,"calendarRight.h5.w3","");

		 break;
	}
    
    
    
    java.util.Iterator it = printCalendar.entrySet().iterator();
	 //String��KEY�����i�[����ϐ�
	 String strKey = "";
	 
	 //
	 
	 while(it.hasNext()){
		 //�L�[�����擾
		 Map.Entry key = (Map.Entry)it.next();
		 //KEY��String�^�Ŋi�[
		 strKey = String.valueOf(key.getKey());
		 
		 int intKey = 0;
		 //�l���󔒂�������null�������ꍇ�͏����l��ݒ肷��
		 if(key.getValue()=="" || key.getValue() == null){
			 intKey = 1;
		 }else{
			 //���݂�KEY���̒l���擾
			 intKey = Integer.parseInt(String.valueOf(key.getValue()));
		 }

		 //�O���b�h�̍s�����i�[����ϐ�
		 String gridRow = "";
		 //���t�̓��ɓ����镔���𐔒l�Ƃ��Ď擾����
		 int dayCount = 0;
		 //�v�Z�p�̒l���i�[����ϐ�
		 int calcIndex = 0;
		 //�J�����_�[�̎�ނ��i�[����
		 String type = "";
		 
		 if(strKey.indexOf("CALENDAR_LEFT_D") == 0){
			 //KEY��������t�̓����擾
			 dayCount = Integer.parseInt(strKey.substring(17,strKey.length()));
			 //�J�����_�[���ł���ꍇ
			 type = "Left";
			 
		 }else if(strKey.indexOf("CALENDAR_RIGHT_D") == 0){
			 //KEY��������t�̓����擾
			 dayCount = Integer.parseInt(strKey.substring(18,strKey.length()));
			 //�J�����_�[�i�E�j�ł���ꍇ
			 type = "Right";

		 }
		 	
		 	 //KEY�̓��t��������O���b�h�i�c�j�����肷��
			 if(dayCount<8){
				 gridRow = "h1";
				 calcIndex = 0;
			 }else if(dayCount<15){
				 gridRow = "h2";
				 calcIndex = 1;
			 }else if(dayCount<22){
				 gridRow = "h3";
				 calcIndex = 2;
			 }else if(dayCount<29){
				 gridRow = "h4";
				 calcIndex = 3;
			 }else{
				 gridRow = "h5";
				 calcIndex = 4;
			 }
			 
			 //�O���b�h�̈ʒu���i�[����ϐ�
			 int gridCol = 0;
			 
			 //����o�����O���b�h����Z���̈ʒu������o��
			 if(calcIndex == 0){
				 gridCol = dayCount;
			 }else{
				 gridCol = dayCount - (7 * calcIndex);
			 }
			 
			 switch(intKey){
			 case 1:
				 ACChotarouXMLUtilities.setValue(writer,"calendar" + type + "Circle." + gridRow + ".w" + gridCol,"");
				 break;
                 
			 //�K����ł���ꍇ�@��
			 case 2:
				 ACChotarouXMLUtilities.setValue(writer,"calendar" + type + "Circle." + gridRow + ".w" + gridCol,"��");
				break;
                
			 //���ʎw���ɂ��K��ł���ꍇ�@��
			 case 3:
				 ACChotarouXMLUtilities.setValue(writer,"calendar" + type + "Circle." + gridRow + ".w" + gridCol,"��");
				 break;
                 
		     //�ً}���K��ł���ꍇ�@�~
			 case 4:
				 ACChotarouXMLUtilities.setValue(writer,"calendar" + type + "Circle." + gridRow + ".w" + gridCol,"�~");			 
				 break;
                 
			 //1����2��ȏ�̖K��ł���ꍇ�@��
			 case 5:
				 ACChotarouXMLUtilities.setValue(writer,"calendar" + type + "Circle." + gridRow + ".w" + gridCol,"��");
				 break;
			 }
				 
		 	
			 

			 
	 }
	 //060323�ύX
	 // �a��̌o�߂�ݒ肷��B
     // �a���ݒ肷��B
     String byojoStateComment = (String) VRBindPathParser.get("BYOJO_STATE",
             printParameters);
     // �擾�������l���S�Q�������Ƃ�
     String[] strByojoStateComment = ACTextUtilities.separateLineWrapOnByte(
             byojoStateComment, 84);

     List listByojoStateComment = Arrays.asList(strByojoStateComment);
     // ������
     StringBuffer sb = new StringBuffer();

     for (int i = 0; i < listByojoStateComment.size(); i++) {
         sb.append(listByojoStateComment.get(i));
         // �ŏI�s�ł���ꍇ�͒ǉ����Ȃ�
         if (i != listByojoStateComment.size() - 1) {
             //���s�R�[�h�ǉ�
             sb.append(ACConstants.LINE_SEPARATOR);
         }
     }
    ACChotarouXMLUtilities.setValue(writer, "patient.byojoComments.value",sb.toString());
    
    //060323�ύX
    // �Ō�E���n�r���e�[�V�����̓��e��ݒ肷��B
    String kangoRiha = (String) VRBindPathParser.get("KANGO_REHA_NAIYO",
            printParameters);
    // �擾�������l���S�Q�������Ƃ�
    String[] strKangoRiha = ACTextUtilities.separateLineWrapOnByte(
            kangoRiha, 84);

    List listKangoRiha = Arrays.asList(strKangoRiha);
    // ������
    sb = new StringBuffer();

    for (int i = 0; i < listKangoRiha.size(); i++) {
        sb.append(listKangoRiha.get(i));
        // �ŏI�s�ł���ꍇ�͒ǉ����Ȃ�
        if (i != listKangoRiha.size() - 1) {
            //���s�R�[�h�ǉ�
            sb.append(ACConstants.LINE_SEPARATOR);
        }
    }
    
    ACChotarouXMLUtilities.setValue(writer,"patient.kangoRehaComments.value",sb.toString());
    //060323�ύX
    // �ƒ�ł̗×{�E���̏󋵂�ݒ肷��B
    String ryoyouKaigo = (String) VRBindPathParser.get("RYOYO_KAIGO_STATE",
            printParameters);
    // �擾�������l���S�Q�������Ƃ�
    String[] strRyoyouKaigo = ACTextUtilities.separateLineWrapOnByte(
            ryoyouKaigo, 84);

    List listRyoyouKaigo = Arrays.asList(strRyoyouKaigo);
    // ������
    sb = new StringBuffer();

    for (int i = 0; i < listRyoyouKaigo.size(); i++) {
        sb.append(listRyoyouKaigo.get(i));
        // �ŏI�s�ł���ꍇ�͒ǉ����Ȃ�
        if (i != listRyoyouKaigo.size() - 1) {
            //���s�R�[�h�ǉ�
            sb.append(ACConstants.LINE_SEPARATOR);
        }
    }
    
    ACChotarouXMLUtilities.setValue(writer,"patient.ryoyoStateComments.value" ,sb.toString());
    
    //060323�ύX
    // ���L���ׂ�������ݒ肷��B
    String reportComment = (String) VRBindPathParser.get("REPORT_COMMENT",
            printParameters);
    // �擾�������l��48�������Ƃ�
    String[] strReportComment = ACTextUtilities.separateLineWrapOnByte(
            reportComment, 96);

    List listReportComment = Arrays.asList(strReportComment);
    // ������
    sb = new StringBuffer();

    for (int i = 0; i < listReportComment.size(); i++) {
        sb.append(listReportComment.get(i));
        // �ŏI�s�ł���ꍇ�͒ǉ����Ȃ�
        if (i != listReportComment.size() - 1) {
            //���s�R�[�h�ǉ�
            sb.append(ACConstants.LINE_SEPARATOR);
        }
    }
    ACChotarouXMLUtilities.setValue(writer,"patient.specialComments.header",sb.toString());
    
    // �n��p�����[�^printParam��KEY:CREATE_DATE��VALUE���擾����B
    Date createDate = (Date)printParameters.getData("CREATE_DATE");
    // �擾�����l���uggge�NM��d���v(�a��)�ɕϊ�����B
    VRDateFormat fr = new VRDateFormat("ggge�NM��d��");
    
    String strCreateDate = fr.format(createDate);
    
    // �쐬�N������ݒ肷��B
    ACChotarouXMLUtilities.setValue(writer,"createDate", strCreateDate);
    // �X�e�[�V��������ݒ肷��B
    ACChotarouXMLUtilities.setValue(writer, printParameters, "PROVIDER_NAME", "station.stationName.value");
    // �Ǘ��Ҏ�����ݒ肷��B
    ACChotarouXMLUtilities.setValue(writer, printParameters, "ADMINISTRATOR_NAME", "station.administratorName.value");
    // �厡�㎁����ݒ肷��B
    ACChotarouXMLUtilities.setValue(writer, printParameters, "DOCTOR_NAME", "doctor.doctorName.value");

    //�y�[�W�I��
    writer.endPageEdit();
    //TODO ��������s�����Ȃ��true��Ԃ��B
  
	    return true;
  	}   

  
  }
