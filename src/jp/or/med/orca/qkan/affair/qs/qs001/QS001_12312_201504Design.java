
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
 * 作成日: 2015/03/13  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン短期入所療養介護（診療所療養） (QS001_12312_201504)
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
 * サービスパターン短期入所療養介護（診療所療養）画面項目デザイン(QS001_12312_201504) 
 */
public class QS001_12312_201504Design extends QS001ServicePanel {
  //GUIコンポーネント

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup shortStayClinicRecuperationInstitutionDivisionRadio;

  private ACLabelContainer shortStayClinicRecuperationInstitutionDivisionRadioContainer;

  private ACListModelAdapter shortStayClinicRecuperationInstitutionDivisionRadioModel;

  private ACRadioButtonItem shortStayClinicRecuperationInstitutionDivisionRadioItem1;

  private ACRadioButtonItem shortStayClinicRecuperationInstitutionDivisionRadioItem2;

  private ACRadioButtonItem shortStayClinicRecuperationInstitutionDivisionRadioItem3;

  private ACLabelContainer staffAssignmentDivisionContainer;

  private ACValueArrayRadioButtonGroup staffAssignment1Division;

  private ACListModelAdapter staffAssignment1DivisionModel;

  private ACRadioButtonItem staffAssignmentDivisionItem1;

  private ACRadioButtonItem staffAssignmentDivisionItem2;

  private ACRadioButtonItem staffAssignmentDivisionItem3;

  private ACRadioButtonItem staffAssignmentDivisionItem4;

  private ACValueArrayRadioButtonGroup staffAssignment2Division;

  private ACListModelAdapter staffAssignment2DivisionModel;

  private ACRadioButtonItem staffAssignmentDivisionItem5;

  private ACRadioButtonItem staffAssignmentDivisionItem6;

  private ACRadioButtonItem staffAssignmentDivisionItem7;

  private ACLabelContainer shortStayClinicRecuperationHospitalRoomContena;

  private ACValueArrayRadioButtonGroup shortStayClinicRecuperationHospitalRoomRadio;

  private ACListModelAdapter shortStayClinicRecuperationHospitalRoomRadioModel;

  private ACRadioButtonItem shortStayClinicRecuperationHospitalRoomRadioItem1;

  private ACRadioButtonItem shortStayClinicRecuperationHospitalRoomRadioItem2;

  private ACValueArrayRadioButtonGroup shortStayClinicRecuperationUnitHospitalRoomRadio;

  private ACListModelAdapter shortStayClinicRecuperationUnitHospitalRoomRadioModel;

  private ACRadioButtonItem shortStayClinicRecuperationUnitHospitalRoomRadioItem1;

  private ACRadioButtonItem shortStayClinicRecuperationUnitHospitalRoomRadioItem2;

  private ACValueArrayRadioButtonGroup shortStayClinicRecuperationSickroomDivisionRadio;

  private ACLabelContainer shortStayClinicRecuperationSickroomDivisionRadioContainer;

  private ACListModelAdapter shortStayClinicRecuperationSickroomDivisionRadioModel;

  private ACRadioButtonItem shortStayClinicRecuperationSickroomDivisionRadioItem1;

  private ACRadioButtonItem shortStayClinicRecuperationSickroomDivisionRadioItem2;

  private ACRadioButtonItem shortStayClinicRecuperationSickroomDivisionRadioItem3;

  private ACRadioButtonItem shortStayClinicRecuperationSickroomDivisionRadioItem4;

  private ACComboBox tankinyusyoTimeDivision;

  private ACLabelContainer tankinyusyoTimeDivisionContainer;

  private ACComboBoxModelAdapter tankinyusyoTimeDivisionModel;

  private ACValueArrayRadioButtonGroup shortStayClinicRecuperationSubtractionType;

  private ACLabelContainer shortStayClinicRecuperationSubtractionTypeContainer;

  private ACListModelAdapter shortStayClinicRecuperationSubtractionTypeModel;

  private ACRadioButtonItem shortStayClinicRecuperationSubtractionTypeNormal;

  private ACRadioButtonItem shortStayClinicRecuperationSubtractionType3;

  private ACValueArrayRadioButtonGroup shortStayClinicRecuperationProvisionBase;

  private ACLabelContainer shortStayClinicRecuperationProvisionBaseContainer;

  private ACListModelAdapter shortStayClinicRecuperationProvisionBaseModel;

  private ACRadioButtonItem shortStayClinicRecuperationProvisionBaseNormal;

  private ACRadioButtonItem shortStayClinicRecuperationProvisionBaseType1;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup dementiaActionAddRadioGroup;

  private ACLabelContainer dementiaActionAddRadioGroupContainer;

  private ACListModelAdapter dementiaActionAddRadioGroupModel;

  private ACRadioButtonItem dementiaActionAddRadioItem1;

  private ACRadioButtonItem dementiaActionAddRadioItem2;

  private ACValueArrayRadioButtonGroup shortStayClinicRecuperationEmergencyNetworkAddRadio;

  private ACLabelContainer shortStayClinicRecuperationEmergencyNetworkAddRadioContainer;

  private ACListModelAdapter shortStayClinicRecuperationEmergencyNetworkAddRadioModel;

  private ACRadioButtonItem shortStayClinicRecuperationEmergencyNetworkAddRadioItem1;

  private ACRadioButtonItem shortStayClinicRecuperationEmergencyNetworkAddRadioItem2;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACValueArrayRadioButtonGroup shortStayClinicRecuperationMeetingAndSendingOff;

  private ACLabelContainer shortStayClinicRecuperationMeetingAndSendingOffContainer;

  private ACListModelAdapter shortStayClinicRecuperationMeetingAndSendingOffModel;

  private ACRadioButtonItem shortStayClinicRecuperationMeetingAndSendingOffNone;

  private ACRadioButtonItem shortStayClinicRecuperationMeetingAndSendingOffOneWay;

  private ACRadioButtonItem shortStayClinicRecuperationMeetingAndSendingOffRoundTrip;

  private ACValueArrayRadioButtonGroup shortStayClinicRecuperationMedicalExpensesRadio;

  private ACLabelContainer shortStayClinicRecuperationMedicalExpensesRadioContainer;

  private ACListModelAdapter shortStayClinicRecuperationMedicalExpensesRadioModel;

  private ACRadioButtonItem shortStayClinicRecuperationMedicalExpensesRadioItem1;

  private ACRadioButtonItem shortStayClinicRecuperationMedicalExpensesRadioItem2;

  private ACValueArrayRadioButtonGroup shortStayClinicRecuperationStaffReduceRadio;

  private ACLabelContainer shortStayClinicRecuperationStaffReduceRadioContainer;

  private ACListModelAdapter shortStayClinicRecuperationStaffReduceRadioModel;

  private ACRadioButtonItem shortStayClinicRecuperationStaffReduceRadioItem1;

  private ACRadioButtonItem shortStayClinicRecuperationStaffReduceRadioItem2;

  private ACMapBindButton shortStayClinicRecuperationSpecificConsultationFee;

  private ACLabel shortStayClinicRecuperationSpecificConsultationFeeOutline;

  private ACPanel tab3;

  private ACBackLabelContainer shortStayClinicRecuperationDinnerContainer;

  private ACComboBox shortStayClinicRecuperationDinnerOffer;

  private ACLabelContainer shortStayClinicRecuperationDinnerOfferContainer;

  private ACComboBoxModelAdapter shortStayClinicRecuperationDinnerOfferModel;

  private ACTextField shortStayClinicRecuperationDinnerCost;

  private ACLabelContainer shortStayClinicRecuperationDinnerCostContainer;

  private ACIntegerCheckBox shortStayClinicRecuperationEtc30Over;

  private ACValueArrayRadioButtonGroup shortStayClinicRecuperationUnitCareMaintenanceRadio;

  private ACLabelContainer shortStayClinicRecuperationUnitCareMaintenanceRadioContainer;

  private ACListModelAdapter shortStayClinicRecuperationUnitCareMaintenanceRadioModel;

  private ACRadioButtonItem shortStayClinicRecuperationUnitCareMaintenanceRadioitem1;

  private ACRadioButtonItem shortStayClinicRecuperationUnitCareMaintenanceRadioitem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem5;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

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
  public ACValueArrayRadioButtonGroup getShortStayClinicRecuperationInstitutionDivisionRadio(){
    if(shortStayClinicRecuperationInstitutionDivisionRadio==null){

      shortStayClinicRecuperationInstitutionDivisionRadio = new ACValueArrayRadioButtonGroup();

      getShortStayClinicRecuperationInstitutionDivisionRadioContainer().setText("施設等の区分");

      shortStayClinicRecuperationInstitutionDivisionRadio.setBindPath("1230201");

      shortStayClinicRecuperationInstitutionDivisionRadio.setUseClearButton(false);

      shortStayClinicRecuperationInstitutionDivisionRadio.setModel(getShortStayClinicRecuperationInstitutionDivisionRadioModel());

      shortStayClinicRecuperationInstitutionDivisionRadio.setValues(new int[]{1,2,3});

      addShortStayClinicRecuperationInstitutionDivisionRadio();
    }
    return shortStayClinicRecuperationInstitutionDivisionRadio;

  }

  /**
   * 施設等の区分コンテナを取得します。
   * @return 施設等の区分コンテナ
   */
  protected ACLabelContainer getShortStayClinicRecuperationInstitutionDivisionRadioContainer(){
    if(shortStayClinicRecuperationInstitutionDivisionRadioContainer==null){
      shortStayClinicRecuperationInstitutionDivisionRadioContainer = new ACLabelContainer();
      shortStayClinicRecuperationInstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationInstitutionDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationInstitutionDivisionRadioContainer.add(getShortStayClinicRecuperationInstitutionDivisionRadio(), null);
    }
    return shortStayClinicRecuperationInstitutionDivisionRadioContainer;
  }

