
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
 * プログラム 通所介護 (QO004005)
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
 * 通所介護画面項目デザイン(QO004005) 
 */
public class QO004005Design extends ACPanel {
  //GUIコンポーネント

  private ACGroupBox tsuusyokaigoGroup;

  private ACLabelContainer tsuusyokaigoDiscountContena;

  private ACTextField tsuusyokaigoDiscountRate;

  private ACLabel tsuusyokaigotSign;

  private ACClearableRadioButtonGroup tsuusyokaigoFacilitiesDivision;

  private ACLabelContainer tsuusyokaigoFacilitiesDivisionContainer;

  private ACListModelAdapter tsuusyokaigoFacilitiesDivisionModel;

  private ACRadioButtonItem tsuusyokaigoSingle;

  private ACRadioButtonItem tsuusyokaigoDouble;

  private ACRadioButtonItem tsuusyokaigoDementiaSingle;

  private ACRadioButtonItem tsuusyokaigoDementiaDouble;

  private ACClearableRadioButtonGroup tsuusyokaigoFunctionTrainingGuidanceSystem;

  private ACLabelContainer tsuusyokaigoFunctionTrainingGuidanceSystemContainer;

  private ACListModelAdapter tsuusyokaigoFunctionTrainingGuidanceSystemModel;

  private ACRadioButtonItem tsuusyokaigoFunctionTrainingGuidanceSystemOff;

  private ACRadioButtonItem tsuusyokaigoFunctionTrainingGuidanceSystemOn;

  private ACClearableRadioButtonGroup tsuusyokaigoBathingHelpSystem;

  private ACLabelContainer tsuusyokaigoBathingHelpSystemContainer;

  private ACListModelAdapter tsuusyokaigoBathingHelpSystemModel;

  private ACRadioButtonItem tsuusyokaigoBathingHelpSystemOff;

  private ACRadioButtonItem tsuusyokaigoBathingHelpSystemOn;

  private ACClearableRadioButtonGroup tsuusyokaigoSpecialBathingHelpSystem;

  private ACLabelContainer tsuusyokaigoSpecialBathingHelpSystemContainer;

  private ACListModelAdapter tsuusyokaigoSpecialBathingHelpSystemModel;

  private ACRadioButtonItem tsuusyokaigoSpecialBathingHelpSystemOff;

  private ACRadioButtonItem tsuusyokaigoSpecialBathingHelpSystemOn;

  private ACClearableRadioButtonGroup tsuusyokaigoMeetingAndSendingOffSystem;

  private ACLabelContainer tsuusyokaigoMeetingAndSendingOffSystemContainer;

  private ACListModelAdapter tsuusyokaigoMeetingAndSendingOffSystemModel;

  private ACRadioButtonItem tsuusyokaigoMeetingAndSendingOffSystemOff;

  private ACRadioButtonItem tsuusyokaigoMeetingAndSendingOffSystemOn;

  private ACClearableRadioButtonGroup tsuusyokaigoStaffRadio;

  private ACLabelContainer tsuusyokaigoStaffRadioContainer;

  private ACListModelAdapter tsuusyokaigoStaffRadioModel;

  private ACRadioButtonItem tsuusyokaigoStaffNot;

  private ACRadioButtonItem tsuusyokaigoStaffReduce;

  private ACRadioButtonItem tsuusyokaigoStaffShortage;

  //getter

  /**
   * 事業グループを取得します。
   * @return 事業グループ
   */
  public ACGroupBox getTsuusyokaigoGroup(){
    if(tsuusyokaigoGroup==null){

      tsuusyokaigoGroup = new ACGroupBox();

      tsuusyokaigoGroup.setText("通所介護");

      tsuusyokaigoGroup.setFollowChildEnabled(true);

      tsuusyokaigoGroup.setHgrid(200);

      addTsuusyokaigoGroup();
    }
    return tsuusyokaigoGroup;

  }

  /**
   * 割引率コンテナを取得します。
   * @return 割引率コンテナ
   */
  public ACLabelContainer getTsuusyokaigoDiscountContena(){
    if(tsuusyokaigoDiscountContena==null){

      tsuusyokaigoDiscountContena = new ACLabelContainer();

      tsuusyokaigoDiscountContena.setText("割引率");

      tsuusyokaigoDiscountContena.setFollowChildEnabled(true);

      addTsuusyokaigoDiscountContena();
    }
    return tsuusyokaigoDiscountContena;

  }

