
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
 * 開発者: 廣瀬 一海
 * 作成日: 2009/03/12  日本コンピューター株式会社 廣瀬 一海 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業者登録 (004)
 * プログラム 介護予防短期入所療養介護(病院療養型) (QO004139)
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
 * 介護予防短期入所療養介護(病院療養型)画面項目デザイン(QO004139) 
 */
public class QO004139Design extends QO004ProviderPanel {
  //GUIコンポーネント

  private ACGroupBox mainGroup;

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACPanel calculationDetails;

  private ACClearableRadioButtonGroup facilitiesDivision;

  private ACLabelContainer facilitiesDivisionContainer;

  private ACListModelAdapter facilitiesDivisionModel;

  private ACRadioButtonItem facilitiesDivisionItem1;

  private ACRadioButtonItem facilitiesDivisionItem2;

  private ACRadioButtonItem facilitiesDivisionItem3;

  private ACRadioButtonItem facilitiesDivisionItem4;

  private ACClearableRadioButtonGroup staffAssignmentDivision;

  private ACLabelContainer staffAssignmentDivisionContainer;

  private ACListModelAdapter staffAssignmentDivisionModel;

  private ACRadioButtonItem staffAssignmentDivisionItem1;

  private ACRadioButtonItem staffAssignmentDivisionItem2;

  private ACRadioButtonItem staffAssignmentDivisionItem3;

  private ACValueArrayRadioButtonGroup nightWorkDivision;

  private ACLabelContainer nightWorkDivisionContainer;

  private ACListModelAdapter nightWorkDivisionModel;

  private ACRadioButtonItem nightWorkDivisionItem1;

  private ACRadioButtonItem nightWorkDivisionItem2;

  private ACRadioButtonItem nightWorkDivisionItem3;

  private ACRadioButtonItem nightWorkDivisionItem4;

  private ACRadioButtonItem nightWorkDivisionItem6;

  private ACRadioButtonItem nightWorkDivisionItem5;

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

  private ACValueArrayRadioButtonGroup recuperationEnvironmentalH2104;

  private ACLabelContainer recuperationEnvironmentalH2104Container;

  private ACListModelAdapter recuperationEnvironmentalH2104Model;

  private ACRadioButtonItem recuperationEnvironmentalH2104Item1;

  private ACRadioButtonItem recuperationEnvironmentalH2104Item2;

  private ACClearableRadioButtonGroup doctorsAssignment;

  private ACLabelContainer doctorsAssignmentContainer;

  private ACListModelAdapter doctorsAssignmentModel;

  private ACRadioButtonItem doctorsAssignmentItem1;

  private ACRadioButtonItem doctorsAssignmentItem2;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACClearableRadioButtonGroup meetingAndSendingOffSystem;

  private ACLabelContainer meetingAndSendingOffSystemContainer;

  private ACListModelAdapter meetingAndSendingOffSystemModel;

  private ACRadioButtonItem meetingAndSendingOffSystemItem1;

  private ACRadioButtonItem meetingAndSendingOffSystemItem2;

  private ACValueArrayRadioButtonGroup medicalFoodAddRadioGroup;

  private ACLabelContainer medicalFoodAddRadioGroupContainer;

  private ACListModelAdapter medicalFoodAddRadioGroupModel;

  private ACRadioButtonItem medicalFoodAddRadioItem1;

  private ACRadioButtonItem medicalFoodAddRadioItem2;

  private ACLabelContainer specialClinicDetailsContainer;

  private ACIntegerCheckBox specialClinicDetailsItem1;

  private ACIntegerCheckBox specialClinicDetailsItem2;

  private ACIntegerCheckBox specialClinicDetailsItem3;

  private ACLabelContainer rehabilitationDetailsContainer;

  private ACIntegerCheckBox rehabilitationDetailsItem1;

  private ACIntegerCheckBox rehabilitationDetailsItem3;

  private ACIntegerCheckBox rehabilitationDetailsItem4;

  private ACIntegerCheckBox rehabilitationDetailsItem5;

  private ACIntegerCheckBox rehabilitationDetailsItem6;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACPanel tab2;

  private ACPanel oldLowElementArea;

  private ACGroupBox oldLowH2103Group;

  private ACClearableRadioButtonGroup facilitiesDivision_H2103;

  private ACLabelContainer facilitiesDivision_H2103Container;

  private ACListModelAdapter facilitiesDivision_H2103Model;

  private ACRadioButtonItem facilitiesDivisionItem1_H2103;

  private ACRadioButtonItem facilitiesDivisionItem2_H2103;

  private ACRadioButtonItem facilitiesDivisionItem3_H2103;

  private ACClearableRadioButtonGroup staffAssignmentDivision_H2103;

  private ACLabelContainer staffAssignmentDivision_H2103Container;

  private ACListModelAdapter staffAssignmentDivision_H2103Model;

  private ACRadioButtonItem staffAssignmentDivisionItem1_H2103;

  private ACRadioButtonItem staffAssignmentDivisionItem2_H2103;

  private ACRadioButtonItem staffAssignmentDivisionItem3_H2103;

  private ACClearableRadioButtonGroup nightWorkDivision_H2103;

  private ACLabelContainer nightWorkDivision_H2103Container;

  private ACListModelAdapter nightWorkDivision_H2103Model;

  private ACRadioButtonItem nightWorkDivisionItem1_H2103;

  private ACRadioButtonItem nightWorkDivisionItem2_H2103;

  private ACRadioButtonItem nightWorkDivisionItem3_H2103;

  private ACRadioButtonItem nightWorkDivisionItem4_H2103;

  private ACRadioButtonItem nightWorkDivisionItem5_H2103;

  private ACClearableRadioButtonGroup unitCareMaintenance_H2103;

  private ACLabelContainer unitCareMaintenance_H2103Container;

  private ACListModelAdapter unitCareMaintenance_H2103Model;

  private ACRadioButtonItem unitCareMaintenanceItem1_H2103;

  private ACRadioButtonItem unitCareMaintenanceItem2_H2103;

  private ACClearableRadioButtonGroup recuperationEnvironmental;

  private ACLabelContainer recuperationEnvironmentalContainer;

  private ACListModelAdapter recuperationEnvironmentalModel;

  private ACRadioButtonItem recuperationEnvironmentalItem1;

  private ACRadioButtonItem recuperationEnvironmentalItem2;

  private ACRadioButtonItem recuperationEnvironmentalItem3;

  private ACRadioButtonItem recuperationEnvironmentalItem4;

  private ACClearableRadioButtonGroup nourishmentControlAdd;

  private ACLabelContainer nourishmentControlAddContainer;

  private ACListModelAdapter nourishmentControlAddModel;

  private ACRadioButtonItem nourishmentControlAddItem1;

  private ACRadioButtonItem nourishmentControlAddItem2;

  private ACRadioButtonItem nourishmentControlAddItem3;

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

  //getter

  /**
   * 事業グループを取得します。
   * @return 事業グループ
   */
  public ACGroupBox getMainGroup(){
    if(mainGroup==null){

      mainGroup = new ACGroupBox();

      mainGroup.setText("介護予防短期入所療養介護（病院療養型）");

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

      addTab1();
    }
    return tab1;

  }

  /**
   * 算定項目領域を取得します。
   * @return 算定項目領域
   */
  public ACPanel getCalculationDetails(){
    if(calculationDetails==null){

      calculationDetails = new ACPanel();

      calculationDetails.setFollowChildEnabled(true);

      calculationDetails.setHgrid(200);

      addCalculationDetails();
    }
    return calculationDetails;

  }

