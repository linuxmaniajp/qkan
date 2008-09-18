
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
 * 作成日: 2007/12/13  日本コンピューター株式会社 小笠　貴志 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービス予定 (QS001)
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
 * サービス予定画面項目デザイン(QS001) 
 */
public class QS001Design extends QkanAffairContainer implements ACAffairable {
  //GUIコンポーネント

  private ACAffairButtonBar buttons;

  private ACAffairButton clearPlan;

  private ACAffairButton openPlan;

  private ACAffairButton clearResult;

  private ACAffairButton openResult;

  private ACAffairButton insert;

  private ACAffairButton update;

  private ACAffairButton printWeekly;

  private ACAffairButton printMonthly;

  private ACPanel contents;

  private ACPanel leftContents;

  private ACGroupBox serviceKinds;

  private ACListBox serviceKindList;

  private ACListModelAdapter serviceKindListModel;

  private ACGroupBox servicePatterns;

  private QS001DaySchedule patternList;

  private ACPanel patternListButtons;

  private ACButton patternAdd;

  private ACButton patternDelete;

  private ACButton patternNameChange;

  private ACGroupBox servuceDetails;

  private ACPanel serviceOfferEntrepreneurs;

  private ACComboBox serviceOfferEntrepreneur;

  private ACLabelContainer serviceOfferEntrepreneurContainer;

  private ACComboBoxModelAdapter serviceOfferEntrepreneurModel;

  private ACPanel serviceContentSettings;

  private ACLabel noServiceInfomation;

  private ACPanel serviceContentSettingButtons;

  private ACButton serviceSet;

  private ACButton serviceDelete;

  private QS001DraggableButton picture;

  private ACPanel rightContents;

  private ACGroupBox patientInfos;

  private ACLabel targetYearMonth;

  private ACLabel patientName;

  private ACLabel patientInsuredID;

  private ACPanel yokaigodoLimits;

  private ACTextField yokaigodo;

  private ACLabelContainer yokaigodoContainer;

  private ACPanel chartButtons;

  private ACButton changeChart;

  private ACLabel calendarInfomation;

  private ACPanel charts;

  //getter

  /**
   * ボタンバーを取得します。
   * @return ボタンバー
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("サービス予定");

      addButtons();
    }
    return buttons;

  }

  /**
   * クリア(予定)を取得します。
   * @return クリア(予定)
   */
  public ACAffairButton getClearPlan(){
    if(clearPlan==null){

      clearPlan = new ACAffairButton();

      clearPlan.setText("クリア(C)");

      clearPlan.setToolTipText("予定情報をクリアします。");

      clearPlan.setMnemonic('C');

      clearPlan.setIconPath(ACConstants.ICON_PATH_CLEAR_24);

      addClearPlan();
    }
    return clearPlan;

  }

  /**
   * 前回読込(予定)を取得します。
   * @return 前回読込(予定)
   */
  public ACAffairButton getOpenPlan(){
    if(openPlan==null){

      openPlan = new ACAffairButton();

      openPlan.setText("前回読込(O)");

      openPlan.setToolTipText("過去に立てた予定の中で、最新の予定情報を転記します。");

      openPlan.setMnemonic('O');

      openPlan.setIconPath(ACConstants.ICON_PATH_OPEN_24);

      addOpenPlan();
    }
    return openPlan;

  }

  /**
   * クリア(実績)を取得します。
   * @return クリア(実績)
   */
  public ACAffairButton getClearResult(){
    if(clearResult==null){

      clearResult = new ACAffairButton();

      clearResult.setText("クリア(C)");

      clearResult.setToolTipText("実績情報をクリアします。");

      clearResult.setMnemonic('C');

      clearResult.setIconPath(ACConstants.ICON_PATH_CLEAR_24);

      addClearResult();
    }
    return clearResult;

  }

  /**
   * 予定読込(実績)を取得します。
   * @return 予定読込(実績)
   */
  public ACAffairButton getOpenResult(){
    if(openResult==null){

      openResult = new ACAffairButton();

      openResult.setText("予定読込(O)");

      openResult.setToolTipText("実績の全消去と予定の読込を行います。");

      openResult.setMnemonic('O');

      openResult.setIconPath(ACConstants.ICON_PATH_OPEN_24);

      addOpenResult();
    }
    return openResult;

  }

