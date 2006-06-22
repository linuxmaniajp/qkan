
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
 * プログラム （介護療養型医療施設（診療所型） (QO004019)
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
 * （介護療養型医療施設（診療所型）画面項目デザイン(QO004019) 
 */
public class QO004019Design extends ACPanel {
  //GUIコンポーネント

  private ACGroupBox kaigoRecuperationMedicalFacilitiesClinicGroup;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesClinicDiscountContainer;

  private ACTextField kaigoRecuperationMedicalFacilitiesClinicDiscountRate;

  private ACLabel kaigoRecuperationMedicalFacilitiesClinicPercentSign;

  private ACClearableRadioButtonGroup kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadio;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioContainer;

  private ACListModelAdapter kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioModel;

  private ACRadioButtonItem kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem1;

  private ACRadioButtonItem kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem2;

  private ACClearableRadioButtonGroup kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionContainer;

  private ACListModelAdapter kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionModel;

  private ACRadioButtonItem kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision1;

  private ACRadioButtonItem kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision2;

  private ACClearableRadioButtonGroup kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmental;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalContainer;

  private ACListModelAdapter kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalModel;

  private ACRadioButtonItem kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalStandard;

  private ACRadioButtonItem kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction1;

  private ACRadioButtonItem kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction2;

  private ACClearableRadioButtonGroup kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadio;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioContainer;

  private ACListModelAdapter kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioModel;

  private ACRadioButtonItem kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem1;

  private ACRadioButtonItem kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem2;

  private ACClearableRadioButtonGroup kaigoRecuperationMedicalFacilitiesClinicNutritionRadio;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesClinicNutritionRadioContainer;

  private ACListModelAdapter kaigoRecuperationMedicalFacilitiesClinicNutritionRadioModel;

  private ACRadioButtonItem kaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem1;

  private ACRadioButtonItem kaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem2 ;

  private ACClearableRadioButtonGroup kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadio;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioContainer;

  private ACListModelAdapter kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioModel;

  private ACRadioButtonItem kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem1;

  private ACRadioButtonItem kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem2 ;

  private ACClearableRadioButtonGroup kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadio;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioContainer;

  private ACListModelAdapter kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioModel;

  private ACRadioButtonItem kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem1;

  private ACRadioButtonItem kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem2;

  private ACClearableRadioButtonGroup kaigoRecuperationMedicalFacilitiesClinicStaffReduce;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesClinicStaffReduceContainer;

  private ACListModelAdapter kaigoRecuperationMedicalFacilitiesClinicStaffReduceModel;

  private ACRadioButtonItem kaigoRecuperationMedicalFacilitiesClinicStaffNot;

  private ACRadioButtonItem kaigoRecuperationMedicalFacilitiesClinicStaffExcess;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner;

  private ACTextField kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyTotal;

  private ACLabel kaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoneyLabel;

  private ACTextField kaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney;

  private ACLabel kaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoneyLabel;

  private ACTextField kaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney;

  private ACLabel kaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoneyLabel;

  private ACTextField kaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney;

  private ACLabel kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoney4Label;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyConteiner;

  private ACTextField kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyText;

  private ACLabel kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyLabel;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyConteiner;

  private ACTextField kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyText;

  private ACLabel kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyLabel;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyConteiner;

  private ACTextField kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyText;

  private ACLabel kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyLabel;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesClinicTasyouRoomConteiner;

  private ACTextField kaigoRecuperationMedicalFacilitiesClinicTasyouRoomText;

  private ACLabel kaigoRecuperationMedicalFacilitiesClinicTasyouRoomLabel;

  //getter

  /**
   * 事業グループを取得します。
   * @return 事業グループ
   */
  public ACGroupBox getKaigoRecuperationMedicalFacilitiesClinicGroup(){
    if(kaigoRecuperationMedicalFacilitiesClinicGroup==null){

      kaigoRecuperationMedicalFacilitiesClinicGroup = new ACGroupBox();

      kaigoRecuperationMedicalFacilitiesClinicGroup.setText("介護療養型医療施設（診療所型）");

      kaigoRecuperationMedicalFacilitiesClinicGroup.setFollowChildEnabled(true);

      kaigoRecuperationMedicalFacilitiesClinicGroup.setHgrid(200);

      addKaigoRecuperationMedicalFacilitiesClinicGroup();
    }
    return kaigoRecuperationMedicalFacilitiesClinicGroup;

  }