  /**
   * 割引率を取得します。
   * @return 割引率
   */
  public ACTextField getTsuusyokaigoDiscountRate(){
    if(tsuusyokaigoDiscountRate==null){

      tsuusyokaigoDiscountRate = new ACTextField();

      tsuusyokaigoDiscountRate.setBindPath("REDUCT_RATE");

      tsuusyokaigoDiscountRate.setColumns(3);

      tsuusyokaigoDiscountRate.setCharType(VRCharType.ONLY_DIGIT);

      tsuusyokaigoDiscountRate.setHorizontalAlignment(SwingConstants.RIGHT);

      tsuusyokaigoDiscountRate.setIMEMode(InputSubset.LATIN);

      tsuusyokaigoDiscountRate.setMaxLength(3);

      addTsuusyokaigoDiscountRate();
    }
    return tsuusyokaigoDiscountRate;

  }

  /**
   * ％ラベルを取得します。
   * @return ％ラベル
   */
  public ACLabel getTsuusyokaigotSign(){
    if(tsuusyokaigotSign==null){

      tsuusyokaigotSign = new ACLabel();

      tsuusyokaigotSign.setText("％");

      addTsuusyokaigotSign();
    }
    return tsuusyokaigotSign;

  }

  /**
   * 施設区分ラジオグループを取得します。
   * @return 施設区分ラジオグループ
   */
  public ACClearableRadioButtonGroup getTsuusyokaigoFacilitiesDivision(){
    if(tsuusyokaigoFacilitiesDivision==null){

      tsuusyokaigoFacilitiesDivision = new ACClearableRadioButtonGroup();

      getTsuusyokaigoFacilitiesDivisionContainer().setText("施設区分");

      tsuusyokaigoFacilitiesDivision.setBindPath("1150101");

      tsuusyokaigoFacilitiesDivision.setModel(getTsuusyokaigoFacilitiesDivisionModel());

      tsuusyokaigoFacilitiesDivision.setUseClearButton(false);

      addTsuusyokaigoFacilitiesDivision();
    }
    return tsuusyokaigoFacilitiesDivision;

  }

  /**
   * 施設区分ラジオグループコンテナを取得します。
   * @return 施設区分ラジオグループコンテナ
   */
  protected ACLabelContainer getTsuusyokaigoFacilitiesDivisionContainer(){
    if(tsuusyokaigoFacilitiesDivisionContainer==null){
      tsuusyokaigoFacilitiesDivisionContainer = new ACLabelContainer();
      tsuusyokaigoFacilitiesDivisionContainer.setFollowChildEnabled(true);
      tsuusyokaigoFacilitiesDivisionContainer.add(getTsuusyokaigoFacilitiesDivision(), null);
    }
    return tsuusyokaigoFacilitiesDivisionContainer;
  }

  /**
   * 施設区分ラジオグループモデルを取得します。
   * @return 施設区分ラジオグループモデル
   */
  protected ACListModelAdapter getTsuusyokaigoFacilitiesDivisionModel(){
    if(tsuusyokaigoFacilitiesDivisionModel==null){
      tsuusyokaigoFacilitiesDivisionModel = new ACListModelAdapter();
      addTsuusyokaigoFacilitiesDivisionModel();
    }
    return tsuusyokaigoFacilitiesDivisionModel;
  }

  /**
   * 単独型を取得します。
   * @return 単独型
   */
  public ACRadioButtonItem getTsuusyokaigoSingle(){
    if(tsuusyokaigoSingle==null){

      tsuusyokaigoSingle = new ACRadioButtonItem();

      tsuusyokaigoSingle.setText("単独型");

      tsuusyokaigoSingle.setGroup(getTsuusyokaigoFacilitiesDivision());

      addTsuusyokaigoSingle();
    }
    return tsuusyokaigoSingle;

  }

  /**
   * 併設型を取得します。
   * @return 併設型
   */
  public ACRadioButtonItem getTsuusyokaigoDouble(){
    if(tsuusyokaigoDouble==null){

      tsuusyokaigoDouble = new ACRadioButtonItem();

      tsuusyokaigoDouble.setText("併設型");

      tsuusyokaigoDouble.setGroup(getTsuusyokaigoFacilitiesDivision());

      addTsuusyokaigoDouble();
    }
    return tsuusyokaigoDouble;

  }

