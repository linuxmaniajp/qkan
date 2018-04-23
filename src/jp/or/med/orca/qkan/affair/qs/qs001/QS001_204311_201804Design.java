
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
 * 開発者: 日高　しのぶ
 * 作成日: 2018/02/17  日本コンピューター株式会社 日高　しのぶ 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン短期入所療養介護（介護医療院） (QS001_204311_201804)
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
 * サービスパターン短期入所療養介護（介護医療院）画面項目デザイン(QS001_204311_201804) 
 */
public class QS001_204311_201804Design extends QS001ServicePanel {
  //GUIコンポーネント

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup shortStayHospitalRecuperationInstitutionDivisionRadio;

  private ACLabelContainer shortStayHospitalRecuperationInstitutionDivisionRadioContainer;

  private ACListModelAdapter shortStayHospitalRecuperationInstitutionDivisionRadioModel;

  private ACRadioButtonItem shortStayHospitalRecuperationInstitutionDivisionRadioItem1;

  private ACRadioButtonItem shortStayHospitalRecuperationInstitutionDivisionRadioItem2;

  private ACRadioButtonItem shortStayHospitalRecuperationInstitutionDivisionRadioItem3;

  private ACRadioButtonItem shortStayHospitalRecuperationInstitutionDivisionRadioItem4;

  private ACRadioButtonItem shortStayHospitalRecuperationInstitutionDivisionRadioItem5;

  private ACRadioButtonItem shortStayHospitalRecuperationInstitutionDivisionRadioItem6;

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

  private ACLabelContainer shortStayHospitalRecuperationHospitalRoomContena;

  private ACValueArrayRadioButtonGroup shortStayHospitalRecuperationHospitalRoomRadio;

  private ACListModelAdapter shortStayHospitalRecuperationHospitalRoomRadioModel;

  private ACRadioButtonItem shortStayHospitalRecuperationHospitalRoomRadioItem1;

  private ACRadioButtonItem shortStayHospitalRecuperationHospitalRoomRadioItem2;

  private ACValueArrayRadioButtonGroup shortStayHospitalRecuperationUnitHospitalRoomRadio;

  private ACListModelAdapter shortStayHospitalRecuperationUnitHospitalRoomRadioModel;

  private ACRadioButtonItem shortStayHospitalRecuperationUnitHospitalRoomRadioItem1;

  private ACRadioButtonItem shortStayHospitalRecuperationUnitHospitalRoomRadioItem2;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup shortStayHospitalRecuperationUnitCareMaintenanceRadio;

  private ACLabelContainer shortStayHospitalRecuperationUnitCareMaintenanceRadioContainer;

  private ACListModelAdapter shortStayHospitalRecuperationUnitCareMaintenanceRadioModel;

  private ACRadioButtonItem shortStayHospitalRecuperationUnitCareMaintenanceRadioItem1;

  private ACRadioButtonItem shortStayHospitalRecuperationUnitCareMaintenanceRadioItem2;

  private ACValueArrayRadioButtonGroup shortStayHospitalRecuperationAdditionType;

  private ACLabelContainer shortStayHospitalRecuperationAdditionTypeContainer;

  private ACListModelAdapter shortStayHospitalRecuperationAdditionTypeModel;

  private ACRadioButtonItem shortStayHospitalRecuperationAdditionType1;

  private ACRadioButtonItem shortStayHospitalRecuperationAdditionType2;

  private ACRadioButtonItem shortStayHospitalRecuperationAdditionType3;

  private ACRadioButtonItem shortStayHospitalRecuperationAdditionType4;

  private ACRadioButtonItem shortStayHospitalRecuperationAdditionType5;

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

  private ACValueArrayRadioButtonGroup shortStayHospitalRecuperationType;

  private ACLabelContainer shortStayHospitalRecuperationTypeContainer;

  private ACListModelAdapter shortStayHospitalRecuperationTypeModel;

  private ACRadioButtonItem shortStayHospitalRecuperationTypeNormal;

  private ACRadioButtonItem shortStayHospitalRecuperationTypeNone;

  private ACValueArrayRadioButtonGroup medicalFacilityHospitalSubstraction;

  private ACLabelContainer medicalFacilityHospitalSubstractionContainer;

  private ACListModelAdapter medicalFacilityHospitalSubstractionModel;

  private ACRadioButtonItem medicalFacilityHospitalSubstractionItem1;

  private ACRadioButtonItem medicalFacilityHospitalSubstractionItem2;

  private ACRadioButtonItem medicalFacilityHospitalSubstractionItem3;

  private ACRadioButtonItem medicalFacilityHospitalSubstractionItem4;

  private ACPanel tab3;

  private ACValueArrayRadioButtonGroup dementiaActionAddRadioGroup;

  private ACLabelContainer dementiaActionAddRadioGroupContainer;

  private ACListModelAdapter dementiaActionAddRadioGroupModel;

  private ACRadioButtonItem dementiaActionAddRadioItem1;

  private ACRadioButtonItem dementiaActionAddRadioItem2;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACValueArrayRadioButtonGroup shortStayHospitalRecuperationMeetingAndSendingOff;

  private ACLabelContainer shortStayHospitalRecuperationMeetingAndSendingOffContainer;

  private ACListModelAdapter shortStayHospitalRecuperationMeetingAndSendingOffModel;

  private ACRadioButtonItem shortStayHospitalRecuperationMeetingAndSendingOffNone;

  private ACRadioButtonItem shortStayHospitalRecuperationMeetingAndSendingOffOneWay;

  private ACRadioButtonItem shortStayHospitalRecuperationMeetingAndSendingOffRoundTrip;

  private ACValueArrayRadioButtonGroup shortStayHospitalRecuperationMedicalExpensesRadio;

  private ACLabelContainer shortStayHospitalRecuperationMedicalExpensesRadioContainer;

  private ACListModelAdapter shortStayHospitalRecuperationMedicalExpensesRadioModel;

  private ACRadioButtonItem shortStayHospitalRecuperationMedicalExpensesRadioItem1;

  private ACRadioButtonItem shortStayHospitalRecuperationMedicalExpensesRadioItem2;

  private ACRadioButtonItem shortStayHospitalRecuperationMedicalExpensesRadioItem3;

  private ACRadioButtonItem shortStayHospitalRecuperationMedicalExpensesRadioItem4;

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

  private ACPanel tab4;

  private ACMapBindButton shortStayHospitalRecuperationSpecificConsultationFee;

  private ACLabel shortStayHospitalRecuperationSpecificConsultationFeeOutline;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem5;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACBackLabelContainer shortStayRecuperationHealthFacilityDinnerContainer;

  private ACComboBox shortStayRecuperationHealthFacilityDinnerOffer;

  private ACLabelContainer shortStayRecuperationHealthFacilityDinnerOfferContainer;

  private ACComboBoxModelAdapter shortStayRecuperationHealthFacilityDinnerOfferModel;

  private ACTextField shortStayRecuperationHealthFacilityDinnerCost;

  private ACLabelContainer shortStayRecuperationHealthFacilityDinnerCostContainer;

  private ACIntegerCheckBox shortStayHospitalRecuperationEtc30Over;

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
  public ACValueArrayRadioButtonGroup getShortStayHospitalRecuperationInstitutionDivisionRadio(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadio==null){

      shortStayHospitalRecuperationInstitutionDivisionRadio = new ACValueArrayRadioButtonGroup();

      getShortStayHospitalRecuperationInstitutionDivisionRadioContainer().setText("施設等の区分");

      shortStayHospitalRecuperationInstitutionDivisionRadio.setBindPath("20430101");

      shortStayHospitalRecuperationInstitutionDivisionRadio.setNoSelectIndex(0);

      shortStayHospitalRecuperationInstitutionDivisionRadio.setUseClearButton(false);

      shortStayHospitalRecuperationInstitutionDivisionRadio.setModel(getShortStayHospitalRecuperationInstitutionDivisionRadioModel());

      shortStayHospitalRecuperationInstitutionDivisionRadio.setValues(new int[]{1,2,3,4,5,6});

      addShortStayHospitalRecuperationInstitutionDivisionRadio();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadio;

  }

