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
 * �쐬��: 2006/01/06  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���[�Ǘ� (C)
 * �v���Z�X �K��Ō�L�^���T (004)
 * �v���O���� �K��Ō�L�^���T (QC004)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qc.qc004;

import java.awt.event.ActionEvent;
import java.text.Format;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �K��Ō�L�^���T(QC004)
 */

public class QC004 extends QC004Event {
	/**
	 * �R���X�g���N�^�ł��B
	 */
	public QC004() {
	}

	public void initAffair(ACAffairInfo affair) throws Exception {
		super.initAffair(affair);
		initAction(affair);
	}

	/**
	 * �������������s�Ȃ��܂��B
	 * 
	 * @param affair
	 *            �Ɩ����
	 * @throws Exception
	 *             ������O
	 */
	protected void initAction(ACAffairInfo affair) throws Exception {
		// �n��p�����[�^�[��ޔ�����B
		// patientId = PATIENT_ID
		// targetDate = TARGET_DATE

		VRMap parameters = affair.getParameters();

		if (VRBindPathParser.has("PATIENT_ID", parameters)) {
			setPatientId(ACCastUtilities.toInt(VRBindPathParser.get("PATIENT_ID", parameters)));
		}

		if (VRBindPathParser.has("TARGET_DATE", parameters)) {
			setTargetDate(ACCastUtilities.toDate(VRBindPathParser.get("TARGET_DATE", parameters)));
		}

		// �K��Ō�̋L�^���TTBL�iHOMONKANGO_KIROKUSHO�j�̃p�b�V�u�`�F�b�N�L�[���`����B
		// �e�[�u���FHOMONKANGO_KIROKUSHO
		// �L�[�FPATIENT_ID,TARGET_DATE
		// �t�H�[�}�b�g,���l,�N����
		// �N���C�A���g�^�C���t�B�[���h�FLAST_TIME
		// �T�[�o�[�^�C���t�B�[���h�FLAST_TIME

		setPASSIVE_CHECK_KEY_KIROKUSHO(new ACPassiveKey("HOMONKANGO_KIROKUSHO", new String[] { "PATIENT_ID", "TARGET_DATE" }, new Format[] { null, new ACSQLSafeDateFormat("yyyy/M/d") }, "LAST_TIME", "LAST_TIME"));

		// �X�i�b�v�V���b�g�̎B�e�Ώێw�肷��B���B�e�ΏۂƂ��āu�N���C�A���g�̈�icontents�j�v���w�肷��B
		getSnapshot().setRootContainer(getContents());

		// ���p�ҏ����擾����B
		VRArrayList patientList = new VRArrayList();
		patientList = (VRArrayList) QkanCommon.getPatientInfo(getDBManager(), getPatientId());

		if (patientList.isEmpty()) {
			// ���R�[�h���擾�o���Ȃ������ꍇ
			// �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_PASSIVE_CHECK_ON_FIND
			QkanMessageList.getInstance().ERROR_OF_PASSIVE_CHECK_ON_FIND();
			// �n���p�����[�^�[���쐬����B��KEY�FNEXT_AFFAIR VALUE�FQC004
			setParameter(parameters);
			// �u���p�҈ꗗ�iQU001)��ɖ߂�B
			ACFrame.getInstance().back();
		}

		// ���R�[�h���擾�ł����ꍇ
		// �擾�������R�[�h��patientMap�Ɋi�[����B
		setPatientMap((VRMap) patientList.getData(0));

		// patientName�ɗ��p�҂̃t���l�[�����i�[����B
		String patientName = QkanCommon.toFullName(ACCastUtilities.toString(getPatientMap().getData("PATIENT_FAMILY_NAME")), ACCastUtilities.toString(getPatientMap().get("PATIENT_FIRST_NAME")));

		// patientAge�Ƀ��R�[�h�̐��N��������V�X�e�����t����ɂ��ĔN����Z�o�������ʂ��i�[����B
		int patientAge = QkanCommon.calcAge(ACCastUtilities.toDate(getPatientMap().getData("PATIENT_BIRTHDAY")));

		// patientMap�ɗ��p�҂̃t���l�[���ƔN������L��KEY/VALUE�Őݒ肷��B
		// KEY�FPATIENT_NAME VALUE�FpatientName
		// KEY�FPATIENT_AGE VALUE�FpatientAge
		getPatientMap().setData("PATIENT_NAME", patientName);
		getPatientMap().setData("PATIENT_AGE", new Integer(patientAge));

		// �K��Ō�L�^���T���̎擾���s���B
		doFindPassive();

		// ��Ë@�փR���{�{�b�N�X��\������
		getMedicalFacilityInfo();

		// ���p�҂̓o�^���Ă����Ë@�֏����擾����B
		// PROCESS_MODE���A���ʒ萔�́uPROCESS_MODE_INSERT(4)�v�������ꍇ
		if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {

			// ��Ë@�֏��擾�̂��߁AHashMap�Fparam���쐬�����L�̃p�����[�^�[��ݒ肷��B
			VRHashMap param = new VRHashMap();
			// KEY�FPATIENT_ID VALUE�FpatientId
			param.setData("PATIENT_ID", new Integer(getPatientId()));

			// ��Ë@�֏��擾�̂��߂�SQL�����擾����B
			// �擾����SQL�������s����B
			VRList hospitalList = getDBManager().executeQuery(getSQL_GET_PATIENT_STATION_HISTORY(param));
			
			// ���R�[�h���擾�ł����ꍇ
			if (!hospitalList.isEmpty()) {
				// �擾���R�[�h�W����1���ڂ̃��R�[�h��ޔ�����B
				VRMap hospitalMap = (VRMap) hospitalList.getData(0);
				// �擾�������R�[�h��stationMap�Ɋi�[����B
				setStationMap(hospitalMap);

				// kirokushoMap��stationMap���}�[�W����B���擾������Ë@�֏�񂪃}�[�W�����B
				getKirokushoMap().putAll(getStationMap());

			} else {
				// ���R�[�h���擾�ł��Ȃ������ꍇ
				// kirokushoMap�Ɉȉ���KEY/VALUE��ݒ肷��B�����p�ғo�^��Ë@�ւ����݂��Ȃ��ꍇ�A���I����Ԃɂ��邽��null��ݒ�B
				// KEY�FPROVIDER_NAME VALUE�Fnull
				VRHashMap defaultKirokushoMap = new VRHashMap();
				defaultKirokushoMap.setData("PROVIDER_NAME", null);
				setKirokushoMap(defaultKirokushoMap);
			}
		}

		// ��Ë@�֏�����ʂɓW�J����B
		// �K��Ō�L�^���T���ikirokushoMap�j�ɗ��p�ҏ��ipatientMap�j���}�[�W����B
		getKirokushoMap().putAll(getPatientMap());

		// kirokushoMap���u�N���C�A���g�̈�icontents�j��ɃZ�b�g����B
		getContents().setSource(getKirokushoMap());

		// ��ʂɓW�J����B
		getContents().bindSource();

		// �Ɩ����}�X�^����A�Ɩ������擾����B�����ID = "QC004"
		// �擾�����f�[�^�́u�E�C���h�E�^�C�g���iWINDOW_TITLE�j�v���E�C���h�E�ɐݒ肷��B
		// �擾�����f�[�^�́u�Ɩ��^�C�g���iAFFAIR_TITLE�j�v���Ɩ��{�^���o�[�ɐݒ肷��B
		setAffairTitle("QC004", getButtons());
		// �X�i�b�v�V���b�g���B�e����B
		getSnapshot().snapshot();
	}

    public boolean canBack(VRMap parameters) throws Exception {
        if (!super.canBack(parameters)) {
            return false;
        }
        // ���b�Z�[�W����t���O
        int msgID;

        // �ύX�`�F�b�N�i�X�i�b�v�V���b�g�j
        if (getSnapshot().isModified()) {
            // �ύX����Ă���ꍇ
            // PROCESS_MODE�̊m�F���s���B
            // PROCESS_MODE���A���ʒ萔�́uPROCESS_MODE_INSERT(4)�v�������ꍇ�i�o�^���[�h�j
            if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
                // �o�^�m�F���b�Z�[�W��\������B�����b�Z�[�WID = WARNING_OF_INSERT_ON_MODIFIED
                msgID = QkanMessageList.getInstance()
                        .WARNING_OF_INSERT_ON_MODIFIED();

                switch (msgID) {
                case ACMessageBox.RESULT_YES:
                    // �u�X�V���Ė߂�v������
                    // ���̓`�F�b�N���s���B
                    if (!doCheck()) {
                        // ���̓G���[������ꍇ
                        // �����𔲂���B
                        return false;
                    }

                    // ���̓G���[���Ȃ��ꍇ
                    // �ۑ��������s���B
                    if (doInsert()) {
                        // �ۑ�����������I�������ꍇ
                        // �n���p�����[�^�[���쐬����B��KEY�FNEXT_AFFAIR VALUE�FQC004
                        setParameter(parameters);

                        // �u���p�҈ꗗ�iQU001�j�v��ʂɖ߂�B
                    } else {
                        // �ۑ��������ُ�I�������ꍇ
                        // �����𔲂���B
                        return false;
                    }

                    break;

                case ACMessageBox.RESULT_NO:
                    // �u�j�����Ė߂�v������
                    // �n���p�����[�^�[���쐬����B��KEY�FNEXT_AFFAIR VALUE�FQC004
                    setParameter(parameters);
                    // �u���p�҈ꗗ�iQU001�j�v��ʂɖ߂�B
                    return true;

                default:
                    // �u�L�����Z���v������
                    // �����𔲂���B
                    return false;
                }

            } else if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
                // PROCESS_MODE���A���ʒ萔�́uPROCESS_MODE_UPDATE(3)�v�������ꍇ�i�X�V���[�h�j
                // �X�V�m�F���b�Z�[�W��\������B�����b�Z�[�WID = WARNING_OF_UPDATE_ON_MODIFIED
                msgID = QkanMessageList.getInstance()
                        .WARNING_OF_UPDATE_ON_MODIFIED();
                switch (msgID) {
                case ACMessageBox.RESULT_YES:
                    // �u�X�V���Ė߂�v������
                    // ���̓`�F�b�N���s���B
                    if (!doCheck()) {
                        // ���̓G���[������ꍇ
                        // �����𔲂���B
                        return false;
                    }
                    // ���̓G���[���Ȃ��ꍇ
                    // �X�V�������s���B
                    if(doUpdate()){

                    // �ۑ�����������I�������ꍇ
                    // �n���p�����[�^�[���쐬����B��KEY�FNEXT_AFFAIR VALUE�FQC004
                    setParameter(parameters);

                    // �u���p�҈ꗗ�iQU001�j�v��ʂɖ߂�B
                    }else{
                    // �ۑ��������ُ�I�������ꍇ
                    // �����𔲂���B
                        return false;
                    }
                    break;

                case ACMessageBox.RESULT_NO:
                    // �u�j�����Ė߂�v������
                    // �n���p�����[�^�[���쐬����B��KEY�FNEXT_AFFAIR VALUE�FQC004
                    setParameter(parameters);

                    // �u���p�҈ꗗ�iQU001�j�v��ʂɖ߂�B
                    return true;

                default:
                    // �u�L�����Z���v������
                    // �����𔲂���B
                    return false;
                }
            }
        }
        return true;
    }

	public boolean canClose() throws Exception {
		if (!super.canClose()) {
			return false;
		}
		// �ύX�`�F�b�N�i�X�i�b�v�V���b�g�j
		if (getSnapshot().isModified()) {
			// �ύX����Ă���ꍇ
			// �I���m�F���b�Z�[�W��\������B

			if (QkanMessageList.getInstance().WARNING_OF_CLOSE_ON_MODIFIED() == ACMessageBox.RESULT_OK) {
				// �u�͂��v������
				// ���ǒ��V�X�e�����I������B
				return true;

			} else {
				// �u�������v������
				// �����𔲂���B�i�������s��Ȃ��j
				return false;
			}

		} else {
			// �ύX����Ă��Ȃ��ꍇ
			// ���ǒ��V�X�e�����I������B
			return true;
		}
	}

	// �R���|�[�l���g�C�x���g

	/**
	 * �u�Ǎ��ݏ����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void openActionPerformed(ActionEvent e) throws Exception {
		// �O���ȑO�̖K��Ō�L�^���T���̒��ōŐV�̏���Ǎ��ށB
		// �Ǎ��݊m�F���s���B�����b�Z�[�WID = QC001_WARNING_ON_READ_OF_MOST_NEW_DATA
		if (QkanMessageList.getInstance().QC001_WARNING_ON_READ_OF_MOST_NEW_DATA() == ACMessageBox.RESULT_OK) {
			// �uOK�������
			// �K��Ō�L�^���T���擾�̂��߂�SQL�����擾������HashMap�Fparam���쐬���A���L��KEY/VALUE��ݒ肷��B
			VRMap param = new VRHashMap();

			// KEY�FPATIENT_ID VALUE�FpatientId
			// KEY�FTARGET_DATE VALUE�FtargetDate
			param.setData("PATIENT_ID", new Integer(getPatientId()));
			param.setData("TARGET_DATE", ACDateUtilities.toFirstDayOfMonth(getTargetDate()));

			// SQL�����擾����B
			// �擾����SQL�������s����B
			VRList lastKirokushoList = getDBManager().executeQuery(getSQL_GET_LAST_HOMONKANGO_KIROKUSHO(param));

			// ���R�[�h���擾�ł����ꍇ
			if (!lastKirokushoList.isEmpty()) {
				// �擾�����z����AkirokushoMap�Ɋi�[����B
				VRMap lastKirokushoMap = (VRMap) lastKirokushoList.getData(0);

				setKirokushoMap(lastKirokushoMap);
				// kirokushoMap���u�N���C�A���g�̈�icontents�j�v�ɃZ�b�g����B
				getContents().setSource(getKirokushoMap());
				// ��ʂɓW�J����B
				getContents().bindSource();
//				 �X�i�b�v�V���b�g���B�e����B
//				getSnapshot().snapshot();
			} else {
				// ���R�[�h���擾�ł��Ȃ������ꍇ
				// ���b�Z�[�W��\������B�����b�Z�[�WID QC001_NOTICE_HAS_NO_LAST_DATA
				// �����𔲂���B�i�����s��Ȃ��j
				QkanMessageList.getInstance().QC001_NOTICE_HAS_NO_LAST_DATA();
			}
		}
	}

	/**
	 * �u��������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void printActionPerformed(ActionEvent e) throws Exception {
		// �K��Ō�L�^���T�̈�����s���B
		// �ȉ��̈�����n���A����m�F���s���B�����b�Z�[�WID = WARNING_OF_PRINT
//		if (QkanMessageList.getInstance().WARNING_OF_PRINT("�K��Ō�L�^��I") == ACMessageBox.RESULT_OK) {
		
		if(getSnapshot().isModified()){
			// ��ʏ�̃f�[�^�ɕύX������ꍇ�͈���O�̕ۑ��m�F���b�Z�[�W��\������B
            // ���b�Z�[�W�i�[�p
            int msgID = 0;

            // �ύX���������ꍇ
            if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
                // �o�^�p���b�Z�[�W���쐬����
                msgID = QkanMessageList.getInstance().WARNING_OF_DO_PRINT("�o�^",
                        "�K��Ō�L�^��I");
            } else if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
                // �X�V�p���b�Z�[�WID���쐬����
                msgID = QkanMessageList.getInstance().WARNING_OF_DO_PRINT("�X�V",
                        "�K��Ō�L�^��I");
            }

            // �ۑ��m�F�ŁuOK�v�ȊO���I�����ꂽ�ꍇ�A��������𒆒f����B
            if (msgID != ACMessageBox.RESULT_OK) {
            	return;
            }

		}
		
		// ���̓`�F�b�N���s���B
		// ���̓G���[���Ȃ��ꍇ
		// ����ۑ�����B
		if(!doSave()) {
			return;
		}

		// �p�b�V�u�`�F�b�N�p�̃f�[�^��o�^����B
		doFindPassive();

		// ��ʏ�̏���kirokushoMap�Ɋi�[����B
		getContents().setSource(getKirokushoMap());
		getContents().applySource();

		// ����N���X�ւ̓n��p�����[�^(���R�[�h) printParameter�𐶐�����B
		VRMap printParameter = null;
		printParameter = new VRHashMap();

		// printParameter�ɁAKirokushoMap�̒l���R�s�[����B
		printParameter = getKirokushoMap();

		// ����Ǘ��N���X�𐶐�
		ACChotarouXMLWriter writer = new ACChotarouXMLWriter();

		// ����J�n��錾
		writer.beginPrintEdit();
		QC004P01 qc00401 = new QC004P01();
		QC004P02 qc00402 = new QC004P02();

		// �������B
		// �K��Ō�L�^���T��N0.1���쐬����B
		// �K��Ō�L�^��I��NO.2���쐬����B
		// ���[���o�͂���B
		if (qc00401.doPrint(writer, printParameter) && qc00402.doPrint(writer, printParameter)) {

			// �������ꂽ�ꍇ
			// ����I���𐧌�
			writer.endPrintEdit();

			// PDF�t�@�C���𐶐����ĊJ��
			ACChotarouXMLUtilities.openPDF(writer);

		} else {
			// ��������Ȃ������ꍇ
		}
//		}
	}

	/**
	 * �u�o�^�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void insertActionPerformed(ActionEvent e) throws Exception {
		// �K��Ō�L�^���T����ۑ�����B
		// ���̓`�F�b�N���s���B
		if (doCheck()) {
			// �uOK�v������
			// �o�^�������s���B
			if (doSave()) {

				// �p�b�V�u�`�F�b�N�p�̃f�[�^��o�^����B
				doFindPassive();

				// �o�^�������b�Z�[�W��\������B�����b�Z�[�WID = INSERT_SUCCESSED
				QkanMessageList.getInstance().INSERT_SUCCESSED();
				// ��ʏ�Ԃ�ύX����B
				setState_UPDATE_STATE();
			}
		}
	}

	/**
	 * �u�X�V�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void updateActionPerformed(ActionEvent e) throws Exception {
		// �K��Ō�L�^���T�����X�V����B
		// ���̓`�F�b�N���s���B
		if (doCheck()) {
			if (doSave()) {
				// �p�b�V�u�`�F�b�N�p�̃f�[�^��o�^����B
				doFindPassive();

				// �X�V�������b�Z�[�W��\������B�����b�Z�[�WID = UPDATE_SUCCESSED
				QkanMessageList.getInstance().UPDATE_SUCCESSED();
			}
		}
	}

	/**
	 * �u��ʏ����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void syujiMedicalNameActionPerformed(ActionEvent e) throws Exception {
		// �I�����ꂽ���Ë@��(syujiMedicalName�j��̏���\������B
		// providerList�Ɋi�[����Ă���z�񃌃R�[�h�̒�����A�I�����ꂽ���Ə��̃��R�[�h��providerMap�Ɋi�[����B
		// ���ȉ��A�I�����ꂽ���Ə��̂��Ƃ��u�I�����Ə��v�ƌď̂���B
		VRMap selectedMap = (VRMap) getSyujiMedicalName().getSelectedModelItem();

		if (!(selectedMap == null)) {
			setProviderMap(selectedMap);
			// ��厡��̈�isyujis�j���providerMap���Z�b�g����B
			getSyujis().setSource(getProviderMap());
			// ��ʂɓW�J����B
			getSyujis().bindSource();
		}
	}

	public static void main(String[] args) {
		// �f�t�H���g�f�o�b�O�N��
		ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		param.setData("PATIENT_ID", new Integer(2));
		param.setData("TARGET_DATE", "2006/02/02");
		ACFrame.debugStart(new ACAffairInfo(QC004.class.getName(), param));
	}

	// �����֐�

	/**
	 * �u�p�b�V�u�`�F�b�N�p�f�[�^�o�^�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doFindPassive() throws Exception {
		// �K��Ō�L�^���T�̏����擾���p�b�V�u�L�[��o�^����B
		// �K��Ō�L�^���T���擾�̂��߁AHashMap�Fparam�ɉ��L��KEY/VALUE��ݒ肷��B
		VRMap param = new VRHashMap();
		// KEY�FPATIENT_ID VALUE�FpatientId
		// KEY�FTARGET_DATE VALUE�FtargetDate
		param.setData("PATIENT_ID", new Integer(getPatientId()));
		param.setData("TARGET_DATE", getTargetDate());

		// �K��Ō�L�^���T���擾�̂��߂�SQL�����擾����B
		// �擾����SQL�������s����B

		VRList houmonKangoKirokushoList = getDBManager().executeQuery(getSQL_GET_HOMONKANGO_KIROKUSHO(param));

		if (!houmonKangoKirokushoList.isEmpty()) {
			// ���R�[�h���擾�ł����ꍇ
			// PROCESS_MODE���A���ʒ萔�́uPROCESS_MODE_UPDATE(3)�v�ɐݒ肷��B�i�X�V���[�h�j
			// ��ʂ̏�Ԃ�ύX����B
			setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);

			// ��ʂ̏�Ԃ�UPDATE_STATE�ɕύX����B
			setState_UPDATE_STATE();

			// �擾�������R�[�h��kirokushoList�Ɋi�[����B
			setKirokushoList(houmonKangoKirokushoList);
			// �擾�������R�[�h�̍ŏ��̃��R�[�h��kirokushoMap�Ɋi�[����B
			VRMap houmonKangoKirokushoMap = (VRMap) houmonKangoKirokushoList.getData(0);

			setKirokushoMap(houmonKangoKirokushoMap);

			// �p�b�V�u�`�F�b�N�p�̔�r�f�[�^���L�[�iPASSIVE_CHECK_KEY_KIROKUSHO�j�œo�^����B
			getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY_KIROKUSHO(), getKirokushoList());

			// ��Ë@�֏��Ď擾����
			getMedicalFacilityInfo();
			getContents().setSource(houmonKangoKirokushoMap);
			getContents().bindSource();
			// �X�i�b�v�V���b�g���B�e����B
			getSnapshot().snapshot();

		} else {

			// ���R�[�h���擾�ł��Ȃ������ꍇ
			// PROCESS_MODE���A���ʒ萔�́uPROCESS_MODE_INSERT(4)�v�ɐݒ肷��B�i�o�^���[�h�j
			setProcessMode(QkanConstants.PROCESS_MODE_INSERT);
			// ��ʂ̏�Ԃ�INSERT_STATE�ɕύX����B
			setState_INSERT_STATE();
		}
	}

	/**
	 * �u�ۑ������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean doSave() throws Exception {
		// �K��Ō�L�^���T����ۑ����鏈��
		// PROCESS_MODE���`�F�b�N����B
		if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
			// PROCESS_MODE���A���ʒ萔�́uPROCESS_MODE_INSERT(4)�v�������ꍇ
			// �o�^�������s��
			if (doInsert()) {
				return true;
			} else {
				return false;
			}
		} else if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
			// PROCESS_MODE���A���ʒ萔�́uPROCESS_MODE_UPDATE(3)�v�������ꍇ�i�X�V���[�h�j
			// �X�V�������s���B
			if (doUpdate()) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	/**
	 * �u�o�^�������s���v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean doInsert() throws Exception {
		// �K��Ō�L�^��I�̓o�^���s������
		try {
			// �g�����U�N�V�������J�n����B
			getDBManager().beginTransaction();
			// �p�b�V�u�^�X�N���N���A����B
			getPassiveChecker().clearPassiveTask();

			// kirokushoMap�ɉ�ʏ�̏����i�[����B
			getContents().setSource(getKirokushoMap());
			getContents().applySource();

			// kirokushoMap�ɉ��L�̃p�����[�^�[��ݒ肷��B
			// KEY�FPATIENT_ID VALUE�FpatientId
			// KEY�FTARGET_DATE VALUE�FtargetDate
			getKirokushoMap().setData("PATIENT_ID", new Integer(getPatientId()));
			getKirokushoMap().setData("TARGET_DATE", getTargetDate());

			// �p�b�V�u�^�X�N��o�^����B
			getPassiveChecker().addPassiveInsertTask(getPASSIVE_CHECK_KEY_KIROKUSHO(), getKirokushoMap());

			// �p�b�V�u�`�F�b�N���s���B
			if (getPassiveChecker().passiveCheck(getDBManager())) {
				// �p�b�V�u�G���[���Ȃ��ꍇ
				// ����K��N�����̖K�⎞�ԁi�o�^�p�j�̐ݒ���s���B
				// setFirstVisitTime();

				// �K��Ō�L�^���T���o�^�p�́ASQL�����擾����B
				// �擾����SQL�������s����B
				getDBManager().executeUpdate(getSQL_INSERT_KIROKUSHO(getKirokushoMap()));

				// SQL�����s�����ŃG���[���������Ȃ������ꍇ
				// �������R�~�b�g����B
				getDBManager().commitTransaction();

				// PROCESS_MODE���A���ʒ萔�́uPROCESS_MODE_UPDATE(3)�v�ɐݒ肷��B�i�X�V���[�h�j
				setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);

			} else {
				// �p�b�V�u�G���[������ꍇ
				// �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_PASSIVE_CHECK_ON_FIND
				QkanMessageList.getInstance().ERROR_OF_PASSIVE_CHECK_ON_FIND();
				// �����𔲂���B�i�ُ�I���j
				getDBManager().beginTransaction();
				return false;
			}

		} catch (Exception ex) {
			// SQL�����s�����ŃG���[�����������ꍇ
			// ���������[���o�b�N����B
			getDBManager().rollbackTransaction();
			// ��O�G���[�𓊂���B
			// �����𔲂���B�i�ُ�I���j
			throw ex;
		}
		return true;
	}

	/**
	 * �u�X�V�������s���v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean doUpdate() throws Exception {
		// �K��Ō�L�^���T���̍X�V���s���B
		try {
			// �g�����U�N�V�������J�n����B
			getDBManager().beginTransaction();
			// �p�b�V�u�^�X�N���N���A����B
			getPassiveChecker().clearPassiveTask();

			// kirokushoMap�ɉ�ʏ�̏����i�[����B
			getContents().setSource(getKirokushoMap());
			getContents().applySource();

			// kirokushoMap�ɉ��L�̃p�����[�^�[��ݒ肷��B
			// KEY�FPATIENT_ID VALUE�FpatientId
			// KEY�FTARGET_DATE VALUE�FtargetDate
			getKirokushoMap().setData("PATIENT_ID", new Integer(getPatientId()));
			getKirokushoMap().setData("TARGET_DATE", getTargetDate());

			// �p�b�V�u�^�X�N��o�^����B
			getPassiveChecker().addPassiveUpdateTask(getPASSIVE_CHECK_KEY_KIROKUSHO());

			// �p�b�V�u�`�F�b�N���s���B
			if (getPassiveChecker().passiveCheck(getDBManager())) {
				// �p�b�V�u�G���[���Ȃ��ꍇ
				// �K��Ō�L�^���T���X�V�p��SQL�����擾����B
				// �擾����SQL�������s����B
				getDBManager().executeUpdate(getSQL_UPDATE_KIROKUSHO(getKirokushoMap()));

				// SQL���s�����ŃG���[���Ȃ��ꍇ
				// �������R�~�b�g����B
				getDBManager().commitTransaction();

			} else {
				// �p�b�V�u�G���[������ꍇ
				// �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_PASSIVE_CHECK_ON_FIND
				QkanMessageList.getInstance().ERROR_OF_PASSIVE_CHECK_ON_FIND();
				// �����𔲂���B�i�ُ�I���j
				getDBManager().beginTransaction();
				return false;
			}

		} catch (Exception ex) {
			// SQL�����s�����ŃG���[������ꍇ
			// ���������[���o�b�N����B
			getDBManager().rollbackTransaction();
			// �����𔲂���B�i�ُ�I���j
			throw ex;
		}
		return true;
	}

	/**
	 * �u�n���p�����[�^�[�쐬�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void setParameter(VRMap parameters) throws Exception {
		// ���p�҈ꗗ��ʂŎg�p����n���p�����[�^�[�̍쐬���s���B
		// affairMap�ɉ��L��KEY/VALUE��ݒ肷��B
		// KEY�FNEXT_AFFAIR VALUE�FQC004
		parameters.setData("NEXT_AFFAIR", "QC004");
		ACAffairInfo affair = new ACAffairInfo(QC004.class.getName(), parameters);
	}

	/**
	 * �u�K��J�n���ԁE�K��I�����ԓ��̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean doCheck() throws Exception {
		// �K��J�n���ԁE�K��I�����Ԃ̓��̓`�F�b�N���s���B
		// �K��J�n���Ԃ̃`�F�b�N���s���B
		// �K��I�����Ԃ̃`�F�b�N���s���B
		if (doCheckStartTime() && doCheckEndTime()) {
			// ��L2�̃`�F�b�N�ŃG���[���������Ȃ������ꍇtrue��Ԃ��B
			return true;
		}
		return false;
	}

	/**
	 * �u�K��J�n���ԓ��̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean doCheckStartTime() throws Exception {
		// ����K��J�n���Ԃ��`�F�b�N���鏈��
		// ����K��J�n���ԁifirstVisitDateStartHour�j�����͂���Ă��邩�`�F�b�N����B
		if (getFirstVisitDateStartHour().equals("")) {
			// ���͂���Ă��Ȃ������ꍇ
			// �ȉ��̈�����n���A�G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_NEED_CHECK_FOR_INPUT
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT("����K��N�����̖K��J�n����");
			// ����K��J�n���ԁifirstVisitDateStartMinute�j�Ƀt�H�[�J�X�𓖂Ă�B
			getFirstVisitDateStartHour().requestFocus();
			// �����𔲂���B�i�ُ�F�����́j
			return false;
		}
		return true;
	}

	/**
	 * �u�K��I�����ԓ��̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean doCheckEndTime() throws Exception {
		// �K��I�����ԃ`�F�b�N����
		// ����K��J�n���ԁifirstVisitDateEndHour�j�����͂���Ă��邩�`�F�b�N����B
		if (getFirstVisitDateEndHour().equals("")) {
			// ���͂���Ă��Ȃ������ꍇ
			// �ȉ��̈�����n���A�G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_NEED_CHECK_FOR_INPUT
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT("����K��N�����̖K��I������");
			// ����K��J�n���ԁifirstVisitDateEndHour�j�Ƀt�H�[�J�X�𓖂Ă�B
			getFirstVisitDateEndHour().requestFocus();
			// �����𔲂���B�i�ُ�F�����́j
			return false;
		}
		return true;
	}

	/**
	 * �u��Ë@�֏��R���{�Z�b�g�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void getMedicalFacilityInfo() throws Exception {
		// ��Ë@�ւ̎��Ə������擾����
		// ��Ë@�ւ̎��Ə������擾���邽�߂�SQL�����擾����B
		// �擾����SQL�������s����B
		VRList hospitalList = getDBManager().executeQuery(getSQL_GET_MEDICAL_FACILITY(null));

		// ���R�[�h���擾�ł����ꍇ
		if (!hospitalList.isEmpty()) {
			// �擾�������R�[�h�z���providerList�Ɋi�[����B
			setProviderList(hospitalList);
			// ��Â�񋟂��Ă��鎖�Ə������ȉ���KEY��map�ɐݒ肷��B
			VRHashMap map = new VRHashMap();

			// KEY�FMEDICAL_FACILITY_ID VALUE�FproviderList
			map.setData("MEDICAL_FACILITY_ID", getProviderList());

			// map���u��Ë@�փR���{(syujiMedicalName)�v�ɁA�ݒ肷��B
			getSyujiMedicalName().setModelSource(map);

			// ��Ë@�փR���{�Ƀ��f���i�I�����j����荞��
			getSyujiMedicalName().bindModelSource();
		}
	}
}
