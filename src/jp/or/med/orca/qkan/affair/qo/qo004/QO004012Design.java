
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
 * プログラム 事業者登録(短期入所療養介護認知症疾患型) (QO004012)
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
 * 事業者登録(短期入所療養介護認知症疾患型)画面項目デザイン(QO004012) 
 */
public class QO004012Design extends ACPanel {
  //GUIコンポーネント

  private ACGroupBox shortStayDementiaDiseaseRecuperationGroup;

  private ACLabelContainer shortStayDementiaDiseaseRecuperationDiscountConteiner;

  private ACTextField shortStayDementiaDiseaseRecuperationDiscountRate;

  private ACLabel shortStayDementiaDiseaseRecuperationPercentSign;

  private ACClearableRadioButtonGroup shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadio;

  private ACLabelContainer shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioContainer;

  private ACListModelAdapter shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioModel;

  private ACRadioButtonItem shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem1;

  private ACRadioButtonItem shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem2;

  private ACClearableRadioButtonGroup shortStayDementiaDiseaseRecuperationStaffAssignmentDivision;

  private ACLabelContainer shortStayDementiaDiseaseRecuperationStaffAssignmentDivisionContainer;

  private ACListModelAdapter shortStayDementiaDiseaseRecuperationStaffAssignmentDivisionModel;

  private ACRadioButtonItem shortStayDementiaDiseaseRecuperationStaffAssignmentDivision1;

  private ACRadioButtonItem shortStayDementiaDiseaseRecuperationStaffAssignmentDivision2;

  private ACRadioButtonItem shortStayDementiaDiseaseRecuperationstaffAssignmentDivision3;

  private ACClearableRadioButtonGroup shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystem;

  private ACLabelContainer shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemContainer;

  private ACListModelAdapter shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemModel;

  private ACRadioButtonItem shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOff;

  private ACRadioButtonItem shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOn;

  private ACClearableRadioButtonGroup shortStayDementiaDiseaseRecuperationNutritionManageRadio;

  private ACLabelContainer shortStayDementiaDiseaseRecuperationNutritionManageRadioContainer;

  private ACListModelAdapter shortStayDementiaDiseaseRecuperationNutritionManageRadioModel;

  private ACRadioButtonItem shortStayDementiaDiseaseRecuperationNutritionManageRadioItem1;

  private ACRadioButtonItem shortStayDementiaDiseaseRecuperationNutritionManageRadioItem2;

  private ACClearableRadioButtonGroup shortStayDementiaDiseaseRecuperationRecuperateDinnerRadio;

  private ACLabelContainer shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioContainer;

  private ACListModelAdapter shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioModel;

  private ACRadioButtonItem shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem1;

  private ACRadioButtonItem shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem2;

  private ACComboBox shortStayDementiaDiseaseRecuperationStaffReduce;

  private ACLabelContainer shortStayDementiaDiseaseRecuperationStaffReduceContainer;

  private ACComboBoxModelAdapter shortStayDementiaDiseaseRecuperationStaffReduceModel;

  private ACLabelContainer shortStayRecuperateCareCognitiveDinnerStandeirdMoneyConteiner;

  private ACTextField shortStayRecuperateCareCognitiveDinnerStandeirdMoneyTotal;

  private ACLabel shortStayRecuperateCareCognitiveMorningDinnerStandeirdMoneyLabel;

  private ACTextField shortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney;

  private ACLabel shortStayRecuperateCareCognitiveNoonDinnerStandeirdMoneyLabel;

  private ACTextField shortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney;

  private ACLabel shortStayRecuperateCareCognitiveNightDinnerStandeirdTotalMoneyLabel;

  private ACTextField shortStayRecuperateCareCognitiveNightDinnerStandeirdMoney;

  private ACLabel shortStayRecuperateCareCognitiveRecuperateCareCognitiveDinnerStandeirdMoney4Label;

  private ACLabelContainer shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyConteiner;

  private ACTextField shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyText;

  private ACLabel shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyLabel;

  private ACLabelContainer shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyConteiner;

  private ACTextField shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyText;

  private ACLabel shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyLabel;

  private ACLabelContainer shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyConteiner;

  private ACTextField shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyText;

  private ACLabel shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyLabel;

  private ACLabelContainer shortStayRecuperateCareCognitiveTasyouRoomConteiner;

  private ACTextField shortStayRecuperateCareCognitiveTasyouRoomText;

  private ACLabel shortStayRecuperateCareCognitiveTasyouRoomLabel;

  //getter

  /**
   * 事業グループを取得します。
   * @return 事業グループ
   */
  public ACGroupBox getShortStayDementiaDiseaseRecuperationGroup(){
    if(shortStayDementiaDiseaseRecuperationGroup==null){

      shortStayDementiaDiseaseRecuperationGroup = new ACGroupBox();

      shortStayDementiaDiseaseRecuperationGroup.setText("短期入所療養介護（認知症疾患型）");

      shortStayDementiaDiseaseRecuperationGroup.setFollowChildEnabled(true);

      shortStayDementiaDiseaseRecuperationGroup.setHgrid(200);

      addShortStayDementiaDiseaseRecuperationGroup();
    }
    return shortStayDementiaDiseaseRecuperationGroup;

  }

  /**
   * 割引率コンテナを取得します。
   * @return 割引率コンテナ
   */
  public ACLabelContainer getShortStayDementiaDiseaseRecuperationDiscountConteiner(){
    if(shortStayDementiaDiseaseRecuperationDiscountConteiner==null){

      shortStayDementiaDiseaseRecuperationDiscountConteiner = new ACLabelContainer();

      shortStayDementiaDiseaseRecuperationDiscountConteiner.setText("割引率");

      shortStayDementiaDiseaseRecuperationDiscountConteiner.setFollowChildEnabled(true);

      addShortStayDementiaDiseaseRecuperationDiscountConteiner();
    }
    return shortStayDementiaDiseaseRecuperationDiscountConteiner;

  }

