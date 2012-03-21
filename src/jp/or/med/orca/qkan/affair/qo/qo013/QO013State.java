
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
 * �쐬��: 2006/06/02  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ����W�����Z�v�g�\�t�g�A�g (013)
 * �v���O���� ����W�����Z�v�g�\�t�g�A�g (QO013)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo013;
/**
 * ����W�����Z�v�g�\�t�g�A�g��Ԓ�`(QO013) 
 */
public class QO013State extends QO013Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO013State(){
  }

  /**
   * �u���ڑ��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_NOT_CONNECTED() throws Exception {

        getImportPatient().setEnabled(false);

  }

  /**
   * �u�ڑ��ς݁v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_CONNECTED() throws Exception {

        getImportPatient().setEnabled(true);

  }

  /**
   * �u�O�y�[�W�Ȃ��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_PREVIEW_PAGE() throws Exception {

        getPreviewPage().setEnabled(false);

  }

  /**
   * �u�O�y�[�W����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_PREVIEW_PAGE() throws Exception {

        getPreviewPage().setEnabled(true);

  }

  /**
   * �u���y�[�W�Ȃ��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_NEXT_PAGE() throws Exception {

        getNextPage().setEnabled(false);

  }

  /**
   * �u���y�[�W����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_NEXT_PAGE() throws Exception {

        getNextPage().setEnabled(true);

  }

}