  /**
   * 施設等の区分モデルを取得します。
   * @return 施設等の区分モデル
   */
  protected ACListModelAdapter getShortStayClinicRecuperationInstitutionDivisionRadioModel(){
    if(shortStayClinicRecuperationInstitutionDivisionRadioModel==null){
      shortStayClinicRecuperationInstitutionDivisionRadioModel = new ACListModelAdapter();
      addShortStayClinicRecuperationInstitutionDivisionRadioModel();
    }
    return shortStayClinicRecuperationInstitutionDivisionRadioModel;
  }

  /**
   * 診療所を取得します。
   * @return 診療所
   */
  public ACRadioButtonItem getShortStayClinicRecuperationInstitutionDivisionRadioItem1(){
    if(shortStayClinicRecuperationInstitutionDivisionRadioItem1==null){

      shortStayClinicRecuperationInstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayClinicRecuperationInstitutionDivisionRadioItem1.setText("診療所");

      shortStayClinicRecuperationInstitutionDivisionRadioItem1.setGroup(getShortStayClinicRecuperationInstitutionDivisionRadio());

      shortStayClinicRecuperationInstitutionDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationInstitutionDivisionRadioItem1();
    }
    return shortStayClinicRecuperationInstitutionDivisionRadioItem1;

  }

  /**
   * ユニット型診療所を取得します。
   * @return ユニット型診療所
   */
  public ACRadioButtonItem getShortStayClinicRecuperationInstitutionDivisionRadioItem2(){
    if(shortStayClinicRecuperationInstitutionDivisionRadioItem2==null){

      shortStayClinicRecuperationInstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayClinicRecuperationInstitutionDivisionRadioItem2.setText("ユニット型診療所");

      shortStayClinicRecuperationInstitutionDivisionRadioItem2.setGroup(getShortStayClinicRecuperationInstitutionDivisionRadio());

      shortStayClinicRecuperationInstitutionDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayClinicRecuperationInstitutionDivisionRadioItem2();
    }
    return shortStayClinicRecuperationInstitutionDivisionRadioItem2;

  }

