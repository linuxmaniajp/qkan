
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
 * プログラム 介護老人福祉施設 (QO004016)
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
import jp.or.med.orca.qkan.text.*;
/**
 * 介護老人福祉施設画面項目デザイン(QO004016) 
 */
public class QO004016Design extends ACPanel {
  //GUIコンポーネント

  private ACGroupBox agedPeopleWelfareFacilityGroup;

  private ACLabelContainer agedPeopleWelfareFacilityDiscountcontainer;

  private ACTextField agedPeopleWelfareFacilityDiscountRate;

  private ACLabel percentSign;

  private ACClearableRadioButtonGroup agedPeopleWelfareFacilitiesDivision;

  private ACLabelContainer agedPeopleWelfareFacilitiesDivisionContainer;

  private ACListModelAdapter agedPeopleWelfareFacilitiesDivisionModel;

  private VRLayout agedPeopleWelfareFacilitiesDivisionLayout;

  private ACRadioButtonItem welfareFacility1;

  private ACRadioButtonItem welfareFacility2;

  private ACRadioButtonItem welfareFacility3;

  private ACRadioButtonItem welfareFacility4;

  private ACClearableRadioButtonGroup nightShiftCondition;

  private ACLabelContainer nightShiftConditionContainer;

  private ACListModelAdapter nightShiftConditionModel;

  private ACRadioButtonItem nightShiftConditionStandard;

  private ACRadioButtonItem nightShiftConditionSubtraction;

  private ACClearableRadioButtonGroup functionTrainingGuidanceSystem;

  private ACLabelContainer functionTrainingGuidanceSystemContainer;

  private ACListModelAdapter functionTrainingGuidanceSystemModel;

  private ACRadioButtonItem functionTrainingGuidanceSystemOff;

  private ACRadioButtonItem functionTrainingGuidanceSystemOn;

  private ACClearableRadioButtonGroup standingDoctorArrangement;

  private ACLabelContainer standingDoctorArrangementContainer;

  private ACListModelAdapter standingDoctorArrangementModel;

  private ACRadioButtonItem standingDoctorArrangementOff;

  private ACRadioButtonItem standingDoctorArrangementOn;

  private ACClearableRadioButtonGroup psychiatristMaster;

  private ACLabelContainer psychiatristMasterContainer;

  private ACListModelAdapter psychiatristMasterModel;

  private ACRadioButtonItem psychiatristMasterOff;

  private ACRadioButtonItem psychiatristMasterOn;

  private ACClearableRadioButtonGroup handicappedPersonSupport;

  private ACLabelContainer handicappedPersonSupportContainer;

  private ACListModelAdapter handicappedPersonSupportModel;

  private ACRadioButtonItem handicappedPersonSupportOff;

  private ACRadioButtonItem handicappedPersonSupportOn;

  private ACClearableRadioButtonGroup nutritionManageRadio;

  private ACLabelContainer nutritionManageRadioContainer;

  private ACListModelAdapter nutritionManageRadioModel;

  private ACRadioButtonItem nutritionManageRadioItem1;

  private ACRadioButtonItem nutritionManageRadioItem2;

  private ACClearableRadioButtonGroup nutritionRadio;

  private ACLabelContainer nutritionRadioContainer;

  private ACListModelAdapter nutritionRadioModel;

  private ACRadioButtonItem nutritionRadioItem1;

  private ACRadioButtonItem nutritionRadioItem2 ;

  private ACClearableRadioButtonGroup oralSwitchRadio;

  private ACLabelContainer oralSwitchRadioContainer;

  private ACListModelAdapter oralSwitchRadioModel;

  private ACRadioButtonItem oralSwitchRadioItem1;

  private ACRadioButtonItem oralSwitchRadioItem2 ;

  private ACClearableRadioButtonGroup recuperateDinnerRadio;

  private ACLabelContainer recuperateDinnerRadioContainer;

  private ACListModelAdapter recuperateDinnerRadioModel;

  private ACRadioButtonItem recuperateDinnerRadioItem1;

  private ACRadioButtonItem recuperateDinnerRadioItem2;

  private ACClearableRadioButtonGroup staffLack;

  private ACLabelContainer staffLackContainer;

  private ACListModelAdapter staffLackModel;

  private ACRadioButtonItem staffLackOff;

  private ACRadioButtonItem staffLackStaffExcess;

  private ACRadioButtonItem staffLackKaigo;

  private ACLabelContainer careOldPepleWelfareFacilitiesDinnerStandeirdMoneyConteiner;

  private ACTextField careOldPepleWelfareFacilitiesDinnerStandeirdMoneyTotal;

  private ACLabel careOldPepleWelfareFacilitiesMorningDinnerStandeirdMoneyLabel;

  private ACTextField careOldPepleWelfareFacilitiesMorningDinnerStandeirdMoney;

  private ACLabel careOldPepleWelfareFacilitiesNoonDinnerStandeirdMoneyLabel;

  private ACTextField careOldPepleWelfareFacilitiesNoonDinnerStandeirdMoney;

  private ACLabel careOldPepleWelfareFacilitiesNightDinnerStandeirdMoneyLabel;

  private ACTextField careOldPepleWelfareFacilitiesNightDinnerStandeirdMoney;

  private ACLabel careOldPepleWelfareFacilitiesDinnerStandeirdMoney4Label;

  private ACLabelContainer careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyConteiner;

  private ACTextField careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyText;

  private ACLabel careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyLabel;

  private ACLabelContainer careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyConteiner;

  private ACTextField careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyText;

  private ACLabel careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyLabel;

  private ACLabelContainer careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyConteiner;

  private ACTextField careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyText;

  private ACLabel careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyLabel;

  private ACLabelContainer careOldPepleWelfareFacilitiesTasyouRoomConteiner;

  private ACTextField careOldPepleWelfareFacilitiesTasyouRoomText;

  private ACLabel careOldPepleWelfareFacilitiesTasyouRoomLabel;

  //getter

  /**
   * 事業グループを取得します。
   * @return 事業グループ
   */
  public ACGroupBox getAgedPeopleWelfareFacilityGroup(){
    if(agedPeopleWelfareFacilityGroup==null){

      agedPeopleWelfareFacilityGroup = new ACGroupBox();

      agedPeopleWelfareFacilityGroup.setText("介護老人福祉施設");

      agedPeopleWelfareFacilityGroup.setFollowChildEnabled(true);

      agedPeopleWelfareFacilityGroup.setHgrid(500);

      addAgedPeopleWelfareFacilityGroup();
    }
    return agedPeopleWelfareFacilityGroup;

  }

  /**
   * 割引率コンテナを取得します。
   * @return 割引率コンテナ
   */
  public ACLabelContainer getAgedPeopleWelfareFacilityDiscountcontainer(){
    if(agedPeopleWelfareFacilityDiscountcontainer==null){

      agedPeopleWelfareFacilityDiscountcontainer = new ACLabelContainer();

      agedPeopleWelfareFacilityDiscountcontainer.setText("割引率");

      agedPeopleWelfareFacilityDiscountcontainer.setFollowChildEnabled(true);

      addAgedPeopleWelfareFacilityDiscountcontainer();
    }
    return agedPeopleWelfareFacilityDiscountcontainer;

  }

