
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
 * 開発者: 堤 瑞樹
 * 作成日: 2006/01/31  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム 週間表 (QS001001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Color;
import java.awt.Component;
import java.awt.im.InputSubset;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACButton;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACIntegerCheckBox;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.ACTimeComboBox;
import jp.nichicom.ac.container.ACBackLabelContainer;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACComboBoxModelAdapter;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.component.QkanDateTextField;
/**
 * 週間表画面項目デザイン(QS001001) 
 */
public class QS001001Design extends ACPanel {
  //GUIコンポーネント

  private ACPanel contents;

  private ACGroupBox timeContentLabelWeeks;

  private ACPanel timeContentLabelWeeksLeft;

  private ACBackLabelContainer timeComboContainer;

  private ACTimeComboBox beginCombo;

  private ACLabelContainer beginComboContainer;

  private ACComboBoxModelAdapter beginComboModel;

  private ACLabel timeComboCaption;

  private ACTimeComboBox endCombo;

  private ACLabelContainer endComboContainer;

  private ACComboBoxModelAdapter endComboModel;

  private ACLabelContainer dayoftheWeekContainer;

  private ACIntegerCheckBox mondayCheck;

  private ACIntegerCheckBox tuesdayCheck;

  private ACIntegerCheckBox wednesdayCheck;

  private ACIntegerCheckBox thursdayCheck;

  private ACIntegerCheckBox fridayCheck;

  private ACIntegerCheckBox saturdayCheck;

  private ACIntegerCheckBox sundayCheck;

  private ACPanel timeButtons;

  private ACButton timeButton;

  private ACGroupBox exceptionServiceCombos;

  private ACBackLabelContainer exceptionComboContena;

  private ACComboBox exceptionBeginCombo;

  private ACLabelContainer exceptionBeginComboContainer;

  private ACComboBoxModelAdapter exceptionBeginComboModel;

  private ACLabel exceptionBeginLabel;

  private ACComboBox exceptionEndCombo;

  private ACLabelContainer exceptionEndComboContainer;

  private ACComboBoxModelAdapter exceptionEndComboModel;

  private ACLabel exceptionEndLabel;

  private ACButton everydayButton;

  private ACButton exceptionButton;

  private ACPanel weeklyCharts;

  private QS001WeekSchedule weeklySchedule;

  private ACPanel bottoms;

  private ACGroupBox nonWeeks;

  private QS001DaySchedule freedayServices;

  private ACPanel lowerRights;

  private ACGroupBox expansions;

  private ACLabelContainer expansionStartDateContainer;

  private ACTextField expansionStartDate;

  private ACLabel expansionStartDateCaption;

  private ACButton expansionButton;

  private ACGroupBox weeklyServicePlans;

  private QkanDateTextField createDate;

  private ACLabelContainer createDateContainer;

  //getter

  /**
   * クライアント領域を取得します。
   * @return クライアント領域
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      addContents();
    }
    return contents;

  }

  /**
   * 時刻曜日設定ラベル統括領域を取得します。
   * @return 時刻曜日設定ラベル統括領域
   */
  public ACGroupBox getTimeContentLabelWeeks(){
    if(timeContentLabelWeeks==null){

      timeContentLabelWeeks = new ACGroupBox();

      timeContentLabelWeeks.setText("３．時刻・曜日の選択");

      addTimeContentLabelWeeks();
    }
    return timeContentLabelWeeks;

  }

  /**
   * 時刻曜日設定ラベル統括領域左を取得します。
   * @return 時刻曜日設定ラベル統括領域左
   */
  public ACPanel getTimeContentLabelWeeksLeft(){
    if(timeContentLabelWeeksLeft==null){

      timeContentLabelWeeksLeft = new ACPanel();

      addTimeContentLabelWeeksLeft();
    }
    return timeContentLabelWeeksLeft;

  }

  /**
   * コンボコンテナを取得します。
   * @return コンボコンテナ
   */
  public ACBackLabelContainer getTimeComboContainer(){
    if(timeComboContainer==null){

      timeComboContainer = new ACBackLabelContainer();

      timeComboContainer.setText("時刻");

      addTimeComboContainer();
    }
    return timeComboContainer;

  }

  /**
   * 開始時刻コンボを取得します。
   * @return 開始時刻コンボ
   */
  public ACTimeComboBox getBeginCombo(){
    if(beginCombo==null){

      beginCombo = new ACTimeComboBox();

      beginCombo.setBindPath("3");

      beginCombo.setModelBindPath("3");

      beginCombo.setModel(getBeginComboModel());

      beginCombo.setRenderBindPath("CONTENT");

      addBeginCombo();
    }
    return beginCombo;

  }

  /**
   * 開始時刻コンボコンテナを取得します。
   * @return 開始時刻コンボコンテナ
   */
  protected ACLabelContainer getBeginComboContainer(){
    if(beginComboContainer==null){
      beginComboContainer = new ACLabelContainer();
      beginComboContainer.add(getBeginCombo(), null);
    }
    return beginComboContainer;
  }

  /**
   * 開始時刻コンボモデルを取得します。
   * @return 開始時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getBeginComboModel(){
    if(beginComboModel==null){
      beginComboModel = new ACComboBoxModelAdapter();
      addBeginComboModel();
    }
    return beginComboModel;
  }

  /**
   * 時刻キャプションを取得します。
   * @return 時刻キャプション
   */
  public ACLabel getTimeComboCaption(){
    if(timeComboCaption==null){

      timeComboCaption = new ACLabel();

      timeComboCaption.setText("から");

      addTimeComboCaption();
    }
    return timeComboCaption;

  }

  /**
   * 終了時刻コンボを取得します。
   * @return 終了時刻コンボ
   */
  public ACTimeComboBox getEndCombo(){
    if(endCombo==null){

      endCombo = new ACTimeComboBox();

      endCombo.setBindPath("4");

      endCombo.setModelBindPath("4");

      endCombo.setModel(getEndComboModel());

      endCombo.setRenderBindPath("CONTENT");

      addEndCombo();
    }
    return endCombo;

  }

  /**
   * 終了時刻コンボコンテナを取得します。
   * @return 終了時刻コンボコンテナ
   */
  protected ACLabelContainer getEndComboContainer(){
    if(endComboContainer==null){
      endComboContainer = new ACLabelContainer();
      endComboContainer.add(getEndCombo(), null);
    }
    return endComboContainer;
  }

  /**
   * 終了時刻コンボモデルを取得します。
   * @return 終了時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getEndComboModel(){
    if(endComboModel==null){
      endComboModel = new ACComboBoxModelAdapter();
      addEndComboModel();
    }
    return endComboModel;
  }

  /**
   * 曜日設定領域コンテナを取得します。
   * @return 曜日設定領域コンテナ
   */
  public ACLabelContainer getDayoftheWeekContainer(){
    if(dayoftheWeekContainer==null){

      dayoftheWeekContainer = new ACLabelContainer();

      addDayoftheWeekContainer();
    }
    return dayoftheWeekContainer;

  }

  /**
   * チェックボックス月曜を取得します。
   * @return チェックボックス月曜
   */
  public ACIntegerCheckBox getMondayCheck(){
    if(mondayCheck==null){

      mondayCheck = new ACIntegerCheckBox();

      mondayCheck.setText("月");

      addMondayCheck();
    }
    return mondayCheck;

  }

  /**
   * チェックボックス火曜を取得します。
   * @return チェックボックス火曜
   */
  public ACIntegerCheckBox getTuesdayCheck(){
    if(tuesdayCheck==null){

      tuesdayCheck = new ACIntegerCheckBox();

      tuesdayCheck.setText("火");

      addTuesdayCheck();
    }
    return tuesdayCheck;

  }

  /**
   * チェックボックス水曜を取得します。
   * @return チェックボックス水曜
   */
  public ACIntegerCheckBox getWednesdayCheck(){
    if(wednesdayCheck==null){

      wednesdayCheck = new ACIntegerCheckBox();

      wednesdayCheck.setText("水");

      addWednesdayCheck();
    }
    return wednesdayCheck;

  }

  /**
   * チェックボックス木曜を取得します。
   * @return チェックボックス木曜
   */
  public ACIntegerCheckBox getThursdayCheck(){
    if(thursdayCheck==null){

      thursdayCheck = new ACIntegerCheckBox();

      thursdayCheck.setText("木");

      addThursdayCheck();
    }
    return thursdayCheck;

  }

  /**
   * チェックボックス金曜を取得します。
   * @return チェックボックス金曜
   */
  public ACIntegerCheckBox getFridayCheck(){
    if(fridayCheck==null){

      fridayCheck = new ACIntegerCheckBox();

      fridayCheck.setText("金");

      addFridayCheck();
    }
    return fridayCheck;

  }

  /**
   * チェックボックス土曜を取得します。
   * @return チェックボックス土曜
   */
  public ACIntegerCheckBox getSaturdayCheck(){
    if(saturdayCheck==null){

      saturdayCheck = new ACIntegerCheckBox();

      saturdayCheck.setText("土");

      addSaturdayCheck();
    }
    return saturdayCheck;

  }

  /**
   * チェックボックス日曜を取得します。
   * @return チェックボックス日曜
   */
  public ACIntegerCheckBox getSundayCheck(){
    if(sundayCheck==null){

      sundayCheck = new ACIntegerCheckBox();

      sundayCheck.setText("日");

      addSundayCheck();
    }
    return sundayCheck;

  }

  /**
   * 貼り付けボタン領域を取得します。
   * @return 貼り付けボタン領域
   */
  public ACPanel getTimeButtons(){
    if(timeButtons==null){

      timeButtons = new ACPanel();

      addTimeButtons();
    }
    return timeButtons;

  }

  /**
   * 貼り付けボタンを取得します。
   * @return 貼り付けボタン
   */
  public ACButton getTimeButton(){
    if(timeButton==null){

      timeButton = new ACButton();

      timeButton.setText("貼り付け");

      timeButton.setToolTipText("サービスを週間表に貼り付けます。");

      timeButton.setIconPath(ACConstants.ICON_PATH_DOWN_24);

      addTimeButton();
    }
    return timeButton;

  }

  /**
   * 週単位以外のサービス領域を取得します。
   * @return 週単位以外のサービス領域
   */
  public ACGroupBox getExceptionServiceCombos(){
    if(exceptionServiceCombos==null){

      exceptionServiceCombos = new ACGroupBox();

      exceptionServiceCombos.setText("４．週単位以外のサービス");

      exceptionServiceCombos.setFollowChildEnabled(true);

      addExceptionServiceCombos();
    }
    return exceptionServiceCombos;

  }

  /**
   * コンボコンテナを取得します。
   * @return コンボコンテナ
   */
  public ACBackLabelContainer getExceptionComboContena(){
    if(exceptionComboContena==null){

      exceptionComboContena = new ACBackLabelContainer();

      exceptionComboContena.setText("期間");

      addExceptionComboContena();
    }
    return exceptionComboContena;

  }

  /**
   * 開始コンボを取得します。
   * @return 開始コンボ
   */
  public ACComboBox getExceptionBeginCombo(){
    if(exceptionBeginCombo==null){

      exceptionBeginCombo = new ACComboBox();

      exceptionBeginCombo.setBindPath("24");

      exceptionBeginCombo.setEditable(false);

      exceptionBeginCombo.setModelBindPath("24");

      exceptionBeginCombo.setModel(getExceptionBeginComboModel());

      exceptionBeginCombo.setRenderBindPath("CONTENT");

      addExceptionBeginCombo();
    }
    return exceptionBeginCombo;

  }

  /**
   * 開始コンボコンテナを取得します。
   * @return 開始コンボコンテナ
   */
  protected ACLabelContainer getExceptionBeginComboContainer(){
    if(exceptionBeginComboContainer==null){
      exceptionBeginComboContainer = new ACLabelContainer();
      exceptionBeginComboContainer.add(getExceptionBeginCombo(), null);
    }
    return exceptionBeginComboContainer;
  }

  /**
   * 開始コンボモデルを取得します。
   * @return 開始コンボモデル
   */
  protected ACComboBoxModelAdapter getExceptionBeginComboModel(){
    if(exceptionBeginComboModel==null){
      exceptionBeginComboModel = new ACComboBoxModelAdapter();
      addExceptionBeginComboModel();
    }
    return exceptionBeginComboModel;
  }

  /**
   * からラベルを取得します。
   * @return からラベル
   */
  public ACLabel getExceptionBeginLabel(){
    if(exceptionBeginLabel==null){

      exceptionBeginLabel = new ACLabel();

      exceptionBeginLabel.setText("から");

      addExceptionBeginLabel();
    }
    return exceptionBeginLabel;

  }

  /**
   * 終了コンボを取得します。
   * @return 終了コンボ
   */
  public ACComboBox getExceptionEndCombo(){
    if(exceptionEndCombo==null){

      exceptionEndCombo = new ACComboBox();

      exceptionEndCombo.setBindPath("25");

      exceptionEndCombo.setEditable(false);

      exceptionEndCombo.setModelBindPath("25");

      exceptionEndCombo.setModel(getExceptionEndComboModel());

      exceptionEndCombo.setRenderBindPath("CONTENT");

      exceptionEndCombo.setBlankable(true);

      addExceptionEndCombo();
    }
    return exceptionEndCombo;

  }

  /**
   * 終了コンボコンテナを取得します。
   * @return 終了コンボコンテナ
   */
  protected ACLabelContainer getExceptionEndComboContainer(){
    if(exceptionEndComboContainer==null){
      exceptionEndComboContainer = new ACLabelContainer();
      exceptionEndComboContainer.add(getExceptionEndCombo(), null);
    }
    return exceptionEndComboContainer;
  }

  /**
   * 終了コンボモデルを取得します。
   * @return 終了コンボモデル
   */
  protected ACComboBoxModelAdapter getExceptionEndComboModel(){
    if(exceptionEndComboModel==null){
      exceptionEndComboModel = new ACComboBoxModelAdapter();
      addExceptionEndComboModel();
    }
    return exceptionEndComboModel;
  }

  /**
   * 日間ラベルを取得します。
   * @return 日間ラベル
   */
  public ACLabel getExceptionEndLabel(){
    if(exceptionEndLabel==null){

      exceptionEndLabel = new ACLabel();

      exceptionEndLabel.setText("日間");

      addExceptionEndLabel();
    }
    return exceptionEndLabel;

  }

  /**
   * 毎日ボタンを取得します。
   * @return 毎日ボタン
   */
  public ACButton getEverydayButton(){
    if(everydayButton==null){

      everydayButton = new ACButton();

      everydayButton.setText("毎日");

      everydayButton.setToolTipText("全日入所として貼り付けます。");

      addEverydayButton();
    }
    return everydayButton;

  }

  /**
   * 貼り付けボタンを取得します。
   * @return 貼り付けボタン
   */
  public ACButton getExceptionButton(){
    if(exceptionButton==null){

      exceptionButton = new ACButton();

      exceptionButton.setText("貼り付け");

      exceptionButton.setToolTipText("サービスを週間表に貼り付けます。");

      exceptionButton.setIconPath(ACConstants.ICON_PATH_DOWN_24);

      addExceptionButton();
    }
    return exceptionButton;

  }

  /**
   * 週間表領域を取得します。
   * @return 週間表領域
   */
  public ACPanel getWeeklyCharts(){
    if(weeklyCharts==null){

      weeklyCharts = new ACPanel();

      weeklyCharts.setBackground(new Color(233,255,240));

      addWeeklyCharts();
    }
    return weeklyCharts;

  }

  /**
   * 週間表を取得します。
   * @return 週間表
   */
  public QS001WeekSchedule getWeeklySchedule(){
    if(weeklySchedule==null){

      weeklySchedule = new QS001WeekSchedule();

      addWeeklySchedule();
    }
    return weeklySchedule;

  }

  /**
   * 下部領域を取得します。
   * @return 下部領域
   */
  public ACPanel getBottoms(){
    if(bottoms==null){

      bottoms = new ACPanel();

      addBottoms();
    }
    return bottoms;

  }

  /**
   * 週単位以外領域を取得します。
   * @return 週単位以外領域
   */
  public ACGroupBox getNonWeeks(){
    if(nonWeeks==null){

      nonWeeks = new ACGroupBox();

      nonWeeks.setText("週単位以外");

      addNonWeeks();
    }
    return nonWeeks;

  }

  /**
   * 週単位以外のサービスを取得します。
   * @return 週単位以外のサービス
   */
  public QS001DaySchedule getFreedayServices(){
    if(freedayServices==null){

      freedayServices = new QS001DaySchedule();

      addFreedayServices();
    }
    return freedayServices;

  }

  /**
   * 下部右領域を取得します。
   * @return 下部右領域
   */
  public ACPanel getLowerRights(){
    if(lowerRights==null){

      lowerRights = new ACPanel();

      addLowerRights();
    }
    return lowerRights;

  }

  /**
   * 月間に展開領域を取得します。
   * @return 月間に展開領域
   */
  public ACGroupBox getExpansions(){
    if(expansions==null){

      expansions = new ACGroupBox();

      expansions.setText("月間へ展開");

      addExpansions();
    }
    return expansions;

  }

  /**
   * 展開開始日コンテナを取得します。
   * @return 展開開始日コンテナ
   */
  public ACLabelContainer getExpansionStartDateContainer(){
    if(expansionStartDateContainer==null){

      expansionStartDateContainer = new ACLabelContainer();

      addExpansionStartDateContainer();
    }
    return expansionStartDateContainer;

  }

  /**
   * 日付を取得します。
   * @return 日付
   */
  public ACTextField getExpansionStartDate(){
    if(expansionStartDate==null){

      expansionStartDate = new ACTextField();

      expansionStartDate.setColumns(2);

      expansionStartDate.setCharType(VRCharType.ONLY_DIGIT);

      expansionStartDate.setIMEMode(InputSubset.LATIN);

      expansionStartDate.setMaxLength(2);

      addExpansionStartDate();
    }
    return expansionStartDate;

  }

  /**
   * キャプションを取得します。
   * @return キャプション
   */
  public ACLabel getExpansionStartDateCaption(){
    if(expansionStartDateCaption==null){

      expansionStartDateCaption = new ACLabel();

      expansionStartDateCaption.setText("日から");

      addExpansionStartDateCaption();
    }
    return expansionStartDateCaption;

  }

  /**
   * 展開ボタンを取得します。
   * @return 展開ボタン
   */
  public ACButton getExpansionButton(){
    if(expansionButton==null){

      expansionButton = new ACButton();

      expansionButton.setText("月間へ展開");

      expansionButton.setToolTipText("週間表のサービスを月間表に展開します。");

      addExpansionButton();
    }
    return expansionButton;

  }

  /**
   * 週間サービス計画表領域を取得します。
   * @return 週間サービス計画表領域
   */
  public ACGroupBox getWeeklyServicePlans(){
    if(weeklyServicePlans==null){

      weeklyServicePlans = new ACGroupBox();

      weeklyServicePlans.setText("週間サービス計画表");

      addWeeklyServicePlans();
    }
    return weeklyServicePlans;

  }

  /**
   * 作成年月日を取得します。
   * @return 作成年月日
   */
  public QkanDateTextField getCreateDate(){
    if(createDate==null){

      createDate = new QkanDateTextField();

      getCreateDateContainer().setText("作成年月日");

      addCreateDate();
    }
    return createDate;

  }

  /**
   * 作成年月日コンテナを取得します。
   * @return 作成年月日コンテナ
   */
  protected ACLabelContainer getCreateDateContainer(){
    if(createDateContainer==null){
      createDateContainer = new ACLabelContainer();
      createDateContainer.add(getCreateDate(), null);
    }
    return createDateContainer;
  }

  /**
   * コンストラクタです。
   */
  public QS001001Design() {

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

    this.add(getContents(), VRLayout.CLIENT);

  }

  /**
   * クライアント領域に内部項目を追加します。
   */
  protected void addContents(){

    contents.add(getTimeContentLabelWeeks(), VRLayout.NORTH);

    contents.add(getExceptionServiceCombos(), VRLayout.NORTH);

    contents.add(getWeeklyCharts(), VRLayout.CLIENT);

    contents.add(getBottoms(), VRLayout.SOUTH);
  }

  /**
   * 時刻曜日設定ラベル統括領域に内部項目を追加します。
   */
  protected void addTimeContentLabelWeeks(){

    timeContentLabelWeeks.add(getTimeContentLabelWeeksLeft(), VRLayout.CLIENT);

    timeContentLabelWeeks.add(getTimeButtons(), VRLayout.EAST);
  }

  /**
   * 時刻曜日設定ラベル統括領域左に内部項目を追加します。
   */
  protected void addTimeContentLabelWeeksLeft(){

    timeContentLabelWeeksLeft.add(getTimeComboContainer(), VRLayout.FLOW_RETURN);

    timeContentLabelWeeksLeft.add(getDayoftheWeekContainer(), VRLayout.FLOW_RETURN);

  }

  /**
   * コンボコンテナに内部項目を追加します。
   */
  protected void addTimeComboContainer(){

    timeComboContainer.add(getBeginComboContainer(), VRLayout.FLOW);

    timeComboContainer.add(getTimeComboCaption(), VRLayout.FLOW);

    timeComboContainer.add(getEndComboContainer(), VRLayout.FLOW);

  }

  /**
   * 開始時刻コンボに内部項目を追加します。
   */
  protected void addBeginCombo(){

  }

  /**
   * 開始時刻コンボモデルに内部項目を追加します。
   */
  protected void addBeginComboModel(){

  }

  /**
   * 時刻キャプションに内部項目を追加します。
   */
  protected void addTimeComboCaption(){

  }

  /**
   * 終了時刻コンボに内部項目を追加します。
   */
  protected void addEndCombo(){

  }

  /**
   * 終了時刻コンボモデルに内部項目を追加します。
   */
  protected void addEndComboModel(){

  }

  /**
   * 曜日設定領域コンテナに内部項目を追加します。
   */
  protected void addDayoftheWeekContainer(){

    dayoftheWeekContainer.add(getMondayCheck(), VRLayout.FLOW);

    dayoftheWeekContainer.add(getTuesdayCheck(), VRLayout.FLOW);

    dayoftheWeekContainer.add(getWednesdayCheck(), VRLayout.FLOW);

    dayoftheWeekContainer.add(getThursdayCheck(), VRLayout.FLOW);

    dayoftheWeekContainer.add(getFridayCheck(), VRLayout.FLOW);

    dayoftheWeekContainer.add(getSaturdayCheck(), VRLayout.FLOW);

    dayoftheWeekContainer.add(getSundayCheck(), VRLayout.FLOW);

  }

  /**
   * チェックボックス月曜に内部項目を追加します。
   */
  protected void addMondayCheck(){

  }

  /**
   * チェックボックス火曜に内部項目を追加します。
   */
  protected void addTuesdayCheck(){

  }

  /**
   * チェックボックス水曜に内部項目を追加します。
   */
  protected void addWednesdayCheck(){

  }

  /**
   * チェックボックス木曜に内部項目を追加します。
   */
  protected void addThursdayCheck(){

  }

  /**
   * チェックボックス金曜に内部項目を追加します。
   */
  protected void addFridayCheck(){

  }

  /**
   * チェックボックス土曜に内部項目を追加します。
   */
  protected void addSaturdayCheck(){

  }

  /**
   * チェックボックス日曜に内部項目を追加します。
   */
  protected void addSundayCheck(){

  }

  /**
   * 貼り付けボタン領域に内部項目を追加します。
   */
  protected void addTimeButtons(){

    timeButtons.add(getTimeButton(), VRLayout.SOUTH);
  }

  /**
   * 貼り付けボタンに内部項目を追加します。
   */
  protected void addTimeButton(){

  }

  /**
   * 週単位以外のサービス領域に内部項目を追加します。
   */
  protected void addExceptionServiceCombos(){

    exceptionServiceCombos.add(getExceptionComboContena(), VRLayout.FLOW);

    exceptionServiceCombos.add(getExceptionButton(), VRLayout.EAST);
    exceptionServiceCombos.add(getEverydayButton(), VRLayout.EAST);
  }

  /**
   * コンボコンテナに内部項目を追加します。
   */
  protected void addExceptionComboContena(){

    exceptionComboContena.add(getExceptionBeginComboContainer(), VRLayout.FLOW);

    exceptionComboContena.add(getExceptionBeginLabel(), VRLayout.FLOW);

    exceptionComboContena.add(getExceptionEndComboContainer(), VRLayout.FLOW);

    exceptionComboContena.add(getExceptionEndLabel(), VRLayout.FLOW);

  }

  /**
   * 開始コンボに内部項目を追加します。
   */
  protected void addExceptionBeginCombo(){

  }

  /**
   * 開始コンボモデルに内部項目を追加します。
   */
  protected void addExceptionBeginComboModel(){

  }

  /**
   * からラベルに内部項目を追加します。
   */
  protected void addExceptionBeginLabel(){

  }

  /**
   * 終了コンボに内部項目を追加します。
   */
  protected void addExceptionEndCombo(){

  }

  /**
   * 終了コンボモデルに内部項目を追加します。
   */
  protected void addExceptionEndComboModel(){

  }

  /**
   * 日間ラベルに内部項目を追加します。
   */
  protected void addExceptionEndLabel(){

  }

  /**
   * 毎日ボタンに内部項目を追加します。
   */
  protected void addEverydayButton(){

  }

  /**
   * 貼り付けボタンに内部項目を追加します。
   */
  protected void addExceptionButton(){

  }

  /**
   * 週間表領域に内部項目を追加します。
   */
  protected void addWeeklyCharts(){

    weeklyCharts.add(getWeeklySchedule(), VRLayout.CLIENT);

  }

  /**
   * 週間表に内部項目を追加します。
   */
  protected void addWeeklySchedule(){

  }

  /**
   * 下部領域に内部項目を追加します。
   */
  protected void addBottoms(){

    bottoms.add(getNonWeeks(), VRLayout.CLIENT);

    bottoms.add(getLowerRights(), VRLayout.EAST);
  }

  /**
   * 週単位以外領域に内部項目を追加します。
   */
  protected void addNonWeeks(){

    nonWeeks.add(getFreedayServices(), VRLayout.CLIENT);

  }

  /**
   * 週単位以外のサービスに内部項目を追加します。
   */
  protected void addFreedayServices(){

  }

  /**
   * 下部右領域に内部項目を追加します。
   */
  protected void addLowerRights(){

    lowerRights.add(getExpansions(), VRLayout.CLIENT);

    lowerRights.add(getWeeklyServicePlans(), VRLayout.SOUTH);
  }

  /**
   * 月間に展開領域に内部項目を追加します。
   */
  protected void addExpansions(){

    expansions.add(getExpansionStartDateContainer(), VRLayout.FLOW);

    expansions.add(getExpansionButton(), VRLayout.FLOW_RETURN);

  }

  /**
   * 展開開始日コンテナに内部項目を追加します。
   */
  protected void addExpansionStartDateContainer(){

    expansionStartDateContainer.add(getExpansionStartDate(), VRLayout.FLOW);

    expansionStartDateContainer.add(getExpansionStartDateCaption(), VRLayout.FLOW);

  }

  /**
   * 日付に内部項目を追加します。
   */
  protected void addExpansionStartDate(){

  }

  /**
   * キャプションに内部項目を追加します。
   */
  protected void addExpansionStartDateCaption(){

  }

  /**
   * 展開ボタンに内部項目を追加します。
   */
  protected void addExpansionButton(){

  }

  /**
   * 週間サービス計画表領域に内部項目を追加します。
   */
  protected void addWeeklyServicePlans(){

    weeklyServicePlans.add(getCreateDateContainer(), VRLayout.FLOW);

  }

  /**
   * 作成年月日に内部項目を追加します。
   */
  protected void addCreateDate(){

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
      ACFrame.getInstance().getContentPane().add(new QS001001Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001001Design getThis() {
    return this;
  }
}
