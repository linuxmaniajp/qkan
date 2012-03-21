
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
 * �J����: ����@��F
 * �쐬��: 2011/11/16  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����̑����e�ڍ� (QS001_90101_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * �T�[�r�X�p�^�[�����̑����e�ڍ׏�Ԓ�`(QS001_90101_201204) 
 */
@SuppressWarnings("serial")
public class QS001_90101_201204State extends QS001_90101_201204Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_90101_201204State(){
  }

  /**
   * �u�ҏW�\�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_EDIT() throws Exception {

        getDailyLifeActivitFindButton().setEnabled(true);

        getDailyLifeActivitDeleteButton().setEnabled(true);

  }

  /**
   * �u�ҏW�s�\�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_EDIT() throws Exception {

        getDailyLifeActivitFindButton().setEnabled(false);

        getDailyLifeActivitDeleteButton().setEnabled(false);

  }

  /**
   * �u�ǉ��\�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_ADD() throws Exception {

        getDailyLifeActivitInsertButton().setEnabled(true);

  }

  /**
   * �u�ǉ��s�\�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_ADD() throws Exception {

        getDailyLifeActivitInsertButton().setEnabled(false);

  }

}
