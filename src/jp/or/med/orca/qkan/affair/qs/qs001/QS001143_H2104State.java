
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
 * �J����: �c���@����
 * �쐬��: 2009/03/16  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����\�h����{�ݓ����Ґ������ (QS001143_H2104)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.io.*;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import jp.nichicom.ac.*;
import jp.nichicom.ac.bind.*;
import jp.nichicom.ac.component.*;
import jp.nichicom.ac.component.dnd.*;
import jp.nichicom.ac.component.dnd.event.*;
import jp.nichicom.ac.component.event.*;
import jp.nichicom.ac.component.mainmenu.*;
import jp.nichicom.ac.component.table.*;
import jp.nichicom.ac.component.table.event.*;
import jp.nichicom.ac.container.*;
import jp.nichicom.ac.core.*;
import jp.nichicom.ac.filechooser.*;
import jp.nichicom.ac.io.*;
import jp.nichicom.ac.lang.*;
import jp.nichicom.ac.pdf.*;
import jp.nichicom.ac.sql.*;
import jp.nichicom.ac.text.*;
import jp.nichicom.ac.util.*;
import jp.nichicom.ac.util.adapter.*;
import jp.nichicom.vr.*;
import jp.nichicom.vr.bind.*;
import jp.nichicom.vr.bind.event.*;
import jp.nichicom.vr.border.*;
import jp.nichicom.vr.component.*;
import jp.nichicom.vr.component.event.*;
import jp.nichicom.vr.component.table.*;
import jp.nichicom.vr.container.*;
import jp.nichicom.vr.focus.*;
import jp.nichicom.vr.image.*;
import jp.nichicom.vr.io.*;
import jp.nichicom.vr.layout.*;
import jp.nichicom.vr.text.*;
import jp.nichicom.vr.text.parsers.*;
import jp.nichicom.vr.util.*;
import jp.nichicom.vr.util.adapter.*;
import jp.nichicom.vr.util.logging.*;
import jp.or.med.orca.qkan.*;
import jp.or.med.orca.qkan.affair.*;
import jp.or.med.orca.qkan.component.*;
/**
 * �T�[�r�X�p�^�[�����\�h����{�ݓ����Ґ�������Ԓ�`(QS001143_H2104) 
 */
public class QS001143_H2104State extends QS001143_H2104Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001143_H2104State(){
  }

  /**
   * �u��ʏ�ԂP�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_1() throws Exception {

        getOutsideServiceRadio().setEnabled(false);

        getSpecificFacilityBeginTime().setEnabled(false);

        getSpecificFacilityEndTime().setEnabled(false);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(true);

        getImpairedPersonHelpAddRadioGroup().setEnabled(false);

        getMedicalCoordinateAddRadioGroup().setEnabled(true);

  }

  /**
   * �u��ʏ�ԂQ�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_2() throws Exception {

        getOutsideServiceRadio().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);

        getVisitCareGroup().setEnabled(true);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);

  }

  /**
   * �u��ʏ�ԂR�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_3() throws Exception {

        getOutsideServiceRadio().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);

  }

  /**
   * �u��ʏ�ԂS�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_4() throws Exception {

        getOutsideServiceRadio().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(true);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);

  }

  /**
   * �u��ʏ�ԂT�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_5() throws Exception {

        getOutsideServiceRadio().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(true);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(true);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);

  }

  /**
   * �u��ʏ�ԂU�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_6() throws Exception {

        getOutsideServiceRadio().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(true);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);

  }

  /**
   * �u��ʏ�ԂV�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_7() throws Exception {

        getOutsideServiceRadio().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(true);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);

  }

  /**
   * �u��ʏ�ԂW�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_8() throws Exception {

        getOutsideServiceRadio().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(true);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);

  }

  /**
   * �u��ʏ�ԂX�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_9() throws Exception {

        getOutsideServiceRadio().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(true);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);

  }

  /**
   * �u��ʏ�ԂP�O�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_10() throws Exception {

        getOutsideServiceRadio().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(true);

        getDivisionRadion().setEnabled(true);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);

  }

  /**
   * �u��ʏ�ԂP�P�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_11() throws Exception {

        getOutsideServiceRadio().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(true);

        getDivisionRadion().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);

  }

  /**
   * �u�ʋ@�\�P���̐��E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INDIVIDUAL_FUNCTION_TRAINING_ENABLE_FALSE() throws Exception {

        getNinchishoTaioTsushoIndividualFunctionTrainingAddRadio().setEnabled(false);

  }

  /**
   * �u�ʋ@�\�P���̐��E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INDIVIDUAL_FUNCTION_TRAINING_ENABLE_TRUE() throws Exception {

        getNinchishoTaioTsushoIndividualFunctionTrainingAddRadio().setEnabled(true);

  }

}