  /**
   * 割引率を取得します。
   * @return 割引率
   */
  public ACTextField getShortStayDementiaDiseaseRecuperationDiscountRate(){
    if(shortStayDementiaDiseaseRecuperationDiscountRate==null){

      shortStayDementiaDiseaseRecuperationDiscountRate = new ACTextField();

      shortStayDementiaDiseaseRecuperationDiscountRate.setBindPath("REDUCT_RATE");

      shortStayDementiaDiseaseRecuperationDiscountRate.setColumns(3);

      shortStayDementiaDiseaseRecuperationDiscountRate.setCharType(VRCharType.ONLY_DIGIT);

      shortStayDementiaDiseaseRecuperationDiscountRate.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayDementiaDiseaseRecuperationDiscountRate.setIMEMode(InputSubset.LATIN);

      shortStayDementiaDiseaseRecuperationDiscountRate.setMaxLength(3);

      addShortStayDementiaDiseaseRecuperationDiscountRate();
    }
    return shortStayDementiaDiseaseRecuperationDiscountRate;

  }

  /**
   * ％ラベルを取得します。
   * @return ％ラベル
   */
  public ACLabel getShortStayDementiaDiseaseRecuperationPercentSign(){
    if(shortStayDementiaDiseaseRecuperationPercentSign==null){

      shortStayDementiaDiseaseRecuperationPercentSign = new ACLabel();

      shortStayDementiaDiseaseRecuperationPercentSign.setText("％");

      addShortStayDementiaDiseaseRecuperationPercentSign();
    }
    return shortStayDementiaDiseaseRecuperationPercentSign;

  }

  /**
   * 施設区分ラジオグループを取得します。
   * @return 施設区分ラジオグループ
   */
  public ACClearableRadioButtonGroup getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadio(){
    if(shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadio==null){

      shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadio = new ACClearableRadioButtonGroup();

      getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioContainer().setText("施設区分");

      shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadio.setBindPath("1230301");

      shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadio.setModel(getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioModel());

      shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadio.setUseClearButton(false);

      addShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadio();
    }
    return shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadio;

  }

  /**
   * 施設区分ラジオグループコンテナを取得します。
   * @return 施設区分ラジオグループコンテナ
   */
  protected ACLabelContainer getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioContainer(){
    if(shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioContainer==null){
      shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioContainer = new ACLabelContainer();
      shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioContainer.setFollowChildEnabled(true);
      shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioContainer.add(getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadio(), null);
    }
    return shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioContainer;
  }

  /**
   * 施設区分ラジオグループモデルを取得します。
   * @return 施設区分ラジオグループモデル
   */
  protected ACListModelAdapter getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioModel(){
    if(shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioModel==null){
      shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioModel = new ACListModelAdapter();
      addShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioModel();
    }
    return shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioModel;
  }

  /**
   * 認知症疾患型を取得します。
   * @return 認知症疾患型
   */
  public ACRadioButtonItem getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem1(){
    if(shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem1==null){

      shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem1 = new ACRadioButtonItem();

      shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem1.setText("認知症疾患型");

      shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem1.setGroup(getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadio());

      addShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem1();
    }
    return shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem1;

  }

  /**
   * ユニット型認知症疾患型を取得します。
   * @return ユニット型認知症疾患型
   */
  public ACRadioButtonItem getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem2(){
    if(shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem2==null){

      shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem2 = new ACRadioButtonItem();

      shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem2.setText("ユニット型認知症疾患型");

      shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem2.setGroup(getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadio());

      addShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem2();
    }
    return shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem2;

  }

  /**
   * 人員配置区分ラジオグループを取得します。
   * @return 人員配置区分ラジオグループ
   */
  public ACClearableRadioButtonGroup getShortStayDementiaDiseaseRecuperationStaffAssignmentDivision(){
    if(shortStayDementiaDiseaseRecuperationStaffAssignmentDivision==null){

      shortStayDementiaDiseaseRecuperationStaffAssignmentDivision = new ACClearableRadioButtonGroup();

      getShortStayDementiaDiseaseRecuperationStaffAssignmentDivisionContainer().setText("人員配置区分");

      shortStayDementiaDiseaseRecuperationStaffAssignmentDivision.setBindPath("1230302");

      shortStayDementiaDiseaseRecuperationStaffAssignmentDivision.setModel(getShortStayDementiaDiseaseRecuperationStaffAssignmentDivisionModel());

      shortStayDementiaDiseaseRecuperationStaffAssignmentDivision.setUseClearButton(false);

      addShortStayDementiaDiseaseRecuperationStaffAssignmentDivision();
    }
    return shortStayDementiaDiseaseRecuperationStaffAssignmentDivision;

  }

  /**
   * 人員配置区分ラジオグループコンテナを取得します。
   * @return 人員配置区分ラジオグループコンテナ
   */
  protected ACLabelContainer getShortStayDementiaDiseaseRecuperationStaffAssignmentDivisionContainer(){
    if(shortStayDementiaDiseaseRecuperationStaffAssignmentDivisionContainer==null){
      shortStayDementiaDiseaseRecuperationStaffAssignmentDivisionContainer = new ACLabelContainer();
      shortStayDementiaDiseaseRecuperationStaffAssignmentDivisionContainer.setFollowChildEnabled(true);
      shortStayDementiaDiseaseRecuperationStaffAssignmentDivisionContainer.add(getShortStayDementiaDiseaseRecuperationStaffAssignmentDivision(), null);
    }
    return shortStayDementiaDiseaseRecuperationStaffAssignmentDivisionContainer;
  }

