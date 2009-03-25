
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
 * 開発者: 田中　統蔵
 * 作成日: 2009/03/03  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン介護予防特定施設入居者生活介護 (QS001143_H2104)
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
 * サービスパターン介護予防特定施設入居者生活介護画面項目デザイン(QS001143_H2104) 
 */
public class QS001143_H2104Design extends QS001ServicePanel {
  //GUIコンポーネント

  private JTabbedPane tabs;

  private ACPanel tabPanel1;

  private ACClearableRadioButtonGroup facilitiesDivisionRadio;

  private ACLabelContainer facilitiesDivisionRadioContainer;

  private ACListModelAdapter facilitiesDivisionRadioModel;

  private ACRadioButtonItem facilitiesDivisionRadioItem1;

  private ACRadioButtonItem facilitiesDivisionRadioItem2;

  private ACClearableRadioButtonGroup specificFacilitySubtractionRadio;

  private ACLabelContainer specificFacilitySubtractionRadioContainer;

  private ACListModelAdapter specificFacilitySubtractionRadioModel;

  private ACRadioButtonItem specificFacilitySubtractionNot;

  private ACRadioButtonItem specificFacilitySubtractionPersonLack;

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

  private ACBackLabelContainer specificFacilityTimeContena;

  private ACTimeComboBox specificFacilityBeginTime;

  private ACLabelContainer specificFacilityBeginTimeContainer;

  private ACComboBoxModelAdapter specificFacilityBeginTimeModel;

  private ACTimeComboBox specificFacilityEndTime;

  private ACLabelContainer specificFacilityEndTimeContainer;

  private ACComboBoxModelAdapter specificFacilityEndTimeModel;

  private ACPanel tabPanel2;

  private ACPanel servicePanelAdd;

  private ACClearableRadioButtonGroup specificFacilityFunctionTrainingRadio;

  private ACLabelContainer specificFacilityFunctionTrainingRadioContainer;

  private ACListModelAdapter specificFacilityFunctionTrainingRadioModel;

  private ACRadioButtonItem specificFacilityFunctionTrainingRadioItem2;

  private ACRadioButtonItem specificFacilityFunctionTrainingRadioItem1;

  private ACClearableRadioButtonGroup medicalCoordinateAddRadioGroup;

  private ACLabelContainer medicalCoordinateAddRadioGroupContainer;

  private ACListModelAdapter medicalCoordinateAddRadioGroupModel;

  private ACRadioButtonItem medicalCoordinateAddRadioItem1;

  private ACRadioButtonItem medicalCoordinateAddRadioItem2;

  private ACClearableRadioButtonGroup impairedPersonHelpAddRadioGroup;

  private ACLabelContainer impairedPersonHelpAddRadioGroupContainer;

  private ACListModelAdapter impairedPersonHelpAddRadioGroupModel;

  private ACRadioButtonItem impairedPersonHelpAddRadioItem1;

  private ACRadioButtonItem impairedPersonHelpAddRadioItem2;

  private ACGroupBox visitCareGroup;

  private ACClearableRadioButtonGroup visitCareRadio;

  private ACLabelContainer visitCareRadioContainer;

  private ACListModelAdapter visitCareRadioModel;

  private ACRadioButtonItem visitCareRadioItem1;

  private ACRadioButtonItem visitCareRadioItem2;

  private ACRadioButtonItem visitCareRadioItem3;

  private ACIntegerCheckBox visitCareCrackOnDayCheck;

  private ACGroupBox visitNursingRadioGroup;

  private ACClearableRadioButtonGroup visitNursingFacilitiesDivisionRadio;

  private ACLabelContainer visitNursingFacilitiesDivisionRadioContainer;

  private ACListModelAdapter visitNursingFacilitiesDivisionRadioModel;

  private ACRadioButtonItem visitNursingFacilitiesDivisionRadioItem1;

  private ACRadioButtonItem visitNursingFacilitiesDivisionRadioItem2;

