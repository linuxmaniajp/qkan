
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
 * プログラム 介護老人保健施設 (QO004017)
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
 * 介護老人保健施設画面項目デザイン(QO004017) 
 */
public class QO004017Design extends ACPanel {
  //GUIコンポーネント

  private ACGroupBox agedPeopleHealthFacilityGroup;

  private ACLabelContainer agedPeopleHealthFacilityDiscountContainer;

  private ACTextField agedPeopleHealthFacilityDiscountRate;

  private ACLabel percentSign;

  private ACClearableRadioButtonGroup institutionDivisionRadio;

  private ACLabelContainer institutionDivisionRadioContainer;

  private ACListModelAdapter institutionDivisionRadioModel;

  private ACRadioButtonItem institutionDivisionRadioItem1;

  private ACRadioButtonItem institutionDivisionRadioItem2;

  private ACClearableRadioButtonGroup nightShiftCondition;

  private ACLabelContainer nightShiftConditionContainer;

  private ACListModelAdapter nightShiftConditionModel;

  private ACRadioButtonItem nightShiftConditionStandard;

  private ACRadioButtonItem nightShiftConditionSubtraction;

  private ACClearableRadioButtonGroup rehabilitationFunctionalEnhancement;

  private ACLabelContainer rehabilitationFunctionalEnhancementContainer;

  private ACListModelAdapter rehabilitationFunctionalEnhancementModel;

  private ACRadioButtonItem rehabilitationFunctionalEnhancementOff;

  private ACRadioButtonItem rehabilitationFunctionalEnhancementOn;

  private ACClearableRadioButtonGroup dementiaSpecialBuilding;

  private ACLabelContainer dementiaSpecialBuildingContainer;

  private ACListModelAdapter dementiaSpecialBuildingModel;

  private ACRadioButtonItem dementiaSpecialBuildingOff;

  private ACRadioButtonItem dementiaSpecialBuildingOn;

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

  private ACRadioButtonItem staffLackExcess;

  private ACRadioButtonItem staffLackKango;

  private ACLabelContainer careOldPeopleHealthFacilitiesDinnerStandeirdMoneyConteiner;

  private ACTextField careOldPeopleHealthFacilitiesDinnerStandeirdMoneyTotal;

  private ACLabel careOldPeopleHealthFacilitiesMorningDinnerStandeirdMoneyLabel;

  private ACTextField careOldPeopleHealthFacilitiesMorningDinnerStandeirdMoney;

  private ACLabel careOldPeopleHealthFacilitiesNoonDinnerStandeirdMoneyLabel;

  private ACTextField careOldPeopleHealthFacilitiesNoonDinnerStandeirdMoney;

  private ACLabel careOldPeopleHealthFacilitiesNightDinnerStandeirdMoneyLabel;

  private ACTextField careOldPeopleHealthFacilitiesNightDinnerStandeirdMoney;

  private ACLabel careOldPeopleHealthFacilitiesTotalDinnerStandeirdMoneyDenominationLabel;

  private ACLabelContainer careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyConteiner;

  private ACTextField careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyText;

  private ACLabel careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyLabel;

  private ACLabelContainer careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyConteiner;

  private ACTextField careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyText;

  private ACLabel careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyLabel;

  private ACLabelContainer careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyConteiner;

  private ACTextField careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyText;

  private ACLabel careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyLabel;

  private ACLabelContainer careOldPeopleHealthFacilitiesTasyouRoomConteiner;

  private ACTextField careOldPeopleHealthFacilitiesTasyouRoomText;

  private ACLabel careOldPeopleHealthFacilitiesTasyouRoomLabel;

  //getter

  /**
   * 事業グループを取得します。
   * @return 事業グループ
   */
  public ACGroupBox getAgedPeopleHealthFacilityGroup(){
    if(agedPeopleHealthFacilityGroup==null){

      agedPeopleHealthFacilityGroup = new ACGroupBox();

      agedPeopleHealthFacilityGroup.setText("介護老人保健施設");

      agedPeopleHealthFacilityGroup.setFollowChildEnabled(true);

      agedPeopleHealthFacilityGroup.setHgrid(200);

      addAgedPeopleHealthFacilityGroup();
    }
    return agedPeopleHealthFacilityGroup;

  }

  /**
   * 割引率コンテナを取得します。
   * @return 割引率コンテナ
   */
  public ACLabelContainer getAgedPeopleHealthFacilityDiscountContainer(){
    if(agedPeopleHealthFacilityDiscountContainer==null){

      agedPeopleHealthFacilityDiscountContainer = new ACLabelContainer();

      agedPeopleHealthFacilityDiscountContainer.setText("割引率");

      agedPeopleHealthFacilityDiscountContainer.setFollowChildEnabled(true);

      addAgedPeopleHealthFacilityDiscountContainer();
    }
    return agedPeopleHealthFacilityDiscountContainer;

  }

