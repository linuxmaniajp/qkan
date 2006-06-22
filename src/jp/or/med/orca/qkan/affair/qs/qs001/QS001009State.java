
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
 * �쐬��: 2006/01/24  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�p�^�[���ʏ����n (001)
 * �v���O���� �T�[�r�X�p�^�[���ʏ����n (QS001009)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * �T�[�r�X�p�^�[���ʏ����n��Ԓ�`(QS001009) 
 */
public class QS001009State extends QS001009Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001009State(){
  }

  /**
   * �u�������Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_VALID_ADD_BATH() throws Exception {

        getHoumonRehabilitationBathRadioItem2().setEnabled(true);

  }

  /**
   * �u�������Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_INVALID_ADD_BATH() throws Exception {

        getHoumonRehabilitationBathRadioItem2().setEnabled(false);

  }

  /**
   * �u���ʓ������Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_VALID_ADD_SPECIAL_BATH() throws Exception {

        getHoumonRehabilitationBathRadioItem3().setEnabled(true);

  }

  /**
   * �u���ʓ������Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_INVALID_ADD_SPECIAL_BATH() throws Exception {

        getHoumonRehabilitationBathRadioItem3().setEnabled(false);

  }

  /**
   * �u���n�r���K��w�����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_VALID_ADD_REHA_TREATMENT() throws Exception {

        getHoumonRehabilitationAdditionTreatmentPersonRadio().setEnabled(true);

  }

  /**
   * �u���n�r���K��w�����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_INVALID_ADD_REHA_TREATMENT() throws Exception {

        getHoumonRehabilitationAdditionTreatmentPersonRadio().setEnabled(false);

  }

}
