
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
 * �쐬��: 2012/02/20  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[����ԑΉ��^�K���� (QS001_17111_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * �T�[�r�X�p�^�[����ԑΉ��^�K�����Ԓ�`(QS001_17111_201204) 
 */
public class QS001_17111_201204State extends QS001_17111_201204Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_17111_201204State(){
  }

  /**
   * �u�{�݋敪�EI�^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_STATE_1() throws Exception {

        getServiceDivisionRadio().setEnabled(true);
        getServiceDivisionRadio().getParent().setEnabled(true);

        getAnytimeCorrespondenceTypeRadio().setEnabled(true);
        getAnytimeCorrespondenceTypeRadio().getParent().setEnabled(true);

        getCalculationDivision().setEnabled(true);
        getCalculationDivision().getParent().setEnabled(true);

  }

  /**
   * �u�{�݋敪�EII�^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_STATE_2() throws Exception {

        getServiceDivisionRadio().setEnabled(false);
        getServiceDivisionRadio().getParent().setEnabled(false);

        getAnytimeCorrespondenceTypeRadio().setEnabled(false);
        getAnytimeCorrespondenceTypeRadio().getParent().setEnabled(false);

        getCalculationDivision().setEnabled(false);
        getCalculationDivision().getParent().setEnabled(false);

  }

  /**
   * �u�Ή��l���E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_PERSONS() throws Exception {

        getAnytimeCorrespondenceTypeRadio().setEnabled(true);
        getAnytimeCorrespondenceTypeRadio().getParent().setEnabled(true);

  }

  /**
   * �u�Ή��l���E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_PERSONS() throws Exception {

        getAnytimeCorrespondenceTypeRadio().setEnabled(false);
        getAnytimeCorrespondenceTypeRadio().getParent().setEnabled(false);

  }

  /**
   * �u�����`�F�b�N�L��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DAY_CHECK_ON() throws Exception {

        getPrintable().setEnabled(true);

  }

  /**
   * �u�����`�F�b�N�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DAY_CHECK_OFF() throws Exception {

        getPrintable().setEnabled(false);

  }

}
