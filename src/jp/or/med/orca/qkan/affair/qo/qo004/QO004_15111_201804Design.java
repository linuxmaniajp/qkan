
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
 * 開発者: 日高　しのぶ
 * 作成日: 2018/02/19  日本コンピューター株式会社 日高　しのぶ 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業者登録 (004)
 * プログラム 介護福祉施設サービス (QO004_15111_201804)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;
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
 * 介護福祉施設サービス画面項目デザイン(QO004_15111_201804) 
 */
public class QO004_15111_201804Design extends QO004ProviderPanel {
  //GUIコンポーネント

  private ACGroupBox mainGroup;

  private JTabbedPane tab;

  private ACPanel panel1;

  private ACPanel calculationDetails1;

  private ACValueArrayRadioButtonGroup facilitiesDivision;

  private ACLabelContainer facilitiesDivisionContainer;

  private ACListModelAdapter facilitiesDivisionModel;

  private ACRadioButtonItem facilitiesDivisionItem1;

  private ACRadioButtonItem facilitiesDivisionItem2;

  private ACRadioButtonItem facilitiesDivisionItem3;

  private ACRadioButtonItem facilitiesDivisionItem4;

  private ACValueArrayRadioButtonGroup nightWorkDivision;

  private ACLabelContainer nightWorkDivisionContainer;

  private ACListModelAdapter nightWorkDivisionModel;

  private ACRadioButtonItem nightWorkDivisionItem1;

  private ACRadioButtonItem nightWorkDivisionItem2;

  private ACValueArrayRadioButtonGroup staffLack;

  private ACLabelContainer staffLackContainer;

  private ACListModelAdapter staffLackModel;

  private ACRadioButtonItem staffLackItem1;

  private ACRadioButtonItem staffLackItem2;

  private ACRadioButtonItem staffLackItem3;

  private ACRadioButtonItem staffLackItem4;

  private ACValueArrayRadioButtonGroup unitCareMaintenance;

  private ACLabelContainer unitCareMaintenanceContainer;

  private ACListModelAdapter unitCareMaintenanceModel;

  private ACRadioButtonItem unitCareMaintenanceItem1;

  private ACRadioButtonItem unitCareMaintenanceItem2;

  private ACValueArrayRadioButtonGroup bodyRestraintAbolition;

  private ACLabelContainer bodyRestraintAbolitionContainer;

  private ACListModelAdapter bodyRestraintAbolitionModel;

  private ACRadioButtonItem bodyRestraintAbolitionItem1;

  private ACRadioButtonItem bodyRestraintAbolitionItem2;

  private ACValueArrayRadioButtonGroup dailyLifeContinuanceRadioGroup;

  private ACLabelContainer dailyLifeContinuanceRadioGroupContainer;

  private ACListModelAdapter dailyLifeContinuanceRadioGroupModel;

  private ACRadioButtonItem dailyLifeContinuanceRadioItem1;

  private ACRadioButtonItem dailyLifeContinuanceRadioItem2;

  private ACValueArrayRadioButtonGroup nurseStructuralAddRadioGroup;

  private ACLabelContainer nurseStructuralAddRadioGroupContainer;

  private ACListModelAdapter nurseStructuralAddRadioGroupModel;

  private ACRadioButtonItem nurseStructuralAddRadioItem1;

  private ACRadioButtonItem nurseStructuralAddRadioItem2;

  private ACValueArrayRadioButtonGroup nurseStructuralAddRadio2Group;

  private ACLabelContainer nurseStructuralAddRadio2GroupContainer;

  private ACListModelAdapter nurseStructuralAddRadio2GroupModel;

  private ACRadioButtonItem nurseStructuralAddRadio2Item1;

  private ACRadioButtonItem nurseStructuralAddRadio2Item2;

  private ACValueArrayRadioButtonGroup nightStaffDispositionAddRadioGroup;

  private ACLabelContainer nightStaffDispositionAddRadioGroupContainer;

  private ACListModelAdapter nightStaffDispositionAddRadioGroupModel;

  private ACRadioButtonItem nightStaffDispositionAddRadioItem1;

  private ACRadioButtonItem nightStaffDispositionAddRadioItem2;

  private ACRadioButtonItem nightStaffDispositionAddRadioItem3;

  private ACValueArrayRadioButtonGroup kaigoRobotRadioGroup;

  private ACLabelContainer kaigoRobotRadioGroupContainer;

  private ACListModelAdapter kaigoRobotRadioGroupModel;

  private ACRadioButtonItem kaigoRobotRadioItem1;

  private ACRadioButtonItem kaigoRobotRadioItem2;

  private ACValueArrayRadioButtonGroup semiUnitCareMaintenance;

  private ACLabelContainer semiUnitCareMaintenanceContainer;

  private ACListModelAdapter semiUnitCareMaintenanceModel;

  private ACRadioButtonItem semiUnitCareMaintenanceItem1;

  private ACRadioButtonItem semiUnitCareMaintenanceItem2;

  private ACValueArrayRadioButtonGroup seikatsuKinouGroup;

  private ACLabelContainer seikatsuKinouGroupContainer;

  private ACListModelAdapter seikatsuKinouGroupModel;

  private ACRadioButtonItem seikatsuKinouGroupItem1;

  private ACRadioButtonItem seikatsuKinouGroupItem2;

  private ACValueArrayRadioButtonGroup functionTrainingGuidanceSystem;

  private ACLabelContainer functionTrainingGuidanceSystemContainer;

  private ACListModelAdapter functionTrainingGuidanceSystemModel;

  private ACRadioButtonItem functionTrainingGuidanceSystemItem1;

  private ACRadioButtonItem functionTrainingGuidanceSystemItem3;

  private ACPanel panel2;

  private ACPanel calculationDetails2;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACValueArrayRadioButtonGroup standingDoctorAssignment;

  private ACLabelContainer standingDoctorAssignmentContainer;

  private ACListModelAdapter standingDoctorAssignmentModel;

  private ACRadioButtonItem standingDoctorAssignmentItem1;

  private ACRadioButtonItem standingDoctorAssignmentItem2;

  private ACValueArrayRadioButtonGroup psychiatristGuidance;

  private ACLabelContainer psychiatristGuidanceContainer;

  private ACListModelAdapter psychiatristGuidanceModel;

  private ACRadioButtonItem psychiatristGuidanceItem1;

  private ACRadioButtonItem psychiatristGuidanceItem2;

  private ACValueArrayRadioButtonGroup handicappedPersonSupport;

  private ACLabelContainer handicappedPersonSupportContainer;

  private ACListModelAdapter handicappedPersonSupportModel;

  private ACRadioButtonItem handicappedPersonSupportItem1;

  private ACRadioButtonItem handicappedPersonSupportItem2;

  private ACRadioButtonItem handicappedPersonSupportItem3;

  private ACValueArrayRadioButtonGroup nourishmentImprovement;

  private ACLabelContainer nourishmentImprovementContainer;

  private ACListModelAdapter nourishmentImprovementModel;

  private ACRadioButtonItem nourishmentImprovementAddItem1;

  private ACRadioButtonItem nourishmentImprovementAddItem2;

  private ACValueArrayRadioButtonGroup medicalFoodAddRadioGroup;

  private ACLabelContainer medicalFoodAddRadioGroupContainer;

  private ACListModelAdapter medicalFoodAddRadioGroupModel;

  private ACRadioButtonItem medicalFoodAddRadioItem1;

  private ACRadioButtonItem medicalFoodAddRadioItem2;

  private ACValueArrayRadioButtonGroup placementDoctorEmergency;

  private ACLabelContainer placementDoctorEmergencyContainer;

  private ACListModelAdapter placementDoctorEmergencyModel;

  private ACRadioButtonItem placementDoctorEmergencyItem1;

  private ACRadioButtonItem placementDoctorEmergencyItem2;

  private ACValueArrayRadioButtonGroup terminalCare;

  private ACLabelContainer terminalCareContainer;

  private ACListModelAdapter terminalCareModel;

  private ACRadioButtonItem terminalCareItem1;

  private ACRadioButtonItem terminalCareItem2;

  private ACRadioButtonItem terminalCareItem3;

  private ACValueArrayRadioButtonGroup homeAndFacility;

  private ACLabelContainer homeAndFacilityContainer;

  private ACListModelAdapter homeAndFacilityModel;

  private ACRadioButtonItem homeAndFacilityItem1;

  private ACRadioButtonItem homeAndFacilityItem2;

  private ACValueArrayRadioButtonGroup dementiaProfessionalCareAddRadioGroup;

  private ACLabelContainer dementiaProfessionalCareAddRadioGroupContainer;

  private ACListModelAdapter dementiaProfessionalCareAddRadioGroupModel;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem1;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem2;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem3;

  private ACValueArrayRadioButtonGroup pressureUlcerManagement;

  private ACLabelContainer pressureUlcerManagementContainer;

  private ACListModelAdapter pressureUlcerManagementModel;

  private ACRadioButtonItem pressureUlcerManagementItem1;

  private ACRadioButtonItem pressureUlcerManagementItem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem5;

  private ACValueArrayRadioButtonGroup staffUpgradeRadioGroup;

  private ACLabelContainer staffUpgradeRadioGroupContainer;

  private ACListModelAdapter staffUpgradeRadioGroupModel;

  private ACRadioButtonItem staffUpgradeRadioItem1;

  private ACRadioButtonItem staffUpgradeRadioItem2;

  private ACRadioButtonItem staffUpgradeRadioItem3;

  private ACRadioButtonItem staffUpgradeRadioItem4;

  private ACRadioButtonItem staffUpgradeRadioItem5;

  private ACRadioButtonItem staffUpgradeRadioItem6;

  private ACPanel calculationDetails3;

  private ACLabelContainer reduceRateContainer;

  private ACTextField reduceRate;

  private ACLabel percentSign;

  private ACIntegerCheckBox ShahukuReduce;

  private ACPanel panel3;

  private ACGroupBox standardMoneyGroup;

  private ACLabelContainer dinnerContainer;

  private ACTextField dinnerTotal;

  private ACBackLabelContainer dinnerDetailsContainer;

  private ACLabel dinnerMorningLabel;

  private ACTextField dinnerMorning;

  private ACLabel dinnerNoonLabel;

  private ACTextField dinnerNoon;

  private ACLabel dinnerNightLabel;

  private ACTextField dinnerNight;

  private ACLabel dinnerDenomination;

  private ACLabelContainer unitRoomContainer;

  private ACTextField unitRoom;

  private ACLabel unitRoomLabel;

  private ACLabelContainer unitSemiRoomContainer;

  private ACTextField unitSemiRoom;

  private ACLabel unitSemiRoomLabel;

  private ACLabelContainer normalRoomContainer;

  private ACTextField normalRoom;

  private ACLabel normalRoomLabel;

  private ACLabelContainer tasyouRoomContainer;

  private ACTextField tasyouRoom;

  private ACLabel tasyouRoomLabel;

  //getter

  /**
   * 事業グループを取得します。
   * @return 事業グループ
   */
  public ACGroupBox getMainGroup(){
    if(mainGroup==null){

      mainGroup = new ACGroupBox();

      mainGroup.setText("介護福祉施設サービス");

      mainGroup.setFollowChildEnabled(true);

      mainGroup.setHgrid(200);

      addMainGroup();
    }
    return mainGroup;

  }

  /**
   * タブを取得します。
   * @return タブ
   */
  public JTabbedPane getTab(){
    if(tab==null){

      tab = new JTabbedPane();

      addTab();
    }
    return tab;

  }

  /**
   * パネル1を取得します。
   * @return パネル1
   */
  public ACPanel getPanel1(){
    if(panel1==null){

      panel1 = new ACPanel();

      panel1.setFollowChildEnabled(true);

      panel1.setHgrid(200);

      addPanel1();
    }
    return panel1;

  }

  /**
   * 算定項目領域1を取得します。
   * @return 算定項目領域1
   */
  public ACPanel getCalculationDetails1(){
    if(calculationDetails1==null){

      calculationDetails1 = new ACPanel();

      calculationDetails1.setFollowChildEnabled(true);

      calculationDetails1.setHgrid(300);

      addCalculationDetails1();
    }
    return calculationDetails1;

  }

  /**
   * 施設区分ラジオグループを取得します。
   * @return 施設区分ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getFacilitiesDivision(){
    if(facilitiesDivision==null){

      facilitiesDivision = new ACValueArrayRadioButtonGroup();

      getFacilitiesDivisionContainer().setText("施設等の区分");

      facilitiesDivision.setBindPath("1510101");

      facilitiesDivision.setUseClearButton(false);

      facilitiesDivision.setModel(getFacilitiesDivisionModel());

      facilitiesDivision.setValues(new int[]{1,2,3,4});

      addFacilitiesDivision();
    }
    return facilitiesDivision;

  }

  /**
   * 施設区分ラジオグループコンテナを取得します。
   * @return 施設区分ラジオグループコンテナ
   */
  protected ACLabelContainer getFacilitiesDivisionContainer(){
    if(facilitiesDivisionContainer==null){
      facilitiesDivisionContainer = new ACLabelContainer();
      facilitiesDivisionContainer.setFollowChildEnabled(true);
      facilitiesDivisionContainer.setVAlignment(VRLayout.CENTER);
      facilitiesDivisionContainer.add(getFacilitiesDivision(), null);
    }
    return facilitiesDivisionContainer;
  }

  /**
   * 施設区分ラジオグループモデルを取得します。
   * @return 施設区分ラジオグループモデル
   */
  protected ACListModelAdapter getFacilitiesDivisionModel(){
    if(facilitiesDivisionModel==null){
      facilitiesDivisionModel = new ACListModelAdapter();
      addFacilitiesDivisionModel();
    }
    return facilitiesDivisionModel;
  }

  /**
   * 介護福祉施設を取得します。
   * @return 介護福祉施設
   */
  public ACRadioButtonItem getFacilitiesDivisionItem1(){
    if(facilitiesDivisionItem1==null){

      facilitiesDivisionItem1 = new ACRadioButtonItem();

      facilitiesDivisionItem1.setText("介護福祉施設");

      facilitiesDivisionItem1.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem1.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem1();
    }
    return facilitiesDivisionItem1;

  }

  /**
   * 経過的小規模介護福祉施設を取得します。
   * @return 経過的小規模介護福祉施設
   */
  public ACRadioButtonItem getFacilitiesDivisionItem2(){
    if(facilitiesDivisionItem2==null){

      facilitiesDivisionItem2 = new ACRadioButtonItem();

      facilitiesDivisionItem2.setText("経過的小規模介護福祉施設");

      facilitiesDivisionItem2.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem2.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem2();
    }
    return facilitiesDivisionItem2;

  }

  /**
   * ユニット型介護福祉施設を取得します。
   * @return ユニット型介護福祉施設
   */
  public ACRadioButtonItem getFacilitiesDivisionItem3(){
    if(facilitiesDivisionItem3==null){

      facilitiesDivisionItem3 = new ACRadioButtonItem();

      facilitiesDivisionItem3.setText("ユニット型介護福祉施設");

      facilitiesDivisionItem3.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem3.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem3();
    }
    return facilitiesDivisionItem3;

  }

