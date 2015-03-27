
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
 * 作成日: 2015/03/02  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン定期巡回・随時対応型訪問介護看護 (QS001_17611_201504)
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
 * サービスパターン定期巡回・随時対応型訪問介護看護画面項目デザイン(QS001_17611_201504) 
 */
public class QS001_17611_201504Design extends QS001ServicePanel {
  //GUIコンポーネント

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup divisionRadioGroup;

  private ACLabelContainer divisionRadioGroupContainer;

  private ACListModelAdapter divisionRadioGroupModel;

  private ACRadioButtonItem divisionRadioItem1;

  private ACRadioButtonItem divisionRadioItem2;

  private ACValueArrayRadioButtonGroup sijishoOfferRadioGroup;

  private ACLabelContainer sijishoOfferRadioGroupContainer;

  private ACListModelAdapter sijishoOfferRadioGroupModel;

  private ACRadioButtonItem sijishoOfferRadioItem1;

  private ACRadioButtonItem sijishoOfferRadioItem2;

  private ACValueArrayRadioButtonGroup nurseStaffDivisionRadioGroup;

  private ACLabelContainer nurseStaffDivisionRadioGroupContainer;

  private ACListModelAdapter nurseStaffDivisionRadioGroupModel;

  private ACRadioButtonItem nurseStaffDivisionRadioItem1;

  private ACRadioButtonItem nurseStaffDivisionRadioItem2;

  private ACValueArrayRadioButtonGroup initialAddRadioGroup;

  private ACLabelContainer initialAddRadioGroupContainer;

  private ACListModelAdapter initialAddRadioGroupModel;

  private ACRadioButtonItem initialAddRadioItem1;

  private ACRadioButtonItem initialAddRadioItem2;

  private ACValueArrayRadioButtonGroup emergencyVisitRadioGroup;

  private ACLabelContainer emergencyVisitRadioGroupContainer;

  private ACListModelAdapter emergencyVisitRadioGroupModel;

  private ACRadioButtonItem emergencyVisitRadioItem1;

  private ACRadioButtonItem emergencyVisitRadioItem2;

  private ACValueArrayRadioButtonGroup specialManagementRadioGroup;

  private ACLabelContainer specialManagementRadioGroupContainer;

  private ACListModelAdapter specialManagementRadioGroupModel;

  private ACRadioButtonItem specialManagementRadioItem1;

  private ACRadioButtonItem specialManagementRadioItem2;

  private ACRadioButtonItem specialManagementRadioItem3;

  private ACLabelContainer leaveConcernContainer;

  private ACIntegerCheckBox leaveAfterVisitCheck;

  private ACValueArrayRadioButtonGroup terminalCareRadioGroup;

  private ACLabelContainer terminalCareRadioGroupContainer;

  private ACListModelAdapter terminalCareRadioGroupModel;

  private ACRadioButtonItem terminalCareRadioItem1;

  private ACRadioButtonItem terminalCareRadioItem2;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem5;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACValueArrayRadioButtonGroup providerAddMountainousAreaRafioRadioGroup;

  private ACLabelContainer providerAddMountainousAreaRafioRadioGroupContainer;

  private ACListModelAdapter providerAddMountainousAreaRafioRadioGroupModel;

  private ACRadioButtonItem providerAddMountainousAreaRafioItem1;

  private ACRadioButtonItem providerAddMountainousAreaRafioRadioItem2;

  private ACComboBox serviceMunicipalityAdd;

  private ACLabelContainer serviceMunicipalityAddContainer;

  private ACComboBoxModelAdapter serviceMunicipalityAddModel;

  private ACValueArrayRadioButtonGroup dayCareUseSubtractionRadioGroup;

  private ACLabelContainer dayCareUseSubtractionRadioGroupContainer;

  private ACListModelAdapter dayCareUseSubtractionRadioGroupModel;

  private ACRadioButtonItem dayCareUseSubtractionRadioItem1;

  private ACRadioButtonItem dayCareUseSubtractionRadioItem2;

  private ACValueArrayRadioButtonGroup calculationDivision;

  private ACLabelContainer calculationDivisionContainer;

  private ACListModelAdapter calculationDivisionModel;

  private ACRadioButtonItem calculationDivisionNormal;

  private ACRadioButtonItem calculationDivisionAddOnly;

  private ACIntegerCheckBox crackOnDayCheck;

  private ACIntegerCheckBox printable;

  private ACBackLabelContainer homonNyuyokuTimeContainer;

  private ACTimeComboBox homonNyuyokuBeginTime;

  private ACLabelContainer homonNyuyokuBeginTimeContainer;

  private ACComboBoxModelAdapter homonNyuyokuBeginTimeModel;

  private ACTimeComboBox homonNyuyokuEndTime;

  private ACLabelContainer homonNyuyokuEndTimeContainer;

  private ACComboBoxModelAdapter homonNyuyokuEndTimeModel;

  private ACValueArrayRadioButtonGroup sameBuildingRadioGroup;

  private ACLabelContainer sameBuildingRadioGroupContainer;

  private ACListModelAdapter sameBuildingRadioGroupModel;

  private ACRadioButtonItem sameBuildingRadioItem1;

  private ACRadioButtonItem sameBuildingRadioItem2;

  private ACValueArrayRadioButtonGroup comprehensiveManagementSystemRadioGroup;

  private ACLabelContainer comprehensiveManagementSystemRadioGroupContainer;

  private ACListModelAdapter comprehensiveManagementSystemRadioGroupModel;

  private ACRadioButtonItem comprehensiveManagementSystemRadioItem1;

  private ACRadioButtonItem comprehensiveManagementSystemRadioItem2;

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
   * サービス提供を取得します。
   * @return サービス提供
   */
  public ACValueArrayRadioButtonGroup getDivisionRadioGroup(){
    if(divisionRadioGroup==null){

      divisionRadioGroup = new ACValueArrayRadioButtonGroup();

      getDivisionRadioGroupContainer().setText("サービス提供");

      divisionRadioGroup.setBindPath("1760101");

      divisionRadioGroup.setUseClearButton(false);

      divisionRadioGroup.setModel(getDivisionRadioGroupModel());

      divisionRadioGroup.setValues(new int[]{1,2});

      addDivisionRadioGroup();
    }
    return divisionRadioGroup;

  }

  /**
   * サービス提供コンテナを取得します。
   * @return サービス提供コンテナ
   */
  protected ACLabelContainer getDivisionRadioGroupContainer(){
    if(divisionRadioGroupContainer==null){
      divisionRadioGroupContainer = new ACLabelContainer();
      divisionRadioGroupContainer.setFollowChildEnabled(true);
      divisionRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      divisionRadioGroupContainer.add(getDivisionRadioGroup(), null);
    }
    return divisionRadioGroupContainer;
  }

  /**
   * サービス提供モデルを取得します。
   * @return サービス提供モデル
   */
  protected ACListModelAdapter getDivisionRadioGroupModel(){
    if(divisionRadioGroupModel==null){
      divisionRadioGroupModel = new ACListModelAdapter();
      addDivisionRadioGroupModel();
    }
    return divisionRadioGroupModel;
  }

  /**
   * 一体型定期巡回を取得します。
   * @return 一体型定期巡回
   */
  public ACRadioButtonItem getDivisionRadioItem1(){
    if(divisionRadioItem1==null){

      divisionRadioItem1 = new ACRadioButtonItem();

      divisionRadioItem1.setText("一体型定期巡回");

      divisionRadioItem1.setGroup(getDivisionRadioGroup());

      divisionRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addDivisionRadioItem1();
    }
    return divisionRadioItem1;

  }

