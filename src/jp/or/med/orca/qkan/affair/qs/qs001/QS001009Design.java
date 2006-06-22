
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
 * サブシステム 予定管理 (S)
 * プロセス 利用者一覧（サービス予定作成/変更） (001)
 * プログラム サービスパターン通所リハ (QS001009)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Component;

import javax.swing.JTabbedPane;

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
 * サービスパターン通所リハ画面項目デザイン(QS001009) 
 */
public class QS001009Design extends QS001ServicePanel {
  //GUIコンポーネント

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACBackLabelContainer houmonRehabilitationTimeContena;

  private ACTimeComboBox houmonRehabilitationTimeContenaBeginTime;

  private ACLabelContainer houmonRehabilitationTimeContenaBeginTimeContainer;

  private ACComboBoxModelAdapter houmonRehabilitationTimeContenaBeginTimeModel;

  private ACTimeComboBox houmonRehabilitationTimeContenaEndTime;

  private ACLabelContainer houmonRehabilitationTimeContenaEndTimeContainer;

  private ACComboBoxModelAdapter houmonRehabilitationTimeContenaEndTimeModel;

  private ACClearableRadioButtonGroup houmonRehabilitationTimeContenaFacilityDivision;

  private ACLabelContainer houmonRehabilitationTimeContenaFacilityDivisionContainer;

  private ACListModelAdapter houmonRehabilitationTimeContenaFacilityDivisionModel;

  private ACRadioButtonItem houmonRehabilitationMedicalInstitution;

  private ACRadioButtonItem houmonRehabilitationDouble;

  private ACRadioButtonItem houmonRehabilitationClinic;

  private ACComboBox houmonRehabilitationTimeDivision;

  private ACLabelContainer houmonRehabilitationTimeDivisionContainer;

  private ACComboBoxModelAdapter houmonRehabilitationTimeDivisionModel;

  private ACClearableRadioButtonGroup houmonRehabilitationBathRadio;

  private ACLabelContainer houmonRehabilitationBathRadioContainer;

  private ACListModelAdapter houmonRehabilitationBathRadioModel;

  private ACRadioButtonItem houmonRehabilitationBathRadioItem1;

  private ACRadioButtonItem houmonRehabilitationBathRadioItem2;

  private ACRadioButtonItem houmonRehabilitationBathRadioItem3;

  private ACClearableRadioButtonGroup houmonRehabilitationMeetingAndSendingOff;

  private ACLabelContainer houmonRehabilitationMeetingAndSendingOffContainer;

  private ACListModelAdapter houmonRehabilitationMeetingAndSendingOffModel;

  private ACRadioButtonItem houmonRehabilitationMeetingAndSendingOffNone;

  private ACRadioButtonItem houmonRehabilitationMeetingAndSendingOffOneWay;

  private ACRadioButtonItem houmonRehabilitationMeetingAndSendingOffRoundTrip;

  private ACClearableRadioButtonGroup houmonRehabilitationAdditionTreatmentPersonRadio;

  private ACLabelContainer houmonRehabilitationAdditionTreatmentPersonRadioContainer;

  private ACListModelAdapter houmonRehabilitationAdditionTreatmentPersonRadioModel;

  private ACRadioButtonItem houmonRehabilitationAdditionTreatmentPersonRadioItem1;

  private ACRadioButtonItem houmonRehabilitationAdditionTreatmentPersonRadioItem2;

  private ACClearableRadioButtonGroup houmonRehabilitationIndividualRadio;

  private ACLabelContainer houmonRehabilitationIndividualRadioContainer;

  private ACListModelAdapter houmonRehabilitationIndividualRadioModel;

  private ACRadioButtonItem houmonRehabilitationIndividualRadioItem1;

  private ACRadioButtonItem houmonRehabilitationIndividualRadioItem2;

  private ACRadioButtonItem houmonRehabilitationIndividualRadioItem3;

  private ACPanel tab2;

  private ACClearableRadioButtonGroup houmonRehabilitationSubtraction;

  private ACLabelContainer houmonRehabilitationSubtractionContainer;

  private ACListModelAdapter houmonRehabilitationSubtractionModel;

  private ACRadioButtonItem houmonRehabilitationSubtractionNot;

  private ACRadioButtonItem houmonRehabilitationSubtractionExcess;

  private ACRadioButtonItem houmonRehabilitationSubtractionLack;

  //getter

  /**
   * タブペインを取得します。
   * @return タブペイン
   */
  public JTabbedPane getTabs(){
    if(tabs==null){

      tabs = new JTabbedPane();

      addTabs();
    }
    return tabs;

  }

  /**
   * タブ1を取得します。
   * @return タブ1
   */
  public ACPanel getTab1(){
    if(tab1==null){

      tab1 = new ACPanel();

      tab1.setHgap(0);

      addTab1();
    }
    return tab1;

  }

  /**
   * 提供時間コンテナを取得します。
   * @return 提供時間コンテナ
   */
  public ACBackLabelContainer getHoumonRehabilitationTimeContena(){
    if(houmonRehabilitationTimeContena==null){

      houmonRehabilitationTimeContena = new ACBackLabelContainer();

      addHoumonRehabilitationTimeContena();
    }
    return houmonRehabilitationTimeContena;

  }

