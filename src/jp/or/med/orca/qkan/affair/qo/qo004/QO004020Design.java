
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
 * プログラム 事業者登録(介護療養型医療施設（認知症疾患型）) (QO004020)
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
 * 事業者登録(介護療養型医療施設（認知症疾患型）)画面項目デザイン(QO004020) 
 */
public class QO004020Design extends ACPanel {
  //GUIコンポーネント

  private ACGroupBox kaigoRecuperationMedicalFacilitiesGroup;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesDiscountcontainer;

  private ACTextField kaigoRecuperationMedicalFacilitiesDiscountRate;

  private ACLabel percentSign;

  private ACClearableRadioButtonGroup InstitutionDivisionRadio;

  private ACLabelContainer InstitutionDivisionRadioContainer;

  private ACListModelAdapter InstitutionDivisionRadioModel;

  private ACRadioButtonItem InstitutionDivisionRadioItem1;

  private ACRadioButtonItem InstitutionDivisionRadioItem2;

  private ACClearableRadioButtonGroup staffAssignmentDivision;

  private ACLabelContainer staffAssignmentDivisionContainer;

  private ACListModelAdapter staffAssignmentDivisionModel;

  private ACRadioButtonItem staffAssignmentDivision1;

  private ACRadioButtonItem staffAssignmentDivision2;

  private ACRadioButtonItem staffAssignmentDivision3;

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

  private ACComboBox staffLack;

  private ACLabelContainer staffLackContainer;

  private ACComboBoxModelAdapter staffLackModel;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner;

  private ACTextField kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyTotal;

  private ACLabel kaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoneyLabel;

  private ACTextField kaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney;

  private ACLabel kaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoneyLabel;

  private ACTextField kaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney;

  private ACLabel kaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoneyLabel;

  private ACTextField kaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney;

  private ACLabel kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyDenomination;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyConteiner;

  private ACTextField kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyText;

  private ACLabel kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyLabel;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyConteiner;

  private ACTextField kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyText;

  private ACLabel kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyLabel;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyConteiner;

  private ACTextField kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyText;

  private ACLabel kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyLabel;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomConteiner;

  private ACTextField kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomText;

  private ACLabel kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomLabel;

  //getter

  /**
   * 事業グループを取得します。
   * @return 事業グループ
   */
  public ACGroupBox getKaigoRecuperationMedicalFacilitiesGroup(){
    if(kaigoRecuperationMedicalFacilitiesGroup==null){

      kaigoRecuperationMedicalFacilitiesGroup = new ACGroupBox();

      kaigoRecuperationMedicalFacilitiesGroup.setText("介護療養型医療施設（認知症疾患型）");

      kaigoRecuperationMedicalFacilitiesGroup.setFollowChildEnabled(true);

      kaigoRecuperationMedicalFacilitiesGroup.setHgrid(200);

      addKaigoRecuperationMedicalFacilitiesGroup();
    }
    return kaigoRecuperationMedicalFacilitiesGroup;

  }

  /**
   * 割引率コンテナを取得します。
   * @return 割引率コンテナ
   */
  public ACLabelContainer getKaigoRecuperationMedicalFacilitiesDiscountcontainer(){
    if(kaigoRecuperationMedicalFacilitiesDiscountcontainer==null){

      kaigoRecuperationMedicalFacilitiesDiscountcontainer = new ACLabelContainer();

      kaigoRecuperationMedicalFacilitiesDiscountcontainer.setText("割引率");

      kaigoRecuperationMedicalFacilitiesDiscountcontainer.setFollowChildEnabled(true);

      addKaigoRecuperationMedicalFacilitiesDiscountcontainer();
    }
    return kaigoRecuperationMedicalFacilitiesDiscountcontainer;

  }