  /**
   * 認知症専用単独型を取得します。
   * @return 認知症専用単独型
   */
  public ACRadioButtonItem getTsuusyokaigoDementiaSingle(){
    if(tsuusyokaigoDementiaSingle==null){

      tsuusyokaigoDementiaSingle = new ACRadioButtonItem();

      tsuusyokaigoDementiaSingle.setText("認知症専用単独型");

      tsuusyokaigoDementiaSingle.setGroup(getTsuusyokaigoFacilitiesDivision());

      addTsuusyokaigoDementiaSingle();
    }
    return tsuusyokaigoDementiaSingle;

  }

  /**
   * 認知症専用併設型を取得します。
   * @return 認知症専用併設型
   */
  public ACRadioButtonItem getTsuusyokaigoDementiaDouble(){
    if(tsuusyokaigoDementiaDouble==null){

      tsuusyokaigoDementiaDouble = new ACRadioButtonItem();

      tsuusyokaigoDementiaDouble.setText("認知症専用併設型");

      tsuusyokaigoDementiaDouble.setGroup(getTsuusyokaigoFacilitiesDivision());

      addTsuusyokaigoDementiaDouble();
    }
    return tsuusyokaigoDementiaDouble;

  }

  /**
   * 機能訓練指導体制ラジオグループを取得します。
   * @return 機能訓練指導体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getTsuusyokaigoFunctionTrainingGuidanceSystem(){
    if(tsuusyokaigoFunctionTrainingGuidanceSystem==null){

      tsuusyokaigoFunctionTrainingGuidanceSystem = new ACClearableRadioButtonGroup();

      getTsuusyokaigoFunctionTrainingGuidanceSystemContainer().setText("機能訓練指導体制");

      tsuusyokaigoFunctionTrainingGuidanceSystem.setBindPath("1150102");

      tsuusyokaigoFunctionTrainingGuidanceSystem.setModel(getTsuusyokaigoFunctionTrainingGuidanceSystemModel());

      tsuusyokaigoFunctionTrainingGuidanceSystem.setUseClearButton(false);

      addTsuusyokaigoFunctionTrainingGuidanceSystem();
    }
    return tsuusyokaigoFunctionTrainingGuidanceSystem;

  }

  /**
   * 機能訓練指導体制ラジオグループコンテナを取得します。
   * @return 機能訓練指導体制ラジオグループコンテナ
   */
  protected ACLabelContainer getTsuusyokaigoFunctionTrainingGuidanceSystemContainer(){
    if(tsuusyokaigoFunctionTrainingGuidanceSystemContainer==null){
      tsuusyokaigoFunctionTrainingGuidanceSystemContainer = new ACLabelContainer();
      tsuusyokaigoFunctionTrainingGuidanceSystemContainer.setFollowChildEnabled(true);
      tsuusyokaigoFunctionTrainingGuidanceSystemContainer.add(getTsuusyokaigoFunctionTrainingGuidanceSystem(), null);
    }
    return tsuusyokaigoFunctionTrainingGuidanceSystemContainer;
  }

