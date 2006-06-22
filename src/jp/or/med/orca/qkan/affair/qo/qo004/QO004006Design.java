
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
 * プログラム 通所リハ (QO004006)
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
 * 通所リハ画面項目デザイン(QO004006) 
 */
public class QO004006Design extends ACPanel {
  //GUIコンポーネント

  private ACGroupBox tsuusyorehabilitationGroup;

  private ACLabelContainer tsuusyorehabilitationDiscountContena;

  private ACTextField tsuusyorehabilitationDiscountRate;

  private ACLabel tsuusyorehabilitationPercentSign;

  private ACClearableRadioButtonGroup tsuusyorehabilitationFacilitiesDivision;

  private ACLabelContainer tsuusyorehabilitationFacilitiesDivisionContainer;

  private ACListModelAdapter tsuusyorehabilitationFacilitiesDivisionModel;

  private ACRadioButtonItem tsuusyorehabilitationNormalFacilities;

  private ACRadioButtonItem tsuusyorehabilitationSmallFacilities;

  private ACRadioButtonItem tsuusyorehabilitationEtcFacilities;

  private ACClearableRadioButtonGroup tsuusyorehabilitationBathingHelpSystem;

  private ACLabelContainer tsuusyorehabilitationBathingHelpSystemContainer;

  private ACListModelAdapter tsuusyorehabilitationBathingHelpSystemModel;

  private ACRadioButtonItem tsuusyorehabilitationBathingHelpSystemOff;

  private ACRadioButtonItem tsuusyorehabilitationBathingHelpSystemOn;

  private ACClearableRadioButtonGroup tsuusyorehabilitationSpecialBathingHelpSystem;

  private ACLabelContainer tsuusyorehabilitationSpecialBathingHelpSystemContainer;

  private ACListModelAdapter tsuusyorehabilitationSpecialBathingHelpSystemModel;

  private ACRadioButtonItem tsuusyorehabilitationSpecialBathingHelpSystemOff;

  private ACRadioButtonItem tsuusyorehabilitationSpecialBathingHelpSystemOn;

  private ACClearableRadioButtonGroup tsuusyorehabilitationMeetingAndSendingOffSystem;

  private ACLabelContainer tsuusyorehabilitationMeetingAndSendingOffSystemContainer;

  private ACListModelAdapter tsuusyorehabilitationMeetingAndSendingOffSystemModel;

  private ACRadioButtonItem tsuusyorehabilitationMeetingAndSendingOffSystemOff;

  private ACRadioButtonItem tsuusyorehabilitationMeetingAndSendingOffSystemOn;

  private ACClearableRadioButtonGroup tsuusyorehabilitationStaffReduce;

  private ACLabelContainer tsuusyorehabilitationStaffReduceContainer;

  private ACListModelAdapter tsuusyorehabilitationStaffReduceModel;

  private ACRadioButtonItem tsuusyorehabilitationStaffNot;

  private ACRadioButtonItem tsuusyorehabilitationStaffExcess;

  private ACRadioButtonItem tsuusyorehabilitationMedicalStaffDivision;

  //getter

  /**
   * 事業グループを取得します。
   * @return 事業グループ
   */
  public ACGroupBox getTsuusyorehabilitationGroup(){
    if(tsuusyorehabilitationGroup==null){

      tsuusyorehabilitationGroup = new ACGroupBox();

      tsuusyorehabilitationGroup.setText("通所リハビリテーション");

      tsuusyorehabilitationGroup.setFollowChildEnabled(true);

      tsuusyorehabilitationGroup.setHgrid(200);

      addTsuusyorehabilitationGroup();
    }
    return tsuusyorehabilitationGroup;

  }

