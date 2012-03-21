
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
 * �J����: �����@�L
 * �쐬��: 2006/02/16  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X CSV�o�� (008)
 * �v���O���� �t�H���_�I�� (QP008)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp008;
/**
 * �t�H���_�I����Ԓ�`(QP008) 
 */
public class QP008State extends QP008Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QP008State(){
  }

  /**
   * �u������ԁv�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INIT() throws Exception {

        getErrorPanel().setVisible(false);

        getFileSelects().setVisible(true);

        getGoBack().setEnabled(false);

        getCancel().setEnabled(true);

        getFilePath().setEditable(false);

  }

  /**
   * �uCSV�o�͊������v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INFO() throws Exception {

        getErrorPanel().setVisible(true);

        getFileSelects().setVisible(false);

        getGoBack().setEnabled(false);

        getCancel().setEnabled(false);

        getFilePath().setEditable(false);

  }

  /**
   * �uCSV�o�̓G���[���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ERROR() throws Exception {

        getErrorPanel().setVisible(true);

        getFileSelects().setVisible(false);

        getGoBack().setEnabled(true);

        getCancel().setEnabled(true);

        getFilePath().setEditable(false);

  }

}