  /**
   * 施設区分ラジオグループを取得します。
   * @return 施設区分ラジオグループ
   */
  public ACClearableRadioButtonGroup getFacilitiesDivision(){
    if(facilitiesDivision==null){

      facilitiesDivision = new ACClearableRadioButtonGroup();

      getFacilitiesDivisionContainer().setText("施設等の区分");

      facilitiesDivision.setBindPath("1260122");

      facilitiesDivision.setUseClearButton(false);

      facilitiesDivision.setModel(getFacilitiesDivisionModel());

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
   * 病院療養型を取得します。
   * @return 病院療養型
   */
  public ACRadioButtonItem getFacilitiesDivisionItem1(){
    if(facilitiesDivisionItem1==null){

      facilitiesDivisionItem1 = new ACRadioButtonItem();

      facilitiesDivisionItem1.setText("病院療養型");

      facilitiesDivisionItem1.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem1.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem1();
    }
    return facilitiesDivisionItem1;

  }

  /**
   * ユニット型病院療養型を取得します。
   * @return ユニット型病院療養型
   */
  public ACRadioButtonItem getFacilitiesDivisionItem2(){
    if(facilitiesDivisionItem2==null){

      facilitiesDivisionItem2 = new ACRadioButtonItem();

      facilitiesDivisionItem2.setText("ユニット型病院療養型");

      facilitiesDivisionItem2.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem2.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem2();
    }
    return facilitiesDivisionItem2;

  }

  /**
   * 病院経過型を取得します。
   * @return 病院経過型
   */
  public ACRadioButtonItem getFacilitiesDivisionItem3(){
    if(facilitiesDivisionItem3==null){

      facilitiesDivisionItem3 = new ACRadioButtonItem();

      facilitiesDivisionItem3.setText("病院経過型");

      facilitiesDivisionItem3.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem3.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem3();
    }
    return facilitiesDivisionItem3;

  }

  /**
   * ユニット型病院経過型を取得します。
   * @return ユニット型病院経過型
   */
  public ACRadioButtonItem getFacilitiesDivisionItem4(){
    if(facilitiesDivisionItem4==null){

      facilitiesDivisionItem4 = new ACRadioButtonItem();

      facilitiesDivisionItem4.setText("ユニット型病院経過型");

      facilitiesDivisionItem4.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem4.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem4();
    }
    return facilitiesDivisionItem4;

  }

  /**
   * 人員配置区分ラジオグループを取得します。
   * @return 人員配置区分ラジオグループ
   */
  public ACClearableRadioButtonGroup getStaffAssignmentDivision(){
    if(staffAssignmentDivision==null){

      staffAssignmentDivision = new ACClearableRadioButtonGroup();

      getStaffAssignmentDivisionContainer().setText("人員配置区分");

      staffAssignmentDivision.setBindPath("1260123");

      staffAssignmentDivision.setUseClearButton(false);

      staffAssignmentDivision.setModel(getStaffAssignmentDivisionModel());

      addStaffAssignmentDivision();
    }
    return staffAssignmentDivision;

  }

  /**
   * 人員配置区分ラジオグループコンテナを取得します。
   * @return 人員配置区分ラジオグループコンテナ
   */
  protected ACLabelContainer getStaffAssignmentDivisionContainer(){
    if(staffAssignmentDivisionContainer==null){
      staffAssignmentDivisionContainer = new ACLabelContainer();
      staffAssignmentDivisionContainer.setFollowChildEnabled(true);
      staffAssignmentDivisionContainer.setVAlignment(VRLayout.CENTER);
      staffAssignmentDivisionContainer.add(getStaffAssignmentDivision(), null);
    }
    return staffAssignmentDivisionContainer;
  }

  /**
   * 人員配置区分ラジオグループモデルを取得します。
   * @return 人員配置区分ラジオグループモデル
   */
  protected ACListModelAdapter getStaffAssignmentDivisionModel(){
    if(staffAssignmentDivisionModel==null){
      staffAssignmentDivisionModel = new ACListModelAdapter();
      addStaffAssignmentDivisionModel();
    }
    return staffAssignmentDivisionModel;
  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem1(){
    if(staffAssignmentDivisionItem1==null){

      staffAssignmentDivisionItem1 = new ACRadioButtonItem();

      staffAssignmentDivisionItem1.setText("I 型");

      staffAssignmentDivisionItem1.setGroup(getStaffAssignmentDivision());

      addStaffAssignmentDivisionItem1();
    }
    return staffAssignmentDivisionItem1;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem2(){
    if(staffAssignmentDivisionItem2==null){

      staffAssignmentDivisionItem2 = new ACRadioButtonItem();

      staffAssignmentDivisionItem2.setText("II 型");

      staffAssignmentDivisionItem2.setGroup(getStaffAssignmentDivision());

      addStaffAssignmentDivisionItem2();
    }
    return staffAssignmentDivisionItem2;

  }

  /**
   * III型を取得します。
   * @return III型
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem3(){
    if(staffAssignmentDivisionItem3==null){

      staffAssignmentDivisionItem3 = new ACRadioButtonItem();

      staffAssignmentDivisionItem3.setText("III 型");

      staffAssignmentDivisionItem3.setGroup(getStaffAssignmentDivision());

      addStaffAssignmentDivisionItem3();
    }
    return staffAssignmentDivisionItem3;

  }

  /**
   * 夜間勤務条件基準ラジオグループを取得します。
   * @return 夜間勤務条件基準ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getNightWorkDivision(){
    if(nightWorkDivision==null){

      nightWorkDivision = new ACValueArrayRadioButtonGroup();

      getNightWorkDivisionContainer().setText("夜間勤務条件基準");

      nightWorkDivision.setBindPath("1260124");

      nightWorkDivision.setUseClearButton(false);

      nightWorkDivision.setModel(getNightWorkDivisionModel());

      nightWorkDivision.setValues(new int[]{1,2,3,4,6,5});

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

      nightWorkDivisionItem1.setConstraints(VRLayout.FLOW);

      addNightWorkDivisionItem1();
    }
    return nightWorkDivisionItem1;

  }

  /**
   * 加算型Iを取得します。
   * @return 加算型I
   */
  public ACRadioButtonItem getNightWorkDivisionItem2(){
    if(nightWorkDivisionItem2==null){

      nightWorkDivisionItem2 = new ACRadioButtonItem();

      nightWorkDivisionItem2.setText("加算型 I");

      nightWorkDivisionItem2.setGroup(getNightWorkDivision());

      nightWorkDivisionItem2.setConstraints(VRLayout.FLOW);

      addNightWorkDivisionItem2();
    }
    return nightWorkDivisionItem2;

  }

  /**
   * 加算型IIを取得します。
   * @return 加算型II
   */
  public ACRadioButtonItem getNightWorkDivisionItem3(){
    if(nightWorkDivisionItem3==null){

      nightWorkDivisionItem3 = new ACRadioButtonItem();

      nightWorkDivisionItem3.setText("加算型 II");

      nightWorkDivisionItem3.setGroup(getNightWorkDivision());

      nightWorkDivisionItem3.setConstraints(VRLayout.FLOW_RETURN);

      addNightWorkDivisionItem3();
    }
    return nightWorkDivisionItem3;

  }

  /**
   * 加算型IIIを取得します。
   * @return 加算型III
   */
  public ACRadioButtonItem getNightWorkDivisionItem4(){
    if(nightWorkDivisionItem4==null){

      nightWorkDivisionItem4 = new ACRadioButtonItem();

      nightWorkDivisionItem4.setText("加算型 III");

      nightWorkDivisionItem4.setGroup(getNightWorkDivision());

      nightWorkDivisionItem4.setConstraints(VRLayout.FLOW);

      addNightWorkDivisionItem4();
    }
    return nightWorkDivisionItem4;

  }

  /**
   * 加算型IVを取得します。
   * @return 加算型IV
   */
  public ACRadioButtonItem getNightWorkDivisionItem6(){
    if(nightWorkDivisionItem6==null){

      nightWorkDivisionItem6 = new ACRadioButtonItem();

      nightWorkDivisionItem6.setText("加算型 IV");

      nightWorkDivisionItem6.setGroup(getNightWorkDivision());

      nightWorkDivisionItem6.setConstraints(VRLayout.FLOW);

      addNightWorkDivisionItem6();
    }
    return nightWorkDivisionItem6;

  }

  /**
   * 減算型を取得します。
   * @return 減算型
   */
  public ACRadioButtonItem getNightWorkDivisionItem5(){
    if(nightWorkDivisionItem5==null){

      nightWorkDivisionItem5 = new ACRadioButtonItem();

      nightWorkDivisionItem5.setText("減算型");

      nightWorkDivisionItem5.setGroup(getNightWorkDivision());

      nightWorkDivisionItem5.setConstraints(VRLayout.FLOW);

      addNightWorkDivisionItem5();
    }
    return nightWorkDivisionItem5;

  }

  /**
   * 職員の欠員による減算の状況を取得します。
   * @return 職員の欠員による減算の状況
   */
  public ACClearableRadioButtonGroup getStaffLack(){
    if(staffLack==null){

      staffLack = new ACClearableRadioButtonGroup();

      getStaffLackContainer().setText("職員の欠員による減算の状況");

      staffLack.setBindPath("1260104");

      staffLack.setUseClearButton(false);

      staffLack.setModel(getStaffLackModel());

      addStaffLack();
    }
    return staffLack;

  }

  /**
   * 職員の欠員による減算の状況コンテナを取得します。
   * @return 職員の欠員による減算の状況コンテナ
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
   * 職員の欠員による減算の状況モデルを取得します。
   * @return 職員の欠員による減算の状況モデル
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
   * 医師を取得します。
   * @return 医師
   */
  public ACRadioButtonItem getStaffLackItem2(){
    if(staffLackItem2==null){

      staffLackItem2 = new ACRadioButtonItem();

      staffLackItem2.setText("医師");

      staffLackItem2.setGroup(getStaffLack());

      staffLackItem2.setConstraints(VRLayout.FLOW);

      addStaffLackItem2();
    }
    return staffLackItem2;

  }

  /**
   * 看護職員を取得します。
   * @return 看護職員
   */
  public ACRadioButtonItem getStaffLackItem3(){
    if(staffLackItem3==null){

      staffLackItem3 = new ACRadioButtonItem();

      staffLackItem3.setText("看護職員");

      staffLackItem3.setGroup(getStaffLack());

      staffLackItem3.setConstraints(VRLayout.FLOW);

      addStaffLackItem3();
    }
    return staffLackItem3;

  }

  /**
   * 介護職員を取得します。
   * @return 介護職員
   */
  public ACRadioButtonItem getStaffLackItem4(){
    if(staffLackItem4==null){

      staffLackItem4 = new ACRadioButtonItem();

      staffLackItem4.setText("介護職員");

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

      unitCareMaintenance.setBindPath("1260125");

      unitCareMaintenance.setUseClearButton(false);

      unitCareMaintenance.setModel(getUnitCareMaintenanceModel());

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
   * 療養環境基準ラジオグループを取得します。
   * @return 療養環境基準ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getRecuperationEnvironmentalH2104(){
    if(recuperationEnvironmentalH2104==null){

      recuperationEnvironmentalH2104 = new ACValueArrayRadioButtonGroup();

      getRecuperationEnvironmentalH2104Container().setText("療養環境基準");

      recuperationEnvironmentalH2104.setBindPath("1260121");

      recuperationEnvironmentalH2104.setNoSelectIndex(0);

      recuperationEnvironmentalH2104.setUseClearButton(false);

      recuperationEnvironmentalH2104.setModel(getRecuperationEnvironmentalH2104Model());

      recuperationEnvironmentalH2104.setValues(new int[]{1,2});

      addRecuperationEnvironmentalH2104();
    }
    return recuperationEnvironmentalH2104;

  }

  /**
   * 療養環境基準ラジオグループコンテナを取得します。
   * @return 療養環境基準ラジオグループコンテナ
   */
  protected ACLabelContainer getRecuperationEnvironmentalH2104Container(){
    if(recuperationEnvironmentalH2104Container==null){
      recuperationEnvironmentalH2104Container = new ACLabelContainer();
      recuperationEnvironmentalH2104Container.setFollowChildEnabled(true);
      recuperationEnvironmentalH2104Container.setVAlignment(VRLayout.CENTER);
      recuperationEnvironmentalH2104Container.add(getRecuperationEnvironmentalH2104(), null);
    }
    return recuperationEnvironmentalH2104Container;
  }

  /**
   * 療養環境基準ラジオグループモデルを取得します。
   * @return 療養環境基準ラジオグループモデル
   */
  protected ACListModelAdapter getRecuperationEnvironmentalH2104Model(){
    if(recuperationEnvironmentalH2104Model==null){
      recuperationEnvironmentalH2104Model = new ACListModelAdapter();
      addRecuperationEnvironmentalH2104Model();
    }
    return recuperationEnvironmentalH2104Model;
  }

  /**
   * 基準型を取得します。
   * @return 基準型
   */
  public ACRadioButtonItem getRecuperationEnvironmentalH2104Item1(){
    if(recuperationEnvironmentalH2104Item1==null){

      recuperationEnvironmentalH2104Item1 = new ACRadioButtonItem();

      recuperationEnvironmentalH2104Item1.setText("基準型");

      recuperationEnvironmentalH2104Item1.setGroup(getRecuperationEnvironmentalH2104());

      addRecuperationEnvironmentalH2104Item1();
    }
    return recuperationEnvironmentalH2104Item1;

  }

  /**
   * 減算型を取得します。
   * @return 減算型
   */
  public ACRadioButtonItem getRecuperationEnvironmentalH2104Item2(){
    if(recuperationEnvironmentalH2104Item2==null){

      recuperationEnvironmentalH2104Item2 = new ACRadioButtonItem();

      recuperationEnvironmentalH2104Item2.setText("減算型");

      recuperationEnvironmentalH2104Item2.setGroup(getRecuperationEnvironmentalH2104());

      addRecuperationEnvironmentalH2104Item2();
    }
    return recuperationEnvironmentalH2104Item2;

  }

  /**
   * 医師の配置基準ラジオグループを取得します。
   * @return 医師の配置基準ラジオグループ
   */
  public ACClearableRadioButtonGroup getDoctorsAssignment(){
    if(doctorsAssignment==null){

      doctorsAssignment = new ACClearableRadioButtonGroup();

      getDoctorsAssignmentContainer().setText("医師の配置基準");

      doctorsAssignment.setBindPath("1260107");

      doctorsAssignment.setUseClearButton(false);

      doctorsAssignment.setModel(getDoctorsAssignmentModel());

      addDoctorsAssignment();
    }
    return doctorsAssignment;

  }

  /**
   * 医師の配置基準ラジオグループコンテナを取得します。
   * @return 医師の配置基準ラジオグループコンテナ
   */
  protected ACLabelContainer getDoctorsAssignmentContainer(){
    if(doctorsAssignmentContainer==null){
      doctorsAssignmentContainer = new ACLabelContainer();
      doctorsAssignmentContainer.setFollowChildEnabled(true);
      doctorsAssignmentContainer.setVAlignment(VRLayout.CENTER);
      doctorsAssignmentContainer.add(getDoctorsAssignment(), null);
    }
    return doctorsAssignmentContainer;
  }

  /**
   * 医師の配置基準ラジオグループモデルを取得します。
   * @return 医師の配置基準ラジオグループモデル
   */
  protected ACListModelAdapter getDoctorsAssignmentModel(){
    if(doctorsAssignmentModel==null){
      doctorsAssignmentModel = new ACListModelAdapter();
      addDoctorsAssignmentModel();
    }
    return doctorsAssignmentModel;
  }

  /**
   * 基準を取得します。
   * @return 基準
   */
  public ACRadioButtonItem getDoctorsAssignmentItem1(){
    if(doctorsAssignmentItem1==null){

      doctorsAssignmentItem1 = new ACRadioButtonItem();

      doctorsAssignmentItem1.setText("基準");

      doctorsAssignmentItem1.setGroup(getDoctorsAssignment());

      addDoctorsAssignmentItem1();
    }
    return doctorsAssignmentItem1;

  }

  /**
   * 医療法施行規則第49条適用を取得します。
   * @return 医療法施行規則第49条適用
   */
  public ACRadioButtonItem getDoctorsAssignmentItem2(){
    if(doctorsAssignmentItem2==null){

      doctorsAssignmentItem2 = new ACRadioButtonItem();

      doctorsAssignmentItem2.setText("医療法施行規則第49条適用");

      doctorsAssignmentItem2.setGroup(getDoctorsAssignment());

      addDoctorsAssignmentItem2();
    }
    return doctorsAssignmentItem2;

  }

  /**
   * 若年性認知症利用者受入加算を取得します。
   * @return 若年性認知症利用者受入加算
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("若年性認知症利用者受入加算");

      youngDementiaPatinetAddRadioGroup.setBindPath("1260118");

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
   * 送迎体制ラジオグループを取得します。
   * @return 送迎体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getMeetingAndSendingOffSystem(){
    if(meetingAndSendingOffSystem==null){

      meetingAndSendingOffSystem = new ACClearableRadioButtonGroup();

      getMeetingAndSendingOffSystemContainer().setText("送迎体制");

      meetingAndSendingOffSystem.setBindPath("1260108");

      meetingAndSendingOffSystem.setUseClearButton(false);

      meetingAndSendingOffSystem.setModel(getMeetingAndSendingOffSystemModel());

      addMeetingAndSendingOffSystem();
    }
    return meetingAndSendingOffSystem;

  }

  /**
   * 送迎体制ラジオグループコンテナを取得します。
   * @return 送迎体制ラジオグループコンテナ
   */
  protected ACLabelContainer getMeetingAndSendingOffSystemContainer(){
    if(meetingAndSendingOffSystemContainer==null){
      meetingAndSendingOffSystemContainer = new ACLabelContainer();
      meetingAndSendingOffSystemContainer.setFollowChildEnabled(true);
      meetingAndSendingOffSystemContainer.setVAlignment(VRLayout.CENTER);
      meetingAndSendingOffSystemContainer.add(getMeetingAndSendingOffSystem(), null);
    }
    return meetingAndSendingOffSystemContainer;
  }

  /**
   * 送迎体制ラジオグループモデルを取得します。
   * @return 送迎体制ラジオグループモデル
   */
  protected ACListModelAdapter getMeetingAndSendingOffSystemModel(){
    if(meetingAndSendingOffSystemModel==null){
      meetingAndSendingOffSystemModel = new ACListModelAdapter();
      addMeetingAndSendingOffSystemModel();
    }
    return meetingAndSendingOffSystemModel;
  }

  /**
   * 対応不可を取得します。
   * @return 対応不可
   */
  public ACRadioButtonItem getMeetingAndSendingOffSystemItem1(){
    if(meetingAndSendingOffSystemItem1==null){

      meetingAndSendingOffSystemItem1 = new ACRadioButtonItem();

      meetingAndSendingOffSystemItem1.setText("対応不可");

      meetingAndSendingOffSystemItem1.setGroup(getMeetingAndSendingOffSystem());

      addMeetingAndSendingOffSystemItem1();
    }
    return meetingAndSendingOffSystemItem1;

  }

  /**
   * 対応可を取得します。
   * @return 対応可
   */
  public ACRadioButtonItem getMeetingAndSendingOffSystemItem2(){
    if(meetingAndSendingOffSystemItem2==null){

      meetingAndSendingOffSystemItem2 = new ACRadioButtonItem();

      meetingAndSendingOffSystemItem2.setText("対応可");

      meetingAndSendingOffSystemItem2.setGroup(getMeetingAndSendingOffSystem());

      addMeetingAndSendingOffSystemItem2();
    }
    return meetingAndSendingOffSystemItem2;

  }

  /**
   * 療養食加算を取得します。
   * @return 療養食加算
   */
  public ACValueArrayRadioButtonGroup getMedicalFoodAddRadioGroup(){
    if(medicalFoodAddRadioGroup==null){

      medicalFoodAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getMedicalFoodAddRadioGroupContainer().setText("療養食加算");

      medicalFoodAddRadioGroup.setBindPath("1260119");

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
   * 特定診療費項目コンテナを取得します。
   * @return 特定診療費項目コンテナ
   */
  public ACLabelContainer getSpecialClinicDetailsContainer(){
    if(specialClinicDetailsContainer==null){

      specialClinicDetailsContainer = new ACLabelContainer();

      specialClinicDetailsContainer.setText("特定診療費項目");

      specialClinicDetailsContainer.setFollowChildEnabled(true);

      addSpecialClinicDetailsContainer();
    }
    return specialClinicDetailsContainer;

  }

  /**
   * 重症皮膚潰瘍指導管理チェックを取得します。
   * @return 重症皮膚潰瘍指導管理チェック
   */
  public ACIntegerCheckBox getSpecialClinicDetailsItem1(){
    if(specialClinicDetailsItem1==null){

      specialClinicDetailsItem1 = new ACIntegerCheckBox();

      specialClinicDetailsItem1.setText("重症皮膚潰瘍指導管理");

      specialClinicDetailsItem1.setBindPath("3010101");

      specialClinicDetailsItem1.setSelectValue(2);

      specialClinicDetailsItem1.setUnSelectValue(1);

      addSpecialClinicDetailsItem1();
    }
    return specialClinicDetailsItem1;

  }

  /**
   * 薬剤管理指導チェックを取得します。
   * @return 薬剤管理指導チェック
   */
  public ACIntegerCheckBox getSpecialClinicDetailsItem2(){
    if(specialClinicDetailsItem2==null){

      specialClinicDetailsItem2 = new ACIntegerCheckBox();

      specialClinicDetailsItem2.setText("薬剤管理指導");

      specialClinicDetailsItem2.setBindPath("3010102");

      specialClinicDetailsItem2.setSelectValue(2);

      specialClinicDetailsItem2.setUnSelectValue(1);

      addSpecialClinicDetailsItem2();
    }
    return specialClinicDetailsItem2;

  }

  /**
   * 集団コミュニケーション療法を取得します。
   * @return 集団コミュニケーション療法
   */
  public ACIntegerCheckBox getSpecialClinicDetailsItem3(){
    if(specialClinicDetailsItem3==null){

      specialClinicDetailsItem3 = new ACIntegerCheckBox();

      specialClinicDetailsItem3.setText("集団コミュニケーション療法");

      specialClinicDetailsItem3.setBindPath("3010112");

      specialClinicDetailsItem3.setSelectValue(2);

      specialClinicDetailsItem3.setUnSelectValue(1);

      addSpecialClinicDetailsItem3();
    }
    return specialClinicDetailsItem3;

  }

  /**
   * リハビリ提供体制コンテナを取得します。
   * @return リハビリ提供体制コンテナ
   */
  public ACLabelContainer getRehabilitationDetailsContainer(){
    if(rehabilitationDetailsContainer==null){

      rehabilitationDetailsContainer = new ACLabelContainer();

      rehabilitationDetailsContainer.setText("リハビリ提供体制");

      rehabilitationDetailsContainer.setFollowChildEnabled(true);

      addRehabilitationDetailsContainer();
    }
    return rehabilitationDetailsContainer;

  }

  /**
   * 理学療法Ⅰチェックを取得します。
   * @return 理学療法Ⅰチェック
   */
  public ACIntegerCheckBox getRehabilitationDetailsItem1(){
    if(rehabilitationDetailsItem1==null){

      rehabilitationDetailsItem1 = new ACIntegerCheckBox();

      rehabilitationDetailsItem1.setText("理学療法 I");

      rehabilitationDetailsItem1.setBindPath("3010103");

      rehabilitationDetailsItem1.setSelectValue(2);

      rehabilitationDetailsItem1.setUnSelectValue(1);

      addRehabilitationDetailsItem1();
    }
    return rehabilitationDetailsItem1;

  }

  /**
   * 作業療法チェックを取得します。
   * @return 作業療法チェック
   */
  public ACIntegerCheckBox getRehabilitationDetailsItem3(){
    if(rehabilitationDetailsItem3==null){

      rehabilitationDetailsItem3 = new ACIntegerCheckBox();

      rehabilitationDetailsItem3.setText("作業療法");

      rehabilitationDetailsItem3.setBindPath("3010105");

      rehabilitationDetailsItem3.setSelectValue(2);

      rehabilitationDetailsItem3.setUnSelectValue(1);

      addRehabilitationDetailsItem3();
    }
    return rehabilitationDetailsItem3;

  }

  /**
   * 言語聴覚療法チェックを取得します。
   * @return 言語聴覚療法チェック
   */
  public ACIntegerCheckBox getRehabilitationDetailsItem4(){
    if(rehabilitationDetailsItem4==null){

      rehabilitationDetailsItem4 = new ACIntegerCheckBox();

      rehabilitationDetailsItem4.setText("言語聴覚療法");

      rehabilitationDetailsItem4.setBindPath("3010106");

      rehabilitationDetailsItem4.setSelectValue(2);

      rehabilitationDetailsItem4.setUnSelectValue(1);

      addRehabilitationDetailsItem4();
    }
    return rehabilitationDetailsItem4;

  }

  /**
   * 精神科作業療法チェックを取得します。
   * @return 精神科作業療法チェック
   */
  public ACIntegerCheckBox getRehabilitationDetailsItem5(){
    if(rehabilitationDetailsItem5==null){

      rehabilitationDetailsItem5 = new ACIntegerCheckBox();

      rehabilitationDetailsItem5.setText("精神科作業療法");

      rehabilitationDetailsItem5.setBindPath("3010107");

      rehabilitationDetailsItem5.setSelectValue(2);

      rehabilitationDetailsItem5.setUnSelectValue(1);

      addRehabilitationDetailsItem5();
    }
    return rehabilitationDetailsItem5;

  }

  /**
   * その他チェックを取得します。
   * @return その他チェック
   */
  public ACIntegerCheckBox getRehabilitationDetailsItem6(){
    if(rehabilitationDetailsItem6==null){

      rehabilitationDetailsItem6 = new ACIntegerCheckBox();

      rehabilitationDetailsItem6.setText("その他");

      rehabilitationDetailsItem6.setBindPath("3010108");

      rehabilitationDetailsItem6.setSelectValue(2);

      rehabilitationDetailsItem6.setUnSelectValue(1);

      addRehabilitationDetailsItem6();
    }
    return rehabilitationDetailsItem6;

  }

  /**
   * サービス提供体制強化加算を取得します。
   * @return サービス提供体制強化加算
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("サービス提供体制強化加算");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1260120");

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
   * 加算Iを取得します。
   * @return 加算I
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("加算I");

      serviceAddProvisionStructuralRadioItem2.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem2.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem2();
    }
    return serviceAddProvisionStructuralRadioItem2;

  }

  /**
   * 加算IIを取得します。
   * @return 加算II
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem3(){
    if(serviceAddProvisionStructuralRadioItem3==null){

      serviceAddProvisionStructuralRadioItem3 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem3.setText("加算II");

      serviceAddProvisionStructuralRadioItem3.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem3.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem3();
    }
    return serviceAddProvisionStructuralRadioItem3;

  }

  /**
   * 加算IIIを取得します。
   * @return 加算III
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem4(){
    if(serviceAddProvisionStructuralRadioItem4==null){

      serviceAddProvisionStructuralRadioItem4 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem4.setText("加算III");

      serviceAddProvisionStructuralRadioItem4.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem4.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem4();
    }
    return serviceAddProvisionStructuralRadioItem4;

  }

  /**
   * タブ2を取得します。
   * @return タブ2
   */
  public ACPanel getTab2(){
    if(tab2==null){

      tab2 = new ACPanel();

      tab2.setFollowChildEnabled(true);

      addTab2();
    }
    return tab2;

  }

  /**
   * 旧法項目を取得します。
   * @return 旧法項目
   */
  public ACPanel getOldLowElementArea(){
    if(oldLowElementArea==null){

      oldLowElementArea = new ACPanel();

      oldLowElementArea.setFollowChildEnabled(true);

      addOldLowElementArea();
    }
    return oldLowElementArea;

  }

  /**
   * 平成21年3月以前グループを取得します。
   * @return 平成21年3月以前グループ
   */
  public ACGroupBox getOldLowH2103Group(){
    if(oldLowH2103Group==null){

      oldLowH2103Group = new ACGroupBox();

      oldLowH2103Group.setText("平成21年3月以前");

      oldLowH2103Group.setFollowChildEnabled(true);

      oldLowH2103Group.setHgap(0);

      oldLowH2103Group.setLabelMargin(0);

      oldLowH2103Group.setVgap(0);

      addOldLowH2103Group();
    }
    return oldLowH2103Group;

  }

  /**
   * 施設区分ラジオグループを取得します。
   * @return 施設区分ラジオグループ
   */
  public ACClearableRadioButtonGroup getFacilitiesDivision_H2103(){
    if(facilitiesDivision_H2103==null){

      facilitiesDivision_H2103 = new ACClearableRadioButtonGroup();

      getFacilitiesDivision_H2103Container().setText("施設等の区分");

      facilitiesDivision_H2103.setBindPath("1260101");

      facilitiesDivision_H2103.setUseClearButton(false);

      facilitiesDivision_H2103.setModel(getFacilitiesDivision_H2103Model());

      addFacilitiesDivision_H2103();
    }
    return facilitiesDivision_H2103;

  }

  /**
   * 施設区分ラジオグループコンテナを取得します。
   * @return 施設区分ラジオグループコンテナ
   */
  protected ACLabelContainer getFacilitiesDivision_H2103Container(){
    if(facilitiesDivision_H2103Container==null){
      facilitiesDivision_H2103Container = new ACLabelContainer();
      facilitiesDivision_H2103Container.setFollowChildEnabled(true);
      facilitiesDivision_H2103Container.setVAlignment(VRLayout.CENTER);
      facilitiesDivision_H2103Container.add(getFacilitiesDivision_H2103(), null);
    }
    return facilitiesDivision_H2103Container;
  }

  /**
   * 施設区分ラジオグループモデルを取得します。
   * @return 施設区分ラジオグループモデル
   */
  protected ACListModelAdapter getFacilitiesDivision_H2103Model(){
    if(facilitiesDivision_H2103Model==null){
      facilitiesDivision_H2103Model = new ACListModelAdapter();
      addFacilitiesDivision_H2103Model();
    }
    return facilitiesDivision_H2103Model;
  }

  /**
   * 病院療養型を取得します。
   * @return 病院療養型
   */
  public ACRadioButtonItem getFacilitiesDivisionItem1_H2103(){
    if(facilitiesDivisionItem1_H2103==null){

      facilitiesDivisionItem1_H2103 = new ACRadioButtonItem();

      facilitiesDivisionItem1_H2103.setText("病院療養型");

      facilitiesDivisionItem1_H2103.setGroup(getFacilitiesDivision_H2103());

      facilitiesDivisionItem1_H2103.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem1_H2103();
    }
    return facilitiesDivisionItem1_H2103;

  }

  /**
   * ユニット型病院療養型を取得します。
   * @return ユニット型病院療養型
   */
  public ACRadioButtonItem getFacilitiesDivisionItem2_H2103(){
    if(facilitiesDivisionItem2_H2103==null){

      facilitiesDivisionItem2_H2103 = new ACRadioButtonItem();

      facilitiesDivisionItem2_H2103.setText("ユニット型病院療養型");

      facilitiesDivisionItem2_H2103.setGroup(getFacilitiesDivision_H2103());

      facilitiesDivisionItem2_H2103.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem2_H2103();
    }
    return facilitiesDivisionItem2_H2103;

  }

  /**
   * 病院経過型を取得します。
   * @return 病院経過型
   */
  public ACRadioButtonItem getFacilitiesDivisionItem3_H2103(){
    if(facilitiesDivisionItem3_H2103==null){

      facilitiesDivisionItem3_H2103 = new ACRadioButtonItem();

      facilitiesDivisionItem3_H2103.setText("病院経過型");

      facilitiesDivisionItem3_H2103.setGroup(getFacilitiesDivision_H2103());

      facilitiesDivisionItem3_H2103.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem3_H2103();
    }
    return facilitiesDivisionItem3_H2103;

  }

  /**
   * 人員配置区分ラジオグループを取得します。
   * @return 人員配置区分ラジオグループ
   */
  public ACClearableRadioButtonGroup getStaffAssignmentDivision_H2103(){
    if(staffAssignmentDivision_H2103==null){

      staffAssignmentDivision_H2103 = new ACClearableRadioButtonGroup();

      getStaffAssignmentDivision_H2103Container().setText("人員配置区分");

      staffAssignmentDivision_H2103.setBindPath("1260102");

      staffAssignmentDivision_H2103.setUseClearButton(false);

      staffAssignmentDivision_H2103.setModel(getStaffAssignmentDivision_H2103Model());

      addStaffAssignmentDivision_H2103();
    }
    return staffAssignmentDivision_H2103;

  }

  /**
   * 人員配置区分ラジオグループコンテナを取得します。
   * @return 人員配置区分ラジオグループコンテナ
   */
  protected ACLabelContainer getStaffAssignmentDivision_H2103Container(){
    if(staffAssignmentDivision_H2103Container==null){
      staffAssignmentDivision_H2103Container = new ACLabelContainer();
      staffAssignmentDivision_H2103Container.setFollowChildEnabled(true);
      staffAssignmentDivision_H2103Container.setVAlignment(VRLayout.CENTER);
      staffAssignmentDivision_H2103Container.add(getStaffAssignmentDivision_H2103(), null);
    }
    return staffAssignmentDivision_H2103Container;
  }

  /**
   * 人員配置区分ラジオグループモデルを取得します。
   * @return 人員配置区分ラジオグループモデル
   */
  protected ACListModelAdapter getStaffAssignmentDivision_H2103Model(){
    if(staffAssignmentDivision_H2103Model==null){
      staffAssignmentDivision_H2103Model = new ACListModelAdapter();
      addStaffAssignmentDivision_H2103Model();
    }
    return staffAssignmentDivision_H2103Model;
  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem1_H2103(){
    if(staffAssignmentDivisionItem1_H2103==null){

      staffAssignmentDivisionItem1_H2103 = new ACRadioButtonItem();

      staffAssignmentDivisionItem1_H2103.setText("I 型");

      staffAssignmentDivisionItem1_H2103.setGroup(getStaffAssignmentDivision_H2103());

      addStaffAssignmentDivisionItem1_H2103();
    }
    return staffAssignmentDivisionItem1_H2103;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem2_H2103(){
    if(staffAssignmentDivisionItem2_H2103==null){

      staffAssignmentDivisionItem2_H2103 = new ACRadioButtonItem();

      staffAssignmentDivisionItem2_H2103.setText("II 型");

      staffAssignmentDivisionItem2_H2103.setGroup(getStaffAssignmentDivision_H2103());

      addStaffAssignmentDivisionItem2_H2103();
    }
    return staffAssignmentDivisionItem2_H2103;

  }

  /**
   * III型を取得します。
   * @return III型
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem3_H2103(){
    if(staffAssignmentDivisionItem3_H2103==null){

      staffAssignmentDivisionItem3_H2103 = new ACRadioButtonItem();

      staffAssignmentDivisionItem3_H2103.setText("III 型");

      staffAssignmentDivisionItem3_H2103.setGroup(getStaffAssignmentDivision_H2103());

      addStaffAssignmentDivisionItem3_H2103();
    }
    return staffAssignmentDivisionItem3_H2103;

  }

  /**
   * 夜間勤務条件基準ラジオグループを取得します。
   * @return 夜間勤務条件基準ラジオグループ
   */
  public ACClearableRadioButtonGroup getNightWorkDivision_H2103(){
    if(nightWorkDivision_H2103==null){

      nightWorkDivision_H2103 = new ACClearableRadioButtonGroup();

      getNightWorkDivision_H2103Container().setText("夜間勤務条件基準");

      nightWorkDivision_H2103.setBindPath("1260103");

      nightWorkDivision_H2103.setUseClearButton(false);

      nightWorkDivision_H2103.setModel(getNightWorkDivision_H2103Model());

      addNightWorkDivision_H2103();
    }
    return nightWorkDivision_H2103;

  }

  /**
   * 夜間勤務条件基準ラジオグループコンテナを取得します。
   * @return 夜間勤務条件基準ラジオグループコンテナ
   */
  protected ACLabelContainer getNightWorkDivision_H2103Container(){
    if(nightWorkDivision_H2103Container==null){
      nightWorkDivision_H2103Container = new ACLabelContainer();
      nightWorkDivision_H2103Container.setFollowChildEnabled(true);
      nightWorkDivision_H2103Container.setVAlignment(VRLayout.CENTER);
      nightWorkDivision_H2103Container.add(getNightWorkDivision_H2103(), null);
    }
    return nightWorkDivision_H2103Container;
  }

  /**
   * 夜間勤務条件基準ラジオグループモデルを取得します。
   * @return 夜間勤務条件基準ラジオグループモデル
   */
  protected ACListModelAdapter getNightWorkDivision_H2103Model(){
    if(nightWorkDivision_H2103Model==null){
      nightWorkDivision_H2103Model = new ACListModelAdapter();
      addNightWorkDivision_H2103Model();
    }
    return nightWorkDivision_H2103Model;
  }

  /**
   * 基準型を取得します。
   * @return 基準型
   */
  public ACRadioButtonItem getNightWorkDivisionItem1_H2103(){
    if(nightWorkDivisionItem1_H2103==null){

      nightWorkDivisionItem1_H2103 = new ACRadioButtonItem();

      nightWorkDivisionItem1_H2103.setText("基準型");

      nightWorkDivisionItem1_H2103.setGroup(getNightWorkDivision_H2103());

      addNightWorkDivisionItem1_H2103();
    }
    return nightWorkDivisionItem1_H2103;

  }

  /**
   * 加算型Iを取得します。
   * @return 加算型I
   */
  public ACRadioButtonItem getNightWorkDivisionItem2_H2103(){
    if(nightWorkDivisionItem2_H2103==null){

      nightWorkDivisionItem2_H2103 = new ACRadioButtonItem();

      nightWorkDivisionItem2_H2103.setText("加算型 I");

      nightWorkDivisionItem2_H2103.setGroup(getNightWorkDivision_H2103());

      addNightWorkDivisionItem2_H2103();
    }
    return nightWorkDivisionItem2_H2103;

  }

  /**
   * 加算型IIを取得します。
   * @return 加算型II
   */
  public ACRadioButtonItem getNightWorkDivisionItem3_H2103(){
    if(nightWorkDivisionItem3_H2103==null){

      nightWorkDivisionItem3_H2103 = new ACRadioButtonItem();

      nightWorkDivisionItem3_H2103.setText("加算型 II");

      nightWorkDivisionItem3_H2103.setGroup(getNightWorkDivision_H2103());

      addNightWorkDivisionItem3_H2103();
    }
    return nightWorkDivisionItem3_H2103;

  }

  /**
   * 加算型IIIを取得します。
   * @return 加算型III
   */
  public ACRadioButtonItem getNightWorkDivisionItem4_H2103(){
    if(nightWorkDivisionItem4_H2103==null){

      nightWorkDivisionItem4_H2103 = new ACRadioButtonItem();

      nightWorkDivisionItem4_H2103.setText("加算型 III");

      nightWorkDivisionItem4_H2103.setGroup(getNightWorkDivision_H2103());

      addNightWorkDivisionItem4_H2103();
    }
    return nightWorkDivisionItem4_H2103;

  }

  /**
   * 減算型を取得します。
   * @return 減算型
   */
  public ACRadioButtonItem getNightWorkDivisionItem5_H2103(){
    if(nightWorkDivisionItem5_H2103==null){

      nightWorkDivisionItem5_H2103 = new ACRadioButtonItem();

      nightWorkDivisionItem5_H2103.setText("減算型");

      nightWorkDivisionItem5_H2103.setGroup(getNightWorkDivision_H2103());

      addNightWorkDivisionItem5_H2103();
    }
    return nightWorkDivisionItem5_H2103;

  }

  /**
   * ユニットケア体制を取得します。
   * @return ユニットケア体制
   */
  public ACClearableRadioButtonGroup getUnitCareMaintenance_H2103(){
    if(unitCareMaintenance_H2103==null){

      unitCareMaintenance_H2103 = new ACClearableRadioButtonGroup();

      getUnitCareMaintenance_H2103Container().setText("ユニットケア体制");

      unitCareMaintenance_H2103.setBindPath("1260105");

      unitCareMaintenance_H2103.setUseClearButton(false);

      unitCareMaintenance_H2103.setModel(getUnitCareMaintenance_H2103Model());

      addUnitCareMaintenance_H2103();
    }
    return unitCareMaintenance_H2103;

  }

  /**
   * ユニットケア体制コンテナを取得します。
   * @return ユニットケア体制コンテナ
   */
  protected ACLabelContainer getUnitCareMaintenance_H2103Container(){
    if(unitCareMaintenance_H2103Container==null){
      unitCareMaintenance_H2103Container = new ACLabelContainer();
      unitCareMaintenance_H2103Container.setFollowChildEnabled(true);
      unitCareMaintenance_H2103Container.setVAlignment(VRLayout.CENTER);
      unitCareMaintenance_H2103Container.add(getUnitCareMaintenance_H2103(), null);
    }
    return unitCareMaintenance_H2103Container;
  }

  /**
   * ユニットケア体制モデルを取得します。
   * @return ユニットケア体制モデル
   */
  protected ACListModelAdapter getUnitCareMaintenance_H2103Model(){
    if(unitCareMaintenance_H2103Model==null){
      unitCareMaintenance_H2103Model = new ACListModelAdapter();
      addUnitCareMaintenance_H2103Model();
    }
    return unitCareMaintenance_H2103Model;
  }

  /**
   * 対応不可を取得します。
   * @return 対応不可
   */
  public ACRadioButtonItem getUnitCareMaintenanceItem1_H2103(){
    if(unitCareMaintenanceItem1_H2103==null){

      unitCareMaintenanceItem1_H2103 = new ACRadioButtonItem();

      unitCareMaintenanceItem1_H2103.setText("対応不可");

      unitCareMaintenanceItem1_H2103.setGroup(getUnitCareMaintenance_H2103());

      unitCareMaintenanceItem1_H2103.setConstraints(VRLayout.FLOW);

      addUnitCareMaintenanceItem1_H2103();
    }
    return unitCareMaintenanceItem1_H2103;

  }

  /**
   * 対応可を取得します。
   * @return 対応可
   */
  public ACRadioButtonItem getUnitCareMaintenanceItem2_H2103(){
    if(unitCareMaintenanceItem2_H2103==null){

      unitCareMaintenanceItem2_H2103 = new ACRadioButtonItem();

      unitCareMaintenanceItem2_H2103.setText("対応可");

      unitCareMaintenanceItem2_H2103.setGroup(getUnitCareMaintenance_H2103());

      unitCareMaintenanceItem2_H2103.setConstraints(VRLayout.FLOW);

      addUnitCareMaintenanceItem2_H2103();
    }
    return unitCareMaintenanceItem2_H2103;

  }

  /**
   * 療養環境基準ラジオグループを取得します。
   * @return 療養環境基準ラジオグループ
   */
  public ACClearableRadioButtonGroup getRecuperationEnvironmental(){
    if(recuperationEnvironmental==null){

      recuperationEnvironmental = new ACClearableRadioButtonGroup();

      getRecuperationEnvironmentalContainer().setText("療養環境基準");

      recuperationEnvironmental.setBindPath("1260106");

      recuperationEnvironmental.setUseClearButton(false);

      recuperationEnvironmental.setModel(getRecuperationEnvironmentalModel());

      addRecuperationEnvironmental();
    }
    return recuperationEnvironmental;

  }

  /**
   * 療養環境基準ラジオグループコンテナを取得します。
   * @return 療養環境基準ラジオグループコンテナ
   */
  protected ACLabelContainer getRecuperationEnvironmentalContainer(){
    if(recuperationEnvironmentalContainer==null){
      recuperationEnvironmentalContainer = new ACLabelContainer();
      recuperationEnvironmentalContainer.setFollowChildEnabled(true);
      recuperationEnvironmentalContainer.setVAlignment(VRLayout.CENTER);
      recuperationEnvironmentalContainer.add(getRecuperationEnvironmental(), null);
    }
    return recuperationEnvironmentalContainer;
  }

  /**
   * 療養環境基準ラジオグループモデルを取得します。
   * @return 療養環境基準ラジオグループモデル
   */
  protected ACListModelAdapter getRecuperationEnvironmentalModel(){
    if(recuperationEnvironmentalModel==null){
      recuperationEnvironmentalModel = new ACListModelAdapter();
      addRecuperationEnvironmentalModel();
    }
    return recuperationEnvironmentalModel;
  }

  /**
   * 基準型を取得します。
   * @return 基準型
   */
  public ACRadioButtonItem getRecuperationEnvironmentalItem1(){
    if(recuperationEnvironmentalItem1==null){

      recuperationEnvironmentalItem1 = new ACRadioButtonItem();

      recuperationEnvironmentalItem1.setText("基準型");

      recuperationEnvironmentalItem1.setGroup(getRecuperationEnvironmental());

      addRecuperationEnvironmentalItem1();
    }
    return recuperationEnvironmentalItem1;

  }

  /**
   * 減算型Iを取得します。
   * @return 減算型I
   */
  public ACRadioButtonItem getRecuperationEnvironmentalItem2(){
    if(recuperationEnvironmentalItem2==null){

      recuperationEnvironmentalItem2 = new ACRadioButtonItem();

      recuperationEnvironmentalItem2.setText("減算型 I");

      recuperationEnvironmentalItem2.setGroup(getRecuperationEnvironmental());

      addRecuperationEnvironmentalItem2();
    }
    return recuperationEnvironmentalItem2;

  }

  /**
   * 減算型IIを取得します。
   * @return 減算型II
   */
  public ACRadioButtonItem getRecuperationEnvironmentalItem3(){
    if(recuperationEnvironmentalItem3==null){

      recuperationEnvironmentalItem3 = new ACRadioButtonItem();

      recuperationEnvironmentalItem3.setText("減算型 II");

      recuperationEnvironmentalItem3.setGroup(getRecuperationEnvironmental());

      addRecuperationEnvironmentalItem3();
    }
    return recuperationEnvironmentalItem3;

  }

  /**
   * 減算型IIIを取得します。
   * @return 減算型III
   */
  public ACRadioButtonItem getRecuperationEnvironmentalItem4(){
    if(recuperationEnvironmentalItem4==null){

      recuperationEnvironmentalItem4 = new ACRadioButtonItem();

      recuperationEnvironmentalItem4.setText("減算型 III");

      recuperationEnvironmentalItem4.setGroup(getRecuperationEnvironmental());

      addRecuperationEnvironmentalItem4();
    }
    return recuperationEnvironmentalItem4;

  }

  /**
   * 栄養管理の評価ラジオグループを取得します。
   * @return 栄養管理の評価ラジオグループ
   */
  public ACClearableRadioButtonGroup getNourishmentControlAdd(){
    if(nourishmentControlAdd==null){

      nourishmentControlAdd = new ACClearableRadioButtonGroup();

      getNourishmentControlAddContainer().setText("栄養管理の評価");

      nourishmentControlAdd.setBindPath("1260109");

      nourishmentControlAdd.setUseClearButton(false);

      nourishmentControlAdd.setModel(getNourishmentControlAddModel());

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

      addNourishmentControlAddItem3();
    }
    return nourishmentControlAddItem3;

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

      dinnerTotal.setBindPath("1260110");

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

      dinnerMorning.setBindPath("1260111");

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

      dinnerNoon.setBindPath("1260112");

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

      dinnerNight.setBindPath("1260113");

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

      unitRoom.setBindPath("1260114");

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

      unitSemiRoom.setBindPath("1260115");

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

      normalRoom.setBindPath("1260116");

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

      tasyouRoom.setBindPath("1260117");

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

      reduceRateContainer.setForeground(java.awt.Color.gray);

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

      percentSign.setForeground(java.awt.Color.gray);

      addPercentSign();
    }
    return percentSign;

  }

  /**
   * コンストラクタです。
   */
  public QO004139Design() {

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

    mainGroup.add(getTabs(), VRLayout.CLIENT);

  }

  /**
   * タブに内部項目を追加します。
   */
  protected void addTabs(){

    tabs.addTab("1", getTab1());

    tabs.addTab("2", getTab2());

  }

  /**
   * タブ1に内部項目を追加します。
   */
  protected void addTab1(){

    tab1.add(getCalculationDetails(), VRLayout.NORTH);

  }

  /**
   * 算定項目領域に内部項目を追加します。
   */
  protected void addCalculationDetails(){

    calculationDetails.add(getFacilitiesDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getStaffAssignmentDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getNightWorkDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getStaffLackContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getUnitCareMaintenanceContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getRecuperationEnvironmentalH2104Container(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getDoctorsAssignmentContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getMeetingAndSendingOffSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getMedicalFoodAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getSpecialClinicDetailsContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getRehabilitationDetailsContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * 病院療養型に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem1(){

  }

  /**
   * ユニット型病院療養型に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem2(){

  }

  /**
   * 病院経過型に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem3(){

  }

  /**
   * ユニット型病院経過型に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem4(){

  }

  /**
   * 人員配置区分ラジオグループに内部項目を追加します。
   */
  protected void addStaffAssignmentDivision(){

  }

  /**
   * 人員配置区分ラジオグループモデルに内部項目を追加します。
   */
  protected void addStaffAssignmentDivisionModel(){

    getStaffAssignmentDivisionItem1().setButtonIndex(1);

    getStaffAssignmentDivisionModel().add(getStaffAssignmentDivisionItem1());

    getStaffAssignmentDivisionItem2().setButtonIndex(2);

    getStaffAssignmentDivisionModel().add(getStaffAssignmentDivisionItem2());

    getStaffAssignmentDivisionItem3().setButtonIndex(3);

    getStaffAssignmentDivisionModel().add(getStaffAssignmentDivisionItem3());

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addStaffAssignmentDivisionItem1(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addStaffAssignmentDivisionItem2(){

  }

  /**
   * III型に内部項目を追加します。
   */
  protected void addStaffAssignmentDivisionItem3(){

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

    getNightWorkDivisionItem3().setButtonIndex(3);

    getNightWorkDivisionModel().add(getNightWorkDivisionItem3());

    getNightWorkDivisionItem4().setButtonIndex(4);

    getNightWorkDivisionModel().add(getNightWorkDivisionItem4());

    getNightWorkDivisionItem6().setButtonIndex(6);

    getNightWorkDivisionModel().add(getNightWorkDivisionItem6());

    getNightWorkDivisionItem5().setButtonIndex(5);

    getNightWorkDivisionModel().add(getNightWorkDivisionItem5());

  }

  /**
   * 基準型に内部項目を追加します。
   */
  protected void addNightWorkDivisionItem1(){

  }

  /**
   * 加算型Iに内部項目を追加します。
   */
  protected void addNightWorkDivisionItem2(){

  }

  /**
   * 加算型IIに内部項目を追加します。
   */
  protected void addNightWorkDivisionItem3(){

  }

  /**
   * 加算型IIIに内部項目を追加します。
   */
  protected void addNightWorkDivisionItem4(){

  }

  /**
   * 加算型IVに内部項目を追加します。
   */
  protected void addNightWorkDivisionItem6(){

  }

  /**
   * 減算型に内部項目を追加します。
   */
  protected void addNightWorkDivisionItem5(){

  }

  /**
   * 職員の欠員による減算の状況に内部項目を追加します。
   */
  protected void addStaffLack(){

  }

  /**
   * 職員の欠員による減算の状況モデルに内部項目を追加します。
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
   * 医師に内部項目を追加します。
   */
  protected void addStaffLackItem2(){

  }

  /**
   * 看護職員に内部項目を追加します。
   */
  protected void addStaffLackItem3(){

  }

  /**
   * 介護職員に内部項目を追加します。
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
   * 療養環境基準ラジオグループに内部項目を追加します。
   */
  protected void addRecuperationEnvironmentalH2104(){

  }

  /**
   * 療養環境基準ラジオグループモデルに内部項目を追加します。
   */
  protected void addRecuperationEnvironmentalH2104Model(){

    getRecuperationEnvironmentalH2104Item1().setButtonIndex(1);

    getRecuperationEnvironmentalH2104Model().add(getRecuperationEnvironmentalH2104Item1());

    getRecuperationEnvironmentalH2104Item2().setButtonIndex(2);

    getRecuperationEnvironmentalH2104Model().add(getRecuperationEnvironmentalH2104Item2());

  }

  /**
   * 基準型に内部項目を追加します。
   */
  protected void addRecuperationEnvironmentalH2104Item1(){

  }

  /**
   * 減算型に内部項目を追加します。
   */
  protected void addRecuperationEnvironmentalH2104Item2(){

  }

  /**
   * 医師の配置基準ラジオグループに内部項目を追加します。
   */
  protected void addDoctorsAssignment(){

  }

  /**
   * 医師の配置基準ラジオグループモデルに内部項目を追加します。
   */
  protected void addDoctorsAssignmentModel(){

    getDoctorsAssignmentItem1().setButtonIndex(1);

    getDoctorsAssignmentModel().add(getDoctorsAssignmentItem1());

    getDoctorsAssignmentItem2().setButtonIndex(2);

    getDoctorsAssignmentModel().add(getDoctorsAssignmentItem2());

  }

  /**
   * 基準に内部項目を追加します。
   */
  protected void addDoctorsAssignmentItem1(){

  }

  /**
   * 医療法施行規則第49条適用に内部項目を追加します。
   */
  protected void addDoctorsAssignmentItem2(){

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
   * 送迎体制ラジオグループに内部項目を追加します。
   */
  protected void addMeetingAndSendingOffSystem(){

  }

  /**
   * 送迎体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addMeetingAndSendingOffSystemModel(){

    getMeetingAndSendingOffSystemItem1().setButtonIndex(1);

    getMeetingAndSendingOffSystemModel().add(getMeetingAndSendingOffSystemItem1());

    getMeetingAndSendingOffSystemItem2().setButtonIndex(2);

    getMeetingAndSendingOffSystemModel().add(getMeetingAndSendingOffSystemItem2());

  }

  /**
   * 対応不可に内部項目を追加します。
   */
  protected void addMeetingAndSendingOffSystemItem1(){

  }

  /**
   * 対応可に内部項目を追加します。
   */
  protected void addMeetingAndSendingOffSystemItem2(){

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
   * 特定診療費項目コンテナに内部項目を追加します。
   */
  protected void addSpecialClinicDetailsContainer(){

    specialClinicDetailsContainer.add(getSpecialClinicDetailsItem1(), VRLayout.FLOW);

    specialClinicDetailsContainer.add(getSpecialClinicDetailsItem2(), VRLayout.FLOW_RETURN);

    specialClinicDetailsContainer.add(getSpecialClinicDetailsItem3(), VRLayout.FLOW);

  }

  /**
   * 重症皮膚潰瘍指導管理チェックに内部項目を追加します。
   */
  protected void addSpecialClinicDetailsItem1(){

  }

  /**
   * 薬剤管理指導チェックに内部項目を追加します。
   */
  protected void addSpecialClinicDetailsItem2(){

  }

  /**
   * 集団コミュニケーション療法に内部項目を追加します。
   */
  protected void addSpecialClinicDetailsItem3(){

  }

  /**
   * リハビリ提供体制コンテナに内部項目を追加します。
   */
  protected void addRehabilitationDetailsContainer(){

    rehabilitationDetailsContainer.add(getRehabilitationDetailsItem1(), VRLayout.FLOW);

    rehabilitationDetailsContainer.add(getRehabilitationDetailsItem3(), VRLayout.FLOW_RETURN);

    rehabilitationDetailsContainer.add(getRehabilitationDetailsItem4(), VRLayout.FLOW);

    rehabilitationDetailsContainer.add(getRehabilitationDetailsItem5(), VRLayout.FLOW);

    rehabilitationDetailsContainer.add(getRehabilitationDetailsItem6(), VRLayout.FLOW);

  }

  /**
   * 理学療法Ⅰチェックに内部項目を追加します。
   */
  protected void addRehabilitationDetailsItem1(){

  }

  /**
   * 作業療法チェックに内部項目を追加します。
   */
  protected void addRehabilitationDetailsItem3(){

  }

  /**
   * 言語聴覚療法チェックに内部項目を追加します。
   */
  protected void addRehabilitationDetailsItem4(){

  }

  /**
   * 精神科作業療法チェックに内部項目を追加します。
   */
  protected void addRehabilitationDetailsItem5(){

  }

  /**
   * その他チェックに内部項目を追加します。
   */
  protected void addRehabilitationDetailsItem6(){

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
   * 加算Iに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem2(){

  }

  /**
   * 加算IIに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem3(){

  }

  /**
   * 加算IIIに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem4(){

  }

  /**
   * タブ2に内部項目を追加します。
   */
  protected void addTab2(){

    tab2.add(getOldLowElementArea(), VRLayout.NORTH);

    tab2.add(getStandardMoneyGroup(), VRLayout.NORTH);

    tab2.add(getCalculationDetails2(), VRLayout.NORTH);

  }

  /**
   * 旧法項目に内部項目を追加します。
   */
  protected void addOldLowElementArea(){

    oldLowElementArea.add(getOldLowH2103Group(), VRLayout.NORTH);

  }

  /**
   * 平成21年3月以前グループに内部項目を追加します。
   */
  protected void addOldLowH2103Group(){

    oldLowH2103Group.add(getFacilitiesDivision_H2103Container(), VRLayout.FLOW_INSETLINE_RETURN);

    oldLowH2103Group.add(getStaffAssignmentDivision_H2103Container(), VRLayout.FLOW_INSETLINE_RETURN);

    oldLowH2103Group.add(getNightWorkDivision_H2103Container(), VRLayout.FLOW_INSETLINE_RETURN);

    oldLowH2103Group.add(getUnitCareMaintenance_H2103Container(), VRLayout.FLOW_INSETLINE_RETURN);

    oldLowH2103Group.add(getRecuperationEnvironmentalContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    oldLowH2103Group.add(getNourishmentControlAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 施設区分ラジオグループに内部項目を追加します。
   */
  protected void addFacilitiesDivision_H2103(){

  }

  /**
   * 施設区分ラジオグループモデルに内部項目を追加します。
   */
  protected void addFacilitiesDivision_H2103Model(){

    getFacilitiesDivisionItem1_H2103().setButtonIndex(1);

    getFacilitiesDivision_H2103Model().add(getFacilitiesDivisionItem1_H2103());

    getFacilitiesDivisionItem2_H2103().setButtonIndex(2);

    getFacilitiesDivision_H2103Model().add(getFacilitiesDivisionItem2_H2103());

    getFacilitiesDivisionItem3_H2103().setButtonIndex(3);

    getFacilitiesDivision_H2103Model().add(getFacilitiesDivisionItem3_H2103());

  }

  /**
   * 病院療養型に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem1_H2103(){

  }

  /**
   * ユニット型病院療養型に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem2_H2103(){

  }

  /**
   * 病院経過型に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem3_H2103(){

  }

  /**
   * 人員配置区分ラジオグループに内部項目を追加します。
   */
  protected void addStaffAssignmentDivision_H2103(){

  }

  /**
   * 人員配置区分ラジオグループモデルに内部項目を追加します。
   */
  protected void addStaffAssignmentDivision_H2103Model(){

    getStaffAssignmentDivisionItem1_H2103().setButtonIndex(1);

    getStaffAssignmentDivision_H2103Model().add(getStaffAssignmentDivisionItem1_H2103());

    getStaffAssignmentDivisionItem2_H2103().setButtonIndex(2);

    getStaffAssignmentDivision_H2103Model().add(getStaffAssignmentDivisionItem2_H2103());

    getStaffAssignmentDivisionItem3_H2103().setButtonIndex(3);

    getStaffAssignmentDivision_H2103Model().add(getStaffAssignmentDivisionItem3_H2103());

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addStaffAssignmentDivisionItem1_H2103(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addStaffAssignmentDivisionItem2_H2103(){

  }

  /**
   * III型に内部項目を追加します。
   */
  protected void addStaffAssignmentDivisionItem3_H2103(){

  }

  /**
   * 夜間勤務条件基準ラジオグループに内部項目を追加します。
   */
  protected void addNightWorkDivision_H2103(){

  }

  /**
   * 夜間勤務条件基準ラジオグループモデルに内部項目を追加します。
   */
  protected void addNightWorkDivision_H2103Model(){

    getNightWorkDivisionItem1_H2103().setButtonIndex(1);

    getNightWorkDivision_H2103Model().add(getNightWorkDivisionItem1_H2103());

    getNightWorkDivisionItem2_H2103().setButtonIndex(2);

    getNightWorkDivision_H2103Model().add(getNightWorkDivisionItem2_H2103());

    getNightWorkDivisionItem3_H2103().setButtonIndex(3);

    getNightWorkDivision_H2103Model().add(getNightWorkDivisionItem3_H2103());

    getNightWorkDivisionItem4_H2103().setButtonIndex(4);

    getNightWorkDivision_H2103Model().add(getNightWorkDivisionItem4_H2103());

    getNightWorkDivisionItem5_H2103().setButtonIndex(5);

    getNightWorkDivision_H2103Model().add(getNightWorkDivisionItem5_H2103());

  }

  /**
   * 基準型に内部項目を追加します。
   */
  protected void addNightWorkDivisionItem1_H2103(){

  }

  /**
   * 加算型Iに内部項目を追加します。
   */
  protected void addNightWorkDivisionItem2_H2103(){

  }

  /**
   * 加算型IIに内部項目を追加します。
   */
  protected void addNightWorkDivisionItem3_H2103(){

  }

  /**
   * 加算型IIIに内部項目を追加します。
   */
  protected void addNightWorkDivisionItem4_H2103(){

  }

  /**
   * 減算型に内部項目を追加します。
   */
  protected void addNightWorkDivisionItem5_H2103(){

  }

  /**
   * ユニットケア体制に内部項目を追加します。
   */
  protected void addUnitCareMaintenance_H2103(){

  }

  /**
   * ユニットケア体制モデルに内部項目を追加します。
   */
  protected void addUnitCareMaintenance_H2103Model(){

    getUnitCareMaintenanceItem1_H2103().setButtonIndex(1);

    getUnitCareMaintenance_H2103Model().add(getUnitCareMaintenanceItem1_H2103());

    getUnitCareMaintenanceItem2_H2103().setButtonIndex(2);

    getUnitCareMaintenance_H2103Model().add(getUnitCareMaintenanceItem2_H2103());

  }

  /**
   * 対応不可に内部項目を追加します。
   */
  protected void addUnitCareMaintenanceItem1_H2103(){

  }

  /**
   * 対応可に内部項目を追加します。
   */
  protected void addUnitCareMaintenanceItem2_H2103(){

  }

  /**
   * 療養環境基準ラジオグループに内部項目を追加します。
   */
  protected void addRecuperationEnvironmental(){

  }

  /**
   * 療養環境基準ラジオグループモデルに内部項目を追加します。
   */
  protected void addRecuperationEnvironmentalModel(){

    getRecuperationEnvironmentalItem1().setButtonIndex(1);

    getRecuperationEnvironmentalModel().add(getRecuperationEnvironmentalItem1());

    getRecuperationEnvironmentalItem2().setButtonIndex(2);

    getRecuperationEnvironmentalModel().add(getRecuperationEnvironmentalItem2());

    getRecuperationEnvironmentalItem3().setButtonIndex(3);

    getRecuperationEnvironmentalModel().add(getRecuperationEnvironmentalItem3());

    getRecuperationEnvironmentalItem4().setButtonIndex(4);

    getRecuperationEnvironmentalModel().add(getRecuperationEnvironmentalItem4());

  }

  /**
   * 基準型に内部項目を追加します。
   */
  protected void addRecuperationEnvironmentalItem1(){

  }

  /**
   * 減算型Iに内部項目を追加します。
   */
  protected void addRecuperationEnvironmentalItem2(){

  }

  /**
   * 減算型IIに内部項目を追加します。
   */
  protected void addRecuperationEnvironmentalItem3(){

  }

  /**
   * 減算型IIIに内部項目を追加します。
   */
  protected void addRecuperationEnvironmentalItem4(){

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

    calculationDetails2.add(getReduceRateContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
      ACFrame.debugStart(new ACAffairInfo(QO004139Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004139Design getThis() {
    return this;
  }
}