  /**
   * ユニット型経過的小規模介護福祉施設を取得します。
   * @return ユニット型経過的小規模介護福祉施設
   */
  public ACRadioButtonItem getFacilitiesDivisionItem4(){
    if(facilitiesDivisionItem4==null){

      facilitiesDivisionItem4 = new ACRadioButtonItem();

      facilitiesDivisionItem4.setText("ユニット型経過的小規模介護福祉施設");

      facilitiesDivisionItem4.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem4.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem4();
    }
    return facilitiesDivisionItem4;

  }

  /**
   * 夜間勤務条件基準ラジオグループを取得します。
   * @return 夜間勤務条件基準ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getNightWorkDivision(){
    if(nightWorkDivision==null){

      nightWorkDivision = new ACValueArrayRadioButtonGroup();

      getNightWorkDivisionContainer().setText("夜間勤務条件基準");

      nightWorkDivision.setBindPath("1510102");

      nightWorkDivision.setUseClearButton(false);

      nightWorkDivision.setModel(getNightWorkDivisionModel());

      nightWorkDivision.setValues(new int[]{1,2});

      addNightWorkDivision();
    }
    return nightWorkDivision;

  }

  /**
   * 夜間勤務条件基準ラジオグループコンテナを取得します。
   * @return 夜間勤務条件基準ラジオグループコンテナ
   */
  protected ACLabelContainer getNightWorkDivisionContainer(){
    if(nightWorkDivisionContainer==null){
      nightWorkDivisionContainer = new ACLabelContainer();
      nightWorkDivisionContainer.setFollowChildEnabled(true);
      nightWorkDivisionContainer.setVAlignment(VRLayout.CENTER);
      nightWorkDivisionContainer.add(getNightWorkDivision(), null);
    }
    return nightWorkDivisionContainer;
  }

  /**
   * 夜間勤務条件基準ラジオグループモデルを取得します。
   * @return 夜間勤務条件基準ラジオグループモデル
   */
  protected ACListModelAdapter getNightWorkDivisionModel(){
    if(nightWorkDivisionModel==null){
      nightWorkDivisionModel = new ACListModelAdapter();
      addNightWorkDivisionModel();
    }
    return nightWorkDivisionModel;
  }

  /**
   * 基準型を取得します。
   * @return 基準型
   */
  public ACRadioButtonItem getNightWorkDivisionItem1(){
    if(nightWorkDivisionItem1==null){

      nightWorkDivisionItem1 = new ACRadioButtonItem();

      nightWorkDivisionItem1.setText("基準型");

      nightWorkDivisionItem1.setGroup(getNightWorkDivision());

      addNightWorkDivisionItem1();
    }
    return nightWorkDivisionItem1;

  }

  /**
   * 減算型を取得します。
   * @return 減算型
   */
  public ACRadioButtonItem getNightWorkDivisionItem2(){
    if(nightWorkDivisionItem2==null){

      nightWorkDivisionItem2 = new ACRadioButtonItem();

      nightWorkDivisionItem2.setText("減算型");

      nightWorkDivisionItem2.setGroup(getNightWorkDivision());

      addNightWorkDivisionItem2();
    }
    return nightWorkDivisionItem2;

  }

  /**
   * 職員の欠員による減算の状況ラジオグループを取得します。
   * @return 職員の欠員による減算の状況ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getStaffLack(){
    if(staffLack==null){

      staffLack = new ACValueArrayRadioButtonGroup();

      getStaffLackContainer().setText("職員の欠員による減算の状況");

      staffLack.setBindPath("1510112");

      staffLack.setUseClearButton(false);

      staffLack.setModel(getStaffLackModel());

      staffLack.setValues(new int[]{1,2,3,4});

      addStaffLack();
    }
    return staffLack;

  }

  /**
   * 職員の欠員による減算の状況ラジオグループコンテナを取得します。
   * @return 職員の欠員による減算の状況ラジオグループコンテナ
   */
  protected ACLabelContainer getStaffLackContainer(){
    if(staffLackContainer==null){
      staffLackContainer = new ACLabelContainer();
      staffLackContainer.setFollowChildEnabled(true);
      staffLackContainer.setVAlignment(VRLayout.CENTER);
      staffLackContainer.add(getStaffLack(), null);
    }
    return staffLackContainer;
  }

