
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
 * 開発者: 松本　幸一
 * 作成日: 2006/03/26  日本コンピューター株式会社 松本　幸一 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン訪問入浴介護 (QS001102)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Component;

import jp.nichicom.ac.component.ACClearableRadioButtonGroup;
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
 * サービスパターン訪問入浴介護画面項目デザイン(QS001102) 
 */
public class QS001102Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACPanel homonNyuyokuPatterns;

  private ACClearableRadioButtonGroup homonNyuyokuClass;

  private ACLabelContainer homonNyuyokuClassContainer;

  private ACListModelAdapter homonNyuyokuClassModel;

  private ACRadioButtonItem homonNyuyokuClassDouble;

  private ACRadioButtonItem homonNyuyokuClassSingle;

  private ACClearableRadioButtonGroup homonNyuyokuPartsRadio;

  private ACLabelContainer homonNyuyokuPartsRadioContainer;

  private ACListModelAdapter homonNyuyokuPartsRadioModel;

  private ACRadioButtonItem homonNyuyokuPartsRadioItem1;

  private ACRadioButtonItem homonNyuyokuPartsRadioItem2;

  private ACBackLabelContainer homonNyuyokuTimeContainer;

  private ACTimeComboBox homonNyuyokuBeginTime;

  private ACLabelContainer homonNyuyokuBeginTimeContainer;

  private ACComboBoxModelAdapter homonNyuyokuBeginTimeModel;

  private ACTimeComboBox homonNyuyokuEndTime;

  private ACLabelContainer homonNyuyokuEndTimeContainer;

  private ACComboBoxModelAdapter homonNyuyokuEndTimeModel;

  //getter

  /**
   * 訪問入浴介護パターン領域を取得します。
   * @return 訪問入浴介護パターン領域
   */
  public ACPanel getHomonNyuyokuPatterns(){
    if(homonNyuyokuPatterns==null){

      homonNyuyokuPatterns = new ACPanel();

      addHomonNyuyokuPatterns();
    }
    return homonNyuyokuPatterns;

  }

  /**
   * 訪問者の種別ラジオグループを取得します。
   * @return 訪問者の種別ラジオグループ
   */
  public ACClearableRadioButtonGroup getHomonNyuyokuClass(){
    if(homonNyuyokuClass==null){

      homonNyuyokuClass = new ACClearableRadioButtonGroup();

      getHomonNyuyokuClassContainer().setText("訪問者の人数");

      homonNyuyokuClass.setBindPath("1120103");

      homonNyuyokuClass.setUseClearButton(false);

      homonNyuyokuClass.setModel(getHomonNyuyokuClassModel());

      addHomonNyuyokuClass();
    }
    return homonNyuyokuClass;

  }

  /**
   * 訪問者の種別ラジオグループコンテナを取得します。
   * @return 訪問者の種別ラジオグループコンテナ
   */
  protected ACLabelContainer getHomonNyuyokuClassContainer(){
    if(homonNyuyokuClassContainer==null){
      homonNyuyokuClassContainer = new ACLabelContainer();
      homonNyuyokuClassContainer.setFollowChildEnabled(true);
      homonNyuyokuClassContainer.setVAlignment(VRLayout.CENTER);
      homonNyuyokuClassContainer.add(getHomonNyuyokuClass(), null);
    }
    return homonNyuyokuClassContainer;
  }

  /**
   * 訪問者の種別ラジオグループモデルを取得します。
   * @return 訪問者の種別ラジオグループモデル
   */
  protected ACListModelAdapter getHomonNyuyokuClassModel(){
    if(homonNyuyokuClassModel==null){
      homonNyuyokuClassModel = new ACListModelAdapter();
      addHomonNyuyokuClassModel();
    }
    return homonNyuyokuClassModel;
  }

  /**
   * 看護職員1人＋介護職員2人を取得します。
   * @return 看護職員1人＋介護職員2人
   */
  public ACRadioButtonItem getHomonNyuyokuClassDouble(){
    if(homonNyuyokuClassDouble==null){

      homonNyuyokuClassDouble = new ACRadioButtonItem();

      homonNyuyokuClassDouble.setText("看護職員1人及び介護職員2人");

      homonNyuyokuClassDouble.setGroup(getHomonNyuyokuClass());

      homonNyuyokuClassDouble.setConstraints(VRLayout.FLOW_RETURN);

      addHomonNyuyokuClassDouble();
    }
    return homonNyuyokuClassDouble;

  }

  /**
   * 介護職員3人を取得します。
   * @return 介護職員3人
   */
  public ACRadioButtonItem getHomonNyuyokuClassSingle(){
    if(homonNyuyokuClassSingle==null){

      homonNyuyokuClassSingle = new ACRadioButtonItem();

      homonNyuyokuClassSingle.setText("介護職員3人");

      homonNyuyokuClassSingle.setGroup(getHomonNyuyokuClass());

      homonNyuyokuClassSingle.setConstraints(VRLayout.FLOW);

      addHomonNyuyokuClassSingle();
    }
    return homonNyuyokuClassSingle;

  }

  /**
   * 訪問入浴介護区分ラジオグループを取得します。
   * @return 訪問入浴介護区分ラジオグループ
   */
  public ACClearableRadioButtonGroup getHomonNyuyokuPartsRadio(){
    if(homonNyuyokuPartsRadio==null){

      homonNyuyokuPartsRadio = new ACClearableRadioButtonGroup();

      getHomonNyuyokuPartsRadioContainer().setText("入浴介護区分");

      homonNyuyokuPartsRadio.setBindPath("1120104");

      homonNyuyokuPartsRadio.setUseClearButton(false);

      homonNyuyokuPartsRadio.setModel(getHomonNyuyokuPartsRadioModel());

      addHomonNyuyokuPartsRadio();
    }
    return homonNyuyokuPartsRadio;

  }

  /**
   * 訪問入浴介護区分ラジオグループコンテナを取得します。
   * @return 訪問入浴介護区分ラジオグループコンテナ
   */
  protected ACLabelContainer getHomonNyuyokuPartsRadioContainer(){
    if(homonNyuyokuPartsRadioContainer==null){
      homonNyuyokuPartsRadioContainer = new ACLabelContainer();
      homonNyuyokuPartsRadioContainer.setFollowChildEnabled(true);
      homonNyuyokuPartsRadioContainer.setVAlignment(VRLayout.CENTER);
      homonNyuyokuPartsRadioContainer.add(getHomonNyuyokuPartsRadio(), null);
    }
    return homonNyuyokuPartsRadioContainer;
  }

  /**
   * 訪問入浴介護区分ラジオグループモデルを取得します。
   * @return 訪問入浴介護区分ラジオグループモデル
   */
  protected ACListModelAdapter getHomonNyuyokuPartsRadioModel(){
    if(homonNyuyokuPartsRadioModel==null){
      homonNyuyokuPartsRadioModel = new ACListModelAdapter();
      addHomonNyuyokuPartsRadioModel();
    }
    return homonNyuyokuPartsRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHomonNyuyokuPartsRadioItem1(){
    if(homonNyuyokuPartsRadioItem1==null){

      homonNyuyokuPartsRadioItem1 = new ACRadioButtonItem();

      homonNyuyokuPartsRadioItem1.setText("なし");

      homonNyuyokuPartsRadioItem1.setGroup(getHomonNyuyokuPartsRadio());

      homonNyuyokuPartsRadioItem1.setConstraints(VRLayout.FLOW);

      addHomonNyuyokuPartsRadioItem1();
    }
    return homonNyuyokuPartsRadioItem1;

  }

  /**
   * 部分浴・清拭のみを取得します。
   * @return 部分浴・清拭のみ
   */
  public ACRadioButtonItem getHomonNyuyokuPartsRadioItem2(){
    if(homonNyuyokuPartsRadioItem2==null){

      homonNyuyokuPartsRadioItem2 = new ACRadioButtonItem();

      homonNyuyokuPartsRadioItem2.setText("部分浴・清拭のみ");

      homonNyuyokuPartsRadioItem2.setGroup(getHomonNyuyokuPartsRadio());

      homonNyuyokuPartsRadioItem2.setConstraints(VRLayout.FLOW);

      addHomonNyuyokuPartsRadioItem2();
    }
    return homonNyuyokuPartsRadioItem2;

  }

  /**
   * 提供時間コンテナを取得します。
   * @return 提供時間コンテナ
   */
  public ACBackLabelContainer getHomonNyuyokuTimeContainer(){
    if(homonNyuyokuTimeContainer==null){

      homonNyuyokuTimeContainer = new ACBackLabelContainer();

      addHomonNyuyokuTimeContainer();
    }
    return homonNyuyokuTimeContainer;

  }

  /**
   * 開始時刻コンボを取得します。
   * @return 開始時刻コンボ
   */
  public ACTimeComboBox getHomonNyuyokuBeginTime(){
    if(homonNyuyokuBeginTime==null){

      homonNyuyokuBeginTime = new ACTimeComboBox();

      getHomonNyuyokuBeginTimeContainer().setText("開始時刻");

      homonNyuyokuBeginTime.setBindPath("3");

      homonNyuyokuBeginTime.setModelBindPath("3");

      homonNyuyokuBeginTime.setRenderBindPath("CONTENT");

      homonNyuyokuBeginTime.setModel(getHomonNyuyokuBeginTimeModel());

      addHomonNyuyokuBeginTime();
    }
    return homonNyuyokuBeginTime;

  }

  /**
   * 開始時刻コンボコンテナを取得します。
   * @return 開始時刻コンボコンテナ
   */
  protected ACLabelContainer getHomonNyuyokuBeginTimeContainer(){
    if(homonNyuyokuBeginTimeContainer==null){
      homonNyuyokuBeginTimeContainer = new ACLabelContainer();
      homonNyuyokuBeginTimeContainer.setFollowChildEnabled(true);
      homonNyuyokuBeginTimeContainer.setVAlignment(VRLayout.CENTER);
      homonNyuyokuBeginTimeContainer.add(getHomonNyuyokuBeginTime(), null);
    }
    return homonNyuyokuBeginTimeContainer;
  }

  /**
   * 開始時刻コンボモデルを取得します。
   * @return 開始時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getHomonNyuyokuBeginTimeModel(){
    if(homonNyuyokuBeginTimeModel==null){
      homonNyuyokuBeginTimeModel = new ACComboBoxModelAdapter();
      addHomonNyuyokuBeginTimeModel();
    }
    return homonNyuyokuBeginTimeModel;
  }

  /**
   * 終了時刻コンボを取得します。
   * @return 終了時刻コンボ
   */
  public ACTimeComboBox getHomonNyuyokuEndTime(){
    if(homonNyuyokuEndTime==null){

      homonNyuyokuEndTime = new ACTimeComboBox();

      getHomonNyuyokuEndTimeContainer().setText("終了時刻");

      homonNyuyokuEndTime.setBindPath("4");

      homonNyuyokuEndTime.setModelBindPath("4");

      homonNyuyokuEndTime.setRenderBindPath("CONTENT");

      homonNyuyokuEndTime.setModel(getHomonNyuyokuEndTimeModel());

      addHomonNyuyokuEndTime();
    }
    return homonNyuyokuEndTime;

  }

  /**
   * 終了時刻コンボコンテナを取得します。
   * @return 終了時刻コンボコンテナ
   */
  protected ACLabelContainer getHomonNyuyokuEndTimeContainer(){
    if(homonNyuyokuEndTimeContainer==null){
      homonNyuyokuEndTimeContainer = new ACLabelContainer();
      homonNyuyokuEndTimeContainer.setFollowChildEnabled(true);
      homonNyuyokuEndTimeContainer.setVAlignment(VRLayout.CENTER);
      homonNyuyokuEndTimeContainer.add(getHomonNyuyokuEndTime(), null);
    }
    return homonNyuyokuEndTimeContainer;
  }

  /**
   * 終了時刻コンボモデルを取得します。
   * @return 終了時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getHomonNyuyokuEndTimeModel(){
    if(homonNyuyokuEndTimeModel==null){
      homonNyuyokuEndTimeModel = new ACComboBoxModelAdapter();
      addHomonNyuyokuEndTimeModel();
    }
    return homonNyuyokuEndTimeModel;
  }

  /**
   * コンストラクタです。
   */
  public QS001102Design() {

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

    this.add(getHomonNyuyokuPatterns(), VRLayout.CLIENT);

  }

  /**
   * 訪問入浴介護パターン領域に内部項目を追加します。
   */
  protected void addHomonNyuyokuPatterns(){

    homonNyuyokuPatterns.add(getHomonNyuyokuClassContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    homonNyuyokuPatterns.add(getHomonNyuyokuPartsRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    homonNyuyokuPatterns.add(getHomonNyuyokuTimeContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * 訪問者の種別ラジオグループに内部項目を追加します。
   */
  protected void addHomonNyuyokuClass(){

  }

  /**
   * 訪問者の種別ラジオグループモデルに内部項目を追加します。
   */
  protected void addHomonNyuyokuClassModel(){

    getHomonNyuyokuClassDouble().setButtonIndex(1);
    getHomonNyuyokuClassModel().add(getHomonNyuyokuClassDouble());

    getHomonNyuyokuClassSingle().setButtonIndex(2);
    getHomonNyuyokuClassModel().add(getHomonNyuyokuClassSingle());

  }

  /**
   * 看護職員1人＋介護職員2人に内部項目を追加します。
   */
  protected void addHomonNyuyokuClassDouble(){

  }

  /**
   * 介護職員3人に内部項目を追加します。
   */
  protected void addHomonNyuyokuClassSingle(){

  }

  /**
   * 訪問入浴介護区分ラジオグループに内部項目を追加します。
   */
  protected void addHomonNyuyokuPartsRadio(){

  }

  /**
   * 訪問入浴介護区分ラジオグループモデルに内部項目を追加します。
   */
  protected void addHomonNyuyokuPartsRadioModel(){

    getHomonNyuyokuPartsRadioItem1().setButtonIndex(1);
    getHomonNyuyokuPartsRadioModel().add(getHomonNyuyokuPartsRadioItem1());

    getHomonNyuyokuPartsRadioItem2().setButtonIndex(2);
    getHomonNyuyokuPartsRadioModel().add(getHomonNyuyokuPartsRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHomonNyuyokuPartsRadioItem1(){

  }

  /**
   * 部分浴・清拭のみに内部項目を追加します。
   */
  protected void addHomonNyuyokuPartsRadioItem2(){

  }

  /**
   * 提供時間コンテナに内部項目を追加します。
   */
  protected void addHomonNyuyokuTimeContainer(){

    homonNyuyokuTimeContainer.add(getHomonNyuyokuBeginTimeContainer(), VRLayout.FLOW);

    homonNyuyokuTimeContainer.add(getHomonNyuyokuEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * 開始時刻コンボに内部項目を追加します。
   */
  protected void addHomonNyuyokuBeginTime(){

  }

  /**
   * 開始時刻コンボモデルに内部項目を追加します。
   */
  protected void addHomonNyuyokuBeginTimeModel(){

  }

  /**
   * 終了時刻コンボに内部項目を追加します。
   */
  protected void addHomonNyuyokuEndTime(){

  }

  /**
   * 終了時刻コンボモデルに内部項目を追加します。
   */
  protected void addHomonNyuyokuEndTimeModel(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001102Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001102Design getThis() {
    return this;
  }
}
