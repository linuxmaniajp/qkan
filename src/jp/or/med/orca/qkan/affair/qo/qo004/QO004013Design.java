
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
 * プログラム 短期入所療養介護基準適合診療所型 (QO004013)
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
 * 短期入所療養介護基準適合診療所型画面項目デザイン(QO004013) 
 */
public class QO004013Design extends ACPanel {
  //GUIコンポーネント

  private ACGroupBox shortStayStandardAgreementRecuperationGroup;

  private ACLabelContainer shortStayStandardAgreementRecuperationDiscountContainer;

  private ACTextField shortStayStandardAgreementRecuperationDiscountRate;

  private ACLabel shortStayStandardAgreementRecuperationPercentSign;

  private ACClearableRadioButtonGroup shortStayStandardAgreementRecuperationMeetingAndSendingOffSystem;

  private ACLabelContainer shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemContainer;

  private ACListModelAdapter shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemModel;

  private ACRadioButtonItem shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOff;

  private ACRadioButtonItem shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOn;

  private ACClearableRadioButtonGroup shortStayStandardAgreementRecuperationNutritionManageRadio;

  private ACLabelContainer shortStayStandardAgreementRecuperationNutritionManageRadioContainer;

  private ACListModelAdapter shortStayStandardAgreementRecuperationNutritionManageRadioModel;

  private ACRadioButtonItem shortStayStandardAgreementRecuperationNutritionManageRadioItem1;

  private ACRadioButtonItem shortStayStandardAgreementRecuperationNutritionManageRadioItem2;

  private ACClearableRadioButtonGroup shortStayStandardAgreementRecuperationRecuperateRadio;

  private ACLabelContainer shortStayStandardAgreementRecuperationRecuperateRadioContainer;

  private ACListModelAdapter shortStayStandardAgreementRecuperationRecuperateRadioModel;

  private ACRadioButtonItem shortStayStandardAgreementRecuperationRecuperateRadioItem1;

  private ACRadioButtonItem shortStayStandardAgreementRecuperationRecuperateRadioItem2;

  private ACClearableRadioButtonGroup shortStayStandardAgreementRecuperationStaffReduceRadio;

  private ACLabelContainer shortStayStandardAgreementRecuperationStaffReduceRadioContainer;

  private ACListModelAdapter shortStayStandardAgreementRecuperationStaffReduceRadioModel;

  private ACRadioButtonItem shortStayStandardAgreementRecuperationStaffNot;

  private ACRadioButtonItem shortStayStandardAgreementRecuperationStaffExcess;

  private ACLabelContainer shortStayRecuperateCareStandardDinnerStandeirdMoneyConteiner;

  private ACTextField shortStayRecuperateCareStandardDinnerStandeirdMoneyTotal;

  private ACLabel shortStayRecuperateCareStandardMorningDinnerStandeirdMoneyLabel;

  private ACTextField shortStayRecuperateCareStandardMorningDinnerStandeirdMoney;

  private ACLabel shortStayRecuperateCareStandardNoonDinnerStandeirdMoneyLabel;

  private ACTextField shortStayRecuperateCareStandardNoonDinnerStandeirdMoney;

  private ACLabel shortStayRecuperateCareStandardNightDinnerStandeirdMoneyLabel;

  private ACTextField shortStayRecuperateCareStandardNightDinnerStandeirdMoney;

  private ACLabel shortStayRecuperateCareStandardDinnerStandeirdMoney4Label;

  private ACLabelContainer shortStayRecuperateCareStandardUnitRoomStandeirdMoneyConteiner;

  private ACTextField shortStayRecuperateCareStandardUnitRoomStandeirdMoneyText;

  private ACLabel shortStayRecuperateCareStandardUnitRoomStandeirdMoneyLabel;

  private ACLabelContainer shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyConteiner;

  private ACTextField shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyText;

  private ACLabel shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyLabel;

  private ACLabelContainer shortStayRecuperateCareStandardNormalRoomStandeirdMoneyConteiner;

  private ACTextField shortStayRecuperateCareStandardNormalRoomStandeirdMoneyText;

  private ACLabel shortStayRecuperateCareStandardNormalRoomStandeirdMoneyLabel;

  private ACLabelContainer shortStayRecuperateCareStandardTasyouRoomConteiner;

  private ACTextField shortStayRecuperateCareStandardTasyouRoomText;

  private ACLabel shortStayRecuperateCareStandardTasyouRoomLabel;

  //getter

  /**
   * 事業グループを取得します。
   * @return 事業グループ
   */
  public ACGroupBox getShortStayStandardAgreementRecuperationGroup(){
    if(shortStayStandardAgreementRecuperationGroup==null){

      shortStayStandardAgreementRecuperationGroup = new ACGroupBox();

      shortStayStandardAgreementRecuperationGroup.setText("短期入所療養介護（基準適合診療所型）");

      shortStayStandardAgreementRecuperationGroup.setFollowChildEnabled(true);

      shortStayStandardAgreementRecuperationGroup.setHgrid(200);

      addShortStayStandardAgreementRecuperationGroup();
    }
    return shortStayStandardAgreementRecuperationGroup;

  }

  /**
   * 割引率コンテナを取得します。
   * @return 割引率コンテナ
   */
  public ACLabelContainer getShortStayStandardAgreementRecuperationDiscountContainer(){
    if(shortStayStandardAgreementRecuperationDiscountContainer==null){

      shortStayStandardAgreementRecuperationDiscountContainer = new ACLabelContainer();

      shortStayStandardAgreementRecuperationDiscountContainer.setText("割引率");

      shortStayStandardAgreementRecuperationDiscountContainer.setFollowChildEnabled(true);

      addShortStayStandardAgreementRecuperationDiscountContainer();
    }
    return shortStayStandardAgreementRecuperationDiscountContainer;

  }

