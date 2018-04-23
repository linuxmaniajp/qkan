
/*
 * Project code name "ORCA"
 * 給付管理台帳ソフト QKANCHO（JMA care benefit management software）
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
 * アプリ: QKANCHO
 * 開発者: 亀井　陽一郎
 * 作成日: 2018/02/22  日本コンピューター株式会社 亀井　陽一郎 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン介護医療院 (QS001_15511_201804)
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
 * サービスパターン介護医療院画面項目デザイン(QS001_15511_201804) 
 */
public class QS001_15511_201804Design extends QS001ServicePanel {
  //GUIコンポーネント

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup medicalFacilityHospitalInstitutionDivisionRadio;

  private ACLabelContainer medicalFacilityHospitalInstitutionDivisionRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalInstitutionDivisionRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalHospitalInstitutionDivisionRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalHospitalInstitutionDivisionRadioItem5;

  private ACRadioButtonItem medicalFacilityHospitalHospitalInstitutionDivisionRadioItem3;

  private ACRadioButtonItem medicalFacilityHospitalHospitalInstitutionDivisionRadioItem2;

  private ACRadioButtonItem medicalFacilityHospitalHospitalInstitutionDivisionRadioItem4;

  private ACRadioButtonItem medicalFacilityHospitalHospitalInstitutionDivisionRadioItem6;

  private ACLabelContainer staffAssignmentDivisionContainer;

  private ACValueArrayRadioButtonGroup staffAssignment1Division;

  private ACListModelAdapter staffAssignment1DivisionModel;

  private ACRadioButtonItem staffAssignmentDivisionItem1;

  private ACRadioButtonItem staffAssignmentDivisionItem2;

  private ACRadioButtonItem staffAssignmentDivisionItem3;

  private ACValueArrayRadioButtonGroup staffAssignment2Division;

  private ACListModelAdapter staffAssignment2DivisionModel;

  private ACRadioButtonItem staffAssignmentDivisionItem4;

  private ACRadioButtonItem staffAssignmentDivisionItem5;

  private ACRadioButtonItem staffAssignmentDivisionItem6;

  private ACValueArrayRadioButtonGroup staffAssignment3Division;

  private ACListModelAdapter staffAssignment3DivisionModel;

  private ACRadioButtonItem staffAssignmentDivisionItem7;

  private ACRadioButtonItem staffAssignmentDivisionItem8;

  private ACLabelContainer medicalFacilityHospitalHospitalRoomContena;

  private ACValueArrayRadioButtonGroup medicalFacilityHospitalHospitalRoomRadio;

  private ACListModelAdapter medicalFacilityHospitalHospitalRoomRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalHospitalRoomRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalHospitalRoomRadioItem2;

  private ACValueArrayRadioButtonGroup medicalFacilityHospitalUnitHospitalRoomRadio;

  private ACListModelAdapter medicalFacilityHospitalUnitHospitalRoomRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalUnitHospitalRoomRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalUnitHospitalRoomRadioItem2;

  private ACValueArrayRadioButtonGroup medicalFacilityHospitalNightShiftSubtractionRadio;

  private ACLabelContainer medicalFacilityHospitalNightShiftSubtractionRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalNightShiftSubtractionRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalNightShiftSubtractionRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalNightShiftSubtractionRadioItem2;

  private ACValueArrayRadioButtonGroup unitCareMaintenanceRadio;

  private ACLabelContainer unitCareMaintenanceRadioContainer;

  private ACListModelAdapter unitCareMaintenanceRadioModel;

  private ACRadioButtonItem unitCareMaintenanceRadioItem1;

  private ACRadioButtonItem unitCareMaintenanceRadioItem2;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup bodyRestraintAbolitionRadio;

  private ACLabelContainer bodyRestraintAbolitionRadioContainer;

  private ACListModelAdapter bodyRestraintAbolitionRadioModel;

  private ACRadioButtonItem bodyRestraintAbolitionRadioItem1;

  private ACRadioButtonItem bodyRestraintAbolitionRadioItem2;

  private ACValueArrayRadioButtonGroup environmentalCorridorRadio;

  private ACLabelContainer environmentalCorridorRadioContainer;

  private ACListModelAdapter environmentalCorridorRadioModel;

  private ACRadioButtonItem environmentalCorridorRadioItem1;

  private ACRadioButtonItem environmentalCorridorRadioItem2;

  private ACValueArrayRadioButtonGroup environmentalRecuperationRoomRadio;

  private ACLabelContainer environmentalRecuperationRoomRadioContainer;

  private ACListModelAdapter environmentalRecuperationRoomRadioModel;

  private ACRadioButtonItem environmentalRecuperationRoomRadioItem1;

  private ACRadioButtonItem environmentalRecuperationRoomRadioItem2;

  private ACValueArrayRadioButtonGroup medicalFacilityHospitalSubstraction;

  private ACLabelContainer medicalFacilityHospitalSubstractionContainer;

  private ACListModelAdapter medicalFacilityHospitalSubstractionModel;

  private ACRadioButtonItem medicalFacilityHospitalSubstractionItem1;

  private ACRadioButtonItem medicalFacilityHospitalSubstractionItem2;

  private ACRadioButtonItem medicalFacilityHospitalSubstractionItem3;

  private ACRadioButtonItem medicalFacilityHospitalSubstractionItem4;

  private ACValueArrayRadioButtonGroup hospitalRecuperationAdditionType;

  private ACLabelContainer hospitalRecuperationAdditionTypeContainer;

  private ACListModelAdapter hospitalRecuperationAdditionTypeModel;

  private ACRadioButtonItem hospitalRecuperationAdditionType1;

  private ACRadioButtonItem hospitalRecuperationAdditionType2;

  private ACRadioButtonItem hospitalRecuperationAdditionType3;

  private ACRadioButtonItem hospitalRecuperationAdditionType4;

  private ACRadioButtonItem hospitalRecuperationAdditionType5;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACPanel tab3;

  private ACValueArrayRadioButtonGroup medicalFacilityHospitalStayRadio;

  private ACLabelContainer medicalFacilityHospitalStayRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalStayRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalStayRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalStayRadioItem2;

  private ACValueArrayRadioButtonGroup trialHijoRadio;

  private ACLabelContainer trialHijoRadioContainer;

  private ACListModelAdapter trialHijoRadioModel;

  private ACRadioButtonItem trialHijoRadioItem1;

  private ACRadioButtonItem trialHijoRadioItem2;

  private ACValueArrayRadioButtonGroup medicalFacilityHospitalMedicalExaminationRadio;

  private ACLabelContainer medicalFacilityHospitalMedicalExaminationRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalMedicalExaminationRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalMedicalExaminationRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalMedicalExaminationRadioItem2;

  private ACValueArrayRadioButtonGroup medicalFacilityHospitalStandardRadio;

  private ACLabelContainer medicalFacilityHospitalStandardRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalStandardRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalStandardRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalStandardRadioItem2;

  private ACValueArrayRadioButtonGroup reEntryNutritionCooperationAdd;

  private ACLabelContainer reEntryNutritionCooperationAddContainer;

  private ACListModelAdapter reEntryNutritionCooperationAddModel;

  private ACRadioButtonItem reEntryNutritionCooperationAddItem1;

  private ACRadioButtonItem reEntryNutritionCooperationAddItem2;

  private ACValueArrayRadioButtonGroup medicalFacilityHospitalNutritionRadio;

  private ACLabelContainer medicalFacilityHospitalNutritionRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalNutritionRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalNutritionRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalNutritionRadioItem2;

  private ACValueArrayRadioButtonGroup lowNutritionalRiskImprovementAdd;

  private ACLabelContainer lowNutritionalRiskImprovementAddContainer;

  private ACListModelAdapter lowNutritionalRiskImprovementAddModel;

  private ACRadioButtonItem lowNutritionalRiskImprovementAddItem1;

  private ACRadioButtonItem lowNutritionalRiskImprovementAddItem2;

  private ACValueArrayRadioButtonGroup medicalFacilityHospitalOralSwitchRadio;

  private ACLabelContainer medicalFacilityHospitalOralSwitchRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalOralSwitchRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalOralSwitchRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalOralSwitchRadioItem2;

  private ACLabelContainer oralMaintenanceAddContainer;

  private ACValueArrayRadioButtonGroup oralMaintenanceAdd;

  private ACListModelAdapter oralMaintenanceAddModel;

  private ACRadioButtonItem oralMaintenanceAddItem1;

  private ACRadioButtonItem oralMaintenanceAddItem2;

  private ACIntegerCheckBox oralMaintenanceAddItem3;

  private ACPanel tab4;

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

  private ACValueArrayRadioButtonGroup medicalFacilityHospitalRecuperateDinnerRadio;

  private ACLabelContainer medicalFacilityHospitalRecuperateDinnerRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalRecuperateDinnerRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalRecuperateDinnerRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalRecuperateDinnerRadioItem2;

  private ACRadioButtonItem medicalFacilityHospitalRecuperateDinnerRadioItem3;

  private ACRadioButtonItem medicalFacilityHospitalRecuperateDinnerRadioItem4;

  private ACValueArrayRadioButtonGroup stayReturnSupportAddRadio;

  private ACLabelContainer stayReturnSupportAddRadioContainer;

  private ACListModelAdapter stayReturnSupportAddRadioModel;

  private ACRadioButtonItem stayReturnSupportAddRadioItem1;

  private ACRadioButtonItem stayReturnSupportAddRadioItem2;

  private ACLabelContainer medicalFacilityHospitalHijoAddition;

  private ACIntegerCheckBox leavingHospitalPreConsultationAddition;

  private ACIntegerCheckBox leavingHospitalAfterConsultationAddition;

  private ACIntegerCheckBox leavingHospitalConsultationAddition;

  private ACIntegerCheckBox leavingHospitalDissemination;

  private ACIntegerCheckBox leavingHospitalCooperationAddition;

  private ACIntegerCheckBox leavingHospital;

  private ACMapBindButton medicalFacilityHospitalConsultationFee;

  private ACLabel medicalFacilityHospitalConsultationFeeLabel;

  private ACPanel tab5;

  private ACValueArrayRadioButtonGroup emergencyTreatmentManagementRadio;

  private ACLabelContainer emergencyTreatmentManagementRadioContainer;

  private ACListModelAdapter emergencyTreatmentManagementRadioModel;

  private ACRadioButtonItem emergencyTreatmentManagementItem1;

  private ACRadioButtonItem emergencyTreatmentManagementItem2;

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

  private ACValueArrayRadioButtonGroup treatmentSystemForSevereDementiaDiseaseRadioGroup;

  private ACLabelContainer treatmentSystemForSevereDementiaDiseaseRadioGroupContainer;

  private ACListModelAdapter treatmentSystemForSevereDementiaDiseaseRadioGroupModel;

  private ACRadioButtonItem treatmentSystemForSevereDementiaDiseaseItem1;

  private ACRadioButtonItem treatmentSystemForSevereDementiaDiseaseItem2;

  private ACRadioButtonItem treatmentSystemForSevereDementiaDiseaseItem3;

  private ACValueArrayRadioButtonGroup transferFixingSupportRadio;

  private ACLabelContainer transferFixingSupportRadioContainer;

  private ACListModelAdapter transferFixingSupportRadioModel;

  private ACRadioButtonItem transferFixingSupportItem1;

  private ACRadioButtonItem transferFixingSupportItem2;

  private ACValueArrayRadioButtonGroup excretionSupport;

  private ACLabelContainer excretionSupportContainer;

  private ACListModelAdapter excretionSupportModel;

  private ACRadioButtonItem excretionSupportItem1;

  private ACRadioButtonItem excretionSupportItem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem5;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACBackLabelContainer medicalFacilityDinnerContainer;

  private ACComboBox medicalFacilityDinnerOffer;

  private ACLabelContainer medicalFacilityDinnerOfferContainer;

  private ACComboBoxModelAdapter medicalFacilityDinnerOfferModel;

  private ACTextField medicalFacilityDinnerCost;

  private ACLabelContainer medicalFacilityDinnerCostContainer;

  private ACValueArrayRadioButtonGroup medicalFacilityHospitalCalculationDivisionRadio;

  private ACLabelContainer medicalFacilityHospitalCalculationDivisionRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalCalculationDivisionRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalCalculationDivisionRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalCalculationDivisionRadioItem2;

  //getter

  /**
   * タブペインを取得します。
   * @return タブペイン
   */
  public JTabbedPane getTabs(){
    if(tabs==null){

      tabs = new JTabbedPane();

      addTabs();
    }
    return tabs;

  }

  /**
   * タブ1を取得します。
   * @return タブ1
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
   * 施設等の区分を取得します。
   * @return 施設等の区分
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityHospitalInstitutionDivisionRadio(){
    if(medicalFacilityHospitalInstitutionDivisionRadio==null){

      medicalFacilityHospitalInstitutionDivisionRadio = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityHospitalInstitutionDivisionRadioContainer().setText("施設等の区分");

      medicalFacilityHospitalInstitutionDivisionRadio.setBindPath("1550101");

      medicalFacilityHospitalInstitutionDivisionRadio.setNoSelectIndex(0);

      medicalFacilityHospitalInstitutionDivisionRadio.setUseClearButton(false);

      medicalFacilityHospitalInstitutionDivisionRadio.setModel(getMedicalFacilityHospitalInstitutionDivisionRadioModel());

      medicalFacilityHospitalInstitutionDivisionRadio.setValues(new int[]{1,2,3,4,5,6});

      addMedicalFacilityHospitalInstitutionDivisionRadio();
    }
    return medicalFacilityHospitalInstitutionDivisionRadio;

  }

  /**
   * 施設等の区分コンテナを取得します。
   * @return 施設等の区分コンテナ
   */
  protected ACLabelContainer getMedicalFacilityHospitalInstitutionDivisionRadioContainer(){
    if(medicalFacilityHospitalInstitutionDivisionRadioContainer==null){
      medicalFacilityHospitalInstitutionDivisionRadioContainer = new ACLabelContainer();
      medicalFacilityHospitalInstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalInstitutionDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalInstitutionDivisionRadioContainer.add(getMedicalFacilityHospitalInstitutionDivisionRadio(), null);
    }
    return medicalFacilityHospitalInstitutionDivisionRadioContainer;
  }

  /**
   * 施設等の区分モデルを取得します。
   * @return 施設等の区分モデル
   */
  protected ACListModelAdapter getMedicalFacilityHospitalInstitutionDivisionRadioModel(){
    if(medicalFacilityHospitalInstitutionDivisionRadioModel==null){
      medicalFacilityHospitalInstitutionDivisionRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalInstitutionDivisionRadioModel();
    }
    return medicalFacilityHospitalInstitutionDivisionRadioModel;
  }

  /**
   * I型介護医療院を取得します。
   * @return I型介護医療院
   */
  public ACRadioButtonItem getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem1(){
    if(medicalFacilityHospitalHospitalInstitutionDivisionRadioItem1==null){

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem1.setText("I型介護医療院");

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem1.setGroup(getMedicalFacilityHospitalInstitutionDivisionRadio());

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem1();
    }
    return medicalFacilityHospitalHospitalInstitutionDivisionRadioItem1;

  }

  /**
   * II型介護医療院を取得します。
   * @return II型介護医療院
   */
  public ACRadioButtonItem getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem5(){
    if(medicalFacilityHospitalHospitalInstitutionDivisionRadioItem5==null){

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem5 = new ACRadioButtonItem();

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem5.setText("II型介護医療院");

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem5.setGroup(getMedicalFacilityHospitalInstitutionDivisionRadio());

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem5.setConstraints(VRLayout.FLOW_RETURN);

      addMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem5();
    }
    return medicalFacilityHospitalHospitalInstitutionDivisionRadioItem5;

  }

  /**
   * 特別介護医療院を取得します。
   * @return 特別介護医療院
   */
  public ACRadioButtonItem getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem3(){
    if(medicalFacilityHospitalHospitalInstitutionDivisionRadioItem3==null){

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem3 = new ACRadioButtonItem();

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem3.setText("特別介護医療院");

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem3.setGroup(getMedicalFacilityHospitalInstitutionDivisionRadio());

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem3();
    }
    return medicalFacilityHospitalHospitalInstitutionDivisionRadioItem3;

  }

  /**
   * ユニット型I型介護医療院を取得します。
   * @return ユニット型I型介護医療院
   */
  public ACRadioButtonItem getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem2(){
    if(medicalFacilityHospitalHospitalInstitutionDivisionRadioItem2==null){

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem2.setText("ユニット型I型介護医療院");

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem2.setGroup(getMedicalFacilityHospitalInstitutionDivisionRadio());

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem2();
    }
    return medicalFacilityHospitalHospitalInstitutionDivisionRadioItem2;

  }

  /**
   * ユニット型II型介護医療院を取得します。
   * @return ユニット型II型介護医療院
   */
  public ACRadioButtonItem getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem4(){
    if(medicalFacilityHospitalHospitalInstitutionDivisionRadioItem4==null){

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem4 = new ACRadioButtonItem();

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem4.setText("ユニット型II型介護医療院");

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem4.setGroup(getMedicalFacilityHospitalInstitutionDivisionRadio());

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem4();
    }
    return medicalFacilityHospitalHospitalInstitutionDivisionRadioItem4;

  }

  /**
   * ユニット型特別介護医療院を取得します。
   * @return ユニット型特別介護医療院
   */
  public ACRadioButtonItem getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem6(){
    if(medicalFacilityHospitalHospitalInstitutionDivisionRadioItem6==null){

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem6 = new ACRadioButtonItem();

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem6.setText("ユニット型特別介護医療院");

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem6.setGroup(getMedicalFacilityHospitalInstitutionDivisionRadio());

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem6.setConstraints(VRLayout.FLOW_RETURN);

      addMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem6();
    }
    return medicalFacilityHospitalHospitalInstitutionDivisionRadioItem6;

  }

  /**
   * 人員配置区分コンテナを取得します。
   * @return 人員配置区分コンテナ
   */
  public ACLabelContainer getStaffAssignmentDivisionContainer(){
    if(staffAssignmentDivisionContainer==null){

      staffAssignmentDivisionContainer = new ACLabelContainer();

      staffAssignmentDivisionContainer.setText("人員配置区分");

      staffAssignmentDivisionContainer.setFollowChildEnabled(true);

      addStaffAssignmentDivisionContainer();
    }
    return staffAssignmentDivisionContainer;

  }

  /**
   * 人員配置区分ラジオグループを取得します。
   * @return 人員配置区分ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getStaffAssignment1Division(){
    if(staffAssignment1Division==null){

      staffAssignment1Division = new ACValueArrayRadioButtonGroup();

      staffAssignment1Division.setBindPath("1550102");

      staffAssignment1Division.setUseClearButton(false);

      staffAssignment1Division.setModel(getStaffAssignment1DivisionModel());

      staffAssignment1Division.setValues(new int[]{1,2,3});

      addStaffAssignment1Division();
    }
    return staffAssignment1Division;

  }

  /**
   * 人員配置区分ラジオグループモデルを取得します。
   * @return 人員配置区分ラジオグループモデル
   */
  protected ACListModelAdapter getStaffAssignment1DivisionModel(){
    if(staffAssignment1DivisionModel==null){
      staffAssignment1DivisionModel = new ACListModelAdapter();
      addStaffAssignment1DivisionModel();
    }
    return staffAssignment1DivisionModel;
  }

  /**
   * I型（I）を取得します。
   * @return I型（I）
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem1(){
    if(staffAssignmentDivisionItem1==null){

      staffAssignmentDivisionItem1 = new ACRadioButtonItem();

      staffAssignmentDivisionItem1.setText("I型 (I)");

      staffAssignmentDivisionItem1.setGroup(getStaffAssignment1Division());

      staffAssignmentDivisionItem1.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivisionItem1();
    }
    return staffAssignmentDivisionItem1;

  }

  /**
   * I型（II）を取得します。
   * @return I型（II）
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem2(){
    if(staffAssignmentDivisionItem2==null){

      staffAssignmentDivisionItem2 = new ACRadioButtonItem();

      staffAssignmentDivisionItem2.setText("I型 (II)");

      staffAssignmentDivisionItem2.setGroup(getStaffAssignment1Division());

      staffAssignmentDivisionItem2.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivisionItem2();
    }
    return staffAssignmentDivisionItem2;

  }

  /**
   * I型（III）を取得します。
   * @return I型（III）
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem3(){
    if(staffAssignmentDivisionItem3==null){

      staffAssignmentDivisionItem3 = new ACRadioButtonItem();

      staffAssignmentDivisionItem3.setText("I型 (III)");

      staffAssignmentDivisionItem3.setGroup(getStaffAssignment1Division());

      staffAssignmentDivisionItem3.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivisionItem3();
    }
    return staffAssignmentDivisionItem3;

  }

  /**
   * 人員配置区分を取得します。
   * @return 人員配置区分
   */
  public ACValueArrayRadioButtonGroup getStaffAssignment2Division(){
    if(staffAssignment2Division==null){

      staffAssignment2Division = new ACValueArrayRadioButtonGroup();

      staffAssignment2Division.setBindPath("1550103");

      staffAssignment2Division.setUseClearButton(false);

      staffAssignment2Division.setModel(getStaffAssignment2DivisionModel());

      staffAssignment2Division.setValues(new int[]{1,2,3});

      addStaffAssignment2Division();
    }
    return staffAssignment2Division;

  }