  /**
   * 施設等の区分コンテナを取得します。
   * @return 施設等の区分コンテナ
   */
  protected ACLabelContainer getShortStayHospitalRecuperationInstitutionDivisionRadioContainer(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioContainer==null){
      shortStayHospitalRecuperationInstitutionDivisionRadioContainer = new ACLabelContainer();
      shortStayHospitalRecuperationInstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationInstitutionDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayHospitalRecuperationInstitutionDivisionRadioContainer.add(getShortStayHospitalRecuperationInstitutionDivisionRadio(), null);
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioContainer;
  }

  /**
   * 施設等の区分モデルを取得します。
   * @return 施設等の区分モデル
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationInstitutionDivisionRadioModel(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioModel==null){
      shortStayHospitalRecuperationInstitutionDivisionRadioModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationInstitutionDivisionRadioModel();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioModel;
  }

  /**
   * I型介護医療院を取得します。
   * @return I型介護医療院
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationInstitutionDivisionRadioItem1(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioItem1==null){

      shortStayHospitalRecuperationInstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationInstitutionDivisionRadioItem1.setText("I型介護医療院");

      shortStayHospitalRecuperationInstitutionDivisionRadioItem1.setGroup(getShortStayHospitalRecuperationInstitutionDivisionRadio());

      shortStayHospitalRecuperationInstitutionDivisionRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayHospitalRecuperationInstitutionDivisionRadioItem1();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioItem1;

  }

  /**
   * II型介護医療院を取得します。
   * @return II型介護医療院
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationInstitutionDivisionRadioItem2(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioItem2==null){

      shortStayHospitalRecuperationInstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationInstitutionDivisionRadioItem2.setText("II型介護医療院");

      shortStayHospitalRecuperationInstitutionDivisionRadioItem2.setGroup(getShortStayHospitalRecuperationInstitutionDivisionRadio());

      shortStayHospitalRecuperationInstitutionDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayHospitalRecuperationInstitutionDivisionRadioItem2();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioItem2;

  }

  /**
   * 特別介護医療院を取得します。
   * @return 特別介護医療院
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationInstitutionDivisionRadioItem3(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioItem3==null){

      shortStayHospitalRecuperationInstitutionDivisionRadioItem3 = new ACRadioButtonItem();

      shortStayHospitalRecuperationInstitutionDivisionRadioItem3.setText("特別介護医療院");

      shortStayHospitalRecuperationInstitutionDivisionRadioItem3.setGroup(getShortStayHospitalRecuperationInstitutionDivisionRadio());

      shortStayHospitalRecuperationInstitutionDivisionRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayHospitalRecuperationInstitutionDivisionRadioItem3();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioItem3;

  }

  /**
   * ユニット型I型介護医療院を取得します。
   * @return ユニット型I型介護医療院
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationInstitutionDivisionRadioItem4(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioItem4==null){

      shortStayHospitalRecuperationInstitutionDivisionRadioItem4 = new ACRadioButtonItem();

      shortStayHospitalRecuperationInstitutionDivisionRadioItem4.setText("ユニット型I型介護医療院");

      shortStayHospitalRecuperationInstitutionDivisionRadioItem4.setGroup(getShortStayHospitalRecuperationInstitutionDivisionRadio());

      shortStayHospitalRecuperationInstitutionDivisionRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayHospitalRecuperationInstitutionDivisionRadioItem4();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioItem4;

  }

  /**
   * ユニット型II型介護医療院を取得します。
   * @return ユニット型II型介護医療院
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationInstitutionDivisionRadioItem5(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioItem5==null){

      shortStayHospitalRecuperationInstitutionDivisionRadioItem5 = new ACRadioButtonItem();

      shortStayHospitalRecuperationInstitutionDivisionRadioItem5.setText("ユニット型II型介護医療院");

      shortStayHospitalRecuperationInstitutionDivisionRadioItem5.setGroup(getShortStayHospitalRecuperationInstitutionDivisionRadio());

      shortStayHospitalRecuperationInstitutionDivisionRadioItem5.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayHospitalRecuperationInstitutionDivisionRadioItem5();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioItem5;

  }

  /**
   * ユニット型特別介護医療院を取得します。
   * @return ユニット型特別介護医療院
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationInstitutionDivisionRadioItem6(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioItem6==null){

      shortStayHospitalRecuperationInstitutionDivisionRadioItem6 = new ACRadioButtonItem();

      shortStayHospitalRecuperationInstitutionDivisionRadioItem6.setText("ユニット型特別介護医療院");

      shortStayHospitalRecuperationInstitutionDivisionRadioItem6.setGroup(getShortStayHospitalRecuperationInstitutionDivisionRadio());

      shortStayHospitalRecuperationInstitutionDivisionRadioItem6.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayHospitalRecuperationInstitutionDivisionRadioItem6();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioItem6;

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

      staffAssignment1Division.setBindPath("20430102");

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

      staffAssignment2Division.setBindPath("20430103");

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

      staffAssignment3Division.setBindPath("20430104");

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
  public ACLabelContainer getShortStayHospitalRecuperationHospitalRoomContena(){
    if(shortStayHospitalRecuperationHospitalRoomContena==null){

      shortStayHospitalRecuperationHospitalRoomContena = new ACLabelContainer();

      shortStayHospitalRecuperationHospitalRoomContena.setText("病室区分");

      shortStayHospitalRecuperationHospitalRoomContena.setFollowChildEnabled(true);

      addShortStayHospitalRecuperationHospitalRoomContena();
    }
    return shortStayHospitalRecuperationHospitalRoomContena;

  }

  /**
   * 病室区分（病室）を取得します。
   * @return 病室区分（病室）
   */
  public ACValueArrayRadioButtonGroup getShortStayHospitalRecuperationHospitalRoomRadio(){
    if(shortStayHospitalRecuperationHospitalRoomRadio==null){

      shortStayHospitalRecuperationHospitalRoomRadio = new ACValueArrayRadioButtonGroup();

      shortStayHospitalRecuperationHospitalRoomRadio.setBindPath("20430105");

      shortStayHospitalRecuperationHospitalRoomRadio.setUseClearButton(false);

      shortStayHospitalRecuperationHospitalRoomRadio.setModel(getShortStayHospitalRecuperationHospitalRoomRadioModel());

      shortStayHospitalRecuperationHospitalRoomRadio.setValues(new int[]{1,2});

      addShortStayHospitalRecuperationHospitalRoomRadio();
    }
    return shortStayHospitalRecuperationHospitalRoomRadio;

  }

  /**
   * 病室区分（病室）モデルを取得します。
   * @return 病室区分（病室）モデル
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationHospitalRoomRadioModel(){
    if(shortStayHospitalRecuperationHospitalRoomRadioModel==null){
      shortStayHospitalRecuperationHospitalRoomRadioModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationHospitalRoomRadioModel();
    }
    return shortStayHospitalRecuperationHospitalRoomRadioModel;
  }

  /**
   * 従来型個室を取得します。
   * @return 従来型個室
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationHospitalRoomRadioItem1(){
    if(shortStayHospitalRecuperationHospitalRoomRadioItem1==null){

      shortStayHospitalRecuperationHospitalRoomRadioItem1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationHospitalRoomRadioItem1.setText("従来型個室");

      shortStayHospitalRecuperationHospitalRoomRadioItem1.setGroup(getShortStayHospitalRecuperationHospitalRoomRadio());

      shortStayHospitalRecuperationHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationHospitalRoomRadioItem1();
    }
    return shortStayHospitalRecuperationHospitalRoomRadioItem1;

  }

  /**
   * 多床室を取得します。
   * @return 多床室
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationHospitalRoomRadioItem2(){
    if(shortStayHospitalRecuperationHospitalRoomRadioItem2==null){

      shortStayHospitalRecuperationHospitalRoomRadioItem2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationHospitalRoomRadioItem2.setText("多床室");

      shortStayHospitalRecuperationHospitalRoomRadioItem2.setGroup(getShortStayHospitalRecuperationHospitalRoomRadio());

      shortStayHospitalRecuperationHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationHospitalRoomRadioItem2();
    }
    return shortStayHospitalRecuperationHospitalRoomRadioItem2;

  }

  /**
   * 病室区分（ユニット型病院）を取得します。
   * @return 病室区分（ユニット型病院）
   */
  public ACValueArrayRadioButtonGroup getShortStayHospitalRecuperationUnitHospitalRoomRadio(){
    if(shortStayHospitalRecuperationUnitHospitalRoomRadio==null){

      shortStayHospitalRecuperationUnitHospitalRoomRadio = new ACValueArrayRadioButtonGroup();

      shortStayHospitalRecuperationUnitHospitalRoomRadio.setBindPath("20430106");

      shortStayHospitalRecuperationUnitHospitalRoomRadio.setUseClearButton(false);

      shortStayHospitalRecuperationUnitHospitalRoomRadio.setModel(getShortStayHospitalRecuperationUnitHospitalRoomRadioModel());

      shortStayHospitalRecuperationUnitHospitalRoomRadio.setValues(new int[]{1,2});

      addShortStayHospitalRecuperationUnitHospitalRoomRadio();
    }
    return shortStayHospitalRecuperationUnitHospitalRoomRadio;

  }