  /**
   * 登録を取得します。
   * @return 登録
   */
  public ACAffairButton getInsert(){
    if(insert==null){

      insert = new ACAffairButton();

      insert.setText("登録(S)");

      insert.setToolTipText("現在の内容を登録します。");

      insert.setMnemonic('S');

      insert.setIconPath(ACConstants.ICON_PATH_UPDATE_24);

      addInsert();
    }
    return insert;

  }

  /**
   * 更新を取得します。
   * @return 更新
   */
  public ACAffairButton getUpdate(){
    if(update==null){

      update = new ACAffairButton();

      update.setText("更新(S)");

      update.setToolTipText("現在の内容を更新します。");

      update.setMnemonic('S');

      update.setIconPath(ACConstants.ICON_PATH_UPDATE_24);

      addUpdate();
    }
    return update;

  }

  /**
   * 印刷(週間表)を取得します。
   * @return 印刷(週間表)
   */
  public ACAffairButton getPrintWeekly(){
    if(printWeekly==null){

      printWeekly = new ACAffairButton();

      printWeekly.setText("印刷(P)");

      printWeekly.setToolTipText("「週間サービス計画表」を印刷します。");

      printWeekly.setMnemonic('P');

      printWeekly.setIconPath(ACConstants.ICON_PATH_PRINT_24);

      addPrintWeekly();
    }
    return printWeekly;

  }

  /**
   * 印刷(月間表)を取得します。
   * @return 印刷(月間表)
   */
  public ACAffairButton getPrintMonthly(){
    if(printMonthly==null){

      printMonthly = new ACAffairButton();

      printMonthly.setText("印刷(P)");

      printMonthly.setToolTipText("「サービス予定票・提供票」を印刷します。");

      printMonthly.setMnemonic('P');

      printMonthly.setIconPath(ACConstants.ICON_PATH_PRINT_24);

      addPrintMonthly();
    }
    return printMonthly;

  }

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
   * 左領域を取得します。
   * @return 左領域
   */
  public ACPanel getLeftContents(){
    if(leftContents==null){

      leftContents = new ACPanel();

      addLeftContents();
    }
    return leftContents;

  }

  /**
   * サービス選択領域を取得します。
   * @return サービス選択領域
   */
  public ACGroupBox getServiceKinds(){
    if(serviceKinds==null){

      serviceKinds = new ACGroupBox();

      serviceKinds.setText("１.サービスの選択");

      addServiceKinds();
    }
    return serviceKinds;

  }

  /**
   * サービス種類リストを取得します。
   * @return サービス種類リスト
   */
  public ACListBox getServiceKindList(){
    if(serviceKindList==null){

      serviceKindList = new ACListBox();

      serviceKindList.setModel(getServiceKindListModel());

      serviceKindList.setPreferredSize(new Dimension(240,120));

      addServiceKindList();
    }
    return serviceKindList;

  }

  /**
   * サービス種類リストモデルを取得します。
   * @return サービス種類リストモデル
   */
  protected ACListModelAdapter getServiceKindListModel(){
    if(serviceKindListModel==null){
      serviceKindListModel = new ACListModelAdapter();
      addServiceKindListModel();
    }
    return serviceKindListModel;
  }

  /**
   * パターン追加・削除領域を取得します。
   * @return パターン追加・削除領域
   */
  public ACGroupBox getServicePatterns(){
    if(servicePatterns==null){

      servicePatterns = new ACGroupBox();

      servicePatterns.setText("パターン追加/削除");

      addServicePatterns();
    }
    return servicePatterns;

  }

  /**
   * パターンリストを取得します。
   * @return パターンリスト
   */
  public QS001DaySchedule getPatternList(){
    if(patternList==null){

      patternList = new QS001DaySchedule();

      patternList.setPreferredSize(new Dimension(100,80));

      patternList.setMoveMode(false);

      patternList.setRecieveMode(false);

      addPatternList();
    }
    return patternList;

  }

  /**
   * パターンボタン領域を取得します。
   * @return パターンボタン領域
   */
  public ACPanel getPatternListButtons(){
    if(patternListButtons==null){

      patternListButtons = new ACPanel();

      patternListButtons.setHgap(0);

      addPatternListButtons();
    }
    return patternListButtons;

  }

  /**
   * パターン-追加を取得します。
   * @return パターン-追加
   */
  public ACButton getPatternAdd(){
    if(patternAdd==null){

      patternAdd = new ACButton();

      patternAdd.setText("追加");

      addPatternAdd();
    }
    return patternAdd;

  }

