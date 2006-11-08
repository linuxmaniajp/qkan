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
 * �쐬��: 2006/01/21  ���{�R���s���[�^�[������� ��i�@�a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���p�ҊǗ� (U)
 * �v���Z�X ��ÊŌ����� (003)
 * �v���O���� ��ÊŌ����� (QU003)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qu.qu003;

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
import jp.nichicom.ac.text.ACHashMapFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
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

/**
 * ��ÊŌ�����(QU003) 
 */
public class QU003 extends QU003Event {
	/**
	 * �R���X�g���N�^�ł��B
	 */
	public QU003() {
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

		// �EpatientId�@KEY�FPATIENT_ID
		if (VRBindPathParser.has("PATIENT_ID", param)) {
			setPatientId(ACCastUtilities.toInt(VRBindPathParser.get(
					"PATIENT_ID", param)));
		}

		// �EprocessStart�@KEY�FPROCESS_START
		if (VRBindPathParser.has("PROCESS_START", param)) {
			setProcessStart(ACCastUtilities.toString(VRBindPathParser.get(
					"PROCESS_START", param)));
		}

		// �n��p�����[�^�̍폜
		param.clear();

		// ��ʂ̏��������s���B
		initialize();

		// DB���f�[�^���擾���A��ʂɐݒ肷��B
		doFind();

	}

	public boolean canBack(VRMap parameters) throws Exception {
		if (!super.canBack(parameters)) {
			return false;
		}

		boolean unsettledInfoExistFlg = false;

		// �����߂�t���O��1�̏ꍇ		
		if (getCompulsoryBackFlg() == 1) {
			// �ȉ��̒l���p�����[�^�ɐݒ肷��B	
			// KEY�FCOMPULSORY_BACK_FLG  VALUE�FcompulsoryBackFlg
			VRBindPathParser.set("COMPULSORY_BACK_FLG", parameters,
					new Integer(getCompulsoryBackFlg()));
			// �O��ʂɑJ�ڂ���B	
			return true;
		}

		// �ύX�`�F�b�N(�j������\���̂�����)
		if (getSnapShotIryo().isModified()) {
			unsettledInfoExistFlg = true;
		}

		// �ύX�`�F�b�N�i�X�i�b�v�V���b�g�̃`�F�b�N�A��ʃe�[�u���̃`�F�b�N�j
		if (getSnapshot().isModified() || getMedicalTableChangeFlg() == 1
				|| unsettledInfoExistFlg) {
			// �Ō�ɕۑ�����Ă���A���ځE��ʃe�[�u�����ύX����Ă���ꍇ
			// (���L�̂����ꂩ�̏ꍇ)
			// �EisModified
			// �EmedicalTableChangeFlg = 1

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
							String msgParam = "��Õی����";
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
						if (!isValidInputStation()) {
							// ���̓G���[������ꍇ				    	
							// �������I������B
							return false;
						}

						// �ۑ��������s���B
						if (!doSave()) {
							// �p�b�V�u�G���[�����������ꍇ
							return false;
						}

						// �ۑ�����������I�������ꍇ
						//				    	// ���������ʒm���b�Z�[�W��\������B
						//				        // �E���b�Z�[�WID�FINSERT_SUCCESSED
						//				    	QkanMessageList.getInstance().INSERT_SUCCESSED();

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
				// �E���b�Z�[�WID�FWARNING_OF_UPDATE_ON_MODIFIED;

				switch (QkanMessageList.getInstance()
						.WARNING_OF_UPDATE_ON_MODIFIED()) {
				case ACMessageBox.RESULT_OK:
					// �u�͂��v��I�������ꍇ

					try {
						// �j��������񂪂��邱�Ƃ�`���郁�b�Z�[�W
						if (unsettledInfoExistFlg) {
							// ���b�Z�[�W�\��
							String msgParam = "��Õی����";
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
						if (!isValidInputStation()) {
							// ���̓G���[������ꍇ				    	
							// �������I������B
							return false;
						}

						// �ۑ��������s���B
						if (!doSave()) {
							// �p�b�V�u�G���[�����������ꍇ
							return false;
						}

						// �ۑ�����������I�������ꍇ
						//					    // ���������ʒm���b�Z�[�W��\������B
						//					    // �E���b�Z�[�WID�FUPDATE_SUCCESSED
						//					    QkanMessageList.getInstance().UPDATE_SUCCESSED();

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

		// ���L��n��p�����[�^�Ƃ��āA�u���p�ғo�^�iQU002�j�v��ʂɖ߂�B
		// �EKEY�FPATIENT_ID VALUE�FpatientId�i���p��ID�j
		// �EKEY�FPROCESS_MODE VALUE�F�i���ʒ萔��PROCESS_MODE_UPDATE�i�v���Z�X���[�h�u�X�V�v�j�j
		// �EKEY�FPROCESS_START VALUE�FprocessStart
		VRBindPathParser.set("PATIENT_ID", parameters, new Integer(
				getPatientId()));
		VRBindPathParser.set("PROCESS_MODE", parameters, new Integer(
				QkanConstants.PROCESS_MODE_UPDATE));
		VRBindPathParser.set("PROCESS_START", parameters, getProcessStart());

		// �O��ʂւ̑J�ڂ�������Ȃ��true��Ԃ��B
		return true;
	}

	public boolean canClose() throws Exception {
		if (!super.canClose()) {
			return false;
		}

		// �ύX�`�F�b�N�i�X�i�b�v�V���b�g�A��ʃe�[�u���̃`�F�b�N�j
		if (getSnapshot().isModified() || getMedicalTableChangeFlg() == 1) {
			// �Ō�ɕۑ�����Ă���A���ځE�e�[�u�����ύX����Ă���ꍇ
			// (���L�̂����ꂩ�̏ꍇ�j
			// �EisModified
			// �EmedicalTableChangeFlg = 1

			// �I���m�F���b�Z�[�W��\������B
			switch (QkanMessageList.getInstance()
					.WARNING_OF_CLOSE_ON_MODIFIED()) {
			// �E���b�Z�[�WID�FWARNING_OF_CLOSE_ON_MODIFIED

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

		try {

			// �ύX�`�F�b�N(�j������\���̂�����)
			if (getSnapShotIryo().isModified()) {
				// ���b�Z�[�W�\��
				String msgParam = "��Õی����";
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
			if (!isValidInputStation()) {
				// ���̓G���[���������ꍇ
				// �����𒆒f����B(�I��)
				return;
			}

			// �ۑ��������s���B
			if (!doSave()) {
				// �p�b�V�u�G���[���N�����ꍇ
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
			// �i�I���j
			QkanMessageList.getInstance().INSERT_SUCCESSED();

		} catch (Exception ex) {
			// �ۑ�����������I�����Ȃ������ꍇ
			// �������I������B
			throw ex;
		}
	}

	/**
	 * �uDB�X�V�v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void updateActionPerformed(ActionEvent e) throws Exception {

		try {

			// �ύX�`�F�b�N(�j������\���̂�����)
			if (getSnapShotIryo().isModified()) {
				// ���b�Z�[�W�\��
				String msgParam = "��Õی����";
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
			if (!isValidInputStation()) {
				// ���̓G���[���������ꍇ
				// �����𒆒f����B(�I��)
				return;
			}

			// �ۑ��������s���B
			if (!doSave()) {
				// �p�b�V�u�G���[���N�����ꍇ
				return;
			}

			// �ۑ�����������I�������ꍇ
			// ��ʂ̐ݒ���s���B
			casualInitialize();

			// �ŐV�̃f�[�^���擾����B
			doFind();

			// �������b�Z�[�W��\������B
			// �E���b�Z�[�WID�FUPDATE_SUCCESSED
			//�i�I���j
			QkanMessageList.getInstance().UPDATE_SUCCESSED();

		} catch (Exception ex) {
			// �ۑ�����������I�����Ȃ������ꍇ
			// �������I������B
			throw ex;
		}
	}

	/**
	 * �u�Ώۃ��R�[�h��\���v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void medicalInfoTableSelectionChanged(ListSelectionEvent e)
			throws Exception {

		VRMap map = new VRHashMap();

		if (!getMedicalInfoTable().isSelected()) {
			// ��ʃe�[�u���̍s��I�����Ă��Ȃ��ꍇ

			// Enable������s���B
			// �E���ID�FENABLE_MEDICAL_BUTTON_FALSE
			setState_ENABLE_MEDICAL_BUTTON_FALSE();

			// ��ʂ̃\�[�X�𐶐�����B
			map = (VRMap) getMedicalInfos().createSource();

			//  	    // �ی��Җ��A�s�������R���{�̃N���A�@��bindpath�������Ȃ�����
			//  	    getMedicalInfoInsurerName().setSelectedItem(null);
			//  	    getMedicalInfoCitiesName().setSelectedItem(null);

		} else {
			// ��ʃe�[�u���̍s��I�����Ă���ꍇ

			// Enable������s���B
			// �E���ID�FENABLE_MEDICAL_BUTTON_TRUE
			setState_ENABLE_MEDICAL_BUTTON_TRUE();

			// �I������Ă��郌�R�[�h���擾����B
			map = (VRMap) getMedicalInfoTable().getSelectedModelRowValue();

		}

		// �u��Õی��̈�E���imedicalInfos�j�v�̃\�[�X�Ƃ��Đݒ肷��B
		getMedicalInfos().setSource(map);

		// ��ʂɓW�J����B
		getMedicalInfos().bindSource();

		// �ی��Җ��A�s��������I����Ԃɂ���B
		Object temp;
		// �ی��Җ�
		temp = VRBindPathParser.get("MEDICAL_INSURER_ID", map);
		getMedicalInfoInsurerName().setSelectedItem(
				ACBindUtilities.getMatchRowFromValue(getInsurerList(),
						"INSURER_ID", temp));
		// �s������
		temp = VRBindPathParser.get("CITY_INSURER_ID", map);
		getMedicalInfoCitiesName().setSelectedItem(
				ACBindUtilities.getMatchRowFromValue(getInsurerList(),
						"INSURER_ID", temp));

		// �X�i�b�v�V���b�g
		getSnapShotIryo().snapshot();

	}

	/**
	 * �u�N���A�����v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void medicalInfoButtonClearActionPerformed(ActionEvent e)
			throws Exception {

		if (getMedicalInfoTable().isSelected()) {
			// ��ʃe�[�u�����I������Ă���ꍇ
			// ��ʃe�[�u���̍s�𖢑I���̏�Ԃɐݒ肷��B
			getMedicalInfoTable().clearSelection();
		} else {
			VRMap map = new VRHashMap();
			// ��ʂ̃\�[�X�𐶐�����B
			map = (VRMap) getMedicalInfos().createSource();

			// �u��Õی��̈�E���imedicalInfos�j�v�̃\�[�X�Ƃ��Đݒ肷��B
			getMedicalInfos().setSource(map);

			// ��ʂɓW�J����B
			getMedicalInfos().bindSource();

			// �X�i�b�v�V���b�g
			getSnapShotIryo().snapshot();

		}

	}

	/**
	 * �u�ǉ������v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void medicalInfoButtonInsertActionPerformed(ActionEvent e)
			throws Exception {

		// ���̓`�F�b�N���s���B
		if (!isValidInputMedical(CHECK_MODE_INSERT)) {
			// ���̓G���[���������ꍇ
			// �����𒆒f����B
			return;
		}

		// ���̓G���[���Ȃ������ꍇ
		// �L���ȃf�[�^�̂ݎ擾����B
		VRMap map = getValidMedicalData();

		// �擾������ʏ�̃f�[�^��PATIENT_ID��ݒ肷��B
		VRBindPathParser.set("PATIENT_ID", map, new Integer(getPatientId()));

		// medicalHistoryList�����������[�v���AMEDICAL_HISTORY_ID�̍ő�l+1�̒l���擾����B
		int maxId = 0;

		// �ő�l�̎擾
		if (!(getMedicalHistoryList() == null || getMedicalHistoryList().size() == 0)) {

			// ��ʃe�[�u���Ɋ��Ƀf�[�^�����݂��Ă���ꍇ    	
			for (int i = 0; i < getMedicalHistoryList().size(); i++) {

				int target = ACCastUtilities.toInt(VRBindPathParser.get(
						"MEDICAL_HISTORY_ID", (VRMap) getMedicalHistoryList()
								.get(i)));

				// ��r�Ώۂ���r�����傫���l�̏ꍇ
				if (maxId < target) {
					// ��r�Ώۂ��r���Ƃ���B
					maxId = target;
				}

			}
		}

		// MEDICAL_HISTORY_ID��ǉ�����B
		VRBindPathParser.set("MEDICAL_HISTORY_ID", map, new Integer(maxId + 1));

		//    // ��ʂ̍���9/����8���W�I�imedicalInfoOld9AndOld8Radio�j��������Ԃ̏ꍇ
		//    if(!getMedicalInfoOld9AndOld8Radio().isEnabled()){
		//	    // ��ʂ̍���9/����8���W�I�imedicalInfoOld9AndOld8Radio�j��
		//    	// �I������Ă���ꍇ
		//    	if(getMedicalInfoOld9AndOld8Radio().isSelected()){
		//    		// �擾�����f�[�^��OLD_RATE_FLAG�̒l��0��������B
		//    		VRBindPathParser.set("OLD_RATE_FLAG", map, new Integer(0));
		//    	}
		//    }

		// �擾�����f�[�^���e�[�u���\���p�ɕҏW����B
		map = toMedicalTableList(map);

		// �擾�����f�[�^��medicalHistoryList�ɒǉ�����B
		getMedicalHistoryList().add(map);

		// �ǉ��s�̃C���f�b�N�X��ޔ�(�ŏI�s�̃C���f�b�N�X)
		int selectedRow = getMedicalHistoryList().size() - 1;

		// �ȉ��̏����ň�Õی��e�[�u���̃\�[�g���s���B
		// MEDICAL_VALID_START�i��Õی��L�����ԊJ�n�j�@DESC
		getMedicalInfoTable().sort("MEDICAL_VALID_START DESC");

		// �I������Ă����s��I��
		getMedicalInfoTable().setSelectedModelRow(selectedRow);

		// medicalTableChangeFlg��1�i�ύX����j��������B
		setMedicalTableChangeFlg(1);

	}

	/**
	 * �u�ҏW�����v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void medicalInfoButtonConpileActionPerformed(ActionEvent e)
			throws Exception {

		// ���̓`�F�b�N���s���B
		if (!isValidInputMedical(CHECK_MODE_UPDATE)) {
			// ���̓G���[���������ꍇ
			// �����𒆒f����B
			return;
		}

		// ���̓G���[���Ȃ������ꍇ
		// �I���s�̃C���f�b�N�X��ޔ�
		int selectedRow = getMedicalInfoTable().getSelectedModelRow();

		// �L���ȃf�[�^�̂ݎ擾����B
		VRMap map = getValidMedicalData();

		//    // ��ʂ̍���9/����8���W�I�imedicalInfoOld9AndOld8Radio�j��������Ԃ̏ꍇ
		//    if(!getMedicalInfoOld9AndOld8Radio().isEnabled()){
		//	    // ��ʂ̍���9/����8���W�I�imedicalInfoOld9AndOld8Radio�j��
		//    	// �I������Ă���ꍇ
		//    	if(getMedicalInfoOld9AndOld8Radio().isSelected()){
		//    		// �擾�����f�[�^��OLD_RATE_FLAG�̒l��0��������B
		//    		VRBindPathParser.set("OLD_RATE_FLAG", map, new Integer(0));
		//    	}
		//    }

		// �I���s�̃f�[�^���擾����B
		VRMap temp = (VRMap) getMedicalHistoryList().get(selectedRow);

		// �I���s�̃f�[�^����ʏ�ɂȂ��f�[�^����ʏ�f�[�^�Ɉڂ��B
		VRBindPathParser.set("PATIENT_ID", map, new Integer(getPatientId()));
		VRBindPathParser.set("MEDICAL_HISTORY_ID", map, VRBindPathParser.get(
				"MEDICAL_HISTORY_ID", temp));

		// �擾�����f�[�^���e�[�u���\���p�ɕҏW����B
		map = toMedicalTableList(map);

		// �I���s�ɉ�ʏ�̃f�[�^��ݒ肷��B
		getMedicalHistoryList().setData(selectedRow, map);

		// �ȉ��̏����ň�Õی��e�[�u���̃\�[�g���s���B
		// MEDICAL_VALID_START�i��Õی��L�����ԊJ�n�j�@DESC
		getMedicalInfoTable().sort("MEDICAL_VALID_START DESC");

		// �I������Ă����s��I��
		getMedicalInfoTable().setSelectedModelRow(selectedRow);

		// medicalTableChangeFlg��1�i�ύX����j��������B
		setMedicalTableChangeFlg(1);

	}

	/**
	 * �u�폜�����v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void medicalInfoButtonDeleteActionPerformed(ActionEvent e)
			throws Exception {

		// �m�F���b�Z�[�W��\������B
		// �E���b�Z�[�WID�FWARNING_OF_DELETE_SELECTION
		switch (QkanMessageList.getInstance().WARNING_OF_DELETE_SELECTION()) {

		// �u�͂��v��I�������ꍇ
		case ACMessageBox.RESULT_OK:

			// �I������Ă��郌�R�[�h�̉�ʏ�̃C���f�b�N�X
			int sortedRow = getMedicalInfoTable().getSelectedSortedRow();

			// �I������Ă��郌�R�[�h��idouHistoryList����폜����B
			getMedicalHistoryList().remove(
					getMedicalInfoTable().getSelectedModelRow());

			// �폜���ꂽ�s��1�s��̍s��I������B
			getMedicalInfoTable().setSelectedSortedRowOnAfterDelete(sortedRow);

			// medicalTableChangeFlg��1�i�ύX����j��������B
			setMedicalTableChangeFlg(1);

			break;

		case ACMessageBox.RESULT_CANCEL:
			// �u�L�����Z���v��I�������ꍇ
			// �����𔲂���B�i�������Ȃ��j
			break;

		}
	}

	/**
	 * �u�N���A�����v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void specialInstructButton2ActionPerformed(ActionEvent e)
			throws Exception {

		// ���ʎw�������ԊJ�n�ispecialInstruct1�j�A
		// ���ʎw�������ԏI���ispecialInstruct2�j���N���A����B
		VRMap map = (VRMap) getSpecialInstructPanel1().createSource();
		getSpecialInstructPanel1().setSource(map);
		getSpecialInstructPanel1().bindSource();

	}

	/**
	 * �u��ʏ����v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void medicalInfoInsurerNoFocusLost(FocusEvent e) throws Exception {

		// ���͂��ꂽ�ی��Ҕԍ��ŁA�ی��ҏ��iinsurerList�j����������B
		String medicalInsurerId = getMedicalInfoInsurerNo().getText();
		VRMap map = ACBindUtilities.getMatchRowFromValue(getInsurerList(),
				"INSURER_ID", medicalInsurerId);

		// �Y�����R�[�h�̕ی��Җ����A�ی��Җ��R���{�imedicalInfoInsurerName�j
		// �őI����Ԃɂ���B
		getMedicalInfoInsurerName().setSelectedItem(map);
	}

	/**
	 * �u��ʏ����v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void medicalInfoInsurerNameActionPerformed(ActionEvent e)
			throws Exception {

		// �I�����ꂽ�ی��҂̕ی��Ҕԍ���ی��Ҕԍ��t�B�[���h�imedicalInfoInsurerNo�j
		// �ɕ\������B
		VRMap map = (VRMap) getMedicalInfoInsurerName().getSelectedModelItem();

		if (VRBindPathParser.get("INSURER_ID", map) != null) {
			getMedicalInfoInsurerNo().setText(
					ACCastUtilities.toString(VRBindPathParser.get("INSURER_ID",
							map)));
		}
	}

	/**
	 * �u��ʏ����v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void medicalInfoCitiesNoFocusLost(FocusEvent e) throws Exception {

		// ���͂��ꂽ�ی��Ҕԍ��ŁA�ی��ҏ��iinsurerList�j����������B
		String cityInsurerId = getMedicalInfoCitiesNo().getText();
		VRMap map = ACBindUtilities.getMatchRowFromValue(getInsurerList(),
				"INSURER_ID", cityInsurerId);

		// �Y�����R�[�h�̕ی��Җ����A�ی��Җ��R���{�imedicalInfoCitiesName�j
		// �őI����Ԃɂ���B
		getMedicalInfoCitiesName().setSelectedItem(map);
	}

	/**
	 * �u��ʏ����v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void medicalInfoCitiesNameActionPerformed(ActionEvent e)
			throws Exception {

		// �I�����ꂽ�ی��҂̕ی��Ҕԍ���ی��Ҕԍ��t�B�[���h�imedicalInfoInsurerNo�j
		// �ɕ\������B
		VRMap map = (VRMap) getMedicalInfoCitiesName().getSelectedModelItem();

		if (VRBindPathParser.get("INSURER_ID", map) != null) {
			getMedicalInfoCitiesNo().setText(
					ACCastUtilities.toString(VRBindPathParser.get("INSURER_ID",
							map)));
		}

	}

	/**
	 * �u��ʏ����v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void medicalTreatmentInfoOrganActionPerformed(ActionEvent e)
			throws Exception {

		VRMap map;

		// ��Ë@�֏��\������
		if (getMedicalTreatmentInfoOrgan().isSelected()) {
			// �R���{�őI������Ă����Ë@�ւ̏����擾����B
			if (getMedicalTreatmentInfoOrgan().getSelectedModelItem() == null
					|| "".equals(getMedicalTreatmentInfoOrgan()
							.getSelectedModelItem())) {

				// �V���ȃ\�[�X�𐶐�����B
				map = (VRMap) getMedicalTreatmentInfos().createSource();

				// �厡�㎁����KEY�����
				map.remove("DOCTOR_NAME");

			} else {
				map = (VRMap) getMedicalTreatmentInfoOrgan()
						.getSelectedModelItem();

				// medicalFacilityMap����A�ȉ��̃t�B�[���h���擾���A��������B
				// �EMEDICAL_FACILITY_TEL_FIRST
				// �EMEDICAL_FACILITY_TEL_SECOND
				// �EMEDICAL_FACILITY_TEL_THIRD
				String tel1 = ACCastUtilities.toString(VRBindPathParser.get(
						"MEDICAL_FACILITY_TEL_FIRST", map));
				String tel2 = ACCastUtilities.toString(VRBindPathParser.get(
						"MEDICAL_FACILITY_TEL_SECOND", map));
				String tel3 = ACCastUtilities.toString(VRBindPathParser.get(
						"MEDICAL_FACILITY_TEL_THIRD", map));
				String tel = QkanCommon.toTel(tel1, tel2, tel3);

				// ���������l��medicalFacilityMap��KEY�FMEDICAL_FACILITY_TEL�Őݒ肷��B
				VRBindPathParser.set("MEDICAL_FACILITY_TEL", map, tel);

				// medicalFacilityMap����A�ȉ��̃t�B�[���h���擾���A��������B
				// �EMEDICAL_FACILITY_ZIP_FIRST
				// �EMEDICAL_FACILITY_ZIP_SECOND
				String zip1 = ACCastUtilities.toString(VRBindPathParser.get(
						"MEDICAL_FACILITY_ZIP_FIRST", map));
				String zip2 = ACCastUtilities.toString(VRBindPathParser.get(
						"MEDICAL_FACILITY_ZIP_SECOND", map));
				String zip = QkanCommon.toZip(zip1, zip2);

				// ���������l��medicalFacilityMap��KEY�FMEDICAL_FACILITY_ZIP�Őݒ肷��B
				VRBindPathParser.set("MEDICAL_FACILITY_ZIP", map, zip);

				// medicalFacilityMap����A�ȉ��̃t�B�[���h���擾���A��������B
				// �EMEDICAL_FACILITY_FAX_FIRST
				// �EMEDICAL_FACILITY_FAX_SECOND
				// �EMEDICAL_FACILITY_FAX_THIRD
				String fax1 = ACCastUtilities.toString(VRBindPathParser.get(
						"MEDICAL_FACILITY_FAX_FIRST", map));
				String fax2 = ACCastUtilities.toString(VRBindPathParser.get(
						"MEDICAL_FACILITY_FAX_SECOND", map));
				String fax3 = ACCastUtilities.toString(VRBindPathParser.get(
						"MEDICAL_FACILITY_FAX_THIRD", map));
				String fax = QkanCommon.toTel(fax1, fax2, fax3);

				// ���������l��medicalFacilityMap��KEY�FMEDICAL_FACILITY_FAX�Őݒ肷��B
				VRBindPathParser.set("MEDICAL_FACILITY_FAX", map, fax);

			}

		} else {
			// �V���ȃ\�[�X�𐶐�����B
			map = (VRMap) getMedicalTreatmentInfos().createSource();

			// �厡�㎁����KEY�����
			map.remove("DOCTOR_NAME");

		}

		// �厡�㎁���̃\�[�X��ޔ�����B
		VRMap temp = (VRMap) getMedicalTreatmentInfoMainDoctorName()
				.getSource();

		// ��Ë@�֏��imedicalTreatmentInfos�j�̃\�[�X�Ƃ���medicalFacilityMap��ݒ肷��B
		getMedicalTreatmentInfos().setSource(map);

		// ��ʂɓW�J����B
		getMedicalTreatmentInfos().bindSource();

		// �ޔ����Ă������厡�㎁���̃\�[�X��ݒ肷��B
		getMedicalTreatmentInfoMainDoctorName().setSource(temp);

	}

	/**
	 * �u��ʏ����v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void medicalInfoInsuranceVarietyRadio2SelectionChanged(
			ListSelectionEvent e) throws Exception {

		//  	if(getMedicalInfoInsuranceVarietyRadio2().isSelected()){
		//  	    // �I������Ă���ꍇ
		//  		if(getMedicalInfoInsuranceVarietyRadio2().getSelectedIndex() == 1){
		//	  	    // �u�V�l�v���I������Ă���ꍇ
		//	  	    // Enable������s���B
		//	  	    // �E���ID�FENABLE_OLD_RADIO_TRUE
		//  			setState_ENABLE_OLD_RADIO_TRUE();
		//  		}else{
		//  		    // Enable������s���B
		//  		    // �E���ID�FENABLE_OLD_RADIO_FALSE
		//  		    setState_ENABLE_OLD_RADIO_FALSE();
		//  		}
		//  	}else{
		//	  	// �I������Ă��Ȃ��ꍇ�i�N���A���ꂽ��ԁj
		//	    // Enable������s���B
		//	    // �E���ID�FENABLE_OLD_RADIO_FALSE
		//	    setState_ENABLE_OLD_RADIO_FALSE();
		//  	}

	}

	/**
	 * �u��ʏ����v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void medicalInfoInsuranceVarietyRadio1SelectionChanged(
			ListSelectionEvent e) throws Exception {

		if (getMedicalInfoInsuranceVarietyRadio1().isSelected()) {
			// �I������Ă���ꍇ
			if (getMedicalInfoInsuranceVarietyRadio1().getSelectedIndex() == INSURE_TYPE_KOHI) {
				// ����I������Ă���ꍇ
				setState_ONLY_KOHI();
			} else {
				// ����ȊO���I������Ă���ꍇ
				setState_NOT_ONLY_KOHI();
			}
		} else {
			// �I������Ă��Ȃ��ꍇ
			setState_NOT_ONLY_KOHI();
		}
	}

	public static void main(String[] args) {
		//�f�t�H���g�f�o�b�O�N��
		ACFrame.getInstance().setFrameEventProcesser(
				new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		//param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
		ACFrame.debugStart(new ACAffairInfo(QU003.class.getName(), param));
	}

	// �����֐�

	/**
	 * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @throws Exception ������O
	 */
	public boolean isValidInputStation() throws Exception {

		// �K��Ō�X�e�[�V�������̓��̓`�F�b�N���s���B

		String msgParam1 = null;
		String msgParam2 = null;
		String msgParam3 = null;

		// ���L�̃t�B�[���h�������͂łȂ����`�F�b�N����B
		// �E�w�����L�����ԊJ�n�iinstructInfoValidLimit1�j
		// ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"�w�����L�����ԊJ�n��"��������B
		// �E�w�����L�����ԏI���iinstructInfoValidLimit2�j
		// ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"�w�����L�����ԏI����"��������B
		// �J�n�]���́A�I���]������
		if (ACTextUtilities.isNullText(getInstructInfoValidLimit1().getText())
				&& !(ACTextUtilities.isNullText(getInstructInfoValidLimit2()
						.getText()))) {
			getInstructInfoValidLimit1().requestFocus();
			msgParam1 = "�w�����L�����ԊJ�n��";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
					msgParam1);
			return false;
		}

		// �E�w�����L�����ԊJ�n�iinstructInfoValidLimit1�j
		// ���͂���Ă���ꍇ�A���݂�����t�����͂���Ă��邩�B
		// ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"�w�����L�����ԊJ�n����"��������B
		if (!(ACTextUtilities
				.isNullText(getInstructInfoValidLimit1().getText()))) {
			if (!(getInstructInfoValidLimit1().isValidDate())) {
				getInstructInfoValidLimit1().requestFocus();
				msgParam1 = "�w�����L�����ԊJ�n����";
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE(msgParam1);
				return false;
			}
		}

		// �J�n�]�����́A�I���]����
		if (!(ACTextUtilities
				.isNullText(getInstructInfoValidLimit1().getText()))
				&& ACTextUtilities.isNullText(getInstructInfoValidLimit2()
						.getText())) {
			getInstructInfoValidLimit2().requestFocus();
			msgParam1 = "�w�����L�����ԏI����";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
					msgParam1);
			return false;
		}

		// �E�w�����L�����ԏI���iinstructInfoValidLimit2�j
		// ���͂���Ă���ꍇ�A���݂�����t�����͂���Ă��邩�B
		// ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"�w�����L�����ԏI������"��������B
		if (!(ACTextUtilities
				.isNullText(getInstructInfoValidLimit2().getText()))) {
			if (!(getInstructInfoValidLimit2().isValidDate())) {
				getInstructInfoValidLimit2().requestFocus();
				msgParam1 = "�w�����L�����ԏI������";
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE(msgParam1);
				return false;
			}
		}

		// �E���ʎw�����L�����ԊJ�n�ispecialInstruct1�j
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"���ʎw�����L�����ԊJ�n��"��������B
		// �E���ʎw�����L�����ԏI���ispecialInstruct2�j
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"���ʎw�����L�����ԏI����"��������B
		// �J�n�]���́A�I���]������
		if (ACTextUtilities.isNullText(getSpecialInstruct1().getText())
				&& !(ACTextUtilities
						.isNullText(getSpecialInstruct2().getText()))) {
			getSpecialInstruct1().requestFocus();
			msgParam1 = "���ʎw�����L�����ԊJ�n��";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
					msgParam1);
			return false;
		}

		// �E���ʎw�����L�����ԊJ�n�ispecialInstruct1�j
		// ���͂���Ă���ꍇ�A���݂�����t�����͂���Ă��邩�B
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"���ʎw�����L�����ԊJ�n����"��������B
		if (!(ACTextUtilities.isNullText(getSpecialInstruct1().getText()))) {
			if (!(getSpecialInstruct1().isValidDate())) {
				getSpecialInstruct1().requestFocus();
				msgParam1 = "���ʎw�����L�����ԊJ�n����";
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE(msgParam1);
				return false;
			}
		}

		// �J�n�]�����́A�I���]����
		if (!(ACTextUtilities.isNullText(getSpecialInstruct1().getText()))
				&& ACTextUtilities.isNullText(getSpecialInstruct2().getText())) {
			getSpecialInstruct2().requestFocus();
			msgParam1 = "���ʎw�����L�����ԏI����";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
					msgParam1);
			return false;
		}

		// �E���ʎw�����L�����ԏI���ispecialInstruct2�j
		// ���͂���Ă���ꍇ�A���݂�����t�����͂���Ă��邩�B
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"���ʎw�����L�����ԏI������"��������B
		if (!(ACTextUtilities.isNullText(getSpecialInstruct2().getText()))) {
			if (!(getSpecialInstruct2().isValidDate())) {
				getSpecialInstruct2().requestFocus();
				msgParam1 = "���ʎw�����L�����ԊJ�I������";
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE(msgParam1);
				return false;
			}
		}

		// �E�w�����L�����ԊJ�n�iinstructInfoValidLimit1�j
		// �E�w�����L�����ԏI���iinstructInfoValidLimit2�j
		// �O��֌W���`�F�b�N����B�����͂���Ă���ꍇ
		// �s���Ȓl�̏ꍇ
		// String�FmsgParam1��錾���A"�w�����L�����Ԃ�"��������B
		// String�FmsgParam2��錾���A"�J�n��"��������B
		// String�FmsgParam3��錾���A"�I����"��������B
		if (!(ACTextUtilities
				.isNullText(getInstructInfoValidLimit1().getText()))
				&& !(ACTextUtilities.isNullText(getInstructInfoValidLimit2()
						.getText()))) {
			Date start = getInstructInfoValidLimit1().getDate();
			Date end = getInstructInfoValidLimit2().getDate();
			if (ACDateUtilities.compareOnDay(start, end) > 0) {
				getInstructInfoValidLimit1().requestFocus();
				msgParam1 = "�w�����L�����Ԃ�";
				msgParam2 = "�J�n��";
				msgParam3 = "�I����";
				QkanMessageList.getInstance().ERROR_OF_GREATER_DATE_RELATION(
						msgParam1, msgParam2, msgParam3);
				return false;
			}
		}

		// �E���ʎw�����L�����ԊJ�n�ispecialInstruct1�j
		// �E���ʎw�����L�����ԏI���ispecialInstruct2�j
		// �O��֌W���`�F�b�N����B�����͂���Ă���ꍇ
		// �s���Ȓl�̏ꍇ
		// String�FmsgParam1��錾���A"���ʎw�����L�����Ԃ�"��������B
		// String�FmsgParam2��錾���A"�J�n��"��������B
		// String�FmsgParam3��錾���A"�I����"��������B
		if (!(ACTextUtilities.isNullText(getSpecialInstruct1().getText()))
				&& !(ACTextUtilities
						.isNullText(getSpecialInstruct2().getText()))) {
			Date start = getSpecialInstruct1().getDate();
			Date end = getSpecialInstruct2().getDate();
			if (ACDateUtilities.compareOnDay(start, end) > 0) {
				getSpecialInstruct1().requestFocus();
				msgParam1 = "���ʎw�����L�����Ԃ�";
				msgParam2 = "�J�n��";
				msgParam3 = "�I����";
				QkanMessageList.getInstance().ERROR_OF_GREATER_DATE_RELATION(
						msgParam1, msgParam2, msgParam3);
				return false;
			}
		}

		// ���̓G���[���Ȃ������ꍇ
		return true;

	}

	/**
	 * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @throws Exception ������O
	 */
	public boolean isValidInputMedical(int checkMode) throws Exception {

		// ��Õی����̓��̓`�F�b�N���s���B

		// �t���O
		int doUpdateFlg = 0;

		String msgParam1 = null;
		String msgParam2 = null;
		String msgParam3 = null;

		// �E�u�ی���ށE��imedicalInfoInsuranceVarietyRadio1�j�v
		// �I������Ă��邩�ǂ����B
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�ی����"��������B
		if (!(getMedicalInfoInsuranceVarietyRadio1().isSelected())) {
			getMedicalInfoInsuranceVarietyRadio1().requestFocus();
			msgParam1 = "�ی����";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(
					msgParam1);
			return false;
		}

		// �E�u�{�l/�Ƒ��imedicalInfoPersonAndFamilyRadio�j�v
		// �I������Ă��邩�ǂ����B
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�{�l/�Ƒ�"��������B
//		if (!(getMedicalInfoPersonAndFamilyRadio().isSelected())) {
//			getMedicalInfoPersonAndFamilyRadio().requestFocus();
//			msgParam1 = "�{�l/�Ƒ�";
//			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(
//					msgParam1);
//			return false;
//		}

		// �E�u�ی��Ҕԍ��imedicalInfoInsurerNo�j�v
		// ���͂���Ă��邩�ǂ����B
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�ی��Ҕԍ�"��������B
		if (getMedicalInfoInsurerNo().isEnabled()) {
			if (ACTextUtilities.isNullText(getMedicalInfoInsurerNo().getText())) {
				getMedicalInfoInsurerNo().requestFocus();
				msgParam1 = "�ی��Ҕԍ�";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}
		}

		// �E�u�ی��Җ��imedicalInfoInsurerName�j�v
		// �I������Ă��邩�ǂ����B
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�ی��Җ�"��������B
		//    if(!(getMedicalInfoInsurerName().isSelected())){
		//    	getMedicalInfoInsurerName().requestFocus();
		//    	msgParam1 = "�ی��Җ�";
		//    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(msgParam1);
		//    	return false;
		//    }

		// �E�u�L���E�ԍ��imedicalInfoMark�j�v
		// ���͂���Ă��邩�ǂ����B���ی���ނŌ���(INSURE_TYPE_KOHI)�ȊO��I�����Ă���ꍇ
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�L���E�ԍ�"��������B
		//    if(getMedicalInfoInsuranceVarietyRadio1().getSelectedIndex() != INSURE_TYPE_KOHI){
		//    	if(ACTextUtilities.isNullText(getMedicalInfoMark().getText())){
		//    		getMedicalInfoMark().requestFocus();
		//    		msgParam1 = "�L���E�ԍ�";
		//        	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(msgParam1);
		//        	return false;
		//    	}
		//    }

		// �E�u�L�����ԊJ�n�imedicalInfoValidLimit1�j�v
		// ���͂���Ă��邩�ǂ����B
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�L�����ԊJ�n��"��������B
		if (ACTextUtilities.isNullText(getMedicalInfoValidLimit1().getText())) {
			getMedicalInfoValidLimit1().requestFocus();
			msgParam1 = "�L�����ԊJ�n��";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
					msgParam1);
			return false;
		}

		// �E�u�L�����ԊJ�n�imedicalInfoValidLimit1�j�v
		// ���݂�����t�����͂���Ă��邩�ǂ����B
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�L�����ԊJ�n����"��������B
		if (!(getMedicalInfoValidLimit1().isValidDate())) {
			getMedicalInfoValidLimit1().requestFocus();
			msgParam1 = "�L�����ԊJ�n����";
			QkanMessageList.getInstance().ERROR_OF_WRONG_DATE(msgParam1);
			return false;
		}

		// �E�u�L�����ԏI���imedicalInfoValidLimit2�j�v
		// ���͂���Ă��邩�ǂ����B
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�L�����ԏI����"��������B
		if (ACTextUtilities.isNullText(getMedicalInfoValidLimit2().getText())) {
			getMedicalInfoValidLimit2().requestFocus();
			msgParam1 = "�L�����ԏI����";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
					msgParam1);
			return false;
		}

		// �E�u�L�����ԏI���imedicalInfoValidLimit2�j�v
		// ���݂�����t�����͂���Ă��邩�ǂ����B
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�L�����ԏI������"��������B
		if (!(getMedicalInfoValidLimit2().isValidDate())) {
			getMedicalInfoValidLimit2().requestFocus();
			msgParam1 = "�L�����ԏI������";
			QkanMessageList.getInstance().ERROR_OF_WRONG_DATE(msgParam1);
			return false;
		}

		// �E�u�L�����ԊJ�n�imedicalInfoValidLimit1�j�v
		// �E�u�L�����ԏI���imedicalInfoValidLimit2�j�v
		// �O��֌W���`�F�b�N����B
		// ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"�L�����Ԃ�"��������B
		// ���G���[�̏ꍇ�AString�FmsgParam2��錾���A"�J�n��"��������B
		// ���G���[�̏ꍇ�AString�FmsgParam3��錾���A"�I����"��������B
		Date start = getMedicalInfoValidLimit1().getDate();
		Date end = getMedicalInfoValidLimit2().getDate();

		if (ACDateUtilities.compareOnDay(start, end) > 0) {
			getMedicalInfoValidLimit1().requestFocus();
			msgParam1 = "�L�����Ԃ�";
			msgParam2 = "�J�n��";
			msgParam3 = "�I����";
			QkanMessageList.getInstance().ERROR_OF_GREATER_DATE_RELATION(
					msgParam1, msgParam2, msgParam3);
			return false;
		}

		// �E�u�L�����ԊJ�n�imedicalInfoValidLimit1�j�v
		// �E�u�L�����ԏI���imedicalInfoValidLimit2�j�v
		// ���ɓo�^����Ă��闚���̗L�����ԂƏd�Ȃ��Ă��Ȃ����`�F�b�N����B
		// �E���b�Z�[�WID�FEQU003_ERROR_OF_DUPLICATE_IRYO

		int targetIndex = -1; // ���g�̗����ȊO�ŁA�L�����Ԃ��Ō�̗����̃C���f�b�N�X
		int selectedRow = getMedicalInfoTable().getSelectedModelRow(); // �I������Ă��闚���̃C���f�b�N�X

		if (!(getMedicalHistoryList() == null || getMedicalHistoryList().size() == 0)) {

			Date latestStart = null;
			Date reservedStart = null;
			Date reservedEnd = null;

			// �Ō�̗����̃C���f�b�N�X���擾����B
			for (int i = 0; i < getMedicalHistoryList().size(); i++) { // �F�藚�����������[�v

				// �ҏW���[�h�̏ꍇ
				// ���g�̗����͖�������B
				if (checkMode == CHECK_MODE_UPDATE) {
					if (i == selectedRow) {
						continue;
					}
				}

				VRMap map = (VRMap) getMedicalHistoryList().get(i); // ���𒊏o

				reservedStart = (Date) VRBindPathParser.get(
						"MEDICAL_VALID_START", map); // �����̗L�����ԊJ�n��
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
			for (int i = 0; i < getMedicalHistoryList().size(); i++) { // �F�藚�����������[�v

				// �Ō�̗����͌�Ŕ�r����
				if (i == targetIndex) {
					continue;
				}

				// �ҏW���[�h�̏ꍇ
				// ���g�̗����͖�������B
				if (checkMode == CHECK_MODE_UPDATE) {
					if (i == selectedRow) {
						continue;
					}
				}

				VRMap map = (VRMap) getMedicalHistoryList().get(i); // ���𒊏o

				reservedStart = ACCastUtilities.toDate(VRBindPathParser.get(
						"MEDICAL_VALID_START", map));
				reservedEnd = ACCastUtilities.toDate(VRBindPathParser.get(
						"MEDICAL_VALID_END", map));

				// ���ԏd���`�F�b�N
				// �`�F�b�N�̌��ʂ��擾
				int result = ACDateUtilities.getDuplicateTermCheck(
						reservedStart, reservedEnd, start, end);

				if (result != ACDateUtilities.DUPLICATE_NONE) {
					// �d�����Ă����ꍇ
					getMedicalInfoValidLimit1().requestFocus();
					QkanMessageList.getInstance()
							.QU003_ERROR_OF_DUPLICATE_IRYO();
					return false;
				}
			}

			// �Ō�̗����Əd�����Ă��Ȃ����`�F�b�N����B
			if (targetIndex != -1) {
				VRMap latestMap = (VRMap) getMedicalHistoryList().get(
						targetIndex); // �Ō�̗��𒊏o
				reservedStart = (Date) VRBindPathParser.get(
						"MEDICAL_VALID_START", latestMap); // �Ō�̗����̗L�����ԊJ�n��
				reservedEnd = (Date) VRBindPathParser.get("MEDICAL_VALID_END",
						latestMap); // �Ō�̗����̗L�����ԏI����

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
						msgParam1 = "��Õی�";
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
							getMedicalInfoValidLimit1().requestFocus();
							// �߂�l�Ƃ���false��Ԃ��B
							return false;
						}

					} else {
						// �L�����Ԃ������Œ����ł��Ȃ��ꍇ
						getMedicalInfoValidLimit1().requestFocus();
						QkanMessageList.getInstance()
								.QU003_ERROR_OF_DUPLICATE_IRYO();
						return false;
					}

				}

			}
		}

		// �E�u���t����(medicalInfoProvide)�v
		// �I������Ă��邩�ǂ����B
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"���t����"��������B
		if (getMedicalInfoProvide().isEnabled()) {
			if (!(getMedicalInfoProvide().isSelected())) {
				getMedicalInfoProvide().requestFocus();
				msgParam1 = "���t����";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(
						msgParam1);
				return false;
			}
		}

		// �s�����ԍ�
		// ���͂���Ă���ꍇ�̂݃`�F�b�N
		// �s�����ԍ�-�@�ʔԍ������͂���Ă���ꍇ
		if (getMedicalInfoCitiesLawNo().isEnabled()) {
			if (!ACTextUtilities.isNullText(getMedicalInfoCitiesLawNo()
					.getText())) {
				if (getMedicalInfoCitiesLawNo().getText().length() != 2) {
					getMedicalInfoCitiesLawNo().requestFocus();
					msgParam1 = "�@�ʔԍ�";
					msgParam2 = "2";
					QkanMessageList.getInstance().ERROR_OF_LENGTH(msgParam1,
							msgParam2);
					return false;
				}
				if (ACTextUtilities.isNullText(getMedicalInfoCitiesNo()
						.getText())) {
					getMedicalInfoCitiesNo().requestFocus();
					msgParam1 = "�s�����ԍ�";
					QkanMessageList.getInstance()
							.ERROR_OF_NEED_CHECK_FOR_INPUT(msgParam1);
					return false;
				}
				//    	if(!(getMedicalInfoCitiesName().isSelected())){
				//    		getMedicalInfoCitiesName().requestFocus();
				//    		msgParam1 = "�s������";
				//        	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(msgParam1);
				//        	return false;
				//    	}
			}
		}

		// �s�����ԍ�-�ی��Ҕԍ������͂���Ă���ꍇ
		if (getMedicalInfoCitiesNo().isEnabled()) {
			if (!ACTextUtilities.isNullText(getMedicalInfoCitiesNo().getText())) {
				if (ACTextUtilities.isNullText(getMedicalInfoCitiesLawNo()
						.getText())) {
					getMedicalInfoCitiesLawNo().requestFocus();
					msgParam1 = "�s�����ԍ�";
					QkanMessageList.getInstance()
							.ERROR_OF_NEED_CHECK_FOR_INPUT(msgParam1);
					return false;
				}
				if (getMedicalInfoCitiesLawNo().getText().length() != 2) {
					getMedicalInfoCitiesLawNo().requestFocus();
					msgParam1 = "�@�ʔԍ�";
					msgParam2 = "2";
					QkanMessageList.getInstance().ERROR_OF_LENGTH(msgParam1,
							msgParam2);
					return false;
				}
				//    	if(!(getMedicalInfoCitiesName().isSelected())){
				//    		getMedicalInfoCitiesName().requestFocus();
				//    		msgParam1 = "�s������";
				//        	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(msgParam1);
				//        	return false;
				//    	}
			}
		}

		// �s���������I������Ă���ꍇ
		if (getMedicalInfoCitiesName().isEnabled()) {
			if (getMedicalInfoCitiesName().isSelected()) {
				if (ACTextUtilities.isNullText(getMedicalInfoCitiesLawNo()
						.getText())) {
					getMedicalInfoCitiesLawNo().requestFocus();
					msgParam1 = "�s�����ԍ�";
					QkanMessageList.getInstance()
							.ERROR_OF_NEED_CHECK_FOR_INPUT(msgParam1);
					return false;
				}
				if (getMedicalInfoCitiesLawNo().getText().length() != 2) {
					getMedicalInfoCitiesLawNo().requestFocus();
					msgParam1 = "�@�ʔԍ�";
					msgParam2 = "2";
					QkanMessageList.getInstance().ERROR_OF_LENGTH(msgParam1,
							msgParam2);
					return false;
				}
			}
		}
		// �󋋎Ҕԍ�
		// ���͂���Ă���ꍇ�̂݃`�F�b�N
		if (getMedicalInfoOldPersonReceiptNo().isEnabled()) {
			if (!ACTextUtilities.isNullText(getMedicalInfoOldPersonReceiptNo()
					.getText())) {
				if (getMedicalInfoOldPersonReceiptNo().getText().length() != 7) {
					getMedicalInfoOldPersonReceiptNo().requestFocus();
					msgParam1 = "�󋋎Ҕԍ�";
					msgParam2 = "7";
					QkanMessageList.getInstance().ERROR_OF_LENGTH(msgParam1,
							msgParam2);
					return false;
				}
			}
		}

		// �L�����Ԏ�������
		if (doUpdateFlg == 1) {

			// ���������m�F���b�Z�[�W�ŁuOK�v��I�������ꍇ
			// kaigoInfoValidLimit1�i�L�����ԊJ�n���j�̒l���擾���A�O���̒l�ɕϊ�����B
			Date changedDate = ACDateUtilities.addDay(start, -1);
			// �ϊ������l���A���Ƀe�[�u���ɓo�^����Ă���v���F�藚���̂����A
			// �d�Ȃ��Ă���F��̗L�����ԏI�����ɐݒ肷��B
			VRBindPathParser.set("MEDICAL_VALID_END",
					(VRMap) getMedicalHistoryList().get(targetIndex),
					changedDate);
		}

		// ���̓G���[���Ȃ������ꍇ
		return true;

	}

	/**
	 * �u�L���f�[�^�̎擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @throws Exception ������O
	 */
	public VRMap getValidMedicalData() throws Exception {
		// ��Õی��̃f�[�^�̂����L���ȃf�[�^�̂ݎ擾����B
		VRMap map = new VRHashMap();
		getMedicalInfos().setSource(map);

		// ���͂��ꂽ�f�[�^���\�[�X�ɗ������݁A�f�[�^���擾����B
		getMedicalInfos().applySource();

		if (!getMedicalInfoOld9AndOld8Radio().isEnabled()) {
			map.remove("OLD_RATE_FLAG");
		}

		if (!getMedicalInfoInsurerLawNo().isEnabled()) {
			map.remove("MEDICAL_LAW_NO");
		}

		if (!getMedicalInfoInsurerNo().isEnabled()) {
			map.remove("MEDICAL_INSURER_ID");
		}

		if (!getMedicalInfoMark().isEnabled()) {
			map.remove("MEDICAL_INSURE_ID");
		}

		if (!getMedicalInfoProvide().isEnabled()) {
			map.remove("BENEFIT_RATE");
		}

		if (!getMedicalInfoCitiesLawNo().isEnabled()) {
			map.remove("CITY_LAW_NO");
		}

		if (!getMedicalInfoCitiesNo().isEnabled()) {
			map.remove("CITY_INSURER_ID");
		}

		if (!getMedicalInfoOldPersonReceiptNo().isEnabled()) {
			map.remove("OLD_RECIPIENT_ID");
		}

		return map;
	}

	/**
	 * �u�ۑ������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @throws Exception ������O
	 */
	public boolean doSave() throws Exception {
		// �ۑ��������s���B
		try {

			// �g�����U�N�V�����J�n
			getDBManager().beginTransaction();

			// ��ʏ�̃f�[�^���擾����B
			VRMap map = new VRHashMap();

			getPoint2().setSource(map);
			getPoint2().applySource();

			// ��ʏ�ɂȂ��f�[�^��ǉ�����B
			VRBindPathParser
					.set("PATIENT_ID", map, new Integer(getPatientId()));
			VRBindPathParser.set("STATION_HISTORY_ID", map, new Integer(
					STATION_HISTORY_ID));

			// �p�b�V�u�`�F�b�N�̃^�X�N���N���A����B
			getPassiveChecker().clearPassiveTask();

			// �p�b�V�u�`�F�b�N�̃^�X�N��ǉ�����B	    
			// ��KEY�FPASSIVE_CHECK_KEY
			getPassiveChecker().addPassiveUpdateTask(getPASSIVE_CHECK_KEY(), 0);

			// �p�b�V�u�`�F�b�N���s���B
			if (!getPassiveChecker().passiveCheck(getDBManager())) {
				// �p�b�V�u�G���[�����������ꍇ
				// �G���[���b�Z�[�W��\������B
				// �E���b�Z�[�WID�FERROR_OF_PASSIVE_CHECK_ON_UPDATE
				QkanMessageList.getInstance()
						.ERROR_OF_PASSIVE_CHECK_ON_UPDATE();

				// �g�����U�N�V��������
				getDBManager().rollbackTransaction();

				// �i�����I���j
				return false;
			}

			// SQL���擾�p
			VRMap param = null;
			String strSql = null;

			// ��Õی������̓o�^
			// �S�ٍ폜
			if (getMedicalDataFlg() == 1) {
				// medicalDataFlg��1�̏ꍇ

				// SQL���擾�̂��߂�HashMap�Fparam�𐶐����A���L��KEY��ݒ肷��B
				// �EPATIENT_ID
				param = new VRHashMap();
				VRBindPathParser.set("PATIENT_ID", param, new Integer(
						getPatientId()));

				// ��Õی������iPATIENT_MEDICAL_HISTORY�j�̊Y�����p�҂̃��R�[�h��S���폜����B�@���܂��R�~�b�g���Ȃ����ƁB
				strSql = getSQL_DELETE_MEDICAL_HISTORY(param);
				getDBManager().executeUpdate(strSql);
			}

			// �o�^
			if (!(getMedicalHistoryList() == null || getMedicalHistoryList()
					.size() == 0)) {
				for (int i = 0; i < getMedicalHistoryList().size(); i++) {
					// ��Õی������iPATIENT_MEDICAL_HISTORY�j�ɉ�ʏ�̃f�[�^
					// �imedicalHistoryList�j��o�^����B�@���܂��R�~�b�g���Ȃ����ƁB
					param = new VRHashMap();
					param = (VRMap) getMedicalHistoryList().get(i);

					strSql = getSQL_INSERT_MEDICAL_HISTORY(param);
					getDBManager().executeUpdate(strSql);
				}
			}

			// �K��Ō�X�e�[�V���������̓o�^
			// �S���폜
			if (getStationDataFlg() == 1) {
				// stationDataFlg��1�̏ꍇ
				// SQL���擾�̂��߂�HashMap�Fparam�𐶐����A���L��KEY��ݒ肷��B
				// �EPATIENT_ID
				param = new VRHashMap();
				VRBindPathParser.set("PATIENT_ID", param, new Integer(
						getPatientId()));

				// �K��Ō�X�e�[�V���������iPATIENT_STATION_HISTORY�j
				// �̊Y�����p�҂̃��R�[�h��S���폜����B�@���܂��R�~�b�g���Ȃ����ƁB
				strSql = getSQL_DELETE_STATION_HISTORY(param);
				getDBManager().executeUpdate(strSql);
			}

			// �o�^
			param = new VRHashMap();
			param = map;

			// �K��Ō�X�e�[�V���������iPATIENT_MEDICAL_HISTORY�j��
			// ��ʏ�̃f�[�^��o�^����B
			strSql = getSQL_INSERT_STATION_HISTORY(param);
			getDBManager().executeUpdate(strSql);

			// ���p�Ҋ�{���TBL�̍ŏI�X�V�������X�V����B
			param = new VRHashMap();
			VRBindPathParser.set("PATIENT_ID", param, new Integer(
					getPatientId()));
			strSql = getSQL_UPDATE_PATIENT_LAST_TIME(param);
			getDBManager().executeUpdate(strSql);

			// �R�~�b�g
			// ��L��SQL���s�����ɐ��������ꍇ
			// DB�������R�~�b�g����B
			getDBManager().commitTransaction();

			// ���L�̃t���O������������B
			// �EmedicalTableChangeFlg
			// �EmedicalDataFlg
			// �EstationDataFlg
			setMedicalTableChangeFlg(0);
			setMedicalDataFlg(0);
			setStationDataFlg(0);

			return true;

		} catch (Exception ex) {
			// ��L��SQL���s�����Ɏ��s�����ꍇ
			// ���[���o�b�N����B
			getDBManager().rollbackTransaction();
			// ��O�𓊂���B
			// �i�I���j
			throw ex;
		}

	}

	/**
	 * �u���R�[�h�擾�E��ʐݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @throws Exception ������O
	 */
	public void doFind() throws Exception {
		// ���R�[�h�擾�E��ʐݒ���s���B

		// �n���ꂽ���p��ID��p���āA���p�ҏ����擾����B
		VRList list = QkanCommon.getPatientInfo(getDBManager(), getPatientId());

		if (list == null || list.size() == 0) {
			// ���p�Ҋ�{��񂪎擾�ł��Ȃ������ꍇ		
			// ��O�������s���B���̃��W�b�N��ʂ�͓̂���ʂɑJ�ڂ���Ԃɗ��p��(PATIENT)���폜���ꂽ�ꍇ�ł��邽�߁B	
			// �G���[���b�Z�[�W��\������B	
			// �E���b�Z�[�WID�FERROR_OF_PASSIVE_CHECK_ON_FIND
			QkanMessageList.getInstance().ERROR_OF_PASSIVE_CHECK_ON_FIND();

			// �O��ʂɑJ�ڂ���B
			setCompulsoryBackFlg(1);
			ACFrame.getInstance().back();
			return;

		}

		// �p�b�V�u�L�[�ɓo�^
		getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY(), list);

		// �擾�������p�ҏ����A�ȉ��̃t�B�[���h�̒l���擾����B
		// �EPATIENT_FAMILY_NAME
		// �EPATIENT_FIRST_NAME
		VRMap map = (VRMap) list.get(0);
		String familyName = ACCastUtilities.toString(VRBindPathParser.get(
				"PATIENT_FAMILY_NAME", map));
		String firstName = ACCastUtilities.toString(VRBindPathParser.get(
				"PATIENT_FIRST_NAME", map));

		// ��L�̒l���������āApatientName�ɕ\������B
		getPatientName().setText(QkanCommon.toFullName(familyName, firstName));

		// DB����Õی��������擾����B
		doFindMedical();

		// ��Õی������imedicalHistoryList�j����Õی��e�[�u�����f��
		// �imedicalTableModel�j�ɃZ�b�g����B
		getMedicalTableModel().setAdaptee(getMedicalHistoryList());

		// DB���K��Ō�X�e�[�V���������擾����B
		doFindStation();

		// �K��Ō�X�e�[�V���������istationHistoryList�j�̍ŏ��̃��R�[�h���A
		// �u�K��Ō�×{��׏����o�^�̈�ipoint2�j�v�ɐݒ肷��B
		// ��ʂɓW�J����B
		if (!(getStationHistoryList() == null || getStationHistoryList().size() == 0)) {
			getPoint2().setSource((VRMap) getStationHistoryList().get(0));
			getPoint2().bindSource();
		}

		// �Ɩ��{�^���̐ݒ�
		if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
			// �V�K�̏ꍇ�iprocessMode�����ʒ萔��PROCESS_MODE_INSERT�j
			// �Ɩ��{�^���̏�Ԑݒ���s���B
			// ����ID�FINSERT_MODE
			setState_INSERT_MODE();
		} else {
			// �X�V���[�h�iprocessMode�����ʒ萔��PROCESS_MODE_UPDATE�j�̏ꍇ
			// �Ɩ��{�^���̏�Ԑݒ���s���B
			// ����ID�FUPDATE_MODE
			setState_UPDATE_MODE();
		}

		if (getMedicalHistoryList() == null
				|| getMedicalHistoryList().size() == 0) {
			// ��Õی������e�[�u���imedicalInfoTable�j�̃��R�[�h��0���̏ꍇ

			// ��Õی����̈�̏����l�쐬
			VRMap defaultMap = (VRMap) getPoint1().createSource();
			// �̈�̃N���A
			getPoint1().setSource(defaultMap);
			getPoint1().bindSource();

			// Enable������s���B
			// �E���ID�FsetState_ENABLE_OLD_RADIO_FALSE
			//    	setState_ENABLE_OLD_RADIO_FALSE();

			// �E���ID�FENABLE_MEDICAL_BUTTON_FALSE
			setState_ENABLE_MEDICAL_BUTTON_FALSE();
		} else {
			// ��Õی������e�[�u���imedicalInfoTable�j�̃��R�[�h��1���ȏ�̏ꍇ
			// �e�[�u����1��ڂ�I��������Ԃɂ���B
			getMedicalInfoTable().setSelectedSortedFirstRow();
		}

		// �t�H�[�J�X
		getMedicalInfoInsuranceVarietyRadio1().requestFocus();

		// �X�i�b�v�V���b�g�B�e�B
		getSnapshot().snapshot();
		getSnapShotIryo().snapshot();

	}

	/**
	 * �u��Õی��������擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @throws Exception ������O
	 */
	public void doFindMedical() throws Exception {
		// ��Õی��������擾����B

		// SQL���擾�̂��߂�HashMap�Fparam�𐶐����A���L��KEY/VALUE�Őݒ肷��B
		// �EpatientId/patientId
		VRMap param = new VRHashMap();
		VRBindPathParser.set("PATIENT_ID", param, new Integer(getPatientId()));

		// ��Õی��������擾����B
		// �擾�����f�[�^��medicalHistoryList�Ɋi�[����B
		String strSql = getSQL_GET_MEDICAL_HISTORY(param);
		setMedicalHistoryList(getDBManager().executeQuery(strSql));

		// ���R�[�h��1���ȏ�̏ꍇ
		if (!(getMedicalHistoryList() == null || getMedicalHistoryList().size() == 0)) {

			// ��ʃe�[�u���\���p�ɕҏW����B
			toMedicalTableList(getMedicalHistoryList());

			// �v���Z�X���[�h�iprocessMode�j��
			// ���ʒ萔��PROCESS_MODE_UPDATE��������B
			setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);

			// medicalDataFlg��1��������B
			setMedicalDataFlg(1);

		}

	}

	/**
	 * �u�K��Ō�X�e�[�V�����������擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @throws Exception ������O
	 */
	public void doFindStation() throws Exception {
		// �K��Ō�X�e�[�V�����������擾����B

		// SQL���擾�̂��߂�HashMap�Fparam�𐶐����A���L��KEY/VALUE�Őݒ肷��B
		// �EpatientId/patientId
		VRMap param = new VRHashMap();
		VRBindPathParser.set("PATIENT_ID", param, new Integer(getPatientId()));

		// �K��Ō�X�e�[�V���������擾����B
		// �擾�����f�[�^��stationHistoryList�Ɋi�[����B
		String strSql = getSQL_GET_STATION_HISTORY(param);
		setStationHistoryList(getDBManager().executeQuery(strSql));

		if (!(getStationHistoryList() == null || getStationHistoryList().size() == 0)) {
			// ���R�[�h��1���ȏ�̏ꍇ
			// �v���Z�X���[�h�iprocessMode�j��
			// ���ʒ萔��PROCESS_MODE_UPDATE��������B
			setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);

			// stationDataFlg��1��������B
			setStationDataFlg(1);

		}

		//    // �K��Ō�X�e�[�V���������istationHistoryList�j���p�b�V�u�`�F�b�N�p�ɑޔ�����B
		//    getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY_STATION(), getStationHistoryList());

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
		setPASSIVE_CHECK_KEY(new ACPassiveKey("PATIENT",
				new String[] { "PATIENT_ID" }, new Format[] { null },
				"LAST_TIME", "LAST_TIME"));

		// �e�[�u�����f���̒�`
		// �J�����̐ݒ�
		// "INSURE_TYPE" "SELF_FLAG" "MEDICAL_LAW_NO+MEDICAL_INSURER_ID"
		// "MEDICAL_INSURER_NAME" "MEDICAL_INSURE_ID" "MEDICAL_VALID_START"
		// "MEDICAL_VALID_END" "BENEFIT_RATE" "CITY_LAW_NO+CITY_INSURER_ID" 
		// "CITY_NAME" "OLD_RECIPIENT_ID"
		ACTableModelAdapter model = new ACTableModelAdapter();

		model.setColumns(new String[] { "INSURE_TYPE_NAME",
				"HONNIN_KAZOKU_NAME", "MEDICAL_LAW_NO+''+MEDICAL_INSURER_ID",
				"MEDICAL_INSURER_NAME", "MEDICAL_INSURE_ID",
				"MEDICAL_VALID_START", "MEDICAL_VALID_END", "BENEFIT_RATE",
				"CITY_LAW_NO+''+CITY_INSURER_ID", "CITY_INSURER_NAME",
				"OLD_RECIPIENT_ID" });

		setMedicalTableModel(model);

		// �e�[�u��(medicalInfoTable)��medicalTableModel���Z�b�g����B
		getMedicalInfoTable().setModel(getMedicalTableModel());

		// �e�e�[�u���J�����Ƀt�H�[�}�b�^��ݒ肷��B
		//    // �ی����
		//    getMedicalInfoTableColumn1().setFormat(new ACHashMapFormat(
		//			new String[] { "�Е�", "����", "����" }, 
		//			new Integer[] {new Integer(1), new Integer(2), new Integer(3), }));

		// �{�l/�Ƒ�
		//    getMedicalInfoTableColumn2().setFormat(new ACHashMapFormat(
		//			new String[] { "�{�l", "3��", "�Ƒ�" }, 
		//			new Integer[] {new Integer(1), new Integer(2), new Integer(3), }));

		// ���t����
		getMedicalInfoTableColumn8().setFormat(
				new ACHashMapFormat(new String[] { "10��", "9��", "8��", "7��" },
						new Integer[] { new Integer(1), new Integer(2),
								new Integer(3), new Integer(4), }));

		// �X�i�b�v�V���b�g�̎B�e�Ώۂ��u�K��Ō�×{��׏����o�^�̈�ipoint2�j�v�ݒ肷��B
		getSnapshot().setRootContainer(getPoint2());

		// �X�i�b�v�V���b�g�i��Õی����̈�j
		getSnapShotIryo().setRootContainer(getMedicalInfos());

		// ��ʐݒ���s���B
		casualInitialize();

	}

	/**
	 * �u��ʐݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @throws Exception ������O
	 */
	public void casualInitialize() throws Exception {

		// VRMap map�𐶐�����B
		VRMap map = new VRHashMap();

		// �ی��ҏ����擾���AinsurerList�Ɋi�[����B
		setInsurerList(QkanCommon.getInsurerInfoMedicalOnly(getDBManager()));

		// insurerList�̌��������[�v����B
		if (!(getInsurerList() == null || getInsurerList().size() == 0)) {
			for (int i = 0; i < getInsurerList().size(); i++) {

				// insurerList�Ɋi�[����Ă���VRMap��KEY�FINSURER_ID���擾����B
				Object insurerId = VRBindPathParser.get("INSURER_ID",
						(VRMap) getInsurerList().get(i));

				// �擾�����ی���ID��MEDICAL_INSURER_ID�ɃR�s�[����B
				VRBindPathParser.set("MEDICAL_INSURER_ID",
						(VRMap) getInsurerList().get(i), insurerId);
				// �擾�����ی���ID��CITY_INSURER_ID�ɃR�s�[����B
				VRBindPathParser.set("CITY_INSURER_ID",
						(VRMap) getInsurerList().get(i), insurerId);
			}
		}

		// �ی��ҏ����ȉ���KEY��map�ɐݒ肷��B
		// �EKEY�FMEDICAL_INSURER
		// �EKEY�FCITY_INSURER
		VRBindPathParser.set("MEDICAL_INSURER", map, getInsurerList());
		VRBindPathParser.set("CITY_INSURER", map, getInsurerList());

		// ��Ë@�֏����擾���AmedicalFacilityList�ɑޔ�����B
		setMedicalFacilityList(QkanCommon
				.getMedicalFacilityInfo(getDBManager()));

		// ��Ë@�֏���map�ɉ��L��KEY�Őݒ肷��B
		// �EKEY�FMEDICAL_FACILITY
		VRBindPathParser.set("MEDICAL_FACILITY", map, getMedicalFacilityList());

		// �R�[�h�}�X�^�f�[�^�̑ޔ�
		setMasterCode(QkanSystemInformation.getInstance().getMasterCode());

		// �R�[�h�}�X�^�f�[�^���CODE_ID�FCODE_BENEFIT_RATE���擾����B
		// �J�����FCONTENT_KEY�̃J��������BENEFIT_RATE�ɕϊ�����B
		// �擾���������̑I������map�ɉ��L��KEY�Őݒ肷��B
		// �EKEY�FBENEFIT_RATE    
		VRBindPathParser.set("BENEFIT_RATE", map, QkanCommon
				.getArrayFromMasterCode(CODE_BENEFIT_RATE, "BENEFIT_RATE"));

		// map���u�N���C�A���g�̈�icontents�j�v�ɐݒ肷��B
		getContents().setModelSource(map);

		// ��ʂɓW�J����B
		getContents().bindModelSource();

	}

	/**
	 * �u�f�[�^�ҏW�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * ��Õی������e�[�u���\���p�ɕҏW����֐��ł��B
	 * @return VRList ��Õی����i�ҏW�ρj
	 * @param VRList ��Õی����i1���j
	 * @throws Exception ������O
	 */
	public VRList toMedicalTableList(VRList list) throws Exception {
		// �n���ꂽ��Õی�������ʃe�[�u���\���p�ɕҏW����B		

		if (list == null) {
			// �n���ꂽ�f�[�^��null�̏ꍇ		
			// �߂�l�Ƃ���null��Ԃ��B
			return null;
		} else {
			// �n���ꂽ�f�[�^�̌��������[�v����B
			for (int i = 0; i < list.size(); i++) {
				// ���R�[�h��ҏW����B
				toMedicalTableList((VRMap) list.get(i));
			}
		}

		//�߂�l�Ƃ���list��Ԃ��B
		return list;
	}

	/**
	 * �u�f�[�^�ҏW�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * ��Õی������e�[�u���\���p�ɕҏW����֐��ł��B
	 * @return VRMap ��Õی����i�ҏW�ρj
	 * @param VRMap ��Õی����i1���j
	 * @throws Exception ������O
	 */
	public VRMap toMedicalTableList(VRMap map) throws Exception {
		// �n���ꂽ��Õی�������ʃe�[�u���\���p�ɕҏW����B			

		VRMap temp = null;

		// �n���ꂽ���R�[�h��MEDICAL_INSURER_ID�̒l�ŁAinsurerList��
		// INSURER_ID����������B
		if (VRBindPathParser.has("MEDICAL_INSURER_ID", map)) {
			temp = new VRHashMap();
			temp = ACBindUtilities.getMatchRowFromValue(getInsurerList(),
					"INSURER_ID", VRBindPathParser.get("MEDICAL_INSURER_ID",
							map));
		}

		if (temp != null) {
			// �Y������ی��ҏ�񂪂������ꍇ	
			// �Y������ی��ҏ���INSURER_NAME��n���ꂽ���R�[�h��
			// KEY�FMEDICAL_INSURER_NAME�Œǉ�����B
			VRBindPathParser.set("MEDICAL_INSURER_NAME", map, VRBindPathParser
					.get("INSURER_NAME", temp));
		}

		// �n���ꂽ���R�[�h��CITY_INSURER_ID�̒l�ŁAinsurerList��
		// INSURER_ID����������B
		if (VRBindPathParser.has("CITY_INSURER_ID", map)) {
			temp = new VRHashMap();
			temp = ACBindUtilities.getMatchRowFromValue(getInsurerList(),
					"INSURER_ID", VRBindPathParser.get("CITY_INSURER_ID", map));
		}

		if (temp != null) {
			// �Y������ی��ҏ�񂪂������ꍇ	
			// �Y������ی��ҏ���INSURER_NAME��n���ꂽ���R�[�h��
			// KEY�FCITY_INSURER_NAME�Œǉ�����B
			VRBindPathParser.set("CITY_INSURER_NAME", map, VRBindPathParser
					.get("INSURER_NAME", temp));
		}

		// �R�[�h�}�X�^��薼�̂��擾
		VRList list = null;

		// �ی���ޖ��̂̒ǉ�
		list = new VRArrayList();
		list = (VRList) VRBindPathParser.get(new Integer(CODE_INSURE_TYPE),
				getMasterCode());
		if (VRBindPathParser.has("INSURE_TYPE", map)) {
			temp = new VRHashMap();
			temp = ACBindUtilities.getMatchRowFromValue(list, "CONTENT_KEY",
					VRBindPathParser.get("INSURE_TYPE", map));
			if (temp != null) {
				VRBindPathParser.set("INSURE_TYPE_NAME", map, VRBindPathParser
						.get("CONTENT", temp));
			}
		}

		// �{�l/�Ƒ����̂̒ǉ�
		list = new VRArrayList();
		list = (VRList) VRBindPathParser.get(new Integer(CODE_HONNIN_KAZOKU),
				getMasterCode());
		if (VRBindPathParser.has("SELF_FLAG", map)) {
			temp = new VRHashMap();
			temp = ACBindUtilities.getMatchRowFromValue(list, "CONTENT_KEY",
					VRBindPathParser.get("SELF_FLAG", map));
			if (temp != null) {
				VRBindPathParser.set("HONNIN_KAZOKU_NAME", map,
						VRBindPathParser.get("CONTENT", temp));
			}
		}

		// �߂�l�Ƃ���map��Ԃ��B		
		return map;
	}

	public Component getFirstFocusComponent() {
		return getMedicalInfoInsuranceVarietyRadio1();
	}
}
