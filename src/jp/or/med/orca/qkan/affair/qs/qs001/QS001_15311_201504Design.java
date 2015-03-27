
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
 * 開発者: 樋口　雅彦
 * 作成日: 2015/02/19  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン介護療養型医療施設（病院） (QS001_15311_201504)
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
 * サービスパターン介護療養型医療施設（病院）画面項目デザイン(QS001_15311_201504) 
 */
public class QS001_15311_201504Design extends QS001ServicePanel {
  //GUIコンポーネント

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup medicalFacilityHospitalInstitutionDivisionRadio;

  private ACLabelContainer medicalFacilityHospitalInstitutionDivisionRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalInstitutionDivisionRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalHospitalInstitutionDivisionRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalHospitalInstitutionDivisionRadioItem2;

  private ACRadioButtonItem medicalFacilityHospitalHospitalInstitutionDivisionRadioItem3;

  private ACRadioButtonItem medicalFacilityHospitalHospitalInstitutionDivisionRadioItem4;

  private ACLabelContainer staffAssignmentDivisionContainer;

  private ACValueArrayRadioButtonGroup staffAssignment1Division;

  private ACListModelAdapter staffAssignment1DivisionModel;

  private ACRadioButtonItem staffAssignmentDivisionItem1;

  private ACRadioButtonItem staffAssignmentDivisionItem2;

  private ACRadioButtonItem staffAssignmentDivisionItem3;

  private ACRadioButtonItem staffAssignmentDivisionItem4;

  private ACRadioButtonItem staffAssignmentDivisionItem5;

  private ACRadioButtonItem staffAssignmentDivisionItem6;

  private ACValueArrayRadioButtonGroup staffAssignment2Division;

  private ACListModelAdapter staffAssignment2DivisionModel;

  private ACRadioButtonItem staffAssignmentDivisionItem7;

  private ACRadioButtonItem staffAssignmentDivisionItem8;

  private ACRadioButtonItem staffAssignmentDivisionItem9;

  private ACValueArrayRadioButtonGroup staffAssignment3Division;

  private ACListModelAdapter staffAssignment3DivisionModel;

  private ACRadioButtonItem staffAssignmentDivisionItem10;

  private ACRadioButtonItem staffAssignmentDivisionItem11;

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

  private ACRadioButtonItem medicalFacilityHospitalNightShiftSubtractionRadioItem3;

  private ACRadioButtonItem medicalFacilityHospitalNightShiftSubtractionRadioItem4;

  private ACRadioButtonItem medicalFacilityHospitalNightShiftSubtractionRadioItem6;

  private ACRadioButtonItem medicalFacilityHospitalNightShiftSubtractionRadioItem5;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup medicalFacilityHospitalEnvironmentalRadio;

  private ACLabelContainer medicalFacilityHospitalEnvironmentalRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalEnvironmentalRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalEnvironmentalRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalEnvironmentalRadioItem2;

  private ACRadioButtonItem medicalFacilityHospitalEnvironmentalRadioItem3;

  private ACValueArrayRadioButtonGroup medicalFacilityHospitalDoctorArrangeStandardRadio;

  private ACLabelContainer medicalFacilityHospitalDoctorArrangeStandardRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalDoctorArrangeStandardRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalDoctorArrangeStandardRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalDoctorArrangeStandardRadioItem2;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACValueArrayRadioButtonGroup medicalFacilityHospitalStayRadio;

  private ACLabelContainer medicalFacilityHospitalStayRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalStayRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalStayRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalStayRadioItem2;

  private ACValueArrayRadioButtonGroup medicalFacilityHospitalStandardRadio;

  private ACLabelContainer medicalFacilityHospitalStandardRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalStandardRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalStandardRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalStandardRadioItem2;

  private ACValueArrayRadioButtonGroup medicalFacilityHospitalMedicalExaminationRadio;

  private ACLabelContainer medicalFacilityHospitalMedicalExaminationRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalMedicalExaminationRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalMedicalExaminationRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalMedicalExaminationRadioItem2;

  private ACValueArrayRadioButtonGroup medicalFacilityHospitalNutritionRadio;

  private ACLabelContainer medicalFacilityHospitalNutritionRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalNutritionRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalNutritionRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalNutritionRadioItem2;

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

  private ACPanel tab3;

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

  private ACLabelContainer medicalFacilityHospitalHijoAddition;

  private ACIntegerCheckBox leavingHospitalPreConsultationAddition;

  private ACIntegerCheckBox leavingHospitalAfterConsultationAddition;

  private ACIntegerCheckBox leavingHospitalConsultationAddition;

  private ACIntegerCheckBox leavingHospitalDissemination;

  private ACIntegerCheckBox leavingHospitalCooperationAddition;

  private ACIntegerCheckBox leavingHospital;

  private ACMapBindButton medicalFacilityHospitalConsultationFee;

  private ACLabel medicalFacilityHospitalConsultationFeeLabel;

  private ACComboBox medicalFacilityHospitalSubstraction;

  private ACLabelContainer medicalFacilityHospitalSubstractionContainer;

  private ACComboBoxModelAdapter medicalFacilityHospitalSubstractionModel;

  private ACPanel tab4;

  private ACBackLabelContainer medicalFacilityDinnerContainer;

  private ACComboBox medicalFacilityDinnerOffer;

  private ACLabelContainer medicalFacilityDinnerOfferContainer;

  private ACComboBoxModelAdapter medicalFacilityDinnerOfferModel;

  private ACTextField medicalFacilityDinnerCost;

  private ACLabelContainer medicalFacilityDinnerCostContainer;

  private ACValueArrayRadioButtonGroup unitCareMaintenanceRadio;

  private ACLabelContainer unitCareMaintenanceRadioContainer;

  private ACListModelAdapter unitCareMaintenanceRadioModel;

  private ACRadioButtonItem unitCareMaintenanceRadioItem1;

  private ACRadioButtonItem unitCareMaintenanceRadioItem2;

  private ACValueArrayRadioButtonGroup bodyRestraintAbolitionRadio;

  private ACLabelContainer bodyRestraintAbolitionRadioContainer;

  private ACListModelAdapter bodyRestraintAbolitionRadioModel;

  private ACRadioButtonItem bodyRestraintAbolitionRadioItem1;

  private ACRadioButtonItem bodyRestraintAbolitionRadioItem2;

  private ACValueArrayRadioButtonGroup stayReturnSupportAddRadio;

  private ACLabelContainer stayReturnSupportAddRadioContainer;

  private ACListModelAdapter stayReturnSupportAddRadioModel;

