
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
 * 開発者: 小笠　貴志
 * 作成日: 2006/02/18  日本コンピューター株式会社 小笠　貴志 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業者登録 (004)
 * プログラム 事業者登録(短期入所生活介護) (QO004008)
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
import jp.or.med.orca.qkan.component.*;
import jp.or.med.orca.qkan.lib.*;
import jp.or.med.orca.qkan.text.*;
/**
 * 事業者登録(短期入所生活介護)画面項目デザイン(QO004008) 
 */
public class QO004008Design extends ACPanel {
  //GUIコンポーネント

  private ACGroupBox shortStayLifeGroup;

  private ACLabelContainer shortStayLifeDiscountContainer;

  private ACTextField shortStayLifeDiscountRate;

  private ACLabel shortStayPercentSign;

  private ACClearableRadioButtonGroup shortStayLifeFacilitiesDivision;

  private ACLabelContainer shortStayLifeFacilitiesDivisionContainer;

  private ACListModelAdapter shortStayLifeFacilitiesDivisionModel;

  private ACRadioButtonItem shortStayLifeSingle;

  private ACRadioButtonItem shortStayLifeDouble;

  private ACRadioButtonItem shortStayLifeSmall;

  private ACRadioButtonItem shortStayLifeDoubleSmall;

  private ACClearableRadioButtonGroup shortStayNightWorkDivision;

  private ACLabelContainer shortStayNightWorkDivisionContainer;

  private ACListModelAdapter shortStayNightWorkDivisionModel;

  private ACRadioButtonItem shortStayLifeNightWorkDivisionFill;

  private ACRadioButtonItem shortStayNightWorkDivisionNotFill;

  private ACClearableRadioButtonGroup shortStayLifeFunctionTrainingGuidanceSystem;

  private ACLabelContainer shortStayLifeFunctionTrainingGuidanceSystemContainer;

  private ACListModelAdapter shortStayLifeFunctionTrainingGuidanceSystemModel;

  private ACRadioButtonItem shortStayFunctionTrainingGuidanceSystemOff;

  private ACRadioButtonItem shortStayLifeFunctionTrainingGuidanceSystemOn;

  private ACClearableRadioButtonGroup shortStayMeetingAndSendingOffSystem;

  private ACLabelContainer shortStayMeetingAndSendingOffSystemContainer;

  private ACListModelAdapter shortStayMeetingAndSendingOffSystemModel;

  private ACRadioButtonItem shortStayLifeMeetingAndSendingOffSystemOff;

  private ACRadioButtonItem shortStayMeetingAndSendingOffSystemOn;

  private ACClearableRadioButtonGroup shortStayLifeNutritionManageRadio;

  private ACLabelContainer shortStayLifeNutritionManageRadioContainer;

  private ACListModelAdapter shortStayLifeNutritionManageRadioModel;

  private ACRadioButtonItem shortStayLifeNutritionManageRadioItem1;

  private ACRadioButtonItem shortStayLifeNutritionManageRadioItem2;

  private ACClearableRadioButtonGroup shortStayLifeRecuperatDinnerRadio;

  private ACLabelContainer shortStayLifeRecuperatDinnerRadioContainer;

  private ACListModelAdapter shortStayLifeRecuperatDinnerRadioModel;

  private ACRadioButtonItem shortStayLifeRecuperatDinnerRadioItem1;

  private ACRadioButtonItem shortStayLifeRecuperatDinnerRadioItem2;

  private ACClearableRadioButtonGroup shortStayStaffReduceRadio;

  private ACLabelContainer shortStayStaffReduceRadioContainer;

  private ACListModelAdapter shortStayStaffReduceRadioModel;

  private ACRadioButtonItem shortStayStaffNot;

  private ACRadioButtonItem shortStayStaffExcess;

  private ACRadioButtonItem shortStayStaffShortage;

  private ACLabelContainer shortStayDinnerStandardMoneyConteiner;

  private ACTextField shortStayDinnerStandardMoneyTotal;

  private ACLabel shortStayMorningDinnerStandardMoneyLabel;

  private ACTextField shortStayMorningDinnerStandardMoney;

  private ACLabel shortStayNoonDinnerStandardMoneyLabel;

  private ACTextField shortStayNoonDinnerStandardMoney;

  private ACLabel shortStayNightDinnerStandardMoneyLabel;

  private ACTextField shortStayNightDinnerStandardMoney;

  private ACLabel shortStayDinnerStandardMoneyDenomination;

  private ACLabelContainer shortStayUnitRoomStandardMoneyConteiner;

  private ACTextField shortStayUnitRoomStandardMoneyText;

  private ACLabel shortStayUnitRoomStandardMoneyLabel;

  private ACLabelContainer shortStayUnitSemiRoomStandardMoneyConteiner;

  private ACTextField shortStayUnitSemiRoomStandardMoneyText;

  private ACLabel shortStayUnitSemiRoomStandardMoneyLabel;

  private ACLabelContainer shortStayNormalRoomStandardMoneyConteiner;

  private ACTextField shortStayNormalRoomStandardMoneyText;

  private ACLabel shortStayNormalRoomStandardMoneyLabel;

  private ACLabelContainer shortStayTasyouRoomConteiner;

  private ACTextField shortStayTasyouRoomText;

  private ACLabel shortStayTasyouRoomLabel;

  //getter

  /**
   * 事業グループを取得します。
   * @return 事業グループ
   */
  public ACGroupBox getShortStayLifeGroup(){
    if(shortStayLifeGroup==null){

      shortStayLifeGroup = new ACGroupBox();

      shortStayLifeGroup.setText("短期入所生活介護");

      shortStayLifeGroup.setFollowChildEnabled(true);

      shortStayLifeGroup.setHgrid(200);

      addShortStayLifeGroup();
    }
    return shortStayLifeGroup;

  }

  /**
   * 割引率コンテナを取得します。
   * @return 割引率コンテナ
   */
  public ACLabelContainer getShortStayLifeDiscountContainer(){
    if(shortStayLifeDiscountContainer==null){

      shortStayLifeDiscountContainer = new ACLabelContainer();

      shortStayLifeDiscountContainer.setText("割引率");

      shortStayLifeDiscountContainer.setFollowChildEnabled(true);

      addShortStayLifeDiscountContainer();
    }
    return shortStayLifeDiscountContainer;

  }

  /**
   * 割引率を取得します。
   * @return 割引率
   */
  public ACTextField getShortStayLifeDiscountRate(){
    if(shortStayLifeDiscountRate==null){

      shortStayLifeDiscountRate = new ACTextField();

      shortStayLifeDiscountRate.setBindPath("REDUCT_RATE");

      shortStayLifeDiscountRate.setColumns(3);

      shortStayLifeDiscountRate.setCharType(VRCharType.ONLY_DIGIT);

      shortStayLifeDiscountRate.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayLifeDiscountRate.setIMEMode(InputSubset.LATIN);

      shortStayLifeDiscountRate.setMaxLength(3);

      addShortStayLifeDiscountRate();
    }
    return shortStayLifeDiscountRate;

  }

  /**
   * ％ラベルを取得します。
   * @return ％ラベル
   */
  public ACLabel getShortStayPercentSign(){
    if(shortStayPercentSign==null){

      shortStayPercentSign = new ACLabel();

      shortStayPercentSign.setText("％");

      addShortStayPercentSign();
    }
    return shortStayPercentSign;

  }