  /**
   * 職員の欠員による減算の状況ラジオグループモデルを取得します。
   * @return 職員の欠員による減算の状況ラジオグループモデル
   */
  protected ACListModelAdapter getStaffLackModel(){
    if(staffLackModel==null){
      staffLackModel = new ACListModelAdapter();
      addStaffLackModel();
    }
    return staffLackModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getStaffLackItem1(){
    if(staffLackItem1==null){

      staffLackItem1 = new ACRadioButtonItem();

      staffLackItem1.setText("なし");

      staffLackItem1.setGroup(getStaffLack());

      staffLackItem1.setConstraints(VRLayout.FLOW);

      addStaffLackItem1();
    }
    return staffLackItem1;

  }

  /**
   * 看護職員を取得します。
   * @return 看護職員
   */
  public ACRadioButtonItem getStaffLackItem2(){
    if(staffLackItem2==null){

      staffLackItem2 = new ACRadioButtonItem();

      staffLackItem2.setText("看護職員");

      staffLackItem2.setGroup(getStaffLack());

      staffLackItem2.setConstraints(VRLayout.FLOW_RETURN);

      addStaffLackItem2();
    }
    return staffLackItem2;

  }

  /**
   * 介護職員を取得します。
   * @return 介護職員
   */
  public ACRadioButtonItem getStaffLackItem3(){
    if(staffLackItem3==null){

      staffLackItem3 = new ACRadioButtonItem();

      staffLackItem3.setText("介護職員");

      staffLackItem3.setGroup(getStaffLack());

      staffLackItem3.setConstraints(VRLayout.FLOW);

      addStaffLackItem3();
    }
    return staffLackItem3;

  }

  /**
   * 介護支援専門員を取得します。
   * @return 介護支援専門員
   */
  public ACRadioButtonItem getStaffLackItem4(){
    if(staffLackItem4==null){

      staffLackItem4 = new ACRadioButtonItem();

      staffLackItem4.setText("介護支援専門員");

      staffLackItem4.setGroup(getStaffLack());

      staffLackItem4.setConstraints(VRLayout.FLOW);

      addStaffLackItem4();
    }
    return staffLackItem4;

  }

  /**
   * ユニットケア体制を取得します。
   * @return ユニットケア体制
   */
  public ACValueArrayRadioButtonGroup getUnitCareMaintenance(){
    if(unitCareMaintenance==null){

      unitCareMaintenance = new ACValueArrayRadioButtonGroup();

      getUnitCareMaintenanceContainer().setText("ユニットケア体制");

      unitCareMaintenance.setBindPath("1510121");

      unitCareMaintenance.setUseClearButton(false);

      unitCareMaintenance.setModel(getUnitCareMaintenanceModel());

      unitCareMaintenance.setValues(new int[]{1,2});

      addUnitCareMaintenance();
    }
    return unitCareMaintenance;

  }

  /**
   * ユニットケア体制コンテナを取得します。
   * @return ユニットケア体制コンテナ
   */
  protected ACLabelContainer getUnitCareMaintenanceContainer(){
    if(unitCareMaintenanceContainer==null){
      unitCareMaintenanceContainer = new ACLabelContainer();
      unitCareMaintenanceContainer.setFollowChildEnabled(true);
      unitCareMaintenanceContainer.setVAlignment(VRLayout.CENTER);
      unitCareMaintenanceContainer.add(getUnitCareMaintenance(), null);
    }
    return unitCareMaintenanceContainer;
  }

  /**
   * ユニットケア体制モデルを取得します。
   * @return ユニットケア体制モデル
   */
  protected ACListModelAdapter getUnitCareMaintenanceModel(){
    if(unitCareMaintenanceModel==null){
      unitCareMaintenanceModel = new ACListModelAdapter();
      addUnitCareMaintenanceModel();
    }
    return unitCareMaintenanceModel;
  }

  /**
   * 対応不可を取得します。
   * @return 対応不可
   */
  public ACRadioButtonItem getUnitCareMaintenanceItem1(){
    if(unitCareMaintenanceItem1==null){

      unitCareMaintenanceItem1 = new ACRadioButtonItem();

      unitCareMaintenanceItem1.setText("対応不可");

      unitCareMaintenanceItem1.setGroup(getUnitCareMaintenance());

      unitCareMaintenanceItem1.setConstraints(VRLayout.FLOW);

      addUnitCareMaintenanceItem1();
    }
    return unitCareMaintenanceItem1;

  }

  /**
   * 対応可を取得します。
   * @return 対応可
   */
  public ACRadioButtonItem getUnitCareMaintenanceItem2(){
    if(unitCareMaintenanceItem2==null){

      unitCareMaintenanceItem2 = new ACRadioButtonItem();

      unitCareMaintenanceItem2.setText("対応可");

      unitCareMaintenanceItem2.setGroup(getUnitCareMaintenance());

      unitCareMaintenanceItem2.setConstraints(VRLayout.FLOW);

      addUnitCareMaintenanceItem2();
    }
    return unitCareMaintenanceItem2;

  }

  /**
   * 身体拘束廃止取組の有無を取得します。
   * @return 身体拘束廃止取組の有無
   */
  public ACValueArrayRadioButtonGroup getBodyRestraintAbolition(){
    if(bodyRestraintAbolition==null){

      bodyRestraintAbolition = new ACValueArrayRadioButtonGroup();

      getBodyRestraintAbolitionContainer().setText("身体拘束廃止取組の有無");

      bodyRestraintAbolition.setBindPath("1510124");

      bodyRestraintAbolition.setUseClearButton(false);

      bodyRestraintAbolition.setModel(getBodyRestraintAbolitionModel());

      bodyRestraintAbolition.setValues(new int[]{1,2});

      addBodyRestraintAbolition();
    }
    return bodyRestraintAbolition;

  }

  /**
   * 身体拘束廃止取組の有無コンテナを取得します。
   * @return 身体拘束廃止取組の有無コンテナ
   */
  protected ACLabelContainer getBodyRestraintAbolitionContainer(){
    if(bodyRestraintAbolitionContainer==null){
      bodyRestraintAbolitionContainer = new ACLabelContainer();
      bodyRestraintAbolitionContainer.setFollowChildEnabled(true);
      bodyRestraintAbolitionContainer.setVAlignment(VRLayout.CENTER);
      bodyRestraintAbolitionContainer.add(getBodyRestraintAbolition(), null);
    }
    return bodyRestraintAbolitionContainer;
  }

  /**
   * 身体拘束廃止取組の有無モデルを取得します。
   * @return 身体拘束廃止取組の有無モデル
   */
  protected ACListModelAdapter getBodyRestraintAbolitionModel(){
    if(bodyRestraintAbolitionModel==null){
      bodyRestraintAbolitionModel = new ACListModelAdapter();
      addBodyRestraintAbolitionModel();
    }
    return bodyRestraintAbolitionModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getBodyRestraintAbolitionItem1(){
    if(bodyRestraintAbolitionItem1==null){

      bodyRestraintAbolitionItem1 = new ACRadioButtonItem();

      bodyRestraintAbolitionItem1.setText("なし");

      bodyRestraintAbolitionItem1.setGroup(getBodyRestraintAbolition());

      bodyRestraintAbolitionItem1.setConstraints(VRLayout.FLOW);

      addBodyRestraintAbolitionItem1();
    }
    return bodyRestraintAbolitionItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getBodyRestraintAbolitionItem2(){
    if(bodyRestraintAbolitionItem2==null){

      bodyRestraintAbolitionItem2 = new ACRadioButtonItem();

      bodyRestraintAbolitionItem2.setText("あり");

      bodyRestraintAbolitionItem2.setGroup(getBodyRestraintAbolition());

      bodyRestraintAbolitionItem2.setConstraints(VRLayout.FLOW);

      addBodyRestraintAbolitionItem2();
    }
    return bodyRestraintAbolitionItem2;

  }

  /**
   * 日常生活継続支援加算を取得します。
   * @return 日常生活継続支援加算
   */
  public ACValueArrayRadioButtonGroup getDailyLifeContinuanceRadioGroup(){
    if(dailyLifeContinuanceRadioGroup==null){

      dailyLifeContinuanceRadioGroup = new ACValueArrayRadioButtonGroup();

      getDailyLifeContinuanceRadioGroupContainer().setText("日常生活継続支援加算");

      dailyLifeContinuanceRadioGroup.setBindPath("1510127");

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
   * 看護体制加算Iを取得します。
   * @return 看護体制加算I
   */
  public ACValueArrayRadioButtonGroup getNurseStructuralAddRadioGroup(){
    if(nurseStructuralAddRadioGroup==null){

      nurseStructuralAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getNurseStructuralAddRadioGroupContainer().setText("看護体制加算I");

      nurseStructuralAddRadioGroup.setBindPath("1510128");

      nurseStructuralAddRadioGroup.setNoSelectIndex(0);

      nurseStructuralAddRadioGroup.setUseClearButton(false);

      nurseStructuralAddRadioGroup.setModel(getNurseStructuralAddRadioGroupModel());

      nurseStructuralAddRadioGroup.setValues(new int[]{1,2});

      addNurseStructuralAddRadioGroup();
    }
    return nurseStructuralAddRadioGroup;

  }

  /**
   * 看護体制加算Iコンテナを取得します。
   * @return 看護体制加算Iコンテナ
   */
  protected ACLabelContainer getNurseStructuralAddRadioGroupContainer(){
    if(nurseStructuralAddRadioGroupContainer==null){
      nurseStructuralAddRadioGroupContainer = new ACLabelContainer();
      nurseStructuralAddRadioGroupContainer.setFollowChildEnabled(true);
      nurseStructuralAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      nurseStructuralAddRadioGroupContainer.add(getNurseStructuralAddRadioGroup(), null);
    }
    return nurseStructuralAddRadioGroupContainer;
  }

  /**
   * 看護体制加算Iモデルを取得します。
   * @return 看護体制加算Iモデル
   */
  protected ACListModelAdapter getNurseStructuralAddRadioGroupModel(){
    if(nurseStructuralAddRadioGroupModel==null){
      nurseStructuralAddRadioGroupModel = new ACListModelAdapter();
      addNurseStructuralAddRadioGroupModel();
    }
    return nurseStructuralAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getNurseStructuralAddRadioItem1(){
    if(nurseStructuralAddRadioItem1==null){

      nurseStructuralAddRadioItem1 = new ACRadioButtonItem();

      nurseStructuralAddRadioItem1.setText("なし");

      nurseStructuralAddRadioItem1.setGroup(getNurseStructuralAddRadioGroup());

      nurseStructuralAddRadioItem1.setConstraints(VRLayout.FLOW);

      addNurseStructuralAddRadioItem1();
    }
    return nurseStructuralAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getNurseStructuralAddRadioItem2(){
    if(nurseStructuralAddRadioItem2==null){

      nurseStructuralAddRadioItem2 = new ACRadioButtonItem();

      nurseStructuralAddRadioItem2.setText("あり");

      nurseStructuralAddRadioItem2.setGroup(getNurseStructuralAddRadioGroup());

      nurseStructuralAddRadioItem2.setConstraints(VRLayout.FLOW);

      addNurseStructuralAddRadioItem2();
    }
    return nurseStructuralAddRadioItem2;

  }

  /**
   * 看護体制加算IIを取得します。
   * @return 看護体制加算II
   */
  public ACValueArrayRadioButtonGroup getNurseStructuralAddRadio2Group(){
    if(nurseStructuralAddRadio2Group==null){

      nurseStructuralAddRadio2Group = new ACValueArrayRadioButtonGroup();

      getNurseStructuralAddRadio2GroupContainer().setText("看護体制加算II");

      nurseStructuralAddRadio2Group.setBindPath("1510138");

      nurseStructuralAddRadio2Group.setNoSelectIndex(0);

      nurseStructuralAddRadio2Group.setUseClearButton(false);

      nurseStructuralAddRadio2Group.setModel(getNurseStructuralAddRadio2GroupModel());

      nurseStructuralAddRadio2Group.setValues(new int[]{1,2});

      addNurseStructuralAddRadio2Group();
    }
    return nurseStructuralAddRadio2Group;

  }

  /**
   * 看護体制加算IIコンテナを取得します。
   * @return 看護体制加算IIコンテナ
   */
  protected ACLabelContainer getNurseStructuralAddRadio2GroupContainer(){
    if(nurseStructuralAddRadio2GroupContainer==null){
      nurseStructuralAddRadio2GroupContainer = new ACLabelContainer();
      nurseStructuralAddRadio2GroupContainer.setFollowChildEnabled(true);
      nurseStructuralAddRadio2GroupContainer.setVAlignment(VRLayout.CENTER);
      nurseStructuralAddRadio2GroupContainer.add(getNurseStructuralAddRadio2Group(), null);
    }
    return nurseStructuralAddRadio2GroupContainer;
  }

  /**
   * 看護体制加算IIモデルを取得します。
   * @return 看護体制加算IIモデル
   */
  protected ACListModelAdapter getNurseStructuralAddRadio2GroupModel(){
    if(nurseStructuralAddRadio2GroupModel==null){
      nurseStructuralAddRadio2GroupModel = new ACListModelAdapter();
      addNurseStructuralAddRadio2GroupModel();
    }
    return nurseStructuralAddRadio2GroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getNurseStructuralAddRadio2Item1(){
    if(nurseStructuralAddRadio2Item1==null){

      nurseStructuralAddRadio2Item1 = new ACRadioButtonItem();

      nurseStructuralAddRadio2Item1.setText("なし");

      nurseStructuralAddRadio2Item1.setGroup(getNurseStructuralAddRadio2Group());

      nurseStructuralAddRadio2Item1.setConstraints(VRLayout.FLOW);

      addNurseStructuralAddRadio2Item1();
    }
    return nurseStructuralAddRadio2Item1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getNurseStructuralAddRadio2Item2(){
    if(nurseStructuralAddRadio2Item2==null){

      nurseStructuralAddRadio2Item2 = new ACRadioButtonItem();

      nurseStructuralAddRadio2Item2.setText("あり");

      nurseStructuralAddRadio2Item2.setGroup(getNurseStructuralAddRadio2Group());

      nurseStructuralAddRadio2Item2.setConstraints(VRLayout.FLOW);

      addNurseStructuralAddRadio2Item2();
    }
    return nurseStructuralAddRadio2Item2;

  }

  /**
   * 夜勤職員配置加算を取得します。
   * @return 夜勤職員配置加算
   */
  public ACValueArrayRadioButtonGroup getNightStaffDispositionAddRadioGroup(){
    if(nightStaffDispositionAddRadioGroup==null){

      nightStaffDispositionAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getNightStaffDispositionAddRadioGroupContainer().setText("夜勤職員配置加算");

      nightStaffDispositionAddRadioGroup.setBindPath("1510129");

      nightStaffDispositionAddRadioGroup.setNoSelectIndex(0);

      nightStaffDispositionAddRadioGroup.setUseClearButton(false);

      nightStaffDispositionAddRadioGroup.setModel(getNightStaffDispositionAddRadioGroupModel());

      nightStaffDispositionAddRadioGroup.setValues(new int[]{1,2,3});

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
   * 加算I・加算IIを取得します。
   * @return 加算I・加算II
   */
  public ACRadioButtonItem getNightStaffDispositionAddRadioItem2(){
    if(nightStaffDispositionAddRadioItem2==null){

      nightStaffDispositionAddRadioItem2 = new ACRadioButtonItem();

      nightStaffDispositionAddRadioItem2.setText("加算I・加算II");

      nightStaffDispositionAddRadioItem2.setGroup(getNightStaffDispositionAddRadioGroup());

      nightStaffDispositionAddRadioItem2.setConstraints(VRLayout.FLOW);

      addNightStaffDispositionAddRadioItem2();
    }
    return nightStaffDispositionAddRadioItem2;

  }

  /**
   * 加算III・加算IVを取得します。
   * @return 加算III・加算IV
   */
  public ACRadioButtonItem getNightStaffDispositionAddRadioItem3(){
    if(nightStaffDispositionAddRadioItem3==null){

      nightStaffDispositionAddRadioItem3 = new ACRadioButtonItem();

      nightStaffDispositionAddRadioItem3.setText("加算III・加算IV");

      nightStaffDispositionAddRadioItem3.setGroup(getNightStaffDispositionAddRadioGroup());

      nightStaffDispositionAddRadioItem3.setConstraints(VRLayout.FLOW);

      addNightStaffDispositionAddRadioItem3();
    }
    return nightStaffDispositionAddRadioItem3;

  }

  /**
   * 介護ロボットの導入を取得します。
   * @return 介護ロボットの導入
   */
  public ACValueArrayRadioButtonGroup getKaigoRobotRadioGroup(){
    if(kaigoRobotRadioGroup==null){

      kaigoRobotRadioGroup = new ACValueArrayRadioButtonGroup();

      getKaigoRobotRadioGroupContainer().setText("介護ロボットの導入");

      kaigoRobotRadioGroup.setBindPath("1510135");

      kaigoRobotRadioGroup.setNoSelectIndex(0);

      kaigoRobotRadioGroup.setUseClearButton(false);

      kaigoRobotRadioGroup.setModel(getKaigoRobotRadioGroupModel());

      kaigoRobotRadioGroup.setValues(new int[]{1,2});

      addKaigoRobotRadioGroup();
    }
    return kaigoRobotRadioGroup;

  }

  /**
   * 介護ロボットの導入コンテナを取得します。
   * @return 介護ロボットの導入コンテナ
   */
  protected ACLabelContainer getKaigoRobotRadioGroupContainer(){
    if(kaigoRobotRadioGroupContainer==null){
      kaigoRobotRadioGroupContainer = new ACLabelContainer();
      kaigoRobotRadioGroupContainer.setFollowChildEnabled(true);
      kaigoRobotRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      kaigoRobotRadioGroupContainer.add(getKaigoRobotRadioGroup(), null);
    }
    return kaigoRobotRadioGroupContainer;
  }

  /**
   * 介護ロボットの導入モデルを取得します。
   * @return 介護ロボットの導入モデル
   */
  protected ACListModelAdapter getKaigoRobotRadioGroupModel(){
    if(kaigoRobotRadioGroupModel==null){
      kaigoRobotRadioGroupModel = new ACListModelAdapter();
      addKaigoRobotRadioGroupModel();
    }
    return kaigoRobotRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKaigoRobotRadioItem1(){
    if(kaigoRobotRadioItem1==null){

      kaigoRobotRadioItem1 = new ACRadioButtonItem();

      kaigoRobotRadioItem1.setText("なし");

      kaigoRobotRadioItem1.setGroup(getKaigoRobotRadioGroup());

      kaigoRobotRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoRobotRadioItem1();
    }
    return kaigoRobotRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getKaigoRobotRadioItem2(){
    if(kaigoRobotRadioItem2==null){

      kaigoRobotRadioItem2 = new ACRadioButtonItem();

      kaigoRobotRadioItem2.setText("あり");

      kaigoRobotRadioItem2.setGroup(getKaigoRobotRadioGroup());

      kaigoRobotRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoRobotRadioItem2();
    }
    return kaigoRobotRadioItem2;

  }

  /**
   * 準ユニットケア体制を取得します。
   * @return 準ユニットケア体制
   */
  public ACValueArrayRadioButtonGroup getSemiUnitCareMaintenance(){
    if(semiUnitCareMaintenance==null){

      semiUnitCareMaintenance = new ACValueArrayRadioButtonGroup();

      getSemiUnitCareMaintenanceContainer().setText("準ユニットケア体制");

      semiUnitCareMaintenance.setBindPath("1510122");

      semiUnitCareMaintenance.setUseClearButton(false);

      semiUnitCareMaintenance.setModel(getSemiUnitCareMaintenanceModel());

      semiUnitCareMaintenance.setValues(new int[]{1,2});

      addSemiUnitCareMaintenance();
    }
    return semiUnitCareMaintenance;

  }

  /**
   * 準ユニットケア体制コンテナを取得します。
   * @return 準ユニットケア体制コンテナ
   */
  protected ACLabelContainer getSemiUnitCareMaintenanceContainer(){
    if(semiUnitCareMaintenanceContainer==null){
      semiUnitCareMaintenanceContainer = new ACLabelContainer();
      semiUnitCareMaintenanceContainer.setFollowChildEnabled(true);
      semiUnitCareMaintenanceContainer.setVAlignment(VRLayout.CENTER);
      semiUnitCareMaintenanceContainer.add(getSemiUnitCareMaintenance(), null);
    }
    return semiUnitCareMaintenanceContainer;
  }

  /**
   * 準ユニットケア体制モデルを取得します。
   * @return 準ユニットケア体制モデル
   */
  protected ACListModelAdapter getSemiUnitCareMaintenanceModel(){
    if(semiUnitCareMaintenanceModel==null){
      semiUnitCareMaintenanceModel = new ACListModelAdapter();
      addSemiUnitCareMaintenanceModel();
    }
    return semiUnitCareMaintenanceModel;
  }

  /**
   * 対応不可を取得します。
   * @return 対応不可
   */
  public ACRadioButtonItem getSemiUnitCareMaintenanceItem1(){
    if(semiUnitCareMaintenanceItem1==null){

      semiUnitCareMaintenanceItem1 = new ACRadioButtonItem();

      semiUnitCareMaintenanceItem1.setText("対応不可");

      semiUnitCareMaintenanceItem1.setGroup(getSemiUnitCareMaintenance());

      semiUnitCareMaintenanceItem1.setConstraints(VRLayout.FLOW);

      addSemiUnitCareMaintenanceItem1();
    }
    return semiUnitCareMaintenanceItem1;

  }

  /**
   * 対応可を取得します。
   * @return 対応可
   */
  public ACRadioButtonItem getSemiUnitCareMaintenanceItem2(){
    if(semiUnitCareMaintenanceItem2==null){

      semiUnitCareMaintenanceItem2 = new ACRadioButtonItem();

      semiUnitCareMaintenanceItem2.setText("対応可");

      semiUnitCareMaintenanceItem2.setGroup(getSemiUnitCareMaintenance());

      semiUnitCareMaintenanceItem2.setConstraints(VRLayout.FLOW);

      addSemiUnitCareMaintenanceItem2();
    }
    return semiUnitCareMaintenanceItem2;

  }

  /**
   * 生活機能向上連携加算を取得します。
   * @return 生活機能向上連携加算
   */
  public ACValueArrayRadioButtonGroup getSeikatsuKinouGroup(){
    if(seikatsuKinouGroup==null){

      seikatsuKinouGroup = new ACValueArrayRadioButtonGroup();

      getSeikatsuKinouGroupContainer().setText("生活機能向上連携加算");

      seikatsuKinouGroup.setBindPath("1510139");

      seikatsuKinouGroup.setNoSelectIndex(0);

      seikatsuKinouGroup.setUseClearButton(false);

      seikatsuKinouGroup.setModel(getSeikatsuKinouGroupModel());

      seikatsuKinouGroup.setValues(new int[]{1,2});

      addSeikatsuKinouGroup();
    }
    return seikatsuKinouGroup;

  }

  /**
   * 生活機能向上連携加算コンテナを取得します。
   * @return 生活機能向上連携加算コンテナ
   */
  protected ACLabelContainer getSeikatsuKinouGroupContainer(){
    if(seikatsuKinouGroupContainer==null){
      seikatsuKinouGroupContainer = new ACLabelContainer();
      seikatsuKinouGroupContainer.setFollowChildEnabled(true);
      seikatsuKinouGroupContainer.setVAlignment(VRLayout.CENTER);
      seikatsuKinouGroupContainer.add(getSeikatsuKinouGroup(), null);
    }
    return seikatsuKinouGroupContainer;
  }

  /**
   * 生活機能向上連携加算モデルを取得します。
   * @return 生活機能向上連携加算モデル
   */
  protected ACListModelAdapter getSeikatsuKinouGroupModel(){
    if(seikatsuKinouGroupModel==null){
      seikatsuKinouGroupModel = new ACListModelAdapter();
      addSeikatsuKinouGroupModel();
    }
    return seikatsuKinouGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getSeikatsuKinouGroupItem1(){
    if(seikatsuKinouGroupItem1==null){

      seikatsuKinouGroupItem1 = new ACRadioButtonItem();

      seikatsuKinouGroupItem1.setText("なし");

      seikatsuKinouGroupItem1.setGroup(getSeikatsuKinouGroup());

      seikatsuKinouGroupItem1.setConstraints(VRLayout.FLOW);

      addSeikatsuKinouGroupItem1();
    }
    return seikatsuKinouGroupItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getSeikatsuKinouGroupItem2(){
    if(seikatsuKinouGroupItem2==null){

      seikatsuKinouGroupItem2 = new ACRadioButtonItem();

      seikatsuKinouGroupItem2.setText("あり");

      seikatsuKinouGroupItem2.setGroup(getSeikatsuKinouGroup());

      seikatsuKinouGroupItem2.setConstraints(VRLayout.FLOW);

      addSeikatsuKinouGroupItem2();
    }
    return seikatsuKinouGroupItem2;

  }

  /**
   * 個別機能訓練体制ラジオグループを取得します。
   * @return 個別機能訓練体制ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getFunctionTrainingGuidanceSystem(){
    if(functionTrainingGuidanceSystem==null){

      functionTrainingGuidanceSystem = new ACValueArrayRadioButtonGroup();

      getFunctionTrainingGuidanceSystemContainer().setText("個別機能訓練体制");

      functionTrainingGuidanceSystem.setBindPath("1510103");

      functionTrainingGuidanceSystem.setUseClearButton(false);

      functionTrainingGuidanceSystem.setModel(getFunctionTrainingGuidanceSystemModel());

      functionTrainingGuidanceSystem.setValues(new int[]{1,2});

      addFunctionTrainingGuidanceSystem();
    }
    return functionTrainingGuidanceSystem;

  }

  /**
   * 個別機能訓練体制ラジオグループコンテナを取得します。
   * @return 個別機能訓練体制ラジオグループコンテナ
   */
  protected ACLabelContainer getFunctionTrainingGuidanceSystemContainer(){
    if(functionTrainingGuidanceSystemContainer==null){
      functionTrainingGuidanceSystemContainer = new ACLabelContainer();
      functionTrainingGuidanceSystemContainer.setFollowChildEnabled(true);
      functionTrainingGuidanceSystemContainer.setVAlignment(VRLayout.CENTER);
      functionTrainingGuidanceSystemContainer.add(getFunctionTrainingGuidanceSystem(), null);
    }
    return functionTrainingGuidanceSystemContainer;
  }

  /**
   * 個別機能訓練体制ラジオグループモデルを取得します。
   * @return 個別機能訓練体制ラジオグループモデル
   */
  protected ACListModelAdapter getFunctionTrainingGuidanceSystemModel(){
    if(functionTrainingGuidanceSystemModel==null){
      functionTrainingGuidanceSystemModel = new ACListModelAdapter();
      addFunctionTrainingGuidanceSystemModel();
    }
    return functionTrainingGuidanceSystemModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getFunctionTrainingGuidanceSystemItem1(){
    if(functionTrainingGuidanceSystemItem1==null){

      functionTrainingGuidanceSystemItem1 = new ACRadioButtonItem();

      functionTrainingGuidanceSystemItem1.setText("なし");

      functionTrainingGuidanceSystemItem1.setGroup(getFunctionTrainingGuidanceSystem());

      addFunctionTrainingGuidanceSystemItem1();
    }
    return functionTrainingGuidanceSystemItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getFunctionTrainingGuidanceSystemItem3(){
    if(functionTrainingGuidanceSystemItem3==null){

      functionTrainingGuidanceSystemItem3 = new ACRadioButtonItem();

      functionTrainingGuidanceSystemItem3.setText("あり");

      functionTrainingGuidanceSystemItem3.setGroup(getFunctionTrainingGuidanceSystem());

      addFunctionTrainingGuidanceSystemItem3();
    }
    return functionTrainingGuidanceSystemItem3;

  }

  /**
   * パネル2を取得します。
   * @return パネル2
   */
  public ACPanel getPanel2(){
    if(panel2==null){

      panel2 = new ACPanel();

      panel2.setFollowChildEnabled(true);

      panel2.setHgrid(200);

      addPanel2();
    }
    return panel2;

  }

  /**
   * 算定項目領域2を取得します。
   * @return 算定項目領域2
   */
  public ACPanel getCalculationDetails2(){
    if(calculationDetails2==null){

      calculationDetails2 = new ACPanel();

      calculationDetails2.setFollowChildEnabled(true);

      calculationDetails2.setHgrid(200);

      addCalculationDetails2();
    }
    return calculationDetails2;

  }

  /**
   * 若年性認知症入所者受入加算を取得します。
   * @return 若年性認知症入所者受入加算
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("若年性認知症入所者受入加算");

      youngDementiaPatinetAddRadioGroup.setBindPath("1510130");

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
   * 常勤専従医師配置ラジオグループを取得します。
   * @return 常勤専従医師配置ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getStandingDoctorAssignment(){
    if(standingDoctorAssignment==null){

      standingDoctorAssignment = new ACValueArrayRadioButtonGroup();

      getStandingDoctorAssignmentContainer().setText("常勤専従医師配置");

      standingDoctorAssignment.setBindPath("1510104");

      standingDoctorAssignment.setUseClearButton(false);

      standingDoctorAssignment.setModel(getStandingDoctorAssignmentModel());

      standingDoctorAssignment.setValues(new int[]{1,2});

      addStandingDoctorAssignment();
    }
    return standingDoctorAssignment;

  }

  /**
   * 常勤専従医師配置ラジオグループコンテナを取得します。
   * @return 常勤専従医師配置ラジオグループコンテナ
   */
  protected ACLabelContainer getStandingDoctorAssignmentContainer(){
    if(standingDoctorAssignmentContainer==null){
      standingDoctorAssignmentContainer = new ACLabelContainer();
      standingDoctorAssignmentContainer.setFollowChildEnabled(true);
      standingDoctorAssignmentContainer.setVAlignment(VRLayout.CENTER);
      standingDoctorAssignmentContainer.add(getStandingDoctorAssignment(), null);
    }
    return standingDoctorAssignmentContainer;
  }

  /**
   * 常勤専従医師配置ラジオグループモデルを取得します。
   * @return 常勤専従医師配置ラジオグループモデル
   */
  protected ACListModelAdapter getStandingDoctorAssignmentModel(){
    if(standingDoctorAssignmentModel==null){
      standingDoctorAssignmentModel = new ACListModelAdapter();
      addStandingDoctorAssignmentModel();
    }
    return standingDoctorAssignmentModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getStandingDoctorAssignmentItem1(){
    if(standingDoctorAssignmentItem1==null){

      standingDoctorAssignmentItem1 = new ACRadioButtonItem();

      standingDoctorAssignmentItem1.setText("なし");

      standingDoctorAssignmentItem1.setGroup(getStandingDoctorAssignment());

      addStandingDoctorAssignmentItem1();
    }
    return standingDoctorAssignmentItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getStandingDoctorAssignmentItem2(){
    if(standingDoctorAssignmentItem2==null){

      standingDoctorAssignmentItem2 = new ACRadioButtonItem();

      standingDoctorAssignmentItem2.setText("あり");

      standingDoctorAssignmentItem2.setGroup(getStandingDoctorAssignment());

      addStandingDoctorAssignmentItem2();
    }
    return standingDoctorAssignmentItem2;

  }

  /**
   * 精神科医師定期的療養指導ラジオグループを取得します。
   * @return 精神科医師定期的療養指導ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getPsychiatristGuidance(){
    if(psychiatristGuidance==null){

      psychiatristGuidance = new ACValueArrayRadioButtonGroup();

      getPsychiatristGuidanceContainer().setText("精神科医師定期的療養指導");

      psychiatristGuidance.setBindPath("1510105");

      psychiatristGuidance.setUseClearButton(false);

      psychiatristGuidance.setModel(getPsychiatristGuidanceModel());

      psychiatristGuidance.setValues(new int[]{1,2});

      addPsychiatristGuidance();
    }
    return psychiatristGuidance;

  }

  /**
   * 精神科医師定期的療養指導ラジオグループコンテナを取得します。
   * @return 精神科医師定期的療養指導ラジオグループコンテナ
   */
  protected ACLabelContainer getPsychiatristGuidanceContainer(){
    if(psychiatristGuidanceContainer==null){
      psychiatristGuidanceContainer = new ACLabelContainer();
      psychiatristGuidanceContainer.setFollowChildEnabled(true);
      psychiatristGuidanceContainer.setVAlignment(VRLayout.CENTER);
      psychiatristGuidanceContainer.add(getPsychiatristGuidance(), null);
    }
    return psychiatristGuidanceContainer;
  }

  /**
   * 精神科医師定期的療養指導ラジオグループモデルを取得します。
   * @return 精神科医師定期的療養指導ラジオグループモデル
   */
  protected ACListModelAdapter getPsychiatristGuidanceModel(){
    if(psychiatristGuidanceModel==null){
      psychiatristGuidanceModel = new ACListModelAdapter();
      addPsychiatristGuidanceModel();
    }
    return psychiatristGuidanceModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getPsychiatristGuidanceItem1(){
    if(psychiatristGuidanceItem1==null){

      psychiatristGuidanceItem1 = new ACRadioButtonItem();

      psychiatristGuidanceItem1.setText("なし");

      psychiatristGuidanceItem1.setGroup(getPsychiatristGuidance());

      addPsychiatristGuidanceItem1();
    }
    return psychiatristGuidanceItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getPsychiatristGuidanceItem2(){
    if(psychiatristGuidanceItem2==null){

      psychiatristGuidanceItem2 = new ACRadioButtonItem();

      psychiatristGuidanceItem2.setText("あり");

      psychiatristGuidanceItem2.setGroup(getPsychiatristGuidance());

      addPsychiatristGuidanceItem2();
    }
    return psychiatristGuidanceItem2;

  }

  /**
   * 障害者生活支援体制ラジオグループを取得します。
   * @return 障害者生活支援体制ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getHandicappedPersonSupport(){
    if(handicappedPersonSupport==null){

      handicappedPersonSupport = new ACValueArrayRadioButtonGroup();

      getHandicappedPersonSupportContainer().setText("障害者生活支援体制");

      handicappedPersonSupport.setBindPath("1510106");

      handicappedPersonSupport.setUseClearButton(false);

      handicappedPersonSupport.setModel(getHandicappedPersonSupportModel());

      handicappedPersonSupport.setValues(new int[]{1,2,3});

      addHandicappedPersonSupport();
    }
    return handicappedPersonSupport;

  }

  /**
   * 障害者生活支援体制ラジオグループコンテナを取得します。
   * @return 障害者生活支援体制ラジオグループコンテナ
   */
  protected ACLabelContainer getHandicappedPersonSupportContainer(){
    if(handicappedPersonSupportContainer==null){
      handicappedPersonSupportContainer = new ACLabelContainer();
      handicappedPersonSupportContainer.setFollowChildEnabled(true);
      handicappedPersonSupportContainer.setVAlignment(VRLayout.CENTER);
      handicappedPersonSupportContainer.add(getHandicappedPersonSupport(), null);
    }
    return handicappedPersonSupportContainer;
  }

  /**
   * 障害者生活支援体制ラジオグループモデルを取得します。
   * @return 障害者生活支援体制ラジオグループモデル
   */
  protected ACListModelAdapter getHandicappedPersonSupportModel(){
    if(handicappedPersonSupportModel==null){
      handicappedPersonSupportModel = new ACListModelAdapter();
      addHandicappedPersonSupportModel();
    }
    return handicappedPersonSupportModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHandicappedPersonSupportItem1(){
    if(handicappedPersonSupportItem1==null){

      handicappedPersonSupportItem1 = new ACRadioButtonItem();

      handicappedPersonSupportItem1.setText("なし");

      handicappedPersonSupportItem1.setGroup(getHandicappedPersonSupport());

      addHandicappedPersonSupportItem1();
    }
    return handicappedPersonSupportItem1;

  }

  /**
   * 加算Iを取得します。
   * @return 加算I
   */
  public ACRadioButtonItem getHandicappedPersonSupportItem2(){
    if(handicappedPersonSupportItem2==null){

      handicappedPersonSupportItem2 = new ACRadioButtonItem();

      handicappedPersonSupportItem2.setText("加算I");

      handicappedPersonSupportItem2.setGroup(getHandicappedPersonSupport());

      addHandicappedPersonSupportItem2();
    }
    return handicappedPersonSupportItem2;

  }

  /**
   * 加算IIを取得します。
   * @return 加算II
   */
  public ACRadioButtonItem getHandicappedPersonSupportItem3(){
    if(handicappedPersonSupportItem3==null){

      handicappedPersonSupportItem3 = new ACRadioButtonItem();

      handicappedPersonSupportItem3.setText("加算II");

      handicappedPersonSupportItem3.setGroup(getHandicappedPersonSupport());

      addHandicappedPersonSupportItem3();
    }
    return handicappedPersonSupportItem3;

  }

  /**
   * 栄養マネジメント体制を取得します。
   * @return 栄養マネジメント体制
   */
  public ACValueArrayRadioButtonGroup getNourishmentImprovement(){
    if(nourishmentImprovement==null){

      nourishmentImprovement = new ACValueArrayRadioButtonGroup();

      getNourishmentImprovementContainer().setText("栄養マネジメント体制");

      nourishmentImprovement.setBindPath("1510134");

      nourishmentImprovement.setUseClearButton(false);

      nourishmentImprovement.setModel(getNourishmentImprovementModel());

      nourishmentImprovement.setValues(new int[]{1,2});

      addNourishmentImprovement();
    }
    return nourishmentImprovement;

  }

  /**
   * 栄養マネジメント体制コンテナを取得します。
   * @return 栄養マネジメント体制コンテナ
   */
  protected ACLabelContainer getNourishmentImprovementContainer(){
    if(nourishmentImprovementContainer==null){
      nourishmentImprovementContainer = new ACLabelContainer();
      nourishmentImprovementContainer.setFollowChildEnabled(true);
      nourishmentImprovementContainer.setVAlignment(VRLayout.CENTER);
      nourishmentImprovementContainer.add(getNourishmentImprovement(), null);
    }
    return nourishmentImprovementContainer;
  }

  /**
   * 栄養マネジメント体制モデルを取得します。
   * @return 栄養マネジメント体制モデル
   */
  protected ACListModelAdapter getNourishmentImprovementModel(){
    if(nourishmentImprovementModel==null){
      nourishmentImprovementModel = new ACListModelAdapter();
      addNourishmentImprovementModel();
    }
    return nourishmentImprovementModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getNourishmentImprovementAddItem1(){
    if(nourishmentImprovementAddItem1==null){

      nourishmentImprovementAddItem1 = new ACRadioButtonItem();

      nourishmentImprovementAddItem1.setText("なし");

      nourishmentImprovementAddItem1.setGroup(getNourishmentImprovement());

      addNourishmentImprovementAddItem1();
    }
    return nourishmentImprovementAddItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getNourishmentImprovementAddItem2(){
    if(nourishmentImprovementAddItem2==null){

      nourishmentImprovementAddItem2 = new ACRadioButtonItem();

      nourishmentImprovementAddItem2.setText("あり");

      nourishmentImprovementAddItem2.setGroup(getNourishmentImprovement());

      addNourishmentImprovementAddItem2();
    }
    return nourishmentImprovementAddItem2;

  }

  /**
   * 療養食加算を取得します。
   * @return 療養食加算
   */
  public ACValueArrayRadioButtonGroup getMedicalFoodAddRadioGroup(){
    if(medicalFoodAddRadioGroup==null){

      medicalFoodAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getMedicalFoodAddRadioGroupContainer().setText("療養食加算");

      medicalFoodAddRadioGroup.setBindPath("1510131");

      medicalFoodAddRadioGroup.setNoSelectIndex(0);

      medicalFoodAddRadioGroup.setUseClearButton(false);

      medicalFoodAddRadioGroup.setModel(getMedicalFoodAddRadioGroupModel());

      medicalFoodAddRadioGroup.setValues(new int[]{1,2});

      addMedicalFoodAddRadioGroup();
    }
    return medicalFoodAddRadioGroup;

  }

  /**
   * 療養食加算コンテナを取得します。
   * @return 療養食加算コンテナ
   */
  protected ACLabelContainer getMedicalFoodAddRadioGroupContainer(){
    if(medicalFoodAddRadioGroupContainer==null){
      medicalFoodAddRadioGroupContainer = new ACLabelContainer();
      medicalFoodAddRadioGroupContainer.setFollowChildEnabled(true);
      medicalFoodAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      medicalFoodAddRadioGroupContainer.add(getMedicalFoodAddRadioGroup(), null);
    }
    return medicalFoodAddRadioGroupContainer;
  }

  /**
   * 療養食加算モデルを取得します。
   * @return 療養食加算モデル
   */
  protected ACListModelAdapter getMedicalFoodAddRadioGroupModel(){
    if(medicalFoodAddRadioGroupModel==null){
      medicalFoodAddRadioGroupModel = new ACListModelAdapter();
      addMedicalFoodAddRadioGroupModel();
    }
    return medicalFoodAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalFoodAddRadioItem1(){
    if(medicalFoodAddRadioItem1==null){

      medicalFoodAddRadioItem1 = new ACRadioButtonItem();

      medicalFoodAddRadioItem1.setText("なし");

      medicalFoodAddRadioItem1.setGroup(getMedicalFoodAddRadioGroup());

      medicalFoodAddRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFoodAddRadioItem1();
    }
    return medicalFoodAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMedicalFoodAddRadioItem2(){
    if(medicalFoodAddRadioItem2==null){

      medicalFoodAddRadioItem2 = new ACRadioButtonItem();

      medicalFoodAddRadioItem2.setText("あり");

      medicalFoodAddRadioItem2.setGroup(getMedicalFoodAddRadioGroup());

      medicalFoodAddRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFoodAddRadioItem2();
    }
    return medicalFoodAddRadioItem2;

  }

  /**
   * 配置医師緊急時対応加算を取得します。
   * @return 配置医師緊急時対応加算
   */
  public ACValueArrayRadioButtonGroup getPlacementDoctorEmergency(){
    if(placementDoctorEmergency==null){

      placementDoctorEmergency = new ACValueArrayRadioButtonGroup();

      getPlacementDoctorEmergencyContainer().setText("配置医師緊急時対応加算");

      placementDoctorEmergency.setBindPath("1510136");

      placementDoctorEmergency.setNoSelectIndex(0);

      placementDoctorEmergency.setUseClearButton(false);

      placementDoctorEmergency.setModel(getPlacementDoctorEmergencyModel());

      placementDoctorEmergency.setValues(new int[]{1,2});

      addPlacementDoctorEmergency();
    }
    return placementDoctorEmergency;

  }

  /**
   * 配置医師緊急時対応加算コンテナを取得します。
   * @return 配置医師緊急時対応加算コンテナ
   */
  protected ACLabelContainer getPlacementDoctorEmergencyContainer(){
    if(placementDoctorEmergencyContainer==null){
      placementDoctorEmergencyContainer = new ACLabelContainer();
      placementDoctorEmergencyContainer.setFollowChildEnabled(true);
      placementDoctorEmergencyContainer.setVAlignment(VRLayout.CENTER);
      placementDoctorEmergencyContainer.add(getPlacementDoctorEmergency(), null);
    }
    return placementDoctorEmergencyContainer;
  }

  /**
   * 配置医師緊急時対応加算モデルを取得します。
   * @return 配置医師緊急時対応加算モデル
   */
  protected ACListModelAdapter getPlacementDoctorEmergencyModel(){
    if(placementDoctorEmergencyModel==null){
      placementDoctorEmergencyModel = new ACListModelAdapter();
      addPlacementDoctorEmergencyModel();
    }
    return placementDoctorEmergencyModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getPlacementDoctorEmergencyItem1(){
    if(placementDoctorEmergencyItem1==null){

      placementDoctorEmergencyItem1 = new ACRadioButtonItem();

      placementDoctorEmergencyItem1.setText("なし");

      placementDoctorEmergencyItem1.setGroup(getPlacementDoctorEmergency());

      placementDoctorEmergencyItem1.setConstraints(VRLayout.FLOW);

      addPlacementDoctorEmergencyItem1();
    }
    return placementDoctorEmergencyItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getPlacementDoctorEmergencyItem2(){
    if(placementDoctorEmergencyItem2==null){

      placementDoctorEmergencyItem2 = new ACRadioButtonItem();

      placementDoctorEmergencyItem2.setText("あり");

      placementDoctorEmergencyItem2.setGroup(getPlacementDoctorEmergency());

      placementDoctorEmergencyItem2.setConstraints(VRLayout.FLOW);

      addPlacementDoctorEmergencyItem2();
    }
    return placementDoctorEmergencyItem2;

  }

  /**
   * 看取り介護体制を取得します。
   * @return 看取り介護体制
   */
  public ACValueArrayRadioButtonGroup getTerminalCare(){
    if(terminalCare==null){

      terminalCare = new ACValueArrayRadioButtonGroup();

      getTerminalCareContainer().setText("看取り介護体制");

      terminalCare.setBindPath("1510125");

      terminalCare.setUseClearButton(false);

      terminalCare.setModel(getTerminalCareModel());

      terminalCare.setValues(new int[]{1,2,3});

      addTerminalCare();
    }
    return terminalCare;

  }

  /**
   * 看取り介護体制コンテナを取得します。
   * @return 看取り介護体制コンテナ
   */
  protected ACLabelContainer getTerminalCareContainer(){
    if(terminalCareContainer==null){
      terminalCareContainer = new ACLabelContainer();
      terminalCareContainer.setFollowChildEnabled(true);
      terminalCareContainer.setVAlignment(VRLayout.CENTER);
      terminalCareContainer.add(getTerminalCare(), null);
    }
    return terminalCareContainer;
  }

  /**
   * 看取り介護体制モデルを取得します。
   * @return 看取り介護体制モデル
   */
  protected ACListModelAdapter getTerminalCareModel(){
    if(terminalCareModel==null){
      terminalCareModel = new ACListModelAdapter();
      addTerminalCareModel();
    }
    return terminalCareModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTerminalCareItem1(){
    if(terminalCareItem1==null){

      terminalCareItem1 = new ACRadioButtonItem();

      terminalCareItem1.setText("なし");

      terminalCareItem1.setGroup(getTerminalCare());

      terminalCareItem1.setConstraints(VRLayout.FLOW);

      addTerminalCareItem1();
    }
    return terminalCareItem1;

  }

  /**
   * 加算Iを取得します。
   * @return 加算I
   */
  public ACRadioButtonItem getTerminalCareItem2(){
    if(terminalCareItem2==null){

      terminalCareItem2 = new ACRadioButtonItem();

      terminalCareItem2.setText("加算I");

      terminalCareItem2.setGroup(getTerminalCare());

      terminalCareItem2.setConstraints(VRLayout.FLOW);

      addTerminalCareItem2();
    }
    return terminalCareItem2;

  }

  /**
   * 加算IIを取得します。
   * @return 加算II
   */
  public ACRadioButtonItem getTerminalCareItem3(){
    if(terminalCareItem3==null){

      terminalCareItem3 = new ACRadioButtonItem();

      terminalCareItem3.setText("加算II");

      terminalCareItem3.setGroup(getTerminalCare());

      terminalCareItem3.setConstraints(VRLayout.FLOW);

      addTerminalCareItem3();
    }
    return terminalCareItem3;

  }

  /**
   * 在宅・入所相互利用体制を取得します。
   * @return 在宅・入所相互利用体制
   */
  public ACValueArrayRadioButtonGroup getHomeAndFacility(){
    if(homeAndFacility==null){

      homeAndFacility = new ACValueArrayRadioButtonGroup();

      getHomeAndFacilityContainer().setText("在宅・入所相互利用体制");

      homeAndFacility.setBindPath("1510126");

      homeAndFacility.setUseClearButton(false);

      homeAndFacility.setModel(getHomeAndFacilityModel());

      homeAndFacility.setValues(new int[]{1,2});

      addHomeAndFacility();
    }
    return homeAndFacility;

  }

  /**
   * 在宅・入所相互利用体制コンテナを取得します。
   * @return 在宅・入所相互利用体制コンテナ
   */
  protected ACLabelContainer getHomeAndFacilityContainer(){
    if(homeAndFacilityContainer==null){
      homeAndFacilityContainer = new ACLabelContainer();
      homeAndFacilityContainer.setFollowChildEnabled(true);
      homeAndFacilityContainer.setVAlignment(VRLayout.CENTER);
      homeAndFacilityContainer.add(getHomeAndFacility(), null);
    }
    return homeAndFacilityContainer;
  }

  /**
   * 在宅・入所相互利用体制モデルを取得します。
   * @return 在宅・入所相互利用体制モデル
   */
  protected ACListModelAdapter getHomeAndFacilityModel(){
    if(homeAndFacilityModel==null){
      homeAndFacilityModel = new ACListModelAdapter();
      addHomeAndFacilityModel();
    }
    return homeAndFacilityModel;
  }

  /**
   * 対応不可を取得します。
   * @return 対応不可
   */
  public ACRadioButtonItem getHomeAndFacilityItem1(){
    if(homeAndFacilityItem1==null){

      homeAndFacilityItem1 = new ACRadioButtonItem();

      homeAndFacilityItem1.setText("対応不可");

      homeAndFacilityItem1.setGroup(getHomeAndFacility());

      homeAndFacilityItem1.setConstraints(VRLayout.FLOW);

      addHomeAndFacilityItem1();
    }
    return homeAndFacilityItem1;

  }

  /**
   * 対応可を取得します。
   * @return 対応可
   */
  public ACRadioButtonItem getHomeAndFacilityItem2(){
    if(homeAndFacilityItem2==null){

      homeAndFacilityItem2 = new ACRadioButtonItem();

      homeAndFacilityItem2.setText("対応可");

      homeAndFacilityItem2.setGroup(getHomeAndFacility());

      homeAndFacilityItem2.setConstraints(VRLayout.FLOW);

      addHomeAndFacilityItem2();
    }
    return homeAndFacilityItem2;

  }

  /**
   * 認知症専門ケア加算を取得します。
   * @return 認知症専門ケア加算
   */
  public ACValueArrayRadioButtonGroup getDementiaProfessionalCareAddRadioGroup(){
    if(dementiaProfessionalCareAddRadioGroup==null){

      dementiaProfessionalCareAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaProfessionalCareAddRadioGroupContainer().setText("認知症専門ケア加算");

      dementiaProfessionalCareAddRadioGroup.setBindPath("1510132");

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
   * 加算Iを取得します。
   * @return 加算I
   */
  public ACRadioButtonItem getDementiaProfessionalCareAddRadioItem2(){
    if(dementiaProfessionalCareAddRadioItem2==null){

      dementiaProfessionalCareAddRadioItem2 = new ACRadioButtonItem();

      dementiaProfessionalCareAddRadioItem2.setText("加算I");

      dementiaProfessionalCareAddRadioItem2.setGroup(getDementiaProfessionalCareAddRadioGroup());

      dementiaProfessionalCareAddRadioItem2.setConstraints(VRLayout.FLOW);

      addDementiaProfessionalCareAddRadioItem2();
    }
    return dementiaProfessionalCareAddRadioItem2;

  }

  /**
   * 加算IIを取得します。
   * @return 加算II
   */
  public ACRadioButtonItem getDementiaProfessionalCareAddRadioItem3(){
    if(dementiaProfessionalCareAddRadioItem3==null){

      dementiaProfessionalCareAddRadioItem3 = new ACRadioButtonItem();

      dementiaProfessionalCareAddRadioItem3.setText("加算II");

      dementiaProfessionalCareAddRadioItem3.setGroup(getDementiaProfessionalCareAddRadioGroup());

      dementiaProfessionalCareAddRadioItem3.setConstraints(VRLayout.FLOW);

      addDementiaProfessionalCareAddRadioItem3();
    }
    return dementiaProfessionalCareAddRadioItem3;

  }

  /**
   * 褥瘡マネジメント加算を取得します。
   * @return 褥瘡マネジメント加算
   */
  public ACValueArrayRadioButtonGroup getPressureUlcerManagement(){
    if(pressureUlcerManagement==null){

      pressureUlcerManagement = new ACValueArrayRadioButtonGroup();

      getPressureUlcerManagementContainer().setText("褥瘡マネジメント加算");

      pressureUlcerManagement.setBindPath("1510137");

      pressureUlcerManagement.setNoSelectIndex(0);

      pressureUlcerManagement.setUseClearButton(false);

      pressureUlcerManagement.setModel(getPressureUlcerManagementModel());

      pressureUlcerManagement.setValues(new int[]{1,2});

      addPressureUlcerManagement();
    }
    return pressureUlcerManagement;

  }

  /**
   * 褥瘡マネジメント加算コンテナを取得します。
   * @return 褥瘡マネジメント加算コンテナ
   */
  protected ACLabelContainer getPressureUlcerManagementContainer(){
    if(pressureUlcerManagementContainer==null){
      pressureUlcerManagementContainer = new ACLabelContainer();
      pressureUlcerManagementContainer.setFollowChildEnabled(true);
      pressureUlcerManagementContainer.setVAlignment(VRLayout.CENTER);
      pressureUlcerManagementContainer.add(getPressureUlcerManagement(), null);
    }
    return pressureUlcerManagementContainer;
  }

  /**
   * 褥瘡マネジメント加算モデルを取得します。
   * @return 褥瘡マネジメント加算モデル
   */
  protected ACListModelAdapter getPressureUlcerManagementModel(){
    if(pressureUlcerManagementModel==null){
      pressureUlcerManagementModel = new ACListModelAdapter();
      addPressureUlcerManagementModel();
    }
    return pressureUlcerManagementModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getPressureUlcerManagementItem1(){
    if(pressureUlcerManagementItem1==null){

      pressureUlcerManagementItem1 = new ACRadioButtonItem();

      pressureUlcerManagementItem1.setText("なし");

      pressureUlcerManagementItem1.setGroup(getPressureUlcerManagement());

      pressureUlcerManagementItem1.setConstraints(VRLayout.FLOW);

      addPressureUlcerManagementItem1();
    }
    return pressureUlcerManagementItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getPressureUlcerManagementItem2(){
    if(pressureUlcerManagementItem2==null){

      pressureUlcerManagementItem2 = new ACRadioButtonItem();

      pressureUlcerManagementItem2.setText("あり");

      pressureUlcerManagementItem2.setGroup(getPressureUlcerManagement());

      pressureUlcerManagementItem2.setConstraints(VRLayout.FLOW);

      addPressureUlcerManagementItem2();
    }
    return pressureUlcerManagementItem2;

  }

  /**
   * サービス提供体制強化加算を取得します。
   * @return サービス提供体制強化加算
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("サービス提供体制強化加算");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1510133");

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
   * 加算Iイを取得します。
   * @return 加算Iイ
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("加算Iイ");

      serviceAddProvisionStructuralRadioItem2.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem2.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem2();
    }
    return serviceAddProvisionStructuralRadioItem2;

  }

  /**
   * 加算Iロを取得します。
   * @return 加算Iロ
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem3(){
    if(serviceAddProvisionStructuralRadioItem3==null){

      serviceAddProvisionStructuralRadioItem3 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem3.setText("加算Iロ");

      serviceAddProvisionStructuralRadioItem3.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addServiceAddProvisionStructuralRadioItem3();
    }
    return serviceAddProvisionStructuralRadioItem3;

  }

  /**
   * 加算IIを取得します。
   * @return 加算II
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem4(){
    if(serviceAddProvisionStructuralRadioItem4==null){

      serviceAddProvisionStructuralRadioItem4 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem4.setText("加算II");

      serviceAddProvisionStructuralRadioItem4.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem4.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem4();
    }
    return serviceAddProvisionStructuralRadioItem4;

  }

  /**
   * 加算IIIを取得します。
   * @return 加算III
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem5(){
    if(serviceAddProvisionStructuralRadioItem5==null){

      serviceAddProvisionStructuralRadioItem5 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem5.setText("加算III");

      serviceAddProvisionStructuralRadioItem5.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem5.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem5();
    }
    return serviceAddProvisionStructuralRadioItem5;

  }

  /**
   * 介護職員処遇改善加算を取得します。
   * @return 介護職員処遇改善加算
   */
  public ACValueArrayRadioButtonGroup getStaffUpgradeRadioGroup(){
    if(staffUpgradeRadioGroup==null){

      staffUpgradeRadioGroup = new ACValueArrayRadioButtonGroup();

      getStaffUpgradeRadioGroupContainer().setText("介護職員処遇改善加算");

      staffUpgradeRadioGroup.setBindPath("4");

      staffUpgradeRadioGroup.setEnabled(true);

      staffUpgradeRadioGroup.setUseClearButton(false);

      staffUpgradeRadioGroup.setModel(getStaffUpgradeRadioGroupModel());

      staffUpgradeRadioGroup.setValues(new int[]{1,6,5,2,3,4});

      addStaffUpgradeRadioGroup();
    }
    return staffUpgradeRadioGroup;

  }

  /**
   * 介護職員処遇改善加算コンテナを取得します。
   * @return 介護職員処遇改善加算コンテナ
   */
  protected ACLabelContainer getStaffUpgradeRadioGroupContainer(){
    if(staffUpgradeRadioGroupContainer==null){
      staffUpgradeRadioGroupContainer = new ACLabelContainer();
      staffUpgradeRadioGroupContainer.setFollowChildEnabled(true);
      staffUpgradeRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      staffUpgradeRadioGroupContainer.add(getStaffUpgradeRadioGroup(), null);
    }
    return staffUpgradeRadioGroupContainer;
  }

  /**
   * 介護職員処遇改善加算モデルを取得します。
   * @return 介護職員処遇改善加算モデル
   */
  protected ACListModelAdapter getStaffUpgradeRadioGroupModel(){
    if(staffUpgradeRadioGroupModel==null){
      staffUpgradeRadioGroupModel = new ACListModelAdapter();
      addStaffUpgradeRadioGroupModel();
    }
    return staffUpgradeRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getStaffUpgradeRadioItem1(){
    if(staffUpgradeRadioItem1==null){

      staffUpgradeRadioItem1 = new ACRadioButtonItem();

      staffUpgradeRadioItem1.setText("なし");

      staffUpgradeRadioItem1.setGroup(getStaffUpgradeRadioGroup());

      staffUpgradeRadioItem1.setConstraints(VRLayout.FLOW);

      addStaffUpgradeRadioItem1();
    }
    return staffUpgradeRadioItem1;

  }

  /**
   * 加算Iを取得します。
   * @return 加算I
   */
  public ACRadioButtonItem getStaffUpgradeRadioItem2(){
    if(staffUpgradeRadioItem2==null){

      staffUpgradeRadioItem2 = new ACRadioButtonItem();

      staffUpgradeRadioItem2.setText("加算I");

      staffUpgradeRadioItem2.setGroup(getStaffUpgradeRadioGroup());

      staffUpgradeRadioItem2.setConstraints(VRLayout.FLOW);

      addStaffUpgradeRadioItem2();
    }
    return staffUpgradeRadioItem2;

  }

  /**
   * 加算IIを取得します。
   * @return 加算II
   */
  public ACRadioButtonItem getStaffUpgradeRadioItem3(){
    if(staffUpgradeRadioItem3==null){

      staffUpgradeRadioItem3 = new ACRadioButtonItem();

      staffUpgradeRadioItem3.setText("加算II");

      staffUpgradeRadioItem3.setGroup(getStaffUpgradeRadioGroup());

      staffUpgradeRadioItem3.setConstraints(VRLayout.FLOW);

      addStaffUpgradeRadioItem3();
    }
    return staffUpgradeRadioItem3;

  }

  /**
   * 加算IIIを取得します。
   * @return 加算III
   */
  public ACRadioButtonItem getStaffUpgradeRadioItem4(){
    if(staffUpgradeRadioItem4==null){

      staffUpgradeRadioItem4 = new ACRadioButtonItem();

      staffUpgradeRadioItem4.setText("加算III");

      staffUpgradeRadioItem4.setGroup(getStaffUpgradeRadioGroup());

      staffUpgradeRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addStaffUpgradeRadioItem4();
    }
    return staffUpgradeRadioItem4;

  }

  /**
   * 加算IVを取得します。
   * @return 加算IV
   */
  public ACRadioButtonItem getStaffUpgradeRadioItem5(){
    if(staffUpgradeRadioItem5==null){

      staffUpgradeRadioItem5 = new ACRadioButtonItem();

      staffUpgradeRadioItem5.setText("加算IV");

      staffUpgradeRadioItem5.setGroup(getStaffUpgradeRadioGroup());

      staffUpgradeRadioItem5.setConstraints(VRLayout.FLOW);

      addStaffUpgradeRadioItem5();
    }
    return staffUpgradeRadioItem5;

  }

  /**
   * 加算Vを取得します。
   * @return 加算V
   */
  public ACRadioButtonItem getStaffUpgradeRadioItem6(){
    if(staffUpgradeRadioItem6==null){

      staffUpgradeRadioItem6 = new ACRadioButtonItem();

      staffUpgradeRadioItem6.setText("加算V");

      staffUpgradeRadioItem6.setGroup(getStaffUpgradeRadioGroup());

      staffUpgradeRadioItem6.setConstraints(VRLayout.FLOW);

      addStaffUpgradeRadioItem6();
    }
    return staffUpgradeRadioItem6;

  }

  /**
   * 算定項目領域3を取得します。
   * @return 算定項目領域3
   */
  public ACPanel getCalculationDetails3(){
    if(calculationDetails3==null){

      calculationDetails3 = new ACPanel();

      calculationDetails3.setFollowChildEnabled(true);

      calculationDetails3.setHgrid(200);

      addCalculationDetails3();
    }
    return calculationDetails3;

  }

  /**
   * 割引率コンテナを取得します。
   * @return 割引率コンテナ
   */
  public ACLabelContainer getReduceRateContainer(){
    if(reduceRateContainer==null){

      reduceRateContainer = new ACLabelContainer();

      reduceRateContainer.setText("割引率");

      reduceRateContainer.setFollowChildEnabled(true);

      addReduceRateContainer();
    }
    return reduceRateContainer;

  }

  /**
   * 割引率を取得します。
   * @return 割引率
   */
  public ACTextField getReduceRate(){
    if(reduceRate==null){

      reduceRate = new ACTextField();

      reduceRate.setBindPath("REDUCT_RATE");

      reduceRate.setColumns(3);

      reduceRate.setCharType(VRCharType.ONLY_DIGIT);

      reduceRate.setHorizontalAlignment(SwingConstants.RIGHT);

      reduceRate.setIMEMode(InputSubset.LATIN);

      reduceRate.setMaxLength(3);

      addReduceRate();
    }
    return reduceRate;

  }

  /**
   * ％ラベルを取得します。
   * @return ％ラベル
   */
  public ACLabel getPercentSign(){
    if(percentSign==null){

      percentSign = new ACLabel();

      percentSign.setText("％");

      addPercentSign();
    }
    return percentSign;

  }

  /**
   * 社福減免対象事業者を取得します。
   * @return 社福減免対象事業者
   */
  public ACIntegerCheckBox getShahukuReduce(){
    if(ShahukuReduce==null){

      ShahukuReduce = new ACIntegerCheckBox();

      ShahukuReduce.setText("社会福祉法人等の軽減制度");

      ShahukuReduce.setBindPath("1");

      ShahukuReduce.setSelectValue(2);

      ShahukuReduce.setUnSelectValue(1);

      addShahukuReduce();
    }
    return ShahukuReduce;

  }

  /**
   * パネル3を取得します。
   * @return パネル3
   */
  public ACPanel getPanel3(){
    if(panel3==null){

      panel3 = new ACPanel();

      panel3.setFollowChildEnabled(true);

      panel3.setHgrid(200);

      addPanel3();
    }
    return panel3;

  }

  /**
   * 基準額グループを取得します。
   * @return 基準額グループ
   */
  public ACGroupBox getStandardMoneyGroup(){
    if(standardMoneyGroup==null){

      standardMoneyGroup = new ACGroupBox();

      standardMoneyGroup.setText("食費・居住費基準額");

      standardMoneyGroup.setFollowChildEnabled(true);

      standardMoneyGroup.setHgrid(500);

      addStandardMoneyGroup();
    }
    return standardMoneyGroup;

  }

  /**
   * 食費基準額・コンテナを取得します。
   * @return 食費基準額・コンテナ
   */
  public ACLabelContainer getDinnerContainer(){
    if(dinnerContainer==null){

      dinnerContainer = new ACLabelContainer();

      dinnerContainer.setText("食費");

      dinnerContainer.setFollowChildEnabled(true);

      addDinnerContainer();
    }
    return dinnerContainer;

  }

  /**
   * 食費基準額・合計・テキストを取得します。
   * @return 食費基準額・合計・テキスト
   */
  public ACTextField getDinnerTotal(){
    if(dinnerTotal==null){

      dinnerTotal = new ACTextField();

      dinnerTotal.setBindPath("1510113");

      dinnerTotal.setColumns(4);

      dinnerTotal.setCharType(VRCharType.ONLY_DIGIT);

      dinnerTotal.setHorizontalAlignment(SwingConstants.RIGHT);

      dinnerTotal.setIMEMode(InputSubset.LATIN);

      dinnerTotal.setMaxLength(4);

      addDinnerTotal();
    }
    return dinnerTotal;

  }

  /**
   * 食費基準額・内訳・コンテナを取得します。
   * @return 食費基準額・内訳・コンテナ
   */
  public ACBackLabelContainer getDinnerDetailsContainer(){
    if(dinnerDetailsContainer==null){

      dinnerDetailsContainer = new ACBackLabelContainer();

      dinnerDetailsContainer.setFollowChildEnabled(true);

      addDinnerDetailsContainer();
    }
    return dinnerDetailsContainer;

  }

  /**
   * 食費基準額・朝・ラベルを取得します。
   * @return 食費基準額・朝・ラベル
   */
  public ACLabel getDinnerMorningLabel(){
    if(dinnerMorningLabel==null){

      dinnerMorningLabel = new ACLabel();

      dinnerMorningLabel.setText("朝");

      addDinnerMorningLabel();
    }
    return dinnerMorningLabel;

  }

  /**
   * 食費基準額・朝・テキストを取得します。
   * @return 食費基準額・朝・テキスト
   */
  public ACTextField getDinnerMorning(){
    if(dinnerMorning==null){

      dinnerMorning = new ACTextField();

      dinnerMorning.setBindPath("1510114");

      dinnerMorning.setColumns(3);

      dinnerMorning.setCharType(VRCharType.ONLY_DIGIT);

      dinnerMorning.setHorizontalAlignment(SwingConstants.RIGHT);

      dinnerMorning.setIMEMode(InputSubset.LATIN);

      dinnerMorning.setMaxLength(4);

      addDinnerMorning();
    }
    return dinnerMorning;

  }

  /**
   * 食費基準額・昼・ラベルを取得します。
   * @return 食費基準額・昼・ラベル
   */
  public ACLabel getDinnerNoonLabel(){
    if(dinnerNoonLabel==null){

      dinnerNoonLabel = new ACLabel();

      dinnerNoonLabel.setText("昼");

      addDinnerNoonLabel();
    }
    return dinnerNoonLabel;

  }

  /**
   * 食費基準額・昼・テキストを取得します。
   * @return 食費基準額・昼・テキスト
   */
  public ACTextField getDinnerNoon(){
    if(dinnerNoon==null){

      dinnerNoon = new ACTextField();

      dinnerNoon.setBindPath("1510115");

      dinnerNoon.setColumns(3);

      dinnerNoon.setCharType(VRCharType.ONLY_DIGIT);

      dinnerNoon.setHorizontalAlignment(SwingConstants.RIGHT);

      dinnerNoon.setIMEMode(InputSubset.LATIN);

      dinnerNoon.setMaxLength(4);

      addDinnerNoon();
    }
    return dinnerNoon;

  }

  /**
   * 食費基準額・夜・ラベルを取得します。
   * @return 食費基準額・夜・ラベル
   */
  public ACLabel getDinnerNightLabel(){
    if(dinnerNightLabel==null){

      dinnerNightLabel = new ACLabel();

      dinnerNightLabel.setText("夜");

      addDinnerNightLabel();
    }
    return dinnerNightLabel;

  }

  /**
   * 食費基準額・夜・テキストを取得します。
   * @return 食費基準額・夜・テキスト
   */
  public ACTextField getDinnerNight(){
    if(dinnerNight==null){

      dinnerNight = new ACTextField();

      dinnerNight.setBindPath("1510116");

      dinnerNight.setColumns(3);

      dinnerNight.setCharType(VRCharType.ONLY_DIGIT);

      dinnerNight.setHorizontalAlignment(SwingConstants.RIGHT);

      dinnerNight.setIMEMode(InputSubset.LATIN);

      dinnerNight.setMaxLength(4);

      addDinnerNight();
    }
    return dinnerNight;

  }

  /**
   * 食費基準額・ラベルを取得します。
   * @return 食費基準額・ラベル
   */
  public ACLabel getDinnerDenomination(){
    if(dinnerDenomination==null){

      dinnerDenomination = new ACLabel();

      dinnerDenomination.setText("（円）");

      addDinnerDenomination();
    }
    return dinnerDenomination;

  }

  /**
   * ユニット型個室基準額・コンテナを取得します。
   * @return ユニット型個室基準額・コンテナ
   */
  public ACLabelContainer getUnitRoomContainer(){
    if(unitRoomContainer==null){

      unitRoomContainer = new ACLabelContainer();

      unitRoomContainer.setText("ユニット型個室");

      unitRoomContainer.setFollowChildEnabled(true);

      addUnitRoomContainer();
    }
    return unitRoomContainer;

  }

  /**
   * ユニット型個室基準額・テキストを取得します。
   * @return ユニット型個室基準額・テキスト
   */
  public ACTextField getUnitRoom(){
    if(unitRoom==null){

      unitRoom = new ACTextField();

      unitRoom.setBindPath("1510117");

      unitRoom.setColumns(4);

      unitRoom.setCharType(VRCharType.ONLY_DIGIT);

      unitRoom.setHorizontalAlignment(SwingConstants.RIGHT);

      unitRoom.setIMEMode(InputSubset.LATIN);

      unitRoom.setMaxLength(4);

      addUnitRoom();
    }
    return unitRoom;

  }

  /**
   * ユニット型個室基準額・ラベルを取得します。
   * @return ユニット型個室基準額・ラベル
   */
  public ACLabel getUnitRoomLabel(){
    if(unitRoomLabel==null){

      unitRoomLabel = new ACLabel();

      unitRoomLabel.setText("（円）");

      addUnitRoomLabel();
    }
    return unitRoomLabel;

  }

  /**
   * ユニット型個室的多床室基準額・コンテナを取得します。
   * @return ユニット型個室的多床室基準額・コンテナ
   */
  public ACLabelContainer getUnitSemiRoomContainer(){
    if(unitSemiRoomContainer==null){

      unitSemiRoomContainer = new ACLabelContainer();

      unitSemiRoomContainer.setText("ユニット型個室的多床室");

      unitSemiRoomContainer.setFollowChildEnabled(true);

      addUnitSemiRoomContainer();
    }
    return unitSemiRoomContainer;

  }

  /**
   * ユニット型個室的多床室基準額・テキストを取得します。
   * @return ユニット型個室的多床室基準額・テキスト
   */
  public ACTextField getUnitSemiRoom(){
    if(unitSemiRoom==null){

      unitSemiRoom = new ACTextField();

      unitSemiRoom.setBindPath("1510118");

      unitSemiRoom.setColumns(4);

      unitSemiRoom.setCharType(VRCharType.ONLY_DIGIT);

      unitSemiRoom.setHorizontalAlignment(SwingConstants.RIGHT);

      unitSemiRoom.setIMEMode(InputSubset.LATIN);

      unitSemiRoom.setMaxLength(4);

      addUnitSemiRoom();
    }
    return unitSemiRoom;

  }

  /**
   * ユニット型個室的多床室基準額・ラベルを取得します。
   * @return ユニット型個室的多床室基準額・ラベル
   */
  public ACLabel getUnitSemiRoomLabel(){
    if(unitSemiRoomLabel==null){

      unitSemiRoomLabel = new ACLabel();

      unitSemiRoomLabel.setText("（円）");

      addUnitSemiRoomLabel();
    }
    return unitSemiRoomLabel;

  }

  /**
   * 従来型個室基準額・コンテナを取得します。
   * @return 従来型個室基準額・コンテナ
   */
  public ACLabelContainer getNormalRoomContainer(){
    if(normalRoomContainer==null){

      normalRoomContainer = new ACLabelContainer();

      normalRoomContainer.setText("従来型個室");

      normalRoomContainer.setFollowChildEnabled(true);

      addNormalRoomContainer();
    }
    return normalRoomContainer;

  }

  /**
   * 従来型個室基準額・テキストを取得します。
   * @return 従来型個室基準額・テキスト
   */
  public ACTextField getNormalRoom(){
    if(normalRoom==null){

      normalRoom = new ACTextField();

      normalRoom.setBindPath("1510119");

      normalRoom.setColumns(4);

      normalRoom.setCharType(VRCharType.ONLY_DIGIT);

      normalRoom.setHorizontalAlignment(SwingConstants.RIGHT);

      normalRoom.setIMEMode(InputSubset.LATIN);

      normalRoom.setMaxLength(4);

      addNormalRoom();
    }
    return normalRoom;

  }

  /**
   * 従来型個室基準額・ラベルを取得します。
   * @return 従来型個室基準額・ラベル
   */
  public ACLabel getNormalRoomLabel(){
    if(normalRoomLabel==null){

      normalRoomLabel = new ACLabel();

      normalRoomLabel.setText("（円）");

      addNormalRoomLabel();
    }
    return normalRoomLabel;

  }

  /**
   * 多床室基準額・コンテナを取得します。
   * @return 多床室基準額・コンテナ
   */
  public ACLabelContainer getTasyouRoomContainer(){
    if(tasyouRoomContainer==null){

      tasyouRoomContainer = new ACLabelContainer();

      tasyouRoomContainer.setText("多床室");

      tasyouRoomContainer.setFollowChildEnabled(true);

      addTasyouRoomContainer();
    }
    return tasyouRoomContainer;

  }

  /**
   * 多床室基準額・テキストを取得します。
   * @return 多床室基準額・テキスト
   */
  public ACTextField getTasyouRoom(){
    if(tasyouRoom==null){

      tasyouRoom = new ACTextField();

      tasyouRoom.setBindPath("1510120");

      tasyouRoom.setColumns(4);

      tasyouRoom.setCharType(VRCharType.ONLY_DIGIT);

      tasyouRoom.setHorizontalAlignment(SwingConstants.RIGHT);

      tasyouRoom.setIMEMode(InputSubset.LATIN);

      tasyouRoom.setMaxLength(4);

      addTasyouRoom();
    }
    return tasyouRoom;

  }

  /**
   * 多床室基準額・ラベルを取得します。
   * @return 多床室基準額・ラベル
   */
  public ACLabel getTasyouRoomLabel(){
    if(tasyouRoomLabel==null){

      tasyouRoomLabel = new ACLabel();

      tasyouRoomLabel.setText("（円）");

      addTasyouRoomLabel();
    }
    return tasyouRoomLabel;

  }

  /**
   * コンストラクタです。
   */
  public QO004_15111_201804Design() {

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

    this.add(getMainGroup(), VRLayout.CLIENT);

  }

  /**
   * 事業グループに内部項目を追加します。
   */
  protected void addMainGroup(){

    mainGroup.add(getTab(), VRLayout.CLIENT);

  }

  /**
   * タブに内部項目を追加します。
   */
  protected void addTab(){

    tab.addTab("1", getPanel1());

    tab.addTab("2", getPanel2());

    tab.addTab("3", getPanel3());

  }

  /**
   * パネル1に内部項目を追加します。
   */
  protected void addPanel1(){

    panel1.add(getCalculationDetails1(), VRLayout.NORTH);

  }

  /**
   * 算定項目領域1に内部項目を追加します。
   */
  protected void addCalculationDetails1(){

    calculationDetails1.add(getFacilitiesDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails1.add(getNightWorkDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails1.add(getStaffLackContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails1.add(getUnitCareMaintenanceContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails1.add(getBodyRestraintAbolitionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails1.add(getDailyLifeContinuanceRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails1.add(getNurseStructuralAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails1.add(getNurseStructuralAddRadio2GroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails1.add(getNightStaffDispositionAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails1.add(getKaigoRobotRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails1.add(getSemiUnitCareMaintenanceContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails1.add(getSeikatsuKinouGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails1.add(getFunctionTrainingGuidanceSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 施設区分ラジオグループに内部項目を追加します。
   */
  protected void addFacilitiesDivision(){

  }

  /**
   * 施設区分ラジオグループモデルに内部項目を追加します。
   */
  protected void addFacilitiesDivisionModel(){

    getFacilitiesDivisionItem1().setButtonIndex(1);

    getFacilitiesDivisionModel().add(getFacilitiesDivisionItem1());

    getFacilitiesDivisionItem2().setButtonIndex(2);

    getFacilitiesDivisionModel().add(getFacilitiesDivisionItem2());

    getFacilitiesDivisionItem3().setButtonIndex(3);

    getFacilitiesDivisionModel().add(getFacilitiesDivisionItem3());

    getFacilitiesDivisionItem4().setButtonIndex(4);

    getFacilitiesDivisionModel().add(getFacilitiesDivisionItem4());

  }

  /**
   * 介護福祉施設に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem1(){

  }

  /**
   * 経過的小規模介護福祉施設に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem2(){

  }

  /**
   * ユニット型介護福祉施設に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem3(){

  }

  /**
   * ユニット型経過的小規模介護福祉施設に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem4(){

  }

  /**
   * 夜間勤務条件基準ラジオグループに内部項目を追加します。
   */
  protected void addNightWorkDivision(){

  }

  /**
   * 夜間勤務条件基準ラジオグループモデルに内部項目を追加します。
   */
  protected void addNightWorkDivisionModel(){

    getNightWorkDivisionItem1().setButtonIndex(1);

    getNightWorkDivisionModel().add(getNightWorkDivisionItem1());

    getNightWorkDivisionItem2().setButtonIndex(2);

    getNightWorkDivisionModel().add(getNightWorkDivisionItem2());

  }

  /**
   * 基準型に内部項目を追加します。
   */
  protected void addNightWorkDivisionItem1(){

  }

  /**
   * 減算型に内部項目を追加します。
   */
  protected void addNightWorkDivisionItem2(){

  }

  /**
   * 職員の欠員による減算の状況ラジオグループに内部項目を追加します。
   */
  protected void addStaffLack(){

  }

  /**
   * 職員の欠員による減算の状況ラジオグループモデルに内部項目を追加します。
   */
  protected void addStaffLackModel(){

    getStaffLackItem1().setButtonIndex(1);

    getStaffLackModel().add(getStaffLackItem1());

    getStaffLackItem2().setButtonIndex(2);

    getStaffLackModel().add(getStaffLackItem2());

    getStaffLackItem3().setButtonIndex(3);

    getStaffLackModel().add(getStaffLackItem3());

    getStaffLackItem4().setButtonIndex(4);

    getStaffLackModel().add(getStaffLackItem4());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addStaffLackItem1(){

  }

  /**
   * 看護職員に内部項目を追加します。
   */
  protected void addStaffLackItem2(){

  }

  /**
   * 介護職員に内部項目を追加します。
   */
  protected void addStaffLackItem3(){

  }

  /**
   * 介護支援専門員に内部項目を追加します。
   */
  protected void addStaffLackItem4(){

  }

  /**
   * ユニットケア体制に内部項目を追加します。
   */
  protected void addUnitCareMaintenance(){

  }

  /**
   * ユニットケア体制モデルに内部項目を追加します。
   */
  protected void addUnitCareMaintenanceModel(){

    getUnitCareMaintenanceItem1().setButtonIndex(1);

    getUnitCareMaintenanceModel().add(getUnitCareMaintenanceItem1());

    getUnitCareMaintenanceItem2().setButtonIndex(2);

    getUnitCareMaintenanceModel().add(getUnitCareMaintenanceItem2());

  }

  /**
   * 対応不可に内部項目を追加します。
   */
  protected void addUnitCareMaintenanceItem1(){

  }

  /**
   * 対応可に内部項目を追加します。
   */
  protected void addUnitCareMaintenanceItem2(){

  }

  /**
   * 身体拘束廃止取組の有無に内部項目を追加します。
   */
  protected void addBodyRestraintAbolition(){

  }

  /**
   * 身体拘束廃止取組の有無モデルに内部項目を追加します。
   */
  protected void addBodyRestraintAbolitionModel(){

    getBodyRestraintAbolitionItem1().setButtonIndex(1);

    getBodyRestraintAbolitionModel().add(getBodyRestraintAbolitionItem1());

    getBodyRestraintAbolitionItem2().setButtonIndex(2);

    getBodyRestraintAbolitionModel().add(getBodyRestraintAbolitionItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addBodyRestraintAbolitionItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addBodyRestraintAbolitionItem2(){

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
   * 看護体制加算Iに内部項目を追加します。
   */
  protected void addNurseStructuralAddRadioGroup(){

  }

  /**
   * 看護体制加算Iモデルに内部項目を追加します。
   */
  protected void addNurseStructuralAddRadioGroupModel(){

    getNurseStructuralAddRadioItem1().setButtonIndex(1);

    getNurseStructuralAddRadioGroupModel().add(getNurseStructuralAddRadioItem1());

    getNurseStructuralAddRadioItem2().setButtonIndex(2);

    getNurseStructuralAddRadioGroupModel().add(getNurseStructuralAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addNurseStructuralAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addNurseStructuralAddRadioItem2(){

  }

  /**
   * 看護体制加算IIに内部項目を追加します。
   */
  protected void addNurseStructuralAddRadio2Group(){

  }

  /**
   * 看護体制加算IIモデルに内部項目を追加します。
   */
  protected void addNurseStructuralAddRadio2GroupModel(){

    getNurseStructuralAddRadio2Item1().setButtonIndex(1);

    getNurseStructuralAddRadio2GroupModel().add(getNurseStructuralAddRadio2Item1());

    getNurseStructuralAddRadio2Item2().setButtonIndex(2);

    getNurseStructuralAddRadio2GroupModel().add(getNurseStructuralAddRadio2Item2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addNurseStructuralAddRadio2Item1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addNurseStructuralAddRadio2Item2(){

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

    getNightStaffDispositionAddRadioItem3().setButtonIndex(3);

    getNightStaffDispositionAddRadioGroupModel().add(getNightStaffDispositionAddRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addNightStaffDispositionAddRadioItem1(){

  }

  /**
   * 加算I・加算IIに内部項目を追加します。
   */
  protected void addNightStaffDispositionAddRadioItem2(){

  }

  /**
   * 加算III・加算IVに内部項目を追加します。
   */
  protected void addNightStaffDispositionAddRadioItem3(){

  }

  /**
   * 介護ロボットの導入に内部項目を追加します。
   */
  protected void addKaigoRobotRadioGroup(){

  }

  /**
   * 介護ロボットの導入モデルに内部項目を追加します。
   */
  protected void addKaigoRobotRadioGroupModel(){

    getKaigoRobotRadioItem1().setButtonIndex(1);

    getKaigoRobotRadioGroupModel().add(getKaigoRobotRadioItem1());

    getKaigoRobotRadioItem2().setButtonIndex(2);

    getKaigoRobotRadioGroupModel().add(getKaigoRobotRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoRobotRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addKaigoRobotRadioItem2(){

  }

  /**
   * 準ユニットケア体制に内部項目を追加します。
   */
  protected void addSemiUnitCareMaintenance(){

  }

  /**
   * 準ユニットケア体制モデルに内部項目を追加します。
   */
  protected void addSemiUnitCareMaintenanceModel(){

    getSemiUnitCareMaintenanceItem1().setButtonIndex(1);

    getSemiUnitCareMaintenanceModel().add(getSemiUnitCareMaintenanceItem1());

    getSemiUnitCareMaintenanceItem2().setButtonIndex(2);

    getSemiUnitCareMaintenanceModel().add(getSemiUnitCareMaintenanceItem2());

  }

  /**
   * 対応不可に内部項目を追加します。
   */
  protected void addSemiUnitCareMaintenanceItem1(){

  }

  /**
   * 対応可に内部項目を追加します。
   */
  protected void addSemiUnitCareMaintenanceItem2(){

  }

  /**
   * 生活機能向上連携加算に内部項目を追加します。
   */
  protected void addSeikatsuKinouGroup(){

  }

  /**
   * 生活機能向上連携加算モデルに内部項目を追加します。
   */
  protected void addSeikatsuKinouGroupModel(){

    getSeikatsuKinouGroupItem1().setButtonIndex(1);

    getSeikatsuKinouGroupModel().add(getSeikatsuKinouGroupItem1());

    getSeikatsuKinouGroupItem2().setButtonIndex(2);

    getSeikatsuKinouGroupModel().add(getSeikatsuKinouGroupItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addSeikatsuKinouGroupItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addSeikatsuKinouGroupItem2(){

  }

  /**
   * 個別機能訓練体制ラジオグループに内部項目を追加します。
   */
  protected void addFunctionTrainingGuidanceSystem(){

  }

  /**
   * 個別機能訓練体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addFunctionTrainingGuidanceSystemModel(){

    getFunctionTrainingGuidanceSystemItem1().setButtonIndex(1);

    getFunctionTrainingGuidanceSystemModel().add(getFunctionTrainingGuidanceSystemItem1());

    getFunctionTrainingGuidanceSystemItem3().setButtonIndex(2);

    getFunctionTrainingGuidanceSystemModel().add(getFunctionTrainingGuidanceSystemItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addFunctionTrainingGuidanceSystemItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addFunctionTrainingGuidanceSystemItem3(){

  }

  /**
   * パネル2に内部項目を追加します。
   */
  protected void addPanel2(){

    panel2.add(getCalculationDetails2(), VRLayout.NORTH);

    panel2.add(getCalculationDetails3(), VRLayout.NORTH);

  }

  /**
   * 算定項目領域2に内部項目を追加します。
   */
  protected void addCalculationDetails2(){

    calculationDetails2.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getStandingDoctorAssignmentContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getPsychiatristGuidanceContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getHandicappedPersonSupportContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getNourishmentImprovementContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getMedicalFoodAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getPlacementDoctorEmergencyContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getTerminalCareContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getHomeAndFacilityContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getDementiaProfessionalCareAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getPressureUlcerManagementContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getStaffUpgradeRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * 常勤専従医師配置ラジオグループに内部項目を追加します。
   */
  protected void addStandingDoctorAssignment(){

  }

  /**
   * 常勤専従医師配置ラジオグループモデルに内部項目を追加します。
   */
  protected void addStandingDoctorAssignmentModel(){

    getStandingDoctorAssignmentItem1().setButtonIndex(1);

    getStandingDoctorAssignmentModel().add(getStandingDoctorAssignmentItem1());

    getStandingDoctorAssignmentItem2().setButtonIndex(2);

    getStandingDoctorAssignmentModel().add(getStandingDoctorAssignmentItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addStandingDoctorAssignmentItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addStandingDoctorAssignmentItem2(){

  }

  /**
   * 精神科医師定期的療養指導ラジオグループに内部項目を追加します。
   */
  protected void addPsychiatristGuidance(){

  }

  /**
   * 精神科医師定期的療養指導ラジオグループモデルに内部項目を追加します。
   */
  protected void addPsychiatristGuidanceModel(){

    getPsychiatristGuidanceItem1().setButtonIndex(1);

    getPsychiatristGuidanceModel().add(getPsychiatristGuidanceItem1());

    getPsychiatristGuidanceItem2().setButtonIndex(2);

    getPsychiatristGuidanceModel().add(getPsychiatristGuidanceItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addPsychiatristGuidanceItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addPsychiatristGuidanceItem2(){

  }

  /**
   * 障害者生活支援体制ラジオグループに内部項目を追加します。
   */
  protected void addHandicappedPersonSupport(){

  }

  /**
   * 障害者生活支援体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addHandicappedPersonSupportModel(){

    getHandicappedPersonSupportItem1().setButtonIndex(1);

    getHandicappedPersonSupportModel().add(getHandicappedPersonSupportItem1());

    getHandicappedPersonSupportItem2().setButtonIndex(2);

    getHandicappedPersonSupportModel().add(getHandicappedPersonSupportItem2());

    getHandicappedPersonSupportItem3().setButtonIndex(3);

    getHandicappedPersonSupportModel().add(getHandicappedPersonSupportItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHandicappedPersonSupportItem1(){

  }

  /**
   * 加算Iに内部項目を追加します。
   */
  protected void addHandicappedPersonSupportItem2(){

  }

  /**
   * 加算IIに内部項目を追加します。
   */
  protected void addHandicappedPersonSupportItem3(){

  }

  /**
   * 栄養マネジメント体制に内部項目を追加します。
   */
  protected void addNourishmentImprovement(){

  }

  /**
   * 栄養マネジメント体制モデルに内部項目を追加します。
   */
  protected void addNourishmentImprovementModel(){

    getNourishmentImprovementAddItem1().setButtonIndex(1);

    getNourishmentImprovementModel().add(getNourishmentImprovementAddItem1());

    getNourishmentImprovementAddItem2().setButtonIndex(2);

    getNourishmentImprovementModel().add(getNourishmentImprovementAddItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addNourishmentImprovementAddItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addNourishmentImprovementAddItem2(){

  }

  /**
   * 療養食加算に内部項目を追加します。
   */
  protected void addMedicalFoodAddRadioGroup(){

  }

  /**
   * 療養食加算モデルに内部項目を追加します。
   */
  protected void addMedicalFoodAddRadioGroupModel(){

    getMedicalFoodAddRadioItem1().setButtonIndex(1);

    getMedicalFoodAddRadioGroupModel().add(getMedicalFoodAddRadioItem1());

    getMedicalFoodAddRadioItem2().setButtonIndex(2);

    getMedicalFoodAddRadioGroupModel().add(getMedicalFoodAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalFoodAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMedicalFoodAddRadioItem2(){

  }

  /**
   * 配置医師緊急時対応加算に内部項目を追加します。
   */
  protected void addPlacementDoctorEmergency(){

  }

  /**
   * 配置医師緊急時対応加算モデルに内部項目を追加します。
   */
  protected void addPlacementDoctorEmergencyModel(){

    getPlacementDoctorEmergencyItem1().setButtonIndex(1);

    getPlacementDoctorEmergencyModel().add(getPlacementDoctorEmergencyItem1());

    getPlacementDoctorEmergencyItem2().setButtonIndex(2);

    getPlacementDoctorEmergencyModel().add(getPlacementDoctorEmergencyItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addPlacementDoctorEmergencyItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addPlacementDoctorEmergencyItem2(){

  }

  /**
   * 看取り介護体制に内部項目を追加します。
   */
  protected void addTerminalCare(){

  }

  /**
   * 看取り介護体制モデルに内部項目を追加します。
   */
  protected void addTerminalCareModel(){

    getTerminalCareItem1().setButtonIndex(1);

    getTerminalCareModel().add(getTerminalCareItem1());

    getTerminalCareItem2().setButtonIndex(2);

    getTerminalCareModel().add(getTerminalCareItem2());

    getTerminalCareItem3().setButtonIndex(3);

    getTerminalCareModel().add(getTerminalCareItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTerminalCareItem1(){

  }

  /**
   * 加算Iに内部項目を追加します。
   */
  protected void addTerminalCareItem2(){

  }

  /**
   * 加算IIに内部項目を追加します。
   */
  protected void addTerminalCareItem3(){

  }

  /**
   * 在宅・入所相互利用体制に内部項目を追加します。
   */
  protected void addHomeAndFacility(){

  }

  /**
   * 在宅・入所相互利用体制モデルに内部項目を追加します。
   */
  protected void addHomeAndFacilityModel(){

    getHomeAndFacilityItem1().setButtonIndex(1);

    getHomeAndFacilityModel().add(getHomeAndFacilityItem1());

    getHomeAndFacilityItem2().setButtonIndex(2);

    getHomeAndFacilityModel().add(getHomeAndFacilityItem2());

  }

  /**
   * 対応不可に内部項目を追加します。
   */
  protected void addHomeAndFacilityItem1(){

  }

  /**
   * 対応可に内部項目を追加します。
   */
  protected void addHomeAndFacilityItem2(){

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
   * 加算Iに内部項目を追加します。
   */
  protected void addDementiaProfessionalCareAddRadioItem2(){

  }

  /**
   * 加算IIに内部項目を追加します。
   */
  protected void addDementiaProfessionalCareAddRadioItem3(){

  }

  /**
   * 褥瘡マネジメント加算に内部項目を追加します。
   */
  protected void addPressureUlcerManagement(){

  }

  /**
   * 褥瘡マネジメント加算モデルに内部項目を追加します。
   */
  protected void addPressureUlcerManagementModel(){

    getPressureUlcerManagementItem1().setButtonIndex(1);

    getPressureUlcerManagementModel().add(getPressureUlcerManagementItem1());

    getPressureUlcerManagementItem2().setButtonIndex(2);

    getPressureUlcerManagementModel().add(getPressureUlcerManagementItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addPressureUlcerManagementItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addPressureUlcerManagementItem2(){

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

    getServiceAddProvisionStructuralRadioItem2().setButtonIndex(5);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem2());

    getServiceAddProvisionStructuralRadioItem3().setButtonIndex(2);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem3());

    getServiceAddProvisionStructuralRadioItem4().setButtonIndex(3);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem4());

    getServiceAddProvisionStructuralRadioItem5().setButtonIndex(4);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem5());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem1(){

  }

  /**
   * 加算Iイに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem2(){

  }

  /**
   * 加算Iロに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem3(){

  }

  /**
   * 加算IIに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem4(){

  }

  /**
   * 加算IIIに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem5(){

  }

  /**
   * 介護職員処遇改善加算に内部項目を追加します。
   */
  protected void addStaffUpgradeRadioGroup(){

  }

  /**
   * 介護職員処遇改善加算モデルに内部項目を追加します。
   */
  protected void addStaffUpgradeRadioGroupModel(){

    getStaffUpgradeRadioItem1().setButtonIndex(1);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem1());

    getStaffUpgradeRadioItem2().setButtonIndex(6);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem2());

    getStaffUpgradeRadioItem3().setButtonIndex(5);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem3());

    getStaffUpgradeRadioItem4().setButtonIndex(2);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem4());

    getStaffUpgradeRadioItem5().setButtonIndex(3);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem5());

    getStaffUpgradeRadioItem6().setButtonIndex(4);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem6());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addStaffUpgradeRadioItem1(){

  }

  /**
   * 加算Iに内部項目を追加します。
   */
  protected void addStaffUpgradeRadioItem2(){

  }

  /**
   * 加算IIに内部項目を追加します。
   */
  protected void addStaffUpgradeRadioItem3(){

  }

  /**
   * 加算IIIに内部項目を追加します。
   */
  protected void addStaffUpgradeRadioItem4(){

  }

  /**
   * 加算IVに内部項目を追加します。
   */
  protected void addStaffUpgradeRadioItem5(){

  }

  /**
   * 加算Vに内部項目を追加します。
   */
  protected void addStaffUpgradeRadioItem6(){

  }

  /**
   * 算定項目領域3に内部項目を追加します。
   */
  protected void addCalculationDetails3(){

    calculationDetails3.add(getReduceRateContainer(), VRLayout.FLOW_INSETLINE);

    calculationDetails3.add(getShahukuReduce(), VRLayout.FLOW_RETURN);

  }

  /**
   * 割引率コンテナに内部項目を追加します。
   */
  protected void addReduceRateContainer(){

    reduceRateContainer.add(getReduceRate(), VRLayout.FLOW);

    reduceRateContainer.add(getPercentSign(), VRLayout.FLOW);

  }

  /**
   * 割引率に内部項目を追加します。
   */
  protected void addReduceRate(){

  }

  /**
   * ％ラベルに内部項目を追加します。
   */
  protected void addPercentSign(){

  }

  /**
   * 社福減免対象事業者に内部項目を追加します。
   */
  protected void addShahukuReduce(){

  }

  /**
   * パネル3に内部項目を追加します。
   */
  protected void addPanel3(){

    panel3.add(getStandardMoneyGroup(), VRLayout.NORTH);

  }

  /**
   * 基準額グループに内部項目を追加します。
   */
  protected void addStandardMoneyGroup(){

    standardMoneyGroup.add(getDinnerContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    standardMoneyGroup.add(getUnitRoomContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    standardMoneyGroup.add(getUnitSemiRoomContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    standardMoneyGroup.add(getNormalRoomContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    standardMoneyGroup.add(getTasyouRoomContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 食費基準額・コンテナに内部項目を追加します。
   */
  protected void addDinnerContainer(){

    dinnerContainer.add(getDinnerTotal(), VRLayout.FLOW);

    dinnerContainer.add(getDinnerDetailsContainer(), VRLayout.FLOW);

  }

  /**
   * 食費基準額・合計・テキストに内部項目を追加します。
   */
  protected void addDinnerTotal(){

  }

  /**
   * 食費基準額・内訳・コンテナに内部項目を追加します。
   */
  protected void addDinnerDetailsContainer(){

    dinnerDetailsContainer.add(getDinnerMorningLabel(), VRLayout.FLOW);

    dinnerDetailsContainer.add(getDinnerMorning(), VRLayout.FLOW);

    dinnerDetailsContainer.add(getDinnerNoonLabel(), VRLayout.FLOW);

    dinnerDetailsContainer.add(getDinnerNoon(), VRLayout.FLOW);

    dinnerDetailsContainer.add(getDinnerNightLabel(), VRLayout.FLOW);

    dinnerDetailsContainer.add(getDinnerNight(), VRLayout.FLOW);

    dinnerDetailsContainer.add(getDinnerDenomination(), VRLayout.FLOW);

  }

  /**
   * 食費基準額・朝・ラベルに内部項目を追加します。
   */
  protected void addDinnerMorningLabel(){

  }

  /**
   * 食費基準額・朝・テキストに内部項目を追加します。
   */
  protected void addDinnerMorning(){

  }

  /**
   * 食費基準額・昼・ラベルに内部項目を追加します。
   */
  protected void addDinnerNoonLabel(){

  }

  /**
   * 食費基準額・昼・テキストに内部項目を追加します。
   */
  protected void addDinnerNoon(){

  }

  /**
   * 食費基準額・夜・ラベルに内部項目を追加します。
   */
  protected void addDinnerNightLabel(){

  }

  /**
   * 食費基準額・夜・テキストに内部項目を追加します。
   */
  protected void addDinnerNight(){

  }

  /**
   * 食費基準額・ラベルに内部項目を追加します。
   */
  protected void addDinnerDenomination(){

  }

  /**
   * ユニット型個室基準額・コンテナに内部項目を追加します。
   */
  protected void addUnitRoomContainer(){

    unitRoomContainer.add(getUnitRoom(), null);

    unitRoomContainer.add(getUnitRoomLabel(), null);

  }

  /**
   * ユニット型個室基準額・テキストに内部項目を追加します。
   */
  protected void addUnitRoom(){

  }

  /**
   * ユニット型個室基準額・ラベルに内部項目を追加します。
   */
  protected void addUnitRoomLabel(){

  }

  /**
   * ユニット型個室的多床室基準額・コンテナに内部項目を追加します。
   */
  protected void addUnitSemiRoomContainer(){

    unitSemiRoomContainer.add(getUnitSemiRoom(), null);

    unitSemiRoomContainer.add(getUnitSemiRoomLabel(), null);

  }

  /**
   * ユニット型個室的多床室基準額・テキストに内部項目を追加します。
   */
  protected void addUnitSemiRoom(){

  }

  /**
   * ユニット型個室的多床室基準額・ラベルに内部項目を追加します。
   */
  protected void addUnitSemiRoomLabel(){

  }

  /**
   * 従来型個室基準額・コンテナに内部項目を追加します。
   */
  protected void addNormalRoomContainer(){

    normalRoomContainer.add(getNormalRoom(), null);

    normalRoomContainer.add(getNormalRoomLabel(), null);

  }

  /**
   * 従来型個室基準額・テキストに内部項目を追加します。
   */
  protected void addNormalRoom(){

  }

  /**
   * 従来型個室基準額・ラベルに内部項目を追加します。
   */
  protected void addNormalRoomLabel(){

  }

  /**
   * 多床室基準額・コンテナに内部項目を追加します。
   */
  protected void addTasyouRoomContainer(){

    tasyouRoomContainer.add(getTasyouRoom(), null);

    tasyouRoomContainer.add(getTasyouRoomLabel(), null);

  }

  /**
   * 多床室基準額・テキストに内部項目を追加します。
   */
  protected void addTasyouRoom(){

  }

  /**
   * 多床室基準額・ラベルに内部項目を追加します。
   */
  protected void addTasyouRoomLabel(){

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
      ACFrame.debugStart(new ACAffairInfo(QO004_15111_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004_15111_201804Design getThis() {
    return this;
  }
}
