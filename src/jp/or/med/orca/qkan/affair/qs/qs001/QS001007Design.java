
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
 * 作成日: 2006/01/24  日本コンピューター株式会社 小笠　貴志 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン訪問リハ (QS001007)
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
 * サービスパターン訪問リハ画面項目デザイン(QS001007) 
 */
public class QS001007Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACPanel houmonRehabilitationPatterns;

  private ACBackLabelContainer houmonRehabilitationTimeContena;

  private ACTimeComboBox houmonRehabilitationBeginTime;

  private ACLabelContainer houmonRehabilitationBeginTimeContainer;

  private ACComboBoxModelAdapter houmonRehabilitationBeginTimeModel;

  private ACTimeComboBox houmonRehabilitationEndTime;

  private ACLabelContainer houmonRehabilitationEndTimeContainer;

  private ACComboBoxModelAdapter houmonRehabilitationEndTimeModel;

  private ACClearableRadioButtonGroup houmonRehabilitationFacilityDivision;

  private ACLabelContainer houmonRehabilitationFacilityDivisionContainer;

  private ACListModelAdapter houmonRehabilitationFacilityDivisionModel;

  private ACRadioButtonItem houmonRehabilitationClassDouble;

  private ACRadioButtonItem houmonRehabilitationClassSingle;

  private ACClearableRadioButtonGroup houmonRehabilitationAdditionRadio;

  private ACLabelContainer houmonRehabilitationAdditionRadioContainer;

  private ACListModelAdapter houmonRehabilitationAdditionRadioModel;

  private ACRadioButtonItem houmonRehabilitationAdditionRadioItem1;

  private ACRadioButtonItem houmonRehabilitationAdditionRadioItem2;

  //getter

  /**
   * 訪問リハビリテーションパターン領域を取得します。
   * @return 訪問リハビリテーションパターン領域
   */
  public ACPanel getHoumonRehabilitationPatterns(){
    if(houmonRehabilitationPatterns==null){

      houmonRehabilitationPatterns = new ACPanel();

      addHoumonRehabilitationPatterns();
    }
    return houmonRehabilitationPatterns;

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
  public ACTimeComboBox getHoumonRehabilitationBeginTime(){
    if(houmonRehabilitationBeginTime==null){

      houmonRehabilitationBeginTime = new ACTimeComboBox();

      getHoumonRehabilitationBeginTimeContainer().setText("開始時刻");

      houmonRehabilitationBeginTime.setBindPath("3");

      houmonRehabilitationBeginTime.setModelBindPath("3");

      houmonRehabilitationBeginTime.setModel(getHoumonRehabilitationBeginTimeModel());

      houmonRehabilitationBeginTime.setRenderBindPath("CONTENT");

      addHoumonRehabilitationBeginTime();
    }
    return houmonRehabilitationBeginTime;

  }

  /**
   * 開始時刻コンボコンテナを取得します。
   * @return 開始時刻コンボコンテナ
   */
  protected ACLabelContainer getHoumonRehabilitationBeginTimeContainer(){
    if(houmonRehabilitationBeginTimeContainer==null){
      houmonRehabilitationBeginTimeContainer = new ACLabelContainer();
      houmonRehabilitationBeginTimeContainer.add(getHoumonRehabilitationBeginTime(), null);
    }
    return houmonRehabilitationBeginTimeContainer;
  }

  /**
   * 開始時刻コンボモデルを取得します。
   * @return 開始時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getHoumonRehabilitationBeginTimeModel(){
    if(houmonRehabilitationBeginTimeModel==null){
      houmonRehabilitationBeginTimeModel = new ACComboBoxModelAdapter();
      addHoumonRehabilitationBeginTimeModel();
    }
    return houmonRehabilitationBeginTimeModel;
  }

  /**
   * 終了時刻コンボを取得します。
   * @return 終了時刻コンボ
   */
  public ACTimeComboBox getHoumonRehabilitationEndTime(){
    if(houmonRehabilitationEndTime==null){

      houmonRehabilitationEndTime = new ACTimeComboBox();

      getHoumonRehabilitationEndTimeContainer().setText("終了時刻");

      houmonRehabilitationEndTime.setBindPath("4");

      houmonRehabilitationEndTime.setModelBindPath("4");

      houmonRehabilitationEndTime.setModel(getHoumonRehabilitationEndTimeModel());

      houmonRehabilitationEndTime.setRenderBindPath("CONTENT");

      addHoumonRehabilitationEndTime();
    }
    return houmonRehabilitationEndTime;

  }

  /**
   * 終了時刻コンボコンテナを取得します。
   * @return 終了時刻コンボコンテナ
   */
  protected ACLabelContainer getHoumonRehabilitationEndTimeContainer(){
    if(houmonRehabilitationEndTimeContainer==null){
      houmonRehabilitationEndTimeContainer = new ACLabelContainer();
      houmonRehabilitationEndTimeContainer.add(getHoumonRehabilitationEndTime(), null);
    }
    return houmonRehabilitationEndTimeContainer;
  }

  /**
   * 終了時刻コンボモデルを取得します。
   * @return 終了時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getHoumonRehabilitationEndTimeModel(){
    if(houmonRehabilitationEndTimeModel==null){
      houmonRehabilitationEndTimeModel = new ACComboBoxModelAdapter();
      addHoumonRehabilitationEndTimeModel();
    }
    return houmonRehabilitationEndTimeModel;
  }

  /**
   * 施設区分を取得します。
   * @return 施設区分
   */
  public ACClearableRadioButtonGroup getHoumonRehabilitationFacilityDivision(){
    if(houmonRehabilitationFacilityDivision==null){

      houmonRehabilitationFacilityDivision = new ACClearableRadioButtonGroup();

      getHoumonRehabilitationFacilityDivisionContainer().setText("施設区分");

      houmonRehabilitationFacilityDivision.setBindPath("1140103");

      houmonRehabilitationFacilityDivision.setModel(getHoumonRehabilitationFacilityDivisionModel());

      houmonRehabilitationFacilityDivision.setUseClearButton(false);

      addHoumonRehabilitationFacilityDivision();
    }
    return houmonRehabilitationFacilityDivision;

  }

  /**
   * 施設区分コンテナを取得します。
   * @return 施設区分コンテナ
   */
  protected ACLabelContainer getHoumonRehabilitationFacilityDivisionContainer(){
    if(houmonRehabilitationFacilityDivisionContainer==null){
      houmonRehabilitationFacilityDivisionContainer = new ACLabelContainer();
      houmonRehabilitationFacilityDivisionContainer.add(getHoumonRehabilitationFacilityDivision(), null);
    }
    return houmonRehabilitationFacilityDivisionContainer;
  }

  /**
   * 施設区分モデルを取得します。
   * @return 施設区分モデル
   */
  protected ACListModelAdapter getHoumonRehabilitationFacilityDivisionModel(){
    if(houmonRehabilitationFacilityDivisionModel==null){
      houmonRehabilitationFacilityDivisionModel = new ACListModelAdapter();
      addHoumonRehabilitationFacilityDivisionModel();
    }
    return houmonRehabilitationFacilityDivisionModel;
  }

  /**
   * 病院または診療所を取得します。
   * @return 病院または診療所
   */
  public ACRadioButtonItem getHoumonRehabilitationClassDouble(){
    if(houmonRehabilitationClassDouble==null){

      houmonRehabilitationClassDouble = new ACRadioButtonItem();

      houmonRehabilitationClassDouble.setText("病院又は診療所");

      houmonRehabilitationClassDouble.setGroup(getHoumonRehabilitationFacilityDivision());

      houmonRehabilitationClassDouble.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonRehabilitationClassDouble();
    }
    return houmonRehabilitationClassDouble;

  }

  /**
   * 介護老人保健施設を取得します。
   * @return 介護老人保健施設
   */
  public ACRadioButtonItem getHoumonRehabilitationClassSingle(){
    if(houmonRehabilitationClassSingle==null){

      houmonRehabilitationClassSingle = new ACRadioButtonItem();

      houmonRehabilitationClassSingle.setText("介護老人保健施設");

      houmonRehabilitationClassSingle.setGroup(getHoumonRehabilitationFacilityDivision());

      houmonRehabilitationClassSingle.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationClassSingle();
    }
    return houmonRehabilitationClassSingle;

  }

  /**
   * 日常生活活動訓練加算を取得します。
   * @return 日常生活活動訓練加算
   */
  public ACClearableRadioButtonGroup getHoumonRehabilitationAdditionRadio(){
    if(houmonRehabilitationAdditionRadio==null){

      houmonRehabilitationAdditionRadio = new ACClearableRadioButtonGroup();

      getHoumonRehabilitationAdditionRadioContainer().setText("日常生活活動訓練加算");

      houmonRehabilitationAdditionRadio.setBindPath("1140104");

      houmonRehabilitationAdditionRadio.setModel(getHoumonRehabilitationAdditionRadioModel());

      houmonRehabilitationAdditionRadio.setUseClearButton(false);

      addHoumonRehabilitationAdditionRadio();
    }
    return houmonRehabilitationAdditionRadio;

  }

  /**
   * 日常生活活動訓練加算コンテナを取得します。
   * @return 日常生活活動訓練加算コンテナ
   */
  protected ACLabelContainer getHoumonRehabilitationAdditionRadioContainer(){
    if(houmonRehabilitationAdditionRadioContainer==null){
      houmonRehabilitationAdditionRadioContainer = new ACLabelContainer();
      houmonRehabilitationAdditionRadioContainer.add(getHoumonRehabilitationAdditionRadio(), null);
    }
    return houmonRehabilitationAdditionRadioContainer;
  }

  /**
   * 日常生活活動訓練加算モデルを取得します。
   * @return 日常生活活動訓練加算モデル
   */
  protected ACListModelAdapter getHoumonRehabilitationAdditionRadioModel(){
    if(houmonRehabilitationAdditionRadioModel==null){
      houmonRehabilitationAdditionRadioModel = new ACListModelAdapter();
      addHoumonRehabilitationAdditionRadioModel();
    }
    return houmonRehabilitationAdditionRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonRehabilitationAdditionRadioItem1(){
    if(houmonRehabilitationAdditionRadioItem1==null){

      houmonRehabilitationAdditionRadioItem1 = new ACRadioButtonItem();

      houmonRehabilitationAdditionRadioItem1.setText("なし");

      houmonRehabilitationAdditionRadioItem1.setGroup(getHoumonRehabilitationAdditionRadio());

      houmonRehabilitationAdditionRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationAdditionRadioItem1();
    }
    return houmonRehabilitationAdditionRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHoumonRehabilitationAdditionRadioItem2(){
    if(houmonRehabilitationAdditionRadioItem2==null){

      houmonRehabilitationAdditionRadioItem2 = new ACRadioButtonItem();

      houmonRehabilitationAdditionRadioItem2.setText("あり");

      houmonRehabilitationAdditionRadioItem2.setGroup(getHoumonRehabilitationAdditionRadio());

      houmonRehabilitationAdditionRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationAdditionRadioItem2();
    }
    return houmonRehabilitationAdditionRadioItem2;

  }

  /**
   * コンストラクタです。
   */
  public QS001007Design() {

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

    this.add(getHoumonRehabilitationPatterns(), VRLayout.WEST);

  }

  /**
   * 訪問リハビリテーションパターン領域に内部項目を追加します。
   */
  protected void addHoumonRehabilitationPatterns(){

    houmonRehabilitationPatterns.add(getHoumonRehabilitationTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    houmonRehabilitationPatterns.add(getHoumonRehabilitationFacilityDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonRehabilitationPatterns.add(getHoumonRehabilitationAdditionRadioContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 提供時間コンテナに内部項目を追加します。
   */
  protected void addHoumonRehabilitationTimeContena(){

    houmonRehabilitationTimeContena.add(getHoumonRehabilitationBeginTimeContainer(), VRLayout.FLOW);

    houmonRehabilitationTimeContena.add(getHoumonRehabilitationEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * 開始時刻コンボに内部項目を追加します。
   */
  protected void addHoumonRehabilitationBeginTime(){

  }

  /**
   * 開始時刻コンボモデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationBeginTimeModel(){

  }

  /**
   * 終了時刻コンボに内部項目を追加します。
   */
  protected void addHoumonRehabilitationEndTime(){

  }

  /**
   * 終了時刻コンボモデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationEndTimeModel(){

  }

  /**
   * 施設区分に内部項目を追加します。
   */
  protected void addHoumonRehabilitationFacilityDivision(){

  }

  /**
   * 施設区分モデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationFacilityDivisionModel(){

    getHoumonRehabilitationClassDouble().setButtonIndex(0);
    getHoumonRehabilitationFacilityDivisionModel().add(getHoumonRehabilitationClassDouble());

    getHoumonRehabilitationClassSingle().setButtonIndex(1);
    getHoumonRehabilitationFacilityDivisionModel().add(getHoumonRehabilitationClassSingle());

  }

  /**
   * 病院または診療所に内部項目を追加します。
   */
  protected void addHoumonRehabilitationClassDouble(){

  }

  /**
   * 介護老人保健施設に内部項目を追加します。
   */
  protected void addHoumonRehabilitationClassSingle(){

  }

  /**
   * 日常生活活動訓練加算に内部項目を追加します。
   */
  protected void addHoumonRehabilitationAdditionRadio(){

  }

  /**
   * 日常生活活動訓練加算モデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationAdditionRadioModel(){

    getHoumonRehabilitationAdditionRadioItem1().setButtonIndex(0);
    getHoumonRehabilitationAdditionRadioModel().add(getHoumonRehabilitationAdditionRadioItem1());

    getHoumonRehabilitationAdditionRadioItem2().setButtonIndex(1);
    getHoumonRehabilitationAdditionRadioModel().add(getHoumonRehabilitationAdditionRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonRehabilitationAdditionRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHoumonRehabilitationAdditionRadioItem2(){

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
      ACFrame.getInstance().getContentPane().add(new QS001007Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001007Design getThis() {
    return this;
  }
}
