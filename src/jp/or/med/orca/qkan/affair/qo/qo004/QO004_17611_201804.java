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
 * �J����: �����F
 * �쐬��: 2011/12/08  ���{�R���s���[�^�[������� �����F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ə��o�^ (004)
 * �v���O���� �������E�����Ή��^�K����Ō� (QO004_17611_201804)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �������E�����Ή��^�K����Ō�(QO004_17611_201804)
 */
public class QO004_17611_201804 extends QO004_17611_201804Event {
	/**
	 * �R���X�g���N�^�ł��B
	 */
	public QO004_17611_201804() {
	}

	// �R���|�[�l���g�C�x���g

	public static void main(String[] args) {
		// �f�t�H���g�f�o�b�O�N��
		ACFrame.getInstance().setFrameEventProcesser(
				new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		// param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
		ACFrame.debugStart(new ACAffairInfo(QO004_17611_201804.class.getName(),
				param));
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
		
		// �������e�L�X�g�ɏ����l0��������B
        getReduceRate().setText("0");
		// ���W�I�̏����l��ݒ肷��B
        QkanCommon.selectFirstRadioItem(getMainGroup());

	}

	/**
	 * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean isValidInput() throws Exception {
		// �����̓`�F�b�N
		// �G���[���b�Z�[�W�����i�[�p�� errMsg���쐬����B
		String errMsg = null;

        // ���L�̃e�L�X�g�t�B�[���h�ɑ΂��ē��̓`�F�b�N���s���B�����͂������ꍇ�� errMsg �Ƀ��b�Z�[�W���i�[����B
        // �EreduceRate�i�������e�L�X�g�j�� errMsg = ������
        if (ACTextUtilities.isNullText(getReduceRate().getText())) {
            errMsg = "������";
            QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
            getReduceRate().requestFocus();
            return false;
        }

        // �������̒l���`�F�b�N����B
        int reduceRate = ACCastUtilities.toInt(getReduceRate().getText());
        if (reduceRate > 100) {
            // 100�𒴂���l�����͂���Ă����ꍇ
            QkanMessageList.getInstance().QO004_ERROR_OF_REDUCT_RATE();
            // �G���[�����������C���X�^���X�Ƀt�H�[�J�X�𓖂Ă�B
            getReduceRate().requestFocus();
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
        if (state) {
            // �����Ƃ���true���n���ꂽ�ꍇ
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
        // �p�l���f�[�^�擾

        getMainGroup().setSource(map);
        getMainGroup().applySource();

	}

}
