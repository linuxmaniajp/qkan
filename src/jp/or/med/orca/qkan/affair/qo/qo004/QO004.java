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
 * �쐬��: 2006/02/09  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ə��Ǘ� (004)
 * �v���O���� ���Ə��o�^ (QO004)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qo.qo004;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.Iterator;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.io.ACPropertyXML;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACHashMapFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.ACZipRelation;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.affair.qs.qs001.QS001ServicePanel;

/**
 * ���Ə��o�^(QO004)
 */
public class QO004 extends QO004Event {
	/**
	 * �R���X�g���N�^�ł��B
	 */
	public QO004() {
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
		// ��ʂ̏����\�����s�������B

		VRMap param = affair.getParameters();

		// �O��ʂ���̓n��p�����[�^�[��ޔ�����B
		// PROCESS_MODE = PROCESS_MODE
		// selectedProviderId = providerId
		if (VRBindPathParser.has("PROCESS_MODE", param)) {
			setPROCESS_MODE(ACCastUtilities.toInt(VRBindPathParser.get(
					"PROCESS_MODE", param)));
		}

		if (VRBindPathParser.has("PROVIDER_ID", param)) {
			setSelectedProviderId(ACCastUtilities.toString(VRBindPathParser
					.get("PROVIDER_ID", param)));
		}

		// ��ʂ̏������A�ݒ�
		initialize();

		// DB��背�R�[�h���擾���A��ʂɓW�J����B
		doFind();

	}

	public boolean canBack(VRMap parameters) throws Exception {
		if (!super.canBack(parameters)) {
			return false;
		}

		// �O��ʂɑJ�ڂ��鏈���B
		// �����߂�t���O��1�̏ꍇ
		if (getCompulsoryBackFlag() == 1) {
			return true;
		}

		// �ύX���`�F�b�N����B���X�i�b�v�V���b�g
		if (getSnapshot().isModified()
				|| getProviderStaffTableChangeFlag() == 1
				|| getProviderServiceTableChangeFlag() == 1) {
			// �Ō�ɕۑ�����Ă���A���ځE�e�[�u�����ύX����Ă���ꍇ(���L�̂����ꂩ�̏ꍇ�j
			// �EisModified
			// �EproviderServiceTableChangeFlag = 1
			// �EproviderStaffTableChangeFlag = 1
			if (getPROCESS_MODE() == QkanConstants.PROCESS_MODE_INSERT) {
				// PROCESS_MODE���A���ʒ萔�PROCESS_MODE_INSERT(4)��������ꍇ
				// �o�^�m�F���b�Z�[�W��\������B�����b�Z�[�WID = WARNING_OF_INSERT_ON_MODIFIED
				switch (QkanMessageList.getInstance()
						.WARNING_OF_INSERT_ON_MODIFIED()) {
				// �u�o�^���Ė߂�v������
				case ACMessageBox.RESULT_OK:
					try {
						// ���Ə���{�����̓`�F�b�N���s���B
						if (!doValidProviderCheck()) {
							return false;
						}
						// �ۑ��������s���B
						if (!doSave()) {
							return false;
						}
						setPROCESS_MODE(QkanConstants.PROCESS_MODE_UPDATE);
						break;
					} catch (Exception ex) {
						throw ex;
					}

				case ACMessageBox.RESULT_CANCEL:
					return false;
				}
			} else {
				// PROCESS_MODE���A���ʒ萔�̢PROCESS_MODE_UPDATE(3)��������ꍇ
				// �X�V�m�F���b�Z�[�W��\������B�����b�Z�[�WID = CAN_BACK_ON_UPDATE
				switch (QkanMessageList.getInstance()
						.WARNING_OF_UPDATE_ON_MODIFIED()) {
				// �u�X�V���Ė߂�v������
				case ACMessageBox.RESULT_OK:
					// ���Ə���{�����̓`�F�b�N
					if (!doValidProviderCheck()) {
						return false;
					}
					// �ۑ��������s���B
					if (!doSave()) {
						return false;
					}
					break;
				case ACMessageBox.RESULT_CANCEL:
					return false;
				}
			}
		}

		// �O��ʑJ�ڗp�p�����[�^�[��ݒ肷��B
		// KEY�FBOOMERANG_AFFAIR VALUE�FAFFAIR_ID
		VRBindPathParser.set("BOOMERANG_AFFAIR", parameters, AFFAIR_ID);

		// �X�V���[�h�̏ꍇ
		if (getPROCESS_MODE() == QkanConstants.PROCESS_MODE_UPDATE) {
			// KEY�FPROVIDER_ID VALUE�FselectedProviderId
			VRBindPathParser.set("PROVIDER_ID", parameters,
					getSelectedProviderId());
		}

		// �O��ʂւ̑J�ڂ�������Ȃ��true��Ԃ��B
		return true;
	}

	public boolean canClose() throws Exception {
		// �ύX�`�F�b�N�i�X�i�b�v�V���b�g�A��ʃe�[�u���̃`�F�b�N�j
		if (getSnapshot().isModified()
				|| getProviderStaffTableChangeFlag() == 1
				|| getProviderServiceTableChangeFlag() == 1) {
			// �Ō�ɕۑ�����Ă���A���ځE�e�[�u�����ύX����Ă���ꍇ(���L�̂����ꂩ�̏ꍇ�j
			// �EisModified
			// �EproviderServiceTableChangeFlag = 1
			// �EproviderStaffTableChangeFlag = 1
			// �I���m�F���b�Z�[�W��\������B
			// �E���b�Z�[�WID�FWARNING_OF_CLOSE_ON_MODIFIED
			if (QkanMessageList.getInstance().WARNING_OF_CLOSE_ON_MODIFIED() == ACMessageBox.RESULT_CANCEL) {
				// �u�L�����Z���v��I�������ꍇ
				// �����𒆒f����i�������Ȃ��j�B
				return false;
			}
		}

		// �V�X�e�����I������B
		return true;

	}

	// �R���|�[�l���g�C�x���g