  /**
   * 開始時刻コンボを取得します。
   * @return 開始時刻コンボ
   */
  public ACTimeComboBox getHoumonRehabilitationTimeContenaBeginTime(){
    if(houmonRehabilitationTimeContenaBeginTime==null){

      houmonRehabilitationTimeContenaBeginTime = new ACTimeComboBox();

      getHoumonRehabilitationTimeContenaBeginTimeContainer().setText("開始時刻");

      houmonRehabilitationTimeContenaBeginTime.setBindPath("3");

      houmonRehabilitationTimeContenaBeginTime.setModelBindPath("3");

      houmonRehabilitationTimeContenaBeginTime.setModel(getHoumonRehabilitationTimeContenaBeginTimeModel());

      houmonRehabilitationTimeContenaBeginTime.setRenderBindPath("CONTENT");

      addHoumonRehabilitationTimeContenaBeginTime();
    }
    return houmonRehabilitationTimeContenaBeginTime;

  }

  /**
   * 開始時刻コンボコンテナを取得します。
   * @return 開始時刻コンボコンテナ
   */
  protected ACLabelContainer getHoumonRehabilitationTimeContenaBeginTimeContainer(){
    if(houmonRehabilitationTimeContenaBeginTimeContainer==null){
      houmonRehabilitationTimeContenaBeginTimeContainer = new ACLabelContainer();
      houmonRehabilitationTimeContenaBeginTimeContainer.setFollowChildEnabled(true);
      houmonRehabilitationTimeContenaBeginTimeContainer.add(getHoumonRehabilitationTimeContenaBeginTime(), null);
    }
    return houmonRehabilitationTimeContenaBeginTimeContainer;
  }

  /**
   * 開始時刻コンボモデルを取得します。
   * @return 開始時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getHoumonRehabilitationTimeContenaBeginTimeModel(){
    if(houmonRehabilitationTimeContenaBeginTimeModel==null){
      houmonRehabilitationTimeContenaBeginTimeModel = new ACComboBoxModelAdapter();
      addHoumonRehabilitationTimeContenaBeginTimeModel();
    }
    return houmonRehabilitationTimeContenaBeginTimeModel;
  }

  /**
   * 終了時刻コンボを取得します。
   * @return 終了時刻コンボ
   */
  public ACTimeComboBox getHoumonRehabilitationTimeContenaEndTime(){
    if(houmonRehabilitationTimeContenaEndTime==null){

      houmonRehabilitationTimeContenaEndTime = new ACTimeComboBox();

      getHoumonRehabilitationTimeContenaEndTimeContainer().setText("終了時刻");

      houmonRehabilitationTimeContenaEndTime.setBindPath("4");

      houmonRehabilitationTimeContenaEndTime.setModelBindPath("4");

      houmonRehabilitationTimeContenaEndTime.setModel(getHoumonRehabilitationTimeContenaEndTimeModel());

      houmonRehabilitationTimeContenaEndTime.setRenderBindPath("CONTENT");

      addHoumonRehabilitationTimeContenaEndTime();
    }
    return houmonRehabilitationTimeContenaEndTime;

  }

  /**
   * 終了時刻コンボコンテナを取得します。
   * @return 終了時刻コンボコンテナ
   */
  protected ACLabelContainer getHoumonRehabilitationTimeContenaEndTimeContainer(){
    if(houmonRehabilitationTimeContenaEndTimeContainer==null){
      houmonRehabilitationTimeContenaEndTimeContainer = new ACLabelContainer();
      houmonRehabilitationTimeContenaEndTimeContainer.setFollowChildEnabled(true);
      houmonRehabilitationTimeContenaEndTimeContainer.add(getHoumonRehabilitationTimeContenaEndTime(), null);
    }
    return houmonRehabilitationTimeContenaEndTimeContainer;
  }

  /**
   * 終了時刻コンボモデルを取得します。
   * @return 終了時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getHoumonRehabilitationTimeContenaEndTimeModel(){
    if(houmonRehabilitationTimeContenaEndTimeModel==null){
      houmonRehabilitationTimeContenaEndTimeModel = new ACComboBoxModelAdapter();
      addHoumonRehabilitationTimeContenaEndTimeModel();
    }
    return houmonRehabilitationTimeContenaEndTimeModel;
  }

  /**
   * 施設区分を取得します。
   * @return 施設区分
   */
  public ACClearableRadioButtonGroup getHoumonRehabilitationTimeContenaFacilityDivision(){
    if(houmonRehabilitationTimeContenaFacilityDivision==null){

      houmonRehabilitationTimeContenaFacilityDivision = new ACClearableRadioButtonGroup();

      getHoumonRehabilitationTimeContenaFacilityDivisionContainer().setText("施設区分");

      houmonRehabilitationTimeContenaFacilityDivision.setBindPath("1160103");

      houmonRehabilitationTimeContenaFacilityDivision.setModel(getHoumonRehabilitationTimeContenaFacilityDivisionModel());

      houmonRehabilitationTimeContenaFacilityDivision.setUseClearButton(false);

      addHoumonRehabilitationTimeContenaFacilityDivision();
    }
    return houmonRehabilitationTimeContenaFacilityDivision;

  }

  /**
   * 施設区分コンテナを取得します。
   * @return 施設区分コンテナ
   */
  protected ACLabelContainer getHoumonRehabilitationTimeContenaFacilityDivisionContainer(){
    if(houmonRehabilitationTimeContenaFacilityDivisionContainer==null){
      houmonRehabilitationTimeContenaFacilityDivisionContainer = new ACLabelContainer();
      houmonRehabilitationTimeContenaFacilityDivisionContainer.setFollowChildEnabled(true);
      houmonRehabilitationTimeContenaFacilityDivisionContainer.add(getHoumonRehabilitationTimeContenaFacilityDivision(), null);
    }
    return houmonRehabilitationTimeContenaFacilityDivisionContainer;
  }