  /**
   * パターン-削除を取得します。
   * @return パターン-削除
   */
  public ACButton getPatternDelete(){
    if(patternDelete==null){

      patternDelete = new ACButton();

      patternDelete.setText("削除");

      addPatternDelete();
    }
    return patternDelete;

  }

  /**
   * パターン-変更を取得します。
   * @return パターン-変更
   */
  public ACButton getPatternNameChange(){
    if(patternNameChange==null){

      patternNameChange = new ACButton();

      patternNameChange.setText("名称");

      addPatternNameChange();
    }
    return patternNameChange;

  }

  /**
   * サービス内容登録・選択領域を取得します。
   * @return サービス内容登録・選択領域
   */
  public ACGroupBox getServuceDetails(){
    if(servuceDetails==null){

      servuceDetails = new ACGroupBox();

      servuceDetails.setText("２.サービス内容登録/選択");

      addServuceDetails();
    }
    return servuceDetails;

  }

  /**
   * サービス提供事業所コンボ領域を取得します。
   * @return サービス提供事業所コンボ領域
   */
  public ACPanel getServiceOfferEntrepreneurs(){
    if(serviceOfferEntrepreneurs==null){

      serviceOfferEntrepreneurs = new ACPanel();

      addServiceOfferEntrepreneurs();
    }
    return serviceOfferEntrepreneurs;

  }

  /**
   * サービス提供事業者コンボを取得します。
   * @return サービス提供事業者コンボ
   */
  public ACComboBox getServiceOfferEntrepreneur(){
    if(serviceOfferEntrepreneur==null){

      serviceOfferEntrepreneur = new ACComboBox();

      getServiceOfferEntrepreneurContainer().setText("事業所");

      serviceOfferEntrepreneur.setBindPath("PROVIDER_ID");

      serviceOfferEntrepreneur.setEditable(false);

      serviceOfferEntrepreneur.setRenderBindPath("PROVIDER_NAME");

      serviceOfferEntrepreneur.setModel(getServiceOfferEntrepreneurModel());

      addServiceOfferEntrepreneur();
    }
    return serviceOfferEntrepreneur;

  }

  /**
   * サービス提供事業者コンボコンテナを取得します。
   * @return サービス提供事業者コンボコンテナ
   */
  protected ACLabelContainer getServiceOfferEntrepreneurContainer(){
    if(serviceOfferEntrepreneurContainer==null){
      serviceOfferEntrepreneurContainer = new ACLabelContainer();
      serviceOfferEntrepreneurContainer.setFollowChildEnabled(true);
      serviceOfferEntrepreneurContainer.setVAlignment(VRLayout.CENTER);
      serviceOfferEntrepreneurContainer.add(getServiceOfferEntrepreneur(), VRLayout.CLIENT);
    }
    return serviceOfferEntrepreneurContainer;
  }

  /**
   * サービス提供事業者コンボモデルを取得します。
   * @return サービス提供事業者コンボモデル
   */
  protected ACComboBoxModelAdapter getServiceOfferEntrepreneurModel(){
    if(serviceOfferEntrepreneurModel==null){
      serviceOfferEntrepreneurModel = new ACComboBoxModelAdapter();
      addServiceOfferEntrepreneurModel();
    }
    return serviceOfferEntrepreneurModel;
  }

  /**
   * サービス内容設定領域を取得します。
   * @return サービス内容設定領域
   */
  public ACPanel getServiceContentSettings(){
    if(serviceContentSettings==null){

      serviceContentSettings = new ACPanel();

      serviceContentSettings.setBackground(new Color(233,255,240));

      addServiceContentSettings();
    }
    return serviceContentSettings;

  }

  /**
   * 提供サービスなしの説明を取得します。
   * @return 提供サービスなしの説明
   */
  public ACLabel getNoServiceInfomation(){
    if(noServiceInfomation==null){

      noServiceInfomation = new ACLabel();

      noServiceInfomation.setText("提供可能なサービスがありません。" + ACConstants.LINE_SEPARATOR + "事業所登録画面にて、" + ACConstants.LINE_SEPARATOR + "提供するサービスを" + ACConstants.LINE_SEPARATOR + "登録してください。");

      noServiceInfomation.setIconPath(ACConstants.ICON_PATH_EXCLAMATION_16);

      addNoServiceInfomation();
    }
    return noServiceInfomation;

  }

  /**
   * サービス内容設定ボタン領域を取得します。
   * @return サービス内容設定ボタン領域
   */
  public ACPanel getServiceContentSettingButtons(){
    if(serviceContentSettingButtons==null){

      serviceContentSettingButtons = new ACPanel();

      serviceContentSettingButtons.setAutoWrap(false);

      serviceContentSettingButtons.setHgap(0);

      addServiceContentSettingButtons();
    }
    return serviceContentSettingButtons;

  }

