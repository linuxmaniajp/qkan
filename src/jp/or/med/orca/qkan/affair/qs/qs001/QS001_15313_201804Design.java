
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
 * 作成日: 2018/03/15  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン介護療養型医療施設（認知症） (QS001_15313_201804)
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
 * サービスパターン介護療養型医療施設（認知症）画面項目デザイン(QS001_15313_201804) 
 */
public class QS001_15313_201804Design extends QS001ServicePanel {
  //GUIコンポーネント

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup medicalFacilityCognitiveHospitalInstitutionDivisionRadio;

  private ACLabelContainer medicalFacilityCognitiveHospitalInstitutionDivisionRadioContainer;

  private ACListModelAdapter medicalFacilityCognitiveHospitalInstitutionDivisionRadioModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem2;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem3;

  private ACValueArrayRadioButtonGroup hospitalDivisionRadio;

  private ACLabelContainer hospitalDivisionRadioContainer;

  private ACListModelAdapter hospitalDivisionRadioModel;

  private ACRadioButtonItem hospitalDivisionRadioItem1;

  private ACRadioButtonItem hospitalDivisionRadioItem2;

  private ACValueArrayRadioButtonGroup medicalFacilityCognitiveHospitalHospitalDivision;

  private ACLabelContainer medicalFacilityCognitiveHospitalHospitalDivisionContainer;

  private ACListModelAdapter medicalFacilityCognitiveHospitalHospitalDivisionModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalDivision1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalDivision2;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalDivision3;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalDivision4;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalDivision5;

  private ACLabelContainer medicalFacilityCognitiveHospitalHospitalRoomContena;

  private ACValueArrayRadioButtonGroup medicalFacilityCognitiveHospitalHospitalRoomRadio;

  private ACListModelAdapter medicalFacilityCognitiveHospitalHospitalRoomRadioModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalHospitalRoomRadioItem1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalHospitalRoomRadioItem2;

  private ACValueArrayRadioButtonGroup medicalFacilityCognitiveHospitalUnitHospitalRoomRadio;

  private ACListModelAdapter medicalFacilityCognitiveHospitalUnitHospitalRoomRadioModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem2;

  private ACValueArrayRadioButtonGroup hospitalizedPatientsCriteriaRadio;

  private ACLabelContainer hospitalizedPatientsCriteriaRadioContainer;

  private ACListModelAdapter hospitalizedPatientsCriteriaRadioModel;

  private ACRadioButtonItem hospitalizedPatientsCriteriaRadioItem1;

  private ACRadioButtonItem hospitalizedPatientsCriteriaRadioItem2;

  private ACValueArrayRadioButtonGroup unitCareMaintenanceRadio;

  private ACLabelContainer unitCareMaintenanceRadioContainer;

  private ACListModelAdapter unitCareMaintenanceRadioModel;

  private ACRadioButtonItem unitCareMaintenanceRadioItem1;

  private ACRadioButtonItem unitCareMaintenanceRadioItem2;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup medicalFacilityCognitiveHospitalStayRadio;

  private ACLabelContainer medicalFacilityCognitiveHospitalStayRadioContainer;

  private ACListModelAdapter medicalFacilityCognitiveHospitalStayRadioModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalStayRadioItem1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalStayRadioItem2;

  private ACValueArrayRadioButtonGroup medicalFacilityCognitiveHospitalStandardRadio;

  private ACLabelContainer medicalFacilityCognitiveHospitalStandardRadioContainer;

  private ACListModelAdapter medicalFacilityCognitiveHospitalStandardRadioModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalStandardRadioItem1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalStandardRadioItem2;

  private ACValueArrayRadioButtonGroup medicalFacilityCognitiveHospitalMedicalExaminationRadio;

  private ACLabelContainer medicalFacilityCognitiveHospitalMedicalExaminationRadioContainer;

  private ACListModelAdapter medicalFacilityCognitiveHospitalMedicalExaminationRadioModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalMedicalExaminationRadioItem1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalMedicalExaminationRadioItem2;

  private ACValueArrayRadioButtonGroup medicalFacilityCognitiveHospitalNutritionRadio;

  private ACLabelContainer medicalFacilityCognitiveHospitalNutritionRadioContainer;

  private ACListModelAdapter medicalFacilityCognitiveHospitalNutritionRadioModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalNutritionRadioItem1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalNutritionRadioItem2;

  private ACValueArrayRadioButtonGroup medicalFacilityCognitiveHospitalOralSwitchRadio;

  private ACLabelContainer medicalFacilityCognitiveHospitalOralSwitchRadioContainer;

  private ACListModelAdapter medicalFacilityCognitiveHospitalOralSwitchRadioModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalOralSwitchRadioItem1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalOralSwitchRadioItem2;

  private ACLabelContainer oralMaintenanceAddContainer;

  private ACValueArrayRadioButtonGroup oralMaintenanceAdd;

  private ACListModelAdapter oralMaintenanceAddModel;

  private ACRadioButtonItem oralMaintenanceAddItem1;

  private ACRadioButtonItem oralMaintenanceAddItem2;

  private ACIntegerCheckBox oralMaintenanceAddItem3;

  private ACValueArrayRadioButtonGroup oralKeepStructureAddRadioGroup;

  private ACLabelContainer oralKeepStructureAddRadioGroupContainer;

  private ACListModelAdapter oralKeepStructureAddRadioGroupModel;

  private ACRadioButtonItem oralKeepStructureAddRadioItem1;

  private ACRadioButtonItem oralKeepStructureAddRadioItem2;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACValueArrayRadioButtonGroup medicalFacilityCognitiveHospitalRecuperateDinnerRadio;

  private ACLabelContainer medicalFacilityCognitiveHospitalRecuperateDinnerRadioContainer;

  private ACListModelAdapter medicalFacilityCognitiveHospitalRecuperateDinnerRadioModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem2;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem3;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem4;

  private ACPanel tab3;

  private ACLabelContainer medicalFacilityCognitiveHospitalHijoAddition;

  private ACIntegerCheckBox leavingHospitalPreConsultationAddition;

  private ACIntegerCheckBox leavingHospitalAfterConsultationAddition;

  private ACIntegerCheckBox leavingHospitalConsultationAddition;

  private ACIntegerCheckBox leavingHospitalDissemination;

  private ACIntegerCheckBox leavingHospitalCooperationAddition;

  private ACIntegerCheckBox leavingHospital;

  private ACMapBindButton medicalFacilityCognitiveHospitalConsultationFee;

  private ACLabel medicalFacilityCognitiveHospitalConsultationFeeLabel;

  private ACComboBox medicalFacilityCognitiveHospitalSubstraction;

  private ACLabelContainer medicalFacilityCognitiveHospitalSubstractionContainer;

  private ACComboBoxModelAdapter medicalFacilityCognitiveHospitalSubstractionModel;

  private ACBackLabelContainer medicalFacilityCognitiveHospitalDinnerContainer;

  private ACComboBox medicalFacilityCognitiveHospitalDinnerOffer;

  private ACLabelContainer medicalFacilityCognitiveHospitalDinnerOfferContainer;

  private ACComboBoxModelAdapter medicalFacilityCognitiveHospitalDinnerOfferModel;

  private ACTextField medicalFacilityCognitiveHospitalDinnerCost;

  private ACLabelContainer medicalFacilityCognitiveHospitalDinnerCostContainer;

  private ACPanel tab4;

  private ACValueArrayRadioButtonGroup bodyRestraintAbolitionRadio;

  private ACLabelContainer bodyRestraintAbolitionRadioContainer;

  private ACListModelAdapter bodyRestraintAbolitionRadioModel;

  private ACRadioButtonItem bodyRestraintAbolitionRadioItem1;

  private ACRadioButtonItem bodyRestraintAbolitionRadioItem2;

  private ACValueArrayRadioButtonGroup stayReturnSupportAddRadio;

  private ACLabelContainer stayReturnSupportAddRadioContainer;

  private ACListModelAdapter stayReturnSupportAddRadioModel;

  private ACRadioButtonItem stayReturnSupportAddRadioitem1;

  private ACRadioButtonItem stayReturnSupportAddRadioitem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem5;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACValueArrayRadioButtonGroup lowNutritionalRiskImprovementAdd;

  private ACLabelContainer lowNutritionalRiskImprovementAddContainer;

  private ACListModelAdapter lowNutritionalRiskImprovementAddModel;

  private ACRadioButtonItem lowNutritionalRiskImprovementAddItem1;

  private ACRadioButtonItem lowNutritionalRiskImprovementAddItem2;

  private ACValueArrayRadioButtonGroup excretionSupport;

  private ACLabelContainer excretionSupportContainer;

  private ACListModelAdapter excretionSupportModel;

  private ACRadioButtonItem excretionSupportItem1;

  private ACRadioButtonItem excretionSupportItem2;

  private ACValueArrayRadioButtonGroup medicalFacilityCognitiveHospitalCalculationDivisionRadio;

  private ACLabelContainer medicalFacilityCognitiveHospitalCalculationDivisionRadioContainer;

  private ACListModelAdapter medicalFacilityCognitiveHospitalCalculationDivisionRadioModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalCalculationDivisionRadioItem1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalCalculationDivisionRadioItem2;

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
  public ACValueArrayRadioButtonGroup getMedicalFacilityCognitiveHospitalInstitutionDivisionRadio(){
    if(medicalFacilityCognitiveHospitalInstitutionDivisionRadio==null){

      medicalFacilityCognitiveHospitalInstitutionDivisionRadio = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityCognitiveHospitalInstitutionDivisionRadioContainer().setText("施設等の区分");

      medicalFacilityCognitiveHospitalInstitutionDivisionRadio.setBindPath("1530301");

      medicalFacilityCognitiveHospitalInstitutionDivisionRadio.setUseClearButton(false);

      medicalFacilityCognitiveHospitalInstitutionDivisionRadio.setModel(getMedicalFacilityCognitiveHospitalInstitutionDivisionRadioModel());

      medicalFacilityCognitiveHospitalInstitutionDivisionRadio.setValues(new int[]{1,2,3});

      addMedicalFacilityCognitiveHospitalInstitutionDivisionRadio();
    }
    return medicalFacilityCognitiveHospitalInstitutionDivisionRadio;

  }

  /**
   * 施設等の区分コンテナを取得します。
   * @return 施設等の区分コンテナ
   */
  protected ACLabelContainer getMedicalFacilityCognitiveHospitalInstitutionDivisionRadioContainer(){
    if(medicalFacilityCognitiveHospitalInstitutionDivisionRadioContainer==null){
      medicalFacilityCognitiveHospitalInstitutionDivisionRadioContainer = new ACLabelContainer();
      medicalFacilityCognitiveHospitalInstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      medicalFacilityCognitiveHospitalInstitutionDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityCognitiveHospitalInstitutionDivisionRadioContainer.add(getMedicalFacilityCognitiveHospitalInstitutionDivisionRadio(), null);
    }
    return medicalFacilityCognitiveHospitalInstitutionDivisionRadioContainer;
  }

