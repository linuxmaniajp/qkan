
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
 * �쐬��: 2012/02/16  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[��������x�� (QS001_14311_201504)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * �T�[�r�X�p�^�[��������x����Ԓ�`(QS001_14311_201504) 
 */
public class QS001_14311_201504State extends QS001_14311_201504Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_14311_201504State(){
  }

  /**
   * �u���Ə����E���Z�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_PROVIDER_CUT_OFF() throws Exception {

        getKaigoSupportSpecificProviderSubtractionRadio().setEnabled(false);
        getKaigoSupportSpecificProviderSubtractionRadio().getParent().setEnabled(false);

  }

  /**
   * �u���Ə����E���Z�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_PROVIDER_CUT_ON() throws Exception {

        getKaigoSupportSpecificProviderSubtractionRadio().setEnabled(true);
        getKaigoSupportSpecificProviderSubtractionRadio().getParent().setEnabled(true);

  }

  /**
   * �u������Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_SYOKAI_ADD() throws Exception {

        getKaigoSupportStandardRadio().setEnabled(false);
        getKaigoSupportStandardRadio().getParent().setEnabled(false);

  }

  /**
   * �u������Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_SYOKAI_ADD() throws Exception {

        getKaigoSupportStandardRadio().setEnabled(true);
        getKaigoSupportStandardRadio().getParent().setEnabled(true);

  }

  /**
   * �u�މ@�E�ޏ����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_TAIIN_ADD() throws Exception {

        getDischargeAddRadio().setEnabled(false);
        getDischargeAddRadio().getParent().setEnabled(false);

  }

  /**
   * �u�މ@�E�ޏ����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_TAIIN_ADD() throws Exception {

        getDischargeAddRadio().setEnabled(true);
        getDischargeAddRadio().getParent().setEnabled(true);

  }

}
