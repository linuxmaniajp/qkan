
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
 * 作成日: 2015/02/28  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業者登録 (004)
 * プログラム 複合型サービス（看護小規模多機能型居宅介護・短期利用以外） (QO004_17711_201504)
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
 * 複合型サービス（看護小規模多機能型居宅介護・短期利用以外）画面項目デザイン(QO004_17711_201504) 
 */
public class QO004_17711_201504Design extends QO004ProviderPanel {
  //GUIコンポーネント

  private ACGroupBox mainGroup;

  private ACValueArrayRadioButtonGroup staffLackRadioGroup;

  private ACLabelContainer staffLackRadioGroupContainer;

  private ACListModelAdapter staffLackRadioGroupModel;

  private ACRadioButtonItem staffLackRadioItem1;

  private ACRadioButtonItem staffLackRadioItem2;

  private ACRadioButtonItem staffLackRadioItem3;

  private ACValueArrayRadioButtonGroup nursingSystemSubtractionRadioGroup;

  private ACLabelContainer nursingSystemSubtractionRadioGroupContainer;

  private ACListModelAdapter nursingSystemSubtractionRadioGroupModel;

  private ACRadioButtonItem nursingSystemSubtractionRadioItem1;

  private ACRadioButtonItem nursingSystemSubtractionRadioItem2;

  private ACValueArrayRadioButtonGroup emergencyRadioGroup;

  private ACLabelContainer emergencyRadioGroupContainer;

  private ACListModelAdapter emergencyRadioGroupModel;

  private ACRadioButtonItem emergencyRadioItem1;

  private ACRadioButtonItem emergencyRadioItem2;

  private ACValueArrayRadioButtonGroup specialManagementSystemRadioGroup;

  private ACLabelContainer specialManagementSystemRadioGroupContainer;

  private ACListModelAdapter specialManagementSystemRadioGroupModel;

  private ACRadioButtonItem specialManagementSystemRadioItem1;

  private ACRadioButtonItem specialManagementSystemRadioItem2;

  private ACValueArrayRadioButtonGroup terminalCareRadioGroup;

  private ACLabelContainer terminalCareRadioGroupContainer;

  private ACListModelAdapter terminalCareRadioGroupModel;

  private ACRadioButtonItem terminalCareRadioItem1;

  private ACRadioButtonItem terminalCareRadioItem2;

  private ACValueArrayRadioButtonGroup nursingStrengthenAddRadioGroup;

  private ACLabelContainer nursingStrengthenAddRadioGroupContainer;

  private ACListModelAdapter nursingStrengthenAddRadioGroupModel;

  private ACRadioButtonItem nursingStrengthenAddRadioItem1;

  private ACRadioButtonItem nursingStrengthenAddRadioItem2;

  private ACValueArrayRadioButtonGroup comprehensiveManagementSystemRadioGroup;

  private ACLabelContainer comprehensiveManagementSystemRadioGroupContainer;

  private ACListModelAdapter comprehensiveManagementSystemRadioGroupModel;

  private ACRadioButtonItem comprehensiveManagementSystemRadioItem1;

  private ACRadioButtonItem comprehensiveManagementSystemRadioItem2;

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

  private ACLabelContainer reduceRateContainer;

  private ACTextField reduceRate;

  private ACLabel percentSign;

  private ACIntegerCheckBox ShahukuReduce;

  private ACPanel oldLowElementArea;

  //getter

  /**
   * 事業グループを取得します。
   * @return 事業グループ
   */
  public ACGroupBox getMainGroup(){
    if(mainGroup==null){

      mainGroup = new ACGroupBox();

      mainGroup.setText("複合型サービス（看護小規模多機能型居宅介護・短期利用以外）");

      mainGroup.setFollowChildEnabled(true);

      addMainGroup();
    }
    return mainGroup;

  }