  /**
   * 設定ボタンを取得します。
   * @return 設定ボタン
   */
  public ACButton getServiceSet(){
    if(serviceSet==null){

      serviceSet = new ACButton();

      serviceSet.setText("設定(A)");

      serviceSet.setMnemonic('A');

      addServiceSet();
    }
    return serviceSet;

  }

  /**
   * 削除ボタンを取得します。
   * @return 削除ボタン
   */
  public ACButton getServiceDelete(){
    if(serviceDelete==null){

      serviceDelete = new ACButton();

      serviceDelete.setText("削除(D)");

      serviceDelete.setMnemonic('D');

      addServiceDelete();
    }
    return serviceDelete;

  }

  /**
   * 絵を取得します。
   * @return 絵
   */
  public QS001DraggableButton getPicture(){
    if(picture==null){

      picture = new QS001DraggableButton();

      picture.setIconPath(ACConstants.ICON_PATH_RIGHT_16);

      addPicture();
    }
    return picture;

  }

  /**
   * 右領域を取得します。
   * @return 右領域
   */
  public ACPanel getRightContents(){
    if(rightContents==null){

      rightContents = new ACPanel();

      addRightContents();
    }
    return rightContents;

  }

  /**
   * 利用者情報領域を取得します。
   * @return 利用者情報領域
   */
  public ACGroupBox getPatientInfos(){
    if(patientInfos==null){

      patientInfos = new ACGroupBox();

      patientInfos.setText("利用者情報");

      addPatientInfos();
    }
    return patientInfos;

  }

  /**
   * 対象年月を取得します。
   * @return 対象年月
   */
  public ACLabel getTargetYearMonth(){
    if(targetYearMonth==null){

      targetYearMonth = new ACLabel();

      targetYearMonth.setText("平成99年99月");

      addTargetYearMonth();
    }
    return targetYearMonth;

  }

  /**
   * 利用者氏名を取得します。
   * @return 利用者氏名
   */
  public ACLabel getPatientName(){
    if(patientName==null){

      patientName = new ACLabel();

      patientName.setText("(利用者氏名)");

      addPatientName();
    }
    return patientName;

  }

  /**
   * 利用者被保険者番号を取得します。
   * @return 利用者被保険者番号
   */
  public ACLabel getPatientInsuredID(){
    if(patientInsuredID==null){

      patientInsuredID = new ACLabel();

      patientInsuredID.setText("(利用者被保険者番号)");

      addPatientInsuredID();
    }
    return patientInsuredID;

  }

  /**
   * 要介護度・限度額領域を取得します。
   * @return 要介護度・限度額領域
   */
  public ACPanel getYokaigodoLimits(){
    if(yokaigodoLimits==null){

      yokaigodoLimits = new ACPanel();

      yokaigodoLimits.setAutoWrap(false);

      yokaigodoLimits.setHgap(0);

      addYokaigodoLimits();
    }
    return yokaigodoLimits;

  }

  /**
   * 要介護度を取得します。
   * @return 要介護度
   */
  public ACTextField getYokaigodo(){
    if(yokaigodo==null){

      yokaigodo = new ACTextField();

      getYokaigodoContainer().setText("要介護度");

      yokaigodo.setEditable(false);

      yokaigodo.setColumns(6);

      yokaigodo.setHorizontalAlignment(SwingConstants.CENTER);

      addYokaigodo();
    }
    return yokaigodo;

  }

  /**
   * 要介護度コンテナを取得します。
   * @return 要介護度コンテナ
   */
  protected ACLabelContainer getYokaigodoContainer(){
    if(yokaigodoContainer==null){
      yokaigodoContainer = new ACLabelContainer();
      yokaigodoContainer.setFollowChildEnabled(true);
      yokaigodoContainer.setVAlignment(VRLayout.CENTER);
      yokaigodoContainer.add(getYokaigodo(), null);
    }
    return yokaigodoContainer;
  }

  /**
   * ボタン領域を取得します。
   * @return ボタン領域
   */
  public ACPanel getChartButtons(){
    if(chartButtons==null){

      chartButtons = new ACPanel();

      addChartButtons();
    }
    return chartButtons;

  }

