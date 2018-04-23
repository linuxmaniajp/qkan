
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
 * �쐬��: 2018/03/06  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[����앟���{�� (QS001_15111_201804)
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
import jp.or.med.orca.qkan.text.*;
/**
 * �T�[�r�X�p�^�[����앟���{�݉�ʍ��ڃf�U�C��(QS001_15111_201804) 
 */
public class QS001_15111_201804Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityInstitutionDivisionRadio;

  private ACLabelContainer kaigoWelfareFacilityInstitutionDivisionRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityInstitutionDivisionRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityInstitutionDivisionRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityInstitutionDivisionRadioItem2;

  private ACRadioButtonItem kaigoWelfareFacilityInstitutionDivisionRadioItem3;

  private ACRadioButtonItem kaigoWelfareFacilityInstitutionDivisionRadioItem4;

  private ACLabelContainer kaigoWelfareFacilityHospitalRoomDivisionContena;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityHospitalRoomDivisionRadio;

  private ACListModelAdapter kaigoWelfareFacilityHospitalRoomDivisionRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityHospitalRoomDivisionRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityHospitalRoomDivisionRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityUnitHospitalRoomDivisionRadio;

  private ACListModelAdapter kaigoWelfareFacilityUnitHospitalRoomDivisionRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityUnitCareMaintenanceRadio;

  private ACLabelContainer kaigoWelfareFacilityUnitCareMaintenanceRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityUnitCareMaintenanceRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityUnitCareMaintenanceRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityUnitCareMaintenanceRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityJunUnitCareAddRadio;

  private ACLabelContainer kaigoWelfareFacilityJunUnitCareAddRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityJunUnitCareAddRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityJunUnitCareAddRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityJunUnitCareAddRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityNightShiftSubtractionRadio;

  private ACLabelContainer kaigoWelfareFacilityNightShiftSubtractionRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityNightShiftSubtractionRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityNightShiftSubtractionRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityNightShiftSubtractionRadioItem2;

  private ACValueArrayRadioButtonGroup dailyLifeContinuanceRadioGroup;

  private ACLabelContainer dailyLifeContinuanceRadioGroupContainer;

  private ACListModelAdapter dailyLifeContinuanceRadioGroupModel;

  private ACRadioButtonItem dailyLifeContinuanceRadioItem1;

  private ACRadioButtonItem dailyLifeContinuanceRadioItem2;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityFunctionTrainingRadio;

  private ACLabelContainer kaigoWelfareFacilityFunctionTrainingRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityFunctionTrainingRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityFunctionTrainingRadioItem2;

  private ACRadioButtonItem kaigoWelfareFacilityFunctionTrainingRadioItem1;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityHandicappedRadio;

  private ACLabelContainer kaigoWelfareFacilityHandicappedRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityHandicappedRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityHandicappedRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityHandicappedRadioItem2;

  private ACRadioButtonItem kaigoWelfareFacilityHandicappedRadioItem3;

  private ACLabelContainer nurseStructuralAddGroup;

  private ACIntegerCheckBox nurseStructuralAddCheckItem1;

  private ACIntegerCheckBox nurseStructuralAddCheckItem2;

  private ACValueArrayRadioButtonGroup nightStaffDispositionAddRadioGroup;

  private ACLabelContainer nightStaffDispositionAddRadioGroupContainer;

  private ACListModelAdapter nightStaffDispositionAddRadioGroupModel;

  private ACRadioButtonItem nightStaffDispositionAddRadioItem1;

  private ACRadioButtonItem nightStaffDispositionAddRadioItem2;

  private ACRadioButtonItem nightStaffDispositionAddRadioItem3;

  private ACValueArrayRadioButtonGroup stayPeopleCountRadioGroup;

  private ACLabelContainer stayPeopleCountRadioGroupContainer;

  private ACListModelAdapter stayPeopleCountRadioGroupModel;

  private ACRadioButtonItem stayPeopleCountRadioItem1;

  private ACRadioButtonItem stayPeopleCountRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityFacilityFulltimeDoctorRadio;

  private ACLabelContainer kaigoWelfareFacilityFacilityFulltimeDoctorRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityFacilityFulltimeDoctorRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityPsychiatristRadio;

  private ACLabelContainer kaigoWelfareFacilityPsychiatristRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityPsychiatristRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityPsychiatristRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityPsychiatristRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityStayingOutOvernightCostRadio;

  private ACLabelContainer kaigoWelfareFacilityStayingOutOvernightCostRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityStayingOutOvernightCostRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityStayingOutOvernightCostRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityStayingOutOvernightCostRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityDefaultRadio;

  private ACLabelContainer kaigoWelfareFacilityDefaultRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityDefaultRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityDefaultRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityDefaultRadioItem2;

  private ACPanel tab3;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityNutritionRadio;

  private ACLabelContainer kaigoWelfareFacilityNutritionRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityNutritionRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityNutritionRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityNutritionRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityOralSwitchRadio;

  private ACLabelContainer kaigoWelfareFacilityOralSwitchRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityOralSwitchRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityOralSwitchRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityOralSwitchRadioItem2;

  private ACLabelContainer oralMaintenanceAddContainer;

  private ACValueArrayRadioButtonGroup oralMaintenanceAdd;

  private ACListModelAdapter oralMaintenanceAddModel;

  private ACRadioButtonItem oralMaintenanceAddItem1;

  private ACRadioButtonItem oralMaintenanceAddItem2;

  private ACIntegerCheckBox oralMaintenanceAddItem3;

  private ACValueArrayRadioButtonGroup oralKeepStructureAddRadioGroup;

  private ACLabelContainer oralKeepStructureAddRadioGroupContainer;

  private ACListModelAdapter oralKeepStructureAddRadioGroupModel;

  private ACRadioButtonItem oralKeepStructureAddRadioItem1;

  private ACRadioButtonItem oralKeepStructureAddRadioItem2;

  private ACValueArrayRadioButtonGroup oralKeepAddRadioGroup;

  private ACLabelContainer oralKeepAddRadioGroupContainer;

  private ACListModelAdapter oralKeepAddRadioGroupModel;

  private ACRadioButtonItem oralKeepAddRadioItem1;

  private ACRadioButtonItem oralKeepAddRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityRecuperateDinnerRadio;

  private ACLabelContainer kaigoWelfareFacilityRecuperateDinnerRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityRecuperateDinnerRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityRecuperateDinnerRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityRecuperateDinnerRadioItem2;

  private ACRadioButtonItem kaigoWelfareFacilityRecuperateDinnerRadioItem3;

  private ACRadioButtonItem kaigoWelfareFacilityRecuperateDinnerRadioItem4;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACLabelContainer kaigoWelfareFacilityHijoAddition;

  private ACIntegerCheckBox hijoPreConsultationAddition;

  private ACIntegerCheckBox hijoAfterConsultationAddition;

  private ACIntegerCheckBox hijoConsultationAddition;

  private ACIntegerCheckBox hijoCooperationAddition;

  private ACPanel tab4;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityStaffSubtraction;

  private ACLabelContainer kaigoWelfareFacilityStaffSubtractionContainer;

  private ACListModelAdapter kaigoWelfareFacilityStaffSubtractionModel;

  private ACRadioButtonItem kaigoWelfareFacilityStaffSubtractionCapacityNot;

  private ACRadioButtonItem kaigoWelfareFacilityStaffSubtractionCapacityExcess;

  private ACRadioButtonItem kaigoWelfareFacilityStaffSubtractionPersonLack;

  private ACBackLabelContainer kaigoWelfareFacilityDinnerContainer;

  private ACComboBox kaigoWelfareFacilityDinnerOffer;

  private ACLabelContainer kaigoWelfareFacilityDinnerOfferContainer;

  private ACComboBoxModelAdapter kaigoWelfareFacilityDinnerOfferModel;

  private ACTextField kaigoWelfareFacilityDinnerCost;

  private ACLabelContainer kaigoWelfareFacilityDinnerCostContainer;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityBodyRestraintAbolitionRadio;

  private ACLabelContainer kaigoWelfareFacilityBodyRestraintAbolitionRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityBodyRestraintAbolitionRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityBodyRestraintAbolitionRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityBodyRestraintAbolitionRadioItem2;

  private ACLabelContainer kaigoWelfareFacilityTakingCareNursingAddDaysContainer2;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityTakingCareNursingPtn;

  private ACListModelAdapter kaigoWelfareFacilityTakingCareNursingPtnModel;

  private ACRadioButtonItem kaigoWelfareFacilityTakingCareNursingPtnItem1;

  private ACRadioButtonItem kaigoWelfareFacilityTakingCareNursingPtnItem2;

  private ACRadioButtonItem kaigoWelfareFacilityTakingCareNursingPtnItem3;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityTakingCareNursingAddRadio;

  private ACListModelAdapter kaigoWelfareFacilityTakingCareNursingAddRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityTakingCareNursingAddRadioItem2;

  private ACRadioButtonItem kaigoWelfareFacilityTakingCareNursingAddRadioItem3;

  private ACRadioButtonItem kaigoWelfareFacilityTakingCareNursingAddRadioItem4;

  private ACLabelContainer kaigoWelfareFacilityTakingCareNursingAddDaysContainer;

  private ACTextField kaigoWelfareFacilityTakingCareNursingAddDays;

  private ACLabel kaigoWelfareFacilityTakingCareNursingAddDaysUnit;

  private ACPanel tab5;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityStayReturnSupportAddRadio;

  private ACLabelContainer kaigoWelfareFacilityStayReturnSupportAddRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityStayReturnSupportAddRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityStayReturnSupportAddRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityStayReturnSupportAddRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityHomeShareAddRadio;

  private ACLabelContainer kaigoWelfareFacilityHomeShareAddRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityHomeShareAddRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityHomeShareAddRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityHomeShareAddRadioItem2;

  private ACValueArrayRadioButtonGroup dementiaProfessionalCareAddRadioGroup;

  private ACLabelContainer dementiaProfessionalCareAddRadioGroupContainer;

  private ACListModelAdapter dementiaProfessionalCareAddRadioGroupModel;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem1;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem2;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem3;

  private ACValueArrayRadioButtonGroup dementiaEmergencyAddRadioGroup;

  private ACLabelContainer dementiaEmergencyAddRadioGroupContainer;

  private ACListModelAdapter dementiaEmergencyAddRadioGroupModel;

  private ACRadioButtonItem dementiaEmergencyAddRadioItem1;

  private ACRadioButtonItem dementiaEmergencyAddRadioItem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem5;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACValueArrayRadioButtonGroup improvementCollaboration;

  private ACLabelContainer improvementCollaborationContainer;

  private ACListModelAdapter improvementCollaborationModel;

  private ACRadioButtonItem improvementCollaborationItem1;

  private ACRadioButtonItem improvementCollaborationItem2;

  private ACValueArrayRadioButtonGroup homeServiceUsageFeeAtHome;

  private ACLabelContainer homeServiceUsageFeeAtHomeContainer;

  private ACListModelAdapter homeServiceUsageFeeAtHomeModel;

  private ACRadioButtonItem homeServiceUsageFeeAtHomeItem1;

  private ACRadioButtonItem homeServiceUsageFeeAtHomeItem2;

  private ACValueArrayRadioButtonGroup reEntryNutritionCooperationAdd;

  private ACLabelContainer reEntryNutritionCooperationAddContainer;

  private ACListModelAdapter reEntryNutritionCooperationAddModel;

  private ACRadioButtonItem reEntryNutritionCooperationAddItem1;

  private ACRadioButtonItem reEntryNutritionCooperationAddItem2;

  private ACValueArrayRadioButtonGroup lowNutritionalRiskImprovementAdd;

  private ACLabelContainer lowNutritionalRiskImprovementAddContainer;

  private ACListModelAdapter lowNutritionalRiskImprovementAddModel;

  private ACRadioButtonItem lowNutritionalRiskImprovementAddItem1;

  private ACRadioButtonItem lowNutritionalRiskImprovementAddItem2;

  private ACPanel tab6;

  private ACValueArrayRadioButtonGroup placementPhysicianEmergencyResponseAdd;

  private ACLabelContainer placementPhysicianEmergencyResponseAddContainer;

  private ACListModelAdapter placementPhysicianEmergencyResponseAddModel;

  private ACRadioButtonItem placementPhysicianEmergencyResponseItem1;

  private ACRadioButtonItem placementPhysicianEmergencyResponseItem2;

  private ACRadioButtonItem placementPhysicianEmergencyResponseItem3;

  private ACValueArrayRadioButtonGroup pressureSoresManagement;

  private ACLabelContainer pressureSoresManagementContainer;

  private ACListModelAdapter pressureSoresManagementModel;

  private ACRadioButtonItem pressureSoresManagementItem1;

  private ACRadioButtonItem pressureSoresManagementItem2;

  private ACValueArrayRadioButtonGroup excretionSupport;

  private ACLabelContainer excretionSupportContainer;

  private ACListModelAdapter excretionSupportModel;

  private ACRadioButtonItem excretionSupportItem1;

  private ACRadioButtonItem excretionSupportItem2;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityCalculationDivisionRadilo;

  private ACLabelContainer kaigoWelfareFacilityCalculationDivisionRadiloContainer;

  private ACListModelAdapter kaigoWelfareFacilityCalculationDivisionRadiloModel;

  private ACRadioButtonItem kaigoWelfareFacilityCalculationDivisionRadiloItem1;

  private ACRadioButtonItem kaigoWelfareFacilityCalculationDivisionRadiloItem2;

  //getter

  /**
   * �^�u�y�C�����擾���܂��B
   * @return �^�u�y�C��
   */
  public JTabbedPane getTabs(){
    if(tabs==null){

      tabs = new JTabbedPane();

      addTabs();
    }
    return tabs;

  }

  /**
   * �^�u1���擾���܂��B
   * @return �^�u1
   */
  public ACPanel getTab1(){
    if(tab1==null){

      tab1 = new ACPanel();

      tab1.setFollowChildEnabled(true);

      tab1.setHgap(0);

      addTab1();
    }
    return tab1;

  }

  /**
   * �{�ݓ��̋敪���擾���܂��B
   * @return �{�ݓ��̋敪
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityInstitutionDivisionRadio(){
    if(kaigoWelfareFacilityInstitutionDivisionRadio==null){

      kaigoWelfareFacilityInstitutionDivisionRadio = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityInstitutionDivisionRadioContainer().setText("�{�ݓ��̋敪");

      kaigoWelfareFacilityInstitutionDivisionRadio.setBindPath("1510101");

      kaigoWelfareFacilityInstitutionDivisionRadio.setUseClearButton(false);

      kaigoWelfareFacilityInstitutionDivisionRadio.setModel(getKaigoWelfareFacilityInstitutionDivisionRadioModel());

      kaigoWelfareFacilityInstitutionDivisionRadio.setValues(new int[]{1,2,3,4});

      addKaigoWelfareFacilityInstitutionDivisionRadio();
    }
    return kaigoWelfareFacilityInstitutionDivisionRadio;

  }

  /**
   * �{�ݓ��̋敪�R���e�i���擾���܂��B
   * @return �{�ݓ��̋敪�R���e�i
   */
  protected ACLabelContainer getKaigoWelfareFacilityInstitutionDivisionRadioContainer(){
    if(kaigoWelfareFacilityInstitutionDivisionRadioContainer==null){
      kaigoWelfareFacilityInstitutionDivisionRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityInstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityInstitutionDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityInstitutionDivisionRadioContainer.add(getKaigoWelfareFacilityInstitutionDivisionRadio(), null);
    }
    return kaigoWelfareFacilityInstitutionDivisionRadioContainer;
  }

  /**
   * �{�ݓ��̋敪���f�����擾���܂��B
   * @return �{�ݓ��̋敪���f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityInstitutionDivisionRadioModel(){
    if(kaigoWelfareFacilityInstitutionDivisionRadioModel==null){
      kaigoWelfareFacilityInstitutionDivisionRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityInstitutionDivisionRadioModel();
    }
    return kaigoWelfareFacilityInstitutionDivisionRadioModel;
  }

  /**
   * ��앟���{�݂��擾���܂��B
   * @return ��앟���{��
   */
  public ACRadioButtonItem getKaigoWelfareFacilityInstitutionDivisionRadioItem1(){
    if(kaigoWelfareFacilityInstitutionDivisionRadioItem1==null){

      kaigoWelfareFacilityInstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityInstitutionDivisionRadioItem1.setText("��앟���{��");

      kaigoWelfareFacilityInstitutionDivisionRadioItem1.setGroup(getKaigoWelfareFacilityInstitutionDivisionRadio());

      kaigoWelfareFacilityInstitutionDivisionRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoWelfareFacilityInstitutionDivisionRadioItem1();
    }
    return kaigoWelfareFacilityInstitutionDivisionRadioItem1;

  }

  /**
   * �o�ߓI���K�͉�앟���{�݂��擾���܂��B
   * @return �o�ߓI���K�͉�앟���{��
   */
  public ACRadioButtonItem getKaigoWelfareFacilityInstitutionDivisionRadioItem2(){
    if(kaigoWelfareFacilityInstitutionDivisionRadioItem2==null){

      kaigoWelfareFacilityInstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityInstitutionDivisionRadioItem2.setText("�o�ߓI���K�͉�앟���{��");

      kaigoWelfareFacilityInstitutionDivisionRadioItem2.setGroup(getKaigoWelfareFacilityInstitutionDivisionRadio());

      kaigoWelfareFacilityInstitutionDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoWelfareFacilityInstitutionDivisionRadioItem2();
    }
    return kaigoWelfareFacilityInstitutionDivisionRadioItem2;

  }

  /**
   * ���j�b�g�^��앟���{�݂��擾���܂��B
   * @return ���j�b�g�^��앟���{��
   */
  public ACRadioButtonItem getKaigoWelfareFacilityInstitutionDivisionRadioItem3(){
    if(kaigoWelfareFacilityInstitutionDivisionRadioItem3==null){

      kaigoWelfareFacilityInstitutionDivisionRadioItem3 = new ACRadioButtonItem();

      kaigoWelfareFacilityInstitutionDivisionRadioItem3.setText("���j�b�g�^��앟���{��");

      kaigoWelfareFacilityInstitutionDivisionRadioItem3.setGroup(getKaigoWelfareFacilityInstitutionDivisionRadio());

      kaigoWelfareFacilityInstitutionDivisionRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoWelfareFacilityInstitutionDivisionRadioItem3();
    }
    return kaigoWelfareFacilityInstitutionDivisionRadioItem3;

  }

  /**
   * ���j�b�g�^�o�ߓI���K�͉�앟���{�݂��擾���܂��B
   * @return ���j�b�g�^�o�ߓI���K�͉�앟���{��
   */
  public ACRadioButtonItem getKaigoWelfareFacilityInstitutionDivisionRadioItem4(){
    if(kaigoWelfareFacilityInstitutionDivisionRadioItem4==null){

      kaigoWelfareFacilityInstitutionDivisionRadioItem4 = new ACRadioButtonItem();

      kaigoWelfareFacilityInstitutionDivisionRadioItem4.setText("���j�b�g�^�o�ߓI���K�͉�앟���{��");

      kaigoWelfareFacilityInstitutionDivisionRadioItem4.setGroup(getKaigoWelfareFacilityInstitutionDivisionRadio());

      kaigoWelfareFacilityInstitutionDivisionRadioItem4.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityInstitutionDivisionRadioItem4();
    }
    return kaigoWelfareFacilityInstitutionDivisionRadioItem4;

  }

  /**
   * �a���敪�R���e�i���擾���܂��B
   * @return �a���敪�R���e�i
   */
  public ACLabelContainer getKaigoWelfareFacilityHospitalRoomDivisionContena(){
    if(kaigoWelfareFacilityHospitalRoomDivisionContena==null){

      kaigoWelfareFacilityHospitalRoomDivisionContena = new ACLabelContainer();

      kaigoWelfareFacilityHospitalRoomDivisionContena.setText("�a���敪");

      kaigoWelfareFacilityHospitalRoomDivisionContena.setFollowChildEnabled(true);

      addKaigoWelfareFacilityHospitalRoomDivisionContena();
    }
    return kaigoWelfareFacilityHospitalRoomDivisionContena;

  }

  /**
   * �a���敪�i��앟���{�݁j���擾���܂��B
   * @return �a���敪�i��앟���{�݁j
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityHospitalRoomDivisionRadio(){
    if(kaigoWelfareFacilityHospitalRoomDivisionRadio==null){

      kaigoWelfareFacilityHospitalRoomDivisionRadio = new ACValueArrayRadioButtonGroup();

      kaigoWelfareFacilityHospitalRoomDivisionRadio.setBindPath("1510102");

      kaigoWelfareFacilityHospitalRoomDivisionRadio.setUseClearButton(false);

      kaigoWelfareFacilityHospitalRoomDivisionRadio.setModel(getKaigoWelfareFacilityHospitalRoomDivisionRadioModel());

      kaigoWelfareFacilityHospitalRoomDivisionRadio.setValues(new int[]{1,2});

      addKaigoWelfareFacilityHospitalRoomDivisionRadio();
    }
    return kaigoWelfareFacilityHospitalRoomDivisionRadio;

  }

  /**
   * �a���敪�i��앟���{�݁j���f�����擾���܂��B
   * @return �a���敪�i��앟���{�݁j���f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityHospitalRoomDivisionRadioModel(){
    if(kaigoWelfareFacilityHospitalRoomDivisionRadioModel==null){
      kaigoWelfareFacilityHospitalRoomDivisionRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityHospitalRoomDivisionRadioModel();
    }
    return kaigoWelfareFacilityHospitalRoomDivisionRadioModel;
  }

  /**
   * �]���^�����擾���܂��B
   * @return �]���^��
   */
  public ACRadioButtonItem getKaigoWelfareFacilityHospitalRoomDivisionRadioItem1(){
    if(kaigoWelfareFacilityHospitalRoomDivisionRadioItem1==null){

      kaigoWelfareFacilityHospitalRoomDivisionRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityHospitalRoomDivisionRadioItem1.setText("�]���^��");

      kaigoWelfareFacilityHospitalRoomDivisionRadioItem1.setGroup(getKaigoWelfareFacilityHospitalRoomDivisionRadio());

      kaigoWelfareFacilityHospitalRoomDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityHospitalRoomDivisionRadioItem1();
    }
    return kaigoWelfareFacilityHospitalRoomDivisionRadioItem1;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACRadioButtonItem getKaigoWelfareFacilityHospitalRoomDivisionRadioItem2(){
    if(kaigoWelfareFacilityHospitalRoomDivisionRadioItem2==null){

      kaigoWelfareFacilityHospitalRoomDivisionRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityHospitalRoomDivisionRadioItem2.setText("������");

      kaigoWelfareFacilityHospitalRoomDivisionRadioItem2.setGroup(getKaigoWelfareFacilityHospitalRoomDivisionRadio());

      kaigoWelfareFacilityHospitalRoomDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityHospitalRoomDivisionRadioItem2();
    }
    return kaigoWelfareFacilityHospitalRoomDivisionRadioItem2;

  }

  /**
   * �a���敪�i���j�b�g�^��앟���{�݁j���擾���܂��B
   * @return �a���敪�i���j�b�g�^��앟���{�݁j
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityUnitHospitalRoomDivisionRadio(){
    if(kaigoWelfareFacilityUnitHospitalRoomDivisionRadio==null){

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadio = new ACValueArrayRadioButtonGroup();

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadio.setBindPath("1510103");

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadio.setUseClearButton(false);

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadio.setModel(getKaigoWelfareFacilityUnitHospitalRoomDivisionRadioModel());

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadio.setValues(new int[]{1,2});

      addKaigoWelfareFacilityUnitHospitalRoomDivisionRadio();
    }
    return kaigoWelfareFacilityUnitHospitalRoomDivisionRadio;

  }

  /**
   * �a���敪�i���j�b�g�^��앟���{�݁j���f�����擾���܂��B
   * @return �a���敪�i���j�b�g�^��앟���{�݁j���f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityUnitHospitalRoomDivisionRadioModel(){
    if(kaigoWelfareFacilityUnitHospitalRoomDivisionRadioModel==null){
      kaigoWelfareFacilityUnitHospitalRoomDivisionRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityUnitHospitalRoomDivisionRadioModel();
    }
    return kaigoWelfareFacilityUnitHospitalRoomDivisionRadioModel;
  }

  /**
   * ���j�b�g�^�����擾���܂��B
   * @return ���j�b�g�^��
   */
  public ACRadioButtonItem getKaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem1(){
    if(kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem1==null){

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem1.setText("�ƯČ^��");

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem1.setGroup(getKaigoWelfareFacilityUnitHospitalRoomDivisionRadio());

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem1();
    }
    return kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem1;

  }

  /**
   * ���j�b�g�^���I���������擾���܂��B
   * @return ���j�b�g�^���I������
   */
  public ACRadioButtonItem getKaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem2(){
    if(kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem2==null){

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem2.setText("�ƯČ^���I������");

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem2.setGroup(getKaigoWelfareFacilityUnitHospitalRoomDivisionRadio());

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem2();
    }
    return kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem2;

  }

  /**
   * ���j�b�g�P�A�̐������擾���܂��B
   * @return ���j�b�g�P�A�̐���
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityUnitCareMaintenanceRadio(){
    if(kaigoWelfareFacilityUnitCareMaintenanceRadio==null){

      kaigoWelfareFacilityUnitCareMaintenanceRadio = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityUnitCareMaintenanceRadioContainer().setText("���j�b�g�P�A�̐���");

      kaigoWelfareFacilityUnitCareMaintenanceRadio.setBindPath("1510124");

      kaigoWelfareFacilityUnitCareMaintenanceRadio.setUseClearButton(false);

      kaigoWelfareFacilityUnitCareMaintenanceRadio.setModel(getKaigoWelfareFacilityUnitCareMaintenanceRadioModel());

      kaigoWelfareFacilityUnitCareMaintenanceRadio.setValues(new int[]{1,2});

      addKaigoWelfareFacilityUnitCareMaintenanceRadio();
    }
    return kaigoWelfareFacilityUnitCareMaintenanceRadio;

  }

  /**
   * ���j�b�g�P�A�̐����R���e�i���擾���܂��B
   * @return ���j�b�g�P�A�̐����R���e�i
   */
  protected ACLabelContainer getKaigoWelfareFacilityUnitCareMaintenanceRadioContainer(){
    if(kaigoWelfareFacilityUnitCareMaintenanceRadioContainer==null){
      kaigoWelfareFacilityUnitCareMaintenanceRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityUnitCareMaintenanceRadioContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityUnitCareMaintenanceRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityUnitCareMaintenanceRadioContainer.add(getKaigoWelfareFacilityUnitCareMaintenanceRadio(), null);
    }
    return kaigoWelfareFacilityUnitCareMaintenanceRadioContainer;
  }

  /**
   * ���j�b�g�P�A�̐������f�����擾���܂��B
   * @return ���j�b�g�P�A�̐������f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityUnitCareMaintenanceRadioModel(){
    if(kaigoWelfareFacilityUnitCareMaintenanceRadioModel==null){
      kaigoWelfareFacilityUnitCareMaintenanceRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityUnitCareMaintenanceRadioModel();
    }
    return kaigoWelfareFacilityUnitCareMaintenanceRadioModel;
  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACRadioButtonItem getKaigoWelfareFacilityUnitCareMaintenanceRadioItem1(){
    if(kaigoWelfareFacilityUnitCareMaintenanceRadioItem1==null){

      kaigoWelfareFacilityUnitCareMaintenanceRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityUnitCareMaintenanceRadioItem1.setText("������");

      kaigoWelfareFacilityUnitCareMaintenanceRadioItem1.setGroup(getKaigoWelfareFacilityUnitCareMaintenanceRadio());

      kaigoWelfareFacilityUnitCareMaintenanceRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityUnitCareMaintenanceRadioItem1();
    }
    return kaigoWelfareFacilityUnitCareMaintenanceRadioItem1;

  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoWelfareFacilityUnitCareMaintenanceRadioItem2(){
    if(kaigoWelfareFacilityUnitCareMaintenanceRadioItem2==null){

      kaigoWelfareFacilityUnitCareMaintenanceRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityUnitCareMaintenanceRadioItem2.setText("����");

      kaigoWelfareFacilityUnitCareMaintenanceRadioItem2.setGroup(getKaigoWelfareFacilityUnitCareMaintenanceRadio());

      kaigoWelfareFacilityUnitCareMaintenanceRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityUnitCareMaintenanceRadioItem2();
    }
    return kaigoWelfareFacilityUnitCareMaintenanceRadioItem2;

  }

  /**
   * �����j�b�g�P�A���Z���擾���܂��B
   * @return �����j�b�g�P�A���Z
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityJunUnitCareAddRadio(){
    if(kaigoWelfareFacilityJunUnitCareAddRadio==null){

      kaigoWelfareFacilityJunUnitCareAddRadio = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityJunUnitCareAddRadioContainer().setText("�����j�b�g�P�A���Z");

      kaigoWelfareFacilityJunUnitCareAddRadio.setBindPath("1510125");

      kaigoWelfareFacilityJunUnitCareAddRadio.setUseClearButton(false);

      kaigoWelfareFacilityJunUnitCareAddRadio.setModel(getKaigoWelfareFacilityJunUnitCareAddRadioModel());

      kaigoWelfareFacilityJunUnitCareAddRadio.setValues(new int[]{1,2});

      addKaigoWelfareFacilityJunUnitCareAddRadio();
    }
    return kaigoWelfareFacilityJunUnitCareAddRadio;

  }

  /**
   * �����j�b�g�P�A���Z�R���e�i���擾���܂��B
   * @return �����j�b�g�P�A���Z�R���e�i
   */
  protected ACLabelContainer getKaigoWelfareFacilityJunUnitCareAddRadioContainer(){
    if(kaigoWelfareFacilityJunUnitCareAddRadioContainer==null){
      kaigoWelfareFacilityJunUnitCareAddRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityJunUnitCareAddRadioContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityJunUnitCareAddRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityJunUnitCareAddRadioContainer.add(getKaigoWelfareFacilityJunUnitCareAddRadio(), null);
    }
    return kaigoWelfareFacilityJunUnitCareAddRadioContainer;
  }

  /**
   * �����j�b�g�P�A���Z���f�����擾���܂��B
   * @return �����j�b�g�P�A���Z���f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityJunUnitCareAddRadioModel(){
    if(kaigoWelfareFacilityJunUnitCareAddRadioModel==null){
      kaigoWelfareFacilityJunUnitCareAddRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityJunUnitCareAddRadioModel();
    }
    return kaigoWelfareFacilityJunUnitCareAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoWelfareFacilityJunUnitCareAddRadioItem1(){
    if(kaigoWelfareFacilityJunUnitCareAddRadioItem1==null){

      kaigoWelfareFacilityJunUnitCareAddRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityJunUnitCareAddRadioItem1.setText("�Ȃ�");

      kaigoWelfareFacilityJunUnitCareAddRadioItem1.setGroup(getKaigoWelfareFacilityJunUnitCareAddRadio());

      kaigoWelfareFacilityJunUnitCareAddRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityJunUnitCareAddRadioItem1();
    }
    return kaigoWelfareFacilityJunUnitCareAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoWelfareFacilityJunUnitCareAddRadioItem2(){
    if(kaigoWelfareFacilityJunUnitCareAddRadioItem2==null){

      kaigoWelfareFacilityJunUnitCareAddRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityJunUnitCareAddRadioItem2.setText("����");

      kaigoWelfareFacilityJunUnitCareAddRadioItem2.setGroup(getKaigoWelfareFacilityJunUnitCareAddRadio());

      kaigoWelfareFacilityJunUnitCareAddRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityJunUnitCareAddRadioItem2();
    }
    return kaigoWelfareFacilityJunUnitCareAddRadioItem2;

  }

  /**
   * ��Α̐����Z���擾���܂��B
   * @return ��Α̐����Z
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityNightShiftSubtractionRadio(){
    if(kaigoWelfareFacilityNightShiftSubtractionRadio==null){

      kaigoWelfareFacilityNightShiftSubtractionRadio = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityNightShiftSubtractionRadioContainer().setText("��ԋΖ������");

      kaigoWelfareFacilityNightShiftSubtractionRadio.setBindPath("1510106");

      kaigoWelfareFacilityNightShiftSubtractionRadio.setUseClearButton(false);

      kaigoWelfareFacilityNightShiftSubtractionRadio.setModel(getKaigoWelfareFacilityNightShiftSubtractionRadioModel());

      kaigoWelfareFacilityNightShiftSubtractionRadio.setValues(new int[]{1,2});

      addKaigoWelfareFacilityNightShiftSubtractionRadio();
    }
    return kaigoWelfareFacilityNightShiftSubtractionRadio;

  }

  /**
   * ��Α̐����Z�R���e�i���擾���܂��B
   * @return ��Α̐����Z�R���e�i
   */
  protected ACLabelContainer getKaigoWelfareFacilityNightShiftSubtractionRadioContainer(){
    if(kaigoWelfareFacilityNightShiftSubtractionRadioContainer==null){
      kaigoWelfareFacilityNightShiftSubtractionRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityNightShiftSubtractionRadioContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityNightShiftSubtractionRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityNightShiftSubtractionRadioContainer.add(getKaigoWelfareFacilityNightShiftSubtractionRadio(), null);
    }
    return kaigoWelfareFacilityNightShiftSubtractionRadioContainer;
  }

  /**
   * ��Α̐����Z���f�����擾���܂��B
   * @return ��Α̐����Z���f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityNightShiftSubtractionRadioModel(){
    if(kaigoWelfareFacilityNightShiftSubtractionRadioModel==null){
      kaigoWelfareFacilityNightShiftSubtractionRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityNightShiftSubtractionRadioModel();
    }
    return kaigoWelfareFacilityNightShiftSubtractionRadioModel;
  }

  /**
   * ��^���擾���܂��B
   * @return ��^
   */
  public ACRadioButtonItem getKaigoWelfareFacilityNightShiftSubtractionRadioItem1(){
    if(kaigoWelfareFacilityNightShiftSubtractionRadioItem1==null){

      kaigoWelfareFacilityNightShiftSubtractionRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityNightShiftSubtractionRadioItem1.setText("��^");

      kaigoWelfareFacilityNightShiftSubtractionRadioItem1.setGroup(getKaigoWelfareFacilityNightShiftSubtractionRadio());

      kaigoWelfareFacilityNightShiftSubtractionRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityNightShiftSubtractionRadioItem1();
    }
    return kaigoWelfareFacilityNightShiftSubtractionRadioItem1;

  }

  /**
   * ���Z�^���擾���܂��B
   * @return ���Z�^
   */
  public ACRadioButtonItem getKaigoWelfareFacilityNightShiftSubtractionRadioItem2(){
    if(kaigoWelfareFacilityNightShiftSubtractionRadioItem2==null){

      kaigoWelfareFacilityNightShiftSubtractionRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityNightShiftSubtractionRadioItem2.setText("���Z�^");

      kaigoWelfareFacilityNightShiftSubtractionRadioItem2.setGroup(getKaigoWelfareFacilityNightShiftSubtractionRadio());

      kaigoWelfareFacilityNightShiftSubtractionRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityNightShiftSubtractionRadioItem2();
    }
    return kaigoWelfareFacilityNightShiftSubtractionRadioItem2;

  }

  /**
   * ���퐶���p���x�����Z���擾���܂��B
   * @return ���퐶���p���x�����Z
   */
  public ACValueArrayRadioButtonGroup getDailyLifeContinuanceRadioGroup(){
    if(dailyLifeContinuanceRadioGroup==null){

      dailyLifeContinuanceRadioGroup = new ACValueArrayRadioButtonGroup();

      getDailyLifeContinuanceRadioGroupContainer().setText("���퐶���p���x�����Z");

      dailyLifeContinuanceRadioGroup.setBindPath("1510133");

      dailyLifeContinuanceRadioGroup.setNoSelectIndex(0);

      dailyLifeContinuanceRadioGroup.setUseClearButton(false);

      dailyLifeContinuanceRadioGroup.setModel(getDailyLifeContinuanceRadioGroupModel());

      dailyLifeContinuanceRadioGroup.setValues(new int[]{1,2});

      addDailyLifeContinuanceRadioGroup();
    }
    return dailyLifeContinuanceRadioGroup;

  }

  /**
   * ���퐶���p���x�����Z�R���e�i���擾���܂��B
   * @return ���퐶���p���x�����Z�R���e�i
   */
  protected ACLabelContainer getDailyLifeContinuanceRadioGroupContainer(){
    if(dailyLifeContinuanceRadioGroupContainer==null){
      dailyLifeContinuanceRadioGroupContainer = new ACLabelContainer();
      dailyLifeContinuanceRadioGroupContainer.setFollowChildEnabled(true);
      dailyLifeContinuanceRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      dailyLifeContinuanceRadioGroupContainer.add(getDailyLifeContinuanceRadioGroup(), null);
    }
    return dailyLifeContinuanceRadioGroupContainer;
  }

  /**
   * ���퐶���p���x�����Z���f�����擾���܂��B
   * @return ���퐶���p���x�����Z���f��
   */
  protected ACListModelAdapter getDailyLifeContinuanceRadioGroupModel(){
    if(dailyLifeContinuanceRadioGroupModel==null){
      dailyLifeContinuanceRadioGroupModel = new ACListModelAdapter();
      addDailyLifeContinuanceRadioGroupModel();
    }
    return dailyLifeContinuanceRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getDailyLifeContinuanceRadioItem1(){
    if(dailyLifeContinuanceRadioItem1==null){

      dailyLifeContinuanceRadioItem1 = new ACRadioButtonItem();

      dailyLifeContinuanceRadioItem1.setText("�Ȃ�");

      dailyLifeContinuanceRadioItem1.setGroup(getDailyLifeContinuanceRadioGroup());

      dailyLifeContinuanceRadioItem1.setConstraints(VRLayout.FLOW);

      addDailyLifeContinuanceRadioItem1();
    }
    return dailyLifeContinuanceRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getDailyLifeContinuanceRadioItem2(){
    if(dailyLifeContinuanceRadioItem2==null){

      dailyLifeContinuanceRadioItem2 = new ACRadioButtonItem();

      dailyLifeContinuanceRadioItem2.setText("����");

      dailyLifeContinuanceRadioItem2.setGroup(getDailyLifeContinuanceRadioGroup());

      dailyLifeContinuanceRadioItem2.setConstraints(VRLayout.FLOW);

      addDailyLifeContinuanceRadioItem2();
    }
    return dailyLifeContinuanceRadioItem2;

  }

  /**
   * �^�u2���擾���܂��B
   * @return �^�u2
   */
  public ACPanel getTab2(){
    if(tab2==null){

      tab2 = new ACPanel();

      tab2.setFollowChildEnabled(true);

      tab2.setHgap(0);

      addTab2();
    }
    return tab2;

  }

  /**
   * �ʋ@�\�P���w�����Z���擾���܂��B
   * @return �ʋ@�\�P���w�����Z
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityFunctionTrainingRadio(){
    if(kaigoWelfareFacilityFunctionTrainingRadio==null){

      kaigoWelfareFacilityFunctionTrainingRadio = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityFunctionTrainingRadioContainer().setText("�ʋ@�\�P���w�����Z");

      kaigoWelfareFacilityFunctionTrainingRadio.setBindPath("1510107");

      kaigoWelfareFacilityFunctionTrainingRadio.setUseClearButton(false);

      kaigoWelfareFacilityFunctionTrainingRadio.setModel(getKaigoWelfareFacilityFunctionTrainingRadioModel());

      kaigoWelfareFacilityFunctionTrainingRadio.setValues(new int[]{1,2});

      addKaigoWelfareFacilityFunctionTrainingRadio();
    }
    return kaigoWelfareFacilityFunctionTrainingRadio;

  }

  /**
   * �ʋ@�\�P���w�����Z�R���e�i���擾���܂��B
   * @return �ʋ@�\�P���w�����Z�R���e�i
   */
  protected ACLabelContainer getKaigoWelfareFacilityFunctionTrainingRadioContainer(){
    if(kaigoWelfareFacilityFunctionTrainingRadioContainer==null){
      kaigoWelfareFacilityFunctionTrainingRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityFunctionTrainingRadioContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityFunctionTrainingRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityFunctionTrainingRadioContainer.add(getKaigoWelfareFacilityFunctionTrainingRadio(), null);
    }
    return kaigoWelfareFacilityFunctionTrainingRadioContainer;
  }

  /**
   * �ʋ@�\�P���w�����Z���f�����擾���܂��B
   * @return �ʋ@�\�P���w�����Z���f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityFunctionTrainingRadioModel(){
    if(kaigoWelfareFacilityFunctionTrainingRadioModel==null){
      kaigoWelfareFacilityFunctionTrainingRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityFunctionTrainingRadioModel();
    }
    return kaigoWelfareFacilityFunctionTrainingRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoWelfareFacilityFunctionTrainingRadioItem2(){
    if(kaigoWelfareFacilityFunctionTrainingRadioItem2==null){

      kaigoWelfareFacilityFunctionTrainingRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityFunctionTrainingRadioItem2.setText("�Ȃ�");

      kaigoWelfareFacilityFunctionTrainingRadioItem2.setGroup(getKaigoWelfareFacilityFunctionTrainingRadio());

      kaigoWelfareFacilityFunctionTrainingRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityFunctionTrainingRadioItem2();
    }
    return kaigoWelfareFacilityFunctionTrainingRadioItem2;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoWelfareFacilityFunctionTrainingRadioItem1(){
    if(kaigoWelfareFacilityFunctionTrainingRadioItem1==null){

      kaigoWelfareFacilityFunctionTrainingRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityFunctionTrainingRadioItem1.setText("����");

      kaigoWelfareFacilityFunctionTrainingRadioItem1.setGroup(getKaigoWelfareFacilityFunctionTrainingRadio());

      kaigoWelfareFacilityFunctionTrainingRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityFunctionTrainingRadioItem1();
    }
    return kaigoWelfareFacilityFunctionTrainingRadioItem1;

  }

  /**
   * ��Q�Ґ����x���̐����Z���擾���܂��B
   * @return ��Q�Ґ����x���̐����Z
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityHandicappedRadio(){
    if(kaigoWelfareFacilityHandicappedRadio==null){

      kaigoWelfareFacilityHandicappedRadio = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityHandicappedRadioContainer().setText("��Q�Ґ����x���̐����Z");

      kaigoWelfareFacilityHandicappedRadio.setBindPath("1510110");

      kaigoWelfareFacilityHandicappedRadio.setUseClearButton(false);

      kaigoWelfareFacilityHandicappedRadio.setModel(getKaigoWelfareFacilityHandicappedRadioModel());

      kaigoWelfareFacilityHandicappedRadio.setValues(new int[]{1,2,3});

      addKaigoWelfareFacilityHandicappedRadio();
    }
    return kaigoWelfareFacilityHandicappedRadio;

  }

  /**
   * ��Q�Ґ����x���̐����Z�R���e�i���擾���܂��B
   * @return ��Q�Ґ����x���̐����Z�R���e�i
   */
  protected ACLabelContainer getKaigoWelfareFacilityHandicappedRadioContainer(){
    if(kaigoWelfareFacilityHandicappedRadioContainer==null){
      kaigoWelfareFacilityHandicappedRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityHandicappedRadioContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityHandicappedRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityHandicappedRadioContainer.add(getKaigoWelfareFacilityHandicappedRadio(), null);
    }
    return kaigoWelfareFacilityHandicappedRadioContainer;
  }

  /**
   * ��Q�Ґ����x���̐����Z���f�����擾���܂��B
   * @return ��Q�Ґ����x���̐����Z���f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityHandicappedRadioModel(){
    if(kaigoWelfareFacilityHandicappedRadioModel==null){
      kaigoWelfareFacilityHandicappedRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityHandicappedRadioModel();
    }
    return kaigoWelfareFacilityHandicappedRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoWelfareFacilityHandicappedRadioItem1(){
    if(kaigoWelfareFacilityHandicappedRadioItem1==null){

      kaigoWelfareFacilityHandicappedRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityHandicappedRadioItem1.setText("�Ȃ�");

      kaigoWelfareFacilityHandicappedRadioItem1.setGroup(getKaigoWelfareFacilityHandicappedRadio());

      kaigoWelfareFacilityHandicappedRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityHandicappedRadioItem1();
    }
    return kaigoWelfareFacilityHandicappedRadioItem1;

  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getKaigoWelfareFacilityHandicappedRadioItem2(){
    if(kaigoWelfareFacilityHandicappedRadioItem2==null){

      kaigoWelfareFacilityHandicappedRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityHandicappedRadioItem2.setText("I�^");

      kaigoWelfareFacilityHandicappedRadioItem2.setGroup(getKaigoWelfareFacilityHandicappedRadio());

      kaigoWelfareFacilityHandicappedRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityHandicappedRadioItem2();
    }
    return kaigoWelfareFacilityHandicappedRadioItem2;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getKaigoWelfareFacilityHandicappedRadioItem3(){
    if(kaigoWelfareFacilityHandicappedRadioItem3==null){

      kaigoWelfareFacilityHandicappedRadioItem3 = new ACRadioButtonItem();

      kaigoWelfareFacilityHandicappedRadioItem3.setText("II�^");

      kaigoWelfareFacilityHandicappedRadioItem3.setGroup(getKaigoWelfareFacilityHandicappedRadio());

      kaigoWelfareFacilityHandicappedRadioItem3.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityHandicappedRadioItem3();
    }
    return kaigoWelfareFacilityHandicappedRadioItem3;

  }

  /**
   * �Ō�̐����Z�R���e�i���擾���܂��B
   * @return �Ō�̐����Z�R���e�i
   */
  public ACLabelContainer getNurseStructuralAddGroup(){
    if(nurseStructuralAddGroup==null){

      nurseStructuralAddGroup = new ACLabelContainer();

      nurseStructuralAddGroup.setText("�Ō�̐����Z");

      nurseStructuralAddGroup.setFollowChildEnabled(true);

      nurseStructuralAddGroup.setHgap(0);

      nurseStructuralAddGroup.setLabelMargin(0);

      nurseStructuralAddGroup.setVgap(0);

      addNurseStructuralAddGroup();
    }
    return nurseStructuralAddGroup;

  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACIntegerCheckBox getNurseStructuralAddCheckItem1(){
    if(nurseStructuralAddCheckItem1==null){

      nurseStructuralAddCheckItem1 = new ACIntegerCheckBox();

      nurseStructuralAddCheckItem1.setText("I�^");

      nurseStructuralAddCheckItem1.setBindPath("1510142");

      nurseStructuralAddCheckItem1.setSelectValue(2);

      nurseStructuralAddCheckItem1.setUnSelectValue(1);

      addNurseStructuralAddCheckItem1();
    }
    return nurseStructuralAddCheckItem1;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACIntegerCheckBox getNurseStructuralAddCheckItem2(){
    if(nurseStructuralAddCheckItem2==null){

      nurseStructuralAddCheckItem2 = new ACIntegerCheckBox();

      nurseStructuralAddCheckItem2.setText("II�^");

      nurseStructuralAddCheckItem2.setBindPath("1510143");

      nurseStructuralAddCheckItem2.setSelectValue(2);

      nurseStructuralAddCheckItem2.setUnSelectValue(1);

      addNurseStructuralAddCheckItem2();
    }
    return nurseStructuralAddCheckItem2;

  }

  /**
   * ��ΐE���z�u���Z���擾���܂��B
   * @return ��ΐE���z�u���Z
   */
  public ACValueArrayRadioButtonGroup getNightStaffDispositionAddRadioGroup(){
    if(nightStaffDispositionAddRadioGroup==null){

      nightStaffDispositionAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getNightStaffDispositionAddRadioGroupContainer().setText("��ΐE���z�u���Z");

      nightStaffDispositionAddRadioGroup.setBindPath("1510135");

      nightStaffDispositionAddRadioGroup.setNoSelectIndex(0);

      nightStaffDispositionAddRadioGroup.setUseClearButton(false);

      nightStaffDispositionAddRadioGroup.setModel(getNightStaffDispositionAddRadioGroupModel());

      nightStaffDispositionAddRadioGroup.setValues(new int[]{1,2,3});

      addNightStaffDispositionAddRadioGroup();
    }
    return nightStaffDispositionAddRadioGroup;

  }

  /**
   * ��ΐE���z�u���Z�R���e�i���擾���܂��B
   * @return ��ΐE���z�u���Z�R���e�i
   */
  protected ACLabelContainer getNightStaffDispositionAddRadioGroupContainer(){
    if(nightStaffDispositionAddRadioGroupContainer==null){
      nightStaffDispositionAddRadioGroupContainer = new ACLabelContainer();
      nightStaffDispositionAddRadioGroupContainer.setFollowChildEnabled(true);
      nightStaffDispositionAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      nightStaffDispositionAddRadioGroupContainer.add(getNightStaffDispositionAddRadioGroup(), null);
    }
    return nightStaffDispositionAddRadioGroupContainer;
  }

  /**
   * ��ΐE���z�u���Z���f�����擾���܂��B
   * @return ��ΐE���z�u���Z���f��
   */
  protected ACListModelAdapter getNightStaffDispositionAddRadioGroupModel(){
    if(nightStaffDispositionAddRadioGroupModel==null){
      nightStaffDispositionAddRadioGroupModel = new ACListModelAdapter();
      addNightStaffDispositionAddRadioGroupModel();
    }
    return nightStaffDispositionAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getNightStaffDispositionAddRadioItem1(){
    if(nightStaffDispositionAddRadioItem1==null){

      nightStaffDispositionAddRadioItem1 = new ACRadioButtonItem();

      nightStaffDispositionAddRadioItem1.setText("�Ȃ�");

      nightStaffDispositionAddRadioItem1.setGroup(getNightStaffDispositionAddRadioGroup());

      nightStaffDispositionAddRadioItem1.setConstraints(VRLayout.FLOW);

      addNightStaffDispositionAddRadioItem1();
    }
    return nightStaffDispositionAddRadioItem1;

  }

  /**
   * I�EII�^���擾���܂��B
   * @return I�EII�^
   */
  public ACRadioButtonItem getNightStaffDispositionAddRadioItem2(){
    if(nightStaffDispositionAddRadioItem2==null){

      nightStaffDispositionAddRadioItem2 = new ACRadioButtonItem();

      nightStaffDispositionAddRadioItem2.setText("I�EII�^");

      nightStaffDispositionAddRadioItem2.setGroup(getNightStaffDispositionAddRadioGroup());

      nightStaffDispositionAddRadioItem2.setConstraints(VRLayout.FLOW);

      addNightStaffDispositionAddRadioItem2();
    }
    return nightStaffDispositionAddRadioItem2;

  }

  /**
   * III�EIV�^���擾���܂��B
   * @return III�EIV�^
   */
  public ACRadioButtonItem getNightStaffDispositionAddRadioItem3(){
    if(nightStaffDispositionAddRadioItem3==null){

      nightStaffDispositionAddRadioItem3 = new ACRadioButtonItem();

      nightStaffDispositionAddRadioItem3.setText("III�EIV�^");

      nightStaffDispositionAddRadioItem3.setGroup(getNightStaffDispositionAddRadioGroup());

      nightStaffDispositionAddRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addNightStaffDispositionAddRadioItem3();
    }
    return nightStaffDispositionAddRadioItem3;

  }

  /**
   * ����������擾���܂��B
   * @return �������
   */
  public ACValueArrayRadioButtonGroup getStayPeopleCountRadioGroup(){
    if(stayPeopleCountRadioGroup==null){

      stayPeopleCountRadioGroup = new ACValueArrayRadioButtonGroup();

      getStayPeopleCountRadioGroupContainer().setText("�������");

      stayPeopleCountRadioGroup.setBindPath("1510136");

      stayPeopleCountRadioGroup.setNoSelectIndex(0);

      stayPeopleCountRadioGroup.setUseClearButton(false);

      stayPeopleCountRadioGroup.setModel(getStayPeopleCountRadioGroupModel());

      stayPeopleCountRadioGroup.setValues(new int[]{1,2});

      addStayPeopleCountRadioGroup();
    }
    return stayPeopleCountRadioGroup;

  }

  /**
   * ��������R���e�i���擾���܂��B
   * @return ��������R���e�i
   */
  protected ACLabelContainer getStayPeopleCountRadioGroupContainer(){
    if(stayPeopleCountRadioGroupContainer==null){
      stayPeopleCountRadioGroupContainer = new ACLabelContainer();
      stayPeopleCountRadioGroupContainer.setFollowChildEnabled(true);
      stayPeopleCountRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      stayPeopleCountRadioGroupContainer.add(getStayPeopleCountRadioGroup(), null);
    }
    return stayPeopleCountRadioGroupContainer;
  }

  /**
   * ����������f�����擾���܂��B
   * @return ����������f��
   */
  protected ACListModelAdapter getStayPeopleCountRadioGroupModel(){
    if(stayPeopleCountRadioGroupModel==null){
      stayPeopleCountRadioGroupModel = new ACListModelAdapter();
      addStayPeopleCountRadioGroupModel();
    }
    return stayPeopleCountRadioGroupModel;
  }

  /**
   * 30�l�ȏ�50�l�ȉ����擾���܂��B
   * @return 30�l�ȏ�50�l�ȉ�
   */
  public ACRadioButtonItem getStayPeopleCountRadioItem1(){
    if(stayPeopleCountRadioItem1==null){

      stayPeopleCountRadioItem1 = new ACRadioButtonItem();

      stayPeopleCountRadioItem1.setText("30�l�ȏ�50�l�ȉ�");

      stayPeopleCountRadioItem1.setGroup(getStayPeopleCountRadioGroup());

      stayPeopleCountRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addStayPeopleCountRadioItem1();
    }
    return stayPeopleCountRadioItem1;

  }

  /**
   * 51�l�ȏ㖔�͌o�ߓI���K�͂��擾���܂��B
   * @return 51�l�ȏ㖔�͌o�ߓI���K��
   */
  public ACRadioButtonItem getStayPeopleCountRadioItem2(){
    if(stayPeopleCountRadioItem2==null){

      stayPeopleCountRadioItem2 = new ACRadioButtonItem();

      stayPeopleCountRadioItem2.setText("51�l�ȏ㖔�͌o�ߓI���K��");

      stayPeopleCountRadioItem2.setGroup(getStayPeopleCountRadioGroup());

      stayPeopleCountRadioItem2.setConstraints(VRLayout.FLOW);

      addStayPeopleCountRadioItem2();
    }
    return stayPeopleCountRadioItem2;

  }

  /**
   * ��Έ�t�z�u���Z���擾���܂��B
   * @return ��Έ�t�z�u���Z
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityFacilityFulltimeDoctorRadio(){
    if(kaigoWelfareFacilityFacilityFulltimeDoctorRadio==null){

      kaigoWelfareFacilityFacilityFulltimeDoctorRadio = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityFacilityFulltimeDoctorRadioContainer().setText("��Έ�t�z�u���Z");

      kaigoWelfareFacilityFacilityFulltimeDoctorRadio.setBindPath("1510108");

      kaigoWelfareFacilityFacilityFulltimeDoctorRadio.setUseClearButton(false);

      kaigoWelfareFacilityFacilityFulltimeDoctorRadio.setModel(getKaigoWelfareFacilityFacilityFulltimeDoctorRadioModel());

      kaigoWelfareFacilityFacilityFulltimeDoctorRadio.setValues(new int[]{1,2});

      addKaigoWelfareFacilityFacilityFulltimeDoctorRadio();
    }
    return kaigoWelfareFacilityFacilityFulltimeDoctorRadio;

  }

  /**
   * ��Έ�t�z�u���Z�R���e�i���擾���܂��B
   * @return ��Έ�t�z�u���Z�R���e�i
   */
  protected ACLabelContainer getKaigoWelfareFacilityFacilityFulltimeDoctorRadioContainer(){
    if(kaigoWelfareFacilityFacilityFulltimeDoctorRadioContainer==null){
      kaigoWelfareFacilityFacilityFulltimeDoctorRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityFacilityFulltimeDoctorRadioContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityFacilityFulltimeDoctorRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityFacilityFulltimeDoctorRadioContainer.add(getKaigoWelfareFacilityFacilityFulltimeDoctorRadio(), null);
    }
    return kaigoWelfareFacilityFacilityFulltimeDoctorRadioContainer;
  }

  /**
   * ��Έ�t�z�u���Z���f�����擾���܂��B
   * @return ��Έ�t�z�u���Z���f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityFacilityFulltimeDoctorRadioModel(){
    if(kaigoWelfareFacilityFacilityFulltimeDoctorRadioModel==null){
      kaigoWelfareFacilityFacilityFulltimeDoctorRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityFacilityFulltimeDoctorRadioModel();
    }
    return kaigoWelfareFacilityFacilityFulltimeDoctorRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoWelfareFacilityFacilityFulltimeDoctorRadioItem1(){
    if(kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem1==null){

      kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem1.setText("�Ȃ�");

      kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem1.setGroup(getKaigoWelfareFacilityFacilityFulltimeDoctorRadio());

      kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityFacilityFulltimeDoctorRadioItem1();
    }
    return kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoWelfareFacilityFacilityFulltimeDoctorRadioItem2(){
    if(kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem2==null){

      kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem2.setText("����");

      kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem2.setGroup(getKaigoWelfareFacilityFacilityFulltimeDoctorRadio());

      kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityFacilityFulltimeDoctorRadioItem2();
    }
    return kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem2;

  }

  /**
   * ���_�Ȉ�×{�w�����Z���擾���܂��B
   * @return ���_�Ȉ�×{�w�����Z
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityPsychiatristRadio(){
    if(kaigoWelfareFacilityPsychiatristRadio==null){

      kaigoWelfareFacilityPsychiatristRadio = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityPsychiatristRadioContainer().setText("���_�Ȉ�×{�w�����Z");

      kaigoWelfareFacilityPsychiatristRadio.setBindPath("1510109");

      kaigoWelfareFacilityPsychiatristRadio.setUseClearButton(false);

      kaigoWelfareFacilityPsychiatristRadio.setModel(getKaigoWelfareFacilityPsychiatristRadioModel());

      kaigoWelfareFacilityPsychiatristRadio.setValues(new int[]{1,2});

      addKaigoWelfareFacilityPsychiatristRadio();
    }
    return kaigoWelfareFacilityPsychiatristRadio;

  }

  /**
   * ���_�Ȉ�×{�w�����Z�R���e�i���擾���܂��B
   * @return ���_�Ȉ�×{�w�����Z�R���e�i
   */
  protected ACLabelContainer getKaigoWelfareFacilityPsychiatristRadioContainer(){
    if(kaigoWelfareFacilityPsychiatristRadioContainer==null){
      kaigoWelfareFacilityPsychiatristRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityPsychiatristRadioContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityPsychiatristRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityPsychiatristRadioContainer.add(getKaigoWelfareFacilityPsychiatristRadio(), null);
    }
    return kaigoWelfareFacilityPsychiatristRadioContainer;
  }

  /**
   * ���_�Ȉ�×{�w�����Z���f�����擾���܂��B
   * @return ���_�Ȉ�×{�w�����Z���f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityPsychiatristRadioModel(){
    if(kaigoWelfareFacilityPsychiatristRadioModel==null){
      kaigoWelfareFacilityPsychiatristRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityPsychiatristRadioModel();
    }
    return kaigoWelfareFacilityPsychiatristRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoWelfareFacilityPsychiatristRadioItem1(){
    if(kaigoWelfareFacilityPsychiatristRadioItem1==null){

      kaigoWelfareFacilityPsychiatristRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityPsychiatristRadioItem1.setText("�Ȃ�");

      kaigoWelfareFacilityPsychiatristRadioItem1.setGroup(getKaigoWelfareFacilityPsychiatristRadio());

      kaigoWelfareFacilityPsychiatristRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityPsychiatristRadioItem1();
    }
    return kaigoWelfareFacilityPsychiatristRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoWelfareFacilityPsychiatristRadioItem2(){
    if(kaigoWelfareFacilityPsychiatristRadioItem2==null){

      kaigoWelfareFacilityPsychiatristRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityPsychiatristRadioItem2.setText("����");

      kaigoWelfareFacilityPsychiatristRadioItem2.setGroup(getKaigoWelfareFacilityPsychiatristRadio());

      kaigoWelfareFacilityPsychiatristRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityPsychiatristRadioItem2();
    }
    return kaigoWelfareFacilityPsychiatristRadioItem2;

  }

  /**
   * �O�����Z���擾���܂��B
   * @return �O�����Z
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityStayingOutOvernightCostRadio(){
    if(kaigoWelfareFacilityStayingOutOvernightCostRadio==null){

      kaigoWelfareFacilityStayingOutOvernightCostRadio = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityStayingOutOvernightCostRadioContainer().setText("�O�����Z");

      kaigoWelfareFacilityStayingOutOvernightCostRadio.setBindPath("1510111");

      kaigoWelfareFacilityStayingOutOvernightCostRadio.setUseClearButton(false);

      kaigoWelfareFacilityStayingOutOvernightCostRadio.setModel(getKaigoWelfareFacilityStayingOutOvernightCostRadioModel());

      kaigoWelfareFacilityStayingOutOvernightCostRadio.setValues(new int[]{1,2});

      addKaigoWelfareFacilityStayingOutOvernightCostRadio();
    }
    return kaigoWelfareFacilityStayingOutOvernightCostRadio;

  }

  /**
   * �O�����Z�R���e�i���擾���܂��B
   * @return �O�����Z�R���e�i
   */
  protected ACLabelContainer getKaigoWelfareFacilityStayingOutOvernightCostRadioContainer(){
    if(kaigoWelfareFacilityStayingOutOvernightCostRadioContainer==null){
      kaigoWelfareFacilityStayingOutOvernightCostRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityStayingOutOvernightCostRadioContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityStayingOutOvernightCostRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityStayingOutOvernightCostRadioContainer.add(getKaigoWelfareFacilityStayingOutOvernightCostRadio(), null);
    }
    return kaigoWelfareFacilityStayingOutOvernightCostRadioContainer;
  }

  /**
   * �O�����Z���f�����擾���܂��B
   * @return �O�����Z���f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityStayingOutOvernightCostRadioModel(){
    if(kaigoWelfareFacilityStayingOutOvernightCostRadioModel==null){
      kaigoWelfareFacilityStayingOutOvernightCostRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityStayingOutOvernightCostRadioModel();
    }
    return kaigoWelfareFacilityStayingOutOvernightCostRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoWelfareFacilityStayingOutOvernightCostRadioItem1(){
    if(kaigoWelfareFacilityStayingOutOvernightCostRadioItem1==null){

      kaigoWelfareFacilityStayingOutOvernightCostRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityStayingOutOvernightCostRadioItem1.setText("�Ȃ�");

      kaigoWelfareFacilityStayingOutOvernightCostRadioItem1.setGroup(getKaigoWelfareFacilityStayingOutOvernightCostRadio());

      kaigoWelfareFacilityStayingOutOvernightCostRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityStayingOutOvernightCostRadioItem1();
    }
    return kaigoWelfareFacilityStayingOutOvernightCostRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoWelfareFacilityStayingOutOvernightCostRadioItem2(){
    if(kaigoWelfareFacilityStayingOutOvernightCostRadioItem2==null){

      kaigoWelfareFacilityStayingOutOvernightCostRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityStayingOutOvernightCostRadioItem2.setText("����");

      kaigoWelfareFacilityStayingOutOvernightCostRadioItem2.setGroup(getKaigoWelfareFacilityStayingOutOvernightCostRadio());

      kaigoWelfareFacilityStayingOutOvernightCostRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityStayingOutOvernightCostRadioItem2();
    }
    return kaigoWelfareFacilityStayingOutOvernightCostRadioItem2;

  }

  /**
   * �������Z���擾���܂��B
   * @return �������Z
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityDefaultRadio(){
    if(kaigoWelfareFacilityDefaultRadio==null){

      kaigoWelfareFacilityDefaultRadio = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityDefaultRadioContainer().setText("�������Z");

      kaigoWelfareFacilityDefaultRadio.setBindPath("1510112");

      kaigoWelfareFacilityDefaultRadio.setUseClearButton(false);

      kaigoWelfareFacilityDefaultRadio.setModel(getKaigoWelfareFacilityDefaultRadioModel());

      kaigoWelfareFacilityDefaultRadio.setValues(new int[]{1,2});

      addKaigoWelfareFacilityDefaultRadio();
    }
    return kaigoWelfareFacilityDefaultRadio;

  }

  /**
   * �������Z�R���e�i���擾���܂��B
   * @return �������Z�R���e�i
   */
  protected ACLabelContainer getKaigoWelfareFacilityDefaultRadioContainer(){
    if(kaigoWelfareFacilityDefaultRadioContainer==null){
      kaigoWelfareFacilityDefaultRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityDefaultRadioContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityDefaultRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityDefaultRadioContainer.add(getKaigoWelfareFacilityDefaultRadio(), null);
    }
    return kaigoWelfareFacilityDefaultRadioContainer;
  }

  /**
   * �������Z���f�����擾���܂��B
   * @return �������Z���f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityDefaultRadioModel(){
    if(kaigoWelfareFacilityDefaultRadioModel==null){
      kaigoWelfareFacilityDefaultRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityDefaultRadioModel();
    }
    return kaigoWelfareFacilityDefaultRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoWelfareFacilityDefaultRadioItem1(){
    if(kaigoWelfareFacilityDefaultRadioItem1==null){

      kaigoWelfareFacilityDefaultRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityDefaultRadioItem1.setText("�Ȃ�");

      kaigoWelfareFacilityDefaultRadioItem1.setGroup(getKaigoWelfareFacilityDefaultRadio());

      kaigoWelfareFacilityDefaultRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityDefaultRadioItem1();
    }
    return kaigoWelfareFacilityDefaultRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoWelfareFacilityDefaultRadioItem2(){
    if(kaigoWelfareFacilityDefaultRadioItem2==null){

      kaigoWelfareFacilityDefaultRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityDefaultRadioItem2.setText("����");

      kaigoWelfareFacilityDefaultRadioItem2.setGroup(getKaigoWelfareFacilityDefaultRadio());

      kaigoWelfareFacilityDefaultRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityDefaultRadioItem2();
    }
    return kaigoWelfareFacilityDefaultRadioItem2;

  }

  /**
   * �^�u3���擾���܂��B
   * @return �^�u3
   */
  public ACPanel getTab3(){
    if(tab3==null){

      tab3 = new ACPanel();

      tab3.setFollowChildEnabled(true);

      tab3.setHgap(0);

      addTab3();
    }
    return tab3;

  }

  /**
   * �h�{�}�l�W�����g���Z���擾���܂��B
   * @return �h�{�}�l�W�����g���Z
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityNutritionRadio(){
    if(kaigoWelfareFacilityNutritionRadio==null){

      kaigoWelfareFacilityNutritionRadio = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityNutritionRadioContainer().setText("�h�{�}�l�W�����g���Z");

      kaigoWelfareFacilityNutritionRadio.setBindPath("1510114");

      kaigoWelfareFacilityNutritionRadio.setUseClearButton(false);

      kaigoWelfareFacilityNutritionRadio.setModel(getKaigoWelfareFacilityNutritionRadioModel());

      kaigoWelfareFacilityNutritionRadio.setValues(new int[]{1,2});

      addKaigoWelfareFacilityNutritionRadio();
    }
    return kaigoWelfareFacilityNutritionRadio;

  }

  /**
   * �h�{�}�l�W�����g���Z�R���e�i���擾���܂��B
   * @return �h�{�}�l�W�����g���Z�R���e�i
   */
  protected ACLabelContainer getKaigoWelfareFacilityNutritionRadioContainer(){
    if(kaigoWelfareFacilityNutritionRadioContainer==null){
      kaigoWelfareFacilityNutritionRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityNutritionRadioContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityNutritionRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityNutritionRadioContainer.add(getKaigoWelfareFacilityNutritionRadio(), null);
    }
    return kaigoWelfareFacilityNutritionRadioContainer;
  }

  /**
   * �h�{�}�l�W�����g���Z���f�����擾���܂��B
   * @return �h�{�}�l�W�����g���Z���f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityNutritionRadioModel(){
    if(kaigoWelfareFacilityNutritionRadioModel==null){
      kaigoWelfareFacilityNutritionRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityNutritionRadioModel();
    }
    return kaigoWelfareFacilityNutritionRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoWelfareFacilityNutritionRadioItem1(){
    if(kaigoWelfareFacilityNutritionRadioItem1==null){

      kaigoWelfareFacilityNutritionRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityNutritionRadioItem1.setText("�Ȃ�");

      kaigoWelfareFacilityNutritionRadioItem1.setGroup(getKaigoWelfareFacilityNutritionRadio());

      kaigoWelfareFacilityNutritionRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityNutritionRadioItem1();
    }
    return kaigoWelfareFacilityNutritionRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoWelfareFacilityNutritionRadioItem2(){
    if(kaigoWelfareFacilityNutritionRadioItem2==null){

      kaigoWelfareFacilityNutritionRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityNutritionRadioItem2.setText("����");

      kaigoWelfareFacilityNutritionRadioItem2.setGroup(getKaigoWelfareFacilityNutritionRadio());

      kaigoWelfareFacilityNutritionRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityNutritionRadioItem2();
    }
    return kaigoWelfareFacilityNutritionRadioItem2;

  }

  /**
   * �o���ڍs���Z���擾���܂��B
   * @return �o���ڍs���Z
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityOralSwitchRadio(){
    if(kaigoWelfareFacilityOralSwitchRadio==null){

      kaigoWelfareFacilityOralSwitchRadio = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityOralSwitchRadioContainer().setText("�o���ڍs���Z");

      kaigoWelfareFacilityOralSwitchRadio.setBindPath("1510115");

      kaigoWelfareFacilityOralSwitchRadio.setUseClearButton(false);

      kaigoWelfareFacilityOralSwitchRadio.setModel(getKaigoWelfareFacilityOralSwitchRadioModel());

      kaigoWelfareFacilityOralSwitchRadio.setValues(new int[]{1,2});

      addKaigoWelfareFacilityOralSwitchRadio();
    }
    return kaigoWelfareFacilityOralSwitchRadio;

  }

  /**
   * �o���ڍs���Z�R���e�i���擾���܂��B
   * @return �o���ڍs���Z�R���e�i
   */
  protected ACLabelContainer getKaigoWelfareFacilityOralSwitchRadioContainer(){
    if(kaigoWelfareFacilityOralSwitchRadioContainer==null){
      kaigoWelfareFacilityOralSwitchRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityOralSwitchRadioContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityOralSwitchRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityOralSwitchRadioContainer.add(getKaigoWelfareFacilityOralSwitchRadio(), null);
    }
    return kaigoWelfareFacilityOralSwitchRadioContainer;
  }

  /**
   * �o���ڍs���Z���f�����擾���܂��B
   * @return �o���ڍs���Z���f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityOralSwitchRadioModel(){
    if(kaigoWelfareFacilityOralSwitchRadioModel==null){
      kaigoWelfareFacilityOralSwitchRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityOralSwitchRadioModel();
    }
    return kaigoWelfareFacilityOralSwitchRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoWelfareFacilityOralSwitchRadioItem1(){
    if(kaigoWelfareFacilityOralSwitchRadioItem1==null){

      kaigoWelfareFacilityOralSwitchRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityOralSwitchRadioItem1.setText("�Ȃ�");

      kaigoWelfareFacilityOralSwitchRadioItem1.setGroup(getKaigoWelfareFacilityOralSwitchRadio());

      kaigoWelfareFacilityOralSwitchRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityOralSwitchRadioItem1();
    }
    return kaigoWelfareFacilityOralSwitchRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoWelfareFacilityOralSwitchRadioItem2(){
    if(kaigoWelfareFacilityOralSwitchRadioItem2==null){

      kaigoWelfareFacilityOralSwitchRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityOralSwitchRadioItem2.setText("����");

      kaigoWelfareFacilityOralSwitchRadioItem2.setGroup(getKaigoWelfareFacilityOralSwitchRadio());

      kaigoWelfareFacilityOralSwitchRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityOralSwitchRadioItem2();
    }
    return kaigoWelfareFacilityOralSwitchRadioItem2;

  }

  /**
   * �o���ێ����Z�R���e�i���擾���܂��B
   * @return �o���ێ����Z�R���e�i
   */
  public ACLabelContainer getOralMaintenanceAddContainer(){
    if(oralMaintenanceAddContainer==null){

      oralMaintenanceAddContainer = new ACLabelContainer();

      oralMaintenanceAddContainer.setText("�o���ێ����Z");

      oralMaintenanceAddContainer.setFollowChildEnabled(true);

      addOralMaintenanceAddContainer();
    }
    return oralMaintenanceAddContainer;

  }

  /**
   * �o���ێ����Z���擾���܂��B
   * @return �o���ێ����Z
   */
  public ACValueArrayRadioButtonGroup getOralMaintenanceAdd(){
    if(oralMaintenanceAdd==null){

      oralMaintenanceAdd = new ACValueArrayRadioButtonGroup();

      oralMaintenanceAdd.setBindPath("1510126");

      oralMaintenanceAdd.setUseClearButton(false);

      oralMaintenanceAdd.setModel(getOralMaintenanceAddModel());

      oralMaintenanceAdd.setValues(new int[]{1,2});

      addOralMaintenanceAdd();
    }
    return oralMaintenanceAdd;

  }

  /**
   * �o���ێ����Z���f�����擾���܂��B
   * @return �o���ێ����Z���f��
   */
  protected ACListModelAdapter getOralMaintenanceAddModel(){
    if(oralMaintenanceAddModel==null){
      oralMaintenanceAddModel = new ACListModelAdapter();
      addOralMaintenanceAddModel();
    }
    return oralMaintenanceAddModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getOralMaintenanceAddItem1(){
    if(oralMaintenanceAddItem1==null){

      oralMaintenanceAddItem1 = new ACRadioButtonItem();

      oralMaintenanceAddItem1.setText("�Ȃ�");

      oralMaintenanceAddItem1.setGroup(getOralMaintenanceAdd());

      oralMaintenanceAddItem1.setConstraints(VRLayout.FLOW);

      addOralMaintenanceAddItem1();
    }
    return oralMaintenanceAddItem1;

  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getOralMaintenanceAddItem2(){
    if(oralMaintenanceAddItem2==null){

      oralMaintenanceAddItem2 = new ACRadioButtonItem();

      oralMaintenanceAddItem2.setText("I�^");

      oralMaintenanceAddItem2.setGroup(getOralMaintenanceAdd());

      oralMaintenanceAddItem2.setConstraints(VRLayout.FLOW);

      addOralMaintenanceAddItem2();
    }
    return oralMaintenanceAddItem2;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACIntegerCheckBox getOralMaintenanceAddItem3(){
    if(oralMaintenanceAddItem3==null){

      oralMaintenanceAddItem3 = new ACIntegerCheckBox();

      oralMaintenanceAddItem3.setText("II�^");

      oralMaintenanceAddItem3.setBindPath("1510146");

      oralMaintenanceAddItem3.setSelectValue(2);

      oralMaintenanceAddItem3.setUnSelectValue(1);

      addOralMaintenanceAddItem3();
    }
    return oralMaintenanceAddItem3;

  }

  /**
   * ���o�q���Ǘ��̐����Z���擾���܂��B
   * @return ���o�q���Ǘ��̐����Z
   */
  public ACValueArrayRadioButtonGroup getOralKeepStructureAddRadioGroup(){
    if(oralKeepStructureAddRadioGroup==null){

      oralKeepStructureAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getOralKeepStructureAddRadioGroupContainer().setText("���o�q���Ǘ��̐����Z");

      oralKeepStructureAddRadioGroup.setBindPath("1510145");

      oralKeepStructureAddRadioGroup.setNoSelectIndex(0);

      oralKeepStructureAddRadioGroup.setUseClearButton(false);

      oralKeepStructureAddRadioGroup.setModel(getOralKeepStructureAddRadioGroupModel());

      oralKeepStructureAddRadioGroup.setValues(new int[]{1,2});

      addOralKeepStructureAddRadioGroup();
    }
    return oralKeepStructureAddRadioGroup;

  }

  /**
   * ���o�q���Ǘ��̐����Z�R���e�i���擾���܂��B
   * @return ���o�q���Ǘ��̐����Z�R���e�i
   */
  protected ACLabelContainer getOralKeepStructureAddRadioGroupContainer(){
    if(oralKeepStructureAddRadioGroupContainer==null){
      oralKeepStructureAddRadioGroupContainer = new ACLabelContainer();
      oralKeepStructureAddRadioGroupContainer.setFollowChildEnabled(true);
      oralKeepStructureAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      oralKeepStructureAddRadioGroupContainer.add(getOralKeepStructureAddRadioGroup(), null);
    }
    return oralKeepStructureAddRadioGroupContainer;
  }

  /**
   * ���o�q���Ǘ��̐����Z���f�����擾���܂��B
   * @return ���o�q���Ǘ��̐����Z���f��
   */
  protected ACListModelAdapter getOralKeepStructureAddRadioGroupModel(){
    if(oralKeepStructureAddRadioGroupModel==null){
      oralKeepStructureAddRadioGroupModel = new ACListModelAdapter();
      addOralKeepStructureAddRadioGroupModel();
    }
    return oralKeepStructureAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getOralKeepStructureAddRadioItem1(){
    if(oralKeepStructureAddRadioItem1==null){

      oralKeepStructureAddRadioItem1 = new ACRadioButtonItem();

      oralKeepStructureAddRadioItem1.setText("�Ȃ�");

      oralKeepStructureAddRadioItem1.setGroup(getOralKeepStructureAddRadioGroup());

      oralKeepStructureAddRadioItem1.setConstraints(VRLayout.FLOW);

      addOralKeepStructureAddRadioItem1();
    }
    return oralKeepStructureAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getOralKeepStructureAddRadioItem2(){
    if(oralKeepStructureAddRadioItem2==null){

      oralKeepStructureAddRadioItem2 = new ACRadioButtonItem();

      oralKeepStructureAddRadioItem2.setText("����");

      oralKeepStructureAddRadioItem2.setGroup(getOralKeepStructureAddRadioGroup());

      oralKeepStructureAddRadioItem2.setConstraints(VRLayout.FLOW);

      addOralKeepStructureAddRadioItem2();
    }
    return oralKeepStructureAddRadioItem2;

  }

  /**
   * ���o�q���Ǘ����Z���擾���܂��B
   * @return ���o�q���Ǘ����Z
   */
  public ACValueArrayRadioButtonGroup getOralKeepAddRadioGroup(){
    if(oralKeepAddRadioGroup==null){

      oralKeepAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getOralKeepAddRadioGroupContainer().setText("���o�q���Ǘ����Z");

      oralKeepAddRadioGroup.setBindPath("1510138");

      oralKeepAddRadioGroup.setNoSelectIndex(0);

      oralKeepAddRadioGroup.setUseClearButton(false);

      oralKeepAddRadioGroup.setModel(getOralKeepAddRadioGroupModel());

      oralKeepAddRadioGroup.setValues(new int[]{1,2});

      addOralKeepAddRadioGroup();
    }
    return oralKeepAddRadioGroup;

  }

  /**
   * ���o�q���Ǘ����Z�R���e�i���擾���܂��B
   * @return ���o�q���Ǘ����Z�R���e�i
   */
  protected ACLabelContainer getOralKeepAddRadioGroupContainer(){
    if(oralKeepAddRadioGroupContainer==null){
      oralKeepAddRadioGroupContainer = new ACLabelContainer();
      oralKeepAddRadioGroupContainer.setFollowChildEnabled(true);
      oralKeepAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      oralKeepAddRadioGroupContainer.add(getOralKeepAddRadioGroup(), null);
    }
    return oralKeepAddRadioGroupContainer;
  }

  /**
   * ���o�q���Ǘ����Z���f�����擾���܂��B
   * @return ���o�q���Ǘ����Z���f��
   */
  protected ACListModelAdapter getOralKeepAddRadioGroupModel(){
    if(oralKeepAddRadioGroupModel==null){
      oralKeepAddRadioGroupModel = new ACListModelAdapter();
      addOralKeepAddRadioGroupModel();
    }
    return oralKeepAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getOralKeepAddRadioItem1(){
    if(oralKeepAddRadioItem1==null){

      oralKeepAddRadioItem1 = new ACRadioButtonItem();

      oralKeepAddRadioItem1.setText("�Ȃ�");

      oralKeepAddRadioItem1.setGroup(getOralKeepAddRadioGroup());

      oralKeepAddRadioItem1.setConstraints(VRLayout.FLOW);

      addOralKeepAddRadioItem1();
    }
    return oralKeepAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getOralKeepAddRadioItem2(){
    if(oralKeepAddRadioItem2==null){

      oralKeepAddRadioItem2 = new ACRadioButtonItem();

      oralKeepAddRadioItem2.setText("����");

      oralKeepAddRadioItem2.setGroup(getOralKeepAddRadioGroup());

      oralKeepAddRadioItem2.setConstraints(VRLayout.FLOW);

      addOralKeepAddRadioItem2();
    }
    return oralKeepAddRadioItem2;

  }

  /**
   * �×{�H���Z���擾���܂��B
   * @return �×{�H���Z
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityRecuperateDinnerRadio(){
    if(kaigoWelfareFacilityRecuperateDinnerRadio==null){

      kaigoWelfareFacilityRecuperateDinnerRadio = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityRecuperateDinnerRadioContainer().setText("�×{�H���Z");

      kaigoWelfareFacilityRecuperateDinnerRadio.setBindPath("1510116");

      kaigoWelfareFacilityRecuperateDinnerRadio.setUseClearButton(false);

      kaigoWelfareFacilityRecuperateDinnerRadio.setModel(getKaigoWelfareFacilityRecuperateDinnerRadioModel());

      kaigoWelfareFacilityRecuperateDinnerRadio.setValues(new int[]{1,2,3,4});

      addKaigoWelfareFacilityRecuperateDinnerRadio();
    }
    return kaigoWelfareFacilityRecuperateDinnerRadio;

  }

  /**
   * �×{�H���Z�R���e�i���擾���܂��B
   * @return �×{�H���Z�R���e�i
   */
  protected ACLabelContainer getKaigoWelfareFacilityRecuperateDinnerRadioContainer(){
    if(kaigoWelfareFacilityRecuperateDinnerRadioContainer==null){
      kaigoWelfareFacilityRecuperateDinnerRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityRecuperateDinnerRadioContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityRecuperateDinnerRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityRecuperateDinnerRadioContainer.add(getKaigoWelfareFacilityRecuperateDinnerRadio(), null);
    }
    return kaigoWelfareFacilityRecuperateDinnerRadioContainer;
  }

  /**
   * �×{�H���Z���f�����擾���܂��B
   * @return �×{�H���Z���f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityRecuperateDinnerRadioModel(){
    if(kaigoWelfareFacilityRecuperateDinnerRadioModel==null){
      kaigoWelfareFacilityRecuperateDinnerRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityRecuperateDinnerRadioModel();
    }
    return kaigoWelfareFacilityRecuperateDinnerRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoWelfareFacilityRecuperateDinnerRadioItem1(){
    if(kaigoWelfareFacilityRecuperateDinnerRadioItem1==null){

      kaigoWelfareFacilityRecuperateDinnerRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityRecuperateDinnerRadioItem1.setText("�Ȃ�");

      kaigoWelfareFacilityRecuperateDinnerRadioItem1.setGroup(getKaigoWelfareFacilityRecuperateDinnerRadio());

      kaigoWelfareFacilityRecuperateDinnerRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityRecuperateDinnerRadioItem1();
    }
    return kaigoWelfareFacilityRecuperateDinnerRadioItem1;

  }

  /**
   * 3����擾���܂��B
   * @return 3��
   */
  public ACRadioButtonItem getKaigoWelfareFacilityRecuperateDinnerRadioItem2(){
    if(kaigoWelfareFacilityRecuperateDinnerRadioItem2==null){

      kaigoWelfareFacilityRecuperateDinnerRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityRecuperateDinnerRadioItem2.setText("3��");

      kaigoWelfareFacilityRecuperateDinnerRadioItem2.setGroup(getKaigoWelfareFacilityRecuperateDinnerRadio());

      kaigoWelfareFacilityRecuperateDinnerRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityRecuperateDinnerRadioItem2();
    }
    return kaigoWelfareFacilityRecuperateDinnerRadioItem2;

  }

  /**
   * 2����擾���܂��B
   * @return 2��
   */
  public ACRadioButtonItem getKaigoWelfareFacilityRecuperateDinnerRadioItem3(){
    if(kaigoWelfareFacilityRecuperateDinnerRadioItem3==null){

      kaigoWelfareFacilityRecuperateDinnerRadioItem3 = new ACRadioButtonItem();

      kaigoWelfareFacilityRecuperateDinnerRadioItem3.setText("2��");

      kaigoWelfareFacilityRecuperateDinnerRadioItem3.setGroup(getKaigoWelfareFacilityRecuperateDinnerRadio());

      kaigoWelfareFacilityRecuperateDinnerRadioItem3.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityRecuperateDinnerRadioItem3();
    }
    return kaigoWelfareFacilityRecuperateDinnerRadioItem3;

  }

  /**
   * 1����擾���܂��B
   * @return 1��
   */
  public ACRadioButtonItem getKaigoWelfareFacilityRecuperateDinnerRadioItem4(){
    if(kaigoWelfareFacilityRecuperateDinnerRadioItem4==null){

      kaigoWelfareFacilityRecuperateDinnerRadioItem4 = new ACRadioButtonItem();

      kaigoWelfareFacilityRecuperateDinnerRadioItem4.setText("1��");

      kaigoWelfareFacilityRecuperateDinnerRadioItem4.setGroup(getKaigoWelfareFacilityRecuperateDinnerRadio());

      kaigoWelfareFacilityRecuperateDinnerRadioItem4.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityRecuperateDinnerRadioItem4();
    }
    return kaigoWelfareFacilityRecuperateDinnerRadioItem4;

  }

  /**
   * ��N���F�m�Ǔ����Ҏ�����Z���擾���܂��B
   * @return ��N���F�m�Ǔ����Ҏ�����Z
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("��N���F�m�Ǔ����Ҏ�����Z");

      youngDementiaPatinetAddRadioGroup.setBindPath("1510137");

      youngDementiaPatinetAddRadioGroup.setNoSelectIndex(0);

      youngDementiaPatinetAddRadioGroup.setUseClearButton(false);

      youngDementiaPatinetAddRadioGroup.setModel(getYoungDementiaPatinetAddRadioGroupModel());

      youngDementiaPatinetAddRadioGroup.setValues(new int[]{1,2});

      addYoungDementiaPatinetAddRadioGroup();
    }
    return youngDementiaPatinetAddRadioGroup;

  }

  /**
   * ��N���F�m�Ǔ����Ҏ�����Z�R���e�i���擾���܂��B
   * @return ��N���F�m�Ǔ����Ҏ�����Z�R���e�i
   */
  protected ACLabelContainer getYoungDementiaPatinetAddRadioGroupContainer(){
    if(youngDementiaPatinetAddRadioGroupContainer==null){
      youngDementiaPatinetAddRadioGroupContainer = new ACLabelContainer();
      youngDementiaPatinetAddRadioGroupContainer.setFollowChildEnabled(true);
      youngDementiaPatinetAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      youngDementiaPatinetAddRadioGroupContainer.add(getYoungDementiaPatinetAddRadioGroup(), null);
    }
    return youngDementiaPatinetAddRadioGroupContainer;
  }

  /**
   * ��N���F�m�Ǔ����Ҏ�����Z���f�����擾���܂��B
   * @return ��N���F�m�Ǔ����Ҏ�����Z���f��
   */
  protected ACListModelAdapter getYoungDementiaPatinetAddRadioGroupModel(){
    if(youngDementiaPatinetAddRadioGroupModel==null){
      youngDementiaPatinetAddRadioGroupModel = new ACListModelAdapter();
      addYoungDementiaPatinetAddRadioGroupModel();
    }
    return youngDementiaPatinetAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getYoungDementiaPatinetAddRadioItem1(){
    if(youngDementiaPatinetAddRadioItem1==null){

      youngDementiaPatinetAddRadioItem1 = new ACRadioButtonItem();

      youngDementiaPatinetAddRadioItem1.setText("�Ȃ�");

      youngDementiaPatinetAddRadioItem1.setGroup(getYoungDementiaPatinetAddRadioGroup());

      youngDementiaPatinetAddRadioItem1.setConstraints(VRLayout.FLOW);

      addYoungDementiaPatinetAddRadioItem1();
    }
    return youngDementiaPatinetAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getYoungDementiaPatinetAddRadioItem2(){
    if(youngDementiaPatinetAddRadioItem2==null){

      youngDementiaPatinetAddRadioItem2 = new ACRadioButtonItem();

      youngDementiaPatinetAddRadioItem2.setText("����");

      youngDementiaPatinetAddRadioItem2.setGroup(getYoungDementiaPatinetAddRadioGroup());

      youngDementiaPatinetAddRadioItem2.setConstraints(VRLayout.FLOW);

      addYoungDementiaPatinetAddRadioItem2();
    }
    return youngDementiaPatinetAddRadioItem2;

  }

  /**
   * �ޏ��֘A���Z���擾���܂��B
   * @return �ޏ��֘A���Z
   */
  public ACLabelContainer getKaigoWelfareFacilityHijoAddition(){
    if(kaigoWelfareFacilityHijoAddition==null){

      kaigoWelfareFacilityHijoAddition = new ACLabelContainer();

      kaigoWelfareFacilityHijoAddition.setText("�ޏ��֘A���Z");

      kaigoWelfareFacilityHijoAddition.setFollowChildEnabled(true);

      addKaigoWelfareFacilityHijoAddition();
    }
    return kaigoWelfareFacilityHijoAddition;

  }

  /**
   * �ޏ��O�K�⑊�k�������Z���擾���܂��B
   * @return �ޏ��O�K�⑊�k�������Z
   */
  public ACIntegerCheckBox getHijoPreConsultationAddition(){
    if(hijoPreConsultationAddition==null){

      hijoPreConsultationAddition = new ACIntegerCheckBox();

      hijoPreConsultationAddition.setText("�ޏ��O�K�⑊�k�������Z");

      hijoPreConsultationAddition.setBindPath("3020109");

      hijoPreConsultationAddition.setSelectValue(2);

      hijoPreConsultationAddition.setUnSelectValue(1);

      addHijoPreConsultationAddition();
    }
    return hijoPreConsultationAddition;

  }

  /**
   * �ޏ���K�⑊�k�������Z���擾���܂��B
   * @return �ޏ���K�⑊�k�������Z
   */
  public ACIntegerCheckBox getHijoAfterConsultationAddition(){
    if(hijoAfterConsultationAddition==null){

      hijoAfterConsultationAddition = new ACIntegerCheckBox();

      hijoAfterConsultationAddition.setText("�ޏ���K�⑊�k�������Z");

      hijoAfterConsultationAddition.setBindPath("3020110");

      hijoAfterConsultationAddition.setSelectValue(2);

      hijoAfterConsultationAddition.setUnSelectValue(1);

      addHijoAfterConsultationAddition();
    }
    return hijoAfterConsultationAddition;

  }

  /**
   * �ޏ������k�������Z���擾���܂��B
   * @return �ޏ������k�������Z
   */
  public ACIntegerCheckBox getHijoConsultationAddition(){
    if(hijoConsultationAddition==null){

      hijoConsultationAddition = new ACIntegerCheckBox();

      hijoConsultationAddition.setText("�ޏ������k�������Z");

      hijoConsultationAddition.setBindPath("3020102");

      hijoConsultationAddition.setSelectValue(2);

      hijoConsultationAddition.setUnSelectValue(1);

      addHijoConsultationAddition();
    }
    return hijoConsultationAddition;

  }

  /**
   * �ޏ��O�A�g���Z���擾���܂��B
   * @return �ޏ��O�A�g���Z
   */
  public ACIntegerCheckBox getHijoCooperationAddition(){
    if(hijoCooperationAddition==null){

      hijoCooperationAddition = new ACIntegerCheckBox();

      hijoCooperationAddition.setText("�ޏ��O�A�g���Z");

      hijoCooperationAddition.setBindPath("3020103");

      hijoCooperationAddition.setSelectValue(2);

      hijoCooperationAddition.setUnSelectValue(1);

      addHijoCooperationAddition();
    }
    return hijoCooperationAddition;

  }

  /**
   * �^�u4���擾���܂��B
   * @return �^�u4
   */
  public ACPanel getTab4(){
    if(tab4==null){

      tab4 = new ACPanel();

      tab4.setFollowChildEnabled(true);

      tab4.setHgap(0);

      addTab4();
    }
    return tab4;

  }

  /**
   * �l�����Z���擾���܂��B
   * @return �l�����Z
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityStaffSubtraction(){
    if(kaigoWelfareFacilityStaffSubtraction==null){

      kaigoWelfareFacilityStaffSubtraction = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityStaffSubtractionContainer().setText("�l�����Z");

      kaigoWelfareFacilityStaffSubtraction.setBindPath("1510120");

      kaigoWelfareFacilityStaffSubtraction.setUseClearButton(false);

      kaigoWelfareFacilityStaffSubtraction.setModel(getKaigoWelfareFacilityStaffSubtractionModel());

      kaigoWelfareFacilityStaffSubtraction.setValues(new int[]{1,2,3});

      addKaigoWelfareFacilityStaffSubtraction();
    }
    return kaigoWelfareFacilityStaffSubtraction;

  }

  /**
   * �l�����Z�R���e�i���擾���܂��B
   * @return �l�����Z�R���e�i
   */
  protected ACLabelContainer getKaigoWelfareFacilityStaffSubtractionContainer(){
    if(kaigoWelfareFacilityStaffSubtractionContainer==null){
      kaigoWelfareFacilityStaffSubtractionContainer = new ACLabelContainer();
      kaigoWelfareFacilityStaffSubtractionContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityStaffSubtractionContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityStaffSubtractionContainer.add(getKaigoWelfareFacilityStaffSubtraction(), null);
    }
    return kaigoWelfareFacilityStaffSubtractionContainer;
  }

  /**
   * �l�����Z���f�����擾���܂��B
   * @return �l�����Z���f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityStaffSubtractionModel(){
    if(kaigoWelfareFacilityStaffSubtractionModel==null){
      kaigoWelfareFacilityStaffSubtractionModel = new ACListModelAdapter();
      addKaigoWelfareFacilityStaffSubtractionModel();
    }
    return kaigoWelfareFacilityStaffSubtractionModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoWelfareFacilityStaffSubtractionCapacityNot(){
    if(kaigoWelfareFacilityStaffSubtractionCapacityNot==null){

      kaigoWelfareFacilityStaffSubtractionCapacityNot = new ACRadioButtonItem();

      kaigoWelfareFacilityStaffSubtractionCapacityNot.setText("�Ȃ�");

      kaigoWelfareFacilityStaffSubtractionCapacityNot.setGroup(getKaigoWelfareFacilityStaffSubtraction());

      kaigoWelfareFacilityStaffSubtractionCapacityNot.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityStaffSubtractionCapacityNot();
    }
    return kaigoWelfareFacilityStaffSubtractionCapacityNot;

  }

  /**
   * ������߂��擾���܂��B
   * @return �������
   */
  public ACRadioButtonItem getKaigoWelfareFacilityStaffSubtractionCapacityExcess(){
    if(kaigoWelfareFacilityStaffSubtractionCapacityExcess==null){

      kaigoWelfareFacilityStaffSubtractionCapacityExcess = new ACRadioButtonItem();

      kaigoWelfareFacilityStaffSubtractionCapacityExcess.setText("�������");

      kaigoWelfareFacilityStaffSubtractionCapacityExcess.setGroup(getKaigoWelfareFacilityStaffSubtraction());

      kaigoWelfareFacilityStaffSubtractionCapacityExcess.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoWelfareFacilityStaffSubtractionCapacityExcess();
    }
    return kaigoWelfareFacilityStaffSubtractionCapacityExcess;

  }

  /**
   * �Ō�E���E�����͉��x�������̕s�����擾���܂��B
   * @return �Ō�E���E�����͉��x�������̕s��
   */
  public ACRadioButtonItem getKaigoWelfareFacilityStaffSubtractionPersonLack(){
    if(kaigoWelfareFacilityStaffSubtractionPersonLack==null){

      kaigoWelfareFacilityStaffSubtractionPersonLack = new ACRadioButtonItem();

      kaigoWelfareFacilityStaffSubtractionPersonLack.setText("<html>�Ō�E���E������<br>���x�������̕s��</html>");

      kaigoWelfareFacilityStaffSubtractionPersonLack.setGroup(getKaigoWelfareFacilityStaffSubtraction());

      kaigoWelfareFacilityStaffSubtractionPersonLack.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityStaffSubtractionPersonLack();
    }
    return kaigoWelfareFacilityStaffSubtractionPersonLack;

  }

  /**
   * �H���R���e�i���擾���܂��B
   * @return �H���R���e�i
   */
  public ACBackLabelContainer getKaigoWelfareFacilityDinnerContainer(){
    if(kaigoWelfareFacilityDinnerContainer==null){

      kaigoWelfareFacilityDinnerContainer = new ACBackLabelContainer();

      kaigoWelfareFacilityDinnerContainer.setFollowChildEnabled(true);

      addKaigoWelfareFacilityDinnerContainer();
    }
    return kaigoWelfareFacilityDinnerContainer;

  }

  /**
   * �H���񋟂��擾���܂��B
   * @return �H����
   */
  public ACComboBox getKaigoWelfareFacilityDinnerOffer(){
    if(kaigoWelfareFacilityDinnerOffer==null){

      kaigoWelfareFacilityDinnerOffer = new ACComboBox();

      getKaigoWelfareFacilityDinnerOfferContainer().setText("�H����");

      kaigoWelfareFacilityDinnerOffer.setBindPath("1510121");

      kaigoWelfareFacilityDinnerOffer.setEditable(false);

      kaigoWelfareFacilityDinnerOffer.setModelBindPath("1510121");

      kaigoWelfareFacilityDinnerOffer.setRenderBindPath("CONTENT");

      kaigoWelfareFacilityDinnerOffer.setModel(getKaigoWelfareFacilityDinnerOfferModel());

      addKaigoWelfareFacilityDinnerOffer();
    }
    return kaigoWelfareFacilityDinnerOffer;

  }

  /**
   * �H���񋟃R���e�i���擾���܂��B
   * @return �H���񋟃R���e�i
   */
  protected ACLabelContainer getKaigoWelfareFacilityDinnerOfferContainer(){
    if(kaigoWelfareFacilityDinnerOfferContainer==null){
      kaigoWelfareFacilityDinnerOfferContainer = new ACLabelContainer();
      kaigoWelfareFacilityDinnerOfferContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityDinnerOfferContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityDinnerOfferContainer.add(getKaigoWelfareFacilityDinnerOffer(), null);
    }
    return kaigoWelfareFacilityDinnerOfferContainer;
  }

  /**
   * �H���񋟃��f�����擾���܂��B
   * @return �H���񋟃��f��
   */
  protected ACComboBoxModelAdapter getKaigoWelfareFacilityDinnerOfferModel(){
    if(kaigoWelfareFacilityDinnerOfferModel==null){
      kaigoWelfareFacilityDinnerOfferModel = new ACComboBoxModelAdapter();
      addKaigoWelfareFacilityDinnerOfferModel();
    }
    return kaigoWelfareFacilityDinnerOfferModel;
  }

  /**
   * �H����p���擾���܂��B
   * @return �H����p
   */
  public ACTextField getKaigoWelfareFacilityDinnerCost(){
    if(kaigoWelfareFacilityDinnerCost==null){

      kaigoWelfareFacilityDinnerCost = new ACTextField();

      getKaigoWelfareFacilityDinnerCostContainer().setText("�H����p");

      kaigoWelfareFacilityDinnerCost.setBindPath("1510123");

      kaigoWelfareFacilityDinnerCost.setColumns(4);

      kaigoWelfareFacilityDinnerCost.setCharType(VRCharType.ONLY_DIGIT);

      kaigoWelfareFacilityDinnerCost.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoWelfareFacilityDinnerCost.setIMEMode(InputSubset.LATIN);

      kaigoWelfareFacilityDinnerCost.setMaxLength(5);

      addKaigoWelfareFacilityDinnerCost();
    }
    return kaigoWelfareFacilityDinnerCost;

  }

  /**
   * �H����p�R���e�i���擾���܂��B
   * @return �H����p�R���e�i
   */
  protected ACLabelContainer getKaigoWelfareFacilityDinnerCostContainer(){
    if(kaigoWelfareFacilityDinnerCostContainer==null){
      kaigoWelfareFacilityDinnerCostContainer = new ACLabelContainer();
      kaigoWelfareFacilityDinnerCostContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityDinnerCostContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityDinnerCostContainer.add(getKaigoWelfareFacilityDinnerCost(), null);
    }
    return kaigoWelfareFacilityDinnerCostContainer;
  }

  /**
   * �g�̍S���p�~�����{���Z���擾���܂��B
   * @return �g�̍S���p�~�����{���Z
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityBodyRestraintAbolitionRadio(){
    if(kaigoWelfareFacilityBodyRestraintAbolitionRadio==null){

      kaigoWelfareFacilityBodyRestraintAbolitionRadio = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityBodyRestraintAbolitionRadioContainer().setText("�g�̍S���p�~�����{���Z");

      kaigoWelfareFacilityBodyRestraintAbolitionRadio.setBindPath("1510128");

      kaigoWelfareFacilityBodyRestraintAbolitionRadio.setUseClearButton(false);

      kaigoWelfareFacilityBodyRestraintAbolitionRadio.setModel(getKaigoWelfareFacilityBodyRestraintAbolitionRadioModel());

      kaigoWelfareFacilityBodyRestraintAbolitionRadio.setValues(new int[]{1,2});

      addKaigoWelfareFacilityBodyRestraintAbolitionRadio();
    }
    return kaigoWelfareFacilityBodyRestraintAbolitionRadio;

  }

  /**
   * �g�̍S���p�~�����{���Z�R���e�i���擾���܂��B
   * @return �g�̍S���p�~�����{���Z�R���e�i
   */
  protected ACLabelContainer getKaigoWelfareFacilityBodyRestraintAbolitionRadioContainer(){
    if(kaigoWelfareFacilityBodyRestraintAbolitionRadioContainer==null){
      kaigoWelfareFacilityBodyRestraintAbolitionRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityBodyRestraintAbolitionRadioContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityBodyRestraintAbolitionRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityBodyRestraintAbolitionRadioContainer.add(getKaigoWelfareFacilityBodyRestraintAbolitionRadio(), null);
    }
    return kaigoWelfareFacilityBodyRestraintAbolitionRadioContainer;
  }

  /**
   * �g�̍S���p�~�����{���Z���f�����擾���܂��B
   * @return �g�̍S���p�~�����{���Z���f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityBodyRestraintAbolitionRadioModel(){
    if(kaigoWelfareFacilityBodyRestraintAbolitionRadioModel==null){
      kaigoWelfareFacilityBodyRestraintAbolitionRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityBodyRestraintAbolitionRadioModel();
    }
    return kaigoWelfareFacilityBodyRestraintAbolitionRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoWelfareFacilityBodyRestraintAbolitionRadioItem1(){
    if(kaigoWelfareFacilityBodyRestraintAbolitionRadioItem1==null){

      kaigoWelfareFacilityBodyRestraintAbolitionRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityBodyRestraintAbolitionRadioItem1.setText("�Ȃ�");

      kaigoWelfareFacilityBodyRestraintAbolitionRadioItem1.setGroup(getKaigoWelfareFacilityBodyRestraintAbolitionRadio());

      kaigoWelfareFacilityBodyRestraintAbolitionRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityBodyRestraintAbolitionRadioItem1();
    }
    return kaigoWelfareFacilityBodyRestraintAbolitionRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoWelfareFacilityBodyRestraintAbolitionRadioItem2(){
    if(kaigoWelfareFacilityBodyRestraintAbolitionRadioItem2==null){

      kaigoWelfareFacilityBodyRestraintAbolitionRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityBodyRestraintAbolitionRadioItem2.setText("����");

      kaigoWelfareFacilityBodyRestraintAbolitionRadioItem2.setGroup(getKaigoWelfareFacilityBodyRestraintAbolitionRadio());

      kaigoWelfareFacilityBodyRestraintAbolitionRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityBodyRestraintAbolitionRadioItem2();
    }
    return kaigoWelfareFacilityBodyRestraintAbolitionRadioItem2;

  }

  /**
   * �Ŏ������Z�R���e�i2���擾���܂��B
   * @return �Ŏ������Z�R���e�i2
   */
  public ACLabelContainer getKaigoWelfareFacilityTakingCareNursingAddDaysContainer2(){
    if(kaigoWelfareFacilityTakingCareNursingAddDaysContainer2==null){

      kaigoWelfareFacilityTakingCareNursingAddDaysContainer2 = new ACLabelContainer();

      kaigoWelfareFacilityTakingCareNursingAddDaysContainer2.setText("�Ŏ������Z");

      kaigoWelfareFacilityTakingCareNursingAddDaysContainer2.setFollowChildEnabled(true);

      addKaigoWelfareFacilityTakingCareNursingAddDaysContainer2();
    }
    return kaigoWelfareFacilityTakingCareNursingAddDaysContainer2;

  }

  /**
   * �Ŏ������Z�^���擾���܂��B
   * @return �Ŏ������Z�^
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityTakingCareNursingPtn(){
    if(kaigoWelfareFacilityTakingCareNursingPtn==null){

      kaigoWelfareFacilityTakingCareNursingPtn = new ACValueArrayRadioButtonGroup();

      kaigoWelfareFacilityTakingCareNursingPtn.setBindPath("1510147");

      kaigoWelfareFacilityTakingCareNursingPtn.setNoSelectIndex(0);

      kaigoWelfareFacilityTakingCareNursingPtn.setUseClearButton(false);

      kaigoWelfareFacilityTakingCareNursingPtn.setModel(getKaigoWelfareFacilityTakingCareNursingPtnModel());

      kaigoWelfareFacilityTakingCareNursingPtn.setValues(new int[]{1,2,3});

      addKaigoWelfareFacilityTakingCareNursingPtn();
    }
    return kaigoWelfareFacilityTakingCareNursingPtn;

  }

  /**
   * �Ŏ������Z�^���f�����擾���܂��B
   * @return �Ŏ������Z�^���f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityTakingCareNursingPtnModel(){
    if(kaigoWelfareFacilityTakingCareNursingPtnModel==null){
      kaigoWelfareFacilityTakingCareNursingPtnModel = new ACListModelAdapter();
      addKaigoWelfareFacilityTakingCareNursingPtnModel();
    }
    return kaigoWelfareFacilityTakingCareNursingPtnModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoWelfareFacilityTakingCareNursingPtnItem1(){
    if(kaigoWelfareFacilityTakingCareNursingPtnItem1==null){

      kaigoWelfareFacilityTakingCareNursingPtnItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityTakingCareNursingPtnItem1.setText("�Ȃ�");

      kaigoWelfareFacilityTakingCareNursingPtnItem1.setGroup(getKaigoWelfareFacilityTakingCareNursingPtn());

      kaigoWelfareFacilityTakingCareNursingPtnItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityTakingCareNursingPtnItem1();
    }
    return kaigoWelfareFacilityTakingCareNursingPtnItem1;

  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getKaigoWelfareFacilityTakingCareNursingPtnItem2(){
    if(kaigoWelfareFacilityTakingCareNursingPtnItem2==null){

      kaigoWelfareFacilityTakingCareNursingPtnItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityTakingCareNursingPtnItem2.setText("I�^");

      kaigoWelfareFacilityTakingCareNursingPtnItem2.setGroup(getKaigoWelfareFacilityTakingCareNursingPtn());

      kaigoWelfareFacilityTakingCareNursingPtnItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityTakingCareNursingPtnItem2();
    }
    return kaigoWelfareFacilityTakingCareNursingPtnItem2;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getKaigoWelfareFacilityTakingCareNursingPtnItem3(){
    if(kaigoWelfareFacilityTakingCareNursingPtnItem3==null){

      kaigoWelfareFacilityTakingCareNursingPtnItem3 = new ACRadioButtonItem();

      kaigoWelfareFacilityTakingCareNursingPtnItem3.setText("II�^");

      kaigoWelfareFacilityTakingCareNursingPtnItem3.setGroup(getKaigoWelfareFacilityTakingCareNursingPtn());

      kaigoWelfareFacilityTakingCareNursingPtnItem3.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityTakingCareNursingPtnItem3();
    }
    return kaigoWelfareFacilityTakingCareNursingPtnItem3;

  }

  /**
   * �Ŏ������Z��ʂ��擾���܂��B
   * @return �Ŏ������Z���
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityTakingCareNursingAddRadio(){
    if(kaigoWelfareFacilityTakingCareNursingAddRadio==null){

      kaigoWelfareFacilityTakingCareNursingAddRadio = new ACValueArrayRadioButtonGroup();

      kaigoWelfareFacilityTakingCareNursingAddRadio.setBindPath("1510139");

      kaigoWelfareFacilityTakingCareNursingAddRadio.setNoSelectIndex(0);

      kaigoWelfareFacilityTakingCareNursingAddRadio.setUseClearButton(false);

      kaigoWelfareFacilityTakingCareNursingAddRadio.setModel(getKaigoWelfareFacilityTakingCareNursingAddRadioModel());

      kaigoWelfareFacilityTakingCareNursingAddRadio.setValues(new int[]{2,3,4});

      addKaigoWelfareFacilityTakingCareNursingAddRadio();
    }
    return kaigoWelfareFacilityTakingCareNursingAddRadio;

  }

  /**
   * �Ŏ������Z��ʃ��f�����擾���܂��B
   * @return �Ŏ������Z��ʃ��f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityTakingCareNursingAddRadioModel(){
    if(kaigoWelfareFacilityTakingCareNursingAddRadioModel==null){
      kaigoWelfareFacilityTakingCareNursingAddRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityTakingCareNursingAddRadioModel();
    }
    return kaigoWelfareFacilityTakingCareNursingAddRadioModel;
  }

  /**
   * ���S���ȑO4���ȏ�30���ȉ����擾���܂��B
   * @return ���S���ȑO4���ȏ�30���ȉ�
   */
  public ACRadioButtonItem getKaigoWelfareFacilityTakingCareNursingAddRadioItem2(){
    if(kaigoWelfareFacilityTakingCareNursingAddRadioItem2==null){

      kaigoWelfareFacilityTakingCareNursingAddRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityTakingCareNursingAddRadioItem2.setText("���S���ȑO4���ȏ�30���ȉ�");

      kaigoWelfareFacilityTakingCareNursingAddRadioItem2.setGroup(getKaigoWelfareFacilityTakingCareNursingAddRadio());

      kaigoWelfareFacilityTakingCareNursingAddRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoWelfareFacilityTakingCareNursingAddRadioItem2();
    }
    return kaigoWelfareFacilityTakingCareNursingAddRadioItem2;

  }

  /**
   * ���S���ȑO2������3�����擾���܂��B
   * @return ���S���ȑO2������3��
   */
  public ACRadioButtonItem getKaigoWelfareFacilityTakingCareNursingAddRadioItem3(){
    if(kaigoWelfareFacilityTakingCareNursingAddRadioItem3==null){

      kaigoWelfareFacilityTakingCareNursingAddRadioItem3 = new ACRadioButtonItem();

      kaigoWelfareFacilityTakingCareNursingAddRadioItem3.setText("���S���ȑO2������3��");

      kaigoWelfareFacilityTakingCareNursingAddRadioItem3.setGroup(getKaigoWelfareFacilityTakingCareNursingAddRadio());

      kaigoWelfareFacilityTakingCareNursingAddRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoWelfareFacilityTakingCareNursingAddRadioItem3();
    }
    return kaigoWelfareFacilityTakingCareNursingAddRadioItem3;

  }

  /**
   * ���S�����擾���܂��B
   * @return ���S��
   */
  public ACRadioButtonItem getKaigoWelfareFacilityTakingCareNursingAddRadioItem4(){
    if(kaigoWelfareFacilityTakingCareNursingAddRadioItem4==null){

      kaigoWelfareFacilityTakingCareNursingAddRadioItem4 = new ACRadioButtonItem();

      kaigoWelfareFacilityTakingCareNursingAddRadioItem4.setText("���S��");

      kaigoWelfareFacilityTakingCareNursingAddRadioItem4.setGroup(getKaigoWelfareFacilityTakingCareNursingAddRadio());

      kaigoWelfareFacilityTakingCareNursingAddRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoWelfareFacilityTakingCareNursingAddRadioItem4();
    }
    return kaigoWelfareFacilityTakingCareNursingAddRadioItem4;

  }

  /**
   * �Ŏ������Z�����R���e�i���擾���܂��B
   * @return �Ŏ������Z�����R���e�i
   */
  public ACLabelContainer getKaigoWelfareFacilityTakingCareNursingAddDaysContainer(){
    if(kaigoWelfareFacilityTakingCareNursingAddDaysContainer==null){

      kaigoWelfareFacilityTakingCareNursingAddDaysContainer = new ACLabelContainer();

      kaigoWelfareFacilityTakingCareNursingAddDaysContainer.setText("�Ŏ������Z����");

      kaigoWelfareFacilityTakingCareNursingAddDaysContainer.setFollowChildEnabled(true);

      addKaigoWelfareFacilityTakingCareNursingAddDaysContainer();
    }
    return kaigoWelfareFacilityTakingCareNursingAddDaysContainer;

  }

  /**
   * �Ŏ������Z�������擾���܂��B
   * @return �Ŏ������Z����
   */
  public ACTextField getKaigoWelfareFacilityTakingCareNursingAddDays(){
    if(kaigoWelfareFacilityTakingCareNursingAddDays==null){

      kaigoWelfareFacilityTakingCareNursingAddDays = new ACTextField();

      kaigoWelfareFacilityTakingCareNursingAddDays.setText("1");

      kaigoWelfareFacilityTakingCareNursingAddDays.setBindPath("1510132");

      kaigoWelfareFacilityTakingCareNursingAddDays.setColumns(2);

      kaigoWelfareFacilityTakingCareNursingAddDays.setCharType(VRCharType.ONLY_DIGIT);

      kaigoWelfareFacilityTakingCareNursingAddDays.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoWelfareFacilityTakingCareNursingAddDays.setMaxLength(2);

      addKaigoWelfareFacilityTakingCareNursingAddDays();
    }
    return kaigoWelfareFacilityTakingCareNursingAddDays;

  }

  /**
   * �Ŏ������Z�����P�ʂ��擾���܂��B
   * @return �Ŏ������Z�����P��
   */
  public ACLabel getKaigoWelfareFacilityTakingCareNursingAddDaysUnit(){
    if(kaigoWelfareFacilityTakingCareNursingAddDaysUnit==null){

      kaigoWelfareFacilityTakingCareNursingAddDaysUnit = new ACLabel();

      kaigoWelfareFacilityTakingCareNursingAddDaysUnit.setText("��");

      addKaigoWelfareFacilityTakingCareNursingAddDaysUnit();
    }
    return kaigoWelfareFacilityTakingCareNursingAddDaysUnit;

  }

  /**
   * �^�u5���擾���܂��B
   * @return �^�u5
   */
  public ACPanel getTab5(){
    if(tab5==null){

      tab5 = new ACPanel();

      tab5.setFollowChildEnabled(true);

      tab5.setHgap(0);

      addTab5();
    }
    return tab5;

  }

  /**
   * �ݑ�A�x���@�\���Z���擾���܂��B
   * @return �ݑ�A�x���@�\���Z
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityStayReturnSupportAddRadio(){
    if(kaigoWelfareFacilityStayReturnSupportAddRadio==null){

      kaigoWelfareFacilityStayReturnSupportAddRadio = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityStayReturnSupportAddRadioContainer().setText("�ݑ�A�x���@�\���Z");

      kaigoWelfareFacilityStayReturnSupportAddRadio.setBindPath("1510130");

      kaigoWelfareFacilityStayReturnSupportAddRadio.setUseClearButton(false);

      kaigoWelfareFacilityStayReturnSupportAddRadio.setModel(getKaigoWelfareFacilityStayReturnSupportAddRadioModel());

      kaigoWelfareFacilityStayReturnSupportAddRadio.setValues(new int[]{1,2});

      addKaigoWelfareFacilityStayReturnSupportAddRadio();
    }
    return kaigoWelfareFacilityStayReturnSupportAddRadio;

  }

  /**
   * �ݑ�A�x���@�\���Z�R���e�i���擾���܂��B
   * @return �ݑ�A�x���@�\���Z�R���e�i
   */
  protected ACLabelContainer getKaigoWelfareFacilityStayReturnSupportAddRadioContainer(){
    if(kaigoWelfareFacilityStayReturnSupportAddRadioContainer==null){
      kaigoWelfareFacilityStayReturnSupportAddRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityStayReturnSupportAddRadioContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityStayReturnSupportAddRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityStayReturnSupportAddRadioContainer.add(getKaigoWelfareFacilityStayReturnSupportAddRadio(), null);
    }
    return kaigoWelfareFacilityStayReturnSupportAddRadioContainer;
  }

  /**
   * �ݑ�A�x���@�\���Z���f�����擾���܂��B
   * @return �ݑ�A�x���@�\���Z���f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityStayReturnSupportAddRadioModel(){
    if(kaigoWelfareFacilityStayReturnSupportAddRadioModel==null){
      kaigoWelfareFacilityStayReturnSupportAddRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityStayReturnSupportAddRadioModel();
    }
    return kaigoWelfareFacilityStayReturnSupportAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoWelfareFacilityStayReturnSupportAddRadioItem1(){
    if(kaigoWelfareFacilityStayReturnSupportAddRadioItem1==null){

      kaigoWelfareFacilityStayReturnSupportAddRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityStayReturnSupportAddRadioItem1.setText("�Ȃ�");

      kaigoWelfareFacilityStayReturnSupportAddRadioItem1.setGroup(getKaigoWelfareFacilityStayReturnSupportAddRadio());

      kaigoWelfareFacilityStayReturnSupportAddRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityStayReturnSupportAddRadioItem1();
    }
    return kaigoWelfareFacilityStayReturnSupportAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoWelfareFacilityStayReturnSupportAddRadioItem2(){
    if(kaigoWelfareFacilityStayReturnSupportAddRadioItem2==null){

      kaigoWelfareFacilityStayReturnSupportAddRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityStayReturnSupportAddRadioItem2.setText("����");

      kaigoWelfareFacilityStayReturnSupportAddRadioItem2.setGroup(getKaigoWelfareFacilityStayReturnSupportAddRadio());

      kaigoWelfareFacilityStayReturnSupportAddRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityStayReturnSupportAddRadioItem2();
    }
    return kaigoWelfareFacilityStayReturnSupportAddRadioItem2;

  }

  /**
   * �ݑ�E�������ݗ��p���Z���擾���܂��B
   * @return �ݑ�E�������ݗ��p���Z
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityHomeShareAddRadio(){
    if(kaigoWelfareFacilityHomeShareAddRadio==null){

      kaigoWelfareFacilityHomeShareAddRadio = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityHomeShareAddRadioContainer().setText("�ݑ�E�������ݗ��p���Z");

      kaigoWelfareFacilityHomeShareAddRadio.setBindPath("1510131");

      kaigoWelfareFacilityHomeShareAddRadio.setUseClearButton(false);

      kaigoWelfareFacilityHomeShareAddRadio.setModel(getKaigoWelfareFacilityHomeShareAddRadioModel());

      kaigoWelfareFacilityHomeShareAddRadio.setValues(new int[]{1,2});

      addKaigoWelfareFacilityHomeShareAddRadio();
    }
    return kaigoWelfareFacilityHomeShareAddRadio;

  }

  /**
   * �ݑ�E�������ݗ��p���Z�R���e�i���擾���܂��B
   * @return �ݑ�E�������ݗ��p���Z�R���e�i
   */
  protected ACLabelContainer getKaigoWelfareFacilityHomeShareAddRadioContainer(){
    if(kaigoWelfareFacilityHomeShareAddRadioContainer==null){
      kaigoWelfareFacilityHomeShareAddRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityHomeShareAddRadioContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityHomeShareAddRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityHomeShareAddRadioContainer.add(getKaigoWelfareFacilityHomeShareAddRadio(), null);
    }
    return kaigoWelfareFacilityHomeShareAddRadioContainer;
  }

  /**
   * �ݑ�E�������ݗ��p���Z���f�����擾���܂��B
   * @return �ݑ�E�������ݗ��p���Z���f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityHomeShareAddRadioModel(){
    if(kaigoWelfareFacilityHomeShareAddRadioModel==null){
      kaigoWelfareFacilityHomeShareAddRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityHomeShareAddRadioModel();
    }
    return kaigoWelfareFacilityHomeShareAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoWelfareFacilityHomeShareAddRadioItem1(){
    if(kaigoWelfareFacilityHomeShareAddRadioItem1==null){

      kaigoWelfareFacilityHomeShareAddRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityHomeShareAddRadioItem1.setText("�Ȃ�");

      kaigoWelfareFacilityHomeShareAddRadioItem1.setGroup(getKaigoWelfareFacilityHomeShareAddRadio());

      kaigoWelfareFacilityHomeShareAddRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityHomeShareAddRadioItem1();
    }
    return kaigoWelfareFacilityHomeShareAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoWelfareFacilityHomeShareAddRadioItem2(){
    if(kaigoWelfareFacilityHomeShareAddRadioItem2==null){

      kaigoWelfareFacilityHomeShareAddRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityHomeShareAddRadioItem2.setText("����");

      kaigoWelfareFacilityHomeShareAddRadioItem2.setGroup(getKaigoWelfareFacilityHomeShareAddRadio());

      kaigoWelfareFacilityHomeShareAddRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityHomeShareAddRadioItem2();
    }
    return kaigoWelfareFacilityHomeShareAddRadioItem2;

  }

  /**
   * �F�m�ǐ��P�A���Z���擾���܂��B
   * @return �F�m�ǐ��P�A���Z
   */
  public ACValueArrayRadioButtonGroup getDementiaProfessionalCareAddRadioGroup(){
    if(dementiaProfessionalCareAddRadioGroup==null){

      dementiaProfessionalCareAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaProfessionalCareAddRadioGroupContainer().setText("�F�m�ǐ��P�A���Z");

      dementiaProfessionalCareAddRadioGroup.setBindPath("1510140");

      dementiaProfessionalCareAddRadioGroup.setVisible(true);

      dementiaProfessionalCareAddRadioGroup.setEnabled(true);

      dementiaProfessionalCareAddRadioGroup.setNoSelectIndex(0);

      dementiaProfessionalCareAddRadioGroup.setUseClearButton(false);

      dementiaProfessionalCareAddRadioGroup.setModel(getDementiaProfessionalCareAddRadioGroupModel());

      dementiaProfessionalCareAddRadioGroup.setValues(new int[]{1,2,3});

      addDementiaProfessionalCareAddRadioGroup();
    }
    return dementiaProfessionalCareAddRadioGroup;

  }

  /**
   * �F�m�ǐ��P�A���Z�R���e�i���擾���܂��B
   * @return �F�m�ǐ��P�A���Z�R���e�i
   */
  protected ACLabelContainer getDementiaProfessionalCareAddRadioGroupContainer(){
    if(dementiaProfessionalCareAddRadioGroupContainer==null){
      dementiaProfessionalCareAddRadioGroupContainer = new ACLabelContainer();
      dementiaProfessionalCareAddRadioGroupContainer.setFollowChildEnabled(true);
      dementiaProfessionalCareAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      dementiaProfessionalCareAddRadioGroupContainer.add(getDementiaProfessionalCareAddRadioGroup(), null);
    }
    return dementiaProfessionalCareAddRadioGroupContainer;
  }

  /**
   * �F�m�ǐ��P�A���Z���f�����擾���܂��B
   * @return �F�m�ǐ��P�A���Z���f��
   */
  protected ACListModelAdapter getDementiaProfessionalCareAddRadioGroupModel(){
    if(dementiaProfessionalCareAddRadioGroupModel==null){
      dementiaProfessionalCareAddRadioGroupModel = new ACListModelAdapter();
      addDementiaProfessionalCareAddRadioGroupModel();
    }
    return dementiaProfessionalCareAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getDementiaProfessionalCareAddRadioItem1(){
    if(dementiaProfessionalCareAddRadioItem1==null){

      dementiaProfessionalCareAddRadioItem1 = new ACRadioButtonItem();

      dementiaProfessionalCareAddRadioItem1.setText("�Ȃ�");

      dementiaProfessionalCareAddRadioItem1.setGroup(getDementiaProfessionalCareAddRadioGroup());

      dementiaProfessionalCareAddRadioItem1.setConstraints(VRLayout.FLOW);

      addDementiaProfessionalCareAddRadioItem1();
    }
    return dementiaProfessionalCareAddRadioItem1;

  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getDementiaProfessionalCareAddRadioItem2(){
    if(dementiaProfessionalCareAddRadioItem2==null){

      dementiaProfessionalCareAddRadioItem2 = new ACRadioButtonItem();

      dementiaProfessionalCareAddRadioItem2.setText("I�^");

      dementiaProfessionalCareAddRadioItem2.setGroup(getDementiaProfessionalCareAddRadioGroup());

      dementiaProfessionalCareAddRadioItem2.setConstraints(VRLayout.FLOW);

      addDementiaProfessionalCareAddRadioItem2();
    }
    return dementiaProfessionalCareAddRadioItem2;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getDementiaProfessionalCareAddRadioItem3(){
    if(dementiaProfessionalCareAddRadioItem3==null){

      dementiaProfessionalCareAddRadioItem3 = new ACRadioButtonItem();

      dementiaProfessionalCareAddRadioItem3.setText("II�^");

      dementiaProfessionalCareAddRadioItem3.setGroup(getDementiaProfessionalCareAddRadioGroup());

      dementiaProfessionalCareAddRadioItem3.setConstraints(VRLayout.FLOW);

      addDementiaProfessionalCareAddRadioItem3();
    }
    return dementiaProfessionalCareAddRadioItem3;

  }

  /**
   * �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z���擾���܂��B
   * @return �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z
   */
  public ACValueArrayRadioButtonGroup getDementiaEmergencyAddRadioGroup(){
    if(dementiaEmergencyAddRadioGroup==null){

      dementiaEmergencyAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaEmergencyAddRadioGroupContainer().setText("�F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z");

      dementiaEmergencyAddRadioGroup.setBindPath("1510144");

      dementiaEmergencyAddRadioGroup.setNoSelectIndex(0);

      dementiaEmergencyAddRadioGroup.setUseClearButton(false);

      dementiaEmergencyAddRadioGroup.setModel(getDementiaEmergencyAddRadioGroupModel());

      dementiaEmergencyAddRadioGroup.setValues(new int[]{1,2});

      addDementiaEmergencyAddRadioGroup();
    }
    return dementiaEmergencyAddRadioGroup;

  }

  /**
   * �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z�R���e�i���擾���܂��B
   * @return �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z�R���e�i
   */
  protected ACLabelContainer getDementiaEmergencyAddRadioGroupContainer(){
    if(dementiaEmergencyAddRadioGroupContainer==null){
      dementiaEmergencyAddRadioGroupContainer = new ACLabelContainer();
      dementiaEmergencyAddRadioGroupContainer.setFollowChildEnabled(true);
      dementiaEmergencyAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      dementiaEmergencyAddRadioGroupContainer.add(getDementiaEmergencyAddRadioGroup(), null);
    }
    return dementiaEmergencyAddRadioGroupContainer;
  }

  /**
   * �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z���f�����擾���܂��B
   * @return �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z���f��
   */
  protected ACListModelAdapter getDementiaEmergencyAddRadioGroupModel(){
    if(dementiaEmergencyAddRadioGroupModel==null){
      dementiaEmergencyAddRadioGroupModel = new ACListModelAdapter();
      addDementiaEmergencyAddRadioGroupModel();
    }
    return dementiaEmergencyAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getDementiaEmergencyAddRadioItem1(){
    if(dementiaEmergencyAddRadioItem1==null){

      dementiaEmergencyAddRadioItem1 = new ACRadioButtonItem();

      dementiaEmergencyAddRadioItem1.setText("�Ȃ�");

      dementiaEmergencyAddRadioItem1.setGroup(getDementiaEmergencyAddRadioGroup());

      dementiaEmergencyAddRadioItem1.setConstraints(VRLayout.FLOW);

      addDementiaEmergencyAddRadioItem1();
    }
    return dementiaEmergencyAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getDementiaEmergencyAddRadioItem2(){
    if(dementiaEmergencyAddRadioItem2==null){

      dementiaEmergencyAddRadioItem2 = new ACRadioButtonItem();

      dementiaEmergencyAddRadioItem2.setText("����");

      dementiaEmergencyAddRadioItem2.setGroup(getDementiaEmergencyAddRadioGroup());

      dementiaEmergencyAddRadioItem2.setConstraints(VRLayout.FLOW);

      addDementiaEmergencyAddRadioItem2();
    }
    return dementiaEmergencyAddRadioItem2;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("�T�[�r�X�񋟑̐��������Z");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1510141");

      serviceAddProvisionStructuralRadioGroup.setVisible(true);

      serviceAddProvisionStructuralRadioGroup.setEnabled(true);

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,5,2,3,4});

      addServiceAddProvisionStructuralRadioGroup();
    }
    return serviceAddProvisionStructuralRadioGroup;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z�R���e�i���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z�R���e�i
   */
  protected ACLabelContainer getServiceAddProvisionStructuralRadioGroupContainer(){
    if(serviceAddProvisionStructuralRadioGroupContainer==null){
      serviceAddProvisionStructuralRadioGroupContainer = new ACLabelContainer();
      serviceAddProvisionStructuralRadioGroupContainer.setFollowChildEnabled(true);
      serviceAddProvisionStructuralRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      serviceAddProvisionStructuralRadioGroupContainer.add(getServiceAddProvisionStructuralRadioGroup(), null);
    }
    return serviceAddProvisionStructuralRadioGroupContainer;
  }

  /**
   * �T�[�r�X�񋟑̐��������Z���f�����擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z���f��
   */
  protected ACListModelAdapter getServiceAddProvisionStructuralRadioGroupModel(){
    if(serviceAddProvisionStructuralRadioGroupModel==null){
      serviceAddProvisionStructuralRadioGroupModel = new ACListModelAdapter();
      addServiceAddProvisionStructuralRadioGroupModel();
    }
    return serviceAddProvisionStructuralRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem1(){
    if(serviceAddProvisionStructuralRadioItem1==null){

      serviceAddProvisionStructuralRadioItem1 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem1.setText("�Ȃ�");

      serviceAddProvisionStructuralRadioItem1.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem1.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem1();
    }
    return serviceAddProvisionStructuralRadioItem1;

  }

  /**
   * I�C�^���擾���܂��B
   * @return I�C�^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem5(){
    if(serviceAddProvisionStructuralRadioItem5==null){

      serviceAddProvisionStructuralRadioItem5 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem5.setText("I�C�^");

      serviceAddProvisionStructuralRadioItem5.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem5.setConstraints(VRLayout.FLOW_RETURN);

      addServiceAddProvisionStructuralRadioItem5();
    }
    return serviceAddProvisionStructuralRadioItem5;

  }

  /**
   * I���^���擾���܂��B
   * @return I���^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("I���^");

      serviceAddProvisionStructuralRadioItem2.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem2.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem2();
    }
    return serviceAddProvisionStructuralRadioItem2;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem3(){
    if(serviceAddProvisionStructuralRadioItem3==null){

      serviceAddProvisionStructuralRadioItem3 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem3.setText("II�^");

      serviceAddProvisionStructuralRadioItem3.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem3.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem3();
    }
    return serviceAddProvisionStructuralRadioItem3;

  }

  /**
   * III�^���擾���܂��B
   * @return III�^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem4(){
    if(serviceAddProvisionStructuralRadioItem4==null){

      serviceAddProvisionStructuralRadioItem4 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem4.setText("III�^");

      serviceAddProvisionStructuralRadioItem4.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem4.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem4();
    }
    return serviceAddProvisionStructuralRadioItem4;

  }

  /**
   * �����@�\����A�g���Z���擾���܂��B
   * @return �����@�\����A�g���Z
   */
  public ACValueArrayRadioButtonGroup getImprovementCollaboration(){
    if(improvementCollaboration==null){

      improvementCollaboration = new ACValueArrayRadioButtonGroup();

      getImprovementCollaborationContainer().setText("�����@�\����A�g���Z");

      improvementCollaboration.setBindPath("1510148");

      improvementCollaboration.setUseClearButton(false);

      improvementCollaboration.setModel(getImprovementCollaborationModel());

      improvementCollaboration.setValues(new int[]{1,2});

      addImprovementCollaboration();
    }
    return improvementCollaboration;

  }

  /**
   * �����@�\����A�g���Z�R���e�i���擾���܂��B
   * @return �����@�\����A�g���Z�R���e�i
   */
  protected ACLabelContainer getImprovementCollaborationContainer(){
    if(improvementCollaborationContainer==null){
      improvementCollaborationContainer = new ACLabelContainer();
      improvementCollaborationContainer.setFollowChildEnabled(true);
      improvementCollaborationContainer.setVAlignment(VRLayout.CENTER);
      improvementCollaborationContainer.add(getImprovementCollaboration(), null);
    }
    return improvementCollaborationContainer;
  }

  /**
   * �����@�\����A�g���Z���f�����擾���܂��B
   * @return �����@�\����A�g���Z���f��
   */
  protected ACListModelAdapter getImprovementCollaborationModel(){
    if(improvementCollaborationModel==null){
      improvementCollaborationModel = new ACListModelAdapter();
      addImprovementCollaborationModel();
    }
    return improvementCollaborationModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getImprovementCollaborationItem1(){
    if(improvementCollaborationItem1==null){

      improvementCollaborationItem1 = new ACRadioButtonItem();

      improvementCollaborationItem1.setText("�Ȃ�");

      improvementCollaborationItem1.setGroup(getImprovementCollaboration());

      improvementCollaborationItem1.setConstraints(VRLayout.FLOW);

      addImprovementCollaborationItem1();
    }
    return improvementCollaborationItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getImprovementCollaborationItem2(){
    if(improvementCollaborationItem2==null){

      improvementCollaborationItem2 = new ACRadioButtonItem();

      improvementCollaborationItem2.setText("����");

      improvementCollaborationItem2.setGroup(getImprovementCollaboration());

      improvementCollaborationItem2.setConstraints(VRLayout.FLOW);

      addImprovementCollaborationItem2();
    }
    return improvementCollaborationItem2;

  }

  /**
   * �O�����ݑ�T�[�r�X���p��p���擾���܂��B
   * @return �O�����ݑ�T�[�r�X���p��p
   */
  public ACValueArrayRadioButtonGroup getHomeServiceUsageFeeAtHome(){
    if(homeServiceUsageFeeAtHome==null){

      homeServiceUsageFeeAtHome = new ACValueArrayRadioButtonGroup();

      getHomeServiceUsageFeeAtHomeContainer().setText("�O�����ݑ�T�[�r�X���p��p");

      homeServiceUsageFeeAtHome.setBindPath("1510149");

      homeServiceUsageFeeAtHome.setUseClearButton(false);

      homeServiceUsageFeeAtHome.setModel(getHomeServiceUsageFeeAtHomeModel());

      homeServiceUsageFeeAtHome.setValues(new int[]{1,2});

      addHomeServiceUsageFeeAtHome();
    }
    return homeServiceUsageFeeAtHome;

  }

  /**
   * �O�����ݑ�T�[�r�X���p��p�R���e�i���擾���܂��B
   * @return �O�����ݑ�T�[�r�X���p��p�R���e�i
   */
  protected ACLabelContainer getHomeServiceUsageFeeAtHomeContainer(){
    if(homeServiceUsageFeeAtHomeContainer==null){
      homeServiceUsageFeeAtHomeContainer = new ACLabelContainer();
      homeServiceUsageFeeAtHomeContainer.setFollowChildEnabled(true);
      homeServiceUsageFeeAtHomeContainer.setVAlignment(VRLayout.CENTER);
      homeServiceUsageFeeAtHomeContainer.add(getHomeServiceUsageFeeAtHome(), null);
    }
    return homeServiceUsageFeeAtHomeContainer;
  }

  /**
   * �O�����ݑ�T�[�r�X���p��p���f�����擾���܂��B
   * @return �O�����ݑ�T�[�r�X���p��p���f��
   */
  protected ACListModelAdapter getHomeServiceUsageFeeAtHomeModel(){
    if(homeServiceUsageFeeAtHomeModel==null){
      homeServiceUsageFeeAtHomeModel = new ACListModelAdapter();
      addHomeServiceUsageFeeAtHomeModel();
    }
    return homeServiceUsageFeeAtHomeModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHomeServiceUsageFeeAtHomeItem1(){
    if(homeServiceUsageFeeAtHomeItem1==null){

      homeServiceUsageFeeAtHomeItem1 = new ACRadioButtonItem();

      homeServiceUsageFeeAtHomeItem1.setText("�Ȃ�");

      homeServiceUsageFeeAtHomeItem1.setGroup(getHomeServiceUsageFeeAtHome());

      homeServiceUsageFeeAtHomeItem1.setConstraints(VRLayout.FLOW);

      addHomeServiceUsageFeeAtHomeItem1();
    }
    return homeServiceUsageFeeAtHomeItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHomeServiceUsageFeeAtHomeItem2(){
    if(homeServiceUsageFeeAtHomeItem2==null){

      homeServiceUsageFeeAtHomeItem2 = new ACRadioButtonItem();

      homeServiceUsageFeeAtHomeItem2.setText("����");

      homeServiceUsageFeeAtHomeItem2.setGroup(getHomeServiceUsageFeeAtHome());

      homeServiceUsageFeeAtHomeItem2.setConstraints(VRLayout.FLOW);

      addHomeServiceUsageFeeAtHomeItem2();
    }
    return homeServiceUsageFeeAtHomeItem2;

  }

  /**
   * �ē������h�{�A�g���Z���擾���܂��B
   * @return �ē������h�{�A�g���Z
   */
  public ACValueArrayRadioButtonGroup getReEntryNutritionCooperationAdd(){
    if(reEntryNutritionCooperationAdd==null){

      reEntryNutritionCooperationAdd = new ACValueArrayRadioButtonGroup();

      getReEntryNutritionCooperationAddContainer().setText("�ē������h�{�A�g���Z");

      reEntryNutritionCooperationAdd.setBindPath("1510150");

      reEntryNutritionCooperationAdd.setUseClearButton(false);

      reEntryNutritionCooperationAdd.setModel(getReEntryNutritionCooperationAddModel());

      reEntryNutritionCooperationAdd.setValues(new int[]{1,2});

      addReEntryNutritionCooperationAdd();
    }
    return reEntryNutritionCooperationAdd;

  }

  /**
   * �ē������h�{�A�g���Z�R���e�i���擾���܂��B
   * @return �ē������h�{�A�g���Z�R���e�i
   */
  protected ACLabelContainer getReEntryNutritionCooperationAddContainer(){
    if(reEntryNutritionCooperationAddContainer==null){
      reEntryNutritionCooperationAddContainer = new ACLabelContainer();
      reEntryNutritionCooperationAddContainer.setFollowChildEnabled(true);
      reEntryNutritionCooperationAddContainer.setVAlignment(VRLayout.CENTER);
      reEntryNutritionCooperationAddContainer.add(getReEntryNutritionCooperationAdd(), null);
    }
    return reEntryNutritionCooperationAddContainer;
  }

  /**
   * �ē������h�{�A�g���Z���f�����擾���܂��B
   * @return �ē������h�{�A�g���Z���f��
   */
  protected ACListModelAdapter getReEntryNutritionCooperationAddModel(){
    if(reEntryNutritionCooperationAddModel==null){
      reEntryNutritionCooperationAddModel = new ACListModelAdapter();
      addReEntryNutritionCooperationAddModel();
    }
    return reEntryNutritionCooperationAddModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getReEntryNutritionCooperationAddItem1(){
    if(reEntryNutritionCooperationAddItem1==null){

      reEntryNutritionCooperationAddItem1 = new ACRadioButtonItem();

      reEntryNutritionCooperationAddItem1.setText("�Ȃ�");

      reEntryNutritionCooperationAddItem1.setGroup(getReEntryNutritionCooperationAdd());

      reEntryNutritionCooperationAddItem1.setConstraints(VRLayout.FLOW);

      addReEntryNutritionCooperationAddItem1();
    }
    return reEntryNutritionCooperationAddItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getReEntryNutritionCooperationAddItem2(){
    if(reEntryNutritionCooperationAddItem2==null){

      reEntryNutritionCooperationAddItem2 = new ACRadioButtonItem();

      reEntryNutritionCooperationAddItem2.setText("����");

      reEntryNutritionCooperationAddItem2.setGroup(getReEntryNutritionCooperationAdd());

      reEntryNutritionCooperationAddItem2.setConstraints(VRLayout.FLOW);

      addReEntryNutritionCooperationAddItem2();
    }
    return reEntryNutritionCooperationAddItem2;

  }

  /**
   * ��h�{���X�N���P���Z���擾���܂��B
   * @return ��h�{���X�N���P���Z
   */
  public ACValueArrayRadioButtonGroup getLowNutritionalRiskImprovementAdd(){
    if(lowNutritionalRiskImprovementAdd==null){

      lowNutritionalRiskImprovementAdd = new ACValueArrayRadioButtonGroup();

      getLowNutritionalRiskImprovementAddContainer().setText("��h�{���X�N���P���Z");

      lowNutritionalRiskImprovementAdd.setBindPath("1510151");

      lowNutritionalRiskImprovementAdd.setUseClearButton(false);

      lowNutritionalRiskImprovementAdd.setModel(getLowNutritionalRiskImprovementAddModel());

      lowNutritionalRiskImprovementAdd.setValues(new int[]{1,2});

      addLowNutritionalRiskImprovementAdd();
    }
    return lowNutritionalRiskImprovementAdd;

  }

  /**
   * ��h�{���X�N���P���Z�R���e�i���擾���܂��B
   * @return ��h�{���X�N���P���Z�R���e�i
   */
  protected ACLabelContainer getLowNutritionalRiskImprovementAddContainer(){
    if(lowNutritionalRiskImprovementAddContainer==null){
      lowNutritionalRiskImprovementAddContainer = new ACLabelContainer();
      lowNutritionalRiskImprovementAddContainer.setFollowChildEnabled(true);
      lowNutritionalRiskImprovementAddContainer.setVAlignment(VRLayout.CENTER);
      lowNutritionalRiskImprovementAddContainer.add(getLowNutritionalRiskImprovementAdd(), null);
    }
    return lowNutritionalRiskImprovementAddContainer;
  }

  /**
   * ��h�{���X�N���P���Z���f�����擾���܂��B
   * @return ��h�{���X�N���P���Z���f��
   */
  protected ACListModelAdapter getLowNutritionalRiskImprovementAddModel(){
    if(lowNutritionalRiskImprovementAddModel==null){
      lowNutritionalRiskImprovementAddModel = new ACListModelAdapter();
      addLowNutritionalRiskImprovementAddModel();
    }
    return lowNutritionalRiskImprovementAddModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getLowNutritionalRiskImprovementAddItem1(){
    if(lowNutritionalRiskImprovementAddItem1==null){

      lowNutritionalRiskImprovementAddItem1 = new ACRadioButtonItem();

      lowNutritionalRiskImprovementAddItem1.setText("�Ȃ�");

      lowNutritionalRiskImprovementAddItem1.setGroup(getLowNutritionalRiskImprovementAdd());

      lowNutritionalRiskImprovementAddItem1.setConstraints(VRLayout.FLOW);

      addLowNutritionalRiskImprovementAddItem1();
    }
    return lowNutritionalRiskImprovementAddItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getLowNutritionalRiskImprovementAddItem2(){
    if(lowNutritionalRiskImprovementAddItem2==null){

      lowNutritionalRiskImprovementAddItem2 = new ACRadioButtonItem();

      lowNutritionalRiskImprovementAddItem2.setText("����");

      lowNutritionalRiskImprovementAddItem2.setGroup(getLowNutritionalRiskImprovementAdd());

      lowNutritionalRiskImprovementAddItem2.setConstraints(VRLayout.FLOW);

      addLowNutritionalRiskImprovementAddItem2();
    }
    return lowNutritionalRiskImprovementAddItem2;

  }

  /**
   * �^�u6���擾���܂��B
   * @return �^�u6
   */
  public ACPanel getTab6(){
    if(tab6==null){

      tab6 = new ACPanel();

      tab6.setFollowChildEnabled(true);

      tab6.setHgap(0);

      addTab6();
    }
    return tab6;

  }

  /**
   * �z�u��t�ً}���Ή����Z���擾���܂��B
   * @return �z�u��t�ً}���Ή����Z
   */
  public ACValueArrayRadioButtonGroup getPlacementPhysicianEmergencyResponseAdd(){
    if(placementPhysicianEmergencyResponseAdd==null){

      placementPhysicianEmergencyResponseAdd = new ACValueArrayRadioButtonGroup();

      getPlacementPhysicianEmergencyResponseAddContainer().setText("�z�u��t�ً}���Ή����Z");

      placementPhysicianEmergencyResponseAdd.setBindPath("1510152");

      placementPhysicianEmergencyResponseAdd.setUseClearButton(false);

      placementPhysicianEmergencyResponseAdd.setModel(getPlacementPhysicianEmergencyResponseAddModel());

      placementPhysicianEmergencyResponseAdd.setValues(new int[]{1,2,3});

      addPlacementPhysicianEmergencyResponseAdd();
    }
    return placementPhysicianEmergencyResponseAdd;

  }

  /**
   * �z�u��t�ً}���Ή����Z�R���e�i���擾���܂��B
   * @return �z�u��t�ً}���Ή����Z�R���e�i
   */
  protected ACLabelContainer getPlacementPhysicianEmergencyResponseAddContainer(){
    if(placementPhysicianEmergencyResponseAddContainer==null){
      placementPhysicianEmergencyResponseAddContainer = new ACLabelContainer();
      placementPhysicianEmergencyResponseAddContainer.setFollowChildEnabled(true);
      placementPhysicianEmergencyResponseAddContainer.setVAlignment(VRLayout.CENTER);
      placementPhysicianEmergencyResponseAddContainer.add(getPlacementPhysicianEmergencyResponseAdd(), null);
    }
    return placementPhysicianEmergencyResponseAddContainer;
  }

  /**
   * �z�u��t�ً}���Ή����Z���f�����擾���܂��B
   * @return �z�u��t�ً}���Ή����Z���f��
   */
  protected ACListModelAdapter getPlacementPhysicianEmergencyResponseAddModel(){
    if(placementPhysicianEmergencyResponseAddModel==null){
      placementPhysicianEmergencyResponseAddModel = new ACListModelAdapter();
      addPlacementPhysicianEmergencyResponseAddModel();
    }
    return placementPhysicianEmergencyResponseAddModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getPlacementPhysicianEmergencyResponseItem1(){
    if(placementPhysicianEmergencyResponseItem1==null){

      placementPhysicianEmergencyResponseItem1 = new ACRadioButtonItem();

      placementPhysicianEmergencyResponseItem1.setText("�Ȃ�");

      placementPhysicianEmergencyResponseItem1.setGroup(getPlacementPhysicianEmergencyResponseAdd());

      placementPhysicianEmergencyResponseItem1.setConstraints(VRLayout.FLOW);

      addPlacementPhysicianEmergencyResponseItem1();
    }
    return placementPhysicianEmergencyResponseItem1;

  }

  /**
   * �����E��Ԃ��擾���܂��B
   * @return �����E���
   */
  public ACRadioButtonItem getPlacementPhysicianEmergencyResponseItem2(){
    if(placementPhysicianEmergencyResponseItem2==null){

      placementPhysicianEmergencyResponseItem2 = new ACRadioButtonItem();

      placementPhysicianEmergencyResponseItem2.setText("�����E���");

      placementPhysicianEmergencyResponseItem2.setGroup(getPlacementPhysicianEmergencyResponseAdd());

      placementPhysicianEmergencyResponseItem2.setConstraints(VRLayout.FLOW_RETURN);

      addPlacementPhysicianEmergencyResponseItem2();
    }
    return placementPhysicianEmergencyResponseItem2;

  }

  /**
   * �[����擾���܂��B
   * @return �[��
   */
  public ACRadioButtonItem getPlacementPhysicianEmergencyResponseItem3(){
    if(placementPhysicianEmergencyResponseItem3==null){

      placementPhysicianEmergencyResponseItem3 = new ACRadioButtonItem();

      placementPhysicianEmergencyResponseItem3.setText("�[��");

      placementPhysicianEmergencyResponseItem3.setGroup(getPlacementPhysicianEmergencyResponseAdd());

      placementPhysicianEmergencyResponseItem3.setConstraints(VRLayout.FLOW);

      addPlacementPhysicianEmergencyResponseItem3();
    }
    return placementPhysicianEmergencyResponseItem3;

  }

  /**
   * ��ጃ}�l�W�����g���Z���擾���܂��B
   * @return ��ጃ}�l�W�����g���Z
   */
  public ACValueArrayRadioButtonGroup getPressureSoresManagement(){
    if(pressureSoresManagement==null){

      pressureSoresManagement = new ACValueArrayRadioButtonGroup();

      getPressureSoresManagementContainer().setText("��ጃ}�l�W�����g���Z");

      pressureSoresManagement.setBindPath("1510153");

      pressureSoresManagement.setUseClearButton(false);

      pressureSoresManagement.setModel(getPressureSoresManagementModel());

      pressureSoresManagement.setValues(new int[]{1,2});

      addPressureSoresManagement();
    }
    return pressureSoresManagement;

  }

  /**
   * ��ጃ}�l�W�����g���Z�R���e�i���擾���܂��B
   * @return ��ጃ}�l�W�����g���Z�R���e�i
   */
  protected ACLabelContainer getPressureSoresManagementContainer(){
    if(pressureSoresManagementContainer==null){
      pressureSoresManagementContainer = new ACLabelContainer();
      pressureSoresManagementContainer.setFollowChildEnabled(true);
      pressureSoresManagementContainer.setVAlignment(VRLayout.CENTER);
      pressureSoresManagementContainer.add(getPressureSoresManagement(), null);
    }
    return pressureSoresManagementContainer;
  }

  /**
   * ��ጃ}�l�W�����g���Z���f�����擾���܂��B
   * @return ��ጃ}�l�W�����g���Z���f��
   */
  protected ACListModelAdapter getPressureSoresManagementModel(){
    if(pressureSoresManagementModel==null){
      pressureSoresManagementModel = new ACListModelAdapter();
      addPressureSoresManagementModel();
    }
    return pressureSoresManagementModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getPressureSoresManagementItem1(){
    if(pressureSoresManagementItem1==null){

      pressureSoresManagementItem1 = new ACRadioButtonItem();

      pressureSoresManagementItem1.setText("�Ȃ�");

      pressureSoresManagementItem1.setGroup(getPressureSoresManagement());

      pressureSoresManagementItem1.setConstraints(VRLayout.FLOW);

      addPressureSoresManagementItem1();
    }
    return pressureSoresManagementItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getPressureSoresManagementItem2(){
    if(pressureSoresManagementItem2==null){

      pressureSoresManagementItem2 = new ACRadioButtonItem();

      pressureSoresManagementItem2.setText("����");

      pressureSoresManagementItem2.setGroup(getPressureSoresManagement());

      pressureSoresManagementItem2.setConstraints(VRLayout.FLOW);

      addPressureSoresManagementItem2();
    }
    return pressureSoresManagementItem2;

  }

  /**
   * �r���x�����Z���擾���܂��B
   * @return �r���x�����Z
   */
  public ACValueArrayRadioButtonGroup getExcretionSupport(){
    if(excretionSupport==null){

      excretionSupport = new ACValueArrayRadioButtonGroup();

      getExcretionSupportContainer().setText("�r���x�����Z");

      excretionSupport.setBindPath("1510154");

      excretionSupport.setUseClearButton(false);

      excretionSupport.setModel(getExcretionSupportModel());

      excretionSupport.setValues(new int[]{1,2});

      addExcretionSupport();
    }
    return excretionSupport;

  }

  /**
   * �r���x�����Z�R���e�i���擾���܂��B
   * @return �r���x�����Z�R���e�i
   */
  protected ACLabelContainer getExcretionSupportContainer(){
    if(excretionSupportContainer==null){
      excretionSupportContainer = new ACLabelContainer();
      excretionSupportContainer.setFollowChildEnabled(true);
      excretionSupportContainer.setVAlignment(VRLayout.CENTER);
      excretionSupportContainer.add(getExcretionSupport(), null);
    }
    return excretionSupportContainer;
  }

  /**
   * �r���x�����Z���f�����擾���܂��B
   * @return �r���x�����Z���f��
   */
  protected ACListModelAdapter getExcretionSupportModel(){
    if(excretionSupportModel==null){
      excretionSupportModel = new ACListModelAdapter();
      addExcretionSupportModel();
    }
    return excretionSupportModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getExcretionSupportItem1(){
    if(excretionSupportItem1==null){

      excretionSupportItem1 = new ACRadioButtonItem();

      excretionSupportItem1.setText("�Ȃ�");

      excretionSupportItem1.setGroup(getExcretionSupport());

      excretionSupportItem1.setConstraints(VRLayout.FLOW);

      addExcretionSupportItem1();
    }
    return excretionSupportItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getExcretionSupportItem2(){
    if(excretionSupportItem2==null){

      excretionSupportItem2 = new ACRadioButtonItem();

      excretionSupportItem2.setText("����");

      excretionSupportItem2.setGroup(getExcretionSupport());

      excretionSupportItem2.setConstraints(VRLayout.FLOW);

      addExcretionSupportItem2();
    }
    return excretionSupportItem2;

  }

  /**
   * �Z��敪���擾���܂��B
   * @return �Z��敪
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityCalculationDivisionRadilo(){
    if(kaigoWelfareFacilityCalculationDivisionRadilo==null){

      kaigoWelfareFacilityCalculationDivisionRadilo = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityCalculationDivisionRadiloContainer().setText("�Z��敪");

      kaigoWelfareFacilityCalculationDivisionRadilo.setBindPath("9");

      kaigoWelfareFacilityCalculationDivisionRadilo.setUseClearButton(false);

      kaigoWelfareFacilityCalculationDivisionRadilo.setModel(getKaigoWelfareFacilityCalculationDivisionRadiloModel());

      kaigoWelfareFacilityCalculationDivisionRadilo.setValues(new int[]{1,2});

      addKaigoWelfareFacilityCalculationDivisionRadilo();
    }
    return kaigoWelfareFacilityCalculationDivisionRadilo;

  }

  /**
   * �Z��敪�R���e�i���擾���܂��B
   * @return �Z��敪�R���e�i
   */
  protected ACLabelContainer getKaigoWelfareFacilityCalculationDivisionRadiloContainer(){
    if(kaigoWelfareFacilityCalculationDivisionRadiloContainer==null){
      kaigoWelfareFacilityCalculationDivisionRadiloContainer = new ACLabelContainer();
      kaigoWelfareFacilityCalculationDivisionRadiloContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityCalculationDivisionRadiloContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityCalculationDivisionRadiloContainer.add(getKaigoWelfareFacilityCalculationDivisionRadilo(), null);
    }
    return kaigoWelfareFacilityCalculationDivisionRadiloContainer;
  }

  /**
   * �Z��敪���f�����擾���܂��B
   * @return �Z��敪���f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityCalculationDivisionRadiloModel(){
    if(kaigoWelfareFacilityCalculationDivisionRadiloModel==null){
      kaigoWelfareFacilityCalculationDivisionRadiloModel = new ACListModelAdapter();
      addKaigoWelfareFacilityCalculationDivisionRadiloModel();
    }
    return kaigoWelfareFacilityCalculationDivisionRadiloModel;
  }

  /**
   * �ʏ���擾���܂��B
   * @return �ʏ�
   */
  public ACRadioButtonItem getKaigoWelfareFacilityCalculationDivisionRadiloItem1(){
    if(kaigoWelfareFacilityCalculationDivisionRadiloItem1==null){

      kaigoWelfareFacilityCalculationDivisionRadiloItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityCalculationDivisionRadiloItem1.setText("�ʏ�");

      kaigoWelfareFacilityCalculationDivisionRadiloItem1.setGroup(getKaigoWelfareFacilityCalculationDivisionRadilo());

      kaigoWelfareFacilityCalculationDivisionRadiloItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityCalculationDivisionRadiloItem1();
    }
    return kaigoWelfareFacilityCalculationDivisionRadiloItem1;

  }

  /**
   * ���Z�݂̂��擾���܂��B
   * @return ���Z�̂�
   */
  public ACRadioButtonItem getKaigoWelfareFacilityCalculationDivisionRadiloItem2(){
    if(kaigoWelfareFacilityCalculationDivisionRadiloItem2==null){

      kaigoWelfareFacilityCalculationDivisionRadiloItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityCalculationDivisionRadiloItem2.setText("���Z�̂�");

      kaigoWelfareFacilityCalculationDivisionRadiloItem2.setGroup(getKaigoWelfareFacilityCalculationDivisionRadilo());

      kaigoWelfareFacilityCalculationDivisionRadiloItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityCalculationDivisionRadiloItem2();
    }
    return kaigoWelfareFacilityCalculationDivisionRadiloItem2;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_15111_201804Design() {

    try {
      initialize();

    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g�̐ݒ���s�Ȃ��܂��B
   */
  protected void initThis(){
  }

  /**
   * this�ɓ������ڂ�ǉ����܂��B
   */
  protected void addThis(){

    this.add(getTabs(), VRLayout.CLIENT);

  }

  /**
   * �^�u�y�C���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabs(){

    tabs.addTab("1", getTab1());

    tabs.addTab("2", getTab2());

    tabs.addTab("3", getTab3());

    tabs.addTab("4", getTab4());

    tabs.addTab("5", getTab5());

    tabs.addTab("6", getTab6());

  }

  /**
   * �^�u1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab1(){

    tab1.add(getKaigoWelfareFacilityInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getKaigoWelfareFacilityHospitalRoomDivisionContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getKaigoWelfareFacilityUnitCareMaintenanceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getKaigoWelfareFacilityJunUnitCareAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getKaigoWelfareFacilityNightShiftSubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getDailyLifeContinuanceRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �{�ݓ��̋敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityInstitutionDivisionRadio(){

  }

  /**
   * �{�ݓ��̋敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityInstitutionDivisionRadioModel(){

    getKaigoWelfareFacilityInstitutionDivisionRadioItem1().setButtonIndex(1);

    getKaigoWelfareFacilityInstitutionDivisionRadioModel().add(getKaigoWelfareFacilityInstitutionDivisionRadioItem1());

    getKaigoWelfareFacilityInstitutionDivisionRadioItem2().setButtonIndex(2);

    getKaigoWelfareFacilityInstitutionDivisionRadioModel().add(getKaigoWelfareFacilityInstitutionDivisionRadioItem2());

    getKaigoWelfareFacilityInstitutionDivisionRadioItem3().setButtonIndex(3);

    getKaigoWelfareFacilityInstitutionDivisionRadioModel().add(getKaigoWelfareFacilityInstitutionDivisionRadioItem3());

    getKaigoWelfareFacilityInstitutionDivisionRadioItem4().setButtonIndex(4);

    getKaigoWelfareFacilityInstitutionDivisionRadioModel().add(getKaigoWelfareFacilityInstitutionDivisionRadioItem4());

  }

  /**
   * ��앟���{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityInstitutionDivisionRadioItem1(){

  }

  /**
   * �o�ߓI���K�͉�앟���{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityInstitutionDivisionRadioItem2(){

  }

  /**
   * ���j�b�g�^��앟���{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityInstitutionDivisionRadioItem3(){

  }

  /**
   * ���j�b�g�^�o�ߓI���K�͉�앟���{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityInstitutionDivisionRadioItem4(){

  }

  /**
   * �a���敪�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityHospitalRoomDivisionContena(){

    kaigoWelfareFacilityHospitalRoomDivisionContena.add(getKaigoWelfareFacilityHospitalRoomDivisionRadio(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoWelfareFacilityHospitalRoomDivisionContena.add(getKaigoWelfareFacilityUnitHospitalRoomDivisionRadio(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �a���敪�i��앟���{�݁j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityHospitalRoomDivisionRadio(){

  }

  /**
   * �a���敪�i��앟���{�݁j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityHospitalRoomDivisionRadioModel(){

    getKaigoWelfareFacilityHospitalRoomDivisionRadioItem1().setButtonIndex(1);

    getKaigoWelfareFacilityHospitalRoomDivisionRadioModel().add(getKaigoWelfareFacilityHospitalRoomDivisionRadioItem1());

    getKaigoWelfareFacilityHospitalRoomDivisionRadioItem2().setButtonIndex(2);

    getKaigoWelfareFacilityHospitalRoomDivisionRadioModel().add(getKaigoWelfareFacilityHospitalRoomDivisionRadioItem2());

  }

  /**
   * �]���^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityHospitalRoomDivisionRadioItem1(){

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityHospitalRoomDivisionRadioItem2(){

  }

  /**
   * �a���敪�i���j�b�g�^��앟���{�݁j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityUnitHospitalRoomDivisionRadio(){

  }

  /**
   * �a���敪�i���j�b�g�^��앟���{�݁j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityUnitHospitalRoomDivisionRadioModel(){

    getKaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem1().setButtonIndex(1);

    getKaigoWelfareFacilityUnitHospitalRoomDivisionRadioModel().add(getKaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem1());

    getKaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem2().setButtonIndex(2);

    getKaigoWelfareFacilityUnitHospitalRoomDivisionRadioModel().add(getKaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem2());

  }

  /**
   * ���j�b�g�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem1(){

  }

  /**
   * ���j�b�g�^���I�������ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem2(){

  }

  /**
   * ���j�b�g�P�A�̐����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityUnitCareMaintenanceRadio(){

  }

  /**
   * ���j�b�g�P�A�̐������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityUnitCareMaintenanceRadioModel(){

    getKaigoWelfareFacilityUnitCareMaintenanceRadioItem1().setButtonIndex(1);

    getKaigoWelfareFacilityUnitCareMaintenanceRadioModel().add(getKaigoWelfareFacilityUnitCareMaintenanceRadioItem1());

    getKaigoWelfareFacilityUnitCareMaintenanceRadioItem2().setButtonIndex(2);

    getKaigoWelfareFacilityUnitCareMaintenanceRadioModel().add(getKaigoWelfareFacilityUnitCareMaintenanceRadioItem2());

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityUnitCareMaintenanceRadioItem1(){

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityUnitCareMaintenanceRadioItem2(){

  }

  /**
   * �����j�b�g�P�A���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityJunUnitCareAddRadio(){

  }

  /**
   * �����j�b�g�P�A���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityJunUnitCareAddRadioModel(){

    getKaigoWelfareFacilityJunUnitCareAddRadioItem1().setButtonIndex(1);

    getKaigoWelfareFacilityJunUnitCareAddRadioModel().add(getKaigoWelfareFacilityJunUnitCareAddRadioItem1());

    getKaigoWelfareFacilityJunUnitCareAddRadioItem2().setButtonIndex(2);

    getKaigoWelfareFacilityJunUnitCareAddRadioModel().add(getKaigoWelfareFacilityJunUnitCareAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityJunUnitCareAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityJunUnitCareAddRadioItem2(){

  }

  /**
   * ��Α̐����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityNightShiftSubtractionRadio(){

  }

  /**
   * ��Α̐����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityNightShiftSubtractionRadioModel(){

    getKaigoWelfareFacilityNightShiftSubtractionRadioItem1().setButtonIndex(1);

    getKaigoWelfareFacilityNightShiftSubtractionRadioModel().add(getKaigoWelfareFacilityNightShiftSubtractionRadioItem1());

    getKaigoWelfareFacilityNightShiftSubtractionRadioItem2().setButtonIndex(2);

    getKaigoWelfareFacilityNightShiftSubtractionRadioModel().add(getKaigoWelfareFacilityNightShiftSubtractionRadioItem2());

  }

  /**
   * ��^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityNightShiftSubtractionRadioItem1(){

  }

  /**
   * ���Z�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityNightShiftSubtractionRadioItem2(){

  }

  /**
   * ���퐶���p���x�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDailyLifeContinuanceRadioGroup(){

  }

  /**
   * ���퐶���p���x�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDailyLifeContinuanceRadioGroupModel(){

    getDailyLifeContinuanceRadioItem1().setButtonIndex(1);

    getDailyLifeContinuanceRadioGroupModel().add(getDailyLifeContinuanceRadioItem1());

    getDailyLifeContinuanceRadioItem2().setButtonIndex(2);

    getDailyLifeContinuanceRadioGroupModel().add(getDailyLifeContinuanceRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDailyLifeContinuanceRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addDailyLifeContinuanceRadioItem2(){

  }

  /**
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getKaigoWelfareFacilityFunctionTrainingRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getKaigoWelfareFacilityHandicappedRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getNurseStructuralAddGroup(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getNightStaffDispositionAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getStayPeopleCountRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getKaigoWelfareFacilityFacilityFulltimeDoctorRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getKaigoWelfareFacilityPsychiatristRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getKaigoWelfareFacilityStayingOutOvernightCostRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getKaigoWelfareFacilityDefaultRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �ʋ@�\�P���w�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityFunctionTrainingRadio(){

  }

  /**
   * �ʋ@�\�P���w�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityFunctionTrainingRadioModel(){

    getKaigoWelfareFacilityFunctionTrainingRadioItem2().setButtonIndex(1);

    getKaigoWelfareFacilityFunctionTrainingRadioModel().add(getKaigoWelfareFacilityFunctionTrainingRadioItem2());

    getKaigoWelfareFacilityFunctionTrainingRadioItem1().setButtonIndex(2);

    getKaigoWelfareFacilityFunctionTrainingRadioModel().add(getKaigoWelfareFacilityFunctionTrainingRadioItem1());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityFunctionTrainingRadioItem2(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityFunctionTrainingRadioItem1(){

  }

  /**
   * ��Q�Ґ����x���̐����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityHandicappedRadio(){

  }

  /**
   * ��Q�Ґ����x���̐����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityHandicappedRadioModel(){

    getKaigoWelfareFacilityHandicappedRadioItem1().setButtonIndex(1);

    getKaigoWelfareFacilityHandicappedRadioModel().add(getKaigoWelfareFacilityHandicappedRadioItem1());

    getKaigoWelfareFacilityHandicappedRadioItem2().setButtonIndex(2);

    getKaigoWelfareFacilityHandicappedRadioModel().add(getKaigoWelfareFacilityHandicappedRadioItem2());

    getKaigoWelfareFacilityHandicappedRadioItem3().setButtonIndex(3);

    getKaigoWelfareFacilityHandicappedRadioModel().add(getKaigoWelfareFacilityHandicappedRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityHandicappedRadioItem1(){

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityHandicappedRadioItem2(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityHandicappedRadioItem3(){

  }

  /**
   * �Ō�̐����Z�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNurseStructuralAddGroup(){

    nurseStructuralAddGroup.add(getNurseStructuralAddCheckItem1(), VRLayout.FLOW);

    nurseStructuralAddGroup.add(getNurseStructuralAddCheckItem2(), VRLayout.FLOW);

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNurseStructuralAddCheckItem1(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNurseStructuralAddCheckItem2(){

  }

  /**
   * ��ΐE���z�u���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightStaffDispositionAddRadioGroup(){

  }

  /**
   * ��ΐE���z�u���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightStaffDispositionAddRadioGroupModel(){

    getNightStaffDispositionAddRadioItem1().setButtonIndex(1);

    getNightStaffDispositionAddRadioGroupModel().add(getNightStaffDispositionAddRadioItem1());

    getNightStaffDispositionAddRadioItem2().setButtonIndex(2);

    getNightStaffDispositionAddRadioGroupModel().add(getNightStaffDispositionAddRadioItem2());

    getNightStaffDispositionAddRadioItem3().setButtonIndex(3);

    getNightStaffDispositionAddRadioGroupModel().add(getNightStaffDispositionAddRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightStaffDispositionAddRadioItem1(){

  }

  /**
   * I�EII�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightStaffDispositionAddRadioItem2(){

  }

  /**
   * III�EIV�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightStaffDispositionAddRadioItem3(){

  }

  /**
   * ��������ɓ������ڂ�ǉ����܂��B
   */
  protected void addStayPeopleCountRadioGroup(){

  }

  /**
   * ����������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStayPeopleCountRadioGroupModel(){

    getStayPeopleCountRadioItem1().setButtonIndex(1);

    getStayPeopleCountRadioGroupModel().add(getStayPeopleCountRadioItem1());

    getStayPeopleCountRadioItem2().setButtonIndex(2);

    getStayPeopleCountRadioGroupModel().add(getStayPeopleCountRadioItem2());

  }

  /**
   * 30�l�ȏ�50�l�ȉ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addStayPeopleCountRadioItem1(){

  }

  /**
   * 51�l�ȏ㖔�͌o�ߓI���K�͂ɓ������ڂ�ǉ����܂��B
   */
  protected void addStayPeopleCountRadioItem2(){

  }

  /**
   * ��Έ�t�z�u���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityFacilityFulltimeDoctorRadio(){

  }

  /**
   * ��Έ�t�z�u���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityFacilityFulltimeDoctorRadioModel(){

    getKaigoWelfareFacilityFacilityFulltimeDoctorRadioItem1().setButtonIndex(1);

    getKaigoWelfareFacilityFacilityFulltimeDoctorRadioModel().add(getKaigoWelfareFacilityFacilityFulltimeDoctorRadioItem1());

    getKaigoWelfareFacilityFacilityFulltimeDoctorRadioItem2().setButtonIndex(2);

    getKaigoWelfareFacilityFacilityFulltimeDoctorRadioModel().add(getKaigoWelfareFacilityFacilityFulltimeDoctorRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityFacilityFulltimeDoctorRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityFacilityFulltimeDoctorRadioItem2(){

  }

  /**
   * ���_�Ȉ�×{�w�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityPsychiatristRadio(){

  }

  /**
   * ���_�Ȉ�×{�w�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityPsychiatristRadioModel(){

    getKaigoWelfareFacilityPsychiatristRadioItem1().setButtonIndex(1);

    getKaigoWelfareFacilityPsychiatristRadioModel().add(getKaigoWelfareFacilityPsychiatristRadioItem1());

    getKaigoWelfareFacilityPsychiatristRadioItem2().setButtonIndex(2);

    getKaigoWelfareFacilityPsychiatristRadioModel().add(getKaigoWelfareFacilityPsychiatristRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityPsychiatristRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityPsychiatristRadioItem2(){

  }

  /**
   * �O�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityStayingOutOvernightCostRadio(){

  }

  /**
   * �O�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityStayingOutOvernightCostRadioModel(){

    getKaigoWelfareFacilityStayingOutOvernightCostRadioItem1().setButtonIndex(1);

    getKaigoWelfareFacilityStayingOutOvernightCostRadioModel().add(getKaigoWelfareFacilityStayingOutOvernightCostRadioItem1());

    getKaigoWelfareFacilityStayingOutOvernightCostRadioItem2().setButtonIndex(2);

    getKaigoWelfareFacilityStayingOutOvernightCostRadioModel().add(getKaigoWelfareFacilityStayingOutOvernightCostRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityStayingOutOvernightCostRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityStayingOutOvernightCostRadioItem2(){

  }

  /**
   * �������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityDefaultRadio(){

  }

  /**
   * �������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityDefaultRadioModel(){

    getKaigoWelfareFacilityDefaultRadioItem1().setButtonIndex(1);

    getKaigoWelfareFacilityDefaultRadioModel().add(getKaigoWelfareFacilityDefaultRadioItem1());

    getKaigoWelfareFacilityDefaultRadioItem2().setButtonIndex(2);

    getKaigoWelfareFacilityDefaultRadioModel().add(getKaigoWelfareFacilityDefaultRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityDefaultRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityDefaultRadioItem2(){

  }

  /**
   * �^�u3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab3(){

    tab3.add(getKaigoWelfareFacilityNutritionRadioContainer(), VRLayout.FLOW_INSETLINE);

    tab3.add(getKaigoWelfareFacilityOralSwitchRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getOralMaintenanceAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getOralKeepStructureAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getOralKeepAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getKaigoWelfareFacilityRecuperateDinnerRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getKaigoWelfareFacilityHijoAddition(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �h�{�}�l�W�����g���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityNutritionRadio(){

  }

  /**
   * �h�{�}�l�W�����g���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityNutritionRadioModel(){

    getKaigoWelfareFacilityNutritionRadioItem1().setButtonIndex(1);

    getKaigoWelfareFacilityNutritionRadioModel().add(getKaigoWelfareFacilityNutritionRadioItem1());

    getKaigoWelfareFacilityNutritionRadioItem2().setButtonIndex(2);

    getKaigoWelfareFacilityNutritionRadioModel().add(getKaigoWelfareFacilityNutritionRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityNutritionRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityNutritionRadioItem2(){

  }

  /**
   * �o���ڍs���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityOralSwitchRadio(){

  }

  /**
   * �o���ڍs���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityOralSwitchRadioModel(){

    getKaigoWelfareFacilityOralSwitchRadioItem1().setButtonIndex(1);

    getKaigoWelfareFacilityOralSwitchRadioModel().add(getKaigoWelfareFacilityOralSwitchRadioItem1());

    getKaigoWelfareFacilityOralSwitchRadioItem2().setButtonIndex(2);

    getKaigoWelfareFacilityOralSwitchRadioModel().add(getKaigoWelfareFacilityOralSwitchRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityOralSwitchRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityOralSwitchRadioItem2(){

  }

  /**
   * �o���ێ����Z�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralMaintenanceAddContainer(){

    oralMaintenanceAddContainer.add(getOralMaintenanceAdd(), null);

    oralMaintenanceAddContainer.add(getOralMaintenanceAddItem3(), VRLayout.FLOW);

  }

  /**
   * �o���ێ����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralMaintenanceAdd(){

  }

  /**
   * �o���ێ����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralMaintenanceAddModel(){

    getOralMaintenanceAddItem1().setButtonIndex(1);

    getOralMaintenanceAddModel().add(getOralMaintenanceAddItem1());

    getOralMaintenanceAddItem2().setButtonIndex(2);

    getOralMaintenanceAddModel().add(getOralMaintenanceAddItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralMaintenanceAddItem1(){

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralMaintenanceAddItem2(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralMaintenanceAddItem3(){

  }

  /**
   * ���o�q���Ǘ��̐����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralKeepStructureAddRadioGroup(){

  }

  /**
   * ���o�q���Ǘ��̐����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralKeepStructureAddRadioGroupModel(){

    getOralKeepStructureAddRadioItem1().setButtonIndex(1);

    getOralKeepStructureAddRadioGroupModel().add(getOralKeepStructureAddRadioItem1());

    getOralKeepStructureAddRadioItem2().setButtonIndex(2);

    getOralKeepStructureAddRadioGroupModel().add(getOralKeepStructureAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralKeepStructureAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralKeepStructureAddRadioItem2(){

  }

  /**
   * ���o�q���Ǘ����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralKeepAddRadioGroup(){

  }

  /**
   * ���o�q���Ǘ����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralKeepAddRadioGroupModel(){

    getOralKeepAddRadioItem1().setButtonIndex(1);

    getOralKeepAddRadioGroupModel().add(getOralKeepAddRadioItem1());

    getOralKeepAddRadioItem2().setButtonIndex(2);

    getOralKeepAddRadioGroupModel().add(getOralKeepAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralKeepAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralKeepAddRadioItem2(){

  }

  /**
   * �×{�H���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityRecuperateDinnerRadio(){

  }

  /**
   * �×{�H���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityRecuperateDinnerRadioModel(){

    getKaigoWelfareFacilityRecuperateDinnerRadioItem1().setButtonIndex(1);

    getKaigoWelfareFacilityRecuperateDinnerRadioModel().add(getKaigoWelfareFacilityRecuperateDinnerRadioItem1());

    getKaigoWelfareFacilityRecuperateDinnerRadioItem2().setButtonIndex(2);

    getKaigoWelfareFacilityRecuperateDinnerRadioModel().add(getKaigoWelfareFacilityRecuperateDinnerRadioItem2());

    getKaigoWelfareFacilityRecuperateDinnerRadioItem3().setButtonIndex(3);

    getKaigoWelfareFacilityRecuperateDinnerRadioModel().add(getKaigoWelfareFacilityRecuperateDinnerRadioItem3());

    getKaigoWelfareFacilityRecuperateDinnerRadioItem4().setButtonIndex(4);

    getKaigoWelfareFacilityRecuperateDinnerRadioModel().add(getKaigoWelfareFacilityRecuperateDinnerRadioItem4());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityRecuperateDinnerRadioItem1(){

  }

  /**
   * 3��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityRecuperateDinnerRadioItem2(){

  }

  /**
   * 2��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityRecuperateDinnerRadioItem3(){

  }

  /**
   * 1��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityRecuperateDinnerRadioItem4(){

  }

  /**
   * ��N���F�m�Ǔ����Ҏ�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYoungDementiaPatinetAddRadioGroup(){

  }

  /**
   * ��N���F�m�Ǔ����Ҏ�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addYoungDementiaPatinetAddRadioGroupModel(){

    getYoungDementiaPatinetAddRadioItem1().setButtonIndex(1);

    getYoungDementiaPatinetAddRadioGroupModel().add(getYoungDementiaPatinetAddRadioItem1());

    getYoungDementiaPatinetAddRadioItem2().setButtonIndex(2);

    getYoungDementiaPatinetAddRadioGroupModel().add(getYoungDementiaPatinetAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addYoungDementiaPatinetAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addYoungDementiaPatinetAddRadioItem2(){

  }

  /**
   * �ޏ��֘A���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityHijoAddition(){

    kaigoWelfareFacilityHijoAddition.add(getHijoPreConsultationAddition(), VRLayout.FLOW_RETURN);

    kaigoWelfareFacilityHijoAddition.add(getHijoAfterConsultationAddition(), VRLayout.FLOW_RETURN);

    kaigoWelfareFacilityHijoAddition.add(getHijoConsultationAddition(), VRLayout.FLOW_RETURN);

    kaigoWelfareFacilityHijoAddition.add(getHijoCooperationAddition(), VRLayout.FLOW_RETURN);

  }

  /**
   * �ޏ��O�K�⑊�k�������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHijoPreConsultationAddition(){

  }

  /**
   * �ޏ���K�⑊�k�������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHijoAfterConsultationAddition(){

  }

  /**
   * �ޏ������k�������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHijoConsultationAddition(){

  }

  /**
   * �ޏ��O�A�g���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHijoCooperationAddition(){

  }

  /**
   * �^�u4�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab4(){

    tab4.add(getKaigoWelfareFacilityStaffSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getKaigoWelfareFacilityDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    tab4.add(getKaigoWelfareFacilityBodyRestraintAbolitionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getKaigoWelfareFacilityTakingCareNursingAddDaysContainer2(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getKaigoWelfareFacilityTakingCareNursingAddDaysContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �l�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityStaffSubtraction(){

  }

  /**
   * �l�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityStaffSubtractionModel(){

    getKaigoWelfareFacilityStaffSubtractionCapacityNot().setButtonIndex(1);

    getKaigoWelfareFacilityStaffSubtractionModel().add(getKaigoWelfareFacilityStaffSubtractionCapacityNot());

    getKaigoWelfareFacilityStaffSubtractionCapacityExcess().setButtonIndex(2);

    getKaigoWelfareFacilityStaffSubtractionModel().add(getKaigoWelfareFacilityStaffSubtractionCapacityExcess());

    getKaigoWelfareFacilityStaffSubtractionPersonLack().setButtonIndex(3);

    getKaigoWelfareFacilityStaffSubtractionModel().add(getKaigoWelfareFacilityStaffSubtractionPersonLack());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityStaffSubtractionCapacityNot(){

  }

  /**
   * ������߂ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityStaffSubtractionCapacityExcess(){

  }

  /**
   * �Ō�E���E�����͉��x�������̕s���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityStaffSubtractionPersonLack(){

  }

  /**
   * �H���R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityDinnerContainer(){

    kaigoWelfareFacilityDinnerContainer.add(getKaigoWelfareFacilityDinnerOfferContainer(), VRLayout.FLOW);

    kaigoWelfareFacilityDinnerContainer.add(getKaigoWelfareFacilityDinnerCostContainer(), VRLayout.FLOW);

  }

  /**
   * �H���񋟂ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityDinnerOffer(){

  }

  /**
   * �H���񋟃��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityDinnerOfferModel(){

  }

  /**
   * �H����p�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityDinnerCost(){

  }

  /**
   * �g�̍S���p�~�����{���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityBodyRestraintAbolitionRadio(){

  }

  /**
   * �g�̍S���p�~�����{���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityBodyRestraintAbolitionRadioModel(){

    getKaigoWelfareFacilityBodyRestraintAbolitionRadioItem1().setButtonIndex(1);

    getKaigoWelfareFacilityBodyRestraintAbolitionRadioModel().add(getKaigoWelfareFacilityBodyRestraintAbolitionRadioItem1());

    getKaigoWelfareFacilityBodyRestraintAbolitionRadioItem2().setButtonIndex(2);

    getKaigoWelfareFacilityBodyRestraintAbolitionRadioModel().add(getKaigoWelfareFacilityBodyRestraintAbolitionRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityBodyRestraintAbolitionRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityBodyRestraintAbolitionRadioItem2(){

  }

  /**
   * �Ŏ������Z�R���e�i2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityTakingCareNursingAddDaysContainer2(){

    kaigoWelfareFacilityTakingCareNursingAddDaysContainer2.add(getKaigoWelfareFacilityTakingCareNursingPtn(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoWelfareFacilityTakingCareNursingAddDaysContainer2.add(getKaigoWelfareFacilityTakingCareNursingAddRadio(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �Ŏ������Z�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityTakingCareNursingPtn(){

  }

  /**
   * �Ŏ������Z�^���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityTakingCareNursingPtnModel(){

    getKaigoWelfareFacilityTakingCareNursingPtnItem1().setButtonIndex(1);

    getKaigoWelfareFacilityTakingCareNursingPtnModel().add(getKaigoWelfareFacilityTakingCareNursingPtnItem1());

    getKaigoWelfareFacilityTakingCareNursingPtnItem2().setButtonIndex(2);

    getKaigoWelfareFacilityTakingCareNursingPtnModel().add(getKaigoWelfareFacilityTakingCareNursingPtnItem2());

    getKaigoWelfareFacilityTakingCareNursingPtnItem3().setButtonIndex(3);

    getKaigoWelfareFacilityTakingCareNursingPtnModel().add(getKaigoWelfareFacilityTakingCareNursingPtnItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityTakingCareNursingPtnItem1(){

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityTakingCareNursingPtnItem2(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityTakingCareNursingPtnItem3(){

  }

  /**
   * �Ŏ������Z��ʂɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityTakingCareNursingAddRadio(){

  }

  /**
   * �Ŏ������Z��ʃ��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityTakingCareNursingAddRadioModel(){

    getKaigoWelfareFacilityTakingCareNursingAddRadioItem2().setButtonIndex(2);

    getKaigoWelfareFacilityTakingCareNursingAddRadioModel().add(getKaigoWelfareFacilityTakingCareNursingAddRadioItem2());

    getKaigoWelfareFacilityTakingCareNursingAddRadioItem3().setButtonIndex(3);

    getKaigoWelfareFacilityTakingCareNursingAddRadioModel().add(getKaigoWelfareFacilityTakingCareNursingAddRadioItem3());

    getKaigoWelfareFacilityTakingCareNursingAddRadioItem4().setButtonIndex(4);

    getKaigoWelfareFacilityTakingCareNursingAddRadioModel().add(getKaigoWelfareFacilityTakingCareNursingAddRadioItem4());

  }

  /**
   * ���S���ȑO4���ȏ�30���ȉ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityTakingCareNursingAddRadioItem2(){

  }

  /**
   * ���S���ȑO2������3���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityTakingCareNursingAddRadioItem3(){

  }

  /**
   * ���S���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityTakingCareNursingAddRadioItem4(){

  }

  /**
   * �Ŏ������Z�����R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityTakingCareNursingAddDaysContainer(){

    kaigoWelfareFacilityTakingCareNursingAddDaysContainer.add(getKaigoWelfareFacilityTakingCareNursingAddDays(), VRLayout.FLOW);

    kaigoWelfareFacilityTakingCareNursingAddDaysContainer.add(getKaigoWelfareFacilityTakingCareNursingAddDaysUnit(), VRLayout.FLOW);

  }

  /**
   * �Ŏ������Z�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityTakingCareNursingAddDays(){

  }

  /**
   * �Ŏ������Z�����P�ʂɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityTakingCareNursingAddDaysUnit(){

  }

  /**
   * �^�u5�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab5(){

    tab5.add(getKaigoWelfareFacilityStayReturnSupportAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab5.add(getKaigoWelfareFacilityHomeShareAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab5.add(getDementiaProfessionalCareAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab5.add(getDementiaEmergencyAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab5.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab5.add(getImprovementCollaborationContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab5.add(getHomeServiceUsageFeeAtHomeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab5.add(getReEntryNutritionCooperationAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab5.add(getLowNutritionalRiskImprovementAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �ݑ�A�x���@�\���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityStayReturnSupportAddRadio(){

  }

  /**
   * �ݑ�A�x���@�\���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityStayReturnSupportAddRadioModel(){

    getKaigoWelfareFacilityStayReturnSupportAddRadioItem1().setButtonIndex(1);

    getKaigoWelfareFacilityStayReturnSupportAddRadioModel().add(getKaigoWelfareFacilityStayReturnSupportAddRadioItem1());

    getKaigoWelfareFacilityStayReturnSupportAddRadioItem2().setButtonIndex(2);

    getKaigoWelfareFacilityStayReturnSupportAddRadioModel().add(getKaigoWelfareFacilityStayReturnSupportAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityStayReturnSupportAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityStayReturnSupportAddRadioItem2(){

  }

  /**
   * �ݑ�E�������ݗ��p���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityHomeShareAddRadio(){

  }

  /**
   * �ݑ�E�������ݗ��p���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityHomeShareAddRadioModel(){

    getKaigoWelfareFacilityHomeShareAddRadioItem1().setButtonIndex(1);

    getKaigoWelfareFacilityHomeShareAddRadioModel().add(getKaigoWelfareFacilityHomeShareAddRadioItem1());

    getKaigoWelfareFacilityHomeShareAddRadioItem2().setButtonIndex(2);

    getKaigoWelfareFacilityHomeShareAddRadioModel().add(getKaigoWelfareFacilityHomeShareAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityHomeShareAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityHomeShareAddRadioItem2(){

  }

  /**
   * �F�m�ǐ��P�A���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaProfessionalCareAddRadioGroup(){

  }

  /**
   * �F�m�ǐ��P�A���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaProfessionalCareAddRadioGroupModel(){

    getDementiaProfessionalCareAddRadioItem1().setButtonIndex(1);

    getDementiaProfessionalCareAddRadioGroupModel().add(getDementiaProfessionalCareAddRadioItem1());

    getDementiaProfessionalCareAddRadioItem2().setButtonIndex(2);

    getDementiaProfessionalCareAddRadioGroupModel().add(getDementiaProfessionalCareAddRadioItem2());

    getDementiaProfessionalCareAddRadioItem3().setButtonIndex(3);

    getDementiaProfessionalCareAddRadioGroupModel().add(getDementiaProfessionalCareAddRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaProfessionalCareAddRadioItem1(){

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaProfessionalCareAddRadioItem2(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaProfessionalCareAddRadioItem3(){

  }

  /**
   * �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaEmergencyAddRadioGroup(){

  }

  /**
   * �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaEmergencyAddRadioGroupModel(){

    getDementiaEmergencyAddRadioItem1().setButtonIndex(1);

    getDementiaEmergencyAddRadioGroupModel().add(getDementiaEmergencyAddRadioItem1());

    getDementiaEmergencyAddRadioItem2().setButtonIndex(2);

    getDementiaEmergencyAddRadioGroupModel().add(getDementiaEmergencyAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaEmergencyAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaEmergencyAddRadioItem2(){

  }

  /**
   * �T�[�r�X�񋟑̐��������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioGroup(){

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioGroupModel(){

    getServiceAddProvisionStructuralRadioItem1().setButtonIndex(1);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem1());

    getServiceAddProvisionStructuralRadioItem5().setButtonIndex(5);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem5());

    getServiceAddProvisionStructuralRadioItem2().setButtonIndex(2);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem2());

    getServiceAddProvisionStructuralRadioItem3().setButtonIndex(3);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem3());

    getServiceAddProvisionStructuralRadioItem4().setButtonIndex(4);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem4());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem1(){

  }

  /**
   * I�C�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem5(){

  }

  /**
   * I���^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem2(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem3(){

  }

  /**
   * III�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem4(){

  }

  /**
   * �����@�\����A�g���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addImprovementCollaboration(){

  }

  /**
   * �����@�\����A�g���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addImprovementCollaborationModel(){

    getImprovementCollaborationItem1().setButtonIndex(1);

    getImprovementCollaborationModel().add(getImprovementCollaborationItem1());

    getImprovementCollaborationItem2().setButtonIndex(2);

    getImprovementCollaborationModel().add(getImprovementCollaborationItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addImprovementCollaborationItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addImprovementCollaborationItem2(){

  }

  /**
   * �O�����ݑ�T�[�r�X���p��p�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomeServiceUsageFeeAtHome(){

  }

  /**
   * �O�����ݑ�T�[�r�X���p��p���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomeServiceUsageFeeAtHomeModel(){

    getHomeServiceUsageFeeAtHomeItem1().setButtonIndex(1);

    getHomeServiceUsageFeeAtHomeModel().add(getHomeServiceUsageFeeAtHomeItem1());

    getHomeServiceUsageFeeAtHomeItem2().setButtonIndex(2);

    getHomeServiceUsageFeeAtHomeModel().add(getHomeServiceUsageFeeAtHomeItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomeServiceUsageFeeAtHomeItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomeServiceUsageFeeAtHomeItem2(){

  }

  /**
   * �ē������h�{�A�g���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addReEntryNutritionCooperationAdd(){

  }

  /**
   * �ē������h�{�A�g���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addReEntryNutritionCooperationAddModel(){

    getReEntryNutritionCooperationAddItem1().setButtonIndex(1);

    getReEntryNutritionCooperationAddModel().add(getReEntryNutritionCooperationAddItem1());

    getReEntryNutritionCooperationAddItem2().setButtonIndex(2);

    getReEntryNutritionCooperationAddModel().add(getReEntryNutritionCooperationAddItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addReEntryNutritionCooperationAddItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addReEntryNutritionCooperationAddItem2(){

  }

  /**
   * ��h�{���X�N���P���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLowNutritionalRiskImprovementAdd(){

  }

  /**
   * ��h�{���X�N���P���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addLowNutritionalRiskImprovementAddModel(){

    getLowNutritionalRiskImprovementAddItem1().setButtonIndex(1);

    getLowNutritionalRiskImprovementAddModel().add(getLowNutritionalRiskImprovementAddItem1());

    getLowNutritionalRiskImprovementAddItem2().setButtonIndex(2);

    getLowNutritionalRiskImprovementAddModel().add(getLowNutritionalRiskImprovementAddItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addLowNutritionalRiskImprovementAddItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addLowNutritionalRiskImprovementAddItem2(){

  }

  /**
   * �^�u6�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab6(){

    tab6.add(getPlacementPhysicianEmergencyResponseAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab6.add(getPressureSoresManagementContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab6.add(getExcretionSupportContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab6.add(getKaigoWelfareFacilityCalculationDivisionRadiloContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �z�u��t�ً}���Ή����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPlacementPhysicianEmergencyResponseAdd(){

  }

  /**
   * �z�u��t�ً}���Ή����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPlacementPhysicianEmergencyResponseAddModel(){

    getPlacementPhysicianEmergencyResponseItem1().setButtonIndex(1);

    getPlacementPhysicianEmergencyResponseAddModel().add(getPlacementPhysicianEmergencyResponseItem1());

    getPlacementPhysicianEmergencyResponseItem2().setButtonIndex(2);

    getPlacementPhysicianEmergencyResponseAddModel().add(getPlacementPhysicianEmergencyResponseItem2());

    getPlacementPhysicianEmergencyResponseItem3().setButtonIndex(3);

    getPlacementPhysicianEmergencyResponseAddModel().add(getPlacementPhysicianEmergencyResponseItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPlacementPhysicianEmergencyResponseItem1(){

  }

  /**
   * �����E��Ԃɓ������ڂ�ǉ����܂��B
   */
  protected void addPlacementPhysicianEmergencyResponseItem2(){

  }

  /**
   * �[��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPlacementPhysicianEmergencyResponseItem3(){

  }

  /**
   * ��ጃ}�l�W�����g���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPressureSoresManagement(){

  }

  /**
   * ��ጃ}�l�W�����g���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPressureSoresManagementModel(){

    getPressureSoresManagementItem1().setButtonIndex(1);

    getPressureSoresManagementModel().add(getPressureSoresManagementItem1());

    getPressureSoresManagementItem2().setButtonIndex(2);

    getPressureSoresManagementModel().add(getPressureSoresManagementItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPressureSoresManagementItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addPressureSoresManagementItem2(){

  }

  /**
   * �r���x�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExcretionSupport(){

  }

  /**
   * �r���x�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addExcretionSupportModel(){

    getExcretionSupportItem1().setButtonIndex(1);

    getExcretionSupportModel().add(getExcretionSupportItem1());

    getExcretionSupportItem2().setButtonIndex(2);

    getExcretionSupportModel().add(getExcretionSupportItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addExcretionSupportItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addExcretionSupportItem2(){

  }

  /**
   * �Z��敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityCalculationDivisionRadilo(){

  }

  /**
   * �Z��敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityCalculationDivisionRadiloModel(){

    getKaigoWelfareFacilityCalculationDivisionRadiloItem1().setButtonIndex(1);

    getKaigoWelfareFacilityCalculationDivisionRadiloModel().add(getKaigoWelfareFacilityCalculationDivisionRadiloItem1());

    getKaigoWelfareFacilityCalculationDivisionRadiloItem2().setButtonIndex(2);

    getKaigoWelfareFacilityCalculationDivisionRadiloModel().add(getKaigoWelfareFacilityCalculationDivisionRadiloItem2());

  }

  /**
   * �ʏ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityCalculationDivisionRadiloItem1(){

  }

  /**
   * ���Z�݂̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityCalculationDivisionRadiloItem2(){

  }

  /**
   * �R���|�[�l���g�����������܂��B
   * @throws Exception ��������O
   */
  private void initialize() throws Exception {
    initThis();
    addThis();
  }
  public boolean canBack(VRMap parameters) throws Exception {
    return true;
  }
  public Component getFirstFocusComponent() {

    return null;

  }
  public void initAffair(ACAffairInfo affair) throws Exception {
  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    try {
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QS001_15111_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001_15111_201804Design getThis() {
    return this;
  }
}
