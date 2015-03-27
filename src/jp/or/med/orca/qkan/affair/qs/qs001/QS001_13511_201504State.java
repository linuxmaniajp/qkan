
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
 * �쐬��: 2015/02/27  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����\�h����{�ݓ����Ґ������ (QS001_13511_201504)
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
 * �T�[�r�X�p�^�[�����\�h����{�ݓ����Ґ�������Ԓ�`(QS001_13511_201504) 
 */
public class QS001_13511_201504State extends QS001_13511_201504Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_13511_201504State(){
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

        getVisitCareServiceGroup().setEnabled(false);

        getExpertPlaceNursingServiceGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);
        getDivisionRadion().getParent().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(true);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(true);

        getImpairedPersonHelpAddRadioGroup().setEnabled(false);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(false);

        getMedicalCoordinateAddRadioGroup().setEnabled(true);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(true);

        getDementiaProfessionalCareAddRadioGroup().setEnabled(true);
        getDementiaProfessionalCareAddRadioGroup().getParent().setEnabled(true);

        getVisitCarePrintable().setEnabled(false);

        getExpertPlaceNursingPrintable().setEnabled(false);

        getExpertPlaceRehabiliPrintable().setEnabled(false);

        getVisitCareServicePrintable().setEnabled(false);

        getExpertPlaceNursingServicePrintable().setEnabled(false);

  }

  /**
   * �u��ʏ�ԂQ�K����v�̏�Ԃɐݒ肵�܂��B
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

        getVisitCareServiceGroup().setEnabled(false);

        getExpertPlaceNursingServiceGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);
        getDivisionRadion().getParent().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(false);

        getDementiaProfessionalCareAddRadioGroup().setEnabled(false);
        getDementiaProfessionalCareAddRadioGroup().getParent().setEnabled(false);

        getVisitCarePrintable().setEnabled(true);

        getExpertPlaceNursingPrintable().setEnabled(false);

        getExpertPlaceRehabiliPrintable().setEnabled(false);

        getVisitCareServicePrintable().setEnabled(false);

        getExpertPlaceNursingServicePrintable().setEnabled(false);

  }

  /**
   * �u��ʏ�ԂR�K������v�̏�Ԃɐݒ肵�܂��B
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

        getVisitCareServiceGroup().setEnabled(false);

        getExpertPlaceNursingServiceGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);
        getDivisionRadion().getParent().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(false);

        getDementiaProfessionalCareAddRadioGroup().setEnabled(false);
        getDementiaProfessionalCareAddRadioGroup().getParent().setEnabled(false);

        getVisitCarePrintable().setEnabled(false);

        getExpertPlaceNursingPrintable().setEnabled(false);

        getExpertPlaceRehabiliPrintable().setEnabled(false);

        getVisitCareServicePrintable().setEnabled(false);

        getExpertPlaceNursingServicePrintable().setEnabled(false);

  }

  /**
   * �u��ʏ�ԂS�K��Ō�v�̏�Ԃɐݒ肵�܂��B
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

        getVisitCareServiceGroup().setEnabled(false);

        getExpertPlaceNursingServiceGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);
        getDivisionRadion().getParent().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(false);

        getDementiaProfessionalCareAddRadioGroup().setEnabled(false);
        getDementiaProfessionalCareAddRadioGroup().getParent().setEnabled(false);

        getVisitCarePrintable().setEnabled(false);

        getExpertPlaceNursingPrintable().setEnabled(false);

        getExpertPlaceRehabiliPrintable().setEnabled(false);

        getVisitCareServicePrintable().setEnabled(false);

        getExpertPlaceNursingServicePrintable().setEnabled(false);

  }

  /**
   * �u��ʏ�ԂT�K��Ō�v�̏�Ԃɐݒ肵�܂��B
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

        getVisitCareServiceGroup().setEnabled(false);

        getExpertPlaceNursingServiceGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);
        getDivisionRadion().getParent().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(false);

        getDementiaProfessionalCareAddRadioGroup().setEnabled(false);
        getDementiaProfessionalCareAddRadioGroup().getParent().setEnabled(false);

        getVisitCarePrintable().setEnabled(false);

        getExpertPlaceNursingPrintable().setEnabled(false);

        getExpertPlaceRehabiliPrintable().setEnabled(false);

        getVisitCareServicePrintable().setEnabled(false);

        getExpertPlaceNursingServicePrintable().setEnabled(false);

  }

  /**
   * �u��ʏ�ԂU�K�⃊�n�v�̏�Ԃɐݒ肵�܂��B
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

        getVisitCareServiceGroup().setEnabled(false);

        getExpertPlaceNursingServiceGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);
        getDivisionRadion().getParent().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(false);

        getDementiaProfessionalCareAddRadioGroup().setEnabled(false);
        getDementiaProfessionalCareAddRadioGroup().getParent().setEnabled(false);

        getVisitCarePrintable().setEnabled(false);

        getExpertPlaceNursingPrintable().setEnabled(false);

        getExpertPlaceRehabiliPrintable().setEnabled(false);

        getVisitCareServicePrintable().setEnabled(false);

        getExpertPlaceNursingServicePrintable().setEnabled(false);

  }

  /**
   * �u��ʏ�ԂV�ʏ����v�̏�Ԃɐݒ肵�܂��B
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

        getVisitCareServiceGroup().setEnabled(false);

        getExpertPlaceNursingServiceGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);
        getDivisionRadion().getParent().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(false);

        getDementiaProfessionalCareAddRadioGroup().setEnabled(false);
        getDementiaProfessionalCareAddRadioGroup().getParent().setEnabled(false);

        getVisitCarePrintable().setEnabled(false);

        getExpertPlaceNursingPrintable().setEnabled(true);

        getExpertPlaceRehabiliPrintable().setEnabled(false);

        getVisitCareServicePrintable().setEnabled(false);

        getExpertPlaceNursingServicePrintable().setEnabled(false);

  }

  /**
   * �u��ʏ�ԂW�ʏ����n�v�̏�Ԃɐݒ肵�܂��B
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

        getVisitCareServiceGroup().setEnabled(false);

        getExpertPlaceNursingServiceGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);
        getDivisionRadion().getParent().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(false);

        getDementiaProfessionalCareAddRadioGroup().setEnabled(false);
        getDementiaProfessionalCareAddRadioGroup().getParent().setEnabled(false);

        getVisitCarePrintable().setEnabled(false);

        getExpertPlaceNursingPrintable().setEnabled(false);

        getExpertPlaceRehabiliPrintable().setEnabled(true);

        getVisitCareServicePrintable().setEnabled(false);

        getExpertPlaceNursingServicePrintable().setEnabled(false);

  }

  /**
   * �u��ʏ�ԂX�����p��v�̏�Ԃɐݒ肵�܂��B
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

        getVisitCareServiceGroup().setEnabled(false);

        getExpertPlaceNursingServiceGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);
        getDivisionRadion().getParent().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(false);

        getDementiaProfessionalCareAddRadioGroup().setEnabled(false);
        getDementiaProfessionalCareAddRadioGroup().getParent().setEnabled(false);

        getVisitCarePrintable().setEnabled(false);

        getExpertPlaceNursingPrintable().setEnabled(false);

        getExpertPlaceRehabiliPrintable().setEnabled(false);

        getVisitCareServicePrintable().setEnabled(false);

        getExpertPlaceNursingServicePrintable().setEnabled(false);

  }

  /**
   * �u��ʏ�ԂP�O�F�m�ǁv�̏�Ԃɐݒ肵�܂��B
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

        getVisitCareServiceGroup().setEnabled(false);

        getExpertPlaceNursingServiceGroup().setEnabled(false);

        getDivisionRadion().setEnabled(true);
        getDivisionRadion().getParent().setEnabled(true);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(false);

        getDementiaProfessionalCareAddRadioGroup().setEnabled(false);
        getDementiaProfessionalCareAddRadioGroup().getParent().setEnabled(false);

        getVisitCarePrintable().setEnabled(false);

        getExpertPlaceNursingPrintable().setEnabled(false);

        getExpertPlaceRehabiliPrintable().setEnabled(false);

        getVisitCareServicePrintable().setEnabled(false);

        getExpertPlaceNursingServicePrintable().setEnabled(false);

  }

  /**
   * �u��ʏ�ԂP�P�F�m�ǁv�̏�Ԃɐݒ肵�܂��B
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

        getVisitCareServiceGroup().setEnabled(false);

        getExpertPlaceNursingServiceGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);
        getDivisionRadion().getParent().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(false);

        getDementiaProfessionalCareAddRadioGroup().setEnabled(false);
        getDementiaProfessionalCareAddRadioGroup().getParent().setEnabled(false);

        getVisitCarePrintable().setEnabled(false);

        getExpertPlaceNursingPrintable().setEnabled(false);

        getExpertPlaceRehabiliPrintable().setEnabled(false);

        getVisitCareServicePrintable().setEnabled(false);

        getExpertPlaceNursingServicePrintable().setEnabled(false);

  }

  /**
   * �u��ʏ��1�Q�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_12() throws Exception {

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

        getVisitCareServiceGroup().setEnabled(true);

        getExpertPlaceNursingServiceGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);
        getDivisionRadion().getParent().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(false);

        getDementiaProfessionalCareAddRadioGroup().setEnabled(false);
        getDementiaProfessionalCareAddRadioGroup().getParent().setEnabled(false);

        getVisitCarePrintable().setEnabled(false);

        getExpertPlaceNursingPrintable().setEnabled(false);

        getExpertPlaceRehabiliPrintable().setEnabled(false);

        getVisitCareServicePrintable().setEnabled(true);

        getExpertPlaceNursingServicePrintable().setEnabled(false);

  }

  /**
   * �u��ʏ�ԂP�R�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_13() throws Exception {

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

        getVisitCareServiceGroup().setEnabled(false);

        getExpertPlaceNursingServiceGroup().setEnabled(true);

        getDivisionRadion().setEnabled(false);
        getDivisionRadion().getParent().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(false);

        getDementiaProfessionalCareAddRadioGroup().setEnabled(false);
        getDementiaProfessionalCareAddRadioGroup().getParent().setEnabled(false);

        getVisitCarePrintable().setEnabled(false);

        getExpertPlaceNursingPrintable().setEnabled(false);

        getExpertPlaceRehabiliPrintable().setEnabled(false);

        getVisitCareServicePrintable().setEnabled(false);

        getExpertPlaceNursingServicePrintable().setEnabled(true);

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

  /**
   * �u�K��^�T�[�r�X�E�����E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DAY_CHECK_VISIT_CARE_SERVICE_ON() throws Exception {

        getVisitCareServicePrintable().setEnabled(true);

  }

  /**
   * �u�K��^�T�[�r�X�E�����E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DAY_CHECK_VISIT_CARE_SERVICE_OFF() throws Exception {

        getVisitCareServicePrintable().setEnabled(false);

  }

  /**
   * �u�ʏ��^�T�[�r�X�E�����E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DAY_CHECK_NURSING_SERVICE_ON() throws Exception {

        getExpertPlaceNursingServicePrintable().setEnabled(true);

  }

  /**
   * �u�ʏ��^�T�[�r�X�E�����E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DAY_CHECK_NURSING_SERVICE_OFF() throws Exception {

        getExpertPlaceNursingServicePrintable().setEnabled(false);

  }

  /**
   * �u�Ō�E���敪�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_NURSE_STAFF_DIVISION() throws Exception {

        getNurseStaffDivisionRadioGroup().setEnabled(true);
        getNurseStaffDivisionRadioGroup().getParent().setEnabled(true);

  }

  /**
   * �u�Ō�E���敪�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_NURSE_STAFF_DIVISION() throws Exception {

        getNurseStaffDivisionRadioGroup().setEnabled(false);
        getNurseStaffDivisionRadioGroup().getParent().setEnabled(false);

  }

}
