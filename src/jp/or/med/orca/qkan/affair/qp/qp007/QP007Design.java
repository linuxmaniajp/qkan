
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
 * 作成日: 2008/02/27  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス 利用者向け印刷 (007)
 * プログラム 利用者向請求書印刷設定 (QP007)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp007;
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
 * 利用者向請求書印刷設定画面項目デザイン(QP007) 
 */
public class QP007Design extends QkanAffairDialog {
  //GUIコンポーネント

  private ACPanel contents;

  private VRLayout patientBillSetupContentsLayout;

  private ACGroupBox patientBillSetupTargetGroup;

  private VRLayout patientBillSetupTargetGroupLayout;

  private ACPanel patientBillSetupUp;

  private ACPanel patientBillSetupLeft;

  private ACVerticalRadioButtonGroup patientBillSetupPapersRadio;

  private ACLabelContainer patientBillSetupPapersRadioContainer;

  private ACListModelAdapter patientBillSetupPapersRadioModel;

  private ACRadioButtonItem patientBillSetupPapersRadioItem1;

  private ACRadioButtonItem patientBillSetupPapersRadioItem2;

  private ACRadioButtonItem patientBillSetupPapersRadioItem3;

  private ACPanel patientBillSetupRight;

  private QkanDateTextField patientBillSetupBillDate;

  private ACLabelContainer patientBillSetupBillDateContainer;

  private QkanDateTextField patientBillSetupReceiptDate;

  private ACLabelContainer patientBillSetupReceiptDateContainer;

  private ACIntegerCheckBox patientBillSetupBillAndReceiptDate;

  private ACPanel patientBillSetupUnder;

  private ACIntegerCheckBox patientBillSetupUnderPrintOn;

  private ACIntegerCheckBox patientBillSetupMedicalTreatmentOn;

  private ACIntegerCheckBox patientBillSetupDetailsPrintOn;

  private ACPanel buttons;

  private ACPanel buttonsPanelLeft;

  private ACLabel spacer1;

  private ACButton print;

  private ACPanel buttonsPanelRight;

  private ACLabel spacer2;

  private ACButton close;

  //getter

  /**
   * クライアント領域を取得します。
   * @return クライアント領域
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      contents.setLayout(getPatientBillSetupContentsLayout());

      addContents();
    }
    return contents;

  }

  /**
   * クライアント領域・レイアウトを取得します。
   * @return クライアント領域・レイアウト
   */
  public VRLayout getPatientBillSetupContentsLayout(){
    if(patientBillSetupContentsLayout==null){

      patientBillSetupContentsLayout = new VRLayout();

      addPatientBillSetupContentsLayout();
    }
    return patientBillSetupContentsLayout;

  }

  /**
   * 印刷対象・グループを取得します。
   * @return 印刷対象・グループ
   */
  public ACGroupBox getPatientBillSetupTargetGroup(){
    if(patientBillSetupTargetGroup==null){

      patientBillSetupTargetGroup = new ACGroupBox();

      patientBillSetupTargetGroup.setText("印刷対象");

      patientBillSetupTargetGroup.setLayout(getPatientBillSetupTargetGroupLayout());

      addPatientBillSetupTargetGroup();
    }
    return patientBillSetupTargetGroup;

  }

  /**
   * 印刷対象・グループ・レイアウトを取得します。
   * @return 印刷対象・グループ・レイアウト
   */
  public VRLayout getPatientBillSetupTargetGroupLayout(){
    if(patientBillSetupTargetGroupLayout==null){

      patientBillSetupTargetGroupLayout = new VRLayout();

      patientBillSetupTargetGroupLayout.setAutoWrap(false);

      addPatientBillSetupTargetGroupLayout();
    }
    return patientBillSetupTargetGroupLayout;

  }

  /**
   * 印刷設定領域・上を取得します。
   * @return 印刷設定領域・上
   */
  public ACPanel getPatientBillSetupUp(){
    if(patientBillSetupUp==null){

      patientBillSetupUp = new ACPanel();

      addPatientBillSetupUp();
    }
    return patientBillSetupUp;

  }

  /**
   * 印刷設定領域・左を取得します。
   * @return 印刷設定領域・左
   */
  public ACPanel getPatientBillSetupLeft(){
    if(patientBillSetupLeft==null){

      patientBillSetupLeft = new ACPanel();

      addPatientBillSetupLeft();
    }
    return patientBillSetupLeft;

  }