  /**
   * 割引率コンテナを取得します。
   * @return 割引率コンテナ
   */
  public ACLabelContainer getKaigoRecuperationMedicalFacilitiesClinicDiscountContainer(){
    if(kaigoRecuperationMedicalFacilitiesClinicDiscountContainer==null){

      kaigoRecuperationMedicalFacilitiesClinicDiscountContainer = new ACLabelContainer();

      kaigoRecuperationMedicalFacilitiesClinicDiscountContainer.setText("割引率");

      kaigoRecuperationMedicalFacilitiesClinicDiscountContainer.setFollowChildEnabled(true);

      addKaigoRecuperationMedicalFacilitiesClinicDiscountContainer();
    }
    return kaigoRecuperationMedicalFacilitiesClinicDiscountContainer;

  }

  /**
   * 割引率を取得します。
   * @return 割引率
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesClinicDiscountRate(){
    if(kaigoRecuperationMedicalFacilitiesClinicDiscountRate==null){

      kaigoRecuperationMedicalFacilitiesClinicDiscountRate = new ACTextField();

      kaigoRecuperationMedicalFacilitiesClinicDiscountRate.setBindPath("REDUCT_RATE");

      kaigoRecuperationMedicalFacilitiesClinicDiscountRate.setColumns(3);

      kaigoRecuperationMedicalFacilitiesClinicDiscountRate.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesClinicDiscountRate.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesClinicDiscountRate.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesClinicDiscountRate.setMaxLength(3);

      addKaigoRecuperationMedicalFacilitiesClinicDiscountRate();
    }
    return kaigoRecuperationMedicalFacilitiesClinicDiscountRate;

  }

  /**
   * ％ラベルを取得します。
   * @return ％ラベル
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesClinicPercentSign(){
    if(kaigoRecuperationMedicalFacilitiesClinicPercentSign==null){

      kaigoRecuperationMedicalFacilitiesClinicPercentSign = new ACLabel();

      kaigoRecuperationMedicalFacilitiesClinicPercentSign.setText("％");

      addKaigoRecuperationMedicalFacilitiesClinicPercentSign();
    }
    return kaigoRecuperationMedicalFacilitiesClinicPercentSign;

  }

  /**
   * 施設区分ラジオグループを取得します。
   * @return 施設区分ラジオグループ
   */
  public ACClearableRadioButtonGroup getKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadio(){
    if(kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadio==null){

      kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadio = new ACClearableRadioButtonGroup();

      getKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioContainer().setText("施設区分");

      kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadio.setBindPath("1530201");

      kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadio.setModel(getKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioModel());

      kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadio.setUseClearButton(false);

      addKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadio();
    }
    return kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadio;

  }

  /**
   * 施設区分ラジオグループコンテナを取得します。
   * @return 施設区分ラジオグループコンテナ
   */
  protected ACLabelContainer getKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioContainer(){
    if(kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioContainer==null){
      kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioContainer = new ACLabelContainer();
      kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioContainer.add(getKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadio(), null);
    }
    return kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioContainer;
  }

  /**
   * 施設区分ラジオグループモデルを取得します。
   * @return 施設区分ラジオグループモデル
   */
  protected ACListModelAdapter getKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioModel(){
    if(kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioModel==null){
      kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioModel = new ACListModelAdapter();
      addKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioModel();
    }
    return kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioModel;
  }

  /**
   * 診療所を取得します。
   * @return 診療所
   */
  public ACRadioButtonItem getKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem1(){
    if(kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem1==null){

      kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem1.setText("診療所");

      kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem1.setGroup(getKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadio());

      addKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem1();
    }
    return kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem1;

  }

  /**
   * ユニット型診療所を取得します。
   * @return ユニット型診療所
   */
  public ACRadioButtonItem getKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem2(){
    if(kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem2==null){

      kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem2.setText("ユニット型診療所");

      kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem2.setGroup(getKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadio());

      addKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem2();
    }
    return kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem2;

  }

  /**
   * 人員配置区分ラジオグループを取得します。
   * @return 人員配置区分ラジオグループ
   */
  public ACClearableRadioButtonGroup getKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision(){
    if(kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision==null){

      kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision = new ACClearableRadioButtonGroup();

      getKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionContainer().setText("人員配置区分");

      kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision.setBindPath("1530202");

      kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision.setModel(getKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionModel());

      kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision.setUseClearButton(false);

      addKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision();
    }
    return kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision;

  }

  /**
   * 人員配置区分ラジオグループコンテナを取得します。
   * @return 人員配置区分ラジオグループコンテナ
   */
  protected ACLabelContainer getKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionContainer(){
    if(kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionContainer==null){
      kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionContainer = new ACLabelContainer();
      kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionContainer.setFollowChildEnabled(true);
      kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionContainer.add(getKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision(), null);
    }
    return kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionContainer;
  }