  /**
   * 職員の欠員による減算の状況を取得します。
   * @return 職員の欠員による減算の状況
   */
  public ACValueArrayRadioButtonGroup getStaffLackRadioGroup(){
    if(staffLackRadioGroup==null){

      staffLackRadioGroup = new ACValueArrayRadioButtonGroup();

      getStaffLackRadioGroupContainer().setText("職員の欠員による減算の状況");

      staffLackRadioGroup.setBindPath("1770101");

      staffLackRadioGroup.setVisible(true);

      staffLackRadioGroup.setEnabled(true);

      staffLackRadioGroup.setNoSelectIndex(0);

      staffLackRadioGroup.setUseClearButton(false);

      staffLackRadioGroup.setModel(getStaffLackRadioGroupModel());

      staffLackRadioGroup.setValues(new int[]{1,2,3});

      addStaffLackRadioGroup();
    }
    return staffLackRadioGroup;

  }

  /**
   * 職員の欠員による減算の状況コンテナを取得します。
   * @return 職員の欠員による減算の状況コンテナ
   */
  protected ACLabelContainer getStaffLackRadioGroupContainer(){
    if(staffLackRadioGroupContainer==null){
      staffLackRadioGroupContainer = new ACLabelContainer();
      staffLackRadioGroupContainer.setFollowChildEnabled(true);
      staffLackRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      staffLackRadioGroupContainer.add(getStaffLackRadioGroup(), null);
    }
    return staffLackRadioGroupContainer;
  }

