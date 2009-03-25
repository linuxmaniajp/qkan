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
 * �J����: ��i �a�P
 * �쐬��: 2006/01/12  ���{�R���s���[�^�[������� ��i �a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���p�ҊǗ� (U)
 * �v���Z�X ���p�ғo�^ (002)
 * �v���O���� ���p�ғo�^ (QU002)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qu.qu002;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.text.Format;
import java.util.Date;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.ACZipRelation;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.affair.qm.qm002.QM002;
import jp.or.med.orca.qkan.affair.qu.qu001.QU001;
import jp.or.med.orca.qkan.affair.qu.qu003.QU003;
import jp.or.med.orca.qkan.affair.qu.qu004.QU004;

/**
 * ���p�ғo�^(QU002) 
 */
public class QU002 extends QU002Event {
	/**
	 * �R���X�g���N�^�ł��B
	 */
	public QU002() {
	}

	public void initAffair(ACAffairInfo affair) throws Exception {
		super.initAffair(affair);
		initAction(affair);
	}

	/**
	 * �������������s�Ȃ��܂��B
	 * @param affair �Ɩ����
	 * @throws Exception ������O
	 */
	protected void initAction(ACAffairInfo affair) throws Exception {

		// �n��p�����[�^��ޔ�����B
		VRMap param = affair.getParameters();

		// KEY�FCOMPULSORY_BACK_FLG
		if (VRBindPathParser.has("COMPULSORY_BACK_FLG", param)) {
			setCompulsoryBackFlg(ACCastUtilities.toInt(VRBindPathParser.get(
					"COMPULSORY_BACK_FLG", param)));
			// �߂�t���O��1�̏ꍇ
			if (getCompulsoryBackFlg() == 1) {
				// �O��ʂ֑J�ڂ���B
				ACFrame.getInstance().back();
				return;
			}

		}

		// KEY�FPATIENT_ID(���p��ID)
		if (VRBindPathParser.has("PATIENT_ID", param)) {
			setPatientId(ACCastUtilities.toInt(VRBindPathParser.get(
					"PATIENT_ID", param)));
		}

		// KEY�FPROCESS_MODE(�������[�h)
		if (VRBindPathParser.has("PROCESS_MODE", param)) {
			setProcessMode(ACCastUtilities.toInt(VRBindPathParser.get(
					"PROCESS_MODE", param)));
		}

		// KEY�FPROCESS_START(�J�ڌ����)
		if (VRBindPathParser.has("PROCESS_START", param)) {
			setProcessStart(ACCastUtilities.toString(VRBindPathParser.get(
					"PROCESS_START", param)));
		} else {
			// PROCESS_START�������Ă��Ȃ��ꍇ
			// �O���ID���擾����B
			ACAffairInfo info = ACFrame.getInstance().getBackAffair();

			if (info != null) {
				if (QM002.class.getName().equals(info.getClassName())) {
					// �O��ʂ����j���[��ʁiQM002�j�̏ꍇ
					setProcessStart("FROM_MENU");

				} else if (QU001.class.getName().equals(info.getClassName())) {
					// �O��ʂ����p�҈ꗗ��ʁiQU001�j�̏ꍇ
					setProcessStart("FROM_LIST");

				}
			}
		}

		// �n��p�����[�^�̍폜
		param.clear();

		// ��ʂ̏��������s���B
		initialize();

		// DB��背�R�[�h���擾���A��ʂɓW�J����B
		doFind();

	}

	public boolean canBack(VRMap parameters) throws Exception {
		if (!super.canBack(parameters)) {
			return false;
		}

		boolean unsettledInfoExistFlg = false;

		// �����I�ɖ߂�
		if (getCompulsoryBackFlg() == 1) {
			return true;
		}

		// �ύX�`�F�b�N(�j������\���̂�����)
		if (getSnapShotIdou().isModified() || getSnapShotKaigo().isModified()) {
			unsettledInfoExistFlg = true;
		}

		// �ύX�`�F�b�N�i�X�i�b�v�V���b�g�̃`�F�b�N�A��ʃe�[�u���̃`�F�b�N�j    
		if (getSnapshot().isModified() || getIdouTableChangeFlg() == 1
				|| getKaigoTableChangeFlg() == 1 || unsettledInfoExistFlg) {
			// �Ō�ɕۑ�����Ă���A���ځE��ʃe�[�u�����ύX����Ă���ꍇ(���L�̂����ꂩ�̏ꍇ�j
			// �EisModified
			// �EidouTableChangeFlg = 1
			// �EkaigoTableChangeFlg = 1

			// �m�F���b�Z�[�W��\������B
			if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
				// �V�K�̏ꍇ�iprocessMode�����ʒ萔��PROCESS_MODE_INSERT�j
				// �E���b�Z�[�WID�FWARNING_OF_INSERT_ON_MODIFIED	

				switch (QkanMessageList.getInstance()
						.WARNING_OF_INSERT_ON_MODIFIED()) {
				case ACMessageBox.RESULT_OK:
					// �u�͂��v��I�������ꍇ

					try {
						// �j��������񂪂��邱�Ƃ�`���郁�b�Z�[�W
						if (unsettledInfoExistFlg) {
							// ���b�Z�[�W�\��
							String msgParam = "�v���F����������͈ٓ����";
							switch (QkanMessageList.getInstance()
									.WARNING_OF_CANCELLATION_UNSETTLED_DATA(
											msgParam)) {
							// �uOK�v�Ȃ�j��
							case ACMessageBox.RESULT_OK:
								break;
							// �uCANCEL�v�Ȃ珈�����f
							case ACMessageBox.RESULT_CANCEL:
								return false;
							}
						}

						// ���̓`�F�b�N���s���B
						if (!isValidInputPatient()) {
							// ���̓G���[������ꍇ				    	
							// �������I������B
							return false;
						}

						// �ۑ��������s���B
						if (!doSave()) {
							// �p�b�V�u�G���[�̏ꍇ
							return false;
						}

						// �������[�h���X�V���[�h�ɕύX����B				        
						setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);

					} catch (Exception ex) {

						// �ۑ�����������I�����Ȃ������ꍇ
						// �����𒆒f����B
						throw ex;
					}

					break;

				case ACMessageBox.RESULT_CANCEL:
					// �u�L�����Z���v��I�������ꍇ
					// �������I������B
					return false;
				}

			} else if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
				// �ҏW�̏ꍇ�iprocessMode�����ʒ萔��PROCESS_MODE_UPDATE�j
				// �E���b�Z�[�WID�FWARNING_OF_UPDATE_ON_MODIFIED

				switch (QkanMessageList.getInstance()
						.WARNING_OF_UPDATE_ON_MODIFIED()) {
				case ACMessageBox.RESULT_OK:
					// �u�͂��v��I�������ꍇ

					try {
						// �j��������񂪂��邱�Ƃ�`���郁�b�Z�[�W
						if (unsettledInfoExistFlg) {
							// ���b�Z�[�W�\��
							String msgParam = "�v���F����������͈ٓ����";
							switch (QkanMessageList.getInstance()
									.WARNING_OF_CANCELLATION_UNSETTLED_DATA(
											msgParam)) {
							// �uOK�v�Ȃ�j��
							case ACMessageBox.RESULT_OK:
								break;
							// �uCANCEL�v�Ȃ珈�����f
							case ACMessageBox.RESULT_CANCEL:
								return false;
							}
						}

						// ���̓`�F�b�N���s���B
						if (!isValidInputPatient()) {
							// ���̓G���[������ꍇ				    	
							// �������I������B
							return false;
						}

						// �ۑ��������s���B
						if (!doSave()) {
							// �p�b�V�u�G���[�̏ꍇ
							return false;
						}

					} catch (Exception ex) {
						// �ۑ�����������I�����Ȃ������ꍇ
						// �����𒆒f����B(�I��)
						throw ex;
					}

					break;

				case ACMessageBox.RESULT_CANCEL:
					// �u�͂��v�u�������v�ȊO��I�������ꍇ
					// �����𒆒f����i�������Ȃ��j�B
					return false;
				}
			}
		}

		// �O��ʂɑJ�ڂ���B
		if ("FROM_LIST".equals(getProcessStart())) {
			// ���p�҈ꗗ��ʂ���J�ڂ��Ă����ꍇ�iprocessStart = "FROM_LIST"�j

			if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
				// �X�V���[�h�̏ꍇ�A���L��n��p�����[�^�Ƃ���B
				// �EKEY�FPATIENT_ID�@VALUE�FpatientId
				VRBindPathParser.set("PATIENT_ID", parameters, new Integer(
						getPatientId()));
			}
		}

		// �O��ʂւ̑J�ڂ�������Ȃ��true��Ԃ��B
		return true;
	}

	public boolean canClose() throws Exception {
		if (!super.canClose()) {
			return false;
		}

		// �ύX�`�F�b�N�i�X�i�b�v�V���b�g�A��ʃe�[�u���̃`�F�b�N�j
		if (getSnapshot().isModified() || getIdouTableChangeFlg() == 1
				|| getKaigoTableChangeFlg() == 1) {
			// �Ō�ɕۑ�����Ă���A���ځE��ʃe�[�u�����ύX����Ă���ꍇ(���L�̂����ꂩ�̏ꍇ�j
			// �EisModified
			// �EidouTableChangeFlg = 1
			// �EkaigoTableChangeFlg = 1

			// �I���m�F���b�Z�[�W��\������B
			// �E���b�Z�[�WID�FWARNING_OF_CLOSE_ON_MODIFIED
			switch (QkanMessageList.getInstance()
					.WARNING_OF_CLOSE_ON_MODIFIED()) {

			case ACMessageBox.RESULT_CANCEL:
				// �u�L�����Z���v��I�������ꍇ
				// �����𒆒f����i�������Ȃ��j�B
				return false;
			}

		}

		// �I����������Ȃ��true��Ԃ��B
		return true;
	}

	//�R���|�[�l���g�C�x���g

	/**
	 * �uDB�o�^�v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void insertActionPerformed(ActionEvent e) throws Exception {

		// ���o�^����
		try {

			// �ύX�`�F�b�N(�j������\���̂�����)
			if (getSnapShotIdou().isModified()
					|| getSnapShotKaigo().isModified()) {
				// ���b�Z�[�W�\��
				String msgParam = "�v���F����������͈ٓ����";
				switch (QkanMessageList.getInstance()
						.WARNING_OF_CANCELLATION_UNSETTLED_DATA(msgParam)) {
				// �uOK�v�Ȃ�j��
				case ACMessageBox.RESULT_OK:
					break;
				// �uCANCEL�v�Ȃ珈�����f
				case ACMessageBox.RESULT_CANCEL:
					return;
				}
			}

			// ���̓`�F�b�N���s���B
			if (!isValidInputPatient()) {
				// ���̓G���[���������ꍇ
				// �����𒆒f����B(�I��)
				return;
			}

			// �ۑ��������s���B
			if (!doSave()) {
				// �p�b�V�u�G���[�̏ꍇ
				return;
			}

			// �ۑ�����������I�������ꍇ
			// �������[�h���X�V���[�h�ɕύX����B
			setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);

			// ��ʂ̐ݒ���s���B
			casualInitialize();

			// �ŐV�̃f�[�^���擾����B
			doFind();

			// �������b�Z�[�W��\������B
			// �E���b�Z�[�WID�FINSERT_SUCCESSED    
			QkanMessageList.getInstance().INSERT_SUCCESSED();

		} catch (Exception ex) {
			// �ۑ�����������I�����Ȃ������ꍇ
			// �������I������B�i�������Ȃ��j
			throw ex;
		}

	}

	/**
	 * �uDB�X�V�v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void updateActionPerformed(ActionEvent e) throws Exception {

		// ���X�V����    
		try {

			// �ύX�`�F�b�N(�j������\���̂�����)
			if (getSnapShotIdou().isModified()
					|| getSnapShotKaigo().isModified()) {
				// ���b�Z�[�W�\��
				String msgParam = "�v���F����������͈ٓ����";
				switch (QkanMessageList.getInstance()
						.WARNING_OF_CANCELLATION_UNSETTLED_DATA(msgParam)) {
				// �uOK�v�Ȃ�j��
				case ACMessageBox.RESULT_OK:
					break;
				// �uCANCEL�v�Ȃ珈�����f
				case ACMessageBox.RESULT_CANCEL:
					return;
				}
			}

			// ���̓`�F�b�N���s���B
			if (!isValidInputPatient()) {
				// ���̓G���[���������ꍇ
				// �����𒆒f����B(�I��)
				return;
			}

			// �ۑ��������s���B
			if (!doSave()) {
				// �p�b�V�u�G���[�̏ꍇ
				return;
			}

			// �ۑ�����������I�������ꍇ
			// ��ʂ̐ݒ���s���B
			casualInitialize();

			// �ŐV�̃f�[�^���擾����B
			doFind();

			// �������b�Z�[�W��\������B
			// �E���b�Z�[�WID�FUPDATE_SUCCESSED
			QkanMessageList.getInstance().UPDATE_SUCCESSED();

		} catch (Exception ex) {
			// �ۑ�����������I�����Ȃ������ꍇ
			// �������I������B�i�������Ȃ��j
			throw ex;
		}

	}

	/**
	 * �u��ʑS�̃N���A�����v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void clearInsertModeActionPerformed(ActionEvent e)
			throws Exception {

		// �ύX�`�F�b�N�i�X�i�b�v�V���b�g�̃`�F�b�N�A��ʃe�[�u���̃`�F�b�N�j
		if (getSnapshot().isModified() || getIdouTableChangeFlg() == 1
				|| getKaigoTableChangeFlg() == 1) {
			// �Ō�ɕۑ�����Ă���A���ځE��ʃe�[�u�����ύX����Ă���ꍇ(���L�̂����ꂩ�̏ꍇ�j
			// �EisModified
			// �EidouTableChangeFlg = 1
			// �EkaigoTableChangeFlg = 1

			// �����m�F���b�Z�[�W��\������B
			// �E���b�Z�[�WID�FWARNING_OF_CLEAR_ON_MODIFIED
			switch (QkanMessageList.getInstance()
					.WARNING_OF_CLEAR_ON_MODIFIED()) {

			case ACMessageBox.RESULT_CANCEL:
				// �u�L�����Z���v��I�������ꍇ
				// �����𒆒f����i�������Ȃ��j�B
				return;

			}
		}

		// ��ʑS�̃N���A�������s���B
		doClear();

	}

	/**
	 * �u��ʑS�̃N���A�����v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void clearUpdateModeActionPerformed(ActionEvent e)
			throws Exception {

		// �ύX�`�F�b�N�i�X�i�b�v�V���b�g�̃`�F�b�N�A��ʃe�[�u���̃`�F�b�N�j
		if (getSnapshot().isModified() || getIdouTableChangeFlg() == 1
				|| getKaigoTableChangeFlg() == 1) {
			// �Ō�ɕۑ�����Ă���A���ځE��ʃe�[�u�����ύX����Ă���ꍇ(���L�̂����ꂩ�̏ꍇ�j
			// �EisModified
			// �EidouTableChangeFlg = 1
			// �EkaigoTableChangeFlg = 1

			// �����m�F���b�Z�[�W��\������B
			// �E���b�Z�[�WID�FWARNING_OF_CLEAR_ON_MODIFIED
			switch (QkanMessageList.getInstance()
					.WARNING_OF_CLEAR_ON_MODIFIED()) {

			case ACMessageBox.RESULT_CANCEL:
				// �u�L�����Z���v��I�������ꍇ
				// �����𒆒f����i�������Ȃ��j�B
				return;

			}
		}

		// ��ʑS�̃N���A�������s���B	
		doClear();

	}

	/**
	 * �u��ʑJ�ڏ����v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void toHokanInfoButtonActionPerformed(ActionEvent e)
			throws Exception {

		boolean unsettledInfoExistFlg = false;

		// �ύX�`�F�b�N(�j������\���̂�����)
		if (getSnapShotIdou().isModified() || getSnapShotKaigo().isModified()) {
			unsettledInfoExistFlg = true;
		}

		// ���b�Z�[�W�\���p����
		String msgParam1 = null;
		String msgParam2 = null;

		// ���L�̊m�F���b�Z�[�W��\������B
		if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
			// �V�K�̏ꍇ�iprocessMode�����ʒ萔��PROCESS_MODE_INSERT�j

			// �E���b�Z�[�WID�FQU002_WARNING_OF_TRANSFER
			// �������F"��ÊŌ���"
			// ��j�����F"�o�^"

			msgParam1 = "��ÊŌ���";
			msgParam2 = "�o�^";

		} else if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
			// �ҏW�̏ꍇ�iprocessMode�����ʒ萔��PROCESS_MODE_UPDATE�j

			// �ύX�`�F�b�N�i�X�i�b�v�V���b�g�̃`�F�b�N�A��ʃe�[�u���̃`�F�b�N�j
			if (getSnapshot().isModified()
					|| getIdouTableChangeFlg() == 1
					|| getKaigoTableChangeFlg() == 1 || unsettledInfoExistFlg) {
				// �Ō�ɕۑ�����Ă���A���ځE��ʃe�[�u�����ύX����Ă���ꍇ(���L�̂����ꂩ�̏ꍇ�j
				// �EisModified
				// �EidouTableChangeFlg = 1
				// �EkaigoTableChangeFlg = 1

				// �E���b�Z�[�WID�FQU002_WARNING_OF_TRANSFER
				// �������F"��ÊŌ���"
				// ��j�����F"�X�V"

				msgParam1 = "��ÊŌ���";
				msgParam2 = "�X�V";
			}
		}

		// �������ݒ肳��Ă���ꍇ�A���b�Z�[�W��\������B
		if (!(msgParam1 == null || "".equals(msgParam1))) {

			switch (QkanMessageList.getInstance().QU002_WARNING_OF_TRANSFER(
					msgParam1, msgParam2)) {

			case ACMessageBox.RESULT_OK:
				// �u�͂��v��I�������ꍇ

				try {
					if (unsettledInfoExistFlg) {
						// ���b�Z�[�W�\��
						String msgParam = "�v���F����������͈ٓ����";
						switch (QkanMessageList.getInstance()
								.WARNING_OF_CANCELLATION_UNSETTLED_DATA(
										msgParam)) {
						// �uOK�v�Ȃ�j��
						case ACMessageBox.RESULT_OK:
							break;
						// �uCANCEL�v�Ȃ珈�����f
						case ACMessageBox.RESULT_CANCEL:
							return;
						}
					}

					// ���̓`�F�b�N���s���B
					if (!isValidInputPatient()) {
						// ���̓G���[���������ꍇ
						// �����𒆒f����B(�I��)
						return;
					}

					// �ۑ��������s���B
					if (!doSave()) {
						// �p�b�V�u�G���[�̏ꍇ
						return;
					}

					// �ۑ�����������I�������ꍇ
					// ��ʏ�Ԃ̏��������s���B
					casualInitialize();

					// �ŐV�̃f�[�^���擾����B
					doFind();

				} catch (Exception ex) {
					// �ۑ�����������I�����Ȃ������ꍇ
					// �������I������B�i�������Ȃ��j
					throw ex;
				}

				break;

			case ACMessageBox.RESULT_CANCEL:
				// �u�͂��v�I���ȊO�̏ꍇ
				// �����𔲂���B
				return;

			}
		}

		// �ȉ���n��p�����[�^�Ƃ��āA��ÊŌ����ʁiQU003�j�ɑJ�ڂ���B
		// �EKEY�FPATIENT_ID�@VALUE�FpatientId
		// �EKEY�FPROCESS_START�@VALUE�FprocessStart
		VRMap param = new VRHashMap();
		VRBindPathParser.set("PATIENT_ID", param, new Integer(getPatientId()));
		VRBindPathParser.set("PROCESS_START", param, getProcessStart());

		ACAffairInfo affair = new ACAffairInfo(QU003.class.getName(), param);

		ACFrame.getInstance().next(affair);

	}

	/**
	 * �u��ʑJ�ڏ����v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void toKohiInfoButtonActionPerformed(ActionEvent e)
			throws Exception {

		boolean unsettledInfoExistFlg = false;

		// �ύX�`�F�b�N(�j������\���̂�����)
		if (getSnapShotIdou().isModified() || getSnapShotKaigo().isModified()) {
			unsettledInfoExistFlg = true;
		}

		// ���b�Z�[�W�\���p����
		String msgParam1 = null;
		String msgParam2 = null;

		// ���L�̊m�F���b�Z�[�W��\������B
		if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
			// �V�K�̏ꍇ�iprocessMode�����ʒ萔��PROCESS_MODE_INSERT�j
			// �E���b�Z�[�WID�FQU002_WARNING_OF_TRANSFER
			// �������F"����E�Е��y�����"
			// ��j�����F"�o�^"

			msgParam1 = "����E�Е��y�����";
			msgParam2 = "�o�^";

		} else if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
			// �ҏW�̏ꍇ�iprocessMode�����ʒ萔��PROCESS_MODE_UPDATE�j

			// �ύX�`�F�b�N�i�X�i�b�v�V���b�g�̃`�F�b�N�A��ʃe�[�u���̃`�F�b�N�j
			if (getSnapshot().isModified()
					|| getIdouTableChangeFlg() == 1
					|| getKaigoTableChangeFlg() == 1 || unsettledInfoExistFlg) {
				// �Ō�ɕۑ�����Ă���A���ځE��ʃe�[�u�����ύX����Ă���ꍇ(���L�̂����ꂩ�̏ꍇ�j
				// �Enot isModified
				// �EidouTableChangeFlg = 1
				// �EkaigoTableChangeFlg = 1

				// �E���b�Z�[�WID�FQU002_WARNING_OF_TRANSFER
				// �������F"����E�Е��y�����"
				// ��j�����F"�X�V"

				msgParam1 = "����E�Е��y�����";
				msgParam2 = "�X�V";
			}
		}

		// �������ݒ肳��Ă���ꍇ�A���b�Z�[�W��\������B
		if (!(msgParam1 == null || "".equals(msgParam1))) {

			switch (QkanMessageList.getInstance().QU002_WARNING_OF_TRANSFER(
					msgParam1, msgParam2)) {

			case ACMessageBox.RESULT_OK:
				// �u�͂��v��I�������ꍇ

				try {
					if (unsettledInfoExistFlg) {
						// ���b�Z�[�W�\��
						String msgParam = "�v���F����������͈ٓ����";
						switch (QkanMessageList.getInstance()
								.WARNING_OF_CANCELLATION_UNSETTLED_DATA(
										msgParam)) {
						// �uOK�v�Ȃ�j��
						case ACMessageBox.RESULT_OK:
							break;
						// �uCANCEL�v�Ȃ珈�����f
						case ACMessageBox.RESULT_CANCEL:
							return;
						}
					}

					// ���̓`�F�b�N���s���B
					if (!isValidInputPatient()) {
						// ���̓G���[���������ꍇ
						// �����𒆒f����B(�I��)
						return;
					}

					// �ۑ��������s���B
					if (!doSave()) {
						// �p�b�V�u�G���[�̏ꍇ
						return;
					}

					// �ۑ�����������I�������ꍇ
					// ��ʏ�Ԃ̏��������s���B
					casualInitialize();

					// �ŐV�̃f�[�^���擾����B
					doFind();

				} catch (Exception ex) {
					// �ۑ�����������I�����Ȃ������ꍇ
					// �������I������B�i�������Ȃ��j
					throw ex;
				}

				break;

			case ACMessageBox.RESULT_CANCEL:
				// �u�͂��v�I���ȊO�̏ꍇ
				// �����𔲂���B
				return;

			}
		}

		// �ȉ���n��p�����[�^�Ƃ��āA����E�Е��y������ʁiQU004�j�ɑJ�ڂ���B
		// �EKEY�FPATIENT_ID�@VALUE�FpatientId
		// �EKEY�FPROCESS_START�@VALUE�FprocessStart
		VRMap param = new VRHashMap();
		VRBindPathParser.set("PATIENT_ID", param, new Integer(getPatientId()));
		VRBindPathParser.set("PROCESS_START", param, getProcessStart());

		ACAffairInfo affair = new ACAffairInfo(QU004.class.getName(), param);

		ACFrame.getInstance().next(affair);

	}

	/**
	 * �u�Ώۃ��R�[�h��\���v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void idouInfoTableSelectionChanged(ListSelectionEvent e)
			throws Exception {

		VRMap map = new VRHashMap();

		if (!getIdouInfoTable().isSelected()) {
			// ��ʃe�[�u���̍s��I�����Ă��Ȃ��ꍇ
			// Enable������s���B
			// �E���ID�FENABLE_IDOU_BUTTON_FALSE
			setState_ENABLE_IDOU_BUTTON_FALSE();

			// ��ʂ̃\�[�X�𐶐�����B
			map = (VRMap) getIdouInfo().createSource();

		} else {
			// ��ʃe�[�u���̍s��I�����Ă���ꍇ
			// �E���ID�FENABLE_IDOU_BUTTON_TRUE
			// Enable������s���B
			setState_ENABLE_IDOU_BUTTON_TRUE();

			// �I������Ă��郌�R�[�h���擾����B
			map = (VRMap) getIdouInfoTable().getSelectedModelRowValue();

		}

		// �u�ٓ����̈�iidouInfo�j�v�̃\�[�X�Ƃ��Đݒ肷��B
		getIdouInfo().setSource(map);

		// ��ʂɓW�J����B
		getIdouInfo().bindSource();

		// �X�i�b�v�V���b�g
		getSnapShotIdou().snapshot();

	}

	/**
	 * �u�N���A�����v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void idouInfoButtonClearActionPerformed(ActionEvent e)
			throws Exception {

		if (getIdouInfoTable().isSelected()) {
			// ��ʃe�[�u�����I������Ă���ꍇ
			// ��ʃe�[�u���̍s�𖢑I���̏�Ԃɐݒ肷��B
			getIdouInfoTable().clearSelection();
		} else {
			VRMap map = new VRHashMap();

			// ��ʂ̃\�[�X�𐶐�����B
			map = (VRMap) getIdouInfo().createSource();

			// �u�ٓ����̈�iidouInfo�j�v�̃\�[�X�Ƃ��Đݒ肷��B
			getIdouInfo().setSource(map);

			// ��ʂɓW�J����B
			getIdouInfo().bindSource();

			// �X�i�b�v�V���b�g
			getSnapShotIdou().snapshot();
		}

		// �ٓ��̈�̏�Ԃ�����������B
		setState_IDOU_INIT();

	}

	/**
	 * �u�ǉ������v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void idouInfoButtonInsertActionPerformed(ActionEvent e)
			throws Exception {

		// ���̓`�F�b�N���s���B
		if (!isValidInputIdou()) {
			// ���̓G���[���������ꍇ
			// �����𒆒f����B
			return;
		}

		// ���̓G���[���Ȃ������ꍇ
		// ��ÊŌ�̖K��I���łȂ��ꍇ(���ԃe�L�X�g�������̏ꍇ)
		// �u���ԁv�̒l�ɋ󕶎���������B
		if (!getIdouInfoTime().isEnabled()) {
			getIdouInfoTime().setText("");
		}

		// �擾�����f�[�^�̈ٓ����R���u���̑��v�ȊO�̏ꍇ�i���̑����e�e�L�X�g����\���̏ꍇ�j
		// �u���̑��@���e�v�̒l�ɋ󕶎���������B    
		if (!getIdouInfoReasonMemo().getParent().isVisible()) {
			getIdouInfoReasonMemo().setText("");
		}

		// ���HashMap�𐶐����A�u�ٓ����̈�iidouInfo�j�v�̃\�[�X�Ƃ��Đݒ肷��B
		VRMap map = new VRHashMap();
		getIdouInfo().setSource(map);

		// ���͂��ꂽ�f�[�^���\�[�X�ɗ������݁A�f�[�^���擾����B
		getIdouInfo().applySource();

		// idouHistoryList�����������[�v���ACHANGES_HISTORY_ID�̍ő�l+1�̒l���擾����B
		int maxId = 0;

		// �ő�l�̎擾
		if (!(getIdouHistoryList() == null || getIdouHistoryList().size() == 0)) {

			// ��ʃe�[�u���Ɋ��Ƀf�[�^�����݂��Ă���ꍇ    	
			for (int i = 0; i < getIdouHistoryList().size(); i++) {

				int target = ACCastUtilities.toInt(VRBindPathParser.get(
						"CHANGES_HISTORY_ID", (VRMap) getIdouHistoryList().get(
								i)));

				// ��r�Ώۂ���r�����傫���l�̏ꍇ
				if (maxId < target) {
					// ��r�Ώۂ��r���Ƃ���B
					maxId = target;
				}

			}
		}

		// �擾�����l���A�擾�����ٓ�����KEY�FCHANGES_HISTORY_ID�Őݒ肷��B
		VRBindPathParser.set("CHANGES_HISTORY_ID", map, new Integer(maxId + 1));

		// ���p��ID�̐ݒ�
		if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
			// �X�V���[�h�̏ꍇ	
			// �擾�����f�[�^��KEY�FPATIENT_ID�@VALUE�Fpatientid��ݒ肷��B
			VRBindPathParser
					.set("PATIENT_ID", map, new Integer(getPatientId()));
		}

		// �e�[�u���\���p�ɕҏW����B
		map = toIdouTableList(map);

		// �擾�����f�[�^��idouHistoryList�ɒǉ�����B
		getIdouHistoryList().add(map);

		// �ǉ��s�̃C���f�b�N�X��ޔ�(�ŏI�s�̃C���f�b�N�X)
		int selectedRow = getIdouHistoryList().size() - 1;

		// �ȉ��̏����ňٓ����e�[�u���̃\�[�g���s���B
		// CHANGES_DATE�i�ٓ����t�j�@DESC
		getIdouInfoTable().sort("CHANGES_DATE DESC");

		// �ޔ����Ă����C���f�b�N�X�̍s��I��
		getIdouInfoTable().setSelectedModelRow(selectedRow);

		// idouTableChangeFlg��1�i�ύX����j��������B
		setIdouTableChangeFlg(1);

	}

	/**
	 * �u�ҏW�����v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void idouInfoButtonEditActionPerformed(ActionEvent e)
			throws Exception {

		// ���̓`�F�b�N���s���B
		if (!isValidInputIdou()) {
			// ���̓G���[���������ꍇ
			// �����𒆒f����B
			return;
		}

		// ���̓G���[���Ȃ������ꍇ
		// ��ÊŌ�̖K��I���łȂ��ꍇ(���ԃe�L�X�g�������̏ꍇ)
		// �u���ԁv�̒l�ɋ󕶎���������B
		if (!getIdouInfoTime().isEnabled()) {
			getIdouInfoTime().setText("");
		}

		// �擾�����f�[�^�̈ٓ����R���u���̑��v�ȊO�̏ꍇ�i���̑����e�e�L�X�g����\���̏ꍇ�j
		// �u���̑��@���e�v�̒l�ɋ󕶎���������B    
		if (!getIdouInfoReasonMemo().getParent().isVisible()) {
			getIdouInfoReasonMemo().setText("");
		}

		// �I���s�̃C���f�b�N�X��ޔ�
		int selectedRow = getIdouInfoTable().getSelectedModelRow();

		// ���͂��ꂽ�f�[�^���擾����B
		VRMap map = new VRHashMap();
		getIdouInfo().setSource(map);
		getIdouInfo().applySource();

		// �I���s�̃f�[�^���擾����B
		VRMap temp = (VRMap) getIdouHistoryList().get(selectedRow);

		// �I���s�̃f�[�^���A��ʏ�ɂȂ��f�[�^����ʏ�f�[�^�Ɉڂ��B
		VRBindPathParser.set("PATIENT_ID", map, new Integer(getPatientId()));
		VRBindPathParser.set("CHANGES_HISTORY_ID", map, VRBindPathParser.get(
				"CHANGES_HISTORY_ID", temp));

		// �e�[�u���\���p�ɕҏW����B
		map = toIdouTableList(map);

		// �I���s�ɉ�ʏ�̃f�[�^��ݒ肷��B
		getIdouHistoryList().setData(selectedRow, map);

		// �ȉ��̏����ňٓ����e�[�u���̃\�[�g���s���B
		// CHANGES_DATE�i�ٓ����t�j�@DESC
		getIdouInfoTable().sort("CHANGES_DATE DESC");

		// �I������Ă����s��I��
		getIdouInfoTable().setSelectedModelRow(selectedRow);

		// idouTableChangeFlg��1�i�ύX����j��������B
		setIdouTableChangeFlg(1);

	}

	/**
	 * �u�폜�����v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void idouInfoButtonDeleteActionPerformed(ActionEvent e)
			throws Exception {

		if (!(getIdouHistoryList() == null || getIdouHistoryList().size() == 0)) {
			// �m�F���b�Z�[�W��\������B
			// �@�E���b�Z�[�WID�FWARNING_OF_DELETE_SELECTION
			switch (QkanMessageList.getInstance().WARNING_OF_DELETE_SELECTION()) {

			case ACMessageBox.RESULT_OK:
				// �u�͂��v��I�������ꍇ
				// �I������Ă��郌�R�[�h�̉�ʏ�̃C���f�b�N�X
				int sortedRow = getIdouInfoTable().getSelectedSortedRow();

				// �I������Ă��郌�R�[�h��idouHistoryList����폜����B
				getIdouHistoryList().remove(
						getIdouInfoTable().getSelectedModelRow());

				// �폜���ꂽ�s��1�s��̍s��I������B
				getIdouInfoTable().setSelectedSortedRowOnAfterDelete(sortedRow);

				// idouTableChangeFlg��1�i�ύX����j��������B
				setIdouTableChangeFlg(1);

				break;

			case ACMessageBox.RESULT_CANCEL:
				// �u�L�����Z���v��I�������ꍇ
				// �����𔲂���B�i�������Ȃ��j
				break;
			}
		}
	}

	/**
	 * �u�Ώۃ��R�[�h��\���v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void kaigoInfoTableSelectionChanged(ListSelectionEvent e)
			throws Exception {

		VRMap map = new VRHashMap();

		if (!getKaigoInfoTable().isSelected()) {
			// ��ʃe�[�u���̍s��I�����Ă��Ȃ��ꍇ

			// Enable������s���B
			// �E���ID�FENABLE_KAIGO_BUTTON_FALSE
			setState_ENABLE_KAIGO_BUTTON_FALSE();

			// ��ʂ̃\�[�X�𐶐�����B
			map = (VRMap) getKaigoInfo().createSource();

			// ���t���ɂ̓f�t�H���g�l�F90��ݒ肷��B
			VRBindPathParser.set("INSURE_RATE", map, "90");

		} else {
			// ��ʃe�[�u���̍s��I�����Ă���ꍇ

			// Enable������s���B
			// �E���ID�FENABLE_KAIGO_BUTTON_TRUE
			setState_ENABLE_KAIGO_BUTTON_TRUE();

			// �I������Ă��郌�R�[�h���擾����B
			map = (VRMap) getKaigoInfoTable().getSelectedModelRowValue();

		}

		// �u�����̈�ikaigoInfo�j�v�̃\�[�X�Ƃ��Đݒ肷��B
		getKaigoInfo().setSource(map);

		// ��ʂɓW�J����B
		getKaigoInfo().bindSource();

		// �X�i�b�v�V���b�g
		getSnapShotKaigo().snapshot();

	}

	/**
	 * �u�N���A�����v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void kaigoInfoButtonClearActionPerformed(ActionEvent e)
			throws Exception {

		if (getKaigoInfoTable().isSelected()) {
			// ��ʃe�[�u�����I������Ă���ꍇ
			// ��ʃe�[�u���̍s�𖢑I���̏�Ԃɐݒ肷��B
			getKaigoInfoTable().clearSelection();

		} else {
			VRMap map = new VRHashMap();

			// ��ʂ̃\�[�X�𐶐�����B
			map = (VRMap) getKaigoInfo().createSource();

			// ���t��
			VRBindPathParser.set("INSURE_RATE", map, "90");

			// �u�����̈�ikaigoInfo�j�v�̃\�[�X�Ƃ��Đݒ肷��B
			getKaigoInfo().setSource(map);

			// ��ʂɓW�J����B
			getKaigoInfo().bindSource();

			// �X�i�b�v�V���b�g
			getSnapShotKaigo().snapshot();
		}

	}

	/**
	 * �u�ǉ������v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void kaigoInfoButtonInsertActionPerformed(ActionEvent e)
			throws Exception {

		// �v���x���`�F�b�N
		if (getKaigoInfoYokaigoInfo().isSelected()) {
			VRMap temp = (VRMap) getKaigoInfoYokaigoInfo()
					.getSelectedModelItem();
			int jotaiCode = ACCastUtilities.toInt(VRBindPathParser.get(
					"JOTAI_CODE", temp));
			if (jotaiCode == YOUKAIGODO_HIGAITOU) {
				// ��Y�����I������Ă���ꍇ�@���ǉ��E�ҏW�����Ŏg�p����B
				setNonCorrespondenceFlg(1);
			} else {
				setNonCorrespondenceFlg(0);
			}
		}

		// ���̓`�F�b�N���s���B
		if (!isValidInputKaigo(CHECK_MODE_INSERT)) {
			// ���̓G���[���������ꍇ
			// �����𒆒f����B
			return;
		}

		// ���̓G���[���Ȃ������ꍇ

		// �u����T�[�r�X�v��쐬�ҁv���W�I�ŁA�u��ی��ҁv���I������Ă���ꍇ
		// ���u������x�����Ə����v�R���{�������̏ꍇ
		// �u������x�����Ə����v�R���{�𖢑I���ɐݒ肷��B
		if (!getKaigoInfoKyotakuServicePlanCombo().isEnabled()) {
			getKaigoInfoKyotakuServicePlanCombo().setSelectedItem(null);
		}

		// ���HashMap�𐶐����A�u�����̈�ikaigoInfo�j�v�̃\�[�X�Ƃ��Đݒ肷��B
		VRMap map = new VRHashMap();
		getKaigoInfo().setSource(map);

		// ���͂��ꂽ�f�[�^���\�[�X�ɗ������݁A�f�[�^���擾����B
		getKaigoInfo().applySource();

		// kaigoHistoryList�����������[�v���ANINTEI_HISTORY_ID�̍ő�l+1�̒l���擾����B
		int maxId = 0;

		//�ő�l�̎擾
		if (!(getKaigoHistoryList() == null || getKaigoHistoryList().size() == 0)) {

			// ��ʃe�[�u���Ɋ��Ƀf�[�^�����݂��Ă���ꍇ    	
			for (int i = 0; i < getKaigoHistoryList().size(); i++) {

				int target = ACCastUtilities.toInt(VRBindPathParser.get(
						"NINTEI_HISTORY_ID", (VRMap) getKaigoHistoryList().get(
								i)));

				// ��r�Ώۂ���r�����傫���l�̏ꍇ
				if (maxId < target) {
					// ��r�Ώۂ��r���Ƃ���B
					maxId = target;
				}

			}
		}

		// �擾�����l���A�擾�����F�����KEY�FNINTEI_HISTORY_ID�Őݒ肷��B
		VRBindPathParser.set("NINTEI_HISTORY_ID", map, new Integer(maxId + 1));

		// ���p��ID�̐ݒ�
		if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
			// �X�V���[�h�̏ꍇ	
			// �擾�����f�[�^��KEY�FPATIENT_ID�@VALUE�Fpatientid��ݒ肷��B
			VRBindPathParser
					.set("PATIENT_ID", map, new Integer(getPatientId()));
		}

		//    if(getNonCorrespondenceFlg() == 0){
		//    	// ��ی��Ҕԍ����uH�`�v�ƂȂ��Ă���ꍇ�@����Y���̏ꍇ�͓�������ʂ�Ȃ�
		//	    // ��ی��Ҕԍ�
		//	    String insuredId = 
		//	    	ACCastUtilities.toString(VRBindPathParser.get("INSURED_ID", map));
		//	    
		//	    // ���t��
		//	    int insureRate = 0;
		//	    	insureRate = ACCastUtilities.toInt(VRBindPathParser.get("INSURE_RATE", map));
		//	    	
		//	    if(insuredId.charAt(0) == 'H'){
		//	    	if(insureRate != INSURE_RATE_SEIHO){
		//		    	// ���t�����u0%�v�ƂȂ��Ă��Ȃ��ꍇ
		//	    		if (QkanMessageList.getInstance()
		//							.QU002_WARNING_OF_CHANGE_RATE_FOR_SEIHO_TANDOKU() == ACMessageBox.RESULT_YES) {
		//					// ���t�����u0%�v�ɐݒ肷��B
		//					VRBindPathParser.set("INSURE_RATE", map, new Integer(INSURE_RATE_SEIHO));
		//				}
		//	    	}
		//			// ����o�^�����Ȃ������b�Z�[�W��\������B	
		//	    	// �E���b�Z�[�WID�FQU002_REQUEST_TO_INSERT_SEIHO
		//			QkanMessageList.getInstance().QU002_REQUEST_TO_INSERT_SEIHO();
		//	    }
		//    }

		// �e�[�u���\���p�ɕҏW
		map = toKaigoTableList(map);

		// �v���x����Y���̏ꍇ�A����E�������t��L�����Ԃɐݒ肷��B
		if (getNonCorrespondenceFlg() == 1) {
			setMaxAndMinDate(map);
		}

		// String����Integer�Ɍ^�ϊ��@���\�[�g���΍�
		final String[] keys = new String[] { "INSURE_RATE", "LIMIT_RATE",
				"EXTERNAL_USE_LIMIT" };
		QkanCommon.convertValueFromStringToInteger(map, keys);

		// �擾�����f�[�^��kaigoHistoryList�ɒǉ�����B
		getKaigoHistoryList().add(map);

		// �ǉ��s�̃C���f�b�N�X��ޔ�(�ŏI�s�̃C���f�b�N�X)
		int selectedRow = getKaigoHistoryList().size() - 1;

		// �ȉ��̏����ŉ����e�[�u���̃\�[�g���s���B
		// INSURE_VALID_START�i�L�����ԊJ�n�j�@DESC
		getKaigoInfoTable().sort("INSURE_VALID_START DESC");

		// �ǉ��s��I��
		getKaigoInfoTable().setSelectedModelRow(selectedRow);

		// kaigoTableChangeFlg��1�i�ύX����j��������B
		setKaigoTableChangeFlg(1);

		// ��Y���t���O��������
		setNonCorrespondenceFlg(0);

		// �V�X�e�����t�ɂ����ėL���ȗv���x��\������B
		displayNowYokaigodo();

	}

	/**
	 * �u�ҏW�����v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void kaigoInfoButtonEditActionPerformed(ActionEvent e)
			throws Exception {

		// �v���x���`�F�b�N
		if (getKaigoInfoYokaigoInfo().isSelected()) {
			VRMap temp = (VRMap) getKaigoInfoYokaigoInfo()
					.getSelectedModelItem();
			int jotaiCode = ACCastUtilities.toInt(VRBindPathParser.get(
					"JOTAI_CODE", temp));
			if (jotaiCode == YOUKAIGODO_HIGAITOU) {
				// ��Y�����I������Ă���ꍇ�@���ǉ��E�ҏW�����Ŏg�p����B
				setNonCorrespondenceFlg(1);
			} else {
				setNonCorrespondenceFlg(0);
			}
		}

		// ���̓`�F�b�N���s���B
		if (!isValidInputKaigo(CHECK_MODE_UPDATE)) {
			// ���̓G���[���������ꍇ
			// �����𒆒f����B
			return;
		}

		// ���̓G���[���Ȃ������ꍇ      
		// �u����T�[�r�X�v��쐬�ҁv���W�I�ŁA�u��ی��ҁv���I������Ă���ꍇ
		// ���u������x�����Ə����v�R���{�������̏ꍇ
		// �u������x�����Ə����v�R���{�𖢑I���ɐݒ肷��B
		if (!getKaigoInfoKyotakuServicePlanCombo().isEnabled()) {
			getKaigoInfoKyotakuServicePlanCombo().setSelectedItem(null);
		}

		// �I���s�̃C���f�b�N�X��ޔ�
		int selectedRow = getKaigoInfoTable().getSelectedModelRow();

		// ��ʏ�̃f�[�^���擾����B
		VRMap map = new VRHashMap();

		getKaigoInfo().setSource(map);
		getKaigoInfo().applySource();

		// �I���s�̃f�[�^���擾����B
		VRMap temp = (VRMap) getKaigoHistoryList().get(selectedRow);

		// �I���s�̃f�[�^����ʏ�ɂȂ��f�[�^����ʏ�f�[�^�Ɉڂ��B
		VRBindPathParser.set("PATIENT_ID", map, new Integer(getPatientId()));
		VRBindPathParser.set("NINTEI_HISTORY_ID", map, VRBindPathParser.get(
				"NINTEI_HISTORY_ID", temp));

		//    if(getNonCorrespondenceFlg() == 0){
		//	    // ��ی��Ҕԍ����uH�`�v�ƂȂ��Ă���ꍇ
		//	
		//	    // ��ی��Ҕԍ�
		//	    String insuredId = 
		//	    	ACCastUtilities.toString(VRBindPathParser.get("INSURED_ID", map));
		//	    
		//	    // ���t��
		//	    int insureRate = 0;
		//	    insureRate = ACCastUtilities.toInt(VRBindPathParser.get("INSURE_RATE", map));
		//		    
		//	    if(insuredId.charAt(0) == 'H'){
		//	    	if(insureRate != INSURE_RATE_SEIHO){
		//		    	// ���t�����u0%�v�ƂȂ��Ă��Ȃ��ꍇ
		//	    		if (QkanMessageList.getInstance()
		//						.QU002_WARNING_OF_CHANGE_RATE_FOR_SEIHO_TANDOKU() == ACMessageBox.RESULT_YES) {
		//		    		// ���t�����u0%�v�ɐݒ肷��B
		//		    		VRBindPathParser.set("INSURE_RATE", map, new Integer(INSURE_RATE_SEIHO));
		//	    		}
		//	    	}
		//			// ����o�^�����Ȃ������b�Z�[�W��\������B	
		//	    	// �E���b�Z�[�WID�FQU002_REQUEST_TO_INSERT_SEIHO
		//			QkanMessageList.getInstance().QU002_REQUEST_TO_INSERT_SEIHO();
		//	    }
		//    }

		// �e�[�u���\���p�ɕҏW����B
		map = toKaigoTableList(map);

		// �v���x����Y���̏ꍇ�A����E�������t��L�����Ԃɐݒ肷��B
		if (getNonCorrespondenceFlg() == 1) {
			setMaxAndMinDate(map);
		}

		// String����Integer�Ɍ^�ϊ��@���\�[�g���΍�
		final String[] keys = new String[] { "INSURE_RATE", "LIMIT_RATE",
				"EXTERNAL_USE_LIMIT" };
		QkanCommon.convertValueFromStringToInteger(map, keys);

		// �I���s�ɉ�ʏ�̃f�[�^��ݒ肷��B
		getKaigoHistoryList().setData(selectedRow, map);

		// �ȉ��̏����ŉ����e�[�u���̃\�[�g���s���B
		// INSURE_VALID_START�i�L�����ԊJ�n�j�@DESC
		getKaigoInfoTable().sort("INSURE_VALID_START DESC");

		// �I������Ă����s��I��
		getKaigoInfoTable().setSelectedModelRow(selectedRow);

		// kaigoTableChangeFlg��1�i�ύX����j��������B
		setKaigoTableChangeFlg(1);

		// ��Y���t���O��������
		setNonCorrespondenceFlg(0);

		// �V�X�e�����t�ɂ����ėL���ȗv���x��\������B
		displayNowYokaigodo();

	}

	/**
	 * �u����A�������t�ݒ�v�����ł��B
	 * @param VRMap �l���l�ߍ��݂���VRMap
	 * @throws Exception ������O
	 */
	public void setMaxAndMinDate(VRMap map) throws Exception {
		// ��Y���̏ꍇ�̏���

		// �L�����ԊJ�n�������͂���Ă��Ȃ��ꍇ
		// �������t�������ݒ�
		if (ACTextUtilities.isNullText(getKaigoInfoValidLimit1().getText())) {
			VRBindPathParser.set("INSURE_VALID_START", map, MIN_DATE);
		}

		// �L�����ԏI���������͂���Ă��Ȃ��ꍇ
		// ������t�������ݒ�
		if (ACTextUtilities.isNullText(getKaigoInfoValidLimit3().getText())) {
			VRBindPathParser.set("INSURE_VALID_END", map, MAX_DATE);
		}
	}

	/**
	 * �u�폜�����v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void kaigoInfoDeleteActionPerformed(ActionEvent e)
			throws Exception {

		if (!(getKaigoHistoryList() == null || getKaigoHistoryList().size() == 0)) {

			// �m�F���b�Z�[�W��\������B
			// �E���b�Z�[�WID�FWARNING_OF_DELETE_SELECTION
			switch (QkanMessageList.getInstance().WARNING_OF_DELETE_SELECTION()) {
			case ACMessageBox.RESULT_OK:
				// �u�͂��v��I�������ꍇ

				// �I���s�f�[�^���擾����B
				VRMap map = (VRMap) getKaigoInfoTable()
						.getSelectedModelRowValue();
				int jotaiCode = ACCastUtilities.toInt(VRBindPathParser.get(
						"JOTAI_CODE", map));

				// ��Y���łȂ��ꍇ
				if (jotaiCode != YOUKAIGODO_HIGAITOU) {

					// �L�����Ԓ��̃T�[�r�X�\��E���т̃��R�[�h���擾���邽�߂�HashMap�Fparam�𐶐����A���L��KEY/VALUE��ݒ肷��B
					// �EKEY�FPATIENT_ID�@VALUE�FpatientId
					// �EKEY�FVALID_START�@VALUE�F�i�L�����ԊJ�n�j
					// �EKEY�FVALID_END�@VALUE�F�i�L�����ԏI���j
					VRMap param = new VRHashMap();
					VRBindPathParser.set("PATIENT_ID", param, new Integer(
							getPatientId()));
					VRBindPathParser.set("VALID_START", param, VRBindPathParser
							.get("INSURE_VALID_START", map));
					VRBindPathParser.set("VALID_END", param, VRBindPathParser
							.get("INSURE_VALID_END", map));

					// �L�����Ԓ��̃T�[�r�X�\��E���т̃��R�[�h���擾����B
					String strSql = getSQL_GET_PATIENT_RESERVED_SERVICE(param);
					VRList list = getDBManager().executeQuery(strSql);

					if (!(list == null || list.size() == 0)) {
						// ���R�[�h��1���ȏゾ�����ꍇ
						// �G���[���b�Z�[�W��\������B
						// �E���b�Z�[�WID�FQU002_ERROR_OF_RESERVED_SERVICE
						String msgParam = "�ҏW";
						switch (QkanMessageList.getInstance()
								.QU002_WARNING_OF_OUT_OF_VALID(msgParam)) {
						case ACMessageBox.RESULT_CANCEL:
							return;
						}
					}
				}

				// ���R�[�h��0���������ꍇ
				// �I������Ă��郌�R�[�h�̉�ʏ�̃C���f�b�N�X
				int sortedRow = getKaigoInfoTable().getSelectedSortedRow();

				// �I������Ă��郌�R�[�h��kaigoHistoryList����폜����B
				getKaigoHistoryList().remove(
						getKaigoInfoTable().getSelectedModelRow());

				// �폜���ꂽ�s��1�s���I������B
				getKaigoInfoTable()
						.setSelectedSortedRowOnAfterDelete(sortedRow);

				// kaigoTableChangeFlg��1�i�ύX����j��������B
				setKaigoTableChangeFlg(1);

				// �V�X�e�����t�ɂ����ėL���ȗv���x��\������B
				displayNowYokaigodo();

				break;

			case ACMessageBox.RESULT_CANCEL:
				// �u�������v��I�������ꍇ
				// �����𔲂���B�i�������Ȃ��j
				break;

			}
		}
	}

	/**
	 * �u��ʏ����v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void idouInfoServiseActionPerformed(ActionEvent e)
			throws Exception {

		VRList list = new VRArrayList();

		// �I�����ꂽ�T�[�r�X�ɂ��ٓ����R�R���{�iidouInfoChangeContent�j�ɉ��L��CODE_ID�̑I���}��ݒ肷��B
		VRMap map = (VRMap) getIdouInfoServise().getSelectedModelItem();

		if (map != null) {

			switch (ACCastUtilities.toInt(VRBindPathParser.get(
					"CHANGES_CONTENT_TYPE", map))) {

			// �E����n�@CODE_ID�FCODE_IDOU_CONTENT_KYOTAKU
			case IDOU_SERVICE_KYOTAKU:
				list = QkanCommon.getArrayFromMasterCode(
						CODE_IDOU_CONTENT_KYOTAKU, "CHANGES_CONTENT");
				break;

			// �E�{�݌n1�@CODE_ID�FCODE_IDOU_CONTENT_SHISETSU1
			case IDOU_SERVICE_SHISETSU1:
				list = QkanCommon.getArrayFromMasterCode(
						CODE_IDOU_CONTENT_SHISETSU1, "CHANGES_CONTENT");
				break;

			// �E�{�݌n2�@CODE_ID�FCODE_IDOU_CONTENT_SHISETSU2
			case IDOU_SERVICE_SHISETSU2:
				list = QkanCommon.getArrayFromMasterCode(
						CODE_IDOU_CONTENT_SHISETSU2, "CHANGES_CONTENT");
				break;

			// �E��ÊŌ�@CODE_ID�FCODE_IDOU_CONTENT_IRYO_KANGO
			case IDOU_SERVICE_IRYO_KANGO:
				list = QkanCommon.getArrayFromMasterCode(
						CODE_IDOU_CONTENT_IRYO_KANGO, "CHANGES_CONTENT");
				break;

			// �E�{�݌n3�@CODE_ID�FCODE_IDOU_CONTENT_SHISETSU3
			case IDOU_SERVICE_SHISETSU3:
				list = QkanCommon.getArrayFromMasterCode(
						CODE_IDOU_CONTENT_SHISETSU3, "CHANGES_CONTENT");
				break;
			}

			getIdouInfoChangeContent().setModel(list);

			// �ٓ��̈揉����
			// �N���A
			getIdouInfoDate().setText("");
			getIdouInfoTime().setText("");
			getIdouInfoReason().setModel(new VRArrayList());
			getIdouInfoReasonMemo().setText("");
			getIdouInfoReasonContainer().setText("���R/��");
			// �ٓ��̈�̏�Ԃ̏�����
			setState_IDOU_INIT();
			// �ٓ����R��L���ɂ���B
			setState_ENABLE_CONTENT_TRUE();

		} else {
			// �ٓ��̈�̏�Ԃ̏�����
			setState_IDOU_INIT();

		}
	}

	/**
	 * �u��ʏ����v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void idouInfoChangeContentActionPerformed(ActionEvent e)
			throws Exception {

		String caption = null;
		VRList list = new VRArrayList();

		VRMap service = (VRMap) getIdouInfoServise().getSelectedModelItem();
		VRMap content = (VRMap) getIdouInfoChangeContent()
				.getSelectedModelItem();

		// �I�����ꂽ�ٓ����R�ɂ��ٓ����R�R���{�iidouInfoReason�j��
		// �L���v�V�����ƑI���}�����L�̂Ƃ���ɐݒ肷��B
		if (service != null && content != null) {

			switch (ACCastUtilities.toInt(VRBindPathParser.get(
					"CHANGES_CONTENT_TYPE", service))) {

			case IDOU_SERVICE_KYOTAKU:
				// ����n�T�[�r�X�̏ꍇ
				if (ACCastUtilities.toInt(VRBindPathParser.get(
						"CHANGES_CONTENT", content)) == IDOU_STOP_KYOTAKU) {
					// �E�u���~�v���I�����ꂽ�ꍇ�@
					// �L���v�V�����F�u���~���R�v�@CODE_ID�FCODE_IDOU_REASON_KYOTAKU
					caption = "���~���R";
					list = QkanCommon.getArrayFromMasterCode(
							CODE_IDOU_REASON_KYOTAKU, "CHANGES_REASON");
					// Enable������s���B
					// �ٓ����R�R���{��L���ɂ���B
					// �E���ID�FsetState_ENABLE_REASON_TRUE
					setState_ENABLE_REASON_TRUE();
					break;
				} else {
					// �u���~�v�ȊO���I�����ꂽ�ꍇ
					caption = "���R/��";
					// Enable������s���B
					// �ٓ����R�R���{�𖳌��ɂ���B
					// �E���ID�FsetState_ENABLE_REASON_FALSE
					setState_ENABLE_REASON_FALSE();
					// ���̑��e�L�X�g���\���ɂ���B
					// �E���ID�FsetState_ENABLE_REASON_FALSE
					setState_VISIBLE_REASON_MEMO_FALSE();
					break;
				}

			case IDOU_SERVICE_SHISETSU1:
				// �{�݌n1�T�[�r�X�̏ꍇ
				if (ACCastUtilities.toInt(VRBindPathParser.get(
						"CHANGES_CONTENT", content)) == IDOU_STOP_SHISETSU1) {
					// �E�u�ޏ��v���I�����ꂽ�ꍇ�@
					// �L���v�V�����F�u�ޏ���̏󋵁v�@CODE_ID�FCODE_IDOU_REASON_SHISETSU1
					caption = "�ޏ���̏�";
					list = QkanCommon.getArrayFromMasterCode(
							CODE_IDOU_REASON_SHISETSU1, "CHANGES_REASON");
					// Enable������s���B
					// �ٓ����R�R���{��L���ɂ���B
					// �E���ID�FsetState_ENABLE_REASON_TRUE
					setState_ENABLE_REASON_TRUE();
					break;
					
					//[ID:0000453][Shin Fujihara] 2009/02 add begin ����21�N4���@�����Ή�
				} else if (ACCastUtilities.toInt(VRBindPathParser.get(
						"CHANGES_CONTENT", content)) == IDOU_START_SHISETSU1) {
					caption = "�����O�̏�";
					list = QkanCommon.getArrayFromMasterCode(CODE_IDOU_REASON_NYUSYO_NYUIN, "CHANGES_REASON");
					setState_ENABLE_REASON_TRUE();
					break;
					//[ID:0000453][Shin Fujihara] 2009/02 add end ����21�N4���@�����Ή�
					
				} else {
					// �u�ޏ��v�ȊO���I�����ꂽ�ꍇ
					caption = "���R/��";
					// Enable������s���B
					// �ٓ����R�R���{�𖳌��ɂ���B
					// �E���ID�FsetState_ENABLE_REASON_FALSE
					setState_ENABLE_REASON_FALSE();
					// ���̑��e�L�X�g���\���ɂ���B
					// �E���ID�FsetState_ENABLE_REASON_FALSE
					setState_VISIBLE_REASON_MEMO_FALSE();
					break;
				}

			case IDOU_SERVICE_SHISETSU2:
				// �{�݌n2�T�[�r�X�̏ꍇ
				if (ACCastUtilities.toInt(VRBindPathParser.get(
						"CHANGES_CONTENT", content)) == IDOU_STOP_SHISETSU2) {
					// �E�u�މ@�v���I�����ꂽ�ꍇ�@
					// �L���v�V�����F�u�މ@��̏󋵁v�@CODE_ID�FCODE_IDOU_REASON_SHISETSU2
					caption = "�މ@��̏�";
					list = QkanCommon.getArrayFromMasterCode(
							CODE_IDOU_REASON_SHISETSU2, "CHANGES_REASON");
					// �ٓ����R�R���{��L���ɂ���B
					// �E���ID�FsetState_ENABLE_REASON_TRUE
					setState_ENABLE_REASON_TRUE();
					break;
					
					//[ID:0000453][Shin Fujihara] 2009/02 add begin ����21�N4���@�����Ή�
				} else 				if (ACCastUtilities.toInt(VRBindPathParser.get(
						"CHANGES_CONTENT", content)) == IDOU_START_SHISETSU2) {
					caption = "���@�O�̏�";
					list = QkanCommon.getArrayFromMasterCode(CODE_IDOU_REASON_NYUSYO_NYUIN, "CHANGES_REASON");
					setState_ENABLE_REASON_TRUE();
					break;
					//[ID:0000453][Shin Fujihara] 2009/02 add end ����21�N4���@�����Ή�
					
				} else {
					// �u�މ@�v�ȊO���I�����ꂽ�ꍇ
					caption = "���R/��";
					// Enable������s���B
					// �ٓ����R�R���{�𖳌��ɂ���B
					// �E���ID�FsetState_ENABLE_REASON_FALSE
					setState_ENABLE_REASON_FALSE();
					// ���̑��e�L�X�g���\���ɂ���B
					// �E���ID�FsetState_ENABLE_REASON_FALSE
					setState_VISIBLE_REASON_MEMO_FALSE();
					break;
				}

			case IDOU_SERVICE_IRYO_KANGO:
				// ��ÊŌ�̏ꍇ
				if (ACCastUtilities.toInt(VRBindPathParser.get(
						"CHANGES_CONTENT", content)) == IDOU_STOP_IRYO_KANGO) {
					// �E�u�I���v���I�����ꂽ�ꍇ�@
					// �L���v�V�����F�u�I���̏󋵁v�@CODE_ID�FCODE_IDOU_REASON_IRYO_KANGO
					caption = "�I���̏�";
					list = QkanCommon.getArrayFromMasterCode(
							CODE_IDOU_REASON_IRYO_KANGO, "CHANGES_REASON");
					// Enable������s���B
					// �ٓ����R�R���{��L���ɂ���B
					// �E���ID�FsetState_ENABLE_REASON_TRUE
					setState_ENABLE_REASON_TRUE();
					// ���ԃe�L�X�g��L���ɂ���B
					// �E���ID�FENABLE_TIME_TRUE
					setState_ENABLE_TIME_TRUE();
					break;
				} else {
					// �u�I���v�ȊO���I�����ꂽ�ꍇ
					caption = "���R/��";
					// Enable������s���B
					// �ٓ����R�R���{�𖳌��ɂ���B
					// �E���ID�FsetState_ENABLE_REASON_FALSE
					setState_ENABLE_REASON_FALSE();
					// ���ԃe�L�X�g�𖳌��ɂ���B
					// �E���ID�FENABLE_TIME_FALSE
					setState_ENABLE_TIME_FALSE();
					// ���̑��e�L�X�g���\���ɂ���B
					// �E���ID�FsetState_ENABLE_REASON_FALSE
					setState_VISIBLE_REASON_MEMO_FALSE();
					break;
				}

			case IDOU_SERVICE_SHISETSU3:
				// �{�݌n3�T�[�r�X�̏ꍇ
				if (ACCastUtilities.toInt(VRBindPathParser.get(
						"CHANGES_CONTENT", content)) == IDOU_STOP_SHISETSU3) {
					// �E�u�ދ��v���I�����ꂽ�ꍇ�@
					// �L���v�V�����F�u�ދ���̏󋵁v�@CODE_ID�FCODE_IDOU_REASON_SHISETSU3
					caption = "�ދ���̏�";
					list = QkanCommon.getArrayFromMasterCode(
							CODE_IDOU_REASON_SHISETSU3, "CHANGES_REASON");
					// �ٓ����R�R���{��L���ɂ���B
					// �E���ID�FsetState_ENABLE_REASON_TRUE
					setState_ENABLE_REASON_TRUE();
					break;
					
					//[ID:0000453][Shin Fujihara] 2009/02 add begin ����21�N4���@�����Ή�
				} else 				if (ACCastUtilities.toInt(VRBindPathParser.get(
						"CHANGES_CONTENT", content)) == IDOU_START_SHISETSU3) {
					caption = "�����O�̏�";
					list = QkanCommon.getArrayFromMasterCode(CODE_IDOU_REASON_NYUSYO_NYUIN, "CHANGES_REASON");
					setState_ENABLE_REASON_TRUE();
					break;
					//[ID:0000453][Shin Fujihara] 2009/02 add end ����21�N4���@�����Ή�
					
				} else {
					// �u�ދ��v�ȊO���I�����ꂽ�ꍇ
					caption = "���R/��";
					// Enable������s���B
					// �ٓ����R�R���{�𖳌��ɂ���B
					// �E���ID�FsetState_ENABLE_REASON_FALSE
					setState_ENABLE_REASON_FALSE();
					// ���̑��e�L�X�g���\���ɂ���B
					// �E���ID�FsetState_ENABLE_REASON_FALSE
					setState_VISIBLE_REASON_MEMO_FALSE();
					break;
				}
			}

			// �L���v�V�����̐ݒ�
			getIdouInfoReasonContainer().setText(caption);

			// �R���{���̐ݒ�
			getIdouInfoReason().setModel(list);

		}

	}

	/**
	 * �u��ʏ����v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void idouInfoReasonActionPerformed(ActionEvent e)
			throws Exception {

		VRMap service = new VRHashMap();
		VRMap reason = new VRHashMap();

		if (getIdouInfoServise().getSelectedModelItem() == null
				|| "".equals(getIdouInfoServise().getSelectedModelItem())) {
			// �T�[�r�X���I������Ă��Ȃ��ꍇ
			setState_VISIBLE_REASON_MEMO_FALSE();
			return;
		}

		if (getIdouInfoReason().getSelectedModelItem() == null
				|| "".equals(getIdouInfoReason().getSelectedModelItem())) {
			// ���R���I������Ă��Ȃ��ꍇ
			setState_VISIBLE_REASON_MEMO_FALSE();
			return;
		}

		service = (VRMap) getIdouInfoServise().getSelectedModelItem();
		reason = (VRMap) getIdouInfoReason().getSelectedModelItem();

		// �ٓ����R�̎��
		int contentType = ACCastUtilities.toInt(VRBindPathParser.get(
				"CHANGES_CONTENT_TYPE", service));
		// ���R/�󋵂̒l
		int reasonValue = ACCastUtilities.toInt(VRBindPathParser.get(
				"CHANGES_REASON", reason));

		switch (contentType) {

		// ����n�̏ꍇ
		case IDOU_SERVICE_KYOTAKU:
			if (reasonValue == IDOU_OTHER_KYOTAKU) {
				// �I�����ꂽ�ٓ����R���u���̑��v�̏ꍇ
				// Visible������s���B
				setState_VISIBLE_REASON_MEMO_TRUE();
				break;
			} else {
				// �I�����ꂽ�ٓ����R���u���̑��v�ȊO�̏ꍇ
				setState_VISIBLE_REASON_MEMO_FALSE();
				break;
			}

		// �{�݌n1�̏ꍇ
		case IDOU_SERVICE_SHISETSU1:
			if (reasonValue == IDOU_OTHER_SHISETSU1) {
				// �I�����ꂽ�ٓ����R���u���̑��v�̏ꍇ
				// Visible������s���B
				setState_VISIBLE_REASON_MEMO_TRUE();
				break;
			} else {
				// �I�����ꂽ�ٓ����R���u���̑��v�ȊO�̏ꍇ
				setState_VISIBLE_REASON_MEMO_FALSE();
				break;
			}

		// �{�݌n2�̏ꍇ
		case IDOU_SERVICE_SHISETSU2:
			if (reasonValue == IDOU_OTHER_SHISETSU2) {
				// �I�����ꂽ�ٓ����R���u���̑��v�̏ꍇ
				// Visible������s���B
				setState_VISIBLE_REASON_MEMO_TRUE();
				break;
			} else {
				// �I�����ꂽ�ٓ����R���u���̑��v�ȊO�̏ꍇ
				setState_VISIBLE_REASON_MEMO_FALSE();
				break;
			}

		// ��ÊŌ�̏ꍇ
		case IDOU_SERVICE_IRYO_KANGO:
			if (reasonValue == IDOU_OTHER_IRYO_KANGO) {
				// �I�����ꂽ�ٓ����R���u���̑��v�̏ꍇ
				// Visible������s���B
				setState_VISIBLE_REASON_MEMO_TRUE();
				break;
			} else {
				// �I�����ꂽ�ٓ����R���u���̑��v�ȊO�̏ꍇ
				setState_VISIBLE_REASON_MEMO_FALSE();
				break;
			}

		// �{�݌n3�̏ꍇ
		case IDOU_SERVICE_SHISETSU3:
			if (reasonValue == IDOU_OTHER_SHISETSU3) {
				// �I�����ꂽ�ٓ����R���u���̑��v�̏ꍇ
				// Visible������s���B
				setState_VISIBLE_REASON_MEMO_TRUE();
				break;
			} else {
				// �I�����ꂽ�ٓ����R���u���̑��v�ȊO�̏ꍇ
				setState_VISIBLE_REASON_MEMO_FALSE();
				break;
			}
		}

	}

	/**
	 * �u�ی��Җ��\���E�x�����x�z�\���v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void kaigoInfoInsurerIdFocusLost(FocusEvent e) throws Exception {

		String insurerId = getKaigoInfoInsurerId().getText();

		// ���͂��ꂽ�ی��Ҕԍ��ɊY������ی��҂����݂���ꍇ
		VRMap map = (VRMap) getKaigoInfoInsurerName().getDataFromBindPath(
				insurerId);

		// �ی��Җ��R���{�ikaigoInfoInsurerName�j�̊Y���ی��҂�I����Ԃɂ���B
		getKaigoInfoInsurerName().setSelectedItem(map);

		// �x�����x�z���x�����x�z�e�L�X�g�t�B�[���h�ikaigoInfoProvideLimit�j�ɕ\������B
		doFindLimitRate();

	}

	/**
	 * �u�ی��Ҕԍ��\���E�x�����x�z�\���v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void kaigoInfoInsurerNameActionPerformed(ActionEvent e)
			throws Exception {

		// �I�����ꂽ�ی��҂̕ی��Ҕԍ���ی��Ҕԍ��t�B�[���h�ikaigoInfoInsurerId�j
		// �ɕ\������B
		VRMap map = (VRMap) getKaigoInfoInsurerName().getSelectedModelItem();

		if (VRBindPathParser.get("INSURER_ID", map) == null) {
			getKaigoInfoInsurerId().setText("");
		} else {
			getKaigoInfoInsurerId().setText(
					ACCastUtilities.toString(VRBindPathParser.get("INSURER_ID",
							map)));
		}

		// �x�����x�z���x�����x�z�e�L�X�g�t�B�[���h�ikaigoInfoProvideLimit�j�ɕ\������B
		doFindLimitRate();

	}

	/**
	 * �u��ʏ����v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void kaigoInfoKyotakuServiceRadioSelectionChanged(
			ListSelectionEvent e) throws Exception {

		switch (getKaigoInfoKyotakuServiceRadio().getSelectedIndex()) {
		case 1:
			// ������x�����Ə��ikaigoInfoKyotakuServiceRadioItem1�j���I�����ꂽ�ꍇ
			// Enable������s���B
			// �E���ID�FENABLE_SHIEN_TRUE
			setState_ENABLE_SHIEN_TRUE();
			// ����T�[�r�X�v��쐬�ҁE�R���{�ikaigoInfoKyotakuServicePlanCombo�j�̌��Ƃ��āAproviderListKaigoShien��ݒ肷��B
			getKaigoInfoKyotakuServicePlanCombo().setModel(
					getProviderListKaigoShien());
			break;
		case 2:
			// ��ی��ҁikaigoInfoKyotakuServiceRadioItem2�j���I�����ꂽ�ꍇ
			// Enable������s���B
			// �E���ID�FENABLE_SHIEN_FALSE
			setState_ENABLE_SHIEN_FALSE();
			break;
		case 3:
			// ������x�����Ə��ikaigoInfoKyotakuServiceRadioItem1�j���I�����ꂽ�ꍇ		
			// Enable������s���B	
			// �E���ID�FENABLE_SHIEN_TRUE
			setState_ENABLE_SHIEN_TRUE();
			// ����T�[�r�X�v��쐬�ҁE�R���{�ikaigoInfoKyotakuServicePlanCombo�j�̌��Ƃ��āAproviderListYobouShien��ݒ肷��B	
			getKaigoInfoKyotakuServicePlanCombo().setModel(
					getProviderListYobouShien());
			break;
		default:
			setState_ENABLE_SHIEN_FALSE();
		}
	}

	/**
	 * �u�x�����x�z�\���v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void kaigoInfoYokaigoInfoActionPerformed(ActionEvent e)
			throws Exception {

		// �x�����x�z���x�����x�z�e�L�X�g�t�B�[���h�ikaigoInfoProvideLimit�j�ɕ\������B
		doFindLimitRate();

		doFindExternalUseLimit();

	}

	/**
	 * �u�x�����x�z�\���v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void kaigoInfoValidLimit1FocusLost(FocusEvent e) throws Exception {

		// �x�����x�z���x�����x�z�e�L�X�g�t�B�[���h�ikaigoInfoProvideLimit�j�ɕ\������B
		doFindLimitRate();

		doFindExternalUseLimit();

	}

	/**
	 * �u�x�����x�z�\���v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void kaigoInfoValidLimit3FocusLost(FocusEvent e) throws Exception {

		// �x�����x�z���x�����x�z�e�L�X�g�t�B�[���h�ikaigoInfoProvideLimit�j�ɕ\������B
		doFindLimitRate();

		doFindExternalUseLimit();

	}

	/**
	 * �u�N��\���v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void basicInfoBirthFocusLost(FocusEvent e) throws Exception {

		// �N���\������B
		VRMap map = new VRHashMap();

		if (ACTextUtilities.isNullText(getBasicInfoBirth().getText())) {
			// �󔒂̏ꍇ
			VRBindPathParser.set("PATIENT_BIRTHDAY", map, "");
		} else if (!getBasicInfoBirth().isValidDate()) {
			// ���݂��Ȃ����t�̏ꍇ
			VRBindPathParser.set("PATIENT_BIRTHDAY", map, "");
		} else {
			// ���������͂���Ă���ꍇ
			VRBindPathParser.set("PATIENT_BIRTHDAY", map, getBasicInfoBirth()
					.getDate());
		}

		// �\��
		getBasicInfoAge().setSource(map);
		getBasicInfoAge().bindSource();

	}

	/**
	 * �u��ʏ����v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void institutionInfoTokuteiNyushoActionPerformed(ActionEvent e)
			throws Exception {

		if (getInstitutionInfoTokuteiNyusho().isSelected()) {
			// �I������Ă���ꍇ
			setState_ENABLE_TOKUTEI_NYUSHO_TRUE();
		} else {
			// �I������Ă��Ȃ��ꍇ
			setState_ENABLE_TOKUTEI_NYUSHO_FALSE();
		}
	}

	public static void main(String[] args) {
		//�f�t�H���g�f�o�b�O�N��
		ACFrame.getInstance().setFrameEventProcesser(
				new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();

		//    param.setData("PATIENT_ID", new Integer(10));
		param.setData("PROCESS_MODE", new Integer(
				QkanConstants.PROCESS_MODE_INSERT));

		// param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
		ACFrame.debugStart(new ACAffairInfo(QU002.class.getName(), param));
	}

	//�����֐�

	/**
	 * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @throws Exception ������O
	 */
	public boolean isValidInputPatient() throws Exception {

		// ���p�Ҋ�{���̓��̓`�F�b�N���s���B

		// ���b�Z�[�W�\���p
		String msgParam = null;

		// �����̃`�F�b�N    
		// �EbasicInfoName1�i���j�@
		// �EbasicInfoName2�i���j�@�������͂ǂ��炩����ɓ��͂���Ă���Ή�
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"����"��������B  	
		if (ACTextUtilities.isNullText(getBasicInfoName1().getText())
				&& ACTextUtilities.isNullText(getBasicInfoName2().getText())) {
			getBasicInfoName1().requestFocus();
			msgParam = "����";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
					msgParam);
			return false;
		}

		// �ӂ肪�Ȃ̃`�F�b�N
		// �EbasicInfoFurigana1�i�ӂ肪�Ȏ��j
		// �EbasicInfoFurigana2�i�ӂ肪�Ȗ��j�@���ӂ肪�Ȃ������Ɠ��l�ǂ��炩����ɓ��͂���Ă���Ή�
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�ӂ肪��"��������B  	
		if (ACTextUtilities.isNullText(getBasicInfoFurigana1().getText())
				&& ACTextUtilities
						.isNullText(getBasicInfoFurigana2().getText())) {
			getBasicInfoFurigana1().requestFocus(); // �t�H�[�J�X
			msgParam = "�ӂ肪��";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
					msgParam);
			return false;
		}

		// ���ʂ̃`�F�b�N
		// �EbasicInfoSexs�i���ʁj

		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"����"��������B  	
		if (!getBasicInfoSexs().isSelected()) {
			getBasicInfoSexs().requestFocus(); // �t�H�[�J�X
			msgParam = "����";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(
					msgParam);
			return false;
		}

		// ���N�����̃`�F�b�N
		// �EbasicInfoBirth�i���N�����j
		// �����͂��ǂ���
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"���N����"��������B
		if (ACTextUtilities.isNullText(getBasicInfoBirth().getText())) {
			getBasicInfoBirth().requestFocus(); // �t�H�[�J�X
			msgParam = "���N����";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(
					msgParam);
			return false;
		}
		// ���݂��Ȃ����t���ǂ���
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"���N������"��������B
		if (!getBasicInfoBirth().isValidDate()) {
			getBasicInfoBirth().requestFocus(); // �t�H�[�J�X
			msgParam = "���N������";
			QkanMessageList.getInstance().ERROR_OF_WRONG_DATE(msgParam);
			return false;
		}
		// �����̓��t���ǂ���
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"���N������"��������B
		Date nowDate = new Date(); // ���ݓ��t
		Date birth = getBasicInfoBirth().getDate(); // ���N����   	
		if (ACDateUtilities.getDifferenceOnDay(nowDate, birth) < 0) {
			getBasicInfoBirth().requestFocus(); // �t�H�[�J�X
			msgParam = "���N������";
			QkanMessageList.getInstance().ERROR_OF_FUTURE_DATE(msgParam);
			return false;
		}

		// �{�ݏ��̈�
		// ������{�ݓ����҃`�F�b�N��ON�̏ꍇ�̂݃`�F�b�N����B
		if (getInstitutionInfoTokuteiNyusho().isSelected()) {
			// �����͂łȂ����`�F�b�N����B
			// �EinstitutionInfoDinnerBearLimitMoneyText
			// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"���S���x�z"��������B  	
			if (ACTextUtilities
					.isNullText(getInstitutionInfoDinnerBearLimitMoneyText()
							.getText())) {
				getInstitutionInfoDinnerBearLimitMoneyText().requestFocus();
				msgParam = "���S���x�z";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam);
				return false;
			}

			// �EinstitutionInfoUnitRoomLimitMoneyText
			// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"���S���x�z"��������B
			if (ACTextUtilities
					.isNullText(getInstitutionInfoUnitRoomLimitMoneyText()
							.getText())) {
				getInstitutionInfoUnitRoomLimitMoneyText().requestFocus();
				msgParam = "���S���x�z";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam);
				return false;
			}

			// �EinstitutionInfoUnitSemiRoomLimitMoneyText
			// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"���S���x�z"��������B 
			if (ACTextUtilities
					.isNullText(getInstitutionInfoUnitSemiRoomLimitMoneyText()
							.getText())) {
				getInstitutionInfoUnitSemiRoomLimitMoneyText().requestFocus();
				msgParam = "���S���x�z";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam);
				return false;
			}

			// �EinstitutionInfoNormalRoomLimitMoneyText
			// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"���S���x�z"��������B 
			if (ACTextUtilities
					.isNullText(getInstitutionInfoNormalRoomLimitMoneyText()
							.getText())) {
				getInstitutionInfoNormalRoomLimitMoneyText().requestFocus();
				msgParam = "���S���x�z";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam);
				return false;
			}

			// �EinstitutionInfoNormalRoomLimitMoneyText2
			// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"���S���x�z"��������B 
			if (ACTextUtilities
					.isNullText(getInstitutionInfoNormalRoomLimitMoneyText2()
							.getText())) {
				getInstitutionInfoNormalRoomLimitMoneyText2().requestFocus();
				msgParam = "���S���x�z";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam);
				return false;
			}

			// �EinstitutionInfoTasyoRoomLimitMoneyText
			// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"���S���x�z"��������B  
			if (ACTextUtilities
					.isNullText(getInstitutionInfoTasyoRoomLimitMoneyText()
							.getText())) {
				getInstitutionInfoTasyoRoomLimitMoneyText().requestFocus();
				msgParam = "���S���x�z";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam);
				return false;
			}

		}

		// ���̓`�F�b�N�G���[���������Ȃ������ꍇ
		// �@�߂�l�Ƃ���true��Ԃ��B
		return true;

	}

	/**
	 * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @throws Exception ������O
	 */
	public boolean isValidInputIdou() throws Exception {
		// �ٓ����̓��̓`�F�b�N���s���B    

		String msgParam = null;

		// �T�[�r�X�̃`�F�b�N
		// �EidouInfoServise�i�T�[�r�X�j
		// �I������Ă��邩�ǂ���
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�T�[�r�X"��������B
		if (!getIdouInfoServise().isSelected()) {
			getIdouInfoServise().requestFocus();
			msgParam = "�T�[�r�X";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(
					msgParam);
			return false;
		}

		// �ٓ����R�̃`�F�b�N
		// �EidouInfoChangeContent�i�ٓ����R�j
		// �I������Ă��邩�ǂ���
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�ٓ����R"��������B
		if (!getIdouInfoChangeContent().isSelected()) {
			getIdouInfoChangeContent().requestFocus();
			msgParam = "�ٓ����R";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(
					msgParam);
			return false;
		}

		// ���t�̃`�F�b�N
		// �EidouInfoDate�i���t�j
		// ���͂���Ă��邩�ǂ���
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"���t"��������B
		if (ACTextUtilities.isNullText(getIdouInfoDate().getText())) {
			getIdouInfoDate().requestFocus();
			msgParam = "���t";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
					msgParam);
			return false;
		}
		// ���݂�����t���ǂ���
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"���t��"��������B
		if (!getIdouInfoDate().isValidDate()) {
			getIdouInfoDate().requestFocus();
			msgParam = "���t��";
			QkanMessageList.getInstance().ERROR_OF_WRONG_DATE(msgParam);
			return false;
		}

		// ���̓`�F�b�N�G���[���������Ȃ������ꍇ
		// �߂�l�Ƃ���true��Ԃ��B
		return true;

	}

	/**
	 * �u�x�����x�z�\���v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @throws Exception ������O
	 */
	public void doFindLimitRate() throws Exception {

		// �x�����x�z���擾����B
		int limitRate = getLimitRate();

		// �擾�����x�����x�z�̒l���]1�̏ꍇ
		if (limitRate == -1) {
			// ��ʏ�̎x�����x�z�e�L�X�g����ɂ���B
			getKaigoInfoProvideLimit().setText("");
			return;
		}

		// �擾�����x�����x�z���x�����x�z�e�L�X�g�t�B�[���h
		// �ikaigoInfoProvideLimit�j�ɕ\������B
		getKaigoInfoProvideLimit().setText(ACCastUtilities.toString(limitRate));

	}

	/**
	 * �u�x�����x�z�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @return limitRate �x�����x�z
	 * @throws Exception ������O
	 */
	public int getLimitRate() throws Exception {

		// �߂�l
		int limitRate = -1;

		// ���̓`�F�b�N���s���A�x�����x�z���擾���邽�߂ɕK�v�Ȉ������擾���A
		// VRMap param�Ɋi�[����B
		VRMap param = getParamForLimitRate();

		if (param != null) {
			// �������擾�ł����ꍇ�iparam <> null�j

			// �x�����x�z���擾����B
			// �����ی��̗L�����Ԃƕی��҂̎x�����x�z�L�����Ԃ��r���A�L���Ȏx�����x�z��\������B
			// ���L���Ȏx�����x�z����������ꍇ�́A�ŐV�iLIMIT_RATE_HISTORY_ID�̑傫���j�̎x�����x�z��\������B
			VRBindPathParser.set("LIMIT_RATE_TYPE", param, new Integer(1));
			String strSql = null;
			strSql = getSQL_GET_INSURER_LIMIT_RATE(param);
			VRList list = getDBManager().executeQuery(strSql);

			if (list == null || list.size() == 0) {
				// �擾�����f�[�^������0���̏ꍇ
				// �����J���ȋK��̎x�����x�z���擾����B
				strSql = getSQL_GET_OFFICIAL_LIMIT_RATE(param);
				list = getDBManager().executeQuery(strSql);

				// �擾�����x�����x�z�e�L�X�g�t�B�[���h�ikaigoInfoProvideLimit�j�ɕ\������B
				if (!(list == null || list.size() == 0)) {
					limitRate = ACCastUtilities.toInt(VRBindPathParser.get(
							"LIMIT_RATE_VALUE", (VRMap) list.get(0)));
				}

			} else {
				// �ی��҂̎x�����x�z��ݒ肷��B
				limitRate = ACCastUtilities.toInt(VRBindPathParser.get(
						"LIMIT_RATE_VALUE", (VRMap) list.get(0)));
			}

		}

		return limitRate;

	}

	/**
	 * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @return param �x�����x�z�擾�ɕK�v�Ȓl
	 * @throws Exception ������O
	 */
	public VRMap getParamForLimitRate() throws Exception {

		// �x�����x�z���擾�p�̓��̓`�F�b�N���s���B

		// �ی��Җ��̃`�F�b�N
		// �EkaigoInfoInsurerName�i�ی��Җ��j
		// �I������Ă��邩�ǂ���
		if (!getKaigoInfoInsurerName().isSelected()) {
			// �I������Ă��Ȃ��ꍇ					
			return null;
		}

		// �v�����̃`�F�b�N
		// �EkaigoInfoYokaigoInfo�i�v�����j
		// �I������Ă��邩�ǂ���
		if (!getKaigoInfoYokaigoInfo().isSelected()) {
			// �I������Ă��Ȃ��ꍇ								
			return null;
		}

		// �L�����ԊJ�n���̃`�F�b�N	
		// �EkaigoInfoValidLimit1�i�L�����ԊJ�n���j					
		// ���͂���Ă��邩�ǂ���
		if (ACTextUtilities.isNullText(getKaigoInfoValidLimit1().getText())) {
			// ���͂���Ă��Ȃ��ꍇ					
			return null;
		}

		// ���݂��Ȃ����t�����͂���Ă��Ȃ����ǂ���
		if (!getKaigoInfoValidLimit1().isValidDate()) {
			// ���݂��Ȃ����t�����͂���Ă���ꍇ		
			return null;
		}

		// �L�����ԏI�����̃`�F�b�N
		// �EkaigoInfoValidLimit3�i�L�����ԏI�����j				
		// ���͂���Ă��邩�ǂ���
		if (ACTextUtilities.isNullText(getKaigoInfoValidLimit3().getText())) {
			// ���͂���Ă��Ȃ��ꍇ					
			return null;
		}

		// ���݂��Ȃ����t�����͂���Ă��Ȃ����ǂ���
		if (!getKaigoInfoValidLimit3().isValidDate()) {
			// ���݂��Ȃ����t�����͂���Ă���ꍇ		
			return null;
		}

		// �L�����Ԃ̑O��֌W������Ă��Ȃ����ǂ���						
		// �EkaigoInfoValidLimit1�i�L�����ԊJ�n���j					
		// �EkaigoInfoValidLimit2�i�L�����ԏI�����j
		Date start = getKaigoInfoValidLimit1().getDate();
		Date end = getKaigoInfoValidLimit3().getDate();

		if (ACDateUtilities.getDifferenceOnDay(start, end) > 0) {
			// �O��֌W������Ă���ꍇ
			return null;
		}

		// �G���[���Ȃ������ꍇ
		// �ȉ��̒l��VRMap map�ɐݒ肷��B	
		// �EkaigoInfoInsurerId�i�ی��Ҕԍ��j�@KEY�FINSURER_ID
		// �EkaigoInfoYokaigoInfo�i�v�����j�@KEY�FJOTAI_CODE
		// �EkaigoInfoValidLimit1�i�L�����ԊJ�n�j�@KEY�FVALID_START
		// �EkaigoInfoValidLimit3�i�L�����ԏI���j�@KEY�FVALID_END
		VRMap param = new VRHashMap();
		VRBindPathParser.set("INSURER_ID", param, getKaigoInfoInsurerId()
				.getText());
		VRMap yokaigo = (VRMap) getKaigoInfoYokaigoInfo()
				.getSelectedModelItem();
		VRBindPathParser.set("JOTAI_CODE", param, VRBindPathParser.get(
				"JOTAI_CODE", yokaigo));
		VRBindPathParser.set("VALID_START", param, getKaigoInfoValidLimit1()
				.getDate());
		VRBindPathParser.set("VALID_END", param, getKaigoInfoValidLimit3()
				.getDate());

		// �߂�l�Ƃ���map��Ԃ��B  	
		return param;
	}

	/**
	 * �u�O�����p�^����P�ʐ��\���v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @throws Exception ������O
	 */
	public void doFindExternalUseLimit() throws Exception {

		// �O�����p�^����P�ʐ����擾����B
		int externalUseLimit = getExternalUseLimit();

		// �擾�����O�����p�^����P�ʐ��̒l���]1�̏ꍇ
		if (externalUseLimit == -1) {
			// ��ʏ�̊O�����p�^����P�ʐ��e�L�X�g����ɂ���B
			getKaigoInfoExternalUseLimit().setText("");
			return;
		}

		// �擾�����O�����p�^����P�ʐ����O�����p�^����P�ʐ��e�L�X�g�t�B�[���h
		// �ikaigoInfoExternalUseLimit�j�ɕ\������B
		getKaigoInfoExternalUseLimit().setText(
				ACCastUtilities.toString(externalUseLimit));

	}

	/**
	 * �u�O�����p�^����P�ʐ��擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @return externalUseLimit �O�����p�^����P�ʐ�
	 * @throws Exception ������O
	 */
	public int getExternalUseLimit() throws Exception {

		// �߂�l
		int externalUseLimit = -1;

		// ���̓`�F�b�N���s���A�O�����p�^����P�ʐ����擾���邽�߂ɕK�v�Ȉ������擾���A
		// VRMap param�Ɋi�[����B
		VRMap param = getParamForExternalUseLimit();

		if (param != null) {
			// �������擾�ł����ꍇ�iparam <> null�j

			// �O�����p�^����P�ʐ����擾����B
			// �����ی��̗L�����Ԃƃ}�X�^�̗L�����Ԃ��r���A�L���ȊO�����p�^����P�ʐ���\������B
			// ���L���ȊO�����p�^����P�ʐ�����������ꍇ�́A�ŐV�iLIMIT_RATE_HISTORY_ID�̑傫���j��
			//   �O�����p�^����P�ʐ���\������B
			VRBindPathParser.set("LIMIT_RATE_TYPE", param, new Integer(2));
			String strSql = null;
			strSql = getSQL_GET_OFFICIAL_LIMIT_RATE(param);
			VRList list = getDBManager().executeQuery(strSql);

			if (!(list == null || list.size() == 0)) {
				// �O�����p�^����P�ʐ���ݒ肷��B
				externalUseLimit = ACCastUtilities.toInt(VRBindPathParser.get(
						"LIMIT_RATE_VALUE", (VRMap) list.get(0)));
			}

		}

		return externalUseLimit;
	}

	/**
	 * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @return param �O�����p�^����P�ʐ��擾�ɕK�v�Ȓl
	 * @throws Exception ������O
	 */
	public VRMap getParamForExternalUseLimit() throws Exception {

		// �O�����p�^����P�ʐ��擾�p�̓��̓`�F�b�N���s���B

		// �v�����̃`�F�b�N
		// �EkaigoInfoYokaigoInfo�i�v�����j
		// �I������Ă��邩�ǂ���
		if (!getKaigoInfoYokaigoInfo().isSelected()) {
			// �I������Ă��Ȃ��ꍇ								
			return null;
		}

		// �L�����ԊJ�n���̃`�F�b�N	
		// �EkaigoInfoValidLimit1�i�L�����ԊJ�n���j					
		// ���͂���Ă��邩�ǂ���
		if (ACTextUtilities.isNullText(getKaigoInfoValidLimit1().getText())) {
			// ���͂���Ă��Ȃ��ꍇ					
			return null;
		}

		// ���݂��Ȃ����t�����͂���Ă��Ȃ����ǂ���
		if (!getKaigoInfoValidLimit1().isValidDate()) {
			// ���݂��Ȃ����t�����͂���Ă���ꍇ		
			return null;
		}

		// �L�����ԏI�����̃`�F�b�N
		// �EkaigoInfoValidLimit3�i�L�����ԏI�����j				
		// ���͂���Ă��邩�ǂ���
		if (ACTextUtilities.isNullText(getKaigoInfoValidLimit3().getText())) {
			// ���͂���Ă��Ȃ��ꍇ					
			return null;
		}

		// ���݂��Ȃ����t�����͂���Ă��Ȃ����ǂ���
		if (!getKaigoInfoValidLimit3().isValidDate()) {
			// ���݂��Ȃ����t�����͂���Ă���ꍇ		
			return null;
		}

		// �L�����Ԃ̑O��֌W������Ă��Ȃ����ǂ���						
		// �EkaigoInfoValidLimit1�i�L�����ԊJ�n���j					
		// �EkaigoInfoValidLimit2�i�L�����ԏI�����j
		Date start = getKaigoInfoValidLimit1().getDate();
		Date end = getKaigoInfoValidLimit3().getDate();

		if (ACDateUtilities.getDifferenceOnDay(start, end) > 0) {
			// �O��֌W������Ă���ꍇ
			return null;
		}

		// �G���[���Ȃ������ꍇ
		// �ȉ��̒l��VRMap map�ɐݒ肷��B	
		// �EkaigoInfoYokaigoInfo�i�v�����j�@KEY�FJOTAI_CODE
		// �EkaigoInfoValidLimit1�i�L�����ԊJ�n�j�@KEY�FVALID_START
		// �EkaigoInfoValidLimit3�i�L�����ԏI���j�@KEY�FVALID_END
		VRMap param = new VRHashMap();
		VRMap yokaigo = (VRMap) getKaigoInfoYokaigoInfo()
				.getSelectedModelItem();
		VRBindPathParser.set("JOTAI_CODE", param, VRBindPathParser.get(
				"JOTAI_CODE", yokaigo));
		VRBindPathParser.set("VALID_START", param, getKaigoInfoValidLimit1()
				.getDate());
		VRBindPathParser.set("VALID_END", param, getKaigoInfoValidLimit3()
				.getDate());

		// �߂�l�Ƃ���map��Ԃ��B  	
		return param;
	}

	/**
	 * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @param checkMode 1�F�ǉ����[�h�@2�F�ҏW���[�h
	 * @throws Exception ������O
	 */
	public boolean isValidInputKaigo(int checkMode) throws Exception {
		// ���ی����̓��̓`�F�b�N���s���B

		// �t���O
		int doUpdateFlg = 0;

		// ���b�Z�[�W�\���p
		String msgParam1 = null;
		String msgParam2 = null;
		String msgParam3 = null;

		// �o�^����Ă��闚���̗L������
		Date reservedStart = null;
		Date reservedEnd = null;

		if (getNonCorrespondenceFlg() == 0) { // ���v���x-��Y���̏ꍇ�͏�����ʂ�Ȃ��B
			// �ی��Ҕԍ��̃`�F�b�N
			// �EkaigoInfoInsurerId�i�ی��Ҕԍ��j
			// ���͂���Ă��邩�ǂ���    
			// ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"�ی��Ҕԍ�"��������B
			if (ACTextUtilities.isNullText(getKaigoInfoInsurerId().getText())) {
				getKaigoInfoInsurerId().requestFocus(); // �t�H�[�J�X
				msgParam1 = "�ی��Ҕԍ�";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}
			//	    // ������6�����ǂ���
			//	    // ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"�ی��Ҕԍ�"��������B
			//	    // ���G���[�̏ꍇ�AString�FmsgParam2��錾���A"6"��������B
			//	    String insurerId = getKaigoInfoInsurerId().getText();
			//	    if(insurerId.length() != 6){
			//	    	getKaigoInfoInsurerId().requestFocus();		// �t�H�[�J�X
			//	    	msgParam1 = "�ی��Ҕԍ�";
			//	    	msgParam2 = "6";
			//	        QkanMessageList.getInstance().ERROR_OF_LENGTH(msgParam1, msgParam2);
			//	    	return false;    	
			//	    }

			// �ی��Җ��̃`�F�b�N
			// �EkaigoInfoInsurerName�i�ی��Җ��j
			// �I������Ă��邩�ǂ���
			// ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"�ی��Җ�"��������B
			if (!getKaigoInfoInsurerName().isSelected()) {
				getKaigoInfoInsurerName().requestFocus(); // �t�H�[�J�X
				msgParam1 = "�ی��Җ�";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(
						msgParam1);
				return false;
			}

			// ��ی��Ҕԍ��̃`�F�b�N
			// �EkaigoInfoInsuredId�i��ی��Ҕԍ��j
			// ���͂���Ă��邩�ǂ���
			// ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"��ی��Ҕԍ�"��������B
			if (ACTextUtilities.isNullText(getKaigoInfoInsuredId().getText())) {
				getKaigoInfoInsuredId().requestFocus(); // �t�H�[�J�X
				msgParam1 = "��ی��Ҕԍ�";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}
			// ������10�����ǂ���    
			// ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"��ی��Ҕԍ�"��������B
			// ���G���[�̏ꍇ�AString�FmsgParam2��錾���A"10"��������B
			if (getKaigoInfoInsuredId().getText().length() != 10) {
				getKaigoInfoInsuredId().requestFocus(); // �t�H�[�J�X
				msgParam1 = "��ی��Ҕԍ�";
				msgParam2 = "10";
				QkanMessageList.getInstance().ERROR_OF_LENGTH(msgParam1,
						msgParam2);
				return false;
			}

			// ���t���̃`�F�b�N
			// �EkaigoInfoBenefit�i���t���j
			// ���͂���Ă��邩�ǂ���
			// ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"���t��"��������B
			if (ACTextUtilities.isNullText(getKaigoInfoBenefit().getText())) {
				getKaigoInfoBenefit().requestFocus(); // �t�H�[�J�X
				msgParam1 = "���t��";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}

			// ���t���ɓ��͂���Ă���l���s���łȂ����ǂ���
			int benefitRate = ACCastUtilities.toInt(getKaigoInfoBenefit()
					.getText());
			if (benefitRate < 0 || benefitRate > 100) {
				getKaigoInfoBenefit().requestFocus(); // �t�H�[�J�X
				msgParam1 = "���t��";
				msgParam2 = "100";
				QkanMessageList.getInstance().ERROR_OF_VALUE_TOO_MUCH(
						msgParam1, msgParam2);
				return false;
			}

			// ��ی��Ҕԍ�
			String insuredId = getKaigoInfoInsuredId().getText();
			// ���t��
			int insureRate = ACCastUtilities.toInt(getKaigoInfoBenefit()
					.getText(), 0);

			if (insuredId.charAt(0) != 'H') {
				if (insureRate == INSURE_RATE_SEIHO) {
					// ���ےP�ƂłȂ����ɋ��t�����u0%�v�Ɛݒ肳��Ă����ꍇ
					getKaigoInfoBenefit().requestFocus(); // �t�H�[�J�X
					QkanMessageList.getInstance()
							.QU002_ERROR_OF_RATE_FOR_NOT_SEIHO_TANDOKU();
					return false;
				}
			}

			// ����T�[�r�X�v��쐬�҂̃`�F�b�N
			// �EkaigoInfoKyotakuServiceRadio�i����T�[�r�X�v��쐬�ҁj
			//	    // �I������Ă��邩�ǂ���
			//	    // ���G���[�̏ꍇ�AString�FmsgParam��錾���A"����T�[�r�X�v��쐬��"��������B
			//	  	if(!getKaigoInfoKyotakuServiceRadio().isSelected()){
			//	  		getKaigoInfoKyotakuServiceRadio().requestFocus();		// �t�H�[�J�X
			//	    	msgParam1 = "����T�[�r�X�v��쐬��";
			//	        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(msgParam1);
			//	    	return false;  		
			//	  	}

			// �x�����Ə��̃`�F�b�N�@������T�[�r�X�쐬�҂ŋ�����x�����Ə����I������Ă���ꍇ�̂�
			// �EkaigoInfoKyotakuServicePlanCombo�i������x�����Ə��j
			// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"������x�����Ə�"��������B
			if (getKaigoInfoKyotakuServiceRadio().getSelectedIndex() == INDEX_OF_PROVIDER_SHIEN
					|| getKaigoInfoKyotakuServiceRadio().getSelectedIndex() == INDEX_OF_PROVIDER_YOBOU_SHIEN) {
				if (!getKaigoInfoKyotakuServicePlanCombo().isSelected()) {
					getKaigoInfoKyotakuServicePlanCombo().requestFocus(); // �t�H�[�J�X
					//		    	msgParam1 = "������x�����Ə�";
					//		  		QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(msgParam1);
					QkanMessageList.getInstance()
							.QU002_ERROR_OF_NO_DATA_SHIEN_PROVIDER();
					return false;
				}
			}

			// �\���敪�̃`�F�b�N
			// �I������Ă��邩�ǂ���
			// �EkaigoInfoRequestDivisionRadio�i�\���敪�j
			// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�\���敪"��������B
			if (!getKaigoInfoRequestDivisionRadio().isSelected()) {
				getKaigoInfoRequestDivisionRadio().requestFocus(); // �t�H�[�J�X
				msgParam1 = "�\���敪";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(
						msgParam1);
				return false;
			}

			// �v�����̃`�F�b�N
			// �I������Ă��邩�ǂ���
			// �EkaigoInfoYokaigoInfo�i�v�����j
			// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�v�����"��������B
			if (!getKaigoInfoYokaigoInfo().isSelected()) {
				getKaigoInfoYokaigoInfo().requestFocus(); // �t�H�[�J�X
				msgParam1 = "�v�����";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(
						msgParam1);
				return false;
			}

		}

		// �͏o���̃`�F�b�N�@�����͂���Ă���ꍇ�̂�
		// �EkaigoInfoReportDate�i�͏o���j
		// ���݂�����t�����͂���Ă��邩�ǂ���
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�͏o����"��������B
		if (!ACTextUtilities.isNullText(getKaigoInfoReportDate().getText())) {
			if (!getKaigoInfoReportDate().isValidDate()) {
				getKaigoInfoReportDate().requestFocus(); // �t�H�[�J�X
				msgParam1 = "�͏o����";
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE(msgParam1);
				return false;
			}
		}

		// �\�����̃`�F�b�N�@�����͂���Ă���ꍇ�̂�
		// �EkaigoInfoRequestDate�i�\�����j
		// ���݂�����t�����͂���Ă��邩�ǂ���
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�\������"��������B
		if (!ACTextUtilities.isNullText(getKaigoInfoRequestDate().getText())) {
			if (!getKaigoInfoRequestDate().isValidDate()) {
				getKaigoInfoRequestDate().requestFocus(); // �t�H�[�J�X
				msgParam1 = "�\������";
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE(msgParam1);
				return false;
			}
		}

		// �F����̃`�F�b�N�@�����͂���Ă���ꍇ�̂�
		// �EkaigoInfoAuthorizeDate�i�F����j
		// ���݂�����t�����͂���Ă��邩�ǂ���
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�F�����"��������B
		if (!ACTextUtilities.isNullText(getKaigoInfoAuthorizeDate().getText())) {
			if (!getKaigoInfoAuthorizeDate().isValidDate()) {
				getKaigoInfoAuthorizeDate().requestFocus(); // �t�H�[�J�X
				msgParam1 = "�F�����";
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE(msgParam1);
				return false;
			}
		}

		if (getNonCorrespondenceFlg() == 0) {
			// �L�����ԊJ�n���̃`�F�b�N�@���v���x-��Y���̏ꍇ�͍s��Ȃ��B
			// �EkaigoInfoValidLimit1�i�L�����ԊJ�n���j
			// ���͂���Ă��邩�ǂ���    
			// ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"�L�����ԊJ�n��"��������B
			if (ACTextUtilities.isNullText(getKaigoInfoValidLimit1().getText())) {
				getKaigoInfoValidLimit1().requestFocus(); // �t�H�[�J�X
				msgParam1 = "�L�����ԊJ�n��";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}
		}

		// ���݂�����t�����͂���Ă��邩�ǂ���
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�L�����ԊJ�n����"��������B
		if (!ACTextUtilities.isNullText(getKaigoInfoValidLimit1().getText())) {
			if (!getKaigoInfoValidLimit1().isValidDate()) {
				getKaigoInfoValidLimit1().requestFocus(); // �t�H�[�J�X
				msgParam1 = "�L�����ԊJ�n����";
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE(msgParam1);
				return false;
			}
		}

		if (getNonCorrespondenceFlg() == 0) {
			// �L�����ԏI�����̃`�F�b�N�@���v���x-��Y���̏ꍇ�͍s��Ȃ��B
			// �EkaigoInfoValidLimit3�i�L�����ԏI�����j
			// ���͂���Ă��邩�ǂ���    
			// ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"�L�����ԏI����"��������B
			if (ACTextUtilities.isNullText(getKaigoInfoValidLimit3().getText())) {
				getKaigoInfoValidLimit3().requestFocus(); // �t�H�[�J�X
				msgParam1 = "�L�����ԏI����";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}
		}

		// ���݂�����t�����͂���Ă��邩�ǂ����@���v���x-��Y���̏ꍇ�͍s��Ȃ��B
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�L�����ԏI������"��������B
		if (!ACTextUtilities.isNullText(getKaigoInfoValidLimit3().getText())) {
			if (!getKaigoInfoValidLimit3().isValidDate()) {
				getKaigoInfoValidLimit3().requestFocus(); // �t�H�[�J�X
				msgParam1 = "�L�����ԏI������";
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE(msgParam1);
				return false;
			}
		}

		int targetIndex = -1; // �ҏW�ΏۂƂȂ闚���̃C���f�b�N�X

		if (getNonCorrespondenceFlg() == 0) {
			// �L�����ԊJ�n���ƗL�����ԏI�����̑O��֌W�̃`�F�b�N�@���v���x-��Y���̏ꍇ�͍s��Ȃ��B
			// �EkaigoInfoValidLimit1�i�L�����ԊJ�n���j
			// �EkaigoInfoValidLimit3�i�L�����ԏI�����j
			// ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"�L�����Ԃ�"��������B
			// ���G���[�̏ꍇ�AString�FmsgParam2��錾���A"�J�n��"��������B
			// ���G���[�̏ꍇ�AString�FmsgParam3��錾���A"�I����"��������B

			Date start = getKaigoInfoValidLimit1().getDate();
			Date end = getKaigoInfoValidLimit3().getDate();

			if (ACDateUtilities.getDifferenceOnDay(start, end) > 0) {
				getKaigoInfoValidLimit1().requestFocus();
				msgParam1 = "�L�����Ԃ�";
				msgParam2 = "�J�n��";
				msgParam3 = "�I����";
				QkanMessageList.getInstance().ERROR_OF_GREATER_DATE_RELATION(
						msgParam1, msgParam2, msgParam3);
				return false;
			}

			// ���ɓo�^����Ă���v���F��̗L�����ԂƏd�Ȃ��Ă��Ȃ����ǂ����@���v���x-��Y���̏ꍇ�͍s��Ȃ��B
			// �EkaigoInfoValidLimit1�i�L�����ԊJ�n���j
			// �EkaigoInfoValidLimit2�i�L�����ԏI�����j

			if (!(getKaigoHistoryList() == null || getKaigoHistoryList().size() == 0)) {

				Date latestStart = null;

				// �Ō�̗����̃C���f�b�N�X���擾����B
				for (int i = 0; i < getKaigoHistoryList().size(); i++) { // �F�藚�����������[�v

					// �ҏW���[�h�̏ꍇ
					// ���g�̗����͖�������B
					if (checkMode == CHECK_MODE_UPDATE) {
						if (i == getKaigoInfoTable().getSelectedModelRow()) {
							continue;
						}
					}

					VRMap map = (VRMap) getKaigoHistoryList().get(i); // ���𒊏o

					// �Ώۂ̗�������Y���̏ꍇ�͖�������B
					int targetJotaiCode = ACCastUtilities
							.toInt(VRBindPathParser.get("JOTAI_CODE", map));
					if (targetJotaiCode == YOUKAIGODO_HIGAITOU) {
						continue;
					}

					reservedStart = (Date) VRBindPathParser.get(
							"INSURE_VALID_START", map); // �����̗L�����ԊJ�n��
					if (latestStart == null) {
						latestStart = reservedStart;
						targetIndex = i;
					} else if (ACDateUtilities.getDifferenceOnDay(latestStart,
							reservedStart) < 0) {
						latestStart = reservedStart;
						targetIndex = i;
					}
				}

				// �Ō�̗����ȊO�̗����Əd�����Ă��Ȃ����`�F�b�N����B
				for (int i = 0; i < getKaigoHistoryList().size(); i++) { // �F�藚�����������[�v

					// �Ō�̗����͌�Ŕ�r����
					if (i == targetIndex) {
						continue;
					}

					// �ҏW���[�h�̏ꍇ
					// ���g�̗����͖�������B
					if (checkMode == CHECK_MODE_UPDATE) {
						if (i == getKaigoInfoTable().getSelectedModelRow()) {
							continue;
						}
					}

					VRMap map = (VRMap) getKaigoHistoryList().get(i); // ���𒊏o

					// �Ώۂ̗�������Y���̏ꍇ�͖�������B
					int targetJotaiCode = ACCastUtilities
							.toInt(VRBindPathParser.get("JOTAI_CODE", map));
					if (targetJotaiCode == YOUKAIGODO_HIGAITOU) {
						continue;
					}

					reservedStart = (Date) VRBindPathParser.get(
							"INSURE_VALID_START", map);
					reservedEnd = (Date) VRBindPathParser.get(
							"INSURE_VALID_END", map);

					// ���ԏd���`�F�b�N
					// �`�F�b�N�̌��ʂ��擾
					int result = ACDateUtilities.getDuplicateTermCheck(
							reservedStart, reservedEnd, start, end);

					if (result != ACDateUtilities.DUPLICATE_NONE) {
						// �d�����Ă����ꍇ

						getKaigoInfoValidLimit1().requestFocus();
						QkanMessageList.getInstance()
								.QU002_ERROR_OF_DUPLICATE_KAIGO();
						return false;

					}
				}

				// �Ō�̗����Əd�����Ă��Ȃ����`�F�b�N����B
				if (targetIndex != -1) {
					VRMap latestMap = (VRMap) getKaigoHistoryList().get(
							targetIndex); // �Ō�̗��𒊏o
					reservedStart = (Date) VRBindPathParser.get(
							"INSURE_VALID_START", latestMap); // �Ō�̗����̗L�����ԊJ�n��
					reservedEnd = (Date) VRBindPathParser.get(
							"INSURE_VALID_END", latestMap); // �Ō�̗����̗L�����ԏI����

					// �`�F�b�N�̌��ʂ��擾
					int result = ACDateUtilities.getDuplicateTermCheck(
							reservedStart, reservedEnd, start, end);

					if (result != ACDateUtilities.DUPLICATE_NONE) {
						// �d�����Ă����ꍇ

						if (result == ACDateUtilities.DUPLICATE_FIRST_INCLUDE_SECOND
								|| result == ACDateUtilities.DUPLICATE_FIRST_INCLUDE_SECOND_EQUALS_BOTH_END
								|| result == ACDateUtilities.DUPLICATE_FIRST_END_AND_SECOND_BEGIN
								|| result == ACDateUtilities.DUPLICATE_FIRST_END_AND_SECOND_BEGIN_ON_ONE_DAY) {
							// �L�����Ԃ������Œ����ł���ꍇ
							// �m�F���b�Z�[�W��\������B
							// �E���b�Z�[�WID�FWARNING_OF_DUPLICATE_TERM
							msgParam1 = "�v���F��";
							switch (QkanMessageList.getInstance()
									.WARNING_OF_DUPLICATE_TERM(msgParam1)) {
							case ACMessageBox.RESULT_OK:
								// �uOK�v���I�����ꂽ�ꍇ
								// ���̓`�F�b�N�����S�Ƀp�X�����㏈�����s���B
								doUpdateFlg = 1;
								break;
							case ACMessageBox.RESULT_CANCEL:
								// �u�L�����Z���v���I�����ꂽ�ꍇ
								// �G���[�����������C���X�^���X�Ƀt�H�[�J�X�𓖂Ă�B
								getKaigoInfoValidLimit1().requestFocus();
								// �߂�l�Ƃ���false��Ԃ��B
								return false;
							}

						} else {
							// �L�����Ԃ������Œ����ł��Ȃ��ꍇ
							getKaigoInfoValidLimit1().requestFocus();
							QkanMessageList.getInstance()
									.QU002_ERROR_OF_DUPLICATE_KAIGO();
							return false;
						}

					}
				}
			}
		}

		if (getNonCorrespondenceFlg() == 0) { // ��Y���̏ꍇ�͏�����ʂ�Ȃ��B
			// ���f���̃`�F�b�N�@�����f���R���I������Ă���ꍇ�̂�
			// �EkaigoInfoInterruptionDate�i���f���j
			// ���f���R���I������Ă���ꍇ�A���͂���Ă��邩�ǂ���
			if (getKaigoInfoInterruptionReasonRadio().isSelected()) {
				if (ACTextUtilities.isNullText(getKaigoInfoInterruptionDate()
						.getText())) {
					// ���͂���Ă��邩�ǂ���    
					// ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"���f��"��������B
					getKaigoInfoInterruptionDate().requestFocus(); // �t�H�[�J�X
					msgParam1 = "���f��";
					QkanMessageList.getInstance()
							.ERROR_OF_NEED_CHECK_FOR_INPUT(msgParam1);
					return false;
				}
			}
		}

		// ���f���̃`�F�b�N�@�����f���R���I������Ă���ꍇ�̂�
		// �EkaigoInfoInterruptionDate�i���f���j
		// ���͂���Ă���ꍇ�A���݂�����t�����͂���Ă��邩�ǂ���
		if (!ACTextUtilities.isNullText(getKaigoInfoInterruptionDate()
				.getText())) {
			if (!getKaigoInfoInterruptionDate().isValidDate()) {
				// ���݂�����t�����͂���Ă��邩�ǂ���
				// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"���f����"��������B
				getKaigoInfoInterruptionDate().requestFocus(); // �t�H�[�J�X
				msgParam1 = "���f����";
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE(msgParam1);
				return false;
			}
		}

		if (getNonCorrespondenceFlg() == 0) { // ��Y���̏ꍇ�͏�����ʂ�Ȃ��B
			// ���f���R�̃`�F�b�N�@�����f�������͂���Ă���ꍇ�̂�
			// �I������Ă��邩�ǂ���
			// �EkaigoInfoInterruptionReasonRadio�i���f���R�j
			// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"���f���R"��������B
			if (!(ACTextUtilities.isNullText(getKaigoInfoInterruptionDate()
					.getText()))) {
				if (!getKaigoInfoInterruptionReasonRadio().isSelected()) {
					getKaigoInfoInterruptionReasonRadio().requestFocus(); // �t�H�[�J�X
					msgParam1 = "���f���R";
					QkanMessageList.getInstance()
							.ERROR_OF_NEED_CHECK_FOR_SELECT(msgParam1);
					return false;
				}
			}
		}

		if (getNonCorrespondenceFlg() == 0) {

			Date start = getKaigoInfoValidLimit1().getDate();
			Date end = getKaigoInfoValidLimit3().getDate();

			// 1���i�ЂƂ��j�ɁA�قȂ��ی��Ҕԍ���3�ȏ㑶�݂��邱�ƂɂȂ�Ȃ����`�F�b�N����B
			if (!(getKaigoHistoryList() == null || getKaigoHistoryList().size() == 0)) {

				int num = 0; // �d�������񐔂��J�E���g����B
				String insuredId = getKaigoInfoInsuredId().getText();

				// �L�����ԊJ�n���̌��ɑ��݂���F�藚������������B
				// �������Ď擾�����F�藚���̌��������[�v����B
				for (int i = 0; i < getKaigoHistoryList().size(); i++) {

					// �ҏW���[�h�̏ꍇ
					// ���g�̗����͖�������B
					if (checkMode == CHECK_MODE_UPDATE) {
						if (i == getKaigoInfoTable().getSelectedModelRow()) {
							continue;
						}
					}

					// �����̎擾
					VRMap map = (VRMap) getKaigoHistoryList().get(i);

					// �Ώۂ̗�������Y���̏ꍇ�͖�������B
					int targetJotaiCode = ACCastUtilities
							.toInt(VRBindPathParser.get("JOTAI_CODE", map));
					if (targetJotaiCode == YOUKAIGODO_HIGAITOU) {
						continue;
					}

					reservedStart = (Date) VRBindPathParser.get(
							"INSURE_VALID_START", map);
					reservedEnd = (Date) VRBindPathParser.get(
							"INSURE_VALID_END", map);

					if (ACDateUtilities.getDifferenceOnMonth(start,
							reservedStart) == 0
							|| ACDateUtilities.getDifferenceOnMonth(start,
									reservedEnd) == 0) {
						// �����̔�ی��Ҕԍ���kaigoInfoInsuredId�i��ی��Ҕԍ��j��
						// ���͂���Ă����ی��Ҕԍ����قȂ�ꍇ
						if (!insuredId.equals(ACCastUtilities
								.toString(VRBindPathParser.get("INSURED_ID",
										map)))) {
							// ���l�^�ϐ�num��1��������B
							num += 1;
						}

						// num�̒l��2�̏ꍇ
						if (num == 2) {
							getKaigoInfoInsuredId().requestFocus(); // �t�H�[�J�X
							// �G���[���b�Z�[�W��\������B
							QkanMessageList.getInstance()
									.QP002_ERROR_OF_INSURED_ID();
							return false;
						}

					}
				}

				// �J�E���^������
				num = 0;

				// �L�����ԏI�����̌��ɑ��݂���F�藚������������B
				// �������Ď擾�����F�藚���̌��������[�v����B
				for (int i = 0; i < getKaigoHistoryList().size(); i++) {

					// �ҏW���[�h�̏ꍇ
					// ���g�̗����͖�������B
					if (checkMode == CHECK_MODE_UPDATE) {
						if (i == getKaigoInfoTable().getSelectedModelRow()) {
							continue;
						}
					}

					VRMap map = (VRMap) getKaigoHistoryList().get(i);

					// �Ώۂ̗�������Y���̏ꍇ�͖�������B
					int targetJotaiCode = ACCastUtilities
							.toInt(VRBindPathParser.get("JOTAI_CODE", map));
					if (targetJotaiCode == YOUKAIGODO_HIGAITOU) {
						continue;
					}

					reservedStart = (Date) VRBindPathParser.get(
							"INSURE_VALID_START", map);
					reservedEnd = (Date) VRBindPathParser.get(
							"INSURE_VALID_END", map);

					if (ACDateUtilities.compareOnMonth(end, reservedStart) == 0
							|| ACDateUtilities.compareOnMonth(end, reservedEnd) == 0) {
						// �����̔�ی��Ҕԍ���kaigoInfoInsuredId�i��ی��Ҕԍ��j��
						// ���͂���Ă����ی��Ҕԍ����قȂ�ꍇ
						if (!insuredId.equals(ACCastUtilities
								.toString(VRBindPathParser.get("INSURED_ID",
										map)))) {
							// ���l�^�ϐ�num��1��������B
							num += 1;
						}

						// num�̒l��2�̏ꍇ
						if (num == 2) {
							getKaigoInfoInsuredId().requestFocus(); // �t�H�[�J�X
							// �G���[���b�Z�[�W��\������B
							QkanMessageList.getInstance()
									.QP002_ERROR_OF_INSURED_ID();
							return false;
						}

					}
				}
			}
		}

        
        // [ID:0000444][Tozo TANAKA] 2009/03/07 add begin ����21�N4���@�����Ή�
        if (getNonCorrespondenceFlg() == 0) {
            // �o�ߓI�v���̊��ԃ`�F�b�N�@���v���x-��Y���̏ꍇ�͍s��Ȃ�
            //���L�̃t�B�[���h�ɓ��͂���Ă�����t���A�v���x�Ɩ������Ă��Ȃ����`�F�b�N����B
            // �EkaigoInfoValidLimit1�i�L�����ԊJ�n���j
            // �EkaigoInfoValidLimit3�i�L�����ԏI�����j
            
            // �I�����Ă���v���x���擾����B
            VRMap temp = (VRMap) getKaigoInfoYokaigoInfo().getSelectedModelItem();
            int jotaiCode = ACCastUtilities.toInt(VRBindPathParser.get("JOTAI_CODE", temp));
            if(jotaiCode == YOUKAIGODO_KEIKATEKI_YOUKAIGO){
                //�I�����Ă���v���x���o�ߓI�v���̏ꍇ
                //���͂��Ă���v���F��̗L�����Ԃ��擾����B
                Date start = getKaigoInfoValidLimit1().getDate();
                Date end = getKaigoInfoValidLimit3().getDate();
                if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, end)<1){
                    //�L�����Ԃ̏I����������21�N4���ȍ~�̏ꍇ
                    //�o�ߓI�v���̗L�����Ԃ͕���21�N3��31���ȑO�ɂ���悤�G���[���b�Z�[�W��\������B
                    QkanMessageList.getInstance().ERROR_OF_GREATER_DATE_RELATION("�o�ߓI�v���̗L�����Ԃ�","","����21�N3��31��");
                    //�����𒆒f����B
                    return false;
                }
            }
            
        }
        // [ID:0000444][Tozo TANAKA] 2009/03/07 add end
        

		// �ҏW�{�^��������
		if (checkMode == CHECK_MODE_UPDATE) {
			// �X�V���[�h�̏ꍇ
			if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {

				// �Ώۂ̔F��̏����擾
				VRMap temp = (VRMap) getKaigoInfoTable()
						.getSelectedModelRowValue();
				// �Ώۂ̔F��̗v���x��ޔ�
				int targetJotaiCode = ACCastUtilities.toInt(VRBindPathParser
						.get("JOTAI_CODE", temp));

				// SQL���擾�p
				VRMap param = null;
				// SQL���i�[�p
				String strSql = null;

				// �g�����U�N�V�����J�n�@���T�[�r�X���̍X�V��h��
				getDBManager().beginTransaction();

				// �V���ɓ��͂��ꂽ�L�����Ԓ��̃T�[�r�X�\��E���т̃��R�[�h���擾���邽�߂�
				// HashMap�Fparam�𐶐����A���L��KEY/VALUE��ݒ肷��B
				// �EKEY�FPATIENT_ID�@VALUE�FpatientId
				// �EKEY�FVALID_START�@VALUE�FkaigoInfoValidLimit1�i�L�����ԊJ�n�j�̒l
				// �EKEY�FVALID_END�@VALUE�FkaigoInfoValidLimit3�i�L�����ԏI���j�̒l
				param = new VRHashMap();
				VRBindPathParser.set("PATIENT_ID", param, new Integer(
						getPatientId()));
				if (getNonCorrespondenceFlg() == 0) {
					// ��Y���̏ꍇ�͓��͂��ꂽ�L�����Ԃ͕K�v�Ȃ�
					VRBindPathParser.set("VALID_START", param,
							getKaigoInfoValidLimit1().getDate());
					VRBindPathParser.set("VALID_END", param,
							getKaigoInfoValidLimit3().getDate());
				}

				// �V���ɓ��͂��ꂽ�L�����Ԓ��̃T�[�r�X�\��E���т̃��R�[�h���擾����B
				strSql = getSQL_GET_PATIENT_RESERVED_SERVICE(param);
				VRList newList = getDBManager().executeQuery(strSql);

				// �o�^����Ă����L�����Ԓ��̃T�[�r�X�\��E���т̃��R�[�h���擾���邽�߂�
				// HashMap�Fparam�𐶐����A���L��KEY/VALUE��ݒ肷��B	
				// �EKEY�FPATIENT_ID�@VALUE�FpatientId
				// �EKEY�FVALID_START�@VALUE�F�I�����R�[�h�̗L�����ԊJ�n�̒l
				// �EKEY�FVALID_END�@VALUE�F�I�����R�[�h�̗L�����ԏI���̒l
				param = new VRHashMap();
				VRBindPathParser.set("PATIENT_ID", param, new Integer(
						getPatientId()));
				if (targetJotaiCode != YOUKAIGODO_HIGAITOU) {
					// �Ώۂ̔F��̗v���x����Y���̏ꍇ�͕K�v�Ȃ�
					VRBindPathParser.set("VALID_START", param, VRBindPathParser
							.get("INSURE_VALID_START", temp));
					VRBindPathParser.set("VALID_END", param, VRBindPathParser
							.get("INSURE_VALID_END", temp));
				}

				// �o�^����Ă����L�����Ԓ��̃T�[�r�X�\��E���т̃��R�[�h���擾����B
				strSql = getSQL_GET_PATIENT_RESERVED_SERVICE(param);
				VRList oldList = getDBManager().executeQuery(strSql);

				// �R�~�b�g
				getDBManager().commitTransaction();

				// �I�����ꂽ�����̗v���x����Y���łȂ��ꍇ
				if (targetJotaiCode != YOUKAIGODO_HIGAITOU) {
					if (getNonCorrespondenceFlg() == 0) {
						// �I�����ꂽ�v���x����Y���łȂ��ꍇ
						// �擾����2�̃f�[�^���r����B
						if (!(oldList == null || oldList.size() == 0)) {
							boolean stopFlg = false;
							for (int i = 0; i < oldList.size(); i++) {
								// �o�^����Ă����L�����Ԓ��̃T�[�r�X���A���͂��ꂽ�L�����Ԃɑ��݂��Ȃ��ꍇ

								// oldList�̃��R�[�h��newList���猟�����A�C���f�b�N�X���擾����B
								int index = ACBindUtilities
										.getMatchIndexFromMap(newList,
												"SERVICE_ID", (VRMap) oldList
														.get(i));

								// ���݂��Ȃ������ꍇ
								if (index == -1) {
									// ���b�Z�[�W��\������B				
									// �E���b�Z�[�WID�FQU002_WARNING_OF_OUT_OF_VALID
									msgParam1 = "�ҏW";
									switch (QkanMessageList.getInstance()
											.QU002_WARNING_OF_OUT_OF_VALID(
													msgParam1)) {
									case ACMessageBox.RESULT_OK:
										stopFlg = true;
										break;
									case ACMessageBox.RESULT_CANCEL:
										return false;
									}
								}
								// OK���I�����ꂽ�ꍇ�̓��[�v�I��
								if (stopFlg) {
									break;
								}
							}
						}
					} else {
						// �I�����ꂽ�v���x����Y���̏ꍇ
						// �v���x���� �� ��Y���̃P�[�X
						if (!(oldList == null || oldList.size() == 0)) {
							// ���ɓo�^����Ă���T�[�r�X������ꍇ
							msgParam1 = "�ҏW";
							switch (QkanMessageList.getInstance()
									.QU002_WARNING_OF_OUT_OF_VALID(msgParam1)) {
							case ACMessageBox.RESULT_CANCEL:
								return false;
							}
						}
					}
				}
			}
		}

		if (getNonCorrespondenceFlg() == 0) {
			// ���̓`�F�b�N�G���[���������Ȃ������ꍇ

			// ���t���␳

			// ��ی��Ҕԍ�
			String insuredId = getKaigoInfoInsuredId().getText();
			// ���t��
			int insureRate = ACCastUtilities.toInt(getKaigoInfoBenefit()
					.getText(), 0);

			if (insuredId.charAt(0) == 'H') {
				// ��ی��Ҕԍ����uH�`�v�ƂȂ��Ă���ꍇ
				if (insureRate != INSURE_RATE_SEIHO) {
					// ���t�����u0%�v�ƂȂ��Ă��Ȃ��ꍇ
					switch(QkanMessageList.getInstance()
							.QU002_WARNING_OF_CHANGE_RATE_FOR_SEIHO_TANDOKU()) {
					case ACMessageBox.RESULT_YES:
						// ���t�����u0%�v�ɐݒ肷��B
						getKaigoInfoBenefit().setText(
								ACCastUtilities.toString(INSURE_RATE_SEIHO));
						break;
					case ACMessageBox.RESULT_CANCEL:
						// �����𔲂���
						return false;
					}
				}
				// ����o�^�����Ȃ������b�Z�[�W��\������B	
				// �E���b�Z�[�WID�FQU002_REQUEST_TO_INSERT_SEIHO
				QkanMessageList.getInstance().QU002_REQUEST_TO_INSERT_SEIHO();
			}

			// �L�����Ԏ�������
			if (doUpdateFlg == 1) {

				// ���͂��ꂽ�L�����ԊJ�n��
				Date start = getKaigoInfoValidLimit1().getDate();

				// ���������m�F���b�Z�[�W�ŁuOK�v��I�������ꍇ
				// kaigoInfoValidLimit1�i�L�����ԊJ�n���j�̒l���擾���A�O���̒l�ɕϊ�����B
				Date changedDate = ACDateUtilities.addDay(start, -1);
				// �ϊ������l���A���Ƀe�[�u���ɓo�^����Ă���v���F�藚���̂����A
				// �d�Ȃ��Ă���F��̗L�����ԏI�����ɐݒ肷��B
				VRBindPathParser.set("INSURE_VALID_END",
						(VRMap) getKaigoHistoryList().get(targetIndex),
						changedDate);
			}
		}

		// �߂�l�Ƃ���true��Ԃ��B
		return true;

	}

	/**
	 * �u�ۑ������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @throws Exception ������O
	 */
	public boolean doSave() throws Exception {
		// �ۑ��������s���B
		// ���p�ҏ��̓o�^
		try {

			// SQL���擾�pVRMap param���`����B
			VRMap param = null;
			// SQL���i�[�pString strSql���`����B
			String strSql = null;
			// ��ʏ�̃f�[�^�i�[�p
			VRMap data = new VRHashMap();

			// ��������҃`�F�b�N��OFF�̏ꍇ
			if (!getInstitutionInfoTokuteiNyusho().isSelected()) {
				// ���S���x�z�ɋ󕶎���\������B
				getInstitutionInfoDinnerBearLimitMoneyText().setText("");
				getInstitutionInfoUnitRoomLimitMoneyText().setText("");
				getInstitutionInfoUnitSemiRoomLimitMoneyText().setText("");
				getInstitutionInfoNormalRoomLimitMoneyText().setText("");
				getInstitutionInfoNormalRoomLimitMoneyText2().setText("");
				getInstitutionInfoTasyoRoomLimitMoneyText().setText("");
			}

			// ��ʏ�̃f�[�^�̎擾
			// �\�[�X����
			data = (VRMap) getContents().createSource();
			// ��ʂɐݒ�
			getContents().setSource(data);
			// ��ʏ�̃f�[�^�𗬂�����
			getContents().applySource();

			// �g�����U�N�V�����J�n
			getDBManager().beginTransaction();

			// ���p�Ҋ�{���
			if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
				// �V�K�̏ꍇ�iprocessMode�����ʒ萔��PROCESS_MODE_INSERT�j

				//		    // ���p��ID���擾���ApatientId�Ɋi�[����B
				//  			setPatientId(
				//  					QkanCommon.getBookingNumber(getDBManager(), "PATIENT", "PATIENT_ID", 1));

				//		    // ��ʏ�̃f�[�^�Ɏ擾�������p��ID��ǉ�����B
				//		    VRBindPathParser.set("PATIENT_ID", data, new Integer(getPatientId()));

				// SQL���擾�pHashMap�Fparam�𐶐����A��ʏ�̃f�[�^��ݒ肷��B
				param = new VRHashMap();
				param = data;

				// ���p�ҏ��iPATIENT�j�ɉ�ʏ�̃f�[�^��o�^����B
				// ���܂��R�~�b�g���Ȃ��B  			
				strSql = getSQL_INSERT_PATIENT(param);
				getDBManager().executeUpdate(strSql);

				// ���p��ID���擾���ApatientId�Ɋi�[����B
				param = new VRHashMap();

				strSql = getSQL_GET_NEW_PATIENT_ID(param);
				VRList list = getDBManager().executeQuery(strSql);
				VRMap temp = (VRMap) list.get(0);

				// ���p��ID���擾���ApatientId�Ɋi�[����B
				setPatientId(ACCastUtilities.toInt(VRBindPathParser.get(
						"PATIENT_ID", temp)));

				// ��ʏ�̃f�[�^�Ɏ擾�������p��ID��ǉ�����B
				VRBindPathParser.set("PATIENT_ID", data, new Integer(
						getPatientId()));

			} else if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
				// �ҏW�̏ꍇ�iprocessMode�����ʒ萔��PROCESS_MODE_UPDATE�j

				// �p�b�V�u�`�F�b�N�̃^�X�N���N���A����B
				getPassiveChecker().clearPassiveTask();

				// �p�b�V�u�`�F�b�N�����L�̃p�b�V�u�L�[�ōs���B
				// �EKEY�FPASSIVE_CHECK_KEY_PATIENT
				getPassiveChecker().addPassiveUpdateTask(
						getPASSIVE_CHECK_KEY_PATIENT(), 0);

				if (!(getPassiveChecker().passiveCheck(getDBManager()))) {
					// �p�b�V�u�G���[�����������ꍇ

					// �G���[���b�Z�[�W��\������B
					// �E���b�Z�[�WID�FERROR_OF_PASSIVE_CHECK_ON_UPDATE
					QkanMessageList.getInstance()
							.ERROR_OF_PASSIVE_CHECK_ON_UPDATE();

					// �g�����U�N�V��������
					getDBManager().rollbackTransaction();

					// �������I������B
					return false;
				}

				// SQL���擾�pHashMap�Fparam�𐶐����A��ʏ�̃f�[�^��ݒ肷��B
				param = new VRHashMap();
				param = data;

				// ���p��ID��ǉ�
				VRBindPathParser.set("PATIENT_ID", data, new Integer(
						getPatientId()));

				// ���p�ҏ��iPATIENT�j����ʏ�̃f�[�^�ōX�V����B
				// ���܂��R�~�b�g���Ȃ��B
				strSql = getSQL_UPDATE_PATIENT(param);
				getDBManager().executeUpdate(strSql);

			}

			// �v���F�藚�����
			// �v���F�藚�����S���폜
			if (getKaigoDataFlg() == 1) {
				// kaigoDataFlg�̒l��1�̏ꍇ

				// �S���폜�pSQL���擾�̂��߂�HashMap�Fparam�𐶐����A���L��KEY/VALUE��ݒ肷��B
				// �EKEY�FPATIENT_ID VALUE�FpatientId
				param = new VRHashMap();
				VRBindPathParser.set("PATIENT_ID", param, new Integer(
						getPatientId()));

				// �v���F�藚���iPATIENT_NINTEI_HISTORY�j�̊Y�����p�҂̃��R�[�h��S���폜����B
				// ���܂��R�~�b�g���Ȃ��B
				strSql = getSQL_DELETE_NINTEI_HISTORY(param);
				getDBManager().executeUpdate(strSql);

			}

			// �v���F�藚�����o�^
			if (!(getKaigoHistoryList() == null || getKaigoHistoryList().size() == 0)) {

				for (int i = 0; i < getKaigoHistoryList().size(); i++) {

					param = new VRHashMap();
					param = (VRMap) getKaigoHistoryList().get(i);

					if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
						// �V�K�̏ꍇ�iprocessMode�����ʒ萔��PROCESS_MODE_INSERT�j
						// ��ʏ�̃f�[�^�ikaigoHistoryList�j�ɁA���L��KEY/VALUE��ݒ肷��B
						// �EKEY�FPATIENT_ID VALUE�FpatientId
						VRBindPathParser.set("PATIENT_ID", param, new Integer(
								getPatientId()));
					}

					// �v���F�藚���iPATIENT_NINTEI_HISTORY�j�ɉ�ʏ�̃f�[�^�ikaigoHistoryList�j��o�^����B
					// ���܂��R�~�b�g���Ȃ��B
					strSql = getSQL_INSERT_NINTEI_HISTORY(param);
					getDBManager().executeUpdate(strSql);

				}
			}

			// �ٓ��������
			// �ٓ��������S���폜
			if (getIdouDataFlg() == 1) {
				// idouDataFlg�̒l��1�̏ꍇ

				// �S���폜�pSQL���擾�̂��߂�HashMap�Fparam�𐶐����A���L��KEY/VALUE��ݒ肷��B
				// �EKEY�FPATIENT_ID VALUE�FpatientId
				param = new VRHashMap();
				VRBindPathParser.set("PATIENT_ID", param, new Integer(
						getPatientId()));

				// �ٓ������iPATIENT_CHANGES_HISTORY�j�̊Y�����p�҂̃��R�[�h��S���폜����B
				// ���܂��R�~�b�g���Ȃ��B
				strSql = getSQL_DELETE_CHANGES_HISTORY(param);
				getDBManager().executeUpdate(strSql);

			}

			// �ٓ��������o�^
			if (!(getIdouHistoryList() == null || getIdouHistoryList().size() == 0)) {

				for (int i = 0; i < getIdouHistoryList().size(); i++) {

					param = new VRHashMap();
					param = (VRMap) getIdouHistoryList().get(i);

					if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
						// �V�K�̏ꍇ�iprocessMode�����ʒ萔��PROCESS_MODE_INSERT�j
						// ��ʏ�̃f�[�^�iidouHistoryList�j�ɁA���L��KEY/VALUE��ݒ肷��B
						// �EKEY�FPATIENT_ID VALUE�FpatientId
						VRBindPathParser.set("PATIENT_ID", param, new Integer(
								getPatientId()));

					}

					// �ٓ������iPATIENT_CHANGES_HISTORY�j�ɉ�ʏ�̃f�[�^�iidouHistoryList�j��o�^����B
					// ���܂��R�~�b�g���Ȃ��B
					strSql = getSQL_INSERT_CHANGES_HISTORY(param);
					getDBManager().executeUpdate(strSql);

				}
			}

			// �{�ݗ������
			// �{�ݗ������S���폜
			if (getShisetsuDataFlg() == 1) {
				// shisetsuDataFlg�̒l��1�̏ꍇ

				// �S���폜�pSQL���擾�̂��߂�HashMap�Fparam�𐶐����A���L��KEY/VALUE��ݒ肷��B
				// �EKEY�FPATIENT_ID VALUE�FpatientId
				param = new VRHashMap();
				VRBindPathParser.set("PATIENT_ID", param, new Integer(
						getPatientId()));

				// �{�ݗ����iPATIENT_SHISETSU_HISTORY�j�̊Y�����p�҂̃��R�[�h��S���폜����B
				// ���܂��R�~�b�g���Ȃ��B
				strSql = getSQL_DELETE_SHISETSU_HISTORY(param);
				getDBManager().executeUpdate(strSql);

			}

			// �{�ݗ������o�^
			param = new VRHashMap();
			param = data;

			// ���p��ID�ǉ�
			VRBindPathParser.set("PATIENT_ID", param, new Integer(
					getPatientId()));

			// ����ԍ���ǉ�����B
			VRBindPathParser.set("SHISETSU_HISTORY_ID", param, new Integer(1));

			// �{�ݗ����iPATIENT_SHISETSU_HISTORY�j�ɉ�ʏ�̃f�[�^�ishisetsuHistoryList�j��o�^����B
			// ���܂��R�~�b�g���Ȃ��B
			strSql = getSQL_INSERT_SHISETSU_HISTORY(param);
			getDBManager().executeUpdate(strSql);

			// ��L��SQL���s�����ɐ��������ꍇ
			// DB�������R�~�b�g����B
			getDBManager().commitTransaction();

			// ���L�̃t���O������������B
			// �EidouTableChangeFlg
			// �EkaigoTableChangeFlg
			// �EkaigoDataFlg
			// �EidouDataFlg
			// �EshisetsuDataFlg
			setIdouTableChangeFlg(0);
			setKaigoTableChangeFlg(0);
			setKaigoDataFlg(0);
			setIdouDataFlg(0);
			setShisetsuDataFlg(0);

			return true;

		} catch (Exception ex) {
			// ��L��SQL���s�����Ɏ��s�����ꍇ
			// ���[���o�b�N����B
			getDBManager().rollbackTransaction();

			// ��O�𓊂���B
			throw ex;
		}
	}

	/**
	 * �u���R�[�h�擾�E��ʐݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @throws Exception ������O
	 */
	public void doFind() throws Exception {
		// ���R�[�h�擾�E��ʐݒ���s���B

		if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
			// �ҏW�̏ꍇ�iprocessMode�����ʒ萔��PROCESS_MODE_UPDATE�j
			// ���p�ҏ����擾����B
			doFindPatient();

			// �v��엚�������擾����B
			doFindKaigo();

			// �ٓ����������擾����B
			doFindIdou();

			// �{�ݗ��������擾����B
			doFindShisetsu();

			// �擾�������p�ҏ��ipatientInfoList�j�̍ŏ��̃��R�[�h�𒊏o���A
			// �u�N���C�A���g�̈�(contents)�v��source�ɐݒ肷��B
			if (getPatientInfoList().size() > 0) {
				getBasicInfoAndInfoButton().setSource(
						(VRMap) getPatientInfoList().get(0));
			}

			// �擾�����{�ݗ������ishisetsuHistoryList�j�̍ŏ��̃��R�[�h�𒊏o���A
			// �u�N���C�A���g�̈�(contents)�v��source�ɐݒ肷��B
			if (getShisetsuHistoryList().size() > 0) {
				getInstitutionInfos().setSource(
						(VRMap) getShisetsuHistoryList().get(0));
			}

			// ��ʂɓW�J����B
			getContents().bindSource();

		}

		// �擾�����v��엚�����ikaigoHistoryList�j��kaigoTableModel�ɐݒ肷��B
		getKaigoTableModel().setAdaptee(getKaigoHistoryList());

		// �擾�����ٓ��������iidouHistoryList�j��idouTableModel�ɐݒ肷��B
		getIdouTableModel().setAdaptee(getIdouHistoryList());

		if (getKaigoHistoryList() == null || getKaigoHistoryList().size() == 0) {
			// kaigoInfoTable�̃��R�[�h��0���̏ꍇ

			// ������x�����Ə��R���{�𖳌��ɂ���B
			setState_ENABLE_SHIEN_FALSE();

			// ���ی����̈�̏����l�쐬
			VRMap defaultMap = (VRMap) getKaigoInfo().createSource();
			// ���t���ɏ����g�l�F90��ݒ肷��B
			VRBindPathParser.set("INSURE_RATE", defaultMap, "90");
			// �̈�̃N���A
			getKaigoInfo().setSource(defaultMap);
			getKaigoInfo().bindSource();

			// �{�^���̏�Ԃ𖢑I���̏ꍇ�̏�Ԃɐݒ肷��B
			setState_ENABLE_KAIGO_BUTTON_FALSE();

		} else {
			// kaigoInfoTable�̃��R�[�h��1���ȏ�̏ꍇ

			// �e�[�u����1��ڂ�I��������Ԃɂ���B
			getKaigoInfoTable().setSelectedSortedFirstRow();

		}

		if (getIdouHistoryList() == null || getIdouHistoryList().size() == 0) {
			// idouInfoTable�̃��R�[�h��0���̏ꍇ

			// �ٓ��̈�̏�Ԃ�����������B
			setState_IDOU_INIT();

			// �ٓ����̈�̏����l�쐬
			VRMap defaultMap = (VRMap) getIdouInfo().createSource();
			// �̈�̃N���A
			getIdouInfo().setSource(defaultMap);
			getIdouInfo().bindSource();

			// �{�^���̏�Ԃ𖢑I���̏ꍇ�̏�Ԃɐݒ肷��B
			setState_ENABLE_IDOU_BUTTON_FALSE();

		} else {
			// idouInfoTable�̃��R�[�h��1���ȏ�̏ꍇ

			// �e�[�u����1��ڂ�I��������Ԃɂ���B
			getIdouInfoTable().setSelectedSortedFirstRow();

		}

		if (getInstitutionInfoTokuteiNyusho().isSelected()) {
			// ��������҃`�F�b�N��ON�̏ꍇ
			// ���S���x�z�̈��L���ɂ���B
			setState_ENABLE_TOKUTEI_NYUSHO_TRUE();
		} else {
			// ��������҃`�F�b�N��OFF�̏ꍇ
			// ���S���x�z�̈��L���ɂ���B
			setState_ENABLE_TOKUTEI_NYUSHO_FALSE();
		}

		// �V�X�e�����t�ɂ����ėL���ȗv���x��\������B
		displayNowYokaigodo();

		// �t�H�[�J�X
		getBasicInfoPatientCd().requestFocus();

		// �X�i�b�v�V���b�g���B�e����B
		getSnapshot().snapshot();
		getSnapShotKaigo().snapshot();
		getSnapShotIdou().snapshot();

	}

	/**
	 * �u���p�ҏ��擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @throws Exception ������O
	 */
	public void doFindPatient() throws Exception {
		// ���p�ҏ��擾���s���B

		if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {

			// ���p�ҏ��擾���ApatientInfoList�Ɋi�[����B
			setPatientInfoList(QkanCommon.getPatientInfo(getDBManager(),
					getPatientId()));

			if (getPatientInfoList().size() == 0) {
				// ���R�[�h���擾�ł��Ȃ������ꍇ

				// ��O�������s���B���̃��W�b�N��ʂ�͓̂���ʂɑJ�ڂ���Ԃɗ��p��(PATIENT)���폜���ꂽ�ꍇ�ł��邽�߁B
				// �G���[���b�Z�[�W��\������B
				QkanMessageList.getInstance().ERROR_OF_PASSIVE_CHECK_ON_FIND();

				// �O��ʂɖ߂�B(�����𔲂���)
				setCompulsoryBackFlg(1);
				ACFrame.getInstance().back();
				return;

			} else {
				// ���R�[�h���擾�ł����ꍇ

				// ���p�ҏ��ipatientInfoList�j���p�b�V�u�`�F�b�N�p�ɑޔ�����B
				getPassiveChecker().reservedPassive(
						getPASSIVE_CHECK_KEY_PATIENT(), getPatientInfoList());
			}
		}

	}

	/**
	 * �u�v��엚�����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @throws Exception ������O
	 */
	public void doFindKaigo() throws Exception {
		// �v��엚�����擾���s���B

		// �擾�̂��߂�HashMap�Fparam�𐶐����A�ȉ���KEY/VALUE��ݒ肷��B
		VRMap param = new VRHashMap();

		// KEY�FPATIENT_ID�@VALUE�FpatientId
		VRBindPathParser.set("PATIENT_ID", param, new Integer(getPatientId()));

		// �v��엚�������擾���AkaigoHistoryList�Ɋi�[����B
		String strSql = getSQL_GET_PATIENT_KAIGO(param);
		// �擾
		VRList list = getDBManager().executeQuery(strSql);

		// �e�[�u���\���p�ɕҏW���Ċi�[����B    
		setKaigoHistoryList(toKaigoTableList(list));

		if (getKaigoHistoryList().size() > 0) {
			// �v��엚���̃��R�[�h��1���ȏ�̏ꍇ
			// kaigoDataFlg��1��������B
			setKaigoDataFlg(1);
		}

	}

	/**
	 * �u�ٓ��������擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @throws Exception ������O
	 */
	public void doFindIdou() throws Exception {
		// �ٓ��������擾���s���B

		// �擾�̂��߂�HashMap�Fparam�𐶐����A�ȉ���KEY/VALUE��ݒ肷��B
		VRMap param = new VRHashMap();

		// KEY�FPATIENT_ID�@VALUE�FpatientId
		VRBindPathParser.set("PATIENT_ID", param, new Integer(getPatientId()));

		// �ٓ����������擾���AidouHistoryList�Ɋi�[����B
		String strSql = getSQL_GET_PATIENT_CHANGES(param);

		VRList list = getDBManager().executeQuery(strSql);

		// �e�[�u���\���p�ɕҏW����B
		setIdouHistoryList(toIdouTableList(list));

		if (getIdouHistoryList().size() > 0) {
			// �ٓ������̃��R�[�h��1���ȏ�̏ꍇ
			// idouDataFlg��1��������B
			setIdouDataFlg(1);
		}
	}

	/**
	 * �u�{�ݗ������擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @throws Exception ������O
	 */
	public void doFindShisetsu() throws Exception {
		// �{�ݗ������擾���s���B

		// �擾�̂��߂�HashMap�Fparam�𐶐����A�ȉ���KEY/VALUE��ݒ肷��B
		VRMap param = new VRHashMap();

		// KEY�FPATIENT_ID�@VALUE�FpatientId
		VRBindPathParser.set("PATIENT_ID", param, new Integer(getPatientId()));

		// �{�ݗ��������擾���AshisetsuHistoryList�Ɋi�[����B
		String strSql = getSQL_GET_PATIENT_SHISETSU(param);

		setShisetsuHistoryList(getDBManager().executeQuery(strSql));

		if (getShisetsuHistoryList().size() > 0) {
			// �{�ݗ����̃��R�[�h��1���ȏ�̏ꍇ
			// shisetsuDataFlg��1��������B
			setShisetsuDataFlg(1);
		}
	}

	/**
	 * �u��ʑS�̃N���A�����v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @throws Exception ������O
	 */
	public void doClear() throws Exception {
		// ����ʑS�̃N���A����
		// ����ʍ��ڃN���A
		// �u�N���C�A���g�̈�(contents)�v�̃\�[�X�𐶐�����B  	
		VRMap map = (VRMap) getContents().createSource();
		// �u�ꗗ�ɕ\������v�`�F�b�N�{�b�N�X�̒l��ݒ肷��B
		VRBindPathParser.set("SHOW_FLAG", map, new Integer(1));
		// ���t��
		VRBindPathParser.set("INSURE_RATE", map, "90");

		getContents().setSource(map);

		// ��ʂɓW�J����B
		getContents().bindSource();

		// ���S���x�z�̈�𖳌��ɂ���B
		setState_ENABLE_TOKUTEI_NYUSHO_FALSE();

		// ���v���C�x�[�g�ϐ��N���A
		// �ȉ��̃v���C�x�[�g�ϐ�������������B
		// �EpatientId
		// �EpatientInfoList
		// �EkaigoHistoryList  	
		// �EidouHistoryList
		// �EshisetsuHistoryList
		// �EidouTableChangeFlg
		// �EkaigoTableChangeFlg
		// �EkaigoDataFlg
		// �EidouDataFlg
		// �EshisetsuDataFlg
		setPatientId(0);
		getPatientInfoList().clear();
		getKaigoHistoryList().clear();
		getIdouHistoryList().clear();
		getShisetsuHistoryList();
		setIdouTableChangeFlg(0);
		setKaigoTableChangeFlg(0);
		setKaigoDataFlg(0);
		setIdouDataFlg(0);
		setShisetsuDataFlg(0);

		// �V�X�e�����t�ɂ����ėL���ȗv���x��\������B
		displayNowYokaigodo();

		// �����[�h�̐؂�ւ�
		if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
			// �X�V���[�h�̏ꍇ�iprocessMode�����ʒ萔��PROCESS_MODE_UPDATE�j

			// processMode��PROCESS_MODE_INSERT��������B
			setProcessMode(QkanConstants.PROCESS_MODE_INSERT);

		}

		// �Ɩ��{�^���̏�Ԑݒ���s���B
		setState_INSERT_MODE();

		// �t�H�[�J�X
		getBasicInfoPatientCd().requestFocus();

		// �X�i�b�v�V���b�g�B�e
		getSnapshot().snapshot();
		getSnapShotKaigo().snapshot();
		getSnapShotIdou().snapshot();

	}

	/**
	 * �u��ʏ������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @throws Exception ������O
	 */
	public void initialize() throws Exception {
		// ��ʂ̏��������s���B    

		// �Ɩ����}�X�^���A�f�[�^���擾����B
		// �擾�����f�[�^�̃E�B���h�E�^�C�g���iWINDOW_TITLE�j���E�B���h�E�ɐݒ肷��B
		// �擾�����f�[�^�̋Ɩ��^�C�g���iAFFAIR_TITLE�j���Ɩ��{�^���o�[�ɐݒ肷��B   
		setAffairTitle(AFFAIR_ID, getButtons());

		// �p�b�V�u�L�[�̒�`
		setPASSIVE_CHECK_KEY_PATIENT(new ACPassiveKey("PATIENT",
				new String[] { "PATIENT_ID" }, new Format[] { null },
				"LAST_TIME", "LAST_TIME"));

		// �e�[�u�����f���̐���
		ACTableModelAdapter model = null;

		// kaigoTableModel�𐶐�����B
		// "SHINSEI_DATE" "SHUBETSU_CODE" "JOTAI_CODE" "INSURE_VALID_START" "INSURE_VALID_END" "REPORTED_DATE"
		// "STOP_DATE" "STOP_REASON" "LIMIT_RATE"
		model = new ACTableModelAdapter();
		model
				.setColumns(new String[] { "SHINSEI_DATE",
						"SHUBETSU_CODE_NAME", "JOTAI_CODE_NAME",
						"INSURE_VALID_START", "INSURE_VALID_END",
						"REPORTED_DATE", "STOP_DATE", "STOP_REASON_NAME",
						"LIMIT_RATE" });
		setKaigoTableModel(model);

		// idouTableModel�𐶐�����B	
		// "SYSTEM_SERVICE_KIND_DETAIL" "CHANGES_CONTENT" "CHANGES_DATE" "CHANGES_TIME" "CHANGES_REASON"
		model = new ACTableModelAdapter();
		model.setColumns(new String[] { "SERVICE_ABBREVIATION", "CONTENT",
				"CHANGES_DATE", "CHANGES_TIME", "REASON" });
		//  	model.setColumns(new String[]{
		//  			"SYSTEM_SERVICE_KIND_DETAIL",
		//			"CONTENT",
		//			"CHANGES_DATE",
		//			"CHANGES_TIME",
		//			"REASON"
		//  	});  	
		setIdouTableModel(model);

		// �e�[�u�����f�������L�̉�ʃe�[�u���ɐݒ肷��B
		// �E�u�����E�e�[�u���̈�ikaigoInfoTable�j�v
		getKaigoInfoTable().setModel(getKaigoTableModel());
		// �E�u�ٓ����E�e�[�u���̈�iidouInfoTable�j�v
		getIdouInfoTable().setModel(getIdouTableModel());

		// �e�e�[�u���J�����Ƀt�H�[�}�b�^��ݒ肷��B
		// �\���敪
		//    getKaigoInfoTableColumn2().setFormat(new ACHashMapFormat(
		//			new String[] { "�V�K�E���ԏI����V�K", "�X�V", "�ύX" }, 
		//			new Integer[] {new Integer(1), new Integer(2), new Integer(3),}));

		// �v���x
		//    getKaigoInfoTableColumn3().setFormat(new QkanJotaiCodeUnapplicableFormat());

		//    // ���f���R
		//    getKaigoInfoTableColumn8().setFormat(new ACHashMapFormat(
		//			new String[] { "��X�V", "��Y��", "���S" }, 
		//			new Integer[] {new Integer(1),new Integer(2), new Integer(3),}));
		//
		//    // �T�[�r�X
		//    getIdouInfoTableColumn1().setFormat(new QkanServiceFormat());

		//    // �ٓ����R
		//    getIdouInfoTableColumn2().setFormat(new QkanChangesContentFormat());

		//    // �ٓ����R
		//    getIdouInfoTableColumn5().setFormat(new QkanChangesReasonFormat());

		// ���ȕ⊮
		// �����Ƃ��Ȃ��֘A�t����B
		getBasicInfoName1().setKanaField(getBasicInfoFurigana1());
		getBasicInfoName2().setKanaField(getBasicInfoFurigana2());

		// �X�֔ԍ�����Z���ϊ�
		// �X�֔ԍ��ƏZ�����֘A�t����B
		new ACZipRelation(getBasicInfoZip1(), getBasicInfoZip3(),
				getBasicInfoAddress());

		// �X�i�b�v�V���b�g�̎B�e�Ώۂ��u�N���C�A���g�̈�icontents�j�v�Ɏw�肷��B
		getSnapshot().setRootContainer(getContents());

		// ���X�i�b�v�V���b�g�̎B�e�Ώۂ��牺�L�̗̈�����O����B
		// �E�u�ٓ����̈�E��iidouInfoUp�j�v
		// �E�u���ی��̈�ikaigoInfo�j�v
		VRList excusions = new VRArrayList();
		excusions.add(getIdouInfoUp());
		excusions.add(getKaigoInfo());

		getSnapshot().setExclusions(excusions);

		// �v�����̈�̃X�i�b�v�V���b�g
		getSnapShotKaigo().setRootContainer(getKaigoInfo());
		// �ٓ����̈�̃X�i�b�v�V���b�g
		getSnapShotIdou().setRootContainer(getIdouInfo());

		// ��ʐݒ���s���B
		casualInitialize();

		//    if(getProcessMode() == QkanConstants.PROCESS_MODE_INSERT){
		//    	// �V�K�ǉ����[�h�̏ꍇ
		//	    // �u�ꗗ�ɕ\������v�`�F�b�N�{�b�N�X�ɏ����l��ݒ肷��B
		//	    getBasicInfoCheck().setValue(1);
		//    }

		// ��ʂɏ����l��\������B
		VRMap map = (VRMap) getContents().createSource();
		// �u�ꗗ�ɕ\������v�`�F�b�N�{�b�N�X�̒l��ݒ肷��B
		VRBindPathParser.set("SHOW_FLAG", map, new Integer(1));
		
		//��Ìn��\���Ή� fujihara.shin 2009.1.13 add start
		if (!QkanCommon.isShowOldIryo()){
			setState_VISIBLE_OLD_IRYOU_FALSE();
		}
		//��Ìn��\���Ή� fujihara.shin 2009.1.13 add end
		
		getContents().setSource(map);
		getContents().bindSource();

	}

	/**
	 * �u��ʐݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @throws Exception ������O
	 */
	public void casualInitialize() throws Exception {
		//��ʂ�ݒ肷��B

		// VRMap map�𐶐�����B
		VRMap map = new VRHashMap();

		// �V�X�e�����t�̎擾
		setSystemDate(QkanSystemInformation.getInstance().getSystemDate());

		// �R�[�h�}�X�^�f�[�^�̎擾
		setMasterCode(QkanSystemInformation.getInstance().getMasterCode());

		// �R�[�h�}�X�^���牺�L��CODE_ID�̃��R�[�h�𒊏o���A���L��KEY��map�ɐݒ肷��B
		// �ECODE_ID�FCODE_YOKAIGODO�@KEY�FJOTAI_CODE
		VRBindPathParser.set("JOTAI_CODE", map, QkanCommon
				.getArrayFromMasterCode(CODE_YOKAIGODO, "JOTAI_CODE"));

		// �ECODE_ID�FCODE_INSURE_RATE�@KEY�FINSURE_RATE
		//    VRBindPathParser.set(
		//    		"INSURE_RATE", map, QkanCommon.getArrayFromMasterCode(CODE_INSURE_RATE, "INSURE_RATE"));

		// �T�[�r�X�}�X�^���R�[�h���擾���A�ȉ���KEY��map�ɐݒ肷��B
		// �EKEY�FSERVICE
		VRList service = new VRArrayList();
		setMasterService(QkanCommon.getMasterService(getDBManager(),
				TARGET_DATE_20060401));

		VRList temp = new VRArrayList(getMasterService().values());

		if (!(temp == null || temp.size() == 0)) {
			for (int i = 0; i < temp.size(); i++) {
				VRMap serviceMap = (VRMap) temp.get(i);
				int systemServiceKindDetail = ACCastUtilities
						.toInt(VRBindPathParser.get(
								"SYSTEM_SERVICE_KIND_DETAIL", serviceMap));

				//��Ìn��\���Ή� fujihara.shin 2009.1.13 add start
				if ((systemServiceKindDetail == 20101) && !QkanCommon.isShowOldIryo()){
					continue;
				}
				//��Ìn��\���Ή� fujihara.shin 2009.1.13 add end
				
				// �u���̑��v�u��ȓ��퐶����̊����v��r��
				if (!(systemServiceKindDetail == SERVICE_TYPE_OTHER || systemServiceKindDetail == SERVICE_TYPE_ROUTINE)) {
					service.add(serviceMap);
				}

			}
		}

		VRBindPathParser.set("SERVICE", map, service);

		// ������x�����Ə������擾���Alist�Ɋi�[����B
		// ��������x���A���K�͑��@�\�^��񋟂��Ă��鎖�Ə�
		VRList serviceKind = new VRArrayList();
		serviceKind.add(new Integer(SERVICE_TYPE_SHIEN));
		serviceKind.add(new Integer(SERVICE_TYPE_SHOKIBO));
		setProviderListKaigoShien(QkanCommon.getProviderInfo(getDBManager(),
				serviceKind));

		// �����\�h�x���A���\�h���K�͑��@�\�^��񋟂��Ă��鎖�Ə�
		serviceKind = new VRArrayList();
		serviceKind.add(new Integer(SERVICE_TYPE_YOBOU_SHIEN));
		serviceKind.add(new Integer(SERVICE_TYPE_YOBOU_SHOKIBO));
		setProviderListYobouShien(QkanCommon.getProviderInfo(getDBManager(),
				serviceKind));

		//    VRBindPathParser.set(
		//    		"PROVIDER", map, QkanCommon.getProviderInfo(getDBManager(), serviceKind));

		// �ی��ҏ����擾���A�ȉ���KEY��map�ɐݒ肷��B�i�p�����[�^�ȗ��j
		// �EKEY�FINSURER
		VRBindPathParser.set("INSURER", map, QkanCommon
				.getInsurerInfoCareOnly(getDBManager()));

		// map���u�N���C�A���g�̈�icontents�j�v�ɐݒ肷��B
		getContents().setModelSource(map);

		// map����ʂɓW�J����B
		getContents().bindModelSource();

		// �Ɩ��{�^���̏�Ԑݒ���s���B
		if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
			// �V�K�̏ꍇ�iprocessMode�����ʒ萔��PROCESS_MODE_INSERT�j
			setState_INSERT_MODE();
		} else if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
			// �ҏW�̏ꍇ�iprocessMode�����ʒ萔��PROCESS_MODE_UPDATE�j
			setState_UPDATE_MODE();
		}

		// �ٓ����̈�̏�Ԃ�����������B
		setState_IDOU_INIT();
	}

	/**
	 * �u�f�[�^�ҏW�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 *  �F������e�[�u���\���p�ɕҏW����֐��ł��B
	 * @return VRList �F����i�ҏW�ρj
	 * @param VRList �F����i�������j
	 * @throws Exception ������O
	 */
	public VRList toKaigoTableList(VRList list) throws Exception {

		if (list == null) {
			return null;
		}

		VRList result = new VRArrayList();

		// �n���ꂽ�f�[�^�̌��������[�v����B
		for (int i = 0; i < list.size(); i++) {
			// �f�[�^��背�R�[�h�����o���B
			VRMap map = (VRMap) list.get(i);
			// ���R�[�h���e�[�u���\���p�ɕҏW����B
			map = toKaigoTableList(map);
			// �f�[�^�ɒǉ�
			result.add(map);
		}

		return result;

	}

	/**
	 * �u�f�[�^�ҏW�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 *  �F������e�[�u���\���p�ɕҏW����֐��ł��B
	 * @return VRMap �F����i�ҏW�ρj
	 * @param VRMap �F����i�P���j
	 * @throws Exception ������O
	 */
	public VRMap toKaigoTableList(VRMap map) throws Exception {

		if (map == null) {
			return null;
		}

		// �R�[�h�}�X�^��薼�̂��擾����B
		VRList list = null;
		VRMap temp = null;

		// �v���x
		list = new VRArrayList();
		list = (VRList) VRBindPathParser.get(new Integer(CODE_YOKAIGODO),
				getMasterCode());
		temp = new VRHashMap();
		if (VRBindPathParser.has("JOTAI_CODE", map)) {
			temp = ACBindUtilities.getMatchRowFromValue(list, "CONTENT_KEY",
					VRBindPathParser.get("JOTAI_CODE", map));
			if (temp != null) {
				VRBindPathParser.set("JOTAI_CODE_NAME", map, VRBindPathParser
						.get("CONTENT", temp));
			}
		}

		// �\���敪
		list = new VRArrayList();
		list = (VRList) VRBindPathParser.get(new Integer(CODE_SHINSEI_KUBUN),
				getMasterCode());
		temp = new VRHashMap();
		if (VRBindPathParser.has("SHUBETSU_CODE", map)) {
			temp = ACBindUtilities.getMatchRowFromValue(list, "CONTENT_KEY",
					VRBindPathParser.get("SHUBETSU_CODE", map));
			if (temp != null) {
				VRBindPathParser.set("SHUBETSU_CODE_NAME", map,
						VRBindPathParser.get("CONTENT", temp));
			}
		}

		// ���f���R
		list = new VRArrayList();
		list = (VRList) VRBindPathParser.get(new Integer(CODE_TYUDAN_RIYU),
				getMasterCode());
		temp = new VRHashMap();
		if (VRBindPathParser.has("STOP_REASON", map)) {
			temp = ACBindUtilities.getMatchRowFromValue(list, "CONTENT_KEY",
					VRBindPathParser.get("STOP_REASON", map));
			if (temp != null) {
				VRBindPathParser.set("STOP_REASON_NAME", map, VRBindPathParser
						.get("CONTENT", temp));
			}
		}

		return map;

	}

	/**
	 * �u�f�[�^�ҏW�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 *  �ٓ������e�[�u���\���p�ɕҏW����֐��ł��B
	 * @return VRList �ٓ����i�ҏW�ρj
	 * @param VRList �ٓ����i�������j
	 * @throws Exception ������O
	 */
	public VRList toIdouTableList(VRList list) throws Exception {

		if (list == null) {
			return null;
		}

		VRList result = new VRArrayList();

		// �n���ꂽ�f�[�^�̌��������[�v����B
		for (int i = 0; i < list.size(); i++) {
			// �f�[�^��背�R�[�h�����o���B
			VRMap map = (VRMap) list.get(i);
			// ���R�[�h���e�[�u���\���p�ɕҏW����B
			map = toIdouTableList(map);
			// �f�[�^�ɒǉ�
			result.add(map);
		}

		return result;

	}

	/**
	 * �u�f�[�^�ҏW�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 *  �ٓ������e�[�u���\���p�ɕҏW����֐��ł��B
	 * @return VRMap �ٓ����i�ҏW�ρj
	 * @param VRMap �ٓ����i1���j
	 * @throws Exception ������O
	 */
	public VRMap toIdouTableList(VRMap map) throws Exception {

		// �ٓ������e�[�u���\���p�ɕҏW����B

		if (map == null) {
			return null;
		}

		// �n���ꂽ�ٓ����̃T�[�r�X��ރR�[�h
		int serviceType = ACCastUtilities.toInt(VRBindPathParser.get(
				"SYSTEM_SERVICE_KIND_DETAIL", map));

		// �T�[�r�X��ރR�[�h��p���āA�T�[�r�X�f�[�^���擾
		VRMap service = (VRMap) VRBindPathParser.get(new Integer(serviceType),
				getMasterService());

		// �ΏۊO�T�[�r�X�̏ꍇ
		if (service == null) {
			return null;
		}

		// �}�X�^�f�[�^���T�[�r�X���̂̎擾
		String serviceName = ACCastUtilities.toString(VRBindPathParser.get(
				"SERVICE_ABBREVIATION", service));

		// �n���ꂽVRMap�ɐݒ�
		VRBindPathParser.set("SERVICE_ABBREVIATION", map, serviceName);

		// �n���ꂽ�ٓ����̈ٓ����R
		int content = 0;

		if (!(VRBindPathParser.get("CHANGES_CONTENT", map) == null || ""
				.equals(VRBindPathParser.get("CHANGES_CONTENT", map)))) {
			content = ACCastUtilities.toInt(VRBindPathParser.get(
					"CHANGES_CONTENT", map));
		}

		// �n���ꂽ�ٓ����̈ٓ����R
		int reason = 0;

		if (!(VRBindPathParser.get("CHANGES_REASON", map) == null || ""
				.equals(VRBindPathParser.get("CHANGES_REASON", map)))) {
			reason = ACCastUtilities.toInt(VRBindPathParser.get(
					"CHANGES_REASON", map));
		}

		// �T�[�r�X��CHANGES_CONTENT_TYPE���擾
		int contentType = ACCastUtilities.toInt(VRBindPathParser.get(
				"CHANGES_CONTENT_TYPE", service));

		// �ٓ����R�E�ٓ����R�̕ϊ�����
		// ��`
		// �R�[�h�}�X�^���擾�����ٓ����R�ƈٓ����R���i�[����B
		VRList codeContentList;
		VRList codeReasonList;

		VRMap temp;

		switch (contentType) {

		// ����n
		case IDOU_SERVICE_KYOTAKU:
			// �R�[�h�}�X�^��苏��n�ٓ����R�̃f�[�^�擾
			codeContentList = new VRArrayList();
			codeContentList = (VRList) VRBindPathParser.get(new Integer(
					CODE_IDOU_CONTENT_KYOTAKU), getMasterCode());

			// �ٓ����R�@��CONTENT��ǉ�
			temp = new VRHashMap();
			temp = (VRMap) ACBindUtilities.getMatchRowFromValue(
					codeContentList, "CONTENT_KEY", new Integer(content));

			VRBindPathParser.set("CONTENT", map, VRBindPathParser.get(
					"CONTENT", temp));

			if (content == IDOU_STOP_KYOTAKU) {

				// �R�[�h�}�X�^��苏��n�ٓ����R�̃f�[�^�擾
				codeReasonList = new VRArrayList();
				codeReasonList = (VRList) VRBindPathParser.get(new Integer(
						CODE_IDOU_REASON_KYOTAKU), getMasterCode());

				// �ٓ����R�@��REASON��ǉ�
				temp = new VRHashMap();
				temp = (VRMap) ACBindUtilities.getMatchRowFromValue(
						codeReasonList, "CONTENT_KEY", new Integer(reason));

				VRBindPathParser.set("REASON", map, VRBindPathParser.get(
						"CONTENT", temp));

			}

			break;

		// �{�݌n1
		case IDOU_SERVICE_SHISETSU1:
			// �R�[�h�}�X�^���{�݌n1�ٓ����R�̃f�[�^�擾
			codeContentList = new VRArrayList();
			codeContentList = (VRList) VRBindPathParser.get(new Integer(
					CODE_IDOU_CONTENT_SHISETSU1), getMasterCode());

			// �ٓ����R�@��CONTENT��ǉ�
			temp = new VRHashMap();
			temp = (VRMap) ACBindUtilities.getMatchRowFromValue(
					codeContentList, "CONTENT_KEY", new Integer(content));

			VRBindPathParser.set("CONTENT", map, VRBindPathParser.get(
					"CONTENT", temp));

			if (content == IDOU_STOP_SHISETSU1) {

				// �R�[�h�}�X�^���{�݌n1�ٓ����R�̃f�[�^�擾
				codeReasonList = new VRArrayList();
				codeReasonList = (VRList) VRBindPathParser.get(new Integer(
						CODE_IDOU_REASON_SHISETSU1), getMasterCode());

				// �ٓ����R�@��REASON��ǉ�
				temp = new VRHashMap();
				temp = (VRMap) ACBindUtilities.getMatchRowFromValue(
						codeReasonList, "CONTENT_KEY", new Integer(reason));

				VRBindPathParser.set("REASON", map, VRBindPathParser.get(
						"CONTENT", temp));

			}
			//[ID:0000453][Shin Fujihara] 2009/02 add begin ����21�N4���@�����Ή�
			else if (content == IDOU_START_SHISETSU1){
				codeReasonList = new VRArrayList();
				codeReasonList = (VRList) VRBindPathParser.get(new Integer(CODE_IDOU_REASON_NYUSYO_NYUIN), getMasterCode());
				// �ٓ����R�@��REASON��ǉ�
				temp = new VRHashMap();
				temp = (VRMap) ACBindUtilities.getMatchRowFromValue(codeReasonList, "CONTENT_KEY", new Integer(reason));
				VRBindPathParser.set("REASON", map, VRBindPathParser.get("CONTENT", temp));
			}
			//[ID:0000453][Shin Fujihara] 2009/02 add end ����21�N4���@�����Ή�
			break;

		// �{�݌n2
		case IDOU_SERVICE_SHISETSU2:
			// �R�[�h�}�X�^���{�݌n2�ٓ����R�̃f�[�^�擾
			codeContentList = new VRArrayList();
			codeContentList = (VRList) VRBindPathParser.get(new Integer(
					CODE_IDOU_CONTENT_SHISETSU2), getMasterCode());

			// �ٓ����R�@��CONTENT��ǉ�
			temp = new VRHashMap();
			temp = (VRMap) ACBindUtilities.getMatchRowFromValue(
					codeContentList, "CONTENT_KEY", new Integer(content));

			VRBindPathParser.set("CONTENT", map, VRBindPathParser.get(
					"CONTENT", temp));

			if (content == IDOU_STOP_SHISETSU2) {

				// �R�[�h�}�X�^���{�݌n2�ٓ����R�̃f�[�^�擾
				codeReasonList = new VRArrayList();
				codeReasonList = (VRList) VRBindPathParser.get(new Integer(
						CODE_IDOU_REASON_SHISETSU2), getMasterCode());

				// �ٓ����R�@��REASON��ǉ�
				temp = new VRHashMap();
				temp = (VRMap) ACBindUtilities.getMatchRowFromValue(
						codeReasonList, "CONTENT_KEY", new Integer(reason));

				VRBindPathParser.set("REASON", map, VRBindPathParser.get(
						"CONTENT", temp));

			}
			//[ID:0000453][Shin Fujihara] 2009/02 add begin ����21�N4���@�����Ή�
			else if (content == IDOU_START_SHISETSU2){
				codeReasonList = new VRArrayList();
				codeReasonList = (VRList) VRBindPathParser.get(new Integer(CODE_IDOU_REASON_NYUSYO_NYUIN), getMasterCode());
				// �ٓ����R�@��REASON��ǉ�
				temp = new VRHashMap();
				temp = (VRMap) ACBindUtilities.getMatchRowFromValue(codeReasonList, "CONTENT_KEY", new Integer(reason));
				VRBindPathParser.set("REASON", map, VRBindPathParser.get("CONTENT", temp));
			}
			//[ID:0000453][Shin Fujihara] 2009/02 add end ����21�N4���@�����Ή�
			
			break;

		// ��ÊŌ�
		case IDOU_SERVICE_IRYO_KANGO:
			// �R�[�h�}�X�^����ÊŌ�ٓ����R�̃f�[�^�擾
			codeContentList = new VRArrayList();
			codeContentList = (VRList) VRBindPathParser.get(new Integer(
					CODE_IDOU_CONTENT_IRYO_KANGO), getMasterCode());

			// �ٓ����R�@��CONTENT��ǉ�
			temp = new VRHashMap();
			temp = (VRMap) ACBindUtilities.getMatchRowFromValue(
					codeContentList, "CONTENT_KEY", new Integer(content));

			VRBindPathParser.set("CONTENT", map, VRBindPathParser.get(
					"CONTENT", temp));

			if (content == IDOU_STOP_IRYO_KANGO) {

				// �R�[�h�}�X�^����ÊŌ�ٓ����R�̃f�[�^�擾
				codeReasonList = new VRArrayList();
				codeReasonList = (VRList) VRBindPathParser.get(new Integer(
						CODE_IDOU_REASON_IRYO_KANGO), getMasterCode());

				// �ٓ����R�@��REASON��ǉ�
				temp = new VRHashMap();
				temp = (VRMap) ACBindUtilities.getMatchRowFromValue(
						codeReasonList, "CONTENT_KEY", new Integer(reason));

				VRBindPathParser.set("REASON", map, VRBindPathParser.get(
						"CONTENT", temp));

			}

			break;

		// �{�݌n3
		case IDOU_SERVICE_SHISETSU3:
			// �R�[�h�}�X�^���{�݌n3�ٓ����R�̃f�[�^�擾
			codeContentList = new VRArrayList();
			codeContentList = (VRList) VRBindPathParser.get(new Integer(
					CODE_IDOU_CONTENT_SHISETSU3), getMasterCode());

			// �ٓ����R�@��CONTENT��ǉ�
			temp = new VRHashMap();
			temp = (VRMap) ACBindUtilities.getMatchRowFromValue(
					codeContentList, "CONTENT_KEY", new Integer(content));

			VRBindPathParser.set("CONTENT", map, VRBindPathParser.get(
					"CONTENT", temp));

			if (content == IDOU_STOP_IRYO_KANGO) {

				// �R�[�h�}�X�^���{�݌n3�ٓ����R�̃f�[�^�擾
				codeReasonList = new VRArrayList();
				codeReasonList = (VRList) VRBindPathParser.get(new Integer(
						CODE_IDOU_REASON_SHISETSU3), getMasterCode());

				// �ٓ����R�@��REASON��ǉ�
				temp = new VRHashMap();
				temp = (VRMap) ACBindUtilities.getMatchRowFromValue(
						codeReasonList, "CONTENT_KEY", new Integer(reason));

				VRBindPathParser.set("REASON", map, VRBindPathParser.get(
						"CONTENT", temp));

			}
			//[ID:0000453][Shin Fujihara] 2009/02 add begin ����21�N4���@�����Ή�
			else if (content == IDOU_START_SHISETSU3){
				codeReasonList = new VRArrayList();
				codeReasonList = (VRList) VRBindPathParser.get(new Integer(CODE_IDOU_REASON_NYUSYO_NYUIN), getMasterCode());
				// �ٓ����R�@��REASON��ǉ�
				temp = new VRHashMap();
				temp = (VRMap) ACBindUtilities.getMatchRowFromValue(codeReasonList, "CONTENT_KEY", new Integer(reason));
				VRBindPathParser.set("REASON", map, VRBindPathParser.get("CONTENT", temp));
			}
			//[ID:0000453][Shin Fujihara] 2009/02 add end ����21�N4���@�����Ή�
			break;
		}

		return map;

	}

	/**
	 * �u���݂̗v���x��\���v�Ɋւ��鏈�����s�Ȃ��܂��B
	 *  
	 * @throws Exception ������O
	 */
	public void displayNowYokaigodo() throws Exception {
		// ���݂̗v���x��\������
		String yokaigodoNow = "";
		boolean hasHigaito = false;
		VRList target = (VRList) getKaigoTableModel().getAdaptee();

		if (target == null || target.size() == 0) {
			// �����������Ă��Ȃ��P�[�X
			yokaigodoNow = "�F�藚���Ȃ�";
		} else {
			for (int i = 0; i < target.size(); i++) {
				VRMap temp = (VRMap) target.get(i);
				Date start = ACCastUtilities.toDate(VRBindPathParser.get(
						"INSURE_VALID_START", temp));
				Date end = ACCastUtilities.toDate(VRBindPathParser.get(
						"INSURE_VALID_END", temp));
				if (isValidTermOnTargetDate(getSystemDate(), start, end)) {
					// �V�X�e�����t�ɂ����ėL���ȔF�藚���ł���ꍇ
					int yokaigodo = ACCastUtilities.toInt(VRBindPathParser.get(
							"JOTAI_CODE", temp));
					if (yokaigodo == YOUKAIGODO_HIGAITOU) {
						// ��Y���̏ꍇ�͈ꎞ�ۗ�
						hasHigaito = true;
					} else {
						// ��Y���łȂ��ꍇ�̓��[�v�I��
						yokaigodoNow = ACCastUtilities
								.toString(VRBindPathParser.get(
										"JOTAI_CODE_NAME", temp));
						break;
					}
				}
			}
		}

		// ��L���[�v�Ō��݂̗v���x���擾�ł��Ȃ��P�[�X
		if (yokaigodoNow == null || "".equals(yokaigodoNow)) {
			if (hasHigaito) {
				// ��Y���������Ă���P�[�X
				yokaigodoNow = "��Y��";
			} else {
				// ��Y���������Ă��Ȃ��P�[�X
				yokaigodoNow = "�L�����ԊO";
			}
		}

		// �\��
		getYokaigodoNow().setText(yokaigodoNow);

	}

	/**
	 * �u�L���Ȋ��Ԃ��ǂ����̔���v�Ɋւ��鏈�����s�Ȃ��܂��B
	 *  �w����t�ɂ����ėL���Ȋ��Ԃ��ǂ����𔻒肷��֐��ł��B
	 * @throws Exception ������O
	 */
	public boolean isValidTermOnTargetDate(Date targetDate, Date start, Date end)
			throws Exception {
		// �w����t�ɂ����ėL���Ȋ��Ԃ��ǂ����𔻒肷��֐�

		if (ACDateUtilities.getDifferenceOnDay(targetDate, start) >= 0
				&& ACDateUtilities.getDifferenceOnDay(targetDate, end) <= 0) {
			return true;
		}

		return false;
	}

	public Component getFirstFocusComponent() {
		return getBasicInfoPatientCd();
	}
}
