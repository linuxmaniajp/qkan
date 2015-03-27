
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
 * �쐬��: 2012/03/06  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�p�^�[���Z�������×{��� (001)
 * �v���O���� �T�[�r�X�p�^�[���Z�������×{���(���V�l�ی��{��) (QS001_12211_201504)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * �T�[�r�X�p�^�[���Z�������×{���(���V�l�ی��{��)��Ԓ�`(QS001_12211_201504) 
 */
public class QS001_12211_201504State extends QS001_12211_201504Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_12211_201504State(){
  }

  /**
   * �u���V�l�ی��{�݁iI�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_1() throws Exception {

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionContena().setVisible(true);

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio().setEnabled(true);

        getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio().setEnabled(false);

        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().getParent().setVisible(false);

        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().setEnabled(false);
        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().getParent().setEnabled(false);

        getTankinyusyoTimeDivision().setEnabled(false);
        getTankinyusyoTimeDivision().getParent().setEnabled(false);

        getShortStayRecuperationHealthUnitCareAddRadio().setEnabled(false);
        getShortStayRecuperationHealthUnitCareAddRadio().getParent().setEnabled(false);

        getNightStaffDispositionAddRadioGroup().setEnabled(true);
        getNightStaffDispositionAddRadioGroup().getParent().setEnabled(true);

        getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio().setEnabled(true);
        getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio().getParent().setEnabled(true);

        getDementiaActionAddRadioGroup().setEnabled(true);
        getDementiaActionAddRadioGroup().getParent().setEnabled(true);

        getShortStayRecuperationHealthPersonnelDivision1().setEnabled(true);

        getShortStayRecuperationHealthPersonnelDivision2().setEnabled(false);

        getShortStayRecuperationHealthFacilitySpecialMedicalExpense().setEnabled(false);

        getShortStayRecuperationHealthFacilityRecuperationRadio().setEnabled(false);
        getShortStayRecuperationHealthFacilityRecuperationRadio().getParent().setEnabled(false);

  }

  /**
   * �u���j�b�g�^���V�l�ی��{�݁iI�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_2() throws Exception {

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionContena().setVisible(true);

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio().setEnabled(false);

        getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio().setEnabled(true);

        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().getParent().setVisible(false);

        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().setEnabled(false);
        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().getParent().setEnabled(false);

        getTankinyusyoTimeDivision().setEnabled(false);
        getTankinyusyoTimeDivision().getParent().setEnabled(false);

        getShortStayRecuperationHealthUnitCareAddRadio().setEnabled(true);
        getShortStayRecuperationHealthUnitCareAddRadio().getParent().setEnabled(true);

        getNightStaffDispositionAddRadioGroup().setEnabled(true);
        getNightStaffDispositionAddRadioGroup().getParent().setEnabled(true);

        getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio().setEnabled(false);
        getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio().getParent().setEnabled(false);

        getDementiaActionAddRadioGroup().setEnabled(true);
        getDementiaActionAddRadioGroup().getParent().setEnabled(true);

        getShortStayRecuperationHealthPersonnelDivision1().setEnabled(true);

        getShortStayRecuperationHealthPersonnelDivision2().setEnabled(false);

        getShortStayRecuperationHealthFacilitySpecialMedicalExpense().setEnabled(false);

        getShortStayRecuperationHealthFacilityRecuperationRadio().setEnabled(false);
        getShortStayRecuperationHealthFacilityRecuperationRadio().getParent().setEnabled(false);

  }

  /**
   * �u���V�l�ی��{�݁iII�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_3() throws Exception {

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionContena().setVisible(true);

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio().setEnabled(true);

        getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio().setEnabled(false);

        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().getParent().setVisible(false);

        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().setEnabled(false);
        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().getParent().setEnabled(false);

        getTankinyusyoTimeDivision().setEnabled(false);
        getTankinyusyoTimeDivision().getParent().setEnabled(false);

        getShortStayRecuperationHealthUnitCareAddRadio().setEnabled(false);
        getShortStayRecuperationHealthUnitCareAddRadio().getParent().setEnabled(false);

        getNightStaffDispositionAddRadioGroup().setEnabled(true);
        getNightStaffDispositionAddRadioGroup().getParent().setEnabled(true);

        getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio().setEnabled(true);
        getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio().getParent().setEnabled(true);

        getDementiaActionAddRadioGroup().setEnabled(true);
        getDementiaActionAddRadioGroup().getParent().setEnabled(true);

        getShortStayRecuperationHealthPersonnelDivision1().setEnabled(false);

        getShortStayRecuperationHealthPersonnelDivision2().setEnabled(true);

        getShortStayRecuperationHealthFacilitySpecialMedicalExpense().setEnabled(true);

        getShortStayRecuperationHealthFacilityRecuperationRadio().setEnabled(true);
        getShortStayRecuperationHealthFacilityRecuperationRadio().getParent().setEnabled(true);

  }

  /**
   * �u���j�b�g�^���V�l�ی��{�݁iII�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_4() throws Exception {

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionContena().setVisible(true);

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio().setEnabled(false);

        getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio().setEnabled(true);

        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().getParent().setVisible(false);

        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().setEnabled(false);
        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().getParent().setEnabled(false);

        getTankinyusyoTimeDivision().setEnabled(false);
        getTankinyusyoTimeDivision().getParent().setEnabled(false);

        getShortStayRecuperationHealthUnitCareAddRadio().setEnabled(true);
        getShortStayRecuperationHealthUnitCareAddRadio().getParent().setEnabled(true);

        getNightStaffDispositionAddRadioGroup().setEnabled(true);
        getNightStaffDispositionAddRadioGroup().getParent().setEnabled(true);

        getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio().setEnabled(false);
        getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio().getParent().setEnabled(false);

        getDementiaActionAddRadioGroup().setEnabled(true);
        getDementiaActionAddRadioGroup().getParent().setEnabled(true);

        getShortStayRecuperationHealthPersonnelDivision1().setEnabled(false);

        getShortStayRecuperationHealthPersonnelDivision2().setEnabled(true);

        getShortStayRecuperationHealthFacilitySpecialMedicalExpense().setEnabled(true);

        getShortStayRecuperationHealthFacilityRecuperationRadio().setEnabled(true);
        getShortStayRecuperationHealthFacilityRecuperationRadio().getParent().setEnabled(true);

  }

  /**
   * �u���V�l�ی��{�݁iIII�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_5() throws Exception {

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionContena().setVisible(true);

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio().setEnabled(true);

        getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio().setEnabled(false);

        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().getParent().setVisible(false);

        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().setEnabled(false);
        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().getParent().setEnabled(false);

        getTankinyusyoTimeDivision().setEnabled(false);
        getTankinyusyoTimeDivision().getParent().setEnabled(false);

        getShortStayRecuperationHealthUnitCareAddRadio().setEnabled(false);
        getShortStayRecuperationHealthUnitCareAddRadio().getParent().setEnabled(false);

        getNightStaffDispositionAddRadioGroup().setEnabled(true);
        getNightStaffDispositionAddRadioGroup().getParent().setEnabled(true);

        getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio().setEnabled(true);
        getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio().getParent().setEnabled(true);

        getDementiaActionAddRadioGroup().setEnabled(true);
        getDementiaActionAddRadioGroup().getParent().setEnabled(true);

        getShortStayRecuperationHealthPersonnelDivision1().setEnabled(false);

        getShortStayRecuperationHealthPersonnelDivision2().setEnabled(true);

        getShortStayRecuperationHealthFacilitySpecialMedicalExpense().setEnabled(true);

        getShortStayRecuperationHealthFacilityRecuperationRadio().setEnabled(true);
        getShortStayRecuperationHealthFacilityRecuperationRadio().getParent().setEnabled(true);

  }

  /**
   * �u���j�b�g�^���V�l�ی��{�݁iIII�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_6() throws Exception {

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionContena().setVisible(true);

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio().setEnabled(false);

        getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio().setEnabled(true);

        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().getParent().setVisible(false);

        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().setEnabled(false);
        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().getParent().setEnabled(false);

        getTankinyusyoTimeDivision().setEnabled(false);
        getTankinyusyoTimeDivision().getParent().setEnabled(false);

        getShortStayRecuperationHealthUnitCareAddRadio().setEnabled(true);
        getShortStayRecuperationHealthUnitCareAddRadio().getParent().setEnabled(true);

        getNightStaffDispositionAddRadioGroup().setEnabled(true);
        getNightStaffDispositionAddRadioGroup().getParent().setEnabled(true);

        getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio().setEnabled(false);
        getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio().getParent().setEnabled(false);

        getDementiaActionAddRadioGroup().setEnabled(true);
        getDementiaActionAddRadioGroup().getParent().setEnabled(true);

        getShortStayRecuperationHealthPersonnelDivision1().setEnabled(false);

        getShortStayRecuperationHealthPersonnelDivision2().setEnabled(true);

        getShortStayRecuperationHealthFacilitySpecialMedicalExpense().setEnabled(true);

        getShortStayRecuperationHealthFacilityRecuperationRadio().setEnabled(true);
        getShortStayRecuperationHealthFacilityRecuperationRadio().getParent().setEnabled(true);

  }

  /**
   * �u���A��V���[�g�X�e�C�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_7() throws Exception {

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionContena().setVisible(false);

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio().setEnabled(false);

        getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio().setEnabled(false);

        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().getParent().setVisible(true);

        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().setEnabled(true);
        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().getParent().setEnabled(true);

        getTankinyusyoTimeDivision().setEnabled(true);
        getTankinyusyoTimeDivision().getParent().setEnabled(true);

        getShortStayRecuperationHealthUnitCareAddRadio().setEnabled(false);
        getShortStayRecuperationHealthUnitCareAddRadio().getParent().setEnabled(false);

        getNightStaffDispositionAddRadioGroup().setEnabled(false);
        getNightStaffDispositionAddRadioGroup().getParent().setEnabled(false);

        getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio().setEnabled(false);
        getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio().getParent().setEnabled(false);

        getDementiaActionAddRadioGroup().setEnabled(false);
        getDementiaActionAddRadioGroup().getParent().setEnabled(false);

        getShortStayRecuperationHealthPersonnelDivision1().setEnabled(false);

        getShortStayRecuperationHealthPersonnelDivision2().setEnabled(false);

        getShortStayRecuperationHealthFacilitySpecialMedicalExpense().setEnabled(true);

        getShortStayRecuperationHealthFacilityRecuperationRadio().setEnabled(false);
        getShortStayRecuperationHealthFacilityRecuperationRadio().getParent().setEnabled(false);

  }

  /**
   * �u�F�m�ǃP�A���Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_DEMENTIA_CARE() throws Exception {

        getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio().setEnabled(true);
        getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio().getParent().setEnabled(true);

  }

  /**
   * �u�F�m�ǃP�A���Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_DEMENTIA_CARE() throws Exception {

        getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio().setEnabled(false);
        getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio().getParent().setEnabled(false);

  }

  /**
   * �u�F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_DEMENTIA_ACTION() throws Exception {

        getDementiaActionAddRadioGroup().setEnabled(true);
        getDementiaActionAddRadioGroup().getParent().setEnabled(true);

  }

  /**
   * �u�F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_DEMENTIA_ACTION() throws Exception {

        getDementiaActionAddRadioGroup().setEnabled(false);
        getDementiaActionAddRadioGroup().getParent().setEnabled(false);

  }

  /**
   * �u�H���񋟁E����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_USE_MEAT() throws Exception {

        getShortStayRecuperationHealthFacilityDinnerCost().setEnabled(true);
        getShortStayRecuperationHealthFacilityDinnerCost().getParent().setEnabled(true);

  }

  /**
   * �u�H���񋟁E�Ȃ��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_NOT_USE_MEAT() throws Exception {

        getShortStayRecuperationHealthFacilityDinnerCost().setEnabled(false);
        getShortStayRecuperationHealthFacilityDinnerCost().getParent().setEnabled(false);

  }

  /**
   * �u��N���F�m�Ǘ��p�Ҏ�����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_YOUNG_DEMENTIA_PATINET() throws Exception {

        getYoungDementiaPatinetAddRadioGroup().setEnabled(true);
        getYoungDementiaPatinetAddRadioGroup().getParent().setEnabled(true);

  }

  /**
   * �u��N���F�m�Ǘ��p�Ҏ�����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_YOUNG_DEMENTIA_PATINET() throws Exception {

        getYoungDementiaPatinetAddRadioGroup().setEnabled(false);
        getYoungDementiaPatinetAddRadioGroup().getParent().setEnabled(false);

  }

  /**
   * �u�d�x�×{�Ǘ����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_MEDICAL_MANAGEMENT() throws Exception {

        getSeverelyMedicalManagementAdd().setEnabled(true);
        getSeverelyMedicalManagementAdd().getParent().setEnabled(true);

  }

  /**
   * �u�d�x�×{�Ǘ����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_MEDICAL_MANAGEMENT() throws Exception {

        getSeverelyMedicalManagementAdd().setEnabled(false);
        getSeverelyMedicalManagementAdd().getParent().setEnabled(false);

  }

  /**
   * �u�ً}�Z������������Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_EMERGENCY_ACCEPTANCE() throws Exception {

        getEmergencyAcceptanceRadioGroup().setEnabled(true);
        getEmergencyAcceptanceRadioGroup().getParent().setEnabled(true);

  }

  /**
   * �u�ً}�Z������������Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_EMERGENCY_ACCEPTANCE() throws Exception {

        getEmergencyAcceptanceRadioGroup().setEnabled(false);
        getEmergencyAcceptanceRadioGroup().getParent().setEnabled(false);

  }

}
