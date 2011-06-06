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
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X �ی��ҊǗ� (002)
 * �v���O���� �ی��ғo�^ (QO002)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qo.qo002;

import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Date;
import java.util.Iterator;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.io.ACPropertyXML;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.ACZipRelation;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.bridge.sql.BridgeFirebirdDBManager;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.logging.VRLogger;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �ی��ғo�^(QO002)
 */
public class QO002 extends QO002Event {

	/**
	 * �ҏW�{�^���������ꂽ���ǂ����̔���
	 */
	private boolean insurerLimitRateEditHantei;

	/**
	 * �߂�{�^���������ꂽ���ǂ���
	 */
	private boolean canBackBtnHantei;

	/**
	 * �R���X�g���N�^�ł��B
	 */
	public QO002() {
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
		new ACZipRelation(getInsurerZip1(), getInsurerZip2(),
				getInsurerAddress());
        // [ID:0000520][Masahiko Higuchi] 2009/07 add begin �ی��҃}�X�^���ی��Ҕԍ��̃G���[�`�F�b�N�@�\��ǉ�
        // �f�[�^�x�[�X�ڑ���������A�ی��҃}�X�^�������ł��Ă��Ȃ��ꍇ
        if (QkanSystemInformation.getInstance().isInsurerMasterDatabese()
                && getMasterInsurerDBManager() == null) {

            // �}�X�^�f�[�^�x�[�X�𐶐�����B
            setMasterInsurerDBManager(new QO002_M_InsurerBridgeFirebirdDBManager());

        }
        // [ID:0000520][Masahiko Higuchi] 2009/07 add end
        
		// �ҏW�{�^������̏�����
		insurerLimitRateEditHantei = false;
		
		//�߂�{�^���̔���̏�����
		canBackBtnHantei=false;

		// ��ʓW�J����
		// �O��ʂ���̓n��p�����[�^�[��ޔ�����B
		VRMap parameters = affair.getParameters();
		// 
		// �f�[�^�����݂��Ă��邩���`�F�b�N
		if (VRBindPathParser.has("INSURER_ID", parameters)) {
			// int�^�Ɍ^�ϊ������p��ID��ޔ�
			setInsurereId(String.valueOf(VRBindPathParser.get("INSURER_ID",
					parameters)));
		}
		if (VRBindPathParser.has("PROCESS_MODE", parameters)) {

			// int�^�Ɍ^�ϊ����v���Z�X���[�h��ޔ�
			setPROCESS_MODE(String.valueOf(VRBindPathParser.get("PROCESS_MODE",
					parameters)));
		}
		if (getPROCESS_MODE() == null) {
			setPROCESS_MODE(String.valueOf(QkanConstants.PROCESS_MODE_INSERT));
		}
        
		// this.insurerId = insurerId �i�ی��Ҕԍ��j
		// ��ی��ҏ��TABLE�iINSURER)��̃p�b�V�u�`�F�b�N�L�[���`����B
		// �e�[�u���FINSURER
		// �L�[�FINSURER_ID
		// �t�H�[�}�b�g�F������
		// �N���C�A���g�^�C���t�B�[���h�FLAST_TIME
		// �T�[�o�[�^�C���t�B�[���h�FLAST_TIME
		setINSURER_INFO_PASSIVE_CHECK_KEY(new ACPassiveKey("INSURER",
				new String[] { "INSURER_ID" }, new boolean[] { true },
				"LAST_TIME", "LAST_TIME"));

		// �Ɩ����}�X�^���A�f�[�^���擾����B
		QkanCommon.getAffairInfo(getDBManager(), "QO002");
		// �擾�����f�[�^�̃E�B���h�E�^�C�g���iWINDOW_TITLE�j���E�B���h�E�ɐݒ肷��B
		// �擾�����f�[�^�̋Ɩ��^�C�g���iAFFAIR_TITLE�j���Ɩ��{�^���o�[�ɐݒ肷��B
		setAffairTitle("QO002", "0", getButtons());

		// ��ʂ̏�Ԃ�ύX����B
		setState_INSURER_LIMIT_RATE_ENABLE_FALSE();
		// �Ɩ��{�^���̃L���v�V������ύX����B
		// PROCESS_MODE���A���ʒ萔�́uPROCESS_MODE_INSERT(4)��������ꍇ
		if (getPROCESS_MODE().equals(
				Integer.toString(QkanConstants.PROCESS_MODE_INSERT))) {
			// ��ʏ�Ԃ�ύX����B
			setState_INSERT_STATE();
            // [ID:0000520][Masahiko Higuchi] 2009/07 add begin �ی��҃}�X�^���ی��Ҕԍ��̃G���[�`�F�b�N�@�\��ǉ�
            // �ی��҃}�X�^�����݂���ꍇ�A�ی��Ҕԍ��A���C�x���g��g�ݍ���
            if (getMasterInsurerDBManager() != null
                    && QkanSystemInformation.getInstance()
                            .isInsurerMasterDatabese()) {
                // ��͏���
                setQO002_InsurerRelation(new QO002_InsurerRelation(
                        getMasterInsurerDBManager(), getInsurerId(),
                        getInsurerName(), true, true, true, true));
            }
            // [ID:0000520][Masahiko Higuchi] 2009/07 add end
            
		} else if (getPROCESS_MODE().equals(
				Integer.toString(QkanConstants.PROCESS_MODE_UPDATE))) {
			// PROCESS_MODE���A���ʒ萔�̢PROCESS_MODE_UPDATE(3)��������ꍇ
			// ��ʏ�Ԃ�ύX����B
			setState_UPDATE_STATE();
		}

		// �e�[�u�����f�������L�̉�ʂ̃e�[�u���ɐݒ肷��B
		ACTableModelAdapter model = new ACTableModelAdapter();

		model
				.setColumns(new String[] { "12", "13", "11", "21", "22", "23",
						"24", "25", "LIMIT_RATE_VALID_START",
						"LIMIT_RATE_VALID_END", });

		setInsurerLimitRateTableModel(model);

		// �E�ی��x�����x�z���e�[�u���iinsurerLimitRateTable)
		// �e�[�u�����f���FinsurerLimitRateTableModel
		getInsurerLimitRateTable().setModel(getInsurerLimitRateTableModel());
		// DB��背�R�[�h���擾���A��ʂɓW�J����B
		doFind();

		// �X�i�b�v�V���b�g���B�e����
		snapshotCustom();
	}

	public boolean canBack(VRMap parameters) throws Exception {
		if (!super.canBack(parameters)) {
			return false;
		}
		
		//�߂�{�^���̔���
		canBackBtnHantei=true;
		
		// �O��ʂɑJ�ڂ��鏈���B
		// �ύX���`�F�b�N����B���X�i�b�v�V���b�g
		if (getSnapshot().isModified()) {
			// �ύX����Ă����ꍇ
			// PROCESS_MODE���m�F����B
			// PROCESS_MODE���A���ʒ萔�̢PROCESS_MODE_INSERT(4�)�������ꍇ
			if (getPROCESS_MODE().equals(
					Integer.toString(QkanConstants.PROCESS_MODE_INSERT))) {
				// �o�^�m�F���b�Z�[�W��\������B�����b�Z�[�WID = CAN_BACK_ON_INSERT
				int msgID = QkanMessageList.getInstance()
						.WARNING_OF_UPDATE_ON_MODIFIED();
				switch (msgID) {
				case ACMessageBox.RESULT_OK:
					// ��o�^���Ė߂飉�����
					// �ی��ґS�����̓`�F�b�N���s���B
					if (getInsurerLimitRateTableChangeFlg() == 1) {
						if (!doValidCheck()) {
							canBackBtnHantei=false;
							return false;
						}
					} else {
						if (!doValidInsurerInfoCheck()) {
							canBackBtnHantei=false;
							return false;
						}
					}

					// �o�^�������s���B
					if(!doSave()){
						canBackBtnHantei=false;
						return false;
					}

					// �o�^�������b�Z�[�W��\������B�����b�Z�[�WID = INSERT_SUCCESSED
					// QkanMessageList.getInstance().INSERT_SUCCESSED();
					// �n���p�����[�^�[���쐬����B
					parameters
							.setData("QO001.class", this.getClass().getName());
					parameters.setData("INSURER_ID", getInsurereId());

					// �O��ʂɑJ�ڂ���B
					return true;
				case ACMessageBox.RESULT_NO:
					// ��j�����Ė߂飉�����
					// �n���p�����[�^�[���쐬����B
					parameters
							.setData("QO001.class", this.getClass().getName());
					// �X�V���[�h�̎��A�J�ڐ�փp�����[�^��n���B
					if (getPROCESS_MODE()
							.equals(
									Integer
											.toString(QkanConstants.PROCESS_MODE_UPDATE))) {
						parameters.setData("INSURER_ID", getInsurereId());
					}

					// �O��ʂɑJ�ڂ���B
					return true;
				case ACMessageBox.RESULT_CANCEL:
					canBackBtnHantei=false;
					return false;
					
				}
			} else {
				// PROCESS_MODE���A���ʒ萔�̢PROCESS_MODE_UPDATE(3)��������ꍇ
				// �X�V�m�F���b�Z�[�W��\������B�����b�Z�[�WID = WARNING_OF_UPDATE_ON_MODIFIED
				int msgID = QkanMessageList.getInstance()
						.WARNING_OF_UPDATE_ON_MODIFIED();
				switch (msgID) {
				case ACMessageBox.RESULT_OK:

					// ��X�V���Ė߂飉�����
					// �ی��ґS�����̓`�F�b�N���s���B
					if (doValidInsurerNameCheck()) {
						// �X�V�������s���B
						if(!doSave()){
							canBackBtnHantei=false;
							return false;
						}
					} else {
						canBackBtnHantei=false;
						return false;
					}

					// �X�V�������b�Z�[�W��\������B�����b�Z�[�WID = UPDATE_SUCCESSED
					// QkanMessageList.getInstance().UPDATE_SUCCESSED();
					// �n���p�����[�^�[���쐬����B
					parameters
							.setData("QO001.class", this.getClass().getName());
					parameters.setData("INSURER_ID", getInsurereId());
					// �O��ʂɑJ�ڂ���B
					return true;
					
				case ACMessageBox.RESULT_NO:
					// ��j�����Ė߂飉�����
					// �n���p�����[�^�[���쐬����B
					parameters
							.setData("QO001.class", this.getClass().getName());
					// �X�V���[�h�̎��A�J�ڐ�փp�����[�^��n���B
					if (getPROCESS_MODE()
							.equals(
									Integer
											.toString(QkanConstants.PROCESS_MODE_UPDATE))) {
						parameters.setData("INSURER_ID", getInsurereId());
					}

					// �O��ʂɑJ�ڂ���B
					return true;
				case ACMessageBox.RESULT_CANCEL:
					canBackBtnHantei=false;
					return false;
				}
			}
		} else {
			// �ύX����Ă��Ȃ������ꍇ
			// insurerLimitRateTableChangeFlg�̒l���`�F�b�N����B
			if (getInsurerLimitRateTableChangeFlg() == 1) {
				// �l��1�i�ύX����j�������ꍇ
				// �X�V�m�F���b�Z�[�W��\������B�����b�Z�[�WID = WARNING_OF_UPDATE_ON_MODIFIED
				int msgID = QkanMessageList.getInstance()
						.WARNING_OF_UPDATE_ON_MODIFIED();
				switch (msgID) {
				case ACMessageBox.RESULT_OK:

					// ��X�V���Ė߂飉�����
					// �ی��Ҋ�{���̓��̓`�F�b�N���s���B����{��񂪂Ȃ����ߍX�V�ł��Ȃ�
					if (doValidInsurerInfoCheck()) {
						// �X�V�������s���B
						if(!doSave()){
							canBackBtnHantei=false;
							return false;
						}
					} else {
						canBackBtnHantei=false;
						return false;
					}
				case ACMessageBox.RESULT_NO:
					// ��j�����Ė߂飉�����
					// �n���p�����[�^�[���쐬����B
					parameters
							.setData("QO001.class", this.getClass().getName());
					// �X�V���[�h�̎��A�J�ڐ�փp�����[�^��n���B
					if (getPROCESS_MODE()
							.equals(
									Integer
											.toString(QkanConstants.PROCESS_MODE_UPDATE))) {
						parameters.setData("INSURER_ID", getInsurereId());
					}

					// �O��ʂɑJ�ڂ���B
					return true;
				case ACMessageBox.RESULT_CANCEL:
					canBackBtnHantei=false;
					return false;
				}
			} else {
				// �n���p�����[�^�[���쐬����B
				parameters.setData("QO001.class", this.getClass().getName());
				// �X�V���[�h�̎��A�J�ڐ�փp�����[�^��n���B
				if (getPROCESS_MODE().equals(
						Integer.toString(QkanConstants.PROCESS_MODE_UPDATE))) {
					parameters.setData("INSURER_ID", getInsurereId());
				}

				// �O��ʂɑJ�ڂ���B
				return true;
			}
		}
		// TODO �O��ʂւ̑J�ڂ�������Ȃ��true��Ԃ��B
		return true;
	}