  /**
   * 病室区分（ユニット型病院）モデルを取得します。
   * @return 病室区分（ユニット型病院）モデル
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationUnitHospitalRoomRadioModel(){
    if(shortStayHospitalRecuperationUnitHospitalRoomRadioModel==null){
      shortStayHospitalRecuperationUnitHospitalRoomRadioModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationUnitHospitalRoomRadioModel();
    }
    return shortStayHospitalRecuperationUnitHospitalRoomRadioModel;
  }

  /**
   * ユニット型個室を取得します。
   * @return ユニット型個室
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationUnitHospitalRoomRadioItem1(){
    if(shortStayHospitalRecuperationUnitHospitalRoomRadioItem1==null){

      shortStayHospitalRecuperationUnitHospitalRoomRadioItem1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationUnitHospitalRoomRadioItem1.setText("ﾕﾆｯﾄ型個室");

      shortStayHospitalRecuperationUnitHospitalRoomRadioItem1.setGroup(getShortStayHospitalRecuperationUnitHospitalRoomRadio());

      shortStayHospitalRecuperationUnitHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationUnitHospitalRoomRadioItem1();
    }
    return shortStayHospitalRecuperationUnitHospitalRoomRadioItem1;

  }

  /**
   * ユニット型個室的多床室を取得します。
   * @return ユニット型個室的多床室
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationUnitHospitalRoomRadioItem2(){
    if(shortStayHospitalRecuperationUnitHospitalRoomRadioItem2==null){

      shortStayHospitalRecuperationUnitHospitalRoomRadioItem2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationUnitHospitalRoomRadioItem2.setText("ﾕﾆｯﾄ型個室的多床室");

      shortStayHospitalRecuperationUnitHospitalRoomRadioItem2.setGroup(getShortStayHospitalRecuperationUnitHospitalRoomRadio());

      shortStayHospitalRecuperationUnitHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationUnitHospitalRoomRadioItem2();
    }
    return shortStayHospitalRecuperationUnitHospitalRoomRadioItem2;

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
   * ユニットケアの整備を取得します。
   * @return ユニットケアの整備
   */
  public ACValueArrayRadioButtonGroup getShortStayHospitalRecuperationUnitCareMaintenanceRadio(){
    if(shortStayHospitalRecuperationUnitCareMaintenanceRadio==null){

      shortStayHospitalRecuperationUnitCareMaintenanceRadio = new ACValueArrayRadioButtonGroup();

      getShortStayHospitalRecuperationUnitCareMaintenanceRadioContainer().setText("ユニットケアの整備");

      shortStayHospitalRecuperationUnitCareMaintenanceRadio.setBindPath("20430109");

      shortStayHospitalRecuperationUnitCareMaintenanceRadio.setUseClearButton(false);

      shortStayHospitalRecuperationUnitCareMaintenanceRadio.setModel(getShortStayHospitalRecuperationUnitCareMaintenanceRadioModel());

      shortStayHospitalRecuperationUnitCareMaintenanceRadio.setValues(new int[]{1,2});

      addShortStayHospitalRecuperationUnitCareMaintenanceRadio();
    }
    return shortStayHospitalRecuperationUnitCareMaintenanceRadio;

  }

  /**
   * ユニットケアの整備コンテナを取得します。
   * @return ユニットケアの整備コンテナ
   */
  protected ACLabelContainer getShortStayHospitalRecuperationUnitCareMaintenanceRadioContainer(){
    if(shortStayHospitalRecuperationUnitCareMaintenanceRadioContainer==null){
      shortStayHospitalRecuperationUnitCareMaintenanceRadioContainer = new ACLabelContainer();
      shortStayHospitalRecuperationUnitCareMaintenanceRadioContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationUnitCareMaintenanceRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayHospitalRecuperationUnitCareMaintenanceRadioContainer.add(getShortStayHospitalRecuperationUnitCareMaintenanceRadio(), null);
    }
    return shortStayHospitalRecuperationUnitCareMaintenanceRadioContainer;
  }

  /**
   * ユニットケアの整備モデルを取得します。
   * @return ユニットケアの整備モデル
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationUnitCareMaintenanceRadioModel(){
    if(shortStayHospitalRecuperationUnitCareMaintenanceRadioModel==null){
      shortStayHospitalRecuperationUnitCareMaintenanceRadioModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationUnitCareMaintenanceRadioModel();
    }
    return shortStayHospitalRecuperationUnitCareMaintenanceRadioModel;
  }

  /**
   * 未整備を取得します。
   * @return 未整備
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationUnitCareMaintenanceRadioItem1(){
    if(shortStayHospitalRecuperationUnitCareMaintenanceRadioItem1==null){

      shortStayHospitalRecuperationUnitCareMaintenanceRadioItem1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationUnitCareMaintenanceRadioItem1.setText("未整備");

      shortStayHospitalRecuperationUnitCareMaintenanceRadioItem1.setGroup(getShortStayHospitalRecuperationUnitCareMaintenanceRadio());

      shortStayHospitalRecuperationUnitCareMaintenanceRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationUnitCareMaintenanceRadioItem1();
    }
    return shortStayHospitalRecuperationUnitCareMaintenanceRadioItem1;

  }

  /**
   * 整備を取得します。
   * @return 整備
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationUnitCareMaintenanceRadioItem2(){
    if(shortStayHospitalRecuperationUnitCareMaintenanceRadioItem2==null){

      shortStayHospitalRecuperationUnitCareMaintenanceRadioItem2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationUnitCareMaintenanceRadioItem2.setText("整備");

      shortStayHospitalRecuperationUnitCareMaintenanceRadioItem2.setGroup(getShortStayHospitalRecuperationUnitCareMaintenanceRadio());

      shortStayHospitalRecuperationUnitCareMaintenanceRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationUnitCareMaintenanceRadioItem2();
    }
    return shortStayHospitalRecuperationUnitCareMaintenanceRadioItem2;

  }

  /**
   * 夜間勤務等看護加算を取得します。
   * @return 夜間勤務等看護加算
   */
  public ACValueArrayRadioButtonGroup getShortStayHospitalRecuperationAdditionType(){
    if(shortStayHospitalRecuperationAdditionType==null){

      shortStayHospitalRecuperationAdditionType = new ACValueArrayRadioButtonGroup();

      getShortStayHospitalRecuperationAdditionTypeContainer().setText("夜間勤務等看護加算");

      shortStayHospitalRecuperationAdditionType.setBindPath("20430110");

      shortStayHospitalRecuperationAdditionType.setUseClearButton(false);

      shortStayHospitalRecuperationAdditionType.setModel(getShortStayHospitalRecuperationAdditionTypeModel());

      shortStayHospitalRecuperationAdditionType.setValues(new int[]{1,2,3,4,5});

      addShortStayHospitalRecuperationAdditionType();
    }
    return shortStayHospitalRecuperationAdditionType;

  }

  /**
   * 夜間勤務等看護加算コンテナを取得します。
   * @return 夜間勤務等看護加算コンテナ
   */
  protected ACLabelContainer getShortStayHospitalRecuperationAdditionTypeContainer(){
    if(shortStayHospitalRecuperationAdditionTypeContainer==null){
      shortStayHospitalRecuperationAdditionTypeContainer = new ACLabelContainer();
      shortStayHospitalRecuperationAdditionTypeContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationAdditionTypeContainer.setVAlignment(VRLayout.CENTER);
      shortStayHospitalRecuperationAdditionTypeContainer.add(getShortStayHospitalRecuperationAdditionType(), null);
    }
    return shortStayHospitalRecuperationAdditionTypeContainer;
  }

