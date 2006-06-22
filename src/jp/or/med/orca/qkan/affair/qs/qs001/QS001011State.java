
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
 * �T�u�V�X�e�� �T�[�r�X�\�� (S)
 * �v���Z�X �T�[�r�X�p�^�[���Z������������� (001)
 * �v���O���� �T�[�r�X�p�^�[���Z������������� (QS001011)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * �T�[�r�X�p�^�[���Z��������������Ԓ�`(QS001011) 
 */
public class QS001011State extends QS001011Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001011State(){
  }

  /**
   * �u�@�\�P���E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_VALID_FUNCTION_TRAINING() throws Exception {

        getShortStayLifeAdditionFunctionTrainingRadio().setEnabled(true);

  }

  /**
   * �u�@�\�P���E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_INVALID_FUNCTION_TRAINING() throws Exception {

        getShortStayLifeAdditionFunctionTrainingRadio().setEnabled(false);

  }

  /**
   * �u���}���Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_VALID_MEETING_AND_SENDING_OFF() throws Exception {

        getShortStayLifeMeetingAndSendingOff().setEnabled(true);

  }

  /**
   * �u���}���Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_INVALID_MEETING_AND_SENDING_OFF() throws Exception {

        getShortStayLifeMeetingAndSendingOff().setEnabled(false);

  }

  /**
   * �u�h�{�Ǘ��̐����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_VALID_DIETICIAN_MANAGE() throws Exception {

        getShortStayLifeDieticianManageRadio().setEnabled(true);

  }

  /**
   * �u�h�{�Ǘ��̐����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_INVALID_DIETICIAN_MANAGE() throws Exception {

        getShortStayLifeDieticianManageRadio().setEnabled(false);

  }

  /**
   * �u�×{�H���Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_VALID_MEDICAL_EXPENSES() throws Exception {

        getShortStayLifeMedicalExpensesRadio().setEnabled(true);

  }

  /**
   * �u�×{�H���Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_INVALID_MEDICAL_EXPENSES() throws Exception {

        getShortStayLifeMedicalExpensesRadio().setEnabled(false);

  }

  /**
   * �u�]���^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_CONVENTIONAL_FORM() throws Exception {

        getShortStayLifeHospitalRoomDivisionRadio().setEnabled(true);

        getShortStayLifeUnitHospitalRoomDivisionRadio().setEnabled(false);

  }

  /**
   * �u���j�b�g�^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_UNIT_FORM() throws Exception {

        getShortStayLifeHospitalRoomDivisionRadio().setEnabled(false);

        getShortStayLifeUnitHospitalRoomDivisionRadio().setEnabled(true);

  }

  /**
   * �u�H���񋟁E����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_USE_MEAT() throws Exception {

        getShortStayLifeDinnerCost().setEnabled(true);

  }

  /**
   * �u�H���񋟁E�Ȃ��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_NOT_USE_MEAT() throws Exception {

        getShortStayLifeDinnerCost().setEnabled(false);

  }

}