  /**
   * 人員配置区分ラジオグループモデルを取得します。
   * @return 人員配置区分ラジオグループモデル
   */
  protected ACListModelAdapter getShortStayDementiaDiseaseRecuperationStaffAssignmentDivisionModel(){
    if(shortStayDementiaDiseaseRecuperationStaffAssignmentDivisionModel==null){
      shortStayDementiaDiseaseRecuperationStaffAssignmentDivisionModel = new ACListModelAdapter();
      addShortStayDementiaDiseaseRecuperationStaffAssignmentDivisionModel();
    }
    return shortStayDementiaDiseaseRecuperationStaffAssignmentDivisionModel;
  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getShortStayDementiaDiseaseRecuperationStaffAssignmentDivision1(){
    if(shortStayDementiaDiseaseRecuperationStaffAssignmentDivision1==null){

      shortStayDementiaDiseaseRecuperationStaffAssignmentDivision1 = new ACRadioButtonItem();

      shortStayDementiaDiseaseRecuperationStaffAssignmentDivision1.setText("I型");

      shortStayDementiaDiseaseRecuperationStaffAssignmentDivision1.setGroup(getShortStayDementiaDiseaseRecuperationStaffAssignmentDivision());

      addShortStayDementiaDiseaseRecuperationStaffAssignmentDivision1();
    }
    return shortStayDementiaDiseaseRecuperationStaffAssignmentDivision1;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getShortStayDementiaDiseaseRecuperationStaffAssignmentDivision2(){
    if(shortStayDementiaDiseaseRecuperationStaffAssignmentDivision2==null){

      shortStayDementiaDiseaseRecuperationStaffAssignmentDivision2 = new ACRadioButtonItem();

      shortStayDementiaDiseaseRecuperationStaffAssignmentDivision2.setText("II型");

      shortStayDementiaDiseaseRecuperationStaffAssignmentDivision2.setGroup(getShortStayDementiaDiseaseRecuperationStaffAssignmentDivision());

      addShortStayDementiaDiseaseRecuperationStaffAssignmentDivision2();
    }
    return shortStayDementiaDiseaseRecuperationStaffAssignmentDivision2;

  }

  /**
   * III型を取得します。
   * @return III型
   */
  public ACRadioButtonItem getShortStayDementiaDiseaseRecuperationstaffAssignmentDivision3(){
    if(shortStayDementiaDiseaseRecuperationstaffAssignmentDivision3==null){

      shortStayDementiaDiseaseRecuperationstaffAssignmentDivision3 = new ACRadioButtonItem();

      shortStayDementiaDiseaseRecuperationstaffAssignmentDivision3.setText("III型");

      shortStayDementiaDiseaseRecuperationstaffAssignmentDivision3.setGroup(getShortStayDementiaDiseaseRecuperationStaffAssignmentDivision());

      addShortStayDementiaDiseaseRecuperationstaffAssignmentDivision3();
    }
    return shortStayDementiaDiseaseRecuperationstaffAssignmentDivision3;

  }

  /**
   * 送迎体制ラジオグループを取得します。
   * @return 送迎体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystem(){
    if(shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystem==null){

      shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystem = new ACClearableRadioButtonGroup();

      getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemContainer().setText("送迎体制");

      shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystem.setBindPath("1230303");

      shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystem.setModel(getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemModel());

      shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystem.setUseClearButton(false);

      addShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystem();
    }
    return shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystem;

  }

  /**
   * 送迎体制ラジオグループコンテナを取得します。
   * @return 送迎体制ラジオグループコンテナ
   */
  protected ACLabelContainer getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemContainer(){
    if(shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemContainer==null){
      shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemContainer = new ACLabelContainer();
      shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemContainer.setFollowChildEnabled(true);
      shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemContainer.add(getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystem(), null);
    }
    return shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemContainer;
  }

  /**
   * 送迎体制ラジオグループモデルを取得します。
   * @return 送迎体制ラジオグループモデル
   */
  protected ACListModelAdapter getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemModel(){
    if(shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemModel==null){
      shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemModel = new ACListModelAdapter();
      addShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemModel();
    }
    return shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOff(){
    if(shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOff==null){

      shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOff = new ACRadioButtonItem();

      shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOff.setText("なし");

      shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOff.setGroup(getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystem());

      addShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOff();
    }
    return shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOff;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOn(){
    if(shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOn==null){

      shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOn = new ACRadioButtonItem();

      shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOn.setText("あり");

      shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOn.setGroup(getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystem());

      addShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOn();
    }
    return shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOn;

  }

  /**
   * 栄養管理体制ラジオグループを取得します。
   * @return 栄養管理体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getShortStayDementiaDiseaseRecuperationNutritionManageRadio(){
    if(shortStayDementiaDiseaseRecuperationNutritionManageRadio==null){

      shortStayDementiaDiseaseRecuperationNutritionManageRadio = new ACClearableRadioButtonGroup();

      getShortStayDementiaDiseaseRecuperationNutritionManageRadioContainer().setText("栄養管理体制");

      shortStayDementiaDiseaseRecuperationNutritionManageRadio.setBindPath("1230304");

      shortStayDementiaDiseaseRecuperationNutritionManageRadio.setModel(getShortStayDementiaDiseaseRecuperationNutritionManageRadioModel());

      shortStayDementiaDiseaseRecuperationNutritionManageRadio.setUseClearButton(false);

      addShortStayDementiaDiseaseRecuperationNutritionManageRadio();
    }
    return shortStayDementiaDiseaseRecuperationNutritionManageRadio;

  }

  /**
   * 栄養管理体制ラジオグループコンテナを取得します。
   * @return 栄養管理体制ラジオグループコンテナ
   */
  protected ACLabelContainer getShortStayDementiaDiseaseRecuperationNutritionManageRadioContainer(){
    if(shortStayDementiaDiseaseRecuperationNutritionManageRadioContainer==null){
      shortStayDementiaDiseaseRecuperationNutritionManageRadioContainer = new ACLabelContainer();
      shortStayDementiaDiseaseRecuperationNutritionManageRadioContainer.setFollowChildEnabled(true);
      shortStayDementiaDiseaseRecuperationNutritionManageRadioContainer.add(getShortStayDementiaDiseaseRecuperationNutritionManageRadio(), null);
    }
    return shortStayDementiaDiseaseRecuperationNutritionManageRadioContainer;
  }

  /**
   * 栄養管理体制ラジオグループモデルを取得します。
   * @return 栄養管理体制ラジオグループモデル
   */
  protected ACListModelAdapter getShortStayDementiaDiseaseRecuperationNutritionManageRadioModel(){
    if(shortStayDementiaDiseaseRecuperationNutritionManageRadioModel==null){
      shortStayDementiaDiseaseRecuperationNutritionManageRadioModel = new ACListModelAdapter();
      addShortStayDementiaDiseaseRecuperationNutritionManageRadioModel();
    }
    return shortStayDementiaDiseaseRecuperationNutritionManageRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayDementiaDiseaseRecuperationNutritionManageRadioItem1(){
    if(shortStayDementiaDiseaseRecuperationNutritionManageRadioItem1==null){

      shortStayDementiaDiseaseRecuperationNutritionManageRadioItem1 = new ACRadioButtonItem();

      shortStayDementiaDiseaseRecuperationNutritionManageRadioItem1.setText("なし");

      shortStayDementiaDiseaseRecuperationNutritionManageRadioItem1.setGroup(getShortStayDementiaDiseaseRecuperationNutritionManageRadio());

      addShortStayDementiaDiseaseRecuperationNutritionManageRadioItem1();
    }
    return shortStayDementiaDiseaseRecuperationNutritionManageRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayDementiaDiseaseRecuperationNutritionManageRadioItem2(){
    if(shortStayDementiaDiseaseRecuperationNutritionManageRadioItem2==null){

      shortStayDementiaDiseaseRecuperationNutritionManageRadioItem2 = new ACRadioButtonItem();

      shortStayDementiaDiseaseRecuperationNutritionManageRadioItem2.setText("あり");

      shortStayDementiaDiseaseRecuperationNutritionManageRadioItem2.setGroup(getShortStayDementiaDiseaseRecuperationNutritionManageRadio());

      addShortStayDementiaDiseaseRecuperationNutritionManageRadioItem2();
    }
    return shortStayDementiaDiseaseRecuperationNutritionManageRadioItem2;

  }

  /**
   * 療養食体制ラジオグループを取得します。
   * @return 療養食体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadio(){
    if(shortStayDementiaDiseaseRecuperationRecuperateDinnerRadio==null){

      shortStayDementiaDiseaseRecuperationRecuperateDinnerRadio = new ACClearableRadioButtonGroup();

      getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioContainer().setText("療養食体制");

      shortStayDementiaDiseaseRecuperationRecuperateDinnerRadio.setBindPath("1230305");

      shortStayDementiaDiseaseRecuperationRecuperateDinnerRadio.setModel(getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioModel());

      shortStayDementiaDiseaseRecuperationRecuperateDinnerRadio.setUseClearButton(false);

      addShortStayDementiaDiseaseRecuperationRecuperateDinnerRadio();
    }
    return shortStayDementiaDiseaseRecuperationRecuperateDinnerRadio;

  }

  /**
   * 療養食体制ラジオグループコンテナを取得します。
   * @return 療養食体制ラジオグループコンテナ
   */
  protected ACLabelContainer getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioContainer(){
    if(shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioContainer==null){
      shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioContainer = new ACLabelContainer();
      shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioContainer.setFollowChildEnabled(true);
      shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioContainer.add(getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadio(), null);
    }
    return shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioContainer;
  }

  /**
   * 療養食体制ラジオグループモデルを取得します。
   * @return 療養食体制ラジオグループモデル
   */
  protected ACListModelAdapter getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioModel(){
    if(shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioModel==null){
      shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioModel = new ACListModelAdapter();
      addShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioModel();
    }
    return shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem1(){
    if(shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem1==null){

      shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem1 = new ACRadioButtonItem();

      shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem1.setText("なし");

      shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem1.setGroup(getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadio());

      addShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem1();
    }
    return shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem2(){
    if(shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem2==null){

      shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem2 = new ACRadioButtonItem();

      shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem2.setText("あり");

      shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem2.setGroup(getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadio());

      addShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem2();
    }
    return shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem2;

  }

  /**
   * 人員減算コンボを取得します。
   * @return 人員減算コンボ
   */
  public ACComboBox getShortStayDementiaDiseaseRecuperationStaffReduce(){
    if(shortStayDementiaDiseaseRecuperationStaffReduce==null){

      shortStayDementiaDiseaseRecuperationStaffReduce = new ACComboBox();

      getShortStayDementiaDiseaseRecuperationStaffReduceContainer().setText("人員減算");

      shortStayDementiaDiseaseRecuperationStaffReduce.setBindPath("1230306");

      shortStayDementiaDiseaseRecuperationStaffReduce.setEditable(false);

      shortStayDementiaDiseaseRecuperationStaffReduce.setModel(getShortStayDementiaDiseaseRecuperationStaffReduceModel());

      shortStayDementiaDiseaseRecuperationStaffReduce.setRenderBindPath("CONTENT");

      addShortStayDementiaDiseaseRecuperationStaffReduce();
    }
    return shortStayDementiaDiseaseRecuperationStaffReduce;

  }

  /**
   * 人員減算コンボコンテナを取得します。
   * @return 人員減算コンボコンテナ
   */
  protected ACLabelContainer getShortStayDementiaDiseaseRecuperationStaffReduceContainer(){
    if(shortStayDementiaDiseaseRecuperationStaffReduceContainer==null){
      shortStayDementiaDiseaseRecuperationStaffReduceContainer = new ACLabelContainer();
      shortStayDementiaDiseaseRecuperationStaffReduceContainer.setFollowChildEnabled(true);
      shortStayDementiaDiseaseRecuperationStaffReduceContainer.add(getShortStayDementiaDiseaseRecuperationStaffReduce(), null);
    }
    return shortStayDementiaDiseaseRecuperationStaffReduceContainer;
  }

  /**
   * 人員減算コンボモデルを取得します。
   * @return 人員減算コンボモデル
   */
  protected ACComboBoxModelAdapter getShortStayDementiaDiseaseRecuperationStaffReduceModel(){
    if(shortStayDementiaDiseaseRecuperationStaffReduceModel==null){
      shortStayDementiaDiseaseRecuperationStaffReduceModel = new ACComboBoxModelAdapter();
      addShortStayDementiaDiseaseRecuperationStaffReduceModel();
    }
    return shortStayDementiaDiseaseRecuperationStaffReduceModel;
  }

  /**
   * 食費基準額・コンテナを取得します。
   * @return 食費基準額・コンテナ
   */
  public ACLabelContainer getShortStayRecuperateCareCognitiveDinnerStandeirdMoneyConteiner(){
    if(shortStayRecuperateCareCognitiveDinnerStandeirdMoneyConteiner==null){

      shortStayRecuperateCareCognitiveDinnerStandeirdMoneyConteiner = new ACLabelContainer();

      shortStayRecuperateCareCognitiveDinnerStandeirdMoneyConteiner.setText("食費基準額");

      shortStayRecuperateCareCognitiveDinnerStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareCognitiveDinnerStandeirdMoneyConteiner();
    }
    return shortStayRecuperateCareCognitiveDinnerStandeirdMoneyConteiner;

  }

  /**
   * 食費基準額・合計・テキストを取得します。
   * @return 食費基準額・合計・テキスト
   */
  public ACTextField getShortStayRecuperateCareCognitiveDinnerStandeirdMoneyTotal(){
    if(shortStayRecuperateCareCognitiveDinnerStandeirdMoneyTotal==null){

      shortStayRecuperateCareCognitiveDinnerStandeirdMoneyTotal = new ACTextField();

      shortStayRecuperateCareCognitiveDinnerStandeirdMoneyTotal.setBindPath("1230307");

      shortStayRecuperateCareCognitiveDinnerStandeirdMoneyTotal.setEditable(false);

      shortStayRecuperateCareCognitiveDinnerStandeirdMoneyTotal.setColumns(4);

      shortStayRecuperateCareCognitiveDinnerStandeirdMoneyTotal.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareCognitiveDinnerStandeirdMoneyTotal.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareCognitiveDinnerStandeirdMoneyTotal.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareCognitiveDinnerStandeirdMoneyTotal.setMaxLength(4);

      addShortStayRecuperateCareCognitiveDinnerStandeirdMoneyTotal();
    }
    return shortStayRecuperateCareCognitiveDinnerStandeirdMoneyTotal;

  }

  /**
   * 食費基準額・朝・ラベルを取得します。
   * @return 食費基準額・朝・ラベル
   */
  public ACLabel getShortStayRecuperateCareCognitiveMorningDinnerStandeirdMoneyLabel(){
    if(shortStayRecuperateCareCognitiveMorningDinnerStandeirdMoneyLabel==null){

      shortStayRecuperateCareCognitiveMorningDinnerStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareCognitiveMorningDinnerStandeirdMoneyLabel.setText("　朝");

      addShortStayRecuperateCareCognitiveMorningDinnerStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareCognitiveMorningDinnerStandeirdMoneyLabel;

  }

  /**
   * 食費基準額・朝・テキストを取得します。
   * @return 食費基準額・朝・テキスト
   */
  public ACTextField getShortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney(){
    if(shortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney==null){

      shortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney = new ACTextField();

      shortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney.setBindPath("1230308");

      shortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney.setColumns(3);

      shortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney.setMaxLength(3);

      addShortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney();
    }
    return shortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney;

  }

  /**
   * 食費基準額・昼・ラベルを取得します。
   * @return 食費基準額・昼・ラベル
   */
  public ACLabel getShortStayRecuperateCareCognitiveNoonDinnerStandeirdMoneyLabel(){
    if(shortStayRecuperateCareCognitiveNoonDinnerStandeirdMoneyLabel==null){

      shortStayRecuperateCareCognitiveNoonDinnerStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareCognitiveNoonDinnerStandeirdMoneyLabel.setText("昼");

      addShortStayRecuperateCareCognitiveNoonDinnerStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareCognitiveNoonDinnerStandeirdMoneyLabel;

  }

  /**
   * 食費基準額・昼・テキストを取得します。
   * @return 食費基準額・昼・テキスト
   */
  public ACTextField getShortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney(){
    if(shortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney==null){

      shortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney = new ACTextField();

      shortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney.setBindPath("1230309");

      shortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney.setColumns(3);

      shortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney.setMaxLength(3);

      addShortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney();
    }
    return shortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney;

  }

  /**
   * 食費基準額・夜・ラベルを取得します。
   * @return 食費基準額・夜・ラベル
   */
  public ACLabel getShortStayRecuperateCareCognitiveNightDinnerStandeirdTotalMoneyLabel(){
    if(shortStayRecuperateCareCognitiveNightDinnerStandeirdTotalMoneyLabel==null){

      shortStayRecuperateCareCognitiveNightDinnerStandeirdTotalMoneyLabel = new ACLabel();

      shortStayRecuperateCareCognitiveNightDinnerStandeirdTotalMoneyLabel.setText("夜");

      addShortStayRecuperateCareCognitiveNightDinnerStandeirdTotalMoneyLabel();
    }
    return shortStayRecuperateCareCognitiveNightDinnerStandeirdTotalMoneyLabel;

  }

  /**
   * 食費基準額・夜・テキストを取得します。
   * @return 食費基準額・夜・テキスト
   */
  public ACTextField getShortStayRecuperateCareCognitiveNightDinnerStandeirdMoney(){
    if(shortStayRecuperateCareCognitiveNightDinnerStandeirdMoney==null){

      shortStayRecuperateCareCognitiveNightDinnerStandeirdMoney = new ACTextField();

      shortStayRecuperateCareCognitiveNightDinnerStandeirdMoney.setBindPath("1230310");

      shortStayRecuperateCareCognitiveNightDinnerStandeirdMoney.setColumns(3);

      shortStayRecuperateCareCognitiveNightDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareCognitiveNightDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareCognitiveNightDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareCognitiveNightDinnerStandeirdMoney.setMaxLength(3);

      addShortStayRecuperateCareCognitiveNightDinnerStandeirdMoney();
    }
    return shortStayRecuperateCareCognitiveNightDinnerStandeirdMoney;

  }

  /**
   * 食費基準額・ラベルを取得します。
   * @return 食費基準額・ラベル
   */
  public ACLabel getShortStayRecuperateCareCognitiveRecuperateCareCognitiveDinnerStandeirdMoney4Label(){
    if(shortStayRecuperateCareCognitiveRecuperateCareCognitiveDinnerStandeirdMoney4Label==null){

      shortStayRecuperateCareCognitiveRecuperateCareCognitiveDinnerStandeirdMoney4Label = new ACLabel();

      shortStayRecuperateCareCognitiveRecuperateCareCognitiveDinnerStandeirdMoney4Label.setText("（円）");

      addShortStayRecuperateCareCognitiveRecuperateCareCognitiveDinnerStandeirdMoney4Label();
    }
    return shortStayRecuperateCareCognitiveRecuperateCareCognitiveDinnerStandeirdMoney4Label;

  }

  /**
   * ユニット型個室基準額・コンテナを取得します。
   * @return ユニット型個室基準額・コンテナ
   */
  public ACLabelContainer getShortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyConteiner(){
    if(shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyConteiner==null){

      shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyConteiner = new ACLabelContainer();

      shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyConteiner.setText("ユニット型個室基準額");

      shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyConteiner();
    }
    return shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyConteiner;

  }

  /**
   * ユニット型個室基準額・テキストを取得します。
   * @return ユニット型個室基準額・テキスト
   */
  public ACTextField getShortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyText(){
    if(shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyText==null){

      shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyText = new ACTextField();

      shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyText.setBindPath("1230311");

      shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyText.setColumns(4);

      shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyText.setMaxLength(4);

      addShortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyText();
    }
    return shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyText;

  }

  /**
   * ユニット型個室基準額・ラベルを取得します。
   * @return ユニット型個室基準額・ラベル
   */
  public ACLabel getShortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyLabel(){
    if(shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyLabel==null){

      shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyLabel.setText("（円）");

      addShortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyLabel;

  }

  /**
   * ユニット型準個室基準額・コンテナを取得します。
   * @return ユニット型準個室基準額・コンテナ
   */
  public ACLabelContainer getShortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyConteiner(){
    if(shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyConteiner==null){

      shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyConteiner = new ACLabelContainer();

      shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyConteiner.setText("ユニット型準個室基準額");

      shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyConteiner();
    }
    return shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyConteiner;

  }

  /**
   * ユニット型準個室基準額・テキストを取得します。
   * @return ユニット型準個室基準額・テキスト
   */
  public ACTextField getShortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyText(){
    if(shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyText==null){

      shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyText = new ACTextField();

      shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyText.setBindPath("1230312");

      shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyText.setColumns(4);

      shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyText.setMaxLength(4);

      addShortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyText();
    }
    return shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyText;

  }

  /**
   * ユニット型準個室基準額・ラベルを取得します。
   * @return ユニット型準個室基準額・ラベル
   */
  public ACLabel getShortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyLabel(){
    if(shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyLabel==null){

      shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyLabel.setText("（円）");

      addShortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyLabel;

  }

  /**
   * 従来型個室基準額・コンテナを取得します。
   * @return 従来型個室基準額・コンテナ
   */
  public ACLabelContainer getShortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyConteiner(){
    if(shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyConteiner==null){

      shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyConteiner = new ACLabelContainer();

      shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyConteiner.setText("　　従来型個室基準額");

      shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyConteiner();
    }
    return shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyConteiner;

  }

  /**
   * 従来型個室基準額・テキストを取得します。
   * @return 従来型個室基準額・テキスト
   */
  public ACTextField getShortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyText(){
    if(shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyText==null){

      shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyText = new ACTextField();

      shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyText.setBindPath("1230313");

      shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyText.setColumns(4);

      shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyText.setMaxLength(4);

      addShortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyText();
    }
    return shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyText;

  }

  /**
   * 従来型個室基準額・ラベルを取得します。
   * @return 従来型個室基準額・ラベル
   */
  public ACLabel getShortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyLabel(){
    if(shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyLabel==null){

      shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyLabel.setText("（円）");

      addShortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyLabel;

  }

  /**
   * 多床室基準額・コンテナを取得します。
   * @return 多床室基準額・コンテナ
   */
  public ACLabelContainer getShortStayRecuperateCareCognitiveTasyouRoomConteiner(){
    if(shortStayRecuperateCareCognitiveTasyouRoomConteiner==null){

      shortStayRecuperateCareCognitiveTasyouRoomConteiner = new ACLabelContainer();

      shortStayRecuperateCareCognitiveTasyouRoomConteiner.setText("　　多床室基準額");

      shortStayRecuperateCareCognitiveTasyouRoomConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareCognitiveTasyouRoomConteiner();
    }
    return shortStayRecuperateCareCognitiveTasyouRoomConteiner;

  }

  /**
   * 多床室基準額・テキストを取得します。
   * @return 多床室基準額・テキスト
   */
  public ACTextField getShortStayRecuperateCareCognitiveTasyouRoomText(){
    if(shortStayRecuperateCareCognitiveTasyouRoomText==null){

      shortStayRecuperateCareCognitiveTasyouRoomText = new ACTextField();

      shortStayRecuperateCareCognitiveTasyouRoomText.setBindPath("1230314");

      shortStayRecuperateCareCognitiveTasyouRoomText.setColumns(4);

      shortStayRecuperateCareCognitiveTasyouRoomText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareCognitiveTasyouRoomText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareCognitiveTasyouRoomText.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareCognitiveTasyouRoomText.setMaxLength(4);

      addShortStayRecuperateCareCognitiveTasyouRoomText();
    }
    return shortStayRecuperateCareCognitiveTasyouRoomText;

  }

  /**
   * 多床室基準額・ラベルを取得します。
   * @return 多床室基準額・ラベル
   */
  public ACLabel getShortStayRecuperateCareCognitiveTasyouRoomLabel(){
    if(shortStayRecuperateCareCognitiveTasyouRoomLabel==null){

      shortStayRecuperateCareCognitiveTasyouRoomLabel = new ACLabel();

      shortStayRecuperateCareCognitiveTasyouRoomLabel.setText("（円）");

      addShortStayRecuperateCareCognitiveTasyouRoomLabel();
    }
    return shortStayRecuperateCareCognitiveTasyouRoomLabel;

  }

  /**
   * コンストラクタです。
   */
  public QO004012Design() {

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

    this.add(getShortStayDementiaDiseaseRecuperationGroup(), VRLayout.CLIENT);

  }

  /**
   * 事業グループに内部項目を追加します。
   */
  protected void addShortStayDementiaDiseaseRecuperationGroup(){

    shortStayDementiaDiseaseRecuperationGroup.add(getShortStayDementiaDiseaseRecuperationDiscountConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayDementiaDiseaseRecuperationGroup.add(getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayDementiaDiseaseRecuperationGroup.add(getShortStayDementiaDiseaseRecuperationStaffAssignmentDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayDementiaDiseaseRecuperationGroup.add(getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayDementiaDiseaseRecuperationGroup.add(getShortStayDementiaDiseaseRecuperationNutritionManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayDementiaDiseaseRecuperationGroup.add(getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayDementiaDiseaseRecuperationGroup.add(getShortStayDementiaDiseaseRecuperationStaffReduceContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayDementiaDiseaseRecuperationGroup.add(getShortStayRecuperateCareCognitiveDinnerStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayDementiaDiseaseRecuperationGroup.add(getShortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayDementiaDiseaseRecuperationGroup.add(getShortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayDementiaDiseaseRecuperationGroup.add(getShortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayDementiaDiseaseRecuperationGroup.add(getShortStayRecuperateCareCognitiveTasyouRoomConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 割引率コンテナに内部項目を追加します。
   */
  protected void addShortStayDementiaDiseaseRecuperationDiscountConteiner(){

    shortStayDementiaDiseaseRecuperationDiscountConteiner.add(getShortStayDementiaDiseaseRecuperationDiscountRate(), VRLayout.FLOW);

    shortStayDementiaDiseaseRecuperationDiscountConteiner.add(getShortStayDementiaDiseaseRecuperationPercentSign(), VRLayout.FLOW);

  }

  /**
   * 割引率に内部項目を追加します。
   */
  protected void addShortStayDementiaDiseaseRecuperationDiscountRate(){

  }

  /**
   * ％ラベルに内部項目を追加します。
   */
  protected void addShortStayDementiaDiseaseRecuperationPercentSign(){

  }

  /**
   * 施設区分ラジオグループに内部項目を追加します。
   */
  protected void addShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadio(){

  }

  /**
   * 施設区分ラジオグループモデルに内部項目を追加します。
   */
  protected void addShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioModel(){

    getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem1().setButtonIndex(1);
    getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioModel().add(getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem1());

    getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem2().setButtonIndex(2);
    getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioModel().add(getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem2());

  }

  /**
   * 認知症疾患型に内部項目を追加します。
   */
  protected void addShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem1(){

  }

  /**
   * ユニット型認知症疾患型に内部項目を追加します。
   */
  protected void addShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem2(){

  }

  /**
   * 人員配置区分ラジオグループに内部項目を追加します。
   */
  protected void addShortStayDementiaDiseaseRecuperationStaffAssignmentDivision(){

  }

  /**
   * 人員配置区分ラジオグループモデルに内部項目を追加します。
   */
  protected void addShortStayDementiaDiseaseRecuperationStaffAssignmentDivisionModel(){

    getShortStayDementiaDiseaseRecuperationStaffAssignmentDivision1().setButtonIndex(1);
    getShortStayDementiaDiseaseRecuperationStaffAssignmentDivisionModel().add(getShortStayDementiaDiseaseRecuperationStaffAssignmentDivision1());

    getShortStayDementiaDiseaseRecuperationStaffAssignmentDivision2().setButtonIndex(2);
    getShortStayDementiaDiseaseRecuperationStaffAssignmentDivisionModel().add(getShortStayDementiaDiseaseRecuperationStaffAssignmentDivision2());

    getShortStayDementiaDiseaseRecuperationstaffAssignmentDivision3().setButtonIndex(3);
    getShortStayDementiaDiseaseRecuperationStaffAssignmentDivisionModel().add(getShortStayDementiaDiseaseRecuperationstaffAssignmentDivision3());

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addShortStayDementiaDiseaseRecuperationStaffAssignmentDivision1(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addShortStayDementiaDiseaseRecuperationStaffAssignmentDivision2(){

  }

  /**
   * III型に内部項目を追加します。
   */
  protected void addShortStayDementiaDiseaseRecuperationstaffAssignmentDivision3(){

  }

  /**
   * 送迎体制ラジオグループに内部項目を追加します。
   */
  protected void addShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystem(){

  }

  /**
   * 送迎体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemModel(){

    getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOff().setButtonIndex(1);
    getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemModel().add(getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOff());

    getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOn().setButtonIndex(2);
    getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemModel().add(getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOn());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOff(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOn(){

  }

  /**
   * 栄養管理体制ラジオグループに内部項目を追加します。
   */
  protected void addShortStayDementiaDiseaseRecuperationNutritionManageRadio(){

  }

  /**
   * 栄養管理体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addShortStayDementiaDiseaseRecuperationNutritionManageRadioModel(){

    getShortStayDementiaDiseaseRecuperationNutritionManageRadioItem1().setButtonIndex(1);
    getShortStayDementiaDiseaseRecuperationNutritionManageRadioModel().add(getShortStayDementiaDiseaseRecuperationNutritionManageRadioItem1());

    getShortStayDementiaDiseaseRecuperationNutritionManageRadioItem2().setButtonIndex(2);
    getShortStayDementiaDiseaseRecuperationNutritionManageRadioModel().add(getShortStayDementiaDiseaseRecuperationNutritionManageRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayDementiaDiseaseRecuperationNutritionManageRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayDementiaDiseaseRecuperationNutritionManageRadioItem2(){

  }

  /**
   * 療養食体制ラジオグループに内部項目を追加します。
   */
  protected void addShortStayDementiaDiseaseRecuperationRecuperateDinnerRadio(){

  }

  /**
   * 療養食体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioModel(){

    getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem1().setButtonIndex(1);
    getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioModel().add(getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem1());

    getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem2().setButtonIndex(2);
    getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioModel().add(getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem2(){

  }

  /**
   * 人員減算コンボに内部項目を追加します。
   */
  protected void addShortStayDementiaDiseaseRecuperationStaffReduce(){

  }

  /**
   * 人員減算コンボモデルに内部項目を追加します。
   */
  protected void addShortStayDementiaDiseaseRecuperationStaffReduceModel(){

  }

  /**
   * 食費基準額・コンテナに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareCognitiveDinnerStandeirdMoneyConteiner(){

    shortStayRecuperateCareCognitiveDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareCognitiveDinnerStandeirdMoneyTotal(), VRLayout.FLOW);

    shortStayRecuperateCareCognitiveDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareCognitiveMorningDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    shortStayRecuperateCareCognitiveDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney(), VRLayout.FLOW);

    shortStayRecuperateCareCognitiveDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareCognitiveNoonDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    shortStayRecuperateCareCognitiveDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney(), VRLayout.FLOW);

    shortStayRecuperateCareCognitiveDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareCognitiveNightDinnerStandeirdTotalMoneyLabel(), VRLayout.FLOW);

    shortStayRecuperateCareCognitiveDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareCognitiveNightDinnerStandeirdMoney(), VRLayout.FLOW);

    shortStayRecuperateCareCognitiveDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareCognitiveRecuperateCareCognitiveDinnerStandeirdMoney4Label(), VRLayout.FLOW);

  }

  /**
   * 食費基準額・合計・テキストに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareCognitiveDinnerStandeirdMoneyTotal(){

  }

  /**
   * 食費基準額・朝・ラベルに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareCognitiveMorningDinnerStandeirdMoneyLabel(){

  }

  /**
   * 食費基準額・朝・テキストに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney(){

  }

  /**
   * 食費基準額・昼・ラベルに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareCognitiveNoonDinnerStandeirdMoneyLabel(){

  }

  /**
   * 食費基準額・昼・テキストに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney(){

  }

  /**
   * 食費基準額・夜・ラベルに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareCognitiveNightDinnerStandeirdTotalMoneyLabel(){

  }

  /**
   * 食費基準額・夜・テキストに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareCognitiveNightDinnerStandeirdMoney(){

  }

  /**
   * 食費基準額・ラベルに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareCognitiveRecuperateCareCognitiveDinnerStandeirdMoney4Label(){

  }

  /**
   * ユニット型個室基準額・コンテナに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyConteiner(){

    shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyText(), null);

    shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyLabel(), null);

  }

  /**
   * ユニット型個室基準額・テキストに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyText(){

  }

  /**
   * ユニット型個室基準額・ラベルに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyLabel(){

  }

  /**
   * ユニット型準個室基準額・コンテナに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyConteiner(){

    shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyText(), null);

    shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyLabel(), null);

  }

  /**
   * ユニット型準個室基準額・テキストに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyText(){

  }

  /**
   * ユニット型準個室基準額・ラベルに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyLabel(){

  }

  /**
   * 従来型個室基準額・コンテナに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyConteiner(){

    shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyText(), null);

    shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyLabel(), null);

  }

  /**
   * 従来型個室基準額・テキストに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyText(){

  }

  /**
   * 従来型個室基準額・ラベルに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyLabel(){

  }

  /**
   * 多床室基準額・コンテナに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareCognitiveTasyouRoomConteiner(){

    shortStayRecuperateCareCognitiveTasyouRoomConteiner.add(getShortStayRecuperateCareCognitiveTasyouRoomText(), null);

    shortStayRecuperateCareCognitiveTasyouRoomConteiner.add(getShortStayRecuperateCareCognitiveTasyouRoomLabel(), null);

  }

  /**
   * 多床室基準額・テキストに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareCognitiveTasyouRoomText(){

  }

  /**
   * 多床室基準額・ラベルに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareCognitiveTasyouRoomLabel(){

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
      ACFrame.getInstance().getContentPane().add(new QO004012Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004012Design getThis() {
    return this;
  }
}