  /**
   * 月間表・週間表切替ボタンを取得します。
   * @return 月間表・週間表切替ボタン
   */
  public ACButton getChangeChart(){
    if(changeChart==null){

      changeChart = new ACButton();

      changeChart.setText("切替");

      addChangeChart();
    }
    return changeChart;

  }

  /**
   * カレンダ説明を取得します。
   * @return カレンダ説明
   */
  public ACLabel getCalendarInfomation(){
    if(calendarInfomation==null){

      calendarInfomation = new ACLabel();

      calendarInfomation.setText("Shiftキーを押しながらドラッグ＆ドロップすると、サービスを複製できます。");

      calendarInfomation.setIconPath(ACConstants.ICON_PATH_INFORMATION_16);

      addCalendarInfomation();
    }
    return calendarInfomation;

  }

  /**
   * 月間表・週間表領域を取得します。
   * @return 月間表・週間表領域
   */
  public ACPanel getCharts(){
    if(charts==null){

      charts = new ACPanel();

      charts.setBackground(new Color(233,240,255));

      addCharts();
    }
    return charts;

  }

  /**
   * コンストラクタです。
   */
  public QS001Design() {

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

    this.add(getButtons(), VRLayout.NORTH);

    this.add(getContents(), VRLayout.CLIENT);

  }

  /**
   * ボタンバーに内部項目を追加します。
   */
  protected void addButtons(){

    buttons.add(getPrintMonthly(), VRLayout.EAST);
    buttons.add(getPrintWeekly(), VRLayout.EAST);
    buttons.add(getUpdate(), VRLayout.EAST);
    buttons.add(getInsert(), VRLayout.EAST);
    buttons.add(getOpenResult(), VRLayout.EAST);
    buttons.add(getClearResult(), VRLayout.EAST);
    buttons.add(getOpenPlan(), VRLayout.EAST);
    buttons.add(getClearPlan(), VRLayout.EAST);
  }

  /**
   * クリア(予定)に内部項目を追加します。
   */
  protected void addClearPlan(){

  }

  /**
   * 前回読込(予定)に内部項目を追加します。
   */
  protected void addOpenPlan(){

  }

  /**
   * クリア(実績)に内部項目を追加します。
   */
  protected void addClearResult(){

  }

  /**
   * 予定読込(実績)に内部項目を追加します。
   */
  protected void addOpenResult(){

  }

  /**
   * 登録に内部項目を追加します。
   */
  protected void addInsert(){

  }

  /**
   * 更新に内部項目を追加します。
   */
  protected void addUpdate(){

  }

  /**
   * 印刷(週間表)に内部項目を追加します。
   */
  protected void addPrintWeekly(){

  }

  /**
   * 印刷(月間表)に内部項目を追加します。
   */
  protected void addPrintMonthly(){

  }

  /**
   * クライアント領域に内部項目を追加します。
   */
  protected void addContents(){

    contents.add(getLeftContents(), VRLayout.WEST);

    contents.add(getRightContents(), VRLayout.CLIENT);

  }

  /**
   * 左領域に内部項目を追加します。
   */
  protected void addLeftContents(){

    leftContents.add(getServiceKinds(), VRLayout.NORTH);

    leftContents.add(getServuceDetails(), VRLayout.CLIENT);

    leftContents.add(getServiceContentSettingButtons(), VRLayout.SOUTH);
  }

  /**
   * サービス選択領域に内部項目を追加します。
   */
  protected void addServiceKinds(){

    serviceKinds.add(getServiceKindList(), VRLayout.NORTH);

    serviceKinds.add(getServicePatterns(), VRLayout.NORTH);

  }

  /**
   * サービス種類リストに内部項目を追加します。
   */
  protected void addServiceKindList(){

  }

  /**
   * サービス種類リストモデルに内部項目を追加します。
   */
  protected void addServiceKindListModel(){

  }

  /**
   * パターン追加・削除領域に内部項目を追加します。
   */
  protected void addServicePatterns(){

    servicePatterns.add(getPatternList(), VRLayout.CLIENT);

    servicePatterns.add(getPatternListButtons(), VRLayout.EAST);
  }

  /**
   * パターンリストに内部項目を追加します。
   */
  protected void addPatternList(){

  }

  /**
   * パターンボタン領域に内部項目を追加します。
   */
  protected void addPatternListButtons(){

    patternListButtons.add(getPatternAdd(), VRLayout.FLOW_RETURN);

    patternListButtons.add(getPatternDelete(), VRLayout.FLOW_RETURN);

    patternListButtons.add(getPatternNameChange(), VRLayout.FLOW_RETURN);

  }