  /**
   * 書類種類ラジオグループを取得します。
   * @return 書類種類ラジオグループ
   */
  public ACVerticalRadioButtonGroup getPatientBillSetupPapersRadio(){
    if(patientBillSetupPapersRadio==null){

      patientBillSetupPapersRadio = new ACVerticalRadioButtonGroup();

      patientBillSetupPapersRadio.setBindPath("TARGET_RADIO");

      patientBillSetupPapersRadio.setUseClearButton(false);

      patientBillSetupPapersRadio.setModel(getPatientBillSetupPapersRadioModel());

      addPatientBillSetupPapersRadio();
    }
    return patientBillSetupPapersRadio;

  }

  /**
   * 書類種類ラジオグループコンテナを取得します。
   * @return 書類種類ラジオグループコンテナ
   */
  protected ACLabelContainer getPatientBillSetupPapersRadioContainer(){
    if(patientBillSetupPapersRadioContainer==null){
      patientBillSetupPapersRadioContainer = new ACLabelContainer();
      patientBillSetupPapersRadioContainer.setFollowChildEnabled(true);
      patientBillSetupPapersRadioContainer.setVAlignment(VRLayout.CENTER);
      patientBillSetupPapersRadioContainer.add(getPatientBillSetupPapersRadio(), null);
    }
    return patientBillSetupPapersRadioContainer;
  }

  /**
   * 書類種類ラジオグループモデルを取得します。
   * @return 書類種類ラジオグループモデル
   */
  protected ACListModelAdapter getPatientBillSetupPapersRadioModel(){
    if(patientBillSetupPapersRadioModel==null){
      patientBillSetupPapersRadioModel = new ACListModelAdapter();
      addPatientBillSetupPapersRadioModel();
    }
    return patientBillSetupPapersRadioModel;
  }

  /**
   * 請求書を取得します。
   * @return 請求書
   */
  public ACRadioButtonItem getPatientBillSetupPapersRadioItem1(){
    if(patientBillSetupPapersRadioItem1==null){

      patientBillSetupPapersRadioItem1 = new ACRadioButtonItem();

      patientBillSetupPapersRadioItem1.setText("請求書");

      patientBillSetupPapersRadioItem1.setGroup(getPatientBillSetupPapersRadio());

      addPatientBillSetupPapersRadioItem1();
    }
    return patientBillSetupPapersRadioItem1;

  }

  /**
   * 領収書を取得します。
   * @return 領収書
   */
  public ACRadioButtonItem getPatientBillSetupPapersRadioItem2(){
    if(patientBillSetupPapersRadioItem2==null){

      patientBillSetupPapersRadioItem2 = new ACRadioButtonItem();

      patientBillSetupPapersRadioItem2.setText("領収書");

      patientBillSetupPapersRadioItem2.setGroup(getPatientBillSetupPapersRadio());

      addPatientBillSetupPapersRadioItem2();
    }
    return patientBillSetupPapersRadioItem2;

  }

  /**
   * 請求書・領収書を取得します。
   * @return 請求書・領収書
   */
  public ACRadioButtonItem getPatientBillSetupPapersRadioItem3(){
    if(patientBillSetupPapersRadioItem3==null){

      patientBillSetupPapersRadioItem3 = new ACRadioButtonItem();

      patientBillSetupPapersRadioItem3.setText("請求書・領収書");

      patientBillSetupPapersRadioItem3.setGroup(getPatientBillSetupPapersRadio());

      addPatientBillSetupPapersRadioItem3();
    }
    return patientBillSetupPapersRadioItem3;

  }

  /**
   * 印刷設定領域・右を取得します。
   * @return 印刷設定領域・右
   */
  public ACPanel getPatientBillSetupRight(){
    if(patientBillSetupRight==null){

      patientBillSetupRight = new ACPanel();

      addPatientBillSetupRight();
    }
    return patientBillSetupRight;

  }

  /**
   * 請求書日付を取得します。
   * @return 請求書日付
   */
  public QkanDateTextField getPatientBillSetupBillDate(){
    if(patientBillSetupBillDate==null){

      patientBillSetupBillDate = new QkanDateTextField();

      getPatientBillSetupBillDateContainer().setText("請求書日付");

      patientBillSetupBillDate.setBindPath("TARGET_DATE");

      addPatientBillSetupBillDate();
    }
    return patientBillSetupBillDate;

  }

