
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
 * �v���O���� ���\�h����{�ݓ����҉�� (QO004143)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;
/**
 * ���\�h����{�ݓ����҉���Ԓ�`(QO004143) 
 */
public class QO004143State extends QO004143Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004143State(){
  }

  /**
   * �u�p�l���S�̗L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SET_PANEL_TRUE() throws Exception {

        getMainGroup().setEnabled(true);

  }

  /**
   * �u�p�l���S�̖����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SET_PANEL_FALSE() throws Exception {

        getMainGroup().setEnabled(false);

  }

  /**
   * �u���j�b�g�^�C�v�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STAFF_ASSIGNMENT_TYPE_OUTSIDE_SERVICE() throws Exception {

        getFunctionTrainingGuidanceSystem().setEnabled(false);
        getFunctionTrainingGuidanceSystem().getParent().setEnabled(false);
        getStaffLack().setEnabled(false);
        getStaffLack().getParent().setEnabled(false);
  }

  /**
   * �u�m�[�}���^�C�v�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STAFF_ASSIGNMENT_TYPE_NORMAL() throws Exception {

        getFunctionTrainingGuidanceSystem().setEnabled(true);
        getFunctionTrainingGuidanceSystem().getParent().setEnabled(true);
        getStaffLack().setEnabled(true);
        getStaffLack().getParent().setEnabled(true);

  }

}
