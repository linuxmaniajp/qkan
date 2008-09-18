
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
 * 開発者: 松本　幸一
 * 作成日: 2006/03/09  日本コンピューター株式会社 松本　幸一 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業者登録 (004)
 * プログラム 介護老人福祉施設 (QO004118)
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
import jp.or.med.orca.qkan.affair.qs.qs001.QS001ServicePanel;
import jp.or.med.orca.qkan.component.*;
import jp.or.med.orca.qkan.lib.*;
import jp.or.med.orca.qkan.text.*;
/**
 * 介護老人福祉施設画面項目デザイン(QO004118) 
 */
public class QO004118Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACGroupBox mainGroup;

  private JTabbedPane tab;

  private ACPanel panel1;

  private ACPanel calculationDetails1;

  private ACClearableRadioButtonGroup facilitiesDivision;

  private ACLabelContainer facilitiesDivisionContainer;

  private ACListModelAdapter facilitiesDivisionModel;

  private ACRadioButtonItem facilitiesDivisionItem1;

  private ACRadioButtonItem facilitiesDivisionItem2;

  private ACRadioButtonItem facilitiesDivisionItem3;

  private ACRadioButtonItem facilitiesDivisionItem4;

  private ACClearableRadioButtonGroup nightWorkDivision;

  private ACLabelContainer nightWorkDivisionContainer;

  private ACListModelAdapter nightWorkDivisionModel;

  private ACRadioButtonItem nightWorkDivisionItem1;

  private ACRadioButtonItem nightWorkDivisionItem2;

  private ACClearableRadioButtonGroup staffLack;

  private ACLabelContainer staffLackContainer;

  private ACListModelAdapter staffLackModel;

  private ACRadioButtonItem staffLackItem1;

  private ACRadioButtonItem staffLackItem2;

  private ACRadioButtonItem staffLackItem3;

  private ACRadioButtonItem staffLackItem4;

  private ACClearableRadioButtonGroup unitCareMaintenance;

  private ACLabelContainer unitCareMaintenanceContainer;

  private ACListModelAdapter unitCareMaintenanceModel;

  private ACRadioButtonItem unitCareMaintenanceItem1;

  private ACRadioButtonItem unitCareMaintenanceItem2;

  private ACClearableRadioButtonGroup heavilyCorrespondenceAdd;

  private ACLabelContainer heavilyCorrespondenceAddContainer;

  private ACListModelAdapter heavilyCorrespondenceAddModel;

  private ACRadioButtonItem heavilyCorrespondenceAddItem1;

  private ACRadioButtonItem heavilyCorrespondenceAddItem2;

  private ACClearableRadioButtonGroup semiUnitCareMaintenance;

  private ACLabelContainer semiUnitCareMaintenanceContainer;

  private ACListModelAdapter semiUnitCareMaintenanceModel;

  private ACRadioButtonItem semiUnitCareMaintenanceItem1;

  private ACRadioButtonItem semiUnitCareMaintenanceItem2;

  private ACClearableRadioButtonGroup functionTrainingGuidanceSystem;

  private ACLabelContainer functionTrainingGuidanceSystemContainer;

  private ACListModelAdapter functionTrainingGuidanceSystemModel;

  private ACRadioButtonItem functionTrainingGuidanceSystemItem1;

  private ACRadioButtonItem functionTrainingGuidanceSystemItem2;

  private ACClearableRadioButtonGroup standingDoctorAssignment;

  private ACLabelContainer standingDoctorAssignmentContainer;

  private ACListModelAdapter standingDoctorAssignmentModel;

  private ACRadioButtonItem standingDoctorAssignmentItem1;

  private ACRadioButtonItem standingDoctorAssignmentItem2;

  private ACClearableRadioButtonGroup psychiatristGuidance;

  private ACLabelContainer psychiatristGuidanceContainer;

  private ACListModelAdapter psychiatristGuidanceModel;

  private ACRadioButtonItem psychiatristGuidanceItem1;

  private ACRadioButtonItem psychiatristGuidanceItem2;

  private ACClearableRadioButtonGroup handicappedPersonSupport;

  private ACLabelContainer handicappedPersonSupportContainer;

  private ACListModelAdapter handicappedPersonSupportModel;

  private ACRadioButtonItem handicappedPersonSupportItem1;

  private ACRadioButtonItem handicappedPersonSupportItem2;

  private ACClearableRadioButtonGroup nourishmentControlAdd;

  private ACLabelContainer nourishmentControlAddContainer;

  private ACListModelAdapter nourishmentControlAddModel;

  private ACRadioButtonItem nourishmentControlAddItem1;

  private ACRadioButtonItem nourishmentControlAddItem2;

  private ACRadioButtonItem nourishmentControlAddItem3;

  private ACClearableRadioButtonGroup nourishmentManagementAdd;

  private ACLabelContainer nourishmentManagementAddContainer;

  private ACListModelAdapter nourishmentManagementAddModel;

  private ACRadioButtonItem nourishmentManagementAddItem1;

  private ACRadioButtonItem nourishmentManagementAddItem2;

  private ACClearableRadioButtonGroup bodyRestraintAbolition;

  private ACLabelContainer bodyRestraintAbolitionContainer;

  private ACListModelAdapter bodyRestraintAbolitionModel;

  private ACRadioButtonItem bodyRestraintAbolitionItem1;

  private ACRadioButtonItem bodyRestraintAbolitionItem2;

  private ACClearableRadioButtonGroup terminalCare;

  private ACLabelContainer terminalCareContainer;

  private ACListModelAdapter terminalCareModel;

  private ACRadioButtonItem terminalCareItem1;

  private ACRadioButtonItem terminalCareItem2;

  private ACClearableRadioButtonGroup homeAndFacility;

  private ACLabelContainer homeAndFacilityContainer;

  private ACListModelAdapter homeAndFacilityModel;

  private ACRadioButtonItem homeAndFacilityItem1;

  private ACRadioButtonItem homeAndFacilityItem2;

  private ACPanel panel2;

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

  private ACPanel calculationDetails2;

  private ACLabelContainer reduceRateContainer;

  private ACTextField reduceRate;

  private ACLabel percentSign;

  private ACIntegerCheckBox ShahukuReduce;

  //getter

  /**
   * 事業グループを取得します。
   * @return 事業グループ
   */
  public ACGroupBox getMainGroup(){
    if(mainGroup==null){

      mainGroup = new ACGroupBox();

      mainGroup.setText("介護老人福祉施設");

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
  public ACClearableRadioButtonGroup getFacilitiesDivision(){
    if(facilitiesDivision==null){

      facilitiesDivision = new ACClearableRadioButtonGroup();

      getFacilitiesDivisionContainer().setText("施設等の区分");

      facilitiesDivision.setBindPath("1510101");

      facilitiesDivision.setModel(getFacilitiesDivisionModel());

      facilitiesDivision.setUseClearButton(false);

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

      facilitiesDivisionItem1.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem1();
    }
    return facilitiesDivisionItem1;

  }

  /**
   * 小規模介護福祉施設を取得します。
   * @return 小規模介護福祉施設
   */
  public ACRadioButtonItem getFacilitiesDivisionItem2(){
    if(facilitiesDivisionItem2==null){

      facilitiesDivisionItem2 = new ACRadioButtonItem();

      facilitiesDivisionItem2.setText("小規模介護福祉施設");

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
   * ユニット型小規模介護福祉施設を取得します。
   * @return ユニット型小規模介護福祉施設
   */
  public ACRadioButtonItem getFacilitiesDivisionItem4(){
    if(facilitiesDivisionItem4==null){

      facilitiesDivisionItem4 = new ACRadioButtonItem();

      facilitiesDivisionItem4.setText("ユニット型小規模介護福祉施設");

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
  public ACClearableRadioButtonGroup getNightWorkDivision(){
    if(nightWorkDivision==null){

      nightWorkDivision = new ACClearableRadioButtonGroup();

      getNightWorkDivisionContainer().setText("夜間勤務条件基準");

      nightWorkDivision.setBindPath("1510102");

      nightWorkDivision.setModel(getNightWorkDivisionModel());

      nightWorkDivision.setUseClearButton(false);

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
  public ACClearableRadioButtonGroup getStaffLack(){
    if(staffLack==null){

      staffLack = new ACClearableRadioButtonGroup();

      getStaffLackContainer().setText("職員の欠員による減算の状況");

      staffLack.setBindPath("1510112");

      staffLack.setModel(getStaffLackModel());

      staffLack.setUseClearButton(false);

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
  public ACClearableRadioButtonGroup getUnitCareMaintenance(){
    if(unitCareMaintenance==null){

      unitCareMaintenance = new ACClearableRadioButtonGroup();

      getUnitCareMaintenanceContainer().setText("ユニットケア体制");

      unitCareMaintenance.setBindPath("1510121");

      unitCareMaintenance.setModel(getUnitCareMaintenanceModel());

      unitCareMaintenance.setUseClearButton(false);

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
   * 重度化対応体制を取得します。
   * @return 重度化対応体制
   */
  public ACClearableRadioButtonGroup getHeavilyCorrespondenceAdd(){
    if(heavilyCorrespondenceAdd==null){

      heavilyCorrespondenceAdd = new ACClearableRadioButtonGroup();

      getHeavilyCorrespondenceAddContainer().setText("重度化対応体制");

      heavilyCorrespondenceAdd.setBindPath("1510123");

      heavilyCorrespondenceAdd.setModel(getHeavilyCorrespondenceAddModel());

      heavilyCorrespondenceAdd.setUseClearButton(false);

      addHeavilyCorrespondenceAdd();
    }
    return heavilyCorrespondenceAdd;

  }

  /**
   * 重度化対応体制コンテナを取得します。
   * @return 重度化対応体制コンテナ
   */
  protected ACLabelContainer getHeavilyCorrespondenceAddContainer(){
    if(heavilyCorrespondenceAddContainer==null){
      heavilyCorrespondenceAddContainer = new ACLabelContainer();
      heavilyCorrespondenceAddContainer.setFollowChildEnabled(true);
      heavilyCorrespondenceAddContainer.setVAlignment(VRLayout.CENTER);
      heavilyCorrespondenceAddContainer.add(getHeavilyCorrespondenceAdd(), null);
    }
    return heavilyCorrespondenceAddContainer;
  }

  /**
   * 重度化対応体制モデルを取得します。
   * @return 重度化対応体制モデル
   */
  protected ACListModelAdapter getHeavilyCorrespondenceAddModel(){
    if(heavilyCorrespondenceAddModel==null){
      heavilyCorrespondenceAddModel = new ACListModelAdapter();
      addHeavilyCorrespondenceAddModel();
    }
    return heavilyCorrespondenceAddModel;
  }

  /**
   * 対応不可を取得します。
   * @return 対応不可
   */
  public ACRadioButtonItem getHeavilyCorrespondenceAddItem1(){
    if(heavilyCorrespondenceAddItem1==null){

      heavilyCorrespondenceAddItem1 = new ACRadioButtonItem();

      heavilyCorrespondenceAddItem1.setText("対応不可");

      heavilyCorrespondenceAddItem1.setGroup(getHeavilyCorrespondenceAdd());

      heavilyCorrespondenceAddItem1.setConstraints(VRLayout.FLOW);

      addHeavilyCorrespondenceAddItem1();
    }
    return heavilyCorrespondenceAddItem1;

  }

  /**
   * 対応可を取得します。
   * @return 対応可
   */
  public ACRadioButtonItem getHeavilyCorrespondenceAddItem2(){
    if(heavilyCorrespondenceAddItem2==null){

      heavilyCorrespondenceAddItem2 = new ACRadioButtonItem();

      heavilyCorrespondenceAddItem2.setText("対応可");

      heavilyCorrespondenceAddItem2.setGroup(getHeavilyCorrespondenceAdd());

      heavilyCorrespondenceAddItem2.setConstraints(VRLayout.FLOW);

      addHeavilyCorrespondenceAddItem2();
    }
    return heavilyCorrespondenceAddItem2;

  }

  /**
   * 準ユニットケア体制を取得します。
   * @return 準ユニットケア体制
   */
  public ACClearableRadioButtonGroup getSemiUnitCareMaintenance(){
    if(semiUnitCareMaintenance==null){

      semiUnitCareMaintenance = new ACClearableRadioButtonGroup();

      getSemiUnitCareMaintenanceContainer().setText("準ユニットケア体制");

      semiUnitCareMaintenance.setBindPath("1510122");

      semiUnitCareMaintenance.setModel(getSemiUnitCareMaintenanceModel());

      semiUnitCareMaintenance.setUseClearButton(false);

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
   * 個別機能訓練体制ラジオグループを取得します。
   * @return 個別機能訓練体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getFunctionTrainingGuidanceSystem(){
    if(functionTrainingGuidanceSystem==null){

      functionTrainingGuidanceSystem = new ACClearableRadioButtonGroup();

      getFunctionTrainingGuidanceSystemContainer().setText("個別機能訓練体制");

      functionTrainingGuidanceSystem.setBindPath("1510103");

      functionTrainingGuidanceSystem.setModel(getFunctionTrainingGuidanceSystemModel());

      functionTrainingGuidanceSystem.setUseClearButton(false);

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
  public ACRadioButtonItem getFunctionTrainingGuidanceSystemItem2(){
    if(functionTrainingGuidanceSystemItem2==null){

      functionTrainingGuidanceSystemItem2 = new ACRadioButtonItem();

      functionTrainingGuidanceSystemItem2.setText("あり");

      functionTrainingGuidanceSystemItem2.setGroup(getFunctionTrainingGuidanceSystem());

      addFunctionTrainingGuidanceSystemItem2();
    }
    return functionTrainingGuidanceSystemItem2;

  }

  /**
   * 常勤専従医師配置ラジオグループを取得します。
   * @return 常勤専従医師配置ラジオグループ
   */
  public ACClearableRadioButtonGroup getStandingDoctorAssignment(){
    if(standingDoctorAssignment==null){

      standingDoctorAssignment = new ACClearableRadioButtonGroup();

      getStandingDoctorAssignmentContainer().setText("常勤専従医師配置");

      standingDoctorAssignment.setBindPath("1510104");

      standingDoctorAssignment.setModel(getStandingDoctorAssignmentModel());

      standingDoctorAssignment.setUseClearButton(false);

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
  public ACClearableRadioButtonGroup getPsychiatristGuidance(){
    if(psychiatristGuidance==null){

      psychiatristGuidance = new ACClearableRadioButtonGroup();

      getPsychiatristGuidanceContainer().setText("精神科医師定期的療養指導");

      psychiatristGuidance.setBindPath("1510105");

      psychiatristGuidance.setModel(getPsychiatristGuidanceModel());

      psychiatristGuidance.setUseClearButton(false);

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
  public ACClearableRadioButtonGroup getHandicappedPersonSupport(){
    if(handicappedPersonSupport==null){

      handicappedPersonSupport = new ACClearableRadioButtonGroup();

      getHandicappedPersonSupportContainer().setText("障害者生活支援体制");

      handicappedPersonSupport.setBindPath("1510106");

      handicappedPersonSupport.setModel(getHandicappedPersonSupportModel());

      handicappedPersonSupport.setUseClearButton(false);

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
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHandicappedPersonSupportItem2(){
    if(handicappedPersonSupportItem2==null){

      handicappedPersonSupportItem2 = new ACRadioButtonItem();

      handicappedPersonSupportItem2.setText("あり");

      handicappedPersonSupportItem2.setGroup(getHandicappedPersonSupport());

      addHandicappedPersonSupportItem2();
    }
    return handicappedPersonSupportItem2;

  }

  /**
   * 栄養管理の評価ラジオグループを取得します。
   * @return 栄養管理の評価ラジオグループ
   */
  public ACClearableRadioButtonGroup getNourishmentControlAdd(){
    if(nourishmentControlAdd==null){

      nourishmentControlAdd = new ACClearableRadioButtonGroup();

      getNourishmentControlAddContainer().setText("栄養管理の評価");

      nourishmentControlAdd.setBindPath("1510108");

      nourishmentControlAdd.setModel(getNourishmentControlAddModel());

      nourishmentControlAdd.setUseClearButton(false);

      addNourishmentControlAdd();
    }
    return nourishmentControlAdd;

  }

  /**
   * 栄養管理の評価ラジオグループコンテナを取得します。
   * @return 栄養管理の評価ラジオグループコンテナ
   */
  protected ACLabelContainer getNourishmentControlAddContainer(){
    if(nourishmentControlAddContainer==null){
      nourishmentControlAddContainer = new ACLabelContainer();
      nourishmentControlAddContainer.setFollowChildEnabled(true);
      nourishmentControlAddContainer.setVAlignment(VRLayout.CENTER);
      nourishmentControlAddContainer.add(getNourishmentControlAdd(), null);
    }
    return nourishmentControlAddContainer;
  }

  /**
   * 栄養管理の評価ラジオグループモデルを取得します。
   * @return 栄養管理の評価ラジオグループモデル
   */
  protected ACListModelAdapter getNourishmentControlAddModel(){
    if(nourishmentControlAddModel==null){
      nourishmentControlAddModel = new ACListModelAdapter();
      addNourishmentControlAddModel();
    }
    return nourishmentControlAddModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getNourishmentControlAddItem1(){
    if(nourishmentControlAddItem1==null){

      nourishmentControlAddItem1 = new ACRadioButtonItem();

      nourishmentControlAddItem1.setText("なし");

      nourishmentControlAddItem1.setGroup(getNourishmentControlAdd());

      nourishmentControlAddItem1.setConstraints(VRLayout.FLOW);

      addNourishmentControlAddItem1();
    }
    return nourishmentControlAddItem1;

  }

  /**
   * 栄養士を取得します。
   * @return 栄養士
   */
  public ACRadioButtonItem getNourishmentControlAddItem2(){
    if(nourishmentControlAddItem2==null){

      nourishmentControlAddItem2 = new ACRadioButtonItem();

      nourishmentControlAddItem2.setText("栄養士");

      nourishmentControlAddItem2.setGroup(getNourishmentControlAdd());

      nourishmentControlAddItem2.setConstraints(VRLayout.FLOW);

      addNourishmentControlAddItem2();
    }
    return nourishmentControlAddItem2;

  }

  /**
   * 管理栄養士を取得します。
   * @return 管理栄養士
   */
  public ACRadioButtonItem getNourishmentControlAddItem3(){
    if(nourishmentControlAddItem3==null){

      nourishmentControlAddItem3 = new ACRadioButtonItem();

      nourishmentControlAddItem3.setText("管理栄養士");

      nourishmentControlAddItem3.setGroup(getNourishmentControlAdd());

      nourishmentControlAddItem3.setConstraints(VRLayout.FLOW_RETURN);

      addNourishmentControlAddItem3();
    }
    return nourishmentControlAddItem3;

  }

  /**
   * 栄養ケア・マネジメント体制ラジオグループを取得します。
   * @return 栄養ケア・マネジメント体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getNourishmentManagementAdd(){
    if(nourishmentManagementAdd==null){

      nourishmentManagementAdd = new ACClearableRadioButtonGroup();

      getNourishmentManagementAddContainer().setText("栄養ケア・マネジメント体制");

      nourishmentManagementAdd.setBindPath("1510109");

      nourishmentManagementAdd.setModel(getNourishmentManagementAddModel());

      nourishmentManagementAdd.setUseClearButton(false);

      addNourishmentManagementAdd();
    }
    return nourishmentManagementAdd;

  }

  /**
   * 栄養ケア・マネジメント体制ラジオグループコンテナを取得します。
   * @return 栄養ケア・マネジメント体制ラジオグループコンテナ
   */
  protected ACLabelContainer getNourishmentManagementAddContainer(){
    if(nourishmentManagementAddContainer==null){
      nourishmentManagementAddContainer = new ACLabelContainer();
      nourishmentManagementAddContainer.setFollowChildEnabled(true);
      nourishmentManagementAddContainer.setVAlignment(VRLayout.CENTER);
      nourishmentManagementAddContainer.add(getNourishmentManagementAdd(), null);
    }
    return nourishmentManagementAddContainer;
  }

  /**
   * 栄養ケア・マネジメント体制ラジオグループモデルを取得します。
   * @return 栄養ケア・マネジメント体制ラジオグループモデル
   */
  protected ACListModelAdapter getNourishmentManagementAddModel(){
    if(nourishmentManagementAddModel==null){
      nourishmentManagementAddModel = new ACListModelAdapter();
      addNourishmentManagementAddModel();
    }
    return nourishmentManagementAddModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getNourishmentManagementAddItem1(){
    if(nourishmentManagementAddItem1==null){

      nourishmentManagementAddItem1 = new ACRadioButtonItem();

      nourishmentManagementAddItem1.setText("なし");

      nourishmentManagementAddItem1.setGroup(getNourishmentManagementAdd());

      addNourishmentManagementAddItem1();
    }
    return nourishmentManagementAddItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getNourishmentManagementAddItem2(){
    if(nourishmentManagementAddItem2==null){

      nourishmentManagementAddItem2 = new ACRadioButtonItem();

      nourishmentManagementAddItem2.setText("あり");

      nourishmentManagementAddItem2.setGroup(getNourishmentManagementAdd());

      addNourishmentManagementAddItem2();
    }
    return nourishmentManagementAddItem2;

  }

  /**
   * 身体拘束廃止取組の有無を取得します。
   * @return 身体拘束廃止取組の有無
   */
  public ACClearableRadioButtonGroup getBodyRestraintAbolition(){
    if(bodyRestraintAbolition==null){

      bodyRestraintAbolition = new ACClearableRadioButtonGroup();

      getBodyRestraintAbolitionContainer().setText("身体拘束廃止取組の有無");

      bodyRestraintAbolition.setBindPath("1510124");

      bodyRestraintAbolition.setModel(getBodyRestraintAbolitionModel());

      bodyRestraintAbolition.setUseClearButton(false);

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
   * 看取り介護体制を取得します。
   * @return 看取り介護体制
   */
  public ACClearableRadioButtonGroup getTerminalCare(){
    if(terminalCare==null){

      terminalCare = new ACClearableRadioButtonGroup();

      getTerminalCareContainer().setText("看取り介護体制");

      terminalCare.setBindPath("1510125");

      terminalCare.setModel(getTerminalCareModel());

      terminalCare.setUseClearButton(false);

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
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getTerminalCareItem2(){
    if(terminalCareItem2==null){

      terminalCareItem2 = new ACRadioButtonItem();

      terminalCareItem2.setText("あり");

      terminalCareItem2.setGroup(getTerminalCare());

      terminalCareItem2.setConstraints(VRLayout.FLOW);

      addTerminalCareItem2();
    }
    return terminalCareItem2;

  }

  /**
   * 在宅・入所相互利用体制を取得します。
   * @return 在宅・入所相互利用体制
   */
  public ACClearableRadioButtonGroup getHomeAndFacility(){
    if(homeAndFacility==null){

      homeAndFacility = new ACClearableRadioButtonGroup();

      getHomeAndFacilityContainer().setText("在宅・入所相互利用体制");

      homeAndFacility.setBindPath("1510126");

      homeAndFacility.setModel(getHomeAndFacilityModel());

      homeAndFacility.setUseClearButton(false);

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
   * ユニット型準個室基準額・コンテナを取得します。
   * @return ユニット型準個室基準額・コンテナ
   */
  public ACLabelContainer getUnitSemiRoomContainer(){
    if(unitSemiRoomContainer==null){

      unitSemiRoomContainer = new ACLabelContainer();

      unitSemiRoomContainer.setText("ユニット型準個室");

      unitSemiRoomContainer.setFollowChildEnabled(true);

      addUnitSemiRoomContainer();
    }
    return unitSemiRoomContainer;

  }

  /**
   * ユニット型準個室基準額・テキストを取得します。
   * @return ユニット型準個室基準額・テキスト
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
   * ユニット型準個室基準額・ラベルを取得します。
   * @return ユニット型準個室基準額・ラベル
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
   * コンストラクタです。
   */
  public QO004118Design() {

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

    calculationDetails1.add(getHeavilyCorrespondenceAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails1.add(getSemiUnitCareMaintenanceContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails1.add(getFunctionTrainingGuidanceSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails1.add(getStandingDoctorAssignmentContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails1.add(getPsychiatristGuidanceContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails1.add(getHandicappedPersonSupportContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails1.add(getNourishmentControlAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails1.add(getNourishmentManagementAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails1.add(getBodyRestraintAbolitionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails1.add(getTerminalCareContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails1.add(getHomeAndFacilityContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * 小規模介護福祉施設に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem2(){

  }

  /**
   * ユニット型介護福祉施設に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem3(){

  }

  /**
   * ユニット型小規模介護福祉施設に内部項目を追加します。
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
   * 重度化対応体制に内部項目を追加します。
   */
  protected void addHeavilyCorrespondenceAdd(){

  }

  /**
   * 重度化対応体制モデルに内部項目を追加します。
   */
  protected void addHeavilyCorrespondenceAddModel(){

    getHeavilyCorrespondenceAddItem1().setButtonIndex(1);
    getHeavilyCorrespondenceAddModel().add(getHeavilyCorrespondenceAddItem1());

    getHeavilyCorrespondenceAddItem2().setButtonIndex(2);
    getHeavilyCorrespondenceAddModel().add(getHeavilyCorrespondenceAddItem2());

  }

  /**
   * 対応不可に内部項目を追加します。
   */
  protected void addHeavilyCorrespondenceAddItem1(){

  }

  /**
   * 対応可に内部項目を追加します。
   */
  protected void addHeavilyCorrespondenceAddItem2(){

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

    getFunctionTrainingGuidanceSystemItem2().setButtonIndex(2);
    getFunctionTrainingGuidanceSystemModel().add(getFunctionTrainingGuidanceSystemItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addFunctionTrainingGuidanceSystemItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addFunctionTrainingGuidanceSystemItem2(){

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

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHandicappedPersonSupportItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHandicappedPersonSupportItem2(){

  }

  /**
   * 栄養管理の評価ラジオグループに内部項目を追加します。
   */
  protected void addNourishmentControlAdd(){

  }

  /**
   * 栄養管理の評価ラジオグループモデルに内部項目を追加します。
   */
  protected void addNourishmentControlAddModel(){

    getNourishmentControlAddItem1().setButtonIndex(1);
    getNourishmentControlAddModel().add(getNourishmentControlAddItem1());

    getNourishmentControlAddItem2().setButtonIndex(2);
    getNourishmentControlAddModel().add(getNourishmentControlAddItem2());

    getNourishmentControlAddItem3().setButtonIndex(3);
    getNourishmentControlAddModel().add(getNourishmentControlAddItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addNourishmentControlAddItem1(){

  }

  /**
   * 栄養士に内部項目を追加します。
   */
  protected void addNourishmentControlAddItem2(){

  }

  /**
   * 管理栄養士に内部項目を追加します。
   */
  protected void addNourishmentControlAddItem3(){

  }

  /**
   * 栄養ケア・マネジメント体制ラジオグループに内部項目を追加します。
   */
  protected void addNourishmentManagementAdd(){

  }

  /**
   * 栄養ケア・マネジメント体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addNourishmentManagementAddModel(){

    getNourishmentManagementAddItem1().setButtonIndex(1);
    getNourishmentManagementAddModel().add(getNourishmentManagementAddItem1());

    getNourishmentManagementAddItem2().setButtonIndex(2);
    getNourishmentManagementAddModel().add(getNourishmentManagementAddItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addNourishmentManagementAddItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addNourishmentManagementAddItem2(){

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

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTerminalCareItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addTerminalCareItem2(){

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
   * パネル2に内部項目を追加します。
   */
  protected void addPanel2(){

    panel2.add(getStandardMoneyGroup(), VRLayout.NORTH);

    panel2.add(getCalculationDetails2(), VRLayout.NORTH);

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
   * ユニット型準個室基準額・コンテナに内部項目を追加します。
   */
  protected void addUnitSemiRoomContainer(){

    unitSemiRoomContainer.add(getUnitSemiRoom(), null);

    unitSemiRoomContainer.add(getUnitSemiRoomLabel(), null);

  }

  /**
   * ユニット型準個室基準額・テキストに内部項目を追加します。
   */
  protected void addUnitSemiRoom(){

  }

  /**
   * ユニット型準個室基準額・ラベルに内部項目を追加します。
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
   * 算定項目領域2に内部項目を追加します。
   */
  protected void addCalculationDetails2(){

    calculationDetails2.add(getReduceRateContainer(), VRLayout.FLOW_INSETLINE);

    calculationDetails2.add(getShahukuReduce(), VRLayout.FLOW_RETURN);

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
      ACFrame.setVRLookAndFeel();
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QO004118Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004118Design getThis() {
    return this;
  }
}