  private ACClearableRadioButtonGroup visitNursingStaffDivisionRadio;

  private ACLabelContainer visitNursingStaffDivisionRadioContainer;

  private ACListModelAdapter visitNursingStaffDivisionRadioModel;

  private ACRadioButtonItem visitNursingStaffDivisionRadioItem1;

  private ACRadioButtonItem visitNursingStaffDivisionRadioItem2;

  private ACComboBox visitNursingCombo;

  private ACLabelContainer visitNursingComboContainer;

  private ACComboBoxModelAdapter visitNursingComboModel;

  private ACPanel tabPanel3;

  private ACGroupBox visitRehabiliGroup;

  private ACClearableRadioButtonGroup visitRehabiliRadio;

  private ACLabelContainer visitRehabiliRadioContainer;

  private ACListModelAdapter visitRehabiliRadioModel;

  private ACRadioButtonItem visitRehabiliRadioItem1;

  private ACRadioButtonItem visitRehabiliRadioItem2;

  private ACGroupBox expertPlaceNursingGroup;

  private ACIntegerCheckBox expertPlaceNursingCrackOnDayChaeck;

  private ACClearableRadioButtonGroup expertPlaceNursingMovementFunctionImprovementAddRadio;

  private ACLabelContainer expertPlaceNursingMovementFunctionImprovementAddRadioContainer;

  private ACListModelAdapter expertPlaceNursingMovementFunctionImprovementAddRadioModel;

  private ACRadioButtonItem expertPlaceNursingMovementFunctionImprovementAddRadioItem1;

  private ACRadioButtonItem expertPlaceNursingMovementFunctionImprovementAddRadioItem2;

  private ACClearableRadioButtonGroup expertPlaceNursingNourishmentImprovementAddRadio;

  private ACLabelContainer expertPlaceNursingNourishmentImprovementAddRadioContainer;

  private ACListModelAdapter expertPlaceNursingNourishmentImprovementAddRadioModel;

  private ACRadioButtonItem expertPlaceNursingNourishmentImprovementAddRadioItem1;

  private ACRadioButtonItem expertPlaceNursingNourishmentImprovementAddRadioItem2;

  private ACClearableRadioButtonGroup expertPlaceNursingMouthFunctionImprovementAddRadio;

  private ACLabelContainer expertPlaceNursingMouthFunctionImprovementAddRadioContainer;

  private ACListModelAdapter expertPlaceNursingMouthFunctionImprovementAddRadioModel;

  private ACRadioButtonItem expertPlaceNursingMouthFunctionImprovementAddRadioItem1;

  private ACRadioButtonItem expertPlaceNursingMouthFunctionImprovementAddRadioItem2;

  private ACPanel tabPanel4;

  private ACGroupBox expertPlaceRehabiliGroup;

  private ACIntegerCheckBox expertPlaceRehabiliCrackOnDay;

  private ACClearableRadioButtonGroup expertPlaceRehabiliMovementFunctionImprovementAddRadio;

  private ACLabelContainer expertPlaceRehabiliMovementFunctionImprovementAddRadioContainer;

  private ACListModelAdapter expertPlaceRehabiliMovementFunctionImprovementAddRadioModel;

  private ACRadioButtonItem expertPlaceRehabiliMovementFunctionImprovementAddRadioItem1;

  private ACRadioButtonItem expertPlaceRehabiliMovementFunctionImprovementAddRadioItem2;

  private ACClearableRadioButtonGroup expertPlaceRehabiliNourishmentImprovementAddRadio;

  private ACLabelContainer expertPlaceRehabiliNourishmentImprovementAddRadioContainer;

  private ACListModelAdapter expertPlaceRehabiliNourishmentImprovementAddRadioModel;

  private ACRadioButtonItem expertPlaceRehabiliNourishmentImprovementAddRadioItem1;

