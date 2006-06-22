
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
 * 作成日: 2006/02/14  日本コンピューター株式会社 小笠　貴志 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン通所介護 (QS001008)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Component;

import jp.nichicom.ac.component.ACClearableRadioButtonGroup;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACRadioButtonItem;
import jp.nichicom.ac.component.ACTimeComboBox;
import jp.nichicom.ac.container.ACBackLabelContainer;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACComboBoxModelAdapter;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
/**
 * サービスパターン通所介護画面項目デザイン(QS001008) 
 */
public class QS001008Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACPanel tsuusyoKaigoPatterns;

  private ACBackLabelContainer tsuusyoKaigoTimeContena;

  private ACTimeComboBox tsuusyoKaigoTimeBeginTime;

  private ACLabelContainer tsuusyoKaigoTimeBeginTimeContainer;

  private ACComboBoxModelAdapter tsuusyoKaigoTimeBeginTimeModel;

  private ACTimeComboBox tsuusyoKaigoTimeEndTime;

  private ACLabelContainer tsuusyoKaigoTimeEndTimeContainer;

  private ACComboBoxModelAdapter tsuusyoKaigoTimeEndTimeModel;

  private ACClearableRadioButtonGroup tsuusyoKaigoTimeContenaFacilityDivision;

  private ACLabelContainer tsuusyoKaigoTimeContenaFacilityDivisionContainer;

  private ACListModelAdapter tsuusyoKaigoTimeContenaFacilityDivisionModel;

  private ACRadioButtonItem tsuusyoKaigoSingle;

  private ACRadioButtonItem tsuusyoKaigoDouble;

  private ACRadioButtonItem tsuusyoKaigoDementiaSingle;

  private ACRadioButtonItem tsuusyoKaigoDementiaDouble;

  private ACComboBox tsuusyoKaigoTimeDivision;

  private ACLabelContainer tsuusyoKaigoTimeDivisionContainer;

  private ACComboBoxModelAdapter tsuusyoKaigoTimeDivisionModel;

  private ACClearableRadioButtonGroup tsuusyoKaigoAdditionFunctionTrainingRadio;

  private ACLabelContainer tsuusyoKaigoAdditionFunctionTrainingRadioContainer;

  private ACListModelAdapter tsuusyoKaigoAdditionFunctionTrainingRadioModel;

  private ACRadioButtonItem tsuusyoKaigoAdditionFunctionTrainingRadioItem1;

  private ACRadioButtonItem tsuusyoKaigoAdditionFunctionTrainingRadioItem2;

  private ACClearableRadioButtonGroup tsuusyoKaigoAdditionFunctionBathRadio;

  private ACLabelContainer tsuusyoKaigoAdditionFunctionBathRadioContainer;

  private ACListModelAdapter tsuusyoKaigoAdditionFunctionBathRadioModel;

  private ACRadioButtonItem tsuusyoKaigoAdditionFunctionBathRadioItem1;

  private ACRadioButtonItem tsuusyoKaigoAdditionFunctionBathRadioItem2;

  private ACRadioButtonItem tsuusyoKaigoAdditionFunctionBathRadioItem3;

  private ACClearableRadioButtonGroup tsuusyoKaigoMeetingAndSendingOff;

  private ACLabelContainer tsuusyoKaigoMeetingAndSendingOffContainer;

  private ACListModelAdapter tsuusyoKaigoMeetingAndSendingOffModel;

  private ACRadioButtonItem tsuusyoKaigoMeetingAndSendingOffNone;

  private ACRadioButtonItem tsuusyoKaigoMeetingAndSendingOffOneWay;

  private ACRadioButtonItem tsuusyoKaigoMeetingAndSendingOffRoundTrip;

  private ACClearableRadioButtonGroup tsuusyoKaigoSubtraction;

  private ACLabelContainer tsuusyoKaigoSubtractionContainer;

  private ACListModelAdapter tsuusyoKaigoSubtractionModel;

  private ACRadioButtonItem tsuusyoKaigoSubtractionNot;

  private ACRadioButtonItem tsuusyoKaigoSubtractionExcess;

  private ACRadioButtonItem tsuusyoKaigoSubtractionLack;

  //getter

  /**
   * 通所介護パターン領域を取得します。
   * @return 通所介護パターン領域
   */
  public ACPanel getTsuusyoKaigoPatterns(){
    if(tsuusyoKaigoPatterns==null){

      tsuusyoKaigoPatterns = new ACPanel();

      tsuusyoKaigoPatterns.setHgap(0);

      addTsuusyoKaigoPatterns();
    }
    return tsuusyoKaigoPatterns;

  }

  /**
   * 提供時間コンテナを取得します。
   * @return 提供時間コンテナ
   */
  public ACBackLabelContainer getTsuusyoKaigoTimeContena(){
    if(tsuusyoKaigoTimeContena==null){

      tsuusyoKaigoTimeContena = new ACBackLabelContainer();

      addTsuusyoKaigoTimeContena();
    }
    return tsuusyoKaigoTimeContena;

  }

  /**
   * 開始時刻コンボを取得します。
   * @return 開始時刻コンボ
   */
  public ACTimeComboBox getTsuusyoKaigoTimeBeginTime(){
    if(tsuusyoKaigoTimeBeginTime==null){

      tsuusyoKaigoTimeBeginTime = new ACTimeComboBox();

      getTsuusyoKaigoTimeBeginTimeContainer().setText("開始時刻");

      tsuusyoKaigoTimeBeginTime.setBindPath("3");

      tsuusyoKaigoTimeBeginTime.setModelBindPath("3");

      tsuusyoKaigoTimeBeginTime.setModel(getTsuusyoKaigoTimeBeginTimeModel());

      tsuusyoKaigoTimeBeginTime.setRenderBindPath("CONTENT");

      addTsuusyoKaigoTimeBeginTime();
    }
    return tsuusyoKaigoTimeBeginTime;

  }

  /**
   * 開始時刻コンボコンテナを取得します。
   * @return 開始時刻コンボコンテナ
   */
  protected ACLabelContainer getTsuusyoKaigoTimeBeginTimeContainer(){
    if(tsuusyoKaigoTimeBeginTimeContainer==null){
      tsuusyoKaigoTimeBeginTimeContainer = new ACLabelContainer();
      tsuusyoKaigoTimeBeginTimeContainer.setFollowChildEnabled(true);
      tsuusyoKaigoTimeBeginTimeContainer.add(getTsuusyoKaigoTimeBeginTime(), null);
    }
    return tsuusyoKaigoTimeBeginTimeContainer;
  }

  /**
   * 開始時刻コンボモデルを取得します。
   * @return 開始時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getTsuusyoKaigoTimeBeginTimeModel(){
    if(tsuusyoKaigoTimeBeginTimeModel==null){
      tsuusyoKaigoTimeBeginTimeModel = new ACComboBoxModelAdapter();
      addTsuusyoKaigoTimeBeginTimeModel();
    }
    return tsuusyoKaigoTimeBeginTimeModel;
  }

  /**
   * 終了時刻コンボを取得します。
   * @return 終了時刻コンボ
   */
  public ACTimeComboBox getTsuusyoKaigoTimeEndTime(){
    if(tsuusyoKaigoTimeEndTime==null){

      tsuusyoKaigoTimeEndTime = new ACTimeComboBox();

      getTsuusyoKaigoTimeEndTimeContainer().setText("終了時刻");

      tsuusyoKaigoTimeEndTime.setBindPath("4");

      tsuusyoKaigoTimeEndTime.setModelBindPath("4");

      tsuusyoKaigoTimeEndTime.setModel(getTsuusyoKaigoTimeEndTimeModel());

      tsuusyoKaigoTimeEndTime.setRenderBindPath("CONTENT");

      addTsuusyoKaigoTimeEndTime();
    }
    return tsuusyoKaigoTimeEndTime;

  }

  /**
   * 終了時刻コンボコンテナを取得します。
   * @return 終了時刻コンボコンテナ
   */
  protected ACLabelContainer getTsuusyoKaigoTimeEndTimeContainer(){
    if(tsuusyoKaigoTimeEndTimeContainer==null){
      tsuusyoKaigoTimeEndTimeContainer = new ACLabelContainer();
      tsuusyoKaigoTimeEndTimeContainer.setFollowChildEnabled(true);
      tsuusyoKaigoTimeEndTimeContainer.add(getTsuusyoKaigoTimeEndTime(), null);
    }
    return tsuusyoKaigoTimeEndTimeContainer;
  }

  /**
   * 終了時刻コンボモデルを取得します。
   * @return 終了時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getTsuusyoKaigoTimeEndTimeModel(){
    if(tsuusyoKaigoTimeEndTimeModel==null){
      tsuusyoKaigoTimeEndTimeModel = new ACComboBoxModelAdapter();
      addTsuusyoKaigoTimeEndTimeModel();
    }
    return tsuusyoKaigoTimeEndTimeModel;
  }

  /**
   * 施設区分を取得します。
   * @return 施設区分
   */
  public ACClearableRadioButtonGroup getTsuusyoKaigoTimeContenaFacilityDivision(){
    if(tsuusyoKaigoTimeContenaFacilityDivision==null){

      tsuusyoKaigoTimeContenaFacilityDivision = new ACClearableRadioButtonGroup();

      getTsuusyoKaigoTimeContenaFacilityDivisionContainer().setText("施設区分");

      tsuusyoKaigoTimeContenaFacilityDivision.setBindPath("1150103");

      tsuusyoKaigoTimeContenaFacilityDivision.setModel(getTsuusyoKaigoTimeContenaFacilityDivisionModel());

      tsuusyoKaigoTimeContenaFacilityDivision.setUseClearButton(false);

      addTsuusyoKaigoTimeContenaFacilityDivision();
    }
    return tsuusyoKaigoTimeContenaFacilityDivision;

  }

  /**
   * 施設区分コンテナを取得します。
   * @return 施設区分コンテナ
   */
  protected ACLabelContainer getTsuusyoKaigoTimeContenaFacilityDivisionContainer(){
    if(tsuusyoKaigoTimeContenaFacilityDivisionContainer==null){
      tsuusyoKaigoTimeContenaFacilityDivisionContainer = new ACLabelContainer();
      tsuusyoKaigoTimeContenaFacilityDivisionContainer.setFollowChildEnabled(true);
      tsuusyoKaigoTimeContenaFacilityDivisionContainer.add(getTsuusyoKaigoTimeContenaFacilityDivision(), null);
    }
    return tsuusyoKaigoTimeContenaFacilityDivisionContainer;
  }

  /**
   * 施設区分モデルを取得します。
   * @return 施設区分モデル
   */
  protected ACListModelAdapter getTsuusyoKaigoTimeContenaFacilityDivisionModel(){
    if(tsuusyoKaigoTimeContenaFacilityDivisionModel==null){
      tsuusyoKaigoTimeContenaFacilityDivisionModel = new ACListModelAdapter();
      addTsuusyoKaigoTimeContenaFacilityDivisionModel();
    }
    return tsuusyoKaigoTimeContenaFacilityDivisionModel;
  }

  /**
   * 単独型を取得します。
   * @return 単独型
   */
  public ACRadioButtonItem getTsuusyoKaigoSingle(){
    if(tsuusyoKaigoSingle==null){

      tsuusyoKaigoSingle = new ACRadioButtonItem();

      tsuusyoKaigoSingle.setText("単独型");

      tsuusyoKaigoSingle.setGroup(getTsuusyoKaigoTimeContenaFacilityDivision());

      tsuusyoKaigoSingle.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoSingle();
    }
    return tsuusyoKaigoSingle;

  }

  /**
   * 併設型を取得します。
   * @return 併設型
   */
  public ACRadioButtonItem getTsuusyoKaigoDouble(){
    if(tsuusyoKaigoDouble==null){

      tsuusyoKaigoDouble = new ACRadioButtonItem();

      tsuusyoKaigoDouble.setText("併設型");

      tsuusyoKaigoDouble.setGroup(getTsuusyoKaigoTimeContenaFacilityDivision());

      tsuusyoKaigoDouble.setConstraints(VRLayout.FLOW_RETURN);

      addTsuusyoKaigoDouble();
    }
    return tsuusyoKaigoDouble;

  }

  /**
   * 痴呆専用単独型を取得します。
   * @return 痴呆専用単独型
   */
  public ACRadioButtonItem getTsuusyoKaigoDementiaSingle(){
    if(tsuusyoKaigoDementiaSingle==null){

      tsuusyoKaigoDementiaSingle = new ACRadioButtonItem();

      tsuusyoKaigoDementiaSingle.setText("認知症専用単独型");

      tsuusyoKaigoDementiaSingle.setGroup(getTsuusyoKaigoTimeContenaFacilityDivision());

      tsuusyoKaigoDementiaSingle.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoDementiaSingle();
    }
    return tsuusyoKaigoDementiaSingle;

  }

  /**
   * 痴呆専用併設型を取得します。
   * @return 痴呆専用併設型
   */
  public ACRadioButtonItem getTsuusyoKaigoDementiaDouble(){
    if(tsuusyoKaigoDementiaDouble==null){

      tsuusyoKaigoDementiaDouble = new ACRadioButtonItem();

      tsuusyoKaigoDementiaDouble.setText("認知症専用併設型");

      tsuusyoKaigoDementiaDouble.setGroup(getTsuusyoKaigoTimeContenaFacilityDivision());

      tsuusyoKaigoDementiaDouble.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoDementiaDouble();
    }
    return tsuusyoKaigoDementiaDouble;

  }

  /**
   * 時間区分を取得します。
   * @return 時間区分
   */
  public ACComboBox getTsuusyoKaigoTimeDivision(){
    if(tsuusyoKaigoTimeDivision==null){

      tsuusyoKaigoTimeDivision = new ACComboBox();

      getTsuusyoKaigoTimeDivisionContainer().setText("時間区分");

      tsuusyoKaigoTimeDivision.setBindPath("1150104");

      tsuusyoKaigoTimeDivision.setEditable(false);

      tsuusyoKaigoTimeDivision.setModelBindPath("1150104");

      tsuusyoKaigoTimeDivision.setModel(getTsuusyoKaigoTimeDivisionModel());

      tsuusyoKaigoTimeDivision.setRenderBindPath("CONTENT");

      addTsuusyoKaigoTimeDivision();
    }
    return tsuusyoKaigoTimeDivision;

  }

  /**
   * 時間区分コンテナを取得します。
   * @return 時間区分コンテナ
   */
  protected ACLabelContainer getTsuusyoKaigoTimeDivisionContainer(){
    if(tsuusyoKaigoTimeDivisionContainer==null){
      tsuusyoKaigoTimeDivisionContainer = new ACLabelContainer();
      tsuusyoKaigoTimeDivisionContainer.setFollowChildEnabled(true);
      tsuusyoKaigoTimeDivisionContainer.add(getTsuusyoKaigoTimeDivision(), null);
    }
    return tsuusyoKaigoTimeDivisionContainer;
  }

  /**
   * 時間区分モデルを取得します。
   * @return 時間区分モデル
   */
  protected ACComboBoxModelAdapter getTsuusyoKaigoTimeDivisionModel(){
    if(tsuusyoKaigoTimeDivisionModel==null){
      tsuusyoKaigoTimeDivisionModel = new ACComboBoxModelAdapter();
      addTsuusyoKaigoTimeDivisionModel();
    }
    return tsuusyoKaigoTimeDivisionModel;
  }

  /**
   * 機能訓練指導加算を取得します。
   * @return 機能訓練指導加算
   */
  public ACClearableRadioButtonGroup getTsuusyoKaigoAdditionFunctionTrainingRadio(){
    if(tsuusyoKaigoAdditionFunctionTrainingRadio==null){

      tsuusyoKaigoAdditionFunctionTrainingRadio = new ACClearableRadioButtonGroup();

      getTsuusyoKaigoAdditionFunctionTrainingRadioContainer().setText("機能訓練加算");

      tsuusyoKaigoAdditionFunctionTrainingRadio.setBindPath("1150105");

      tsuusyoKaigoAdditionFunctionTrainingRadio.setModel(getTsuusyoKaigoAdditionFunctionTrainingRadioModel());

      tsuusyoKaigoAdditionFunctionTrainingRadio.setUseClearButton(false);

      addTsuusyoKaigoAdditionFunctionTrainingRadio();
    }
    return tsuusyoKaigoAdditionFunctionTrainingRadio;

  }

  /**
   * 機能訓練指導加算コンテナを取得します。
   * @return 機能訓練指導加算コンテナ
   */
  protected ACLabelContainer getTsuusyoKaigoAdditionFunctionTrainingRadioContainer(){
    if(tsuusyoKaigoAdditionFunctionTrainingRadioContainer==null){
      tsuusyoKaigoAdditionFunctionTrainingRadioContainer = new ACLabelContainer();
      tsuusyoKaigoAdditionFunctionTrainingRadioContainer.setFollowChildEnabled(true);
      tsuusyoKaigoAdditionFunctionTrainingRadioContainer.add(getTsuusyoKaigoAdditionFunctionTrainingRadio(), null);
    }
    return tsuusyoKaigoAdditionFunctionTrainingRadioContainer;
  }

  /**
   * 機能訓練指導加算モデルを取得します。
   * @return 機能訓練指導加算モデル
   */
  protected ACListModelAdapter getTsuusyoKaigoAdditionFunctionTrainingRadioModel(){
    if(tsuusyoKaigoAdditionFunctionTrainingRadioModel==null){
      tsuusyoKaigoAdditionFunctionTrainingRadioModel = new ACListModelAdapter();
      addTsuusyoKaigoAdditionFunctionTrainingRadioModel();
    }
    return tsuusyoKaigoAdditionFunctionTrainingRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTsuusyoKaigoAdditionFunctionTrainingRadioItem1(){
    if(tsuusyoKaigoAdditionFunctionTrainingRadioItem1==null){

      tsuusyoKaigoAdditionFunctionTrainingRadioItem1 = new ACRadioButtonItem();

      tsuusyoKaigoAdditionFunctionTrainingRadioItem1.setText("なし");

      tsuusyoKaigoAdditionFunctionTrainingRadioItem1.setGroup(getTsuusyoKaigoAdditionFunctionTrainingRadio());

      tsuusyoKaigoAdditionFunctionTrainingRadioItem1.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoAdditionFunctionTrainingRadioItem1();
    }
    return tsuusyoKaigoAdditionFunctionTrainingRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getTsuusyoKaigoAdditionFunctionTrainingRadioItem2(){
    if(tsuusyoKaigoAdditionFunctionTrainingRadioItem2==null){

      tsuusyoKaigoAdditionFunctionTrainingRadioItem2 = new ACRadioButtonItem();

      tsuusyoKaigoAdditionFunctionTrainingRadioItem2.setText("あり");

      tsuusyoKaigoAdditionFunctionTrainingRadioItem2.setGroup(getTsuusyoKaigoAdditionFunctionTrainingRadio());

      tsuusyoKaigoAdditionFunctionTrainingRadioItem2.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoAdditionFunctionTrainingRadioItem2();
    }
    return tsuusyoKaigoAdditionFunctionTrainingRadioItem2;

  }

  /**
   * 入浴加算を取得します。
   * @return 入浴加算
   */
  public ACClearableRadioButtonGroup getTsuusyoKaigoAdditionFunctionBathRadio(){
    if(tsuusyoKaigoAdditionFunctionBathRadio==null){

      tsuusyoKaigoAdditionFunctionBathRadio = new ACClearableRadioButtonGroup();

      getTsuusyoKaigoAdditionFunctionBathRadioContainer().setText("入浴加算");

      tsuusyoKaigoAdditionFunctionBathRadio.setBindPath("1150106");

      tsuusyoKaigoAdditionFunctionBathRadio.setModel(getTsuusyoKaigoAdditionFunctionBathRadioModel());

      tsuusyoKaigoAdditionFunctionBathRadio.setUseClearButton(false);

      addTsuusyoKaigoAdditionFunctionBathRadio();
    }
    return tsuusyoKaigoAdditionFunctionBathRadio;

  }

  /**
   * 入浴加算コンテナを取得します。
   * @return 入浴加算コンテナ
   */
  protected ACLabelContainer getTsuusyoKaigoAdditionFunctionBathRadioContainer(){
    if(tsuusyoKaigoAdditionFunctionBathRadioContainer==null){
      tsuusyoKaigoAdditionFunctionBathRadioContainer = new ACLabelContainer();
      tsuusyoKaigoAdditionFunctionBathRadioContainer.setFollowChildEnabled(true);
      tsuusyoKaigoAdditionFunctionBathRadioContainer.add(getTsuusyoKaigoAdditionFunctionBathRadio(), null);
    }
    return tsuusyoKaigoAdditionFunctionBathRadioContainer;
  }

  /**
   * 入浴加算モデルを取得します。
   * @return 入浴加算モデル
   */
  protected ACListModelAdapter getTsuusyoKaigoAdditionFunctionBathRadioModel(){
    if(tsuusyoKaigoAdditionFunctionBathRadioModel==null){
      tsuusyoKaigoAdditionFunctionBathRadioModel = new ACListModelAdapter();
      addTsuusyoKaigoAdditionFunctionBathRadioModel();
    }
    return tsuusyoKaigoAdditionFunctionBathRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTsuusyoKaigoAdditionFunctionBathRadioItem1(){
    if(tsuusyoKaigoAdditionFunctionBathRadioItem1==null){

      tsuusyoKaigoAdditionFunctionBathRadioItem1 = new ACRadioButtonItem();

      tsuusyoKaigoAdditionFunctionBathRadioItem1.setText("なし");

      tsuusyoKaigoAdditionFunctionBathRadioItem1.setGroup(getTsuusyoKaigoAdditionFunctionBathRadio());

      tsuusyoKaigoAdditionFunctionBathRadioItem1.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoAdditionFunctionBathRadioItem1();
    }
    return tsuusyoKaigoAdditionFunctionBathRadioItem1;

  }

  /**
   * 通常を取得します。
   * @return 通常
   */
  public ACRadioButtonItem getTsuusyoKaigoAdditionFunctionBathRadioItem2(){
    if(tsuusyoKaigoAdditionFunctionBathRadioItem2==null){

      tsuusyoKaigoAdditionFunctionBathRadioItem2 = new ACRadioButtonItem();

      tsuusyoKaigoAdditionFunctionBathRadioItem2.setText("通常入浴");

      tsuusyoKaigoAdditionFunctionBathRadioItem2.setGroup(getTsuusyoKaigoAdditionFunctionBathRadio());

      tsuusyoKaigoAdditionFunctionBathRadioItem2.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoAdditionFunctionBathRadioItem2();
    }
    return tsuusyoKaigoAdditionFunctionBathRadioItem2;

  }

  /**
   * 特別入浴を取得します。
   * @return 特別入浴
   */
  public ACRadioButtonItem getTsuusyoKaigoAdditionFunctionBathRadioItem3(){
    if(tsuusyoKaigoAdditionFunctionBathRadioItem3==null){

      tsuusyoKaigoAdditionFunctionBathRadioItem3 = new ACRadioButtonItem();

      tsuusyoKaigoAdditionFunctionBathRadioItem3.setText("特別入浴");

      tsuusyoKaigoAdditionFunctionBathRadioItem3.setGroup(getTsuusyoKaigoAdditionFunctionBathRadio());

      tsuusyoKaigoAdditionFunctionBathRadioItem3.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoAdditionFunctionBathRadioItem3();
    }
    return tsuusyoKaigoAdditionFunctionBathRadioItem3;

  }

  /**
   * 送迎区分を取得します。
   * @return 送迎区分
   */
  public ACClearableRadioButtonGroup getTsuusyoKaigoMeetingAndSendingOff(){
    if(tsuusyoKaigoMeetingAndSendingOff==null){

      tsuusyoKaigoMeetingAndSendingOff = new ACClearableRadioButtonGroup();

      getTsuusyoKaigoMeetingAndSendingOffContainer().setText("送迎加算");

      tsuusyoKaigoMeetingAndSendingOff.setBindPath("6");

      tsuusyoKaigoMeetingAndSendingOff.setModel(getTsuusyoKaigoMeetingAndSendingOffModel());

      tsuusyoKaigoMeetingAndSendingOff.setUseClearButton(false);

      addTsuusyoKaigoMeetingAndSendingOff();
    }
    return tsuusyoKaigoMeetingAndSendingOff;

  }

  /**
   * 送迎区分コンテナを取得します。
   * @return 送迎区分コンテナ
   */
  protected ACLabelContainer getTsuusyoKaigoMeetingAndSendingOffContainer(){
    if(tsuusyoKaigoMeetingAndSendingOffContainer==null){
      tsuusyoKaigoMeetingAndSendingOffContainer = new ACLabelContainer();
      tsuusyoKaigoMeetingAndSendingOffContainer.setFollowChildEnabled(true);
      tsuusyoKaigoMeetingAndSendingOffContainer.add(getTsuusyoKaigoMeetingAndSendingOff(), null);
    }
    return tsuusyoKaigoMeetingAndSendingOffContainer;
  }

  /**
   * 送迎区分モデルを取得します。
   * @return 送迎区分モデル
   */
  protected ACListModelAdapter getTsuusyoKaigoMeetingAndSendingOffModel(){
    if(tsuusyoKaigoMeetingAndSendingOffModel==null){
      tsuusyoKaigoMeetingAndSendingOffModel = new ACListModelAdapter();
      addTsuusyoKaigoMeetingAndSendingOffModel();
    }
    return tsuusyoKaigoMeetingAndSendingOffModel;
  }

  /**
   * 送迎なしを取得します。
   * @return 送迎なし
   */
  public ACRadioButtonItem getTsuusyoKaigoMeetingAndSendingOffNone(){
    if(tsuusyoKaigoMeetingAndSendingOffNone==null){

      tsuusyoKaigoMeetingAndSendingOffNone = new ACRadioButtonItem();

      tsuusyoKaigoMeetingAndSendingOffNone.setText("送迎なし");

      tsuusyoKaigoMeetingAndSendingOffNone.setGroup(getTsuusyoKaigoMeetingAndSendingOff());

      tsuusyoKaigoMeetingAndSendingOffNone.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoMeetingAndSendingOffNone();
    }
    return tsuusyoKaigoMeetingAndSendingOffNone;

  }

  /**
   * 送迎片道を取得します。
   * @return 送迎片道
   */
  public ACRadioButtonItem getTsuusyoKaigoMeetingAndSendingOffOneWay(){
    if(tsuusyoKaigoMeetingAndSendingOffOneWay==null){

      tsuusyoKaigoMeetingAndSendingOffOneWay = new ACRadioButtonItem();

      tsuusyoKaigoMeetingAndSendingOffOneWay.setText("送迎片道");

      tsuusyoKaigoMeetingAndSendingOffOneWay.setGroup(getTsuusyoKaigoMeetingAndSendingOff());

      tsuusyoKaigoMeetingAndSendingOffOneWay.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoMeetingAndSendingOffOneWay();
    }
    return tsuusyoKaigoMeetingAndSendingOffOneWay;

  }

  /**
   * 送迎往復を取得します。
   * @return 送迎往復
   */
  public ACRadioButtonItem getTsuusyoKaigoMeetingAndSendingOffRoundTrip(){
    if(tsuusyoKaigoMeetingAndSendingOffRoundTrip==null){

      tsuusyoKaigoMeetingAndSendingOffRoundTrip = new ACRadioButtonItem();

      tsuusyoKaigoMeetingAndSendingOffRoundTrip.setText("送迎往復");

      tsuusyoKaigoMeetingAndSendingOffRoundTrip.setGroup(getTsuusyoKaigoMeetingAndSendingOff());

      tsuusyoKaigoMeetingAndSendingOffRoundTrip.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoMeetingAndSendingOffRoundTrip();
    }
    return tsuusyoKaigoMeetingAndSendingOffRoundTrip;

  }

  /**
   * 人員減算を取得します。
   * @return 人員減算
   */
  public ACClearableRadioButtonGroup getTsuusyoKaigoSubtraction(){
    if(tsuusyoKaigoSubtraction==null){

      tsuusyoKaigoSubtraction = new ACClearableRadioButtonGroup();

      getTsuusyoKaigoSubtractionContainer().setText("人員減算");

      tsuusyoKaigoSubtraction.setBindPath("1150108");

      tsuusyoKaigoSubtraction.setModel(getTsuusyoKaigoSubtractionModel());

      tsuusyoKaigoSubtraction.setUseClearButton(false);

      addTsuusyoKaigoSubtraction();
    }
    return tsuusyoKaigoSubtraction;

  }

  /**
   * 人員減算コンテナを取得します。
   * @return 人員減算コンテナ
   */
  protected ACLabelContainer getTsuusyoKaigoSubtractionContainer(){
    if(tsuusyoKaigoSubtractionContainer==null){
      tsuusyoKaigoSubtractionContainer = new ACLabelContainer();
      tsuusyoKaigoSubtractionContainer.setFollowChildEnabled(true);
      tsuusyoKaigoSubtractionContainer.add(getTsuusyoKaigoSubtraction(), null);
    }
    return tsuusyoKaigoSubtractionContainer;
  }

  /**
   * 人員減算モデルを取得します。
   * @return 人員減算モデル
   */
  protected ACListModelAdapter getTsuusyoKaigoSubtractionModel(){
    if(tsuusyoKaigoSubtractionModel==null){
      tsuusyoKaigoSubtractionModel = new ACListModelAdapter();
      addTsuusyoKaigoSubtractionModel();
    }
    return tsuusyoKaigoSubtractionModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTsuusyoKaigoSubtractionNot(){
    if(tsuusyoKaigoSubtractionNot==null){

      tsuusyoKaigoSubtractionNot = new ACRadioButtonItem();

      tsuusyoKaigoSubtractionNot.setText("なし");

      tsuusyoKaigoSubtractionNot.setGroup(getTsuusyoKaigoSubtraction());

      tsuusyoKaigoSubtractionNot.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoSubtractionNot();
    }
    return tsuusyoKaigoSubtractionNot;

  }

  /**
   * 定員超過を取得します。
   * @return 定員超過
   */
  public ACRadioButtonItem getTsuusyoKaigoSubtractionExcess(){
    if(tsuusyoKaigoSubtractionExcess==null){

      tsuusyoKaigoSubtractionExcess = new ACRadioButtonItem();

      tsuusyoKaigoSubtractionExcess.setText("定員超過");

      tsuusyoKaigoSubtractionExcess.setGroup(getTsuusyoKaigoSubtraction());

      tsuusyoKaigoSubtractionExcess.setConstraints(VRLayout.FLOW_RETURN);

      addTsuusyoKaigoSubtractionExcess();
    }
    return tsuusyoKaigoSubtractionExcess;

  }

  /**
   * 看護・介護職員の不足を取得します。
   * @return 看護・介護職員の不足
   */
  public ACRadioButtonItem getTsuusyoKaigoSubtractionLack(){
    if(tsuusyoKaigoSubtractionLack==null){

      tsuusyoKaigoSubtractionLack = new ACRadioButtonItem();

      tsuusyoKaigoSubtractionLack.setText("看護・介護職員の不足");

      tsuusyoKaigoSubtractionLack.setGroup(getTsuusyoKaigoSubtraction());

      tsuusyoKaigoSubtractionLack.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoSubtractionLack();
    }
    return tsuusyoKaigoSubtractionLack;

  }

  /**
   * コンストラクタです。
   */
  public QS001008Design() {

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

    this.add(getTsuusyoKaigoPatterns(), VRLayout.WEST);

  }

  /**
   * 通所介護パターン領域に内部項目を追加します。
   */
  protected void addTsuusyoKaigoPatterns(){

    tsuusyoKaigoPatterns.add(getTsuusyoKaigoTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    tsuusyoKaigoPatterns.add(getTsuusyoKaigoTimeContenaFacilityDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyoKaigoPatterns.add(getTsuusyoKaigoTimeDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyoKaigoPatterns.add(getTsuusyoKaigoAdditionFunctionTrainingRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyoKaigoPatterns.add(getTsuusyoKaigoAdditionFunctionBathRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyoKaigoPatterns.add(getTsuusyoKaigoMeetingAndSendingOffContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyoKaigoPatterns.add(getTsuusyoKaigoSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 提供時間コンテナに内部項目を追加します。
   */
  protected void addTsuusyoKaigoTimeContena(){

    tsuusyoKaigoTimeContena.add(getTsuusyoKaigoTimeBeginTimeContainer(), VRLayout.FLOW);

    tsuusyoKaigoTimeContena.add(getTsuusyoKaigoTimeEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * 開始時刻コンボに内部項目を追加します。
   */
  protected void addTsuusyoKaigoTimeBeginTime(){

  }

  /**
   * 開始時刻コンボモデルに内部項目を追加します。
   */
  protected void addTsuusyoKaigoTimeBeginTimeModel(){

  }

  /**
   * 終了時刻コンボに内部項目を追加します。
   */
  protected void addTsuusyoKaigoTimeEndTime(){

  }

  /**
   * 終了時刻コンボモデルに内部項目を追加します。
   */
  protected void addTsuusyoKaigoTimeEndTimeModel(){

  }

  /**
   * 施設区分に内部項目を追加します。
   */
  protected void addTsuusyoKaigoTimeContenaFacilityDivision(){

  }

  /**
   * 施設区分モデルに内部項目を追加します。
   */
  protected void addTsuusyoKaigoTimeContenaFacilityDivisionModel(){

    getTsuusyoKaigoSingle().setButtonIndex(1);
    getTsuusyoKaigoTimeContenaFacilityDivisionModel().add(getTsuusyoKaigoSingle());

    getTsuusyoKaigoDouble().setButtonIndex(2);
    getTsuusyoKaigoTimeContenaFacilityDivisionModel().add(getTsuusyoKaigoDouble());

    getTsuusyoKaigoDementiaSingle().setButtonIndex(3);
    getTsuusyoKaigoTimeContenaFacilityDivisionModel().add(getTsuusyoKaigoDementiaSingle());

    getTsuusyoKaigoDementiaDouble().setButtonIndex(4);
    getTsuusyoKaigoTimeContenaFacilityDivisionModel().add(getTsuusyoKaigoDementiaDouble());

  }

  /**
   * 単独型に内部項目を追加します。
   */
  protected void addTsuusyoKaigoSingle(){

  }

  /**
   * 併設型に内部項目を追加します。
   */
  protected void addTsuusyoKaigoDouble(){

  }

  /**
   * 痴呆専用単独型に内部項目を追加します。
   */
  protected void addTsuusyoKaigoDementiaSingle(){

  }

  /**
   * 痴呆専用併設型に内部項目を追加します。
   */
  protected void addTsuusyoKaigoDementiaDouble(){

  }

  /**
   * 時間区分に内部項目を追加します。
   */
  protected void addTsuusyoKaigoTimeDivision(){

  }

  /**
   * 時間区分モデルに内部項目を追加します。
   */
  protected void addTsuusyoKaigoTimeDivisionModel(){

  }

  /**
   * 機能訓練指導加算に内部項目を追加します。
   */
  protected void addTsuusyoKaigoAdditionFunctionTrainingRadio(){

  }

  /**
   * 機能訓練指導加算モデルに内部項目を追加します。
   */
  protected void addTsuusyoKaigoAdditionFunctionTrainingRadioModel(){

    getTsuusyoKaigoAdditionFunctionTrainingRadioItem1().setButtonIndex(1);
    getTsuusyoKaigoAdditionFunctionTrainingRadioModel().add(getTsuusyoKaigoAdditionFunctionTrainingRadioItem1());

    getTsuusyoKaigoAdditionFunctionTrainingRadioItem2().setButtonIndex(2);
    getTsuusyoKaigoAdditionFunctionTrainingRadioModel().add(getTsuusyoKaigoAdditionFunctionTrainingRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTsuusyoKaigoAdditionFunctionTrainingRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addTsuusyoKaigoAdditionFunctionTrainingRadioItem2(){

  }

  /**
   * 入浴加算に内部項目を追加します。
   */
  protected void addTsuusyoKaigoAdditionFunctionBathRadio(){

  }

  /**
   * 入浴加算モデルに内部項目を追加します。
   */
  protected void addTsuusyoKaigoAdditionFunctionBathRadioModel(){

    getTsuusyoKaigoAdditionFunctionBathRadioItem1().setButtonIndex(1);
    getTsuusyoKaigoAdditionFunctionBathRadioModel().add(getTsuusyoKaigoAdditionFunctionBathRadioItem1());

    getTsuusyoKaigoAdditionFunctionBathRadioItem2().setButtonIndex(2);
    getTsuusyoKaigoAdditionFunctionBathRadioModel().add(getTsuusyoKaigoAdditionFunctionBathRadioItem2());

    getTsuusyoKaigoAdditionFunctionBathRadioItem3().setButtonIndex(3);
    getTsuusyoKaigoAdditionFunctionBathRadioModel().add(getTsuusyoKaigoAdditionFunctionBathRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTsuusyoKaigoAdditionFunctionBathRadioItem1(){

  }

  /**
   * 通常に内部項目を追加します。
   */
  protected void addTsuusyoKaigoAdditionFunctionBathRadioItem2(){

  }

  /**
   * 特別入浴に内部項目を追加します。
   */
  protected void addTsuusyoKaigoAdditionFunctionBathRadioItem3(){

  }

  /**
   * 送迎区分に内部項目を追加します。
   */
  protected void addTsuusyoKaigoMeetingAndSendingOff(){

  }

  /**
   * 送迎区分モデルに内部項目を追加します。
   */
  protected void addTsuusyoKaigoMeetingAndSendingOffModel(){

    getTsuusyoKaigoMeetingAndSendingOffNone().setButtonIndex(1);
    getTsuusyoKaigoMeetingAndSendingOffModel().add(getTsuusyoKaigoMeetingAndSendingOffNone());

    getTsuusyoKaigoMeetingAndSendingOffOneWay().setButtonIndex(2);
    getTsuusyoKaigoMeetingAndSendingOffModel().add(getTsuusyoKaigoMeetingAndSendingOffOneWay());

    getTsuusyoKaigoMeetingAndSendingOffRoundTrip().setButtonIndex(3);
    getTsuusyoKaigoMeetingAndSendingOffModel().add(getTsuusyoKaigoMeetingAndSendingOffRoundTrip());

  }

  /**
   * 送迎なしに内部項目を追加します。
   */
  protected void addTsuusyoKaigoMeetingAndSendingOffNone(){

  }

  /**
   * 送迎片道に内部項目を追加します。
   */
  protected void addTsuusyoKaigoMeetingAndSendingOffOneWay(){

  }

  /**
   * 送迎往復に内部項目を追加します。
   */
  protected void addTsuusyoKaigoMeetingAndSendingOffRoundTrip(){

  }

  /**
   * 人員減算に内部項目を追加します。
   */
  protected void addTsuusyoKaigoSubtraction(){

  }

  /**
   * 人員減算モデルに内部項目を追加します。
   */
  protected void addTsuusyoKaigoSubtractionModel(){

    getTsuusyoKaigoSubtractionNot().setButtonIndex(1);
    getTsuusyoKaigoSubtractionModel().add(getTsuusyoKaigoSubtractionNot());

    getTsuusyoKaigoSubtractionExcess().setButtonIndex(2);
    getTsuusyoKaigoSubtractionModel().add(getTsuusyoKaigoSubtractionExcess());

    getTsuusyoKaigoSubtractionLack().setButtonIndex(3);
    getTsuusyoKaigoSubtractionModel().add(getTsuusyoKaigoSubtractionLack());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTsuusyoKaigoSubtractionNot(){

  }

  /**
   * 定員超過に内部項目を追加します。
   */
  protected void addTsuusyoKaigoSubtractionExcess(){

  }

  /**
   * 看護・介護職員の不足に内部項目を追加します。
   */
  protected void addTsuusyoKaigoSubtractionLack(){

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
      ACFrame.getInstance().getContentPane().add(new QS001008Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001008Design getThis() {
    return this;
  }
}