  /**
   * 施設区分モデルを取得します。
   * @return 施設区分モデル
   */
  protected ACListModelAdapter getHoumonRehabilitationTimeContenaFacilityDivisionModel(){
    if(houmonRehabilitationTimeContenaFacilityDivisionModel==null){
      houmonRehabilitationTimeContenaFacilityDivisionModel = new ACListModelAdapter();
      addHoumonRehabilitationTimeContenaFacilityDivisionModel();
    }
    return houmonRehabilitationTimeContenaFacilityDivisionModel;
  }

  /**
   * 通常規模医療機関を取得します。
   * @return 通常規模医療機関
   */
  public ACRadioButtonItem getHoumonRehabilitationMedicalInstitution(){
    if(houmonRehabilitationMedicalInstitution==null){

      houmonRehabilitationMedicalInstitution = new ACRadioButtonItem();

      houmonRehabilitationMedicalInstitution.setText("通常規模医療機関");

      houmonRehabilitationMedicalInstitution.setGroup(getHoumonRehabilitationTimeContenaFacilityDivision());

      houmonRehabilitationMedicalInstitution.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationMedicalInstitution();
    }
    return houmonRehabilitationMedicalInstitution;

  }

  /**
   * 小規模診療所を取得します。
   * @return 小規模診療所
   */
  public ACRadioButtonItem getHoumonRehabilitationDouble(){
    if(houmonRehabilitationDouble==null){

      houmonRehabilitationDouble = new ACRadioButtonItem();

      houmonRehabilitationDouble.setText("小規模診療所");

      houmonRehabilitationDouble.setGroup(getHoumonRehabilitationTimeContenaFacilityDivision());

      houmonRehabilitationDouble.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonRehabilitationDouble();
    }
    return houmonRehabilitationDouble;

  }

  /**
   * 介護老人保健施設を取得します。
   * @return 介護老人保健施設
   */
  public ACRadioButtonItem getHoumonRehabilitationClinic(){
    if(houmonRehabilitationClinic==null){

      houmonRehabilitationClinic = new ACRadioButtonItem();

      houmonRehabilitationClinic.setText("介護老人保健施設");

      houmonRehabilitationClinic.setGroup(getHoumonRehabilitationTimeContenaFacilityDivision());

      houmonRehabilitationClinic.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationClinic();
    }
    return houmonRehabilitationClinic;

  }

  /**
   * 時間区分を取得します。
   * @return 時間区分
   */
  public ACComboBox getHoumonRehabilitationTimeDivision(){
    if(houmonRehabilitationTimeDivision==null){

      houmonRehabilitationTimeDivision = new ACComboBox();

      getHoumonRehabilitationTimeDivisionContainer().setText("時間区分");

      houmonRehabilitationTimeDivision.setBindPath("1160104");

      houmonRehabilitationTimeDivision.setEditable(false);

      houmonRehabilitationTimeDivision.setModelBindPath("1160104");

      houmonRehabilitationTimeDivision.setModel(getHoumonRehabilitationTimeDivisionModel());

      houmonRehabilitationTimeDivision.setRenderBindPath("CONTENT");

      addHoumonRehabilitationTimeDivision();
    }
    return houmonRehabilitationTimeDivision;

  }

  /**
   * 時間区分コンテナを取得します。
   * @return 時間区分コンテナ
   */
  protected ACLabelContainer getHoumonRehabilitationTimeDivisionContainer(){
    if(houmonRehabilitationTimeDivisionContainer==null){
      houmonRehabilitationTimeDivisionContainer = new ACLabelContainer();
      houmonRehabilitationTimeDivisionContainer.setFollowChildEnabled(true);
      houmonRehabilitationTimeDivisionContainer.add(getHoumonRehabilitationTimeDivision(), null);
    }
    return houmonRehabilitationTimeDivisionContainer;
  }

  /**
   * 時間区分モデルを取得します。
   * @return 時間区分モデル
   */
  protected ACComboBoxModelAdapter getHoumonRehabilitationTimeDivisionModel(){
    if(houmonRehabilitationTimeDivisionModel==null){
      houmonRehabilitationTimeDivisionModel = new ACComboBoxModelAdapter();
      addHoumonRehabilitationTimeDivisionModel();
    }
    return houmonRehabilitationTimeDivisionModel;
  }

  /**
   * 入浴加算を取得します。
   * @return 入浴加算
   */
  public ACClearableRadioButtonGroup getHoumonRehabilitationBathRadio(){
    if(houmonRehabilitationBathRadio==null){

      houmonRehabilitationBathRadio = new ACClearableRadioButtonGroup();

      getHoumonRehabilitationBathRadioContainer().setText("入浴加算");

      houmonRehabilitationBathRadio.setBindPath("1160105");

      houmonRehabilitationBathRadio.setModel(getHoumonRehabilitationBathRadioModel());

      houmonRehabilitationBathRadio.setUseClearButton(false);

      addHoumonRehabilitationBathRadio();
    }
    return houmonRehabilitationBathRadio;

  }

