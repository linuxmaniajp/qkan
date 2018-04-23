
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
 * 作成日: 2018/02/28  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン短期入所療養介護（介護老人保健施設） (QS001_12211_201804)
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
 * サービスパターン短期入所療養介護（介護老人保健施設）画面項目デザイン(QS001_12211_201804) 
 */
public class QS001_12211_201804Design extends QS001ServicePanel {
  //GUIコンポーネント

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup shortStayRecuperationHealthFacilityInstitutionDivisionRadio;

  private ACLabelContainer shortStayRecuperationHealthFacilityInstitutionDivisionRadioContainer;

  private ACListModelAdapter shortStayRecuperationHealthFacilityInstitutionDivisionRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem3;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem4;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem5;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem6;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem7;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem8;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem9;

  private ACLabelContainer shortStayRecuperationHealthPersonnelDivisionContainer;

  private ACValueArrayRadioButtonGroup shortStayRecuperationHealthPersonnelDivision1;

  private ACListModelAdapter shortStayRecuperationHealthPersonnelDivision1Model;

  private ACRadioButtonItem shortStayRecuperationHealthPersonnelDivision11;

  private ACRadioButtonItem shortStayRecuperationHealthPersonnelDivision12;

  private ACLabelContainer shortStayRecuperationHealthFacilityHospitalRoomDivisionContena;

  private ACValueArrayRadioButtonGroup shortStayRecuperationHealthFacilityHospitalRoomDivisionRadio;

  private ACListModelAdapter shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem2;

  private ACValueArrayRadioButtonGroup shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio;

  private ACListModelAdapter shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem2;

  private ACValueArrayRadioButtonGroup shortStayRecuperationHealthFacilitySickroomDivisionRadio;

  private ACLabelContainer shortStayRecuperationHealthFacilitySickroomDivisionRadioContainer;

  private ACListModelAdapter shortStayRecuperationHealthFacilitySickroomDivisionRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilitySickroomDivisionRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthFacilitySickroomDivisionRadioItem2;

  private ACRadioButtonItem shortStayRecuperationHealthFacilitySickroomDivisionRadioItem3;

  private ACRadioButtonItem shortStayRecuperationHealthFacilitySickroomDivisionRadioItem4;

  private ACPanel tab2;

  private ACComboBox tankinyusyoTimeDivision;

  private ACLabelContainer tankinyusyoTimeDivisionContainer;

  private ACComboBoxModelAdapter tankinyusyoTimeDivisionModel;

  private ACValueArrayRadioButtonGroup shortStayRecuperationHealthNightWorkConditionRadio;

  private ACLabelContainer shortStayRecuperationHealthNightWorkConditionRadioContainer;

  private ACListModelAdapter shortStayRecuperationHealthNightWorkConditionRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthNightWorkConditionRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthNightWorkConditionRadioItem2;

  private ACValueArrayRadioButtonGroup nightStaffDispositionAddRadioGroup;

  private ACLabelContainer nightStaffDispositionAddRadioGroupContainer;

  private ACListModelAdapter nightStaffDispositionAddRadioGroupModel;

  private ACRadioButtonItem nightStaffDispositionAddRadioItem1;

  private ACRadioButtonItem nightStaffDispositionAddRadioItem2;

  private ACValueArrayRadioButtonGroup houmonRehabilitationShortConcentrationAddRadio;

  private ACLabelContainer houmonRehabilitationShortConcentrationAddRadioContainer;

  private ACListModelAdapter houmonRehabilitationShortConcentrationAddRadioModel;

  private ACRadioButtonItem houmonRehabilitationShortConcentrationAddRadioItem1;

  private ACRadioButtonItem houmonRehabilitationShortConcentrationAddRadioItem2;

  private ACValueArrayRadioButtonGroup shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio;

  private ACLabelContainer shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioContainer;

  private ACListModelAdapter shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem2;

  private ACValueArrayRadioButtonGroup dementiaActionAddRadioGroup;

  private ACLabelContainer dementiaActionAddRadioGroupContainer;

  private ACListModelAdapter dementiaActionAddRadioGroupModel;

  private ACRadioButtonItem dementiaActionAddRadioItem1;

  private ACRadioButtonItem dementiaActionAddRadioItem2;

  private ACValueArrayRadioButtonGroup emergencyAcceptanceRadioGroup;

  private ACLabelContainer emergencyAcceptanceRadioGroupContainer;

  private ACListModelAdapter emergencyAcceptanceRadioGroupModel;

  private ACRadioButtonItem emergencyAcceptanceRadioItem1;

  private ACRadioButtonItem emergencyAcceptanceRadioItem2;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACPanel tab3;

  private ACValueArrayRadioButtonGroup shortStayRecuperationHealthFacilityMeetingAndSendingOff;

  private ACLabelContainer shortStayRecuperationHealthFacilityMeetingAndSendingOffContainer;

  private ACListModelAdapter shortStayRecuperationHealthFacilityMeetingAndSendingOffModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityMeetingAndSendingOffNone;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityMeetingAndSendingOffOneWay;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityMeetingAndSendingOffRoundTrip;

  private ACValueArrayRadioButtonGroup shortStayRecuperationHealthFacilityUrgentTimeStepRadio;

  private ACLabelContainer shortStayRecuperationHealthFacilityUrgentTimeStepRadioContainer;

  private ACListModelAdapter shortStayRecuperationHealthFacilityUrgentTimeStepRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem2;

  private ACValueArrayRadioButtonGroup shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio;

  private ACLabelContainer shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioContainer;

  private ACListModelAdapter shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem2;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem3;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem4;

  private ACMapBindButton shortStayRecuperationHealthFacilitySpecialMedicalExpense;

  private ACLabel shortStayRecuperationHealthFacilitySpecialMedicalExpenseLabel;

  private ACIntegerCheckBox shortStayRecuperationHealthFacilityEtc30Over;

  private ACValueArrayRadioButtonGroup shortStayRecuperationHealthFacilityPersonSubtraction;

  private ACLabelContainer shortStayRecuperationHealthFacilityPersonSubtractionContainer;

  private ACListModelAdapter shortStayRecuperationHealthFacilityPersonSubtractionModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityPersonSubtractionNot;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityPersonSubtractionExcess;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityPersonSubtractionStaffLack;

  private ACBackLabelContainer shortStayRecuperationHealthFacilityDinnerContainer;

  private ACComboBox shortStayRecuperationHealthFacilityDinnerOffer;

  private ACLabelContainer shortStayRecuperationHealthFacilityDinnerOfferContainer;

  private ACComboBoxModelAdapter shortStayRecuperationHealthFacilityDinnerOfferModel;

  private ACTextField shortStayRecuperationHealthFacilityDinnerCost;

  private ACLabelContainer shortStayRecuperationHealthFacilityDinnerCostContainer;

  private ACValueArrayRadioButtonGroup shortStayRecuperationHealthUnitCareAddRadio;

  private ACLabelContainer shortStayRecuperationHealthUnitCareAddRadioContainer;

  private ACListModelAdapter shortStayRecuperationHealthUnitCareAddRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthUnitCareAddRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthUnitCareAddRadioItem2;

  private ACLabelContainer shortStayRecuperationHealthFacilityRecuperationGroup;

  private ACIntegerCheckBox nurseStructuralAddRadioItem1;

  private ACIntegerCheckBox nurseStructuralAddRadioItem2;

  private ACPanel tab4;

  private ACValueArrayRadioButtonGroup severelyMedicalManagementAdd;

  private ACLabelContainer severelyMedicalManagementAddContainer;

  private ACListModelAdapter severelyMedicalManagementAddModel;

  private ACRadioButtonItem severelyMedicalManagementAddItem1;

  private ACRadioButtonItem severelyMedicalManagementAddItem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem5;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACValueArrayRadioButtonGroup stayReturnSupportRyoyoAddRadio;

  private ACLabelContainer stayReturnSupportRyoyoAddRadioContainer;

  private ACListModelAdapter stayReturnSupportRyoyoAddRadioModel;

  private ACRadioButtonItem stayReturnSupportRyoyoAddRadioItem1;

  private ACRadioButtonItem stayReturnSupportRyoyoAddRadioItem2;

  private ACValueArrayRadioButtonGroup dementiaProfessionalCareAddRadioGroup;

  private ACLabelContainer dementiaProfessionalCareAddRadioGroupContainer;

  private ACListModelAdapter dementiaProfessionalCareAddRadioGroupModel;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem1;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem2;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem3;

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
  public ACValueArrayRadioButtonGroup getShortStayRecuperationHealthFacilityInstitutionDivisionRadio(){
    if(shortStayRecuperationHealthFacilityInstitutionDivisionRadio==null){

      shortStayRecuperationHealthFacilityInstitutionDivisionRadio = new ACValueArrayRadioButtonGroup();

      getShortStayRecuperationHealthFacilityInstitutionDivisionRadioContainer().setText("施設等の区分");

      shortStayRecuperationHealthFacilityInstitutionDivisionRadio.setBindPath("1220101");

      shortStayRecuperationHealthFacilityInstitutionDivisionRadio.setUseClearButton(false);

      shortStayRecuperationHealthFacilityInstitutionDivisionRadio.setModel(getShortStayRecuperationHealthFacilityInstitutionDivisionRadioModel());

      shortStayRecuperationHealthFacilityInstitutionDivisionRadio.setValues(new int[]{1,2,3,4,5,6,7,8,9});

      addShortStayRecuperationHealthFacilityInstitutionDivisionRadio();
    }
    return shortStayRecuperationHealthFacilityInstitutionDivisionRadio;

  }

  /**
   * 施設等の区分コンテナを取得します。
   * @return 施設等の区分コンテナ
   */
  protected ACLabelContainer getShortStayRecuperationHealthFacilityInstitutionDivisionRadioContainer(){
    if(shortStayRecuperationHealthFacilityInstitutionDivisionRadioContainer==null){
      shortStayRecuperationHealthFacilityInstitutionDivisionRadioContainer = new ACLabelContainer();
      shortStayRecuperationHealthFacilityInstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthFacilityInstitutionDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayRecuperationHealthFacilityInstitutionDivisionRadioContainer.add(getShortStayRecuperationHealthFacilityInstitutionDivisionRadio(), null);
    }
    return shortStayRecuperationHealthFacilityInstitutionDivisionRadioContainer;
  }

  /**
   * 施設等の区分モデルを取得します。
   * @return 施設等の区分モデル
   */
  protected ACListModelAdapter getShortStayRecuperationHealthFacilityInstitutionDivisionRadioModel(){
    if(shortStayRecuperationHealthFacilityInstitutionDivisionRadioModel==null){
      shortStayRecuperationHealthFacilityInstitutionDivisionRadioModel = new ACListModelAdapter();
      addShortStayRecuperationHealthFacilityInstitutionDivisionRadioModel();
    }
    return shortStayRecuperationHealthFacilityInstitutionDivisionRadioModel;
  }

