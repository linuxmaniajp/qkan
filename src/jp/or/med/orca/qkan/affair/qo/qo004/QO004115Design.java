
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
 * 作成日: 2009/03/11  日本コンピューター株式会社 松本　幸一 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業者登録 (004)
 * プログラム 特定施設入居者生活介護 (QO004115)
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
 * 特定施設入居者生活介護画面項目デザイン(QO004115) 
 */
public class QO004115Design extends QO004ProviderPanel {
  //GUIコンポーネント

  private ACGroupBox mainGroup;

  private ACPanel calculationDetails;

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

  private ACClearableRadioButtonGroup staffAssignmentDivision;

  private ACLabelContainer staffAssignmentDivisionContainer;

  private ACListModelAdapter staffAssignmentDivisionModel;

  private ACRadioButtonItem staffAssignmentDivisionItem1;

  private ACRadioButtonItem staffAssignmentDivisionItem2;

  private ACClearableRadioButtonGroup staffLack;

  private ACLabelContainer staffLackContainer;

  private ACListModelAdapter staffLackModel;

  private ACRadioButtonItem staffLackItem1;

  private ACRadioButtonItem staffLackItem2;

  private ACRadioButtonItem staffLackItem3;

  private ACClearableRadioButtonGroup functionTrainingGuidanceSystem;

  private ACLabelContainer functionTrainingGuidanceSystemContainer;

  private ACListModelAdapter functionTrainingGuidanceSystemModel;

  private ACRadioButtonItem functionTrainingGuidanceSystemItem1;

  private ACRadioButtonItem functionTrainingGuidanceSystemItem2;

  private ACClearableRadioButtonGroup nightNursingSystemAdd;

  private ACLabelContainer nightNursingSystemAddContainer;

  private ACListModelAdapter nightNursingSystemAddModel;

  private ACRadioButtonItem nightNursingSystemAddItem1;

  private ACRadioButtonItem nightNursingSystemAddItem2;

  private ACLabelContainer reduceRateContainer;

  private ACTextField reduceRate;

  private ACLabel percentSign;

  private ACPanel oldLowElementArea;

  private ACGroupBox oldLowH2103Group;

  private ACClearableRadioButtonGroup facilitiesDivision_H2103;

  private ACLabelContainer facilitiesDivision_H2103Container;

  private ACListModelAdapter facilitiesDivision_H2103Model;

  private ACRadioButtonItem facilitiesDivisionItem1_H2103;

  private ACRadioButtonItem facilitiesDivisionItem2_H2103;

  private ACRadioButtonItem facilitiesDivisionItem3_H2103;

  private ACRadioButtonItem facilitiesDivisionItem4_H2103;

  //getter

