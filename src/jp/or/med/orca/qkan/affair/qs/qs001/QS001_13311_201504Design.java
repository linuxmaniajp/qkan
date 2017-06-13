
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
 * 作成日: 2016/01/27  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン特定施設入所者生活介護 (QS001_13311_201504)
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
 * サービスパターン特定施設入所者生活介護画面項目デザイン(QS001_13311_201504) 
 */
public class QS001_13311_201504Design extends QS001ServicePanel {
  //GUIコンポーネント

  private JTabbedPane tabs;

  private ACPanel tabPanel1;

  private ACValueArrayRadioButtonGroup facilitiesDivisionRadio;

  private ACLabelContainer facilitiesDivisionRadioContainer;

  private ACListModelAdapter facilitiesDivisionRadioModel;

  private ACRadioButtonItem facilitiesDivisionRadioItem1;

  private ACRadioButtonItem facilitiesDivisionRadioItem2;

  private ACValueArrayRadioButtonGroup specificFacilitySubtractionRadio;

  private ACLabelContainer specificFacilitySubtractionRadioContainer;

  private ACListModelAdapter specificFacilitySubtractionRadioModel;

  private ACRadioButtonItem specificFacilitySubtractionNot;

  private ACRadioButtonItem specificFacilitySubtractionPersonLack;

  private ACValueArrayRadioButtonGroup specificFacilityFunctionTrainingRadio;

  private ACLabelContainer specificFacilityFunctionTrainingRadioContainer;

  private ACListModelAdapter specificFacilityFunctionTrainingRadioModel;

  private ACRadioButtonItem specificFacilityFunctionTrainingRadioItem2;

  private ACRadioButtonItem specificFacilityFunctionTrainingRadioItem1;

  private ACValueArrayRadioButtonGroup nightNursingSystemRadio;

  private ACLabelContainer nightNursingSystemRadioContainer;

  private ACListModelAdapter nightNursingSystemRadioModel;

  private ACRadioButtonItem nightNursingSystemRadioItem1;

  private ACRadioButtonItem nightNursingSystemRadioItem2;

  private ACValueArrayRadioButtonGroup medicalCoordinateAddRadioGroup;

  private ACLabelContainer medicalCoordinateAddRadioGroupContainer;

  private ACListModelAdapter medicalCoordinateAddRadioGroupModel;

  private ACRadioButtonItem medicalCoordinateAddRadioItem1;

  private ACRadioButtonItem medicalCoordinateAddRadioItem2;

  private ACValueArrayRadioButtonGroup impairedPersonHelpAddRadioGroup;

  private ACLabelContainer impairedPersonHelpAddRadioGroupContainer;

  private ACListModelAdapter impairedPersonHelpAddRadioGroupModel;

  private ACRadioButtonItem impairedPersonHelpAddRadioItem1;

  private ACRadioButtonItem impairedPersonHelpAddRadioItem2;

  private ACPanel tabPanel2;

  private ACValueArrayRadioButtonGroup terminalCareAddRadioGroup;

  private ACLabelContainer terminalCareAddRadioGroupContainer;

  private ACListModelAdapter terminalCareAddRadioGroupModel;

  private ACRadioButtonItem terminalCareAddRadioItem1;

  private ACRadioButtonItem terminalCareAddRadioItem2;

  private ACRadioButtonItem terminalCareAddRadioItem3;

  private ACRadioButtonItem terminalCareAddRadioItem4;

  private ACLabelContainer kaigoWelfareFacilityTakingCareNursingAddDaysContainer;

  private ACTextField kaigoWelfareFacilityTakingCareNursingAddDays;

  private ACLabel kaigoWelfareFacilityTakingCareNursingAddDaysUnit;

  private ACValueArrayRadioButtonGroup dementiaProfessionalCareAddRadioGroup;

  private ACLabelContainer dementiaProfessionalCareAddRadioGroupContainer;

  private ACListModelAdapter dementiaProfessionalCareAddRadioGroupModel;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem1;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem2;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem3;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem5;

  private ACValueArrayRadioButtonGroup calculationDivisionRadio;

  private ACLabelContainer calculationDivisionRadioContainer;

  private ACListModelAdapter calculationDivisionRadioModel;

  private ACRadioButtonItem calculationDivisionRadioItem1;

  private ACRadioButtonItem calculationDivisionRadioItem2;

  private ACPanel tabPanel3;

  private ACPanel serviceSettingPanel;

  private ACValueArrayRadioButtonGroup outsideServiceRadio;

  private ACLabelContainer outsideServiceRadioContainer;

  private ACListModelAdapter outsideServiceRadioModel;

  private ACRadioButtonItem outsideServiceRadioItem0;

  private ACRadioButtonItem outsideServiceRadioItem1;

  private ACRadioButtonItem outsideServiceRadioItem2;

  private ACRadioButtonItem outsideServiceRadioItem3;

  private ACRadioButtonItem outsideServiceRadioItem4;

  private ACRadioButtonItem outsideServiceRadioItem5;

  private ACRadioButtonItem outsideServiceRadioItem6;

  private ACRadioButtonItem outsideServiceRadioItem7;

  private ACRadioButtonItem outsideServiceRadioItem8;

  private ACRadioButtonItem outsideServiceRadioItem9;

  private ACBackLabelContainer specificFacilityTimeContena;

  private ACTimeComboBox specificFacilityBeginTime;

  private ACLabelContainer specificFacilityBeginTimeContainer;

  private ACComboBoxModelAdapter specificFacilityBeginTimeModel;

  private ACTimeComboBox specificFacilityEndTime;

  private ACLabelContainer specificFacilityEndTimeContainer;

  private ACComboBoxModelAdapter specificFacilityEndTimeModel;

  private ACGroupBox visitCareGroup;

  private ACValueArrayRadioButtonGroup visitCareRadio;

  private ACLabelContainer visitCareRadioContainer;

  private ACListModelAdapter visitCareRadioModel;

  private ACRadioButtonItem visitCareRadioItem1;

  private ACRadioButtonItem visitCareRadioItem2;

  private ACRadioButtonItem visitCareRadioItem3;

  private ACComboBox visitCareCombo;

  private ACLabelContainer visitCareComboContainer;

  private ACComboBoxModelAdapter visitCareComboModel;

  private ACPanel tabPanel4;

  private ACGroupBox visitNursingRadioGroup;

  private ACValueArrayRadioButtonGroup visitNursingFacilitiesDivisionRadio;

  private ACLabelContainer visitNursingFacilitiesDivisionRadioContainer;

  private ACListModelAdapter visitNursingFacilitiesDivisionRadioModel;

  private ACRadioButtonItem visitNursingFacilitiesDivisionRadioItem1;

  private ACRadioButtonItem visitNursingFacilitiesDivisionRadioItem2;

  private ACValueArrayRadioButtonGroup visitNursingStaffDivisionRadio;

  private ACLabelContainer visitNursingStaffDivisionRadioContainer;

  private ACListModelAdapter visitNursingStaffDivisionRadioModel;

  private ACRadioButtonItem visitNursingStaffDivisionRadioItem1;

  private ACRadioButtonItem visitNursingStaffDivisionRadioItem2;

  private ACIntegerCheckBox twoOrMoreTimesCheck;

  private ACComboBox visitNursingCombo;

  private ACLabelContainer visitNursingComboContainer;

  private ACComboBoxModelAdapter visitNursingComboModel;

  private ACValueArrayRadioButtonGroup nurseStaffDivisionRadioGroup;

  private ACLabelContainer nurseStaffDivisionRadioGroupContainer;

  private ACListModelAdapter nurseStaffDivisionRadioGroupModel;

  private ACRadioButtonItem nurseStaffDivisionRadioItem1;

  private ACRadioButtonItem nurseStaffDivisionRadioItem2;

  private ACGroupBox visitRehabiliGroup;

  private ACValueArrayRadioButtonGroup visitRehabiliRadio;

  private ACLabelContainer visitRehabiliRadioContainer;

  private ACListModelAdapter visitRehabiliRadioModel;

  private ACRadioButtonItem visitRehabiliRadioItem1;

  private ACRadioButtonItem visitRehabiliRadioItem2;

  private ACPanel tabPanel5;

  private ACGroupBox expertPlaceNursingGroup;

  private ACValueArrayRadioButtonGroup expertPlaceNursingRadio;

  private ACLabelContainer expertPlaceNursingRadioContainer;

  private ACListModelAdapter expertPlaceNursingRadioModel;

  private ACRadioButtonItem expertPlaceNursingRadioItem1;

  private ACRadioButtonItem expertPlaceNursingRadioItem2;

  private ACRadioButtonItem expertPlaceNursingRadioItem3;

  private ACRadioButtonItem expertPlaceNursingRadioItem4;

  private ACRadioButtonItem expertPlaceNursingRadioItem5;

  private ACComboBox expertPlaceNursingCombo;

  private ACLabelContainer expertPlaceNursingComboContainer;

  private ACComboBoxModelAdapter expertPlaceNursingComboModel;

  private ACPanel tabPanel6;

  private ACGroupBox expertPlaceRehabiliGroup;

  private ACValueArrayRadioButtonGroup expertPlaceRehabiliRadio;

  private ACLabelContainer expertPlaceRehabiliRadioContainer;

  private ACListModelAdapter expertPlaceRehabiliRadioModel;

  private ACRadioButtonItem expertPlaceRehabiliRadioItem1;

  private ACRadioButtonItem expertPlaceRehabiliRadioItem2;

  private ACRadioButtonItem expertPlaceRehabiliRadioItem3;

  private ACRadioButtonItem expertPlaceRehabiliRadioItem4;

  private ACRadioButtonItem expertPlaceRehabiliRadioItem5;

  private ACRadioButtonItem expertPlaceRehabiliRadioItem6;

  private ACComboBox expertPlaceRehabiliCombo;

  private ACLabelContainer expertPlaceRehabiliComboContainer;

  private ACComboBoxModelAdapter expertPlaceRehabiliComboModel;

  private ACPanel tabPanel7;

  private ACGroupBox welfareToolsGroup;

  private ACComboBox welfareToolsCombo;

  private ACLabelContainer welfareToolsComboContainer;

  private ACComboBoxModelAdapter welfareToolsComboModel;

  private ACTextField welfarePointText;

  private ACLabelContainer welfarePointTextContainer;

  private ACTextField welfareTekiyoText;

  private ACLabelContainer welfareTekiyoTextContainer;

  private ACGroupBox ninchishoTaioTsushoGroup;

  private ACValueArrayRadioButtonGroup providerDivisionRadio;

  private ACLabelContainer providerDivisionRadioContainer;

  private ACListModelAdapter providerDivisionRadioModel;

  private ACRadioButtonItem providerDivisionRadioItem1;

  private ACRadioButtonItem providerDivisionRadioItem2;

  private ACValueArrayRadioButtonGroup divisionRadion;

  private ACLabelContainer divisionRadionContainer;

  private ACListModelAdapter divisionRadionModel;

  private ACRadioButtonItem divisionRadionitem1;

  private ACRadioButtonItem divisionRadionitem2;

  private ACValueArrayRadioButtonGroup timeDivisionRadio;

  private ACLabelContainer timeDivisionRadioContainer;

  private ACListModelAdapter timeDivisionRadioModel;

  private ACRadioButtonItem timeDivisionRadioItem1;

  private ACRadioButtonItem timeDivisionRadioItem2;

  private ACRadioButtonItem timeDivisionRadioItem3;

  private ACRadioButtonItem timeDivisionRadioItem4;

  private ACPanel tabPanel8;

  private ACGroupBox chiikiDayCareGroup;

  private ACValueArrayRadioButtonGroup chiikiDayCareRadio;

  private ACLabelContainer chiikiDayCareRadioContainer;

  private ACListModelAdapter chiikiDayCareRadioModel;

  private ACRadioButtonItem chiikiDayCareRadioItem1;

  private ACRadioButtonItem chiikiDayCareRadioItem2;

  private ACComboBox chiikiDayCareCombo;

  private ACLabelContainer chiikiDayCareComboContainer;

  private ACComboBoxModelAdapter chiikiDayCareComboModel;

  //getter

  /**
   * タブを取得します。
   * @return タブ
   */
  public JTabbedPane getTabs(){
    if(tabs==null){

      tabs = new JTabbedPane();

      addTabs();
    }
    return tabs;

  }

  /**
   * タブパネル1を取得します。
   * @return タブパネル1
   */
  public ACPanel getTabPanel1(){
    if(tabPanel1==null){

      tabPanel1 = new ACPanel();

      tabPanel1.setFollowChildEnabled(true);

      tabPanel1.setHgap(0);

      addTabPanel1();
    }
    return tabPanel1;

  }

  /**
   * 施設等の区分を取得します。
   * @return 施設等の区分
   */
  public ACValueArrayRadioButtonGroup getFacilitiesDivisionRadio(){
    if(facilitiesDivisionRadio==null){

      facilitiesDivisionRadio = new ACValueArrayRadioButtonGroup();

      getFacilitiesDivisionRadioContainer().setText("施設等の区分");

      facilitiesDivisionRadio.setBindPath("1330105");

      facilitiesDivisionRadio.setUseClearButton(false);

      facilitiesDivisionRadio.setModel(getFacilitiesDivisionRadioModel());

      facilitiesDivisionRadio.setValues(new int[]{1,2});

      addFacilitiesDivisionRadio();
    }
    return facilitiesDivisionRadio;

  }

  /**
   * 施設等の区分コンテナを取得します。
   * @return 施設等の区分コンテナ
   */
  protected ACLabelContainer getFacilitiesDivisionRadioContainer(){
    if(facilitiesDivisionRadioContainer==null){
      facilitiesDivisionRadioContainer = new ACLabelContainer();
      facilitiesDivisionRadioContainer.setFollowChildEnabled(true);
      facilitiesDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      facilitiesDivisionRadioContainer.add(getFacilitiesDivisionRadio(), null);
    }
    return facilitiesDivisionRadioContainer;
  }

  /**
   * 施設等の区分モデルを取得します。
   * @return 施設等の区分モデル
   */
  protected ACListModelAdapter getFacilitiesDivisionRadioModel(){
    if(facilitiesDivisionRadioModel==null){
      facilitiesDivisionRadioModel = new ACListModelAdapter();
      addFacilitiesDivisionRadioModel();
    }
    return facilitiesDivisionRadioModel;
  }

  /**
   * 特定施設入居者を取得します。
   * @return 特定施設入居者
   */
  public ACRadioButtonItem getFacilitiesDivisionRadioItem1(){
    if(facilitiesDivisionRadioItem1==null){

      facilitiesDivisionRadioItem1 = new ACRadioButtonItem();

      facilitiesDivisionRadioItem1.setText("特定施設入居者");

      facilitiesDivisionRadioItem1.setGroup(getFacilitiesDivisionRadio());

      facilitiesDivisionRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionRadioItem1();
    }
    return facilitiesDivisionRadioItem1;

  }

  /**
   * 外部サービス利用型を取得します。
   * @return 外部サービス利用型
   */
  public ACRadioButtonItem getFacilitiesDivisionRadioItem2(){
    if(facilitiesDivisionRadioItem2==null){

      facilitiesDivisionRadioItem2 = new ACRadioButtonItem();

      facilitiesDivisionRadioItem2.setText("外部サービス利用型");

      facilitiesDivisionRadioItem2.setGroup(getFacilitiesDivisionRadio());

      facilitiesDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionRadioItem2();
    }
    return facilitiesDivisionRadioItem2;

  }

  /**
   * 人員減算を取得します。
   * @return 人員減算
   */
  public ACValueArrayRadioButtonGroup getSpecificFacilitySubtractionRadio(){
    if(specificFacilitySubtractionRadio==null){

      specificFacilitySubtractionRadio = new ACValueArrayRadioButtonGroup();

      getSpecificFacilitySubtractionRadioContainer().setText("人員減算");

      specificFacilitySubtractionRadio.setBindPath("1330104");

      specificFacilitySubtractionRadio.setUseClearButton(false);

      specificFacilitySubtractionRadio.setModel(getSpecificFacilitySubtractionRadioModel());

      specificFacilitySubtractionRadio.setValues(new int[]{1,2});

      addSpecificFacilitySubtractionRadio();
    }
    return specificFacilitySubtractionRadio;

  }

  /**
   * 人員減算コンテナを取得します。
   * @return 人員減算コンテナ
   */
  protected ACLabelContainer getSpecificFacilitySubtractionRadioContainer(){
    if(specificFacilitySubtractionRadioContainer==null){
      specificFacilitySubtractionRadioContainer = new ACLabelContainer();
      specificFacilitySubtractionRadioContainer.setFollowChildEnabled(true);
      specificFacilitySubtractionRadioContainer.setVAlignment(VRLayout.CENTER);
      specificFacilitySubtractionRadioContainer.add(getSpecificFacilitySubtractionRadio(), null);
    }
    return specificFacilitySubtractionRadioContainer;
  }