  /**
   * 機能訓練指導体制ラジオグループモデルを取得します。
   * @return 機能訓練指導体制ラジオグループモデル
   */
  protected ACListModelAdapter getTsuusyokaigoFunctionTrainingGuidanceSystemModel(){
    if(tsuusyokaigoFunctionTrainingGuidanceSystemModel==null){
      tsuusyokaigoFunctionTrainingGuidanceSystemModel = new ACListModelAdapter();
      addTsuusyokaigoFunctionTrainingGuidanceSystemModel();
    }
    return tsuusyokaigoFunctionTrainingGuidanceSystemModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTsuusyokaigoFunctionTrainingGuidanceSystemOff(){
    if(tsuusyokaigoFunctionTrainingGuidanceSystemOff==null){

      tsuusyokaigoFunctionTrainingGuidanceSystemOff = new ACRadioButtonItem();

      tsuusyokaigoFunctionTrainingGuidanceSystemOff.setText("なし");

      tsuusyokaigoFunctionTrainingGuidanceSystemOff.setGroup(getTsuusyokaigoFunctionTrainingGuidanceSystem());

      addTsuusyokaigoFunctionTrainingGuidanceSystemOff();
    }
    return tsuusyokaigoFunctionTrainingGuidanceSystemOff;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getTsuusyokaigoFunctionTrainingGuidanceSystemOn(){
    if(tsuusyokaigoFunctionTrainingGuidanceSystemOn==null){

      tsuusyokaigoFunctionTrainingGuidanceSystemOn = new ACRadioButtonItem();

      tsuusyokaigoFunctionTrainingGuidanceSystemOn.setText("あり");

      tsuusyokaigoFunctionTrainingGuidanceSystemOn.setGroup(getTsuusyokaigoFunctionTrainingGuidanceSystem());

      addTsuusyokaigoFunctionTrainingGuidanceSystemOn();
    }
    return tsuusyokaigoFunctionTrainingGuidanceSystemOn;

  }

  /**
   * 入浴介助体制ラジオグループを取得します。
   * @return 入浴介助体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getTsuusyokaigoBathingHelpSystem(){
    if(tsuusyokaigoBathingHelpSystem==null){

      tsuusyokaigoBathingHelpSystem = new ACClearableRadioButtonGroup();

      getTsuusyokaigoBathingHelpSystemContainer().setText("入浴介助体制");

      tsuusyokaigoBathingHelpSystem.setBindPath("1150103");

      tsuusyokaigoBathingHelpSystem.setModel(getTsuusyokaigoBathingHelpSystemModel());

      tsuusyokaigoBathingHelpSystem.setUseClearButton(false);

      addTsuusyokaigoBathingHelpSystem();
    }
    return tsuusyokaigoBathingHelpSystem;

  }

  /**
   * 入浴介助体制ラジオグループコンテナを取得します。
   * @return 入浴介助体制ラジオグループコンテナ
   */
  protected ACLabelContainer getTsuusyokaigoBathingHelpSystemContainer(){
    if(tsuusyokaigoBathingHelpSystemContainer==null){
      tsuusyokaigoBathingHelpSystemContainer = new ACLabelContainer();
      tsuusyokaigoBathingHelpSystemContainer.setFollowChildEnabled(true);
      tsuusyokaigoBathingHelpSystemContainer.add(getTsuusyokaigoBathingHelpSystem(), null);
    }
    return tsuusyokaigoBathingHelpSystemContainer;
  }

  /**
   * 入浴介助体制ラジオグループモデルを取得します。
   * @return 入浴介助体制ラジオグループモデル
   */
  protected ACListModelAdapter getTsuusyokaigoBathingHelpSystemModel(){
    if(tsuusyokaigoBathingHelpSystemModel==null){
      tsuusyokaigoBathingHelpSystemModel = new ACListModelAdapter();
      addTsuusyokaigoBathingHelpSystemModel();
    }
    return tsuusyokaigoBathingHelpSystemModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTsuusyokaigoBathingHelpSystemOff(){
    if(tsuusyokaigoBathingHelpSystemOff==null){

      tsuusyokaigoBathingHelpSystemOff = new ACRadioButtonItem();

      tsuusyokaigoBathingHelpSystemOff.setText("なし");

      tsuusyokaigoBathingHelpSystemOff.setGroup(getTsuusyokaigoBathingHelpSystem());

      addTsuusyokaigoBathingHelpSystemOff();
    }
    return tsuusyokaigoBathingHelpSystemOff;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getTsuusyokaigoBathingHelpSystemOn(){
    if(tsuusyokaigoBathingHelpSystemOn==null){

      tsuusyokaigoBathingHelpSystemOn = new ACRadioButtonItem();

      tsuusyokaigoBathingHelpSystemOn.setText("あり");

      tsuusyokaigoBathingHelpSystemOn.setGroup(getTsuusyokaigoBathingHelpSystem());

      addTsuusyokaigoBathingHelpSystemOn();
    }
    return tsuusyokaigoBathingHelpSystemOn;

  }

  /**
   * 特別入浴介助体制ラジオグループを取得します。
   * @return 特別入浴介助体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getTsuusyokaigoSpecialBathingHelpSystem(){
    if(tsuusyokaigoSpecialBathingHelpSystem==null){

      tsuusyokaigoSpecialBathingHelpSystem = new ACClearableRadioButtonGroup();

      getTsuusyokaigoSpecialBathingHelpSystemContainer().setText("特別入浴介助体制");

      tsuusyokaigoSpecialBathingHelpSystem.setBindPath("1150104");

      tsuusyokaigoSpecialBathingHelpSystem.setModel(getTsuusyokaigoSpecialBathingHelpSystemModel());

      tsuusyokaigoSpecialBathingHelpSystem.setUseClearButton(false);

      addTsuusyokaigoSpecialBathingHelpSystem();
    }
    return tsuusyokaigoSpecialBathingHelpSystem;

  }

  /**
   * 特別入浴介助体制ラジオグループコンテナを取得します。
   * @return 特別入浴介助体制ラジオグループコンテナ
   */
  protected ACLabelContainer getTsuusyokaigoSpecialBathingHelpSystemContainer(){
    if(tsuusyokaigoSpecialBathingHelpSystemContainer==null){
      tsuusyokaigoSpecialBathingHelpSystemContainer = new ACLabelContainer();
      tsuusyokaigoSpecialBathingHelpSystemContainer.setFollowChildEnabled(true);
      tsuusyokaigoSpecialBathingHelpSystemContainer.add(getTsuusyokaigoSpecialBathingHelpSystem(), null);
    }
    return tsuusyokaigoSpecialBathingHelpSystemContainer;
  }

  /**
   * 特別入浴介助体制ラジオグループモデルを取得します。
   * @return 特別入浴介助体制ラジオグループモデル
   */
  protected ACListModelAdapter getTsuusyokaigoSpecialBathingHelpSystemModel(){
    if(tsuusyokaigoSpecialBathingHelpSystemModel==null){
      tsuusyokaigoSpecialBathingHelpSystemModel = new ACListModelAdapter();
      addTsuusyokaigoSpecialBathingHelpSystemModel();
    }
    return tsuusyokaigoSpecialBathingHelpSystemModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTsuusyokaigoSpecialBathingHelpSystemOff(){
    if(tsuusyokaigoSpecialBathingHelpSystemOff==null){

      tsuusyokaigoSpecialBathingHelpSystemOff = new ACRadioButtonItem();

      tsuusyokaigoSpecialBathingHelpSystemOff.setText("なし");

      tsuusyokaigoSpecialBathingHelpSystemOff.setGroup(getTsuusyokaigoSpecialBathingHelpSystem());

      addTsuusyokaigoSpecialBathingHelpSystemOff();
    }
    return tsuusyokaigoSpecialBathingHelpSystemOff;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getTsuusyokaigoSpecialBathingHelpSystemOn(){
    if(tsuusyokaigoSpecialBathingHelpSystemOn==null){

      tsuusyokaigoSpecialBathingHelpSystemOn = new ACRadioButtonItem();

      tsuusyokaigoSpecialBathingHelpSystemOn.setText("あり");

      tsuusyokaigoSpecialBathingHelpSystemOn.setGroup(getTsuusyokaigoSpecialBathingHelpSystem());

      addTsuusyokaigoSpecialBathingHelpSystemOn();
    }
    return tsuusyokaigoSpecialBathingHelpSystemOn;

  }

  /**
   * 送迎体制ラジオグループを取得します。
   * @return 送迎体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getTsuusyokaigoMeetingAndSendingOffSystem(){
    if(tsuusyokaigoMeetingAndSendingOffSystem==null){

      tsuusyokaigoMeetingAndSendingOffSystem = new ACClearableRadioButtonGroup();

      getTsuusyokaigoMeetingAndSendingOffSystemContainer().setText("送迎体制");

      tsuusyokaigoMeetingAndSendingOffSystem.setBindPath("1150105");

      tsuusyokaigoMeetingAndSendingOffSystem.setModel(getTsuusyokaigoMeetingAndSendingOffSystemModel());

      tsuusyokaigoMeetingAndSendingOffSystem.setUseClearButton(false);

      addTsuusyokaigoMeetingAndSendingOffSystem();
    }
    return tsuusyokaigoMeetingAndSendingOffSystem;

  }

  /**
   * 送迎体制ラジオグループコンテナを取得します。
   * @return 送迎体制ラジオグループコンテナ
   */
  protected ACLabelContainer getTsuusyokaigoMeetingAndSendingOffSystemContainer(){
    if(tsuusyokaigoMeetingAndSendingOffSystemContainer==null){
      tsuusyokaigoMeetingAndSendingOffSystemContainer = new ACLabelContainer();
      tsuusyokaigoMeetingAndSendingOffSystemContainer.setFollowChildEnabled(true);
      tsuusyokaigoMeetingAndSendingOffSystemContainer.add(getTsuusyokaigoMeetingAndSendingOffSystem(), null);
    }
    return tsuusyokaigoMeetingAndSendingOffSystemContainer;
  }

  /**
   * 送迎体制ラジオグループモデルを取得します。
   * @return 送迎体制ラジオグループモデル
   */
  protected ACListModelAdapter getTsuusyokaigoMeetingAndSendingOffSystemModel(){
    if(tsuusyokaigoMeetingAndSendingOffSystemModel==null){
      tsuusyokaigoMeetingAndSendingOffSystemModel = new ACListModelAdapter();
      addTsuusyokaigoMeetingAndSendingOffSystemModel();
    }
    return tsuusyokaigoMeetingAndSendingOffSystemModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTsuusyokaigoMeetingAndSendingOffSystemOff(){
    if(tsuusyokaigoMeetingAndSendingOffSystemOff==null){

      tsuusyokaigoMeetingAndSendingOffSystemOff = new ACRadioButtonItem();

      tsuusyokaigoMeetingAndSendingOffSystemOff.setText("なし");

      tsuusyokaigoMeetingAndSendingOffSystemOff.setGroup(getTsuusyokaigoMeetingAndSendingOffSystem());

      addTsuusyokaigoMeetingAndSendingOffSystemOff();
    }
    return tsuusyokaigoMeetingAndSendingOffSystemOff;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getTsuusyokaigoMeetingAndSendingOffSystemOn(){
    if(tsuusyokaigoMeetingAndSendingOffSystemOn==null){

      tsuusyokaigoMeetingAndSendingOffSystemOn = new ACRadioButtonItem();

      tsuusyokaigoMeetingAndSendingOffSystemOn.setText("あり");

      tsuusyokaigoMeetingAndSendingOffSystemOn.setGroup(getTsuusyokaigoMeetingAndSendingOffSystem());

      addTsuusyokaigoMeetingAndSendingOffSystemOn();
    }
    return tsuusyokaigoMeetingAndSendingOffSystemOn;

  }

  /**
   * 人員減算ラジオグループを取得します。
   * @return 人員減算ラジオグループ
   */
  public ACClearableRadioButtonGroup getTsuusyokaigoStaffRadio(){
    if(tsuusyokaigoStaffRadio==null){

      tsuusyokaigoStaffRadio = new ACClearableRadioButtonGroup();

      getTsuusyokaigoStaffRadioContainer().setText("人員減算");

      tsuusyokaigoStaffRadio.setBindPath("1150106");

      tsuusyokaigoStaffRadio.setModel(getTsuusyokaigoStaffRadioModel());

      tsuusyokaigoStaffRadio.setUseClearButton(false);

      addTsuusyokaigoStaffRadio();
    }
    return tsuusyokaigoStaffRadio;

  }

  /**
   * 人員減算ラジオグループコンテナを取得します。
   * @return 人員減算ラジオグループコンテナ
   */
  protected ACLabelContainer getTsuusyokaigoStaffRadioContainer(){
    if(tsuusyokaigoStaffRadioContainer==null){
      tsuusyokaigoStaffRadioContainer = new ACLabelContainer();
      tsuusyokaigoStaffRadioContainer.setFollowChildEnabled(true);
      tsuusyokaigoStaffRadioContainer.add(getTsuusyokaigoStaffRadio(), null);
    }
    return tsuusyokaigoStaffRadioContainer;
  }

  /**
   * 人員減算ラジオグループモデルを取得します。
   * @return 人員減算ラジオグループモデル
   */
  protected ACListModelAdapter getTsuusyokaigoStaffRadioModel(){
    if(tsuusyokaigoStaffRadioModel==null){
      tsuusyokaigoStaffRadioModel = new ACListModelAdapter();
      addTsuusyokaigoStaffRadioModel();
    }
    return tsuusyokaigoStaffRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTsuusyokaigoStaffNot(){
    if(tsuusyokaigoStaffNot==null){

      tsuusyokaigoStaffNot = new ACRadioButtonItem();

      tsuusyokaigoStaffNot.setText("なし");

      tsuusyokaigoStaffNot.setGroup(getTsuusyokaigoStaffRadio());

      addTsuusyokaigoStaffNot();
    }
    return tsuusyokaigoStaffNot;

  }

  /**
   * 定員超過を取得します。
   * @return 定員超過
   */
  public ACRadioButtonItem getTsuusyokaigoStaffReduce(){
    if(tsuusyokaigoStaffReduce==null){

      tsuusyokaigoStaffReduce = new ACRadioButtonItem();

      tsuusyokaigoStaffReduce.setText("定員超過");

      tsuusyokaigoStaffReduce.setGroup(getTsuusyokaigoStaffRadio());

      addTsuusyokaigoStaffReduce();
    }
    return tsuusyokaigoStaffReduce;

  }

  /**
   * 看護、介護職員の不足を取得します。
   * @return 看護、介護職員の不足
   */
  public ACRadioButtonItem getTsuusyokaigoStaffShortage(){
    if(tsuusyokaigoStaffShortage==null){

      tsuusyokaigoStaffShortage = new ACRadioButtonItem();

      tsuusyokaigoStaffShortage.setText("看護・介護職員の不足");

      tsuusyokaigoStaffShortage.setGroup(getTsuusyokaigoStaffRadio());

      addTsuusyokaigoStaffShortage();
    }
    return tsuusyokaigoStaffShortage;

  }

  /**
   * コンストラクタです。
   */
  public QO004005Design() {

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

    this.add(getTsuusyokaigoGroup(), VRLayout.CLIENT);

  }

  /**
   * 事業グループに内部項目を追加します。
   */
  protected void addTsuusyokaigoGroup(){

    tsuusyokaigoGroup.add(getTsuusyokaigoDiscountContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyokaigoGroup.add(getTsuusyokaigoFacilitiesDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyokaigoGroup.add(getTsuusyokaigoFunctionTrainingGuidanceSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyokaigoGroup.add(getTsuusyokaigoBathingHelpSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyokaigoGroup.add(getTsuusyokaigoSpecialBathingHelpSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyokaigoGroup.add(getTsuusyokaigoMeetingAndSendingOffSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyokaigoGroup.add(getTsuusyokaigoStaffRadioContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 割引率コンテナに内部項目を追加します。
   */
  protected void addTsuusyokaigoDiscountContena(){

    tsuusyokaigoDiscountContena.add(getTsuusyokaigoDiscountRate(), VRLayout.FLOW);

    tsuusyokaigoDiscountContena.add(getTsuusyokaigotSign(), VRLayout.FLOW);

  }

  /**
   * 割引率に内部項目を追加します。
   */
  protected void addTsuusyokaigoDiscountRate(){

  }

  /**
   * ％ラベルに内部項目を追加します。
   */
  protected void addTsuusyokaigotSign(){

  }

  /**
   * 施設区分ラジオグループに内部項目を追加します。
   */
  protected void addTsuusyokaigoFacilitiesDivision(){

  }

  /**
   * 施設区分ラジオグループモデルに内部項目を追加します。
   */
  protected void addTsuusyokaigoFacilitiesDivisionModel(){

    getTsuusyokaigoSingle().setButtonIndex(1);
    getTsuusyokaigoFacilitiesDivisionModel().add(getTsuusyokaigoSingle());

    getTsuusyokaigoDouble().setButtonIndex(2);
    getTsuusyokaigoFacilitiesDivisionModel().add(getTsuusyokaigoDouble());

    getTsuusyokaigoDementiaSingle().setButtonIndex(3);
    getTsuusyokaigoFacilitiesDivisionModel().add(getTsuusyokaigoDementiaSingle());

    getTsuusyokaigoDementiaDouble().setButtonIndex(4);
    getTsuusyokaigoFacilitiesDivisionModel().add(getTsuusyokaigoDementiaDouble());

  }

  /**
   * 単独型に内部項目を追加します。
   */
  protected void addTsuusyokaigoSingle(){

  }

  /**
   * 併設型に内部項目を追加します。
   */
  protected void addTsuusyokaigoDouble(){

  }

  /**
   * 認知症専用単独型に内部項目を追加します。
   */
  protected void addTsuusyokaigoDementiaSingle(){

  }

  /**
   * 認知症専用併設型に内部項目を追加します。
   */
  protected void addTsuusyokaigoDementiaDouble(){

  }

  /**
   * 機能訓練指導体制ラジオグループに内部項目を追加します。
   */
  protected void addTsuusyokaigoFunctionTrainingGuidanceSystem(){

  }

  /**
   * 機能訓練指導体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addTsuusyokaigoFunctionTrainingGuidanceSystemModel(){

    getTsuusyokaigoFunctionTrainingGuidanceSystemOff().setButtonIndex(1);
    getTsuusyokaigoFunctionTrainingGuidanceSystemModel().add(getTsuusyokaigoFunctionTrainingGuidanceSystemOff());

    getTsuusyokaigoFunctionTrainingGuidanceSystemOn().setButtonIndex(2);
    getTsuusyokaigoFunctionTrainingGuidanceSystemModel().add(getTsuusyokaigoFunctionTrainingGuidanceSystemOn());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTsuusyokaigoFunctionTrainingGuidanceSystemOff(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addTsuusyokaigoFunctionTrainingGuidanceSystemOn(){

  }

  /**
   * 入浴介助体制ラジオグループに内部項目を追加します。
   */
  protected void addTsuusyokaigoBathingHelpSystem(){

  }

  /**
   * 入浴介助体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addTsuusyokaigoBathingHelpSystemModel(){

    getTsuusyokaigoBathingHelpSystemOff().setButtonIndex(1);
    getTsuusyokaigoBathingHelpSystemModel().add(getTsuusyokaigoBathingHelpSystemOff());

    getTsuusyokaigoBathingHelpSystemOn().setButtonIndex(2);
    getTsuusyokaigoBathingHelpSystemModel().add(getTsuusyokaigoBathingHelpSystemOn());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTsuusyokaigoBathingHelpSystemOff(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addTsuusyokaigoBathingHelpSystemOn(){

  }

  /**
   * 特別入浴介助体制ラジオグループに内部項目を追加します。
   */
  protected void addTsuusyokaigoSpecialBathingHelpSystem(){

  }

  /**
   * 特別入浴介助体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addTsuusyokaigoSpecialBathingHelpSystemModel(){

    getTsuusyokaigoSpecialBathingHelpSystemOff().setButtonIndex(1);
    getTsuusyokaigoSpecialBathingHelpSystemModel().add(getTsuusyokaigoSpecialBathingHelpSystemOff());

    getTsuusyokaigoSpecialBathingHelpSystemOn().setButtonIndex(2);
    getTsuusyokaigoSpecialBathingHelpSystemModel().add(getTsuusyokaigoSpecialBathingHelpSystemOn());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTsuusyokaigoSpecialBathingHelpSystemOff(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addTsuusyokaigoSpecialBathingHelpSystemOn(){

  }

  /**
   * 送迎体制ラジオグループに内部項目を追加します。
   */
  protected void addTsuusyokaigoMeetingAndSendingOffSystem(){

  }

  /**
   * 送迎体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addTsuusyokaigoMeetingAndSendingOffSystemModel(){

    getTsuusyokaigoMeetingAndSendingOffSystemOff().setButtonIndex(1);
    getTsuusyokaigoMeetingAndSendingOffSystemModel().add(getTsuusyokaigoMeetingAndSendingOffSystemOff());

    getTsuusyokaigoMeetingAndSendingOffSystemOn().setButtonIndex(2);
    getTsuusyokaigoMeetingAndSendingOffSystemModel().add(getTsuusyokaigoMeetingAndSendingOffSystemOn());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTsuusyokaigoMeetingAndSendingOffSystemOff(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addTsuusyokaigoMeetingAndSendingOffSystemOn(){

  }

  /**
   * 人員減算ラジオグループに内部項目を追加します。
   */
  protected void addTsuusyokaigoStaffRadio(){

  }

  /**
   * 人員減算ラジオグループモデルに内部項目を追加します。
   */
  protected void addTsuusyokaigoStaffRadioModel(){

    getTsuusyokaigoStaffNot().setButtonIndex(1);
    getTsuusyokaigoStaffRadioModel().add(getTsuusyokaigoStaffNot());

    getTsuusyokaigoStaffReduce().setButtonIndex(2);
    getTsuusyokaigoStaffRadioModel().add(getTsuusyokaigoStaffReduce());

    getTsuusyokaigoStaffShortage().setButtonIndex(3);
    getTsuusyokaigoStaffRadioModel().add(getTsuusyokaigoStaffShortage());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTsuusyokaigoStaffNot(){

  }

  /**
   * 定員超過に内部項目を追加します。
   */
  protected void addTsuusyokaigoStaffReduce(){

  }

  /**
   * 看護、介護職員の不足に内部項目を追加します。
   */
  protected void addTsuusyokaigoStaffShortage(){

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
      ACFrame.getInstance().getContentPane().add(new QO004005Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004005Design getThis() {
    return this;
  }
}