  /**
   * 職員の欠員による減算の状況モデルを取得します。
   * @return 職員の欠員による減算の状況モデル
   */
  protected ACListModelAdapter getStaffLackRadioGroupModel(){
    if(staffLackRadioGroupModel==null){
      staffLackRadioGroupModel = new ACListModelAdapter();
      addStaffLackRadioGroupModel();
    }
    return staffLackRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getStaffLackRadioItem1(){
    if(staffLackRadioItem1==null){

      staffLackRadioItem1 = new ACRadioButtonItem();

      staffLackRadioItem1.setText("なし");

      staffLackRadioItem1.setGroup(getStaffLackRadioGroup());

      staffLackRadioItem1.setConstraints(VRLayout.FLOW);

      addStaffLackRadioItem1();
    }
    return staffLackRadioItem1;

  }

  /**
   * 看護職員を取得します。
   * @return 看護職員
   */
  public ACRadioButtonItem getStaffLackRadioItem2(){
    if(staffLackRadioItem2==null){

      staffLackRadioItem2 = new ACRadioButtonItem();

      staffLackRadioItem2.setText("看護職員");

      staffLackRadioItem2.setGroup(getStaffLackRadioGroup());

      staffLackRadioItem2.setConstraints(VRLayout.FLOW);

      addStaffLackRadioItem2();
    }
    return staffLackRadioItem2;

  }

  /**
   * 介護職員を取得します。
   * @return 介護職員
   */
  public ACRadioButtonItem getStaffLackRadioItem3(){
    if(staffLackRadioItem3==null){

      staffLackRadioItem3 = new ACRadioButtonItem();

      staffLackRadioItem3.setText("介護職員");

      staffLackRadioItem3.setGroup(getStaffLackRadioGroup());

      staffLackRadioItem3.setConstraints(VRLayout.FLOW);

      addStaffLackRadioItem3();
    }
    return staffLackRadioItem3;

  }

  /**
   * 訪問看護体制減算を取得します。
   * @return 訪問看護体制減算
   */
  public ACValueArrayRadioButtonGroup getNursingSystemSubtractionRadioGroup(){
    if(nursingSystemSubtractionRadioGroup==null){

      nursingSystemSubtractionRadioGroup = new ACValueArrayRadioButtonGroup();

      getNursingSystemSubtractionRadioGroupContainer().setText("訪問看護体制減算");

      nursingSystemSubtractionRadioGroup.setBindPath("1770106");

      nursingSystemSubtractionRadioGroup.setVisible(true);

      nursingSystemSubtractionRadioGroup.setEnabled(true);

      nursingSystemSubtractionRadioGroup.setNoSelectIndex(0);

      nursingSystemSubtractionRadioGroup.setUseClearButton(false);

      nursingSystemSubtractionRadioGroup.setModel(getNursingSystemSubtractionRadioGroupModel());

      nursingSystemSubtractionRadioGroup.setValues(new int[]{1,2});

      addNursingSystemSubtractionRadioGroup();
    }
    return nursingSystemSubtractionRadioGroup;

  }

  /**
   * 訪問看護体制減算コンテナを取得します。
   * @return 訪問看護体制減算コンテナ
   */
  protected ACLabelContainer getNursingSystemSubtractionRadioGroupContainer(){
    if(nursingSystemSubtractionRadioGroupContainer==null){
      nursingSystemSubtractionRadioGroupContainer = new ACLabelContainer();
      nursingSystemSubtractionRadioGroupContainer.setFollowChildEnabled(true);
      nursingSystemSubtractionRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      nursingSystemSubtractionRadioGroupContainer.add(getNursingSystemSubtractionRadioGroup(), null);
    }
    return nursingSystemSubtractionRadioGroupContainer;
  }

  /**
   * 訪問看護体制減算モデルを取得します。
   * @return 訪問看護体制減算モデル
   */
  protected ACListModelAdapter getNursingSystemSubtractionRadioGroupModel(){
    if(nursingSystemSubtractionRadioGroupModel==null){
      nursingSystemSubtractionRadioGroupModel = new ACListModelAdapter();
      addNursingSystemSubtractionRadioGroupModel();
    }
    return nursingSystemSubtractionRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getNursingSystemSubtractionRadioItem1(){
    if(nursingSystemSubtractionRadioItem1==null){

      nursingSystemSubtractionRadioItem1 = new ACRadioButtonItem();

      nursingSystemSubtractionRadioItem1.setText("なし");

      nursingSystemSubtractionRadioItem1.setGroup(getNursingSystemSubtractionRadioGroup());

      nursingSystemSubtractionRadioItem1.setConstraints(VRLayout.FLOW);

      addNursingSystemSubtractionRadioItem1();
    }
    return nursingSystemSubtractionRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getNursingSystemSubtractionRadioItem2(){
    if(nursingSystemSubtractionRadioItem2==null){

      nursingSystemSubtractionRadioItem2 = new ACRadioButtonItem();

      nursingSystemSubtractionRadioItem2.setText("あり");

      nursingSystemSubtractionRadioItem2.setGroup(getNursingSystemSubtractionRadioGroup());

      nursingSystemSubtractionRadioItem2.setConstraints(VRLayout.FLOW);

      addNursingSystemSubtractionRadioItem2();
    }
    return nursingSystemSubtractionRadioItem2;

  }

  /**
   * 緊急時訪問看護加算を取得します。
   * @return 緊急時訪問看護加算
   */
  public ACValueArrayRadioButtonGroup getEmergencyRadioGroup(){
    if(emergencyRadioGroup==null){

      emergencyRadioGroup = new ACValueArrayRadioButtonGroup();

      getEmergencyRadioGroupContainer().setText("緊急時訪問看護加算");

      emergencyRadioGroup.setBindPath("1770105");

      emergencyRadioGroup.setVisible(true);

      emergencyRadioGroup.setEnabled(true);

      emergencyRadioGroup.setNoSelectIndex(0);

      emergencyRadioGroup.setUseClearButton(false);

      emergencyRadioGroup.setModel(getEmergencyRadioGroupModel());

      emergencyRadioGroup.setValues(new int[]{1,2});

      addEmergencyRadioGroup();
    }
    return emergencyRadioGroup;

  }

  /**
   * 緊急時訪問看護加算コンテナを取得します。
   * @return 緊急時訪問看護加算コンテナ
   */
  protected ACLabelContainer getEmergencyRadioGroupContainer(){
    if(emergencyRadioGroupContainer==null){
      emergencyRadioGroupContainer = new ACLabelContainer();
      emergencyRadioGroupContainer.setFollowChildEnabled(true);
      emergencyRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      emergencyRadioGroupContainer.add(getEmergencyRadioGroup(), null);
    }
    return emergencyRadioGroupContainer;
  }

  /**
   * 緊急時訪問看護加算モデルを取得します。
   * @return 緊急時訪問看護加算モデル
   */
  protected ACListModelAdapter getEmergencyRadioGroupModel(){
    if(emergencyRadioGroupModel==null){
      emergencyRadioGroupModel = new ACListModelAdapter();
      addEmergencyRadioGroupModel();
    }
    return emergencyRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getEmergencyRadioItem1(){
    if(emergencyRadioItem1==null){

      emergencyRadioItem1 = new ACRadioButtonItem();

      emergencyRadioItem1.setText("なし");

      emergencyRadioItem1.setGroup(getEmergencyRadioGroup());

      emergencyRadioItem1.setConstraints(VRLayout.FLOW);

      addEmergencyRadioItem1();
    }
    return emergencyRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getEmergencyRadioItem2(){
    if(emergencyRadioItem2==null){

      emergencyRadioItem2 = new ACRadioButtonItem();

      emergencyRadioItem2.setText("あり");

      emergencyRadioItem2.setGroup(getEmergencyRadioGroup());

      emergencyRadioItem2.setConstraints(VRLayout.FLOW);

      addEmergencyRadioItem2();
    }
    return emergencyRadioItem2;

  }

  /**
   * 特別管理体制を取得します。
   * @return 特別管理体制
   */
  public ACValueArrayRadioButtonGroup getSpecialManagementSystemRadioGroup(){
    if(specialManagementSystemRadioGroup==null){

      specialManagementSystemRadioGroup = new ACValueArrayRadioButtonGroup();

      getSpecialManagementSystemRadioGroupContainer().setText("特別管理体制");

      specialManagementSystemRadioGroup.setBindPath("1770102");

      specialManagementSystemRadioGroup.setVisible(true);

      specialManagementSystemRadioGroup.setEnabled(true);

      specialManagementSystemRadioGroup.setNoSelectIndex(0);

      specialManagementSystemRadioGroup.setUseClearButton(false);

      specialManagementSystemRadioGroup.setModel(getSpecialManagementSystemRadioGroupModel());

      specialManagementSystemRadioGroup.setValues(new int[]{1,2});

      addSpecialManagementSystemRadioGroup();
    }
    return specialManagementSystemRadioGroup;

  }

  /**
   * 特別管理体制コンテナを取得します。
   * @return 特別管理体制コンテナ
   */
  protected ACLabelContainer getSpecialManagementSystemRadioGroupContainer(){
    if(specialManagementSystemRadioGroupContainer==null){
      specialManagementSystemRadioGroupContainer = new ACLabelContainer();
      specialManagementSystemRadioGroupContainer.setFollowChildEnabled(true);
      specialManagementSystemRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      specialManagementSystemRadioGroupContainer.add(getSpecialManagementSystemRadioGroup(), null);
    }
    return specialManagementSystemRadioGroupContainer;
  }

  /**
   * 特別管理体制モデルを取得します。
   * @return 特別管理体制モデル
   */
  protected ACListModelAdapter getSpecialManagementSystemRadioGroupModel(){
    if(specialManagementSystemRadioGroupModel==null){
      specialManagementSystemRadioGroupModel = new ACListModelAdapter();
      addSpecialManagementSystemRadioGroupModel();
    }
    return specialManagementSystemRadioGroupModel;
  }

  /**
   * 対応不可を取得します。
   * @return 対応不可
   */
  public ACRadioButtonItem getSpecialManagementSystemRadioItem1(){
    if(specialManagementSystemRadioItem1==null){

      specialManagementSystemRadioItem1 = new ACRadioButtonItem();

      specialManagementSystemRadioItem1.setText("対応不可");

      specialManagementSystemRadioItem1.setGroup(getSpecialManagementSystemRadioGroup());

      specialManagementSystemRadioItem1.setConstraints(VRLayout.FLOW);

      addSpecialManagementSystemRadioItem1();
    }
    return specialManagementSystemRadioItem1;

  }

  /**
   * 対応可を取得します。
   * @return 対応可
   */
  public ACRadioButtonItem getSpecialManagementSystemRadioItem2(){
    if(specialManagementSystemRadioItem2==null){

      specialManagementSystemRadioItem2 = new ACRadioButtonItem();

      specialManagementSystemRadioItem2.setText("対応可");

      specialManagementSystemRadioItem2.setGroup(getSpecialManagementSystemRadioGroup());

      specialManagementSystemRadioItem2.setConstraints(VRLayout.FLOW);

      addSpecialManagementSystemRadioItem2();
    }
    return specialManagementSystemRadioItem2;

  }

  /**
   * ターミナルケア体制を取得します。
   * @return ターミナルケア体制
   */
  public ACValueArrayRadioButtonGroup getTerminalCareRadioGroup(){
    if(terminalCareRadioGroup==null){

      terminalCareRadioGroup = new ACValueArrayRadioButtonGroup();

      getTerminalCareRadioGroupContainer().setText("ターミナルケア体制");

      terminalCareRadioGroup.setBindPath("1770103");

      terminalCareRadioGroup.setVisible(true);

      terminalCareRadioGroup.setEnabled(true);

      terminalCareRadioGroup.setNoSelectIndex(0);

      terminalCareRadioGroup.setUseClearButton(false);

      terminalCareRadioGroup.setModel(getTerminalCareRadioGroupModel());

      terminalCareRadioGroup.setValues(new int[]{1,2});

      addTerminalCareRadioGroup();
    }
    return terminalCareRadioGroup;

  }

  /**
   * ターミナルケア体制コンテナを取得します。
   * @return ターミナルケア体制コンテナ
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
   * ターミナルケア体制モデルを取得します。
   * @return ターミナルケア体制モデル
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
   * 訪問看護体制強化加算を取得します。
   * @return 訪問看護体制強化加算
   */
  public ACValueArrayRadioButtonGroup getNursingStrengthenAddRadioGroup(){
    if(nursingStrengthenAddRadioGroup==null){

      nursingStrengthenAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getNursingStrengthenAddRadioGroupContainer().setText("訪問看護体制強化加算");

      nursingStrengthenAddRadioGroup.setBindPath("1770107");

      nursingStrengthenAddRadioGroup.setVisible(true);

      nursingStrengthenAddRadioGroup.setEnabled(true);

      nursingStrengthenAddRadioGroup.setNoSelectIndex(0);

      nursingStrengthenAddRadioGroup.setUseClearButton(false);

      nursingStrengthenAddRadioGroup.setModel(getNursingStrengthenAddRadioGroupModel());

      nursingStrengthenAddRadioGroup.setValues(new int[]{1,2});

      addNursingStrengthenAddRadioGroup();
    }
    return nursingStrengthenAddRadioGroup;

  }

  /**
   * 訪問看護体制強化加算コンテナを取得します。
   * @return 訪問看護体制強化加算コンテナ
   */
  protected ACLabelContainer getNursingStrengthenAddRadioGroupContainer(){
    if(nursingStrengthenAddRadioGroupContainer==null){
      nursingStrengthenAddRadioGroupContainer = new ACLabelContainer();
      nursingStrengthenAddRadioGroupContainer.setFollowChildEnabled(true);
      nursingStrengthenAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      nursingStrengthenAddRadioGroupContainer.add(getNursingStrengthenAddRadioGroup(), null);
    }
    return nursingStrengthenAddRadioGroupContainer;
  }

  /**
   * 訪問看護体制強化加算モデルを取得します。
   * @return 訪問看護体制強化加算モデル
   */
  protected ACListModelAdapter getNursingStrengthenAddRadioGroupModel(){
    if(nursingStrengthenAddRadioGroupModel==null){
      nursingStrengthenAddRadioGroupModel = new ACListModelAdapter();
      addNursingStrengthenAddRadioGroupModel();
    }
    return nursingStrengthenAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getNursingStrengthenAddRadioItem1(){
    if(nursingStrengthenAddRadioItem1==null){

      nursingStrengthenAddRadioItem1 = new ACRadioButtonItem();

      nursingStrengthenAddRadioItem1.setText("なし");

      nursingStrengthenAddRadioItem1.setGroup(getNursingStrengthenAddRadioGroup());

      nursingStrengthenAddRadioItem1.setConstraints(VRLayout.FLOW);

      addNursingStrengthenAddRadioItem1();
    }
    return nursingStrengthenAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getNursingStrengthenAddRadioItem2(){
    if(nursingStrengthenAddRadioItem2==null){

      nursingStrengthenAddRadioItem2 = new ACRadioButtonItem();

      nursingStrengthenAddRadioItem2.setText("あり");

      nursingStrengthenAddRadioItem2.setGroup(getNursingStrengthenAddRadioGroup());

      nursingStrengthenAddRadioItem2.setConstraints(VRLayout.FLOW);

      addNursingStrengthenAddRadioItem2();
    }
    return nursingStrengthenAddRadioItem2;

  }

  /**
   * 総合マネジメント体制強化加算を取得します。
   * @return 総合マネジメント体制強化加算
   */
  public ACValueArrayRadioButtonGroup getComprehensiveManagementSystemRadioGroup(){
    if(comprehensiveManagementSystemRadioGroup==null){

      comprehensiveManagementSystemRadioGroup = new ACValueArrayRadioButtonGroup();

      getComprehensiveManagementSystemRadioGroupContainer().setText("総合マネジメント体制強化加算");

      comprehensiveManagementSystemRadioGroup.setBindPath("1770108");

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
   * サービス提供体制強化加算を取得します。
   * @return サービス提供体制強化加算
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("サービス提供体制強化加算");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1770104");

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

      serviceAddProvisionStructuralRadioItem3.setConstraints(VRLayout.FLOW);

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

      staffUpgradeRadioGroup.setValues(new int[]{1,5,2,3,4});

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

      staffUpgradeRadioItem4.setConstraints(VRLayout.FLOW);

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
   * 旧法項目を取得します。
   * @return 旧法項目
   */
  public ACPanel getOldLowElementArea(){
    if(oldLowElementArea==null){

      oldLowElementArea = new ACPanel();

      addOldLowElementArea();
    }
    return oldLowElementArea;

  }

  /**
   * コンストラクタです。
   */
  public QO004_17711_201504Design() {

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

    mainGroup.add(getStaffLackRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getNursingSystemSubtractionRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getEmergencyRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getSpecialManagementSystemRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getTerminalCareRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getNursingStrengthenAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getComprehensiveManagementSystemRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getStaffUpgradeRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getReduceRateContainer(), VRLayout.FLOW_INSETLINE);

    mainGroup.add(getShahukuReduce(), VRLayout.FLOW_RETURN);

    mainGroup.add(getOldLowElementArea(), VRLayout.FLOW_RETURN);

  }

  /**
   * 職員の欠員による減算の状況に内部項目を追加します。
   */
  protected void addStaffLackRadioGroup(){

  }

  /**
   * 職員の欠員による減算の状況モデルに内部項目を追加します。
   */
  protected void addStaffLackRadioGroupModel(){

    getStaffLackRadioItem1().setButtonIndex(1);

    getStaffLackRadioGroupModel().add(getStaffLackRadioItem1());

    getStaffLackRadioItem2().setButtonIndex(2);

    getStaffLackRadioGroupModel().add(getStaffLackRadioItem2());

    getStaffLackRadioItem3().setButtonIndex(3);

    getStaffLackRadioGroupModel().add(getStaffLackRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addStaffLackRadioItem1(){

  }

  /**
   * 看護職員に内部項目を追加します。
   */
  protected void addStaffLackRadioItem2(){

  }

  /**
   * 介護職員に内部項目を追加します。
   */
  protected void addStaffLackRadioItem3(){

  }

  /**
   * 訪問看護体制減算に内部項目を追加します。
   */
  protected void addNursingSystemSubtractionRadioGroup(){

  }

  /**
   * 訪問看護体制減算モデルに内部項目を追加します。
   */
  protected void addNursingSystemSubtractionRadioGroupModel(){

    getNursingSystemSubtractionRadioItem1().setButtonIndex(1);

    getNursingSystemSubtractionRadioGroupModel().add(getNursingSystemSubtractionRadioItem1());

    getNursingSystemSubtractionRadioItem2().setButtonIndex(2);

    getNursingSystemSubtractionRadioGroupModel().add(getNursingSystemSubtractionRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addNursingSystemSubtractionRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addNursingSystemSubtractionRadioItem2(){

  }

  /**
   * 緊急時訪問看護加算に内部項目を追加します。
   */
  protected void addEmergencyRadioGroup(){

  }

  /**
   * 緊急時訪問看護加算モデルに内部項目を追加します。
   */
  protected void addEmergencyRadioGroupModel(){

    getEmergencyRadioItem1().setButtonIndex(1);

    getEmergencyRadioGroupModel().add(getEmergencyRadioItem1());

    getEmergencyRadioItem2().setButtonIndex(2);

    getEmergencyRadioGroupModel().add(getEmergencyRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addEmergencyRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addEmergencyRadioItem2(){

  }

  /**
   * 特別管理体制に内部項目を追加します。
   */
  protected void addSpecialManagementSystemRadioGroup(){

  }

  /**
   * 特別管理体制モデルに内部項目を追加します。
   */
  protected void addSpecialManagementSystemRadioGroupModel(){

    getSpecialManagementSystemRadioItem1().setButtonIndex(1);

    getSpecialManagementSystemRadioGroupModel().add(getSpecialManagementSystemRadioItem1());

    getSpecialManagementSystemRadioItem2().setButtonIndex(2);

    getSpecialManagementSystemRadioGroupModel().add(getSpecialManagementSystemRadioItem2());

  }

  /**
   * 対応不可に内部項目を追加します。
   */
  protected void addSpecialManagementSystemRadioItem1(){

  }

  /**
   * 対応可に内部項目を追加します。
   */
  protected void addSpecialManagementSystemRadioItem2(){

  }

  /**
   * ターミナルケア体制に内部項目を追加します。
   */
  protected void addTerminalCareRadioGroup(){

  }

  /**
   * ターミナルケア体制モデルに内部項目を追加します。
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
   * 訪問看護体制強化加算に内部項目を追加します。
   */
  protected void addNursingStrengthenAddRadioGroup(){

  }

  /**
   * 訪問看護体制強化加算モデルに内部項目を追加します。
   */
  protected void addNursingStrengthenAddRadioGroupModel(){

    getNursingStrengthenAddRadioItem1().setButtonIndex(1);

    getNursingStrengthenAddRadioGroupModel().add(getNursingStrengthenAddRadioItem1());

    getNursingStrengthenAddRadioItem2().setButtonIndex(2);

    getNursingStrengthenAddRadioGroupModel().add(getNursingStrengthenAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addNursingStrengthenAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addNursingStrengthenAddRadioItem2(){

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

    getStaffUpgradeRadioItem2().setButtonIndex(5);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem2());

    getStaffUpgradeRadioItem3().setButtonIndex(2);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem3());

    getStaffUpgradeRadioItem4().setButtonIndex(3);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem4());

    getStaffUpgradeRadioItem5().setButtonIndex(4);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem5());

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
   * 旧法項目に内部項目を追加します。
   */
  protected void addOldLowElementArea(){

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
      ACFrame.debugStart(new ACAffairInfo(QO004_17711_201504Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004_17711_201504Design getThis() {
    return this;
  }
}
