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
 * �v���O���� ���\�h�F�m�ǑΉ��^�ʏ���� (QO004146)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACCalendar;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * ���\�h�F�m�ǑΉ��^�ʏ����(QO004146)
 */
public class QO004146 extends QO004146Event {
	/**
	 * �R���X�g���N�^�ł��B
	 */
	public QO004146() {
	}

	// �R���|�[�l���g�C�x���g

	public static void main(String[] args) {
		// �f�t�H���g�f�o�b�O�N��
		ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		// param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
		ACFrame.debugStart(new ACAffairInfo(QO004146.class.getName(), param));
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
		// �������e�L�X�g�ɏ����l0��������B
		getReduceRate().setText("0");
		// ���W�I�̒l������������
		QkanCommon.selectFirstRadioItem(getThis());
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
		if (!getFacilitiesDivision().isSelected()) {
			// �EfacilitiesDivision�i�{�݋敪���W�I�O���[�v�j�� errMsg = �{�݋敪
			errMsg = "�{�݋敪";
			// ���I���������ꍇ
			// �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_NEED_CHECK_FOR_SELECT ���� = errMsg
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
			// �G���[�����������C���X�^���X�Ƀt�H�[�J�X�𓖂Ă�B
			getFacilitiesDivision().requestFocus();
			// �����𔲂���B�i���f����j
			return false;
		}

		// �EstaffLack�i�l�����Z���W�I�O���[�v�j�� errMsg = �l�����Z
		if (!getStaffLack().isSelected()) {
			errMsg = "�l�����Z";
			// ���I���������ꍇ
			// �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_NEED_CHECK_FOR_SELECT ���� = errMsg
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
			// �G���[�����������C���X�^���X�Ƀt�H�[�J�X�𓖂Ă�B
			getStaffLack().requestFocus();
			// �����𔲂���B�i���f����j
			return false;
		}

		// �EExtendTime�i���ԉ����T�[�r�X�̐����W�I�O���[�v�j�� errMsg = ���ԉ����T�[�r�X�̐�
		if (!getExtendTime().isSelected()) {
			errMsg = "���ԉ����T�[�r�X�̐�";
			// ���I���������ꍇ
			// �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_NEED_CHECK_FOR_SELECT ���� = errMsg
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
			// �G���[�����������C���X�^���X�Ƀt�H�[�J�X�𓖂Ă�B
			getExtendTime().requestFocus();
			// �����𔲂���B�i���f����j
			return false;
		}

		// �EfunctionTrainingGuidanceSystem�i�ʋ@�\�P���w���̐����W�I�O���[�v�j
		// ��errMsg = �ʋ@�\�P���w���̐�
		if (!getFunctionTrainingGuidanceSystem().isSelected()) {
			errMsg = "�ʋ@�\�P���w���̐�";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
			getFunctionTrainingGuidanceSystem().requestFocus();
			return false;
		}

		// �EbathingHelpSystem�i������̐����W�I�O���[�v�j
		// ��errMsg = ������̐�
		if (!getBathingHelpSystem().isSelected()) {
			errMsg = "������̐�";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
			getBathingHelpSystem().requestFocus();
			return false;
		}

		// �EnourishmentManagement�i�h�{���P�̐����W�I�O���[�v�j�� errMsg = �h�{���P�̐�
		if (!getNourishmentImprovement().isSelected()) {
			errMsg = "�h�{���P�̐�";
			// ���I���������ꍇ
			// �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_NEED_CHECK_FOR_SELECT ���� = errMsg
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
			// �G���[�����������C���X�^���X�Ƀt�H�[�J�X�𓖂Ă�B
			getNourishmentImprovement().requestFocus();
			// �����𔲂���B�i���f����j
			return false;
		}

		// �EmouthImprovement�i���o�@�\����̐����W�I�O���[�v�j�� errMsg = ���o�@�\����̐�
		if (!getMouthImprovement().isSelected()) {
			errMsg = "���o�@�\����̐�";
			// ���I���������ꍇ
			// �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_NEED_CHECK_FOR_SELECT ���� = errMsg
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
			// �G���[�����������C���X�^���X�Ƀt�H�[�J�X�𓖂Ă�B
			getMouthImprovement().requestFocus();
			// �����𔲂���B�i���f����j
			return false;
		}

		// ���L�̃e�L�X�g�t�B�[���h�ɑ΂��ē��̓`�F�b�N���s���B�����͂������ꍇ�� errMsg �Ƀ��b�Z�[�W���i�[����B
		if (ACTextUtilities.isNullText(getReduceRate())) {
			errMsg = "������";
			// �EreduceRate�i�������e�L�X�g�j�� errMsg = ������
			// ���͂���Ă��Ȃ������ꍇ
			// �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_NEED_CHECK_FOR_INPUT ���� = errMsg
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
			// �G���[�����������C���X�^���X�Ƀt�H�[�J�X�𓖂Ă�B
			getReduceRate().requestFocus();
			// �����𔲂���B�i���f����j
			return false;
		}

		// �������̒l���`�F�b�N����B
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
		// ���ID�FSET_PANEL_TRUE
		if (state) {
			setState_SET_PANEL_TRUE();
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

		// �f�o�b�O�p�o��
//		System.out.println(map);

	}
}
