
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
 * 作成日: 2015/03/09  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン介護福祉施設 (QS001_15111_201504)
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
 * サービスパターン介護福祉施設画面項目デザイン(QS001_15111_201504) 
 */
public class QS001_15111_201504Design extends QS001ServicePanel {
  //GUIコンポーネント

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityInstitutionDivisionRadio;

  private ACLabelContainer kaigoWelfareFacilityInstitutionDivisionRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityInstitutionDivisionRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityInstitutionDivisionRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityInstitutionDivisionRadioItem2;

  private ACRadioButtonItem kaigoWelfareFacilityInstitutionDivisionRadioItem3;

  private ACRadioButtonItem kaigoWelfareFacilityInstitutionDivisionRadioItem4;

  private ACIntegerCheckBox kaigoWelfareFacilityOldMeasuresPerson;

  private ACLabelContainer kaigoWelfareFacilityHospitalRoomDivisionContena;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityHospitalRoomDivisionRadio;

  private ACListModelAdapter kaigoWelfareFacilityHospitalRoomDivisionRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityHospitalRoomDivisionRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityHospitalRoomDivisionRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityUnitHospitalRoomDivisionRadio;

  private ACListModelAdapter kaigoWelfareFacilityUnitHospitalRoomDivisionRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityUnitCareMaintenanceRadio;

  private ACLabelContainer kaigoWelfareFacilityUnitCareMaintenanceRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityUnitCareMaintenanceRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityUnitCareMaintenanceRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityUnitCareMaintenanceRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityJunUnitCareAddRadio;

  private ACLabelContainer kaigoWelfareFacilityJunUnitCareAddRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityJunUnitCareAddRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityJunUnitCareAddRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityJunUnitCareAddRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityNightShiftSubtractionRadio;

  private ACLabelContainer kaigoWelfareFacilityNightShiftSubtractionRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityNightShiftSubtractionRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityNightShiftSubtractionRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityNightShiftSubtractionRadioItem2;

  private ACValueArrayRadioButtonGroup dailyLifeContinuanceRadioGroup;

  private ACLabelContainer dailyLifeContinuanceRadioGroupContainer;

  private ACListModelAdapter dailyLifeContinuanceRadioGroupModel;

  private ACRadioButtonItem dailyLifeContinuanceRadioItem1;

  private ACRadioButtonItem dailyLifeContinuanceRadioItem2;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityFunctionTrainingRadio;

  private ACLabelContainer kaigoWelfareFacilityFunctionTrainingRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityFunctionTrainingRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityFunctionTrainingRadioItem2;

  private ACRadioButtonItem kaigoWelfareFacilityFunctionTrainingRadioItem1;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityHandicappedRadio;

  private ACLabelContainer kaigoWelfareFacilityHandicappedRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityHandicappedRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityHandicappedRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityHandicappedRadioItem2;

  private ACLabelContainer nurseStructuralAddGroup;

  private ACIntegerCheckBox nurseStructuralAddCheckItem1;

  private ACIntegerCheckBox nurseStructuralAddCheckItem2;

  private ACValueArrayRadioButtonGroup nightStaffDispositionAddRadioGroup;

  private ACLabelContainer nightStaffDispositionAddRadioGroupContainer;

  private ACListModelAdapter nightStaffDispositionAddRadioGroupModel;

  private ACRadioButtonItem nightStaffDispositionAddRadioItem1;

  private ACRadioButtonItem nightStaffDispositionAddRadioItem2;

  private ACValueArrayRadioButtonGroup stayPeopleCountRadioGroup;

  private ACLabelContainer stayPeopleCountRadioGroupContainer;

  private ACListModelAdapter stayPeopleCountRadioGroupModel;

  private ACRadioButtonItem stayPeopleCountRadioItem1;

  private ACRadioButtonItem stayPeopleCountRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityFacilityFulltimeDoctorRadio;

  private ACLabelContainer kaigoWelfareFacilityFacilityFulltimeDoctorRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityFacilityFulltimeDoctorRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityPsychiatristRadio;

  private ACLabelContainer kaigoWelfareFacilityPsychiatristRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityPsychiatristRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityPsychiatristRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityPsychiatristRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityStayingOutOvernightCostRadio;

  private ACLabelContainer kaigoWelfareFacilityStayingOutOvernightCostRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityStayingOutOvernightCostRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityStayingOutOvernightCostRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityStayingOutOvernightCostRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityDefaultRadio;

  private ACLabelContainer kaigoWelfareFacilityDefaultRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityDefaultRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityDefaultRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityDefaultRadioItem2;

  private ACPanel tab3;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityNutritionRadio;

  private ACLabelContainer kaigoWelfareFacilityNutritionRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityNutritionRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityNutritionRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityNutritionRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityOralSwitchRadio;

  private ACLabelContainer kaigoWelfareFacilityOralSwitchRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityOralSwitchRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityOralSwitchRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityOralSwitchRadioItem2;

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

  private ACValueArrayRadioButtonGroup oralKeepAddRadioGroup;

  private ACLabelContainer oralKeepAddRadioGroupContainer;

  private ACListModelAdapter oralKeepAddRadioGroupModel;

  private ACRadioButtonItem oralKeepAddRadioItem1;

  private ACRadioButtonItem oralKeepAddRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityRecuperateDinnerRadio;

  private ACLabelContainer kaigoWelfareFacilityRecuperateDinnerRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityRecuperateDinnerRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityRecuperateDinnerRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityRecuperateDinnerRadioItem2;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACLabelContainer kaigoWelfareFacilityHijoAddition;

  private ACIntegerCheckBox hijoPreConsultationAddition;

  private ACIntegerCheckBox hijoAfterConsultationAddition;

  private ACIntegerCheckBox hijoConsultationAddition;

  private ACIntegerCheckBox hijoCooperationAddition;

  private ACPanel tab4;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityStaffSubtraction;

  private ACLabelContainer kaigoWelfareFacilityStaffSubtractionContainer;

  private ACListModelAdapter kaigoWelfareFacilityStaffSubtractionModel;

  private ACRadioButtonItem kaigoWelfareFacilityStaffSubtractionCapacityNot;

  private ACRadioButtonItem kaigoWelfareFacilityStaffSubtractionCapacityExcess;

  private ACRadioButtonItem kaigoWelfareFacilityStaffSubtractionPersonLack;

  private ACBackLabelContainer kaigoWelfareFacilityDinnerContainer;

  private ACComboBox kaigoWelfareFacilityDinnerOffer;

  private ACLabelContainer kaigoWelfareFacilityDinnerOfferContainer;

  private ACComboBoxModelAdapter kaigoWelfareFacilityDinnerOfferModel;

  private ACTextField kaigoWelfareFacilityDinnerCost;

  private ACLabelContainer kaigoWelfareFacilityDinnerCostContainer;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityBodyRestraintAbolitionRadio;

  private ACLabelContainer kaigoWelfareFacilityBodyRestraintAbolitionRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityBodyRestraintAbolitionRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityBodyRestraintAbolitionRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityBodyRestraintAbolitionRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityTakingCareNursingAddRadio;

  private ACLabelContainer kaigoWelfareFacilityTakingCareNursingAddRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityTakingCareNursingAddRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityTakingCareNursingAddRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityTakingCareNursingAddRadioItem2;

  private ACRadioButtonItem kaigoWelfareFacilityTakingCareNursingAddRadioItem3;

  private ACRadioButtonItem kaigoWelfareFacilityTakingCareNursingAddRadioItem4;

  private ACLabelContainer kaigoWelfareFacilityTakingCareNursingAddDaysContainer;

  private ACTextField kaigoWelfareFacilityTakingCareNursingAddDays;

  private ACLabel kaigoWelfareFacilityTakingCareNursingAddDaysUnit;

  private ACPanel tab5;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityStayReturnSupportAddRadio;

  private ACLabelContainer kaigoWelfareFacilityStayReturnSupportAddRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityStayReturnSupportAddRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityStayReturnSupportAddRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityStayReturnSupportAddRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityHomeShareAddRadio;

  private ACLabelContainer kaigoWelfareFacilityHomeShareAddRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityHomeShareAddRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityHomeShareAddRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityHomeShareAddRadioItem2;

  private ACValueArrayRadioButtonGroup dementiaProfessionalCareAddRadioGroup;

  private ACLabelContainer dementiaProfessionalCareAddRadioGroupContainer;

  private ACListModelAdapter dementiaProfessionalCareAddRadioGroupModel;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem1;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem2;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem3;

  private ACValueArrayRadioButtonGroup dementiaEmergencyAddRadioGroup;

  private ACLabelContainer dementiaEmergencyAddRadioGroupContainer;

  private ACListModelAdapter dementiaEmergencyAddRadioGroupModel;

  private ACRadioButtonItem dementiaEmergencyAddRadioItem1;

  private ACRadioButtonItem dementiaEmergencyAddRadioItem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem5;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityCalculationDivisionRadilo;

  private ACLabelContainer kaigoWelfareFacilityCalculationDivisionRadiloContainer;

  private ACListModelAdapter kaigoWelfareFacilityCalculationDivisionRadiloModel;

  private ACRadioButtonItem kaigoWelfareFacilityCalculationDivisionRadiloItem1;

  private ACRadioButtonItem kaigoWelfareFacilityCalculationDivisionRadiloItem2;

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
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityInstitutionDivisionRadio(){
    if(kaigoWelfareFacilityInstitutionDivisionRadio==null){

      kaigoWelfareFacilityInstitutionDivisionRadio = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityInstitutionDivisionRadioContainer().setText("施設等の区分");

      kaigoWelfareFacilityInstitutionDivisionRadio.setBindPath("1510101");

      kaigoWelfareFacilityInstitutionDivisionRadio.setUseClearButton(false);

      kaigoWelfareFacilityInstitutionDivisionRadio.setModel(getKaigoWelfareFacilityInstitutionDivisionRadioModel());

      kaigoWelfareFacilityInstitutionDivisionRadio.setValues(new int[]{1,2,3,4});

      addKaigoWelfareFacilityInstitutionDivisionRadio();
    }
    return kaigoWelfareFacilityInstitutionDivisionRadio;

  }

  /**
   * 施設等の区分コンテナを取得します。
   * @return 施設等の区分コンテナ
   */
  protected ACLabelContainer getKaigoWelfareFacilityInstitutionDivisionRadioContainer(){
    if(kaigoWelfareFacilityInstitutionDivisionRadioContainer==null){
      kaigoWelfareFacilityInstitutionDivisionRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityInstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityInstitutionDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityInstitutionDivisionRadioContainer.add(getKaigoWelfareFacilityInstitutionDivisionRadio(), null);
    }
    return kaigoWelfareFacilityInstitutionDivisionRadioContainer;
  }

  /**
   * 施設等の区分モデルを取得します。
   * @return 施設等の区分モデル
   */
  protected ACListModelAdapter getKaigoWelfareFacilityInstitutionDivisionRadioModel(){
    if(kaigoWelfareFacilityInstitutionDivisionRadioModel==null){
      kaigoWelfareFacilityInstitutionDivisionRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityInstitutionDivisionRadioModel();
    }
    return kaigoWelfareFacilityInstitutionDivisionRadioModel;
  }

  /**
   * 介護福祉施設を取得します。
   * @return 介護福祉施設
   */
  public ACRadioButtonItem getKaigoWelfareFacilityInstitutionDivisionRadioItem1(){
    if(kaigoWelfareFacilityInstitutionDivisionRadioItem1==null){

      kaigoWelfareFacilityInstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityInstitutionDivisionRadioItem1.setText("介護福祉施設");

      kaigoWelfareFacilityInstitutionDivisionRadioItem1.setGroup(getKaigoWelfareFacilityInstitutionDivisionRadio());

      kaigoWelfareFacilityInstitutionDivisionRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoWelfareFacilityInstitutionDivisionRadioItem1();
    }
    return kaigoWelfareFacilityInstitutionDivisionRadioItem1;

  }

  /**
   * 小規模介護福祉施設を取得します。
   * @return 小規模介護福祉施設
   */
  public ACRadioButtonItem getKaigoWelfareFacilityInstitutionDivisionRadioItem2(){
    if(kaigoWelfareFacilityInstitutionDivisionRadioItem2==null){

      kaigoWelfareFacilityInstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityInstitutionDivisionRadioItem2.setText("小規模介護福祉施設");

      kaigoWelfareFacilityInstitutionDivisionRadioItem2.setGroup(getKaigoWelfareFacilityInstitutionDivisionRadio());

      kaigoWelfareFacilityInstitutionDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoWelfareFacilityInstitutionDivisionRadioItem2();
    }
    return kaigoWelfareFacilityInstitutionDivisionRadioItem2;

  }

  /**
   * ユニット型介護福祉施設を取得します。
   * @return ユニット型介護福祉施設
   */
  public ACRadioButtonItem getKaigoWelfareFacilityInstitutionDivisionRadioItem3(){
    if(kaigoWelfareFacilityInstitutionDivisionRadioItem3==null){

      kaigoWelfareFacilityInstitutionDivisionRadioItem3 = new ACRadioButtonItem();

      kaigoWelfareFacilityInstitutionDivisionRadioItem3.setText("ユニット型介護福祉施設");

      kaigoWelfareFacilityInstitutionDivisionRadioItem3.setGroup(getKaigoWelfareFacilityInstitutionDivisionRadio());

      kaigoWelfareFacilityInstitutionDivisionRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoWelfareFacilityInstitutionDivisionRadioItem3();
    }
    return kaigoWelfareFacilityInstitutionDivisionRadioItem3;

  }

  /**
   * ユニット型小規模介護福祉施設を取得します。
   * @return ユニット型小規模介護福祉施設
   */
  public ACRadioButtonItem getKaigoWelfareFacilityInstitutionDivisionRadioItem4(){
    if(kaigoWelfareFacilityInstitutionDivisionRadioItem4==null){

      kaigoWelfareFacilityInstitutionDivisionRadioItem4 = new ACRadioButtonItem();

      kaigoWelfareFacilityInstitutionDivisionRadioItem4.setText("ユニット型小規模介護福祉施設");

      kaigoWelfareFacilityInstitutionDivisionRadioItem4.setGroup(getKaigoWelfareFacilityInstitutionDivisionRadio());

      kaigoWelfareFacilityInstitutionDivisionRadioItem4.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityInstitutionDivisionRadioItem4();
    }
    return kaigoWelfareFacilityInstitutionDivisionRadioItem4;

  }

  /**
   * 旧措置入所者チェックを取得します。
   * @return 旧措置入所者チェック
   */
  public ACIntegerCheckBox getKaigoWelfareFacilityOldMeasuresPerson(){
    if(kaigoWelfareFacilityOldMeasuresPerson==null){

      kaigoWelfareFacilityOldMeasuresPerson = new ACIntegerCheckBox();

      kaigoWelfareFacilityOldMeasuresPerson.setText("旧措置入所者");

      kaigoWelfareFacilityOldMeasuresPerson.setBindPath("8");

      kaigoWelfareFacilityOldMeasuresPerson.setSelectValue(2);

      kaigoWelfareFacilityOldMeasuresPerson.setUnSelectValue(1);

      addKaigoWelfareFacilityOldMeasuresPerson();
    }
    return kaigoWelfareFacilityOldMeasuresPerson;

  }

