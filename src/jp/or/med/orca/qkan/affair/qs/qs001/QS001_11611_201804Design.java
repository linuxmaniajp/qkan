
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
 * 作成日: 2018/02/27  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス 利用者一覧（サービス予定作成/変更） (001)
 * プログラム サービスパターン通所リハ (QS001_11611_201804)
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
 * サービスパターン通所リハ画面項目デザイン(QS001_11611_201804) 
 */
public class QS001_11611_201804Design extends QS001ServicePanel {
  //GUIコンポーネント

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup facilityDivisionRadioGroup;

  private ACLabelContainer facilityDivisionRadioGroupContainer;

  private ACListModelAdapter facilityDivisionRadioGroupModel;

  private ACRadioButtonItem facilityDivisionRadioItem1;

  private ACRadioButtonItem facilityDivisionRadioItem2;

  private ACRadioButtonItem facilityDivisionRadioItem3;

  private ACRadioButtonItem facilityDivisionRadioItem4;

  private ACRadioButtonItem facilityDivisionRadioItem5;

  private ACRadioButtonItem facilityDivisionRadioItem6;

  private ACRadioButtonItem facilityDivisionRadioItem7;

  private ACRadioButtonItem facilityDivisionRadioItem8;

  private ACRadioButtonItem facilityDivisionRadioItem9;

  private ACComboBox houmonRehabilitationTimeDivision;

  private ACLabelContainer houmonRehabilitationTimeDivisionContainer;

  private ACComboBoxModelAdapter houmonRehabilitationTimeDivisionModel;

  private ACBackLabelContainer houmonRehabilitationTimeContena;

  private ACTimeComboBox houmonRehabilitationTimeContenaBeginTime;

  private ACLabelContainer houmonRehabilitationTimeContenaBeginTimeContainer;

  private ACComboBoxModelAdapter houmonRehabilitationTimeContenaBeginTimeModel;

  private ACTimeComboBox houmonRehabilitationTimeContenaEndTime;

  private ACLabelContainer houmonRehabilitationTimeContenaEndTimeContainer;

  private ACComboBoxModelAdapter houmonRehabilitationTimeContenaEndTimeModel;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup houmonRehabilitationSubtraction;

  private ACLabelContainer houmonRehabilitationSubtractionContainer;

  private ACListModelAdapter houmonRehabilitationSubtractionModel;

  private ACRadioButtonItem houmonRehabilitationSubtractionNot;

  private ACRadioButtonItem houmonRehabilitationSubtractionExcess;

  private ACRadioButtonItem houmonRehabilitationSubtractionLack;

  private ACValueArrayRadioButtonGroup houmonRehabilitationBathRadio;

  private ACLabelContainer houmonRehabilitationBathRadioContainer;

  private ACListModelAdapter houmonRehabilitationBathRadioModel;

  private ACRadioButtonItem houmonRehabilitationBathRadioItem1;

  private ACRadioButtonItem houmonRehabilitationBathRadioItem2;

  private ACValueArrayRadioButtonGroup houmonRehabilitationManagementAddRadio;

  private ACLabelContainer houmonRehabilitationManagementAddRadioContainer;

  private ACListModelAdapter houmonRehabilitationManagementAddRadioModel;

  private ACRadioButtonItem houmonRehabilitationManagementAddRadioItem1;

  private ACRadioButtonItem houmonRehabilitationManagementAddRadioItem2;

  private ACRadioButtonItem houmonRehabilitationManagementAddRadioItem3;

  private ACRadioButtonItem houmonRehabilitationManagementAddRadioItem4;

  private ACRadioButtonItem houmonRehabilitationManagementAddRadioItem5;

  private ACRadioButtonItem houmonRehabilitationManagementAddRadioItem6;

  private ACRadioButtonItem houmonRehabilitationManagementAddRadioItem7;

  private ACRadioButtonItem houmonRehabilitationManagementAddRadioItem8;

  private ACValueArrayRadioButtonGroup houmonRehabilitationShortConcentrationAddRadio;

  private ACLabelContainer houmonRehabilitationShortConcentrationAddRadioContainer;

  private ACListModelAdapter houmonRehabilitationShortConcentrationAddRadioModel;

  private ACRadioButtonItem houmonRehabilitationShortConcentrationAddRadioItem1;

  private ACRadioButtonItem houmonRehabilitationShortConcentrationAddRadioItem2;

  private ACValueArrayRadioButtonGroup physiotherapistStrengthenedAddRadioGroup;

  private ACLabelContainer physiotherapistStrengthenedAddRadioGroupContainer;

  private ACListModelAdapter physiotherapistStrengthenedAddRadioGroupModel;

  private ACRadioButtonItem physiotherapistStrengthenedAddRadioItem1;

  private ACRadioButtonItem physiotherapistStrengthenedAddRadioItem2;

  private ACPanel tab3;

  private ACValueArrayRadioButtonGroup dementiaRehabilitationShortConcentrationAddRadio;

  private ACLabelContainer dementiaRehabilitationShortConcentrationAddRadioContainer;

  private ACListModelAdapter dementiaRehabilitationShortConcentrationAddRadioModel;

  private ACRadioButtonItem dementiaRehabilitationShortConcentrationAddRadioItem1;

  private ACRadioButtonItem dementiaRehabilitationShortConcentrationAddRadioItem2;

  private ACRadioButtonItem dementiaRehabilitationShortConcentrationAddRadioItem3;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACValueArrayRadioButtonGroup houmonRehabilitationNourishmentManagementAddRadio;

  private ACLabelContainer houmonRehabilitationNourishmentManagementAddRadioContainer;

  private ACListModelAdapter houmonRehabilitationNourishmentManagementAddRadioModel;

  private ACRadioButtonItem houmonRehabilitationNourishmentManagementAddRadioItem1;

  private ACRadioButtonItem houmonRehabilitationNourishmentManagementAddRadioItem2;

  private ACValueArrayRadioButtonGroup houmonRehabilitationMouthFunctionAddRadio;

  private ACLabelContainer houmonRehabilitationMouthFunctionAddRadioContainer;

  private ACListModelAdapter houmonRehabilitationMouthFunctionAddRadioModel;

  private ACRadioButtonItem houmonRehabilitationMouthFunctionAddRadioItem1;

  private ACRadioButtonItem houmonRehabilitationMouthFunctionAddRadioItem2;

  private ACValueArrayRadioButtonGroup medicalManagementRadioGroup;

  private ACLabelContainer medicalManagementRadioGroupContainer;

  private ACListModelAdapter medicalManagementRadioGroupModel;

  private ACRadioButtonItem medicalManagementRadioItem1;

  private ACRadioButtonItem medicalManagementRadioItem2;

  private ACValueArrayRadioButtonGroup transportationCallRadioGroup;

  private ACLabelContainer transportationCallRadioGroupContainer;

  private ACListModelAdapter transportationCallRadioGroupModel;

  private ACRadioButtonItem transportationCallRadioItem1;

  private ACRadioButtonItem transportationCallRadioItem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACValueArrayRadioButtonGroup providerAddMountainousAreaRadioGroup;

  private ACLabelContainer providerAddMountainousAreaRadioGroupContainer;

  private ACListModelAdapter providerAddMountainousAreaRadioGroupModel;

  private ACRadioButtonItem providerAddMountainousAreaRadioItem1;

  private ACRadioButtonItem providerAddMountainousAreaRadioItem2;

  private ACPanel tab4;

  private ACValueArrayRadioButtonGroup lifeActsImproveRehabilitationRadioGroup;

  private ACLabelContainer lifeActsImproveRehabilitationRadioGroupContainer;

  private ACListModelAdapter lifeActsImproveRehabilitationRadioGroupModel;

  private ACRadioButtonItem lifeActsImproveRehabilitationRadioItem1;

  private ACRadioButtonItem lifeActsImproveRehabilitationRadioItem2;

  private ACRadioButtonItem lifeActsImproveRehabilitationRadioItem3;

  private ACValueArrayRadioButtonGroup lifeActsImproveRehaSubtractionRadioGroup;

  private ACLabelContainer lifeActsImproveRehaSubtractionRadioGroupContainer;

  private ACListModelAdapter lifeActsImproveRehaSubtractionRadioGroupModel;

  private ACRadioButtonItem lifeActsImproveRehaSubtractionRadioItem1;

  private ACRadioButtonItem lifeActsImproveRehaSubtractionRadioItem2;

  private ACValueArrayRadioButtonGroup severeCareRecipientsAccepted;

  private ACLabelContainer severeCareRecipientsAcceptedContainer;

  private ACListModelAdapter severeCareRecipientsAcceptedModel;

  private ACRadioButtonItem severeCareRecipientsAcceptedItem1;

  private ACRadioButtonItem severeCareRecipientsAcceptedItem2;

  private ACValueArrayRadioButtonGroup MeetingAndSendingOff;

  private ACLabelContainer MeetingAndSendingOffContainer;

  private ACListModelAdapter MeetingAndSendingOffModel;

  private ACRadioButtonItem MeetingAndSendingOffRoundTrip;

  private ACRadioButtonItem MeetingAndSendingOffOneWay;

  private ACRadioButtonItem MeetingAndSendingOffNone;

  private ACValueArrayRadioButtonGroup regionalServiceRadioGroup;

  private ACLabelContainer regionalServiceRadioGroupContainer;

  private ACListModelAdapter regionalServiceRadioGroupModel;

  private ACRadioButtonItem regionalServiceRadioItem1;

  private ACRadioButtonItem regionalServiceRadioItem2;

  private ACValueArrayRadioButtonGroup rehabilitationSystem;

  private ACLabelContainer rehabilitationSystemContainer;

  private ACListModelAdapter rehabilitationSystemModel;

  private ACRadioButtonItem rehabilitationSystemItem1;

  private ACRadioButtonItem rehabilitationSystemItem2;

  private ACValueArrayRadioButtonGroup nutritionScreening;

  private ACLabelContainer nutritionScreeningContainer;

  private ACListModelAdapter nutritionScreeningModel;

  private ACRadioButtonItem nutritionScreeningItem1;

  private ACRadioButtonItem nutritionScreeningItem2;

  private ACValueArrayRadioButtonGroup calculationDivision;

  private ACLabelContainer calculationDivisionContainer;

  private ACListModelAdapter calculationDivisionModel;

  private ACRadioButtonItem calculationDivisionNormal;

  private ACRadioButtonItem calculationDivisionAddOnly;

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
  public ACValueArrayRadioButtonGroup getFacilityDivisionRadioGroup(){
    if(facilityDivisionRadioGroup==null){

      facilityDivisionRadioGroup = new ACValueArrayRadioButtonGroup();

      getFacilityDivisionRadioGroupContainer().setText("施設等の区分");

      facilityDivisionRadioGroup.setBindPath("1160116");

      facilityDivisionRadioGroup.setNoSelectIndex(0);

      facilityDivisionRadioGroup.setUseClearButton(false);

      facilityDivisionRadioGroup.setModel(getFacilityDivisionRadioGroupModel());

      facilityDivisionRadioGroup.setValues(new int[]{1,2,7,3,4,8,5,6,9});

      addFacilityDivisionRadioGroup();
    }
    return facilityDivisionRadioGroup;

  }

  /**
   * 施設等の区分コンテナを取得します。
   * @return 施設等の区分コンテナ
   */
  protected ACLabelContainer getFacilityDivisionRadioGroupContainer(){
    if(facilityDivisionRadioGroupContainer==null){
      facilityDivisionRadioGroupContainer = new ACLabelContainer();
      facilityDivisionRadioGroupContainer.setFollowChildEnabled(true);
      facilityDivisionRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      facilityDivisionRadioGroupContainer.add(getFacilityDivisionRadioGroup(), null);
    }
    return facilityDivisionRadioGroupContainer;
  }

  /**
   * 施設等の区分モデルを取得します。
   * @return 施設等の区分モデル
   */
  protected ACListModelAdapter getFacilityDivisionRadioGroupModel(){
    if(facilityDivisionRadioGroupModel==null){
      facilityDivisionRadioGroupModel = new ACListModelAdapter();
      addFacilityDivisionRadioGroupModel();
    }
    return facilityDivisionRadioGroupModel;
  }

  /**
   * 通常規模（病院・診療所）を取得します。
   * @return 通常規模（病院・診療所）
   */
  public ACRadioButtonItem getFacilityDivisionRadioItem1(){
    if(facilityDivisionRadioItem1==null){

      facilityDivisionRadioItem1 = new ACRadioButtonItem();

      facilityDivisionRadioItem1.setText("通常規模（病院・診療所）");

      facilityDivisionRadioItem1.setGroup(getFacilityDivisionRadioGroup());

      facilityDivisionRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addFacilityDivisionRadioItem1();
    }
    return facilityDivisionRadioItem1;

  }

  /**
   * 通常規模（老健施設）を取得します。
   * @return 通常規模（老健施設）
   */
  public ACRadioButtonItem getFacilityDivisionRadioItem2(){
    if(facilityDivisionRadioItem2==null){

      facilityDivisionRadioItem2 = new ACRadioButtonItem();

      facilityDivisionRadioItem2.setText("通常規模（老健施設）");

      facilityDivisionRadioItem2.setGroup(getFacilityDivisionRadioGroup());

      facilityDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addFacilityDivisionRadioItem2();
    }
    return facilityDivisionRadioItem2;

  }

  /**
   * 通常規模（介護医療院）を取得します。
   * @return 通常規模（介護医療院）
   */
  public ACRadioButtonItem getFacilityDivisionRadioItem3(){
    if(facilityDivisionRadioItem3==null){

      facilityDivisionRadioItem3 = new ACRadioButtonItem();

      facilityDivisionRadioItem3.setText("通常規模（介護医療院）");

      facilityDivisionRadioItem3.setGroup(getFacilityDivisionRadioGroup());

      facilityDivisionRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addFacilityDivisionRadioItem3();
    }
    return facilityDivisionRadioItem3;

  }

