
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
 * �J����: �c���@����
 * �쐬��: 2006/05/08  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �W�v���׉�� (QS001030)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * �W�v���׉�ʏ�Ԓ�`(QS001030) 
 */
@SuppressWarnings("serial")
public class QS001005State extends QS001005Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001005State(){
  }

  /**
   * �u�\�胂�[�h�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_PROCESS_TYPE_PLAN() throws Exception {

        getDetailsTableColumn4().setVisible(true);

        getDetailsTableColumn5().setVisible(true);

        getOuterTableColumn4().setVisible(true);

        getOuterTableColumn5().setVisible(true);

  }

  /**
   * �u���у��[�h�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_PROCESS_TYPE_RESULT() throws Exception {

        getDetailsTableColumn4().setVisible(false);

        getDetailsTableColumn5().setVisible(false);

        getOuterTableColumn4().setVisible(false);

        getOuterTableColumn5().setVisible(false);

  }

}
