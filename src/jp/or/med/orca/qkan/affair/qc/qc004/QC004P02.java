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
 * �v���O���� �K��Ō�L�^���T NO.2 (QC00402)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qc.qc004;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;

/**
 * �K��Ō�L�^���T NO.2(QC00402) ���[��`�̃t�@�C���� �F QC00402.xml
 */
public class QC004P02 extends QC004P02Event {
	/**
	 * �R���X�g���N�^�ł��B
	 */
	public QC004P02() {
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
		ACChotarouXMLUtilities.addFormat(writer, "QC004P02", "QC004P02.xml");
		// �y�[�W�J�n
		writer.beginPageEdit("QC004P02");
		// ���L�̏����ŁA���p�ҁE�Ƒ��̈˗��ړI��ݒ肷��B
		ACChotarouXMLUtilities.setTextOfLineWrapOnByte(writer, printParam, "PURPOSE", "purpose", 74);
		// 1�s�Ɉ�����镶�����͑S�p37�����Ƃ���B
		// ���s����6�s�Ƃ���B

		// �n��p�����[�^�[�FADL_MOVE�̒l���`�F�b�N����B
		// setValue("kirokushoGrid1.h1.w2", patientFullName);
		switch (ACCastUtilities.toInt(printParam.getData("ADL_MOVE"))) {
			case 1:
				// �l��1�������ꍇ
				// adlMove2���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlMove2");
				// adlMove3���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlMove3");
				// adlMove4���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlMove4");
				break;

			case 2:
				// �l��2�������ꍇ
				// adlMove1���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlMove1");
				// adlMove3���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlMove3");
				// adlMove4���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlMove4");
				break;

			case 3:
				// �l��3�������ꍇ
				// adlMove1���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlMove1");
				// adlMove2���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlMove2");
				// adlMove4���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlMove4");
				break;

			case 4:
				// �l��4�������ꍇ
				// adlMove1���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlMove1");
				// adlMove2���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlMove2");
				// adlMove3���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlMove3");
				break;

			default:
				// �l��0�������͂��̑��������ꍇ
				// adlMove1���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlMove1");
				// adlMove2���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlMove2");
				// adlMove3���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlMove3");
				// adlMove4���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlMove4");
				break;
		}

		// �n��p�����[�^�[�FADL_FOOD�̒l���`�F�b�N����B
		switch (ACCastUtilities.toInt(printParam.getData("ADL_FOOD"))) {
			case 1:
				// �l��1�������ꍇ
				// adlFood2���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlFood2");
				// adlFood3���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlFood3");
				// adlFood4���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlFood4");
				break;

			case 2:
				// �l��2�������ꍇ
				// adlFood1���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlFood1");
				// adlFood3���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlFood3");
				// adlFood4���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlFood4");
				break;

			case 3:
				// �l��3�������ꍇ
				// adlFood1���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlFood1");
				// adlFood2���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlFood2");
				// adlFood4���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlFood4");
				break;

			case 4:
				// �l��4�������ꍇ
				// adlFood1���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlFood1");
				// adlFood2���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlFood2");
				// adlFood3���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlFood3");
				break;

			default:
				// �l��0�������͂��̑��������ꍇ
				// adlFood1���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlFood1");
				// adlFood2���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlFood2");
				// adlFood3���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlFood3");
				// adlFood4���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlFood4");
				break;
		}

		// �n��p�����[�^�[�FADL_EXCRETION�̒l���`�F�b�N����B
		switch (ACCastUtilities.toInt(printParam.getData("ADL_EXCRETION"))) {
			case 1:
				// �l��1�������ꍇ
				// adlExcretion2���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion2");
				// adlExcretion3���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion3");
				// adlExcretion4���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion4");
				break;

			case 2:
				// �l��2�������ꍇ
				// adlExcretion1���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion1");
				// adlExcretion3���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion3");
				// adlExcretion4���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion4");
				break;

			case 3:
				// �l��3�������ꍇ
				// adlExcretion1���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion1");
				// adlExcretion2���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion2");
				// adlExcretion4���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion4");
				break;

			case 4:
				// �l��4�������ꍇ
				// adlExcretion1���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion1");
				// adlExcretion2���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion2");
				// adlExcretion3���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion3");
				break;

			default:
				// �l��0�������͂��̑��������ꍇ
				// adlExcretion1���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion1");
				// adlExcretion2���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion2");
				// adlExcretion3���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion3");
				// adlExcretion4���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion4");
				break;
		}

		// �n��p�����[�^�[�FADL_BATH�̒l���`�F�b�N����B
		switch (ACCastUtilities.toInt(printParam.getData("ADL_BATH"))) {
			case 1:
				// �l��1�������ꍇ
				// adlBath2���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlBath2");
				// adlBath3���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlBath3");
				// adlBath4���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlBath4");
				break;

			case 2:
				// �l��2�������ꍇ
				// adlBath1���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlBath1");
				// adlBath3���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlBath3");
				// adlBath4���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlBath4");
				break;

			case 3:
				// �l��3�������ꍇ
				// adlBath1���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlBath1");
				// adlBath2���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlBath2");
				// adlBath4���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlBath4");
				break;

			case 4:
				// �l��4�������ꍇ
				// adlBath1���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlBath1");
				// adlBath2���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlBath2");
				// adlChangeCloth3���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlBath3");
				break;

			default:
				// �l��0�������͂��̑��������ꍇ
				// adlBath1���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlBath1");
				// adlBath2���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlBath2");
				// adlChangeCloth3���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlBath3");
				// adlChangeCloth4���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlBath4");
				break;
		}

		// �n��p�����[�^�[�FADL_CHANGE_CLOTH�̒l���`�F�b�N����B
		switch (ACCastUtilities.toInt(printParam.getData("ADL_CHANGE_CLOTH"))) {
			case 1:
				// �l��1�������ꍇ
				// adlChangeClothes2���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlChangeClothes2");
				// adlChangeClothes3���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlChangeClothes3");
				// adlChangeClothes4���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlChangeClothes4");
				break;

			case 2:
				// �l��2�������ꍇ
				// adlChangeClothes1���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlChangeClothes1");
				// adlChangeClothes3���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlChangeClothes3");
				// adlChangeClothes4���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlChangeClothes4");
				break;

			case 3:
				// �l��3�������ꍇ
				// adlChangeClothes1���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlChangeClothes1");
				// adlChangeClothes2���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlChangeClothes2");
				// adlChangeClothes4���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlChangeClothes4");
				break;

			case 4:
				// �l��4�������ꍇ
				// adlChangeClothes1���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlChangeClothes1");
				// adlChangeClothes2���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlChangeClothes2");
				// adlChangeClothes3���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlChangeClothes3");
				break;

			default:
				// �l��0�������͂��̑��������ꍇ
				// adlChangeClothes1���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlChangeClothes1");
				// adlChangeClothes2���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlChangeClothes2");
				// adlChangeClothes3���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlChangeClothes3");
				// adlChangeClothes4���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlChangeClothes4");
				break;
		}

		// �n��p�����[�^�[�FADL_COSMETIC�̒l���`�F�b�N����B
		switch (ACCastUtilities.toInt(printParam.getData("ADL_COSMETIC"))) {
			case 1:
				// �l��1�������ꍇ
				// adCosmetic2���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adCosmetic2");
				// adCosmetic3���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adCosmetic3");
				// adCosmetic4���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adCosmetic4");
				break;

			case 2:
				// �l��2�������ꍇ
				// adCosmetic1���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adCosmetic1");
				// adCosmetic3���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adCosmetic3");
				// adCosmetic4���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adCosmetic4");
				break;

			case 3:
				// �l��3�������ꍇ
				// adCosmetic1���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adCosmetic1");
				// adCosmetic2���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adCosmetic2");
				// adCosmetic4���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adCosmetic4");
				break;

			case 4:
				// �l��4�������ꍇ
				// adCosmetic1���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adCosmetic1");
				// adCosmetic2���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adCosmetic2");
				// adCosmetic3���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adCosmetic3");
				break;

			default:
				// �l��0�������͂��̑��������ꍇ
				// adCosmetic1���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adCosmetic1");
				// adCosmetic2���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adCosmetic2");
				// adCosmetic3���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adCosmetic3");
				// adCosmetic4���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adCosmetic4");

				break;
		}

		// �n��p�����[�^�[�FADL_COMMUNICATION�̒l���`�F�b�N����B
		switch (ACCastUtilities.toInt(printParam.getData("ADL_COMMUNICATION"))) {
			case 1:
				// �l��1�������ꍇ
				// adlCommunication2���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlCommunication2");
				// adlCommunication3���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlCommunication3");
				// adlCommunication4���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlCommunication4");
				break;

			case 2:
				// �l��2�������ꍇ
				// adlCommunication1���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlCommunication1");
				// adlCommunication3���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlCommunication3");
				// adlCommunication4���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlCommunication4");
				break;

			case 3:
				// �l��3�������ꍇ
				// adlCommunication1���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlCommunication1");
				// adlCommunication2���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlCommunication2");
				// adlCommunication4���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlCommunication4");
				break;

			case 4:
				// �l��4�������ꍇ
				// adlCommunication1���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlCommunication1");
				// adlCommunication2���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlCommunication2");
				// adlCommunication3���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlCommunication3");
				break;

			default:
				// �l��0�������͂��̑��������ꍇ
				// adlCommunication1���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlCommunication1");
				// adlCommunication2���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlCommunication2");
				// adlCommunication3���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlCommunication3");
				// adlCommunication4���\���ɂ���B
				ACChotarouXMLUtilities.setInvisible(writer, "adlCommunication4");
				break;
		}

		// �厡�㎁����ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "DOCTOR_NAME", "doctorName");
		// �厡���Ë@�ւ�ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "MEDICAL_FACILITY_NAME", "providerName");
		// �厡�㏊�ݒn��ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "MEDICAL_FACILITY_ADDRESS", "providerAdderess");

		// PROVIDER_TEL_FIRST�̒l���`�F�b�N����B
		// �󔒂������ꍇ
		// PROVIDER_TEL_SECOND�̒l���`�F�b�N����B
		// �󔒂������ꍇ
		// PROVIDER_TEL_THIRD�̒l���`�F�b�N����B
		// �󔒂������ꍇ
		// �����𔲂���B�i�d�b�ԍ����󎚂��Ȃ��j
		// �󔒂ł͂Ȃ������ꍇ
		// �������ցB
		// �󔒂ł͂Ȃ������ꍇ
		// �������ցB
		// �󔒂ł͂Ȃ������ꍇ
		// �������ցB
		// �d�b�ԍ���������providerTel�Ɋi�[����B
		// toTel(PROVIDER_TEL_FIRST, PROVIDER_TEL_SECOND, PROVIDER_TEL_THIRD);
		// �d�b�ԍ���ݒ肷��B
		// setValue(providerTel, providerTel);

		String providerTel = QkanCommon.toTel(String.valueOf(printParam.getData("MEDICAL_FACILITY_TEL_FIRST")), String.valueOf(printParam.getData("MEDICAL_FACILITY_TEL_SECOND")), String.valueOf(printParam.getData("MEDICAL_FACILITY_TEL_THIRD")));

		// ���������d�b�ԍ���ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, "providerTel", providerTel);

		// ���L�̏����ŁA�ً}���̘A�����@��ݒ肷��B
		ACChotarouXMLUtilities.setTextOfLineWrapOnByte(writer, printParam, "DOCTOR_RENRAKUSAKI", "doctorRenrakusaki", 92);
		// 1�s�Ɉ�����镶�����͑S�p46�����Ƃ���B
		// �ő�o�͍s����8�s�Ƃ���B

		// �֌W�@��1 �A�����ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "MEDICAL_RENRAKUSAKI1", "kirokushoGrid4.h2.w2");
		// �֌W�@��1 �S���҂�ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "MEDICAL_PREPARED1", "kirokushoGrid4.h2.w3");
		// �֌W�@��1 ���l��ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "MEDICAL_NOTE1", "kirokushoGrid4.h2.w4");
		// �֌W�@��2 �A�����ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "MEDICAL_RENRAKUSAKI2", "kirokushoGrid4.h3.w2");
		// �֌W�@��2 �S���҂�ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "MEDICAL_PREPARED2", "kirokushoGrid4.h3.w3");
		// �֌W�@��2 ���l��ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "MEDICAL_NOTE2", "kirokushoGrid4.h3.w4");
		// �֌W�@��3 �A�����ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "MEDICAL_RENRAKUSAKI3", "kirokushoGrid4.h4.w2");
		// �֌W�@��3 �S���҂�ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "MEDICAL_PREPARED3", "kirokushoGrid4.h4.w3");
		// �֌W�@��3 ���l��ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "MEDICAL_NOTE3", "kirokushoGrid4.h4.w4");
		// �֌W�@��4 �A�����ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "MEDICAL_RENRAKUSAKI4", "kirokushoGrid4.h5.w2");
		// �֌W�@��4 �S���҂�ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "MEDICAL_PREPARED4", "kirokushoGrid4.h5.w3");
		// �֌W�@��4 ���l��ݒ肷��B
		ACChotarouXMLUtilities.setValue(writer, printParam, "MEDICAL_NOTE4", "kirokushoGrid4.h5.w4");

		// ���L�̏����ŁA�����E�ی��T�[�r�X���̗��p�󋵂�ݒ肷��B
		// 1�s�Ɉ�����镶�����͑S�p46�����Ƃ���B
		// �ő�o�͍s����6�s�Ƃ���B
		ACChotarouXMLUtilities.setTextOfLineWrapOnByte(writer, printParam, "USED_STATE", "UsedState", 92);
		
		// �y�[�W�I��
		writer.endPageEdit();
		return true;
	}

}