  /**
   * 介護老人保健施設（I）を取得します。
   * @return 介護老人保健施設（I）
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1(){
    if(shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1==null){

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1.setText("介護老人保健施設（I）");

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1.setGroup(getShortStayRecuperationHealthFacilityInstitutionDivisionRadio());

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1();
    }
    return shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1;

  }

  /**
   * ユニット型介護老人保健施設（I）を取得します。
   * @return ユニット型介護老人保健施設（I）
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2(){
    if(shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2==null){

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2.setText("ユニット型介護老人保健施設（I）");

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2.setGroup(getShortStayRecuperationHealthFacilityInstitutionDivisionRadio());

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2();
    }
    return shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2;

  }

  /**
   * 介護老人保健施設（II）を取得します。
   * @return 介護老人保健施設（II）
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem3(){
    if(shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem3==null){

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem3 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem3.setText("介護老人保健施設（II）");

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem3.setGroup(getShortStayRecuperationHealthFacilityInstitutionDivisionRadio());

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem3();
    }
    return shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem3;

  }

  /**
   * ユニット型介護老人保健施設（II）を取得します。
   * @return ユニット型介護老人保健施設（II）
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem4(){
    if(shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem4==null){

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem4 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem4.setText("ユニット型介護老人保健施設（II）");

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem4.setGroup(getShortStayRecuperationHealthFacilityInstitutionDivisionRadio());

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem4();
    }
    return shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem4;

  }

  /**
   * 介護老人保健施設（III）を取得します。
   * @return 介護老人保健施設（III）
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem5(){
    if(shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem5==null){

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem5 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem5.setText("介護老人保健施設（III）");

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem5.setGroup(getShortStayRecuperationHealthFacilityInstitutionDivisionRadio());

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem5.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem5();
    }
    return shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem5;

  }

  /**
   * ユニット型介護老人保健施設（III）を取得します。
   * @return ユニット型介護老人保健施設（III）
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem6(){
    if(shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem6==null){

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem6 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem6.setText("ユニット型介護老人保健施設（III）");

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem6.setGroup(getShortStayRecuperationHealthFacilityInstitutionDivisionRadio());

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem6.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem6();
    }
    return shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem6;

  }

  /**
   * 介護老人保健施設（IV）を取得します。
   * @return 介護老人保健施設（IV）
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem7(){
    if(shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem7==null){

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem7 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem7.setText("介護老人保健施設（IV）");

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem7.setGroup(getShortStayRecuperationHealthFacilityInstitutionDivisionRadio());

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem7.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem7();
    }
    return shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem7;

  }

  /**
   * ユニット型介護老人保健施設（IV）を取得します。
   * @return ユニット型介護老人保健施設（IV）
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem8(){
    if(shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem8==null){

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem8 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem8.setText("ユニット型介護老人保健施設（IV）");

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem8.setGroup(getShortStayRecuperationHealthFacilityInstitutionDivisionRadio());

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem8.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem8();
    }
    return shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem8;

  }

  /**
   * 日帰りショートステイを取得します。
   * @return 日帰りショートステイ
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem9(){
    if(shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem9==null){

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem9 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem9.setText("日帰りショートステイ");

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem9.setGroup(getShortStayRecuperationHealthFacilityInstitutionDivisionRadio());

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem9.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem9();
    }
    return shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem9;

  }

  /**
   * 人員配置区分コンテナを取得します。
   * @return 人員配置区分コンテナ
   */
  public ACLabelContainer getShortStayRecuperationHealthPersonnelDivisionContainer(){
    if(shortStayRecuperationHealthPersonnelDivisionContainer==null){

      shortStayRecuperationHealthPersonnelDivisionContainer = new ACLabelContainer();

      shortStayRecuperationHealthPersonnelDivisionContainer.setText("人員配置区分");

      shortStayRecuperationHealthPersonnelDivisionContainer.setFollowChildEnabled(true);

      addShortStayRecuperationHealthPersonnelDivisionContainer();
    }
    return shortStayRecuperationHealthPersonnelDivisionContainer;

  }

  /**
   * 人員配置区分を取得します。
   * @return 人員配置区分
   */
  public ACValueArrayRadioButtonGroup getShortStayRecuperationHealthPersonnelDivision1(){
    if(shortStayRecuperationHealthPersonnelDivision1==null){

      shortStayRecuperationHealthPersonnelDivision1 = new ACValueArrayRadioButtonGroup();

      shortStayRecuperationHealthPersonnelDivision1.setBindPath("1220131");

      shortStayRecuperationHealthPersonnelDivision1.setUseClearButton(false);

      shortStayRecuperationHealthPersonnelDivision1.setModel(getShortStayRecuperationHealthPersonnelDivision1Model());

      shortStayRecuperationHealthPersonnelDivision1.setValues(new int[]{1,2});

      addShortStayRecuperationHealthPersonnelDivision1();
    }
    return shortStayRecuperationHealthPersonnelDivision1;

  }

  /**
   * 人員配置区分モデルを取得します。
   * @return 人員配置区分モデル
   */
  protected ACListModelAdapter getShortStayRecuperationHealthPersonnelDivision1Model(){
    if(shortStayRecuperationHealthPersonnelDivision1Model==null){
      shortStayRecuperationHealthPersonnelDivision1Model = new ACListModelAdapter();
      addShortStayRecuperationHealthPersonnelDivision1Model();
    }
    return shortStayRecuperationHealthPersonnelDivision1Model;
  }

  /**
   * 基本型を取得します。
   * @return 基本型
   */
  public ACRadioButtonItem getShortStayRecuperationHealthPersonnelDivision11(){
    if(shortStayRecuperationHealthPersonnelDivision11==null){

      shortStayRecuperationHealthPersonnelDivision11 = new ACRadioButtonItem();

      shortStayRecuperationHealthPersonnelDivision11.setText("基本型");

      shortStayRecuperationHealthPersonnelDivision11.setGroup(getShortStayRecuperationHealthPersonnelDivision1());

      shortStayRecuperationHealthPersonnelDivision11.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthPersonnelDivision11();
    }
    return shortStayRecuperationHealthPersonnelDivision11;

  }

  /**
   * 在宅強化型を取得します。
   * @return 在宅強化型
   */
  public ACRadioButtonItem getShortStayRecuperationHealthPersonnelDivision12(){
    if(shortStayRecuperationHealthPersonnelDivision12==null){

      shortStayRecuperationHealthPersonnelDivision12 = new ACRadioButtonItem();

      shortStayRecuperationHealthPersonnelDivision12.setText("在宅強化型");

      shortStayRecuperationHealthPersonnelDivision12.setGroup(getShortStayRecuperationHealthPersonnelDivision1());

      shortStayRecuperationHealthPersonnelDivision12.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthPersonnelDivision12();
    }
    return shortStayRecuperationHealthPersonnelDivision12;

  }

  /**
   * 病室区分コンテナを取得します。
   * @return 病室区分コンテナ
   */
  public ACLabelContainer getShortStayRecuperationHealthFacilityHospitalRoomDivisionContena(){
    if(shortStayRecuperationHealthFacilityHospitalRoomDivisionContena==null){

      shortStayRecuperationHealthFacilityHospitalRoomDivisionContena = new ACLabelContainer();

      shortStayRecuperationHealthFacilityHospitalRoomDivisionContena.setText("病室区分");

      shortStayRecuperationHealthFacilityHospitalRoomDivisionContena.setFollowChildEnabled(true);

      addShortStayRecuperationHealthFacilityHospitalRoomDivisionContena();
    }
    return shortStayRecuperationHealthFacilityHospitalRoomDivisionContena;

  }

  /**
   * 病室区分（介護老人保健施設）を取得します。
   * @return 病室区分（介護老人保健施設）
   */
  public ACValueArrayRadioButtonGroup getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio(){
    if(shortStayRecuperationHealthFacilityHospitalRoomDivisionRadio==null){

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadio = new ACValueArrayRadioButtonGroup();

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadio.setBindPath("1220102");

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadio.setUseClearButton(false);

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadio.setModel(getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioModel());

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadio.setValues(new int[]{1,2});

      addShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio();
    }
    return shortStayRecuperationHealthFacilityHospitalRoomDivisionRadio;

  }

  /**
   * 病室区分（介護老人保健施設）モデルを取得します。
   * @return 病室区分（介護老人保健施設）モデル
   */
  protected ACListModelAdapter getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioModel(){
    if(shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioModel==null){
      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioModel = new ACListModelAdapter();
      addShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioModel();
    }
    return shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioModel;
  }

  /**
   * 従来型個室を取得します。
   * @return 従来型個室
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem1(){
    if(shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem1==null){

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem1.setText("従来型個室");

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem1.setGroup(getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio());

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem1();
    }
    return shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem1;

  }

  /**
   * 多床室を取得します。
   * @return 多床室
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem2(){
    if(shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem2==null){

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem2.setText("多床室");

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem2.setGroup(getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio());

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem2();
    }
    return shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem2;

  }

  /**
   * 病室区分（ユニット型介護老人保健施設）を取得します。
   * @return 病室区分（ユニット型介護老人保健施設）
   */
  public ACValueArrayRadioButtonGroup getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio(){
    if(shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio==null){

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio = new ACValueArrayRadioButtonGroup();

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio.setBindPath("1220103");

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio.setUseClearButton(false);

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio.setModel(getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioModel());

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio.setValues(new int[]{1,2});

      addShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio();
    }
    return shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio;

  }

  /**
   * 病室区分（ユニット型介護老人保健施設）モデルを取得します。
   * @return 病室区分（ユニット型介護老人保健施設）モデル
   */
  protected ACListModelAdapter getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioModel(){
    if(shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioModel==null){
      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioModel = new ACListModelAdapter();
      addShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioModel();
    }
    return shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioModel;
  }

  /**
   * ユニット型個室を取得します。
   * @return ユニット型個室
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem1(){
    if(shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem1==null){

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem1.setText("ﾕﾆｯﾄ型個室");

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem1.setGroup(getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio());

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem1();
    }
    return shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem1;

  }

  /**
   * ユニット型個室的多床室を取得します。
   * @return ユニット型個室的多床室
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem2(){
    if(shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem2==null){

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem2.setText("ﾕﾆｯﾄ型個室的多床室");

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem2.setGroup(getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio());

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem2();
    }
    return shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem2;

  }

  /**
   * 病室区分ラジオを取得します。
   * @return 病室区分ラジオ
   */
  public ACValueArrayRadioButtonGroup getShortStayRecuperationHealthFacilitySickroomDivisionRadio(){
    if(shortStayRecuperationHealthFacilitySickroomDivisionRadio==null){

      shortStayRecuperationHealthFacilitySickroomDivisionRadio = new ACValueArrayRadioButtonGroup();

      getShortStayRecuperationHealthFacilitySickroomDivisionRadioContainer().setText("病室区分");

      shortStayRecuperationHealthFacilitySickroomDivisionRadio.setBindPath("1220119");

      shortStayRecuperationHealthFacilitySickroomDivisionRadio.setUseClearButton(false);

      shortStayRecuperationHealthFacilitySickroomDivisionRadio.setModel(getShortStayRecuperationHealthFacilitySickroomDivisionRadioModel());

      shortStayRecuperationHealthFacilitySickroomDivisionRadio.setValues(new int[]{1,2,3,4});

      addShortStayRecuperationHealthFacilitySickroomDivisionRadio();
    }
    return shortStayRecuperationHealthFacilitySickroomDivisionRadio;

  }

