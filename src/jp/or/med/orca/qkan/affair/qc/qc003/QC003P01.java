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
 * �쐬��: 2005/12/19  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���[�Ǘ� (C)
 * �v���Z�X �V�l�K��Ō�E�K��Ō�̏��񋟏� (003)
 * �v���O���� �V�l�K��Ō�E�K��Ō�̏��񋟏� (QC00301)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qc.qc003;

import java.util.Date;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanSystemInformation;

/**
 * �V�l�K��Ō�E�K��Ō�̏��񋟏�(QC00301) ���[��`�̃t�@�C���� �F QC00301.xml
 */
public class QC003P01 extends QC003P01Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QC003P01() {
    }

    /**
     * ���[�𐶐����܂��B
     * 
     * @param writer ����Ǘ��N���X
     * @param printParam ����p�����^
     * @throws Exception ������O
     */
    public boolean doPrint(ACChotarouXMLWriter writer, VRMap printParam)
            throws Exception {
        // TODO ���[ID��K�v�ɉ�����"mainFormat"����K�؂Ȃ��̂ɏ��������邱�ƁB
        ACChotarouXMLUtilities.addFormat(writer, "QC003P01", "QC003P01.xml");
        // �y�[�W�J�n homonkangojohoteikyosho
        writer.beginPageEdit("QC003P01");
        // CREATE_DATE�̔N�̕�����ݒ肷��B
        Date createDate = (Date) printParam.getData("CREATE_DATE");
        // setValue(createDate(w2.h), ���t�i�N�j);
        int eraYear = ACDateUtilities.getEraYear(createDate);
        ACChotarouXMLUtilities.setValue(writer, "createDate.h.w2", new Integer(
                eraYear));
        // CREATE_DATE�̌��̕�����ݒ肷��B
        // setValue(createDate(w4.h), ���t�i���j);
        int month = ACDateUtilities.getMonth(createDate);
        ACChotarouXMLUtilities.setValue(writer, "createDate.h.w4", new Integer(
                month));

        // CREATE_DATE�̓��̕�����ݒ肷��B
        // setValue(createDate�iw6.h�j, ���t�i���j);
        int day = ACDateUtilities.getDayOfMonth(createDate);
        ACChotarouXMLUtilities.setValue(writer, "createDate.h.w6", new Integer(
                day));

        // ���񋟐��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, printParam, "JOHO_TEIKYO_SAKI",
                "johoTeikyoSaki");
        // �K��Ō�X�e�[�V���� ���ݒn��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, printParam, "PROVIDER_ADDRESS",
                "providerAddress");
        // �K��Ō�X�e�[�V���� ���̂�ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, printParam, "PROVIDER_NAME",
                "providerName");

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
        String providerTel = QkanCommon.toTel(ACCastUtilities
                .toString(printParam.getData("PROVIDER_TEL_FIRST")),
                ACCastUtilities.toString(printParam
                        .getData("PROVIDER_TEL_SECOND")), ACCastUtilities
                        .toString(printParam.getData("PROVIDER_TEL_THIRD")));
        // �d�b�ԍ���ݒ肷��B
        // setValue(providerTel, providerTel);
        ACChotarouXMLUtilities.setValue(writer, "providerTel", providerTel);

        // �Ǘ��Ҏ�����ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, printParam,
                "PROVIDER_ADMINISTRATOR", "providerAdministrator");
        // ���p�Ҏ�����ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, printParam,
                "PATIENT_FULL_NAME", "patientInfo1.h1.w6");
        // �n��p�����[�^�[PATIENT_SEX�̒l���`�F�b�N����B
        if (new Integer(1).equals(printParam.getData("PATIENT_SEX"))) {
            // �l��1�������ꍇ
            // �u���v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientSex2");
        } else if(new Integer(2).equals(printParam.getData("PATIENT_SEX"))){
            // �l��2�������ꍇ
            // �u�j�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientSex1");
        }else{
            //��\���ɂ���
            ACChotarouXMLUtilities.setInvisible(writer, "patientSex1");
            ACChotarouXMLUtilities.setInvisible(writer, "patientSex2");
        }

        // ���p�Ґ��N�������擾����
        Date patientBirthDay = (Date) printParam.getData(("PATIENT_BIRTHDAY"));

        // ���p�҂̒a������ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "patientAge", ACCastUtilities
                .toString(QkanCommon.calcAge(patientBirthDay,
                        QkanSystemInformation.getInstance().getSystemDate())));

        String eraFull = ACDateUtilities.getEraFull(patientBirthDay);

        // �N�����u�����v�������ꍇ
        if ("����".equals(eraFull)) {
            // �u�吳�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirthDay2");
            // �u���a�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirthDay3");
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirthDay4");

            // �N�����u�吳�v�������ꍇ
        } else if ("�吳".equals(eraFull)) {
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirthDay1");
            // �u���a�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirthDay3");
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirthDay4");

            // �N�����u���a�v�������ꍇ
        } else if ("���a".equals(eraFull)) {
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirthDay1");
            // �u�吳�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirthDay2");
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirthDay4");

            // �N����������v�������ꍇ
        } else if ("����".equals(eraFull)) {
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirthDay1");
            // �u�吳�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirthDay2");
            // �u���a�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirthDay3");
            
        } else {
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirthDay1");
            // �u�吳�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirthDay2");
            // �u���a�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirthDay3");
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirthDay4");
            
        }

        // �N��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "patientBirthdayYear",
                new Integer(ACDateUtilities.getEraYear(patientBirthDay)));
        // ����ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "patientBirthdayMonth",
                new Integer(ACDateUtilities.getMonth(patientBirthDay)));
        // ����ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "patientBirthdayDay",
                new Integer(ACDateUtilities.getDayOfMonth(patientBirthDay)));
        // ���O�C�����t���擾���A�ϐ��ilogijnDate�j�Ɋi�[����B
        // �N����v�Z���A�ϐ��ipatientAge�j�Ɋi�[����B
        // calcAge(PATIENT_BIRTHDAY, logijnDate);
        int patientAge = QkanCommon.calcAge(patientBirthDay,
                QkanSystemInformation.getInstance().getSystemDate());
        // �v�Z�����l��ݒ肷��B
        // setValue(patientAge, patientAge);
        ACChotarouXMLUtilities.setValue(writer, "patientAge", new Integer(
                patientAge));
        // �E�Ƃ�ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, printParam, "PATIENT_JOB",
                "patientJob");
        // �Z����ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, printParam, "PATIENT_ADDRESS",
                "patientInfo2.h1.w2");
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
        // �d�b�ԍ���������PatientTel�Ɋi�[����B
        // toTel(PATIENT_TEL_FIRST, PATIENT_TEL_SECOND, PATIENT_TEL_THIRD);
        String patientTel = QkanCommon.toTel(ACCastUtilities
                .toString(printParam.getData("PATIENT_TEL_FIRST")),
                ACCastUtilities.toString(printParam
                        .getData("PATIENT_TEL_SECOND")), ACCastUtilities
                        .toString(printParam.getData("PATIENT_TEL_THIRD")));
        // �d�b�ԍ���ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "patientInfo2.h2.w2",
                patientTel);
        // �厡�㎁����ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, printParam, "DOCTOR_NAME",
                "doctorInfo.h1.w2");
        // �厡��Z����ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, printParam, "DOCTOR_ADDRESS",
                "doctorInfo.h2.w2");
        // �叝�a����ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, printParam, "DISEASE",
                "doctorInfo.h3.w2");

        int adlMove = ACCastUtilities.toInt(printParam.getData("ADL_MOVE"));
        // �n��p�����[�^�[ADL_MOVE�̒l���`�F�b�N����B
        switch (adlMove) {
        // �l��1�������ꍇ
        case 1:
            // �u�ꕔ��v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlMove2");
            // �u�S�ʉ����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlMove3");
            // �����I��
            break;

        // �l��2�������ꍇ
        case 2:
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlMove1");
            // �u�S�ʉ�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlMove3");
            // �����I��
            break;

        // �l��3�������ꍇ
        case 3:
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlMove1");
            // �u�ꕔ��v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlMove2");
            // �����I��
            break;

        // ���I����Ԃ������ꍇ
        default:
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlMove1");
            // �u�ꕔ��v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlMove2");
            // �u�S�ʉ�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlMove3");
            // �����I��
            break;

        }

        int adlExcretion = ACCastUtilities.toInt(printParam
                .getData("ADL_EXCRETION"));
        // �n��p���[���[�^�[ADL_EXCRETION�̒l���`�F�b�N����
        switch (adlExcretion) {
        // �l��1�������ꍇ
        case 1:
            // �u�ꕔ��v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion2");
            // �u�S�ʉ����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion3");
            // �����I��
            break;

        case 2:
            // �l��2�������ꍇ
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion1");
            // �u�S�ʉ�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion3");
            // �����I��
            break;

        case 3:
            // �l��3�������ꍇ
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion1");
            // �u�ꕔ��v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion2");
            // �����I��
            break;

        default:
            // �l��3�������ꍇ
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion1");
            // �u�ꕔ��v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion2");
            // �u�S�ʉ�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion3");
            // �����I��
            break;

        }

        int adlChangeCloth = ACCastUtilities.toInt(printParam
                .getData("ADL_CHANGE_CLOTH"));
        // �n��p�����[�^�[ADL_CHANGE_CLOTH�̒l���`�F�b�N����B
        switch (adlChangeCloth) {
        // �l��1�������ꍇ
        case 1:
            // �u�ꕔ��v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlChangeCloth2");
            // �u�S�ʉ����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlChangeCloth3");
            // �����I��
            break;

        // �l��2�������ꍇ
        case 2:
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlChangeCloth1");
            // �u�S�ʉ�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlChangeCloth3");
            // �����I��
            break;

        // �l��3�������ꍇ
        case 3:
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlChangeCloth1");
            // �u�ꕔ��v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlChangeCloth2");
            // �����I��
            break;

        default:
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlChangeCloth1");
            // �u�ꕔ��v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlChangeCloth2");
            // �u�S�ʉ�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlChangeCloth3");
            // �����I��
            break;

        }

        int adlFood = ACCastUtilities.toInt(printParam.getData("ADL_FOOD"));
        // �n��p�����[�^�[ADL_FOOD�̒l���`�F�b�N����B
        switch (adlFood) {
        // �l��1�������ꍇ
        case 1:
            // �u�ꕔ��v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlFood2");
            // �u�S�ʉ����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlFood3");
            // �����I��
            break;

        // �l��2�������ꍇ
        case 2:
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlFood1");
            // �u�S�ʉ�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlFood3");
            // �����I��
            break;

        // �l��3�������ꍇ
        case 3:
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlFood1");
            // �u�ꕔ��v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlFood2");

            // �����I��
            break;

        default:
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlFood1");
            // �u�ꕔ��v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlFood2");
            // �u�S�ʉ�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlFood3");
            // �����I��
            break;
        }

        int adlBath = ACCastUtilities.toInt(printParam.getData("ADL_BATH"));
        // �n��p�����[�^�[ADL_BATH�̒l���`�F�b�N����B
        switch (adlBath) {
        // �l��1�������ꍇ
        case 1:
            // �u�ꕔ��v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlBath2");
            // �u�S�ʉ����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlBath3");
            // �����I��
            break;

        // �l��2�������ꍇ
        case 2:
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlBath1");
            // �u�S�ʉ�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlBath3");
            // �����I��
            break;

        // �l��3�������ꍇ
        case 3:
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlBath1");
            // �u�ꕔ��v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlBath2");
            // �����I��
            break;

        default:
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlBath1");
            // �u�ꕔ��v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlBath2");
            // �u�S�ʉ�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlBath3");
            // �����I��
            break;

        }

        int adlCosmetic = ACCastUtilities.toInt(printParam
                .getData("ADL_COSMETIC"));
        // �n��p�����[�^�[ADL_COSMETIC�̒l���`�F�b�N����B
        switch (adlCosmetic) {
        // �l��1�������ꍇ
        case 1:
            // �u�ꕔ��v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlCosmetic2");
            // �u�S�ʉ����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlCosmetic3");
            // �����I��
            break;

        // �l��2�������ꍇ
        case 2:
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlCosmetic1");
            // �u�S�ʉ�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlCosmetic3");
            // �����I��
            break;

        // �l��3�������ꍇ
        case 3:
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlCosmetic1");
            // �u�ꕔ��v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlCosmetic2");
            // �����I��
            break;

        default:
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlCosmetic1");
            // �u�ꕔ��v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlCosmetic2");
            // �u�S�ʉ�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "adlCosmetic3");
            // �����I��
            break;

        }

        // �v���x
        int jotaiCode = ACCastUtilities.toInt(printParam.getData("JOTAI_CODE"), 1);
        // JOTAI_CODE�̒l���`�F�b�N����
        switch (jotaiCode) {
        // �l��1�������ꍇ
        case 1:
            //�u�v�x���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode12");
            //�u�v�x���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode13");
            // �u�v�x���v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode2");
            // �u�v���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode3");
            // �u�v���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode4");
            // �u�v���R�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode5");
            // �u�v���S�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode6");
            // �u�v���T�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode7");
            // �����I��
            break;

        // �l��11�������ꍇ
        case 11:
            //�u�v�x���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode12");
            //�u�v�x���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode13");
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode1");
            // �u�v���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode3");
            // �u�v���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode4");
            // �u�v���R�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode5");
            // �u�v���S�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode6");
            // �u�v���T�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode7");
            // �����I��
            break;
        case 12:
            //�u�v�x���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode13");
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode1");
            // �u�v�x���v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode2");
            // �u�v���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode3");
            // �u�v���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode4");
            // �u�v���R�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode5");
            // �u�v���S�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode6");
            // �u�v���T�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode7");
            // �����I��
            break;
        case 13:
            //�u�v�x���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode12");
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode1");
            // �u�v�x���v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode2");
            // �u�v���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode3");
            // �u�v���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode4");
            // �u�v���R�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode5");
            // �u�v���S�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode6");
            // �u�v���T�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode7");
            // �����I��
            break;
        // �l��21�������ꍇ
        case 21:
            //�u�v�x���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode12");
            //�u�v�x���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode13");
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode1");
            // �u�v�x���v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode2");
            // �u�v���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode4");
            // �u�v���R�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode5");
            // �u�v���S�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode6");
            // �u�v���T�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode7");
            // �����I��
            break;

        // �l��22�������ꍇ
        case 22:
            //�u�v�x���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode12");
            //�u�v�x���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode13");
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode1");
            // �u�v�x���v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode2");
            // �u�v���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode3");
            // �u�v���R�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode5");
            // �u�v���S�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode6");
            // �u�v���T�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode7");
            // �����I��
            break;

        // �l��23�������ꍇ
        case 23:
            //�u�v�x���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode12");
            //�u�v�x���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode13");
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode1");
            // �u�v�x���v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode2");
            // �u�v���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode3");
            // �u�v���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode4");
            // �u�v���S�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode6");
            // �u�v���T�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode7");
            // �����I��
            break;

        // �l��24�������ꍇ
        case 24:
            //�u�v�x���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode12");
            //�u�v�x���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode13");
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode1");
            // �u�v�x���v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode2");
            // �u�v���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode3");
            // �u�v���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode4");
            // �u�v���R�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode5");
            // �u�v���T�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode7");
            // �����I��
            break;

        // �l��25�������ꍇ
        case 25:
            //�u�v�x���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode12");
            //�u�v�x���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode13");
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode1");
            // �u�v�x���v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode2");
            // �u�v���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode3");
            // �u�v���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode4");
            // �u�v���R�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode5");
            // �u�v���S�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode6");
            //�����I��
            break;

        default:
            //�u�v�x���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode12");
            //�u�v�x���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode13");
//            //�u�����v�̃V�F�C�v���\���ɂ���B
//            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode1");
            //�u�v�x���v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode2");
            //�u�v���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode3");
            //�u�v���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode4");
            //�u�v���R�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode5");
            //�u�v���S�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode6");
            //�u�v���T�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode7");
            break;
        }

        // ���L�̏����ŕa��E��Q���̏�Ԃ�ݒ肷��B
        //�E1�s�Ɉ�������̂́A�S�p45�����Ƃ���B46�����ȍ~��2�s�ڂɐݒ肷��B
        //�E�ő�o�͍s����2�s�Ƃ���B    

        //������ɕϊ�
        String byojoShogaiState = ACCastUtilities.toString(printParam
                .get("BYOJO_SHOGAI_STATE"));

        ACChotarouXMLUtilities.setValue(writer, "etcInfo.h1.w2",
                getInsertionLineSeparatorToStringOnByte(byojoShogaiState, 90));

        //1��������̖K��񐔁i���j��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, printParam, "HOMON_KAISU_DAY",
                "hokenKaisuDay");

        //1��������̖K��񐔁i��j��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, printParam,
                "HOMON_KAISU_COUNT", "hokenKaisuCount");

        //���L�̏����ŊŌ�̓��e��ݒ肷��B
        //1�s�Ɉ�������̂́A�S�p45�����Ƃ���B46�����ȍ~��2�s�ڂɐݒ肷��B
        //�E�ő�o�͍s����2�s�Ƃ���B
        String kangoNaiyo = ACCastUtilities.toString(printParam.get("KANGO_NAIYO"));

        ACChotarouXMLUtilities.setValue(writer, "etcInfo.h4.w2",
                getInsertionLineSeparatorToStringOnByte(kangoNaiyo, 90));

        //���L�̏����ŕK�v�ƍl������ی������T�[�r�X��ݒ肷��B
        //1�s�Ɉ�������̂́A�S�p45�����Ƃ���B46�����ȍ~��2�s�ڂɐݒ肷��B
        //�E�ő�o�͍s����2�s�Ƃ���B    
        String hokenFukushiService = ACCastUtilities.toString(printParam
                .get("HOKEN_FUKUSHI_SERVICE")); 

        ACChotarouXMLUtilities
                .setValue(writer, "etcInfo.h3.w2",
                        getInsertionLineSeparatorToStringOnByte(
                                hokenFukushiService, 90));

        //���L�̏����ł��̑����L���ׂ�������ݒ肷��B
        //1�s�Ɉ�������̂́A�S�p45�����Ƃ���B46�����ȍ~��2�s�ڂɐݒ肷��B
        //�E�ő�o�͍s����2�s�Ƃ���B
        String ryuijiko = ACCastUtilities.toString(printParam.get("RYUIJIKO")); 
        
        ACChotarouXMLUtilities.setValue(writer, "etcInfo.h2.w2",
                getInsertionLineSeparatorToStringOnByte(ryuijiko, 90));

        //�y�[�W�I��
        writer.endPageEdit();
        //TODO ��������s�����Ȃ��true��Ԃ��B
        return true;
    }

    /**
     * ���������Ƃɉ��s�R�[�h��}�������������Ԃ��܂�
     * @param keyName �L�[�̖��O
     * @param printParam �g�p����p���[���[�^�[
     * @param columns ���s��Ƃ��镶����
     * @return ���s�R�[�h��}������������
     * @throws Exception
     */
    public String getInsertionLineSeparatorToString(String keyName,
            VRMap printParam, int columns) throws Exception {
        
        //�o�C�g�Ȃ̂ŕ������ɂ��킹2�{�ɂ���
        String[] slComment = ACTextUtilities.separateLineWrapOnByte(
                ACCastUtilities.toString(printParam.getData(keyName)), columns*2+1);

        StringBuilder sbComment = new StringBuilder();

        for (int i = 0; i < slComment.length; i++) {
            sbComment.append(slComment[i]);
            //�ŏI�s�ł���ꍇ�͉��s�R�[�h��ǉ����Ȃ�
            if (i != slComment.length - 1) {
                //���s�R�[�h��ǉ�����
                sbComment.append(ACConstants.LINE_SEPARATOR);
            }
        }

        String insertionLineSeparatorString = sbComment.toString();

        //���s�R�[�h��ǉ������������Ԃ�
        return insertionLineSeparatorString;
    }

    /**
     * �w�肳�ꂽ�������ŉ��s�����������Ԃ��܂��B
     * @param chr ���s�ΏۂƂȂ镶����
     * @param columnIndex ���s�������
     * @return ���s������}������������
     */
    public String getInsertionLineSeparatorToStringOnChar(String chr, int charIndex){
        String[] slCharacter = ACTextUtilities.separateLineWrapOnChar(chr,charIndex);
        
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