	/**
	 * �u�񋟃T�[�r�X��񔽉f�v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void reflectionActionPerformed(ActionEvent e) throws Exception {
		// �񋟃T�[�r�X���𔽉f���鏈��
		reflect();

	}

	/**
	 * �u�V�K�o�^���[�h�v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void newDataActionPerformed(ActionEvent e) throws Exception {
		// �V�K�o�^���[�h�ɕύX���鏈��
		if (getSnapshot().isModified()
				|| getProviderStaffTableChangeFlag() == 1
				|| getProviderServiceTableChangeFlag() == 1) {
			// �V�K���[�h�ύX�m�F���b�Z�[�W��\������B �����b�Z�[�WID = WARNING_OF_CLEAR_ON_MODIFIED
			if (QkanMessageList.getInstance().WARNING_OF_CLEAR_ON_MODIFIED() == ACMessageBox.RESULT_CANCEL) {
				// �u�L�����Z���v�̏ꍇ
				// �������I������B
				return;
			}
		}

		// �N���A�������s���B
		allClear();

	}

	/**
	 * �u�N���A�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void clearActionPerformed(ActionEvent e) throws Exception {
		// ��ʂ��N���A���鏈��
		// �ύX�`�F�b�N���s���B
		// ���X�i�b�v�V���b�g�i�S�́j�A�X�i�b�v�V���b�g�i�T�[�r�X�p�l���j�AproviderStaffTableChangeFlag
		if (getSnapshot().isModified()
				|| getProviderStaffTableChangeFlag() == 1
				|| getProviderServiceTableChangeFlag() == 1) {
			// �ύX���������ꍇ
			// �N���A�����m�F���b�Z�[�W��\������B �����b�Z�[�WID = WARNING_OF_CLEAR_ON_MODIFIED
			if (QkanMessageList.getInstance().WARNING_OF_CLEAR_ON_MODIFIED() == ACMessageBox.RESULT_CANCEL) {
				// �u�L�����Z���v�̏ꍇ
				// �������I������B
				return;
			}
		}

		// �N���A�������s���B
		allClear();

	}

	/**
	 * �u�Ώۃ��R�[�h����ʂɓW�J�v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void providerStaffTableSelectionChanged(ListSelectionEvent e)
			throws Exception {
		// �I�����ꂽ�Z���̒S���Җ�����ʂɓW�J���鏈��
		VRMap map = new VRHashMap();

		if (getProviderStaffTable().isSelected()) {
			// �I�����ꂽ���R�[�h���擾����B
			map = (VRMap) getProviderStaffTable().getSelectedModelRowValue();
			// �{�^���̏�Ԑݒ�
			setState_STAFF_BUTTON_STATE2();
		} else {
			// �S���җ̈�̃\�[�X�𐶐�����B
			map = (VRMap) getProviderStaffInputPanel().createSource();
			// �{�^���̏�Ԑݒ�
			setState_STAFF_BUTTON_STATE1();
		}

		// �\�[�X�Ƃ��Đݒ肷��B
		getProviderStaffInputPanel().setSource(map);

		// ��ʂɓW�J����B
		getProviderStaffInputPanel().bindSource();

		// �X�i�b�v�V���b�g�B�e
		getStaffSnapshot().snapshot();

	}

	/**
	 * �u�Ώۃ��R�[�h����ʂɓW�J�v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void serviceKindTableSelectionChanged(ListSelectionEvent e)
			throws Exception {

		// �I�����ꂽ�Z���̒񋟃T�[�r�X�ڍ׏�����ʂɓW�J���鏈��
		// �e�[�u���s���I������Ă��Ȃ��ꍇ
		if (!getServiceKindTable().isSelected()) {
			// ���f�{�^���𖳌��ɂ���B
			setState_SERVICE_DETAIL_BUTTON_ENABLE_FALSE();
			// �񋟃`�F�b�N�̃N���A
			getOfferCheck().setValue(0);
			// �T�[�r�X�p�l���̃N���A
			getProviderDetailServiceDetails().removeAll();
			setProviderServiceClass(null);
			// �ޔ��T�[�r�X��ރR�[�h�̏�����
			setCurrentServiceType(0);
			// �T�[�r�X�p�l���̃X�i�b�v�V���b�g�B�e
			getServiceSnapshot().snapshot();
			return;
		}

		// �I���s���R�[�h�擾
		VRMap selectedService = (VRMap) getServiceKindTable()
				.getSelectedModelRowValue();
		// �I�����R�[�h�̃T�[�r�X��ނ��擾
		int selectedServiceType = ACCastUtilities.toInt(VRBindPathParser.get(
				"SYSTEM_SERVICE_KIND_DETAIL", selectedService));

		// �ēx����̍s���I�����ꂽ�ꍇ�A�����𔲂���
		if (getCurrentServiceType() == selectedServiceType) {
			return;
		}

		// �񋟃T�[�r�X�ڍ׏��p�l���̕ύX�`�F�b�N���s���B���X�i�b�v�V���b�g
		if (isModifiedOnService()) {
			// �ύX������ꍇ
			// �񋟃T�[�r�X�m�F���b�Z�[�W��\������B
			// �����b�Z�[�WID = QO004_WARNING_OF_SERVICE_INSERT
			switch (QkanMessageList.getInstance()
					.QO004_WARNING_OF_SERVICE_INSERT()) {
			// �uYES�v���I�����ꂽ�ꍇ
			case ACMessageBox.RESULT_YES:
				// ���f����
				if (!reflect()) {
					// �I�������ɖ߂�
					VRList temp = (VRList) getProviderServiceTableModel()
							.getAdaptee();
					int i = ACBindUtilities.getMatchIndexFromValue(temp,
							"SYSTEM_SERVICE_KIND_DETAIL", new Integer(
									getCurrentServiceType()));
					getServiceKindTable().setSelectedModelRow(i);
					return;
				}
				break;
			// �uNO�v���I�����ꂽ�ꍇ
			case ACMessageBox.RESULT_NO:
				// �ޔ����Ă����I���T�[�r�X��ރR�[�h��������
				setCurrentServiceType(0);
				break;
			// �uCANCEL�v���I�����ꂽ�ꍇ
			case ACMessageBox.RESULT_CANCEL:
				// �I�������ɖ߂�
				VRList temp = (VRList) getProviderServiceTableModel()
						.getAdaptee();
				int i = ACBindUtilities.getMatchIndexFromValue(temp,
						"SYSTEM_SERVICE_KIND_DETAIL", new Integer(
								getCurrentServiceType()));
				getServiceKindTable().setSelectedModelRow(i);
				return;
			}
		}

		ACPanel panel = createProviderServicePanel(selectedServiceType);

		if (panel == null) {
			getProviderDetailServiceDetails().removeAll();
			setProviderServiceClass(null);
		} else {

			panel.setFollowChildEnabled(true);

            //2009/02/25 [ID:0000440][Tozo TANAKA] replace begin - ����21�N4���@�����Ή�
            //������21�N4���@�����Ή���
//			((QS001ServicePanel) panel).setDBManager(getDBManager());
//
//			setProviderServiceClass((iProviderServicePanel) panel);
//
//			getProviderServiceClass().initialize();
            if(panel instanceof QO004ProviderPanel){
                ((QO004ProviderPanel) panel).setDBManager(getDBManager());
            }
            if(panel instanceof iProviderServicePanel){
                setProviderServiceClass((iProviderServicePanel) panel);
            }
            getProviderServiceClass().initialize();
            
            if (panel instanceof QO004ProviderPanel) {
                int oldLowSetting = 0;
                if (ACFrame.getInstance().getPropertyXML().hasValueAt(
                        "ScreenConfig/ShowOldLowProviderElements")) {
                    //�V�X�e���ݒ�[ScreenConfig/ShowOldLowProviderElements]�̒l���擾����B
                    oldLowSetting = ACCastUtilities.toInt(ACFrame
                            .getInstance().getPropertyXML().getValueAt(
                                    "ScreenConfig/ShowOldLowProviderElements"),
                            0);
                }
                //�擾�����l��0���傫���ꍇ
                //���@���ڂ̕\����Ԃ��u�\���v�ɐݒ肷��B
                //�擾�����l��0�ȉ��̏ꍇ
                //���@���ڂ̕\����Ԃ��u��\���v�ɐݒ肷��B
                ((QO004ProviderPanel) panel)
                        .setOldLowElementAreaVisible(oldLowSetting > 0);
            }            
            // 2009/02/25 [ID:0000440][Tozo TANAKA] replace end - ����21�N4���@�����Ή�

			// �T�[�r�X��ޏڍח̈�iproviderDetailServiceDetails�j�ȉ��̃p�l�����폜����B�Z�b�g����Ă���p�l���̍폜����
			getProviderDetailServiceDetails().removeAll();

			// �񋟃T�[�r�X�p�l���Ƃ���servicePanel��ǉ�����B���p�l���̐؂�ւ�����
			getProviderDetailServiceDetails().add(
					(ACPanel) getProviderServiceClass(), VRLayout.CLIENT);
			getProviderDetailServiceDetails().revalidate();
			getProviderDetailServiceDetails().repaint();

			// servicePanel �ɑI�����ꂽ�Z���̃��R�[�h���\�[�X�Ƃ��Đݒ肷��B
			panel.setSource(selectedService);

			// servicePanel �ɓW�J����B
			panel.bindSource();

		}

		// �񋟃`�F�b�N�ɂ��l��^����B
		getOfferCheck().setSource(selectedService);
		getOfferCheck().bindSource();

		// �T�[�r�X�̏�Ԃ�ݒ肷��B
		setStateServiceInfos();

		// ���f�{�^����L���ɂ���B
		setState_SERVICE_DETAIL_BUTTON_ENABLE_TRUE();

		// �T�[�r�X�p�l���p�̃X�i�b�v�V���b�g���B�e����B
		getServiceSnapshot().snapshot();

		// �I���T�[�r�X�̃T�[�r�X��ރR�[�h��ޔ�
		setCurrentServiceType(selectedServiceType);

	}

	/**
	 * �u�T�[�r�X�p�l���̐���v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void offerCheckActionPerformed(ActionEvent e) throws Exception {
		// �T�[�r�X�񋟂̗L���𔻕ʂ��鏈��
		setStateServiceInfos();

	}

	/**
	 * �u�S���Ғǉ��v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void providerStaffInsertActionPerformed(ActionEvent e)
			throws Exception {
		// �S���҂�ǉ����鏈��

		// ���̓`�F�b�N
		if (!isValidInputStaff(CHECK_MODE_INSERT)) {
			return;
		}

		// ��ʏ�̃f�[�^���擾
		VRMap map = new VRHashMap();
		getProviderStaffInputPanel().setSource(map);
		getProviderStaffInputPanel().applySource();

		// providerStaffList�����������[�v���ASTAFF_ID�̍ő�l+1�̒l���擾����B
		int maxId = 0;
		// �ő�l�̎擾
		if (!(getProviderStaffList() == null)) {
			// ��ʃe�[�u���Ɋ��Ƀf�[�^�����݂��Ă���ꍇ
			for (int i = 0; i < getProviderStaffList().size(); i++) {
				int target = ACCastUtilities.toInt(VRBindPathParser.get(
						"STAFF_ID", (VRMap) getProviderStaffList().get(i)));
				// ��r�Ώۂ���r�����傫���l�̏ꍇ
				if (maxId < target) {
					// ��r�Ώۂ��r���Ƃ���B
					maxId = target;
				}
			}
		}

		// STAFF_ID�̐ݒ�
		VRBindPathParser.set("STAFF_ID", map, new Integer(maxId + 1));

		// providerStaffList�ɉ�ʏ�̃f�[�^��ǉ�����B
		getProviderStaffList().add(map);

		// �ǉ��s��I����Ԃɐݒ肷��B
		getProviderStaffTable().setSelectedModelRow(
				getProviderStaffList().size() - 1);

		// STAFF_PROCESS_MODE���`�F�b�N����B
		if (getSTAFF_PROCESS_MODE() == QkanConstants.PROCESS_MODE_INSERT) {
			// STAFF_PROCESS_MODE���A���ʒ萔�̢PROCESS_MODE_INSERT(4)��������ꍇ
			// ��ʏ�Ԃ�ύX����B�i�ҏW�폜�{�^���������\�ɂ���B�j
			setState_STAFF_BUTTON_STATE2();
		}

		// �S���҃e�[�u���t���O providerStaffTableChangeFlag �� 1�i�ύX����j�ɕύX����B
		setProviderStaffTableChangeFlag(1);

		// �X�i�b�v�V���b�g�B�e
		getStaffSnapshot().snapshot();

	}

	/**
	 * �u�S���ҕҏW�v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void providerStaffFindActionPerformed(ActionEvent e)
			throws Exception {
		// �S���҃e�[�u���őI�����ꂽ�S���҂̕ҏW���s������

		// ���̓`�F�b�N
		if (!isValidInputStaff(CHECK_MODE_UPDATE)) {
			return;
		}

		// ��ʏ�̃f�[�^���擾
		VRMap map = new VRHashMap();
		getProviderStaffInputPanel().setSource(map);
		getProviderStaffInputPanel().applySource();

		// �I������Ă��郌�R�[�h���擾
		VRMap selectedMap = (VRMap) getProviderStaffTable()
				.getSelectedModelRowValue();

		// �I�����R�[�h���A��ʏ�ɂȂ��f�[�^���ڂ��B
		int staffId = ACCastUtilities.toInt(VRBindPathParser.get("STAFF_ID",
				selectedMap));
		VRBindPathParser.set("STAFF_ID", map, new Integer(staffId));

		// �I�����R�[�h�Ɖ�ʏ�̃f�[�^��u��������B
		getProviderStaffList().setData(
				getProviderStaffTable().getSelectedModelRow(), map);

		// �ĕ`��
		getProviderStaffTable().repaint();
		getProviderStaffTable().revalidate();

		// �S���҃e�[�u���t���O providerStaffTableChangeFlag �� 1�i�ύX����j�ɕύX����B
		setProviderStaffTableChangeFlag(1);

		// �X�i�b�v�V���b�g�B�e
		getStaffSnapshot().snapshot();
	}

	/**
	 * �u�S���ҍ폜�v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void providerStaffDeleteActionPerformed(ActionEvent e)
			throws Exception {
		// �S���҃e�[�u���őI�����ꂽ�S���҂̍폜���s������

		// �I�����ꂽ���R�[�h��providerStaffList����폜����B
		if (!(getProviderStaffList() == null || getProviderStaffList().size() == 0)) {
			// �m�F���b�Z�[�W��\������B
			// �E���b�Z�[�WID�FWARNING_OF_DELETE_SELECTION
			switch (QkanMessageList.getInstance().WARNING_OF_DELETE_SELECTION()) {

			case ACMessageBox.RESULT_OK:
				// �u�͂��v��I�������ꍇ
				// �I������Ă��郌�R�[�h�̉�ʏ�̃C���f�b�N�X
				int sortedRow = getProviderStaffTable().getSelectedSortedRow();

				// �I������Ă��郌�R�[�h��providerStaffList����폜����B
				getProviderStaffList().remove(
						getProviderStaffTable().getSelectedModelRow());

				// �폜���ꂽ�s��1�s��̍s��I������B
				getProviderStaffTable().setSelectedSortedRowOnAfterDelete(
						sortedRow);

				// �S���҃e�[�u���t���O providerStaffTableChangeFlag �� 1�i�ύX����j�ɕύX����B
				setProviderStaffTableChangeFlag(1);

				break;

			case ACMessageBox.RESULT_CANCEL:
				// �u�L�����Z���v��I�������ꍇ
				// �����𔲂���B�i�������Ȃ��j
				break;
			}
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
		// ���Ə�����o�^���鏈��

		try {

			// ���Ə��T�[�r�X��񂪕ύX����Ă��Ȃ����`�F�b�N����B
			if (isModifiedOnService()) {
				// �ύX������ꍇ
				// �񋟃T�[�r�X�m�F���b�Z�[�W��\������B
				// �����b�Z�[�WID = QO004_WARNING_OF_SERVICE_INSERT
				switch (QkanMessageList.getInstance()
						.QO004_WARNING_OF_SERVICE_INSERT()) {
				// �uYES�v���I�����ꂽ�ꍇ
				case ACMessageBox.RESULT_YES:
					// ���f����
					if (!reflect()) {
						return;
					}
					break;
				// �uNO�v���I�����ꂽ�ꍇ
				case ACMessageBox.RESULT_NO:
					break;
				// �uCANCEL�v���I�����ꂽ�ꍇ
				case ACMessageBox.RESULT_CANCEL:
					return;
				}
			}

			// �S���ҏ�񂪕ύX����Ă��Ȃ����`�F�b�N����B
			if (getStaffSnapshot().isModified()) {
				// ���b�Z�[�W�\��
				String msgParam = "�S���ҏ��";
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

			// ���Ə���{�����̓`�F�b�N���s���B
			if (!doValidProviderCheck()) {
				return;
			}

			// �ۑ��������s���B
			if (!doSave()) {
				return;
			}

			// �������[�h���X�V���[�h�ɕύX����B
			setPROCESS_MODE(QkanConstants.PROCESS_MODE_UPDATE);

			// ��ʏ�Ԃ�ݒ肷��B
			affairSetUp();

			// �Č���
			doFind();

			// �T�[�r�X�̈�s�ڂ�I��
			getServiceKindTable().setSelectedSortedFirstRow();

			// �o�^�������b�Z�[�W��\������B �����b�Z�[�WID = INSERT_SUCCESSED
			QkanMessageList.getInstance().INSERT_SUCCESSED();

		} catch (Exception ex) {
			throw ex;
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
		// ���Ə������X�V���鏈��

		try {

			// ���Ə��T�[�r�X��񂪕ύX����Ă��Ȃ����`�F�b�N����B
			if (isModifiedOnService()) {
				// �ύX������ꍇ
				// �񋟃T�[�r�X�m�F���b�Z�[�W��\������B
				// �����b�Z�[�WID = QO004_WARNING_OF_SERVICE_INSERT
				switch (QkanMessageList.getInstance()
						.QO004_WARNING_OF_SERVICE_INSERT()) {
				// �uYES�v���I�����ꂽ�ꍇ
				case ACMessageBox.RESULT_YES:
					// ���f����
					if (!reflect()) {
						return;
					}
					break;
				// �uNO�v���I�����ꂽ�ꍇ
				case ACMessageBox.RESULT_NO:
					break;
				// �uCANCEL�v���I�����ꂽ�ꍇ
				case ACMessageBox.RESULT_CANCEL:
					return;
				}
			}

			// �S���ҏ�񂪕ύX����Ă��Ȃ����`�F�b�N����B
			if (getStaffSnapshot().isModified()) {
				// ���b�Z�[�W�\��
				String msgParam = "�S���ҏ��";
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

			// ���Ə���{�����̓`�F�b�N���s���B
			if (!doValidProviderCheck()) {
				return;
			}

			// �ۑ��������s���B
			if (!doSave()) {
				return;
			}

			// ��ʏ�Ԃ�ݒ肷��B
			affairSetUp();

			// �Č���
			doFind();

			// �T�[�r�X�̈�s�ڂ�I��
			getServiceKindTable().setSelectedSortedFirstRow();

			// �X�V�������b�Z�[�W��\������B �����b�Z�[�WID = UPDATE_SUCCESSED
			QkanMessageList.getInstance().UPDATE_SUCCESSED();

		} catch (Exception ex) {
			throw ex;
		}

	}

	public static void main(String[] args) {
		// �f�t�H���g�f�o�b�O�N��
		// ACFrame.getInstance().setFrameEventProcesser(new
		// QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		param.setData("PROVIDER_ID", "0000000006");
		param.setData("PROCESS_MODE", new Integer(
				QkanConstants.PROCESS_MODE_INSERT));
		// param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
		ACFrame.debugStart(new ACAffairInfo(QO004.class.getName(), param));
	}

	// �����֐�
	/**
	 * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void initialize() throws Exception {

		// �^�C�g���̐ݒ�
		// �Ɩ����}�X�^���A�f�[�^���擾����B
		// �擾�����f�[�^�̃E�B���h�E�^�C�g���iWINDOW_TITLE�j���E�B���h�E�ɐݒ肷��B
		// �擾�����f�[�^�̋Ɩ��^�C�g���iAFFAIR_TITLE�j���Ɩ��{�^���o�[�ɐݒ肷��B
		setAffairTitle(AFFAIR_ID, getButtons());

		// �p�b�V�u�L�[�̒�`
		setPROVIDER_PASSIVE_CHECK_KEY(new ACPassiveKey("PROVIDER",
				new String[] { "PROVIDER_ID" }, new boolean[] { true },
				"LAST_TIME", "LAST_TIME"));

		// �X�i�b�v�V���b�g�B�e�Ώێw��
		// �X�i�b�v�V���b�g�̑Ώۂ��w�肷��B�i�S�́j
		getSnapshot().setRootContainer(getProviderContents());

		// ���Ώۂ��A�ȉ��̗̈�����O����B
		// �E�T�[�r�X�ڍ׏��̈�iproviderDetailServiceDetails�j
		// �E���Ə��ڍ׏��̈�iproviderDetailContents�j
		// �E�S���ҏڍ׏��̈�iproviderMainContentChargesPanel�j
		VRList excusions = new VRArrayList();
		excusions.add(getProviderDetailServiceDetails());
		excusions.add(getProviderDetailContents());
		excusions.add(getProviderMainContentChargesPanel());
		getSnapshot().setExclusions(excusions);

		// �X�i�b�v�V���b�g�̑Ώۂ��w�肷��B�i�T�[�r�X�j
		getServiceSnapshot()
				.setRootContainer(getProviderDetailServiceDetails());
		// �X�i�b�v�V���b�g�̑Ώۂ��w�肷��B�i�S���ҁj
		getStaffSnapshot().setRootContainer(getProviderStaffInputPanel());

		// �e�[�u�����f���̐ݒ�
		ACTableModelAdapter model = null;

		// providerStaffTableModel��ݒ肷��B
		// "STAFF_FAMILY_NAME+' '+STAFF_FIRST_NAME"
		model = new ACTableModelAdapter();
		model.setColumns(new String[] { "CARE_MANAGER_NO",
				"STAFF_FAMILY_NAME+'�@'+STAFF_FIRST_NAME" });
		setProviderStaffTableModel(model);

		// providerServiceTableModel��ݒ肷��B
		// "OFFER" "SERVICE_NAME"
		model = new ACTableModelAdapter();
		model.setColumns(new String[] { "OFFER", "SERVICE_ABBREVIATION" });
		setProviderServiceTableModel(model);

		// �e�[�u�����f�������L�̉�ʂ̃e�[�u���ɐݒ肷��B
		// �E�S���҃e�[�u���iproviderStaffTable�j �E�e�[�u�����f���iproviderStaffTableModel�j
		// �E�񋟃T�[�r�X�e�[�u���iserviceKindTable�j �E�e�[�u�����f���iproviderServiceTableModel�j
		getProviderStaffTable().setModel(getProviderStaffTableModel());
		getServiceKindTable().setModel(getProviderServiceTableModel());

		// �A�C�R���̐ݒ�
		getServiceKindTableColum1()
				.setFormat(
						new ACHashMapFormat(
								new String[] {
										"jp/nichicom/ac/images/icon/pix16/btn_079.png",
										"jp/nichicom/ac/images/icon/pix16/btn_080.png" },
								new Boolean[] { new Boolean(true),
										new Boolean(false) }));

		// �X�֔ԍ�����Z���ϊ�
		// �X�֔ԍ��ƏZ�����֘A�t����B
		new ACZipRelation(getProviderPostnoOn(), getProviderPostnoUnder(),
				getProviderAddress());

		// ���j���[�}�X�^�f�[�^�̎擾
		getMasterMenu();

		// ��ʏ�Ԃ������ݒ�ɂ���B
		setState_INIT_STATE();

		// ��ʂ̐ݒ�
		affairSetUp();

	}

	/**
	 * �u��ʐݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void affairSetUp() throws Exception {

		// �R���{�ݒ�
		VRMap comboMap = new VRHashMap();
		VRList temp = new VRArrayList();

		// �R�[�h�}�X�^��艺�L��CODE_ID�̃f�[�^���擾��comboMap�Ɋi�[����B
		// �ECODE_ID = CODE_PROVIDER_TYPE �����Ə����
		temp = QkanCommon.getArrayFromMasterCode(CODE_PROVIDER_TYPE,
				"PROVIDER_TYPE");
		VRBindPathParser.set("PROVIDER_TYPE", comboMap, temp);

		// �ECODE_ID = CODE_LAW_VERSION ���@�����敪
		temp = QkanCommon.getArrayFromMasterCode(CODE_LAW_VERSION,
				"LAW_VERSION");
		VRBindPathParser.set("LAW_VERSION", comboMap, temp);

		// comboMap �����Ə����̈�iproviderContents�j�ɃZ�b�g����B
		getProviderContents().setModelSource(comboMap);

		// ��ʂɓW�J����B���R���{�Z�b�g����
		getProviderContents().bindModelSource();

		// �������[�h�ɂ���ʏ�Ԑݒ�
		if (getPROCESS_MODE() == QkanConstants.PROCESS_MODE_INSERT) {
			setState_INSERT_STATE();
		} else {
			setState_UPDATE_STATE();
		}

	}

	/**
	 * �u���Ə����擾�����v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doFind() throws Exception {
		// ���Ə����擾���擾���鏈��

		// PROCESS_MODE�̃`�F�b�N���s���B
		if (getPROCESS_MODE() == QkanConstants.PROCESS_MODE_UPDATE) {
			// �X�V���[�h
			// PROCESS_MODE���A���ʒ萔�̢PROCESS_MODE_UPDATE(3)��������ꍇ

			// ���Ə������擾���AproviderList�Ɋi�[�B �����ʊ֐� getProviderInfo���g�p
			setProviderList(QkanCommon.getProviderInfo(getDBManager(),
					getSelectedProviderId()));

			// �p�b�V�u�`�F�b�N�p�̃f�[�^��o�^����B
			getPassiveChecker().reservedPassive(
					getPROVIDER_PASSIVE_CHECK_KEY(), getProviderList());

			if (getProviderList() == null || getProviderList().size() == 0) {
				// �X�V���[�h�ɂ����Ď��Ə������擾�ł��Ȃ������ꍇ
				// �����I�ɑS��ʂɑJ�ڂ���B

				// �G���[���b�Z�[�W��\������B
				QkanMessageList.getInstance().ERROR_OF_PASSIVE_CHECK_ON_FIND();

				// �O��ʂɖ߂�B(�����𔲂���)
				setCompulsoryBackFlag(1);
				ACFrame.getInstance().back();
				return;
			}

			// �u���Ə����̈�iproviderContents�j��Ɏ擾�������Ə�����ݒ肷��B
			getProviderContents().setSource(getFirstRecord(getProviderList()));

			// ��ʂɓW�J����B
			getProviderContents().bindSource();

			// ���Ə����j���[�����擾����B
			doFindProviderMenu();

		}

		// �񋟃T�[�r�X�e�[�u���̃f�[�^���擾����B
		doCreateServiceTableData();

		// �S���ҏ����擾����B
		doCreateStaffData();

		// �擾�����S���҃e�[�u���̃f�[�^�iproviderServiceList�j��providerServiceTableModel�ɐݒ肷��B
		getProviderServiceTableModel().setAdaptee(getProviderServiceList());

		// �擾�����S���҃e�[�u���̃f�[�^�iproviderStaffList�j��providerStaffTableModel�ɐݒ肷��B
		getProviderStaffTableModel().setAdaptee(getProviderStaffList());

		if (!(getProviderStaffList() == null || getProviderStaffList().size() == 0)) {
			// �S���ҏ��1���ȏ�̏ꍇ
			// �e�[�u���̈�s�ڂ�I��������Ԃɂ���B ���I���C�x���g
			getProviderStaffTable().setSelectedSortedFirstRow();
		}

		// �񋟃T�[�r�X�֘A�̏�Ԑݒ�
		setState_SERVICE_DETAIL_BUTTON_ENABLE_FALSE();

		// �t�H�[�J�X
		if (getPROCESS_MODE() == QkanConstants.PROCESS_MODE_INSERT) {
			getProviderId().requestFocus();
		} else {
			getProviderName().requestFocus();
		}

		// �X�i�b�v�V���b�g���B�e����B
		getSnapshot().snapshot();
		getServiceSnapshot().snapshot();
		getStaffSnapshot().snapshot();

	}

	/**
	 * �u���Ə����j���[�����擾����v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 * 
	 */
	public void doFindProviderMenu() throws Exception {

		// ���Ə����j���[�����擾����擾���鏈��
		// SQL���擾�p��VRMap param�𐶐����A�ȉ���KEY/VALUE��ݒ肷��B
		// KEY�FPROVIDER_ID VALUE�FselectedProviderId
		VRMap param = new VRHashMap();
		VRBindPathParser.set("PROVIDER_ID", param, getSelectedProviderId());

		// ���Ə����j���[�擾�p��SQL�����擾����B
		// SQL_ID�FGET_PROVIDER_MENU
		String strSql = getSQL_GET_PROVIDER_MENU(param);

		// SQL�������s���A���Ə����j���[�����擾����B
		// �擾�������Ə����j���[����providerMenuList�Ɋi�[����B
		setProviderMenuList(getDBManager().executeQuery(strSql));

		if (getProviderMenuList() == null || getProviderMenuList().size() == 0) {
			// ���Ə����j���[��񂪑��݂��Ȃ��ꍇ
			setMenuDataExistenceFlag(0);
		} else {
			// ���Ə����j���[��񂪑��݂���ꍇ
			setMenuDataExistenceFlag(1);
		}

	}

