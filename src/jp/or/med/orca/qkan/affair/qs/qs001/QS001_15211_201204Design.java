
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
 * 作成日: 2012/04/09  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン介護老人保健施設 (QS001_15211_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Color;
import java.awt.Component;
import java.awt.im.InputSubset;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACIntegerCheckBox;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACMapBindButton;
import jp.nichicom.ac.component.ACRadioButtonItem;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.ACValueArrayRadioButtonGroup;
import jp.nichicom.ac.container.ACBackLabelContainer;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACComboBoxModelAdapter;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
/**
 * サービスパターン介護老人保健施設画面項目デザイン(QS001_15211_201204) 
 */
public class QS001_15211_201204Design extends QS001ServicePanel {
  //GUIコンポーネント

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup kaigoHealthCareOfTheAgedDivisionRadio;

  private ACLabelContainer kaigoHealthCareOfTheAgedDivisionRadioContainer;

  private ACListModelAdapter kaigoHealthCareOfTheAgedDivisionRadioModel;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedDivisionRadioItem1;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedDivisionRadioItem2;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedDivisionRadioItem3;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedDivisionRadioItem4;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedDivisionRadioItem5;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedDivisionRadioItem6;

  private ACLabelContainer kaigoHealthCareOfTheAgedHospitalDivisionContainer;

  private ACValueArrayRadioButtonGroup kaigoHealthCareOfTheAgedHospitalDivision1;

  private ACListModelAdapter kaigoHealthCareOfTheAgedHospitalDivision1Model;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedHospitalDivision11;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedHospitalDivision12;

  private ACValueArrayRadioButtonGroup kaigoHealthCareOfTheAgedHospitalDivision2;

  private ACListModelAdapter kaigoHealthCareOfTheAgedHospitalDivision2Model;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedHospitalDivision21;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedHospitalDivision22;

  private ACLabelContainer kaigoHealthCareOfTheAgedHospitalRoomContena;

  private ACValueArrayRadioButtonGroup kaigoHealthCareOfTheAgedHospitalRoomRadio;

  private ACListModelAdapter kaigoHealthCareOfTheAgedHospitalRoomRadioModel;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedHospitalRoomRadioItem1;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedHospitalRoomRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoHealthCareOfTheAgedUnitHospitalRoomRadio;

  private ACListModelAdapter kaigoHealthCareOfTheAgedUnitHospitalRoomRadioModel;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem1;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoHealthCareOfTheAgedNightShiftSubtractionRadio;

  private ACLabelContainer kaigoHealthCareOfTheAgedNightShiftSubtractionRadioContainer;

  private ACListModelAdapter kaigoHealthCareOfTheAgedNightShiftSubtractionRadioModel;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem1;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem2;

  private ACLabelContainer shortConcentrationRehabiliContainer;

  private ACValueArrayRadioButtonGroup shortConcentrationRehabiliAddRadio;

  private ACListModelAdapter shortConcentrationRehabiliAddRadioModel;

  private ACRadioButtonItem shortConcentrationRehabiliAddRadioItem1;

  private ACRadioButtonItem shortConcentrationRehabiliAddRadioItem2;

  private ACIntegerCheckBox shortConcentrationRehabiliAddDementiaCheck;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup kaigoHealthCareOfTheAgedStayingOutOvernightCostRadio;

  private ACLabelContainer kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioContainer;

  private ACListModelAdapter kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioModel;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem1;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoHealthCareOfTheAgedDefaultRadio;

  private ACLabelContainer kaigoHealthCareOfTheAgedDefaultRadioContainer;

  private ACListModelAdapter kaigoHealthCareOfTheAgedDefaultRadioModel;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedDefaultRadioItem1;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedDefaultRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoHealthCareOfTheAgedEmergencyRadio;

  private ACLabelContainer kaigoHealthCareOfTheAgedEmergencyRadioContainer;

  private ACListModelAdapter kaigoHealthCareOfTheAgedEmergencyRadioModel;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedEmergencyRadioItem1;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedEmergencyRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoHealthCareOfTheAgedNutritionRadio;

  private ACLabelContainer kaigoHealthCareOfTheAgedNutritionRadioContainer;

  private ACListModelAdapter kaigoHealthCareOfTheAgedNutritionRadioModel;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedNutritionRadioItem1;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedNutritionRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoHealthCareOfTheAgedOralSwitchRadio;

  private ACLabelContainer kaigoHealthCareOfTheAgedOralSwitchRadioContainer;

  private ACListModelAdapter kaigoHealthCareOfTheAgedOralSwitchRadioModel;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedOralSwitchRadioItem1;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedOralSwitchRadioItem2;

  private ACValueArrayRadioButtonGroup oralMaintenanceAddRadio;

  private ACLabelContainer oralMaintenanceAddRadioContainer;

  private ACListModelAdapter oralMaintenanceAddRadioModel;

  private ACRadioButtonItem oralMaintenanceAddRadioItem1;

  private ACRadioButtonItem oralMaintenanceAddRadioItem2;

  private ACRadioButtonItem oralMaintenanceAddRadioItem3;

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

  private ACValueArrayRadioButtonGroup kaigoHealthCareOfTheAgedRecuperateDinnerRadio;

  private ACLabelContainer kaigoHealthCareOfTheAgedRecuperateDinnerRadioContainer;

  private ACListModelAdapter kaigoHealthCareOfTheAgedRecuperateDinnerRadioModel;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedRecuperateDinnerRadioItem1;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedRecuperateDinnerRadioItem2;

  private ACMapBindButton specialMedicalExpense;

  private ACLabel specialMedicalExpenseLabel;

  private ACBackLabelContainer kaigoHealthCareOfTheAgedDinnerContainer;

  private ACComboBox kaigoHealthCareOfTheAgedDinnerOffer;

  private ACLabelContainer kaigoHealthCareOfTheAgedDinnerOfferContainer;

  private ACComboBoxModelAdapter kaigoHealthCareOfTheAgedDinnerOfferModel;

  private ACTextField kaigoHealthCareOfTheAgedDinnerCost;

  private ACLabelContainer kaigoHealthCareOfTheAgedDinnerCostContainer;

  private ACPanel tab3;

  private ACValueArrayRadioButtonGroup kaigoHealthCareOfTheAgedStaffSubtraction;

  private ACLabelContainer kaigoHealthCareOfTheAgedStaffSubtractionContainer;

  private ACListModelAdapter kaigoHealthCareOfTheAgedStaffSubtractionModel;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedStaffSubtractionCapacityNot;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedStaffSubtractionCapacityExcess;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedStaffSubtractionPersonLack;

  private ACValueArrayRadioButtonGroup unitCareMaintenanceRadio;

  private ACLabelContainer unitCareMaintenanceRadioContainer;

  private ACListModelAdapter unitCareMaintenanceRadioModel;

  private ACRadioButtonItem unitCareMaintenanceRadioItem1;

  private ACRadioButtonItem unitCareMaintenanceRadioItem2;

  private ACValueArrayRadioButtonGroup recuperationRadio;

  private ACLabelContainer recuperationRadioContainer;

  private ACListModelAdapter recuperationRadioModel;

  private ACRadioButtonItem recuperationRadioItem1;

  private ACRadioButtonItem recuperationRadioItem2;

  private ACValueArrayRadioButtonGroup nightStaffDispositionAddRadioGroup;

  private ACLabelContainer nightStaffDispositionAddRadioGroupContainer;

  private ACListModelAdapter nightStaffDispositionAddRadioGroupModel;

  private ACRadioButtonItem nightStaffDispositionAddRadioItem1;

  private ACRadioButtonItem nightStaffDispositionAddRadioItem2;

  private ACValueArrayRadioButtonGroup intentionCommunicationDifficultyAddRadio;

  private ACLabelContainer intentionCommunicationDifficultyAddRadioContainer;

  private ACListModelAdapter intentionCommunicationDifficultyAddRadioModel;

  private ACRadioButtonItem intentionCommunicationDifficultyAddRadioItem1;

  private ACRadioButtonItem intentionCommunicationDifficultyAddRadioItem2;

  private ACValueArrayRadioButtonGroup dementiaProfessionalCareAddRadioGroup;

  private ACLabelContainer dementiaProfessionalCareAddRadioGroupContainer;

  private ACListModelAdapter dementiaProfessionalCareAddRadioGroupModel;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem1;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem2;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem3;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACValueArrayRadioButtonGroup dementiainfoAddRadioGroup;

  private ACLabelContainer dementiainfoAddRadioGroupContainer;

  private ACListModelAdapter dementiainfoAddRadioGroupModel;

  private ACRadioButtonItem dementiainfoAddRadioItem1;

  private ACRadioButtonItem dementiainfoAddRadioItem2;

  private ACValueArrayRadioButtonGroup dementiaEmergencyAddRadioGroup;

  private ACLabelContainer dementiaEmergencyAddRadioGroupContainer;

  private ACListModelAdapter dementiaEmergencyAddRadioGroupModel;

  private ACRadioButtonItem dementiaEmergencyAddRadioItem1;

  private ACRadioButtonItem dementiaEmergencyAddRadioItem2;

  private ACValueArrayRadioButtonGroup bodyRestraintAbolitionRadio;

  private ACLabelContainer bodyRestraintAbolitionRadioContainer;

  private ACListModelAdapter bodyRestraintAbolitionRadioModel;

  private ACRadioButtonItem bodyRestraintAbolitionRadioItem1;

  private ACRadioButtonItem bodyRestraintAbolitionRadioItem2;

  private ACPanel tab4;

  private ACLabelContainer kaigoHealthCareOfTheAgedHijoAddition;

  private ACIntegerCheckBox leavingHospitalPreConsultationAddition;

  private ACIntegerCheckBox leavingHospitalAfterConsultationAddition;

  private ACIntegerCheckBox leavingHospitalConsultationAddition;

  private ACIntegerCheckBox leavingHospitalDissemination;

  private ACIntegerCheckBox leavingHospitalCooperationAddition;

  private ACIntegerCheckBox leavingHospital;

  private ACValueArrayRadioButtonGroup stayReturnSupportRyoyoAddRadio;

  private ACLabelContainer stayReturnSupportRyoyoAddRadioContainer;

  private ACListModelAdapter stayReturnSupportRyoyoAddRadioModel;

  private ACRadioButtonItem stayReturnSupportRyoyoAddRadioItem1;

  private ACRadioButtonItem stayReturnSupportRyoyoAddRadioItem2;

  private ACValueArrayRadioButtonGroup stayReturnSupportAddRadio;

  private ACLabelContainer stayReturnSupportAddRadioContainer;

  private ACListModelAdapter stayReturnSupportAddRadioModel;

  private ACRadioButtonItem stayReturnSupportAddRadioItem1;

  private ACRadioButtonItem stayReturnSupportAddRadioItem2;

  private ACValueArrayRadioButtonGroup terminalRadio;

  private ACLabelContainer terminalRadioContainer;

  private ACListModelAdapter terminalRadioModel;

  private ACRadioButtonItem terminalRadioItem1;

  private ACRadioButtonItem terminalRadioItem2;

  private ACRadioButtonItem terminalRadioItem3;

  private ACRadioButtonItem terminalRadioItem4;

  private ACLabelContainer terminalDaysContainer;

  private ACTextField terminalDays;

  private ACLabel terminalDaysUnit;

  private ACPanel tab5;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACValueArrayRadioButtonGroup enterHospitalPreConsultantRadio;

  private ACLabelContainer enterHospitalPreConsultantRadioContainer;

  private ACListModelAdapter enterHospitalPreConsultantRadioModel;

  private ACRadioButtonItem enterHospitalPreConsultantRadioItem1;

  private ACRadioButtonItem enterHospitalPreConsultantRadioItem2;

  private ACValueArrayRadioButtonGroup pneumoniaTreatmentRadio;

  private ACLabelContainer pneumoniaTreatmentRadioContainer;

  private ACListModelAdapter pneumoniaTreatmentRadioModel;

  private ACRadioButtonItem pneumoniaTreatmentRadioItem1;

  private ACRadioButtonItem pneumoniaTreatmentRadioItem2;

  private ACValueArrayRadioButtonGroup localTreatmentPlanInfoAddRadio;

  private ACLabelContainer localTreatmentPlanInfoAddRadioContainer;

  private ACListModelAdapter localTreatmentPlanInfoAddRadioModel;

  private ACRadioButtonItem localTreatmentPlanInfoAddRadioItem1;

  private ACRadioButtonItem localTreatmentPlanInfoAddRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoHealthCareOfTheAgedCalculationDivisionRadio;

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
  public ACValueArrayRadioButtonGroup getKaigoHealthCareOfTheAgedDivisionRadio(){
    if(kaigoHealthCareOfTheAgedDivisionRadio==null){

      kaigoHealthCareOfTheAgedDivisionRadio = new ACValueArrayRadioButtonGroup();

      getKaigoHealthCareOfTheAgedDivisionRadioContainer().setText("施設等の区分");

      kaigoHealthCareOfTheAgedDivisionRadio.setBindPath("1520101");

      kaigoHealthCareOfTheAgedDivisionRadio.setNoSelectIndex(0);

      kaigoHealthCareOfTheAgedDivisionRadio.setUseClearButton(false);

      kaigoHealthCareOfTheAgedDivisionRadio.setModel(getKaigoHealthCareOfTheAgedDivisionRadioModel());

      kaigoHealthCareOfTheAgedDivisionRadio.setValues(new int[]{1,2,3,4,5,6});

      addKaigoHealthCareOfTheAgedDivisionRadio();
    }
    return kaigoHealthCareOfTheAgedDivisionRadio;

  }

  /**
   * 施設等の区分コンテナを取得します。
   * @return 施設等の区分コンテナ
   */
  protected ACLabelContainer getKaigoHealthCareOfTheAgedDivisionRadioContainer(){
    if(kaigoHealthCareOfTheAgedDivisionRadioContainer==null){
      kaigoHealthCareOfTheAgedDivisionRadioContainer = new ACLabelContainer();
      kaigoHealthCareOfTheAgedDivisionRadioContainer.setFollowChildEnabled(true);
      kaigoHealthCareOfTheAgedDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoHealthCareOfTheAgedDivisionRadioContainer.add(getKaigoHealthCareOfTheAgedDivisionRadio(), null);
    }
    return kaigoHealthCareOfTheAgedDivisionRadioContainer;
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
   * 介護老人保健施設（I）を取得します。
   * @return 介護老人保健施設（I）
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedDivisionRadioItem1(){
    if(kaigoHealthCareOfTheAgedDivisionRadioItem1==null){

      kaigoHealthCareOfTheAgedDivisionRadioItem1 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedDivisionRadioItem1.setText("介護老人保健施設（I）");

      kaigoHealthCareOfTheAgedDivisionRadioItem1.setGroup(getKaigoHealthCareOfTheAgedDivisionRadio());

      kaigoHealthCareOfTheAgedDivisionRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoHealthCareOfTheAgedDivisionRadioItem1();
    }
    return kaigoHealthCareOfTheAgedDivisionRadioItem1;

  }

  /**
   * ユニット型介護老人保健施設（I）を取得します。
   * @return ユニット型介護老人保健施設（I）
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedDivisionRadioItem2(){
    if(kaigoHealthCareOfTheAgedDivisionRadioItem2==null){

      kaigoHealthCareOfTheAgedDivisionRadioItem2 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedDivisionRadioItem2.setText("ユニット型介護老人保健施設（I）");

      kaigoHealthCareOfTheAgedDivisionRadioItem2.setGroup(getKaigoHealthCareOfTheAgedDivisionRadio());

      kaigoHealthCareOfTheAgedDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoHealthCareOfTheAgedDivisionRadioItem2();
    }
    return kaigoHealthCareOfTheAgedDivisionRadioItem2;

  }

  /**
   * 介護老人保健施設（II）を取得します。
   * @return 介護老人保健施設（II）
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedDivisionRadioItem3(){
    if(kaigoHealthCareOfTheAgedDivisionRadioItem3==null){

      kaigoHealthCareOfTheAgedDivisionRadioItem3 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedDivisionRadioItem3.setText("介護老人保健施設（II）");

      kaigoHealthCareOfTheAgedDivisionRadioItem3.setGroup(getKaigoHealthCareOfTheAgedDivisionRadio());

      kaigoHealthCareOfTheAgedDivisionRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoHealthCareOfTheAgedDivisionRadioItem3();
    }
    return kaigoHealthCareOfTheAgedDivisionRadioItem3;

  }

  /**
   * ユニット型介護老人保健施設（II）を取得します。
   * @return ユニット型介護老人保健施設（II）
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedDivisionRadioItem4(){
    if(kaigoHealthCareOfTheAgedDivisionRadioItem4==null){

      kaigoHealthCareOfTheAgedDivisionRadioItem4 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedDivisionRadioItem4.setText("ユニット型介護老人保健施設（II）");

      kaigoHealthCareOfTheAgedDivisionRadioItem4.setGroup(getKaigoHealthCareOfTheAgedDivisionRadio());

      kaigoHealthCareOfTheAgedDivisionRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoHealthCareOfTheAgedDivisionRadioItem4();
    }
    return kaigoHealthCareOfTheAgedDivisionRadioItem4;

  }

  /**
   * 介護老人保健施設（III）を取得します。
   * @return 介護老人保健施設（III）
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedDivisionRadioItem5(){
    if(kaigoHealthCareOfTheAgedDivisionRadioItem5==null){

      kaigoHealthCareOfTheAgedDivisionRadioItem5 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedDivisionRadioItem5.setText("介護老人保健施設（III）");

      kaigoHealthCareOfTheAgedDivisionRadioItem5.setGroup(getKaigoHealthCareOfTheAgedDivisionRadio());

      kaigoHealthCareOfTheAgedDivisionRadioItem5.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoHealthCareOfTheAgedDivisionRadioItem5();
    }
    return kaigoHealthCareOfTheAgedDivisionRadioItem5;

  }

  /**
   * ユニット型介護老人保健施設（III）を取得します。
   * @return ユニット型介護老人保健施設（III）
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedDivisionRadioItem6(){
    if(kaigoHealthCareOfTheAgedDivisionRadioItem6==null){

      kaigoHealthCareOfTheAgedDivisionRadioItem6 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedDivisionRadioItem6.setText("ユニット型介護老人保健施設（III）");

      kaigoHealthCareOfTheAgedDivisionRadioItem6.setGroup(getKaigoHealthCareOfTheAgedDivisionRadio());

      kaigoHealthCareOfTheAgedDivisionRadioItem6.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoHealthCareOfTheAgedDivisionRadioItem6();
    }
    return kaigoHealthCareOfTheAgedDivisionRadioItem6;

  }

  /**
   * 人員配置区分コンテナを取得します。
   * @return 人員配置区分コンテナ
   */
  public ACLabelContainer getKaigoHealthCareOfTheAgedHospitalDivisionContainer(){
    if(kaigoHealthCareOfTheAgedHospitalDivisionContainer==null){

      kaigoHealthCareOfTheAgedHospitalDivisionContainer = new ACLabelContainer();

      kaigoHealthCareOfTheAgedHospitalDivisionContainer.setText("人員配置区分");

      kaigoHealthCareOfTheAgedHospitalDivisionContainer.setFollowChildEnabled(true);

      addKaigoHealthCareOfTheAgedHospitalDivisionContainer();
    }
    return kaigoHealthCareOfTheAgedHospitalDivisionContainer;

  }

  /**
   * 人員配置区分を取得します。
   * @return 人員配置区分
   */
  public ACValueArrayRadioButtonGroup getKaigoHealthCareOfTheAgedHospitalDivision1(){
    if(kaigoHealthCareOfTheAgedHospitalDivision1==null){

      kaigoHealthCareOfTheAgedHospitalDivision1 = new ACValueArrayRadioButtonGroup();

      kaigoHealthCareOfTheAgedHospitalDivision1.setBindPath("1520143");

      kaigoHealthCareOfTheAgedHospitalDivision1.setUseClearButton(false);

      kaigoHealthCareOfTheAgedHospitalDivision1.setModel(getKaigoHealthCareOfTheAgedHospitalDivision1Model());

      kaigoHealthCareOfTheAgedHospitalDivision1.setValues(new int[]{1,2});

      addKaigoHealthCareOfTheAgedHospitalDivision1();
    }
    return kaigoHealthCareOfTheAgedHospitalDivision1;

  }

  /**
   * 人員配置区分モデルを取得します。
   * @return 人員配置区分モデル
   */
  protected ACListModelAdapter getKaigoHealthCareOfTheAgedHospitalDivision1Model(){
    if(kaigoHealthCareOfTheAgedHospitalDivision1Model==null){
      kaigoHealthCareOfTheAgedHospitalDivision1Model = new ACListModelAdapter();
      addKaigoHealthCareOfTheAgedHospitalDivision1Model();
    }
    return kaigoHealthCareOfTheAgedHospitalDivision1Model;
  }

  /**
   * 従来型を取得します。
   * @return 従来型
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedHospitalDivision11(){
    if(kaigoHealthCareOfTheAgedHospitalDivision11==null){

      kaigoHealthCareOfTheAgedHospitalDivision11 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedHospitalDivision11.setText("従来型");

      kaigoHealthCareOfTheAgedHospitalDivision11.setGroup(getKaigoHealthCareOfTheAgedHospitalDivision1());

      kaigoHealthCareOfTheAgedHospitalDivision11.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedHospitalDivision11();
    }
    return kaigoHealthCareOfTheAgedHospitalDivision11;

  }

  /**
   * 在宅強化型を取得します。
   * @return 在宅強化型
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedHospitalDivision12(){
    if(kaigoHealthCareOfTheAgedHospitalDivision12==null){

      kaigoHealthCareOfTheAgedHospitalDivision12 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedHospitalDivision12.setText("在宅強化型");

      kaigoHealthCareOfTheAgedHospitalDivision12.setGroup(getKaigoHealthCareOfTheAgedHospitalDivision1());

      kaigoHealthCareOfTheAgedHospitalDivision12.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedHospitalDivision12();
    }
    return kaigoHealthCareOfTheAgedHospitalDivision12;

  }

  /**
   * 人員配置区分（療養型）を取得します。
   * @return 人員配置区分（療養型）
   */
  public ACValueArrayRadioButtonGroup getKaigoHealthCareOfTheAgedHospitalDivision2(){
    if(kaigoHealthCareOfTheAgedHospitalDivision2==null){

      kaigoHealthCareOfTheAgedHospitalDivision2 = new ACValueArrayRadioButtonGroup();

      kaigoHealthCareOfTheAgedHospitalDivision2.setBindPath("1520149");

      kaigoHealthCareOfTheAgedHospitalDivision2.setUseClearButton(false);

      kaigoHealthCareOfTheAgedHospitalDivision2.setModel(getKaigoHealthCareOfTheAgedHospitalDivision2Model());

      kaigoHealthCareOfTheAgedHospitalDivision2.setValues(new int[]{1,2});

      addKaigoHealthCareOfTheAgedHospitalDivision2();
    }
    return kaigoHealthCareOfTheAgedHospitalDivision2;

  }

  /**
   * 人員配置区分（療養型）モデルを取得します。
   * @return 人員配置区分（療養型）モデル
   */
  protected ACListModelAdapter getKaigoHealthCareOfTheAgedHospitalDivision2Model(){
    if(kaigoHealthCareOfTheAgedHospitalDivision2Model==null){
      kaigoHealthCareOfTheAgedHospitalDivision2Model = new ACListModelAdapter();
      addKaigoHealthCareOfTheAgedHospitalDivision2Model();
    }
    return kaigoHealthCareOfTheAgedHospitalDivision2Model;
  }

  /**
   * 療養型を取得します。
   * @return 療養型
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedHospitalDivision21(){
    if(kaigoHealthCareOfTheAgedHospitalDivision21==null){

      kaigoHealthCareOfTheAgedHospitalDivision21 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedHospitalDivision21.setText("療養型");

      kaigoHealthCareOfTheAgedHospitalDivision21.setGroup(getKaigoHealthCareOfTheAgedHospitalDivision2());

      kaigoHealthCareOfTheAgedHospitalDivision21.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedHospitalDivision21();
    }
    return kaigoHealthCareOfTheAgedHospitalDivision21;

  }

  /**
   * 療養強化型を取得します。
   * @return 療養強化型
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedHospitalDivision22(){
    if(kaigoHealthCareOfTheAgedHospitalDivision22==null){

      kaigoHealthCareOfTheAgedHospitalDivision22 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedHospitalDivision22.setText("療養強化型");

      kaigoHealthCareOfTheAgedHospitalDivision22.setGroup(getKaigoHealthCareOfTheAgedHospitalDivision2());

      kaigoHealthCareOfTheAgedHospitalDivision22.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedHospitalDivision22();
    }
    return kaigoHealthCareOfTheAgedHospitalDivision22;

  }

  /**
   * 病室区分コンテナを取得します。
   * @return 病室区分コンテナ
   */
  public ACLabelContainer getKaigoHealthCareOfTheAgedHospitalRoomContena(){
    if(kaigoHealthCareOfTheAgedHospitalRoomContena==null){

      kaigoHealthCareOfTheAgedHospitalRoomContena = new ACLabelContainer();

      kaigoHealthCareOfTheAgedHospitalRoomContena.setText("病室区分");

      kaigoHealthCareOfTheAgedHospitalRoomContena.setFollowChildEnabled(true);

      addKaigoHealthCareOfTheAgedHospitalRoomContena();
    }
    return kaigoHealthCareOfTheAgedHospitalRoomContena;

  }

  /**
   * 病室区分（介護保健施設）を取得します。
   * @return 病室区分（介護保健施設）
   */
  public ACValueArrayRadioButtonGroup getKaigoHealthCareOfTheAgedHospitalRoomRadio(){
    if(kaigoHealthCareOfTheAgedHospitalRoomRadio==null){

      kaigoHealthCareOfTheAgedHospitalRoomRadio = new ACValueArrayRadioButtonGroup();

      kaigoHealthCareOfTheAgedHospitalRoomRadio.setBindPath("1520102");

      kaigoHealthCareOfTheAgedHospitalRoomRadio.setUseClearButton(false);

      kaigoHealthCareOfTheAgedHospitalRoomRadio.setModel(getKaigoHealthCareOfTheAgedHospitalRoomRadioModel());

      kaigoHealthCareOfTheAgedHospitalRoomRadio.setValues(new int[]{1,2});

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
  public ACValueArrayRadioButtonGroup getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio(){
    if(kaigoHealthCareOfTheAgedUnitHospitalRoomRadio==null){

      kaigoHealthCareOfTheAgedUnitHospitalRoomRadio = new ACValueArrayRadioButtonGroup();

      kaigoHealthCareOfTheAgedUnitHospitalRoomRadio.setBindPath("1520103");

      kaigoHealthCareOfTheAgedUnitHospitalRoomRadio.setUseClearButton(false);

      kaigoHealthCareOfTheAgedUnitHospitalRoomRadio.setModel(getKaigoHealthCareOfTheAgedUnitHospitalRoomRadioModel());

      kaigoHealthCareOfTheAgedUnitHospitalRoomRadio.setValues(new int[]{1,2});

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
  public ACValueArrayRadioButtonGroup getKaigoHealthCareOfTheAgedNightShiftSubtractionRadio(){
    if(kaigoHealthCareOfTheAgedNightShiftSubtractionRadio==null){

      kaigoHealthCareOfTheAgedNightShiftSubtractionRadio = new ACValueArrayRadioButtonGroup();

      getKaigoHealthCareOfTheAgedNightShiftSubtractionRadioContainer().setText("夜間勤務条件基準");

      kaigoHealthCareOfTheAgedNightShiftSubtractionRadio.setBindPath("1520104");

      kaigoHealthCareOfTheAgedNightShiftSubtractionRadio.setUseClearButton(false);

      kaigoHealthCareOfTheAgedNightShiftSubtractionRadio.setModel(getKaigoHealthCareOfTheAgedNightShiftSubtractionRadioModel());

      kaigoHealthCareOfTheAgedNightShiftSubtractionRadio.setValues(new int[]{1,2});

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
   * 短期集中リハビリ加算コンテナを取得します。
   * @return 短期集中リハビリ加算コンテナ
   */
  public ACLabelContainer getShortConcentrationRehabiliContainer(){
    if(shortConcentrationRehabiliContainer==null){

      shortConcentrationRehabiliContainer = new ACLabelContainer();

      shortConcentrationRehabiliContainer.setText("短期集中リハビリ加算");

      shortConcentrationRehabiliContainer.setFollowChildEnabled(true);

      addShortConcentrationRehabiliContainer();
    }
    return shortConcentrationRehabiliContainer;

  }

  /**
   * 短期集中リハビリ加算を取得します。
   * @return 短期集中リハビリ加算
   */
  public ACValueArrayRadioButtonGroup getShortConcentrationRehabiliAddRadio(){
    if(shortConcentrationRehabiliAddRadio==null){

      shortConcentrationRehabiliAddRadio = new ACValueArrayRadioButtonGroup();

      shortConcentrationRehabiliAddRadio.setBindPath("1520124");

      shortConcentrationRehabiliAddRadio.setUseClearButton(false);

      shortConcentrationRehabiliAddRadio.setModel(getShortConcentrationRehabiliAddRadioModel());

      shortConcentrationRehabiliAddRadio.setValues(new int[]{1,2});

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
   * 外泊時加算を取得します。
   * @return 外泊時加算
   */
  public ACValueArrayRadioButtonGroup getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadio(){
    if(kaigoHealthCareOfTheAgedStayingOutOvernightCostRadio==null){

      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadio = new ACValueArrayRadioButtonGroup();

      getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioContainer().setText("外泊加算");

      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadio.setBindPath("1520107");

      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadio.setUseClearButton(false);

      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadio.setModel(getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioModel());

      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadio.setValues(new int[]{1,2});

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
  public ACValueArrayRadioButtonGroup getKaigoHealthCareOfTheAgedDefaultRadio(){
    if(kaigoHealthCareOfTheAgedDefaultRadio==null){

      kaigoHealthCareOfTheAgedDefaultRadio = new ACValueArrayRadioButtonGroup();

      getKaigoHealthCareOfTheAgedDefaultRadioContainer().setText("初期加算");

      kaigoHealthCareOfTheAgedDefaultRadio.setBindPath("1520108");

      kaigoHealthCareOfTheAgedDefaultRadio.setUseClearButton(false);

      kaigoHealthCareOfTheAgedDefaultRadio.setModel(getKaigoHealthCareOfTheAgedDefaultRadioModel());

      kaigoHealthCareOfTheAgedDefaultRadio.setValues(new int[]{1,2});

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
   * 緊急時施設療養費を取得します。
   * @return 緊急時施設療養費
   */
  public ACValueArrayRadioButtonGroup getKaigoHealthCareOfTheAgedEmergencyRadio(){
    if(kaigoHealthCareOfTheAgedEmergencyRadio==null){

      kaigoHealthCareOfTheAgedEmergencyRadio = new ACValueArrayRadioButtonGroup();

      getKaigoHealthCareOfTheAgedEmergencyRadioContainer().setText("緊急時施設療養費");

      kaigoHealthCareOfTheAgedEmergencyRadio.setBindPath("1520109");

      kaigoHealthCareOfTheAgedEmergencyRadio.setUseClearButton(false);

      kaigoHealthCareOfTheAgedEmergencyRadio.setModel(getKaigoHealthCareOfTheAgedEmergencyRadioModel());

      kaigoHealthCareOfTheAgedEmergencyRadio.setValues(new int[]{1,2});

      addKaigoHealthCareOfTheAgedEmergencyRadio();
    }
    return kaigoHealthCareOfTheAgedEmergencyRadio;

  }

  /**
   * 緊急時施設療養費コンテナを取得します。
   * @return 緊急時施設療養費コンテナ
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
   * 緊急時施設療養費モデルを取得します。
   * @return 緊急時施設療養費モデル
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
   * 栄養マネジメント加算を取得します。
   * @return 栄養マネジメント加算
   */
  public ACValueArrayRadioButtonGroup getKaigoHealthCareOfTheAgedNutritionRadio(){
    if(kaigoHealthCareOfTheAgedNutritionRadio==null){

      kaigoHealthCareOfTheAgedNutritionRadio = new ACValueArrayRadioButtonGroup();

      getKaigoHealthCareOfTheAgedNutritionRadioContainer().setText("栄養マネジメント加算");

      kaigoHealthCareOfTheAgedNutritionRadio.setBindPath("1520111");

      kaigoHealthCareOfTheAgedNutritionRadio.setUseClearButton(false);

      kaigoHealthCareOfTheAgedNutritionRadio.setModel(getKaigoHealthCareOfTheAgedNutritionRadioModel());

      kaigoHealthCareOfTheAgedNutritionRadio.setValues(new int[]{1,2});

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
  public ACValueArrayRadioButtonGroup getKaigoHealthCareOfTheAgedOralSwitchRadio(){
    if(kaigoHealthCareOfTheAgedOralSwitchRadio==null){

      kaigoHealthCareOfTheAgedOralSwitchRadio = new ACValueArrayRadioButtonGroup();

      getKaigoHealthCareOfTheAgedOralSwitchRadioContainer().setText("経口移行加算");

      kaigoHealthCareOfTheAgedOralSwitchRadio.setBindPath("1520112");

      kaigoHealthCareOfTheAgedOralSwitchRadio.setUseClearButton(false);

      kaigoHealthCareOfTheAgedOralSwitchRadio.setModel(getKaigoHealthCareOfTheAgedOralSwitchRadioModel());

      kaigoHealthCareOfTheAgedOralSwitchRadio.setValues(new int[]{1,2});

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
  public ACValueArrayRadioButtonGroup getOralMaintenanceAddRadio(){
    if(oralMaintenanceAddRadio==null){

      oralMaintenanceAddRadio = new ACValueArrayRadioButtonGroup();

      getOralMaintenanceAddRadioContainer().setText("経口維持加算");

      oralMaintenanceAddRadio.setBindPath("1520126");

      oralMaintenanceAddRadio.setUseClearButton(false);

      oralMaintenanceAddRadio.setModel(getOralMaintenanceAddRadioModel());

      oralMaintenanceAddRadio.setValues(new int[]{1,2,3});

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
   * 口腔機能維持管理体制加算を取得します。
   * @return 口腔機能維持管理体制加算
   */
  public ACValueArrayRadioButtonGroup getOralKeepStructureAddRadioGroup(){
    if(oralKeepStructureAddRadioGroup==null){

      oralKeepStructureAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getOralKeepStructureAddRadioGroupContainer().setText("口腔機能維持管理体制加算");

      oralKeepStructureAddRadioGroup.setBindPath("1510145");

      oralKeepStructureAddRadioGroup.setNoSelectIndex(0);

      oralKeepStructureAddRadioGroup.setUseClearButton(false);

      oralKeepStructureAddRadioGroup.setModel(getOralKeepStructureAddRadioGroupModel());

      oralKeepStructureAddRadioGroup.setValues(new int[]{1,2});

      addOralKeepStructureAddRadioGroup();
    }
    return oralKeepStructureAddRadioGroup;

  }

  /**
   * 口腔機能維持管理体制加算コンテナを取得します。
   * @return 口腔機能維持管理体制加算コンテナ
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
   * 口腔機能維持管理体制加算モデルを取得します。
   * @return 口腔機能維持管理体制加算モデル
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
   * 口腔機能維持管理加算を取得します。
   * @return 口腔機能維持管理加算
   */
  public ACValueArrayRadioButtonGroup getOralKeepAddRadioGroup(){
    if(oralKeepAddRadioGroup==null){

      oralKeepAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getOralKeepAddRadioGroupContainer().setText("口腔機能維持管理加算");

      oralKeepAddRadioGroup.setBindPath("1520135");

      oralKeepAddRadioGroup.setNoSelectIndex(0);

      oralKeepAddRadioGroup.setUseClearButton(false);

      oralKeepAddRadioGroup.setModel(getOralKeepAddRadioGroupModel());

      oralKeepAddRadioGroup.setValues(new int[]{1,2});

      addOralKeepAddRadioGroup();
    }
    return oralKeepAddRadioGroup;

  }

  /**
   * 口腔機能維持管理加算コンテナを取得します。
   * @return 口腔機能維持管理加算コンテナ
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
   * 口腔機能維持管理加算モデルを取得します。
   * @return 口腔機能維持管理加算モデル
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
  public ACValueArrayRadioButtonGroup getKaigoHealthCareOfTheAgedRecuperateDinnerRadio(){
    if(kaigoHealthCareOfTheAgedRecuperateDinnerRadio==null){

      kaigoHealthCareOfTheAgedRecuperateDinnerRadio = new ACValueArrayRadioButtonGroup();

      getKaigoHealthCareOfTheAgedRecuperateDinnerRadioContainer().setText("療養食加算");

      kaigoHealthCareOfTheAgedRecuperateDinnerRadio.setBindPath("1520113");

      kaigoHealthCareOfTheAgedRecuperateDinnerRadio.setUseClearButton(false);

      kaigoHealthCareOfTheAgedRecuperateDinnerRadio.setModel(getKaigoHealthCareOfTheAgedRecuperateDinnerRadioModel());

      kaigoHealthCareOfTheAgedRecuperateDinnerRadio.setValues(new int[]{1,2});

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
   * 食事コンテナを取得します。
   * @return 食事コンテナ
   */
  public ACBackLabelContainer getKaigoHealthCareOfTheAgedDinnerContainer(){
    if(kaigoHealthCareOfTheAgedDinnerContainer==null){

      kaigoHealthCareOfTheAgedDinnerContainer = new ACBackLabelContainer();

      kaigoHealthCareOfTheAgedDinnerContainer.setFollowChildEnabled(true);

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
   * 職員減算を取得します。
   * @return 職員減算
   */
  public ACValueArrayRadioButtonGroup getKaigoHealthCareOfTheAgedStaffSubtraction(){
    if(kaigoHealthCareOfTheAgedStaffSubtraction==null){

      kaigoHealthCareOfTheAgedStaffSubtraction = new ACValueArrayRadioButtonGroup();

      getKaigoHealthCareOfTheAgedStaffSubtractionContainer().setText("人員減算");

      kaigoHealthCareOfTheAgedStaffSubtraction.setBindPath("1520119");

      kaigoHealthCareOfTheAgedStaffSubtraction.setUseClearButton(false);

      kaigoHealthCareOfTheAgedStaffSubtraction.setModel(getKaigoHealthCareOfTheAgedStaffSubtractionModel());

      kaigoHealthCareOfTheAgedStaffSubtraction.setValues(new int[]{1,2,3});

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
   * 看護・介護職員又は医師、PT・OT・ST、介護支援専門員の不足を取得します。
   * @return 看護・介護職員又は医師、PT・OT・ST、介護支援専門員の不足
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedStaffSubtractionPersonLack(){
    if(kaigoHealthCareOfTheAgedStaffSubtractionPersonLack==null){

      kaigoHealthCareOfTheAgedStaffSubtractionPersonLack = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedStaffSubtractionPersonLack.setText("<html>看護・介護職員又は医師、PT・OT・ST、<br>介護支援専門員の不足<html>");

      kaigoHealthCareOfTheAgedStaffSubtractionPersonLack.setGroup(getKaigoHealthCareOfTheAgedStaffSubtraction());

      kaigoHealthCareOfTheAgedStaffSubtractionPersonLack.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedStaffSubtractionPersonLack();
    }
    return kaigoHealthCareOfTheAgedStaffSubtractionPersonLack;

  }

  /**
   * ユニットケアの整備を取得します。
   * @return ユニットケアの整備
   */
  public ACValueArrayRadioButtonGroup getUnitCareMaintenanceRadio(){
    if(unitCareMaintenanceRadio==null){

      unitCareMaintenanceRadio = new ACValueArrayRadioButtonGroup();

      getUnitCareMaintenanceRadioContainer().setText("ユニットケアの整備");

      unitCareMaintenanceRadio.setBindPath("1520127");

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
   * 療養体制維持特別加算を取得します。
   * @return 療養体制維持特別加算
   */
  public ACValueArrayRadioButtonGroup getRecuperationRadio(){
    if(recuperationRadio==null){

      recuperationRadio = new ACValueArrayRadioButtonGroup();

      getRecuperationRadioContainer().setText("療養体制維持特別加算");

      recuperationRadio.setBindPath("1520134");

      recuperationRadio.setUseClearButton(false);

      recuperationRadio.setModel(getRecuperationRadioModel());

      recuperationRadio.setValues(new int[]{1,2});

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
   * 夜勤職員配置加算を取得します。
   * @return 夜勤職員配置加算
   */
  public ACValueArrayRadioButtonGroup getNightStaffDispositionAddRadioGroup(){
    if(nightStaffDispositionAddRadioGroup==null){

      nightStaffDispositionAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getNightStaffDispositionAddRadioGroupContainer().setText("夜勤職員配置加算");

      nightStaffDispositionAddRadioGroup.setBindPath("1520136");

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
   * 認知症ケア加算を取得します。
   * @return 認知症ケア加算
   */
  public ACValueArrayRadioButtonGroup getIntentionCommunicationDifficultyAddRadio(){
    if(intentionCommunicationDifficultyAddRadio==null){

      intentionCommunicationDifficultyAddRadio = new ACValueArrayRadioButtonGroup();

      getIntentionCommunicationDifficultyAddRadioContainer().setText("認知症ケア加算");

      intentionCommunicationDifficultyAddRadio.setBindPath("1520128");

      intentionCommunicationDifficultyAddRadio.setUseClearButton(false);

      intentionCommunicationDifficultyAddRadio.setModel(getIntentionCommunicationDifficultyAddRadioModel());

      intentionCommunicationDifficultyAddRadio.setValues(new int[]{1,2});

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
   * 認知症専門ケア加算を取得します。
   * @return 認知症専門ケア加算
   */
  public ACValueArrayRadioButtonGroup getDementiaProfessionalCareAddRadioGroup(){
    if(dementiaProfessionalCareAddRadioGroup==null){

      dementiaProfessionalCareAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaProfessionalCareAddRadioGroupContainer().setText("認知症専門ケア加算");

      dementiaProfessionalCareAddRadioGroup.setBindPath("1520137");

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
   * 若年性認知症入所者受入加算を取得します。
   * @return 若年性認知症入所者受入加算
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("若年性認知症入所者受入加算");

      youngDementiaPatinetAddRadioGroup.setBindPath("1520138");

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
   * 認知症情報提供加算を取得します。
   * @return 認知症情報提供加算
   */
  public ACValueArrayRadioButtonGroup getDementiainfoAddRadioGroup(){
    if(dementiainfoAddRadioGroup==null){

      dementiainfoAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiainfoAddRadioGroupContainer().setText("認知症情報提供加算");

      dementiainfoAddRadioGroup.setBindPath("1520139");

      dementiainfoAddRadioGroup.setNoSelectIndex(0);

      dementiainfoAddRadioGroup.setUseClearButton(false);

      dementiainfoAddRadioGroup.setModel(getDementiainfoAddRadioGroupModel());

      dementiainfoAddRadioGroup.setValues(new int[]{1,2});

      addDementiainfoAddRadioGroup();
    }
    return dementiainfoAddRadioGroup;

  }

  /**
   * 認知症情報提供加算コンテナを取得します。
   * @return 認知症情報提供加算コンテナ
   */
  protected ACLabelContainer getDementiainfoAddRadioGroupContainer(){
    if(dementiainfoAddRadioGroupContainer==null){
      dementiainfoAddRadioGroupContainer = new ACLabelContainer();
      dementiainfoAddRadioGroupContainer.setFollowChildEnabled(true);
      dementiainfoAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      dementiainfoAddRadioGroupContainer.add(getDementiainfoAddRadioGroup(), null);
    }
    return dementiainfoAddRadioGroupContainer;
  }

  /**
   * 認知症情報提供加算モデルを取得します。
   * @return 認知症情報提供加算モデル
   */
  protected ACListModelAdapter getDementiainfoAddRadioGroupModel(){
    if(dementiainfoAddRadioGroupModel==null){
      dementiainfoAddRadioGroupModel = new ACListModelAdapter();
      addDementiainfoAddRadioGroupModel();
    }
    return dementiainfoAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getDementiainfoAddRadioItem1(){
    if(dementiainfoAddRadioItem1==null){

      dementiainfoAddRadioItem1 = new ACRadioButtonItem();

      dementiainfoAddRadioItem1.setText("なし");

      dementiainfoAddRadioItem1.setGroup(getDementiainfoAddRadioGroup());

      dementiainfoAddRadioItem1.setConstraints(VRLayout.FLOW);

      addDementiainfoAddRadioItem1();
    }
    return dementiainfoAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getDementiainfoAddRadioItem2(){
    if(dementiainfoAddRadioItem2==null){

      dementiainfoAddRadioItem2 = new ACRadioButtonItem();

      dementiainfoAddRadioItem2.setText("あり");

      dementiainfoAddRadioItem2.setGroup(getDementiainfoAddRadioGroup());

      dementiainfoAddRadioItem2.setConstraints(VRLayout.FLOW);

      addDementiainfoAddRadioItem2();
    }
    return dementiainfoAddRadioItem2;

  }

  /**
   * 認知症行動・心理症状緊急対応加算を取得します。
   * @return 認知症行動・心理症状緊急対応加算
   */
  public ACValueArrayRadioButtonGroup getDementiaEmergencyAddRadioGroup(){
    if(dementiaEmergencyAddRadioGroup==null){

      dementiaEmergencyAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaEmergencyAddRadioGroupContainer().setText("認知症行動・心理症状緊急対応加算");

      dementiaEmergencyAddRadioGroup.setBindPath("1520146");

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
   * 身体拘束廃止未実施減算を取得します。
   * @return 身体拘束廃止未実施減算
   */
  public ACValueArrayRadioButtonGroup getBodyRestraintAbolitionRadio(){
    if(bodyRestraintAbolitionRadio==null){

      bodyRestraintAbolitionRadio = new ACValueArrayRadioButtonGroup();

      getBodyRestraintAbolitionRadioContainer().setText("身体拘束廃止未実施減算");

      bodyRestraintAbolitionRadio.setBindPath("1520130");

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
   * タブ4を取得します。
   * @return タブ4
   */
  public ACPanel getTab4(){
    if(tab4==null){

      tab4 = new ACPanel();

      tab4.setFollowChildEnabled(true);

      tab4.setHgap(0);

      tab4.setLabelMargin(0);

      tab4.setVgap(0);

      addTab4();
    }
    return tab4;

  }

  /**
   * 退所関連加算を取得します。
   * @return 退所関連加算
   */
  public ACLabelContainer getKaigoHealthCareOfTheAgedHijoAddition(){
    if(kaigoHealthCareOfTheAgedHijoAddition==null){

      kaigoHealthCareOfTheAgedHijoAddition = new ACLabelContainer();

      kaigoHealthCareOfTheAgedHijoAddition.setText("退所関連加算");

      kaigoHealthCareOfTheAgedHijoAddition.setFollowChildEnabled(true);

      addKaigoHealthCareOfTheAgedHijoAddition();
    }
    return kaigoHealthCareOfTheAgedHijoAddition;

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
   * 在宅復帰在宅療養支援加算を取得します。
   * @return 在宅復帰在宅療養支援加算
   */
  public ACValueArrayRadioButtonGroup getStayReturnSupportRyoyoAddRadio(){
    if(stayReturnSupportRyoyoAddRadio==null){

      stayReturnSupportRyoyoAddRadio = new ACValueArrayRadioButtonGroup();

      getStayReturnSupportRyoyoAddRadioContainer().setText("在宅復帰在宅療養支援加算");

      stayReturnSupportRyoyoAddRadio.setBindPath("1520140");

      stayReturnSupportRyoyoAddRadio.setNoSelectIndex(0);

      stayReturnSupportRyoyoAddRadio.setUseClearButton(false);

      stayReturnSupportRyoyoAddRadio.setModel(getStayReturnSupportRyoyoAddRadioModel());

      stayReturnSupportRyoyoAddRadio.setValues(new int[]{1,2});

      addStayReturnSupportRyoyoAddRadio();
    }
    return stayReturnSupportRyoyoAddRadio;

  }

  /**
   * 在宅復帰在宅療養支援加算コンテナを取得します。
   * @return 在宅復帰在宅療養支援加算コンテナ
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
   * 在宅復帰在宅療養支援加算モデルを取得します。
   * @return 在宅復帰在宅療養支援加算モデル
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
   * 在宅復帰支援機能加算を取得します。
   * @return 在宅復帰支援機能加算
   */
  public ACValueArrayRadioButtonGroup getStayReturnSupportAddRadio(){
    if(stayReturnSupportAddRadio==null){

      stayReturnSupportAddRadio = new ACValueArrayRadioButtonGroup();

      getStayReturnSupportAddRadioContainer().setText("在宅復帰支援機能加算");

      stayReturnSupportAddRadio.setBindPath("1520148");

      stayReturnSupportAddRadio.setNoSelectIndex(0);

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
   * ターミナルケア加算を取得します。
   * @return ターミナルケア加算
   */
  public ACValueArrayRadioButtonGroup getTerminalRadio(){
    if(terminalRadio==null){

      terminalRadio = new ACValueArrayRadioButtonGroup();

      getTerminalRadioContainer().setText("ターミナルケア加算");

      terminalRadio.setBindPath("1520141");

      terminalRadio.setNoSelectIndex(0);

      terminalRadio.setUseClearButton(false);

      terminalRadio.setModel(getTerminalRadioModel());

      terminalRadio.setValues(new int[]{1,2,3,4});

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

      terminalRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addTerminalRadioItem1();
    }
    return terminalRadioItem1;

  }

  /**
   * 死亡日以前4日以上30日以下を取得します。
   * @return 死亡日以前4日以上30日以下
   */
  public ACRadioButtonItem getTerminalRadioItem2(){
    if(terminalRadioItem2==null){

      terminalRadioItem2 = new ACRadioButtonItem();

      terminalRadioItem2.setText("死亡日以前4日以上30日以下");

      terminalRadioItem2.setGroup(getTerminalRadio());

      terminalRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addTerminalRadioItem2();
    }
    return terminalRadioItem2;

  }

  /**
   * 死亡日以前2日又は3日を取得します。
   * @return 死亡日以前2日又は3日
   */
  public ACRadioButtonItem getTerminalRadioItem3(){
    if(terminalRadioItem3==null){

      terminalRadioItem3 = new ACRadioButtonItem();

      terminalRadioItem3.setText("死亡日以前2日又は3日");

      terminalRadioItem3.setGroup(getTerminalRadio());

      terminalRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addTerminalRadioItem3();
    }
    return terminalRadioItem3;

  }

  /**
   * 死亡日を取得します。
   * @return 死亡日
   */
  public ACRadioButtonItem getTerminalRadioItem4(){
    if(terminalRadioItem4==null){

      terminalRadioItem4 = new ACRadioButtonItem();

      terminalRadioItem4.setText("死亡日");

      terminalRadioItem4.setGroup(getTerminalRadio());

      terminalRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addTerminalRadioItem4();
    }
    return terminalRadioItem4;

  }

  /**
   * ターミナルケア加算コンテナを取得します。
   * @return ターミナルケア加算コンテナ
   */
  public ACLabelContainer getTerminalDaysContainer(){
    if(terminalDaysContainer==null){

      terminalDaysContainer = new ACLabelContainer();

      terminalDaysContainer.setText("ターミナルケア加算日数");

      terminalDaysContainer.setFollowChildEnabled(true);

      addTerminalDaysContainer();
    }
    return terminalDaysContainer;

  }

  /**
   * ターミナルケア加算日数を取得します。
   * @return ターミナルケア加算日数
   */
  public ACTextField getTerminalDays(){
    if(terminalDays==null){

      terminalDays = new ACTextField();

      terminalDays.setText("1");

      terminalDays.setBindPath("1520150");

      terminalDays.setColumns(2);

      terminalDays.setCharType(VRCharType.ONLY_DIGIT);

      terminalDays.setHorizontalAlignment(SwingConstants.RIGHT);

      terminalDays.setMaxLength(2);

      addTerminalDays();
    }
    return terminalDays;

  }

  /**
   * ターミナルケア加算日数単位を取得します。
   * @return ターミナルケア加算日数単位
   */
  public ACLabel getTerminalDaysUnit(){
    if(terminalDaysUnit==null){

      terminalDaysUnit = new ACLabel();

      terminalDaysUnit.setText("日");

      addTerminalDaysUnit();
    }
    return terminalDaysUnit;

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

      tab5.setLabelMargin(0);

      tab5.setVgap(0);

      addTab5();
    }
    return tab5;

  }

  /**
   * サービス提供体制強化加算を取得します。
   * @return サービス提供体制強化加算
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("サービス提供体制強化加算");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1520142");

      serviceAddProvisionStructuralRadioGroup.setVisible(true);

      serviceAddProvisionStructuralRadioGroup.setEnabled(true);

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,2,3,4});

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
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("I型");

      serviceAddProvisionStructuralRadioItem2.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

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
   * 入所前後訪問指導加算を取得します。
   * @return 入所前後訪問指導加算
   */
  public ACValueArrayRadioButtonGroup getEnterHospitalPreConsultantRadio(){
    if(enterHospitalPreConsultantRadio==null){

      enterHospitalPreConsultantRadio = new ACValueArrayRadioButtonGroup();

      getEnterHospitalPreConsultantRadioContainer().setText("入所前後訪問指導加算");

      enterHospitalPreConsultantRadio.setBindPath("1520144");

      enterHospitalPreConsultantRadio.setUseClearButton(false);

      enterHospitalPreConsultantRadio.setModel(getEnterHospitalPreConsultantRadioModel());

      enterHospitalPreConsultantRadio.setValues(new int[]{1,2});

      addEnterHospitalPreConsultantRadio();
    }
    return enterHospitalPreConsultantRadio;

  }

  /**
   * 入所前後訪問指導加算コンテナを取得します。
   * @return 入所前後訪問指導加算コンテナ
   */
  protected ACLabelContainer getEnterHospitalPreConsultantRadioContainer(){
    if(enterHospitalPreConsultantRadioContainer==null){
      enterHospitalPreConsultantRadioContainer = new ACLabelContainer();
      enterHospitalPreConsultantRadioContainer.setFollowChildEnabled(true);
      enterHospitalPreConsultantRadioContainer.setVAlignment(VRLayout.CENTER);
      enterHospitalPreConsultantRadioContainer.add(getEnterHospitalPreConsultantRadio(), null);
    }
    return enterHospitalPreConsultantRadioContainer;
  }

  /**
   * 入所前後訪問指導加算モデルを取得します。
   * @return 入所前後訪問指導加算モデル
   */
  protected ACListModelAdapter getEnterHospitalPreConsultantRadioModel(){
    if(enterHospitalPreConsultantRadioModel==null){
      enterHospitalPreConsultantRadioModel = new ACListModelAdapter();
      addEnterHospitalPreConsultantRadioModel();
    }
    return enterHospitalPreConsultantRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getEnterHospitalPreConsultantRadioItem1(){
    if(enterHospitalPreConsultantRadioItem1==null){

      enterHospitalPreConsultantRadioItem1 = new ACRadioButtonItem();

      enterHospitalPreConsultantRadioItem1.setText("なし");

      enterHospitalPreConsultantRadioItem1.setGroup(getEnterHospitalPreConsultantRadio());

      enterHospitalPreConsultantRadioItem1.setConstraints(VRLayout.FLOW);

      addEnterHospitalPreConsultantRadioItem1();
    }
    return enterHospitalPreConsultantRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getEnterHospitalPreConsultantRadioItem2(){
    if(enterHospitalPreConsultantRadioItem2==null){

      enterHospitalPreConsultantRadioItem2 = new ACRadioButtonItem();

      enterHospitalPreConsultantRadioItem2.setText("あり");

      enterHospitalPreConsultantRadioItem2.setGroup(getEnterHospitalPreConsultantRadio());

      enterHospitalPreConsultantRadioItem2.setConstraints(VRLayout.FLOW);

      addEnterHospitalPreConsultantRadioItem2();
    }
    return enterHospitalPreConsultantRadioItem2;

  }

  /**
   * 所定疾患施設療養費を取得します。
   * @return 所定疾患施設療養費
   */
  public ACValueArrayRadioButtonGroup getPneumoniaTreatmentRadio(){
    if(pneumoniaTreatmentRadio==null){

      pneumoniaTreatmentRadio = new ACValueArrayRadioButtonGroup();

      getPneumoniaTreatmentRadioContainer().setText("所定疾患施設療養費");

      pneumoniaTreatmentRadio.setBindPath("1520145");

      pneumoniaTreatmentRadio.setUseClearButton(false);

      pneumoniaTreatmentRadio.setModel(getPneumoniaTreatmentRadioModel());

      pneumoniaTreatmentRadio.setValues(new int[]{1,2});

      addPneumoniaTreatmentRadio();
    }
    return pneumoniaTreatmentRadio;

  }

  /**
   * 所定疾患施設療養費コンテナを取得します。
   * @return 所定疾患施設療養費コンテナ
   */
  protected ACLabelContainer getPneumoniaTreatmentRadioContainer(){
    if(pneumoniaTreatmentRadioContainer==null){
      pneumoniaTreatmentRadioContainer = new ACLabelContainer();
      pneumoniaTreatmentRadioContainer.setFollowChildEnabled(true);
      pneumoniaTreatmentRadioContainer.setVAlignment(VRLayout.CENTER);
      pneumoniaTreatmentRadioContainer.add(getPneumoniaTreatmentRadio(), null);
    }
    return pneumoniaTreatmentRadioContainer;
  }

  /**
   * 所定疾患施設療養費モデルを取得します。
   * @return 所定疾患施設療養費モデル
   */
  protected ACListModelAdapter getPneumoniaTreatmentRadioModel(){
    if(pneumoniaTreatmentRadioModel==null){
      pneumoniaTreatmentRadioModel = new ACListModelAdapter();
      addPneumoniaTreatmentRadioModel();
    }
    return pneumoniaTreatmentRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getPneumoniaTreatmentRadioItem1(){
    if(pneumoniaTreatmentRadioItem1==null){

      pneumoniaTreatmentRadioItem1 = new ACRadioButtonItem();

      pneumoniaTreatmentRadioItem1.setText("なし");

      pneumoniaTreatmentRadioItem1.setGroup(getPneumoniaTreatmentRadio());

      pneumoniaTreatmentRadioItem1.setConstraints(VRLayout.FLOW);

      addPneumoniaTreatmentRadioItem1();
    }
    return pneumoniaTreatmentRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getPneumoniaTreatmentRadioItem2(){
    if(pneumoniaTreatmentRadioItem2==null){

      pneumoniaTreatmentRadioItem2 = new ACRadioButtonItem();

      pneumoniaTreatmentRadioItem2.setText("あり");

      pneumoniaTreatmentRadioItem2.setGroup(getPneumoniaTreatmentRadio());

      pneumoniaTreatmentRadioItem2.setConstraints(VRLayout.FLOW);

      addPneumoniaTreatmentRadioItem2();
    }
    return pneumoniaTreatmentRadioItem2;

  }

  /**
   * 地域連携診療計画情報提供加算を取得します。
   * @return 地域連携診療計画情報提供加算
   */
  public ACValueArrayRadioButtonGroup getLocalTreatmentPlanInfoAddRadio(){
    if(localTreatmentPlanInfoAddRadio==null){

      localTreatmentPlanInfoAddRadio = new ACValueArrayRadioButtonGroup();

      getLocalTreatmentPlanInfoAddRadioContainer().setText("地域連携診療計画情報提供加算");

      localTreatmentPlanInfoAddRadio.setBindPath("1520147");

      localTreatmentPlanInfoAddRadio.setUseClearButton(false);

      localTreatmentPlanInfoAddRadio.setModel(getLocalTreatmentPlanInfoAddRadioModel());

      localTreatmentPlanInfoAddRadio.setValues(new int[]{1,2});

      addLocalTreatmentPlanInfoAddRadio();
    }
    return localTreatmentPlanInfoAddRadio;

  }

  /**
   * 地域連携診療計画情報提供加算コンテナを取得します。
   * @return 地域連携診療計画情報提供加算コンテナ
   */
  protected ACLabelContainer getLocalTreatmentPlanInfoAddRadioContainer(){
    if(localTreatmentPlanInfoAddRadioContainer==null){
      localTreatmentPlanInfoAddRadioContainer = new ACLabelContainer();
      localTreatmentPlanInfoAddRadioContainer.setFollowChildEnabled(true);
      localTreatmentPlanInfoAddRadioContainer.setVAlignment(VRLayout.CENTER);
      localTreatmentPlanInfoAddRadioContainer.add(getLocalTreatmentPlanInfoAddRadio(), null);
    }
    return localTreatmentPlanInfoAddRadioContainer;
  }

  /**
   * 地域連携診療計画情報提供加算モデルを取得します。
   * @return 地域連携診療計画情報提供加算モデル
   */
  protected ACListModelAdapter getLocalTreatmentPlanInfoAddRadioModel(){
    if(localTreatmentPlanInfoAddRadioModel==null){
      localTreatmentPlanInfoAddRadioModel = new ACListModelAdapter();
      addLocalTreatmentPlanInfoAddRadioModel();
    }
    return localTreatmentPlanInfoAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getLocalTreatmentPlanInfoAddRadioItem1(){
    if(localTreatmentPlanInfoAddRadioItem1==null){

      localTreatmentPlanInfoAddRadioItem1 = new ACRadioButtonItem();

      localTreatmentPlanInfoAddRadioItem1.setText("なし");

      localTreatmentPlanInfoAddRadioItem1.setGroup(getLocalTreatmentPlanInfoAddRadio());

      localTreatmentPlanInfoAddRadioItem1.setConstraints(VRLayout.FLOW);

      addLocalTreatmentPlanInfoAddRadioItem1();
    }
    return localTreatmentPlanInfoAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getLocalTreatmentPlanInfoAddRadioItem2(){
    if(localTreatmentPlanInfoAddRadioItem2==null){

      localTreatmentPlanInfoAddRadioItem2 = new ACRadioButtonItem();

      localTreatmentPlanInfoAddRadioItem2.setText("あり");

      localTreatmentPlanInfoAddRadioItem2.setGroup(getLocalTreatmentPlanInfoAddRadio());

      localTreatmentPlanInfoAddRadioItem2.setConstraints(VRLayout.FLOW);

      addLocalTreatmentPlanInfoAddRadioItem2();
    }
    return localTreatmentPlanInfoAddRadioItem2;

  }

  /**
   * 算定区分を取得します。
   * @return 算定区分
   */
  public ACValueArrayRadioButtonGroup getKaigoHealthCareOfTheAgedCalculationDivisionRadio(){
    if(kaigoHealthCareOfTheAgedCalculationDivisionRadio==null){

      kaigoHealthCareOfTheAgedCalculationDivisionRadio = new ACValueArrayRadioButtonGroup();

      getKaigoHealthCareOfTheAgedCalculationDivisionRadioContainer().setText("算定区分");

      kaigoHealthCareOfTheAgedCalculationDivisionRadio.setBindPath("9");

      kaigoHealthCareOfTheAgedCalculationDivisionRadio.setUseClearButton(false);

      kaigoHealthCareOfTheAgedCalculationDivisionRadio.setModel(getKaigoHealthCareOfTheAgedCalculationDivisionRadioModel());

      kaigoHealthCareOfTheAgedCalculationDivisionRadio.setValues(new int[]{1,2});

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
  public QS001_15211_201204Design() {

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

    tab1.add(getKaigoHealthCareOfTheAgedDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getKaigoHealthCareOfTheAgedHospitalDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getKaigoHealthCareOfTheAgedHospitalRoomContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getKaigoHealthCareOfTheAgedNightShiftSubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortConcentrationRehabiliContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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

    getKaigoHealthCareOfTheAgedDivisionRadioItem2().setButtonIndex(2);

    getKaigoHealthCareOfTheAgedDivisionRadioModel().add(getKaigoHealthCareOfTheAgedDivisionRadioItem2());

    getKaigoHealthCareOfTheAgedDivisionRadioItem3().setButtonIndex(3);

    getKaigoHealthCareOfTheAgedDivisionRadioModel().add(getKaigoHealthCareOfTheAgedDivisionRadioItem3());

    getKaigoHealthCareOfTheAgedDivisionRadioItem4().setButtonIndex(4);

    getKaigoHealthCareOfTheAgedDivisionRadioModel().add(getKaigoHealthCareOfTheAgedDivisionRadioItem4());

    getKaigoHealthCareOfTheAgedDivisionRadioItem5().setButtonIndex(5);

    getKaigoHealthCareOfTheAgedDivisionRadioModel().add(getKaigoHealthCareOfTheAgedDivisionRadioItem5());

    getKaigoHealthCareOfTheAgedDivisionRadioItem6().setButtonIndex(6);

    getKaigoHealthCareOfTheAgedDivisionRadioModel().add(getKaigoHealthCareOfTheAgedDivisionRadioItem6());

  }

  /**
   * 介護老人保健施設（I）に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedDivisionRadioItem1(){

  }

  /**
   * ユニット型介護老人保健施設（I）に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedDivisionRadioItem2(){

  }

  /**
   * 介護老人保健施設（II）に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedDivisionRadioItem3(){

  }

  /**
   * ユニット型介護老人保健施設（II）に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedDivisionRadioItem4(){

  }

  /**
   * 介護老人保健施設（III）に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedDivisionRadioItem5(){

  }

  /**
   * ユニット型介護老人保健施設（III）に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedDivisionRadioItem6(){

  }

  /**
   * 人員配置区分コンテナに内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedHospitalDivisionContainer(){

    kaigoHealthCareOfTheAgedHospitalDivisionContainer.add(getKaigoHealthCareOfTheAgedHospitalDivision1(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoHealthCareOfTheAgedHospitalDivisionContainer.add(getKaigoHealthCareOfTheAgedHospitalDivision2(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 人員配置区分に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedHospitalDivision1(){

  }

  /**
   * 人員配置区分モデルに内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedHospitalDivision1Model(){

    getKaigoHealthCareOfTheAgedHospitalDivision11().setButtonIndex(1);

    getKaigoHealthCareOfTheAgedHospitalDivision1Model().add(getKaigoHealthCareOfTheAgedHospitalDivision11());

    getKaigoHealthCareOfTheAgedHospitalDivision12().setButtonIndex(2);

    getKaigoHealthCareOfTheAgedHospitalDivision1Model().add(getKaigoHealthCareOfTheAgedHospitalDivision12());

  }

  /**
   * 従来型に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedHospitalDivision11(){

  }

  /**
   * 在宅強化型に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedHospitalDivision12(){

  }

  /**
   * 人員配置区分（療養型）に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedHospitalDivision2(){

  }

  /**
   * 人員配置区分（療養型）モデルに内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedHospitalDivision2Model(){

    getKaigoHealthCareOfTheAgedHospitalDivision21().setButtonIndex(1);

    getKaigoHealthCareOfTheAgedHospitalDivision2Model().add(getKaigoHealthCareOfTheAgedHospitalDivision21());

    getKaigoHealthCareOfTheAgedHospitalDivision22().setButtonIndex(2);

    getKaigoHealthCareOfTheAgedHospitalDivision2Model().add(getKaigoHealthCareOfTheAgedHospitalDivision22());

  }

  /**
   * 療養型に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedHospitalDivision21(){

  }

  /**
   * 療養強化型に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedHospitalDivision22(){

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
   * タブ2に内部項目を追加します。
   */
  protected void addTab2(){

    tab2.add(getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getKaigoHealthCareOfTheAgedDefaultRadioContainer(), VRLayout.FLOW_INSETLINE);

    tab2.add(getKaigoHealthCareOfTheAgedEmergencyRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getKaigoHealthCareOfTheAgedNutritionRadioContainer(), VRLayout.FLOW_INSETLINE);

    tab2.add(getKaigoHealthCareOfTheAgedOralSwitchRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getOralMaintenanceAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getOralKeepStructureAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getOralKeepAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getKaigoHealthCareOfTheAgedRecuperateDinnerRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getSpecialMedicalExpense(), VRLayout.FLOW);

    tab2.add(getSpecialMedicalExpenseLabel(), VRLayout.FLOW_RETURN);

    tab2.add(getKaigoHealthCareOfTheAgedDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

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
   * 緊急時施設療養費に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedEmergencyRadio(){

  }

  /**
   * 緊急時施設療養費モデルに内部項目を追加します。
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
   * 口腔機能維持管理体制加算に内部項目を追加します。
   */
  protected void addOralKeepStructureAddRadioGroup(){

  }

  /**
   * 口腔機能維持管理体制加算モデルに内部項目を追加します。
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
   * 口腔機能維持管理加算に内部項目を追加します。
   */
  protected void addOralKeepAddRadioGroup(){

  }

  /**
   * 口腔機能維持管理加算モデルに内部項目を追加します。
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
   * タブ3に内部項目を追加します。
   */
  protected void addTab3(){

    tab3.add(getKaigoHealthCareOfTheAgedStaffSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getUnitCareMaintenanceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getRecuperationRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getNightStaffDispositionAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getIntentionCommunicationDifficultyAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getDementiaProfessionalCareAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getDementiainfoAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getDementiaEmergencyAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getBodyRestraintAbolitionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * 看護・介護職員又は医師、PT・OT・ST、介護支援専門員の不足に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedStaffSubtractionPersonLack(){

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
   * 認知症情報提供加算に内部項目を追加します。
   */
  protected void addDementiainfoAddRadioGroup(){

  }

  /**
   * 認知症情報提供加算モデルに内部項目を追加します。
   */
  protected void addDementiainfoAddRadioGroupModel(){

    getDementiainfoAddRadioItem1().setButtonIndex(1);

    getDementiainfoAddRadioGroupModel().add(getDementiainfoAddRadioItem1());

    getDementiainfoAddRadioItem2().setButtonIndex(2);

    getDementiainfoAddRadioGroupModel().add(getDementiainfoAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addDementiainfoAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addDementiainfoAddRadioItem2(){

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
   * タブ4に内部項目を追加します。
   */
  protected void addTab4(){

    tab4.add(getKaigoHealthCareOfTheAgedHijoAddition(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getStayReturnSupportRyoyoAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getStayReturnSupportAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getTerminalRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getTerminalDaysContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 退所関連加算に内部項目を追加します。
   */
  protected void addKaigoHealthCareOfTheAgedHijoAddition(){

    kaigoHealthCareOfTheAgedHijoAddition.add(getLeavingHospitalPreConsultationAddition(), VRLayout.FLOW_RETURN);

    kaigoHealthCareOfTheAgedHijoAddition.add(getLeavingHospitalAfterConsultationAddition(), VRLayout.FLOW_RETURN);

    kaigoHealthCareOfTheAgedHijoAddition.add(getLeavingHospitalConsultationAddition(), VRLayout.FLOW_RETURN);

    kaigoHealthCareOfTheAgedHijoAddition.add(getLeavingHospitalDissemination(), VRLayout.FLOW_RETURN);

    kaigoHealthCareOfTheAgedHijoAddition.add(getLeavingHospitalCooperationAddition(), VRLayout.FLOW_RETURN);

    kaigoHealthCareOfTheAgedHijoAddition.add(getLeavingHospital(), VRLayout.FLOW_RETURN);

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
   * 在宅復帰在宅療養支援加算に内部項目を追加します。
   */
  protected void addStayReturnSupportRyoyoAddRadio(){

  }

  /**
   * 在宅復帰在宅療養支援加算モデルに内部項目を追加します。
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

    getTerminalRadioItem3().setButtonIndex(3);

    getTerminalRadioModel().add(getTerminalRadioItem3());

    getTerminalRadioItem4().setButtonIndex(4);

    getTerminalRadioModel().add(getTerminalRadioItem4());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTerminalRadioItem1(){

  }

  /**
   * 死亡日以前4日以上30日以下に内部項目を追加します。
   */
  protected void addTerminalRadioItem2(){

  }

  /**
   * 死亡日以前2日又は3日に内部項目を追加します。
   */
  protected void addTerminalRadioItem3(){

  }

  /**
   * 死亡日に内部項目を追加します。
   */
  protected void addTerminalRadioItem4(){

  }

  /**
   * ターミナルケア加算コンテナに内部項目を追加します。
   */
  protected void addTerminalDaysContainer(){

    terminalDaysContainer.add(getTerminalDays(), VRLayout.FLOW);

    terminalDaysContainer.add(getTerminalDaysUnit(), VRLayout.FLOW);

  }

  /**
   * ターミナルケア加算日数に内部項目を追加します。
   */
  protected void addTerminalDays(){

  }

  /**
   * ターミナルケア加算日数単位に内部項目を追加します。
   */
  protected void addTerminalDaysUnit(){

  }

  /**
   * タブ5に内部項目を追加します。
   */
  protected void addTab5(){

    tab5.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab5.add(getEnterHospitalPreConsultantRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab5.add(getPneumoniaTreatmentRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab5.add(getLocalTreatmentPlanInfoAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab5.add(getKaigoHealthCareOfTheAgedCalculationDivisionRadioContainer(), VRLayout.FLOW_INSETLINE);

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

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem1(){

  }

  /**
   * I型に内部項目を追加します。
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
   * 入所前後訪問指導加算に内部項目を追加します。
   */
  protected void addEnterHospitalPreConsultantRadio(){

  }

  /**
   * 入所前後訪問指導加算モデルに内部項目を追加します。
   */
  protected void addEnterHospitalPreConsultantRadioModel(){

    getEnterHospitalPreConsultantRadioItem1().setButtonIndex(1);

    getEnterHospitalPreConsultantRadioModel().add(getEnterHospitalPreConsultantRadioItem1());

    getEnterHospitalPreConsultantRadioItem2().setButtonIndex(2);

    getEnterHospitalPreConsultantRadioModel().add(getEnterHospitalPreConsultantRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addEnterHospitalPreConsultantRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addEnterHospitalPreConsultantRadioItem2(){

  }

  /**
   * 所定疾患施設療養費に内部項目を追加します。
   */
  protected void addPneumoniaTreatmentRadio(){

  }

  /**
   * 所定疾患施設療養費モデルに内部項目を追加します。
   */
  protected void addPneumoniaTreatmentRadioModel(){

    getPneumoniaTreatmentRadioItem1().setButtonIndex(1);

    getPneumoniaTreatmentRadioModel().add(getPneumoniaTreatmentRadioItem1());

    getPneumoniaTreatmentRadioItem2().setButtonIndex(2);

    getPneumoniaTreatmentRadioModel().add(getPneumoniaTreatmentRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addPneumoniaTreatmentRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addPneumoniaTreatmentRadioItem2(){

  }

  /**
   * 地域連携診療計画情報提供加算に内部項目を追加します。
   */
  protected void addLocalTreatmentPlanInfoAddRadio(){

  }

  /**
   * 地域連携診療計画情報提供加算モデルに内部項目を追加します。
   */
  protected void addLocalTreatmentPlanInfoAddRadioModel(){

    getLocalTreatmentPlanInfoAddRadioItem1().setButtonIndex(1);

    getLocalTreatmentPlanInfoAddRadioModel().add(getLocalTreatmentPlanInfoAddRadioItem1());

    getLocalTreatmentPlanInfoAddRadioItem2().setButtonIndex(2);

    getLocalTreatmentPlanInfoAddRadioModel().add(getLocalTreatmentPlanInfoAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addLocalTreatmentPlanInfoAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addLocalTreatmentPlanInfoAddRadioItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_15211_201204Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001_15211_201204Design getThis() {
    return this;
  }
}
