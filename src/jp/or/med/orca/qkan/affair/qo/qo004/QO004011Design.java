
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
 * プログラム 短期入所療養介護診療所療養型 (QO004011)
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
 * 短期入所療養介護診療所療養型画面項目デザイン(QO004011) 
 */
public class QO004011Design extends ACPanel {
  //GUIコンポーネント

  private ACGroupBox shortStayClinicRecuperationGroup;

  private ACLabelContainer shortStayClinicRecuperationDiscountContainer;

  private ACTextField shortStayClinicRecuperationDiscountRate;

  private ACLabel shortStayPercentSign;

  private ACClearableRadioButtonGroup shortStayInstitutionDivisionRadio;

  private ACLabelContainer shortStayInstitutionDivisionRadioContainer;

  private ACListModelAdapter shortStayInstitutionDivisionRadioModel;

  private ACRadioButtonItem shortStayInstitutionDivisionRadioItem1;

  private ACRadioButtonItem shortStayInstitutionDivisionRadioItem2;

  private ACClearableRadioButtonGroup shortStayStaffAssignmentDivision;

  private ACLabelContainer shortStayStaffAssignmentDivisionContainer;

  private ACListModelAdapter shortStayStaffAssignmentDivisionModel;

  private ACRadioButtonItem shortStayStaffAssignmentDivision1;

  private ACRadioButtonItem shortStayStaffAssignmentDivision2;

  private ACClearableRadioButtonGroup shortStayRecuperationEnvironmental;

  private ACLabelContainer shortStayRecuperationEnvironmentalContainer;

  private ACListModelAdapter shortStayRecuperationEnvironmentalModel;

  private ACRadioButtonItem shortStayRecuperationEnvironmentalStandard;

  private ACRadioButtonItem shortStayRecuperationEnvironmentalSubtraction1;

  private ACRadioButtonItem shortStayRecuperationEnvironmentalSubtraction2;

  private ACClearableRadioButtonGroup shortStayMeetingAndSendingOffSystem;

  private ACLabelContainer shortStayMeetingAndSendingOffSystemContainer;

  private ACListModelAdapter shortStayMeetingAndSendingOffSystemModel;

  private ACRadioButtonItem shortStayMeetingAndSendingOffSystemOff;

  private ACRadioButtonItem shortStayMeetingAndSendingOffSystemOn;

  private ACClearableRadioButtonGroup shortStayNutritionManageRadio;

  private ACLabelContainer shortStayNutritionManageRadioContainer;

  private ACListModelAdapter shortStayNutritionManageRadioModel;

  private ACRadioButtonItem shortStayNutritionManageRadioItem1;

  private ACRadioButtonItem shortStayNutritionManageRadioItem2;

  private ACClearableRadioButtonGroup shortStayRecuperateDinnerRadio;

  private ACLabelContainer shortStayRecuperateDinnerRadioContainer;

  private ACListModelAdapter shortStayRecuperateDinnerRadioModel;

  private ACRadioButtonItem shortStayRecuperateDinnerRadioItem1;

  private ACRadioButtonItem shortStayRecuperateDinnerRadioItem2;

  private ACClearableRadioButtonGroup shortStayStaffReduce;

  private ACLabelContainer shortStayStaffReduceContainer;

  private ACListModelAdapter shortStayStaffReduceModel;

  private ACRadioButtonItem shortStayStaffNot;

  private ACRadioButtonItem shortStayStaffExcess;

  private ACLabelContainer shortStayRecuperateCareClinicDinnerStandeirdMoneyConteiner;

  private ACTextField shortStayRecuperateCareClinicDinnerStandeirdMoneyTotal;

  private ACLabel shortStayRecuperateCareClinicMorningDinnerStandeirdMoneyLabel;

  private ACTextField shortStayRecuperateCareClinicMorningDinnerStandeirdMoney;

  private ACLabel shortStayRecuperateCareClinicNoonDinnerStandeirdMoneyLabel;

  private ACTextField shortStayRecuperateCareClinicNoonDinnerStandeirdMoney;

  private ACLabel shortStayRecuperateCareClinicNightDinnerStandeirdMoneyLabel;

  private ACTextField shortStayRecuperateCareClinicNightDinnerStandeirdMoney;

  private ACLabel shortStayRecuperateCareClinicDinnerStandeirdMoney4Label;

  private ACLabelContainer shortStayRecuperateCareClinicUnitRoomStandeirdMoneyConteiner;

  private ACTextField shortStayRecuperateCareClinicUnitRoomStandeirdMoneyText;

  private ACLabel shortStayRecuperateCareClinicUnitRoomStandeirdMoneyLabel;

  private ACLabelContainer shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyConteiner;

  private ACTextField shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyText;

  private ACLabel shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyLabel;

  private ACLabelContainer shortStayRecuperateCareClinicNormalRoomStandeirdMoneyConteiner;

  private ACTextField shortStayRecuperateCareClinicNormalRoomStandeirdMoneyText;

  private ACLabel shortStayRecuperateCareClinicNormalRoomStandeirdMoneyLabel;

  private ACLabelContainer shortStayRecuperateCareClinicTasyouRoomConteiner;

  private ACTextField shortStayRecuperateCareClinicTasyouRoomText;

  private ACLabel shortStayRecuperateCareClinicTasyouRoomLabel;

  //getter

  /**
   * 事業グループを取得します。
   * @return 事業グループ
   */
  public ACGroupBox getShortStayClinicRecuperationGroup(){
    if(shortStayClinicRecuperationGroup==null){

      shortStayClinicRecuperationGroup = new ACGroupBox();

      shortStayClinicRecuperationGroup.setText("短期入所療養介護（診療所療養型）");

      shortStayClinicRecuperationGroup.setFollowChildEnabled(true);

      shortStayClinicRecuperationGroup.setHgrid(200);

      addShortStayClinicRecuperationGroup();
    }
    return shortStayClinicRecuperationGroup;

  }

  /**
   * 割引率コンテナを取得します。
   * @return 割引率コンテナ
   */
  public ACLabelContainer getShortStayClinicRecuperationDiscountContainer(){
    if(shortStayClinicRecuperationDiscountContainer==null){

      shortStayClinicRecuperationDiscountContainer = new ACLabelContainer();

      shortStayClinicRecuperationDiscountContainer.setText("割引率");

      shortStayClinicRecuperationDiscountContainer.setFollowChildEnabled(true);

      addShortStayClinicRecuperationDiscountContainer();
    }
    return shortStayClinicRecuperationDiscountContainer;

  }