  /**
   * 大規模（I）（病院・診療所）を取得します。
   * @return 大規模（I）（病院・診療所）
   */
  public ACRadioButtonItem getFacilityDivisionRadioItem4(){
    if(facilityDivisionRadioItem4==null){

      facilityDivisionRadioItem4 = new ACRadioButtonItem();

      facilityDivisionRadioItem4.setText("大規模（I）（病院・診療所）");

      facilityDivisionRadioItem4.setGroup(getFacilityDivisionRadioGroup());

      facilityDivisionRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addFacilityDivisionRadioItem4();
    }
    return facilityDivisionRadioItem4;

  }

  /**
   * 大規模（I）（老健施設）を取得します。
   * @return 大規模（I）（老健施設）
   */
  public ACRadioButtonItem getFacilityDivisionRadioItem5(){
    if(facilityDivisionRadioItem5==null){

      facilityDivisionRadioItem5 = new ACRadioButtonItem();

      facilityDivisionRadioItem5.setText("大規模（I）（老健施設）");

      facilityDivisionRadioItem5.setGroup(getFacilityDivisionRadioGroup());

      facilityDivisionRadioItem5.setConstraints(VRLayout.FLOW_RETURN);

      addFacilityDivisionRadioItem5();
    }
    return facilityDivisionRadioItem5;

  }

  /**
   * 大規模（I）（介護医療院）を取得します。
   * @return 大規模（I）（介護医療院）
   */
  public ACRadioButtonItem getFacilityDivisionRadioItem6(){
    if(facilityDivisionRadioItem6==null){

      facilityDivisionRadioItem6 = new ACRadioButtonItem();

      facilityDivisionRadioItem6.setText("大規模（I）（介護医療院）");

      facilityDivisionRadioItem6.setGroup(getFacilityDivisionRadioGroup());

      facilityDivisionRadioItem6.setConstraints(VRLayout.FLOW_RETURN);

      addFacilityDivisionRadioItem6();
    }
    return facilityDivisionRadioItem6;

  }

  /**
   * 大規模（II）（病院・診療所）を取得します。
   * @return 大規模（II）（病院・診療所）
   */
  public ACRadioButtonItem getFacilityDivisionRadioItem7(){
    if(facilityDivisionRadioItem7==null){

      facilityDivisionRadioItem7 = new ACRadioButtonItem();

      facilityDivisionRadioItem7.setText("大規模（II）（病院・診療所）");

      facilityDivisionRadioItem7.setGroup(getFacilityDivisionRadioGroup());

      facilityDivisionRadioItem7.setConstraints(VRLayout.FLOW_RETURN);

      addFacilityDivisionRadioItem7();
    }
    return facilityDivisionRadioItem7;

  }

  /**
   * 大規模（II）（老健施設）を取得します。
   * @return 大規模（II）（老健施設）
   */
  public ACRadioButtonItem getFacilityDivisionRadioItem8(){
    if(facilityDivisionRadioItem8==null){

      facilityDivisionRadioItem8 = new ACRadioButtonItem();

      facilityDivisionRadioItem8.setText("大規模（II）（老健施設）");

      facilityDivisionRadioItem8.setGroup(getFacilityDivisionRadioGroup());

      facilityDivisionRadioItem8.setConstraints(VRLayout.FLOW_RETURN);

      addFacilityDivisionRadioItem8();
    }
    return facilityDivisionRadioItem8;

  }

  /**
   * 大規模（II）（介護医療院）を取得します。
   * @return 大規模（II）（介護医療院）
   */
  public ACRadioButtonItem getFacilityDivisionRadioItem9(){
    if(facilityDivisionRadioItem9==null){

      facilityDivisionRadioItem9 = new ACRadioButtonItem();

      facilityDivisionRadioItem9.setText("大規模（II）（介護医療院）");

      facilityDivisionRadioItem9.setGroup(getFacilityDivisionRadioGroup());

      facilityDivisionRadioItem9.setConstraints(VRLayout.FLOW_RETURN);

      addFacilityDivisionRadioItem9();
    }
    return facilityDivisionRadioItem9;

  }

  /**
   * 時間区分を取得します。
   * @return 時間区分
   */
  public ACComboBox getHoumonRehabilitationTimeDivision(){
    if(houmonRehabilitationTimeDivision==null){

      houmonRehabilitationTimeDivision = new ACComboBox();

      getHoumonRehabilitationTimeDivisionContainer().setText("時間区分");

      houmonRehabilitationTimeDivision.setBindPath("1160104");

      houmonRehabilitationTimeDivision.setEditable(false);

      houmonRehabilitationTimeDivision.setModelBindPath("1160104");

      houmonRehabilitationTimeDivision.setRenderBindPath("CONTENT");

      houmonRehabilitationTimeDivision.setModel(getHoumonRehabilitationTimeDivisionModel());

      addHoumonRehabilitationTimeDivision();
    }
    return houmonRehabilitationTimeDivision;

  }

  /**
   * 時間区分コンテナを取得します。
   * @return 時間区分コンテナ
   */
  protected ACLabelContainer getHoumonRehabilitationTimeDivisionContainer(){
    if(houmonRehabilitationTimeDivisionContainer==null){
      houmonRehabilitationTimeDivisionContainer = new ACLabelContainer();
      houmonRehabilitationTimeDivisionContainer.setFollowChildEnabled(true);
      houmonRehabilitationTimeDivisionContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationTimeDivisionContainer.add(getHoumonRehabilitationTimeDivision(), null);
    }
    return houmonRehabilitationTimeDivisionContainer;
  }

  /**
   * 時間区分モデルを取得します。
   * @return 時間区分モデル
   */
  protected ACComboBoxModelAdapter getHoumonRehabilitationTimeDivisionModel(){
    if(houmonRehabilitationTimeDivisionModel==null){
      houmonRehabilitationTimeDivisionModel = new ACComboBoxModelAdapter();
      addHoumonRehabilitationTimeDivisionModel();
    }
    return houmonRehabilitationTimeDivisionModel;
  }

  /**
   * 提供時間コンテナを取得します。
   * @return 提供時間コンテナ
   */
  public ACBackLabelContainer getHoumonRehabilitationTimeContena(){
    if(houmonRehabilitationTimeContena==null){

      houmonRehabilitationTimeContena = new ACBackLabelContainer();

      addHoumonRehabilitationTimeContena();
    }
    return houmonRehabilitationTimeContena;

  }

  /**
   * 開始時刻コンボを取得します。
   * @return 開始時刻コンボ
   */
  public ACTimeComboBox getHoumonRehabilitationTimeContenaBeginTime(){
    if(houmonRehabilitationTimeContenaBeginTime==null){

      houmonRehabilitationTimeContenaBeginTime = new ACTimeComboBox();

      getHoumonRehabilitationTimeContenaBeginTimeContainer().setText("開始時刻");

      houmonRehabilitationTimeContenaBeginTime.setBindPath("3");

      houmonRehabilitationTimeContenaBeginTime.setModelBindPath("3");

      houmonRehabilitationTimeContenaBeginTime.setRenderBindPath("CONTENT");

      houmonRehabilitationTimeContenaBeginTime.setModel(getHoumonRehabilitationTimeContenaBeginTimeModel());

      addHoumonRehabilitationTimeContenaBeginTime();
    }
    return houmonRehabilitationTimeContenaBeginTime;

  }

  /**
   * 開始時刻コンボコンテナを取得します。
   * @return 開始時刻コンボコンテナ
   */
  protected ACLabelContainer getHoumonRehabilitationTimeContenaBeginTimeContainer(){
    if(houmonRehabilitationTimeContenaBeginTimeContainer==null){
      houmonRehabilitationTimeContenaBeginTimeContainer = new ACLabelContainer();
      houmonRehabilitationTimeContenaBeginTimeContainer.setFollowChildEnabled(true);
      houmonRehabilitationTimeContenaBeginTimeContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationTimeContenaBeginTimeContainer.add(getHoumonRehabilitationTimeContenaBeginTime(), null);
    }
    return houmonRehabilitationTimeContenaBeginTimeContainer;
  }

  /**
   * 開始時刻コンボモデルを取得します。
   * @return 開始時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getHoumonRehabilitationTimeContenaBeginTimeModel(){
    if(houmonRehabilitationTimeContenaBeginTimeModel==null){
      houmonRehabilitationTimeContenaBeginTimeModel = new ACComboBoxModelAdapter();
      addHoumonRehabilitationTimeContenaBeginTimeModel();
    }
    return houmonRehabilitationTimeContenaBeginTimeModel;
  }

  /**
   * 終了時刻コンボを取得します。
   * @return 終了時刻コンボ
   */
  public ACTimeComboBox getHoumonRehabilitationTimeContenaEndTime(){
    if(houmonRehabilitationTimeContenaEndTime==null){

      houmonRehabilitationTimeContenaEndTime = new ACTimeComboBox();

      getHoumonRehabilitationTimeContenaEndTimeContainer().setText("終了時刻");

      houmonRehabilitationTimeContenaEndTime.setBindPath("4");

      houmonRehabilitationTimeContenaEndTime.setModelBindPath("4");

      houmonRehabilitationTimeContenaEndTime.setRenderBindPath("CONTENT");

      houmonRehabilitationTimeContenaEndTime.setModel(getHoumonRehabilitationTimeContenaEndTimeModel());

      addHoumonRehabilitationTimeContenaEndTime();
    }
    return houmonRehabilitationTimeContenaEndTime;

  }

  /**
   * 終了時刻コンボコンテナを取得します。
   * @return 終了時刻コンボコンテナ
   */
  protected ACLabelContainer getHoumonRehabilitationTimeContenaEndTimeContainer(){
    if(houmonRehabilitationTimeContenaEndTimeContainer==null){
      houmonRehabilitationTimeContenaEndTimeContainer = new ACLabelContainer();
      houmonRehabilitationTimeContenaEndTimeContainer.setFollowChildEnabled(true);
      houmonRehabilitationTimeContenaEndTimeContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationTimeContenaEndTimeContainer.add(getHoumonRehabilitationTimeContenaEndTime(), null);
    }
    return houmonRehabilitationTimeContenaEndTimeContainer;
  }

  /**
   * 終了時刻コンボモデルを取得します。
   * @return 終了時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getHoumonRehabilitationTimeContenaEndTimeModel(){
    if(houmonRehabilitationTimeContenaEndTimeModel==null){
      houmonRehabilitationTimeContenaEndTimeModel = new ACComboBoxModelAdapter();
      addHoumonRehabilitationTimeContenaEndTimeModel();
    }
    return houmonRehabilitationTimeContenaEndTimeModel;
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
   * 人員減算を取得します。
   * @return 人員減算
   */
  public ACValueArrayRadioButtonGroup getHoumonRehabilitationSubtraction(){
    if(houmonRehabilitationSubtraction==null){

      houmonRehabilitationSubtraction = new ACValueArrayRadioButtonGroup();

      getHoumonRehabilitationSubtractionContainer().setText("人員減算");

      houmonRehabilitationSubtraction.setBindPath("1160109");

      houmonRehabilitationSubtraction.setUseClearButton(false);

      houmonRehabilitationSubtraction.setModel(getHoumonRehabilitationSubtractionModel());

      houmonRehabilitationSubtraction.setValues(new int[]{1,2,3});

      addHoumonRehabilitationSubtraction();
    }
    return houmonRehabilitationSubtraction;

  }

  /**
   * 人員減算コンテナを取得します。
   * @return 人員減算コンテナ
   */
  protected ACLabelContainer getHoumonRehabilitationSubtractionContainer(){
    if(houmonRehabilitationSubtractionContainer==null){
      houmonRehabilitationSubtractionContainer = new ACLabelContainer();
      houmonRehabilitationSubtractionContainer.setFollowChildEnabled(true);
      houmonRehabilitationSubtractionContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationSubtractionContainer.add(getHoumonRehabilitationSubtraction(), null);
    }
    return houmonRehabilitationSubtractionContainer;
  }