  private ACRadioButtonItem expertPlaceRehabiliNourishmentImprovementAddRadioItem2;

  private ACClearableRadioButtonGroup expertPlaceRehabiliMouthFunctionImprovementAddRadio;

  private ACLabelContainer expertPlaceRehabiliMouthFunctionImprovementAddRadioContainer;

  private ACListModelAdapter expertPlaceRehabiliMouthFunctionImprovementAddRadioModel;

  private ACRadioButtonItem expertPlaceRehabiliMouthFunctionImprovementAddRadioItem1;

  private ACRadioButtonItem expertPlaceRehabiliMouthFunctionImprovementAddRadioItem2;

  private ACGroupBox welfareToolsGroup;

  private ACComboBox welfareToolsCombo;

  private ACLabelContainer welfareToolsComboContainer;

  private ACComboBoxModelAdapter welfareToolsComboModel;

  private ACTextField welfarePointText;

  private ACLabelContainer welfarePointTextContainer;

  private ACTextField welfareTekiyoText;

  private ACLabelContainer welfareTekiyoTextContainer;

  private ACPanel tabPanel5;

  private ACGroupBox ninchishoTaioTsushoGroup;

  private ACClearableRadioButtonGroup providerDivisionRadio;

  private ACLabelContainer providerDivisionRadioContainer;

  private ACListModelAdapter providerDivisionRadioModel;

  private ACRadioButtonItem providerDivisionRadioItem1;

  private ACRadioButtonItem providerDivisionRadioItem2;

  private ACClearableRadioButtonGroup divisionRadion;

  private ACLabelContainer divisionRadionContainer;

  private ACListModelAdapter divisionRadionModel;

  private ACRadioButtonItem divisionRadionitem1;

  private ACRadioButtonItem divisionRadionitem2;

  private ACClearableRadioButtonGroup timeDivisionRadio;

  private ACLabelContainer timeDivisionRadioContainer;

  private ACListModelAdapter timeDivisionRadioModel;

  private ACRadioButtonItem timeDivisionRadioItem1;

  private ACRadioButtonItem timeDivisionRadioItem2;

  private ACRadioButtonItem timeDivisionRadioItem3;

  private ACRadioButtonItem timeDivisionRadioItem4;

  private ACClearableRadioButtonGroup ninchishoTaioTsushoIndividualFunctionTrainingAddRadio;

  private ACLabelContainer ninchishoTaioTsushoIndividualFunctionTrainingAddRadioContainer;

  private ACListModelAdapter ninchishoTaioTsushoIndividualFunctionTrainingAddRadioModel;

  private ACRadioButtonItem ninchishoTaioTsushoIndividualFunctionTrainingAddRadioItem1;

  private ACRadioButtonItem ninchishoTaioTsushoIndividualFunctionTrainingAddRadioItem2;

  private ACClearableRadioButtonGroup ninchishoTaioTsushoNourishmentImprovementAddRadio;

  private ACLabelContainer ninchishoTaioTsushoNourishmentImprovementAddRadioContainer;

  private ACListModelAdapter ninchishoTaioTsushoNourishmentImprovementAddRadioModel;

  private ACRadioButtonItem ninchishoTaioTsushoNourishmentImprovementAddRadioItem1;

  private ACRadioButtonItem ninchishoTaioTsushoNourishmentImprovementAddRadioItem2;

  private ACClearableRadioButtonGroup ninchishoTaioTsushoMouthFunctionImprovementAddRadio;

  private ACLabelContainer ninchishoTaioTsushoMouthFunctionImprovementAddRadioContainer;

  private ACListModelAdapter ninchishoTaioTsushoMouthFunctionImprovementAddRadioModel;

  private ACRadioButtonItem ninchishoTaioTsushoMouthFunctionImprovementAddRadioItem1;

  private ACRadioButtonItem ninchishoTaioTsushoMouthFunctionImprovementAddRadioItem2;

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

      tabPanel1.setHgap(0);

