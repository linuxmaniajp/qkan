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
 * �J����: �A�� ��C
 * �쐬��: 2006/05/02  ���{�R���s���[�^�[������� �A�� ��C �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ə��o�^ (004)
 * �v���O���� ���\�h�Z������������� (QO004137)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;

import java.awt.event.FocusEvent;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * ���\�h�Z�������������(QO004137)
 */
public class QO004137 extends QO004137Event {
	/**
	 * �R���X�g���N�^�ł��B
	 */
	public QO004137() {
	}

	// �R���|�[�l���g�C�x���g

	/**
	 * �u��ʏ�Ԑݒ�v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void facilitiesDivisionSelectionChanged(ListSelectionEvent e) throws Exception {
		// ��ʏ�Ԑݒ�
		// �{�݋敪�́u�P�ƌ^�v�A�u���݌^�v���I������Ă���ꍇ
		if ((getFacilitiesDivision().getSelectedIndex() == FACILITY_TYPE_NORMAL_TANDOKU) || (getFacilitiesDivision().getSelectedIndex() == FACILITY_TYPE_NORMAL_HEISETSU)) {
			setState_FACILITY_TYPE_NORMAL();
			// ���ID�FFACILITY_TYPE_NORMAL
		} else {
			// �{�݋敪�́u�P�ƌ^�v�A�u���݌^�v�ȊO���I������Ă���ꍇ
			setState_FACILITY_TYPE_UNIT();
			// ���ID�FFACILITY_TYPE_UNIT
		}
        // [ID:0000471][Masahiko Higuchi] 2009/04 add begin �󏰌^�Ή�
        setState();
        // [ID:0000471][Masahiko Higuchi] 2009/04 add end
	}

	public static void main(String[] args) {
		// �f�t�H���g�f�o�b�O�N��
		ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		// param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
		ACFrame.debugStart(new ACAffairInfo(QO004137.class.getName(), param));
	}

	// �����֐�

	/**
	 * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void initialize() throws Exception {
		// ��������
		// �������l�ݒ�
		// �������e�L�X�g�ɏ����l0��\������B
		getReduceRate().setText("0");
		// ���W�I�̒l������������
		QkanCommon.selectFirstRadioItem(getThis());

		// �H��E���Z��̎擾�ƕ\��
		VRMap param = new VRHashMap();
		VRBindPathParser.set("SYSTEM_DATE", param, QkanSystemInformation.getInstance().getSystemDate());
		String strSql = getSQL_GET_RESIDENCE_FOOD(param);
		VRList residenceFood = getDBManager().executeQuery(strSql);

		if (residenceFood != null) {
			for (int i = 0; i < residenceFood.size(); i++) {
				VRMap temp = (VRMap) residenceFood.get(i);
				int id = ACCastUtilities.toInt(VRBindPathParser.get("RESIDENCE_FOOD_COST_ID", temp));
				String cost = ACCastUtilities.toString(VRBindPathParser.get("RESIDENCE_FOOD_COST", temp));

				switch (id) {
					// �H��
					case 1:
						getDinnerTotal().setText(cost);
						break;
					// ���j�b�g��
					case 2:
						getUnitRoom().setText(cost);
						break;
					// ���j�b�g����
					case 3:
						getUnitSemiRoom().setText(cost);
						break;
					// �]���^��
					// [ID:0000644][Shin Fujihara] 2011/04/21 edit begin
					// ���z�����l�̕�����
					//case 5:
					case 4:
					// [ID:0000644][Shin Fujihara] 2011/04/21 edit end
						getNormalRoom().setText(cost);
						break;
					// ������
					case 6:
						getTasyouRoom().setText(cost);
						break;
				}

			}
		}

	}

	/**
	 * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean isValidInput() throws Exception {
		// �����̓`�F�b�N
		// �G���[���b�Z�[�W�����i�[�p�� errMsg ���쐬����B
		String errMsg = null;
		// ���L�̃��W�I�O���[�v�ɑ΂��đI���`�F�b�N���s���B���I���������ꍇ�� errMsg �Ƀ��b�Z�[�W���i�[����B
		// �EfacilitiesDivision�i�{�݋敪���W�I�O���[�v�j�� errMsg = �{�݋敪
		if (!getFacilitiesDivision().isSelected()) {
			errMsg = "�{�݋敪";
			// ���I���������ꍇ
			// �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_NEED_CHECK_FOR_SELECT ���� = errMsg
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
			// �G���[�����������C���X�^���X�Ƀt�H�[�J�X�𓖂Ă�B
			getFacilitiesDivision().requestFocus();
			// �����𔲂���B�i���f����j
			return false;
		}

		// �EnightWorkDivision�i��ԋΖ���������W�I�O���[�v�j�� errMsg = ��ԋΖ������
		if (!getNightWorkDivision().isSelected()) {
			errMsg = "��ԋΖ������";
			// ���I���������ꍇ
			// �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_NEED_CHECK_FOR_SELECT ���� = errMsg
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
			// �G���[�����������C���X�^���X�Ƀt�H�[�J�X�𓖂Ă�B
			getNightWorkDivision().requestFocus();
			// �����𔲂���B�i���f����j
			return false;

		}

		// �EfunctionTrainingGuidanceSystem�i�ʋ@�\�P���w���̐����W�I�O���[�v�j�� errMsg = �ʋ@�\�P���w���̐�
		if (!getFunctionTrainingGuidanceSystem().isSelected()) {
			errMsg = "�ʋ@�\�P���w���̐�";
			// ���I���������ꍇ
			// �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_NEED_CHECK_FOR_SELECT ���� = errMsg
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
			// �G���[�����������C���X�^���X�Ƀt�H�[�J�X�𓖂Ă�B
			getFunctionTrainingGuidanceSystem().requestFocus();
			// �����𔲂���B�i���f����j
			return false;

		}

		// �EmeetingAndSendingOffSystem�i���}�̐����W�I�O���[�v�j�� errMsg = ���}�̐�
		if (!getMeetingAndSendingOffSystem().isSelected()) {
			errMsg = "���}�̐�";
			// ���I���������ꍇ
			// �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_NEED_CHECK_FOR_SELECT ���� = errMsg
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
			// �G���[�����������C���X�^���X�Ƀt�H�[�J�X�𓖂Ă�B
			getMeetingAndSendingOffSystem().requestFocus();
			// �����𔲂���B�i���f����j
			return false;

		}

		// �EnourishmentControlAdd�i�h�{�Ǘ��̐����W�I�O���[�v�j�� errMsg = �h�{�Ǘ��̐�
		if (!getNourishmentControlAdd().isSelected()) {
			errMsg = "�h�{�Ǘ��̐�";
			// ���I���������ꍇ
			// �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_NEED_CHECK_FOR_SELECT ���� = errMsg
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
			// �G���[�����������C���X�^���X�Ƀt�H�[�J�X�𓖂Ă�B
			getNourishmentControlAdd().requestFocus();
			// �����𔲂���B�i���f����j
			return false;

		}

		// �EunitCareMaintenance�i���j�b�g�P�A�̐������W�I�O���[�v�j�� errMsg = ���j�b�g�P�A�̐��� ��Enabled = true �̏ꍇ�̂�
		if (!getUnitCareMaintenance().isSelected()) {
			errMsg = "���j�b�g�P�A�̐���";
			// ���I���������ꍇ
			// �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_NEED_CHECK_FOR_SELECT ���� = errMsg
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
			// �G���[�����������C���X�^���X�Ƀt�H�[�J�X�𓖂Ă�B
			getUnitCareMaintenance().requestFocus();
			// �����𔲂���B�i���f����j
			return false;

		}
        
        // [ID:0000471][Masahiko Higuchi] 2009/04 add begin �󏰌^�Ή�
        // �T�[�r�X�񋟑̐��������Z
        if (getServiceAddProvisionStructuralRadioGroup().getSelectedIndex() > 1) {
                // �T�[�r�X�񋟑̐��������Z�i�󏰌^�j�łȂ��ȊO���I������Ă���ꍇ
                if (getServiceAddProvisionStructuralKusyoRadioGroup().isEnabled()
                    && getServiceAddProvisionStructuralKusyoRadioGroup()
                            .getSelectedIndex() > 1) {
                    // �G���[���b�Z�[�W
                    if (QkanMessageList.getInstance()
                            .QO004_WARNING_OF_DOUBLE_CHECK("�T�[�r�X�񋟑̐��������Z�i�P�ƌ^�E���݌^�^�󏰌^�j�̗���") == ACMessageBox.RESULT_CANCEL) {
                        return false;
                    }
                }
            }    
        // [ID:0000471][Masahiko Higuchi] 2009/04 add end
        
		// ���L�̃e�L�X�g�t�B�[���h�ɑ΂��ē��̓`�F�b�N���s���B�����͂������ꍇ�� errMsg �Ƀ��b�Z�[�W���i�[����B
		// �������̒l���`�F�b�N����B
		// �EreduceRate�i�������e�L�X�g�j�� errMsg = ������
		if (ACTextUtilities.isNullText(getReduceRate())) {
			errMsg = "������";
			// ���͂���Ă��Ȃ������ꍇ
			// �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_NEED_CHECK_FOR_INPUT ���� = errMsg
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
			// �G���[�����������C���X�^���X�Ƀt�H�[�J�X�𓖂Ă�B
			getReduceRate().requestFocus();
			// �����𔲂���B�i���f����j
			return false;
		}

		// �������̒l��100�𒴂��Ă���ꍇ
		if (ACCastUtilities.toInt(getReduceRate().getText()) > 100) {
			// �G���[���b�Z�[�W��\������B �����b�Z�[�WID=QO004_ERROR_OF_REDUCT_RATE
			QkanMessageList.getInstance().QO004_ERROR_OF_REDUCT_RATE();
			// �G���[�����������C���X�^���X�Ƀt�H�[�J�X�𓖂Ă�B
			getReduceRate().requestFocus();
			// �����𔲂���B�i���f����j
			return false;
		}

		return true;
	}

	/**
	 * �u�p�l����Ԑ���v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void stateManager(boolean state) throws Exception {
		// ���p�l����Ԑ���
		// �����Ƃ���true���n���ꂽ�ꍇ
		if (state) {
			// ���ID�FSET_PANEL_TRUE
			setState_SET_PANEL_TRUE();

			// �{�݋敪�́u�P�ƌ^�v�A�u���݌^�v���I������Ă���ꍇ
			if ((getFacilitiesDivision().getSelectedIndex() == FACILITY_TYPE_NORMAL_TANDOKU) || (getFacilitiesDivision().getSelectedIndex() == FACILITY_TYPE_NORMAL_HEISETSU)) {
				// ���ID�FUNIT_CARE_FALSE
				setState_FACILITY_TYPE_NORMAL();
			} else {
				setState_FACILITY_TYPE_UNIT();
			}
            // [ID:0000471][Masahiko Higuchi] 2009/04 add begin �󏰌^�Ή�
            setState();
            // [ID:0000471][Masahiko Higuchi] 2009/04 add end
		} else {
			// �����Ƃ���false���n���ꂽ�ꍇ
			// ���ID�FSET_PANEL_FALSE
			setState_SET_PANEL_FALSE();
		}
	}

	/**
	 * �u�p�l���f�[�^�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void getDetails(VRMap map) throws Exception {
		// ���p�l���f�[�^�擾
		// ���ƃO���[�v�̃\�[�X�Ƃ���VRMap map��ݒ肷��B
		setSource(map);

		// ��ʏ�̃f�[�^���擾����B
		applySource();

		// ������Ԃ̃R���g���[���̃f�[�^���폜����B
		removeInvalidData(map);

		// �f�o�b�O�p�o��
//		System.out.println(map);

	}

	/**
	 * �u�����f�[�^�폜�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void removeInvalidData(VRMap map) throws Exception {
		// �������f�[�^�폜
		// �ȉ��̃R���g���[����������Ԃ̏ꍇ�A�ȉ���KEY��map���폜����B
		// �EunitCareMaintenance KEY�F1240104
        QkanCommon.removeDisabledBindPath(getMainGroup(), map);

	}

    /**
     * ��ʏ�Ԑ�����s���܂��B
     */
    public void setState() throws Exception {
        // ���T�[�r�X�񋟑̐��������Z(�󏰌^)�̐��䏈��
        switch(getFacilitiesDivision().getSelectedIndex()) {
        case 1: // �P�ƌ^
        case 3: // �P�ƌ^���j�b�g�^
            setState_INVALID_SERVICE_ADD_KUSYO();
            break;
        case 2: // �󏰌^
        case 4: // ���j�b�g�^�󏰌^
            setState_VALID_SERVICE_ADD_KUSYO();
            break;
        }
        
    }

}