  /**
   * 病室区分コンテナを取得します。
   * @return 病室区分コンテナ
   */
  public ACLabelContainer getKaigoWelfareFacilityHospitalRoomDivisionContena(){
    if(kaigoWelfareFacilityHospitalRoomDivisionContena==null){

      kaigoWelfareFacilityHospitalRoomDivisionContena = new ACLabelContainer();

      kaigoWelfareFacilityHospitalRoomDivisionContena.setText("病室区分");

      kaigoWelfareFacilityHospitalRoomDivisionContena.setFollowChildEnabled(true);

      addKaigoWelfareFacilityHospitalRoomDivisionContena();
    }
    return kaigoWelfareFacilityHospitalRoomDivisionContena;

  }

  /**
   * 病室区分（介護福祉施設）を取得します。
   * @return 病室区分（介護福祉施設）
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityHospitalRoomDivisionRadio(){
    if(kaigoWelfareFacilityHospitalRoomDivisionRadio==null){

      kaigoWelfareFacilityHospitalRoomDivisionRadio = new ACValueArrayRadioButtonGroup();

      kaigoWelfareFacilityHospitalRoomDivisionRadio.setBindPath("1510102");

      kaigoWelfareFacilityHospitalRoomDivisionRadio.setUseClearButton(false);

      kaigoWelfareFacilityHospitalRoomDivisionRadio.setModel(getKaigoWelfareFacilityHospitalRoomDivisionRadioModel());

      kaigoWelfareFacilityHospitalRoomDivisionRadio.setValues(new int[]{1,2});

      addKaigoWelfareFacilityHospitalRoomDivisionRadio();
    }
    return kaigoWelfareFacilityHospitalRoomDivisionRadio;

  }

  /**
   * 病室区分（介護福祉施設）モデルを取得します。
   * @return 病室区分（介護福祉施設）モデル
   */
  protected ACListModelAdapter getKaigoWelfareFacilityHospitalRoomDivisionRadioModel(){
    if(kaigoWelfareFacilityHospitalRoomDivisionRadioModel==null){
      kaigoWelfareFacilityHospitalRoomDivisionRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityHospitalRoomDivisionRadioModel();
    }
    return kaigoWelfareFacilityHospitalRoomDivisionRadioModel;
  }

  /**
   * 従来型個室を取得します。
   * @return 従来型個室
   */
  public ACRadioButtonItem getKaigoWelfareFacilityHospitalRoomDivisionRadioItem1(){
    if(kaigoWelfareFacilityHospitalRoomDivisionRadioItem1==null){

      kaigoWelfareFacilityHospitalRoomDivisionRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityHospitalRoomDivisionRadioItem1.setText("従来型個室");

      kaigoWelfareFacilityHospitalRoomDivisionRadioItem1.setGroup(getKaigoWelfareFacilityHospitalRoomDivisionRadio());

      kaigoWelfareFacilityHospitalRoomDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityHospitalRoomDivisionRadioItem1();
    }
    return kaigoWelfareFacilityHospitalRoomDivisionRadioItem1;

  }

  /**
   * 多床室を取得します。
   * @return 多床室
   */
  public ACRadioButtonItem getKaigoWelfareFacilityHospitalRoomDivisionRadioItem2(){
    if(kaigoWelfareFacilityHospitalRoomDivisionRadioItem2==null){

      kaigoWelfareFacilityHospitalRoomDivisionRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityHospitalRoomDivisionRadioItem2.setText("多床室");

      kaigoWelfareFacilityHospitalRoomDivisionRadioItem2.setGroup(getKaigoWelfareFacilityHospitalRoomDivisionRadio());

      kaigoWelfareFacilityHospitalRoomDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityHospitalRoomDivisionRadioItem2();
    }
    return kaigoWelfareFacilityHospitalRoomDivisionRadioItem2;

  }

  /**
   * 病室区分（ユニット型介護福祉施設）を取得します。
   * @return 病室区分（ユニット型介護福祉施設）
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityUnitHospitalRoomDivisionRadio(){
    if(kaigoWelfareFacilityUnitHospitalRoomDivisionRadio==null){

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadio = new ACValueArrayRadioButtonGroup();

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadio.setBindPath("1510103");

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadio.setUseClearButton(false);

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadio.setModel(getKaigoWelfareFacilityUnitHospitalRoomDivisionRadioModel());

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadio.setValues(new int[]{1,2});

      addKaigoWelfareFacilityUnitHospitalRoomDivisionRadio();
    }
    return kaigoWelfareFacilityUnitHospitalRoomDivisionRadio;

  }

  /**
   * 病室区分（ユニット型介護福祉施設）モデルを取得します。
   * @return 病室区分（ユニット型介護福祉施設）モデル
   */
  protected ACListModelAdapter getKaigoWelfareFacilityUnitHospitalRoomDivisionRadioModel(){
    if(kaigoWelfareFacilityUnitHospitalRoomDivisionRadioModel==null){
      kaigoWelfareFacilityUnitHospitalRoomDivisionRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityUnitHospitalRoomDivisionRadioModel();
    }
    return kaigoWelfareFacilityUnitHospitalRoomDivisionRadioModel;
  }

  /**
   * ユニット型個室を取得します。
   * @return ユニット型個室
   */
  public ACRadioButtonItem getKaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem1(){
    if(kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem1==null){

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem1.setText("ユニット型個室");

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem1.setGroup(getKaigoWelfareFacilityUnitHospitalRoomDivisionRadio());

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem1();
    }
    return kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem1;

  }

  /**
   * ユニット型準個室を取得します。
   * @return ユニット型準個室
   */
  public ACRadioButtonItem getKaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem2(){
    if(kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem2==null){

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem2.setText("ユニット型準個室");

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem2.setGroup(getKaigoWelfareFacilityUnitHospitalRoomDivisionRadio());

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem2();
    }
    return kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem2;

  }

  /**
   * ユニットケアの整備を取得します。
   * @return ユニットケアの整備
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityUnitCareMaintenanceRadio(){
    if(kaigoWelfareFacilityUnitCareMaintenanceRadio==null){

      kaigoWelfareFacilityUnitCareMaintenanceRadio = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityUnitCareMaintenanceRadioContainer().setText("ユニットケアの整備");

      kaigoWelfareFacilityUnitCareMaintenanceRadio.setBindPath("1510124");

      kaigoWelfareFacilityUnitCareMaintenanceRadio.setUseClearButton(false);

      kaigoWelfareFacilityUnitCareMaintenanceRadio.setModel(getKaigoWelfareFacilityUnitCareMaintenanceRadioModel());

      kaigoWelfareFacilityUnitCareMaintenanceRadio.setValues(new int[]{1,2});

      addKaigoWelfareFacilityUnitCareMaintenanceRadio();
    }
    return kaigoWelfareFacilityUnitCareMaintenanceRadio;

  }

  /**
   * ユニットケアの整備コンテナを取得します。
   * @return ユニットケアの整備コンテナ
   */
  protected ACLabelContainer getKaigoWelfareFacilityUnitCareMaintenanceRadioContainer(){
    if(kaigoWelfareFacilityUnitCareMaintenanceRadioContainer==null){
      kaigoWelfareFacilityUnitCareMaintenanceRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityUnitCareMaintenanceRadioContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityUnitCareMaintenanceRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityUnitCareMaintenanceRadioContainer.add(getKaigoWelfareFacilityUnitCareMaintenanceRadio(), null);
    }
    return kaigoWelfareFacilityUnitCareMaintenanceRadioContainer;
  }

  /**
   * ユニットケアの整備モデルを取得します。
   * @return ユニットケアの整備モデル
   */
  protected ACListModelAdapter getKaigoWelfareFacilityUnitCareMaintenanceRadioModel(){
    if(kaigoWelfareFacilityUnitCareMaintenanceRadioModel==null){
      kaigoWelfareFacilityUnitCareMaintenanceRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityUnitCareMaintenanceRadioModel();
    }
    return kaigoWelfareFacilityUnitCareMaintenanceRadioModel;
  }

  /**
   * 未整備を取得します。
   * @return 未整備
   */
  public ACRadioButtonItem getKaigoWelfareFacilityUnitCareMaintenanceRadioItem1(){
    if(kaigoWelfareFacilityUnitCareMaintenanceRadioItem1==null){

      kaigoWelfareFacilityUnitCareMaintenanceRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityUnitCareMaintenanceRadioItem1.setText("未整備");

      kaigoWelfareFacilityUnitCareMaintenanceRadioItem1.setGroup(getKaigoWelfareFacilityUnitCareMaintenanceRadio());

      kaigoWelfareFacilityUnitCareMaintenanceRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityUnitCareMaintenanceRadioItem1();
    }
    return kaigoWelfareFacilityUnitCareMaintenanceRadioItem1;

  }

  /**
   * 整備を取得します。
   * @return 整備
   */
  public ACRadioButtonItem getKaigoWelfareFacilityUnitCareMaintenanceRadioItem2(){
    if(kaigoWelfareFacilityUnitCareMaintenanceRadioItem2==null){

      kaigoWelfareFacilityUnitCareMaintenanceRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityUnitCareMaintenanceRadioItem2.setText("整備");

      kaigoWelfareFacilityUnitCareMaintenanceRadioItem2.setGroup(getKaigoWelfareFacilityUnitCareMaintenanceRadio());

      kaigoWelfareFacilityUnitCareMaintenanceRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityUnitCareMaintenanceRadioItem2();
    }
    return kaigoWelfareFacilityUnitCareMaintenanceRadioItem2;

  }

  /**
   * 準ユニットケア加算を取得します。
   * @return 準ユニットケア加算
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityJunUnitCareAddRadio(){
    if(kaigoWelfareFacilityJunUnitCareAddRadio==null){

      kaigoWelfareFacilityJunUnitCareAddRadio = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityJunUnitCareAddRadioContainer().setText("準ユニットケア加算");

      kaigoWelfareFacilityJunUnitCareAddRadio.setBindPath("1510125");

      kaigoWelfareFacilityJunUnitCareAddRadio.setUseClearButton(false);

      kaigoWelfareFacilityJunUnitCareAddRadio.setModel(getKaigoWelfareFacilityJunUnitCareAddRadioModel());

      kaigoWelfareFacilityJunUnitCareAddRadio.setValues(new int[]{1,2});

      addKaigoWelfareFacilityJunUnitCareAddRadio();
    }
    return kaigoWelfareFacilityJunUnitCareAddRadio;

  }

  /**
   * 準ユニットケア加算コンテナを取得します。
   * @return 準ユニットケア加算コンテナ
   */
  protected ACLabelContainer getKaigoWelfareFacilityJunUnitCareAddRadioContainer(){
    if(kaigoWelfareFacilityJunUnitCareAddRadioContainer==null){
      kaigoWelfareFacilityJunUnitCareAddRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityJunUnitCareAddRadioContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityJunUnitCareAddRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityJunUnitCareAddRadioContainer.add(getKaigoWelfareFacilityJunUnitCareAddRadio(), null);
    }
    return kaigoWelfareFacilityJunUnitCareAddRadioContainer;
  }