  /**
   * 人員減算モデルを取得します。
   * @return 人員減算モデル
   */
  protected ACListModelAdapter getHoumonRehabilitationSubtractionModel(){
    if(houmonRehabilitationSubtractionModel==null){
      houmonRehabilitationSubtractionModel = new ACListModelAdapter();
      addHoumonRehabilitationSubtractionModel();
    }
    return houmonRehabilitationSubtractionModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonRehabilitationSubtractionNot(){
    if(houmonRehabilitationSubtractionNot==null){

      houmonRehabilitationSubtractionNot = new ACRadioButtonItem();

      houmonRehabilitationSubtractionNot.setText("なし");

      houmonRehabilitationSubtractionNot.setGroup(getHoumonRehabilitationSubtraction());

      houmonRehabilitationSubtractionNot.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationSubtractionNot();
    }
    return houmonRehabilitationSubtractionNot;

  }

  /**
   * 定員超過を取得します。
   * @return 定員超過
   */
  public ACRadioButtonItem getHoumonRehabilitationSubtractionExcess(){
    if(houmonRehabilitationSubtractionExcess==null){

      houmonRehabilitationSubtractionExcess = new ACRadioButtonItem();

      houmonRehabilitationSubtractionExcess.setText("定員超過");

      houmonRehabilitationSubtractionExcess.setGroup(getHoumonRehabilitationSubtraction());

      houmonRehabilitationSubtractionExcess.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonRehabilitationSubtractionExcess();
    }
    return houmonRehabilitationSubtractionExcess;

  }

  /**
   * 医師、PT・OT・ST、看護・介護職員の不足を取得します。
   * @return 医師、PT・OT・ST、看護・介護職員の不足
   */
  public ACRadioButtonItem getHoumonRehabilitationSubtractionLack(){
    if(houmonRehabilitationSubtractionLack==null){

      houmonRehabilitationSubtractionLack = new ACRadioButtonItem();

      houmonRehabilitationSubtractionLack.setText("<html>医師、PT・OT・ST、<br>看護・介護職員の不足</html>");

      houmonRehabilitationSubtractionLack.setGroup(getHoumonRehabilitationSubtraction());

      houmonRehabilitationSubtractionLack.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationSubtractionLack();
    }
    return houmonRehabilitationSubtractionLack;

  }

  /**
   * 入浴加算を取得します。
   * @return 入浴加算
   */
  public ACValueArrayRadioButtonGroup getHoumonRehabilitationBathRadio(){
    if(houmonRehabilitationBathRadio==null){

      houmonRehabilitationBathRadio = new ACValueArrayRadioButtonGroup();

      getHoumonRehabilitationBathRadioContainer().setText("入浴加算");

      houmonRehabilitationBathRadio.setBindPath("1160105");

      houmonRehabilitationBathRadio.setUseClearButton(false);

      houmonRehabilitationBathRadio.setModel(getHoumonRehabilitationBathRadioModel());

      houmonRehabilitationBathRadio.setValues(new int[]{1,2});

      addHoumonRehabilitationBathRadio();
    }
    return houmonRehabilitationBathRadio;

  }

  /**
   * 入浴加算コンテナを取得します。
   * @return 入浴加算コンテナ
   */
  protected ACLabelContainer getHoumonRehabilitationBathRadioContainer(){
    if(houmonRehabilitationBathRadioContainer==null){
      houmonRehabilitationBathRadioContainer = new ACLabelContainer();
      houmonRehabilitationBathRadioContainer.setFollowChildEnabled(true);
      houmonRehabilitationBathRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationBathRadioContainer.add(getHoumonRehabilitationBathRadio(), null);
    }
    return houmonRehabilitationBathRadioContainer;
  }

  /**
   * 入浴加算モデルを取得します。
   * @return 入浴加算モデル
   */
  protected ACListModelAdapter getHoumonRehabilitationBathRadioModel(){
    if(houmonRehabilitationBathRadioModel==null){
      houmonRehabilitationBathRadioModel = new ACListModelAdapter();
      addHoumonRehabilitationBathRadioModel();
    }
    return houmonRehabilitationBathRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonRehabilitationBathRadioItem1(){
    if(houmonRehabilitationBathRadioItem1==null){

      houmonRehabilitationBathRadioItem1 = new ACRadioButtonItem();

      houmonRehabilitationBathRadioItem1.setText("なし");

      houmonRehabilitationBathRadioItem1.setGroup(getHoumonRehabilitationBathRadio());

      houmonRehabilitationBathRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationBathRadioItem1();
    }
    return houmonRehabilitationBathRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHoumonRehabilitationBathRadioItem2(){
    if(houmonRehabilitationBathRadioItem2==null){

      houmonRehabilitationBathRadioItem2 = new ACRadioButtonItem();

      houmonRehabilitationBathRadioItem2.setText("あり");

      houmonRehabilitationBathRadioItem2.setGroup(getHoumonRehabilitationBathRadio());

      houmonRehabilitationBathRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationBathRadioItem2();
    }
    return houmonRehabilitationBathRadioItem2;

  }

  /**
   * リハビリテーションマネジメント加算を取得します。
   * @return リハビリテーションマネジメント加算
   */
  public ACValueArrayRadioButtonGroup getHoumonRehabilitationManagementAddRadio(){
    if(houmonRehabilitationManagementAddRadio==null){

      houmonRehabilitationManagementAddRadio = new ACValueArrayRadioButtonGroup();

      getHoumonRehabilitationManagementAddRadioContainer().setText("<html>リハビリテーション<br>マネジメント加算<html>");

      houmonRehabilitationManagementAddRadio.setBindPath("1160111");

      houmonRehabilitationManagementAddRadio.setUseClearButton(false);

      houmonRehabilitationManagementAddRadio.setModel(getHoumonRehabilitationManagementAddRadioModel());

      houmonRehabilitationManagementAddRadio.setValues(new int[]{1,2,3,4,5,6,7,8});

      addHoumonRehabilitationManagementAddRadio();
    }
    return houmonRehabilitationManagementAddRadio;

  }

  /**
   * リハビリテーションマネジメント加算コンテナを取得します。
   * @return リハビリテーションマネジメント加算コンテナ
   */
  protected ACLabelContainer getHoumonRehabilitationManagementAddRadioContainer(){
    if(houmonRehabilitationManagementAddRadioContainer==null){
      houmonRehabilitationManagementAddRadioContainer = new ACLabelContainer();
      houmonRehabilitationManagementAddRadioContainer.setFollowChildEnabled(true);
      houmonRehabilitationManagementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationManagementAddRadioContainer.add(getHoumonRehabilitationManagementAddRadio(), null);
    }
    return houmonRehabilitationManagementAddRadioContainer;
  }

  /**
   * リハビリテーションマネジメント加算モデルを取得します。
   * @return リハビリテーションマネジメント加算モデル
   */
  protected ACListModelAdapter getHoumonRehabilitationManagementAddRadioModel(){
    if(houmonRehabilitationManagementAddRadioModel==null){
      houmonRehabilitationManagementAddRadioModel = new ACListModelAdapter();
      addHoumonRehabilitationManagementAddRadioModel();
    }
    return houmonRehabilitationManagementAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonRehabilitationManagementAddRadioItem1(){
    if(houmonRehabilitationManagementAddRadioItem1==null){

      houmonRehabilitationManagementAddRadioItem1 = new ACRadioButtonItem();

      houmonRehabilitationManagementAddRadioItem1.setText("なし");

      houmonRehabilitationManagementAddRadioItem1.setGroup(getHoumonRehabilitationManagementAddRadio());

      houmonRehabilitationManagementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationManagementAddRadioItem1();
    }
    return houmonRehabilitationManagementAddRadioItem1;

  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getHoumonRehabilitationManagementAddRadioItem2(){
    if(houmonRehabilitationManagementAddRadioItem2==null){

      houmonRehabilitationManagementAddRadioItem2 = new ACRadioButtonItem();

      houmonRehabilitationManagementAddRadioItem2.setText("I型");

      houmonRehabilitationManagementAddRadioItem2.setGroup(getHoumonRehabilitationManagementAddRadio());

      houmonRehabilitationManagementAddRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonRehabilitationManagementAddRadioItem2();
    }
    return houmonRehabilitationManagementAddRadioItem2;

  }

  /**
   * II型(6月以内)を取得します。
   * @return II型(6月以内)
   */
  public ACRadioButtonItem getHoumonRehabilitationManagementAddRadioItem3(){
    if(houmonRehabilitationManagementAddRadioItem3==null){

      houmonRehabilitationManagementAddRadioItem3 = new ACRadioButtonItem();

      houmonRehabilitationManagementAddRadioItem3.setText("II型(6月以内)");

      houmonRehabilitationManagementAddRadioItem3.setGroup(getHoumonRehabilitationManagementAddRadio());

      houmonRehabilitationManagementAddRadioItem3.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationManagementAddRadioItem3();
    }
    return houmonRehabilitationManagementAddRadioItem3;

  }

  /**
   * II型(6月超)を取得します。
   * @return II型(6月超)
   */
  public ACRadioButtonItem getHoumonRehabilitationManagementAddRadioItem4(){
    if(houmonRehabilitationManagementAddRadioItem4==null){

      houmonRehabilitationManagementAddRadioItem4 = new ACRadioButtonItem();

      houmonRehabilitationManagementAddRadioItem4.setText("II型(6月超)");

      houmonRehabilitationManagementAddRadioItem4.setGroup(getHoumonRehabilitationManagementAddRadio());

      houmonRehabilitationManagementAddRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonRehabilitationManagementAddRadioItem4();
    }
    return houmonRehabilitationManagementAddRadioItem4;

  }

  /**
   * III型(6月以内)を取得します。
   * @return III型(6月以内)
   */
  public ACRadioButtonItem getHoumonRehabilitationManagementAddRadioItem5(){
    if(houmonRehabilitationManagementAddRadioItem5==null){

      houmonRehabilitationManagementAddRadioItem5 = new ACRadioButtonItem();

      houmonRehabilitationManagementAddRadioItem5.setText("III型(6月以内)");

      houmonRehabilitationManagementAddRadioItem5.setGroup(getHoumonRehabilitationManagementAddRadio());

      houmonRehabilitationManagementAddRadioItem5.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationManagementAddRadioItem5();
    }
    return houmonRehabilitationManagementAddRadioItem5;

  }

  /**
   * III型(6月超)を取得します。
   * @return III型(6月超)
   */
  public ACRadioButtonItem getHoumonRehabilitationManagementAddRadioItem6(){
    if(houmonRehabilitationManagementAddRadioItem6==null){

      houmonRehabilitationManagementAddRadioItem6 = new ACRadioButtonItem();

      houmonRehabilitationManagementAddRadioItem6.setText("III型(6月超)");

      houmonRehabilitationManagementAddRadioItem6.setGroup(getHoumonRehabilitationManagementAddRadio());

      houmonRehabilitationManagementAddRadioItem6.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonRehabilitationManagementAddRadioItem6();
    }
    return houmonRehabilitationManagementAddRadioItem6;

  }

  /**
   * IV型(6月以内)を取得します。
   * @return IV型(6月以内)
   */
  public ACRadioButtonItem getHoumonRehabilitationManagementAddRadioItem7(){
    if(houmonRehabilitationManagementAddRadioItem7==null){

      houmonRehabilitationManagementAddRadioItem7 = new ACRadioButtonItem();

      houmonRehabilitationManagementAddRadioItem7.setText("IV型(6月以内)");

      houmonRehabilitationManagementAddRadioItem7.setGroup(getHoumonRehabilitationManagementAddRadio());

      houmonRehabilitationManagementAddRadioItem7.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationManagementAddRadioItem7();
    }
    return houmonRehabilitationManagementAddRadioItem7;

  }

  /**
   * IV型(6月超)を取得します。
   * @return IV型(6月超)
   */
  public ACRadioButtonItem getHoumonRehabilitationManagementAddRadioItem8(){
    if(houmonRehabilitationManagementAddRadioItem8==null){

      houmonRehabilitationManagementAddRadioItem8 = new ACRadioButtonItem();

      houmonRehabilitationManagementAddRadioItem8.setText("IV型(6月超)");

      houmonRehabilitationManagementAddRadioItem8.setGroup(getHoumonRehabilitationManagementAddRadio());

      houmonRehabilitationManagementAddRadioItem8.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationManagementAddRadioItem8();
    }
    return houmonRehabilitationManagementAddRadioItem8;

  }

  /**
   * 短期集中個別リハビリ実施加算を取得します。
   * @return 短期集中個別リハビリ実施加算
   */
  public ACValueArrayRadioButtonGroup getHoumonRehabilitationShortConcentrationAddRadio(){
    if(houmonRehabilitationShortConcentrationAddRadio==null){

      houmonRehabilitationShortConcentrationAddRadio = new ACValueArrayRadioButtonGroup();

      getHoumonRehabilitationShortConcentrationAddRadioContainer().setText("短期集中個別リハビリ実施加算");

      houmonRehabilitationShortConcentrationAddRadio.setBindPath("1160112");

      houmonRehabilitationShortConcentrationAddRadio.setUseClearButton(false);

      houmonRehabilitationShortConcentrationAddRadio.setModel(getHoumonRehabilitationShortConcentrationAddRadioModel());

      houmonRehabilitationShortConcentrationAddRadio.setValues(new int[]{1,2});

      addHoumonRehabilitationShortConcentrationAddRadio();
    }
    return houmonRehabilitationShortConcentrationAddRadio;

  }

  /**
   * 短期集中個別リハビリ実施加算コンテナを取得します。
   * @return 短期集中個別リハビリ実施加算コンテナ
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
   * 短期集中個別リハビリ実施加算モデルを取得します。
   * @return 短期集中個別リハビリ実施加算モデル
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
   * 理学療法士等体制強化加算を取得します。
   * @return 理学療法士等体制強化加算
   */
  public ACValueArrayRadioButtonGroup getPhysiotherapistStrengthenedAddRadioGroup(){
    if(physiotherapistStrengthenedAddRadioGroup==null){

      physiotherapistStrengthenedAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getPhysiotherapistStrengthenedAddRadioGroupContainer().setText("理学療法士等体制強化加算");

      physiotherapistStrengthenedAddRadioGroup.setBindPath("1160119");

      physiotherapistStrengthenedAddRadioGroup.setNoSelectIndex(0);

      physiotherapistStrengthenedAddRadioGroup.setUseClearButton(false);

      physiotherapistStrengthenedAddRadioGroup.setModel(getPhysiotherapistStrengthenedAddRadioGroupModel());

      physiotherapistStrengthenedAddRadioGroup.setValues(new int[]{1,2});

      addPhysiotherapistStrengthenedAddRadioGroup();
    }
    return physiotherapistStrengthenedAddRadioGroup;

  }

  /**
   * 理学療法士等体制強化加算コンテナを取得します。
   * @return 理学療法士等体制強化加算コンテナ
   */
  protected ACLabelContainer getPhysiotherapistStrengthenedAddRadioGroupContainer(){
    if(physiotherapistStrengthenedAddRadioGroupContainer==null){
      physiotherapistStrengthenedAddRadioGroupContainer = new ACLabelContainer();
      physiotherapistStrengthenedAddRadioGroupContainer.setFollowChildEnabled(true);
      physiotherapistStrengthenedAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      physiotherapistStrengthenedAddRadioGroupContainer.add(getPhysiotherapistStrengthenedAddRadioGroup(), null);
    }
    return physiotherapistStrengthenedAddRadioGroupContainer;
  }

  /**
   * 理学療法士等体制強化加算モデルを取得します。
   * @return 理学療法士等体制強化加算モデル
   */
  protected ACListModelAdapter getPhysiotherapistStrengthenedAddRadioGroupModel(){
    if(physiotherapistStrengthenedAddRadioGroupModel==null){
      physiotherapistStrengthenedAddRadioGroupModel = new ACListModelAdapter();
      addPhysiotherapistStrengthenedAddRadioGroupModel();
    }
    return physiotherapistStrengthenedAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getPhysiotherapistStrengthenedAddRadioItem1(){
    if(physiotherapistStrengthenedAddRadioItem1==null){

      physiotherapistStrengthenedAddRadioItem1 = new ACRadioButtonItem();

      physiotherapistStrengthenedAddRadioItem1.setText("なし");

      physiotherapistStrengthenedAddRadioItem1.setGroup(getPhysiotherapistStrengthenedAddRadioGroup());

      physiotherapistStrengthenedAddRadioItem1.setConstraints(VRLayout.FLOW);

      addPhysiotherapistStrengthenedAddRadioItem1();
    }
    return physiotherapistStrengthenedAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getPhysiotherapistStrengthenedAddRadioItem2(){
    if(physiotherapistStrengthenedAddRadioItem2==null){

      physiotherapistStrengthenedAddRadioItem2 = new ACRadioButtonItem();

      physiotherapistStrengthenedAddRadioItem2.setText("あり");

      physiotherapistStrengthenedAddRadioItem2.setGroup(getPhysiotherapistStrengthenedAddRadioGroup());

      physiotherapistStrengthenedAddRadioItem2.setConstraints(VRLayout.FLOW);

      addPhysiotherapistStrengthenedAddRadioItem2();
    }
    return physiotherapistStrengthenedAddRadioItem2;

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
   * 認知症短期集中リハビリ実施加算を取得します。
   * @return 認知症短期集中リハビリ実施加算
   */
  public ACValueArrayRadioButtonGroup getDementiaRehabilitationShortConcentrationAddRadio(){
    if(dementiaRehabilitationShortConcentrationAddRadio==null){

      dementiaRehabilitationShortConcentrationAddRadio = new ACValueArrayRadioButtonGroup();

      getDementiaRehabilitationShortConcentrationAddRadioContainer().setText("認知症短期集中リハビリ実施加算");

      dementiaRehabilitationShortConcentrationAddRadio.setBindPath("1160120");

      dementiaRehabilitationShortConcentrationAddRadio.setUseClearButton(false);

      dementiaRehabilitationShortConcentrationAddRadio.setModel(getDementiaRehabilitationShortConcentrationAddRadioModel());

      dementiaRehabilitationShortConcentrationAddRadio.setValues(new int[]{1,2,3});

      addDementiaRehabilitationShortConcentrationAddRadio();
    }
    return dementiaRehabilitationShortConcentrationAddRadio;

  }

  /**
   * 認知症短期集中リハビリ実施加算コンテナを取得します。
   * @return 認知症短期集中リハビリ実施加算コンテナ
   */
  protected ACLabelContainer getDementiaRehabilitationShortConcentrationAddRadioContainer(){
    if(dementiaRehabilitationShortConcentrationAddRadioContainer==null){
      dementiaRehabilitationShortConcentrationAddRadioContainer = new ACLabelContainer();
      dementiaRehabilitationShortConcentrationAddRadioContainer.setFollowChildEnabled(true);
      dementiaRehabilitationShortConcentrationAddRadioContainer.setVAlignment(VRLayout.CENTER);
      dementiaRehabilitationShortConcentrationAddRadioContainer.add(getDementiaRehabilitationShortConcentrationAddRadio(), null);
    }
    return dementiaRehabilitationShortConcentrationAddRadioContainer;
  }

  /**
   * 認知症短期集中リハビリ実施加算モデルを取得します。
   * @return 認知症短期集中リハビリ実施加算モデル
   */
  protected ACListModelAdapter getDementiaRehabilitationShortConcentrationAddRadioModel(){
    if(dementiaRehabilitationShortConcentrationAddRadioModel==null){
      dementiaRehabilitationShortConcentrationAddRadioModel = new ACListModelAdapter();
      addDementiaRehabilitationShortConcentrationAddRadioModel();
    }
    return dementiaRehabilitationShortConcentrationAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getDementiaRehabilitationShortConcentrationAddRadioItem1(){
    if(dementiaRehabilitationShortConcentrationAddRadioItem1==null){

      dementiaRehabilitationShortConcentrationAddRadioItem1 = new ACRadioButtonItem();

      dementiaRehabilitationShortConcentrationAddRadioItem1.setText("なし");

      dementiaRehabilitationShortConcentrationAddRadioItem1.setGroup(getDementiaRehabilitationShortConcentrationAddRadio());

      dementiaRehabilitationShortConcentrationAddRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addDementiaRehabilitationShortConcentrationAddRadioItem1();
    }
    return dementiaRehabilitationShortConcentrationAddRadioItem1;

  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getDementiaRehabilitationShortConcentrationAddRadioItem2(){
    if(dementiaRehabilitationShortConcentrationAddRadioItem2==null){

      dementiaRehabilitationShortConcentrationAddRadioItem2 = new ACRadioButtonItem();

      dementiaRehabilitationShortConcentrationAddRadioItem2.setText("I型");

      dementiaRehabilitationShortConcentrationAddRadioItem2.setGroup(getDementiaRehabilitationShortConcentrationAddRadio());

      dementiaRehabilitationShortConcentrationAddRadioItem2.setConstraints(VRLayout.FLOW);

      addDementiaRehabilitationShortConcentrationAddRadioItem2();
    }
    return dementiaRehabilitationShortConcentrationAddRadioItem2;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getDementiaRehabilitationShortConcentrationAddRadioItem3(){
    if(dementiaRehabilitationShortConcentrationAddRadioItem3==null){

      dementiaRehabilitationShortConcentrationAddRadioItem3 = new ACRadioButtonItem();

      dementiaRehabilitationShortConcentrationAddRadioItem3.setText("II型");

      dementiaRehabilitationShortConcentrationAddRadioItem3.setGroup(getDementiaRehabilitationShortConcentrationAddRadio());

      dementiaRehabilitationShortConcentrationAddRadioItem3.setConstraints(VRLayout.FLOW);

      addDementiaRehabilitationShortConcentrationAddRadioItem3();
    }
    return dementiaRehabilitationShortConcentrationAddRadioItem3;

  }

  /**
   * 若年性認知症利用者受入加算を取得します。
   * @return 若年性認知症利用者受入加算
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("若年性認知症利用者受入加算");

      youngDementiaPatinetAddRadioGroup.setBindPath("1160121");

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
   * 栄養改善加算を取得します。
   * @return 栄養改善加算
   */
  public ACValueArrayRadioButtonGroup getHoumonRehabilitationNourishmentManagementAddRadio(){
    if(houmonRehabilitationNourishmentManagementAddRadio==null){

      houmonRehabilitationNourishmentManagementAddRadio = new ACValueArrayRadioButtonGroup();

      getHoumonRehabilitationNourishmentManagementAddRadioContainer().setText("栄養改善加算");

      houmonRehabilitationNourishmentManagementAddRadio.setBindPath("1160114");

      houmonRehabilitationNourishmentManagementAddRadio.setUseClearButton(false);

      houmonRehabilitationNourishmentManagementAddRadio.setModel(getHoumonRehabilitationNourishmentManagementAddRadioModel());

      houmonRehabilitationNourishmentManagementAddRadio.setValues(new int[]{1,2});

      addHoumonRehabilitationNourishmentManagementAddRadio();
    }
    return houmonRehabilitationNourishmentManagementAddRadio;

  }

  /**
   * 栄養改善加算コンテナを取得します。
   * @return 栄養改善加算コンテナ
   */
  protected ACLabelContainer getHoumonRehabilitationNourishmentManagementAddRadioContainer(){
    if(houmonRehabilitationNourishmentManagementAddRadioContainer==null){
      houmonRehabilitationNourishmentManagementAddRadioContainer = new ACLabelContainer();
      houmonRehabilitationNourishmentManagementAddRadioContainer.setFollowChildEnabled(true);
      houmonRehabilitationNourishmentManagementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationNourishmentManagementAddRadioContainer.add(getHoumonRehabilitationNourishmentManagementAddRadio(), null);
    }
    return houmonRehabilitationNourishmentManagementAddRadioContainer;
  }

  /**
   * 栄養改善加算モデルを取得します。
   * @return 栄養改善加算モデル
   */
  protected ACListModelAdapter getHoumonRehabilitationNourishmentManagementAddRadioModel(){
    if(houmonRehabilitationNourishmentManagementAddRadioModel==null){
      houmonRehabilitationNourishmentManagementAddRadioModel = new ACListModelAdapter();
      addHoumonRehabilitationNourishmentManagementAddRadioModel();
    }
    return houmonRehabilitationNourishmentManagementAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonRehabilitationNourishmentManagementAddRadioItem1(){
    if(houmonRehabilitationNourishmentManagementAddRadioItem1==null){

      houmonRehabilitationNourishmentManagementAddRadioItem1 = new ACRadioButtonItem();

      houmonRehabilitationNourishmentManagementAddRadioItem1.setText("なし");

      houmonRehabilitationNourishmentManagementAddRadioItem1.setGroup(getHoumonRehabilitationNourishmentManagementAddRadio());

      houmonRehabilitationNourishmentManagementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationNourishmentManagementAddRadioItem1();
    }
    return houmonRehabilitationNourishmentManagementAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHoumonRehabilitationNourishmentManagementAddRadioItem2(){
    if(houmonRehabilitationNourishmentManagementAddRadioItem2==null){

      houmonRehabilitationNourishmentManagementAddRadioItem2 = new ACRadioButtonItem();

      houmonRehabilitationNourishmentManagementAddRadioItem2.setText("あり");

      houmonRehabilitationNourishmentManagementAddRadioItem2.setGroup(getHoumonRehabilitationNourishmentManagementAddRadio());

      houmonRehabilitationNourishmentManagementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationNourishmentManagementAddRadioItem2();
    }
    return houmonRehabilitationNourishmentManagementAddRadioItem2;

  }

  /**
   * 口腔機能向上加算を取得します。
   * @return 口腔機能向上加算
   */
  public ACValueArrayRadioButtonGroup getHoumonRehabilitationMouthFunctionAddRadio(){
    if(houmonRehabilitationMouthFunctionAddRadio==null){

      houmonRehabilitationMouthFunctionAddRadio = new ACValueArrayRadioButtonGroup();

      getHoumonRehabilitationMouthFunctionAddRadioContainer().setText("口腔機能向上加算");

      houmonRehabilitationMouthFunctionAddRadio.setBindPath("1160115");

      houmonRehabilitationMouthFunctionAddRadio.setUseClearButton(false);

      houmonRehabilitationMouthFunctionAddRadio.setModel(getHoumonRehabilitationMouthFunctionAddRadioModel());

      houmonRehabilitationMouthFunctionAddRadio.setValues(new int[]{1,2});

      addHoumonRehabilitationMouthFunctionAddRadio();
    }
    return houmonRehabilitationMouthFunctionAddRadio;

  }

  /**
   * 口腔機能向上加算コンテナを取得します。
   * @return 口腔機能向上加算コンテナ
   */
  protected ACLabelContainer getHoumonRehabilitationMouthFunctionAddRadioContainer(){
    if(houmonRehabilitationMouthFunctionAddRadioContainer==null){
      houmonRehabilitationMouthFunctionAddRadioContainer = new ACLabelContainer();
      houmonRehabilitationMouthFunctionAddRadioContainer.setFollowChildEnabled(true);
      houmonRehabilitationMouthFunctionAddRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationMouthFunctionAddRadioContainer.add(getHoumonRehabilitationMouthFunctionAddRadio(), null);
    }
    return houmonRehabilitationMouthFunctionAddRadioContainer;
  }

  /**
   * 口腔機能向上加算モデルを取得します。
   * @return 口腔機能向上加算モデル
   */
  protected ACListModelAdapter getHoumonRehabilitationMouthFunctionAddRadioModel(){
    if(houmonRehabilitationMouthFunctionAddRadioModel==null){
      houmonRehabilitationMouthFunctionAddRadioModel = new ACListModelAdapter();
      addHoumonRehabilitationMouthFunctionAddRadioModel();
    }
    return houmonRehabilitationMouthFunctionAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonRehabilitationMouthFunctionAddRadioItem1(){
    if(houmonRehabilitationMouthFunctionAddRadioItem1==null){

      houmonRehabilitationMouthFunctionAddRadioItem1 = new ACRadioButtonItem();

      houmonRehabilitationMouthFunctionAddRadioItem1.setText("なし");

      houmonRehabilitationMouthFunctionAddRadioItem1.setGroup(getHoumonRehabilitationMouthFunctionAddRadio());

      houmonRehabilitationMouthFunctionAddRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationMouthFunctionAddRadioItem1();
    }
    return houmonRehabilitationMouthFunctionAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHoumonRehabilitationMouthFunctionAddRadioItem2(){
    if(houmonRehabilitationMouthFunctionAddRadioItem2==null){

      houmonRehabilitationMouthFunctionAddRadioItem2 = new ACRadioButtonItem();

      houmonRehabilitationMouthFunctionAddRadioItem2.setText("あり");

      houmonRehabilitationMouthFunctionAddRadioItem2.setGroup(getHoumonRehabilitationMouthFunctionAddRadio());

      houmonRehabilitationMouthFunctionAddRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationMouthFunctionAddRadioItem2();
    }
    return houmonRehabilitationMouthFunctionAddRadioItem2;

  }

  /**
   * 重度療養管理加算を取得します。
   * @return 重度療養管理加算
   */
  public ACValueArrayRadioButtonGroup getMedicalManagementRadioGroup(){
    if(medicalManagementRadioGroup==null){

      medicalManagementRadioGroup = new ACValueArrayRadioButtonGroup();

      getMedicalManagementRadioGroupContainer().setText("重度療養管理加算");

      medicalManagementRadioGroup.setBindPath("1160123");

      medicalManagementRadioGroup.setUseClearButton(false);

      medicalManagementRadioGroup.setModel(getMedicalManagementRadioGroupModel());

      medicalManagementRadioGroup.setValues(new int[]{1,2});

      addMedicalManagementRadioGroup();
    }
    return medicalManagementRadioGroup;

  }

  /**
   * 重度療養管理加算コンテナを取得します。
   * @return 重度療養管理加算コンテナ
   */
  protected ACLabelContainer getMedicalManagementRadioGroupContainer(){
    if(medicalManagementRadioGroupContainer==null){
      medicalManagementRadioGroupContainer = new ACLabelContainer();
      medicalManagementRadioGroupContainer.setFollowChildEnabled(true);
      medicalManagementRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      medicalManagementRadioGroupContainer.add(getMedicalManagementRadioGroup(), null);
    }
    return medicalManagementRadioGroupContainer;
  }

  /**
   * 重度療養管理加算モデルを取得します。
   * @return 重度療養管理加算モデル
   */
  protected ACListModelAdapter getMedicalManagementRadioGroupModel(){
    if(medicalManagementRadioGroupModel==null){
      medicalManagementRadioGroupModel = new ACListModelAdapter();
      addMedicalManagementRadioGroupModel();
    }
    return medicalManagementRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalManagementRadioItem1(){
    if(medicalManagementRadioItem1==null){

      medicalManagementRadioItem1 = new ACRadioButtonItem();

      medicalManagementRadioItem1.setText("なし");

      medicalManagementRadioItem1.setGroup(getMedicalManagementRadioGroup());

      medicalManagementRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalManagementRadioItem1();
    }
    return medicalManagementRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMedicalManagementRadioItem2(){
    if(medicalManagementRadioItem2==null){

      medicalManagementRadioItem2 = new ACRadioButtonItem();

      medicalManagementRadioItem2.setText("あり");

      medicalManagementRadioItem2.setGroup(getMedicalManagementRadioGroup());

      medicalManagementRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalManagementRadioItem2();
    }
    return medicalManagementRadioItem2;

  }

  /**
   * 同一建物居住者へのサービス提供を取得します。
   * @return 同一建物居住者へのサービス提供
   */
  public ACValueArrayRadioButtonGroup getTransportationCallRadioGroup(){
    if(transportationCallRadioGroup==null){

      transportationCallRadioGroup = new ACValueArrayRadioButtonGroup();

      getTransportationCallRadioGroupContainer().setText("同一建物居住者へのサービス提供");

      transportationCallRadioGroup.setBindPath("16");

      transportationCallRadioGroup.setUseClearButton(false);

      transportationCallRadioGroup.setModel(getTransportationCallRadioGroupModel());

      transportationCallRadioGroup.setValues(new int[]{1,2});

      addTransportationCallRadioGroup();
    }
    return transportationCallRadioGroup;

  }

  /**
   * 同一建物居住者へのサービス提供コンテナを取得します。
   * @return 同一建物居住者へのサービス提供コンテナ
   */
  protected ACLabelContainer getTransportationCallRadioGroupContainer(){
    if(transportationCallRadioGroupContainer==null){
      transportationCallRadioGroupContainer = new ACLabelContainer();
      transportationCallRadioGroupContainer.setFollowChildEnabled(true);
      transportationCallRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      transportationCallRadioGroupContainer.add(getTransportationCallRadioGroup(), null);
    }
    return transportationCallRadioGroupContainer;
  }

  /**
   * 同一建物居住者へのサービス提供モデルを取得します。
   * @return 同一建物居住者へのサービス提供モデル
   */
  protected ACListModelAdapter getTransportationCallRadioGroupModel(){
    if(transportationCallRadioGroupModel==null){
      transportationCallRadioGroupModel = new ACListModelAdapter();
      addTransportationCallRadioGroupModel();
    }
    return transportationCallRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTransportationCallRadioItem1(){
    if(transportationCallRadioItem1==null){

      transportationCallRadioItem1 = new ACRadioButtonItem();

      transportationCallRadioItem1.setText("なし");

      transportationCallRadioItem1.setGroup(getTransportationCallRadioGroup());

      transportationCallRadioItem1.setConstraints(VRLayout.FLOW);

      addTransportationCallRadioItem1();
    }
    return transportationCallRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getTransportationCallRadioItem2(){
    if(transportationCallRadioItem2==null){

      transportationCallRadioItem2 = new ACRadioButtonItem();

      transportationCallRadioItem2.setText("あり");

      transportationCallRadioItem2.setGroup(getTransportationCallRadioGroup());

      transportationCallRadioItem2.setConstraints(VRLayout.FLOW);

      addTransportationCallRadioItem2();
    }
    return transportationCallRadioItem2;

  }

  /**
   * サービス提供体制強化加算を取得します。
   * @return サービス提供体制強化加算
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("サービス提供体制強化加算");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1160122");

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,4,2,3});

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
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem4(){
    if(serviceAddProvisionStructuralRadioItem4==null){

      serviceAddProvisionStructuralRadioItem4 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem4.setText("Iイ型");

      serviceAddProvisionStructuralRadioItem4.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addServiceAddProvisionStructuralRadioItem4();
    }
    return serviceAddProvisionStructuralRadioItem4;

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
   * 中山間地域等でのサービス提供加算を取得します。
   * @return 中山間地域等でのサービス提供加算
   */
  public ACValueArrayRadioButtonGroup getProviderAddMountainousAreaRadioGroup(){
    if(providerAddMountainousAreaRadioGroup==null){

      providerAddMountainousAreaRadioGroup = new ACValueArrayRadioButtonGroup();

      getProviderAddMountainousAreaRadioGroupContainer().setText("中山間地域等でのサービス提供加算");

      providerAddMountainousAreaRadioGroup.setBindPath("12");

      providerAddMountainousAreaRadioGroup.setNoSelectIndex(0);

      providerAddMountainousAreaRadioGroup.setUseClearButton(false);

      providerAddMountainousAreaRadioGroup.setModel(getProviderAddMountainousAreaRadioGroupModel());

      providerAddMountainousAreaRadioGroup.setValues(new int[]{1,2});

      addProviderAddMountainousAreaRadioGroup();
    }
    return providerAddMountainousAreaRadioGroup;

  }

  /**
   * 中山間地域等でのサービス提供加算コンテナを取得します。
   * @return 中山間地域等でのサービス提供加算コンテナ
   */
  protected ACLabelContainer getProviderAddMountainousAreaRadioGroupContainer(){
    if(providerAddMountainousAreaRadioGroupContainer==null){
      providerAddMountainousAreaRadioGroupContainer = new ACLabelContainer();
      providerAddMountainousAreaRadioGroupContainer.setFollowChildEnabled(true);
      providerAddMountainousAreaRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      providerAddMountainousAreaRadioGroupContainer.add(getProviderAddMountainousAreaRadioGroup(), null);
    }
    return providerAddMountainousAreaRadioGroupContainer;
  }

  /**
   * 中山間地域等でのサービス提供加算モデルを取得します。
   * @return 中山間地域等でのサービス提供加算モデル
   */
  protected ACListModelAdapter getProviderAddMountainousAreaRadioGroupModel(){
    if(providerAddMountainousAreaRadioGroupModel==null){
      providerAddMountainousAreaRadioGroupModel = new ACListModelAdapter();
      addProviderAddMountainousAreaRadioGroupModel();
    }
    return providerAddMountainousAreaRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getProviderAddMountainousAreaRadioItem1(){
    if(providerAddMountainousAreaRadioItem1==null){

      providerAddMountainousAreaRadioItem1 = new ACRadioButtonItem();

      providerAddMountainousAreaRadioItem1.setText("なし");

      providerAddMountainousAreaRadioItem1.setGroup(getProviderAddMountainousAreaRadioGroup());

      providerAddMountainousAreaRadioItem1.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaRadioItem1();
    }
    return providerAddMountainousAreaRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getProviderAddMountainousAreaRadioItem2(){
    if(providerAddMountainousAreaRadioItem2==null){

      providerAddMountainousAreaRadioItem2 = new ACRadioButtonItem();

      providerAddMountainousAreaRadioItem2.setText("あり");

      providerAddMountainousAreaRadioItem2.setGroup(getProviderAddMountainousAreaRadioGroup());

      providerAddMountainousAreaRadioItem2.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaRadioItem2();
    }
    return providerAddMountainousAreaRadioItem2;

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
   * 生活行為向上リハビリ実施加算を取得します。
   * @return 生活行為向上リハビリ実施加算
   */
  public ACValueArrayRadioButtonGroup getLifeActsImproveRehabilitationRadioGroup(){
    if(lifeActsImproveRehabilitationRadioGroup==null){

      lifeActsImproveRehabilitationRadioGroup = new ACValueArrayRadioButtonGroup();

      getLifeActsImproveRehabilitationRadioGroupContainer().setText("生活行為向上リハビリ実施加算");

      lifeActsImproveRehabilitationRadioGroup.setBindPath("1160124");

      lifeActsImproveRehabilitationRadioGroup.setUseClearButton(false);

      lifeActsImproveRehabilitationRadioGroup.setModel(getLifeActsImproveRehabilitationRadioGroupModel());

      lifeActsImproveRehabilitationRadioGroup.setValues(new int[]{1,2,3});

      addLifeActsImproveRehabilitationRadioGroup();
    }
    return lifeActsImproveRehabilitationRadioGroup;

  }

  /**
   * 生活行為向上リハビリ実施加算コンテナを取得します。
   * @return 生活行為向上リハビリ実施加算コンテナ
   */
  protected ACLabelContainer getLifeActsImproveRehabilitationRadioGroupContainer(){
    if(lifeActsImproveRehabilitationRadioGroupContainer==null){
      lifeActsImproveRehabilitationRadioGroupContainer = new ACLabelContainer();
      lifeActsImproveRehabilitationRadioGroupContainer.setFollowChildEnabled(true);
      lifeActsImproveRehabilitationRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      lifeActsImproveRehabilitationRadioGroupContainer.add(getLifeActsImproveRehabilitationRadioGroup(), null);
    }
    return lifeActsImproveRehabilitationRadioGroupContainer;
  }

  /**
   * 生活行為向上リハビリ実施加算モデルを取得します。
   * @return 生活行為向上リハビリ実施加算モデル
   */
  protected ACListModelAdapter getLifeActsImproveRehabilitationRadioGroupModel(){
    if(lifeActsImproveRehabilitationRadioGroupModel==null){
      lifeActsImproveRehabilitationRadioGroupModel = new ACListModelAdapter();
      addLifeActsImproveRehabilitationRadioGroupModel();
    }
    return lifeActsImproveRehabilitationRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getLifeActsImproveRehabilitationRadioItem1(){
    if(lifeActsImproveRehabilitationRadioItem1==null){

      lifeActsImproveRehabilitationRadioItem1 = new ACRadioButtonItem();

      lifeActsImproveRehabilitationRadioItem1.setText("なし");

      lifeActsImproveRehabilitationRadioItem1.setGroup(getLifeActsImproveRehabilitationRadioGroup());

      lifeActsImproveRehabilitationRadioItem1.setConstraints(VRLayout.FLOW);

      addLifeActsImproveRehabilitationRadioItem1();
    }
    return lifeActsImproveRehabilitationRadioItem1;

  }

  /**
   * 3月以内を取得します。
   * @return 3月以内
   */
  public ACRadioButtonItem getLifeActsImproveRehabilitationRadioItem2(){
    if(lifeActsImproveRehabilitationRadioItem2==null){

      lifeActsImproveRehabilitationRadioItem2 = new ACRadioButtonItem();

      lifeActsImproveRehabilitationRadioItem2.setText("3月以内");

      lifeActsImproveRehabilitationRadioItem2.setGroup(getLifeActsImproveRehabilitationRadioGroup());

      lifeActsImproveRehabilitationRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addLifeActsImproveRehabilitationRadioItem2();
    }
    return lifeActsImproveRehabilitationRadioItem2;

  }

  /**
   * 3月超6月以内を取得します。
   * @return 3月超6月以内
   */
  public ACRadioButtonItem getLifeActsImproveRehabilitationRadioItem3(){
    if(lifeActsImproveRehabilitationRadioItem3==null){

      lifeActsImproveRehabilitationRadioItem3 = new ACRadioButtonItem();

      lifeActsImproveRehabilitationRadioItem3.setText("3月超6月以内");

      lifeActsImproveRehabilitationRadioItem3.setGroup(getLifeActsImproveRehabilitationRadioGroup());

      lifeActsImproveRehabilitationRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addLifeActsImproveRehabilitationRadioItem3();
    }
    return lifeActsImproveRehabilitationRadioItem3;

  }

  /**
   * 生活行為向上リハビリテーション後の継続減算を取得します。
   * @return 生活行為向上リハビリテーション後の継続減算
   */
  public ACValueArrayRadioButtonGroup getLifeActsImproveRehaSubtractionRadioGroup(){
    if(lifeActsImproveRehaSubtractionRadioGroup==null){

      lifeActsImproveRehaSubtractionRadioGroup = new ACValueArrayRadioButtonGroup();

      getLifeActsImproveRehaSubtractionRadioGroupContainer().setText("生活行為向上リハビリ後の継続減算");

      lifeActsImproveRehaSubtractionRadioGroup.setBindPath("1160127");

      lifeActsImproveRehaSubtractionRadioGroup.setVisible(true);

      lifeActsImproveRehaSubtractionRadioGroup.setEnabled(true);

      lifeActsImproveRehaSubtractionRadioGroup.setNoSelectIndex(0);

      lifeActsImproveRehaSubtractionRadioGroup.setUseClearButton(false);

      lifeActsImproveRehaSubtractionRadioGroup.setModel(getLifeActsImproveRehaSubtractionRadioGroupModel());

      lifeActsImproveRehaSubtractionRadioGroup.setValues(new int[]{1,2});

      addLifeActsImproveRehaSubtractionRadioGroup();
    }
    return lifeActsImproveRehaSubtractionRadioGroup;

  }

  /**
   * 生活行為向上リハビリテーション後の継続減算コンテナを取得します。
   * @return 生活行為向上リハビリテーション後の継続減算コンテナ
   */
  protected ACLabelContainer getLifeActsImproveRehaSubtractionRadioGroupContainer(){
    if(lifeActsImproveRehaSubtractionRadioGroupContainer==null){
      lifeActsImproveRehaSubtractionRadioGroupContainer = new ACLabelContainer();
      lifeActsImproveRehaSubtractionRadioGroupContainer.setFollowChildEnabled(true);
      lifeActsImproveRehaSubtractionRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      lifeActsImproveRehaSubtractionRadioGroupContainer.add(getLifeActsImproveRehaSubtractionRadioGroup(), null);
    }
    return lifeActsImproveRehaSubtractionRadioGroupContainer;
  }

  /**
   * 生活行為向上リハビリテーション後の継続減算モデルを取得します。
   * @return 生活行為向上リハビリテーション後の継続減算モデル
   */
  protected ACListModelAdapter getLifeActsImproveRehaSubtractionRadioGroupModel(){
    if(lifeActsImproveRehaSubtractionRadioGroupModel==null){
      lifeActsImproveRehaSubtractionRadioGroupModel = new ACListModelAdapter();
      addLifeActsImproveRehaSubtractionRadioGroupModel();
    }
    return lifeActsImproveRehaSubtractionRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getLifeActsImproveRehaSubtractionRadioItem1(){
    if(lifeActsImproveRehaSubtractionRadioItem1==null){

      lifeActsImproveRehaSubtractionRadioItem1 = new ACRadioButtonItem();

      lifeActsImproveRehaSubtractionRadioItem1.setText("なし");

      lifeActsImproveRehaSubtractionRadioItem1.setGroup(getLifeActsImproveRehaSubtractionRadioGroup());

      lifeActsImproveRehaSubtractionRadioItem1.setConstraints(VRLayout.FLOW);

      addLifeActsImproveRehaSubtractionRadioItem1();
    }
    return lifeActsImproveRehaSubtractionRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getLifeActsImproveRehaSubtractionRadioItem2(){
    if(lifeActsImproveRehaSubtractionRadioItem2==null){

      lifeActsImproveRehaSubtractionRadioItem2 = new ACRadioButtonItem();

      lifeActsImproveRehaSubtractionRadioItem2.setText("あり");

      lifeActsImproveRehaSubtractionRadioItem2.setGroup(getLifeActsImproveRehaSubtractionRadioGroup());

      lifeActsImproveRehaSubtractionRadioItem2.setConstraints(VRLayout.FLOW);

      addLifeActsImproveRehaSubtractionRadioItem2();
    }
    return lifeActsImproveRehaSubtractionRadioItem2;

  }

  /**
   * 中重度者ケア体制加算を取得します。
   * @return 中重度者ケア体制加算
   */
  public ACValueArrayRadioButtonGroup getSevereCareRecipientsAccepted(){
    if(severeCareRecipientsAccepted==null){

      severeCareRecipientsAccepted = new ACValueArrayRadioButtonGroup();

      getSevereCareRecipientsAcceptedContainer().setText("中重度者ケア体制加算");

      severeCareRecipientsAccepted.setBindPath("1160125");

      severeCareRecipientsAccepted.setUseClearButton(false);

      severeCareRecipientsAccepted.setModel(getSevereCareRecipientsAcceptedModel());

      severeCareRecipientsAccepted.setValues(new int[]{1,2});

      addSevereCareRecipientsAccepted();
    }
    return severeCareRecipientsAccepted;

  }

  /**
   * 中重度者ケア体制加算コンテナを取得します。
   * @return 中重度者ケア体制加算コンテナ
   */
  protected ACLabelContainer getSevereCareRecipientsAcceptedContainer(){
    if(severeCareRecipientsAcceptedContainer==null){
      severeCareRecipientsAcceptedContainer = new ACLabelContainer();
      severeCareRecipientsAcceptedContainer.setFollowChildEnabled(true);
      severeCareRecipientsAcceptedContainer.setVAlignment(VRLayout.CENTER);
      severeCareRecipientsAcceptedContainer.add(getSevereCareRecipientsAccepted(), null);
    }
    return severeCareRecipientsAcceptedContainer;
  }

  /**
   * 中重度者ケア体制加算モデルを取得します。
   * @return 中重度者ケア体制加算モデル
   */
  protected ACListModelAdapter getSevereCareRecipientsAcceptedModel(){
    if(severeCareRecipientsAcceptedModel==null){
      severeCareRecipientsAcceptedModel = new ACListModelAdapter();
      addSevereCareRecipientsAcceptedModel();
    }
    return severeCareRecipientsAcceptedModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getSevereCareRecipientsAcceptedItem1(){
    if(severeCareRecipientsAcceptedItem1==null){

      severeCareRecipientsAcceptedItem1 = new ACRadioButtonItem();

      severeCareRecipientsAcceptedItem1.setText("なし");

      severeCareRecipientsAcceptedItem1.setGroup(getSevereCareRecipientsAccepted());

      severeCareRecipientsAcceptedItem1.setConstraints(VRLayout.FLOW);

      addSevereCareRecipientsAcceptedItem1();
    }
    return severeCareRecipientsAcceptedItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getSevereCareRecipientsAcceptedItem2(){
    if(severeCareRecipientsAcceptedItem2==null){

      severeCareRecipientsAcceptedItem2 = new ACRadioButtonItem();

      severeCareRecipientsAcceptedItem2.setText("あり");

      severeCareRecipientsAcceptedItem2.setGroup(getSevereCareRecipientsAccepted());

      severeCareRecipientsAcceptedItem2.setConstraints(VRLayout.FLOW);

      addSevereCareRecipientsAcceptedItem2();
    }
    return severeCareRecipientsAcceptedItem2;

  }

  /**
   * 送迎区分を取得します。
   * @return 送迎区分
   */
  public ACValueArrayRadioButtonGroup getMeetingAndSendingOff(){
    if(MeetingAndSendingOff==null){

      MeetingAndSendingOff = new ACValueArrayRadioButtonGroup();

      getMeetingAndSendingOffContainer().setText("送迎減算");

      MeetingAndSendingOff.setBindPath("18");

      MeetingAndSendingOff.setUseClearButton(false);

      MeetingAndSendingOff.setModel(getMeetingAndSendingOffModel());

      MeetingAndSendingOff.setValues(new int[]{1,2,3});

      addMeetingAndSendingOff();
    }
    return MeetingAndSendingOff;

  }

  /**
   * 送迎区分コンテナを取得します。
   * @return 送迎区分コンテナ
   */
  protected ACLabelContainer getMeetingAndSendingOffContainer(){
    if(MeetingAndSendingOffContainer==null){
      MeetingAndSendingOffContainer = new ACLabelContainer();
      MeetingAndSendingOffContainer.setFollowChildEnabled(true);
      MeetingAndSendingOffContainer.setVAlignment(VRLayout.CENTER);
      MeetingAndSendingOffContainer.add(getMeetingAndSendingOff(), null);
    }
    return MeetingAndSendingOffContainer;
  }

  /**
   * 送迎区分モデルを取得します。
   * @return 送迎区分モデル
   */
  protected ACListModelAdapter getMeetingAndSendingOffModel(){
    if(MeetingAndSendingOffModel==null){
      MeetingAndSendingOffModel = new ACListModelAdapter();
      addMeetingAndSendingOffModel();
    }
    return MeetingAndSendingOffModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMeetingAndSendingOffRoundTrip(){
    if(MeetingAndSendingOffRoundTrip==null){

      MeetingAndSendingOffRoundTrip = new ACRadioButtonItem();

      MeetingAndSendingOffRoundTrip.setText("なし");

      MeetingAndSendingOffRoundTrip.setGroup(getMeetingAndSendingOff());

      MeetingAndSendingOffRoundTrip.setConstraints(VRLayout.FLOW);

      addMeetingAndSendingOffRoundTrip();
    }
    return MeetingAndSendingOffRoundTrip;

  }

  /**
   * 片道減算を取得します。
   * @return 片道減算
   */
  public ACRadioButtonItem getMeetingAndSendingOffOneWay(){
    if(MeetingAndSendingOffOneWay==null){

      MeetingAndSendingOffOneWay = new ACRadioButtonItem();

      MeetingAndSendingOffOneWay.setText("片道減算");

      MeetingAndSendingOffOneWay.setGroup(getMeetingAndSendingOff());

      MeetingAndSendingOffOneWay.setConstraints(VRLayout.FLOW);

      addMeetingAndSendingOffOneWay();
    }
    return MeetingAndSendingOffOneWay;

  }

  /**
   * 往復減算を取得します。
   * @return 往復減算
   */
  public ACRadioButtonItem getMeetingAndSendingOffNone(){
    if(MeetingAndSendingOffNone==null){

      MeetingAndSendingOffNone = new ACRadioButtonItem();

      MeetingAndSendingOffNone.setText("往復減算");

      MeetingAndSendingOffNone.setGroup(getMeetingAndSendingOff());

      MeetingAndSendingOffNone.setConstraints(VRLayout.FLOW);

      addMeetingAndSendingOffNone();
    }
    return MeetingAndSendingOffNone;

  }

  /**
   * 社会参加支援加算を取得します。
   * @return 社会参加支援加算
   */
  public ACValueArrayRadioButtonGroup getRegionalServiceRadioGroup(){
    if(regionalServiceRadioGroup==null){

      regionalServiceRadioGroup = new ACValueArrayRadioButtonGroup();

      getRegionalServiceRadioGroupContainer().setText("社会参加支援加算");

      regionalServiceRadioGroup.setBindPath("1160126");

      regionalServiceRadioGroup.setVisible(true);

      regionalServiceRadioGroup.setEnabled(true);

      regionalServiceRadioGroup.setNoSelectIndex(0);

      regionalServiceRadioGroup.setUseClearButton(false);

      regionalServiceRadioGroup.setModel(getRegionalServiceRadioGroupModel());

      regionalServiceRadioGroup.setValues(new int[]{1,2});

      addRegionalServiceRadioGroup();
    }
    return regionalServiceRadioGroup;

  }

  /**
   * 社会参加支援加算コンテナを取得します。
   * @return 社会参加支援加算コンテナ
   */
  protected ACLabelContainer getRegionalServiceRadioGroupContainer(){
    if(regionalServiceRadioGroupContainer==null){
      regionalServiceRadioGroupContainer = new ACLabelContainer();
      regionalServiceRadioGroupContainer.setFollowChildEnabled(true);
      regionalServiceRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      regionalServiceRadioGroupContainer.add(getRegionalServiceRadioGroup(), null);
    }
    return regionalServiceRadioGroupContainer;
  }

  /**
   * 社会参加支援加算モデルを取得します。
   * @return 社会参加支援加算モデル
   */
  protected ACListModelAdapter getRegionalServiceRadioGroupModel(){
    if(regionalServiceRadioGroupModel==null){
      regionalServiceRadioGroupModel = new ACListModelAdapter();
      addRegionalServiceRadioGroupModel();
    }
    return regionalServiceRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getRegionalServiceRadioItem1(){
    if(regionalServiceRadioItem1==null){

      regionalServiceRadioItem1 = new ACRadioButtonItem();

      regionalServiceRadioItem1.setText("なし");

      regionalServiceRadioItem1.setGroup(getRegionalServiceRadioGroup());

      regionalServiceRadioItem1.setConstraints(VRLayout.FLOW);

      addRegionalServiceRadioItem1();
    }
    return regionalServiceRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getRegionalServiceRadioItem2(){
    if(regionalServiceRadioItem2==null){

      regionalServiceRadioItem2 = new ACRadioButtonItem();

      regionalServiceRadioItem2.setText("あり");

      regionalServiceRadioItem2.setGroup(getRegionalServiceRadioGroup());

      regionalServiceRadioItem2.setConstraints(VRLayout.FLOW);

      addRegionalServiceRadioItem2();
    }
    return regionalServiceRadioItem2;

  }

  /**
   * リハビリテーション提供体制加算を取得します。
   * @return リハビリテーション提供体制加算
   */
  public ACValueArrayRadioButtonGroup getRehabilitationSystem(){
    if(rehabilitationSystem==null){

      rehabilitationSystem = new ACValueArrayRadioButtonGroup();

      getRehabilitationSystemContainer().setText("リハビリテーション提供体制加算");

      rehabilitationSystem.setBindPath("1160128");

      rehabilitationSystem.setNoSelectIndex(0);

      rehabilitationSystem.setUseClearButton(false);

      rehabilitationSystem.setModel(getRehabilitationSystemModel());

      rehabilitationSystem.setValues(new int[]{1,2});

      addRehabilitationSystem();
    }
    return rehabilitationSystem;

  }

  /**
   * リハビリテーション提供体制加算コンテナを取得します。
   * @return リハビリテーション提供体制加算コンテナ
   */
  protected ACLabelContainer getRehabilitationSystemContainer(){
    if(rehabilitationSystemContainer==null){
      rehabilitationSystemContainer = new ACLabelContainer();
      rehabilitationSystemContainer.setFollowChildEnabled(true);
      rehabilitationSystemContainer.setVAlignment(VRLayout.CENTER);
      rehabilitationSystemContainer.add(getRehabilitationSystem(), null);
    }
    return rehabilitationSystemContainer;
  }

  /**
   * リハビリテーション提供体制加算モデルを取得します。
   * @return リハビリテーション提供体制加算モデル
   */
  protected ACListModelAdapter getRehabilitationSystemModel(){
    if(rehabilitationSystemModel==null){
      rehabilitationSystemModel = new ACListModelAdapter();
      addRehabilitationSystemModel();
    }
    return rehabilitationSystemModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getRehabilitationSystemItem1(){
    if(rehabilitationSystemItem1==null){

      rehabilitationSystemItem1 = new ACRadioButtonItem();

      rehabilitationSystemItem1.setText("なし");

      rehabilitationSystemItem1.setGroup(getRehabilitationSystem());

      rehabilitationSystemItem1.setConstraints(VRLayout.FLOW);

      addRehabilitationSystemItem1();
    }
    return rehabilitationSystemItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getRehabilitationSystemItem2(){
    if(rehabilitationSystemItem2==null){

      rehabilitationSystemItem2 = new ACRadioButtonItem();

      rehabilitationSystemItem2.setText("あり");

      rehabilitationSystemItem2.setGroup(getRehabilitationSystem());

      rehabilitationSystemItem2.setConstraints(VRLayout.FLOW);

      addRehabilitationSystemItem2();
    }
    return rehabilitationSystemItem2;

  }

  /**
   * 栄養スクリーニング加算を取得します。
   * @return 栄養スクリーニング加算
   */
  public ACValueArrayRadioButtonGroup getNutritionScreening(){
    if(nutritionScreening==null){

      nutritionScreening = new ACValueArrayRadioButtonGroup();

      getNutritionScreeningContainer().setText("栄養スクリーニング加算");

      nutritionScreening.setBindPath("1160129");

      nutritionScreening.setUseClearButton(false);

      nutritionScreening.setModel(getNutritionScreeningModel());

      nutritionScreening.setValues(new int[]{1,2});

      addNutritionScreening();
    }
    return nutritionScreening;

  }

  /**
   * 栄養スクリーニング加算コンテナを取得します。
   * @return 栄養スクリーニング加算コンテナ
   */
  protected ACLabelContainer getNutritionScreeningContainer(){
    if(nutritionScreeningContainer==null){
      nutritionScreeningContainer = new ACLabelContainer();
      nutritionScreeningContainer.setFollowChildEnabled(true);
      nutritionScreeningContainer.setVAlignment(VRLayout.CENTER);
      nutritionScreeningContainer.add(getNutritionScreening(), null);
    }
    return nutritionScreeningContainer;
  }

  /**
   * 栄養スクリーニング加算モデルを取得します。
   * @return 栄養スクリーニング加算モデル
   */
  protected ACListModelAdapter getNutritionScreeningModel(){
    if(nutritionScreeningModel==null){
      nutritionScreeningModel = new ACListModelAdapter();
      addNutritionScreeningModel();
    }
    return nutritionScreeningModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getNutritionScreeningItem1(){
    if(nutritionScreeningItem1==null){

      nutritionScreeningItem1 = new ACRadioButtonItem();

      nutritionScreeningItem1.setText("なし");

      nutritionScreeningItem1.setGroup(getNutritionScreening());

      addNutritionScreeningItem1();
    }
    return nutritionScreeningItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getNutritionScreeningItem2(){
    if(nutritionScreeningItem2==null){

      nutritionScreeningItem2 = new ACRadioButtonItem();

      nutritionScreeningItem2.setText("あり");

      nutritionScreeningItem2.setGroup(getNutritionScreening());

      addNutritionScreeningItem2();
    }
    return nutritionScreeningItem2;

  }

  /**
   * 算定区分を取得します。
   * @return 算定区分
   */
  public ACValueArrayRadioButtonGroup getCalculationDivision(){
    if(calculationDivision==null){

      calculationDivision = new ACValueArrayRadioButtonGroup();

      getCalculationDivisionContainer().setText("算定区分");

      calculationDivision.setBindPath("9");

      calculationDivision.setUseClearButton(false);

      calculationDivision.setModel(getCalculationDivisionModel());

      calculationDivision.setValues(new int[]{1,2});

      addCalculationDivision();
    }
    return calculationDivision;

  }

  /**
   * 算定区分コンテナを取得します。
   * @return 算定区分コンテナ
   */
  protected ACLabelContainer getCalculationDivisionContainer(){
    if(calculationDivisionContainer==null){
      calculationDivisionContainer = new ACLabelContainer();
      calculationDivisionContainer.setFollowChildEnabled(true);
      calculationDivisionContainer.setVAlignment(VRLayout.CENTER);
      calculationDivisionContainer.add(getCalculationDivision(), null);
    }
    return calculationDivisionContainer;
  }

  /**
   * 算定区分モデルを取得します。
   * @return 算定区分モデル
   */
  protected ACListModelAdapter getCalculationDivisionModel(){
    if(calculationDivisionModel==null){
      calculationDivisionModel = new ACListModelAdapter();
      addCalculationDivisionModel();
    }
    return calculationDivisionModel;
  }

  /**
   * 通常を取得します。
   * @return 通常
   */
  public ACRadioButtonItem getCalculationDivisionNormal(){
    if(calculationDivisionNormal==null){

      calculationDivisionNormal = new ACRadioButtonItem();

      calculationDivisionNormal.setText("通常");

      calculationDivisionNormal.setGroup(getCalculationDivision());

      calculationDivisionNormal.setConstraints(VRLayout.FLOW);

      addCalculationDivisionNormal();
    }
    return calculationDivisionNormal;

  }

  /**
   * 加算のみを取得します。
   * @return 加算のみ
   */
  public ACRadioButtonItem getCalculationDivisionAddOnly(){
    if(calculationDivisionAddOnly==null){

      calculationDivisionAddOnly = new ACRadioButtonItem();

      calculationDivisionAddOnly.setText("加算のみ");

      calculationDivisionAddOnly.setGroup(getCalculationDivision());

      calculationDivisionAddOnly.setConstraints(VRLayout.FLOW);

      addCalculationDivisionAddOnly();
    }
    return calculationDivisionAddOnly;

  }

  /**
   * コンストラクタです。
   */
  public QS001_11611_201804Design() {

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

    tab1.add(getFacilityDivisionRadioGroupContainer(), VRLayout.FLOW_INSETLINE);

    tab1.add(getHoumonRehabilitationTimeDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonRehabilitationTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * 施設等の区分に内部項目を追加します。
   */
  protected void addFacilityDivisionRadioGroup(){

  }

  /**
   * 施設等の区分モデルに内部項目を追加します。
   */
  protected void addFacilityDivisionRadioGroupModel(){

    getFacilityDivisionRadioItem1().setButtonIndex(1);

    getFacilityDivisionRadioGroupModel().add(getFacilityDivisionRadioItem1());

    getFacilityDivisionRadioItem2().setButtonIndex(2);

    getFacilityDivisionRadioGroupModel().add(getFacilityDivisionRadioItem2());

    getFacilityDivisionRadioItem3().setButtonIndex(7);

    getFacilityDivisionRadioGroupModel().add(getFacilityDivisionRadioItem3());

    getFacilityDivisionRadioItem4().setButtonIndex(3);

    getFacilityDivisionRadioGroupModel().add(getFacilityDivisionRadioItem4());

    getFacilityDivisionRadioItem5().setButtonIndex(4);

    getFacilityDivisionRadioGroupModel().add(getFacilityDivisionRadioItem5());

    getFacilityDivisionRadioItem6().setButtonIndex(8);

    getFacilityDivisionRadioGroupModel().add(getFacilityDivisionRadioItem6());

    getFacilityDivisionRadioItem7().setButtonIndex(5);

    getFacilityDivisionRadioGroupModel().add(getFacilityDivisionRadioItem7());

    getFacilityDivisionRadioItem8().setButtonIndex(6);

    getFacilityDivisionRadioGroupModel().add(getFacilityDivisionRadioItem8());

    getFacilityDivisionRadioItem9().setButtonIndex(9);

    getFacilityDivisionRadioGroupModel().add(getFacilityDivisionRadioItem9());

  }

  /**
   * 通常規模（病院・診療所）に内部項目を追加します。
   */
  protected void addFacilityDivisionRadioItem1(){

  }

  /**
   * 通常規模（老健施設）に内部項目を追加します。
   */
  protected void addFacilityDivisionRadioItem2(){

  }

  /**
   * 通常規模（介護医療院）に内部項目を追加します。
   */
  protected void addFacilityDivisionRadioItem3(){

  }

  /**
   * 大規模（I）（病院・診療所）に内部項目を追加します。
   */
  protected void addFacilityDivisionRadioItem4(){

  }

  /**
   * 大規模（I）（老健施設）に内部項目を追加します。
   */
  protected void addFacilityDivisionRadioItem5(){

  }

  /**
   * 大規模（I）（介護医療院）に内部項目を追加します。
   */
  protected void addFacilityDivisionRadioItem6(){

  }

  /**
   * 大規模（II）（病院・診療所）に内部項目を追加します。
   */
  protected void addFacilityDivisionRadioItem7(){

  }

  /**
   * 大規模（II）（老健施設）に内部項目を追加します。
   */
  protected void addFacilityDivisionRadioItem8(){

  }

  /**
   * 大規模（II）（介護医療院）に内部項目を追加します。
   */
  protected void addFacilityDivisionRadioItem9(){

  }

  /**
   * 時間区分に内部項目を追加します。
   */
  protected void addHoumonRehabilitationTimeDivision(){

  }

  /**
   * 時間区分モデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationTimeDivisionModel(){

  }

  /**
   * 提供時間コンテナに内部項目を追加します。
   */
  protected void addHoumonRehabilitationTimeContena(){

    houmonRehabilitationTimeContena.add(getHoumonRehabilitationTimeContenaBeginTimeContainer(), VRLayout.FLOW);

    houmonRehabilitationTimeContena.add(getHoumonRehabilitationTimeContenaEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * 開始時刻コンボに内部項目を追加します。
   */
  protected void addHoumonRehabilitationTimeContenaBeginTime(){

  }

  /**
   * 開始時刻コンボモデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationTimeContenaBeginTimeModel(){

  }

  /**
   * 終了時刻コンボに内部項目を追加します。
   */
  protected void addHoumonRehabilitationTimeContenaEndTime(){

  }

  /**
   * 終了時刻コンボモデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationTimeContenaEndTimeModel(){

  }

  /**
   * タブ2に内部項目を追加します。
   */
  protected void addTab2(){

    tab2.add(getHoumonRehabilitationSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHoumonRehabilitationBathRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHoumonRehabilitationManagementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHoumonRehabilitationShortConcentrationAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getPhysiotherapistStrengthenedAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 人員減算に内部項目を追加します。
   */
  protected void addHoumonRehabilitationSubtraction(){

  }

  /**
   * 人員減算モデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationSubtractionModel(){

    getHoumonRehabilitationSubtractionNot().setButtonIndex(1);

    getHoumonRehabilitationSubtractionModel().add(getHoumonRehabilitationSubtractionNot());

    getHoumonRehabilitationSubtractionExcess().setButtonIndex(2);

    getHoumonRehabilitationSubtractionModel().add(getHoumonRehabilitationSubtractionExcess());

    getHoumonRehabilitationSubtractionLack().setButtonIndex(3);

    getHoumonRehabilitationSubtractionModel().add(getHoumonRehabilitationSubtractionLack());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonRehabilitationSubtractionNot(){

  }

  /**
   * 定員超過に内部項目を追加します。
   */
  protected void addHoumonRehabilitationSubtractionExcess(){

  }

  /**
   * 医師、PT・OT・ST、看護・介護職員の不足に内部項目を追加します。
   */
  protected void addHoumonRehabilitationSubtractionLack(){

  }

  /**
   * 入浴加算に内部項目を追加します。
   */
  protected void addHoumonRehabilitationBathRadio(){

  }

  /**
   * 入浴加算モデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationBathRadioModel(){

    getHoumonRehabilitationBathRadioItem1().setButtonIndex(1);

    getHoumonRehabilitationBathRadioModel().add(getHoumonRehabilitationBathRadioItem1());

    getHoumonRehabilitationBathRadioItem2().setButtonIndex(2);

    getHoumonRehabilitationBathRadioModel().add(getHoumonRehabilitationBathRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonRehabilitationBathRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHoumonRehabilitationBathRadioItem2(){

  }

  /**
   * リハビリテーションマネジメント加算に内部項目を追加します。
   */
  protected void addHoumonRehabilitationManagementAddRadio(){

  }

  /**
   * リハビリテーションマネジメント加算モデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationManagementAddRadioModel(){

    getHoumonRehabilitationManagementAddRadioItem1().setButtonIndex(1);

    getHoumonRehabilitationManagementAddRadioModel().add(getHoumonRehabilitationManagementAddRadioItem1());

    getHoumonRehabilitationManagementAddRadioItem2().setButtonIndex(2);

    getHoumonRehabilitationManagementAddRadioModel().add(getHoumonRehabilitationManagementAddRadioItem2());

    getHoumonRehabilitationManagementAddRadioItem3().setButtonIndex(3);

    getHoumonRehabilitationManagementAddRadioModel().add(getHoumonRehabilitationManagementAddRadioItem3());

    getHoumonRehabilitationManagementAddRadioItem4().setButtonIndex(4);

    getHoumonRehabilitationManagementAddRadioModel().add(getHoumonRehabilitationManagementAddRadioItem4());

    getHoumonRehabilitationManagementAddRadioItem5().setButtonIndex(5);

    getHoumonRehabilitationManagementAddRadioModel().add(getHoumonRehabilitationManagementAddRadioItem5());

    getHoumonRehabilitationManagementAddRadioItem6().setButtonIndex(6);

    getHoumonRehabilitationManagementAddRadioModel().add(getHoumonRehabilitationManagementAddRadioItem6());

    getHoumonRehabilitationManagementAddRadioItem7().setButtonIndex(7);

    getHoumonRehabilitationManagementAddRadioModel().add(getHoumonRehabilitationManagementAddRadioItem7());

    getHoumonRehabilitationManagementAddRadioItem8().setButtonIndex(8);

    getHoumonRehabilitationManagementAddRadioModel().add(getHoumonRehabilitationManagementAddRadioItem8());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonRehabilitationManagementAddRadioItem1(){

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addHoumonRehabilitationManagementAddRadioItem2(){

  }

  /**
   * II型(6月以内)に内部項目を追加します。
   */
  protected void addHoumonRehabilitationManagementAddRadioItem3(){

  }

  /**
   * II型(6月超)に内部項目を追加します。
   */
  protected void addHoumonRehabilitationManagementAddRadioItem4(){

  }

  /**
   * III型(6月以内)に内部項目を追加します。
   */
  protected void addHoumonRehabilitationManagementAddRadioItem5(){

  }

  /**
   * III型(6月超)に内部項目を追加します。
   */
  protected void addHoumonRehabilitationManagementAddRadioItem6(){

  }

  /**
   * IV型(6月以内)に内部項目を追加します。
   */
  protected void addHoumonRehabilitationManagementAddRadioItem7(){

  }

  /**
   * IV型(6月超)に内部項目を追加します。
   */
  protected void addHoumonRehabilitationManagementAddRadioItem8(){

  }

  /**
   * 短期集中個別リハビリ実施加算に内部項目を追加します。
   */
  protected void addHoumonRehabilitationShortConcentrationAddRadio(){

  }

  /**
   * 短期集中個別リハビリ実施加算モデルに内部項目を追加します。
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
   * 理学療法士等体制強化加算に内部項目を追加します。
   */
  protected void addPhysiotherapistStrengthenedAddRadioGroup(){

  }

  /**
   * 理学療法士等体制強化加算モデルに内部項目を追加します。
   */
  protected void addPhysiotherapistStrengthenedAddRadioGroupModel(){

    getPhysiotherapistStrengthenedAddRadioItem1().setButtonIndex(1);

    getPhysiotherapistStrengthenedAddRadioGroupModel().add(getPhysiotherapistStrengthenedAddRadioItem1());

    getPhysiotherapistStrengthenedAddRadioItem2().setButtonIndex(2);

    getPhysiotherapistStrengthenedAddRadioGroupModel().add(getPhysiotherapistStrengthenedAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addPhysiotherapistStrengthenedAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addPhysiotherapistStrengthenedAddRadioItem2(){

  }

  /**
   * タブ3に内部項目を追加します。
   */
  protected void addTab3(){

    tab3.add(getDementiaRehabilitationShortConcentrationAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getHoumonRehabilitationNourishmentManagementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getHoumonRehabilitationMouthFunctionAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getMedicalManagementRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getTransportationCallRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getProviderAddMountainousAreaRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 認知症短期集中リハビリ実施加算に内部項目を追加します。
   */
  protected void addDementiaRehabilitationShortConcentrationAddRadio(){

  }

  /**
   * 認知症短期集中リハビリ実施加算モデルに内部項目を追加します。
   */
  protected void addDementiaRehabilitationShortConcentrationAddRadioModel(){

    getDementiaRehabilitationShortConcentrationAddRadioItem1().setButtonIndex(1);

    getDementiaRehabilitationShortConcentrationAddRadioModel().add(getDementiaRehabilitationShortConcentrationAddRadioItem1());

    getDementiaRehabilitationShortConcentrationAddRadioItem2().setButtonIndex(2);

    getDementiaRehabilitationShortConcentrationAddRadioModel().add(getDementiaRehabilitationShortConcentrationAddRadioItem2());

    getDementiaRehabilitationShortConcentrationAddRadioItem3().setButtonIndex(3);

    getDementiaRehabilitationShortConcentrationAddRadioModel().add(getDementiaRehabilitationShortConcentrationAddRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addDementiaRehabilitationShortConcentrationAddRadioItem1(){

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addDementiaRehabilitationShortConcentrationAddRadioItem2(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addDementiaRehabilitationShortConcentrationAddRadioItem3(){

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
   * 栄養改善加算に内部項目を追加します。
   */
  protected void addHoumonRehabilitationNourishmentManagementAddRadio(){

  }

  /**
   * 栄養改善加算モデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationNourishmentManagementAddRadioModel(){

    getHoumonRehabilitationNourishmentManagementAddRadioItem1().setButtonIndex(1);

    getHoumonRehabilitationNourishmentManagementAddRadioModel().add(getHoumonRehabilitationNourishmentManagementAddRadioItem1());

    getHoumonRehabilitationNourishmentManagementAddRadioItem2().setButtonIndex(2);

    getHoumonRehabilitationNourishmentManagementAddRadioModel().add(getHoumonRehabilitationNourishmentManagementAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonRehabilitationNourishmentManagementAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHoumonRehabilitationNourishmentManagementAddRadioItem2(){

  }

  /**
   * 口腔機能向上加算に内部項目を追加します。
   */
  protected void addHoumonRehabilitationMouthFunctionAddRadio(){

  }

  /**
   * 口腔機能向上加算モデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationMouthFunctionAddRadioModel(){

    getHoumonRehabilitationMouthFunctionAddRadioItem1().setButtonIndex(1);

    getHoumonRehabilitationMouthFunctionAddRadioModel().add(getHoumonRehabilitationMouthFunctionAddRadioItem1());

    getHoumonRehabilitationMouthFunctionAddRadioItem2().setButtonIndex(2);

    getHoumonRehabilitationMouthFunctionAddRadioModel().add(getHoumonRehabilitationMouthFunctionAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonRehabilitationMouthFunctionAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHoumonRehabilitationMouthFunctionAddRadioItem2(){

  }

  /**
   * 重度療養管理加算に内部項目を追加します。
   */
  protected void addMedicalManagementRadioGroup(){

  }

  /**
   * 重度療養管理加算モデルに内部項目を追加します。
   */
  protected void addMedicalManagementRadioGroupModel(){

    getMedicalManagementRadioItem1().setButtonIndex(1);

    getMedicalManagementRadioGroupModel().add(getMedicalManagementRadioItem1());

    getMedicalManagementRadioItem2().setButtonIndex(2);

    getMedicalManagementRadioGroupModel().add(getMedicalManagementRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalManagementRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMedicalManagementRadioItem2(){

  }

  /**
   * 同一建物居住者へのサービス提供に内部項目を追加します。
   */
  protected void addTransportationCallRadioGroup(){

  }

  /**
   * 同一建物居住者へのサービス提供モデルに内部項目を追加します。
   */
  protected void addTransportationCallRadioGroupModel(){

    getTransportationCallRadioItem1().setButtonIndex(1);

    getTransportationCallRadioGroupModel().add(getTransportationCallRadioItem1());

    getTransportationCallRadioItem2().setButtonIndex(2);

    getTransportationCallRadioGroupModel().add(getTransportationCallRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTransportationCallRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addTransportationCallRadioItem2(){

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

    getServiceAddProvisionStructuralRadioItem4().setButtonIndex(4);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem4());

    getServiceAddProvisionStructuralRadioItem2().setButtonIndex(2);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem2());

    getServiceAddProvisionStructuralRadioItem3().setButtonIndex(3);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem1(){

  }

  /**
   * Iイ型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem4(){

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
   * 中山間地域等でのサービス提供加算に内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaRadioGroup(){

  }

  /**
   * 中山間地域等でのサービス提供加算モデルに内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaRadioGroupModel(){

    getProviderAddMountainousAreaRadioItem1().setButtonIndex(1);

    getProviderAddMountainousAreaRadioGroupModel().add(getProviderAddMountainousAreaRadioItem1());

    getProviderAddMountainousAreaRadioItem2().setButtonIndex(2);

    getProviderAddMountainousAreaRadioGroupModel().add(getProviderAddMountainousAreaRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaRadioItem2(){

  }

  /**
   * タブ4に内部項目を追加します。
   */
  protected void addTab4(){

    tab4.add(getLifeActsImproveRehabilitationRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getLifeActsImproveRehaSubtractionRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getSevereCareRecipientsAcceptedContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getMeetingAndSendingOffContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getRegionalServiceRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getRehabilitationSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getNutritionScreeningContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getCalculationDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 生活行為向上リハビリ実施加算に内部項目を追加します。
   */
  protected void addLifeActsImproveRehabilitationRadioGroup(){

  }

  /**
   * 生活行為向上リハビリ実施加算モデルに内部項目を追加します。
   */
  protected void addLifeActsImproveRehabilitationRadioGroupModel(){

    getLifeActsImproveRehabilitationRadioItem1().setButtonIndex(1);

    getLifeActsImproveRehabilitationRadioGroupModel().add(getLifeActsImproveRehabilitationRadioItem1());

    getLifeActsImproveRehabilitationRadioItem2().setButtonIndex(2);

    getLifeActsImproveRehabilitationRadioGroupModel().add(getLifeActsImproveRehabilitationRadioItem2());

    getLifeActsImproveRehabilitationRadioItem3().setButtonIndex(3);

    getLifeActsImproveRehabilitationRadioGroupModel().add(getLifeActsImproveRehabilitationRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addLifeActsImproveRehabilitationRadioItem1(){

  }

  /**
   * 3月以内に内部項目を追加します。
   */
  protected void addLifeActsImproveRehabilitationRadioItem2(){

  }

  /**
   * 3月超6月以内に内部項目を追加します。
   */
  protected void addLifeActsImproveRehabilitationRadioItem3(){

  }

  /**
   * 生活行為向上リハビリテーション後の継続減算に内部項目を追加します。
   */
  protected void addLifeActsImproveRehaSubtractionRadioGroup(){

  }

  /**
   * 生活行為向上リハビリテーション後の継続減算モデルに内部項目を追加します。
   */
  protected void addLifeActsImproveRehaSubtractionRadioGroupModel(){

    getLifeActsImproveRehaSubtractionRadioItem1().setButtonIndex(1);

    getLifeActsImproveRehaSubtractionRadioGroupModel().add(getLifeActsImproveRehaSubtractionRadioItem1());

    getLifeActsImproveRehaSubtractionRadioItem2().setButtonIndex(2);

    getLifeActsImproveRehaSubtractionRadioGroupModel().add(getLifeActsImproveRehaSubtractionRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addLifeActsImproveRehaSubtractionRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addLifeActsImproveRehaSubtractionRadioItem2(){

  }

  /**
   * 中重度者ケア体制加算に内部項目を追加します。
   */
  protected void addSevereCareRecipientsAccepted(){

  }

  /**
   * 中重度者ケア体制加算モデルに内部項目を追加します。
   */
  protected void addSevereCareRecipientsAcceptedModel(){

    getSevereCareRecipientsAcceptedItem1().setButtonIndex(1);

    getSevereCareRecipientsAcceptedModel().add(getSevereCareRecipientsAcceptedItem1());

    getSevereCareRecipientsAcceptedItem2().setButtonIndex(2);

    getSevereCareRecipientsAcceptedModel().add(getSevereCareRecipientsAcceptedItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addSevereCareRecipientsAcceptedItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addSevereCareRecipientsAcceptedItem2(){

  }

  /**
   * 送迎区分に内部項目を追加します。
   */
  protected void addMeetingAndSendingOff(){

  }

  /**
   * 送迎区分モデルに内部項目を追加します。
   */
  protected void addMeetingAndSendingOffModel(){

    getMeetingAndSendingOffRoundTrip().setButtonIndex(1);

    getMeetingAndSendingOffModel().add(getMeetingAndSendingOffRoundTrip());

    getMeetingAndSendingOffOneWay().setButtonIndex(2);

    getMeetingAndSendingOffModel().add(getMeetingAndSendingOffOneWay());

    getMeetingAndSendingOffNone().setButtonIndex(3);

    getMeetingAndSendingOffModel().add(getMeetingAndSendingOffNone());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMeetingAndSendingOffRoundTrip(){

  }

  /**
   * 片道減算に内部項目を追加します。
   */
  protected void addMeetingAndSendingOffOneWay(){

  }

  /**
   * 往復減算に内部項目を追加します。
   */
  protected void addMeetingAndSendingOffNone(){

  }

  /**
   * 社会参加支援加算に内部項目を追加します。
   */
  protected void addRegionalServiceRadioGroup(){

  }

  /**
   * 社会参加支援加算モデルに内部項目を追加します。
   */
  protected void addRegionalServiceRadioGroupModel(){

    getRegionalServiceRadioItem1().setButtonIndex(1);

    getRegionalServiceRadioGroupModel().add(getRegionalServiceRadioItem1());

    getRegionalServiceRadioItem2().setButtonIndex(2);

    getRegionalServiceRadioGroupModel().add(getRegionalServiceRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addRegionalServiceRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addRegionalServiceRadioItem2(){

  }

  /**
   * リハビリテーション提供体制加算に内部項目を追加します。
   */
  protected void addRehabilitationSystem(){

  }

  /**
   * リハビリテーション提供体制加算モデルに内部項目を追加します。
   */
  protected void addRehabilitationSystemModel(){

    getRehabilitationSystemItem1().setButtonIndex(1);

    getRehabilitationSystemModel().add(getRehabilitationSystemItem1());

    getRehabilitationSystemItem2().setButtonIndex(2);

    getRehabilitationSystemModel().add(getRehabilitationSystemItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addRehabilitationSystemItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addRehabilitationSystemItem2(){

  }

  /**
   * 栄養スクリーニング加算に内部項目を追加します。
   */
  protected void addNutritionScreening(){

  }

  /**
   * 栄養スクリーニング加算モデルに内部項目を追加します。
   */
  protected void addNutritionScreeningModel(){

    getNutritionScreeningItem1().setButtonIndex(1);

    getNutritionScreeningModel().add(getNutritionScreeningItem1());

    getNutritionScreeningItem2().setButtonIndex(2);

    getNutritionScreeningModel().add(getNutritionScreeningItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addNutritionScreeningItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addNutritionScreeningItem2(){

  }

  /**
   * 算定区分に内部項目を追加します。
   */
  protected void addCalculationDivision(){

  }

  /**
   * 算定区分モデルに内部項目を追加します。
   */
  protected void addCalculationDivisionModel(){

    getCalculationDivisionNormal().setButtonIndex(1);

    getCalculationDivisionModel().add(getCalculationDivisionNormal());

    getCalculationDivisionAddOnly().setButtonIndex(2);

    getCalculationDivisionModel().add(getCalculationDivisionAddOnly());

  }

  /**
   * 通常に内部項目を追加します。
   */
  protected void addCalculationDivisionNormal(){

  }

  /**
   * 加算のみに内部項目を追加します。
   */
  protected void addCalculationDivisionAddOnly(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_11611_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001_11611_201804Design getThis() {
    return this;
  }
}
