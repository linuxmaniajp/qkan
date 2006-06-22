
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
 * �쐬��: 2006/02/01  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�ԕ\ (QS001001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * �T�ԕ\��Ԓ�`(QS001001) 
 */
public class QS001001State extends QS001001Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001001State(){
  }

  /**
   * �u�T�[�r�X�p�^�[���E��ȓ��퐶����̊����E�I���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_EXT_CONTENT_DETAIL_SELECTED() throws Exception {

        getMondayCheck().setVisible(false);

        getTuesdayCheck().setVisible(false);

        getWednesdayCheck().setVisible(false);

        getThursdayCheck().setVisible(false);

        getFridayCheck().setVisible(false);

        getSaturdayCheck().setVisible(false);

        getSundayCheck().setVisible(false);

        getExceptionServiceCombos().setEnabled(false);

        getExceptionBeginCombo().setEnabled(false);

        getExceptionEndCombo().setEnabled(false);

        getExceptionButton().setEnabled(false);

  }

  /**
   * �u�T�[�r�X�p�^�[���E��ȓ��퐶����̊����E���I���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_EXT_CONTENT_DETAIL_UNSELECTED() throws Exception {

        getMondayCheck().setVisible(true);

        getTuesdayCheck().setVisible(true);

        getWednesdayCheck().setVisible(true);

        getThursdayCheck().setVisible(true);

        getFridayCheck().setVisible(true);

        getSaturdayCheck().setVisible(true);

        getSundayCheck().setVisible(true);

        getExceptionServiceCombos().setEnabled(true);

        getExceptionBeginCombo().setEnabled(true);

        getExceptionEndCombo().setEnabled(true);

        getExceptionButton().setEnabled(true);

  }

}