  /**
   * 連携型定期巡回を取得します。
   * @return 連携型定期巡回
   */
  public ACRadioButtonItem getDivisionRadioItem2(){
    if(divisionRadioItem2==null){

      divisionRadioItem2 = new ACRadioButtonItem();

      divisionRadioItem2.setText("連携型定期巡回");

      divisionRadioItem2.setGroup(getDivisionRadioGroup());

      divisionRadioItem2.setConstraints(VRLayout.FLOW);

      addDivisionRadioItem2();
    }
    return divisionRadioItem2;

  }

  /**
   * 訪問看護サービスの提供を取得します。
   * @return 訪問看護サービスの提供
   */
  public ACValueArrayRadioButtonGroup getSijishoOfferRadioGroup(){
    if(sijishoOfferRadioGroup==null){

      sijishoOfferRadioGroup = new ACValueArrayRadioButtonGroup();

      getSijishoOfferRadioGroupContainer().setText("訪問看護サービスの提供");

      sijishoOfferRadioGroup.setBindPath("1760102");

      sijishoOfferRadioGroup.setUseClearButton(false);

      sijishoOfferRadioGroup.setModel(getSijishoOfferRadioGroupModel());

      sijishoOfferRadioGroup.setValues(new int[]{1,2});

      addSijishoOfferRadioGroup();
    }
    return sijishoOfferRadioGroup;

  }

  /**
   * 訪問看護サービスの提供コンテナを取得します。
   * @return 訪問看護サービスの提供コンテナ
   */
  protected ACLabelContainer getSijishoOfferRadioGroupContainer(){
    if(sijishoOfferRadioGroupContainer==null){
      sijishoOfferRadioGroupContainer = new ACLabelContainer();
      sijishoOfferRadioGroupContainer.setFollowChildEnabled(true);
      sijishoOfferRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      sijishoOfferRadioGroupContainer.add(getSijishoOfferRadioGroup(), null);
    }
    return sijishoOfferRadioGroupContainer;
  }

