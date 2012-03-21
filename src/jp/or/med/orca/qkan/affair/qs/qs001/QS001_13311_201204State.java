
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
 * �v���Z�X �T�[�r�X�p�^�[������{�ݓ����Ґ������ (001)
 * �v���O���� �T�[�r�X�p�^�[������{�ݓ����Ґ������ (QS001_13311_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * �T�[�r�X�p�^�[������{�ݓ����Ґ�������Ԓ�`(QS001_13311_201204) 
 */
public class QS001_13311_201204State extends QS001_13311_201204Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_13311_201204State(){
  }

  /**
   * �u����{�ݓ����ґI�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SELECT_SPECIAL() throws Exception {

        getSpecificFacilityFunctionTrainingRadio().setEnabled(true);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(true);

        getNightNursingSystemRadio().setEnabled(true);
        getNightNursingSystemRadio().getParent().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getSpecificFacilityBeginTime().setEnabled(false);
        getSpecificFacilityBeginTime().getParent().setEnabled(false);

        getSpecificFacilityEndTime().setEnabled(false);
        getSpecificFacilityEndTime().getParent().setEnabled(false);

        getOutsideServiceRadio().setEnabled(false);
        getOutsideServiceRadio().getParent().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getMedicalCoordinateAddRadioGroup().setEnabled(true);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(true);

        getImpairedPersonHelpAddRadioGroup().setEnabled(false);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(false);

        getTerminalCareAddRadioGroup().setEnabled(true);
        getTerminalCareAddRadioGroup().getParent().setEnabled(true);

  }

  /**
   * �u�O���T�[�r�X���p�^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SELECT_OUT() throws Exception {

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(false);

        getNightNursingSystemRadio().setEnabled(false);
        getNightNursingSystemRadio().getParent().setEnabled(false);

        getVisitCareGroup().setEnabled(true);

        getVisitNursingRadioGroup().setEnabled(true);

        getVisitRehabiliGroup().setEnabled(true);

        getExpertPlaceNursingGroup().setEnabled(true);

        getExpertPlaceRehabiliGroup().setEnabled(true);

        getWelfareToolsGroup().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);
        getSpecificFacilityBeginTime().getParent().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);
        getSpecificFacilityEndTime().getParent().setEnabled(true);

        getOutsideServiceRadio().setEnabled(true);
        getOutsideServiceRadio().getParent().setEnabled(true);

        getNinchishoTaioTsushoGroup().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(true);

        getTerminalCareAddRadioGroup().setEnabled(false);
        getTerminalCareAddRadioGroup().getParent().setEnabled(false);

  }

  /**
   * �u�K����I�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SELECT_VISIT() throws Exception {

        getVisitCareGroup().setEnabled(true);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

  }

  /**
   * �u�K��Ō�I�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SELECT_VISIT_NURSING() throws Exception {

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(true);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

  }

  /**
   * �u�K�⃊�n�I�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SELECT_VISIT_REHABILI() throws Exception {

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(true);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

  }

  /**
   * �u�ʏ����I�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SELECT_EXPERTPLACE_NURSING() throws Exception {

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(true);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

  }

  /**
   * �u�ʏ����n�I�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SELECT_EXPERTPLACE_REHABILI() throws Exception {

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(true);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

  }

  /**
   * �u�����p��ݗ^�I�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SELECT_WELFARE_TOOLS() throws Exception {

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(true);

        getNinchishoTaioTsushoGroup().setEnabled(false);

  }

  /**
   * �u�K��������I���㎞�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SELECT_VISIT_BATH() throws Exception {

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

  }

  /**
   * �uPT�EOT�EST�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_STAFF_DIVISION_() throws Exception {

        getVisitNursingStaffDivisionRadioItem2().setEnabled(true);

  }

  /**
   * �uPT�EOT�EST�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_STAFF_DIVISION_() throws Exception {

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

  }

  /**
   * �u�F�m�ǑΉ��ʏ����E�{�݋敪�Q�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_NINTI_DIVISION() throws Exception {

        getDivisionRadion().setEnabled(true);
        getDivisionRadion().getParent().setEnabled(true);

  }

  /**
   * �u�F�m�ǑΉ��ʏ����E�{�݋敪�Q�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_NINTI_DIVISION() throws Exception {

        getDivisionRadion().setEnabled(false);
        getDivisionRadion().getParent().setEnabled(false);

  }

  /**
   * �u�F�m�ǑΉ��ʏ����I�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SELECT_NINTITUUSHO() throws Exception {

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(true);

  }

  /**
   * �u��{�P�ʂ̂ݑI�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SELECT_ONLY_BASE() throws Exception {

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

  }

  /**
   * �u��Ë@�֘A�g���Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_MEDICAL_COORDINATE() throws Exception {

        getMedicalCoordinateAddRadioGroup().setEnabled(true);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(true);

  }

  /**
   * �u��Ë@�֘A�g���Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_MEDICAL_COORDINATE() throws Exception {

        getMedicalCoordinateAddRadioGroup().setEnabled(false);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(false);

  }

  /**
   * �u��Q�ғ��x�����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_IMPAIRED_PERSON_HELP() throws Exception {

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(true);

  }

  /**
   * �u��Q�ғ��x�����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_IMPAIRED_PERSON_HELP() throws Exception {

        getImpairedPersonHelpAddRadioGroup().setEnabled(false);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(false);

  }

  /**
   * �u1����2����z���Ď��{�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_TWO_OR_MORE_TIMES() throws Exception {

        getTwoOrMoreTimesCheck().setEnabled(true);

        getVisitNursingCombo().setEnabled(false);

  }

  /**
   * �u1����2����z���Ď��{�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_TWO_OR_MORE_TIMES() throws Exception {

        getTwoOrMoreTimesCheck().setEnabled(false);

        getVisitNursingCombo().setEnabled(true);

  }

  /**
   * �u���ԋ敪�R���{�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_VISIT_CARE_COMBO() throws Exception {

        getVisitCareCombo().setEnabled(true);

  }

  /**
   * �u���ԋ敪�R���{�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_VISIT_CARE_COMBO() throws Exception {

        getVisitCareCombo().setEnabled(false);

  }

}
