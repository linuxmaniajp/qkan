
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
 * �v���Z�X �T�[�r�X�p�^�[�����V�l�����{�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����V�l�����{�� (QS001_15111_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * �T�[�r�X�p�^�[�����V�l�����{�ݏ�Ԓ�`(QS001_15111_201204) 
 */
public class QS001_15111_201204State extends QS001_15111_201204Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_15111_201204State(){
  }

  /**
   * �u�o���ڍs���Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_NUTRITION() throws Exception {

        getKaigoWelfareFacilityOralSwitchRadio().setEnabled(true);
        getKaigoWelfareFacilityOralSwitchRadio().getParent().setEnabled(true);

  }

  /**
   * �u�o���ڍs���Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_NUTRITION() throws Exception {

        getKaigoWelfareFacilityOralSwitchRadio().setEnabled(false);
        getKaigoWelfareFacilityOralSwitchRadio().getParent().setEnabled(false);

  }

  /**
   * �u�]���^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_CONVENTIONAL_FORM() throws Exception {

        getKaigoWelfareFacilityHospitalRoomDivisionRadio().setEnabled(true);

        getKaigoWelfareFacilityUnitHospitalRoomDivisionRadio().setEnabled(false);

        getKaigoWelfareFacilityUnitCareMaintenanceRadio().setEnabled(false);
        getKaigoWelfareFacilityUnitCareMaintenanceRadio().getParent().setEnabled(false);

  }

  /**
   * �u���j�b�g�^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_UNIT_FORM() throws Exception {

        getKaigoWelfareFacilityHospitalRoomDivisionRadio().setEnabled(false);

        getKaigoWelfareFacilityUnitHospitalRoomDivisionRadio().setEnabled(true);

        getKaigoWelfareFacilityUnitCareMaintenanceRadio().setEnabled(true);
        getKaigoWelfareFacilityUnitCareMaintenanceRadio().getParent().setEnabled(true);

  }

  /**
   * �u�H���񋟁E����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_USE_MEAT() throws Exception {

        getKaigoWelfareFacilityDinnerCost().setEnabled(true);

  }

  /**
   * �u�H���񋟁E�Ȃ��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_NOT_USE_MEAT() throws Exception {

        getKaigoWelfareFacilityDinnerCost().setEnabled(false);

  }

  /**
   * �u���j�b�g�P�A�̐��E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_UNIT_CARE() throws Exception {

        getKaigoWelfareFacilityUnitCareMaintenanceRadio().setEnabled(true);
        getKaigoWelfareFacilityUnitCareMaintenanceRadio().getParent().setEnabled(true);

  }

  /**
   * �u���j�b�g�P�A�̐��E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_UNIT_CARE() throws Exception {

        getKaigoWelfareFacilityUnitCareMaintenanceRadio().setEnabled(false);
        getKaigoWelfareFacilityUnitCareMaintenanceRadio().getParent().setEnabled(false);

  }

  /**
   * �u�Ŏ����E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_TERMINAL() throws Exception {

        getKaigoWelfareFacilityTakingCareNursingAddDays().setEnabled(true);

  }

  /**
   * �u�Ŏ����E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_TERMINAL() throws Exception {

        getKaigoWelfareFacilityTakingCareNursingAddDays().setEnabled(false);

  }

  /**
   * �u�o���ێ����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_KEEP_NUTRITION() throws Exception {

        getKaigoWelfareFacilityJunOralSwitchRadio().setEnabled(true);
        getKaigoWelfareFacilityJunOralSwitchRadio().getParent().setEnabled(true);

  }

  /**
   * �u�o���ێ����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_KEEP_NUTRITION() throws Exception {

        getKaigoWelfareFacilityJunOralSwitchRadio().setEnabled(false);
        getKaigoWelfareFacilityJunOralSwitchRadio().getParent().setEnabled(false);

  }

  /**
   * �u�����j�b�g�P�A�̐��E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_SUB_UNIT_CARE() throws Exception {

        getKaigoWelfareFacilityJunUnitCareAddRadio().setEnabled(true);
        getKaigoWelfareFacilityJunUnitCareAddRadio().getParent().setEnabled(true);

  }

  /**
   * �u�����j�b�g�P�A�̐��E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALLID_SUB_UNIT_CARE() throws Exception {

        getKaigoWelfareFacilityJunUnitCareAddRadio().setEnabled(false);
        getKaigoWelfareFacilityJunUnitCareAddRadio().getParent().setEnabled(false);

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
