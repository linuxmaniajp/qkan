
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
 * �쐬��: 2006/02/06  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� ���ԕ\ (QS001002)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * ���ԕ\��Ԓ�`(QS001002) 
 */
public class QS001002State extends QS001002Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001002State(){
  }

  /**
   * �u�T�[�r�X�I�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SERVICE_SELECTED() throws Exception {

        getCoordinatePrivateExpenses().setEnabled(true);

  }

  /**
   * �u�T�[�r�X���I�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SERVICE_UNSELECTED() throws Exception {

        getCoordinatePrivateExpenses().setEnabled(false);

  }

  /**
   * �u������ԁv�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INIT_STATE() throws Exception {

        getLimit().setEditable(false);

        getLimitAmount().setEditable(false);

        getAfterAdjustment().setEditable(false);

        getAdjustment().setEditable(false);

  }

  /**
   * �u�T�[�r�X�\��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SERVICE_PLAN() throws Exception {

        getUppers().setVisible(true);

  }

  /**
   * �u�T�[�r�X���сv�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SERVICE_RESULT() throws Exception {

        getUppers().setVisible(false);

  }

}
