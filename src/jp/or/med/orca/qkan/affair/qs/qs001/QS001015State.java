
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
 * �J����: �� ����
 * �쐬��: 2006/01/25  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�p�^�[���Z�������×{���i�F�m�ǎ����j (001)
 * �v���O���� �T�[�r�X�p�^�[���Z�������×{���i�F�m�ǎ����j (QS001015)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * �T�[�r�X�p�^�[���Z�������×{���i�F�m�ǎ����j��Ԓ�`(QS001015) 
 */
public class QS001015State extends QS001015Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001015State(){
  }

  /**
   * �u�H���񋟁E����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_USE_MEAT() throws Exception {

        getShortStayDementiaRecuperationDinnerCost().setEnabled(true);

  }

  /**
   * �u�H���񋟁E�Ȃ��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_NOT_USE_MEAT() throws Exception {

        getShortStayDementiaRecuperationDinnerCost().setEnabled(false);

  }

  /**
   * �u�h�{�Ǘ��̐����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_VALID_DIETICIAN_MANAGE() throws Exception {

        getShortStayDementiaRecuperationDieticianManageRadio().setEnabled(true);

  }

  /**
   * �u�h�{�Ǘ��̐����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_INVALID_DIETICIAN_MANAGE() throws Exception {

        getShortStayDementiaRecuperationDieticianManageRadio().setEnabled(false);

  }

  /**
   * �u�×{�H���Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_VALID_MEDICAL_EXPENSES() throws Exception {

        getShortStayDementiaRecuperationMedicalExpensesRadio().setEnabled(true);

  }

  /**
   * �u�×{�H���Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_INVALID_MEDICAL_EXPENSES() throws Exception {

        getShortStayDementiaRecuperationMedicalExpensesRadio().setEnabled(false);

  }

  /**
   * �u�]���^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_CONVENTIONAL_FORM() throws Exception {

        getShortStayDementiaRecuperationHospitalRoomRadio().setEnabled(true);

        getShortStayDementiaRecuperationUnitHospitalRoomRadio().setEnabled(false);

  }

  /**
   * �u���j�b�g�^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_UNIT_FORM() throws Exception {

        getShortStayDementiaRecuperationHospitalRoomRadio().setEnabled(false);

        getShortStayDementiaRecuperationUnitHospitalRoomRadio().setEnabled(true);

  }

}
