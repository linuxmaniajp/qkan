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
 * �J����: ��i�a�P
 * �쐬��: 2011/12/07  ���{�R���s���[�^�[������� ��i�a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ə��o�^ (004)
 * �v���O���� ����{�ݓ����҉��i�Z�����p�j (QO004_12711_201804)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;

import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.io.*;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import jp.nichicom.ac.*;
import jp.nichicom.ac.bind.*;
import jp.nichicom.ac.component.*;
import jp.nichicom.ac.component.dnd.*;
import jp.nichicom.ac.component.dnd.event.*;
import jp.nichicom.ac.component.event.*;
import jp.nichicom.ac.component.mainmenu.*;
import jp.nichicom.ac.component.table.*;
import jp.nichicom.ac.component.table.event.*;
import jp.nichicom.ac.container.*;
import jp.nichicom.ac.core.*;
import jp.nichicom.ac.filechooser.*;
import jp.nichicom.ac.io.*;
import jp.nichicom.ac.lang.*;
import jp.nichicom.ac.pdf.*;
import jp.nichicom.ac.sql.*;
import jp.nichicom.ac.text.*;
import jp.nichicom.ac.util.*;
import jp.nichicom.ac.util.adapter.*;
import jp.nichicom.vr.*;
import jp.nichicom.vr.bind.*;
import jp.nichicom.vr.bind.event.*;
import jp.nichicom.vr.border.*;
import jp.nichicom.vr.component.*;
import jp.nichicom.vr.component.event.*;
import jp.nichicom.vr.component.table.*;
import jp.nichicom.vr.container.*;
import jp.nichicom.vr.focus.*;
import jp.nichicom.vr.image.*;
import jp.nichicom.vr.io.*;
import jp.nichicom.vr.layout.*;
import jp.nichicom.vr.text.*;
import jp.nichicom.vr.text.parsers.*;
import jp.nichicom.vr.util.*;
import jp.nichicom.vr.util.adapter.*;
import jp.nichicom.vr.util.logging.*;
import jp.or.med.orca.qkan.*;
import jp.or.med.orca.qkan.affair.*;
import jp.or.med.orca.qkan.component.*;
import jp.or.med.orca.qkan.text.*;
import jp.nichicom.ac.lib.care.claim.print.schedule.*;

/**
 * ����{�ݓ����҉��i�Z�����p�j(QO004_12711_201804)
 */
public class QO004_12711_201804 extends QO004_12711_201804Event {
	/**
	 * �R���X�g���N�^�ł��B
	 */
	public QO004_12711_201804() {
	}

	// �R���|�[�l���g�C�x���g

	public static void main(String[] args) {
		// �f�t�H���g�f�o�b�O�N��
		ACFrame.getInstance().setFrameEventProcesser(
				new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		// param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
		ACFrame.debugStart(new ACAffairInfo(QO004_12711_201804.class.getName(),
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
		// �������l�ݒ�
		// �������e�L�X�g�ɏ����l0��������B
		getReduceRate().setText("0");
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
        // �G���[���b�Z�[�W�����i�[�p�� errMsg�@���쐬����B
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
            // ���ID�FSET_PANEL_TRUE
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

        // ������Ԃ̃R���g���[���̃f�[�^���폜����B
        removeInvalidData(map);
	}

	/**
	 * �u�����f�[�^�폜�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void removeInvalidData(VRMap map) throws Exception {
		// �����f�[�^�폜

        QkanCommon.removeDisabledBindPath(getMainGroup(), map);

	}

}