  /**
   * 病室区分ラジオコンテナを取得します。
   * @return 病室区分ラジオコンテナ
   */
  protected ACLabelContainer getShortStayRecuperationHealthFacilitySickroomDivisionRadioContainer(){
    if(shortStayRecuperationHealthFacilitySickroomDivisionRadioContainer==null){
      shortStayRecuperationHealthFacilitySickroomDivisionRadioContainer = new ACLabelContainer();
      shortStayRecuperationHealthFacilitySickroomDivisionRadioContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthFacilitySickroomDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayRecuperationHealthFacilitySickroomDivisionRadioContainer.add(getShortStayRecuperationHealthFacilitySickroomDivisionRadio(), null);
    }
    return shortStayRecuperationHealthFacilitySickroomDivisionRadioContainer;
  }

  /**
   * 病室区分ラジオモデルを取得します。
   * @return 病室区分ラジオモデル
   */
  protected ACListModelAdapter getShortStayRecuperationHealthFacilitySickroomDivisionRadioModel(){
    if(shortStayRecuperationHealthFacilitySickroomDivisionRadioModel==null){
      shortStayRecuperationHealthFacilitySickroomDivisionRadioModel = new ACListModelAdapter();
      addShortStayRecuperationHealthFacilitySickroomDivisionRadioModel();
    }
    return shortStayRecuperationHealthFacilitySickroomDivisionRadioModel;
  }