  /**
   * 割引率を取得します。
   * @return 割引率
   */
  public ACTextField getShortStayStandardAgreementRecuperationDiscountRate(){
    if(shortStayStandardAgreementRecuperationDiscountRate==null){

      shortStayStandardAgreementRecuperationDiscountRate = new ACTextField();

      shortStayStandardAgreementRecuperationDiscountRate.setBindPath("REDUCT_RATE");

      shortStayStandardAgreementRecuperationDiscountRate.setColumns(3);

      shortStayStandardAgreementRecuperationDiscountRate.setCharType(VRCharType.ONLY_DIGIT);

      shortStayStandardAgreementRecuperationDiscountRate.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayStandardAgreementRecuperationDiscountRate.setIMEMode(InputSubset.LATIN);

      shortStayStandardAgreementRecuperationDiscountRate.setMaxLength(3);

      addShortStayStandardAgreementRecuperationDiscountRate();
    }
    return shortStayStandardAgreementRecuperationDiscountRate;

  }

  /**
   * ％ラベルを取得します。
   * @return ％ラベル
   */
  public ACLabel getShortStayStandardAgreementRecuperationPercentSign(){
    if(shortStayStandardAgreementRecuperationPercentSign==null){

      shortStayStandardAgreementRecuperationPercentSign = new ACLabel();

      shortStayStandardAgreementRecuperationPercentSign.setText("％");

      addShortStayStandardAgreementRecuperationPercentSign();
    }
    return shortStayStandardAgreementRecuperationPercentSign;

  }

  /**
   * 送迎体制ラジオグループを取得します。
   * @return 送迎体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystem(){
    if(shortStayStandardAgreementRecuperationMeetingAndSendingOffSystem==null){

      shortStayStandardAgreementRecuperationMeetingAndSendingOffSystem = new ACClearableRadioButtonGroup();

      getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemContainer().setText("送迎体制");

      shortStayStandardAgreementRecuperationMeetingAndSendingOffSystem.setBindPath("1230401");

      shortStayStandardAgreementRecuperationMeetingAndSendingOffSystem.setModel(getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemModel());

      shortStayStandardAgreementRecuperationMeetingAndSendingOffSystem.setUseClearButton(false);

      addShortStayStandardAgreementRecuperationMeetingAndSendingOffSystem();
    }
    return shortStayStandardAgreementRecuperationMeetingAndSendingOffSystem;

  }

  /**
   * 送迎体制ラジオグループコンテナを取得します。
   * @return 送迎体制ラジオグループコンテナ
   */
  protected ACLabelContainer getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemContainer(){
    if(shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemContainer==null){
      shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemContainer = new ACLabelContainer();
      shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemContainer.setFollowChildEnabled(true);
      shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemContainer.add(getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystem(), null);
    }
    return shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemContainer;
  }