  /**
   * 施設区分ラジオグループを取得します。
   * @return 施設区分ラジオグループ
   */
  public ACClearableRadioButtonGroup getShortStayLifeFacilitiesDivision(){
    if(shortStayLifeFacilitiesDivision==null){

      shortStayLifeFacilitiesDivision = new ACClearableRadioButtonGroup();

      getShortStayLifeFacilitiesDivisionContainer().setText("施設区分");

      shortStayLifeFacilitiesDivision.setBindPath("1210101");

      shortStayLifeFacilitiesDivision.setModel(getShortStayLifeFacilitiesDivisionModel());

      shortStayLifeFacilitiesDivision.setUseClearButton(false);

      addShortStayLifeFacilitiesDivision();
    }
    return shortStayLifeFacilitiesDivision;

  }

  /**
   * 施設区分ラジオグループコンテナを取得します。
   * @return 施設区分ラジオグループコンテナ
   */
  protected ACLabelContainer getShortStayLifeFacilitiesDivisionContainer(){
    if(shortStayLifeFacilitiesDivisionContainer==null){
      shortStayLifeFacilitiesDivisionContainer = new ACLabelContainer();
      shortStayLifeFacilitiesDivisionContainer.setFollowChildEnabled(true);
      shortStayLifeFacilitiesDivisionContainer.add(getShortStayLifeFacilitiesDivision(), null);
    }
    return shortStayLifeFacilitiesDivisionContainer;
  }

  /**
   * 施設区分ラジオグループモデルを取得します。
   * @return 施設区分ラジオグループモデル
   */
  protected ACListModelAdapter getShortStayLifeFacilitiesDivisionModel(){
    if(shortStayLifeFacilitiesDivisionModel==null){
      shortStayLifeFacilitiesDivisionModel = new ACListModelAdapter();
      addShortStayLifeFacilitiesDivisionModel();
    }
    return shortStayLifeFacilitiesDivisionModel;
  }

  /**
   * 単独型を取得します。
   * @return 単独型
   */
  public ACRadioButtonItem getShortStayLifeSingle(){
    if(shortStayLifeSingle==null){

      shortStayLifeSingle = new ACRadioButtonItem();

      shortStayLifeSingle.setText("単独型");

      shortStayLifeSingle.setGroup(getShortStayLifeFacilitiesDivision());

      addShortStayLifeSingle();
    }
    return shortStayLifeSingle;

  }

  /**
   * 併設型を取得します。
   * @return 併設型
   */
  public ACRadioButtonItem getShortStayLifeDouble(){
    if(shortStayLifeDouble==null){

      shortStayLifeDouble = new ACRadioButtonItem();

      shortStayLifeDouble.setText("併設型");

      shortStayLifeDouble.setGroup(getShortStayLifeFacilitiesDivision());

      addShortStayLifeDouble();
    }
    return shortStayLifeDouble;

  }

  /**
   * 単独小規模型を取得します。
   * @return 単独小規模型
   */
  public ACRadioButtonItem getShortStayLifeSmall(){
    if(shortStayLifeSmall==null){

      shortStayLifeSmall = new ACRadioButtonItem();

      shortStayLifeSmall.setText("単独型ユニット型");

      shortStayLifeSmall.setGroup(getShortStayLifeFacilitiesDivision());

      addShortStayLifeSmall();
    }
    return shortStayLifeSmall;

  }

  /**
   * 併設小規模型を取得します。
   * @return 併設小規模型
   */
  public ACRadioButtonItem getShortStayLifeDoubleSmall(){
    if(shortStayLifeDoubleSmall==null){

      shortStayLifeDoubleSmall = new ACRadioButtonItem();

      shortStayLifeDoubleSmall.setText("併設型ユニット型");

      shortStayLifeDoubleSmall.setGroup(getShortStayLifeFacilitiesDivision());

      addShortStayLifeDoubleSmall();
    }
    return shortStayLifeDoubleSmall;

  }

  /**
   * 夜間勤務条件基準ラジオグループを取得します。
   * @return 夜間勤務条件基準ラジオグループ
   */
  public ACClearableRadioButtonGroup getShortStayNightWorkDivision(){
    if(shortStayNightWorkDivision==null){

      shortStayNightWorkDivision = new ACClearableRadioButtonGroup();

      getShortStayNightWorkDivisionContainer().setText("夜間勤務条件基準");

      shortStayNightWorkDivision.setBindPath("1210102");

      shortStayNightWorkDivision.setModel(getShortStayNightWorkDivisionModel());

      shortStayNightWorkDivision.setUseClearButton(false);

      addShortStayNightWorkDivision();
    }
    return shortStayNightWorkDivision;

  }

  /**
   * 夜間勤務条件基準ラジオグループコンテナを取得します。
   * @return 夜間勤務条件基準ラジオグループコンテナ
   */
  protected ACLabelContainer getShortStayNightWorkDivisionContainer(){
    if(shortStayNightWorkDivisionContainer==null){
      shortStayNightWorkDivisionContainer = new ACLabelContainer();
      shortStayNightWorkDivisionContainer.setFollowChildEnabled(true);
      shortStayNightWorkDivisionContainer.add(getShortStayNightWorkDivision(), null);
    }
    return shortStayNightWorkDivisionContainer;
  }

  /**
   * 夜間勤務条件基準ラジオグループモデルを取得します。
   * @return 夜間勤務条件基準ラジオグループモデル
   */
  protected ACListModelAdapter getShortStayNightWorkDivisionModel(){
    if(shortStayNightWorkDivisionModel==null){
      shortStayNightWorkDivisionModel = new ACListModelAdapter();
      addShortStayNightWorkDivisionModel();
    }
    return shortStayNightWorkDivisionModel;
  }

  /**
   * 基準型を取得します。
   * @return 基準型
   */
  public ACRadioButtonItem getShortStayLifeNightWorkDivisionFill(){
    if(shortStayLifeNightWorkDivisionFill==null){

      shortStayLifeNightWorkDivisionFill = new ACRadioButtonItem();

      shortStayLifeNightWorkDivisionFill.setText("基準型");

      shortStayLifeNightWorkDivisionFill.setGroup(getShortStayNightWorkDivision());

      addShortStayLifeNightWorkDivisionFill();
    }
    return shortStayLifeNightWorkDivisionFill;

  }

  /**
   * 減算型を取得します。
   * @return 減算型
   */
  public ACRadioButtonItem getShortStayNightWorkDivisionNotFill(){
    if(shortStayNightWorkDivisionNotFill==null){

      shortStayNightWorkDivisionNotFill = new ACRadioButtonItem();

      shortStayNightWorkDivisionNotFill.setText("減算型");

      shortStayNightWorkDivisionNotFill.setGroup(getShortStayNightWorkDivision());

      addShortStayNightWorkDivisionNotFill();
    }
    return shortStayNightWorkDivisionNotFill;

  }

