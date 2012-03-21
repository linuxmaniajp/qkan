
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
 * �v���Z�X �T�[�r�X�p�^�[���ʏ����n (001)
 * �v���O���� �T�[�r�X�p�^�[���ʏ����n (QS001_11611_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * �T�[�r�X�p�^�[���ʏ����n��Ԓ�`(QS001_11611_201204) 
 */
public class QS001_11611_201204State extends QS001_11611_201204Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_11611_201204State(){
  }

  /**
   * �u���w�Ö@�m���̐��������Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_PHYSIOTHERAPIST_STRENGTHENED() throws Exception {

        getPhysiotherapistStrengthenedAddRadioGroup().setEnabled(true);
        getPhysiotherapistStrengthenedAddRadioGroup().getParent().setEnabled(true);

  }

  /**
   * �u���w�Ö@�m���̐��������Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_PHYSIOTHERAPIST_STRENGTHENED() throws Exception {

        getPhysiotherapistStrengthenedAddRadioGroup().setEnabled(false);
        getPhysiotherapistStrengthenedAddRadioGroup().getParent().setEnabled(false);

  }

  /**
   * �u�d�x�×{�Ǘ����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_ADD_MEDICAL_MANAGEMENT() throws Exception {

        getMedicalManagementRadioGroup().setEnabled(true);
        getMedicalManagementRadioGroup().getParent().setEnabled(true);

  }

  /**
   * �u�d�x�×{�Ǘ����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_ADD_MEDICAL_MANAGEMENT() throws Exception {

        getMedicalManagementRadioGroup().setEnabled(false);
        getMedicalManagementRadioGroup().getParent().setEnabled(false);

  }

}
