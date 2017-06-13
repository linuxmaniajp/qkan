
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
 * 作成日: 2016/12/01  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン介護予防特定施設入居者生活介護 (QS001_13511_201504)
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
 * サービスパターン介護予防特定施設入居者生活介護画面項目デザイン(QS001_13511_201504) 
 */
public class QS001_13511_201504Design extends QS001ServicePanel {
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

  private ACPanel servicePanelAdd;

  private ACValueArrayRadioButtonGroup specificFacilityFunctionTrainingRadio;

  private ACLabelContainer specificFacilityFunctionTrainingRadioContainer;

  private ACListModelAdapter specificFacilityFunctionTrainingRadioModel;

  private ACRadioButtonItem specificFacilityFunctionTrainingRadioItem2;

  private ACRadioButtonItem specificFacilityFunctionTrainingRadioItem1;

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

  private ACPanel tabPanel2;

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

  private ACRadioButtonItem outsideServiceRadioItem10;

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

  private ACIntegerCheckBox visitCareCrackOnDayCheck;

  private ACIntegerCheckBox visitCarePrintable;

  private ACPanel tabPanel3;

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

  private ACPanel tabPanel4;

  private ACGroupBox expertPlaceNursingGroup;

  private ACIntegerCheckBox expertPlaceNursingCrackOnDayChaeck;

  private ACIntegerCheckBox expertPlaceNursingPrintable;

  private ACValueArrayRadioButtonGroup expertPlaceNursingMovementFunctionImprovementAddRadio;

  private ACLabelContainer expertPlaceNursingMovementFunctionImprovementAddRadioContainer;

  private ACListModelAdapter expertPlaceNursingMovementFunctionImprovementAddRadioModel;

  private ACRadioButtonItem expertPlaceNursingMovementFunctionImprovementAddRadioItem1;

  private ACRadioButtonItem expertPlaceNursingMovementFunctionImprovementAddRadioItem2;

  private ACValueArrayRadioButtonGroup expertPlaceNursingNourishmentImprovementAddRadio;

  private ACLabelContainer expertPlaceNursingNourishmentImprovementAddRadioContainer;

  private ACListModelAdapter expertPlaceNursingNourishmentImprovementAddRadioModel;

  private ACRadioButtonItem expertPlaceNursingNourishmentImprovementAddRadioItem1;

  private ACRadioButtonItem expertPlaceNursingNourishmentImprovementAddRadioItem2;

  private ACValueArrayRadioButtonGroup expertPlaceNursingMouthFunctionImprovementAddRadio;

  private ACLabelContainer expertPlaceNursingMouthFunctionImprovementAddRadioContainer;

  private ACListModelAdapter expertPlaceNursingMouthFunctionImprovementAddRadioModel;

  private ACRadioButtonItem expertPlaceNursingMouthFunctionImprovementAddRadioItem1;

  private ACRadioButtonItem expertPlaceNursingMouthFunctionImprovementAddRadioItem2;

  private ACValueArrayRadioButtonGroup expertPlaceNursingSentakutekiServiceRadio;

  private ACLabelContainer expertPlaceNursingSentakutekiServiceRadioContainer;

  private ACListModelAdapter expertPlaceNursingSentakutekiServiceRadioModel;

  private ACRadioButtonItem expertPlaceNursingSentakutekiServiceRadioItem1;

  private ACRadioButtonItem expertPlaceNursingSentakutekiServiceRadioItem2;

  private ACRadioButtonItem expertPlaceNursingSentakutekiServiceRadioItem3;

  private ACRadioButtonItem expertPlaceNursingSentakutekiServiceRadioItem4;

  private ACRadioButtonItem expertPlaceNursingSentakutekiServiceRadioItem5;

  private ACPanel tabPanel5;

  private ACGroupBox expertPlaceRehabiliGroup;

  private ACIntegerCheckBox expertPlaceRehabiliCrackOnDay;

  private ACIntegerCheckBox expertPlaceRehabiliPrintable;

  private ACValueArrayRadioButtonGroup expertPlaceRehabiliRadio;

  private ACLabelContainer expertPlaceRehabiliRadioContainer;

  private ACListModelAdapter expertPlaceRehabiliRadioModel;

  private ACRadioButtonItem expertPlaceRehabiliRadioItem1;

  private ACRadioButtonItem expertPlaceRehabiliRadioItem2;

  private ACValueArrayRadioButtonGroup expertPlaceRehabiliMovementFunctionImprovementAddRadio;

  private ACLabelContainer expertPlaceRehabiliMovementFunctionImprovementAddRadioContainer;

  private ACListModelAdapter expertPlaceRehabiliMovementFunctionImprovementAddRadioModel;

  private ACRadioButtonItem expertPlaceRehabiliMovementFunctionImprovementAddRadioItem1;

  private ACRadioButtonItem expertPlaceRehabiliMovementFunctionImprovementAddRadioItem2;

  private ACValueArrayRadioButtonGroup expertPlaceRehabiliNourishmentImprovementAddRadio;

  private ACLabelContainer expertPlaceRehabiliNourishmentImprovementAddRadioContainer;

  private ACListModelAdapter expertPlaceRehabiliNourishmentImprovementAddRadioModel;

  private ACRadioButtonItem expertPlaceRehabiliNourishmentImprovementAddRadioItem1;

  private ACRadioButtonItem expertPlaceRehabiliNourishmentImprovementAddRadioItem2;

  private ACValueArrayRadioButtonGroup expertPlaceRehabiliMouthFunctionImprovementAddRadio;

  private ACLabelContainer expertPlaceRehabiliMouthFunctionImprovementAddRadioContainer;

  private ACListModelAdapter expertPlaceRehabiliMouthFunctionImprovementAddRadioModel;

  private ACRadioButtonItem expertPlaceRehabiliMouthFunctionImprovementAddRadioItem1;

  private ACRadioButtonItem expertPlaceRehabiliMouthFunctionImprovementAddRadioItem2;

  private ACValueArrayRadioButtonGroup expertPlaceRehabiliSentakutekiServiceRadio;

  private ACLabelContainer expertPlaceRehabiliSentakutekiServiceRadioContainer;

  private ACListModelAdapter expertPlaceRehabiliSentakutekiServiceRadioModel;

  private ACRadioButtonItem expertPlaceRehabiliSentakutekiServiceRadioItem1;

  private ACRadioButtonItem expertPlaceRehabiliSentakutekiServiceRadioItem2;

  private ACRadioButtonItem expertPlaceRehabiliSentakutekiServiceRadioItem3;

  private ACRadioButtonItem expertPlaceRehabiliSentakutekiServiceRadioItem4;

  private ACRadioButtonItem expertPlaceRehabiliSentakutekiServiceRadioItem5;

  private ACPanel tabPanel6;

  private ACGroupBox welfareToolsGroup;

  private ACComboBox welfareToolsCombo;

  private ACLabelContainer welfareToolsComboContainer;

  private ACComboBoxModelAdapter welfareToolsComboModel;

  private ACTextField welfarePointText;

  private ACLabelContainer welfarePointTextContainer;

  private ACTextField welfareTekiyoText;

  private ACLabelContainer welfareTekiyoTextContainer;

  private ACPanel tabPanel7;

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

  private ACValueArrayRadioButtonGroup ninchishoTaioTsushoIndividualFunctionTrainingAddRadio;

  private ACLabelContainer ninchishoTaioTsushoIndividualFunctionTrainingAddRadioContainer;

  private ACListModelAdapter ninchishoTaioTsushoIndividualFunctionTrainingAddRadioModel;

  private ACRadioButtonItem ninchishoTaioTsushoIndividualFunctionTrainingAddRadioItem1;

  private ACRadioButtonItem ninchishoTaioTsushoIndividualFunctionTrainingAddRadioItem2;

  private ACValueArrayRadioButtonGroup ninchishoTaioTsushoNourishmentImprovementAddRadio;

  private ACLabelContainer ninchishoTaioTsushoNourishmentImprovementAddRadioContainer;

  private ACListModelAdapter ninchishoTaioTsushoNourishmentImprovementAddRadioModel;

  private ACRadioButtonItem ninchishoTaioTsushoNourishmentImprovementAddRadioItem1;

  private ACRadioButtonItem ninchishoTaioTsushoNourishmentImprovementAddRadioItem2;

  private ACValueArrayRadioButtonGroup ninchishoTaioTsushoMouthFunctionImprovementAddRadio;

  private ACLabelContainer ninchishoTaioTsushoMouthFunctionImprovementAddRadioContainer;

  private ACListModelAdapter ninchishoTaioTsushoMouthFunctionImprovementAddRadioModel;

  private ACRadioButtonItem ninchishoTaioTsushoMouthFunctionImprovementAddRadioItem1;

  private ACRadioButtonItem ninchishoTaioTsushoMouthFunctionImprovementAddRadioItem2;

  private ACPanel tabPanel8;

  private ACGroupBox visitCareServiceGroup;

  private ACValueArrayRadioButtonGroup visitCareServiceRadio;

  private ACLabelContainer visitCareServiceRadioContainer;

  private ACListModelAdapter visitCareServiceRadioModel;

  private ACRadioButtonItem visitCareServiceRadioItem1;

  private ACRadioButtonItem visitCareServiceRadioItem2;

  private ACRadioButtonItem visitCareServiceRadioItem3;

  private ACIntegerCheckBox visitCareServiceCrackOnDayCheck;

  private ACIntegerCheckBox visitCareServicePrintable;

  private ACGroupBox expertPlaceNursingServiceGroup;

  private ACIntegerCheckBox expertPlaceNursingServiceCrackOnDayChaeck;

  private ACIntegerCheckBox expertPlaceNursingServicePrintable;

  private ACValueArrayRadioButtonGroup expertPlaceNursingServiceMovementFunctionImprovementAddRadio;

  private ACLabelContainer expertPlaceNursingServiceMovementFunctionImprovementAddRadioContainer;

  private ACListModelAdapter expertPlaceNursingServiceMovementFunctionImprovementAddRadioModel;

  private ACRadioButtonItem expertPlaceNursingServiceMovementFunctionImprovementAddRadioItem1;

  private ACRadioButtonItem expertPlaceNursingServiceMovementFunctionImprovementAddRadioItem2;

  private ACValueArrayRadioButtonGroup expertPlaceNursingServiceNourishmentImprovementAddRadio;

  private ACLabelContainer expertPlaceNursingServiceNourishmentImprovementAddRadioContainer;

  private ACListModelAdapter expertPlaceNursingServiceNourishmentImprovementAddRadioModel;

  private ACRadioButtonItem expertPlaceNursingServiceNourishmentImprovementAddRadioItem1;

  private ACRadioButtonItem expertPlaceNursingServiceNourishmentImprovementAddRadioItem2;

  private ACValueArrayRadioButtonGroup expertPlaceNursingServiceMouthFunctionImprovementAddRadio;

  private ACLabelContainer expertPlaceNursingServiceMouthFunctionImprovementAddRadioContainer;

  private ACListModelAdapter expertPlaceNursingServiceMouthFunctionImprovementAddRadioModel;

  private ACRadioButtonItem expertPlaceNursingServiceMouthFunctionImprovementAddRadioItem1;

  private ACRadioButtonItem expertPlaceNursingServiceMouthFunctionImprovementAddRadioItem2;

  private ACValueArrayRadioButtonGroup expertPlaceNursingServiceSentakutekiServiceRadio;

  private ACLabelContainer expertPlaceNursingServiceSentakutekiServiceRadioContainer;

  private ACListModelAdapter expertPlaceNursingServiceSentakutekiServiceRadioModel;

  private ACRadioButtonItem expertPlaceNursingServiceSentakutekiServiceRadioItem1;

  private ACRadioButtonItem expertPlaceNursingServiceSentakutekiServiceRadioItem2;

  private ACRadioButtonItem expertPlaceNursingServiceSentakutekiServiceRadioItem3;

  private ACRadioButtonItem expertPlaceNursingServiceSentakutekiServiceRadioItem4;

  private ACRadioButtonItem expertPlaceNursingServiceSentakutekiServiceRadioItem5;

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

      facilitiesDivisionRadio.setBindPath("1350101");

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

      specificFacilitySubtractionRadio.setBindPath("1350103");

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
   * 看護・介護職員が欠員を取得します。
   * @return 看護・介護職員が欠員
   */
  public ACRadioButtonItem getSpecificFacilitySubtractionPersonLack(){
    if(specificFacilitySubtractionPersonLack==null){

      specificFacilitySubtractionPersonLack = new ACRadioButtonItem();

      specificFacilitySubtractionPersonLack.setText("看護・介護職員が欠員");

      specificFacilitySubtractionPersonLack.setGroup(getSpecificFacilitySubtractionRadio());

      specificFacilitySubtractionPersonLack.setConstraints(VRLayout.FLOW);

      addSpecificFacilitySubtractionPersonLack();
    }
    return specificFacilitySubtractionPersonLack;

  }

  /**
   * サービス加算パネルを取得します。
   * @return サービス加算パネル
   */
  public ACPanel getServicePanelAdd(){
    if(servicePanelAdd==null){

      servicePanelAdd = new ACPanel();

      servicePanelAdd.setFollowChildEnabled(true);

      servicePanelAdd.setHgap(0);

      servicePanelAdd.setLabelMargin(0);

      servicePanelAdd.setVgap(0);

      addServicePanelAdd();
    }
    return servicePanelAdd;

  }

  /**
   * 個別機能訓練加算を取得します。
   * @return 個別機能訓練加算
   */
  public ACValueArrayRadioButtonGroup getSpecificFacilityFunctionTrainingRadio(){
    if(specificFacilityFunctionTrainingRadio==null){

      specificFacilityFunctionTrainingRadio = new ACValueArrayRadioButtonGroup();

      getSpecificFacilityFunctionTrainingRadioContainer().setText("個別機能訓練加算");

      specificFacilityFunctionTrainingRadio.setBindPath("1350102");

      specificFacilityFunctionTrainingRadio.setUseClearButton(false);

      specificFacilityFunctionTrainingRadio.setModel(getSpecificFacilityFunctionTrainingRadioModel());

      specificFacilityFunctionTrainingRadio.setValues(new int[]{1,2});

      addSpecificFacilityFunctionTrainingRadio();
    }
    return specificFacilityFunctionTrainingRadio;

  }