  /**
   * 請求書日付コンテナを取得します。
   * @return 請求書日付コンテナ
   */
  protected ACLabelContainer getPatientBillSetupBillDateContainer(){
    if(patientBillSetupBillDateContainer==null){
      patientBillSetupBillDateContainer = new ACLabelContainer();
      patientBillSetupBillDateContainer.setFollowChildEnabled(true);
      patientBillSetupBillDateContainer.setVAlignment(VRLayout.CENTER);
      patientBillSetupBillDateContainer.add(getPatientBillSetupBillDate(), null);
    }
    return patientBillSetupBillDateContainer;
  }

  /**
   * 領収書日付を取得します。
   * @return 領収書日付
   */
  public QkanDateTextField getPatientBillSetupReceiptDate(){
    if(patientBillSetupReceiptDate==null){

      patientBillSetupReceiptDate = new QkanDateTextField();

      getPatientBillSetupReceiptDateContainer().setText("領収書日付");

      patientBillSetupReceiptDate.setBindPath("GET_DATE");

      addPatientBillSetupReceiptDate();
    }
    return patientBillSetupReceiptDate;

  }

  /**
   * 領収書日付コンテナを取得します。
   * @return 領収書日付コンテナ
   */
  protected ACLabelContainer getPatientBillSetupReceiptDateContainer(){
    if(patientBillSetupReceiptDateContainer==null){
      patientBillSetupReceiptDateContainer = new ACLabelContainer();
      patientBillSetupReceiptDateContainer.setFollowChildEnabled(true);
      patientBillSetupReceiptDateContainer.setVAlignment(VRLayout.CENTER);
      patientBillSetupReceiptDateContainer.add(getPatientBillSetupReceiptDate(), null);
    }
    return patientBillSetupReceiptDateContainer;
  }

  /**
   * 合計・小計を印刷するを取得します。
   * @return 合計・小計を印刷する
   */
  public ACIntegerCheckBox getPatientBillSetupBillAndReceiptDate(){
    if(patientBillSetupBillAndReceiptDate==null){

      patientBillSetupBillAndReceiptDate = new ACIntegerCheckBox();

      patientBillSetupBillAndReceiptDate.setText("合計・小計を印刷する");

      patientBillSetupBillAndReceiptDate.setBindPath("TOTAL_CHECK");

      addPatientBillSetupBillAndReceiptDate();
    }
    return patientBillSetupBillAndReceiptDate;

  }

  /**
   * 印刷設定領域・下を取得します。
   * @return 印刷設定領域・下
   */
  public ACPanel getPatientBillSetupUnder(){
    if(patientBillSetupUnder==null){

      patientBillSetupUnder = new ACPanel();

      addPatientBillSetupUnder();
    }
    return patientBillSetupUnder;

  }

  /**
   * 請求書に振込先の枠を印刷するを取得します。
   * @return 請求書に振込先の枠を印刷する
   */
  public ACIntegerCheckBox getPatientBillSetupUnderPrintOn(){
    if(patientBillSetupUnderPrintOn==null){

      patientBillSetupUnderPrintOn = new ACIntegerCheckBox();

      patientBillSetupUnderPrintOn.setText("請求書に振込先の枠を印刷する");

      patientBillSetupUnderPrintOn.setBindPath("PRINT_CHECK");

      addPatientBillSetupUnderPrintOn();
    }
    return patientBillSetupUnderPrintOn;

  }

  /**
   * 医療費控除対応版で出力を取得します。
   * @return 医療費控除対応版で出力
   */
  public ACIntegerCheckBox getPatientBillSetupMedicalTreatmentOn(){
    if(patientBillSetupMedicalTreatmentOn==null){

      patientBillSetupMedicalTreatmentOn = new ACIntegerCheckBox();

      patientBillSetupMedicalTreatmentOn.setText("医療費控除対応版で出力");

      patientBillSetupMedicalTreatmentOn.setBindPath("STYLE_CHECK");

      addPatientBillSetupMedicalTreatmentOn();
    }
    return patientBillSetupMedicalTreatmentOn;

  }

  /**
   * 詳細版で印刷するを取得します。
   * @return 詳細版で印刷する
   */
  public ACIntegerCheckBox getPatientBillSetupDetailsPrintOn(){
    if(patientBillSetupDetailsPrintOn==null){

      patientBillSetupDetailsPrintOn = new ACIntegerCheckBox();

      patientBillSetupDetailsPrintOn.setText("詳細版で印刷する");

      patientBillSetupDetailsPrintOn.setBindPath("DETAILS_CHECK");

      addPatientBillSetupDetailsPrintOn();
    }
    return patientBillSetupDetailsPrintOn;

  }

