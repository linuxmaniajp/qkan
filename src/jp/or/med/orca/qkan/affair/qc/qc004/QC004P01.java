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
 * �J����: ����@��F
 * �쐬��: 2006/01/16  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���[�Ǘ� (C)
 * �v���Z�X �K��Ō�L�^���T (004)
 * �v���O���� �K��Ō�L�^���T NO.1 (QC00401)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qc.qc004;

import java.beans.FeatureDescriptor;
import java.util.Date;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanSystemInformation;

/**
 * �K��Ō�L�^���T NO.1(QC00401) ���[��`�̃t�@�C���� �F QC00401.xml
 */
public class QC004P01 extends QC004P01Event {
	/**
	 * �R���X�g���N�^�ł��B
	 */
	public QC004P01() {
	}

	/**
	 * ���[�𐶐����܂��B
	 * 
	 * @param writer
	 *            ����Ǘ��N���X
	 * @param printParam
	 *            ����p�����^
	 * @throws Exception
	 *             ������O
	 */
	public boolean doPrint(ACChotarouXMLWriter writer, VRMap printParam) throws Exception {

		// �K�v�ł���Β��[ID�����������邱�ƁB
		ACChotarouXMLUtilities.addFormat(writer, "QC004P01", "QC004P01.xml");

		// �y�[�W�J�n
		writer.beginPageEdit("QC004P01");

		// �����̐�����������patientFullName�Ɋi�[����B
		// toFullName(PATIENT_FAMILY_NAME, PATIENT_FIRST_NAME);
		// String patientFullName = QkanCommon.toFullName(String.valueOf(printParam.getData("PATIENT_FAMILY_NAME")), String.valueOf(printParam.getData("PATIENT_FIRST_NAME")));

		// ���Ҏ�����ݒ肷��B
		// setValue(kirokushoGrid1(w2.h1), patientFullName);
		ACChotarouXMLUtilities.setValue(writer, printParam, "PATIENT_NAME", "kirokushoGrid1.h1.w2");

		// PATIENT_SEX�̒l���`�F�b�N����B
		if (printParam.getData("PATIENT_SEX").equals(new Integer(MALE))) {
			// �l��1�������ꍇ
			// ���̃V�F�C�v���\���ɂ���B
			ACChotarouXMLUtilities.setInvisible(writer, "patientSex2");
		} else if(printParam.getData("PATIENT_SEX").equals(new Integer(FEMALE))) {

			// �l��2�������ꍇ
			// �j�̃V�F�C�v���\���ɂ���B
			ACChotarouXMLUtilities.setInvisible(writer, "patientSex1");
		}else {
			ACChotarouXMLUtilities.setInvisible(writer, "patientSex1");
			ACChotarouXMLUtilities.setInvisible(writer, "patientSex2");
		}

		// �n��p�����[�^�[�FPATIENT_BIRTHDAY���擾����B
		// patientBirthday(String�^�j��PATIENT_BIRRHDAY�� �uggge�NM��d���v �̏����ŕϊ����i�[����B
		Date patientBirthday = ACCastUtilities.toDate(printParam.getData("PATIENT_BIRTHDAY"));

		// patientBirthday����uggg�i�����j�v�����o���ApatientBirthdayReki�Ɋi�[����B
		String patientBirthdayReki = ACDateUtilities.getEraFull(patientBirthday);

		// patientBirthday����ue�i�N�j�v�����o���ApatientBirthdayYear�Ɋi�[����B
		Integer patientBirthdayYear = new Integer(ACDateUtilities.getEraYear(patientBirthday));

		// patientBirthday����uM�i���j�v�����o���ApatientBirthdayMonth�Ɋi�[����B
		Integer patientBirthdayMonth = new Integer(ACDateUtilities.getMonth(patientBirthday));

		// patientBirthday����ud�i���j�v�����o���ApatientBirthdayDay�Ɋi�[����B
		Integer patientBirthdayDay = new Integer(ACDateUtilities.getDayOfMonth(patientBirthday));

		// �V�X�e�����t���擾���A�ϐ�systemDate�Ɋi�[����B
		Date systemDate = QkanSystemInformation.getInstance().getSystemDate();

		// �N����擾���A�ϐ�patientAge�Ɋi�[����B
		Integer patientAge = new Integer(QkanCommon.calcAge(patientBirthday, systemDate));

		// ������ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, "kirokushoGrid1.h1.w13", patientBirthdayReki);

		// ���t�i�N�j��ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, "kirokushoGrid1.h1.w12", patientBirthdayYear);

		// ���t�i���j��ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, "kirokushoGrid1.h1.w10", patientBirthdayMonth);

		// ���t�i���j��ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, "kirokushoGrid1.h1.w8", patientBirthdayDay);

		// �N���ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, "kirokushoGrid1.h1.w6", patientAge);

		// �Z����ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "PATIENT_ADDRESS", "patientAddress");

		// PATIENT_TEL_FIRST�̒l���`�F�b�N����B
		// �󔒂������ꍇ
		// PATIENT_TEL_SECOND�̒l���`�F�b�N����B
		// �󔒂������ꍇ
		// PATIENT_TEL_THIRD�̒l���`�F�b�N����B
		// �󔒂������ꍇ
		// �����𔲂���B
		// �󔒂ł͂Ȃ������ꍇ
		// �������ցB
		// �󔒂ł͂Ȃ������ꍇ
		// �������ցB
		// �󔒂ł͂Ȃ������ꍇ
		// �������ցB
		// �d�b�ԍ����������A�ϐ�patientTel�Ɋi�[����B
		// toTel(PATIENT_TEL_FIRST, PATIENT_TEL_SECOND, PATIENT_TEL_THIRD);
		String patientTel = QkanCommon.toTel(String.valueOf(printParam.getData("PATIENT_TEL_FIRST")), String.valueOf(printParam.getData("PATIENT_TEL_SECOND")), String.valueOf(printParam.getData("PATIENT_TEL_THIRD")));

		// ���������d�b�ԍ���ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, "kirokushoGrid1.h2.w13", patientTel);

		// �Ō�t������ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "NURSE_NAME", "kirokushoGrid2.h1.w2");

		// �ϐ�firstVisitDate(String�^�j�𐶐�����B

		// kirokushoMap��KEY�FFIRST_VISIT_DATE��VALUE���`�F�b�N����B
		if (!ACTextUtilities.isNullText(printParam.getData("FIRST_VISIT_DATE"))) {
			// VALUE���󕶎��ł͂Ȃ������ꍇ
			// �擾�����l�� gge�NM��d���iE�j �̌`���ɕϊ�����B
			// VALUE��firstVisitDate�Ɋi�[����B
			// firstVisitDate�̒l��ݒ肷��B
			Date visitDate = ACCastUtilities.toDate(printParam.getData("FIRST_VISIT_DATE"));
			String firstVisitDate = VRDateParser.format(visitDate, "gggee�NMM��dd��");
			firstVisitDate += "�i" + ACDateUtilities.getDayOfWeekShort(visitDate) + "�j";
			ACChotarouXMLUtilities.setValue(writer, "firstVisitDate", firstVisitDate);
		}

		// KEY�FFIRST_VISIT_DATE_START��VALUE���`�F�b�N����B
		if (ACTextUtilities.isNullText(printParam.getData("FIRST_VISIT_DATE_START"))) {
			// �󔒂������ꍇ
			// �u�`�ifirstVisitDateFrom�j�v���\���ɂ���B
			ACChotarouXMLUtilities.setInvisible(writer, "firstVisitDateFrom");

		} else {
			// �󔒂ł͂Ȃ������ꍇ
			// firstVisitDateStart�̒l��ݒ肷��B
			String firstVisitDateStart = VRDateParser.format(ACCastUtilities.toDate(printParam.getData("FIRST_VISIT_DATE_START")), "HH��mm��");
			ACChotarouXMLUtilities.setValue(writer, "firstVisitDateStart", firstVisitDateStart);

			// KEY�FFIRST_VISIT_DATE_END��VALUE���F�b�N����B
			if (ACTextUtilities.isNullText(printParam.getData("FIRST_VISIT_DATE_END"))) {
				// �󔒂������ꍇ
				// �u�`�ifirstVisitDateFrom�j�v���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "firstVisitDateFrom");
			} else {
				// �󔒂ł͂Ȃ������ꍇ
				// firstVisitDateEnd�̒l��ݒ肷��B
				String firstVisitDateEnd = VRDateParser.format(ACCastUtilities.toDate(printParam.getData("FIRST_VISIT_DATE_END")), "HH��mm��");
				ACChotarouXMLUtilities.setValue(writer, "firstVisitDateEnd", firstVisitDateEnd);
			}
		}

		// ���L�̏����ŁA�傽�鏝�a����ݒ肷��B
		// �E1�s�Ɉ�����镶�����́A�S�p37�����Ƃ���B
		// �E���s����4�s�Ƃ���B
		ACChotarouXMLUtilities.setTextOfLineWrapOnByte(writer, printParam, "DISEASE", "kirokushoGrid2.h3.w2", 74);

		// ���L�̏����ŁA�a��E���Ï�ԓ���ݒ肷��B
		// �E1�s�Ɉ�����镶�����́A�S�p37�����Ƃ���B
		// �E���s����8�s�Ƃ���B
		ACChotarouXMLUtilities.setTextOfLineWrapOnByte(writer, printParam, "BYOJO_CHIYU_JOTAI", "kirokushoGrid2.h4.w2", 74);
		
		// ���L�̏����ŁA���a����ݒ肷��B
		// �E1�s�Ɉ�����镶�����́A�S�p37�����Ƃ���B
		// �E���s����7�s�Ƃ���B
		ACChotarouXMLUtilities.setTextOfLineWrapOnByte(writer, printParam, "GENBYOREKI", "kirokushoGrid2.h5.w2", 74);
		
		// ���L�̏����ŁA��������ݒ肷��B
		// �E1�s�Ɉ�����镶�����́A�S�p37�����Ƃ���B
		// �E���s����7�s�Ƃ���B
		ACChotarouXMLUtilities.setTextOfLineWrapOnByte(writer, printParam, "KIOREKI", "kirokushoGrid2.h6.w2", 74);

		// ���L�̏����ŁA��������ݒ肷��B
		// �E1�s�Ɉ�����镶�����́A�S�p37�����Ƃ���B
		// �E���s����7�s�Ƃ���B
		ACChotarouXMLUtilities.setTextOfLineWrapOnByte(writer, printParam, "SEIKATSUREKI", "kirokushoGrid2.h7.w2", 74);

		// �Ƒ��\��1 ������ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_NAME1", "kirokushoGrid3.h2.w2");

		// �Ƒ��\��1 �N���ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_AGE1", "kirokushoGrid3.h2.w3");

		// �Ƒ��\��1 ������ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_RELATION1", "kirokushoGrid3.h2.w4");

		// �Ƒ��\��1 �E�Ƃ�ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_JOB1", "kirokushoGrid3.h2.w5");

		// �Ƒ��\��1 ���L���ׂ�������ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_COMMENT1", "kirokushoGrid3.h2.w6");

		// �Ƒ��\��2 ������ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_NAME2", "kirokushoGrid3.h3.w2");

		// �Ƒ��\��2 �N���ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_AGE2", "kirokushoGrid3.h3.w3");

		// �Ƒ��\��2 ������ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_RELATION2", "kirokushoGrid3.h3.w4");

		// �Ƒ��\��2 �E�Ƃ�ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_JOB2", "kirokushoGrid3.h3.w5");

		// �Ƒ��\��2 ���L���ׂ�������ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_COMMENT2", "kirokushoGrid3.h3.w6");

		// �Ƒ��\��3 ������ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_NAME3", "kirokushoGrid3.h4.w2");

		// �Ƒ��\��3 �N���ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_AGE3", "kirokushoGrid3.h4.w3");

		// �Ƒ��\��3 ������ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_RELATION3", "kirokushoGrid3.h4.w4");

		// �Ƒ��\��3 �E�Ƃ�ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_JOB3", "kirokushoGrid3.h4.w5");

		// �Ƒ��\��3 ���L���ׂ�������ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_COMMENT3", "kirokushoGrid3.h4.w6");

		// �Ƒ��\��4 ������ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_NAME4", "kirokushoGrid3.h5.w2");

		// �Ƒ��\��4 �N���ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_AGE4", "kirokushoGrid3.h5.w3");

		// �Ƒ��\��4 ������ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_RELATION4", "kirokushoGrid3.h5.w4");

		// �Ƒ��\��4 �E�Ƃ�ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_JOB4", "kirokushoGrid3.h5.w5");

		// �Ƒ��\��4 ���L���ׂ�������ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_COMMENT4", "kirokushoGrid3.h5.w6");

		// �Ƒ��\��5 ������ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_NAME5", "kirokushoGrid3.h6.w2");

		// �Ƒ��\��5 �N���ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_AGE5", "kirokushoGrid3.h6.w3");

		// �Ƒ��\��5 ������ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_RELATION5", "kirokushoGrid3.h6.w4");

		// �Ƒ��\��5 �E�Ƃ�ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_JOB5", "kirokushoGrid3.h6.w5");

		// �Ƒ��\��5 ���L���ׂ�������ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_COMMENT5", "kirokushoGrid3.h6.w6");

		// �Ƒ��\��6 ������ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_NAME6", "kirokushoGrid3.h7.w2");

		// �Ƒ��\��6 �N���ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_AGE6", "kirokushoGrid3.h7.w3");

		// �Ƒ��\��6 ������ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_RELATION6", "kirokushoGrid3.h7.w4");

		// �Ƒ��\��6 �E�Ƃ�ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_JOB6", "kirokushoGrid3.h7.w5");

		// �Ƒ��\��6 ���L���ׂ�������ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_COMMENT6", "kirokushoGrid3.h7.w6");

		// ���L�̏����ŁA��ȉ��҂�ݒ肷��B
		// 1�s�Ɉ�����镶�����͑S�p37�����Ƃ���B
		// ���s����3�s�Ƃ���B
		ACChotarouXMLUtilities.setTextOfLineWrapOnByte(writer, printParam, "CAREGIVER", "kirokushoGrid4.h1.w2", 74);
		
		// ���L�̏����ŁA�Z����ݒ肷��B
		// 1�s�Ɉ�����镶�����͑S�p37�����Ƃ���B
		// ���s����4�s�Ƃ���B
		ACChotarouXMLUtilities.setTextOfLineWrapOnByte(writer, printParam, "HOUSE", "kirokushoGrid4.h2.w2", 74);

		// �y�[�W�I��
		writer.endPageEdit();
		return true;
	}

}