  /**
   * 従来型個室を取得します。
   * @return 従来型個室
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilitySickroomDivisionRadioItem1(){
    if(shortStayRecuperationHealthFacilitySickroomDivisionRadioItem1==null){

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem1.setText("従来型個室");

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem1.setGroup(getShortStayRecuperationHealthFacilitySickroomDivisionRadio());

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilitySickroomDivisionRadioItem1();
    }
    return shortStayRecuperationHealthFacilitySickroomDivisionRadioItem1;

  }

  /**
   * 多床室を取得します。
   * @return 多床室
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilitySickroomDivisionRadioItem2(){
    if(shortStayRecuperationHealthFacilitySickroomDivisionRadioItem2==null){

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem2.setText("多床室");

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem2.setGroup(getShortStayRecuperationHealthFacilitySickroomDivisionRadio());

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayRecuperationHealthFacilitySickroomDivisionRadioItem2();
    }
    return shortStayRecuperationHealthFacilitySickroomDivisionRadioItem2;

  }

  /**
   * ユニット型個室を取得します。
   * @return ユニット型個室
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilitySickroomDivisionRadioItem3(){
    if(shortStayRecuperationHealthFacilitySickroomDivisionRadioItem3==null){

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem3 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem3.setText("ﾕﾆｯﾄ型個室");

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem3.setGroup(getShortStayRecuperationHealthFacilitySickroomDivisionRadio());

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem3.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilitySickroomDivisionRadioItem3();
    }
    return shortStayRecuperationHealthFacilitySickroomDivisionRadioItem3;

  }

  /**
   * ユニット型個室的多床室を取得します。
   * @return ユニット型個室的多床室
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilitySickroomDivisionRadioItem4(){
    if(shortStayRecuperationHealthFacilitySickroomDivisionRadioItem4==null){

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem4 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem4.setText("ﾕﾆｯﾄ型個室的多床室");

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem4.setGroup(getShortStayRecuperationHealthFacilitySickroomDivisionRadio());

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem4.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilitySickroomDivisionRadioItem4();
    }
    return shortStayRecuperationHealthFacilitySickroomDivisionRadioItem4;

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
   * 時間区分を取得します。
   * @return 時間区分
   */
  public ACComboBox getTankinyusyoTimeDivision(){
    if(tankinyusyoTimeDivision==null){

      tankinyusyoTimeDivision = new ACComboBox();

      getTankinyusyoTimeDivisionContainer().setText("時間区分");

      tankinyusyoTimeDivision.setBindPath("1220125");

      tankinyusyoTimeDivision.setEditable(false);

      tankinyusyoTimeDivision.setModelBindPath("1220125");

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
   * 夜間勤務条件基準を取得します。
   * @return 夜間勤務条件基準
   */
  public ACValueArrayRadioButtonGroup getShortStayRecuperationHealthNightWorkConditionRadio(){
    if(shortStayRecuperationHealthNightWorkConditionRadio==null){

      shortStayRecuperationHealthNightWorkConditionRadio = new ACValueArrayRadioButtonGroup();

      getShortStayRecuperationHealthNightWorkConditionRadioContainer().setText("夜間勤務条件基準");

      shortStayRecuperationHealthNightWorkConditionRadio.setBindPath("1220104");

      shortStayRecuperationHealthNightWorkConditionRadio.setUseClearButton(false);

      shortStayRecuperationHealthNightWorkConditionRadio.setModel(getShortStayRecuperationHealthNightWorkConditionRadioModel());

      shortStayRecuperationHealthNightWorkConditionRadio.setValues(new int[]{1,2});

      addShortStayRecuperationHealthNightWorkConditionRadio();
    }
    return shortStayRecuperationHealthNightWorkConditionRadio;

  }

  /**
   * 夜間勤務条件基準コンテナを取得します。
   * @return 夜間勤務条件基準コンテナ
   */
  protected ACLabelContainer getShortStayRecuperationHealthNightWorkConditionRadioContainer(){
    if(shortStayRecuperationHealthNightWorkConditionRadioContainer==null){
      shortStayRecuperationHealthNightWorkConditionRadioContainer = new ACLabelContainer();
      shortStayRecuperationHealthNightWorkConditionRadioContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthNightWorkConditionRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayRecuperationHealthNightWorkConditionRadioContainer.add(getShortStayRecuperationHealthNightWorkConditionRadio(), null);
    }
    return shortStayRecuperationHealthNightWorkConditionRadioContainer;
  }

  /**
   * 夜間勤務条件基準モデルを取得します。
   * @return 夜間勤務条件基準モデル
   */
  protected ACListModelAdapter getShortStayRecuperationHealthNightWorkConditionRadioModel(){
    if(shortStayRecuperationHealthNightWorkConditionRadioModel==null){
      shortStayRecuperationHealthNightWorkConditionRadioModel = new ACListModelAdapter();
      addShortStayRecuperationHealthNightWorkConditionRadioModel();
    }
    return shortStayRecuperationHealthNightWorkConditionRadioModel;
  }

  /**
   * 基準型を取得します。
   * @return 基準型
   */
  public ACRadioButtonItem getShortStayRecuperationHealthNightWorkConditionRadioItem1(){
    if(shortStayRecuperationHealthNightWorkConditionRadioItem1==null){

      shortStayRecuperationHealthNightWorkConditionRadioItem1 = new ACRadioButtonItem();

      shortStayRecuperationHealthNightWorkConditionRadioItem1.setText("基準型");

      shortStayRecuperationHealthNightWorkConditionRadioItem1.setGroup(getShortStayRecuperationHealthNightWorkConditionRadio());

      shortStayRecuperationHealthNightWorkConditionRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthNightWorkConditionRadioItem1();
    }
    return shortStayRecuperationHealthNightWorkConditionRadioItem1;

  }

  /**
   * 減算型を取得します。
   * @return 減算型
   */
  public ACRadioButtonItem getShortStayRecuperationHealthNightWorkConditionRadioItem2(){
    if(shortStayRecuperationHealthNightWorkConditionRadioItem2==null){

      shortStayRecuperationHealthNightWorkConditionRadioItem2 = new ACRadioButtonItem();

      shortStayRecuperationHealthNightWorkConditionRadioItem2.setText("減算型");

      shortStayRecuperationHealthNightWorkConditionRadioItem2.setGroup(getShortStayRecuperationHealthNightWorkConditionRadio());

      shortStayRecuperationHealthNightWorkConditionRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthNightWorkConditionRadioItem2();
    }
    return shortStayRecuperationHealthNightWorkConditionRadioItem2;

  }

  /**
   * 夜勤職員配置加算を取得します。
   * @return 夜勤職員配置加算
   */
  public ACValueArrayRadioButtonGroup getNightStaffDispositionAddRadioGroup(){
    if(nightStaffDispositionAddRadioGroup==null){

      nightStaffDispositionAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getNightStaffDispositionAddRadioGroupContainer().setText("夜勤職員配置加算");

      nightStaffDispositionAddRadioGroup.setBindPath("1220122");

      nightStaffDispositionAddRadioGroup.setNoSelectIndex(0);

      nightStaffDispositionAddRadioGroup.setUseClearButton(false);

      nightStaffDispositionAddRadioGroup.setModel(getNightStaffDispositionAddRadioGroupModel());

      nightStaffDispositionAddRadioGroup.setValues(new int[]{1,2});

      addNightStaffDispositionAddRadioGroup();
    }
    return nightStaffDispositionAddRadioGroup;

  }

  /**
   * 夜勤職員配置加算コンテナを取得します。
   * @return 夜勤職員配置加算コンテナ
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
   * 夜勤職員配置加算モデルを取得します。
   * @return 夜勤職員配置加算モデル
   */
  protected ACListModelAdapter getNightStaffDispositionAddRadioGroupModel(){
    if(nightStaffDispositionAddRadioGroupModel==null){
      nightStaffDispositionAddRadioGroupModel = new ACListModelAdapter();
      addNightStaffDispositionAddRadioGroupModel();
    }
    return nightStaffDispositionAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getNightStaffDispositionAddRadioItem1(){
    if(nightStaffDispositionAddRadioItem1==null){

      nightStaffDispositionAddRadioItem1 = new ACRadioButtonItem();

      nightStaffDispositionAddRadioItem1.setText("なし");

      nightStaffDispositionAddRadioItem1.setGroup(getNightStaffDispositionAddRadioGroup());

      nightStaffDispositionAddRadioItem1.setConstraints(VRLayout.FLOW);

      addNightStaffDispositionAddRadioItem1();
    }
    return nightStaffDispositionAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getNightStaffDispositionAddRadioItem2(){
    if(nightStaffDispositionAddRadioItem2==null){

      nightStaffDispositionAddRadioItem2 = new ACRadioButtonItem();

      nightStaffDispositionAddRadioItem2.setText("あり");

      nightStaffDispositionAddRadioItem2.setGroup(getNightStaffDispositionAddRadioGroup());

      nightStaffDispositionAddRadioItem2.setConstraints(VRLayout.FLOW);

      addNightStaffDispositionAddRadioItem2();
    }
    return nightStaffDispositionAddRadioItem2;

  }

  /**
   * 個別リハビリ実施加算を取得します。
   * @return 個別リハビリ実施加算
   */
  public ACValueArrayRadioButtonGroup getHoumonRehabilitationShortConcentrationAddRadio(){
    if(houmonRehabilitationShortConcentrationAddRadio==null){

      houmonRehabilitationShortConcentrationAddRadio = new ACValueArrayRadioButtonGroup();

      getHoumonRehabilitationShortConcentrationAddRadioContainer().setText("個別リハビリ実施加算");

      houmonRehabilitationShortConcentrationAddRadio.setBindPath("1220126");

      houmonRehabilitationShortConcentrationAddRadio.setNoSelectIndex(0);

      houmonRehabilitationShortConcentrationAddRadio.setUseClearButton(false);

      houmonRehabilitationShortConcentrationAddRadio.setModel(getHoumonRehabilitationShortConcentrationAddRadioModel());

      houmonRehabilitationShortConcentrationAddRadio.setValues(new int[]{1,2});

      addHoumonRehabilitationShortConcentrationAddRadio();
    }
    return houmonRehabilitationShortConcentrationAddRadio;

  }

  /**
   * 個別リハビリ実施加算コンテナを取得します。
   * @return 個別リハビリ実施加算コンテナ
   */
  protected ACLabelContainer getHoumonRehabilitationShortConcentrationAddRadioContainer(){
    if(houmonRehabilitationShortConcentrationAddRadioContainer==null){
      houmonRehabilitationShortConcentrationAddRadioContainer = new ACLabelContainer();
      houmonRehabilitationShortConcentrationAddRadioContainer.setFollowChildEnabled(true);
      houmonRehabilitationShortConcentrationAddRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationShortConcentrationAddRadioContainer.add(getHoumonRehabilitationShortConcentrationAddRadio(), null);
    }
    return houmonRehabilitationShortConcentrationAddRadioContainer;
  }

  /**
   * 個別リハビリ実施加算モデルを取得します。
   * @return 個別リハビリ実施加算モデル
   */
  protected ACListModelAdapter getHoumonRehabilitationShortConcentrationAddRadioModel(){
    if(houmonRehabilitationShortConcentrationAddRadioModel==null){
      houmonRehabilitationShortConcentrationAddRadioModel = new ACListModelAdapter();
      addHoumonRehabilitationShortConcentrationAddRadioModel();
    }
    return houmonRehabilitationShortConcentrationAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonRehabilitationShortConcentrationAddRadioItem1(){
    if(houmonRehabilitationShortConcentrationAddRadioItem1==null){

      houmonRehabilitationShortConcentrationAddRadioItem1 = new ACRadioButtonItem();

      houmonRehabilitationShortConcentrationAddRadioItem1.setText("なし");

      houmonRehabilitationShortConcentrationAddRadioItem1.setGroup(getHoumonRehabilitationShortConcentrationAddRadio());

      houmonRehabilitationShortConcentrationAddRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationShortConcentrationAddRadioItem1();
    }
    return houmonRehabilitationShortConcentrationAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHoumonRehabilitationShortConcentrationAddRadioItem2(){
    if(houmonRehabilitationShortConcentrationAddRadioItem2==null){

      houmonRehabilitationShortConcentrationAddRadioItem2 = new ACRadioButtonItem();

      houmonRehabilitationShortConcentrationAddRadioItem2.setText("あり");

      houmonRehabilitationShortConcentrationAddRadioItem2.setGroup(getHoumonRehabilitationShortConcentrationAddRadio());

      houmonRehabilitationShortConcentrationAddRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonRehabilitationShortConcentrationAddRadioItem2();
    }
    return houmonRehabilitationShortConcentrationAddRadioItem2;

  }

  /**
   * 認知症ケア加算を取得します。
   * @return 認知症ケア加算
   */
  public ACValueArrayRadioButtonGroup getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio(){
    if(shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio==null){

      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio = new ACValueArrayRadioButtonGroup();

      getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioContainer().setText("認知症ケア加算");

      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio.setBindPath("1220116");

      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio.setUseClearButton(false);

      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio.setModel(getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioModel());

      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio.setValues(new int[]{1,2});

      addShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio();
    }
    return shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio;

  }

  /**
   * 認知症ケア加算コンテナを取得します。
   * @return 認知症ケア加算コンテナ
   */
  protected ACLabelContainer getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioContainer(){
    if(shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioContainer==null){
      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioContainer = new ACLabelContainer();
      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioContainer.add(getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio(), null);
    }
    return shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioContainer;
  }

  /**
   * 認知症ケア加算モデルを取得します。
   * @return 認知症ケア加算モデル
   */
  protected ACListModelAdapter getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioModel(){
    if(shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioModel==null){
      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioModel = new ACListModelAdapter();
      addShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioModel();
    }
    return shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem1(){
    if(shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem1==null){

      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem1 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem1.setText("なし");

      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem1.setGroup(getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio());

      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem1();
    }
    return shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem2(){
    if(shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem2==null){

      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem2 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem2.setText("あり");

      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem2.setGroup(getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio());

      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem2();
    }
    return shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem2;

  }

  /**
   * 認知症行動・心理症状緊急対応加算を取得します。
   * @return 認知症行動・心理症状緊急対応加算
   */
  public ACValueArrayRadioButtonGroup getDementiaActionAddRadioGroup(){
    if(dementiaActionAddRadioGroup==null){

      dementiaActionAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaActionAddRadioGroupContainer().setText("認知症行動・" + ACConstants.LINE_SEPARATOR + "心理症状緊急対応加算" + ACConstants.LINE_SEPARATOR + "（1月に7日を限度）");

      dementiaActionAddRadioGroup.setBindPath("1220127");

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
  public ACValueArrayRadioButtonGroup getEmergencyAcceptanceRadioGroup(){
    if(emergencyAcceptanceRadioGroup==null){

      emergencyAcceptanceRadioGroup = new ACValueArrayRadioButtonGroup();

      getEmergencyAcceptanceRadioGroupContainer().setText("緊急短期入所受入加算" + ACConstants.LINE_SEPARATOR + "（1月に7日を限度）");

      emergencyAcceptanceRadioGroup.setBindPath("1220130");

      emergencyAcceptanceRadioGroup.setUseClearButton(false);

      emergencyAcceptanceRadioGroup.setModel(getEmergencyAcceptanceRadioGroupModel());

      emergencyAcceptanceRadioGroup.setValues(new int[]{1,2});

      addEmergencyAcceptanceRadioGroup();
    }
    return emergencyAcceptanceRadioGroup;

  }

  /**
   * 緊急短期入所受入加算コンテナを取得します。
   * @return 緊急短期入所受入加算コンテナ
   */
  protected ACLabelContainer getEmergencyAcceptanceRadioGroupContainer(){
    if(emergencyAcceptanceRadioGroupContainer==null){
      emergencyAcceptanceRadioGroupContainer = new ACLabelContainer();
      emergencyAcceptanceRadioGroupContainer.setFollowChildEnabled(true);
      emergencyAcceptanceRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      emergencyAcceptanceRadioGroupContainer.add(getEmergencyAcceptanceRadioGroup(), null);
    }
    return emergencyAcceptanceRadioGroupContainer;
  }

  /**
   * 緊急短期入所受入加算モデルを取得します。
   * @return 緊急短期入所受入加算モデル
   */
  protected ACListModelAdapter getEmergencyAcceptanceRadioGroupModel(){
    if(emergencyAcceptanceRadioGroupModel==null){
      emergencyAcceptanceRadioGroupModel = new ACListModelAdapter();
      addEmergencyAcceptanceRadioGroupModel();
    }
    return emergencyAcceptanceRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getEmergencyAcceptanceRadioItem1(){
    if(emergencyAcceptanceRadioItem1==null){

      emergencyAcceptanceRadioItem1 = new ACRadioButtonItem();

      emergencyAcceptanceRadioItem1.setText("なし");

      emergencyAcceptanceRadioItem1.setGroup(getEmergencyAcceptanceRadioGroup());

      emergencyAcceptanceRadioItem1.setConstraints(VRLayout.FLOW);

      addEmergencyAcceptanceRadioItem1();
    }
    return emergencyAcceptanceRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getEmergencyAcceptanceRadioItem2(){
    if(emergencyAcceptanceRadioItem2==null){

      emergencyAcceptanceRadioItem2 = new ACRadioButtonItem();

      emergencyAcceptanceRadioItem2.setText("あり");

      emergencyAcceptanceRadioItem2.setGroup(getEmergencyAcceptanceRadioGroup());

      emergencyAcceptanceRadioItem2.setConstraints(VRLayout.FLOW);

      addEmergencyAcceptanceRadioItem2();
    }
    return emergencyAcceptanceRadioItem2;

  }

  /**
   * 若年性認知症利用者受入加算を取得します。
   * @return 若年性認知症利用者受入加算
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("若年性認知症利用者受入加算");

      youngDementiaPatinetAddRadioGroup.setBindPath("1220123");

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
   * 送迎区分を取得します。
   * @return 送迎区分
   */
  public ACValueArrayRadioButtonGroup getShortStayRecuperationHealthFacilityMeetingAndSendingOff(){
    if(shortStayRecuperationHealthFacilityMeetingAndSendingOff==null){

      shortStayRecuperationHealthFacilityMeetingAndSendingOff = new ACValueArrayRadioButtonGroup();

      getShortStayRecuperationHealthFacilityMeetingAndSendingOffContainer().setText("送迎加算");

      shortStayRecuperationHealthFacilityMeetingAndSendingOff.setBindPath("6");

      shortStayRecuperationHealthFacilityMeetingAndSendingOff.setUseClearButton(false);

      shortStayRecuperationHealthFacilityMeetingAndSendingOff.setModel(getShortStayRecuperationHealthFacilityMeetingAndSendingOffModel());

      shortStayRecuperationHealthFacilityMeetingAndSendingOff.setValues(new int[]{1,2,3});

      addShortStayRecuperationHealthFacilityMeetingAndSendingOff();
    }
    return shortStayRecuperationHealthFacilityMeetingAndSendingOff;

  }

  /**
   * 送迎区分コンテナを取得します。
   * @return 送迎区分コンテナ
   */
  protected ACLabelContainer getShortStayRecuperationHealthFacilityMeetingAndSendingOffContainer(){
    if(shortStayRecuperationHealthFacilityMeetingAndSendingOffContainer==null){
      shortStayRecuperationHealthFacilityMeetingAndSendingOffContainer = new ACLabelContainer();
      shortStayRecuperationHealthFacilityMeetingAndSendingOffContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthFacilityMeetingAndSendingOffContainer.setVAlignment(VRLayout.CENTER);
      shortStayRecuperationHealthFacilityMeetingAndSendingOffContainer.add(getShortStayRecuperationHealthFacilityMeetingAndSendingOff(), null);
    }
    return shortStayRecuperationHealthFacilityMeetingAndSendingOffContainer;
  }

  /**
   * 送迎区分モデルを取得します。
   * @return 送迎区分モデル
   */
  protected ACListModelAdapter getShortStayRecuperationHealthFacilityMeetingAndSendingOffModel(){
    if(shortStayRecuperationHealthFacilityMeetingAndSendingOffModel==null){
      shortStayRecuperationHealthFacilityMeetingAndSendingOffModel = new ACListModelAdapter();
      addShortStayRecuperationHealthFacilityMeetingAndSendingOffModel();
    }
    return shortStayRecuperationHealthFacilityMeetingAndSendingOffModel;
  }

  /**
   * 送迎なしを取得します。
   * @return 送迎なし
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityMeetingAndSendingOffNone(){
    if(shortStayRecuperationHealthFacilityMeetingAndSendingOffNone==null){

      shortStayRecuperationHealthFacilityMeetingAndSendingOffNone = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityMeetingAndSendingOffNone.setText("送迎なし");

      shortStayRecuperationHealthFacilityMeetingAndSendingOffNone.setGroup(getShortStayRecuperationHealthFacilityMeetingAndSendingOff());

      shortStayRecuperationHealthFacilityMeetingAndSendingOffNone.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityMeetingAndSendingOffNone();
    }
    return shortStayRecuperationHealthFacilityMeetingAndSendingOffNone;

  }

  /**
   * 送迎片道を取得します。
   * @return 送迎片道
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityMeetingAndSendingOffOneWay(){
    if(shortStayRecuperationHealthFacilityMeetingAndSendingOffOneWay==null){

      shortStayRecuperationHealthFacilityMeetingAndSendingOffOneWay = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityMeetingAndSendingOffOneWay.setText("送迎片道");

      shortStayRecuperationHealthFacilityMeetingAndSendingOffOneWay.setGroup(getShortStayRecuperationHealthFacilityMeetingAndSendingOff());

      shortStayRecuperationHealthFacilityMeetingAndSendingOffOneWay.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityMeetingAndSendingOffOneWay();
    }
    return shortStayRecuperationHealthFacilityMeetingAndSendingOffOneWay;

  }

  /**
   * 送迎往復を取得します。
   * @return 送迎往復
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityMeetingAndSendingOffRoundTrip(){
    if(shortStayRecuperationHealthFacilityMeetingAndSendingOffRoundTrip==null){

      shortStayRecuperationHealthFacilityMeetingAndSendingOffRoundTrip = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityMeetingAndSendingOffRoundTrip.setText("送迎往復");

      shortStayRecuperationHealthFacilityMeetingAndSendingOffRoundTrip.setGroup(getShortStayRecuperationHealthFacilityMeetingAndSendingOff());

      shortStayRecuperationHealthFacilityMeetingAndSendingOffRoundTrip.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityMeetingAndSendingOffRoundTrip();
    }
    return shortStayRecuperationHealthFacilityMeetingAndSendingOffRoundTrip;

  }

  /**
   * 緊急時治療管理加算を取得します。
   * @return 緊急時治療管理加算
   */
  public ACValueArrayRadioButtonGroup getShortStayRecuperationHealthFacilityUrgentTimeStepRadio(){
    if(shortStayRecuperationHealthFacilityUrgentTimeStepRadio==null){

      shortStayRecuperationHealthFacilityUrgentTimeStepRadio = new ACValueArrayRadioButtonGroup();

      getShortStayRecuperationHealthFacilityUrgentTimeStepRadioContainer().setText("緊急時治療管理加算");

      shortStayRecuperationHealthFacilityUrgentTimeStepRadio.setBindPath("1220108");

      shortStayRecuperationHealthFacilityUrgentTimeStepRadio.setUseClearButton(false);

      shortStayRecuperationHealthFacilityUrgentTimeStepRadio.setModel(getShortStayRecuperationHealthFacilityUrgentTimeStepRadioModel());

      shortStayRecuperationHealthFacilityUrgentTimeStepRadio.setValues(new int[]{1,2});

      addShortStayRecuperationHealthFacilityUrgentTimeStepRadio();
    }
    return shortStayRecuperationHealthFacilityUrgentTimeStepRadio;

  }

  /**
   * 緊急時治療管理加算コンテナを取得します。
   * @return 緊急時治療管理加算コンテナ
   */
  protected ACLabelContainer getShortStayRecuperationHealthFacilityUrgentTimeStepRadioContainer(){
    if(shortStayRecuperationHealthFacilityUrgentTimeStepRadioContainer==null){
      shortStayRecuperationHealthFacilityUrgentTimeStepRadioContainer = new ACLabelContainer();
      shortStayRecuperationHealthFacilityUrgentTimeStepRadioContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthFacilityUrgentTimeStepRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayRecuperationHealthFacilityUrgentTimeStepRadioContainer.add(getShortStayRecuperationHealthFacilityUrgentTimeStepRadio(), null);
    }
    return shortStayRecuperationHealthFacilityUrgentTimeStepRadioContainer;
  }

  /**
   * 緊急時治療管理加算モデルを取得します。
   * @return 緊急時治療管理加算モデル
   */
  protected ACListModelAdapter getShortStayRecuperationHealthFacilityUrgentTimeStepRadioModel(){
    if(shortStayRecuperationHealthFacilityUrgentTimeStepRadioModel==null){
      shortStayRecuperationHealthFacilityUrgentTimeStepRadioModel = new ACListModelAdapter();
      addShortStayRecuperationHealthFacilityUrgentTimeStepRadioModel();
    }
    return shortStayRecuperationHealthFacilityUrgentTimeStepRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityUrgentTimeStepRadioItem1(){
    if(shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem1==null){

      shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem1 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem1.setText("なし");

      shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem1.setGroup(getShortStayRecuperationHealthFacilityUrgentTimeStepRadio());

      shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityUrgentTimeStepRadioItem1();
    }
    return shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityUrgentTimeStepRadioItem2(){
    if(shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem2==null){

      shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem2 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem2.setText("あり");

      shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem2.setGroup(getShortStayRecuperationHealthFacilityUrgentTimeStepRadio());

      shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityUrgentTimeStepRadioItem2();
    }
    return shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem2;

  }

  /**
   * 療養食加算を取得します。
   * @return 療養食加算
   */
  public ACValueArrayRadioButtonGroup getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio(){
    if(shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio==null){

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio = new ACValueArrayRadioButtonGroup();

      getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioContainer().setText("療養食加算");

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio.setBindPath("1220110");

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio.setUseClearButton(false);

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio.setModel(getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioModel());

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio.setValues(new int[]{1,2,3,4});

      addShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio();
    }
    return shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio;

  }

  /**
   * 療養食加算コンテナを取得します。
   * @return 療養食加算コンテナ
   */
  protected ACLabelContainer getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioContainer(){
    if(shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioContainer==null){
      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioContainer = new ACLabelContainer();
      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioContainer.add(getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio(), null);
    }
    return shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioContainer;
  }

  /**
   * 療養食加算モデルを取得します。
   * @return 療養食加算モデル
   */
  protected ACListModelAdapter getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioModel(){
    if(shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioModel==null){
      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioModel = new ACListModelAdapter();
      addShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioModel();
    }
    return shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem1(){
    if(shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem1==null){

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem1 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem1.setText("なし");

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem1.setGroup(getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio());

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem1();
    }
    return shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem1;

  }

  /**
   * 3回を取得します。
   * @return 3回
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem2(){
    if(shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem2==null){

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem2 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem2.setText("3回");

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem2.setGroup(getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio());

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem2();
    }
    return shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem2;

  }

  /**
   * 2回を取得します。
   * @return 2回
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem3(){
    if(shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem3==null){

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem3 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem3.setText("2回");

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem3.setGroup(getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio());

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem3.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem3();
    }
    return shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem3;

  }

  /**
   * 1回を取得します。
   * @return 1回
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem4(){
    if(shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem4==null){

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem4 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem4.setText("1回");

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem4.setGroup(getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio());

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem4.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem4();
    }
    return shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem4;

  }

  /**
   * 特別療養費を取得します。
   * @return 特別療養費
   */
  public ACMapBindButton getShortStayRecuperationHealthFacilitySpecialMedicalExpense(){
    if(shortStayRecuperationHealthFacilitySpecialMedicalExpense==null){

      shortStayRecuperationHealthFacilitySpecialMedicalExpense = new ACMapBindButton();

      shortStayRecuperationHealthFacilitySpecialMedicalExpense.setText("特別療養費");

      shortStayRecuperationHealthFacilitySpecialMedicalExpense.setToolTipText("特別療養費を設定します。");

      addShortStayRecuperationHealthFacilitySpecialMedicalExpense();
    }
    return shortStayRecuperationHealthFacilitySpecialMedicalExpense;

  }

  /**
   * ラベルを取得します。
   * @return ラベル
   */
  public ACLabel getShortStayRecuperationHealthFacilitySpecialMedicalExpenseLabel(){
    if(shortStayRecuperationHealthFacilitySpecialMedicalExpenseLabel==null){

      shortStayRecuperationHealthFacilitySpecialMedicalExpenseLabel = new ACLabel();

      shortStayRecuperationHealthFacilitySpecialMedicalExpenseLabel.setText("設定なし");

      shortStayRecuperationHealthFacilitySpecialMedicalExpenseLabel.setOpaque(true);
      shortStayRecuperationHealthFacilitySpecialMedicalExpenseLabel.setBackground(new Color(255,255,172));

      addShortStayRecuperationHealthFacilitySpecialMedicalExpenseLabel();
    }
    return shortStayRecuperationHealthFacilitySpecialMedicalExpenseLabel;

  }

  /**
   * 30日超を取得します。
   * @return 30日超
   */
  public ACIntegerCheckBox getShortStayRecuperationHealthFacilityEtc30Over(){
    if(shortStayRecuperationHealthFacilityEtc30Over==null){

      shortStayRecuperationHealthFacilityEtc30Over = new ACIntegerCheckBox();

      shortStayRecuperationHealthFacilityEtc30Over.setText("30日超");

      shortStayRecuperationHealthFacilityEtc30Over.setBindPath("5");

      shortStayRecuperationHealthFacilityEtc30Over.setSelectValue(2);

      shortStayRecuperationHealthFacilityEtc30Over.setUnSelectValue(1);

      addShortStayRecuperationHealthFacilityEtc30Over();
    }
    return shortStayRecuperationHealthFacilityEtc30Over;

  }

  /**
   * 人員減算を取得します。
   * @return 人員減算
   */
  public ACValueArrayRadioButtonGroup getShortStayRecuperationHealthFacilityPersonSubtraction(){
    if(shortStayRecuperationHealthFacilityPersonSubtraction==null){

      shortStayRecuperationHealthFacilityPersonSubtraction = new ACValueArrayRadioButtonGroup();

      getShortStayRecuperationHealthFacilityPersonSubtractionContainer().setText("人員減算");

      shortStayRecuperationHealthFacilityPersonSubtraction.setBindPath("1220111");

      shortStayRecuperationHealthFacilityPersonSubtraction.setUseClearButton(false);

      shortStayRecuperationHealthFacilityPersonSubtraction.setModel(getShortStayRecuperationHealthFacilityPersonSubtractionModel());

      shortStayRecuperationHealthFacilityPersonSubtraction.setValues(new int[]{1,2,3});

      addShortStayRecuperationHealthFacilityPersonSubtraction();
    }
    return shortStayRecuperationHealthFacilityPersonSubtraction;

  }

  /**
   * 人員減算コンテナを取得します。
   * @return 人員減算コンテナ
   */
  protected ACLabelContainer getShortStayRecuperationHealthFacilityPersonSubtractionContainer(){
    if(shortStayRecuperationHealthFacilityPersonSubtractionContainer==null){
      shortStayRecuperationHealthFacilityPersonSubtractionContainer = new ACLabelContainer();
      shortStayRecuperationHealthFacilityPersonSubtractionContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthFacilityPersonSubtractionContainer.setVAlignment(VRLayout.CENTER);
      shortStayRecuperationHealthFacilityPersonSubtractionContainer.add(getShortStayRecuperationHealthFacilityPersonSubtraction(), null);
    }
    return shortStayRecuperationHealthFacilityPersonSubtractionContainer;
  }

  /**
   * 人員減算モデルを取得します。
   * @return 人員減算モデル
   */
  protected ACListModelAdapter getShortStayRecuperationHealthFacilityPersonSubtractionModel(){
    if(shortStayRecuperationHealthFacilityPersonSubtractionModel==null){
      shortStayRecuperationHealthFacilityPersonSubtractionModel = new ACListModelAdapter();
      addShortStayRecuperationHealthFacilityPersonSubtractionModel();
    }
    return shortStayRecuperationHealthFacilityPersonSubtractionModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityPersonSubtractionNot(){
    if(shortStayRecuperationHealthFacilityPersonSubtractionNot==null){

      shortStayRecuperationHealthFacilityPersonSubtractionNot = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityPersonSubtractionNot.setText("なし");

      shortStayRecuperationHealthFacilityPersonSubtractionNot.setGroup(getShortStayRecuperationHealthFacilityPersonSubtraction());

      shortStayRecuperationHealthFacilityPersonSubtractionNot.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityPersonSubtractionNot();
    }
    return shortStayRecuperationHealthFacilityPersonSubtractionNot;

  }

  /**
   * 定員超過を取得します。
   * @return 定員超過
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityPersonSubtractionExcess(){
    if(shortStayRecuperationHealthFacilityPersonSubtractionExcess==null){

      shortStayRecuperationHealthFacilityPersonSubtractionExcess = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityPersonSubtractionExcess.setText("定員超過");

      shortStayRecuperationHealthFacilityPersonSubtractionExcess.setGroup(getShortStayRecuperationHealthFacilityPersonSubtraction());

      shortStayRecuperationHealthFacilityPersonSubtractionExcess.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayRecuperationHealthFacilityPersonSubtractionExcess();
    }
    return shortStayRecuperationHealthFacilityPersonSubtractionExcess;

  }

  /**
   * 看護・介護職員又は医師、PT・OT・STの不足を取得します。
   * @return 看護・介護職員又は医師、PT・OT・STの不足
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityPersonSubtractionStaffLack(){
    if(shortStayRecuperationHealthFacilityPersonSubtractionStaffLack==null){

      shortStayRecuperationHealthFacilityPersonSubtractionStaffLack = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityPersonSubtractionStaffLack.setText("<html>看護・介護職員又は医師、<br>PT・OT・STの不足</html>");

      shortStayRecuperationHealthFacilityPersonSubtractionStaffLack.setGroup(getShortStayRecuperationHealthFacilityPersonSubtraction());

      shortStayRecuperationHealthFacilityPersonSubtractionStaffLack.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityPersonSubtractionStaffLack();
    }
    return shortStayRecuperationHealthFacilityPersonSubtractionStaffLack;

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

      shortStayRecuperationHealthFacilityDinnerOffer.setBindPath("1220112");

      shortStayRecuperationHealthFacilityDinnerOffer.setEditable(false);

      shortStayRecuperationHealthFacilityDinnerOffer.setModelBindPath("1220112");

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

      shortStayRecuperationHealthFacilityDinnerCost.setBindPath("1220115");

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
   * ユニットケアの整備を取得します。
   * @return ユニットケアの整備
   */
  public ACValueArrayRadioButtonGroup getShortStayRecuperationHealthUnitCareAddRadio(){
    if(shortStayRecuperationHealthUnitCareAddRadio==null){

      shortStayRecuperationHealthUnitCareAddRadio = new ACValueArrayRadioButtonGroup();

      getShortStayRecuperationHealthUnitCareAddRadioContainer().setText("ユニットケアの整備");

      shortStayRecuperationHealthUnitCareAddRadio.setBindPath("1220117");

      shortStayRecuperationHealthUnitCareAddRadio.setUseClearButton(false);

      shortStayRecuperationHealthUnitCareAddRadio.setModel(getShortStayRecuperationHealthUnitCareAddRadioModel());

      shortStayRecuperationHealthUnitCareAddRadio.setValues(new int[]{1,2});

      addShortStayRecuperationHealthUnitCareAddRadio();
    }
    return shortStayRecuperationHealthUnitCareAddRadio;

  }

  /**
   * ユニットケアの整備コンテナを取得します。
   * @return ユニットケアの整備コンテナ
   */
  protected ACLabelContainer getShortStayRecuperationHealthUnitCareAddRadioContainer(){
    if(shortStayRecuperationHealthUnitCareAddRadioContainer==null){
      shortStayRecuperationHealthUnitCareAddRadioContainer = new ACLabelContainer();
      shortStayRecuperationHealthUnitCareAddRadioContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthUnitCareAddRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayRecuperationHealthUnitCareAddRadioContainer.add(getShortStayRecuperationHealthUnitCareAddRadio(), null);
    }
    return shortStayRecuperationHealthUnitCareAddRadioContainer;
  }

  /**
   * ユニットケアの整備モデルを取得します。
   * @return ユニットケアの整備モデル
   */
  protected ACListModelAdapter getShortStayRecuperationHealthUnitCareAddRadioModel(){
    if(shortStayRecuperationHealthUnitCareAddRadioModel==null){
      shortStayRecuperationHealthUnitCareAddRadioModel = new ACListModelAdapter();
      addShortStayRecuperationHealthUnitCareAddRadioModel();
    }
    return shortStayRecuperationHealthUnitCareAddRadioModel;
  }

  /**
   * 未整備を取得します。
   * @return 未整備
   */
  public ACRadioButtonItem getShortStayRecuperationHealthUnitCareAddRadioItem1(){
    if(shortStayRecuperationHealthUnitCareAddRadioItem1==null){

      shortStayRecuperationHealthUnitCareAddRadioItem1 = new ACRadioButtonItem();

      shortStayRecuperationHealthUnitCareAddRadioItem1.setText("未整備");

      shortStayRecuperationHealthUnitCareAddRadioItem1.setGroup(getShortStayRecuperationHealthUnitCareAddRadio());

      shortStayRecuperationHealthUnitCareAddRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthUnitCareAddRadioItem1();
    }
    return shortStayRecuperationHealthUnitCareAddRadioItem1;

  }

  /**
   * 整備を取得します。
   * @return 整備
   */
  public ACRadioButtonItem getShortStayRecuperationHealthUnitCareAddRadioItem2(){
    if(shortStayRecuperationHealthUnitCareAddRadioItem2==null){

      shortStayRecuperationHealthUnitCareAddRadioItem2 = new ACRadioButtonItem();

      shortStayRecuperationHealthUnitCareAddRadioItem2.setText("整備");

      shortStayRecuperationHealthUnitCareAddRadioItem2.setGroup(getShortStayRecuperationHealthUnitCareAddRadio());

      shortStayRecuperationHealthUnitCareAddRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthUnitCareAddRadioItem2();
    }
    return shortStayRecuperationHealthUnitCareAddRadioItem2;

  }

  /**
   * 療養体制維持特別加算コンテナを取得します。
   * @return 療養体制維持特別加算コンテナ
   */
  public ACLabelContainer getShortStayRecuperationHealthFacilityRecuperationGroup(){
    if(shortStayRecuperationHealthFacilityRecuperationGroup==null){

      shortStayRecuperationHealthFacilityRecuperationGroup = new ACLabelContainer();

      shortStayRecuperationHealthFacilityRecuperationGroup.setText("療養体制維持特別加算");

      shortStayRecuperationHealthFacilityRecuperationGroup.setFollowChildEnabled(true);

      shortStayRecuperationHealthFacilityRecuperationGroup.setHgap(0);

      shortStayRecuperationHealthFacilityRecuperationGroup.setLabelMargin(0);

      shortStayRecuperationHealthFacilityRecuperationGroup.setVgap(0);

      addShortStayRecuperationHealthFacilityRecuperationGroup();
    }
    return shortStayRecuperationHealthFacilityRecuperationGroup;

  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACIntegerCheckBox getNurseStructuralAddRadioItem1(){
    if(nurseStructuralAddRadioItem1==null){

      nurseStructuralAddRadioItem1 = new ACIntegerCheckBox();

      nurseStructuralAddRadioItem1.setText("I型");

      nurseStructuralAddRadioItem1.setBindPath("1220121");

      nurseStructuralAddRadioItem1.setSelectValue(2);

      nurseStructuralAddRadioItem1.setUnSelectValue(1);

      addNurseStructuralAddRadioItem1();
    }
    return nurseStructuralAddRadioItem1;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACIntegerCheckBox getNurseStructuralAddRadioItem2(){
    if(nurseStructuralAddRadioItem2==null){

      nurseStructuralAddRadioItem2 = new ACIntegerCheckBox();

      nurseStructuralAddRadioItem2.setText("II型");

      nurseStructuralAddRadioItem2.setBindPath("1220135");

      nurseStructuralAddRadioItem2.setSelectValue(2);

      nurseStructuralAddRadioItem2.setUnSelectValue(1);

      addNurseStructuralAddRadioItem2();
    }
    return nurseStructuralAddRadioItem2;

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
   * 重度療養管理加算を取得します。
   * @return 重度療養管理加算
   */
  public ACValueArrayRadioButtonGroup getSeverelyMedicalManagementAdd(){
    if(severelyMedicalManagementAdd==null){

      severelyMedicalManagementAdd = new ACValueArrayRadioButtonGroup();

      getSeverelyMedicalManagementAddContainer().setText("重度療養管理加算");

      severelyMedicalManagementAdd.setBindPath("1220129");

      severelyMedicalManagementAdd.setUseClearButton(false);

      severelyMedicalManagementAdd.setModel(getSeverelyMedicalManagementAddModel());

      severelyMedicalManagementAdd.setValues(new int[]{1,2});

      addSeverelyMedicalManagementAdd();
    }
    return severelyMedicalManagementAdd;

  }

  /**
   * 重度療養管理加算コンテナを取得します。
   * @return 重度療養管理加算コンテナ
   */
  protected ACLabelContainer getSeverelyMedicalManagementAddContainer(){
    if(severelyMedicalManagementAddContainer==null){
      severelyMedicalManagementAddContainer = new ACLabelContainer();
      severelyMedicalManagementAddContainer.setFollowChildEnabled(true);
      severelyMedicalManagementAddContainer.setVAlignment(VRLayout.CENTER);
      severelyMedicalManagementAddContainer.add(getSeverelyMedicalManagementAdd(), null);
    }
    return severelyMedicalManagementAddContainer;
  }

  /**
   * 重度療養管理加算モデルを取得します。
   * @return 重度療養管理加算モデル
   */
  protected ACListModelAdapter getSeverelyMedicalManagementAddModel(){
    if(severelyMedicalManagementAddModel==null){
      severelyMedicalManagementAddModel = new ACListModelAdapter();
      addSeverelyMedicalManagementAddModel();
    }
    return severelyMedicalManagementAddModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getSeverelyMedicalManagementAddItem1(){
    if(severelyMedicalManagementAddItem1==null){

      severelyMedicalManagementAddItem1 = new ACRadioButtonItem();

      severelyMedicalManagementAddItem1.setText("なし");

      severelyMedicalManagementAddItem1.setGroup(getSeverelyMedicalManagementAdd());

      severelyMedicalManagementAddItem1.setConstraints(VRLayout.FLOW);

      addSeverelyMedicalManagementAddItem1();
    }
    return severelyMedicalManagementAddItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getSeverelyMedicalManagementAddItem2(){
    if(severelyMedicalManagementAddItem2==null){

      severelyMedicalManagementAddItem2 = new ACRadioButtonItem();

      severelyMedicalManagementAddItem2.setText("あり");

      severelyMedicalManagementAddItem2.setGroup(getSeverelyMedicalManagementAdd());

      severelyMedicalManagementAddItem2.setConstraints(VRLayout.FLOW);

      addSeverelyMedicalManagementAddItem2();
    }
    return severelyMedicalManagementAddItem2;

  }

  /**
   * サービス提供体制強化加算を取得します。
   * @return サービス提供体制強化加算
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("サービス提供体制強化加算");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1220124");

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
   * 在宅復帰・在宅療養支援機能加算を取得します。
   * @return 在宅復帰・在宅療養支援機能加算
   */
  public ACValueArrayRadioButtonGroup getStayReturnSupportRyoyoAddRadio(){
    if(stayReturnSupportRyoyoAddRadio==null){

      stayReturnSupportRyoyoAddRadio = new ACValueArrayRadioButtonGroup();

      getStayReturnSupportRyoyoAddRadioContainer().setText("在宅復帰・在宅療養支援機能加算");

      stayReturnSupportRyoyoAddRadio.setBindPath("1220133");

      stayReturnSupportRyoyoAddRadio.setNoSelectIndex(0);

      stayReturnSupportRyoyoAddRadio.setUseClearButton(false);

      stayReturnSupportRyoyoAddRadio.setModel(getStayReturnSupportRyoyoAddRadioModel());

      stayReturnSupportRyoyoAddRadio.setValues(new int[]{1,2});

      addStayReturnSupportRyoyoAddRadio();
    }
    return stayReturnSupportRyoyoAddRadio;

  }

  /**
   * 在宅復帰・在宅療養支援機能加算コンテナを取得します。
   * @return 在宅復帰・在宅療養支援機能加算コンテナ
   */
  protected ACLabelContainer getStayReturnSupportRyoyoAddRadioContainer(){
    if(stayReturnSupportRyoyoAddRadioContainer==null){
      stayReturnSupportRyoyoAddRadioContainer = new ACLabelContainer();
      stayReturnSupportRyoyoAddRadioContainer.setFollowChildEnabled(true);
      stayReturnSupportRyoyoAddRadioContainer.setVAlignment(VRLayout.CENTER);
      stayReturnSupportRyoyoAddRadioContainer.add(getStayReturnSupportRyoyoAddRadio(), null);
    }
    return stayReturnSupportRyoyoAddRadioContainer;
  }

  /**
   * 在宅復帰・在宅療養支援機能加算モデルを取得します。
   * @return 在宅復帰・在宅療養支援機能加算モデル
   */
  protected ACListModelAdapter getStayReturnSupportRyoyoAddRadioModel(){
    if(stayReturnSupportRyoyoAddRadioModel==null){
      stayReturnSupportRyoyoAddRadioModel = new ACListModelAdapter();
      addStayReturnSupportRyoyoAddRadioModel();
    }
    return stayReturnSupportRyoyoAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getStayReturnSupportRyoyoAddRadioItem1(){
    if(stayReturnSupportRyoyoAddRadioItem1==null){

      stayReturnSupportRyoyoAddRadioItem1 = new ACRadioButtonItem();

      stayReturnSupportRyoyoAddRadioItem1.setText("なし");

      stayReturnSupportRyoyoAddRadioItem1.setGroup(getStayReturnSupportRyoyoAddRadio());

      stayReturnSupportRyoyoAddRadioItem1.setConstraints(VRLayout.FLOW);

      addStayReturnSupportRyoyoAddRadioItem1();
    }
    return stayReturnSupportRyoyoAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getStayReturnSupportRyoyoAddRadioItem2(){
    if(stayReturnSupportRyoyoAddRadioItem2==null){

      stayReturnSupportRyoyoAddRadioItem2 = new ACRadioButtonItem();

      stayReturnSupportRyoyoAddRadioItem2.setText("あり");

      stayReturnSupportRyoyoAddRadioItem2.setGroup(getStayReturnSupportRyoyoAddRadio());

      stayReturnSupportRyoyoAddRadioItem2.setConstraints(VRLayout.FLOW);

      addStayReturnSupportRyoyoAddRadioItem2();
    }
    return stayReturnSupportRyoyoAddRadioItem2;

  }

  /**
   * 認知症専門ケア加算を取得します。
   * @return 認知症専門ケア加算
   */
  public ACValueArrayRadioButtonGroup getDementiaProfessionalCareAddRadioGroup(){
    if(dementiaProfessionalCareAddRadioGroup==null){

      dementiaProfessionalCareAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaProfessionalCareAddRadioGroupContainer().setText("認知症専門ケア加算");

      dementiaProfessionalCareAddRadioGroup.setBindPath("1220134");

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
   * コンストラクタです。
   */
  public QS001_12211_201804Design() {

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

    tab1.add(getShortStayRecuperationHealthFacilityInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE);

    tab1.add(getShortStayRecuperationHealthPersonnelDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayRecuperationHealthFacilityHospitalRoomDivisionContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayRecuperationHealthFacilitySickroomDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 施設等の区分に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityInstitutionDivisionRadio(){

  }

  /**
   * 施設等の区分モデルに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityInstitutionDivisionRadioModel(){

    getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1().setButtonIndex(1);

    getShortStayRecuperationHealthFacilityInstitutionDivisionRadioModel().add(getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1());

    getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2().setButtonIndex(2);

    getShortStayRecuperationHealthFacilityInstitutionDivisionRadioModel().add(getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2());

    getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem3().setButtonIndex(3);

    getShortStayRecuperationHealthFacilityInstitutionDivisionRadioModel().add(getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem3());

    getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem4().setButtonIndex(4);

    getShortStayRecuperationHealthFacilityInstitutionDivisionRadioModel().add(getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem4());

    getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem5().setButtonIndex(5);

    getShortStayRecuperationHealthFacilityInstitutionDivisionRadioModel().add(getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem5());

    getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem6().setButtonIndex(6);

    getShortStayRecuperationHealthFacilityInstitutionDivisionRadioModel().add(getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem6());

    getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem7().setButtonIndex(7);

    getShortStayRecuperationHealthFacilityInstitutionDivisionRadioModel().add(getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem7());

    getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem8().setButtonIndex(8);

    getShortStayRecuperationHealthFacilityInstitutionDivisionRadioModel().add(getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem8());

    getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem9().setButtonIndex(9);

    getShortStayRecuperationHealthFacilityInstitutionDivisionRadioModel().add(getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem9());

  }

  /**
   * 介護老人保健施設（I）に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1(){

  }

  /**
   * ユニット型介護老人保健施設（I）に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2(){

  }

  /**
   * 介護老人保健施設（II）に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem3(){

  }

  /**
   * ユニット型介護老人保健施設（II）に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem4(){

  }

  /**
   * 介護老人保健施設（III）に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem5(){

  }

  /**
   * ユニット型介護老人保健施設（III）に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem6(){

  }

  /**
   * 介護老人保健施設（IV）に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem7(){

  }

  /**
   * ユニット型介護老人保健施設（IV）に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem8(){

  }

  /**
   * 日帰りショートステイに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem9(){

  }

  /**
   * 人員配置区分コンテナに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthPersonnelDivisionContainer(){

    shortStayRecuperationHealthPersonnelDivisionContainer.add(getShortStayRecuperationHealthPersonnelDivision1(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 人員配置区分に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthPersonnelDivision1(){

  }

  /**
   * 人員配置区分モデルに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthPersonnelDivision1Model(){

    getShortStayRecuperationHealthPersonnelDivision11().setButtonIndex(1);

    getShortStayRecuperationHealthPersonnelDivision1Model().add(getShortStayRecuperationHealthPersonnelDivision11());

    getShortStayRecuperationHealthPersonnelDivision12().setButtonIndex(2);

    getShortStayRecuperationHealthPersonnelDivision1Model().add(getShortStayRecuperationHealthPersonnelDivision12());

  }

  /**
   * 基本型に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthPersonnelDivision11(){

  }

  /**
   * 在宅強化型に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthPersonnelDivision12(){

  }

  /**
   * 病室区分コンテナに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityHospitalRoomDivisionContena(){

    shortStayRecuperationHealthFacilityHospitalRoomDivisionContena.add(getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayRecuperationHealthFacilityHospitalRoomDivisionContena.add(getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 病室区分（介護老人保健施設）に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio(){

  }

  /**
   * 病室区分（介護老人保健施設）モデルに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioModel(){

    getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem1().setButtonIndex(1);

    getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioModel().add(getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem1());

    getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem2().setButtonIndex(2);

    getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioModel().add(getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem2());

  }

  /**
   * 従来型個室に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem1(){

  }

  /**
   * 多床室に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem2(){

  }

  /**
   * 病室区分（ユニット型介護老人保健施設）に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio(){

  }

  /**
   * 病室区分（ユニット型介護老人保健施設）モデルに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioModel(){

    getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem1().setButtonIndex(1);

    getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioModel().add(getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem1());

    getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem2().setButtonIndex(2);

    getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioModel().add(getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem2());

  }

  /**
   * ユニット型個室に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem1(){

  }

  /**
   * ユニット型個室的多床室に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem2(){

  }

  /**
   * 病室区分ラジオに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilitySickroomDivisionRadio(){

  }

  /**
   * 病室区分ラジオモデルに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilitySickroomDivisionRadioModel(){

    getShortStayRecuperationHealthFacilitySickroomDivisionRadioItem1().setButtonIndex(1);

    getShortStayRecuperationHealthFacilitySickroomDivisionRadioModel().add(getShortStayRecuperationHealthFacilitySickroomDivisionRadioItem1());

    getShortStayRecuperationHealthFacilitySickroomDivisionRadioItem2().setButtonIndex(2);

    getShortStayRecuperationHealthFacilitySickroomDivisionRadioModel().add(getShortStayRecuperationHealthFacilitySickroomDivisionRadioItem2());

    getShortStayRecuperationHealthFacilitySickroomDivisionRadioItem3().setButtonIndex(3);

    getShortStayRecuperationHealthFacilitySickroomDivisionRadioModel().add(getShortStayRecuperationHealthFacilitySickroomDivisionRadioItem3());

    getShortStayRecuperationHealthFacilitySickroomDivisionRadioItem4().setButtonIndex(4);

    getShortStayRecuperationHealthFacilitySickroomDivisionRadioModel().add(getShortStayRecuperationHealthFacilitySickroomDivisionRadioItem4());

  }

  /**
   * 従来型個室に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilitySickroomDivisionRadioItem1(){

  }

  /**
   * 多床室に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilitySickroomDivisionRadioItem2(){

  }

  /**
   * ユニット型個室に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilitySickroomDivisionRadioItem3(){

  }

  /**
   * ユニット型個室的多床室に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilitySickroomDivisionRadioItem4(){

  }

  /**
   * タブ2に内部項目を追加します。
   */
  protected void addTab2(){

    tab2.add(getTankinyusyoTimeDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayRecuperationHealthNightWorkConditionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getNightStaffDispositionAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHoumonRehabilitationShortConcentrationAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getDementiaActionAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getEmergencyAcceptanceRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * 夜間勤務条件基準に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthNightWorkConditionRadio(){

  }

  /**
   * 夜間勤務条件基準モデルに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthNightWorkConditionRadioModel(){

    getShortStayRecuperationHealthNightWorkConditionRadioItem1().setButtonIndex(1);

    getShortStayRecuperationHealthNightWorkConditionRadioModel().add(getShortStayRecuperationHealthNightWorkConditionRadioItem1());

    getShortStayRecuperationHealthNightWorkConditionRadioItem2().setButtonIndex(2);

    getShortStayRecuperationHealthNightWorkConditionRadioModel().add(getShortStayRecuperationHealthNightWorkConditionRadioItem2());

  }

  /**
   * 基準型に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthNightWorkConditionRadioItem1(){

  }

  /**
   * 減算型に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthNightWorkConditionRadioItem2(){

  }

  /**
   * 夜勤職員配置加算に内部項目を追加します。
   */
  protected void addNightStaffDispositionAddRadioGroup(){

  }

  /**
   * 夜勤職員配置加算モデルに内部項目を追加します。
   */
  protected void addNightStaffDispositionAddRadioGroupModel(){

    getNightStaffDispositionAddRadioItem1().setButtonIndex(1);

    getNightStaffDispositionAddRadioGroupModel().add(getNightStaffDispositionAddRadioItem1());

    getNightStaffDispositionAddRadioItem2().setButtonIndex(2);

    getNightStaffDispositionAddRadioGroupModel().add(getNightStaffDispositionAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addNightStaffDispositionAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addNightStaffDispositionAddRadioItem2(){

  }

  /**
   * 個別リハビリ実施加算に内部項目を追加します。
   */
  protected void addHoumonRehabilitationShortConcentrationAddRadio(){

  }

  /**
   * 個別リハビリ実施加算モデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationShortConcentrationAddRadioModel(){

    getHoumonRehabilitationShortConcentrationAddRadioItem1().setButtonIndex(1);

    getHoumonRehabilitationShortConcentrationAddRadioModel().add(getHoumonRehabilitationShortConcentrationAddRadioItem1());

    getHoumonRehabilitationShortConcentrationAddRadioItem2().setButtonIndex(2);

    getHoumonRehabilitationShortConcentrationAddRadioModel().add(getHoumonRehabilitationShortConcentrationAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonRehabilitationShortConcentrationAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHoumonRehabilitationShortConcentrationAddRadioItem2(){

  }

  /**
   * 認知症ケア加算に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio(){

  }

  /**
   * 認知症ケア加算モデルに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioModel(){

    getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem1().setButtonIndex(1);

    getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioModel().add(getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem1());

    getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem2().setButtonIndex(2);

    getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioModel().add(getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem2(){

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
  protected void addEmergencyAcceptanceRadioGroup(){

  }

  /**
   * 緊急短期入所受入加算モデルに内部項目を追加します。
   */
  protected void addEmergencyAcceptanceRadioGroupModel(){

    getEmergencyAcceptanceRadioItem1().setButtonIndex(1);

    getEmergencyAcceptanceRadioGroupModel().add(getEmergencyAcceptanceRadioItem1());

    getEmergencyAcceptanceRadioItem2().setButtonIndex(2);

    getEmergencyAcceptanceRadioGroupModel().add(getEmergencyAcceptanceRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addEmergencyAcceptanceRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addEmergencyAcceptanceRadioItem2(){

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
   * タブ3に内部項目を追加します。
   */
  protected void addTab3(){

    tab3.add(getShortStayRecuperationHealthFacilityMeetingAndSendingOffContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getShortStayRecuperationHealthFacilityUrgentTimeStepRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getShortStayRecuperationHealthFacilitySpecialMedicalExpense(), VRLayout.FLOW);

    tab3.add(getShortStayRecuperationHealthFacilitySpecialMedicalExpenseLabel(), VRLayout.FLOW_RETURN);

    tab3.add(getShortStayRecuperationHealthFacilityEtc30Over(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getShortStayRecuperationHealthFacilityPersonSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getShortStayRecuperationHealthFacilityDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    tab3.add(getShortStayRecuperationHealthUnitCareAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getShortStayRecuperationHealthFacilityRecuperationGroup(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 送迎区分に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityMeetingAndSendingOff(){

  }

  /**
   * 送迎区分モデルに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityMeetingAndSendingOffModel(){

    getShortStayRecuperationHealthFacilityMeetingAndSendingOffNone().setButtonIndex(1);

    getShortStayRecuperationHealthFacilityMeetingAndSendingOffModel().add(getShortStayRecuperationHealthFacilityMeetingAndSendingOffNone());

    getShortStayRecuperationHealthFacilityMeetingAndSendingOffOneWay().setButtonIndex(2);

    getShortStayRecuperationHealthFacilityMeetingAndSendingOffModel().add(getShortStayRecuperationHealthFacilityMeetingAndSendingOffOneWay());

    getShortStayRecuperationHealthFacilityMeetingAndSendingOffRoundTrip().setButtonIndex(3);

    getShortStayRecuperationHealthFacilityMeetingAndSendingOffModel().add(getShortStayRecuperationHealthFacilityMeetingAndSendingOffRoundTrip());

  }

  /**
   * 送迎なしに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityMeetingAndSendingOffNone(){

  }

  /**
   * 送迎片道に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityMeetingAndSendingOffOneWay(){

  }

  /**
   * 送迎往復に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityMeetingAndSendingOffRoundTrip(){

  }

  /**
   * 緊急時治療管理加算に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityUrgentTimeStepRadio(){

  }

  /**
   * 緊急時治療管理加算モデルに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityUrgentTimeStepRadioModel(){

    getShortStayRecuperationHealthFacilityUrgentTimeStepRadioItem1().setButtonIndex(1);

    getShortStayRecuperationHealthFacilityUrgentTimeStepRadioModel().add(getShortStayRecuperationHealthFacilityUrgentTimeStepRadioItem1());

    getShortStayRecuperationHealthFacilityUrgentTimeStepRadioItem2().setButtonIndex(2);

    getShortStayRecuperationHealthFacilityUrgentTimeStepRadioModel().add(getShortStayRecuperationHealthFacilityUrgentTimeStepRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityUrgentTimeStepRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityUrgentTimeStepRadioItem2(){

  }

  /**
   * 療養食加算に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio(){

  }

  /**
   * 療養食加算モデルに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioModel(){

    getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem1().setButtonIndex(1);

    getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioModel().add(getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem1());

    getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem2().setButtonIndex(2);

    getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioModel().add(getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem2());

    getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem3().setButtonIndex(3);

    getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioModel().add(getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem3());

    getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem4().setButtonIndex(4);

    getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioModel().add(getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem4());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem1(){

  }

  /**
   * 3回に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem2(){

  }

  /**
   * 2回に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem3(){

  }

  /**
   * 1回に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem4(){

  }

  /**
   * 特別療養費に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilitySpecialMedicalExpense(){

  }

  /**
   * ラベルに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilitySpecialMedicalExpenseLabel(){

  }

  /**
   * 30日超に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityEtc30Over(){

  }

  /**
   * 人員減算に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityPersonSubtraction(){

  }

  /**
   * 人員減算モデルに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityPersonSubtractionModel(){

    getShortStayRecuperationHealthFacilityPersonSubtractionNot().setButtonIndex(1);

    getShortStayRecuperationHealthFacilityPersonSubtractionModel().add(getShortStayRecuperationHealthFacilityPersonSubtractionNot());

    getShortStayRecuperationHealthFacilityPersonSubtractionExcess().setButtonIndex(2);

    getShortStayRecuperationHealthFacilityPersonSubtractionModel().add(getShortStayRecuperationHealthFacilityPersonSubtractionExcess());

    getShortStayRecuperationHealthFacilityPersonSubtractionStaffLack().setButtonIndex(3);

    getShortStayRecuperationHealthFacilityPersonSubtractionModel().add(getShortStayRecuperationHealthFacilityPersonSubtractionStaffLack());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityPersonSubtractionNot(){

  }

  /**
   * 定員超過に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityPersonSubtractionExcess(){

  }

  /**
   * 看護・介護職員又は医師、PT・OT・STの不足に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityPersonSubtractionStaffLack(){

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
   * ユニットケアの整備に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthUnitCareAddRadio(){

  }

  /**
   * ユニットケアの整備モデルに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthUnitCareAddRadioModel(){

    getShortStayRecuperationHealthUnitCareAddRadioItem1().setButtonIndex(1);

    getShortStayRecuperationHealthUnitCareAddRadioModel().add(getShortStayRecuperationHealthUnitCareAddRadioItem1());

    getShortStayRecuperationHealthUnitCareAddRadioItem2().setButtonIndex(2);

    getShortStayRecuperationHealthUnitCareAddRadioModel().add(getShortStayRecuperationHealthUnitCareAddRadioItem2());

  }

  /**
   * 未整備に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthUnitCareAddRadioItem1(){

  }

  /**
   * 整備に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthUnitCareAddRadioItem2(){

  }

  /**
   * 療養体制維持特別加算コンテナに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityRecuperationGroup(){

    shortStayRecuperationHealthFacilityRecuperationGroup.add(getNurseStructuralAddRadioItem1(), VRLayout.FLOW);

    shortStayRecuperationHealthFacilityRecuperationGroup.add(getNurseStructuralAddRadioItem2(), VRLayout.FLOW);

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addNurseStructuralAddRadioItem1(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addNurseStructuralAddRadioItem2(){

  }

  /**
   * タブ4に内部項目を追加します。
   */
  protected void addTab4(){

    tab4.add(getSeverelyMedicalManagementAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getStayReturnSupportRyoyoAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getDementiaProfessionalCareAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 重度療養管理加算に内部項目を追加します。
   */
  protected void addSeverelyMedicalManagementAdd(){

  }

  /**
   * 重度療養管理加算モデルに内部項目を追加します。
   */
  protected void addSeverelyMedicalManagementAddModel(){

    getSeverelyMedicalManagementAddItem1().setButtonIndex(1);

    getSeverelyMedicalManagementAddModel().add(getSeverelyMedicalManagementAddItem1());

    getSeverelyMedicalManagementAddItem2().setButtonIndex(2);

    getSeverelyMedicalManagementAddModel().add(getSeverelyMedicalManagementAddItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addSeverelyMedicalManagementAddItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addSeverelyMedicalManagementAddItem2(){

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
   * 在宅復帰・在宅療養支援機能加算に内部項目を追加します。
   */
  protected void addStayReturnSupportRyoyoAddRadio(){

  }

  /**
   * 在宅復帰・在宅療養支援機能加算モデルに内部項目を追加します。
   */
  protected void addStayReturnSupportRyoyoAddRadioModel(){

    getStayReturnSupportRyoyoAddRadioItem1().setButtonIndex(1);

    getStayReturnSupportRyoyoAddRadioModel().add(getStayReturnSupportRyoyoAddRadioItem1());

    getStayReturnSupportRyoyoAddRadioItem2().setButtonIndex(2);

    getStayReturnSupportRyoyoAddRadioModel().add(getStayReturnSupportRyoyoAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addStayReturnSupportRyoyoAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addStayReturnSupportRyoyoAddRadioItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_12211_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001_12211_201804Design getThis() {
    return this;
  }
}
