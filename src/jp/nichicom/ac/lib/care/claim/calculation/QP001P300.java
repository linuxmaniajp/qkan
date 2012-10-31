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
 * �J����: ���{�@�K��
 * �쐬��: 2010/11/08  ���{�R���s���[�^�[������� ���{�@�K�� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���� (P)
 * �v���Z�X ���p�҈ꗗ (001)
 * �v���O���� ���p�҈ꗗ (QP001P083)
 *
 *****************************************************************
 */
package jp.nichicom.ac.lib.care.claim.calculation;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Iterator;

import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.text.QkanClaimStyleFormat;
import jp.or.med.orca.qkan.text.QkanJotaiCodeFormat;

/**
 * ���p�҈ꗗ ���[��`�̃t�@�C���� �F QP001P300.xml
 */
public class QP001P300 extends QP001PrintEvent {
	/**
	 * �R���X�g���N�^�ł��B
	 */
	public QP001P300() {
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
		ACChotarouXMLUtilities.addFormat(writer, "QP001P300", "QP001P300.xml");
		// �y�[�W�J�n
		writer.beginPageEdit("QP001P300");
		
		// ����p���i�[�p��VRArrayList printArray���`����B
		// printArray�ɁA�n��p�����[�^�� KEY : PARAM �� VALUE ��ݒ肷��B
		// ���ȉ��AprintArray�Ɋi�[����Ă��郌�R�[�h���Q�Ƃ���B
		// ���݂̓��t���擾����B(�V�X�e�����t�ł͂Ȃ�)
		// ���t(�a��)�̔N��ݒ肷��B
		// ���t�̌���ݒ肷��B
		// ���t�̓���ݒ肷��B
		setPageHeader(writer, printParam);

		// LIST
		VRList list = (VRList) VRBindPathParser.get("LIST", printParam);
		Iterator it = list.iterator();

		VRMap row = null;
		int rowCount = 1;
		
		while (it.hasNext()) {
			
			// �ł�����̈��������22���ɂȂ�A�������͑S�Ă̗��p�҂��������܂Ń��[�v����B
			if (23 <= rowCount) {
				// ���y�[�W����
				// ��U�y�[�W���m��
				writer.endPageEdit();
				//�V�����y�[�W���J�n
				//[ID:0000735][Shin Fujihara] 2012/05 edit begin �ꗗ����G���[�Ή�
				//writer.beginPageEdit("QP001P083");
				writer.beginPageEdit("QP001P300");
				//[ID:0000735][Shin Fujihara] 2012/05 edit end �ꗗ����G���[�Ή�
				
				// �ϐ��������E������ݒ�
				rowCount = 1;
				setPageHeader(writer, printParam);
			}
			
			
			// ������闘�p�ҏ��(1����)���AVRHashMap patientMap�ɑޔ�����B
			row = (VRMap) it.next();
			
			// �񋟔N����ݒ肷��B
			// setValue(patients.provideDate.h*, (patientMap��PROVIDER_DATE));
			ACChotarouXMLUtilities.setValue(writer, getCol(rowCount, "provideDate"), getYMJp(VRBindPathParser.get("TARGET_DATE", row)));

			// �l����ݒ肷��B
			// setValue(patients.style.h*, (patientMap��STYLE));
			ACChotarouXMLUtilities.setValue(writer, getCol(rowCount, "style"), getStyleName(VRBindPathParser.get("CLAIM_STYLE_TYPE", row)));

			// �ی��Ҕԍ���ݒ肷��B
			// setValue(patients.insurerNo.h*, (patientMap��INSURER_NO));
			ACChotarouXMLUtilities.setValue(writer, getCol(rowCount, "insurerNo"), VRBindPathParser.get("INSURER_ID", row));

			// ��ی��Ҕԍ���ݒ肷��B
			// setValue(patients.underInsurerNo.h*, (patientMap��UNDER_INSURER_NO));
			ACChotarouXMLUtilities.setValue(writer, getCol(rowCount, "underInsurerNo"), VRBindPathParser.get("INSURED_ID", row));

			// ���p�Ҏ�����ݒ肷��B
			// setValue(patients.name.h*, (patientMap��NAME));
			ACChotarouXMLUtilities.setValue(writer, getCol(rowCount, "name"), VRBindPathParser.get("PATIENT_NAME", row));

			// ���ʂ�ݒ肷��B
			// setValue(patients.sex.h*, (patientMap��SEX));
			ACChotarouXMLUtilities.setValue(writer, getCol(rowCount, "sex"), getSex(VRBindPathParser.get("PATIENT_SEX", row)));

			// �N���ݒ肷��B
			// setValue(patients.age.h*, (patientMap��AGE));
			ACChotarouXMLUtilities.setValue(writer, getCol(rowCount, "age"), getAge(VRBindPathParser.get("PATIENT_BIRTHDAY", row)));

			// �v���x��ݒ肷��B
			// setValue(patients.yokaigodo.h*, (patientMap��YOKAIGODO));
			ACChotarouXMLUtilities.setValue(writer, getCol(rowCount, "yokaigodo"), getJotai(VRBindPathParser.get("JOTAI_CODE", row)));

			// �v��P�ʂ�ݒ肷��B
			// setValue(patients.planUnit.h*, (patientMap��PLAN_UNIT));
			ACChotarouXMLUtilities.setValue(writer, getCol(rowCount, "planUnit"), getNum(VRBindPathParser.get("PLAN_RATE", row)));

			// �T�[�r�X�P�ʂ�ݒ肷��B
			// setValue(patients.serviceUnit.h*, (patientMap��SERVICE_UNIT));
			ACChotarouXMLUtilities.setValue(writer, getCol(rowCount, "serviceUnit"), getNum(VRBindPathParser.get("SERVICE_UNIT", row)));

			// �T�[�r�X���v���z��ݒ肷��B
			// setValue(patients.serviceTotalAmount.h*, (patientMap��SERVICE_TOTAL_AMOUNT));
			ACChotarouXMLUtilities.setValue(writer, getCol(rowCount, "serviceTotalAmount"), getNum(VRBindPathParser.get("SERVICE_TOTAL", row)));

			// �ی������z��ݒ肷��B
			// setValue(patients.insurerChargeAmount.h*, (patientMap��INSURER_CHARGE_AMOUNT));
			ACChotarouXMLUtilities.setValue(writer, getCol(rowCount, "insurerChargeAmount"), getNum(VRBindPathParser.get("HOKEN", row)));

			// ����S�z��ݒ肷��B
			// setValue(patients.publicExpenseAmount.h*, (patientMap��PUBLIC_EXPENSE_AMOUNT));
			ACChotarouXMLUtilities.setValue(writer, getCol(rowCount, "publicExpenseAmount"), getNum(VRBindPathParser.get("KOUHI", row)));

			// ���p�ҕ��S�z��ݒ肷��B
			// setValue(patients.patientChargeAmount.h*, (patientMap��PATIENT_CHARGE_AMOUNT));
			ACChotarouXMLUtilities.setValue(writer, getCol(rowCount, "patientChargeAmount"), getNum(VRBindPathParser.get("RIYOUSYA", row)));
			
			rowCount++;

		}
		
		// �y�[�W�I��
		writer.endPageEdit();
		
		// ��������s�����Ȃ��true��Ԃ��B
		return true;
	}
	
	// �񖼁E����s�ԍ�����ʒu���̂��쐬����
	private String getCol(int rowCount, String ColName) {
		return "patients.h" + rowCount + "." + ColName;
	}
	
	// �a��N���ɕϊ�
	private String getYMJp(Object date) throws Exception {
		return VRDateParser.format((Date)date,"ggge�NMM��");
	}
	
	// �l���ԍ�����l�����̂ɕϊ�
	private String getStyleName(Object style) {
		return QkanClaimStyleFormat.getInstance().format(style);
	}
	
	// �R�[�h���琫�ʖ��̂ɕϊ�
	private String getSex(Object sex) {
		return QkanConstants.FORMAT_SEX.format(sex);
	}
	
	// ���N��������N��ɕϊ�
	private String getAge(Object birthday) {
		return QkanConstants.FORMAT_NOW_AGE.format(birthday) + "��";
	}
	
	// ��ԃR�[�h����v���x���̂ɕϊ�
	private String getJotai(Object code) {
		return QkanJotaiCodeFormat.getInstance().format(code);
	}
	
	// ���l���J���}��؂�̃t�H�[�}�b�g�ɕϊ�
	private String getNum(Object num) {
		return NumberFormat.getInstance().format(num);
	}
	
	//�S�Ẵy�[�W�ŋ��ʂ̗̈���󎚂���
	private void setPageHeader(ACChotarouXMLWriter writer, VRMap printParam) throws Exception {
		//�����
		ACChotarouXMLUtilities.setValue(writer, "Date", VRBindPathParser.get("DATE", printParam));
		
		//���v�P�ʐ�
		ACChotarouXMLUtilities.setValue(writer, "total.h1.w2", VRBindPathParser.get("SERVICE_UNIT", printParam));
		//���v���z
		ACChotarouXMLUtilities.setValue(writer, "total.h1.w4", VRBindPathParser.get("SERVICE_TOTAL", printParam));
		//�ی������z
		ACChotarouXMLUtilities.setValue(writer, "total.h2.w2", VRBindPathParser.get("HOKEN", printParam));
		//���v����
		ACChotarouXMLUtilities.setValue(writer, "total.h2.w4", VRBindPathParser.get("SERVICE_COUNT", printParam));
		//���p�����z
		ACChotarouXMLUtilities.setValue(writer, "total.h3.w2", VRBindPathParser.get("RIYOUSYA", printParam));
		//������z
		ACChotarouXMLUtilities.setValue(writer, "total.h3.w4", VRBindPathParser.get("KOUHI", printParam));
	}

}
