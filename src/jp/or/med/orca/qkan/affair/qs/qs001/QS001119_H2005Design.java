
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
 * 作成日: 2008/04/25  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン介護老人保健施設 (QS001119_H2005)
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
 * サービスパターン介護老人保健施設画面項目デザイン(QS001119_H2005) 
 */
public class QS001119_H2005Design extends QS001ServicePanel {
  //GUIコンポーネント

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACLabelContainer kaigoHealthCareOfTheAgedDivisionContainar;

  private ACBackLabelContainer kaigoHealthCareOfTheAgedDivisionBackLavelContainar1;

  private ACValueArrayRadioButtonGroup kaigoHealthCareOfTheAgedDivisionRadio;

  private ACListModelAdapter kaigoHealthCareOfTheAgedDivisionRadioModel;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedDivisionRadioItem1;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedDivisionRadioItem2;

  private ACBackLabelContainer kaigoHealthCareOfTheAgedDivisionBackLavelContainar2;

  private ACValueArrayRadioButtonGroup kaigoHealthCareOfTheAgedDivision;

  private ACListModelAdapter kaigoHealthCareOfTheAgedDivisionModel;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedDivisionType1;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedDivisionType2;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedDivisionType3;

  private ACLabelContainer kaigoHealthCareOfTheAgedHospitalRoomContena;

  private ACClearableRadioButtonGroup kaigoHealthCareOfTheAgedHospitalRoomRadio;

  private ACListModelAdapter kaigoHealthCareOfTheAgedHospitalRoomRadioModel;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedHospitalRoomRadioItem1;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedHospitalRoomRadioItem2;

  private ACClearableRadioButtonGroup kaigoHealthCareOfTheAgedUnitHospitalRoomRadio;

  private ACListModelAdapter kaigoHealthCareOfTheAgedUnitHospitalRoomRadioModel;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem1;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem2;

  private ACClearableRadioButtonGroup kaigoHealthCareOfTheAgedNightShiftSubtractionRadio;

  private ACLabelContainer kaigoHealthCareOfTheAgedNightShiftSubtractionRadioContainer;

  private ACListModelAdapter kaigoHealthCareOfTheAgedNightShiftSubtractionRadioModel;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem1;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem2;

  private ACClearableRadioButtonGroup rehabiliManagementAddRadio;

  private ACLabelContainer rehabiliManagementAddRadioContainer;

  private ACListModelAdapter rehabiliManagementAddRadioModel;

  private ACRadioButtonItem rehabiliManagementAddRadioItem1;

  private ACRadioButtonItem rehabiliManagementAddRadioItem2;

  private ACLabelContainer shortConcentrationRehabiliContainer;

  private ACClearableRadioButtonGroup shortConcentrationRehabiliAddRadio;

  private ACListModelAdapter shortConcentrationRehabiliAddRadioModel;

  private ACRadioButtonItem shortConcentrationRehabiliAddRadioItem1;

  private ACRadioButtonItem shortConcentrationRehabiliAddRadioItem2;

  private ACIntegerCheckBox shortConcentrationRehabiliAddDementiaCheck;

  private ACClearableRadioButtonGroup kaigoHealthCareOfTheAgedStayingOutOvernightCostRadio;

  private ACLabelContainer kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioContainer;

  private ACListModelAdapter kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioModel;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem1;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem2;

  private ACClearableRadioButtonGroup kaigoHealthCareOfTheAgedDefaultRadio;

  private ACLabelContainer kaigoHealthCareOfTheAgedDefaultRadioContainer;

  private ACListModelAdapter kaigoHealthCareOfTheAgedDefaultRadioModel;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedDefaultRadioItem1;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedDefaultRadioItem2;

  private ACPanel tab2;

  private ACClearableRadioButtonGroup kaigoHealthCareOfTheAgedEmergencyRadio;

  private ACLabelContainer kaigoHealthCareOfTheAgedEmergencyRadioContainer;

  private ACListModelAdapter kaigoHealthCareOfTheAgedEmergencyRadioModel;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedEmergencyRadioItem1;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedEmergencyRadioItem2;

  private ACClearableRadioButtonGroup kaigoHealthCareOfTheAgedNutritionManageRadio;

  private ACLabelContainer kaigoHealthCareOfTheAgedNutritionManageRadioContainer;

  private ACListModelAdapter kaigoHealthCareOfTheAgedNutritionManageRadioModel;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedNutritionManageRadioItem1;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedNutritionManageRadioItem2;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedNutritionManageRadioItem3;

  private ACClearableRadioButtonGroup kaigoHealthCareOfTheAgedNutritionRadio;

  private ACLabelContainer kaigoHealthCareOfTheAgedNutritionRadioContainer;

  private ACListModelAdapter kaigoHealthCareOfTheAgedNutritionRadioModel;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedNutritionRadioItem1;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedNutritionRadioItem2;

  private ACClearableRadioButtonGroup kaigoHealthCareOfTheAgedOralSwitchRadio;

  private ACLabelContainer kaigoHealthCareOfTheAgedOralSwitchRadioContainer;

  private ACListModelAdapter kaigoHealthCareOfTheAgedOralSwitchRadioModel;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedOralSwitchRadioItem1;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedOralSwitchRadioItem2;

  private ACClearableRadioButtonGroup oralMaintenanceAddRadio;

  private ACLabelContainer oralMaintenanceAddRadioContainer;

  private ACListModelAdapter oralMaintenanceAddRadioModel;

  private ACRadioButtonItem oralMaintenanceAddRadioItem1;

  private ACRadioButtonItem oralMaintenanceAddRadioItem2;

  private ACRadioButtonItem oralMaintenanceAddRadioItem3;

  private ACClearableRadioButtonGroup kaigoHealthCareOfTheAgedRecuperateDinnerRadio;

  private ACLabelContainer kaigoHealthCareOfTheAgedRecuperateDinnerRadioContainer;

  private ACListModelAdapter kaigoHealthCareOfTheAgedRecuperateDinnerRadioModel;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedRecuperateDinnerRadioItem1;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedRecuperateDinnerRadioItem2;

  private ACLabelContainer kaigoHealthCareOfTheAgedHijoAddition;

  private ACIntegerCheckBox leavingHospitalPreConsultationAddition;

  private ACIntegerCheckBox leavingHospitalConsultationAddition;

  private ACIntegerCheckBox leavingHospitalDissemination;

  private ACIntegerCheckBox leavingHospitalCooperationAddition;

  private ACIntegerCheckBox leavingHospital;

  private ACMapBindButton specialMedicalExpense;

  private ACLabel specialMedicalExpenseLabel;

  private ACPanel tab3;

  private ACClearableRadioButtonGroup kaigoHealthCareOfTheAgedStaffSubtraction;

  private ACLabelContainer kaigoHealthCareOfTheAgedStaffSubtractionContainer;

  private ACListModelAdapter kaigoHealthCareOfTheAgedStaffSubtractionModel;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedStaffSubtractionCapacityNot;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedStaffSubtractionCapacityExcess;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedStaffSubtractionPersonLack;

  private ACBackLabelContainer kaigoHealthCareOfTheAgedDinnerContainer;

  private ACComboBox kaigoHealthCareOfTheAgedDinnerOffer;

  private ACLabelContainer kaigoHealthCareOfTheAgedDinnerOfferContainer;

  private ACComboBoxModelAdapter kaigoHealthCareOfTheAgedDinnerOfferModel;

  private ACTextField kaigoHealthCareOfTheAgedDinnerCost;

  private ACLabelContainer kaigoHealthCareOfTheAgedDinnerCostContainer;

  private ACClearableRadioButtonGroup unitCareMaintenanceRadio;

  private ACLabelContainer unitCareMaintenanceRadioContainer;

  private ACListModelAdapter unitCareMaintenanceRadioModel;

  private ACRadioButtonItem unitCareMaintenanceRadioItem1;

  private ACRadioButtonItem unitCareMaintenanceRadioItem2;

  private ACClearableRadioButtonGroup recuperationRadio;

  private ACLabelContainer recuperationRadioContainer;

  private ACListModelAdapter recuperationRadioModel;

  private ACRadioButtonItem recuperationRadioItem1;

  private ACRadioButtonItem recuperationRadioItem2;

  private ACClearableRadioButtonGroup intentionCommunicationDifficultyAddRadio;

  private ACLabelContainer intentionCommunicationDifficultyAddRadioContainer;

  private ACListModelAdapter intentionCommunicationDifficultyAddRadioModel;

  private ACRadioButtonItem intentionCommunicationDifficultyAddRadioItem1;

  private ACRadioButtonItem intentionCommunicationDifficultyAddRadioItem2;

  private ACClearableRadioButtonGroup trialHijoRadio;

  private ACLabelContainer trialHijoRadioContainer;

  private ACListModelAdapter trialHijoRadioModel;

  private ACRadioButtonItem trialHijoRadioItem1;

  private ACRadioButtonItem trialHijoRadioItem2;

  private ACClearableRadioButtonGroup bodyRestraintAbolitionRadio;

  private ACLabelContainer bodyRestraintAbolitionRadioContainer;

  private ACListModelAdapter bodyRestraintAbolitionRadioModel;

  private ACRadioButtonItem bodyRestraintAbolitionRadioItem1;

  private ACRadioButtonItem bodyRestraintAbolitionRadioItem2;

  private ACClearableRadioButtonGroup stayReturnSupportAddRadio;

  private ACLabelContainer stayReturnSupportAddRadioContainer;

  private ACListModelAdapter stayReturnSupportAddRadioModel;

  private ACRadioButtonItem stayReturnSupportAddRadioItem1;

  private ACRadioButtonItem stayReturnSupportAddRadioItem2;

  private ACClearableRadioButtonGroup terminalRadio;

  private ACLabelContainer terminalRadioContainer;

  private ACListModelAdapter terminalRadioModel;

  private ACRadioButtonItem terminalRadioItem1;

  private ACRadioButtonItem terminalRadioItem2;

  private ACClearableRadioButtonGroup kaigoHealthCareOfTheAgedCalculationDivisionRadio;

  private ACLabelContainer kaigoHealthCareOfTheAgedCalculationDivisionRadioContainer;

  private ACListModelAdapter kaigoHealthCareOfTheAgedCalculationDivisionRadioModel;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedCalculationDivisionRadioItem1;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedCalculationDivisionRadioItem2;

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

      tab1.setHgap(0);