	/**
	 * �u�񋟃T�[�r�X���X�g�p�̃f�[�^���쐬����v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doCreateServiceTableData() throws Exception {
		// �񋟃T�[�r�X���X�g���쐬���鏈��

		// �T�[�r�X�}�X�^�f�[�^���擾����B
		VRMap temp = QkanCommon.getMasterService(getDBManager(),
				TARGET_DATE_20060401);

		if (temp == null) {
			// �}�X�^�f�[�^���擾�ł��Ȃ������ꍇ
			// �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_SERVICE_MASTER
			QkanMessageList.getInstance().QO004_ERROR_OF_SERVICE_MASTER();

			// �����I�ɑO��ʂɖ߂�B
			setCompulsoryBackFlag(1);
			ACFrame.getInstance().back();
			return;

		}

		// ��ÊŌ�A���̑��A��ȓ��퐶����̊�����r������B
		if (VRBindPathParser.has(new Integer(SERVICE_TYPE_IRYO_KANGO), temp)) {
			temp.remove(new Integer(SERVICE_TYPE_IRYO_KANGO));
		}
		if (VRBindPathParser.has(new Integer(SERVICE_TYPE_OTHER), temp)) {
			temp.remove(new Integer(SERVICE_TYPE_OTHER));
		}
		if (VRBindPathParser.has(new Integer(SERVICE_TYPE_ROUTINE), temp)) {
			temp.remove(new Integer(SERVICE_TYPE_ROUTINE));
		}

		VRList list = new VRArrayList(temp.values());
		setProviderServiceList(list);

		// �}�X�^�f�[�^���擾�ł����ꍇ
		// �ڍ׏��i�[�p
		VRList providerServiceDetailList = new VRArrayList();

		// PROCESS_MODE���`�F�b�N����B
		if (getPROCESS_MODE() == QkanConstants.PROCESS_MODE_UPDATE) {
			// �X�V���[�h
			// PROCESS_MODE���A���ʒ萔�̢PROCESS_MODE_UPDATE(3)��������ꍇ

			// �񋟃T�[�r�X�ڍ׏����擾����B
			providerServiceDetailList = QkanCommon.getProviderServiceDetail(
					getDBManager(), getSelectedProviderId());

		}

		if (providerServiceDetailList != null
				|| providerServiceDetailList.size() == 0) {
			// ���Ə��T�[�r�X��񂪑��݂��Ȃ��ꍇ
			setServiceDataExistenceFlag(0);
		} else {
			// ���Ə��T�[�r�X��񂪑��݂���ꍇ
			setServiceDataExistenceFlag(1);
		}

		// �}�X�^�f�[�^�ɒ񋟃t���O�̒l��ǉ�����B
		for (int i = 0; i < getProviderServiceList().size(); i++) {
			// �񋟃T�[�r�X���iproviderServiceList�j�̃T�[�r�X��ނƁA
			// �񋟃T�[�r�X�ڍ׏��iproviderServiceDetailList�j�̃T�[�r�X��ނ�1���R�[�h����r����B
			VRMap service = (VRMap) getProviderServiceList().get(i);

			// �ڍ׏��Ɉ�v����f�[�^�����邩��������B
			VRMap detail = ACBindUtilities.getMatchRowFromMap(
					providerServiceDetailList, "SYSTEM_SERVICE_KIND_DETAIL",
					service);

			if (detail == null) {
				// �T�[�r�X��ނ̈�v���郌�R�[�h�����������ꍇ
				// providerServiceList���̔�r�������R�[�h�Ɉȉ���KEY/VALUE��ݒ肷��B
				// KEY�FOFFER VALUE�FFALSE
				VRBindPathParser.set("OFFER", service, new Boolean(false));
			} else {
				// �T�[�r�X��ނ̈�v���郌�R�[�h���������ꍇ
				// ���R�[�h���m���}�[�W��providerServiceList�Ɋi�[����B
				service.putAll(detail);
				// ���R�[�h���Ɉȉ���KEY/VALUE��ݒ肷��B
				// KEY�FOFFER VALUE�FTRUE
				VRBindPathParser.set("OFFER", service, new Boolean(true));
			}

			// ���R�[�h��providerServiceList�ɖ߂��B
			getProviderServiceList().set(i, service);
		}
        

        // [ID:0000440][Tozo TANAKA] 2009/03/09 add begin ����21�N4���@�����Ή�
        int oldLowSetting = 0;
        if (ACFrame.getInstance().getPropertyXML().hasValueAt(
                "ScreenConfig/ShowOldLowProviderElements")) {
            //�V�X�e���ݒ�[ScreenConfig/ShowOldLowProviderElements]�̒l���擾����B
            oldLowSetting = ACCastUtilities.toInt(ACFrame
                    .getInstance().getPropertyXML().getValueAt(
                            "ScreenConfig/ShowOldLowProviderElements"),
                    0);
        }
        if(oldLowSetting <= 0){
            //�擾�����l��0�ȉ��̏ꍇ
            //�@������ɂȂ��Ȃ�T�[�r�X�̓t�B���^�����O���ĕ\������B

            //�񋟃T�[�r�X���O���X�g���N���A����B
            getFilteredServiceList().clear();
            Iterator it=getProviderServiceList().iterator();
            while(it.hasNext()){
                // �񋟃T�[�r�X���iproviderServiceList�j�̃T�[�r�X��ނ�S��������B
                VRMap service = (VRMap) it.next();
                switch (ACCastUtilities.toInt(VRBindPathParser.get(
                        "SYSTEM_SERVICE_KIND_DETAIL", service), 0)) {
                    //�V�X�e���T�[�r�X��ނ��ȉ��̂����ꂩ�̏ꍇ
                    case 12314:
                        //�Z�������×{���(��K���f�Ï�)
                    case 12614:
                        //���\�h�Z�������×{���(��K���f�Ï�)
                        //�񋟃T�[�r�X���O���X�g�ɑΏۃT�[�r�X��ǉ�����B
                        getFilteredServiceList().add(service);
                        break;
                }
            }
            //�񋟃T�[�r�X��񂩂�񋟃T�[�r�X���O���X�g�̍��ڂ����O����B
            getProviderServiceList().removeAll(getFilteredServiceList());
        }
        // [ID:0000440][Tozo TANAKA] 2009/03/09 add end
        
	}

	/**
	 * �u�S���ҏ��擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doCreateStaffData() throws Exception {
		// �S���ҏ����擾���鏈��

		// PROCESS_MODE���`�F�b�N����B
		if (getPROCESS_MODE() == QkanConstants.PROCESS_MODE_INSERT) {
			// PROCESS_MODE���A���ʒ萔�̢PROCESS_MODE_INSERT(4)��������ꍇ
			// STAFF_PROCESS_MODE���A���ʒ萔�̢PROCESS_MODE_INSERT(4)��ɐݒ肷��B
			setSTAFF_PROCESS_MODE(QkanConstants.PROCESS_MODE_INSERT);
			// ��ʏ�Ԃ�ݒ肷��B���ҏW�E�폜�{�^����Enable���䂵�����s�ɂ���B
			setState_STAFF_BUTTON_STATE1();
			// ���݃t���O
			setStaffDataExistenceFlag(0);
		} else {
			// PROCESS_MODE���A���ʒ萔�̢PROCESS_MODE_UPDATE(3)��������ꍇ
			// HashMap�Fparam���쐬���ȉ���KEY/VALUE�Őݒ肷��B
			// KEY�FPROVIDER_ID VALUE�FselectedProviderId
			VRMap param = new VRHashMap();
			VRBindPathParser.set("PROVIDER_ID", param, getSelectedProviderId());

			// �S���ҏ����擾���邽�߂�SQL�����擾����B
			String strSql = getSQL_GET_STAFF(param);

			// �擾����SQL�������s����B
			setProviderStaffList(getDBManager().executeQuery(strSql));

			if (getProviderStaffList() == null
					|| getProviderStaffList().size() == 0) {
				// ���R�[�h���擾�ł��Ȃ������ꍇ
				// STAFF_PROCESS_MODE���A���ʒ萔�̢PROCESS_MODE_INSERT(4)��ɐݒ肷��B
				setSTAFF_PROCESS_MODE(QkanConstants.PROCESS_MODE_INSERT);
				// �S���ҏ��̈�̏����l�쐬
				VRMap defaultMap = (VRMap) getProviderStaffInputPanel()
						.createSource();
				// �̈�̃N���A
				getProviderStaffInputPanel().setSource(defaultMap);
				getProviderStaffInputPanel().bindSource();
				// ��ʏ�Ԃ�ݒ肷��B���ҏW�E�폜�{�^����Enable���䂵�����s�ɂ���B
				setState_STAFF_BUTTON_STATE1();
				// ���݃t���O
				setStaffDataExistenceFlag(0);
			} else {
				// ���R�[�h���擾�ł����ꍇ
				// STAFF_PROCESS_MODE���A���ʒ萔�̢PROCESS_MODE_UPDATE(3)��ɐݒ肷��B
				setSTAFF_PROCESS_MODE(QkanConstants.PROCESS_MODE_UPDATE);
				// ���݃t���O
				setStaffDataExistenceFlag(1);
			}
		}
	}

	/**
	 * �u�S���ҏ����̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 * @return boolean
	 */
	public boolean isValidInputStaff(int checkMode) throws Exception {
		// �S���ҏ��̓��̓`�F�b�N���s���B
		String msgParam1;
		String msgParam2;

		// ���L�̃e�L�X�g�t�B�[���h�ɓ��͂���Ă���ꍇ�A������̒������`�F�b�N����B
		// �EproviderStaffCareManagerNo�i�x�������ԍ��j
		// ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"�x�������ԍ�"��������B
		// ���G���[�̏ꍇ�AString�FmsgParam2��錾���A"8"��������B
		if (!ACTextUtilities.isNullText(getProviderStaffCareManagerNo()
				.getText())) {
			String careManagerNo = getProviderStaffCareManagerNo().getText();

			if (careManagerNo.length() != 8) {
				// �����񒷂�8���łȂ��ꍇ
				getProviderStaffCareManagerNo().requestFocus();
				msgParam1 = "�x�������ԍ�";
				msgParam2 = "8";
				QkanMessageList.getInstance().ERROR_OF_LENGTH(msgParam1,
						msgParam2);
				return false;
			}

			// �����Ə����ɓ���̉��x�������ԍ������݂��Ȃ����`�F�b�N����B
			for (int i = 0; i < getProviderStaffList().size(); i++) {
				// �ҏW���[�h�̏ꍇ�A���g�̃��R�[�h�͖�������B
				if (checkMode == CHECK_MODE_UPDATE) {
					if (i == getProviderStaffTable().getSelectedModelRow()) {
						continue;
					}
				}

				// ���x�������ԍ����r����B
				VRMap temp = (VRMap) getProviderStaffList().get(i);
				if (careManagerNo
						.equals(ACCastUtilities.toString(VRBindPathParser.get(
								"CARE_MANAGER_NO", temp)))) {
					getProviderStaffCareManagerNo().requestFocus();
					QkanMessageList.getInstance()
							.QO004_ERROR_OF_DUPLICATE_CARE_MANAGER_NO();
					return false;
				}
			}

			// // ���̎��Ə����ɓ���̉��x�������ԍ������݂��Ȃ����`�F�b�N����B
			// VRMap param = new VRHashMap();
			// if (getPROCESS_MODE() == QkanConstants.PROCESS_MODE_UPDATE) {
			// // �X�V���[�h�̏ꍇ
			// // �p�����[�^�Ɏ��Ə�ID���܂߂�
			// VRBindPathParser.set("PROVIDER_ID", param,
			// getSelectedProviderId());
			// }
			// VRBindPathParser.set("CARE_MANAGER_NO", param, careManagerNo);
			//
			// String strSql = getSQL_GET_SAME_CARE_MANAGER_NO(param);
			// VRList sameNoStaffList = getDBManager().executeQuery(strSql);
			//
			// if (!(sameNoStaffList == null || sameNoStaffList.size() == 0)) {
			// getProviderStaffCareManagerNo().requestFocus();
			// QkanMessageList.getInstance().QO004_ERROR_OF_DUPLICATE_CARE_MANAGER_NO();
			// return false;
			// }

		}

		// ���L�̃e�L�X�g�t�B�[���h�����͂���Ă��邩�`�F�b�N����B
		// �EproviderStaffFamilyName�i�S���Ґ��j
		// �EproviderStaffInsert�i�S���Җ��j �������͂ǂ��炩����ɓ��͂���Ă���Ή�
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�S���Җ�"��������B
		if (ACTextUtilities.isNullText(getProviderStaffFamilyName().getText())
				&& ACTextUtilities.isNullText(getProviderStaffFirstName()
						.getText())) {
			getProviderStaffFamilyName().requestFocus();
			msgParam1 = "�S���Җ�";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
					msgParam1);
			return false;
		}

