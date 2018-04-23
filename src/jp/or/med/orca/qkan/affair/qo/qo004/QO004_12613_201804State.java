
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
 * �쐬��: 2009/03/04  ���{�R���s���[�^�[������� �A�� ��C �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ə��o�^ (004)
 * �v���O���� ���\�h�Z�������×{���i�F�m�ǎ����^�j (QO004141)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;
/**
 * ���\�h�Z�������×{���i�F�m�ǎ����^�j��Ԓ�`(QO004141) 
 */
@SuppressWarnings("serial")
public class QO004_12613_201804State extends QO004_12613_201804Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004_12613_201804State(){
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
  public void setState_FACILITY_TYPE_UNIT() throws Exception {

        getUnitCareMaintenance().setEnabled(true);
        getUnitCareMaintenance().getParent().setEnabled(true);

        getStaffAssignmentDivision().setEnabled(true);
        getStaffAssignmentDivision().getParent().setEnabled(true);

        getStaffAssignmentDivisionItem1().setEnabled(true);
        getStaffAssignmentDivisionItem2().setEnabled(true);
        getStaffAssignmentDivisionItem3().setEnabled(false);
        getStaffAssignmentDivisionItem4().setEnabled(false);
        getStaffAssignmentDivisionItem5().setEnabled(false);

  }

  /**
   * �u�m�[�}���^�C�v�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_NORMAL() throws Exception {

        getUnitCareMaintenance().setEnabled(false);
        getUnitCareMaintenance().getParent().setEnabled(false);

        getStaffAssignmentDivision().setEnabled(true);
        getStaffAssignmentDivision().getParent().setEnabled(true);

        getStaffAssignmentDivisionItem1().setEnabled(true);
        getStaffAssignmentDivisionItem2().setEnabled(true);
        getStaffAssignmentDivisionItem3().setEnabled(true);
        getStaffAssignmentDivisionItem4().setEnabled(true);
        getStaffAssignmentDivisionItem5().setEnabled(true);

  }

  /**
   * �u�o�ߌ^�^�C�v�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_PASSAGE() throws Exception {

        getUnitCareMaintenance().setEnabled(false);
        getUnitCareMaintenance().getParent().setEnabled(false);

        getStaffAssignmentDivision().setEnabled(false);
        getStaffAssignmentDivision().getParent().setEnabled(false);

  }

}