  /**
   * 割引率コンテナを取得します。
   * @return 割引率コンテナ
   */
  public ACLabelContainer getTsuusyorehabilitationDiscountContena(){
    if(tsuusyorehabilitationDiscountContena==null){

      tsuusyorehabilitationDiscountContena = new ACLabelContainer();

      tsuusyorehabilitationDiscountContena.setText("割引率");

      tsuusyorehabilitationDiscountContena.setFollowChildEnabled(true);

      addTsuusyorehabilitationDiscountContena();
    }
    return tsuusyorehabilitationDiscountContena;

  }

  /**
   * 割引率を取得します。
   * @return 割引率
   */
  public ACTextField getTsuusyorehabilitationDiscountRate(){
    if(tsuusyorehabilitationDiscountRate==null){

      tsuusyorehabilitationDiscountRate = new ACTextField();

      tsuusyorehabilitationDiscountRate.setBindPath("REDUCT_RATE");

      tsuusyorehabilitationDiscountRate.setColumns(3);

      tsuusyorehabilitationDiscountRate.setCharType(VRCharType.ONLY_DIGIT);

      tsuusyorehabilitationDiscountRate.setHorizontalAlignment(SwingConstants.RIGHT);

      tsuusyorehabilitationDiscountRate.setIMEMode(InputSubset.LATIN);

      tsuusyorehabilitationDiscountRate.setMaxLength(3);

      addTsuusyorehabilitationDiscountRate();
    }
    return tsuusyorehabilitationDiscountRate;

  }

  /**
   * ％ラベルを取得します。
   * @return ％ラベル
   */
  public ACLabel getTsuusyorehabilitationPercentSign(){
    if(tsuusyorehabilitationPercentSign==null){

      tsuusyorehabilitationPercentSign = new ACLabel();

      tsuusyorehabilitationPercentSign.setText("％");

      addTsuusyorehabilitationPercentSign();
    }
    return tsuusyorehabilitationPercentSign;

  }

  /**
   * 施設区分ラジオグループを取得します。
   * @return 施設区分ラジオグループ
   */
  public ACClearableRadioButtonGroup getTsuusyorehabilitationFacilitiesDivision(){
    if(tsuusyorehabilitationFacilitiesDivision==null){

      tsuusyorehabilitationFacilitiesDivision = new ACClearableRadioButtonGroup();

      getTsuusyorehabilitationFacilitiesDivisionContainer().setText("施設区分");

      tsuusyorehabilitationFacilitiesDivision.setBindPath("1160101");

      tsuusyorehabilitationFacilitiesDivision.setModel(getTsuusyorehabilitationFacilitiesDivisionModel());

      tsuusyorehabilitationFacilitiesDivision.setUseClearButton(false);

      addTsuusyorehabilitationFacilitiesDivision();
    }
    return tsuusyorehabilitationFacilitiesDivision;

  }

  /**
   * 施設区分ラジオグループコンテナを取得します。
   * @return 施設区分ラジオグループコンテナ
   */
  protected ACLabelContainer getTsuusyorehabilitationFacilitiesDivisionContainer(){
    if(tsuusyorehabilitationFacilitiesDivisionContainer==null){
      tsuusyorehabilitationFacilitiesDivisionContainer = new ACLabelContainer();
      tsuusyorehabilitationFacilitiesDivisionContainer.setFollowChildEnabled(true);
      tsuusyorehabilitationFacilitiesDivisionContainer.add(getTsuusyorehabilitationFacilitiesDivision(), null);
    }
    return tsuusyorehabilitationFacilitiesDivisionContainer;
  }

  /**
   * 施設区分ラジオグループモデルを取得します。
   * @return 施設区分ラジオグループモデル
   */
  protected ACListModelAdapter getTsuusyorehabilitationFacilitiesDivisionModel(){
    if(tsuusyorehabilitationFacilitiesDivisionModel==null){
      tsuusyorehabilitationFacilitiesDivisionModel = new ACListModelAdapter();
      addTsuusyorehabilitationFacilitiesDivisionModel();
    }
    return tsuusyorehabilitationFacilitiesDivisionModel;
  }