  /**
   * 割引率を取得します。
   * @return 割引率
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesDiscountRate(){
    if(kaigoRecuperationMedicalFacilitiesDiscountRate==null){

      kaigoRecuperationMedicalFacilitiesDiscountRate = new ACTextField();

      kaigoRecuperationMedicalFacilitiesDiscountRate.setBindPath("REDUCT_RATE");

      kaigoRecuperationMedicalFacilitiesDiscountRate.setColumns(3);

      kaigoRecuperationMedicalFacilitiesDiscountRate.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesDiscountRate.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesDiscountRate.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesDiscountRate.setMaxLength(3);

      addKaigoRecuperationMedicalFacilitiesDiscountRate();
    }
    return kaigoRecuperationMedicalFacilitiesDiscountRate;

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
    if(InstitutionDivisionRadio==null){

      InstitutionDivisionRadio = new ACClearableRadioButtonGroup();

      getInstitutionDivisionRadioContainer().setText("施設区分");

      InstitutionDivisionRadio.setBindPath("1530301");

      InstitutionDivisionRadio.setModel(getInstitutionDivisionRadioModel());

      InstitutionDivisionRadio.setUseClearButton(false);

      addInstitutionDivisionRadio();
    }
    return InstitutionDivisionRadio;

  }

  /**
   * 施設区分ラジオグループコンテナを取得します。
   * @return 施設区分ラジオグループコンテナ
   */
  protected ACLabelContainer getInstitutionDivisionRadioContainer(){
    if(InstitutionDivisionRadioContainer==null){
      InstitutionDivisionRadioContainer = new ACLabelContainer();
      InstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      InstitutionDivisionRadioContainer.add(getInstitutionDivisionRadio(), null);
    }
    return InstitutionDivisionRadioContainer;
  }

  /**
   * 施設区分ラジオグループモデルを取得します。
   * @return 施設区分ラジオグループモデル
   */
  protected ACListModelAdapter getInstitutionDivisionRadioModel(){
    if(InstitutionDivisionRadioModel==null){
      InstitutionDivisionRadioModel = new ACListModelAdapter();
      addInstitutionDivisionRadioModel();
    }
    return InstitutionDivisionRadioModel;
  }

  /**
   * 認知症疾患型を取得します。
   * @return 認知症疾患型
   */
  public ACRadioButtonItem getInstitutionDivisionRadioItem1(){
    if(InstitutionDivisionRadioItem1==null){

      InstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      InstitutionDivisionRadioItem1.setText("認知症疾患型");

      InstitutionDivisionRadioItem1.setGroup(getInstitutionDivisionRadio());

      addInstitutionDivisionRadioItem1();
    }
    return InstitutionDivisionRadioItem1;

  }

  /**
   * ユニット型認知症疾患型を取得します。
   * @return ユニット型認知症疾患型
   */
  public ACRadioButtonItem getInstitutionDivisionRadioItem2(){
    if(InstitutionDivisionRadioItem2==null){

      InstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      InstitutionDivisionRadioItem2.setText("ユニット型認知症疾患型");

      InstitutionDivisionRadioItem2.setGroup(getInstitutionDivisionRadio());

      addInstitutionDivisionRadioItem2();
    }
    return InstitutionDivisionRadioItem2;

  }

