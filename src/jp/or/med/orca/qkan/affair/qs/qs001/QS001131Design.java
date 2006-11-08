
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
 * 作成日: 2006/05/10  日本コンピューター株式会社 松本　幸一 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン介護予防訪問入浴介護 (QS001131)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
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
import jp.nichicom.ac.component.table.event.*;
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
 * サービスパターン介護予防訪問入浴介護画面項目デザイン(QS001131) 
 */
public class QS001131Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACPanel preventiveVisitBathCareMultiPatterns;

  private ACClearableRadioButtonGroup visitPersonAddRadio;

  private ACLabelContainer visitPersonAddRadioContainer;

  private ACListModelAdapter visitPersonAddRadioModel;

  private ACRadioButtonItem visitPersonAddRadioItem1;

  private ACRadioButtonItem visitPersonAddRadioItem2;

  private ACClearableRadioButtonGroup bathCareDivisionAddRadio;

  private ACLabelContainer bathCareDivisionAddRadioContainer;

  private ACListModelAdapter bathCareDivisionAddRadioModel;

  private ACRadioButtonItem bathCareDivisionAddRadioItem1;

  private ACRadioButtonItem bathCareDivisionAddRadioItem2;

  private ACBackLabelContainer homonNyuyokuTimeContainer;

  private ACTimeComboBox homonNyuyokuBeginTime;

  private ACLabelContainer homonNyuyokuBeginTimeContainer;

  private ACComboBoxModelAdapter homonNyuyokuBeginTimeModel;

  private ACTimeComboBox homonNyuyokuEndTime;

  private ACLabelContainer homonNyuyokuEndTimeContainer;

  private ACComboBoxModelAdapter homonNyuyokuEndTimeModel;

  //getter

  /**
   * 介護予防訪問入浴介護パターン領域を取得します。
   * @return 介護予防訪問入浴介護パターン領域
   */
  public ACPanel getPreventiveVisitBathCareMultiPatterns(){
    if(preventiveVisitBathCareMultiPatterns==null){

      preventiveVisitBathCareMultiPatterns = new ACPanel();

      preventiveVisitBathCareMultiPatterns.setAutoWrap(false);

      preventiveVisitBathCareMultiPatterns.setHgrid(200);

      addPreventiveVisitBathCareMultiPatterns();
    }
    return preventiveVisitBathCareMultiPatterns;

  }

  /**
   * 訪問者の人数を取得します。
   * @return 訪問者の人数
   */
  public ACClearableRadioButtonGroup getVisitPersonAddRadio(){
    if(visitPersonAddRadio==null){

      visitPersonAddRadio = new ACClearableRadioButtonGroup();

      getVisitPersonAddRadioContainer().setText("訪問者の人数");

      visitPersonAddRadio.setBindPath("1620101");

      visitPersonAddRadio.setUseClearButton(false);

      visitPersonAddRadio.setModel(getVisitPersonAddRadioModel());

      addVisitPersonAddRadio();
    }
    return visitPersonAddRadio;

  }

  /**
   * 訪問者の人数コンテナを取得します。
   * @return 訪問者の人数コンテナ
   */
  protected ACLabelContainer getVisitPersonAddRadioContainer(){
    if(visitPersonAddRadioContainer==null){
      visitPersonAddRadioContainer = new ACLabelContainer();
      visitPersonAddRadioContainer.setFollowChildEnabled(true);
      visitPersonAddRadioContainer.setVAlignment(VRLayout.CENTER);
      visitPersonAddRadioContainer.add(getVisitPersonAddRadio(), null);
    }
    return visitPersonAddRadioContainer;
  }

  /**
   * 訪問者の人数モデルを取得します。
   * @return 訪問者の人数モデル
   */
  protected ACListModelAdapter getVisitPersonAddRadioModel(){
    if(visitPersonAddRadioModel==null){
      visitPersonAddRadioModel = new ACListModelAdapter();
      addVisitPersonAddRadioModel();
    }
    return visitPersonAddRadioModel;
  }

  /**
   * 看護職員1人及び介護職員1人を取得します。
   * @return 看護職員1人及び介護職員1人
   */
  public ACRadioButtonItem getVisitPersonAddRadioItem1(){
    if(visitPersonAddRadioItem1==null){

      visitPersonAddRadioItem1 = new ACRadioButtonItem();

      visitPersonAddRadioItem1.setText("看護職員1人及び介護職員1人");

      visitPersonAddRadioItem1.setGroup(getVisitPersonAddRadio());

      visitPersonAddRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addVisitPersonAddRadioItem1();
    }
    return visitPersonAddRadioItem1;

  }

  /**
   * 介護職員2人を取得します。
   * @return 介護職員2人
   */
  public ACRadioButtonItem getVisitPersonAddRadioItem2(){
    if(visitPersonAddRadioItem2==null){

      visitPersonAddRadioItem2 = new ACRadioButtonItem();

      visitPersonAddRadioItem2.setText("介護職員2人");

      visitPersonAddRadioItem2.setGroup(getVisitPersonAddRadio());

      visitPersonAddRadioItem2.setConstraints(VRLayout.FLOW);

      addVisitPersonAddRadioItem2();
    }
    return visitPersonAddRadioItem2;

  }

  /**
   * 入浴介護区分を取得します。
   * @return 入浴介護区分
   */
  public ACClearableRadioButtonGroup getBathCareDivisionAddRadio(){
    if(bathCareDivisionAddRadio==null){

      bathCareDivisionAddRadio = new ACClearableRadioButtonGroup();

      getBathCareDivisionAddRadioContainer().setText("入浴介護区分");

      bathCareDivisionAddRadio.setBindPath("1620102");

      bathCareDivisionAddRadio.setUseClearButton(false);

      bathCareDivisionAddRadio.setModel(getBathCareDivisionAddRadioModel());

      addBathCareDivisionAddRadio();
    }
    return bathCareDivisionAddRadio;

  }

  /**
   * 入浴介護区分コンテナを取得します。
   * @return 入浴介護区分コンテナ
   */
  protected ACLabelContainer getBathCareDivisionAddRadioContainer(){
    if(bathCareDivisionAddRadioContainer==null){
      bathCareDivisionAddRadioContainer = new ACLabelContainer();
      bathCareDivisionAddRadioContainer.setFollowChildEnabled(true);
      bathCareDivisionAddRadioContainer.setVAlignment(VRLayout.CENTER);
      bathCareDivisionAddRadioContainer.add(getBathCareDivisionAddRadio(), null);
    }
    return bathCareDivisionAddRadioContainer;
  }

  /**
   * 入浴介護区分モデルを取得します。
   * @return 入浴介護区分モデル
   */
  protected ACListModelAdapter getBathCareDivisionAddRadioModel(){
    if(bathCareDivisionAddRadioModel==null){
      bathCareDivisionAddRadioModel = new ACListModelAdapter();
      addBathCareDivisionAddRadioModel();
    }
    return bathCareDivisionAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getBathCareDivisionAddRadioItem1(){
    if(bathCareDivisionAddRadioItem1==null){

      bathCareDivisionAddRadioItem1 = new ACRadioButtonItem();

      bathCareDivisionAddRadioItem1.setText("なし");

      bathCareDivisionAddRadioItem1.setGroup(getBathCareDivisionAddRadio());

      bathCareDivisionAddRadioItem1.setConstraints(VRLayout.FLOW);

      addBathCareDivisionAddRadioItem1();
    }
    return bathCareDivisionAddRadioItem1;

  }

  /**
   * 部分浴・清拭のみを取得します。
   * @return 部分浴・清拭のみ
   */
  public ACRadioButtonItem getBathCareDivisionAddRadioItem2(){
    if(bathCareDivisionAddRadioItem2==null){

      bathCareDivisionAddRadioItem2 = new ACRadioButtonItem();

      bathCareDivisionAddRadioItem2.setText("部分浴・清拭のみ");

      bathCareDivisionAddRadioItem2.setGroup(getBathCareDivisionAddRadio());

      bathCareDivisionAddRadioItem2.setConstraints(VRLayout.FLOW);

      addBathCareDivisionAddRadioItem2();
    }
    return bathCareDivisionAddRadioItem2;

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
  public QS001131Design() {

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

    this.add(getPreventiveVisitBathCareMultiPatterns(), VRLayout.CLIENT);

  }

  /**
   * 介護予防訪問入浴介護パターン領域に内部項目を追加します。
   */
  protected void addPreventiveVisitBathCareMultiPatterns(){

    preventiveVisitBathCareMultiPatterns.add(getVisitPersonAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    preventiveVisitBathCareMultiPatterns.add(getBathCareDivisionAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    preventiveVisitBathCareMultiPatterns.add(getHomonNyuyokuTimeContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * 訪問者の人数に内部項目を追加します。
   */
  protected void addVisitPersonAddRadio(){

  }

  /**
   * 訪問者の人数モデルに内部項目を追加します。
   */
  protected void addVisitPersonAddRadioModel(){

    getVisitPersonAddRadioItem1().setButtonIndex(1);
    getVisitPersonAddRadioModel().add(getVisitPersonAddRadioItem1());

    getVisitPersonAddRadioItem2().setButtonIndex(2);
    getVisitPersonAddRadioModel().add(getVisitPersonAddRadioItem2());

  }

  /**
   * 看護職員1人及び介護職員1人に内部項目を追加します。
   */
  protected void addVisitPersonAddRadioItem1(){

  }

  /**
   * 介護職員2人に内部項目を追加します。
   */
  protected void addVisitPersonAddRadioItem2(){

  }

  /**
   * 入浴介護区分に内部項目を追加します。
   */
  protected void addBathCareDivisionAddRadio(){

  }

  /**
   * 入浴介護区分モデルに内部項目を追加します。
   */
  protected void addBathCareDivisionAddRadioModel(){

    getBathCareDivisionAddRadioItem1().setButtonIndex(1);
    getBathCareDivisionAddRadioModel().add(getBathCareDivisionAddRadioItem1());

    getBathCareDivisionAddRadioItem2().setButtonIndex(2);
    getBathCareDivisionAddRadioModel().add(getBathCareDivisionAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addBathCareDivisionAddRadioItem1(){

  }

  /**
   * 部分浴・清拭のみに内部項目を追加します。
   */
  protected void addBathCareDivisionAddRadioItem2(){

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
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QS001131Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001131Design getThis() {
    return this;
  }
}