  /**
   * 割引率を取得します。
   * @return 割引率
   */
  public ACTextField getAgedPeopleHealthFacilityDiscountRate(){
    if(agedPeopleHealthFacilityDiscountRate==null){

      agedPeopleHealthFacilityDiscountRate = new ACTextField();

      agedPeopleHealthFacilityDiscountRate.setBindPath("REDUCT_RATE");

      agedPeopleHealthFacilityDiscountRate.setColumns(3);

      agedPeopleHealthFacilityDiscountRate.setCharType(VRCharType.ONLY_DIGIT);

      agedPeopleHealthFacilityDiscountRate.setHorizontalAlignment(SwingConstants.RIGHT);

      agedPeopleHealthFacilityDiscountRate.setIMEMode(InputSubset.LATIN);

      agedPeopleHealthFacilityDiscountRate.setMaxLength(3);

      addAgedPeopleHealthFacilityDiscountRate();
    }
    return agedPeopleHealthFacilityDiscountRate;

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
  public ACClearableRadioButtonGroup getInstitutionDivisionRadio(){
    if(institutionDivisionRadio==null){

      institutionDivisionRadio = new ACClearableRadioButtonGroup();

      getInstitutionDivisionRadioContainer().setText("施設区分");

      institutionDivisionRadio.setBindPath("1520101");

      institutionDivisionRadio.setModel(getInstitutionDivisionRadioModel());

      institutionDivisionRadio.setUseClearButton(false);

      addInstitutionDivisionRadio();
    }
    return institutionDivisionRadio;

  }

  /**
   * 施設区分ラジオグループコンテナを取得します。
   * @return 施設区分ラジオグループコンテナ
   */
  protected ACLabelContainer getInstitutionDivisionRadioContainer(){
    if(institutionDivisionRadioContainer==null){
      institutionDivisionRadioContainer = new ACLabelContainer();
      institutionDivisionRadioContainer.setFollowChildEnabled(true);
      institutionDivisionRadioContainer.add(getInstitutionDivisionRadio(), null);
    }
    return institutionDivisionRadioContainer;
  }

  /**
   * 施設区分ラジオグループモデルを取得します。
   * @return 施設区分ラジオグループモデル
   */
  protected ACListModelAdapter getInstitutionDivisionRadioModel(){
    if(institutionDivisionRadioModel==null){
      institutionDivisionRadioModel = new ACListModelAdapter();
      addInstitutionDivisionRadioModel();
    }
    return institutionDivisionRadioModel;
  }

  /**
   * 介護保健施設を取得します。
   * @return 介護保健施設
   */
  public ACRadioButtonItem getInstitutionDivisionRadioItem1(){
    if(institutionDivisionRadioItem1==null){

      institutionDivisionRadioItem1 = new ACRadioButtonItem();

      institutionDivisionRadioItem1.setText("介護保健施設");

      institutionDivisionRadioItem1.setGroup(getInstitutionDivisionRadio());

      addInstitutionDivisionRadioItem1();
    }
    return institutionDivisionRadioItem1;

  }

  /**
   * ユニット型介護保健施設を取得します。
   * @return ユニット型介護保健施設
   */
  public ACRadioButtonItem getInstitutionDivisionRadioItem2(){
    if(institutionDivisionRadioItem2==null){

      institutionDivisionRadioItem2 = new ACRadioButtonItem();

      institutionDivisionRadioItem2.setText("ユニット型介護保健施設");

      institutionDivisionRadioItem2.setGroup(getInstitutionDivisionRadio());

      addInstitutionDivisionRadioItem2();
    }
    return institutionDivisionRadioItem2;

  }

  /**
   * 夜間勤務条件基準ラジオグループを取得します。
   * @return 夜間勤務条件基準ラジオグループ
   */
  public ACClearableRadioButtonGroup getNightShiftCondition(){
    if(nightShiftCondition==null){

      nightShiftCondition = new ACClearableRadioButtonGroup();

      getNightShiftConditionContainer().setText("夜間勤務条件基準");

      nightShiftCondition.setBindPath("1520102");

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
   * リハビリテーション機能強化ラジオグループを取得します。
   * @return リハビリテーション機能強化ラジオグループ
   */
  public ACClearableRadioButtonGroup getRehabilitationFunctionalEnhancement(){
    if(rehabilitationFunctionalEnhancement==null){

      rehabilitationFunctionalEnhancement = new ACClearableRadioButtonGroup();

      getRehabilitationFunctionalEnhancementContainer().setText("リハビリテーション機能強化");

      rehabilitationFunctionalEnhancement.setBindPath("1520103");

      rehabilitationFunctionalEnhancement.setModel(getRehabilitationFunctionalEnhancementModel());

      rehabilitationFunctionalEnhancement.setUseClearButton(false);

      addRehabilitationFunctionalEnhancement();
    }
    return rehabilitationFunctionalEnhancement;

  }

  /**
   * リハビリテーション機能強化ラジオグループコンテナを取得します。
   * @return リハビリテーション機能強化ラジオグループコンテナ
   */
  protected ACLabelContainer getRehabilitationFunctionalEnhancementContainer(){
    if(rehabilitationFunctionalEnhancementContainer==null){
      rehabilitationFunctionalEnhancementContainer = new ACLabelContainer();
      rehabilitationFunctionalEnhancementContainer.setFollowChildEnabled(true);
      rehabilitationFunctionalEnhancementContainer.add(getRehabilitationFunctionalEnhancement(), null);
    }
    return rehabilitationFunctionalEnhancementContainer;
  }

  /**
   * リハビリテーション機能強化ラジオグループモデルを取得します。
   * @return リハビリテーション機能強化ラジオグループモデル
   */
  protected ACListModelAdapter getRehabilitationFunctionalEnhancementModel(){
    if(rehabilitationFunctionalEnhancementModel==null){
      rehabilitationFunctionalEnhancementModel = new ACListModelAdapter();
      addRehabilitationFunctionalEnhancementModel();
    }
    return rehabilitationFunctionalEnhancementModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getRehabilitationFunctionalEnhancementOff(){
    if(rehabilitationFunctionalEnhancementOff==null){

      rehabilitationFunctionalEnhancementOff = new ACRadioButtonItem();

      rehabilitationFunctionalEnhancementOff.setText("なし");

      rehabilitationFunctionalEnhancementOff.setGroup(getRehabilitationFunctionalEnhancement());

      addRehabilitationFunctionalEnhancementOff();
    }
    return rehabilitationFunctionalEnhancementOff;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getRehabilitationFunctionalEnhancementOn(){
    if(rehabilitationFunctionalEnhancementOn==null){

      rehabilitationFunctionalEnhancementOn = new ACRadioButtonItem();

      rehabilitationFunctionalEnhancementOn.setText("あり");

      rehabilitationFunctionalEnhancementOn.setGroup(getRehabilitationFunctionalEnhancement());

      addRehabilitationFunctionalEnhancementOn();
    }
    return rehabilitationFunctionalEnhancementOn;

  }

  /**
   * 認知症専門棟ラジオグループを取得します。
   * @return 認知症専門棟ラジオグループ
   */
  public ACClearableRadioButtonGroup getDementiaSpecialBuilding(){
    if(dementiaSpecialBuilding==null){

      dementiaSpecialBuilding = new ACClearableRadioButtonGroup();

      getDementiaSpecialBuildingContainer().setText("認知症専門棟");

      dementiaSpecialBuilding.setBindPath("1520104");

      dementiaSpecialBuilding.setModel(getDementiaSpecialBuildingModel());

      dementiaSpecialBuilding.setUseClearButton(false);

      addDementiaSpecialBuilding();
    }
    return dementiaSpecialBuilding;

  }

  /**
   * 認知症専門棟ラジオグループコンテナを取得します。
   * @return 認知症専門棟ラジオグループコンテナ
   */
  protected ACLabelContainer getDementiaSpecialBuildingContainer(){
    if(dementiaSpecialBuildingContainer==null){
      dementiaSpecialBuildingContainer = new ACLabelContainer();
      dementiaSpecialBuildingContainer.setFollowChildEnabled(true);
      dementiaSpecialBuildingContainer.add(getDementiaSpecialBuilding(), null);
    }
    return dementiaSpecialBuildingContainer;
  }

  /**
   * 認知症専門棟ラジオグループモデルを取得します。
   * @return 認知症専門棟ラジオグループモデル
   */
  protected ACListModelAdapter getDementiaSpecialBuildingModel(){
    if(dementiaSpecialBuildingModel==null){
      dementiaSpecialBuildingModel = new ACListModelAdapter();
      addDementiaSpecialBuildingModel();
    }
    return dementiaSpecialBuildingModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getDementiaSpecialBuildingOff(){
    if(dementiaSpecialBuildingOff==null){

      dementiaSpecialBuildingOff = new ACRadioButtonItem();

      dementiaSpecialBuildingOff.setText("なし");

      dementiaSpecialBuildingOff.setGroup(getDementiaSpecialBuilding());

      addDementiaSpecialBuildingOff();
    }
    return dementiaSpecialBuildingOff;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getDementiaSpecialBuildingOn(){
    if(dementiaSpecialBuildingOn==null){

      dementiaSpecialBuildingOn = new ACRadioButtonItem();

      dementiaSpecialBuildingOn.setText("あり");

      dementiaSpecialBuildingOn.setGroup(getDementiaSpecialBuilding());

      addDementiaSpecialBuildingOn();
    }
    return dementiaSpecialBuildingOn;

  }

  /**
   * 栄養管理体制ラジオグループを取得します。
   * @return 栄養管理体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getNutritionManageRadio(){
    if(nutritionManageRadio==null){

      nutritionManageRadio = new ACClearableRadioButtonGroup();

      getNutritionManageRadioContainer().setText("栄養管理体制");

      nutritionManageRadio.setBindPath("1520105");

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

      nutritionRadio.setBindPath("1520106");

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

      oralSwitchRadio.setBindPath("1520107");

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

      recuperateDinnerRadio.setBindPath("1520108");

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

      staffLack.setBindPath("1520109");

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
  public ACRadioButtonItem getStaffLackExcess(){
    if(staffLackExcess==null){

      staffLackExcess = new ACRadioButtonItem();

      staffLackExcess.setText("定員超過");

      staffLackExcess.setGroup(getStaffLack());

      addStaffLackExcess();
    }
    return staffLackExcess;

  }

  /**
   * 看護・介護職員又は医師、PT・OT、介護支援専門員の不足を取得します。
   * @return 看護・介護職員又は医師、PT・OT、介護支援専門員の不足
   */
  public ACRadioButtonItem getStaffLackKango(){
    if(staffLackKango==null){

      staffLackKango = new ACRadioButtonItem();

      staffLackKango.setText("看護・介護職員又は医師、PT・OT、介護支援専門員の不足");

      staffLackKango.setGroup(getStaffLack());

      addStaffLackKango();
    }
    return staffLackKango;

  }

  /**
   * 食費基準額・コンテナを取得します。
   * @return 食費基準額・コンテナ
   */
  public ACLabelContainer getCareOldPeopleHealthFacilitiesDinnerStandeirdMoneyConteiner(){
    if(careOldPeopleHealthFacilitiesDinnerStandeirdMoneyConteiner==null){

      careOldPeopleHealthFacilitiesDinnerStandeirdMoneyConteiner = new ACLabelContainer();

      careOldPeopleHealthFacilitiesDinnerStandeirdMoneyConteiner.setText("食費基準額");

      careOldPeopleHealthFacilitiesDinnerStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addCareOldPeopleHealthFacilitiesDinnerStandeirdMoneyConteiner();
    }
    return careOldPeopleHealthFacilitiesDinnerStandeirdMoneyConteiner;

  }

  /**
   * 食費基準額・合計・テキストを取得します。
   * @return 食費基準額・合計・テキスト
   */
  public ACTextField getCareOldPeopleHealthFacilitiesDinnerStandeirdMoneyTotal(){
    if(careOldPeopleHealthFacilitiesDinnerStandeirdMoneyTotal==null){

      careOldPeopleHealthFacilitiesDinnerStandeirdMoneyTotal = new ACTextField();

      careOldPeopleHealthFacilitiesDinnerStandeirdMoneyTotal.setBindPath("1520110");

      careOldPeopleHealthFacilitiesDinnerStandeirdMoneyTotal.setEditable(false);

      careOldPeopleHealthFacilitiesDinnerStandeirdMoneyTotal.setColumns(4);

      careOldPeopleHealthFacilitiesDinnerStandeirdMoneyTotal.setCharType(VRCharType.ONLY_DIGIT);

      careOldPeopleHealthFacilitiesDinnerStandeirdMoneyTotal.setHorizontalAlignment(SwingConstants.RIGHT);

      careOldPeopleHealthFacilitiesDinnerStandeirdMoneyTotal.setIMEMode(InputSubset.LATIN);

      careOldPeopleHealthFacilitiesDinnerStandeirdMoneyTotal.setMaxLength(4);

      addCareOldPeopleHealthFacilitiesDinnerStandeirdMoneyTotal();
    }
    return careOldPeopleHealthFacilitiesDinnerStandeirdMoneyTotal;

  }

  /**
   * 食費基準額・朝・ラベルを取得します。
   * @return 食費基準額・朝・ラベル
   */
  public ACLabel getCareOldPeopleHealthFacilitiesMorningDinnerStandeirdMoneyLabel(){
    if(careOldPeopleHealthFacilitiesMorningDinnerStandeirdMoneyLabel==null){

      careOldPeopleHealthFacilitiesMorningDinnerStandeirdMoneyLabel = new ACLabel();

      careOldPeopleHealthFacilitiesMorningDinnerStandeirdMoneyLabel.setText("　朝");

      addCareOldPeopleHealthFacilitiesMorningDinnerStandeirdMoneyLabel();
    }
    return careOldPeopleHealthFacilitiesMorningDinnerStandeirdMoneyLabel;

  }

  /**
   * 食費基準額・朝・テキストを取得します。
   * @return 食費基準額・朝・テキスト
   */
  public ACTextField getCareOldPeopleHealthFacilitiesMorningDinnerStandeirdMoney(){
    if(careOldPeopleHealthFacilitiesMorningDinnerStandeirdMoney==null){

      careOldPeopleHealthFacilitiesMorningDinnerStandeirdMoney = new ACTextField();

      careOldPeopleHealthFacilitiesMorningDinnerStandeirdMoney.setBindPath("1520111");

      careOldPeopleHealthFacilitiesMorningDinnerStandeirdMoney.setColumns(3);

      careOldPeopleHealthFacilitiesMorningDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      careOldPeopleHealthFacilitiesMorningDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      careOldPeopleHealthFacilitiesMorningDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      careOldPeopleHealthFacilitiesMorningDinnerStandeirdMoney.setMaxLength(3);

      addCareOldPeopleHealthFacilitiesMorningDinnerStandeirdMoney();
    }
    return careOldPeopleHealthFacilitiesMorningDinnerStandeirdMoney;

  }

  /**
   * 食費基準額・昼・ラベルを取得します。
   * @return 食費基準額・昼・ラベル
   */
  public ACLabel getCareOldPeopleHealthFacilitiesNoonDinnerStandeirdMoneyLabel(){
    if(careOldPeopleHealthFacilitiesNoonDinnerStandeirdMoneyLabel==null){

      careOldPeopleHealthFacilitiesNoonDinnerStandeirdMoneyLabel = new ACLabel();

      careOldPeopleHealthFacilitiesNoonDinnerStandeirdMoneyLabel.setText("昼");

      addCareOldPeopleHealthFacilitiesNoonDinnerStandeirdMoneyLabel();
    }
    return careOldPeopleHealthFacilitiesNoonDinnerStandeirdMoneyLabel;

  }

  /**
   * 食費基準額・昼・テキストを取得します。
   * @return 食費基準額・昼・テキスト
   */
  public ACTextField getCareOldPeopleHealthFacilitiesNoonDinnerStandeirdMoney(){
    if(careOldPeopleHealthFacilitiesNoonDinnerStandeirdMoney==null){

      careOldPeopleHealthFacilitiesNoonDinnerStandeirdMoney = new ACTextField();

      careOldPeopleHealthFacilitiesNoonDinnerStandeirdMoney.setBindPath("1520112");

      careOldPeopleHealthFacilitiesNoonDinnerStandeirdMoney.setColumns(3);

      careOldPeopleHealthFacilitiesNoonDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      careOldPeopleHealthFacilitiesNoonDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      careOldPeopleHealthFacilitiesNoonDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      careOldPeopleHealthFacilitiesNoonDinnerStandeirdMoney.setMaxLength(3);

      addCareOldPeopleHealthFacilitiesNoonDinnerStandeirdMoney();
    }
    return careOldPeopleHealthFacilitiesNoonDinnerStandeirdMoney;

  }

  /**
   * 食費基準額・夜・ラベルを取得します。
   * @return 食費基準額・夜・ラベル
   */
  public ACLabel getCareOldPeopleHealthFacilitiesNightDinnerStandeirdMoneyLabel(){
    if(careOldPeopleHealthFacilitiesNightDinnerStandeirdMoneyLabel==null){

      careOldPeopleHealthFacilitiesNightDinnerStandeirdMoneyLabel = new ACLabel();

      careOldPeopleHealthFacilitiesNightDinnerStandeirdMoneyLabel.setText("夜");

      addCareOldPeopleHealthFacilitiesNightDinnerStandeirdMoneyLabel();
    }
    return careOldPeopleHealthFacilitiesNightDinnerStandeirdMoneyLabel;

  }

  /**
   * 食費基準額・夜・テキストを取得します。
   * @return 食費基準額・夜・テキスト
   */
  public ACTextField getCareOldPeopleHealthFacilitiesNightDinnerStandeirdMoney(){
    if(careOldPeopleHealthFacilitiesNightDinnerStandeirdMoney==null){

      careOldPeopleHealthFacilitiesNightDinnerStandeirdMoney = new ACTextField();

      careOldPeopleHealthFacilitiesNightDinnerStandeirdMoney.setBindPath("1520113");

      careOldPeopleHealthFacilitiesNightDinnerStandeirdMoney.setColumns(3);

      careOldPeopleHealthFacilitiesNightDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      careOldPeopleHealthFacilitiesNightDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      careOldPeopleHealthFacilitiesNightDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      careOldPeopleHealthFacilitiesNightDinnerStandeirdMoney.setMaxLength(3);

      addCareOldPeopleHealthFacilitiesNightDinnerStandeirdMoney();
    }
    return careOldPeopleHealthFacilitiesNightDinnerStandeirdMoney;

  }

  /**
   * 食費基準額・ラベルを取得します。
   * @return 食費基準額・ラベル
   */
  public ACLabel getCareOldPeopleHealthFacilitiesTotalDinnerStandeirdMoneyDenominationLabel(){
    if(careOldPeopleHealthFacilitiesTotalDinnerStandeirdMoneyDenominationLabel==null){

      careOldPeopleHealthFacilitiesTotalDinnerStandeirdMoneyDenominationLabel = new ACLabel();

      careOldPeopleHealthFacilitiesTotalDinnerStandeirdMoneyDenominationLabel.setText("（円）");

      addCareOldPeopleHealthFacilitiesTotalDinnerStandeirdMoneyDenominationLabel();
    }
    return careOldPeopleHealthFacilitiesTotalDinnerStandeirdMoneyDenominationLabel;

  }

  /**
   * ユニット型個室基準額・コンテナを取得します。
   * @return ユニット型個室基準額・コンテナ
   */
  public ACLabelContainer getCareOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyConteiner(){
    if(careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyConteiner==null){

      careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyConteiner = new ACLabelContainer();

      careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyConteiner.setText("ユニット型個室基準額");

      careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addCareOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyConteiner();
    }
    return careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyConteiner;

  }

  /**
   * ユニット型個室基準額・テキストを取得します。
   * @return ユニット型個室基準額・テキスト
   */
  public ACTextField getCareOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyText(){
    if(careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyText==null){

      careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyText = new ACTextField();

      careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyText.setBindPath("1520114");

      careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyText.setColumns(4);

      careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyText.setMaxLength(4);

      addCareOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyText();
    }
    return careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyText;

  }

  /**
   * ユニット型個室基準額・ラベルを取得します。
   * @return ユニット型個室基準額・ラベル
   */
  public ACLabel getCareOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyLabel(){
    if(careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyLabel==null){

      careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyLabel = new ACLabel();

      careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyLabel.setText("（円）");

      addCareOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyLabel();
    }
    return careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyLabel;

  }

  /**
   * ユニット型準個室基準額・コンテナを取得します。
   * @return ユニット型準個室基準額・コンテナ
   */
  public ACLabelContainer getCareOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyConteiner(){
    if(careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyConteiner==null){

      careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyConteiner = new ACLabelContainer();

      careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyConteiner.setText("ユニット型準個室基準額");

      careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addCareOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyConteiner();
    }
    return careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyConteiner;

  }

  /**
   * ユニット型準個室基準額・テキストを取得します。
   * @return ユニット型準個室基準額・テキスト
   */
  public ACTextField getCareOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyText(){
    if(careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyText==null){

      careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyText = new ACTextField();

      careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyText.setBindPath("1520115");

      careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyText.setColumns(4);

      careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyText.setMaxLength(4);

      addCareOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyText();
    }
    return careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyText;

  }

  /**
   * ユニット型準個室基準額・ラベルを取得します。
   * @return ユニット型準個室基準額・ラベル
   */
  public ACLabel getCareOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyLabel(){
    if(careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyLabel==null){

      careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyLabel = new ACLabel();

      careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyLabel.setText("（円）");

      addCareOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyLabel();
    }
    return careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyLabel;

  }

  /**
   * 従来型個室基準額・コンテナを取得します。
   * @return 従来型個室基準額・コンテナ
   */
  public ACLabelContainer getCareOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyConteiner(){
    if(careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyConteiner==null){

      careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyConteiner = new ACLabelContainer();

      careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyConteiner.setText("従来型個室基準額");

      careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addCareOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyConteiner();
    }
    return careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyConteiner;

  }

  /**
   * 従来型個室基準額・テキストを取得します。
   * @return 従来型個室基準額・テキスト
   */
  public ACTextField getCareOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyText(){
    if(careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyText==null){

      careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyText = new ACTextField();

      careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyText.setBindPath("1520116");

      careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyText.setColumns(4);

      careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyText.setMaxLength(4);

      addCareOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyText();
    }
    return careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyText;

  }

  /**
   * 従来型個室基準額・ラベルを取得します。
   * @return 従来型個室基準額・ラベル
   */
  public ACLabel getCareOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyLabel(){
    if(careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyLabel==null){

      careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyLabel = new ACLabel();

      careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyLabel.setText("（円）");

      addCareOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyLabel();
    }
    return careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyLabel;

  }

  /**
   * 多床室基準額・コンテナを取得します。
   * @return 多床室基準額・コンテナ
   */
  public ACLabelContainer getCareOldPeopleHealthFacilitiesTasyouRoomConteiner(){
    if(careOldPeopleHealthFacilitiesTasyouRoomConteiner==null){

      careOldPeopleHealthFacilitiesTasyouRoomConteiner = new ACLabelContainer();

      careOldPeopleHealthFacilitiesTasyouRoomConteiner.setText("多床室基準額");

      careOldPeopleHealthFacilitiesTasyouRoomConteiner.setFollowChildEnabled(true);

      addCareOldPeopleHealthFacilitiesTasyouRoomConteiner();
    }
    return careOldPeopleHealthFacilitiesTasyouRoomConteiner;

  }

  /**
   * 多床室基準額・テキストを取得します。
   * @return 多床室基準額・テキスト
   */
  public ACTextField getCareOldPeopleHealthFacilitiesTasyouRoomText(){
    if(careOldPeopleHealthFacilitiesTasyouRoomText==null){

      careOldPeopleHealthFacilitiesTasyouRoomText = new ACTextField();

      careOldPeopleHealthFacilitiesTasyouRoomText.setBindPath("1520117");

      careOldPeopleHealthFacilitiesTasyouRoomText.setColumns(4);

      careOldPeopleHealthFacilitiesTasyouRoomText.setCharType(VRCharType.ONLY_DIGIT);

      careOldPeopleHealthFacilitiesTasyouRoomText.setHorizontalAlignment(SwingConstants.RIGHT);

      careOldPeopleHealthFacilitiesTasyouRoomText.setIMEMode(InputSubset.LATIN);

      careOldPeopleHealthFacilitiesTasyouRoomText.setMaxLength(4);

      addCareOldPeopleHealthFacilitiesTasyouRoomText();
    }
    return careOldPeopleHealthFacilitiesTasyouRoomText;

  }

  /**
   * 多床室基準額・ラベルを取得します。
   * @return 多床室基準額・ラベル
   */
  public ACLabel getCareOldPeopleHealthFacilitiesTasyouRoomLabel(){
    if(careOldPeopleHealthFacilitiesTasyouRoomLabel==null){

      careOldPeopleHealthFacilitiesTasyouRoomLabel = new ACLabel();

      careOldPeopleHealthFacilitiesTasyouRoomLabel.setText("（円）");

      addCareOldPeopleHealthFacilitiesTasyouRoomLabel();
    }
    return careOldPeopleHealthFacilitiesTasyouRoomLabel;

  }

  /**
   * コンストラクタです。
   */
  public QO004017Design() {

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

    this.add(getAgedPeopleHealthFacilityGroup(), VRLayout.CLIENT);

  }

  /**
   * 事業グループに内部項目を追加します。
   */
  protected void addAgedPeopleHealthFacilityGroup(){

    agedPeopleHealthFacilityGroup.add(getAgedPeopleHealthFacilityDiscountContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleHealthFacilityGroup.add(getInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleHealthFacilityGroup.add(getNightShiftConditionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleHealthFacilityGroup.add(getRehabilitationFunctionalEnhancementContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleHealthFacilityGroup.add(getDementiaSpecialBuildingContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleHealthFacilityGroup.add(getNutritionManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleHealthFacilityGroup.add(getNutritionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleHealthFacilityGroup.add(getOralSwitchRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleHealthFacilityGroup.add(getRecuperateDinnerRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleHealthFacilityGroup.add(getStaffLackContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleHealthFacilityGroup.add(getCareOldPeopleHealthFacilitiesDinnerStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleHealthFacilityGroup.add(getCareOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleHealthFacilityGroup.add(getCareOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleHealthFacilityGroup.add(getCareOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleHealthFacilityGroup.add(getCareOldPeopleHealthFacilitiesTasyouRoomConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 割引率コンテナに内部項目を追加します。
   */
  protected void addAgedPeopleHealthFacilityDiscountContainer(){

    agedPeopleHealthFacilityDiscountContainer.add(getAgedPeopleHealthFacilityDiscountRate(), VRLayout.FLOW);

    agedPeopleHealthFacilityDiscountContainer.add(getPercentSign(), VRLayout.FLOW);

  }

  /**
   * 割引率に内部項目を追加します。
   */
  protected void addAgedPeopleHealthFacilityDiscountRate(){

  }

  /**
   * ％ラベルに内部項目を追加します。
   */
  protected void addPercentSign(){

  }

  /**
   * 施設区分ラジオグループに内部項目を追加します。
   */
  protected void addInstitutionDivisionRadio(){

  }

  /**
   * 施設区分ラジオグループモデルに内部項目を追加します。
   */
  protected void addInstitutionDivisionRadioModel(){

    getInstitutionDivisionRadioItem1().setButtonIndex(1);
    getInstitutionDivisionRadioModel().add(getInstitutionDivisionRadioItem1());

    getInstitutionDivisionRadioItem2().setButtonIndex(2);
    getInstitutionDivisionRadioModel().add(getInstitutionDivisionRadioItem2());

  }

  /**
   * 介護保健施設に内部項目を追加します。
   */
  protected void addInstitutionDivisionRadioItem1(){

  }

  /**
   * ユニット型介護保健施設に内部項目を追加します。
   */
  protected void addInstitutionDivisionRadioItem2(){

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
   * リハビリテーション機能強化ラジオグループに内部項目を追加します。
   */
  protected void addRehabilitationFunctionalEnhancement(){

  }

  /**
   * リハビリテーション機能強化ラジオグループモデルに内部項目を追加します。
   */
  protected void addRehabilitationFunctionalEnhancementModel(){

    getRehabilitationFunctionalEnhancementOff().setButtonIndex(1);
    getRehabilitationFunctionalEnhancementModel().add(getRehabilitationFunctionalEnhancementOff());

    getRehabilitationFunctionalEnhancementOn().setButtonIndex(2);
    getRehabilitationFunctionalEnhancementModel().add(getRehabilitationFunctionalEnhancementOn());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addRehabilitationFunctionalEnhancementOff(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addRehabilitationFunctionalEnhancementOn(){

  }

  /**
   * 認知症専門棟ラジオグループに内部項目を追加します。
   */
  protected void addDementiaSpecialBuilding(){

  }

  /**
   * 認知症専門棟ラジオグループモデルに内部項目を追加します。
   */
  protected void addDementiaSpecialBuildingModel(){

    getDementiaSpecialBuildingOff().setButtonIndex(1);
    getDementiaSpecialBuildingModel().add(getDementiaSpecialBuildingOff());

    getDementiaSpecialBuildingOn().setButtonIndex(2);
    getDementiaSpecialBuildingModel().add(getDementiaSpecialBuildingOn());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addDementiaSpecialBuildingOff(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addDementiaSpecialBuildingOn(){

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

    getStaffLackExcess().setButtonIndex(2);
    getStaffLackModel().add(getStaffLackExcess());

    getStaffLackKango().setButtonIndex(3);
    getStaffLackModel().add(getStaffLackKango());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addStaffLackOff(){

  }

  /**
   * 定員超過に内部項目を追加します。
   */
  protected void addStaffLackExcess(){

  }

  /**
   * 看護・介護職員又は医師、PT・OT、介護支援専門員の不足に内部項目を追加します。
   */
  protected void addStaffLackKango(){

  }

  /**
   * 食費基準額・コンテナに内部項目を追加します。
   */
  protected void addCareOldPeopleHealthFacilitiesDinnerStandeirdMoneyConteiner(){

    careOldPeopleHealthFacilitiesDinnerStandeirdMoneyConteiner.add(getCareOldPeopleHealthFacilitiesDinnerStandeirdMoneyTotal(), VRLayout.FLOW);

    careOldPeopleHealthFacilitiesDinnerStandeirdMoneyConteiner.add(getCareOldPeopleHealthFacilitiesMorningDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    careOldPeopleHealthFacilitiesDinnerStandeirdMoneyConteiner.add(getCareOldPeopleHealthFacilitiesMorningDinnerStandeirdMoney(), VRLayout.FLOW);

    careOldPeopleHealthFacilitiesDinnerStandeirdMoneyConteiner.add(getCareOldPeopleHealthFacilitiesNoonDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    careOldPeopleHealthFacilitiesDinnerStandeirdMoneyConteiner.add(getCareOldPeopleHealthFacilitiesNoonDinnerStandeirdMoney(), VRLayout.FLOW);

    careOldPeopleHealthFacilitiesDinnerStandeirdMoneyConteiner.add(getCareOldPeopleHealthFacilitiesNightDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    careOldPeopleHealthFacilitiesDinnerStandeirdMoneyConteiner.add(getCareOldPeopleHealthFacilitiesNightDinnerStandeirdMoney(), VRLayout.FLOW);

    careOldPeopleHealthFacilitiesDinnerStandeirdMoneyConteiner.add(getCareOldPeopleHealthFacilitiesTotalDinnerStandeirdMoneyDenominationLabel(), VRLayout.FLOW);

  }

  /**
   * 食費基準額・合計・テキストに内部項目を追加します。
   */
  protected void addCareOldPeopleHealthFacilitiesDinnerStandeirdMoneyTotal(){

  }

  /**
   * 食費基準額・朝・ラベルに内部項目を追加します。
   */
  protected void addCareOldPeopleHealthFacilitiesMorningDinnerStandeirdMoneyLabel(){

  }

  /**
   * 食費基準額・朝・テキストに内部項目を追加します。
   */
  protected void addCareOldPeopleHealthFacilitiesMorningDinnerStandeirdMoney(){

  }

  /**
   * 食費基準額・昼・ラベルに内部項目を追加します。
   */
  protected void addCareOldPeopleHealthFacilitiesNoonDinnerStandeirdMoneyLabel(){

  }

  /**
   * 食費基準額・昼・テキストに内部項目を追加します。
   */
  protected void addCareOldPeopleHealthFacilitiesNoonDinnerStandeirdMoney(){

  }

  /**
   * 食費基準額・夜・ラベルに内部項目を追加します。
   */
  protected void addCareOldPeopleHealthFacilitiesNightDinnerStandeirdMoneyLabel(){

  }

  /**
   * 食費基準額・夜・テキストに内部項目を追加します。
   */
  protected void addCareOldPeopleHealthFacilitiesNightDinnerStandeirdMoney(){

  }

  /**
   * 食費基準額・ラベルに内部項目を追加します。
   */
  protected void addCareOldPeopleHealthFacilitiesTotalDinnerStandeirdMoneyDenominationLabel(){

  }

  /**
   * ユニット型個室基準額・コンテナに内部項目を追加します。
   */
  protected void addCareOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyConteiner(){

    careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyConteiner.add(getCareOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyText(), null);

    careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyConteiner.add(getCareOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyLabel(), null);

  }

  /**
   * ユニット型個室基準額・テキストに内部項目を追加します。
   */
  protected void addCareOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyText(){

  }

  /**
   * ユニット型個室基準額・ラベルに内部項目を追加します。
   */
  protected void addCareOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyLabel(){

  }

  /**
   * ユニット型準個室基準額・コンテナに内部項目を追加します。
   */
  protected void addCareOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyConteiner(){

    careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyConteiner.add(getCareOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyText(), null);

    careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyConteiner.add(getCareOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyLabel(), null);

  }

  /**
   * ユニット型準個室基準額・テキストに内部項目を追加します。
   */
  protected void addCareOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyText(){

  }

  /**
   * ユニット型準個室基準額・ラベルに内部項目を追加します。
   */
  protected void addCareOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyLabel(){

  }

  /**
   * 従来型個室基準額・コンテナに内部項目を追加します。
   */
  protected void addCareOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyConteiner(){

    careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyConteiner.add(getCareOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyText(), null);

    careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyConteiner.add(getCareOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyLabel(), null);

  }

  /**
   * 従来型個室基準額・テキストに内部項目を追加します。
   */
  protected void addCareOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyText(){

  }

  /**
   * 従来型個室基準額・ラベルに内部項目を追加します。
   */
  protected void addCareOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyLabel(){

  }

  /**
   * 多床室基準額・コンテナに内部項目を追加します。
   */
  protected void addCareOldPeopleHealthFacilitiesTasyouRoomConteiner(){

    careOldPeopleHealthFacilitiesTasyouRoomConteiner.add(getCareOldPeopleHealthFacilitiesTasyouRoomText(), null);

    careOldPeopleHealthFacilitiesTasyouRoomConteiner.add(getCareOldPeopleHealthFacilitiesTasyouRoomLabel(), null);

  }

  /**
   * 多床室基準額・テキストに内部項目を追加します。
   */
  protected void addCareOldPeopleHealthFacilitiesTasyouRoomText(){

  }

  /**
   * 多床室基準額・ラベルに内部項目を追加します。
   */
  protected void addCareOldPeopleHealthFacilitiesTasyouRoomLabel(){

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
      ACFrame.getInstance().getContentPane().add(new QO004017Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004017Design getThis() {
    return this;
  }
}