  /**
   * 人員配置区分ラジオグループを取得します。
   * @return 人員配置区分ラジオグループ
   */
  public ACClearableRadioButtonGroup getStaffAssignmentDivision(){
    if(staffAssignmentDivision==null){

      staffAssignmentDivision = new ACClearableRadioButtonGroup();

      getStaffAssignmentDivisionContainer().setText("人員配置区分");

      staffAssignmentDivision.setBindPath("1530302");

      staffAssignmentDivision.setModel(getStaffAssignmentDivisionModel());

      staffAssignmentDivision.setUseClearButton(false);

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
  public ACRadioButtonItem getStaffAssignmentDivision1(){
    if(staffAssignmentDivision1==null){

      staffAssignmentDivision1 = new ACRadioButtonItem();

      staffAssignmentDivision1.setText("I型");

      staffAssignmentDivision1.setGroup(getStaffAssignmentDivision());

      addStaffAssignmentDivision1();
    }
    return staffAssignmentDivision1;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getStaffAssignmentDivision2(){
    if(staffAssignmentDivision2==null){

      staffAssignmentDivision2 = new ACRadioButtonItem();

      staffAssignmentDivision2.setText("II型");

      staffAssignmentDivision2.setGroup(getStaffAssignmentDivision());

      addStaffAssignmentDivision2();
    }
    return staffAssignmentDivision2;

  }

  /**
   * III型を取得します。
   * @return III型
   */
  public ACRadioButtonItem getStaffAssignmentDivision3(){
    if(staffAssignmentDivision3==null){

      staffAssignmentDivision3 = new ACRadioButtonItem();

      staffAssignmentDivision3.setText("III型");

      staffAssignmentDivision3.setGroup(getStaffAssignmentDivision());

      addStaffAssignmentDivision3();
    }
    return staffAssignmentDivision3;

  }

  /**
   * 栄養管理体制ラジオグループを取得します。
   * @return 栄養管理体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getNutritionManageRadio(){
    if(nutritionManageRadio==null){

      nutritionManageRadio = new ACClearableRadioButtonGroup();

      getNutritionManageRadioContainer().setText("栄養管理体制");

      nutritionManageRadio.setBindPath("1530303");

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

      nutritionRadio.setBindPath("1530304");

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

      oralSwitchRadio.setBindPath("1530305");

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

      recuperateDinnerRadio.setBindPath("1530306");

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
   * 人員減算を取得します。
   * @return 人員減算
   */
  public ACComboBox getStaffLack(){
    if(staffLack==null){

      staffLack = new ACComboBox();

      getStaffLackContainer().setText("人員減算");

      staffLack.setBindPath("1530307");

      staffLack.setEditable(false);

      staffLack.setModel(getStaffLackModel());

      staffLack.setRenderBindPath("CONTENT");

      addStaffLack();
    }
    return staffLack;

  }

  /**
   * 人員減算コンテナを取得します。
   * @return 人員減算コンテナ
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
   * 人員減算モデルを取得します。
   * @return 人員減算モデル
   */
  protected ACComboBoxModelAdapter getStaffLackModel(){
    if(staffLackModel==null){
      staffLackModel = new ACComboBoxModelAdapter();
      addStaffLackModel();
    }
    return staffLackModel;
  }

  /**
   * 食費基準額・コンテナを取得します。
   * @return 食費基準額・コンテナ
   */
  public ACLabelContainer getKaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner(){
    if(kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner==null){

      kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner = new ACLabelContainer();

      kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner.setText("食費基準額");

      kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addKaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner();
    }
    return kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner;

  }

  /**
   * 食費基準額・合計・テキストを取得します。
   * @return 食費基準額・合計・テキスト
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyTotal(){
    if(kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyTotal==null){

      kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyTotal = new ACTextField();

      kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyTotal.setBindPath("1530308");

      kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyTotal.setEditable(false);

      kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyTotal.setColumns(4);

      kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyTotal.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyTotal.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyTotal.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyTotal.setMaxLength(4);

      addKaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyTotal();
    }
    return kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyTotal;

  }

  /**
   * 食費基準額・朝・ラベルを取得します。
   * @return 食費基準額・朝・ラベル
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoneyLabel(){
    if(kaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoneyLabel==null){

      kaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoneyLabel = new ACLabel();

      kaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoneyLabel.setText("　朝");

      addKaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoneyLabel();
    }
    return kaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoneyLabel;

  }

  /**
   * 食費基準額・朝・テキストを取得します。
   * @return 食費基準額・朝・テキスト
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney(){
    if(kaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney==null){

      kaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney = new ACTextField();

      kaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney.setBindPath("1530309");

      kaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney.setColumns(3);

      kaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney.setMaxLength(3);

      addKaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney();
    }
    return kaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney;

  }

  /**
   * 食費基準額・昼・ラベルを取得します。
   * @return 食費基準額・昼・ラベル
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoneyLabel(){
    if(kaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoneyLabel==null){

      kaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoneyLabel = new ACLabel();

      kaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoneyLabel.setText("昼");

      addKaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoneyLabel();
    }
    return kaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoneyLabel;

  }

  /**
   * 食費基準額・昼・テキストを取得します。
   * @return 食費基準額・昼・テキスト
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney(){
    if(kaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney==null){

      kaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney = new ACTextField();

      kaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney.setBindPath("1530310");

      kaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney.setColumns(3);

      kaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney.setMaxLength(3);

      addKaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney();
    }
    return kaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney;

  }

  /**
   * 食費基準額・夜・ラベルを取得します。
   * @return 食費基準額・夜・ラベル
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoneyLabel(){
    if(kaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoneyLabel==null){

      kaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoneyLabel = new ACLabel();

      kaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoneyLabel.setText("夜");

      addKaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoneyLabel();
    }
    return kaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoneyLabel;

  }

  /**
   * 食費基準額・夜・テキストを取得します。
   * @return 食費基準額・夜・テキスト
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney(){
    if(kaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney==null){

      kaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney = new ACTextField();

      kaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney.setBindPath("1530311");

      kaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney.setColumns(3);

      kaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney.setMaxLength(3);

      addKaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney();
    }
    return kaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney;

  }

  /**
   * 食費基準額・ラベルを取得します。
   * @return 食費基準額・ラベル
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyDenomination(){
    if(kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyDenomination==null){

      kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyDenomination = new ACLabel();

      kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyDenomination.setText("（円）");

      addKaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyDenomination();
    }
    return kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyDenomination;

  }

  /**
   * ユニット型個室基準額・コンテナを取得します。
   * @return ユニット型個室基準額・コンテナ
   */
  public ACLabelContainer getKaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyConteiner(){
    if(kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyConteiner==null){

      kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyConteiner = new ACLabelContainer();

      kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyConteiner.setText("ユニット型個室基準額");

      kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addKaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyConteiner();
    }
    return kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyConteiner;

  }

  /**
   * ユニット型個室基準額・テキストを取得します。
   * @return ユニット型個室基準額・テキスト
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyText(){
    if(kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyText==null){

      kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyText = new ACTextField();

      kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyText.setBindPath("1530312");

      kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyText.setColumns(4);

      kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyText.setMaxLength(4);

      addKaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyText();
    }
    return kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyText;

  }

  /**
   * ユニット型個室基準額・ラベルを取得します。
   * @return ユニット型個室基準額・ラベル
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyLabel(){
    if(kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyLabel==null){

      kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyLabel = new ACLabel();

      kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyLabel.setText("（円）");

      addKaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyLabel();
    }
    return kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyLabel;

  }

  /**
   * ユニット型準個室基準額・コンテナを取得します。
   * @return ユニット型準個室基準額・コンテナ
   */
  public ACLabelContainer getKaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyConteiner(){
    if(kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyConteiner==null){

      kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyConteiner = new ACLabelContainer();

      kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyConteiner.setText("ユニット型準個室基準額");

      kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addKaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyConteiner();
    }
    return kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyConteiner;

  }

  /**
   * ユニット型準個室基準額・テキストを取得します。
   * @return ユニット型準個室基準額・テキスト
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyText(){
    if(kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyText==null){

      kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyText = new ACTextField();

      kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyText.setBindPath("1530313");

      kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyText.setColumns(4);

      kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyText.setMaxLength(4);

      addKaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyText();
    }
    return kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyText;

  }

  /**
   * ユニット型準個室基準額・ラベルを取得します。
   * @return ユニット型準個室基準額・ラベル
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyLabel(){
    if(kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyLabel==null){

      kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyLabel = new ACLabel();

      kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyLabel.setText("（円）");

      addKaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyLabel();
    }
    return kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyLabel;

  }

  /**
   * 従来型個室基準額・コンテナを取得します。
   * @return 従来型個室基準額・コンテナ
   */
  public ACLabelContainer getKaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyConteiner(){
    if(kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyConteiner==null){

      kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyConteiner = new ACLabelContainer();

      kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyConteiner.setText("　　従来型個室基準額");

      kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addKaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyConteiner();
    }
    return kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyConteiner;

  }

  /**
   * 従来型個室基準額・テキストを取得します。
   * @return 従来型個室基準額・テキスト
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyText(){
    if(kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyText==null){

      kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyText = new ACTextField();

      kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyText.setBindPath("1530314");

      kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyText.setColumns(4);

      kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyText.setMaxLength(4);

      addKaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyText();
    }
    return kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyText;

  }

  /**
   * 従来型個室基準額・ラベルを取得します。
   * @return 従来型個室基準額・ラベル
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyLabel(){
    if(kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyLabel==null){

      kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyLabel = new ACLabel();

      kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyLabel.setText("（円）");

      addKaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyLabel();
    }
    return kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyLabel;

  }

  /**
   * 多床室基準額・コンテナを取得します。
   * @return 多床室基準額・コンテナ
   */
  public ACLabelContainer getKaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomConteiner(){
    if(kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomConteiner==null){

      kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomConteiner = new ACLabelContainer();

      kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomConteiner.setText("　　多床室基準額");

      kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomConteiner.setFollowChildEnabled(true);

      addKaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomConteiner();
    }
    return kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomConteiner;

  }

  /**
   * 多床室基準額・テキストを取得します。
   * @return 多床室基準額・テキスト
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomText(){
    if(kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomText==null){

      kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomText = new ACTextField();

      kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomText.setBindPath("1530315");

      kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomText.setColumns(4);

      kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomText.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomText.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomText.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomText.setMaxLength(4);

      addKaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomText();
    }
    return kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomText;

  }

  /**
   * 多床室基準額・ラベルを取得します。
   * @return 多床室基準額・ラベル
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomLabel(){
    if(kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomLabel==null){

      kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomLabel = new ACLabel();

      kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomLabel.setText("（円）");

      addKaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomLabel();
    }
    return kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomLabel;

  }

  /**
   * コンストラクタです。
   */
  public QO004020Design() {

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

    this.add(getKaigoRecuperationMedicalFacilitiesGroup(), VRLayout.CLIENT);

  }

  /**
   * 事業グループに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesGroup(){

    kaigoRecuperationMedicalFacilitiesGroup.add(getKaigoRecuperationMedicalFacilitiesDiscountcontainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getStaffAssignmentDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getNutritionManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getNutritionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getOralSwitchRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getRecuperateDinnerRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getStaffLackContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getKaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getKaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getKaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getKaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getKaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 割引率コンテナに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesDiscountcontainer(){

    kaigoRecuperationMedicalFacilitiesDiscountcontainer.add(getKaigoRecuperationMedicalFacilitiesDiscountRate(), VRLayout.FLOW);

    kaigoRecuperationMedicalFacilitiesDiscountcontainer.add(getPercentSign(), VRLayout.FLOW);

  }

  /**
   * 割引率に内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesDiscountRate(){

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
   * 認知症疾患型に内部項目を追加します。
   */
  protected void addInstitutionDivisionRadioItem1(){

  }

  /**
   * ユニット型認知症疾患型に内部項目を追加します。
   */
  protected void addInstitutionDivisionRadioItem2(){

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

    getStaffAssignmentDivision1().setButtonIndex(1);
    getStaffAssignmentDivisionModel().add(getStaffAssignmentDivision1());

    getStaffAssignmentDivision2().setButtonIndex(2);
    getStaffAssignmentDivisionModel().add(getStaffAssignmentDivision2());

    getStaffAssignmentDivision3().setButtonIndex(3);
    getStaffAssignmentDivisionModel().add(getStaffAssignmentDivision3());

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addStaffAssignmentDivision1(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addStaffAssignmentDivision2(){

  }

  /**
   * III型に内部項目を追加します。
   */
  protected void addStaffAssignmentDivision3(){

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
   * 人員減算に内部項目を追加します。
   */
  protected void addStaffLack(){

  }

  /**
   * 人員減算モデルに内部項目を追加します。
   */
  protected void addStaffLackModel(){

  }

  /**
   * 食費基準額・コンテナに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner(){

    kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyTotal(), VRLayout.FLOW);

    kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney(), VRLayout.FLOW);

    kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney(), VRLayout.FLOW);

    kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney(), VRLayout.FLOW);

    kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyDenomination(), VRLayout.FLOW);

  }

  /**
   * 食費基準額・合計・テキストに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyTotal(){

  }

  /**
   * 食費基準額・朝・ラベルに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoneyLabel(){

  }

  /**
   * 食費基準額・朝・テキストに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney(){

  }

  /**
   * 食費基準額・昼・ラベルに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoneyLabel(){

  }

  /**
   * 食費基準額・昼・テキストに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney(){

  }

  /**
   * 食費基準額・夜・ラベルに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoneyLabel(){

  }

  /**
   * 食費基準額・夜・テキストに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney(){

  }

  /**
   * 食費基準額・ラベルに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyDenomination(){

  }

  /**
   * ユニット型個室基準額・コンテナに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyConteiner(){

    kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyText(), null);

    kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyLabel(), null);

  }

  /**
   * ユニット型個室基準額・テキストに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyText(){

  }

  /**
   * ユニット型個室基準額・ラベルに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyLabel(){

  }

  /**
   * ユニット型準個室基準額・コンテナに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyConteiner(){

    kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyText(), null);

    kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyLabel(), null);

  }

  /**
   * ユニット型準個室基準額・テキストに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyText(){

  }

  /**
   * ユニット型準個室基準額・ラベルに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyLabel(){

  }

  /**
   * 従来型個室基準額・コンテナに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyConteiner(){

    kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyText(), null);

    kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyLabel(), null);

  }

  /**
   * 従来型個室基準額・テキストに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyText(){

  }

  /**
   * 従来型個室基準額・ラベルに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyLabel(){

  }

  /**
   * 多床室基準額・コンテナに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomConteiner(){

    kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomConteiner.add(getKaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomText(), null);

    kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomConteiner.add(getKaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomLabel(), null);

  }

  /**
   * 多床室基準額・テキストに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomText(){

  }

  /**
   * 多床室基準額・ラベルに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomLabel(){

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
      ACFrame.getInstance().getContentPane().add(new QO004020Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004020Design getThis() {
    return this;
  }
}