  /**
   * ボタン領域を取得します。
   * @return ボタン領域
   */
  public ACPanel getButtons(){
    if(buttons==null){

      buttons = new ACPanel();

      buttons.setAutoWrap(false);

      addButtons();
    }
    return buttons;

  }

  /**
   * ボタン配置パネル（左）を取得します。
   * @return ボタン配置パネル（左）
   */
  public ACPanel getButtonsPanelLeft(){
    if(buttonsPanelLeft==null){

      buttonsPanelLeft = new ACPanel();

      addButtonsPanelLeft();
    }
    return buttonsPanelLeft;

  }

  /**
   * スペーサー１を取得します。
   * @return スペーサー１
   */
  public ACLabel getSpacer1(){
    if(spacer1==null){

      spacer1 = new ACLabel();

      spacer1.setText("　　");

      addSpacer1();
    }
    return spacer1;

  }

  /**
   * 印刷を取得します。
   * @return 印刷
   */
  public ACButton getPrint(){
    if(print==null){

      print = new ACButton();

      print.setText("印刷");

      addPrint();
    }
    return print;

  }

  /**
   * ボタン配置パネル（右）を取得します。
   * @return ボタン配置パネル（右）
   */
  public ACPanel getButtonsPanelRight(){
    if(buttonsPanelRight==null){

      buttonsPanelRight = new ACPanel();

      addButtonsPanelRight();
    }
    return buttonsPanelRight;

  }

  /**
   * スペーサー２を取得します。
   * @return スペーサー２
   */
  public ACLabel getSpacer2(){
    if(spacer2==null){

      spacer2 = new ACLabel();

      spacer2.setText("　　");

      addSpacer2();
    }
    return spacer2;

  }

  /**
   * 閉じるを取得します。
   * @return 閉じる
   */
  public ACButton getClose(){
    if(close==null){

      close = new ACButton();

      close.setText("閉じる");

      addClose();
    }
    return close;

  }

