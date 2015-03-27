
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
 * �J����: �����@���̂�
 * �쐬��: 2014/12/02  MIS��B������� �����@���̂� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���[�Ǘ� (C)
 * �v���Z�X ����×{�Ǘ��w���� (006)
 * �v���O���� ����×{�Ǘ��w�����ꗗ (QC006)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qc.qc006;
/**
 * ����×{�Ǘ��w�����ꗗ��Ԓ�`(QC006) 
 */
public class QC006State extends QC006Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QC006State(){
  }

  /**
   * �u�V�K�E�X�V�i�Z���I����ԁj�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SELECTED() throws Exception {

        getDetail().setEnabled(true);

        getInsert().setEnabled(true);

        getDelete().setEnabled(true);

  }

  /**
   * �u�V�K�E�X�V�i�Z�����I����ԁj�A�V�K�̂݁v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_NEWSELECTED() throws Exception {

        getDetail().setEnabled(false);

        getInsert().setEnabled(true);

        getDelete().setEnabled(false);

  }

  /**
   * �u�X�V�̂݁i�Z���I���j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_NEWUNSELECTED() throws Exception {

        getDetail().setEnabled(true);

        getInsert().setEnabled(false);

        getDelete().setEnabled(true);

  }

  /**
   * �u�X�V�̂݁i�Z�����I���j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_UNSELECTED() throws Exception {

        getDetail().setEnabled(false);

        getInsert().setEnabled(false);

        getDelete().setEnabled(false);

  }

}
