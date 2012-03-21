
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
 * 開発者: 樋口　雅彦
 * 作成日: 2011/11/16  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターンその他内容詳細 (QS001_90101_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Component;
import java.awt.im.InputSubset;

import jp.nichicom.ac.component.ACButton;
import jp.nichicom.ac.component.ACTextField;
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
 * サービスパターンその他内容詳細画面項目デザイン(QS001_90101_201204) 
 */
@SuppressWarnings("serial")
public class QS001_90101_201204Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACPanel dailyLifeActivityPatterns;

  private ACPanel dailyLifeActivityDetail;

  private ACBackLabelContainer dailyLifeActivityTimeContena;

  private ACTimeComboBox dailyLifeActivityBeginTime;

  private ACLabelContainer dailyLifeActivityBeginTimeContainer;

  private ACComboBoxModelAdapter dailyLifeActivityBeginTimeModel;

  private ACTimeComboBox dailyLifeActivityTimeContenaEndTime;

  private ACLabelContainer dailyLifeActivityTimeContenaEndTimeContainer;

  private ACComboBoxModelAdapter dailyLifeActivityTimeContenaEndTimeModel;

  private QS001OtherItemListBox dailyLifeActivitList;

  private ACLabelContainer dailyLifeActivitListContainer;

  private ACListModelAdapter dailyLifeActivitListModel;

  private ACTextField dailyLifeActivitySelect;

  private ACLabelContainer dailyLifeActivitySelectContainer;

  private ACButton dailyLifeActivitInsertButton;

  private ACButton dailyLifeActivitFindButton;

  private ACButton dailyLifeActivitDeleteButton;

  //getter

  /**
   * 主な日常生活上の活動パターン領域を取得します。
   * @return 主な日常生活上の活動パターン領域
   */
  public ACPanel getDailyLifeActivityPatterns(){
    if(dailyLifeActivityPatterns==null){

      dailyLifeActivityPatterns = new ACPanel();

      dailyLifeActivityPatterns.setAutoWrap(false);

      addDailyLifeActivityPatterns();
    }
    return dailyLifeActivityPatterns;

  }

  /**
   * 内容パネルを取得します。
   * @return 内容パネル
   */
  public ACPanel getDailyLifeActivityDetail(){
    if(dailyLifeActivityDetail==null){

      dailyLifeActivityDetail = new ACPanel();

      dailyLifeActivityDetail.setHgrid(200);

      addDailyLifeActivityDetail();
    }
    return dailyLifeActivityDetail;

  }

  /**
   * 提供時間コンテナを取得します。
   * @return 提供時間コンテナ
   */
  public ACBackLabelContainer getDailyLifeActivityTimeContena(){
    if(dailyLifeActivityTimeContena==null){

      dailyLifeActivityTimeContena = new ACBackLabelContainer();

      addDailyLifeActivityTimeContena();
    }
    return dailyLifeActivityTimeContena;

  }

  /**
   * 開始時刻コンボを取得します。
   * @return 開始時刻コンボ
   */
  public ACTimeComboBox getDailyLifeActivityBeginTime(){
    if(dailyLifeActivityBeginTime==null){

      dailyLifeActivityBeginTime = new ACTimeComboBox();

      getDailyLifeActivityBeginTimeContainer().setText("開始時刻");

      dailyLifeActivityBeginTime.setBindPath("3");

      dailyLifeActivityBeginTime.setModelBindPath("3");

      dailyLifeActivityBeginTime.setRenderBindPath("CONTENT");

      dailyLifeActivityBeginTime.setModel(getDailyLifeActivityBeginTimeModel());

      addDailyLifeActivityBeginTime();
    }
    return dailyLifeActivityBeginTime;

  }

  /**
   * 開始時刻コンボコンテナを取得します。
   * @return 開始時刻コンボコンテナ
   */
  protected ACLabelContainer getDailyLifeActivityBeginTimeContainer(){
    if(dailyLifeActivityBeginTimeContainer==null){
      dailyLifeActivityBeginTimeContainer = new ACLabelContainer();
      dailyLifeActivityBeginTimeContainer.setFollowChildEnabled(true);
      dailyLifeActivityBeginTimeContainer.setVAlignment(VRLayout.CENTER);
      dailyLifeActivityBeginTimeContainer.add(getDailyLifeActivityBeginTime(), null);
    }
    return dailyLifeActivityBeginTimeContainer;
  }

  /**
   * 開始時刻コンボモデルを取得します。
   * @return 開始時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getDailyLifeActivityBeginTimeModel(){
    if(dailyLifeActivityBeginTimeModel==null){
      dailyLifeActivityBeginTimeModel = new ACComboBoxModelAdapter();
      addDailyLifeActivityBeginTimeModel();
    }
    return dailyLifeActivityBeginTimeModel;
  }

  /**
   * 終了時刻コンボを取得します。
   * @return 終了時刻コンボ
   */
  public ACTimeComboBox getDailyLifeActivityTimeContenaEndTime(){
    if(dailyLifeActivityTimeContenaEndTime==null){

      dailyLifeActivityTimeContenaEndTime = new ACTimeComboBox();

      getDailyLifeActivityTimeContenaEndTimeContainer().setText("終了時刻");

      dailyLifeActivityTimeContenaEndTime.setBindPath("4");

      dailyLifeActivityTimeContenaEndTime.setModelBindPath("4");

      dailyLifeActivityTimeContenaEndTime.setRenderBindPath("CONTENT");

      dailyLifeActivityTimeContenaEndTime.setModel(getDailyLifeActivityTimeContenaEndTimeModel());

      addDailyLifeActivityTimeContenaEndTime();
    }
    return dailyLifeActivityTimeContenaEndTime;

  }

  /**
   * 終了時刻コンボコンテナを取得します。
   * @return 終了時刻コンボコンテナ
   */
  protected ACLabelContainer getDailyLifeActivityTimeContenaEndTimeContainer(){
    if(dailyLifeActivityTimeContenaEndTimeContainer==null){
      dailyLifeActivityTimeContenaEndTimeContainer = new ACLabelContainer();
      dailyLifeActivityTimeContenaEndTimeContainer.setFollowChildEnabled(true);
      dailyLifeActivityTimeContenaEndTimeContainer.setVAlignment(VRLayout.CENTER);
      dailyLifeActivityTimeContenaEndTimeContainer.add(getDailyLifeActivityTimeContenaEndTime(), null);
    }
    return dailyLifeActivityTimeContenaEndTimeContainer;
  }

  /**
   * 終了時刻コンボモデルを取得します。
   * @return 終了時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getDailyLifeActivityTimeContenaEndTimeModel(){
    if(dailyLifeActivityTimeContenaEndTimeModel==null){
      dailyLifeActivityTimeContenaEndTimeModel = new ACComboBoxModelAdapter();
      addDailyLifeActivityTimeContenaEndTimeModel();
    }
    return dailyLifeActivityTimeContenaEndTimeModel;
  }

  /**
   * 主な日常生活リストを取得します。
   * @return 主な日常生活リスト
   */
  public QS001OtherItemListBox getDailyLifeActivitList(){
    if(dailyLifeActivitList==null){

      dailyLifeActivitList = new QS001OtherItemListBox();

      getDailyLifeActivitListContainer().setText("入力候補");

      dailyLifeActivitList.setBindPath("dummy");

      dailyLifeActivitList.setColumns(12);

      dailyLifeActivitList.setModel(getDailyLifeActivitListModel());

      dailyLifeActivitList.setVisibleRowCount(11);

      addDailyLifeActivitList();
    }
    return dailyLifeActivitList;

  }

  /**
   * 主な日常生活リストコンテナを取得します。
   * @return 主な日常生活リストコンテナ
   */
  protected ACLabelContainer getDailyLifeActivitListContainer(){
    if(dailyLifeActivitListContainer==null){
      dailyLifeActivitListContainer = new ACLabelContainer();
      dailyLifeActivitListContainer.setFollowChildEnabled(true);
      dailyLifeActivitListContainer.setVAlignment(VRLayout.CENTER);
      dailyLifeActivitListContainer.add(getDailyLifeActivitList(), null);
    }
    return dailyLifeActivitListContainer;
  }

  /**
   * 主な日常生活リストモデルを取得します。
   * @return 主な日常生活リストモデル
   */
  protected ACListModelAdapter getDailyLifeActivitListModel(){
    if(dailyLifeActivitListModel==null){
      dailyLifeActivitListModel = new ACListModelAdapter();
      addDailyLifeActivitListModel();
    }
    return dailyLifeActivitListModel;
  }

  /**
   * 内容詳細テキストを取得します。
   * @return 内容詳細テキスト
   */
  public ACTextField getDailyLifeActivitySelect(){
    if(dailyLifeActivitySelect==null){

      dailyLifeActivitySelect = new ACTextField();

      getDailyLifeActivitySelectContainer().setText("内容詳細");

      dailyLifeActivitySelect.setBindPath("9010101");

      dailyLifeActivitySelect.setColumns(11);

      dailyLifeActivitySelect.setIMEMode(InputSubset.KANJI);

      dailyLifeActivitySelect.setMaxLength(10);

      addDailyLifeActivitySelect();
    }
    return dailyLifeActivitySelect;

  }

  /**
   * 内容詳細テキストコンテナを取得します。
   * @return 内容詳細テキストコンテナ
   */
  protected ACLabelContainer getDailyLifeActivitySelectContainer(){
    if(dailyLifeActivitySelectContainer==null){
      dailyLifeActivitySelectContainer = new ACLabelContainer();
      dailyLifeActivitySelectContainer.setFollowChildEnabled(true);
      dailyLifeActivitySelectContainer.setVAlignment(VRLayout.CENTER);
      dailyLifeActivitySelectContainer.add(getDailyLifeActivitySelect(), null);
    }
    return dailyLifeActivitySelectContainer;
  }

  /**
   * 追加を取得します。
   * @return 追加
   */
  public ACButton getDailyLifeActivitInsertButton(){
    if(dailyLifeActivitInsertButton==null){

      dailyLifeActivitInsertButton = new ACButton();

      dailyLifeActivitInsertButton.setText("追加");

      addDailyLifeActivitInsertButton();
    }
    return dailyLifeActivitInsertButton;

  }

  /**
   * 編集を取得します。
   * @return 編集
   */
  public ACButton getDailyLifeActivitFindButton(){
    if(dailyLifeActivitFindButton==null){

      dailyLifeActivitFindButton = new ACButton();

      dailyLifeActivitFindButton.setText("編集");

      addDailyLifeActivitFindButton();
    }
    return dailyLifeActivitFindButton;

  }

  /**
   * 削除を取得します。
   * @return 削除
   */
  public ACButton getDailyLifeActivitDeleteButton(){
    if(dailyLifeActivitDeleteButton==null){

      dailyLifeActivitDeleteButton = new ACButton();

      dailyLifeActivitDeleteButton.setText("削除");

      addDailyLifeActivitDeleteButton();
    }
    return dailyLifeActivitDeleteButton;

  }

  /**
   * コンストラクタです。
   */
  public QS001_90101_201204Design() {

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

    this.add(getDailyLifeActivityPatterns(), VRLayout.WEST);

  }

  /**
   * 主な日常生活上の活動パターン領域に内部項目を追加します。
   */
  protected void addDailyLifeActivityPatterns(){

    dailyLifeActivityPatterns.add(getDailyLifeActivityDetail(), VRLayout.NORTH);

  }

  /**
   * 内容パネルに内部項目を追加します。
   */
  protected void addDailyLifeActivityDetail(){

    dailyLifeActivityDetail.add(getDailyLifeActivityTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    dailyLifeActivityDetail.add(getDailyLifeActivitListContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    dailyLifeActivityDetail.add(getDailyLifeActivitySelectContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    dailyLifeActivityDetail.add(getDailyLifeActivitInsertButton(), VRLayout.FLOW);

    dailyLifeActivityDetail.add(getDailyLifeActivitFindButton(), VRLayout.FLOW);

    dailyLifeActivityDetail.add(getDailyLifeActivitDeleteButton(), VRLayout.FLOW);

  }

  /**
   * 提供時間コンテナに内部項目を追加します。
   */
  protected void addDailyLifeActivityTimeContena(){

    dailyLifeActivityTimeContena.add(getDailyLifeActivityBeginTimeContainer(), VRLayout.FLOW);

    dailyLifeActivityTimeContena.add(getDailyLifeActivityTimeContenaEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * 開始時刻コンボに内部項目を追加します。
   */
  protected void addDailyLifeActivityBeginTime(){

  }

  /**
   * 開始時刻コンボモデルに内部項目を追加します。
   */
  protected void addDailyLifeActivityBeginTimeModel(){

  }

  /**
   * 終了時刻コンボに内部項目を追加します。
   */
  protected void addDailyLifeActivityTimeContenaEndTime(){

  }

  /**
   * 終了時刻コンボモデルに内部項目を追加します。
   */
  protected void addDailyLifeActivityTimeContenaEndTimeModel(){

  }

  /**
   * 主な日常生活リストに内部項目を追加します。
   */
  protected void addDailyLifeActivitList(){

  }

  /**
   * 主な日常生活リストモデルに内部項目を追加します。
   */
  protected void addDailyLifeActivitListModel(){

  }

  /**
   * 内容詳細テキストに内部項目を追加します。
   */
  protected void addDailyLifeActivitySelect(){

  }

  /**
   * 追加に内部項目を追加します。
   */
  protected void addDailyLifeActivitInsertButton(){

  }

  /**
   * 編集に内部項目を追加します。
   */
  protected void addDailyLifeActivitFindButton(){

  }

  /**
   * 削除に内部項目を追加します。
   */
  protected void addDailyLifeActivitDeleteButton(){

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
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QS001_90101_201204Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001_90101_201204Design getThis() {
    return this;
  }
}