  /**
   * コンストラクタです。
   */
  public QP007Design() {

    super(ACFrame.getInstance(), true);
    this.getContentPane().setLayout(new VRLayout());
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    try {
      initialize();

      setSize(520, 220);

      // ウィンドウを中央に配置
      Point pos;
      try{
          pos= ACFrame.getInstance().getLocationOnScreen();
      }catch(Exception ex){
          pos = new Point(0,0);
      }
      Dimension screenSize = ACFrame.getInstance().getSize();
      Dimension frameSize = this.getSize();
      if (frameSize.height > screenSize.height) {
          frameSize.height = screenSize.height;
      }
      if (frameSize.width > screenSize.width) {
          frameSize.width = screenSize.width;
      }
      this.setLocation((int)(pos.getX()+(screenSize.width - frameSize.width) / 2),
              (int)(pos.getY()+(screenSize.height - frameSize.height) / 2));

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

    this.getContentPane().add(getContents(), VRLayout.CLIENT);

  }

  /**
   * クライアント領域に内部項目を追加します。
   */
  protected void addContents(){

    contents.add(getPatientBillSetupTargetGroup(), VRLayout.NORTH);

    contents.add(getButtons(), VRLayout.NORTH);

  }

  /**
   * クライアント領域・レイアウトに内部項目を追加します。
   */
  protected void addPatientBillSetupContentsLayout(){

  }

  /**
   * 印刷対象・グループに内部項目を追加します。
   */
  protected void addPatientBillSetupTargetGroup(){

    patientBillSetupTargetGroup.add(getPatientBillSetupUp(), VRLayout.NORTH);

    patientBillSetupTargetGroup.add(getPatientBillSetupUnder(), VRLayout.NORTH);

  }

  /**
   * 印刷対象・グループ・レイアウトに内部項目を追加します。
   */
  protected void addPatientBillSetupTargetGroupLayout(){

  }

  /**
   * 印刷設定領域・上に内部項目を追加します。
   */
  protected void addPatientBillSetupUp(){

    patientBillSetupUp.add(getPatientBillSetupLeft(), VRLayout.WEST);

    patientBillSetupUp.add(getPatientBillSetupRight(), VRLayout.EAST);
  }

  /**
   * 印刷設定領域・左に内部項目を追加します。
   */
  protected void addPatientBillSetupLeft(){

    patientBillSetupLeft.add(getPatientBillSetupPapersRadioContainer(), VRLayout.FLOW);

  }

  /**
   * 書類種類ラジオグループに内部項目を追加します。
   */
  protected void addPatientBillSetupPapersRadio(){

  }

  /**
   * 書類種類ラジオグループモデルに内部項目を追加します。
   */
  protected void addPatientBillSetupPapersRadioModel(){

    getPatientBillSetupPapersRadioItem1().setButtonIndex(1);

    getPatientBillSetupPapersRadioModel().add(getPatientBillSetupPapersRadioItem1());

    getPatientBillSetupPapersRadioItem2().setButtonIndex(2);

    getPatientBillSetupPapersRadioModel().add(getPatientBillSetupPapersRadioItem2());

    getPatientBillSetupPapersRadioItem3().setButtonIndex(3);

    getPatientBillSetupPapersRadioModel().add(getPatientBillSetupPapersRadioItem3());

  }

  /**
   * 請求書に内部項目を追加します。
   */
  protected void addPatientBillSetupPapersRadioItem1(){

  }

  /**
   * 領収書に内部項目を追加します。
   */
  protected void addPatientBillSetupPapersRadioItem2(){

  }

  /**
   * 請求書・領収書に内部項目を追加します。
   */
  protected void addPatientBillSetupPapersRadioItem3(){

  }

  /**
   * 印刷設定領域・右に内部項目を追加します。
   */
  protected void addPatientBillSetupRight(){

    patientBillSetupRight.add(getPatientBillSetupBillDateContainer(), VRLayout.FLOW_RETURN);

    patientBillSetupRight.add(getPatientBillSetupReceiptDateContainer(), VRLayout.FLOW_RETURN);

    patientBillSetupRight.add(getPatientBillSetupBillAndReceiptDate(), VRLayout.FLOW);

  }

  /**
   * 請求書日付に内部項目を追加します。
   */
  protected void addPatientBillSetupBillDate(){

  }

  /**
   * 領収書日付に内部項目を追加します。
   */
  protected void addPatientBillSetupReceiptDate(){

  }

  /**
   * 合計・小計を印刷するに内部項目を追加します。
   */
  protected void addPatientBillSetupBillAndReceiptDate(){

  }

  /**
   * 印刷設定領域・下に内部項目を追加します。
   */
  protected void addPatientBillSetupUnder(){

    patientBillSetupUnder.add(getPatientBillSetupUnderPrintOn(), VRLayout.FLOW);

    patientBillSetupUnder.add(getPatientBillSetupMedicalTreatmentOn(), VRLayout.FLOW_RETURN);

    patientBillSetupUnder.add(getPatientBillSetupDetailsPrintOn(), VRLayout.FLOW);

  }

  /**
   * 請求書に振込先の枠を印刷するに内部項目を追加します。
   */
  protected void addPatientBillSetupUnderPrintOn(){

  }

  /**
   * 医療費控除対応版で出力に内部項目を追加します。
   */
  protected void addPatientBillSetupMedicalTreatmentOn(){

  }

  /**
   * 詳細版で印刷するに内部項目を追加します。
   */
  protected void addPatientBillSetupDetailsPrintOn(){

  }

  /**
   * ボタン領域に内部項目を追加します。
   */
  protected void addButtons(){

    buttons.add(getButtonsPanelLeft(), VRLayout.CLIENT);

    buttons.add(getButtonsPanelRight(), VRLayout.CLIENT);

  }

  /**
   * ボタン配置パネル（左）に内部項目を追加します。
   */
  protected void addButtonsPanelLeft(){

    buttonsPanelLeft.add(getPrint(), VRLayout.EAST);
    buttonsPanelLeft.add(getSpacer1(), VRLayout.EAST);
  }

  /**
   * スペーサー１に内部項目を追加します。
   */
  protected void addSpacer1(){

  }

  /**
   * 印刷に内部項目を追加します。
   */
  protected void addPrint(){

  }

  /**
   * ボタン配置パネル（右）に内部項目を追加します。
   */
  protected void addButtonsPanelRight(){

    buttonsPanelRight.add(getSpacer2(), VRLayout.WEST);

    buttonsPanelRight.add(getClose(), VRLayout.WEST);

  }

  /**
   * スペーサー２に内部項目を追加します。
   */
  protected void addSpacer2(){

  }

  /**
   * 閉じるに内部項目を追加します。
   */
  protected void addClose(){

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

  public void setVisible(boolean visible){
    if(visible){
      try{
        initAffair(null);
      }catch(Throwable ex){
        ACCommon.getInstance().showExceptionMessage(ex);
      }
    }
    super.setVisible(visible);
  }
  public static void main(String[] args) {
    //デフォルトデバッグ起動
    try {
      ACFrame.setVRLookAndFeel();
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      new QP007Design().setVisible(true);
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QP007Design getThis() {
    return this;
  }
}
