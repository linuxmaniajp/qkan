
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
 * 作成日: 2018/02/18  日本コンピューター株式会社 日高　しのぶ 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その多機能 (O)
 * プロセス 事業所情報登録 (004)
 * プログラム 短期入所療養介護（介護老人保健施設） (QO004_12211_201804)
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
 * 短期入所療養介護（介護老人保健施設）画面項目デザイン(QO004_12211_201804) 
 */
public class QO004_12211_201804Design extends QO004ProviderPanel {
  //GUIコンポーネント

  private ACGroupBox mainGroup;

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACPanel panel1;

  private ACValueArrayRadioButtonGroup facilitiesDivision;

  private ACLabelContainer facilitiesDivisionContainer;

  private ACListModelAdapter facilitiesDivisionModel;

  private ACRadioButtonItem facilitiesDivisionItem1;

  private ACRadioButtonItem facilitiesDivisionItem2;

  private ACRadioButtonItem facilitiesDivisionItem3;

  private ACRadioButtonItem facilitiesDivisionItem4;

  private ACRadioButtonItem facilitiesDivisionItem5;

  private ACRadioButtonItem facilitiesDivisionItem6;

  private ACRadioButtonItem facilitiesDivisionItem7;

  private ACRadioButtonItem facilitiesDivisionItem8;

  private ACLabelContainer personnelDivisionContainer;

  private ACValueArrayRadioButtonGroup personnelDivision1RadioGroup;

  private ACListModelAdapter personnelDivision1RadioGroupModel;

  private ACRadioButtonItem personnelDivision1RadioItem1;

  private ACRadioButtonItem personnelDivision1RadioItem2;

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

  private ACRadioButtonItem staffLackItem5;

  private ACRadioButtonItem staffLackItem6;

  private ACRadioButtonItem staffLackItem7;

  private ACValueArrayRadioButtonGroup unitCareMaintenance;

  private ACLabelContainer unitCareMaintenanceContainer;

  private ACListModelAdapter unitCareMaintenanceModel;

  private ACRadioButtonItem unitCareMaintenanceItem1;

  private ACRadioButtonItem unitCareMaintenanceItem2;

  private ACValueArrayRadioButtonGroup nightStaffDispositionAddRadioGroup;

  private ACLabelContainer nightStaffDispositionAddRadioGroupContainer;

  private ACListModelAdapter nightStaffDispositionAddRadioGroupModel;

  private ACRadioButtonItem nightStaffDispositionAddRadioItem1;

  private ACRadioButtonItem nightStaffDispositionAddRadioItem2;

  private ACLabelContainer rehabilitationDetailsContainer;

  private ACIntegerCheckBox rehabilitationDetailsItem1;

  private ACIntegerCheckBox rehabilitationDetailsItem2;

  private ACIntegerCheckBox rehabilitationDetailsItem3;

  private ACValueArrayRadioButtonGroup dementiaCare;

  private ACLabelContainer dementiaCareContainer;

  private ACListModelAdapter dementiaCareModel;

  private ACRadioButtonItem dementiaCareItem1;

  private ACRadioButtonItem dementiaCareItem2;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACPanel tab2;

  private ACPanel panel2;

  private ACValueArrayRadioButtonGroup aggressiveSupportRadioGroup;

  private ACLabelContainer aggressiveSupportRadioGroupContainer;

  private ACListModelAdapter aggressiveSupportRadioGroupModel;

  private ACRadioButtonItem aggressiveSupportRadioItem1;

  private ACRadioButtonItem aggressiveSupportRadioItem2;

  private ACRadioButtonItem aggressiveSupportRadioItem3;

  private ACValueArrayRadioButtonGroup meetingAndSendingOffSystem;

  private ACLabelContainer meetingAndSendingOffSystemContainer;

  private ACListModelAdapter meetingAndSendingOffSystemModel;

  private ACRadioButtonItem meetingAndSendingOffSystemItem1;

  private ACRadioButtonItem meetingAndSendingOffSystemItem2;

  private ACLabelContainer specialMedicalDetailsContainer;

  private ACIntegerCheckBox specialMedicalDetailsItem1;

  private ACIntegerCheckBox specialMedicalDetailsItem2;

  private ACValueArrayRadioButtonGroup MedicalSystemUpkeep;

  private ACLabelContainer MedicalSystemUpkeepContainer;

  private ACListModelAdapter MedicalSystemUpkeepModel;

  private ACRadioButtonItem MedicalSystemUpkeepItem1;

  private ACRadioButtonItem MedicalSystemUpkeepItem2;

  private ACValueArrayRadioButtonGroup MedicalSystemUpkeep2;

  private ACLabelContainer MedicalSystemUpkeep2Container;

  private ACListModelAdapter MedicalSystemUpkeep2Model;

  private ACRadioButtonItem MedicalSystemUpkeep2Item1;

  private ACRadioButtonItem MedicalSystemUpkeep2Item2;

  private ACValueArrayRadioButtonGroup medicalFoodAddRadioGroup;

  private ACLabelContainer medicalFoodAddRadioGroupContainer;

  private ACListModelAdapter medicalFoodAddRadioGroupModel;

  private ACRadioButtonItem medicalFoodAddRadioItem1;

  private ACRadioButtonItem medicalFoodAddRadioItem2;

  private ACValueArrayRadioButtonGroup dementiaCareRadioGroup;

  private ACLabelContainer dementiaCareRadioGroupContainer;

  private ACListModelAdapter dementiaCareRadioGroupModel;

  private ACRadioButtonItem dementiaCareRadioItem1;

  private ACRadioButtonItem dementiaCareRadioItem2;

  private ACRadioButtonItem dementiaCareRadioItem3;

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

