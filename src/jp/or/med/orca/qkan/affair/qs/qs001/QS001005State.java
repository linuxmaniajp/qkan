
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
 * �쐬��: 2006/01/26  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[���K��Ō�(���) (QS001005)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * �T�[�r�X�p�^�[���K��Ō�(���)��Ԓ�`(QS001005) 
 */
public class QS001005State extends QS001005Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001005State(){
  }

  /**
   * �u���w�Ö@�m���͍�ƗÖ@�m�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_VALID_HOMON_KANGO_PTOT() throws Exception {

        getHoumonKangoKaigoClass3().setEnabled(true);

  }

  /**
   * �u���w�Ö@�m���͍�ƗÖ@�m�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_INVALID_HOMON_KANGO_PTOT() throws Exception {

        getHoumonKangoKaigoClass3().setEnabled(false);

  }

  /**
   * �u�ً}���K��Ō���Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_VALID_URGENT_TIME_RADIO() throws Exception {

        getHoumonKangoKaigoUrgentTimeRadio().setEnabled(true);

  }

  /**
   * �u�ً}���K��Ō���Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_INVALID_URGENT_TIME_RADIO() throws Exception {

        getHoumonKangoKaigoUrgentTimeRadio().setEnabled(false);

  }

  /**
   * �u���ʊǗ��̐��E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_VALID_SPECIAL_MANAGE_RADIO() throws Exception {

        getHoumonKangoKaigoSpecialManageRadio().setEnabled(true);

  }

  /**
   * �u���ʊǗ��̐��E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_INVALID_SPECIAL_MANAGE_RADIO() throws Exception {

        getHoumonKangoKaigoSpecialManageRadio().setEnabled(false);

  }

}