  /**
   * 人員配置区分モデルを取得します。
   * @return 人員配置区分モデル
   */
  protected ACListModelAdapter getStaffAssignment2DivisionModel(){
    if(staffAssignment2DivisionModel==null){
      staffAssignment2DivisionModel = new ACListModelAdapter();
      addStaffAssignment2DivisionModel();
    }
    return staffAssignment2DivisionModel;
  }

  /**
   * II型（I）を取得します。
   * @return II型（I）
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem4(){
    if(staffAssignmentDivisionItem4==null){

      staffAssignmentDivisionItem4 = new ACRadioButtonItem();

      staffAssignmentDivisionItem4.setText("II型 (I)");

      staffAssignmentDivisionItem4.setGroup(getStaffAssignment2Division());

      staffAssignmentDivisionItem4.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivisionItem4();
    }
    return staffAssignmentDivisionItem4;

  }

  /**
   * II型（II）を取得します。
   * @return II型（II）
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem5(){
    if(staffAssignmentDivisionItem5==null){

      staffAssignmentDivisionItem5 = new ACRadioButtonItem();

      staffAssignmentDivisionItem5.setText("II型 (II)");

      staffAssignmentDivisionItem5.setGroup(getStaffAssignment2Division());

      staffAssignmentDivisionItem5.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivisionItem5();
    }
    return staffAssignmentDivisionItem5;

  }

  /**
   * II型（III）を取得します。
   * @return II型（III）
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem6(){
    if(staffAssignmentDivisionItem6==null){

      staffAssignmentDivisionItem6 = new ACRadioButtonItem();

      staffAssignmentDivisionItem6.setText("II型 (III)");

      staffAssignmentDivisionItem6.setGroup(getStaffAssignment2Division());

      staffAssignmentDivisionItem6.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivisionItem6();
    }
    return staffAssignmentDivisionItem6;

  }

  /**
   * 人員配置区分を取得します。
   * @return 人員配置区分
   */
  public ACValueArrayRadioButtonGroup getStaffAssignment3Division(){
    if(staffAssignment3Division==null){

      staffAssignment3Division = new ACValueArrayRadioButtonGroup();

      staffAssignment3Division.setBindPath("1550104");

      staffAssignment3Division.setUseClearButton(false);

      staffAssignment3Division.setModel(getStaffAssignment3DivisionModel());

      staffAssignment3Division.setValues(new int[]{1,2});

      addStaffAssignment3Division();
    }
    return staffAssignment3Division;

  }