      mainGroup.setText("短期入所療養介護（介護老人保健施設）");

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
   * 施設区分ラジオグループを取得します。
   * @return 施設区分ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getFacilitiesDivision(){
    if(facilitiesDivision==null){

      facilitiesDivision = new ACValueArrayRadioButtonGroup();

      getFacilitiesDivisionContainer().setText("施設等の区分");

      facilitiesDivision.setBindPath("1220101");

      facilitiesDivision.setUseClearButton(false);

      facilitiesDivision.setModel(getFacilitiesDivisionModel());

      facilitiesDivision.setValues(new int[]{1,2,3,4,5,6,7,8});

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
   * 介護老人保健施設（I）を取得します。
   * @return 介護老人保健施設（I）
   */
  public ACRadioButtonItem getFacilitiesDivisionItem1(){
    if(facilitiesDivisionItem1==null){

      facilitiesDivisionItem1 = new ACRadioButtonItem();

      facilitiesDivisionItem1.setText("介護老人保健施設（I）");

      facilitiesDivisionItem1.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem1.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem1();
    }
    return facilitiesDivisionItem1;

  }

  /**
   * ユニット型介護老人保健施設（I）を取得します。
   * @return ユニット型介護老人保健施設（I）
   */
  public ACRadioButtonItem getFacilitiesDivisionItem2(){
    if(facilitiesDivisionItem2==null){

      facilitiesDivisionItem2 = new ACRadioButtonItem();

      facilitiesDivisionItem2.setText("ユニット型介護老人保健施設（I）");

      facilitiesDivisionItem2.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem2.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem2();
    }
    return facilitiesDivisionItem2;

  }

  /**
   * 介護老人保健施設（II）を取得します。
   * @return 介護老人保健施設（II）
   */
  public ACRadioButtonItem getFacilitiesDivisionItem3(){
    if(facilitiesDivisionItem3==null){

      facilitiesDivisionItem3 = new ACRadioButtonItem();

      facilitiesDivisionItem3.setText("介護老人保健施設（II）");

      facilitiesDivisionItem3.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem3.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem3();
    }
    return facilitiesDivisionItem3;

  }

  /**
   * ユニット型介護老人保健施設（II）を取得します。
   * @return ユニット型介護老人保健施設（II）
   */
  public ACRadioButtonItem getFacilitiesDivisionItem4(){
    if(facilitiesDivisionItem4==null){

      facilitiesDivisionItem4 = new ACRadioButtonItem();

      facilitiesDivisionItem4.setText("ユニット型介護老人保健施設（II）");

      facilitiesDivisionItem4.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem4.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem4();
    }
    return facilitiesDivisionItem4;

  }

  /**
   * 介護老人保健施設（III）を取得します。
   * @return 介護老人保健施設（III）
   */
  public ACRadioButtonItem getFacilitiesDivisionItem5(){
    if(facilitiesDivisionItem5==null){

      facilitiesDivisionItem5 = new ACRadioButtonItem();

      facilitiesDivisionItem5.setText("介護老人保健施設（III）");

      facilitiesDivisionItem5.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem5.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem5();
    }
    return facilitiesDivisionItem5;

  }

  /**
   * ユニット型介護老人保健施設（III）を取得します。
   * @return ユニット型介護老人保健施設（III）
   */
  public ACRadioButtonItem getFacilitiesDivisionItem6(){
    if(facilitiesDivisionItem6==null){

      facilitiesDivisionItem6 = new ACRadioButtonItem();

      facilitiesDivisionItem6.setText("ユニット型介護老人保健施設（III）");

      facilitiesDivisionItem6.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem6.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem6();
    }
    return facilitiesDivisionItem6;

  }

  /**
   * 介護老人保健施設（IV）を取得します。
   * @return 介護老人保健施設（IV）
   */
  public ACRadioButtonItem getFacilitiesDivisionItem7(){
    if(facilitiesDivisionItem7==null){

      facilitiesDivisionItem7 = new ACRadioButtonItem();

      facilitiesDivisionItem7.setText("介護老人保健施設（IV）");

      facilitiesDivisionItem7.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem7.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem7();
    }
    return facilitiesDivisionItem7;

  }

  /**
   * ユニット型介護老人保健施設（IV）を取得します。
   * @return ユニット型介護老人保健施設（IV）
   */
  public ACRadioButtonItem getFacilitiesDivisionItem8(){
    if(facilitiesDivisionItem8==null){

      facilitiesDivisionItem8 = new ACRadioButtonItem();

      facilitiesDivisionItem8.setText("ユニット型介護老人保健施設（IV）");

      facilitiesDivisionItem8.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem8.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem8();
    }
    return facilitiesDivisionItem8;

  }

  /**
   * 人員配置区分コンテナを取得します。
   * @return 人員配置区分コンテナ
   */
  public ACLabelContainer getPersonnelDivisionContainer(){
    if(personnelDivisionContainer==null){

      personnelDivisionContainer = new ACLabelContainer();

      personnelDivisionContainer.setText("人員配置区分");

      personnelDivisionContainer.setFollowChildEnabled(true);

      addPersonnelDivisionContainer();
    }
    return personnelDivisionContainer;

  }

  /**
   * 人員配置区分１を取得します。
   * @return 人員配置区分１
   */
  public ACValueArrayRadioButtonGroup getPersonnelDivision1RadioGroup(){
    if(personnelDivision1RadioGroup==null){

      personnelDivision1RadioGroup = new ACValueArrayRadioButtonGroup();

      personnelDivision1RadioGroup.setBindPath("1220127");

      personnelDivision1RadioGroup.setUseClearButton(false);

      personnelDivision1RadioGroup.setModel(getPersonnelDivision1RadioGroupModel());

      personnelDivision1RadioGroup.setValues(new int[]{1,2});

      addPersonnelDivision1RadioGroup();
    }
    return personnelDivision1RadioGroup;

  }

  /**
   * 人員配置区分１モデルを取得します。
   * @return 人員配置区分１モデル
   */
  protected ACListModelAdapter getPersonnelDivision1RadioGroupModel(){
    if(personnelDivision1RadioGroupModel==null){
      personnelDivision1RadioGroupModel = new ACListModelAdapter();
      addPersonnelDivision1RadioGroupModel();
    }
    return personnelDivision1RadioGroupModel;
  }

  /**
   * 基本型を取得します。
   * @return 基本型
   */
  public ACRadioButtonItem getPersonnelDivision1RadioItem1(){
    if(personnelDivision1RadioItem1==null){

      personnelDivision1RadioItem1 = new ACRadioButtonItem();

      personnelDivision1RadioItem1.setText("基本型");

      personnelDivision1RadioItem1.setGroup(getPersonnelDivision1RadioGroup());

      personnelDivision1RadioItem1.setConstraints(VRLayout.FLOW);

      addPersonnelDivision1RadioItem1();
    }
    return personnelDivision1RadioItem1;

  }

  /**
   * 在宅強化型を取得します。
   * @return 在宅強化型
   */
  public ACRadioButtonItem getPersonnelDivision1RadioItem2(){
    if(personnelDivision1RadioItem2==null){

      personnelDivision1RadioItem2 = new ACRadioButtonItem();

      personnelDivision1RadioItem2.setText("在宅強化型");

      personnelDivision1RadioItem2.setGroup(getPersonnelDivision1RadioGroup());

      personnelDivision1RadioItem2.setConstraints(VRLayout.FLOW);

      addPersonnelDivision1RadioItem2();
    }
    return personnelDivision1RadioItem2;

  }

  /**
   * 夜間勤務条件基準ラジオグループを取得します。
   * @return 夜間勤務条件基準ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getNightWorkDivision(){
    if(nightWorkDivision==null){

      nightWorkDivision = new ACValueArrayRadioButtonGroup();

      getNightWorkDivisionContainer().setText("夜間勤務条件基準");

      nightWorkDivision.setBindPath("1220102");

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

      nightWorkDivisionItem1.setConstraints(VRLayout.FLOW);

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

      nightWorkDivisionItem2.setConstraints(VRLayout.FLOW);

      addNightWorkDivisionItem2();
    }
    return nightWorkDivisionItem2;

  }

  /**
   * 職員の欠員による減算の状況を取得します。
   * @return 職員の欠員による減算の状況
   */
  public ACValueArrayRadioButtonGroup getStaffLack(){
    if(staffLack==null){

      staffLack = new ACValueArrayRadioButtonGroup();

      getStaffLackContainer().setText("職員の欠員による減算の状況");

      staffLack.setBindPath("1220126");

      staffLack.setUseClearButton(false);

      staffLack.setModel(getStaffLackModel());

      staffLack.setValues(new int[]{1,2,3,4,5,6,7});

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

      staffLackItem4.setConstraints(VRLayout.FLOW_RETURN);

      addStaffLackItem4();
    }
    return staffLackItem4;

  }

  /**
   * 理学療法士を取得します。
   * @return 理学療法士
   */
  public ACRadioButtonItem getStaffLackItem5(){
    if(staffLackItem5==null){

      staffLackItem5 = new ACRadioButtonItem();

      staffLackItem5.setText("理学療法士");

      staffLackItem5.setGroup(getStaffLack());

      staffLackItem5.setConstraints(VRLayout.FLOW);

      addStaffLackItem5();
    }
    return staffLackItem5;

  }

  /**
   * 作業療法士を取得します。
   * @return 作業療法士
   */
  public ACRadioButtonItem getStaffLackItem6(){
    if(staffLackItem6==null){

      staffLackItem6 = new ACRadioButtonItem();

      staffLackItem6.setText("作業療法士");

      staffLackItem6.setGroup(getStaffLack());

      staffLackItem6.setConstraints(VRLayout.FLOW);

      addStaffLackItem6();
    }
    return staffLackItem6;

  }

  /**
   * 言語聴覚士を取得します。
   * @return 言語聴覚士
   */
  public ACRadioButtonItem getStaffLackItem7(){
    if(staffLackItem7==null){

      staffLackItem7 = new ACRadioButtonItem();

      staffLackItem7.setText("言語聴覚士");

      staffLackItem7.setGroup(getStaffLack());

      staffLackItem7.setConstraints(VRLayout.FLOW);

      addStaffLackItem7();
    }
    return staffLackItem7;

  }

  /**
   * ユニットケア体制を取得します。
   * @return ユニットケア体制
   */
  public ACValueArrayRadioButtonGroup getUnitCareMaintenance(){
    if(unitCareMaintenance==null){

      unitCareMaintenance = new ACValueArrayRadioButtonGroup();

      getUnitCareMaintenanceContainer().setText("ユニットケア体制");

      unitCareMaintenance.setBindPath("1220117");

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
   * 夜勤職員配置加算を取得します。
   * @return 夜勤職員配置加算
   */
  public ACValueArrayRadioButtonGroup getNightStaffDispositionAddRadioGroup(){
    if(nightStaffDispositionAddRadioGroup==null){

      nightStaffDispositionAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getNightStaffDispositionAddRadioGroupContainer().setText("夜勤職員配置加算");

      nightStaffDispositionAddRadioGroup.setBindPath("1220122");

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
   * 言語聴覚療法チェックを取得します。
   * @return 言語聴覚療法チェック
   */
  public ACIntegerCheckBox getRehabilitationDetailsItem1(){
    if(rehabilitationDetailsItem1==null){

      rehabilitationDetailsItem1 = new ACIntegerCheckBox();

      rehabilitationDetailsItem1.setText("言語聴覚療法");

      rehabilitationDetailsItem1.setBindPath("3010106");

      rehabilitationDetailsItem1.setSelectValue(2);

      rehabilitationDetailsItem1.setUnSelectValue(1);

      addRehabilitationDetailsItem1();
    }
    return rehabilitationDetailsItem1;

  }

  /**
   * 精神科作業療法チェックを取得します。
   * @return 精神科作業療法チェック
   */
  public ACIntegerCheckBox getRehabilitationDetailsItem2(){
    if(rehabilitationDetailsItem2==null){

      rehabilitationDetailsItem2 = new ACIntegerCheckBox();

      rehabilitationDetailsItem2.setText("精神科作業療法");

      rehabilitationDetailsItem2.setBindPath("3010107");

      rehabilitationDetailsItem2.setSelectValue(2);

      rehabilitationDetailsItem2.setUnSelectValue(1);

      addRehabilitationDetailsItem2();
    }
    return rehabilitationDetailsItem2;

  }

  /**
   * その他チェックを取得します。
   * @return その他チェック
   */
  public ACIntegerCheckBox getRehabilitationDetailsItem3(){
    if(rehabilitationDetailsItem3==null){

      rehabilitationDetailsItem3 = new ACIntegerCheckBox();

      rehabilitationDetailsItem3.setText("その他");

      rehabilitationDetailsItem3.setBindPath("3010108");

      rehabilitationDetailsItem3.setSelectValue(2);

      rehabilitationDetailsItem3.setUnSelectValue(1);

      addRehabilitationDetailsItem3();
    }
    return rehabilitationDetailsItem3;

  }

  /**
   * 認知症ケア加算を取得します。
   * @return 認知症ケア加算
   */
  public ACValueArrayRadioButtonGroup getDementiaCare(){
    if(dementiaCare==null){

      dementiaCare = new ACValueArrayRadioButtonGroup();

      getDementiaCareContainer().setText("認知症ケア加算");

      dementiaCare.setBindPath("1220119");

      dementiaCare.setUseClearButton(false);

      dementiaCare.setModel(getDementiaCareModel());

      dementiaCare.setValues(new int[]{1,2});

      addDementiaCare();
    }
    return dementiaCare;

  }

  /**
   * 認知症ケア加算コンテナを取得します。
   * @return 認知症ケア加算コンテナ
   */
  protected ACLabelContainer getDementiaCareContainer(){
    if(dementiaCareContainer==null){
      dementiaCareContainer = new ACLabelContainer();
      dementiaCareContainer.setFollowChildEnabled(true);
      dementiaCareContainer.setVAlignment(VRLayout.CENTER);
      dementiaCareContainer.add(getDementiaCare(), null);
    }
    return dementiaCareContainer;
  }

  /**
   * 認知症ケア加算モデルを取得します。
   * @return 認知症ケア加算モデル
   */
  protected ACListModelAdapter getDementiaCareModel(){
    if(dementiaCareModel==null){
      dementiaCareModel = new ACListModelAdapter();
      addDementiaCareModel();
    }
    return dementiaCareModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getDementiaCareItem1(){
    if(dementiaCareItem1==null){

      dementiaCareItem1 = new ACRadioButtonItem();

      dementiaCareItem1.setText("なし");

      dementiaCareItem1.setGroup(getDementiaCare());

      dementiaCareItem1.setConstraints(VRLayout.FLOW);

      addDementiaCareItem1();
    }
    return dementiaCareItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getDementiaCareItem2(){
    if(dementiaCareItem2==null){

      dementiaCareItem2 = new ACRadioButtonItem();

      dementiaCareItem2.setText("あり");

      dementiaCareItem2.setGroup(getDementiaCare());

      dementiaCareItem2.setConstraints(VRLayout.FLOW);

      addDementiaCareItem2();
    }
    return dementiaCareItem2;

  }

  /**
   * 若年性認知症利用者受入加算を取得します。
   * @return 若年性認知症利用者受入加算
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("若年性認知症利用者受入加算");

      youngDementiaPatinetAddRadioGroup.setBindPath("1220124");

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
   * 算定項目領域を取得します。
   * @return 算定項目領域
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
   * 在宅復帰・在宅療養支援機能加算を取得します。
   * @return 在宅復帰・在宅療養支援機能加算
   */
  public ACValueArrayRadioButtonGroup getAggressiveSupportRadioGroup(){
    if(aggressiveSupportRadioGroup==null){

      aggressiveSupportRadioGroup = new ACValueArrayRadioButtonGroup();

      getAggressiveSupportRadioGroupContainer().setText("在宅復帰・在宅療養支援機能加算");

      aggressiveSupportRadioGroup.setBindPath("1220131");

      aggressiveSupportRadioGroup.setNoSelectIndex(0);

      aggressiveSupportRadioGroup.setUseClearButton(false);

      aggressiveSupportRadioGroup.setModel(getAggressiveSupportRadioGroupModel());

      aggressiveSupportRadioGroup.setValues(new int[]{1,2,3});

      addAggressiveSupportRadioGroup();
    }
    return aggressiveSupportRadioGroup;

  }

  /**
   * 在宅復帰・在宅療養支援機能加算コンテナを取得します。
   * @return 在宅復帰・在宅療養支援機能加算コンテナ
   */
  protected ACLabelContainer getAggressiveSupportRadioGroupContainer(){
    if(aggressiveSupportRadioGroupContainer==null){
      aggressiveSupportRadioGroupContainer = new ACLabelContainer();
      aggressiveSupportRadioGroupContainer.setFollowChildEnabled(true);
      aggressiveSupportRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      aggressiveSupportRadioGroupContainer.add(getAggressiveSupportRadioGroup(), null);
    }
    return aggressiveSupportRadioGroupContainer;
  }

  /**
   * 在宅復帰・在宅療養支援機能加算モデルを取得します。
   * @return 在宅復帰・在宅療養支援機能加算モデル
   */
  protected ACListModelAdapter getAggressiveSupportRadioGroupModel(){
    if(aggressiveSupportRadioGroupModel==null){
      aggressiveSupportRadioGroupModel = new ACListModelAdapter();
      addAggressiveSupportRadioGroupModel();
    }
    return aggressiveSupportRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getAggressiveSupportRadioItem1(){
    if(aggressiveSupportRadioItem1==null){

      aggressiveSupportRadioItem1 = new ACRadioButtonItem();

      aggressiveSupportRadioItem1.setText("なし");

      aggressiveSupportRadioItem1.setGroup(getAggressiveSupportRadioGroup());

      aggressiveSupportRadioItem1.setConstraints(VRLayout.FLOW);

      addAggressiveSupportRadioItem1();
    }
    return aggressiveSupportRadioItem1;

  }

  /**
   * 加算Iを取得します。
   * @return 加算I
   */
  public ACRadioButtonItem getAggressiveSupportRadioItem2(){
    if(aggressiveSupportRadioItem2==null){

      aggressiveSupportRadioItem2 = new ACRadioButtonItem();

      aggressiveSupportRadioItem2.setText("加算I");

      aggressiveSupportRadioItem2.setGroup(getAggressiveSupportRadioGroup());

      aggressiveSupportRadioItem2.setConstraints(VRLayout.FLOW);

      addAggressiveSupportRadioItem2();
    }
    return aggressiveSupportRadioItem2;

  }

  /**
   * 加算IIを取得します。
   * @return 加算II
   */
  public ACRadioButtonItem getAggressiveSupportRadioItem3(){
    if(aggressiveSupportRadioItem3==null){

      aggressiveSupportRadioItem3 = new ACRadioButtonItem();

      aggressiveSupportRadioItem3.setText("加算II");

      aggressiveSupportRadioItem3.setGroup(getAggressiveSupportRadioGroup());

      aggressiveSupportRadioItem3.setConstraints(VRLayout.FLOW);

      addAggressiveSupportRadioItem3();
    }
    return aggressiveSupportRadioItem3;

  }

  /**
   * 送迎体制ラジオグループを取得します。
   * @return 送迎体制ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getMeetingAndSendingOffSystem(){
    if(meetingAndSendingOffSystem==null){

      meetingAndSendingOffSystem = new ACValueArrayRadioButtonGroup();

      getMeetingAndSendingOffSystemContainer().setText("送迎体制");

      meetingAndSendingOffSystem.setBindPath("1220105");

      meetingAndSendingOffSystem.setUseClearButton(false);

      meetingAndSendingOffSystem.setModel(getMeetingAndSendingOffSystemModel());

      meetingAndSendingOffSystem.setValues(new int[]{1,2});

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

      meetingAndSendingOffSystemItem1.setConstraints(VRLayout.FLOW);

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

      meetingAndSendingOffSystemItem2.setConstraints(VRLayout.FLOW);

      addMeetingAndSendingOffSystemItem2();
    }
    return meetingAndSendingOffSystemItem2;

  }

  /**
   * 特別療養費項目コンテナを取得します。
   * @return 特別療養費項目コンテナ
   */
  public ACLabelContainer getSpecialMedicalDetailsContainer(){
    if(specialMedicalDetailsContainer==null){

      specialMedicalDetailsContainer = new ACLabelContainer();

      specialMedicalDetailsContainer.setText("特別療養費加算項目");

      specialMedicalDetailsContainer.setFollowChildEnabled(true);

      addSpecialMedicalDetailsContainer();
    }
    return specialMedicalDetailsContainer;

  }

  /**
   * 重症皮膚潰瘍管理指導チェックを取得します。
   * @return 重症皮膚潰瘍管理指導チェック
   */
  public ACIntegerCheckBox getSpecialMedicalDetailsItem1(){
    if(specialMedicalDetailsItem1==null){

      specialMedicalDetailsItem1 = new ACIntegerCheckBox();

      specialMedicalDetailsItem1.setText("重症皮膚潰瘍管理指導");

      specialMedicalDetailsItem1.setBindPath("3010109");

      specialMedicalDetailsItem1.setSelectValue(2);

      specialMedicalDetailsItem1.setUnSelectValue(1);

      addSpecialMedicalDetailsItem1();
    }
    return specialMedicalDetailsItem1;

  }

  /**
   * 薬剤管理指導チェックを取得します。
   * @return 薬剤管理指導チェック
   */
  public ACIntegerCheckBox getSpecialMedicalDetailsItem2(){
    if(specialMedicalDetailsItem2==null){

      specialMedicalDetailsItem2 = new ACIntegerCheckBox();

      specialMedicalDetailsItem2.setText("薬剤管理指導");

      specialMedicalDetailsItem2.setBindPath("3010110");

      specialMedicalDetailsItem2.setSelectValue(2);

      specialMedicalDetailsItem2.setUnSelectValue(1);

      addSpecialMedicalDetailsItem2();
    }
    return specialMedicalDetailsItem2;

  }

  /**
   * 療養体制維持特別加算ラジオグループを取得します。
   * @return 療養体制維持特別加算ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getMedicalSystemUpkeep(){
    if(MedicalSystemUpkeep==null){

      MedicalSystemUpkeep = new ACValueArrayRadioButtonGroup();

      getMedicalSystemUpkeepContainer().setText("療養体制維持特別加算I");

      MedicalSystemUpkeep.setBindPath("1220121");

      MedicalSystemUpkeep.setUseClearButton(false);

      MedicalSystemUpkeep.setModel(getMedicalSystemUpkeepModel());

      MedicalSystemUpkeep.setValues(new int[]{1,2});

      addMedicalSystemUpkeep();
    }
    return MedicalSystemUpkeep;

  }

  /**
   * 療養体制維持特別加算ラジオグループコンテナを取得します。
   * @return 療養体制維持特別加算ラジオグループコンテナ
   */
  protected ACLabelContainer getMedicalSystemUpkeepContainer(){
    if(MedicalSystemUpkeepContainer==null){
      MedicalSystemUpkeepContainer = new ACLabelContainer();
      MedicalSystemUpkeepContainer.setFollowChildEnabled(true);
      MedicalSystemUpkeepContainer.setVAlignment(VRLayout.CENTER);
      MedicalSystemUpkeepContainer.add(getMedicalSystemUpkeep(), null);
    }
    return MedicalSystemUpkeepContainer;
  }

  /**
   * 療養体制維持特別加算ラジオグループモデルを取得します。
   * @return 療養体制維持特別加算ラジオグループモデル
   */
  protected ACListModelAdapter getMedicalSystemUpkeepModel(){
    if(MedicalSystemUpkeepModel==null){
      MedicalSystemUpkeepModel = new ACListModelAdapter();
      addMedicalSystemUpkeepModel();
    }
    return MedicalSystemUpkeepModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalSystemUpkeepItem1(){
    if(MedicalSystemUpkeepItem1==null){

      MedicalSystemUpkeepItem1 = new ACRadioButtonItem();

      MedicalSystemUpkeepItem1.setText("なし");

      MedicalSystemUpkeepItem1.setGroup(getMedicalSystemUpkeep());

      MedicalSystemUpkeepItem1.setConstraints(VRLayout.FLOW);

      addMedicalSystemUpkeepItem1();
    }
    return MedicalSystemUpkeepItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMedicalSystemUpkeepItem2(){
    if(MedicalSystemUpkeepItem2==null){

      MedicalSystemUpkeepItem2 = new ACRadioButtonItem();

      MedicalSystemUpkeepItem2.setText("あり");

      MedicalSystemUpkeepItem2.setGroup(getMedicalSystemUpkeep());

      MedicalSystemUpkeepItem2.setConstraints(VRLayout.FLOW);

      addMedicalSystemUpkeepItem2();
    }
    return MedicalSystemUpkeepItem2;

  }

  /**
   * 療養体制維持特別加算ラジオグループを取得します。
   * @return 療養体制維持特別加算ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getMedicalSystemUpkeep2(){
    if(MedicalSystemUpkeep2==null){

      MedicalSystemUpkeep2 = new ACValueArrayRadioButtonGroup();

      getMedicalSystemUpkeep2Container().setText("療養体制維持特別加算II");

      MedicalSystemUpkeep2.setBindPath("1220133");

      MedicalSystemUpkeep2.setUseClearButton(false);

      MedicalSystemUpkeep2.setModel(getMedicalSystemUpkeep2Model());

      MedicalSystemUpkeep2.setValues(new int[]{1,2});

      addMedicalSystemUpkeep2();
    }
    return MedicalSystemUpkeep2;

  }

  /**
   * 療養体制維持特別加算ラジオグループコンテナを取得します。
   * @return 療養体制維持特別加算ラジオグループコンテナ
   */
  protected ACLabelContainer getMedicalSystemUpkeep2Container(){
    if(MedicalSystemUpkeep2Container==null){
      MedicalSystemUpkeep2Container = new ACLabelContainer();
      MedicalSystemUpkeep2Container.setFollowChildEnabled(true);
      MedicalSystemUpkeep2Container.setVAlignment(VRLayout.CENTER);
      MedicalSystemUpkeep2Container.add(getMedicalSystemUpkeep2(), null);
    }
    return MedicalSystemUpkeep2Container;
  }

  /**
   * 療養体制維持特別加算ラジオグループモデルを取得します。
   * @return 療養体制維持特別加算ラジオグループモデル
   */
  protected ACListModelAdapter getMedicalSystemUpkeep2Model(){
    if(MedicalSystemUpkeep2Model==null){
      MedicalSystemUpkeep2Model = new ACListModelAdapter();
      addMedicalSystemUpkeep2Model();
    }
    return MedicalSystemUpkeep2Model;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalSystemUpkeep2Item1(){
    if(MedicalSystemUpkeep2Item1==null){

      MedicalSystemUpkeep2Item1 = new ACRadioButtonItem();

      MedicalSystemUpkeep2Item1.setText("なし");

      MedicalSystemUpkeep2Item1.setGroup(getMedicalSystemUpkeep2());

      MedicalSystemUpkeep2Item1.setConstraints(VRLayout.FLOW);

      addMedicalSystemUpkeep2Item1();
    }
    return MedicalSystemUpkeep2Item1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMedicalSystemUpkeep2Item2(){
    if(MedicalSystemUpkeep2Item2==null){

      MedicalSystemUpkeep2Item2 = new ACRadioButtonItem();

      MedicalSystemUpkeep2Item2.setText("あり");

      MedicalSystemUpkeep2Item2.setGroup(getMedicalSystemUpkeep2());

      MedicalSystemUpkeep2Item2.setConstraints(VRLayout.FLOW);

      addMedicalSystemUpkeep2Item2();
    }
    return MedicalSystemUpkeep2Item2;

  }

  /**
   * 療養食加算を取得します。
   * @return 療養食加算
   */
  public ACValueArrayRadioButtonGroup getMedicalFoodAddRadioGroup(){
    if(medicalFoodAddRadioGroup==null){

      medicalFoodAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getMedicalFoodAddRadioGroupContainer().setText("療養食加算");

      medicalFoodAddRadioGroup.setBindPath("1220123");

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
   * 認知症専門ケア加算を取得します。
   * @return 認知症専門ケア加算
   */
  public ACValueArrayRadioButtonGroup getDementiaCareRadioGroup(){
    if(dementiaCareRadioGroup==null){

      dementiaCareRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaCareRadioGroupContainer().setText("認知症専門ケア加算");

      dementiaCareRadioGroup.setBindPath("1220132");

      dementiaCareRadioGroup.setNoSelectIndex(0);

      dementiaCareRadioGroup.setUseClearButton(false);

      dementiaCareRadioGroup.setModel(getDementiaCareRadioGroupModel());

      dementiaCareRadioGroup.setValues(new int[]{1,2,3});

      addDementiaCareRadioGroup();
    }
    return dementiaCareRadioGroup;

  }

  /**
   * 認知症専門ケア加算コンテナを取得します。
   * @return 認知症専門ケア加算コンテナ
   */
  protected ACLabelContainer getDementiaCareRadioGroupContainer(){
    if(dementiaCareRadioGroupContainer==null){
      dementiaCareRadioGroupContainer = new ACLabelContainer();
      dementiaCareRadioGroupContainer.setFollowChildEnabled(true);
      dementiaCareRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      dementiaCareRadioGroupContainer.add(getDementiaCareRadioGroup(), null);
    }
    return dementiaCareRadioGroupContainer;
  }

  /**
   * 認知症専門ケア加算モデルを取得します。
   * @return 認知症専門ケア加算モデル
   */
  protected ACListModelAdapter getDementiaCareRadioGroupModel(){
    if(dementiaCareRadioGroupModel==null){
      dementiaCareRadioGroupModel = new ACListModelAdapter();
      addDementiaCareRadioGroupModel();
    }
    return dementiaCareRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getDementiaCareRadioItem1(){
    if(dementiaCareRadioItem1==null){

      dementiaCareRadioItem1 = new ACRadioButtonItem();

      dementiaCareRadioItem1.setText("なし");

      dementiaCareRadioItem1.setGroup(getDementiaCareRadioGroup());

      dementiaCareRadioItem1.setConstraints(VRLayout.FLOW);

      addDementiaCareRadioItem1();
    }
    return dementiaCareRadioItem1;

  }

  /**
   * 加算Iを取得します。
   * @return 加算I
   */
  public ACRadioButtonItem getDementiaCareRadioItem2(){
    if(dementiaCareRadioItem2==null){

      dementiaCareRadioItem2 = new ACRadioButtonItem();

      dementiaCareRadioItem2.setText("加算I");

      dementiaCareRadioItem2.setGroup(getDementiaCareRadioGroup());

      dementiaCareRadioItem2.setConstraints(VRLayout.FLOW);

      addDementiaCareRadioItem2();
    }
    return dementiaCareRadioItem2;

  }

  /**
   * 加算IIを取得します。
   * @return 加算II
   */
  public ACRadioButtonItem getDementiaCareRadioItem3(){
    if(dementiaCareRadioItem3==null){

      dementiaCareRadioItem3 = new ACRadioButtonItem();

      dementiaCareRadioItem3.setText("加算II");

      dementiaCareRadioItem3.setGroup(getDementiaCareRadioGroup());

      dementiaCareRadioItem3.setConstraints(VRLayout.FLOW);

      addDementiaCareRadioItem3();
    }
    return dementiaCareRadioItem3;

  }

  /**
   * サービス提供体制強化加算を取得します。
   * @return サービス提供体制強化加算
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("サービス提供体制強化加算");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1220125");

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

      dinnerTotal.setBindPath("1220109");

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

      dinnerMorning.setBindPath("1220110");

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

      dinnerNoon.setBindPath("1220111");

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

      dinnerNight.setBindPath("1220112");

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

      unitRoom.setBindPath("1220113");

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

      unitSemiRoom.setBindPath("1220114");

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

      normalRoom.setBindPath("1220115");

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

      tasyouRoom.setBindPath("1220116");

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
  public QO004_12211_201804Design() {

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

    tab1.add(getPanel1(), VRLayout.NORTH);

  }

  /**
   * 算定項目領域に内部項目を追加します。
   */
  protected void addPanel1(){

    panel1.add(getFacilitiesDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    panel1.add(getPersonnelDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    panel1.add(getNightWorkDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    panel1.add(getStaffLackContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    panel1.add(getUnitCareMaintenanceContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    panel1.add(getNightStaffDispositionAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    panel1.add(getRehabilitationDetailsContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    panel1.add(getDementiaCareContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    panel1.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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

    getFacilitiesDivisionItem5().setButtonIndex(5);

    getFacilitiesDivisionModel().add(getFacilitiesDivisionItem5());

    getFacilitiesDivisionItem6().setButtonIndex(6);

    getFacilitiesDivisionModel().add(getFacilitiesDivisionItem6());

    getFacilitiesDivisionItem7().setButtonIndex(7);

    getFacilitiesDivisionModel().add(getFacilitiesDivisionItem7());

    getFacilitiesDivisionItem8().setButtonIndex(8);

    getFacilitiesDivisionModel().add(getFacilitiesDivisionItem8());

  }

  /**
   * 介護老人保健施設（I）に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem1(){

  }

  /**
   * ユニット型介護老人保健施設（I）に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem2(){

  }

  /**
   * 介護老人保健施設（II）に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem3(){

  }

  /**
   * ユニット型介護老人保健施設（II）に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem4(){

  }

  /**
   * 介護老人保健施設（III）に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem5(){

  }

  /**
   * ユニット型介護老人保健施設（III）に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem6(){

  }

  /**
   * 介護老人保健施設（IV）に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem7(){

  }

  /**
   * ユニット型介護老人保健施設（IV）に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem8(){

  }

  /**
   * 人員配置区分コンテナに内部項目を追加します。
   */
  protected void addPersonnelDivisionContainer(){

    personnelDivisionContainer.add(getPersonnelDivision1RadioGroup(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 人員配置区分１に内部項目を追加します。
   */
  protected void addPersonnelDivision1RadioGroup(){

  }

  /**
   * 人員配置区分１モデルに内部項目を追加します。
   */
  protected void addPersonnelDivision1RadioGroupModel(){

    getPersonnelDivision1RadioItem1().setButtonIndex(1);

    getPersonnelDivision1RadioGroupModel().add(getPersonnelDivision1RadioItem1());

    getPersonnelDivision1RadioItem2().setButtonIndex(2);

    getPersonnelDivision1RadioGroupModel().add(getPersonnelDivision1RadioItem2());

  }

  /**
   * 基本型に内部項目を追加します。
   */
  protected void addPersonnelDivision1RadioItem1(){

  }

  /**
   * 在宅強化型に内部項目を追加します。
   */
  protected void addPersonnelDivision1RadioItem2(){

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

    getStaffLackItem5().setButtonIndex(5);

    getStaffLackModel().add(getStaffLackItem5());

    getStaffLackItem6().setButtonIndex(6);

    getStaffLackModel().add(getStaffLackItem6());

    getStaffLackItem7().setButtonIndex(7);

    getStaffLackModel().add(getStaffLackItem7());

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
   * 理学療法士に内部項目を追加します。
   */
  protected void addStaffLackItem5(){

  }

  /**
   * 作業療法士に内部項目を追加します。
   */
  protected void addStaffLackItem6(){

  }

  /**
   * 言語聴覚士に内部項目を追加します。
   */
  protected void addStaffLackItem7(){

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
   * リハビリ提供体制コンテナに内部項目を追加します。
   */
  protected void addRehabilitationDetailsContainer(){

    rehabilitationDetailsContainer.add(getRehabilitationDetailsItem1(), VRLayout.FLOW);

    rehabilitationDetailsContainer.add(getRehabilitationDetailsItem2(), VRLayout.FLOW);

    rehabilitationDetailsContainer.add(getRehabilitationDetailsItem3(), VRLayout.FLOW);

  }

  /**
   * 言語聴覚療法チェックに内部項目を追加します。
   */
  protected void addRehabilitationDetailsItem1(){

  }

  /**
   * 精神科作業療法チェックに内部項目を追加します。
   */
  protected void addRehabilitationDetailsItem2(){

  }

  /**
   * その他チェックに内部項目を追加します。
   */
  protected void addRehabilitationDetailsItem3(){

  }

  /**
   * 認知症ケア加算に内部項目を追加します。
   */
  protected void addDementiaCare(){

  }

  /**
   * 認知症ケア加算モデルに内部項目を追加します。
   */
  protected void addDementiaCareModel(){

    getDementiaCareItem1().setButtonIndex(1);

    getDementiaCareModel().add(getDementiaCareItem1());

    getDementiaCareItem2().setButtonIndex(2);

    getDementiaCareModel().add(getDementiaCareItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addDementiaCareItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addDementiaCareItem2(){

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
   * タブ2に内部項目を追加します。
   */
  protected void addTab2(){

    tab2.add(getPanel2(), VRLayout.NORTH);

    tab2.add(getStandardMoneyGroup(), VRLayout.NORTH);

  }

  /**
   * 算定項目領域に内部項目を追加します。
   */
  protected void addPanel2(){

    panel2.add(getAggressiveSupportRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    panel2.add(getMeetingAndSendingOffSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    panel2.add(getSpecialMedicalDetailsContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    panel2.add(getMedicalSystemUpkeepContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    panel2.add(getMedicalSystemUpkeep2Container(), VRLayout.FLOW_INSETLINE_RETURN);

    panel2.add(getMedicalFoodAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    panel2.add(getDementiaCareRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    panel2.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    panel2.add(getStaffUpgradeRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 在宅復帰・在宅療養支援機能加算に内部項目を追加します。
   */
  protected void addAggressiveSupportRadioGroup(){

  }

  /**
   * 在宅復帰・在宅療養支援機能加算モデルに内部項目を追加します。
   */
  protected void addAggressiveSupportRadioGroupModel(){

    getAggressiveSupportRadioItem1().setButtonIndex(1);

    getAggressiveSupportRadioGroupModel().add(getAggressiveSupportRadioItem1());

    getAggressiveSupportRadioItem2().setButtonIndex(2);

    getAggressiveSupportRadioGroupModel().add(getAggressiveSupportRadioItem2());

    getAggressiveSupportRadioItem3().setButtonIndex(3);

    getAggressiveSupportRadioGroupModel().add(getAggressiveSupportRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addAggressiveSupportRadioItem1(){

  }

  /**
   * 加算Iに内部項目を追加します。
   */
  protected void addAggressiveSupportRadioItem2(){

  }

  /**
   * 加算IIに内部項目を追加します。
   */
  protected void addAggressiveSupportRadioItem3(){

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
   * 特別療養費項目コンテナに内部項目を追加します。
   */
  protected void addSpecialMedicalDetailsContainer(){

    specialMedicalDetailsContainer.add(getSpecialMedicalDetailsItem1(), VRLayout.FLOW);

    specialMedicalDetailsContainer.add(getSpecialMedicalDetailsItem2(), VRLayout.FLOW);

  }

  /**
   * 重症皮膚潰瘍管理指導チェックに内部項目を追加します。
   */
  protected void addSpecialMedicalDetailsItem1(){

  }

  /**
   * 薬剤管理指導チェックに内部項目を追加します。
   */
  protected void addSpecialMedicalDetailsItem2(){

  }

  /**
   * 療養体制維持特別加算ラジオグループに内部項目を追加します。
   */
  protected void addMedicalSystemUpkeep(){

  }

  /**
   * 療養体制維持特別加算ラジオグループモデルに内部項目を追加します。
   */
  protected void addMedicalSystemUpkeepModel(){

    getMedicalSystemUpkeepItem1().setButtonIndex(1);

    getMedicalSystemUpkeepModel().add(getMedicalSystemUpkeepItem1());

    getMedicalSystemUpkeepItem2().setButtonIndex(2);

    getMedicalSystemUpkeepModel().add(getMedicalSystemUpkeepItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalSystemUpkeepItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMedicalSystemUpkeepItem2(){

  }

  /**
   * 療養体制維持特別加算ラジオグループに内部項目を追加します。
   */
  protected void addMedicalSystemUpkeep2(){

  }

  /**
   * 療養体制維持特別加算ラジオグループモデルに内部項目を追加します。
   */
  protected void addMedicalSystemUpkeep2Model(){

    getMedicalSystemUpkeep2Item1().setButtonIndex(1);

    getMedicalSystemUpkeep2Model().add(getMedicalSystemUpkeep2Item1());

    getMedicalSystemUpkeep2Item2().setButtonIndex(2);

    getMedicalSystemUpkeep2Model().add(getMedicalSystemUpkeep2Item2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalSystemUpkeep2Item1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMedicalSystemUpkeep2Item2(){

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
   * 認知症専門ケア加算に内部項目を追加します。
   */
  protected void addDementiaCareRadioGroup(){

  }

  /**
   * 認知症専門ケア加算モデルに内部項目を追加します。
   */
  protected void addDementiaCareRadioGroupModel(){

    getDementiaCareRadioItem1().setButtonIndex(1);

    getDementiaCareRadioGroupModel().add(getDementiaCareRadioItem1());

    getDementiaCareRadioItem2().setButtonIndex(2);

    getDementiaCareRadioGroupModel().add(getDementiaCareRadioItem2());

    getDementiaCareRadioItem3().setButtonIndex(3);

    getDementiaCareRadioGroupModel().add(getDementiaCareRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addDementiaCareRadioItem1(){

  }

  /**
   * 加算Iに内部項目を追加します。
   */
  protected void addDementiaCareRadioItem2(){

  }

  /**
   * 加算IIに内部項目を追加します。
   */
  protected void addDementiaCareRadioItem3(){

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

    unitRoomContainer.add(getUnitRoom(), VRLayout.FLOW);

    unitRoomContainer.add(getUnitRoomLabel(), VRLayout.FLOW);

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

    unitSemiRoomContainer.add(getUnitSemiRoom(), VRLayout.FLOW);

    unitSemiRoomContainer.add(getUnitSemiRoomLabel(), VRLayout.FLOW);

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

    normalRoomContainer.add(getNormalRoom(), VRLayout.FLOW);

    normalRoomContainer.add(getNormalRoomLabel(), VRLayout.FLOW);

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

    tasyouRoomContainer.add(getTasyouRoom(), VRLayout.FLOW);

    tasyouRoomContainer.add(getTasyouRoomLabel(), VRLayout.FLOW);

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
      ACFrame.debugStart(new ACAffairInfo(QO004_12211_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004_12211_201804Design getThis() {
    return this;
  }
}
