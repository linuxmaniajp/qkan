
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
 * �v���O���� �T�[�r�X�p�^�[�����\�h�x���� (QS001_14611_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * �T�[�r�X�p�^�[�����\�h�x�����Ԓ�`(QS001_14611_201204) 
 */
@SuppressWarnings("serial")
public class QS001_14611_201204State extends QS001_14611_201204Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_14611_201204State(){
  }

  /**
   * �u��ʏ�ԂP�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_1() throws Exception {

        getConsignmentCareManagerNoText().setEnabled(false);

        getConsignmentCareManagerNameCombo().setEnabled(false);

  }

  /**
   * �u��ʏ�ԂQ�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_2() throws Exception {

        getConsignmentCareManagerNoText().setEnabled(true);

        getConsignmentCareManagerNameCombo().setEnabled(true);

  }

}
