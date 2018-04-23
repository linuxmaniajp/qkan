
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
 * 作成日: 2018/02/08  日本コンピューター株式会社 日高　しのぶ 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業者登録 (004)
 * プログラム 事業者登録(短期入所生活介護) (QO004_12111_201804)
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
 * 事業者登録(短期入所生活介護)画面項目デザイン(QO004_12111_201804) 
 */
public class QO004_12111_201804Design extends QO004ProviderPanel {
  //GUIコンポーネント

  private ACGroupBox mainGroup;

  private JTabbedPane tab;

  private ACPanel panel1;

  private ACPanel calculationDetails;

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

  private ACValueArrayRadioButtonGroup unitCareMaintenance;

  private ACLabelContainer unitCareMaintenanceContainer;

  private ACListModelAdapter unitCareMaintenanceModel;

  private ACRadioButtonItem unitCareMaintenanceItem1;

  private ACRadioButtonItem unitCareMaintenanceItem2;

  private ACValueArrayRadioButtonGroup kyoseiServiceTankiRadioGroup;

  private ACLabelContainer kyoseiServiceTankiRadioGroupContainer;

  private ACListModelAdapter kyoseiServiceTankiRadioGroupModel;

  private ACRadioButtonItem kyoseiServiceTankiItem1;

  private ACRadioButtonItem kyoseiServiceTankiItem2;

  private ACValueArrayRadioButtonGroup seikatsuSoudanGroup;

  private ACLabelContainer seikatsuSoudanGroupContainer;

  private ACListModelAdapter seikatsuSoudanGroupModel;

  private ACRadioButtonItem seikatsuSoudanGroupItem1;

  private ACRadioButtonItem seikatsuSoudanGroupItem2;

  private ACValueArrayRadioButtonGroup seikatsuKinouGroup;

  private ACLabelContainer seikatsuKinouGroupContainer;

  private ACListModelAdapter seikatsuKinouGroupModel;

  private ACRadioButtonItem seikatsuKinouGroupItem1;

  private ACRadioButtonItem seikatsuKinouGroupItem2;

  private ACValueArrayRadioButtonGroup functionTrainingGuidanceSystem;

  private ACLabelContainer functionTrainingGuidanceSystemContainer;

  private ACListModelAdapter functionTrainingGuidanceSystemModel;

  private ACRadioButtonItem functionTrainingGuidanceSystemItem1;

  private ACRadioButtonItem functionTrainingGuidanceSystemItem2;

  private ACValueArrayRadioButtonGroup individualfunctionTrainingSystem;

  private ACLabelContainer individualfunctionTrainingSystemContainer;

  private ACListModelAdapter individualfunctionTrainingSystemModel;

  private ACRadioButtonItem individualfunctionTrainingSystemItem1;

  private ACRadioButtonItem individualfunctionTrainingSystemItem2;

  private ACValueArrayRadioButtonGroup nurseStructuralAddRadioGroup;

  private ACLabelContainer nurseStructuralAddRadioGroupContainer;

  private ACListModelAdapter nurseStructuralAddRadioGroupModel;

  private ACRadioButtonItem nurseStructuralAddRadioItem1;

  private ACRadioButtonItem nurseStructuralAddRadioItem2;

  private ACRadioButtonItem nurseStructuralAddRadioItem3;

  private ACValueArrayRadioButtonGroup nurseStructuralAdd2RadioGroup;

  private ACLabelContainer nurseStructuralAdd2RadioGroupContainer;

  private ACListModelAdapter nurseStructuralAdd2RadioGroupModel;

  private ACRadioButtonItem nurseStructuralAdd2RadioItem1;

  private ACRadioButtonItem nurseStructuralAdd2RadioItem2;

  private ACRadioButtonItem nurseStructuralAdd2RadioItem3;

  private ACValueArrayRadioButtonGroup medicalStrengthenCooperation;

  private ACLabelContainer medicalStrengthenCooperationContainer;

  private ACListModelAdapter medicalStrengthenCooperationModel;

  private ACRadioButtonItem medicalStrengthenCooperationItem1;

  private ACRadioButtonItem medicalStrengthenCooperationItem2;

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

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACPanel panel2;

  private ACPanel calculationDetails2;

  private ACValueArrayRadioButtonGroup meetingAndSendingOffSystem;

  private ACLabelContainer meetingAndSendingOffSystemContainer;

  private ACListModelAdapter meetingAndSendingOffSystemModel;

  private ACRadioButtonItem meetingAndSendingOffSystemItem1;

  private ACRadioButtonItem meetingAndSendingOffSystemItem2;

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

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralKusyoRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralKusyoRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralKusyoRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralKusyoRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralKusyoRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralKusyoRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralKusyoRadioItem4;

  private ACRadioButtonItem serviceAddProvisionStructuralKusyoRadioItem5;

  private ACValueArrayRadioButtonGroup staffUpgradeRadioGroup;

  private ACLabelContainer staffUpgradeRadioGroupContainer;

  private ACListModelAdapter staffUpgradeRadioGroupModel;

  private ACRadioButtonItem staffUpgradeRadioItem1;

  private ACRadioButtonItem staffUpgradeRadioItem2;

  private ACRadioButtonItem staffUpgradeRadioItem3;

  private ACRadioButtonItem staffUpgradeRadioItem4;

  private ACRadioButtonItem staffUpgradeRadioItem5;

  private ACRadioButtonItem staffUpgradeRadioItem6;

  private ACLabelContainer reduceRateContainer;

  private ACTextField reduceRate;

  private ACLabel percentSign;

  private ACIntegerCheckBox ShahukuReduce;

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

      mainGroup.setText("短期入所生活介護");

