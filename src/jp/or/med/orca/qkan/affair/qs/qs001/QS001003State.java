
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
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[���K���� (QS001003)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * �T�[�r�X�p�^�[���K�����Ԓ�`(QS001003) 
 */
public class QS001003State extends QS001003Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001003State(){
  }

  /**
   * �u�g�̉��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_SHINTAI_KAIGO() throws Exception {

        getHomonkaigoTeikyoTime().setEnabled(true);

        getHoumonKaigoInTime().setEnabled(false);

        getHoumonKaigoNumberOfPeople().setEnabled(true);

  }

  /**
   * �u���������v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_SEIKATSU_ENJO() throws Exception {

        getHomonkaigoTeikyoTime().setEnabled(true);

        getHoumonKaigoInTime().setEnabled(false);

        getHoumonKaigoNumberOfPeople().setEnabled(true);

  }

  /**
   * �u�g�̐����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_SHINTAI_SEIKATSU() throws Exception {

        getHomonkaigoTeikyoTime().setEnabled(true);

        getHoumonKaigoInTime().setEnabled(true);

        getHoumonKaigoNumberOfPeople().setEnabled(true);

  }

  /**
   * �u�ʉ@����~��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_JOKOKAIJO() throws Exception {

        getHomonkaigoTeikyoTime().setEnabled(false);

        getHoumonKaigoInTime().setEnabled(false);

        getHoumonKaigoNumberOfPeople().setEnabled(false);

  }

}
