
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
 * 作成日: 2006/05/09  日本コンピューター株式会社 松本　幸一 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン介護予防訪問介護 (QS001130)
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
 * サービスパターン介護予防訪問介護画面項目デザイン(QS001130) 
 */
public class QS001130Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACPanel preventiveVisitCareMultiPatterns;

  private ACClearableRadioButtonGroup visitCareExpenseAddRadio;

  private ACLabelContainer visitCareExpenseAddRadioContainer;

  private ACListModelAdapter visitCareExpenseAddRadioModel;

  private ACRadioButtonItem visitCareExpenseAddRadioItem1;

  private ACRadioButtonItem visitCareExpenseAddRadioItem2;

  private ACRadioButtonItem visitCareExpenseAddRadioItem3;

  private ACClearableRadioButtonGroup classEmploymentAddRadio;

  private ACLabelContainer classEmploymentAddRadioContainer;

  private ACListModelAdapter classEmploymentAddRadioModel;

  private ACRadioButtonItem classEmploymentAddRadioItem1;

  private ACRadioButtonItem classEmploymentAddRadioItem2;

  private ACIntegerCheckBox crackOnDayCheck;

  private ACBackLabelContainer houmonKaigoTimeContainer;

  private ACTimeComboBox houmonKaigoBeginTime;

  private ACLabelContainer houmonKaigoBeginTimeContainer;

  private ACComboBoxModelAdapter houmonKaigoBeginTimeModel;

  private ACTimeComboBox houmonKaigoEndTime;

  private ACLabelContainer houmonKaigoEndTimeContainer;

  private ACComboBoxModelAdapter houmonKaigoEndTimeModel;

  //getter

  /**
   * 介護予防訪問介護パターン領域を取得します。
   * @return 介護予防訪問介護パターン領域
   */
  public ACPanel getPreventiveVisitCareMultiPatterns(){
    if(preventiveVisitCareMultiPatterns==null){

      preventiveVisitCareMultiPatterns = new ACPanel();

      preventiveVisitCareMultiPatterns.setAutoWrap(false);

      preventiveVisitCareMultiPatterns.setHgrid(200);

      addPreventiveVisitCareMultiPatterns();
    }
    return preventiveVisitCareMultiPatterns;

  }

  /**
   * 訪問介護費を取得します。
   * @return 訪問介護費
   */
  public ACClearableRadioButtonGroup getVisitCareExpenseAddRadio(){
    if(visitCareExpenseAddRadio==null){

      visitCareExpenseAddRadio = new ACClearableRadioButtonGroup();

      getVisitCareExpenseAddRadioContainer().setText("訪問介護費");

      visitCareExpenseAddRadio.setBindPath("1610101");

      visitCareExpenseAddRadio.setUseClearButton(false);

      visitCareExpenseAddRadio.setModel(getVisitCareExpenseAddRadioModel());

      addVisitCareExpenseAddRadio();
    }
    return visitCareExpenseAddRadio;

  }

  /**
   * 訪問介護費コンテナを取得します。
   * @return 訪問介護費コンテナ
   */
  protected ACLabelContainer getVisitCareExpenseAddRadioContainer(){
    if(visitCareExpenseAddRadioContainer==null){
      visitCareExpenseAddRadioContainer = new ACLabelContainer();
      visitCareExpenseAddRadioContainer.setFollowChildEnabled(true);
      visitCareExpenseAddRadioContainer.setVAlignment(VRLayout.CENTER);
      visitCareExpenseAddRadioContainer.add(getVisitCareExpenseAddRadio(), null);
    }
    return visitCareExpenseAddRadioContainer;
  }

  /**
   * 訪問介護費モデルを取得します。
   * @return 訪問介護費モデル
   */
  protected ACListModelAdapter getVisitCareExpenseAddRadioModel(){
    if(visitCareExpenseAddRadioModel==null){
      visitCareExpenseAddRadioModel = new ACListModelAdapter();
      addVisitCareExpenseAddRadioModel();
    }
    return visitCareExpenseAddRadioModel;
  }

  /**
   * Ⅰ型を取得します。
   * @return Ⅰ型
   */
  public ACRadioButtonItem getVisitCareExpenseAddRadioItem1(){
    if(visitCareExpenseAddRadioItem1==null){

      visitCareExpenseAddRadioItem1 = new ACRadioButtonItem();

      visitCareExpenseAddRadioItem1.setText("Ⅰ型");

      visitCareExpenseAddRadioItem1.setGroup(getVisitCareExpenseAddRadio());

      visitCareExpenseAddRadioItem1.setConstraints(VRLayout.FLOW);

      addVisitCareExpenseAddRadioItem1();
    }
    return visitCareExpenseAddRadioItem1;

  }

  /**
   * Ⅱ型を取得します。
   * @return Ⅱ型
   */
  public ACRadioButtonItem getVisitCareExpenseAddRadioItem2(){
    if(visitCareExpenseAddRadioItem2==null){

      visitCareExpenseAddRadioItem2 = new ACRadioButtonItem();

      visitCareExpenseAddRadioItem2.setText("Ⅱ型");

      visitCareExpenseAddRadioItem2.setGroup(getVisitCareExpenseAddRadio());

      visitCareExpenseAddRadioItem2.setConstraints(VRLayout.FLOW);

      addVisitCareExpenseAddRadioItem2();
    }
    return visitCareExpenseAddRadioItem2;

  }

  /**
   * Ⅲ型を取得します。
   * @return Ⅲ型
   */
  public ACRadioButtonItem getVisitCareExpenseAddRadioItem3(){
    if(visitCareExpenseAddRadioItem3==null){

      visitCareExpenseAddRadioItem3 = new ACRadioButtonItem();

      visitCareExpenseAddRadioItem3.setText("Ⅲ型");

      visitCareExpenseAddRadioItem3.setGroup(getVisitCareExpenseAddRadio());

      visitCareExpenseAddRadioItem3.setConstraints(VRLayout.FLOW);

      addVisitCareExpenseAddRadioItem3();
    }
    return visitCareExpenseAddRadioItem3;

  }

  /**
   * 訪問者の級職を取得します。
   * @return 訪問者の級職
   */
  public ACClearableRadioButtonGroup getClassEmploymentAddRadio(){
    if(classEmploymentAddRadio==null){

      classEmploymentAddRadio = new ACClearableRadioButtonGroup();

      getClassEmploymentAddRadioContainer().setText("訪問者の級職");

      classEmploymentAddRadio.setBindPath("1610102");

      classEmploymentAddRadio.setUseClearButton(false);

      classEmploymentAddRadio.setModel(getClassEmploymentAddRadioModel());

      addClassEmploymentAddRadio();
    }
    return classEmploymentAddRadio;

  }

  /**
   * 訪問者の級職コンテナを取得します。
   * @return 訪問者の級職コンテナ
   */
  protected ACLabelContainer getClassEmploymentAddRadioContainer(){
    if(classEmploymentAddRadioContainer==null){
      classEmploymentAddRadioContainer = new ACLabelContainer();
      classEmploymentAddRadioContainer.setFollowChildEnabled(true);
      classEmploymentAddRadioContainer.setVAlignment(VRLayout.CENTER);
      classEmploymentAddRadioContainer.add(getClassEmploymentAddRadio(), null);
    }
    return classEmploymentAddRadioContainer;
  }

  /**
   * 訪問者の級職モデルを取得します。
   * @return 訪問者の級職モデル
   */
  protected ACListModelAdapter getClassEmploymentAddRadioModel(){
    if(classEmploymentAddRadioModel==null){
      classEmploymentAddRadioModel = new ACListModelAdapter();
      addClassEmploymentAddRadioModel();
    }
    return classEmploymentAddRadioModel;
  }

  /**
   * 3級以外を取得します。
   * @return 3級以外
   */
  public ACRadioButtonItem getClassEmploymentAddRadioItem1(){
    if(classEmploymentAddRadioItem1==null){

      classEmploymentAddRadioItem1 = new ACRadioButtonItem();

      classEmploymentAddRadioItem1.setText("3級以外");

      classEmploymentAddRadioItem1.setGroup(getClassEmploymentAddRadio());

      classEmploymentAddRadioItem1.setConstraints(VRLayout.FLOW);

      addClassEmploymentAddRadioItem1();
    }
    return classEmploymentAddRadioItem1;

  }

  /**
   * 3級を取得します。
   * @return 3級
   */
  public ACRadioButtonItem getClassEmploymentAddRadioItem2(){
    if(classEmploymentAddRadioItem2==null){

      classEmploymentAddRadioItem2 = new ACRadioButtonItem();

      classEmploymentAddRadioItem2.setText("3級");

      classEmploymentAddRadioItem2.setGroup(getClassEmploymentAddRadio());

      classEmploymentAddRadioItem2.setConstraints(VRLayout.FLOW);

      addClassEmploymentAddRadioItem2();
    }
    return classEmploymentAddRadioItem2;

  }

  /**
   * 日割を取得します。
   * @return 日割
   */
  public ACIntegerCheckBox getCrackOnDayCheck(){
    if(crackOnDayCheck==null){

      crackOnDayCheck = new ACIntegerCheckBox();

      crackOnDayCheck.setText("日割");

      crackOnDayCheck.setBindPath("1610103");

      crackOnDayCheck.setSelectValue(2);

      crackOnDayCheck.setUnSelectValue(1);

      addCrackOnDayCheck();
    }
    return crackOnDayCheck;

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

      houmonKaigoBeginTime.setRenderBindPath("CONTENT");

      houmonKaigoBeginTime.setModel(getHoumonKaigoBeginTimeModel());

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
      houmonKaigoBeginTimeContainer.setFollowChildEnabled(true);
      houmonKaigoBeginTimeContainer.setVAlignment(VRLayout.CENTER);
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

      houmonKaigoEndTime.setRenderBindPath("CONTENT");

      houmonKaigoEndTime.setModel(getHoumonKaigoEndTimeModel());

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
      houmonKaigoEndTimeContainer.setFollowChildEnabled(true);
      houmonKaigoEndTimeContainer.setVAlignment(VRLayout.CENTER);
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
   * コンストラクタです。
   */
  public QS001130Design() {

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

    this.add(getPreventiveVisitCareMultiPatterns(), VRLayout.CLIENT);

  }

  /**
   * 介護予防訪問介護パターン領域に内部項目を追加します。
   */
  protected void addPreventiveVisitCareMultiPatterns(){

    preventiveVisitCareMultiPatterns.add(getVisitCareExpenseAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    preventiveVisitCareMultiPatterns.add(getClassEmploymentAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    preventiveVisitCareMultiPatterns.add(getCrackOnDayCheck(), VRLayout.FLOW_RETURN);

    preventiveVisitCareMultiPatterns.add(getHoumonKaigoTimeContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * 訪問介護費に内部項目を追加します。
   */
  protected void addVisitCareExpenseAddRadio(){

  }

  /**
   * 訪問介護費モデルに内部項目を追加します。
   */
  protected void addVisitCareExpenseAddRadioModel(){

    getVisitCareExpenseAddRadioItem1().setButtonIndex(1);
    getVisitCareExpenseAddRadioModel().add(getVisitCareExpenseAddRadioItem1());

    getVisitCareExpenseAddRadioItem2().setButtonIndex(2);
    getVisitCareExpenseAddRadioModel().add(getVisitCareExpenseAddRadioItem2());

    getVisitCareExpenseAddRadioItem3().setButtonIndex(3);
    getVisitCareExpenseAddRadioModel().add(getVisitCareExpenseAddRadioItem3());

  }

  /**
   * Ⅰ型に内部項目を追加します。
   */
  protected void addVisitCareExpenseAddRadioItem1(){

  }

  /**
   * Ⅱ型に内部項目を追加します。
   */
  protected void addVisitCareExpenseAddRadioItem2(){

  }

  /**
   * Ⅲ型に内部項目を追加します。
   */
  protected void addVisitCareExpenseAddRadioItem3(){

  }

  /**
   * 訪問者の級職に内部項目を追加します。
   */
  protected void addClassEmploymentAddRadio(){

  }

  /**
   * 訪問者の級職モデルに内部項目を追加します。
   */
  protected void addClassEmploymentAddRadioModel(){

    getClassEmploymentAddRadioItem1().setButtonIndex(1);
    getClassEmploymentAddRadioModel().add(getClassEmploymentAddRadioItem1());

    getClassEmploymentAddRadioItem2().setButtonIndex(2);
    getClassEmploymentAddRadioModel().add(getClassEmploymentAddRadioItem2());

  }

  /**
   * 3級以外に内部項目を追加します。
   */
  protected void addClassEmploymentAddRadioItem1(){

  }

  /**
   * 3級に内部項目を追加します。
   */
  protected void addClassEmploymentAddRadioItem2(){

  }

  /**
   * 日割に内部項目を追加します。
   */
  protected void addCrackOnDayCheck(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001130Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001130Design getThis() {
    return this;
  }
}
