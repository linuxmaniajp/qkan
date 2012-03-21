
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
 * �쐬��: 2012/03/08  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����V�l�ی��{�� (QS001_15211_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * �T�[�r�X�p�^�[�����V�l�ی��{�ݏ�Ԓ�`(QS001_15211_201204) 
 */
public class QS001_15211_201204State extends QS001_15211_201204Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_15211_201204State(){
  }

  /**
   * �u�H���񋟁E����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_USE_MEAT() throws Exception {

        getKaigoHealthCareOfTheAgedDinnerCost().setEnabled(true);

  }

  /**
   * �u�H���񋟁E�Ȃ��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_NOT_USE_MEAT() throws Exception {

        getKaigoHealthCareOfTheAgedDinnerCost().setEnabled(false);

  }

  /**
   * �u�o���ڍs�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_NUTRITION() throws Exception {

        getKaigoHealthCareOfTheAgedOralSwitchRadio().setEnabled(true);
        getKaigoHealthCareOfTheAgedOralSwitchRadio().getParent().setEnabled(true);

  }

  /**
   * �u�o���ڍs�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_NUTRITION() throws Exception {

        getKaigoHealthCareOfTheAgedOralSwitchRadio().setEnabled(false);
        getKaigoHealthCareOfTheAgedOralSwitchRadio().getParent().setEnabled(false);

  }

  /**
   * �u�o���ێ����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_KEEP_NUTRITION() throws Exception {

        getOralMaintenanceAddRadio().setEnabled(true);
        getOralMaintenanceAddRadio().getParent().setEnabled(true);

  }

  /**
   * �u�o���ێ����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_KEEP_NUTRITION() throws Exception {

        getOralMaintenanceAddRadio().setEnabled(false);
        getOralMaintenanceAddRadio().getParent().setEnabled(false);

  }

  /**
   * �u�O�����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_GAIHAKU() throws Exception {

        getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadio().setEnabled(true);
        getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadio().getParent().setEnabled(true);

  }

  /**
   * �u�O�����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_GAIHAKU() throws Exception {

        getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadio().setEnabled(false);
        getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadio().getParent().setEnabled(false);

  }

  /**
   * �u���V�l�ی��{�݁iI�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_1() throws Exception {

        getKaigoHealthCareOfTheAgedHospitalRoomRadio().setEnabled(true);

        getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio().setEnabled(false);

        getUnitCareMaintenanceRadio().setEnabled(false);
        getUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getSpecialMedicalExpense().setEnabled(false);

        getIntentionCommunicationDifficultyAddRadio().setEnabled(true);
        getIntentionCommunicationDifficultyAddRadio().getParent().setEnabled(true);

        getKaigoHealthCareOfTheAgedHospitalDivision1().setEnabled(true);

        getKaigoHealthCareOfTheAgedHospitalDivision2().setEnabled(false);

        getStayReturnSupportAddRadio().setEnabled(false);
        getStayReturnSupportAddRadio().getParent().setEnabled(false);

        getRecuperationRadio().setEnabled(false);
        getRecuperationRadio().getParent().setEnabled(false);

  }

  /**
   * �u���j�b�g�^���V�l�ی��{�݁iI�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_2() throws Exception {

        getKaigoHealthCareOfTheAgedHospitalRoomRadio().setEnabled(false);

        getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio().setEnabled(true);

        getUnitCareMaintenanceRadio().setEnabled(true);
        getUnitCareMaintenanceRadio().getParent().setEnabled(true);

        getSpecialMedicalExpense().setEnabled(false);

        getIntentionCommunicationDifficultyAddRadio().setEnabled(false);
        getIntentionCommunicationDifficultyAddRadio().getParent().setEnabled(false);

        getKaigoHealthCareOfTheAgedHospitalDivision1().setEnabled(true);

        getKaigoHealthCareOfTheAgedHospitalDivision2().setEnabled(false);

        getStayReturnSupportAddRadio().setEnabled(false);
        getStayReturnSupportAddRadio().getParent().setEnabled(false);

        getRecuperationRadio().setEnabled(false);
        getRecuperationRadio().getParent().setEnabled(false);

  }

  /**
   * �u���V�l�ی��{�݁iII�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_3() throws Exception {

        getKaigoHealthCareOfTheAgedHospitalRoomRadio().setEnabled(true);

        getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio().setEnabled(false);

        getUnitCareMaintenanceRadio().setEnabled(false);
        getUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getSpecialMedicalExpense().setEnabled(true);

        getIntentionCommunicationDifficultyAddRadio().setEnabled(true);
        getIntentionCommunicationDifficultyAddRadio().getParent().setEnabled(true);

        getStayReturnSupportRyoyoAddRadio().setEnabled(false);
        getStayReturnSupportRyoyoAddRadio().getParent().setEnabled(false);

        getKaigoHealthCareOfTheAgedHospitalDivision1().setEnabled(false);

        getKaigoHealthCareOfTheAgedHospitalDivision2().setEnabled(true);

        getStayReturnSupportAddRadio().setEnabled(true);
        getStayReturnSupportAddRadio().getParent().setEnabled(true);

        getRecuperationRadio().setEnabled(true);
        getRecuperationRadio().getParent().setEnabled(true);

  }

  /**
   * �u���j�b�g�^���V�l�ی��{�݁iII�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_4() throws Exception {

        getKaigoHealthCareOfTheAgedHospitalRoomRadio().setEnabled(false);

        getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio().setEnabled(true);

        getUnitCareMaintenanceRadio().setEnabled(true);
        getUnitCareMaintenanceRadio().getParent().setEnabled(true);

        getSpecialMedicalExpense().setEnabled(true);

        getIntentionCommunicationDifficultyAddRadio().setEnabled(false);
        getIntentionCommunicationDifficultyAddRadio().getParent().setEnabled(false);

        getStayReturnSupportRyoyoAddRadio().setEnabled(false);
        getStayReturnSupportRyoyoAddRadio().getParent().setEnabled(false);

        getKaigoHealthCareOfTheAgedHospitalDivision1().setEnabled(false);

        getKaigoHealthCareOfTheAgedHospitalDivision2().setEnabled(true);

        getStayReturnSupportAddRadio().setEnabled(true);
        getStayReturnSupportAddRadio().getParent().setEnabled(true);

        getRecuperationRadio().setEnabled(true);
        getRecuperationRadio().getParent().setEnabled(true);

  }

  /**
   * �u���V�l�ی��{�݁iIII�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_5() throws Exception {

        getKaigoHealthCareOfTheAgedHospitalRoomRadio().setEnabled(true);

        getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio().setEnabled(false);

        getUnitCareMaintenanceRadio().setEnabled(false);
        getUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getSpecialMedicalExpense().setEnabled(true);

        getIntentionCommunicationDifficultyAddRadio().setEnabled(true);
        getIntentionCommunicationDifficultyAddRadio().getParent().setEnabled(true);

        getStayReturnSupportRyoyoAddRadio().setEnabled(false);
        getStayReturnSupportRyoyoAddRadio().getParent().setEnabled(false);

        getKaigoHealthCareOfTheAgedHospitalDivision1().setEnabled(false);

        getKaigoHealthCareOfTheAgedHospitalDivision2().setEnabled(true);

        getStayReturnSupportAddRadio().setEnabled(true);
        getStayReturnSupportAddRadio().getParent().setEnabled(true);

        getRecuperationRadio().setEnabled(true);
        getRecuperationRadio().getParent().setEnabled(true);

  }

  /**
   * �u���j�b�g�^���V�l�ی��{�݁iIII�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_6() throws Exception {

        getKaigoHealthCareOfTheAgedHospitalRoomRadio().setEnabled(false);

        getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio().setEnabled(true);

        getUnitCareMaintenanceRadio().setEnabled(true);
        getUnitCareMaintenanceRadio().getParent().setEnabled(true);

        getSpecialMedicalExpense().setEnabled(true);

        getIntentionCommunicationDifficultyAddRadio().setEnabled(false);
        getIntentionCommunicationDifficultyAddRadio().getParent().setEnabled(false);

        getStayReturnSupportRyoyoAddRadio().setEnabled(false);
        getStayReturnSupportRyoyoAddRadio().getParent().setEnabled(false);

        getKaigoHealthCareOfTheAgedHospitalDivision1().setEnabled(false);

        getKaigoHealthCareOfTheAgedHospitalDivision2().setEnabled(true);

        getStayReturnSupportAddRadio().setEnabled(true);
        getStayReturnSupportAddRadio().getParent().setEnabled(true);

        getRecuperationRadio().setEnabled(true);
        getRecuperationRadio().getParent().setEnabled(true);

  }

  /**
   * �u�ݑ�A�x���@�\���Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_STAY_RETURN() throws Exception {

        getStayReturnSupportRyoyoAddRadio().setEnabled(true);
        getStayReturnSupportRyoyoAddRadio().getParent().setEnabled(true);

  }

  /**
   * �u�ݑ�A�x���@�\���Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_STAY_RETURN() throws Exception {

        getStayReturnSupportRyoyoAddRadio().setEnabled(false);
        getStayReturnSupportRyoyoAddRadio().getParent().setEnabled(false);

  }

  /**
   * �u���o�@�\�ێ��Ǘ����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_ORAL_CARE() throws Exception {

        getOralKeepAddRadioGroup().setEnabled(true);
        getOralKeepAddRadioGroup().getParent().setEnabled(true);

  }

  /**
   * �u���o�@�\�ێ��Ǘ����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_ORAL_CARE() throws Exception {

        getOralKeepAddRadioGroup().setEnabled(false);
        getOralKeepAddRadioGroup().getParent().setEnabled(false);

  }

}
