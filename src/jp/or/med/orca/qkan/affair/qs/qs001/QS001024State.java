
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
 * �J����: �� ����
 * �쐬��: 2006/01/27  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�p�^�[�����×{�^��Î{�݁i�f�Ï��j (001)
 * �v���O���� �T�[�r�X�p�^�[�����×{�^��Î{�݁i�f�Ï��j (QS001024)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * �T�[�r�X�p�^�[�����×{�^��Î{�݁i�f�Ï��j��Ԓ�`(QS001024) 
 */
public class QS001024State extends QS001024Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001024State(){
  }

  /**
   * �u�h�{�Ǘ��E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_VALID_DIETICIAN_MANAGE() throws Exception {

        getMedicalFacilityClinicNutritionManageRadio().setEnabled(true);

  }

  /**
   * �u�h�{�Ǘ��E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_INVALID_DIETICIAN_MANAGE() throws Exception {

        getMedicalFacilityClinicNutritionManageRadio().setEnabled(false);

  }

  /**
   * �u�h�{�}�l�W�����g�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_VALID_MANAGE() throws Exception {

        getMedicalFacilityClinicNutritionRadio().setEnabled(true);

  }

  /**
   * �u�h�{�}�l�W�����g�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_INVALID_MANAGE() throws Exception {

        getMedicalFacilityClinicNutritionRadio().setEnabled(false);

  }

  /**
   * �u�o���ڍs�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_VALID_NUTRITION() throws Exception {

        getMedicalFacilityClinicOralSwitchRadio().setEnabled(true);

  }

  /**
   * �u�o���ڍs�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_INVALID_NUTRITION() throws Exception {

        getMedicalFacilityClinicOralSwitchRadio().setEnabled(false);

  }

  /**
   * �u�×{�H�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_VALID_MEDICAL_EXPENSES() throws Exception {

        getMedicalFacilityClinicRecuperateDinnerRadio().setEnabled(true);

  }

  /**
   * �u�×{�H�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_INVALID_MEDICAL_EXPENSES() throws Exception {

        getMedicalFacilityClinicRecuperateDinnerRadio().setEnabled(false);

  }

  /**
   * �u�]���^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_CONVENTIONAL_FORM() throws Exception {

        getMedicalFacilityClinicHospitalRoomRadio().setEnabled(true);

        getMedicalFacilityClinicUnitHospitalRoomRadio().setEnabled(false);

  }

  /**
   * �u���j�b�g�^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_UNIT_FORM() throws Exception {

        getMedicalFacilityClinicHospitalRoomRadio().setEnabled(false);

        getMedicalFacilityClinicUnitHospitalRoomRadio().setEnabled(true);

  }

  /**
   * �u�H���񋟁E����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_USE_MEAT() throws Exception {

        getMedicalFacilityClinicDinnerCost().setEnabled(true);

  }

  /**
   * �u�H���񋟁E�Ȃ��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_NOT_USE_MEAT() throws Exception {

        getMedicalFacilityClinicDinnerCost().setEnabled(false);

  }

}