  /**
   * 事業グループを取得します。
   * @return 事業グループ
   */
  public ACGroupBox getMainGroup(){
    if(mainGroup==null){

      mainGroup = new ACGroupBox();

      mainGroup.setText("特定施設入居者生活介護");

      mainGroup.setFollowChildEnabled(true);

      mainGroup.setHgrid(200);

      addMainGroup();
    }
    return mainGroup;

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
   * 施設等の区分ラジオグループを取得します。
   * @return 施設等の区分ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getFacilitiesDivision(){
    if(facilitiesDivision==null){

      facilitiesDivision = new ACValueArrayRadioButtonGroup();

      getFacilitiesDivisionContainer().setText("施設等の区分");

      facilitiesDivision.setBindPath("1330108");

      facilitiesDivision.setNoSelectIndex(0);

      facilitiesDivision.setUseClearButton(false);

      facilitiesDivision.setModel(getFacilitiesDivisionModel());

      facilitiesDivision.setValues(new int[]{1,2,3,4,5,6,7,8});

      addFacilitiesDivision();
    }
    return facilitiesDivision;

  }

  /**
   * 施設等の区分ラジオグループコンテナを取得します。
   * @return 施設等の区分ラジオグループコンテナ
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
   * 施設等の区分ラジオグループモデルを取得します。
   * @return 施設等の区分ラジオグループモデル
   */
  protected ACListModelAdapter getFacilitiesDivisionModel(){
    if(facilitiesDivisionModel==null){
      facilitiesDivisionModel = new ACListModelAdapter();
      addFacilitiesDivisionModel();
    }
    return facilitiesDivisionModel;
  }

  /**
   * 有料老人ホーム（介護専用型）を取得します。
   * @return 有料老人ホーム（介護専用型）
   */
  public ACRadioButtonItem getFacilitiesDivisionItem1(){
    if(facilitiesDivisionItem1==null){

      facilitiesDivisionItem1 = new ACRadioButtonItem();

      facilitiesDivisionItem1.setText("有料老人ホーム（介護専用型）");

      facilitiesDivisionItem1.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem1.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem1();
    }
    return facilitiesDivisionItem1;

  }

  /**
   * 軽費老人ホーム（介護専用型）を取得します。
   * @return 軽費老人ホーム（介護専用型）
   */
  public ACRadioButtonItem getFacilitiesDivisionItem2(){
    if(facilitiesDivisionItem2==null){

      facilitiesDivisionItem2 = new ACRadioButtonItem();

      facilitiesDivisionItem2.setText("軽費老人ホーム（介護専用型）");

      facilitiesDivisionItem2.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem2.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem2();
    }
    return facilitiesDivisionItem2;

  }

  /**
   * 養護老人ホーム（介護専用型）を取得します。
   * @return 養護老人ホーム（介護専用型）
   */
  public ACRadioButtonItem getFacilitiesDivisionItem3(){
    if(facilitiesDivisionItem3==null){

      facilitiesDivisionItem3 = new ACRadioButtonItem();

      facilitiesDivisionItem3.setText("養護老人ホーム（介護専用型）");

      facilitiesDivisionItem3.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem3.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem3();
    }
    return facilitiesDivisionItem3;

  }

  /**
   * 高齢者専用賃貸住宅（介護専用型）を取得します。
   * @return 高齢者専用賃貸住宅（介護専用型）
   */
  public ACRadioButtonItem getFacilitiesDivisionItem4(){
    if(facilitiesDivisionItem4==null){

      facilitiesDivisionItem4 = new ACRadioButtonItem();

      facilitiesDivisionItem4.setText("高齢者専用賃貸住宅（介護専用型）");

      facilitiesDivisionItem4.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem4.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem4();
    }
    return facilitiesDivisionItem4;

  }

  /**
   * 有料老人ホーム（混合型）を取得します。
   * @return 有料老人ホーム（混合型）
   */
  public ACRadioButtonItem getFacilitiesDivisionItem5(){
    if(facilitiesDivisionItem5==null){

      facilitiesDivisionItem5 = new ACRadioButtonItem();

      facilitiesDivisionItem5.setText("有料老人ホーム（混合型）");

      facilitiesDivisionItem5.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem5.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem5();
    }
    return facilitiesDivisionItem5;

  }

  /**
   * 軽費老人ホーム（混合型）を取得します。
   * @return 軽費老人ホーム（混合型）
   */
  public ACRadioButtonItem getFacilitiesDivisionItem6(){
    if(facilitiesDivisionItem6==null){

      facilitiesDivisionItem6 = new ACRadioButtonItem();

      facilitiesDivisionItem6.setText("軽費老人ホーム（混合型）");

      facilitiesDivisionItem6.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem6.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem6();
    }
    return facilitiesDivisionItem6;

  }

  /**
   * 養護老人ホーム（混合型）を取得します。
   * @return 養護老人ホーム（混合型）
   */
  public ACRadioButtonItem getFacilitiesDivisionItem7(){
    if(facilitiesDivisionItem7==null){

      facilitiesDivisionItem7 = new ACRadioButtonItem();

      facilitiesDivisionItem7.setText("養護老人ホーム（混合型）");

      facilitiesDivisionItem7.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem7.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem7();
    }
    return facilitiesDivisionItem7;

  }

  /**
   * 高齢者専用賃貸住宅（混合型）を取得します。
   * @return 高齢者専用賃貸住宅（混合型）
   */
  public ACRadioButtonItem getFacilitiesDivisionItem8(){
    if(facilitiesDivisionItem8==null){

      facilitiesDivisionItem8 = new ACRadioButtonItem();

      facilitiesDivisionItem8.setText("高齢者専用賃貸住宅（混合型）");

      facilitiesDivisionItem8.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem8.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem8();
    }
    return facilitiesDivisionItem8;

  }

  /**
   * 人員配置区分ラジオグループを取得します。
   * @return 人員配置区分ラジオグループ
   */
  public ACClearableRadioButtonGroup getStaffAssignmentDivision(){
    if(staffAssignmentDivision==null){

      staffAssignmentDivision = new ACClearableRadioButtonGroup();

      getStaffAssignmentDivisionContainer().setText("人員配置区分");

      staffAssignmentDivision.setBindPath("1330103");

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
   * 一般型を取得します。
   * @return 一般型
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem1(){
    if(staffAssignmentDivisionItem1==null){

      staffAssignmentDivisionItem1 = new ACRadioButtonItem();

      staffAssignmentDivisionItem1.setText("一般型");

      staffAssignmentDivisionItem1.setGroup(getStaffAssignmentDivision());

      staffAssignmentDivisionItem1.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivisionItem1();
    }
    return staffAssignmentDivisionItem1;

  }

  /**
   * 外部サービス利用型を取得します。
   * @return 外部サービス利用型
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem2(){
    if(staffAssignmentDivisionItem2==null){

      staffAssignmentDivisionItem2 = new ACRadioButtonItem();

      staffAssignmentDivisionItem2.setText("外部サービス利用型");

      staffAssignmentDivisionItem2.setGroup(getStaffAssignmentDivision());

      staffAssignmentDivisionItem2.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivisionItem2();
    }
    return staffAssignmentDivisionItem2;

  }

  /**
   * 職員の欠員による減算の状況ラジオグループを取得します。
   * @return 職員の欠員による減算の状況ラジオグループ
   */
  public ACClearableRadioButtonGroup getStaffLack(){
    if(staffLack==null){

      staffLack = new ACClearableRadioButtonGroup();

      getStaffLackContainer().setText("職員の欠員による減算の状況");

      staffLack.setBindPath("1330102");

      staffLack.setUseClearButton(false);

      staffLack.setModel(getStaffLackModel());

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
   * 個別機能訓練体制ラジオグループを取得します。
   * @return 個別機能訓練体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getFunctionTrainingGuidanceSystem(){
    if(functionTrainingGuidanceSystem==null){

      functionTrainingGuidanceSystem = new ACClearableRadioButtonGroup();

      getFunctionTrainingGuidanceSystemContainer().setText("個別機能訓練体制");

      functionTrainingGuidanceSystem.setBindPath("1330101");

      functionTrainingGuidanceSystem.setUseClearButton(false);

      functionTrainingGuidanceSystem.setModel(getFunctionTrainingGuidanceSystemModel());

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
   * 夜間看護体制を取得します。
   * @return 夜間看護体制
   */
  public ACClearableRadioButtonGroup getNightNursingSystemAdd(){
    if(nightNursingSystemAdd==null){

      nightNursingSystemAdd = new ACClearableRadioButtonGroup();

      getNightNursingSystemAddContainer().setText("夜間看護体制");

      nightNursingSystemAdd.setBindPath("1330104");

      nightNursingSystemAdd.setUseClearButton(false);

      nightNursingSystemAdd.setModel(getNightNursingSystemAddModel());

      addNightNursingSystemAdd();
    }
    return nightNursingSystemAdd;

  }

  /**
   * 夜間看護体制コンテナを取得します。
   * @return 夜間看護体制コンテナ
   */
  protected ACLabelContainer getNightNursingSystemAddContainer(){
    if(nightNursingSystemAddContainer==null){
      nightNursingSystemAddContainer = new ACLabelContainer();
      nightNursingSystemAddContainer.setFollowChildEnabled(true);
      nightNursingSystemAddContainer.setVAlignment(VRLayout.CENTER);
      nightNursingSystemAddContainer.add(getNightNursingSystemAdd(), null);
    }
    return nightNursingSystemAddContainer;
  }

  /**
   * 夜間看護体制モデルを取得します。
   * @return 夜間看護体制モデル
   */
  protected ACListModelAdapter getNightNursingSystemAddModel(){
    if(nightNursingSystemAddModel==null){
      nightNursingSystemAddModel = new ACListModelAdapter();
      addNightNursingSystemAddModel();
    }
    return nightNursingSystemAddModel;
  }

  /**
   * 対応不可を取得します。
   * @return 対応不可
   */
  public ACRadioButtonItem getNightNursingSystemAddItem1(){
    if(nightNursingSystemAddItem1==null){

      nightNursingSystemAddItem1 = new ACRadioButtonItem();

      nightNursingSystemAddItem1.setText("対応不可");

      nightNursingSystemAddItem1.setGroup(getNightNursingSystemAdd());

      nightNursingSystemAddItem1.setConstraints(VRLayout.FLOW);

      addNightNursingSystemAddItem1();
    }
    return nightNursingSystemAddItem1;

  }

  /**
   * 対応可を取得します。
   * @return 対応可
   */
  public ACRadioButtonItem getNightNursingSystemAddItem2(){
    if(nightNursingSystemAddItem2==null){

      nightNursingSystemAddItem2 = new ACRadioButtonItem();

      nightNursingSystemAddItem2.setText("対応可");

      nightNursingSystemAddItem2.setGroup(getNightNursingSystemAdd());

      nightNursingSystemAddItem2.setConstraints(VRLayout.FLOW);

      addNightNursingSystemAddItem2();
    }
    return nightNursingSystemAddItem2;

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
   * 施設等の区分ラジオグループを取得します。
   * @return 施設等の区分ラジオグループ
   */
  public ACClearableRadioButtonGroup getFacilitiesDivision_H2103(){
    if(facilitiesDivision_H2103==null){

      facilitiesDivision_H2103 = new ACClearableRadioButtonGroup();

      getFacilitiesDivision_H2103Container().setText("施設等の区分");

      facilitiesDivision_H2103.setBindPath("1330105");

      facilitiesDivision_H2103.setUseClearButton(false);

      facilitiesDivision_H2103.setModel(getFacilitiesDivision_H2103Model());

      addFacilitiesDivision_H2103();
    }
    return facilitiesDivision_H2103;

  }

  /**
   * 施設等の区分ラジオグループコンテナを取得します。
   * @return 施設等の区分ラジオグループコンテナ
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
   * 施設等の区分ラジオグループモデルを取得します。
   * @return 施設等の区分ラジオグループモデル
   */
  protected ACListModelAdapter getFacilitiesDivision_H2103Model(){
    if(facilitiesDivision_H2103Model==null){
      facilitiesDivision_H2103Model = new ACListModelAdapter();
      addFacilitiesDivision_H2103Model();
    }
    return facilitiesDivision_H2103Model;
  }

  /**
   * 有料老人ホームを取得します。
   * @return 有料老人ホーム
   */
  public ACRadioButtonItem getFacilitiesDivisionItem1_H2103(){
    if(facilitiesDivisionItem1_H2103==null){

      facilitiesDivisionItem1_H2103 = new ACRadioButtonItem();

      facilitiesDivisionItem1_H2103.setText("有料老人ホーム");

      facilitiesDivisionItem1_H2103.setGroup(getFacilitiesDivision_H2103());

      facilitiesDivisionItem1_H2103.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem1_H2103();
    }
    return facilitiesDivisionItem1_H2103;

  }

  /**
   * 軽費老人ホームを取得します。
   * @return 軽費老人ホーム
   */
  public ACRadioButtonItem getFacilitiesDivisionItem2_H2103(){
    if(facilitiesDivisionItem2_H2103==null){

      facilitiesDivisionItem2_H2103 = new ACRadioButtonItem();

      facilitiesDivisionItem2_H2103.setText("軽費老人ホーム");

      facilitiesDivisionItem2_H2103.setGroup(getFacilitiesDivision_H2103());

      facilitiesDivisionItem2_H2103.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem2_H2103();
    }
    return facilitiesDivisionItem2_H2103;

  }

  /**
   * 養護老人ホームを取得します。
   * @return 養護老人ホーム
   */
  public ACRadioButtonItem getFacilitiesDivisionItem3_H2103(){
    if(facilitiesDivisionItem3_H2103==null){

      facilitiesDivisionItem3_H2103 = new ACRadioButtonItem();

      facilitiesDivisionItem3_H2103.setText("養護老人ホーム");

      facilitiesDivisionItem3_H2103.setGroup(getFacilitiesDivision_H2103());

      facilitiesDivisionItem3_H2103.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem3_H2103();
    }
    return facilitiesDivisionItem3_H2103;

  }

  /**
   * 高齢者専用賃貸住宅を取得します。
   * @return 高齢者専用賃貸住宅
   */
  public ACRadioButtonItem getFacilitiesDivisionItem4_H2103(){
    if(facilitiesDivisionItem4_H2103==null){

      facilitiesDivisionItem4_H2103 = new ACRadioButtonItem();

      facilitiesDivisionItem4_H2103.setText("高齢者専用賃貸住宅");

      facilitiesDivisionItem4_H2103.setGroup(getFacilitiesDivision_H2103());

      facilitiesDivisionItem4_H2103.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem4_H2103();
    }
    return facilitiesDivisionItem4_H2103;

  }

  /**
   * コンストラクタです。
   */
  public QO004115Design() {

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

    mainGroup.add(getCalculationDetails(), VRLayout.NORTH);

    mainGroup.add(getOldLowElementArea(), VRLayout.FLOW_RETURN);

  }

  /**
   * 算定項目領域に内部項目を追加します。
   */
  protected void addCalculationDetails(){

    calculationDetails.add(getFacilitiesDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getStaffAssignmentDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getStaffLackContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getFunctionTrainingGuidanceSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getNightNursingSystemAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getReduceRateContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 施設等の区分ラジオグループに内部項目を追加します。
   */
  protected void addFacilitiesDivision(){

  }

  /**
   * 施設等の区分ラジオグループモデルに内部項目を追加します。
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
   * 有料老人ホーム（介護専用型）に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem1(){

  }

  /**
   * 軽費老人ホーム（介護専用型）に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem2(){

  }

  /**
   * 養護老人ホーム（介護専用型）に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem3(){

  }

  /**
   * 高齢者専用賃貸住宅（介護専用型）に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem4(){

  }

  /**
   * 有料老人ホーム（混合型）に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem5(){

  }

  /**
   * 軽費老人ホーム（混合型）に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem6(){

  }

  /**
   * 養護老人ホーム（混合型）に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem7(){

  }

  /**
   * 高齢者専用賃貸住宅（混合型）に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem8(){

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

  }

  /**
   * 一般型に内部項目を追加します。
   */
  protected void addStaffAssignmentDivisionItem1(){

  }

  /**
   * 外部サービス利用型に内部項目を追加します。
   */
  protected void addStaffAssignmentDivisionItem2(){

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
   * 夜間看護体制に内部項目を追加します。
   */
  protected void addNightNursingSystemAdd(){

  }

  /**
   * 夜間看護体制モデルに内部項目を追加します。
   */
  protected void addNightNursingSystemAddModel(){

    getNightNursingSystemAddItem1().setButtonIndex(1);

    getNightNursingSystemAddModel().add(getNightNursingSystemAddItem1());

    getNightNursingSystemAddItem2().setButtonIndex(2);

    getNightNursingSystemAddModel().add(getNightNursingSystemAddItem2());

  }

  /**
   * 対応不可に内部項目を追加します。
   */
  protected void addNightNursingSystemAddItem1(){

  }

  /**
   * 対応可に内部項目を追加します。
   */
  protected void addNightNursingSystemAddItem2(){

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

  }

  /**
   * 施設等の区分ラジオグループに内部項目を追加します。
   */
  protected void addFacilitiesDivision_H2103(){

  }

  /**
   * 施設等の区分ラジオグループモデルに内部項目を追加します。
   */
  protected void addFacilitiesDivision_H2103Model(){

    getFacilitiesDivisionItem1_H2103().setButtonIndex(1);

    getFacilitiesDivision_H2103Model().add(getFacilitiesDivisionItem1_H2103());

    getFacilitiesDivisionItem2_H2103().setButtonIndex(2);

    getFacilitiesDivision_H2103Model().add(getFacilitiesDivisionItem2_H2103());

    getFacilitiesDivisionItem3_H2103().setButtonIndex(3);

    getFacilitiesDivision_H2103Model().add(getFacilitiesDivisionItem3_H2103());

    getFacilitiesDivisionItem4_H2103().setButtonIndex(4);

    getFacilitiesDivision_H2103Model().add(getFacilitiesDivisionItem4_H2103());

  }

  /**
   * 有料老人ホームに内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem1_H2103(){

  }

  /**
   * 軽費老人ホームに内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem2_H2103(){

  }

  /**
   * 養護老人ホームに内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem3_H2103(){

  }

  /**
   * 高齢者専用賃貸住宅に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem4_H2103(){

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
      ACFrame.debugStart(new ACAffairInfo(QO004115Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004115Design getThis() {
    return this;
  }
}
