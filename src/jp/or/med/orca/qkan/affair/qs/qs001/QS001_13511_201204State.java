
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
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����\�h����{�ݓ����Ґ������ (QS001_13511_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * �T�[�r�X�p�^�[�����\�h����{�ݓ����Ґ�������Ԓ�`(QS001_13511_201204) 
 */
public class QS001_13511_201204State extends QS001_13511_201204Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_13511_201204State(){
  }

  /**
   * �u��ʏ�ԂP�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_1() throws Exception {

        getOutsideServiceRadio().setEnabled(false);
        getOutsideServiceRadio().getParent().setEnabled(false);

        getSpecificFacilityBeginTime().setEnabled(false);
        getSpecificFacilityBeginTime().getParent().setEnabled(false);

        getSpecificFacilityEndTime().setEnabled(false);
        getSpecificFacilityEndTime().getParent().setEnabled(false);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);
        getDivisionRadion().getParent().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(true);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(true);

        getImpairedPersonHelpAddRadioGroup().setEnabled(false);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(false);

        getMedicalCoordinateAddRadioGroup().setEnabled(true);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(true);

        getVisitCarePrintable().setEnabled(false);

        getExpertPlaceNursingPrintable().setEnabled(false);

        getExpertPlaceRehabiliPrintable().setEnabled(false);

  }

  /**
   * �u��ʏ�ԂQ�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_2() throws Exception {

        getOutsideServiceRadio().setEnabled(true);
        getOutsideServiceRadio().getParent().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);
        getSpecificFacilityBeginTime().getParent().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);
        getSpecificFacilityEndTime().getParent().setEnabled(true);

        getVisitCareGroup().setEnabled(true);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);
        getDivisionRadion().getParent().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(false);

        getVisitCarePrintable().setEnabled(true);

        getExpertPlaceNursingPrintable().setEnabled(false);

        getExpertPlaceRehabiliPrintable().setEnabled(false);

  }

  /**
   * �u��ʏ�ԂR�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_3() throws Exception {

        getOutsideServiceRadio().setEnabled(true);
        getOutsideServiceRadio().getParent().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);
        getSpecificFacilityBeginTime().getParent().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);
        getSpecificFacilityEndTime().getParent().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);
        getDivisionRadion().getParent().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(false);

        getVisitCarePrintable().setEnabled(false);

        getExpertPlaceNursingPrintable().setEnabled(false);

        getExpertPlaceRehabiliPrintable().setEnabled(false);

  }

  /**
   * �u��ʏ�ԂS�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_4() throws Exception {

        getOutsideServiceRadio().setEnabled(true);
        getOutsideServiceRadio().getParent().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);
        getSpecificFacilityBeginTime().getParent().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);
        getSpecificFacilityEndTime().getParent().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(true);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);
        getDivisionRadion().getParent().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(false);

        getVisitCarePrintable().setEnabled(false);

        getExpertPlaceNursingPrintable().setEnabled(false);

        getExpertPlaceRehabiliPrintable().setEnabled(false);

  }

  /**
   * �u��ʏ�ԂT�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_5() throws Exception {

        getOutsideServiceRadio().setEnabled(true);
        getOutsideServiceRadio().getParent().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);
        getSpecificFacilityBeginTime().getParent().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);
        getSpecificFacilityEndTime().getParent().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(true);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(true);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);
        getDivisionRadion().getParent().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(false);

        getVisitCarePrintable().setEnabled(false);

        getExpertPlaceNursingPrintable().setEnabled(false);

        getExpertPlaceRehabiliPrintable().setEnabled(false);

  }

  /**
   * �u��ʏ�ԂU�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_6() throws Exception {

        getOutsideServiceRadio().setEnabled(true);
        getOutsideServiceRadio().getParent().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);
        getSpecificFacilityBeginTime().getParent().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);
        getSpecificFacilityEndTime().getParent().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(true);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);
        getDivisionRadion().getParent().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(false);

        getVisitCarePrintable().setEnabled(false);

        getExpertPlaceNursingPrintable().setEnabled(false);

        getExpertPlaceRehabiliPrintable().setEnabled(false);

  }

  /**
   * �u��ʏ�ԂV�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_7() throws Exception {

        getOutsideServiceRadio().setEnabled(true);
        getOutsideServiceRadio().getParent().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);
        getSpecificFacilityBeginTime().getParent().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);
        getSpecificFacilityEndTime().getParent().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(true);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);
        getDivisionRadion().getParent().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(false);

        getVisitCarePrintable().setEnabled(false);

        getExpertPlaceNursingPrintable().setEnabled(true);

        getExpertPlaceRehabiliPrintable().setEnabled(false);

  }

  /**
   * �u��ʏ�ԂW�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_8() throws Exception {

        getOutsideServiceRadio().setEnabled(true);
        getOutsideServiceRadio().getParent().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);
        getSpecificFacilityBeginTime().getParent().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);
        getSpecificFacilityEndTime().getParent().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(true);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);
        getDivisionRadion().getParent().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(false);

        getVisitCarePrintable().setEnabled(false);

        getExpertPlaceNursingPrintable().setEnabled(false);

        getExpertPlaceRehabiliPrintable().setEnabled(true);

  }

  /**
   * �u��ʏ�ԂX�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_9() throws Exception {

        getOutsideServiceRadio().setEnabled(true);
        getOutsideServiceRadio().getParent().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);
        getSpecificFacilityBeginTime().getParent().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);
        getSpecificFacilityEndTime().getParent().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(true);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);
        getDivisionRadion().getParent().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(false);

        getVisitCarePrintable().setEnabled(false);

        getExpertPlaceNursingPrintable().setEnabled(false);

        getExpertPlaceRehabiliPrintable().setEnabled(false);

  }

  /**
   * �u��ʏ�ԂP�O�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_10() throws Exception {

        getOutsideServiceRadio().setEnabled(true);
        getOutsideServiceRadio().getParent().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);
        getSpecificFacilityBeginTime().getParent().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);
        getSpecificFacilityEndTime().getParent().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(true);

        getDivisionRadion().setEnabled(true);
        getDivisionRadion().getParent().setEnabled(true);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(false);

        getVisitCarePrintable().setEnabled(false);

        getExpertPlaceNursingPrintable().setEnabled(false);

        getExpertPlaceRehabiliPrintable().setEnabled(false);

  }

  /**
   * �u��ʏ�ԂP�P�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_11() throws Exception {

        getOutsideServiceRadio().setEnabled(true);
        getOutsideServiceRadio().getParent().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);
        getSpecificFacilityBeginTime().getParent().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);
        getSpecificFacilityEndTime().getParent().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(true);

        getDivisionRadion().setEnabled(false);
        getDivisionRadion().getParent().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(false);

        getVisitCarePrintable().setEnabled(false);

        getExpertPlaceNursingPrintable().setEnabled(false);

        getExpertPlaceRehabiliPrintable().setEnabled(false);

  }

  /**
   * �u�K����E�����E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DAY_CHECK_VISIT_CARE_ON() throws Exception {

        getVisitCarePrintable().setEnabled(true);

  }

  /**
   * �u�K����E�����E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DAY_CHECK_VISIT_CARE_OFF() throws Exception {

        getVisitCarePrintable().setEnabled(false);

  }

  /**
   * �u�ʏ����E�����E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DAY_CHECK_NURSING_ON() throws Exception {

        getExpertPlaceNursingPrintable().setEnabled(true);

  }

  /**
   * �u�ʏ����E�����E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DAY_CHECK_NURSING_OFF() throws Exception {

        getExpertPlaceNursingPrintable().setEnabled(false);

  }

  /**
   * �u�ʏ����n�E�����E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DAY_CHECK_REHABILI_ON() throws Exception {

        getExpertPlaceRehabiliPrintable().setEnabled(true);

  }

  /**
   * �u�ʏ����n�E�����E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DAY_CHECK_REHABILI_OFF() throws Exception {

        getExpertPlaceRehabiliPrintable().setEnabled(false);

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

}
