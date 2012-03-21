
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
 * �J����: ��i�@�a�P
 * �쐬��: 2006/01/16  ���{�R���s���[�^�[������� ��i�@�a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ��Ë@�֊Ǘ� (010)
 * �v���O���� ��Ë@�֓o�^ (QO010)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo010;
/**
 * ��Ë@�֓o�^��Ԓ�`(QO010) 
 */
public class QO010State extends QO010Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO010State(){
  }

  /**
   * �u�o�^���[�h�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_INSERT_MODE() throws Exception {

        getInsert().setVisible(true);

        getUpdate().setVisible(false);

        getNewData().setVisible(false);

        getClear().setVisible(true);

  }

  /**
   * �u�X�V���[�h�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_UPDATE_MODE() throws Exception {

        getInsert().setVisible(false);

        getUpdate().setVisible(true);

        getNewData().setVisible(true);

        getClear().setVisible(false);

  }

}
