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
 * �J����: ��i�@�a�P
 * �쐬��: 2006/01/16  ���{�R���s���[�^�[������� ��i�@�a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ��Ë@�֊Ǘ� (010)
 * �v���O���� ��Ë@�֓o�^ (QO010)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qo.qo010;

import java.awt.event.ActionEvent;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.ACZipRelation;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * ��Ë@�֓o�^(QO010)
 */
public class QO010 extends QO010Event {
	/**
	 * �R���X�g���N�^�ł��B
	 */
	public QO010() {
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
		// �X�֔ԍ�����Z���ϊ�
		new ACZipRelation(getMedicalFacilityPostnoOn(),
				getMedicalFacilityPostnoUnder(), getMedicalFacilityAddress());

		// �p�b�V�u�L�[�̒�`
		setPASSIVE_CHECK_KEY(new ACPassiveKey("MEDICAL_FACILITY",
				new String[] { "MEDICAL_FACILITY_ID" }, "LAST_TIME",
				"LAST_TIME"));

		// �n��p�����[�^��ޔ�����B
		// medicalFacilityId = MEDICAL_FACILITY_ID�i��Ë@��ID�j
		VRMap parameters = affair.getParameters();

		// �f�[�^�����݂��Ă��邩���`�F�b�N
		if (VRBindPathParser.has("MEDICAL_FACILITY_ID", parameters)) {

			// int�^�Ɍ^�ϊ������p��ID��ޔ�
			setMedicalFacilityId(Integer.parseInt(String
					.valueOf(VRBindPathParser.get("MEDICAL_FACILITY_ID",
							parameters))));
		}
		if (VRBindPathParser.has("PROCESS_MODE", parameters)) {

			// int�^�Ɍ^�ϊ����v���Z�X���[�h��ޔ�
			setProcessMode(Integer.parseInt(String.valueOf(VRBindPathParser
					.get("PROCESS_MODE", parameters))));
		}

		// ��ʏ�Ԃ̏��������s���B
		initialize();

		// �X�i�b�v�V���b�g�B�e�Ώۂ��u��Ë@�֏��̈�imedicalFacilityContents�j�v�Ɏw�肷��B
		getSnapshot().setRootContainer(getMedicalFacilityContents());
		// �X�V���[�h�̏ꍇ�iprocessMode�����ʒ萔��PROCESS_MODE_UPDATE�j
		// �f�[�^���������A�擾����B
		doFind();
	}

	public boolean canBack(VRMap parameters) throws Exception {
		if (!super.canBack(parameters)) {
			return false;
		}
		// �Ō�ɕۑ�����Ă���ύX����Ă��邩�ǂ����`�F�b�N����B
		if (getSnapshot().isModified()) {
			// �Ō�ɕۑ�����Ă���ύX����Ă���ꍇ�iACSnapshot.isModified == true�j
			// �m�F���b�Z�[�W��\������B
			// �o�^���[�h�̏ꍇ�iprocessMode�����ʒ萔��PROCESS_MODE_INSERT�j
			int msgID = 0;
			if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
				// �E���b�Z�[�WID�FWARNING_OF_INSERT_ON_MODIFIED
				msgID = QkanMessageList.getInstance()
						.WARNING_OF_INSERT_ON_MODIFIED();
			} else {
				// �X�V���[�h�̏ꍇ�iprocessMode�����ʒ萔��PROCESS_MODE_UPDATE�j
				msgID = QkanMessageList.getInstance()
						.WARNING_OF_UPDATE_ON_MODIFIED();
				// �E���b�Z�[�WID�FWARNING_OF_UPDATE_ON_MODIFIED
			}
			switch (msgID) {
			// �u�͂��v�u�������v�ȊO��I�������ꍇ
			case ACMessageBox.RESULT_CANCEL:
				// �����𒆒f����i�������Ȃ��j�B
				return false;

			case ACMessageBox.RESULT_YES:
				// �u�͂��v��I�������ꍇ
				// ���̓`�F�b�N���s���B
				if (!isValidInput()) {
					// ���̓G���[���������ꍇ�i�߂�l��false�ł������ꍇ�j
					// �����𒆒f����B(�I��)
					return false;
				}
				// �ۑ��������s���B
				if (doSave()) {
					// �ۑ�����������I�������ꍇ
					// �o�^���[�h�̏ꍇ�iprocessMode�����ʒ萔��PROCESS_MODE_INSERT�j
					if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
						// ���������ʒm���b�Z�[�W��\������B
						// �E���b�Z�[�WID�FINSERT_SUCCESSED
//						QkanMessageList.getInstance().INSERT_SUCCESSED();
						// �������[�h���X�V���[�h�ɕύX����B
						setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);
					} else {
						// �X�V���[�h�̏ꍇ�iprocessMode�����ʒ萔��PROCESS_MODE_UPDATE�j
						// ���������ʒm���b�Z�[�W��\������B
						// �E���b�Z�[�WID�FUPDATE_SUCCESSED
//						QkanMessageList.getInstance().UPDATE_SUCCESSED();
					}
				} else {
					// �ۑ�����������I�����Ȃ������ꍇ
					// �����𒆒f����B(�I��)
					return false;
				}

			}
		}

		// �X�V���[�h�̏ꍇ
		if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
			// ���L�p�����[�^��߂莞�̓n��p�����[�^�ɐݒ肷��B
			// KEY�FMEDICAL_FACILITY_ID VALUE�FmedicalFacilityId
			parameters.setData("MEDICAL_FACILITY_ID", new Integer(
					getMedicalFacilityId()));
		}
		// TODO �O��ʂւ̑J�ڂ�������Ȃ��true��Ԃ��B
		return true;
	}

	public boolean canClose() throws Exception {
		if (!super.canClose()) {
			return false;
		}
		// �Ō�ɕۑ�����Ă���ύX����Ă��邩�ǂ����`�F�b�N����B
		int msgID = 0;
		if (getSnapshot().isModified()) {
			// �Ō�ɕۑ�����Ă���ύX����Ă���ꍇ�iACSnapshot.isModified == true�j
			// �I���m�F���b�Z�[�W��\������B
			msgID = QkanMessageList.getInstance()
					.WARNING_OF_CLOSE_ON_MODIFIED();
			// �E���b�Z�[�WID�FWARNING_OF_CLOSE_ON_MODIFIED
			switch (msgID) {
			case ACMessageBox.RESULT_CANCEL:
				// �u�͂��v�I���ȊO�̏ꍇ
				// �����𒆒f����i�������Ȃ��j�B
				return false;
			}
		}
		// �V�X�e�����I������B
		// TODO �I����������Ȃ��true��Ԃ��B
		return true;
	}

	// �R���|�[�l���g�C�x���g

	/**
	 * �u�o�^�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void insertActionPerformed(ActionEvent e) throws Exception {
		// ���̓`�F�b�N���s���B
		if (!isValidInput()) {
			// ���̓G���[���������ꍇ�i�߂�l��false�ł������ꍇ�j
			// �����𒆒f����B(�I��)
			return;
		}
		// �ۑ��������s���B
		if (doSave()) {
			// �ۑ�����������I�������ꍇ
			// �������[�h���X�V���[�h�ɕύX����B
			setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);
			// ��ʏ�Ԃ̏��������s���B
			initialize();

			// �uMEDICAL_FACILITY�vTABLE���ŐV�̃f�[�^���擾����B
			doFind();

			// ���������ʒm���b�Z�[�W��\������B
			// �E���b�Z�[�WID�FINSERT_SUCCESSED
			QkanMessageList.getInstance().INSERT_SUCCESSED();
		} else {
			// �ۑ�����������I�����Ȃ������ꍇ
			// �����𒆒f����B(�I��)
			return;
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
		// ���̓`�F�b�N���s���B
		if (!isValidInput()) {
			// ���̓G���[���������ꍇ�i�߂�l��false�ł������ꍇ�j
			// �����𒆒f����B(�I��)
			return;
		}
		// �ۑ��������s���B
		if (doSave()) {
			// �ۑ�����������I�������ꍇ
			// ��ʏ�Ԃ̏��������s���B
			initialize();

			// �uMEDICAL_FACILITY�vTABLE���ŐV�̃f�[�^���擾����B
			doFind();

			// ���������ʒm���b�Z�[�W��\������B
			QkanMessageList.getInstance().UPDATE_SUCCESSED();
			// �E���b�Z�[�WID�FUPDATE_SUCCESSED
		} else {
			// �ۑ�����������I�����Ȃ������ꍇ
			// �����𒆒f����B(�I��)
			return;
		}
	}

	/**
	 * �u��ʃN���A�i�X�V���[�h���j�v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void newDataActionPerformed(ActionEvent e) throws Exception {
		// �Ō�ɕۑ�����Ă���ύX����Ă��邩�ǂ����`�F�b�N����B
		int msgID = 0;
		if (getSnapshot().isModified()) {
			// �Ō�ɕۑ�����Ă���ύX����Ă���ꍇ�iACSnapshot.isModified == true�j
			// �m�F���b�Z�[�W��\������B
			msgID = QkanMessageList.getInstance()
					.WARNING_OF_CLEAR_ON_MODIFIED();
			// �E���b�Z�[�WID�FWARNING_OF_CLEAR_ON_MODIFIED
			switch (msgID) {
			case ACMessageBox.RESULT_CANCEL:
				// �uOK�v�I���ȊO�̏ꍇ
				// �������I������B
				return;
			}
		}
		// ��ʑS�̂��N���A����B
		doClear();
	}

	/**
	 * �u��ʃN���A�i�V�K���[�h���j�v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void clearActionPerformed(ActionEvent e) throws Exception {
		// �Ō�ɕۑ�����Ă���ύX����Ă��邩�ǂ����`�F�b�N����B
		int msgID = 0;
		if (getSnapshot().isModified()) {
			// �Ō�ɕۑ�����Ă���ύX����Ă���ꍇ�iACSnapshot.isModified == true�j
			// �m�F���b�Z�[�W��\������B
			msgID = QkanMessageList.getInstance()
					.WARNING_OF_CLEAR_ON_MODIFIED();
			// �E���b�Z�[�WID�FWARNING_OF_CLEAR_ON_MODIFIED
			switch (msgID) {
			case ACMessageBox.RESULT_CANCEL:
				// �uOK�v�I���ȊO�̏ꍇ
				// �������I������B
				return;
			}
		}
		// ��ʑS�̂��N���A����B
		doClear();
	}

	public static void main(String[] args) {
		// �f�t�H���g�f�o�b�O�N��
		ACFrame.getInstance().setFrameEventProcesser(
				new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		// param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
		ACFrame.debugStart(new ACAffairInfo(QO010.class.getName(), param));
	}

	// �����֐�

	/**
	 * �u��ʏ������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void initialize() throws Exception {
		// ����ʏ���������
		// ���E�B���h�E�^�C�g���E�Ɩ��{�^���o�[�̐ݒ�
		// �E�B���h�E�^�C�g���E�Ɩ��{�^���o�[��ݒ肷��B
		setAffairTitle("QO010", "0", getButtons());
		// ���Ɩ��{�^���̏�Ԑݒ�
		// �o�^���[�h�̏ꍇ�iprocessMode�����ʒ萔��PROCESS_MODE_INSERT�j
		if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
			// �Ɩ��{�^���̏�Ԃ�ݒ肷��B
			setState_INSERT_MODE();
			// �E���ID�FINSERT_MODE
		} else {
			// �X�V���[�h�̏ꍇ�iprocessMode�����ʒ萔��PROCESS_MODE_UPDATE�j
			// �Ɩ��{�^���̏�Ԃ�ݒ肷��B
			setState_UPDATE_MODE();
			// �E���ID�FUPDATE_MODE
		}

	}

	/**
	 * �u���������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doFind() throws Exception {
		// ��������������щ�ʓW�J
		// SQL���擾�pVRMap sqlParam�𐶐�����B
		if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {

			VRMap sqlParam = new VRHashMap();
			// sqlParam�ɉ��L�̒l��ݒ肷��B
			// KEY�FMEDICAL_FACILITY_ID VALUE�FmedicalFacilityId
			sqlParam.setData("MEDICAL_FACILITY_ID", new Integer(
					getMedicalFacilityId()));
			// sqlParam�������Ƃ��āA��Ë@�֏��擾�pSQL�����擾����B
			// getSQL_GET_MEDICAL_FACILITY(sqlParam);
			// �擾����SQL�������s���A��Ë@�֏����擾����B
			VRList MedicalFacilityList = getDBManager().executeQuery(
					getSQL_GET_MEDICAL_FACILITY(sqlParam));

			// �擾�����f�[�^�̌�����0���ł���ꍇ
			if (MedicalFacilityList.size() == 0) {
				// �G���[���b�Z�[�W��\������B
				// �E���b�Z�[�WID�FERROR_OF_PASSIVE_CHECK_ON_FIND
				QkanMessageList.getInstance().ERROR_OF_PASSIVE_CHECK_ON_FIND();
				// �u��Ë@�ֈꗗ�v��ʂɖ߂�B

			} else {
				// �擾�����f�[�^�̌�����1���ȏ�ł���ꍇ
				// �p�b�V�u�L�[���N���A����B
				getPassiveChecker().clearReservedPassive();
				// �擾�����f�[�^���p�b�V�u�L�[�ɓo�^����B
				// reservedPassive(PASSIVE_CHECK_KEY, �i�擾�����f�[�^�j);
				getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY(),
						MedicalFacilityList);
				// �擾�����f�[�^�̍ŏ��̃��R�[�h���u��Ë@�֏��̈�imedicalFacilityContents�j�v�̃\�[�X�Ƃ��Đݒ肷��B
				VRMap MedicalFacilityMap = (VRMap) MedicalFacilityList
						.getData(0);
				// this.setSource(MedicalFacilityMap);
				getMedicalFacilityContents().setSource(MedicalFacilityMap);

				// ��ʂɓW�J����B
				getMedicalFacilityContents().bindSource();
			}
		}
		// �X�i�b�v�V���b�g���B�e����B
		getSnapshot().snapshot();
	}

	/**
	 * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean isValidInput() throws Exception {
		// �����̓`�F�b�N
		// ���b�Z�[�W�ɓn��������i�[�pString msgParam�𐶐�����B
		String msgParam = null;
		// �E��Ë@�֖��́imedicalFacilityName�j
		if (ACTextUtilities.isNullText(getMedicalFacilityName().getText())) {
			// �����͂̏ꍇ
			// msgParam��"��Ë@�֖���"��������B
			msgParam = "��Ë@�֖���";
			// �G���[���b�Z�[�W��\������B
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
					msgParam);
			// �E���b�Z�[�WID�FERROR_OF_NEED_CHECK_FOR_INPUT
			// �G���[�����������C���X�^���X�Ƀt�H�[�J�X�𓖂Ă�B
			getMedicalFacilityName().requestFocus();
			// �߂�l�Ƃ���false��Ԃ��B
			return false;
		}
		return true;
	}

	/**
	 * �u�ۑ������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean doSave() throws Exception {

		// ���ۑ�����
		// SQL���擾�pVRMap sqlParam�𐶐�����B
		VRMap sqlParam = new VRHashMap();
		// ��ʏ�̃f�[�^���擾���AsqlParam�Ɋi�[����B
		getMedicalFacilityContents().setSource(sqlParam);
		getMedicalFacilityContents().applySource();

		// DB�}�l�[�W���[��`
		ACDBManager dbm = getDBManager();

		try {
			// �g�����U�N�V�����J�n
			dbm.beginTransaction();

			// �o�^���[�h�̏ꍇ�iprocessMode�����ʒ萔��PROCESS_MODE_INSERT�j
			if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {

				// �uMEDICAL_FACILITY�vTABLE�o�^�p��SQL�����擾����B
				// getSQL_INSERT_MEDICAL_FACILITY(null);
				// �擾����SQL�������s����B
				getDBManager().executeUpdate(
						getSQL_INSERT_MEDICAL_FACILITY(sqlParam));

				// �ꎞHashMap
				VRMap medicalFacilityIdMap = new VRHashMap();
				medicalFacilityIdMap = (VRMap) dbm.executeQuery(
						getSQL_GET_NEW_MEDICAL_FACILITY_ID(null)).getData();

				setMedicalFacilityId(ACCastUtilities.toInt(VRBindPathParser
						.get("MEDICAL_FACILITY_ID_MAX", medicalFacilityIdMap)));

			} else {
				// �p�b�V�u�^�X�N���N���A����B
				getPassiveChecker().clearPassiveTask();

				// �p�b�V�u�^�X�N��o�^����B
				getPassiveChecker().addPassiveUpdateTask(
						getPASSIVE_CHECK_KEY(), 0);

				// �p�b�V�u�`�F�b�N�����s����B
				if (!getPassiveChecker().passiveCheck(dbm)) {
					// �p�b�V�u�G���[������ꍇ
					// �p�b�V�u�G���[���b�Z�[�W��\������B�����b�Z�[�WID =
					// ERROR_OF_PASSIVE_CHECK_ON_UPDATE
					QkanMessageList.getInstance()
							.ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
					// �����𒆒f����B
					dbm.rollbackTransaction();
					return false;
				}

				// sqlParam�ɉ��L�̒l��ǉ�����B
				// KEY�FMEDICAL_FACILITY_ID VALUE�FmedicalFacilityId
				sqlParam.setData("MEDICAL_FACILITY_ID", new Integer(
						getMedicalFacilityId()));
				// �uMEDICAL_FACILITY�vTABLE�X�V�p��SQL�����擾����B
				// getSQL_UPDATE_MEDICAL_FACILITY(null);
				// �擾����SQL�������s����B
				getDBManager().executeUpdate(
						getSQL_UPDATE_MEDICAL_FACILITY(sqlParam));

			}
		} catch (Exception sqlEx) {
			// ��L��SQL�������ɃG���[�����������ꍇ
			// ���������[���o�b�N����B
			sqlEx.printStackTrace();

			dbm.rollbackTransaction();
			// �����𒆒f����B(�ُ�I��)
			throw sqlEx;
			// return false;
		}
		// ��L��SQL����������ɏI�������ꍇ
		// �������R�~�b�g����B
		getDBManager().commitTransaction();

		return true;
	}

	/**
	 * �u��ʃN���A�����v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doClear() throws Exception {
		// ����ʑS�̂��N���A���鏈��
		// ����ʃN���A
		// ���VRMap�𐶐����A�u��Ë@�֏��̈�imedicalFacilityContents�j�v�̃\�[�X�Ƃ��Đݒ肷��B
		VRMap clearMap = new VRHashMap();

		clearMap = (VRMap) getMedicalFacilityContents().createSource();
		getMedicalFacilityContents().setSource(clearMap);
		// ��ʂɋ��VRMap��W�J����B
		getMedicalFacilityContents().bindSource();

		// ���ϐ��N���A�A�������[�h�ύX
		// �X�V���[�h�̏ꍇ�iprocessMode�����ʒ萔��PROCESS_MODE_UPDATE�j
		if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
			// medicalFacilityId���N���A����B�i0��������j
			setMedicalFacilityId(0);
			// �������[�h��o�^���[�h�ɕύX����B
			setProcessMode(QkanConstants.PROCESS_MODE_INSERT);
		}
		// ����ʏ�����
		// ��ʏ�Ԃ̏��������s���B
		initialize();

		// ���X�i�b�v�V���b�g�̎B�e
		// �X�i�b�v�V���b�g���B�e����B
		getSnapshot().snapshot();
	}

}
