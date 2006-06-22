
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
 * 作成日: 2006/01/10  日本コンピューター株式会社 小笠　貴志 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン訪問介護 (QS001003)
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
 * サービスパターン訪問介護画面項目デザイン(QS001003) 
 */
public class QS001003Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACPanel houmonKaigoPatterns;

  private ACComboBox houmonKaigoServicePattern;

  private ACLabelContainer houmonKaigoServicePatternContainer;

  private ACComboBoxModelAdapter houmonKaigoServicePatternModel;

  private ACComboBox homonkaigoTeikyoTime;

  private ACLabelContainer homonkaigoTeikyoTimeContainer;

  private ACComboBoxModelAdapter homonkaigoTeikyoTimeModel;

  private ACComboBox houmonKaigoInTime;

  private ACLabelContainer houmonKaigoInTimeContainer;

  private ACComboBoxModelAdapter houmonKaigoInTimeModel;

  private ACBackLabelContainer houmonKaigoTimeContainer;

  private ACTimeComboBox houmonKaigoBeginTime;

  private ACLabelContainer houmonKaigoBeginTimeContainer;

  private ACComboBoxModelAdapter houmonKaigoBeginTimeModel;

  private ACTimeComboBox houmonKaigoEndTime;

  private ACLabelContainer houmonKaigoEndTimeContainer;

  private ACComboBoxModelAdapter houmonKaigoEndTimeModel;

  private ACClearableRadioButtonGroup houmonKaigoClass;

  private ACLabelContainer houmonKaigoClassContainer;

  private ACListModelAdapter houmonKaigoClassModel;

  private ACRadioButtonItem houmonKaigoClassOther;

  private ACRadioButtonItem houmonKaigoClass3;

  private ACClearableRadioButtonGroup houmonKaigoNumberOfPeople;

  private ACLabelContainer houmonKaigoNumberOfPeopleContainer;

  private ACListModelAdapter houmonKaigoNumberOfPeopleModel;

  private ACRadioButtonItem houmonKaigoNumberOfPeople1;

  private ACRadioButtonItem houmonKaigoNumberOfPeople2;

  private ACClearableRadioButtonGroup houmonKaigoTimeZone;

  private ACLabelContainer houmonKaigoTimeZoneContainer;

  private ACListModelAdapter houmonKaigoTimeZoneModel;

  private ACRadioButtonItem houmonKaigoTimeZoneNormal;

  private ACRadioButtonItem houmonKaigoTimeZoneEarlyMorning;

  private ACRadioButtonItem houmonKaigoTimeZoneNighttime;

  private ACRadioButtonItem houmonKaigoTimeZoneMidnight;

  //getter

  /**
   * 訪問介護パターン領域を取得します。
   * @return 訪問介護パターン領域
   */
  public ACPanel getHoumonKaigoPatterns(){
    if(houmonKaigoPatterns==null){

      houmonKaigoPatterns = new ACPanel();

      addHoumonKaigoPatterns();
    }
    return houmonKaigoPatterns;

  }

  /**
   * サービスコンボを取得します。
   * @return サービスコンボ
   */
  public ACComboBox getHoumonKaigoServicePattern(){
    if(houmonKaigoServicePattern==null){

      houmonKaigoServicePattern = new ACComboBox();

      getHoumonKaigoServicePatternContainer().setText("訪問種別");

      houmonKaigoServicePattern.setBindPath("1110101");

      houmonKaigoServicePattern.setEditable(false);

      houmonKaigoServicePattern.setModelBindPath("1110101");

      houmonKaigoServicePattern.setModel(getHoumonKaigoServicePatternModel());

      houmonKaigoServicePattern.setRenderBindPath("CONTENT");

      addHoumonKaigoServicePattern();
    }
    return houmonKaigoServicePattern;

  }

  /**
   * サービスコンボコンテナを取得します。
   * @return サービスコンボコンテナ
   */
  protected ACLabelContainer getHoumonKaigoServicePatternContainer(){
    if(houmonKaigoServicePatternContainer==null){
      houmonKaigoServicePatternContainer = new ACLabelContainer();
      houmonKaigoServicePatternContainer.add(getHoumonKaigoServicePattern(), null);
    }
    return houmonKaigoServicePatternContainer;
  }

  /**
   * サービスコンボモデルを取得します。
   * @return サービスコンボモデル
   */
  protected ACComboBoxModelAdapter getHoumonKaigoServicePatternModel(){
    if(houmonKaigoServicePatternModel==null){
      houmonKaigoServicePatternModel = new ACComboBoxModelAdapter();
      addHoumonKaigoServicePatternModel();
    }
    return houmonKaigoServicePatternModel;
  }

  /**
   * 提供時間コンボを取得します。
   * @return 提供時間コンボ
   */
  public ACComboBox getHomonkaigoTeikyoTime(){
    if(homonkaigoTeikyoTime==null){

      homonkaigoTeikyoTime = new ACComboBox();

      getHomonkaigoTeikyoTimeContainer().setText("提供時間");

      homonkaigoTeikyoTime.setBindPath("1110105");

      homonkaigoTeikyoTime.setEditable(false);

      homonkaigoTeikyoTime.setModelBindPath("1110105");

      homonkaigoTeikyoTime.setModel(getHomonkaigoTeikyoTimeModel());

      homonkaigoTeikyoTime.setRenderBindPath("CONTENT");

      homonkaigoTeikyoTime.setBlankable(false);

      addHomonkaigoTeikyoTime();
    }
    return homonkaigoTeikyoTime;

  }

  /**
   * 提供時間コンボコンテナを取得します。
   * @return 提供時間コンボコンテナ
   */
  protected ACLabelContainer getHomonkaigoTeikyoTimeContainer(){
    if(homonkaigoTeikyoTimeContainer==null){
      homonkaigoTeikyoTimeContainer = new ACLabelContainer();
      homonkaigoTeikyoTimeContainer.add(getHomonkaigoTeikyoTime(), null);
    }
    return homonkaigoTeikyoTimeContainer;
  }

  /**
   * 提供時間コンボモデルを取得します。
   * @return 提供時間コンボモデル
   */
  protected ACComboBoxModelAdapter getHomonkaigoTeikyoTimeModel(){
    if(homonkaigoTeikyoTimeModel==null){
      homonkaigoTeikyoTimeModel = new ACComboBoxModelAdapter();
      addHomonkaigoTeikyoTimeModel();
    }
    return homonkaigoTeikyoTimeModel;
  }

  /**
   * うち身体時間コンボを取得します。
   * @return うち身体時間コンボ
   */
  public ACComboBox getHoumonKaigoInTime(){
    if(houmonKaigoInTime==null){

      houmonKaigoInTime = new ACComboBox();

      getHoumonKaigoInTimeContainer().setText("うち身体時間");

      houmonKaigoInTime.setBindPath("1110104");

      houmonKaigoInTime.setEditable(false);

      houmonKaigoInTime.setModelBindPath("1110104");

      houmonKaigoInTime.setModel(getHoumonKaigoInTimeModel());

      houmonKaigoInTime.setRenderBindPath("CONTENT");

      addHoumonKaigoInTime();
    }
    return houmonKaigoInTime;

  }

  /**
   * うち身体時間コンボコンテナを取得します。
   * @return うち身体時間コンボコンテナ
   */
  protected ACLabelContainer getHoumonKaigoInTimeContainer(){
    if(houmonKaigoInTimeContainer==null){
      houmonKaigoInTimeContainer = new ACLabelContainer();
      houmonKaigoInTimeContainer.add(getHoumonKaigoInTime(), null);
    }
    return houmonKaigoInTimeContainer;
  }

  /**
   * うち身体時間コンボモデルを取得します。
   * @return うち身体時間コンボモデル
   */
  protected ACComboBoxModelAdapter getHoumonKaigoInTimeModel(){
    if(houmonKaigoInTimeModel==null){
      houmonKaigoInTimeModel = new ACComboBoxModelAdapter();
      addHoumonKaigoInTimeModel();
    }
    return houmonKaigoInTimeModel;
  }

  /**
   * 提供時間コンテナを取得します。
   * @return 提供時間コンテナ
   */
  public ACBackLabelContainer getHoumonKaigoTimeContainer(){
    if(houmonKaigoTimeContainer==null){

      houmonKaigoTimeContainer = new ACBackLabelContainer();

      addHoumonKaigoTimeContainer();
    }
    return houmonKaigoTimeContainer;

  }

  /**
   * 開始時刻コンボを取得します。
   * @return 開始時刻コンボ
   */
  public ACTimeComboBox getHoumonKaigoBeginTime(){
    if(houmonKaigoBeginTime==null){

      houmonKaigoBeginTime = new ACTimeComboBox();

      getHoumonKaigoBeginTimeContainer().setText("開始時刻");

      houmonKaigoBeginTime.setBindPath("3");

      houmonKaigoBeginTime.setModelBindPath("3");

      houmonKaigoBeginTime.setModel(getHoumonKaigoBeginTimeModel());

      houmonKaigoBeginTime.setRenderBindPath("CONTENT");

      addHoumonKaigoBeginTime();
    }
    return houmonKaigoBeginTime;

  }

  /**
   * 開始時刻コンボコンテナを取得します。
   * @return 開始時刻コンボコンテナ
   */
  protected ACLabelContainer getHoumonKaigoBeginTimeContainer(){
    if(houmonKaigoBeginTimeContainer==null){
      houmonKaigoBeginTimeContainer = new ACLabelContainer();
      houmonKaigoBeginTimeContainer.add(getHoumonKaigoBeginTime(), null);
    }
    return houmonKaigoBeginTimeContainer;
  }

  /**
   * 開始時刻コンボモデルを取得します。
   * @return 開始時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getHoumonKaigoBeginTimeModel(){
    if(houmonKaigoBeginTimeModel==null){
      houmonKaigoBeginTimeModel = new ACComboBoxModelAdapter();
      addHoumonKaigoBeginTimeModel();
    }
    return houmonKaigoBeginTimeModel;
  }

  /**
   * 終了時刻コンボを取得します。
   * @return 終了時刻コンボ
   */
  public ACTimeComboBox getHoumonKaigoEndTime(){
    if(houmonKaigoEndTime==null){

      houmonKaigoEndTime = new ACTimeComboBox();

      getHoumonKaigoEndTimeContainer().setText("終了時刻");

      houmonKaigoEndTime.setBindPath("4");

      houmonKaigoEndTime.setModelBindPath("4");

      houmonKaigoEndTime.setModel(getHoumonKaigoEndTimeModel());

      houmonKaigoEndTime.setRenderBindPath("CONTENT");

      addHoumonKaigoEndTime();
    }
    return houmonKaigoEndTime;

  }

  /**
   * 終了時刻コンボコンテナを取得します。
   * @return 終了時刻コンボコンテナ
   */
  protected ACLabelContainer getHoumonKaigoEndTimeContainer(){
    if(houmonKaigoEndTimeContainer==null){
      houmonKaigoEndTimeContainer = new ACLabelContainer();
      houmonKaigoEndTimeContainer.add(getHoumonKaigoEndTime(), null);
    }
    return houmonKaigoEndTimeContainer;
  }

  /**
   * 終了時刻コンボモデルを取得します。
   * @return 終了時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getHoumonKaigoEndTimeModel(){
    if(houmonKaigoEndTimeModel==null){
      houmonKaigoEndTimeModel = new ACComboBoxModelAdapter();
      addHoumonKaigoEndTimeModel();
    }
    return houmonKaigoEndTimeModel;
  }

  /**
   * 訪問者の級職ラジオグループを取得します。
   * @return 訪問者の級職ラジオグループ
   */
  public ACClearableRadioButtonGroup getHoumonKaigoClass(){
    if(houmonKaigoClass==null){

      houmonKaigoClass = new ACClearableRadioButtonGroup();

      getHoumonKaigoClassContainer().setText("訪問者の級職");

      houmonKaigoClass.setBindPath("1110106");

      houmonKaigoClass.setModel(getHoumonKaigoClassModel());

      houmonKaigoClass.setUseClearButton(false);

      addHoumonKaigoClass();
    }
    return houmonKaigoClass;

  }

  /**
   * 訪問者の級職ラジオグループコンテナを取得します。
   * @return 訪問者の級職ラジオグループコンテナ
   */
  protected ACLabelContainer getHoumonKaigoClassContainer(){
    if(houmonKaigoClassContainer==null){
      houmonKaigoClassContainer = new ACLabelContainer();
      houmonKaigoClassContainer.add(getHoumonKaigoClass(), null);
    }
    return houmonKaigoClassContainer;
  }

  /**
   * 訪問者の級職ラジオグループモデルを取得します。
   * @return 訪問者の級職ラジオグループモデル
   */
  protected ACListModelAdapter getHoumonKaigoClassModel(){
    if(houmonKaigoClassModel==null){
      houmonKaigoClassModel = new ACListModelAdapter();
      addHoumonKaigoClassModel();
    }
    return houmonKaigoClassModel;
  }

  /**
   * ３級以外を取得します。
   * @return ３級以外
   */
  public ACRadioButtonItem getHoumonKaigoClassOther(){
    if(houmonKaigoClassOther==null){

      houmonKaigoClassOther = new ACRadioButtonItem();

      houmonKaigoClassOther.setText("3級以外");

      houmonKaigoClassOther.setGroup(getHoumonKaigoClass());

      addHoumonKaigoClassOther();
    }
    return houmonKaigoClassOther;

  }

  /**
   * ３級を取得します。
   * @return ３級
   */
  public ACRadioButtonItem getHoumonKaigoClass3(){
    if(houmonKaigoClass3==null){

      houmonKaigoClass3 = new ACRadioButtonItem();

      houmonKaigoClass3.setText("3級");

      houmonKaigoClass3.setGroup(getHoumonKaigoClass());

      addHoumonKaigoClass3();
    }
    return houmonKaigoClass3;

  }

  /**
   * 訪問人数ラジオグループを取得します。
   * @return 訪問人数ラジオグループ
   */
  public ACClearableRadioButtonGroup getHoumonKaigoNumberOfPeople(){
    if(houmonKaigoNumberOfPeople==null){

      houmonKaigoNumberOfPeople = new ACClearableRadioButtonGroup();

      getHoumonKaigoNumberOfPeopleContainer().setText("訪問人数");

      houmonKaigoNumberOfPeople.setBindPath("1110107");

      houmonKaigoNumberOfPeople.setModel(getHoumonKaigoNumberOfPeopleModel());

      houmonKaigoNumberOfPeople.setUseClearButton(false);

      addHoumonKaigoNumberOfPeople();
    }
    return houmonKaigoNumberOfPeople;

  }

  /**
   * 訪問人数ラジオグループコンテナを取得します。
   * @return 訪問人数ラジオグループコンテナ
   */
  protected ACLabelContainer getHoumonKaigoNumberOfPeopleContainer(){
    if(houmonKaigoNumberOfPeopleContainer==null){
      houmonKaigoNumberOfPeopleContainer = new ACLabelContainer();
      houmonKaigoNumberOfPeopleContainer.add(getHoumonKaigoNumberOfPeople(), null);
    }
    return houmonKaigoNumberOfPeopleContainer;
  }

  /**
   * 訪問人数ラジオグループモデルを取得します。
   * @return 訪問人数ラジオグループモデル
   */
  protected ACListModelAdapter getHoumonKaigoNumberOfPeopleModel(){
    if(houmonKaigoNumberOfPeopleModel==null){
      houmonKaigoNumberOfPeopleModel = new ACListModelAdapter();
      addHoumonKaigoNumberOfPeopleModel();
    }
    return houmonKaigoNumberOfPeopleModel;
  }

  /**
   * 1人を取得します。
   * @return 1人
   */
  public ACRadioButtonItem getHoumonKaigoNumberOfPeople1(){
    if(houmonKaigoNumberOfPeople1==null){

      houmonKaigoNumberOfPeople1 = new ACRadioButtonItem();

      houmonKaigoNumberOfPeople1.setText("1人");

      houmonKaigoNumberOfPeople1.setGroup(getHoumonKaigoNumberOfPeople());

      addHoumonKaigoNumberOfPeople1();
    }
    return houmonKaigoNumberOfPeople1;

  }

  /**
   * 2人を取得します。
   * @return 2人
   */
  public ACRadioButtonItem getHoumonKaigoNumberOfPeople2(){
    if(houmonKaigoNumberOfPeople2==null){

      houmonKaigoNumberOfPeople2 = new ACRadioButtonItem();

      houmonKaigoNumberOfPeople2.setText("2人");

      houmonKaigoNumberOfPeople2.setGroup(getHoumonKaigoNumberOfPeople());

      addHoumonKaigoNumberOfPeople2();
    }
    return houmonKaigoNumberOfPeople2;

  }

  /**
   * 時間帯ラジオグループを取得します。
   * @return 時間帯ラジオグループ
   */
  public ACClearableRadioButtonGroup getHoumonKaigoTimeZone(){
    if(houmonKaigoTimeZone==null){

      houmonKaigoTimeZone = new ACClearableRadioButtonGroup();

      getHoumonKaigoTimeZoneContainer().setText("時間帯");

      houmonKaigoTimeZone.setBindPath("1110108");

      houmonKaigoTimeZone.setModel(getHoumonKaigoTimeZoneModel());

      houmonKaigoTimeZone.setUseClearButton(false);

      addHoumonKaigoTimeZone();
    }
    return houmonKaigoTimeZone;

  }

  /**
   * 時間帯ラジオグループコンテナを取得します。
   * @return 時間帯ラジオグループコンテナ
   */
  protected ACLabelContainer getHoumonKaigoTimeZoneContainer(){
    if(houmonKaigoTimeZoneContainer==null){
      houmonKaigoTimeZoneContainer = new ACLabelContainer();
      houmonKaigoTimeZoneContainer.add(getHoumonKaigoTimeZone(), null);
    }
    return houmonKaigoTimeZoneContainer;
  }

  /**
   * 時間帯ラジオグループモデルを取得します。
   * @return 時間帯ラジオグループモデル
   */
  protected ACListModelAdapter getHoumonKaigoTimeZoneModel(){
    if(houmonKaigoTimeZoneModel==null){
      houmonKaigoTimeZoneModel = new ACListModelAdapter();
      addHoumonKaigoTimeZoneModel();
    }
    return houmonKaigoTimeZoneModel;
  }

  /**
   * 通常を取得します。
   * @return 通常
   */
  public ACRadioButtonItem getHoumonKaigoTimeZoneNormal(){
    if(houmonKaigoTimeZoneNormal==null){

      houmonKaigoTimeZoneNormal = new ACRadioButtonItem();

      houmonKaigoTimeZoneNormal.setText("通常");

      houmonKaigoTimeZoneNormal.setGroup(getHoumonKaigoTimeZone());

      addHoumonKaigoTimeZoneNormal();
    }
    return houmonKaigoTimeZoneNormal;

  }

  /**
   * 早朝を取得します。
   * @return 早朝
   */
  public ACRadioButtonItem getHoumonKaigoTimeZoneEarlyMorning(){
    if(houmonKaigoTimeZoneEarlyMorning==null){

      houmonKaigoTimeZoneEarlyMorning = new ACRadioButtonItem();

      houmonKaigoTimeZoneEarlyMorning.setText("早朝");

      houmonKaigoTimeZoneEarlyMorning.setGroup(getHoumonKaigoTimeZone());

      addHoumonKaigoTimeZoneEarlyMorning();
    }
    return houmonKaigoTimeZoneEarlyMorning;

  }

  /**
   * 夜間を取得します。
   * @return 夜間
   */
  public ACRadioButtonItem getHoumonKaigoTimeZoneNighttime(){
    if(houmonKaigoTimeZoneNighttime==null){

      houmonKaigoTimeZoneNighttime = new ACRadioButtonItem();

      houmonKaigoTimeZoneNighttime.setText("夜間");

      houmonKaigoTimeZoneNighttime.setGroup(getHoumonKaigoTimeZone());

      addHoumonKaigoTimeZoneNighttime();
    }
    return houmonKaigoTimeZoneNighttime;

  }

  /**
   * 深夜を取得します。
   * @return 深夜
   */
  public ACRadioButtonItem getHoumonKaigoTimeZoneMidnight(){
    if(houmonKaigoTimeZoneMidnight==null){

      houmonKaigoTimeZoneMidnight = new ACRadioButtonItem();

      houmonKaigoTimeZoneMidnight.setText("深夜");

      houmonKaigoTimeZoneMidnight.setGroup(getHoumonKaigoTimeZone());

      addHoumonKaigoTimeZoneMidnight();
    }
    return houmonKaigoTimeZoneMidnight;

  }

  /**
   * コンストラクタです。
   */
  public QS001003Design() {

    try {
      initialize();
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

    this.add(getHoumonKaigoPatterns(), VRLayout.WEST);

  }

  /**
   * 訪問介護パターン領域に内部項目を追加します。
   */
  protected void addHoumonKaigoPatterns(){

    houmonKaigoPatterns.add(getHoumonKaigoServicePatternContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonKaigoPatterns.add(getHomonkaigoTeikyoTimeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonKaigoPatterns.add(getHoumonKaigoInTimeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonKaigoPatterns.add(getHoumonKaigoTimeContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    houmonKaigoPatterns.add(getHoumonKaigoClassContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonKaigoPatterns.add(getHoumonKaigoNumberOfPeopleContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonKaigoPatterns.add(getHoumonKaigoTimeZoneContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * サービスコンボに内部項目を追加します。
   */
  protected void addHoumonKaigoServicePattern(){

  }

  /**
   * サービスコンボモデルに内部項目を追加します。
   */
  protected void addHoumonKaigoServicePatternModel(){

  }

  /**
   * 提供時間コンボに内部項目を追加します。
   */
  protected void addHomonkaigoTeikyoTime(){

  }

  /**
   * 提供時間コンボモデルに内部項目を追加します。
   */
  protected void addHomonkaigoTeikyoTimeModel(){

  }

  /**
   * うち身体時間コンボに内部項目を追加します。
   */
  protected void addHoumonKaigoInTime(){

  }

  /**
   * うち身体時間コンボモデルに内部項目を追加します。
   */
  protected void addHoumonKaigoInTimeModel(){

  }

  /**
   * 提供時間コンテナに内部項目を追加します。
   */
  protected void addHoumonKaigoTimeContainer(){

    houmonKaigoTimeContainer.add(getHoumonKaigoBeginTimeContainer(), VRLayout.FLOW);

    houmonKaigoTimeContainer.add(getHoumonKaigoEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * 開始時刻コンボに内部項目を追加します。
   */
  protected void addHoumonKaigoBeginTime(){

  }

  /**
   * 開始時刻コンボモデルに内部項目を追加します。
   */
  protected void addHoumonKaigoBeginTimeModel(){

  }

  /**
   * 終了時刻コンボに内部項目を追加します。
   */
  protected void addHoumonKaigoEndTime(){

  }

  /**
   * 終了時刻コンボモデルに内部項目を追加します。
   */
  protected void addHoumonKaigoEndTimeModel(){

  }

  /**
   * 訪問者の級職ラジオグループに内部項目を追加します。
   */
  protected void addHoumonKaigoClass(){

  }

  /**
   * 訪問者の級職ラジオグループモデルに内部項目を追加します。
   */
  protected void addHoumonKaigoClassModel(){

    getHoumonKaigoClassOther().setButtonIndex(0);
    getHoumonKaigoClassModel().add(getHoumonKaigoClassOther());

    getHoumonKaigoClass3().setButtonIndex(1);
    getHoumonKaigoClassModel().add(getHoumonKaigoClass3());

  }

  /**
   * ３級以外に内部項目を追加します。
   */
  protected void addHoumonKaigoClassOther(){

  }

  /**
   * ３級に内部項目を追加します。
   */
  protected void addHoumonKaigoClass3(){

  }

  /**
   * 訪問人数ラジオグループに内部項目を追加します。
   */
  protected void addHoumonKaigoNumberOfPeople(){

  }

  /**
   * 訪問人数ラジオグループモデルに内部項目を追加します。
   */
  protected void addHoumonKaigoNumberOfPeopleModel(){

    getHoumonKaigoNumberOfPeople1().setButtonIndex(0);
    getHoumonKaigoNumberOfPeopleModel().add(getHoumonKaigoNumberOfPeople1());

    getHoumonKaigoNumberOfPeople2().setButtonIndex(1);
    getHoumonKaigoNumberOfPeopleModel().add(getHoumonKaigoNumberOfPeople2());

  }

  /**
   * 1人に内部項目を追加します。
   */
  protected void addHoumonKaigoNumberOfPeople1(){

  }

  /**
   * 2人に内部項目を追加します。
   */
  protected void addHoumonKaigoNumberOfPeople2(){

  }

  /**
   * 時間帯ラジオグループに内部項目を追加します。
   */
  protected void addHoumonKaigoTimeZone(){

  }

  /**
   * 時間帯ラジオグループモデルに内部項目を追加します。
   */
  protected void addHoumonKaigoTimeZoneModel(){

    getHoumonKaigoTimeZoneNormal().setButtonIndex(0);
    getHoumonKaigoTimeZoneModel().add(getHoumonKaigoTimeZoneNormal());

    getHoumonKaigoTimeZoneEarlyMorning().setButtonIndex(1);
    getHoumonKaigoTimeZoneModel().add(getHoumonKaigoTimeZoneEarlyMorning());

    getHoumonKaigoTimeZoneNighttime().setButtonIndex(2);
    getHoumonKaigoTimeZoneModel().add(getHoumonKaigoTimeZoneNighttime());

    getHoumonKaigoTimeZoneMidnight().setButtonIndex(3);
    getHoumonKaigoTimeZoneModel().add(getHoumonKaigoTimeZoneMidnight());

  }

  /**
   * 通常に内部項目を追加します。
   */
  protected void addHoumonKaigoTimeZoneNormal(){

  }

  /**
   * 早朝に内部項目を追加します。
   */
  protected void addHoumonKaigoTimeZoneEarlyMorning(){

  }

  /**
   * 夜間に内部項目を追加します。
   */
  protected void addHoumonKaigoTimeZoneNighttime(){

  }

  /**
   * 深夜に内部項目を追加します。
   */
  protected void addHoumonKaigoTimeZoneMidnight(){

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
      ACFrame.getInstance().getContentPane().add(new QS001003Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001003Design getThis() {
    return this;
  }
}
