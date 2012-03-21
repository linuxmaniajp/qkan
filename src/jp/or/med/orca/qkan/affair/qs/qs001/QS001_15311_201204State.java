
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
 * �v���O���� �T�[�r�X�p�^�[�����×{�^��Î{�݁i�a�@�j (QS001_15311_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * �T�[�r�X�p�^�[�����×{�^��Î{�݁i�a�@�j��Ԓ�`(QS001_15311_201204) 
 */
public class QS001_15311_201204State extends QS001_15311_201204Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_15311_201204State(){
  }

  /**
   * �u�o���ڍs�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_NUTRITION() throws Exception {

        getMedicalFacilityHospitalOralSwitchRadio().setEnabled(true);
        getMedicalFacilityHospitalOralSwitchRadio().getParent().setEnabled(true);

  }

  /**
   * �u�o���ڍs�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_NUTRITION() throws Exception {

        getMedicalFacilityHospitalOralSwitchRadio().setEnabled(false);
        getMedicalFacilityHospitalOralSwitchRadio().getParent().setEnabled(false);

  }

  /**
   * �u�]���^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_CONVENTIONAL_FORM() throws Exception {

        getMedicalFacilityHospitalHospitalRoomRadio().setEnabled(true);

        getMedicalFacilityHospitalUnitHospitalRoomRadio().setEnabled(false);

        getUnitCareMaintenanceRadio().setEnabled(false);
        getUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getMedicalFacilityHospitalHospitalDivision().setEnabled(true);
        getMedicalFacilityHospitalHospitalDivision().getParent().setEnabled(true);

        getTrialHijoRadio().setEnabled(false);
        getTrialHijoRadio().getParent().setEnabled(false);

  }

  /**
   * �u���j�b�g�^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_UNIT_FORM() throws Exception {

        getMedicalFacilityHospitalHospitalRoomRadio().setEnabled(false);

        getMedicalFacilityHospitalUnitHospitalRoomRadio().setEnabled(true);

        getUnitCareMaintenanceRadio().setEnabled(true);
        getUnitCareMaintenanceRadio().getParent().setEnabled(true);

        getMedicalFacilityHospitalHospitalDivision().setEnabled(false);
        getMedicalFacilityHospitalHospitalDivision().getParent().setEnabled(false);

        getTrialHijoRadio().setEnabled(false);
        getTrialHijoRadio().getParent().setEnabled(false);

  }

  /**
   * �u�H���񋟁E����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_USE_MEAT() throws Exception {

        getMedicalFacilityDinnerCost().setEnabled(true);

  }

  /**
   * �u�H���񋟁E�Ȃ��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_NOT_USE_MEAT() throws Exception {

        getMedicalFacilityDinnerCost().setEnabled(false);

  }

  /**
   * �u�l�����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_SUBTRACTION() throws Exception {

        getMedicalFacilityHospitalDivision1().setEnabled(true);

        getMedicalFacilityHospitalDivision2().setEnabled(true);

        getMedicalFacilityHospitalDivision3().setEnabled(true);

  }

  /**
   * �u�l�����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_SUBTRACTION() throws Exception {

        getMedicalFacilityHospitalDivision1().setEnabled(false);

        getMedicalFacilityHospitalDivision2().setEnabled(false);

        getMedicalFacilityHospitalDivision3().setEnabled(true);

  }

  /**
   * �u�o���ێ����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_KEEP_NUTRITION() throws Exception {

        getOralMaintenanceRadio().setEnabled(true);
        getOralMaintenanceRadio().getParent().setEnabled(true);

  }

  /**
   * �u�o���ێ����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_KEEP_NUTRITION() throws Exception {

        getOralMaintenanceRadio().setEnabled(false);
        getOralMaintenanceRadio().getParent().setEnabled(false);

  }

  /**
   * �u���Ȏ�M�̗L���E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_TAKAJYUSIN() throws Exception {

        getMedicalFacilityHospitalMedicalExaminationRadio().setEnabled(true);
        getMedicalFacilityHospitalMedicalExaminationRadio().getParent().setEnabled(true);

  }

  /**
   * �u���Ȏ�M�̗L���E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_TAKAJYUSIN() throws Exception {

        getMedicalFacilityHospitalMedicalExaminationRadio().setEnabled(false);
        getMedicalFacilityHospitalMedicalExaminationRadio().getParent().setEnabled(false);

  }

  /**
   * �u�O�����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_GAIHAKU() throws Exception {

        getMedicalFacilityHospitalStayRadio().setEnabled(true);
        getMedicalFacilityHospitalStayRadio().getParent().setEnabled(true);

  }

  /**
   * �u�O�����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_GAIHAKU() throws Exception {

        getMedicalFacilityHospitalStayRadio().setEnabled(false);
        getMedicalFacilityHospitalStayRadio().getParent().setEnabled(false);

  }

  /**
   * �u�o�ߌ^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_PASSAGE_FORM() throws Exception {

        getMedicalFacilityHospitalHospitalRoomRadio().setEnabled(true);

        getMedicalFacilityHospitalUnitHospitalRoomRadio().setEnabled(false);

        getUnitCareMaintenanceRadio().setEnabled(false);
        getUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getMedicalFacilityHospitalHospitalDivision().setEnabled(true);
        getMedicalFacilityHospitalHospitalDivision().getParent().setEnabled(true);

        getTrialHijoRadio().setEnabled(true);
        getTrialHijoRadio().getParent().setEnabled(true);

  }

  /**
   * �u���s�I�މ@�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_TRIAL_HIJO() throws Exception {

        getTrialHijoRadio().setEnabled(true);
        getTrialHijoRadio().getParent().setEnabled(true);

  }

  /**
   * �u���s�I�މ@�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_TRIAL_HIJO() throws Exception {

        getTrialHijoRadio().setEnabled(false);
        getTrialHijoRadio().getParent().setEnabled(false);

  }

  /**
   * �u�l�����Z�E�����i�o�ߌ^_1�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_SUBTRACTION_3_ENABLE() throws Exception {

        getMedicalFacilityHospitalDivision1().setEnabled(true);

        getMedicalFacilityHospitalDivision2().setEnabled(true);

        getMedicalFacilityHospitalDivision3().setEnabled(false);

  }

  /**
   * �u�l�����Z�E�����i�o�ߌ^_2�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_SUBTRACTION_1_3_ENABLE() throws Exception {

        getMedicalFacilityHospitalDivision1().setEnabled(false);

        getMedicalFacilityHospitalDivision2().setEnabled(true);

        getMedicalFacilityHospitalDivision3().setEnabled(false);

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