      addTabPanel1();
    }
    return tabPanel1;

  }

  /**
   * 施設等の区分を取得します。
   * @return 施設等の区分
   */
  public ACClearableRadioButtonGroup getFacilitiesDivisionRadio(){
    if(facilitiesDivisionRadio==null){

      facilitiesDivisionRadio = new ACClearableRadioButtonGroup();

      getFacilitiesDivisionRadioContainer().setText("施設等の区分");

      facilitiesDivisionRadio.setBindPath("1350101");

      facilitiesDivisionRadio.setUseClearButton(false);

      facilitiesDivisionRadio.setModel(getFacilitiesDivisionRadioModel());

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
  public ACClearableRadioButtonGroup getSpecificFacilitySubtractionRadio(){
    if(specificFacilitySubtractionRadio==null){

      specificFacilitySubtractionRadio = new ACClearableRadioButtonGroup();

      getSpecificFacilitySubtractionRadioContainer().setText("人員減算");

      specificFacilitySubtractionRadio.setBindPath("1350103");

      specificFacilitySubtractionRadio.setUseClearButton(false);

      specificFacilitySubtractionRadio.setModel(getSpecificFacilitySubtractionRadioModel());

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

      outsideServiceRadio.setValues(new int[]{9,1,2,3,4,5,6,7,8});

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

      outsideServiceRadioItem8.setConstraints(VRLayout.FLOW);

      addOutsideServiceRadioItem8();
    }
    return outsideServiceRadioItem8;

  }

  /**
   * 提供時間コンテナを取得します。
   * @return 提供時間コンテナ
   */
  public ACBackLabelContainer getSpecificFacilityTimeContena(){
    if(specificFacilityTimeContena==null){

      specificFacilityTimeContena = new ACBackLabelContainer();

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
   * タブパネル2を取得します。
   * @return タブパネル2
   */
  public ACPanel getTabPanel2(){
    if(tabPanel2==null){

      tabPanel2 = new ACPanel();

      tabPanel2.setHgap(0);

      addTabPanel2();
    }
    return tabPanel2;

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
  public ACClearableRadioButtonGroup getSpecificFacilityFunctionTrainingRadio(){
    if(specificFacilityFunctionTrainingRadio==null){

      specificFacilityFunctionTrainingRadio = new ACClearableRadioButtonGroup();

      getSpecificFacilityFunctionTrainingRadioContainer().setText("個別機能訓練加算");

      specificFacilityFunctionTrainingRadio.setBindPath("1350102");

      specificFacilityFunctionTrainingRadio.setUseClearButton(false);

      specificFacilityFunctionTrainingRadio.setModel(getSpecificFacilityFunctionTrainingRadioModel());

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
  public ACClearableRadioButtonGroup getMedicalCoordinateAddRadioGroup(){
    if(medicalCoordinateAddRadioGroup==null){

      medicalCoordinateAddRadioGroup = new ACClearableRadioButtonGroup();

      getMedicalCoordinateAddRadioGroupContainer().setText("医療機関連携加算");

      medicalCoordinateAddRadioGroup.setBindPath("1350127");

      medicalCoordinateAddRadioGroup.setUseClearButton(false);

      medicalCoordinateAddRadioGroup.setModel(getMedicalCoordinateAddRadioGroupModel());

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
  public ACClearableRadioButtonGroup getImpairedPersonHelpAddRadioGroup(){
    if(impairedPersonHelpAddRadioGroup==null){

      impairedPersonHelpAddRadioGroup = new ACClearableRadioButtonGroup();

      getImpairedPersonHelpAddRadioGroupContainer().setText("障害者等支援加算");

      impairedPersonHelpAddRadioGroup.setBindPath("1350128");

      impairedPersonHelpAddRadioGroup.setUseClearButton(false);

      impairedPersonHelpAddRadioGroup.setModel(getImpairedPersonHelpAddRadioGroupModel());

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
  public ACClearableRadioButtonGroup getVisitCareRadio(){
    if(visitCareRadio==null){

      visitCareRadio = new ACClearableRadioButtonGroup();

      getVisitCareRadioContainer().setText("訪問介護費");

      visitCareRadio.setBindPath("1350105");

      visitCareRadio.setUseClearButton(false);

      visitCareRadio.setModel(getVisitCareRadioModel());

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
  public ACClearableRadioButtonGroup getVisitNursingFacilitiesDivisionRadio(){
    if(visitNursingFacilitiesDivisionRadio==null){

      visitNursingFacilitiesDivisionRadio = new ACClearableRadioButtonGroup();

      getVisitNursingFacilitiesDivisionRadioContainer().setText("施設等の区分");

      visitNursingFacilitiesDivisionRadio.setBindPath("1350107");

      visitNursingFacilitiesDivisionRadio.setUseClearButton(false);

      visitNursingFacilitiesDivisionRadio.setModel(getVisitNursingFacilitiesDivisionRadioModel());

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
  public ACClearableRadioButtonGroup getVisitNursingStaffDivisionRadio(){
    if(visitNursingStaffDivisionRadio==null){

      visitNursingStaffDivisionRadio = new ACClearableRadioButtonGroup();

      getVisitNursingStaffDivisionRadioContainer().setText("職員区分");

      visitNursingStaffDivisionRadio.setBindPath("1350108");

      visitNursingStaffDivisionRadio.setUseClearButton(false);

      visitNursingStaffDivisionRadio.setModel(getVisitNursingStaffDivisionRadioModel());

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
   * タブパネル3を取得します。
   * @return タブパネル3
   */
  public ACPanel getTabPanel3(){
    if(tabPanel3==null){

      tabPanel3 = new ACPanel();

      tabPanel3.setHgap(0);

      addTabPanel3();
    }
    return tabPanel3;

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
  public ACClearableRadioButtonGroup getVisitRehabiliRadio(){
    if(visitRehabiliRadio==null){

      visitRehabiliRadio = new ACClearableRadioButtonGroup();

      getVisitRehabiliRadioContainer().setText("施設等の区分");

      visitRehabiliRadio.setBindPath("1350110");

      visitRehabiliRadio.setUseClearButton(false);

      visitRehabiliRadio.setModel(getVisitRehabiliRadioModel());

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
   * 運動器機能向上加算を取得します。
   * @return 運動器機能向上加算
   */
  public ACClearableRadioButtonGroup getExpertPlaceNursingMovementFunctionImprovementAddRadio(){
    if(expertPlaceNursingMovementFunctionImprovementAddRadio==null){

      expertPlaceNursingMovementFunctionImprovementAddRadio = new ACClearableRadioButtonGroup();

      getExpertPlaceNursingMovementFunctionImprovementAddRadioContainer().setText("運動器機能向上加算");

      expertPlaceNursingMovementFunctionImprovementAddRadio.setBindPath("1350112");

      expertPlaceNursingMovementFunctionImprovementAddRadio.setUseClearButton(false);

      expertPlaceNursingMovementFunctionImprovementAddRadio.setModel(getExpertPlaceNursingMovementFunctionImprovementAddRadioModel());

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
  public ACClearableRadioButtonGroup getExpertPlaceNursingNourishmentImprovementAddRadio(){
    if(expertPlaceNursingNourishmentImprovementAddRadio==null){

      expertPlaceNursingNourishmentImprovementAddRadio = new ACClearableRadioButtonGroup();

      getExpertPlaceNursingNourishmentImprovementAddRadioContainer().setText("栄養改善加算");

      expertPlaceNursingNourishmentImprovementAddRadio.setBindPath("1350113");

      expertPlaceNursingNourishmentImprovementAddRadio.setUseClearButton(false);

      expertPlaceNursingNourishmentImprovementAddRadio.setModel(getExpertPlaceNursingNourishmentImprovementAddRadioModel());

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
  public ACClearableRadioButtonGroup getExpertPlaceNursingMouthFunctionImprovementAddRadio(){
    if(expertPlaceNursingMouthFunctionImprovementAddRadio==null){

      expertPlaceNursingMouthFunctionImprovementAddRadio = new ACClearableRadioButtonGroup();

      getExpertPlaceNursingMouthFunctionImprovementAddRadioContainer().setText("口腔機能向上加算");

      expertPlaceNursingMouthFunctionImprovementAddRadio.setBindPath("1350114");

      expertPlaceNursingMouthFunctionImprovementAddRadio.setUseClearButton(false);

      expertPlaceNursingMouthFunctionImprovementAddRadio.setModel(getExpertPlaceNursingMouthFunctionImprovementAddRadioModel());

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
   * タブパネル4を取得します。
   * @return タブパネル4
   */
  public ACPanel getTabPanel4(){
    if(tabPanel4==null){

      tabPanel4 = new ACPanel();

      tabPanel4.setHgap(0);

      addTabPanel4();
    }
    return tabPanel4;

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
   * 運動器機能向上加算を取得します。
   * @return 運動器機能向上加算
   */
  public ACClearableRadioButtonGroup getExpertPlaceRehabiliMovementFunctionImprovementAddRadio(){
    if(expertPlaceRehabiliMovementFunctionImprovementAddRadio==null){

      expertPlaceRehabiliMovementFunctionImprovementAddRadio = new ACClearableRadioButtonGroup();

      getExpertPlaceRehabiliMovementFunctionImprovementAddRadioContainer().setText("運動器機能向上加算");

      expertPlaceRehabiliMovementFunctionImprovementAddRadio.setBindPath("1350116");

      expertPlaceRehabiliMovementFunctionImprovementAddRadio.setUseClearButton(false);

      expertPlaceRehabiliMovementFunctionImprovementAddRadio.setModel(getExpertPlaceRehabiliMovementFunctionImprovementAddRadioModel());

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
  public ACClearableRadioButtonGroup getExpertPlaceRehabiliNourishmentImprovementAddRadio(){
    if(expertPlaceRehabiliNourishmentImprovementAddRadio==null){

      expertPlaceRehabiliNourishmentImprovementAddRadio = new ACClearableRadioButtonGroup();

      getExpertPlaceRehabiliNourishmentImprovementAddRadioContainer().setText("栄養改善加算");

      expertPlaceRehabiliNourishmentImprovementAddRadio.setBindPath("1350117");

      expertPlaceRehabiliNourishmentImprovementAddRadio.setUseClearButton(false);

      expertPlaceRehabiliNourishmentImprovementAddRadio.setModel(getExpertPlaceRehabiliNourishmentImprovementAddRadioModel());

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
  public ACClearableRadioButtonGroup getExpertPlaceRehabiliMouthFunctionImprovementAddRadio(){
    if(expertPlaceRehabiliMouthFunctionImprovementAddRadio==null){

      expertPlaceRehabiliMouthFunctionImprovementAddRadio = new ACClearableRadioButtonGroup();

      getExpertPlaceRehabiliMouthFunctionImprovementAddRadioContainer().setText("口腔機能向上加算");

      expertPlaceRehabiliMouthFunctionImprovementAddRadio.setBindPath("1350118");

      expertPlaceRehabiliMouthFunctionImprovementAddRadio.setUseClearButton(false);

      expertPlaceRehabiliMouthFunctionImprovementAddRadio.setModel(getExpertPlaceRehabiliMouthFunctionImprovementAddRadioModel());

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
   * タブパネル5を取得します。
   * @return タブパネル5
   */
  public ACPanel getTabPanel5(){
    if(tabPanel5==null){

      tabPanel5 = new ACPanel();

      tabPanel5.setHgap(0);

      tabPanel5.setLabelMargin(0);

      tabPanel5.setVgap(0);

      addTabPanel5();
    }
    return tabPanel5;

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
  public ACClearableRadioButtonGroup getProviderDivisionRadio(){
    if(providerDivisionRadio==null){

      providerDivisionRadio = new ACClearableRadioButtonGroup();

      getProviderDivisionRadioContainer().setText("施設等の区分1");

      providerDivisionRadio.setBindPath("1350121");

      providerDivisionRadio.setUseClearButton(false);

      providerDivisionRadio.setModel(getProviderDivisionRadioModel());

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
  public ACClearableRadioButtonGroup getDivisionRadion(){
    if(divisionRadion==null){

      divisionRadion = new ACClearableRadioButtonGroup();

      getDivisionRadionContainer().setText("施設等の区分2");

      divisionRadion.setBindPath("1350122");

      divisionRadion.setUseClearButton(false);

      divisionRadion.setModel(getDivisionRadionModel());

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
  public ACClearableRadioButtonGroup getTimeDivisionRadio(){
    if(timeDivisionRadio==null){

      timeDivisionRadio = new ACClearableRadioButtonGroup();

      getTimeDivisionRadioContainer().setText("時間区分");

      timeDivisionRadio.setBindPath("1350123");

      timeDivisionRadio.setUseClearButton(false);

      timeDivisionRadio.setModel(getTimeDivisionRadioModel());

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
  public ACClearableRadioButtonGroup getNinchishoTaioTsushoIndividualFunctionTrainingAddRadio(){
    if(ninchishoTaioTsushoIndividualFunctionTrainingAddRadio==null){

      ninchishoTaioTsushoIndividualFunctionTrainingAddRadio = new ACClearableRadioButtonGroup();

      getNinchishoTaioTsushoIndividualFunctionTrainingAddRadioContainer().setText("個別機能訓練加算");

      ninchishoTaioTsushoIndividualFunctionTrainingAddRadio.setBindPath("1350124");

      ninchishoTaioTsushoIndividualFunctionTrainingAddRadio.setUseClearButton(false);

      ninchishoTaioTsushoIndividualFunctionTrainingAddRadio.setModel(getNinchishoTaioTsushoIndividualFunctionTrainingAddRadioModel());

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
  public ACClearableRadioButtonGroup getNinchishoTaioTsushoNourishmentImprovementAddRadio(){
    if(ninchishoTaioTsushoNourishmentImprovementAddRadio==null){

      ninchishoTaioTsushoNourishmentImprovementAddRadio = new ACClearableRadioButtonGroup();

      getNinchishoTaioTsushoNourishmentImprovementAddRadioContainer().setText("栄養改善加算");

      ninchishoTaioTsushoNourishmentImprovementAddRadio.setBindPath("1350125");

      ninchishoTaioTsushoNourishmentImprovementAddRadio.setUseClearButton(false);

      ninchishoTaioTsushoNourishmentImprovementAddRadio.setModel(getNinchishoTaioTsushoNourishmentImprovementAddRadioModel());

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
  public ACClearableRadioButtonGroup getNinchishoTaioTsushoMouthFunctionImprovementAddRadio(){
    if(ninchishoTaioTsushoMouthFunctionImprovementAddRadio==null){

      ninchishoTaioTsushoMouthFunctionImprovementAddRadio = new ACClearableRadioButtonGroup();

      getNinchishoTaioTsushoMouthFunctionImprovementAddRadioContainer().setText("口腔機能向上加算");

      ninchishoTaioTsushoMouthFunctionImprovementAddRadio.setBindPath("1350126");

      ninchishoTaioTsushoMouthFunctionImprovementAddRadio.setUseClearButton(false);

      ninchishoTaioTsushoMouthFunctionImprovementAddRadio.setModel(getNinchishoTaioTsushoMouthFunctionImprovementAddRadioModel());

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
   * コンストラクタです。
   */
  public QS001143_H2104Design() {

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

  }

  /**
   * タブパネル1に内部項目を追加します。
   */
  protected void addTabPanel1(){

    tabPanel1.add(getFacilitiesDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tabPanel1.add(getSpecificFacilitySubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tabPanel1.add(getOutsideServiceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tabPanel1.add(getSpecificFacilityTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

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
   * タブパネル2に内部項目を追加します。
   */
  protected void addTabPanel2(){

    tabPanel2.add(getServicePanelAdd(), VRLayout.NORTH);

    tabPanel2.add(getVisitCareGroup(), VRLayout.NORTH);

    tabPanel2.add(getVisitNursingRadioGroup(), VRLayout.NORTH);

  }

  /**
   * サービス加算パネルに内部項目を追加します。
   */
  protected void addServicePanelAdd(){

    servicePanelAdd.add(getSpecificFacilityFunctionTrainingRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    servicePanelAdd.add(getMedicalCoordinateAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    servicePanelAdd.add(getImpairedPersonHelpAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * 訪問介護グループに内部項目を追加します。
   */
  protected void addVisitCareGroup(){

    visitCareGroup.add(getVisitCareRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    visitCareGroup.add(getVisitCareCrackOnDayCheck(), VRLayout.FLOW_RETURN);

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
   * 訪問看護に内部項目を追加します。
   */
  protected void addVisitNursingRadioGroup(){

    visitNursingRadioGroup.add(getVisitNursingFacilitiesDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    visitNursingRadioGroup.add(getVisitNursingStaffDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    visitNursingRadioGroup.add(getVisitNursingComboContainer(), VRLayout.FLOW);

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
   * タブパネル3に内部項目を追加します。
   */
  protected void addTabPanel3(){

    tabPanel3.add(getVisitRehabiliGroup(), VRLayout.NORTH);

    tabPanel3.add(getExpertPlaceNursingGroup(), VRLayout.NORTH);

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
   * 通所介護グループに内部項目を追加します。
   */
  protected void addExpertPlaceNursingGroup(){

    expertPlaceNursingGroup.add(getExpertPlaceNursingCrackOnDayChaeck(), VRLayout.FLOW_RETURN);

    expertPlaceNursingGroup.add(getExpertPlaceNursingMovementFunctionImprovementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    expertPlaceNursingGroup.add(getExpertPlaceNursingNourishmentImprovementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    expertPlaceNursingGroup.add(getExpertPlaceNursingMouthFunctionImprovementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 日割に内部項目を追加します。
   */
  protected void addExpertPlaceNursingCrackOnDayChaeck(){

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
   * タブパネル4に内部項目を追加します。
   */
  protected void addTabPanel4(){

    tabPanel4.add(getExpertPlaceRehabiliGroup(), VRLayout.NORTH);

    tabPanel4.add(getWelfareToolsGroup(), VRLayout.NORTH);

  }

  /**
   * 通所リハグループに内部項目を追加します。
   */
  protected void addExpertPlaceRehabiliGroup(){

    expertPlaceRehabiliGroup.add(getExpertPlaceRehabiliCrackOnDay(), VRLayout.FLOW_INSETLINE_RETURN);

    expertPlaceRehabiliGroup.add(getExpertPlaceRehabiliMovementFunctionImprovementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    expertPlaceRehabiliGroup.add(getExpertPlaceRehabiliNourishmentImprovementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    expertPlaceRehabiliGroup.add(getExpertPlaceRehabiliMouthFunctionImprovementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 日割に内部項目を追加します。
   */
  protected void addExpertPlaceRehabiliCrackOnDay(){

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
   * タブパネル5に内部項目を追加します。
   */
  protected void addTabPanel5(){

    tabPanel5.add(getNinchishoTaioTsushoGroup(), VRLayout.NORTH);

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
      ACFrame.debugStart(new ACAffairInfo(QS001143_H2104Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001143_H2104Design getThis() {
    return this;
  }
}