	public boolean canClose() throws Exception {
		if (!super.canClose()) {
			return false;
		}
		// ���X�i�b�v�V���b�g�`�F�b�N
		// �X�i�b�v�V���b�g�̍X�V�`�F�b�N���s���B
		if (!getSnapshot().isModified()) {
			// �X�V����Ă��Ȃ��ꍇ
			// �V�X�e�����I������B
			return true;
		}
		// �X�V����Ă���ꍇ
		// �������p������B
		// ���I���m�F
		// �I���m�F�̃��b�Z�[�W��\������B
		// �����b�Z�[�WID = WARNING_OF_CLOSE_ON_MODIFIED

		int msgID = QkanMessageList.getInstance()
				.WARNING_OF_CLOSE_ON_MODIFIED();
		if (msgID == ACMessageBox.RESULT_OK) {
			// �uOK�v�I����
			// �V�X�e�����I������B
			return true;
		} else {
			// �u�L�����Z���v�I����
			// �����𒆒f����B
			return false;
		}
	}

	// �R���|�[�l���g�C�x���g

	/**
	 * �u�敪�x�����x�z���p�l���𐧌䂷��v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void insurerLimitRateEnableCheckActionPerformed(ActionEvent e)
			throws Exception {
		// �敪�x�����x�z���p�l���𐧌䂷�鏈��
		// insurerLimitRateEnableCheck �̒l���`�F�b�N����B

		// �l��1�i�`�F�b�N����j�������ꍇ
		if (getInsurerLimitRateEnableCheck().isSelected() == true) {
			// ��ʂ̏�Ԃ�ύX����B
			setState_INSURER_LIMIT_RATE_ENABLE_TRUE();
			// �e�[�u���ɏ�񂪋�̎�
			if (getInsurerLimitRateTable().getRowCount() == 0) {
				setState_NOT_POSSIBLE_FIND_AND_DELETE_LIMIT_RATE();
			}

			// �t�H�[�J�X�ݒ�
			getValidPeriodStart().requestFocus();

		} else {
			// �l��0�i�`�F�b�N�Ȃ��j�������ꍇ
			// ��ʂ̏�Ԃ�ύX����B
			setState_INSURER_LIMIT_RATE_ENABLE_FALSE();

			// �t�H�[�J�X�ݒ�
			if (getPROCESS_MODE().equals(
					String.valueOf(QkanConstants.PROCESS_MODE_INSERT))) {
				getInsurerId().requestFocus();
			} else {
				getInsurerName().requestFocus();
			}
		}
	}

	/**
	 * �u�Ώۃ��R�[�h��\���v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void insurerLimitRateTableSelectionChanged(ListSelectionEvent e)
			throws Exception {
		// �e�[�u�������I������Ă��Ȃ��Ƃ�
		if (!getInsurerLimitRateTable().isSelected()) {
			// �ҏW�E�폜�{�^���������t���ɂ���
			setState_NOT_POSSIBLE_FIND_AND_DELETE_LIMIT_RATE();
		}

		// �I�����R�[�h�̎x�����x�z����\������B
		// �I������Ă��郌�R�[�h��x�����x�z���̈捶�validPeriodLeft��̃\�[�X�Ƃ��Đݒ肷��B
		// setSource(insurerLimitRateTable, �I�����R�[�h);
		if (getInsurerLimitRateTable().getSelectedRow() != -1) {
			getValidPeriodPanel().setSource(
					(VRMap) getInsurerLimitRateTable()
							.getSelectedModelRowValue());
			// ��ʂɓW�J����B
			// bindSource(insurerLimitRatePanel);
			getValidPeriodPanel().bindSource();

			// �ҏW�E�폜�{�^���������\�ɂ���
			setState_POSSIBLE_FIND_AND_DELETE_LIMIT_RATE();

			// �X�i�b�v�V���b�g
			getSnapShotPeriod().snapshot();
		}
	}

	/**
	 * �u�ǉ������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void insurerLimitRateInsertButtonActionPerformed(ActionEvent e)
			throws Exception {
		// ���͂��ꂽ�x�����x�z���e�[�u���ɒǉ����鏈��
		// ���̓`�F�b�N���s���B
		if (doValidLimitRateCheck()) {
			setInsurereId(getInsurerId().getText());

			// ���HashMap�𐶐����A��ی��Ҏx�����x�z���̈�( insurerLimitRateInfo)��Ƀ\�[�X�Ƃ��Đݒ肷��B
			// setSource( insurerLimitRateInfo);
			VRMap insurerLimitInfoMap = new VRHashMap();
			// insurerLimitInfoMap = null;
			getValidPeriodPanel().setSource(insurerLimitInfoMap);

			// ���͂��ꂽ�f�[�^���\�[�X�ɗ������݁A�f�[�^���擾����B
			// applySource( insurerLimitRateInfo);
			getValidPeriodPanel().applySource();
			insurerLimitInfoMap.setData("LIMIT_RATE_HISTORY_ID", Integer
					.toString(getInsurerLimitRateTable().getRowCount() + 1));
			insurerLimitInfoMap.setData("INSURER_ID", getInsurereId());

			// �e�[�u���̃\�[�g��L���ɂ��邽�߁A
			// �w��L�[�̃f�[�^�^��String����Integer�ɕϊ�����B
			final String[] Keys = new String[] { "11", "12", "13", "21", "22",
					"23", "24", "25" };
			QkanCommon.convertValueFromStringToInteger(insurerLimitInfoMap,
					Keys);

			getInsurerLimitRateList().add(insurerLimitInfoMap);
			// getInsurerLimitRateTableModel().setAdaptee(
			// getInsurerLimitRateList());

			// insurerLimitRateList���̃��R�[�h�ɉ��L��KEY/VALUE��ݒ肷��B
			// KEY�FLIMIT_RATE_HISTORY_ID VALUE�F���X�g���̃C���f�b�N�X
			// getInsurerLimitRateList().setData("LIMIT_RATE_HISTORY_ID",getInsurerLimitRateList().getData());
			getInsurerLimitRateTable().setSelectedSortedLastRow();
			// insurerLimitRateTableChangeFlg��1�i�ύX����j��������B
			setInsurerLimitRateTableChangeFlg(1);
			// ��ʏ�Ԃ�ύX����B�i�폜�A�ҏW�{�^����Enable���䂵�A�����\�ɂ���j
			setState_POSSIBLE_FIND_AND_DELETE_LIMIT_RATE();
		}
	}

	/**
	 * �u�ҏW�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void insurerLimitRateEditButtonActionPerformed(ActionEvent e)
			throws Exception {
		// �e�[�u�����I������Ă���Ƃ�
		if (getInsurerLimitRateTable().isSelected()) {
			// �I�����R�[�h����͂��ꂽ�x�����x�z�ōX�V���鏈���B
			// ���̓`�F�b�N���s���B
			insurerLimitRateEditHantei = true;
			if (doValidLimitRateCheck()) {

				// ���͂��ꂽ�f�[�^���擾����B
				// applySource( insurerLimitRateInfo);
				VRMap insurerLimitInfoMap = new VRHashMap();
				getValidPeriodPanel().setSource(insurerLimitInfoMap);
				getValidPeriodPanel().applySource();

				// �e�[�u�����ĕ`�ʂ���B
				insurerLimitInfoMap.setData("INSURER_ID", getInsurereId());

				getInsurerLimitRateList().setData(
						getInsurerLimitRateTable().getSelectedModelRow(),
						insurerLimitInfoMap);

				// �e�[�u���̃\�[�g��L���ɂ��邽�߁A
				// �w��L�[�̃f�[�^�^��String����Integer�ɕϊ�����B
				final String[] Keys = new String[] { "11", "12", "13", "21",
						"22", "23", "24", "25" };
				QkanCommon.convertValueFromStringToInteger(insurerLimitInfoMap,
						Keys);

				getInsurerLimitRateTable().revalidate();
				getInsurerLimitRateTable().repaint();

				// insurerLimitRateTableChangeFlg��1�i�ύX����j��������B
				setInsurerLimitRateTableChangeFlg(1);

				// �X�i�b�v�V���b�g�̎B�e
				getSnapShotPeriod().snapshot();

			}
		}
	}

	/**
	 * �u�폜�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void insurerLimitRateDeleteButtonActionPerformed(ActionEvent e)
			throws Exception {

		// �e�[�u�����I������Ă��邩
		if (getInsurerLimitRateTable().isSelected()) {
			// �I�����R�[�h���폜���鏈��
			// �폜�m�F���b�Z�[�W��\������B�����b�Z�[�WID = WARNING_OF_DELETE_SELECTION
			int msgID = QkanMessageList.getInstance()
					.WARNING_OF_DELETE_SELECTION();
			// ��͂���I����
			switch (msgID) {
			case ACMessageBox.RESULT_OK:
				// �I�����ꂽ���R�[�h��insurerLimitRateList����폜����B
				int index = getInsurerLimitRateTable().getSelectedRow();

				getInsurerLimitRateList().remove(
						getInsurerLimitRateTable().getSelectedModelRowValue());
				getInsurerLimitRateTableModel().setAdaptee(
						getInsurerLimitRateList());
				// insurerLimitRateTableChangeFlg��1�i�ύX����j��������B
				setInsurerLimitRateTableChangeFlg(1);
				// ���R�[�h�̌�����0���ɂȂ����ꍇ
				if (getInsurerLimitRateTable().getRowCount() == 0) {
					// ��ʏ�Ԃ�ύX����B�i�폜�A�ҏW�{�^����Enable���䂵�A�����s�ɂ���j
					setState_NOT_POSSIBLE_FIND_AND_DELETE_LIMIT_RATE();
				} else {
					getInsurerLimitRateTable()
							.setSelectedSortedRowOnAfterDelete(index);
				}

			case ACMessageBox.RESULT_CANCEL:
				// ��L�����Z����I����
				// �����𔲂���B�i�������s��Ȃ��j
				return;
			}
		}
	}

	/**
	 * �u��x�����x�z��\�����鏈���v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void insurerLimitRateRegularButtonActionPerformed(ActionEvent e)
			throws Exception {
		// �����ϐ� regularLimitRateList �𐶐�����B
		VRMap regularLimitRateMap = new VRHashMap();

		// ��x�����x�z��\�����鏈��
		//  
		// �l��1�i�ύX����j�������ꍇ
		if (getInsurerLimitRateTableChangeFlg() == 1) {
			// �m�F���b�Z�[�W��\������B �����b�Z�[�WID = QO002_WARNING_OF_LIMIT_RATE_REGULAR
			int msgID = QkanMessageList.getInstance()
					.QO002_WARNING_OF_LIMIT_RATE_REGULAR();
			switch (msgID) {
			case ACMessageBox.RESULT_OK:
				// �uOK�v�������ꍇ
				// �ی��Ҏx�����x�z���p�l��(insurerLimitRateInfo)�̃\�[�X�Ƃ���
				// regularLimitRateMap ��ݒ肷��B
				getValidPeriodPanel().setSource(regularLimitRateMap);
				// �ی��Ҏx�����x�z���p�l����createSource���s���B
				getValidPeriodPanel().createSource();
				// ��ʂ��N���A����B
				getValidPeriodPanel().bindSource();
				// ��x�����x�z�����擾����B
				regularLimitRateMap.putAll(doFindRegularLImitRate());

				// �擾��������regularLimitRateMap�Ɋi�[����B
				// �ی��Ҏx�����x�z���p�l��(insurerLimitRateInfo)�̃\�[�X�Ƃ���
				// regularLimitRateMap ��ݒ肷��B
				getValidPeriodPanel().setSource(regularLimitRateMap);
				// �ی��Ҏx�����x�z���p�l��(insurerLimitRateInfo)�ɏ���W�J����B
				getValidPeriodPanel().bindSource();
			}
		} else {
			// �ی��Ҏx�����x�z���p�l��(insurerLimitRateInfo)�̃\�[�X�Ƃ��� regularLimitRateMap
			// ��ݒ肷��B
			getValidPeriodPanel().setSource(regularLimitRateMap);
			// �ی��Ҏx�����x�z���p�l����createSource���s���B
			getValidPeriodPanel().createSource();
			// ��ʂ��N���A����B
			getValidPeriodPanel().bindSource();
			// ��x�����x�z�����擾����B
			regularLimitRateMap.putAll(doFindRegularLImitRate());

			// �擾��������regularLimitRateMap�Ɋi�[����B
			// �ی��Ҏx�����x�z���p�l��(insurerLimitRateInfo)�̃\�[�X�Ƃ��� regularLimitRateMap
			// ��ݒ肷��B
			getValidPeriodPanel().setSource(regularLimitRateMap);
			// �ی��Ҏx�����x�z���p�l��(insurerLimitRateInfo)�ɏ���W�J����B
			getValidPeriodPanel().bindSource();
		}
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
		// �ی��ҏ���o�^���鏈��
		// �ύX�`�F�b�N���s���B���X�i�b�v�V���b�g
		// �ύX�`�F�b�N(�j������\���̂�����)
		if (getSnapShotPeriod().isModified()) {
			// ���b�Z�[�W�\��
			String msgParam = "�x�����x�z�������";
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

		if (getSnapshot().isModified()) {
			// �ύX���������ꍇ
			// �ی��ҏ��̓��̓`�F�b�N���s���B
			if (doValidInsurerInfoCheck()) {

				// �o�^�������s���B
				if (doSave()) {

					// PROCESS_MODE���A���ʒ萔�PROCESS_MODE_UPDATE(3)��ɕύX����B
					setPROCESS_MODE(Integer
							.toString(QkanConstants.PROCESS_MODE_UPDATE));
					// insurerLimitRateChangeFlg�̒l��0�i�ύX�Ȃ��j��������B
					setInsurerLimitRateTableChangeFlg(0);
					// �o�^�������b�Z�[�W��\������B�����b�Z�[�WID = INSERT_SUCCESSED
					QkanMessageList.getInstance().INSERT_SUCCESSED();
					// ��ʏ�Ԃ�ύX����B
					setState_UPDATE_STATE();
					// DB��背�R�[�h���擾���A��ʂɓW�J����B
					doFind();
					// �X�i�b�v�V���b�g���B�e����B
					snapshotCustom();
				}
			}

		} else {
			// �ύX���Ȃ������ꍇ
			// insurerLimitRateChangeFlg�̒l���`�F�b�N����B
			// �l��1�i�ύX����j�������ꍇ
			if (getInsurerLimitRateTableChangeFlg() == 1) {
				// �ی��ҏ��̓��̓`�F�b�N���s���B
				if (doValidInsurerInfoCheck()) {
					// �o�^�������s���B
					if (doSave()) {

						// PROCESS_MODE��PROCESS_MODE_UPDATE�ɕύX����B
						setPROCESS_MODE(Integer
								.toString(QkanConstants.PROCESS_MODE_UPDATE));
						// insurerLimitRateChangeFlg�̒l��0�i�ύX�Ȃ��j��������B
						setInsurerLimitRateTableChangeFlg(0);
						// �o�^�������b�Z�[�W��\������B�����b�Z�[�WID = INSERT_SUCCESSED
						QkanMessageList.getInstance().INSERT_SUCCESSED();
						// ��ʏ�Ԃ�ύX����B
						setState_UPDATE_STATE();
						// DB��背�R�[�h���擾���A��ʂɓW�J����B
						doFind();
						// �X�i�b�v�V���b�g���B�e����B
						snapshotCustom();
					}
				}
			} else {
				// �ی��ҏ��̓��̓`�F�b�N���s���B
				if (doValidInsurerInfoCheck()) {
					// �o�^�������s���B
					if (doSave()) {

						// PROCESS_MODE��PROCESS_MODE_UPDATE�ɕύX����B
						setPROCESS_MODE(Integer
								.toString(QkanConstants.PROCESS_MODE_UPDATE));
						// insurerLimitRateChangeFlg�̒l��0�i�ύX�Ȃ��j��������B
						setInsurerLimitRateTableChangeFlg(0);
						// �o�^�������b�Z�[�W��\������B�����b�Z�[�WID = INSERT_SUCCESSED
						QkanMessageList.getInstance().INSERT_SUCCESSED();
						// ��ʏ�Ԃ�ύX����B
						setState_UPDATE_STATE();
						// DB��背�R�[�h���擾���A��ʂɓW�J����B
						doFind();
						// �X�i�b�v�V���b�g���B�e����B
						snapshotCustom();
					}
				}
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
		// �ی��ҏ����X�V���鏈��
		// �ύX�`�F�b�N���s���B���X�i�b�v�V���b�g
		if (getSnapShotPeriod().isModified()) {
			// ���b�Z�[�W�\��
			String msgParam = "�x�����x�z�������";
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

		if (getSnapshot().isModified()) {
			// �ύX���������ꍇ
			if (doValidInsurerNameCheck()) {
				// �X�V�������s���B
				if (doSave()) {
					// insurerLimitRateChangeFlg�̒l��0�i�ύX�Ȃ��j��������B
					setInsurerLimitRateTableChangeFlg(0);
					// �X�V�������b�Z�[�W��\������B�����b�Z�[�WID = UPDATE_SUCCESSED
					QkanMessageList.getInstance().UPDATE_SUCCESSED();
					// DB��背�R�[�h���擾���A��ʂɓW�J����B
					doFind();
					// �X�i�b�v�V���b�g���B�e����B
					snapshotCustom();
				}
			}
		} else {
			// �ύX���Ȃ������ꍇ
			// insurerLimitRateChangeFlg�̒l���`�F�b�N����B
			// �l��1�i�ύX����j�������ꍇ
			if (getInsurerLimitRateTableChangeFlg() == 1) {
				// �ی��ҏ��̓��̓`�F�b�N���s���B
				if (doValidInsurerNameCheck()) {
					// �X�V�������s���B
					if (doSave()) {
						// insurerLimitRateChangeFlg�̒l��0�i�ύX�Ȃ��j��������B
						setInsurerLimitRateTableChangeFlg(0);
						// �X�V�������b�Z�[�W��\������B�����b�Z�[�WID = UPDATE_SUCCESSED
						QkanMessageList.getInstance().UPDATE_SUCCESSED();
						// DB��背�R�[�h���擾���A��ʂɓW�J����B
						doFind();
						// �X�i�b�v�V���b�g���B�e����B
						snapshotCustom();
					}
				}
			} else {
				if (doValidInsurerNameCheck()) {
					// �X�V�������s���B
					if (doSave()) {
						// insurerLimitRateChangeFlg�̒l��0�i�ύX�Ȃ��j��������B
						setInsurerLimitRateTableChangeFlg(0);
						// �X�V�������b�Z�[�W��\������B�����b�Z�[�WID = UPDATE_SUCCESSED
						QkanMessageList.getInstance().UPDATE_SUCCESSED();
						// DB��背�R�[�h���擾���A��ʂɓW�J����B
						doFind();
						// �X�i�b�v�V���b�g���B�e����B
						snapshotCustom();
					}
				}
			}
		}
	}

	/**
	 * �u�V�K�o�^���[�h�ύX�v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void newDataActionPerformed(ActionEvent e) throws Exception {
		// �V�K�o�^���[�h�ύX���鏈��
		// �ύX�`�F�b�N���s���B ���X�i�b�v�V���b�g
		if (getSnapshot().isModified()) {
			// �ύX���������ꍇ
			// �V�K�o�^���[�h�J�ڊm�F���b�Z�[�W��\������B �����b�Z�[�WID = WARNING_OF_CLEAR_ON_MODIFIED
			int msgID = QkanMessageList.getInstance()
					.WARNING_OF_CLEAR_ON_MODIFIED();
			// �uOK�v�������ꍇ
			switch (msgID) {
			case ACMessageBox.RESULT_OK:
				// �V�K�o�^���[�h�ɕύX����
				insertModeChange();
				// ��ʂ̏�Ԃ�ύX����B
				setState_INIT_STATE();
				// �ی��Ҕԍ��Ƀt�H�[�J�X
				getInsurerId().requestFocus();
				// �X�i�b�v�V���b�g���B�e����B
				snapshotCustom();
			}
		} else {
			// �ύX���Ȃ������ꍇ
			// insurerLimitRateTableChangeFlg�̒l���`�F�b�N����B
			// �l��1�i�ύX����j�������ꍇ
			if (getInsurerLimitRateTableChangeFlg() == 1) {
				// �V�K�o�^���[�h�J�ڊm�F���b�Z�[�W��\������B
				int msgID = QkanMessageList.getInstance()
						.WARNING_OF_CLEAR_ON_MODIFIED();
				// �uOK�v�������ꍇ
				switch (msgID) {
				case ACMessageBox.RESULT_OK:
					// �V�K�o�^���[�h�ɕύX����
					insertModeChange();
					// ��ʂ̏�Ԃ�ύX����B
					setState_INIT_STATE();
					// �ی��Ҕԍ��Ƀt�H�[�J�X
					getInsurerId().requestFocus();
					// �X�i�b�v�V���b�g���B�e����B
					snapshotCustom();
				}
			} else {
				// �V�K�o�^���[�h�ɕύX����
				insertModeChange();
				// ��ʂ̏�Ԃ�ύX����B
				setState_INIT_STATE();
				// �ی��Ҕԍ��Ƀt�H�[�J�X
				getInsurerId().requestFocus();
				// �X�i�b�v�V���b�g���B�e����B
				snapshotCustom();
			}
		}
        
        // [ID:0000520][Masahiko Higuchi] 2009/07 add begin �ی��҃}�X�^���ی��Ҕԍ��̃G���[�`�F�b�N�@�\��ǉ�
        if (getMasterInsurerDBManager() != null
                && QkanSystemInformation.getInstance()
                        .isInsurerMasterDatabese()) {
            setState_VALID_INSURER_SELECT();
        } else {
            setState_INVALID_INSURER_SELECT();
        }
        // [ID:0000520][Masahiko Higuchi] 2009/07 add end
        
	}

	/**
	 * �u��ʏ��̃N���A�v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void clearActionPerformed(ActionEvent e) throws Exception {
		// ��ʏ����N���A���鏈��
		// �ύX�`�F�b�N���s���B ���X�i�b�v�V���b�g
		if (getSnapshot().isModified()) {
			// �ύX���������ꍇ
			// �m�F���b�Z�[�W��\������ �����b�Z�[�WID = WARNING_OF_CLEAR_ON_MODIFIED
			int msgID = QkanMessageList.getInstance()
					.WARNING_OF_CLEAR_ON_MODIFIED();
			switch (msgID) {
			case ACMessageBox.RESULT_OK:
				// �uOK�v�������ꍇ
				// �N���A�������s��
				allClear();
			}
		} else {
			// �ύX���Ȃ������ꍇ
			// insurerLimitRateTableChangeFlg�̒l���`�F�b�N����B
			// �l��1�i�ύX����j�������ꍇ
			if (getInsurerLimitRateTableChangeFlg() == 1) {
				// �m�F���b�Z�[�W��\������ �����b�Z�[�WID = WARNING_OF_CLEAR_ON_MODIFIED
				int msgID = QkanMessageList.getInstance()
						.WARNING_OF_CLEAR_ON_MODIFIED();
				switch (msgID) {
				case ACMessageBox.RESULT_OK:
					// �uOK�v�������ꍇ
					// �N���A�������s���B
					allClear();
				}
			} else {
				allClear();
			}
		}

	}

	public static void main(String[] args) {
		// �f�t�H���g�f�o�b�O�N��
		ACFrame.getInstance().setFrameEventProcesser(
				new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		param.setData("INSURER_ID", "000001");
		// param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
		ACFrame.debugStart(new ACAffairInfo(QO002.class.getName(), param));
	}

	// �����֐�

	/**
	 * �u���R�[�h���擾����ʂɐݒ肷��B�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doFind() throws Exception {
		// ������ʓW�J���s������
		// �I��ی��҂̏����擾����B
		// �ی��ҏ��TABLE�ɑ��݂���A�ی��ҏ����擾����B
		doFindInsurerInfo();

		// �擾�����ی��ҏ��iinsurerInfoMap�j��ی��ҏ����͗̈�iinsurerInfos)��ɐݒ肷��B
		getInsurerInfos().setSource(getInsurerInfoMap());
		// ��ʂɓW�J����B
		getInsurerInfos().bindSource();
		// �x�����x�z�����擾����B
		doFindInsurerLimitRate();

		// �x�����x�z���e�[�u���Ɏ擾���R�[�h��\������B
		getInsurerLimitRateTableModel().setAdaptee(getInsurerLimitRateList());

		// ���R�[�h��1���ȏ゠�����ꍇ
		if (getInsurerLimitRateList().size() > 0) {
			// ��ʂ̏�Ԃ�ύX����B
			setState_INSURER_LIMIT_RATE_ENABLE_TRUE();
			// ���R�[�h��1���ڂ�I����Ԃɂ���B���Z���I���C�x���g
			getInsurerLimitRateTable().setSelectedSortedFirstRow();
		} else {

		}

		// �t�H�[�J�X����
		if (getPROCESS_MODE().equals(
				String.valueOf(QkanConstants.PROCESS_MODE_INSERT))) {
			getInsurerId().requestFocus();
		} else {
			getInsurerName().requestFocus();
		}
	}

	/**
	 * �u�ی��ҏ��擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doFindInsurerInfo() throws Exception {
		// �ی��ҏ����擾����B
		// �ی��ҏ��擾�pSQL�����擾���邽�߂�VRMap�Fparam���쐬���A�ȉ���KEY/VALUE�Őݒ肷��B
		VRMap param = new VRHashMap();

		// KEY�FINSURER_ID VALUE�FinsurerId

		if (getInsurereId() != null) {
			param.setData("INSURER_ID", getInsurereId());

			// �ی��ҏ����擾���邽�߂�SQL�����擾����B
			// getSQL_GET_INSURER_INFO(param);
			// �擾����SQL�������s����B
			setInsurerInfoList(getDBManager().executeQuery(
					getSQL_GET_INSURER_INFO(param)));
		}

		// ���R�[�h���擾�ł����ꍇ
		if (getInsurerInfoList().size() > 0) {
			setPROCESS_MODE(String.valueOf(QkanConstants.PROCESS_MODE_UPDATE));

			// �擾�������R�[�h��insurerInfoMap�Ɋi�[����B
			setInsurerInfoMap((VRMap) getInsurerInfoList().getData());
			// // insurerInfoList�Ɏ擾����insurerInfoMap���i�[����B
			// setInsurerInfoList((VRList) getInsurerInfoMap().getData());
			// �ی��ҏ��TABLE�p�b�V�u�`�F�b�N�p�Ƀf�[�^��o�^����B
			getPassiveChecker().reservedPassive(
					getINSURER_INFO_PASSIVE_CHECK_KEY(), getInsurerInfoList());
			// ��ʏ�Ԃ�ύX����B
			setState_UPDATE_STATE();
            
            // [ID:0000520][Masahiko Higuchi] 2009/07 add begin �ی��҃}�X�^���ی��Ҕԍ��̃G���[�`�F�b�N�@�\��ǉ�
            if(getQO002_InsurerRelation() != null) {
                getQO002_InsurerRelation().deleteInsurerNameListener();
                getQO002_InsurerRelation().deleteInsurerNoListener();
            }
            // [ID:0000520][Masahiko Higuchi] 2009/07 add end
            
		} else {
			// ���R�[�h���擾�ł��Ȃ������ꍇ
			// PROCESS_MODE�̃`�F�b�N���s���B
			// if (getPROCESS_MODE() == Integer
			// .toString(QkanConstants.PROCESS_MODE_INSERT)) {
			// // PROCESS_MODE���A���ʒ萔�̢PROCESS_MODE_INSERT(4)��������ꍇ
			// // insurerInfoMap�̃\�[�X�𐶐�����B�i�V�K�o�^���N���A�����ɗp����j
			// // createSource();
			// setInsurerInfoMap((VRMap) getContents().createSource());
			// getContents().setSource(getInsurerInfoMap());
			// getContents().bindSource();
			//
			// // ��ʏ�Ԃ�ύX����B
			// setState_INSERT_STATE();
			setPROCESS_MODE(String.valueOf(QkanConstants.PROCESS_MODE_INSERT));

			// if(getPROCESS_MODE() == Integer
			// .toString(QkanConstants.PROCESS_MODE_UPDATE)) {
			// // PROCESS_MODE���A���ʒ萔�̢PROCESS_MODE_UPDATE(3)��������ꍇ
			// // �G���[���b�Z�[�W��\������B �����b�Z�[�WID = ERROR_OF_PASSIVE_CHECK_ON_UPDATE
			// QkanMessageList.getInstance()
			// .ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
			// // �ی��҈ꗗ�QO001���ʂɑJ�ڂ���B
			// ACFrame.getInstance().back();
			// }else{
			// PROCESS_MODE���A���ʒ萔�̢PROCESS_MODE_INSERT(4)��������ꍇ
			// insurerInfoMap�̃\�[�X�𐶐�����B�i�V�K�o�^���N���A�����ɗp����j
			// createSource();
			setInsurerInfoMap((VRMap) getContents().createSource());
			// [ID:0000461][Masahiko Higuchi] 2009/03 add begin �ی��ғo�^���̏����l
            getInsurerInfoMap().setData("INSURER_TYPE",new Integer(1));
            // [ID:0000461][Masahiko Higuchi] 2009/03 add end
			getContents().setSource(getInsurerInfoMap());
			getContents().bindSource();
			// ��ʏ�Ԃ�ύX����B
			setState_INSERT_STATE();
			// }
            // [ID:0000520][Masahiko Higuchi] 2009/07 add begin �ی��҃}�X�^���ی��Ҕԍ��̃G���[�`�F�b�N�@�\��ǉ� 
            // �ی��҃}�X�^�Ƃ̐ڑ����o���Ă���Ȃ��
            if (getMasterInsurerDBManager() != null
                    && QkanSystemInformation.getInstance()
                            .isInsurerMasterDatabese()) {
                setState_VALID_INSURER_SELECT();
            } else {
                setState_INVALID_INSURER_SELECT();
            }
            // [ID:0000520][Masahiko Higuchi] 2009/07 add end
		}
	}

	/**
	 * �u�x�����x�z���擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doFindInsurerLimitRate() throws Exception {
		// �x�����x�z�����擾����B
		// �x�����x�z���擾�̂���HashMap�Fparam���쐬���ȉ���KEY/VALUE��ݒ肷��B
		VRMap param = new VRHashMap();
		// KEY�FINSURER_ID VALUE�FinsurerId
		if (getInsurereId() != null) {
			param.setData("INSURER_ID", getInsurereId());
			// �x�����x�z�����擾���邽�߂�SQL�����擾����B
			// getSQL_GET_INSURER_LIMIT_RATE(param);
			// �擾����SQL�������s����B
			setInsurerLimitRateList(getDBManager().executeQuery(
					getSQL_GET_INSURER_LIMIT_RATE(param)));

		}

		if (getInsurerLimitRateList().size() > 0) {
			// ���R�[�h���擾�ł����ꍇ
			// �擾�������R�[�h��insurerLimitRateListSource�ɐݒ肷��B
			setInsurerLimitRateListSource(getInsurerLimitRateList());
			// ����Ɏ����Ă���x�����x�z����ی���ID�A�x�����x�z������KEY�ɂ���1���R�[�h�i����j�ɂ�insurerLimitRateList�Ɋi�[����B�����ʊ֐��FgetSeriesedKeyList�g�p
			VRMap map = new VRHashMap();

			Iterator it = getInsurerLimitRateList().iterator();

			VRList list = new VRArrayList();
			int limitRateHistoryOldId = 1;

			while (it.hasNext()) {
				VRMap row = (VRMap) it.next();
				// JOTAI_CODE���L�[�ALIMIT_RATE_VALUE��l�Ƃ��Ēǉ�

				if (ACCastUtilities.toInt(VRBindPathParser.get(
						"LIMIT_RATE_HISTORY_ID", row)) == limitRateHistoryOldId) {
					map.put("LIMIT_RATE_HISTORY_ID", VRBindPathParser.get(
							"LIMIT_RATE_HISTORY_ID", row));
					map.put("INSURER_ID", getInsurereId());
					map.put(String.valueOf(VRBindPathParser.get("JOTAI_CODE",
							row)), VRBindPathParser
							.get("LIMIT_RATE_VALUE", row));
					map.put("LIMIT_RATE_VALID_START", VRBindPathParser.get(
							"LIMIT_RATE_VALID_START", row));
					map.put("LIMIT_RATE_VALID_END", VRBindPathParser.get(
							"LIMIT_RATE_VALID_END", row));
				} else {

					list.add(map);
					map = new VRHashMap();
					map.put(String.valueOf(VRBindPathParser.get("JOTAI_CODE",
							row)), VRBindPathParser
							.get("LIMIT_RATE_VALUE", row));
				}

				limitRateHistoryOldId = ACCastUtilities.toInt(VRBindPathParser
						.get("LIMIT_RATE_HISTORY_ID", row));
			}

			list.add(map);
			setInsurerLimitRateList(list);

			// setInsurerLimitRateList(ACBindUtilities.getSeriesedKeyListWithoutGroupField(getInsurerLimitRateListSource(),str1,str2,str3,str4,ob));
			// ��ʏ�Ԃ�ύX����B
			setState_INSURER_LIMIT_RATE_ENABLE_TRUE();
			// �x�����x�z�ύX�`�F�b�N�iinsurerLimitRateEnableCheck�j���`�F�b�N��Ԃɂ���B
			getInsurerLimitRateEnableCheck().setSelected(true);
		} else {
			// ���R�[�h���擾�ł��Ȃ������ꍇ
			// �����J���ȋK��̎x�����x�z���擾��insurerLimitRateListSource�Ɋi�[����B
			VRMap regularLimitRateMap = new VRHashMap();
			regularLimitRateMap = (VRMap) doFindRegularLImitRate();
			getValidPeriodPanel().createSource();
			getValidPeriodPanel().setSource(regularLimitRateMap);
			getValidPeriodPanel().bindSource();

			// ��ʏ�Ԃ�ύX����B
			setState_INSURER_LIMIT_RATE_ENABLE_FALSE();
		}

	}

	/**
	 * �u�ۑ������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean doSave() throws Exception {
		setInsurereId(getInsurerId().getText());
        
		// ���̓��[�h��INSERT�̎�
		if (getPROCESS_MODE().equals(
				Integer.toString(QkanConstants.PROCESS_MODE_INSERT))) {

			// �ꎞ�ޔ�map
			VRMap map = new VRHashMap();
			map.setData("INSURER_ID", getInsurerId().getText());

			// �ꎞ�ޔ�list
			VRList list = null;

			list = getDBManager().executeQuery(
					getSQL_GET_INSURER_INFO_DELETE_FLAG(map));
			// �폜�ς݂Ƀf�[�^�����邩�ǂ����̃`�F�b�N������
			if (list.size() > 0) {
				int msgID = QkanMessageList.getInstance()
						.WARNING_OF_RESTORATION_OF_DELETE_DATA("�ی��Ҕԍ�", "�ی���");

				switch (msgID) {
				case ACMessageBox.RESULT_OK:

//					setInsurereId(getInsurerId().getText());
					doFind();
					return false;

				case ACMessageBox.RESULT_CANCEL:
					// VRMap param = new VRHashMap();
					// param.setData(getInsurereId());

					// ���J�ڏ���
					// ACAffairInfo affair = null;
					// affair = new ACAffairInfo(QO001.class.getName(), param);
					// ����ʂɑJ�ڂ���B
					// ACFrame.getInstance().next(affair);
					return false;
				}
			}

			list = getDBManager().executeQuery(getSQL_GET_INSURER_INFO(map));
			// ���ɓo�^�ς݂��`�F�b�N����B
			if (list.size() > 0) {
				// �o�^�ς݂̎��A���b�Z�[�W��\������B
				QkanMessageList.getInstance().QO002_ERROR_OF_OVERLAP("�ی��ԍ�");

				// �t�H�[�J�X��ی��Ҕԍ��e�L�X�g�ɂ��킹��B
				getInsurerId().requestFocus();

				// false��Ԃ��B
				return false;
			}
			// �o�^�ς݂łȂ��Ƃ������𔲂���B
            // [ID:0000520][Masahiko Higuchi] 2009/07 add begin �ی��҃}�X�^���ی��Ҕԍ��̃G���[�`�F�b�N�@�\��ǉ�
            // �ی��҃}�X�^���擾�ł����ꍇ
            if ((getMasterInsurerDBManager() != null && QkanSystemInformation
                    .getInstance().isInsurerMasterDatabese())
                    && !getQO002_InsurerRelation().isValidInsurer()) {
                int msgID = QkanMessageList.getInstance().QO002_WARNING_OF_INSURER();
                // ���b�Z�[�WID
                switch(msgID) {
                case ACMessageBox.RESULT_OK:
                    // �������s
                    break;
                case ACMessageBox.RESULT_CANCEL:
                    return false;
                }
            }
            // [ID:0000520][Masahiko Higuchi] 2009/07 add end
            
		}

		// �ی��҂̏���DB�ɓo�^����B
		try {
			// �g�����U�N�V�������J�n����B
			getDBManager().beginTransaction();

			// �p�b�V�u�^�X�N���N���A����B
			getPassiveChecker().clearPassiveTask();

			// ��ʏ�̏����擾��insurerInfoMap�Ɋi�[����
			getInsurerInfos().setSource(getInsurerInfoMap());
			getInsurerInfos().applySource();

			getInsurerInfoList().clearData();
			getInsurerInfoList().addData(getInsurerInfoMap());

			// PROCESS_MODE�̒l���`�F�b�N����B
			// PROCESS_MODE���A���ʒ萔�̢PROCESS_MODE_INSERT(4)��������ꍇ
			if (getPROCESS_MODE().equals(
					String.valueOf(QkanConstants.PROCESS_MODE_INSERT))) {

				setInsurereId(getInsurerId().getText());

				// �p�b�V�u�^�X�N��o�^����B�iINSERT�j ���ی��ҏ��o�^�p
				getPassiveChecker().addPassiveInsertTask(
						getINSURER_INFO_PASSIVE_CHECK_KEY(),
						getInsurerInfoList());

			} else if (getPROCESS_MODE().equals(
					Integer.toString(QkanConstants.PROCESS_MODE_UPDATE))) {
				// PROCESS_MODE���A���ʒ萔�̢PROCESS_MODE_UPDATE(3)��������ꍇ
				// �p�b�V�u�^�X�N��o�^����B�iUPDATE�j ���ی��ҏ��X�V�p
				getPassiveChecker().addPassiveUpdateTask(
						getINSURER_INFO_PASSIVE_CHECK_KEY());
			}
			// �p�b�V�u�`�F�b�N���s��
			// �p�b�V�u�G���[�����������ꍇ
			if (!getPassiveChecker().passiveCheck(getDBManager())) {
				// �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_PASSIVE_CHECK_ON_UPDATE
				QkanMessageList.getInstance()
						.ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
				// �����𔲂���B�i�����𒆒f����j
				getDBManager().rollbackTransaction();
				return false;
			} else {
				// �p�b�V�u�G���[���������Ȃ������ꍇ
				// PROCESS_MODE�̃`�F�b�N������B
				// PROCESS_MODE���A���ʒ萔�̢PROCESS_MODE_INSERT(4)��������ꍇ
				if (getPROCESS_MODE().equals(
						Integer.toString(QkanConstants.PROCESS_MODE_INSERT))) {
					// ��ʏ�̏����擾��insurerInfoMap�Ɋi�[����B
					// getInsurerInfos().setSource(getInsurerInfoMap());
					// getInsurerInfos().applySource();

					// �ی��ҏ��o�^�̂��߂�SQL�����擾����B
					// �ی��ҏ��o�^�p��SQL�����擾����B
					// getSQL_INSERT_INSURER_INFO(getInsurerInfoMap());
					// �擾����SQL�������s����B
					getDBManager().executeUpdate(
							getSQL_INSERT_INSURER_INFO(getInsurerInfoMap()));

					// SQL���s���ɃG���[���������Ȃ������ꍇ
					// insurerLimitRateEnableCheck �̒l���`�F�b�N����B
					// �l��1�i�`�F�b�N����j�������ꍇ
					// if (getInsurerLimitRateEnableCheck().getValue() == 1) {
					// ���̓`�F�b�N���s��
					// if(doValidLimitRateCheck()){
					// ���̓G���[���Ȃ������ꍇ
					// �x�����x�z����o�^����
					doSaveLimitRate();

					// ���̓G���[���������ꍇ
					// }else{
					// �����𒆒f����B
					// return false;
					// }
					// PROCESS_MODE���A���ʒ萔�̢PROCESS_MODE_UPDATE(3)��������ꍇ
					// }
				} else {
					// ��ʏ�̏����擾��insurerInfoMao�Ɋi�[����B
					// getInsurerInfos().setSource(getInsurerInfoMap());
					// getInsurerInfos().applySource();
					// �ی��ҏ��X�V�̂��߂�SQL�����擾����B
					// �ی��ҏ��X�V�p��SQL�����擾����B
					// getSQL_UPDATE_INSURER_INFO(getInsurerInfoMap());
					// �擾����SQL�������s����B
					getDBManager().executeUpdate(
							getSQL_UPDATE_INSURER_INFO(getInsurerInfoMap()));

					// SQL���s���ɃG���[���������Ȃ������ꍇ
					// insurerLimitRateEnableCheck �̒l���`�F�b�N����B
					// �l��1�i�`�F�b�N����j�������ꍇ
					// ���̓`�F�b�N���s��
					// if (getInsurerLimitRateEnableCheck().getValue() == 1) {
					// if(doValidLimitRateCheck()){

					// ���̓G���[���Ȃ������ꍇ
					// �x�����x�z����o�^����
					doSaveLimitRate();

					// ���̓G���[���������ꍇ
					// }else{
					// �����𒆒f����B
					// return false;
					// }

					// }
				}
			}
		} catch (Exception sqlEx) {
			// SQL���s���ɃG���[�����������ꍇ
			sqlEx.printStackTrace();

			getDBManager().rollbackTransaction();
			// �����𔲂���B�i�����𒆒f����j
			throw sqlEx;
		}
		// 1���G���[���������Ȃ������ꍇ
		// �������R�~�b�g����B
		getDBManager().commitTransaction();
		// �i����I���j
		// �X�i�b�v�V���b�g���B�e����B
		snapshotCustom();

		return true;
	}

	/**
	 * �u�x�����x�z���o�^�����v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doSaveLimitRate() throws Exception {
		// �x�����x�z�����X�V����i�X�V���[�h�j
		// �x�����x�z���폜�p��SQL�����擾���邽��VRMap�Fparam���쐬���A���L��KEY/VALUE��ݒ肷��B
		VRMap param = new VRHashMap();
		// KEY�FINSURER_ID VALUE�FinsurerId
		param.setData("INSURER_ID", getInsurereId());
		// �x�����x�z���폜�p��SQL�����擾����B
		// getSQL_DELETE_INSURER_LIMIT_RATE(param);
		// �擾����SQL�������s����B

		getDBManager().executeUpdate(getSQL_DELETE_INSURER_LIMIT_RATE(param));
		// SQL�����s���ɃG���[�����������ꍇ
		// �����𔲂���B�i�����𒆒f����j
		// SQL�����s���ɃG���[���������Ȃ������ꍇ
		// �x�����x�z�����폜����B���܂��R�~�b�g�͍s��Ȃ��B
		// �x�����x�z�ڍ׏��폜�p��SQL�����擾����B
		// getSQL_DELETE_INSURER_LIMIT_RATE_DETAIL(param);
		// �擾����SQL�������s����B
		getDBManager().executeUpdate(
				getSQL_DELETE_INSURER_LIMIT_RATE_DETAIL(param));
		// SQL�����s���ɃG���[�����������ꍇ
		// �����𔲂���B�i�����𒆒f����j
		// SQL�����s���ɃG���[���������Ȃ������ꍇ
		// �x�����x�z�ڍ׏����폜����B���܂��R�~�b�g�͍s��Ȃ��B
		// insurerLimitRateList�̃��R�[�h���x�����x�z���TABLE�ɓo�^����B
		// insurerLimitRateList���̃��R�[�h�������ȉ��̏������s���B
		// insurerLimitRateList�����烌�R�[�h���擾��insurerLimitRateMap�Ɋi�[����B
		// �x�����x�z���o�^�p��SQL�����擾����B
		// getSQL_INSURT_INSURER_LIMIT_RATE(getInsurerLimitRateMap());
		// �擾����SQL�������s����B
		// SQL�����s���ɃG���[�����������ꍇ
		// �����𔲂���B�i�����𒆒f����j
		// SQL�����s���ɃG���[���������Ȃ������ꍇ
		// �x�����x�z����o�^����B���܂��R�~�b�g�͍s��Ȃ��B
		// ���[�v�̃J�E���g��+1����B
		// ���R�[�h�������[�v�����ꍇ�������ցB

		// getValidPeriodPanel().setSource(getInsurerLimitRateMap());
		// getValidPeriodPanel().applySource();
		//		
		// getInsurerLimitRateList().clearData();
		// getInsurerLimitRateList().addData(getInsurerLimitRateMap());

		for (int i = 0; i < getInsurerLimitRateList().size(); i++) {
			VRMap insurerLimitRateMap = new VRHashMap();
			insurerLimitRateMap = (VRMap) getInsurerLimitRateList().getData(i);
			insurerLimitRateMap.setData("LIMIT_RATE_HISTORY_ID", Integer
					.toString(i + 1));

			getDBManager()
					.executeUpdate(
							getSQL_INSURT_INSURER_LIMIT_RATE((VRMap) getInsurerLimitRateList()
									.getData(i)));
		}
		// �x�����x�z�ڍ׏��o�^�pSQL���Ŏg�p���邽�߂̃f�[�^�[���擾��insurerLimitRateListSource�Ɋi�[����B
		String[] str1 = { "INSURER_ID", "LIMIT_RATE_HISTORY_ID",
				"LIMIT_RATE_VALID_START", "LIMIT_RATE_VALID_END" };
		String[] str2 = { "12", "13", "11", "21", "22", "23", "24", "25" };
		Object obj = null;

		setInsurerLimitRateListSource(ACBindUtilities.getParalleledKeyList(
				getInsurerLimitRateList(), str1, "JOTAI_CODE",
				"LIMIT_RATE_VALUE", str2, obj));

		// insurerLimitRateSource���̃��R�[�h���x�����x�z�ڍ׏��TABLE�ɓo�^����B
		// insurerLimtRateSource���̃��R�[�h�̐������ȉ��̏������s���B
		// insurerLimitRateSource���烌�R�[�h���擾��insurerLimitRateSourceMap�Ɋi�[����B
		VRMap insurerLimitRateListSourceMap = new VRHashMap();
		for (int i = 0; i < getInsurerLimitRateListSource().size(); i++) {
			insurerLimitRateListSourceMap
					.putAll((VRMap) getInsurerLimitRateListSource().getData(i));
			getDBManager()
					.executeUpdate(
							getSQL_INSURT_INSURER_LIMIT_RATE_DETAIL(insurerLimitRateListSourceMap));
		}
		// �x�����x�z�ڍ׏��o�^�p��SQL�����擾����
		// getSQL_INSURT_INSURER_LIMIT_RATE_DETAIL(insurerLimitRateListSourceMap);
		// �擾����SQL�������s����B
		// getDBManager().executeUpdate(getSQL_INSURT_INSURER_LIMIT_RATE_DETAIL(insurerLimitRateListSourceMap));
		// SQL�����s���ɃG���[�����������ꍇ
		// �����𔲂���B�i�����𒆒f����j
		// SQL�����s���ɃG���[���������Ȃ������ꍇ
		// ���[�v�̃J�E���g��+1����B
		// ���R�[�h�������[�v�����ꍇ�������ցB

	}

	/**
	 * �u�n���p�����[�^�[��ݒ肷��B�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void setParameter() throws Exception {
		// �O��ʂ�ID��ݒ肷�鏈��
		// �ی��Ҕԍ��e�L�X�g(insurerId)����l���擾���A�n���p�����[�^�[�Ƃ��ĉ��L��KEY/VALUE�Ŋi�[����B
		// KEY�FINSURER_ID VALUE�F�ی��Ҕԍ��e�L�X�g����擾�����l
		// setParameter("INSURER_ID",getInsurerId().getText());

	}

	/**
	 * �u�ی��ґS�����̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean doValidCheck() throws Exception {
		// �ی��ғo�^�ɓ��͕K�{�ȍ��ڂ̃`�F�b�N���s�������B
		// �ی��Ҋ�{�����̓`�F�b�N������B
		if (doValidInsurerInfoCheck() && doValidLimitRateCheck()) {
			return true;
		}
		// �L�����ԓ��̓`�F�b�N���s���B
		// doValidLimitRateCheck();

		// ��L�Q�̃`�F�b�N�ŃG���[���������Ȃ������ꍇ true ��Ԃ�
		return false;
	}

	/**
	 * �u�ی��Ҋ�{�����̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean doValidInsurerInfoCheck() throws Exception {
		// ��ی��Ҕԍ��iinsurerId�j������͂���Ă��邩�`�F�b�N���鏈��
		// ���͂���Ă��Ȃ������ꍇ
		if (ACTextUtilities.isNullText(getInsurerId().getText())) {
			// �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_NEED_CHECK_FOR_INPUT ��1���� =
			// "�ی��Ҕԍ�"
			QkanMessageList.getInstance()
					.ERROR_OF_NEED_CHECK_FOR_INPUT("�ی��Ҕԍ�");
			// ��ی��Ҕԍ��iinsurerId�j��Ƀt�H�[�J�X�𓖂Ă�B
			getInsurerId().requestFocus();
			// �����𔲂���B�i�����𒆒f����j
			return false;

			// ���͂���Ă����ꍇ
		} else {
//			if (getInsurerId().getText().length() != 6) {
//				QkanMessageList.getInstance().ERROR_OF_LENGTH("�ی��Ҕԍ�", "6");
//				// ��ی��Ҕԍ��iinsurerId�j��Ƀt�H�[�J�X�𓖂Ă�B
//				getInsurerId().requestFocus();
//				// �����𔲂���B�i�����𒆒f����j
//				return false;
//			}

			// ��ی��Җ��́iinsurerName�j������͂���Ă��邩�`�F�b�N����B
			// ���͂���Ă��Ȃ������ꍇ
			if (ACTextUtilities.isNullText(getInsurerName().getText())) {
				// �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_NEED_CHECK_FOR_INPUT ��1���� =
				// "�ی��Җ���"
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						"�ی��Җ���");
				// ��ی��Җ��́iinsurerName�j��Ƀt�H�[�J�X�𓖂Ă�B
				getInsurerName().requestFocus();
				// �����𔲂���B�i�����𒆒f����j
				return false;
			}
		}

		// ��ی��Ҕԍ��e�L�X�g�iinsurerId�j��ɓ��͂���Ă���ی��Ҕԍ��ƁA�o�^�ς݃f�[�^�̕ی��Ҕԍ����d�����Ă��Ȃ����`�F�b�N����B
		// insurerLimitRateList���ɢ�ی��Ҕԍ��e�L�X�g�iinsurerId�j��ɓ��͂���Ă���ی��Ҕԍ��ƁA����̕ی��Ҕԍ������݂��邩�`�F�b�N����B
		// if(VRBindPathParser.get("INSURER_ID",getInsurerLimitRateList()) !=
		// null){
		// for (int i = 0; i < getInsurerLimitRateList().size(); i++) {
		// if (VRBindPathParser.get("INSURER_ID",
		// (VRMap) getInsurerLimitRateList().getData(i)).equals(
		// getInsurerId().getText())) {
		// // ���݂����ꍇ
		// // �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_SAME_DATA_FOUND
		// QkanMessageList.getInstance().ERROR_OF_SAME_DATA_FOUND("�ی���");
		// // ��ی��Ҕԍ��e�L�X�g�iinsurerId�j��Ƀt�H�[�J�X�𓖂Ă�B
		// getInsurerId().requestFocus();
		// // �����𔲂���B�i�����𒆒f����j
		// return false;
		// }
		// }
		// }
		return true;
	}

	/**
	 * �u�ی��Җ��̓��̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean doValidInsurerNameCheck() throws Exception {
		// ��ی��Җ��́iinsurerName�j������͂���Ă��邩�`�F�b�N����B
		// ���͂���Ă��Ȃ������ꍇ
		if (ACTextUtilities.isNullText(getInsurerName().getText())) {
			// �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_NEED_CHECK_FOR_INPUT ��1���� =
			// "�ی��Җ���"
			QkanMessageList.getInstance()
					.ERROR_OF_NEED_CHECK_FOR_INPUT("�ی��Җ���");
			// ��ی��Җ��́iinsurerName�j��Ƀt�H�[�J�X�𓖂Ă�B
			getInsurerName().requestFocus();
			// �����𔲂���B�i�����𒆒f����j
			return false;
		}
		return true;
	}

	/**
	 * �u�x�����x�z���`�F�b�N�����v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean doValidLimitRateCheck() throws Exception {
		// �x�����x�z��񐳂������͂���Ă��邩�`�F�b�N���鏈��
		// ��L�����ԃe�L�X�g�i�J�n�j�ivalidPeriodStart�j������͂���Ă��邩�`�F�b�N����B
		// ���͂���Ă����ꍇ
		if (!ACTextUtilities.isNullText(getValidPeriodStart().getText())) {
			// ���t�^���ǂ����̃`�F�b�N
			if (!getValidPeriodStart().isValidDate()) {
				// �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_WRONG_DATE ���� = �L������
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�L������");
				// ��L�����ԃe�L�X�g�i�I���j�ivalidPeriodEnd�j��Ƀt�H�[�J�X�𓖂Ă�B
				getValidPeriodStart().requestFocus();
				// �����𔲂���B�i�����𒆒f����j
				return false;
			}

			// ��L�����ԃe�L�X�g�i�I���j�ivalidPeriodEnd�j������͂���Ă��邩�`�F�b�N����B
			// ���͂���Ă����ꍇ
			if (!ACTextUtilities.isNullText(getValidPeriodEnd().getText())) {
				if (!getValidPeriodEnd().isValidDate()) {
					// �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_WRONG_DATE ���� = �L������
					QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�L������");
					// ��L�����ԃe�L�X�g�i�I���j�ivalidPeriodEnd�j��Ƀt�H�[�J�X�𓖂Ă�B
					getValidPeriodEnd().requestFocus();
					// �����𔲂���B�i�����𒆒f����j
					return false;
				}

				// �L�����ԃe�L�X�g�ɓ��͂��ꂽ�l���`�F�b�N����B
				// �l���A�L�����ԃe�L�X�g�i�J�n�j���L�����ԃe�L�X�g�i�I���j�������ꍇ
				if (ACDateUtilities
						.compareOnDay(
								ACCastUtilities.toDate(getValidPeriodStart()
										.getText()),
								ACCastUtilities.toDate(getValidPeriodEnd()
										.getText())) == 1) {
					// �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_WRONG_DATE ���� = �L������
					QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�L������");
					// ��L�����ԃe�L�X�g�i�I���j�ivalidPeriodEnd�j��Ƀt�H�[�J�X�𓖂Ă�B
					getValidPeriodEnd().requestFocus();
					// �����𔲂���B�i�����𒆒f����j
					return false;
				} else if (ACDateUtilities
						.compareOnDay(
								ACCastUtilities.toDate(getValidPeriodStart()
										.getText()),
								ACCastUtilities.toDate(getValidPeriodEnd()
										.getText())) == 0) {
					// �l���A�L�����ԃe�L�X�g�i�J�n�j=�L�����ԃe�L�X�g�i�I���j�������ꍇ
					// �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_WRONG_DATE ���� = �L������
					QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�L������");
					// ��L�����ԃe�L�X�g�i�I���j�ivalidPeriodEnd�j��Ƀt�H�[�J�X�𓖂Ă�B
					getValidPeriodEnd().requestFocus();
					// �����𔲂���B�i�����𒆒f����j
					return false;
				}
			} else {
				// ���͂���Ă��Ȃ������ꍇ
				// �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_NEED_CHECK_FOR_INPUT ���� =
				// �L������
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						"�L������");
				// ��L�����ԃe�L�X�g�i�I���j�ivalidPeriodEnd�j��Ƀt�H�[�J�X�𓖂Ă�B
				getValidPeriodEnd().requestFocus();
				// �����𔲂���B�i�����𒆒f����j
				return false;
			}
		} else {
			// ���͂���Ă��Ȃ������ꍇ
			// �L�����ԃe�L�X�g�i�I���j�ivalidPeriodEnd�j������͂���Ă��邩�`�F�b�N����B
			// ���͂���Ă����ꍇ
			if (!ACTextUtilities.isNullText(getValidPeriodEnd().getText())) {
				if (!getValidPeriodEnd().isValid()) {
					// �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_WRONG_DATE ���� = �L������
					QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�L������");
					// ��L�����ԃe�L�X�g�i�I���j�ivalidPeriodEnd�j��Ƀt�H�[�J�X�𓖂Ă�B
					getValidPeriodEnd().requestFocus();
					// �����𔲂���B�i�����𒆒f����j
					return false;
				}

				// �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_NEED_CHECK_FOR_INPUT ���� =
				// �L������
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						"�L������");
				// ��L�����ԃe�L�X�g�i�J�n�j�ivalidPeriodStart�j��Ƀt�H�[�J�X�𓖂Ă�B
				getValidPeriodStart().requestFocus();
				// �����𔲂���B�i�����𒆒f����j
				return false;
				// ���͂���Ă��Ȃ������ꍇ
			} else {
				// �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_NEED_CHECK_FOR_INPUT
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						"�L������");
				// ��L�����ԃe�L�X�g�i�J�n�j�ivalidPeriodStart�j��Ƀt�H�[�J�X�𓖂Ă�B
				getValidPeriodStart().requestFocus();
				// �����𔲂���B�i�����𒆒f����j
				return false;
			}
		}

		// �L�����ԃe�L�X�g�i�J�n�j�ivalidPeriodStart�j�̒l���`�F�b�N����B
		// ���͂���Ă���l�������ȊO�̒l�������ꍇ
		if (ACDateUtilities.compareOnDay(
				ACCastUtilities.toDate(getValidPeriodStart().getText()),
				ACDateUtilities
						.toFirstDayOfMonth(
								ACCastUtilities.toDate(getValidPeriodStart()
										.getText()))) != 0) {
			// �G���[���b�Z�[�W��\������B ���b�Z�[�WID�FERROR_OF_VALID_PERIOD
			QkanMessageList.getInstance().ERROR_OF_VALID_PERIOD("�J�n", "����");
			return false;
		}
		// �E�L�����ԃe�L�X�g�i�I���j�ivalidPeriodEnd�j
		// ���͂���Ă���l�������ȊO�̒l�������ꍇ
		if (ACDateUtilities.compareOnDay(
				ACCastUtilities.toDate(getValidPeriodEnd().getText()),
				ACDateUtilities.toLastDayOfMonth(
						ACCastUtilities.toDate(getValidPeriodEnd().getText()))) != 0) {
			// �G���[���b�Z�[�W��\������B ���b�Z�[�WID�FERROR_OF_VALID_PERIOD
			QkanMessageList.getInstance().ERROR_OF_VALID_PERIOD("�I��", "����");
			return false;
		}

		// ���L�̃t�B�[���h�ɓ��͂���Ă�����t�����ɓo�^����Ă���L�����ԂƏd�����Ă��Ȃ����`�F�b�N����B���L�����Ԃ����������͂���Ă���ꍇ�̂ݒʉ߂��郍�W�b�N�B
		// �E�L�����ԃe�L�X�g�i�J�n�j�ivalidPeriodStart�j
		// �E�L�����ԃe�L�X�g�i�I���j�ivalidPeriodEnd�j
		// insurerLimitRateList����LIMIT_RATE_VALID_START�y�сALIMIT_RATE_VALID_END�̓��t�Ɣ�r����B
		// validPeriodStart > LIMIT_RATE_VALID_START
		// validPeriodStart < LIMIT_RATE_VALID_END
		// validPeriodEnd > LIMIT_RATE_VALID_START
		// validPeriodEnd > LIMIT_RATE_VALID_END

		if (getInsurerLimitRateList().size() > 0) {
			for (int i = 0; i < getInsurerLimitRateList().size(); i++) {
				if(canBackBtnHantei==true){
					return true;
				}
				
				if (insurerLimitRateEditHantei == true
						&& getInsurerLimitRateTable().getSelectedModelRow() == i) {
					insurerLimitRateEditHantei = false;
					break;
				}

				if (ACDateUtilities
						.compareOnDay(
								ACCastUtilities.toDate(getValidPeriodStart()
										.getText()),
								(Date) VRBindPathParser.get(
										"LIMIT_RATE_VALID_START",
										(VRMap) getInsurerLimitRateList()
												.getData(i))) == 0) {
					// ���L�̏����ƈ�v����ꍇ�G���[���b�Z�[�W��\������B���b�Z�[�WID =
					// QO002_ERROR_OF_DUPLICATE_LIMIT_RATE ���� = "�L������"
					QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�L������");
					return false;
				}
				if (ACDateUtilities.compareOnDay(
						ACCastUtilities.toDate(getValidPeriodEnd().getText()),
						(Date) VRBindPathParser.get("LIMIT_RATE_VALID_END",
								(VRMap) getInsurerLimitRateList().getData(i))) == 0) {
					// ���L�̏����ƈ�v����ꍇ�G���[���b�Z�[�W��\������B���b�Z�[�WID =
					// QO002_ERROR_OF_DUPLICATE_LIMIT_RATE ���� = "�L������"
					QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�L������");
					return false;
				}
				if (ACDateUtilities
						.compareOnDay(
								ACCastUtilities.toDate(getValidPeriodStart()
										.getText()),
								(Date) VRBindPathParser.get(
										"LIMIT_RATE_VALID_START",
										(VRMap) getInsurerLimitRateList()
												.getData(i))) == 1
						&& ACDateUtilities.compareOnDay(
								ACCastUtilities.toDate(getValidPeriodStart()
										.getText()),
								(Date) VRBindPathParser.get(
										"LIMIT_RATE_VALID_END",
										(VRMap) getInsurerLimitRateList()
												.getData(i))) == -1) {
					// ���L�̏����ƈ�v����ꍇ�G���[���b�Z�[�W��\������B���b�Z�[�WID =
					// QO002_ERROR_OF_DUPLICATE_LIMIT_RATE ���� = "�L������"
					QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�L������");
					return false;
				}
				if (ACDateUtilities.compareOnDay(
						ACCastUtilities.toDate(getValidPeriodEnd().getText()),
						(Date) VRBindPathParser.get("LIMIT_RATE_VALID_START",
								(VRMap) getInsurerLimitRateList().getData(i))) == 1
						&& ACDateUtilities.compareOnDay(
								ACCastUtilities.toDate(getValidPeriodEnd()
										.getText()),
								(Date) VRBindPathParser.get(
										"LIMIT_RATE_VALID_END",
										(VRMap) getInsurerLimitRateList()
												.getData(i))) == -1) {
					// ���L�̏����ƈ�v����ꍇ�G���[���b�Z�[�W��\������B���b�Z�[�WID =
					// QO002_ERROR_OF_DUPLICATE_LIMIT_RATE ���� = "�L������"
					QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�L������");
					return false;
				}
			}
		}

		// ���L�̃t�B�[���h���󔒂łȂ����`�F�b�N����B
		// �E�x�����x�z�i�v�x���j�iyosien�j
		// �E�x�����x�z�i�v���1�j�iyokaigo1�j
		// �E�x�����x�z�i�v���2�j�iyokaigo2�j
		// �E�x�����x�z�i�v���3�j�iyokaigo3�j
		// �E�x�����x�z�i�v���4�j�iyokaigo4�j
		// �E�x�����x�z�i�v���5�j�iyokaigo5�j
		// �󔒂������ꍇ
		if (getYosien1().getText().equals("")
				|| getYosien2().getText().equals("")
				|| getYosien().getText().equals("")
				|| getYokaigo1().getText().equals("")
				|| getYokaigo2().getText().equals("")
				|| getYokaigo3().getText().equals("")
				|| getYokaigo4().getText().equals("")
				|| getYokaigo5().getText().equals("")) {
			// �G���[���b�Z�[�W��\������B �����b�Z�[�WID�FERROR_OF_NEED_CHECK_FOR_INPUT
			QkanMessageList.getInstance()
					.ERROR_OF_NEED_CHECK_FOR_INPUT("�x�����x�z");
			// �����𔲂���B�i�����𒆒f����j
			return false;
		}
		return true;
	}

	/**
	 * �u�V�K�o�^���[�h�ɕύX���鏈���v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void insertModeChange() throws Exception {
		// �V�K�o�^���[�h�ɕύX���鏈��
		// ��ʃN���A�̂���allClearMap�𐶐�����B
		VRMap allClearMap = new VRHashMap();
		// allClearMap�̃\�[�X�𐶐�����B�i�V�K�o�^���N���A�����ɗp����j
		allClearMap = (VRMap) getInsurerInfos().createSource();
        // [ID:0000461][Masahiko Higuchi] 2009/03 add begin �ی��ғo�^���̏����l
        allClearMap.setData("INSURER_TYPE",new Integer(1));
        // [ID:0000461][Masahiko Higuchi] 2009/03 add end
        // [ID:0000520][Masahiko Higuchi] 2009/07 add begin �ی��҃}�X�^���ی��Ҕԍ��̃G���[�`�F�b�N�@�\��ǉ�
        // �ی��҃}�X�^�����݂���ꍇ�A�ی��Ҕԍ��A���C�x���g��g�ݍ���
        if (getMasterInsurerDBManager() != null
                && QkanSystemInformation.getInstance()
                        .isInsurerMasterDatabese()) {
            // ��͏���
            setQO002_InsurerRelation(new QO002_InsurerRelation(
                    getMasterInsurerDBManager(), getInsurerId(),
                    getInsurerName(), true, true, true , true));
        }
        // [ID:0000520][Masahiko Higuchi] 2009/07 add end
		getInsurerInfos().setSource(allClearMap);
		getInsurerInfos().bindSource();

		// insurerLImitRateList������������B
		// setInsurerLimitRateList(null);
		// �x�����x�z���e�[�u���ɏ������������R�[�h��\������B���e�[�u�����N���A�����
		// getInsurerLimitRateTableModel().setAdaptee(getInsurerLimitRateList());
		getInsurerLimitRateTableModel().clearData();

		// PROCESS_MODE���A���ʒ萔�̢PROCESS_MODE_INSERT(4)��ɂ���B
		setPROCESS_MODE(Integer.toString(QkanConstants.PROCESS_MODE_INSERT));

		// insurerLimitRateTableChangeFlg��0�i�ω��Ȃ��j��������B
		setInsurerLimitRateTableChangeFlg(0);

		// �x�����x�z�`�F�b�N���͂���
		getInsurerLimitRateEnableCheck().setSelected(false);

		// �����ϐ� map �𐶐�����B
		VRMap map = new VRHashMap();
		// ���J�ȋK��̎x�����x�z���擾�� map �Ɋi�[����
		map.putAll(doFindRegularLImitRate());
		// �擾�����x�����x�z��ی��Ҏx�����x�z���p�l���iinsurerLimitRateInfo�j�ɃZ�b�g����
		// setSource(contents, allClearMap);
		getValidPeriodPanel().setSource(map);
		// ��ʂɓW�J����
		getValidPeriodPanel().bindSource();

		// �ی��Ҕԍ��e�L�X�g��L���ɂ���
		getInsurerId().setEnabled(true);

	}

	/**
	 * �u��ʂ��N���A���鏈���v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void allClear() throws Exception {
		insertModeChange();
		// ��ʂ̏�Ԃ�ύX����B
		setState_INIT_STATE();
        // [ID:0000520][Masahiko Higuchi] 2009/07 add begin �ی��҃}�X�^���ی��Ҕԍ��̃G���[�`�F�b�N�@�\��ǉ�
        // �ی��҃}�X�^�����݂���ꍇ�A�ی��Ҕԍ��A���C�x���g��g�ݍ���
        if (getMasterInsurerDBManager() != null
                && QkanSystemInformation.getInstance()
                        .isInsurerMasterDatabese()) {
            setState_VALID_INSURER_SELECT();
        } else {
            setState_INVALID_INSURER_SELECT();
        }
        // [ID:0000520][Masahiko Higuchi] 2009/07 add end
		// �t�H�[�J�X�ݒ�
		getInsurerId().requestFocus();

	}

	/**
	 * �u�X�i�b�v�V���b�g���B�e���鏈���v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void snapshotCustom() throws Exception {
		// �X�i�b�v�V���b�g���B�e���鏈��
		// �X�i�b�v�V���b�g�̎B�e�Ώۂ��w�肷��B
		getSnapshot().setRootContainer(getContents());
		// �X�i�b�v�V���b�g���B�e����
		// getSnapshot().snapshot();
		// ���X�i�b�v�V���b�g�̎B�e�Ώۂ��牺�L�̗̈�����O����B
		VRList excusions = new VRArrayList();
		excusions.add(getInsurerLimitRateInfo());

		getSnapshot().setExclusions(excusions);

		// �v�����̈�̃X�i�b�v�V���b�g
		getSnapShotPeriod().setRootContainer(getInsurerLimitRateInfo());

		getSnapshot().snapshot();
		getSnapShotPeriod().snapshot();
	}

	/**
	 * �u�K��x�����x�z���擾���鏈���v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public VRMap doFindRegularLImitRate() throws Exception {
		// �K��x�����x�z���擾���鏈��
		// �����ϐ� regularLimitRateList �𐶐�����B
		VRList regularLimitRateList = new VRArrayList();
		// �����ϐ� regularLimitRateMap �𐶐�����B
		VRMap regularLimitRateMap = new VRHashMap();
		// �K��x�����x�z���擾���邽�߂�SQL�����擾����B
		// getSQL_SELECT_M_LIMIT_RATE(null);
		// �擾����SQL�������s����B
		VRMap sqlParam = new VRHashMap();
		// sqlParam.setData("M_LIMIT_RATE_DETAIL.LIMIT_RATE_HISTORY_ID","1");
		regularLimitRateList = getDBManager().executeQuery(
				getSQL_SELECT_M_LIMIT_RATE(null));
		// �擾�������R�[�h����1���ȏゾ�����ꍇ
		if (regularLimitRateList.size() > 0) {
			// �擾��������regularLimitRateList�Ɋi�[����B
			// ����̃��R�[�h�𒼗񉻂���B
			// ���񉻂����l��regularLImitRateMap�Ɋi�[����B
			// regularLimitRateMap��߂�l�Ƃ��ĕԂ��B

			VRMap map = new VRHashMap();
			if (regularLimitRateList.size() > 0) {
				// �e��񂾂��]�L
				map.putAll((VRMap) regularLimitRateList.getData());
				map.remove("JOTAI_CODE");
				map.remove("LIMIT_RATE_VALUE");
				map.setData("LIMIT_RATE_VALID_END", "");

				Iterator it = regularLimitRateList.iterator();
				while (it.hasNext()) {
					VRMap row = (VRMap) it.next();
					// JOTAI_CODE���L�[�ALIMIT_RATE_VALUE��l�Ƃ��Ēǉ�
					map.put(String.valueOf(VRBindPathParser.get("JOTAI_CODE",
							row)), VRBindPathParser
							.get("LIMIT_RATE_VALUE", row));
				}
			}
			regularLimitRateMap = map;

			return regularLimitRateMap;

		} else {
			return null;
		}
	}

    /**
     * �ی��ґI���{�^���������̏���
     * 
     * @author Masahiko Higuchi
     * @since V5.5.0
     */
    protected void insurerSelectButtonActionPerformed(ActionEvent e)
            throws Exception {
        // �ی��ґI����ʂ𐶐�����B
        QO002001 insurerSelectDialog = new QO002001();
        VRMap selectData = insurerSelectDialog.showModal(getMasterInsurerDBManager());
        // �I������Ă��Ȃ��ꍇ
        if(selectData == null) {
            return;
        }
        // �~�{�^���΍�
        if(selectData.isEmpty()) {
            return;
        }
        // �ی��Ҕԍ�
        getInsurerId().setText(
                ACCastUtilities.toString(VRBindPathParser.get("INSURER_NO",
                        selectData), ""));
        // �ی��Җ���
        getInsurerName().setText(
                ACCastUtilities.toString(VRBindPathParser.get("INSURER_NAME",
                        selectData), ""));
        getQO002_InsurerRelation().validDataNo(getInsurerId(),
                getInsurerId().getText());
        getQO002_InsurerRelation().validDataName(getInsurerName(),
                getInsurerName().getText());
        revalidate();
        repaint();
        
    }

}