  /**
   * 日帰りショートステイを取得します。
   * @return 日帰りショートステイ
   */
  public ACRadioButtonItem getShortStayClinicRecuperationInstitutionDivisionRadioItem3(){
    if(shortStayClinicRecuperationInstitutionDivisionRadioItem3==null){

      shortStayClinicRecuperationInstitutionDivisionRadioItem3 = new ACRadioButtonItem();

      shortStayClinicRecuperationInstitutionDivisionRadioItem3.setText("日帰りショートステイ");

      shortStayClinicRecuperationInstitutionDivisionRadioItem3.setGroup(getShortStayClinicRecuperationInstitutionDivisionRadio());

      shortStayClinicRecuperationInstitutionDivisionRadioItem3.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationInstitutionDivisionRadioItem3();
    }
    return shortStayClinicRecuperationInstitutionDivisionRadioItem3;

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

      staffAssignment1Division.setBindPath("1230202");

      staffAssignment1Division.setUseClearButton(false);

      staffAssignment1Division.setModel(getStaffAssignment1DivisionModel());

      staffAssignment1Division.setValues(new int[]{1,2,3,4});

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
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem4(){
    if(staffAssignmentDivisionItem4==null){

      staffAssignmentDivisionItem4 = new ACRadioButtonItem();

      staffAssignmentDivisionItem4.setText("II型");

      staffAssignmentDivisionItem4.setGroup(getStaffAssignment1Division());

      staffAssignmentDivisionItem4.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivisionItem4();
    }
    return staffAssignmentDivisionItem4;

  }

  /**
   * 人員配置区分を取得します。
   * @return 人員配置区分
   */
  public ACValueArrayRadioButtonGroup getStaffAssignment2Division(){
    if(staffAssignment2Division==null){

      staffAssignment2Division = new ACValueArrayRadioButtonGroup();

      staffAssignment2Division.setBindPath("1230214");

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
  public ACRadioButtonItem getStaffAssignmentDivisionItem5(){
    if(staffAssignmentDivisionItem5==null){

      staffAssignmentDivisionItem5 = new ACRadioButtonItem();

      staffAssignmentDivisionItem5.setText("強化型以外");

      staffAssignmentDivisionItem5.setGroup(getStaffAssignment2Division());

      staffAssignmentDivisionItem5.setConstraints(VRLayout.FLOW_RETURN);

      addStaffAssignmentDivisionItem5();
    }
    return staffAssignmentDivisionItem5;

  }

  /**
   * 強化型Aを取得します。
   * @return 強化型A
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem6(){
    if(staffAssignmentDivisionItem6==null){

      staffAssignmentDivisionItem6 = new ACRadioButtonItem();

      staffAssignmentDivisionItem6.setText("強化型A");

      staffAssignmentDivisionItem6.setGroup(getStaffAssignment2Division());

      staffAssignmentDivisionItem6.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivisionItem6();
    }
    return staffAssignmentDivisionItem6;

  }

  /**
   * 強化型Bを取得します。
   * @return 強化型B
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem7(){
    if(staffAssignmentDivisionItem7==null){

      staffAssignmentDivisionItem7 = new ACRadioButtonItem();

      staffAssignmentDivisionItem7.setText("強化型B");

      staffAssignmentDivisionItem7.setGroup(getStaffAssignment2Division());

      staffAssignmentDivisionItem7.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivisionItem7();
    }
    return staffAssignmentDivisionItem7;

  }

  /**
   * 病室区分コンテナ(ショートステイ以外用)を取得します。
   * @return 病室区分コンテナ(ショートステイ以外用)
   */
  public ACLabelContainer getShortStayClinicRecuperationHospitalRoomContena(){
    if(shortStayClinicRecuperationHospitalRoomContena==null){

      shortStayClinicRecuperationHospitalRoomContena = new ACLabelContainer();

      shortStayClinicRecuperationHospitalRoomContena.setText("病室区分");

      shortStayClinicRecuperationHospitalRoomContena.setFollowChildEnabled(true);

      addShortStayClinicRecuperationHospitalRoomContena();
    }
    return shortStayClinicRecuperationHospitalRoomContena;

  }

  /**
   * 病室（診療所）を取得します。
   * @return 病室（診療所）
   */
  public ACValueArrayRadioButtonGroup getShortStayClinicRecuperationHospitalRoomRadio(){
    if(shortStayClinicRecuperationHospitalRoomRadio==null){

      shortStayClinicRecuperationHospitalRoomRadio = new ACValueArrayRadioButtonGroup();

      shortStayClinicRecuperationHospitalRoomRadio.setBindPath("1230203");

      shortStayClinicRecuperationHospitalRoomRadio.setUseClearButton(false);

      shortStayClinicRecuperationHospitalRoomRadio.setModel(getShortStayClinicRecuperationHospitalRoomRadioModel());

      shortStayClinicRecuperationHospitalRoomRadio.setValues(new int[]{1,2});

      addShortStayClinicRecuperationHospitalRoomRadio();
    }
    return shortStayClinicRecuperationHospitalRoomRadio;

  }

  /**
   * 病室（診療所）モデルを取得します。
   * @return 病室（診療所）モデル
   */
  protected ACListModelAdapter getShortStayClinicRecuperationHospitalRoomRadioModel(){
    if(shortStayClinicRecuperationHospitalRoomRadioModel==null){
      shortStayClinicRecuperationHospitalRoomRadioModel = new ACListModelAdapter();
      addShortStayClinicRecuperationHospitalRoomRadioModel();
    }
    return shortStayClinicRecuperationHospitalRoomRadioModel;
  }

  /**
   * 従来型個室を取得します。
   * @return 従来型個室
   */
  public ACRadioButtonItem getShortStayClinicRecuperationHospitalRoomRadioItem1(){
    if(shortStayClinicRecuperationHospitalRoomRadioItem1==null){

      shortStayClinicRecuperationHospitalRoomRadioItem1 = new ACRadioButtonItem();

      shortStayClinicRecuperationHospitalRoomRadioItem1.setText("従来型個室");

      shortStayClinicRecuperationHospitalRoomRadioItem1.setGroup(getShortStayClinicRecuperationHospitalRoomRadio());

      shortStayClinicRecuperationHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationHospitalRoomRadioItem1();
    }
    return shortStayClinicRecuperationHospitalRoomRadioItem1;

  }

  /**
   * 多床室を取得します。
   * @return 多床室
   */
  public ACRadioButtonItem getShortStayClinicRecuperationHospitalRoomRadioItem2(){
    if(shortStayClinicRecuperationHospitalRoomRadioItem2==null){

      shortStayClinicRecuperationHospitalRoomRadioItem2 = new ACRadioButtonItem();

      shortStayClinicRecuperationHospitalRoomRadioItem2.setText("多床室");

      shortStayClinicRecuperationHospitalRoomRadioItem2.setGroup(getShortStayClinicRecuperationHospitalRoomRadio());

      shortStayClinicRecuperationHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationHospitalRoomRadioItem2();
    }
    return shortStayClinicRecuperationHospitalRoomRadioItem2;

  }

  /**
   * 病室（ユニット型）を取得します。
   * @return 病室（ユニット型）
   */
  public ACValueArrayRadioButtonGroup getShortStayClinicRecuperationUnitHospitalRoomRadio(){
    if(shortStayClinicRecuperationUnitHospitalRoomRadio==null){

      shortStayClinicRecuperationUnitHospitalRoomRadio = new ACValueArrayRadioButtonGroup();

      shortStayClinicRecuperationUnitHospitalRoomRadio.setBindPath("1230204");

      shortStayClinicRecuperationUnitHospitalRoomRadio.setUseClearButton(false);

      shortStayClinicRecuperationUnitHospitalRoomRadio.setModel(getShortStayClinicRecuperationUnitHospitalRoomRadioModel());

      shortStayClinicRecuperationUnitHospitalRoomRadio.setValues(new int[]{1,2});

      addShortStayClinicRecuperationUnitHospitalRoomRadio();
    }
    return shortStayClinicRecuperationUnitHospitalRoomRadio;

  }

  /**
   * 病室（ユニット型）モデルを取得します。
   * @return 病室（ユニット型）モデル
   */
  protected ACListModelAdapter getShortStayClinicRecuperationUnitHospitalRoomRadioModel(){
    if(shortStayClinicRecuperationUnitHospitalRoomRadioModel==null){
      shortStayClinicRecuperationUnitHospitalRoomRadioModel = new ACListModelAdapter();
      addShortStayClinicRecuperationUnitHospitalRoomRadioModel();
    }
    return shortStayClinicRecuperationUnitHospitalRoomRadioModel;
  }

  /**
   * ユニット型個室を取得します。
   * @return ユニット型個室
   */
  public ACRadioButtonItem getShortStayClinicRecuperationUnitHospitalRoomRadioItem1(){
    if(shortStayClinicRecuperationUnitHospitalRoomRadioItem1==null){

      shortStayClinicRecuperationUnitHospitalRoomRadioItem1 = new ACRadioButtonItem();

      shortStayClinicRecuperationUnitHospitalRoomRadioItem1.setText("ユニット型個室");

      shortStayClinicRecuperationUnitHospitalRoomRadioItem1.setGroup(getShortStayClinicRecuperationUnitHospitalRoomRadio());

      shortStayClinicRecuperationUnitHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationUnitHospitalRoomRadioItem1();
    }
    return shortStayClinicRecuperationUnitHospitalRoomRadioItem1;

  }

  /**
   * ユニット型準個室を取得します。
   * @return ユニット型準個室
   */
  public ACRadioButtonItem getShortStayClinicRecuperationUnitHospitalRoomRadioItem2(){
    if(shortStayClinicRecuperationUnitHospitalRoomRadioItem2==null){

      shortStayClinicRecuperationUnitHospitalRoomRadioItem2 = new ACRadioButtonItem();

      shortStayClinicRecuperationUnitHospitalRoomRadioItem2.setText("ユニット型準個室");

      shortStayClinicRecuperationUnitHospitalRoomRadioItem2.setGroup(getShortStayClinicRecuperationUnitHospitalRoomRadio());

      shortStayClinicRecuperationUnitHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationUnitHospitalRoomRadioItem2();
    }
    return shortStayClinicRecuperationUnitHospitalRoomRadioItem2;

  }

  /**
   * 病室区分ラジオ(ショートステイ用)を取得します。
   * @return 病室区分ラジオ(ショートステイ用)
   */
  public ACValueArrayRadioButtonGroup getShortStayClinicRecuperationSickroomDivisionRadio(){
    if(shortStayClinicRecuperationSickroomDivisionRadio==null){

      shortStayClinicRecuperationSickroomDivisionRadio = new ACValueArrayRadioButtonGroup();

      getShortStayClinicRecuperationSickroomDivisionRadioContainer().setText("病室区分");

      shortStayClinicRecuperationSickroomDivisionRadio.setBindPath("1230212");

      shortStayClinicRecuperationSickroomDivisionRadio.setUseClearButton(false);

      shortStayClinicRecuperationSickroomDivisionRadio.setModel(getShortStayClinicRecuperationSickroomDivisionRadioModel());

      shortStayClinicRecuperationSickroomDivisionRadio.setValues(new int[]{1,2,3,4});

      addShortStayClinicRecuperationSickroomDivisionRadio();
    }
    return shortStayClinicRecuperationSickroomDivisionRadio;

  }

  /**
   * 病室区分ラジオ(ショートステイ用)コンテナを取得します。
   * @return 病室区分ラジオ(ショートステイ用)コンテナ
   */
  protected ACLabelContainer getShortStayClinicRecuperationSickroomDivisionRadioContainer(){
    if(shortStayClinicRecuperationSickroomDivisionRadioContainer==null){
      shortStayClinicRecuperationSickroomDivisionRadioContainer = new ACLabelContainer();
      shortStayClinicRecuperationSickroomDivisionRadioContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationSickroomDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationSickroomDivisionRadioContainer.add(getShortStayClinicRecuperationSickroomDivisionRadio(), null);
    }
    return shortStayClinicRecuperationSickroomDivisionRadioContainer;
  }

  /**
   * 病室区分ラジオ(ショートステイ用)モデルを取得します。
   * @return 病室区分ラジオ(ショートステイ用)モデル
   */
  protected ACListModelAdapter getShortStayClinicRecuperationSickroomDivisionRadioModel(){
    if(shortStayClinicRecuperationSickroomDivisionRadioModel==null){
      shortStayClinicRecuperationSickroomDivisionRadioModel = new ACListModelAdapter();
      addShortStayClinicRecuperationSickroomDivisionRadioModel();
    }
    return shortStayClinicRecuperationSickroomDivisionRadioModel;
  }

  /**
   * 従来型個室を取得します。
   * @return 従来型個室
   */
  public ACRadioButtonItem getShortStayClinicRecuperationSickroomDivisionRadioItem1(){
    if(shortStayClinicRecuperationSickroomDivisionRadioItem1==null){

      shortStayClinicRecuperationSickroomDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayClinicRecuperationSickroomDivisionRadioItem1.setText("従来型個室");

      shortStayClinicRecuperationSickroomDivisionRadioItem1.setGroup(getShortStayClinicRecuperationSickroomDivisionRadio());

      shortStayClinicRecuperationSickroomDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationSickroomDivisionRadioItem1();
    }
    return shortStayClinicRecuperationSickroomDivisionRadioItem1;

  }

  /**
   * 多床室を取得します。
   * @return 多床室
   */
  public ACRadioButtonItem getShortStayClinicRecuperationSickroomDivisionRadioItem2(){
    if(shortStayClinicRecuperationSickroomDivisionRadioItem2==null){

      shortStayClinicRecuperationSickroomDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayClinicRecuperationSickroomDivisionRadioItem2.setText("多床室");

      shortStayClinicRecuperationSickroomDivisionRadioItem2.setGroup(getShortStayClinicRecuperationSickroomDivisionRadio());

      shortStayClinicRecuperationSickroomDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayClinicRecuperationSickroomDivisionRadioItem2();
    }
    return shortStayClinicRecuperationSickroomDivisionRadioItem2;

  }

  /**
   * ユニット型個室を取得します。
   * @return ユニット型個室
   */
  public ACRadioButtonItem getShortStayClinicRecuperationSickroomDivisionRadioItem3(){
    if(shortStayClinicRecuperationSickroomDivisionRadioItem3==null){

      shortStayClinicRecuperationSickroomDivisionRadioItem3 = new ACRadioButtonItem();

      shortStayClinicRecuperationSickroomDivisionRadioItem3.setText("ユニット型個室");

      shortStayClinicRecuperationSickroomDivisionRadioItem3.setGroup(getShortStayClinicRecuperationSickroomDivisionRadio());

      shortStayClinicRecuperationSickroomDivisionRadioItem3.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationSickroomDivisionRadioItem3();
    }
    return shortStayClinicRecuperationSickroomDivisionRadioItem3;

  }

  /**
   * ユニット型準個室を取得します。
   * @return ユニット型準個室
   */
  public ACRadioButtonItem getShortStayClinicRecuperationSickroomDivisionRadioItem4(){
    if(shortStayClinicRecuperationSickroomDivisionRadioItem4==null){

      shortStayClinicRecuperationSickroomDivisionRadioItem4 = new ACRadioButtonItem();

      shortStayClinicRecuperationSickroomDivisionRadioItem4.setText("ユニット型準個室");

      shortStayClinicRecuperationSickroomDivisionRadioItem4.setGroup(getShortStayClinicRecuperationSickroomDivisionRadio());

      shortStayClinicRecuperationSickroomDivisionRadioItem4.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationSickroomDivisionRadioItem4();
    }
    return shortStayClinicRecuperationSickroomDivisionRadioItem4;

  }

  /**
   * 時間区分を取得します。
   * @return 時間区分
   */
  public ACComboBox getTankinyusyoTimeDivision(){
    if(tankinyusyoTimeDivision==null){

      tankinyusyoTimeDivision = new ACComboBox();

      getTankinyusyoTimeDivisionContainer().setText("時間区分");

      tankinyusyoTimeDivision.setBindPath("1230255");

      tankinyusyoTimeDivision.setEditable(false);

      tankinyusyoTimeDivision.setModelBindPath("1230255");

      tankinyusyoTimeDivision.setRenderBindPath("CONTENT");

      tankinyusyoTimeDivision.setModel(getTankinyusyoTimeDivisionModel());

      addTankinyusyoTimeDivision();
    }
    return tankinyusyoTimeDivision;

  }

  /**
   * 時間区分コンテナを取得します。
   * @return 時間区分コンテナ
   */
  protected ACLabelContainer getTankinyusyoTimeDivisionContainer(){
    if(tankinyusyoTimeDivisionContainer==null){
      tankinyusyoTimeDivisionContainer = new ACLabelContainer();
      tankinyusyoTimeDivisionContainer.setFollowChildEnabled(true);
      tankinyusyoTimeDivisionContainer.setVAlignment(VRLayout.CENTER);
      tankinyusyoTimeDivisionContainer.add(getTankinyusyoTimeDivision(), null);
    }
    return tankinyusyoTimeDivisionContainer;
  }

  /**
   * 時間区分モデルを取得します。
   * @return 時間区分モデル
   */
  protected ACComboBoxModelAdapter getTankinyusyoTimeDivisionModel(){
    if(tankinyusyoTimeDivisionModel==null){
      tankinyusyoTimeDivisionModel = new ACComboBoxModelAdapter();
      addTankinyusyoTimeDivisionModel();
    }
    return tankinyusyoTimeDivisionModel;
  }

  /**
   * 療養環境減算を取得します。
   * @return 療養環境減算
   */
  public ACValueArrayRadioButtonGroup getShortStayClinicRecuperationSubtractionType(){
    if(shortStayClinicRecuperationSubtractionType==null){

      shortStayClinicRecuperationSubtractionType = new ACValueArrayRadioButtonGroup();

      getShortStayClinicRecuperationSubtractionTypeContainer().setText("療養環境減算");

      shortStayClinicRecuperationSubtractionType.setBindPath("1230254");

      shortStayClinicRecuperationSubtractionType.setNoSelectIndex(0);

      shortStayClinicRecuperationSubtractionType.setUseClearButton(false);

      shortStayClinicRecuperationSubtractionType.setModel(getShortStayClinicRecuperationSubtractionTypeModel());

      shortStayClinicRecuperationSubtractionType.setValues(new int[]{1,3});

      addShortStayClinicRecuperationSubtractionType();
    }
    return shortStayClinicRecuperationSubtractionType;

  }

  /**
   * 療養環境減算コンテナを取得します。
   * @return 療養環境減算コンテナ
   */
  protected ACLabelContainer getShortStayClinicRecuperationSubtractionTypeContainer(){
    if(shortStayClinicRecuperationSubtractionTypeContainer==null){
      shortStayClinicRecuperationSubtractionTypeContainer = new ACLabelContainer();
      shortStayClinicRecuperationSubtractionTypeContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationSubtractionTypeContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationSubtractionTypeContainer.add(getShortStayClinicRecuperationSubtractionType(), null);
    }
    return shortStayClinicRecuperationSubtractionTypeContainer;
  }

  /**
   * 療養環境減算モデルを取得します。
   * @return 療養環境減算モデル
   */
  protected ACListModelAdapter getShortStayClinicRecuperationSubtractionTypeModel(){
    if(shortStayClinicRecuperationSubtractionTypeModel==null){
      shortStayClinicRecuperationSubtractionTypeModel = new ACListModelAdapter();
      addShortStayClinicRecuperationSubtractionTypeModel();
    }
    return shortStayClinicRecuperationSubtractionTypeModel;
  }

  /**
   * 基準型を取得します。
   * @return 基準型
   */
  public ACRadioButtonItem getShortStayClinicRecuperationSubtractionTypeNormal(){
    if(shortStayClinicRecuperationSubtractionTypeNormal==null){

      shortStayClinicRecuperationSubtractionTypeNormal = new ACRadioButtonItem();

      shortStayClinicRecuperationSubtractionTypeNormal.setText("基準型");

      shortStayClinicRecuperationSubtractionTypeNormal.setGroup(getShortStayClinicRecuperationSubtractionType());

      shortStayClinicRecuperationSubtractionTypeNormal.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationSubtractionTypeNormal();
    }
    return shortStayClinicRecuperationSubtractionTypeNormal;

  }

  /**
   * 減算型IIを取得します。
   * @return 減算型II
   */
  public ACRadioButtonItem getShortStayClinicRecuperationSubtractionType3(){
    if(shortStayClinicRecuperationSubtractionType3==null){

      shortStayClinicRecuperationSubtractionType3 = new ACRadioButtonItem();

      shortStayClinicRecuperationSubtractionType3.setText("減算型II");

      shortStayClinicRecuperationSubtractionType3.setGroup(getShortStayClinicRecuperationSubtractionType());

      shortStayClinicRecuperationSubtractionType3.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationSubtractionType3();
    }
    return shortStayClinicRecuperationSubtractionType3;

  }

  /**
   * 設備基準減算を取得します。
   * @return 設備基準減算
   */
  public ACValueArrayRadioButtonGroup getShortStayClinicRecuperationProvisionBase(){
    if(shortStayClinicRecuperationProvisionBase==null){

      shortStayClinicRecuperationProvisionBase = new ACValueArrayRadioButtonGroup();

      getShortStayClinicRecuperationProvisionBaseContainer().setText("設備基準減算");

      shortStayClinicRecuperationProvisionBase.setBindPath("1230252");

      shortStayClinicRecuperationProvisionBase.setUseClearButton(false);

      shortStayClinicRecuperationProvisionBase.setModel(getShortStayClinicRecuperationProvisionBaseModel());

      shortStayClinicRecuperationProvisionBase.setValues(new int[]{1,2});

      addShortStayClinicRecuperationProvisionBase();
    }
    return shortStayClinicRecuperationProvisionBase;

  }

  /**
   * 設備基準減算コンテナを取得します。
   * @return 設備基準減算コンテナ
   */
  protected ACLabelContainer getShortStayClinicRecuperationProvisionBaseContainer(){
    if(shortStayClinicRecuperationProvisionBaseContainer==null){
      shortStayClinicRecuperationProvisionBaseContainer = new ACLabelContainer();
      shortStayClinicRecuperationProvisionBaseContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationProvisionBaseContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationProvisionBaseContainer.add(getShortStayClinicRecuperationProvisionBase(), null);
    }
    return shortStayClinicRecuperationProvisionBaseContainer;
  }

  /**
   * 設備基準減算モデルを取得します。
   * @return 設備基準減算モデル
   */
  protected ACListModelAdapter getShortStayClinicRecuperationProvisionBaseModel(){
    if(shortStayClinicRecuperationProvisionBaseModel==null){
      shortStayClinicRecuperationProvisionBaseModel = new ACListModelAdapter();
      addShortStayClinicRecuperationProvisionBaseModel();
    }
    return shortStayClinicRecuperationProvisionBaseModel;
  }

  /**
   * 基準を取得します。
   * @return 基準
   */
  public ACRadioButtonItem getShortStayClinicRecuperationProvisionBaseNormal(){
    if(shortStayClinicRecuperationProvisionBaseNormal==null){

      shortStayClinicRecuperationProvisionBaseNormal = new ACRadioButtonItem();

      shortStayClinicRecuperationProvisionBaseNormal.setText("基準型");

      shortStayClinicRecuperationProvisionBaseNormal.setGroup(getShortStayClinicRecuperationProvisionBase());

      shortStayClinicRecuperationProvisionBaseNormal.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationProvisionBaseNormal();
    }
    return shortStayClinicRecuperationProvisionBaseNormal;

  }

  /**
   * 減算型を取得します。
   * @return 減算型
   */
  public ACRadioButtonItem getShortStayClinicRecuperationProvisionBaseType1(){
    if(shortStayClinicRecuperationProvisionBaseType1==null){

      shortStayClinicRecuperationProvisionBaseType1 = new ACRadioButtonItem();

      shortStayClinicRecuperationProvisionBaseType1.setText("減算型");

      shortStayClinicRecuperationProvisionBaseType1.setGroup(getShortStayClinicRecuperationProvisionBase());

      shortStayClinicRecuperationProvisionBaseType1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationProvisionBaseType1();
    }
    return shortStayClinicRecuperationProvisionBaseType1;

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
   * 認知症行動・心理症状緊急対応加算を取得します。
   * @return 認知症行動・心理症状緊急対応加算
   */
  public ACValueArrayRadioButtonGroup getDementiaActionAddRadioGroup(){
    if(dementiaActionAddRadioGroup==null){

      dementiaActionAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaActionAddRadioGroupContainer().setText("認知症行動・" + ACConstants.LINE_SEPARATOR + "心理症状緊急対応加算" + ACConstants.LINE_SEPARATOR + "（1月に7日を限度）");

      dementiaActionAddRadioGroup.setBindPath("1230256");

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

      dementiaActionAddRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addDementiaActionAddRadioItem2();
    }
    return dementiaActionAddRadioItem2;

  }

  /**
   * 緊急短期入所受入加算を取得します。
   * @return 緊急短期入所受入加算
   */
  public ACValueArrayRadioButtonGroup getShortStayClinicRecuperationEmergencyNetworkAddRadio(){
    if(shortStayClinicRecuperationEmergencyNetworkAddRadio==null){

      shortStayClinicRecuperationEmergencyNetworkAddRadio = new ACValueArrayRadioButtonGroup();

      getShortStayClinicRecuperationEmergencyNetworkAddRadioContainer().setText("緊急短期入所受入加算" + ACConstants.LINE_SEPARATOR + "（1月に7日を限度）");

      shortStayClinicRecuperationEmergencyNetworkAddRadio.setBindPath("1230213");

      shortStayClinicRecuperationEmergencyNetworkAddRadio.setUseClearButton(false);

      shortStayClinicRecuperationEmergencyNetworkAddRadio.setModel(getShortStayClinicRecuperationEmergencyNetworkAddRadioModel());

      shortStayClinicRecuperationEmergencyNetworkAddRadio.setValues(new int[]{1,2});

      addShortStayClinicRecuperationEmergencyNetworkAddRadio();
    }
    return shortStayClinicRecuperationEmergencyNetworkAddRadio;

  }

  /**
   * 緊急短期入所受入加算コンテナを取得します。
   * @return 緊急短期入所受入加算コンテナ
   */
  protected ACLabelContainer getShortStayClinicRecuperationEmergencyNetworkAddRadioContainer(){
    if(shortStayClinicRecuperationEmergencyNetworkAddRadioContainer==null){
      shortStayClinicRecuperationEmergencyNetworkAddRadioContainer = new ACLabelContainer();
      shortStayClinicRecuperationEmergencyNetworkAddRadioContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationEmergencyNetworkAddRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationEmergencyNetworkAddRadioContainer.add(getShortStayClinicRecuperationEmergencyNetworkAddRadio(), null);
    }
    return shortStayClinicRecuperationEmergencyNetworkAddRadioContainer;
  }

  /**
   * 緊急短期入所受入加算モデルを取得します。
   * @return 緊急短期入所受入加算モデル
   */
  protected ACListModelAdapter getShortStayClinicRecuperationEmergencyNetworkAddRadioModel(){
    if(shortStayClinicRecuperationEmergencyNetworkAddRadioModel==null){
      shortStayClinicRecuperationEmergencyNetworkAddRadioModel = new ACListModelAdapter();
      addShortStayClinicRecuperationEmergencyNetworkAddRadioModel();
    }
    return shortStayClinicRecuperationEmergencyNetworkAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayClinicRecuperationEmergencyNetworkAddRadioItem1(){
    if(shortStayClinicRecuperationEmergencyNetworkAddRadioItem1==null){

      shortStayClinicRecuperationEmergencyNetworkAddRadioItem1 = new ACRadioButtonItem();

      shortStayClinicRecuperationEmergencyNetworkAddRadioItem1.setText("なし");

      shortStayClinicRecuperationEmergencyNetworkAddRadioItem1.setGroup(getShortStayClinicRecuperationEmergencyNetworkAddRadio());

      shortStayClinicRecuperationEmergencyNetworkAddRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationEmergencyNetworkAddRadioItem1();
    }
    return shortStayClinicRecuperationEmergencyNetworkAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayClinicRecuperationEmergencyNetworkAddRadioItem2(){
    if(shortStayClinicRecuperationEmergencyNetworkAddRadioItem2==null){

      shortStayClinicRecuperationEmergencyNetworkAddRadioItem2 = new ACRadioButtonItem();

      shortStayClinicRecuperationEmergencyNetworkAddRadioItem2.setText("あり");

      shortStayClinicRecuperationEmergencyNetworkAddRadioItem2.setGroup(getShortStayClinicRecuperationEmergencyNetworkAddRadio());

      shortStayClinicRecuperationEmergencyNetworkAddRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationEmergencyNetworkAddRadioItem2();
    }
    return shortStayClinicRecuperationEmergencyNetworkAddRadioItem2;

  }

  /**
   * 若年性認知症利用者受入加算を取得します。
   * @return 若年性認知症利用者受入加算
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("若年性認知症利用者受入加算");

      youngDementiaPatinetAddRadioGroup.setBindPath("1230257");

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
  public ACValueArrayRadioButtonGroup getShortStayClinicRecuperationMeetingAndSendingOff(){
    if(shortStayClinicRecuperationMeetingAndSendingOff==null){

      shortStayClinicRecuperationMeetingAndSendingOff = new ACValueArrayRadioButtonGroup();

      getShortStayClinicRecuperationMeetingAndSendingOffContainer().setText("送迎加算");

      shortStayClinicRecuperationMeetingAndSendingOff.setBindPath("6");

      shortStayClinicRecuperationMeetingAndSendingOff.setUseClearButton(false);

      shortStayClinicRecuperationMeetingAndSendingOff.setModel(getShortStayClinicRecuperationMeetingAndSendingOffModel());

      shortStayClinicRecuperationMeetingAndSendingOff.setValues(new int[]{1,2,3});

      addShortStayClinicRecuperationMeetingAndSendingOff();
    }
    return shortStayClinicRecuperationMeetingAndSendingOff;

  }

  /**
   * 送迎加算コンテナを取得します。
   * @return 送迎加算コンテナ
   */
  protected ACLabelContainer getShortStayClinicRecuperationMeetingAndSendingOffContainer(){
    if(shortStayClinicRecuperationMeetingAndSendingOffContainer==null){
      shortStayClinicRecuperationMeetingAndSendingOffContainer = new ACLabelContainer();
      shortStayClinicRecuperationMeetingAndSendingOffContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationMeetingAndSendingOffContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationMeetingAndSendingOffContainer.add(getShortStayClinicRecuperationMeetingAndSendingOff(), null);
    }
    return shortStayClinicRecuperationMeetingAndSendingOffContainer;
  }

  /**
   * 送迎加算モデルを取得します。
   * @return 送迎加算モデル
   */
  protected ACListModelAdapter getShortStayClinicRecuperationMeetingAndSendingOffModel(){
    if(shortStayClinicRecuperationMeetingAndSendingOffModel==null){
      shortStayClinicRecuperationMeetingAndSendingOffModel = new ACListModelAdapter();
      addShortStayClinicRecuperationMeetingAndSendingOffModel();
    }
    return shortStayClinicRecuperationMeetingAndSendingOffModel;
  }

  /**
   * 送迎なしを取得します。
   * @return 送迎なし
   */
  public ACRadioButtonItem getShortStayClinicRecuperationMeetingAndSendingOffNone(){
    if(shortStayClinicRecuperationMeetingAndSendingOffNone==null){

      shortStayClinicRecuperationMeetingAndSendingOffNone = new ACRadioButtonItem();

      shortStayClinicRecuperationMeetingAndSendingOffNone.setText("送迎なし");

      shortStayClinicRecuperationMeetingAndSendingOffNone.setGroup(getShortStayClinicRecuperationMeetingAndSendingOff());

      shortStayClinicRecuperationMeetingAndSendingOffNone.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationMeetingAndSendingOffNone();
    }
    return shortStayClinicRecuperationMeetingAndSendingOffNone;

  }

  /**
   * 送迎片道を取得します。
   * @return 送迎片道
   */
  public ACRadioButtonItem getShortStayClinicRecuperationMeetingAndSendingOffOneWay(){
    if(shortStayClinicRecuperationMeetingAndSendingOffOneWay==null){

      shortStayClinicRecuperationMeetingAndSendingOffOneWay = new ACRadioButtonItem();

      shortStayClinicRecuperationMeetingAndSendingOffOneWay.setText("送迎片道");

      shortStayClinicRecuperationMeetingAndSendingOffOneWay.setGroup(getShortStayClinicRecuperationMeetingAndSendingOff());

      shortStayClinicRecuperationMeetingAndSendingOffOneWay.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationMeetingAndSendingOffOneWay();
    }
    return shortStayClinicRecuperationMeetingAndSendingOffOneWay;

  }

  /**
   * 送迎往復を取得します。
   * @return 送迎往復
   */
  public ACRadioButtonItem getShortStayClinicRecuperationMeetingAndSendingOffRoundTrip(){
    if(shortStayClinicRecuperationMeetingAndSendingOffRoundTrip==null){

      shortStayClinicRecuperationMeetingAndSendingOffRoundTrip = new ACRadioButtonItem();

      shortStayClinicRecuperationMeetingAndSendingOffRoundTrip.setText("送迎往復");

      shortStayClinicRecuperationMeetingAndSendingOffRoundTrip.setGroup(getShortStayClinicRecuperationMeetingAndSendingOff());

      shortStayClinicRecuperationMeetingAndSendingOffRoundTrip.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationMeetingAndSendingOffRoundTrip();
    }
    return shortStayClinicRecuperationMeetingAndSendingOffRoundTrip;

  }

  /**
   * 療養食加算を取得します。
   * @return 療養食加算
   */
  public ACValueArrayRadioButtonGroup getShortStayClinicRecuperationMedicalExpensesRadio(){
    if(shortStayClinicRecuperationMedicalExpensesRadio==null){

      shortStayClinicRecuperationMedicalExpensesRadio = new ACValueArrayRadioButtonGroup();

      getShortStayClinicRecuperationMedicalExpensesRadioContainer().setText("療養食加算");

      shortStayClinicRecuperationMedicalExpensesRadio.setBindPath("1230208");

      shortStayClinicRecuperationMedicalExpensesRadio.setUseClearButton(false);

      shortStayClinicRecuperationMedicalExpensesRadio.setModel(getShortStayClinicRecuperationMedicalExpensesRadioModel());

      shortStayClinicRecuperationMedicalExpensesRadio.setValues(new int[]{1,2});

      addShortStayClinicRecuperationMedicalExpensesRadio();
    }
    return shortStayClinicRecuperationMedicalExpensesRadio;

  }

  /**
   * 療養食加算コンテナを取得します。
   * @return 療養食加算コンテナ
   */
  protected ACLabelContainer getShortStayClinicRecuperationMedicalExpensesRadioContainer(){
    if(shortStayClinicRecuperationMedicalExpensesRadioContainer==null){
      shortStayClinicRecuperationMedicalExpensesRadioContainer = new ACLabelContainer();
      shortStayClinicRecuperationMedicalExpensesRadioContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationMedicalExpensesRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationMedicalExpensesRadioContainer.add(getShortStayClinicRecuperationMedicalExpensesRadio(), null);
    }
    return shortStayClinicRecuperationMedicalExpensesRadioContainer;
  }

  /**
   * 療養食加算モデルを取得します。
   * @return 療養食加算モデル
   */
  protected ACListModelAdapter getShortStayClinicRecuperationMedicalExpensesRadioModel(){
    if(shortStayClinicRecuperationMedicalExpensesRadioModel==null){
      shortStayClinicRecuperationMedicalExpensesRadioModel = new ACListModelAdapter();
      addShortStayClinicRecuperationMedicalExpensesRadioModel();
    }
    return shortStayClinicRecuperationMedicalExpensesRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayClinicRecuperationMedicalExpensesRadioItem1(){
    if(shortStayClinicRecuperationMedicalExpensesRadioItem1==null){

      shortStayClinicRecuperationMedicalExpensesRadioItem1 = new ACRadioButtonItem();

      shortStayClinicRecuperationMedicalExpensesRadioItem1.setText("なし");

      shortStayClinicRecuperationMedicalExpensesRadioItem1.setGroup(getShortStayClinicRecuperationMedicalExpensesRadio());

      shortStayClinicRecuperationMedicalExpensesRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationMedicalExpensesRadioItem1();
    }
    return shortStayClinicRecuperationMedicalExpensesRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayClinicRecuperationMedicalExpensesRadioItem2(){
    if(shortStayClinicRecuperationMedicalExpensesRadioItem2==null){

      shortStayClinicRecuperationMedicalExpensesRadioItem2 = new ACRadioButtonItem();

      shortStayClinicRecuperationMedicalExpensesRadioItem2.setText("あり");

      shortStayClinicRecuperationMedicalExpensesRadioItem2.setGroup(getShortStayClinicRecuperationMedicalExpensesRadio());

      shortStayClinicRecuperationMedicalExpensesRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationMedicalExpensesRadioItem2();
    }
    return shortStayClinicRecuperationMedicalExpensesRadioItem2;

  }

  /**
   * 人員減算を取得します。
   * @return 人員減算
   */
  public ACValueArrayRadioButtonGroup getShortStayClinicRecuperationStaffReduceRadio(){
    if(shortStayClinicRecuperationStaffReduceRadio==null){

      shortStayClinicRecuperationStaffReduceRadio = new ACValueArrayRadioButtonGroup();

      getShortStayClinicRecuperationStaffReduceRadioContainer().setText("人員減算");

      shortStayClinicRecuperationStaffReduceRadio.setBindPath("1230209");

      shortStayClinicRecuperationStaffReduceRadio.setUseClearButton(false);

      shortStayClinicRecuperationStaffReduceRadio.setModel(getShortStayClinicRecuperationStaffReduceRadioModel());

      shortStayClinicRecuperationStaffReduceRadio.setValues(new int[]{1,2});

      addShortStayClinicRecuperationStaffReduceRadio();
    }
    return shortStayClinicRecuperationStaffReduceRadio;

  }

  /**
   * 人員減算コンテナを取得します。
   * @return 人員減算コンテナ
   */
  protected ACLabelContainer getShortStayClinicRecuperationStaffReduceRadioContainer(){
    if(shortStayClinicRecuperationStaffReduceRadioContainer==null){
      shortStayClinicRecuperationStaffReduceRadioContainer = new ACLabelContainer();
      shortStayClinicRecuperationStaffReduceRadioContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationStaffReduceRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationStaffReduceRadioContainer.add(getShortStayClinicRecuperationStaffReduceRadio(), null);
    }
    return shortStayClinicRecuperationStaffReduceRadioContainer;
  }

  /**
   * 人員減算モデルを取得します。
   * @return 人員減算モデル
   */
  protected ACListModelAdapter getShortStayClinicRecuperationStaffReduceRadioModel(){
    if(shortStayClinicRecuperationStaffReduceRadioModel==null){
      shortStayClinicRecuperationStaffReduceRadioModel = new ACListModelAdapter();
      addShortStayClinicRecuperationStaffReduceRadioModel();
    }
    return shortStayClinicRecuperationStaffReduceRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayClinicRecuperationStaffReduceRadioItem1(){
    if(shortStayClinicRecuperationStaffReduceRadioItem1==null){

      shortStayClinicRecuperationStaffReduceRadioItem1 = new ACRadioButtonItem();

      shortStayClinicRecuperationStaffReduceRadioItem1.setText("なし");

      shortStayClinicRecuperationStaffReduceRadioItem1.setGroup(getShortStayClinicRecuperationStaffReduceRadio());

      shortStayClinicRecuperationStaffReduceRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationStaffReduceRadioItem1();
    }
    return shortStayClinicRecuperationStaffReduceRadioItem1;

  }

  /**
   * 定員超過を取得します。
   * @return 定員超過
   */
  public ACRadioButtonItem getShortStayClinicRecuperationStaffReduceRadioItem2(){
    if(shortStayClinicRecuperationStaffReduceRadioItem2==null){

      shortStayClinicRecuperationStaffReduceRadioItem2 = new ACRadioButtonItem();

      shortStayClinicRecuperationStaffReduceRadioItem2.setText("定員超過");

      shortStayClinicRecuperationStaffReduceRadioItem2.setGroup(getShortStayClinicRecuperationStaffReduceRadio());

      shortStayClinicRecuperationStaffReduceRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationStaffReduceRadioItem2();
    }
    return shortStayClinicRecuperationStaffReduceRadioItem2;

  }

  /**
   * 特定診療費ボタンを取得します。
   * @return 特定診療費ボタン
   */
  public ACMapBindButton getShortStayClinicRecuperationSpecificConsultationFee(){
    if(shortStayClinicRecuperationSpecificConsultationFee==null){

      shortStayClinicRecuperationSpecificConsultationFee = new ACMapBindButton();

      shortStayClinicRecuperationSpecificConsultationFee.setText("特定診療費");

      shortStayClinicRecuperationSpecificConsultationFee.setToolTipText("特定診療費を設定します。");

      addShortStayClinicRecuperationSpecificConsultationFee();
    }
    return shortStayClinicRecuperationSpecificConsultationFee;

  }

  /**
   * 設定ラベルを取得します。
   * @return 設定ラベル
   */
  public ACLabel getShortStayClinicRecuperationSpecificConsultationFeeOutline(){
    if(shortStayClinicRecuperationSpecificConsultationFeeOutline==null){

      shortStayClinicRecuperationSpecificConsultationFeeOutline = new ACLabel();

      shortStayClinicRecuperationSpecificConsultationFeeOutline.setText("設定なし");

      shortStayClinicRecuperationSpecificConsultationFeeOutline.setOpaque(true);
      shortStayClinicRecuperationSpecificConsultationFeeOutline.setBackground(new Color(255,255,172));

      addShortStayClinicRecuperationSpecificConsultationFeeOutline();
    }
    return shortStayClinicRecuperationSpecificConsultationFeeOutline;

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
   * 食事コンテナを取得します。
   * @return 食事コンテナ
   */
  public ACBackLabelContainer getShortStayClinicRecuperationDinnerContainer(){
    if(shortStayClinicRecuperationDinnerContainer==null){

      shortStayClinicRecuperationDinnerContainer = new ACBackLabelContainer();

      shortStayClinicRecuperationDinnerContainer.setFollowChildEnabled(true);

      addShortStayClinicRecuperationDinnerContainer();
    }
    return shortStayClinicRecuperationDinnerContainer;

  }

  /**
   * 食事提供を取得します。
   * @return 食事提供
   */
  public ACComboBox getShortStayClinicRecuperationDinnerOffer(){
    if(shortStayClinicRecuperationDinnerOffer==null){

      shortStayClinicRecuperationDinnerOffer = new ACComboBox();

      getShortStayClinicRecuperationDinnerOfferContainer().setText("食事提供");

      shortStayClinicRecuperationDinnerOffer.setBindPath("1230249");

      shortStayClinicRecuperationDinnerOffer.setEditable(false);

      shortStayClinicRecuperationDinnerOffer.setModelBindPath("1230249");

      shortStayClinicRecuperationDinnerOffer.setRenderBindPath("CONTENT");

      shortStayClinicRecuperationDinnerOffer.setModel(getShortStayClinicRecuperationDinnerOfferModel());

      addShortStayClinicRecuperationDinnerOffer();
    }
    return shortStayClinicRecuperationDinnerOffer;

  }

  /**
   * 食事提供コンテナを取得します。
   * @return 食事提供コンテナ
   */
  protected ACLabelContainer getShortStayClinicRecuperationDinnerOfferContainer(){
    if(shortStayClinicRecuperationDinnerOfferContainer==null){
      shortStayClinicRecuperationDinnerOfferContainer = new ACLabelContainer();
      shortStayClinicRecuperationDinnerOfferContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationDinnerOfferContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationDinnerOfferContainer.add(getShortStayClinicRecuperationDinnerOffer(), null);
    }
    return shortStayClinicRecuperationDinnerOfferContainer;
  }

  /**
   * 食事提供モデルを取得します。
   * @return 食事提供モデル
   */
  protected ACComboBoxModelAdapter getShortStayClinicRecuperationDinnerOfferModel(){
    if(shortStayClinicRecuperationDinnerOfferModel==null){
      shortStayClinicRecuperationDinnerOfferModel = new ACComboBoxModelAdapter();
      addShortStayClinicRecuperationDinnerOfferModel();
    }
    return shortStayClinicRecuperationDinnerOfferModel;
  }

  /**
   * 食事費用を取得します。
   * @return 食事費用
   */
  public ACTextField getShortStayClinicRecuperationDinnerCost(){
    if(shortStayClinicRecuperationDinnerCost==null){

      shortStayClinicRecuperationDinnerCost = new ACTextField();

      getShortStayClinicRecuperationDinnerCostContainer().setText("食事費用");

      shortStayClinicRecuperationDinnerCost.setBindPath("1230251");

      shortStayClinicRecuperationDinnerCost.setColumns(4);

      shortStayClinicRecuperationDinnerCost.setCharType(VRCharType.ONLY_DIGIT);

      shortStayClinicRecuperationDinnerCost.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayClinicRecuperationDinnerCost.setIMEMode(InputSubset.LATIN);

      shortStayClinicRecuperationDinnerCost.setMaxLength(5);

      addShortStayClinicRecuperationDinnerCost();
    }
    return shortStayClinicRecuperationDinnerCost;

  }

  /**
   * 食事費用コンテナを取得します。
   * @return 食事費用コンテナ
   */
  protected ACLabelContainer getShortStayClinicRecuperationDinnerCostContainer(){
    if(shortStayClinicRecuperationDinnerCostContainer==null){
      shortStayClinicRecuperationDinnerCostContainer = new ACLabelContainer();
      shortStayClinicRecuperationDinnerCostContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationDinnerCostContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationDinnerCostContainer.add(getShortStayClinicRecuperationDinnerCost(), null);
    }
    return shortStayClinicRecuperationDinnerCostContainer;
  }

  /**
   * 30日超を取得します。
   * @return 30日超
   */
  public ACIntegerCheckBox getShortStayClinicRecuperationEtc30Over(){
    if(shortStayClinicRecuperationEtc30Over==null){

      shortStayClinicRecuperationEtc30Over = new ACIntegerCheckBox();

      shortStayClinicRecuperationEtc30Over.setText("30日超");

      shortStayClinicRecuperationEtc30Over.setBindPath("5");

      shortStayClinicRecuperationEtc30Over.setSelectValue(2);

      shortStayClinicRecuperationEtc30Over.setUnSelectValue(1);

      addShortStayClinicRecuperationEtc30Over();
    }
    return shortStayClinicRecuperationEtc30Over;

  }

  /**
   * ユニットケアの整備を取得します。
   * @return ユニットケアの整備
   */
  public ACValueArrayRadioButtonGroup getShortStayClinicRecuperationUnitCareMaintenanceRadio(){
    if(shortStayClinicRecuperationUnitCareMaintenanceRadio==null){

      shortStayClinicRecuperationUnitCareMaintenanceRadio = new ACValueArrayRadioButtonGroup();

      getShortStayClinicRecuperationUnitCareMaintenanceRadioContainer().setText("ユニットケアの整備");

      shortStayClinicRecuperationUnitCareMaintenanceRadio.setBindPath("1230210");

      shortStayClinicRecuperationUnitCareMaintenanceRadio.setUseClearButton(false);

      shortStayClinicRecuperationUnitCareMaintenanceRadio.setModel(getShortStayClinicRecuperationUnitCareMaintenanceRadioModel());

      shortStayClinicRecuperationUnitCareMaintenanceRadio.setValues(new int[]{1,2});

      addShortStayClinicRecuperationUnitCareMaintenanceRadio();
    }
    return shortStayClinicRecuperationUnitCareMaintenanceRadio;

  }

  /**
   * ユニットケアの整備コンテナを取得します。
   * @return ユニットケアの整備コンテナ
   */
  protected ACLabelContainer getShortStayClinicRecuperationUnitCareMaintenanceRadioContainer(){
    if(shortStayClinicRecuperationUnitCareMaintenanceRadioContainer==null){
      shortStayClinicRecuperationUnitCareMaintenanceRadioContainer = new ACLabelContainer();
      shortStayClinicRecuperationUnitCareMaintenanceRadioContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationUnitCareMaintenanceRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationUnitCareMaintenanceRadioContainer.add(getShortStayClinicRecuperationUnitCareMaintenanceRadio(), null);
    }
    return shortStayClinicRecuperationUnitCareMaintenanceRadioContainer;
  }

  /**
   * ユニットケアの整備モデルを取得します。
   * @return ユニットケアの整備モデル
   */
  protected ACListModelAdapter getShortStayClinicRecuperationUnitCareMaintenanceRadioModel(){
    if(shortStayClinicRecuperationUnitCareMaintenanceRadioModel==null){
      shortStayClinicRecuperationUnitCareMaintenanceRadioModel = new ACListModelAdapter();
      addShortStayClinicRecuperationUnitCareMaintenanceRadioModel();
    }
    return shortStayClinicRecuperationUnitCareMaintenanceRadioModel;
  }

  /**
   * 未整備を取得します。
   * @return 未整備
   */
  public ACRadioButtonItem getShortStayClinicRecuperationUnitCareMaintenanceRadioitem1(){
    if(shortStayClinicRecuperationUnitCareMaintenanceRadioitem1==null){

      shortStayClinicRecuperationUnitCareMaintenanceRadioitem1 = new ACRadioButtonItem();

      shortStayClinicRecuperationUnitCareMaintenanceRadioitem1.setText("未整備");

      shortStayClinicRecuperationUnitCareMaintenanceRadioitem1.setGroup(getShortStayClinicRecuperationUnitCareMaintenanceRadio());

      shortStayClinicRecuperationUnitCareMaintenanceRadioitem1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationUnitCareMaintenanceRadioitem1();
    }
    return shortStayClinicRecuperationUnitCareMaintenanceRadioitem1;

  }

  /**
   * 整備を取得します。
   * @return 整備
   */
  public ACRadioButtonItem getShortStayClinicRecuperationUnitCareMaintenanceRadioitem2(){
    if(shortStayClinicRecuperationUnitCareMaintenanceRadioitem2==null){

      shortStayClinicRecuperationUnitCareMaintenanceRadioitem2 = new ACRadioButtonItem();

      shortStayClinicRecuperationUnitCareMaintenanceRadioitem2.setText("整備");

      shortStayClinicRecuperationUnitCareMaintenanceRadioitem2.setGroup(getShortStayClinicRecuperationUnitCareMaintenanceRadio());

      shortStayClinicRecuperationUnitCareMaintenanceRadioitem2.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationUnitCareMaintenanceRadioitem2();
    }
    return shortStayClinicRecuperationUnitCareMaintenanceRadioitem2;

  }

  /**
   * サービス提供体制強化加算を取得します。
   * @return サービス提供体制強化加算
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("サービス提供体制強化加算");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1230253");

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
   * コンストラクタです。
   */
  public QS001_12312_201504Design() {

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

  }

  /**
   * タブ1に内部項目を追加します。
   */
  protected void addTab1(){

    tab1.add(getShortStayClinicRecuperationInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getStaffAssignmentDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayClinicRecuperationHospitalRoomContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayClinicRecuperationSickroomDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getTankinyusyoTimeDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayClinicRecuperationSubtractionTypeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayClinicRecuperationProvisionBaseContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 施設等の区分に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationInstitutionDivisionRadio(){

  }

  /**
   * 施設等の区分モデルに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationInstitutionDivisionRadioModel(){

    getShortStayClinicRecuperationInstitutionDivisionRadioItem1().setButtonIndex(1);

    getShortStayClinicRecuperationInstitutionDivisionRadioModel().add(getShortStayClinicRecuperationInstitutionDivisionRadioItem1());

    getShortStayClinicRecuperationInstitutionDivisionRadioItem2().setButtonIndex(2);

    getShortStayClinicRecuperationInstitutionDivisionRadioModel().add(getShortStayClinicRecuperationInstitutionDivisionRadioItem2());

    getShortStayClinicRecuperationInstitutionDivisionRadioItem3().setButtonIndex(3);

    getShortStayClinicRecuperationInstitutionDivisionRadioModel().add(getShortStayClinicRecuperationInstitutionDivisionRadioItem3());

  }

  /**
   * 診療所に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationInstitutionDivisionRadioItem1(){

  }

  /**
   * ユニット型診療所に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationInstitutionDivisionRadioItem2(){

  }

  /**
   * 日帰りショートステイに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationInstitutionDivisionRadioItem3(){

  }

  /**
   * 人員配置区分コンテナに内部項目を追加します。
   */
  protected void addStaffAssignmentDivisionContainer(){

    staffAssignmentDivisionContainer.add(getStaffAssignment1Division(), VRLayout.FLOW_INSETLINE_RETURN);

    staffAssignmentDivisionContainer.add(getStaffAssignment2Division(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * II型に内部項目を追加します。
   */
  protected void addStaffAssignmentDivisionItem4(){

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

    getStaffAssignmentDivisionItem5().setButtonIndex(1);

    getStaffAssignment2DivisionModel().add(getStaffAssignmentDivisionItem5());

    getStaffAssignmentDivisionItem6().setButtonIndex(2);

    getStaffAssignment2DivisionModel().add(getStaffAssignmentDivisionItem6());

    getStaffAssignmentDivisionItem7().setButtonIndex(3);

    getStaffAssignment2DivisionModel().add(getStaffAssignmentDivisionItem7());

  }

  /**
   * 強化型以外に内部項目を追加します。
   */
  protected void addStaffAssignmentDivisionItem5(){

  }

  /**
   * 強化型Aに内部項目を追加します。
   */
  protected void addStaffAssignmentDivisionItem6(){

  }

  /**
   * 強化型Bに内部項目を追加します。
   */
  protected void addStaffAssignmentDivisionItem7(){

  }

  /**
   * 病室区分コンテナ(ショートステイ以外用)に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationHospitalRoomContena(){

    shortStayClinicRecuperationHospitalRoomContena.add(getShortStayClinicRecuperationHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayClinicRecuperationHospitalRoomContena.add(getShortStayClinicRecuperationUnitHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 病室（診療所）に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationHospitalRoomRadio(){

  }

  /**
   * 病室（診療所）モデルに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationHospitalRoomRadioModel(){

    getShortStayClinicRecuperationHospitalRoomRadioItem1().setButtonIndex(1);

    getShortStayClinicRecuperationHospitalRoomRadioModel().add(getShortStayClinicRecuperationHospitalRoomRadioItem1());

    getShortStayClinicRecuperationHospitalRoomRadioItem2().setButtonIndex(2);

    getShortStayClinicRecuperationHospitalRoomRadioModel().add(getShortStayClinicRecuperationHospitalRoomRadioItem2());

  }

  /**
   * 従来型個室に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationHospitalRoomRadioItem1(){

  }

  /**
   * 多床室に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationHospitalRoomRadioItem2(){

  }

  /**
   * 病室（ユニット型）に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationUnitHospitalRoomRadio(){

  }

  /**
   * 病室（ユニット型）モデルに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationUnitHospitalRoomRadioModel(){

    getShortStayClinicRecuperationUnitHospitalRoomRadioItem1().setButtonIndex(1);

    getShortStayClinicRecuperationUnitHospitalRoomRadioModel().add(getShortStayClinicRecuperationUnitHospitalRoomRadioItem1());

    getShortStayClinicRecuperationUnitHospitalRoomRadioItem2().setButtonIndex(2);

    getShortStayClinicRecuperationUnitHospitalRoomRadioModel().add(getShortStayClinicRecuperationUnitHospitalRoomRadioItem2());

  }

  /**
   * ユニット型個室に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationUnitHospitalRoomRadioItem1(){

  }

  /**
   * ユニット型準個室に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationUnitHospitalRoomRadioItem2(){

  }

  /**
   * 病室区分ラジオ(ショートステイ用)に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationSickroomDivisionRadio(){

  }

  /**
   * 病室区分ラジオ(ショートステイ用)モデルに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationSickroomDivisionRadioModel(){

    getShortStayClinicRecuperationSickroomDivisionRadioItem1().setButtonIndex(1);

    getShortStayClinicRecuperationSickroomDivisionRadioModel().add(getShortStayClinicRecuperationSickroomDivisionRadioItem1());

    getShortStayClinicRecuperationSickroomDivisionRadioItem2().setButtonIndex(2);

    getShortStayClinicRecuperationSickroomDivisionRadioModel().add(getShortStayClinicRecuperationSickroomDivisionRadioItem2());

    getShortStayClinicRecuperationSickroomDivisionRadioItem3().setButtonIndex(3);

    getShortStayClinicRecuperationSickroomDivisionRadioModel().add(getShortStayClinicRecuperationSickroomDivisionRadioItem3());

    getShortStayClinicRecuperationSickroomDivisionRadioItem4().setButtonIndex(4);

    getShortStayClinicRecuperationSickroomDivisionRadioModel().add(getShortStayClinicRecuperationSickroomDivisionRadioItem4());

  }

  /**
   * 従来型個室に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationSickroomDivisionRadioItem1(){

  }

  /**
   * 多床室に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationSickroomDivisionRadioItem2(){

  }

  /**
   * ユニット型個室に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationSickroomDivisionRadioItem3(){

  }

  /**
   * ユニット型準個室に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationSickroomDivisionRadioItem4(){

  }

  /**
   * 時間区分に内部項目を追加します。
   */
  protected void addTankinyusyoTimeDivision(){

  }

  /**
   * 時間区分モデルに内部項目を追加します。
   */
  protected void addTankinyusyoTimeDivisionModel(){

  }

  /**
   * 療養環境減算に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationSubtractionType(){

  }

  /**
   * 療養環境減算モデルに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationSubtractionTypeModel(){

    getShortStayClinicRecuperationSubtractionTypeNormal().setButtonIndex(1);

    getShortStayClinicRecuperationSubtractionTypeModel().add(getShortStayClinicRecuperationSubtractionTypeNormal());

    getShortStayClinicRecuperationSubtractionType3().setButtonIndex(3);

    getShortStayClinicRecuperationSubtractionTypeModel().add(getShortStayClinicRecuperationSubtractionType3());

  }

  /**
   * 基準型に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationSubtractionTypeNormal(){

  }

  /**
   * 減算型IIに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationSubtractionType3(){

  }

  /**
   * 設備基準減算に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationProvisionBase(){

  }

  /**
   * 設備基準減算モデルに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationProvisionBaseModel(){

    getShortStayClinicRecuperationProvisionBaseNormal().setButtonIndex(1);

    getShortStayClinicRecuperationProvisionBaseModel().add(getShortStayClinicRecuperationProvisionBaseNormal());

    getShortStayClinicRecuperationProvisionBaseType1().setButtonIndex(2);

    getShortStayClinicRecuperationProvisionBaseModel().add(getShortStayClinicRecuperationProvisionBaseType1());

  }

  /**
   * 基準に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationProvisionBaseNormal(){

  }

  /**
   * 減算型に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationProvisionBaseType1(){

  }

  /**
   * タブ2に内部項目を追加します。
   */
  protected void addTab2(){

    tab2.add(getDementiaActionAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayClinicRecuperationEmergencyNetworkAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayClinicRecuperationMeetingAndSendingOffContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayClinicRecuperationMedicalExpensesRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayClinicRecuperationStaffReduceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayClinicRecuperationSpecificConsultationFee(), VRLayout.FLOW);

    tab2.add(getShortStayClinicRecuperationSpecificConsultationFeeOutline(), VRLayout.FLOW_RETURN);

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
   * 緊急短期入所受入加算に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationEmergencyNetworkAddRadio(){

  }

  /**
   * 緊急短期入所受入加算モデルに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationEmergencyNetworkAddRadioModel(){

    getShortStayClinicRecuperationEmergencyNetworkAddRadioItem1().setButtonIndex(1);

    getShortStayClinicRecuperationEmergencyNetworkAddRadioModel().add(getShortStayClinicRecuperationEmergencyNetworkAddRadioItem1());

    getShortStayClinicRecuperationEmergencyNetworkAddRadioItem2().setButtonIndex(2);

    getShortStayClinicRecuperationEmergencyNetworkAddRadioModel().add(getShortStayClinicRecuperationEmergencyNetworkAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationEmergencyNetworkAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationEmergencyNetworkAddRadioItem2(){

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
  protected void addShortStayClinicRecuperationMeetingAndSendingOff(){

  }

  /**
   * 送迎加算モデルに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationMeetingAndSendingOffModel(){

    getShortStayClinicRecuperationMeetingAndSendingOffNone().setButtonIndex(1);

    getShortStayClinicRecuperationMeetingAndSendingOffModel().add(getShortStayClinicRecuperationMeetingAndSendingOffNone());

    getShortStayClinicRecuperationMeetingAndSendingOffOneWay().setButtonIndex(2);

    getShortStayClinicRecuperationMeetingAndSendingOffModel().add(getShortStayClinicRecuperationMeetingAndSendingOffOneWay());

    getShortStayClinicRecuperationMeetingAndSendingOffRoundTrip().setButtonIndex(3);

    getShortStayClinicRecuperationMeetingAndSendingOffModel().add(getShortStayClinicRecuperationMeetingAndSendingOffRoundTrip());

  }

  /**
   * 送迎なしに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationMeetingAndSendingOffNone(){

  }

  /**
   * 送迎片道に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationMeetingAndSendingOffOneWay(){

  }

  /**
   * 送迎往復に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationMeetingAndSendingOffRoundTrip(){

  }

  /**
   * 療養食加算に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationMedicalExpensesRadio(){

  }

  /**
   * 療養食加算モデルに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationMedicalExpensesRadioModel(){

    getShortStayClinicRecuperationMedicalExpensesRadioItem1().setButtonIndex(1);

    getShortStayClinicRecuperationMedicalExpensesRadioModel().add(getShortStayClinicRecuperationMedicalExpensesRadioItem1());

    getShortStayClinicRecuperationMedicalExpensesRadioItem2().setButtonIndex(2);

    getShortStayClinicRecuperationMedicalExpensesRadioModel().add(getShortStayClinicRecuperationMedicalExpensesRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationMedicalExpensesRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationMedicalExpensesRadioItem2(){

  }

  /**
   * 人員減算に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationStaffReduceRadio(){

  }

  /**
   * 人員減算モデルに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationStaffReduceRadioModel(){

    getShortStayClinicRecuperationStaffReduceRadioItem1().setButtonIndex(1);

    getShortStayClinicRecuperationStaffReduceRadioModel().add(getShortStayClinicRecuperationStaffReduceRadioItem1());

    getShortStayClinicRecuperationStaffReduceRadioItem2().setButtonIndex(2);

    getShortStayClinicRecuperationStaffReduceRadioModel().add(getShortStayClinicRecuperationStaffReduceRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationStaffReduceRadioItem1(){

  }

  /**
   * 定員超過に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationStaffReduceRadioItem2(){

  }

  /**
   * 特定診療費ボタンに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationSpecificConsultationFee(){

  }

  /**
   * 設定ラベルに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationSpecificConsultationFeeOutline(){

  }

  /**
   * タブ3に内部項目を追加します。
   */
  protected void addTab3(){

    tab3.add(getShortStayClinicRecuperationDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    tab3.add(getShortStayClinicRecuperationEtc30Over(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getShortStayClinicRecuperationUnitCareMaintenanceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 食事コンテナに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationDinnerContainer(){

    shortStayClinicRecuperationDinnerContainer.add(getShortStayClinicRecuperationDinnerOfferContainer(), VRLayout.FLOW);

    shortStayClinicRecuperationDinnerContainer.add(getShortStayClinicRecuperationDinnerCostContainer(), VRLayout.FLOW);

  }

  /**
   * 食事提供に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationDinnerOffer(){

  }

  /**
   * 食事提供モデルに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationDinnerOfferModel(){

  }

  /**
   * 食事費用に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationDinnerCost(){

  }

  /**
   * 30日超に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationEtc30Over(){

  }

  /**
   * ユニットケアの整備に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationUnitCareMaintenanceRadio(){

  }

  /**
   * ユニットケアの整備モデルに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationUnitCareMaintenanceRadioModel(){

    getShortStayClinicRecuperationUnitCareMaintenanceRadioitem1().setButtonIndex(1);

    getShortStayClinicRecuperationUnitCareMaintenanceRadioModel().add(getShortStayClinicRecuperationUnitCareMaintenanceRadioitem1());

    getShortStayClinicRecuperationUnitCareMaintenanceRadioitem2().setButtonIndex(2);

    getShortStayClinicRecuperationUnitCareMaintenanceRadioModel().add(getShortStayClinicRecuperationUnitCareMaintenanceRadioitem2());

  }

  /**
   * 未整備に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationUnitCareMaintenanceRadioitem1(){

  }

  /**
   * 整備に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationUnitCareMaintenanceRadioitem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_12312_201504Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001_12312_201504Design getThis() {
    return this;
  }
}