		// ���̓G���[���Ȃ������ꍇ
		return true;

	}

	/**
	 * �u�ۑ������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean doSave() throws Exception {
		// �ۑ����s������
		try {

			// ��`
			String errMsg;
			String errMsg2;
			String strSql;

			// ��ʏ�̃f�[�^���擾����B
			VRMap affairData = new VRHashMap();
			getProviderContents().setSource(affairData);
			getProviderContents().applySource();

            //2009/02/25 [ID:0000440][Tozo TANAKA] add begin - ����21�N4���@�����Ή�
            //������21�N4���@�����Ή���
            //���̓G���[�̌��o
            if (ACCastUtilities.toInt(VRBindPathParser.get("SPECIAL_AREA_FLAG",
                    affairData), 1) == 2) {
                // ���ʒn��Ƀ`�F�b�N�����Ă���ꍇ
                // �n��E�K�͂Ƃ��Ɂu���R�Ԓn�擙�v�ɊY������񋟃T�[�r�X��񂪂Ȃ������`�F�b�N����B
                int serviceCount = getProviderServiceList().size();
                for (int i = 0; i < serviceCount; i++) {
                    VRMap serviceInfo = (VRMap) getProviderServiceList().get(i);
                    if (ACCastUtilities.toInt(VRBindPathParser.get(
                            BIND_PATH_OF_MOUNTAINOUS_AREA_RAFIO, serviceInfo),
                            1) == 2
                            && ACCastUtilities.toInt(VRBindPathParser.get(
                                    BIND_PATH_OF_MOUNTAINOUS_AREA_SCALE,
                                    serviceInfo), 1) == 2) {
                        // �n��E�K�͂Ƃ��Ɂu���R�Ԓn�擙�v�ɊY������񋟃T�[�r�X��񂪂������ꍇ
                        // �G���[���b�Z�[�W��\������B
                        VRMap messageParam = new VRHashMap();
                        messageParam.put("serviceName", VRBindPathParser.get(
                                "SERVICE_ABBREVIATION", serviceInfo));
                        QkanMessageList.getInstance()
                                .QO004_ERROR_OF_AREA_COLLISION(messageParam);

                        // �񋟃T�[�r�X�e�[�u���̓��Y�T�[�r�X�Ƀt�H�[�J�X�����āA�T�[�r�X�ڍ׏���\��������B
                        getServiceKindTable().setSelectedModelRow(i);
                        //�߂�l�Ƃ���false��Ԃ��B
                        return false;
                    }
                }
            }
            //2009/02/25 [ID:0000440][Tozo TANAKA] add end - ����21�N4���@�����Ή�
            
			// �g�����U�N�V�������J�n����B
			getDBManager().beginTransaction();

			// �폜���ꂽ���Ə��̒��ɁA���͂��ꂽ���Ə��ԍ���
			// ��v���鎖�Ə��ԍ��������Ə������Ȃ����`�F�b�N����B
			if (getPROCESS_MODE() == QkanConstants.PROCESS_MODE_INSERT) {
				strSql = getSQL_GET_DELETE_PROVIDER_OF_DUPLICATE_ID(affairData);
				VRList list = getDBManager().executeQuery(strSql);
				if (!(list == null || list.size() == 0)) {
					// ���Ə������݂���ꍇ
					errMsg = "���Ə��ԍ�";
					errMsg2 = "���Ə�";
					switch (QkanMessageList.getInstance()
							.WARNING_OF_RESTORATION_OF_DELETE_DATA(errMsg,
									errMsg2)) {
					case ACMessageBox.RESULT_OK:
						// �X�V���[�h�ɐ؂�ւ���
						setPROCESS_MODE(QkanConstants.PROCESS_MODE_UPDATE);
						// ���Ə��ԍ���ݒ�
						setSelectedProviderId(ACCastUtilities
								.toString(VRBindPathParser.get("PROVIDER_ID",
										affairData)));
						// �t���O�̏�����
						clearFlags();
						// ��ʃZ�b�g�A�b�v
						affairSetUp();
						// ����
						doFind();
						// �T�[�r�X�̈�s�ڂ�I��
						getServiceKindTable().setSelectedSortedFirstRow();
						break;
					}
					// �g�����U�N�V��������
					getDBManager().rollbackTransaction();
					// �����I��
					return false;
				}
			}

			// �p�b�V�u�^�X�N���N���A����B
			getPassiveChecker().clearPassiveTask();

			// PROCESS_MODE���`�F�b�N����B
			if (getPROCESS_MODE() == QkanConstants.PROCESS_MODE_INSERT) {
				// PROCESS_MODE���A���ʒ萔�̢PROCESS_MODE_INSERT(4)��������ꍇ
				// �o�^�p�p�b�V�u�^�X�N��o�^����B
				getPassiveChecker().addPassiveInsertTask(
						getPROVIDER_PASSIVE_CHECK_KEY(), affairData);
			} else {
				// PROCESS_MODE���A���ʒ萔�̢PROCESS_MODE_UPDATE(3)��������ꍇ
				// �X�V�p�p�b�V�u�^�X�N��o�^����B
				getPassiveChecker().addPassiveUpdateTask(
						getPROVIDER_PASSIVE_CHECK_KEY(), 0);
			}

			// �p�b�V�u�`�F�b�N���s���B
			if (!getPassiveChecker().passiveCheck(getDBManager())) {
				// �p�b�V�u�G���[�����������ꍇ
				if (getPROCESS_MODE() == QkanConstants.PROCESS_MODE_INSERT) {
					// PROCESS_MODE���A���ʒ萔�̢PROCESS_MODE_INSERT(4)��������ꍇ
					// �G���[���b�Z�[�W��\������B
					// �����b�Z�[�WID = ERROR_OF_SAME_DATA_FOUND ���� = "���Ə�"
					errMsg = "���Ə��ԍ�";
					QkanMessageList.getInstance().ERROR_OF_SAME_DATA_FOUND(
							errMsg);
					getProviderId().requestFocus();
				} else {
					// PROCESS_MODE���A���ʒ萔�̢PROCESS_MODE_UPDATE(3)��������ꍇ
					// �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_PASSIVE_CHECK_ON_UPDATE
					QkanMessageList.getInstance()
							.ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
				}
				// �g�����U�N�V��������
				getDBManager().rollbackTransaction();
				// �����I��
				return false;
			}

			// ���Ə���{���̓o�^
			// PROCESS_MODE���`�F�b�N����B
			if (getPROCESS_MODE() == QkanConstants.PROCESS_MODE_INSERT) {
				// PROCESS_MODE���A���ʒ萔�̢PROCESS_MODE_INSERT(4)��������ꍇ
				// ���Ə����o�^�̂��߂�SQL�����擾����
				strSql = getSQL_INSERT_PROVIDER(affairData);
				// �擾����SQL�������s����B
				getDBManager().executeUpdate(strSql);
				// ���Ə��ԍ��̑ޔ�
				setSelectedProviderId(getProviderId().getText());
			} else {
				// PROCESS_MODE���A���ʒ萔�̢PROCESS_MODE_UPDATE(3)��������ꍇ
				// ���Ə����X�V�̂��߂�SQL�����擾����B
				strSql = getSQL_UPDATE_PROVIDER(affairData);
				// �擾����SQL�������s����B
				getDBManager().executeUpdate(strSql);
			}

			// �S���ҏ��̓o�^
			VRMap staffMap;
			// �폜
			if (getStaffDataExistenceFlag() == 1) {
				// ��ʓW�J���ɒS���ҏ�񂪑��݂����ꍇ
				// �S���폜
				staffMap = new VRHashMap();
				// staffMap�ɉ��L��KEY/VALUE��ݒ肷��B
				// KEY�FPROVIDER_ID VALUE�FselectedProviderId
				VRBindPathParser.set("PROVIDER_ID", staffMap,
						getSelectedProviderId());
				// �S���ҏ��폜�̂��߂�SQL�����擾����B
				strSql = getSQL_DELETE_STAFF(staffMap);
				// �擾����SQL�������s����B
				getDBManager().executeUpdate(strSql);

			}
			// �o�^
			// providerStaffList�̃��R�[�h�����`�F�b�N����B
			// ���R�[�h��1���ȏゾ�����ꍇ
			if (!(getProviderStaffList() == null || getProviderStaffList()
					.size() == 0)) {
				for (int i = 0; i < getProviderStaffList().size(); i++) {
					// VRMap�FstaffMap���쐬����B
					staffMap = new VRHashMap();
					staffMap = (VRMap) getProviderStaffList().get(i);
					// staffMap�ɉ��L��KEY/VALUE��ݒ肷��B
					// KEY�FPROVIDER_ID VALUE�FselectedProviderId
					VRBindPathParser.set("PROVIDER_ID", staffMap,
							getSelectedProviderId());
					// �S���ҏ��o�^�̂��߂�SQL�����擾����B
					strSql = getSQL_INSERT_STAFF(staffMap);
					// �擾����SQL�������s����B
					getDBManager().executeUpdate(strSql);
				}
			}

            // [ID:0000444][Tozo TANAKA] 2009/03/09 replace begin ����21�N4���@�����Ή�
//            // providerServiceList���̃��R�[�h�������[�v���񂵓o�^����������B
//            VRList insertServiceList = new VRArrayList();
//            for (int i = 0; i < getProviderServiceList().size(); i++) {
//                VRMap temp = (VRMap) getProviderServiceList().get(i);
//                boolean offer = ACCastUtilities.toBoolean(VRBindPathParser.get(
//                        "OFFER", temp));
//                int systemServiceKindDetail = ACCastUtilities
//                        .toInt(VRBindPathParser.get(
//                                "SYSTEM_SERVICE_KIND_DETAIL", temp));
//
//                // providerServiceList���OFFER�̒l��true�̃��R�[�h���擾����B
//                if (offer) {
//                    // �o�^�pVRList�ɒǉ�
//                    insertServiceList.add(temp);
//                    // SYSTEM_SERVICE_KIND_DETAIL��11301�i�K��Ō�i���j�j�̏ꍇ
//                    if (systemServiceKindDetail == SERVICE_TYPE_KAIGO_KANGO) {
//                        // �K��Ō�i��Áj�̍쐬
//                        // �K��Ō�i��Áj�̃}�X�^�f�[�^���T�[�r�X�}�X�^���擾
//                        // ���K��Ō�i��Áj�͉�ʓW�J���ɍ폜
//                        VRMap iryoKango = (VRMap) VRBindPathParser.get(
//                                new Integer(SERVICE_TYPE_IRYO_KANGO),
//                                (VRMap) QkanCommon
//                                        .getMasterService(getDBManager()));
//                        // ��ʏ�f�[�^�i�K��Ō�i���j�j�ƃ}�X�^�f�[�^�i�K��Ō�i��Áj�j���}�[�W
//                        VRMap cloneTemp = (VRMap) temp.clone();
//                        cloneTemp.putAll(iryoKango);
//                        insertServiceList.add(cloneTemp);
//                    }
//                }
//            }
            //�t�B���^����Ȃ��T�[�r�X�A�t�B���^�����T�[�r�X�����������������X�gnoFilteredProviderServiceList�𐶐�����B
            VRList noFilteredProviderServiceList = new VRArrayList();
            noFilteredProviderServiceList.addAll(getProviderServiceList());
            noFilteredProviderServiceList.addAll(getFilteredServiceList());
            
			// noFilteredProviderServiceList���̃��R�[�h�������[�v���񂵓o�^����������B
			VRList insertServiceList = new VRArrayList();
			for (int i = 0; i < noFilteredProviderServiceList.size(); i++) {
				VRMap temp = (VRMap) noFilteredProviderServiceList.get(i);
				boolean offer = ACCastUtilities.toBoolean(VRBindPathParser.get(
						"OFFER", temp));
				int systemServiceKindDetail = ACCastUtilities
						.toInt(VRBindPathParser.get(
								"SYSTEM_SERVICE_KIND_DETAIL", temp));

				// noFilteredProviderServiceList���OFFER�̒l��true�̃��R�[�h���擾����B
				if (offer) {
					// �o�^�pVRList�ɒǉ�
					insertServiceList.add(temp);
					// SYSTEM_SERVICE_KIND_DETAIL��11301�i�K��Ō�i���j�j�̏ꍇ
					if (systemServiceKindDetail == SERVICE_TYPE_KAIGO_KANGO) {
						// �K��Ō�i��Áj�̍쐬
						// �K��Ō�i��Áj�̃}�X�^�f�[�^���T�[�r�X�}�X�^���擾
						// ���K��Ō�i��Áj�͉�ʓW�J���ɍ폜
						VRMap iryoKango = (VRMap) VRBindPathParser.get(
								new Integer(SERVICE_TYPE_IRYO_KANGO),
								(VRMap) QkanCommon
										.getMasterService(getDBManager()));
						// ��ʏ�f�[�^�i�K��Ō�i���j�j�ƃ}�X�^�f�[�^�i�K��Ō�i��Áj�j���}�[�W
						VRMap cloneTemp = (VRMap) temp.clone();
						cloneTemp.putAll(iryoKango);
						insertServiceList.add(cloneTemp);
					}
				}
			}
            // [ID:0000444][Tozo TANAKA] 2009/03/09 replace end

			if (insertServiceList != null) {

				// ���j���[���o�^
				// ��ʓW�J���Ƀf�[�^�����݂��Ă����ꍇ�A�S���폜
				if (getMenuDataExistenceFlag() == 1) {
					// ���Ə����j���[��񂪑��݂���ꍇ
					// �p�����[�^�쐬
					VRMap param = new VRHashMap();
					VRBindPathParser.set("PROVIDER_ID", param,
							getSelectedProviderId());

					// SQL���擾�A���s
					strSql = getSQL_DELETE_PROVIDER_MENU(param);
					getDBManager().executeUpdate(strSql);
				}

				// �����Ə��̏ꍇ�̂݁A�o�^
				// providerList����PROVIDER_JIJIGYOUSHO_TYPE �̒l���`�F�b�N����B
				int jijigyoshoType = ACCastUtilities.toInt(VRBindPathParser
						.get("PROVIDER_JIJIGYOUSHO_TYPE", affairData));
				if (jijigyoshoType == PROVIDER_TYPE_JIJIGYOSHO) {
					// �����Ə��ł���ꍇ
					// ���Ə����j���[���m�肵�o�^���鏈�����s���B
					insertProviderMenu(insertServiceList);
				}

				// �]�v�ȃL�[��r��
				final String[] removeKeys = new String[] {
						"PROVIDER_SERVICE_ID", "SERVICE_VALID_START",
						"SERVICE_VALID_END", "SERVICE_CODE_KIND",
						"SERVICE_NAME", "SERVICE_ABBREVIATION",
						"SERVICE_KIND_NAME", "SERVICE_CALENDAR_ABBREVIATION",
						"CLAIM_STYLE_TYPE", "BUSINESS_TYPE",
						"CALENDAR_PASTE_FLAG", "CHANGES_CONTENT_TYPE",
						"CLAIM_LAYER", "SERVICE_FAMILY", "SERVICE_SORT",
						"LAST_TIME", "OFFER" };

				ACBindUtilities.removeKeys(insertServiceList, removeKeys);

				// ���Ə�ID��t��
				for (int i = 0; i < insertServiceList.size(); i++) {
					VRBindPathParser.set("PROVIDER_ID",
							(VRMap) insertServiceList.get(i),
							getSelectedProviderId());
				}

				// ���Ə��T�[�r�X�ڍ׏��̓o�^���s���B
				QkanCommon.updateProviderServiceDetail(getDBManager(),
						insertServiceList, getSelectedProviderId());

			}

			// �������R�~�b�g����B
			getDBManager().commitTransaction();

		} catch (Exception ex) {
			// �g�����U�N�V�����J�n����A�G���[���������Ă����ꍇ
			// ���������[���o�b�N����B
			getDBManager().rollbackTransaction();
			throw ex;
		}

		// �t���O�̏�����
		clearFlags();

		return true;
	}

	/**
	 * �u�폜�\�ȃT�[�r�X�����f���鏈���v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean doCheckDeleteService() throws Exception {
		// �폜�\�ȃT�[�r�X�����ʂ��鏈��

		// �����ϐ�
		VRMap sqlParam;
		VRList list;
		String strSql;
		String errMsg;

		// �o�^���[�h�̏ꍇ
		if (getPROCESS_MODE() == QkanConstants.PROCESS_MODE_INSERT) {
			// �`�F�b�N���s��Ȃ�
			return true;
		}

		// �Ώۃf�[�^�̎擾
		VRMap temp = getServiceInfos(getCurrentServiceType());
		int systemServiceKindDetail = ACCastUtilities.toInt(VRBindPathParser
				.get("SYSTEM_SERVICE_KIND_DETAIL", temp));

		// sqlParam�ɉ��L�̒l���i�[����B
		// KEY�FSYSTEM_SERVICE_KIND_DETAIL
		// VALUE�F���ݕ\�����Ă���p�l����SYSTEM_SERVICE_KIND_DETAIL
		// KEY�FPROVIDER_ID VALUE�FselectedProviderId
		sqlParam = new VRHashMap();
		VRBindPathParser.set("SYSTEM_SERVICE_KIND_DETAIL", sqlParam,
				new Integer(systemServiceKindDetail));
		VRBindPathParser.set("PROVIDER_ID", sqlParam, getSelectedProviderId());

		// ���ݕ\������Ă���p�l����������x�����Ɓi14301�j�������ꍇ
		if (systemServiceKindDetail == SERVICE_TYPE_CARE_PLAN) {
			// �v���F��TABLE�œo�^����Ă��鎖�Ə����`�F�b�N����B

			// �v���F��TABLE�`�F�b�N�p��SQL�����擾����B
			strSql = getSQL_GET_PATIENT_NINTEI_HISTORY(sqlParam);
			// �擾����SQL�������s����B
			list = new VRArrayList();
			list = getDBManager().executeQuery(strSql);

			// ���R�[�h���擾�ł����ꍇ
			if (list.size() > 0) {
				// errMsg = ���p�ғo�^�ŋ�����x�����Ə�
				// �G���[���b�Z�[�W�[��\������B
				// �����b�Z�[�WID=ERROR_OF_DELETE_USED ��1����=errMsg
				errMsg = "���p�ғo�^�ŋ�����x�����Ə�";
				QkanMessageList.getInstance().ERROR_OF_DELETE_USED(errMsg);
				// �߂�l�Ƃ���false��Ԃ��B
				return false;
			}
		}

		// �T�[�r�XTABLE�œo�^����Ă��鎖�Ə��Ƃ��ēo�^����Ă��邩�`�F�b�N����B
		// �T�[�r�XTABLE�p��SQL�����擾����B
		strSql = getSQL_GET_SERVICE(sqlParam);
		// �擾����SQL�������s����B
		list = new VRArrayList();
		list = getDBManager().executeQuery(strSql);

		// ���R�[�h���擾�ł����ꍇ
		if (list.size() > 0) {
			// errMsg = �T�[�r�X�̗\�薔�͎���
			// �G���[���b�Z�[�W�[��\������B
			// �����b�Z�[�WID=ERROR_OF_DELETE_USED ��1����=errMsg
			errMsg = "�T�[�r�X�̒񋟎��Ə�";
			QkanMessageList.getInstance().ERROR_OF_DELETE_USED(errMsg);
			// �߂�l�Ƃ���false��Ԃ��B
			return false;
		}

		// �S�Ă�SQL���̌��ʂ�0���������ꍇ
		// �߂�l�Ƃ���true��Ԃ�
		return true;

	}

	/**
	 * �u���Ə����j���[����o�^����v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void insertProviderMenu(VRList list) throws Exception {
		// ���Ə��o�^���j���[���m�肷��B
		// ��`
		// SQL���擾�p
		String strSql;

		try {

			// �o�^�����T�[�r�X��BUSINESS_TYPE��S�ē����i�_���a�Ōv�Z�j�����ʂ� businessType�i�ϐ��j�Ɋi�[����B
			int businessTypeSum = 0;
			int businessTypeTemp = 0;
			for (int i = 0; i < list.size(); i++) {
				VRMap temp = (VRMap) list.get(i);
				businessTypeTemp = ACCastUtilities.toInt(VRBindPathParser.get(
						"BUSINESS_TYPE", temp));
				businessTypeSum = businessTypeSum | businessTypeTemp;
			}

			// �擾�������j���[�}�X�^�̃��R�[�h���� ���L�̏������s���B
			int businessTypeMaster = 0;
			for (int i = 0; i < getMasterMenuList().size(); i++) {
				// masterMenuList���̃��R�[�h��masterMenuMap�Ɋi�[����B
				VRMap masterMenuMap = new VRHashMap();
				masterMenuMap = (VRMap) getMasterMenuList().get(i);
				businessTypeMaster = ACCastUtilities.toInt(VRBindPathParser
						.get("BUSINESS_TYPE", masterMenuMap));

				// businessTypeMaster��businessType��_���ςŌv�Z����B
				if ((businessTypeMaster & businessTypeSum) == 0) {
					// �v�Z�����l��0�������ꍇ
					// masterMenuMap�ɉ��L��KEY/VALUE��ݒ肷��B
					// KEY�FPROVIDER_ID VALUE�FselectedProviderId
					// KEY�FSHOW_FLAG VALUE�F0
					VRBindPathParser.set("PROVIDER_ID", masterMenuMap,
							getSelectedProviderId());
					VRBindPathParser.set("SHOW_FLAG", masterMenuMap,
							new Integer(0));
				} else {
					// �v�Z�����l��0�ȊO�̏ꍇ
					// masterMenuMap�ɉ��L��KEY/VALUE��ݒ肷��B
					// KEY�FPROVIDER_ID VALUE�FselectedProviderId
					// KEY�FSHOW_FLAG VALUE�F1
					VRBindPathParser.set("PROVIDER_ID", masterMenuMap,
							getSelectedProviderId());
					VRBindPathParser.set("SHOW_FLAG", masterMenuMap,
							new Integer(1));
				}

				// ���Ə����j���[���o�^�������s�����߂�SQL�����擾����B
				strSql = getSQL_INSERT_PROVIDER_MENU(masterMenuMap);
				// �擾����SQL�������s����B
				getDBManager().executeUpdate(strSql);

				// ���O�C�����Ə��̕ҏW���s�����ꍇ�̂�
				// �V�X�e���ɑޔ����Ă��鎖�Ə��̃��j���[�f�[�^���폜����B
				if (getSelectedProviderId().equals(
						QkanSystemInformation.getInstance()
								.getLoginProviderID())) {
					QkanSystemInformation.getInstance().setMenuTree(null);
				}
			}

		} catch (Exception ex) {
			// SQL�����s���ɃG���[�����������ꍇ
			// ��O�G���[�𓊂���B
			throw ex;
		}

	}

	/**
	 * �u�}�X�^���j���[��������擾���鏈���v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void getMasterMenu() throws Exception {
		// �}�X�^���j���[��������擾���鏈��
		// �}�X�^���j���[��������擾���邽�߂�SQL�����擾����B
		String strSql = getSQL_GET_M_MENU(null);
		// �擾����SQL�������s����B
		VRList list = getDBManager().executeQuery(strSql);

		if (list == null || list.size() == 0) {
			// �擾�������R�[�h��0���������ꍇ
			// �G���[���b�Z�[�W��\������B
			// �����b�Z�[�WID = QO004_ERROR_OF_MASTER_MENU
			QkanMessageList.getInstance().QO004_ERROR_OF_MASTER_MENU();
			return;
		}

		// ���R�[�h��1���ȏ�擾�ł����ꍇ
		// �擾�������R�[�h�W����MasterMenuList�Ɋi�[����B
		setMasterMenuList(list);

	}

	/**
	 * �u���Ə���{���`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean doValidProviderCheck() throws Exception {
		// ���Ə���{�����`�F�b�N����B

		// �G���[���b�Z�[�W�����i�[�p��errMsg���쐬����B
		String errMsg1;
		String errMsg2;

		// ���L�̃e�L�X�g�t�B�[���h�ɑ΂��ē��̓`�F�b�N���s���B
		// �EproviderId�i���Ə��ԍ��j
		if (ACTextUtilities.isNullText(getProviderId().getText())) {
			getProviderId().requestFocus();
			errMsg1 = "���Ə��ԍ�";
			QkanMessageList.getInstance()
					.ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg1);
			return false;
		}

		// ���Ə��ԍ���10�����`�F�b�N����B
		String temp = getProviderId().getText();
		if (temp.length() != 10) {
			getProviderId().requestFocus();
			errMsg1 = "���Ə��ԍ�";
			errMsg2 = "10";
			QkanMessageList.getInstance().ERROR_OF_LENGTH(errMsg1, errMsg2);
			return false;
		}

		// �EproviderName�i���Ə����́j
		if (ACTextUtilities.isNullText(getProviderName().getText())) {
			getProviderName().requestFocus();
			errMsg1 = "���Ə�����";
			QkanMessageList.getInstance()
					.ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg1);
			return false;
		}

		// ���L�̃��W�I�O���[�v�ɑ΂��đI���`�F�b�N���s���B
		// ���I���������ꍇ�� errMsg �Ƀ��b�Z�[�W���i�[����B
		// �EproviderMainContentDivision�i�����Ə��敪���W�I�O���[�v�j�� errMsg = �����Ə��敪
		if (!getProviderMainContentDivision().isSelected()) {
			getProviderMainContentDivision().requestFocus();
			errMsg1 = "�����Ə��敪";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(
					errMsg1);
			return false;
		}

		// �EproviderMainContentBusiness�i���Ƌ敪���W�I�O���[�v�j�� errMsg = ���Ƌ敪
		if (!getProviderMainContentBusiness().isSelected()) {
			getProviderMainContentBusiness().requestFocus();
			errMsg1 = "���Ƌ敪";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(
					errMsg1);
			return false;
		}

		// �EproviderMainContentRegion�i�n��敪���W�I�O���[�v�j ��errMsg = �n��敪
		if (!getProviderMainContentRegion().isSelected()) {
			getProviderMainContentRegion().requestFocus();
			errMsg1 = "�n��敪";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(
					errMsg1);
			return false;
		}

		return true;
	}

	/**
	 * �u�T�[�r�X�p�l�������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 * @param int
	 *            �V�X�e���T�[�r�X��ރR�[�h
	 */
	public ACPanel createProviderServicePanel(int serviceType) throws Exception {

		switch (serviceType) {
		// // �l�� 11101�i�K����j �������ꍇ
		// case 11101:
		// // panel��ACPanel "QO004001"�i�K����j�𐶐�����B
		// return new QO004001();
		// // �l�� 11201�i�K��������j �������ꍇ
		// case 11201:
		// // panel��ACPanel"QO004002"�i�K��������j�𐶐�����B
		// return new QO004002();
		// // �l�� 11301�i�K��Ō�j �������ꍇ
		// case 11301:
		// // panel��ACPanel"QO004003"�i�K����j�𐶐�����B
		// return new QO004003();
		// // �l�� 11401�i�K�⃊�n�j �������ꍇ
		// case 11401:
		// // panel��ACPanel"QO004004"�i�K�⃊�n�j�𐶐�����B
		// return new QO004004();
		// // �l�� 11501�i�ʏ����j �������ꍇ
		// case 11501:
		// // panel��ACPanel"QO004005"�i�ʏ����j�𐶐�����B
		// return new QO004005();
		// // �l�� 11601�i�ʏ����n�j �������ꍇ
		// case 11601:
		// // panel��ACPanel"QO004006"�i�ʏ����n�j�𐶐�����B
		// return new QO004006();
		// // �l�� 11701�i�����p��j �������ꍇ
		// case 11701:
		// // panel��ACPanel"QO004007"�i�����p��j�𐶐�����B
		// return new QO004007();
		// // �l�� 12101�i�Z�����������j �������ꍇ
		// case 12101:
		// // panel��ACPanel"QO004008"�i�Z�����������j�𐶐�����B
		// return new QO004008();
		// // �l�� 12201�i�Z�������×{���i�V���j�j �������ꍇ
		// case 12201:
		// // panel��ACPanel"QO004009"�i�Z�������×{���i�V���j�j�𐶐�����B
		// return new QO004009();
		// // �l�� 12301�i�Z�������×{���(�a�@�×{�^)�j �������ꍇ
		// case 12301:
		// // panel��ACPanel"QO004010"�i�Z�������×{���(�a�@�×{�^)�j�𐶐�����B
		// return new QO004010();
		// // �l�� 12302�i�Z�������×{���(�f�Ï��×{�^)�j �������ꍇ
		// case 12302:
		// // panel��ACPanel"QO004011"�i�Z�������×{���(�f�Ï��×{�^)�j�𐶐�����B
		// return new QO004011();
		// // �l�� 12303�i�Z�������×{���(�Z�������×{���(�F�m�ǎ����^)�j �������ꍇ
		// case 12303:
		// // panel��ACPanel"QO004012"�i�Z�������×{���(�F�m�ǎ����^)�j�𐶐�����B
		// return new QO004012();
		// // �l�� 12304�i�Z�������×{���(��K���f�Ï�)�j �������ꍇ
		// case 12304:
		// // panel��ACPanel"QO004013"�i�Z�������×{���(��K���f�Ï�)�j�𐶐�����B
		// return new QO004013();
		// // �l�� 13201�i�F�m�ǑΉ��^�����������j �������ꍇ
		// case 13201:
		// // panel��ACPanel"QO004014"�i�F�m�ǑΉ��^�����������j�𐶐�����B
		// return new QO004014();
		// // �l�� 13301�i����{�ݓ����Ґ������j �������ꍇ
		// case 13301:
		// // panel��ACPanel"QO004015"�i����{�ݓ����Ґ������j�𐶐�����B
		// return new QO004015();
		// // �l�� 15101�i���V�l�����{�݁j �������ꍇ
		// case 15101:
		// // panel��ACPanel"QO004016"�i���V�l�����{�݁j�𐶐�����B
		// return new QO004016();
		// // �l�� 15201�i���V�l�ی��{�݁j �������ꍇ
		// case 15201:
		// // panel��ACPanel"QO004017"�i���V�l�ی��{�݁j�𐶐�����B
		// return new QO004017();
		// // �l�� 15301�i���×{�^��Î{��(�×{�^�a�@)�j �������ꍇ
		// case 15301:
		// // panel��ACPanel"QO004018"�i���×{�^��Î{��(�×{�^�a�@)�j�𐶐�����B
		// return new QO004018();
		// // �l�� 15302�i���×{�^��Î{��(�f�Ï��^)�j �������ꍇ
		// case 15302:
		// // panel��ACPanel"QO004019"�i���×{�^��Î{��(�f�Ï��^)�j�𐶐�����B
		// return new QO004019();
		// // �l�� 15303�i���×{�^��Î{��(���×{�^��Î{��(�F�m�ǎ����^)�j �������ꍇ
		// case 15303:
		// // panel��ACPanel"QO004020"�i���×{�^��Î{��(�F�m�ǎ����^)�j�𐶐�����B
		// return new QO004020();
		// �l�� 11111�i�K����j �������ꍇ
		case 11111:
			// �ϐ� servicePanel �� ACPanel "QO004101"�i�K����j�𐶐�����B
			return new QO004101();
		// �l�� 11211�i�K��������j �������ꍇ
		case 11211:
			// �ϐ� servicePanel �� ACPanel"QO004102"�i�K��������j�𐶐�����B
			return new QO004102();
		// �l�� 11311�i�K��Ō�j �������ꍇ
		case 11311:
			// �ϐ� servicePanel �� ACPanel"QO004103"�i�K��Ō�j�𐶐�����B
			return new QO004103();
		// �l�� 11411�i�K�⃊�n�j �������ꍇ
		case 11411:
			// �ϐ� servicePanel �� ACPanel"QO004105"�i�K�⃊�n�j�𐶐�����B
			return new QO004105();
		// �l�� 11511�i�ʏ����j �������ꍇ
		case 11511:
			// �ϐ� servicePanel �� ACPanel"QO004107"�i�ʏ����j�𐶐�����B
			return new QO004107();
		// �l�� 11611�i�ʏ����n�j �������ꍇ
		case 11611:
			// �ϐ� servicePanel �� ACPanel"QO004108"�i�ʏ����n�j�𐶐�����B
			return new QO004108();
		// �l�� 11711�i�����p��j �������ꍇ
		case 11711:
			// �ϐ� servicePanel �� ACPanel"QO004116"�i�����p��j�𐶐�����B
			return new QO004116();
		// �l�� 12111�i�Z�����������j �������ꍇ
		case 12111:
			// �ϐ� servicePanel �� ACPanel"QO004109"�i�Z�������������j�𐶐�����B
			return new QO004109();
		// �l�� 12211�i�Z�������×{���i�V���j�j �������ꍇ
		case 12211:
			// �ϐ� servicePanel �� ACPanel"QO004110"�i�Z�������×{���i�V���j�j�𐶐�����B
			return new QO004110();
		// �l�� 12311�i�Z�������×{���(�a�@�×{�^)�j �������ꍇ
		case 12311:
			// �ϐ� servicePanel �� ACPanel"QO004111"�i�Z�������×{���(�a�@�×{�^)�j�𐶐�����B
			return new QO004111();
		// �l�� 12312�i�Z�������×{���(�f�Ï��×{�^)�j �������ꍇ
		case 12312:
			// �ϐ� servicePanel �� ACPanel"QO004112"�i�Z�������×{���(�f�Ï��×{�^)�j�𐶐�����B
			return new QO004112();
		// �l�� 12313�i�Z�������×{���(�Z�������×{���(�F�m�ǎ����^)�j �������ꍇ
		case 12313:
			// �ϐ� servicePanel �� ACPanel"QO004113"�i�Z�������×{���(�F�m�ǎ����^)�j�𐶐�����B
			return new QO004113();
		// �l�� 12314�i�Z�������×{���(��K���f�Ï�)�j �������ꍇ
		case 12314:
			// �ϐ� servicePanel �� ACPanel"QO004114"�i�Z�������×{���(��K���f�Ï�)�j�𐶐�����B
			return new QO004114();
		// �l�� 13111�i����×{�Ǘ��w���j �������ꍇ
		case 13111:
			// �ϐ� servicePanel �� ACPanel"QO004106"�i����×{�Ǘ��w���j�𐶐�����B
			return new QO004106();
		// �l�� 13311�i����{�ݓ����Ґ������j �������ꍇ
		case 13311:
			// �ϐ� servicePanel �� ACPanel"QO004115"�i����{�ݓ����Ґ������j�𐶐�����B
			return new QO004115();
		// �l�� 14311�i����×{�Ǘ��w���j �������ꍇ
		case 14311:
			// �ϐ� servicePanel �� ACPanel"QO004117"�i����×{�Ǘ��w���j�𐶐�����B
			return new QO004117();
		// �l�� 15111�i���V�l�����{�݁j �������ꍇ
		case 15111:
			// �ϐ� servicePanel �� ACPanel"QO004118"�i���V�l�����{�݁j�𐶐�����B
			return new QO004118();
		// �l�� 15211�i���V�l�ی��{�݁j �������ꍇ
		case 15211:
			// �ϐ� servicePanel �� ACPanel"QO004119"�i���V�l�ی��{�݁j�𐶐�����B
			return new QO004119();
		// �l�� 15311�i���×{�^��Î{��(�×{�^�a�@)�j �������ꍇ
		case 15311:
			// �ϐ� servicePanel �� ACPanel"QO004120"�i���×{�^��Î{��(�×{�^�a�@)�j�𐶐�����B
			return new QO004120();
		// �l�� 15312�i���×{�^��Î{��(�f�Ï��^)�j �������ꍇ
		case 15312:
			// �ϐ� servicePanel �� ACPanel"QO004121"�i���×{�^��Î{��(�f�Ï��^)�j�𐶐�����B
			return new QO004121();
		// �l�� 15313�i���×{�^��Î{��(���×{�^��Î{��(�F�m�ǎ����^)�j �������ꍇ
		case 15313:
			// �ϐ� servicePanel �� ACPanel"QO004122"�i���×{�^��Î{��(�F�m�ǎ����^)�j�𐶐�����B
			return new QO004122();
		// �l�� 17111�i��ԑΉ��^�K����j �������ꍇ
		case 17111:
			// �ϐ� servicePanel �� ACPanel"QO004123"�i��ԑΉ��^�K����j�𐶐�����B
			return new QO004123();
		// �l�� 17211�i�F�m�ǑΉ��^�ʏ����j �������ꍇ
		case 17211:
			// �ϐ� servicePanel �� ACPanel"QO004124"�i�F�m�ǑΉ��^�ʏ����j�𐶐�����B
			return new QO004124();
		// �l�� 17311�i���K�͑��@�\�^������j �������ꍇ
		case 17311:
			// �ϐ� servicePanel �� ACPanel"QO004125"�i���K�͑��@�\�^������j�𐶐�����B
			return new QO004125();
		// �l�� 13211�i�F�m�ǑΉ��^�����������i�Z�����p�ȊO�j�j �������ꍇ
		case 13211:
			// �ϐ� servicePanel �� ACPanel"QO004126"�i�F�m�ǑΉ��^�����������i�Z�����p�ȊO�j�j�𐶐�����B
			return new QO004126();
		// �l�� 13811�i�F�m�ǑΉ��^�����������i�Z�����p�j�j �������ꍇ
		case 13811:
			// �ϐ� servicePanel �� ACPanel"QO004127"�i�F�m�ǑΉ��^�����������i�Z�����p�j�j�𐶐�����B
			return new QO004127();
		// �l�� 13611�i�n�斧���^����{�ݓ����Ґ������j �������ꍇ
		case 13611:
			// �ϐ� servicePanel �� ACPanel"QO004128"�i�n�斧���^����{�ݓ����Ґ������j�𐶐�����B
			return new QO004128();
		// �l�� 15411�i�n�斧���^���V�l�����{�݁j �������ꍇ
		case 15411:
			// �ϐ� servicePanel �� ACPanel"QO004129"�i�n�斧���^���V�l�����{�݁j�𐶐�����B
			return new QO004129();

		// �l�� 16111 ( ���\�h�K���� ) �������ꍇ
		case 16111:
			// �ϐ� servicePanel��ACPanel" QO004130 " ( ���\�h�K���� )�𐶐�����B 16111
			return new QO004130();

		// �l�� 16211 ( ���\�h�K�������� ) �������ꍇ
		case 16211:
			// �ϐ� servicePanel��ACPanel" QO004131 " ( ���\�h�K�������� )�𐶐�����B 16211
			return new QO004131();

		// �l�� 16311 ( ���\�h�K��Ō� ) �������ꍇ
		case 16311:
			// �ϐ� servicePanel��ACPanel" QO004132 " ( ���\�h�K��Ō� )�𐶐�����B 16311
			return new QO004132();

		// �l�� 16411 ( ���\�h�K�⃊�n�r���e�[�V���� ) �������ꍇ
		case 16411:
			// �ϐ� servicePanel��ACPanel" QO004133 " ( ���\�h�K�⃊�n�r���e�[�V���� )�𐶐�����B
			// 16411
			return new QO004133();

		// �l�� 13411 ( ���\�h����×{�Ǘ��w�� ) �������ꍇ
		case 13411:
			// �ϐ� servicePanel��ACPanel" QO004134 " ( ���\�h����×{�Ǘ��w�� )�𐶐�����B 13411
			return new QO004134();

		// �l�� 16511 ( ���\�h�ʏ���� ) �������ꍇ
		case 16511:
			// �ϐ� servicePanel��ACPanel" QO004135 " ( ���\�h�ʏ���� )�𐶐�����B 16511
			return new QO004135();

		// �l�� 16611 ( ���\�h�ʏ����n�r���e�[�V���� ) �������ꍇ
		case 16611:
			// �ϐ� servicePanel��ACPanel" QO004136 " ( ���\�h�ʏ����n�r���e�[�V���� )�𐶐�����B
			// 16611
			return new QO004136();

		// �l�� 12411 ( ���\�h�Z������������� ) �������ꍇ
		case 12411:
			// �ϐ� servicePanel��ACPanel" QO004137 " ( ���\�h�Z������������� )�𐶐�����B 12411
			return new QO004137();

		// �l�� 12511 ( ���\�h�Z�������×{���(�V��) ) �������ꍇ
		case 12511:
			// �ϐ� servicePanel��ACPanel" QO004138 " ( ���\�h�Z�������×{���(�V��) )�𐶐�����B
			// 12511
			return new QO004138();

		// �l�� 12611 ( ���\�h�Z�������×{���(�×{�a����L����a�@) ) �������ꍇ
		case 12611:
			// �ϐ� servicePanel��ACPanel" QO004139 " ( ���\�h�Z�������×{���(�×{�a����L����a�@)
			// )�𐶐�����B 12611
			return new QO004139();

		// �l�� 12612 ( ���\�h�Z�������×{���(�×{�a����L����f�Ï�) ) �������ꍇ
		case 12612:
			// �ϐ� servicePanel��ACPanel" QO004140 " ( ���\�h�Z�������×{���(�×{�a����L����f�Ï�)
			// )�𐶐�����B 12612
			return new QO004140();

		// �l�� 12613 ( ���\�h�Z�������×{���(�V�l���F�m�ǎ����×{�a����L����a�@) ) �������ꍇ
		case 12613:
			// �ϐ� servicePanel��ACPanel" QO004141 " (
			// ���\�h�Z�������×{���(�V�l���F�m�ǎ����×{�a����L����a�@) )�𐶐�����B 12613
			return new QO004141();

		// �l�� 12614 ( ���\�h�Z�������×{���(��K���f�Ï�) ) �������ꍇ
		case 12614:
			// �ϐ� servicePanel��ACPanel" QO004142 " ( ���\�h�Z�������×{���(��K���f�Ï�)
			// )�𐶐�����B 12614
			return new QO004142();

		// �l�� 13511 ( ���\�h����{�ݓ����Ґ������ ) �������ꍇ
		case 13511:
			// �ϐ� servicePanel��ACPanel" QO004143 " ( ���\�h����{�ݓ����Ґ������ )�𐶐�����B
			// 13511
			return new QO004143();

		// �l�� 16711 ( ���\�h�����p��ݗ^ ) �������ꍇ
		case 16711:
			// �ϐ� servicePanel��ACPanel" QO004144 " ( ���\�h�����p��ݗ^ )�𐶐�����B 16711
			return new QO004144();

		// �l�� 14611 ( ���\�h�x�� ) �������ꍇ
		case 14611:
			// �ϐ� servicePanel��ACPanel" QO004145 " ( ���\�h�x�� )�𐶐�����B 14611
			return new QO004145();

		// �l�� 17411 ( ���\�h�F�m�ǑΉ��^�ʏ���� ) �������ꍇ
		case 17411:
			// �ϐ� servicePanel��ACPanel" QO004146 " ( ���\�h�F�m�ǑΉ��^�ʏ���� )�𐶐�����B
			// 17411
			return new QO004146();

		// �l�� 17511 ( ���\�h���K�͑��@�\�^������ ) �������ꍇ
		case 17511:
			// �ϐ� servicePanel��ACPanel" QO004147 " ( ���\�h���K�͑��@�\�^������ )�𐶐�����B
			// 17511
			return new QO004147();

		// �l�� 13711 ( ���\�h�F�m�ǑΉ��^�����������(�Z�����p�ȊO) ) �������ꍇ
		case 13711:
			// �ϐ� servicePanel��ACPanel" QO004148 " ( ���\�h�F�m�ǑΉ��^�����������(�Z�����p�ȊO)
			// )�𐶐�����B 13711
			return new QO004148();

		// �l�� 13911 ( ���\�h�F�m�ǑΉ��^�����������(�Z�����p) ) �������ꍇ
		case 13911:
			// �ϐ� servicePanel��ACPanel" QO004149 " ( ���\�h�F�m�ǑΉ��^�����������(�Z�����p)
			// )�𐶐�����B 13911
			return new QO004149();

		}
		return null;
	}

	/**
	 * �u�T�[�r�X�ڍ׏��ύX�`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean isModifiedOnService() throws Exception {

		// �񋟃`�F�b�N�̕ύX�`�F�b�N
		boolean oldOffer = ACCastUtilities.toBoolean(VRBindPathParser.get(
				"OFFER", getServiceInfos(getCurrentServiceType())));

		if (getOfferCheck().isSelected()) {
			if (!oldOffer) {
				return true;
			}
			// �񋟃`�F�b�N��ON�̏ꍇ�̂݃p�l���̕ύX�`�F�b�N
			if (getServiceSnapshot().isModified()) {
				return true;
			}
		} else {
			if (oldOffer) {
				return true;
			}
		}

		// �`�F�b�N�A�p�l�����ɕύX���Ȃ��ꍇ
		return false;

	}

	/**
	 * �u�N���A�����v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void allClear() throws Exception {
		// ��ʃN���A����
		// �ϐ��A�t���O�̃N���A
		clearFlags();
		setSelectedProviderId("");
		setPROCESS_MODE(QkanConstants.PROCESS_MODE_INSERT);
		setSTAFF_PROCESS_MODE(QkanConstants.PROCESS_MODE_INSERT);
		setProviderList(new VRArrayList());
		setProviderServiceList(new VRArrayList());
		setProviderStaffList(new VRArrayList());

		// providerContents��createSource�������s���A�߂�l��providerMap�Ɋi�[����B
		// ��ʂɃ\�[�X�Ƃ���(providerMap)���Z�b�g����B
		VRMap map = (VRMap) getProviderContents().createSource();
		getProviderContents().setSource(map);
		getProviderContents().bindSource();

		// ��ʂɓW�J����B
		getProviderContents().bindSource();

		// �e�[�u���̃N���A
		// �񋟃T�[�r�X�e�[�u��
		doCreateServiceTableData();
		getProviderServiceTableModel().setAdaptee(getProviderServiceList());

		// ��s��(�K����)�I��
		getServiceKindTable().setSelectedSortedFirstRow();

		// �X�^�b�t�e�[�u��
		getProviderStaffTableModel().setAdaptee(getProviderStaffList());

		// ��ʏ�ԏ�����
		setState_INIT_STATE();

		// �t�H�[�J�X
		getProviderId().requestFocus();

		// �X�i�b�v�V���b�g�i�S�́j���B�e����B
		getSnapshot().snapshot();
		// �X�i�b�v�V���b�g�i�T�[�r�X�p�l���p�j���B�e����B
		getServiceSnapshot().snapshot();
		// �X�i�b�v�V���b�g�i�S���җp�j���B�e����B
		getStaffSnapshot().snapshot();

	}

	/**
	 * �u�T�[�r�X�̈��Ԑݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void setStateServiceInfos() throws Exception {

		if (getProviderServiceClass() == null) {
			return;
		}

		// offerCheck�i�񋟃`�F�b�N�{�b�N�X�j�̒l���`�F�b�N����B
		switch (getOfferCheck().getValue()) {
		case 0:
			// �l�� false�i�񋟂��Ă��Ȃ��j�������ꍇ
			// �T�[�r�X�p�l����ҏW�s�ɂ���B�T�[�r�X�p�l����Enable��false �ɐݒ肷��B
			getProviderServiceClass().stateManager(false);
			break;
		case 1:
			// �l��true�i�񋟂��Ă���j�������ꍇ
			// �T�[�r�X�p�l����ҏW�\�ɂ���B�T�[�r�X�p�l����Enable��true �ɐݒ肷��B
			getProviderServiceClass().stateManager(true);
			break;
		}
	}

	/**
	 * �u���R�[�h���o�����v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 * @return VRMap
	 */
	public VRMap getFirstRecord(VRList list) throws Exception {
		// �n���ꂽ���R�[�h�W���̍ŏ��̃��R�[�h�𒊏o���A�߂�l�Ƃ��ĕԂ������B

		// �߂�l
		VRMap map = new VRHashMap();

		// �ŏ��̃��R�[�h���o
		if (!(list == null || list.size() == 0)) {
			map = (VRMap) list.get(0);
		}

		// �߂�l��Ԃ�
		return map;

	}

	/**
	 * �u�T�[�r�X�ڍ׏�񔽉f�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean reflect() throws Exception {
		// �T�[�r�X�ڍ׏����擾���A�e�[�u���ɔ��f���鏈��

		// �Ώۃ��R�[�h�̎擾
		VRMap map = getServiceInfos(getCurrentServiceType());

		// �񋟃`�F�b�N�{�b�N�X�̒l���`�F�b�N����B
		// 0=�񋟂��Ă��Ȃ�
		// 1=�񋟂��Ă���
		if (getOfferCheck().getValue() == 0) {
			// �T�[�r�X��񋟂��Ă��Ȃ������ꍇ
			// �폜�\�ȃT�[�r�X�����ʂ���
			if (!doCheckDeleteService()) {
				return false;
			} else {
				// �폜�\�������ꍇ
				// �Ώۃ��R�[�h�̒񋟃J�����̒l��false�ɂ���B
				VRBindPathParser.set("OFFER", map, new Boolean(false));
			}

		} else {

			// �T�[�r�X��񋟂��Ă����ꍇ
			// ���̓`�F�b�N���s���B
			if (getProviderServiceClass() != null) {
				if (!getProviderServiceClass().isValidInput()) {
					return false;
				}
			}

			// // ������
			// map.putAll((VRMap)getProviderDetailServiceDetails().createSource());
			// ��ʏ�̃T�[�r�X�ڍ׏����擾����B
			getProviderServiceClass().getDetails(map);

			// �񋟃T�[�r�X�e�[�u���Ō��ݑI������Ă��郌�R�[�h�̒񋟃J�����̒l��true�ɂ���B
			VRBindPathParser.set("OFFER", map, new Boolean(true));

		}

		// �ĕ`��
		getServiceKindTable().repaint();
		getServiceKindTable().revalidate();

		// �ύX�t���O��1�ɐݒ肷��B
		setProviderServiceTableChangeFlag(1);

		// �T�[�r�X�p�l���p�X�i�b�v�V���b�g���B�e����B
		getServiceSnapshot().snapshot();

		return true;

	}

	/**
	 * �u�t���O�̏������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void clearFlags() throws Exception {

		// �t���O�̏�����
		// providerServiceTableChangeFlag
		setProviderServiceTableChangeFlag(0);
		// providerStaffTableChangeFlag
		setProviderStaffTableChangeFlag(0);
		// serviceDataExistenceFlag
		setServiceDataExistenceFlag(0);
		// staffDataExistenceFlag
		setStaffDataExistenceFlag(0);
		// compulsoryBackFlag
		setCompulsoryBackFlag(0);
	}

	/**
	 * �uKEY���w�肵�ăT�[�r�X�����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public VRMap getServiceInfos(int systemServiceKindDetail) throws Exception {

		// �V�X�e���T�[�r�X��ރR�[�h���w�肵�ăT�[�r�X�����擾����B
		VRMap map = ACBindUtilities.getMatchRowFromValue(
				getProviderServiceList(), "SYSTEM_SERVICE_KIND_DETAIL",
				new Integer(systemServiceKindDetail));

		return map;

	}

	public Component getFirstFocusComponent() {
		if (getPROCESS_MODE() == QkanConstants.PROCESS_MODE_INSERT) {
			return getProviderId();
		} else {
			return getProviderName();
		}
	}
}
