
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
 * �쐬��: 2005/12/16  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���[�Ǘ� (C)
 * �v���Z�X �ݑ�×{�����̃|�C���g (005)
 * �v���O���� �ݑ�×{�����̃|�C���g (QC00501)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qc.qc005;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;

/**
 * �ݑ�×{�����̃|�C���g(QC00501) 
 * ���[��`�̃t�@�C���� �F QC00501.xml
 */
public class QC005P01 extends QC005P01Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QC005P01(){
  }

  /**
   * ���[�𐶐����܂��B
   * @param writer ����Ǘ��N���X
   * @param printParam ����p�����^
   * @throws Exception ������O
   */
  public boolean doPrint(ACChotarouXMLWriter writer, VRMap printParam) throws Exception {
    //TODO ���[ID��K�v�ɉ�����"mainFormat"����K�؂Ȃ��̂ɏ��������邱�ƁB
    ACChotarouXMLUtilities.addFormat(writer, "QC005P01", "QC005P01.xml");
    //�y�[�W�J�n
    writer.beginPageEdit("QC005P01");
    // ���쐬�N����ݒ肷��B
    // �@�n��p�����[�^��KEY : CREATE_DATE_ZAITAKU �� VALUE ���擾����B(���t�^)   
    // �@�@�擾�������t�̘a��̔N��ݒ肷��B
    //     setValue(createDate.year.h);
    ACChotarouXMLUtilities.setValue(writer, "createDate.h.year",String.valueOf(
    		ACDateUtilities.getEraYear(ACCastUtilities.toDate(
    				VRBindPathParser.get("CREATE_DATE_ZAITAKU",printParam)))));

    // �@�@�擾�������t�̌���ݒ肷��B
    //     setValue(createDate.month.h);
    ACChotarouXMLUtilities.setValue(writer, "createDate.h.w3",String.valueOf(
    		ACDateUtilities.getMonth(ACCastUtilities.toDate(
    				VRBindPathParser.get("CREATE_DATE_ZAITAKU",printParam)))));
    
    // �u���Ȃ��̎厡��́A���A�����ł��B�v��ݒ肷��B
    ACChotarouXMLUtilities.setValue(writer, printParam, "DOCTOR_NAME", "yourDoctor");
    // �������̖K���(6��)�̐ݒ�
    // �@�u�����̖K����v�i�[�p�̃��R�[�h�z�� visitThisMonthArray�𐶐�����B
    // �@�ȉ��̏�����n��p�����[�^ VISIT_THIS_MONTH_NO1 ���� VISIT_THIS_MONTH_NO6 ��6���J��Ԃ��B
    // �@�@�n��p�����[�^ KEY : VISIT_THIS_MONTH_NO* �� VALUE���`�F�b�N����B
    // �@�@�@�l�����݂���ꍇ
    if(!ACTextUtilities.isNullText(VRBindPathParser.get("VISIT_THIS_MONTH_NO1",printParam))){
    // �@�@�@�@visitThisMonthArray�� KEY : VISIT_THIS_MONTH_NO* �� VALUE��ݒ肷��B
        // �@visitThisMonthArray�̌������J��Ԃ��B
        // �@�@�u�����̖K����v�� n���ڂ�visitThisMonthArray�� n�ڂ̒l��ݒ肷��B
        //     setValue(visit.day*.this, VISIT_THIS_MONTH_NO*);
        ACChotarouXMLUtilities.setValue(writer, "visit.this.day1"
        		,VRBindPathParser.get("VISIT_THIS_MONTH_NO1",printParam));
    }
    // �@�@�@�l�����݂��Ȃ��ꍇ
    // �@�@�@�@�������Ȃ��B

    // �@�c��́u�����̖K����v�̌����J��Ԃ��B
    if(!ACTextUtilities.isNullText(VRBindPathParser.get("VISIT_THIS_MONTH_NO2",printParam))){
        ACChotarouXMLUtilities.setValue(writer, "visit.this.day2"
        		,VRBindPathParser.get("VISIT_THIS_MONTH_NO2",printParam));     	
    }else{
//    �@�@�u�����̖K����v�� n���ڂ̃L���v�V�����u���v�������B
//      setValue(visit.unit*.this, "");
    	ACChotarouXMLUtilities.setValue(writer, "visit.this.unit2","");
    }
    if(!ACTextUtilities.isNullText(VRBindPathParser.get("VISIT_THIS_MONTH_NO3",printParam))){
        ACChotarouXMLUtilities.setValue(writer, "visit.this.day3"
        		,VRBindPathParser.get("VISIT_THIS_MONTH_NO3",printParam));     	
    }else{
    	ACChotarouXMLUtilities.setValue(writer, "visit.this.unit3","");
    }    
    if(!ACTextUtilities.isNullText(VRBindPathParser.get("VISIT_THIS_MONTH_NO4",printParam))){
        ACChotarouXMLUtilities.setValue(writer, "visit.this.day4"
        		,VRBindPathParser.get("VISIT_THIS_MONTH_NO4",printParam));     	
    }else{
    	ACChotarouXMLUtilities.setValue(writer, "visit.this.unit4","");
    }        
    if(!ACTextUtilities.isNullText(VRBindPathParser.get("VISIT_THIS_MONTH_NO5",printParam))){
        ACChotarouXMLUtilities.setValue(writer, "visit.this.day5"
        		,VRBindPathParser.get("VISIT_THIS_MONTH_NO5",printParam));     	
    }else{
    	ACChotarouXMLUtilities.setValue(writer, "visit.this.unit5","");
    }            
    if(!ACTextUtilities.isNullText(VRBindPathParser.get("VISIT_THIS_MONTH_NO6",printParam))){
        ACChotarouXMLUtilities.setValue(writer, "visit.this.day6"
        		,VRBindPathParser.get("VISIT_THIS_MONTH_NO6",printParam));     	
    }else{
    	ACChotarouXMLUtilities.setValue(writer, "visit.this.unit6","");
    }            
    // �������̖K��\��(6��)�̐ݒ�
    // �@�u�����̖K��\��v�i�[�p�̃��R�[�h�z�� visitNextMonthArray�𐶐�����B
    // �@�ȉ��̏�����n��p�����[�^ VISIT_NEXT_MONTH_NO1 ���� VISIT_NEXT_MONTH_NO6 ��6���J��Ԃ��B
    // �@�@�n��p�����[�^ KEY : VISIT_NEXT_MONTH_NO* �� VALUE���`�F�b�N����B
    // �@�@�@�l�����݂���ꍇ
    if(!ACTextUtilities.isNullText(VRBindPathParser.get("VISIT_NEXT_MONTH_NO1",printParam))){
    // �@�@�@�@visitNextMonthArray�� KEY : VISIT_NEXT_MONTH_NO* �� VALUE��ݒ肷��B
    // �@�@�@�l�����݂��Ȃ��ꍇ
    // �@�@�@�@�������Ȃ��B
    // �@visitNextMonthArray�̌������J��Ԃ��B
    // �@�@�u�����̖K��\��v�� n���ڂ�visitNextMonthArray�� n�ڂ̒l��ݒ肷��B
    //     setValue(visit.day*.next, VISIT_NEXT_MONTH_NO*);
        ACChotarouXMLUtilities.setValue(writer, "visit.next.day1"
        		,VRBindPathParser.get("VISIT_NEXT_MONTH_NO1",printParam));
    }
    
    // �@�c��́u�����̖K��\��v�̌����J��Ԃ��B
    if(!ACTextUtilities.isNullText(VRBindPathParser.get("VISIT_NEXT_MONTH_NO2",printParam))){
        ACChotarouXMLUtilities.setValue(writer, "visit.next.day2"
        		,VRBindPathParser.get("VISIT_NEXT_MONTH_NO2",printParam));     	
    }else{
        // �@�@�u�����̖K��\��v�� n���ڂ̃L���v�V�����u���v�������B
        //     setValue(visit.unit*.next, "");    	
    	ACChotarouXMLUtilities.setValue(writer, "visit.next.unit2","");
    }
    if(!ACTextUtilities.isNullText(VRBindPathParser.get("VISIT_NEXT_MONTH_NO3",printParam))){
        ACChotarouXMLUtilities.setValue(writer, "visit.next.day3"
        		,VRBindPathParser.get("VISIT_NEXT_MONTH_NO3",printParam));     	
    }else{
    	ACChotarouXMLUtilities.setValue(writer, "visit.next.unit3","");
    }
    if(!ACTextUtilities.isNullText(VRBindPathParser.get("VISIT_NEXT_MONTH_NO4",printParam))){
        ACChotarouXMLUtilities.setValue(writer, "visit.next.day4"
        		,VRBindPathParser.get("VISIT_NEXT_MONTH_NO4",printParam));     	
    }else{
    	ACChotarouXMLUtilities.setValue(writer, "visit.next.unit4","");
    }    
    if(!ACTextUtilities.isNullText(VRBindPathParser.get("VISIT_NEXT_MONTH_NO5",printParam))){
        ACChotarouXMLUtilities.setValue(writer, "visit.next.day5"
        		,VRBindPathParser.get("VISIT_NEXT_MONTH_NO5",printParam));     	
    }else{
    	ACChotarouXMLUtilities.setValue(writer, "visit.next.unit5","");
    }    
    if(!ACTextUtilities.isNullText(VRBindPathParser.get("VISIT_NEXT_MONTH_NO6",printParam))){
        ACChotarouXMLUtilities.setValue(writer, "visit.next.day6"
        		,VRBindPathParser.get("VISIT_NEXT_MONTH_NO6",printParam));     	
    }else{
    	ACChotarouXMLUtilities.setValue(writer, "visit.next.unit6","");
    }   
    
    // �����̃A�h�o�C�X��ݒ肷��B
    ACChotarouXMLUtilities.setValue(writer, printParam, "ADVICE_MONTH", "adviceMonth");
    // �A�h�o�C�X�E�{����ݒ肷��B
    ACChotarouXMLUtilities.setTextOfLineWrapOnByte( writer, printParam, "ADVICE", "advice", 96);
//    ACChotarouXMLUtilities.setValue(writer, printParam, "ADVICE", "advice");
    // ��Ë@�֖���ݒ肷��B
    ACChotarouXMLUtilities.setValue(writer, printParam, "MEDICAL_FACILITY_NAME", "medicalInstitusion");
    // �S���㎁����ݒ肷��B
    ACChotarouXMLUtilities.setValue(writer, printParam, "DOCTOR_NAME", "doctorName");
    // �A�����ݒ肷��B
    String medicalTel = QkanCommon.toTel(VRBindPathParser.get(
            "MEDICAL_FACILITY_TEL_FIRST", printParam), VRBindPathParser
            .get("MEDICAL_FACILITY_TEL_SECOND", printParam),
            VRBindPathParser.get("MEDICAL_FACILITY_TEL_THIRD", printParam));
    
    ACChotarouXMLUtilities.setValue(writer,"renrakusaki",medicalTel);

    //���p�Ж���ݒ肷��B
    ACChotarouXMLUtilities.setValue(writer, printParam, "PATIENT_NAME", "patientName");
    
    
    
    //�y�[�W�I��
    writer.endPageEdit();
    //TODO ��������s�����Ȃ��true��Ԃ��B
    return true;
  }

}