  private ACRadioButtonItem stayReturnSupportAddRadioItem1;

  private ACRadioButtonItem stayReturnSupportAddRadioItem2;

  private ACValueArrayRadioButtonGroup trialHijoRadio;

  private ACLabelContainer trialHijoRadioContainer;

  private ACListModelAdapter trialHijoRadioModel;

  private ACRadioButtonItem trialHijoRadioItem1;

  private ACRadioButtonItem trialHijoRadioItem2;

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

      medicalFacilityHospitalInstitutionDivisionRadio.setBindPath("1530162");

      medicalFacilityHospitalInstitutionDivisionRadio.setNoSelectIndex(0);

      medicalFacilityHospitalInstitutionDivisionRadio.setUseClearButton(false);

      medicalFacilityHospitalInstitutionDivisionRadio.setModel(getMedicalFacilityHospitalInstitutionDivisionRadioModel());

      medicalFacilityHospitalInstitutionDivisionRadio.setValues(new int[]{1,2,3,4});

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
   * 病院を取得します。
   * @return 病院
   */
  public ACRadioButtonItem getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem1(){
    if(medicalFacilityHospitalHospitalInstitutionDivisionRadioItem1==null){

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem1.setText("病院");

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem1.setGroup(getMedicalFacilityHospitalInstitutionDivisionRadio());

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem1();
    }
    return medicalFacilityHospitalHospitalInstitutionDivisionRadioItem1;

  }

  /**
   * ユニット型病院を取得します。
   * @return ユニット型病院
   */
  public ACRadioButtonItem getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem2(){
    if(medicalFacilityHospitalHospitalInstitutionDivisionRadioItem2==null){

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem2.setText("ユニット型病院");

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem2.setGroup(getMedicalFacilityHospitalInstitutionDivisionRadio());

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem2();
    }
    return medicalFacilityHospitalHospitalInstitutionDivisionRadioItem2;

  }

  /**
   * 経過型を取得します。
   * @return 経過型
   */
  public ACRadioButtonItem getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem3(){
    if(medicalFacilityHospitalHospitalInstitutionDivisionRadioItem3==null){

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem3 = new ACRadioButtonItem();

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem3.setText("経過型");

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem3.setGroup(getMedicalFacilityHospitalInstitutionDivisionRadio());

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem3.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem3();
    }
    return medicalFacilityHospitalHospitalInstitutionDivisionRadioItem3;

  }