      addTab1();
    }
    return tab1;

  }

  /**
   * 施設等の区分コンテナを取得します。
   * @return 施設等の区分コンテナ
   */
  public ACLabelContainer getKaigoHealthCareOfTheAgedDivisionContainar(){
    if(kaigoHealthCareOfTheAgedDivisionContainar==null){

      kaigoHealthCareOfTheAgedDivisionContainar = new ACLabelContainer();

      kaigoHealthCareOfTheAgedDivisionContainar.setText("施設等の区分");

      kaigoHealthCareOfTheAgedDivisionContainar.setHgap(0);

      kaigoHealthCareOfTheAgedDivisionContainar.setLabelMargin(0);

      kaigoHealthCareOfTheAgedDivisionContainar.setVgap(0);

      addKaigoHealthCareOfTheAgedDivisionContainar();
    }
    return kaigoHealthCareOfTheAgedDivisionContainar;

  }

  /**
   * 施設等の区分ラベルコンテナを取得します。
   * @return 施設等の区分ラベルコンテナ
   */
  public ACBackLabelContainer getKaigoHealthCareOfTheAgedDivisionBackLavelContainar1(){
    if(kaigoHealthCareOfTheAgedDivisionBackLavelContainar1==null){

      kaigoHealthCareOfTheAgedDivisionBackLavelContainar1 = new ACBackLabelContainer();

      kaigoHealthCareOfTheAgedDivisionBackLavelContainar1.setFollowChildEnabled(true);

      kaigoHealthCareOfTheAgedDivisionBackLavelContainar1.setHgap(0);

      kaigoHealthCareOfTheAgedDivisionBackLavelContainar1.setLabelMargin(0);

      kaigoHealthCareOfTheAgedDivisionBackLavelContainar1.setVgap(0);

      addKaigoHealthCareOfTheAgedDivisionBackLavelContainar1();
    }
    return kaigoHealthCareOfTheAgedDivisionBackLavelContainar1;

  }

  /**
   * 施設等の区分を取得します。
   * @return 施設等の区分
   */
  public ACValueArrayRadioButtonGroup getKaigoHealthCareOfTheAgedDivisionRadio(){
    if(kaigoHealthCareOfTheAgedDivisionRadio==null){

      kaigoHealthCareOfTheAgedDivisionRadio = new ACValueArrayRadioButtonGroup();

      kaigoHealthCareOfTheAgedDivisionRadio.setBindPath("1520101");

      kaigoHealthCareOfTheAgedDivisionRadio.setNoSelectIndex(0);

      kaigoHealthCareOfTheAgedDivisionRadio.setUseClearButton(false);

      kaigoHealthCareOfTheAgedDivisionRadio.setModel(getKaigoHealthCareOfTheAgedDivisionRadioModel());

      kaigoHealthCareOfTheAgedDivisionRadio.setValues(new int[]{1,3});

      addKaigoHealthCareOfTheAgedDivisionRadio();
    }
    return kaigoHealthCareOfTheAgedDivisionRadio;

  }

  /**
   * 施設等の区分モデルを取得します。
   * @return 施設等の区分モデル
   */
  protected ACListModelAdapter getKaigoHealthCareOfTheAgedDivisionRadioModel(){
    if(kaigoHealthCareOfTheAgedDivisionRadioModel==null){
      kaigoHealthCareOfTheAgedDivisionRadioModel = new ACListModelAdapter();
      addKaigoHealthCareOfTheAgedDivisionRadioModel();
    }
    return kaigoHealthCareOfTheAgedDivisionRadioModel;
  }

  /**
   * 介護保健施設を取得します。
   * @return 介護保健施設
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedDivisionRadioItem1(){
    if(kaigoHealthCareOfTheAgedDivisionRadioItem1==null){

      kaigoHealthCareOfTheAgedDivisionRadioItem1 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedDivisionRadioItem1.setText("介護保健施設");

      kaigoHealthCareOfTheAgedDivisionRadioItem1.setGroup(getKaigoHealthCareOfTheAgedDivisionRadio());

      kaigoHealthCareOfTheAgedDivisionRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoHealthCareOfTheAgedDivisionRadioItem1();
    }
    return kaigoHealthCareOfTheAgedDivisionRadioItem1;

  }

  /**
   * ユニット型介護保健施設を取得します。
   * @return ユニット型介護保健施設
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedDivisionRadioItem2(){
    if(kaigoHealthCareOfTheAgedDivisionRadioItem2==null){

      kaigoHealthCareOfTheAgedDivisionRadioItem2 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedDivisionRadioItem2.setText("ユニット型介護保健施設");

      kaigoHealthCareOfTheAgedDivisionRadioItem2.setGroup(getKaigoHealthCareOfTheAgedDivisionRadio());

      kaigoHealthCareOfTheAgedDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoHealthCareOfTheAgedDivisionRadioItem2();
    }
    return kaigoHealthCareOfTheAgedDivisionRadioItem2;

  }

  /**
   * 背面ラベルコンテナ（体制）を取得します。
   * @return 背面ラベルコンテナ（体制）
   */
  public ACBackLabelContainer getKaigoHealthCareOfTheAgedDivisionBackLavelContainar2(){
    if(kaigoHealthCareOfTheAgedDivisionBackLavelContainar2==null){

      kaigoHealthCareOfTheAgedDivisionBackLavelContainar2 = new ACBackLabelContainer();

      kaigoHealthCareOfTheAgedDivisionBackLavelContainar2.setFollowChildEnabled(true);

      kaigoHealthCareOfTheAgedDivisionBackLavelContainar2.setHgap(0);

      kaigoHealthCareOfTheAgedDivisionBackLavelContainar2.setLabelMargin(0);

      kaigoHealthCareOfTheAgedDivisionBackLavelContainar2.setVgap(0);

      addKaigoHealthCareOfTheAgedDivisionBackLavelContainar2();
    }
    return kaigoHealthCareOfTheAgedDivisionBackLavelContainar2;

  }

  /**
   * 体制を取得します。
   * @return 体制
   */
  public ACValueArrayRadioButtonGroup getKaigoHealthCareOfTheAgedDivision(){
    if(kaigoHealthCareOfTheAgedDivision==null){

      kaigoHealthCareOfTheAgedDivision = new ACValueArrayRadioButtonGroup();

      kaigoHealthCareOfTheAgedDivision.setBindPath("1520132");

      kaigoHealthCareOfTheAgedDivision.setNoSelectIndex(0);

      kaigoHealthCareOfTheAgedDivision.setUseClearButton(false);

      kaigoHealthCareOfTheAgedDivision.setModel(getKaigoHealthCareOfTheAgedDivisionModel());

      kaigoHealthCareOfTheAgedDivision.setValues(new int[]{1,2,3});

      addKaigoHealthCareOfTheAgedDivision();
    }
    return kaigoHealthCareOfTheAgedDivision;

  }

  /**
   * 体制モデルを取得します。
   * @return 体制モデル
   */
  protected ACListModelAdapter getKaigoHealthCareOfTheAgedDivisionModel(){
    if(kaigoHealthCareOfTheAgedDivisionModel==null){
      kaigoHealthCareOfTheAgedDivisionModel = new ACListModelAdapter();
      addKaigoHealthCareOfTheAgedDivisionModel();
    }
    return kaigoHealthCareOfTheAgedDivisionModel;
  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedDivisionType1(){
    if(kaigoHealthCareOfTheAgedDivisionType1==null){

      kaigoHealthCareOfTheAgedDivisionType1 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedDivisionType1.setText("I型");

      kaigoHealthCareOfTheAgedDivisionType1.setGroup(getKaigoHealthCareOfTheAgedDivision());

      kaigoHealthCareOfTheAgedDivisionType1.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedDivisionType1();
    }
    return kaigoHealthCareOfTheAgedDivisionType1;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedDivisionType2(){
    if(kaigoHealthCareOfTheAgedDivisionType2==null){

      kaigoHealthCareOfTheAgedDivisionType2 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedDivisionType2.setText("II型");

      kaigoHealthCareOfTheAgedDivisionType2.setGroup(getKaigoHealthCareOfTheAgedDivision());

      kaigoHealthCareOfTheAgedDivisionType2.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedDivisionType2();
    }
    return kaigoHealthCareOfTheAgedDivisionType2;

  }

  /**
   * III型を取得します。
   * @return III型
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedDivisionType3(){
    if(kaigoHealthCareOfTheAgedDivisionType3==null){

      kaigoHealthCareOfTheAgedDivisionType3 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedDivisionType3.setText("III型");

      kaigoHealthCareOfTheAgedDivisionType3.setGroup(getKaigoHealthCareOfTheAgedDivision());

      kaigoHealthCareOfTheAgedDivisionType3.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedDivisionType3();
    }
    return kaigoHealthCareOfTheAgedDivisionType3;

  }

  /**
   * 病室区分コンテナを取得します。
   * @return 病室区分コンテナ
   */
  public ACLabelContainer getKaigoHealthCareOfTheAgedHospitalRoomContena(){
    if(kaigoHealthCareOfTheAgedHospitalRoomContena==null){

      kaigoHealthCareOfTheAgedHospitalRoomContena = new ACLabelContainer();

      kaigoHealthCareOfTheAgedHospitalRoomContena.setText("病室区分");

      addKaigoHealthCareOfTheAgedHospitalRoomContena();
    }
    return kaigoHealthCareOfTheAgedHospitalRoomContena;

  }

  /**
   * 病室区分（介護保健施設）を取得します。
   * @return 病室区分（介護保健施設）
   */
  public ACClearableRadioButtonGroup getKaigoHealthCareOfTheAgedHospitalRoomRadio(){
    if(kaigoHealthCareOfTheAgedHospitalRoomRadio==null){

      kaigoHealthCareOfTheAgedHospitalRoomRadio = new ACClearableRadioButtonGroup();

      kaigoHealthCareOfTheAgedHospitalRoomRadio.setBindPath("1520102");

      kaigoHealthCareOfTheAgedHospitalRoomRadio.setUseClearButton(false);

      kaigoHealthCareOfTheAgedHospitalRoomRadio.setModel(getKaigoHealthCareOfTheAgedHospitalRoomRadioModel());

      addKaigoHealthCareOfTheAgedHospitalRoomRadio();
    }
    return kaigoHealthCareOfTheAgedHospitalRoomRadio;

  }

  /**
   * 病室区分（介護保健施設）モデルを取得します。
   * @return 病室区分（介護保健施設）モデル
   */
  protected ACListModelAdapter getKaigoHealthCareOfTheAgedHospitalRoomRadioModel(){
    if(kaigoHealthCareOfTheAgedHospitalRoomRadioModel==null){
      kaigoHealthCareOfTheAgedHospitalRoomRadioModel = new ACListModelAdapter();
      addKaigoHealthCareOfTheAgedHospitalRoomRadioModel();
    }
    return kaigoHealthCareOfTheAgedHospitalRoomRadioModel;
  }

  /**
   * 従来型個室を取得します。
   * @return 従来型個室
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedHospitalRoomRadioItem1(){
    if(kaigoHealthCareOfTheAgedHospitalRoomRadioItem1==null){

      kaigoHealthCareOfTheAgedHospitalRoomRadioItem1 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedHospitalRoomRadioItem1.setText("従来型個室");

      kaigoHealthCareOfTheAgedHospitalRoomRadioItem1.setGroup(getKaigoHealthCareOfTheAgedHospitalRoomRadio());

      kaigoHealthCareOfTheAgedHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedHospitalRoomRadioItem1();
    }
    return kaigoHealthCareOfTheAgedHospitalRoomRadioItem1;

  }

  /**
   * 多床室を取得します。
   * @return 多床室
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedHospitalRoomRadioItem2(){
    if(kaigoHealthCareOfTheAgedHospitalRoomRadioItem2==null){

      kaigoHealthCareOfTheAgedHospitalRoomRadioItem2 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedHospitalRoomRadioItem2.setText("多床室");

      kaigoHealthCareOfTheAgedHospitalRoomRadioItem2.setGroup(getKaigoHealthCareOfTheAgedHospitalRoomRadio());

      kaigoHealthCareOfTheAgedHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedHospitalRoomRadioItem2();
    }
    return kaigoHealthCareOfTheAgedHospitalRoomRadioItem2;

  }

  /**
   * 病室区分（ユニット型）を取得します。
   * @return 病室区分（ユニット型）
   */
  public ACClearableRadioButtonGroup getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio(){
    if(kaigoHealthCareOfTheAgedUnitHospitalRoomRadio==null){

      kaigoHealthCareOfTheAgedUnitHospitalRoomRadio = new ACClearableRadioButtonGroup();

      kaigoHealthCareOfTheAgedUnitHospitalRoomRadio.setBindPath("1520103");

      kaigoHealthCareOfTheAgedUnitHospitalRoomRadio.setUseClearButton(false);

      kaigoHealthCareOfTheAgedUnitHospitalRoomRadio.setModel(getKaigoHealthCareOfTheAgedUnitHospitalRoomRadioModel());

      addKaigoHealthCareOfTheAgedUnitHospitalRoomRadio();
    }
    return kaigoHealthCareOfTheAgedUnitHospitalRoomRadio;

  }

  /**
   * 病室区分（ユニット型）モデルを取得します。
   * @return 病室区分（ユニット型）モデル
   */
  protected ACListModelAdapter getKaigoHealthCareOfTheAgedUnitHospitalRoomRadioModel(){
    if(kaigoHealthCareOfTheAgedUnitHospitalRoomRadioModel==null){
      kaigoHealthCareOfTheAgedUnitHospitalRoomRadioModel = new ACListModelAdapter();
      addKaigoHealthCareOfTheAgedUnitHospitalRoomRadioModel();
    }
    return kaigoHealthCareOfTheAgedUnitHospitalRoomRadioModel;
  }

  /**
   * ユニット型個室を取得します。
   * @return ユニット型個室
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem1(){
    if(kaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem1==null){

      kaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem1 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem1.setText("ユニット型個室");

      kaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem1.setGroup(getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio());

      kaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem1();
    }
    return kaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem1;

  }

  /**
   * ユニット型準個室を取得します。
   * @return ユニット型準個室
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem2(){
    if(kaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem2==null){

      kaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem2 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem2.setText("ユニット型準個室");

      kaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem2.setGroup(getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio());

      kaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem2();
    }
    return kaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem2;

  }

  /**
   * 夜間勤務条件基準を取得します。
   * @return 夜間勤務条件基準
   */
  public ACClearableRadioButtonGroup getKaigoHealthCareOfTheAgedNightShiftSubtractionRadio(){
    if(kaigoHealthCareOfTheAgedNightShiftSubtractionRadio==null){

      kaigoHealthCareOfTheAgedNightShiftSubtractionRadio = new ACClearableRadioButtonGroup();

      getKaigoHealthCareOfTheAgedNightShiftSubtractionRadioContainer().setText("夜間勤務条件基準");

      kaigoHealthCareOfTheAgedNightShiftSubtractionRadio.setBindPath("1520104");

      kaigoHealthCareOfTheAgedNightShiftSubtractionRadio.setUseClearButton(false);

      kaigoHealthCareOfTheAgedNightShiftSubtractionRadio.setModel(getKaigoHealthCareOfTheAgedNightShiftSubtractionRadioModel());

      addKaigoHealthCareOfTheAgedNightShiftSubtractionRadio();
    }
    return kaigoHealthCareOfTheAgedNightShiftSubtractionRadio;

  }

  /**
   * 夜間勤務条件基準コンテナを取得します。
   * @return 夜間勤務条件基準コンテナ
   */
  protected ACLabelContainer getKaigoHealthCareOfTheAgedNightShiftSubtractionRadioContainer(){
    if(kaigoHealthCareOfTheAgedNightShiftSubtractionRadioContainer==null){
      kaigoHealthCareOfTheAgedNightShiftSubtractionRadioContainer = new ACLabelContainer();
      kaigoHealthCareOfTheAgedNightShiftSubtractionRadioContainer.setFollowChildEnabled(true);
      kaigoHealthCareOfTheAgedNightShiftSubtractionRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoHealthCareOfTheAgedNightShiftSubtractionRadioContainer.add(getKaigoHealthCareOfTheAgedNightShiftSubtractionRadio(), null);
    }
    return kaigoHealthCareOfTheAgedNightShiftSubtractionRadioContainer;
  }

  /**
   * 夜間勤務条件基準モデルを取得します。
   * @return 夜間勤務条件基準モデル
   */
  protected ACListModelAdapter getKaigoHealthCareOfTheAgedNightShiftSubtractionRadioModel(){
    if(kaigoHealthCareOfTheAgedNightShiftSubtractionRadioModel==null){
      kaigoHealthCareOfTheAgedNightShiftSubtractionRadioModel = new ACListModelAdapter();
      addKaigoHealthCareOfTheAgedNightShiftSubtractionRadioModel();
    }
    return kaigoHealthCareOfTheAgedNightShiftSubtractionRadioModel;
  }

  /**
   * 基準型を取得します。
   * @return 基準型
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem1(){
    if(kaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem1==null){

      kaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem1 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem1.setText("基準型");

      kaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem1.setGroup(getKaigoHealthCareOfTheAgedNightShiftSubtractionRadio());

      kaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem1();
    }
    return kaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem1;

  }

  /**
   * 減算型を取得します。
   * @return 減算型
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem2(){
    if(kaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem2==null){

      kaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem2 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem2.setText("減算型");

      kaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem2.setGroup(getKaigoHealthCareOfTheAgedNightShiftSubtractionRadio());

      kaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem2();
    }
    return kaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem2;

  }

  /**
   * リハビリ・マネジメント加算を取得します。
   * @return リハビリ・マネジメント加算
   */
  public ACClearableRadioButtonGroup getRehabiliManagementAddRadio(){
    if(rehabiliManagementAddRadio==null){

      rehabiliManagementAddRadio = new ACClearableRadioButtonGroup();

      getRehabiliManagementAddRadioContainer().setText("リハビリ・マネジメント加算");

      rehabiliManagementAddRadio.setBindPath("1520123");

      rehabiliManagementAddRadio.setUseClearButton(false);

      rehabiliManagementAddRadio.setModel(getRehabiliManagementAddRadioModel());

      addRehabiliManagementAddRadio();
    }
    return rehabiliManagementAddRadio;

  }

  /**
   * リハビリ・マネジメント加算コンテナを取得します。
   * @return リハビリ・マネジメント加算コンテナ
   */
  protected ACLabelContainer getRehabiliManagementAddRadioContainer(){
    if(rehabiliManagementAddRadioContainer==null){
      rehabiliManagementAddRadioContainer = new ACLabelContainer();
      rehabiliManagementAddRadioContainer.setFollowChildEnabled(true);
      rehabiliManagementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      rehabiliManagementAddRadioContainer.add(getRehabiliManagementAddRadio(), null);
    }
    return rehabiliManagementAddRadioContainer;
  }

  /**
   * リハビリ・マネジメント加算モデルを取得します。
   * @return リハビリ・マネジメント加算モデル
   */
  protected ACListModelAdapter getRehabiliManagementAddRadioModel(){
    if(rehabiliManagementAddRadioModel==null){
      rehabiliManagementAddRadioModel = new ACListModelAdapter();
      addRehabiliManagementAddRadioModel();
    }
    return rehabiliManagementAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getRehabiliManagementAddRadioItem1(){
    if(rehabiliManagementAddRadioItem1==null){

      rehabiliManagementAddRadioItem1 = new ACRadioButtonItem();

      rehabiliManagementAddRadioItem1.setText("なし");

      rehabiliManagementAddRadioItem1.setGroup(getRehabiliManagementAddRadio());

      rehabiliManagementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addRehabiliManagementAddRadioItem1();
    }
    return rehabiliManagementAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getRehabiliManagementAddRadioItem2(){
    if(rehabiliManagementAddRadioItem2==null){

      rehabiliManagementAddRadioItem2 = new ACRadioButtonItem();

      rehabiliManagementAddRadioItem2.setText("あり");

      rehabiliManagementAddRadioItem2.setGroup(getRehabiliManagementAddRadio());

      rehabiliManagementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addRehabiliManagementAddRadioItem2();
    }
    return rehabiliManagementAddRadioItem2;

  }

  /**
   * 短期集中リハビリ加算コンテナを取得します。
   * @return 短期集中リハビリ加算コンテナ
   */
  public ACLabelContainer getShortConcentrationRehabiliContainer(){
    if(shortConcentrationRehabiliContainer==null){

      shortConcentrationRehabiliContainer = new ACLabelContainer();

      shortConcentrationRehabiliContainer.setText("短期集中リハビリ加算");

      addShortConcentrationRehabiliContainer();
    }
    return shortConcentrationRehabiliContainer;

  }

  /**
   * 短期集中リハビリ加算を取得します。
   * @return 短期集中リハビリ加算
   */
  public ACClearableRadioButtonGroup getShortConcentrationRehabiliAddRadio(){
    if(shortConcentrationRehabiliAddRadio==null){

      shortConcentrationRehabiliAddRadio = new ACClearableRadioButtonGroup();

      shortConcentrationRehabiliAddRadio.setBindPath("1520124");

      shortConcentrationRehabiliAddRadio.setUseClearButton(false);

      shortConcentrationRehabiliAddRadio.setModel(getShortConcentrationRehabiliAddRadioModel());

      addShortConcentrationRehabiliAddRadio();
    }
    return shortConcentrationRehabiliAddRadio;

  }

  /**
   * 短期集中リハビリ加算モデルを取得します。
   * @return 短期集中リハビリ加算モデル
   */
  protected ACListModelAdapter getShortConcentrationRehabiliAddRadioModel(){
    if(shortConcentrationRehabiliAddRadioModel==null){
      shortConcentrationRehabiliAddRadioModel = new ACListModelAdapter();
      addShortConcentrationRehabiliAddRadioModel();
    }
    return shortConcentrationRehabiliAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortConcentrationRehabiliAddRadioItem1(){
    if(shortConcentrationRehabiliAddRadioItem1==null){

      shortConcentrationRehabiliAddRadioItem1 = new ACRadioButtonItem();

      shortConcentrationRehabiliAddRadioItem1.setText("なし");

      shortConcentrationRehabiliAddRadioItem1.setGroup(getShortConcentrationRehabiliAddRadio());

      shortConcentrationRehabiliAddRadioItem1.setConstraints(VRLayout.FLOW);

      addShortConcentrationRehabiliAddRadioItem1();
    }
    return shortConcentrationRehabiliAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortConcentrationRehabiliAddRadioItem2(){
    if(shortConcentrationRehabiliAddRadioItem2==null){

      shortConcentrationRehabiliAddRadioItem2 = new ACRadioButtonItem();

      shortConcentrationRehabiliAddRadioItem2.setText("あり");

      shortConcentrationRehabiliAddRadioItem2.setGroup(getShortConcentrationRehabiliAddRadio());

      shortConcentrationRehabiliAddRadioItem2.setConstraints(VRLayout.FLOW);

      addShortConcentrationRehabiliAddRadioItem2();
    }
    return shortConcentrationRehabiliAddRadioItem2;

  }

  /**
   * 認知症高齢者を取得します。
   * @return 認知症高齢者
   */
  public ACIntegerCheckBox getShortConcentrationRehabiliAddDementiaCheck(){
    if(shortConcentrationRehabiliAddDementiaCheck==null){

      shortConcentrationRehabiliAddDementiaCheck = new ACIntegerCheckBox();

      shortConcentrationRehabiliAddDementiaCheck.setText("認知症高齢者");

      shortConcentrationRehabiliAddDementiaCheck.setBindPath("1520125");

      shortConcentrationRehabiliAddDementiaCheck.setSelectValue(2);

      shortConcentrationRehabiliAddDementiaCheck.setUnSelectValue(1);

      addShortConcentrationRehabiliAddDementiaCheck();
    }
    return shortConcentrationRehabiliAddDementiaCheck;

  }

  /**
   * 外泊時加算を取得します。
   * @return 外泊時加算
   */
  public ACClearableRadioButtonGroup getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadio(){
    if(kaigoHealthCareOfTheAgedStayingOutOvernightCostRadio==null){

      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadio = new ACClearableRadioButtonGroup();

      getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioContainer().setText("外泊加算");

      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadio.setBindPath("1520107");

      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadio.setUseClearButton(false);

      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadio.setModel(getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioModel());

      addKaigoHealthCareOfTheAgedStayingOutOvernightCostRadio();
    }
    return kaigoHealthCareOfTheAgedStayingOutOvernightCostRadio;

  }

  /**
   * 外泊時加算コンテナを取得します。
   * @return 外泊時加算コンテナ
   */
  protected ACLabelContainer getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioContainer(){
    if(kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioContainer==null){
      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioContainer = new ACLabelContainer();
      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioContainer.setFollowChildEnabled(true);
      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioContainer.add(getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadio(), null);
    }
    return kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioContainer;
  }

  /**
   * 外泊時加算モデルを取得します。
   * @return 外泊時加算モデル
   */
  protected ACListModelAdapter getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioModel(){
    if(kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioModel==null){
      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioModel = new ACListModelAdapter();
      addKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioModel();
    }
    return kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem1(){
    if(kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem1==null){

      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem1 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem1.setText("なし");

      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem1.setGroup(getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadio());

      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem1();
    }
    return kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem2(){
    if(kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem2==null){

      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem2 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem2.setText("あり");

      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem2.setGroup(getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadio());

      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem2();
    }
    return kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem2;

  }

  /**
   * 初期加算を取得します。
   * @return 初期加算
   */
  public ACClearableRadioButtonGroup getKaigoHealthCareOfTheAgedDefaultRadio(){
    if(kaigoHealthCareOfTheAgedDefaultRadio==null){

      kaigoHealthCareOfTheAgedDefaultRadio = new ACClearableRadioButtonGroup();

      getKaigoHealthCareOfTheAgedDefaultRadioContainer().setText("初期加算");

      kaigoHealthCareOfTheAgedDefaultRadio.setBindPath("1520108");

      kaigoHealthCareOfTheAgedDefaultRadio.setUseClearButton(false);

      kaigoHealthCareOfTheAgedDefaultRadio.setModel(getKaigoHealthCareOfTheAgedDefaultRadioModel());

      addKaigoHealthCareOfTheAgedDefaultRadio();
    }
    return kaigoHealthCareOfTheAgedDefaultRadio;

  }

  /**
   * 初期加算コンテナを取得します。
   * @return 初期加算コンテナ
   */
  protected ACLabelContainer getKaigoHealthCareOfTheAgedDefaultRadioContainer(){
    if(kaigoHealthCareOfTheAgedDefaultRadioContainer==null){
      kaigoHealthCareOfTheAgedDefaultRadioContainer = new ACLabelContainer();
      kaigoHealthCareOfTheAgedDefaultRadioContainer.setFollowChildEnabled(true);
      kaigoHealthCareOfTheAgedDefaultRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoHealthCareOfTheAgedDefaultRadioContainer.add(getKaigoHealthCareOfTheAgedDefaultRadio(), null);
    }
    return kaigoHealthCareOfTheAgedDefaultRadioContainer;
  }

  /**
   * 初期加算モデルを取得します。
   * @return 初期加算モデル
   */
  protected ACListModelAdapter getKaigoHealthCareOfTheAgedDefaultRadioModel(){
    if(kaigoHealthCareOfTheAgedDefaultRadioModel==null){
      kaigoHealthCareOfTheAgedDefaultRadioModel = new ACListModelAdapter();
      addKaigoHealthCareOfTheAgedDefaultRadioModel();
    }
    return kaigoHealthCareOfTheAgedDefaultRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedDefaultRadioItem1(){
    if(kaigoHealthCareOfTheAgedDefaultRadioItem1==null){

      kaigoHealthCareOfTheAgedDefaultRadioItem1 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedDefaultRadioItem1.setText("なし");

      kaigoHealthCareOfTheAgedDefaultRadioItem1.setGroup(getKaigoHealthCareOfTheAgedDefaultRadio());

      kaigoHealthCareOfTheAgedDefaultRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedDefaultRadioItem1();
    }
    return kaigoHealthCareOfTheAgedDefaultRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedDefaultRadioItem2(){
    if(kaigoHealthCareOfTheAgedDefaultRadioItem2==null){

      kaigoHealthCareOfTheAgedDefaultRadioItem2 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedDefaultRadioItem2.setText("あり");

      kaigoHealthCareOfTheAgedDefaultRadioItem2.setGroup(getKaigoHealthCareOfTheAgedDefaultRadio());

      kaigoHealthCareOfTheAgedDefaultRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedDefaultRadioItem2();
    }
    return kaigoHealthCareOfTheAgedDefaultRadioItem2;

  }

  /**
   * タブ2を取得します。
   * @return タブ2
   */
  public ACPanel getTab2(){
    if(tab2==null){

      tab2 = new ACPanel();

      tab2.setHgap(0);

      addTab2();
    }
    return tab2;

  }

  /**
   * 緊急時治療管理加算を取得します。
   * @return 緊急時治療管理加算
   */
  public ACClearableRadioButtonGroup getKaigoHealthCareOfTheAgedEmergencyRadio(){
    if(kaigoHealthCareOfTheAgedEmergencyRadio==null){

      kaigoHealthCareOfTheAgedEmergencyRadio = new ACClearableRadioButtonGroup();

      getKaigoHealthCareOfTheAgedEmergencyRadioContainer().setText("緊急時治療管理加算");

      kaigoHealthCareOfTheAgedEmergencyRadio.setBindPath("1520109");

      kaigoHealthCareOfTheAgedEmergencyRadio.setUseClearButton(false);

      kaigoHealthCareOfTheAgedEmergencyRadio.setModel(getKaigoHealthCareOfTheAgedEmergencyRadioModel());

      addKaigoHealthCareOfTheAgedEmergencyRadio();
    }
    return kaigoHealthCareOfTheAgedEmergencyRadio;

  }

  /**
   * 緊急時治療管理加算コンテナを取得します。
   * @return 緊急時治療管理加算コンテナ
   */
  protected ACLabelContainer getKaigoHealthCareOfTheAgedEmergencyRadioContainer(){
    if(kaigoHealthCareOfTheAgedEmergencyRadioContainer==null){
      kaigoHealthCareOfTheAgedEmergencyRadioContainer = new ACLabelContainer();
      kaigoHealthCareOfTheAgedEmergencyRadioContainer.setFollowChildEnabled(true);
      kaigoHealthCareOfTheAgedEmergencyRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoHealthCareOfTheAgedEmergencyRadioContainer.add(getKaigoHealthCareOfTheAgedEmergencyRadio(), null);
    }
    return kaigoHealthCareOfTheAgedEmergencyRadioContainer;
  }

  /**
   * 緊急時治療管理加算モデルを取得します。
   * @return 緊急時治療管理加算モデル
   */
  protected ACListModelAdapter getKaigoHealthCareOfTheAgedEmergencyRadioModel(){
    if(kaigoHealthCareOfTheAgedEmergencyRadioModel==null){
      kaigoHealthCareOfTheAgedEmergencyRadioModel = new ACListModelAdapter();
      addKaigoHealthCareOfTheAgedEmergencyRadioModel();
    }
    return kaigoHealthCareOfTheAgedEmergencyRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedEmergencyRadioItem1(){
    if(kaigoHealthCareOfTheAgedEmergencyRadioItem1==null){

      kaigoHealthCareOfTheAgedEmergencyRadioItem1 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedEmergencyRadioItem1.setText("なし");

      kaigoHealthCareOfTheAgedEmergencyRadioItem1.setGroup(getKaigoHealthCareOfTheAgedEmergencyRadio());

      kaigoHealthCareOfTheAgedEmergencyRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedEmergencyRadioItem1();
    }
    return kaigoHealthCareOfTheAgedEmergencyRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedEmergencyRadioItem2(){
    if(kaigoHealthCareOfTheAgedEmergencyRadioItem2==null){

      kaigoHealthCareOfTheAgedEmergencyRadioItem2 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedEmergencyRadioItem2.setText("あり");

      kaigoHealthCareOfTheAgedEmergencyRadioItem2.setGroup(getKaigoHealthCareOfTheAgedEmergencyRadio());

      kaigoHealthCareOfTheAgedEmergencyRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedEmergencyRadioItem2();
    }
    return kaigoHealthCareOfTheAgedEmergencyRadioItem2;

  }

  /**
   * 栄養管理体制加算を取得します。
   * @return 栄養管理体制加算
   */
  public ACClearableRadioButtonGroup getKaigoHealthCareOfTheAgedNutritionManageRadio(){
    if(kaigoHealthCareOfTheAgedNutritionManageRadio==null){

      kaigoHealthCareOfTheAgedNutritionManageRadio = new ACClearableRadioButtonGroup();

      getKaigoHealthCareOfTheAgedNutritionManageRadioContainer().setText("栄養管理体制加算");

      kaigoHealthCareOfTheAgedNutritionManageRadio.setBindPath("1520110");

      kaigoHealthCareOfTheAgedNutritionManageRadio.setUseClearButton(false);

      kaigoHealthCareOfTheAgedNutritionManageRadio.setModel(getKaigoHealthCareOfTheAgedNutritionManageRadioModel());

      addKaigoHealthCareOfTheAgedNutritionManageRadio();
    }
    return kaigoHealthCareOfTheAgedNutritionManageRadio;

  }

  /**
   * 栄養管理体制加算コンテナを取得します。
   * @return 栄養管理体制加算コンテナ
   */
  protected ACLabelContainer getKaigoHealthCareOfTheAgedNutritionManageRadioContainer(){
    if(kaigoHealthCareOfTheAgedNutritionManageRadioContainer==null){
      kaigoHealthCareOfTheAgedNutritionManageRadioContainer = new ACLabelContainer();
      kaigoHealthCareOfTheAgedNutritionManageRadioContainer.setFollowChildEnabled(true);
      kaigoHealthCareOfTheAgedNutritionManageRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoHealthCareOfTheAgedNutritionManageRadioContainer.add(getKaigoHealthCareOfTheAgedNutritionManageRadio(), null);
    }
    return kaigoHealthCareOfTheAgedNutritionManageRadioContainer;
  }

  /**
   * 栄養管理体制加算モデルを取得します。
   * @return 栄養管理体制加算モデル
   */
  protected ACListModelAdapter getKaigoHealthCareOfTheAgedNutritionManageRadioModel(){
    if(kaigoHealthCareOfTheAgedNutritionManageRadioModel==null){
      kaigoHealthCareOfTheAgedNutritionManageRadioModel = new ACListModelAdapter();
      addKaigoHealthCareOfTheAgedNutritionManageRadioModel();
    }
    return kaigoHealthCareOfTheAgedNutritionManageRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedNutritionManageRadioItem1(){
    if(kaigoHealthCareOfTheAgedNutritionManageRadioItem1==null){

      kaigoHealthCareOfTheAgedNutritionManageRadioItem1 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedNutritionManageRadioItem1.setText("なし");

      kaigoHealthCareOfTheAgedNutritionManageRadioItem1.setGroup(getKaigoHealthCareOfTheAgedNutritionManageRadio());

      kaigoHealthCareOfTheAgedNutritionManageRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedNutritionManageRadioItem1();
    }
    return kaigoHealthCareOfTheAgedNutritionManageRadioItem1;

  }

  /**
   * 管理栄養士を取得します。
   * @return 管理栄養士
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedNutritionManageRadioItem2(){
    if(kaigoHealthCareOfTheAgedNutritionManageRadioItem2==null){

      kaigoHealthCareOfTheAgedNutritionManageRadioItem2 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedNutritionManageRadioItem2.setText("管理栄養士");

      kaigoHealthCareOfTheAgedNutritionManageRadioItem2.setGroup(getKaigoHealthCareOfTheAgedNutritionManageRadio());

      kaigoHealthCareOfTheAgedNutritionManageRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoHealthCareOfTheAgedNutritionManageRadioItem2();
    }
    return kaigoHealthCareOfTheAgedNutritionManageRadioItem2;

  }

  /**
   * 栄養士を取得します。
   * @return 栄養士
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedNutritionManageRadioItem3(){
    if(kaigoHealthCareOfTheAgedNutritionManageRadioItem3==null){

      kaigoHealthCareOfTheAgedNutritionManageRadioItem3 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedNutritionManageRadioItem3.setText("栄養士");

      kaigoHealthCareOfTheAgedNutritionManageRadioItem3.setGroup(getKaigoHealthCareOfTheAgedNutritionManageRadio());

      kaigoHealthCareOfTheAgedNutritionManageRadioItem3.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedNutritionManageRadioItem3();
    }
    return kaigoHealthCareOfTheAgedNutritionManageRadioItem3;

  }

  /**
   * 栄養マネジメント加算を取得します。
   * @return 栄養マネジメント加算
   */
  public ACClearableRadioButtonGroup getKaigoHealthCareOfTheAgedNutritionRadio(){
    if(kaigoHealthCareOfTheAgedNutritionRadio==null){

      kaigoHealthCareOfTheAgedNutritionRadio = new ACClearableRadioButtonGroup();

      getKaigoHealthCareOfTheAgedNutritionRadioContainer().setText("栄養マネジメント加算");

      kaigoHealthCareOfTheAgedNutritionRadio.setBindPath("1520111");

      kaigoHealthCareOfTheAgedNutritionRadio.setUseClearButton(false);

      kaigoHealthCareOfTheAgedNutritionRadio.setModel(getKaigoHealthCareOfTheAgedNutritionRadioModel());

      addKaigoHealthCareOfTheAgedNutritionRadio();
    }
    return kaigoHealthCareOfTheAgedNutritionRadio;

  }

  /**
   * 栄養マネジメント加算コンテナを取得します。
   * @return 栄養マネジメント加算コンテナ
   */
  protected ACLabelContainer getKaigoHealthCareOfTheAgedNutritionRadioContainer(){
    if(kaigoHealthCareOfTheAgedNutritionRadioContainer==null){
      kaigoHealthCareOfTheAgedNutritionRadioContainer = new ACLabelContainer();
      kaigoHealthCareOfTheAgedNutritionRadioContainer.setFollowChildEnabled(true);
      kaigoHealthCareOfTheAgedNutritionRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoHealthCareOfTheAgedNutritionRadioContainer.add(getKaigoHealthCareOfTheAgedNutritionRadio(), null);
    }
    return kaigoHealthCareOfTheAgedNutritionRadioContainer;
  }

  /**
   * 栄養マネジメント加算モデルを取得します。
   * @return 栄養マネジメント加算モデル
   */
  protected ACListModelAdapter getKaigoHealthCareOfTheAgedNutritionRadioModel(){
    if(kaigoHealthCareOfTheAgedNutritionRadioModel==null){
      kaigoHealthCareOfTheAgedNutritionRadioModel = new ACListModelAdapter();
      addKaigoHealthCareOfTheAgedNutritionRadioModel();
    }
    return kaigoHealthCareOfTheAgedNutritionRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedNutritionRadioItem1(){
    if(kaigoHealthCareOfTheAgedNutritionRadioItem1==null){

      kaigoHealthCareOfTheAgedNutritionRadioItem1 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedNutritionRadioItem1.setText("なし");

      kaigoHealthCareOfTheAgedNutritionRadioItem1.setGroup(getKaigoHealthCareOfTheAgedNutritionRadio());

      kaigoHealthCareOfTheAgedNutritionRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedNutritionRadioItem1();
    }
    return kaigoHealthCareOfTheAgedNutritionRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedNutritionRadioItem2(){
    if(kaigoHealthCareOfTheAgedNutritionRadioItem2==null){

      kaigoHealthCareOfTheAgedNutritionRadioItem2 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedNutritionRadioItem2.setText("あり");

      kaigoHealthCareOfTheAgedNutritionRadioItem2.setGroup(getKaigoHealthCareOfTheAgedNutritionRadio());

      kaigoHealthCareOfTheAgedNutritionRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedNutritionRadioItem2();
    }
    return kaigoHealthCareOfTheAgedNutritionRadioItem2;

  }

  /**
   * 経口移行加算を取得します。
   * @return 経口移行加算
   */
  public ACClearableRadioButtonGroup getKaigoHealthCareOfTheAgedOralSwitchRadio(){
    if(kaigoHealthCareOfTheAgedOralSwitchRadio==null){

      kaigoHealthCareOfTheAgedOralSwitchRadio = new ACClearableRadioButtonGroup();

      getKaigoHealthCareOfTheAgedOralSwitchRadioContainer().setText("経口移行加算");

      kaigoHealthCareOfTheAgedOralSwitchRadio.setBindPath("1520112");

      kaigoHealthCareOfTheAgedOralSwitchRadio.setUseClearButton(false);

      kaigoHealthCareOfTheAgedOralSwitchRadio.setModel(getKaigoHealthCareOfTheAgedOralSwitchRadioModel());

      addKaigoHealthCareOfTheAgedOralSwitchRadio();
    }
    return kaigoHealthCareOfTheAgedOralSwitchRadio;

  }

  /**
   * 経口移行加算コンテナを取得します。
   * @return 経口移行加算コンテナ
   */
  protected ACLabelContainer getKaigoHealthCareOfTheAgedOralSwitchRadioContainer(){
    if(kaigoHealthCareOfTheAgedOralSwitchRadioContainer==null){
      kaigoHealthCareOfTheAgedOralSwitchRadioContainer = new ACLabelContainer();
      kaigoHealthCareOfTheAgedOralSwitchRadioContainer.setFollowChildEnabled(true);
      kaigoHealthCareOfTheAgedOralSwitchRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoHealthCareOfTheAgedOralSwitchRadioContainer.add(getKaigoHealthCareOfTheAgedOralSwitchRadio(), null);
    }
    return kaigoHealthCareOfTheAgedOralSwitchRadioContainer;
  }

  /**
   * 経口移行加算モデルを取得します。
   * @return 経口移行加算モデル
   */
  protected ACListModelAdapter getKaigoHealthCareOfTheAgedOralSwitchRadioModel(){
    if(kaigoHealthCareOfTheAgedOralSwitchRadioModel==null){
      kaigoHealthCareOfTheAgedOralSwitchRadioModel = new ACListModelAdapter();
      addKaigoHealthCareOfTheAgedOralSwitchRadioModel();
    }
    return kaigoHealthCareOfTheAgedOralSwitchRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedOralSwitchRadioItem1(){
    if(kaigoHealthCareOfTheAgedOralSwitchRadioItem1==null){

      kaigoHealthCareOfTheAgedOralSwitchRadioItem1 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedOralSwitchRadioItem1.setText("なし");

      kaigoHealthCareOfTheAgedOralSwitchRadioItem1.setGroup(getKaigoHealthCareOfTheAgedOralSwitchRadio());

      kaigoHealthCareOfTheAgedOralSwitchRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedOralSwitchRadioItem1();
    }
    return kaigoHealthCareOfTheAgedOralSwitchRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedOralSwitchRadioItem2(){
    if(kaigoHealthCareOfTheAgedOralSwitchRadioItem2==null){

      kaigoHealthCareOfTheAgedOralSwitchRadioItem2 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedOralSwitchRadioItem2.setText("あり");

      kaigoHealthCareOfTheAgedOralSwitchRadioItem2.setGroup(getKaigoHealthCareOfTheAgedOralSwitchRadio());

      kaigoHealthCareOfTheAgedOralSwitchRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedOralSwitchRadioItem2();
    }
    return kaigoHealthCareOfTheAgedOralSwitchRadioItem2;

  }

  /**
   * 経口維持加算を取得します。
   * @return 経口維持加算
   */
  public ACClearableRadioButtonGroup getOralMaintenanceAddRadio(){
    if(oralMaintenanceAddRadio==null){

      oralMaintenanceAddRadio = new ACClearableRadioButtonGroup();

      getOralMaintenanceAddRadioContainer().setText("経口維持加算");

      oralMaintenanceAddRadio.setBindPath("1520126");

      oralMaintenanceAddRadio.setUseClearButton(false);

      oralMaintenanceAddRadio.setModel(getOralMaintenanceAddRadioModel());

      addOralMaintenanceAddRadio();
    }
    return oralMaintenanceAddRadio;

  }

  /**
   * 経口維持加算コンテナを取得します。
   * @return 経口維持加算コンテナ
   */
  protected ACLabelContainer getOralMaintenanceAddRadioContainer(){
    if(oralMaintenanceAddRadioContainer==null){
      oralMaintenanceAddRadioContainer = new ACLabelContainer();
      oralMaintenanceAddRadioContainer.setFollowChildEnabled(true);
      oralMaintenanceAddRadioContainer.setVAlignment(VRLayout.CENTER);
      oralMaintenanceAddRadioContainer.add(getOralMaintenanceAddRadio(), null);
    }
    return oralMaintenanceAddRadioContainer;
  }

  /**
   * 経口維持加算モデルを取得します。
   * @return 経口維持加算モデル
   */
  protected ACListModelAdapter getOralMaintenanceAddRadioModel(){
    if(oralMaintenanceAddRadioModel==null){
      oralMaintenanceAddRadioModel = new ACListModelAdapter();
      addOralMaintenanceAddRadioModel();
    }
    return oralMaintenanceAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getOralMaintenanceAddRadioItem1(){
    if(oralMaintenanceAddRadioItem1==null){

      oralMaintenanceAddRadioItem1 = new ACRadioButtonItem();

      oralMaintenanceAddRadioItem1.setText("なし");

      oralMaintenanceAddRadioItem1.setGroup(getOralMaintenanceAddRadio());

      oralMaintenanceAddRadioItem1.setConstraints(VRLayout.FLOW);

      addOralMaintenanceAddRadioItem1();
    }
    return oralMaintenanceAddRadioItem1;

  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getOralMaintenanceAddRadioItem2(){
    if(oralMaintenanceAddRadioItem2==null){

      oralMaintenanceAddRadioItem2 = new ACRadioButtonItem();

      oralMaintenanceAddRadioItem2.setText("I型");

      oralMaintenanceAddRadioItem2.setGroup(getOralMaintenanceAddRadio());

      oralMaintenanceAddRadioItem2.setConstraints(VRLayout.FLOW);

      addOralMaintenanceAddRadioItem2();
    }
    return oralMaintenanceAddRadioItem2;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getOralMaintenanceAddRadioItem3(){
    if(oralMaintenanceAddRadioItem3==null){

      oralMaintenanceAddRadioItem3 = new ACRadioButtonItem();

      oralMaintenanceAddRadioItem3.setText("II型");

      oralMaintenanceAddRadioItem3.setGroup(getOralMaintenanceAddRadio());

      oralMaintenanceAddRadioItem3.setConstraints(VRLayout.FLOW);

      addOralMaintenanceAddRadioItem3();
    }
    return oralMaintenanceAddRadioItem3;

  }

  /**
   * 療養食加算を取得します。
   * @return 療養食加算
   */
  public ACClearableRadioButtonGroup getKaigoHealthCareOfTheAgedRecuperateDinnerRadio(){
    if(kaigoHealthCareOfTheAgedRecuperateDinnerRadio==null){

      kaigoHealthCareOfTheAgedRecuperateDinnerRadio = new ACClearableRadioButtonGroup();

      getKaigoHealthCareOfTheAgedRecuperateDinnerRadioContainer().setText("療養食加算");

      kaigoHealthCareOfTheAgedRecuperateDinnerRadio.setBindPath("1520113");

      kaigoHealthCareOfTheAgedRecuperateDinnerRadio.setUseClearButton(false);

      kaigoHealthCareOfTheAgedRecuperateDinnerRadio.setModel(getKaigoHealthCareOfTheAgedRecuperateDinnerRadioModel());

      addKaigoHealthCareOfTheAgedRecuperateDinnerRadio();
    }
    return kaigoHealthCareOfTheAgedRecuperateDinnerRadio;

  }

  /**
   * 療養食加算コンテナを取得します。
   * @return 療養食加算コンテナ
   */
  protected ACLabelContainer getKaigoHealthCareOfTheAgedRecuperateDinnerRadioContainer(){
    if(kaigoHealthCareOfTheAgedRecuperateDinnerRadioContainer==null){
      kaigoHealthCareOfTheAgedRecuperateDinnerRadioContainer = new ACLabelContainer();
      kaigoHealthCareOfTheAgedRecuperateDinnerRadioContainer.setFollowChildEnabled(true);
      kaigoHealthCareOfTheAgedRecuperateDinnerRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoHealthCareOfTheAgedRecuperateDinnerRadioContainer.add(getKaigoHealthCareOfTheAgedRecuperateDinnerRadio(), null);
    }
    return kaigoHealthCareOfTheAgedRecuperateDinnerRadioContainer;
  }

  /**
   * 療養食加算モデルを取得します。
   * @return 療養食加算モデル
   */
  protected ACListModelAdapter getKaigoHealthCareOfTheAgedRecuperateDinnerRadioModel(){
    if(kaigoHealthCareOfTheAgedRecuperateDinnerRadioModel==null){
      kaigoHealthCareOfTheAgedRecuperateDinnerRadioModel = new ACListModelAdapter();
      addKaigoHealthCareOfTheAgedRecuperateDinnerRadioModel();
    }
    return kaigoHealthCareOfTheAgedRecuperateDinnerRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedRecuperateDinnerRadioItem1(){
    if(kaigoHealthCareOfTheAgedRecuperateDinnerRadioItem1==null){

      kaigoHealthCareOfTheAgedRecuperateDinnerRadioItem1 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedRecuperateDinnerRadioItem1.setText("なし");

      kaigoHealthCareOfTheAgedRecuperateDinnerRadioItem1.setGroup(getKaigoHealthCareOfTheAgedRecuperateDinnerRadio());

      kaigoHealthCareOfTheAgedRecuperateDinnerRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedRecuperateDinnerRadioItem1();
    }
    return kaigoHealthCareOfTheAgedRecuperateDinnerRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedRecuperateDinnerRadioItem2(){
    if(kaigoHealthCareOfTheAgedRecuperateDinnerRadioItem2==null){

      kaigoHealthCareOfTheAgedRecuperateDinnerRadioItem2 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedRecuperateDinnerRadioItem2.setText("あり");

      kaigoHealthCareOfTheAgedRecuperateDinnerRadioItem2.setGroup(getKaigoHealthCareOfTheAgedRecuperateDinnerRadio());

      kaigoHealthCareOfTheAgedRecuperateDinnerRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedRecuperateDinnerRadioItem2();
    }
    return kaigoHealthCareOfTheAgedRecuperateDinnerRadioItem2;

  }

  /**
   * 退所関連加算を取得します。
   * @return 退所関連加算
   */
  public ACLabelContainer getKaigoHealthCareOfTheAgedHijoAddition(){
    if(kaigoHealthCareOfTheAgedHijoAddition==null){

      kaigoHealthCareOfTheAgedHijoAddition = new ACLabelContainer();

      kaigoHealthCareOfTheAgedHijoAddition.setText("退所関連加算");

      addKaigoHealthCareOfTheAgedHijoAddition();
    }
    return kaigoHealthCareOfTheAgedHijoAddition;

  }

  /**
   * 退所(院)前後訪問指導加算を取得します。
   * @return 退所(院)前後訪問指導加算
   */
  public ACIntegerCheckBox getLeavingHospitalPreConsultationAddition(){
    if(leavingHospitalPreConsultationAddition==null){

      leavingHospitalPreConsultationAddition = new ACIntegerCheckBox();

      leavingHospitalPreConsultationAddition.setText("退所前後訪問指導加算");

      leavingHospitalPreConsultationAddition.setBindPath("3020104");

      leavingHospitalPreConsultationAddition.setSelectValue(2);

      leavingHospitalPreConsultationAddition.setUnSelectValue(1);

      addLeavingHospitalPreConsultationAddition();
    }
    return leavingHospitalPreConsultationAddition;

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
   * 特別療養費を取得します。
   * @return 特別療養費
   */
  public ACMapBindButton getSpecialMedicalExpense(){
    if(specialMedicalExpense==null){

      specialMedicalExpense = new ACMapBindButton();

      specialMedicalExpense.setText("特別療養費");

      specialMedicalExpense.setToolTipText("特別療養費を設定します。");

      addSpecialMedicalExpense();
    }
    return specialMedicalExpense;

  }

  /**
   * ラベルを取得します。
   * @return ラベル
   */
  public ACLabel getSpecialMedicalExpenseLabel(){
    if(specialMedicalExpenseLabel==null){

      specialMedicalExpenseLabel = new ACLabel();

      specialMedicalExpenseLabel.setText("設定なし");

      specialMedicalExpenseLabel.setOpaque(true);
      specialMedicalExpenseLabel.setBackground(new Color(255,255,172));

      addSpecialMedicalExpenseLabel();
    }
    return specialMedicalExpenseLabel;

  }

  /**
   * タブ3を取得します。
   * @return タブ3
   */
  public ACPanel getTab3(){
    if(tab3==null){

      tab3 = new ACPanel();

      tab3.setHgap(0);

      addTab3();
    }
    return tab3;

  }

  /**
   * 職員減算を取得します。
   * @return 職員減算
   */
  public ACClearableRadioButtonGroup getKaigoHealthCareOfTheAgedStaffSubtraction(){
    if(kaigoHealthCareOfTheAgedStaffSubtraction==null){

      kaigoHealthCareOfTheAgedStaffSubtraction = new ACClearableRadioButtonGroup();

      getKaigoHealthCareOfTheAgedStaffSubtractionContainer().setText("人員減算");

      kaigoHealthCareOfTheAgedStaffSubtraction.setBindPath("1520119");

      kaigoHealthCareOfTheAgedStaffSubtraction.setUseClearButton(false);

      kaigoHealthCareOfTheAgedStaffSubtraction.setModel(getKaigoHealthCareOfTheAgedStaffSubtractionModel());

      addKaigoHealthCareOfTheAgedStaffSubtraction();
    }
    return kaigoHealthCareOfTheAgedStaffSubtraction;

  }

  /**
   * 職員減算コンテナを取得します。
   * @return 職員減算コンテナ
   */
  protected ACLabelContainer getKaigoHealthCareOfTheAgedStaffSubtractionContainer(){
    if(kaigoHealthCareOfTheAgedStaffSubtractionContainer==null){
      kaigoHealthCareOfTheAgedStaffSubtractionContainer = new ACLabelContainer();
      kaigoHealthCareOfTheAgedStaffSubtractionContainer.setFollowChildEnabled(true);
      kaigoHealthCareOfTheAgedStaffSubtractionContainer.setVAlignment(VRLayout.CENTER);
      kaigoHealthCareOfTheAgedStaffSubtractionContainer.add(getKaigoHealthCareOfTheAgedStaffSubtraction(), null);
    }
    return kaigoHealthCareOfTheAgedStaffSubtractionContainer;
  }

  /**
   * 職員減算モデルを取得します。
   * @return 職員減算モデル
   */
  protected ACListModelAdapter getKaigoHealthCareOfTheAgedStaffSubtractionModel(){
    if(kaigoHealthCareOfTheAgedStaffSubtractionModel==null){
      kaigoHealthCareOfTheAgedStaffSubtractionModel = new ACListModelAdapter();
      addKaigoHealthCareOfTheAgedStaffSubtractionModel();
    }
    return kaigoHealthCareOfTheAgedStaffSubtractionModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedStaffSubtractionCapacityNot(){
    if(kaigoHealthCareOfTheAgedStaffSubtractionCapacityNot==null){

      kaigoHealthCareOfTheAgedStaffSubtractionCapacityNot = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedStaffSubtractionCapacityNot.setText("なし");

      kaigoHealthCareOfTheAgedStaffSubtractionCapacityNot.setGroup(getKaigoHealthCareOfTheAgedStaffSubtraction());

      kaigoHealthCareOfTheAgedStaffSubtractionCapacityNot.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedStaffSubtractionCapacityNot();
    }
    return kaigoHealthCareOfTheAgedStaffSubtractionCapacityNot;

  }

  /**
   * 定員超過を取得します。
   * @return 定員超過
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedStaffSubtractionCapacityExcess(){
    if(kaigoHealthCareOfTheAgedStaffSubtractionCapacityExcess==null){

      kaigoHealthCareOfTheAgedStaffSubtractionCapacityExcess = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedStaffSubtractionCapacityExcess.setText("定員超過");

      kaigoHealthCareOfTheAgedStaffSubtractionCapacityExcess.setGroup(getKaigoHealthCareOfTheAgedStaffSubtraction());

      kaigoHealthCareOfTheAgedStaffSubtractionCapacityExcess.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoHealthCareOfTheAgedStaffSubtractionCapacityExcess();
    }
    return kaigoHealthCareOfTheAgedStaffSubtractionCapacityExcess;

  }

  /**
   * 看護・介護職員又は医師、PT・OT、介護支援専門員の不足を取得します。
   * @return 看護・介護職員又は医師、PT・OT、介護支援専門員の不足
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedStaffSubtractionPersonLack(){
    if(kaigoHealthCareOfTheAgedStaffSubtractionPersonLack==null){

      kaigoHealthCareOfTheAgedStaffSubtractionPersonLack = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedStaffSubtractionPersonLack.setText("<html>看護・介護職員又は医師、PT・OT、<br>介護支援専門員の不足<html>");

      kaigoHealthCareOfTheAgedStaffSubtractionPersonLack.setGroup(getKaigoHealthCareOfTheAgedStaffSubtraction());

      kaigoHealthCareOfTheAgedStaffSubtractionPersonLack.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedStaffSubtractionPersonLack();
    }
    return kaigoHealthCareOfTheAgedStaffSubtractionPersonLack;

  }

  /**
   * 食事コンテナを取得します。
   * @return 食事コンテナ
   */
  public ACBackLabelContainer getKaigoHealthCareOfTheAgedDinnerContainer(){
    if(kaigoHealthCareOfTheAgedDinnerContainer==null){

      kaigoHealthCareOfTheAgedDinnerContainer = new ACBackLabelContainer();

      addKaigoHealthCareOfTheAgedDinnerContainer();
    }
    return kaigoHealthCareOfTheAgedDinnerContainer;

  }

  /**
   * 食事提供を取得します。
   * @return 食事提供
   */
  public ACComboBox getKaigoHealthCareOfTheAgedDinnerOffer(){
    if(kaigoHealthCareOfTheAgedDinnerOffer==null){

      kaigoHealthCareOfTheAgedDinnerOffer = new ACComboBox();

      getKaigoHealthCareOfTheAgedDinnerOfferContainer().setText("食事提供");

      kaigoHealthCareOfTheAgedDinnerOffer.setBindPath("1520120");

      kaigoHealthCareOfTheAgedDinnerOffer.setEditable(false);

      kaigoHealthCareOfTheAgedDinnerOffer.setModelBindPath("1520120");

      kaigoHealthCareOfTheAgedDinnerOffer.setRenderBindPath("CONTENT");

      kaigoHealthCareOfTheAgedDinnerOffer.setModel(getKaigoHealthCareOfTheAgedDinnerOfferModel());

      addKaigoHealthCareOfTheAgedDinnerOffer();
    }
    return kaigoHealthCareOfTheAgedDinnerOffer;

  }

  /**
   * 食事提供コンテナを取得します。
   * @return 食事提供コンテナ
   */
  protected ACLabelContainer getKaigoHealthCareOfTheAgedDinnerOfferContainer(){
    if(kaigoHealthCareOfTheAgedDinnerOfferContainer==null){
      kaigoHealthCareOfTheAgedDinnerOfferContainer = new ACLabelContainer();
      kaigoHealthCareOfTheAgedDinnerOfferContainer.setFollowChildEnabled(true);
      kaigoHealthCareOfTheAgedDinnerOfferContainer.setVAlignment(VRLayout.CENTER);
      kaigoHealthCareOfTheAgedDinnerOfferContainer.add(getKaigoHealthCareOfTheAgedDinnerOffer(), null);
    }
    return kaigoHealthCareOfTheAgedDinnerOfferContainer;
  }

  /**
   * 食事提供モデルを取得します。
   * @return 食事提供モデル
   */
  protected ACComboBoxModelAdapter getKaigoHealthCareOfTheAgedDinnerOfferModel(){
    if(kaigoHealthCareOfTheAgedDinnerOfferModel==null){
      kaigoHealthCareOfTheAgedDinnerOfferModel = new ACComboBoxModelAdapter();
      addKaigoHealthCareOfTheAgedDinnerOfferModel();
    }
    return kaigoHealthCareOfTheAgedDinnerOfferModel;
  }

  /**
   * 食事費用を取得します。
   * @return 食事費用
   */
  public ACTextField getKaigoHealthCareOfTheAgedDinnerCost(){
    if(kaigoHealthCareOfTheAgedDinnerCost==null){

      kaigoHealthCareOfTheAgedDinnerCost = new ACTextField();

      getKaigoHealthCareOfTheAgedDinnerCostContainer().setText("食事費用");

      kaigoHealthCareOfTheAgedDinnerCost.setBindPath("1520122");

      kaigoHealthCareOfTheAgedDinnerCost.setColumns(4);

      kaigoHealthCareOfTheAgedDinnerCost.setCharType(VRCharType.ONLY_DIGIT);

      kaigoHealthCareOfTheAgedDinnerCost.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoHealthCareOfTheAgedDinnerCost.setIMEMode(InputSubset.LATIN);

      kaigoHealthCareOfTheAgedDinnerCost.setMaxLength(5);

      addKaigoHealthCareOfTheAgedDinnerCost();
    }
    return kaigoHealthCareOfTheAgedDinnerCost;

  }

  /**
   * 食事費用コンテナを取得します。
   * @return 食事費用コンテナ
   */
  protected ACLabelContainer getKaigoHealthCareOfTheAgedDinnerCostContainer(){
    if(kaigoHealthCareOfTheAgedDinnerCostContainer==null){
      kaigoHealthCareOfTheAgedDinnerCostContainer = new ACLabelContainer();
      kaigoHealthCareOfTheAgedDinnerCostContainer.setFollowChildEnabled(true);
      kaigoHealthCareOfTheAgedDinnerCostContainer.setVAlignment(VRLayout.CENTER);
      kaigoHealthCareOfTheAgedDinnerCostContainer.add(getKaigoHealthCareOfTheAgedDinnerCost(), null);
    }
    return kaigoHealthCareOfTheAgedDinnerCostContainer;
  }

  /**
   * ユニットケアの整備を取得します。
   * @return ユニットケアの整備
   */
  public ACClearableRadioButtonGroup getUnitCareMaintenanceRadio(){
    if(unitCareMaintenanceRadio==null){

      unitCareMaintenanceRadio = new ACClearableRadioButtonGroup();

      getUnitCareMaintenanceRadioContainer().setText("ユニットケアの整備");

      unitCareMaintenanceRadio.setBindPath("1520127");

      unitCareMaintenanceRadio.setUseClearButton(false);

      unitCareMaintenanceRadio.setModel(getUnitCareMaintenanceRadioModel());

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
   * 療養体制維持特別加算を取得します。
   * @return 療養体制維持特別加算
   */
  public ACClearableRadioButtonGroup getRecuperationRadio(){
    if(recuperationRadio==null){

      recuperationRadio = new ACClearableRadioButtonGroup();

      getRecuperationRadioContainer().setText("療養体制維持特別加算");

      recuperationRadio.setBindPath("1520134");

      recuperationRadio.setUseClearButton(false);

      recuperationRadio.setModel(getRecuperationRadioModel());

      addRecuperationRadio();
    }
    return recuperationRadio;

  }

  /**
   * 療養体制維持特別加算コンテナを取得します。
   * @return 療養体制維持特別加算コンテナ
   */
  protected ACLabelContainer getRecuperationRadioContainer(){
    if(recuperationRadioContainer==null){
      recuperationRadioContainer = new ACLabelContainer();
      recuperationRadioContainer.setFollowChildEnabled(true);
      recuperationRadioContainer.setVAlignment(VRLayout.CENTER);
      recuperationRadioContainer.add(getRecuperationRadio(), null);
    }
    return recuperationRadioContainer;
  }

  /**
   * 療養体制維持特別加算モデルを取得します。
   * @return 療養体制維持特別加算モデル
   */
  protected ACListModelAdapter getRecuperationRadioModel(){
    if(recuperationRadioModel==null){
      recuperationRadioModel = new ACListModelAdapter();
      addRecuperationRadioModel();
    }
    return recuperationRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getRecuperationRadioItem1(){
    if(recuperationRadioItem1==null){

      recuperationRadioItem1 = new ACRadioButtonItem();

      recuperationRadioItem1.setText("なし");

      recuperationRadioItem1.setGroup(getRecuperationRadio());

      recuperationRadioItem1.setConstraints(VRLayout.FLOW);

      addRecuperationRadioItem1();
    }
    return recuperationRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getRecuperationRadioItem2(){
    if(recuperationRadioItem2==null){

      recuperationRadioItem2 = new ACRadioButtonItem();

      recuperationRadioItem2.setText("あり");

      recuperationRadioItem2.setGroup(getRecuperationRadio());

      recuperationRadioItem2.setConstraints(VRLayout.FLOW);

      addRecuperationRadioItem2();
    }
    return recuperationRadioItem2;

  }

  /**
   * 認知症ケア加算を取得します。
   * @return 認知症ケア加算
   */
  public ACClearableRadioButtonGroup getIntentionCommunicationDifficultyAddRadio(){
    if(intentionCommunicationDifficultyAddRadio==null){

      intentionCommunicationDifficultyAddRadio = new ACClearableRadioButtonGroup();

      getIntentionCommunicationDifficultyAddRadioContainer().setText("認知症ケア加算");

      intentionCommunicationDifficultyAddRadio.setBindPath("1520128");

      intentionCommunicationDifficultyAddRadio.setUseClearButton(false);

      intentionCommunicationDifficultyAddRadio.setModel(getIntentionCommunicationDifficultyAddRadioModel());

      addIntentionCommunicationDifficultyAddRadio();
    }
    return intentionCommunicationDifficultyAddRadio;

  }

  /**
   * 認知症ケア加算コンテナを取得します。
   * @return 認知症ケア加算コンテナ
   */
  protected ACLabelContainer getIntentionCommunicationDifficultyAddRadioContainer(){
    if(intentionCommunicationDifficultyAddRadioContainer==null){
      intentionCommunicationDifficultyAddRadioContainer = new ACLabelContainer();
      intentionCommunicationDifficultyAddRadioContainer.setFollowChildEnabled(true);
      intentionCommunicationDifficultyAddRadioContainer.setVAlignment(VRLayout.CENTER);
      intentionCommunicationDifficultyAddRadioContainer.add(getIntentionCommunicationDifficultyAddRadio(), null);
    }
    return intentionCommunicationDifficultyAddRadioContainer;
  }

  /**
   * 認知症ケア加算モデルを取得します。
   * @return 認知症ケア加算モデル
   */
  protected ACListModelAdapter getIntentionCommunicationDifficultyAddRadioModel(){
    if(intentionCommunicationDifficultyAddRadioModel==null){
      intentionCommunicationDifficultyAddRadioModel = new ACListModelAdapter();
      addIntentionCommunicationDifficultyAddRadioModel();
    }
    return intentionCommunicationDifficultyAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getIntentionCommunicationDifficultyAddRadioItem1(){
    if(intentionCommunicationDifficultyAddRadioItem1==null){

      intentionCommunicationDifficultyAddRadioItem1 = new ACRadioButtonItem();

      intentionCommunicationDifficultyAddRadioItem1.setText("なし");

      intentionCommunicationDifficultyAddRadioItem1.setGroup(getIntentionCommunicationDifficultyAddRadio());

      intentionCommunicationDifficultyAddRadioItem1.setConstraints(VRLayout.FLOW);

      addIntentionCommunicationDifficultyAddRadioItem1();
    }
    return intentionCommunicationDifficultyAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getIntentionCommunicationDifficultyAddRadioItem2(){
    if(intentionCommunicationDifficultyAddRadioItem2==null){

      intentionCommunicationDifficultyAddRadioItem2 = new ACRadioButtonItem();

      intentionCommunicationDifficultyAddRadioItem2.setText("あり");

      intentionCommunicationDifficultyAddRadioItem2.setGroup(getIntentionCommunicationDifficultyAddRadio());

      intentionCommunicationDifficultyAddRadioItem2.setConstraints(VRLayout.FLOW);

      addIntentionCommunicationDifficultyAddRadioItem2();
    }
    return intentionCommunicationDifficultyAddRadioItem2;

  }

  /**
   * 試行的退所サービス費を取得します。
   * @return 試行的退所サービス費
   */
  public ACClearableRadioButtonGroup getTrialHijoRadio(){
    if(trialHijoRadio==null){

      trialHijoRadio = new ACClearableRadioButtonGroup();

      getTrialHijoRadioContainer().setText("試行的退所サービス費");

      trialHijoRadio.setBindPath("1520129");

      trialHijoRadio.setUseClearButton(false);

      trialHijoRadio.setModel(getTrialHijoRadioModel());

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
   * 身体拘束廃止未実施減算を取得します。
   * @return 身体拘束廃止未実施減算
   */
  public ACClearableRadioButtonGroup getBodyRestraintAbolitionRadio(){
    if(bodyRestraintAbolitionRadio==null){

      bodyRestraintAbolitionRadio = new ACClearableRadioButtonGroup();

      getBodyRestraintAbolitionRadioContainer().setText("身体拘束廃止未実施減算");

      bodyRestraintAbolitionRadio.setBindPath("1520130");

      bodyRestraintAbolitionRadio.setUseClearButton(false);

      bodyRestraintAbolitionRadio.setModel(getBodyRestraintAbolitionRadioModel());

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
  public ACClearableRadioButtonGroup getStayReturnSupportAddRadio(){
    if(stayReturnSupportAddRadio==null){

      stayReturnSupportAddRadio = new ACClearableRadioButtonGroup();

      getStayReturnSupportAddRadioContainer().setText("在宅復帰支援機能加算");

      stayReturnSupportAddRadio.setBindPath("1520131");

      stayReturnSupportAddRadio.setUseClearButton(false);

      stayReturnSupportAddRadio.setModel(getStayReturnSupportAddRadioModel());

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
   * ターミナルケア加算を取得します。
   * @return ターミナルケア加算
   */
  public ACClearableRadioButtonGroup getTerminalRadio(){
    if(terminalRadio==null){

      terminalRadio = new ACClearableRadioButtonGroup();

      getTerminalRadioContainer().setText("ターミナルケア加算");

      terminalRadio.setBindPath("1520133");

      terminalRadio.setUseClearButton(false);

      terminalRadio.setModel(getTerminalRadioModel());

      addTerminalRadio();
    }
    return terminalRadio;

  }

  /**
   * ターミナルケア加算コンテナを取得します。
   * @return ターミナルケア加算コンテナ
   */
  protected ACLabelContainer getTerminalRadioContainer(){
    if(terminalRadioContainer==null){
      terminalRadioContainer = new ACLabelContainer();
      terminalRadioContainer.setFollowChildEnabled(true);
      terminalRadioContainer.setVAlignment(VRLayout.CENTER);
      terminalRadioContainer.add(getTerminalRadio(), null);
    }
    return terminalRadioContainer;
  }

  /**
   * ターミナルケア加算モデルを取得します。
   * @return ターミナルケア加算モデル
   */
  protected ACListModelAdapter getTerminalRadioModel(){
    if(terminalRadioModel==null){
      terminalRadioModel = new ACListModelAdapter();
      addTerminalRadioModel();
    }
    return terminalRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTerminalRadioItem1(){
    if(terminalRadioItem1==null){

      terminalRadioItem1 = new ACRadioButtonItem();

      terminalRadioItem1.setText("なし");

      terminalRadioItem1.setGroup(getTerminalRadio());

      terminalRadioItem1.setConstraints(VRLayout.FLOW);

      addTerminalRadioItem1();
    }
    return terminalRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getTerminalRadioItem2(){
    if(terminalRadioItem2==null){

      terminalRadioItem2 = new ACRadioButtonItem();

      terminalRadioItem2.setText("あり");

      terminalRadioItem2.setGroup(getTerminalRadio());

      terminalRadioItem2.setConstraints(VRLayout.FLOW);

      addTerminalRadioItem2();
    }
    return terminalRadioItem2;

  }

  /**
   * 算定区分を取得します。
   * @return 算定区分
   */
  public ACClearableRadioButtonGroup getKaigoHealthCareOfTheAgedCalculationDivisionRadio(){
    if(kaigoHealthCareOfTheAgedCalculationDivisionRadio==null){

      kaigoHealthCareOfTheAgedCalculationDivisionRadio = new ACClearableRadioButtonGroup();

      getKaigoHealthCareOfTheAgedCalculationDivisionRadioContainer().setText("算定区分");

      kaigoHealthCareOfTheAgedCalculationDivisionRadio.setBindPath("9");

      kaigoHealthCareOfTheAgedCalculationDivisionRadio.setUseClearButton(false);

      kaigoHealthCareOfTheAgedCalculationDivisionRadio.setModel(getKaigoHealthCareOfTheAgedCalculationDivisionRadioModel());

      addKaigoHealthCareOfTheAgedCalculationDivisionRadio();
    }
    return kaigoHealthCareOfTheAgedCalculationDivisionRadio;

  }

  /**
   * 算定区分コンテナを取得します。
   * @return 算定区分コンテナ
   */
  protected ACLabelContainer getKaigoHealthCareOfTheAgedCalculationDivisionRadioContainer(){
    if(kaigoHealthCareOfTheAgedCalculationDivisionRadioContainer==null){
      kaigoHealthCareOfTheAgedCalculationDivisionRadioContainer = new ACLabelContainer();
      kaigoHealthCareOfTheAgedCalculationDivisionRadioContainer.setFollowChildEnabled(true);
      kaigoHealthCareOfTheAgedCalculationDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoHealthCareOfTheAgedCalculationDivisionRadioContainer.add(getKaigoHealthCareOfTheAgedCalculationDivisionRadio(), null);
    }
    return kaigoHealthCareOfTheAgedCalculationDivisionRadioContainer;
  }

  /**
   * 算定区分モデルを取得します。
   * @return 算定区分モデル
   */
  protected ACListModelAdapter getKaigoHealthCareOfTheAgedCalculationDivisionRadioModel(){
    if(kaigoHealthCareOfTheAgedCalculationDivisionRadioModel==null){
      kaigoHealthCareOfTheAgedCalculationDivisionRadioModel = new ACListModelAdapter();
      addKaigoHealthCareOfTheAgedCalculationDivisionRadioModel();
    }
    return kaigoHealthCareOfTheAgedCalculationDivisionRadioModel;
  }

  /**
   * 通常を取得します。
   * @return 通常
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedCalculationDivisionRadioItem1(){
    if(kaigoHealthCareOfTheAgedCalculationDivisionRadioItem1==null){

      kaigoHealthCareOfTheAgedCalculationDivisionRadioItem1 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedCalculationDivisionRadioItem1.setText("通常");

      kaigoHealthCareOfTheAgedCalculationDivisionRadioItem1.setGroup(getKaigoHealthCareOfTheAgedCalculationDivisionRadio());

      kaigoHealthCareOfTheAgedCalculationDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedCalculationDivisionRadioItem1();
    }
    return kaigoHealthCareOfTheAgedCalculationDivisionRadioItem1;

  }

  /**
   * 加算のみを取得します。
   * @return 加算のみ
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedCalculationDivisionRadioItem2(){
    if(kaigoHealthCareOfTheAgedCalculationDivisionRadioItem2==null){

      kaigoHealthCareOfTheAgedCalculationDivisionRadioItem2 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedCalculationDivisionRadioItem2.setText("加算のみ");

      kaigoHealthCareOfTheAgedCalculationDivisionRadioItem2.setGroup(getKaigoHealthCareOfTheAgedCalculationDivisionRadio());

      kaigoHealthCareOfTheAgedCalculationDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedCalculationDivisionRadioItem2();
    }
    return kaigoHealthCareOfTheAgedCalculationDivisionRadioItem2;

  }

  /**
   * コンストラクタです。
   */
  public QS001119_H2005Design() {

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

    tab1.add(getKaigoHealthCareOfTheAgedDivisionContainar(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getKaigoHealthCareOfTheAgedHospitalRoomContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getKaigoHealthCareOfTheAgedNightShiftSubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getRehabiliManagementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortConcentrationRehabiliContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getKaigoHealthCareOfTheAgedDefaultRadioContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 施設等の区分コンテナに内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedDivisionContainar(){

    kaigoHealthCareOfTheAgedDivisionContainar.add(getKaigoHealthCareOfTheAgedDivisionBackLavelContainar1(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoHealthCareOfTheAgedDivisionContainar.add(getKaigoHealthCareOfTheAgedDivisionBackLavelContainar2(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 施設等の区分ラベルコンテナに内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedDivisionBackLavelContainar1(){

    kaigoHealthCareOfTheAgedDivisionBackLavelContainar1.add(getKaigoHealthCareOfTheAgedDivisionRadio(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 施設等の区分に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedDivisionRadio(){

  }

  /**
   * 施設等の区分モデルに内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedDivisionRadioModel(){

    getKaigoHealthCareOfTheAgedDivisionRadioItem1().setButtonIndex(1);

    getKaigoHealthCareOfTheAgedDivisionRadioModel().add(getKaigoHealthCareOfTheAgedDivisionRadioItem1());

    getKaigoHealthCareOfTheAgedDivisionRadioItem2().setButtonIndex(3);

    getKaigoHealthCareOfTheAgedDivisionRadioModel().add(getKaigoHealthCareOfTheAgedDivisionRadioItem2());

  }

  /**
   * 介護保健施設に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedDivisionRadioItem1(){

  }

  /**
   * ユニット型介護保健施設に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedDivisionRadioItem2(){

  }

  /**
   * 背面ラベルコンテナ（体制）に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedDivisionBackLavelContainar2(){

    kaigoHealthCareOfTheAgedDivisionBackLavelContainar2.add(getKaigoHealthCareOfTheAgedDivision(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 体制に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedDivision(){

  }

  /**
   * 体制モデルに内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedDivisionModel(){

    getKaigoHealthCareOfTheAgedDivisionType1().setButtonIndex(1);

    getKaigoHealthCareOfTheAgedDivisionModel().add(getKaigoHealthCareOfTheAgedDivisionType1());

    getKaigoHealthCareOfTheAgedDivisionType2().setButtonIndex(2);

    getKaigoHealthCareOfTheAgedDivisionModel().add(getKaigoHealthCareOfTheAgedDivisionType2());

    getKaigoHealthCareOfTheAgedDivisionType3().setButtonIndex(3);

    getKaigoHealthCareOfTheAgedDivisionModel().add(getKaigoHealthCareOfTheAgedDivisionType3());

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedDivisionType1(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedDivisionType2(){

  }

  /**
   * III型に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedDivisionType3(){

  }

  /**
   * 病室区分コンテナに内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedHospitalRoomContena(){

    kaigoHealthCareOfTheAgedHospitalRoomContena.add(getKaigoHealthCareOfTheAgedHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoHealthCareOfTheAgedHospitalRoomContena.add(getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 病室区分（介護保健施設）に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedHospitalRoomRadio(){

  }

  /**
   * 病室区分（介護保健施設）モデルに内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedHospitalRoomRadioModel(){

    getKaigoHealthCareOfTheAgedHospitalRoomRadioItem1().setButtonIndex(1);

    getKaigoHealthCareOfTheAgedHospitalRoomRadioModel().add(getKaigoHealthCareOfTheAgedHospitalRoomRadioItem1());

    getKaigoHealthCareOfTheAgedHospitalRoomRadioItem2().setButtonIndex(2);

    getKaigoHealthCareOfTheAgedHospitalRoomRadioModel().add(getKaigoHealthCareOfTheAgedHospitalRoomRadioItem2());

  }

  /**
   * 従来型個室に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedHospitalRoomRadioItem1(){

  }

  /**
   * 多床室に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedHospitalRoomRadioItem2(){

  }

  /**
   * 病室区分（ユニット型）に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedUnitHospitalRoomRadio(){

  }

  /**
   * 病室区分（ユニット型）モデルに内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedUnitHospitalRoomRadioModel(){

    getKaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem1().setButtonIndex(1);

    getKaigoHealthCareOfTheAgedUnitHospitalRoomRadioModel().add(getKaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem1());

    getKaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem2().setButtonIndex(2);

    getKaigoHealthCareOfTheAgedUnitHospitalRoomRadioModel().add(getKaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem2());

  }

  /**
   * ユニット型個室に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem1(){

  }

  /**
   * ユニット型準個室に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem2(){

  }

  /**
   * 夜間勤務条件基準に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedNightShiftSubtractionRadio(){

  }

  /**
   * 夜間勤務条件基準モデルに内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedNightShiftSubtractionRadioModel(){

    getKaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem1().setButtonIndex(1);

    getKaigoHealthCareOfTheAgedNightShiftSubtractionRadioModel().add(getKaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem1());

    getKaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem2().setButtonIndex(2);

    getKaigoHealthCareOfTheAgedNightShiftSubtractionRadioModel().add(getKaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem2());

  }

  /**
   * 基準型に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem1(){

  }

  /**
   * 減算型に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem2(){

  }

  /**
   * リハビリ・マネジメント加算に内部項目を追加します。
   */
  protected void addRehabiliManagementAddRadio(){

  }

  /**
   * リハビリ・マネジメント加算モデルに内部項目を追加します。
   */
  protected void addRehabiliManagementAddRadioModel(){

    getRehabiliManagementAddRadioItem1().setButtonIndex(1);

    getRehabiliManagementAddRadioModel().add(getRehabiliManagementAddRadioItem1());

    getRehabiliManagementAddRadioItem2().setButtonIndex(2);

    getRehabiliManagementAddRadioModel().add(getRehabiliManagementAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addRehabiliManagementAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addRehabiliManagementAddRadioItem2(){

  }

  /**
   * 短期集中リハビリ加算コンテナに内部項目を追加します。
   */
  protected void addShortConcentrationRehabiliContainer(){

    shortConcentrationRehabiliContainer.add(getShortConcentrationRehabiliAddRadio(), VRLayout.FLOW_RETURN);

    shortConcentrationRehabiliContainer.add(getShortConcentrationRehabiliAddDementiaCheck(), VRLayout.FLOW);

  }

  /**
   * 短期集中リハビリ加算に内部項目を追加します。
   */
  protected void addShortConcentrationRehabiliAddRadio(){

  }

  /**
   * 短期集中リハビリ加算モデルに内部項目を追加します。
   */
  protected void addShortConcentrationRehabiliAddRadioModel(){

    getShortConcentrationRehabiliAddRadioItem1().setButtonIndex(1);

    getShortConcentrationRehabiliAddRadioModel().add(getShortConcentrationRehabiliAddRadioItem1());

    getShortConcentrationRehabiliAddRadioItem2().setButtonIndex(2);

    getShortConcentrationRehabiliAddRadioModel().add(getShortConcentrationRehabiliAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortConcentrationRehabiliAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortConcentrationRehabiliAddRadioItem2(){

  }

  /**
   * 認知症高齢者に内部項目を追加します。
   */
  protected void addShortConcentrationRehabiliAddDementiaCheck(){

  }

  /**
   * 外泊時加算に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedStayingOutOvernightCostRadio(){

  }

  /**
   * 外泊時加算モデルに内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioModel(){

    getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem1().setButtonIndex(1);

    getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioModel().add(getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem1());

    getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem2().setButtonIndex(2);

    getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioModel().add(getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem2(){

  }

  /**
   * 初期加算に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedDefaultRadio(){

  }

  /**
   * 初期加算モデルに内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedDefaultRadioModel(){

    getKaigoHealthCareOfTheAgedDefaultRadioItem1().setButtonIndex(1);

    getKaigoHealthCareOfTheAgedDefaultRadioModel().add(getKaigoHealthCareOfTheAgedDefaultRadioItem1());

    getKaigoHealthCareOfTheAgedDefaultRadioItem2().setButtonIndex(2);

    getKaigoHealthCareOfTheAgedDefaultRadioModel().add(getKaigoHealthCareOfTheAgedDefaultRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedDefaultRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedDefaultRadioItem2(){

  }

  /**
   * タブ2に内部項目を追加します。
   */
  protected void addTab2(){

    tab2.add(getKaigoHealthCareOfTheAgedEmergencyRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getKaigoHealthCareOfTheAgedNutritionManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getKaigoHealthCareOfTheAgedNutritionRadioContainer(), VRLayout.FLOW_INSETLINE);

    tab2.add(getKaigoHealthCareOfTheAgedOralSwitchRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getOralMaintenanceAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getKaigoHealthCareOfTheAgedRecuperateDinnerRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getKaigoHealthCareOfTheAgedHijoAddition(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getSpecialMedicalExpense(), VRLayout.FLOW);

    tab2.add(getSpecialMedicalExpenseLabel(), VRLayout.FLOW_RETURN);

  }

  /**
   * 緊急時治療管理加算に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedEmergencyRadio(){

  }

  /**
   * 緊急時治療管理加算モデルに内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedEmergencyRadioModel(){

    getKaigoHealthCareOfTheAgedEmergencyRadioItem1().setButtonIndex(1);

    getKaigoHealthCareOfTheAgedEmergencyRadioModel().add(getKaigoHealthCareOfTheAgedEmergencyRadioItem1());

    getKaigoHealthCareOfTheAgedEmergencyRadioItem2().setButtonIndex(2);

    getKaigoHealthCareOfTheAgedEmergencyRadioModel().add(getKaigoHealthCareOfTheAgedEmergencyRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedEmergencyRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedEmergencyRadioItem2(){

  }

  /**
   * 栄養管理体制加算に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedNutritionManageRadio(){

  }

  /**
   * 栄養管理体制加算モデルに内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedNutritionManageRadioModel(){

    getKaigoHealthCareOfTheAgedNutritionManageRadioItem1().setButtonIndex(1);

    getKaigoHealthCareOfTheAgedNutritionManageRadioModel().add(getKaigoHealthCareOfTheAgedNutritionManageRadioItem1());

    getKaigoHealthCareOfTheAgedNutritionManageRadioItem2().setButtonIndex(2);

    getKaigoHealthCareOfTheAgedNutritionManageRadioModel().add(getKaigoHealthCareOfTheAgedNutritionManageRadioItem2());

    getKaigoHealthCareOfTheAgedNutritionManageRadioItem3().setButtonIndex(3);

    getKaigoHealthCareOfTheAgedNutritionManageRadioModel().add(getKaigoHealthCareOfTheAgedNutritionManageRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedNutritionManageRadioItem1(){

  }

  /**
   * 管理栄養士に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedNutritionManageRadioItem2(){

  }

  /**
   * 栄養士に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedNutritionManageRadioItem3(){

  }

  /**
   * 栄養マネジメント加算に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedNutritionRadio(){

  }

  /**
   * 栄養マネジメント加算モデルに内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedNutritionRadioModel(){

    getKaigoHealthCareOfTheAgedNutritionRadioItem1().setButtonIndex(1);

    getKaigoHealthCareOfTheAgedNutritionRadioModel().add(getKaigoHealthCareOfTheAgedNutritionRadioItem1());

    getKaigoHealthCareOfTheAgedNutritionRadioItem2().setButtonIndex(2);

    getKaigoHealthCareOfTheAgedNutritionRadioModel().add(getKaigoHealthCareOfTheAgedNutritionRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedNutritionRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedNutritionRadioItem2(){

  }

  /**
   * 経口移行加算に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedOralSwitchRadio(){

  }

  /**
   * 経口移行加算モデルに内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedOralSwitchRadioModel(){

    getKaigoHealthCareOfTheAgedOralSwitchRadioItem1().setButtonIndex(1);

    getKaigoHealthCareOfTheAgedOralSwitchRadioModel().add(getKaigoHealthCareOfTheAgedOralSwitchRadioItem1());

    getKaigoHealthCareOfTheAgedOralSwitchRadioItem2().setButtonIndex(2);

    getKaigoHealthCareOfTheAgedOralSwitchRadioModel().add(getKaigoHealthCareOfTheAgedOralSwitchRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedOralSwitchRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedOralSwitchRadioItem2(){

  }

  /**
   * 経口維持加算に内部項目を追加します。
   */
  protected void addOralMaintenanceAddRadio(){

  }

  /**
   * 経口維持加算モデルに内部項目を追加します。
   */
  protected void addOralMaintenanceAddRadioModel(){

    getOralMaintenanceAddRadioItem1().setButtonIndex(1);

    getOralMaintenanceAddRadioModel().add(getOralMaintenanceAddRadioItem1());

    getOralMaintenanceAddRadioItem2().setButtonIndex(2);

    getOralMaintenanceAddRadioModel().add(getOralMaintenanceAddRadioItem2());

    getOralMaintenanceAddRadioItem3().setButtonIndex(3);

    getOralMaintenanceAddRadioModel().add(getOralMaintenanceAddRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addOralMaintenanceAddRadioItem1(){

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addOralMaintenanceAddRadioItem2(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addOralMaintenanceAddRadioItem3(){

  }

  /**
   * 療養食加算に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedRecuperateDinnerRadio(){

  }

  /**
   * 療養食加算モデルに内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedRecuperateDinnerRadioModel(){

    getKaigoHealthCareOfTheAgedRecuperateDinnerRadioItem1().setButtonIndex(1);

    getKaigoHealthCareOfTheAgedRecuperateDinnerRadioModel().add(getKaigoHealthCareOfTheAgedRecuperateDinnerRadioItem1());

    getKaigoHealthCareOfTheAgedRecuperateDinnerRadioItem2().setButtonIndex(2);

    getKaigoHealthCareOfTheAgedRecuperateDinnerRadioModel().add(getKaigoHealthCareOfTheAgedRecuperateDinnerRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedRecuperateDinnerRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedRecuperateDinnerRadioItem2(){

  }

  /**
   * 退所関連加算に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedHijoAddition(){

    kaigoHealthCareOfTheAgedHijoAddition.add(getLeavingHospitalPreConsultationAddition(), VRLayout.FLOW_RETURN);

    kaigoHealthCareOfTheAgedHijoAddition.add(getLeavingHospitalConsultationAddition(), VRLayout.FLOW_RETURN);

    kaigoHealthCareOfTheAgedHijoAddition.add(getLeavingHospitalDissemination(), VRLayout.FLOW_RETURN);

    kaigoHealthCareOfTheAgedHijoAddition.add(getLeavingHospitalCooperationAddition(), VRLayout.FLOW_RETURN);

    kaigoHealthCareOfTheAgedHijoAddition.add(getLeavingHospital(), VRLayout.FLOW_RETURN);

  }

  /**
   * 退所(院)前後訪問指導加算に内部項目を追加します。
   */
  protected void addLeavingHospitalPreConsultationAddition(){

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
   * 特別療養費に内部項目を追加します。
   */
  protected void addSpecialMedicalExpense(){

  }

  /**
   * ラベルに内部項目を追加します。
   */
  protected void addSpecialMedicalExpenseLabel(){

  }

  /**
   * タブ3に内部項目を追加します。
   */
  protected void addTab3(){

    tab3.add(getKaigoHealthCareOfTheAgedStaffSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getKaigoHealthCareOfTheAgedDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    tab3.add(getUnitCareMaintenanceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getRecuperationRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getIntentionCommunicationDifficultyAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getTrialHijoRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getBodyRestraintAbolitionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getStayReturnSupportAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getTerminalRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getKaigoHealthCareOfTheAgedCalculationDivisionRadioContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 職員減算に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedStaffSubtraction(){

  }

  /**
   * 職員減算モデルに内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedStaffSubtractionModel(){

    getKaigoHealthCareOfTheAgedStaffSubtractionCapacityNot().setButtonIndex(1);

    getKaigoHealthCareOfTheAgedStaffSubtractionModel().add(getKaigoHealthCareOfTheAgedStaffSubtractionCapacityNot());

    getKaigoHealthCareOfTheAgedStaffSubtractionCapacityExcess().setButtonIndex(2);

    getKaigoHealthCareOfTheAgedStaffSubtractionModel().add(getKaigoHealthCareOfTheAgedStaffSubtractionCapacityExcess());

    getKaigoHealthCareOfTheAgedStaffSubtractionPersonLack().setButtonIndex(3);

    getKaigoHealthCareOfTheAgedStaffSubtractionModel().add(getKaigoHealthCareOfTheAgedStaffSubtractionPersonLack());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedStaffSubtractionCapacityNot(){

  }

  /**
   * 定員超過に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedStaffSubtractionCapacityExcess(){

  }

  /**
   * 看護・介護職員又は医師、PT・OT、介護支援専門員の不足に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedStaffSubtractionPersonLack(){

  }

  /**
   * 食事コンテナに内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedDinnerContainer(){

    kaigoHealthCareOfTheAgedDinnerContainer.add(getKaigoHealthCareOfTheAgedDinnerOfferContainer(), VRLayout.FLOW);

    kaigoHealthCareOfTheAgedDinnerContainer.add(getKaigoHealthCareOfTheAgedDinnerCostContainer(), VRLayout.FLOW);

  }

  /**
   * 食事提供に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedDinnerOffer(){

  }

  /**
   * 食事提供モデルに内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedDinnerOfferModel(){

  }

  /**
   * 食事費用に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedDinnerCost(){

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
   * 療養体制維持特別加算に内部項目を追加します。
   */
  protected void addRecuperationRadio(){

  }

  /**
   * 療養体制維持特別加算モデルに内部項目を追加します。
   */
  protected void addRecuperationRadioModel(){

    getRecuperationRadioItem1().setButtonIndex(1);

    getRecuperationRadioModel().add(getRecuperationRadioItem1());

    getRecuperationRadioItem2().setButtonIndex(2);

    getRecuperationRadioModel().add(getRecuperationRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addRecuperationRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addRecuperationRadioItem2(){

  }

  /**
   * 認知症ケア加算に内部項目を追加します。
   */
  protected void addIntentionCommunicationDifficultyAddRadio(){

  }

  /**
   * 認知症ケア加算モデルに内部項目を追加します。
   */
  protected void addIntentionCommunicationDifficultyAddRadioModel(){

    getIntentionCommunicationDifficultyAddRadioItem1().setButtonIndex(1);

    getIntentionCommunicationDifficultyAddRadioModel().add(getIntentionCommunicationDifficultyAddRadioItem1());

    getIntentionCommunicationDifficultyAddRadioItem2().setButtonIndex(2);

    getIntentionCommunicationDifficultyAddRadioModel().add(getIntentionCommunicationDifficultyAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addIntentionCommunicationDifficultyAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addIntentionCommunicationDifficultyAddRadioItem2(){

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
   * ターミナルケア加算に内部項目を追加します。
   */
  protected void addTerminalRadio(){

  }

  /**
   * ターミナルケア加算モデルに内部項目を追加します。
   */
  protected void addTerminalRadioModel(){

    getTerminalRadioItem1().setButtonIndex(1);

    getTerminalRadioModel().add(getTerminalRadioItem1());

    getTerminalRadioItem2().setButtonIndex(2);

    getTerminalRadioModel().add(getTerminalRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTerminalRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addTerminalRadioItem2(){

  }

  /**
   * 算定区分に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedCalculationDivisionRadio(){

  }

  /**
   * 算定区分モデルに内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedCalculationDivisionRadioModel(){

    getKaigoHealthCareOfTheAgedCalculationDivisionRadioItem1().setButtonIndex(1);

    getKaigoHealthCareOfTheAgedCalculationDivisionRadioModel().add(getKaigoHealthCareOfTheAgedCalculationDivisionRadioItem1());

    getKaigoHealthCareOfTheAgedCalculationDivisionRadioItem2().setButtonIndex(2);

    getKaigoHealthCareOfTheAgedCalculationDivisionRadioModel().add(getKaigoHealthCareOfTheAgedCalculationDivisionRadioItem2());

  }

  /**
   * 通常に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedCalculationDivisionRadioItem1(){

  }

  /**
   * 加算のみに内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedCalculationDivisionRadioItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001119_H2005Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001119_H2005Design getThis() {
    return this;
  }
}