      mainGroup.setFollowChildEnabled(true);

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
   * パネル１を取得します。
   * @return パネル１
   */
  public ACPanel getPanel1(){
    if(panel1==null){

      panel1 = new ACPanel();

      panel1.setFollowChildEnabled(true);

      addPanel1();
    }
    return panel1;

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
  public ACValueArrayRadioButtonGroup getFacilitiesDivision(){
    if(facilitiesDivision==null){

      facilitiesDivision = new ACValueArrayRadioButtonGroup();

      getFacilitiesDivisionContainer().setText("施設等の区分");

      facilitiesDivision.setBindPath("1210101");

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
   * 単独型を取得します。
   * @return 単独型
   */
  public ACRadioButtonItem getFacilitiesDivisionItem1(){
    if(facilitiesDivisionItem1==null){

      facilitiesDivisionItem1 = new ACRadioButtonItem();

      facilitiesDivisionItem1.setText("単独型");

      facilitiesDivisionItem1.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem1.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem1();
    }
    return facilitiesDivisionItem1;

  }

  /**
   * 併設型・空床型を取得します。
   * @return 併設型・空床型
   */
  public ACRadioButtonItem getFacilitiesDivisionItem2(){
    if(facilitiesDivisionItem2==null){

      facilitiesDivisionItem2 = new ACRadioButtonItem();

      facilitiesDivisionItem2.setText("併設型・空床型");

      facilitiesDivisionItem2.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem2.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem2();
    }
    return facilitiesDivisionItem2;

  }

  /**
   * 単独型ユニット型を取得します。
   * @return 単独型ユニット型
   */
  public ACRadioButtonItem getFacilitiesDivisionItem3(){
    if(facilitiesDivisionItem3==null){

      facilitiesDivisionItem3 = new ACRadioButtonItem();

      facilitiesDivisionItem3.setText("単独型ユニット型");

      facilitiesDivisionItem3.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem3.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem3();
    }
    return facilitiesDivisionItem3;

  }

  /**
   * 併設型・空床型ユニット型を取得します。
   * @return 併設型・空床型ユニット型
   */
  public ACRadioButtonItem getFacilitiesDivisionItem4(){
    if(facilitiesDivisionItem4==null){

      facilitiesDivisionItem4 = new ACRadioButtonItem();

      facilitiesDivisionItem4.setText("併設型・空床型ユニット型");

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

      nightWorkDivision.setBindPath("1210102");

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

      staffLack.setBindPath("1210107");

      staffLack.setUseClearButton(false);

      staffLack.setModel(getStaffLackModel());

      staffLack.setValues(new int[]{1,2,3});

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

      addStaffLackItem3();
    }
    return staffLackItem3;

  }

  /**
   * ユニットケア体制を取得します。
   * @return ユニットケア体制
   */
  public ACValueArrayRadioButtonGroup getUnitCareMaintenance(){
    if(unitCareMaintenance==null){

      unitCareMaintenance = new ACValueArrayRadioButtonGroup();

      getUnitCareMaintenanceContainer().setText("ユニットケア体制");

      unitCareMaintenance.setBindPath("1210116");

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
   * 共生型サービスの提供 （短期入所事業所） を取得します。
   * @return 共生型サービスの提供 （短期入所事業所） 
   */
  public ACValueArrayRadioButtonGroup getKyoseiServiceTankiRadioGroup(){
    if(kyoseiServiceTankiRadioGroup==null){

      kyoseiServiceTankiRadioGroup = new ACValueArrayRadioButtonGroup();

      getKyoseiServiceTankiRadioGroupContainer().setText("<html>共生型サービスの提供<br> （短期入所事業所）</html> ");

      kyoseiServiceTankiRadioGroup.setBindPath("1210130");

      kyoseiServiceTankiRadioGroup.setUseClearButton(false);

      kyoseiServiceTankiRadioGroup.setModel(getKyoseiServiceTankiRadioGroupModel());

      kyoseiServiceTankiRadioGroup.setValues(new int[]{1,2});

      addKyoseiServiceTankiRadioGroup();
    }
    return kyoseiServiceTankiRadioGroup;

  }

  /**
   * 共生型サービスの提供 （短期入所事業所） コンテナを取得します。
   * @return 共生型サービスの提供 （短期入所事業所） コンテナ
   */
  protected ACLabelContainer getKyoseiServiceTankiRadioGroupContainer(){
    if(kyoseiServiceTankiRadioGroupContainer==null){
      kyoseiServiceTankiRadioGroupContainer = new ACLabelContainer();
      kyoseiServiceTankiRadioGroupContainer.setFollowChildEnabled(true);
      kyoseiServiceTankiRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      kyoseiServiceTankiRadioGroupContainer.add(getKyoseiServiceTankiRadioGroup(), null);
    }
    return kyoseiServiceTankiRadioGroupContainer;
  }

  /**
   * 共生型サービスの提供 （短期入所事業所） モデルを取得します。
   * @return 共生型サービスの提供 （短期入所事業所） モデル
   */
  protected ACListModelAdapter getKyoseiServiceTankiRadioGroupModel(){
    if(kyoseiServiceTankiRadioGroupModel==null){
      kyoseiServiceTankiRadioGroupModel = new ACListModelAdapter();
      addKyoseiServiceTankiRadioGroupModel();
    }
    return kyoseiServiceTankiRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKyoseiServiceTankiItem1(){
    if(kyoseiServiceTankiItem1==null){

      kyoseiServiceTankiItem1 = new ACRadioButtonItem();

      kyoseiServiceTankiItem1.setText("なし");

      kyoseiServiceTankiItem1.setGroup(getKyoseiServiceTankiRadioGroup());

      addKyoseiServiceTankiItem1();
    }
    return kyoseiServiceTankiItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getKyoseiServiceTankiItem2(){
    if(kyoseiServiceTankiItem2==null){

      kyoseiServiceTankiItem2 = new ACRadioButtonItem();

      kyoseiServiceTankiItem2.setText("あり");

      kyoseiServiceTankiItem2.setGroup(getKyoseiServiceTankiRadioGroup());

      addKyoseiServiceTankiItem2();
    }
    return kyoseiServiceTankiItem2;

  }

  /**
   * 生活相談員配置等加算を取得します。
   * @return 生活相談員配置等加算
   */
  public ACValueArrayRadioButtonGroup getSeikatsuSoudanGroup(){
    if(seikatsuSoudanGroup==null){

      seikatsuSoudanGroup = new ACValueArrayRadioButtonGroup();

      getSeikatsuSoudanGroupContainer().setText("生活相談員配置等加算");

      seikatsuSoudanGroup.setBindPath("1210131");

      seikatsuSoudanGroup.setNoSelectIndex(0);

      seikatsuSoudanGroup.setUseClearButton(false);

      seikatsuSoudanGroup.setModel(getSeikatsuSoudanGroupModel());

      seikatsuSoudanGroup.setValues(new int[]{1,2});

      addSeikatsuSoudanGroup();
    }
    return seikatsuSoudanGroup;

  }

  /**
   * 生活相談員配置等加算コンテナを取得します。
   * @return 生活相談員配置等加算コンテナ
   */
  protected ACLabelContainer getSeikatsuSoudanGroupContainer(){
    if(seikatsuSoudanGroupContainer==null){
      seikatsuSoudanGroupContainer = new ACLabelContainer();
      seikatsuSoudanGroupContainer.setFollowChildEnabled(true);
      seikatsuSoudanGroupContainer.setVAlignment(VRLayout.CENTER);
      seikatsuSoudanGroupContainer.add(getSeikatsuSoudanGroup(), null);
    }
    return seikatsuSoudanGroupContainer;
  }

  /**
   * 生活相談員配置等加算モデルを取得します。
   * @return 生活相談員配置等加算モデル
   */
  protected ACListModelAdapter getSeikatsuSoudanGroupModel(){
    if(seikatsuSoudanGroupModel==null){
      seikatsuSoudanGroupModel = new ACListModelAdapter();
      addSeikatsuSoudanGroupModel();
    }
    return seikatsuSoudanGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getSeikatsuSoudanGroupItem1(){
    if(seikatsuSoudanGroupItem1==null){

      seikatsuSoudanGroupItem1 = new ACRadioButtonItem();

      seikatsuSoudanGroupItem1.setText("なし");

      seikatsuSoudanGroupItem1.setGroup(getSeikatsuSoudanGroup());

      seikatsuSoudanGroupItem1.setConstraints(VRLayout.FLOW);

      addSeikatsuSoudanGroupItem1();
    }
    return seikatsuSoudanGroupItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getSeikatsuSoudanGroupItem2(){
    if(seikatsuSoudanGroupItem2==null){

      seikatsuSoudanGroupItem2 = new ACRadioButtonItem();

      seikatsuSoudanGroupItem2.setText("あり");

      seikatsuSoudanGroupItem2.setGroup(getSeikatsuSoudanGroup());

      seikatsuSoudanGroupItem2.setConstraints(VRLayout.FLOW);

      addSeikatsuSoudanGroupItem2();
    }
    return seikatsuSoudanGroupItem2;

  }

  /**
   * 生活機能向上連携加算を取得します。
   * @return 生活機能向上連携加算
   */
  public ACValueArrayRadioButtonGroup getSeikatsuKinouGroup(){
    if(seikatsuKinouGroup==null){

      seikatsuKinouGroup = new ACValueArrayRadioButtonGroup();

      getSeikatsuKinouGroupContainer().setText("生活機能向上連携加算");

      seikatsuKinouGroup.setBindPath("1210132");

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
   * 機能訓練指導体制ラジオグループを取得します。
   * @return 機能訓練指導体制ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getFunctionTrainingGuidanceSystem(){
    if(functionTrainingGuidanceSystem==null){

      functionTrainingGuidanceSystem = new ACValueArrayRadioButtonGroup();

      getFunctionTrainingGuidanceSystemContainer().setText("機能訓練指導体制");

      functionTrainingGuidanceSystem.setBindPath("1210103");

      functionTrainingGuidanceSystem.setUseClearButton(false);

      functionTrainingGuidanceSystem.setModel(getFunctionTrainingGuidanceSystemModel());

      functionTrainingGuidanceSystem.setValues(new int[]{1,2});

      addFunctionTrainingGuidanceSystem();
    }
    return functionTrainingGuidanceSystem;

  }

  /**
   * 機能訓練指導体制ラジオグループコンテナを取得します。
   * @return 機能訓練指導体制ラジオグループコンテナ
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
   * 機能訓練指導体制ラジオグループモデルを取得します。
   * @return 機能訓練指導体制ラジオグループモデル
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
   * 個別機能訓練体制ラジオグループを取得します。
   * @return 個別機能訓練体制ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getIndividualfunctionTrainingSystem(){
    if(individualfunctionTrainingSystem==null){

      individualfunctionTrainingSystem = new ACValueArrayRadioButtonGroup();

      getIndividualfunctionTrainingSystemContainer().setText("個別機能訓練体制");

      individualfunctionTrainingSystem.setBindPath("1210128");

      individualfunctionTrainingSystem.setNoSelectIndex(0);

      individualfunctionTrainingSystem.setUseClearButton(false);

      individualfunctionTrainingSystem.setModel(getIndividualfunctionTrainingSystemModel());

      individualfunctionTrainingSystem.setValues(new int[]{1,2});

      addIndividualfunctionTrainingSystem();
    }
    return individualfunctionTrainingSystem;

  }

  /**
   * 個別機能訓練体制ラジオグループコンテナを取得します。
   * @return 個別機能訓練体制ラジオグループコンテナ
   */
  protected ACLabelContainer getIndividualfunctionTrainingSystemContainer(){
    if(individualfunctionTrainingSystemContainer==null){
      individualfunctionTrainingSystemContainer = new ACLabelContainer();
      individualfunctionTrainingSystemContainer.setFollowChildEnabled(true);
      individualfunctionTrainingSystemContainer.setVAlignment(VRLayout.CENTER);
      individualfunctionTrainingSystemContainer.add(getIndividualfunctionTrainingSystem(), null);
    }
    return individualfunctionTrainingSystemContainer;
  }

  /**
   * 個別機能訓練体制ラジオグループモデルを取得します。
   * @return 個別機能訓練体制ラジオグループモデル
   */
  protected ACListModelAdapter getIndividualfunctionTrainingSystemModel(){
    if(individualfunctionTrainingSystemModel==null){
      individualfunctionTrainingSystemModel = new ACListModelAdapter();
      addIndividualfunctionTrainingSystemModel();
    }
    return individualfunctionTrainingSystemModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getIndividualfunctionTrainingSystemItem1(){
    if(individualfunctionTrainingSystemItem1==null){

      individualfunctionTrainingSystemItem1 = new ACRadioButtonItem();

      individualfunctionTrainingSystemItem1.setText("なし");

      individualfunctionTrainingSystemItem1.setGroup(getIndividualfunctionTrainingSystem());

      individualfunctionTrainingSystemItem1.setConstraints(VRLayout.FLOW);

      addIndividualfunctionTrainingSystemItem1();
    }
    return individualfunctionTrainingSystemItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getIndividualfunctionTrainingSystemItem2(){
    if(individualfunctionTrainingSystemItem2==null){

      individualfunctionTrainingSystemItem2 = new ACRadioButtonItem();

      individualfunctionTrainingSystemItem2.setText("あり");

      individualfunctionTrainingSystemItem2.setGroup(getIndividualfunctionTrainingSystem());

      individualfunctionTrainingSystemItem2.setConstraints(VRLayout.FLOW);

      addIndividualfunctionTrainingSystemItem2();
    }
    return individualfunctionTrainingSystemItem2;

  }

  /**
   * 看護体制加算 I又はIIIを取得します。
   * @return 看護体制加算 I又はIII
   */
  public ACValueArrayRadioButtonGroup getNurseStructuralAddRadioGroup(){
    if(nurseStructuralAddRadioGroup==null){

      nurseStructuralAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getNurseStructuralAddRadioGroupContainer().setText("看護体制加算 I又はIII");

      nurseStructuralAddRadioGroup.setBindPath("1210120");

      nurseStructuralAddRadioGroup.setNoSelectIndex(0);

      nurseStructuralAddRadioGroup.setUseClearButton(false);

      nurseStructuralAddRadioGroup.setModel(getNurseStructuralAddRadioGroupModel());

      nurseStructuralAddRadioGroup.setValues(new int[]{1,2,3});

      addNurseStructuralAddRadioGroup();
    }
    return nurseStructuralAddRadioGroup;

  }

  /**
   * 看護体制加算 I又はIIIコンテナを取得します。
   * @return 看護体制加算 I又はIIIコンテナ
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
   * 看護体制加算 I又はIIIモデルを取得します。
   * @return 看護体制加算 I又はIIIモデル
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
   * 加算Iを取得します。
   * @return 加算I
   */
  public ACRadioButtonItem getNurseStructuralAddRadioItem2(){
    if(nurseStructuralAddRadioItem2==null){

      nurseStructuralAddRadioItem2 = new ACRadioButtonItem();

      nurseStructuralAddRadioItem2.setText("加算I");

      nurseStructuralAddRadioItem2.setGroup(getNurseStructuralAddRadioGroup());

      nurseStructuralAddRadioItem2.setConstraints(VRLayout.FLOW);

      addNurseStructuralAddRadioItem2();
    }
    return nurseStructuralAddRadioItem2;

  }

  /**
   * 加算IIIを取得します。
   * @return 加算III
   */
  public ACRadioButtonItem getNurseStructuralAddRadioItem3(){
    if(nurseStructuralAddRadioItem3==null){

      nurseStructuralAddRadioItem3 = new ACRadioButtonItem();

      nurseStructuralAddRadioItem3.setText("加算III");

      nurseStructuralAddRadioItem3.setGroup(getNurseStructuralAddRadioGroup());

      nurseStructuralAddRadioItem3.setConstraints(VRLayout.FLOW);

      addNurseStructuralAddRadioItem3();
    }
    return nurseStructuralAddRadioItem3;

  }

  /**
   * 看護体制加算 II又はIVを取得します。
   * @return 看護体制加算 II又はIV
   */
  public ACValueArrayRadioButtonGroup getNurseStructuralAdd2RadioGroup(){
    if(nurseStructuralAdd2RadioGroup==null){

      nurseStructuralAdd2RadioGroup = new ACValueArrayRadioButtonGroup();

      getNurseStructuralAdd2RadioGroupContainer().setText("看護体制加算 II又はIV");

      nurseStructuralAdd2RadioGroup.setBindPath("1210133");

      nurseStructuralAdd2RadioGroup.setNoSelectIndex(0);

      nurseStructuralAdd2RadioGroup.setUseClearButton(false);

      nurseStructuralAdd2RadioGroup.setModel(getNurseStructuralAdd2RadioGroupModel());

      nurseStructuralAdd2RadioGroup.setValues(new int[]{1,2,3});

      addNurseStructuralAdd2RadioGroup();
    }
    return nurseStructuralAdd2RadioGroup;

  }

  /**
   * 看護体制加算 II又はIVコンテナを取得します。
   * @return 看護体制加算 II又はIVコンテナ
   */
  protected ACLabelContainer getNurseStructuralAdd2RadioGroupContainer(){
    if(nurseStructuralAdd2RadioGroupContainer==null){
      nurseStructuralAdd2RadioGroupContainer = new ACLabelContainer();
      nurseStructuralAdd2RadioGroupContainer.setFollowChildEnabled(true);
      nurseStructuralAdd2RadioGroupContainer.setVAlignment(VRLayout.CENTER);
      nurseStructuralAdd2RadioGroupContainer.add(getNurseStructuralAdd2RadioGroup(), null);
    }
    return nurseStructuralAdd2RadioGroupContainer;
  }

  /**
   * 看護体制加算 II又はIVモデルを取得します。
   * @return 看護体制加算 II又はIVモデル
   */
  protected ACListModelAdapter getNurseStructuralAdd2RadioGroupModel(){
    if(nurseStructuralAdd2RadioGroupModel==null){
      nurseStructuralAdd2RadioGroupModel = new ACListModelAdapter();
      addNurseStructuralAdd2RadioGroupModel();
    }
    return nurseStructuralAdd2RadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getNurseStructuralAdd2RadioItem1(){
    if(nurseStructuralAdd2RadioItem1==null){

      nurseStructuralAdd2RadioItem1 = new ACRadioButtonItem();

      nurseStructuralAdd2RadioItem1.setText("なし");

      nurseStructuralAdd2RadioItem1.setGroup(getNurseStructuralAdd2RadioGroup());

      nurseStructuralAdd2RadioItem1.setConstraints(VRLayout.FLOW);

      addNurseStructuralAdd2RadioItem1();
    }
    return nurseStructuralAdd2RadioItem1;

  }

  /**
   * 加算IIを取得します。
   * @return 加算II
   */
  public ACRadioButtonItem getNurseStructuralAdd2RadioItem2(){
    if(nurseStructuralAdd2RadioItem2==null){

      nurseStructuralAdd2RadioItem2 = new ACRadioButtonItem();

      nurseStructuralAdd2RadioItem2.setText("加算II");

      nurseStructuralAdd2RadioItem2.setGroup(getNurseStructuralAdd2RadioGroup());

      nurseStructuralAdd2RadioItem2.setConstraints(VRLayout.FLOW);

      addNurseStructuralAdd2RadioItem2();
    }
    return nurseStructuralAdd2RadioItem2;

  }

  /**
   * 加算IVを取得します。
   * @return 加算IV
   */
  public ACRadioButtonItem getNurseStructuralAdd2RadioItem3(){
    if(nurseStructuralAdd2RadioItem3==null){

      nurseStructuralAdd2RadioItem3 = new ACRadioButtonItem();

      nurseStructuralAdd2RadioItem3.setText("加算IV");

      nurseStructuralAdd2RadioItem3.setGroup(getNurseStructuralAdd2RadioGroup());

      nurseStructuralAdd2RadioItem3.setConstraints(VRLayout.FLOW);

      addNurseStructuralAdd2RadioItem3();
    }
    return nurseStructuralAdd2RadioItem3;

  }

  /**
   * 医療連携強化加算ラジオグループを取得します。
   * @return 医療連携強化加算ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getMedicalStrengthenCooperation(){
    if(medicalStrengthenCooperation==null){

      medicalStrengthenCooperation = new ACValueArrayRadioButtonGroup();

      getMedicalStrengthenCooperationContainer().setText("医療連携強化加算");

      medicalStrengthenCooperation.setBindPath("1210129");

      medicalStrengthenCooperation.setNoSelectIndex(0);

      medicalStrengthenCooperation.setUseClearButton(false);

      medicalStrengthenCooperation.setModel(getMedicalStrengthenCooperationModel());

      medicalStrengthenCooperation.setValues(new int[]{1,2});

      addMedicalStrengthenCooperation();
    }
    return medicalStrengthenCooperation;

  }

  /**
   * 医療連携強化加算ラジオグループコンテナを取得します。
   * @return 医療連携強化加算ラジオグループコンテナ
   */
  protected ACLabelContainer getMedicalStrengthenCooperationContainer(){
    if(medicalStrengthenCooperationContainer==null){
      medicalStrengthenCooperationContainer = new ACLabelContainer();
      medicalStrengthenCooperationContainer.setFollowChildEnabled(true);
      medicalStrengthenCooperationContainer.setVAlignment(VRLayout.CENTER);
      medicalStrengthenCooperationContainer.add(getMedicalStrengthenCooperation(), null);
    }
    return medicalStrengthenCooperationContainer;
  }

  /**
   * 医療連携強化加算ラジオグループモデルを取得します。
   * @return 医療連携強化加算ラジオグループモデル
   */
  protected ACListModelAdapter getMedicalStrengthenCooperationModel(){
    if(medicalStrengthenCooperationModel==null){
      medicalStrengthenCooperationModel = new ACListModelAdapter();
      addMedicalStrengthenCooperationModel();
    }
    return medicalStrengthenCooperationModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalStrengthenCooperationItem1(){
    if(medicalStrengthenCooperationItem1==null){

      medicalStrengthenCooperationItem1 = new ACRadioButtonItem();

      medicalStrengthenCooperationItem1.setText("なし");

      medicalStrengthenCooperationItem1.setGroup(getMedicalStrengthenCooperation());

      medicalStrengthenCooperationItem1.setConstraints(VRLayout.FLOW);

      addMedicalStrengthenCooperationItem1();
    }
    return medicalStrengthenCooperationItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMedicalStrengthenCooperationItem2(){
    if(medicalStrengthenCooperationItem2==null){

      medicalStrengthenCooperationItem2 = new ACRadioButtonItem();

      medicalStrengthenCooperationItem2.setText("あり");

      medicalStrengthenCooperationItem2.setGroup(getMedicalStrengthenCooperation());

      medicalStrengthenCooperationItem2.setConstraints(VRLayout.FLOW);

      addMedicalStrengthenCooperationItem2();
    }
    return medicalStrengthenCooperationItem2;

  }

  /**
   * 夜勤職員配置加算を取得します。
   * @return 夜勤職員配置加算
   */
  public ACValueArrayRadioButtonGroup getNightStaffDispositionAddRadioGroup(){
    if(nightStaffDispositionAddRadioGroup==null){

      nightStaffDispositionAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getNightStaffDispositionAddRadioGroupContainer().setText("夜勤職員配置加算");

      nightStaffDispositionAddRadioGroup.setBindPath("1210121");

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

      kaigoRobotRadioGroup.setBindPath("1210134");

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
   * 若年性認知症利用者受入加算を取得します。
   * @return 若年性認知症利用者受入加算
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("若年性認知症利用者受入加算");

      youngDementiaPatinetAddRadioGroup.setBindPath("1210122");

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
   * パネル2を取得します。
   * @return パネル2
   */
  public ACPanel getPanel2(){
    if(panel2==null){

      panel2 = new ACPanel();

      panel2.setFollowChildEnabled(true);

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
   * 送迎体制ラジオグループを取得します。
   * @return 送迎体制ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getMeetingAndSendingOffSystem(){
    if(meetingAndSendingOffSystem==null){

      meetingAndSendingOffSystem = new ACValueArrayRadioButtonGroup();

      getMeetingAndSendingOffSystemContainer().setText("送迎体制");

      meetingAndSendingOffSystem.setBindPath("1210104");

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

      medicalFoodAddRadioGroup.setBindPath("1210123");

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

      dementiaCareRadioGroup.setBindPath("1210135");

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
   * サービス提供体制強化加算（単独型・併設型）を取得します。
   * @return サービス提供体制強化加算（単独型・併設型）
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("<html>サービス提供体制強化加算<br>（単独型・併設型）</html>");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1210124");

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
   * サービス提供体制強化加算（単独型・併設型）コンテナを取得します。
   * @return サービス提供体制強化加算（単独型・併設型）コンテナ
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
   * サービス提供体制強化加算（単独型・併設型）モデルを取得します。
   * @return サービス提供体制強化加算（単独型・併設型）モデル
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
   * サービス提供体制強化加算（空床型）を取得します。
   * @return サービス提供体制強化加算（空床型）
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralKusyoRadioGroup(){
    if(serviceAddProvisionStructuralKusyoRadioGroup==null){

      serviceAddProvisionStructuralKusyoRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralKusyoRadioGroupContainer().setText("<html>サービス提供体制強化加算<br>（空床型）</html>");

      serviceAddProvisionStructuralKusyoRadioGroup.setBindPath("1210125");

      serviceAddProvisionStructuralKusyoRadioGroup.setVisible(true);

      serviceAddProvisionStructuralKusyoRadioGroup.setEnabled(true);

      serviceAddProvisionStructuralKusyoRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralKusyoRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralKusyoRadioGroup.setModel(getServiceAddProvisionStructuralKusyoRadioGroupModel());

      serviceAddProvisionStructuralKusyoRadioGroup.setValues(new int[]{1,5,2,3,4});

      addServiceAddProvisionStructuralKusyoRadioGroup();
    }
    return serviceAddProvisionStructuralKusyoRadioGroup;

  }

  /**
   * サービス提供体制強化加算（空床型）コンテナを取得します。
   * @return サービス提供体制強化加算（空床型）コンテナ
   */
  protected ACLabelContainer getServiceAddProvisionStructuralKusyoRadioGroupContainer(){
    if(serviceAddProvisionStructuralKusyoRadioGroupContainer==null){
      serviceAddProvisionStructuralKusyoRadioGroupContainer = new ACLabelContainer();
      serviceAddProvisionStructuralKusyoRadioGroupContainer.setFollowChildEnabled(true);
      serviceAddProvisionStructuralKusyoRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      serviceAddProvisionStructuralKusyoRadioGroupContainer.add(getServiceAddProvisionStructuralKusyoRadioGroup(), null);
    }
    return serviceAddProvisionStructuralKusyoRadioGroupContainer;
  }

  /**
   * サービス提供体制強化加算（空床型）モデルを取得します。
   * @return サービス提供体制強化加算（空床型）モデル
   */
  protected ACListModelAdapter getServiceAddProvisionStructuralKusyoRadioGroupModel(){
    if(serviceAddProvisionStructuralKusyoRadioGroupModel==null){
      serviceAddProvisionStructuralKusyoRadioGroupModel = new ACListModelAdapter();
      addServiceAddProvisionStructuralKusyoRadioGroupModel();
    }
    return serviceAddProvisionStructuralKusyoRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralKusyoRadioItem1(){
    if(serviceAddProvisionStructuralKusyoRadioItem1==null){

      serviceAddProvisionStructuralKusyoRadioItem1 = new ACRadioButtonItem();

      serviceAddProvisionStructuralKusyoRadioItem1.setText("なし");

      serviceAddProvisionStructuralKusyoRadioItem1.setGroup(getServiceAddProvisionStructuralKusyoRadioGroup());

      serviceAddProvisionStructuralKusyoRadioItem1.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralKusyoRadioItem1();
    }
    return serviceAddProvisionStructuralKusyoRadioItem1;

  }

  /**
   * 加算Iイを取得します。
   * @return 加算Iイ
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralKusyoRadioItem2(){
    if(serviceAddProvisionStructuralKusyoRadioItem2==null){

      serviceAddProvisionStructuralKusyoRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralKusyoRadioItem2.setText("加算Iイ");

      serviceAddProvisionStructuralKusyoRadioItem2.setGroup(getServiceAddProvisionStructuralKusyoRadioGroup());

      serviceAddProvisionStructuralKusyoRadioItem2.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralKusyoRadioItem2();
    }
    return serviceAddProvisionStructuralKusyoRadioItem2;

  }

  /**
   * 加算Iロを取得します。
   * @return 加算Iロ
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralKusyoRadioItem3(){
    if(serviceAddProvisionStructuralKusyoRadioItem3==null){

      serviceAddProvisionStructuralKusyoRadioItem3 = new ACRadioButtonItem();

      serviceAddProvisionStructuralKusyoRadioItem3.setText("加算Iロ");

      serviceAddProvisionStructuralKusyoRadioItem3.setGroup(getServiceAddProvisionStructuralKusyoRadioGroup());

      serviceAddProvisionStructuralKusyoRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addServiceAddProvisionStructuralKusyoRadioItem3();
    }
    return serviceAddProvisionStructuralKusyoRadioItem3;

  }

  /**
   * 加算IIを取得します。
   * @return 加算II
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralKusyoRadioItem4(){
    if(serviceAddProvisionStructuralKusyoRadioItem4==null){

      serviceAddProvisionStructuralKusyoRadioItem4 = new ACRadioButtonItem();

      serviceAddProvisionStructuralKusyoRadioItem4.setText("加算II");

      serviceAddProvisionStructuralKusyoRadioItem4.setGroup(getServiceAddProvisionStructuralKusyoRadioGroup());

      serviceAddProvisionStructuralKusyoRadioItem4.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralKusyoRadioItem4();
    }
    return serviceAddProvisionStructuralKusyoRadioItem4;

  }

  /**
   * 加算IIIを取得します。
   * @return 加算III
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralKusyoRadioItem5(){
    if(serviceAddProvisionStructuralKusyoRadioItem5==null){

      serviceAddProvisionStructuralKusyoRadioItem5 = new ACRadioButtonItem();

      serviceAddProvisionStructuralKusyoRadioItem5.setText("加算III");

      serviceAddProvisionStructuralKusyoRadioItem5.setGroup(getServiceAddProvisionStructuralKusyoRadioGroup());

      serviceAddProvisionStructuralKusyoRadioItem5.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralKusyoRadioItem5();
    }
    return serviceAddProvisionStructuralKusyoRadioItem5;

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

      dinnerTotal.setBindPath("1210108");

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

      dinnerMorning.setBindPath("1210109");

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

      dinnerNoon.setBindPath("1210110");

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

      dinnerNight.setBindPath("1210111");

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

      unitRoom.setBindPath("1210112");

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

      unitSemiRoom.setBindPath("1210113");

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

      normalRoom.setBindPath("1210114");

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

      tasyouRoom.setBindPath("1210115");

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
  public QO004_12111_201804Design() {

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
   * パネル１に内部項目を追加します。
   */
  protected void addPanel1(){

    panel1.add(getCalculationDetails(), VRLayout.NORTH);

  }

  /**
   * 算定項目領域に内部項目を追加します。
   */
  protected void addCalculationDetails(){

    calculationDetails.add(getFacilitiesDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getNightWorkDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getStaffLackContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getUnitCareMaintenanceContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getKyoseiServiceTankiRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getSeikatsuSoudanGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getSeikatsuKinouGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getFunctionTrainingGuidanceSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getIndividualfunctionTrainingSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getNurseStructuralAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getNurseStructuralAdd2RadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getMedicalStrengthenCooperationContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getNightStaffDispositionAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getKaigoRobotRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * 単独型に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem1(){

  }

  /**
   * 併設型・空床型に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem2(){

  }

  /**
   * 単独型ユニット型に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem3(){

  }

  /**
   * 併設型・空床型ユニット型に内部項目を追加します。
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
   * 共生型サービスの提供 （短期入所事業所） に内部項目を追加します。
   */
  protected void addKyoseiServiceTankiRadioGroup(){

  }

  /**
   * 共生型サービスの提供 （短期入所事業所） モデルに内部項目を追加します。
   */
  protected void addKyoseiServiceTankiRadioGroupModel(){

    getKyoseiServiceTankiItem1().setButtonIndex(1);

    getKyoseiServiceTankiRadioGroupModel().add(getKyoseiServiceTankiItem1());

    getKyoseiServiceTankiItem2().setButtonIndex(2);

    getKyoseiServiceTankiRadioGroupModel().add(getKyoseiServiceTankiItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKyoseiServiceTankiItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addKyoseiServiceTankiItem2(){

  }

  /**
   * 生活相談員配置等加算に内部項目を追加します。
   */
  protected void addSeikatsuSoudanGroup(){

  }

  /**
   * 生活相談員配置等加算モデルに内部項目を追加します。
   */
  protected void addSeikatsuSoudanGroupModel(){

    getSeikatsuSoudanGroupItem1().setButtonIndex(1);

    getSeikatsuSoudanGroupModel().add(getSeikatsuSoudanGroupItem1());

    getSeikatsuSoudanGroupItem2().setButtonIndex(2);

    getSeikatsuSoudanGroupModel().add(getSeikatsuSoudanGroupItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addSeikatsuSoudanGroupItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addSeikatsuSoudanGroupItem2(){

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
   * 機能訓練指導体制ラジオグループに内部項目を追加します。
   */
  protected void addFunctionTrainingGuidanceSystem(){

  }

  /**
   * 機能訓練指導体制ラジオグループモデルに内部項目を追加します。
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
   * 個別機能訓練体制ラジオグループに内部項目を追加します。
   */
  protected void addIndividualfunctionTrainingSystem(){

  }

  /**
   * 個別機能訓練体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addIndividualfunctionTrainingSystemModel(){

    getIndividualfunctionTrainingSystemItem1().setButtonIndex(1);

    getIndividualfunctionTrainingSystemModel().add(getIndividualfunctionTrainingSystemItem1());

    getIndividualfunctionTrainingSystemItem2().setButtonIndex(2);

    getIndividualfunctionTrainingSystemModel().add(getIndividualfunctionTrainingSystemItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addIndividualfunctionTrainingSystemItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addIndividualfunctionTrainingSystemItem2(){

  }

  /**
   * 看護体制加算 I又はIIIに内部項目を追加します。
   */
  protected void addNurseStructuralAddRadioGroup(){

  }

  /**
   * 看護体制加算 I又はIIIモデルに内部項目を追加します。
   */
  protected void addNurseStructuralAddRadioGroupModel(){

    getNurseStructuralAddRadioItem1().setButtonIndex(1);

    getNurseStructuralAddRadioGroupModel().add(getNurseStructuralAddRadioItem1());

    getNurseStructuralAddRadioItem2().setButtonIndex(2);

    getNurseStructuralAddRadioGroupModel().add(getNurseStructuralAddRadioItem2());

    getNurseStructuralAddRadioItem3().setButtonIndex(3);

    getNurseStructuralAddRadioGroupModel().add(getNurseStructuralAddRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addNurseStructuralAddRadioItem1(){

  }

  /**
   * 加算Iに内部項目を追加します。
   */
  protected void addNurseStructuralAddRadioItem2(){

  }

  /**
   * 加算IIIに内部項目を追加します。
   */
  protected void addNurseStructuralAddRadioItem3(){

  }

  /**
   * 看護体制加算 II又はIVに内部項目を追加します。
   */
  protected void addNurseStructuralAdd2RadioGroup(){

  }

  /**
   * 看護体制加算 II又はIVモデルに内部項目を追加します。
   */
  protected void addNurseStructuralAdd2RadioGroupModel(){

    getNurseStructuralAdd2RadioItem1().setButtonIndex(1);

    getNurseStructuralAdd2RadioGroupModel().add(getNurseStructuralAdd2RadioItem1());

    getNurseStructuralAdd2RadioItem2().setButtonIndex(2);

    getNurseStructuralAdd2RadioGroupModel().add(getNurseStructuralAdd2RadioItem2());

    getNurseStructuralAdd2RadioItem3().setButtonIndex(3);

    getNurseStructuralAdd2RadioGroupModel().add(getNurseStructuralAdd2RadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addNurseStructuralAdd2RadioItem1(){

  }

  /**
   * 加算IIに内部項目を追加します。
   */
  protected void addNurseStructuralAdd2RadioItem2(){

  }

  /**
   * 加算IVに内部項目を追加します。
   */
  protected void addNurseStructuralAdd2RadioItem3(){

  }

  /**
   * 医療連携強化加算ラジオグループに内部項目を追加します。
   */
  protected void addMedicalStrengthenCooperation(){

  }

  /**
   * 医療連携強化加算ラジオグループモデルに内部項目を追加します。
   */
  protected void addMedicalStrengthenCooperationModel(){

    getMedicalStrengthenCooperationItem1().setButtonIndex(1);

    getMedicalStrengthenCooperationModel().add(getMedicalStrengthenCooperationItem1());

    getMedicalStrengthenCooperationItem2().setButtonIndex(2);

    getMedicalStrengthenCooperationModel().add(getMedicalStrengthenCooperationItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalStrengthenCooperationItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMedicalStrengthenCooperationItem2(){

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
   * パネル2に内部項目を追加します。
   */
  protected void addPanel2(){

    panel2.add(getCalculationDetails2(), VRLayout.NORTH);

    panel2.add(getStandardMoneyGroup(), VRLayout.NORTH);

  }

  /**
   * 算定項目領域2に内部項目を追加します。
   */
  protected void addCalculationDetails2(){

    calculationDetails2.add(getMeetingAndSendingOffSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getMedicalFoodAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getDementiaCareRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getServiceAddProvisionStructuralKusyoRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getStaffUpgradeRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getReduceRateContainer(), VRLayout.FLOW);

    calculationDetails2.add(getShahukuReduce(), VRLayout.FLOW);

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
   * サービス提供体制強化加算（単独型・併設型）に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioGroup(){

  }

  /**
   * サービス提供体制強化加算（単独型・併設型）モデルに内部項目を追加します。
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
   * サービス提供体制強化加算（空床型）に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralKusyoRadioGroup(){

  }

  /**
   * サービス提供体制強化加算（空床型）モデルに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralKusyoRadioGroupModel(){

    getServiceAddProvisionStructuralKusyoRadioItem1().setButtonIndex(1);

    getServiceAddProvisionStructuralKusyoRadioGroupModel().add(getServiceAddProvisionStructuralKusyoRadioItem1());

    getServiceAddProvisionStructuralKusyoRadioItem2().setButtonIndex(5);

    getServiceAddProvisionStructuralKusyoRadioGroupModel().add(getServiceAddProvisionStructuralKusyoRadioItem2());

    getServiceAddProvisionStructuralKusyoRadioItem3().setButtonIndex(2);

    getServiceAddProvisionStructuralKusyoRadioGroupModel().add(getServiceAddProvisionStructuralKusyoRadioItem3());

    getServiceAddProvisionStructuralKusyoRadioItem4().setButtonIndex(3);

    getServiceAddProvisionStructuralKusyoRadioGroupModel().add(getServiceAddProvisionStructuralKusyoRadioItem4());

    getServiceAddProvisionStructuralKusyoRadioItem5().setButtonIndex(4);

    getServiceAddProvisionStructuralKusyoRadioGroupModel().add(getServiceAddProvisionStructuralKusyoRadioItem5());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralKusyoRadioItem1(){

  }

  /**
   * 加算Iイに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralKusyoRadioItem2(){

  }

  /**
   * 加算Iロに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralKusyoRadioItem3(){

  }

  /**
   * 加算IIに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralKusyoRadioItem4(){

  }

  /**
   * 加算IIIに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralKusyoRadioItem5(){

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
      ACFrame.debugStart(new ACAffairInfo(QO004_12111_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004_12111_201804Design getThis() {
    return this;
  }
}
