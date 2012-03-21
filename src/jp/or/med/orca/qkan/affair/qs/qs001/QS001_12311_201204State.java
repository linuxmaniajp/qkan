
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
 * �v���Z�X �T�[�r�X�p�^�[���Z�������×{���i�a�@�×{�j (001)
 * �v���O���� �T�[�r�X�p�^�[���Z�������×{���i�a�@�×{�j (QS001_12311_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * �T�[�r�X�p�^�[���Z�������×{���i�a�@�×{�j��Ԓ�`(QS001_12311_201204) 
 */
public class QS001_12311_201204State extends QS001_12311_201204Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_12311_201204State(){
  }

  /**
   * �u�H���񋟁E����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_USE_MEAT() throws Exception {

        getShortStayRecuperationHealthFacilityDinnerCost().setEnabled(true);

  }

  /**
   * �u�H���񋟁E�Ȃ��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_NOT_USE_MEAT() throws Exception {

        getShortStayRecuperationHealthFacilityDinnerCost().setEnabled(false);

  }

  /**
   * �u�l���z�u�T�E�U�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_PERSON_SUBTRACTION() throws Exception {

        getShortStayHospitalRecuperationType1().setEnabled(false);

        getShortStayHospitalRecuperationType2().setEnabled(false);

  }

  /**
   * �u�l���z�u�T�E�U�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_PERSON_SUBTRACTION() throws Exception {

        getShortStayHospitalRecuperationType1().setEnabled(true);

        getShortStayHospitalRecuperationType2().setEnabled(true);

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
   * �u�l���z�u�T�E�V�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_PERSON_SUBTRACTION_1_3() throws Exception {

        getShortStayHospitalRecuperationDivision().setEnabled(true);
        getShortStayHospitalRecuperationDivision().getParent().setEnabled(true);

        getShortStayHospitalRecuperationType1().setEnabled(false);

        getShortStayHospitalRecuperationType2().setEnabled(true);

        getShortStayHospitalRecuperationType3().setEnabled(false);

  }

  /**
   * �u�{�݋敪�E�a�@�×{�^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_NORMAL() throws Exception {

        getShortStayHospitalRecuperationHospitalRoomRadio().setEnabled(true);

        getShortStayHospitalRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getShortStayHospitalRecuperationDivision().setEnabled(true);
        getShortStayHospitalRecuperationDivision().getParent().setEnabled(true);

        getShortStayHospitalRecuperationType1().setEnabled(true);

        getShortStayHospitalRecuperationType2().setEnabled(true);

        getShortStayHospitalRecuperationType3().setEnabled(true);

        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setVisible(false);

        getShortStayHospitalRecuperationSickroomDivisionRadio().setEnabled(false);
        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setEnabled(false);

        getShortStayHospitalRecuperationHospitalRoomContena().setVisible(true);

        getTankinyusyoTimeDivision().setEnabled(false);

        getShortStayHospitalRecuperationAdditionType().getParent().setVisible(true);

        getShortStayHospitalRecuperationAdditionType().setEnabled(true);
        getShortStayHospitalRecuperationAdditionType().getParent().setEnabled(true);

        getShortStayHospitalRecuperationAdditionTypeForShortstay().getParent().setVisible(false);

        getShortStayHospitalRecuperationAdditionTypeForShortstay().setEnabled(false);
        getShortStayHospitalRecuperationAdditionTypeForShortstay().getParent().setEnabled(false);

        getDementiaActionAddRadioGroup().setEnabled(true);
        getDementiaActionAddRadioGroup().getParent().setEnabled(true);

        getEmergencyAcceptanceRadioGroup().setEnabled(true);
        getEmergencyAcceptanceRadioGroup().getParent().setEnabled(true);

  }

  /**
   * �u�{�݋敪�E���j�b�g�^�a�@�×{�^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_UNIT() throws Exception {

        getShortStayHospitalRecuperationHospitalRoomRadio().setEnabled(false);

        getShortStayHospitalRecuperationUnitHospitalRoomRadio().setEnabled(true);

        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().setEnabled(true);
        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(true);

        getShortStayHospitalRecuperationDivision().setEnabled(false);
        getShortStayHospitalRecuperationDivision().getParent().setEnabled(false);

        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setVisible(false);

        getShortStayHospitalRecuperationSickroomDivisionRadio().setEnabled(false);
        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setEnabled(false);

        getShortStayHospitalRecuperationHospitalRoomContena().setVisible(true);

        getTankinyusyoTimeDivision().setEnabled(false);

        getShortStayHospitalRecuperationAdditionType().getParent().setVisible(true);

        getShortStayHospitalRecuperationAdditionType().setEnabled(true);
        getShortStayHospitalRecuperationAdditionType().getParent().setEnabled(true);

        getShortStayHospitalRecuperationAdditionTypeForShortstay().getParent().setVisible(false);

        getShortStayHospitalRecuperationAdditionTypeForShortstay().setEnabled(false);
        getShortStayHospitalRecuperationAdditionTypeForShortstay().getParent().setEnabled(false);

        getDementiaActionAddRadioGroup().setEnabled(true);
        getDementiaActionAddRadioGroup().getParent().setEnabled(true);

        getEmergencyAcceptanceRadioGroup().setEnabled(true);
        getEmergencyAcceptanceRadioGroup().getParent().setEnabled(true);

  }

  /**
   * �u�{�݋敪�E�a�@�o�ߌ^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_KEIKAGATA() throws Exception {

        getShortStayHospitalRecuperationHospitalRoomRadio().setEnabled(true);

        getShortStayHospitalRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getShortStayHospitalRecuperationDivision().setEnabled(true);
        getShortStayHospitalRecuperationDivision().getParent().setEnabled(true);

        getShortStayHospitalRecuperationType1().setEnabled(true);

        getShortStayHospitalRecuperationType2().setEnabled(true);

        getShortStayHospitalRecuperationType3().setEnabled(false);

        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setVisible(false);

        getShortStayHospitalRecuperationSickroomDivisionRadio().setEnabled(false);
        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setEnabled(false);

        getShortStayHospitalRecuperationHospitalRoomContena().setVisible(true);

        getTankinyusyoTimeDivision().setEnabled(false);

        getShortStayHospitalRecuperationAdditionType().getParent().setVisible(true);

        getShortStayHospitalRecuperationAdditionType().setEnabled(true);
        getShortStayHospitalRecuperationAdditionType().getParent().setEnabled(true);

        getShortStayHospitalRecuperationAdditionTypeForShortstay().getParent().setVisible(false);

        getShortStayHospitalRecuperationAdditionTypeForShortstay().setEnabled(false);
        getShortStayHospitalRecuperationAdditionTypeForShortstay().getParent().setEnabled(false);

        getDementiaActionAddRadioGroup().setEnabled(true);
        getDementiaActionAddRadioGroup().getParent().setEnabled(true);

        getEmergencyAcceptanceRadioGroup().setEnabled(true);
        getEmergencyAcceptanceRadioGroup().getParent().setEnabled(true);

  }

  /**
   * �u�{�݋敪�E���j�b�g�^�a�@�o�ߌ^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_UNIT_KEIKAGATA() throws Exception {

        getShortStayHospitalRecuperationHospitalRoomRadio().setEnabled(false);

        getShortStayHospitalRecuperationUnitHospitalRoomRadio().setEnabled(true);

        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().setEnabled(true);
        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(true);

        getShortStayHospitalRecuperationDivision().setEnabled(false);
        getShortStayHospitalRecuperationDivision().getParent().setEnabled(false);

        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setVisible(false);

        getShortStayHospitalRecuperationSickroomDivisionRadio().setEnabled(false);
        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setEnabled(false);

        getShortStayHospitalRecuperationHospitalRoomContena().setVisible(true);

        getTankinyusyoTimeDivision().setEnabled(false);

        getShortStayHospitalRecuperationAdditionType().getParent().setVisible(true);

        getShortStayHospitalRecuperationAdditionType().setEnabled(true);
        getShortStayHospitalRecuperationAdditionType().getParent().setEnabled(true);

        getShortStayHospitalRecuperationAdditionTypeForShortstay().getParent().setVisible(false);

        getShortStayHospitalRecuperationAdditionTypeForShortstay().setEnabled(false);
        getShortStayHospitalRecuperationAdditionTypeForShortstay().getParent().setEnabled(false);

        getDementiaActionAddRadioGroup().setEnabled(true);
        getDementiaActionAddRadioGroup().getParent().setEnabled(true);

        getEmergencyAcceptanceRadioGroup().setEnabled(true);
        getEmergencyAcceptanceRadioGroup().getParent().setEnabled(true);

  }

  /**
   * �u�{�݋敪�E���A��V���[�g�X�e�C�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_SHORT_STAY() throws Exception {

        getShortStayHospitalRecuperationHospitalRoomRadio().setEnabled(false);

        getShortStayHospitalRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getShortStayHospitalRecuperationDivision().setEnabled(false);
        getShortStayHospitalRecuperationDivision().getParent().setEnabled(false);

        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setVisible(true);

        getShortStayHospitalRecuperationSickroomDivisionRadio().setEnabled(true);
        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setEnabled(true);

        getShortStayHospitalRecuperationHospitalRoomContena().setVisible(false);

        getTankinyusyoTimeDivision().setEnabled(true);

        getShortStayHospitalRecuperationAdditionType().getParent().setVisible(false);

        getShortStayHospitalRecuperationAdditionType().setEnabled(false);
        getShortStayHospitalRecuperationAdditionType().getParent().setEnabled(false);

        getShortStayHospitalRecuperationAdditionTypeForShortstay().getParent().setVisible(true);

        getShortStayHospitalRecuperationAdditionTypeForShortstay().setEnabled(true);
        getShortStayHospitalRecuperationAdditionTypeForShortstay().getParent().setEnabled(true);

        getDementiaActionAddRadioGroup().setEnabled(false);
        getDementiaActionAddRadioGroup().getParent().setEnabled(false);

        getEmergencyAcceptanceRadioGroup().setEnabled(false);
        getEmergencyAcceptanceRadioGroup().getParent().setEnabled(false);

  }

}