  /**
   * 割引率を取得します。
   * @return 割引率
   */
  public ACTextField getShortStayClinicRecuperationDiscountRate(){
    if(shortStayClinicRecuperationDiscountRate==null){

      shortStayClinicRecuperationDiscountRate = new ACTextField();

      shortStayClinicRecuperationDiscountRate.setBindPath("REDUCT_RATE");

      shortStayClinicRecuperationDiscountRate.setColumns(3);

      shortStayClinicRecuperationDiscountRate.setCharType(VRCharType.ONLY_DIGIT);

      shortStayClinicRecuperationDiscountRate.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayClinicRecuperationDiscountRate.setIMEMode(InputSubset.LATIN);

      shortStayClinicRecuperationDiscountRate.setMaxLength(3);

      addShortStayClinicRecuperationDiscountRate();
    }
    return shortStayClinicRecuperationDiscountRate;

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
  public ACClearableRadioButtonGroup getShortStayInstitutionDivisionRadio(){
    if(shortStayInstitutionDivisionRadio==null){

      shortStayInstitutionDivisionRadio = new ACClearableRadioButtonGroup();

      getShortStayInstitutionDivisionRadioContainer().setText("施設区分");

      shortStayInstitutionDivisionRadio.setBindPath("1230201");

      shortStayInstitutionDivisionRadio.setModel(getShortStayInstitutionDivisionRadioModel());

      shortStayInstitutionDivisionRadio.setUseClearButton(false);

      addShortStayInstitutionDivisionRadio();
    }
    return shortStayInstitutionDivisionRadio;

  }

  /**
   * 施設区分ラジオグループコンテナを取得します。
   * @return 施設区分ラジオグループコンテナ
   */
  protected ACLabelContainer getShortStayInstitutionDivisionRadioContainer(){
    if(shortStayInstitutionDivisionRadioContainer==null){
      shortStayInstitutionDivisionRadioContainer = new ACLabelContainer();
      shortStayInstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      shortStayInstitutionDivisionRadioContainer.add(getShortStayInstitutionDivisionRadio(), null);
    }
    return shortStayInstitutionDivisionRadioContainer;
  }

  /**
   * 施設区分ラジオグループモデルを取得します。
   * @return 施設区分ラジオグループモデル
   */
  protected ACListModelAdapter getShortStayInstitutionDivisionRadioModel(){
    if(shortStayInstitutionDivisionRadioModel==null){
      shortStayInstitutionDivisionRadioModel = new ACListModelAdapter();
      addShortStayInstitutionDivisionRadioModel();
    }
    return shortStayInstitutionDivisionRadioModel;
  }

  /**
   * 診療所を取得します。
   * @return 診療所
   */
  public ACRadioButtonItem getShortStayInstitutionDivisionRadioItem1(){
    if(shortStayInstitutionDivisionRadioItem1==null){

      shortStayInstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayInstitutionDivisionRadioItem1.setText("診療所");

      shortStayInstitutionDivisionRadioItem1.setGroup(getShortStayInstitutionDivisionRadio());

      addShortStayInstitutionDivisionRadioItem1();
    }
    return shortStayInstitutionDivisionRadioItem1;

  }

  /**
   * ユニット型診療所を取得します。
   * @return ユニット型診療所
   */
  public ACRadioButtonItem getShortStayInstitutionDivisionRadioItem2(){
    if(shortStayInstitutionDivisionRadioItem2==null){

      shortStayInstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayInstitutionDivisionRadioItem2.setText("ユニット型診療所");

      shortStayInstitutionDivisionRadioItem2.setGroup(getShortStayInstitutionDivisionRadio());

      addShortStayInstitutionDivisionRadioItem2();
    }
    return shortStayInstitutionDivisionRadioItem2;

  }

  /**
   * 人員配置区分ラジオグループを取得します。
   * @return 人員配置区分ラジオグループ
   */
  public ACClearableRadioButtonGroup getShortStayStaffAssignmentDivision(){
    if(shortStayStaffAssignmentDivision==null){

      shortStayStaffAssignmentDivision = new ACClearableRadioButtonGroup();

      getShortStayStaffAssignmentDivisionContainer().setText("人員配置区分");

      shortStayStaffAssignmentDivision.setBindPath("1230202");

      shortStayStaffAssignmentDivision.setModel(getShortStayStaffAssignmentDivisionModel());

      shortStayStaffAssignmentDivision.setUseClearButton(false);

      addShortStayStaffAssignmentDivision();
    }
    return shortStayStaffAssignmentDivision;

  }

  /**
   * 人員配置区分ラジオグループコンテナを取得します。
   * @return 人員配置区分ラジオグループコンテナ
   */
  protected ACLabelContainer getShortStayStaffAssignmentDivisionContainer(){
    if(shortStayStaffAssignmentDivisionContainer==null){
      shortStayStaffAssignmentDivisionContainer = new ACLabelContainer();
      shortStayStaffAssignmentDivisionContainer.setFollowChildEnabled(true);
      shortStayStaffAssignmentDivisionContainer.add(getShortStayStaffAssignmentDivision(), null);
    }
    return shortStayStaffAssignmentDivisionContainer;
  }

  /**
   * 人員配置区分ラジオグループモデルを取得します。
   * @return 人員配置区分ラジオグループモデル
   */
  protected ACListModelAdapter getShortStayStaffAssignmentDivisionModel(){
    if(shortStayStaffAssignmentDivisionModel==null){
      shortStayStaffAssignmentDivisionModel = new ACListModelAdapter();
      addShortStayStaffAssignmentDivisionModel();
    }
    return shortStayStaffAssignmentDivisionModel;
  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getShortStayStaffAssignmentDivision1(){
    if(shortStayStaffAssignmentDivision1==null){

      shortStayStaffAssignmentDivision1 = new ACRadioButtonItem();

      shortStayStaffAssignmentDivision1.setText("I型");

      shortStayStaffAssignmentDivision1.setGroup(getShortStayStaffAssignmentDivision());

      addShortStayStaffAssignmentDivision1();
    }
    return shortStayStaffAssignmentDivision1;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getShortStayStaffAssignmentDivision2(){
    if(shortStayStaffAssignmentDivision2==null){

      shortStayStaffAssignmentDivision2 = new ACRadioButtonItem();

      shortStayStaffAssignmentDivision2.setText("II型");

      shortStayStaffAssignmentDivision2.setGroup(getShortStayStaffAssignmentDivision());

      addShortStayStaffAssignmentDivision2();
    }
    return shortStayStaffAssignmentDivision2;

  }

  /**
   * 療養環境基準ラジオグループを取得します。
   * @return 療養環境基準ラジオグループ
   */
  public ACClearableRadioButtonGroup getShortStayRecuperationEnvironmental(){
    if(shortStayRecuperationEnvironmental==null){

      shortStayRecuperationEnvironmental = new ACClearableRadioButtonGroup();

      getShortStayRecuperationEnvironmentalContainer().setText("療養環境基準");

      shortStayRecuperationEnvironmental.setBindPath("1230203");

      shortStayRecuperationEnvironmental.setModel(getShortStayRecuperationEnvironmentalModel());

      shortStayRecuperationEnvironmental.setUseClearButton(false);

      addShortStayRecuperationEnvironmental();
    }
    return shortStayRecuperationEnvironmental;

  }

  /**
   * 療養環境基準ラジオグループコンテナを取得します。
   * @return 療養環境基準ラジオグループコンテナ
   */
  protected ACLabelContainer getShortStayRecuperationEnvironmentalContainer(){
    if(shortStayRecuperationEnvironmentalContainer==null){
      shortStayRecuperationEnvironmentalContainer = new ACLabelContainer();
      shortStayRecuperationEnvironmentalContainer.setFollowChildEnabled(true);
      shortStayRecuperationEnvironmentalContainer.add(getShortStayRecuperationEnvironmental(), null);
    }
    return shortStayRecuperationEnvironmentalContainer;
  }

  /**
   * 療養環境基準ラジオグループモデルを取得します。
   * @return 療養環境基準ラジオグループモデル
   */
  protected ACListModelAdapter getShortStayRecuperationEnvironmentalModel(){
    if(shortStayRecuperationEnvironmentalModel==null){
      shortStayRecuperationEnvironmentalModel = new ACListModelAdapter();
      addShortStayRecuperationEnvironmentalModel();
    }
    return shortStayRecuperationEnvironmentalModel;
  }

  /**
   * 基準型を取得します。
   * @return 基準型
   */
  public ACRadioButtonItem getShortStayRecuperationEnvironmentalStandard(){
    if(shortStayRecuperationEnvironmentalStandard==null){

      shortStayRecuperationEnvironmentalStandard = new ACRadioButtonItem();

      shortStayRecuperationEnvironmentalStandard.setText("基準型");

      shortStayRecuperationEnvironmentalStandard.setGroup(getShortStayRecuperationEnvironmental());

      addShortStayRecuperationEnvironmentalStandard();
    }
    return shortStayRecuperationEnvironmentalStandard;

  }

  /**
   * 減算型Iを取得します。
   * @return 減算型I
   */
  public ACRadioButtonItem getShortStayRecuperationEnvironmentalSubtraction1(){
    if(shortStayRecuperationEnvironmentalSubtraction1==null){

      shortStayRecuperationEnvironmentalSubtraction1 = new ACRadioButtonItem();

      shortStayRecuperationEnvironmentalSubtraction1.setText("減算型I");

      shortStayRecuperationEnvironmentalSubtraction1.setGroup(getShortStayRecuperationEnvironmental());

      addShortStayRecuperationEnvironmentalSubtraction1();
    }
    return shortStayRecuperationEnvironmentalSubtraction1;

  }

  /**
   * 減算型IIを取得します。
   * @return 減算型II
   */
  public ACRadioButtonItem getShortStayRecuperationEnvironmentalSubtraction2(){
    if(shortStayRecuperationEnvironmentalSubtraction2==null){

      shortStayRecuperationEnvironmentalSubtraction2 = new ACRadioButtonItem();

      shortStayRecuperationEnvironmentalSubtraction2.setText("減算型II");

      shortStayRecuperationEnvironmentalSubtraction2.setGroup(getShortStayRecuperationEnvironmental());

      addShortStayRecuperationEnvironmentalSubtraction2();
    }
    return shortStayRecuperationEnvironmentalSubtraction2;

  }

  /**
   * 送迎体制ラジオグループを取得します。
   * @return 送迎体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getShortStayMeetingAndSendingOffSystem(){
    if(shortStayMeetingAndSendingOffSystem==null){

      shortStayMeetingAndSendingOffSystem = new ACClearableRadioButtonGroup();

      getShortStayMeetingAndSendingOffSystemContainer().setText("送迎体制");

      shortStayMeetingAndSendingOffSystem.setBindPath("1230204");

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
  public ACRadioButtonItem getShortStayMeetingAndSendingOffSystemOff(){
    if(shortStayMeetingAndSendingOffSystemOff==null){

      shortStayMeetingAndSendingOffSystemOff = new ACRadioButtonItem();

      shortStayMeetingAndSendingOffSystemOff.setText("なし");

      shortStayMeetingAndSendingOffSystemOff.setGroup(getShortStayMeetingAndSendingOffSystem());

      addShortStayMeetingAndSendingOffSystemOff();
    }
    return shortStayMeetingAndSendingOffSystemOff;

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
  public ACClearableRadioButtonGroup getShortStayNutritionManageRadio(){
    if(shortStayNutritionManageRadio==null){

      shortStayNutritionManageRadio = new ACClearableRadioButtonGroup();

      getShortStayNutritionManageRadioContainer().setText("栄養管理体制");

      shortStayNutritionManageRadio.setBindPath("1230205");

      shortStayNutritionManageRadio.setModel(getShortStayNutritionManageRadioModel());

      shortStayNutritionManageRadio.setUseClearButton(false);

      addShortStayNutritionManageRadio();
    }
    return shortStayNutritionManageRadio;

  }

  /**
   * 栄養管理体制ラジオグループコンテナを取得します。
   * @return 栄養管理体制ラジオグループコンテナ
   */
  protected ACLabelContainer getShortStayNutritionManageRadioContainer(){
    if(shortStayNutritionManageRadioContainer==null){
      shortStayNutritionManageRadioContainer = new ACLabelContainer();
      shortStayNutritionManageRadioContainer.setFollowChildEnabled(true);
      shortStayNutritionManageRadioContainer.add(getShortStayNutritionManageRadio(), null);
    }
    return shortStayNutritionManageRadioContainer;
  }

  /**
   * 栄養管理体制ラジオグループモデルを取得します。
   * @return 栄養管理体制ラジオグループモデル
   */
  protected ACListModelAdapter getShortStayNutritionManageRadioModel(){
    if(shortStayNutritionManageRadioModel==null){
      shortStayNutritionManageRadioModel = new ACListModelAdapter();
      addShortStayNutritionManageRadioModel();
    }
    return shortStayNutritionManageRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayNutritionManageRadioItem1(){
    if(shortStayNutritionManageRadioItem1==null){

      shortStayNutritionManageRadioItem1 = new ACRadioButtonItem();

      shortStayNutritionManageRadioItem1.setText("なし");

      shortStayNutritionManageRadioItem1.setGroup(getShortStayNutritionManageRadio());

      addShortStayNutritionManageRadioItem1();
    }
    return shortStayNutritionManageRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayNutritionManageRadioItem2(){
    if(shortStayNutritionManageRadioItem2==null){

      shortStayNutritionManageRadioItem2 = new ACRadioButtonItem();

      shortStayNutritionManageRadioItem2.setText("あり");

      shortStayNutritionManageRadioItem2.setGroup(getShortStayNutritionManageRadio());

      addShortStayNutritionManageRadioItem2();
    }
    return shortStayNutritionManageRadioItem2;

  }

  /**
   * 療養食体制ラジオグループを取得します。
   * @return 療養食体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getShortStayRecuperateDinnerRadio(){
    if(shortStayRecuperateDinnerRadio==null){

      shortStayRecuperateDinnerRadio = new ACClearableRadioButtonGroup();

      getShortStayRecuperateDinnerRadioContainer().setText("療養食体制");

      shortStayRecuperateDinnerRadio.setBindPath("1230206");

      shortStayRecuperateDinnerRadio.setModel(getShortStayRecuperateDinnerRadioModel());

      shortStayRecuperateDinnerRadio.setUseClearButton(false);

      addShortStayRecuperateDinnerRadio();
    }
    return shortStayRecuperateDinnerRadio;

  }

  /**
   * 療養食体制ラジオグループコンテナを取得します。
   * @return 療養食体制ラジオグループコンテナ
   */
  protected ACLabelContainer getShortStayRecuperateDinnerRadioContainer(){
    if(shortStayRecuperateDinnerRadioContainer==null){
      shortStayRecuperateDinnerRadioContainer = new ACLabelContainer();
      shortStayRecuperateDinnerRadioContainer.setFollowChildEnabled(true);
      shortStayRecuperateDinnerRadioContainer.add(getShortStayRecuperateDinnerRadio(), null);
    }
    return shortStayRecuperateDinnerRadioContainer;
  }

  /**
   * 療養食体制ラジオグループモデルを取得します。
   * @return 療養食体制ラジオグループモデル
   */
  protected ACListModelAdapter getShortStayRecuperateDinnerRadioModel(){
    if(shortStayRecuperateDinnerRadioModel==null){
      shortStayRecuperateDinnerRadioModel = new ACListModelAdapter();
      addShortStayRecuperateDinnerRadioModel();
    }
    return shortStayRecuperateDinnerRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayRecuperateDinnerRadioItem1(){
    if(shortStayRecuperateDinnerRadioItem1==null){

      shortStayRecuperateDinnerRadioItem1 = new ACRadioButtonItem();

      shortStayRecuperateDinnerRadioItem1.setText("なし");

      shortStayRecuperateDinnerRadioItem1.setGroup(getShortStayRecuperateDinnerRadio());

      addShortStayRecuperateDinnerRadioItem1();
    }
    return shortStayRecuperateDinnerRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayRecuperateDinnerRadioItem2(){
    if(shortStayRecuperateDinnerRadioItem2==null){

      shortStayRecuperateDinnerRadioItem2 = new ACRadioButtonItem();

      shortStayRecuperateDinnerRadioItem2.setText("あり");

      shortStayRecuperateDinnerRadioItem2.setGroup(getShortStayRecuperateDinnerRadio());

      addShortStayRecuperateDinnerRadioItem2();
    }
    return shortStayRecuperateDinnerRadioItem2;

  }

  /**
   * 人員減算ラジオグループを取得します。
   * @return 人員減算ラジオグループ
   */
  public ACClearableRadioButtonGroup getShortStayStaffReduce(){
    if(shortStayStaffReduce==null){

      shortStayStaffReduce = new ACClearableRadioButtonGroup();

      getShortStayStaffReduceContainer().setText("人員減算");

      shortStayStaffReduce.setBindPath("1230207");

      shortStayStaffReduce.setModel(getShortStayStaffReduceModel());

      shortStayStaffReduce.setUseClearButton(false);

      addShortStayStaffReduce();
    }
    return shortStayStaffReduce;

  }

  /**
   * 人員減算ラジオグループコンテナを取得します。
   * @return 人員減算ラジオグループコンテナ
   */
  protected ACLabelContainer getShortStayStaffReduceContainer(){
    if(shortStayStaffReduceContainer==null){
      shortStayStaffReduceContainer = new ACLabelContainer();
      shortStayStaffReduceContainer.setFollowChildEnabled(true);
      shortStayStaffReduceContainer.add(getShortStayStaffReduce(), null);
    }
    return shortStayStaffReduceContainer;
  }

  /**
   * 人員減算ラジオグループモデルを取得します。
   * @return 人員減算ラジオグループモデル
   */
  protected ACListModelAdapter getShortStayStaffReduceModel(){
    if(shortStayStaffReduceModel==null){
      shortStayStaffReduceModel = new ACListModelAdapter();
      addShortStayStaffReduceModel();
    }
    return shortStayStaffReduceModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayStaffNot(){
    if(shortStayStaffNot==null){

      shortStayStaffNot = new ACRadioButtonItem();

      shortStayStaffNot.setText("なし");

      shortStayStaffNot.setGroup(getShortStayStaffReduce());

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

      shortStayStaffExcess.setGroup(getShortStayStaffReduce());

      addShortStayStaffExcess();
    }
    return shortStayStaffExcess;

  }

  /**
   * 食費基準額・コンテナを取得します。
   * @return 食費基準額・コンテナ
   */
  public ACLabelContainer getShortStayRecuperateCareClinicDinnerStandeirdMoneyConteiner(){
    if(shortStayRecuperateCareClinicDinnerStandeirdMoneyConteiner==null){

      shortStayRecuperateCareClinicDinnerStandeirdMoneyConteiner = new ACLabelContainer();

      shortStayRecuperateCareClinicDinnerStandeirdMoneyConteiner.setText("食費基準額");

      shortStayRecuperateCareClinicDinnerStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareClinicDinnerStandeirdMoneyConteiner();
    }
    return shortStayRecuperateCareClinicDinnerStandeirdMoneyConteiner;

  }

  /**
   * 食費基準額・合計・テキストを取得します。
   * @return 食費基準額・合計・テキスト
   */
  public ACTextField getShortStayRecuperateCareClinicDinnerStandeirdMoneyTotal(){
    if(shortStayRecuperateCareClinicDinnerStandeirdMoneyTotal==null){

      shortStayRecuperateCareClinicDinnerStandeirdMoneyTotal = new ACTextField();

      shortStayRecuperateCareClinicDinnerStandeirdMoneyTotal.setBindPath("1230208");

      shortStayRecuperateCareClinicDinnerStandeirdMoneyTotal.setEditable(false);

      shortStayRecuperateCareClinicDinnerStandeirdMoneyTotal.setColumns(4);

      shortStayRecuperateCareClinicDinnerStandeirdMoneyTotal.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareClinicDinnerStandeirdMoneyTotal.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareClinicDinnerStandeirdMoneyTotal.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareClinicDinnerStandeirdMoneyTotal.setMaxLength(4);

      addShortStayRecuperateCareClinicDinnerStandeirdMoneyTotal();
    }
    return shortStayRecuperateCareClinicDinnerStandeirdMoneyTotal;

  }

  /**
   * 食費基準額・朝・ラベルを取得します。
   * @return 食費基準額・朝・ラベル
   */
  public ACLabel getShortStayRecuperateCareClinicMorningDinnerStandeirdMoneyLabel(){
    if(shortStayRecuperateCareClinicMorningDinnerStandeirdMoneyLabel==null){

      shortStayRecuperateCareClinicMorningDinnerStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareClinicMorningDinnerStandeirdMoneyLabel.setText("　朝");

      addShortStayRecuperateCareClinicMorningDinnerStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareClinicMorningDinnerStandeirdMoneyLabel;

  }

  /**
   * 食費基準額・朝・テキストを取得します。
   * @return 食費基準額・朝・テキスト
   */
  public ACTextField getShortStayRecuperateCareClinicMorningDinnerStandeirdMoney(){
    if(shortStayRecuperateCareClinicMorningDinnerStandeirdMoney==null){

      shortStayRecuperateCareClinicMorningDinnerStandeirdMoney = new ACTextField();

      shortStayRecuperateCareClinicMorningDinnerStandeirdMoney.setBindPath("1230209");

      shortStayRecuperateCareClinicMorningDinnerStandeirdMoney.setColumns(3);

      shortStayRecuperateCareClinicMorningDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareClinicMorningDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareClinicMorningDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareClinicMorningDinnerStandeirdMoney.setMaxLength(3);

      addShortStayRecuperateCareClinicMorningDinnerStandeirdMoney();
    }
    return shortStayRecuperateCareClinicMorningDinnerStandeirdMoney;

  }

  /**
   * 食費基準額・昼・ラベルを取得します。
   * @return 食費基準額・昼・ラベル
   */
  public ACLabel getShortStayRecuperateCareClinicNoonDinnerStandeirdMoneyLabel(){
    if(shortStayRecuperateCareClinicNoonDinnerStandeirdMoneyLabel==null){

      shortStayRecuperateCareClinicNoonDinnerStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareClinicNoonDinnerStandeirdMoneyLabel.setText("昼");

      addShortStayRecuperateCareClinicNoonDinnerStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareClinicNoonDinnerStandeirdMoneyLabel;

  }

  /**
   * 食費基準額・昼・テキストを取得します。
   * @return 食費基準額・昼・テキスト
   */
  public ACTextField getShortStayRecuperateCareClinicNoonDinnerStandeirdMoney(){
    if(shortStayRecuperateCareClinicNoonDinnerStandeirdMoney==null){

      shortStayRecuperateCareClinicNoonDinnerStandeirdMoney = new ACTextField();

      shortStayRecuperateCareClinicNoonDinnerStandeirdMoney.setBindPath("1230210");

      shortStayRecuperateCareClinicNoonDinnerStandeirdMoney.setColumns(3);

      shortStayRecuperateCareClinicNoonDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareClinicNoonDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareClinicNoonDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareClinicNoonDinnerStandeirdMoney.setMaxLength(3);

      addShortStayRecuperateCareClinicNoonDinnerStandeirdMoney();
    }
    return shortStayRecuperateCareClinicNoonDinnerStandeirdMoney;

  }

  /**
   * 食費基準額・夜・ラベルを取得します。
   * @return 食費基準額・夜・ラベル
   */
  public ACLabel getShortStayRecuperateCareClinicNightDinnerStandeirdMoneyLabel(){
    if(shortStayRecuperateCareClinicNightDinnerStandeirdMoneyLabel==null){

      shortStayRecuperateCareClinicNightDinnerStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareClinicNightDinnerStandeirdMoneyLabel.setText("夜");

      addShortStayRecuperateCareClinicNightDinnerStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareClinicNightDinnerStandeirdMoneyLabel;

  }

  /**
   * 食費基準額・夜・テキストを取得します。
   * @return 食費基準額・夜・テキスト
   */
  public ACTextField getShortStayRecuperateCareClinicNightDinnerStandeirdMoney(){
    if(shortStayRecuperateCareClinicNightDinnerStandeirdMoney==null){

      shortStayRecuperateCareClinicNightDinnerStandeirdMoney = new ACTextField();

      shortStayRecuperateCareClinicNightDinnerStandeirdMoney.setBindPath("1230211");

      shortStayRecuperateCareClinicNightDinnerStandeirdMoney.setColumns(3);

      shortStayRecuperateCareClinicNightDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareClinicNightDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareClinicNightDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareClinicNightDinnerStandeirdMoney.setMaxLength(3);

      addShortStayRecuperateCareClinicNightDinnerStandeirdMoney();
    }
    return shortStayRecuperateCareClinicNightDinnerStandeirdMoney;

  }

  /**
   * 食費基準額・ラベルを取得します。
   * @return 食費基準額・ラベル
   */
  public ACLabel getShortStayRecuperateCareClinicDinnerStandeirdMoney4Label(){
    if(shortStayRecuperateCareClinicDinnerStandeirdMoney4Label==null){

      shortStayRecuperateCareClinicDinnerStandeirdMoney4Label = new ACLabel();

      shortStayRecuperateCareClinicDinnerStandeirdMoney4Label.setText("（円）");

      addShortStayRecuperateCareClinicDinnerStandeirdMoney4Label();
    }
    return shortStayRecuperateCareClinicDinnerStandeirdMoney4Label;

  }

  /**
   * ユニット型個室基準額・コンテナを取得します。
   * @return ユニット型個室基準額・コンテナ
   */
  public ACLabelContainer getShortStayRecuperateCareClinicUnitRoomStandeirdMoneyConteiner(){
    if(shortStayRecuperateCareClinicUnitRoomStandeirdMoneyConteiner==null){

      shortStayRecuperateCareClinicUnitRoomStandeirdMoneyConteiner = new ACLabelContainer();

      shortStayRecuperateCareClinicUnitRoomStandeirdMoneyConteiner.setText("ユニット型個室基準額");

      shortStayRecuperateCareClinicUnitRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareClinicUnitRoomStandeirdMoneyConteiner();
    }
    return shortStayRecuperateCareClinicUnitRoomStandeirdMoneyConteiner;

  }

  /**
   * ユニット型個室基準額・テキストを取得します。
   * @return ユニット型個室基準額・テキスト
   */
  public ACTextField getShortStayRecuperateCareClinicUnitRoomStandeirdMoneyText(){
    if(shortStayRecuperateCareClinicUnitRoomStandeirdMoneyText==null){

      shortStayRecuperateCareClinicUnitRoomStandeirdMoneyText = new ACTextField();

      shortStayRecuperateCareClinicUnitRoomStandeirdMoneyText.setBindPath("1230212");

      shortStayRecuperateCareClinicUnitRoomStandeirdMoneyText.setColumns(4);

      shortStayRecuperateCareClinicUnitRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareClinicUnitRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareClinicUnitRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareClinicUnitRoomStandeirdMoneyText.setMaxLength(4);

      addShortStayRecuperateCareClinicUnitRoomStandeirdMoneyText();
    }
    return shortStayRecuperateCareClinicUnitRoomStandeirdMoneyText;

  }

  /**
   * ユニット型個室基準額・ラベルを取得します。
   * @return ユニット型個室基準額・ラベル
   */
  public ACLabel getShortStayRecuperateCareClinicUnitRoomStandeirdMoneyLabel(){
    if(shortStayRecuperateCareClinicUnitRoomStandeirdMoneyLabel==null){

      shortStayRecuperateCareClinicUnitRoomStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareClinicUnitRoomStandeirdMoneyLabel.setText("（円）");

      addShortStayRecuperateCareClinicUnitRoomStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareClinicUnitRoomStandeirdMoneyLabel;

  }

  /**
   * ユニット型準個室基準額・コンテナを取得します。
   * @return ユニット型準個室基準額・コンテナ
   */
  public ACLabelContainer getShortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyConteiner(){
    if(shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyConteiner==null){

      shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyConteiner = new ACLabelContainer();

      shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyConteiner.setText("ユニット型準個室基準額");

      shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyConteiner();
    }
    return shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyConteiner;

  }

  /**
   * ユニット型準個室基準額・テキストを取得します。
   * @return ユニット型準個室基準額・テキスト
   */
  public ACTextField getShortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyText(){
    if(shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyText==null){

      shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyText = new ACTextField();

      shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyText.setBindPath("1230213");

      shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyText.setColumns(4);

      shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyText.setMaxLength(4);

      addShortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyText();
    }
    return shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyText;

  }

  /**
   * ユニット型準個室基準額・ラベルを取得します。
   * @return ユニット型準個室基準額・ラベル
   */
  public ACLabel getShortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyLabel(){
    if(shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyLabel==null){

      shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyLabel.setText("（円）");

      addShortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyLabel;

  }

  /**
   * 従来型個室基準額・コンテナを取得します。
   * @return 従来型個室基準額・コンテナ
   */
  public ACLabelContainer getShortStayRecuperateCareClinicNormalRoomStandeirdMoneyConteiner(){
    if(shortStayRecuperateCareClinicNormalRoomStandeirdMoneyConteiner==null){

      shortStayRecuperateCareClinicNormalRoomStandeirdMoneyConteiner = new ACLabelContainer();

      shortStayRecuperateCareClinicNormalRoomStandeirdMoneyConteiner.setText("　　従来型個室基準額");

      shortStayRecuperateCareClinicNormalRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareClinicNormalRoomStandeirdMoneyConteiner();
    }
    return shortStayRecuperateCareClinicNormalRoomStandeirdMoneyConteiner;

  }

  /**
   * 従来型個室基準額・テキストを取得します。
   * @return 従来型個室基準額・テキスト
   */
  public ACTextField getShortStayRecuperateCareClinicNormalRoomStandeirdMoneyText(){
    if(shortStayRecuperateCareClinicNormalRoomStandeirdMoneyText==null){

      shortStayRecuperateCareClinicNormalRoomStandeirdMoneyText = new ACTextField();

      shortStayRecuperateCareClinicNormalRoomStandeirdMoneyText.setBindPath("1230214");

      shortStayRecuperateCareClinicNormalRoomStandeirdMoneyText.setColumns(4);

      shortStayRecuperateCareClinicNormalRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareClinicNormalRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareClinicNormalRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareClinicNormalRoomStandeirdMoneyText.setMaxLength(4);

      addShortStayRecuperateCareClinicNormalRoomStandeirdMoneyText();
    }
    return shortStayRecuperateCareClinicNormalRoomStandeirdMoneyText;

  }

  /**
   * 従来型個室基準額・ラベルを取得します。
   * @return 従来型個室基準額・ラベル
   */
  public ACLabel getShortStayRecuperateCareClinicNormalRoomStandeirdMoneyLabel(){
    if(shortStayRecuperateCareClinicNormalRoomStandeirdMoneyLabel==null){

      shortStayRecuperateCareClinicNormalRoomStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareClinicNormalRoomStandeirdMoneyLabel.setText("（円）");

      addShortStayRecuperateCareClinicNormalRoomStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareClinicNormalRoomStandeirdMoneyLabel;

  }

  /**
   * 多床室基準額・コンテナを取得します。
   * @return 多床室基準額・コンテナ
   */
  public ACLabelContainer getShortStayRecuperateCareClinicTasyouRoomConteiner(){
    if(shortStayRecuperateCareClinicTasyouRoomConteiner==null){

      shortStayRecuperateCareClinicTasyouRoomConteiner = new ACLabelContainer();

      shortStayRecuperateCareClinicTasyouRoomConteiner.setText("　　多床室基準額");

      shortStayRecuperateCareClinicTasyouRoomConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareClinicTasyouRoomConteiner();
    }
    return shortStayRecuperateCareClinicTasyouRoomConteiner;

  }

  /**
   * 多床室基準額・テキストを取得します。
   * @return 多床室基準額・テキスト
   */
  public ACTextField getShortStayRecuperateCareClinicTasyouRoomText(){
    if(shortStayRecuperateCareClinicTasyouRoomText==null){

      shortStayRecuperateCareClinicTasyouRoomText = new ACTextField();

      shortStayRecuperateCareClinicTasyouRoomText.setBindPath("1230215");

      shortStayRecuperateCareClinicTasyouRoomText.setColumns(4);

      shortStayRecuperateCareClinicTasyouRoomText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareClinicTasyouRoomText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareClinicTasyouRoomText.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareClinicTasyouRoomText.setMaxLength(4);

      addShortStayRecuperateCareClinicTasyouRoomText();
    }
    return shortStayRecuperateCareClinicTasyouRoomText;

  }

  /**
   * 多床室基準額・ラベルを取得します。
   * @return 多床室基準額・ラベル
   */
  public ACLabel getShortStayRecuperateCareClinicTasyouRoomLabel(){
    if(shortStayRecuperateCareClinicTasyouRoomLabel==null){

      shortStayRecuperateCareClinicTasyouRoomLabel = new ACLabel();

      shortStayRecuperateCareClinicTasyouRoomLabel.setText("（円）");

      addShortStayRecuperateCareClinicTasyouRoomLabel();
    }
    return shortStayRecuperateCareClinicTasyouRoomLabel;

  }

  /**
   * コンストラクタです。
   */
  public QO004011Design() {

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

    this.add(getShortStayClinicRecuperationGroup(), VRLayout.CLIENT);

  }

  /**
   * 事業グループに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationGroup(){

    shortStayClinicRecuperationGroup.add(getShortStayClinicRecuperationDiscountContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayClinicRecuperationGroup.add(getShortStayInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayClinicRecuperationGroup.add(getShortStayStaffAssignmentDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayClinicRecuperationGroup.add(getShortStayRecuperationEnvironmentalContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayClinicRecuperationGroup.add(getShortStayMeetingAndSendingOffSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayClinicRecuperationGroup.add(getShortStayNutritionManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayClinicRecuperationGroup.add(getShortStayRecuperateDinnerRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayClinicRecuperationGroup.add(getShortStayStaffReduceContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayClinicRecuperationGroup.add(getShortStayRecuperateCareClinicDinnerStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayClinicRecuperationGroup.add(getShortStayRecuperateCareClinicUnitRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayClinicRecuperationGroup.add(getShortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayClinicRecuperationGroup.add(getShortStayRecuperateCareClinicNormalRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayClinicRecuperationGroup.add(getShortStayRecuperateCareClinicTasyouRoomConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 割引率コンテナに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationDiscountContainer(){

    shortStayClinicRecuperationDiscountContainer.add(getShortStayClinicRecuperationDiscountRate(), VRLayout.FLOW);

    shortStayClinicRecuperationDiscountContainer.add(getShortStayPercentSign(), VRLayout.FLOW);

  }

  /**
   * 割引率に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationDiscountRate(){

  }

  /**
   * ％ラベルに内部項目を追加します。
   */
  protected void addShortStayPercentSign(){

  }

  /**
   * 施設区分ラジオグループに内部項目を追加します。
   */
  protected void addShortStayInstitutionDivisionRadio(){

  }

  /**
   * 施設区分ラジオグループモデルに内部項目を追加します。
   */
  protected void addShortStayInstitutionDivisionRadioModel(){

    getShortStayInstitutionDivisionRadioItem1().setButtonIndex(1);
    getShortStayInstitutionDivisionRadioModel().add(getShortStayInstitutionDivisionRadioItem1());

    getShortStayInstitutionDivisionRadioItem2().setButtonIndex(2);
    getShortStayInstitutionDivisionRadioModel().add(getShortStayInstitutionDivisionRadioItem2());

  }

  /**
   * 診療所に内部項目を追加します。
   */
  protected void addShortStayInstitutionDivisionRadioItem1(){

  }

  /**
   * ユニット型診療所に内部項目を追加します。
   */
  protected void addShortStayInstitutionDivisionRadioItem2(){

  }

  /**
   * 人員配置区分ラジオグループに内部項目を追加します。
   */
  protected void addShortStayStaffAssignmentDivision(){

  }

  /**
   * 人員配置区分ラジオグループモデルに内部項目を追加します。
   */
  protected void addShortStayStaffAssignmentDivisionModel(){

    getShortStayStaffAssignmentDivision1().setButtonIndex(1);
    getShortStayStaffAssignmentDivisionModel().add(getShortStayStaffAssignmentDivision1());

    getShortStayStaffAssignmentDivision2().setButtonIndex(2);
    getShortStayStaffAssignmentDivisionModel().add(getShortStayStaffAssignmentDivision2());

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addShortStayStaffAssignmentDivision1(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addShortStayStaffAssignmentDivision2(){

  }

  /**
   * 療養環境基準ラジオグループに内部項目を追加します。
   */
  protected void addShortStayRecuperationEnvironmental(){

  }

  /**
   * 療養環境基準ラジオグループモデルに内部項目を追加します。
   */
  protected void addShortStayRecuperationEnvironmentalModel(){

    getShortStayRecuperationEnvironmentalStandard().setButtonIndex(1);
    getShortStayRecuperationEnvironmentalModel().add(getShortStayRecuperationEnvironmentalStandard());

    getShortStayRecuperationEnvironmentalSubtraction1().setButtonIndex(2);
    getShortStayRecuperationEnvironmentalModel().add(getShortStayRecuperationEnvironmentalSubtraction1());

    getShortStayRecuperationEnvironmentalSubtraction2().setButtonIndex(3);
    getShortStayRecuperationEnvironmentalModel().add(getShortStayRecuperationEnvironmentalSubtraction2());

  }

  /**
   * 基準型に内部項目を追加します。
   */
  protected void addShortStayRecuperationEnvironmentalStandard(){

  }

  /**
   * 減算型Iに内部項目を追加します。
   */
  protected void addShortStayRecuperationEnvironmentalSubtraction1(){

  }

  /**
   * 減算型IIに内部項目を追加します。
   */
  protected void addShortStayRecuperationEnvironmentalSubtraction2(){

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

    getShortStayMeetingAndSendingOffSystemOff().setButtonIndex(1);
    getShortStayMeetingAndSendingOffSystemModel().add(getShortStayMeetingAndSendingOffSystemOff());

    getShortStayMeetingAndSendingOffSystemOn().setButtonIndex(2);
    getShortStayMeetingAndSendingOffSystemModel().add(getShortStayMeetingAndSendingOffSystemOn());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayMeetingAndSendingOffSystemOff(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayMeetingAndSendingOffSystemOn(){

  }

  /**
   * 栄養管理体制ラジオグループに内部項目を追加します。
   */
  protected void addShortStayNutritionManageRadio(){

  }

  /**
   * 栄養管理体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addShortStayNutritionManageRadioModel(){

    getShortStayNutritionManageRadioItem1().setButtonIndex(1);
    getShortStayNutritionManageRadioModel().add(getShortStayNutritionManageRadioItem1());

    getShortStayNutritionManageRadioItem2().setButtonIndex(2);
    getShortStayNutritionManageRadioModel().add(getShortStayNutritionManageRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayNutritionManageRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayNutritionManageRadioItem2(){

  }

  /**
   * 療養食体制ラジオグループに内部項目を追加します。
   */
  protected void addShortStayRecuperateDinnerRadio(){

  }

  /**
   * 療養食体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addShortStayRecuperateDinnerRadioModel(){

    getShortStayRecuperateDinnerRadioItem1().setButtonIndex(1);
    getShortStayRecuperateDinnerRadioModel().add(getShortStayRecuperateDinnerRadioItem1());

    getShortStayRecuperateDinnerRadioItem2().setButtonIndex(2);
    getShortStayRecuperateDinnerRadioModel().add(getShortStayRecuperateDinnerRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayRecuperateDinnerRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayRecuperateDinnerRadioItem2(){

  }

  /**
   * 人員減算ラジオグループに内部項目を追加します。
   */
  protected void addShortStayStaffReduce(){

  }

  /**
   * 人員減算ラジオグループモデルに内部項目を追加します。
   */
  protected void addShortStayStaffReduceModel(){

    getShortStayStaffNot().setButtonIndex(1);
    getShortStayStaffReduceModel().add(getShortStayStaffNot());

    getShortStayStaffExcess().setButtonIndex(2);
    getShortStayStaffReduceModel().add(getShortStayStaffExcess());

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
   * 食費基準額・コンテナに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareClinicDinnerStandeirdMoneyConteiner(){

    shortStayRecuperateCareClinicDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareClinicDinnerStandeirdMoneyTotal(), VRLayout.FLOW);

    shortStayRecuperateCareClinicDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareClinicMorningDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    shortStayRecuperateCareClinicDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareClinicMorningDinnerStandeirdMoney(), VRLayout.FLOW);

    shortStayRecuperateCareClinicDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareClinicNoonDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    shortStayRecuperateCareClinicDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareClinicNoonDinnerStandeirdMoney(), VRLayout.FLOW);

    shortStayRecuperateCareClinicDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareClinicNightDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    shortStayRecuperateCareClinicDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareClinicNightDinnerStandeirdMoney(), VRLayout.FLOW);

    shortStayRecuperateCareClinicDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareClinicDinnerStandeirdMoney4Label(), VRLayout.FLOW);

  }

  /**
   * 食費基準額・合計・テキストに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareClinicDinnerStandeirdMoneyTotal(){

  }

  /**
   * 食費基準額・朝・ラベルに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareClinicMorningDinnerStandeirdMoneyLabel(){

  }

  /**
   * 食費基準額・朝・テキストに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareClinicMorningDinnerStandeirdMoney(){

  }

  /**
   * 食費基準額・昼・ラベルに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareClinicNoonDinnerStandeirdMoneyLabel(){

  }

  /**
   * 食費基準額・昼・テキストに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareClinicNoonDinnerStandeirdMoney(){

  }

  /**
   * 食費基準額・夜・ラベルに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareClinicNightDinnerStandeirdMoneyLabel(){

  }

  /**
   * 食費基準額・夜・テキストに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareClinicNightDinnerStandeirdMoney(){

  }

  /**
   * 食費基準額・ラベルに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareClinicDinnerStandeirdMoney4Label(){

  }

  /**
   * ユニット型個室基準額・コンテナに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareClinicUnitRoomStandeirdMoneyConteiner(){

    shortStayRecuperateCareClinicUnitRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareClinicUnitRoomStandeirdMoneyText(), null);

    shortStayRecuperateCareClinicUnitRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareClinicUnitRoomStandeirdMoneyLabel(), null);

  }

  /**
   * ユニット型個室基準額・テキストに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareClinicUnitRoomStandeirdMoneyText(){

  }

  /**
   * ユニット型個室基準額・ラベルに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareClinicUnitRoomStandeirdMoneyLabel(){

  }

  /**
   * ユニット型準個室基準額・コンテナに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyConteiner(){

    shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyText(), null);

    shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyLabel(), null);

  }

  /**
   * ユニット型準個室基準額・テキストに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyText(){

  }

  /**
   * ユニット型準個室基準額・ラベルに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyLabel(){

  }

  /**
   * 従来型個室基準額・コンテナに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareClinicNormalRoomStandeirdMoneyConteiner(){

    shortStayRecuperateCareClinicNormalRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareClinicNormalRoomStandeirdMoneyText(), null);

    shortStayRecuperateCareClinicNormalRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareClinicNormalRoomStandeirdMoneyLabel(), null);

  }

  /**
   * 従来型個室基準額・テキストに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareClinicNormalRoomStandeirdMoneyText(){

  }

  /**
   * 従来型個室基準額・ラベルに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareClinicNormalRoomStandeirdMoneyLabel(){

  }

  /**
   * 多床室基準額・コンテナに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareClinicTasyouRoomConteiner(){

    shortStayRecuperateCareClinicTasyouRoomConteiner.add(getShortStayRecuperateCareClinicTasyouRoomText(), null);

    shortStayRecuperateCareClinicTasyouRoomConteiner.add(getShortStayRecuperateCareClinicTasyouRoomLabel(), null);

  }

  /**
   * 多床室基準額・テキストに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareClinicTasyouRoomText(){

  }

  /**
   * 多床室基準額・ラベルに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareClinicTasyouRoomLabel(){

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
      ACFrame.getInstance().getContentPane().add(new QO004011Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004011Design getThis() {
    return this;
  }
}