  /**
   * 人員配置区分モデルを取得します。
   * @return 人員配置区分モデル
   */
  protected ACListModelAdapter getStaffAssignment3DivisionModel(){
    if(staffAssignment3DivisionModel==null){
      staffAssignment3DivisionModel = new ACListModelAdapter();
      addStaffAssignment3DivisionModel();
    }
    return staffAssignment3DivisionModel;
  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem7(){
    if(staffAssignmentDivisionItem7==null){

      staffAssignmentDivisionItem7 = new ACRadioButtonItem();

      staffAssignmentDivisionItem7.setText("I 型");

      staffAssignmentDivisionItem7.setGroup(getStaffAssignment3Division());

      staffAssignmentDivisionItem7.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivisionItem7();
    }
    return staffAssignmentDivisionItem7;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem8(){
    if(staffAssignmentDivisionItem8==null){

      staffAssignmentDivisionItem8 = new ACRadioButtonItem();

      staffAssignmentDivisionItem8.setText("II 型");

      staffAssignmentDivisionItem8.setGroup(getStaffAssignment3Division());

      staffAssignmentDivisionItem8.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivisionItem8();
    }
    return staffAssignmentDivisionItem8;

  }

  /**
   * 病室区分コンテナを取得します。
   * @return 病室区分コンテナ
   */
  public ACLabelContainer getMedicalFacilityHospitalHospitalRoomContena(){
    if(medicalFacilityHospitalHospitalRoomContena==null){

      medicalFacilityHospitalHospitalRoomContena = new ACLabelContainer();

      medicalFacilityHospitalHospitalRoomContena.setText("病室区分");

      medicalFacilityHospitalHospitalRoomContena.setFollowChildEnabled(true);

      addMedicalFacilityHospitalHospitalRoomContena();
    }
    return medicalFacilityHospitalHospitalRoomContena;

  }

  /**
   * 病室区分（病院）を取得します。
   * @return 病室区分（病院）
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityHospitalHospitalRoomRadio(){
    if(medicalFacilityHospitalHospitalRoomRadio==null){

      medicalFacilityHospitalHospitalRoomRadio = new ACValueArrayRadioButtonGroup();

      medicalFacilityHospitalHospitalRoomRadio.setBindPath("1550105");

      medicalFacilityHospitalHospitalRoomRadio.setUseClearButton(false);

      medicalFacilityHospitalHospitalRoomRadio.setModel(getMedicalFacilityHospitalHospitalRoomRadioModel());

      medicalFacilityHospitalHospitalRoomRadio.setValues(new int[]{1,2});

      addMedicalFacilityHospitalHospitalRoomRadio();
    }
    return medicalFacilityHospitalHospitalRoomRadio;

  }

  /**
   * 病室区分（病院）モデルを取得します。
   * @return 病室区分（病院）モデル
   */
  protected ACListModelAdapter getMedicalFacilityHospitalHospitalRoomRadioModel(){
    if(medicalFacilityHospitalHospitalRoomRadioModel==null){
      medicalFacilityHospitalHospitalRoomRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalHospitalRoomRadioModel();
    }
    return medicalFacilityHospitalHospitalRoomRadioModel;
  }

  /**
   * 従来型個室を取得します。
   * @return 従来型個室
   */
  public ACRadioButtonItem getMedicalFacilityHospitalHospitalRoomRadioItem1(){
    if(medicalFacilityHospitalHospitalRoomRadioItem1==null){

      medicalFacilityHospitalHospitalRoomRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalHospitalRoomRadioItem1.setText("従来型個室");

      medicalFacilityHospitalHospitalRoomRadioItem1.setGroup(getMedicalFacilityHospitalHospitalRoomRadio());

      medicalFacilityHospitalHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalHospitalRoomRadioItem1();
    }
    return medicalFacilityHospitalHospitalRoomRadioItem1;

  }

  /**
   * 多床室を取得します。
   * @return 多床室
   */
  public ACRadioButtonItem getMedicalFacilityHospitalHospitalRoomRadioItem2(){
    if(medicalFacilityHospitalHospitalRoomRadioItem2==null){

      medicalFacilityHospitalHospitalRoomRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalHospitalRoomRadioItem2.setText("多床室");

      medicalFacilityHospitalHospitalRoomRadioItem2.setGroup(getMedicalFacilityHospitalHospitalRoomRadio());

      medicalFacilityHospitalHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalHospitalRoomRadioItem2();
    }
    return medicalFacilityHospitalHospitalRoomRadioItem2;

  }

  /**
   * 病室区分（ユニット型）を取得します。
   * @return 病室区分（ユニット型）
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityHospitalUnitHospitalRoomRadio(){
    if(medicalFacilityHospitalUnitHospitalRoomRadio==null){

      medicalFacilityHospitalUnitHospitalRoomRadio = new ACValueArrayRadioButtonGroup();

      medicalFacilityHospitalUnitHospitalRoomRadio.setBindPath("1550106");

      medicalFacilityHospitalUnitHospitalRoomRadio.setUseClearButton(false);

      medicalFacilityHospitalUnitHospitalRoomRadio.setModel(getMedicalFacilityHospitalUnitHospitalRoomRadioModel());

      medicalFacilityHospitalUnitHospitalRoomRadio.setValues(new int[]{1,2});

      addMedicalFacilityHospitalUnitHospitalRoomRadio();
    }
    return medicalFacilityHospitalUnitHospitalRoomRadio;

  }

  /**
   * 病室区分（ユニット型）モデルを取得します。
   * @return 病室区分（ユニット型）モデル
   */
  protected ACListModelAdapter getMedicalFacilityHospitalUnitHospitalRoomRadioModel(){
    if(medicalFacilityHospitalUnitHospitalRoomRadioModel==null){
      medicalFacilityHospitalUnitHospitalRoomRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalUnitHospitalRoomRadioModel();
    }
    return medicalFacilityHospitalUnitHospitalRoomRadioModel;
  }

  /**
   * ユニット型個室を取得します。
   * @return ユニット型個室
   */
  public ACRadioButtonItem getMedicalFacilityHospitalUnitHospitalRoomRadioItem1(){
    if(medicalFacilityHospitalUnitHospitalRoomRadioItem1==null){

      medicalFacilityHospitalUnitHospitalRoomRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalUnitHospitalRoomRadioItem1.setText("ﾕﾆｯﾄ型個室");

      medicalFacilityHospitalUnitHospitalRoomRadioItem1.setGroup(getMedicalFacilityHospitalUnitHospitalRoomRadio());

      medicalFacilityHospitalUnitHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalUnitHospitalRoomRadioItem1();
    }
    return medicalFacilityHospitalUnitHospitalRoomRadioItem1;

  }

  /**
   * ユニット型個室的多床室を取得します。
   * @return ユニット型個室的多床室
   */
  public ACRadioButtonItem getMedicalFacilityHospitalUnitHospitalRoomRadioItem2(){
    if(medicalFacilityHospitalUnitHospitalRoomRadioItem2==null){

      medicalFacilityHospitalUnitHospitalRoomRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalUnitHospitalRoomRadioItem2.setText("ﾕﾆｯﾄ型個室的多床室");

      medicalFacilityHospitalUnitHospitalRoomRadioItem2.setGroup(getMedicalFacilityHospitalUnitHospitalRoomRadio());

      medicalFacilityHospitalUnitHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalUnitHospitalRoomRadioItem2();
    }
    return medicalFacilityHospitalUnitHospitalRoomRadioItem2;

  }

  /**
   * 夜間勤務条件基準を取得します。
   * @return 夜間勤務条件基準
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityHospitalNightShiftSubtractionRadio(){
    if(medicalFacilityHospitalNightShiftSubtractionRadio==null){

      medicalFacilityHospitalNightShiftSubtractionRadio = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityHospitalNightShiftSubtractionRadioContainer().setText("夜間勤務条件基準");

      medicalFacilityHospitalNightShiftSubtractionRadio.setBindPath("1550107");

      medicalFacilityHospitalNightShiftSubtractionRadio.setNoSelectIndex(0);

      medicalFacilityHospitalNightShiftSubtractionRadio.setUseClearButton(false);

      medicalFacilityHospitalNightShiftSubtractionRadio.setModel(getMedicalFacilityHospitalNightShiftSubtractionRadioModel());

      medicalFacilityHospitalNightShiftSubtractionRadio.setValues(new int[]{1,2});

      addMedicalFacilityHospitalNightShiftSubtractionRadio();
    }
    return medicalFacilityHospitalNightShiftSubtractionRadio;

  }

  /**
   * 夜間勤務条件基準コンテナを取得します。
   * @return 夜間勤務条件基準コンテナ
   */
  protected ACLabelContainer getMedicalFacilityHospitalNightShiftSubtractionRadioContainer(){
    if(medicalFacilityHospitalNightShiftSubtractionRadioContainer==null){
      medicalFacilityHospitalNightShiftSubtractionRadioContainer = new ACLabelContainer();
      medicalFacilityHospitalNightShiftSubtractionRadioContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalNightShiftSubtractionRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalNightShiftSubtractionRadioContainer.add(getMedicalFacilityHospitalNightShiftSubtractionRadio(), null);
    }
    return medicalFacilityHospitalNightShiftSubtractionRadioContainer;
  }

  /**
   * 夜間勤務条件基準モデルを取得します。
   * @return 夜間勤務条件基準モデル
   */
  protected ACListModelAdapter getMedicalFacilityHospitalNightShiftSubtractionRadioModel(){
    if(medicalFacilityHospitalNightShiftSubtractionRadioModel==null){
      medicalFacilityHospitalNightShiftSubtractionRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalNightShiftSubtractionRadioModel();
    }
    return medicalFacilityHospitalNightShiftSubtractionRadioModel;
  }

  /**
   * 基準型を取得します。
   * @return 基準型
   */
  public ACRadioButtonItem getMedicalFacilityHospitalNightShiftSubtractionRadioItem1(){
    if(medicalFacilityHospitalNightShiftSubtractionRadioItem1==null){

      medicalFacilityHospitalNightShiftSubtractionRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalNightShiftSubtractionRadioItem1.setText("基準型");

      medicalFacilityHospitalNightShiftSubtractionRadioItem1.setGroup(getMedicalFacilityHospitalNightShiftSubtractionRadio());

      medicalFacilityHospitalNightShiftSubtractionRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalNightShiftSubtractionRadioItem1();
    }
    return medicalFacilityHospitalNightShiftSubtractionRadioItem1;

  }

  /**
   * 減算型を取得します。
   * @return 減算型
   */
  public ACRadioButtonItem getMedicalFacilityHospitalNightShiftSubtractionRadioItem2(){
    if(medicalFacilityHospitalNightShiftSubtractionRadioItem2==null){

      medicalFacilityHospitalNightShiftSubtractionRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalNightShiftSubtractionRadioItem2.setText("減算型");

      medicalFacilityHospitalNightShiftSubtractionRadioItem2.setGroup(getMedicalFacilityHospitalNightShiftSubtractionRadio());

      medicalFacilityHospitalNightShiftSubtractionRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalNightShiftSubtractionRadioItem2();
    }
    return medicalFacilityHospitalNightShiftSubtractionRadioItem2;

  }

  /**
   * ユニットケアの整備を取得します。
   * @return ユニットケアの整備
   */
  public ACValueArrayRadioButtonGroup getUnitCareMaintenanceRadio(){
    if(unitCareMaintenanceRadio==null){

      unitCareMaintenanceRadio = new ACValueArrayRadioButtonGroup();

      getUnitCareMaintenanceRadioContainer().setText("ユニットケアの整備");

      unitCareMaintenanceRadio.setBindPath("1550108");

      unitCareMaintenanceRadio.setUseClearButton(false);

      unitCareMaintenanceRadio.setModel(getUnitCareMaintenanceRadioModel());

      unitCareMaintenanceRadio.setValues(new int[]{1,2});

      addUnitCareMaintenanceRadio();
    }
    return unitCareMaintenanceRadio;

  }

  /**
   * ユニットケアの整備コンテナを取得します。
   * @return ユニットケアの整備コンテナ
   */
  protected ACLabelContainer getUnitCareMaintenanceRadioContainer(){
    if(unitCareMaintenanceRadioContainer==null){
      unitCareMaintenanceRadioContainer = new ACLabelContainer();
      unitCareMaintenanceRadioContainer.setFollowChildEnabled(true);
      unitCareMaintenanceRadioContainer.setVAlignment(VRLayout.CENTER);
      unitCareMaintenanceRadioContainer.add(getUnitCareMaintenanceRadio(), null);
    }
    return unitCareMaintenanceRadioContainer;
  }

  /**
   * ユニットケアの整備モデルを取得します。
   * @return ユニットケアの整備モデル
   */
  protected ACListModelAdapter getUnitCareMaintenanceRadioModel(){
    if(unitCareMaintenanceRadioModel==null){
      unitCareMaintenanceRadioModel = new ACListModelAdapter();
      addUnitCareMaintenanceRadioModel();
    }
    return unitCareMaintenanceRadioModel;
  }

  /**
   * 未整備を取得します。
   * @return 未整備
   */
  public ACRadioButtonItem getUnitCareMaintenanceRadioItem1(){
    if(unitCareMaintenanceRadioItem1==null){

      unitCareMaintenanceRadioItem1 = new ACRadioButtonItem();

      unitCareMaintenanceRadioItem1.setText("未整備");

      unitCareMaintenanceRadioItem1.setGroup(getUnitCareMaintenanceRadio());

      unitCareMaintenanceRadioItem1.setConstraints(VRLayout.FLOW);

      addUnitCareMaintenanceRadioItem1();
    }
    return unitCareMaintenanceRadioItem1;

  }

  /**
   * 整備を取得します。
   * @return 整備
   */
  public ACRadioButtonItem getUnitCareMaintenanceRadioItem2(){
    if(unitCareMaintenanceRadioItem2==null){

      unitCareMaintenanceRadioItem2 = new ACRadioButtonItem();

      unitCareMaintenanceRadioItem2.setText("整備");

      unitCareMaintenanceRadioItem2.setGroup(getUnitCareMaintenanceRadio());

      unitCareMaintenanceRadioItem2.setConstraints(VRLayout.FLOW);

      addUnitCareMaintenanceRadioItem2();
    }
    return unitCareMaintenanceRadioItem2;

  }

  /**
   * タブ2を取得します。
   * @return タブ2
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
   * 身体拘束廃止未実施減算を取得します。
   * @return 身体拘束廃止未実施減算
   */
  public ACValueArrayRadioButtonGroup getBodyRestraintAbolitionRadio(){
    if(bodyRestraintAbolitionRadio==null){

      bodyRestraintAbolitionRadio = new ACValueArrayRadioButtonGroup();

      getBodyRestraintAbolitionRadioContainer().setText("身体拘束廃止未実施減算");

      bodyRestraintAbolitionRadio.setBindPath("1550109");

      bodyRestraintAbolitionRadio.setUseClearButton(false);

      bodyRestraintAbolitionRadio.setModel(getBodyRestraintAbolitionRadioModel());

      bodyRestraintAbolitionRadio.setValues(new int[]{1,2});

      addBodyRestraintAbolitionRadio();
    }
    return bodyRestraintAbolitionRadio;

  }

  /**
   * 身体拘束廃止未実施減算コンテナを取得します。
   * @return 身体拘束廃止未実施減算コンテナ
   */
  protected ACLabelContainer getBodyRestraintAbolitionRadioContainer(){
    if(bodyRestraintAbolitionRadioContainer==null){
      bodyRestraintAbolitionRadioContainer = new ACLabelContainer();
      bodyRestraintAbolitionRadioContainer.setFollowChildEnabled(true);
      bodyRestraintAbolitionRadioContainer.setVAlignment(VRLayout.CENTER);
      bodyRestraintAbolitionRadioContainer.add(getBodyRestraintAbolitionRadio(), null);
    }
    return bodyRestraintAbolitionRadioContainer;
  }

  /**
   * 身体拘束廃止未実施減算モデルを取得します。
   * @return 身体拘束廃止未実施減算モデル
   */
  protected ACListModelAdapter getBodyRestraintAbolitionRadioModel(){
    if(bodyRestraintAbolitionRadioModel==null){
      bodyRestraintAbolitionRadioModel = new ACListModelAdapter();
      addBodyRestraintAbolitionRadioModel();
    }
    return bodyRestraintAbolitionRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getBodyRestraintAbolitionRadioItem1(){
    if(bodyRestraintAbolitionRadioItem1==null){

      bodyRestraintAbolitionRadioItem1 = new ACRadioButtonItem();

      bodyRestraintAbolitionRadioItem1.setText("なし");

      bodyRestraintAbolitionRadioItem1.setGroup(getBodyRestraintAbolitionRadio());

      bodyRestraintAbolitionRadioItem1.setConstraints(VRLayout.FLOW);

      addBodyRestraintAbolitionRadioItem1();
    }
    return bodyRestraintAbolitionRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getBodyRestraintAbolitionRadioItem2(){
    if(bodyRestraintAbolitionRadioItem2==null){

      bodyRestraintAbolitionRadioItem2 = new ACRadioButtonItem();

      bodyRestraintAbolitionRadioItem2.setText("あり");

      bodyRestraintAbolitionRadioItem2.setGroup(getBodyRestraintAbolitionRadio());

      bodyRestraintAbolitionRadioItem2.setConstraints(VRLayout.FLOW);

      addBodyRestraintAbolitionRadioItem2();
    }
    return bodyRestraintAbolitionRadioItem2;

  }

  /**
   * 療養環境基準（廊下）を取得します。
   * @return 療養環境基準（廊下）
   */
  public ACValueArrayRadioButtonGroup getEnvironmentalCorridorRadio(){
    if(environmentalCorridorRadio==null){

      environmentalCorridorRadio = new ACValueArrayRadioButtonGroup();

      getEnvironmentalCorridorRadioContainer().setText("療養環境基準（廊下）");

      environmentalCorridorRadio.setBindPath("1550110");

      environmentalCorridorRadio.setUseClearButton(false);

      environmentalCorridorRadio.setModel(getEnvironmentalCorridorRadioModel());

      environmentalCorridorRadio.setValues(new int[]{1,2});

      addEnvironmentalCorridorRadio();
    }
    return environmentalCorridorRadio;

  }

  /**
   * 療養環境基準（廊下）コンテナを取得します。
   * @return 療養環境基準（廊下）コンテナ
   */
  protected ACLabelContainer getEnvironmentalCorridorRadioContainer(){
    if(environmentalCorridorRadioContainer==null){
      environmentalCorridorRadioContainer = new ACLabelContainer();
      environmentalCorridorRadioContainer.setFollowChildEnabled(true);
      environmentalCorridorRadioContainer.setVAlignment(VRLayout.CENTER);
      environmentalCorridorRadioContainer.add(getEnvironmentalCorridorRadio(), null);
    }
    return environmentalCorridorRadioContainer;
  }

  /**
   * 療養環境基準（廊下）モデルを取得します。
   * @return 療養環境基準（廊下）モデル
   */
  protected ACListModelAdapter getEnvironmentalCorridorRadioModel(){
    if(environmentalCorridorRadioModel==null){
      environmentalCorridorRadioModel = new ACListModelAdapter();
      addEnvironmentalCorridorRadioModel();
    }
    return environmentalCorridorRadioModel;
  }

  /**
   * 基準型を取得します。
   * @return 基準型
   */
  public ACRadioButtonItem getEnvironmentalCorridorRadioItem1(){
    if(environmentalCorridorRadioItem1==null){

      environmentalCorridorRadioItem1 = new ACRadioButtonItem();

      environmentalCorridorRadioItem1.setText("基準型");

      environmentalCorridorRadioItem1.setGroup(getEnvironmentalCorridorRadio());

      environmentalCorridorRadioItem1.setConstraints(VRLayout.FLOW);

      addEnvironmentalCorridorRadioItem1();
    }
    return environmentalCorridorRadioItem1;

  }

  /**
   * 減算型を取得します。
   * @return 減算型
   */
  public ACRadioButtonItem getEnvironmentalCorridorRadioItem2(){
    if(environmentalCorridorRadioItem2==null){

      environmentalCorridorRadioItem2 = new ACRadioButtonItem();

      environmentalCorridorRadioItem2.setText("減算型");

      environmentalCorridorRadioItem2.setGroup(getEnvironmentalCorridorRadio());

      environmentalCorridorRadioItem2.setConstraints(VRLayout.FLOW);

      addEnvironmentalCorridorRadioItem2();
    }
    return environmentalCorridorRadioItem2;

  }

  /**
   * 療養環境基準（療養室）を取得します。
   * @return 療養環境基準（療養室）
   */
  public ACValueArrayRadioButtonGroup getEnvironmentalRecuperationRoomRadio(){
    if(environmentalRecuperationRoomRadio==null){

      environmentalRecuperationRoomRadio = new ACValueArrayRadioButtonGroup();

      getEnvironmentalRecuperationRoomRadioContainer().setText("療養環境基準（療養室）");

      environmentalRecuperationRoomRadio.setBindPath("1550111");

      environmentalRecuperationRoomRadio.setUseClearButton(false);

      environmentalRecuperationRoomRadio.setModel(getEnvironmentalRecuperationRoomRadioModel());

      environmentalRecuperationRoomRadio.setValues(new int[]{1,2});

      addEnvironmentalRecuperationRoomRadio();
    }
    return environmentalRecuperationRoomRadio;

  }

  /**
   * 療養環境基準（療養室）コンテナを取得します。
   * @return 療養環境基準（療養室）コンテナ
   */
  protected ACLabelContainer getEnvironmentalRecuperationRoomRadioContainer(){
    if(environmentalRecuperationRoomRadioContainer==null){
      environmentalRecuperationRoomRadioContainer = new ACLabelContainer();
      environmentalRecuperationRoomRadioContainer.setFollowChildEnabled(true);
      environmentalRecuperationRoomRadioContainer.setVAlignment(VRLayout.CENTER);
      environmentalRecuperationRoomRadioContainer.add(getEnvironmentalRecuperationRoomRadio(), null);
    }
    return environmentalRecuperationRoomRadioContainer;
  }

  /**
   * 療養環境基準（療養室）モデルを取得します。
   * @return 療養環境基準（療養室）モデル
   */
  protected ACListModelAdapter getEnvironmentalRecuperationRoomRadioModel(){
    if(environmentalRecuperationRoomRadioModel==null){
      environmentalRecuperationRoomRadioModel = new ACListModelAdapter();
      addEnvironmentalRecuperationRoomRadioModel();
    }
    return environmentalRecuperationRoomRadioModel;
  }

  /**
   * 基準型を取得します。
   * @return 基準型
   */
  public ACRadioButtonItem getEnvironmentalRecuperationRoomRadioItem1(){
    if(environmentalRecuperationRoomRadioItem1==null){

      environmentalRecuperationRoomRadioItem1 = new ACRadioButtonItem();

      environmentalRecuperationRoomRadioItem1.setText("基準型");

      environmentalRecuperationRoomRadioItem1.setGroup(getEnvironmentalRecuperationRoomRadio());

      environmentalRecuperationRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addEnvironmentalRecuperationRoomRadioItem1();
    }
    return environmentalRecuperationRoomRadioItem1;

  }

  /**
   * 減算型を取得します。
   * @return 減算型
   */
  public ACRadioButtonItem getEnvironmentalRecuperationRoomRadioItem2(){
    if(environmentalRecuperationRoomRadioItem2==null){

      environmentalRecuperationRoomRadioItem2 = new ACRadioButtonItem();

      environmentalRecuperationRoomRadioItem2.setText("減算型");

      environmentalRecuperationRoomRadioItem2.setGroup(getEnvironmentalRecuperationRoomRadio());

      environmentalRecuperationRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addEnvironmentalRecuperationRoomRadioItem2();
    }
    return environmentalRecuperationRoomRadioItem2;

  }

  /**
   * 職員減算を取得します。
   * @return 職員減算
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityHospitalSubstraction(){
    if(medicalFacilityHospitalSubstraction==null){

      medicalFacilityHospitalSubstraction = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityHospitalSubstractionContainer().setText("人員減算");

      medicalFacilityHospitalSubstraction.setBindPath("1550128");

      medicalFacilityHospitalSubstraction.setUseClearButton(false);

      medicalFacilityHospitalSubstraction.setModel(getMedicalFacilityHospitalSubstractionModel());

      medicalFacilityHospitalSubstraction.setValues(new int[]{1,2,3,4});

      addMedicalFacilityHospitalSubstraction();
    }
    return medicalFacilityHospitalSubstraction;

  }

  /**
   * 職員減算コンテナを取得します。
   * @return 職員減算コンテナ
   */
  protected ACLabelContainer getMedicalFacilityHospitalSubstractionContainer(){
    if(medicalFacilityHospitalSubstractionContainer==null){
      medicalFacilityHospitalSubstractionContainer = new ACLabelContainer();
      medicalFacilityHospitalSubstractionContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalSubstractionContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalSubstractionContainer.add(getMedicalFacilityHospitalSubstraction(), null);
    }
    return medicalFacilityHospitalSubstractionContainer;
  }

  /**
   * 職員減算モデルを取得します。
   * @return 職員減算モデル
   */
  protected ACListModelAdapter getMedicalFacilityHospitalSubstractionModel(){
    if(medicalFacilityHospitalSubstractionModel==null){
      medicalFacilityHospitalSubstractionModel = new ACListModelAdapter();
      addMedicalFacilityHospitalSubstractionModel();
    }
    return medicalFacilityHospitalSubstractionModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalFacilityHospitalSubstractionItem1(){
    if(medicalFacilityHospitalSubstractionItem1==null){

      medicalFacilityHospitalSubstractionItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalSubstractionItem1.setText("なし");

      medicalFacilityHospitalSubstractionItem1.setGroup(getMedicalFacilityHospitalSubstraction());

      medicalFacilityHospitalSubstractionItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalSubstractionItem1();
    }
    return medicalFacilityHospitalSubstractionItem1;

  }

  /**
   * 定員超過を取得します。
   * @return 定員超過
   */
  public ACRadioButtonItem getMedicalFacilityHospitalSubstractionItem2(){
    if(medicalFacilityHospitalSubstractionItem2==null){

      medicalFacilityHospitalSubstractionItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalSubstractionItem2.setText("定員超過");

      medicalFacilityHospitalSubstractionItem2.setGroup(getMedicalFacilityHospitalSubstraction());

      medicalFacilityHospitalSubstractionItem2.setConstraints(VRLayout.FLOW_RETURN);

      addMedicalFacilityHospitalSubstractionItem2();
    }
    return medicalFacilityHospitalSubstractionItem2;

  }

  /**
   * 医師・薬剤師・看護職員・介護職員・介護支援専門員の不足を取得します。
   * @return 医師・薬剤師・看護職員・介護職員・介護支援専門員の不足
   */
  public ACRadioButtonItem getMedicalFacilityHospitalSubstractionItem3(){
    if(medicalFacilityHospitalSubstractionItem3==null){

      medicalFacilityHospitalSubstractionItem3 = new ACRadioButtonItem();

      medicalFacilityHospitalSubstractionItem3.setText("<html>医師・薬剤師・看護職員<br>介護職員・介護支援専門員の不足<html>");

      medicalFacilityHospitalSubstractionItem3.setGroup(getMedicalFacilityHospitalSubstraction());

      medicalFacilityHospitalSubstractionItem3.setConstraints(VRLayout.FLOW_RETURN);

      addMedicalFacilityHospitalSubstractionItem3();
    }
    return medicalFacilityHospitalSubstractionItem3;

  }

  /**
   * 正看比率が20％未満を取得します。
   * @return 正看比率が20％未満
   */
  public ACRadioButtonItem getMedicalFacilityHospitalSubstractionItem4(){
    if(medicalFacilityHospitalSubstractionItem4==null){

      medicalFacilityHospitalSubstractionItem4 = new ACRadioButtonItem();

      medicalFacilityHospitalSubstractionItem4.setText("正看比率が20％未満");

      medicalFacilityHospitalSubstractionItem4.setGroup(getMedicalFacilityHospitalSubstraction());

      medicalFacilityHospitalSubstractionItem4.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalSubstractionItem4();
    }
    return medicalFacilityHospitalSubstractionItem4;

  }

  /**
   * 夜間勤務等看護加算を取得します。
   * @return 夜間勤務等看護加算
   */
  public ACValueArrayRadioButtonGroup getHospitalRecuperationAdditionType(){
    if(hospitalRecuperationAdditionType==null){

      hospitalRecuperationAdditionType = new ACValueArrayRadioButtonGroup();

      getHospitalRecuperationAdditionTypeContainer().setText("夜間勤務等看護加算");

      hospitalRecuperationAdditionType.setBindPath("1550112");

      hospitalRecuperationAdditionType.setUseClearButton(false);

      hospitalRecuperationAdditionType.setModel(getHospitalRecuperationAdditionTypeModel());

      hospitalRecuperationAdditionType.setValues(new int[]{1,2,3,4,5});

      addHospitalRecuperationAdditionType();
    }
    return hospitalRecuperationAdditionType;

  }

  /**
   * 夜間勤務等看護加算コンテナを取得します。
   * @return 夜間勤務等看護加算コンテナ
   */
  protected ACLabelContainer getHospitalRecuperationAdditionTypeContainer(){
    if(hospitalRecuperationAdditionTypeContainer==null){
      hospitalRecuperationAdditionTypeContainer = new ACLabelContainer();
      hospitalRecuperationAdditionTypeContainer.setFollowChildEnabled(true);
      hospitalRecuperationAdditionTypeContainer.setVAlignment(VRLayout.CENTER);
      hospitalRecuperationAdditionTypeContainer.add(getHospitalRecuperationAdditionType(), null);
    }
    return hospitalRecuperationAdditionTypeContainer;
  }

  /**
   * 夜間勤務等看護加算モデルを取得します。
   * @return 夜間勤務等看護加算モデル
   */
  protected ACListModelAdapter getHospitalRecuperationAdditionTypeModel(){
    if(hospitalRecuperationAdditionTypeModel==null){
      hospitalRecuperationAdditionTypeModel = new ACListModelAdapter();
      addHospitalRecuperationAdditionTypeModel();
    }
    return hospitalRecuperationAdditionTypeModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHospitalRecuperationAdditionType1(){
    if(hospitalRecuperationAdditionType1==null){

      hospitalRecuperationAdditionType1 = new ACRadioButtonItem();

      hospitalRecuperationAdditionType1.setText("なし");

      hospitalRecuperationAdditionType1.setGroup(getHospitalRecuperationAdditionType());

      hospitalRecuperationAdditionType1.setConstraints(VRLayout.FLOW);

      addHospitalRecuperationAdditionType1();
    }
    return hospitalRecuperationAdditionType1;

  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getHospitalRecuperationAdditionType2(){
    if(hospitalRecuperationAdditionType2==null){

      hospitalRecuperationAdditionType2 = new ACRadioButtonItem();

      hospitalRecuperationAdditionType2.setText("I型");

      hospitalRecuperationAdditionType2.setGroup(getHospitalRecuperationAdditionType());

      hospitalRecuperationAdditionType2.setConstraints(VRLayout.FLOW);

      addHospitalRecuperationAdditionType2();
    }
    return hospitalRecuperationAdditionType2;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getHospitalRecuperationAdditionType3(){
    if(hospitalRecuperationAdditionType3==null){

      hospitalRecuperationAdditionType3 = new ACRadioButtonItem();

      hospitalRecuperationAdditionType3.setText("II型");

      hospitalRecuperationAdditionType3.setGroup(getHospitalRecuperationAdditionType());

      hospitalRecuperationAdditionType3.setConstraints(VRLayout.FLOW_RETURN);

      addHospitalRecuperationAdditionType3();
    }
    return hospitalRecuperationAdditionType3;

  }

  /**
   * III型を取得します。
   * @return III型
   */
  public ACRadioButtonItem getHospitalRecuperationAdditionType4(){
    if(hospitalRecuperationAdditionType4==null){

      hospitalRecuperationAdditionType4 = new ACRadioButtonItem();

      hospitalRecuperationAdditionType4.setText("III型");

      hospitalRecuperationAdditionType4.setGroup(getHospitalRecuperationAdditionType());

      hospitalRecuperationAdditionType4.setConstraints(VRLayout.FLOW);

      addHospitalRecuperationAdditionType4();
    }
    return hospitalRecuperationAdditionType4;

  }

  /**
   * IV型を取得します。
   * @return IV型
   */
  public ACRadioButtonItem getHospitalRecuperationAdditionType5(){
    if(hospitalRecuperationAdditionType5==null){

      hospitalRecuperationAdditionType5 = new ACRadioButtonItem();

      hospitalRecuperationAdditionType5.setText("IV型");

      hospitalRecuperationAdditionType5.setGroup(getHospitalRecuperationAdditionType());

      hospitalRecuperationAdditionType5.setConstraints(VRLayout.FLOW);

      addHospitalRecuperationAdditionType5();
    }
    return hospitalRecuperationAdditionType5;

  }

  /**
   * 若年性認知症入所者受入加算を取得します。
   * @return 若年性認知症入所者受入加算
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("若年性認知症入所者受入加算");

      youngDementiaPatinetAddRadioGroup.setBindPath("1550113");

      youngDementiaPatinetAddRadioGroup.setNoSelectIndex(0);

      youngDementiaPatinetAddRadioGroup.setUseClearButton(false);

      youngDementiaPatinetAddRadioGroup.setModel(getYoungDementiaPatinetAddRadioGroupModel());

      youngDementiaPatinetAddRadioGroup.setValues(new int[]{1,2});

      addYoungDementiaPatinetAddRadioGroup();
    }
    return youngDementiaPatinetAddRadioGroup;

  }

  /**
   * 若年性認知症入所者受入加算コンテナを取得します。
   * @return 若年性認知症入所者受入加算コンテナ
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
   * 若年性認知症入所者受入加算モデルを取得します。
   * @return 若年性認知症入所者受入加算モデル
   */
  protected ACListModelAdapter getYoungDementiaPatinetAddRadioGroupModel(){
    if(youngDementiaPatinetAddRadioGroupModel==null){
      youngDementiaPatinetAddRadioGroupModel = new ACListModelAdapter();
      addYoungDementiaPatinetAddRadioGroupModel();
    }
    return youngDementiaPatinetAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getYoungDementiaPatinetAddRadioItem1(){
    if(youngDementiaPatinetAddRadioItem1==null){

      youngDementiaPatinetAddRadioItem1 = new ACRadioButtonItem();

      youngDementiaPatinetAddRadioItem1.setText("なし");

      youngDementiaPatinetAddRadioItem1.setGroup(getYoungDementiaPatinetAddRadioGroup());

      youngDementiaPatinetAddRadioItem1.setConstraints(VRLayout.FLOW);

      addYoungDementiaPatinetAddRadioItem1();
    }
    return youngDementiaPatinetAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getYoungDementiaPatinetAddRadioItem2(){
    if(youngDementiaPatinetAddRadioItem2==null){

      youngDementiaPatinetAddRadioItem2 = new ACRadioButtonItem();

      youngDementiaPatinetAddRadioItem2.setText("あり");

      youngDementiaPatinetAddRadioItem2.setGroup(getYoungDementiaPatinetAddRadioGroup());

      youngDementiaPatinetAddRadioItem2.setConstraints(VRLayout.FLOW);

      addYoungDementiaPatinetAddRadioItem2();
    }
    return youngDementiaPatinetAddRadioItem2;

  }

  /**
   * タブ3を取得します。
   * @return タブ3
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
   * 外泊時費用を取得します。
   * @return 外泊時費用
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityHospitalStayRadio(){
    if(medicalFacilityHospitalStayRadio==null){

      medicalFacilityHospitalStayRadio = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityHospitalStayRadioContainer().setText("外泊時費用");

      medicalFacilityHospitalStayRadio.setBindPath("1550114");

      medicalFacilityHospitalStayRadio.setUseClearButton(false);

      medicalFacilityHospitalStayRadio.setModel(getMedicalFacilityHospitalStayRadioModel());

      medicalFacilityHospitalStayRadio.setValues(new int[]{1,2});

      addMedicalFacilityHospitalStayRadio();
    }
    return medicalFacilityHospitalStayRadio;

  }

  /**
   * 外泊時費用コンテナを取得します。
   * @return 外泊時費用コンテナ
   */
  protected ACLabelContainer getMedicalFacilityHospitalStayRadioContainer(){
    if(medicalFacilityHospitalStayRadioContainer==null){
      medicalFacilityHospitalStayRadioContainer = new ACLabelContainer();
      medicalFacilityHospitalStayRadioContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalStayRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalStayRadioContainer.add(getMedicalFacilityHospitalStayRadio(), null);
    }
    return medicalFacilityHospitalStayRadioContainer;
  }

  /**
   * 外泊時費用モデルを取得します。
   * @return 外泊時費用モデル
   */
  protected ACListModelAdapter getMedicalFacilityHospitalStayRadioModel(){
    if(medicalFacilityHospitalStayRadioModel==null){
      medicalFacilityHospitalStayRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalStayRadioModel();
    }
    return medicalFacilityHospitalStayRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalFacilityHospitalStayRadioItem1(){
    if(medicalFacilityHospitalStayRadioItem1==null){

      medicalFacilityHospitalStayRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalStayRadioItem1.setText("なし");

      medicalFacilityHospitalStayRadioItem1.setGroup(getMedicalFacilityHospitalStayRadio());

      medicalFacilityHospitalStayRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalStayRadioItem1();
    }
    return medicalFacilityHospitalStayRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMedicalFacilityHospitalStayRadioItem2(){
    if(medicalFacilityHospitalStayRadioItem2==null){

      medicalFacilityHospitalStayRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalStayRadioItem2.setText("あり");

      medicalFacilityHospitalStayRadioItem2.setGroup(getMedicalFacilityHospitalStayRadio());

      medicalFacilityHospitalStayRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalStayRadioItem2();
    }
    return medicalFacilityHospitalStayRadioItem2;

  }

  /**
   * 試行的退所サービス費を取得します。
   * @return 試行的退所サービス費
   */
  public ACValueArrayRadioButtonGroup getTrialHijoRadio(){
    if(trialHijoRadio==null){

      trialHijoRadio = new ACValueArrayRadioButtonGroup();

      getTrialHijoRadioContainer().setText("試行的退所サービス費");

      trialHijoRadio.setBindPath("1550115");

      trialHijoRadio.setUseClearButton(false);

      trialHijoRadio.setModel(getTrialHijoRadioModel());

      trialHijoRadio.setValues(new int[]{1,2});

      addTrialHijoRadio();
    }
    return trialHijoRadio;

  }

  /**
   * 試行的退所サービス費コンテナを取得します。
   * @return 試行的退所サービス費コンテナ
   */
  protected ACLabelContainer getTrialHijoRadioContainer(){
    if(trialHijoRadioContainer==null){
      trialHijoRadioContainer = new ACLabelContainer();
      trialHijoRadioContainer.setFollowChildEnabled(true);
      trialHijoRadioContainer.setVAlignment(VRLayout.CENTER);
      trialHijoRadioContainer.add(getTrialHijoRadio(), null);
    }
    return trialHijoRadioContainer;
  }

  /**
   * 試行的退所サービス費モデルを取得します。
   * @return 試行的退所サービス費モデル
   */
  protected ACListModelAdapter getTrialHijoRadioModel(){
    if(trialHijoRadioModel==null){
      trialHijoRadioModel = new ACListModelAdapter();
      addTrialHijoRadioModel();
    }
    return trialHijoRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTrialHijoRadioItem1(){
    if(trialHijoRadioItem1==null){

      trialHijoRadioItem1 = new ACRadioButtonItem();

      trialHijoRadioItem1.setText("なし");

      trialHijoRadioItem1.setGroup(getTrialHijoRadio());

      trialHijoRadioItem1.setConstraints(VRLayout.FLOW);

      addTrialHijoRadioItem1();
    }
    return trialHijoRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getTrialHijoRadioItem2(){
    if(trialHijoRadioItem2==null){

      trialHijoRadioItem2 = new ACRadioButtonItem();

      trialHijoRadioItem2.setText("あり");

      trialHijoRadioItem2.setGroup(getTrialHijoRadio());

      trialHijoRadioItem2.setConstraints(VRLayout.FLOW);

      addTrialHijoRadioItem2();
    }
    return trialHijoRadioItem2;

  }

  /**
   * 他科受診時費用を取得します。
   * @return 他科受診時費用
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityHospitalMedicalExaminationRadio(){
    if(medicalFacilityHospitalMedicalExaminationRadio==null){

      medicalFacilityHospitalMedicalExaminationRadio = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityHospitalMedicalExaminationRadioContainer().setText("他科受診時費用");

      medicalFacilityHospitalMedicalExaminationRadio.setBindPath("1550116");

      medicalFacilityHospitalMedicalExaminationRadio.setUseClearButton(false);

      medicalFacilityHospitalMedicalExaminationRadio.setModel(getMedicalFacilityHospitalMedicalExaminationRadioModel());

      medicalFacilityHospitalMedicalExaminationRadio.setValues(new int[]{1,2});

      addMedicalFacilityHospitalMedicalExaminationRadio();
    }
    return medicalFacilityHospitalMedicalExaminationRadio;

  }

  /**
   * 他科受診時費用コンテナを取得します。
   * @return 他科受診時費用コンテナ
   */
  protected ACLabelContainer getMedicalFacilityHospitalMedicalExaminationRadioContainer(){
    if(medicalFacilityHospitalMedicalExaminationRadioContainer==null){
      medicalFacilityHospitalMedicalExaminationRadioContainer = new ACLabelContainer();
      medicalFacilityHospitalMedicalExaminationRadioContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalMedicalExaminationRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalMedicalExaminationRadioContainer.add(getMedicalFacilityHospitalMedicalExaminationRadio(), null);
    }
    return medicalFacilityHospitalMedicalExaminationRadioContainer;
  }

  /**
   * 他科受診時費用モデルを取得します。
   * @return 他科受診時費用モデル
   */
  protected ACListModelAdapter getMedicalFacilityHospitalMedicalExaminationRadioModel(){
    if(medicalFacilityHospitalMedicalExaminationRadioModel==null){
      medicalFacilityHospitalMedicalExaminationRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalMedicalExaminationRadioModel();
    }
    return medicalFacilityHospitalMedicalExaminationRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalFacilityHospitalMedicalExaminationRadioItem1(){
    if(medicalFacilityHospitalMedicalExaminationRadioItem1==null){

      medicalFacilityHospitalMedicalExaminationRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalMedicalExaminationRadioItem1.setText("なし");

      medicalFacilityHospitalMedicalExaminationRadioItem1.setGroup(getMedicalFacilityHospitalMedicalExaminationRadio());

      medicalFacilityHospitalMedicalExaminationRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalMedicalExaminationRadioItem1();
    }
    return medicalFacilityHospitalMedicalExaminationRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMedicalFacilityHospitalMedicalExaminationRadioItem2(){
    if(medicalFacilityHospitalMedicalExaminationRadioItem2==null){

      medicalFacilityHospitalMedicalExaminationRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalMedicalExaminationRadioItem2.setText("あり");

      medicalFacilityHospitalMedicalExaminationRadioItem2.setGroup(getMedicalFacilityHospitalMedicalExaminationRadio());

      medicalFacilityHospitalMedicalExaminationRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalMedicalExaminationRadioItem2();
    }
    return medicalFacilityHospitalMedicalExaminationRadioItem2;

  }

  /**
   * 初期加算を取得します。
   * @return 初期加算
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityHospitalStandardRadio(){
    if(medicalFacilityHospitalStandardRadio==null){

      medicalFacilityHospitalStandardRadio = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityHospitalStandardRadioContainer().setText("初期加算");

      medicalFacilityHospitalStandardRadio.setBindPath("1550117");

      medicalFacilityHospitalStandardRadio.setUseClearButton(false);

      medicalFacilityHospitalStandardRadio.setModel(getMedicalFacilityHospitalStandardRadioModel());

      medicalFacilityHospitalStandardRadio.setValues(new int[]{1,2});

      addMedicalFacilityHospitalStandardRadio();
    }
    return medicalFacilityHospitalStandardRadio;

  }

  /**
   * 初期加算コンテナを取得します。
   * @return 初期加算コンテナ
   */
  protected ACLabelContainer getMedicalFacilityHospitalStandardRadioContainer(){
    if(medicalFacilityHospitalStandardRadioContainer==null){
      medicalFacilityHospitalStandardRadioContainer = new ACLabelContainer();
      medicalFacilityHospitalStandardRadioContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalStandardRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalStandardRadioContainer.add(getMedicalFacilityHospitalStandardRadio(), null);
    }
    return medicalFacilityHospitalStandardRadioContainer;
  }

  /**
   * 初期加算モデルを取得します。
   * @return 初期加算モデル
   */
  protected ACListModelAdapter getMedicalFacilityHospitalStandardRadioModel(){
    if(medicalFacilityHospitalStandardRadioModel==null){
      medicalFacilityHospitalStandardRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalStandardRadioModel();
    }
    return medicalFacilityHospitalStandardRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalFacilityHospitalStandardRadioItem1(){
    if(medicalFacilityHospitalStandardRadioItem1==null){

      medicalFacilityHospitalStandardRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalStandardRadioItem1.setText("なし");

      medicalFacilityHospitalStandardRadioItem1.setGroup(getMedicalFacilityHospitalStandardRadio());

      medicalFacilityHospitalStandardRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalStandardRadioItem1();
    }
    return medicalFacilityHospitalStandardRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMedicalFacilityHospitalStandardRadioItem2(){
    if(medicalFacilityHospitalStandardRadioItem2==null){

      medicalFacilityHospitalStandardRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalStandardRadioItem2.setText("あり");

      medicalFacilityHospitalStandardRadioItem2.setGroup(getMedicalFacilityHospitalStandardRadio());

      medicalFacilityHospitalStandardRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalStandardRadioItem2();
    }
    return medicalFacilityHospitalStandardRadioItem2;

  }

  /**
   * 再入所時栄養連携加算を取得します。
   * @return 再入所時栄養連携加算
   */
  public ACValueArrayRadioButtonGroup getReEntryNutritionCooperationAdd(){
    if(reEntryNutritionCooperationAdd==null){

      reEntryNutritionCooperationAdd = new ACValueArrayRadioButtonGroup();

      getReEntryNutritionCooperationAddContainer().setText("再入所時栄養連携加算");

      reEntryNutritionCooperationAdd.setBindPath("1550118");

      reEntryNutritionCooperationAdd.setUseClearButton(false);

      reEntryNutritionCooperationAdd.setModel(getReEntryNutritionCooperationAddModel());

      reEntryNutritionCooperationAdd.setValues(new int[]{1,2});

      addReEntryNutritionCooperationAdd();
    }
    return reEntryNutritionCooperationAdd;

  }

  /**
   * 再入所時栄養連携加算コンテナを取得します。
   * @return 再入所時栄養連携加算コンテナ
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
   * 再入所時栄養連携加算モデルを取得します。
   * @return 再入所時栄養連携加算モデル
   */
  protected ACListModelAdapter getReEntryNutritionCooperationAddModel(){
    if(reEntryNutritionCooperationAddModel==null){
      reEntryNutritionCooperationAddModel = new ACListModelAdapter();
      addReEntryNutritionCooperationAddModel();
    }
    return reEntryNutritionCooperationAddModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getReEntryNutritionCooperationAddItem1(){
    if(reEntryNutritionCooperationAddItem1==null){

      reEntryNutritionCooperationAddItem1 = new ACRadioButtonItem();

      reEntryNutritionCooperationAddItem1.setText("なし");

      reEntryNutritionCooperationAddItem1.setGroup(getReEntryNutritionCooperationAdd());

      reEntryNutritionCooperationAddItem1.setConstraints(VRLayout.FLOW);

      addReEntryNutritionCooperationAddItem1();
    }
    return reEntryNutritionCooperationAddItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getReEntryNutritionCooperationAddItem2(){
    if(reEntryNutritionCooperationAddItem2==null){

      reEntryNutritionCooperationAddItem2 = new ACRadioButtonItem();

      reEntryNutritionCooperationAddItem2.setText("あり");

      reEntryNutritionCooperationAddItem2.setGroup(getReEntryNutritionCooperationAdd());

      reEntryNutritionCooperationAddItem2.setConstraints(VRLayout.FLOW);

      addReEntryNutritionCooperationAddItem2();
    }
    return reEntryNutritionCooperationAddItem2;

  }

  /**
   * 栄養マネジメント加算を取得します。
   * @return 栄養マネジメント加算
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityHospitalNutritionRadio(){
    if(medicalFacilityHospitalNutritionRadio==null){

      medicalFacilityHospitalNutritionRadio = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityHospitalNutritionRadioContainer().setText("栄養マネジメント加算");

      medicalFacilityHospitalNutritionRadio.setBindPath("1550119");

      medicalFacilityHospitalNutritionRadio.setUseClearButton(false);

      medicalFacilityHospitalNutritionRadio.setModel(getMedicalFacilityHospitalNutritionRadioModel());

      medicalFacilityHospitalNutritionRadio.setValues(new int[]{1,2});

      addMedicalFacilityHospitalNutritionRadio();
    }
    return medicalFacilityHospitalNutritionRadio;

  }

  /**
   * 栄養マネジメント加算コンテナを取得します。
   * @return 栄養マネジメント加算コンテナ
   */
  protected ACLabelContainer getMedicalFacilityHospitalNutritionRadioContainer(){
    if(medicalFacilityHospitalNutritionRadioContainer==null){
      medicalFacilityHospitalNutritionRadioContainer = new ACLabelContainer();
      medicalFacilityHospitalNutritionRadioContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalNutritionRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalNutritionRadioContainer.add(getMedicalFacilityHospitalNutritionRadio(), null);
    }
    return medicalFacilityHospitalNutritionRadioContainer;
  }

  /**
   * 栄養マネジメント加算モデルを取得します。
   * @return 栄養マネジメント加算モデル
   */
  protected ACListModelAdapter getMedicalFacilityHospitalNutritionRadioModel(){
    if(medicalFacilityHospitalNutritionRadioModel==null){
      medicalFacilityHospitalNutritionRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalNutritionRadioModel();
    }
    return medicalFacilityHospitalNutritionRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalFacilityHospitalNutritionRadioItem1(){
    if(medicalFacilityHospitalNutritionRadioItem1==null){

      medicalFacilityHospitalNutritionRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalNutritionRadioItem1.setText("なし");

      medicalFacilityHospitalNutritionRadioItem1.setGroup(getMedicalFacilityHospitalNutritionRadio());

      medicalFacilityHospitalNutritionRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalNutritionRadioItem1();
    }
    return medicalFacilityHospitalNutritionRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMedicalFacilityHospitalNutritionRadioItem2(){
    if(medicalFacilityHospitalNutritionRadioItem2==null){

      medicalFacilityHospitalNutritionRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalNutritionRadioItem2.setText("あり");

      medicalFacilityHospitalNutritionRadioItem2.setGroup(getMedicalFacilityHospitalNutritionRadio());

      medicalFacilityHospitalNutritionRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalNutritionRadioItem2();
    }
    return medicalFacilityHospitalNutritionRadioItem2;

  }

  /**
   * 低栄養リスク改善加算を取得します。
   * @return 低栄養リスク改善加算
   */
  public ACValueArrayRadioButtonGroup getLowNutritionalRiskImprovementAdd(){
    if(lowNutritionalRiskImprovementAdd==null){

      lowNutritionalRiskImprovementAdd = new ACValueArrayRadioButtonGroup();

      getLowNutritionalRiskImprovementAddContainer().setText("低栄養リスク改善加算");

      lowNutritionalRiskImprovementAdd.setBindPath("1550120");

      lowNutritionalRiskImprovementAdd.setUseClearButton(false);

      lowNutritionalRiskImprovementAdd.setModel(getLowNutritionalRiskImprovementAddModel());

      lowNutritionalRiskImprovementAdd.setValues(new int[]{1,2});

      addLowNutritionalRiskImprovementAdd();
    }
    return lowNutritionalRiskImprovementAdd;

  }

  /**
   * 低栄養リスク改善加算コンテナを取得します。
   * @return 低栄養リスク改善加算コンテナ
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
   * 低栄養リスク改善加算モデルを取得します。
   * @return 低栄養リスク改善加算モデル
   */
  protected ACListModelAdapter getLowNutritionalRiskImprovementAddModel(){
    if(lowNutritionalRiskImprovementAddModel==null){
      lowNutritionalRiskImprovementAddModel = new ACListModelAdapter();
      addLowNutritionalRiskImprovementAddModel();
    }
    return lowNutritionalRiskImprovementAddModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getLowNutritionalRiskImprovementAddItem1(){
    if(lowNutritionalRiskImprovementAddItem1==null){

      lowNutritionalRiskImprovementAddItem1 = new ACRadioButtonItem();

      lowNutritionalRiskImprovementAddItem1.setText("なし");

      lowNutritionalRiskImprovementAddItem1.setGroup(getLowNutritionalRiskImprovementAdd());

      lowNutritionalRiskImprovementAddItem1.setConstraints(VRLayout.FLOW);

      addLowNutritionalRiskImprovementAddItem1();
    }
    return lowNutritionalRiskImprovementAddItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getLowNutritionalRiskImprovementAddItem2(){
    if(lowNutritionalRiskImprovementAddItem2==null){

      lowNutritionalRiskImprovementAddItem2 = new ACRadioButtonItem();

      lowNutritionalRiskImprovementAddItem2.setText("あり");

      lowNutritionalRiskImprovementAddItem2.setGroup(getLowNutritionalRiskImprovementAdd());

      lowNutritionalRiskImprovementAddItem2.setConstraints(VRLayout.FLOW);

      addLowNutritionalRiskImprovementAddItem2();
    }
    return lowNutritionalRiskImprovementAddItem2;

  }

  /**
   * 経口移行加算を取得します。
   * @return 経口移行加算
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityHospitalOralSwitchRadio(){
    if(medicalFacilityHospitalOralSwitchRadio==null){

      medicalFacilityHospitalOralSwitchRadio = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityHospitalOralSwitchRadioContainer().setText("経口移行加算");

      medicalFacilityHospitalOralSwitchRadio.setBindPath("1550121");

      medicalFacilityHospitalOralSwitchRadio.setUseClearButton(false);

      medicalFacilityHospitalOralSwitchRadio.setModel(getMedicalFacilityHospitalOralSwitchRadioModel());

      medicalFacilityHospitalOralSwitchRadio.setValues(new int[]{1,2});

      addMedicalFacilityHospitalOralSwitchRadio();
    }
    return medicalFacilityHospitalOralSwitchRadio;

  }

  /**
   * 経口移行加算コンテナを取得します。
   * @return 経口移行加算コンテナ
   */
  protected ACLabelContainer getMedicalFacilityHospitalOralSwitchRadioContainer(){
    if(medicalFacilityHospitalOralSwitchRadioContainer==null){
      medicalFacilityHospitalOralSwitchRadioContainer = new ACLabelContainer();
      medicalFacilityHospitalOralSwitchRadioContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalOralSwitchRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalOralSwitchRadioContainer.add(getMedicalFacilityHospitalOralSwitchRadio(), null);
    }
    return medicalFacilityHospitalOralSwitchRadioContainer;
  }

  /**
   * 経口移行加算モデルを取得します。
   * @return 経口移行加算モデル
   */
  protected ACListModelAdapter getMedicalFacilityHospitalOralSwitchRadioModel(){
    if(medicalFacilityHospitalOralSwitchRadioModel==null){
      medicalFacilityHospitalOralSwitchRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalOralSwitchRadioModel();
    }
    return medicalFacilityHospitalOralSwitchRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalFacilityHospitalOralSwitchRadioItem1(){
    if(medicalFacilityHospitalOralSwitchRadioItem1==null){

      medicalFacilityHospitalOralSwitchRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalOralSwitchRadioItem1.setText("なし");

      medicalFacilityHospitalOralSwitchRadioItem1.setGroup(getMedicalFacilityHospitalOralSwitchRadio());

      medicalFacilityHospitalOralSwitchRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalOralSwitchRadioItem1();
    }
    return medicalFacilityHospitalOralSwitchRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMedicalFacilityHospitalOralSwitchRadioItem2(){
    if(medicalFacilityHospitalOralSwitchRadioItem2==null){

      medicalFacilityHospitalOralSwitchRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalOralSwitchRadioItem2.setText("あり");

      medicalFacilityHospitalOralSwitchRadioItem2.setGroup(getMedicalFacilityHospitalOralSwitchRadio());

      medicalFacilityHospitalOralSwitchRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalOralSwitchRadioItem2();
    }
    return medicalFacilityHospitalOralSwitchRadioItem2;

  }

  /**
   * 経口維持加算コンテナを取得します。
   * @return 経口維持加算コンテナ
   */
  public ACLabelContainer getOralMaintenanceAddContainer(){
    if(oralMaintenanceAddContainer==null){

      oralMaintenanceAddContainer = new ACLabelContainer();

      oralMaintenanceAddContainer.setText("経口維持加算");

      oralMaintenanceAddContainer.setFollowChildEnabled(true);

      addOralMaintenanceAddContainer();
    }
    return oralMaintenanceAddContainer;

  }

  /**
   * 経口維持加算を取得します。
   * @return 経口維持加算
   */
  public ACValueArrayRadioButtonGroup getOralMaintenanceAdd(){
    if(oralMaintenanceAdd==null){

      oralMaintenanceAdd = new ACValueArrayRadioButtonGroup();

      oralMaintenanceAdd.setBindPath("1550122");

      oralMaintenanceAdd.setUseClearButton(false);

      oralMaintenanceAdd.setModel(getOralMaintenanceAddModel());

      oralMaintenanceAdd.setValues(new int[]{1,2});

      addOralMaintenanceAdd();
    }
    return oralMaintenanceAdd;

  }

  /**
   * 経口維持加算モデルを取得します。
   * @return 経口維持加算モデル
   */
  protected ACListModelAdapter getOralMaintenanceAddModel(){
    if(oralMaintenanceAddModel==null){
      oralMaintenanceAddModel = new ACListModelAdapter();
      addOralMaintenanceAddModel();
    }
    return oralMaintenanceAddModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getOralMaintenanceAddItem1(){
    if(oralMaintenanceAddItem1==null){

      oralMaintenanceAddItem1 = new ACRadioButtonItem();

      oralMaintenanceAddItem1.setText("なし");

      oralMaintenanceAddItem1.setGroup(getOralMaintenanceAdd());

      oralMaintenanceAddItem1.setConstraints(VRLayout.FLOW);

      addOralMaintenanceAddItem1();
    }
    return oralMaintenanceAddItem1;

  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getOralMaintenanceAddItem2(){
    if(oralMaintenanceAddItem2==null){

      oralMaintenanceAddItem2 = new ACRadioButtonItem();

      oralMaintenanceAddItem2.setText("I型");

      oralMaintenanceAddItem2.setGroup(getOralMaintenanceAdd());

      oralMaintenanceAddItem2.setConstraints(VRLayout.FLOW);

      addOralMaintenanceAddItem2();
    }
    return oralMaintenanceAddItem2;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACIntegerCheckBox getOralMaintenanceAddItem3(){
    if(oralMaintenanceAddItem3==null){

      oralMaintenanceAddItem3 = new ACIntegerCheckBox();

      oralMaintenanceAddItem3.setText("II型");

      oralMaintenanceAddItem3.setBindPath("1550123");

      oralMaintenanceAddItem3.setSelectValue(2);

      oralMaintenanceAddItem3.setUnSelectValue(1);

      addOralMaintenanceAddItem3();
    }
    return oralMaintenanceAddItem3;

  }

  /**
   * タブ4を取得します。
   * @return タブ4
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
   * 口腔衛生管理体制加算を取得します。
   * @return 口腔衛生管理体制加算
   */
  public ACValueArrayRadioButtonGroup getOralKeepStructureAddRadioGroup(){
    if(oralKeepStructureAddRadioGroup==null){

      oralKeepStructureAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getOralKeepStructureAddRadioGroupContainer().setText("口腔衛生管理体制加算");

      oralKeepStructureAddRadioGroup.setBindPath("1550124");

      oralKeepStructureAddRadioGroup.setNoSelectIndex(0);

      oralKeepStructureAddRadioGroup.setUseClearButton(false);

      oralKeepStructureAddRadioGroup.setModel(getOralKeepStructureAddRadioGroupModel());

      oralKeepStructureAddRadioGroup.setValues(new int[]{1,2});

      addOralKeepStructureAddRadioGroup();
    }
    return oralKeepStructureAddRadioGroup;

  }

  /**
   * 口腔衛生管理体制加算コンテナを取得します。
   * @return 口腔衛生管理体制加算コンテナ
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
   * 口腔衛生管理体制加算モデルを取得します。
   * @return 口腔衛生管理体制加算モデル
   */
  protected ACListModelAdapter getOralKeepStructureAddRadioGroupModel(){
    if(oralKeepStructureAddRadioGroupModel==null){
      oralKeepStructureAddRadioGroupModel = new ACListModelAdapter();
      addOralKeepStructureAddRadioGroupModel();
    }
    return oralKeepStructureAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getOralKeepStructureAddRadioItem1(){
    if(oralKeepStructureAddRadioItem1==null){

      oralKeepStructureAddRadioItem1 = new ACRadioButtonItem();

      oralKeepStructureAddRadioItem1.setText("なし");

      oralKeepStructureAddRadioItem1.setGroup(getOralKeepStructureAddRadioGroup());

      oralKeepStructureAddRadioItem1.setConstraints(VRLayout.FLOW);

      addOralKeepStructureAddRadioItem1();
    }
    return oralKeepStructureAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getOralKeepStructureAddRadioItem2(){
    if(oralKeepStructureAddRadioItem2==null){

      oralKeepStructureAddRadioItem2 = new ACRadioButtonItem();

      oralKeepStructureAddRadioItem2.setText("あり");

      oralKeepStructureAddRadioItem2.setGroup(getOralKeepStructureAddRadioGroup());

      oralKeepStructureAddRadioItem2.setConstraints(VRLayout.FLOW);

      addOralKeepStructureAddRadioItem2();
    }
    return oralKeepStructureAddRadioItem2;

  }

  /**
   * 口腔衛生管理加算を取得します。
   * @return 口腔衛生管理加算
   */
  public ACValueArrayRadioButtonGroup getOralKeepAddRadioGroup(){
    if(oralKeepAddRadioGroup==null){

      oralKeepAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getOralKeepAddRadioGroupContainer().setText("口腔衛生管理加算");

      oralKeepAddRadioGroup.setBindPath("1550125");

      oralKeepAddRadioGroup.setNoSelectIndex(0);

      oralKeepAddRadioGroup.setUseClearButton(false);

      oralKeepAddRadioGroup.setModel(getOralKeepAddRadioGroupModel());

      oralKeepAddRadioGroup.setValues(new int[]{1,2});

      addOralKeepAddRadioGroup();
    }
    return oralKeepAddRadioGroup;

  }

  /**
   * 口腔衛生管理加算コンテナを取得します。
   * @return 口腔衛生管理加算コンテナ
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
   * 口腔衛生管理加算モデルを取得します。
   * @return 口腔衛生管理加算モデル
   */
  protected ACListModelAdapter getOralKeepAddRadioGroupModel(){
    if(oralKeepAddRadioGroupModel==null){
      oralKeepAddRadioGroupModel = new ACListModelAdapter();
      addOralKeepAddRadioGroupModel();
    }
    return oralKeepAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getOralKeepAddRadioItem1(){
    if(oralKeepAddRadioItem1==null){

      oralKeepAddRadioItem1 = new ACRadioButtonItem();

      oralKeepAddRadioItem1.setText("なし");

      oralKeepAddRadioItem1.setGroup(getOralKeepAddRadioGroup());

      oralKeepAddRadioItem1.setConstraints(VRLayout.FLOW);

      addOralKeepAddRadioItem1();
    }
    return oralKeepAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getOralKeepAddRadioItem2(){
    if(oralKeepAddRadioItem2==null){

      oralKeepAddRadioItem2 = new ACRadioButtonItem();

      oralKeepAddRadioItem2.setText("あり");

      oralKeepAddRadioItem2.setGroup(getOralKeepAddRadioGroup());

      oralKeepAddRadioItem2.setConstraints(VRLayout.FLOW);

      addOralKeepAddRadioItem2();
    }
    return oralKeepAddRadioItem2;

  }

  /**
   * 療養食加算を取得します。
   * @return 療養食加算
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityHospitalRecuperateDinnerRadio(){
    if(medicalFacilityHospitalRecuperateDinnerRadio==null){

      medicalFacilityHospitalRecuperateDinnerRadio = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityHospitalRecuperateDinnerRadioContainer().setText("療養食加算");

      medicalFacilityHospitalRecuperateDinnerRadio.setBindPath("1550126");

      medicalFacilityHospitalRecuperateDinnerRadio.setUseClearButton(false);

      medicalFacilityHospitalRecuperateDinnerRadio.setModel(getMedicalFacilityHospitalRecuperateDinnerRadioModel());

      medicalFacilityHospitalRecuperateDinnerRadio.setValues(new int[]{1,2,3,4});

      addMedicalFacilityHospitalRecuperateDinnerRadio();
    }
    return medicalFacilityHospitalRecuperateDinnerRadio;

  }

  /**
   * 療養食加算コンテナを取得します。
   * @return 療養食加算コンテナ
   */
  protected ACLabelContainer getMedicalFacilityHospitalRecuperateDinnerRadioContainer(){
    if(medicalFacilityHospitalRecuperateDinnerRadioContainer==null){
      medicalFacilityHospitalRecuperateDinnerRadioContainer = new ACLabelContainer();
      medicalFacilityHospitalRecuperateDinnerRadioContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalRecuperateDinnerRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalRecuperateDinnerRadioContainer.add(getMedicalFacilityHospitalRecuperateDinnerRadio(), null);
    }
    return medicalFacilityHospitalRecuperateDinnerRadioContainer;
  }

  /**
   * 療養食加算モデルを取得します。
   * @return 療養食加算モデル
   */
  protected ACListModelAdapter getMedicalFacilityHospitalRecuperateDinnerRadioModel(){
    if(medicalFacilityHospitalRecuperateDinnerRadioModel==null){
      medicalFacilityHospitalRecuperateDinnerRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalRecuperateDinnerRadioModel();
    }
    return medicalFacilityHospitalRecuperateDinnerRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalFacilityHospitalRecuperateDinnerRadioItem1(){
    if(medicalFacilityHospitalRecuperateDinnerRadioItem1==null){

      medicalFacilityHospitalRecuperateDinnerRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalRecuperateDinnerRadioItem1.setText("なし");

      medicalFacilityHospitalRecuperateDinnerRadioItem1.setGroup(getMedicalFacilityHospitalRecuperateDinnerRadio());

      medicalFacilityHospitalRecuperateDinnerRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalRecuperateDinnerRadioItem1();
    }
    return medicalFacilityHospitalRecuperateDinnerRadioItem1;

  }

  /**
   * 3回を取得します。
   * @return 3回
   */
  public ACRadioButtonItem getMedicalFacilityHospitalRecuperateDinnerRadioItem2(){
    if(medicalFacilityHospitalRecuperateDinnerRadioItem2==null){

      medicalFacilityHospitalRecuperateDinnerRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalRecuperateDinnerRadioItem2.setText("3回");

      medicalFacilityHospitalRecuperateDinnerRadioItem2.setGroup(getMedicalFacilityHospitalRecuperateDinnerRadio());

      medicalFacilityHospitalRecuperateDinnerRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalRecuperateDinnerRadioItem2();
    }
    return medicalFacilityHospitalRecuperateDinnerRadioItem2;

  }

  /**
   * 2回を取得します。
   * @return 2回
   */
  public ACRadioButtonItem getMedicalFacilityHospitalRecuperateDinnerRadioItem3(){
    if(medicalFacilityHospitalRecuperateDinnerRadioItem3==null){

      medicalFacilityHospitalRecuperateDinnerRadioItem3 = new ACRadioButtonItem();

      medicalFacilityHospitalRecuperateDinnerRadioItem3.setText("2回");

      medicalFacilityHospitalRecuperateDinnerRadioItem3.setGroup(getMedicalFacilityHospitalRecuperateDinnerRadio());

      medicalFacilityHospitalRecuperateDinnerRadioItem3.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalRecuperateDinnerRadioItem3();
    }
    return medicalFacilityHospitalRecuperateDinnerRadioItem3;

  }

  /**
   * 1回を取得します。
   * @return 1回
   */
  public ACRadioButtonItem getMedicalFacilityHospitalRecuperateDinnerRadioItem4(){
    if(medicalFacilityHospitalRecuperateDinnerRadioItem4==null){

      medicalFacilityHospitalRecuperateDinnerRadioItem4 = new ACRadioButtonItem();

      medicalFacilityHospitalRecuperateDinnerRadioItem4.setText("1回");

      medicalFacilityHospitalRecuperateDinnerRadioItem4.setGroup(getMedicalFacilityHospitalRecuperateDinnerRadio());

      medicalFacilityHospitalRecuperateDinnerRadioItem4.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalRecuperateDinnerRadioItem4();
    }
    return medicalFacilityHospitalRecuperateDinnerRadioItem4;

  }

  /**
   * 在宅復帰支援機能加算を取得します。
   * @return 在宅復帰支援機能加算
   */
  public ACValueArrayRadioButtonGroup getStayReturnSupportAddRadio(){
    if(stayReturnSupportAddRadio==null){

      stayReturnSupportAddRadio = new ACValueArrayRadioButtonGroup();

      getStayReturnSupportAddRadioContainer().setText("在宅復帰支援機能加算");

      stayReturnSupportAddRadio.setBindPath("1550127");

      stayReturnSupportAddRadio.setUseClearButton(false);

      stayReturnSupportAddRadio.setModel(getStayReturnSupportAddRadioModel());

      stayReturnSupportAddRadio.setValues(new int[]{1,2});

      addStayReturnSupportAddRadio();
    }
    return stayReturnSupportAddRadio;

  }

  /**
   * 在宅復帰支援機能加算コンテナを取得します。
   * @return 在宅復帰支援機能加算コンテナ
   */
  protected ACLabelContainer getStayReturnSupportAddRadioContainer(){
    if(stayReturnSupportAddRadioContainer==null){
      stayReturnSupportAddRadioContainer = new ACLabelContainer();
      stayReturnSupportAddRadioContainer.setFollowChildEnabled(true);
      stayReturnSupportAddRadioContainer.setVAlignment(VRLayout.CENTER);
      stayReturnSupportAddRadioContainer.add(getStayReturnSupportAddRadio(), null);
    }
    return stayReturnSupportAddRadioContainer;
  }

  /**
   * 在宅復帰支援機能加算モデルを取得します。
   * @return 在宅復帰支援機能加算モデル
   */
  protected ACListModelAdapter getStayReturnSupportAddRadioModel(){
    if(stayReturnSupportAddRadioModel==null){
      stayReturnSupportAddRadioModel = new ACListModelAdapter();
      addStayReturnSupportAddRadioModel();
    }
    return stayReturnSupportAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getStayReturnSupportAddRadioItem1(){
    if(stayReturnSupportAddRadioItem1==null){

      stayReturnSupportAddRadioItem1 = new ACRadioButtonItem();

      stayReturnSupportAddRadioItem1.setText("なし");

      stayReturnSupportAddRadioItem1.setGroup(getStayReturnSupportAddRadio());

      stayReturnSupportAddRadioItem1.setConstraints(VRLayout.FLOW);

      addStayReturnSupportAddRadioItem1();
    }
    return stayReturnSupportAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getStayReturnSupportAddRadioItem2(){
    if(stayReturnSupportAddRadioItem2==null){

      stayReturnSupportAddRadioItem2 = new ACRadioButtonItem();

      stayReturnSupportAddRadioItem2.setText("あり");

      stayReturnSupportAddRadioItem2.setGroup(getStayReturnSupportAddRadio());

      stayReturnSupportAddRadioItem2.setConstraints(VRLayout.FLOW);

      addStayReturnSupportAddRadioItem2();
    }
    return stayReturnSupportAddRadioItem2;

  }

  /**
   * 退所関連加算を取得します。
   * @return 退所関連加算
   */
  public ACLabelContainer getMedicalFacilityHospitalHijoAddition(){
    if(medicalFacilityHospitalHijoAddition==null){

      medicalFacilityHospitalHijoAddition = new ACLabelContainer();

      medicalFacilityHospitalHijoAddition.setText("退所関連加算");

      medicalFacilityHospitalHijoAddition.setFollowChildEnabled(true);

      addMedicalFacilityHospitalHijoAddition();
    }
    return medicalFacilityHospitalHijoAddition;

  }

  /**
   * 退所(院)前訪問指導加算を取得します。
   * @return 退所(院)前訪問指導加算
   */
  public ACIntegerCheckBox getLeavingHospitalPreConsultationAddition(){
    if(leavingHospitalPreConsultationAddition==null){

      leavingHospitalPreConsultationAddition = new ACIntegerCheckBox();

      leavingHospitalPreConsultationAddition.setText("退所前訪問指導加算");

      leavingHospitalPreConsultationAddition.setBindPath("3020109");

      leavingHospitalPreConsultationAddition.setSelectValue(2);

      leavingHospitalPreConsultationAddition.setUnSelectValue(1);

      addLeavingHospitalPreConsultationAddition();
    }
    return leavingHospitalPreConsultationAddition;

  }

  /**
   * 退所(院)後訪問指導加算を取得します。
   * @return 退所(院)後訪問指導加算
   */
  public ACIntegerCheckBox getLeavingHospitalAfterConsultationAddition(){
    if(leavingHospitalAfterConsultationAddition==null){

      leavingHospitalAfterConsultationAddition = new ACIntegerCheckBox();

      leavingHospitalAfterConsultationAddition.setText("退所後訪問指導加算");

      leavingHospitalAfterConsultationAddition.setBindPath("3020110");

      leavingHospitalAfterConsultationAddition.setSelectValue(2);

      leavingHospitalAfterConsultationAddition.setUnSelectValue(1);

      addLeavingHospitalAfterConsultationAddition();
    }
    return leavingHospitalAfterConsultationAddition;

  }

  /**
   * 退所(院)時指導加算を取得します。
   * @return 退所(院)時指導加算
   */
  public ACIntegerCheckBox getLeavingHospitalConsultationAddition(){
    if(leavingHospitalConsultationAddition==null){

      leavingHospitalConsultationAddition = new ACIntegerCheckBox();

      leavingHospitalConsultationAddition.setText("退所時指導加算");

      leavingHospitalConsultationAddition.setBindPath("3020105");

      leavingHospitalConsultationAddition.setSelectValue(2);

      leavingHospitalConsultationAddition.setUnSelectValue(1);

      addLeavingHospitalConsultationAddition();
    }
    return leavingHospitalConsultationAddition;

  }

  /**
   * 退所(院)時情報提供加算を取得します。
   * @return 退所(院)時情報提供加算
   */
  public ACIntegerCheckBox getLeavingHospitalDissemination(){
    if(leavingHospitalDissemination==null){

      leavingHospitalDissemination = new ACIntegerCheckBox();

      leavingHospitalDissemination.setText("退所時情報提供加算");

      leavingHospitalDissemination.setBindPath("3020106");

      leavingHospitalDissemination.setSelectValue(2);

      leavingHospitalDissemination.setUnSelectValue(1);

      addLeavingHospitalDissemination();
    }
    return leavingHospitalDissemination;

  }

  /**
   * 退所(院)前連携加算を取得します。
   * @return 退所(院)前連携加算
   */
  public ACIntegerCheckBox getLeavingHospitalCooperationAddition(){
    if(leavingHospitalCooperationAddition==null){

      leavingHospitalCooperationAddition = new ACIntegerCheckBox();

      leavingHospitalCooperationAddition.setText("退所前連携加算");

      leavingHospitalCooperationAddition.setBindPath("3020107");

      leavingHospitalCooperationAddition.setSelectValue(2);

      leavingHospitalCooperationAddition.setUnSelectValue(1);

      addLeavingHospitalCooperationAddition();
    }
    return leavingHospitalCooperationAddition;

  }

  /**
   * 訪問看護指示加算を取得します。
   * @return 訪問看護指示加算
   */
  public ACIntegerCheckBox getLeavingHospital(){
    if(leavingHospital==null){

      leavingHospital = new ACIntegerCheckBox();

      leavingHospital.setText("訪問看護指示加算");

      leavingHospital.setBindPath("3020108");

      leavingHospital.setSelectValue(2);

      leavingHospital.setUnSelectValue(1);

      addLeavingHospital();
    }
    return leavingHospital;

  }

  /**
   * 特別診療費を取得します。
   * @return 特別診療費
   */
  public ACMapBindButton getMedicalFacilityHospitalConsultationFee(){
    if(medicalFacilityHospitalConsultationFee==null){

      medicalFacilityHospitalConsultationFee = new ACMapBindButton();

      medicalFacilityHospitalConsultationFee.setText("特別診療費");

      medicalFacilityHospitalConsultationFee.setToolTipText("特別診療費を設定します。");

      addMedicalFacilityHospitalConsultationFee();
    }
    return medicalFacilityHospitalConsultationFee;

  }

  /**
   * ラベルを取得します。
   * @return ラベル
   */
  public ACLabel getMedicalFacilityHospitalConsultationFeeLabel(){
    if(medicalFacilityHospitalConsultationFeeLabel==null){

      medicalFacilityHospitalConsultationFeeLabel = new ACLabel();

      medicalFacilityHospitalConsultationFeeLabel.setText("設定なし");

      medicalFacilityHospitalConsultationFeeLabel.setOpaque(true);
      medicalFacilityHospitalConsultationFeeLabel.setBackground(new Color(255,255,172));

      addMedicalFacilityHospitalConsultationFeeLabel();
    }
    return medicalFacilityHospitalConsultationFeeLabel;

  }

  /**
   * タブ5を取得します。
   * @return タブ5
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
   * 緊急時治療管理を取得します。
   * @return 緊急時治療管理
   */
  public ACValueArrayRadioButtonGroup getEmergencyTreatmentManagementRadio(){
    if(emergencyTreatmentManagementRadio==null){

      emergencyTreatmentManagementRadio = new ACValueArrayRadioButtonGroup();

      getEmergencyTreatmentManagementRadioContainer().setText("緊急時治療管理");

      emergencyTreatmentManagementRadio.setBindPath("1550129");

      emergencyTreatmentManagementRadio.setUseClearButton(false);

      emergencyTreatmentManagementRadio.setModel(getEmergencyTreatmentManagementRadioModel());

      emergencyTreatmentManagementRadio.setValues(new int[]{1,2});

      addEmergencyTreatmentManagementRadio();
    }
    return emergencyTreatmentManagementRadio;

  }

  /**
   * 緊急時治療管理コンテナを取得します。
   * @return 緊急時治療管理コンテナ
   */
  protected ACLabelContainer getEmergencyTreatmentManagementRadioContainer(){
    if(emergencyTreatmentManagementRadioContainer==null){
      emergencyTreatmentManagementRadioContainer = new ACLabelContainer();
      emergencyTreatmentManagementRadioContainer.setFollowChildEnabled(true);
      emergencyTreatmentManagementRadioContainer.setVAlignment(VRLayout.CENTER);
      emergencyTreatmentManagementRadioContainer.add(getEmergencyTreatmentManagementRadio(), null);
    }
    return emergencyTreatmentManagementRadioContainer;
  }

  /**
   * 緊急時治療管理モデルを取得します。
   * @return 緊急時治療管理モデル
   */
  protected ACListModelAdapter getEmergencyTreatmentManagementRadioModel(){
    if(emergencyTreatmentManagementRadioModel==null){
      emergencyTreatmentManagementRadioModel = new ACListModelAdapter();
      addEmergencyTreatmentManagementRadioModel();
    }
    return emergencyTreatmentManagementRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getEmergencyTreatmentManagementItem1(){
    if(emergencyTreatmentManagementItem1==null){

      emergencyTreatmentManagementItem1 = new ACRadioButtonItem();

      emergencyTreatmentManagementItem1.setText("なし");

      emergencyTreatmentManagementItem1.setGroup(getEmergencyTreatmentManagementRadio());

      emergencyTreatmentManagementItem1.setConstraints(VRLayout.FLOW);

      addEmergencyTreatmentManagementItem1();
    }
    return emergencyTreatmentManagementItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getEmergencyTreatmentManagementItem2(){
    if(emergencyTreatmentManagementItem2==null){

      emergencyTreatmentManagementItem2 = new ACRadioButtonItem();

      emergencyTreatmentManagementItem2.setText("あり");

      emergencyTreatmentManagementItem2.setGroup(getEmergencyTreatmentManagementRadio());

      emergencyTreatmentManagementItem2.setConstraints(VRLayout.FLOW);

      addEmergencyTreatmentManagementItem2();
    }
    return emergencyTreatmentManagementItem2;

  }

  /**
   * 認知症専門ケア加算を取得します。
   * @return 認知症専門ケア加算
   */
  public ACValueArrayRadioButtonGroup getDementiaProfessionalCareAddRadioGroup(){
    if(dementiaProfessionalCareAddRadioGroup==null){

      dementiaProfessionalCareAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaProfessionalCareAddRadioGroupContainer().setText("認知症専門ケア加算");

      dementiaProfessionalCareAddRadioGroup.setBindPath("1550130");

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
   * 認知症専門ケア加算コンテナを取得します。
   * @return 認知症専門ケア加算コンテナ
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
   * 認知症専門ケア加算モデルを取得します。
   * @return 認知症専門ケア加算モデル
   */
  protected ACListModelAdapter getDementiaProfessionalCareAddRadioGroupModel(){
    if(dementiaProfessionalCareAddRadioGroupModel==null){
      dementiaProfessionalCareAddRadioGroupModel = new ACListModelAdapter();
      addDementiaProfessionalCareAddRadioGroupModel();
    }
    return dementiaProfessionalCareAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getDementiaProfessionalCareAddRadioItem1(){
    if(dementiaProfessionalCareAddRadioItem1==null){

      dementiaProfessionalCareAddRadioItem1 = new ACRadioButtonItem();

      dementiaProfessionalCareAddRadioItem1.setText("なし");

      dementiaProfessionalCareAddRadioItem1.setGroup(getDementiaProfessionalCareAddRadioGroup());

      dementiaProfessionalCareAddRadioItem1.setConstraints(VRLayout.FLOW);

      addDementiaProfessionalCareAddRadioItem1();
    }
    return dementiaProfessionalCareAddRadioItem1;

  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getDementiaProfessionalCareAddRadioItem2(){
    if(dementiaProfessionalCareAddRadioItem2==null){

      dementiaProfessionalCareAddRadioItem2 = new ACRadioButtonItem();

      dementiaProfessionalCareAddRadioItem2.setText("I型");

      dementiaProfessionalCareAddRadioItem2.setGroup(getDementiaProfessionalCareAddRadioGroup());

      dementiaProfessionalCareAddRadioItem2.setConstraints(VRLayout.FLOW);

      addDementiaProfessionalCareAddRadioItem2();
    }
    return dementiaProfessionalCareAddRadioItem2;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getDementiaProfessionalCareAddRadioItem3(){
    if(dementiaProfessionalCareAddRadioItem3==null){

      dementiaProfessionalCareAddRadioItem3 = new ACRadioButtonItem();

      dementiaProfessionalCareAddRadioItem3.setText("II型");

      dementiaProfessionalCareAddRadioItem3.setGroup(getDementiaProfessionalCareAddRadioGroup());

      dementiaProfessionalCareAddRadioItem3.setConstraints(VRLayout.FLOW);

      addDementiaProfessionalCareAddRadioItem3();
    }
    return dementiaProfessionalCareAddRadioItem3;

  }

  /**
   * 認知症行動・心理症状緊急対応加算を取得します。
   * @return 認知症行動・心理症状緊急対応加算
   */
  public ACValueArrayRadioButtonGroup getDementiaEmergencyAddRadioGroup(){
    if(dementiaEmergencyAddRadioGroup==null){

      dementiaEmergencyAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaEmergencyAddRadioGroupContainer().setText("認知症行動・心理症状緊急対応加算");

      dementiaEmergencyAddRadioGroup.setBindPath("1550131");

      dementiaEmergencyAddRadioGroup.setNoSelectIndex(0);

      dementiaEmergencyAddRadioGroup.setUseClearButton(false);

      dementiaEmergencyAddRadioGroup.setModel(getDementiaEmergencyAddRadioGroupModel());

      dementiaEmergencyAddRadioGroup.setValues(new int[]{1,2});

      addDementiaEmergencyAddRadioGroup();
    }
    return dementiaEmergencyAddRadioGroup;

  }

  /**
   * 認知症行動・心理症状緊急対応加算コンテナを取得します。
   * @return 認知症行動・心理症状緊急対応加算コンテナ
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
   * 認知症行動・心理症状緊急対応加算モデルを取得します。
   * @return 認知症行動・心理症状緊急対応加算モデル
   */
  protected ACListModelAdapter getDementiaEmergencyAddRadioGroupModel(){
    if(dementiaEmergencyAddRadioGroupModel==null){
      dementiaEmergencyAddRadioGroupModel = new ACListModelAdapter();
      addDementiaEmergencyAddRadioGroupModel();
    }
    return dementiaEmergencyAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getDementiaEmergencyAddRadioItem1(){
    if(dementiaEmergencyAddRadioItem1==null){

      dementiaEmergencyAddRadioItem1 = new ACRadioButtonItem();

      dementiaEmergencyAddRadioItem1.setText("なし");

      dementiaEmergencyAddRadioItem1.setGroup(getDementiaEmergencyAddRadioGroup());

      dementiaEmergencyAddRadioItem1.setConstraints(VRLayout.FLOW);

      addDementiaEmergencyAddRadioItem1();
    }
    return dementiaEmergencyAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getDementiaEmergencyAddRadioItem2(){
    if(dementiaEmergencyAddRadioItem2==null){

      dementiaEmergencyAddRadioItem2 = new ACRadioButtonItem();

      dementiaEmergencyAddRadioItem2.setText("あり");

      dementiaEmergencyAddRadioItem2.setGroup(getDementiaEmergencyAddRadioGroup());

      dementiaEmergencyAddRadioItem2.setConstraints(VRLayout.FLOW);

      addDementiaEmergencyAddRadioItem2();
    }
    return dementiaEmergencyAddRadioItem2;

  }

  /**
   * 重度認知症疾患療養体制加算を取得します。
   * @return 重度認知症疾患療養体制加算
   */
  public ACValueArrayRadioButtonGroup getTreatmentSystemForSevereDementiaDiseaseRadioGroup(){
    if(treatmentSystemForSevereDementiaDiseaseRadioGroup==null){

      treatmentSystemForSevereDementiaDiseaseRadioGroup = new ACValueArrayRadioButtonGroup();

      getTreatmentSystemForSevereDementiaDiseaseRadioGroupContainer().setText("重度認知症疾患療養体制加算");

      treatmentSystemForSevereDementiaDiseaseRadioGroup.setBindPath("1550132");

      treatmentSystemForSevereDementiaDiseaseRadioGroup.setVisible(true);

      treatmentSystemForSevereDementiaDiseaseRadioGroup.setEnabled(true);

      treatmentSystemForSevereDementiaDiseaseRadioGroup.setNoSelectIndex(0);

      treatmentSystemForSevereDementiaDiseaseRadioGroup.setUseClearButton(false);

      treatmentSystemForSevereDementiaDiseaseRadioGroup.setModel(getTreatmentSystemForSevereDementiaDiseaseRadioGroupModel());

      treatmentSystemForSevereDementiaDiseaseRadioGroup.setValues(new int[]{1,2,3});

      addTreatmentSystemForSevereDementiaDiseaseRadioGroup();
    }
    return treatmentSystemForSevereDementiaDiseaseRadioGroup;

  }

  /**
   * 重度認知症疾患療養体制加算コンテナを取得します。
   * @return 重度認知症疾患療養体制加算コンテナ
   */
  protected ACLabelContainer getTreatmentSystemForSevereDementiaDiseaseRadioGroupContainer(){
    if(treatmentSystemForSevereDementiaDiseaseRadioGroupContainer==null){
      treatmentSystemForSevereDementiaDiseaseRadioGroupContainer = new ACLabelContainer();
      treatmentSystemForSevereDementiaDiseaseRadioGroupContainer.setFollowChildEnabled(true);
      treatmentSystemForSevereDementiaDiseaseRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      treatmentSystemForSevereDementiaDiseaseRadioGroupContainer.add(getTreatmentSystemForSevereDementiaDiseaseRadioGroup(), null);
    }
    return treatmentSystemForSevereDementiaDiseaseRadioGroupContainer;
  }

  /**
   * 重度認知症疾患療養体制加算モデルを取得します。
   * @return 重度認知症疾患療養体制加算モデル
   */
  protected ACListModelAdapter getTreatmentSystemForSevereDementiaDiseaseRadioGroupModel(){
    if(treatmentSystemForSevereDementiaDiseaseRadioGroupModel==null){
      treatmentSystemForSevereDementiaDiseaseRadioGroupModel = new ACListModelAdapter();
      addTreatmentSystemForSevereDementiaDiseaseRadioGroupModel();
    }
    return treatmentSystemForSevereDementiaDiseaseRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTreatmentSystemForSevereDementiaDiseaseItem1(){
    if(treatmentSystemForSevereDementiaDiseaseItem1==null){

      treatmentSystemForSevereDementiaDiseaseItem1 = new ACRadioButtonItem();

      treatmentSystemForSevereDementiaDiseaseItem1.setText("なし");

      treatmentSystemForSevereDementiaDiseaseItem1.setGroup(getTreatmentSystemForSevereDementiaDiseaseRadioGroup());

      treatmentSystemForSevereDementiaDiseaseItem1.setConstraints(VRLayout.FLOW);

      addTreatmentSystemForSevereDementiaDiseaseItem1();
    }
    return treatmentSystemForSevereDementiaDiseaseItem1;

  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getTreatmentSystemForSevereDementiaDiseaseItem2(){
    if(treatmentSystemForSevereDementiaDiseaseItem2==null){

      treatmentSystemForSevereDementiaDiseaseItem2 = new ACRadioButtonItem();

      treatmentSystemForSevereDementiaDiseaseItem2.setText("I型");

      treatmentSystemForSevereDementiaDiseaseItem2.setGroup(getTreatmentSystemForSevereDementiaDiseaseRadioGroup());

      treatmentSystemForSevereDementiaDiseaseItem2.setConstraints(VRLayout.FLOW);

      addTreatmentSystemForSevereDementiaDiseaseItem2();
    }
    return treatmentSystemForSevereDementiaDiseaseItem2;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getTreatmentSystemForSevereDementiaDiseaseItem3(){
    if(treatmentSystemForSevereDementiaDiseaseItem3==null){

      treatmentSystemForSevereDementiaDiseaseItem3 = new ACRadioButtonItem();

      treatmentSystemForSevereDementiaDiseaseItem3.setText("II型");

      treatmentSystemForSevereDementiaDiseaseItem3.setGroup(getTreatmentSystemForSevereDementiaDiseaseRadioGroup());

      treatmentSystemForSevereDementiaDiseaseItem3.setConstraints(VRLayout.FLOW);

      addTreatmentSystemForSevereDementiaDiseaseItem3();
    }
    return treatmentSystemForSevereDementiaDiseaseItem3;

  }

  /**
   * 移行定着支援加算を取得します。
   * @return 移行定着支援加算
   */
  public ACValueArrayRadioButtonGroup getTransferFixingSupportRadio(){
    if(transferFixingSupportRadio==null){

      transferFixingSupportRadio = new ACValueArrayRadioButtonGroup();

      getTransferFixingSupportRadioContainer().setText("移行定着支援加算");

      transferFixingSupportRadio.setBindPath("1550133");

      transferFixingSupportRadio.setUseClearButton(false);

      transferFixingSupportRadio.setModel(getTransferFixingSupportRadioModel());

      transferFixingSupportRadio.setValues(new int[]{1,2});

      addTransferFixingSupportRadio();
    }
    return transferFixingSupportRadio;

  }

  /**
   * 移行定着支援加算コンテナを取得します。
   * @return 移行定着支援加算コンテナ
   */
  protected ACLabelContainer getTransferFixingSupportRadioContainer(){
    if(transferFixingSupportRadioContainer==null){
      transferFixingSupportRadioContainer = new ACLabelContainer();
      transferFixingSupportRadioContainer.setFollowChildEnabled(true);
      transferFixingSupportRadioContainer.setVAlignment(VRLayout.CENTER);
      transferFixingSupportRadioContainer.add(getTransferFixingSupportRadio(), null);
    }
    return transferFixingSupportRadioContainer;
  }

  /**
   * 移行定着支援加算モデルを取得します。
   * @return 移行定着支援加算モデル
   */
  protected ACListModelAdapter getTransferFixingSupportRadioModel(){
    if(transferFixingSupportRadioModel==null){
      transferFixingSupportRadioModel = new ACListModelAdapter();
      addTransferFixingSupportRadioModel();
    }
    return transferFixingSupportRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTransferFixingSupportItem1(){
    if(transferFixingSupportItem1==null){

      transferFixingSupportItem1 = new ACRadioButtonItem();

      transferFixingSupportItem1.setText("なし");

      transferFixingSupportItem1.setGroup(getTransferFixingSupportRadio());

      transferFixingSupportItem1.setConstraints(VRLayout.FLOW);

      addTransferFixingSupportItem1();
    }
    return transferFixingSupportItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getTransferFixingSupportItem2(){
    if(transferFixingSupportItem2==null){

      transferFixingSupportItem2 = new ACRadioButtonItem();

      transferFixingSupportItem2.setText("あり");

      transferFixingSupportItem2.setGroup(getTransferFixingSupportRadio());

      transferFixingSupportItem2.setConstraints(VRLayout.FLOW);

      addTransferFixingSupportItem2();
    }
    return transferFixingSupportItem2;

  }

  /**
   * 排せつ支援加算を取得します。
   * @return 排せつ支援加算
   */
  public ACValueArrayRadioButtonGroup getExcretionSupport(){
    if(excretionSupport==null){

      excretionSupport = new ACValueArrayRadioButtonGroup();

      getExcretionSupportContainer().setText("排せつ支援加算");

      excretionSupport.setBindPath("1550134");

      excretionSupport.setUseClearButton(false);

      excretionSupport.setModel(getExcretionSupportModel());

      excretionSupport.setValues(new int[]{1,2});

      addExcretionSupport();
    }
    return excretionSupport;

  }

  /**
   * 排せつ支援加算コンテナを取得します。
   * @return 排せつ支援加算コンテナ
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
   * 排せつ支援加算モデルを取得します。
   * @return 排せつ支援加算モデル
   */
  protected ACListModelAdapter getExcretionSupportModel(){
    if(excretionSupportModel==null){
      excretionSupportModel = new ACListModelAdapter();
      addExcretionSupportModel();
    }
    return excretionSupportModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getExcretionSupportItem1(){
    if(excretionSupportItem1==null){

      excretionSupportItem1 = new ACRadioButtonItem();

      excretionSupportItem1.setText("なし");

      excretionSupportItem1.setGroup(getExcretionSupport());

      excretionSupportItem1.setConstraints(VRLayout.FLOW);

      addExcretionSupportItem1();
    }
    return excretionSupportItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getExcretionSupportItem2(){
    if(excretionSupportItem2==null){

      excretionSupportItem2 = new ACRadioButtonItem();

      excretionSupportItem2.setText("あり");

      excretionSupportItem2.setGroup(getExcretionSupport());

      excretionSupportItem2.setConstraints(VRLayout.FLOW);

      addExcretionSupportItem2();
    }
    return excretionSupportItem2;

  }

  /**
   * サービス提供体制強化加算を取得します。
   * @return サービス提供体制強化加算
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("サービス提供体制強化加算");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1550135");

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
   * サービス提供体制強化加算コンテナを取得します。
   * @return サービス提供体制強化加算コンテナ
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
   * サービス提供体制強化加算モデルを取得します。
   * @return サービス提供体制強化加算モデル
   */
  protected ACListModelAdapter getServiceAddProvisionStructuralRadioGroupModel(){
    if(serviceAddProvisionStructuralRadioGroupModel==null){
      serviceAddProvisionStructuralRadioGroupModel = new ACListModelAdapter();
      addServiceAddProvisionStructuralRadioGroupModel();
    }
    return serviceAddProvisionStructuralRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem1(){
    if(serviceAddProvisionStructuralRadioItem1==null){

      serviceAddProvisionStructuralRadioItem1 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem1.setText("なし");

      serviceAddProvisionStructuralRadioItem1.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem1.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem1();
    }
    return serviceAddProvisionStructuralRadioItem1;

  }

  /**
   * Iイ型を取得します。
   * @return Iイ型
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem5(){
    if(serviceAddProvisionStructuralRadioItem5==null){

      serviceAddProvisionStructuralRadioItem5 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem5.setText("Iイ型");

      serviceAddProvisionStructuralRadioItem5.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem5.setConstraints(VRLayout.FLOW_RETURN);

      addServiceAddProvisionStructuralRadioItem5();
    }
    return serviceAddProvisionStructuralRadioItem5;

  }

  /**
   * Iロ型を取得します。
   * @return Iロ型
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("Iロ型");

      serviceAddProvisionStructuralRadioItem2.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem2.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem2();
    }
    return serviceAddProvisionStructuralRadioItem2;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem3(){
    if(serviceAddProvisionStructuralRadioItem3==null){

      serviceAddProvisionStructuralRadioItem3 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem3.setText("II型");

      serviceAddProvisionStructuralRadioItem3.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem3.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem3();
    }
    return serviceAddProvisionStructuralRadioItem3;

  }

  /**
   * III型を取得します。
   * @return III型
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem4(){
    if(serviceAddProvisionStructuralRadioItem4==null){

      serviceAddProvisionStructuralRadioItem4 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem4.setText("III型");

      serviceAddProvisionStructuralRadioItem4.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem4.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem4();
    }
    return serviceAddProvisionStructuralRadioItem4;

  }

  /**
   * 食事コンテナを取得します。
   * @return 食事コンテナ
   */
  public ACBackLabelContainer getMedicalFacilityDinnerContainer(){
    if(medicalFacilityDinnerContainer==null){

      medicalFacilityDinnerContainer = new ACBackLabelContainer();

      medicalFacilityDinnerContainer.setFollowChildEnabled(true);

      addMedicalFacilityDinnerContainer();
    }
    return medicalFacilityDinnerContainer;

  }

  /**
   * 食事提供を取得します。
   * @return 食事提供
   */
  public ACComboBox getMedicalFacilityDinnerOffer(){
    if(medicalFacilityDinnerOffer==null){

      medicalFacilityDinnerOffer = new ACComboBox();

      getMedicalFacilityDinnerOfferContainer().setText("食事提供");

      medicalFacilityDinnerOffer.setBindPath("1550136");

      medicalFacilityDinnerOffer.setEditable(false);

      medicalFacilityDinnerOffer.setModelBindPath("1550136");

      medicalFacilityDinnerOffer.setRenderBindPath("CONTENT");

      medicalFacilityDinnerOffer.setModel(getMedicalFacilityDinnerOfferModel());

      addMedicalFacilityDinnerOffer();
    }
    return medicalFacilityDinnerOffer;

  }

  /**
   * 食事提供コンテナを取得します。
   * @return 食事提供コンテナ
   */
  protected ACLabelContainer getMedicalFacilityDinnerOfferContainer(){
    if(medicalFacilityDinnerOfferContainer==null){
      medicalFacilityDinnerOfferContainer = new ACLabelContainer();
      medicalFacilityDinnerOfferContainer.setFollowChildEnabled(true);
      medicalFacilityDinnerOfferContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityDinnerOfferContainer.add(getMedicalFacilityDinnerOffer(), null);
    }
    return medicalFacilityDinnerOfferContainer;
  }

  /**
   * 食事提供モデルを取得します。
   * @return 食事提供モデル
   */
  protected ACComboBoxModelAdapter getMedicalFacilityDinnerOfferModel(){
    if(medicalFacilityDinnerOfferModel==null){
      medicalFacilityDinnerOfferModel = new ACComboBoxModelAdapter();
      addMedicalFacilityDinnerOfferModel();
    }
    return medicalFacilityDinnerOfferModel;
  }

  /**
   * 食事費用を取得します。
   * @return 食事費用
   */
  public ACTextField getMedicalFacilityDinnerCost(){
    if(medicalFacilityDinnerCost==null){

      medicalFacilityDinnerCost = new ACTextField();

      getMedicalFacilityDinnerCostContainer().setText("食事費用");

      medicalFacilityDinnerCost.setBindPath("1550137");

      medicalFacilityDinnerCost.setColumns(4);

      medicalFacilityDinnerCost.setCharType(VRCharType.ONLY_DIGIT);

      medicalFacilityDinnerCost.setHorizontalAlignment(SwingConstants.RIGHT);

      medicalFacilityDinnerCost.setIMEMode(InputSubset.LATIN);

      medicalFacilityDinnerCost.setMaxLength(5);

      addMedicalFacilityDinnerCost();
    }
    return medicalFacilityDinnerCost;

  }

  /**
   * 食事費用コンテナを取得します。
   * @return 食事費用コンテナ
   */
  protected ACLabelContainer getMedicalFacilityDinnerCostContainer(){
    if(medicalFacilityDinnerCostContainer==null){
      medicalFacilityDinnerCostContainer = new ACLabelContainer();
      medicalFacilityDinnerCostContainer.setFollowChildEnabled(true);
      medicalFacilityDinnerCostContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityDinnerCostContainer.add(getMedicalFacilityDinnerCost(), null);
    }
    return medicalFacilityDinnerCostContainer;
  }

  /**
   * 算定区分を取得します。
   * @return 算定区分
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityHospitalCalculationDivisionRadio(){
    if(medicalFacilityHospitalCalculationDivisionRadio==null){

      medicalFacilityHospitalCalculationDivisionRadio = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityHospitalCalculationDivisionRadioContainer().setText("算定区分");

      medicalFacilityHospitalCalculationDivisionRadio.setBindPath("9");

      medicalFacilityHospitalCalculationDivisionRadio.setUseClearButton(false);

      medicalFacilityHospitalCalculationDivisionRadio.setModel(getMedicalFacilityHospitalCalculationDivisionRadioModel());

      medicalFacilityHospitalCalculationDivisionRadio.setValues(new int[]{1,2});

      addMedicalFacilityHospitalCalculationDivisionRadio();
    }
    return medicalFacilityHospitalCalculationDivisionRadio;

  }

  /**
   * 算定区分コンテナを取得します。
   * @return 算定区分コンテナ
   */
  protected ACLabelContainer getMedicalFacilityHospitalCalculationDivisionRadioContainer(){
    if(medicalFacilityHospitalCalculationDivisionRadioContainer==null){
      medicalFacilityHospitalCalculationDivisionRadioContainer = new ACLabelContainer();
      medicalFacilityHospitalCalculationDivisionRadioContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalCalculationDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalCalculationDivisionRadioContainer.add(getMedicalFacilityHospitalCalculationDivisionRadio(), null);
    }
    return medicalFacilityHospitalCalculationDivisionRadioContainer;
  }

  /**
   * 算定区分モデルを取得します。
   * @return 算定区分モデル
   */
  protected ACListModelAdapter getMedicalFacilityHospitalCalculationDivisionRadioModel(){
    if(medicalFacilityHospitalCalculationDivisionRadioModel==null){
      medicalFacilityHospitalCalculationDivisionRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalCalculationDivisionRadioModel();
    }
    return medicalFacilityHospitalCalculationDivisionRadioModel;
  }

  /**
   * 通常を取得します。
   * @return 通常
   */
  public ACRadioButtonItem getMedicalFacilityHospitalCalculationDivisionRadioItem1(){
    if(medicalFacilityHospitalCalculationDivisionRadioItem1==null){

      medicalFacilityHospitalCalculationDivisionRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalCalculationDivisionRadioItem1.setText("通常");

      medicalFacilityHospitalCalculationDivisionRadioItem1.setGroup(getMedicalFacilityHospitalCalculationDivisionRadio());

      medicalFacilityHospitalCalculationDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalCalculationDivisionRadioItem1();
    }
    return medicalFacilityHospitalCalculationDivisionRadioItem1;

  }

  /**
   * 加算のみを取得します。
   * @return 加算のみ
   */
  public ACRadioButtonItem getMedicalFacilityHospitalCalculationDivisionRadioItem2(){
    if(medicalFacilityHospitalCalculationDivisionRadioItem2==null){

      medicalFacilityHospitalCalculationDivisionRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalCalculationDivisionRadioItem2.setText("加算のみ");

      medicalFacilityHospitalCalculationDivisionRadioItem2.setGroup(getMedicalFacilityHospitalCalculationDivisionRadio());

      medicalFacilityHospitalCalculationDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalCalculationDivisionRadioItem2();
    }
    return medicalFacilityHospitalCalculationDivisionRadioItem2;

  }

  /**
   * コンストラクタです。
   */
  public QS001_15511_201804Design() {

    try {
      initialize();

    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身の設定を行ないます。
   */
  protected void initThis(){
  }

  /**
   * thisに内部項目を追加します。
   */
  protected void addThis(){

    this.add(getTabs(), VRLayout.CLIENT);

  }

  /**
   * タブペインに内部項目を追加します。
   */
  protected void addTabs(){

    tabs.addTab("1", getTab1());

    tabs.addTab("2", getTab2());

    tabs.addTab("3", getTab3());

    tabs.addTab("4", getTab4());

    tabs.addTab("5", getTab5());

  }

  /**
   * タブ1に内部項目を追加します。
   */
  protected void addTab1(){

    tab1.add(getMedicalFacilityHospitalInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getStaffAssignmentDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityHospitalHospitalRoomContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityHospitalNightShiftSubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getUnitCareMaintenanceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 施設等の区分に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalInstitutionDivisionRadio(){

  }

  /**
   * 施設等の区分モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalInstitutionDivisionRadioModel(){

    getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem1().setButtonIndex(1);

    getMedicalFacilityHospitalInstitutionDivisionRadioModel().add(getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem1());

    getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem5().setButtonIndex(2);

    getMedicalFacilityHospitalInstitutionDivisionRadioModel().add(getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem5());

    getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem3().setButtonIndex(3);

    getMedicalFacilityHospitalInstitutionDivisionRadioModel().add(getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem3());

    getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem2().setButtonIndex(4);

    getMedicalFacilityHospitalInstitutionDivisionRadioModel().add(getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem2());

    getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem4().setButtonIndex(5);

    getMedicalFacilityHospitalInstitutionDivisionRadioModel().add(getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem4());

    getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem6().setButtonIndex(6);

    getMedicalFacilityHospitalInstitutionDivisionRadioModel().add(getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem6());

  }

  /**
   * I型介護医療院に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem1(){

  }

  /**
   * II型介護医療院に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem5(){

  }

  /**
   * 特別介護医療院に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem3(){

  }

  /**
   * ユニット型I型介護医療院に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem2(){

  }

  /**
   * ユニット型II型介護医療院に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem4(){

  }

  /**
   * ユニット型特別介護医療院に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem6(){

  }

  /**
   * 人員配置区分コンテナに内部項目を追加します。
   */
  protected void addStaffAssignmentDivisionContainer(){

    staffAssignmentDivisionContainer.add(getStaffAssignment1Division(), VRLayout.FLOW_INSETLINE_RETURN);

    staffAssignmentDivisionContainer.add(getStaffAssignment2Division(), VRLayout.FLOW_INSETLINE_RETURN);

    staffAssignmentDivisionContainer.add(getStaffAssignment3Division(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 人員配置区分ラジオグループに内部項目を追加します。
   */
  protected void addStaffAssignment1Division(){

  }

  /**
   * 人員配置区分ラジオグループモデルに内部項目を追加します。
   */
  protected void addStaffAssignment1DivisionModel(){

    getStaffAssignmentDivisionItem1().setButtonIndex(1);

    getStaffAssignment1DivisionModel().add(getStaffAssignmentDivisionItem1());

    getStaffAssignmentDivisionItem2().setButtonIndex(2);

    getStaffAssignment1DivisionModel().add(getStaffAssignmentDivisionItem2());

    getStaffAssignmentDivisionItem3().setButtonIndex(3);

    getStaffAssignment1DivisionModel().add(getStaffAssignmentDivisionItem3());

  }

  /**
   * I型（I）に内部項目を追加します。
   */
  protected void addStaffAssignmentDivisionItem1(){

  }

  /**
   * I型（II）に内部項目を追加します。
   */
  protected void addStaffAssignmentDivisionItem2(){

  }

  /**
   * I型（III）に内部項目を追加します。
   */
  protected void addStaffAssignmentDivisionItem3(){

  }

  /**
   * 人員配置区分に内部項目を追加します。
   */
  protected void addStaffAssignment2Division(){

  }

  /**
   * 人員配置区分モデルに内部項目を追加します。
   */
  protected void addStaffAssignment2DivisionModel(){

    getStaffAssignmentDivisionItem4().setButtonIndex(1);

    getStaffAssignment2DivisionModel().add(getStaffAssignmentDivisionItem4());

    getStaffAssignmentDivisionItem5().setButtonIndex(2);

    getStaffAssignment2DivisionModel().add(getStaffAssignmentDivisionItem5());

    getStaffAssignmentDivisionItem6().setButtonIndex(3);

    getStaffAssignment2DivisionModel().add(getStaffAssignmentDivisionItem6());

  }

  /**
   * II型（I）に内部項目を追加します。
   */
  protected void addStaffAssignmentDivisionItem4(){

  }

  /**
   * II型（II）に内部項目を追加します。
   */
  protected void addStaffAssignmentDivisionItem5(){

  }

  /**
   * II型（III）に内部項目を追加します。
   */
  protected void addStaffAssignmentDivisionItem6(){

  }

  /**
   * 人員配置区分に内部項目を追加します。
   */
  protected void addStaffAssignment3Division(){

  }

  /**
   * 人員配置区分モデルに内部項目を追加します。
   */
  protected void addStaffAssignment3DivisionModel(){

    getStaffAssignmentDivisionItem7().setButtonIndex(1);

    getStaffAssignment3DivisionModel().add(getStaffAssignmentDivisionItem7());

    getStaffAssignmentDivisionItem8().setButtonIndex(2);

    getStaffAssignment3DivisionModel().add(getStaffAssignmentDivisionItem8());

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addStaffAssignmentDivisionItem7(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addStaffAssignmentDivisionItem8(){

  }

  /**
   * 病室区分コンテナに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalHospitalRoomContena(){

    medicalFacilityHospitalHospitalRoomContena.add(getMedicalFacilityHospitalHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalFacilityHospitalHospitalRoomContena.add(getMedicalFacilityHospitalUnitHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 病室区分（病院）に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalHospitalRoomRadio(){

  }

  /**
   * 病室区分（病院）モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalHospitalRoomRadioModel(){

    getMedicalFacilityHospitalHospitalRoomRadioItem1().setButtonIndex(1);

    getMedicalFacilityHospitalHospitalRoomRadioModel().add(getMedicalFacilityHospitalHospitalRoomRadioItem1());

    getMedicalFacilityHospitalHospitalRoomRadioItem2().setButtonIndex(2);

    getMedicalFacilityHospitalHospitalRoomRadioModel().add(getMedicalFacilityHospitalHospitalRoomRadioItem2());

  }

  /**
   * 従来型個室に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalHospitalRoomRadioItem1(){

  }

  /**
   * 多床室に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalHospitalRoomRadioItem2(){

  }

  /**
   * 病室区分（ユニット型）に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalUnitHospitalRoomRadio(){

  }

  /**
   * 病室区分（ユニット型）モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalUnitHospitalRoomRadioModel(){

    getMedicalFacilityHospitalUnitHospitalRoomRadioItem1().setButtonIndex(1);

    getMedicalFacilityHospitalUnitHospitalRoomRadioModel().add(getMedicalFacilityHospitalUnitHospitalRoomRadioItem1());

    getMedicalFacilityHospitalUnitHospitalRoomRadioItem2().setButtonIndex(2);

    getMedicalFacilityHospitalUnitHospitalRoomRadioModel().add(getMedicalFacilityHospitalUnitHospitalRoomRadioItem2());

  }

  /**
   * ユニット型個室に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalUnitHospitalRoomRadioItem1(){

  }

  /**
   * ユニット型個室的多床室に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalUnitHospitalRoomRadioItem2(){

  }

  /**
   * 夜間勤務条件基準に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalNightShiftSubtractionRadio(){

  }

  /**
   * 夜間勤務条件基準モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalNightShiftSubtractionRadioModel(){

    getMedicalFacilityHospitalNightShiftSubtractionRadioItem1().setButtonIndex(1);

    getMedicalFacilityHospitalNightShiftSubtractionRadioModel().add(getMedicalFacilityHospitalNightShiftSubtractionRadioItem1());

    getMedicalFacilityHospitalNightShiftSubtractionRadioItem2().setButtonIndex(2);

    getMedicalFacilityHospitalNightShiftSubtractionRadioModel().add(getMedicalFacilityHospitalNightShiftSubtractionRadioItem2());

  }

  /**
   * 基準型に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalNightShiftSubtractionRadioItem1(){

  }

  /**
   * 減算型に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalNightShiftSubtractionRadioItem2(){

  }

  /**
   * ユニットケアの整備に内部項目を追加します。
   */
  protected void addUnitCareMaintenanceRadio(){

  }

  /**
   * ユニットケアの整備モデルに内部項目を追加します。
   */
  protected void addUnitCareMaintenanceRadioModel(){

    getUnitCareMaintenanceRadioItem1().setButtonIndex(1);

    getUnitCareMaintenanceRadioModel().add(getUnitCareMaintenanceRadioItem1());

    getUnitCareMaintenanceRadioItem2().setButtonIndex(2);

    getUnitCareMaintenanceRadioModel().add(getUnitCareMaintenanceRadioItem2());

  }

  /**
   * 未整備に内部項目を追加します。
   */
  protected void addUnitCareMaintenanceRadioItem1(){

  }

  /**
   * 整備に内部項目を追加します。
   */
  protected void addUnitCareMaintenanceRadioItem2(){

  }

  /**
   * タブ2に内部項目を追加します。
   */
  protected void addTab2(){

    tab2.add(getBodyRestraintAbolitionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getEnvironmentalCorridorRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getEnvironmentalRecuperationRoomRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityHospitalSubstractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHospitalRecuperationAdditionTypeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 身体拘束廃止未実施減算に内部項目を追加します。
   */
  protected void addBodyRestraintAbolitionRadio(){

  }

  /**
   * 身体拘束廃止未実施減算モデルに内部項目を追加します。
   */
  protected void addBodyRestraintAbolitionRadioModel(){

    getBodyRestraintAbolitionRadioItem1().setButtonIndex(1);

    getBodyRestraintAbolitionRadioModel().add(getBodyRestraintAbolitionRadioItem1());

    getBodyRestraintAbolitionRadioItem2().setButtonIndex(2);

    getBodyRestraintAbolitionRadioModel().add(getBodyRestraintAbolitionRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addBodyRestraintAbolitionRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addBodyRestraintAbolitionRadioItem2(){

  }

  /**
   * 療養環境基準（廊下）に内部項目を追加します。
   */
  protected void addEnvironmentalCorridorRadio(){

  }

  /**
   * 療養環境基準（廊下）モデルに内部項目を追加します。
   */
  protected void addEnvironmentalCorridorRadioModel(){

    getEnvironmentalCorridorRadioItem1().setButtonIndex(1);

    getEnvironmentalCorridorRadioModel().add(getEnvironmentalCorridorRadioItem1());

    getEnvironmentalCorridorRadioItem2().setButtonIndex(2);

    getEnvironmentalCorridorRadioModel().add(getEnvironmentalCorridorRadioItem2());

  }

  /**
   * 基準型に内部項目を追加します。
   */
  protected void addEnvironmentalCorridorRadioItem1(){

  }

  /**
   * 減算型に内部項目を追加します。
   */
  protected void addEnvironmentalCorridorRadioItem2(){

  }

  /**
   * 療養環境基準（療養室）に内部項目を追加します。
   */
  protected void addEnvironmentalRecuperationRoomRadio(){

  }

  /**
   * 療養環境基準（療養室）モデルに内部項目を追加します。
   */
  protected void addEnvironmentalRecuperationRoomRadioModel(){

    getEnvironmentalRecuperationRoomRadioItem1().setButtonIndex(1);

    getEnvironmentalRecuperationRoomRadioModel().add(getEnvironmentalRecuperationRoomRadioItem1());

    getEnvironmentalRecuperationRoomRadioItem2().setButtonIndex(2);

    getEnvironmentalRecuperationRoomRadioModel().add(getEnvironmentalRecuperationRoomRadioItem2());

  }

  /**
   * 基準型に内部項目を追加します。
   */
  protected void addEnvironmentalRecuperationRoomRadioItem1(){

  }

  /**
   * 減算型に内部項目を追加します。
   */
  protected void addEnvironmentalRecuperationRoomRadioItem2(){

  }

  /**
   * 職員減算に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalSubstraction(){

  }

  /**
   * 職員減算モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalSubstractionModel(){

    getMedicalFacilityHospitalSubstractionItem1().setButtonIndex(1);

    getMedicalFacilityHospitalSubstractionModel().add(getMedicalFacilityHospitalSubstractionItem1());

    getMedicalFacilityHospitalSubstractionItem2().setButtonIndex(2);

    getMedicalFacilityHospitalSubstractionModel().add(getMedicalFacilityHospitalSubstractionItem2());

    getMedicalFacilityHospitalSubstractionItem3().setButtonIndex(3);

    getMedicalFacilityHospitalSubstractionModel().add(getMedicalFacilityHospitalSubstractionItem3());

    getMedicalFacilityHospitalSubstractionItem4().setButtonIndex(4);

    getMedicalFacilityHospitalSubstractionModel().add(getMedicalFacilityHospitalSubstractionItem4());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalSubstractionItem1(){

  }

  /**
   * 定員超過に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalSubstractionItem2(){

  }

  /**
   * 医師・薬剤師・看護職員・介護職員・介護支援専門員の不足に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalSubstractionItem3(){

  }

  /**
   * 正看比率が20％未満に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalSubstractionItem4(){

  }

  /**
   * 夜間勤務等看護加算に内部項目を追加します。
   */
  protected void addHospitalRecuperationAdditionType(){

  }

  /**
   * 夜間勤務等看護加算モデルに内部項目を追加します。
   */
  protected void addHospitalRecuperationAdditionTypeModel(){

    getHospitalRecuperationAdditionType1().setButtonIndex(1);

    getHospitalRecuperationAdditionTypeModel().add(getHospitalRecuperationAdditionType1());

    getHospitalRecuperationAdditionType2().setButtonIndex(2);

    getHospitalRecuperationAdditionTypeModel().add(getHospitalRecuperationAdditionType2());

    getHospitalRecuperationAdditionType3().setButtonIndex(3);

    getHospitalRecuperationAdditionTypeModel().add(getHospitalRecuperationAdditionType3());

    getHospitalRecuperationAdditionType4().setButtonIndex(4);

    getHospitalRecuperationAdditionTypeModel().add(getHospitalRecuperationAdditionType4());

    getHospitalRecuperationAdditionType5().setButtonIndex(5);

    getHospitalRecuperationAdditionTypeModel().add(getHospitalRecuperationAdditionType5());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHospitalRecuperationAdditionType1(){

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addHospitalRecuperationAdditionType2(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addHospitalRecuperationAdditionType3(){

  }

  /**
   * III型に内部項目を追加します。
   */
  protected void addHospitalRecuperationAdditionType4(){

  }

  /**
   * IV型に内部項目を追加します。
   */
  protected void addHospitalRecuperationAdditionType5(){

  }

  /**
   * 若年性認知症入所者受入加算に内部項目を追加します。
   */
  protected void addYoungDementiaPatinetAddRadioGroup(){

  }

  /**
   * 若年性認知症入所者受入加算モデルに内部項目を追加します。
   */
  protected void addYoungDementiaPatinetAddRadioGroupModel(){

    getYoungDementiaPatinetAddRadioItem1().setButtonIndex(1);

    getYoungDementiaPatinetAddRadioGroupModel().add(getYoungDementiaPatinetAddRadioItem1());

    getYoungDementiaPatinetAddRadioItem2().setButtonIndex(2);

    getYoungDementiaPatinetAddRadioGroupModel().add(getYoungDementiaPatinetAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addYoungDementiaPatinetAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addYoungDementiaPatinetAddRadioItem2(){

  }

  /**
   * タブ3に内部項目を追加します。
   */
  protected void addTab3(){

    tab3.add(getMedicalFacilityHospitalStayRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getTrialHijoRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getMedicalFacilityHospitalMedicalExaminationRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getMedicalFacilityHospitalStandardRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getReEntryNutritionCooperationAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getMedicalFacilityHospitalNutritionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getLowNutritionalRiskImprovementAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getMedicalFacilityHospitalOralSwitchRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getOralMaintenanceAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 外泊時費用に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalStayRadio(){

  }

  /**
   * 外泊時費用モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalStayRadioModel(){

    getMedicalFacilityHospitalStayRadioItem1().setButtonIndex(1);

    getMedicalFacilityHospitalStayRadioModel().add(getMedicalFacilityHospitalStayRadioItem1());

    getMedicalFacilityHospitalStayRadioItem2().setButtonIndex(2);

    getMedicalFacilityHospitalStayRadioModel().add(getMedicalFacilityHospitalStayRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalStayRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalStayRadioItem2(){

  }

  /**
   * 試行的退所サービス費に内部項目を追加します。
   */
  protected void addTrialHijoRadio(){

  }

  /**
   * 試行的退所サービス費モデルに内部項目を追加します。
   */
  protected void addTrialHijoRadioModel(){

    getTrialHijoRadioItem1().setButtonIndex(1);

    getTrialHijoRadioModel().add(getTrialHijoRadioItem1());

    getTrialHijoRadioItem2().setButtonIndex(2);

    getTrialHijoRadioModel().add(getTrialHijoRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTrialHijoRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addTrialHijoRadioItem2(){

  }

  /**
   * 他科受診時費用に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalMedicalExaminationRadio(){

  }

  /**
   * 他科受診時費用モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalMedicalExaminationRadioModel(){

    getMedicalFacilityHospitalMedicalExaminationRadioItem1().setButtonIndex(1);

    getMedicalFacilityHospitalMedicalExaminationRadioModel().add(getMedicalFacilityHospitalMedicalExaminationRadioItem1());

    getMedicalFacilityHospitalMedicalExaminationRadioItem2().setButtonIndex(2);

    getMedicalFacilityHospitalMedicalExaminationRadioModel().add(getMedicalFacilityHospitalMedicalExaminationRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalMedicalExaminationRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalMedicalExaminationRadioItem2(){

  }

  /**
   * 初期加算に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalStandardRadio(){

  }

  /**
   * 初期加算モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalStandardRadioModel(){

    getMedicalFacilityHospitalStandardRadioItem1().setButtonIndex(1);

    getMedicalFacilityHospitalStandardRadioModel().add(getMedicalFacilityHospitalStandardRadioItem1());

    getMedicalFacilityHospitalStandardRadioItem2().setButtonIndex(2);

    getMedicalFacilityHospitalStandardRadioModel().add(getMedicalFacilityHospitalStandardRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalStandardRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalStandardRadioItem2(){

  }

  /**
   * 再入所時栄養連携加算に内部項目を追加します。
   */
  protected void addReEntryNutritionCooperationAdd(){

  }

  /**
   * 再入所時栄養連携加算モデルに内部項目を追加します。
   */
  protected void addReEntryNutritionCooperationAddModel(){

    getReEntryNutritionCooperationAddItem1().setButtonIndex(1);

    getReEntryNutritionCooperationAddModel().add(getReEntryNutritionCooperationAddItem1());

    getReEntryNutritionCooperationAddItem2().setButtonIndex(2);

    getReEntryNutritionCooperationAddModel().add(getReEntryNutritionCooperationAddItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addReEntryNutritionCooperationAddItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addReEntryNutritionCooperationAddItem2(){

  }

  /**
   * 栄養マネジメント加算に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalNutritionRadio(){

  }

  /**
   * 栄養マネジメント加算モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalNutritionRadioModel(){

    getMedicalFacilityHospitalNutritionRadioItem1().setButtonIndex(1);

    getMedicalFacilityHospitalNutritionRadioModel().add(getMedicalFacilityHospitalNutritionRadioItem1());

    getMedicalFacilityHospitalNutritionRadioItem2().setButtonIndex(2);

    getMedicalFacilityHospitalNutritionRadioModel().add(getMedicalFacilityHospitalNutritionRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalNutritionRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalNutritionRadioItem2(){

  }

  /**
   * 低栄養リスク改善加算に内部項目を追加します。
   */
  protected void addLowNutritionalRiskImprovementAdd(){

  }

  /**
   * 低栄養リスク改善加算モデルに内部項目を追加します。
   */
  protected void addLowNutritionalRiskImprovementAddModel(){

    getLowNutritionalRiskImprovementAddItem1().setButtonIndex(1);

    getLowNutritionalRiskImprovementAddModel().add(getLowNutritionalRiskImprovementAddItem1());

    getLowNutritionalRiskImprovementAddItem2().setButtonIndex(2);

    getLowNutritionalRiskImprovementAddModel().add(getLowNutritionalRiskImprovementAddItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addLowNutritionalRiskImprovementAddItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addLowNutritionalRiskImprovementAddItem2(){

  }

  /**
   * 経口移行加算に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalOralSwitchRadio(){

  }

  /**
   * 経口移行加算モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalOralSwitchRadioModel(){

    getMedicalFacilityHospitalOralSwitchRadioItem1().setButtonIndex(1);

    getMedicalFacilityHospitalOralSwitchRadioModel().add(getMedicalFacilityHospitalOralSwitchRadioItem1());

    getMedicalFacilityHospitalOralSwitchRadioItem2().setButtonIndex(2);

    getMedicalFacilityHospitalOralSwitchRadioModel().add(getMedicalFacilityHospitalOralSwitchRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalOralSwitchRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalOralSwitchRadioItem2(){

  }

  /**
   * 経口維持加算コンテナに内部項目を追加します。
   */
  protected void addOralMaintenanceAddContainer(){

    oralMaintenanceAddContainer.add(getOralMaintenanceAdd(), null);

    oralMaintenanceAddContainer.add(getOralMaintenanceAddItem3(), VRLayout.FLOW);

  }

  /**
   * 経口維持加算に内部項目を追加します。
   */
  protected void addOralMaintenanceAdd(){

  }

  /**
   * 経口維持加算モデルに内部項目を追加します。
   */
  protected void addOralMaintenanceAddModel(){

    getOralMaintenanceAddItem1().setButtonIndex(1);

    getOralMaintenanceAddModel().add(getOralMaintenanceAddItem1());

    getOralMaintenanceAddItem2().setButtonIndex(2);

    getOralMaintenanceAddModel().add(getOralMaintenanceAddItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addOralMaintenanceAddItem1(){

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addOralMaintenanceAddItem2(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addOralMaintenanceAddItem3(){

  }

  /**
   * タブ4に内部項目を追加します。
   */
  protected void addTab4(){

    tab4.add(getOralKeepStructureAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getOralKeepAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getMedicalFacilityHospitalRecuperateDinnerRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getStayReturnSupportAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getMedicalFacilityHospitalHijoAddition(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getMedicalFacilityHospitalConsultationFee(), VRLayout.FLOW);

    tab4.add(getMedicalFacilityHospitalConsultationFeeLabel(), VRLayout.FLOW_RETURN);

  }

  /**
   * 口腔衛生管理体制加算に内部項目を追加します。
   */
  protected void addOralKeepStructureAddRadioGroup(){

  }

  /**
   * 口腔衛生管理体制加算モデルに内部項目を追加します。
   */
  protected void addOralKeepStructureAddRadioGroupModel(){

    getOralKeepStructureAddRadioItem1().setButtonIndex(1);

    getOralKeepStructureAddRadioGroupModel().add(getOralKeepStructureAddRadioItem1());

    getOralKeepStructureAddRadioItem2().setButtonIndex(2);

    getOralKeepStructureAddRadioGroupModel().add(getOralKeepStructureAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addOralKeepStructureAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addOralKeepStructureAddRadioItem2(){

  }

  /**
   * 口腔衛生管理加算に内部項目を追加します。
   */
  protected void addOralKeepAddRadioGroup(){

  }

  /**
   * 口腔衛生管理加算モデルに内部項目を追加します。
   */
  protected void addOralKeepAddRadioGroupModel(){

    getOralKeepAddRadioItem1().setButtonIndex(1);

    getOralKeepAddRadioGroupModel().add(getOralKeepAddRadioItem1());

    getOralKeepAddRadioItem2().setButtonIndex(2);

    getOralKeepAddRadioGroupModel().add(getOralKeepAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addOralKeepAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addOralKeepAddRadioItem2(){

  }

  /**
   * 療養食加算に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalRecuperateDinnerRadio(){

  }

  /**
   * 療養食加算モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalRecuperateDinnerRadioModel(){

    getMedicalFacilityHospitalRecuperateDinnerRadioItem1().setButtonIndex(1);

    getMedicalFacilityHospitalRecuperateDinnerRadioModel().add(getMedicalFacilityHospitalRecuperateDinnerRadioItem1());

    getMedicalFacilityHospitalRecuperateDinnerRadioItem2().setButtonIndex(2);

    getMedicalFacilityHospitalRecuperateDinnerRadioModel().add(getMedicalFacilityHospitalRecuperateDinnerRadioItem2());

    getMedicalFacilityHospitalRecuperateDinnerRadioItem3().setButtonIndex(3);

    getMedicalFacilityHospitalRecuperateDinnerRadioModel().add(getMedicalFacilityHospitalRecuperateDinnerRadioItem3());

    getMedicalFacilityHospitalRecuperateDinnerRadioItem4().setButtonIndex(4);

    getMedicalFacilityHospitalRecuperateDinnerRadioModel().add(getMedicalFacilityHospitalRecuperateDinnerRadioItem4());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalRecuperateDinnerRadioItem1(){

  }

  /**
   * 3回に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalRecuperateDinnerRadioItem2(){

  }

  /**
   * 2回に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalRecuperateDinnerRadioItem3(){

  }

  /**
   * 1回に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalRecuperateDinnerRadioItem4(){

  }

  /**
   * 在宅復帰支援機能加算に内部項目を追加します。
   */
  protected void addStayReturnSupportAddRadio(){

  }

  /**
   * 在宅復帰支援機能加算モデルに内部項目を追加します。
   */
  protected void addStayReturnSupportAddRadioModel(){

    getStayReturnSupportAddRadioItem1().setButtonIndex(1);

    getStayReturnSupportAddRadioModel().add(getStayReturnSupportAddRadioItem1());

    getStayReturnSupportAddRadioItem2().setButtonIndex(2);

    getStayReturnSupportAddRadioModel().add(getStayReturnSupportAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addStayReturnSupportAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addStayReturnSupportAddRadioItem2(){

  }

  /**
   * 退所関連加算に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalHijoAddition(){

    medicalFacilityHospitalHijoAddition.add(getLeavingHospitalPreConsultationAddition(), VRLayout.FLOW_RETURN);

    medicalFacilityHospitalHijoAddition.add(getLeavingHospitalAfterConsultationAddition(), VRLayout.FLOW_RETURN);

    medicalFacilityHospitalHijoAddition.add(getLeavingHospitalConsultationAddition(), VRLayout.FLOW_RETURN);

    medicalFacilityHospitalHijoAddition.add(getLeavingHospitalDissemination(), VRLayout.FLOW_RETURN);

    medicalFacilityHospitalHijoAddition.add(getLeavingHospitalCooperationAddition(), VRLayout.FLOW_RETURN);

    medicalFacilityHospitalHijoAddition.add(getLeavingHospital(), VRLayout.FLOW_RETURN);

  }

  /**
   * 退所(院)前訪問指導加算に内部項目を追加します。
   */
  protected void addLeavingHospitalPreConsultationAddition(){

  }

  /**
   * 退所(院)後訪問指導加算に内部項目を追加します。
   */
  protected void addLeavingHospitalAfterConsultationAddition(){

  }

  /**
   * 退所(院)時指導加算に内部項目を追加します。
   */
  protected void addLeavingHospitalConsultationAddition(){

  }

  /**
   * 退所(院)時情報提供加算に内部項目を追加します。
   */
  protected void addLeavingHospitalDissemination(){

  }

  /**
   * 退所(院)前連携加算に内部項目を追加します。
   */
  protected void addLeavingHospitalCooperationAddition(){

  }

  /**
   * 訪問看護指示加算に内部項目を追加します。
   */
  protected void addLeavingHospital(){

  }

  /**
   * 特別診療費に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalConsultationFee(){

  }

  /**
   * ラベルに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalConsultationFeeLabel(){

  }

  /**
   * タブ5に内部項目を追加します。
   */
  protected void addTab5(){

    tab5.add(getEmergencyTreatmentManagementRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab5.add(getDementiaProfessionalCareAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab5.add(getDementiaEmergencyAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab5.add(getTreatmentSystemForSevereDementiaDiseaseRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab5.add(getTransferFixingSupportRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab5.add(getExcretionSupportContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab5.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab5.add(getMedicalFacilityDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    tab5.add(getMedicalFacilityHospitalCalculationDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 緊急時治療管理に内部項目を追加します。
   */
  protected void addEmergencyTreatmentManagementRadio(){

  }

  /**
   * 緊急時治療管理モデルに内部項目を追加します。
   */
  protected void addEmergencyTreatmentManagementRadioModel(){

    getEmergencyTreatmentManagementItem1().setButtonIndex(1);

    getEmergencyTreatmentManagementRadioModel().add(getEmergencyTreatmentManagementItem1());

    getEmergencyTreatmentManagementItem2().setButtonIndex(2);

    getEmergencyTreatmentManagementRadioModel().add(getEmergencyTreatmentManagementItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addEmergencyTreatmentManagementItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addEmergencyTreatmentManagementItem2(){

  }

  /**
   * 認知症専門ケア加算に内部項目を追加します。
   */
  protected void addDementiaProfessionalCareAddRadioGroup(){

  }

  /**
   * 認知症専門ケア加算モデルに内部項目を追加します。
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
   * なしに内部項目を追加します。
   */
  protected void addDementiaProfessionalCareAddRadioItem1(){

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addDementiaProfessionalCareAddRadioItem2(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addDementiaProfessionalCareAddRadioItem3(){

  }

  /**
   * 認知症行動・心理症状緊急対応加算に内部項目を追加します。
   */
  protected void addDementiaEmergencyAddRadioGroup(){

  }

  /**
   * 認知症行動・心理症状緊急対応加算モデルに内部項目を追加します。
   */
  protected void addDementiaEmergencyAddRadioGroupModel(){

    getDementiaEmergencyAddRadioItem1().setButtonIndex(1);

    getDementiaEmergencyAddRadioGroupModel().add(getDementiaEmergencyAddRadioItem1());

    getDementiaEmergencyAddRadioItem2().setButtonIndex(2);

    getDementiaEmergencyAddRadioGroupModel().add(getDementiaEmergencyAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addDementiaEmergencyAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addDementiaEmergencyAddRadioItem2(){

  }

  /**
   * 重度認知症疾患療養体制加算に内部項目を追加します。
   */
  protected void addTreatmentSystemForSevereDementiaDiseaseRadioGroup(){

  }

  /**
   * 重度認知症疾患療養体制加算モデルに内部項目を追加します。
   */
  protected void addTreatmentSystemForSevereDementiaDiseaseRadioGroupModel(){

    getTreatmentSystemForSevereDementiaDiseaseItem1().setButtonIndex(1);

    getTreatmentSystemForSevereDementiaDiseaseRadioGroupModel().add(getTreatmentSystemForSevereDementiaDiseaseItem1());

    getTreatmentSystemForSevereDementiaDiseaseItem2().setButtonIndex(2);

    getTreatmentSystemForSevereDementiaDiseaseRadioGroupModel().add(getTreatmentSystemForSevereDementiaDiseaseItem2());

    getTreatmentSystemForSevereDementiaDiseaseItem3().setButtonIndex(3);

    getTreatmentSystemForSevereDementiaDiseaseRadioGroupModel().add(getTreatmentSystemForSevereDementiaDiseaseItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTreatmentSystemForSevereDementiaDiseaseItem1(){

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addTreatmentSystemForSevereDementiaDiseaseItem2(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addTreatmentSystemForSevereDementiaDiseaseItem3(){

  }

  /**
   * 移行定着支援加算に内部項目を追加します。
   */
  protected void addTransferFixingSupportRadio(){

  }

  /**
   * 移行定着支援加算モデルに内部項目を追加します。
   */
  protected void addTransferFixingSupportRadioModel(){

    getTransferFixingSupportItem1().setButtonIndex(1);

    getTransferFixingSupportRadioModel().add(getTransferFixingSupportItem1());

    getTransferFixingSupportItem2().setButtonIndex(2);

    getTransferFixingSupportRadioModel().add(getTransferFixingSupportItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTransferFixingSupportItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addTransferFixingSupportItem2(){

  }

  /**
   * 排せつ支援加算に内部項目を追加します。
   */
  protected void addExcretionSupport(){

  }

  /**
   * 排せつ支援加算モデルに内部項目を追加します。
   */
  protected void addExcretionSupportModel(){

    getExcretionSupportItem1().setButtonIndex(1);

    getExcretionSupportModel().add(getExcretionSupportItem1());

    getExcretionSupportItem2().setButtonIndex(2);

    getExcretionSupportModel().add(getExcretionSupportItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addExcretionSupportItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addExcretionSupportItem2(){

  }

  /**
   * サービス提供体制強化加算に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioGroup(){

  }

  /**
   * サービス提供体制強化加算モデルに内部項目を追加します。
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
   * なしに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem1(){

  }

  /**
   * Iイ型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem5(){

  }

  /**
   * Iロ型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem2(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem3(){

  }

  /**
   * III型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem4(){

  }

  /**
   * 食事コンテナに内部項目を追加します。
   */
  protected void addMedicalFacilityDinnerContainer(){

    medicalFacilityDinnerContainer.add(getMedicalFacilityDinnerOfferContainer(), VRLayout.FLOW);

    medicalFacilityDinnerContainer.add(getMedicalFacilityDinnerCostContainer(), VRLayout.FLOW);

  }

  /**
   * 食事提供に内部項目を追加します。
   */
  protected void addMedicalFacilityDinnerOffer(){

  }

  /**
   * 食事提供モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityDinnerOfferModel(){

  }

  /**
   * 食事費用に内部項目を追加します。
   */
  protected void addMedicalFacilityDinnerCost(){

  }

  /**
   * 算定区分に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalCalculationDivisionRadio(){

  }

  /**
   * 算定区分モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalCalculationDivisionRadioModel(){

    getMedicalFacilityHospitalCalculationDivisionRadioItem1().setButtonIndex(1);

    getMedicalFacilityHospitalCalculationDivisionRadioModel().add(getMedicalFacilityHospitalCalculationDivisionRadioItem1());

    getMedicalFacilityHospitalCalculationDivisionRadioItem2().setButtonIndex(2);

    getMedicalFacilityHospitalCalculationDivisionRadioModel().add(getMedicalFacilityHospitalCalculationDivisionRadioItem2());

  }

  /**
   * 通常に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalCalculationDivisionRadioItem1(){

  }

  /**
   * 加算のみに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalCalculationDivisionRadioItem2(){

  }

  /**
   * コンポーネントを初期化します。
   * @throws Exception 初期化例外
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
    //デフォルトデバッグ起動
    try {
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QS001_15511_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001_15511_201804Design getThis() {
    return this;
  }
}