  /**
   * 人員減算モデルを取得します。
   * @return 人員減算モデル
   */
  protected ACListModelAdapter getSpecificFacilitySubtractionRadioModel(){
    if(specificFacilitySubtractionRadioModel==null){
      specificFacilitySubtractionRadioModel = new ACListModelAdapter();
      addSpecificFacilitySubtractionRadioModel();
    }
    return specificFacilitySubtractionRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getSpecificFacilitySubtractionNot(){
    if(specificFacilitySubtractionNot==null){

      specificFacilitySubtractionNot = new ACRadioButtonItem();

      specificFacilitySubtractionNot.setText("なし");

      specificFacilitySubtractionNot.setGroup(getSpecificFacilitySubtractionRadio());

      specificFacilitySubtractionNot.setConstraints(VRLayout.FLOW_RETURN);

      addSpecificFacilitySubtractionNot();
    }
    return specificFacilitySubtractionNot;

  }

  /**
   * 職員不足を取得します。
   * @return 職員不足
   */
  public ACRadioButtonItem getSpecificFacilitySubtractionPersonLack(){
    if(specificFacilitySubtractionPersonLack==null){

      specificFacilitySubtractionPersonLack = new ACRadioButtonItem();

      specificFacilitySubtractionPersonLack.setText("看護・介護職員の不足");

      specificFacilitySubtractionPersonLack.setGroup(getSpecificFacilitySubtractionRadio());

      specificFacilitySubtractionPersonLack.setConstraints(VRLayout.FLOW);

      addSpecificFacilitySubtractionPersonLack();
    }
    return specificFacilitySubtractionPersonLack;

  }

  /**
   * 個別機能訓練指導体制加算を取得します。
   * @return 個別機能訓練指導体制加算
   */
  public ACValueArrayRadioButtonGroup getSpecificFacilityFunctionTrainingRadio(){
    if(specificFacilityFunctionTrainingRadio==null){

      specificFacilityFunctionTrainingRadio = new ACValueArrayRadioButtonGroup();

      getSpecificFacilityFunctionTrainingRadioContainer().setText("個別機能訓練指導加算");

      specificFacilityFunctionTrainingRadio.setBindPath("1330103");

      specificFacilityFunctionTrainingRadio.setUseClearButton(false);

      specificFacilityFunctionTrainingRadio.setModel(getSpecificFacilityFunctionTrainingRadioModel());

      specificFacilityFunctionTrainingRadio.setValues(new int[]{1,2});

      addSpecificFacilityFunctionTrainingRadio();
    }
    return specificFacilityFunctionTrainingRadio;

  }

  /**
   * 個別機能訓練指導体制加算コンテナを取得します。
   * @return 個別機能訓練指導体制加算コンテナ
   */
  protected ACLabelContainer getSpecificFacilityFunctionTrainingRadioContainer(){
    if(specificFacilityFunctionTrainingRadioContainer==null){
      specificFacilityFunctionTrainingRadioContainer = new ACLabelContainer();
      specificFacilityFunctionTrainingRadioContainer.setFollowChildEnabled(true);
      specificFacilityFunctionTrainingRadioContainer.setVAlignment(VRLayout.CENTER);
      specificFacilityFunctionTrainingRadioContainer.add(getSpecificFacilityFunctionTrainingRadio(), null);
    }
    return specificFacilityFunctionTrainingRadioContainer;
  }

  /**
   * 個別機能訓練指導体制加算モデルを取得します。
   * @return 個別機能訓練指導体制加算モデル
   */
  protected ACListModelAdapter getSpecificFacilityFunctionTrainingRadioModel(){
    if(specificFacilityFunctionTrainingRadioModel==null){
      specificFacilityFunctionTrainingRadioModel = new ACListModelAdapter();
      addSpecificFacilityFunctionTrainingRadioModel();
    }
    return specificFacilityFunctionTrainingRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getSpecificFacilityFunctionTrainingRadioItem2(){
    if(specificFacilityFunctionTrainingRadioItem2==null){

      specificFacilityFunctionTrainingRadioItem2 = new ACRadioButtonItem();

      specificFacilityFunctionTrainingRadioItem2.setText("なし");

      specificFacilityFunctionTrainingRadioItem2.setGroup(getSpecificFacilityFunctionTrainingRadio());

      specificFacilityFunctionTrainingRadioItem2.setConstraints(VRLayout.FLOW);

      addSpecificFacilityFunctionTrainingRadioItem2();
    }
    return specificFacilityFunctionTrainingRadioItem2;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getSpecificFacilityFunctionTrainingRadioItem1(){
    if(specificFacilityFunctionTrainingRadioItem1==null){

      specificFacilityFunctionTrainingRadioItem1 = new ACRadioButtonItem();

      specificFacilityFunctionTrainingRadioItem1.setText("あり");

      specificFacilityFunctionTrainingRadioItem1.setGroup(getSpecificFacilityFunctionTrainingRadio());

      specificFacilityFunctionTrainingRadioItem1.setConstraints(VRLayout.FLOW);

      addSpecificFacilityFunctionTrainingRadioItem1();
    }
    return specificFacilityFunctionTrainingRadioItem1;

  }

  /**
   * 夜間看護体制加算を取得します。
   * @return 夜間看護体制加算
   */
  public ACValueArrayRadioButtonGroup getNightNursingSystemRadio(){
    if(nightNursingSystemRadio==null){

      nightNursingSystemRadio = new ACValueArrayRadioButtonGroup();

      getNightNursingSystemRadioContainer().setText("夜間看護体制加算");

      nightNursingSystemRadio.setBindPath("1330106");

      nightNursingSystemRadio.setUseClearButton(false);

      nightNursingSystemRadio.setModel(getNightNursingSystemRadioModel());

      nightNursingSystemRadio.setValues(new int[]{1,2});

      addNightNursingSystemRadio();
    }
    return nightNursingSystemRadio;

  }

  /**
   * 夜間看護体制加算コンテナを取得します。
   * @return 夜間看護体制加算コンテナ
   */
  protected ACLabelContainer getNightNursingSystemRadioContainer(){
    if(nightNursingSystemRadioContainer==null){
      nightNursingSystemRadioContainer = new ACLabelContainer();
      nightNursingSystemRadioContainer.setFollowChildEnabled(true);
      nightNursingSystemRadioContainer.setVAlignment(VRLayout.CENTER);
      nightNursingSystemRadioContainer.add(getNightNursingSystemRadio(), null);
    }
    return nightNursingSystemRadioContainer;
  }

  /**
   * 夜間看護体制加算モデルを取得します。
   * @return 夜間看護体制加算モデル
   */
  protected ACListModelAdapter getNightNursingSystemRadioModel(){
    if(nightNursingSystemRadioModel==null){
      nightNursingSystemRadioModel = new ACListModelAdapter();
      addNightNursingSystemRadioModel();
    }
    return nightNursingSystemRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getNightNursingSystemRadioItem1(){
    if(nightNursingSystemRadioItem1==null){

      nightNursingSystemRadioItem1 = new ACRadioButtonItem();

      nightNursingSystemRadioItem1.setText("なし");

      nightNursingSystemRadioItem1.setGroup(getNightNursingSystemRadio());

      nightNursingSystemRadioItem1.setConstraints(VRLayout.FLOW);

      addNightNursingSystemRadioItem1();
    }
    return nightNursingSystemRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getNightNursingSystemRadioItem2(){
    if(nightNursingSystemRadioItem2==null){

      nightNursingSystemRadioItem2 = new ACRadioButtonItem();

      nightNursingSystemRadioItem2.setText("あり");

      nightNursingSystemRadioItem2.setGroup(getNightNursingSystemRadio());

      nightNursingSystemRadioItem2.setConstraints(VRLayout.FLOW);

      addNightNursingSystemRadioItem2();
    }
    return nightNursingSystemRadioItem2;

  }

  /**
   * 医療機関連携加算を取得します。
   * @return 医療機関連携加算
   */
  public ACValueArrayRadioButtonGroup getMedicalCoordinateAddRadioGroup(){
    if(medicalCoordinateAddRadioGroup==null){

      medicalCoordinateAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getMedicalCoordinateAddRadioGroupContainer().setText("医療機関連携加算");

      medicalCoordinateAddRadioGroup.setBindPath("1330124");

      medicalCoordinateAddRadioGroup.setNoSelectIndex(0);

      medicalCoordinateAddRadioGroup.setUseClearButton(false);

      medicalCoordinateAddRadioGroup.setModel(getMedicalCoordinateAddRadioGroupModel());

      medicalCoordinateAddRadioGroup.setValues(new int[]{1,2});

      addMedicalCoordinateAddRadioGroup();
    }
    return medicalCoordinateAddRadioGroup;

  }

  /**
   * 医療機関連携加算コンテナを取得します。
   * @return 医療機関連携加算コンテナ
   */
  protected ACLabelContainer getMedicalCoordinateAddRadioGroupContainer(){
    if(medicalCoordinateAddRadioGroupContainer==null){
      medicalCoordinateAddRadioGroupContainer = new ACLabelContainer();
      medicalCoordinateAddRadioGroupContainer.setFollowChildEnabled(true);
      medicalCoordinateAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      medicalCoordinateAddRadioGroupContainer.add(getMedicalCoordinateAddRadioGroup(), null);
    }
    return medicalCoordinateAddRadioGroupContainer;
  }

  /**
   * 医療機関連携加算モデルを取得します。
   * @return 医療機関連携加算モデル
   */
  protected ACListModelAdapter getMedicalCoordinateAddRadioGroupModel(){
    if(medicalCoordinateAddRadioGroupModel==null){
      medicalCoordinateAddRadioGroupModel = new ACListModelAdapter();
      addMedicalCoordinateAddRadioGroupModel();
    }
    return medicalCoordinateAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalCoordinateAddRadioItem1(){
    if(medicalCoordinateAddRadioItem1==null){

      medicalCoordinateAddRadioItem1 = new ACRadioButtonItem();

      medicalCoordinateAddRadioItem1.setText("なし");

      medicalCoordinateAddRadioItem1.setGroup(getMedicalCoordinateAddRadioGroup());

      medicalCoordinateAddRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalCoordinateAddRadioItem1();
    }
    return medicalCoordinateAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMedicalCoordinateAddRadioItem2(){
    if(medicalCoordinateAddRadioItem2==null){

      medicalCoordinateAddRadioItem2 = new ACRadioButtonItem();

      medicalCoordinateAddRadioItem2.setText("あり");

      medicalCoordinateAddRadioItem2.setGroup(getMedicalCoordinateAddRadioGroup());

      medicalCoordinateAddRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalCoordinateAddRadioItem2();
    }
    return medicalCoordinateAddRadioItem2;

  }

  /**
   * 障害者等支援加算を取得します。
   * @return 障害者等支援加算
   */
  public ACValueArrayRadioButtonGroup getImpairedPersonHelpAddRadioGroup(){
    if(impairedPersonHelpAddRadioGroup==null){

      impairedPersonHelpAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getImpairedPersonHelpAddRadioGroupContainer().setText("障害者等支援加算");

      impairedPersonHelpAddRadioGroup.setBindPath("1330125");

      impairedPersonHelpAddRadioGroup.setNoSelectIndex(0);

      impairedPersonHelpAddRadioGroup.setUseClearButton(false);

      impairedPersonHelpAddRadioGroup.setModel(getImpairedPersonHelpAddRadioGroupModel());

      impairedPersonHelpAddRadioGroup.setValues(new int[]{1,2});

      addImpairedPersonHelpAddRadioGroup();
    }
    return impairedPersonHelpAddRadioGroup;

  }

  /**
   * 障害者等支援加算コンテナを取得します。
   * @return 障害者等支援加算コンテナ
   */
  protected ACLabelContainer getImpairedPersonHelpAddRadioGroupContainer(){
    if(impairedPersonHelpAddRadioGroupContainer==null){
      impairedPersonHelpAddRadioGroupContainer = new ACLabelContainer();
      impairedPersonHelpAddRadioGroupContainer.setFollowChildEnabled(true);
      impairedPersonHelpAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      impairedPersonHelpAddRadioGroupContainer.add(getImpairedPersonHelpAddRadioGroup(), null);
    }
    return impairedPersonHelpAddRadioGroupContainer;
  }

  /**
   * 障害者等支援加算モデルを取得します。
   * @return 障害者等支援加算モデル
   */
  protected ACListModelAdapter getImpairedPersonHelpAddRadioGroupModel(){
    if(impairedPersonHelpAddRadioGroupModel==null){
      impairedPersonHelpAddRadioGroupModel = new ACListModelAdapter();
      addImpairedPersonHelpAddRadioGroupModel();
    }
    return impairedPersonHelpAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getImpairedPersonHelpAddRadioItem1(){
    if(impairedPersonHelpAddRadioItem1==null){

      impairedPersonHelpAddRadioItem1 = new ACRadioButtonItem();

      impairedPersonHelpAddRadioItem1.setText("なし");

      impairedPersonHelpAddRadioItem1.setGroup(getImpairedPersonHelpAddRadioGroup());

      impairedPersonHelpAddRadioItem1.setConstraints(VRLayout.FLOW);

      addImpairedPersonHelpAddRadioItem1();
    }
    return impairedPersonHelpAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getImpairedPersonHelpAddRadioItem2(){
    if(impairedPersonHelpAddRadioItem2==null){

      impairedPersonHelpAddRadioItem2 = new ACRadioButtonItem();

      impairedPersonHelpAddRadioItem2.setText("あり");

      impairedPersonHelpAddRadioItem2.setGroup(getImpairedPersonHelpAddRadioGroup());

      impairedPersonHelpAddRadioItem2.setConstraints(VRLayout.FLOW);

      addImpairedPersonHelpAddRadioItem2();
    }
    return impairedPersonHelpAddRadioItem2;

  }

  /**
   * タブパネル2を取得します。
   * @return タブパネル2
   */
  public ACPanel getTabPanel2(){
    if(tabPanel2==null){

      tabPanel2 = new ACPanel();

      tabPanel2.setFollowChildEnabled(true);

      tabPanel2.setHgap(0);

      addTabPanel2();
    }
    return tabPanel2;

  }

  /**
   * 看取り介護加算を取得します。
   * @return 看取り介護加算
   */
  public ACValueArrayRadioButtonGroup getTerminalCareAddRadioGroup(){
    if(terminalCareAddRadioGroup==null){

      terminalCareAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getTerminalCareAddRadioGroupContainer().setText("看取り介護加算");

      terminalCareAddRadioGroup.setBindPath("1330128");

      terminalCareAddRadioGroup.setNoSelectIndex(0);

      terminalCareAddRadioGroup.setUseClearButton(false);

      terminalCareAddRadioGroup.setModel(getTerminalCareAddRadioGroupModel());

      terminalCareAddRadioGroup.setValues(new int[]{1,2,3,4});

      addTerminalCareAddRadioGroup();
    }
    return terminalCareAddRadioGroup;

  }

  /**
   * 看取り介護加算コンテナを取得します。
   * @return 看取り介護加算コンテナ
   */
  protected ACLabelContainer getTerminalCareAddRadioGroupContainer(){
    if(terminalCareAddRadioGroupContainer==null){
      terminalCareAddRadioGroupContainer = new ACLabelContainer();
      terminalCareAddRadioGroupContainer.setFollowChildEnabled(true);
      terminalCareAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      terminalCareAddRadioGroupContainer.add(getTerminalCareAddRadioGroup(), null);
    }
    return terminalCareAddRadioGroupContainer;
  }

  /**
   * 看取り介護加算モデルを取得します。
   * @return 看取り介護加算モデル
   */
  protected ACListModelAdapter getTerminalCareAddRadioGroupModel(){
    if(terminalCareAddRadioGroupModel==null){
      terminalCareAddRadioGroupModel = new ACListModelAdapter();
      addTerminalCareAddRadioGroupModel();
    }
    return terminalCareAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTerminalCareAddRadioItem1(){
    if(terminalCareAddRadioItem1==null){

      terminalCareAddRadioItem1 = new ACRadioButtonItem();

      terminalCareAddRadioItem1.setText("なし");

      terminalCareAddRadioItem1.setGroup(getTerminalCareAddRadioGroup());

      terminalCareAddRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addTerminalCareAddRadioItem1();
    }
    return terminalCareAddRadioItem1;

  }

  /**
   * 死亡日以前4日以上30日以下を取得します。
   * @return 死亡日以前4日以上30日以下
   */
  public ACRadioButtonItem getTerminalCareAddRadioItem2(){
    if(terminalCareAddRadioItem2==null){

      terminalCareAddRadioItem2 = new ACRadioButtonItem();

      terminalCareAddRadioItem2.setText("死亡日以前4日以上30日以下");

      terminalCareAddRadioItem2.setGroup(getTerminalCareAddRadioGroup());

      terminalCareAddRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addTerminalCareAddRadioItem2();
    }
    return terminalCareAddRadioItem2;

  }

  /**
   * 死亡日以前2日又は3日を取得します。
   * @return 死亡日以前2日又は3日
   */
  public ACRadioButtonItem getTerminalCareAddRadioItem3(){
    if(terminalCareAddRadioItem3==null){

      terminalCareAddRadioItem3 = new ACRadioButtonItem();

      terminalCareAddRadioItem3.setText("死亡日以前2日又は3日");

      terminalCareAddRadioItem3.setGroup(getTerminalCareAddRadioGroup());

      terminalCareAddRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addTerminalCareAddRadioItem3();
    }
    return terminalCareAddRadioItem3;

  }

  /**
   * 死亡日を取得します。
   * @return 死亡日
   */
  public ACRadioButtonItem getTerminalCareAddRadioItem4(){
    if(terminalCareAddRadioItem4==null){

      terminalCareAddRadioItem4 = new ACRadioButtonItem();

      terminalCareAddRadioItem4.setText("死亡日");

      terminalCareAddRadioItem4.setGroup(getTerminalCareAddRadioGroup());

      terminalCareAddRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addTerminalCareAddRadioItem4();
    }
    return terminalCareAddRadioItem4;

  }

  /**
   * 看取り介護加算コンテナを取得します。
   * @return 看取り介護加算コンテナ
   */
  public ACLabelContainer getKaigoWelfareFacilityTakingCareNursingAddDaysContainer(){
    if(kaigoWelfareFacilityTakingCareNursingAddDaysContainer==null){

      kaigoWelfareFacilityTakingCareNursingAddDaysContainer = new ACLabelContainer();

      kaigoWelfareFacilityTakingCareNursingAddDaysContainer.setText("看取り介護加算日数");

      kaigoWelfareFacilityTakingCareNursingAddDaysContainer.setFollowChildEnabled(true);

      addKaigoWelfareFacilityTakingCareNursingAddDaysContainer();
    }
    return kaigoWelfareFacilityTakingCareNursingAddDaysContainer;

  }

  /**
   * 看取り介護加算日数を取得します。
   * @return 看取り介護加算日数
   */
  public ACTextField getKaigoWelfareFacilityTakingCareNursingAddDays(){
    if(kaigoWelfareFacilityTakingCareNursingAddDays==null){

      kaigoWelfareFacilityTakingCareNursingAddDays = new ACTextField();

      kaigoWelfareFacilityTakingCareNursingAddDays.setText("1");

      kaigoWelfareFacilityTakingCareNursingAddDays.setBindPath("1330133");

      kaigoWelfareFacilityTakingCareNursingAddDays.setColumns(2);

      kaigoWelfareFacilityTakingCareNursingAddDays.setCharType(VRCharType.ONLY_DIGIT);

      kaigoWelfareFacilityTakingCareNursingAddDays.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoWelfareFacilityTakingCareNursingAddDays.setMaxLength(2);

      addKaigoWelfareFacilityTakingCareNursingAddDays();
    }
    return kaigoWelfareFacilityTakingCareNursingAddDays;

  }

  /**
   * 看取り介護加算日数単位を取得します。
   * @return 看取り介護加算日数単位
   */
  public ACLabel getKaigoWelfareFacilityTakingCareNursingAddDaysUnit(){
    if(kaigoWelfareFacilityTakingCareNursingAddDaysUnit==null){

      kaigoWelfareFacilityTakingCareNursingAddDaysUnit = new ACLabel();

      kaigoWelfareFacilityTakingCareNursingAddDaysUnit.setText("日");

      addKaigoWelfareFacilityTakingCareNursingAddDaysUnit();
    }
    return kaigoWelfareFacilityTakingCareNursingAddDaysUnit;

  }

  /**
   * 認知症専門ケア加算を取得します。
   * @return 認知症専門ケア加算
   */
  public ACValueArrayRadioButtonGroup getDementiaProfessionalCareAddRadioGroup(){
    if(dementiaProfessionalCareAddRadioGroup==null){

      dementiaProfessionalCareAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaProfessionalCareAddRadioGroupContainer().setText("認知症専門ケア加算");

      dementiaProfessionalCareAddRadioGroup.setBindPath("1330130");

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

      addDementiaProfessionalCareAddRadioItem1();
    }
    return dementiaProfessionalCareAddRadioItem1;

  }

  /**
   * 加算型Iを取得します。
   * @return 加算型I
   */
  public ACRadioButtonItem getDementiaProfessionalCareAddRadioItem2(){
    if(dementiaProfessionalCareAddRadioItem2==null){

      dementiaProfessionalCareAddRadioItem2 = new ACRadioButtonItem();

      dementiaProfessionalCareAddRadioItem2.setText("加算型I");

      dementiaProfessionalCareAddRadioItem2.setGroup(getDementiaProfessionalCareAddRadioGroup());

      addDementiaProfessionalCareAddRadioItem2();
    }
    return dementiaProfessionalCareAddRadioItem2;

  }

  /**
   * 加算型IIを取得します。
   * @return 加算型II
   */
  public ACRadioButtonItem getDementiaProfessionalCareAddRadioItem3(){
    if(dementiaProfessionalCareAddRadioItem3==null){

      dementiaProfessionalCareAddRadioItem3 = new ACRadioButtonItem();

      dementiaProfessionalCareAddRadioItem3.setText("加算型II");

      dementiaProfessionalCareAddRadioItem3.setGroup(getDementiaProfessionalCareAddRadioGroup());

      addDementiaProfessionalCareAddRadioItem3();
    }
    return dementiaProfessionalCareAddRadioItem3;

  }

  /**
   * サービス提供体制強化加算を取得します。
   * @return サービス提供体制強化加算
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("サービス提供体制強化加算");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1330131");

      serviceAddProvisionStructuralRadioGroup.setVisible(true);

      serviceAddProvisionStructuralRadioGroup.setEnabled(true);

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,2,3,4,5});

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
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("Iイ型");

      serviceAddProvisionStructuralRadioItem2.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addServiceAddProvisionStructuralRadioItem2();
    }
    return serviceAddProvisionStructuralRadioItem2;

  }

  /**
   * Iロ型を取得します。
   * @return Iロ型
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem3(){
    if(serviceAddProvisionStructuralRadioItem3==null){

      serviceAddProvisionStructuralRadioItem3 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem3.setText("Iロ型");

      serviceAddProvisionStructuralRadioItem3.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem3.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem3();
    }
    return serviceAddProvisionStructuralRadioItem3;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem4(){
    if(serviceAddProvisionStructuralRadioItem4==null){

      serviceAddProvisionStructuralRadioItem4 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem4.setText("II型");

      serviceAddProvisionStructuralRadioItem4.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem4.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem4();
    }
    return serviceAddProvisionStructuralRadioItem4;

  }

  /**
   * III型を取得します。
   * @return III型
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem5(){
    if(serviceAddProvisionStructuralRadioItem5==null){

      serviceAddProvisionStructuralRadioItem5 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem5.setText("III型");

      serviceAddProvisionStructuralRadioItem5.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem5.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem5();
    }
    return serviceAddProvisionStructuralRadioItem5;

  }

  /**
   * 算定区分を取得します。
   * @return 算定区分
   */
  public ACValueArrayRadioButtonGroup getCalculationDivisionRadio(){
    if(calculationDivisionRadio==null){

      calculationDivisionRadio = new ACValueArrayRadioButtonGroup();

      getCalculationDivisionRadioContainer().setText("算定区分");

      calculationDivisionRadio.setBindPath("9");

      calculationDivisionRadio.setUseClearButton(false);

      calculationDivisionRadio.setModel(getCalculationDivisionRadioModel());

      calculationDivisionRadio.setValues(new int[]{1,2});

      addCalculationDivisionRadio();
    }
    return calculationDivisionRadio;

  }

  /**
   * 算定区分コンテナを取得します。
   * @return 算定区分コンテナ
   */
  protected ACLabelContainer getCalculationDivisionRadioContainer(){
    if(calculationDivisionRadioContainer==null){
      calculationDivisionRadioContainer = new ACLabelContainer();
      calculationDivisionRadioContainer.setFollowChildEnabled(true);
      calculationDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      calculationDivisionRadioContainer.add(getCalculationDivisionRadio(), null);
    }
    return calculationDivisionRadioContainer;
  }

  /**
   * 算定区分モデルを取得します。
   * @return 算定区分モデル
   */
  protected ACListModelAdapter getCalculationDivisionRadioModel(){
    if(calculationDivisionRadioModel==null){
      calculationDivisionRadioModel = new ACListModelAdapter();
      addCalculationDivisionRadioModel();
    }
    return calculationDivisionRadioModel;
  }

  /**
   * 通常を取得します。
   * @return 通常
   */
  public ACRadioButtonItem getCalculationDivisionRadioItem1(){
    if(calculationDivisionRadioItem1==null){

      calculationDivisionRadioItem1 = new ACRadioButtonItem();

      calculationDivisionRadioItem1.setText("通常");

      calculationDivisionRadioItem1.setGroup(getCalculationDivisionRadio());

      calculationDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addCalculationDivisionRadioItem1();
    }
    return calculationDivisionRadioItem1;

  }

  /**
   * 加算のみを取得します。
   * @return 加算のみ
   */
  public ACRadioButtonItem getCalculationDivisionRadioItem2(){
    if(calculationDivisionRadioItem2==null){

      calculationDivisionRadioItem2 = new ACRadioButtonItem();

      calculationDivisionRadioItem2.setText("加算のみ");

      calculationDivisionRadioItem2.setGroup(getCalculationDivisionRadio());

      calculationDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addCalculationDivisionRadioItem2();
    }
    return calculationDivisionRadioItem2;

  }

  /**
   * タブパネル3を取得します。
   * @return タブパネル3
   */
  public ACPanel getTabPanel3(){
    if(tabPanel3==null){

      tabPanel3 = new ACPanel();

      tabPanel3.setFollowChildEnabled(true);

      tabPanel3.setHgap(0);

      addTabPanel3();
    }
    return tabPanel3;

  }

  /**
   * 概要領域を取得します。
   * @return 概要領域
   */
  public ACPanel getServiceSettingPanel(){
    if(serviceSettingPanel==null){

      serviceSettingPanel = new ACPanel();

      serviceSettingPanel.setFollowChildEnabled(true);

      serviceSettingPanel.setHgap(0);

      serviceSettingPanel.setLabelMargin(0);

      serviceSettingPanel.setVgap(0);

      addServiceSettingPanel();
    }
    return serviceSettingPanel;

  }

  /**
   * 外部サービスを取得します。
   * @return 外部サービス
   */
  public ACValueArrayRadioButtonGroup getOutsideServiceRadio(){
    if(outsideServiceRadio==null){

      outsideServiceRadio = new ACValueArrayRadioButtonGroup();

      getOutsideServiceRadioContainer().setText("外部サービス");

      outsideServiceRadio.setBindPath("1330107");

      outsideServiceRadio.setUseClearButton(false);

      outsideServiceRadio.setModel(getOutsideServiceRadioModel());

      outsideServiceRadio.setValues(new int[]{9,1,2,3,4,5,6,7,8,10});

      addOutsideServiceRadio();
    }
    return outsideServiceRadio;

  }

  /**
   * 外部サービスコンテナを取得します。
   * @return 外部サービスコンテナ
   */
  protected ACLabelContainer getOutsideServiceRadioContainer(){
    if(outsideServiceRadioContainer==null){
      outsideServiceRadioContainer = new ACLabelContainer();
      outsideServiceRadioContainer.setFollowChildEnabled(true);
      outsideServiceRadioContainer.setVAlignment(VRLayout.CENTER);
      outsideServiceRadioContainer.add(getOutsideServiceRadio(), null);
    }
    return outsideServiceRadioContainer;
  }

  /**
   * 外部サービスモデルを取得します。
   * @return 外部サービスモデル
   */
  protected ACListModelAdapter getOutsideServiceRadioModel(){
    if(outsideServiceRadioModel==null){
      outsideServiceRadioModel = new ACListModelAdapter();
      addOutsideServiceRadioModel();
    }
    return outsideServiceRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getOutsideServiceRadioItem0(){
    if(outsideServiceRadioItem0==null){

      outsideServiceRadioItem0 = new ACRadioButtonItem();

      outsideServiceRadioItem0.setText("なし");

      outsideServiceRadioItem0.setGroup(getOutsideServiceRadio());

      outsideServiceRadioItem0.setConstraints(VRLayout.FLOW_RETURN);

      addOutsideServiceRadioItem0();
    }
    return outsideServiceRadioItem0;

  }

  /**
   * 訪問介護を取得します。
   * @return 訪問介護
   */
  public ACRadioButtonItem getOutsideServiceRadioItem1(){
    if(outsideServiceRadioItem1==null){

      outsideServiceRadioItem1 = new ACRadioButtonItem();

      outsideServiceRadioItem1.setText("訪問介護");

      outsideServiceRadioItem1.setGroup(getOutsideServiceRadio());

      outsideServiceRadioItem1.setConstraints(VRLayout.FLOW);

      addOutsideServiceRadioItem1();
    }
    return outsideServiceRadioItem1;

  }

  /**
   * 訪問入浴介護を取得します。
   * @return 訪問入浴介護
   */
  public ACRadioButtonItem getOutsideServiceRadioItem2(){
    if(outsideServiceRadioItem2==null){

      outsideServiceRadioItem2 = new ACRadioButtonItem();

      outsideServiceRadioItem2.setText("訪問入浴介護");

      outsideServiceRadioItem2.setGroup(getOutsideServiceRadio());

      outsideServiceRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addOutsideServiceRadioItem2();
    }
    return outsideServiceRadioItem2;

  }

  /**
   * 訪問看護を取得します。
   * @return 訪問看護
   */
  public ACRadioButtonItem getOutsideServiceRadioItem3(){
    if(outsideServiceRadioItem3==null){

      outsideServiceRadioItem3 = new ACRadioButtonItem();

      outsideServiceRadioItem3.setText("訪問看護");

      outsideServiceRadioItem3.setGroup(getOutsideServiceRadio());

      outsideServiceRadioItem3.setConstraints(VRLayout.FLOW);

      addOutsideServiceRadioItem3();
    }
    return outsideServiceRadioItem3;

  }

  /**
   * 訪問リハを取得します。
   * @return 訪問リハ
   */
  public ACRadioButtonItem getOutsideServiceRadioItem4(){
    if(outsideServiceRadioItem4==null){

      outsideServiceRadioItem4 = new ACRadioButtonItem();

      outsideServiceRadioItem4.setText("訪問リハ");

      outsideServiceRadioItem4.setGroup(getOutsideServiceRadio());

      outsideServiceRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addOutsideServiceRadioItem4();
    }
    return outsideServiceRadioItem4;

  }

  /**
   * 通所介護を取得します。
   * @return 通所介護
   */
  public ACRadioButtonItem getOutsideServiceRadioItem5(){
    if(outsideServiceRadioItem5==null){

      outsideServiceRadioItem5 = new ACRadioButtonItem();

      outsideServiceRadioItem5.setText("通所介護");

      outsideServiceRadioItem5.setGroup(getOutsideServiceRadio());

      outsideServiceRadioItem5.setConstraints(VRLayout.FLOW);

      addOutsideServiceRadioItem5();
    }
    return outsideServiceRadioItem5;

  }

  /**
   * 通所リハを取得します。
   * @return 通所リハ
   */
  public ACRadioButtonItem getOutsideServiceRadioItem6(){
    if(outsideServiceRadioItem6==null){

      outsideServiceRadioItem6 = new ACRadioButtonItem();

      outsideServiceRadioItem6.setText("通所リハ");

      outsideServiceRadioItem6.setGroup(getOutsideServiceRadio());

      outsideServiceRadioItem6.setConstraints(VRLayout.FLOW_RETURN);

      addOutsideServiceRadioItem6();
    }
    return outsideServiceRadioItem6;

  }

  /**
   * 福祉用具貸与を取得します。
   * @return 福祉用具貸与
   */
  public ACRadioButtonItem getOutsideServiceRadioItem7(){
    if(outsideServiceRadioItem7==null){

      outsideServiceRadioItem7 = new ACRadioButtonItem();

      outsideServiceRadioItem7.setText("福祉用具貸与");

      outsideServiceRadioItem7.setGroup(getOutsideServiceRadio());

      outsideServiceRadioItem7.setConstraints(VRLayout.FLOW);

      addOutsideServiceRadioItem7();
    }
    return outsideServiceRadioItem7;

  }

  /**
   * 認知症対応通所介護を取得します。
   * @return 認知症対応通所介護
   */
  public ACRadioButtonItem getOutsideServiceRadioItem8(){
    if(outsideServiceRadioItem8==null){

      outsideServiceRadioItem8 = new ACRadioButtonItem();

      outsideServiceRadioItem8.setText("認知症対応型通所介護");

      outsideServiceRadioItem8.setGroup(getOutsideServiceRadio());

      outsideServiceRadioItem8.setConstraints(VRLayout.FLOW_RETURN);

      addOutsideServiceRadioItem8();
    }
    return outsideServiceRadioItem8;

  }

  /**
   * 地域密着型通所介護を取得します。
   * @return 地域密着型通所介護
   */
  public ACRadioButtonItem getOutsideServiceRadioItem9(){
    if(outsideServiceRadioItem9==null){

      outsideServiceRadioItem9 = new ACRadioButtonItem();

      outsideServiceRadioItem9.setText("地域密着型通所介護");

      outsideServiceRadioItem9.setGroup(getOutsideServiceRadio());

      outsideServiceRadioItem9.setConstraints(VRLayout.FLOW);

      addOutsideServiceRadioItem9();
    }
    return outsideServiceRadioItem9;

  }

  /**
   * 提供時間コンテナを取得します。
   * @return 提供時間コンテナ
   */
  public ACBackLabelContainer getSpecificFacilityTimeContena(){
    if(specificFacilityTimeContena==null){

      specificFacilityTimeContena = new ACBackLabelContainer();

      specificFacilityTimeContena.setFollowChildEnabled(true);

      addSpecificFacilityTimeContena();
    }
    return specificFacilityTimeContena;

  }

  /**
   * 開始時刻コンボを取得します。
   * @return 開始時刻コンボ
   */
  public ACTimeComboBox getSpecificFacilityBeginTime(){
    if(specificFacilityBeginTime==null){

      specificFacilityBeginTime = new ACTimeComboBox();

      getSpecificFacilityBeginTimeContainer().setText("開始時刻");

      specificFacilityBeginTime.setBindPath("3");

      specificFacilityBeginTime.setModelBindPath("3");

      specificFacilityBeginTime.setRenderBindPath("CONTENT");

      specificFacilityBeginTime.setModel(getSpecificFacilityBeginTimeModel());

      addSpecificFacilityBeginTime();
    }
    return specificFacilityBeginTime;

  }

  /**
   * 開始時刻コンボコンテナを取得します。
   * @return 開始時刻コンボコンテナ
   */
  protected ACLabelContainer getSpecificFacilityBeginTimeContainer(){
    if(specificFacilityBeginTimeContainer==null){
      specificFacilityBeginTimeContainer = new ACLabelContainer();
      specificFacilityBeginTimeContainer.setFollowChildEnabled(true);
      specificFacilityBeginTimeContainer.setVAlignment(VRLayout.CENTER);
      specificFacilityBeginTimeContainer.add(getSpecificFacilityBeginTime(), null);
    }
    return specificFacilityBeginTimeContainer;
  }

  /**
   * 開始時刻コンボモデルを取得します。
   * @return 開始時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getSpecificFacilityBeginTimeModel(){
    if(specificFacilityBeginTimeModel==null){
      specificFacilityBeginTimeModel = new ACComboBoxModelAdapter();
      addSpecificFacilityBeginTimeModel();
    }
    return specificFacilityBeginTimeModel;
  }

  /**
   * 終了時刻コンボを取得します。
   * @return 終了時刻コンボ
   */
  public ACTimeComboBox getSpecificFacilityEndTime(){
    if(specificFacilityEndTime==null){

      specificFacilityEndTime = new ACTimeComboBox();

      getSpecificFacilityEndTimeContainer().setText("終了時刻");

      specificFacilityEndTime.setBindPath("4");

      specificFacilityEndTime.setModelBindPath("4");

      specificFacilityEndTime.setRenderBindPath("CONTENT");

      specificFacilityEndTime.setModel(getSpecificFacilityEndTimeModel());

      addSpecificFacilityEndTime();
    }
    return specificFacilityEndTime;

  }

  /**
   * 終了時刻コンボコンテナを取得します。
   * @return 終了時刻コンボコンテナ
   */
  protected ACLabelContainer getSpecificFacilityEndTimeContainer(){
    if(specificFacilityEndTimeContainer==null){
      specificFacilityEndTimeContainer = new ACLabelContainer();
      specificFacilityEndTimeContainer.setFollowChildEnabled(true);
      specificFacilityEndTimeContainer.setVAlignment(VRLayout.CENTER);
      specificFacilityEndTimeContainer.add(getSpecificFacilityEndTime(), null);
    }
    return specificFacilityEndTimeContainer;
  }

  /**
   * 終了時刻コンボモデルを取得します。
   * @return 終了時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getSpecificFacilityEndTimeModel(){
    if(specificFacilityEndTimeModel==null){
      specificFacilityEndTimeModel = new ACComboBoxModelAdapter();
      addSpecificFacilityEndTimeModel();
    }
    return specificFacilityEndTimeModel;
  }

  /**
   * 訪問介護グループを取得します。
   * @return 訪問介護グループ
   */
  public ACGroupBox getVisitCareGroup(){
    if(visitCareGroup==null){

      visitCareGroup = new ACGroupBox();

      visitCareGroup.setText("訪問介護");

      visitCareGroup.setFollowChildEnabled(true);

      addVisitCareGroup();
    }
    return visitCareGroup;

  }

  /**
   * 訪問介護を取得します。
   * @return 訪問介護
   */
  public ACValueArrayRadioButtonGroup getVisitCareRadio(){
    if(visitCareRadio==null){

      visitCareRadio = new ACValueArrayRadioButtonGroup();

      getVisitCareRadioContainer().setText("種別");

      visitCareRadio.setBindPath("1330108");

      visitCareRadio.setUseClearButton(false);

      visitCareRadio.setModel(getVisitCareRadioModel());

      visitCareRadio.setValues(new int[]{1,2,3});

      addVisitCareRadio();
    }
    return visitCareRadio;

  }

  /**
   * 訪問介護コンテナを取得します。
   * @return 訪問介護コンテナ
   */
  protected ACLabelContainer getVisitCareRadioContainer(){
    if(visitCareRadioContainer==null){
      visitCareRadioContainer = new ACLabelContainer();
      visitCareRadioContainer.setFollowChildEnabled(true);
      visitCareRadioContainer.setVAlignment(VRLayout.CENTER);
      visitCareRadioContainer.add(getVisitCareRadio(), null);
    }
    return visitCareRadioContainer;
  }

  /**
   * 訪問介護モデルを取得します。
   * @return 訪問介護モデル
   */
  protected ACListModelAdapter getVisitCareRadioModel(){
    if(visitCareRadioModel==null){
      visitCareRadioModel = new ACListModelAdapter();
      addVisitCareRadioModel();
    }
    return visitCareRadioModel;
  }

  /**
   * 身体介護中心を取得します。
   * @return 身体介護中心
   */
  public ACRadioButtonItem getVisitCareRadioItem1(){
    if(visitCareRadioItem1==null){

      visitCareRadioItem1 = new ACRadioButtonItem();

      visitCareRadioItem1.setText("身体介護中心");

      visitCareRadioItem1.setGroup(getVisitCareRadio());

      visitCareRadioItem1.setConstraints(VRLayout.FLOW);

      addVisitCareRadioItem1();
    }
    return visitCareRadioItem1;

  }

  /**
   * 生活援助中心を取得します。
   * @return 生活援助中心
   */
  public ACRadioButtonItem getVisitCareRadioItem2(){
    if(visitCareRadioItem2==null){

      visitCareRadioItem2 = new ACRadioButtonItem();

      visitCareRadioItem2.setText("生活援助中心");

      visitCareRadioItem2.setGroup(getVisitCareRadio());

      visitCareRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addVisitCareRadioItem2();
    }
    return visitCareRadioItem2;

  }

  /**
   * 通院等乗降介助を取得します。
   * @return 通院等乗降介助
   */
  public ACRadioButtonItem getVisitCareRadioItem3(){
    if(visitCareRadioItem3==null){

      visitCareRadioItem3 = new ACRadioButtonItem();

      visitCareRadioItem3.setText("通院等乗降介助");

      visitCareRadioItem3.setGroup(getVisitCareRadio());

      visitCareRadioItem3.setConstraints(VRLayout.FLOW);

      addVisitCareRadioItem3();
    }
    return visitCareRadioItem3;

  }

  /**
   * 時間区分コンボを取得します。
   * @return 時間区分コンボ
   */
  public ACComboBox getVisitCareCombo(){
    if(visitCareCombo==null){

      visitCareCombo = new ACComboBox();

      getVisitCareComboContainer().setText("時間区分");

      visitCareCombo.setBindPath("1330109");

      visitCareCombo.setEditable(false);

      visitCareCombo.setModelBindPath("1330109");

      visitCareCombo.setRenderBindPath("CONTENT");

      visitCareCombo.setModel(getVisitCareComboModel());

      addVisitCareCombo();
    }
    return visitCareCombo;

  }

  /**
   * 時間区分コンボコンテナを取得します。
   * @return 時間区分コンボコンテナ
   */
  protected ACLabelContainer getVisitCareComboContainer(){
    if(visitCareComboContainer==null){
      visitCareComboContainer = new ACLabelContainer();
      visitCareComboContainer.setFollowChildEnabled(true);
      visitCareComboContainer.setVAlignment(VRLayout.CENTER);
      visitCareComboContainer.add(getVisitCareCombo(), null);
    }
    return visitCareComboContainer;
  }

  /**
   * 時間区分コンボモデルを取得します。
   * @return 時間区分コンボモデル
   */
  protected ACComboBoxModelAdapter getVisitCareComboModel(){
    if(visitCareComboModel==null){
      visitCareComboModel = new ACComboBoxModelAdapter();
      addVisitCareComboModel();
    }
    return visitCareComboModel;
  }

  /**
   * タブパネル4を取得します。
   * @return タブパネル4
   */
  public ACPanel getTabPanel4(){
    if(tabPanel4==null){

      tabPanel4 = new ACPanel();

      tabPanel4.setFollowChildEnabled(true);

      tabPanel4.setHgap(0);

      addTabPanel4();
    }
    return tabPanel4;

  }

  /**
   * 訪問看護を取得します。
   * @return 訪問看護
   */
  public ACGroupBox getVisitNursingRadioGroup(){
    if(visitNursingRadioGroup==null){

      visitNursingRadioGroup = new ACGroupBox();

      visitNursingRadioGroup.setText("訪問看護");

      visitNursingRadioGroup.setFollowChildEnabled(true);

      addVisitNursingRadioGroup();
    }
    return visitNursingRadioGroup;

  }

  /**
   * 施設等の区分を取得します。
   * @return 施設等の区分
   */
  public ACValueArrayRadioButtonGroup getVisitNursingFacilitiesDivisionRadio(){
    if(visitNursingFacilitiesDivisionRadio==null){

      visitNursingFacilitiesDivisionRadio = new ACValueArrayRadioButtonGroup();

      getVisitNursingFacilitiesDivisionRadioContainer().setText("施設等の区分");

      visitNursingFacilitiesDivisionRadio.setBindPath("1330110");

      visitNursingFacilitiesDivisionRadio.setUseClearButton(false);

      visitNursingFacilitiesDivisionRadio.setModel(getVisitNursingFacilitiesDivisionRadioModel());

      visitNursingFacilitiesDivisionRadio.setValues(new int[]{1,2});

      addVisitNursingFacilitiesDivisionRadio();
    }
    return visitNursingFacilitiesDivisionRadio;

  }

  /**
   * 施設等の区分コンテナを取得します。
   * @return 施設等の区分コンテナ
   */
  protected ACLabelContainer getVisitNursingFacilitiesDivisionRadioContainer(){
    if(visitNursingFacilitiesDivisionRadioContainer==null){
      visitNursingFacilitiesDivisionRadioContainer = new ACLabelContainer();
      visitNursingFacilitiesDivisionRadioContainer.setFollowChildEnabled(true);
      visitNursingFacilitiesDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      visitNursingFacilitiesDivisionRadioContainer.add(getVisitNursingFacilitiesDivisionRadio(), null);
    }
    return visitNursingFacilitiesDivisionRadioContainer;
  }

  /**
   * 施設等の区分モデルを取得します。
   * @return 施設等の区分モデル
   */
  protected ACListModelAdapter getVisitNursingFacilitiesDivisionRadioModel(){
    if(visitNursingFacilitiesDivisionRadioModel==null){
      visitNursingFacilitiesDivisionRadioModel = new ACListModelAdapter();
      addVisitNursingFacilitiesDivisionRadioModel();
    }
    return visitNursingFacilitiesDivisionRadioModel;
  }

  /**
   * 訪問看護ステーションを取得します。
   * @return 訪問看護ステーション
   */
  public ACRadioButtonItem getVisitNursingFacilitiesDivisionRadioItem1(){
    if(visitNursingFacilitiesDivisionRadioItem1==null){

      visitNursingFacilitiesDivisionRadioItem1 = new ACRadioButtonItem();

      visitNursingFacilitiesDivisionRadioItem1.setText("訪問看護ステーション");

      visitNursingFacilitiesDivisionRadioItem1.setGroup(getVisitNursingFacilitiesDivisionRadio());

      visitNursingFacilitiesDivisionRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addVisitNursingFacilitiesDivisionRadioItem1();
    }
    return visitNursingFacilitiesDivisionRadioItem1;

  }

  /**
   * 病院又は診療所を取得します。
   * @return 病院又は診療所
   */
  public ACRadioButtonItem getVisitNursingFacilitiesDivisionRadioItem2(){
    if(visitNursingFacilitiesDivisionRadioItem2==null){

      visitNursingFacilitiesDivisionRadioItem2 = new ACRadioButtonItem();

      visitNursingFacilitiesDivisionRadioItem2.setText("病院又は診療所");

      visitNursingFacilitiesDivisionRadioItem2.setGroup(getVisitNursingFacilitiesDivisionRadio());

      visitNursingFacilitiesDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addVisitNursingFacilitiesDivisionRadioItem2();
    }
    return visitNursingFacilitiesDivisionRadioItem2;

  }

  /**
   * 職員区分を取得します。
   * @return 職員区分
   */
  public ACValueArrayRadioButtonGroup getVisitNursingStaffDivisionRadio(){
    if(visitNursingStaffDivisionRadio==null){

      visitNursingStaffDivisionRadio = new ACValueArrayRadioButtonGroup();

      getVisitNursingStaffDivisionRadioContainer().setText("職員区分");

      visitNursingStaffDivisionRadio.setBindPath("1330111");

      visitNursingStaffDivisionRadio.setUseClearButton(false);

      visitNursingStaffDivisionRadio.setModel(getVisitNursingStaffDivisionRadioModel());

      visitNursingStaffDivisionRadio.setValues(new int[]{1,2});

      addVisitNursingStaffDivisionRadio();
    }
    return visitNursingStaffDivisionRadio;

  }

  /**
   * 職員区分コンテナを取得します。
   * @return 職員区分コンテナ
   */
  protected ACLabelContainer getVisitNursingStaffDivisionRadioContainer(){
    if(visitNursingStaffDivisionRadioContainer==null){
      visitNursingStaffDivisionRadioContainer = new ACLabelContainer();
      visitNursingStaffDivisionRadioContainer.setFollowChildEnabled(true);
      visitNursingStaffDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      visitNursingStaffDivisionRadioContainer.add(getVisitNursingStaffDivisionRadio(), null);
    }
    return visitNursingStaffDivisionRadioContainer;
  }

  /**
   * 職員区分モデルを取得します。
   * @return 職員区分モデル
   */
  protected ACListModelAdapter getVisitNursingStaffDivisionRadioModel(){
    if(visitNursingStaffDivisionRadioModel==null){
      visitNursingStaffDivisionRadioModel = new ACListModelAdapter();
      addVisitNursingStaffDivisionRadioModel();
    }
    return visitNursingStaffDivisionRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getVisitNursingStaffDivisionRadioItem1(){
    if(visitNursingStaffDivisionRadioItem1==null){

      visitNursingStaffDivisionRadioItem1 = new ACRadioButtonItem();

      visitNursingStaffDivisionRadioItem1.setText("なし");

      visitNursingStaffDivisionRadioItem1.setGroup(getVisitNursingStaffDivisionRadio());

      visitNursingStaffDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addVisitNursingStaffDivisionRadioItem1();
    }
    return visitNursingStaffDivisionRadioItem1;

  }

  /**
   * PT,OT,STを取得します。
   * @return PT,OT,ST
   */
  public ACRadioButtonItem getVisitNursingStaffDivisionRadioItem2(){
    if(visitNursingStaffDivisionRadioItem2==null){

      visitNursingStaffDivisionRadioItem2 = new ACRadioButtonItem();

      visitNursingStaffDivisionRadioItem2.setText("PT,OT,ST");

      visitNursingStaffDivisionRadioItem2.setGroup(getVisitNursingStaffDivisionRadio());

      visitNursingStaffDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addVisitNursingStaffDivisionRadioItem2();
    }
    return visitNursingStaffDivisionRadioItem2;

  }

  /**
   * 1日に2回を越えて実施を取得します。
   * @return 1日に2回を越えて実施
   */
  public ACIntegerCheckBox getTwoOrMoreTimesCheck(){
    if(twoOrMoreTimesCheck==null){

      twoOrMoreTimesCheck = new ACIntegerCheckBox();

      twoOrMoreTimesCheck.setText("1日に2回を越えて実施");

      twoOrMoreTimesCheck.setBindPath("1330129");

      twoOrMoreTimesCheck.setSelectValue(2);

      twoOrMoreTimesCheck.setUnSelectValue(1);

      addTwoOrMoreTimesCheck();
    }
    return twoOrMoreTimesCheck;

  }

  /**
   * 時間区分コンボを取得します。
   * @return 時間区分コンボ
   */
  public ACComboBox getVisitNursingCombo(){
    if(visitNursingCombo==null){

      visitNursingCombo = new ACComboBox();

      getVisitNursingComboContainer().setText("時間区分");

      visitNursingCombo.setBindPath("1330112");

      visitNursingCombo.setEditable(false);

      visitNursingCombo.setModelBindPath("1330112");

      visitNursingCombo.setRenderBindPath("CONTENT");

      visitNursingCombo.setModel(getVisitNursingComboModel());

      addVisitNursingCombo();
    }
    return visitNursingCombo;

  }

  /**
   * 時間区分コンボコンテナを取得します。
   * @return 時間区分コンボコンテナ
   */
  protected ACLabelContainer getVisitNursingComboContainer(){
    if(visitNursingComboContainer==null){
      visitNursingComboContainer = new ACLabelContainer();
      visitNursingComboContainer.setFollowChildEnabled(true);
      visitNursingComboContainer.setVAlignment(VRLayout.CENTER);
      visitNursingComboContainer.add(getVisitNursingCombo(), null);
    }
    return visitNursingComboContainer;
  }

  /**
   * 時間区分コンボモデルを取得します。
   * @return 時間区分コンボモデル
   */
  protected ACComboBoxModelAdapter getVisitNursingComboModel(){
    if(visitNursingComboModel==null){
      visitNursingComboModel = new ACComboBoxModelAdapter();
      addVisitNursingComboModel();
    }
    return visitNursingComboModel;
  }

  /**
   * 看護職員区分を取得します。
   * @return 看護職員区分
   */
  public ACValueArrayRadioButtonGroup getNurseStaffDivisionRadioGroup(){
    if(nurseStaffDivisionRadioGroup==null){

      nurseStaffDivisionRadioGroup = new ACValueArrayRadioButtonGroup();

      getNurseStaffDivisionRadioGroupContainer().setText("看護職員区分");

      nurseStaffDivisionRadioGroup.setBindPath("1330132");

      nurseStaffDivisionRadioGroup.setUseClearButton(false);

      nurseStaffDivisionRadioGroup.setModel(getNurseStaffDivisionRadioGroupModel());

      nurseStaffDivisionRadioGroup.setValues(new int[]{1,2});

      addNurseStaffDivisionRadioGroup();
    }
    return nurseStaffDivisionRadioGroup;

  }

  /**
   * 看護職員区分コンテナを取得します。
   * @return 看護職員区分コンテナ
   */
  protected ACLabelContainer getNurseStaffDivisionRadioGroupContainer(){
    if(nurseStaffDivisionRadioGroupContainer==null){
      nurseStaffDivisionRadioGroupContainer = new ACLabelContainer();
      nurseStaffDivisionRadioGroupContainer.setFollowChildEnabled(true);
      nurseStaffDivisionRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      nurseStaffDivisionRadioGroupContainer.add(getNurseStaffDivisionRadioGroup(), null);
    }
    return nurseStaffDivisionRadioGroupContainer;
  }

  /**
   * 看護職員区分モデルを取得します。
   * @return 看護職員区分モデル
   */
  protected ACListModelAdapter getNurseStaffDivisionRadioGroupModel(){
    if(nurseStaffDivisionRadioGroupModel==null){
      nurseStaffDivisionRadioGroupModel = new ACListModelAdapter();
      addNurseStaffDivisionRadioGroupModel();
    }
    return nurseStaffDivisionRadioGroupModel;
  }

  /**
   * 正看等を取得します。
   * @return 正看等
   */
  public ACRadioButtonItem getNurseStaffDivisionRadioItem1(){
    if(nurseStaffDivisionRadioItem1==null){

      nurseStaffDivisionRadioItem1 = new ACRadioButtonItem();

      nurseStaffDivisionRadioItem1.setText("正看等");

      nurseStaffDivisionRadioItem1.setGroup(getNurseStaffDivisionRadioGroup());

      nurseStaffDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addNurseStaffDivisionRadioItem1();
    }
    return nurseStaffDivisionRadioItem1;

  }

  /**
   * 准看を取得します。
   * @return 准看
   */
  public ACRadioButtonItem getNurseStaffDivisionRadioItem2(){
    if(nurseStaffDivisionRadioItem2==null){

      nurseStaffDivisionRadioItem2 = new ACRadioButtonItem();

      nurseStaffDivisionRadioItem2.setText("准看");

      nurseStaffDivisionRadioItem2.setGroup(getNurseStaffDivisionRadioGroup());

      nurseStaffDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addNurseStaffDivisionRadioItem2();
    }
    return nurseStaffDivisionRadioItem2;

  }

  /**
   * 訪問リハグループを取得します。
   * @return 訪問リハグループ
   */
  public ACGroupBox getVisitRehabiliGroup(){
    if(visitRehabiliGroup==null){

      visitRehabiliGroup = new ACGroupBox();

      visitRehabiliGroup.setText("訪問リハ");

      visitRehabiliGroup.setFollowChildEnabled(true);

      addVisitRehabiliGroup();
    }
    return visitRehabiliGroup;

  }

  /**
   * 施設等の区分を取得します。
   * @return 施設等の区分
   */
  public ACValueArrayRadioButtonGroup getVisitRehabiliRadio(){
    if(visitRehabiliRadio==null){

      visitRehabiliRadio = new ACValueArrayRadioButtonGroup();

      getVisitRehabiliRadioContainer().setText("施設等の区分");

      visitRehabiliRadio.setBindPath("1330113");

      visitRehabiliRadio.setUseClearButton(false);

      visitRehabiliRadio.setModel(getVisitRehabiliRadioModel());

      visitRehabiliRadio.setValues(new int[]{1,2});

      addVisitRehabiliRadio();
    }
    return visitRehabiliRadio;

  }

  /**
   * 施設等の区分コンテナを取得します。
   * @return 施設等の区分コンテナ
   */
  protected ACLabelContainer getVisitRehabiliRadioContainer(){
    if(visitRehabiliRadioContainer==null){
      visitRehabiliRadioContainer = new ACLabelContainer();
      visitRehabiliRadioContainer.setFollowChildEnabled(true);
      visitRehabiliRadioContainer.setVAlignment(VRLayout.CENTER);
      visitRehabiliRadioContainer.add(getVisitRehabiliRadio(), null);
    }
    return visitRehabiliRadioContainer;
  }

  /**
   * 施設等の区分モデルを取得します。
   * @return 施設等の区分モデル
   */
  protected ACListModelAdapter getVisitRehabiliRadioModel(){
    if(visitRehabiliRadioModel==null){
      visitRehabiliRadioModel = new ACListModelAdapter();
      addVisitRehabiliRadioModel();
    }
    return visitRehabiliRadioModel;
  }

  /**
   * 病院又は診療所を取得します。
   * @return 病院又は診療所
   */
  public ACRadioButtonItem getVisitRehabiliRadioItem1(){
    if(visitRehabiliRadioItem1==null){

      visitRehabiliRadioItem1 = new ACRadioButtonItem();

      visitRehabiliRadioItem1.setText("病院又は診療所");

      visitRehabiliRadioItem1.setGroup(getVisitRehabiliRadio());

      visitRehabiliRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addVisitRehabiliRadioItem1();
    }
    return visitRehabiliRadioItem1;

  }

  /**
   * 介護老人保健施設を取得します。
   * @return 介護老人保健施設
   */
  public ACRadioButtonItem getVisitRehabiliRadioItem2(){
    if(visitRehabiliRadioItem2==null){

      visitRehabiliRadioItem2 = new ACRadioButtonItem();

      visitRehabiliRadioItem2.setText("介護老人保健施設");

      visitRehabiliRadioItem2.setGroup(getVisitRehabiliRadio());

      visitRehabiliRadioItem2.setConstraints(VRLayout.FLOW);

      addVisitRehabiliRadioItem2();
    }
    return visitRehabiliRadioItem2;

  }

  /**
   * タブパネル5を取得します。
   * @return タブパネル5
   */
  public ACPanel getTabPanel5(){
    if(tabPanel5==null){

      tabPanel5 = new ACPanel();

      tabPanel5.setFollowChildEnabled(true);

      tabPanel5.setHgap(0);

      addTabPanel5();
    }
    return tabPanel5;

  }

  /**
   * 通所介護グループを取得します。
   * @return 通所介護グループ
   */
  public ACGroupBox getExpertPlaceNursingGroup(){
    if(expertPlaceNursingGroup==null){

      expertPlaceNursingGroup = new ACGroupBox();

      expertPlaceNursingGroup.setText("通所介護");

      expertPlaceNursingGroup.setFollowChildEnabled(true);

      addExpertPlaceNursingGroup();
    }
    return expertPlaceNursingGroup;

  }

  /**
   * 施設等の区分を取得します。
   * @return 施設等の区分
   */
  public ACValueArrayRadioButtonGroup getExpertPlaceNursingRadio(){
    if(expertPlaceNursingRadio==null){

      expertPlaceNursingRadio = new ACValueArrayRadioButtonGroup();

      getExpertPlaceNursingRadioContainer().setText("施設等の区分");

      expertPlaceNursingRadio.setBindPath("1330126");

      expertPlaceNursingRadio.setUseClearButton(false);

      expertPlaceNursingRadio.setModel(getExpertPlaceNursingRadioModel());

      expertPlaceNursingRadio.setValues(new int[]{1,2,3,4,5});

      addExpertPlaceNursingRadio();
    }
    return expertPlaceNursingRadio;

  }

  /**
   * 施設等の区分コンテナを取得します。
   * @return 施設等の区分コンテナ
   */
  protected ACLabelContainer getExpertPlaceNursingRadioContainer(){
    if(expertPlaceNursingRadioContainer==null){
      expertPlaceNursingRadioContainer = new ACLabelContainer();
      expertPlaceNursingRadioContainer.setFollowChildEnabled(true);
      expertPlaceNursingRadioContainer.setVAlignment(VRLayout.CENTER);
      expertPlaceNursingRadioContainer.add(getExpertPlaceNursingRadio(), null);
    }
    return expertPlaceNursingRadioContainer;
  }

  /**
   * 施設等の区分モデルを取得します。
   * @return 施設等の区分モデル
   */
  protected ACListModelAdapter getExpertPlaceNursingRadioModel(){
    if(expertPlaceNursingRadioModel==null){
      expertPlaceNursingRadioModel = new ACListModelAdapter();
      addExpertPlaceNursingRadioModel();
    }
    return expertPlaceNursingRadioModel;
  }

  /**
   * 小規模事業所を取得します。
   * @return 小規模事業所
   */
  public ACRadioButtonItem getExpertPlaceNursingRadioItem1(){
    if(expertPlaceNursingRadioItem1==null){

      expertPlaceNursingRadioItem1 = new ACRadioButtonItem();

      expertPlaceNursingRadioItem1.setText("小規模事業所（H28.4廃止）");

      expertPlaceNursingRadioItem1.setGroup(getExpertPlaceNursingRadio());

      expertPlaceNursingRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addExpertPlaceNursingRadioItem1();
    }
    return expertPlaceNursingRadioItem1;

  }

  /**
   * 通常規模事業所を取得します。
   * @return 通常規模事業所
   */
  public ACRadioButtonItem getExpertPlaceNursingRadioItem2(){
    if(expertPlaceNursingRadioItem2==null){

      expertPlaceNursingRadioItem2 = new ACRadioButtonItem();

      expertPlaceNursingRadioItem2.setText("通常規模事業所");

      expertPlaceNursingRadioItem2.setGroup(getExpertPlaceNursingRadio());

      expertPlaceNursingRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addExpertPlaceNursingRadioItem2();
    }
    return expertPlaceNursingRadioItem2;

  }

  /**
   * 大規模事業所 Iを取得します。
   * @return 大規模事業所 I
   */
  public ACRadioButtonItem getExpertPlaceNursingRadioItem3(){
    if(expertPlaceNursingRadioItem3==null){

      expertPlaceNursingRadioItem3 = new ACRadioButtonItem();

      expertPlaceNursingRadioItem3.setText("大規模事業所 I");

      expertPlaceNursingRadioItem3.setGroup(getExpertPlaceNursingRadio());

      expertPlaceNursingRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addExpertPlaceNursingRadioItem3();
    }
    return expertPlaceNursingRadioItem3;

  }

  /**
   * 大規模事業所 IIを取得します。
   * @return 大規模事業所 II
   */
  public ACRadioButtonItem getExpertPlaceNursingRadioItem4(){
    if(expertPlaceNursingRadioItem4==null){

      expertPlaceNursingRadioItem4 = new ACRadioButtonItem();

      expertPlaceNursingRadioItem4.setText("大規模事業所 II");

      expertPlaceNursingRadioItem4.setGroup(getExpertPlaceNursingRadio());

      expertPlaceNursingRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addExpertPlaceNursingRadioItem4();
    }
    return expertPlaceNursingRadioItem4;

  }

  /**
   * 療養通所を取得します。
   * @return 療養通所
   */
  public ACRadioButtonItem getExpertPlaceNursingRadioItem5(){
    if(expertPlaceNursingRadioItem5==null){

      expertPlaceNursingRadioItem5 = new ACRadioButtonItem();

      expertPlaceNursingRadioItem5.setText("療養通所（H28.4廃止）");

      expertPlaceNursingRadioItem5.setGroup(getExpertPlaceNursingRadio());

      expertPlaceNursingRadioItem5.setConstraints(VRLayout.FLOW);

      addExpertPlaceNursingRadioItem5();
    }
    return expertPlaceNursingRadioItem5;

  }

  /**
   * 時間区分コンボを取得します。
   * @return 時間区分コンボ
   */
  public ACComboBox getExpertPlaceNursingCombo(){
    if(expertPlaceNursingCombo==null){

      expertPlaceNursingCombo = new ACComboBox();

      getExpertPlaceNursingComboContainer().setText("時間区分");

      expertPlaceNursingCombo.setBindPath("1330115");

      expertPlaceNursingCombo.setEditable(false);

      expertPlaceNursingCombo.setModelBindPath("1330115");

      expertPlaceNursingCombo.setRenderBindPath("CONTENT");

      expertPlaceNursingCombo.setModel(getExpertPlaceNursingComboModel());

      addExpertPlaceNursingCombo();
    }
    return expertPlaceNursingCombo;

  }

  /**
   * 時間区分コンボコンテナを取得します。
   * @return 時間区分コンボコンテナ
   */
  protected ACLabelContainer getExpertPlaceNursingComboContainer(){
    if(expertPlaceNursingComboContainer==null){
      expertPlaceNursingComboContainer = new ACLabelContainer();
      expertPlaceNursingComboContainer.setFollowChildEnabled(true);
      expertPlaceNursingComboContainer.setVAlignment(VRLayout.CENTER);
      expertPlaceNursingComboContainer.add(getExpertPlaceNursingCombo(), null);
    }
    return expertPlaceNursingComboContainer;
  }

  /**
   * 時間区分コンボモデルを取得します。
   * @return 時間区分コンボモデル
   */
  protected ACComboBoxModelAdapter getExpertPlaceNursingComboModel(){
    if(expertPlaceNursingComboModel==null){
      expertPlaceNursingComboModel = new ACComboBoxModelAdapter();
      addExpertPlaceNursingComboModel();
    }
    return expertPlaceNursingComboModel;
  }

  /**
   * タブパネル6を取得します。
   * @return タブパネル6
   */
  public ACPanel getTabPanel6(){
    if(tabPanel6==null){

      tabPanel6 = new ACPanel();

      tabPanel6.setFollowChildEnabled(true);

      tabPanel6.setHgap(0);

      addTabPanel6();
    }
    return tabPanel6;

  }

  /**
   * 通所リハグループを取得します。
   * @return 通所リハグループ
   */
  public ACGroupBox getExpertPlaceRehabiliGroup(){
    if(expertPlaceRehabiliGroup==null){

      expertPlaceRehabiliGroup = new ACGroupBox();

      expertPlaceRehabiliGroup.setText("通所リハ");

      expertPlaceRehabiliGroup.setFollowChildEnabled(true);

      addExpertPlaceRehabiliGroup();
    }
    return expertPlaceRehabiliGroup;

  }

  /**
   * 施設等の区分を取得します。
   * @return 施設等の区分
   */
  public ACValueArrayRadioButtonGroup getExpertPlaceRehabiliRadio(){
    if(expertPlaceRehabiliRadio==null){

      expertPlaceRehabiliRadio = new ACValueArrayRadioButtonGroup();

      getExpertPlaceRehabiliRadioContainer().setText("施設等の区分");

      expertPlaceRehabiliRadio.setBindPath("1330127");

      expertPlaceRehabiliRadio.setUseClearButton(false);

      expertPlaceRehabiliRadio.setModel(getExpertPlaceRehabiliRadioModel());

      expertPlaceRehabiliRadio.setValues(new int[]{1,2,3,4,5,6});

      addExpertPlaceRehabiliRadio();
    }
    return expertPlaceRehabiliRadio;

  }

  /**
   * 施設等の区分コンテナを取得します。
   * @return 施設等の区分コンテナ
   */
  protected ACLabelContainer getExpertPlaceRehabiliRadioContainer(){
    if(expertPlaceRehabiliRadioContainer==null){
      expertPlaceRehabiliRadioContainer = new ACLabelContainer();
      expertPlaceRehabiliRadioContainer.setFollowChildEnabled(true);
      expertPlaceRehabiliRadioContainer.setVAlignment(VRLayout.CENTER);
      expertPlaceRehabiliRadioContainer.add(getExpertPlaceRehabiliRadio(), null);
    }
    return expertPlaceRehabiliRadioContainer;
  }

  /**
   * 施設等の区分モデルを取得します。
   * @return 施設等の区分モデル
   */
  protected ACListModelAdapter getExpertPlaceRehabiliRadioModel(){
    if(expertPlaceRehabiliRadioModel==null){
      expertPlaceRehabiliRadioModel = new ACListModelAdapter();
      addExpertPlaceRehabiliRadioModel();
    }
    return expertPlaceRehabiliRadioModel;
  }

  /**
   * 通常規模事業所（病院・診療所）を取得します。
   * @return 通常規模事業所（病院・診療所）
   */
  public ACRadioButtonItem getExpertPlaceRehabiliRadioItem1(){
    if(expertPlaceRehabiliRadioItem1==null){

      expertPlaceRehabiliRadioItem1 = new ACRadioButtonItem();

      expertPlaceRehabiliRadioItem1.setText("通常規模事業所（病院・診療所）");

      expertPlaceRehabiliRadioItem1.setGroup(getExpertPlaceRehabiliRadio());

      expertPlaceRehabiliRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addExpertPlaceRehabiliRadioItem1();
    }
    return expertPlaceRehabiliRadioItem1;

  }

  /**
   * 通常規模事業所（介護老人保健施設）を取得します。
   * @return 通常規模事業所（介護老人保健施設）
   */
  public ACRadioButtonItem getExpertPlaceRehabiliRadioItem2(){
    if(expertPlaceRehabiliRadioItem2==null){

      expertPlaceRehabiliRadioItem2 = new ACRadioButtonItem();

      expertPlaceRehabiliRadioItem2.setText("通常規模事業所（介護老人保健施設）");

      expertPlaceRehabiliRadioItem2.setGroup(getExpertPlaceRehabiliRadio());

      expertPlaceRehabiliRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addExpertPlaceRehabiliRadioItem2();
    }
    return expertPlaceRehabiliRadioItem2;

  }

  /**
   * 大規模事業所 I（病院・診療所）を取得します。
   * @return 大規模事業所 I（病院・診療所）
   */
  public ACRadioButtonItem getExpertPlaceRehabiliRadioItem3(){
    if(expertPlaceRehabiliRadioItem3==null){

      expertPlaceRehabiliRadioItem3 = new ACRadioButtonItem();

      expertPlaceRehabiliRadioItem3.setText("大規模事業所 I（病院・診療所）");

      expertPlaceRehabiliRadioItem3.setGroup(getExpertPlaceRehabiliRadio());

      expertPlaceRehabiliRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addExpertPlaceRehabiliRadioItem3();
    }
    return expertPlaceRehabiliRadioItem3;

  }

  /**
   * 大規模事業所 I（介護老人保健施設）を取得します。
   * @return 大規模事業所 I（介護老人保健施設）
   */
  public ACRadioButtonItem getExpertPlaceRehabiliRadioItem4(){
    if(expertPlaceRehabiliRadioItem4==null){

      expertPlaceRehabiliRadioItem4 = new ACRadioButtonItem();

      expertPlaceRehabiliRadioItem4.setText("大規模事業所 I（介護老人保健施設）");

      expertPlaceRehabiliRadioItem4.setGroup(getExpertPlaceRehabiliRadio());

      expertPlaceRehabiliRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addExpertPlaceRehabiliRadioItem4();
    }
    return expertPlaceRehabiliRadioItem4;

  }

  /**
   * 大規模事業所 II（病院・診療所）を取得します。
   * @return 大規模事業所 II（病院・診療所）
   */
  public ACRadioButtonItem getExpertPlaceRehabiliRadioItem5(){
    if(expertPlaceRehabiliRadioItem5==null){

      expertPlaceRehabiliRadioItem5 = new ACRadioButtonItem();

      expertPlaceRehabiliRadioItem5.setText("大規模事業所 II（病院・診療所）");

      expertPlaceRehabiliRadioItem5.setGroup(getExpertPlaceRehabiliRadio());

      expertPlaceRehabiliRadioItem5.setConstraints(VRLayout.FLOW_RETURN);

      addExpertPlaceRehabiliRadioItem5();
    }
    return expertPlaceRehabiliRadioItem5;

  }

  /**
   * 大規模事業所 II（介護老人保健施設）を取得します。
   * @return 大規模事業所 II（介護老人保健施設）
   */
  public ACRadioButtonItem getExpertPlaceRehabiliRadioItem6(){
    if(expertPlaceRehabiliRadioItem6==null){

      expertPlaceRehabiliRadioItem6 = new ACRadioButtonItem();

      expertPlaceRehabiliRadioItem6.setText("大規模事業所 II（介護老人保健施設）");

      expertPlaceRehabiliRadioItem6.setGroup(getExpertPlaceRehabiliRadio());

      expertPlaceRehabiliRadioItem6.setConstraints(VRLayout.FLOW);

      addExpertPlaceRehabiliRadioItem6();
    }
    return expertPlaceRehabiliRadioItem6;

  }

  /**
   * 時間区分コンボを取得します。
   * @return 時間区分コンボ
   */
  public ACComboBox getExpertPlaceRehabiliCombo(){
    if(expertPlaceRehabiliCombo==null){

      expertPlaceRehabiliCombo = new ACComboBox();

      getExpertPlaceRehabiliComboContainer().setText("時間区分");

      expertPlaceRehabiliCombo.setBindPath("1330117");

      expertPlaceRehabiliCombo.setEditable(false);

      expertPlaceRehabiliCombo.setModelBindPath("1330117");

      expertPlaceRehabiliCombo.setRenderBindPath("CONTENT");

      expertPlaceRehabiliCombo.setModel(getExpertPlaceRehabiliComboModel());

      addExpertPlaceRehabiliCombo();
    }
    return expertPlaceRehabiliCombo;

  }

  /**
   * 時間区分コンボコンテナを取得します。
   * @return 時間区分コンボコンテナ
   */
  protected ACLabelContainer getExpertPlaceRehabiliComboContainer(){
    if(expertPlaceRehabiliComboContainer==null){
      expertPlaceRehabiliComboContainer = new ACLabelContainer();
      expertPlaceRehabiliComboContainer.setFollowChildEnabled(true);
      expertPlaceRehabiliComboContainer.setVAlignment(VRLayout.CENTER);
      expertPlaceRehabiliComboContainer.add(getExpertPlaceRehabiliCombo(), null);
    }
    return expertPlaceRehabiliComboContainer;
  }

  /**
   * 時間区分コンボモデルを取得します。
   * @return 時間区分コンボモデル
   */
  protected ACComboBoxModelAdapter getExpertPlaceRehabiliComboModel(){
    if(expertPlaceRehabiliComboModel==null){
      expertPlaceRehabiliComboModel = new ACComboBoxModelAdapter();
      addExpertPlaceRehabiliComboModel();
    }
    return expertPlaceRehabiliComboModel;
  }

  /**
   * タブパネル7を取得します。
   * @return タブパネル7
   */
  public ACPanel getTabPanel7(){
    if(tabPanel7==null){

      tabPanel7 = new ACPanel();

      tabPanel7.setFollowChildEnabled(true);

      tabPanel7.setHgap(0);

      addTabPanel7();
    }
    return tabPanel7;

  }

  /**
   * 福祉用具貸与グループを取得します。
   * @return 福祉用具貸与グループ
   */
  public ACGroupBox getWelfareToolsGroup(){
    if(welfareToolsGroup==null){

      welfareToolsGroup = new ACGroupBox();

      welfareToolsGroup.setText("福祉用具貸与");

      welfareToolsGroup.setFollowChildEnabled(true);

      addWelfareToolsGroup();
    }
    return welfareToolsGroup;

  }

  /**
   * 用具を取得します。
   * @return 用具
   */
  public ACComboBox getWelfareToolsCombo(){
    if(welfareToolsCombo==null){

      welfareToolsCombo = new ACComboBox();

      getWelfareToolsComboContainer().setText("用具");

      welfareToolsCombo.setBindPath("1330118");

      welfareToolsCombo.setEditable(false);

      welfareToolsCombo.setColumns(4);

      welfareToolsCombo.setModelBindPath("1330118");

      welfareToolsCombo.setRenderBindPath("CONTENT");

      welfareToolsCombo.setModel(getWelfareToolsComboModel());

      addWelfareToolsCombo();
    }
    return welfareToolsCombo;

  }

  /**
   * 用具コンテナを取得します。
   * @return 用具コンテナ
   */
  protected ACLabelContainer getWelfareToolsComboContainer(){
    if(welfareToolsComboContainer==null){
      welfareToolsComboContainer = new ACLabelContainer();
      welfareToolsComboContainer.setFollowChildEnabled(true);
      welfareToolsComboContainer.setVAlignment(VRLayout.CENTER);
      welfareToolsComboContainer.add(getWelfareToolsCombo(), null);
    }
    return welfareToolsComboContainer;
  }

  /**
   * 用具モデルを取得します。
   * @return 用具モデル
   */
  protected ACComboBoxModelAdapter getWelfareToolsComboModel(){
    if(welfareToolsComboModel==null){
      welfareToolsComboModel = new ACComboBoxModelAdapter();
      addWelfareToolsComboModel();
    }
    return welfareToolsComboModel;
  }

  /**
   * 単価を取得します。
   * @return 単価
   */
  public ACTextField getWelfarePointText(){
    if(welfarePointText==null){

      welfarePointText = new ACTextField();

      getWelfarePointTextContainer().setText("単価");

      welfarePointText.setBindPath("1330119");

      welfarePointText.setColumns(4);

      welfarePointText.setCharType(VRCharType.ONLY_DIGIT);

      welfarePointText.setIMEMode(InputSubset.LATIN);

      welfarePointText.setMaxLength(6);

      addWelfarePointText();
    }
    return welfarePointText;

  }

  /**
   * 単価コンテナを取得します。
   * @return 単価コンテナ
   */
  protected ACLabelContainer getWelfarePointTextContainer(){
    if(welfarePointTextContainer==null){
      welfarePointTextContainer = new ACLabelContainer();
      welfarePointTextContainer.setFollowChildEnabled(true);
      welfarePointTextContainer.setVAlignment(VRLayout.CENTER);
      welfarePointTextContainer.add(getWelfarePointText(), null);
    }
    return welfarePointTextContainer;
  }

  /**
   * 摘要を取得します。
   * @return 摘要
   */
  public ACTextField getWelfareTekiyoText(){
    if(welfareTekiyoText==null){

      welfareTekiyoText = new ACTextField();

      getWelfareTekiyoTextContainer().setText("摘要");

      welfareTekiyoText.setBindPath("1330120");

      welfareTekiyoText.setColumns(15);

      welfareTekiyoText.setCharType(VRCharType.ONLY_HALF_CHAR);

      welfareTekiyoText.setHorizontalAlignment(SwingConstants.LEFT);

      welfareTekiyoText.setIMEMode(InputSubset.LATIN);

      welfareTekiyoText.setMaxLength(20);

      addWelfareTekiyoText();
    }
    return welfareTekiyoText;

  }

  /**
   * 摘要コンテナを取得します。
   * @return 摘要コンテナ
   */
  protected ACLabelContainer getWelfareTekiyoTextContainer(){
    if(welfareTekiyoTextContainer==null){
      welfareTekiyoTextContainer = new ACLabelContainer();
      welfareTekiyoTextContainer.setFollowChildEnabled(true);
      welfareTekiyoTextContainer.setVAlignment(VRLayout.CENTER);
      welfareTekiyoTextContainer.add(getWelfareTekiyoText(), null);
    }
    return welfareTekiyoTextContainer;
  }

  /**
   * 認知症対応型通所介護グループを取得します。
   * @return 認知症対応型通所介護グループ
   */
  public ACGroupBox getNinchishoTaioTsushoGroup(){
    if(ninchishoTaioTsushoGroup==null){

      ninchishoTaioTsushoGroup = new ACGroupBox();

      ninchishoTaioTsushoGroup.setText("認知症対応型通所介護");

      ninchishoTaioTsushoGroup.setFollowChildEnabled(true);

      addNinchishoTaioTsushoGroup();
    }
    return ninchishoTaioTsushoGroup;

  }

  /**
   * 施設等の区分1を取得します。
   * @return 施設等の区分1
   */
  public ACValueArrayRadioButtonGroup getProviderDivisionRadio(){
    if(providerDivisionRadio==null){

      providerDivisionRadio = new ACValueArrayRadioButtonGroup();

      getProviderDivisionRadioContainer().setText("施設等の区分1");

      providerDivisionRadio.setBindPath("1330121");

      providerDivisionRadio.setUseClearButton(false);

      providerDivisionRadio.setModel(getProviderDivisionRadioModel());

      providerDivisionRadio.setValues(new int[]{1,2});

      addProviderDivisionRadio();
    }
    return providerDivisionRadio;

  }

  /**
   * 施設等の区分1コンテナを取得します。
   * @return 施設等の区分1コンテナ
   */
  protected ACLabelContainer getProviderDivisionRadioContainer(){
    if(providerDivisionRadioContainer==null){
      providerDivisionRadioContainer = new ACLabelContainer();
      providerDivisionRadioContainer.setFollowChildEnabled(true);
      providerDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      providerDivisionRadioContainer.add(getProviderDivisionRadio(), null);
    }
    return providerDivisionRadioContainer;
  }

  /**
   * 施設等の区分1モデルを取得します。
   * @return 施設等の区分1モデル
   */
  protected ACListModelAdapter getProviderDivisionRadioModel(){
    if(providerDivisionRadioModel==null){
      providerDivisionRadioModel = new ACListModelAdapter();
      addProviderDivisionRadioModel();
    }
    return providerDivisionRadioModel;
  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getProviderDivisionRadioItem1(){
    if(providerDivisionRadioItem1==null){

      providerDivisionRadioItem1 = new ACRadioButtonItem();

      providerDivisionRadioItem1.setText("I型");

      providerDivisionRadioItem1.setGroup(getProviderDivisionRadio());

      providerDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addProviderDivisionRadioItem1();
    }
    return providerDivisionRadioItem1;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getProviderDivisionRadioItem2(){
    if(providerDivisionRadioItem2==null){

      providerDivisionRadioItem2 = new ACRadioButtonItem();

      providerDivisionRadioItem2.setText("II型");

      providerDivisionRadioItem2.setGroup(getProviderDivisionRadio());

      providerDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addProviderDivisionRadioItem2();
    }
    return providerDivisionRadioItem2;

  }

  /**
   * 施設等の区分2を取得します。
   * @return 施設等の区分2
   */
  public ACValueArrayRadioButtonGroup getDivisionRadion(){
    if(divisionRadion==null){

      divisionRadion = new ACValueArrayRadioButtonGroup();

      getDivisionRadionContainer().setText("施設等の区分2");

      divisionRadion.setBindPath("1330122");

      divisionRadion.setUseClearButton(false);

      divisionRadion.setModel(getDivisionRadionModel());

      divisionRadion.setValues(new int[]{1,2});

      addDivisionRadion();
    }
    return divisionRadion;

  }

  /**
   * 施設等の区分2コンテナを取得します。
   * @return 施設等の区分2コンテナ
   */
  protected ACLabelContainer getDivisionRadionContainer(){
    if(divisionRadionContainer==null){
      divisionRadionContainer = new ACLabelContainer();
      divisionRadionContainer.setFollowChildEnabled(true);
      divisionRadionContainer.setVAlignment(VRLayout.CENTER);
      divisionRadionContainer.add(getDivisionRadion(), null);
    }
    return divisionRadionContainer;
  }

  /**
   * 施設等の区分2モデルを取得します。
   * @return 施設等の区分2モデル
   */
  protected ACListModelAdapter getDivisionRadionModel(){
    if(divisionRadionModel==null){
      divisionRadionModel = new ACListModelAdapter();
      addDivisionRadionModel();
    }
    return divisionRadionModel;
  }

  /**
   * 単独型を取得します。
   * @return 単独型
   */
  public ACRadioButtonItem getDivisionRadionitem1(){
    if(divisionRadionitem1==null){

      divisionRadionitem1 = new ACRadioButtonItem();

      divisionRadionitem1.setText("単独型");

      divisionRadionitem1.setGroup(getDivisionRadion());

      divisionRadionitem1.setConstraints(VRLayout.FLOW);

      addDivisionRadionitem1();
    }
    return divisionRadionitem1;

  }

  /**
   * 併設型を取得します。
   * @return 併設型
   */
  public ACRadioButtonItem getDivisionRadionitem2(){
    if(divisionRadionitem2==null){

      divisionRadionitem2 = new ACRadioButtonItem();

      divisionRadionitem2.setText("併設型");

      divisionRadionitem2.setGroup(getDivisionRadion());

      divisionRadionitem2.setConstraints(VRLayout.FLOW);

      addDivisionRadionitem2();
    }
    return divisionRadionitem2;

  }

  /**
   * 時間区分を取得します。
   * @return 時間区分
   */
  public ACValueArrayRadioButtonGroup getTimeDivisionRadio(){
    if(timeDivisionRadio==null){

      timeDivisionRadio = new ACValueArrayRadioButtonGroup();

      getTimeDivisionRadioContainer().setText("時間区分");

      timeDivisionRadio.setBindPath("1330123");

      timeDivisionRadio.setUseClearButton(false);

      timeDivisionRadio.setModel(getTimeDivisionRadioModel());

      timeDivisionRadio.setValues(new int[]{1,2,3,4});

      addTimeDivisionRadio();
    }
    return timeDivisionRadio;

  }

  /**
   * 時間区分コンテナを取得します。
   * @return 時間区分コンテナ
   */
  protected ACLabelContainer getTimeDivisionRadioContainer(){
    if(timeDivisionRadioContainer==null){
      timeDivisionRadioContainer = new ACLabelContainer();
      timeDivisionRadioContainer.setFollowChildEnabled(true);
      timeDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      timeDivisionRadioContainer.add(getTimeDivisionRadio(), null);
    }
    return timeDivisionRadioContainer;
  }

  /**
   * 時間区分モデルを取得します。
   * @return 時間区分モデル
   */
  protected ACListModelAdapter getTimeDivisionRadioModel(){
    if(timeDivisionRadioModel==null){
      timeDivisionRadioModel = new ACListModelAdapter();
      addTimeDivisionRadioModel();
    }
    return timeDivisionRadioModel;
  }

  /**
   * 2から3時間を取得します。
   * @return 2から3時間
   */
  public ACRadioButtonItem getTimeDivisionRadioItem1(){
    if(timeDivisionRadioItem1==null){

      timeDivisionRadioItem1 = new ACRadioButtonItem();

      timeDivisionRadioItem1.setText("2から3時間");

      timeDivisionRadioItem1.setGroup(getTimeDivisionRadio());

      timeDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addTimeDivisionRadioItem1();
    }
    return timeDivisionRadioItem1;

  }

  /**
   * 3から4時間を取得します。
   * @return 3から4時間
   */
  public ACRadioButtonItem getTimeDivisionRadioItem2(){
    if(timeDivisionRadioItem2==null){

      timeDivisionRadioItem2 = new ACRadioButtonItem();

      timeDivisionRadioItem2.setText("3から5時間");

      timeDivisionRadioItem2.setGroup(getTimeDivisionRadio());

      timeDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addTimeDivisionRadioItem2();
    }
    return timeDivisionRadioItem2;

  }

  /**
   * 4から6時間を取得します。
   * @return 4から6時間
   */
  public ACRadioButtonItem getTimeDivisionRadioItem3(){
    if(timeDivisionRadioItem3==null){

      timeDivisionRadioItem3 = new ACRadioButtonItem();

      timeDivisionRadioItem3.setText("5から7時間");

      timeDivisionRadioItem3.setGroup(getTimeDivisionRadio());

      timeDivisionRadioItem3.setConstraints(VRLayout.FLOW);

      addTimeDivisionRadioItem3();
    }
    return timeDivisionRadioItem3;

  }

  /**
   * 6から8時間を取得します。
   * @return 6から8時間
   */
  public ACRadioButtonItem getTimeDivisionRadioItem4(){
    if(timeDivisionRadioItem4==null){

      timeDivisionRadioItem4 = new ACRadioButtonItem();

      timeDivisionRadioItem4.setText("7から9時間");

      timeDivisionRadioItem4.setGroup(getTimeDivisionRadio());

      timeDivisionRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addTimeDivisionRadioItem4();
    }
    return timeDivisionRadioItem4;

  }

  /**
   * タブパネル8を取得します。
   * @return タブパネル8
   */
  public ACPanel getTabPanel8(){
    if(tabPanel8==null){

      tabPanel8 = new ACPanel();

      tabPanel8.setFollowChildEnabled(true);

      tabPanel8.setHgap(0);

      addTabPanel8();
    }
    return tabPanel8;

  }

  /**
   * 地域密着型通所介護グループを取得します。
   * @return 地域密着型通所介護グループ
   */
  public ACGroupBox getChiikiDayCareGroup(){
    if(chiikiDayCareGroup==null){

      chiikiDayCareGroup = new ACGroupBox();

      chiikiDayCareGroup.setText("地域密着型通所介護");

      chiikiDayCareGroup.setFollowChildEnabled(true);

      addChiikiDayCareGroup();
    }
    return chiikiDayCareGroup;

  }

  /**
   * 施設等の区分を取得します。
   * @return 施設等の区分
   */
  public ACValueArrayRadioButtonGroup getChiikiDayCareRadio(){
    if(chiikiDayCareRadio==null){

      chiikiDayCareRadio = new ACValueArrayRadioButtonGroup();

      getChiikiDayCareRadioContainer().setText("施設等の区分");

      chiikiDayCareRadio.setBindPath("1330134");

      chiikiDayCareRadio.setUseClearButton(false);

      chiikiDayCareRadio.setModel(getChiikiDayCareRadioModel());

      chiikiDayCareRadio.setValues(new int[]{1,2});

      addChiikiDayCareRadio();
    }
    return chiikiDayCareRadio;

  }

  /**
   * 施設等の区分コンテナを取得します。
   * @return 施設等の区分コンテナ
   */
  protected ACLabelContainer getChiikiDayCareRadioContainer(){
    if(chiikiDayCareRadioContainer==null){
      chiikiDayCareRadioContainer = new ACLabelContainer();
      chiikiDayCareRadioContainer.setFollowChildEnabled(true);
      chiikiDayCareRadioContainer.setVAlignment(VRLayout.CENTER);
      chiikiDayCareRadioContainer.add(getChiikiDayCareRadio(), null);
    }
    return chiikiDayCareRadioContainer;
  }

  /**
   * 施設等の区分モデルを取得します。
   * @return 施設等の区分モデル
   */
  protected ACListModelAdapter getChiikiDayCareRadioModel(){
    if(chiikiDayCareRadioModel==null){
      chiikiDayCareRadioModel = new ACListModelAdapter();
      addChiikiDayCareRadioModel();
    }
    return chiikiDayCareRadioModel;
  }

  /**
   * 地域密着型通所介護を取得します。
   * @return 地域密着型通所介護
   */
  public ACRadioButtonItem getChiikiDayCareRadioItem1(){
    if(chiikiDayCareRadioItem1==null){

      chiikiDayCareRadioItem1 = new ACRadioButtonItem();

      chiikiDayCareRadioItem1.setText("地域密着型通所介護");

      chiikiDayCareRadioItem1.setGroup(getChiikiDayCareRadio());

      chiikiDayCareRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addChiikiDayCareRadioItem1();
    }
    return chiikiDayCareRadioItem1;

  }

  /**
   * 療養通所介護を取得します。
   * @return 療養通所介護
   */
  public ACRadioButtonItem getChiikiDayCareRadioItem2(){
    if(chiikiDayCareRadioItem2==null){

      chiikiDayCareRadioItem2 = new ACRadioButtonItem();

      chiikiDayCareRadioItem2.setText("療養通所介護");

      chiikiDayCareRadioItem2.setGroup(getChiikiDayCareRadio());

      chiikiDayCareRadioItem2.setConstraints(VRLayout.FLOW);

      addChiikiDayCareRadioItem2();
    }
    return chiikiDayCareRadioItem2;

  }

  /**
   * 時間区分コンボを取得します。
   * @return 時間区分コンボ
   */
  public ACComboBox getChiikiDayCareCombo(){
    if(chiikiDayCareCombo==null){

      chiikiDayCareCombo = new ACComboBox();

      getChiikiDayCareComboContainer().setText("時間区分");

      chiikiDayCareCombo.setBindPath("1330135");

      chiikiDayCareCombo.setEditable(false);

      chiikiDayCareCombo.setModelBindPath("1330135");

      chiikiDayCareCombo.setRenderBindPath("CONTENT");

      chiikiDayCareCombo.setModel(getChiikiDayCareComboModel());

      addChiikiDayCareCombo();
    }
    return chiikiDayCareCombo;

  }

  /**
   * 時間区分コンボコンテナを取得します。
   * @return 時間区分コンボコンテナ
   */
  protected ACLabelContainer getChiikiDayCareComboContainer(){
    if(chiikiDayCareComboContainer==null){
      chiikiDayCareComboContainer = new ACLabelContainer();
      chiikiDayCareComboContainer.setFollowChildEnabled(true);
      chiikiDayCareComboContainer.setVAlignment(VRLayout.CENTER);
      chiikiDayCareComboContainer.add(getChiikiDayCareCombo(), null);
    }
    return chiikiDayCareComboContainer;
  }

  /**
   * 時間区分コンボモデルを取得します。
   * @return 時間区分コンボモデル
   */
  protected ACComboBoxModelAdapter getChiikiDayCareComboModel(){
    if(chiikiDayCareComboModel==null){
      chiikiDayCareComboModel = new ACComboBoxModelAdapter();
      addChiikiDayCareComboModel();
    }
    return chiikiDayCareComboModel;
  }

  /**
   * コンストラクタです。
   */
  public QS001_13311_201504Design() {

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
   * タブに内部項目を追加します。
   */
  protected void addTabs(){

    tabs.addTab("1", getTabPanel1());

    tabs.addTab("2", getTabPanel2());

    tabs.addTab("3", getTabPanel3());

    tabs.addTab("4", getTabPanel4());

    tabs.addTab("5", getTabPanel5());

    tabs.addTab("6", getTabPanel6());

    tabs.addTab("7", getTabPanel7());

    tabs.addTab("8", getTabPanel8());

  }

  /**
   * タブパネル1に内部項目を追加します。
   */
  protected void addTabPanel1(){

    tabPanel1.add(getFacilitiesDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tabPanel1.add(getSpecificFacilitySubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tabPanel1.add(getSpecificFacilityFunctionTrainingRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tabPanel1.add(getNightNursingSystemRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tabPanel1.add(getMedicalCoordinateAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tabPanel1.add(getImpairedPersonHelpAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 施設等の区分に内部項目を追加します。
   */
  protected void addFacilitiesDivisionRadio(){

  }

  /**
   * 施設等の区分モデルに内部項目を追加します。
   */
  protected void addFacilitiesDivisionRadioModel(){

    getFacilitiesDivisionRadioItem1().setButtonIndex(1);

    getFacilitiesDivisionRadioModel().add(getFacilitiesDivisionRadioItem1());

    getFacilitiesDivisionRadioItem2().setButtonIndex(2);

    getFacilitiesDivisionRadioModel().add(getFacilitiesDivisionRadioItem2());

  }

  /**
   * 特定施設入居者に内部項目を追加します。
   */
  protected void addFacilitiesDivisionRadioItem1(){

  }

  /**
   * 外部サービス利用型に内部項目を追加します。
   */
  protected void addFacilitiesDivisionRadioItem2(){

  }

  /**
   * 人員減算に内部項目を追加します。
   */
  protected void addSpecificFacilitySubtractionRadio(){

  }

  /**
   * 人員減算モデルに内部項目を追加します。
   */
  protected void addSpecificFacilitySubtractionRadioModel(){

    getSpecificFacilitySubtractionNot().setButtonIndex(1);

    getSpecificFacilitySubtractionRadioModel().add(getSpecificFacilitySubtractionNot());

    getSpecificFacilitySubtractionPersonLack().setButtonIndex(2);

    getSpecificFacilitySubtractionRadioModel().add(getSpecificFacilitySubtractionPersonLack());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addSpecificFacilitySubtractionNot(){

  }

  /**
   * 職員不足に内部項目を追加します。
   */
  protected void addSpecificFacilitySubtractionPersonLack(){

  }

  /**
   * 個別機能訓練指導体制加算に内部項目を追加します。
   */
  protected void addSpecificFacilityFunctionTrainingRadio(){

  }

  /**
   * 個別機能訓練指導体制加算モデルに内部項目を追加します。
   */
  protected void addSpecificFacilityFunctionTrainingRadioModel(){

    getSpecificFacilityFunctionTrainingRadioItem2().setButtonIndex(1);

    getSpecificFacilityFunctionTrainingRadioModel().add(getSpecificFacilityFunctionTrainingRadioItem2());

    getSpecificFacilityFunctionTrainingRadioItem1().setButtonIndex(2);

    getSpecificFacilityFunctionTrainingRadioModel().add(getSpecificFacilityFunctionTrainingRadioItem1());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addSpecificFacilityFunctionTrainingRadioItem2(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addSpecificFacilityFunctionTrainingRadioItem1(){

  }

  /**
   * 夜間看護体制加算に内部項目を追加します。
   */
  protected void addNightNursingSystemRadio(){

  }

  /**
   * 夜間看護体制加算モデルに内部項目を追加します。
   */
  protected void addNightNursingSystemRadioModel(){

    getNightNursingSystemRadioItem1().setButtonIndex(1);

    getNightNursingSystemRadioModel().add(getNightNursingSystemRadioItem1());

    getNightNursingSystemRadioItem2().setButtonIndex(2);

    getNightNursingSystemRadioModel().add(getNightNursingSystemRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addNightNursingSystemRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addNightNursingSystemRadioItem2(){

  }

  /**
   * 医療機関連携加算に内部項目を追加します。
   */
  protected void addMedicalCoordinateAddRadioGroup(){

  }

  /**
   * 医療機関連携加算モデルに内部項目を追加します。
   */
  protected void addMedicalCoordinateAddRadioGroupModel(){

    getMedicalCoordinateAddRadioItem1().setButtonIndex(1);

    getMedicalCoordinateAddRadioGroupModel().add(getMedicalCoordinateAddRadioItem1());

    getMedicalCoordinateAddRadioItem2().setButtonIndex(2);

    getMedicalCoordinateAddRadioGroupModel().add(getMedicalCoordinateAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalCoordinateAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMedicalCoordinateAddRadioItem2(){

  }

  /**
   * 障害者等支援加算に内部項目を追加します。
   */
  protected void addImpairedPersonHelpAddRadioGroup(){

  }

  /**
   * 障害者等支援加算モデルに内部項目を追加します。
   */
  protected void addImpairedPersonHelpAddRadioGroupModel(){

    getImpairedPersonHelpAddRadioItem1().setButtonIndex(1);

    getImpairedPersonHelpAddRadioGroupModel().add(getImpairedPersonHelpAddRadioItem1());

    getImpairedPersonHelpAddRadioItem2().setButtonIndex(2);

    getImpairedPersonHelpAddRadioGroupModel().add(getImpairedPersonHelpAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addImpairedPersonHelpAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addImpairedPersonHelpAddRadioItem2(){

  }

  /**
   * タブパネル2に内部項目を追加します。
   */
  protected void addTabPanel2(){

    tabPanel2.add(getTerminalCareAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tabPanel2.add(getKaigoWelfareFacilityTakingCareNursingAddDaysContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tabPanel2.add(getDementiaProfessionalCareAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tabPanel2.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tabPanel2.add(getCalculationDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 看取り介護加算に内部項目を追加します。
   */
  protected void addTerminalCareAddRadioGroup(){

  }

  /**
   * 看取り介護加算モデルに内部項目を追加します。
   */
  protected void addTerminalCareAddRadioGroupModel(){

    getTerminalCareAddRadioItem1().setButtonIndex(1);

    getTerminalCareAddRadioGroupModel().add(getTerminalCareAddRadioItem1());

    getTerminalCareAddRadioItem2().setButtonIndex(2);

    getTerminalCareAddRadioGroupModel().add(getTerminalCareAddRadioItem2());

    getTerminalCareAddRadioItem3().setButtonIndex(3);

    getTerminalCareAddRadioGroupModel().add(getTerminalCareAddRadioItem3());

    getTerminalCareAddRadioItem4().setButtonIndex(4);

    getTerminalCareAddRadioGroupModel().add(getTerminalCareAddRadioItem4());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTerminalCareAddRadioItem1(){

  }

  /**
   * 死亡日以前4日以上30日以下に内部項目を追加します。
   */
  protected void addTerminalCareAddRadioItem2(){

  }

  /**
   * 死亡日以前2日又は3日に内部項目を追加します。
   */
  protected void addTerminalCareAddRadioItem3(){

  }

  /**
   * 死亡日に内部項目を追加します。
   */
  protected void addTerminalCareAddRadioItem4(){

  }

  /**
   * 看取り介護加算コンテナに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityTakingCareNursingAddDaysContainer(){

    kaigoWelfareFacilityTakingCareNursingAddDaysContainer.add(getKaigoWelfareFacilityTakingCareNursingAddDays(), VRLayout.FLOW);

    kaigoWelfareFacilityTakingCareNursingAddDaysContainer.add(getKaigoWelfareFacilityTakingCareNursingAddDaysUnit(), VRLayout.FLOW);

  }

  /**
   * 看取り介護加算日数に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityTakingCareNursingAddDays(){

  }

  /**
   * 看取り介護加算日数単位に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityTakingCareNursingAddDaysUnit(){

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
   * 加算型Iに内部項目を追加します。
   */
  protected void addDementiaProfessionalCareAddRadioItem2(){

  }

  /**
   * 加算型IIに内部項目を追加します。
   */
  protected void addDementiaProfessionalCareAddRadioItem3(){

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

    getServiceAddProvisionStructuralRadioItem2().setButtonIndex(2);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem2());

    getServiceAddProvisionStructuralRadioItem3().setButtonIndex(3);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem3());

    getServiceAddProvisionStructuralRadioItem4().setButtonIndex(4);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem4());

    getServiceAddProvisionStructuralRadioItem5().setButtonIndex(5);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem5());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem1(){

  }

  /**
   * Iイ型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem2(){

  }

  /**
   * Iロ型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem3(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem4(){

  }

  /**
   * III型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem5(){

  }

  /**
   * 算定区分に内部項目を追加します。
   */
  protected void addCalculationDivisionRadio(){

  }

  /**
   * 算定区分モデルに内部項目を追加します。
   */
  protected void addCalculationDivisionRadioModel(){

    getCalculationDivisionRadioItem1().setButtonIndex(1);

    getCalculationDivisionRadioModel().add(getCalculationDivisionRadioItem1());

    getCalculationDivisionRadioItem2().setButtonIndex(2);

    getCalculationDivisionRadioModel().add(getCalculationDivisionRadioItem2());

  }

  /**
   * 通常に内部項目を追加します。
   */
  protected void addCalculationDivisionRadioItem1(){

  }

  /**
   * 加算のみに内部項目を追加します。
   */
  protected void addCalculationDivisionRadioItem2(){

  }

  /**
   * タブパネル3に内部項目を追加します。
   */
  protected void addTabPanel3(){

    tabPanel3.add(getServiceSettingPanel(), VRLayout.NORTH);

    tabPanel3.add(getVisitCareGroup(), VRLayout.NORTH);

  }

  /**
   * 概要領域に内部項目を追加します。
   */
  protected void addServiceSettingPanel(){

    serviceSettingPanel.add(getOutsideServiceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    serviceSettingPanel.add(getSpecificFacilityTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * 外部サービスに内部項目を追加します。
   */
  protected void addOutsideServiceRadio(){

  }

  /**
   * 外部サービスモデルに内部項目を追加します。
   */
  protected void addOutsideServiceRadioModel(){

    getOutsideServiceRadioItem0().setButtonIndex(9);

    getOutsideServiceRadioModel().add(getOutsideServiceRadioItem0());

    getOutsideServiceRadioItem1().setButtonIndex(1);

    getOutsideServiceRadioModel().add(getOutsideServiceRadioItem1());

    getOutsideServiceRadioItem2().setButtonIndex(2);

    getOutsideServiceRadioModel().add(getOutsideServiceRadioItem2());

    getOutsideServiceRadioItem3().setButtonIndex(3);

    getOutsideServiceRadioModel().add(getOutsideServiceRadioItem3());

    getOutsideServiceRadioItem4().setButtonIndex(4);

    getOutsideServiceRadioModel().add(getOutsideServiceRadioItem4());

    getOutsideServiceRadioItem5().setButtonIndex(5);

    getOutsideServiceRadioModel().add(getOutsideServiceRadioItem5());

    getOutsideServiceRadioItem6().setButtonIndex(6);

    getOutsideServiceRadioModel().add(getOutsideServiceRadioItem6());

    getOutsideServiceRadioItem7().setButtonIndex(7);

    getOutsideServiceRadioModel().add(getOutsideServiceRadioItem7());

    getOutsideServiceRadioItem8().setButtonIndex(8);

    getOutsideServiceRadioModel().add(getOutsideServiceRadioItem8());

    getOutsideServiceRadioItem9().setButtonIndex(10);

    getOutsideServiceRadioModel().add(getOutsideServiceRadioItem9());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addOutsideServiceRadioItem0(){

  }

  /**
   * 訪問介護に内部項目を追加します。
   */
  protected void addOutsideServiceRadioItem1(){

  }

  /**
   * 訪問入浴介護に内部項目を追加します。
   */
  protected void addOutsideServiceRadioItem2(){

  }

  /**
   * 訪問看護に内部項目を追加します。
   */
  protected void addOutsideServiceRadioItem3(){

  }

  /**
   * 訪問リハに内部項目を追加します。
   */
  protected void addOutsideServiceRadioItem4(){

  }

  /**
   * 通所介護に内部項目を追加します。
   */
  protected void addOutsideServiceRadioItem5(){

  }

  /**
   * 通所リハに内部項目を追加します。
   */
  protected void addOutsideServiceRadioItem6(){

  }

  /**
   * 福祉用具貸与に内部項目を追加します。
   */
  protected void addOutsideServiceRadioItem7(){

  }

  /**
   * 認知症対応通所介護に内部項目を追加します。
   */
  protected void addOutsideServiceRadioItem8(){

  }

  /**
   * 地域密着型通所介護に内部項目を追加します。
   */
  protected void addOutsideServiceRadioItem9(){

  }

  /**
   * 提供時間コンテナに内部項目を追加します。
   */
  protected void addSpecificFacilityTimeContena(){

    specificFacilityTimeContena.add(getSpecificFacilityBeginTimeContainer(), VRLayout.FLOW);

    specificFacilityTimeContena.add(getSpecificFacilityEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * 開始時刻コンボに内部項目を追加します。
   */
  protected void addSpecificFacilityBeginTime(){

  }

  /**
   * 開始時刻コンボモデルに内部項目を追加します。
   */
  protected void addSpecificFacilityBeginTimeModel(){

  }

  /**
   * 終了時刻コンボに内部項目を追加します。
   */
  protected void addSpecificFacilityEndTime(){

  }

  /**
   * 終了時刻コンボモデルに内部項目を追加します。
   */
  protected void addSpecificFacilityEndTimeModel(){

  }

  /**
   * 訪問介護グループに内部項目を追加します。
   */
  protected void addVisitCareGroup(){

    visitCareGroup.add(getVisitCareRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    visitCareGroup.add(getVisitCareComboContainer(), VRLayout.FLOW);

  }

  /**
   * 訪問介護に内部項目を追加します。
   */
  protected void addVisitCareRadio(){

  }

  /**
   * 訪問介護モデルに内部項目を追加します。
   */
  protected void addVisitCareRadioModel(){

    getVisitCareRadioItem1().setButtonIndex(1);

    getVisitCareRadioModel().add(getVisitCareRadioItem1());

    getVisitCareRadioItem2().setButtonIndex(2);

    getVisitCareRadioModel().add(getVisitCareRadioItem2());

    getVisitCareRadioItem3().setButtonIndex(3);

    getVisitCareRadioModel().add(getVisitCareRadioItem3());

  }

  /**
   * 身体介護中心に内部項目を追加します。
   */
  protected void addVisitCareRadioItem1(){

  }

  /**
   * 生活援助中心に内部項目を追加します。
   */
  protected void addVisitCareRadioItem2(){

  }

  /**
   * 通院等乗降介助に内部項目を追加します。
   */
  protected void addVisitCareRadioItem3(){

  }

  /**
   * 時間区分コンボに内部項目を追加します。
   */
  protected void addVisitCareCombo(){

  }

  /**
   * 時間区分コンボモデルに内部項目を追加します。
   */
  protected void addVisitCareComboModel(){

  }

  /**
   * タブパネル4に内部項目を追加します。
   */
  protected void addTabPanel4(){

    tabPanel4.add(getVisitNursingRadioGroup(), VRLayout.NORTH);

    tabPanel4.add(getVisitRehabiliGroup(), VRLayout.NORTH);

  }

  /**
   * 訪問看護に内部項目を追加します。
   */
  protected void addVisitNursingRadioGroup(){

    visitNursingRadioGroup.add(getVisitNursingFacilitiesDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    visitNursingRadioGroup.add(getVisitNursingStaffDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    visitNursingRadioGroup.add(getTwoOrMoreTimesCheck(), VRLayout.FLOW);

    visitNursingRadioGroup.add(getVisitNursingComboContainer(), VRLayout.FLOW);

    visitNursingRadioGroup.add(getNurseStaffDivisionRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 施設等の区分に内部項目を追加します。
   */
  protected void addVisitNursingFacilitiesDivisionRadio(){

  }

  /**
   * 施設等の区分モデルに内部項目を追加します。
   */
  protected void addVisitNursingFacilitiesDivisionRadioModel(){

    getVisitNursingFacilitiesDivisionRadioItem1().setButtonIndex(1);

    getVisitNursingFacilitiesDivisionRadioModel().add(getVisitNursingFacilitiesDivisionRadioItem1());

    getVisitNursingFacilitiesDivisionRadioItem2().setButtonIndex(2);

    getVisitNursingFacilitiesDivisionRadioModel().add(getVisitNursingFacilitiesDivisionRadioItem2());

  }

  /**
   * 訪問看護ステーションに内部項目を追加します。
   */
  protected void addVisitNursingFacilitiesDivisionRadioItem1(){

  }

  /**
   * 病院又は診療所に内部項目を追加します。
   */
  protected void addVisitNursingFacilitiesDivisionRadioItem2(){

  }

  /**
   * 職員区分に内部項目を追加します。
   */
  protected void addVisitNursingStaffDivisionRadio(){

  }

  /**
   * 職員区分モデルに内部項目を追加します。
   */
  protected void addVisitNursingStaffDivisionRadioModel(){

    getVisitNursingStaffDivisionRadioItem1().setButtonIndex(1);

    getVisitNursingStaffDivisionRadioModel().add(getVisitNursingStaffDivisionRadioItem1());

    getVisitNursingStaffDivisionRadioItem2().setButtonIndex(2);

    getVisitNursingStaffDivisionRadioModel().add(getVisitNursingStaffDivisionRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addVisitNursingStaffDivisionRadioItem1(){

  }

  /**
   * PT,OT,STに内部項目を追加します。
   */
  protected void addVisitNursingStaffDivisionRadioItem2(){

  }

  /**
   * 1日に2回を越えて実施に内部項目を追加します。
   */
  protected void addTwoOrMoreTimesCheck(){

  }

  /**
   * 時間区分コンボに内部項目を追加します。
   */
  protected void addVisitNursingCombo(){

  }

  /**
   * 時間区分コンボモデルに内部項目を追加します。
   */
  protected void addVisitNursingComboModel(){

  }

  /**
   * 看護職員区分に内部項目を追加します。
   */
  protected void addNurseStaffDivisionRadioGroup(){

  }

  /**
   * 看護職員区分モデルに内部項目を追加します。
   */
  protected void addNurseStaffDivisionRadioGroupModel(){

    getNurseStaffDivisionRadioItem1().setButtonIndex(1);

    getNurseStaffDivisionRadioGroupModel().add(getNurseStaffDivisionRadioItem1());

    getNurseStaffDivisionRadioItem2().setButtonIndex(2);

    getNurseStaffDivisionRadioGroupModel().add(getNurseStaffDivisionRadioItem2());

  }

  /**
   * 正看等に内部項目を追加します。
   */
  protected void addNurseStaffDivisionRadioItem1(){

  }

  /**
   * 准看に内部項目を追加します。
   */
  protected void addNurseStaffDivisionRadioItem2(){

  }

  /**
   * 訪問リハグループに内部項目を追加します。
   */
  protected void addVisitRehabiliGroup(){

    visitRehabiliGroup.add(getVisitRehabiliRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 施設等の区分に内部項目を追加します。
   */
  protected void addVisitRehabiliRadio(){

  }

  /**
   * 施設等の区分モデルに内部項目を追加します。
   */
  protected void addVisitRehabiliRadioModel(){

    getVisitRehabiliRadioItem1().setButtonIndex(1);

    getVisitRehabiliRadioModel().add(getVisitRehabiliRadioItem1());

    getVisitRehabiliRadioItem2().setButtonIndex(2);

    getVisitRehabiliRadioModel().add(getVisitRehabiliRadioItem2());

  }

  /**
   * 病院又は診療所に内部項目を追加します。
   */
  protected void addVisitRehabiliRadioItem1(){

  }

  /**
   * 介護老人保健施設に内部項目を追加します。
   */
  protected void addVisitRehabiliRadioItem2(){

  }

  /**
   * タブパネル5に内部項目を追加します。
   */
  protected void addTabPanel5(){

    tabPanel5.add(getExpertPlaceNursingGroup(), VRLayout.NORTH);

  }

  /**
   * 通所介護グループに内部項目を追加します。
   */
  protected void addExpertPlaceNursingGroup(){

    expertPlaceNursingGroup.add(getExpertPlaceNursingRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    expertPlaceNursingGroup.add(getExpertPlaceNursingComboContainer(), VRLayout.FLOW);

  }

  /**
   * 施設等の区分に内部項目を追加します。
   */
  protected void addExpertPlaceNursingRadio(){

  }

  /**
   * 施設等の区分モデルに内部項目を追加します。
   */
  protected void addExpertPlaceNursingRadioModel(){

    getExpertPlaceNursingRadioItem1().setButtonIndex(1);

    getExpertPlaceNursingRadioModel().add(getExpertPlaceNursingRadioItem1());

    getExpertPlaceNursingRadioItem2().setButtonIndex(2);

    getExpertPlaceNursingRadioModel().add(getExpertPlaceNursingRadioItem2());

    getExpertPlaceNursingRadioItem3().setButtonIndex(3);

    getExpertPlaceNursingRadioModel().add(getExpertPlaceNursingRadioItem3());

    getExpertPlaceNursingRadioItem4().setButtonIndex(4);

    getExpertPlaceNursingRadioModel().add(getExpertPlaceNursingRadioItem4());

    getExpertPlaceNursingRadioItem5().setButtonIndex(5);

    getExpertPlaceNursingRadioModel().add(getExpertPlaceNursingRadioItem5());

  }

  /**
   * 小規模事業所に内部項目を追加します。
   */
  protected void addExpertPlaceNursingRadioItem1(){

  }

  /**
   * 通常規模事業所に内部項目を追加します。
   */
  protected void addExpertPlaceNursingRadioItem2(){

  }

  /**
   * 大規模事業所 Iに内部項目を追加します。
   */
  protected void addExpertPlaceNursingRadioItem3(){

  }

  /**
   * 大規模事業所 IIに内部項目を追加します。
   */
  protected void addExpertPlaceNursingRadioItem4(){

  }

  /**
   * 療養通所に内部項目を追加します。
   */
  protected void addExpertPlaceNursingRadioItem5(){

  }

  /**
   * 時間区分コンボに内部項目を追加します。
   */
  protected void addExpertPlaceNursingCombo(){

  }

  /**
   * 時間区分コンボモデルに内部項目を追加します。
   */
  protected void addExpertPlaceNursingComboModel(){

  }

  /**
   * タブパネル6に内部項目を追加します。
   */
  protected void addTabPanel6(){

    tabPanel6.add(getExpertPlaceRehabiliGroup(), VRLayout.NORTH);

  }

  /**
   * 通所リハグループに内部項目を追加します。
   */
  protected void addExpertPlaceRehabiliGroup(){

    expertPlaceRehabiliGroup.add(getExpertPlaceRehabiliRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    expertPlaceRehabiliGroup.add(getExpertPlaceRehabiliComboContainer(), VRLayout.FLOW);

  }

  /**
   * 施設等の区分に内部項目を追加します。
   */
  protected void addExpertPlaceRehabiliRadio(){

  }

  /**
   * 施設等の区分モデルに内部項目を追加します。
   */
  protected void addExpertPlaceRehabiliRadioModel(){

    getExpertPlaceRehabiliRadioItem1().setButtonIndex(1);

    getExpertPlaceRehabiliRadioModel().add(getExpertPlaceRehabiliRadioItem1());

    getExpertPlaceRehabiliRadioItem2().setButtonIndex(2);

    getExpertPlaceRehabiliRadioModel().add(getExpertPlaceRehabiliRadioItem2());

    getExpertPlaceRehabiliRadioItem3().setButtonIndex(3);

    getExpertPlaceRehabiliRadioModel().add(getExpertPlaceRehabiliRadioItem3());

    getExpertPlaceRehabiliRadioItem4().setButtonIndex(4);

    getExpertPlaceRehabiliRadioModel().add(getExpertPlaceRehabiliRadioItem4());

    getExpertPlaceRehabiliRadioItem5().setButtonIndex(5);

    getExpertPlaceRehabiliRadioModel().add(getExpertPlaceRehabiliRadioItem5());

    getExpertPlaceRehabiliRadioItem6().setButtonIndex(6);

    getExpertPlaceRehabiliRadioModel().add(getExpertPlaceRehabiliRadioItem6());

  }

  /**
   * 通常規模事業所（病院・診療所）に内部項目を追加します。
   */
  protected void addExpertPlaceRehabiliRadioItem1(){

  }

  /**
   * 通常規模事業所（介護老人保健施設）に内部項目を追加します。
   */
  protected void addExpertPlaceRehabiliRadioItem2(){

  }

  /**
   * 大規模事業所 I（病院・診療所）に内部項目を追加します。
   */
  protected void addExpertPlaceRehabiliRadioItem3(){

  }

  /**
   * 大規模事業所 I（介護老人保健施設）に内部項目を追加します。
   */
  protected void addExpertPlaceRehabiliRadioItem4(){

  }

  /**
   * 大規模事業所 II（病院・診療所）に内部項目を追加します。
   */
  protected void addExpertPlaceRehabiliRadioItem5(){

  }

  /**
   * 大規模事業所 II（介護老人保健施設）に内部項目を追加します。
   */
  protected void addExpertPlaceRehabiliRadioItem6(){

  }

  /**
   * 時間区分コンボに内部項目を追加します。
   */
  protected void addExpertPlaceRehabiliCombo(){

  }

  /**
   * 時間区分コンボモデルに内部項目を追加します。
   */
  protected void addExpertPlaceRehabiliComboModel(){

  }

  /**
   * タブパネル7に内部項目を追加します。
   */
  protected void addTabPanel7(){

    tabPanel7.add(getWelfareToolsGroup(), VRLayout.NORTH);

    tabPanel7.add(getNinchishoTaioTsushoGroup(), VRLayout.NORTH);

  }

  /**
   * 福祉用具貸与グループに内部項目を追加します。
   */
  protected void addWelfareToolsGroup(){

    welfareToolsGroup.add(getWelfareToolsComboContainer(), VRLayout.FLOW_RETURN);

    welfareToolsGroup.add(getWelfarePointTextContainer(), VRLayout.FLOW_RETURN);

    welfareToolsGroup.add(getWelfareTekiyoTextContainer(), VRLayout.FLOW);

  }

  /**
   * 用具に内部項目を追加します。
   */
  protected void addWelfareToolsCombo(){

  }

  /**
   * 用具モデルに内部項目を追加します。
   */
  protected void addWelfareToolsComboModel(){

  }

  /**
   * 単価に内部項目を追加します。
   */
  protected void addWelfarePointText(){

  }

  /**
   * 摘要に内部項目を追加します。
   */
  protected void addWelfareTekiyoText(){

  }

  /**
   * 認知症対応型通所介護グループに内部項目を追加します。
   */
  protected void addNinchishoTaioTsushoGroup(){

    ninchishoTaioTsushoGroup.add(getProviderDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    ninchishoTaioTsushoGroup.add(getDivisionRadionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    ninchishoTaioTsushoGroup.add(getTimeDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 施設等の区分1に内部項目を追加します。
   */
  protected void addProviderDivisionRadio(){

  }

  /**
   * 施設等の区分1モデルに内部項目を追加します。
   */
  protected void addProviderDivisionRadioModel(){

    getProviderDivisionRadioItem1().setButtonIndex(1);

    getProviderDivisionRadioModel().add(getProviderDivisionRadioItem1());

    getProviderDivisionRadioItem2().setButtonIndex(2);

    getProviderDivisionRadioModel().add(getProviderDivisionRadioItem2());

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addProviderDivisionRadioItem1(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addProviderDivisionRadioItem2(){

  }

  /**
   * 施設等の区分2に内部項目を追加します。
   */
  protected void addDivisionRadion(){

  }

  /**
   * 施設等の区分2モデルに内部項目を追加します。
   */
  protected void addDivisionRadionModel(){

    getDivisionRadionitem1().setButtonIndex(1);

    getDivisionRadionModel().add(getDivisionRadionitem1());

    getDivisionRadionitem2().setButtonIndex(2);

    getDivisionRadionModel().add(getDivisionRadionitem2());

  }

  /**
   * 単独型に内部項目を追加します。
   */
  protected void addDivisionRadionitem1(){

  }

  /**
   * 併設型に内部項目を追加します。
   */
  protected void addDivisionRadionitem2(){

  }

  /**
   * 時間区分に内部項目を追加します。
   */
  protected void addTimeDivisionRadio(){

  }

  /**
   * 時間区分モデルに内部項目を追加します。
   */
  protected void addTimeDivisionRadioModel(){

    getTimeDivisionRadioItem1().setButtonIndex(1);

    getTimeDivisionRadioModel().add(getTimeDivisionRadioItem1());

    getTimeDivisionRadioItem2().setButtonIndex(2);

    getTimeDivisionRadioModel().add(getTimeDivisionRadioItem2());

    getTimeDivisionRadioItem3().setButtonIndex(3);

    getTimeDivisionRadioModel().add(getTimeDivisionRadioItem3());

    getTimeDivisionRadioItem4().setButtonIndex(4);

    getTimeDivisionRadioModel().add(getTimeDivisionRadioItem4());

  }

  /**
   * 2から3時間に内部項目を追加します。
   */
  protected void addTimeDivisionRadioItem1(){

  }

  /**
   * 3から4時間に内部項目を追加します。
   */
  protected void addTimeDivisionRadioItem2(){

  }

  /**
   * 4から6時間に内部項目を追加します。
   */
  protected void addTimeDivisionRadioItem3(){

  }

  /**
   * 6から8時間に内部項目を追加します。
   */
  protected void addTimeDivisionRadioItem4(){

  }

  /**
   * タブパネル8に内部項目を追加します。
   */
  protected void addTabPanel8(){

    tabPanel8.add(getChiikiDayCareGroup(), VRLayout.NORTH);

  }

  /**
   * 地域密着型通所介護グループに内部項目を追加します。
   */
  protected void addChiikiDayCareGroup(){

    chiikiDayCareGroup.add(getChiikiDayCareRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    chiikiDayCareGroup.add(getChiikiDayCareComboContainer(), VRLayout.FLOW);

  }

  /**
   * 施設等の区分に内部項目を追加します。
   */
  protected void addChiikiDayCareRadio(){

  }

  /**
   * 施設等の区分モデルに内部項目を追加します。
   */
  protected void addChiikiDayCareRadioModel(){

    getChiikiDayCareRadioItem1().setButtonIndex(1);

    getChiikiDayCareRadioModel().add(getChiikiDayCareRadioItem1());

    getChiikiDayCareRadioItem2().setButtonIndex(2);

    getChiikiDayCareRadioModel().add(getChiikiDayCareRadioItem2());

  }

  /**
   * 地域密着型通所介護に内部項目を追加します。
   */
  protected void addChiikiDayCareRadioItem1(){

  }

  /**
   * 療養通所介護に内部項目を追加します。
   */
  protected void addChiikiDayCareRadioItem2(){

  }

  /**
   * 時間区分コンボに内部項目を追加します。
   */
  protected void addChiikiDayCareCombo(){

  }

  /**
   * 時間区分コンボモデルに内部項目を追加します。
   */
  protected void addChiikiDayCareComboModel(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_13311_201504Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001_13311_201504Design getThis() {
    return this;
  }
}