  /**
   * 準ユニットケア加算モデルを取得します。
   * @return 準ユニットケア加算モデル
   */
  protected ACListModelAdapter getKaigoWelfareFacilityJunUnitCareAddRadioModel(){
    if(kaigoWelfareFacilityJunUnitCareAddRadioModel==null){
      kaigoWelfareFacilityJunUnitCareAddRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityJunUnitCareAddRadioModel();
    }
    return kaigoWelfareFacilityJunUnitCareAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKaigoWelfareFacilityJunUnitCareAddRadioItem1(){
    if(kaigoWelfareFacilityJunUnitCareAddRadioItem1==null){

      kaigoWelfareFacilityJunUnitCareAddRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityJunUnitCareAddRadioItem1.setText("なし");

      kaigoWelfareFacilityJunUnitCareAddRadioItem1.setGroup(getKaigoWelfareFacilityJunUnitCareAddRadio());

      kaigoWelfareFacilityJunUnitCareAddRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityJunUnitCareAddRadioItem1();
    }
    return kaigoWelfareFacilityJunUnitCareAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getKaigoWelfareFacilityJunUnitCareAddRadioItem2(){
    if(kaigoWelfareFacilityJunUnitCareAddRadioItem2==null){

      kaigoWelfareFacilityJunUnitCareAddRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityJunUnitCareAddRadioItem2.setText("あり");

      kaigoWelfareFacilityJunUnitCareAddRadioItem2.setGroup(getKaigoWelfareFacilityJunUnitCareAddRadio());

      kaigoWelfareFacilityJunUnitCareAddRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityJunUnitCareAddRadioItem2();
    }
    return kaigoWelfareFacilityJunUnitCareAddRadioItem2;

  }

  /**
   * 夜勤体制減算を取得します。
   * @return 夜勤体制減算
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityNightShiftSubtractionRadio(){
    if(kaigoWelfareFacilityNightShiftSubtractionRadio==null){

      kaigoWelfareFacilityNightShiftSubtractionRadio = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityNightShiftSubtractionRadioContainer().setText("夜間勤務条件基準");

      kaigoWelfareFacilityNightShiftSubtractionRadio.setBindPath("1510106");

      kaigoWelfareFacilityNightShiftSubtractionRadio.setUseClearButton(false);

      kaigoWelfareFacilityNightShiftSubtractionRadio.setModel(getKaigoWelfareFacilityNightShiftSubtractionRadioModel());

      kaigoWelfareFacilityNightShiftSubtractionRadio.setValues(new int[]{1,2});

      addKaigoWelfareFacilityNightShiftSubtractionRadio();
    }
    return kaigoWelfareFacilityNightShiftSubtractionRadio;

  }

  /**
   * 夜勤体制減算コンテナを取得します。
   * @return 夜勤体制減算コンテナ
   */
  protected ACLabelContainer getKaigoWelfareFacilityNightShiftSubtractionRadioContainer(){
    if(kaigoWelfareFacilityNightShiftSubtractionRadioContainer==null){
      kaigoWelfareFacilityNightShiftSubtractionRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityNightShiftSubtractionRadioContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityNightShiftSubtractionRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityNightShiftSubtractionRadioContainer.add(getKaigoWelfareFacilityNightShiftSubtractionRadio(), null);
    }
    return kaigoWelfareFacilityNightShiftSubtractionRadioContainer;
  }

  /**
   * 夜勤体制減算モデルを取得します。
   * @return 夜勤体制減算モデル
   */
  protected ACListModelAdapter getKaigoWelfareFacilityNightShiftSubtractionRadioModel(){
    if(kaigoWelfareFacilityNightShiftSubtractionRadioModel==null){
      kaigoWelfareFacilityNightShiftSubtractionRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityNightShiftSubtractionRadioModel();
    }
    return kaigoWelfareFacilityNightShiftSubtractionRadioModel;
  }

  /**
   * 基準型を取得します。
   * @return 基準型
   */
  public ACRadioButtonItem getKaigoWelfareFacilityNightShiftSubtractionRadioItem1(){
    if(kaigoWelfareFacilityNightShiftSubtractionRadioItem1==null){

      kaigoWelfareFacilityNightShiftSubtractionRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityNightShiftSubtractionRadioItem1.setText("基準型");

      kaigoWelfareFacilityNightShiftSubtractionRadioItem1.setGroup(getKaigoWelfareFacilityNightShiftSubtractionRadio());

      kaigoWelfareFacilityNightShiftSubtractionRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityNightShiftSubtractionRadioItem1();
    }
    return kaigoWelfareFacilityNightShiftSubtractionRadioItem1;

  }

  /**
   * 減算型を取得します。
   * @return 減算型
   */
  public ACRadioButtonItem getKaigoWelfareFacilityNightShiftSubtractionRadioItem2(){
    if(kaigoWelfareFacilityNightShiftSubtractionRadioItem2==null){

      kaigoWelfareFacilityNightShiftSubtractionRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityNightShiftSubtractionRadioItem2.setText("減算型");

      kaigoWelfareFacilityNightShiftSubtractionRadioItem2.setGroup(getKaigoWelfareFacilityNightShiftSubtractionRadio());

      kaigoWelfareFacilityNightShiftSubtractionRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityNightShiftSubtractionRadioItem2();
    }
    return kaigoWelfareFacilityNightShiftSubtractionRadioItem2;

  }

  /**
   * 日常生活継続支援加算を取得します。
   * @return 日常生活継続支援加算
   */
  public ACValueArrayRadioButtonGroup getDailyLifeContinuanceRadioGroup(){
    if(dailyLifeContinuanceRadioGroup==null){

      dailyLifeContinuanceRadioGroup = new ACValueArrayRadioButtonGroup();

      getDailyLifeContinuanceRadioGroupContainer().setText("日常生活継続支援加算");

      dailyLifeContinuanceRadioGroup.setBindPath("1510133");

      dailyLifeContinuanceRadioGroup.setNoSelectIndex(0);

      dailyLifeContinuanceRadioGroup.setUseClearButton(false);

      dailyLifeContinuanceRadioGroup.setModel(getDailyLifeContinuanceRadioGroupModel());

      dailyLifeContinuanceRadioGroup.setValues(new int[]{1,2});

      addDailyLifeContinuanceRadioGroup();
    }
    return dailyLifeContinuanceRadioGroup;

  }

  /**
   * 日常生活継続支援加算コンテナを取得します。
   * @return 日常生活継続支援加算コンテナ
   */
  protected ACLabelContainer getDailyLifeContinuanceRadioGroupContainer(){
    if(dailyLifeContinuanceRadioGroupContainer==null){
      dailyLifeContinuanceRadioGroupContainer = new ACLabelContainer();
      dailyLifeContinuanceRadioGroupContainer.setFollowChildEnabled(true);
      dailyLifeContinuanceRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      dailyLifeContinuanceRadioGroupContainer.add(getDailyLifeContinuanceRadioGroup(), null);
    }
    return dailyLifeContinuanceRadioGroupContainer;
  }

  /**
   * 日常生活継続支援加算モデルを取得します。
   * @return 日常生活継続支援加算モデル
   */
  protected ACListModelAdapter getDailyLifeContinuanceRadioGroupModel(){
    if(dailyLifeContinuanceRadioGroupModel==null){
      dailyLifeContinuanceRadioGroupModel = new ACListModelAdapter();
      addDailyLifeContinuanceRadioGroupModel();
    }
    return dailyLifeContinuanceRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getDailyLifeContinuanceRadioItem1(){
    if(dailyLifeContinuanceRadioItem1==null){

      dailyLifeContinuanceRadioItem1 = new ACRadioButtonItem();

      dailyLifeContinuanceRadioItem1.setText("なし");

      dailyLifeContinuanceRadioItem1.setGroup(getDailyLifeContinuanceRadioGroup());

      dailyLifeContinuanceRadioItem1.setConstraints(VRLayout.FLOW);

      addDailyLifeContinuanceRadioItem1();
    }
    return dailyLifeContinuanceRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getDailyLifeContinuanceRadioItem2(){
    if(dailyLifeContinuanceRadioItem2==null){

      dailyLifeContinuanceRadioItem2 = new ACRadioButtonItem();

      dailyLifeContinuanceRadioItem2.setText("あり");

      dailyLifeContinuanceRadioItem2.setGroup(getDailyLifeContinuanceRadioGroup());

      dailyLifeContinuanceRadioItem2.setConstraints(VRLayout.FLOW);

      addDailyLifeContinuanceRadioItem2();
    }
    return dailyLifeContinuanceRadioItem2;

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
   * 個別機能訓練指導加算を取得します。
   * @return 個別機能訓練指導加算
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityFunctionTrainingRadio(){
    if(kaigoWelfareFacilityFunctionTrainingRadio==null){

      kaigoWelfareFacilityFunctionTrainingRadio = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityFunctionTrainingRadioContainer().setText("個別機能訓練指導加算");

      kaigoWelfareFacilityFunctionTrainingRadio.setBindPath("1510107");

      kaigoWelfareFacilityFunctionTrainingRadio.setUseClearButton(false);

      kaigoWelfareFacilityFunctionTrainingRadio.setModel(getKaigoWelfareFacilityFunctionTrainingRadioModel());

      kaigoWelfareFacilityFunctionTrainingRadio.setValues(new int[]{1,2});

      addKaigoWelfareFacilityFunctionTrainingRadio();
    }
    return kaigoWelfareFacilityFunctionTrainingRadio;

  }

  /**
   * 個別機能訓練指導加算コンテナを取得します。
   * @return 個別機能訓練指導加算コンテナ
   */
  protected ACLabelContainer getKaigoWelfareFacilityFunctionTrainingRadioContainer(){
    if(kaigoWelfareFacilityFunctionTrainingRadioContainer==null){
      kaigoWelfareFacilityFunctionTrainingRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityFunctionTrainingRadioContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityFunctionTrainingRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityFunctionTrainingRadioContainer.add(getKaigoWelfareFacilityFunctionTrainingRadio(), null);
    }
    return kaigoWelfareFacilityFunctionTrainingRadioContainer;
  }

  /**
   * 個別機能訓練指導加算モデルを取得します。
   * @return 個別機能訓練指導加算モデル
   */
  protected ACListModelAdapter getKaigoWelfareFacilityFunctionTrainingRadioModel(){
    if(kaigoWelfareFacilityFunctionTrainingRadioModel==null){
      kaigoWelfareFacilityFunctionTrainingRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityFunctionTrainingRadioModel();
    }
    return kaigoWelfareFacilityFunctionTrainingRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKaigoWelfareFacilityFunctionTrainingRadioItem2(){
    if(kaigoWelfareFacilityFunctionTrainingRadioItem2==null){

      kaigoWelfareFacilityFunctionTrainingRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityFunctionTrainingRadioItem2.setText("なし");

      kaigoWelfareFacilityFunctionTrainingRadioItem2.setGroup(getKaigoWelfareFacilityFunctionTrainingRadio());

      kaigoWelfareFacilityFunctionTrainingRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityFunctionTrainingRadioItem2();
    }
    return kaigoWelfareFacilityFunctionTrainingRadioItem2;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getKaigoWelfareFacilityFunctionTrainingRadioItem1(){
    if(kaigoWelfareFacilityFunctionTrainingRadioItem1==null){

      kaigoWelfareFacilityFunctionTrainingRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityFunctionTrainingRadioItem1.setText("あり");

      kaigoWelfareFacilityFunctionTrainingRadioItem1.setGroup(getKaigoWelfareFacilityFunctionTrainingRadio());

      kaigoWelfareFacilityFunctionTrainingRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityFunctionTrainingRadioItem1();
    }
    return kaigoWelfareFacilityFunctionTrainingRadioItem1;

  }

  /**
   * 障害者生活支援体制加算を取得します。
   * @return 障害者生活支援体制加算
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityHandicappedRadio(){
    if(kaigoWelfareFacilityHandicappedRadio==null){

      kaigoWelfareFacilityHandicappedRadio = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityHandicappedRadioContainer().setText("障害者生活支援体制加算");

      kaigoWelfareFacilityHandicappedRadio.setBindPath("1510110");

      kaigoWelfareFacilityHandicappedRadio.setUseClearButton(false);

      kaigoWelfareFacilityHandicappedRadio.setModel(getKaigoWelfareFacilityHandicappedRadioModel());

      kaigoWelfareFacilityHandicappedRadio.setValues(new int[]{1,2});

      addKaigoWelfareFacilityHandicappedRadio();
    }
    return kaigoWelfareFacilityHandicappedRadio;

  }

  /**
   * 障害者生活支援体制加算コンテナを取得します。
   * @return 障害者生活支援体制加算コンテナ
   */
  protected ACLabelContainer getKaigoWelfareFacilityHandicappedRadioContainer(){
    if(kaigoWelfareFacilityHandicappedRadioContainer==null){
      kaigoWelfareFacilityHandicappedRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityHandicappedRadioContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityHandicappedRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityHandicappedRadioContainer.add(getKaigoWelfareFacilityHandicappedRadio(), null);
    }
    return kaigoWelfareFacilityHandicappedRadioContainer;
  }

  /**
   * 障害者生活支援体制加算モデルを取得します。
   * @return 障害者生活支援体制加算モデル
   */
  protected ACListModelAdapter getKaigoWelfareFacilityHandicappedRadioModel(){
    if(kaigoWelfareFacilityHandicappedRadioModel==null){
      kaigoWelfareFacilityHandicappedRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityHandicappedRadioModel();
    }
    return kaigoWelfareFacilityHandicappedRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKaigoWelfareFacilityHandicappedRadioItem1(){
    if(kaigoWelfareFacilityHandicappedRadioItem1==null){

      kaigoWelfareFacilityHandicappedRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityHandicappedRadioItem1.setText("なし");

      kaigoWelfareFacilityHandicappedRadioItem1.setGroup(getKaigoWelfareFacilityHandicappedRadio());

      kaigoWelfareFacilityHandicappedRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityHandicappedRadioItem1();
    }
    return kaigoWelfareFacilityHandicappedRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getKaigoWelfareFacilityHandicappedRadioItem2(){
    if(kaigoWelfareFacilityHandicappedRadioItem2==null){

      kaigoWelfareFacilityHandicappedRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityHandicappedRadioItem2.setText("あり");

      kaigoWelfareFacilityHandicappedRadioItem2.setGroup(getKaigoWelfareFacilityHandicappedRadio());

      kaigoWelfareFacilityHandicappedRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityHandicappedRadioItem2();
    }
    return kaigoWelfareFacilityHandicappedRadioItem2;

  }

  /**
   * 看護体制加算コンテナを取得します。
   * @return 看護体制加算コンテナ
   */
  public ACLabelContainer getNurseStructuralAddGroup(){
    if(nurseStructuralAddGroup==null){

      nurseStructuralAddGroup = new ACLabelContainer();

      nurseStructuralAddGroup.setText("看護体制加算");

      nurseStructuralAddGroup.setFollowChildEnabled(true);

      nurseStructuralAddGroup.setHgap(0);

      nurseStructuralAddGroup.setLabelMargin(0);

      nurseStructuralAddGroup.setVgap(0);

      addNurseStructuralAddGroup();
    }
    return nurseStructuralAddGroup;

  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACIntegerCheckBox getNurseStructuralAddCheckItem1(){
    if(nurseStructuralAddCheckItem1==null){

      nurseStructuralAddCheckItem1 = new ACIntegerCheckBox();

      nurseStructuralAddCheckItem1.setText("I型");

      nurseStructuralAddCheckItem1.setBindPath("1510142");

      nurseStructuralAddCheckItem1.setSelectValue(2);

      nurseStructuralAddCheckItem1.setUnSelectValue(1);

      addNurseStructuralAddCheckItem1();
    }
    return nurseStructuralAddCheckItem1;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACIntegerCheckBox getNurseStructuralAddCheckItem2(){
    if(nurseStructuralAddCheckItem2==null){

      nurseStructuralAddCheckItem2 = new ACIntegerCheckBox();

      nurseStructuralAddCheckItem2.setText("II型");

      nurseStructuralAddCheckItem2.setBindPath("1510143");

      nurseStructuralAddCheckItem2.setSelectValue(2);

      nurseStructuralAddCheckItem2.setUnSelectValue(1);

      addNurseStructuralAddCheckItem2();
    }
    return nurseStructuralAddCheckItem2;

  }

  /**
   * 夜勤職員配置加算を取得します。
   * @return 夜勤職員配置加算
   */
  public ACValueArrayRadioButtonGroup getNightStaffDispositionAddRadioGroup(){
    if(nightStaffDispositionAddRadioGroup==null){

      nightStaffDispositionAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getNightStaffDispositionAddRadioGroupContainer().setText("夜勤職員配置加算");

      nightStaffDispositionAddRadioGroup.setBindPath("1510135");

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
   * 入所定員を取得します。
   * @return 入所定員
   */
  public ACValueArrayRadioButtonGroup getStayPeopleCountRadioGroup(){
    if(stayPeopleCountRadioGroup==null){

      stayPeopleCountRadioGroup = new ACValueArrayRadioButtonGroup();

      getStayPeopleCountRadioGroupContainer().setText("入所定員");

      stayPeopleCountRadioGroup.setBindPath("1510136");

      stayPeopleCountRadioGroup.setNoSelectIndex(0);

      stayPeopleCountRadioGroup.setUseClearButton(false);

      stayPeopleCountRadioGroup.setModel(getStayPeopleCountRadioGroupModel());

      stayPeopleCountRadioGroup.setValues(new int[]{1,2});

      addStayPeopleCountRadioGroup();
    }
    return stayPeopleCountRadioGroup;

  }

  /**
   * 入所定員コンテナを取得します。
   * @return 入所定員コンテナ
   */
  protected ACLabelContainer getStayPeopleCountRadioGroupContainer(){
    if(stayPeopleCountRadioGroupContainer==null){
      stayPeopleCountRadioGroupContainer = new ACLabelContainer();
      stayPeopleCountRadioGroupContainer.setFollowChildEnabled(true);
      stayPeopleCountRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      stayPeopleCountRadioGroupContainer.add(getStayPeopleCountRadioGroup(), null);
    }
    return stayPeopleCountRadioGroupContainer;
  }

  /**
   * 入所定員モデルを取得します。
   * @return 入所定員モデル
   */
  protected ACListModelAdapter getStayPeopleCountRadioGroupModel(){
    if(stayPeopleCountRadioGroupModel==null){
      stayPeopleCountRadioGroupModel = new ACListModelAdapter();
      addStayPeopleCountRadioGroupModel();
    }
    return stayPeopleCountRadioGroupModel;
  }

  /**
   * 31人以上50人以下を取得します。
   * @return 31人以上50人以下
   */
  public ACRadioButtonItem getStayPeopleCountRadioItem1(){
    if(stayPeopleCountRadioItem1==null){

      stayPeopleCountRadioItem1 = new ACRadioButtonItem();

      stayPeopleCountRadioItem1.setText("31人以上50人以下");

      stayPeopleCountRadioItem1.setGroup(getStayPeopleCountRadioGroup());

      stayPeopleCountRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addStayPeopleCountRadioItem1();
    }
    return stayPeopleCountRadioItem1;

  }

  /**
   * 30人又は51人以上を取得します。
   * @return 30人又は51人以上
   */
  public ACRadioButtonItem getStayPeopleCountRadioItem2(){
    if(stayPeopleCountRadioItem2==null){

      stayPeopleCountRadioItem2 = new ACRadioButtonItem();

      stayPeopleCountRadioItem2.setText("30人又は51人以上");

      stayPeopleCountRadioItem2.setGroup(getStayPeopleCountRadioGroup());

      stayPeopleCountRadioItem2.setConstraints(VRLayout.FLOW);

      addStayPeopleCountRadioItem2();
    }
    return stayPeopleCountRadioItem2;

  }

  /**
   * 常勤医師配置加算を取得します。
   * @return 常勤医師配置加算
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityFacilityFulltimeDoctorRadio(){
    if(kaigoWelfareFacilityFacilityFulltimeDoctorRadio==null){

      kaigoWelfareFacilityFacilityFulltimeDoctorRadio = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityFacilityFulltimeDoctorRadioContainer().setText("常勤医師配置加算");

      kaigoWelfareFacilityFacilityFulltimeDoctorRadio.setBindPath("1510108");

      kaigoWelfareFacilityFacilityFulltimeDoctorRadio.setUseClearButton(false);

      kaigoWelfareFacilityFacilityFulltimeDoctorRadio.setModel(getKaigoWelfareFacilityFacilityFulltimeDoctorRadioModel());

      kaigoWelfareFacilityFacilityFulltimeDoctorRadio.setValues(new int[]{1,2});

      addKaigoWelfareFacilityFacilityFulltimeDoctorRadio();
    }
    return kaigoWelfareFacilityFacilityFulltimeDoctorRadio;

  }

  /**
   * 常勤医師配置加算コンテナを取得します。
   * @return 常勤医師配置加算コンテナ
   */
  protected ACLabelContainer getKaigoWelfareFacilityFacilityFulltimeDoctorRadioContainer(){
    if(kaigoWelfareFacilityFacilityFulltimeDoctorRadioContainer==null){
      kaigoWelfareFacilityFacilityFulltimeDoctorRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityFacilityFulltimeDoctorRadioContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityFacilityFulltimeDoctorRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityFacilityFulltimeDoctorRadioContainer.add(getKaigoWelfareFacilityFacilityFulltimeDoctorRadio(), null);
    }
    return kaigoWelfareFacilityFacilityFulltimeDoctorRadioContainer;
  }

  /**
   * 常勤医師配置加算モデルを取得します。
   * @return 常勤医師配置加算モデル
   */
  protected ACListModelAdapter getKaigoWelfareFacilityFacilityFulltimeDoctorRadioModel(){
    if(kaigoWelfareFacilityFacilityFulltimeDoctorRadioModel==null){
      kaigoWelfareFacilityFacilityFulltimeDoctorRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityFacilityFulltimeDoctorRadioModel();
    }
    return kaigoWelfareFacilityFacilityFulltimeDoctorRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKaigoWelfareFacilityFacilityFulltimeDoctorRadioItem1(){
    if(kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem1==null){

      kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem1.setText("なし");

      kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem1.setGroup(getKaigoWelfareFacilityFacilityFulltimeDoctorRadio());

      kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityFacilityFulltimeDoctorRadioItem1();
    }
    return kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getKaigoWelfareFacilityFacilityFulltimeDoctorRadioItem2(){
    if(kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem2==null){

      kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem2.setText("あり");

      kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem2.setGroup(getKaigoWelfareFacilityFacilityFulltimeDoctorRadio());

      kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityFacilityFulltimeDoctorRadioItem2();
    }
    return kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem2;

  }

  /**
   * 精神科医療養指導加算を取得します。
   * @return 精神科医療養指導加算
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityPsychiatristRadio(){
    if(kaigoWelfareFacilityPsychiatristRadio==null){

      kaigoWelfareFacilityPsychiatristRadio = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityPsychiatristRadioContainer().setText("精神科医療養指導加算");

      kaigoWelfareFacilityPsychiatristRadio.setBindPath("1510109");

      kaigoWelfareFacilityPsychiatristRadio.setUseClearButton(false);

      kaigoWelfareFacilityPsychiatristRadio.setModel(getKaigoWelfareFacilityPsychiatristRadioModel());

      kaigoWelfareFacilityPsychiatristRadio.setValues(new int[]{1,2});

      addKaigoWelfareFacilityPsychiatristRadio();
    }
    return kaigoWelfareFacilityPsychiatristRadio;

  }

  /**
   * 精神科医療養指導加算コンテナを取得します。
   * @return 精神科医療養指導加算コンテナ
   */
  protected ACLabelContainer getKaigoWelfareFacilityPsychiatristRadioContainer(){
    if(kaigoWelfareFacilityPsychiatristRadioContainer==null){
      kaigoWelfareFacilityPsychiatristRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityPsychiatristRadioContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityPsychiatristRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityPsychiatristRadioContainer.add(getKaigoWelfareFacilityPsychiatristRadio(), null);
    }
    return kaigoWelfareFacilityPsychiatristRadioContainer;
  }

  /**
   * 精神科医療養指導加算モデルを取得します。
   * @return 精神科医療養指導加算モデル
   */
  protected ACListModelAdapter getKaigoWelfareFacilityPsychiatristRadioModel(){
    if(kaigoWelfareFacilityPsychiatristRadioModel==null){
      kaigoWelfareFacilityPsychiatristRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityPsychiatristRadioModel();
    }
    return kaigoWelfareFacilityPsychiatristRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKaigoWelfareFacilityPsychiatristRadioItem1(){
    if(kaigoWelfareFacilityPsychiatristRadioItem1==null){

      kaigoWelfareFacilityPsychiatristRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityPsychiatristRadioItem1.setText("なし");

      kaigoWelfareFacilityPsychiatristRadioItem1.setGroup(getKaigoWelfareFacilityPsychiatristRadio());

      kaigoWelfareFacilityPsychiatristRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityPsychiatristRadioItem1();
    }
    return kaigoWelfareFacilityPsychiatristRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getKaigoWelfareFacilityPsychiatristRadioItem2(){
    if(kaigoWelfareFacilityPsychiatristRadioItem2==null){

      kaigoWelfareFacilityPsychiatristRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityPsychiatristRadioItem2.setText("あり");

      kaigoWelfareFacilityPsychiatristRadioItem2.setGroup(getKaigoWelfareFacilityPsychiatristRadio());

      kaigoWelfareFacilityPsychiatristRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityPsychiatristRadioItem2();
    }
    return kaigoWelfareFacilityPsychiatristRadioItem2;

  }

  /**
   * 外泊加算を取得します。
   * @return 外泊加算
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityStayingOutOvernightCostRadio(){
    if(kaigoWelfareFacilityStayingOutOvernightCostRadio==null){

      kaigoWelfareFacilityStayingOutOvernightCostRadio = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityStayingOutOvernightCostRadioContainer().setText("外泊加算");

      kaigoWelfareFacilityStayingOutOvernightCostRadio.setBindPath("1510111");

      kaigoWelfareFacilityStayingOutOvernightCostRadio.setUseClearButton(false);

      kaigoWelfareFacilityStayingOutOvernightCostRadio.setModel(getKaigoWelfareFacilityStayingOutOvernightCostRadioModel());

      kaigoWelfareFacilityStayingOutOvernightCostRadio.setValues(new int[]{1,2});

      addKaigoWelfareFacilityStayingOutOvernightCostRadio();
    }
    return kaigoWelfareFacilityStayingOutOvernightCostRadio;

  }

  /**
   * 外泊加算コンテナを取得します。
   * @return 外泊加算コンテナ
   */
  protected ACLabelContainer getKaigoWelfareFacilityStayingOutOvernightCostRadioContainer(){
    if(kaigoWelfareFacilityStayingOutOvernightCostRadioContainer==null){
      kaigoWelfareFacilityStayingOutOvernightCostRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityStayingOutOvernightCostRadioContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityStayingOutOvernightCostRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityStayingOutOvernightCostRadioContainer.add(getKaigoWelfareFacilityStayingOutOvernightCostRadio(), null);
    }
    return kaigoWelfareFacilityStayingOutOvernightCostRadioContainer;
  }

  /**
   * 外泊加算モデルを取得します。
   * @return 外泊加算モデル
   */
  protected ACListModelAdapter getKaigoWelfareFacilityStayingOutOvernightCostRadioModel(){
    if(kaigoWelfareFacilityStayingOutOvernightCostRadioModel==null){
      kaigoWelfareFacilityStayingOutOvernightCostRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityStayingOutOvernightCostRadioModel();
    }
    return kaigoWelfareFacilityStayingOutOvernightCostRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKaigoWelfareFacilityStayingOutOvernightCostRadioItem1(){
    if(kaigoWelfareFacilityStayingOutOvernightCostRadioItem1==null){

      kaigoWelfareFacilityStayingOutOvernightCostRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityStayingOutOvernightCostRadioItem1.setText("なし");

      kaigoWelfareFacilityStayingOutOvernightCostRadioItem1.setGroup(getKaigoWelfareFacilityStayingOutOvernightCostRadio());

      kaigoWelfareFacilityStayingOutOvernightCostRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityStayingOutOvernightCostRadioItem1();
    }
    return kaigoWelfareFacilityStayingOutOvernightCostRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getKaigoWelfareFacilityStayingOutOvernightCostRadioItem2(){
    if(kaigoWelfareFacilityStayingOutOvernightCostRadioItem2==null){

      kaigoWelfareFacilityStayingOutOvernightCostRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityStayingOutOvernightCostRadioItem2.setText("あり");

      kaigoWelfareFacilityStayingOutOvernightCostRadioItem2.setGroup(getKaigoWelfareFacilityStayingOutOvernightCostRadio());

      kaigoWelfareFacilityStayingOutOvernightCostRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityStayingOutOvernightCostRadioItem2();
    }
    return kaigoWelfareFacilityStayingOutOvernightCostRadioItem2;

  }

  /**
   * 初期加算を取得します。
   * @return 初期加算
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityDefaultRadio(){
    if(kaigoWelfareFacilityDefaultRadio==null){

      kaigoWelfareFacilityDefaultRadio = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityDefaultRadioContainer().setText("初期加算");

      kaigoWelfareFacilityDefaultRadio.setBindPath("1510112");

      kaigoWelfareFacilityDefaultRadio.setUseClearButton(false);

      kaigoWelfareFacilityDefaultRadio.setModel(getKaigoWelfareFacilityDefaultRadioModel());

      kaigoWelfareFacilityDefaultRadio.setValues(new int[]{1,2});

      addKaigoWelfareFacilityDefaultRadio();
    }
    return kaigoWelfareFacilityDefaultRadio;

  }

  /**
   * 初期加算コンテナを取得します。
   * @return 初期加算コンテナ
   */
  protected ACLabelContainer getKaigoWelfareFacilityDefaultRadioContainer(){
    if(kaigoWelfareFacilityDefaultRadioContainer==null){
      kaigoWelfareFacilityDefaultRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityDefaultRadioContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityDefaultRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityDefaultRadioContainer.add(getKaigoWelfareFacilityDefaultRadio(), null);
    }
    return kaigoWelfareFacilityDefaultRadioContainer;
  }

  /**
   * 初期加算モデルを取得します。
   * @return 初期加算モデル
   */
  protected ACListModelAdapter getKaigoWelfareFacilityDefaultRadioModel(){
    if(kaigoWelfareFacilityDefaultRadioModel==null){
      kaigoWelfareFacilityDefaultRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityDefaultRadioModel();
    }
    return kaigoWelfareFacilityDefaultRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKaigoWelfareFacilityDefaultRadioItem1(){
    if(kaigoWelfareFacilityDefaultRadioItem1==null){

      kaigoWelfareFacilityDefaultRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityDefaultRadioItem1.setText("なし");

      kaigoWelfareFacilityDefaultRadioItem1.setGroup(getKaigoWelfareFacilityDefaultRadio());

      kaigoWelfareFacilityDefaultRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityDefaultRadioItem1();
    }
    return kaigoWelfareFacilityDefaultRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getKaigoWelfareFacilityDefaultRadioItem2(){
    if(kaigoWelfareFacilityDefaultRadioItem2==null){

      kaigoWelfareFacilityDefaultRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityDefaultRadioItem2.setText("あり");

      kaigoWelfareFacilityDefaultRadioItem2.setGroup(getKaigoWelfareFacilityDefaultRadio());

      kaigoWelfareFacilityDefaultRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityDefaultRadioItem2();
    }
    return kaigoWelfareFacilityDefaultRadioItem2;

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
   * 栄養マネジメント加算を取得します。
   * @return 栄養マネジメント加算
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityNutritionRadio(){
    if(kaigoWelfareFacilityNutritionRadio==null){

      kaigoWelfareFacilityNutritionRadio = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityNutritionRadioContainer().setText("栄養マネジメント加算");

      kaigoWelfareFacilityNutritionRadio.setBindPath("1510114");

      kaigoWelfareFacilityNutritionRadio.setUseClearButton(false);

      kaigoWelfareFacilityNutritionRadio.setModel(getKaigoWelfareFacilityNutritionRadioModel());

      kaigoWelfareFacilityNutritionRadio.setValues(new int[]{1,2});

      addKaigoWelfareFacilityNutritionRadio();
    }
    return kaigoWelfareFacilityNutritionRadio;

  }

  /**
   * 栄養マネジメント加算コンテナを取得します。
   * @return 栄養マネジメント加算コンテナ
   */
  protected ACLabelContainer getKaigoWelfareFacilityNutritionRadioContainer(){
    if(kaigoWelfareFacilityNutritionRadioContainer==null){
      kaigoWelfareFacilityNutritionRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityNutritionRadioContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityNutritionRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityNutritionRadioContainer.add(getKaigoWelfareFacilityNutritionRadio(), null);
    }
    return kaigoWelfareFacilityNutritionRadioContainer;
  }

  /**
   * 栄養マネジメント加算モデルを取得します。
   * @return 栄養マネジメント加算モデル
   */
  protected ACListModelAdapter getKaigoWelfareFacilityNutritionRadioModel(){
    if(kaigoWelfareFacilityNutritionRadioModel==null){
      kaigoWelfareFacilityNutritionRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityNutritionRadioModel();
    }
    return kaigoWelfareFacilityNutritionRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKaigoWelfareFacilityNutritionRadioItem1(){
    if(kaigoWelfareFacilityNutritionRadioItem1==null){

      kaigoWelfareFacilityNutritionRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityNutritionRadioItem1.setText("なし");

      kaigoWelfareFacilityNutritionRadioItem1.setGroup(getKaigoWelfareFacilityNutritionRadio());

      kaigoWelfareFacilityNutritionRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityNutritionRadioItem1();
    }
    return kaigoWelfareFacilityNutritionRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getKaigoWelfareFacilityNutritionRadioItem2(){
    if(kaigoWelfareFacilityNutritionRadioItem2==null){

      kaigoWelfareFacilityNutritionRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityNutritionRadioItem2.setText("あり");

      kaigoWelfareFacilityNutritionRadioItem2.setGroup(getKaigoWelfareFacilityNutritionRadio());

      kaigoWelfareFacilityNutritionRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityNutritionRadioItem2();
    }
    return kaigoWelfareFacilityNutritionRadioItem2;

  }

  /**
   * 経口移行加算を取得します。
   * @return 経口移行加算
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityOralSwitchRadio(){
    if(kaigoWelfareFacilityOralSwitchRadio==null){

      kaigoWelfareFacilityOralSwitchRadio = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityOralSwitchRadioContainer().setText("経口移行加算");

      kaigoWelfareFacilityOralSwitchRadio.setBindPath("1510115");

      kaigoWelfareFacilityOralSwitchRadio.setUseClearButton(false);

      kaigoWelfareFacilityOralSwitchRadio.setModel(getKaigoWelfareFacilityOralSwitchRadioModel());

      kaigoWelfareFacilityOralSwitchRadio.setValues(new int[]{1,2});

      addKaigoWelfareFacilityOralSwitchRadio();
    }
    return kaigoWelfareFacilityOralSwitchRadio;

  }

  /**
   * 経口移行加算コンテナを取得します。
   * @return 経口移行加算コンテナ
   */
  protected ACLabelContainer getKaigoWelfareFacilityOralSwitchRadioContainer(){
    if(kaigoWelfareFacilityOralSwitchRadioContainer==null){
      kaigoWelfareFacilityOralSwitchRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityOralSwitchRadioContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityOralSwitchRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityOralSwitchRadioContainer.add(getKaigoWelfareFacilityOralSwitchRadio(), null);
    }
    return kaigoWelfareFacilityOralSwitchRadioContainer;
  }

  /**
   * 経口移行加算モデルを取得します。
   * @return 経口移行加算モデル
   */
  protected ACListModelAdapter getKaigoWelfareFacilityOralSwitchRadioModel(){
    if(kaigoWelfareFacilityOralSwitchRadioModel==null){
      kaigoWelfareFacilityOralSwitchRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityOralSwitchRadioModel();
    }
    return kaigoWelfareFacilityOralSwitchRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKaigoWelfareFacilityOralSwitchRadioItem1(){
    if(kaigoWelfareFacilityOralSwitchRadioItem1==null){

      kaigoWelfareFacilityOralSwitchRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityOralSwitchRadioItem1.setText("なし");

      kaigoWelfareFacilityOralSwitchRadioItem1.setGroup(getKaigoWelfareFacilityOralSwitchRadio());

      kaigoWelfareFacilityOralSwitchRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityOralSwitchRadioItem1();
    }
    return kaigoWelfareFacilityOralSwitchRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getKaigoWelfareFacilityOralSwitchRadioItem2(){
    if(kaigoWelfareFacilityOralSwitchRadioItem2==null){

      kaigoWelfareFacilityOralSwitchRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityOralSwitchRadioItem2.setText("あり");

      kaigoWelfareFacilityOralSwitchRadioItem2.setGroup(getKaigoWelfareFacilityOralSwitchRadio());

      kaigoWelfareFacilityOralSwitchRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityOralSwitchRadioItem2();
    }
    return kaigoWelfareFacilityOralSwitchRadioItem2;

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

      oralMaintenanceAdd.setBindPath("1510126");

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

      oralMaintenanceAddItem3.setBindPath("1510146");

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
  public ACValueArrayRadioButtonGroup getOralKeepAddRadioGroup(){
    if(oralKeepAddRadioGroup==null){

      oralKeepAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getOralKeepAddRadioGroupContainer().setText("口腔衛生管理加算");

      oralKeepAddRadioGroup.setBindPath("1510138");

      oralKeepAddRadioGroup.setNoSelectIndex(0);

      oralKeepAddRadioGroup.setUseClearButton(false);

      oralKeepAddRadioGroup.setModel(getOralKeepAddRadioGroupModel());

      oralKeepAddRadioGroup.setValues(new int[]{1,2});

      addOralKeepAddRadioGroup();
    }
    return oralKeepAddRadioGroup;

  }

  /**
   * 口腔衛生管理加算コンテナを取得します。
   * @return 口腔衛生管理加算コンテナ
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
   * 口腔衛生管理加算モデルを取得します。
   * @return 口腔衛生管理加算モデル
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
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityRecuperateDinnerRadio(){
    if(kaigoWelfareFacilityRecuperateDinnerRadio==null){

      kaigoWelfareFacilityRecuperateDinnerRadio = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityRecuperateDinnerRadioContainer().setText("療養食加算");

      kaigoWelfareFacilityRecuperateDinnerRadio.setBindPath("1510116");

      kaigoWelfareFacilityRecuperateDinnerRadio.setUseClearButton(false);

      kaigoWelfareFacilityRecuperateDinnerRadio.setModel(getKaigoWelfareFacilityRecuperateDinnerRadioModel());

      kaigoWelfareFacilityRecuperateDinnerRadio.setValues(new int[]{1,2});

      addKaigoWelfareFacilityRecuperateDinnerRadio();
    }
    return kaigoWelfareFacilityRecuperateDinnerRadio;

  }

  /**
   * 療養食加算コンテナを取得します。
   * @return 療養食加算コンテナ
   */
  protected ACLabelContainer getKaigoWelfareFacilityRecuperateDinnerRadioContainer(){
    if(kaigoWelfareFacilityRecuperateDinnerRadioContainer==null){
      kaigoWelfareFacilityRecuperateDinnerRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityRecuperateDinnerRadioContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityRecuperateDinnerRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityRecuperateDinnerRadioContainer.add(getKaigoWelfareFacilityRecuperateDinnerRadio(), null);
    }
    return kaigoWelfareFacilityRecuperateDinnerRadioContainer;
  }

  /**
   * 療養食加算モデルを取得します。
   * @return 療養食加算モデル
   */
  protected ACListModelAdapter getKaigoWelfareFacilityRecuperateDinnerRadioModel(){
    if(kaigoWelfareFacilityRecuperateDinnerRadioModel==null){
      kaigoWelfareFacilityRecuperateDinnerRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityRecuperateDinnerRadioModel();
    }
    return kaigoWelfareFacilityRecuperateDinnerRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKaigoWelfareFacilityRecuperateDinnerRadioItem1(){
    if(kaigoWelfareFacilityRecuperateDinnerRadioItem1==null){

      kaigoWelfareFacilityRecuperateDinnerRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityRecuperateDinnerRadioItem1.setText("なし");

      kaigoWelfareFacilityRecuperateDinnerRadioItem1.setGroup(getKaigoWelfareFacilityRecuperateDinnerRadio());

      kaigoWelfareFacilityRecuperateDinnerRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityRecuperateDinnerRadioItem1();
    }
    return kaigoWelfareFacilityRecuperateDinnerRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getKaigoWelfareFacilityRecuperateDinnerRadioItem2(){
    if(kaigoWelfareFacilityRecuperateDinnerRadioItem2==null){

      kaigoWelfareFacilityRecuperateDinnerRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityRecuperateDinnerRadioItem2.setText("あり");

      kaigoWelfareFacilityRecuperateDinnerRadioItem2.setGroup(getKaigoWelfareFacilityRecuperateDinnerRadio());

      kaigoWelfareFacilityRecuperateDinnerRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityRecuperateDinnerRadioItem2();
    }
    return kaigoWelfareFacilityRecuperateDinnerRadioItem2;

  }

  /**
   * 若年性認知症入所者受入加算を取得します。
   * @return 若年性認知症入所者受入加算
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("若年性認知症入所者受入加算");

      youngDementiaPatinetAddRadioGroup.setBindPath("1510137");

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
   * 退所関連加算を取得します。
   * @return 退所関連加算
   */
  public ACLabelContainer getKaigoWelfareFacilityHijoAddition(){
    if(kaigoWelfareFacilityHijoAddition==null){

      kaigoWelfareFacilityHijoAddition = new ACLabelContainer();

      kaigoWelfareFacilityHijoAddition.setText("退所関連加算");

      kaigoWelfareFacilityHijoAddition.setFollowChildEnabled(true);

      addKaigoWelfareFacilityHijoAddition();
    }
    return kaigoWelfareFacilityHijoAddition;

  }

  /**
   * 退所前訪問相談援助加算を取得します。
   * @return 退所前訪問相談援助加算
   */
  public ACIntegerCheckBox getHijoPreConsultationAddition(){
    if(hijoPreConsultationAddition==null){

      hijoPreConsultationAddition = new ACIntegerCheckBox();

      hijoPreConsultationAddition.setText("退所前訪問相談援助加算");

      hijoPreConsultationAddition.setBindPath("3020109");

      hijoPreConsultationAddition.setSelectValue(2);

      hijoPreConsultationAddition.setUnSelectValue(1);

      addHijoPreConsultationAddition();
    }
    return hijoPreConsultationAddition;

  }

  /**
   * 退所後訪問相談援助加算を取得します。
   * @return 退所後訪問相談援助加算
   */
  public ACIntegerCheckBox getHijoAfterConsultationAddition(){
    if(hijoAfterConsultationAddition==null){

      hijoAfterConsultationAddition = new ACIntegerCheckBox();

      hijoAfterConsultationAddition.setText("退所後訪問相談援助加算");

      hijoAfterConsultationAddition.setBindPath("3020110");

      hijoAfterConsultationAddition.setSelectValue(2);

      hijoAfterConsultationAddition.setUnSelectValue(1);

      addHijoAfterConsultationAddition();
    }
    return hijoAfterConsultationAddition;

  }

  /**
   * 退所時相談援助加算を取得します。
   * @return 退所時相談援助加算
   */
  public ACIntegerCheckBox getHijoConsultationAddition(){
    if(hijoConsultationAddition==null){

      hijoConsultationAddition = new ACIntegerCheckBox();

      hijoConsultationAddition.setText("退所時相談援助加算");

      hijoConsultationAddition.setBindPath("3020102");

      hijoConsultationAddition.setSelectValue(2);

      hijoConsultationAddition.setUnSelectValue(1);

      addHijoConsultationAddition();
    }
    return hijoConsultationAddition;

  }

  /**
   * 退所前連携加算を取得します。
   * @return 退所前連携加算
   */
  public ACIntegerCheckBox getHijoCooperationAddition(){
    if(hijoCooperationAddition==null){

      hijoCooperationAddition = new ACIntegerCheckBox();

      hijoCooperationAddition.setText("退所前連携加算");

      hijoCooperationAddition.setBindPath("3020103");

      hijoCooperationAddition.setSelectValue(2);

      hijoCooperationAddition.setUnSelectValue(1);

      addHijoCooperationAddition();
    }
    return hijoCooperationAddition;

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
   * 人員減算を取得します。
   * @return 人員減算
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityStaffSubtraction(){
    if(kaigoWelfareFacilityStaffSubtraction==null){

      kaigoWelfareFacilityStaffSubtraction = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityStaffSubtractionContainer().setText("人員減算");

      kaigoWelfareFacilityStaffSubtraction.setBindPath("1510120");

      kaigoWelfareFacilityStaffSubtraction.setUseClearButton(false);

      kaigoWelfareFacilityStaffSubtraction.setModel(getKaigoWelfareFacilityStaffSubtractionModel());

      kaigoWelfareFacilityStaffSubtraction.setValues(new int[]{1,2,3});

      addKaigoWelfareFacilityStaffSubtraction();
    }
    return kaigoWelfareFacilityStaffSubtraction;

  }

  /**
   * 人員減算コンテナを取得します。
   * @return 人員減算コンテナ
   */
  protected ACLabelContainer getKaigoWelfareFacilityStaffSubtractionContainer(){
    if(kaigoWelfareFacilityStaffSubtractionContainer==null){
      kaigoWelfareFacilityStaffSubtractionContainer = new ACLabelContainer();
      kaigoWelfareFacilityStaffSubtractionContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityStaffSubtractionContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityStaffSubtractionContainer.add(getKaigoWelfareFacilityStaffSubtraction(), null);
    }
    return kaigoWelfareFacilityStaffSubtractionContainer;
  }

  /**
   * 人員減算モデルを取得します。
   * @return 人員減算モデル
   */
  protected ACListModelAdapter getKaigoWelfareFacilityStaffSubtractionModel(){
    if(kaigoWelfareFacilityStaffSubtractionModel==null){
      kaigoWelfareFacilityStaffSubtractionModel = new ACListModelAdapter();
      addKaigoWelfareFacilityStaffSubtractionModel();
    }
    return kaigoWelfareFacilityStaffSubtractionModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKaigoWelfareFacilityStaffSubtractionCapacityNot(){
    if(kaigoWelfareFacilityStaffSubtractionCapacityNot==null){

      kaigoWelfareFacilityStaffSubtractionCapacityNot = new ACRadioButtonItem();

      kaigoWelfareFacilityStaffSubtractionCapacityNot.setText("なし");

      kaigoWelfareFacilityStaffSubtractionCapacityNot.setGroup(getKaigoWelfareFacilityStaffSubtraction());

      kaigoWelfareFacilityStaffSubtractionCapacityNot.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityStaffSubtractionCapacityNot();
    }
    return kaigoWelfareFacilityStaffSubtractionCapacityNot;

  }

  /**
   * 定員超過を取得します。
   * @return 定員超過
   */
  public ACRadioButtonItem getKaigoWelfareFacilityStaffSubtractionCapacityExcess(){
    if(kaigoWelfareFacilityStaffSubtractionCapacityExcess==null){

      kaigoWelfareFacilityStaffSubtractionCapacityExcess = new ACRadioButtonItem();

      kaigoWelfareFacilityStaffSubtractionCapacityExcess.setText("定員超過");

      kaigoWelfareFacilityStaffSubtractionCapacityExcess.setGroup(getKaigoWelfareFacilityStaffSubtraction());

      kaigoWelfareFacilityStaffSubtractionCapacityExcess.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoWelfareFacilityStaffSubtractionCapacityExcess();
    }
    return kaigoWelfareFacilityStaffSubtractionCapacityExcess;

  }

  /**
   * 看護・介護職員又は介護支援専門員の不足を取得します。
   * @return 看護・介護職員又は介護支援専門員の不足
   */
  public ACRadioButtonItem getKaigoWelfareFacilityStaffSubtractionPersonLack(){
    if(kaigoWelfareFacilityStaffSubtractionPersonLack==null){

      kaigoWelfareFacilityStaffSubtractionPersonLack = new ACRadioButtonItem();

      kaigoWelfareFacilityStaffSubtractionPersonLack.setText("<html>看護・介護職員又は<br>介護支援専門員の不足</html>");

      kaigoWelfareFacilityStaffSubtractionPersonLack.setGroup(getKaigoWelfareFacilityStaffSubtraction());

      kaigoWelfareFacilityStaffSubtractionPersonLack.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityStaffSubtractionPersonLack();
    }
    return kaigoWelfareFacilityStaffSubtractionPersonLack;

  }

  /**
   * 食事コンテナを取得します。
   * @return 食事コンテナ
   */
  public ACBackLabelContainer getKaigoWelfareFacilityDinnerContainer(){
    if(kaigoWelfareFacilityDinnerContainer==null){

      kaigoWelfareFacilityDinnerContainer = new ACBackLabelContainer();

      kaigoWelfareFacilityDinnerContainer.setFollowChildEnabled(true);

      addKaigoWelfareFacilityDinnerContainer();
    }
    return kaigoWelfareFacilityDinnerContainer;

  }

  /**
   * 食事提供を取得します。
   * @return 食事提供
   */
  public ACComboBox getKaigoWelfareFacilityDinnerOffer(){
    if(kaigoWelfareFacilityDinnerOffer==null){

      kaigoWelfareFacilityDinnerOffer = new ACComboBox();

      getKaigoWelfareFacilityDinnerOfferContainer().setText("食事提供");

      kaigoWelfareFacilityDinnerOffer.setBindPath("1510121");

      kaigoWelfareFacilityDinnerOffer.setEditable(false);

      kaigoWelfareFacilityDinnerOffer.setModelBindPath("1510121");

      kaigoWelfareFacilityDinnerOffer.setRenderBindPath("CONTENT");

      kaigoWelfareFacilityDinnerOffer.setModel(getKaigoWelfareFacilityDinnerOfferModel());

      addKaigoWelfareFacilityDinnerOffer();
    }
    return kaigoWelfareFacilityDinnerOffer;

  }

  /**
   * 食事提供コンテナを取得します。
   * @return 食事提供コンテナ
   */
  protected ACLabelContainer getKaigoWelfareFacilityDinnerOfferContainer(){
    if(kaigoWelfareFacilityDinnerOfferContainer==null){
      kaigoWelfareFacilityDinnerOfferContainer = new ACLabelContainer();
      kaigoWelfareFacilityDinnerOfferContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityDinnerOfferContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityDinnerOfferContainer.add(getKaigoWelfareFacilityDinnerOffer(), null);
    }
    return kaigoWelfareFacilityDinnerOfferContainer;
  }

  /**
   * 食事提供モデルを取得します。
   * @return 食事提供モデル
   */
  protected ACComboBoxModelAdapter getKaigoWelfareFacilityDinnerOfferModel(){
    if(kaigoWelfareFacilityDinnerOfferModel==null){
      kaigoWelfareFacilityDinnerOfferModel = new ACComboBoxModelAdapter();
      addKaigoWelfareFacilityDinnerOfferModel();
    }
    return kaigoWelfareFacilityDinnerOfferModel;
  }

  /**
   * 食事費用を取得します。
   * @return 食事費用
   */
  public ACTextField getKaigoWelfareFacilityDinnerCost(){
    if(kaigoWelfareFacilityDinnerCost==null){

      kaigoWelfareFacilityDinnerCost = new ACTextField();

      getKaigoWelfareFacilityDinnerCostContainer().setText("食事費用");

      kaigoWelfareFacilityDinnerCost.setBindPath("1510123");

      kaigoWelfareFacilityDinnerCost.setColumns(4);

      kaigoWelfareFacilityDinnerCost.setCharType(VRCharType.ONLY_DIGIT);

      kaigoWelfareFacilityDinnerCost.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoWelfareFacilityDinnerCost.setIMEMode(InputSubset.LATIN);

      kaigoWelfareFacilityDinnerCost.setMaxLength(5);

      addKaigoWelfareFacilityDinnerCost();
    }
    return kaigoWelfareFacilityDinnerCost;

  }

  /**
   * 食事費用コンテナを取得します。
   * @return 食事費用コンテナ
   */
  protected ACLabelContainer getKaigoWelfareFacilityDinnerCostContainer(){
    if(kaigoWelfareFacilityDinnerCostContainer==null){
      kaigoWelfareFacilityDinnerCostContainer = new ACLabelContainer();
      kaigoWelfareFacilityDinnerCostContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityDinnerCostContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityDinnerCostContainer.add(getKaigoWelfareFacilityDinnerCost(), null);
    }
    return kaigoWelfareFacilityDinnerCostContainer;
  }

  /**
   * 身体拘束廃止未実施減算を取得します。
   * @return 身体拘束廃止未実施減算
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityBodyRestraintAbolitionRadio(){
    if(kaigoWelfareFacilityBodyRestraintAbolitionRadio==null){

      kaigoWelfareFacilityBodyRestraintAbolitionRadio = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityBodyRestraintAbolitionRadioContainer().setText("身体拘束廃止未実施減算");

      kaigoWelfareFacilityBodyRestraintAbolitionRadio.setBindPath("1510128");

      kaigoWelfareFacilityBodyRestraintAbolitionRadio.setUseClearButton(false);

      kaigoWelfareFacilityBodyRestraintAbolitionRadio.setModel(getKaigoWelfareFacilityBodyRestraintAbolitionRadioModel());

      kaigoWelfareFacilityBodyRestraintAbolitionRadio.setValues(new int[]{1,2});

      addKaigoWelfareFacilityBodyRestraintAbolitionRadio();
    }
    return kaigoWelfareFacilityBodyRestraintAbolitionRadio;

  }

  /**
   * 身体拘束廃止未実施減算コンテナを取得します。
   * @return 身体拘束廃止未実施減算コンテナ
   */
  protected ACLabelContainer getKaigoWelfareFacilityBodyRestraintAbolitionRadioContainer(){
    if(kaigoWelfareFacilityBodyRestraintAbolitionRadioContainer==null){
      kaigoWelfareFacilityBodyRestraintAbolitionRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityBodyRestraintAbolitionRadioContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityBodyRestraintAbolitionRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityBodyRestraintAbolitionRadioContainer.add(getKaigoWelfareFacilityBodyRestraintAbolitionRadio(), null);
    }
    return kaigoWelfareFacilityBodyRestraintAbolitionRadioContainer;
  }

  /**
   * 身体拘束廃止未実施減算モデルを取得します。
   * @return 身体拘束廃止未実施減算モデル
   */
  protected ACListModelAdapter getKaigoWelfareFacilityBodyRestraintAbolitionRadioModel(){
    if(kaigoWelfareFacilityBodyRestraintAbolitionRadioModel==null){
      kaigoWelfareFacilityBodyRestraintAbolitionRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityBodyRestraintAbolitionRadioModel();
    }
    return kaigoWelfareFacilityBodyRestraintAbolitionRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKaigoWelfareFacilityBodyRestraintAbolitionRadioItem1(){
    if(kaigoWelfareFacilityBodyRestraintAbolitionRadioItem1==null){

      kaigoWelfareFacilityBodyRestraintAbolitionRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityBodyRestraintAbolitionRadioItem1.setText("なし");

      kaigoWelfareFacilityBodyRestraintAbolitionRadioItem1.setGroup(getKaigoWelfareFacilityBodyRestraintAbolitionRadio());

      kaigoWelfareFacilityBodyRestraintAbolitionRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityBodyRestraintAbolitionRadioItem1();
    }
    return kaigoWelfareFacilityBodyRestraintAbolitionRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getKaigoWelfareFacilityBodyRestraintAbolitionRadioItem2(){
    if(kaigoWelfareFacilityBodyRestraintAbolitionRadioItem2==null){

      kaigoWelfareFacilityBodyRestraintAbolitionRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityBodyRestraintAbolitionRadioItem2.setText("あり");

      kaigoWelfareFacilityBodyRestraintAbolitionRadioItem2.setGroup(getKaigoWelfareFacilityBodyRestraintAbolitionRadio());

      kaigoWelfareFacilityBodyRestraintAbolitionRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityBodyRestraintAbolitionRadioItem2();
    }
    return kaigoWelfareFacilityBodyRestraintAbolitionRadioItem2;

  }

  /**
   * 看取り介護加算を取得します。
   * @return 看取り介護加算
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityTakingCareNursingAddRadio(){
    if(kaigoWelfareFacilityTakingCareNursingAddRadio==null){

      kaigoWelfareFacilityTakingCareNursingAddRadio = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityTakingCareNursingAddRadioContainer().setText("看取り介護加算");

      kaigoWelfareFacilityTakingCareNursingAddRadio.setBindPath("1510139");

      kaigoWelfareFacilityTakingCareNursingAddRadio.setNoSelectIndex(0);

      kaigoWelfareFacilityTakingCareNursingAddRadio.setUseClearButton(false);

      kaigoWelfareFacilityTakingCareNursingAddRadio.setModel(getKaigoWelfareFacilityTakingCareNursingAddRadioModel());

      kaigoWelfareFacilityTakingCareNursingAddRadio.setValues(new int[]{1,2,3,4});

      addKaigoWelfareFacilityTakingCareNursingAddRadio();
    }
    return kaigoWelfareFacilityTakingCareNursingAddRadio;

  }

  /**
   * 看取り介護加算コンテナを取得します。
   * @return 看取り介護加算コンテナ
   */
  protected ACLabelContainer getKaigoWelfareFacilityTakingCareNursingAddRadioContainer(){
    if(kaigoWelfareFacilityTakingCareNursingAddRadioContainer==null){
      kaigoWelfareFacilityTakingCareNursingAddRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityTakingCareNursingAddRadioContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityTakingCareNursingAddRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityTakingCareNursingAddRadioContainer.add(getKaigoWelfareFacilityTakingCareNursingAddRadio(), null);
    }
    return kaigoWelfareFacilityTakingCareNursingAddRadioContainer;
  }

  /**
   * 看取り介護加算モデルを取得します。
   * @return 看取り介護加算モデル
   */
  protected ACListModelAdapter getKaigoWelfareFacilityTakingCareNursingAddRadioModel(){
    if(kaigoWelfareFacilityTakingCareNursingAddRadioModel==null){
      kaigoWelfareFacilityTakingCareNursingAddRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityTakingCareNursingAddRadioModel();
    }
    return kaigoWelfareFacilityTakingCareNursingAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKaigoWelfareFacilityTakingCareNursingAddRadioItem1(){
    if(kaigoWelfareFacilityTakingCareNursingAddRadioItem1==null){

      kaigoWelfareFacilityTakingCareNursingAddRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityTakingCareNursingAddRadioItem1.setText("なし");

      kaigoWelfareFacilityTakingCareNursingAddRadioItem1.setGroup(getKaigoWelfareFacilityTakingCareNursingAddRadio());

      kaigoWelfareFacilityTakingCareNursingAddRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoWelfareFacilityTakingCareNursingAddRadioItem1();
    }
    return kaigoWelfareFacilityTakingCareNursingAddRadioItem1;

  }

  /**
   * 死亡日以前4日以上30日以下を取得します。
   * @return 死亡日以前4日以上30日以下
   */
  public ACRadioButtonItem getKaigoWelfareFacilityTakingCareNursingAddRadioItem2(){
    if(kaigoWelfareFacilityTakingCareNursingAddRadioItem2==null){

      kaigoWelfareFacilityTakingCareNursingAddRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityTakingCareNursingAddRadioItem2.setText("死亡日以前4日以上30日以下");

      kaigoWelfareFacilityTakingCareNursingAddRadioItem2.setGroup(getKaigoWelfareFacilityTakingCareNursingAddRadio());

      kaigoWelfareFacilityTakingCareNursingAddRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoWelfareFacilityTakingCareNursingAddRadioItem2();
    }
    return kaigoWelfareFacilityTakingCareNursingAddRadioItem2;

  }

  /**
   * 死亡日以前2日又は3日を取得します。
   * @return 死亡日以前2日又は3日
   */
  public ACRadioButtonItem getKaigoWelfareFacilityTakingCareNursingAddRadioItem3(){
    if(kaigoWelfareFacilityTakingCareNursingAddRadioItem3==null){

      kaigoWelfareFacilityTakingCareNursingAddRadioItem3 = new ACRadioButtonItem();

      kaigoWelfareFacilityTakingCareNursingAddRadioItem3.setText("死亡日以前2日又は3日");

      kaigoWelfareFacilityTakingCareNursingAddRadioItem3.setGroup(getKaigoWelfareFacilityTakingCareNursingAddRadio());

      kaigoWelfareFacilityTakingCareNursingAddRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoWelfareFacilityTakingCareNursingAddRadioItem3();
    }
    return kaigoWelfareFacilityTakingCareNursingAddRadioItem3;

  }

  /**
   * 死亡日を取得します。
   * @return 死亡日
   */
  public ACRadioButtonItem getKaigoWelfareFacilityTakingCareNursingAddRadioItem4(){
    if(kaigoWelfareFacilityTakingCareNursingAddRadioItem4==null){

      kaigoWelfareFacilityTakingCareNursingAddRadioItem4 = new ACRadioButtonItem();

      kaigoWelfareFacilityTakingCareNursingAddRadioItem4.setText("死亡日");

      kaigoWelfareFacilityTakingCareNursingAddRadioItem4.setGroup(getKaigoWelfareFacilityTakingCareNursingAddRadio());

      kaigoWelfareFacilityTakingCareNursingAddRadioItem4.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityTakingCareNursingAddRadioItem4();
    }
    return kaigoWelfareFacilityTakingCareNursingAddRadioItem4;

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

      kaigoWelfareFacilityTakingCareNursingAddDays.setBindPath("1510132");

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
   * タブ5を取得します。
   * @return タブ5
   */
  public ACPanel getTab5(){
    if(tab5==null){

      tab5 = new ACPanel();

      tab5.setFollowChildEnabled(true);

      tab5.setHgap(0);

      addTab5();
    }
    return tab5;

  }

  /**
   * 在宅復帰支援機能加算を取得します。
   * @return 在宅復帰支援機能加算
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityStayReturnSupportAddRadio(){
    if(kaigoWelfareFacilityStayReturnSupportAddRadio==null){

      kaigoWelfareFacilityStayReturnSupportAddRadio = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityStayReturnSupportAddRadioContainer().setText("在宅復帰支援機能加算");

      kaigoWelfareFacilityStayReturnSupportAddRadio.setBindPath("1510130");

      kaigoWelfareFacilityStayReturnSupportAddRadio.setUseClearButton(false);

      kaigoWelfareFacilityStayReturnSupportAddRadio.setModel(getKaigoWelfareFacilityStayReturnSupportAddRadioModel());

      kaigoWelfareFacilityStayReturnSupportAddRadio.setValues(new int[]{1,2});

      addKaigoWelfareFacilityStayReturnSupportAddRadio();
    }
    return kaigoWelfareFacilityStayReturnSupportAddRadio;

  }

  /**
   * 在宅復帰支援機能加算コンテナを取得します。
   * @return 在宅復帰支援機能加算コンテナ
   */
  protected ACLabelContainer getKaigoWelfareFacilityStayReturnSupportAddRadioContainer(){
    if(kaigoWelfareFacilityStayReturnSupportAddRadioContainer==null){
      kaigoWelfareFacilityStayReturnSupportAddRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityStayReturnSupportAddRadioContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityStayReturnSupportAddRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityStayReturnSupportAddRadioContainer.add(getKaigoWelfareFacilityStayReturnSupportAddRadio(), null);
    }
    return kaigoWelfareFacilityStayReturnSupportAddRadioContainer;
  }

  /**
   * 在宅復帰支援機能加算モデルを取得します。
   * @return 在宅復帰支援機能加算モデル
   */
  protected ACListModelAdapter getKaigoWelfareFacilityStayReturnSupportAddRadioModel(){
    if(kaigoWelfareFacilityStayReturnSupportAddRadioModel==null){
      kaigoWelfareFacilityStayReturnSupportAddRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityStayReturnSupportAddRadioModel();
    }
    return kaigoWelfareFacilityStayReturnSupportAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKaigoWelfareFacilityStayReturnSupportAddRadioItem1(){
    if(kaigoWelfareFacilityStayReturnSupportAddRadioItem1==null){

      kaigoWelfareFacilityStayReturnSupportAddRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityStayReturnSupportAddRadioItem1.setText("なし");

      kaigoWelfareFacilityStayReturnSupportAddRadioItem1.setGroup(getKaigoWelfareFacilityStayReturnSupportAddRadio());

      kaigoWelfareFacilityStayReturnSupportAddRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityStayReturnSupportAddRadioItem1();
    }
    return kaigoWelfareFacilityStayReturnSupportAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getKaigoWelfareFacilityStayReturnSupportAddRadioItem2(){
    if(kaigoWelfareFacilityStayReturnSupportAddRadioItem2==null){

      kaigoWelfareFacilityStayReturnSupportAddRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityStayReturnSupportAddRadioItem2.setText("あり");

      kaigoWelfareFacilityStayReturnSupportAddRadioItem2.setGroup(getKaigoWelfareFacilityStayReturnSupportAddRadio());

      kaigoWelfareFacilityStayReturnSupportAddRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityStayReturnSupportAddRadioItem2();
    }
    return kaigoWelfareFacilityStayReturnSupportAddRadioItem2;

  }

  /**
   * 在宅・入所相互利用加算を取得します。
   * @return 在宅・入所相互利用加算
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityHomeShareAddRadio(){
    if(kaigoWelfareFacilityHomeShareAddRadio==null){

      kaigoWelfareFacilityHomeShareAddRadio = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityHomeShareAddRadioContainer().setText("在宅・入所相互利用加算");

      kaigoWelfareFacilityHomeShareAddRadio.setBindPath("1510131");

      kaigoWelfareFacilityHomeShareAddRadio.setUseClearButton(false);

      kaigoWelfareFacilityHomeShareAddRadio.setModel(getKaigoWelfareFacilityHomeShareAddRadioModel());

      kaigoWelfareFacilityHomeShareAddRadio.setValues(new int[]{1,2});

      addKaigoWelfareFacilityHomeShareAddRadio();
    }
    return kaigoWelfareFacilityHomeShareAddRadio;

  }

  /**
   * 在宅・入所相互利用加算コンテナを取得します。
   * @return 在宅・入所相互利用加算コンテナ
   */
  protected ACLabelContainer getKaigoWelfareFacilityHomeShareAddRadioContainer(){
    if(kaigoWelfareFacilityHomeShareAddRadioContainer==null){
      kaigoWelfareFacilityHomeShareAddRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityHomeShareAddRadioContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityHomeShareAddRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityHomeShareAddRadioContainer.add(getKaigoWelfareFacilityHomeShareAddRadio(), null);
    }
    return kaigoWelfareFacilityHomeShareAddRadioContainer;
  }

  /**
   * 在宅・入所相互利用加算モデルを取得します。
   * @return 在宅・入所相互利用加算モデル
   */
  protected ACListModelAdapter getKaigoWelfareFacilityHomeShareAddRadioModel(){
    if(kaigoWelfareFacilityHomeShareAddRadioModel==null){
      kaigoWelfareFacilityHomeShareAddRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityHomeShareAddRadioModel();
    }
    return kaigoWelfareFacilityHomeShareAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKaigoWelfareFacilityHomeShareAddRadioItem1(){
    if(kaigoWelfareFacilityHomeShareAddRadioItem1==null){

      kaigoWelfareFacilityHomeShareAddRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityHomeShareAddRadioItem1.setText("なし");

      kaigoWelfareFacilityHomeShareAddRadioItem1.setGroup(getKaigoWelfareFacilityHomeShareAddRadio());

      kaigoWelfareFacilityHomeShareAddRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityHomeShareAddRadioItem1();
    }
    return kaigoWelfareFacilityHomeShareAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getKaigoWelfareFacilityHomeShareAddRadioItem2(){
    if(kaigoWelfareFacilityHomeShareAddRadioItem2==null){

      kaigoWelfareFacilityHomeShareAddRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityHomeShareAddRadioItem2.setText("あり");

      kaigoWelfareFacilityHomeShareAddRadioItem2.setGroup(getKaigoWelfareFacilityHomeShareAddRadio());

      kaigoWelfareFacilityHomeShareAddRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityHomeShareAddRadioItem2();
    }
    return kaigoWelfareFacilityHomeShareAddRadioItem2;

  }

  /**
   * 認知症専門ケア加算を取得します。
   * @return 認知症専門ケア加算
   */
  public ACValueArrayRadioButtonGroup getDementiaProfessionalCareAddRadioGroup(){
    if(dementiaProfessionalCareAddRadioGroup==null){

      dementiaProfessionalCareAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaProfessionalCareAddRadioGroupContainer().setText("認知症専門ケア加算");

      dementiaProfessionalCareAddRadioGroup.setBindPath("1510140");

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
   * 認知症行動・心理症状緊急対応加算を取得します。
   * @return 認知症行動・心理症状緊急対応加算
   */
  public ACValueArrayRadioButtonGroup getDementiaEmergencyAddRadioGroup(){
    if(dementiaEmergencyAddRadioGroup==null){

      dementiaEmergencyAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaEmergencyAddRadioGroupContainer().setText("認知症行動・心理症状緊急対応加算");

      dementiaEmergencyAddRadioGroup.setBindPath("1510144");

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
   * サービス提供体制強化加算を取得します。
   * @return サービス提供体制強化加算
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("サービス提供体制強化加算");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1510141");

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
   * 算定区分を取得します。
   * @return 算定区分
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityCalculationDivisionRadilo(){
    if(kaigoWelfareFacilityCalculationDivisionRadilo==null){

      kaigoWelfareFacilityCalculationDivisionRadilo = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityCalculationDivisionRadiloContainer().setText("算定区分");

      kaigoWelfareFacilityCalculationDivisionRadilo.setBindPath("9");

      kaigoWelfareFacilityCalculationDivisionRadilo.setUseClearButton(false);

      kaigoWelfareFacilityCalculationDivisionRadilo.setModel(getKaigoWelfareFacilityCalculationDivisionRadiloModel());

      kaigoWelfareFacilityCalculationDivisionRadilo.setValues(new int[]{1,2});

      addKaigoWelfareFacilityCalculationDivisionRadilo();
    }
    return kaigoWelfareFacilityCalculationDivisionRadilo;

  }

  /**
   * 算定区分コンテナを取得します。
   * @return 算定区分コンテナ
   */
  protected ACLabelContainer getKaigoWelfareFacilityCalculationDivisionRadiloContainer(){
    if(kaigoWelfareFacilityCalculationDivisionRadiloContainer==null){
      kaigoWelfareFacilityCalculationDivisionRadiloContainer = new ACLabelContainer();
      kaigoWelfareFacilityCalculationDivisionRadiloContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityCalculationDivisionRadiloContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityCalculationDivisionRadiloContainer.add(getKaigoWelfareFacilityCalculationDivisionRadilo(), null);
    }
    return kaigoWelfareFacilityCalculationDivisionRadiloContainer;
  }

  /**
   * 算定区分モデルを取得します。
   * @return 算定区分モデル
   */
  protected ACListModelAdapter getKaigoWelfareFacilityCalculationDivisionRadiloModel(){
    if(kaigoWelfareFacilityCalculationDivisionRadiloModel==null){
      kaigoWelfareFacilityCalculationDivisionRadiloModel = new ACListModelAdapter();
      addKaigoWelfareFacilityCalculationDivisionRadiloModel();
    }
    return kaigoWelfareFacilityCalculationDivisionRadiloModel;
  }

  /**
   * 通常を取得します。
   * @return 通常
   */
  public ACRadioButtonItem getKaigoWelfareFacilityCalculationDivisionRadiloItem1(){
    if(kaigoWelfareFacilityCalculationDivisionRadiloItem1==null){

      kaigoWelfareFacilityCalculationDivisionRadiloItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityCalculationDivisionRadiloItem1.setText("通常");

      kaigoWelfareFacilityCalculationDivisionRadiloItem1.setGroup(getKaigoWelfareFacilityCalculationDivisionRadilo());

      kaigoWelfareFacilityCalculationDivisionRadiloItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityCalculationDivisionRadiloItem1();
    }
    return kaigoWelfareFacilityCalculationDivisionRadiloItem1;

  }

  /**
   * 加算のみを取得します。
   * @return 加算のみ
   */
  public ACRadioButtonItem getKaigoWelfareFacilityCalculationDivisionRadiloItem2(){
    if(kaigoWelfareFacilityCalculationDivisionRadiloItem2==null){

      kaigoWelfareFacilityCalculationDivisionRadiloItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityCalculationDivisionRadiloItem2.setText("加算のみ");

      kaigoWelfareFacilityCalculationDivisionRadiloItem2.setGroup(getKaigoWelfareFacilityCalculationDivisionRadilo());

      kaigoWelfareFacilityCalculationDivisionRadiloItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityCalculationDivisionRadiloItem2();
    }
    return kaigoWelfareFacilityCalculationDivisionRadiloItem2;

  }

  /**
   * コンストラクタです。
   */
  public QS001_15111_201504Design() {

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

    tab1.add(getKaigoWelfareFacilityInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getKaigoWelfareFacilityOldMeasuresPerson(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getKaigoWelfareFacilityHospitalRoomDivisionContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getKaigoWelfareFacilityUnitCareMaintenanceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getKaigoWelfareFacilityJunUnitCareAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getKaigoWelfareFacilityNightShiftSubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getDailyLifeContinuanceRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 施設等の区分に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityInstitutionDivisionRadio(){

  }

  /**
   * 施設等の区分モデルに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityInstitutionDivisionRadioModel(){

    getKaigoWelfareFacilityInstitutionDivisionRadioItem1().setButtonIndex(1);

    getKaigoWelfareFacilityInstitutionDivisionRadioModel().add(getKaigoWelfareFacilityInstitutionDivisionRadioItem1());

    getKaigoWelfareFacilityInstitutionDivisionRadioItem2().setButtonIndex(2);

    getKaigoWelfareFacilityInstitutionDivisionRadioModel().add(getKaigoWelfareFacilityInstitutionDivisionRadioItem2());

    getKaigoWelfareFacilityInstitutionDivisionRadioItem3().setButtonIndex(3);

    getKaigoWelfareFacilityInstitutionDivisionRadioModel().add(getKaigoWelfareFacilityInstitutionDivisionRadioItem3());

    getKaigoWelfareFacilityInstitutionDivisionRadioItem4().setButtonIndex(4);

    getKaigoWelfareFacilityInstitutionDivisionRadioModel().add(getKaigoWelfareFacilityInstitutionDivisionRadioItem4());

  }

  /**
   * 介護福祉施設に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityInstitutionDivisionRadioItem1(){

  }

  /**
   * 小規模介護福祉施設に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityInstitutionDivisionRadioItem2(){

  }

  /**
   * ユニット型介護福祉施設に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityInstitutionDivisionRadioItem3(){

  }

  /**
   * ユニット型小規模介護福祉施設に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityInstitutionDivisionRadioItem4(){

  }

  /**
   * 旧措置入所者チェックに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityOldMeasuresPerson(){

  }

  /**
   * 病室区分コンテナに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityHospitalRoomDivisionContena(){

    kaigoWelfareFacilityHospitalRoomDivisionContena.add(getKaigoWelfareFacilityHospitalRoomDivisionRadio(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoWelfareFacilityHospitalRoomDivisionContena.add(getKaigoWelfareFacilityUnitHospitalRoomDivisionRadio(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 病室区分（介護福祉施設）に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityHospitalRoomDivisionRadio(){

  }

  /**
   * 病室区分（介護福祉施設）モデルに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityHospitalRoomDivisionRadioModel(){

    getKaigoWelfareFacilityHospitalRoomDivisionRadioItem1().setButtonIndex(1);

    getKaigoWelfareFacilityHospitalRoomDivisionRadioModel().add(getKaigoWelfareFacilityHospitalRoomDivisionRadioItem1());

    getKaigoWelfareFacilityHospitalRoomDivisionRadioItem2().setButtonIndex(2);

    getKaigoWelfareFacilityHospitalRoomDivisionRadioModel().add(getKaigoWelfareFacilityHospitalRoomDivisionRadioItem2());

  }

  /**
   * 従来型個室に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityHospitalRoomDivisionRadioItem1(){

  }

  /**
   * 多床室に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityHospitalRoomDivisionRadioItem2(){

  }

  /**
   * 病室区分（ユニット型介護福祉施設）に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityUnitHospitalRoomDivisionRadio(){

  }

  /**
   * 病室区分（ユニット型介護福祉施設）モデルに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityUnitHospitalRoomDivisionRadioModel(){

    getKaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem1().setButtonIndex(1);

    getKaigoWelfareFacilityUnitHospitalRoomDivisionRadioModel().add(getKaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem1());

    getKaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem2().setButtonIndex(2);

    getKaigoWelfareFacilityUnitHospitalRoomDivisionRadioModel().add(getKaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem2());

  }

  /**
   * ユニット型個室に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem1(){

  }

  /**
   * ユニット型準個室に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem2(){

  }

  /**
   * ユニットケアの整備に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityUnitCareMaintenanceRadio(){

  }

  /**
   * ユニットケアの整備モデルに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityUnitCareMaintenanceRadioModel(){

    getKaigoWelfareFacilityUnitCareMaintenanceRadioItem1().setButtonIndex(1);

    getKaigoWelfareFacilityUnitCareMaintenanceRadioModel().add(getKaigoWelfareFacilityUnitCareMaintenanceRadioItem1());

    getKaigoWelfareFacilityUnitCareMaintenanceRadioItem2().setButtonIndex(2);

    getKaigoWelfareFacilityUnitCareMaintenanceRadioModel().add(getKaigoWelfareFacilityUnitCareMaintenanceRadioItem2());

  }

  /**
   * 未整備に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityUnitCareMaintenanceRadioItem1(){

  }

  /**
   * 整備に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityUnitCareMaintenanceRadioItem2(){

  }

  /**
   * 準ユニットケア加算に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityJunUnitCareAddRadio(){

  }

  /**
   * 準ユニットケア加算モデルに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityJunUnitCareAddRadioModel(){

    getKaigoWelfareFacilityJunUnitCareAddRadioItem1().setButtonIndex(1);

    getKaigoWelfareFacilityJunUnitCareAddRadioModel().add(getKaigoWelfareFacilityJunUnitCareAddRadioItem1());

    getKaigoWelfareFacilityJunUnitCareAddRadioItem2().setButtonIndex(2);

    getKaigoWelfareFacilityJunUnitCareAddRadioModel().add(getKaigoWelfareFacilityJunUnitCareAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityJunUnitCareAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityJunUnitCareAddRadioItem2(){

  }

  /**
   * 夜勤体制減算に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityNightShiftSubtractionRadio(){

  }

  /**
   * 夜勤体制減算モデルに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityNightShiftSubtractionRadioModel(){

    getKaigoWelfareFacilityNightShiftSubtractionRadioItem1().setButtonIndex(1);

    getKaigoWelfareFacilityNightShiftSubtractionRadioModel().add(getKaigoWelfareFacilityNightShiftSubtractionRadioItem1());

    getKaigoWelfareFacilityNightShiftSubtractionRadioItem2().setButtonIndex(2);

    getKaigoWelfareFacilityNightShiftSubtractionRadioModel().add(getKaigoWelfareFacilityNightShiftSubtractionRadioItem2());

  }

  /**
   * 基準型に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityNightShiftSubtractionRadioItem1(){

  }

  /**
   * 減算型に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityNightShiftSubtractionRadioItem2(){

  }

  /**
   * 日常生活継続支援加算に内部項目を追加します。
   */
  protected void addDailyLifeContinuanceRadioGroup(){

  }

  /**
   * 日常生活継続支援加算モデルに内部項目を追加します。
   */
  protected void addDailyLifeContinuanceRadioGroupModel(){

    getDailyLifeContinuanceRadioItem1().setButtonIndex(1);

    getDailyLifeContinuanceRadioGroupModel().add(getDailyLifeContinuanceRadioItem1());

    getDailyLifeContinuanceRadioItem2().setButtonIndex(2);

    getDailyLifeContinuanceRadioGroupModel().add(getDailyLifeContinuanceRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addDailyLifeContinuanceRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addDailyLifeContinuanceRadioItem2(){

  }

  /**
   * タブ2に内部項目を追加します。
   */
  protected void addTab2(){

    tab2.add(getKaigoWelfareFacilityFunctionTrainingRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getKaigoWelfareFacilityHandicappedRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getNurseStructuralAddGroup(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getNightStaffDispositionAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getStayPeopleCountRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getKaigoWelfareFacilityFacilityFulltimeDoctorRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getKaigoWelfareFacilityPsychiatristRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getKaigoWelfareFacilityStayingOutOvernightCostRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getKaigoWelfareFacilityDefaultRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 個別機能訓練指導加算に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityFunctionTrainingRadio(){

  }

  /**
   * 個別機能訓練指導加算モデルに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityFunctionTrainingRadioModel(){

    getKaigoWelfareFacilityFunctionTrainingRadioItem2().setButtonIndex(1);

    getKaigoWelfareFacilityFunctionTrainingRadioModel().add(getKaigoWelfareFacilityFunctionTrainingRadioItem2());

    getKaigoWelfareFacilityFunctionTrainingRadioItem1().setButtonIndex(2);

    getKaigoWelfareFacilityFunctionTrainingRadioModel().add(getKaigoWelfareFacilityFunctionTrainingRadioItem1());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityFunctionTrainingRadioItem2(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityFunctionTrainingRadioItem1(){

  }

  /**
   * 障害者生活支援体制加算に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityHandicappedRadio(){

  }

  /**
   * 障害者生活支援体制加算モデルに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityHandicappedRadioModel(){

    getKaigoWelfareFacilityHandicappedRadioItem1().setButtonIndex(1);

    getKaigoWelfareFacilityHandicappedRadioModel().add(getKaigoWelfareFacilityHandicappedRadioItem1());

    getKaigoWelfareFacilityHandicappedRadioItem2().setButtonIndex(2);

    getKaigoWelfareFacilityHandicappedRadioModel().add(getKaigoWelfareFacilityHandicappedRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityHandicappedRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityHandicappedRadioItem2(){

  }

  /**
   * 看護体制加算コンテナに内部項目を追加します。
   */
  protected void addNurseStructuralAddGroup(){

    nurseStructuralAddGroup.add(getNurseStructuralAddCheckItem1(), VRLayout.FLOW);

    nurseStructuralAddGroup.add(getNurseStructuralAddCheckItem2(), VRLayout.FLOW);

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addNurseStructuralAddCheckItem1(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addNurseStructuralAddCheckItem2(){

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
   * 入所定員に内部項目を追加します。
   */
  protected void addStayPeopleCountRadioGroup(){

  }

  /**
   * 入所定員モデルに内部項目を追加します。
   */
  protected void addStayPeopleCountRadioGroupModel(){

    getStayPeopleCountRadioItem1().setButtonIndex(1);

    getStayPeopleCountRadioGroupModel().add(getStayPeopleCountRadioItem1());

    getStayPeopleCountRadioItem2().setButtonIndex(2);

    getStayPeopleCountRadioGroupModel().add(getStayPeopleCountRadioItem2());

  }

  /**
   * 31人以上50人以下に内部項目を追加します。
   */
  protected void addStayPeopleCountRadioItem1(){

  }

  /**
   * 30人又は51人以上に内部項目を追加します。
   */
  protected void addStayPeopleCountRadioItem2(){

  }

  /**
   * 常勤医師配置加算に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityFacilityFulltimeDoctorRadio(){

  }

  /**
   * 常勤医師配置加算モデルに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityFacilityFulltimeDoctorRadioModel(){

    getKaigoWelfareFacilityFacilityFulltimeDoctorRadioItem1().setButtonIndex(1);

    getKaigoWelfareFacilityFacilityFulltimeDoctorRadioModel().add(getKaigoWelfareFacilityFacilityFulltimeDoctorRadioItem1());

    getKaigoWelfareFacilityFacilityFulltimeDoctorRadioItem2().setButtonIndex(2);

    getKaigoWelfareFacilityFacilityFulltimeDoctorRadioModel().add(getKaigoWelfareFacilityFacilityFulltimeDoctorRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityFacilityFulltimeDoctorRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityFacilityFulltimeDoctorRadioItem2(){

  }

  /**
   * 精神科医療養指導加算に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityPsychiatristRadio(){

  }

  /**
   * 精神科医療養指導加算モデルに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityPsychiatristRadioModel(){

    getKaigoWelfareFacilityPsychiatristRadioItem1().setButtonIndex(1);

    getKaigoWelfareFacilityPsychiatristRadioModel().add(getKaigoWelfareFacilityPsychiatristRadioItem1());

    getKaigoWelfareFacilityPsychiatristRadioItem2().setButtonIndex(2);

    getKaigoWelfareFacilityPsychiatristRadioModel().add(getKaigoWelfareFacilityPsychiatristRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityPsychiatristRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityPsychiatristRadioItem2(){

  }

  /**
   * 外泊加算に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityStayingOutOvernightCostRadio(){

  }

  /**
   * 外泊加算モデルに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityStayingOutOvernightCostRadioModel(){

    getKaigoWelfareFacilityStayingOutOvernightCostRadioItem1().setButtonIndex(1);

    getKaigoWelfareFacilityStayingOutOvernightCostRadioModel().add(getKaigoWelfareFacilityStayingOutOvernightCostRadioItem1());

    getKaigoWelfareFacilityStayingOutOvernightCostRadioItem2().setButtonIndex(2);

    getKaigoWelfareFacilityStayingOutOvernightCostRadioModel().add(getKaigoWelfareFacilityStayingOutOvernightCostRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityStayingOutOvernightCostRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityStayingOutOvernightCostRadioItem2(){

  }

  /**
   * 初期加算に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityDefaultRadio(){

  }

  /**
   * 初期加算モデルに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityDefaultRadioModel(){

    getKaigoWelfareFacilityDefaultRadioItem1().setButtonIndex(1);

    getKaigoWelfareFacilityDefaultRadioModel().add(getKaigoWelfareFacilityDefaultRadioItem1());

    getKaigoWelfareFacilityDefaultRadioItem2().setButtonIndex(2);

    getKaigoWelfareFacilityDefaultRadioModel().add(getKaigoWelfareFacilityDefaultRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityDefaultRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityDefaultRadioItem2(){

  }

  /**
   * タブ3に内部項目を追加します。
   */
  protected void addTab3(){

    tab3.add(getKaigoWelfareFacilityNutritionRadioContainer(), VRLayout.FLOW_INSETLINE);

    tab3.add(getKaigoWelfareFacilityOralSwitchRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getOralMaintenanceAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getOralKeepStructureAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getOralKeepAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getKaigoWelfareFacilityRecuperateDinnerRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getKaigoWelfareFacilityHijoAddition(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 栄養マネジメント加算に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityNutritionRadio(){

  }

  /**
   * 栄養マネジメント加算モデルに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityNutritionRadioModel(){

    getKaigoWelfareFacilityNutritionRadioItem1().setButtonIndex(1);

    getKaigoWelfareFacilityNutritionRadioModel().add(getKaigoWelfareFacilityNutritionRadioItem1());

    getKaigoWelfareFacilityNutritionRadioItem2().setButtonIndex(2);

    getKaigoWelfareFacilityNutritionRadioModel().add(getKaigoWelfareFacilityNutritionRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityNutritionRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityNutritionRadioItem2(){

  }

  /**
   * 経口移行加算に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityOralSwitchRadio(){

  }

  /**
   * 経口移行加算モデルに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityOralSwitchRadioModel(){

    getKaigoWelfareFacilityOralSwitchRadioItem1().setButtonIndex(1);

    getKaigoWelfareFacilityOralSwitchRadioModel().add(getKaigoWelfareFacilityOralSwitchRadioItem1());

    getKaigoWelfareFacilityOralSwitchRadioItem2().setButtonIndex(2);

    getKaigoWelfareFacilityOralSwitchRadioModel().add(getKaigoWelfareFacilityOralSwitchRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityOralSwitchRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityOralSwitchRadioItem2(){

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
  protected void addOralKeepAddRadioGroup(){

  }

  /**
   * 口腔衛生管理加算モデルに内部項目を追加します。
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
  protected void addKaigoWelfareFacilityRecuperateDinnerRadio(){

  }

  /**
   * 療養食加算モデルに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityRecuperateDinnerRadioModel(){

    getKaigoWelfareFacilityRecuperateDinnerRadioItem1().setButtonIndex(1);

    getKaigoWelfareFacilityRecuperateDinnerRadioModel().add(getKaigoWelfareFacilityRecuperateDinnerRadioItem1());

    getKaigoWelfareFacilityRecuperateDinnerRadioItem2().setButtonIndex(2);

    getKaigoWelfareFacilityRecuperateDinnerRadioModel().add(getKaigoWelfareFacilityRecuperateDinnerRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityRecuperateDinnerRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityRecuperateDinnerRadioItem2(){

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
   * 退所関連加算に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityHijoAddition(){

    kaigoWelfareFacilityHijoAddition.add(getHijoPreConsultationAddition(), VRLayout.FLOW_RETURN);

    kaigoWelfareFacilityHijoAddition.add(getHijoAfterConsultationAddition(), VRLayout.FLOW_RETURN);

    kaigoWelfareFacilityHijoAddition.add(getHijoConsultationAddition(), VRLayout.FLOW_RETURN);

    kaigoWelfareFacilityHijoAddition.add(getHijoCooperationAddition(), VRLayout.FLOW_RETURN);

  }

  /**
   * 退所前訪問相談援助加算に内部項目を追加します。
   */
  protected void addHijoPreConsultationAddition(){

  }

  /**
   * 退所後訪問相談援助加算に内部項目を追加します。
   */
  protected void addHijoAfterConsultationAddition(){

  }

  /**
   * 退所時相談援助加算に内部項目を追加します。
   */
  protected void addHijoConsultationAddition(){

  }

  /**
   * 退所前連携加算に内部項目を追加します。
   */
  protected void addHijoCooperationAddition(){

  }

  /**
   * タブ4に内部項目を追加します。
   */
  protected void addTab4(){

    tab4.add(getKaigoWelfareFacilityStaffSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getKaigoWelfareFacilityDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    tab4.add(getKaigoWelfareFacilityBodyRestraintAbolitionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getKaigoWelfareFacilityTakingCareNursingAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getKaigoWelfareFacilityTakingCareNursingAddDaysContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 人員減算に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityStaffSubtraction(){

  }

  /**
   * 人員減算モデルに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityStaffSubtractionModel(){

    getKaigoWelfareFacilityStaffSubtractionCapacityNot().setButtonIndex(1);

    getKaigoWelfareFacilityStaffSubtractionModel().add(getKaigoWelfareFacilityStaffSubtractionCapacityNot());

    getKaigoWelfareFacilityStaffSubtractionCapacityExcess().setButtonIndex(2);

    getKaigoWelfareFacilityStaffSubtractionModel().add(getKaigoWelfareFacilityStaffSubtractionCapacityExcess());

    getKaigoWelfareFacilityStaffSubtractionPersonLack().setButtonIndex(3);

    getKaigoWelfareFacilityStaffSubtractionModel().add(getKaigoWelfareFacilityStaffSubtractionPersonLack());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityStaffSubtractionCapacityNot(){

  }

  /**
   * 定員超過に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityStaffSubtractionCapacityExcess(){

  }

  /**
   * 看護・介護職員又は介護支援専門員の不足に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityStaffSubtractionPersonLack(){

  }

  /**
   * 食事コンテナに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityDinnerContainer(){

    kaigoWelfareFacilityDinnerContainer.add(getKaigoWelfareFacilityDinnerOfferContainer(), VRLayout.FLOW);

    kaigoWelfareFacilityDinnerContainer.add(getKaigoWelfareFacilityDinnerCostContainer(), VRLayout.FLOW);

  }

  /**
   * 食事提供に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityDinnerOffer(){

  }

  /**
   * 食事提供モデルに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityDinnerOfferModel(){

  }

  /**
   * 食事費用に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityDinnerCost(){

  }

  /**
   * 身体拘束廃止未実施減算に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityBodyRestraintAbolitionRadio(){

  }

  /**
   * 身体拘束廃止未実施減算モデルに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityBodyRestraintAbolitionRadioModel(){

    getKaigoWelfareFacilityBodyRestraintAbolitionRadioItem1().setButtonIndex(1);

    getKaigoWelfareFacilityBodyRestraintAbolitionRadioModel().add(getKaigoWelfareFacilityBodyRestraintAbolitionRadioItem1());

    getKaigoWelfareFacilityBodyRestraintAbolitionRadioItem2().setButtonIndex(2);

    getKaigoWelfareFacilityBodyRestraintAbolitionRadioModel().add(getKaigoWelfareFacilityBodyRestraintAbolitionRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityBodyRestraintAbolitionRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityBodyRestraintAbolitionRadioItem2(){

  }

  /**
   * 看取り介護加算に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityTakingCareNursingAddRadio(){

  }

  /**
   * 看取り介護加算モデルに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityTakingCareNursingAddRadioModel(){

    getKaigoWelfareFacilityTakingCareNursingAddRadioItem1().setButtonIndex(1);

    getKaigoWelfareFacilityTakingCareNursingAddRadioModel().add(getKaigoWelfareFacilityTakingCareNursingAddRadioItem1());

    getKaigoWelfareFacilityTakingCareNursingAddRadioItem2().setButtonIndex(2);

    getKaigoWelfareFacilityTakingCareNursingAddRadioModel().add(getKaigoWelfareFacilityTakingCareNursingAddRadioItem2());

    getKaigoWelfareFacilityTakingCareNursingAddRadioItem3().setButtonIndex(3);

    getKaigoWelfareFacilityTakingCareNursingAddRadioModel().add(getKaigoWelfareFacilityTakingCareNursingAddRadioItem3());

    getKaigoWelfareFacilityTakingCareNursingAddRadioItem4().setButtonIndex(4);

    getKaigoWelfareFacilityTakingCareNursingAddRadioModel().add(getKaigoWelfareFacilityTakingCareNursingAddRadioItem4());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityTakingCareNursingAddRadioItem1(){

  }

  /**
   * 死亡日以前4日以上30日以下に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityTakingCareNursingAddRadioItem2(){

  }

  /**
   * 死亡日以前2日又は3日に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityTakingCareNursingAddRadioItem3(){

  }

  /**
   * 死亡日に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityTakingCareNursingAddRadioItem4(){

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
   * タブ5に内部項目を追加します。
   */
  protected void addTab5(){

    tab5.add(getKaigoWelfareFacilityStayReturnSupportAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab5.add(getKaigoWelfareFacilityHomeShareAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab5.add(getDementiaProfessionalCareAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab5.add(getDementiaEmergencyAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab5.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab5.add(getKaigoWelfareFacilityCalculationDivisionRadiloContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 在宅復帰支援機能加算に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityStayReturnSupportAddRadio(){

  }

  /**
   * 在宅復帰支援機能加算モデルに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityStayReturnSupportAddRadioModel(){

    getKaigoWelfareFacilityStayReturnSupportAddRadioItem1().setButtonIndex(1);

    getKaigoWelfareFacilityStayReturnSupportAddRadioModel().add(getKaigoWelfareFacilityStayReturnSupportAddRadioItem1());

    getKaigoWelfareFacilityStayReturnSupportAddRadioItem2().setButtonIndex(2);

    getKaigoWelfareFacilityStayReturnSupportAddRadioModel().add(getKaigoWelfareFacilityStayReturnSupportAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityStayReturnSupportAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityStayReturnSupportAddRadioItem2(){

  }

  /**
   * 在宅・入所相互利用加算に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityHomeShareAddRadio(){

  }

  /**
   * 在宅・入所相互利用加算モデルに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityHomeShareAddRadioModel(){

    getKaigoWelfareFacilityHomeShareAddRadioItem1().setButtonIndex(1);

    getKaigoWelfareFacilityHomeShareAddRadioModel().add(getKaigoWelfareFacilityHomeShareAddRadioItem1());

    getKaigoWelfareFacilityHomeShareAddRadioItem2().setButtonIndex(2);

    getKaigoWelfareFacilityHomeShareAddRadioModel().add(getKaigoWelfareFacilityHomeShareAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityHomeShareAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityHomeShareAddRadioItem2(){

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
   * 算定区分に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityCalculationDivisionRadilo(){

  }

  /**
   * 算定区分モデルに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityCalculationDivisionRadiloModel(){

    getKaigoWelfareFacilityCalculationDivisionRadiloItem1().setButtonIndex(1);

    getKaigoWelfareFacilityCalculationDivisionRadiloModel().add(getKaigoWelfareFacilityCalculationDivisionRadiloItem1());

    getKaigoWelfareFacilityCalculationDivisionRadiloItem2().setButtonIndex(2);

    getKaigoWelfareFacilityCalculationDivisionRadiloModel().add(getKaigoWelfareFacilityCalculationDivisionRadiloItem2());

  }

  /**
   * 通常に内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityCalculationDivisionRadiloItem1(){

  }

  /**
   * 加算のみに内部項目を追加します。
   */
  protected void addKaigoWelfareFacilityCalculationDivisionRadiloItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_15111_201504Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001_15111_201504Design getThis() {
    return this;
  }
}