  /**
   * 通常規模の医療機関を取得します。
   * @return 通常規模の医療機関
   */
  public ACRadioButtonItem getTsuusyorehabilitationNormalFacilities(){
    if(tsuusyorehabilitationNormalFacilities==null){

      tsuusyorehabilitationNormalFacilities = new ACRadioButtonItem();

      tsuusyorehabilitationNormalFacilities.setText("通常規模の医療機関");

      tsuusyorehabilitationNormalFacilities.setGroup(getTsuusyorehabilitationFacilitiesDivision());

      addTsuusyorehabilitationNormalFacilities();
    }
    return tsuusyorehabilitationNormalFacilities;

  }

  /**
   * 小規模診療所を取得します。
   * @return 小規模診療所
   */
  public ACRadioButtonItem getTsuusyorehabilitationSmallFacilities(){
    if(tsuusyorehabilitationSmallFacilities==null){

      tsuusyorehabilitationSmallFacilities = new ACRadioButtonItem();

      tsuusyorehabilitationSmallFacilities.setText("小規模診療所");

      tsuusyorehabilitationSmallFacilities.setGroup(getTsuusyorehabilitationFacilitiesDivision());

      addTsuusyorehabilitationSmallFacilities();
    }
    return tsuusyorehabilitationSmallFacilities;

  }

  /**
   * 介護老人保健施設を取得します。
   * @return 介護老人保健施設
   */
  public ACRadioButtonItem getTsuusyorehabilitationEtcFacilities(){
    if(tsuusyorehabilitationEtcFacilities==null){

      tsuusyorehabilitationEtcFacilities = new ACRadioButtonItem();

      tsuusyorehabilitationEtcFacilities.setText("介護老人保健施設");

      tsuusyorehabilitationEtcFacilities.setGroup(getTsuusyorehabilitationFacilitiesDivision());

      addTsuusyorehabilitationEtcFacilities();
    }
    return tsuusyorehabilitationEtcFacilities;

  }

  /**
   * 入浴介助体制ラジオグループを取得します。
   * @return 入浴介助体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getTsuusyorehabilitationBathingHelpSystem(){
    if(tsuusyorehabilitationBathingHelpSystem==null){

      tsuusyorehabilitationBathingHelpSystem = new ACClearableRadioButtonGroup();

      getTsuusyorehabilitationBathingHelpSystemContainer().setText("入浴介助体制");

      tsuusyorehabilitationBathingHelpSystem.setBindPath("1160102");

      tsuusyorehabilitationBathingHelpSystem.setModel(getTsuusyorehabilitationBathingHelpSystemModel());

      tsuusyorehabilitationBathingHelpSystem.setUseClearButton(false);

      addTsuusyorehabilitationBathingHelpSystem();
    }
    return tsuusyorehabilitationBathingHelpSystem;

  }

  /**
   * 入浴介助体制ラジオグループコンテナを取得します。
   * @return 入浴介助体制ラジオグループコンテナ
   */
  protected ACLabelContainer getTsuusyorehabilitationBathingHelpSystemContainer(){
    if(tsuusyorehabilitationBathingHelpSystemContainer==null){
      tsuusyorehabilitationBathingHelpSystemContainer = new ACLabelContainer();
      tsuusyorehabilitationBathingHelpSystemContainer.setFollowChildEnabled(true);
      tsuusyorehabilitationBathingHelpSystemContainer.add(getTsuusyorehabilitationBathingHelpSystem(), null);
    }
    return tsuusyorehabilitationBathingHelpSystemContainer;
  }