  /**
   * 割引率を取得します。
   * @return 割引率
   */
  public ACTextField getAgedPeopleWelfareFacilityDiscountRate(){
    if(agedPeopleWelfareFacilityDiscountRate==null){

      agedPeopleWelfareFacilityDiscountRate = new ACTextField();

      agedPeopleWelfareFacilityDiscountRate.setBindPath("REDUCT_RATE");

      agedPeopleWelfareFacilityDiscountRate.setColumns(3);

      agedPeopleWelfareFacilityDiscountRate.setCharType(VRCharType.ONLY_DIGIT);

      agedPeopleWelfareFacilityDiscountRate.setHorizontalAlignment(SwingConstants.RIGHT);

      agedPeopleWelfareFacilityDiscountRate.setIMEMode(InputSubset.LATIN);

      agedPeopleWelfareFacilityDiscountRate.setMaxLength(3);

      addAgedPeopleWelfareFacilityDiscountRate();
    }
    return agedPeopleWelfareFacilityDiscountRate;

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
   * 施設区分ラジオグループを取得します。
   * @return 施設区分ラジオグループ
   */
  public ACClearableRadioButtonGroup getAgedPeopleWelfareFacilitiesDivision(){
    if(agedPeopleWelfareFacilitiesDivision==null){

      agedPeopleWelfareFacilitiesDivision = new ACClearableRadioButtonGroup();

      getAgedPeopleWelfareFacilitiesDivisionContainer().setText("施設区分");

      agedPeopleWelfareFacilitiesDivision.setBindPath("1510101");

      agedPeopleWelfareFacilitiesDivision.setLayout(getAgedPeopleWelfareFacilitiesDivisionLayout());

      agedPeopleWelfareFacilitiesDivision.setModel(getAgedPeopleWelfareFacilitiesDivisionModel());

      agedPeopleWelfareFacilitiesDivision.setUseClearButton(false);

      addAgedPeopleWelfareFacilitiesDivision();
    }
    return agedPeopleWelfareFacilitiesDivision;

  }

  /**
   * 施設区分ラジオグループコンテナを取得します。
   * @return 施設区分ラジオグループコンテナ
   */
  protected ACLabelContainer getAgedPeopleWelfareFacilitiesDivisionContainer(){
    if(agedPeopleWelfareFacilitiesDivisionContainer==null){
      agedPeopleWelfareFacilitiesDivisionContainer = new ACLabelContainer();
      agedPeopleWelfareFacilitiesDivisionContainer.setFollowChildEnabled(true);
      agedPeopleWelfareFacilitiesDivisionContainer.add(getAgedPeopleWelfareFacilitiesDivision(), null);
    }
    return agedPeopleWelfareFacilitiesDivisionContainer;
  }

  /**
   * 施設区分ラジオグループモデルを取得します。
   * @return 施設区分ラジオグループモデル
   */
  protected ACListModelAdapter getAgedPeopleWelfareFacilitiesDivisionModel(){
    if(agedPeopleWelfareFacilitiesDivisionModel==null){
      agedPeopleWelfareFacilitiesDivisionModel = new ACListModelAdapter();
      addAgedPeopleWelfareFacilitiesDivisionModel();
    }
    return agedPeopleWelfareFacilitiesDivisionModel;
  }

  /**
   * 施設等の区分ラジオグループレイアウトを取得します。
   * @return 施設等の区分ラジオグループレイアウト
   */
  public VRLayout getAgedPeopleWelfareFacilitiesDivisionLayout(){
    if(agedPeopleWelfareFacilitiesDivisionLayout==null){

      agedPeopleWelfareFacilitiesDivisionLayout = new VRLayout();

      agedPeopleWelfareFacilitiesDivisionLayout.setAutoWrap(false);

      agedPeopleWelfareFacilitiesDivisionLayout.setHgap(0);

      addAgedPeopleWelfareFacilitiesDivisionLayout();
    }
    return agedPeopleWelfareFacilitiesDivisionLayout;

  }

  /**
   * 介護福祉施設を取得します。
   * @return 介護福祉施設
   */
  public ACRadioButtonItem getWelfareFacility1(){
    if(welfareFacility1==null){

      welfareFacility1 = new ACRadioButtonItem();

      welfareFacility1.setText("介護福祉施設");

      welfareFacility1.setGroup(getAgedPeopleWelfareFacilitiesDivision());

      welfareFacility1.setConstraints(VRLayout.FLOW);

      addWelfareFacility1();
    }
    return welfareFacility1;

  }

  /**
   * 小規模介護福祉施設を取得します。
   * @return 小規模介護福祉施設
   */
  public ACRadioButtonItem getWelfareFacility2(){
    if(welfareFacility2==null){

      welfareFacility2 = new ACRadioButtonItem();

      welfareFacility2.setText("小規模介護福祉施設");

      welfareFacility2.setGroup(getAgedPeopleWelfareFacilitiesDivision());

      welfareFacility2.setConstraints(VRLayout.FLOW_RETURN);

      addWelfareFacility2();
    }
    return welfareFacility2;

  }

  /**
   * ユニット型介護福祉施設を取得します。
   * @return ユニット型介護福祉施設
   */
  public ACRadioButtonItem getWelfareFacility3(){
    if(welfareFacility3==null){

      welfareFacility3 = new ACRadioButtonItem();

      welfareFacility3.setText("ユニット型介護福祉施設");

      welfareFacility3.setGroup(getAgedPeopleWelfareFacilitiesDivision());

      welfareFacility3.setConstraints(VRLayout.FLOW);

      addWelfareFacility3();
    }
    return welfareFacility3;

  }

  /**
   * ユニット型小規模介護福祉施設を取得します。
   * @return ユニット型小規模介護福祉施設
   */
  public ACRadioButtonItem getWelfareFacility4(){
    if(welfareFacility4==null){

      welfareFacility4 = new ACRadioButtonItem();

      welfareFacility4.setText("ユニット型小規模介護福祉施設");

      welfareFacility4.setGroup(getAgedPeopleWelfareFacilitiesDivision());

      welfareFacility4.setConstraints(VRLayout.FLOW);

      addWelfareFacility4();
    }
    return welfareFacility4;

  }

  /**
   * 夜間勤務条件基準ラジオグループを取得します。
   * @return 夜間勤務条件基準ラジオグループ
   */
  public ACClearableRadioButtonGroup getNightShiftCondition(){
    if(nightShiftCondition==null){

      nightShiftCondition = new ACClearableRadioButtonGroup();

      getNightShiftConditionContainer().setText("夜間勤務条件基準");

      nightShiftCondition.setBindPath("1510102");

      nightShiftCondition.setModel(getNightShiftConditionModel());

      nightShiftCondition.setUseClearButton(false);

      addNightShiftCondition();
    }
    return nightShiftCondition;

  }

  /**
   * 夜間勤務条件基準ラジオグループコンテナを取得します。
   * @return 夜間勤務条件基準ラジオグループコンテナ
   */
  protected ACLabelContainer getNightShiftConditionContainer(){
    if(nightShiftConditionContainer==null){
      nightShiftConditionContainer = new ACLabelContainer();
      nightShiftConditionContainer.setFollowChildEnabled(true);
      nightShiftConditionContainer.add(getNightShiftCondition(), null);
    }
    return nightShiftConditionContainer;
  }

  /**
   * 夜間勤務条件基準ラジオグループモデルを取得します。
   * @return 夜間勤務条件基準ラジオグループモデル
   */
  protected ACListModelAdapter getNightShiftConditionModel(){
    if(nightShiftConditionModel==null){
      nightShiftConditionModel = new ACListModelAdapter();
      addNightShiftConditionModel();
    }
    return nightShiftConditionModel;
  }

  /**
   * 基準型を取得します。
   * @return 基準型
   */
  public ACRadioButtonItem getNightShiftConditionStandard(){
    if(nightShiftConditionStandard==null){

      nightShiftConditionStandard = new ACRadioButtonItem();

      nightShiftConditionStandard.setText("基準型");

      nightShiftConditionStandard.setGroup(getNightShiftCondition());

      addNightShiftConditionStandard();
    }
    return nightShiftConditionStandard;

  }

  /**
   * 減算型を取得します。
   * @return 減算型
   */
  public ACRadioButtonItem getNightShiftConditionSubtraction(){
    if(nightShiftConditionSubtraction==null){

      nightShiftConditionSubtraction = new ACRadioButtonItem();

      nightShiftConditionSubtraction.setText("減算型");

      nightShiftConditionSubtraction.setGroup(getNightShiftCondition());

      addNightShiftConditionSubtraction();
    }
    return nightShiftConditionSubtraction;

  }

  /**
   * 機能訓練指導体制ラジオグループを取得します。
   * @return 機能訓練指導体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getFunctionTrainingGuidanceSystem(){
    if(functionTrainingGuidanceSystem==null){

      functionTrainingGuidanceSystem = new ACClearableRadioButtonGroup();

      getFunctionTrainingGuidanceSystemContainer().setText("機能訓練指導体制");

      functionTrainingGuidanceSystem.setBindPath("1510103");

      functionTrainingGuidanceSystem.setModel(getFunctionTrainingGuidanceSystemModel());

      functionTrainingGuidanceSystem.setUseClearButton(false);

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
  public ACRadioButtonItem getFunctionTrainingGuidanceSystemOff(){
    if(functionTrainingGuidanceSystemOff==null){

      functionTrainingGuidanceSystemOff = new ACRadioButtonItem();

      functionTrainingGuidanceSystemOff.setText("なし");

      functionTrainingGuidanceSystemOff.setGroup(getFunctionTrainingGuidanceSystem());

      addFunctionTrainingGuidanceSystemOff();
    }
    return functionTrainingGuidanceSystemOff;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getFunctionTrainingGuidanceSystemOn(){
    if(functionTrainingGuidanceSystemOn==null){

      functionTrainingGuidanceSystemOn = new ACRadioButtonItem();

      functionTrainingGuidanceSystemOn.setText("あり");

      functionTrainingGuidanceSystemOn.setGroup(getFunctionTrainingGuidanceSystem());

      addFunctionTrainingGuidanceSystemOn();
    }
    return functionTrainingGuidanceSystemOn;

  }

  /**
   * 常勤専従医師配置ラジオグループを取得します。
   * @return 常勤専従医師配置ラジオグループ
   */
  public ACClearableRadioButtonGroup getStandingDoctorArrangement(){
    if(standingDoctorArrangement==null){

      standingDoctorArrangement = new ACClearableRadioButtonGroup();

      getStandingDoctorArrangementContainer().setText("常勤専従医師配置");

      standingDoctorArrangement.setBindPath("1510104");

      standingDoctorArrangement.setModel(getStandingDoctorArrangementModel());

      standingDoctorArrangement.setUseClearButton(false);

      addStandingDoctorArrangement();
    }
    return standingDoctorArrangement;

  }

  /**
   * 常勤専従医師配置ラジオグループコンテナを取得します。
   * @return 常勤専従医師配置ラジオグループコンテナ
   */
  protected ACLabelContainer getStandingDoctorArrangementContainer(){
    if(standingDoctorArrangementContainer==null){
      standingDoctorArrangementContainer = new ACLabelContainer();
      standingDoctorArrangementContainer.setFollowChildEnabled(true);
      standingDoctorArrangementContainer.add(getStandingDoctorArrangement(), null);
    }
    return standingDoctorArrangementContainer;
  }

  /**
   * 常勤専従医師配置ラジオグループモデルを取得します。
   * @return 常勤専従医師配置ラジオグループモデル
   */
  protected ACListModelAdapter getStandingDoctorArrangementModel(){
    if(standingDoctorArrangementModel==null){
      standingDoctorArrangementModel = new ACListModelAdapter();
      addStandingDoctorArrangementModel();
    }
    return standingDoctorArrangementModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getStandingDoctorArrangementOff(){
    if(standingDoctorArrangementOff==null){

      standingDoctorArrangementOff = new ACRadioButtonItem();

      standingDoctorArrangementOff.setText("なし");

      standingDoctorArrangementOff.setGroup(getStandingDoctorArrangement());

      addStandingDoctorArrangementOff();
    }
    return standingDoctorArrangementOff;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getStandingDoctorArrangementOn(){
    if(standingDoctorArrangementOn==null){

      standingDoctorArrangementOn = new ACRadioButtonItem();

      standingDoctorArrangementOn.setText("あり");

      standingDoctorArrangementOn.setGroup(getStandingDoctorArrangement());

      addStandingDoctorArrangementOn();
    }
    return standingDoctorArrangementOn;

  }

  /**
   * 精神科医師定期的療養指導ラジオグループを取得します。
   * @return 精神科医師定期的療養指導ラジオグループ
   */
  public ACClearableRadioButtonGroup getPsychiatristMaster(){
    if(psychiatristMaster==null){

      psychiatristMaster = new ACClearableRadioButtonGroup();

      getPsychiatristMasterContainer().setText("精神科医師定期的療養指導");

      psychiatristMaster.setBindPath("1510105");

      psychiatristMaster.setModel(getPsychiatristMasterModel());

      psychiatristMaster.setUseClearButton(false);

      addPsychiatristMaster();
    }
    return psychiatristMaster;

  }

  /**
   * 精神科医師定期的療養指導ラジオグループコンテナを取得します。
   * @return 精神科医師定期的療養指導ラジオグループコンテナ
   */
  protected ACLabelContainer getPsychiatristMasterContainer(){
    if(psychiatristMasterContainer==null){
      psychiatristMasterContainer = new ACLabelContainer();
      psychiatristMasterContainer.setFollowChildEnabled(true);
      psychiatristMasterContainer.add(getPsychiatristMaster(), null);
    }
    return psychiatristMasterContainer;
  }

  /**
   * 精神科医師定期的療養指導ラジオグループモデルを取得します。
   * @return 精神科医師定期的療養指導ラジオグループモデル
   */
  protected ACListModelAdapter getPsychiatristMasterModel(){
    if(psychiatristMasterModel==null){
      psychiatristMasterModel = new ACListModelAdapter();
      addPsychiatristMasterModel();
    }
    return psychiatristMasterModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getPsychiatristMasterOff(){
    if(psychiatristMasterOff==null){

      psychiatristMasterOff = new ACRadioButtonItem();

      psychiatristMasterOff.setText("なし");

      psychiatristMasterOff.setGroup(getPsychiatristMaster());

      addPsychiatristMasterOff();
    }
    return psychiatristMasterOff;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getPsychiatristMasterOn(){
    if(psychiatristMasterOn==null){

      psychiatristMasterOn = new ACRadioButtonItem();

      psychiatristMasterOn.setText("あり");

      psychiatristMasterOn.setGroup(getPsychiatristMaster());

      addPsychiatristMasterOn();
    }
    return psychiatristMasterOn;

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
  public ACRadioButtonItem getHandicappedPersonSupportOff(){
    if(handicappedPersonSupportOff==null){

      handicappedPersonSupportOff = new ACRadioButtonItem();

      handicappedPersonSupportOff.setText("なし");

      handicappedPersonSupportOff.setGroup(getHandicappedPersonSupport());

      addHandicappedPersonSupportOff();
    }
    return handicappedPersonSupportOff;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHandicappedPersonSupportOn(){
    if(handicappedPersonSupportOn==null){

      handicappedPersonSupportOn = new ACRadioButtonItem();

      handicappedPersonSupportOn.setText("あり");

      handicappedPersonSupportOn.setGroup(getHandicappedPersonSupport());

      addHandicappedPersonSupportOn();
    }
    return handicappedPersonSupportOn;

  }

  /**
   * 栄養管理体制ラジオグループを取得します。
   * @return 栄養管理体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getNutritionManageRadio(){
    if(nutritionManageRadio==null){

      nutritionManageRadio = new ACClearableRadioButtonGroup();

      getNutritionManageRadioContainer().setText("栄養管理体制");

      nutritionManageRadio.setBindPath("1510108");

      nutritionManageRadio.setModel(getNutritionManageRadioModel());

      nutritionManageRadio.setUseClearButton(false);

      addNutritionManageRadio();
    }
    return nutritionManageRadio;

  }

  /**
   * 栄養管理体制ラジオグループコンテナを取得します。
   * @return 栄養管理体制ラジオグループコンテナ
   */
  protected ACLabelContainer getNutritionManageRadioContainer(){
    if(nutritionManageRadioContainer==null){
      nutritionManageRadioContainer = new ACLabelContainer();
      nutritionManageRadioContainer.setFollowChildEnabled(true);
      nutritionManageRadioContainer.add(getNutritionManageRadio(), null);
    }
    return nutritionManageRadioContainer;
  }

  /**
   * 栄養管理体制ラジオグループモデルを取得します。
   * @return 栄養管理体制ラジオグループモデル
   */
  protected ACListModelAdapter getNutritionManageRadioModel(){
    if(nutritionManageRadioModel==null){
      nutritionManageRadioModel = new ACListModelAdapter();
      addNutritionManageRadioModel();
    }
    return nutritionManageRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getNutritionManageRadioItem1(){
    if(nutritionManageRadioItem1==null){

      nutritionManageRadioItem1 = new ACRadioButtonItem();

      nutritionManageRadioItem1.setText("なし");

      nutritionManageRadioItem1.setGroup(getNutritionManageRadio());

      addNutritionManageRadioItem1();
    }
    return nutritionManageRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getNutritionManageRadioItem2(){
    if(nutritionManageRadioItem2==null){

      nutritionManageRadioItem2 = new ACRadioButtonItem();

      nutritionManageRadioItem2.setText("あり");

      nutritionManageRadioItem2.setGroup(getNutritionManageRadio());

      addNutritionManageRadioItem2();
    }
    return nutritionManageRadioItem2;

  }

  /**
   * 栄養マネジメント体制ラジオグループを取得します。
   * @return 栄養マネジメント体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getNutritionRadio(){
    if(nutritionRadio==null){

      nutritionRadio = new ACClearableRadioButtonGroup();

      getNutritionRadioContainer().setText("栄養マネジメント体制");

      nutritionRadio.setBindPath("1510109");

      nutritionRadio.setModel(getNutritionRadioModel());

      nutritionRadio.setUseClearButton(false);

      addNutritionRadio();
    }
    return nutritionRadio;

  }

  /**
   * 栄養マネジメント体制ラジオグループコンテナを取得します。
   * @return 栄養マネジメント体制ラジオグループコンテナ
   */
  protected ACLabelContainer getNutritionRadioContainer(){
    if(nutritionRadioContainer==null){
      nutritionRadioContainer = new ACLabelContainer();
      nutritionRadioContainer.setFollowChildEnabled(true);
      nutritionRadioContainer.add(getNutritionRadio(), null);
    }
    return nutritionRadioContainer;
  }

  /**
   * 栄養マネジメント体制ラジオグループモデルを取得します。
   * @return 栄養マネジメント体制ラジオグループモデル
   */
  protected ACListModelAdapter getNutritionRadioModel(){
    if(nutritionRadioModel==null){
      nutritionRadioModel = new ACListModelAdapter();
      addNutritionRadioModel();
    }
    return nutritionRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getNutritionRadioItem1(){
    if(nutritionRadioItem1==null){

      nutritionRadioItem1 = new ACRadioButtonItem();

      nutritionRadioItem1.setText("なし");

      nutritionRadioItem1.setGroup(getNutritionRadio());

      addNutritionRadioItem1();
    }
    return nutritionRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getNutritionRadioItem2 (){
    if(nutritionRadioItem2 ==null){

      nutritionRadioItem2  = new ACRadioButtonItem();

      nutritionRadioItem2 .setText("あり");

      nutritionRadioItem2 .setGroup(getNutritionRadio());

      addNutritionRadioItem2 ();
    }
    return nutritionRadioItem2 ;

  }

  /**
   * 経口移行体制ラジオグループを取得します。
   * @return 経口移行体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getOralSwitchRadio(){
    if(oralSwitchRadio==null){

      oralSwitchRadio = new ACClearableRadioButtonGroup();

      getOralSwitchRadioContainer().setText("経口移行体制");

      oralSwitchRadio.setBindPath("1510110");

      oralSwitchRadio.setModel(getOralSwitchRadioModel());

      oralSwitchRadio.setUseClearButton(false);

      addOralSwitchRadio();
    }
    return oralSwitchRadio;

  }

  /**
   * 経口移行体制ラジオグループコンテナを取得します。
   * @return 経口移行体制ラジオグループコンテナ
   */
  protected ACLabelContainer getOralSwitchRadioContainer(){
    if(oralSwitchRadioContainer==null){
      oralSwitchRadioContainer = new ACLabelContainer();
      oralSwitchRadioContainer.setFollowChildEnabled(true);
      oralSwitchRadioContainer.add(getOralSwitchRadio(), null);
    }
    return oralSwitchRadioContainer;
  }

  /**
   * 経口移行体制ラジオグループモデルを取得します。
   * @return 経口移行体制ラジオグループモデル
   */
  protected ACListModelAdapter getOralSwitchRadioModel(){
    if(oralSwitchRadioModel==null){
      oralSwitchRadioModel = new ACListModelAdapter();
      addOralSwitchRadioModel();
    }
    return oralSwitchRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getOralSwitchRadioItem1(){
    if(oralSwitchRadioItem1==null){

      oralSwitchRadioItem1 = new ACRadioButtonItem();

      oralSwitchRadioItem1.setText("なし");

      oralSwitchRadioItem1.setGroup(getOralSwitchRadio());

      addOralSwitchRadioItem1();
    }
    return oralSwitchRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getOralSwitchRadioItem2 (){
    if(oralSwitchRadioItem2 ==null){

      oralSwitchRadioItem2  = new ACRadioButtonItem();

      oralSwitchRadioItem2 .setText("あり");

      oralSwitchRadioItem2 .setGroup(getOralSwitchRadio());

      addOralSwitchRadioItem2 ();
    }
    return oralSwitchRadioItem2 ;

  }

  /**
   * 療養食体制ラジオグループを取得します。
   * @return 療養食体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getRecuperateDinnerRadio(){
    if(recuperateDinnerRadio==null){

      recuperateDinnerRadio = new ACClearableRadioButtonGroup();

      getRecuperateDinnerRadioContainer().setText("療養食体制");

      recuperateDinnerRadio.setBindPath("1510111");

      recuperateDinnerRadio.setModel(getRecuperateDinnerRadioModel());

      recuperateDinnerRadio.setUseClearButton(false);

      addRecuperateDinnerRadio();
    }
    return recuperateDinnerRadio;

  }

  /**
   * 療養食体制ラジオグループコンテナを取得します。
   * @return 療養食体制ラジオグループコンテナ
   */
  protected ACLabelContainer getRecuperateDinnerRadioContainer(){
    if(recuperateDinnerRadioContainer==null){
      recuperateDinnerRadioContainer = new ACLabelContainer();
      recuperateDinnerRadioContainer.setFollowChildEnabled(true);
      recuperateDinnerRadioContainer.add(getRecuperateDinnerRadio(), null);
    }
    return recuperateDinnerRadioContainer;
  }

  /**
   * 療養食体制ラジオグループモデルを取得します。
   * @return 療養食体制ラジオグループモデル
   */
  protected ACListModelAdapter getRecuperateDinnerRadioModel(){
    if(recuperateDinnerRadioModel==null){
      recuperateDinnerRadioModel = new ACListModelAdapter();
      addRecuperateDinnerRadioModel();
    }
    return recuperateDinnerRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getRecuperateDinnerRadioItem1(){
    if(recuperateDinnerRadioItem1==null){

      recuperateDinnerRadioItem1 = new ACRadioButtonItem();

      recuperateDinnerRadioItem1.setText("なし");

      recuperateDinnerRadioItem1.setGroup(getRecuperateDinnerRadio());

      addRecuperateDinnerRadioItem1();
    }
    return recuperateDinnerRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getRecuperateDinnerRadioItem2(){
    if(recuperateDinnerRadioItem2==null){

      recuperateDinnerRadioItem2 = new ACRadioButtonItem();

      recuperateDinnerRadioItem2.setText("あり");

      recuperateDinnerRadioItem2.setGroup(getRecuperateDinnerRadio());

      addRecuperateDinnerRadioItem2();
    }
    return recuperateDinnerRadioItem2;

  }

  /**
   * 人員減算ラジオグループを取得します。
   * @return 人員減算ラジオグループ
   */
  public ACClearableRadioButtonGroup getStaffLack(){
    if(staffLack==null){

      staffLack = new ACClearableRadioButtonGroup();

      getStaffLackContainer().setText("人員減算");

      staffLack.setBindPath("1510112");

      staffLack.setModel(getStaffLackModel());

      staffLack.setUseClearButton(false);

      addStaffLack();
    }
    return staffLack;

  }

  /**
   * 人員減算ラジオグループコンテナを取得します。
   * @return 人員減算ラジオグループコンテナ
   */
  protected ACLabelContainer getStaffLackContainer(){
    if(staffLackContainer==null){
      staffLackContainer = new ACLabelContainer();
      staffLackContainer.setFollowChildEnabled(true);
      staffLackContainer.add(getStaffLack(), null);
    }
    return staffLackContainer;
  }

  /**
   * 人員減算ラジオグループモデルを取得します。
   * @return 人員減算ラジオグループモデル
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
  public ACRadioButtonItem getStaffLackOff(){
    if(staffLackOff==null){

      staffLackOff = new ACRadioButtonItem();

      staffLackOff.setText("なし");

      staffLackOff.setGroup(getStaffLack());

      addStaffLackOff();
    }
    return staffLackOff;

  }

  /**
   * 定員超過を取得します。
   * @return 定員超過
   */
  public ACRadioButtonItem getStaffLackStaffExcess(){
    if(staffLackStaffExcess==null){

      staffLackStaffExcess = new ACRadioButtonItem();

      staffLackStaffExcess.setText("定員超過");

      staffLackStaffExcess.setGroup(getStaffLack());

      addStaffLackStaffExcess();
    }
    return staffLackStaffExcess;

  }

  /**
   * 看護・介護職員又は介護支援専門員の不足を取得します。
   * @return 看護・介護職員又は介護支援専門員の不足
   */
  public ACRadioButtonItem getStaffLackKaigo(){
    if(staffLackKaigo==null){

      staffLackKaigo = new ACRadioButtonItem();

      staffLackKaigo.setText("看護・介護職員又は介護支援専門員の不足");

      staffLackKaigo.setGroup(getStaffLack());

      addStaffLackKaigo();
    }
    return staffLackKaigo;

  }

  /**
   * 食費基準額・コンテナを取得します。
   * @return 食費基準額・コンテナ
   */
  public ACLabelContainer getCareOldPepleWelfareFacilitiesDinnerStandeirdMoneyConteiner(){
    if(careOldPepleWelfareFacilitiesDinnerStandeirdMoneyConteiner==null){

      careOldPepleWelfareFacilitiesDinnerStandeirdMoneyConteiner = new ACLabelContainer();

      careOldPepleWelfareFacilitiesDinnerStandeirdMoneyConteiner.setText("食費基準額");

      careOldPepleWelfareFacilitiesDinnerStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addCareOldPepleWelfareFacilitiesDinnerStandeirdMoneyConteiner();
    }
    return careOldPepleWelfareFacilitiesDinnerStandeirdMoneyConteiner;

  }

  /**
   * 食費基準額・合計・テキストを取得します。
   * @return 食費基準額・合計・テキスト
   */
  public ACTextField getCareOldPepleWelfareFacilitiesDinnerStandeirdMoneyTotal(){
    if(careOldPepleWelfareFacilitiesDinnerStandeirdMoneyTotal==null){

      careOldPepleWelfareFacilitiesDinnerStandeirdMoneyTotal = new ACTextField();

      careOldPepleWelfareFacilitiesDinnerStandeirdMoneyTotal.setBindPath("1510113");

      careOldPepleWelfareFacilitiesDinnerStandeirdMoneyTotal.setEditable(false);

      careOldPepleWelfareFacilitiesDinnerStandeirdMoneyTotal.setColumns(4);

      careOldPepleWelfareFacilitiesDinnerStandeirdMoneyTotal.setCharType(VRCharType.ONLY_DIGIT);

      careOldPepleWelfareFacilitiesDinnerStandeirdMoneyTotal.setHorizontalAlignment(SwingConstants.RIGHT);

      careOldPepleWelfareFacilitiesDinnerStandeirdMoneyTotal.setIMEMode(InputSubset.LATIN);

      careOldPepleWelfareFacilitiesDinnerStandeirdMoneyTotal.setMaxLength(4);

      addCareOldPepleWelfareFacilitiesDinnerStandeirdMoneyTotal();
    }
    return careOldPepleWelfareFacilitiesDinnerStandeirdMoneyTotal;

  }

  /**
   * 食費基準額・朝・ラベルを取得します。
   * @return 食費基準額・朝・ラベル
   */
  public ACLabel getCareOldPepleWelfareFacilitiesMorningDinnerStandeirdMoneyLabel(){
    if(careOldPepleWelfareFacilitiesMorningDinnerStandeirdMoneyLabel==null){

      careOldPepleWelfareFacilitiesMorningDinnerStandeirdMoneyLabel = new ACLabel();

      careOldPepleWelfareFacilitiesMorningDinnerStandeirdMoneyLabel.setText("　朝");

      addCareOldPepleWelfareFacilitiesMorningDinnerStandeirdMoneyLabel();
    }
    return careOldPepleWelfareFacilitiesMorningDinnerStandeirdMoneyLabel;

  }

  /**
   * 食費基準額・朝・テキストを取得します。
   * @return 食費基準額・朝・テキスト
   */
  public ACTextField getCareOldPepleWelfareFacilitiesMorningDinnerStandeirdMoney(){
    if(careOldPepleWelfareFacilitiesMorningDinnerStandeirdMoney==null){

      careOldPepleWelfareFacilitiesMorningDinnerStandeirdMoney = new ACTextField();

      careOldPepleWelfareFacilitiesMorningDinnerStandeirdMoney.setBindPath("1510114");

      careOldPepleWelfareFacilitiesMorningDinnerStandeirdMoney.setColumns(3);

      careOldPepleWelfareFacilitiesMorningDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      careOldPepleWelfareFacilitiesMorningDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      careOldPepleWelfareFacilitiesMorningDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      careOldPepleWelfareFacilitiesMorningDinnerStandeirdMoney.setMaxLength(3);

      addCareOldPepleWelfareFacilitiesMorningDinnerStandeirdMoney();
    }
    return careOldPepleWelfareFacilitiesMorningDinnerStandeirdMoney;

  }

  /**
   * 食費基準額・昼・ラベルを取得します。
   * @return 食費基準額・昼・ラベル
   */
  public ACLabel getCareOldPepleWelfareFacilitiesNoonDinnerStandeirdMoneyLabel(){
    if(careOldPepleWelfareFacilitiesNoonDinnerStandeirdMoneyLabel==null){

      careOldPepleWelfareFacilitiesNoonDinnerStandeirdMoneyLabel = new ACLabel();

      careOldPepleWelfareFacilitiesNoonDinnerStandeirdMoneyLabel.setText("昼");

      addCareOldPepleWelfareFacilitiesNoonDinnerStandeirdMoneyLabel();
    }
    return careOldPepleWelfareFacilitiesNoonDinnerStandeirdMoneyLabel;

  }

  /**
   * 食費基準額・昼・テキストを取得します。
   * @return 食費基準額・昼・テキスト
   */
  public ACTextField getCareOldPepleWelfareFacilitiesNoonDinnerStandeirdMoney(){
    if(careOldPepleWelfareFacilitiesNoonDinnerStandeirdMoney==null){

      careOldPepleWelfareFacilitiesNoonDinnerStandeirdMoney = new ACTextField();

      careOldPepleWelfareFacilitiesNoonDinnerStandeirdMoney.setBindPath("1510115");

      careOldPepleWelfareFacilitiesNoonDinnerStandeirdMoney.setColumns(3);

      careOldPepleWelfareFacilitiesNoonDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      careOldPepleWelfareFacilitiesNoonDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      careOldPepleWelfareFacilitiesNoonDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      careOldPepleWelfareFacilitiesNoonDinnerStandeirdMoney.setMaxLength(3);

      addCareOldPepleWelfareFacilitiesNoonDinnerStandeirdMoney();
    }
    return careOldPepleWelfareFacilitiesNoonDinnerStandeirdMoney;

  }

  /**
   * 食費基準額・夜・ラベルを取得します。
   * @return 食費基準額・夜・ラベル
   */
  public ACLabel getCareOldPepleWelfareFacilitiesNightDinnerStandeirdMoneyLabel(){
    if(careOldPepleWelfareFacilitiesNightDinnerStandeirdMoneyLabel==null){

      careOldPepleWelfareFacilitiesNightDinnerStandeirdMoneyLabel = new ACLabel();

      careOldPepleWelfareFacilitiesNightDinnerStandeirdMoneyLabel.setText("夜");

      addCareOldPepleWelfareFacilitiesNightDinnerStandeirdMoneyLabel();
    }
    return careOldPepleWelfareFacilitiesNightDinnerStandeirdMoneyLabel;

  }

  /**
   * 食費基準額・夜・テキストを取得します。
   * @return 食費基準額・夜・テキスト
   */
  public ACTextField getCareOldPepleWelfareFacilitiesNightDinnerStandeirdMoney(){
    if(careOldPepleWelfareFacilitiesNightDinnerStandeirdMoney==null){

      careOldPepleWelfareFacilitiesNightDinnerStandeirdMoney = new ACTextField();

      careOldPepleWelfareFacilitiesNightDinnerStandeirdMoney.setBindPath("1510116");

      careOldPepleWelfareFacilitiesNightDinnerStandeirdMoney.setColumns(3);

      careOldPepleWelfareFacilitiesNightDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      careOldPepleWelfareFacilitiesNightDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      careOldPepleWelfareFacilitiesNightDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      careOldPepleWelfareFacilitiesNightDinnerStandeirdMoney.setMaxLength(3);

      addCareOldPepleWelfareFacilitiesNightDinnerStandeirdMoney();
    }
    return careOldPepleWelfareFacilitiesNightDinnerStandeirdMoney;

  }

  /**
   * 食費基準額・ラベルを取得します。
   * @return 食費基準額・ラベル
   */
  public ACLabel getCareOldPepleWelfareFacilitiesDinnerStandeirdMoney4Label(){
    if(careOldPepleWelfareFacilitiesDinnerStandeirdMoney4Label==null){

      careOldPepleWelfareFacilitiesDinnerStandeirdMoney4Label = new ACLabel();

      careOldPepleWelfareFacilitiesDinnerStandeirdMoney4Label.setText("（円）");

      addCareOldPepleWelfareFacilitiesDinnerStandeirdMoney4Label();
    }
    return careOldPepleWelfareFacilitiesDinnerStandeirdMoney4Label;

  }

  /**
   * ユニット型個室基準額・コンテナを取得します。
   * @return ユニット型個室基準額・コンテナ
   */
  public ACLabelContainer getCareOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyConteiner(){
    if(careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyConteiner==null){

      careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyConteiner = new ACLabelContainer();

      careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyConteiner.setText("ユニット型個室基準額");

      careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addCareOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyConteiner();
    }
    return careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyConteiner;

  }

  /**
   * ユニット型個室基準額・テキストを取得します。
   * @return ユニット型個室基準額・テキスト
   */
  public ACTextField getCareOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyText(){
    if(careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyText==null){

      careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyText = new ACTextField();

      careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyText.setBindPath("1510117");

      careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyText.setColumns(4);

      careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyText.setMaxLength(4);

      addCareOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyText();
    }
    return careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyText;

  }

  /**
   * ユニット型個室基準額・ラベルを取得します。
   * @return ユニット型個室基準額・ラベル
   */
  public ACLabel getCareOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyLabel(){
    if(careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyLabel==null){

      careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyLabel = new ACLabel();

      careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyLabel.setText("（円）");

      addCareOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyLabel();
    }
    return careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyLabel;

  }

  /**
   * ユニット型準個室基準額・コンテナを取得します。
   * @return ユニット型準個室基準額・コンテナ
   */
  public ACLabelContainer getCareOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyConteiner(){
    if(careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyConteiner==null){

      careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyConteiner = new ACLabelContainer();

      careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyConteiner.setText("ユニット型準個室基準額");

      careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addCareOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyConteiner();
    }
    return careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyConteiner;

  }

  /**
   * ユニット型準個室基準額・テキストを取得します。
   * @return ユニット型準個室基準額・テキスト
   */
  public ACTextField getCareOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyText(){
    if(careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyText==null){

      careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyText = new ACTextField();

      careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyText.setBindPath("1510118");

      careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyText.setColumns(4);

      careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyText.setMaxLength(4);

      addCareOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyText();
    }
    return careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyText;

  }

  /**
   * ユニット型準個室基準額・ラベルを取得します。
   * @return ユニット型準個室基準額・ラベル
   */
  public ACLabel getCareOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyLabel(){
    if(careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyLabel==null){

      careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyLabel = new ACLabel();

      careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyLabel.setText("（円）");

      addCareOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyLabel();
    }
    return careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyLabel;

  }

  /**
   * 従来型個室基準額・コンテナを取得します。
   * @return 従来型個室基準額・コンテナ
   */
  public ACLabelContainer getCareOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyConteiner(){
    if(careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyConteiner==null){

      careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyConteiner = new ACLabelContainer();

      careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyConteiner.setText("従来型個室基準額");

      careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addCareOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyConteiner();
    }
    return careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyConteiner;

  }

  /**
   * 従来型個室基準額・テキストを取得します。
   * @return 従来型個室基準額・テキスト
   */
  public ACTextField getCareOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyText(){
    if(careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyText==null){

      careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyText = new ACTextField();

      careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyText.setBindPath("1510119");

      careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyText.setColumns(4);

      careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyText.setMaxLength(4);

      addCareOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyText();
    }
    return careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyText;

  }

  /**
   * 従来型個室基準額・ラベルを取得します。
   * @return 従来型個室基準額・ラベル
   */
  public ACLabel getCareOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyLabel(){
    if(careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyLabel==null){

      careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyLabel = new ACLabel();

      careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyLabel.setText("（円）");

      addCareOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyLabel();
    }
    return careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyLabel;

  }

  /**
   * 多床室基準額・コンテナを取得します。
   * @return 多床室基準額・コンテナ
   */
  public ACLabelContainer getCareOldPepleWelfareFacilitiesTasyouRoomConteiner(){
    if(careOldPepleWelfareFacilitiesTasyouRoomConteiner==null){

      careOldPepleWelfareFacilitiesTasyouRoomConteiner = new ACLabelContainer();

      careOldPepleWelfareFacilitiesTasyouRoomConteiner.setText("多床室基準額");

      careOldPepleWelfareFacilitiesTasyouRoomConteiner.setFollowChildEnabled(true);

      addCareOldPepleWelfareFacilitiesTasyouRoomConteiner();
    }
    return careOldPepleWelfareFacilitiesTasyouRoomConteiner;

  }

  /**
   * 多床室基準額・テキストを取得します。
   * @return 多床室基準額・テキスト
   */
  public ACTextField getCareOldPepleWelfareFacilitiesTasyouRoomText(){
    if(careOldPepleWelfareFacilitiesTasyouRoomText==null){

      careOldPepleWelfareFacilitiesTasyouRoomText = new ACTextField();

      careOldPepleWelfareFacilitiesTasyouRoomText.setBindPath("1510120");

      careOldPepleWelfareFacilitiesTasyouRoomText.setColumns(4);

      careOldPepleWelfareFacilitiesTasyouRoomText.setCharType(VRCharType.ONLY_DIGIT);

      careOldPepleWelfareFacilitiesTasyouRoomText.setHorizontalAlignment(SwingConstants.RIGHT);

      careOldPepleWelfareFacilitiesTasyouRoomText.setIMEMode(InputSubset.LATIN);

      careOldPepleWelfareFacilitiesTasyouRoomText.setMaxLength(4);

      addCareOldPepleWelfareFacilitiesTasyouRoomText();
    }
    return careOldPepleWelfareFacilitiesTasyouRoomText;

  }

  /**
   * 多床室基準額・ラベルを取得します。
   * @return 多床室基準額・ラベル
   */
  public ACLabel getCareOldPepleWelfareFacilitiesTasyouRoomLabel(){
    if(careOldPepleWelfareFacilitiesTasyouRoomLabel==null){

      careOldPepleWelfareFacilitiesTasyouRoomLabel = new ACLabel();

      careOldPepleWelfareFacilitiesTasyouRoomLabel.setText("（円）");

      addCareOldPepleWelfareFacilitiesTasyouRoomLabel();
    }
    return careOldPepleWelfareFacilitiesTasyouRoomLabel;

  }

  /**
   * コンストラクタです。
   */
  public QO004016Design() {

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

    this.add(getAgedPeopleWelfareFacilityGroup(), VRLayout.CLIENT);

  }

  /**
   * 事業グループに内部項目を追加します。
   */
  protected void addAgedPeopleWelfareFacilityGroup(){

    agedPeopleWelfareFacilityGroup.add(getAgedPeopleWelfareFacilityDiscountcontainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleWelfareFacilityGroup.add(getAgedPeopleWelfareFacilitiesDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleWelfareFacilityGroup.add(getNightShiftConditionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleWelfareFacilityGroup.add(getFunctionTrainingGuidanceSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleWelfareFacilityGroup.add(getStandingDoctorArrangementContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleWelfareFacilityGroup.add(getPsychiatristMasterContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleWelfareFacilityGroup.add(getHandicappedPersonSupportContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleWelfareFacilityGroup.add(getNutritionManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleWelfareFacilityGroup.add(getNutritionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleWelfareFacilityGroup.add(getOralSwitchRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleWelfareFacilityGroup.add(getRecuperateDinnerRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleWelfareFacilityGroup.add(getStaffLackContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleWelfareFacilityGroup.add(getCareOldPepleWelfareFacilitiesDinnerStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleWelfareFacilityGroup.add(getCareOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleWelfareFacilityGroup.add(getCareOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleWelfareFacilityGroup.add(getCareOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleWelfareFacilityGroup.add(getCareOldPepleWelfareFacilitiesTasyouRoomConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 割引率コンテナに内部項目を追加します。
   */
  protected void addAgedPeopleWelfareFacilityDiscountcontainer(){

    agedPeopleWelfareFacilityDiscountcontainer.add(getAgedPeopleWelfareFacilityDiscountRate(), VRLayout.FLOW);

    agedPeopleWelfareFacilityDiscountcontainer.add(getPercentSign(), VRLayout.FLOW);

  }

  /**
   * 割引率に内部項目を追加します。
   */
  protected void addAgedPeopleWelfareFacilityDiscountRate(){

  }

  /**
   * ％ラベルに内部項目を追加します。
   */
  protected void addPercentSign(){

  }

  /**
   * 施設区分ラジオグループに内部項目を追加します。
   */
  protected void addAgedPeopleWelfareFacilitiesDivision(){

  }

  /**
   * 施設区分ラジオグループモデルに内部項目を追加します。
   */
  protected void addAgedPeopleWelfareFacilitiesDivisionModel(){

    getWelfareFacility1().setButtonIndex(1);
    getAgedPeopleWelfareFacilitiesDivisionModel().add(getWelfareFacility1());

    getWelfareFacility2().setButtonIndex(2);
    getAgedPeopleWelfareFacilitiesDivisionModel().add(getWelfareFacility2());

    getWelfareFacility3().setButtonIndex(3);
    getAgedPeopleWelfareFacilitiesDivisionModel().add(getWelfareFacility3());

    getWelfareFacility4().setButtonIndex(4);
    getAgedPeopleWelfareFacilitiesDivisionModel().add(getWelfareFacility4());

  }

  /**
   * 施設等の区分ラジオグループレイアウトに内部項目を追加します。
   */
  protected void addAgedPeopleWelfareFacilitiesDivisionLayout(){

  }

  /**
   * 介護福祉施設に内部項目を追加します。
   */
  protected void addWelfareFacility1(){

  }

  /**
   * 小規模介護福祉施設に内部項目を追加します。
   */
  protected void addWelfareFacility2(){

  }

  /**
   * ユニット型介護福祉施設に内部項目を追加します。
   */
  protected void addWelfareFacility3(){

  }

  /**
   * ユニット型小規模介護福祉施設に内部項目を追加します。
   */
  protected void addWelfareFacility4(){

  }

  /**
   * 夜間勤務条件基準ラジオグループに内部項目を追加します。
   */
  protected void addNightShiftCondition(){

  }

  /**
   * 夜間勤務条件基準ラジオグループモデルに内部項目を追加します。
   */
  protected void addNightShiftConditionModel(){

    getNightShiftConditionStandard().setButtonIndex(1);
    getNightShiftConditionModel().add(getNightShiftConditionStandard());

    getNightShiftConditionSubtraction().setButtonIndex(2);
    getNightShiftConditionModel().add(getNightShiftConditionSubtraction());

  }

  /**
   * 基準型に内部項目を追加します。
   */
  protected void addNightShiftConditionStandard(){

  }

  /**
   * 減算型に内部項目を追加します。
   */
  protected void addNightShiftConditionSubtraction(){

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

    getFunctionTrainingGuidanceSystemOff().setButtonIndex(1);
    getFunctionTrainingGuidanceSystemModel().add(getFunctionTrainingGuidanceSystemOff());

    getFunctionTrainingGuidanceSystemOn().setButtonIndex(2);
    getFunctionTrainingGuidanceSystemModel().add(getFunctionTrainingGuidanceSystemOn());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addFunctionTrainingGuidanceSystemOff(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addFunctionTrainingGuidanceSystemOn(){

  }

  /**
   * 常勤専従医師配置ラジオグループに内部項目を追加します。
   */
  protected void addStandingDoctorArrangement(){

  }

  /**
   * 常勤専従医師配置ラジオグループモデルに内部項目を追加します。
   */
  protected void addStandingDoctorArrangementModel(){

    getStandingDoctorArrangementOff().setButtonIndex(1);
    getStandingDoctorArrangementModel().add(getStandingDoctorArrangementOff());

    getStandingDoctorArrangementOn().setButtonIndex(2);
    getStandingDoctorArrangementModel().add(getStandingDoctorArrangementOn());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addStandingDoctorArrangementOff(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addStandingDoctorArrangementOn(){

  }

  /**
   * 精神科医師定期的療養指導ラジオグループに内部項目を追加します。
   */
  protected void addPsychiatristMaster(){

  }

  /**
   * 精神科医師定期的療養指導ラジオグループモデルに内部項目を追加します。
   */
  protected void addPsychiatristMasterModel(){

    getPsychiatristMasterOff().setButtonIndex(1);
    getPsychiatristMasterModel().add(getPsychiatristMasterOff());

    getPsychiatristMasterOn().setButtonIndex(2);
    getPsychiatristMasterModel().add(getPsychiatristMasterOn());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addPsychiatristMasterOff(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addPsychiatristMasterOn(){

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

    getHandicappedPersonSupportOff().setButtonIndex(1);
    getHandicappedPersonSupportModel().add(getHandicappedPersonSupportOff());

    getHandicappedPersonSupportOn().setButtonIndex(2);
    getHandicappedPersonSupportModel().add(getHandicappedPersonSupportOn());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHandicappedPersonSupportOff(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHandicappedPersonSupportOn(){

  }

  /**
   * 栄養管理体制ラジオグループに内部項目を追加します。
   */
  protected void addNutritionManageRadio(){

  }

  /**
   * 栄養管理体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addNutritionManageRadioModel(){

    getNutritionManageRadioItem1().setButtonIndex(1);
    getNutritionManageRadioModel().add(getNutritionManageRadioItem1());

    getNutritionManageRadioItem2().setButtonIndex(2);
    getNutritionManageRadioModel().add(getNutritionManageRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addNutritionManageRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addNutritionManageRadioItem2(){

  }

  /**
   * 栄養マネジメント体制ラジオグループに内部項目を追加します。
   */
  protected void addNutritionRadio(){

  }

  /**
   * 栄養マネジメント体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addNutritionRadioModel(){

    getNutritionRadioItem1().setButtonIndex(1);
    getNutritionRadioModel().add(getNutritionRadioItem1());

    getNutritionRadioItem2 ().setButtonIndex(2);
    getNutritionRadioModel().add(getNutritionRadioItem2 ());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addNutritionRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addNutritionRadioItem2 (){

  }

  /**
   * 経口移行体制ラジオグループに内部項目を追加します。
   */
  protected void addOralSwitchRadio(){

  }

  /**
   * 経口移行体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addOralSwitchRadioModel(){

    getOralSwitchRadioItem1().setButtonIndex(1);
    getOralSwitchRadioModel().add(getOralSwitchRadioItem1());

    getOralSwitchRadioItem2 ().setButtonIndex(2);
    getOralSwitchRadioModel().add(getOralSwitchRadioItem2 ());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addOralSwitchRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addOralSwitchRadioItem2 (){

  }

  /**
   * 療養食体制ラジオグループに内部項目を追加します。
   */
  protected void addRecuperateDinnerRadio(){

  }

  /**
   * 療養食体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addRecuperateDinnerRadioModel(){

    getRecuperateDinnerRadioItem1().setButtonIndex(1);
    getRecuperateDinnerRadioModel().add(getRecuperateDinnerRadioItem1());

    getRecuperateDinnerRadioItem2().setButtonIndex(2);
    getRecuperateDinnerRadioModel().add(getRecuperateDinnerRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addRecuperateDinnerRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addRecuperateDinnerRadioItem2(){

  }

  /**
   * 人員減算ラジオグループに内部項目を追加します。
   */
  protected void addStaffLack(){

  }

  /**
   * 人員減算ラジオグループモデルに内部項目を追加します。
   */
  protected void addStaffLackModel(){

    getStaffLackOff().setButtonIndex(1);
    getStaffLackModel().add(getStaffLackOff());

    getStaffLackStaffExcess().setButtonIndex(2);
    getStaffLackModel().add(getStaffLackStaffExcess());

    getStaffLackKaigo().setButtonIndex(3);
    getStaffLackModel().add(getStaffLackKaigo());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addStaffLackOff(){

  }

  /**
   * 定員超過に内部項目を追加します。
   */
  protected void addStaffLackStaffExcess(){

  }

  /**
   * 看護・介護職員又は介護支援専門員の不足に内部項目を追加します。
   */
  protected void addStaffLackKaigo(){

  }

  /**
   * 食費基準額・コンテナに内部項目を追加します。
   */
  protected void addCareOldPepleWelfareFacilitiesDinnerStandeirdMoneyConteiner(){

    careOldPepleWelfareFacilitiesDinnerStandeirdMoneyConteiner.add(getCareOldPepleWelfareFacilitiesDinnerStandeirdMoneyTotal(), VRLayout.FLOW);

    careOldPepleWelfareFacilitiesDinnerStandeirdMoneyConteiner.add(getCareOldPepleWelfareFacilitiesMorningDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    careOldPepleWelfareFacilitiesDinnerStandeirdMoneyConteiner.add(getCareOldPepleWelfareFacilitiesMorningDinnerStandeirdMoney(), VRLayout.FLOW);

    careOldPepleWelfareFacilitiesDinnerStandeirdMoneyConteiner.add(getCareOldPepleWelfareFacilitiesNoonDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    careOldPepleWelfareFacilitiesDinnerStandeirdMoneyConteiner.add(getCareOldPepleWelfareFacilitiesNoonDinnerStandeirdMoney(), VRLayout.FLOW);

    careOldPepleWelfareFacilitiesDinnerStandeirdMoneyConteiner.add(getCareOldPepleWelfareFacilitiesNightDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    careOldPepleWelfareFacilitiesDinnerStandeirdMoneyConteiner.add(getCareOldPepleWelfareFacilitiesNightDinnerStandeirdMoney(), VRLayout.FLOW);

    careOldPepleWelfareFacilitiesDinnerStandeirdMoneyConteiner.add(getCareOldPepleWelfareFacilitiesDinnerStandeirdMoney4Label(), VRLayout.FLOW);

  }

  /**
   * 食費基準額・合計・テキストに内部項目を追加します。
   */
  protected void addCareOldPepleWelfareFacilitiesDinnerStandeirdMoneyTotal(){

  }

  /**
   * 食費基準額・朝・ラベルに内部項目を追加します。
   */
  protected void addCareOldPepleWelfareFacilitiesMorningDinnerStandeirdMoneyLabel(){

  }

  /**
   * 食費基準額・朝・テキストに内部項目を追加します。
   */
  protected void addCareOldPepleWelfareFacilitiesMorningDinnerStandeirdMoney(){

  }

  /**
   * 食費基準額・昼・ラベルに内部項目を追加します。
   */
  protected void addCareOldPepleWelfareFacilitiesNoonDinnerStandeirdMoneyLabel(){

  }

  /**
   * 食費基準額・昼・テキストに内部項目を追加します。
   */
  protected void addCareOldPepleWelfareFacilitiesNoonDinnerStandeirdMoney(){

  }

  /**
   * 食費基準額・夜・ラベルに内部項目を追加します。
   */
  protected void addCareOldPepleWelfareFacilitiesNightDinnerStandeirdMoneyLabel(){

  }

  /**
   * 食費基準額・夜・テキストに内部項目を追加します。
   */
  protected void addCareOldPepleWelfareFacilitiesNightDinnerStandeirdMoney(){

  }

  /**
   * 食費基準額・ラベルに内部項目を追加します。
   */
  protected void addCareOldPepleWelfareFacilitiesDinnerStandeirdMoney4Label(){

  }

  /**
   * ユニット型個室基準額・コンテナに内部項目を追加します。
   */
  protected void addCareOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyConteiner(){

    careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyConteiner.add(getCareOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyText(), null);

    careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyConteiner.add(getCareOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyLabel(), null);

  }

  /**
   * ユニット型個室基準額・テキストに内部項目を追加します。
   */
  protected void addCareOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyText(){

  }

  /**
   * ユニット型個室基準額・ラベルに内部項目を追加します。
   */
  protected void addCareOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyLabel(){

  }

  /**
   * ユニット型準個室基準額・コンテナに内部項目を追加します。
   */
  protected void addCareOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyConteiner(){

    careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyConteiner.add(getCareOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyText(), null);

    careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyConteiner.add(getCareOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyLabel(), null);

  }

  /**
   * ユニット型準個室基準額・テキストに内部項目を追加します。
   */
  protected void addCareOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyText(){

  }

  /**
   * ユニット型準個室基準額・ラベルに内部項目を追加します。
   */
  protected void addCareOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyLabel(){

  }

  /**
   * 従来型個室基準額・コンテナに内部項目を追加します。
   */
  protected void addCareOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyConteiner(){

    careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyConteiner.add(getCareOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyText(), null);

    careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyConteiner.add(getCareOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyLabel(), null);

  }

  /**
   * 従来型個室基準額・テキストに内部項目を追加します。
   */
  protected void addCareOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyText(){

  }

  /**
   * 従来型個室基準額・ラベルに内部項目を追加します。
   */
  protected void addCareOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyLabel(){

  }

  /**
   * 多床室基準額・コンテナに内部項目を追加します。
   */
  protected void addCareOldPepleWelfareFacilitiesTasyouRoomConteiner(){

    careOldPepleWelfareFacilitiesTasyouRoomConteiner.add(getCareOldPepleWelfareFacilitiesTasyouRoomText(), null);

    careOldPepleWelfareFacilitiesTasyouRoomConteiner.add(getCareOldPepleWelfareFacilitiesTasyouRoomLabel(), null);

  }

  /**
   * 多床室基準額・テキストに内部項目を追加します。
   */
  protected void addCareOldPepleWelfareFacilitiesTasyouRoomText(){

  }

  /**
   * 多床室基準額・ラベルに内部項目を追加します。
   */
  protected void addCareOldPepleWelfareFacilitiesTasyouRoomLabel(){

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
      ACFrame.getInstance().getContentPane().add(new QO004016Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004016Design getThis() {
    return this;
  }
}