  /**
   * 施設等の区分モデルを取得します。
   * @return 施設等の区分モデル
   */
  protected ACListModelAdapter getMedicalFacilityCognitiveHospitalInstitutionDivisionRadioModel(){
    if(medicalFacilityCognitiveHospitalInstitutionDivisionRadioModel==null){
      medicalFacilityCognitiveHospitalInstitutionDivisionRadioModel = new ACListModelAdapter();
      addMedicalFacilityCognitiveHospitalInstitutionDivisionRadioModel();
    }
    return medicalFacilityCognitiveHospitalInstitutionDivisionRadioModel;
  }

  /**
   * 認知症疾患型を取得します。
   * @return 認知症疾患型
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem1(){
    if(medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem1==null){

      medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem1.setText("認知症疾患型");

      medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem1.setGroup(getMedicalFacilityCognitiveHospitalInstitutionDivisionRadio());

      medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem1();
    }
    return medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem1;

  }

  /**
   * ユニット型認知症疾患型を取得します。
   * @return ユニット型認知症疾患型
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem2(){
    if(medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem2==null){

      medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem2.setText("ユニット型認知症疾患型");

      medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem2.setGroup(getMedicalFacilityCognitiveHospitalInstitutionDivisionRadio());

      medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem2();
    }
    return medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem2;

  }

  /**
   * 経過型を取得します。
   * @return 経過型
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem3(){
    if(medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem3==null){

      medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem3 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem3.setText("経過型");

      medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem3.setGroup(getMedicalFacilityCognitiveHospitalInstitutionDivisionRadio());

      medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem3.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem3();
    }
    return medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem3;

  }

  /**
   * 病院区分を取得します。
   * @return 病院区分
   */
  public ACValueArrayRadioButtonGroup getHospitalDivisionRadio(){
    if(hospitalDivisionRadio==null){

      hospitalDivisionRadio = new ACValueArrayRadioButtonGroup();

      getHospitalDivisionRadioContainer().setText("病院区分");

      hospitalDivisionRadio.setBindPath("1530316");

      hospitalDivisionRadio.setUseClearButton(false);

      hospitalDivisionRadio.setModel(getHospitalDivisionRadioModel());

      hospitalDivisionRadio.setValues(new int[]{1,2});

      addHospitalDivisionRadio();
    }
    return hospitalDivisionRadio;

  }

  /**
   * 病院区分コンテナを取得します。
   * @return 病院区分コンテナ
   */
  protected ACLabelContainer getHospitalDivisionRadioContainer(){
    if(hospitalDivisionRadioContainer==null){
      hospitalDivisionRadioContainer = new ACLabelContainer();
      hospitalDivisionRadioContainer.setFollowChildEnabled(true);
      hospitalDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      hospitalDivisionRadioContainer.add(getHospitalDivisionRadio(), null);
    }
    return hospitalDivisionRadioContainer;
  }

  /**
   * 病院区分モデルを取得します。
   * @return 病院区分モデル
   */
  protected ACListModelAdapter getHospitalDivisionRadioModel(){
    if(hospitalDivisionRadioModel==null){
      hospitalDivisionRadioModel = new ACListModelAdapter();
      addHospitalDivisionRadioModel();
    }
    return hospitalDivisionRadioModel;
  }

  /**
   * 大学病院を取得します。
   * @return 大学病院
   */
  public ACRadioButtonItem getHospitalDivisionRadioItem1(){
    if(hospitalDivisionRadioItem1==null){

      hospitalDivisionRadioItem1 = new ACRadioButtonItem();

      hospitalDivisionRadioItem1.setText("大学病院");

      hospitalDivisionRadioItem1.setGroup(getHospitalDivisionRadio());

      hospitalDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addHospitalDivisionRadioItem1();
    }
    return hospitalDivisionRadioItem1;

  }

  /**
   * 一般病院を取得します。
   * @return 一般病院
   */
  public ACRadioButtonItem getHospitalDivisionRadioItem2(){
    if(hospitalDivisionRadioItem2==null){

      hospitalDivisionRadioItem2 = new ACRadioButtonItem();

      hospitalDivisionRadioItem2.setText("一般病院");

      hospitalDivisionRadioItem2.setGroup(getHospitalDivisionRadio());

      hospitalDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addHospitalDivisionRadioItem2();
    }
    return hospitalDivisionRadioItem2;

  }

  /**
   * 人員配置区分を取得します。
   * @return 人員配置区分
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityCognitiveHospitalHospitalDivision(){
    if(medicalFacilityCognitiveHospitalHospitalDivision==null){

      medicalFacilityCognitiveHospitalHospitalDivision = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityCognitiveHospitalHospitalDivisionContainer().setText("人員配置区分");

      medicalFacilityCognitiveHospitalHospitalDivision.setBindPath("1530302");

      medicalFacilityCognitiveHospitalHospitalDivision.setUseClearButton(false);

      medicalFacilityCognitiveHospitalHospitalDivision.setModel(getMedicalFacilityCognitiveHospitalHospitalDivisionModel());

      medicalFacilityCognitiveHospitalHospitalDivision.setValues(new int[]{1,2,3,4,5});

      addMedicalFacilityCognitiveHospitalHospitalDivision();
    }
    return medicalFacilityCognitiveHospitalHospitalDivision;

  }

  /**
   * 人員配置区分コンテナを取得します。
   * @return 人員配置区分コンテナ
   */
  protected ACLabelContainer getMedicalFacilityCognitiveHospitalHospitalDivisionContainer(){
    if(medicalFacilityCognitiveHospitalHospitalDivisionContainer==null){
      medicalFacilityCognitiveHospitalHospitalDivisionContainer = new ACLabelContainer();
      medicalFacilityCognitiveHospitalHospitalDivisionContainer.setFollowChildEnabled(true);
      medicalFacilityCognitiveHospitalHospitalDivisionContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityCognitiveHospitalHospitalDivisionContainer.add(getMedicalFacilityCognitiveHospitalHospitalDivision(), null);
    }
    return medicalFacilityCognitiveHospitalHospitalDivisionContainer;
  }