  /**
   * 送迎体制ラジオグループモデルを取得します。
   * @return 送迎体制ラジオグループモデル
   */
  protected ACListModelAdapter getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemModel(){
    if(shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemModel==null){
      shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemModel = new ACListModelAdapter();
      addShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemModel();
    }
    return shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOff(){
    if(shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOff==null){

      shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOff = new ACRadioButtonItem();

      shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOff.setText("なし");

      shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOff.setGroup(getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystem());

      addShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOff();
    }
    return shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOff;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOn(){
    if(shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOn==null){

      shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOn = new ACRadioButtonItem();

      shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOn.setText("あり");

      shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOn.setGroup(getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystem());

      addShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOn();
    }
    return shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOn;

  }

  /**
   * 栄養管理体制ラジオグループを取得します。
   * @return 栄養管理体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getShortStayStandardAgreementRecuperationNutritionManageRadio(){
    if(shortStayStandardAgreementRecuperationNutritionManageRadio==null){

      shortStayStandardAgreementRecuperationNutritionManageRadio = new ACClearableRadioButtonGroup();

      getShortStayStandardAgreementRecuperationNutritionManageRadioContainer().setText("栄養管理体制");

      shortStayStandardAgreementRecuperationNutritionManageRadio.setBindPath("1230402");

      shortStayStandardAgreementRecuperationNutritionManageRadio.setModel(getShortStayStandardAgreementRecuperationNutritionManageRadioModel());

      shortStayStandardAgreementRecuperationNutritionManageRadio.setUseClearButton(false);

      addShortStayStandardAgreementRecuperationNutritionManageRadio();
    }
    return shortStayStandardAgreementRecuperationNutritionManageRadio;

  }

  /**
   * 栄養管理体制ラジオグループコンテナを取得します。
   * @return 栄養管理体制ラジオグループコンテナ
   */
  protected ACLabelContainer getShortStayStandardAgreementRecuperationNutritionManageRadioContainer(){
    if(shortStayStandardAgreementRecuperationNutritionManageRadioContainer==null){
      shortStayStandardAgreementRecuperationNutritionManageRadioContainer = new ACLabelContainer();
      shortStayStandardAgreementRecuperationNutritionManageRadioContainer.setFollowChildEnabled(true);
      shortStayStandardAgreementRecuperationNutritionManageRadioContainer.add(getShortStayStandardAgreementRecuperationNutritionManageRadio(), null);
    }
    return shortStayStandardAgreementRecuperationNutritionManageRadioContainer;
  }

  /**
   * 栄養管理体制ラジオグループモデルを取得します。
   * @return 栄養管理体制ラジオグループモデル
   */
  protected ACListModelAdapter getShortStayStandardAgreementRecuperationNutritionManageRadioModel(){
    if(shortStayStandardAgreementRecuperationNutritionManageRadioModel==null){
      shortStayStandardAgreementRecuperationNutritionManageRadioModel = new ACListModelAdapter();
      addShortStayStandardAgreementRecuperationNutritionManageRadioModel();
    }
    return shortStayStandardAgreementRecuperationNutritionManageRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayStandardAgreementRecuperationNutritionManageRadioItem1(){
    if(shortStayStandardAgreementRecuperationNutritionManageRadioItem1==null){

      shortStayStandardAgreementRecuperationNutritionManageRadioItem1 = new ACRadioButtonItem();

      shortStayStandardAgreementRecuperationNutritionManageRadioItem1.setText("なし");

      shortStayStandardAgreementRecuperationNutritionManageRadioItem1.setGroup(getShortStayStandardAgreementRecuperationNutritionManageRadio());

      addShortStayStandardAgreementRecuperationNutritionManageRadioItem1();
    }
    return shortStayStandardAgreementRecuperationNutritionManageRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayStandardAgreementRecuperationNutritionManageRadioItem2(){
    if(shortStayStandardAgreementRecuperationNutritionManageRadioItem2==null){

      shortStayStandardAgreementRecuperationNutritionManageRadioItem2 = new ACRadioButtonItem();

      shortStayStandardAgreementRecuperationNutritionManageRadioItem2.setText("あり");

      shortStayStandardAgreementRecuperationNutritionManageRadioItem2.setGroup(getShortStayStandardAgreementRecuperationNutritionManageRadio());

      addShortStayStandardAgreementRecuperationNutritionManageRadioItem2();
    }
    return shortStayStandardAgreementRecuperationNutritionManageRadioItem2;

  }

  /**
   * 療養食体制ラジオグループを取得します。
   * @return 療養食体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getShortStayStandardAgreementRecuperationRecuperateRadio(){
    if(shortStayStandardAgreementRecuperationRecuperateRadio==null){

      shortStayStandardAgreementRecuperationRecuperateRadio = new ACClearableRadioButtonGroup();

      getShortStayStandardAgreementRecuperationRecuperateRadioContainer().setText("療養食体制");

      shortStayStandardAgreementRecuperationRecuperateRadio.setBindPath("1230403");

      shortStayStandardAgreementRecuperationRecuperateRadio.setModel(getShortStayStandardAgreementRecuperationRecuperateRadioModel());

      shortStayStandardAgreementRecuperationRecuperateRadio.setUseClearButton(false);

      addShortStayStandardAgreementRecuperationRecuperateRadio();
    }
    return shortStayStandardAgreementRecuperationRecuperateRadio;

  }

  /**
   * 療養食体制ラジオグループコンテナを取得します。
   * @return 療養食体制ラジオグループコンテナ
   */
  protected ACLabelContainer getShortStayStandardAgreementRecuperationRecuperateRadioContainer(){
    if(shortStayStandardAgreementRecuperationRecuperateRadioContainer==null){
      shortStayStandardAgreementRecuperationRecuperateRadioContainer = new ACLabelContainer();
      shortStayStandardAgreementRecuperationRecuperateRadioContainer.setFollowChildEnabled(true);
      shortStayStandardAgreementRecuperationRecuperateRadioContainer.add(getShortStayStandardAgreementRecuperationRecuperateRadio(), null);
    }
    return shortStayStandardAgreementRecuperationRecuperateRadioContainer;
  }

  /**
   * 療養食体制ラジオグループモデルを取得します。
   * @return 療養食体制ラジオグループモデル
   */
  protected ACListModelAdapter getShortStayStandardAgreementRecuperationRecuperateRadioModel(){
    if(shortStayStandardAgreementRecuperationRecuperateRadioModel==null){
      shortStayStandardAgreementRecuperationRecuperateRadioModel = new ACListModelAdapter();
      addShortStayStandardAgreementRecuperationRecuperateRadioModel();
    }
    return shortStayStandardAgreementRecuperationRecuperateRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayStandardAgreementRecuperationRecuperateRadioItem1(){
    if(shortStayStandardAgreementRecuperationRecuperateRadioItem1==null){

      shortStayStandardAgreementRecuperationRecuperateRadioItem1 = new ACRadioButtonItem();

      shortStayStandardAgreementRecuperationRecuperateRadioItem1.setText("なし");

      shortStayStandardAgreementRecuperationRecuperateRadioItem1.setGroup(getShortStayStandardAgreementRecuperationRecuperateRadio());

      addShortStayStandardAgreementRecuperationRecuperateRadioItem1();
    }
    return shortStayStandardAgreementRecuperationRecuperateRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayStandardAgreementRecuperationRecuperateRadioItem2(){
    if(shortStayStandardAgreementRecuperationRecuperateRadioItem2==null){

      shortStayStandardAgreementRecuperationRecuperateRadioItem2 = new ACRadioButtonItem();

      shortStayStandardAgreementRecuperationRecuperateRadioItem2.setText("あり");

      shortStayStandardAgreementRecuperationRecuperateRadioItem2.setGroup(getShortStayStandardAgreementRecuperationRecuperateRadio());

      addShortStayStandardAgreementRecuperationRecuperateRadioItem2();
    }
    return shortStayStandardAgreementRecuperationRecuperateRadioItem2;

  }

  /**
   * 人員減算ラジオグループを取得します。
   * @return 人員減算ラジオグループ
   */
  public ACClearableRadioButtonGroup getShortStayStandardAgreementRecuperationStaffReduceRadio(){
    if(shortStayStandardAgreementRecuperationStaffReduceRadio==null){

      shortStayStandardAgreementRecuperationStaffReduceRadio = new ACClearableRadioButtonGroup();

      getShortStayStandardAgreementRecuperationStaffReduceRadioContainer().setText("人員減算");

      shortStayStandardAgreementRecuperationStaffReduceRadio.setBindPath("1230404");

      shortStayStandardAgreementRecuperationStaffReduceRadio.setModel(getShortStayStandardAgreementRecuperationStaffReduceRadioModel());

      shortStayStandardAgreementRecuperationStaffReduceRadio.setUseClearButton(false);

      addShortStayStandardAgreementRecuperationStaffReduceRadio();
    }
    return shortStayStandardAgreementRecuperationStaffReduceRadio;

  }

  /**
   * 人員減算ラジオグループコンテナを取得します。
   * @return 人員減算ラジオグループコンテナ
   */
  protected ACLabelContainer getShortStayStandardAgreementRecuperationStaffReduceRadioContainer(){
    if(shortStayStandardAgreementRecuperationStaffReduceRadioContainer==null){
      shortStayStandardAgreementRecuperationStaffReduceRadioContainer = new ACLabelContainer();
      shortStayStandardAgreementRecuperationStaffReduceRadioContainer.setFollowChildEnabled(true);
      shortStayStandardAgreementRecuperationStaffReduceRadioContainer.add(getShortStayStandardAgreementRecuperationStaffReduceRadio(), null);
    }
    return shortStayStandardAgreementRecuperationStaffReduceRadioContainer;
  }

  /**
   * 人員減算ラジオグループモデルを取得します。
   * @return 人員減算ラジオグループモデル
   */
  protected ACListModelAdapter getShortStayStandardAgreementRecuperationStaffReduceRadioModel(){
    if(shortStayStandardAgreementRecuperationStaffReduceRadioModel==null){
      shortStayStandardAgreementRecuperationStaffReduceRadioModel = new ACListModelAdapter();
      addShortStayStandardAgreementRecuperationStaffReduceRadioModel();
    }
    return shortStayStandardAgreementRecuperationStaffReduceRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayStandardAgreementRecuperationStaffNot(){
    if(shortStayStandardAgreementRecuperationStaffNot==null){

      shortStayStandardAgreementRecuperationStaffNot = new ACRadioButtonItem();

      shortStayStandardAgreementRecuperationStaffNot.setText("なし");

      shortStayStandardAgreementRecuperationStaffNot.setGroup(getShortStayStandardAgreementRecuperationStaffReduceRadio());

      addShortStayStandardAgreementRecuperationStaffNot();
    }
    return shortStayStandardAgreementRecuperationStaffNot;

  }

  /**
   * 定員超過を取得します。
   * @return 定員超過
   */
  public ACRadioButtonItem getShortStayStandardAgreementRecuperationStaffExcess(){
    if(shortStayStandardAgreementRecuperationStaffExcess==null){

      shortStayStandardAgreementRecuperationStaffExcess = new ACRadioButtonItem();

      shortStayStandardAgreementRecuperationStaffExcess.setText("定員超過");

      shortStayStandardAgreementRecuperationStaffExcess.setGroup(getShortStayStandardAgreementRecuperationStaffReduceRadio());

      addShortStayStandardAgreementRecuperationStaffExcess();
    }
    return shortStayStandardAgreementRecuperationStaffExcess;

  }

  /**
   * 食費基準額・コンテナを取得します。
   * @return 食費基準額・コンテナ
   */
  public ACLabelContainer getShortStayRecuperateCareStandardDinnerStandeirdMoneyConteiner(){
    if(shortStayRecuperateCareStandardDinnerStandeirdMoneyConteiner==null){

      shortStayRecuperateCareStandardDinnerStandeirdMoneyConteiner = new ACLabelContainer();

      shortStayRecuperateCareStandardDinnerStandeirdMoneyConteiner.setText("食費基準額");

      shortStayRecuperateCareStandardDinnerStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareStandardDinnerStandeirdMoneyConteiner();
    }
    return shortStayRecuperateCareStandardDinnerStandeirdMoneyConteiner;

  }

  /**
   * 食費基準額・合計・テキストを取得します。
   * @return 食費基準額・合計・テキスト
   */
  public ACTextField getShortStayRecuperateCareStandardDinnerStandeirdMoneyTotal(){
    if(shortStayRecuperateCareStandardDinnerStandeirdMoneyTotal==null){

      shortStayRecuperateCareStandardDinnerStandeirdMoneyTotal = new ACTextField();

      shortStayRecuperateCareStandardDinnerStandeirdMoneyTotal.setBindPath("1230405");

      shortStayRecuperateCareStandardDinnerStandeirdMoneyTotal.setEditable(false);

      shortStayRecuperateCareStandardDinnerStandeirdMoneyTotal.setColumns(4);

      shortStayRecuperateCareStandardDinnerStandeirdMoneyTotal.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareStandardDinnerStandeirdMoneyTotal.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareStandardDinnerStandeirdMoneyTotal.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareStandardDinnerStandeirdMoneyTotal.setMaxLength(4);

      addShortStayRecuperateCareStandardDinnerStandeirdMoneyTotal();
    }
    return shortStayRecuperateCareStandardDinnerStandeirdMoneyTotal;

  }

  /**
   * 食費基準額・朝・ラベルを取得します。
   * @return 食費基準額・朝・ラベル
   */
  public ACLabel getShortStayRecuperateCareStandardMorningDinnerStandeirdMoneyLabel(){
    if(shortStayRecuperateCareStandardMorningDinnerStandeirdMoneyLabel==null){

      shortStayRecuperateCareStandardMorningDinnerStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareStandardMorningDinnerStandeirdMoneyLabel.setText("　朝");

      addShortStayRecuperateCareStandardMorningDinnerStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareStandardMorningDinnerStandeirdMoneyLabel;

  }

  /**
   * 食費基準額・朝・テキストを取得します。
   * @return 食費基準額・朝・テキスト
   */
  public ACTextField getShortStayRecuperateCareStandardMorningDinnerStandeirdMoney(){
    if(shortStayRecuperateCareStandardMorningDinnerStandeirdMoney==null){

      shortStayRecuperateCareStandardMorningDinnerStandeirdMoney = new ACTextField();

      shortStayRecuperateCareStandardMorningDinnerStandeirdMoney.setBindPath("1230406");

      shortStayRecuperateCareStandardMorningDinnerStandeirdMoney.setColumns(3);

      shortStayRecuperateCareStandardMorningDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareStandardMorningDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareStandardMorningDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareStandardMorningDinnerStandeirdMoney.setMaxLength(3);

      addShortStayRecuperateCareStandardMorningDinnerStandeirdMoney();
    }
    return shortStayRecuperateCareStandardMorningDinnerStandeirdMoney;

  }

  /**
   * 食費基準額・昼・ラベルを取得します。
   * @return 食費基準額・昼・ラベル
   */
  public ACLabel getShortStayRecuperateCareStandardNoonDinnerStandeirdMoneyLabel(){
    if(shortStayRecuperateCareStandardNoonDinnerStandeirdMoneyLabel==null){

      shortStayRecuperateCareStandardNoonDinnerStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareStandardNoonDinnerStandeirdMoneyLabel.setText("昼");

      addShortStayRecuperateCareStandardNoonDinnerStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareStandardNoonDinnerStandeirdMoneyLabel;

  }

  /**
   * 食費基準額・昼・テキストを取得します。
   * @return 食費基準額・昼・テキスト
   */
  public ACTextField getShortStayRecuperateCareStandardNoonDinnerStandeirdMoney(){
    if(shortStayRecuperateCareStandardNoonDinnerStandeirdMoney==null){

      shortStayRecuperateCareStandardNoonDinnerStandeirdMoney = new ACTextField();

      shortStayRecuperateCareStandardNoonDinnerStandeirdMoney.setBindPath("1230407");

      shortStayRecuperateCareStandardNoonDinnerStandeirdMoney.setColumns(3);

      shortStayRecuperateCareStandardNoonDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareStandardNoonDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareStandardNoonDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareStandardNoonDinnerStandeirdMoney.setMaxLength(3);

      addShortStayRecuperateCareStandardNoonDinnerStandeirdMoney();
    }
    return shortStayRecuperateCareStandardNoonDinnerStandeirdMoney;

  }

  /**
   * 食費基準額・夜・ラベルを取得します。
   * @return 食費基準額・夜・ラベル
   */
  public ACLabel getShortStayRecuperateCareStandardNightDinnerStandeirdMoneyLabel(){
    if(shortStayRecuperateCareStandardNightDinnerStandeirdMoneyLabel==null){

      shortStayRecuperateCareStandardNightDinnerStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareStandardNightDinnerStandeirdMoneyLabel.setText("夜");

      addShortStayRecuperateCareStandardNightDinnerStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareStandardNightDinnerStandeirdMoneyLabel;

  }

  /**
   * 食費基準額・夜・テキストを取得します。
   * @return 食費基準額・夜・テキスト
   */
  public ACTextField getShortStayRecuperateCareStandardNightDinnerStandeirdMoney(){
    if(shortStayRecuperateCareStandardNightDinnerStandeirdMoney==null){

      shortStayRecuperateCareStandardNightDinnerStandeirdMoney = new ACTextField();

      shortStayRecuperateCareStandardNightDinnerStandeirdMoney.setBindPath("1230408");

      shortStayRecuperateCareStandardNightDinnerStandeirdMoney.setColumns(3);

      shortStayRecuperateCareStandardNightDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareStandardNightDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareStandardNightDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareStandardNightDinnerStandeirdMoney.setMaxLength(3);

      addShortStayRecuperateCareStandardNightDinnerStandeirdMoney();
    }
    return shortStayRecuperateCareStandardNightDinnerStandeirdMoney;

  }

  /**
   * 食費基準額・ラベルを取得します。
   * @return 食費基準額・ラベル
   */
  public ACLabel getShortStayRecuperateCareStandardDinnerStandeirdMoney4Label(){
    if(shortStayRecuperateCareStandardDinnerStandeirdMoney4Label==null){

      shortStayRecuperateCareStandardDinnerStandeirdMoney4Label = new ACLabel();

      shortStayRecuperateCareStandardDinnerStandeirdMoney4Label.setText("（円）");

      addShortStayRecuperateCareStandardDinnerStandeirdMoney4Label();
    }
    return shortStayRecuperateCareStandardDinnerStandeirdMoney4Label;

  }

  /**
   * ユニット型個室基準額・コンテナを取得します。
   * @return ユニット型個室基準額・コンテナ
   */
  public ACLabelContainer getShortStayRecuperateCareStandardUnitRoomStandeirdMoneyConteiner(){
    if(shortStayRecuperateCareStandardUnitRoomStandeirdMoneyConteiner==null){

      shortStayRecuperateCareStandardUnitRoomStandeirdMoneyConteiner = new ACLabelContainer();

      shortStayRecuperateCareStandardUnitRoomStandeirdMoneyConteiner.setText("ユニット型個室基準額");

      shortStayRecuperateCareStandardUnitRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareStandardUnitRoomStandeirdMoneyConteiner();
    }
    return shortStayRecuperateCareStandardUnitRoomStandeirdMoneyConteiner;

  }

  /**
   * ユニット型個室基準額・テキストを取得します。
   * @return ユニット型個室基準額・テキスト
   */
  public ACTextField getShortStayRecuperateCareStandardUnitRoomStandeirdMoneyText(){
    if(shortStayRecuperateCareStandardUnitRoomStandeirdMoneyText==null){

      shortStayRecuperateCareStandardUnitRoomStandeirdMoneyText = new ACTextField();

      shortStayRecuperateCareStandardUnitRoomStandeirdMoneyText.setBindPath("1230409");

      shortStayRecuperateCareStandardUnitRoomStandeirdMoneyText.setColumns(4);

      shortStayRecuperateCareStandardUnitRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareStandardUnitRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareStandardUnitRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareStandardUnitRoomStandeirdMoneyText.setMaxLength(4);

      addShortStayRecuperateCareStandardUnitRoomStandeirdMoneyText();
    }
    return shortStayRecuperateCareStandardUnitRoomStandeirdMoneyText;

  }

  /**
   * ユニット型個室基準額・ラベルを取得します。
   * @return ユニット型個室基準額・ラベル
   */
  public ACLabel getShortStayRecuperateCareStandardUnitRoomStandeirdMoneyLabel(){
    if(shortStayRecuperateCareStandardUnitRoomStandeirdMoneyLabel==null){

      shortStayRecuperateCareStandardUnitRoomStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareStandardUnitRoomStandeirdMoneyLabel.setText("（円）");

      addShortStayRecuperateCareStandardUnitRoomStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareStandardUnitRoomStandeirdMoneyLabel;

  }

  /**
   * ユニット型準個室基準額・コンテナを取得します。
   * @return ユニット型準個室基準額・コンテナ
   */
  public ACLabelContainer getShortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyConteiner(){
    if(shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyConteiner==null){

      shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyConteiner = new ACLabelContainer();

      shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyConteiner.setText("ユニット型準個室基準額");

      shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyConteiner();
    }
    return shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyConteiner;

  }

  /**
   * ユニット型準個室基準額・テキストを取得します。
   * @return ユニット型準個室基準額・テキスト
   */
  public ACTextField getShortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyText(){
    if(shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyText==null){

      shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyText = new ACTextField();

      shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyText.setBindPath("1230410");

      shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyText.setColumns(4);

      shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyText.setMaxLength(4);

      addShortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyText();
    }
    return shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyText;

  }

  /**
   * ユニット型準個室基準額・ラベルを取得します。
   * @return ユニット型準個室基準額・ラベル
   */
  public ACLabel getShortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyLabel(){
    if(shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyLabel==null){

      shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyLabel.setText("（円）");

      addShortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyLabel;

  }

  /**
   * 従来型個室基準額・コンテナを取得します。
   * @return 従来型個室基準額・コンテナ
   */
  public ACLabelContainer getShortStayRecuperateCareStandardNormalRoomStandeirdMoneyConteiner(){
    if(shortStayRecuperateCareStandardNormalRoomStandeirdMoneyConteiner==null){

      shortStayRecuperateCareStandardNormalRoomStandeirdMoneyConteiner = new ACLabelContainer();

      shortStayRecuperateCareStandardNormalRoomStandeirdMoneyConteiner.setText("　　従来型個室基準額");

      shortStayRecuperateCareStandardNormalRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareStandardNormalRoomStandeirdMoneyConteiner();
    }
    return shortStayRecuperateCareStandardNormalRoomStandeirdMoneyConteiner;

  }

  /**
   * 従来型個室基準額・テキストを取得します。
   * @return 従来型個室基準額・テキスト
   */
  public ACTextField getShortStayRecuperateCareStandardNormalRoomStandeirdMoneyText(){
    if(shortStayRecuperateCareStandardNormalRoomStandeirdMoneyText==null){

      shortStayRecuperateCareStandardNormalRoomStandeirdMoneyText = new ACTextField();

      shortStayRecuperateCareStandardNormalRoomStandeirdMoneyText.setBindPath("1230411");

      shortStayRecuperateCareStandardNormalRoomStandeirdMoneyText.setColumns(4);

      shortStayRecuperateCareStandardNormalRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareStandardNormalRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareStandardNormalRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareStandardNormalRoomStandeirdMoneyText.setMaxLength(4);

      addShortStayRecuperateCareStandardNormalRoomStandeirdMoneyText();
    }
    return shortStayRecuperateCareStandardNormalRoomStandeirdMoneyText;

  }

  /**
   * 従来型個室基準額・ラベルを取得します。
   * @return 従来型個室基準額・ラベル
   */
  public ACLabel getShortStayRecuperateCareStandardNormalRoomStandeirdMoneyLabel(){
    if(shortStayRecuperateCareStandardNormalRoomStandeirdMoneyLabel==null){

      shortStayRecuperateCareStandardNormalRoomStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareStandardNormalRoomStandeirdMoneyLabel.setText("（円）");

      addShortStayRecuperateCareStandardNormalRoomStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareStandardNormalRoomStandeirdMoneyLabel;

  }

  /**
   * 多床室基準額・コンテナを取得します。
   * @return 多床室基準額・コンテナ
   */
  public ACLabelContainer getShortStayRecuperateCareStandardTasyouRoomConteiner(){
    if(shortStayRecuperateCareStandardTasyouRoomConteiner==null){

      shortStayRecuperateCareStandardTasyouRoomConteiner = new ACLabelContainer();

      shortStayRecuperateCareStandardTasyouRoomConteiner.setText("　　多床室基準額");

      shortStayRecuperateCareStandardTasyouRoomConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareStandardTasyouRoomConteiner();
    }
    return shortStayRecuperateCareStandardTasyouRoomConteiner;

  }

  /**
   * 多床室基準額・テキストを取得します。
   * @return 多床室基準額・テキスト
   */
  public ACTextField getShortStayRecuperateCareStandardTasyouRoomText(){
    if(shortStayRecuperateCareStandardTasyouRoomText==null){

      shortStayRecuperateCareStandardTasyouRoomText = new ACTextField();

      shortStayRecuperateCareStandardTasyouRoomText.setBindPath("1230412");

      shortStayRecuperateCareStandardTasyouRoomText.setColumns(4);

      shortStayRecuperateCareStandardTasyouRoomText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareStandardTasyouRoomText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareStandardTasyouRoomText.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareStandardTasyouRoomText.setMaxLength(4);

      addShortStayRecuperateCareStandardTasyouRoomText();
    }
    return shortStayRecuperateCareStandardTasyouRoomText;

  }

  /**
   * 多床室基準額・ラベルを取得します。
   * @return 多床室基準額・ラベル
   */
  public ACLabel getShortStayRecuperateCareStandardTasyouRoomLabel(){
    if(shortStayRecuperateCareStandardTasyouRoomLabel==null){

      shortStayRecuperateCareStandardTasyouRoomLabel = new ACLabel();

      shortStayRecuperateCareStandardTasyouRoomLabel.setText("（円）");

      addShortStayRecuperateCareStandardTasyouRoomLabel();
    }
    return shortStayRecuperateCareStandardTasyouRoomLabel;

  }

  /**
   * コンストラクタです。
   */
  public QO004013Design() {

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

    this.add(getShortStayStandardAgreementRecuperationGroup(), VRLayout.CLIENT);

  }

  /**
   * 事業グループに内部項目を追加します。
   */
  protected void addShortStayStandardAgreementRecuperationGroup(){

    shortStayStandardAgreementRecuperationGroup.add(getShortStayStandardAgreementRecuperationDiscountContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayStandardAgreementRecuperationGroup.add(getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayStandardAgreementRecuperationGroup.add(getShortStayStandardAgreementRecuperationNutritionManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayStandardAgreementRecuperationGroup.add(getShortStayStandardAgreementRecuperationRecuperateRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayStandardAgreementRecuperationGroup.add(getShortStayStandardAgreementRecuperationStaffReduceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayStandardAgreementRecuperationGroup.add(getShortStayRecuperateCareStandardDinnerStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayStandardAgreementRecuperationGroup.add(getShortStayRecuperateCareStandardUnitRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayStandardAgreementRecuperationGroup.add(getShortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayStandardAgreementRecuperationGroup.add(getShortStayRecuperateCareStandardNormalRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayStandardAgreementRecuperationGroup.add(getShortStayRecuperateCareStandardTasyouRoomConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 割引率コンテナに内部項目を追加します。
   */
  protected void addShortStayStandardAgreementRecuperationDiscountContainer(){

    shortStayStandardAgreementRecuperationDiscountContainer.add(getShortStayStandardAgreementRecuperationDiscountRate(), VRLayout.FLOW);

    shortStayStandardAgreementRecuperationDiscountContainer.add(getShortStayStandardAgreementRecuperationPercentSign(), VRLayout.FLOW);

  }

  /**
   * 割引率に内部項目を追加します。
   */
  protected void addShortStayStandardAgreementRecuperationDiscountRate(){

  }

  /**
   * ％ラベルに内部項目を追加します。
   */
  protected void addShortStayStandardAgreementRecuperationPercentSign(){

  }

  /**
   * 送迎体制ラジオグループに内部項目を追加します。
   */
  protected void addShortStayStandardAgreementRecuperationMeetingAndSendingOffSystem(){

  }

  /**
   * 送迎体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemModel(){

    getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOff().setButtonIndex(1);
    getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemModel().add(getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOff());

    getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOn().setButtonIndex(2);
    getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemModel().add(getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOn());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOff(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOn(){

  }

  /**
   * 栄養管理体制ラジオグループに内部項目を追加します。
   */
  protected void addShortStayStandardAgreementRecuperationNutritionManageRadio(){

  }

  /**
   * 栄養管理体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addShortStayStandardAgreementRecuperationNutritionManageRadioModel(){

    getShortStayStandardAgreementRecuperationNutritionManageRadioItem1().setButtonIndex(1);
    getShortStayStandardAgreementRecuperationNutritionManageRadioModel().add(getShortStayStandardAgreementRecuperationNutritionManageRadioItem1());

    getShortStayStandardAgreementRecuperationNutritionManageRadioItem2().setButtonIndex(2);
    getShortStayStandardAgreementRecuperationNutritionManageRadioModel().add(getShortStayStandardAgreementRecuperationNutritionManageRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayStandardAgreementRecuperationNutritionManageRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayStandardAgreementRecuperationNutritionManageRadioItem2(){

  }

  /**
   * 療養食体制ラジオグループに内部項目を追加します。
   */
  protected void addShortStayStandardAgreementRecuperationRecuperateRadio(){

  }

  /**
   * 療養食体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addShortStayStandardAgreementRecuperationRecuperateRadioModel(){

    getShortStayStandardAgreementRecuperationRecuperateRadioItem1().setButtonIndex(1);
    getShortStayStandardAgreementRecuperationRecuperateRadioModel().add(getShortStayStandardAgreementRecuperationRecuperateRadioItem1());

    getShortStayStandardAgreementRecuperationRecuperateRadioItem2().setButtonIndex(2);
    getShortStayStandardAgreementRecuperationRecuperateRadioModel().add(getShortStayStandardAgreementRecuperationRecuperateRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayStandardAgreementRecuperationRecuperateRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayStandardAgreementRecuperationRecuperateRadioItem2(){

  }

  /**
   * 人員減算ラジオグループに内部項目を追加します。
   */
  protected void addShortStayStandardAgreementRecuperationStaffReduceRadio(){

  }

  /**
   * 人員減算ラジオグループモデルに内部項目を追加します。
   */
  protected void addShortStayStandardAgreementRecuperationStaffReduceRadioModel(){

    getShortStayStandardAgreementRecuperationStaffNot().setButtonIndex(1);
    getShortStayStandardAgreementRecuperationStaffReduceRadioModel().add(getShortStayStandardAgreementRecuperationStaffNot());

    getShortStayStandardAgreementRecuperationStaffExcess().setButtonIndex(2);
    getShortStayStandardAgreementRecuperationStaffReduceRadioModel().add(getShortStayStandardAgreementRecuperationStaffExcess());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayStandardAgreementRecuperationStaffNot(){

  }

  /**
   * 定員超過に内部項目を追加します。
   */
  protected void addShortStayStandardAgreementRecuperationStaffExcess(){

  }

  /**
   * 食費基準額・コンテナに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareStandardDinnerStandeirdMoneyConteiner(){

    shortStayRecuperateCareStandardDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareStandardDinnerStandeirdMoneyTotal(), VRLayout.FLOW);

    shortStayRecuperateCareStandardDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareStandardMorningDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    shortStayRecuperateCareStandardDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareStandardMorningDinnerStandeirdMoney(), VRLayout.FLOW);

    shortStayRecuperateCareStandardDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareStandardNoonDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    shortStayRecuperateCareStandardDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareStandardNoonDinnerStandeirdMoney(), VRLayout.FLOW);

    shortStayRecuperateCareStandardDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareStandardNightDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    shortStayRecuperateCareStandardDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareStandardNightDinnerStandeirdMoney(), VRLayout.FLOW);

    shortStayRecuperateCareStandardDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareStandardDinnerStandeirdMoney4Label(), VRLayout.FLOW);

  }

  /**
   * 食費基準額・合計・テキストに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareStandardDinnerStandeirdMoneyTotal(){

  }

  /**
   * 食費基準額・朝・ラベルに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareStandardMorningDinnerStandeirdMoneyLabel(){

  }

  /**
   * 食費基準額・朝・テキストに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareStandardMorningDinnerStandeirdMoney(){

  }

  /**
   * 食費基準額・昼・ラベルに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareStandardNoonDinnerStandeirdMoneyLabel(){

  }

  /**
   * 食費基準額・昼・テキストに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareStandardNoonDinnerStandeirdMoney(){

  }

  /**
   * 食費基準額・夜・ラベルに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareStandardNightDinnerStandeirdMoneyLabel(){

  }

  /**
   * 食費基準額・夜・テキストに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareStandardNightDinnerStandeirdMoney(){

  }

  /**
   * 食費基準額・ラベルに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareStandardDinnerStandeirdMoney4Label(){

  }

  /**
   * ユニット型個室基準額・コンテナに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareStandardUnitRoomStandeirdMoneyConteiner(){

    shortStayRecuperateCareStandardUnitRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareStandardUnitRoomStandeirdMoneyText(), null);

    shortStayRecuperateCareStandardUnitRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareStandardUnitRoomStandeirdMoneyLabel(), null);

  }

  /**
   * ユニット型個室基準額・テキストに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareStandardUnitRoomStandeirdMoneyText(){

  }

  /**
   * ユニット型個室基準額・ラベルに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareStandardUnitRoomStandeirdMoneyLabel(){

  }

  /**
   * ユニット型準個室基準額・コンテナに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyConteiner(){

    shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyText(), null);

    shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyLabel(), null);

  }

  /**
   * ユニット型準個室基準額・テキストに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyText(){

  }

  /**
   * ユニット型準個室基準額・ラベルに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyLabel(){

  }

  /**
   * 従来型個室基準額・コンテナに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareStandardNormalRoomStandeirdMoneyConteiner(){

    shortStayRecuperateCareStandardNormalRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareStandardNormalRoomStandeirdMoneyText(), null);

    shortStayRecuperateCareStandardNormalRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareStandardNormalRoomStandeirdMoneyLabel(), null);

  }

  /**
   * 従来型個室基準額・テキストに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareStandardNormalRoomStandeirdMoneyText(){

  }

  /**
   * 従来型個室基準額・ラベルに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareStandardNormalRoomStandeirdMoneyLabel(){

  }

  /**
   * 多床室基準額・コンテナに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareStandardTasyouRoomConteiner(){

    shortStayRecuperateCareStandardTasyouRoomConteiner.add(getShortStayRecuperateCareStandardTasyouRoomText(), null);

    shortStayRecuperateCareStandardTasyouRoomConteiner.add(getShortStayRecuperateCareStandardTasyouRoomLabel(), null);

  }

  /**
   * 多床室基準額・テキストに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareStandardTasyouRoomText(){

  }

  /**
   * 多床室基準額・ラベルに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareStandardTasyouRoomLabel(){

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
      ACFrame.getInstance().getContentPane().add(new QO004013Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004013Design getThis() {
    return this;
  }
}