  /**
   * 入浴介助体制ラジオグループモデルを取得します。
   * @return 入浴介助体制ラジオグループモデル
   */
  protected ACListModelAdapter getTsuusyorehabilitationBathingHelpSystemModel(){
    if(tsuusyorehabilitationBathingHelpSystemModel==null){
      tsuusyorehabilitationBathingHelpSystemModel = new ACListModelAdapter();
      addTsuusyorehabilitationBathingHelpSystemModel();
    }
    return tsuusyorehabilitationBathingHelpSystemModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTsuusyorehabilitationBathingHelpSystemOff(){
    if(tsuusyorehabilitationBathingHelpSystemOff==null){

      tsuusyorehabilitationBathingHelpSystemOff = new ACRadioButtonItem();

      tsuusyorehabilitationBathingHelpSystemOff.setText("なし");

      tsuusyorehabilitationBathingHelpSystemOff.setGroup(getTsuusyorehabilitationBathingHelpSystem());

      addTsuusyorehabilitationBathingHelpSystemOff();
    }
    return tsuusyorehabilitationBathingHelpSystemOff;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getTsuusyorehabilitationBathingHelpSystemOn(){
    if(tsuusyorehabilitationBathingHelpSystemOn==null){

      tsuusyorehabilitationBathingHelpSystemOn = new ACRadioButtonItem();

      tsuusyorehabilitationBathingHelpSystemOn.setText("あり");

      tsuusyorehabilitationBathingHelpSystemOn.setGroup(getTsuusyorehabilitationBathingHelpSystem());

      addTsuusyorehabilitationBathingHelpSystemOn();
    }
    return tsuusyorehabilitationBathingHelpSystemOn;

  }

  /**
   * 特別入浴介助体制ラジオグループを取得します。
   * @return 特別入浴介助体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getTsuusyorehabilitationSpecialBathingHelpSystem(){
    if(tsuusyorehabilitationSpecialBathingHelpSystem==null){

      tsuusyorehabilitationSpecialBathingHelpSystem = new ACClearableRadioButtonGroup();

      getTsuusyorehabilitationSpecialBathingHelpSystemContainer().setText("特別入浴介助体制");

      tsuusyorehabilitationSpecialBathingHelpSystem.setBindPath("1160103");

      tsuusyorehabilitationSpecialBathingHelpSystem.setModel(getTsuusyorehabilitationSpecialBathingHelpSystemModel());

      tsuusyorehabilitationSpecialBathingHelpSystem.setUseClearButton(false);

      addTsuusyorehabilitationSpecialBathingHelpSystem();
    }
    return tsuusyorehabilitationSpecialBathingHelpSystem;

  }

  /**
   * 特別入浴介助体制ラジオグループコンテナを取得します。
   * @return 特別入浴介助体制ラジオグループコンテナ
   */
  protected ACLabelContainer getTsuusyorehabilitationSpecialBathingHelpSystemContainer(){
    if(tsuusyorehabilitationSpecialBathingHelpSystemContainer==null){
      tsuusyorehabilitationSpecialBathingHelpSystemContainer = new ACLabelContainer();
      tsuusyorehabilitationSpecialBathingHelpSystemContainer.setFollowChildEnabled(true);
      tsuusyorehabilitationSpecialBathingHelpSystemContainer.add(getTsuusyorehabilitationSpecialBathingHelpSystem(), null);
    }
    return tsuusyorehabilitationSpecialBathingHelpSystemContainer;
  }

  /**
   * 特別入浴介助体制ラジオグループモデルを取得します。
   * @return 特別入浴介助体制ラジオグループモデル
   */
  protected ACListModelAdapter getTsuusyorehabilitationSpecialBathingHelpSystemModel(){
    if(tsuusyorehabilitationSpecialBathingHelpSystemModel==null){
      tsuusyorehabilitationSpecialBathingHelpSystemModel = new ACListModelAdapter();
      addTsuusyorehabilitationSpecialBathingHelpSystemModel();
    }
    return tsuusyorehabilitationSpecialBathingHelpSystemModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTsuusyorehabilitationSpecialBathingHelpSystemOff(){
    if(tsuusyorehabilitationSpecialBathingHelpSystemOff==null){

      tsuusyorehabilitationSpecialBathingHelpSystemOff = new ACRadioButtonItem();

      tsuusyorehabilitationSpecialBathingHelpSystemOff.setText("なし");

      tsuusyorehabilitationSpecialBathingHelpSystemOff.setGroup(getTsuusyorehabilitationSpecialBathingHelpSystem());

      addTsuusyorehabilitationSpecialBathingHelpSystemOff();
    }
    return tsuusyorehabilitationSpecialBathingHelpSystemOff;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getTsuusyorehabilitationSpecialBathingHelpSystemOn(){
    if(tsuusyorehabilitationSpecialBathingHelpSystemOn==null){

      tsuusyorehabilitationSpecialBathingHelpSystemOn = new ACRadioButtonItem();

      tsuusyorehabilitationSpecialBathingHelpSystemOn.setText("あり");

      tsuusyorehabilitationSpecialBathingHelpSystemOn.setGroup(getTsuusyorehabilitationSpecialBathingHelpSystem());

      addTsuusyorehabilitationSpecialBathingHelpSystemOn();
    }
    return tsuusyorehabilitationSpecialBathingHelpSystemOn;

  }

  /**
   * 送迎体制ラジオグループを取得します。
   * @return 送迎体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getTsuusyorehabilitationMeetingAndSendingOffSystem(){
    if(tsuusyorehabilitationMeetingAndSendingOffSystem==null){

      tsuusyorehabilitationMeetingAndSendingOffSystem = new ACClearableRadioButtonGroup();

      getTsuusyorehabilitationMeetingAndSendingOffSystemContainer().setText("送迎体制");

      tsuusyorehabilitationMeetingAndSendingOffSystem.setBindPath("1160104");

      tsuusyorehabilitationMeetingAndSendingOffSystem.setModel(getTsuusyorehabilitationMeetingAndSendingOffSystemModel());

      tsuusyorehabilitationMeetingAndSendingOffSystem.setUseClearButton(false);

      addTsuusyorehabilitationMeetingAndSendingOffSystem();
    }
    return tsuusyorehabilitationMeetingAndSendingOffSystem;

  }

  /**
   * 送迎体制ラジオグループコンテナを取得します。
   * @return 送迎体制ラジオグループコンテナ
   */
  protected ACLabelContainer getTsuusyorehabilitationMeetingAndSendingOffSystemContainer(){
    if(tsuusyorehabilitationMeetingAndSendingOffSystemContainer==null){
      tsuusyorehabilitationMeetingAndSendingOffSystemContainer = new ACLabelContainer();
      tsuusyorehabilitationMeetingAndSendingOffSystemContainer.setFollowChildEnabled(true);
      tsuusyorehabilitationMeetingAndSendingOffSystemContainer.add(getTsuusyorehabilitationMeetingAndSendingOffSystem(), null);
    }
    return tsuusyorehabilitationMeetingAndSendingOffSystemContainer;
  }

  /**
   * 送迎体制ラジオグループモデルを取得します。
   * @return 送迎体制ラジオグループモデル
   */
  protected ACListModelAdapter getTsuusyorehabilitationMeetingAndSendingOffSystemModel(){
    if(tsuusyorehabilitationMeetingAndSendingOffSystemModel==null){
      tsuusyorehabilitationMeetingAndSendingOffSystemModel = new ACListModelAdapter();
      addTsuusyorehabilitationMeetingAndSendingOffSystemModel();
    }
    return tsuusyorehabilitationMeetingAndSendingOffSystemModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTsuusyorehabilitationMeetingAndSendingOffSystemOff(){
    if(tsuusyorehabilitationMeetingAndSendingOffSystemOff==null){

      tsuusyorehabilitationMeetingAndSendingOffSystemOff = new ACRadioButtonItem();

      tsuusyorehabilitationMeetingAndSendingOffSystemOff.setText("なし");

      tsuusyorehabilitationMeetingAndSendingOffSystemOff.setGroup(getTsuusyorehabilitationMeetingAndSendingOffSystem());

      addTsuusyorehabilitationMeetingAndSendingOffSystemOff();
    }
    return tsuusyorehabilitationMeetingAndSendingOffSystemOff;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getTsuusyorehabilitationMeetingAndSendingOffSystemOn(){
    if(tsuusyorehabilitationMeetingAndSendingOffSystemOn==null){

      tsuusyorehabilitationMeetingAndSendingOffSystemOn = new ACRadioButtonItem();

      tsuusyorehabilitationMeetingAndSendingOffSystemOn.setText("あり");

      tsuusyorehabilitationMeetingAndSendingOffSystemOn.setGroup(getTsuusyorehabilitationMeetingAndSendingOffSystem());

      addTsuusyorehabilitationMeetingAndSendingOffSystemOn();
    }
    return tsuusyorehabilitationMeetingAndSendingOffSystemOn;

  }

  /**
   * 人員減算ラジオグループを取得します。
   * @return 人員減算ラジオグループ
   */
  public ACClearableRadioButtonGroup getTsuusyorehabilitationStaffReduce(){
    if(tsuusyorehabilitationStaffReduce==null){

      tsuusyorehabilitationStaffReduce = new ACClearableRadioButtonGroup();

      getTsuusyorehabilitationStaffReduceContainer().setText("人員減算");

      tsuusyorehabilitationStaffReduce.setBindPath("1160105");

      tsuusyorehabilitationStaffReduce.setModel(getTsuusyorehabilitationStaffReduceModel());

      tsuusyorehabilitationStaffReduce.setUseClearButton(false);

      addTsuusyorehabilitationStaffReduce();
    }
    return tsuusyorehabilitationStaffReduce;

  }

  /**
   * 人員減算ラジオグループコンテナを取得します。
   * @return 人員減算ラジオグループコンテナ
   */
  protected ACLabelContainer getTsuusyorehabilitationStaffReduceContainer(){
    if(tsuusyorehabilitationStaffReduceContainer==null){
      tsuusyorehabilitationStaffReduceContainer = new ACLabelContainer();
      tsuusyorehabilitationStaffReduceContainer.setFollowChildEnabled(true);
      tsuusyorehabilitationStaffReduceContainer.add(getTsuusyorehabilitationStaffReduce(), null);
    }
    return tsuusyorehabilitationStaffReduceContainer;
  }

  /**
   * 人員減算ラジオグループモデルを取得します。
   * @return 人員減算ラジオグループモデル
   */
  protected ACListModelAdapter getTsuusyorehabilitationStaffReduceModel(){
    if(tsuusyorehabilitationStaffReduceModel==null){
      tsuusyorehabilitationStaffReduceModel = new ACListModelAdapter();
      addTsuusyorehabilitationStaffReduceModel();
    }
    return tsuusyorehabilitationStaffReduceModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTsuusyorehabilitationStaffNot(){
    if(tsuusyorehabilitationStaffNot==null){

      tsuusyorehabilitationStaffNot = new ACRadioButtonItem();

      tsuusyorehabilitationStaffNot.setText("なし");

      tsuusyorehabilitationStaffNot.setGroup(getTsuusyorehabilitationStaffReduce());

      addTsuusyorehabilitationStaffNot();
    }
    return tsuusyorehabilitationStaffNot;

  }

  /**
   * 定員超過を取得します。
   * @return 定員超過
   */
  public ACRadioButtonItem getTsuusyorehabilitationStaffExcess(){
    if(tsuusyorehabilitationStaffExcess==null){

      tsuusyorehabilitationStaffExcess = new ACRadioButtonItem();

      tsuusyorehabilitationStaffExcess.setText("定員超過");

      tsuusyorehabilitationStaffExcess.setGroup(getTsuusyorehabilitationStaffReduce());

      addTsuusyorehabilitationStaffExcess();
    }
    return tsuusyorehabilitationStaffExcess;

  }

  /**
   * 医師、PT・OT・ST、看護・介護職員の不足を取得します。
   * @return 医師、PT・OT・ST、看護・介護職員の不足
   */
  public ACRadioButtonItem getTsuusyorehabilitationMedicalStaffDivision(){
    if(tsuusyorehabilitationMedicalStaffDivision==null){

      tsuusyorehabilitationMedicalStaffDivision = new ACRadioButtonItem();

      tsuusyorehabilitationMedicalStaffDivision.setText("医師、PT・OT・ST、看護・介護職員の不足");

      tsuusyorehabilitationMedicalStaffDivision.setGroup(getTsuusyorehabilitationStaffReduce());

      addTsuusyorehabilitationMedicalStaffDivision();
    }
    return tsuusyorehabilitationMedicalStaffDivision;

  }

  /**
   * コンストラクタです。
   */
  public QO004006Design() {

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

    this.add(getTsuusyorehabilitationGroup(), VRLayout.CLIENT);

  }

  /**
   * 事業グループに内部項目を追加します。
   */
  protected void addTsuusyorehabilitationGroup(){

    tsuusyorehabilitationGroup.add(getTsuusyorehabilitationDiscountContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyorehabilitationGroup.add(getTsuusyorehabilitationFacilitiesDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyorehabilitationGroup.add(getTsuusyorehabilitationBathingHelpSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyorehabilitationGroup.add(getTsuusyorehabilitationSpecialBathingHelpSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyorehabilitationGroup.add(getTsuusyorehabilitationMeetingAndSendingOffSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyorehabilitationGroup.add(getTsuusyorehabilitationStaffReduceContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 割引率コンテナに内部項目を追加します。
   */
  protected void addTsuusyorehabilitationDiscountContena(){

    tsuusyorehabilitationDiscountContena.add(getTsuusyorehabilitationDiscountRate(), VRLayout.FLOW);

    tsuusyorehabilitationDiscountContena.add(getTsuusyorehabilitationPercentSign(), VRLayout.FLOW);

  }

  /**
   * 割引率に内部項目を追加します。
   */
  protected void addTsuusyorehabilitationDiscountRate(){

  }

  /**
   * ％ラベルに内部項目を追加します。
   */
  protected void addTsuusyorehabilitationPercentSign(){

  }

  /**
   * 施設区分ラジオグループに内部項目を追加します。
   */
  protected void addTsuusyorehabilitationFacilitiesDivision(){

  }

  /**
   * 施設区分ラジオグループモデルに内部項目を追加します。
   */
  protected void addTsuusyorehabilitationFacilitiesDivisionModel(){

    getTsuusyorehabilitationNormalFacilities().setButtonIndex(1);
    getTsuusyorehabilitationFacilitiesDivisionModel().add(getTsuusyorehabilitationNormalFacilities());

    getTsuusyorehabilitationSmallFacilities().setButtonIndex(2);
    getTsuusyorehabilitationFacilitiesDivisionModel().add(getTsuusyorehabilitationSmallFacilities());

    getTsuusyorehabilitationEtcFacilities().setButtonIndex(3);
    getTsuusyorehabilitationFacilitiesDivisionModel().add(getTsuusyorehabilitationEtcFacilities());

  }

  /**
   * 通常規模の医療機関に内部項目を追加します。
   */
  protected void addTsuusyorehabilitationNormalFacilities(){

  }

  /**
   * 小規模診療所に内部項目を追加します。
   */
  protected void addTsuusyorehabilitationSmallFacilities(){

  }

  /**
   * 介護老人保健施設に内部項目を追加します。
   */
  protected void addTsuusyorehabilitationEtcFacilities(){

  }

  /**
   * 入浴介助体制ラジオグループに内部項目を追加します。
   */
  protected void addTsuusyorehabilitationBathingHelpSystem(){

  }

  /**
   * 入浴介助体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addTsuusyorehabilitationBathingHelpSystemModel(){

    getTsuusyorehabilitationBathingHelpSystemOff().setButtonIndex(1);
    getTsuusyorehabilitationBathingHelpSystemModel().add(getTsuusyorehabilitationBathingHelpSystemOff());

    getTsuusyorehabilitationBathingHelpSystemOn().setButtonIndex(2);
    getTsuusyorehabilitationBathingHelpSystemModel().add(getTsuusyorehabilitationBathingHelpSystemOn());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTsuusyorehabilitationBathingHelpSystemOff(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addTsuusyorehabilitationBathingHelpSystemOn(){

  }

  /**
   * 特別入浴介助体制ラジオグループに内部項目を追加します。
   */
  protected void addTsuusyorehabilitationSpecialBathingHelpSystem(){

  }

  /**
   * 特別入浴介助体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addTsuusyorehabilitationSpecialBathingHelpSystemModel(){

    getTsuusyorehabilitationSpecialBathingHelpSystemOff().setButtonIndex(1);
    getTsuusyorehabilitationSpecialBathingHelpSystemModel().add(getTsuusyorehabilitationSpecialBathingHelpSystemOff());

    getTsuusyorehabilitationSpecialBathingHelpSystemOn().setButtonIndex(2);
    getTsuusyorehabilitationSpecialBathingHelpSystemModel().add(getTsuusyorehabilitationSpecialBathingHelpSystemOn());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTsuusyorehabilitationSpecialBathingHelpSystemOff(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addTsuusyorehabilitationSpecialBathingHelpSystemOn(){

  }

  /**
   * 送迎体制ラジオグループに内部項目を追加します。
   */
  protected void addTsuusyorehabilitationMeetingAndSendingOffSystem(){

  }

  /**
   * 送迎体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addTsuusyorehabilitationMeetingAndSendingOffSystemModel(){

    getTsuusyorehabilitationMeetingAndSendingOffSystemOff().setButtonIndex(1);
    getTsuusyorehabilitationMeetingAndSendingOffSystemModel().add(getTsuusyorehabilitationMeetingAndSendingOffSystemOff());

    getTsuusyorehabilitationMeetingAndSendingOffSystemOn().setButtonIndex(2);
    getTsuusyorehabilitationMeetingAndSendingOffSystemModel().add(getTsuusyorehabilitationMeetingAndSendingOffSystemOn());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTsuusyorehabilitationMeetingAndSendingOffSystemOff(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addTsuusyorehabilitationMeetingAndSendingOffSystemOn(){

  }

  /**
   * 人員減算ラジオグループに内部項目を追加します。
   */
  protected void addTsuusyorehabilitationStaffReduce(){

  }

  /**
   * 人員減算ラジオグループモデルに内部項目を追加します。
   */
  protected void addTsuusyorehabilitationStaffReduceModel(){

    getTsuusyorehabilitationStaffNot().setButtonIndex(1);
    getTsuusyorehabilitationStaffReduceModel().add(getTsuusyorehabilitationStaffNot());

    getTsuusyorehabilitationStaffExcess().setButtonIndex(2);
    getTsuusyorehabilitationStaffReduceModel().add(getTsuusyorehabilitationStaffExcess());

    getTsuusyorehabilitationMedicalStaffDivision().setButtonIndex(3);
    getTsuusyorehabilitationStaffReduceModel().add(getTsuusyorehabilitationMedicalStaffDivision());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTsuusyorehabilitationStaffNot(){

  }

  /**
   * 定員超過に内部項目を追加します。
   */
  protected void addTsuusyorehabilitationStaffExcess(){

  }

  /**
   * 医師、PT・OT・ST、看護・介護職員の不足に内部項目を追加します。
   */
  protected void addTsuusyorehabilitationMedicalStaffDivision(){

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
      ACFrame.getInstance().getContentPane().add(new QO004006Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004006Design getThis() {
    return this;
  }
}