  /**
   * 夜間勤務等看護加算モデルを取得します。
   * @return 夜間勤務等看護加算モデル
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationAdditionTypeModel(){
    if(shortStayHospitalRecuperationAdditionTypeModel==null){
      shortStayHospitalRecuperationAdditionTypeModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationAdditionTypeModel();
    }
    return shortStayHospitalRecuperationAdditionTypeModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationAdditionType1(){
    if(shortStayHospitalRecuperationAdditionType1==null){

      shortStayHospitalRecuperationAdditionType1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationAdditionType1.setText("なし");

      shortStayHospitalRecuperationAdditionType1.setGroup(getShortStayHospitalRecuperationAdditionType());

      shortStayHospitalRecuperationAdditionType1.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationAdditionType1();
    }
    return shortStayHospitalRecuperationAdditionType1;

  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationAdditionType2(){
    if(shortStayHospitalRecuperationAdditionType2==null){

      shortStayHospitalRecuperationAdditionType2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationAdditionType2.setText("I型");

      shortStayHospitalRecuperationAdditionType2.setGroup(getShortStayHospitalRecuperationAdditionType());

      shortStayHospitalRecuperationAdditionType2.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationAdditionType2();
    }
    return shortStayHospitalRecuperationAdditionType2;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationAdditionType3(){
    if(shortStayHospitalRecuperationAdditionType3==null){

      shortStayHospitalRecuperationAdditionType3 = new ACRadioButtonItem();

      shortStayHospitalRecuperationAdditionType3.setText("II型");

      shortStayHospitalRecuperationAdditionType3.setGroup(getShortStayHospitalRecuperationAdditionType());

      shortStayHospitalRecuperationAdditionType3.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayHospitalRecuperationAdditionType3();
    }
    return shortStayHospitalRecuperationAdditionType3;

  }

  /**
   * III型を取得します。
   * @return III型
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationAdditionType4(){
    if(shortStayHospitalRecuperationAdditionType4==null){

      shortStayHospitalRecuperationAdditionType4 = new ACRadioButtonItem();

      shortStayHospitalRecuperationAdditionType4.setText("III型");

      shortStayHospitalRecuperationAdditionType4.setGroup(getShortStayHospitalRecuperationAdditionType());

      shortStayHospitalRecuperationAdditionType4.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationAdditionType4();
    }
    return shortStayHospitalRecuperationAdditionType4;

  }

  /**
   * IV型を取得します。
   * @return IV型
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationAdditionType5(){
    if(shortStayHospitalRecuperationAdditionType5==null){

      shortStayHospitalRecuperationAdditionType5 = new ACRadioButtonItem();

      shortStayHospitalRecuperationAdditionType5.setText("IV型");

      shortStayHospitalRecuperationAdditionType5.setGroup(getShortStayHospitalRecuperationAdditionType());

      shortStayHospitalRecuperationAdditionType5.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationAdditionType5();
    }
    return shortStayHospitalRecuperationAdditionType5;

  }

  /**
   * 療養環境基準（廊下）を取得します。
   * @return 療養環境基準（廊下）
   */
  public ACValueArrayRadioButtonGroup getEnvironmentalCorridorRadio(){
    if(environmentalCorridorRadio==null){

      environmentalCorridorRadio = new ACValueArrayRadioButtonGroup();

      getEnvironmentalCorridorRadioContainer().setText("療養環境基準（廊下）");

      environmentalCorridorRadio.setBindPath("20430111");

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

      environmentalRecuperationRoomRadio.setBindPath("20430112");

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
   * 夜間勤務条件基準を取得します。
   * @return 夜間勤務条件基準
   */
  public ACValueArrayRadioButtonGroup getShortStayHospitalRecuperationType(){
    if(shortStayHospitalRecuperationType==null){

      shortStayHospitalRecuperationType = new ACValueArrayRadioButtonGroup();

      getShortStayHospitalRecuperationTypeContainer().setText("夜間勤務条件基準");

      shortStayHospitalRecuperationType.setBindPath("20430113");

      shortStayHospitalRecuperationType.setUseClearButton(false);

      shortStayHospitalRecuperationType.setModel(getShortStayHospitalRecuperationTypeModel());

      shortStayHospitalRecuperationType.setValues(new int[]{1,2});

      addShortStayHospitalRecuperationType();
    }
    return shortStayHospitalRecuperationType;

  }

  /**
   * 夜間勤務条件基準コンテナを取得します。
   * @return 夜間勤務条件基準コンテナ
   */
  protected ACLabelContainer getShortStayHospitalRecuperationTypeContainer(){
    if(shortStayHospitalRecuperationTypeContainer==null){
      shortStayHospitalRecuperationTypeContainer = new ACLabelContainer();
      shortStayHospitalRecuperationTypeContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationTypeContainer.setVAlignment(VRLayout.CENTER);
      shortStayHospitalRecuperationTypeContainer.add(getShortStayHospitalRecuperationType(), null);
    }
    return shortStayHospitalRecuperationTypeContainer;
  }

  /**
   * 夜間勤務条件基準モデルを取得します。
   * @return 夜間勤務条件基準モデル
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationTypeModel(){
    if(shortStayHospitalRecuperationTypeModel==null){
      shortStayHospitalRecuperationTypeModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationTypeModel();
    }
    return shortStayHospitalRecuperationTypeModel;
  }

  /**
   * 通常を取得します。
   * @return 通常
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationTypeNormal(){
    if(shortStayHospitalRecuperationTypeNormal==null){

      shortStayHospitalRecuperationTypeNormal = new ACRadioButtonItem();

      shortStayHospitalRecuperationTypeNormal.setText("基準型");

      shortStayHospitalRecuperationTypeNormal.setGroup(getShortStayHospitalRecuperationType());

      shortStayHospitalRecuperationTypeNormal.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationTypeNormal();
    }
    return shortStayHospitalRecuperationTypeNormal;

  }

  /**
   * 減算型を取得します。
   * @return 減算型
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationTypeNone(){
    if(shortStayHospitalRecuperationTypeNone==null){

      shortStayHospitalRecuperationTypeNone = new ACRadioButtonItem();

      shortStayHospitalRecuperationTypeNone.setText("減算型");

      shortStayHospitalRecuperationTypeNone.setGroup(getShortStayHospitalRecuperationType());

      shortStayHospitalRecuperationTypeNone.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationTypeNone();
    }
    return shortStayHospitalRecuperationTypeNone;

  }

  /**
   * 職員減算を取得します。
   * @return 職員減算
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityHospitalSubstraction(){
    if(medicalFacilityHospitalSubstraction==null){

      medicalFacilityHospitalSubstraction = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityHospitalSubstractionContainer().setText("人員減算");

      medicalFacilityHospitalSubstraction.setBindPath("20430114");

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
   * 医師・薬剤師・看護職員・介護職員の不足を取得します。
   * @return 医師・薬剤師・看護職員・介護職員の不足
   */
  public ACRadioButtonItem getMedicalFacilityHospitalSubstractionItem3(){
    if(medicalFacilityHospitalSubstractionItem3==null){

      medicalFacilityHospitalSubstractionItem3 = new ACRadioButtonItem();

      medicalFacilityHospitalSubstractionItem3.setText("<html>医師・薬剤師・看護職員<br>介護職員の不足<html>");

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
   * 認知症行動・心理症状緊急対応加算を取得します。
   * @return 認知症行動・心理症状緊急対応加算
   */
  public ACValueArrayRadioButtonGroup getDementiaActionAddRadioGroup(){
    if(dementiaActionAddRadioGroup==null){

      dementiaActionAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaActionAddRadioGroupContainer().setText("認知症行動・" + ACConstants.LINE_SEPARATOR + "心理症状緊急対応加算" + ACConstants.LINE_SEPARATOR + "（1月に7日を限度）");

      dementiaActionAddRadioGroup.setBindPath("20430115");

      dementiaActionAddRadioGroup.setNoSelectIndex(0);

      dementiaActionAddRadioGroup.setUseClearButton(false);

      dementiaActionAddRadioGroup.setModel(getDementiaActionAddRadioGroupModel());

      dementiaActionAddRadioGroup.setValues(new int[]{1,2});

      addDementiaActionAddRadioGroup();
    }
    return dementiaActionAddRadioGroup;

  }

  /**
   * 認知症行動・心理症状緊急対応加算コンテナを取得します。
   * @return 認知症行動・心理症状緊急対応加算コンテナ
   */
  protected ACLabelContainer getDementiaActionAddRadioGroupContainer(){
    if(dementiaActionAddRadioGroupContainer==null){
      dementiaActionAddRadioGroupContainer = new ACLabelContainer();
      dementiaActionAddRadioGroupContainer.setFollowChildEnabled(true);
      dementiaActionAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      dementiaActionAddRadioGroupContainer.add(getDementiaActionAddRadioGroup(), null);
    }
    return dementiaActionAddRadioGroupContainer;
  }

  /**
   * 認知症行動・心理症状緊急対応加算モデルを取得します。
   * @return 認知症行動・心理症状緊急対応加算モデル
   */
  protected ACListModelAdapter getDementiaActionAddRadioGroupModel(){
    if(dementiaActionAddRadioGroupModel==null){
      dementiaActionAddRadioGroupModel = new ACListModelAdapter();
      addDementiaActionAddRadioGroupModel();
    }
    return dementiaActionAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getDementiaActionAddRadioItem1(){
    if(dementiaActionAddRadioItem1==null){

      dementiaActionAddRadioItem1 = new ACRadioButtonItem();

      dementiaActionAddRadioItem1.setText("なし");

      dementiaActionAddRadioItem1.setGroup(getDementiaActionAddRadioGroup());

      dementiaActionAddRadioItem1.setConstraints(VRLayout.FLOW);

      addDementiaActionAddRadioItem1();
    }
    return dementiaActionAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getDementiaActionAddRadioItem2(){
    if(dementiaActionAddRadioItem2==null){

      dementiaActionAddRadioItem2 = new ACRadioButtonItem();

      dementiaActionAddRadioItem2.setText("あり");

      dementiaActionAddRadioItem2.setGroup(getDementiaActionAddRadioGroup());

      dementiaActionAddRadioItem2.setConstraints(VRLayout.FLOW);

      addDementiaActionAddRadioItem2();
    }
    return dementiaActionAddRadioItem2;

  }

  /**
   * 若年性認知症利用者受入加算を取得します。
   * @return 若年性認知症利用者受入加算
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("若年性認知症利用者受入加算");

      youngDementiaPatinetAddRadioGroup.setBindPath("20430117");

      youngDementiaPatinetAddRadioGroup.setNoSelectIndex(0);

      youngDementiaPatinetAddRadioGroup.setUseClearButton(false);

      youngDementiaPatinetAddRadioGroup.setModel(getYoungDementiaPatinetAddRadioGroupModel());

      youngDementiaPatinetAddRadioGroup.setValues(new int[]{1,2});

      addYoungDementiaPatinetAddRadioGroup();
    }
    return youngDementiaPatinetAddRadioGroup;

  }

  /**
   * 若年性認知症利用者受入加算コンテナを取得します。
   * @return 若年性認知症利用者受入加算コンテナ
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
   * 若年性認知症利用者受入加算モデルを取得します。
   * @return 若年性認知症利用者受入加算モデル
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
   * 送迎加算を取得します。
   * @return 送迎加算
   */
  public ACValueArrayRadioButtonGroup getShortStayHospitalRecuperationMeetingAndSendingOff(){
    if(shortStayHospitalRecuperationMeetingAndSendingOff==null){

      shortStayHospitalRecuperationMeetingAndSendingOff = new ACValueArrayRadioButtonGroup();

      getShortStayHospitalRecuperationMeetingAndSendingOffContainer().setText("送迎加算");

      shortStayHospitalRecuperationMeetingAndSendingOff.setBindPath("6");

      shortStayHospitalRecuperationMeetingAndSendingOff.setUseClearButton(false);

      shortStayHospitalRecuperationMeetingAndSendingOff.setModel(getShortStayHospitalRecuperationMeetingAndSendingOffModel());

      shortStayHospitalRecuperationMeetingAndSendingOff.setValues(new int[]{1,2,3});

      addShortStayHospitalRecuperationMeetingAndSendingOff();
    }
    return shortStayHospitalRecuperationMeetingAndSendingOff;

  }

  /**
   * 送迎加算コンテナを取得します。
   * @return 送迎加算コンテナ
   */
  protected ACLabelContainer getShortStayHospitalRecuperationMeetingAndSendingOffContainer(){
    if(shortStayHospitalRecuperationMeetingAndSendingOffContainer==null){
      shortStayHospitalRecuperationMeetingAndSendingOffContainer = new ACLabelContainer();
      shortStayHospitalRecuperationMeetingAndSendingOffContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationMeetingAndSendingOffContainer.setVAlignment(VRLayout.CENTER);
      shortStayHospitalRecuperationMeetingAndSendingOffContainer.add(getShortStayHospitalRecuperationMeetingAndSendingOff(), null);
    }
    return shortStayHospitalRecuperationMeetingAndSendingOffContainer;
  }

  /**
   * 送迎加算モデルを取得します。
   * @return 送迎加算モデル
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationMeetingAndSendingOffModel(){
    if(shortStayHospitalRecuperationMeetingAndSendingOffModel==null){
      shortStayHospitalRecuperationMeetingAndSendingOffModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationMeetingAndSendingOffModel();
    }
    return shortStayHospitalRecuperationMeetingAndSendingOffModel;
  }

  /**
   * 送迎なしを取得します。
   * @return 送迎なし
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationMeetingAndSendingOffNone(){
    if(shortStayHospitalRecuperationMeetingAndSendingOffNone==null){

      shortStayHospitalRecuperationMeetingAndSendingOffNone = new ACRadioButtonItem();

      shortStayHospitalRecuperationMeetingAndSendingOffNone.setText("送迎なし");

      shortStayHospitalRecuperationMeetingAndSendingOffNone.setGroup(getShortStayHospitalRecuperationMeetingAndSendingOff());

      shortStayHospitalRecuperationMeetingAndSendingOffNone.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationMeetingAndSendingOffNone();
    }
    return shortStayHospitalRecuperationMeetingAndSendingOffNone;

  }

  /**
   * 送迎片道を取得します。
   * @return 送迎片道
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationMeetingAndSendingOffOneWay(){
    if(shortStayHospitalRecuperationMeetingAndSendingOffOneWay==null){

      shortStayHospitalRecuperationMeetingAndSendingOffOneWay = new ACRadioButtonItem();

      shortStayHospitalRecuperationMeetingAndSendingOffOneWay.setText("送迎片道");

      shortStayHospitalRecuperationMeetingAndSendingOffOneWay.setGroup(getShortStayHospitalRecuperationMeetingAndSendingOff());

      shortStayHospitalRecuperationMeetingAndSendingOffOneWay.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationMeetingAndSendingOffOneWay();
    }
    return shortStayHospitalRecuperationMeetingAndSendingOffOneWay;

  }

  /**
   * 送迎往復を取得します。
   * @return 送迎往復
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationMeetingAndSendingOffRoundTrip(){
    if(shortStayHospitalRecuperationMeetingAndSendingOffRoundTrip==null){

      shortStayHospitalRecuperationMeetingAndSendingOffRoundTrip = new ACRadioButtonItem();

      shortStayHospitalRecuperationMeetingAndSendingOffRoundTrip.setText("送迎往復");

      shortStayHospitalRecuperationMeetingAndSendingOffRoundTrip.setGroup(getShortStayHospitalRecuperationMeetingAndSendingOff());

      shortStayHospitalRecuperationMeetingAndSendingOffRoundTrip.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationMeetingAndSendingOffRoundTrip();
    }
    return shortStayHospitalRecuperationMeetingAndSendingOffRoundTrip;

  }

  /**
   * 療養食加算を取得します。
   * @return 療養食加算
   */
  public ACValueArrayRadioButtonGroup getShortStayHospitalRecuperationMedicalExpensesRadio(){
    if(shortStayHospitalRecuperationMedicalExpensesRadio==null){

      shortStayHospitalRecuperationMedicalExpensesRadio = new ACValueArrayRadioButtonGroup();

      getShortStayHospitalRecuperationMedicalExpensesRadioContainer().setText("療養食加算");

      shortStayHospitalRecuperationMedicalExpensesRadio.setBindPath("20430118");

      shortStayHospitalRecuperationMedicalExpensesRadio.setUseClearButton(false);

      shortStayHospitalRecuperationMedicalExpensesRadio.setModel(getShortStayHospitalRecuperationMedicalExpensesRadioModel());

      shortStayHospitalRecuperationMedicalExpensesRadio.setValues(new int[]{1,2,3,4});

      addShortStayHospitalRecuperationMedicalExpensesRadio();
    }
    return shortStayHospitalRecuperationMedicalExpensesRadio;

  }

  /**
   * 療養食加算コンテナを取得します。
   * @return 療養食加算コンテナ
   */
  protected ACLabelContainer getShortStayHospitalRecuperationMedicalExpensesRadioContainer(){
    if(shortStayHospitalRecuperationMedicalExpensesRadioContainer==null){
      shortStayHospitalRecuperationMedicalExpensesRadioContainer = new ACLabelContainer();
      shortStayHospitalRecuperationMedicalExpensesRadioContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationMedicalExpensesRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayHospitalRecuperationMedicalExpensesRadioContainer.add(getShortStayHospitalRecuperationMedicalExpensesRadio(), null);
    }
    return shortStayHospitalRecuperationMedicalExpensesRadioContainer;
  }

  /**
   * 療養食加算モデルを取得します。
   * @return 療養食加算モデル
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationMedicalExpensesRadioModel(){
    if(shortStayHospitalRecuperationMedicalExpensesRadioModel==null){
      shortStayHospitalRecuperationMedicalExpensesRadioModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationMedicalExpensesRadioModel();
    }
    return shortStayHospitalRecuperationMedicalExpensesRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationMedicalExpensesRadioItem1(){
    if(shortStayHospitalRecuperationMedicalExpensesRadioItem1==null){

      shortStayHospitalRecuperationMedicalExpensesRadioItem1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationMedicalExpensesRadioItem1.setText("なし");

      shortStayHospitalRecuperationMedicalExpensesRadioItem1.setGroup(getShortStayHospitalRecuperationMedicalExpensesRadio());

      shortStayHospitalRecuperationMedicalExpensesRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationMedicalExpensesRadioItem1();
    }
    return shortStayHospitalRecuperationMedicalExpensesRadioItem1;

  }

  /**
   * 3回を取得します。
   * @return 3回
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationMedicalExpensesRadioItem2(){
    if(shortStayHospitalRecuperationMedicalExpensesRadioItem2==null){

      shortStayHospitalRecuperationMedicalExpensesRadioItem2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationMedicalExpensesRadioItem2.setText("3回");

      shortStayHospitalRecuperationMedicalExpensesRadioItem2.setGroup(getShortStayHospitalRecuperationMedicalExpensesRadio());

      shortStayHospitalRecuperationMedicalExpensesRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationMedicalExpensesRadioItem2();
    }
    return shortStayHospitalRecuperationMedicalExpensesRadioItem2;

  }

  /**
   * 2回を取得します。
   * @return 2回
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationMedicalExpensesRadioItem3(){
    if(shortStayHospitalRecuperationMedicalExpensesRadioItem3==null){

      shortStayHospitalRecuperationMedicalExpensesRadioItem3 = new ACRadioButtonItem();

      shortStayHospitalRecuperationMedicalExpensesRadioItem3.setText("2回");

      shortStayHospitalRecuperationMedicalExpensesRadioItem3.setGroup(getShortStayHospitalRecuperationMedicalExpensesRadio());

      shortStayHospitalRecuperationMedicalExpensesRadioItem3.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationMedicalExpensesRadioItem3();
    }
    return shortStayHospitalRecuperationMedicalExpensesRadioItem3;

  }

  /**
   * 1回を取得します。
   * @return 1回
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationMedicalExpensesRadioItem4(){
    if(shortStayHospitalRecuperationMedicalExpensesRadioItem4==null){

      shortStayHospitalRecuperationMedicalExpensesRadioItem4 = new ACRadioButtonItem();

      shortStayHospitalRecuperationMedicalExpensesRadioItem4.setText("1回");

      shortStayHospitalRecuperationMedicalExpensesRadioItem4.setGroup(getShortStayHospitalRecuperationMedicalExpensesRadio());

      shortStayHospitalRecuperationMedicalExpensesRadioItem4.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationMedicalExpensesRadioItem4();
    }
    return shortStayHospitalRecuperationMedicalExpensesRadioItem4;

  }

  /**
   * 緊急時治療管理を取得します。
   * @return 緊急時治療管理
   */
  public ACValueArrayRadioButtonGroup getEmergencyTreatmentManagementRadio(){
    if(emergencyTreatmentManagementRadio==null){

      emergencyTreatmentManagementRadio = new ACValueArrayRadioButtonGroup();

      getEmergencyTreatmentManagementRadioContainer().setText("緊急時治療管理");

      emergencyTreatmentManagementRadio.setBindPath("20430119");

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

      dementiaProfessionalCareAddRadioGroup.setBindPath("20430120");

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
   * 特別診療費ボタンを取得します。
   * @return 特別診療費ボタン
   */
  public ACMapBindButton getShortStayHospitalRecuperationSpecificConsultationFee(){
    if(shortStayHospitalRecuperationSpecificConsultationFee==null){

      shortStayHospitalRecuperationSpecificConsultationFee = new ACMapBindButton();

      shortStayHospitalRecuperationSpecificConsultationFee.setText("特別診療費");

      shortStayHospitalRecuperationSpecificConsultationFee.setToolTipText("特別診療費を設定します。");

      addShortStayHospitalRecuperationSpecificConsultationFee();
    }
    return shortStayHospitalRecuperationSpecificConsultationFee;

  }

  /**
   * 設定ラベルを取得します。
   * @return 設定ラベル
   */
  public ACLabel getShortStayHospitalRecuperationSpecificConsultationFeeOutline(){
    if(shortStayHospitalRecuperationSpecificConsultationFeeOutline==null){

      shortStayHospitalRecuperationSpecificConsultationFeeOutline = new ACLabel();

      shortStayHospitalRecuperationSpecificConsultationFeeOutline.setText("設定なし");

      shortStayHospitalRecuperationSpecificConsultationFeeOutline.setOpaque(true);
      shortStayHospitalRecuperationSpecificConsultationFeeOutline.setBackground(new Color(255,255,172));

      addShortStayHospitalRecuperationSpecificConsultationFeeOutline();
    }
    return shortStayHospitalRecuperationSpecificConsultationFeeOutline;

  }

  /**
   * サービス提供体制強化加算を取得します。
   * @return サービス提供体制強化加算
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("サービス提供体制強化加算");

      serviceAddProvisionStructuralRadioGroup.setBindPath("20430122");

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
  public ACBackLabelContainer getShortStayRecuperationHealthFacilityDinnerContainer(){
    if(shortStayRecuperationHealthFacilityDinnerContainer==null){

      shortStayRecuperationHealthFacilityDinnerContainer = new ACBackLabelContainer();

      shortStayRecuperationHealthFacilityDinnerContainer.setFollowChildEnabled(true);

      addShortStayRecuperationHealthFacilityDinnerContainer();
    }
    return shortStayRecuperationHealthFacilityDinnerContainer;

  }

  /**
   * 食事提供を取得します。
   * @return 食事提供
   */
  public ACComboBox getShortStayRecuperationHealthFacilityDinnerOffer(){
    if(shortStayRecuperationHealthFacilityDinnerOffer==null){

      shortStayRecuperationHealthFacilityDinnerOffer = new ACComboBox();

      getShortStayRecuperationHealthFacilityDinnerOfferContainer().setText("食事提供");

      shortStayRecuperationHealthFacilityDinnerOffer.setBindPath("20430123");

      shortStayRecuperationHealthFacilityDinnerOffer.setEditable(false);

      shortStayRecuperationHealthFacilityDinnerOffer.setModelBindPath("20430123");

      shortStayRecuperationHealthFacilityDinnerOffer.setRenderBindPath("CONTENT");

      shortStayRecuperationHealthFacilityDinnerOffer.setModel(getShortStayRecuperationHealthFacilityDinnerOfferModel());

      addShortStayRecuperationHealthFacilityDinnerOffer();
    }
    return shortStayRecuperationHealthFacilityDinnerOffer;

  }

  /**
   * 食事提供コンテナを取得します。
   * @return 食事提供コンテナ
   */
  protected ACLabelContainer getShortStayRecuperationHealthFacilityDinnerOfferContainer(){
    if(shortStayRecuperationHealthFacilityDinnerOfferContainer==null){
      shortStayRecuperationHealthFacilityDinnerOfferContainer = new ACLabelContainer();
      shortStayRecuperationHealthFacilityDinnerOfferContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthFacilityDinnerOfferContainer.setVAlignment(VRLayout.CENTER);
      shortStayRecuperationHealthFacilityDinnerOfferContainer.add(getShortStayRecuperationHealthFacilityDinnerOffer(), null);
    }
    return shortStayRecuperationHealthFacilityDinnerOfferContainer;
  }

  /**
   * 食事提供モデルを取得します。
   * @return 食事提供モデル
   */
  protected ACComboBoxModelAdapter getShortStayRecuperationHealthFacilityDinnerOfferModel(){
    if(shortStayRecuperationHealthFacilityDinnerOfferModel==null){
      shortStayRecuperationHealthFacilityDinnerOfferModel = new ACComboBoxModelAdapter();
      addShortStayRecuperationHealthFacilityDinnerOfferModel();
    }
    return shortStayRecuperationHealthFacilityDinnerOfferModel;
  }

  /**
   * 食事費用を取得します。
   * @return 食事費用
   */
  public ACTextField getShortStayRecuperationHealthFacilityDinnerCost(){
    if(shortStayRecuperationHealthFacilityDinnerCost==null){

      shortStayRecuperationHealthFacilityDinnerCost = new ACTextField();

      getShortStayRecuperationHealthFacilityDinnerCostContainer().setText("食事費用");

      shortStayRecuperationHealthFacilityDinnerCost.setBindPath("20430124");

      shortStayRecuperationHealthFacilityDinnerCost.setColumns(4);

      shortStayRecuperationHealthFacilityDinnerCost.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperationHealthFacilityDinnerCost.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperationHealthFacilityDinnerCost.setIMEMode(InputSubset.LATIN);

      shortStayRecuperationHealthFacilityDinnerCost.setMaxLength(5);

      addShortStayRecuperationHealthFacilityDinnerCost();
    }
    return shortStayRecuperationHealthFacilityDinnerCost;

  }

  /**
   * 食事費用コンテナを取得します。
   * @return 食事費用コンテナ
   */
  protected ACLabelContainer getShortStayRecuperationHealthFacilityDinnerCostContainer(){
    if(shortStayRecuperationHealthFacilityDinnerCostContainer==null){
      shortStayRecuperationHealthFacilityDinnerCostContainer = new ACLabelContainer();
      shortStayRecuperationHealthFacilityDinnerCostContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthFacilityDinnerCostContainer.setVAlignment(VRLayout.CENTER);
      shortStayRecuperationHealthFacilityDinnerCostContainer.add(getShortStayRecuperationHealthFacilityDinnerCost(), null);
    }
    return shortStayRecuperationHealthFacilityDinnerCostContainer;
  }

  /**
   * 30日超を取得します。
   * @return 30日超
   */
  public ACIntegerCheckBox getShortStayHospitalRecuperationEtc30Over(){
    if(shortStayHospitalRecuperationEtc30Over==null){

      shortStayHospitalRecuperationEtc30Over = new ACIntegerCheckBox();

      shortStayHospitalRecuperationEtc30Over.setText("30日超");

      shortStayHospitalRecuperationEtc30Over.setBindPath("5");

      shortStayHospitalRecuperationEtc30Over.setSelectValue(2);

      shortStayHospitalRecuperationEtc30Over.setUnSelectValue(1);

      addShortStayHospitalRecuperationEtc30Over();
    }
    return shortStayHospitalRecuperationEtc30Over;

  }

  /**
   * コンストラクタです。
   */
  public QS001_204311_201804Design() {

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

    tab1.add(getShortStayHospitalRecuperationInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getStaffAssignmentDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayHospitalRecuperationHospitalRoomContena(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 施設等の区分に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadio(){

  }

  /**
   * 施設等の区分モデルに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadioModel(){

    getShortStayHospitalRecuperationInstitutionDivisionRadioItem1().setButtonIndex(1);

    getShortStayHospitalRecuperationInstitutionDivisionRadioModel().add(getShortStayHospitalRecuperationInstitutionDivisionRadioItem1());

    getShortStayHospitalRecuperationInstitutionDivisionRadioItem2().setButtonIndex(2);

    getShortStayHospitalRecuperationInstitutionDivisionRadioModel().add(getShortStayHospitalRecuperationInstitutionDivisionRadioItem2());

    getShortStayHospitalRecuperationInstitutionDivisionRadioItem3().setButtonIndex(3);

    getShortStayHospitalRecuperationInstitutionDivisionRadioModel().add(getShortStayHospitalRecuperationInstitutionDivisionRadioItem3());

    getShortStayHospitalRecuperationInstitutionDivisionRadioItem4().setButtonIndex(4);

    getShortStayHospitalRecuperationInstitutionDivisionRadioModel().add(getShortStayHospitalRecuperationInstitutionDivisionRadioItem4());

    getShortStayHospitalRecuperationInstitutionDivisionRadioItem5().setButtonIndex(5);

    getShortStayHospitalRecuperationInstitutionDivisionRadioModel().add(getShortStayHospitalRecuperationInstitutionDivisionRadioItem5());

    getShortStayHospitalRecuperationInstitutionDivisionRadioItem6().setButtonIndex(6);

    getShortStayHospitalRecuperationInstitutionDivisionRadioModel().add(getShortStayHospitalRecuperationInstitutionDivisionRadioItem6());

  }

  /**
   * I型介護医療院に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadioItem1(){

  }

  /**
   * II型介護医療院に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadioItem2(){

  }

  /**
   * 特別介護医療院に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadioItem3(){

  }

  /**
   * ユニット型I型介護医療院に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadioItem4(){

  }

  /**
   * ユニット型II型介護医療院に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadioItem5(){

  }

  /**
   * ユニット型特別介護医療院に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadioItem6(){

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
  protected void addShortStayHospitalRecuperationHospitalRoomContena(){

    shortStayHospitalRecuperationHospitalRoomContena.add(getShortStayHospitalRecuperationHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayHospitalRecuperationHospitalRoomContena.add(getShortStayHospitalRecuperationUnitHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 病室区分（病室）に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationHospitalRoomRadio(){

  }

  /**
   * 病室区分（病室）モデルに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationHospitalRoomRadioModel(){

    getShortStayHospitalRecuperationHospitalRoomRadioItem1().setButtonIndex(1);

    getShortStayHospitalRecuperationHospitalRoomRadioModel().add(getShortStayHospitalRecuperationHospitalRoomRadioItem1());

    getShortStayHospitalRecuperationHospitalRoomRadioItem2().setButtonIndex(2);

    getShortStayHospitalRecuperationHospitalRoomRadioModel().add(getShortStayHospitalRecuperationHospitalRoomRadioItem2());

  }

  /**
   * 従来型個室に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationHospitalRoomRadioItem1(){

  }

  /**
   * 多床室に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationHospitalRoomRadioItem2(){

  }

  /**
   * 病室区分（ユニット型病院）に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationUnitHospitalRoomRadio(){

  }

  /**
   * 病室区分（ユニット型病院）モデルに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationUnitHospitalRoomRadioModel(){

    getShortStayHospitalRecuperationUnitHospitalRoomRadioItem1().setButtonIndex(1);

    getShortStayHospitalRecuperationUnitHospitalRoomRadioModel().add(getShortStayHospitalRecuperationUnitHospitalRoomRadioItem1());

    getShortStayHospitalRecuperationUnitHospitalRoomRadioItem2().setButtonIndex(2);

    getShortStayHospitalRecuperationUnitHospitalRoomRadioModel().add(getShortStayHospitalRecuperationUnitHospitalRoomRadioItem2());

  }

  /**
   * ユニット型個室に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationUnitHospitalRoomRadioItem1(){

  }

  /**
   * ユニット型個室的多床室に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationUnitHospitalRoomRadioItem2(){

  }

  /**
   * タブ2に内部項目を追加します。
   */
  protected void addTab2(){

    tab2.add(getShortStayHospitalRecuperationUnitCareMaintenanceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayHospitalRecuperationAdditionTypeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getEnvironmentalCorridorRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getEnvironmentalRecuperationRoomRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayHospitalRecuperationTypeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityHospitalSubstractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * ユニットケアの整備に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationUnitCareMaintenanceRadio(){

  }

  /**
   * ユニットケアの整備モデルに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationUnitCareMaintenanceRadioModel(){

    getShortStayHospitalRecuperationUnitCareMaintenanceRadioItem1().setButtonIndex(1);

    getShortStayHospitalRecuperationUnitCareMaintenanceRadioModel().add(getShortStayHospitalRecuperationUnitCareMaintenanceRadioItem1());

    getShortStayHospitalRecuperationUnitCareMaintenanceRadioItem2().setButtonIndex(2);

    getShortStayHospitalRecuperationUnitCareMaintenanceRadioModel().add(getShortStayHospitalRecuperationUnitCareMaintenanceRadioItem2());

  }

  /**
   * 未整備に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationUnitCareMaintenanceRadioItem1(){

  }

  /**
   * 整備に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationUnitCareMaintenanceRadioItem2(){

  }

  /**
   * 夜間勤務等看護加算に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationAdditionType(){

  }

  /**
   * 夜間勤務等看護加算モデルに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationAdditionTypeModel(){

    getShortStayHospitalRecuperationAdditionType1().setButtonIndex(1);

    getShortStayHospitalRecuperationAdditionTypeModel().add(getShortStayHospitalRecuperationAdditionType1());

    getShortStayHospitalRecuperationAdditionType2().setButtonIndex(2);

    getShortStayHospitalRecuperationAdditionTypeModel().add(getShortStayHospitalRecuperationAdditionType2());

    getShortStayHospitalRecuperationAdditionType3().setButtonIndex(3);

    getShortStayHospitalRecuperationAdditionTypeModel().add(getShortStayHospitalRecuperationAdditionType3());

    getShortStayHospitalRecuperationAdditionType4().setButtonIndex(4);

    getShortStayHospitalRecuperationAdditionTypeModel().add(getShortStayHospitalRecuperationAdditionType4());

    getShortStayHospitalRecuperationAdditionType5().setButtonIndex(5);

    getShortStayHospitalRecuperationAdditionTypeModel().add(getShortStayHospitalRecuperationAdditionType5());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationAdditionType1(){

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationAdditionType2(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationAdditionType3(){

  }

  /**
   * III型に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationAdditionType4(){

  }

  /**
   * IV型に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationAdditionType5(){

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
   * 夜間勤務条件基準に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationType(){

  }

  /**
   * 夜間勤務条件基準モデルに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationTypeModel(){

    getShortStayHospitalRecuperationTypeNormal().setButtonIndex(1);

    getShortStayHospitalRecuperationTypeModel().add(getShortStayHospitalRecuperationTypeNormal());

    getShortStayHospitalRecuperationTypeNone().setButtonIndex(2);

    getShortStayHospitalRecuperationTypeModel().add(getShortStayHospitalRecuperationTypeNone());

  }

  /**
   * 通常に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationTypeNormal(){

  }

  /**
   * 減算型に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationTypeNone(){

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
   * 医師・薬剤師・看護職員・介護職員の不足に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalSubstractionItem3(){

  }

  /**
   * 正看比率が20％未満に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalSubstractionItem4(){

  }

  /**
   * タブ3に内部項目を追加します。
   */
  protected void addTab3(){

    tab3.add(getDementiaActionAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getShortStayHospitalRecuperationMeetingAndSendingOffContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getShortStayHospitalRecuperationMedicalExpensesRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getEmergencyTreatmentManagementRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getDementiaProfessionalCareAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 認知症行動・心理症状緊急対応加算に内部項目を追加します。
   */
  protected void addDementiaActionAddRadioGroup(){

  }

  /**
   * 認知症行動・心理症状緊急対応加算モデルに内部項目を追加します。
   */
  protected void addDementiaActionAddRadioGroupModel(){

    getDementiaActionAddRadioItem1().setButtonIndex(1);

    getDementiaActionAddRadioGroupModel().add(getDementiaActionAddRadioItem1());

    getDementiaActionAddRadioItem2().setButtonIndex(2);

    getDementiaActionAddRadioGroupModel().add(getDementiaActionAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addDementiaActionAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addDementiaActionAddRadioItem2(){

  }

  /**
   * 若年性認知症利用者受入加算に内部項目を追加します。
   */
  protected void addYoungDementiaPatinetAddRadioGroup(){

  }

  /**
   * 若年性認知症利用者受入加算モデルに内部項目を追加します。
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
   * 送迎加算に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationMeetingAndSendingOff(){

  }

  /**
   * 送迎加算モデルに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationMeetingAndSendingOffModel(){

    getShortStayHospitalRecuperationMeetingAndSendingOffNone().setButtonIndex(1);

    getShortStayHospitalRecuperationMeetingAndSendingOffModel().add(getShortStayHospitalRecuperationMeetingAndSendingOffNone());

    getShortStayHospitalRecuperationMeetingAndSendingOffOneWay().setButtonIndex(2);

    getShortStayHospitalRecuperationMeetingAndSendingOffModel().add(getShortStayHospitalRecuperationMeetingAndSendingOffOneWay());

    getShortStayHospitalRecuperationMeetingAndSendingOffRoundTrip().setButtonIndex(3);

    getShortStayHospitalRecuperationMeetingAndSendingOffModel().add(getShortStayHospitalRecuperationMeetingAndSendingOffRoundTrip());

  }

  /**
   * 送迎なしに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationMeetingAndSendingOffNone(){

  }

  /**
   * 送迎片道に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationMeetingAndSendingOffOneWay(){

  }

  /**
   * 送迎往復に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationMeetingAndSendingOffRoundTrip(){

  }

  /**
   * 療養食加算に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationMedicalExpensesRadio(){

  }

  /**
   * 療養食加算モデルに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationMedicalExpensesRadioModel(){

    getShortStayHospitalRecuperationMedicalExpensesRadioItem1().setButtonIndex(1);

    getShortStayHospitalRecuperationMedicalExpensesRadioModel().add(getShortStayHospitalRecuperationMedicalExpensesRadioItem1());

    getShortStayHospitalRecuperationMedicalExpensesRadioItem2().setButtonIndex(2);

    getShortStayHospitalRecuperationMedicalExpensesRadioModel().add(getShortStayHospitalRecuperationMedicalExpensesRadioItem2());

    getShortStayHospitalRecuperationMedicalExpensesRadioItem3().setButtonIndex(3);

    getShortStayHospitalRecuperationMedicalExpensesRadioModel().add(getShortStayHospitalRecuperationMedicalExpensesRadioItem3());

    getShortStayHospitalRecuperationMedicalExpensesRadioItem4().setButtonIndex(4);

    getShortStayHospitalRecuperationMedicalExpensesRadioModel().add(getShortStayHospitalRecuperationMedicalExpensesRadioItem4());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationMedicalExpensesRadioItem1(){

  }

  /**
   * 3回に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationMedicalExpensesRadioItem2(){

  }

  /**
   * 2回に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationMedicalExpensesRadioItem3(){

  }

  /**
   * 1回に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationMedicalExpensesRadioItem4(){

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
   * タブ4に内部項目を追加します。
   */
  protected void addTab4(){

    tab4.add(getShortStayHospitalRecuperationSpecificConsultationFee(), VRLayout.FLOW);

    tab4.add(getShortStayHospitalRecuperationSpecificConsultationFeeOutline(), VRLayout.FLOW_RETURN);

    tab4.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getShortStayRecuperationHealthFacilityDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    tab4.add(getShortStayHospitalRecuperationEtc30Over(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 特別診療費ボタンに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationSpecificConsultationFee(){

  }

  /**
   * 設定ラベルに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationSpecificConsultationFeeOutline(){

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
  protected void addShortStayRecuperationHealthFacilityDinnerContainer(){

    shortStayRecuperationHealthFacilityDinnerContainer.add(getShortStayRecuperationHealthFacilityDinnerOfferContainer(), VRLayout.FLOW);

    shortStayRecuperationHealthFacilityDinnerContainer.add(getShortStayRecuperationHealthFacilityDinnerCostContainer(), VRLayout.FLOW);

  }

  /**
   * 食事提供に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityDinnerOffer(){

  }

  /**
   * 食事提供モデルに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityDinnerOfferModel(){

  }

  /**
   * 食事費用に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityDinnerCost(){

  }

  /**
   * 30日超に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationEtc30Over(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_204311_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001_204311_201804Design getThis() {
    return this;
  }
}