  /**
   * ユニット型経過型を取得します。
   * @return ユニット型経過型
   */
  public ACRadioButtonItem getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem4(){
    if(medicalFacilityHospitalHospitalInstitutionDivisionRadioItem4==null){

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem4 = new ACRadioButtonItem();

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem4.setText("ユニット型経過型");

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem4.setGroup(getMedicalFacilityHospitalInstitutionDivisionRadio());

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem4.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem4();
    }
    return medicalFacilityHospitalHospitalInstitutionDivisionRadioItem4;

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

      staffAssignment1Division.setBindPath("1530102");

      staffAssignment1Division.setUseClearButton(false);

      staffAssignment1Division.setModel(getStaffAssignment1DivisionModel());

      staffAssignment1Division.setValues(new int[]{1,2,3,4,5,6});

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
   * I型（強化型以外）を取得します。
   * @return I型（強化型以外）
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem1(){
    if(staffAssignmentDivisionItem1==null){

      staffAssignmentDivisionItem1 = new ACRadioButtonItem();

      staffAssignmentDivisionItem1.setText("I型(強化型以外)");

      staffAssignmentDivisionItem1.setGroup(getStaffAssignment1Division());

      staffAssignmentDivisionItem1.setConstraints(VRLayout.FLOW_RETURN);

      addStaffAssignmentDivisionItem1();
    }
    return staffAssignmentDivisionItem1;

  }

  /**
   * I型（強化型A）を取得します。
   * @return I型（強化型A）
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem2(){
    if(staffAssignmentDivisionItem2==null){

      staffAssignmentDivisionItem2 = new ACRadioButtonItem();

      staffAssignmentDivisionItem2.setText("I型(強化型A)");

      staffAssignmentDivisionItem2.setGroup(getStaffAssignment1Division());

      staffAssignmentDivisionItem2.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivisionItem2();
    }
    return staffAssignmentDivisionItem2;

  }

  /**
   * I型（強化型B）を取得します。
   * @return I型（強化型B）
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem3(){
    if(staffAssignmentDivisionItem3==null){

      staffAssignmentDivisionItem3 = new ACRadioButtonItem();

      staffAssignmentDivisionItem3.setText("I型(強化型B)");

      staffAssignmentDivisionItem3.setGroup(getStaffAssignment1Division());

      staffAssignmentDivisionItem3.setConstraints(VRLayout.FLOW_RETURN);

      addStaffAssignmentDivisionItem3();
    }
    return staffAssignmentDivisionItem3;

  }

  /**
   * II型（強化型以外）を取得します。
   * @return II型（強化型以外）
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem4(){
    if(staffAssignmentDivisionItem4==null){

      staffAssignmentDivisionItem4 = new ACRadioButtonItem();

      staffAssignmentDivisionItem4.setText("II型(強化型以外)");

      staffAssignmentDivisionItem4.setGroup(getStaffAssignment1Division());

      staffAssignmentDivisionItem4.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivisionItem4();
    }
    return staffAssignmentDivisionItem4;

  }

  /**
   * II型（強化型）を取得します。
   * @return II型（強化型）
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem5(){
    if(staffAssignmentDivisionItem5==null){

      staffAssignmentDivisionItem5 = new ACRadioButtonItem();

      staffAssignmentDivisionItem5.setText("II型(強化型)");

      staffAssignmentDivisionItem5.setGroup(getStaffAssignment1Division());

      staffAssignmentDivisionItem5.setConstraints(VRLayout.FLOW_RETURN);

      addStaffAssignmentDivisionItem5();
    }
    return staffAssignmentDivisionItem5;

  }

  /**
   * III型を取得します。
   * @return III型
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem6(){
    if(staffAssignmentDivisionItem6==null){

      staffAssignmentDivisionItem6 = new ACRadioButtonItem();

      staffAssignmentDivisionItem6.setText("III型");

      staffAssignmentDivisionItem6.setGroup(getStaffAssignment1Division());

      staffAssignmentDivisionItem6.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivisionItem6();
    }
    return staffAssignmentDivisionItem6;

  }

  /**
   * 人員配置区分を取得します。
   * @return 人員配置区分
   */
  public ACValueArrayRadioButtonGroup getStaffAssignment2Division(){
    if(staffAssignment2Division==null){

      staffAssignment2Division = new ACValueArrayRadioButtonGroup();

      staffAssignment2Division.setBindPath("1530121");

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
   * 強化型以外を取得します。
   * @return 強化型以外
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem7(){
    if(staffAssignmentDivisionItem7==null){

      staffAssignmentDivisionItem7 = new ACRadioButtonItem();

      staffAssignmentDivisionItem7.setText("強化型以外");

      staffAssignmentDivisionItem7.setGroup(getStaffAssignment2Division());

      staffAssignmentDivisionItem7.setConstraints(VRLayout.FLOW_RETURN);

      addStaffAssignmentDivisionItem7();
    }
    return staffAssignmentDivisionItem7;

  }

  /**
   * 強化型Aを取得します。
   * @return 強化型A
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem8(){
    if(staffAssignmentDivisionItem8==null){

      staffAssignmentDivisionItem8 = new ACRadioButtonItem();

      staffAssignmentDivisionItem8.setText("強化型A");

      staffAssignmentDivisionItem8.setGroup(getStaffAssignment2Division());

      staffAssignmentDivisionItem8.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivisionItem8();
    }
    return staffAssignmentDivisionItem8;

  }

  /**
   * 強化型Bを取得します。
   * @return 強化型B
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem9(){
    if(staffAssignmentDivisionItem9==null){

      staffAssignmentDivisionItem9 = new ACRadioButtonItem();

      staffAssignmentDivisionItem9.setText("強化型B");

      staffAssignmentDivisionItem9.setGroup(getStaffAssignment2Division());

      staffAssignmentDivisionItem9.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivisionItem9();
    }
    return staffAssignmentDivisionItem9;

  }

  /**
   * 人員配置区分を取得します。
   * @return 人員配置区分
   */
  public ACValueArrayRadioButtonGroup getStaffAssignment3Division(){
    if(staffAssignment3Division==null){

      staffAssignment3Division = new ACValueArrayRadioButtonGroup();

      staffAssignment3Division.setBindPath("1530122");

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
  public ACRadioButtonItem getStaffAssignmentDivisionItem10(){
    if(staffAssignmentDivisionItem10==null){

      staffAssignmentDivisionItem10 = new ACRadioButtonItem();

      staffAssignmentDivisionItem10.setText("I 型");

      staffAssignmentDivisionItem10.setGroup(getStaffAssignment3Division());

      staffAssignmentDivisionItem10.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivisionItem10();
    }
    return staffAssignmentDivisionItem10;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem11(){
    if(staffAssignmentDivisionItem11==null){

      staffAssignmentDivisionItem11 = new ACRadioButtonItem();

      staffAssignmentDivisionItem11.setText("II 型");

      staffAssignmentDivisionItem11.setGroup(getStaffAssignment3Division());

      staffAssignmentDivisionItem11.setConstraints(VRLayout.FLOW_RETURN);

      addStaffAssignmentDivisionItem11();
    }
    return staffAssignmentDivisionItem11;

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

      medicalFacilityHospitalHospitalRoomRadio.setBindPath("1530103");

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

      medicalFacilityHospitalUnitHospitalRoomRadio.setBindPath("1530104");

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

      medicalFacilityHospitalUnitHospitalRoomRadioItem1.setText("ユニット型個室");

      medicalFacilityHospitalUnitHospitalRoomRadioItem1.setGroup(getMedicalFacilityHospitalUnitHospitalRoomRadio());

      medicalFacilityHospitalUnitHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalUnitHospitalRoomRadioItem1();
    }
    return medicalFacilityHospitalUnitHospitalRoomRadioItem1;

  }

  /**
   * ユニット型準個室を取得します。
   * @return ユニット型準個室
   */
  public ACRadioButtonItem getMedicalFacilityHospitalUnitHospitalRoomRadioItem2(){
    if(medicalFacilityHospitalUnitHospitalRoomRadioItem2==null){

      medicalFacilityHospitalUnitHospitalRoomRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalUnitHospitalRoomRadioItem2.setText("ユニット型準個室");

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

      getMedicalFacilityHospitalNightShiftSubtractionRadioContainer().setText("夜間勤務" + ACConstants.LINE_SEPARATOR + "条件基準");

      medicalFacilityHospitalNightShiftSubtractionRadio.setBindPath("1530163");

      medicalFacilityHospitalNightShiftSubtractionRadio.setNoSelectIndex(0);

      medicalFacilityHospitalNightShiftSubtractionRadio.setUseClearButton(false);

      medicalFacilityHospitalNightShiftSubtractionRadio.setModel(getMedicalFacilityHospitalNightShiftSubtractionRadioModel());

      medicalFacilityHospitalNightShiftSubtractionRadio.setValues(new int[]{1,2,3,4,6,5});

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
   * 加算型Iを取得します。
   * @return 加算型I
   */
  public ACRadioButtonItem getMedicalFacilityHospitalNightShiftSubtractionRadioItem2(){
    if(medicalFacilityHospitalNightShiftSubtractionRadioItem2==null){

      medicalFacilityHospitalNightShiftSubtractionRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalNightShiftSubtractionRadioItem2.setText("加算型I");

      medicalFacilityHospitalNightShiftSubtractionRadioItem2.setGroup(getMedicalFacilityHospitalNightShiftSubtractionRadio());

      medicalFacilityHospitalNightShiftSubtractionRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalNightShiftSubtractionRadioItem2();
    }
    return medicalFacilityHospitalNightShiftSubtractionRadioItem2;

  }

  /**
   * 加算型IIを取得します。
   * @return 加算型II
   */
  public ACRadioButtonItem getMedicalFacilityHospitalNightShiftSubtractionRadioItem3(){
    if(medicalFacilityHospitalNightShiftSubtractionRadioItem3==null){

      medicalFacilityHospitalNightShiftSubtractionRadioItem3 = new ACRadioButtonItem();

      medicalFacilityHospitalNightShiftSubtractionRadioItem3.setText("加算型II");

      medicalFacilityHospitalNightShiftSubtractionRadioItem3.setGroup(getMedicalFacilityHospitalNightShiftSubtractionRadio());

      medicalFacilityHospitalNightShiftSubtractionRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addMedicalFacilityHospitalNightShiftSubtractionRadioItem3();
    }
    return medicalFacilityHospitalNightShiftSubtractionRadioItem3;

  }

  /**
   * 加算型IIIを取得します。
   * @return 加算型III
   */
  public ACRadioButtonItem getMedicalFacilityHospitalNightShiftSubtractionRadioItem4(){
    if(medicalFacilityHospitalNightShiftSubtractionRadioItem4==null){

      medicalFacilityHospitalNightShiftSubtractionRadioItem4 = new ACRadioButtonItem();

      medicalFacilityHospitalNightShiftSubtractionRadioItem4.setText("加算型III");

      medicalFacilityHospitalNightShiftSubtractionRadioItem4.setGroup(getMedicalFacilityHospitalNightShiftSubtractionRadio());

      medicalFacilityHospitalNightShiftSubtractionRadioItem4.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalNightShiftSubtractionRadioItem4();
    }
    return medicalFacilityHospitalNightShiftSubtractionRadioItem4;

  }

  /**
   * 加算型IVを取得します。
   * @return 加算型IV
   */
  public ACRadioButtonItem getMedicalFacilityHospitalNightShiftSubtractionRadioItem6(){
    if(medicalFacilityHospitalNightShiftSubtractionRadioItem6==null){

      medicalFacilityHospitalNightShiftSubtractionRadioItem6 = new ACRadioButtonItem();

      medicalFacilityHospitalNightShiftSubtractionRadioItem6.setText("加算型IV");

      medicalFacilityHospitalNightShiftSubtractionRadioItem6.setGroup(getMedicalFacilityHospitalNightShiftSubtractionRadio());

      medicalFacilityHospitalNightShiftSubtractionRadioItem6.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalNightShiftSubtractionRadioItem6();
    }
    return medicalFacilityHospitalNightShiftSubtractionRadioItem6;

  }

  /**
   * 減算型を取得します。
   * @return 減算型
   */
  public ACRadioButtonItem getMedicalFacilityHospitalNightShiftSubtractionRadioItem5(){
    if(medicalFacilityHospitalNightShiftSubtractionRadioItem5==null){

      medicalFacilityHospitalNightShiftSubtractionRadioItem5 = new ACRadioButtonItem();

      medicalFacilityHospitalNightShiftSubtractionRadioItem5.setText("減算型");

      medicalFacilityHospitalNightShiftSubtractionRadioItem5.setGroup(getMedicalFacilityHospitalNightShiftSubtractionRadio());

      medicalFacilityHospitalNightShiftSubtractionRadioItem5.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalNightShiftSubtractionRadioItem5();
    }
    return medicalFacilityHospitalNightShiftSubtractionRadioItem5;

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
   * 療養環境基準を取得します。
   * @return 療養環境基準
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityHospitalEnvironmentalRadio(){
    if(medicalFacilityHospitalEnvironmentalRadio==null){

      medicalFacilityHospitalEnvironmentalRadio = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityHospitalEnvironmentalRadioContainer().setText("療養環境基準");

      medicalFacilityHospitalEnvironmentalRadio.setBindPath("1530168");

      medicalFacilityHospitalEnvironmentalRadio.setUseClearButton(false);

      medicalFacilityHospitalEnvironmentalRadio.setModel(getMedicalFacilityHospitalEnvironmentalRadioModel());

      medicalFacilityHospitalEnvironmentalRadio.setValues(new int[]{1,2,3});

      addMedicalFacilityHospitalEnvironmentalRadio();
    }
    return medicalFacilityHospitalEnvironmentalRadio;

  }

  /**
   * 療養環境基準コンテナを取得します。
   * @return 療養環境基準コンテナ
   */
  protected ACLabelContainer getMedicalFacilityHospitalEnvironmentalRadioContainer(){
    if(medicalFacilityHospitalEnvironmentalRadioContainer==null){
      medicalFacilityHospitalEnvironmentalRadioContainer = new ACLabelContainer();
      medicalFacilityHospitalEnvironmentalRadioContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalEnvironmentalRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalEnvironmentalRadioContainer.add(getMedicalFacilityHospitalEnvironmentalRadio(), null);
    }
    return medicalFacilityHospitalEnvironmentalRadioContainer;
  }

  /**
   * 療養環境基準モデルを取得します。
   * @return 療養環境基準モデル
   */
  protected ACListModelAdapter getMedicalFacilityHospitalEnvironmentalRadioModel(){
    if(medicalFacilityHospitalEnvironmentalRadioModel==null){
      medicalFacilityHospitalEnvironmentalRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalEnvironmentalRadioModel();
    }
    return medicalFacilityHospitalEnvironmentalRadioModel;
  }

  /**
   * 基準型を取得します。
   * @return 基準型
   */
  public ACRadioButtonItem getMedicalFacilityHospitalEnvironmentalRadioItem1(){
    if(medicalFacilityHospitalEnvironmentalRadioItem1==null){

      medicalFacilityHospitalEnvironmentalRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalEnvironmentalRadioItem1.setText("基準型");

      medicalFacilityHospitalEnvironmentalRadioItem1.setGroup(getMedicalFacilityHospitalEnvironmentalRadio());

      medicalFacilityHospitalEnvironmentalRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalEnvironmentalRadioItem1();
    }
    return medicalFacilityHospitalEnvironmentalRadioItem1;

  }

  /**
   * 減算型を取得します。
   * @return 減算型
   */
  public ACRadioButtonItem getMedicalFacilityHospitalEnvironmentalRadioItem2(){
    if(medicalFacilityHospitalEnvironmentalRadioItem2==null){

      medicalFacilityHospitalEnvironmentalRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalEnvironmentalRadioItem2.setText("減算型");

      medicalFacilityHospitalEnvironmentalRadioItem2.setGroup(getMedicalFacilityHospitalEnvironmentalRadio());

      medicalFacilityHospitalEnvironmentalRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalEnvironmentalRadioItem2();
    }
    return medicalFacilityHospitalEnvironmentalRadioItem2;

  }

  /**
   * 減算型IIIを取得します。
   * @return 減算型III
   */
  public ACRadioButtonItem getMedicalFacilityHospitalEnvironmentalRadioItem3(){
    if(medicalFacilityHospitalEnvironmentalRadioItem3==null){

      medicalFacilityHospitalEnvironmentalRadioItem3 = new ACRadioButtonItem();

      medicalFacilityHospitalEnvironmentalRadioItem3.setText("減算型III");

      medicalFacilityHospitalEnvironmentalRadioItem3.setGroup(getMedicalFacilityHospitalEnvironmentalRadio());

      medicalFacilityHospitalEnvironmentalRadioItem3.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalEnvironmentalRadioItem3();
    }
    return medicalFacilityHospitalEnvironmentalRadioItem3;

  }

  /**
   * 医師の配置基準を取得します。
   * @return 医師の配置基準
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityHospitalDoctorArrangeStandardRadio(){
    if(medicalFacilityHospitalDoctorArrangeStandardRadio==null){

      medicalFacilityHospitalDoctorArrangeStandardRadio = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityHospitalDoctorArrangeStandardRadioContainer().setText("医師の配置基準");

      medicalFacilityHospitalDoctorArrangeStandardRadio.setBindPath("1530107");

      medicalFacilityHospitalDoctorArrangeStandardRadio.setUseClearButton(false);

      medicalFacilityHospitalDoctorArrangeStandardRadio.setModel(getMedicalFacilityHospitalDoctorArrangeStandardRadioModel());

      medicalFacilityHospitalDoctorArrangeStandardRadio.setValues(new int[]{1,2});

      addMedicalFacilityHospitalDoctorArrangeStandardRadio();
    }
    return medicalFacilityHospitalDoctorArrangeStandardRadio;

  }

  /**
   * 医師の配置基準コンテナを取得します。
   * @return 医師の配置基準コンテナ
   */
  protected ACLabelContainer getMedicalFacilityHospitalDoctorArrangeStandardRadioContainer(){
    if(medicalFacilityHospitalDoctorArrangeStandardRadioContainer==null){
      medicalFacilityHospitalDoctorArrangeStandardRadioContainer = new ACLabelContainer();
      medicalFacilityHospitalDoctorArrangeStandardRadioContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalDoctorArrangeStandardRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalDoctorArrangeStandardRadioContainer.add(getMedicalFacilityHospitalDoctorArrangeStandardRadio(), null);
    }
    return medicalFacilityHospitalDoctorArrangeStandardRadioContainer;
  }

  /**
   * 医師の配置基準モデルを取得します。
   * @return 医師の配置基準モデル
   */
  protected ACListModelAdapter getMedicalFacilityHospitalDoctorArrangeStandardRadioModel(){
    if(medicalFacilityHospitalDoctorArrangeStandardRadioModel==null){
      medicalFacilityHospitalDoctorArrangeStandardRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalDoctorArrangeStandardRadioModel();
    }
    return medicalFacilityHospitalDoctorArrangeStandardRadioModel;
  }

  /**
   * 基準を取得します。
   * @return 基準
   */
  public ACRadioButtonItem getMedicalFacilityHospitalDoctorArrangeStandardRadioItem1(){
    if(medicalFacilityHospitalDoctorArrangeStandardRadioItem1==null){

      medicalFacilityHospitalDoctorArrangeStandardRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalDoctorArrangeStandardRadioItem1.setText("基準");

      medicalFacilityHospitalDoctorArrangeStandardRadioItem1.setGroup(getMedicalFacilityHospitalDoctorArrangeStandardRadio());

      medicalFacilityHospitalDoctorArrangeStandardRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addMedicalFacilityHospitalDoctorArrangeStandardRadioItem1();
    }
    return medicalFacilityHospitalDoctorArrangeStandardRadioItem1;

  }

  /**
   * 医療法施行規則第49条適用を取得します。
   * @return 医療法施行規則第49条適用
   */
  public ACRadioButtonItem getMedicalFacilityHospitalDoctorArrangeStandardRadioItem2(){
    if(medicalFacilityHospitalDoctorArrangeStandardRadioItem2==null){

      medicalFacilityHospitalDoctorArrangeStandardRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalDoctorArrangeStandardRadioItem2.setText("医療法施行規則第49条適用");

      medicalFacilityHospitalDoctorArrangeStandardRadioItem2.setGroup(getMedicalFacilityHospitalDoctorArrangeStandardRadio());

      medicalFacilityHospitalDoctorArrangeStandardRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalDoctorArrangeStandardRadioItem2();
    }
    return medicalFacilityHospitalDoctorArrangeStandardRadioItem2;

  }

  /**
   * 若年性認知症患者受入加算を取得します。
   * @return 若年性認知症患者受入加算
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("若年性認知症患者受入加算");

      youngDementiaPatinetAddRadioGroup.setBindPath("1530164");

      youngDementiaPatinetAddRadioGroup.setNoSelectIndex(0);

      youngDementiaPatinetAddRadioGroup.setUseClearButton(false);

      youngDementiaPatinetAddRadioGroup.setModel(getYoungDementiaPatinetAddRadioGroupModel());

      youngDementiaPatinetAddRadioGroup.setValues(new int[]{1,2});

      addYoungDementiaPatinetAddRadioGroup();
    }
    return youngDementiaPatinetAddRadioGroup;

  }

  /**
   * 若年性認知症患者受入加算コンテナを取得します。
   * @return 若年性認知症患者受入加算コンテナ
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
   * 若年性認知症患者受入加算モデルを取得します。
   * @return 若年性認知症患者受入加算モデル
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
   * 外泊加算を取得します。
   * @return 外泊加算
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityHospitalStayRadio(){
    if(medicalFacilityHospitalStayRadio==null){

      medicalFacilityHospitalStayRadio = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityHospitalStayRadioContainer().setText("外泊加算");

      medicalFacilityHospitalStayRadio.setBindPath("1530108");

      medicalFacilityHospitalStayRadio.setUseClearButton(false);

      medicalFacilityHospitalStayRadio.setModel(getMedicalFacilityHospitalStayRadioModel());

      medicalFacilityHospitalStayRadio.setValues(new int[]{1,2});

      addMedicalFacilityHospitalStayRadio();
    }
    return medicalFacilityHospitalStayRadio;

  }

  /**
   * 外泊加算コンテナを取得します。
   * @return 外泊加算コンテナ
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
   * 外泊加算モデルを取得します。
   * @return 外泊加算モデル
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
   * 初期加算を取得します。
   * @return 初期加算
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityHospitalStandardRadio(){
    if(medicalFacilityHospitalStandardRadio==null){

      medicalFacilityHospitalStandardRadio = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityHospitalStandardRadioContainer().setText("初期加算");

      medicalFacilityHospitalStandardRadio.setBindPath("1530109");

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
   * 他科受診を取得します。
   * @return 他科受診
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityHospitalMedicalExaminationRadio(){
    if(medicalFacilityHospitalMedicalExaminationRadio==null){

      medicalFacilityHospitalMedicalExaminationRadio = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityHospitalMedicalExaminationRadioContainer().setText("他科受診加算");

      medicalFacilityHospitalMedicalExaminationRadio.setBindPath("1530110");

      medicalFacilityHospitalMedicalExaminationRadio.setUseClearButton(false);

      medicalFacilityHospitalMedicalExaminationRadio.setModel(getMedicalFacilityHospitalMedicalExaminationRadioModel());

      medicalFacilityHospitalMedicalExaminationRadio.setValues(new int[]{1,2});

      addMedicalFacilityHospitalMedicalExaminationRadio();
    }
    return medicalFacilityHospitalMedicalExaminationRadio;

  }

  /**
   * 他科受診コンテナを取得します。
   * @return 他科受診コンテナ
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
   * 他科受診モデルを取得します。
   * @return 他科受診モデル
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
   * 栄養マネジメント加算を取得します。
   * @return 栄養マネジメント加算
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityHospitalNutritionRadio(){
    if(medicalFacilityHospitalNutritionRadio==null){

      medicalFacilityHospitalNutritionRadio = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityHospitalNutritionRadioContainer().setText("栄養マネジメント加算");

      medicalFacilityHospitalNutritionRadio.setBindPath("1530112");

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
   * 経口移行加算を取得します。
   * @return 経口移行加算
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityHospitalOralSwitchRadio(){
    if(medicalFacilityHospitalOralSwitchRadio==null){

      medicalFacilityHospitalOralSwitchRadio = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityHospitalOralSwitchRadioContainer().setText("経口移行加算");

      medicalFacilityHospitalOralSwitchRadio.setBindPath("1530113");

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

      oralMaintenanceAdd.setBindPath("1530115");

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

      oralMaintenanceAddItem3.setBindPath("1530120");

      oralMaintenanceAddItem3.setSelectValue(2);

      oralMaintenanceAddItem3.setUnSelectValue(1);

      addOralMaintenanceAddItem3();
    }
    return oralMaintenanceAddItem3;

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
   * 口腔衛生管理体制加算を取得します。
   * @return 口腔衛生管理体制加算
   */
  public ACValueArrayRadioButtonGroup getOralKeepStructureAddRadioGroup(){
    if(oralKeepStructureAddRadioGroup==null){

      oralKeepStructureAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getOralKeepStructureAddRadioGroupContainer().setText("口腔衛生管理体制加算");

      oralKeepStructureAddRadioGroup.setBindPath("1530170");

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

      oralKeepAddRadioGroup.setBindPath("1530165");

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

      medicalFacilityHospitalRecuperateDinnerRadio.setBindPath("1530114");

      medicalFacilityHospitalRecuperateDinnerRadio.setUseClearButton(false);

      medicalFacilityHospitalRecuperateDinnerRadio.setModel(getMedicalFacilityHospitalRecuperateDinnerRadioModel());

      medicalFacilityHospitalRecuperateDinnerRadio.setValues(new int[]{1,2});

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
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMedicalFacilityHospitalRecuperateDinnerRadioItem2(){
    if(medicalFacilityHospitalRecuperateDinnerRadioItem2==null){

      medicalFacilityHospitalRecuperateDinnerRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalRecuperateDinnerRadioItem2.setText("あり");

      medicalFacilityHospitalRecuperateDinnerRadioItem2.setGroup(getMedicalFacilityHospitalRecuperateDinnerRadio());

      medicalFacilityHospitalRecuperateDinnerRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalRecuperateDinnerRadioItem2();
    }
    return medicalFacilityHospitalRecuperateDinnerRadioItem2;

  }

  /**
   * 退所関連加算を取得します。
   * @return 退所関連加算
   */
  public ACLabelContainer getMedicalFacilityHospitalHijoAddition(){
    if(medicalFacilityHospitalHijoAddition==null){

      medicalFacilityHospitalHijoAddition = new ACLabelContainer();

      medicalFacilityHospitalHijoAddition.setText("退院関連加算");

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

      leavingHospitalPreConsultationAddition.setText("退院前訪問指導加算");

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

      leavingHospitalAfterConsultationAddition.setText("退院後訪問指導加算");

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

      leavingHospitalConsultationAddition.setText("退院時指導加算");

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

      leavingHospitalDissemination.setText("退院時情報提供加算");

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

      leavingHospitalCooperationAddition.setText("退院前連携加算");

      leavingHospitalCooperationAddition.setBindPath("3020107");

      leavingHospitalCooperationAddition.setSelectValue(2);

      leavingHospitalCooperationAddition.setUnSelectValue(1);

      addLeavingHospitalCooperationAddition();
    }
    return leavingHospitalCooperationAddition;

  }

  /**
   * 老人訪問看護指示加算を取得します。
   * @return 老人訪問看護指示加算
   */
  public ACIntegerCheckBox getLeavingHospital(){
    if(leavingHospital==null){

      leavingHospital = new ACIntegerCheckBox();

      leavingHospital.setText("老人訪問看護指示加算");

      leavingHospital.setBindPath("3020108");

      leavingHospital.setSelectValue(2);

      leavingHospital.setUnSelectValue(1);

      addLeavingHospital();
    }
    return leavingHospital;

  }

  /**
   * 特定診療費を取得します。
   * @return 特定診療費
   */
  public ACMapBindButton getMedicalFacilityHospitalConsultationFee(){
    if(medicalFacilityHospitalConsultationFee==null){

      medicalFacilityHospitalConsultationFee = new ACMapBindButton();

      medicalFacilityHospitalConsultationFee.setText("特定診療費");

      medicalFacilityHospitalConsultationFee.setToolTipText("特定診療費を設定します。");

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
   * 人員減算を取得します。
   * @return 人員減算
   */
  public ACComboBox getMedicalFacilityHospitalSubstraction(){
    if(medicalFacilityHospitalSubstraction==null){

      medicalFacilityHospitalSubstraction = new ACComboBox();

      getMedicalFacilityHospitalSubstractionContainer().setText("人員減算");

      medicalFacilityHospitalSubstraction.setBindPath("1530158");

      medicalFacilityHospitalSubstraction.setEditable(false);

      medicalFacilityHospitalSubstraction.setModelBindPath("1530158");

      medicalFacilityHospitalSubstraction.setRenderBindPath("CONTENT");

      medicalFacilityHospitalSubstraction.setModel(getMedicalFacilityHospitalSubstractionModel());

      addMedicalFacilityHospitalSubstraction();
    }
    return medicalFacilityHospitalSubstraction;

  }

  /**
   * 人員減算コンテナを取得します。
   * @return 人員減算コンテナ
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
   * 人員減算モデルを取得します。
   * @return 人員減算モデル
   */
  protected ACComboBoxModelAdapter getMedicalFacilityHospitalSubstractionModel(){
    if(medicalFacilityHospitalSubstractionModel==null){
      medicalFacilityHospitalSubstractionModel = new ACComboBoxModelAdapter();
      addMedicalFacilityHospitalSubstractionModel();
    }
    return medicalFacilityHospitalSubstractionModel;
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

      medicalFacilityDinnerOffer.setBindPath("1530159");

      medicalFacilityDinnerOffer.setEditable(false);

      medicalFacilityDinnerOffer.setModelBindPath("1530159");

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

      medicalFacilityDinnerCost.setBindPath("1530161");

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
   * ユニットケアの整備を取得します。
   * @return ユニットケアの整備
   */
  public ACValueArrayRadioButtonGroup getUnitCareMaintenanceRadio(){
    if(unitCareMaintenanceRadio==null){

      unitCareMaintenanceRadio = new ACValueArrayRadioButtonGroup();

      getUnitCareMaintenanceRadioContainer().setText("ユニットケアの整備");

      unitCareMaintenanceRadio.setBindPath("1530116");

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
   * 身体拘束廃止未実施減算を取得します。
   * @return 身体拘束廃止未実施減算
   */
  public ACValueArrayRadioButtonGroup getBodyRestraintAbolitionRadio(){
    if(bodyRestraintAbolitionRadio==null){

      bodyRestraintAbolitionRadio = new ACValueArrayRadioButtonGroup();

      getBodyRestraintAbolitionRadioContainer().setText("身体拘束廃止未実施減算");

      bodyRestraintAbolitionRadio.setBindPath("1530117");

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
   * 在宅復帰支援機能加算を取得します。
   * @return 在宅復帰支援機能加算
   */
  public ACValueArrayRadioButtonGroup getStayReturnSupportAddRadio(){
    if(stayReturnSupportAddRadio==null){

      stayReturnSupportAddRadio = new ACValueArrayRadioButtonGroup();

      getStayReturnSupportAddRadioContainer().setText("在宅復帰支援機能加算");

      stayReturnSupportAddRadio.setBindPath("1530118");

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
   * 試行的退院サービス費を取得します。
   * @return 試行的退院サービス費
   */
  public ACValueArrayRadioButtonGroup getTrialHijoRadio(){
    if(trialHijoRadio==null){

      trialHijoRadio = new ACValueArrayRadioButtonGroup();

      getTrialHijoRadioContainer().setText("試行的退院サービス費");

      trialHijoRadio.setBindPath("1530119");

      trialHijoRadio.setUseClearButton(false);

      trialHijoRadio.setModel(getTrialHijoRadioModel());

      trialHijoRadio.setValues(new int[]{1,2});

      addTrialHijoRadio();
    }
    return trialHijoRadio;

  }

  /**
   * 試行的退院サービス費コンテナを取得します。
   * @return 試行的退院サービス費コンテナ
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
   * 試行的退院サービス費モデルを取得します。
   * @return 試行的退院サービス費モデル
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
   * 認知症専門ケア加算を取得します。
   * @return 認知症専門ケア加算
   */
  public ACValueArrayRadioButtonGroup getDementiaProfessionalCareAddRadioGroup(){
    if(dementiaProfessionalCareAddRadioGroup==null){

      dementiaProfessionalCareAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaProfessionalCareAddRadioGroupContainer().setText("認知症専門ケア加算");

      dementiaProfessionalCareAddRadioGroup.setBindPath("1530166");

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

      dementiaEmergencyAddRadioGroup.setBindPath("1530169");

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
   * サービス提供体制強化加算を取得します。
   * @return サービス提供体制強化加算
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("サービス提供体制強化加算");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1530167");

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
  public QS001_15311_201504Design() {

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

  }

  /**
   * タブ1に内部項目を追加します。
   */
  protected void addTab1(){

    tab1.add(getMedicalFacilityHospitalInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getStaffAssignmentDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityHospitalHospitalRoomContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityHospitalNightShiftSubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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

    getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem2().setButtonIndex(2);

    getMedicalFacilityHospitalInstitutionDivisionRadioModel().add(getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem2());

    getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem3().setButtonIndex(3);

    getMedicalFacilityHospitalInstitutionDivisionRadioModel().add(getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem3());

    getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem4().setButtonIndex(4);

    getMedicalFacilityHospitalInstitutionDivisionRadioModel().add(getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem4());

  }

  /**
   * 病院に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem1(){

  }

  /**
   * ユニット型病院に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem2(){

  }

  /**
   * 経過型に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem3(){

  }

  /**
   * ユニット型経過型に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem4(){

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

    getStaffAssignmentDivisionItem4().setButtonIndex(4);

    getStaffAssignment1DivisionModel().add(getStaffAssignmentDivisionItem4());

    getStaffAssignmentDivisionItem5().setButtonIndex(5);

    getStaffAssignment1DivisionModel().add(getStaffAssignmentDivisionItem5());

    getStaffAssignmentDivisionItem6().setButtonIndex(6);

    getStaffAssignment1DivisionModel().add(getStaffAssignmentDivisionItem6());

  }

  /**
   * I型（強化型以外）に内部項目を追加します。
   */
  protected void addStaffAssignmentDivisionItem1(){

  }

  /**
   * I型（強化型A）に内部項目を追加します。
   */
  protected void addStaffAssignmentDivisionItem2(){

  }

  /**
   * I型（強化型B）に内部項目を追加します。
   */
  protected void addStaffAssignmentDivisionItem3(){

  }

  /**
   * II型（強化型以外）に内部項目を追加します。
   */
  protected void addStaffAssignmentDivisionItem4(){

  }

  /**
   * II型（強化型）に内部項目を追加します。
   */
  protected void addStaffAssignmentDivisionItem5(){

  }

  /**
   * III型に内部項目を追加します。
   */
  protected void addStaffAssignmentDivisionItem6(){

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

    getStaffAssignmentDivisionItem7().setButtonIndex(1);

    getStaffAssignment2DivisionModel().add(getStaffAssignmentDivisionItem7());

    getStaffAssignmentDivisionItem8().setButtonIndex(2);

    getStaffAssignment2DivisionModel().add(getStaffAssignmentDivisionItem8());

    getStaffAssignmentDivisionItem9().setButtonIndex(3);

    getStaffAssignment2DivisionModel().add(getStaffAssignmentDivisionItem9());

  }

  /**
   * 強化型以外に内部項目を追加します。
   */
  protected void addStaffAssignmentDivisionItem7(){

  }

  /**
   * 強化型Aに内部項目を追加します。
   */
  protected void addStaffAssignmentDivisionItem8(){

  }

  /**
   * 強化型Bに内部項目を追加します。
   */
  protected void addStaffAssignmentDivisionItem9(){

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

    getStaffAssignmentDivisionItem10().setButtonIndex(1);

    getStaffAssignment3DivisionModel().add(getStaffAssignmentDivisionItem10());

    getStaffAssignmentDivisionItem11().setButtonIndex(2);

    getStaffAssignment3DivisionModel().add(getStaffAssignmentDivisionItem11());

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addStaffAssignmentDivisionItem10(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addStaffAssignmentDivisionItem11(){

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
   * ユニット型準個室に内部項目を追加します。
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

    getMedicalFacilityHospitalNightShiftSubtractionRadioItem3().setButtonIndex(3);

    getMedicalFacilityHospitalNightShiftSubtractionRadioModel().add(getMedicalFacilityHospitalNightShiftSubtractionRadioItem3());

    getMedicalFacilityHospitalNightShiftSubtractionRadioItem4().setButtonIndex(4);

    getMedicalFacilityHospitalNightShiftSubtractionRadioModel().add(getMedicalFacilityHospitalNightShiftSubtractionRadioItem4());

    getMedicalFacilityHospitalNightShiftSubtractionRadioItem6().setButtonIndex(6);

    getMedicalFacilityHospitalNightShiftSubtractionRadioModel().add(getMedicalFacilityHospitalNightShiftSubtractionRadioItem6());

    getMedicalFacilityHospitalNightShiftSubtractionRadioItem5().setButtonIndex(5);

    getMedicalFacilityHospitalNightShiftSubtractionRadioModel().add(getMedicalFacilityHospitalNightShiftSubtractionRadioItem5());

  }

  /**
   * 基準型に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalNightShiftSubtractionRadioItem1(){

  }

  /**
   * 加算型Iに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalNightShiftSubtractionRadioItem2(){

  }

  /**
   * 加算型IIに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalNightShiftSubtractionRadioItem3(){

  }

  /**
   * 加算型IIIに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalNightShiftSubtractionRadioItem4(){

  }

  /**
   * 加算型IVに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalNightShiftSubtractionRadioItem6(){

  }

  /**
   * 減算型に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalNightShiftSubtractionRadioItem5(){

  }

  /**
   * タブ2に内部項目を追加します。
   */
  protected void addTab2(){

    tab2.add(getMedicalFacilityHospitalEnvironmentalRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityHospitalDoctorArrangeStandardRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityHospitalStayRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityHospitalStandardRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityHospitalMedicalExaminationRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityHospitalNutritionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityHospitalOralSwitchRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getOralMaintenanceAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 療養環境基準に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalEnvironmentalRadio(){

  }

  /**
   * 療養環境基準モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalEnvironmentalRadioModel(){

    getMedicalFacilityHospitalEnvironmentalRadioItem1().setButtonIndex(1);

    getMedicalFacilityHospitalEnvironmentalRadioModel().add(getMedicalFacilityHospitalEnvironmentalRadioItem1());

    getMedicalFacilityHospitalEnvironmentalRadioItem2().setButtonIndex(2);

    getMedicalFacilityHospitalEnvironmentalRadioModel().add(getMedicalFacilityHospitalEnvironmentalRadioItem2());

    getMedicalFacilityHospitalEnvironmentalRadioItem3().setButtonIndex(3);

    getMedicalFacilityHospitalEnvironmentalRadioModel().add(getMedicalFacilityHospitalEnvironmentalRadioItem3());

  }

  /**
   * 基準型に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalEnvironmentalRadioItem1(){

  }

  /**
   * 減算型に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalEnvironmentalRadioItem2(){

  }

  /**
   * 減算型IIIに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalEnvironmentalRadioItem3(){

  }

  /**
   * 医師の配置基準に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalDoctorArrangeStandardRadio(){

  }

  /**
   * 医師の配置基準モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalDoctorArrangeStandardRadioModel(){

    getMedicalFacilityHospitalDoctorArrangeStandardRadioItem1().setButtonIndex(1);

    getMedicalFacilityHospitalDoctorArrangeStandardRadioModel().add(getMedicalFacilityHospitalDoctorArrangeStandardRadioItem1());

    getMedicalFacilityHospitalDoctorArrangeStandardRadioItem2().setButtonIndex(2);

    getMedicalFacilityHospitalDoctorArrangeStandardRadioModel().add(getMedicalFacilityHospitalDoctorArrangeStandardRadioItem2());

  }

  /**
   * 基準に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalDoctorArrangeStandardRadioItem1(){

  }

  /**
   * 医療法施行規則第49条適用に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalDoctorArrangeStandardRadioItem2(){

  }

  /**
   * 若年性認知症患者受入加算に内部項目を追加します。
   */
  protected void addYoungDementiaPatinetAddRadioGroup(){

  }

  /**
   * 若年性認知症患者受入加算モデルに内部項目を追加します。
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
   * 外泊加算に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalStayRadio(){

  }

  /**
   * 外泊加算モデルに内部項目を追加します。
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
   * 他科受診に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalMedicalExaminationRadio(){

  }

  /**
   * 他科受診モデルに内部項目を追加します。
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
   * タブ3に内部項目を追加します。
   */
  protected void addTab3(){

    tab3.add(getOralKeepStructureAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getOralKeepAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getMedicalFacilityHospitalRecuperateDinnerRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getMedicalFacilityHospitalHijoAddition(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getMedicalFacilityHospitalConsultationFee(), VRLayout.FLOW);

    tab3.add(getMedicalFacilityHospitalConsultationFeeLabel(), VRLayout.FLOW_RETURN);

    tab3.add(getMedicalFacilityHospitalSubstractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalRecuperateDinnerRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalRecuperateDinnerRadioItem2(){

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
   * 老人訪問看護指示加算に内部項目を追加します。
   */
  protected void addLeavingHospital(){

  }

  /**
   * 特定診療費に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalConsultationFee(){

  }

  /**
   * ラベルに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalConsultationFeeLabel(){

  }

  /**
   * 人員減算に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalSubstraction(){

  }

  /**
   * 人員減算モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalSubstractionModel(){

  }

  /**
   * タブ4に内部項目を追加します。
   */
  protected void addTab4(){

    tab4.add(getMedicalFacilityDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    tab4.add(getUnitCareMaintenanceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getBodyRestraintAbolitionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getStayReturnSupportAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getTrialHijoRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getDementiaProfessionalCareAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getDementiaEmergencyAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getMedicalFacilityHospitalCalculationDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * 試行的退院サービス費に内部項目を追加します。
   */
  protected void addTrialHijoRadio(){

  }

  /**
   * 試行的退院サービス費モデルに内部項目を追加します。
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
      ACFrame.debugStart(new ACAffairInfo(QS001_15311_201504Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001_15311_201504Design getThis() {
    return this;
  }
}