  /**
   * 機能訓練指導体制ラジオグループを取得します。
   * @return 機能訓練指導体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getShortStayLifeFunctionTrainingGuidanceSystem(){
    if(shortStayLifeFunctionTrainingGuidanceSystem==null){

      shortStayLifeFunctionTrainingGuidanceSystem = new ACClearableRadioButtonGroup();

      getShortStayLifeFunctionTrainingGuidanceSystemContainer().setText("機能訓練指導体制");

      shortStayLifeFunctionTrainingGuidanceSystem.setBindPath("1210103");

      shortStayLifeFunctionTrainingGuidanceSystem.setModel(getShortStayLifeFunctionTrainingGuidanceSystemModel());

      shortStayLifeFunctionTrainingGuidanceSystem.setUseClearButton(false);

      addShortStayLifeFunctionTrainingGuidanceSystem();
    }
    return shortStayLifeFunctionTrainingGuidanceSystem;

  }

  /**
   * 機能訓練指導体制ラジオグループコンテナを取得します。
   * @return 機能訓練指導体制ラジオグループコンテナ
   */
  protected ACLabelContainer getShortStayLifeFunctionTrainingGuidanceSystemContainer(){
    if(shortStayLifeFunctionTrainingGuidanceSystemContainer==null){
      shortStayLifeFunctionTrainingGuidanceSystemContainer = new ACLabelContainer();
      shortStayLifeFunctionTrainingGuidanceSystemContainer.setFollowChildEnabled(true);
      shortStayLifeFunctionTrainingGuidanceSystemContainer.add(getShortStayLifeFunctionTrainingGuidanceSystem(), null);
    }
    return shortStayLifeFunctionTrainingGuidanceSystemContainer;
  }

