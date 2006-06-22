
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
 * �쐬��: 2006/01/13  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�p�^�[���ʏ���� (001)
 * �v���O���� �T�[�r�X�p�^�[���ʏ���� (QS001008)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * �T�[�r�X�p�^�[���ʏ�����Ԓ�`(QS001008) 
 */
public class QS001008State extends QS001008Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001008State(){
  }

  /**
   * �u�@�\�P���E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_VALID_FUNCTION_TRAINING() throws Exception {

        getTsuusyoKaigoAdditionFunctionTrainingRadio().setEnabled(true);

  }

  /**
   * �u�@�\�P���E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_INVALID_FUNCTION_TRAINING() throws Exception {

        getTsuusyoKaigoAdditionFunctionTrainingRadio().setEnabled(false);

  }

  /**
   * �u���}���Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_VALID_MEETING_AND_SENDING_OFF() throws Exception {

        getTsuusyoKaigoMeetingAndSendingOff().setEnabled(true);

  }

  /**
   * �u���}���Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_INVALID_MEETING_AND_SENDING_OFF() throws Exception {

        getTsuusyoKaigoMeetingAndSendingOff().setEnabled(false);

  }

  /**
   * �u�������Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_VALID_ADD_BATH() throws Exception {

        getTsuusyoKaigoAdditionFunctionBathRadioItem2().setEnabled(true);

  }

  /**
   * �u�������Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_INVALID_ADD_BATH() throws Exception {

        getTsuusyoKaigoAdditionFunctionBathRadioItem2().setEnabled(false);

  }

  /**
   * �u���ʓ������Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_VALID_ADD_SPECIAL_BATH() throws Exception {

        getTsuusyoKaigoAdditionFunctionBathRadioItem3().setEnabled(true);

  }

  /**
   * �u���ʓ������Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_INVALID_ADD_SPECIAL_BATH() throws Exception {

        getTsuusyoKaigoAdditionFunctionBathRadioItem3().setEnabled(false);

  }

}
