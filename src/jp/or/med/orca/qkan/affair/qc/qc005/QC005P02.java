
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
 * �쐬��: 2006/03/25  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���[�Ǘ� (C)
 * �v���Z�X ����×{�Ǘ��w���� (005)
 * �v���O���� ����×{�Ǘ��w���� (QC005P02)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qc.qc005;
import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;

/**
 * ����×{�Ǘ��w����(QC005P02) 
 * ���[��`�̃t�@�C���� �F QC00502.xml
 */
public class QC005P02 extends QC005P02Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QC005P02(){
  }

  /**
   * ���[�𐶐����܂��B
   * @param writer ����Ǘ��N���X
   * @param printParam ����p�����^
   * @throws Exception ������O
   */
  public boolean doPrint(ACChotarouXMLWriter writer, VRMap printParam) throws Exception {
    //�K�v�ł���Β��[ID�����������邱�ƁB
    ACChotarouXMLUtilities.addFormat(writer, "QC005P02", "QC005P02.xml");
    //�y�[�W�J�n
    writer.beginPageEdit("QC005P02");
    
    // ��������ݒ肷��B
    ACChotarouXMLUtilities.setValue(writer, "createDate.h.gengou",
                ACCastUtilities.toString(ACDateUtilities
                        .getEraFull(ACCastUtilities.toDate(VRBindPathParser
                                .get("CREATE_DATE_KYOTAKU", printParam)))));
    
    // ���쐬�N�����̐ݒ�    
    // �@�n��p�����[�^���� KEY : CREATE_DATE_KYOTAKU �� VALUE ���擾����B(���t�^)
    // �@�쐬�N�����̘a��̔N��ݒ肷��B
    //     setValue(createDate.year.h, (�a��̔N));
    ACChotarouXMLUtilities.setValue(writer, "createDate.h.year", String
            .valueOf(ACDateUtilities.getEraYear(
                    ACCastUtilities.toDate(VRBindPathParser.get(
                            "CREATE_DATE_KYOTAKU", printParam)))));

    // �@�쐬�N�����̌���ݒ肷��B
    //     setValue(createDate.month.h, (��));
    ACChotarouXMLUtilities.setValue(writer, "createDate.h.month", String
            .valueOf(ACDateUtilities.getMonth(
                    ACCastUtilities.toDate(VRBindPathParser.get(
                            "CREATE_DATE_KYOTAKU", printParam)))));

    // �@�쐬�N�����̓���ݒ肷��B
    //     setValue(createDate.day.h, (��));
    ACChotarouXMLUtilities.setValue(writer, "createDate.h.day", String
            .valueOf(ACDateUtilities.getDayOfMonth(
                    ACCastUtilities.toDate(VRBindPathParser.get(
                            "CREATE_DATE_KYOTAKU", printParam)))));

    // ���x��������ݒ肷��B
    ACChotarouXMLUtilities.setValue(writer, printParam, "SENMONIN", "senmonin");
    // ��Ë@�֖���ݒ肷��B
    ACChotarouXMLUtilities.setValue(writer, printParam, "MEDICAL_FACILITY_NAME", "medicalFacilityName");
    // ��Ë@�֏Z����ݒ肷��B
    ACChotarouXMLUtilities.setValue(writer, printParam, "MEDICAL_FACILITY_ADDRESS", "medicalFacilityAddress");
    // ��Ë@�֘A�����ݒ肷��B
    // ��Ë@�֓d�b�ԍ�����������
    // ��Ë@�֓d�b�ԍ���ݒ肷��B
    String medicalTel = QkanCommon.toTel(VRBindPathParser.get(
                "MEDICAL_FACILITY_TEL_FIRST", printParam), VRBindPathParser
                .get("MEDICAL_FACILITY_TEL_SECOND", printParam),
                VRBindPathParser.get("MEDICAL_FACILITY_TEL_THIRD", printParam));
    //     setValue(medicalFacilityTel);
    ACChotarouXMLUtilities.setValue(writer,"medicalFacilityTel",medicalTel);
    
    // ��Ë@�ֈ�t������ݒ肷��B
    ACChotarouXMLUtilities.setValue(writer, printParam, "DOCTOR_NAME", "doctorName");
    // ���Ə�����ݒ肷��B
    ACChotarouXMLUtilities.setValue(writer, printParam, "PROVIDER_NAME", "providerName");
    // ���p�Ҏ�����ݒ肷��B
    ACChotarouXMLUtilities.setValue(writer, printParam, "PATIENT_NAME", "patientName");
    
    // ���p�Ґ��ʂ�ݒ肷��B
    if (ACCastUtilities.toInt(VRBindPathParser.get("PATIENT_SEX",
            printParam)) == 1) {
        ACChotarouXMLUtilities.setInvisible(writer, "patientSex2");
    } else if(ACCastUtilities.toInt(VRBindPathParser.get("PATIENT_SEX",
            printParam)) == 2){
        ACChotarouXMLUtilities.setInvisible(writer, "patientSex1");
    }else{
        //��\���ɂ���B
        ACChotarouXMLUtilities.setInvisible(writer, "patientSex1");
        ACChotarouXMLUtilities.setInvisible(writer, "patientSex2");
    }
    // �����p�Ґ��N�����̐ݒ�
        // �n��p�����[�^���� KEY : PATIENT_BIRTHDAY �� VALUE ���擾����B(���t�^)
        // �擾�������t�̔N�����擾����B
        // �u�����v�̏ꍇ
        if (ACDateUtilities.getEraFull(
                ACCastUtilities.toDate(VRBindPathParser.get("PATIENT_BIRTHDAY",
                        printParam))).equals("����")) {
            // �u�吳�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth2");
            // �u���a�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth3");
        } else if (ACDateUtilities.getEraFull(
                ACCastUtilities.toDate(VRBindPathParser.get("PATIENT_BIRTHDAY",
                        printParam))).equals("�吳")) {
            // �u�吳�v�̏ꍇ
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth1");
            // �u���a�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth3");
        } else if (ACDateUtilities.getEraFull(
                ACCastUtilities.toDate(VRBindPathParser.get("PATIENT_BIRTHDAY",
                        printParam))).equals("���a")) {
            // �u���a�v�̏ꍇ
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth1");
            // �u�吳�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth2");
        } else {
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth1");
            // �u�吳�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth2");
            // �u���a�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth3");
        }
        // ���N�����̘a��̔N��ݒ肷��B
        // setValue(patientBirth.year.h);
        ACChotarouXMLUtilities.setValue(writer, "patientBirth.h.year", String
                .valueOf(ACDateUtilities.getEraYear(
                        ACCastUtilities.toDate(VRBindPathParser.get(
                                "PATIENT_BIRTHDAY", printParam)))));

        // ���N�����̌���ݒ肷��B
        // setValue(patientBirth.month.h);
        ACChotarouXMLUtilities.setValue(writer, "patientBirth.h.month", String
                .valueOf(ACDateUtilities.getMonth(
                        ACCastUtilities.toDate(VRBindPathParser.get(
                                "PATIENT_BIRTHDAY", printParam)))));

        // ���N�����̓���ݒ肷��B
        // setValue(patientBirth.day.h);
        ACChotarouXMLUtilities.setValue(writer, "patientBirth.h.day", String
                .valueOf(ACDateUtilities.getDayOfMonth(
                        ACCastUtilities.toDate(VRBindPathParser.get(
                                "PATIENT_BIRTHDAY", printParam)))));

    // ���v���x�̐ݒ�
    // �@�n��p�����[�^���� KEY : JOTAI_CODE �� VALUE ���擾����B(����)
    // �@�擾������������`�F�b�N����B
        switch (ACCastUtilities.toInt(VRBindPathParser.get("JOTAI_CODE",
                printParam))) {
        case 12:
            // �u�v�x��1�v�̏ꍇ
            // �u�v�x���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode13");
            // �u�o�ߓI�v���v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode11");
            // �u�v���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode21");
            // �u�v���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode22");
            // �u�v���R�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode23");
            // �u�v���S�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode24");
            // �u�v���T�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode25");
            break;
        case 13:
            // �u�v�x��2�v�̏ꍇ
            // �u�v�x��1�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode12");
            // �u�o�ߓI�v���v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode11");
            // �u�v���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode21");
            // �u�v���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode22");
            // �u�v���R�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode23");
            // �u�v���S�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode24");
            // �u�v���T�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode25");
            break;
        case 11:
            // �u�o�ߓI�v���v�̏ꍇ
            // �u�v�x���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode12");
            // �u�v�x���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode13");
            // �u�v���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode21");
            // �u�v���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode22");
            // �u�v���R�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode23");
            // �u�v���S�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode24");
            // �u�v���T�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode25");
            break;
        case 21:
            // �u�v���P�v�̏ꍇ
            // �u�v�x���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode12");
            // �u�v�x���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode13");
            // �u�o�ߓI�v���v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode11");
            // �u�v���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode22");
            // �u�v���R�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode23");
            // �u�v���S�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode24");
            // �u�v���T�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode25");
            break;
        case 22:
            // �u�v���Q�v�̏ꍇ
            // �u�v�x���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode12");
            // �u�v�x���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode13");
            // �u�o�ߓI�v���v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode11");
            // �u�v���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode21");
            // �u�v���R�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode23");
            // �u�v���S�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode24");
            // �u�v���T�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode25");
            break;
        case 23:
            // �u�v���R�v�̏ꍇ
            // �u�v�x���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode12");
            // �u�v�x���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode13");
            // �u�o�ߓI�v���v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode11");
            // �u�v���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode21");
            // �u�v���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode22");
            // �u�v���S�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode24");
            // �u�v���T�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode25");
            break;
        case 24:
            // �u�v���S�v�̏ꍇ
            // �u�v�x���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode12");
            // �u�v�x���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode13");
            // �u�o�ߓI�v���v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode11");
            // �u�v���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode21");
            // �u�v���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode22");
            // �u�v���R�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode23");
            // �u�v���T�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode25");
            break;
        case 25:
            // �u�v���T�v�̏ꍇ
            // �u�v�x���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode12");
            // �u�v�x���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode13");
            // �u�o�ߓI�v���v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode11");
            // �u�v���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode21");
            // �u�v���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode22");
            // �u�v���R�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode23");
            // �u�v���S�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode24");
            break;
        case 1:
            // �u�����v�̏ꍇ
            // �u�v�x���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode12");
            // �u�v�x���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode13");
            // �u�o�ߓI�v���v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode11");
            // �u�v���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode21");
            // �u�v���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode22");
            // �u�v���R�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode23");
            // �u�v���S�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode24");
            // �u�v���T�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode25");
            break;
        }
    // ����Q�V�l���퐶�������x�̐ݒ�
        // �n��p�����[�^���� KEY : SHOGAI_JIRITSUDO �� VALUE ���擾����B(���l)
        // �擾�����l���`�F�b�N����B
        switch (ACCastUtilities.toInt(VRBindPathParser.get("SHOGAI_JIRITSUDO",
                printParam))) {
        case 1:
            // 1�̏ꍇ
            // �u�i�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo2");
            // �u�`�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo3");
            // �uB�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo4");
            // �uC�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo5");
            break;
        case 2:
            // 2�̏ꍇ
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo1");
            // �u�`�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo3");
            // �uB�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo4");
            // �uC�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo5");
            break;
        case 3:
            // 3�̏ꍇ
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo1");
            // �u�i�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo2");
            // �u�a�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo4");
            // �uC�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo5");
            break;
        case 4:
            // 4�̏ꍇ
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo1");
            // �u�i�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo2");
            // �u�`�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo3");
            // �uC�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo5");
            break;
        case 5:
            // 5�̏ꍇ
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo1");
            // �u�i�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo2");
            // �u�`�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo3");
            // �uB�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo4");
            break;
        case 0:
            // 0�̏ꍇ
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo1");
            // �u�i�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo2");
            // �u�`�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo3");
            // �uB�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo4");
            // �uC�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo5");
            break;
        }
    // ���F�m�ǘV�l���퐶�������x�̐ݒ�
        // �n��p�����[�^���� KEY : NINCHISHO_JIRITSUDO �� VALUE ���擾����B(���l)
        // �擾�����l���`�F�b�N����B
        switch (ACCastUtilities.toInt(VRBindPathParser.get(
                "NINCHISHO_JIRITSUDO", printParam))) {
        case 1:
            // 1�̏ꍇ
            // �uI�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo2");
            // �uII�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo3");
            // �uIII�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo4");
            // �uIV�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo5");
            // �uM�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo6");
            break;
        case 2:
            // 2�̏ꍇ
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo1");
            // �uII�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo3");
            // �uIII�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo4");
            // �uIV�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo5");
            // �uM�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo6");
            break;
        case 3:
            // 3�̏ꍇ
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo1");
            // �uI�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo2");
            // �uIII�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo4");
            // �uIV�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo5");
            // �uM�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo6");
            break;
        case 4:
            // 4�̏ꍇ
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo1");
            // �uI�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo2");
            // �uIII�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo3");
            // �uIV�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo5");
            // �uM�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo6");
            break;
        case 5:
            // 5�̏ꍇ
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo1");
            // �uI�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo2");
            // �uII�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo3");
            // �uIII�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo4");
            // �uM�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo6");
            break;
        case 6:
            // 6�̏ꍇ
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo1");
            // �uI�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo2");
            // �uII�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo3");
            // �uIII�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo4");
            // �uIV�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo5");
            break;
        case 0:
            // 0�̏ꍇ
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo1");
            // �uI�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo2");
            // �uII�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo3");
            // �uIII�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo4");
            // �uIV�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo5");
            // �u�l�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo6");
            break;
        }
        
        String[] slCharacter = ACTextUtilities.separateLineWrapOnByte(
                ACCastUtilities.toString(VRBindPathParser.get(
                        "PATIENT_ADDRESS", printParam)), 80);
    // ���p�ҏZ����ݒ肷��
    // ���p�ҏZ����45�����P�ʂŕ�������
    // ���p�ҏZ����ݒ肷��(45�������j
    //     setValue(patientAddress1);
    // ���p�ҏZ����ݒ肷��(�c��45�����j
    //     setValue(patientAddress2);
        if(slCharacter != null){
            int end=Math.min(slCharacter.length, 2);
            for(int i = 0; i < end; i++){
                int index = i + 1;
                ACChotarouXMLUtilities.setValue(writer,"patientAddress"+index ,slCharacter[i]);
            }
        }
    // ���p�ҘA�����ݒ肷��B
    // ���p�ғd�b�ԍ�����������
    // ���������d�b�ԍ���ݒ肷��B
        String patientTel = QkanCommon.toTel(VRBindPathParser.get(
                "PATIENT_TEL_FIRST", printParam), VRBindPathParser
                .get("PATIENT_TEL_SECOND", printParam),
                VRBindPathParser.get("PATIENT_TEL_THIRD", printParam));
    //     setValue(medicalFacilityTel);
    ACChotarouXMLUtilities.setValue(writer,"patientTel",patientTel);
    //     setValue(patientTel);

    // ���a��̐ݒ�
    // �@�n��p�����[�^���� KEY : CONDITION�@�� VALUE ���擾����B(������j
    // �@�a���45�����i�X�O�o�C�g�j�ŕ�������
    // �@�a���ݒ肷��B
    //     setValue(CONDITION);
    ACChotarouXMLUtilities.setTextOfLineWrapOnByte(writer, printParam,
                "CONDITION", "condition", 90);

    // ���a��o�ߓ��̐ݒ�
    // �@�n��p�����[�^���� KEY : CONDITION_PASSAGE �� VALUE ���擾����B(������j
    // �@�a��o�߂�45�����i�X�O�o�C�g�j�ŕ�������
    // �@�a��o�ߓ���ݒ肷��B
    //     setValue(CONDITION_PASSAGE);
    ACChotarouXMLUtilities.setTextOfLineWrapOnByte(writer, printParam,
            "CONDITION_PASSAGE", "conditionPassage", 90);
    // �����T�[�r�X�𗘗p�����ł̗��ӓ_�E�����@���̐ݒ�
    // �@�n��p�����[�^���� KEY : NOTE_OF_KAIGO_SERVICE �� VALUE ���擾����B(������j
    // �@���T�[�r�X�𗘗p�����ł̗��ӓ_�E�����@����45�����i�X�O�o�C�g�j�ŕ�������
    // �@���T�[�r�X�𗘗p�����ł̗��ӓ_�E�����@����ݒ肷��B
    //     setValue(NOTE_OF_KAIGO_SERVICE);
    ACChotarouXMLUtilities.setTextOfLineWrapOnByte(writer, printParam,
            "NOTE_OF_KAIGO_SERVICE", "noteOfKaigoService", 90);
    // �����p�҂̓��퐶����̗��ӓ_�̐ݒ�
    // �@�n��p�����[�^���� KEY : NOTE_OF_DAILY_LIFE �� VALUE ���擾����B(������j
    // �@���p�҂̓��퐶����̗��ӓ_��45�����i�X�O�o�C�g�j�ŕ�������
    // �@���p�҂̓��퐶����̗��ӓ_��ݒ肷��B
    //     setValue(NOTE_OF_DAILY_LIFE);
    ACChotarouXMLUtilities.setTextOfLineWrapOnByte(writer, printParam,
            "NOTE_OF_DAILY_LIFE", "noteOfDailyLife", 90);
    // �����l�̐ݒ�
    // �@�n��p�����[�^���� KEY : REMARKS �� VALUE ���擾����B(������j
    // �@���l��45�����i�X�O�o�C�g�j�ŕ�������
    // �@���l�̗��ӓ_��ݒ肷��B
    //     setValue(REMARKS);
    ACChotarouXMLUtilities.setTextOfLineWrapOnByte(writer, printParam,
            "REMARKS", "remarks", 90);
    //�y�[�W�I��
    writer.endPageEdit();
    //TODO ��������s�����Ȃ��true��Ԃ��B
    return true;
  }
  
  /**
   * �w�肳�ꂽ�������ŉ��s�����������Ԃ��܂��B
   * @param chr ���s�ΏۂƂȂ镶����
   * @param byteIndex ���s��o�C�g��
   * @return ���s������}������������
   */
  public String getInsertionLineSeparatorToStringOnByte(String chr, int byteIndex){
      String[] slCharacter = ACTextUtilities.separateLineWrapOnByte(chr,byteIndex);
      
      StringBuilder sbCharacter = new StringBuilder();

      for (int i = 0; i < slCharacter.length; i++) {
          sbCharacter.append(slCharacter[i]);
          //�ŏI�s�ł���ꍇ�͉��s�R�[�h��ǉ����Ȃ�
          if (i != slCharacter.length - 1) {
              //���s�R�[�h��ǉ�����
              sbCharacter.append(ACConstants.LINE_SEPARATOR);
          }
      }

      String insertionLineSeparatorString = sbCharacter.toString();
      
      return insertionLineSeparatorString;
  }
  

}