  /**
   * 訪問看護サービスの提供モデルを取得します。
   * @return 訪問看護サービスの提供モデル
   */
  protected ACListModelAdapter getSijishoOfferRadioGroupModel(){
    if(sijishoOfferRadioGroupModel==null){
      sijishoOfferRadioGroupModel = new ACListModelAdapter();
      addSijishoOfferRadioGroupModel();
    }
    return sijishoOfferRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getSijishoOfferRadioItem1(){
    if(sijishoOfferRadioItem1==null){

      sijishoOfferRadioItem1 = new ACRadioButtonItem();

      sijishoOfferRadioItem1.setText("なし");

      sijishoOfferRadioItem1.setGroup(getSijishoOfferRadioGroup());

      sijishoOfferRadioItem1.setConstraints(VRLayout.FLOW);

      addSijishoOfferRadioItem1();
    }
    return sijishoOfferRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getSijishoOfferRadioItem2(){
    if(sijishoOfferRadioItem2==null){

      sijishoOfferRadioItem2 = new ACRadioButtonItem();

      sijishoOfferRadioItem2.setText("あり");

      sijishoOfferRadioItem2.setGroup(getSijishoOfferRadioGroup());

      sijishoOfferRadioItem2.setConstraints(VRLayout.FLOW);

      addSijishoOfferRadioItem2();
    }
    return sijishoOfferRadioItem2;

  }

  /**
   * 看護職員区分を取得します。
   * @return 看護職員区分
   */
  public ACValueArrayRadioButtonGroup getNurseStaffDivisionRadioGroup(){
    if(nurseStaffDivisionRadioGroup==null){

      nurseStaffDivisionRadioGroup = new ACValueArrayRadioButtonGroup();

      getNurseStaffDivisionRadioGroupContainer().setText("看護職員区分");

      nurseStaffDivisionRadioGroup.setBindPath("1760103");

      nurseStaffDivisionRadioGroup.setUseClearButton(false);

      nurseStaffDivisionRadioGroup.setModel(getNurseStaffDivisionRadioGroupModel());

      nurseStaffDivisionRadioGroup.setValues(new int[]{1,2});

      addNurseStaffDivisionRadioGroup();
    }
    return nurseStaffDivisionRadioGroup;

  }

  /**
   * 看護職員区分コンテナを取得します。
   * @return 看護職員区分コンテナ
   */
  protected ACLabelContainer getNurseStaffDivisionRadioGroupContainer(){
    if(nurseStaffDivisionRadioGroupContainer==null){
      nurseStaffDivisionRadioGroupContainer = new ACLabelContainer();
      nurseStaffDivisionRadioGroupContainer.setFollowChildEnabled(true);
      nurseStaffDivisionRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      nurseStaffDivisionRadioGroupContainer.add(getNurseStaffDivisionRadioGroup(), null);
    }
    return nurseStaffDivisionRadioGroupContainer;
  }

  /**
   * 看護職員区分モデルを取得します。
   * @return 看護職員区分モデル
   */
  protected ACListModelAdapter getNurseStaffDivisionRadioGroupModel(){
    if(nurseStaffDivisionRadioGroupModel==null){
      nurseStaffDivisionRadioGroupModel = new ACListModelAdapter();
      addNurseStaffDivisionRadioGroupModel();
    }
    return nurseStaffDivisionRadioGroupModel;
  }

  /**
   * 正看等を取得します。
   * @return 正看等
   */
  public ACRadioButtonItem getNurseStaffDivisionRadioItem1(){
    if(nurseStaffDivisionRadioItem1==null){

      nurseStaffDivisionRadioItem1 = new ACRadioButtonItem();

      nurseStaffDivisionRadioItem1.setText("正看等");

      nurseStaffDivisionRadioItem1.setGroup(getNurseStaffDivisionRadioGroup());

      nurseStaffDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addNurseStaffDivisionRadioItem1();
    }
    return nurseStaffDivisionRadioItem1;

  }

  /**
   * 准看を取得します。
   * @return 准看
   */
  public ACRadioButtonItem getNurseStaffDivisionRadioItem2(){
    if(nurseStaffDivisionRadioItem2==null){

      nurseStaffDivisionRadioItem2 = new ACRadioButtonItem();

      nurseStaffDivisionRadioItem2.setText("准看");

      nurseStaffDivisionRadioItem2.setGroup(getNurseStaffDivisionRadioGroup());

      nurseStaffDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addNurseStaffDivisionRadioItem2();
    }
    return nurseStaffDivisionRadioItem2;

  }

  /**
   * 初期加算を取得します。
   * @return 初期加算
   */
  public ACValueArrayRadioButtonGroup getInitialAddRadioGroup(){
    if(initialAddRadioGroup==null){

      initialAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getInitialAddRadioGroupContainer().setText("初期加算");

      initialAddRadioGroup.setBindPath("1760104");

      initialAddRadioGroup.setUseClearButton(false);

      initialAddRadioGroup.setModel(getInitialAddRadioGroupModel());

      initialAddRadioGroup.setValues(new int[]{1,2});

      addInitialAddRadioGroup();
    }
    return initialAddRadioGroup;

  }

  /**
   * 初期加算コンテナを取得します。
   * @return 初期加算コンテナ
   */
  protected ACLabelContainer getInitialAddRadioGroupContainer(){
    if(initialAddRadioGroupContainer==null){
      initialAddRadioGroupContainer = new ACLabelContainer();
      initialAddRadioGroupContainer.setFollowChildEnabled(true);
      initialAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      initialAddRadioGroupContainer.add(getInitialAddRadioGroup(), null);
    }
    return initialAddRadioGroupContainer;
  }

  /**
   * 初期加算モデルを取得します。
   * @return 初期加算モデル
   */
  protected ACListModelAdapter getInitialAddRadioGroupModel(){
    if(initialAddRadioGroupModel==null){
      initialAddRadioGroupModel = new ACListModelAdapter();
      addInitialAddRadioGroupModel();
    }
    return initialAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getInitialAddRadioItem1(){
    if(initialAddRadioItem1==null){

      initialAddRadioItem1 = new ACRadioButtonItem();

      initialAddRadioItem1.setText("なし");

      initialAddRadioItem1.setGroup(getInitialAddRadioGroup());

      initialAddRadioItem1.setConstraints(VRLayout.FLOW);

      addInitialAddRadioItem1();
    }
    return initialAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getInitialAddRadioItem2(){
    if(initialAddRadioItem2==null){

      initialAddRadioItem2 = new ACRadioButtonItem();

      initialAddRadioItem2.setText("あり");

      initialAddRadioItem2.setGroup(getInitialAddRadioGroup());

      initialAddRadioItem2.setConstraints(VRLayout.FLOW);

      addInitialAddRadioItem2();
    }
    return initialAddRadioItem2;

  }

  /**
   * 緊急時訪問看護加算を取得します。
   * @return 緊急時訪問看護加算
   */
  public ACValueArrayRadioButtonGroup getEmergencyVisitRadioGroup(){
    if(emergencyVisitRadioGroup==null){

      emergencyVisitRadioGroup = new ACValueArrayRadioButtonGroup();

      getEmergencyVisitRadioGroupContainer().setText("緊急時訪問看護加算");

      emergencyVisitRadioGroup.setBindPath("1760105");

      emergencyVisitRadioGroup.setUseClearButton(false);

      emergencyVisitRadioGroup.setModel(getEmergencyVisitRadioGroupModel());

      emergencyVisitRadioGroup.setValues(new int[]{1,2});

      addEmergencyVisitRadioGroup();
    }
    return emergencyVisitRadioGroup;

  }

  /**
   * 緊急時訪問看護加算コンテナを取得します。
   * @return 緊急時訪問看護加算コンテナ
   */
  protected ACLabelContainer getEmergencyVisitRadioGroupContainer(){
    if(emergencyVisitRadioGroupContainer==null){
      emergencyVisitRadioGroupContainer = new ACLabelContainer();
      emergencyVisitRadioGroupContainer.setFollowChildEnabled(true);
      emergencyVisitRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      emergencyVisitRadioGroupContainer.add(getEmergencyVisitRadioGroup(), null);
    }
    return emergencyVisitRadioGroupContainer;
  }

  /**
   * 緊急時訪問看護加算モデルを取得します。
   * @return 緊急時訪問看護加算モデル
   */
  protected ACListModelAdapter getEmergencyVisitRadioGroupModel(){
    if(emergencyVisitRadioGroupModel==null){
      emergencyVisitRadioGroupModel = new ACListModelAdapter();
      addEmergencyVisitRadioGroupModel();
    }
    return emergencyVisitRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getEmergencyVisitRadioItem1(){
    if(emergencyVisitRadioItem1==null){

      emergencyVisitRadioItem1 = new ACRadioButtonItem();

      emergencyVisitRadioItem1.setText("なし");

      emergencyVisitRadioItem1.setGroup(getEmergencyVisitRadioGroup());

      emergencyVisitRadioItem1.setConstraints(VRLayout.FLOW);

      addEmergencyVisitRadioItem1();
    }
    return emergencyVisitRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getEmergencyVisitRadioItem2(){
    if(emergencyVisitRadioItem2==null){

      emergencyVisitRadioItem2 = new ACRadioButtonItem();

      emergencyVisitRadioItem2.setText("あり");

      emergencyVisitRadioItem2.setGroup(getEmergencyVisitRadioGroup());

      emergencyVisitRadioItem2.setConstraints(VRLayout.FLOW);

      addEmergencyVisitRadioItem2();
    }
    return emergencyVisitRadioItem2;

  }

  /**
   * 特別管理加算を取得します。
   * @return 特別管理加算
   */
  public ACValueArrayRadioButtonGroup getSpecialManagementRadioGroup(){
    if(specialManagementRadioGroup==null){

      specialManagementRadioGroup = new ACValueArrayRadioButtonGroup();

      getSpecialManagementRadioGroupContainer().setText("特別管理加算");

      specialManagementRadioGroup.setBindPath("1760106");

      specialManagementRadioGroup.setUseClearButton(false);

      specialManagementRadioGroup.setModel(getSpecialManagementRadioGroupModel());

      specialManagementRadioGroup.setValues(new int[]{1,2,3});

      addSpecialManagementRadioGroup();
    }
    return specialManagementRadioGroup;

  }

  /**
   * 特別管理加算コンテナを取得します。
   * @return 特別管理加算コンテナ
   */
  protected ACLabelContainer getSpecialManagementRadioGroupContainer(){
    if(specialManagementRadioGroupContainer==null){
      specialManagementRadioGroupContainer = new ACLabelContainer();
      specialManagementRadioGroupContainer.setFollowChildEnabled(true);
      specialManagementRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      specialManagementRadioGroupContainer.add(getSpecialManagementRadioGroup(), null);
    }
    return specialManagementRadioGroupContainer;
  }

  /**
   * 特別管理加算モデルを取得します。
   * @return 特別管理加算モデル
   */
  protected ACListModelAdapter getSpecialManagementRadioGroupModel(){
    if(specialManagementRadioGroupModel==null){
      specialManagementRadioGroupModel = new ACListModelAdapter();
      addSpecialManagementRadioGroupModel();
    }
    return specialManagementRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getSpecialManagementRadioItem1(){
    if(specialManagementRadioItem1==null){

      specialManagementRadioItem1 = new ACRadioButtonItem();

      specialManagementRadioItem1.setText("なし");

      specialManagementRadioItem1.setGroup(getSpecialManagementRadioGroup());

      specialManagementRadioItem1.setConstraints(VRLayout.FLOW);

      addSpecialManagementRadioItem1();
    }
    return specialManagementRadioItem1;

  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getSpecialManagementRadioItem2(){
    if(specialManagementRadioItem2==null){

      specialManagementRadioItem2 = new ACRadioButtonItem();

      specialManagementRadioItem2.setText("I型");

      specialManagementRadioItem2.setGroup(getSpecialManagementRadioGroup());

      specialManagementRadioItem2.setConstraints(VRLayout.FLOW);

      addSpecialManagementRadioItem2();
    }
    return specialManagementRadioItem2;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getSpecialManagementRadioItem3(){
    if(specialManagementRadioItem3==null){

      specialManagementRadioItem3 = new ACRadioButtonItem();

      specialManagementRadioItem3.setText("II型");

      specialManagementRadioItem3.setGroup(getSpecialManagementRadioGroup());

      specialManagementRadioItem3.setConstraints(VRLayout.FLOW);

      addSpecialManagementRadioItem3();
    }
    return specialManagementRadioItem3;

  }

  /**
   * 退所関連加算を取得します。
   * @return 退所関連加算
   */
  public ACLabelContainer getLeaveConcernContainer(){
    if(leaveConcernContainer==null){

      leaveConcernContainer = new ACLabelContainer();

      leaveConcernContainer.setText("退所関連加算");

      leaveConcernContainer.setFollowChildEnabled(true);

      addLeaveConcernContainer();
    }
    return leaveConcernContainer;

  }

  /**
   * 退院時共同指導加算を取得します。
   * @return 退院時共同指導加算
   */
  public ACIntegerCheckBox getLeaveAfterVisitCheck(){
    if(leaveAfterVisitCheck==null){

      leaveAfterVisitCheck = new ACIntegerCheckBox();

      leaveAfterVisitCheck.setText("退院時共同指導加算");

      leaveAfterVisitCheck.setBindPath("3020111");

      leaveAfterVisitCheck.setSelectValue(2);

      leaveAfterVisitCheck.setUnSelectValue(1);

      addLeaveAfterVisitCheck();
    }
    return leaveAfterVisitCheck;

  }

  /**
   * ターミナルケア加算を取得します。
   * @return ターミナルケア加算
   */
  public ACValueArrayRadioButtonGroup getTerminalCareRadioGroup(){
    if(terminalCareRadioGroup==null){

      terminalCareRadioGroup = new ACValueArrayRadioButtonGroup();

      getTerminalCareRadioGroupContainer().setText("ターミナルケア加算");

      terminalCareRadioGroup.setBindPath("1760107");

      terminalCareRadioGroup.setUseClearButton(false);

      terminalCareRadioGroup.setModel(getTerminalCareRadioGroupModel());

      terminalCareRadioGroup.setValues(new int[]{1,2});

      addTerminalCareRadioGroup();
    }
    return terminalCareRadioGroup;

  }

  /**
   * ターミナルケア加算コンテナを取得します。
   * @return ターミナルケア加算コンテナ
   */
  protected ACLabelContainer getTerminalCareRadioGroupContainer(){
    if(terminalCareRadioGroupContainer==null){
      terminalCareRadioGroupContainer = new ACLabelContainer();
      terminalCareRadioGroupContainer.setFollowChildEnabled(true);
      terminalCareRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      terminalCareRadioGroupContainer.add(getTerminalCareRadioGroup(), null);
    }
    return terminalCareRadioGroupContainer;
  }

  /**
   * ターミナルケア加算モデルを取得します。
   * @return ターミナルケア加算モデル
   */
  protected ACListModelAdapter getTerminalCareRadioGroupModel(){
    if(terminalCareRadioGroupModel==null){
      terminalCareRadioGroupModel = new ACListModelAdapter();
      addTerminalCareRadioGroupModel();
    }
    return terminalCareRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTerminalCareRadioItem1(){
    if(terminalCareRadioItem1==null){

      terminalCareRadioItem1 = new ACRadioButtonItem();

      terminalCareRadioItem1.setText("なし");

      terminalCareRadioItem1.setGroup(getTerminalCareRadioGroup());

      terminalCareRadioItem1.setConstraints(VRLayout.FLOW);

      addTerminalCareRadioItem1();
    }
    return terminalCareRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getTerminalCareRadioItem2(){
    if(terminalCareRadioItem2==null){

      terminalCareRadioItem2 = new ACRadioButtonItem();

      terminalCareRadioItem2.setText("あり");

      terminalCareRadioItem2.setGroup(getTerminalCareRadioGroup());

      terminalCareRadioItem2.setConstraints(VRLayout.FLOW);

      addTerminalCareRadioItem2();
    }
    return terminalCareRadioItem2;

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
   * サービス提供体制強化加算を取得します。
   * @return サービス提供体制強化加算
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("サービス提供体制強化加算");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1760108");

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
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("Iイ型");

      serviceAddProvisionStructuralRadioItem2.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addServiceAddProvisionStructuralRadioItem2();
    }
    return serviceAddProvisionStructuralRadioItem2;

  }

  /**
   * Iロ型を取得します。
   * @return Iロ型
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem5(){
    if(serviceAddProvisionStructuralRadioItem5==null){

      serviceAddProvisionStructuralRadioItem5 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem5.setText("Iロ型");

      serviceAddProvisionStructuralRadioItem5.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem5.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem5();
    }
    return serviceAddProvisionStructuralRadioItem5;

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
   * 中山間地域等でのサービス提供加算を取得します。
   * @return 中山間地域等でのサービス提供加算
   */
  public ACValueArrayRadioButtonGroup getProviderAddMountainousAreaRafioRadioGroup(){
    if(providerAddMountainousAreaRafioRadioGroup==null){

      providerAddMountainousAreaRafioRadioGroup = new ACValueArrayRadioButtonGroup();

      getProviderAddMountainousAreaRafioRadioGroupContainer().setText("中山間地域等でのサービス提供加算");

      providerAddMountainousAreaRafioRadioGroup.setBindPath("12");

      providerAddMountainousAreaRafioRadioGroup.setNoSelectIndex(0);

      providerAddMountainousAreaRafioRadioGroup.setUseClearButton(false);

      providerAddMountainousAreaRafioRadioGroup.setModel(getProviderAddMountainousAreaRafioRadioGroupModel());

      providerAddMountainousAreaRafioRadioGroup.setValues(new int[]{1,2});

      addProviderAddMountainousAreaRafioRadioGroup();
    }
    return providerAddMountainousAreaRafioRadioGroup;

  }

  /**
   * 中山間地域等でのサービス提供加算コンテナを取得します。
   * @return 中山間地域等でのサービス提供加算コンテナ
   */
  protected ACLabelContainer getProviderAddMountainousAreaRafioRadioGroupContainer(){
    if(providerAddMountainousAreaRafioRadioGroupContainer==null){
      providerAddMountainousAreaRafioRadioGroupContainer = new ACLabelContainer();
      providerAddMountainousAreaRafioRadioGroupContainer.setFollowChildEnabled(true);
      providerAddMountainousAreaRafioRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      providerAddMountainousAreaRafioRadioGroupContainer.add(getProviderAddMountainousAreaRafioRadioGroup(), null);
    }
    return providerAddMountainousAreaRafioRadioGroupContainer;
  }

  /**
   * 中山間地域等でのサービス提供加算モデルを取得します。
   * @return 中山間地域等でのサービス提供加算モデル
   */
  protected ACListModelAdapter getProviderAddMountainousAreaRafioRadioGroupModel(){
    if(providerAddMountainousAreaRafioRadioGroupModel==null){
      providerAddMountainousAreaRafioRadioGroupModel = new ACListModelAdapter();
      addProviderAddMountainousAreaRafioRadioGroupModel();
    }
    return providerAddMountainousAreaRafioRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getProviderAddMountainousAreaRafioItem1(){
    if(providerAddMountainousAreaRafioItem1==null){

      providerAddMountainousAreaRafioItem1 = new ACRadioButtonItem();

      providerAddMountainousAreaRafioItem1.setText("なし");

      providerAddMountainousAreaRafioItem1.setGroup(getProviderAddMountainousAreaRafioRadioGroup());

      providerAddMountainousAreaRafioItem1.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaRafioItem1();
    }
    return providerAddMountainousAreaRafioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getProviderAddMountainousAreaRafioRadioItem2(){
    if(providerAddMountainousAreaRafioRadioItem2==null){

      providerAddMountainousAreaRafioRadioItem2 = new ACRadioButtonItem();

      providerAddMountainousAreaRafioRadioItem2.setText("あり");

      providerAddMountainousAreaRafioRadioItem2.setGroup(getProviderAddMountainousAreaRafioRadioGroup());

      providerAddMountainousAreaRafioRadioItem2.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaRafioRadioItem2();
    }
    return providerAddMountainousAreaRafioRadioItem2;

  }

  /**
   * 定期巡回市町村独自加算を取得します。
   * @return 定期巡回市町村独自加算
   */
  public ACComboBox getServiceMunicipalityAdd(){
    if(serviceMunicipalityAdd==null){

      serviceMunicipalityAdd = new ACComboBox();

      getServiceMunicipalityAddContainer().setText("定期巡回市町村独自加算");

      serviceMunicipalityAdd.setBindPath("1760109");

      serviceMunicipalityAdd.setEditable(false);

      serviceMunicipalityAdd.setModelBindPath("1760109");

      serviceMunicipalityAdd.setRenderBindPath("CONTENT");

      serviceMunicipalityAdd.setBlankable(false);

      serviceMunicipalityAdd.setModel(getServiceMunicipalityAddModel());

      addServiceMunicipalityAdd();
    }
    return serviceMunicipalityAdd;

  }

  /**
   * 定期巡回市町村独自加算コンテナを取得します。
   * @return 定期巡回市町村独自加算コンテナ
   */
  protected ACLabelContainer getServiceMunicipalityAddContainer(){
    if(serviceMunicipalityAddContainer==null){
      serviceMunicipalityAddContainer = new ACLabelContainer();
      serviceMunicipalityAddContainer.setFollowChildEnabled(true);
      serviceMunicipalityAddContainer.setVAlignment(VRLayout.CENTER);
      serviceMunicipalityAddContainer.add(getServiceMunicipalityAdd(), null);
    }
    return serviceMunicipalityAddContainer;
  }

  /**
   * 定期巡回市町村独自加算モデルを取得します。
   * @return 定期巡回市町村独自加算モデル
   */
  protected ACComboBoxModelAdapter getServiceMunicipalityAddModel(){
    if(serviceMunicipalityAddModel==null){
      serviceMunicipalityAddModel = new ACComboBoxModelAdapter();
      addServiceMunicipalityAddModel();
    }
    return serviceMunicipalityAddModel;
  }

  /**
   * 通所利用減算を取得します。
   * @return 通所利用減算
   */
  public ACValueArrayRadioButtonGroup getDayCareUseSubtractionRadioGroup(){
    if(dayCareUseSubtractionRadioGroup==null){

      dayCareUseSubtractionRadioGroup = new ACValueArrayRadioButtonGroup();

      getDayCareUseSubtractionRadioGroupContainer().setText("通所利用減算");

      dayCareUseSubtractionRadioGroup.setBindPath("1760110");

      dayCareUseSubtractionRadioGroup.setUseClearButton(false);

      dayCareUseSubtractionRadioGroup.setModel(getDayCareUseSubtractionRadioGroupModel());

      dayCareUseSubtractionRadioGroup.setValues(new int[]{1,2});

      addDayCareUseSubtractionRadioGroup();
    }
    return dayCareUseSubtractionRadioGroup;

  }

  /**
   * 通所利用減算コンテナを取得します。
   * @return 通所利用減算コンテナ
   */
  protected ACLabelContainer getDayCareUseSubtractionRadioGroupContainer(){
    if(dayCareUseSubtractionRadioGroupContainer==null){
      dayCareUseSubtractionRadioGroupContainer = new ACLabelContainer();
      dayCareUseSubtractionRadioGroupContainer.setFollowChildEnabled(true);
      dayCareUseSubtractionRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      dayCareUseSubtractionRadioGroupContainer.add(getDayCareUseSubtractionRadioGroup(), null);
    }
    return dayCareUseSubtractionRadioGroupContainer;
  }

  /**
   * 通所利用減算モデルを取得します。
   * @return 通所利用減算モデル
   */
  protected ACListModelAdapter getDayCareUseSubtractionRadioGroupModel(){
    if(dayCareUseSubtractionRadioGroupModel==null){
      dayCareUseSubtractionRadioGroupModel = new ACListModelAdapter();
      addDayCareUseSubtractionRadioGroupModel();
    }
    return dayCareUseSubtractionRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getDayCareUseSubtractionRadioItem1(){
    if(dayCareUseSubtractionRadioItem1==null){

      dayCareUseSubtractionRadioItem1 = new ACRadioButtonItem();

      dayCareUseSubtractionRadioItem1.setText("なし");

      dayCareUseSubtractionRadioItem1.setGroup(getDayCareUseSubtractionRadioGroup());

      dayCareUseSubtractionRadioItem1.setConstraints(VRLayout.FLOW);

      addDayCareUseSubtractionRadioItem1();
    }
    return dayCareUseSubtractionRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getDayCareUseSubtractionRadioItem2(){
    if(dayCareUseSubtractionRadioItem2==null){

      dayCareUseSubtractionRadioItem2 = new ACRadioButtonItem();

      dayCareUseSubtractionRadioItem2.setText("あり");

      dayCareUseSubtractionRadioItem2.setGroup(getDayCareUseSubtractionRadioGroup());

      dayCareUseSubtractionRadioItem2.setConstraints(VRLayout.FLOW);

      addDayCareUseSubtractionRadioItem2();
    }
    return dayCareUseSubtractionRadioItem2;

  }

  /**
   * 算定区分を取得します。
   * @return 算定区分
   */
  public ACValueArrayRadioButtonGroup getCalculationDivision(){
    if(calculationDivision==null){

      calculationDivision = new ACValueArrayRadioButtonGroup();

      getCalculationDivisionContainer().setText("算定区分");

      calculationDivision.setBindPath("9");

      calculationDivision.setUseClearButton(false);

      calculationDivision.setModel(getCalculationDivisionModel());

      calculationDivision.setValues(new int[]{1,2});

      addCalculationDivision();
    }
    return calculationDivision;

  }

  /**
   * 算定区分コンテナを取得します。
   * @return 算定区分コンテナ
   */
  protected ACLabelContainer getCalculationDivisionContainer(){
    if(calculationDivisionContainer==null){
      calculationDivisionContainer = new ACLabelContainer();
      calculationDivisionContainer.setFollowChildEnabled(true);
      calculationDivisionContainer.setVAlignment(VRLayout.CENTER);
      calculationDivisionContainer.add(getCalculationDivision(), null);
    }
    return calculationDivisionContainer;
  }

  /**
   * 算定区分モデルを取得します。
   * @return 算定区分モデル
   */
  protected ACListModelAdapter getCalculationDivisionModel(){
    if(calculationDivisionModel==null){
      calculationDivisionModel = new ACListModelAdapter();
      addCalculationDivisionModel();
    }
    return calculationDivisionModel;
  }

  /**
   * 通常を取得します。
   * @return 通常
   */
  public ACRadioButtonItem getCalculationDivisionNormal(){
    if(calculationDivisionNormal==null){

      calculationDivisionNormal = new ACRadioButtonItem();

      calculationDivisionNormal.setText("通常");

      calculationDivisionNormal.setGroup(getCalculationDivision());

      calculationDivisionNormal.setConstraints(VRLayout.FLOW);

      addCalculationDivisionNormal();
    }
    return calculationDivisionNormal;

  }

  /**
   * 加算のみを取得します。
   * @return 加算のみ
   */
  public ACRadioButtonItem getCalculationDivisionAddOnly(){
    if(calculationDivisionAddOnly==null){

      calculationDivisionAddOnly = new ACRadioButtonItem();

      calculationDivisionAddOnly.setText("加算のみ");

      calculationDivisionAddOnly.setGroup(getCalculationDivision());

      calculationDivisionAddOnly.setConstraints(VRLayout.FLOW);

      addCalculationDivisionAddOnly();
    }
    return calculationDivisionAddOnly;

  }

  /**
   * 日割を取得します。
   * @return 日割
   */
  public ACIntegerCheckBox getCrackOnDayCheck(){
    if(crackOnDayCheck==null){

      crackOnDayCheck = new ACIntegerCheckBox();

      crackOnDayCheck.setText("日割");

      crackOnDayCheck.setBindPath("1760111");

      crackOnDayCheck.setSelectValue(2);

      crackOnDayCheck.setUnSelectValue(1);

      addCrackOnDayCheck();
    }
    return crackOnDayCheck;

  }

  /**
   * 提供日を取得します。
   * @return 提供日
   */
  public ACIntegerCheckBox getPrintable(){
    if(printable==null){

      printable = new ACIntegerCheckBox();

      printable.setText("提供日");

      printable.setBindPath("15");

      printable.setSelectValue(2);

      printable.setUnSelectValue(1);

      addPrintable();
    }
    return printable;

  }

  /**
   * 提供時間コンテナを取得します。
   * @return 提供時間コンテナ
   */
  public ACBackLabelContainer getHomonNyuyokuTimeContainer(){
    if(homonNyuyokuTimeContainer==null){

      homonNyuyokuTimeContainer = new ACBackLabelContainer();

      homonNyuyokuTimeContainer.setFollowChildEnabled(true);

      addHomonNyuyokuTimeContainer();
    }
    return homonNyuyokuTimeContainer;

  }

  /**
   * 開始時刻コンボを取得します。
   * @return 開始時刻コンボ
   */
  public ACTimeComboBox getHomonNyuyokuBeginTime(){
    if(homonNyuyokuBeginTime==null){

      homonNyuyokuBeginTime = new ACTimeComboBox();

      getHomonNyuyokuBeginTimeContainer().setText("開始時刻");

      homonNyuyokuBeginTime.setBindPath("3");

      homonNyuyokuBeginTime.setModelBindPath("3");

      homonNyuyokuBeginTime.setRenderBindPath("CONTENT");

      homonNyuyokuBeginTime.setModel(getHomonNyuyokuBeginTimeModel());

      addHomonNyuyokuBeginTime();
    }
    return homonNyuyokuBeginTime;

  }

  /**
   * 開始時刻コンボコンテナを取得します。
   * @return 開始時刻コンボコンテナ
   */
  protected ACLabelContainer getHomonNyuyokuBeginTimeContainer(){
    if(homonNyuyokuBeginTimeContainer==null){
      homonNyuyokuBeginTimeContainer = new ACLabelContainer();
      homonNyuyokuBeginTimeContainer.setFollowChildEnabled(true);
      homonNyuyokuBeginTimeContainer.setVAlignment(VRLayout.CENTER);
      homonNyuyokuBeginTimeContainer.add(getHomonNyuyokuBeginTime(), null);
    }
    return homonNyuyokuBeginTimeContainer;
  }

  /**
   * 開始時刻コンボモデルを取得します。
   * @return 開始時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getHomonNyuyokuBeginTimeModel(){
    if(homonNyuyokuBeginTimeModel==null){
      homonNyuyokuBeginTimeModel = new ACComboBoxModelAdapter();
      addHomonNyuyokuBeginTimeModel();
    }
    return homonNyuyokuBeginTimeModel;
  }

  /**
   * 終了時刻コンボを取得します。
   * @return 終了時刻コンボ
   */
  public ACTimeComboBox getHomonNyuyokuEndTime(){
    if(homonNyuyokuEndTime==null){

      homonNyuyokuEndTime = new ACTimeComboBox();

      getHomonNyuyokuEndTimeContainer().setText("終了時刻");

      homonNyuyokuEndTime.setBindPath("4");

      homonNyuyokuEndTime.setModelBindPath("4");

      homonNyuyokuEndTime.setRenderBindPath("CONTENT");

      homonNyuyokuEndTime.setModel(getHomonNyuyokuEndTimeModel());

      addHomonNyuyokuEndTime();
    }
    return homonNyuyokuEndTime;

  }

  /**
   * 終了時刻コンボコンテナを取得します。
   * @return 終了時刻コンボコンテナ
   */
  protected ACLabelContainer getHomonNyuyokuEndTimeContainer(){
    if(homonNyuyokuEndTimeContainer==null){
      homonNyuyokuEndTimeContainer = new ACLabelContainer();
      homonNyuyokuEndTimeContainer.setFollowChildEnabled(true);
      homonNyuyokuEndTimeContainer.setVAlignment(VRLayout.CENTER);
      homonNyuyokuEndTimeContainer.add(getHomonNyuyokuEndTime(), null);
    }
    return homonNyuyokuEndTimeContainer;
  }

  /**
   * 終了時刻コンボモデルを取得します。
   * @return 終了時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getHomonNyuyokuEndTimeModel(){
    if(homonNyuyokuEndTimeModel==null){
      homonNyuyokuEndTimeModel = new ACComboBoxModelAdapter();
      addHomonNyuyokuEndTimeModel();
    }
    return homonNyuyokuEndTimeModel;
  }

  /**
   * 同一建物居住者へのサービス提供を取得します。
   * @return 同一建物居住者へのサービス提供
   */
  public ACValueArrayRadioButtonGroup getSameBuildingRadioGroup(){
    if(sameBuildingRadioGroup==null){

      sameBuildingRadioGroup = new ACValueArrayRadioButtonGroup();

      getSameBuildingRadioGroupContainer().setText("同一建物居住者へのサービス提供");

      sameBuildingRadioGroup.setBindPath("16");

      sameBuildingRadioGroup.setVisible(true);

      sameBuildingRadioGroup.setEnabled(true);

      sameBuildingRadioGroup.setNoSelectIndex(0);

      sameBuildingRadioGroup.setUseClearButton(false);

      sameBuildingRadioGroup.setModel(getSameBuildingRadioGroupModel());

      sameBuildingRadioGroup.setValues(new int[]{1,2});

      addSameBuildingRadioGroup();
    }
    return sameBuildingRadioGroup;

  }

  /**
   * 同一建物居住者へのサービス提供コンテナを取得します。
   * @return 同一建物居住者へのサービス提供コンテナ
   */
  protected ACLabelContainer getSameBuildingRadioGroupContainer(){
    if(sameBuildingRadioGroupContainer==null){
      sameBuildingRadioGroupContainer = new ACLabelContainer();
      sameBuildingRadioGroupContainer.setFollowChildEnabled(true);
      sameBuildingRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      sameBuildingRadioGroupContainer.add(getSameBuildingRadioGroup(), null);
    }
    return sameBuildingRadioGroupContainer;
  }

  /**
   * 同一建物居住者へのサービス提供モデルを取得します。
   * @return 同一建物居住者へのサービス提供モデル
   */
  protected ACListModelAdapter getSameBuildingRadioGroupModel(){
    if(sameBuildingRadioGroupModel==null){
      sameBuildingRadioGroupModel = new ACListModelAdapter();
      addSameBuildingRadioGroupModel();
    }
    return sameBuildingRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getSameBuildingRadioItem1(){
    if(sameBuildingRadioItem1==null){

      sameBuildingRadioItem1 = new ACRadioButtonItem();

      sameBuildingRadioItem1.setText("なし");

      sameBuildingRadioItem1.setGroup(getSameBuildingRadioGroup());

      sameBuildingRadioItem1.setConstraints(VRLayout.FLOW);

      addSameBuildingRadioItem1();
    }
    return sameBuildingRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getSameBuildingRadioItem2(){
    if(sameBuildingRadioItem2==null){

      sameBuildingRadioItem2 = new ACRadioButtonItem();

      sameBuildingRadioItem2.setText("あり");

      sameBuildingRadioItem2.setGroup(getSameBuildingRadioGroup());

      sameBuildingRadioItem2.setConstraints(VRLayout.FLOW);

      addSameBuildingRadioItem2();
    }
    return sameBuildingRadioItem2;

  }

  /**
   * 総合マネジメント体制強化加算を取得します。
   * @return 総合マネジメント体制強化加算
   */
  public ACValueArrayRadioButtonGroup getComprehensiveManagementSystemRadioGroup(){
    if(comprehensiveManagementSystemRadioGroup==null){

      comprehensiveManagementSystemRadioGroup = new ACValueArrayRadioButtonGroup();

      getComprehensiveManagementSystemRadioGroupContainer().setText("総合マネジメント体制強化加算");

      comprehensiveManagementSystemRadioGroup.setBindPath("1760112");

      comprehensiveManagementSystemRadioGroup.setVisible(true);

      comprehensiveManagementSystemRadioGroup.setEnabled(true);

      comprehensiveManagementSystemRadioGroup.setNoSelectIndex(0);

      comprehensiveManagementSystemRadioGroup.setUseClearButton(false);

      comprehensiveManagementSystemRadioGroup.setModel(getComprehensiveManagementSystemRadioGroupModel());

      comprehensiveManagementSystemRadioGroup.setValues(new int[]{1,2});

      addComprehensiveManagementSystemRadioGroup();
    }
    return comprehensiveManagementSystemRadioGroup;

  }

  /**
   * 総合マネジメント体制強化加算コンテナを取得します。
   * @return 総合マネジメント体制強化加算コンテナ
   */
  protected ACLabelContainer getComprehensiveManagementSystemRadioGroupContainer(){
    if(comprehensiveManagementSystemRadioGroupContainer==null){
      comprehensiveManagementSystemRadioGroupContainer = new ACLabelContainer();
      comprehensiveManagementSystemRadioGroupContainer.setFollowChildEnabled(true);
      comprehensiveManagementSystemRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      comprehensiveManagementSystemRadioGroupContainer.add(getComprehensiveManagementSystemRadioGroup(), null);
    }
    return comprehensiveManagementSystemRadioGroupContainer;
  }

  /**
   * 総合マネジメント体制強化加算モデルを取得します。
   * @return 総合マネジメント体制強化加算モデル
   */
  protected ACListModelAdapter getComprehensiveManagementSystemRadioGroupModel(){
    if(comprehensiveManagementSystemRadioGroupModel==null){
      comprehensiveManagementSystemRadioGroupModel = new ACListModelAdapter();
      addComprehensiveManagementSystemRadioGroupModel();
    }
    return comprehensiveManagementSystemRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getComprehensiveManagementSystemRadioItem1(){
    if(comprehensiveManagementSystemRadioItem1==null){

      comprehensiveManagementSystemRadioItem1 = new ACRadioButtonItem();

      comprehensiveManagementSystemRadioItem1.setText("なし");

      comprehensiveManagementSystemRadioItem1.setGroup(getComprehensiveManagementSystemRadioGroup());

      comprehensiveManagementSystemRadioItem1.setConstraints(VRLayout.FLOW);

      addComprehensiveManagementSystemRadioItem1();
    }
    return comprehensiveManagementSystemRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getComprehensiveManagementSystemRadioItem2(){
    if(comprehensiveManagementSystemRadioItem2==null){

      comprehensiveManagementSystemRadioItem2 = new ACRadioButtonItem();

      comprehensiveManagementSystemRadioItem2.setText("あり");

      comprehensiveManagementSystemRadioItem2.setGroup(getComprehensiveManagementSystemRadioGroup());

      comprehensiveManagementSystemRadioItem2.setConstraints(VRLayout.FLOW);

      addComprehensiveManagementSystemRadioItem2();
    }
    return comprehensiveManagementSystemRadioItem2;

  }

  /**
   * コンストラクタです。
   */
  public QS001_17611_201504Design() {

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

  }

  /**
   * タブ1に内部項目を追加します。
   */
  protected void addTab1(){

    tab1.add(getDivisionRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getSijishoOfferRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getNurseStaffDivisionRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getInitialAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getEmergencyVisitRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getSpecialManagementRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getLeaveConcernContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getTerminalCareRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * サービス提供に内部項目を追加します。
   */
  protected void addDivisionRadioGroup(){

  }

  /**
   * サービス提供モデルに内部項目を追加します。
   */
  protected void addDivisionRadioGroupModel(){

    getDivisionRadioItem1().setButtonIndex(1);

    getDivisionRadioGroupModel().add(getDivisionRadioItem1());

    getDivisionRadioItem2().setButtonIndex(2);

    getDivisionRadioGroupModel().add(getDivisionRadioItem2());

  }

  /**
   * 一体型定期巡回に内部項目を追加します。
   */
  protected void addDivisionRadioItem1(){

  }

  /**
   * 連携型定期巡回に内部項目を追加します。
   */
  protected void addDivisionRadioItem2(){

  }

  /**
   * 訪問看護サービスの提供に内部項目を追加します。
   */
  protected void addSijishoOfferRadioGroup(){

  }

  /**
   * 訪問看護サービスの提供モデルに内部項目を追加します。
   */
  protected void addSijishoOfferRadioGroupModel(){

    getSijishoOfferRadioItem1().setButtonIndex(1);

    getSijishoOfferRadioGroupModel().add(getSijishoOfferRadioItem1());

    getSijishoOfferRadioItem2().setButtonIndex(2);

    getSijishoOfferRadioGroupModel().add(getSijishoOfferRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addSijishoOfferRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addSijishoOfferRadioItem2(){

  }

  /**
   * 看護職員区分に内部項目を追加します。
   */
  protected void addNurseStaffDivisionRadioGroup(){

  }

  /**
   * 看護職員区分モデルに内部項目を追加します。
   */
  protected void addNurseStaffDivisionRadioGroupModel(){

    getNurseStaffDivisionRadioItem1().setButtonIndex(1);

    getNurseStaffDivisionRadioGroupModel().add(getNurseStaffDivisionRadioItem1());

    getNurseStaffDivisionRadioItem2().setButtonIndex(2);

    getNurseStaffDivisionRadioGroupModel().add(getNurseStaffDivisionRadioItem2());

  }

  /**
   * 正看等に内部項目を追加します。
   */
  protected void addNurseStaffDivisionRadioItem1(){

  }

  /**
   * 准看に内部項目を追加します。
   */
  protected void addNurseStaffDivisionRadioItem2(){

  }

  /**
   * 初期加算に内部項目を追加します。
   */
  protected void addInitialAddRadioGroup(){

  }

  /**
   * 初期加算モデルに内部項目を追加します。
   */
  protected void addInitialAddRadioGroupModel(){

    getInitialAddRadioItem1().setButtonIndex(1);

    getInitialAddRadioGroupModel().add(getInitialAddRadioItem1());

    getInitialAddRadioItem2().setButtonIndex(2);

    getInitialAddRadioGroupModel().add(getInitialAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addInitialAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addInitialAddRadioItem2(){

  }

  /**
   * 緊急時訪問看護加算に内部項目を追加します。
   */
  protected void addEmergencyVisitRadioGroup(){

  }

  /**
   * 緊急時訪問看護加算モデルに内部項目を追加します。
   */
  protected void addEmergencyVisitRadioGroupModel(){

    getEmergencyVisitRadioItem1().setButtonIndex(1);

    getEmergencyVisitRadioGroupModel().add(getEmergencyVisitRadioItem1());

    getEmergencyVisitRadioItem2().setButtonIndex(2);

    getEmergencyVisitRadioGroupModel().add(getEmergencyVisitRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addEmergencyVisitRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addEmergencyVisitRadioItem2(){

  }

  /**
   * 特別管理加算に内部項目を追加します。
   */
  protected void addSpecialManagementRadioGroup(){

  }

  /**
   * 特別管理加算モデルに内部項目を追加します。
   */
  protected void addSpecialManagementRadioGroupModel(){

    getSpecialManagementRadioItem1().setButtonIndex(1);

    getSpecialManagementRadioGroupModel().add(getSpecialManagementRadioItem1());

    getSpecialManagementRadioItem2().setButtonIndex(2);

    getSpecialManagementRadioGroupModel().add(getSpecialManagementRadioItem2());

    getSpecialManagementRadioItem3().setButtonIndex(3);

    getSpecialManagementRadioGroupModel().add(getSpecialManagementRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addSpecialManagementRadioItem1(){

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addSpecialManagementRadioItem2(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addSpecialManagementRadioItem3(){

  }

  /**
   * 退所関連加算に内部項目を追加します。
   */
  protected void addLeaveConcernContainer(){

    leaveConcernContainer.add(getLeaveAfterVisitCheck(), VRLayout.FLOW_RETURN);

  }

  /**
   * 退院時共同指導加算に内部項目を追加します。
   */
  protected void addLeaveAfterVisitCheck(){

  }

  /**
   * ターミナルケア加算に内部項目を追加します。
   */
  protected void addTerminalCareRadioGroup(){

  }

  /**
   * ターミナルケア加算モデルに内部項目を追加します。
   */
  protected void addTerminalCareRadioGroupModel(){

    getTerminalCareRadioItem1().setButtonIndex(1);

    getTerminalCareRadioGroupModel().add(getTerminalCareRadioItem1());

    getTerminalCareRadioItem2().setButtonIndex(2);

    getTerminalCareRadioGroupModel().add(getTerminalCareRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTerminalCareRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addTerminalCareRadioItem2(){

  }

  /**
   * タブ2に内部項目を追加します。
   */
  protected void addTab2(){

    tab2.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getProviderAddMountainousAreaRafioRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getServiceMunicipalityAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getDayCareUseSubtractionRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getCalculationDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getCrackOnDayCheck(), VRLayout.FLOW);

    tab2.add(getPrintable(), VRLayout.FLOW_RETURN);

    tab2.add(getHomonNyuyokuTimeContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    tab2.add(getSameBuildingRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getComprehensiveManagementSystemRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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

    getServiceAddProvisionStructuralRadioItem5().setButtonIndex(2);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem5());

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
  protected void addServiceAddProvisionStructuralRadioItem2(){

  }

  /**
   * Iロ型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem5(){

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
   * 中山間地域等でのサービス提供加算に内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaRafioRadioGroup(){

  }

  /**
   * 中山間地域等でのサービス提供加算モデルに内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaRafioRadioGroupModel(){

    getProviderAddMountainousAreaRafioItem1().setButtonIndex(1);

    getProviderAddMountainousAreaRafioRadioGroupModel().add(getProviderAddMountainousAreaRafioItem1());

    getProviderAddMountainousAreaRafioRadioItem2().setButtonIndex(2);

    getProviderAddMountainousAreaRafioRadioGroupModel().add(getProviderAddMountainousAreaRafioRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaRafioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaRafioRadioItem2(){

  }

  /**
   * 定期巡回市町村独自加算に内部項目を追加します。
   */
  protected void addServiceMunicipalityAdd(){

  }

  /**
   * 定期巡回市町村独自加算モデルに内部項目を追加します。
   */
  protected void addServiceMunicipalityAddModel(){

  }

  /**
   * 通所利用減算に内部項目を追加します。
   */
  protected void addDayCareUseSubtractionRadioGroup(){

  }

  /**
   * 通所利用減算モデルに内部項目を追加します。
   */
  protected void addDayCareUseSubtractionRadioGroupModel(){

    getDayCareUseSubtractionRadioItem1().setButtonIndex(1);

    getDayCareUseSubtractionRadioGroupModel().add(getDayCareUseSubtractionRadioItem1());

    getDayCareUseSubtractionRadioItem2().setButtonIndex(2);

    getDayCareUseSubtractionRadioGroupModel().add(getDayCareUseSubtractionRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addDayCareUseSubtractionRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addDayCareUseSubtractionRadioItem2(){

  }

  /**
   * 算定区分に内部項目を追加します。
   */
  protected void addCalculationDivision(){

  }

  /**
   * 算定区分モデルに内部項目を追加します。
   */
  protected void addCalculationDivisionModel(){

    getCalculationDivisionNormal().setButtonIndex(1);

    getCalculationDivisionModel().add(getCalculationDivisionNormal());

    getCalculationDivisionAddOnly().setButtonIndex(2);

    getCalculationDivisionModel().add(getCalculationDivisionAddOnly());

  }

  /**
   * 通常に内部項目を追加します。
   */
  protected void addCalculationDivisionNormal(){

  }

  /**
   * 加算のみに内部項目を追加します。
   */
  protected void addCalculationDivisionAddOnly(){

  }

  /**
   * 日割に内部項目を追加します。
   */
  protected void addCrackOnDayCheck(){

  }

  /**
   * 提供日に内部項目を追加します。
   */
  protected void addPrintable(){

  }

  /**
   * 提供時間コンテナに内部項目を追加します。
   */
  protected void addHomonNyuyokuTimeContainer(){

    homonNyuyokuTimeContainer.add(getHomonNyuyokuBeginTimeContainer(), VRLayout.FLOW);

    homonNyuyokuTimeContainer.add(getHomonNyuyokuEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * 開始時刻コンボに内部項目を追加します。
   */
  protected void addHomonNyuyokuBeginTime(){

  }

  /**
   * 開始時刻コンボモデルに内部項目を追加します。
   */
  protected void addHomonNyuyokuBeginTimeModel(){

  }

  /**
   * 終了時刻コンボに内部項目を追加します。
   */
  protected void addHomonNyuyokuEndTime(){

  }

  /**
   * 終了時刻コンボモデルに内部項目を追加します。
   */
  protected void addHomonNyuyokuEndTimeModel(){

  }

  /**
   * 同一建物居住者へのサービス提供に内部項目を追加します。
   */
  protected void addSameBuildingRadioGroup(){

  }

  /**
   * 同一建物居住者へのサービス提供モデルに内部項目を追加します。
   */
  protected void addSameBuildingRadioGroupModel(){

    getSameBuildingRadioItem1().setButtonIndex(1);

    getSameBuildingRadioGroupModel().add(getSameBuildingRadioItem1());

    getSameBuildingRadioItem2().setButtonIndex(2);

    getSameBuildingRadioGroupModel().add(getSameBuildingRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addSameBuildingRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addSameBuildingRadioItem2(){

  }

  /**
   * 総合マネジメント体制強化加算に内部項目を追加します。
   */
  protected void addComprehensiveManagementSystemRadioGroup(){

  }

  /**
   * 総合マネジメント体制強化加算モデルに内部項目を追加します。
   */
  protected void addComprehensiveManagementSystemRadioGroupModel(){

    getComprehensiveManagementSystemRadioItem1().setButtonIndex(1);

    getComprehensiveManagementSystemRadioGroupModel().add(getComprehensiveManagementSystemRadioItem1());

    getComprehensiveManagementSystemRadioItem2().setButtonIndex(2);

    getComprehensiveManagementSystemRadioGroupModel().add(getComprehensiveManagementSystemRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addComprehensiveManagementSystemRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addComprehensiveManagementSystemRadioItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_17611_201504Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001_17611_201504Design getThis() {
    return this;
  }
}