  /**
   * 人員配置区分モデルを取得します。
   * @return 人員配置区分モデル
   */
  protected ACListModelAdapter getMedicalFacilityCognitiveHospitalHospitalDivisionModel(){
    if(medicalFacilityCognitiveHospitalHospitalDivisionModel==null){
      medicalFacilityCognitiveHospitalHospitalDivisionModel = new ACListModelAdapter();
      addMedicalFacilityCognitiveHospitalHospitalDivisionModel();
    }
    return medicalFacilityCognitiveHospitalHospitalDivisionModel;
  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalDivision1(){
    if(medicalFacilityCognitiveHospitalDivision1==null){

      medicalFacilityCognitiveHospitalDivision1 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalDivision1.setText("I型");

      medicalFacilityCognitiveHospitalDivision1.setGroup(getMedicalFacilityCognitiveHospitalHospitalDivision());

      medicalFacilityCognitiveHospitalDivision1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalDivision1();
    }
    return medicalFacilityCognitiveHospitalDivision1;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalDivision2(){
    if(medicalFacilityCognitiveHospitalDivision2==null){

      medicalFacilityCognitiveHospitalDivision2 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalDivision2.setText("II型");

      medicalFacilityCognitiveHospitalDivision2.setGroup(getMedicalFacilityCognitiveHospitalHospitalDivision());

      medicalFacilityCognitiveHospitalDivision2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalDivision2();
    }
    return medicalFacilityCognitiveHospitalDivision2;

  }

  /**
   * III型を取得します。
   * @return III型
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalDivision3(){
    if(medicalFacilityCognitiveHospitalDivision3==null){

      medicalFacilityCognitiveHospitalDivision3 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalDivision3.setText("III型");

      medicalFacilityCognitiveHospitalDivision3.setGroup(getMedicalFacilityCognitiveHospitalHospitalDivision());

      medicalFacilityCognitiveHospitalDivision3.setConstraints(VRLayout.FLOW_RETURN);

      addMedicalFacilityCognitiveHospitalDivision3();
    }
    return medicalFacilityCognitiveHospitalDivision3;

  }

  /**
   * IV型を取得します。
   * @return IV型
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalDivision4(){
    if(medicalFacilityCognitiveHospitalDivision4==null){

      medicalFacilityCognitiveHospitalDivision4 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalDivision4.setText("IV型");

      medicalFacilityCognitiveHospitalDivision4.setGroup(getMedicalFacilityCognitiveHospitalHospitalDivision());

      medicalFacilityCognitiveHospitalDivision4.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalDivision4();
    }
    return medicalFacilityCognitiveHospitalDivision4;

  }

  /**
   * V型を取得します。
   * @return V型
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalDivision5(){
    if(medicalFacilityCognitiveHospitalDivision5==null){

      medicalFacilityCognitiveHospitalDivision5 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalDivision5.setText("V型");

      medicalFacilityCognitiveHospitalDivision5.setGroup(getMedicalFacilityCognitiveHospitalHospitalDivision());

      medicalFacilityCognitiveHospitalDivision5.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalDivision5();
    }
    return medicalFacilityCognitiveHospitalDivision5;

  }

  /**
   * 病室区分コンテナを取得します。
   * @return 病室区分コンテナ
   */
  public ACLabelContainer getMedicalFacilityCognitiveHospitalHospitalRoomContena(){
    if(medicalFacilityCognitiveHospitalHospitalRoomContena==null){

      medicalFacilityCognitiveHospitalHospitalRoomContena = new ACLabelContainer();

      medicalFacilityCognitiveHospitalHospitalRoomContena.setText("病室区分");

      medicalFacilityCognitiveHospitalHospitalRoomContena.setFollowChildEnabled(true);

      addMedicalFacilityCognitiveHospitalHospitalRoomContena();
    }
    return medicalFacilityCognitiveHospitalHospitalRoomContena;

  }

  /**
   * 病室区分（病院）を取得します。
   * @return 病室区分（病院）
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityCognitiveHospitalHospitalRoomRadio(){
    if(medicalFacilityCognitiveHospitalHospitalRoomRadio==null){

      medicalFacilityCognitiveHospitalHospitalRoomRadio = new ACValueArrayRadioButtonGroup();

      medicalFacilityCognitiveHospitalHospitalRoomRadio.setBindPath("1530303");

      medicalFacilityCognitiveHospitalHospitalRoomRadio.setUseClearButton(false);

      medicalFacilityCognitiveHospitalHospitalRoomRadio.setModel(getMedicalFacilityCognitiveHospitalHospitalRoomRadioModel());

      medicalFacilityCognitiveHospitalHospitalRoomRadio.setValues(new int[]{1,2});

      addMedicalFacilityCognitiveHospitalHospitalRoomRadio();
    }
    return medicalFacilityCognitiveHospitalHospitalRoomRadio;

  }

  /**
   * 病室区分（病院）モデルを取得します。
   * @return 病室区分（病院）モデル
   */
  protected ACListModelAdapter getMedicalFacilityCognitiveHospitalHospitalRoomRadioModel(){
    if(medicalFacilityCognitiveHospitalHospitalRoomRadioModel==null){
      medicalFacilityCognitiveHospitalHospitalRoomRadioModel = new ACListModelAdapter();
      addMedicalFacilityCognitiveHospitalHospitalRoomRadioModel();
    }
    return medicalFacilityCognitiveHospitalHospitalRoomRadioModel;
  }

  /**
   * 従来型個室を取得します。
   * @return 従来型個室
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalHospitalRoomRadioItem1(){
    if(medicalFacilityCognitiveHospitalHospitalRoomRadioItem1==null){

      medicalFacilityCognitiveHospitalHospitalRoomRadioItem1 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalHospitalRoomRadioItem1.setText("従来型個室");

      medicalFacilityCognitiveHospitalHospitalRoomRadioItem1.setGroup(getMedicalFacilityCognitiveHospitalHospitalRoomRadio());

      medicalFacilityCognitiveHospitalHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalHospitalRoomRadioItem1();
    }
    return medicalFacilityCognitiveHospitalHospitalRoomRadioItem1;

  }

  /**
   * 多床室を取得します。
   * @return 多床室
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalHospitalRoomRadioItem2(){
    if(medicalFacilityCognitiveHospitalHospitalRoomRadioItem2==null){

      medicalFacilityCognitiveHospitalHospitalRoomRadioItem2 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalHospitalRoomRadioItem2.setText("多床室");

      medicalFacilityCognitiveHospitalHospitalRoomRadioItem2.setGroup(getMedicalFacilityCognitiveHospitalHospitalRoomRadio());

      medicalFacilityCognitiveHospitalHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalHospitalRoomRadioItem2();
    }
    return medicalFacilityCognitiveHospitalHospitalRoomRadioItem2;

  }

  /**
   * 病室区分（ユニット型）を取得します。
   * @return 病室区分（ユニット型）
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadio(){
    if(medicalFacilityCognitiveHospitalUnitHospitalRoomRadio==null){

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadio = new ACValueArrayRadioButtonGroup();

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadio.setBindPath("1530304");

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadio.setUseClearButton(false);

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadio.setModel(getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioModel());

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadio.setValues(new int[]{1,2});

      addMedicalFacilityCognitiveHospitalUnitHospitalRoomRadio();
    }
    return medicalFacilityCognitiveHospitalUnitHospitalRoomRadio;

  }

  /**
   * 病室区分（ユニット型）モデルを取得します。
   * @return 病室区分（ユニット型）モデル
   */
  protected ACListModelAdapter getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioModel(){
    if(medicalFacilityCognitiveHospitalUnitHospitalRoomRadioModel==null){
      medicalFacilityCognitiveHospitalUnitHospitalRoomRadioModel = new ACListModelAdapter();
      addMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioModel();
    }
    return medicalFacilityCognitiveHospitalUnitHospitalRoomRadioModel;
  }

  /**
   * ユニット型個室を取得します。
   * @return ユニット型個室
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem1(){
    if(medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem1==null){

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem1 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem1.setText("ﾕﾆｯﾄ型個室");

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem1.setGroup(getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadio());

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem1();
    }
    return medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem1;

  }

  /**
   * ユニット型個室的多床室を取得します。
   * @return ユニット型個室的多床室
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem2(){
    if(medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem2==null){

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem2 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem2.setText("ﾕﾆｯﾄ型個室的多床室");

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem2.setGroup(getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadio());

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem2();
    }
    return medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem2;

  }

  /**
   * 入院患者に関する基準を取得します。
   * @return 入院患者に関する基準
   */
  public ACValueArrayRadioButtonGroup getHospitalizedPatientsCriteriaRadio(){
    if(hospitalizedPatientsCriteriaRadio==null){

      hospitalizedPatientsCriteriaRadio = new ACValueArrayRadioButtonGroup();

      getHospitalizedPatientsCriteriaRadioContainer().setText("入院患者に関する基準");

      hospitalizedPatientsCriteriaRadio.setBindPath("1530362");

      hospitalizedPatientsCriteriaRadio.setNoSelectIndex(0);

      hospitalizedPatientsCriteriaRadio.setUseClearButton(false);

      hospitalizedPatientsCriteriaRadio.setModel(getHospitalizedPatientsCriteriaRadioModel());

      hospitalizedPatientsCriteriaRadio.setValues(new int[]{2,1});

      addHospitalizedPatientsCriteriaRadio();
    }
    return hospitalizedPatientsCriteriaRadio;

  }

  /**
   * 入院患者に関する基準コンテナを取得します。
   * @return 入院患者に関する基準コンテナ
   */
  protected ACLabelContainer getHospitalizedPatientsCriteriaRadioContainer(){
    if(hospitalizedPatientsCriteriaRadioContainer==null){
      hospitalizedPatientsCriteriaRadioContainer = new ACLabelContainer();
      hospitalizedPatientsCriteriaRadioContainer.setFollowChildEnabled(true);
      hospitalizedPatientsCriteriaRadioContainer.setVAlignment(VRLayout.CENTER);
      hospitalizedPatientsCriteriaRadioContainer.add(getHospitalizedPatientsCriteriaRadio(), null);
    }
    return hospitalizedPatientsCriteriaRadioContainer;
  }

  /**
   * 入院患者に関する基準モデルを取得します。
   * @return 入院患者に関する基準モデル
   */
  protected ACListModelAdapter getHospitalizedPatientsCriteriaRadioModel(){
    if(hospitalizedPatientsCriteriaRadioModel==null){
      hospitalizedPatientsCriteriaRadioModel = new ACListModelAdapter();
      addHospitalizedPatientsCriteriaRadioModel();
    }
    return hospitalizedPatientsCriteriaRadioModel;
  }

  /**
   * 基準型を取得します。
   * @return 基準型
   */
  public ACRadioButtonItem getHospitalizedPatientsCriteriaRadioItem1(){
    if(hospitalizedPatientsCriteriaRadioItem1==null){

      hospitalizedPatientsCriteriaRadioItem1 = new ACRadioButtonItem();

      hospitalizedPatientsCriteriaRadioItem1.setText("基準型");

      hospitalizedPatientsCriteriaRadioItem1.setGroup(getHospitalizedPatientsCriteriaRadio());

      hospitalizedPatientsCriteriaRadioItem1.setConstraints(VRLayout.FLOW);

      addHospitalizedPatientsCriteriaRadioItem1();
    }
    return hospitalizedPatientsCriteriaRadioItem1;

  }

  /**
   * 減算型を取得します。
   * @return 減算型
   */
  public ACRadioButtonItem getHospitalizedPatientsCriteriaRadioItem2(){
    if(hospitalizedPatientsCriteriaRadioItem2==null){

      hospitalizedPatientsCriteriaRadioItem2 = new ACRadioButtonItem();

      hospitalizedPatientsCriteriaRadioItem2.setText("減算型");

      hospitalizedPatientsCriteriaRadioItem2.setGroup(getHospitalizedPatientsCriteriaRadio());

      hospitalizedPatientsCriteriaRadioItem2.setConstraints(VRLayout.FLOW);

      addHospitalizedPatientsCriteriaRadioItem2();
    }
    return hospitalizedPatientsCriteriaRadioItem2;

  }

  /**
   * ユニットケアの整備を取得します。
   * @return ユニットケアの整備
   */
  public ACValueArrayRadioButtonGroup getUnitCareMaintenanceRadio(){
    if(unitCareMaintenanceRadio==null){

      unitCareMaintenanceRadio = new ACValueArrayRadioButtonGroup();

      getUnitCareMaintenanceRadioContainer().setText("ユニットケアの整備");

      unitCareMaintenanceRadio.setBindPath("1530313");

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
   * 外泊加算を取得します。
   * @return 外泊加算
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityCognitiveHospitalStayRadio(){
    if(medicalFacilityCognitiveHospitalStayRadio==null){

      medicalFacilityCognitiveHospitalStayRadio = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityCognitiveHospitalStayRadioContainer().setText("外泊加算");

      medicalFacilityCognitiveHospitalStayRadio.setBindPath("1530305");

      medicalFacilityCognitiveHospitalStayRadio.setUseClearButton(false);

      medicalFacilityCognitiveHospitalStayRadio.setModel(getMedicalFacilityCognitiveHospitalStayRadioModel());

      medicalFacilityCognitiveHospitalStayRadio.setValues(new int[]{1,2});

      addMedicalFacilityCognitiveHospitalStayRadio();
    }
    return medicalFacilityCognitiveHospitalStayRadio;

  }

  /**
   * 外泊加算コンテナを取得します。
   * @return 外泊加算コンテナ
   */
  protected ACLabelContainer getMedicalFacilityCognitiveHospitalStayRadioContainer(){
    if(medicalFacilityCognitiveHospitalStayRadioContainer==null){
      medicalFacilityCognitiveHospitalStayRadioContainer = new ACLabelContainer();
      medicalFacilityCognitiveHospitalStayRadioContainer.setFollowChildEnabled(true);
      medicalFacilityCognitiveHospitalStayRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityCognitiveHospitalStayRadioContainer.add(getMedicalFacilityCognitiveHospitalStayRadio(), null);
    }
    return medicalFacilityCognitiveHospitalStayRadioContainer;
  }

  /**
   * 外泊加算モデルを取得します。
   * @return 外泊加算モデル
   */
  protected ACListModelAdapter getMedicalFacilityCognitiveHospitalStayRadioModel(){
    if(medicalFacilityCognitiveHospitalStayRadioModel==null){
      medicalFacilityCognitiveHospitalStayRadioModel = new ACListModelAdapter();
      addMedicalFacilityCognitiveHospitalStayRadioModel();
    }
    return medicalFacilityCognitiveHospitalStayRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalStayRadioItem1(){
    if(medicalFacilityCognitiveHospitalStayRadioItem1==null){

      medicalFacilityCognitiveHospitalStayRadioItem1 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalStayRadioItem1.setText("なし");

      medicalFacilityCognitiveHospitalStayRadioItem1.setGroup(getMedicalFacilityCognitiveHospitalStayRadio());

      medicalFacilityCognitiveHospitalStayRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalStayRadioItem1();
    }
    return medicalFacilityCognitiveHospitalStayRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalStayRadioItem2(){
    if(medicalFacilityCognitiveHospitalStayRadioItem2==null){

      medicalFacilityCognitiveHospitalStayRadioItem2 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalStayRadioItem2.setText("あり");

      medicalFacilityCognitiveHospitalStayRadioItem2.setGroup(getMedicalFacilityCognitiveHospitalStayRadio());

      medicalFacilityCognitiveHospitalStayRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalStayRadioItem2();
    }
    return medicalFacilityCognitiveHospitalStayRadioItem2;

  }

  /**
   * 初期加算を取得します。
   * @return 初期加算
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityCognitiveHospitalStandardRadio(){
    if(medicalFacilityCognitiveHospitalStandardRadio==null){

      medicalFacilityCognitiveHospitalStandardRadio = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityCognitiveHospitalStandardRadioContainer().setText("初期加算");

      medicalFacilityCognitiveHospitalStandardRadio.setBindPath("1530306");

      medicalFacilityCognitiveHospitalStandardRadio.setUseClearButton(false);

      medicalFacilityCognitiveHospitalStandardRadio.setModel(getMedicalFacilityCognitiveHospitalStandardRadioModel());

      medicalFacilityCognitiveHospitalStandardRadio.setValues(new int[]{1,2});

      addMedicalFacilityCognitiveHospitalStandardRadio();
    }
    return medicalFacilityCognitiveHospitalStandardRadio;

  }

  /**
   * 初期加算コンテナを取得します。
   * @return 初期加算コンテナ
   */
  protected ACLabelContainer getMedicalFacilityCognitiveHospitalStandardRadioContainer(){
    if(medicalFacilityCognitiveHospitalStandardRadioContainer==null){
      medicalFacilityCognitiveHospitalStandardRadioContainer = new ACLabelContainer();
      medicalFacilityCognitiveHospitalStandardRadioContainer.setFollowChildEnabled(true);
      medicalFacilityCognitiveHospitalStandardRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityCognitiveHospitalStandardRadioContainer.add(getMedicalFacilityCognitiveHospitalStandardRadio(), null);
    }
    return medicalFacilityCognitiveHospitalStandardRadioContainer;
  }

  /**
   * 初期加算モデルを取得します。
   * @return 初期加算モデル
   */
  protected ACListModelAdapter getMedicalFacilityCognitiveHospitalStandardRadioModel(){
    if(medicalFacilityCognitiveHospitalStandardRadioModel==null){
      medicalFacilityCognitiveHospitalStandardRadioModel = new ACListModelAdapter();
      addMedicalFacilityCognitiveHospitalStandardRadioModel();
    }
    return medicalFacilityCognitiveHospitalStandardRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalStandardRadioItem1(){
    if(medicalFacilityCognitiveHospitalStandardRadioItem1==null){

      medicalFacilityCognitiveHospitalStandardRadioItem1 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalStandardRadioItem1.setText("なし");

      medicalFacilityCognitiveHospitalStandardRadioItem1.setGroup(getMedicalFacilityCognitiveHospitalStandardRadio());

      medicalFacilityCognitiveHospitalStandardRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalStandardRadioItem1();
    }
    return medicalFacilityCognitiveHospitalStandardRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalStandardRadioItem2(){
    if(medicalFacilityCognitiveHospitalStandardRadioItem2==null){

      medicalFacilityCognitiveHospitalStandardRadioItem2 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalStandardRadioItem2.setText("あり");

      medicalFacilityCognitiveHospitalStandardRadioItem2.setGroup(getMedicalFacilityCognitiveHospitalStandardRadio());

      medicalFacilityCognitiveHospitalStandardRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalStandardRadioItem2();
    }
    return medicalFacilityCognitiveHospitalStandardRadioItem2;

  }

  /**
   * 他科受診を取得します。
   * @return 他科受診
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityCognitiveHospitalMedicalExaminationRadio(){
    if(medicalFacilityCognitiveHospitalMedicalExaminationRadio==null){

      medicalFacilityCognitiveHospitalMedicalExaminationRadio = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityCognitiveHospitalMedicalExaminationRadioContainer().setText("他科受診加算");

      medicalFacilityCognitiveHospitalMedicalExaminationRadio.setBindPath("1530307");

      medicalFacilityCognitiveHospitalMedicalExaminationRadio.setUseClearButton(false);

      medicalFacilityCognitiveHospitalMedicalExaminationRadio.setModel(getMedicalFacilityCognitiveHospitalMedicalExaminationRadioModel());

      medicalFacilityCognitiveHospitalMedicalExaminationRadio.setValues(new int[]{1,2});

      addMedicalFacilityCognitiveHospitalMedicalExaminationRadio();
    }
    return medicalFacilityCognitiveHospitalMedicalExaminationRadio;

  }

  /**
   * 他科受診コンテナを取得します。
   * @return 他科受診コンテナ
   */
  protected ACLabelContainer getMedicalFacilityCognitiveHospitalMedicalExaminationRadioContainer(){
    if(medicalFacilityCognitiveHospitalMedicalExaminationRadioContainer==null){
      medicalFacilityCognitiveHospitalMedicalExaminationRadioContainer = new ACLabelContainer();
      medicalFacilityCognitiveHospitalMedicalExaminationRadioContainer.setFollowChildEnabled(true);
      medicalFacilityCognitiveHospitalMedicalExaminationRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityCognitiveHospitalMedicalExaminationRadioContainer.add(getMedicalFacilityCognitiveHospitalMedicalExaminationRadio(), null);
    }
    return medicalFacilityCognitiveHospitalMedicalExaminationRadioContainer;
  }

  /**
   * 他科受診モデルを取得します。
   * @return 他科受診モデル
   */
  protected ACListModelAdapter getMedicalFacilityCognitiveHospitalMedicalExaminationRadioModel(){
    if(medicalFacilityCognitiveHospitalMedicalExaminationRadioModel==null){
      medicalFacilityCognitiveHospitalMedicalExaminationRadioModel = new ACListModelAdapter();
      addMedicalFacilityCognitiveHospitalMedicalExaminationRadioModel();
    }
    return medicalFacilityCognitiveHospitalMedicalExaminationRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalMedicalExaminationRadioItem1(){
    if(medicalFacilityCognitiveHospitalMedicalExaminationRadioItem1==null){

      medicalFacilityCognitiveHospitalMedicalExaminationRadioItem1 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalMedicalExaminationRadioItem1.setText("なし");

      medicalFacilityCognitiveHospitalMedicalExaminationRadioItem1.setGroup(getMedicalFacilityCognitiveHospitalMedicalExaminationRadio());

      medicalFacilityCognitiveHospitalMedicalExaminationRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalMedicalExaminationRadioItem1();
    }
    return medicalFacilityCognitiveHospitalMedicalExaminationRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalMedicalExaminationRadioItem2(){
    if(medicalFacilityCognitiveHospitalMedicalExaminationRadioItem2==null){

      medicalFacilityCognitiveHospitalMedicalExaminationRadioItem2 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalMedicalExaminationRadioItem2.setText("あり");

      medicalFacilityCognitiveHospitalMedicalExaminationRadioItem2.setGroup(getMedicalFacilityCognitiveHospitalMedicalExaminationRadio());

      medicalFacilityCognitiveHospitalMedicalExaminationRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalMedicalExaminationRadioItem2();
    }
    return medicalFacilityCognitiveHospitalMedicalExaminationRadioItem2;

  }

  /**
   * 栄養マネジメント加算を取得します。
   * @return 栄養マネジメント加算
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityCognitiveHospitalNutritionRadio(){
    if(medicalFacilityCognitiveHospitalNutritionRadio==null){

      medicalFacilityCognitiveHospitalNutritionRadio = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityCognitiveHospitalNutritionRadioContainer().setText("栄養マネジメント加算");

      medicalFacilityCognitiveHospitalNutritionRadio.setBindPath("1530309");

      medicalFacilityCognitiveHospitalNutritionRadio.setUseClearButton(false);

      medicalFacilityCognitiveHospitalNutritionRadio.setModel(getMedicalFacilityCognitiveHospitalNutritionRadioModel());

      medicalFacilityCognitiveHospitalNutritionRadio.setValues(new int[]{1,2});

      addMedicalFacilityCognitiveHospitalNutritionRadio();
    }
    return medicalFacilityCognitiveHospitalNutritionRadio;

  }

  /**
   * 栄養マネジメント加算コンテナを取得します。
   * @return 栄養マネジメント加算コンテナ
   */
  protected ACLabelContainer getMedicalFacilityCognitiveHospitalNutritionRadioContainer(){
    if(medicalFacilityCognitiveHospitalNutritionRadioContainer==null){
      medicalFacilityCognitiveHospitalNutritionRadioContainer = new ACLabelContainer();
      medicalFacilityCognitiveHospitalNutritionRadioContainer.setFollowChildEnabled(true);
      medicalFacilityCognitiveHospitalNutritionRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityCognitiveHospitalNutritionRadioContainer.add(getMedicalFacilityCognitiveHospitalNutritionRadio(), null);
    }
    return medicalFacilityCognitiveHospitalNutritionRadioContainer;
  }

  /**
   * 栄養マネジメント加算モデルを取得します。
   * @return 栄養マネジメント加算モデル
   */
  protected ACListModelAdapter getMedicalFacilityCognitiveHospitalNutritionRadioModel(){
    if(medicalFacilityCognitiveHospitalNutritionRadioModel==null){
      medicalFacilityCognitiveHospitalNutritionRadioModel = new ACListModelAdapter();
      addMedicalFacilityCognitiveHospitalNutritionRadioModel();
    }
    return medicalFacilityCognitiveHospitalNutritionRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalNutritionRadioItem1(){
    if(medicalFacilityCognitiveHospitalNutritionRadioItem1==null){

      medicalFacilityCognitiveHospitalNutritionRadioItem1 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalNutritionRadioItem1.setText("なし");

      medicalFacilityCognitiveHospitalNutritionRadioItem1.setGroup(getMedicalFacilityCognitiveHospitalNutritionRadio());

      medicalFacilityCognitiveHospitalNutritionRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalNutritionRadioItem1();
    }
    return medicalFacilityCognitiveHospitalNutritionRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalNutritionRadioItem2(){
    if(medicalFacilityCognitiveHospitalNutritionRadioItem2==null){

      medicalFacilityCognitiveHospitalNutritionRadioItem2 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalNutritionRadioItem2.setText("あり");

      medicalFacilityCognitiveHospitalNutritionRadioItem2.setGroup(getMedicalFacilityCognitiveHospitalNutritionRadio());

      medicalFacilityCognitiveHospitalNutritionRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalNutritionRadioItem2();
    }
    return medicalFacilityCognitiveHospitalNutritionRadioItem2;

  }

  /**
   * 経口移行加算を取得します。
   * @return 経口移行加算
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityCognitiveHospitalOralSwitchRadio(){
    if(medicalFacilityCognitiveHospitalOralSwitchRadio==null){

      medicalFacilityCognitiveHospitalOralSwitchRadio = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityCognitiveHospitalOralSwitchRadioContainer().setText("経口移行加算");

      medicalFacilityCognitiveHospitalOralSwitchRadio.setBindPath("1530310");

      medicalFacilityCognitiveHospitalOralSwitchRadio.setUseClearButton(false);

      medicalFacilityCognitiveHospitalOralSwitchRadio.setModel(getMedicalFacilityCognitiveHospitalOralSwitchRadioModel());

      medicalFacilityCognitiveHospitalOralSwitchRadio.setValues(new int[]{1,2});

      addMedicalFacilityCognitiveHospitalOralSwitchRadio();
    }
    return medicalFacilityCognitiveHospitalOralSwitchRadio;

  }

  /**
   * 経口移行加算コンテナを取得します。
   * @return 経口移行加算コンテナ
   */
  protected ACLabelContainer getMedicalFacilityCognitiveHospitalOralSwitchRadioContainer(){
    if(medicalFacilityCognitiveHospitalOralSwitchRadioContainer==null){
      medicalFacilityCognitiveHospitalOralSwitchRadioContainer = new ACLabelContainer();
      medicalFacilityCognitiveHospitalOralSwitchRadioContainer.setFollowChildEnabled(true);
      medicalFacilityCognitiveHospitalOralSwitchRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityCognitiveHospitalOralSwitchRadioContainer.add(getMedicalFacilityCognitiveHospitalOralSwitchRadio(), null);
    }
    return medicalFacilityCognitiveHospitalOralSwitchRadioContainer;
  }

  /**
   * 経口移行加算モデルを取得します。
   * @return 経口移行加算モデル
   */
  protected ACListModelAdapter getMedicalFacilityCognitiveHospitalOralSwitchRadioModel(){
    if(medicalFacilityCognitiveHospitalOralSwitchRadioModel==null){
      medicalFacilityCognitiveHospitalOralSwitchRadioModel = new ACListModelAdapter();
      addMedicalFacilityCognitiveHospitalOralSwitchRadioModel();
    }
    return medicalFacilityCognitiveHospitalOralSwitchRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalOralSwitchRadioItem1(){
    if(medicalFacilityCognitiveHospitalOralSwitchRadioItem1==null){

      medicalFacilityCognitiveHospitalOralSwitchRadioItem1 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalOralSwitchRadioItem1.setText("なし");

      medicalFacilityCognitiveHospitalOralSwitchRadioItem1.setGroup(getMedicalFacilityCognitiveHospitalOralSwitchRadio());

      medicalFacilityCognitiveHospitalOralSwitchRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalOralSwitchRadioItem1();
    }
    return medicalFacilityCognitiveHospitalOralSwitchRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalOralSwitchRadioItem2(){
    if(medicalFacilityCognitiveHospitalOralSwitchRadioItem2==null){

      medicalFacilityCognitiveHospitalOralSwitchRadioItem2 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalOralSwitchRadioItem2.setText("あり");

      medicalFacilityCognitiveHospitalOralSwitchRadioItem2.setGroup(getMedicalFacilityCognitiveHospitalOralSwitchRadio());

      medicalFacilityCognitiveHospitalOralSwitchRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalOralSwitchRadioItem2();
    }
    return medicalFacilityCognitiveHospitalOralSwitchRadioItem2;

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

      oralMaintenanceAdd.setBindPath("1530312");

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

      oralMaintenanceAddItem3.setBindPath("1530317");

      oralMaintenanceAddItem3.setSelectValue(2);

      oralMaintenanceAddItem3.setUnSelectValue(1);

      addOralMaintenanceAddItem3();
    }
    return oralMaintenanceAddItem3;

  }

  /**
   * 口腔衛生管理体制加算を取得します。
   * @return 口腔衛生管理体制加算
   */
  public ACValueArrayRadioButtonGroup getOralKeepStructureAddRadioGroup(){
    if(oralKeepStructureAddRadioGroup==null){

      oralKeepStructureAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getOralKeepStructureAddRadioGroupContainer().setText("口腔衛生管理体制加算");

      oralKeepStructureAddRadioGroup.setBindPath("1530361");

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
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("口腔衛生管理加算");

      youngDementiaPatinetAddRadioGroup.setBindPath("1530359");

      youngDementiaPatinetAddRadioGroup.setNoSelectIndex(0);

      youngDementiaPatinetAddRadioGroup.setUseClearButton(false);

      youngDementiaPatinetAddRadioGroup.setModel(getYoungDementiaPatinetAddRadioGroupModel());

      youngDementiaPatinetAddRadioGroup.setValues(new int[]{1,2});

      addYoungDementiaPatinetAddRadioGroup();
    }
    return youngDementiaPatinetAddRadioGroup;

  }

  /**
   * 口腔衛生管理加算コンテナを取得します。
   * @return 口腔衛生管理加算コンテナ
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
   * 口腔衛生管理加算モデルを取得します。
   * @return 口腔衛生管理加算モデル
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
   * 療養食加算を取得します。
   * @return 療養食加算
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityCognitiveHospitalRecuperateDinnerRadio(){
    if(medicalFacilityCognitiveHospitalRecuperateDinnerRadio==null){

      medicalFacilityCognitiveHospitalRecuperateDinnerRadio = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioContainer().setText("療養食加算");

      medicalFacilityCognitiveHospitalRecuperateDinnerRadio.setBindPath("1530311");

      medicalFacilityCognitiveHospitalRecuperateDinnerRadio.setUseClearButton(false);

      medicalFacilityCognitiveHospitalRecuperateDinnerRadio.setModel(getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioModel());

      medicalFacilityCognitiveHospitalRecuperateDinnerRadio.setValues(new int[]{1,2,3,4});

      addMedicalFacilityCognitiveHospitalRecuperateDinnerRadio();
    }
    return medicalFacilityCognitiveHospitalRecuperateDinnerRadio;

  }

  /**
   * 療養食加算コンテナを取得します。
   * @return 療養食加算コンテナ
   */
  protected ACLabelContainer getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioContainer(){
    if(medicalFacilityCognitiveHospitalRecuperateDinnerRadioContainer==null){
      medicalFacilityCognitiveHospitalRecuperateDinnerRadioContainer = new ACLabelContainer();
      medicalFacilityCognitiveHospitalRecuperateDinnerRadioContainer.setFollowChildEnabled(true);
      medicalFacilityCognitiveHospitalRecuperateDinnerRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityCognitiveHospitalRecuperateDinnerRadioContainer.add(getMedicalFacilityCognitiveHospitalRecuperateDinnerRadio(), null);
    }
    return medicalFacilityCognitiveHospitalRecuperateDinnerRadioContainer;
  }

  /**
   * 療養食加算モデルを取得します。
   * @return 療養食加算モデル
   */
  protected ACListModelAdapter getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioModel(){
    if(medicalFacilityCognitiveHospitalRecuperateDinnerRadioModel==null){
      medicalFacilityCognitiveHospitalRecuperateDinnerRadioModel = new ACListModelAdapter();
      addMedicalFacilityCognitiveHospitalRecuperateDinnerRadioModel();
    }
    return medicalFacilityCognitiveHospitalRecuperateDinnerRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem1(){
    if(medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem1==null){

      medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem1 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem1.setText("なし");

      medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem1.setGroup(getMedicalFacilityCognitiveHospitalRecuperateDinnerRadio());

      medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem1();
    }
    return medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem1;

  }

  /**
   * 3回を取得します。
   * @return 3回
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem2(){
    if(medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem2==null){

      medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem2 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem2.setText("3回");

      medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem2.setGroup(getMedicalFacilityCognitiveHospitalRecuperateDinnerRadio());

      medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem2();
    }
    return medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem2;

  }

  /**
   * 2回を取得します。
   * @return 2回
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem3(){
    if(medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem3==null){

      medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem3 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem3.setText("2回");

      medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem3.setGroup(getMedicalFacilityCognitiveHospitalRecuperateDinnerRadio());

      medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem3.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem3();
    }
    return medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem3;

  }

  /**
   * 1回を取得します。
   * @return 1回
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem4(){
    if(medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem4==null){

      medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem4 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem4.setText("1回");

      medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem4.setGroup(getMedicalFacilityCognitiveHospitalRecuperateDinnerRadio());

      medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem4.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem4();
    }
    return medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem4;

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
   * 退所関連加算を取得します。
   * @return 退所関連加算
   */
  public ACLabelContainer getMedicalFacilityCognitiveHospitalHijoAddition(){
    if(medicalFacilityCognitiveHospitalHijoAddition==null){

      medicalFacilityCognitiveHospitalHijoAddition = new ACLabelContainer();

      medicalFacilityCognitiveHospitalHijoAddition.setText("退院関連加算");

      medicalFacilityCognitiveHospitalHijoAddition.setFollowChildEnabled(true);

      addMedicalFacilityCognitiveHospitalHijoAddition();
    }
    return medicalFacilityCognitiveHospitalHijoAddition;

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
   * 訪問看護指示加算を取得します。
   * @return 訪問看護指示加算
   */
  public ACIntegerCheckBox getLeavingHospital(){
    if(leavingHospital==null){

      leavingHospital = new ACIntegerCheckBox();

      leavingHospital.setText("訪問看護指示加算");

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
  public ACMapBindButton getMedicalFacilityCognitiveHospitalConsultationFee(){
    if(medicalFacilityCognitiveHospitalConsultationFee==null){

      medicalFacilityCognitiveHospitalConsultationFee = new ACMapBindButton();

      medicalFacilityCognitiveHospitalConsultationFee.setText("特定診療費");

      medicalFacilityCognitiveHospitalConsultationFee.setToolTipText("特定診療費を設定します。");

      addMedicalFacilityCognitiveHospitalConsultationFee();
    }
    return medicalFacilityCognitiveHospitalConsultationFee;

  }

  /**
   * ラベルを取得します。
   * @return ラベル
   */
  public ACLabel getMedicalFacilityCognitiveHospitalConsultationFeeLabel(){
    if(medicalFacilityCognitiveHospitalConsultationFeeLabel==null){

      medicalFacilityCognitiveHospitalConsultationFeeLabel = new ACLabel();

      medicalFacilityCognitiveHospitalConsultationFeeLabel.setText("設定なし");

      medicalFacilityCognitiveHospitalConsultationFeeLabel.setOpaque(true);
      medicalFacilityCognitiveHospitalConsultationFeeLabel.setBackground(new Color(255,255,172));

      addMedicalFacilityCognitiveHospitalConsultationFeeLabel();
    }
    return medicalFacilityCognitiveHospitalConsultationFeeLabel;

  }

  /**
   * 人員減算を取得します。
   * @return 人員減算
   */
  public ACComboBox getMedicalFacilityCognitiveHospitalSubstraction(){
    if(medicalFacilityCognitiveHospitalSubstraction==null){

      medicalFacilityCognitiveHospitalSubstraction = new ACComboBox();

      getMedicalFacilityCognitiveHospitalSubstractionContainer().setText("人員減算");

      medicalFacilityCognitiveHospitalSubstraction.setBindPath("1530355");

      medicalFacilityCognitiveHospitalSubstraction.setEditable(false);

      medicalFacilityCognitiveHospitalSubstraction.setModelBindPath("1530355");

      medicalFacilityCognitiveHospitalSubstraction.setRenderBindPath("CONTENT");

      medicalFacilityCognitiveHospitalSubstraction.setModel(getMedicalFacilityCognitiveHospitalSubstractionModel());

      addMedicalFacilityCognitiveHospitalSubstraction();
    }
    return medicalFacilityCognitiveHospitalSubstraction;

  }

  /**
   * 人員減算コンテナを取得します。
   * @return 人員減算コンテナ
   */
  protected ACLabelContainer getMedicalFacilityCognitiveHospitalSubstractionContainer(){
    if(medicalFacilityCognitiveHospitalSubstractionContainer==null){
      medicalFacilityCognitiveHospitalSubstractionContainer = new ACLabelContainer();
      medicalFacilityCognitiveHospitalSubstractionContainer.setFollowChildEnabled(true);
      medicalFacilityCognitiveHospitalSubstractionContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityCognitiveHospitalSubstractionContainer.add(getMedicalFacilityCognitiveHospitalSubstraction(), null);
    }
    return medicalFacilityCognitiveHospitalSubstractionContainer;
  }

  /**
   * 人員減算モデルを取得します。
   * @return 人員減算モデル
   */
  protected ACComboBoxModelAdapter getMedicalFacilityCognitiveHospitalSubstractionModel(){
    if(medicalFacilityCognitiveHospitalSubstractionModel==null){
      medicalFacilityCognitiveHospitalSubstractionModel = new ACComboBoxModelAdapter();
      addMedicalFacilityCognitiveHospitalSubstractionModel();
    }
    return medicalFacilityCognitiveHospitalSubstractionModel;
  }

  /**
   * 食事コンテナを取得します。
   * @return 食事コンテナ
   */
  public ACBackLabelContainer getMedicalFacilityCognitiveHospitalDinnerContainer(){
    if(medicalFacilityCognitiveHospitalDinnerContainer==null){

      medicalFacilityCognitiveHospitalDinnerContainer = new ACBackLabelContainer();

      medicalFacilityCognitiveHospitalDinnerContainer.setFollowChildEnabled(true);

      addMedicalFacilityCognitiveHospitalDinnerContainer();
    }
    return medicalFacilityCognitiveHospitalDinnerContainer;

  }

  /**
   * 食事提供を取得します。
   * @return 食事提供
   */
  public ACComboBox getMedicalFacilityCognitiveHospitalDinnerOffer(){
    if(medicalFacilityCognitiveHospitalDinnerOffer==null){

      medicalFacilityCognitiveHospitalDinnerOffer = new ACComboBox();

      getMedicalFacilityCognitiveHospitalDinnerOfferContainer().setText("食事提供");

      medicalFacilityCognitiveHospitalDinnerOffer.setBindPath("1530356");

      medicalFacilityCognitiveHospitalDinnerOffer.setEditable(false);

      medicalFacilityCognitiveHospitalDinnerOffer.setModelBindPath("1530356");

      medicalFacilityCognitiveHospitalDinnerOffer.setRenderBindPath("CONTENT");

      medicalFacilityCognitiveHospitalDinnerOffer.setModel(getMedicalFacilityCognitiveHospitalDinnerOfferModel());

      addMedicalFacilityCognitiveHospitalDinnerOffer();
    }
    return medicalFacilityCognitiveHospitalDinnerOffer;

  }

  /**
   * 食事提供コンテナを取得します。
   * @return 食事提供コンテナ
   */
  protected ACLabelContainer getMedicalFacilityCognitiveHospitalDinnerOfferContainer(){
    if(medicalFacilityCognitiveHospitalDinnerOfferContainer==null){
      medicalFacilityCognitiveHospitalDinnerOfferContainer = new ACLabelContainer();
      medicalFacilityCognitiveHospitalDinnerOfferContainer.setFollowChildEnabled(true);
      medicalFacilityCognitiveHospitalDinnerOfferContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityCognitiveHospitalDinnerOfferContainer.add(getMedicalFacilityCognitiveHospitalDinnerOffer(), null);
    }
    return medicalFacilityCognitiveHospitalDinnerOfferContainer;
  }

  /**
   * 食事提供モデルを取得します。
   * @return 食事提供モデル
   */
  protected ACComboBoxModelAdapter getMedicalFacilityCognitiveHospitalDinnerOfferModel(){
    if(medicalFacilityCognitiveHospitalDinnerOfferModel==null){
      medicalFacilityCognitiveHospitalDinnerOfferModel = new ACComboBoxModelAdapter();
      addMedicalFacilityCognitiveHospitalDinnerOfferModel();
    }
    return medicalFacilityCognitiveHospitalDinnerOfferModel;
  }

  /**
   * 食事費用を取得します。
   * @return 食事費用
   */
  public ACTextField getMedicalFacilityCognitiveHospitalDinnerCost(){
    if(medicalFacilityCognitiveHospitalDinnerCost==null){

      medicalFacilityCognitiveHospitalDinnerCost = new ACTextField();

      getMedicalFacilityCognitiveHospitalDinnerCostContainer().setText("食事費用");

      medicalFacilityCognitiveHospitalDinnerCost.setBindPath("1530358");

      medicalFacilityCognitiveHospitalDinnerCost.setColumns(4);

      medicalFacilityCognitiveHospitalDinnerCost.setCharType(VRCharType.ONLY_DIGIT);

      medicalFacilityCognitiveHospitalDinnerCost.setHorizontalAlignment(SwingConstants.RIGHT);

      medicalFacilityCognitiveHospitalDinnerCost.setIMEMode(InputSubset.LATIN);

      medicalFacilityCognitiveHospitalDinnerCost.setMaxLength(5);

      addMedicalFacilityCognitiveHospitalDinnerCost();
    }
    return medicalFacilityCognitiveHospitalDinnerCost;

  }

  /**
   * 食事費用コンテナを取得します。
   * @return 食事費用コンテナ
   */
  protected ACLabelContainer getMedicalFacilityCognitiveHospitalDinnerCostContainer(){
    if(medicalFacilityCognitiveHospitalDinnerCostContainer==null){
      medicalFacilityCognitiveHospitalDinnerCostContainer = new ACLabelContainer();
      medicalFacilityCognitiveHospitalDinnerCostContainer.setFollowChildEnabled(true);
      medicalFacilityCognitiveHospitalDinnerCostContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityCognitiveHospitalDinnerCostContainer.add(getMedicalFacilityCognitiveHospitalDinnerCost(), null);
    }
    return medicalFacilityCognitiveHospitalDinnerCostContainer;
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
   * 身体拘束廃止未実施減算を取得します。
   * @return 身体拘束廃止未実施減算
   */
  public ACValueArrayRadioButtonGroup getBodyRestraintAbolitionRadio(){
    if(bodyRestraintAbolitionRadio==null){

      bodyRestraintAbolitionRadio = new ACValueArrayRadioButtonGroup();

      getBodyRestraintAbolitionRadioContainer().setText("身体拘束廃止未実施減算");

      bodyRestraintAbolitionRadio.setBindPath("1530314");

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

      stayReturnSupportAddRadio.setBindPath("1530315");

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
  public ACRadioButtonItem getStayReturnSupportAddRadioitem1(){
    if(stayReturnSupportAddRadioitem1==null){

      stayReturnSupportAddRadioitem1 = new ACRadioButtonItem();

      stayReturnSupportAddRadioitem1.setText("なし");

      stayReturnSupportAddRadioitem1.setGroup(getStayReturnSupportAddRadio());

      stayReturnSupportAddRadioitem1.setConstraints(VRLayout.FLOW);

      addStayReturnSupportAddRadioitem1();
    }
    return stayReturnSupportAddRadioitem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getStayReturnSupportAddRadioitem2(){
    if(stayReturnSupportAddRadioitem2==null){

      stayReturnSupportAddRadioitem2 = new ACRadioButtonItem();

      stayReturnSupportAddRadioitem2.setText("あり");

      stayReturnSupportAddRadioitem2.setGroup(getStayReturnSupportAddRadio());

      stayReturnSupportAddRadioitem2.setConstraints(VRLayout.FLOW);

      addStayReturnSupportAddRadioitem2();
    }
    return stayReturnSupportAddRadioitem2;

  }

  /**
   * サービス提供体制強化加算を取得します。
   * @return サービス提供体制強化加算
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("サービス提供体制強化加算");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1530360");

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
   * 低栄養リスク改善加算を取得します。
   * @return 低栄養リスク改善加算
   */
  public ACValueArrayRadioButtonGroup getLowNutritionalRiskImprovementAdd(){
    if(lowNutritionalRiskImprovementAdd==null){

      lowNutritionalRiskImprovementAdd = new ACValueArrayRadioButtonGroup();

      getLowNutritionalRiskImprovementAddContainer().setText("低栄養リスク改善加算");

      lowNutritionalRiskImprovementAdd.setBindPath("1530363");

      lowNutritionalRiskImprovementAdd.setUseClearButton(false);

      lowNutritionalRiskImprovementAdd.setModel(getLowNutritionalRiskImprovementAddModel());

      lowNutritionalRiskImprovementAdd.setValues(new int[]{1,2});

      addLowNutritionalRiskImprovementAdd();
    }
    return lowNutritionalRiskImprovementAdd;

  }

  /**
   * 低栄養リスク改善加算コンテナを取得します。
   * @return 低栄養リスク改善加算コンテナ
   */
  protected ACLabelContainer getLowNutritionalRiskImprovementAddContainer(){
    if(lowNutritionalRiskImprovementAddContainer==null){
      lowNutritionalRiskImprovementAddContainer = new ACLabelContainer();
      lowNutritionalRiskImprovementAddContainer.setFollowChildEnabled(true);
      lowNutritionalRiskImprovementAddContainer.setVAlignment(VRLayout.CENTER);
      lowNutritionalRiskImprovementAddContainer.add(getLowNutritionalRiskImprovementAdd(), null);
    }
    return lowNutritionalRiskImprovementAddContainer;
  }

  /**
   * 低栄養リスク改善加算モデルを取得します。
   * @return 低栄養リスク改善加算モデル
   */
  protected ACListModelAdapter getLowNutritionalRiskImprovementAddModel(){
    if(lowNutritionalRiskImprovementAddModel==null){
      lowNutritionalRiskImprovementAddModel = new ACListModelAdapter();
      addLowNutritionalRiskImprovementAddModel();
    }
    return lowNutritionalRiskImprovementAddModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getLowNutritionalRiskImprovementAddItem1(){
    if(lowNutritionalRiskImprovementAddItem1==null){

      lowNutritionalRiskImprovementAddItem1 = new ACRadioButtonItem();

      lowNutritionalRiskImprovementAddItem1.setText("なし");

      lowNutritionalRiskImprovementAddItem1.setGroup(getLowNutritionalRiskImprovementAdd());

      lowNutritionalRiskImprovementAddItem1.setConstraints(VRLayout.FLOW);

      addLowNutritionalRiskImprovementAddItem1();
    }
    return lowNutritionalRiskImprovementAddItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getLowNutritionalRiskImprovementAddItem2(){
    if(lowNutritionalRiskImprovementAddItem2==null){

      lowNutritionalRiskImprovementAddItem2 = new ACRadioButtonItem();

      lowNutritionalRiskImprovementAddItem2.setText("あり");

      lowNutritionalRiskImprovementAddItem2.setGroup(getLowNutritionalRiskImprovementAdd());

      lowNutritionalRiskImprovementAddItem2.setConstraints(VRLayout.FLOW);

      addLowNutritionalRiskImprovementAddItem2();
    }
    return lowNutritionalRiskImprovementAddItem2;

  }

  /**
   * 排せつ支援加算を取得します。
   * @return 排せつ支援加算
   */
  public ACValueArrayRadioButtonGroup getExcretionSupport(){
    if(excretionSupport==null){

      excretionSupport = new ACValueArrayRadioButtonGroup();

      getExcretionSupportContainer().setText("排せつ支援加算");

      excretionSupport.setBindPath("1530364");

      excretionSupport.setUseClearButton(false);

      excretionSupport.setModel(getExcretionSupportModel());

      excretionSupport.setValues(new int[]{1,2});

      addExcretionSupport();
    }
    return excretionSupport;

  }

  /**
   * 排せつ支援加算コンテナを取得します。
   * @return 排せつ支援加算コンテナ
   */
  protected ACLabelContainer getExcretionSupportContainer(){
    if(excretionSupportContainer==null){
      excretionSupportContainer = new ACLabelContainer();
      excretionSupportContainer.setFollowChildEnabled(true);
      excretionSupportContainer.setVAlignment(VRLayout.CENTER);
      excretionSupportContainer.add(getExcretionSupport(), null);
    }
    return excretionSupportContainer;
  }

  /**
   * 排せつ支援加算モデルを取得します。
   * @return 排せつ支援加算モデル
   */
  protected ACListModelAdapter getExcretionSupportModel(){
    if(excretionSupportModel==null){
      excretionSupportModel = new ACListModelAdapter();
      addExcretionSupportModel();
    }
    return excretionSupportModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getExcretionSupportItem1(){
    if(excretionSupportItem1==null){

      excretionSupportItem1 = new ACRadioButtonItem();

      excretionSupportItem1.setText("なし");

      excretionSupportItem1.setGroup(getExcretionSupport());

      excretionSupportItem1.setConstraints(VRLayout.FLOW);

      addExcretionSupportItem1();
    }
    return excretionSupportItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getExcretionSupportItem2(){
    if(excretionSupportItem2==null){

      excretionSupportItem2 = new ACRadioButtonItem();

      excretionSupportItem2.setText("あり");

      excretionSupportItem2.setGroup(getExcretionSupport());

      excretionSupportItem2.setConstraints(VRLayout.FLOW);

      addExcretionSupportItem2();
    }
    return excretionSupportItem2;

  }

  /**
   * 算定区分を取得します。
   * @return 算定区分
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityCognitiveHospitalCalculationDivisionRadio(){
    if(medicalFacilityCognitiveHospitalCalculationDivisionRadio==null){

      medicalFacilityCognitiveHospitalCalculationDivisionRadio = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityCognitiveHospitalCalculationDivisionRadioContainer().setText("算定区分");

      medicalFacilityCognitiveHospitalCalculationDivisionRadio.setBindPath("9");

      medicalFacilityCognitiveHospitalCalculationDivisionRadio.setUseClearButton(false);

      medicalFacilityCognitiveHospitalCalculationDivisionRadio.setModel(getMedicalFacilityCognitiveHospitalCalculationDivisionRadioModel());

      medicalFacilityCognitiveHospitalCalculationDivisionRadio.setValues(new int[]{1,2});

      addMedicalFacilityCognitiveHospitalCalculationDivisionRadio();
    }
    return medicalFacilityCognitiveHospitalCalculationDivisionRadio;

  }

  /**
   * 算定区分コンテナを取得します。
   * @return 算定区分コンテナ
   */
  protected ACLabelContainer getMedicalFacilityCognitiveHospitalCalculationDivisionRadioContainer(){
    if(medicalFacilityCognitiveHospitalCalculationDivisionRadioContainer==null){
      medicalFacilityCognitiveHospitalCalculationDivisionRadioContainer = new ACLabelContainer();
      medicalFacilityCognitiveHospitalCalculationDivisionRadioContainer.setFollowChildEnabled(true);
      medicalFacilityCognitiveHospitalCalculationDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityCognitiveHospitalCalculationDivisionRadioContainer.add(getMedicalFacilityCognitiveHospitalCalculationDivisionRadio(), null);
    }
    return medicalFacilityCognitiveHospitalCalculationDivisionRadioContainer;
  }

  /**
   * 算定区分モデルを取得します。
   * @return 算定区分モデル
   */
  protected ACListModelAdapter getMedicalFacilityCognitiveHospitalCalculationDivisionRadioModel(){
    if(medicalFacilityCognitiveHospitalCalculationDivisionRadioModel==null){
      medicalFacilityCognitiveHospitalCalculationDivisionRadioModel = new ACListModelAdapter();
      addMedicalFacilityCognitiveHospitalCalculationDivisionRadioModel();
    }
    return medicalFacilityCognitiveHospitalCalculationDivisionRadioModel;
  }

  /**
   * 通常を取得します。
   * @return 通常
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalCalculationDivisionRadioItem1(){
    if(medicalFacilityCognitiveHospitalCalculationDivisionRadioItem1==null){

      medicalFacilityCognitiveHospitalCalculationDivisionRadioItem1 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalCalculationDivisionRadioItem1.setText("通常");

      medicalFacilityCognitiveHospitalCalculationDivisionRadioItem1.setGroup(getMedicalFacilityCognitiveHospitalCalculationDivisionRadio());

      medicalFacilityCognitiveHospitalCalculationDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalCalculationDivisionRadioItem1();
    }
    return medicalFacilityCognitiveHospitalCalculationDivisionRadioItem1;

  }

  /**
   * 加算のみを取得します。
   * @return 加算のみ
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalCalculationDivisionRadioItem2(){
    if(medicalFacilityCognitiveHospitalCalculationDivisionRadioItem2==null){

      medicalFacilityCognitiveHospitalCalculationDivisionRadioItem2 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalCalculationDivisionRadioItem2.setText("加算のみ");

      medicalFacilityCognitiveHospitalCalculationDivisionRadioItem2.setGroup(getMedicalFacilityCognitiveHospitalCalculationDivisionRadio());

      medicalFacilityCognitiveHospitalCalculationDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalCalculationDivisionRadioItem2();
    }
    return medicalFacilityCognitiveHospitalCalculationDivisionRadioItem2;

  }

  /**
   * コンストラクタです。
   */
  public QS001_15313_201804Design() {

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

    tab1.add(getMedicalFacilityCognitiveHospitalInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHospitalDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityCognitiveHospitalHospitalDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityCognitiveHospitalHospitalRoomContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHospitalizedPatientsCriteriaRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getUnitCareMaintenanceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 施設等の区分に内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalInstitutionDivisionRadio(){

  }

  /**
   * 施設等の区分モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalInstitutionDivisionRadioModel(){

    getMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem1().setButtonIndex(1);

    getMedicalFacilityCognitiveHospitalInstitutionDivisionRadioModel().add(getMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem1());

    getMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem2().setButtonIndex(2);

    getMedicalFacilityCognitiveHospitalInstitutionDivisionRadioModel().add(getMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem2());

    getMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem3().setButtonIndex(3);

    getMedicalFacilityCognitiveHospitalInstitutionDivisionRadioModel().add(getMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem3());

  }

  /**
   * 認知症疾患型に内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem1(){

  }

  /**
   * ユニット型認知症疾患型に内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem2(){

  }

  /**
   * 経過型に内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem3(){

  }

  /**
   * 病院区分に内部項目を追加します。
   */
  protected void addHospitalDivisionRadio(){

  }

  /**
   * 病院区分モデルに内部項目を追加します。
   */
  protected void addHospitalDivisionRadioModel(){

    getHospitalDivisionRadioItem1().setButtonIndex(1);

    getHospitalDivisionRadioModel().add(getHospitalDivisionRadioItem1());

    getHospitalDivisionRadioItem2().setButtonIndex(2);

    getHospitalDivisionRadioModel().add(getHospitalDivisionRadioItem2());

  }

  /**
   * 大学病院に内部項目を追加します。
   */
  protected void addHospitalDivisionRadioItem1(){

  }

  /**
   * 一般病院に内部項目を追加します。
   */
  protected void addHospitalDivisionRadioItem2(){

  }

  /**
   * 人員配置区分に内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalHospitalDivision(){

  }

  /**
   * 人員配置区分モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalHospitalDivisionModel(){

    getMedicalFacilityCognitiveHospitalDivision1().setButtonIndex(1);

    getMedicalFacilityCognitiveHospitalHospitalDivisionModel().add(getMedicalFacilityCognitiveHospitalDivision1());

    getMedicalFacilityCognitiveHospitalDivision2().setButtonIndex(2);

    getMedicalFacilityCognitiveHospitalHospitalDivisionModel().add(getMedicalFacilityCognitiveHospitalDivision2());

    getMedicalFacilityCognitiveHospitalDivision3().setButtonIndex(3);

    getMedicalFacilityCognitiveHospitalHospitalDivisionModel().add(getMedicalFacilityCognitiveHospitalDivision3());

    getMedicalFacilityCognitiveHospitalDivision4().setButtonIndex(4);

    getMedicalFacilityCognitiveHospitalHospitalDivisionModel().add(getMedicalFacilityCognitiveHospitalDivision4());

    getMedicalFacilityCognitiveHospitalDivision5().setButtonIndex(5);

    getMedicalFacilityCognitiveHospitalHospitalDivisionModel().add(getMedicalFacilityCognitiveHospitalDivision5());

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalDivision1(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalDivision2(){

  }

  /**
   * III型に内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalDivision3(){

  }

  /**
   * IV型に内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalDivision4(){

  }

  /**
   * V型に内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalDivision5(){

  }

  /**
   * 病室区分コンテナに内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalHospitalRoomContena(){

    medicalFacilityCognitiveHospitalHospitalRoomContena.add(getMedicalFacilityCognitiveHospitalHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalFacilityCognitiveHospitalHospitalRoomContena.add(getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 病室区分（病院）に内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalHospitalRoomRadio(){

  }

  /**
   * 病室区分（病院）モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalHospitalRoomRadioModel(){

    getMedicalFacilityCognitiveHospitalHospitalRoomRadioItem1().setButtonIndex(1);

    getMedicalFacilityCognitiveHospitalHospitalRoomRadioModel().add(getMedicalFacilityCognitiveHospitalHospitalRoomRadioItem1());

    getMedicalFacilityCognitiveHospitalHospitalRoomRadioItem2().setButtonIndex(2);

    getMedicalFacilityCognitiveHospitalHospitalRoomRadioModel().add(getMedicalFacilityCognitiveHospitalHospitalRoomRadioItem2());

  }

  /**
   * 従来型個室に内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalHospitalRoomRadioItem1(){

  }

  /**
   * 多床室に内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalHospitalRoomRadioItem2(){

  }

  /**
   * 病室区分（ユニット型）に内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalUnitHospitalRoomRadio(){

  }

  /**
   * 病室区分（ユニット型）モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioModel(){

    getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem1().setButtonIndex(1);

    getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioModel().add(getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem1());

    getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem2().setButtonIndex(2);

    getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioModel().add(getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem2());

  }

  /**
   * ユニット型個室に内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem1(){

  }

  /**
   * ユニット型個室的多床室に内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem2(){

  }

  /**
   * 入院患者に関する基準に内部項目を追加します。
   */
  protected void addHospitalizedPatientsCriteriaRadio(){

  }

  /**
   * 入院患者に関する基準モデルに内部項目を追加します。
   */
  protected void addHospitalizedPatientsCriteriaRadioModel(){

    getHospitalizedPatientsCriteriaRadioItem1().setButtonIndex(2);

    getHospitalizedPatientsCriteriaRadioModel().add(getHospitalizedPatientsCriteriaRadioItem1());

    getHospitalizedPatientsCriteriaRadioItem2().setButtonIndex(1);

    getHospitalizedPatientsCriteriaRadioModel().add(getHospitalizedPatientsCriteriaRadioItem2());

  }

  /**
   * 基準型に内部項目を追加します。
   */
  protected void addHospitalizedPatientsCriteriaRadioItem1(){

  }

  /**
   * 減算型に内部項目を追加します。
   */
  protected void addHospitalizedPatientsCriteriaRadioItem2(){

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
   * タブ2に内部項目を追加します。
   */
  protected void addTab2(){

    tab2.add(getMedicalFacilityCognitiveHospitalStayRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityCognitiveHospitalStandardRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityCognitiveHospitalMedicalExaminationRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityCognitiveHospitalNutritionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityCognitiveHospitalOralSwitchRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getOralMaintenanceAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getOralKeepStructureAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 外泊加算に内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalStayRadio(){

  }

  /**
   * 外泊加算モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalStayRadioModel(){

    getMedicalFacilityCognitiveHospitalStayRadioItem1().setButtonIndex(1);

    getMedicalFacilityCognitiveHospitalStayRadioModel().add(getMedicalFacilityCognitiveHospitalStayRadioItem1());

    getMedicalFacilityCognitiveHospitalStayRadioItem2().setButtonIndex(2);

    getMedicalFacilityCognitiveHospitalStayRadioModel().add(getMedicalFacilityCognitiveHospitalStayRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalStayRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalStayRadioItem2(){

  }

  /**
   * 初期加算に内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalStandardRadio(){

  }

  /**
   * 初期加算モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalStandardRadioModel(){

    getMedicalFacilityCognitiveHospitalStandardRadioItem1().setButtonIndex(1);

    getMedicalFacilityCognitiveHospitalStandardRadioModel().add(getMedicalFacilityCognitiveHospitalStandardRadioItem1());

    getMedicalFacilityCognitiveHospitalStandardRadioItem2().setButtonIndex(2);

    getMedicalFacilityCognitiveHospitalStandardRadioModel().add(getMedicalFacilityCognitiveHospitalStandardRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalStandardRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalStandardRadioItem2(){

  }

  /**
   * 他科受診に内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalMedicalExaminationRadio(){

  }

  /**
   * 他科受診モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalMedicalExaminationRadioModel(){

    getMedicalFacilityCognitiveHospitalMedicalExaminationRadioItem1().setButtonIndex(1);

    getMedicalFacilityCognitiveHospitalMedicalExaminationRadioModel().add(getMedicalFacilityCognitiveHospitalMedicalExaminationRadioItem1());

    getMedicalFacilityCognitiveHospitalMedicalExaminationRadioItem2().setButtonIndex(2);

    getMedicalFacilityCognitiveHospitalMedicalExaminationRadioModel().add(getMedicalFacilityCognitiveHospitalMedicalExaminationRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalMedicalExaminationRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalMedicalExaminationRadioItem2(){

  }

  /**
   * 栄養マネジメント加算に内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalNutritionRadio(){

  }

  /**
   * 栄養マネジメント加算モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalNutritionRadioModel(){

    getMedicalFacilityCognitiveHospitalNutritionRadioItem1().setButtonIndex(1);

    getMedicalFacilityCognitiveHospitalNutritionRadioModel().add(getMedicalFacilityCognitiveHospitalNutritionRadioItem1());

    getMedicalFacilityCognitiveHospitalNutritionRadioItem2().setButtonIndex(2);

    getMedicalFacilityCognitiveHospitalNutritionRadioModel().add(getMedicalFacilityCognitiveHospitalNutritionRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalNutritionRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalNutritionRadioItem2(){

  }

  /**
   * 経口移行加算に内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalOralSwitchRadio(){

  }

  /**
   * 経口移行加算モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalOralSwitchRadioModel(){

    getMedicalFacilityCognitiveHospitalOralSwitchRadioItem1().setButtonIndex(1);

    getMedicalFacilityCognitiveHospitalOralSwitchRadioModel().add(getMedicalFacilityCognitiveHospitalOralSwitchRadioItem1());

    getMedicalFacilityCognitiveHospitalOralSwitchRadioItem2().setButtonIndex(2);

    getMedicalFacilityCognitiveHospitalOralSwitchRadioModel().add(getMedicalFacilityCognitiveHospitalOralSwitchRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalOralSwitchRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalOralSwitchRadioItem2(){

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
  protected void addYoungDementiaPatinetAddRadioGroup(){

  }

  /**
   * 口腔衛生管理加算モデルに内部項目を追加します。
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
   * 療養食加算に内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalRecuperateDinnerRadio(){

  }

  /**
   * 療養食加算モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalRecuperateDinnerRadioModel(){

    getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem1().setButtonIndex(1);

    getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioModel().add(getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem1());

    getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem2().setButtonIndex(2);

    getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioModel().add(getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem2());

    getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem3().setButtonIndex(3);

    getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioModel().add(getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem3());

    getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem4().setButtonIndex(4);

    getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioModel().add(getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem4());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem1(){

  }

  /**
   * 3回に内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem2(){

  }

  /**
   * 2回に内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem3(){

  }

  /**
   * 1回に内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem4(){

  }

  /**
   * タブ3に内部項目を追加します。
   */
  protected void addTab3(){

    tab3.add(getMedicalFacilityCognitiveHospitalHijoAddition(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getMedicalFacilityCognitiveHospitalConsultationFee(), VRLayout.FLOW);

    tab3.add(getMedicalFacilityCognitiveHospitalConsultationFeeLabel(), VRLayout.FLOW_RETURN);

    tab3.add(getMedicalFacilityCognitiveHospitalSubstractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getMedicalFacilityCognitiveHospitalDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * 退所関連加算に内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalHijoAddition(){

    medicalFacilityCognitiveHospitalHijoAddition.add(getLeavingHospitalPreConsultationAddition(), VRLayout.FLOW_RETURN);

    medicalFacilityCognitiveHospitalHijoAddition.add(getLeavingHospitalAfterConsultationAddition(), VRLayout.FLOW_RETURN);

    medicalFacilityCognitiveHospitalHijoAddition.add(getLeavingHospitalConsultationAddition(), VRLayout.FLOW_RETURN);

    medicalFacilityCognitiveHospitalHijoAddition.add(getLeavingHospitalDissemination(), VRLayout.FLOW_RETURN);

    medicalFacilityCognitiveHospitalHijoAddition.add(getLeavingHospitalCooperationAddition(), VRLayout.FLOW_RETURN);

    medicalFacilityCognitiveHospitalHijoAddition.add(getLeavingHospital(), VRLayout.FLOW_RETURN);

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
   * 訪問看護指示加算に内部項目を追加します。
   */
  protected void addLeavingHospital(){

  }

  /**
   * 特定診療費に内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalConsultationFee(){

  }

  /**
   * ラベルに内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalConsultationFeeLabel(){

  }

  /**
   * 人員減算に内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalSubstraction(){

  }

  /**
   * 人員減算モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalSubstractionModel(){

  }

  /**
   * 食事コンテナに内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalDinnerContainer(){

    medicalFacilityCognitiveHospitalDinnerContainer.add(getMedicalFacilityCognitiveHospitalDinnerOfferContainer(), VRLayout.FLOW);

    medicalFacilityCognitiveHospitalDinnerContainer.add(getMedicalFacilityCognitiveHospitalDinnerCostContainer(), VRLayout.FLOW);

  }

  /**
   * 食事提供に内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalDinnerOffer(){

  }

  /**
   * 食事提供モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalDinnerOfferModel(){

  }

  /**
   * 食事費用に内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalDinnerCost(){

  }

  /**
   * タブ4に内部項目を追加します。
   */
  protected void addTab4(){

    tab4.add(getBodyRestraintAbolitionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getStayReturnSupportAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getLowNutritionalRiskImprovementAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getExcretionSupportContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getMedicalFacilityCognitiveHospitalCalculationDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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

    getStayReturnSupportAddRadioitem1().setButtonIndex(1);

    getStayReturnSupportAddRadioModel().add(getStayReturnSupportAddRadioitem1());

    getStayReturnSupportAddRadioitem2().setButtonIndex(2);

    getStayReturnSupportAddRadioModel().add(getStayReturnSupportAddRadioitem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addStayReturnSupportAddRadioitem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addStayReturnSupportAddRadioitem2(){

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
   * 低栄養リスク改善加算に内部項目を追加します。
   */
  protected void addLowNutritionalRiskImprovementAdd(){

  }

  /**
   * 低栄養リスク改善加算モデルに内部項目を追加します。
   */
  protected void addLowNutritionalRiskImprovementAddModel(){

    getLowNutritionalRiskImprovementAddItem1().setButtonIndex(1);

    getLowNutritionalRiskImprovementAddModel().add(getLowNutritionalRiskImprovementAddItem1());

    getLowNutritionalRiskImprovementAddItem2().setButtonIndex(2);

    getLowNutritionalRiskImprovementAddModel().add(getLowNutritionalRiskImprovementAddItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addLowNutritionalRiskImprovementAddItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addLowNutritionalRiskImprovementAddItem2(){

  }

  /**
   * 排せつ支援加算に内部項目を追加します。
   */
  protected void addExcretionSupport(){

  }

  /**
   * 排せつ支援加算モデルに内部項目を追加します。
   */
  protected void addExcretionSupportModel(){

    getExcretionSupportItem1().setButtonIndex(1);

    getExcretionSupportModel().add(getExcretionSupportItem1());

    getExcretionSupportItem2().setButtonIndex(2);

    getExcretionSupportModel().add(getExcretionSupportItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addExcretionSupportItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addExcretionSupportItem2(){

  }

  /**
   * 算定区分に内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalCalculationDivisionRadio(){

  }

  /**
   * 算定区分モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalCalculationDivisionRadioModel(){

    getMedicalFacilityCognitiveHospitalCalculationDivisionRadioItem1().setButtonIndex(1);

    getMedicalFacilityCognitiveHospitalCalculationDivisionRadioModel().add(getMedicalFacilityCognitiveHospitalCalculationDivisionRadioItem1());

    getMedicalFacilityCognitiveHospitalCalculationDivisionRadioItem2().setButtonIndex(2);

    getMedicalFacilityCognitiveHospitalCalculationDivisionRadioModel().add(getMedicalFacilityCognitiveHospitalCalculationDivisionRadioItem2());

  }

  /**
   * 通常に内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalCalculationDivisionRadioItem1(){

  }

  /**
   * 加算のみに内部項目を追加します。
   */
  protected void addMedicalFacilityCognitiveHospitalCalculationDivisionRadioItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_15313_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001_15313_201804Design getThis() {
    return this;
  }
}
