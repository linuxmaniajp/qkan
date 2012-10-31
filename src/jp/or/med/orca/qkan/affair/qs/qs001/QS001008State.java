
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
 * �쐬��: 2012/08/08  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\�� (S)
 * �v���Z�X �J�����_�[ (001)
 * �v���O���� ����f�Ô�E���ʗ×{��W�v (QS001008)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * ����f�Ô�E���ʗ×{��W�v��Ԓ�`(QS001008) 
 */
public class QS001008State extends QS001008Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001008State(){
  }

  /**
   * �u�_�C�A���O�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_DIALOG_FALSE() throws Exception {

        getTokubetsuGroup().setEnabled(false);

        getDayDetailGroup().setEnabled(false);

        getTokubetsuTable().setEnabled(false);

        getDayDetailTable().setEnabled(false);

        getProviderCombo().setEnabled(false);
        getProviderCombo().getParent().setEnabled(false);

        getServiceCombo().setEnabled(false);
        getServiceCombo().getParent().setEnabled(false);

  }

  /**
   * �u�_�C�A���O�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_DIALOG_TRUE() throws Exception {

        getTokubetsuGroup().setEnabled(true);

        getDayDetailGroup().setEnabled(true);

        getTokubetsuTable().setEnabled(true);

        getDayDetailTable().setEnabled(true);

        getProviderCombo().setEnabled(true);
        getProviderCombo().getParent().setEnabled(true);

        getServiceCombo().setEnabled(true);
        getServiceCombo().getParent().setEnabled(true);

  }

}