  /**
   * 個別機能訓練加算コンテナを取得します。
   * @return 個別機能訓練加算コンテナ
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
   * 個別機能訓練加算モデルを取得します。
   * @return 個別機能訓練加算モデル
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
   * 医療機関連携加算を取得します。
   * @return 医療機関連携加算
   */
  public ACValueArrayRadioButtonGroup getMedicalCoordinateAddRadioGroup(){
    if(medicalCoordinateAddRadioGroup==null){

      medicalCoordinateAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getMedicalCoordinateAddRadioGroupContainer().setText("医療機関連携加算");

      medicalCoordinateAddRadioGroup.setBindPath("1350127");

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

      impairedPersonHelpAddRadioGroup.setBindPath("1350128");

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
   * 認知症専門ケア加算を取得します。
   * @return 認知症専門ケア加算
   */
  public ACValueArrayRadioButtonGroup getDementiaProfessionalCareAddRadioGroup(){
    if(dementiaProfessionalCareAddRadioGroup==null){

      dementiaProfessionalCareAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaProfessionalCareAddRadioGroupContainer().setText("認知症専門ケア加算");

      dementiaProfessionalCareAddRadioGroup.setBindPath("1350134");

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

      serviceAddProvisionStructuralRadioGroup.setBindPath("1350135");

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

      outsideServiceRadio.setBindPath("1350104");

      outsideServiceRadio.setUseClearButton(false);

      outsideServiceRadio.setModel(getOutsideServiceRadioModel());

      outsideServiceRadio.setValues(new int[]{11,1,2,3,4,5,6,7,8,9,10});

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

      outsideServiceRadioItem7.setConstraints(VRLayout.FLOW_RETURN);

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
   * 訪問型サービスを取得します。
   * @return 訪問型サービス
   */
  public ACRadioButtonItem getOutsideServiceRadioItem9(){
    if(outsideServiceRadioItem9==null){

      outsideServiceRadioItem9 = new ACRadioButtonItem();

      outsideServiceRadioItem9.setText("訪問型サービス");

      outsideServiceRadioItem9.setGroup(getOutsideServiceRadio());

      outsideServiceRadioItem9.setConstraints(VRLayout.FLOW);

      addOutsideServiceRadioItem9();
    }
    return outsideServiceRadioItem9;

  }

  /**
   * 通所型サービスを取得します。
   * @return 通所型サービス
   */
  public ACRadioButtonItem getOutsideServiceRadioItem10(){
    if(outsideServiceRadioItem10==null){

      outsideServiceRadioItem10 = new ACRadioButtonItem();

      outsideServiceRadioItem10.setText("通所型サービス");

      outsideServiceRadioItem10.setGroup(getOutsideServiceRadio());

      outsideServiceRadioItem10.setConstraints(VRLayout.FLOW);

      addOutsideServiceRadioItem10();
    }
    return outsideServiceRadioItem10;

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
   * 訪問介護費を取得します。
   * @return 訪問介護費
   */
  public ACValueArrayRadioButtonGroup getVisitCareRadio(){
    if(visitCareRadio==null){

      visitCareRadio = new ACValueArrayRadioButtonGroup();

      getVisitCareRadioContainer().setText("訪問介護費");

      visitCareRadio.setBindPath("1350105");

      visitCareRadio.setUseClearButton(false);

      visitCareRadio.setModel(getVisitCareRadioModel());

      visitCareRadio.setValues(new int[]{1,2,3});

      addVisitCareRadio();
    }
    return visitCareRadio;

  }

  /**
   * 訪問介護費コンテナを取得します。
   * @return 訪問介護費コンテナ
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
   * 訪問介護費モデルを取得します。
   * @return 訪問介護費モデル
   */
  protected ACListModelAdapter getVisitCareRadioModel(){
    if(visitCareRadioModel==null){
      visitCareRadioModel = new ACListModelAdapter();
      addVisitCareRadioModel();
    }
    return visitCareRadioModel;
  }

  /**
   * Ⅰ型を取得します。
   * @return Ⅰ型
   */
  public ACRadioButtonItem getVisitCareRadioItem1(){
    if(visitCareRadioItem1==null){

      visitCareRadioItem1 = new ACRadioButtonItem();

      visitCareRadioItem1.setText("I型");

      visitCareRadioItem1.setGroup(getVisitCareRadio());

      visitCareRadioItem1.setConstraints(VRLayout.FLOW);

      addVisitCareRadioItem1();
    }
    return visitCareRadioItem1;

  }

  /**
   * Ⅱ型を取得します。
   * @return Ⅱ型
   */
  public ACRadioButtonItem getVisitCareRadioItem2(){
    if(visitCareRadioItem2==null){

      visitCareRadioItem2 = new ACRadioButtonItem();

      visitCareRadioItem2.setText("II型");

      visitCareRadioItem2.setGroup(getVisitCareRadio());

      visitCareRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addVisitCareRadioItem2();
    }
    return visitCareRadioItem2;

  }

  /**
   * Ⅲ型を取得します。
   * @return Ⅲ型
   */
  public ACRadioButtonItem getVisitCareRadioItem3(){
    if(visitCareRadioItem3==null){

      visitCareRadioItem3 = new ACRadioButtonItem();

      visitCareRadioItem3.setText("III型");

      visitCareRadioItem3.setGroup(getVisitCareRadio());

      visitCareRadioItem3.setConstraints(VRLayout.FLOW);

      addVisitCareRadioItem3();
    }
    return visitCareRadioItem3;

  }

  /**
   * 日割を取得します。
   * @return 日割
   */
  public ACIntegerCheckBox getVisitCareCrackOnDayCheck(){
    if(visitCareCrackOnDayCheck==null){

      visitCareCrackOnDayCheck = new ACIntegerCheckBox();

      visitCareCrackOnDayCheck.setText("日割");

      visitCareCrackOnDayCheck.setBindPath("1350106");

      visitCareCrackOnDayCheck.setSelectValue(2);

      visitCareCrackOnDayCheck.setUnSelectValue(1);

      addVisitCareCrackOnDayCheck();
    }
    return visitCareCrackOnDayCheck;

  }

  /**
   * 提供日を取得します。
   * @return 提供日
   */
  public ACIntegerCheckBox getVisitCarePrintable(){
    if(visitCarePrintable==null){

      visitCarePrintable = new ACIntegerCheckBox();

      visitCarePrintable.setText("提供日");

      visitCarePrintable.setBindPath("1350129");

      visitCarePrintable.setSelectValue(2);

      visitCarePrintable.setUnSelectValue(1);

      addVisitCarePrintable();
    }
    return visitCarePrintable;

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

      visitNursingFacilitiesDivisionRadio.setBindPath("1350107");

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

      visitNursingStaffDivisionRadio.setBindPath("1350108");

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

      twoOrMoreTimesCheck.setBindPath("1350132");

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

      visitNursingCombo.setBindPath("1350109");

      visitNursingCombo.setEditable(false);

      visitNursingCombo.setModelBindPath("1350109");

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

      nurseStaffDivisionRadioGroup.setBindPath("1350136");

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

      visitRehabiliRadio.setBindPath("1350110");

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
   * 日割を取得します。
   * @return 日割
   */
  public ACIntegerCheckBox getExpertPlaceNursingCrackOnDayChaeck(){
    if(expertPlaceNursingCrackOnDayChaeck==null){

      expertPlaceNursingCrackOnDayChaeck = new ACIntegerCheckBox();

      expertPlaceNursingCrackOnDayChaeck.setText("日割");

      expertPlaceNursingCrackOnDayChaeck.setBindPath("1350111");

      expertPlaceNursingCrackOnDayChaeck.setSelectValue(2);

      expertPlaceNursingCrackOnDayChaeck.setUnSelectValue(1);

      addExpertPlaceNursingCrackOnDayChaeck();
    }
    return expertPlaceNursingCrackOnDayChaeck;

  }

  /**
   * 提供日を取得します。
   * @return 提供日
   */
  public ACIntegerCheckBox getExpertPlaceNursingPrintable(){
    if(expertPlaceNursingPrintable==null){

      expertPlaceNursingPrintable = new ACIntegerCheckBox();

      expertPlaceNursingPrintable.setText("提供日");

      expertPlaceNursingPrintable.setBindPath("1350130");

      expertPlaceNursingPrintable.setSelectValue(2);

      expertPlaceNursingPrintable.setUnSelectValue(1);

      addExpertPlaceNursingPrintable();
    }
    return expertPlaceNursingPrintable;

  }

  /**
   * 運動器機能向上加算を取得します。
   * @return 運動器機能向上加算
   */
  public ACValueArrayRadioButtonGroup getExpertPlaceNursingMovementFunctionImprovementAddRadio(){
    if(expertPlaceNursingMovementFunctionImprovementAddRadio==null){

      expertPlaceNursingMovementFunctionImprovementAddRadio = new ACValueArrayRadioButtonGroup();

      getExpertPlaceNursingMovementFunctionImprovementAddRadioContainer().setText("運動器機能向上加算");

      expertPlaceNursingMovementFunctionImprovementAddRadio.setBindPath("1350112");

      expertPlaceNursingMovementFunctionImprovementAddRadio.setUseClearButton(false);

      expertPlaceNursingMovementFunctionImprovementAddRadio.setModel(getExpertPlaceNursingMovementFunctionImprovementAddRadioModel());

      expertPlaceNursingMovementFunctionImprovementAddRadio.setValues(new int[]{1,2});

      addExpertPlaceNursingMovementFunctionImprovementAddRadio();
    }
    return expertPlaceNursingMovementFunctionImprovementAddRadio;

  }

  /**
   * 運動器機能向上加算コンテナを取得します。
   * @return 運動器機能向上加算コンテナ
   */
  protected ACLabelContainer getExpertPlaceNursingMovementFunctionImprovementAddRadioContainer(){
    if(expertPlaceNursingMovementFunctionImprovementAddRadioContainer==null){
      expertPlaceNursingMovementFunctionImprovementAddRadioContainer = new ACLabelContainer();
      expertPlaceNursingMovementFunctionImprovementAddRadioContainer.setFollowChildEnabled(true);
      expertPlaceNursingMovementFunctionImprovementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      expertPlaceNursingMovementFunctionImprovementAddRadioContainer.add(getExpertPlaceNursingMovementFunctionImprovementAddRadio(), null);
    }
    return expertPlaceNursingMovementFunctionImprovementAddRadioContainer;
  }

  /**
   * 運動器機能向上加算モデルを取得します。
   * @return 運動器機能向上加算モデル
   */
  protected ACListModelAdapter getExpertPlaceNursingMovementFunctionImprovementAddRadioModel(){
    if(expertPlaceNursingMovementFunctionImprovementAddRadioModel==null){
      expertPlaceNursingMovementFunctionImprovementAddRadioModel = new ACListModelAdapter();
      addExpertPlaceNursingMovementFunctionImprovementAddRadioModel();
    }
    return expertPlaceNursingMovementFunctionImprovementAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getExpertPlaceNursingMovementFunctionImprovementAddRadioItem1(){
    if(expertPlaceNursingMovementFunctionImprovementAddRadioItem1==null){

      expertPlaceNursingMovementFunctionImprovementAddRadioItem1 = new ACRadioButtonItem();

      expertPlaceNursingMovementFunctionImprovementAddRadioItem1.setText("なし");

      expertPlaceNursingMovementFunctionImprovementAddRadioItem1.setGroup(getExpertPlaceNursingMovementFunctionImprovementAddRadio());

      expertPlaceNursingMovementFunctionImprovementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addExpertPlaceNursingMovementFunctionImprovementAddRadioItem1();
    }
    return expertPlaceNursingMovementFunctionImprovementAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getExpertPlaceNursingMovementFunctionImprovementAddRadioItem2(){
    if(expertPlaceNursingMovementFunctionImprovementAddRadioItem2==null){

      expertPlaceNursingMovementFunctionImprovementAddRadioItem2 = new ACRadioButtonItem();

      expertPlaceNursingMovementFunctionImprovementAddRadioItem2.setText("あり");

      expertPlaceNursingMovementFunctionImprovementAddRadioItem2.setGroup(getExpertPlaceNursingMovementFunctionImprovementAddRadio());

      expertPlaceNursingMovementFunctionImprovementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addExpertPlaceNursingMovementFunctionImprovementAddRadioItem2();
    }
    return expertPlaceNursingMovementFunctionImprovementAddRadioItem2;

  }

  /**
   * 栄養改善加算を取得します。
   * @return 栄養改善加算
   */
  public ACValueArrayRadioButtonGroup getExpertPlaceNursingNourishmentImprovementAddRadio(){
    if(expertPlaceNursingNourishmentImprovementAddRadio==null){

      expertPlaceNursingNourishmentImprovementAddRadio = new ACValueArrayRadioButtonGroup();

      getExpertPlaceNursingNourishmentImprovementAddRadioContainer().setText("栄養改善加算");

      expertPlaceNursingNourishmentImprovementAddRadio.setBindPath("1350113");

      expertPlaceNursingNourishmentImprovementAddRadio.setUseClearButton(false);

      expertPlaceNursingNourishmentImprovementAddRadio.setModel(getExpertPlaceNursingNourishmentImprovementAddRadioModel());

      expertPlaceNursingNourishmentImprovementAddRadio.setValues(new int[]{1,2});

      addExpertPlaceNursingNourishmentImprovementAddRadio();
    }
    return expertPlaceNursingNourishmentImprovementAddRadio;

  }

  /**
   * 栄養改善加算コンテナを取得します。
   * @return 栄養改善加算コンテナ
   */
  protected ACLabelContainer getExpertPlaceNursingNourishmentImprovementAddRadioContainer(){
    if(expertPlaceNursingNourishmentImprovementAddRadioContainer==null){
      expertPlaceNursingNourishmentImprovementAddRadioContainer = new ACLabelContainer();
      expertPlaceNursingNourishmentImprovementAddRadioContainer.setFollowChildEnabled(true);
      expertPlaceNursingNourishmentImprovementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      expertPlaceNursingNourishmentImprovementAddRadioContainer.add(getExpertPlaceNursingNourishmentImprovementAddRadio(), null);
    }
    return expertPlaceNursingNourishmentImprovementAddRadioContainer;
  }

  /**
   * 栄養改善加算モデルを取得します。
   * @return 栄養改善加算モデル
   */
  protected ACListModelAdapter getExpertPlaceNursingNourishmentImprovementAddRadioModel(){
    if(expertPlaceNursingNourishmentImprovementAddRadioModel==null){
      expertPlaceNursingNourishmentImprovementAddRadioModel = new ACListModelAdapter();
      addExpertPlaceNursingNourishmentImprovementAddRadioModel();
    }
    return expertPlaceNursingNourishmentImprovementAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getExpertPlaceNursingNourishmentImprovementAddRadioItem1(){
    if(expertPlaceNursingNourishmentImprovementAddRadioItem1==null){

      expertPlaceNursingNourishmentImprovementAddRadioItem1 = new ACRadioButtonItem();

      expertPlaceNursingNourishmentImprovementAddRadioItem1.setText("なし");

      expertPlaceNursingNourishmentImprovementAddRadioItem1.setGroup(getExpertPlaceNursingNourishmentImprovementAddRadio());

      expertPlaceNursingNourishmentImprovementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addExpertPlaceNursingNourishmentImprovementAddRadioItem1();
    }
    return expertPlaceNursingNourishmentImprovementAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getExpertPlaceNursingNourishmentImprovementAddRadioItem2(){
    if(expertPlaceNursingNourishmentImprovementAddRadioItem2==null){

      expertPlaceNursingNourishmentImprovementAddRadioItem2 = new ACRadioButtonItem();

      expertPlaceNursingNourishmentImprovementAddRadioItem2.setText("あり");

      expertPlaceNursingNourishmentImprovementAddRadioItem2.setGroup(getExpertPlaceNursingNourishmentImprovementAddRadio());

      expertPlaceNursingNourishmentImprovementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addExpertPlaceNursingNourishmentImprovementAddRadioItem2();
    }
    return expertPlaceNursingNourishmentImprovementAddRadioItem2;

  }

  /**
   * 口腔機能向上加算を取得します。
   * @return 口腔機能向上加算
   */
  public ACValueArrayRadioButtonGroup getExpertPlaceNursingMouthFunctionImprovementAddRadio(){
    if(expertPlaceNursingMouthFunctionImprovementAddRadio==null){

      expertPlaceNursingMouthFunctionImprovementAddRadio = new ACValueArrayRadioButtonGroup();

      getExpertPlaceNursingMouthFunctionImprovementAddRadioContainer().setText("口腔機能向上加算");

      expertPlaceNursingMouthFunctionImprovementAddRadio.setBindPath("1350114");

      expertPlaceNursingMouthFunctionImprovementAddRadio.setUseClearButton(false);

      expertPlaceNursingMouthFunctionImprovementAddRadio.setModel(getExpertPlaceNursingMouthFunctionImprovementAddRadioModel());

      expertPlaceNursingMouthFunctionImprovementAddRadio.setValues(new int[]{1,2});

      addExpertPlaceNursingMouthFunctionImprovementAddRadio();
    }
    return expertPlaceNursingMouthFunctionImprovementAddRadio;

  }

  /**
   * 口腔機能向上加算コンテナを取得します。
   * @return 口腔機能向上加算コンテナ
   */
  protected ACLabelContainer getExpertPlaceNursingMouthFunctionImprovementAddRadioContainer(){
    if(expertPlaceNursingMouthFunctionImprovementAddRadioContainer==null){
      expertPlaceNursingMouthFunctionImprovementAddRadioContainer = new ACLabelContainer();
      expertPlaceNursingMouthFunctionImprovementAddRadioContainer.setFollowChildEnabled(true);
      expertPlaceNursingMouthFunctionImprovementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      expertPlaceNursingMouthFunctionImprovementAddRadioContainer.add(getExpertPlaceNursingMouthFunctionImprovementAddRadio(), null);
    }
    return expertPlaceNursingMouthFunctionImprovementAddRadioContainer;
  }

  /**
   * 口腔機能向上加算モデルを取得します。
   * @return 口腔機能向上加算モデル
   */
  protected ACListModelAdapter getExpertPlaceNursingMouthFunctionImprovementAddRadioModel(){
    if(expertPlaceNursingMouthFunctionImprovementAddRadioModel==null){
      expertPlaceNursingMouthFunctionImprovementAddRadioModel = new ACListModelAdapter();
      addExpertPlaceNursingMouthFunctionImprovementAddRadioModel();
    }
    return expertPlaceNursingMouthFunctionImprovementAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getExpertPlaceNursingMouthFunctionImprovementAddRadioItem1(){
    if(expertPlaceNursingMouthFunctionImprovementAddRadioItem1==null){

      expertPlaceNursingMouthFunctionImprovementAddRadioItem1 = new ACRadioButtonItem();

      expertPlaceNursingMouthFunctionImprovementAddRadioItem1.setText("なし");

      expertPlaceNursingMouthFunctionImprovementAddRadioItem1.setGroup(getExpertPlaceNursingMouthFunctionImprovementAddRadio());

      expertPlaceNursingMouthFunctionImprovementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addExpertPlaceNursingMouthFunctionImprovementAddRadioItem1();
    }
    return expertPlaceNursingMouthFunctionImprovementAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getExpertPlaceNursingMouthFunctionImprovementAddRadioItem2(){
    if(expertPlaceNursingMouthFunctionImprovementAddRadioItem2==null){

      expertPlaceNursingMouthFunctionImprovementAddRadioItem2 = new ACRadioButtonItem();

      expertPlaceNursingMouthFunctionImprovementAddRadioItem2.setText("あり");

      expertPlaceNursingMouthFunctionImprovementAddRadioItem2.setGroup(getExpertPlaceNursingMouthFunctionImprovementAddRadio());

      expertPlaceNursingMouthFunctionImprovementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addExpertPlaceNursingMouthFunctionImprovementAddRadioItem2();
    }
    return expertPlaceNursingMouthFunctionImprovementAddRadioItem2;

  }

  /**
   * 選択的サービス複数実施加算を取得します。
   * @return 選択的サービス複数実施加算
   */
  public ACValueArrayRadioButtonGroup getExpertPlaceNursingSentakutekiServiceRadio(){
    if(expertPlaceNursingSentakutekiServiceRadio==null){

      expertPlaceNursingSentakutekiServiceRadio = new ACValueArrayRadioButtonGroup();

      getExpertPlaceNursingSentakutekiServiceRadioContainer().setText("選択的サービス" + ACConstants.LINE_SEPARATOR + "複数実施加算");

      expertPlaceNursingSentakutekiServiceRadio.setBindPath("1350145");

      expertPlaceNursingSentakutekiServiceRadio.setUseClearButton(false);

      expertPlaceNursingSentakutekiServiceRadio.setModel(getExpertPlaceNursingSentakutekiServiceRadioModel());

      expertPlaceNursingSentakutekiServiceRadio.setValues(new int[]{1,2,3,4,5});

      addExpertPlaceNursingSentakutekiServiceRadio();
    }
    return expertPlaceNursingSentakutekiServiceRadio;

  }

  /**
   * 選択的サービス複数実施加算コンテナを取得します。
   * @return 選択的サービス複数実施加算コンテナ
   */
  protected ACLabelContainer getExpertPlaceNursingSentakutekiServiceRadioContainer(){
    if(expertPlaceNursingSentakutekiServiceRadioContainer==null){
      expertPlaceNursingSentakutekiServiceRadioContainer = new ACLabelContainer();
      expertPlaceNursingSentakutekiServiceRadioContainer.setFollowChildEnabled(true);
      expertPlaceNursingSentakutekiServiceRadioContainer.setVAlignment(VRLayout.CENTER);
      expertPlaceNursingSentakutekiServiceRadioContainer.add(getExpertPlaceNursingSentakutekiServiceRadio(), null);
    }
    return expertPlaceNursingSentakutekiServiceRadioContainer;
  }

  /**
   * 選択的サービス複数実施加算モデルを取得します。
   * @return 選択的サービス複数実施加算モデル
   */
  protected ACListModelAdapter getExpertPlaceNursingSentakutekiServiceRadioModel(){
    if(expertPlaceNursingSentakutekiServiceRadioModel==null){
      expertPlaceNursingSentakutekiServiceRadioModel = new ACListModelAdapter();
      addExpertPlaceNursingSentakutekiServiceRadioModel();
    }
    return expertPlaceNursingSentakutekiServiceRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getExpertPlaceNursingSentakutekiServiceRadioItem1(){
    if(expertPlaceNursingSentakutekiServiceRadioItem1==null){

      expertPlaceNursingSentakutekiServiceRadioItem1 = new ACRadioButtonItem();

      expertPlaceNursingSentakutekiServiceRadioItem1.setText("なし");

      expertPlaceNursingSentakutekiServiceRadioItem1.setGroup(getExpertPlaceNursingSentakutekiServiceRadio());

      expertPlaceNursingSentakutekiServiceRadioItem1.setConstraints(VRLayout.FLOW);

      addExpertPlaceNursingSentakutekiServiceRadioItem1();
    }
    return expertPlaceNursingSentakutekiServiceRadioItem1;

  }

  /**
   * I1を取得します。
   * @return I1
   */
  public ACRadioButtonItem getExpertPlaceNursingSentakutekiServiceRadioItem2(){
    if(expertPlaceNursingSentakutekiServiceRadioItem2==null){

      expertPlaceNursingSentakutekiServiceRadioItem2 = new ACRadioButtonItem();

      expertPlaceNursingSentakutekiServiceRadioItem2.setText("I1");

      expertPlaceNursingSentakutekiServiceRadioItem2.setGroup(getExpertPlaceNursingSentakutekiServiceRadio());

      expertPlaceNursingSentakutekiServiceRadioItem2.setConstraints(VRLayout.FLOW);

      addExpertPlaceNursingSentakutekiServiceRadioItem2();
    }
    return expertPlaceNursingSentakutekiServiceRadioItem2;

  }

  /**
   * I2を取得します。
   * @return I2
   */
  public ACRadioButtonItem getExpertPlaceNursingSentakutekiServiceRadioItem3(){
    if(expertPlaceNursingSentakutekiServiceRadioItem3==null){

      expertPlaceNursingSentakutekiServiceRadioItem3 = new ACRadioButtonItem();

      expertPlaceNursingSentakutekiServiceRadioItem3.setText("I2");

      expertPlaceNursingSentakutekiServiceRadioItem3.setGroup(getExpertPlaceNursingSentakutekiServiceRadio());

      expertPlaceNursingSentakutekiServiceRadioItem3.setConstraints(VRLayout.FLOW);

      addExpertPlaceNursingSentakutekiServiceRadioItem3();
    }
    return expertPlaceNursingSentakutekiServiceRadioItem3;

  }

  /**
   * I3を取得します。
   * @return I3
   */
  public ACRadioButtonItem getExpertPlaceNursingSentakutekiServiceRadioItem4(){
    if(expertPlaceNursingSentakutekiServiceRadioItem4==null){

      expertPlaceNursingSentakutekiServiceRadioItem4 = new ACRadioButtonItem();

      expertPlaceNursingSentakutekiServiceRadioItem4.setText("I3");

      expertPlaceNursingSentakutekiServiceRadioItem4.setGroup(getExpertPlaceNursingSentakutekiServiceRadio());

      expertPlaceNursingSentakutekiServiceRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addExpertPlaceNursingSentakutekiServiceRadioItem4();
    }
    return expertPlaceNursingSentakutekiServiceRadioItem4;

  }

  /**
   * IIを取得します。
   * @return II
   */
  public ACRadioButtonItem getExpertPlaceNursingSentakutekiServiceRadioItem5(){
    if(expertPlaceNursingSentakutekiServiceRadioItem5==null){

      expertPlaceNursingSentakutekiServiceRadioItem5 = new ACRadioButtonItem();

      expertPlaceNursingSentakutekiServiceRadioItem5.setText("II");

      expertPlaceNursingSentakutekiServiceRadioItem5.setGroup(getExpertPlaceNursingSentakutekiServiceRadio());

      expertPlaceNursingSentakutekiServiceRadioItem5.setConstraints(VRLayout.FLOW);

      addExpertPlaceNursingSentakutekiServiceRadioItem5();
    }
    return expertPlaceNursingSentakutekiServiceRadioItem5;

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

      tabPanel5.setLabelMargin(0);

      tabPanel5.setVgap(0);

      addTabPanel5();
    }
    return tabPanel5;

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
   * 日割を取得します。
   * @return 日割
   */
  public ACIntegerCheckBox getExpertPlaceRehabiliCrackOnDay(){
    if(expertPlaceRehabiliCrackOnDay==null){

      expertPlaceRehabiliCrackOnDay = new ACIntegerCheckBox();

      expertPlaceRehabiliCrackOnDay.setText("日割");

      expertPlaceRehabiliCrackOnDay.setBindPath("1350115");

      expertPlaceRehabiliCrackOnDay.setSelectValue(2);

      expertPlaceRehabiliCrackOnDay.setUnSelectValue(1);

      addExpertPlaceRehabiliCrackOnDay();
    }
    return expertPlaceRehabiliCrackOnDay;

  }

  /**
   * 提供日を取得します。
   * @return 提供日
   */
  public ACIntegerCheckBox getExpertPlaceRehabiliPrintable(){
    if(expertPlaceRehabiliPrintable==null){

      expertPlaceRehabiliPrintable = new ACIntegerCheckBox();

      expertPlaceRehabiliPrintable.setText("提供日");

      expertPlaceRehabiliPrintable.setBindPath("1350131");

      expertPlaceRehabiliPrintable.setSelectValue(2);

      expertPlaceRehabiliPrintable.setUnSelectValue(1);

      addExpertPlaceRehabiliPrintable();
    }
    return expertPlaceRehabiliPrintable;

  }

  /**
   * 施設等の区分を取得します。
   * @return 施設等の区分
   */
  public ACValueArrayRadioButtonGroup getExpertPlaceRehabiliRadio(){
    if(expertPlaceRehabiliRadio==null){

      expertPlaceRehabiliRadio = new ACValueArrayRadioButtonGroup();

      getExpertPlaceRehabiliRadioContainer().setText("施設等の区分");

      expertPlaceRehabiliRadio.setBindPath("1350133");

      expertPlaceRehabiliRadio.setUseClearButton(false);

      expertPlaceRehabiliRadio.setModel(getExpertPlaceRehabiliRadioModel());

      expertPlaceRehabiliRadio.setValues(new int[]{1,2});

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
   * 病院又は診療所を取得します。
   * @return 病院又は診療所
   */
  public ACRadioButtonItem getExpertPlaceRehabiliRadioItem1(){
    if(expertPlaceRehabiliRadioItem1==null){

      expertPlaceRehabiliRadioItem1 = new ACRadioButtonItem();

      expertPlaceRehabiliRadioItem1.setText("病院又は診療所");

      expertPlaceRehabiliRadioItem1.setGroup(getExpertPlaceRehabiliRadio());

      expertPlaceRehabiliRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addExpertPlaceRehabiliRadioItem1();
    }
    return expertPlaceRehabiliRadioItem1;

  }

  /**
   * 介護老人保健施設を取得します。
   * @return 介護老人保健施設
   */
  public ACRadioButtonItem getExpertPlaceRehabiliRadioItem2(){
    if(expertPlaceRehabiliRadioItem2==null){

      expertPlaceRehabiliRadioItem2 = new ACRadioButtonItem();

      expertPlaceRehabiliRadioItem2.setText("介護老人保健施設");

      expertPlaceRehabiliRadioItem2.setGroup(getExpertPlaceRehabiliRadio());

      expertPlaceRehabiliRadioItem2.setConstraints(VRLayout.FLOW);

      addExpertPlaceRehabiliRadioItem2();
    }
    return expertPlaceRehabiliRadioItem2;

  }

  /**
   * 運動器機能向上加算を取得します。
   * @return 運動器機能向上加算
   */
  public ACValueArrayRadioButtonGroup getExpertPlaceRehabiliMovementFunctionImprovementAddRadio(){
    if(expertPlaceRehabiliMovementFunctionImprovementAddRadio==null){

      expertPlaceRehabiliMovementFunctionImprovementAddRadio = new ACValueArrayRadioButtonGroup();

      getExpertPlaceRehabiliMovementFunctionImprovementAddRadioContainer().setText("運動器機能向上加算");

      expertPlaceRehabiliMovementFunctionImprovementAddRadio.setBindPath("1350116");

      expertPlaceRehabiliMovementFunctionImprovementAddRadio.setUseClearButton(false);

      expertPlaceRehabiliMovementFunctionImprovementAddRadio.setModel(getExpertPlaceRehabiliMovementFunctionImprovementAddRadioModel());

      expertPlaceRehabiliMovementFunctionImprovementAddRadio.setValues(new int[]{1,2});

      addExpertPlaceRehabiliMovementFunctionImprovementAddRadio();
    }
    return expertPlaceRehabiliMovementFunctionImprovementAddRadio;

  }

  /**
   * 運動器機能向上加算コンテナを取得します。
   * @return 運動器機能向上加算コンテナ
   */
  protected ACLabelContainer getExpertPlaceRehabiliMovementFunctionImprovementAddRadioContainer(){
    if(expertPlaceRehabiliMovementFunctionImprovementAddRadioContainer==null){
      expertPlaceRehabiliMovementFunctionImprovementAddRadioContainer = new ACLabelContainer();
      expertPlaceRehabiliMovementFunctionImprovementAddRadioContainer.setFollowChildEnabled(true);
      expertPlaceRehabiliMovementFunctionImprovementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      expertPlaceRehabiliMovementFunctionImprovementAddRadioContainer.add(getExpertPlaceRehabiliMovementFunctionImprovementAddRadio(), null);
    }
    return expertPlaceRehabiliMovementFunctionImprovementAddRadioContainer;
  }

  /**
   * 運動器機能向上加算モデルを取得します。
   * @return 運動器機能向上加算モデル
   */
  protected ACListModelAdapter getExpertPlaceRehabiliMovementFunctionImprovementAddRadioModel(){
    if(expertPlaceRehabiliMovementFunctionImprovementAddRadioModel==null){
      expertPlaceRehabiliMovementFunctionImprovementAddRadioModel = new ACListModelAdapter();
      addExpertPlaceRehabiliMovementFunctionImprovementAddRadioModel();
    }
    return expertPlaceRehabiliMovementFunctionImprovementAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getExpertPlaceRehabiliMovementFunctionImprovementAddRadioItem1(){
    if(expertPlaceRehabiliMovementFunctionImprovementAddRadioItem1==null){

      expertPlaceRehabiliMovementFunctionImprovementAddRadioItem1 = new ACRadioButtonItem();

      expertPlaceRehabiliMovementFunctionImprovementAddRadioItem1.setText("なし");

      expertPlaceRehabiliMovementFunctionImprovementAddRadioItem1.setGroup(getExpertPlaceRehabiliMovementFunctionImprovementAddRadio());

      expertPlaceRehabiliMovementFunctionImprovementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addExpertPlaceRehabiliMovementFunctionImprovementAddRadioItem1();
    }
    return expertPlaceRehabiliMovementFunctionImprovementAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getExpertPlaceRehabiliMovementFunctionImprovementAddRadioItem2(){
    if(expertPlaceRehabiliMovementFunctionImprovementAddRadioItem2==null){

      expertPlaceRehabiliMovementFunctionImprovementAddRadioItem2 = new ACRadioButtonItem();

      expertPlaceRehabiliMovementFunctionImprovementAddRadioItem2.setText("あり");

      expertPlaceRehabiliMovementFunctionImprovementAddRadioItem2.setGroup(getExpertPlaceRehabiliMovementFunctionImprovementAddRadio());

      expertPlaceRehabiliMovementFunctionImprovementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addExpertPlaceRehabiliMovementFunctionImprovementAddRadioItem2();
    }
    return expertPlaceRehabiliMovementFunctionImprovementAddRadioItem2;

  }

  /**
   * 栄養改善加算を取得します。
   * @return 栄養改善加算
   */
  public ACValueArrayRadioButtonGroup getExpertPlaceRehabiliNourishmentImprovementAddRadio(){
    if(expertPlaceRehabiliNourishmentImprovementAddRadio==null){

      expertPlaceRehabiliNourishmentImprovementAddRadio = new ACValueArrayRadioButtonGroup();

      getExpertPlaceRehabiliNourishmentImprovementAddRadioContainer().setText("栄養改善加算");

      expertPlaceRehabiliNourishmentImprovementAddRadio.setBindPath("1350117");

      expertPlaceRehabiliNourishmentImprovementAddRadio.setUseClearButton(false);

      expertPlaceRehabiliNourishmentImprovementAddRadio.setModel(getExpertPlaceRehabiliNourishmentImprovementAddRadioModel());

      expertPlaceRehabiliNourishmentImprovementAddRadio.setValues(new int[]{1,2});

      addExpertPlaceRehabiliNourishmentImprovementAddRadio();
    }
    return expertPlaceRehabiliNourishmentImprovementAddRadio;

  }

  /**
   * 栄養改善加算コンテナを取得します。
   * @return 栄養改善加算コンテナ
   */
  protected ACLabelContainer getExpertPlaceRehabiliNourishmentImprovementAddRadioContainer(){
    if(expertPlaceRehabiliNourishmentImprovementAddRadioContainer==null){
      expertPlaceRehabiliNourishmentImprovementAddRadioContainer = new ACLabelContainer();
      expertPlaceRehabiliNourishmentImprovementAddRadioContainer.setFollowChildEnabled(true);
      expertPlaceRehabiliNourishmentImprovementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      expertPlaceRehabiliNourishmentImprovementAddRadioContainer.add(getExpertPlaceRehabiliNourishmentImprovementAddRadio(), null);
    }
    return expertPlaceRehabiliNourishmentImprovementAddRadioContainer;
  }

  /**
   * 栄養改善加算モデルを取得します。
   * @return 栄養改善加算モデル
   */
  protected ACListModelAdapter getExpertPlaceRehabiliNourishmentImprovementAddRadioModel(){
    if(expertPlaceRehabiliNourishmentImprovementAddRadioModel==null){
      expertPlaceRehabiliNourishmentImprovementAddRadioModel = new ACListModelAdapter();
      addExpertPlaceRehabiliNourishmentImprovementAddRadioModel();
    }
    return expertPlaceRehabiliNourishmentImprovementAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getExpertPlaceRehabiliNourishmentImprovementAddRadioItem1(){
    if(expertPlaceRehabiliNourishmentImprovementAddRadioItem1==null){

      expertPlaceRehabiliNourishmentImprovementAddRadioItem1 = new ACRadioButtonItem();

      expertPlaceRehabiliNourishmentImprovementAddRadioItem1.setText("なし");

      expertPlaceRehabiliNourishmentImprovementAddRadioItem1.setGroup(getExpertPlaceRehabiliNourishmentImprovementAddRadio());

      expertPlaceRehabiliNourishmentImprovementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addExpertPlaceRehabiliNourishmentImprovementAddRadioItem1();
    }
    return expertPlaceRehabiliNourishmentImprovementAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getExpertPlaceRehabiliNourishmentImprovementAddRadioItem2(){
    if(expertPlaceRehabiliNourishmentImprovementAddRadioItem2==null){

      expertPlaceRehabiliNourishmentImprovementAddRadioItem2 = new ACRadioButtonItem();

      expertPlaceRehabiliNourishmentImprovementAddRadioItem2.setText("あり");

      expertPlaceRehabiliNourishmentImprovementAddRadioItem2.setGroup(getExpertPlaceRehabiliNourishmentImprovementAddRadio());

      expertPlaceRehabiliNourishmentImprovementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addExpertPlaceRehabiliNourishmentImprovementAddRadioItem2();
    }
    return expertPlaceRehabiliNourishmentImprovementAddRadioItem2;

  }

  /**
   * 口腔機能向上加算を取得します。
   * @return 口腔機能向上加算
   */
  public ACValueArrayRadioButtonGroup getExpertPlaceRehabiliMouthFunctionImprovementAddRadio(){
    if(expertPlaceRehabiliMouthFunctionImprovementAddRadio==null){

      expertPlaceRehabiliMouthFunctionImprovementAddRadio = new ACValueArrayRadioButtonGroup();

      getExpertPlaceRehabiliMouthFunctionImprovementAddRadioContainer().setText("口腔機能向上加算");

      expertPlaceRehabiliMouthFunctionImprovementAddRadio.setBindPath("1350118");

      expertPlaceRehabiliMouthFunctionImprovementAddRadio.setUseClearButton(false);

      expertPlaceRehabiliMouthFunctionImprovementAddRadio.setModel(getExpertPlaceRehabiliMouthFunctionImprovementAddRadioModel());

      expertPlaceRehabiliMouthFunctionImprovementAddRadio.setValues(new int[]{1,2});

      addExpertPlaceRehabiliMouthFunctionImprovementAddRadio();
    }
    return expertPlaceRehabiliMouthFunctionImprovementAddRadio;

  }

  /**
   * 口腔機能向上加算コンテナを取得します。
   * @return 口腔機能向上加算コンテナ
   */
  protected ACLabelContainer getExpertPlaceRehabiliMouthFunctionImprovementAddRadioContainer(){
    if(expertPlaceRehabiliMouthFunctionImprovementAddRadioContainer==null){
      expertPlaceRehabiliMouthFunctionImprovementAddRadioContainer = new ACLabelContainer();
      expertPlaceRehabiliMouthFunctionImprovementAddRadioContainer.setFollowChildEnabled(true);
      expertPlaceRehabiliMouthFunctionImprovementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      expertPlaceRehabiliMouthFunctionImprovementAddRadioContainer.add(getExpertPlaceRehabiliMouthFunctionImprovementAddRadio(), null);
    }
    return expertPlaceRehabiliMouthFunctionImprovementAddRadioContainer;
  }

  /**
   * 口腔機能向上加算モデルを取得します。
   * @return 口腔機能向上加算モデル
   */
  protected ACListModelAdapter getExpertPlaceRehabiliMouthFunctionImprovementAddRadioModel(){
    if(expertPlaceRehabiliMouthFunctionImprovementAddRadioModel==null){
      expertPlaceRehabiliMouthFunctionImprovementAddRadioModel = new ACListModelAdapter();
      addExpertPlaceRehabiliMouthFunctionImprovementAddRadioModel();
    }
    return expertPlaceRehabiliMouthFunctionImprovementAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getExpertPlaceRehabiliMouthFunctionImprovementAddRadioItem1(){
    if(expertPlaceRehabiliMouthFunctionImprovementAddRadioItem1==null){

      expertPlaceRehabiliMouthFunctionImprovementAddRadioItem1 = new ACRadioButtonItem();

      expertPlaceRehabiliMouthFunctionImprovementAddRadioItem1.setText("なし");

      expertPlaceRehabiliMouthFunctionImprovementAddRadioItem1.setGroup(getExpertPlaceRehabiliMouthFunctionImprovementAddRadio());

      expertPlaceRehabiliMouthFunctionImprovementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addExpertPlaceRehabiliMouthFunctionImprovementAddRadioItem1();
    }
    return expertPlaceRehabiliMouthFunctionImprovementAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getExpertPlaceRehabiliMouthFunctionImprovementAddRadioItem2(){
    if(expertPlaceRehabiliMouthFunctionImprovementAddRadioItem2==null){

      expertPlaceRehabiliMouthFunctionImprovementAddRadioItem2 = new ACRadioButtonItem();

      expertPlaceRehabiliMouthFunctionImprovementAddRadioItem2.setText("あり");

      expertPlaceRehabiliMouthFunctionImprovementAddRadioItem2.setGroup(getExpertPlaceRehabiliMouthFunctionImprovementAddRadio());

      expertPlaceRehabiliMouthFunctionImprovementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addExpertPlaceRehabiliMouthFunctionImprovementAddRadioItem2();
    }
    return expertPlaceRehabiliMouthFunctionImprovementAddRadioItem2;

  }

  /**
   * 選択的サービス複数実施加算を取得します。
   * @return 選択的サービス複数実施加算
   */
  public ACValueArrayRadioButtonGroup getExpertPlaceRehabiliSentakutekiServiceRadio(){
    if(expertPlaceRehabiliSentakutekiServiceRadio==null){

      expertPlaceRehabiliSentakutekiServiceRadio = new ACValueArrayRadioButtonGroup();

      getExpertPlaceRehabiliSentakutekiServiceRadioContainer().setText("選択的サービス" + ACConstants.LINE_SEPARATOR + "複数実施加算");

      expertPlaceRehabiliSentakutekiServiceRadio.setBindPath("1350146");

      expertPlaceRehabiliSentakutekiServiceRadio.setUseClearButton(false);

      expertPlaceRehabiliSentakutekiServiceRadio.setModel(getExpertPlaceRehabiliSentakutekiServiceRadioModel());

      expertPlaceRehabiliSentakutekiServiceRadio.setValues(new int[]{1,2,3,4,5});

      addExpertPlaceRehabiliSentakutekiServiceRadio();
    }
    return expertPlaceRehabiliSentakutekiServiceRadio;

  }

  /**
   * 選択的サービス複数実施加算コンテナを取得します。
   * @return 選択的サービス複数実施加算コンテナ
   */
  protected ACLabelContainer getExpertPlaceRehabiliSentakutekiServiceRadioContainer(){
    if(expertPlaceRehabiliSentakutekiServiceRadioContainer==null){
      expertPlaceRehabiliSentakutekiServiceRadioContainer = new ACLabelContainer();
      expertPlaceRehabiliSentakutekiServiceRadioContainer.setFollowChildEnabled(true);
      expertPlaceRehabiliSentakutekiServiceRadioContainer.setVAlignment(VRLayout.CENTER);
      expertPlaceRehabiliSentakutekiServiceRadioContainer.add(getExpertPlaceRehabiliSentakutekiServiceRadio(), null);
    }
    return expertPlaceRehabiliSentakutekiServiceRadioContainer;
  }

  /**
   * 選択的サービス複数実施加算モデルを取得します。
   * @return 選択的サービス複数実施加算モデル
   */
  protected ACListModelAdapter getExpertPlaceRehabiliSentakutekiServiceRadioModel(){
    if(expertPlaceRehabiliSentakutekiServiceRadioModel==null){
      expertPlaceRehabiliSentakutekiServiceRadioModel = new ACListModelAdapter();
      addExpertPlaceRehabiliSentakutekiServiceRadioModel();
    }
    return expertPlaceRehabiliSentakutekiServiceRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getExpertPlaceRehabiliSentakutekiServiceRadioItem1(){
    if(expertPlaceRehabiliSentakutekiServiceRadioItem1==null){

      expertPlaceRehabiliSentakutekiServiceRadioItem1 = new ACRadioButtonItem();

      expertPlaceRehabiliSentakutekiServiceRadioItem1.setText("なし");

      expertPlaceRehabiliSentakutekiServiceRadioItem1.setGroup(getExpertPlaceRehabiliSentakutekiServiceRadio());

      expertPlaceRehabiliSentakutekiServiceRadioItem1.setConstraints(VRLayout.FLOW);

      addExpertPlaceRehabiliSentakutekiServiceRadioItem1();
    }
    return expertPlaceRehabiliSentakutekiServiceRadioItem1;

  }

  /**
   * I1を取得します。
   * @return I1
   */
  public ACRadioButtonItem getExpertPlaceRehabiliSentakutekiServiceRadioItem2(){
    if(expertPlaceRehabiliSentakutekiServiceRadioItem2==null){

      expertPlaceRehabiliSentakutekiServiceRadioItem2 = new ACRadioButtonItem();

      expertPlaceRehabiliSentakutekiServiceRadioItem2.setText("I1");

      expertPlaceRehabiliSentakutekiServiceRadioItem2.setGroup(getExpertPlaceRehabiliSentakutekiServiceRadio());

      expertPlaceRehabiliSentakutekiServiceRadioItem2.setConstraints(VRLayout.FLOW);

      addExpertPlaceRehabiliSentakutekiServiceRadioItem2();
    }
    return expertPlaceRehabiliSentakutekiServiceRadioItem2;

  }

  /**
   * I2を取得します。
   * @return I2
   */
  public ACRadioButtonItem getExpertPlaceRehabiliSentakutekiServiceRadioItem3(){
    if(expertPlaceRehabiliSentakutekiServiceRadioItem3==null){

      expertPlaceRehabiliSentakutekiServiceRadioItem3 = new ACRadioButtonItem();

      expertPlaceRehabiliSentakutekiServiceRadioItem3.setText("I2");

      expertPlaceRehabiliSentakutekiServiceRadioItem3.setGroup(getExpertPlaceRehabiliSentakutekiServiceRadio());

      expertPlaceRehabiliSentakutekiServiceRadioItem3.setConstraints(VRLayout.FLOW);

      addExpertPlaceRehabiliSentakutekiServiceRadioItem3();
    }
    return expertPlaceRehabiliSentakutekiServiceRadioItem3;

  }

  /**
   * I3を取得します。
   * @return I3
   */
  public ACRadioButtonItem getExpertPlaceRehabiliSentakutekiServiceRadioItem4(){
    if(expertPlaceRehabiliSentakutekiServiceRadioItem4==null){

      expertPlaceRehabiliSentakutekiServiceRadioItem4 = new ACRadioButtonItem();

      expertPlaceRehabiliSentakutekiServiceRadioItem4.setText("I3");

      expertPlaceRehabiliSentakutekiServiceRadioItem4.setGroup(getExpertPlaceRehabiliSentakutekiServiceRadio());

      expertPlaceRehabiliSentakutekiServiceRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addExpertPlaceRehabiliSentakutekiServiceRadioItem4();
    }
    return expertPlaceRehabiliSentakutekiServiceRadioItem4;

  }

  /**
   * IIを取得します。
   * @return II
   */
  public ACRadioButtonItem getExpertPlaceRehabiliSentakutekiServiceRadioItem5(){
    if(expertPlaceRehabiliSentakutekiServiceRadioItem5==null){

      expertPlaceRehabiliSentakutekiServiceRadioItem5 = new ACRadioButtonItem();

      expertPlaceRehabiliSentakutekiServiceRadioItem5.setText("II");

      expertPlaceRehabiliSentakutekiServiceRadioItem5.setGroup(getExpertPlaceRehabiliSentakutekiServiceRadio());

      expertPlaceRehabiliSentakutekiServiceRadioItem5.setConstraints(VRLayout.FLOW);

      addExpertPlaceRehabiliSentakutekiServiceRadioItem5();
    }
    return expertPlaceRehabiliSentakutekiServiceRadioItem5;

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

      tabPanel6.setLabelMargin(0);

      tabPanel6.setVgap(0);

      addTabPanel6();
    }
    return tabPanel6;

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

      welfareToolsCombo.setBindPath("1350119");

      welfareToolsCombo.setEditable(false);

      welfareToolsCombo.setColumns(4);

      welfareToolsCombo.setModelBindPath("1350119");

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

      welfarePointText.setBindPath("1350120");

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

      welfareTekiyoText.setBindPath("1170104");

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
   * タブパネル7を取得します。
   * @return タブパネル7
   */
  public ACPanel getTabPanel7(){
    if(tabPanel7==null){

      tabPanel7 = new ACPanel();

      tabPanel7.setFollowChildEnabled(true);

      tabPanel7.setHgap(0);

      tabPanel7.setLabelMargin(0);

      tabPanel7.setVgap(0);

      addTabPanel7();
    }
    return tabPanel7;

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

      providerDivisionRadio.setBindPath("1350121");

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

      divisionRadion.setBindPath("1350122");

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

      timeDivisionRadio.setBindPath("1350123");

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

      timeDivisionRadioItem2.setText("3から4時間");

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

      timeDivisionRadioItem3.setText("4から6時間");

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

      timeDivisionRadioItem4.setText("6から8時間");

      timeDivisionRadioItem4.setGroup(getTimeDivisionRadio());

      timeDivisionRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addTimeDivisionRadioItem4();
    }
    return timeDivisionRadioItem4;

  }

  /**
   * 個別機能訓練加算を取得します。
   * @return 個別機能訓練加算
   */
  public ACValueArrayRadioButtonGroup getNinchishoTaioTsushoIndividualFunctionTrainingAddRadio(){
    if(ninchishoTaioTsushoIndividualFunctionTrainingAddRadio==null){

      ninchishoTaioTsushoIndividualFunctionTrainingAddRadio = new ACValueArrayRadioButtonGroup();

      getNinchishoTaioTsushoIndividualFunctionTrainingAddRadioContainer().setText("個別機能訓練加算");

      ninchishoTaioTsushoIndividualFunctionTrainingAddRadio.setBindPath("1350124");

      ninchishoTaioTsushoIndividualFunctionTrainingAddRadio.setUseClearButton(false);

      ninchishoTaioTsushoIndividualFunctionTrainingAddRadio.setModel(getNinchishoTaioTsushoIndividualFunctionTrainingAddRadioModel());

      ninchishoTaioTsushoIndividualFunctionTrainingAddRadio.setValues(new int[]{1,2});

      addNinchishoTaioTsushoIndividualFunctionTrainingAddRadio();
    }
    return ninchishoTaioTsushoIndividualFunctionTrainingAddRadio;

  }

  /**
   * 個別機能訓練加算コンテナを取得します。
   * @return 個別機能訓練加算コンテナ
   */
  protected ACLabelContainer getNinchishoTaioTsushoIndividualFunctionTrainingAddRadioContainer(){
    if(ninchishoTaioTsushoIndividualFunctionTrainingAddRadioContainer==null){
      ninchishoTaioTsushoIndividualFunctionTrainingAddRadioContainer = new ACLabelContainer();
      ninchishoTaioTsushoIndividualFunctionTrainingAddRadioContainer.setFollowChildEnabled(true);
      ninchishoTaioTsushoIndividualFunctionTrainingAddRadioContainer.setVAlignment(VRLayout.CENTER);
      ninchishoTaioTsushoIndividualFunctionTrainingAddRadioContainer.add(getNinchishoTaioTsushoIndividualFunctionTrainingAddRadio(), null);
    }
    return ninchishoTaioTsushoIndividualFunctionTrainingAddRadioContainer;
  }

  /**
   * 個別機能訓練加算モデルを取得します。
   * @return 個別機能訓練加算モデル
   */
  protected ACListModelAdapter getNinchishoTaioTsushoIndividualFunctionTrainingAddRadioModel(){
    if(ninchishoTaioTsushoIndividualFunctionTrainingAddRadioModel==null){
      ninchishoTaioTsushoIndividualFunctionTrainingAddRadioModel = new ACListModelAdapter();
      addNinchishoTaioTsushoIndividualFunctionTrainingAddRadioModel();
    }
    return ninchishoTaioTsushoIndividualFunctionTrainingAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getNinchishoTaioTsushoIndividualFunctionTrainingAddRadioItem1(){
    if(ninchishoTaioTsushoIndividualFunctionTrainingAddRadioItem1==null){

      ninchishoTaioTsushoIndividualFunctionTrainingAddRadioItem1 = new ACRadioButtonItem();

      ninchishoTaioTsushoIndividualFunctionTrainingAddRadioItem1.setText("なし");

      ninchishoTaioTsushoIndividualFunctionTrainingAddRadioItem1.setGroup(getNinchishoTaioTsushoIndividualFunctionTrainingAddRadio());

      ninchishoTaioTsushoIndividualFunctionTrainingAddRadioItem1.setConstraints(VRLayout.FLOW);

      addNinchishoTaioTsushoIndividualFunctionTrainingAddRadioItem1();
    }
    return ninchishoTaioTsushoIndividualFunctionTrainingAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getNinchishoTaioTsushoIndividualFunctionTrainingAddRadioItem2(){
    if(ninchishoTaioTsushoIndividualFunctionTrainingAddRadioItem2==null){

      ninchishoTaioTsushoIndividualFunctionTrainingAddRadioItem2 = new ACRadioButtonItem();

      ninchishoTaioTsushoIndividualFunctionTrainingAddRadioItem2.setText("あり");

      ninchishoTaioTsushoIndividualFunctionTrainingAddRadioItem2.setGroup(getNinchishoTaioTsushoIndividualFunctionTrainingAddRadio());

      ninchishoTaioTsushoIndividualFunctionTrainingAddRadioItem2.setConstraints(VRLayout.FLOW);

      addNinchishoTaioTsushoIndividualFunctionTrainingAddRadioItem2();
    }
    return ninchishoTaioTsushoIndividualFunctionTrainingAddRadioItem2;

  }

  /**
   * 栄養改善加算を取得します。
   * @return 栄養改善加算
   */
  public ACValueArrayRadioButtonGroup getNinchishoTaioTsushoNourishmentImprovementAddRadio(){
    if(ninchishoTaioTsushoNourishmentImprovementAddRadio==null){

      ninchishoTaioTsushoNourishmentImprovementAddRadio = new ACValueArrayRadioButtonGroup();

      getNinchishoTaioTsushoNourishmentImprovementAddRadioContainer().setText("栄養改善加算");

      ninchishoTaioTsushoNourishmentImprovementAddRadio.setBindPath("1350125");

      ninchishoTaioTsushoNourishmentImprovementAddRadio.setUseClearButton(false);

      ninchishoTaioTsushoNourishmentImprovementAddRadio.setModel(getNinchishoTaioTsushoNourishmentImprovementAddRadioModel());

      ninchishoTaioTsushoNourishmentImprovementAddRadio.setValues(new int[]{1,2});

      addNinchishoTaioTsushoNourishmentImprovementAddRadio();
    }
    return ninchishoTaioTsushoNourishmentImprovementAddRadio;

  }

  /**
   * 栄養改善加算コンテナを取得します。
   * @return 栄養改善加算コンテナ
   */
  protected ACLabelContainer getNinchishoTaioTsushoNourishmentImprovementAddRadioContainer(){
    if(ninchishoTaioTsushoNourishmentImprovementAddRadioContainer==null){
      ninchishoTaioTsushoNourishmentImprovementAddRadioContainer = new ACLabelContainer();
      ninchishoTaioTsushoNourishmentImprovementAddRadioContainer.setFollowChildEnabled(true);
      ninchishoTaioTsushoNourishmentImprovementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      ninchishoTaioTsushoNourishmentImprovementAddRadioContainer.add(getNinchishoTaioTsushoNourishmentImprovementAddRadio(), null);
    }
    return ninchishoTaioTsushoNourishmentImprovementAddRadioContainer;
  }

  /**
   * 栄養改善加算モデルを取得します。
   * @return 栄養改善加算モデル
   */
  protected ACListModelAdapter getNinchishoTaioTsushoNourishmentImprovementAddRadioModel(){
    if(ninchishoTaioTsushoNourishmentImprovementAddRadioModel==null){
      ninchishoTaioTsushoNourishmentImprovementAddRadioModel = new ACListModelAdapter();
      addNinchishoTaioTsushoNourishmentImprovementAddRadioModel();
    }
    return ninchishoTaioTsushoNourishmentImprovementAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getNinchishoTaioTsushoNourishmentImprovementAddRadioItem1(){
    if(ninchishoTaioTsushoNourishmentImprovementAddRadioItem1==null){

      ninchishoTaioTsushoNourishmentImprovementAddRadioItem1 = new ACRadioButtonItem();

      ninchishoTaioTsushoNourishmentImprovementAddRadioItem1.setText("なし");

      ninchishoTaioTsushoNourishmentImprovementAddRadioItem1.setGroup(getNinchishoTaioTsushoNourishmentImprovementAddRadio());

      ninchishoTaioTsushoNourishmentImprovementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addNinchishoTaioTsushoNourishmentImprovementAddRadioItem1();
    }
    return ninchishoTaioTsushoNourishmentImprovementAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getNinchishoTaioTsushoNourishmentImprovementAddRadioItem2(){
    if(ninchishoTaioTsushoNourishmentImprovementAddRadioItem2==null){

      ninchishoTaioTsushoNourishmentImprovementAddRadioItem2 = new ACRadioButtonItem();

      ninchishoTaioTsushoNourishmentImprovementAddRadioItem2.setText("あり");

      ninchishoTaioTsushoNourishmentImprovementAddRadioItem2.setGroup(getNinchishoTaioTsushoNourishmentImprovementAddRadio());

      ninchishoTaioTsushoNourishmentImprovementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addNinchishoTaioTsushoNourishmentImprovementAddRadioItem2();
    }
    return ninchishoTaioTsushoNourishmentImprovementAddRadioItem2;

  }

  /**
   * 口腔機能向上加算を取得します。
   * @return 口腔機能向上加算
   */
  public ACValueArrayRadioButtonGroup getNinchishoTaioTsushoMouthFunctionImprovementAddRadio(){
    if(ninchishoTaioTsushoMouthFunctionImprovementAddRadio==null){

      ninchishoTaioTsushoMouthFunctionImprovementAddRadio = new ACValueArrayRadioButtonGroup();

      getNinchishoTaioTsushoMouthFunctionImprovementAddRadioContainer().setText("口腔機能向上加算");

      ninchishoTaioTsushoMouthFunctionImprovementAddRadio.setBindPath("1350126");

      ninchishoTaioTsushoMouthFunctionImprovementAddRadio.setUseClearButton(false);

      ninchishoTaioTsushoMouthFunctionImprovementAddRadio.setModel(getNinchishoTaioTsushoMouthFunctionImprovementAddRadioModel());

      ninchishoTaioTsushoMouthFunctionImprovementAddRadio.setValues(new int[]{1,2});

      addNinchishoTaioTsushoMouthFunctionImprovementAddRadio();
    }
    return ninchishoTaioTsushoMouthFunctionImprovementAddRadio;

  }

  /**
   * 口腔機能向上加算コンテナを取得します。
   * @return 口腔機能向上加算コンテナ
   */
  protected ACLabelContainer getNinchishoTaioTsushoMouthFunctionImprovementAddRadioContainer(){
    if(ninchishoTaioTsushoMouthFunctionImprovementAddRadioContainer==null){
      ninchishoTaioTsushoMouthFunctionImprovementAddRadioContainer = new ACLabelContainer();
      ninchishoTaioTsushoMouthFunctionImprovementAddRadioContainer.setFollowChildEnabled(true);
      ninchishoTaioTsushoMouthFunctionImprovementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      ninchishoTaioTsushoMouthFunctionImprovementAddRadioContainer.add(getNinchishoTaioTsushoMouthFunctionImprovementAddRadio(), null);
    }
    return ninchishoTaioTsushoMouthFunctionImprovementAddRadioContainer;
  }

  /**
   * 口腔機能向上加算モデルを取得します。
   * @return 口腔機能向上加算モデル
   */
  protected ACListModelAdapter getNinchishoTaioTsushoMouthFunctionImprovementAddRadioModel(){
    if(ninchishoTaioTsushoMouthFunctionImprovementAddRadioModel==null){
      ninchishoTaioTsushoMouthFunctionImprovementAddRadioModel = new ACListModelAdapter();
      addNinchishoTaioTsushoMouthFunctionImprovementAddRadioModel();
    }
    return ninchishoTaioTsushoMouthFunctionImprovementAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getNinchishoTaioTsushoMouthFunctionImprovementAddRadioItem1(){
    if(ninchishoTaioTsushoMouthFunctionImprovementAddRadioItem1==null){

      ninchishoTaioTsushoMouthFunctionImprovementAddRadioItem1 = new ACRadioButtonItem();

      ninchishoTaioTsushoMouthFunctionImprovementAddRadioItem1.setText("なし");

      ninchishoTaioTsushoMouthFunctionImprovementAddRadioItem1.setGroup(getNinchishoTaioTsushoMouthFunctionImprovementAddRadio());

      ninchishoTaioTsushoMouthFunctionImprovementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addNinchishoTaioTsushoMouthFunctionImprovementAddRadioItem1();
    }
    return ninchishoTaioTsushoMouthFunctionImprovementAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getNinchishoTaioTsushoMouthFunctionImprovementAddRadioItem2(){
    if(ninchishoTaioTsushoMouthFunctionImprovementAddRadioItem2==null){

      ninchishoTaioTsushoMouthFunctionImprovementAddRadioItem2 = new ACRadioButtonItem();

      ninchishoTaioTsushoMouthFunctionImprovementAddRadioItem2.setText("あり");

      ninchishoTaioTsushoMouthFunctionImprovementAddRadioItem2.setGroup(getNinchishoTaioTsushoMouthFunctionImprovementAddRadio());

      ninchishoTaioTsushoMouthFunctionImprovementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addNinchishoTaioTsushoMouthFunctionImprovementAddRadioItem2();
    }
    return ninchishoTaioTsushoMouthFunctionImprovementAddRadioItem2;

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

      tabPanel8.setLabelMargin(0);

      tabPanel8.setVgap(0);

      addTabPanel8();
    }
    return tabPanel8;

  }

  /**
   * 訪問型サービスグループを取得します。
   * @return 訪問型サービスグループ
   */
  public ACGroupBox getVisitCareServiceGroup(){
    if(visitCareServiceGroup==null){

      visitCareServiceGroup = new ACGroupBox();

      visitCareServiceGroup.setText("訪問型サービス");

      visitCareServiceGroup.setFollowChildEnabled(true);

      addVisitCareServiceGroup();
    }
    return visitCareServiceGroup;

  }

  /**
   * 訪問型サービス費を取得します。
   * @return 訪問型サービス費
   */
  public ACValueArrayRadioButtonGroup getVisitCareServiceRadio(){
    if(visitCareServiceRadio==null){

      visitCareServiceRadio = new ACValueArrayRadioButtonGroup();

      getVisitCareServiceRadioContainer().setText("訪問型サービス費");

      visitCareServiceRadio.setBindPath("1350137");

      visitCareServiceRadio.setUseClearButton(false);

      visitCareServiceRadio.setModel(getVisitCareServiceRadioModel());

      visitCareServiceRadio.setValues(new int[]{1,2,3});

      addVisitCareServiceRadio();
    }
    return visitCareServiceRadio;

  }

  /**
   * 訪問型サービス費コンテナを取得します。
   * @return 訪問型サービス費コンテナ
   */
  protected ACLabelContainer getVisitCareServiceRadioContainer(){
    if(visitCareServiceRadioContainer==null){
      visitCareServiceRadioContainer = new ACLabelContainer();
      visitCareServiceRadioContainer.setFollowChildEnabled(true);
      visitCareServiceRadioContainer.setVAlignment(VRLayout.CENTER);
      visitCareServiceRadioContainer.add(getVisitCareServiceRadio(), null);
    }
    return visitCareServiceRadioContainer;
  }

  /**
   * 訪問型サービス費モデルを取得します。
   * @return 訪問型サービス費モデル
   */
  protected ACListModelAdapter getVisitCareServiceRadioModel(){
    if(visitCareServiceRadioModel==null){
      visitCareServiceRadioModel = new ACListModelAdapter();
      addVisitCareServiceRadioModel();
    }
    return visitCareServiceRadioModel;
  }

  /**
   * Ⅰ型を取得します。
   * @return Ⅰ型
   */
  public ACRadioButtonItem getVisitCareServiceRadioItem1(){
    if(visitCareServiceRadioItem1==null){

      visitCareServiceRadioItem1 = new ACRadioButtonItem();

      visitCareServiceRadioItem1.setText("I型");

      visitCareServiceRadioItem1.setGroup(getVisitCareServiceRadio());

      visitCareServiceRadioItem1.setConstraints(VRLayout.FLOW);

      addVisitCareServiceRadioItem1();
    }
    return visitCareServiceRadioItem1;

  }

  /**
   * Ⅱ型を取得します。
   * @return Ⅱ型
   */
  public ACRadioButtonItem getVisitCareServiceRadioItem2(){
    if(visitCareServiceRadioItem2==null){

      visitCareServiceRadioItem2 = new ACRadioButtonItem();

      visitCareServiceRadioItem2.setText("II型");

      visitCareServiceRadioItem2.setGroup(getVisitCareServiceRadio());

      visitCareServiceRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addVisitCareServiceRadioItem2();
    }
    return visitCareServiceRadioItem2;

  }

  /**
   * Ⅲ型を取得します。
   * @return Ⅲ型
   */
  public ACRadioButtonItem getVisitCareServiceRadioItem3(){
    if(visitCareServiceRadioItem3==null){

      visitCareServiceRadioItem3 = new ACRadioButtonItem();

      visitCareServiceRadioItem3.setText("III型");

      visitCareServiceRadioItem3.setGroup(getVisitCareServiceRadio());

      visitCareServiceRadioItem3.setConstraints(VRLayout.FLOW);

      addVisitCareServiceRadioItem3();
    }
    return visitCareServiceRadioItem3;

  }

  /**
   * 日割を取得します。
   * @return 日割
   */
  public ACIntegerCheckBox getVisitCareServiceCrackOnDayCheck(){
    if(visitCareServiceCrackOnDayCheck==null){

      visitCareServiceCrackOnDayCheck = new ACIntegerCheckBox();

      visitCareServiceCrackOnDayCheck.setText("日割");

      visitCareServiceCrackOnDayCheck.setBindPath("1350138");

      visitCareServiceCrackOnDayCheck.setSelectValue(2);

      visitCareServiceCrackOnDayCheck.setUnSelectValue(1);

      addVisitCareServiceCrackOnDayCheck();
    }
    return visitCareServiceCrackOnDayCheck;

  }

  /**
   * 提供日を取得します。
   * @return 提供日
   */
  public ACIntegerCheckBox getVisitCareServicePrintable(){
    if(visitCareServicePrintable==null){

      visitCareServicePrintable = new ACIntegerCheckBox();

      visitCareServicePrintable.setText("提供日");

      visitCareServicePrintable.setBindPath("1350139");

      visitCareServicePrintable.setSelectValue(2);

      visitCareServicePrintable.setUnSelectValue(1);

      addVisitCareServicePrintable();
    }
    return visitCareServicePrintable;

  }

  /**
   * 通所型サービスグループを取得します。
   * @return 通所型サービスグループ
   */
  public ACGroupBox getExpertPlaceNursingServiceGroup(){
    if(expertPlaceNursingServiceGroup==null){

      expertPlaceNursingServiceGroup = new ACGroupBox();

      expertPlaceNursingServiceGroup.setText("通所型サービス");

      expertPlaceNursingServiceGroup.setFollowChildEnabled(true);

      addExpertPlaceNursingServiceGroup();
    }
    return expertPlaceNursingServiceGroup;

  }

  /**
   * 日割を取得します。
   * @return 日割
   */
  public ACIntegerCheckBox getExpertPlaceNursingServiceCrackOnDayChaeck(){
    if(expertPlaceNursingServiceCrackOnDayChaeck==null){

      expertPlaceNursingServiceCrackOnDayChaeck = new ACIntegerCheckBox();

      expertPlaceNursingServiceCrackOnDayChaeck.setText("日割");

      expertPlaceNursingServiceCrackOnDayChaeck.setBindPath("1350140");

      expertPlaceNursingServiceCrackOnDayChaeck.setSelectValue(2);

      expertPlaceNursingServiceCrackOnDayChaeck.setUnSelectValue(1);

      addExpertPlaceNursingServiceCrackOnDayChaeck();
    }
    return expertPlaceNursingServiceCrackOnDayChaeck;

  }

  /**
   * 提供日を取得します。
   * @return 提供日
   */
  public ACIntegerCheckBox getExpertPlaceNursingServicePrintable(){
    if(expertPlaceNursingServicePrintable==null){

      expertPlaceNursingServicePrintable = new ACIntegerCheckBox();

      expertPlaceNursingServicePrintable.setText("提供日");

      expertPlaceNursingServicePrintable.setBindPath("1350141");

      expertPlaceNursingServicePrintable.setSelectValue(2);

      expertPlaceNursingServicePrintable.setUnSelectValue(1);

      addExpertPlaceNursingServicePrintable();
    }
    return expertPlaceNursingServicePrintable;

  }

  /**
   * 運動器機能向上加算を取得します。
   * @return 運動器機能向上加算
   */
  public ACValueArrayRadioButtonGroup getExpertPlaceNursingServiceMovementFunctionImprovementAddRadio(){
    if(expertPlaceNursingServiceMovementFunctionImprovementAddRadio==null){

      expertPlaceNursingServiceMovementFunctionImprovementAddRadio = new ACValueArrayRadioButtonGroup();

      getExpertPlaceNursingServiceMovementFunctionImprovementAddRadioContainer().setText("運動器機能向上加算");

      expertPlaceNursingServiceMovementFunctionImprovementAddRadio.setBindPath("1350142");

      expertPlaceNursingServiceMovementFunctionImprovementAddRadio.setUseClearButton(false);

      expertPlaceNursingServiceMovementFunctionImprovementAddRadio.setModel(getExpertPlaceNursingServiceMovementFunctionImprovementAddRadioModel());

      expertPlaceNursingServiceMovementFunctionImprovementAddRadio.setValues(new int[]{1,2});

      addExpertPlaceNursingServiceMovementFunctionImprovementAddRadio();
    }
    return expertPlaceNursingServiceMovementFunctionImprovementAddRadio;

  }

  /**
   * 運動器機能向上加算コンテナを取得します。
   * @return 運動器機能向上加算コンテナ
   */
  protected ACLabelContainer getExpertPlaceNursingServiceMovementFunctionImprovementAddRadioContainer(){
    if(expertPlaceNursingServiceMovementFunctionImprovementAddRadioContainer==null){
      expertPlaceNursingServiceMovementFunctionImprovementAddRadioContainer = new ACLabelContainer();
      expertPlaceNursingServiceMovementFunctionImprovementAddRadioContainer.setFollowChildEnabled(true);
      expertPlaceNursingServiceMovementFunctionImprovementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      expertPlaceNursingServiceMovementFunctionImprovementAddRadioContainer.add(getExpertPlaceNursingServiceMovementFunctionImprovementAddRadio(), null);
    }
    return expertPlaceNursingServiceMovementFunctionImprovementAddRadioContainer;
  }

  /**
   * 運動器機能向上加算モデルを取得します。
   * @return 運動器機能向上加算モデル
   */
  protected ACListModelAdapter getExpertPlaceNursingServiceMovementFunctionImprovementAddRadioModel(){
    if(expertPlaceNursingServiceMovementFunctionImprovementAddRadioModel==null){
      expertPlaceNursingServiceMovementFunctionImprovementAddRadioModel = new ACListModelAdapter();
      addExpertPlaceNursingServiceMovementFunctionImprovementAddRadioModel();
    }
    return expertPlaceNursingServiceMovementFunctionImprovementAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getExpertPlaceNursingServiceMovementFunctionImprovementAddRadioItem1(){
    if(expertPlaceNursingServiceMovementFunctionImprovementAddRadioItem1==null){

      expertPlaceNursingServiceMovementFunctionImprovementAddRadioItem1 = new ACRadioButtonItem();

      expertPlaceNursingServiceMovementFunctionImprovementAddRadioItem1.setText("なし");

      expertPlaceNursingServiceMovementFunctionImprovementAddRadioItem1.setGroup(getExpertPlaceNursingServiceMovementFunctionImprovementAddRadio());

      expertPlaceNursingServiceMovementFunctionImprovementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addExpertPlaceNursingServiceMovementFunctionImprovementAddRadioItem1();
    }
    return expertPlaceNursingServiceMovementFunctionImprovementAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getExpertPlaceNursingServiceMovementFunctionImprovementAddRadioItem2(){
    if(expertPlaceNursingServiceMovementFunctionImprovementAddRadioItem2==null){

      expertPlaceNursingServiceMovementFunctionImprovementAddRadioItem2 = new ACRadioButtonItem();

      expertPlaceNursingServiceMovementFunctionImprovementAddRadioItem2.setText("あり");

      expertPlaceNursingServiceMovementFunctionImprovementAddRadioItem2.setGroup(getExpertPlaceNursingServiceMovementFunctionImprovementAddRadio());

      expertPlaceNursingServiceMovementFunctionImprovementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addExpertPlaceNursingServiceMovementFunctionImprovementAddRadioItem2();
    }
    return expertPlaceNursingServiceMovementFunctionImprovementAddRadioItem2;

  }

  /**
   * 栄養改善加算を取得します。
   * @return 栄養改善加算
   */
  public ACValueArrayRadioButtonGroup getExpertPlaceNursingServiceNourishmentImprovementAddRadio(){
    if(expertPlaceNursingServiceNourishmentImprovementAddRadio==null){

      expertPlaceNursingServiceNourishmentImprovementAddRadio = new ACValueArrayRadioButtonGroup();

      getExpertPlaceNursingServiceNourishmentImprovementAddRadioContainer().setText("栄養改善加算");

      expertPlaceNursingServiceNourishmentImprovementAddRadio.setBindPath("1350143");

      expertPlaceNursingServiceNourishmentImprovementAddRadio.setUseClearButton(false);

      expertPlaceNursingServiceNourishmentImprovementAddRadio.setModel(getExpertPlaceNursingServiceNourishmentImprovementAddRadioModel());

      expertPlaceNursingServiceNourishmentImprovementAddRadio.setValues(new int[]{1,2});

      addExpertPlaceNursingServiceNourishmentImprovementAddRadio();
    }
    return expertPlaceNursingServiceNourishmentImprovementAddRadio;

  }

  /**
   * 栄養改善加算コンテナを取得します。
   * @return 栄養改善加算コンテナ
   */
  protected ACLabelContainer getExpertPlaceNursingServiceNourishmentImprovementAddRadioContainer(){
    if(expertPlaceNursingServiceNourishmentImprovementAddRadioContainer==null){
      expertPlaceNursingServiceNourishmentImprovementAddRadioContainer = new ACLabelContainer();
      expertPlaceNursingServiceNourishmentImprovementAddRadioContainer.setFollowChildEnabled(true);
      expertPlaceNursingServiceNourishmentImprovementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      expertPlaceNursingServiceNourishmentImprovementAddRadioContainer.add(getExpertPlaceNursingServiceNourishmentImprovementAddRadio(), null);
    }
    return expertPlaceNursingServiceNourishmentImprovementAddRadioContainer;
  }

  /**
   * 栄養改善加算モデルを取得します。
   * @return 栄養改善加算モデル
   */
  protected ACListModelAdapter getExpertPlaceNursingServiceNourishmentImprovementAddRadioModel(){
    if(expertPlaceNursingServiceNourishmentImprovementAddRadioModel==null){
      expertPlaceNursingServiceNourishmentImprovementAddRadioModel = new ACListModelAdapter();
      addExpertPlaceNursingServiceNourishmentImprovementAddRadioModel();
    }
    return expertPlaceNursingServiceNourishmentImprovementAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getExpertPlaceNursingServiceNourishmentImprovementAddRadioItem1(){
    if(expertPlaceNursingServiceNourishmentImprovementAddRadioItem1==null){

      expertPlaceNursingServiceNourishmentImprovementAddRadioItem1 = new ACRadioButtonItem();

      expertPlaceNursingServiceNourishmentImprovementAddRadioItem1.setText("なし");

      expertPlaceNursingServiceNourishmentImprovementAddRadioItem1.setGroup(getExpertPlaceNursingServiceNourishmentImprovementAddRadio());

      expertPlaceNursingServiceNourishmentImprovementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addExpertPlaceNursingServiceNourishmentImprovementAddRadioItem1();
    }
    return expertPlaceNursingServiceNourishmentImprovementAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getExpertPlaceNursingServiceNourishmentImprovementAddRadioItem2(){
    if(expertPlaceNursingServiceNourishmentImprovementAddRadioItem2==null){

      expertPlaceNursingServiceNourishmentImprovementAddRadioItem2 = new ACRadioButtonItem();

      expertPlaceNursingServiceNourishmentImprovementAddRadioItem2.setText("あり");

      expertPlaceNursingServiceNourishmentImprovementAddRadioItem2.setGroup(getExpertPlaceNursingServiceNourishmentImprovementAddRadio());

      expertPlaceNursingServiceNourishmentImprovementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addExpertPlaceNursingServiceNourishmentImprovementAddRadioItem2();
    }
    return expertPlaceNursingServiceNourishmentImprovementAddRadioItem2;

  }

  /**
   * 口腔機能向上加算を取得します。
   * @return 口腔機能向上加算
   */
  public ACValueArrayRadioButtonGroup getExpertPlaceNursingServiceMouthFunctionImprovementAddRadio(){
    if(expertPlaceNursingServiceMouthFunctionImprovementAddRadio==null){

      expertPlaceNursingServiceMouthFunctionImprovementAddRadio = new ACValueArrayRadioButtonGroup();

      getExpertPlaceNursingServiceMouthFunctionImprovementAddRadioContainer().setText("口腔機能向上加算");

      expertPlaceNursingServiceMouthFunctionImprovementAddRadio.setBindPath("1350144");

      expertPlaceNursingServiceMouthFunctionImprovementAddRadio.setUseClearButton(false);

      expertPlaceNursingServiceMouthFunctionImprovementAddRadio.setModel(getExpertPlaceNursingServiceMouthFunctionImprovementAddRadioModel());

      expertPlaceNursingServiceMouthFunctionImprovementAddRadio.setValues(new int[]{1,2});

      addExpertPlaceNursingServiceMouthFunctionImprovementAddRadio();
    }
    return expertPlaceNursingServiceMouthFunctionImprovementAddRadio;

  }

  /**
   * 口腔機能向上加算コンテナを取得します。
   * @return 口腔機能向上加算コンテナ
   */
  protected ACLabelContainer getExpertPlaceNursingServiceMouthFunctionImprovementAddRadioContainer(){
    if(expertPlaceNursingServiceMouthFunctionImprovementAddRadioContainer==null){
      expertPlaceNursingServiceMouthFunctionImprovementAddRadioContainer = new ACLabelContainer();
      expertPlaceNursingServiceMouthFunctionImprovementAddRadioContainer.setFollowChildEnabled(true);
      expertPlaceNursingServiceMouthFunctionImprovementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      expertPlaceNursingServiceMouthFunctionImprovementAddRadioContainer.add(getExpertPlaceNursingServiceMouthFunctionImprovementAddRadio(), null);
    }
    return expertPlaceNursingServiceMouthFunctionImprovementAddRadioContainer;
  }

  /**
   * 口腔機能向上加算モデルを取得します。
   * @return 口腔機能向上加算モデル
   */
  protected ACListModelAdapter getExpertPlaceNursingServiceMouthFunctionImprovementAddRadioModel(){
    if(expertPlaceNursingServiceMouthFunctionImprovementAddRadioModel==null){
      expertPlaceNursingServiceMouthFunctionImprovementAddRadioModel = new ACListModelAdapter();
      addExpertPlaceNursingServiceMouthFunctionImprovementAddRadioModel();
    }
    return expertPlaceNursingServiceMouthFunctionImprovementAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getExpertPlaceNursingServiceMouthFunctionImprovementAddRadioItem1(){
    if(expertPlaceNursingServiceMouthFunctionImprovementAddRadioItem1==null){

      expertPlaceNursingServiceMouthFunctionImprovementAddRadioItem1 = new ACRadioButtonItem();

      expertPlaceNursingServiceMouthFunctionImprovementAddRadioItem1.setText("なし");

      expertPlaceNursingServiceMouthFunctionImprovementAddRadioItem1.setGroup(getExpertPlaceNursingServiceMouthFunctionImprovementAddRadio());

      expertPlaceNursingServiceMouthFunctionImprovementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addExpertPlaceNursingServiceMouthFunctionImprovementAddRadioItem1();
    }
    return expertPlaceNursingServiceMouthFunctionImprovementAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getExpertPlaceNursingServiceMouthFunctionImprovementAddRadioItem2(){
    if(expertPlaceNursingServiceMouthFunctionImprovementAddRadioItem2==null){

      expertPlaceNursingServiceMouthFunctionImprovementAddRadioItem2 = new ACRadioButtonItem();

      expertPlaceNursingServiceMouthFunctionImprovementAddRadioItem2.setText("あり");

      expertPlaceNursingServiceMouthFunctionImprovementAddRadioItem2.setGroup(getExpertPlaceNursingServiceMouthFunctionImprovementAddRadio());

      expertPlaceNursingServiceMouthFunctionImprovementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addExpertPlaceNursingServiceMouthFunctionImprovementAddRadioItem2();
    }
    return expertPlaceNursingServiceMouthFunctionImprovementAddRadioItem2;

  }

  /**
   * 選択的サービス複数実施加算を取得します。
   * @return 選択的サービス複数実施加算
   */
  public ACValueArrayRadioButtonGroup getExpertPlaceNursingServiceSentakutekiServiceRadio(){
    if(expertPlaceNursingServiceSentakutekiServiceRadio==null){

      expertPlaceNursingServiceSentakutekiServiceRadio = new ACValueArrayRadioButtonGroup();

      getExpertPlaceNursingServiceSentakutekiServiceRadioContainer().setText("選択的サービス" + ACConstants.LINE_SEPARATOR + "複数実施加算");

      expertPlaceNursingServiceSentakutekiServiceRadio.setBindPath("1350147");

      expertPlaceNursingServiceSentakutekiServiceRadio.setUseClearButton(false);

      expertPlaceNursingServiceSentakutekiServiceRadio.setModel(getExpertPlaceNursingServiceSentakutekiServiceRadioModel());

      expertPlaceNursingServiceSentakutekiServiceRadio.setValues(new int[]{1,2,3,4,5});

      addExpertPlaceNursingServiceSentakutekiServiceRadio();
    }
    return expertPlaceNursingServiceSentakutekiServiceRadio;

  }

  /**
   * 選択的サービス複数実施加算コンテナを取得します。
   * @return 選択的サービス複数実施加算コンテナ
   */
  protected ACLabelContainer getExpertPlaceNursingServiceSentakutekiServiceRadioContainer(){
    if(expertPlaceNursingServiceSentakutekiServiceRadioContainer==null){
      expertPlaceNursingServiceSentakutekiServiceRadioContainer = new ACLabelContainer();
      expertPlaceNursingServiceSentakutekiServiceRadioContainer.setFollowChildEnabled(true);
      expertPlaceNursingServiceSentakutekiServiceRadioContainer.setVAlignment(VRLayout.CENTER);
      expertPlaceNursingServiceSentakutekiServiceRadioContainer.add(getExpertPlaceNursingServiceSentakutekiServiceRadio(), null);
    }
    return expertPlaceNursingServiceSentakutekiServiceRadioContainer;
  }

  /**
   * 選択的サービス複数実施加算モデルを取得します。
   * @return 選択的サービス複数実施加算モデル
   */
  protected ACListModelAdapter getExpertPlaceNursingServiceSentakutekiServiceRadioModel(){
    if(expertPlaceNursingServiceSentakutekiServiceRadioModel==null){
      expertPlaceNursingServiceSentakutekiServiceRadioModel = new ACListModelAdapter();
      addExpertPlaceNursingServiceSentakutekiServiceRadioModel();
    }
    return expertPlaceNursingServiceSentakutekiServiceRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getExpertPlaceNursingServiceSentakutekiServiceRadioItem1(){
    if(expertPlaceNursingServiceSentakutekiServiceRadioItem1==null){

      expertPlaceNursingServiceSentakutekiServiceRadioItem1 = new ACRadioButtonItem();

      expertPlaceNursingServiceSentakutekiServiceRadioItem1.setText("なし");

      expertPlaceNursingServiceSentakutekiServiceRadioItem1.setGroup(getExpertPlaceNursingServiceSentakutekiServiceRadio());

      expertPlaceNursingServiceSentakutekiServiceRadioItem1.setConstraints(VRLayout.FLOW);

      addExpertPlaceNursingServiceSentakutekiServiceRadioItem1();
    }
    return expertPlaceNursingServiceSentakutekiServiceRadioItem1;

  }

  /**
   * I1を取得します。
   * @return I1
   */
  public ACRadioButtonItem getExpertPlaceNursingServiceSentakutekiServiceRadioItem2(){
    if(expertPlaceNursingServiceSentakutekiServiceRadioItem2==null){

      expertPlaceNursingServiceSentakutekiServiceRadioItem2 = new ACRadioButtonItem();

      expertPlaceNursingServiceSentakutekiServiceRadioItem2.setText("I1");

      expertPlaceNursingServiceSentakutekiServiceRadioItem2.setGroup(getExpertPlaceNursingServiceSentakutekiServiceRadio());

      expertPlaceNursingServiceSentakutekiServiceRadioItem2.setConstraints(VRLayout.FLOW);

      addExpertPlaceNursingServiceSentakutekiServiceRadioItem2();
    }
    return expertPlaceNursingServiceSentakutekiServiceRadioItem2;

  }

  /**
   * I2を取得します。
   * @return I2
   */
  public ACRadioButtonItem getExpertPlaceNursingServiceSentakutekiServiceRadioItem3(){
    if(expertPlaceNursingServiceSentakutekiServiceRadioItem3==null){

      expertPlaceNursingServiceSentakutekiServiceRadioItem3 = new ACRadioButtonItem();

      expertPlaceNursingServiceSentakutekiServiceRadioItem3.setText("I2");

      expertPlaceNursingServiceSentakutekiServiceRadioItem3.setGroup(getExpertPlaceNursingServiceSentakutekiServiceRadio());

      expertPlaceNursingServiceSentakutekiServiceRadioItem3.setConstraints(VRLayout.FLOW);

      addExpertPlaceNursingServiceSentakutekiServiceRadioItem3();
    }
    return expertPlaceNursingServiceSentakutekiServiceRadioItem3;

  }

  /**
   * I3を取得します。
   * @return I3
   */
  public ACRadioButtonItem getExpertPlaceNursingServiceSentakutekiServiceRadioItem4(){
    if(expertPlaceNursingServiceSentakutekiServiceRadioItem4==null){

      expertPlaceNursingServiceSentakutekiServiceRadioItem4 = new ACRadioButtonItem();

      expertPlaceNursingServiceSentakutekiServiceRadioItem4.setText("I3");

      expertPlaceNursingServiceSentakutekiServiceRadioItem4.setGroup(getExpertPlaceNursingServiceSentakutekiServiceRadio());

      expertPlaceNursingServiceSentakutekiServiceRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addExpertPlaceNursingServiceSentakutekiServiceRadioItem4();
    }
    return expertPlaceNursingServiceSentakutekiServiceRadioItem4;

  }

  /**
   * IIを取得します。
   * @return II
   */
  public ACRadioButtonItem getExpertPlaceNursingServiceSentakutekiServiceRadioItem5(){
    if(expertPlaceNursingServiceSentakutekiServiceRadioItem5==null){

      expertPlaceNursingServiceSentakutekiServiceRadioItem5 = new ACRadioButtonItem();

      expertPlaceNursingServiceSentakutekiServiceRadioItem5.setText("II");

      expertPlaceNursingServiceSentakutekiServiceRadioItem5.setGroup(getExpertPlaceNursingServiceSentakutekiServiceRadio());

      expertPlaceNursingServiceSentakutekiServiceRadioItem5.setConstraints(VRLayout.FLOW);

      addExpertPlaceNursingServiceSentakutekiServiceRadioItem5();
    }
    return expertPlaceNursingServiceSentakutekiServiceRadioItem5;

  }

  /**
   * コンストラクタです。
   */
  public QS001_13511_201504Design() {

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

    tabPanel1.add(getServicePanelAdd(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * 看護・介護職員が欠員に内部項目を追加します。
   */
  protected void addSpecificFacilitySubtractionPersonLack(){

  }

  /**
   * サービス加算パネルに内部項目を追加します。
   */
  protected void addServicePanelAdd(){

    servicePanelAdd.add(getSpecificFacilityFunctionTrainingRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    servicePanelAdd.add(getMedicalCoordinateAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    servicePanelAdd.add(getImpairedPersonHelpAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    servicePanelAdd.add(getDementiaProfessionalCareAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    servicePanelAdd.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 個別機能訓練加算に内部項目を追加します。
   */
  protected void addSpecificFacilityFunctionTrainingRadio(){

  }

  /**
   * 個別機能訓練加算モデルに内部項目を追加します。
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
   * タブパネル2に内部項目を追加します。
   */
  protected void addTabPanel2(){

    tabPanel2.add(getServiceSettingPanel(), VRLayout.NORTH);

    tabPanel2.add(getVisitCareGroup(), VRLayout.NORTH);

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

    getOutsideServiceRadioItem0().setButtonIndex(11);

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

    getOutsideServiceRadioItem9().setButtonIndex(9);

    getOutsideServiceRadioModel().add(getOutsideServiceRadioItem9());

    getOutsideServiceRadioItem10().setButtonIndex(10);

    getOutsideServiceRadioModel().add(getOutsideServiceRadioItem10());

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
   * 訪問型サービスに内部項目を追加します。
   */
  protected void addOutsideServiceRadioItem9(){

  }

  /**
   * 通所型サービスに内部項目を追加します。
   */
  protected void addOutsideServiceRadioItem10(){

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

    visitCareGroup.add(getVisitCareCrackOnDayCheck(), VRLayout.FLOW);

    visitCareGroup.add(getVisitCarePrintable(), VRLayout.FLOW_RETURN);

  }

  /**
   * 訪問介護費に内部項目を追加します。
   */
  protected void addVisitCareRadio(){

  }

  /**
   * 訪問介護費モデルに内部項目を追加します。
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
   * Ⅰ型に内部項目を追加します。
   */
  protected void addVisitCareRadioItem1(){

  }

  /**
   * Ⅱ型に内部項目を追加します。
   */
  protected void addVisitCareRadioItem2(){

  }

  /**
   * Ⅲ型に内部項目を追加します。
   */
  protected void addVisitCareRadioItem3(){

  }

  /**
   * 日割に内部項目を追加します。
   */
  protected void addVisitCareCrackOnDayCheck(){

  }

  /**
   * 提供日に内部項目を追加します。
   */
  protected void addVisitCarePrintable(){

  }

  /**
   * タブパネル3に内部項目を追加します。
   */
  protected void addTabPanel3(){

    tabPanel3.add(getVisitNursingRadioGroup(), VRLayout.NORTH);

    tabPanel3.add(getVisitRehabiliGroup(), VRLayout.NORTH);

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
   * タブパネル4に内部項目を追加します。
   */
  protected void addTabPanel4(){

    tabPanel4.add(getExpertPlaceNursingGroup(), VRLayout.NORTH);

  }

  /**
   * 通所介護グループに内部項目を追加します。
   */
  protected void addExpertPlaceNursingGroup(){

    expertPlaceNursingGroup.add(getExpertPlaceNursingCrackOnDayChaeck(), VRLayout.FLOW);

    expertPlaceNursingGroup.add(getExpertPlaceNursingPrintable(), VRLayout.FLOW_RETURN);

    expertPlaceNursingGroup.add(getExpertPlaceNursingMovementFunctionImprovementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    expertPlaceNursingGroup.add(getExpertPlaceNursingNourishmentImprovementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    expertPlaceNursingGroup.add(getExpertPlaceNursingMouthFunctionImprovementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    expertPlaceNursingGroup.add(getExpertPlaceNursingSentakutekiServiceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 日割に内部項目を追加します。
   */
  protected void addExpertPlaceNursingCrackOnDayChaeck(){

  }

  /**
   * 提供日に内部項目を追加します。
   */
  protected void addExpertPlaceNursingPrintable(){

  }

  /**
   * 運動器機能向上加算に内部項目を追加します。
   */
  protected void addExpertPlaceNursingMovementFunctionImprovementAddRadio(){

  }

  /**
   * 運動器機能向上加算モデルに内部項目を追加します。
   */
  protected void addExpertPlaceNursingMovementFunctionImprovementAddRadioModel(){

    getExpertPlaceNursingMovementFunctionImprovementAddRadioItem1().setButtonIndex(1);

    getExpertPlaceNursingMovementFunctionImprovementAddRadioModel().add(getExpertPlaceNursingMovementFunctionImprovementAddRadioItem1());

    getExpertPlaceNursingMovementFunctionImprovementAddRadioItem2().setButtonIndex(2);

    getExpertPlaceNursingMovementFunctionImprovementAddRadioModel().add(getExpertPlaceNursingMovementFunctionImprovementAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addExpertPlaceNursingMovementFunctionImprovementAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addExpertPlaceNursingMovementFunctionImprovementAddRadioItem2(){

  }

  /**
   * 栄養改善加算に内部項目を追加します。
   */
  protected void addExpertPlaceNursingNourishmentImprovementAddRadio(){

  }

  /**
   * 栄養改善加算モデルに内部項目を追加します。
   */
  protected void addExpertPlaceNursingNourishmentImprovementAddRadioModel(){

    getExpertPlaceNursingNourishmentImprovementAddRadioItem1().setButtonIndex(1);

    getExpertPlaceNursingNourishmentImprovementAddRadioModel().add(getExpertPlaceNursingNourishmentImprovementAddRadioItem1());

    getExpertPlaceNursingNourishmentImprovementAddRadioItem2().setButtonIndex(2);

    getExpertPlaceNursingNourishmentImprovementAddRadioModel().add(getExpertPlaceNursingNourishmentImprovementAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addExpertPlaceNursingNourishmentImprovementAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addExpertPlaceNursingNourishmentImprovementAddRadioItem2(){

  }

  /**
   * 口腔機能向上加算に内部項目を追加します。
   */
  protected void addExpertPlaceNursingMouthFunctionImprovementAddRadio(){

  }

  /**
   * 口腔機能向上加算モデルに内部項目を追加します。
   */
  protected void addExpertPlaceNursingMouthFunctionImprovementAddRadioModel(){

    getExpertPlaceNursingMouthFunctionImprovementAddRadioItem1().setButtonIndex(1);

    getExpertPlaceNursingMouthFunctionImprovementAddRadioModel().add(getExpertPlaceNursingMouthFunctionImprovementAddRadioItem1());

    getExpertPlaceNursingMouthFunctionImprovementAddRadioItem2().setButtonIndex(2);

    getExpertPlaceNursingMouthFunctionImprovementAddRadioModel().add(getExpertPlaceNursingMouthFunctionImprovementAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addExpertPlaceNursingMouthFunctionImprovementAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addExpertPlaceNursingMouthFunctionImprovementAddRadioItem2(){

  }

  /**
   * 選択的サービス複数実施加算に内部項目を追加します。
   */
  protected void addExpertPlaceNursingSentakutekiServiceRadio(){

  }

  /**
   * 選択的サービス複数実施加算モデルに内部項目を追加します。
   */
  protected void addExpertPlaceNursingSentakutekiServiceRadioModel(){

    getExpertPlaceNursingSentakutekiServiceRadioItem1().setButtonIndex(1);

    getExpertPlaceNursingSentakutekiServiceRadioModel().add(getExpertPlaceNursingSentakutekiServiceRadioItem1());

    getExpertPlaceNursingSentakutekiServiceRadioItem2().setButtonIndex(2);

    getExpertPlaceNursingSentakutekiServiceRadioModel().add(getExpertPlaceNursingSentakutekiServiceRadioItem2());

    getExpertPlaceNursingSentakutekiServiceRadioItem3().setButtonIndex(3);

    getExpertPlaceNursingSentakutekiServiceRadioModel().add(getExpertPlaceNursingSentakutekiServiceRadioItem3());

    getExpertPlaceNursingSentakutekiServiceRadioItem4().setButtonIndex(4);

    getExpertPlaceNursingSentakutekiServiceRadioModel().add(getExpertPlaceNursingSentakutekiServiceRadioItem4());

    getExpertPlaceNursingSentakutekiServiceRadioItem5().setButtonIndex(5);

    getExpertPlaceNursingSentakutekiServiceRadioModel().add(getExpertPlaceNursingSentakutekiServiceRadioItem5());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addExpertPlaceNursingSentakutekiServiceRadioItem1(){

  }

  /**
   * I1に内部項目を追加します。
   */
  protected void addExpertPlaceNursingSentakutekiServiceRadioItem2(){

  }

  /**
   * I2に内部項目を追加します。
   */
  protected void addExpertPlaceNursingSentakutekiServiceRadioItem3(){

  }

  /**
   * I3に内部項目を追加します。
   */
  protected void addExpertPlaceNursingSentakutekiServiceRadioItem4(){

  }

  /**
   * IIに内部項目を追加します。
   */
  protected void addExpertPlaceNursingSentakutekiServiceRadioItem5(){

  }

  /**
   * タブパネル5に内部項目を追加します。
   */
  protected void addTabPanel5(){

    tabPanel5.add(getExpertPlaceRehabiliGroup(), VRLayout.NORTH);

  }

  /**
   * 通所リハグループに内部項目を追加します。
   */
  protected void addExpertPlaceRehabiliGroup(){

    expertPlaceRehabiliGroup.add(getExpertPlaceRehabiliCrackOnDay(), VRLayout.FLOW);

    expertPlaceRehabiliGroup.add(getExpertPlaceRehabiliPrintable(), VRLayout.FLOW_RETURN);

    expertPlaceRehabiliGroup.add(getExpertPlaceRehabiliRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    expertPlaceRehabiliGroup.add(getExpertPlaceRehabiliMovementFunctionImprovementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    expertPlaceRehabiliGroup.add(getExpertPlaceRehabiliNourishmentImprovementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    expertPlaceRehabiliGroup.add(getExpertPlaceRehabiliMouthFunctionImprovementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    expertPlaceRehabiliGroup.add(getExpertPlaceRehabiliSentakutekiServiceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 日割に内部項目を追加します。
   */
  protected void addExpertPlaceRehabiliCrackOnDay(){

  }

  /**
   * 提供日に内部項目を追加します。
   */
  protected void addExpertPlaceRehabiliPrintable(){

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

  }

  /**
   * 病院又は診療所に内部項目を追加します。
   */
  protected void addExpertPlaceRehabiliRadioItem1(){

  }

  /**
   * 介護老人保健施設に内部項目を追加します。
   */
  protected void addExpertPlaceRehabiliRadioItem2(){

  }

  /**
   * 運動器機能向上加算に内部項目を追加します。
   */
  protected void addExpertPlaceRehabiliMovementFunctionImprovementAddRadio(){

  }

  /**
   * 運動器機能向上加算モデルに内部項目を追加します。
   */
  protected void addExpertPlaceRehabiliMovementFunctionImprovementAddRadioModel(){

    getExpertPlaceRehabiliMovementFunctionImprovementAddRadioItem1().setButtonIndex(1);

    getExpertPlaceRehabiliMovementFunctionImprovementAddRadioModel().add(getExpertPlaceRehabiliMovementFunctionImprovementAddRadioItem1());

    getExpertPlaceRehabiliMovementFunctionImprovementAddRadioItem2().setButtonIndex(2);

    getExpertPlaceRehabiliMovementFunctionImprovementAddRadioModel().add(getExpertPlaceRehabiliMovementFunctionImprovementAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addExpertPlaceRehabiliMovementFunctionImprovementAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addExpertPlaceRehabiliMovementFunctionImprovementAddRadioItem2(){

  }

  /**
   * 栄養改善加算に内部項目を追加します。
   */
  protected void addExpertPlaceRehabiliNourishmentImprovementAddRadio(){

  }

  /**
   * 栄養改善加算モデルに内部項目を追加します。
   */
  protected void addExpertPlaceRehabiliNourishmentImprovementAddRadioModel(){

    getExpertPlaceRehabiliNourishmentImprovementAddRadioItem1().setButtonIndex(1);

    getExpertPlaceRehabiliNourishmentImprovementAddRadioModel().add(getExpertPlaceRehabiliNourishmentImprovementAddRadioItem1());

    getExpertPlaceRehabiliNourishmentImprovementAddRadioItem2().setButtonIndex(2);

    getExpertPlaceRehabiliNourishmentImprovementAddRadioModel().add(getExpertPlaceRehabiliNourishmentImprovementAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addExpertPlaceRehabiliNourishmentImprovementAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addExpertPlaceRehabiliNourishmentImprovementAddRadioItem2(){

  }

  /**
   * 口腔機能向上加算に内部項目を追加します。
   */
  protected void addExpertPlaceRehabiliMouthFunctionImprovementAddRadio(){

  }

  /**
   * 口腔機能向上加算モデルに内部項目を追加します。
   */
  protected void addExpertPlaceRehabiliMouthFunctionImprovementAddRadioModel(){

    getExpertPlaceRehabiliMouthFunctionImprovementAddRadioItem1().setButtonIndex(1);

    getExpertPlaceRehabiliMouthFunctionImprovementAddRadioModel().add(getExpertPlaceRehabiliMouthFunctionImprovementAddRadioItem1());

    getExpertPlaceRehabiliMouthFunctionImprovementAddRadioItem2().setButtonIndex(2);

    getExpertPlaceRehabiliMouthFunctionImprovementAddRadioModel().add(getExpertPlaceRehabiliMouthFunctionImprovementAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addExpertPlaceRehabiliMouthFunctionImprovementAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addExpertPlaceRehabiliMouthFunctionImprovementAddRadioItem2(){

  }

  /**
   * 選択的サービス複数実施加算に内部項目を追加します。
   */
  protected void addExpertPlaceRehabiliSentakutekiServiceRadio(){

  }

  /**
   * 選択的サービス複数実施加算モデルに内部項目を追加します。
   */
  protected void addExpertPlaceRehabiliSentakutekiServiceRadioModel(){

    getExpertPlaceRehabiliSentakutekiServiceRadioItem1().setButtonIndex(1);

    getExpertPlaceRehabiliSentakutekiServiceRadioModel().add(getExpertPlaceRehabiliSentakutekiServiceRadioItem1());

    getExpertPlaceRehabiliSentakutekiServiceRadioItem2().setButtonIndex(2);

    getExpertPlaceRehabiliSentakutekiServiceRadioModel().add(getExpertPlaceRehabiliSentakutekiServiceRadioItem2());

    getExpertPlaceRehabiliSentakutekiServiceRadioItem3().setButtonIndex(3);

    getExpertPlaceRehabiliSentakutekiServiceRadioModel().add(getExpertPlaceRehabiliSentakutekiServiceRadioItem3());

    getExpertPlaceRehabiliSentakutekiServiceRadioItem4().setButtonIndex(4);

    getExpertPlaceRehabiliSentakutekiServiceRadioModel().add(getExpertPlaceRehabiliSentakutekiServiceRadioItem4());

    getExpertPlaceRehabiliSentakutekiServiceRadioItem5().setButtonIndex(5);

    getExpertPlaceRehabiliSentakutekiServiceRadioModel().add(getExpertPlaceRehabiliSentakutekiServiceRadioItem5());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addExpertPlaceRehabiliSentakutekiServiceRadioItem1(){

  }

  /**
   * I1に内部項目を追加します。
   */
  protected void addExpertPlaceRehabiliSentakutekiServiceRadioItem2(){

  }

  /**
   * I2に内部項目を追加します。
   */
  protected void addExpertPlaceRehabiliSentakutekiServiceRadioItem3(){

  }

  /**
   * I3に内部項目を追加します。
   */
  protected void addExpertPlaceRehabiliSentakutekiServiceRadioItem4(){

  }

  /**
   * IIに内部項目を追加します。
   */
  protected void addExpertPlaceRehabiliSentakutekiServiceRadioItem5(){

  }

  /**
   * タブパネル6に内部項目を追加します。
   */
  protected void addTabPanel6(){

    tabPanel6.add(getWelfareToolsGroup(), VRLayout.NORTH);

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
   * タブパネル7に内部項目を追加します。
   */
  protected void addTabPanel7(){

    tabPanel7.add(getNinchishoTaioTsushoGroup(), VRLayout.NORTH);

  }

  /**
   * 認知症対応型通所介護グループに内部項目を追加します。
   */
  protected void addNinchishoTaioTsushoGroup(){

    ninchishoTaioTsushoGroup.add(getProviderDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    ninchishoTaioTsushoGroup.add(getDivisionRadionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    ninchishoTaioTsushoGroup.add(getTimeDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    ninchishoTaioTsushoGroup.add(getNinchishoTaioTsushoIndividualFunctionTrainingAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    ninchishoTaioTsushoGroup.add(getNinchishoTaioTsushoNourishmentImprovementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    ninchishoTaioTsushoGroup.add(getNinchishoTaioTsushoMouthFunctionImprovementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * 個別機能訓練加算に内部項目を追加します。
   */
  protected void addNinchishoTaioTsushoIndividualFunctionTrainingAddRadio(){

  }

  /**
   * 個別機能訓練加算モデルに内部項目を追加します。
   */
  protected void addNinchishoTaioTsushoIndividualFunctionTrainingAddRadioModel(){

    getNinchishoTaioTsushoIndividualFunctionTrainingAddRadioItem1().setButtonIndex(1);

    getNinchishoTaioTsushoIndividualFunctionTrainingAddRadioModel().add(getNinchishoTaioTsushoIndividualFunctionTrainingAddRadioItem1());

    getNinchishoTaioTsushoIndividualFunctionTrainingAddRadioItem2().setButtonIndex(2);

    getNinchishoTaioTsushoIndividualFunctionTrainingAddRadioModel().add(getNinchishoTaioTsushoIndividualFunctionTrainingAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addNinchishoTaioTsushoIndividualFunctionTrainingAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addNinchishoTaioTsushoIndividualFunctionTrainingAddRadioItem2(){

  }

  /**
   * 栄養改善加算に内部項目を追加します。
   */
  protected void addNinchishoTaioTsushoNourishmentImprovementAddRadio(){

  }

  /**
   * 栄養改善加算モデルに内部項目を追加します。
   */
  protected void addNinchishoTaioTsushoNourishmentImprovementAddRadioModel(){

    getNinchishoTaioTsushoNourishmentImprovementAddRadioItem1().setButtonIndex(1);

    getNinchishoTaioTsushoNourishmentImprovementAddRadioModel().add(getNinchishoTaioTsushoNourishmentImprovementAddRadioItem1());

    getNinchishoTaioTsushoNourishmentImprovementAddRadioItem2().setButtonIndex(2);

    getNinchishoTaioTsushoNourishmentImprovementAddRadioModel().add(getNinchishoTaioTsushoNourishmentImprovementAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addNinchishoTaioTsushoNourishmentImprovementAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addNinchishoTaioTsushoNourishmentImprovementAddRadioItem2(){

  }

  /**
   * 口腔機能向上加算に内部項目を追加します。
   */
  protected void addNinchishoTaioTsushoMouthFunctionImprovementAddRadio(){

  }

  /**
   * 口腔機能向上加算モデルに内部項目を追加します。
   */
  protected void addNinchishoTaioTsushoMouthFunctionImprovementAddRadioModel(){

    getNinchishoTaioTsushoMouthFunctionImprovementAddRadioItem1().setButtonIndex(1);

    getNinchishoTaioTsushoMouthFunctionImprovementAddRadioModel().add(getNinchishoTaioTsushoMouthFunctionImprovementAddRadioItem1());

    getNinchishoTaioTsushoMouthFunctionImprovementAddRadioItem2().setButtonIndex(2);

    getNinchishoTaioTsushoMouthFunctionImprovementAddRadioModel().add(getNinchishoTaioTsushoMouthFunctionImprovementAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addNinchishoTaioTsushoMouthFunctionImprovementAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addNinchishoTaioTsushoMouthFunctionImprovementAddRadioItem2(){

  }

  /**
   * タブパネル8に内部項目を追加します。
   */
  protected void addTabPanel8(){

    tabPanel8.add(getVisitCareServiceGroup(), VRLayout.NORTH);

    tabPanel8.add(getExpertPlaceNursingServiceGroup(), VRLayout.NORTH);

  }

  /**
   * 訪問型サービスグループに内部項目を追加します。
   */
  protected void addVisitCareServiceGroup(){

    visitCareServiceGroup.add(getVisitCareServiceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    visitCareServiceGroup.add(getVisitCareServiceCrackOnDayCheck(), VRLayout.FLOW);

    visitCareServiceGroup.add(getVisitCareServicePrintable(), VRLayout.FLOW_RETURN);

  }

  /**
   * 訪問型サービス費に内部項目を追加します。
   */
  protected void addVisitCareServiceRadio(){

  }

  /**
   * 訪問型サービス費モデルに内部項目を追加します。
   */
  protected void addVisitCareServiceRadioModel(){

    getVisitCareServiceRadioItem1().setButtonIndex(1);

    getVisitCareServiceRadioModel().add(getVisitCareServiceRadioItem1());

    getVisitCareServiceRadioItem2().setButtonIndex(2);

    getVisitCareServiceRadioModel().add(getVisitCareServiceRadioItem2());

    getVisitCareServiceRadioItem3().setButtonIndex(3);

    getVisitCareServiceRadioModel().add(getVisitCareServiceRadioItem3());

  }

  /**
   * Ⅰ型に内部項目を追加します。
   */
  protected void addVisitCareServiceRadioItem1(){

  }

  /**
   * Ⅱ型に内部項目を追加します。
   */
  protected void addVisitCareServiceRadioItem2(){

  }

  /**
   * Ⅲ型に内部項目を追加します。
   */
  protected void addVisitCareServiceRadioItem3(){

  }

  /**
   * 日割に内部項目を追加します。
   */
  protected void addVisitCareServiceCrackOnDayCheck(){

  }

  /**
   * 提供日に内部項目を追加します。
   */
  protected void addVisitCareServicePrintable(){

  }

  /**
   * 通所型サービスグループに内部項目を追加します。
   */
  protected void addExpertPlaceNursingServiceGroup(){

    expertPlaceNursingServiceGroup.add(getExpertPlaceNursingServiceCrackOnDayChaeck(), VRLayout.FLOW);

    expertPlaceNursingServiceGroup.add(getExpertPlaceNursingServicePrintable(), VRLayout.FLOW_RETURN);

    expertPlaceNursingServiceGroup.add(getExpertPlaceNursingServiceMovementFunctionImprovementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    expertPlaceNursingServiceGroup.add(getExpertPlaceNursingServiceNourishmentImprovementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    expertPlaceNursingServiceGroup.add(getExpertPlaceNursingServiceMouthFunctionImprovementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    expertPlaceNursingServiceGroup.add(getExpertPlaceNursingServiceSentakutekiServiceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 日割に内部項目を追加します。
   */
  protected void addExpertPlaceNursingServiceCrackOnDayChaeck(){

  }

  /**
   * 提供日に内部項目を追加します。
   */
  protected void addExpertPlaceNursingServicePrintable(){

  }

  /**
   * 運動器機能向上加算に内部項目を追加します。
   */
  protected void addExpertPlaceNursingServiceMovementFunctionImprovementAddRadio(){

  }

  /**
   * 運動器機能向上加算モデルに内部項目を追加します。
   */
  protected void addExpertPlaceNursingServiceMovementFunctionImprovementAddRadioModel(){

    getExpertPlaceNursingServiceMovementFunctionImprovementAddRadioItem1().setButtonIndex(1);

    getExpertPlaceNursingServiceMovementFunctionImprovementAddRadioModel().add(getExpertPlaceNursingServiceMovementFunctionImprovementAddRadioItem1());

    getExpertPlaceNursingServiceMovementFunctionImprovementAddRadioItem2().setButtonIndex(2);

    getExpertPlaceNursingServiceMovementFunctionImprovementAddRadioModel().add(getExpertPlaceNursingServiceMovementFunctionImprovementAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addExpertPlaceNursingServiceMovementFunctionImprovementAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addExpertPlaceNursingServiceMovementFunctionImprovementAddRadioItem2(){

  }

  /**
   * 栄養改善加算に内部項目を追加します。
   */
  protected void addExpertPlaceNursingServiceNourishmentImprovementAddRadio(){

  }

  /**
   * 栄養改善加算モデルに内部項目を追加します。
   */
  protected void addExpertPlaceNursingServiceNourishmentImprovementAddRadioModel(){

    getExpertPlaceNursingServiceNourishmentImprovementAddRadioItem1().setButtonIndex(1);

    getExpertPlaceNursingServiceNourishmentImprovementAddRadioModel().add(getExpertPlaceNursingServiceNourishmentImprovementAddRadioItem1());

    getExpertPlaceNursingServiceNourishmentImprovementAddRadioItem2().setButtonIndex(2);

    getExpertPlaceNursingServiceNourishmentImprovementAddRadioModel().add(getExpertPlaceNursingServiceNourishmentImprovementAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addExpertPlaceNursingServiceNourishmentImprovementAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addExpertPlaceNursingServiceNourishmentImprovementAddRadioItem2(){

  }

  /**
   * 口腔機能向上加算に内部項目を追加します。
   */
  protected void addExpertPlaceNursingServiceMouthFunctionImprovementAddRadio(){

  }

  /**
   * 口腔機能向上加算モデルに内部項目を追加します。
   */
  protected void addExpertPlaceNursingServiceMouthFunctionImprovementAddRadioModel(){

    getExpertPlaceNursingServiceMouthFunctionImprovementAddRadioItem1().setButtonIndex(1);

    getExpertPlaceNursingServiceMouthFunctionImprovementAddRadioModel().add(getExpertPlaceNursingServiceMouthFunctionImprovementAddRadioItem1());

    getExpertPlaceNursingServiceMouthFunctionImprovementAddRadioItem2().setButtonIndex(2);

    getExpertPlaceNursingServiceMouthFunctionImprovementAddRadioModel().add(getExpertPlaceNursingServiceMouthFunctionImprovementAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addExpertPlaceNursingServiceMouthFunctionImprovementAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addExpertPlaceNursingServiceMouthFunctionImprovementAddRadioItem2(){

  }

  /**
   * 選択的サービス複数実施加算に内部項目を追加します。
   */
  protected void addExpertPlaceNursingServiceSentakutekiServiceRadio(){

  }

  /**
   * 選択的サービス複数実施加算モデルに内部項目を追加します。
   */
  protected void addExpertPlaceNursingServiceSentakutekiServiceRadioModel(){

    getExpertPlaceNursingServiceSentakutekiServiceRadioItem1().setButtonIndex(1);

    getExpertPlaceNursingServiceSentakutekiServiceRadioModel().add(getExpertPlaceNursingServiceSentakutekiServiceRadioItem1());

    getExpertPlaceNursingServiceSentakutekiServiceRadioItem2().setButtonIndex(2);

    getExpertPlaceNursingServiceSentakutekiServiceRadioModel().add(getExpertPlaceNursingServiceSentakutekiServiceRadioItem2());

    getExpertPlaceNursingServiceSentakutekiServiceRadioItem3().setButtonIndex(3);

    getExpertPlaceNursingServiceSentakutekiServiceRadioModel().add(getExpertPlaceNursingServiceSentakutekiServiceRadioItem3());

    getExpertPlaceNursingServiceSentakutekiServiceRadioItem4().setButtonIndex(4);

    getExpertPlaceNursingServiceSentakutekiServiceRadioModel().add(getExpertPlaceNursingServiceSentakutekiServiceRadioItem4());

    getExpertPlaceNursingServiceSentakutekiServiceRadioItem5().setButtonIndex(5);

    getExpertPlaceNursingServiceSentakutekiServiceRadioModel().add(getExpertPlaceNursingServiceSentakutekiServiceRadioItem5());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addExpertPlaceNursingServiceSentakutekiServiceRadioItem1(){

  }

  /**
   * I1に内部項目を追加します。
   */
  protected void addExpertPlaceNursingServiceSentakutekiServiceRadioItem2(){

  }

  /**
   * I2に内部項目を追加します。
   */
  protected void addExpertPlaceNursingServiceSentakutekiServiceRadioItem3(){

  }

  /**
   * I3に内部項目を追加します。
   */
  protected void addExpertPlaceNursingServiceSentakutekiServiceRadioItem4(){

  }

  /**
   * IIに内部項目を追加します。
   */
  protected void addExpertPlaceNursingServiceSentakutekiServiceRadioItem5(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_13511_201504Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001_13511_201504Design getThis() {
    return this;
  }
}
