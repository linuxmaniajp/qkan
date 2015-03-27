
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
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�p�^�[���n�斧���^����{�ݓ����Ґ������ (001)
 * �v���O���� �T�[�r�X�p�^�[���������E�����Ή��^�K����Ō� (QS001_17611_201504)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * �T�[�r�X�p�^�[���������E�����Ή��^�K����Ō��Ԓ�`(QS001_17611_201504) 
 */
public class QS001_17611_201504State extends QS001_17611_201504Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_17611_201504State(){
  }

  /**
   * �u�{�݋敪�E��̌^�i�w���Ȃ��j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DIVISION_STATE_1() throws Exception {

        getSijishoOfferRadioGroup().setEnabled(true);
        getSijishoOfferRadioGroup().getParent().setEnabled(true);

        getEmergencyVisitRadioGroup().setEnabled(false);
        getEmergencyVisitRadioGroup().getParent().setEnabled(false);

        getSpecialManagementRadioGroup().setEnabled(false);
        getSpecialManagementRadioGroup().getParent().setEnabled(false);

        getTerminalCareRadioGroup().setEnabled(false);
        getTerminalCareRadioGroup().getParent().setEnabled(false);

        getNurseStaffDivisionRadioGroup().setEnabled(false);
        getNurseStaffDivisionRadioGroup().getParent().setEnabled(false);

  }

  /**
   * �u�{�݋敪�E��̌^�i�w������j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DIVISION_STATE_2() throws Exception {

        getSijishoOfferRadioGroup().setEnabled(true);
        getSijishoOfferRadioGroup().getParent().setEnabled(true);

        getEmergencyVisitRadioGroup().setEnabled(true);
        getEmergencyVisitRadioGroup().getParent().setEnabled(true);

        getSpecialManagementRadioGroup().setEnabled(true);
        getSpecialManagementRadioGroup().getParent().setEnabled(true);

        getTerminalCareRadioGroup().setEnabled(true);
        getTerminalCareRadioGroup().getParent().setEnabled(true);

        getNurseStaffDivisionRadioGroup().setEnabled(true);
        getNurseStaffDivisionRadioGroup().getParent().setEnabled(true);

  }

  /**
   * �u�{�݋敪�E��ԂR�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DIVISION_STATE_3() throws Exception {

        getSijishoOfferRadioGroup().setEnabled(false);
        getSijishoOfferRadioGroup().getParent().setEnabled(false);

        getEmergencyVisitRadioGroup().setEnabled(false);
        getEmergencyVisitRadioGroup().getParent().setEnabled(false);

        getSpecialManagementRadioGroup().setEnabled(false);
        getSpecialManagementRadioGroup().getParent().setEnabled(false);

        getTerminalCareRadioGroup().setEnabled(false);
        getTerminalCareRadioGroup().getParent().setEnabled(false);

        getNurseStaffDivisionRadioGroup().setEnabled(false);
        getNurseStaffDivisionRadioGroup().getParent().setEnabled(false);

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