  /**
   * 人員配置区分ラジオグループモデルを取得します。
   * @return 人員配置区分ラジオグループモデル
   */
  protected ACListModelAdapter getKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionModel(){
    if(kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionModel==null){
      kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionModel = new ACListModelAdapter();
      addKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionModel();
    }
    return kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionModel;
  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision1(){
    if(kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision1==null){

      kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision1 = new ACRadioButtonItem();

      kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision1.setText("I型");

      kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision1.setGroup(getKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision());

      addKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision1();
    }
    return kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision1;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision2(){
    if(kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision2==null){

      kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision2 = new ACRadioButtonItem();

      kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision2.setText("II型");

      kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision2.setGroup(getKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision());

      addKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision2();
    }
    return kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision2;

  }

  /**
   * 療養環境基準ラジオグループを取得します。
   * @return 療養環境基準ラジオグループ
   */
  public ACClearableRadioButtonGroup getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmental(){
    if(kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmental==null){

      kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmental = new ACClearableRadioButtonGroup();

      getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalContainer().setText("療養環境基準");

      kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmental.setBindPath("1530203");

      kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmental.setModel(getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalModel());

      kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmental.setUseClearButton(false);

      addKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmental();
    }
    return kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmental;

  }

  /**
   * 療養環境基準ラジオグループコンテナを取得します。
   * @return 療養環境基準ラジオグループコンテナ
   */
  protected ACLabelContainer getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalContainer(){
    if(kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalContainer==null){
      kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalContainer = new ACLabelContainer();
      kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalContainer.setFollowChildEnabled(true);
      kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalContainer.add(getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmental(), null);
    }
    return kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalContainer;
  }

  /**
   * 療養環境基準ラジオグループモデルを取得します。
   * @return 療養環境基準ラジオグループモデル
   */
  protected ACListModelAdapter getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalModel(){
    if(kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalModel==null){
      kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalModel = new ACListModelAdapter();
      addKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalModel();
    }
    return kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalModel;
  }

  /**
   * 基準型を取得します。
   * @return 基準型
   */
  public ACRadioButtonItem getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalStandard(){
    if(kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalStandard==null){

      kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalStandard = new ACRadioButtonItem();

      kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalStandard.setText("基準型");

      kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalStandard.setGroup(getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmental());

      addKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalStandard();
    }
    return kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalStandard;

  }

  /**
   * 減算型Iを取得します。
   * @return 減算型I
   */
  public ACRadioButtonItem getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction1(){
    if(kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction1==null){

      kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction1 = new ACRadioButtonItem();

      kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction1.setText("減算型I");

      kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction1.setGroup(getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmental());

      addKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction1();
    }
    return kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction1;

  }

  /**
   * 減算型IIを取得します。
   * @return 減算型II
   */
  public ACRadioButtonItem getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction2(){
    if(kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction2==null){

      kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction2 = new ACRadioButtonItem();

      kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction2.setText("減算型II");

      kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction2.setGroup(getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmental());

      addKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction2();
    }
    return kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction2;

  }

  /**
   * 栄養管理体制ラジオグループを取得します。
   * @return 栄養管理体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadio(){
    if(kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadio==null){

      kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadio = new ACClearableRadioButtonGroup();

      getKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioContainer().setText("栄養管理体制");

      kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadio.setBindPath("1530204");

      kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadio.setModel(getKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioModel());

      kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadio.setUseClearButton(false);

      addKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadio();
    }
    return kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadio;

  }

  /**
   * 栄養管理体制ラジオグループコンテナを取得します。
   * @return 栄養管理体制ラジオグループコンテナ
   */
  protected ACLabelContainer getKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioContainer(){
    if(kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioContainer==null){
      kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioContainer = new ACLabelContainer();
      kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioContainer.setFollowChildEnabled(true);
      kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioContainer.add(getKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadio(), null);
    }
    return kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioContainer;
  }

  /**
   * 栄養管理体制ラジオグループモデルを取得します。
   * @return 栄養管理体制ラジオグループモデル
   */
  protected ACListModelAdapter getKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioModel(){
    if(kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioModel==null){
      kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioModel = new ACListModelAdapter();
      addKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioModel();
    }
    return kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem1(){
    if(kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem1==null){

      kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem1 = new ACRadioButtonItem();

      kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem1.setText("なし");

      kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem1.setGroup(getKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadio());

      addKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem1();
    }
    return kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem2(){
    if(kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem2==null){

      kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem2 = new ACRadioButtonItem();

      kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem2.setText("あり");

      kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem2.setGroup(getKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadio());

      addKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem2();
    }
    return kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem2;

  }

  /**
   * 栄養マネジメント体制ラジオグループを取得します。
   * @return 栄養マネジメント体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getKaigoRecuperationMedicalFacilitiesClinicNutritionRadio(){
    if(kaigoRecuperationMedicalFacilitiesClinicNutritionRadio==null){

      kaigoRecuperationMedicalFacilitiesClinicNutritionRadio = new ACClearableRadioButtonGroup();

      getKaigoRecuperationMedicalFacilitiesClinicNutritionRadioContainer().setText("栄養マネジメント体制");

      kaigoRecuperationMedicalFacilitiesClinicNutritionRadio.setBindPath("1530205");

      kaigoRecuperationMedicalFacilitiesClinicNutritionRadio.setModel(getKaigoRecuperationMedicalFacilitiesClinicNutritionRadioModel());

      kaigoRecuperationMedicalFacilitiesClinicNutritionRadio.setUseClearButton(false);

      addKaigoRecuperationMedicalFacilitiesClinicNutritionRadio();
    }
    return kaigoRecuperationMedicalFacilitiesClinicNutritionRadio;

  }

  /**
   * 栄養マネジメント体制ラジオグループコンテナを取得します。
   * @return 栄養マネジメント体制ラジオグループコンテナ
   */
  protected ACLabelContainer getKaigoRecuperationMedicalFacilitiesClinicNutritionRadioContainer(){
    if(kaigoRecuperationMedicalFacilitiesClinicNutritionRadioContainer==null){
      kaigoRecuperationMedicalFacilitiesClinicNutritionRadioContainer = new ACLabelContainer();
      kaigoRecuperationMedicalFacilitiesClinicNutritionRadioContainer.setFollowChildEnabled(true);
      kaigoRecuperationMedicalFacilitiesClinicNutritionRadioContainer.add(getKaigoRecuperationMedicalFacilitiesClinicNutritionRadio(), null);
    }
    return kaigoRecuperationMedicalFacilitiesClinicNutritionRadioContainer;
  }

  /**
   * 栄養マネジメント体制ラジオグループモデルを取得します。
   * @return 栄養マネジメント体制ラジオグループモデル
   */
  protected ACListModelAdapter getKaigoRecuperationMedicalFacilitiesClinicNutritionRadioModel(){
    if(kaigoRecuperationMedicalFacilitiesClinicNutritionRadioModel==null){
      kaigoRecuperationMedicalFacilitiesClinicNutritionRadioModel = new ACListModelAdapter();
      addKaigoRecuperationMedicalFacilitiesClinicNutritionRadioModel();
    }
    return kaigoRecuperationMedicalFacilitiesClinicNutritionRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem1(){
    if(kaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem1==null){

      kaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem1 = new ACRadioButtonItem();

      kaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem1.setText("なし");

      kaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem1.setGroup(getKaigoRecuperationMedicalFacilitiesClinicNutritionRadio());

      addKaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem1();
    }
    return kaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getKaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem2 (){
    if(kaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem2 ==null){

      kaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem2  = new ACRadioButtonItem();

      kaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem2 .setText("あり");

      kaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem2 .setGroup(getKaigoRecuperationMedicalFacilitiesClinicNutritionRadio());

      addKaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem2 ();
    }
    return kaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem2 ;

  }

  /**
   * 経口移行体制ラジオグループを取得します。
   * @return 経口移行体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadio(){
    if(kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadio==null){

      kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadio = new ACClearableRadioButtonGroup();

      getKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioContainer().setText("経口移行体制");

      kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadio.setBindPath("1530206");

      kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadio.setModel(getKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioModel());

      kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadio.setUseClearButton(false);

      addKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadio();
    }
    return kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadio;

  }

  /**
   * 経口移行体制ラジオグループコンテナを取得します。
   * @return 経口移行体制ラジオグループコンテナ
   */
  protected ACLabelContainer getKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioContainer(){
    if(kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioContainer==null){
      kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioContainer = new ACLabelContainer();
      kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioContainer.setFollowChildEnabled(true);
      kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioContainer.add(getKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadio(), null);
    }
    return kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioContainer;
  }

  /**
   * 経口移行体制ラジオグループモデルを取得します。
   * @return 経口移行体制ラジオグループモデル
   */
  protected ACListModelAdapter getKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioModel(){
    if(kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioModel==null){
      kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioModel = new ACListModelAdapter();
      addKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioModel();
    }
    return kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem1(){
    if(kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem1==null){

      kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem1 = new ACRadioButtonItem();

      kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem1.setText("なし");

      kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem1.setGroup(getKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadio());

      addKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem1();
    }
    return kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem2 (){
    if(kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem2 ==null){

      kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem2  = new ACRadioButtonItem();

      kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem2 .setText("あり");

      kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem2 .setGroup(getKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadio());

      addKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem2 ();
    }
    return kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem2 ;

  }

  /**
   * 療養食体制ラジオグループを取得します。
   * @return 療養食体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadio(){
    if(kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadio==null){

      kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadio = new ACClearableRadioButtonGroup();

      getKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioContainer().setText("療養食体制");

      kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadio.setBindPath("1530207");

      kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadio.setModel(getKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioModel());

      kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadio.setUseClearButton(false);

      addKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadio();
    }
    return kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadio;

  }

  /**
   * 療養食体制ラジオグループコンテナを取得します。
   * @return 療養食体制ラジオグループコンテナ
   */
  protected ACLabelContainer getKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioContainer(){
    if(kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioContainer==null){
      kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioContainer = new ACLabelContainer();
      kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioContainer.setFollowChildEnabled(true);
      kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioContainer.add(getKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadio(), null);
    }
    return kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioContainer;
  }

  /**
   * 療養食体制ラジオグループモデルを取得します。
   * @return 療養食体制ラジオグループモデル
   */
  protected ACListModelAdapter getKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioModel(){
    if(kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioModel==null){
      kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioModel = new ACListModelAdapter();
      addKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioModel();
    }
    return kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem1(){
    if(kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem1==null){

      kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem1 = new ACRadioButtonItem();

      kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem1.setText("なし");

      kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem1.setGroup(getKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadio());

      addKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem1();
    }
    return kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem2(){
    if(kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem2==null){

      kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem2 = new ACRadioButtonItem();

      kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem2.setText("あり");

      kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem2.setGroup(getKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadio());

      addKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem2();
    }
    return kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem2;

  }

  /**
   * 人員減算ラジオグループを取得します。
   * @return 人員減算ラジオグループ
   */
  public ACClearableRadioButtonGroup getKaigoRecuperationMedicalFacilitiesClinicStaffReduce(){
    if(kaigoRecuperationMedicalFacilitiesClinicStaffReduce==null){

      kaigoRecuperationMedicalFacilitiesClinicStaffReduce = new ACClearableRadioButtonGroup();

      getKaigoRecuperationMedicalFacilitiesClinicStaffReduceContainer().setText("人員減算");

      kaigoRecuperationMedicalFacilitiesClinicStaffReduce.setBindPath("1530208");

      kaigoRecuperationMedicalFacilitiesClinicStaffReduce.setModel(getKaigoRecuperationMedicalFacilitiesClinicStaffReduceModel());

      kaigoRecuperationMedicalFacilitiesClinicStaffReduce.setUseClearButton(false);

      addKaigoRecuperationMedicalFacilitiesClinicStaffReduce();
    }
    return kaigoRecuperationMedicalFacilitiesClinicStaffReduce;

  }

  /**
   * 人員減算ラジオグループコンテナを取得します。
   * @return 人員減算ラジオグループコンテナ
   */
  protected ACLabelContainer getKaigoRecuperationMedicalFacilitiesClinicStaffReduceContainer(){
    if(kaigoRecuperationMedicalFacilitiesClinicStaffReduceContainer==null){
      kaigoRecuperationMedicalFacilitiesClinicStaffReduceContainer = new ACLabelContainer();
      kaigoRecuperationMedicalFacilitiesClinicStaffReduceContainer.setFollowChildEnabled(true);
      kaigoRecuperationMedicalFacilitiesClinicStaffReduceContainer.add(getKaigoRecuperationMedicalFacilitiesClinicStaffReduce(), null);
    }
    return kaigoRecuperationMedicalFacilitiesClinicStaffReduceContainer;
  }

  /**
   * 人員減算ラジオグループモデルを取得します。
   * @return 人員減算ラジオグループモデル
   */
  protected ACListModelAdapter getKaigoRecuperationMedicalFacilitiesClinicStaffReduceModel(){
    if(kaigoRecuperationMedicalFacilitiesClinicStaffReduceModel==null){
      kaigoRecuperationMedicalFacilitiesClinicStaffReduceModel = new ACListModelAdapter();
      addKaigoRecuperationMedicalFacilitiesClinicStaffReduceModel();
    }
    return kaigoRecuperationMedicalFacilitiesClinicStaffReduceModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKaigoRecuperationMedicalFacilitiesClinicStaffNot(){
    if(kaigoRecuperationMedicalFacilitiesClinicStaffNot==null){

      kaigoRecuperationMedicalFacilitiesClinicStaffNot = new ACRadioButtonItem();

      kaigoRecuperationMedicalFacilitiesClinicStaffNot.setText("なし");

      kaigoRecuperationMedicalFacilitiesClinicStaffNot.setGroup(getKaigoRecuperationMedicalFacilitiesClinicStaffReduce());

      addKaigoRecuperationMedicalFacilitiesClinicStaffNot();
    }
    return kaigoRecuperationMedicalFacilitiesClinicStaffNot;

  }

  /**
   * 定員超過を取得します。
   * @return 定員超過
   */
  public ACRadioButtonItem getKaigoRecuperationMedicalFacilitiesClinicStaffExcess(){
    if(kaigoRecuperationMedicalFacilitiesClinicStaffExcess==null){

      kaigoRecuperationMedicalFacilitiesClinicStaffExcess = new ACRadioButtonItem();

      kaigoRecuperationMedicalFacilitiesClinicStaffExcess.setText("定員超過");

      kaigoRecuperationMedicalFacilitiesClinicStaffExcess.setGroup(getKaigoRecuperationMedicalFacilitiesClinicStaffReduce());

      addKaigoRecuperationMedicalFacilitiesClinicStaffExcess();
    }
    return kaigoRecuperationMedicalFacilitiesClinicStaffExcess;

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

      kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyTotal.setBindPath("1530209");

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

      kaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney.setBindPath("1530210");

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

      kaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney.setBindPath("1530211");

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

      kaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney.setBindPath("1530212");

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
  public ACLabel getKaigoRecuperationMedicalFacilitiesDinnerStandeirdMoney4Label(){
    if(kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoney4Label==null){

      kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoney4Label = new ACLabel();

      kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoney4Label.setText("（円）");

      addKaigoRecuperationMedicalFacilitiesDinnerStandeirdMoney4Label();
    }
    return kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoney4Label;

  }

  /**
   * ユニット型個室基準額・コンテナを取得します。
   * @return ユニット型個室基準額・コンテナ
   */
  public ACLabelContainer getKaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyConteiner(){
    if(kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyConteiner==null){

      kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyConteiner = new ACLabelContainer();

      kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyConteiner.setText("ユニット型個室基準額");

      kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addKaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyConteiner();
    }
    return kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyConteiner;

  }

  /**
   * ユニット型個室基準額・テキストを取得します。
   * @return ユニット型個室基準額・テキスト
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyText(){
    if(kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyText==null){

      kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyText = new ACTextField();

      kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyText.setBindPath("1530213");

      kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyText.setColumns(4);

      kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyText.setMaxLength(4);

      addKaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyText();
    }
    return kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyText;

  }

  /**
   * ユニット型個室基準額・ラベルを取得します。
   * @return ユニット型個室基準額・ラベル
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyLabel(){
    if(kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyLabel==null){

      kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyLabel = new ACLabel();

      kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyLabel.setText("（円）");

      addKaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyLabel();
    }
    return kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyLabel;

  }

  /**
   * ユニット型準個室基準額・コンテナを取得します。
   * @return ユニット型準個室基準額・コンテナ
   */
  public ACLabelContainer getKaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyConteiner(){
    if(kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyConteiner==null){

      kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyConteiner = new ACLabelContainer();

      kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyConteiner.setText("ユニット型準個室基準額");

      kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addKaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyConteiner();
    }
    return kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyConteiner;

  }

  /**
   * ユニット型準個室基準額・テキストを取得します。
   * @return ユニット型準個室基準額・テキスト
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyText(){
    if(kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyText==null){

      kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyText = new ACTextField();

      kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyText.setBindPath("1530214");

      kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyText.setColumns(4);

      kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyText.setMaxLength(4);

      addKaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyText();
    }
    return kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyText;

  }

  /**
   * ユニット型準個室基準額・ラベルを取得します。
   * @return ユニット型準個室基準額・ラベル
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyLabel(){
    if(kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyLabel==null){

      kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyLabel = new ACLabel();

      kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyLabel.setText("（円）");

      addKaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyLabel();
    }
    return kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyLabel;

  }

  /**
   * 従来型個室基準額・コンテナを取得します。
   * @return 従来型個室基準額・コンテナ
   */
  public ACLabelContainer getKaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyConteiner(){
    if(kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyConteiner==null){

      kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyConteiner = new ACLabelContainer();

      kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyConteiner.setText("　　従来型個室基準額");

      kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addKaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyConteiner();
    }
    return kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyConteiner;

  }

  /**
   * 従来型個室基準額・テキストを取得します。
   * @return 従来型個室基準額・テキスト
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyText(){
    if(kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyText==null){

      kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyText = new ACTextField();

      kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyText.setBindPath("1530215");

      kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyText.setColumns(4);

      kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyText.setMaxLength(4);

      addKaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyText();
    }
    return kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyText;

  }

  /**
   * 従来型個室基準額・ラベルを取得します。
   * @return 従来型個室基準額・ラベル
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyLabel(){
    if(kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyLabel==null){

      kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyLabel = new ACLabel();

      kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyLabel.setText("（円）");

      addKaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyLabel();
    }
    return kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyLabel;

  }

  /**
   * 多床室基準額・コンテナを取得します。
   * @return 多床室基準額・コンテナ
   */
  public ACLabelContainer getKaigoRecuperationMedicalFacilitiesClinicTasyouRoomConteiner(){
    if(kaigoRecuperationMedicalFacilitiesClinicTasyouRoomConteiner==null){

      kaigoRecuperationMedicalFacilitiesClinicTasyouRoomConteiner = new ACLabelContainer();

      kaigoRecuperationMedicalFacilitiesClinicTasyouRoomConteiner.setText("　　多床室基準額");

      kaigoRecuperationMedicalFacilitiesClinicTasyouRoomConteiner.setFollowChildEnabled(true);

      addKaigoRecuperationMedicalFacilitiesClinicTasyouRoomConteiner();
    }
    return kaigoRecuperationMedicalFacilitiesClinicTasyouRoomConteiner;

  }

  /**
   * 多床室基準額・テキストを取得します。
   * @return 多床室基準額・テキスト
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesClinicTasyouRoomText(){
    if(kaigoRecuperationMedicalFacilitiesClinicTasyouRoomText==null){

      kaigoRecuperationMedicalFacilitiesClinicTasyouRoomText = new ACTextField();

      kaigoRecuperationMedicalFacilitiesClinicTasyouRoomText.setBindPath("1530216");

      kaigoRecuperationMedicalFacilitiesClinicTasyouRoomText.setColumns(4);

      kaigoRecuperationMedicalFacilitiesClinicTasyouRoomText.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesClinicTasyouRoomText.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesClinicTasyouRoomText.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesClinicTasyouRoomText.setMaxLength(4);

      addKaigoRecuperationMedicalFacilitiesClinicTasyouRoomText();
    }
    return kaigoRecuperationMedicalFacilitiesClinicTasyouRoomText;

  }

  /**
   * 多床室基準額・ラベルを取得します。
   * @return 多床室基準額・ラベル
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesClinicTasyouRoomLabel(){
    if(kaigoRecuperationMedicalFacilitiesClinicTasyouRoomLabel==null){

      kaigoRecuperationMedicalFacilitiesClinicTasyouRoomLabel = new ACLabel();

      kaigoRecuperationMedicalFacilitiesClinicTasyouRoomLabel.setText("（円）");

      addKaigoRecuperationMedicalFacilitiesClinicTasyouRoomLabel();
    }
    return kaigoRecuperationMedicalFacilitiesClinicTasyouRoomLabel;

  }

  /**
   * コンストラクタです。
   */
  public QO004019Design() {

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

    this.add(getKaigoRecuperationMedicalFacilitiesClinicGroup(), VRLayout.CLIENT);

  }

  /**
   * 事業グループに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicGroup(){

    kaigoRecuperationMedicalFacilitiesClinicGroup.add(getKaigoRecuperationMedicalFacilitiesClinicDiscountContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesClinicGroup.add(getKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesClinicGroup.add(getKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesClinicGroup.add(getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesClinicGroup.add(getKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesClinicGroup.add(getKaigoRecuperationMedicalFacilitiesClinicNutritionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesClinicGroup.add(getKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesClinicGroup.add(getKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesClinicGroup.add(getKaigoRecuperationMedicalFacilitiesClinicStaffReduceContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesClinicGroup.add(getKaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesClinicGroup.add(getKaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesClinicGroup.add(getKaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesClinicGroup.add(getKaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesClinicGroup.add(getKaigoRecuperationMedicalFacilitiesClinicTasyouRoomConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 割引率コンテナに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicDiscountContainer(){

    kaigoRecuperationMedicalFacilitiesClinicDiscountContainer.add(getKaigoRecuperationMedicalFacilitiesClinicDiscountRate(), VRLayout.FLOW);

    kaigoRecuperationMedicalFacilitiesClinicDiscountContainer.add(getKaigoRecuperationMedicalFacilitiesClinicPercentSign(), VRLayout.FLOW);

  }

  /**
   * 割引率に内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicDiscountRate(){

  }

  /**
   * ％ラベルに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicPercentSign(){

  }

  /**
   * 施設区分ラジオグループに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadio(){

  }

  /**
   * 施設区分ラジオグループモデルに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioModel(){

    getKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem1().setButtonIndex(1);
    getKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioModel().add(getKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem1());

    getKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem2().setButtonIndex(2);
    getKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioModel().add(getKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem2());

  }

  /**
   * 診療所に内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem1(){

  }

  /**
   * ユニット型診療所に内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem2(){

  }

  /**
   * 人員配置区分ラジオグループに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision(){

  }

  /**
   * 人員配置区分ラジオグループモデルに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionModel(){

    getKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision1().setButtonIndex(1);
    getKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionModel().add(getKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision1());

    getKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision2().setButtonIndex(2);
    getKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionModel().add(getKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision2());

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision1(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision2(){

  }

  /**
   * 療養環境基準ラジオグループに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmental(){

  }

  /**
   * 療養環境基準ラジオグループモデルに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalModel(){

    getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalStandard().setButtonIndex(1);
    getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalModel().add(getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalStandard());

    getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction1().setButtonIndex(2);
    getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalModel().add(getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction1());

    getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction2().setButtonIndex(3);
    getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalModel().add(getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction2());

  }

  /**
   * 基準型に内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalStandard(){

  }

  /**
   * 減算型Iに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction1(){

  }

  /**
   * 減算型IIに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction2(){

  }

  /**
   * 栄養管理体制ラジオグループに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadio(){

  }

  /**
   * 栄養管理体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioModel(){

    getKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem1().setButtonIndex(1);
    getKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioModel().add(getKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem1());

    getKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem2().setButtonIndex(2);
    getKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioModel().add(getKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem2(){

  }

  /**
   * 栄養マネジメント体制ラジオグループに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicNutritionRadio(){

  }

  /**
   * 栄養マネジメント体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicNutritionRadioModel(){

    getKaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem1().setButtonIndex(1);
    getKaigoRecuperationMedicalFacilitiesClinicNutritionRadioModel().add(getKaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem1());

    getKaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem2 ().setButtonIndex(2);
    getKaigoRecuperationMedicalFacilitiesClinicNutritionRadioModel().add(getKaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem2 ());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem2 (){

  }

  /**
   * 経口移行体制ラジオグループに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadio(){

  }

  /**
   * 経口移行体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioModel(){

    getKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem1().setButtonIndex(1);
    getKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioModel().add(getKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem1());

    getKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem2 ().setButtonIndex(2);
    getKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioModel().add(getKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem2 ());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem2 (){

  }

  /**
   * 療養食体制ラジオグループに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadio(){

  }

  /**
   * 療養食体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioModel(){

    getKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem1().setButtonIndex(1);
    getKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioModel().add(getKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem1());

    getKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem2().setButtonIndex(2);
    getKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioModel().add(getKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem2(){

  }

  /**
   * 人員減算ラジオグループに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicStaffReduce(){

  }

  /**
   * 人員減算ラジオグループモデルに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicStaffReduceModel(){

    getKaigoRecuperationMedicalFacilitiesClinicStaffNot().setButtonIndex(1);
    getKaigoRecuperationMedicalFacilitiesClinicStaffReduceModel().add(getKaigoRecuperationMedicalFacilitiesClinicStaffNot());

    getKaigoRecuperationMedicalFacilitiesClinicStaffExcess().setButtonIndex(2);
    getKaigoRecuperationMedicalFacilitiesClinicStaffReduceModel().add(getKaigoRecuperationMedicalFacilitiesClinicStaffExcess());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicStaffNot(){

  }

  /**
   * 定員超過に内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicStaffExcess(){

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

    kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesDinnerStandeirdMoney4Label(), VRLayout.FLOW);

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
  protected void addKaigoRecuperationMedicalFacilitiesDinnerStandeirdMoney4Label(){

  }

  /**
   * ユニット型個室基準額・コンテナに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyConteiner(){

    kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyText(), null);

    kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyLabel(), null);

  }

  /**
   * ユニット型個室基準額・テキストに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyText(){

  }

  /**
   * ユニット型個室基準額・ラベルに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyLabel(){

  }

  /**
   * ユニット型準個室基準額・コンテナに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyConteiner(){

    kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyText(), null);

    kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyLabel(), null);

  }

  /**
   * ユニット型準個室基準額・テキストに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyText(){

  }

  /**
   * ユニット型準個室基準額・ラベルに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyLabel(){

  }

  /**
   * 従来型個室基準額・コンテナに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyConteiner(){

    kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyText(), null);

    kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyLabel(), null);

  }

  /**
   * 従来型個室基準額・テキストに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyText(){

  }

  /**
   * 従来型個室基準額・ラベルに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyLabel(){

  }

  /**
   * 多床室基準額・コンテナに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicTasyouRoomConteiner(){

    kaigoRecuperationMedicalFacilitiesClinicTasyouRoomConteiner.add(getKaigoRecuperationMedicalFacilitiesClinicTasyouRoomText(), null);

    kaigoRecuperationMedicalFacilitiesClinicTasyouRoomConteiner.add(getKaigoRecuperationMedicalFacilitiesClinicTasyouRoomLabel(), null);

  }

  /**
   * 多床室基準額・テキストに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicTasyouRoomText(){

  }

  /**
   * 多床室基準額・ラベルに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicTasyouRoomLabel(){

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
      ACFrame.getInstance().getContentPane().add(new QO004019Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004019Design getThis() {
    return this;
  }
}