  /**
   * 機能訓練指導体制ラジオグループモデルを取得します。
   * @return 機能訓練指導体制ラジオグループモデル
   */
  protected ACListModelAdapter getShortStayLifeFunctionTrainingGuidanceSystemModel(){
    if(shortStayLifeFunctionTrainingGuidanceSystemModel==null){
      shortStayLifeFunctionTrainingGuidanceSystemModel = new ACListModelAdapter();
      addShortStayLifeFunctionTrainingGuidanceSystemModel();
    }
    return shortStayLifeFunctionTrainingGuidanceSystemModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayFunctionTrainingGuidanceSystemOff(){
    if(shortStayFunctionTrainingGuidanceSystemOff==null){

      shortStayFunctionTrainingGuidanceSystemOff = new ACRadioButtonItem();

      shortStayFunctionTrainingGuidanceSystemOff.setText("なし");

      shortStayFunctionTrainingGuidanceSystemOff.setGroup(getShortStayLifeFunctionTrainingGuidanceSystem());

      addShortStayFunctionTrainingGuidanceSystemOff();
    }
    return shortStayFunctionTrainingGuidanceSystemOff;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayLifeFunctionTrainingGuidanceSystemOn(){
    if(shortStayLifeFunctionTrainingGuidanceSystemOn==null){

      shortStayLifeFunctionTrainingGuidanceSystemOn = new ACRadioButtonItem();

      shortStayLifeFunctionTrainingGuidanceSystemOn.setText("あり");

      shortStayLifeFunctionTrainingGuidanceSystemOn.setGroup(getShortStayLifeFunctionTrainingGuidanceSystem());

      addShortStayLifeFunctionTrainingGuidanceSystemOn();
    }
    return shortStayLifeFunctionTrainingGuidanceSystemOn;

  }

  /**
   * 送迎体制ラジオグループを取得します。
   * @return 送迎体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getShortStayMeetingAndSendingOffSystem(){
    if(shortStayMeetingAndSendingOffSystem==null){

      shortStayMeetingAndSendingOffSystem = new ACClearableRadioButtonGroup();

      getShortStayMeetingAndSendingOffSystemContainer().setText("送迎体制");

      shortStayMeetingAndSendingOffSystem.setBindPath("1210104");

      shortStayMeetingAndSendingOffSystem.setModel(getShortStayMeetingAndSendingOffSystemModel());

      shortStayMeetingAndSendingOffSystem.setUseClearButton(false);

      addShortStayMeetingAndSendingOffSystem();
    }
    return shortStayMeetingAndSendingOffSystem;

  }

  /**
   * 送迎体制ラジオグループコンテナを取得します。
   * @return 送迎体制ラジオグループコンテナ
   */
  protected ACLabelContainer getShortStayMeetingAndSendingOffSystemContainer(){
    if(shortStayMeetingAndSendingOffSystemContainer==null){
      shortStayMeetingAndSendingOffSystemContainer = new ACLabelContainer();
      shortStayMeetingAndSendingOffSystemContainer.setFollowChildEnabled(true);
      shortStayMeetingAndSendingOffSystemContainer.add(getShortStayMeetingAndSendingOffSystem(), null);
    }
    return shortStayMeetingAndSendingOffSystemContainer;
  }

  /**
   * 送迎体制ラジオグループモデルを取得します。
   * @return 送迎体制ラジオグループモデル
   */
  protected ACListModelAdapter getShortStayMeetingAndSendingOffSystemModel(){
    if(shortStayMeetingAndSendingOffSystemModel==null){
      shortStayMeetingAndSendingOffSystemModel = new ACListModelAdapter();
      addShortStayMeetingAndSendingOffSystemModel();
    }
    return shortStayMeetingAndSendingOffSystemModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayLifeMeetingAndSendingOffSystemOff(){
    if(shortStayLifeMeetingAndSendingOffSystemOff==null){

      shortStayLifeMeetingAndSendingOffSystemOff = new ACRadioButtonItem();

      shortStayLifeMeetingAndSendingOffSystemOff.setText("なし");

      shortStayLifeMeetingAndSendingOffSystemOff.setGroup(getShortStayMeetingAndSendingOffSystem());

      addShortStayLifeMeetingAndSendingOffSystemOff();
    }
    return shortStayLifeMeetingAndSendingOffSystemOff;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayMeetingAndSendingOffSystemOn(){
    if(shortStayMeetingAndSendingOffSystemOn==null){

      shortStayMeetingAndSendingOffSystemOn = new ACRadioButtonItem();

      shortStayMeetingAndSendingOffSystemOn.setText("あり");

      shortStayMeetingAndSendingOffSystemOn.setGroup(getShortStayMeetingAndSendingOffSystem());

      addShortStayMeetingAndSendingOffSystemOn();
    }
    return shortStayMeetingAndSendingOffSystemOn;

  }

  /**
   * 栄養管理体制ラジオグループを取得します。
   * @return 栄養管理体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getShortStayLifeNutritionManageRadio(){
    if(shortStayLifeNutritionManageRadio==null){

      shortStayLifeNutritionManageRadio = new ACClearableRadioButtonGroup();

      getShortStayLifeNutritionManageRadioContainer().setText("栄養管理体制");

      shortStayLifeNutritionManageRadio.setBindPath("1210105");

      shortStayLifeNutritionManageRadio.setModel(getShortStayLifeNutritionManageRadioModel());

      shortStayLifeNutritionManageRadio.setUseClearButton(false);

      addShortStayLifeNutritionManageRadio();
    }
    return shortStayLifeNutritionManageRadio;

  }

  /**
   * 栄養管理体制ラジオグループコンテナを取得します。
   * @return 栄養管理体制ラジオグループコンテナ
   */
  protected ACLabelContainer getShortStayLifeNutritionManageRadioContainer(){
    if(shortStayLifeNutritionManageRadioContainer==null){
      shortStayLifeNutritionManageRadioContainer = new ACLabelContainer();
      shortStayLifeNutritionManageRadioContainer.setFollowChildEnabled(true);
      shortStayLifeNutritionManageRadioContainer.add(getShortStayLifeNutritionManageRadio(), null);
    }
    return shortStayLifeNutritionManageRadioContainer;
  }

  /**
   * 栄養管理体制ラジオグループモデルを取得します。
   * @return 栄養管理体制ラジオグループモデル
   */
  protected ACListModelAdapter getShortStayLifeNutritionManageRadioModel(){
    if(shortStayLifeNutritionManageRadioModel==null){
      shortStayLifeNutritionManageRadioModel = new ACListModelAdapter();
      addShortStayLifeNutritionManageRadioModel();
    }
    return shortStayLifeNutritionManageRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayLifeNutritionManageRadioItem1(){
    if(shortStayLifeNutritionManageRadioItem1==null){

      shortStayLifeNutritionManageRadioItem1 = new ACRadioButtonItem();

      shortStayLifeNutritionManageRadioItem1.setText("なし");

      shortStayLifeNutritionManageRadioItem1.setGroup(getShortStayLifeNutritionManageRadio());

      addShortStayLifeNutritionManageRadioItem1();
    }
    return shortStayLifeNutritionManageRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayLifeNutritionManageRadioItem2(){
    if(shortStayLifeNutritionManageRadioItem2==null){

      shortStayLifeNutritionManageRadioItem2 = new ACRadioButtonItem();

      shortStayLifeNutritionManageRadioItem2.setText("あり");

      shortStayLifeNutritionManageRadioItem2.setGroup(getShortStayLifeNutritionManageRadio());

      addShortStayLifeNutritionManageRadioItem2();
    }
    return shortStayLifeNutritionManageRadioItem2;

  }

  /**
   * 療養食体制ラジオグループを取得します。
   * @return 療養食体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getShortStayLifeRecuperatDinnerRadio(){
    if(shortStayLifeRecuperatDinnerRadio==null){

      shortStayLifeRecuperatDinnerRadio = new ACClearableRadioButtonGroup();

      getShortStayLifeRecuperatDinnerRadioContainer().setText("療養食体制");

      shortStayLifeRecuperatDinnerRadio.setBindPath("1210106");

      shortStayLifeRecuperatDinnerRadio.setModel(getShortStayLifeRecuperatDinnerRadioModel());

      shortStayLifeRecuperatDinnerRadio.setUseClearButton(false);

      addShortStayLifeRecuperatDinnerRadio();
    }
    return shortStayLifeRecuperatDinnerRadio;

  }

  /**
   * 療養食体制ラジオグループコンテナを取得します。
   * @return 療養食体制ラジオグループコンテナ
   */
  protected ACLabelContainer getShortStayLifeRecuperatDinnerRadioContainer(){
    if(shortStayLifeRecuperatDinnerRadioContainer==null){
      shortStayLifeRecuperatDinnerRadioContainer = new ACLabelContainer();
      shortStayLifeRecuperatDinnerRadioContainer.setFollowChildEnabled(true);
      shortStayLifeRecuperatDinnerRadioContainer.add(getShortStayLifeRecuperatDinnerRadio(), null);
    }
    return shortStayLifeRecuperatDinnerRadioContainer;
  }

  /**
   * 療養食体制ラジオグループモデルを取得します。
   * @return 療養食体制ラジオグループモデル
   */
  protected ACListModelAdapter getShortStayLifeRecuperatDinnerRadioModel(){
    if(shortStayLifeRecuperatDinnerRadioModel==null){
      shortStayLifeRecuperatDinnerRadioModel = new ACListModelAdapter();
      addShortStayLifeRecuperatDinnerRadioModel();
    }
    return shortStayLifeRecuperatDinnerRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayLifeRecuperatDinnerRadioItem1(){
    if(shortStayLifeRecuperatDinnerRadioItem1==null){

      shortStayLifeRecuperatDinnerRadioItem1 = new ACRadioButtonItem();

      shortStayLifeRecuperatDinnerRadioItem1.setText("なし");

      shortStayLifeRecuperatDinnerRadioItem1.setGroup(getShortStayLifeRecuperatDinnerRadio());

      addShortStayLifeRecuperatDinnerRadioItem1();
    }
    return shortStayLifeRecuperatDinnerRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayLifeRecuperatDinnerRadioItem2(){
    if(shortStayLifeRecuperatDinnerRadioItem2==null){

      shortStayLifeRecuperatDinnerRadioItem2 = new ACRadioButtonItem();

      shortStayLifeRecuperatDinnerRadioItem2.setText("あり");

      shortStayLifeRecuperatDinnerRadioItem2.setGroup(getShortStayLifeRecuperatDinnerRadio());

      addShortStayLifeRecuperatDinnerRadioItem2();
    }
    return shortStayLifeRecuperatDinnerRadioItem2;

  }

  /**
   * 人員減算区分ラジオグループを取得します。
   * @return 人員減算区分ラジオグループ
   */
  public ACClearableRadioButtonGroup getShortStayStaffReduceRadio(){
    if(shortStayStaffReduceRadio==null){

      shortStayStaffReduceRadio = new ACClearableRadioButtonGroup();

      getShortStayStaffReduceRadioContainer().setText("人員減算");

      shortStayStaffReduceRadio.setBindPath("1210107");

      shortStayStaffReduceRadio.setModel(getShortStayStaffReduceRadioModel());

      shortStayStaffReduceRadio.setUseClearButton(false);

      addShortStayStaffReduceRadio();
    }
    return shortStayStaffReduceRadio;

  }

  /**
   * 人員減算区分ラジオグループコンテナを取得します。
   * @return 人員減算区分ラジオグループコンテナ
   */
  protected ACLabelContainer getShortStayStaffReduceRadioContainer(){
    if(shortStayStaffReduceRadioContainer==null){
      shortStayStaffReduceRadioContainer = new ACLabelContainer();
      shortStayStaffReduceRadioContainer.setFollowChildEnabled(true);
      shortStayStaffReduceRadioContainer.add(getShortStayStaffReduceRadio(), null);
    }
    return shortStayStaffReduceRadioContainer;
  }

  /**
   * 人員減算区分ラジオグループモデルを取得します。
   * @return 人員減算区分ラジオグループモデル
   */
  protected ACListModelAdapter getShortStayStaffReduceRadioModel(){
    if(shortStayStaffReduceRadioModel==null){
      shortStayStaffReduceRadioModel = new ACListModelAdapter();
      addShortStayStaffReduceRadioModel();
    }
    return shortStayStaffReduceRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayStaffNot(){
    if(shortStayStaffNot==null){

      shortStayStaffNot = new ACRadioButtonItem();

      shortStayStaffNot.setText("なし");

      shortStayStaffNot.setGroup(getShortStayStaffReduceRadio());

      addShortStayStaffNot();
    }
    return shortStayStaffNot;

  }

  /**
   * 定員超過を取得します。
   * @return 定員超過
   */
  public ACRadioButtonItem getShortStayStaffExcess(){
    if(shortStayStaffExcess==null){

      shortStayStaffExcess = new ACRadioButtonItem();

      shortStayStaffExcess.setText("定員超過");

      shortStayStaffExcess.setGroup(getShortStayStaffReduceRadio());

      addShortStayStaffExcess();
    }
    return shortStayStaffExcess;

  }

  /**
   * 看護、介護職員の不足を取得します。
   * @return 看護、介護職員の不足
   */
  public ACRadioButtonItem getShortStayStaffShortage(){
    if(shortStayStaffShortage==null){

      shortStayStaffShortage = new ACRadioButtonItem();

      shortStayStaffShortage.setText("看護・介護職員の不足");

      shortStayStaffShortage.setGroup(getShortStayStaffReduceRadio());

      addShortStayStaffShortage();
    }
    return shortStayStaffShortage;

  }

  /**
   * 食費基準額・コンテナを取得します。
   * @return 食費基準額・コンテナ
   */
  public ACLabelContainer getShortStayDinnerStandardMoneyConteiner(){
    if(shortStayDinnerStandardMoneyConteiner==null){

      shortStayDinnerStandardMoneyConteiner = new ACLabelContainer();

      shortStayDinnerStandardMoneyConteiner.setText("食費基準額");

      shortStayDinnerStandardMoneyConteiner.setFollowChildEnabled(true);

      addShortStayDinnerStandardMoneyConteiner();
    }
    return shortStayDinnerStandardMoneyConteiner;

  }

  /**
   * 食費基準額・合計・テキストを取得します。
   * @return 食費基準額・合計・テキスト
   */
  public ACTextField getShortStayDinnerStandardMoneyTotal(){
    if(shortStayDinnerStandardMoneyTotal==null){

      shortStayDinnerStandardMoneyTotal = new ACTextField();

      shortStayDinnerStandardMoneyTotal.setBindPath("1210108");

      shortStayDinnerStandardMoneyTotal.setEditable(false);

      shortStayDinnerStandardMoneyTotal.setColumns(4);

      shortStayDinnerStandardMoneyTotal.setCharType(VRCharType.ONLY_DIGIT);

      shortStayDinnerStandardMoneyTotal.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayDinnerStandardMoneyTotal.setIMEMode(InputSubset.LATIN);

      shortStayDinnerStandardMoneyTotal.setMaxLength(4);

      addShortStayDinnerStandardMoneyTotal();
    }
    return shortStayDinnerStandardMoneyTotal;

  }

  /**
   * 食費基準額・朝・ラベルを取得します。
   * @return 食費基準額・朝・ラベル
   */
  public ACLabel getShortStayMorningDinnerStandardMoneyLabel(){
    if(shortStayMorningDinnerStandardMoneyLabel==null){

      shortStayMorningDinnerStandardMoneyLabel = new ACLabel();

      shortStayMorningDinnerStandardMoneyLabel.setText("　朝");

      addShortStayMorningDinnerStandardMoneyLabel();
    }
    return shortStayMorningDinnerStandardMoneyLabel;

  }

  /**
   * 食費基準額・朝・テキストを取得します。
   * @return 食費基準額・朝・テキスト
   */
  public ACTextField getShortStayMorningDinnerStandardMoney(){
    if(shortStayMorningDinnerStandardMoney==null){

      shortStayMorningDinnerStandardMoney = new ACTextField();

      shortStayMorningDinnerStandardMoney.setBindPath("1210109");

      shortStayMorningDinnerStandardMoney.setColumns(3);

      shortStayMorningDinnerStandardMoney.setCharType(VRCharType.ONLY_DIGIT);

      shortStayMorningDinnerStandardMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayMorningDinnerStandardMoney.setIMEMode(InputSubset.LATIN);

      shortStayMorningDinnerStandardMoney.setMaxLength(3);

      addShortStayMorningDinnerStandardMoney();
    }
    return shortStayMorningDinnerStandardMoney;

  }

  /**
   * 食費基準額・昼・ラベルを取得します。
   * @return 食費基準額・昼・ラベル
   */
  public ACLabel getShortStayNoonDinnerStandardMoneyLabel(){
    if(shortStayNoonDinnerStandardMoneyLabel==null){

      shortStayNoonDinnerStandardMoneyLabel = new ACLabel();

      shortStayNoonDinnerStandardMoneyLabel.setText("昼");

      addShortStayNoonDinnerStandardMoneyLabel();
    }
    return shortStayNoonDinnerStandardMoneyLabel;

  }

  /**
   * 食費基準額・昼・テキストを取得します。
   * @return 食費基準額・昼・テキスト
   */
  public ACTextField getShortStayNoonDinnerStandardMoney(){
    if(shortStayNoonDinnerStandardMoney==null){

      shortStayNoonDinnerStandardMoney = new ACTextField();

      shortStayNoonDinnerStandardMoney.setBindPath("1210110");

      shortStayNoonDinnerStandardMoney.setColumns(3);

      shortStayNoonDinnerStandardMoney.setCharType(VRCharType.ONLY_DIGIT);

      shortStayNoonDinnerStandardMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayNoonDinnerStandardMoney.setIMEMode(InputSubset.LATIN);

      shortStayNoonDinnerStandardMoney.setMaxLength(3);

      addShortStayNoonDinnerStandardMoney();
    }
    return shortStayNoonDinnerStandardMoney;

  }

  /**
   * 食費基準額・夜・ラベルを取得します。
   * @return 食費基準額・夜・ラベル
   */
  public ACLabel getShortStayNightDinnerStandardMoneyLabel(){
    if(shortStayNightDinnerStandardMoneyLabel==null){

      shortStayNightDinnerStandardMoneyLabel = new ACLabel();

      shortStayNightDinnerStandardMoneyLabel.setText("夜");

      addShortStayNightDinnerStandardMoneyLabel();
    }
    return shortStayNightDinnerStandardMoneyLabel;

  }

  /**
   * 食費基準額・夜・テキストを取得します。
   * @return 食費基準額・夜・テキスト
   */
  public ACTextField getShortStayNightDinnerStandardMoney(){
    if(shortStayNightDinnerStandardMoney==null){

      shortStayNightDinnerStandardMoney = new ACTextField();

      shortStayNightDinnerStandardMoney.setBindPath("1210111");

      shortStayNightDinnerStandardMoney.setColumns(3);

      shortStayNightDinnerStandardMoney.setCharType(VRCharType.ONLY_DIGIT);

      shortStayNightDinnerStandardMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayNightDinnerStandardMoney.setIMEMode(InputSubset.LATIN);

      shortStayNightDinnerStandardMoney.setMaxLength(3);

      addShortStayNightDinnerStandardMoney();
    }
    return shortStayNightDinnerStandardMoney;

  }

  /**
   * 食費基準額・ラベルを取得します。
   * @return 食費基準額・ラベル
   */
  public ACLabel getShortStayDinnerStandardMoneyDenomination(){
    if(shortStayDinnerStandardMoneyDenomination==null){

      shortStayDinnerStandardMoneyDenomination = new ACLabel();

      shortStayDinnerStandardMoneyDenomination.setText("（円）");

      addShortStayDinnerStandardMoneyDenomination();
    }
    return shortStayDinnerStandardMoneyDenomination;

  }

  /**
   * ユニット型個室基準額・コンテナを取得します。
   * @return ユニット型個室基準額・コンテナ
   */
  public ACLabelContainer getShortStayUnitRoomStandardMoneyConteiner(){
    if(shortStayUnitRoomStandardMoneyConteiner==null){

      shortStayUnitRoomStandardMoneyConteiner = new ACLabelContainer();

      shortStayUnitRoomStandardMoneyConteiner.setText("ユニット型個室基準額");

      shortStayUnitRoomStandardMoneyConteiner.setFollowChildEnabled(true);

      addShortStayUnitRoomStandardMoneyConteiner();
    }
    return shortStayUnitRoomStandardMoneyConteiner;

  }

  /**
   * ユニット型個室基準額・テキストを取得します。
   * @return ユニット型個室基準額・テキスト
   */
  public ACTextField getShortStayUnitRoomStandardMoneyText(){
    if(shortStayUnitRoomStandardMoneyText==null){

      shortStayUnitRoomStandardMoneyText = new ACTextField();

      shortStayUnitRoomStandardMoneyText.setBindPath("1210112");

      shortStayUnitRoomStandardMoneyText.setColumns(4);

      shortStayUnitRoomStandardMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayUnitRoomStandardMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayUnitRoomStandardMoneyText.setIMEMode(InputSubset.LATIN);

      shortStayUnitRoomStandardMoneyText.setMaxLength(4);

      addShortStayUnitRoomStandardMoneyText();
    }
    return shortStayUnitRoomStandardMoneyText;

  }

  /**
   * ユニット型個室基準額・ラベルを取得します。
   * @return ユニット型個室基準額・ラベル
   */
  public ACLabel getShortStayUnitRoomStandardMoneyLabel(){
    if(shortStayUnitRoomStandardMoneyLabel==null){

      shortStayUnitRoomStandardMoneyLabel = new ACLabel();

      shortStayUnitRoomStandardMoneyLabel.setText("（円）");

      addShortStayUnitRoomStandardMoneyLabel();
    }
    return shortStayUnitRoomStandardMoneyLabel;

  }

  /**
   * ユニット型準個室基準額・コンテナを取得します。
   * @return ユニット型準個室基準額・コンテナ
   */
  public ACLabelContainer getShortStayUnitSemiRoomStandardMoneyConteiner(){
    if(shortStayUnitSemiRoomStandardMoneyConteiner==null){

      shortStayUnitSemiRoomStandardMoneyConteiner = new ACLabelContainer();

      shortStayUnitSemiRoomStandardMoneyConteiner.setText("ユニット型準個室基準額");

      shortStayUnitSemiRoomStandardMoneyConteiner.setFollowChildEnabled(true);

      addShortStayUnitSemiRoomStandardMoneyConteiner();
    }
    return shortStayUnitSemiRoomStandardMoneyConteiner;

  }

  /**
   * ユニット型準個室基準額・テキストを取得します。
   * @return ユニット型準個室基準額・テキスト
   */
  public ACTextField getShortStayUnitSemiRoomStandardMoneyText(){
    if(shortStayUnitSemiRoomStandardMoneyText==null){

      shortStayUnitSemiRoomStandardMoneyText = new ACTextField();

      shortStayUnitSemiRoomStandardMoneyText.setBindPath("1210113");

      shortStayUnitSemiRoomStandardMoneyText.setColumns(4);

      shortStayUnitSemiRoomStandardMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayUnitSemiRoomStandardMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayUnitSemiRoomStandardMoneyText.setIMEMode(InputSubset.LATIN);

      shortStayUnitSemiRoomStandardMoneyText.setMaxLength(4);

      addShortStayUnitSemiRoomStandardMoneyText();
    }
    return shortStayUnitSemiRoomStandardMoneyText;

  }

  /**
   * ユニット型準個室基準額・ラベルを取得します。
   * @return ユニット型準個室基準額・ラベル
   */
  public ACLabel getShortStayUnitSemiRoomStandardMoneyLabel(){
    if(shortStayUnitSemiRoomStandardMoneyLabel==null){

      shortStayUnitSemiRoomStandardMoneyLabel = new ACLabel();

      shortStayUnitSemiRoomStandardMoneyLabel.setText("（円）");

      addShortStayUnitSemiRoomStandardMoneyLabel();
    }
    return shortStayUnitSemiRoomStandardMoneyLabel;

  }

  /**
   * 従来型個室基準額・コンテナを取得します。
   * @return 従来型個室基準額・コンテナ
   */
  public ACLabelContainer getShortStayNormalRoomStandardMoneyConteiner(){
    if(shortStayNormalRoomStandardMoneyConteiner==null){

      shortStayNormalRoomStandardMoneyConteiner = new ACLabelContainer();

      shortStayNormalRoomStandardMoneyConteiner.setText("従来型個室基準額");

      shortStayNormalRoomStandardMoneyConteiner.setFollowChildEnabled(true);

      addShortStayNormalRoomStandardMoneyConteiner();
    }
    return shortStayNormalRoomStandardMoneyConteiner;

  }

  /**
   * 従来型個室基準額・テキストを取得します。
   * @return 従来型個室基準額・テキスト
   */
  public ACTextField getShortStayNormalRoomStandardMoneyText(){
    if(shortStayNormalRoomStandardMoneyText==null){

      shortStayNormalRoomStandardMoneyText = new ACTextField();

      shortStayNormalRoomStandardMoneyText.setBindPath("1210114");

      shortStayNormalRoomStandardMoneyText.setColumns(4);

      shortStayNormalRoomStandardMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayNormalRoomStandardMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayNormalRoomStandardMoneyText.setIMEMode(InputSubset.LATIN);

      shortStayNormalRoomStandardMoneyText.setMaxLength(4);

      addShortStayNormalRoomStandardMoneyText();
    }
    return shortStayNormalRoomStandardMoneyText;

  }

  /**
   * 従来型個室基準額・ラベルを取得します。
   * @return 従来型個室基準額・ラベル
   */
  public ACLabel getShortStayNormalRoomStandardMoneyLabel(){
    if(shortStayNormalRoomStandardMoneyLabel==null){

      shortStayNormalRoomStandardMoneyLabel = new ACLabel();

      shortStayNormalRoomStandardMoneyLabel.setText("（円）");

      addShortStayNormalRoomStandardMoneyLabel();
    }
    return shortStayNormalRoomStandardMoneyLabel;

  }

  /**
   * 多床室基準額・コンテナを取得します。
   * @return 多床室基準額・コンテナ
   */
  public ACLabelContainer getShortStayTasyouRoomConteiner(){
    if(shortStayTasyouRoomConteiner==null){

      shortStayTasyouRoomConteiner = new ACLabelContainer();

      shortStayTasyouRoomConteiner.setText("多床室基準額");

      shortStayTasyouRoomConteiner.setFollowChildEnabled(true);

      addShortStayTasyouRoomConteiner();
    }
    return shortStayTasyouRoomConteiner;

  }

  /**
   * 多床室基準額・テキストを取得します。
   * @return 多床室基準額・テキスト
   */
  public ACTextField getShortStayTasyouRoomText(){
    if(shortStayTasyouRoomText==null){

      shortStayTasyouRoomText = new ACTextField();

      shortStayTasyouRoomText.setBindPath("1210115");

      shortStayTasyouRoomText.setColumns(4);

      shortStayTasyouRoomText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayTasyouRoomText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayTasyouRoomText.setIMEMode(InputSubset.LATIN);

      shortStayTasyouRoomText.setMaxLength(4);

      addShortStayTasyouRoomText();
    }
    return shortStayTasyouRoomText;

  }

  /**
   * 多床室基準額・ラベルを取得します。
   * @return 多床室基準額・ラベル
   */
  public ACLabel getShortStayTasyouRoomLabel(){
    if(shortStayTasyouRoomLabel==null){

      shortStayTasyouRoomLabel = new ACLabel();

      shortStayTasyouRoomLabel.setText("（円）");

      addShortStayTasyouRoomLabel();
    }
    return shortStayTasyouRoomLabel;

  }

  /**
   * コンストラクタです。
   */
  public QO004008Design() {

    try {
      initialize();

      initAffair(null);

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

    this.add(getShortStayLifeGroup(), VRLayout.CLIENT);

  }

  /**
   * 事業グループに内部項目を追加します。
   */
  protected void addShortStayLifeGroup(){

    shortStayLifeGroup.add(getShortStayLifeDiscountContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayLifeGroup.add(getShortStayLifeFacilitiesDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayLifeGroup.add(getShortStayNightWorkDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayLifeGroup.add(getShortStayLifeFunctionTrainingGuidanceSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayLifeGroup.add(getShortStayMeetingAndSendingOffSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayLifeGroup.add(getShortStayLifeNutritionManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayLifeGroup.add(getShortStayLifeRecuperatDinnerRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayLifeGroup.add(getShortStayStaffReduceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayLifeGroup.add(getShortStayDinnerStandardMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayLifeGroup.add(getShortStayUnitRoomStandardMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayLifeGroup.add(getShortStayUnitSemiRoomStandardMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayLifeGroup.add(getShortStayNormalRoomStandardMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayLifeGroup.add(getShortStayTasyouRoomConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 割引率コンテナに内部項目を追加します。
   */
  protected void addShortStayLifeDiscountContainer(){

    shortStayLifeDiscountContainer.add(getShortStayLifeDiscountRate(), VRLayout.FLOW);

    shortStayLifeDiscountContainer.add(getShortStayPercentSign(), VRLayout.FLOW);

  }

  /**
   * 割引率に内部項目を追加します。
   */
  protected void addShortStayLifeDiscountRate(){

  }

  /**
   * ％ラベルに内部項目を追加します。
   */
  protected void addShortStayPercentSign(){

  }

  /**
   * 施設区分ラジオグループに内部項目を追加します。
   */
  protected void addShortStayLifeFacilitiesDivision(){

  }

  /**
   * 施設区分ラジオグループモデルに内部項目を追加します。
   */
  protected void addShortStayLifeFacilitiesDivisionModel(){

    getShortStayLifeSingle().setButtonIndex(1);
    getShortStayLifeFacilitiesDivisionModel().add(getShortStayLifeSingle());

    getShortStayLifeDouble().setButtonIndex(2);
    getShortStayLifeFacilitiesDivisionModel().add(getShortStayLifeDouble());

    getShortStayLifeSmall().setButtonIndex(3);
    getShortStayLifeFacilitiesDivisionModel().add(getShortStayLifeSmall());

    getShortStayLifeDoubleSmall().setButtonIndex(4);
    getShortStayLifeFacilitiesDivisionModel().add(getShortStayLifeDoubleSmall());

  }

  /**
   * 単独型に内部項目を追加します。
   */
  protected void addShortStayLifeSingle(){

  }

  /**
   * 併設型に内部項目を追加します。
   */
  protected void addShortStayLifeDouble(){

  }

  /**
   * 単独小規模型に内部項目を追加します。
   */
  protected void addShortStayLifeSmall(){

  }

  /**
   * 併設小規模型に内部項目を追加します。
   */
  protected void addShortStayLifeDoubleSmall(){

  }

  /**
   * 夜間勤務条件基準ラジオグループに内部項目を追加します。
   */
  protected void addShortStayNightWorkDivision(){

  }

  /**
   * 夜間勤務条件基準ラジオグループモデルに内部項目を追加します。
   */
  protected void addShortStayNightWorkDivisionModel(){

    getShortStayLifeNightWorkDivisionFill().setButtonIndex(1);
    getShortStayNightWorkDivisionModel().add(getShortStayLifeNightWorkDivisionFill());

    getShortStayNightWorkDivisionNotFill().setButtonIndex(2);
    getShortStayNightWorkDivisionModel().add(getShortStayNightWorkDivisionNotFill());

  }

  /**
   * 基準型に内部項目を追加します。
   */
  protected void addShortStayLifeNightWorkDivisionFill(){

  }

  /**
   * 減算型に内部項目を追加します。
   */
  protected void addShortStayNightWorkDivisionNotFill(){

  }

  /**
   * 機能訓練指導体制ラジオグループに内部項目を追加します。
   */
  protected void addShortStayLifeFunctionTrainingGuidanceSystem(){

  }

  /**
   * 機能訓練指導体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addShortStayLifeFunctionTrainingGuidanceSystemModel(){

    getShortStayFunctionTrainingGuidanceSystemOff().setButtonIndex(1);
    getShortStayLifeFunctionTrainingGuidanceSystemModel().add(getShortStayFunctionTrainingGuidanceSystemOff());

    getShortStayLifeFunctionTrainingGuidanceSystemOn().setButtonIndex(2);
    getShortStayLifeFunctionTrainingGuidanceSystemModel().add(getShortStayLifeFunctionTrainingGuidanceSystemOn());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayFunctionTrainingGuidanceSystemOff(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayLifeFunctionTrainingGuidanceSystemOn(){

  }

  /**
   * 送迎体制ラジオグループに内部項目を追加します。
   */
  protected void addShortStayMeetingAndSendingOffSystem(){

  }

  /**
   * 送迎体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addShortStayMeetingAndSendingOffSystemModel(){

    getShortStayLifeMeetingAndSendingOffSystemOff().setButtonIndex(1);
    getShortStayMeetingAndSendingOffSystemModel().add(getShortStayLifeMeetingAndSendingOffSystemOff());

    getShortStayMeetingAndSendingOffSystemOn().setButtonIndex(2);
    getShortStayMeetingAndSendingOffSystemModel().add(getShortStayMeetingAndSendingOffSystemOn());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayLifeMeetingAndSendingOffSystemOff(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayMeetingAndSendingOffSystemOn(){

  }

  /**
   * 栄養管理体制ラジオグループに内部項目を追加します。
   */
  protected void addShortStayLifeNutritionManageRadio(){

  }

  /**
   * 栄養管理体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addShortStayLifeNutritionManageRadioModel(){

    getShortStayLifeNutritionManageRadioItem1().setButtonIndex(1);
    getShortStayLifeNutritionManageRadioModel().add(getShortStayLifeNutritionManageRadioItem1());

    getShortStayLifeNutritionManageRadioItem2().setButtonIndex(2);
    getShortStayLifeNutritionManageRadioModel().add(getShortStayLifeNutritionManageRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayLifeNutritionManageRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayLifeNutritionManageRadioItem2(){

  }

  /**
   * 療養食体制ラジオグループに内部項目を追加します。
   */
  protected void addShortStayLifeRecuperatDinnerRadio(){

  }

  /**
   * 療養食体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addShortStayLifeRecuperatDinnerRadioModel(){

    getShortStayLifeRecuperatDinnerRadioItem1().setButtonIndex(1);
    getShortStayLifeRecuperatDinnerRadioModel().add(getShortStayLifeRecuperatDinnerRadioItem1());

    getShortStayLifeRecuperatDinnerRadioItem2().setButtonIndex(2);
    getShortStayLifeRecuperatDinnerRadioModel().add(getShortStayLifeRecuperatDinnerRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayLifeRecuperatDinnerRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayLifeRecuperatDinnerRadioItem2(){

  }

  /**
   * 人員減算区分ラジオグループに内部項目を追加します。
   */
  protected void addShortStayStaffReduceRadio(){

  }

  /**
   * 人員減算区分ラジオグループモデルに内部項目を追加します。
   */
  protected void addShortStayStaffReduceRadioModel(){

    getShortStayStaffNot().setButtonIndex(1);
    getShortStayStaffReduceRadioModel().add(getShortStayStaffNot());

    getShortStayStaffExcess().setButtonIndex(2);
    getShortStayStaffReduceRadioModel().add(getShortStayStaffExcess());

    getShortStayStaffShortage().setButtonIndex(3);
    getShortStayStaffReduceRadioModel().add(getShortStayStaffShortage());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayStaffNot(){

  }

  /**
   * 定員超過に内部項目を追加します。
   */
  protected void addShortStayStaffExcess(){

  }

  /**
   * 看護、介護職員の不足に内部項目を追加します。
   */
  protected void addShortStayStaffShortage(){

  }

  /**
   * 食費基準額・コンテナに内部項目を追加します。
   */
  protected void addShortStayDinnerStandardMoneyConteiner(){

    shortStayDinnerStandardMoneyConteiner.add(getShortStayDinnerStandardMoneyTotal(), VRLayout.FLOW);

    shortStayDinnerStandardMoneyConteiner.add(getShortStayMorningDinnerStandardMoneyLabel(), VRLayout.FLOW);

    shortStayDinnerStandardMoneyConteiner.add(getShortStayMorningDinnerStandardMoney(), VRLayout.FLOW);

    shortStayDinnerStandardMoneyConteiner.add(getShortStayNoonDinnerStandardMoneyLabel(), VRLayout.FLOW);

    shortStayDinnerStandardMoneyConteiner.add(getShortStayNoonDinnerStandardMoney(), VRLayout.FLOW);

    shortStayDinnerStandardMoneyConteiner.add(getShortStayNightDinnerStandardMoneyLabel(), VRLayout.FLOW);

    shortStayDinnerStandardMoneyConteiner.add(getShortStayNightDinnerStandardMoney(), VRLayout.FLOW);

    shortStayDinnerStandardMoneyConteiner.add(getShortStayDinnerStandardMoneyDenomination(), VRLayout.FLOW);

  }

  /**
   * 食費基準額・合計・テキストに内部項目を追加します。
   */
  protected void addShortStayDinnerStandardMoneyTotal(){

  }

  /**
   * 食費基準額・朝・ラベルに内部項目を追加します。
   */
  protected void addShortStayMorningDinnerStandardMoneyLabel(){

  }

  /**
   * 食費基準額・朝・テキストに内部項目を追加します。
   */
  protected void addShortStayMorningDinnerStandardMoney(){

  }

  /**
   * 食費基準額・昼・ラベルに内部項目を追加します。
   */
  protected void addShortStayNoonDinnerStandardMoneyLabel(){

  }

  /**
   * 食費基準額・昼・テキストに内部項目を追加します。
   */
  protected void addShortStayNoonDinnerStandardMoney(){

  }

  /**
   * 食費基準額・夜・ラベルに内部項目を追加します。
   */
  protected void addShortStayNightDinnerStandardMoneyLabel(){

  }

  /**
   * 食費基準額・夜・テキストに内部項目を追加します。
   */
  protected void addShortStayNightDinnerStandardMoney(){

  }

  /**
   * 食費基準額・ラベルに内部項目を追加します。
   */
  protected void addShortStayDinnerStandardMoneyDenomination(){

  }

  /**
   * ユニット型個室基準額・コンテナに内部項目を追加します。
   */
  protected void addShortStayUnitRoomStandardMoneyConteiner(){

    shortStayUnitRoomStandardMoneyConteiner.add(getShortStayUnitRoomStandardMoneyText(), null);

    shortStayUnitRoomStandardMoneyConteiner.add(getShortStayUnitRoomStandardMoneyLabel(), null);

  }

  /**
   * ユニット型個室基準額・テキストに内部項目を追加します。
   */
  protected void addShortStayUnitRoomStandardMoneyText(){

  }

  /**
   * ユニット型個室基準額・ラベルに内部項目を追加します。
   */
  protected void addShortStayUnitRoomStandardMoneyLabel(){

  }

  /**
   * ユニット型準個室基準額・コンテナに内部項目を追加します。
   */
  protected void addShortStayUnitSemiRoomStandardMoneyConteiner(){

    shortStayUnitSemiRoomStandardMoneyConteiner.add(getShortStayUnitSemiRoomStandardMoneyText(), null);

    shortStayUnitSemiRoomStandardMoneyConteiner.add(getShortStayUnitSemiRoomStandardMoneyLabel(), null);

  }

  /**
   * ユニット型準個室基準額・テキストに内部項目を追加します。
   */
  protected void addShortStayUnitSemiRoomStandardMoneyText(){

  }

  /**
   * ユニット型準個室基準額・ラベルに内部項目を追加します。
   */
  protected void addShortStayUnitSemiRoomStandardMoneyLabel(){

  }

  /**
   * 従来型個室基準額・コンテナに内部項目を追加します。
   */
  protected void addShortStayNormalRoomStandardMoneyConteiner(){

    shortStayNormalRoomStandardMoneyConteiner.add(getShortStayNormalRoomStandardMoneyText(), null);

    shortStayNormalRoomStandardMoneyConteiner.add(getShortStayNormalRoomStandardMoneyLabel(), null);

  }

  /**
   * 従来型個室基準額・テキストに内部項目を追加します。
   */
  protected void addShortStayNormalRoomStandardMoneyText(){

  }

  /**
   * 従来型個室基準額・ラベルに内部項目を追加します。
   */
  protected void addShortStayNormalRoomStandardMoneyLabel(){

  }

  /**
   * 多床室基準額・コンテナに内部項目を追加します。
   */
  protected void addShortStayTasyouRoomConteiner(){

    shortStayTasyouRoomConteiner.add(getShortStayTasyouRoomText(), null);

    shortStayTasyouRoomConteiner.add(getShortStayTasyouRoomLabel(), null);

  }

  /**
   * 多床室基準額・テキストに内部項目を追加します。
   */
  protected void addShortStayTasyouRoomText(){

  }

  /**
   * 多床室基準額・ラベルに内部項目を追加します。
   */
  protected void addShortStayTasyouRoomLabel(){

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
      ACFrame.getInstance().getContentPane().add(new QO004008Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004008Design getThis() {
    return this;
  }
}