  /**
   * パターン-追加に内部項目を追加します。
   */
  protected void addPatternAdd(){

  }

  /**
   * パターン-削除に内部項目を追加します。
   */
  protected void addPatternDelete(){

  }

  /**
   * パターン-変更に内部項目を追加します。
   */
  protected void addPatternNameChange(){

  }

  /**
   * サービス内容登録・選択領域に内部項目を追加します。
   */
  protected void addServuceDetails(){

    servuceDetails.add(getServiceOfferEntrepreneurs(), VRLayout.NORTH);

    servuceDetails.add(getServiceContentSettings(), VRLayout.CLIENT);

  }

  /**
   * サービス提供事業所コンボ領域に内部項目を追加します。
   */
  protected void addServiceOfferEntrepreneurs(){

    serviceOfferEntrepreneurs.add(getServiceOfferEntrepreneurContainer(), VRLayout.CLIENT);

  }

  /**
   * サービス提供事業者コンボに内部項目を追加します。
   */
  protected void addServiceOfferEntrepreneur(){

  }

  /**
   * サービス提供事業者コンボモデルに内部項目を追加します。
   */
  protected void addServiceOfferEntrepreneurModel(){

  }

  /**
   * サービス内容設定領域に内部項目を追加します。
   */
  protected void addServiceContentSettings(){

    serviceContentSettings.add(getNoServiceInfomation(), VRLayout.CLIENT);

  }

  /**
   * 提供サービスなしの説明に内部項目を追加します。
   */
  protected void addNoServiceInfomation(){

  }

  /**
   * サービス内容設定ボタン領域に内部項目を追加します。
   */
  protected void addServiceContentSettingButtons(){

    serviceContentSettingButtons.add(getServiceSet(), VRLayout.FLOW);

    serviceContentSettingButtons.add(getServiceDelete(), VRLayout.FLOW);

    serviceContentSettingButtons.add(getPicture(), VRLayout.FLOW);

  }

  /**
   * 設定ボタンに内部項目を追加します。
   */
  protected void addServiceSet(){

  }

  /**
   * 削除ボタンに内部項目を追加します。
   */
  protected void addServiceDelete(){

  }

  /**
   * 絵に内部項目を追加します。
   */
  protected void addPicture(){

  }

  /**
   * 右領域に内部項目を追加します。
   */
  protected void addRightContents(){

    rightContents.add(getPatientInfos(), VRLayout.NORTH);

    rightContents.add(getChartButtons(), VRLayout.NORTH);

    rightContents.add(getCharts(), VRLayout.CLIENT);

  }

  /**
   * 利用者情報領域に内部項目を追加します。
   */
  protected void addPatientInfos(){

    patientInfos.add(getTargetYearMonth(), VRLayout.WEST);

    patientInfos.add(getPatientName(), VRLayout.FLOW);

    patientInfos.add(getPatientInsuredID(), VRLayout.FLOW);

    patientInfos.add(getYokaigodoLimits(), VRLayout.EAST);
  }

  /**
   * 対象年月に内部項目を追加します。
   */
  protected void addTargetYearMonth(){

  }

  /**
   * 利用者氏名に内部項目を追加します。
   */
  protected void addPatientName(){

  }

  /**
   * 利用者被保険者番号に内部項目を追加します。
   */
  protected void addPatientInsuredID(){

  }

  /**
   * 要介護度・限度額領域に内部項目を追加します。
   */
  protected void addYokaigodoLimits(){

    yokaigodoLimits.add(getYokaigodoContainer(), VRLayout.FLOW);

  }

  /**
   * 要介護度に内部項目を追加します。
   */
  protected void addYokaigodo(){

  }

  /**
   * ボタン領域に内部項目を追加します。
   */
  protected void addChartButtons(){

    chartButtons.add(getChangeChart(), VRLayout.WEST);

    chartButtons.add(getCalendarInfomation(), VRLayout.CLIENT);

  }

  /**
   * 月間表・週間表切替ボタンに内部項目を追加します。
   */
  protected void addChangeChart(){

  }

  /**
   * カレンダ説明に内部項目を追加します。
   */
  protected void addCalendarInfomation(){

  }

  /**
   * 月間表・週間表領域に内部項目を追加します。
   */
  protected void addCharts(){

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

    return getChangeChart();

  }
  public void initAffair(ACAffairInfo affair) throws Exception {
  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    try {
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QS001Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001Design getThis() {
    return this;
  }
}
