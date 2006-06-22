
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
 * �쐬��: 2006/02/07  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� ����E������� (QS001029)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * ����E������ʏ�Ԓ�`(QS001029) 
 */
public class QS001029State extends QS001029Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001029State(){
  }

  /**
   * �u������ԁv�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INIT_STATE() throws Exception {

        getServiceDate().setEditable(false);

        getServiceStartTime().setEditable(false);

        getServiceEndTime().setEditable(false);

        getServiceUnit().setEditable(false);

        getServiceAdjustUnit().setEditable(false);

        getServiceResultUnit().setEditable(false);

  }

  /**
   * �u����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_EXPENCE() throws Exception {

        getServiceAdjustUnit().setEditable(false);

  }

  /**
   * �u�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ADJUST() throws Exception {

        getServiceAdjustUnit().setEditable(true);

  }

}