  /**
   * 入浴加算コンテナを取得します。
   * @return 入浴加算コンテナ
   */
  protected ACLabelContainer getHoumonRehabilitationBathRadioContainer(){
    if(houmonRehabilitationBathRadioContainer==null){
      houmonRehabilitationBathRadioContainer = new ACLabelContainer();
      houmonRehabilitationBathRadioContainer.setFollowChildEnabled(true);
      houmonRehabilitationBathRadioContainer.add(getHoumonRehabilitationBathRadio(), null);
    }
    return houmonRehabilitationBathRadioContainer;
  }

  /**
   * 入浴加算モデルを取得します。
   * @return 入浴加算モデル
   */
  protected ACListModelAdapter getHoumonRehabilitationBathRadioModel(){
    if(houmonRehabilitationBathRadioModel==null){
      houmonRehabilitationBathRadioModel = new ACListModelAdapter();
      addHoumonRehabilitationBathRadioModel();
    }
    return houmonRehabilitationBathRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonRehabilitationBathRadioItem1(){
    if(houmonRehabilitationBathRadioItem1==null){

      houmonRehabilitationBathRadioItem1 = new ACRadioButtonItem();

      houmonRehabilitationBathRadioItem1.setText("なし");

      houmonRehabilitationBathRadioItem1.setGroup(getHoumonRehabilitationBathRadio());

      houmonRehabilitationBathRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationBathRadioItem1();
    }
    return houmonRehabilitationBathRadioItem1;

  }

  /**
   * 通常を取得します。
   * @return 通常
   */
  public ACRadioButtonItem getHoumonRehabilitationBathRadioItem2(){
    if(houmonRehabilitationBathRadioItem2==null){

      houmonRehabilitationBathRadioItem2 = new ACRadioButtonItem();

      houmonRehabilitationBathRadioItem2.setText("通常入浴");

      houmonRehabilitationBathRadioItem2.setGroup(getHoumonRehabilitationBathRadio());

      houmonRehabilitationBathRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationBathRadioItem2();
    }
    return houmonRehabilitationBathRadioItem2;

  }

  /**
   * 特別入浴を取得します。
   * @return 特別入浴
   */
  public ACRadioButtonItem getHoumonRehabilitationBathRadioItem3(){
    if(houmonRehabilitationBathRadioItem3==null){

      houmonRehabilitationBathRadioItem3 = new ACRadioButtonItem();

      houmonRehabilitationBathRadioItem3.setText("特別入浴");

      houmonRehabilitationBathRadioItem3.setGroup(getHoumonRehabilitationBathRadio());

      houmonRehabilitationBathRadioItem3.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationBathRadioItem3();
    }
    return houmonRehabilitationBathRadioItem3;

  }

  /**
   * 送迎区分を取得します。
   * @return 送迎区分
   */
  public ACClearableRadioButtonGroup getHoumonRehabilitationMeetingAndSendingOff(){
    if(houmonRehabilitationMeetingAndSendingOff==null){

      houmonRehabilitationMeetingAndSendingOff = new ACClearableRadioButtonGroup();

      getHoumonRehabilitationMeetingAndSendingOffContainer().setText("送迎加算");

      houmonRehabilitationMeetingAndSendingOff.setBindPath("6");

      houmonRehabilitationMeetingAndSendingOff.setModel(getHoumonRehabilitationMeetingAndSendingOffModel());

      houmonRehabilitationMeetingAndSendingOff.setUseClearButton(false);

      addHoumonRehabilitationMeetingAndSendingOff();
    }
    return houmonRehabilitationMeetingAndSendingOff;

  }

  /**
   * 送迎区分コンテナを取得します。
   * @return 送迎区分コンテナ
   */
  protected ACLabelContainer getHoumonRehabilitationMeetingAndSendingOffContainer(){
    if(houmonRehabilitationMeetingAndSendingOffContainer==null){
      houmonRehabilitationMeetingAndSendingOffContainer = new ACLabelContainer();
      houmonRehabilitationMeetingAndSendingOffContainer.setFollowChildEnabled(true);
      houmonRehabilitationMeetingAndSendingOffContainer.add(getHoumonRehabilitationMeetingAndSendingOff(), null);
    }
    return houmonRehabilitationMeetingAndSendingOffContainer;
  }

  /**
   * 送迎区分モデルを取得します。
   * @return 送迎区分モデル
   */
  protected ACListModelAdapter getHoumonRehabilitationMeetingAndSendingOffModel(){
    if(houmonRehabilitationMeetingAndSendingOffModel==null){
      houmonRehabilitationMeetingAndSendingOffModel = new ACListModelAdapter();
      addHoumonRehabilitationMeetingAndSendingOffModel();
    }
    return houmonRehabilitationMeetingAndSendingOffModel;
  }

  /**
   * 送迎なしを取得します。
   * @return 送迎なし
   */
  public ACRadioButtonItem getHoumonRehabilitationMeetingAndSendingOffNone(){
    if(houmonRehabilitationMeetingAndSendingOffNone==null){

      houmonRehabilitationMeetingAndSendingOffNone = new ACRadioButtonItem();

      houmonRehabilitationMeetingAndSendingOffNone.setText("送迎なし");

      houmonRehabilitationMeetingAndSendingOffNone.setGroup(getHoumonRehabilitationMeetingAndSendingOff());

      houmonRehabilitationMeetingAndSendingOffNone.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationMeetingAndSendingOffNone();
    }
    return houmonRehabilitationMeetingAndSendingOffNone;

  }

  /**
   * 送迎片道を取得します。
   * @return 送迎片道
   */
  public ACRadioButtonItem getHoumonRehabilitationMeetingAndSendingOffOneWay(){
    if(houmonRehabilitationMeetingAndSendingOffOneWay==null){

      houmonRehabilitationMeetingAndSendingOffOneWay = new ACRadioButtonItem();

      houmonRehabilitationMeetingAndSendingOffOneWay.setText("送迎片道");

      houmonRehabilitationMeetingAndSendingOffOneWay.setGroup(getHoumonRehabilitationMeetingAndSendingOff());

      houmonRehabilitationMeetingAndSendingOffOneWay.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationMeetingAndSendingOffOneWay();
    }
    return houmonRehabilitationMeetingAndSendingOffOneWay;

  }

  /**
   * 送迎往復を取得します。
   * @return 送迎往復
   */
  public ACRadioButtonItem getHoumonRehabilitationMeetingAndSendingOffRoundTrip(){
    if(houmonRehabilitationMeetingAndSendingOffRoundTrip==null){

      houmonRehabilitationMeetingAndSendingOffRoundTrip = new ACRadioButtonItem();

      houmonRehabilitationMeetingAndSendingOffRoundTrip.setText("送迎往復");

      houmonRehabilitationMeetingAndSendingOffRoundTrip.setGroup(getHoumonRehabilitationMeetingAndSendingOff());

      houmonRehabilitationMeetingAndSendingOffRoundTrip.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationMeetingAndSendingOffRoundTrip();
    }
    return houmonRehabilitationMeetingAndSendingOffRoundTrip;

  }

  /**
   * リハビリ訪問指導加算を取得します。
   * @return リハビリ訪問指導加算
   */
  public ACClearableRadioButtonGroup getHoumonRehabilitationAdditionTreatmentPersonRadio(){
    if(houmonRehabilitationAdditionTreatmentPersonRadio==null){

      houmonRehabilitationAdditionTreatmentPersonRadio = new ACClearableRadioButtonGroup();

      getHoumonRehabilitationAdditionTreatmentPersonRadioContainer().setText("リハビリ訪問指導加算");

      houmonRehabilitationAdditionTreatmentPersonRadio.setBindPath("1160107");

      houmonRehabilitationAdditionTreatmentPersonRadio.setModel(getHoumonRehabilitationAdditionTreatmentPersonRadioModel());

      houmonRehabilitationAdditionTreatmentPersonRadio.setUseClearButton(false);

      addHoumonRehabilitationAdditionTreatmentPersonRadio();
    }
    return houmonRehabilitationAdditionTreatmentPersonRadio;

  }

  /**
   * リハビリ訪問指導加算コンテナを取得します。
   * @return リハビリ訪問指導加算コンテナ
   */
  protected ACLabelContainer getHoumonRehabilitationAdditionTreatmentPersonRadioContainer(){
    if(houmonRehabilitationAdditionTreatmentPersonRadioContainer==null){
      houmonRehabilitationAdditionTreatmentPersonRadioContainer = new ACLabelContainer();
      houmonRehabilitationAdditionTreatmentPersonRadioContainer.setFollowChildEnabled(true);
      houmonRehabilitationAdditionTreatmentPersonRadioContainer.add(getHoumonRehabilitationAdditionTreatmentPersonRadio(), null);
    }
    return houmonRehabilitationAdditionTreatmentPersonRadioContainer;
  }

  /**
   * リハビリ訪問指導加算モデルを取得します。
   * @return リハビリ訪問指導加算モデル
   */
  protected ACListModelAdapter getHoumonRehabilitationAdditionTreatmentPersonRadioModel(){
    if(houmonRehabilitationAdditionTreatmentPersonRadioModel==null){
      houmonRehabilitationAdditionTreatmentPersonRadioModel = new ACListModelAdapter();
      addHoumonRehabilitationAdditionTreatmentPersonRadioModel();
    }
    return houmonRehabilitationAdditionTreatmentPersonRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonRehabilitationAdditionTreatmentPersonRadioItem1(){
    if(houmonRehabilitationAdditionTreatmentPersonRadioItem1==null){

      houmonRehabilitationAdditionTreatmentPersonRadioItem1 = new ACRadioButtonItem();

      houmonRehabilitationAdditionTreatmentPersonRadioItem1.setText("なし");

      houmonRehabilitationAdditionTreatmentPersonRadioItem1.setGroup(getHoumonRehabilitationAdditionTreatmentPersonRadio());

      houmonRehabilitationAdditionTreatmentPersonRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationAdditionTreatmentPersonRadioItem1();
    }
    return houmonRehabilitationAdditionTreatmentPersonRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHoumonRehabilitationAdditionTreatmentPersonRadioItem2(){
    if(houmonRehabilitationAdditionTreatmentPersonRadioItem2==null){

      houmonRehabilitationAdditionTreatmentPersonRadioItem2 = new ACRadioButtonItem();

      houmonRehabilitationAdditionTreatmentPersonRadioItem2.setText("あり");

      houmonRehabilitationAdditionTreatmentPersonRadioItem2.setGroup(getHoumonRehabilitationAdditionTreatmentPersonRadio());

      houmonRehabilitationAdditionTreatmentPersonRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationAdditionTreatmentPersonRadioItem2();
    }
    return houmonRehabilitationAdditionTreatmentPersonRadioItem2;

  }

  /**
   * 個別リハを取得します。
   * @return 個別リハ
   */
  public ACClearableRadioButtonGroup getHoumonRehabilitationIndividualRadio(){
    if(houmonRehabilitationIndividualRadio==null){

      houmonRehabilitationIndividualRadio = new ACClearableRadioButtonGroup();

      getHoumonRehabilitationIndividualRadioContainer().setText("個別リハビリ加算");

      houmonRehabilitationIndividualRadio.setBindPath("1160108");

      houmonRehabilitationIndividualRadio.setModel(getHoumonRehabilitationIndividualRadioModel());

      houmonRehabilitationIndividualRadio.setUseClearButton(false);

      addHoumonRehabilitationIndividualRadio();
    }
    return houmonRehabilitationIndividualRadio;

  }

  /**
   * 個別リハコンテナを取得します。
   * @return 個別リハコンテナ
   */
  protected ACLabelContainer getHoumonRehabilitationIndividualRadioContainer(){
    if(houmonRehabilitationIndividualRadioContainer==null){
      houmonRehabilitationIndividualRadioContainer = new ACLabelContainer();
      houmonRehabilitationIndividualRadioContainer.setFollowChildEnabled(true);
      houmonRehabilitationIndividualRadioContainer.add(getHoumonRehabilitationIndividualRadio(), null);
    }
    return houmonRehabilitationIndividualRadioContainer;
  }

  /**
   * 個別リハモデルを取得します。
   * @return 個別リハモデル
   */
  protected ACListModelAdapter getHoumonRehabilitationIndividualRadioModel(){
    if(houmonRehabilitationIndividualRadioModel==null){
      houmonRehabilitationIndividualRadioModel = new ACListModelAdapter();
      addHoumonRehabilitationIndividualRadioModel();
    }
    return houmonRehabilitationIndividualRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonRehabilitationIndividualRadioItem1(){
    if(houmonRehabilitationIndividualRadioItem1==null){

      houmonRehabilitationIndividualRadioItem1 = new ACRadioButtonItem();

      houmonRehabilitationIndividualRadioItem1.setText("なし");

      houmonRehabilitationIndividualRadioItem1.setGroup(getHoumonRehabilitationIndividualRadio());

      houmonRehabilitationIndividualRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonRehabilitationIndividualRadioItem1();
    }
    return houmonRehabilitationIndividualRadioItem1;

  }

  /**
   * 退院・退所後１年以内を取得します。
   * @return 退院・退所後１年以内
   */
  public ACRadioButtonItem getHoumonRehabilitationIndividualRadioItem2(){
    if(houmonRehabilitationIndividualRadioItem2==null){

      houmonRehabilitationIndividualRadioItem2 = new ACRadioButtonItem();

      houmonRehabilitationIndividualRadioItem2.setText("退院・退所後１年以内");

      houmonRehabilitationIndividualRadioItem2.setGroup(getHoumonRehabilitationIndividualRadio());

      houmonRehabilitationIndividualRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonRehabilitationIndividualRadioItem2();
    }
    return houmonRehabilitationIndividualRadioItem2;

  }

  /**
   * 退院・退所後１年超を取得します。
   * @return 退院・退所後１年超
   */
  public ACRadioButtonItem getHoumonRehabilitationIndividualRadioItem3(){
    if(houmonRehabilitationIndividualRadioItem3==null){

      houmonRehabilitationIndividualRadioItem3 = new ACRadioButtonItem();

      houmonRehabilitationIndividualRadioItem3.setText("退院・退所後１年超");

      houmonRehabilitationIndividualRadioItem3.setGroup(getHoumonRehabilitationIndividualRadio());

      houmonRehabilitationIndividualRadioItem3.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationIndividualRadioItem3();
    }
    return houmonRehabilitationIndividualRadioItem3;

  }

  /**
   * タブ2を取得します。
   * @return タブ2
   */
  public ACPanel getTab2(){
    if(tab2==null){

      tab2 = new ACPanel();

      tab2.setHgap(0);

      addTab2();
    }
    return tab2;

  }

  /**
   * 人員減算を取得します。
   * @return 人員減算
   */
  public ACClearableRadioButtonGroup getHoumonRehabilitationSubtraction(){
    if(houmonRehabilitationSubtraction==null){

      houmonRehabilitationSubtraction = new ACClearableRadioButtonGroup();

      getHoumonRehabilitationSubtractionContainer().setText("人員減算");

      houmonRehabilitationSubtraction.setBindPath("1160109");

      houmonRehabilitationSubtraction.setModel(getHoumonRehabilitationSubtractionModel());

      houmonRehabilitationSubtraction.setUseClearButton(false);

      addHoumonRehabilitationSubtraction();
    }
    return houmonRehabilitationSubtraction;

  }

  /**
   * 人員減算コンテナを取得します。
   * @return 人員減算コンテナ
   */
  protected ACLabelContainer getHoumonRehabilitationSubtractionContainer(){
    if(houmonRehabilitationSubtractionContainer==null){
      houmonRehabilitationSubtractionContainer = new ACLabelContainer();
      houmonRehabilitationSubtractionContainer.setFollowChildEnabled(true);
      houmonRehabilitationSubtractionContainer.add(getHoumonRehabilitationSubtraction(), null);
    }
    return houmonRehabilitationSubtractionContainer;
  }

  /**
   * 人員減算モデルを取得します。
   * @return 人員減算モデル
   */
  protected ACListModelAdapter getHoumonRehabilitationSubtractionModel(){
    if(houmonRehabilitationSubtractionModel==null){
      houmonRehabilitationSubtractionModel = new ACListModelAdapter();
      addHoumonRehabilitationSubtractionModel();
    }
    return houmonRehabilitationSubtractionModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonRehabilitationSubtractionNot(){
    if(houmonRehabilitationSubtractionNot==null){

      houmonRehabilitationSubtractionNot = new ACRadioButtonItem();

      houmonRehabilitationSubtractionNot.setText("なし");

      houmonRehabilitationSubtractionNot.setGroup(getHoumonRehabilitationSubtraction());

      houmonRehabilitationSubtractionNot.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationSubtractionNot();
    }
    return houmonRehabilitationSubtractionNot;

  }

  /**
   * 定員超過を取得します。
   * @return 定員超過
   */
  public ACRadioButtonItem getHoumonRehabilitationSubtractionExcess(){
    if(houmonRehabilitationSubtractionExcess==null){

      houmonRehabilitationSubtractionExcess = new ACRadioButtonItem();

      houmonRehabilitationSubtractionExcess.setText("定員超過");

      houmonRehabilitationSubtractionExcess.setGroup(getHoumonRehabilitationSubtraction());

      houmonRehabilitationSubtractionExcess.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonRehabilitationSubtractionExcess();
    }
    return houmonRehabilitationSubtractionExcess;

  }

  /**
   * 医師、PT・OT・ST、看護・介護職員の不足を取得します。
   * @return 医師、PT・OT・ST、看護・介護職員の不足
   */
  public ACRadioButtonItem getHoumonRehabilitationSubtractionLack(){
    if(houmonRehabilitationSubtractionLack==null){

      houmonRehabilitationSubtractionLack = new ACRadioButtonItem();

      houmonRehabilitationSubtractionLack.setText("<html>医師、PT・OT・ST、<br>看護・介護職員の不足</html>");

      houmonRehabilitationSubtractionLack.setGroup(getHoumonRehabilitationSubtraction());

      houmonRehabilitationSubtractionLack.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationSubtractionLack();
    }
    return houmonRehabilitationSubtractionLack;

  }

  /**
   * コンストラクタです。
   */
  public QS001009Design() {

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

    this.add(getTabs(), VRLayout.WEST);

  }

  /**
   * タブペインに内部項目を追加します。
   */
  protected void addTabs(){

    tabs.addTab("1", getTab1());

    tabs.addTab("2", getTab2());

  }

  /**
   * タブ1に内部項目を追加します。
   */
  protected void addTab1(){

    tab1.add(getHoumonRehabilitationTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    tab1.add(getHoumonRehabilitationTimeContenaFacilityDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonRehabilitationTimeDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonRehabilitationBathRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonRehabilitationMeetingAndSendingOffContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonRehabilitationAdditionTreatmentPersonRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonRehabilitationIndividualRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 提供時間コンテナに内部項目を追加します。
   */
  protected void addHoumonRehabilitationTimeContena(){

    houmonRehabilitationTimeContena.add(getHoumonRehabilitationTimeContenaBeginTimeContainer(), VRLayout.FLOW);

    houmonRehabilitationTimeContena.add(getHoumonRehabilitationTimeContenaEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * 開始時刻コンボに内部項目を追加します。
   */
  protected void addHoumonRehabilitationTimeContenaBeginTime(){

  }

  /**
   * 開始時刻コンボモデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationTimeContenaBeginTimeModel(){

  }

  /**
   * 終了時刻コンボに内部項目を追加します。
   */
  protected void addHoumonRehabilitationTimeContenaEndTime(){

  }

  /**
   * 終了時刻コンボモデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationTimeContenaEndTimeModel(){

  }

  /**
   * 施設区分に内部項目を追加します。
   */
  protected void addHoumonRehabilitationTimeContenaFacilityDivision(){

  }

  /**
   * 施設区分モデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationTimeContenaFacilityDivisionModel(){

    getHoumonRehabilitationMedicalInstitution().setButtonIndex(1);
    getHoumonRehabilitationTimeContenaFacilityDivisionModel().add(getHoumonRehabilitationMedicalInstitution());

    getHoumonRehabilitationDouble().setButtonIndex(2);
    getHoumonRehabilitationTimeContenaFacilityDivisionModel().add(getHoumonRehabilitationDouble());

    getHoumonRehabilitationClinic().setButtonIndex(3);
    getHoumonRehabilitationTimeContenaFacilityDivisionModel().add(getHoumonRehabilitationClinic());

  }

  /**
   * 通常規模医療機関に内部項目を追加します。
   */
  protected void addHoumonRehabilitationMedicalInstitution(){

  }

  /**
   * 小規模診療所に内部項目を追加します。
   */
  protected void addHoumonRehabilitationDouble(){

  }

  /**
   * 介護老人保健施設に内部項目を追加します。
   */
  protected void addHoumonRehabilitationClinic(){

  }

  /**
   * 時間区分に内部項目を追加します。
   */
  protected void addHoumonRehabilitationTimeDivision(){

  }

  /**
   * 時間区分モデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationTimeDivisionModel(){

  }

  /**
   * 入浴加算に内部項目を追加します。
   */
  protected void addHoumonRehabilitationBathRadio(){

  }

  /**
   * 入浴加算モデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationBathRadioModel(){

    getHoumonRehabilitationBathRadioItem1().setButtonIndex(1);
    getHoumonRehabilitationBathRadioModel().add(getHoumonRehabilitationBathRadioItem1());

    getHoumonRehabilitationBathRadioItem2().setButtonIndex(2);
    getHoumonRehabilitationBathRadioModel().add(getHoumonRehabilitationBathRadioItem2());

    getHoumonRehabilitationBathRadioItem3().setButtonIndex(3);
    getHoumonRehabilitationBathRadioModel().add(getHoumonRehabilitationBathRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonRehabilitationBathRadioItem1(){

  }

  /**
   * 通常に内部項目を追加します。
   */
  protected void addHoumonRehabilitationBathRadioItem2(){

  }

  /**
   * 特別入浴に内部項目を追加します。
   */
  protected void addHoumonRehabilitationBathRadioItem3(){

  }

  /**
   * 送迎区分に内部項目を追加します。
   */
  protected void addHoumonRehabilitationMeetingAndSendingOff(){

  }

  /**
   * 送迎区分モデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationMeetingAndSendingOffModel(){

    getHoumonRehabilitationMeetingAndSendingOffNone().setButtonIndex(1);
    getHoumonRehabilitationMeetingAndSendingOffModel().add(getHoumonRehabilitationMeetingAndSendingOffNone());

    getHoumonRehabilitationMeetingAndSendingOffOneWay().setButtonIndex(2);
    getHoumonRehabilitationMeetingAndSendingOffModel().add(getHoumonRehabilitationMeetingAndSendingOffOneWay());

    getHoumonRehabilitationMeetingAndSendingOffRoundTrip().setButtonIndex(3);
    getHoumonRehabilitationMeetingAndSendingOffModel().add(getHoumonRehabilitationMeetingAndSendingOffRoundTrip());

  }

  /**
   * 送迎なしに内部項目を追加します。
   */
  protected void addHoumonRehabilitationMeetingAndSendingOffNone(){

  }

  /**
   * 送迎片道に内部項目を追加します。
   */
  protected void addHoumonRehabilitationMeetingAndSendingOffOneWay(){

  }

  /**
   * 送迎往復に内部項目を追加します。
   */
  protected void addHoumonRehabilitationMeetingAndSendingOffRoundTrip(){

  }

  /**
   * リハビリ訪問指導加算に内部項目を追加します。
   */
  protected void addHoumonRehabilitationAdditionTreatmentPersonRadio(){

  }

  /**
   * リハビリ訪問指導加算モデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationAdditionTreatmentPersonRadioModel(){

    getHoumonRehabilitationAdditionTreatmentPersonRadioItem1().setButtonIndex(1);
    getHoumonRehabilitationAdditionTreatmentPersonRadioModel().add(getHoumonRehabilitationAdditionTreatmentPersonRadioItem1());

    getHoumonRehabilitationAdditionTreatmentPersonRadioItem2().setButtonIndex(2);
    getHoumonRehabilitationAdditionTreatmentPersonRadioModel().add(getHoumonRehabilitationAdditionTreatmentPersonRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonRehabilitationAdditionTreatmentPersonRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHoumonRehabilitationAdditionTreatmentPersonRadioItem2(){

  }

  /**
   * 個別リハに内部項目を追加します。
   */
  protected void addHoumonRehabilitationIndividualRadio(){

  }

  /**
   * 個別リハモデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationIndividualRadioModel(){

    getHoumonRehabilitationIndividualRadioItem1().setButtonIndex(1);
    getHoumonRehabilitationIndividualRadioModel().add(getHoumonRehabilitationIndividualRadioItem1());

    getHoumonRehabilitationIndividualRadioItem2().setButtonIndex(2);
    getHoumonRehabilitationIndividualRadioModel().add(getHoumonRehabilitationIndividualRadioItem2());

    getHoumonRehabilitationIndividualRadioItem3().setButtonIndex(3);
    getHoumonRehabilitationIndividualRadioModel().add(getHoumonRehabilitationIndividualRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonRehabilitationIndividualRadioItem1(){

  }

  /**
   * 退院・退所後１年以内に内部項目を追加します。
   */
  protected void addHoumonRehabilitationIndividualRadioItem2(){

  }

  /**
   * 退院・退所後１年超に内部項目を追加します。
   */
  protected void addHoumonRehabilitationIndividualRadioItem3(){

  }

  /**
   * タブ2に内部項目を追加します。
   */
  protected void addTab2(){

    tab2.add(getHoumonRehabilitationSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 人員減算に内部項目を追加します。
   */
  protected void addHoumonRehabilitationSubtraction(){

  }

  /**
   * 人員減算モデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationSubtractionModel(){

    getHoumonRehabilitationSubtractionNot().setButtonIndex(1);
    getHoumonRehabilitationSubtractionModel().add(getHoumonRehabilitationSubtractionNot());

    getHoumonRehabilitationSubtractionExcess().setButtonIndex(2);
    getHoumonRehabilitationSubtractionModel().add(getHoumonRehabilitationSubtractionExcess());

    getHoumonRehabilitationSubtractionLack().setButtonIndex(3);
    getHoumonRehabilitationSubtractionModel().add(getHoumonRehabilitationSubtractionLack());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonRehabilitationSubtractionNot(){

  }

  /**
   * 定員超過に内部項目を追加します。
   */
  protected void addHoumonRehabilitationSubtractionExcess(){

  }

  /**
   * 医師、PT・OT・ST、看護・介護職員の不足に内部項目を追加します。
   */
  protected void addHoumonRehabilitationSubtractionLack(){

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
      ACFrame.getInstance().getContentPane().add(new QS001009Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001009Design getThis() {
    return this;
  }
}
