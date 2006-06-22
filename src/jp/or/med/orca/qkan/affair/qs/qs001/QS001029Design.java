
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
 * 作成日: 2006/03/15  日本コンピューター株式会社 小笠　貴志 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム 限度額超過調整画面 (QS001029)
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
 * 限度額超過調整画面画面項目デザイン(QS001029) 
 */
public class QS001029Design extends QkanAffairDialog {
  //GUIコンポーネント

  private ACPanel contents;

  private ACDateTextField serviceDate;

  private ACLabelContainer serviceDateContainer;

  private ACBackLabelContainer serviceTime;

  private ACTimeTextField serviceStartTime;

  private ACLabelContainer serviceStartTimeContainer;

  private ACLabel serviceMidCode;

  private ACTimeTextField serviceEndTime;

  private ACLabelContainer serviceEndTimeContainer;

  private ACTextField providerNames;

  private ACLabelContainer providerNamesContainer;

  private ACTextField serviceName;

  private ACLabelContainer serviceNameContainer;

  private ACTextField serviceUnit;

  private ACLabelContainer serviceUnitContainer;

  private ACTextField serviceAdjustUnit;

  private ACLabelContainer serviceAdjustUnitContainer;

  private ACIntegerCheckBox serviceIndependence;

  private ACLabelContainer serviceIndependenceContainer;

  private ACTextField serviceResultUnit;

  private ACLabelContainer serviceResultUnitContainer;

  private ACPanel buttons;

  private ACButton submit;

  private ACButton close;

  //getter

  /**
   * 限度額超過調整画面領域を取得します。
   * @return 限度額超過調整画面領域
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      contents.setAutoWrap(false);

      contents.setHgrid(200);

      addContents();
    }
    return contents;

  }

  /**
   * 日付を取得します。
   * @return 日付
   */
  public ACDateTextField getServiceDate(){
    if(serviceDate==null){

      serviceDate = new ACDateTextField();

      getServiceDateContainer().setText("年月日");

      serviceDate.setEditable(false);

      addServiceDate();
    }
    return serviceDate;

  }

  /**
   * 日付コンテナを取得します。
   * @return 日付コンテナ
   */
  protected ACLabelContainer getServiceDateContainer(){
    if(serviceDateContainer==null){
      serviceDateContainer = new ACLabelContainer();
      serviceDateContainer.setFollowChildEnabled(true);
      serviceDateContainer.setVAlignment(VRLayout.CENTER);
      serviceDateContainer.add(getServiceDate(), null);
    }
    return serviceDateContainer;
  }

  /**
   * 時刻を取得します。
   * @return 時刻
   */
  public ACBackLabelContainer getServiceTime(){
    if(serviceTime==null){

      serviceTime = new ACBackLabelContainer();

      serviceTime.setText("時刻");

      addServiceTime();
    }
    return serviceTime;

  }

  /**
   * 開始時刻を取得します。
   * @return 開始時刻
   */
  public ACTimeTextField getServiceStartTime(){
    if(serviceStartTime==null){

      serviceStartTime = new ACTimeTextField();

      serviceStartTime.setBindPath("3");

      serviceStartTime.setEditable(false);

      serviceStartTime.setColumns(5);

      addServiceStartTime();
    }
    return serviceStartTime;

  }

  /**
   * 開始時刻コンテナを取得します。
   * @return 開始時刻コンテナ
   */
  protected ACLabelContainer getServiceStartTimeContainer(){
    if(serviceStartTimeContainer==null){
      serviceStartTimeContainer = new ACLabelContainer();
      serviceStartTimeContainer.setFollowChildEnabled(true);
      serviceStartTimeContainer.setVAlignment(VRLayout.CENTER);
      serviceStartTimeContainer.add(getServiceStartTime(), null);
    }
    return serviceStartTimeContainer;
  }

  /**
   * ～ラベルを取得します。
   * @return ～ラベル
   */
  public ACLabel getServiceMidCode(){
    if(serviceMidCode==null){

      serviceMidCode = new ACLabel();

      serviceMidCode.setText("から");

      addServiceMidCode();
    }
    return serviceMidCode;

  }

  /**
   * 終了時刻を取得します。
   * @return 終了時刻
   */
  public ACTimeTextField getServiceEndTime(){
    if(serviceEndTime==null){

      serviceEndTime = new ACTimeTextField();

      serviceEndTime.setBindPath("4");

      serviceEndTime.setEditable(false);

      serviceEndTime.setColumns(5);

      addServiceEndTime();
    }
    return serviceEndTime;

  }

  /**
   * 終了時刻コンテナを取得します。
   * @return 終了時刻コンテナ
   */
  protected ACLabelContainer getServiceEndTimeContainer(){
    if(serviceEndTimeContainer==null){
      serviceEndTimeContainer = new ACLabelContainer();
      serviceEndTimeContainer.setFollowChildEnabled(true);
      serviceEndTimeContainer.setVAlignment(VRLayout.CENTER);
      serviceEndTimeContainer.add(getServiceEndTime(), null);
    }
    return serviceEndTimeContainer;
  }

  /**
   * 事業所名称を取得します。
   * @return 事業所名称
   */
  public ACTextField getProviderNames(){
    if(providerNames==null){

      providerNames = new ACTextField();

      getProviderNamesContainer().setText("事業所名称");

      providerNames.setEditable(false);

      providerNames.setColumns(15);

      addProviderNames();
    }
    return providerNames;

  }

  /**
   * 事業所名称コンテナを取得します。
   * @return 事業所名称コンテナ
   */
  protected ACLabelContainer getProviderNamesContainer(){
    if(providerNamesContainer==null){
      providerNamesContainer = new ACLabelContainer();
      providerNamesContainer.setFollowChildEnabled(true);
      providerNamesContainer.setVAlignment(VRLayout.CENTER);
      providerNamesContainer.add(getProviderNames(), null);
    }
    return providerNamesContainer;
  }

  /**
   * サービス名称を取得します。
   * @return サービス名称
   */
  public ACTextField getServiceName(){
    if(serviceName==null){

      serviceName = new ACTextField();

      getServiceNameContainer().setText("サービス名称");

      serviceName.setEditable(false);

      serviceName.setColumns(18);

      addServiceName();
    }
    return serviceName;

  }

  /**
   * サービス名称コンテナを取得します。
   * @return サービス名称コンテナ
   */
  protected ACLabelContainer getServiceNameContainer(){
    if(serviceNameContainer==null){
      serviceNameContainer = new ACLabelContainer();
      serviceNameContainer.setFollowChildEnabled(true);
      serviceNameContainer.setVAlignment(VRLayout.CENTER);
      serviceNameContainer.add(getServiceName(), null);
    }
    return serviceNameContainer;
  }

  /**
   * 単位数を取得します。
   * @return 単位数
   */
  public ACTextField getServiceUnit(){
    if(serviceUnit==null){

      serviceUnit = new ACTextField();

      getServiceUnitContainer().setText("単位数");

      serviceUnit.setEditable(false);

      serviceUnit.setColumns(5);

      serviceUnit.setHorizontalAlignment(SwingConstants.RIGHT);

      addServiceUnit();
    }
    return serviceUnit;

  }

  /**
   * 単位数コンテナを取得します。
   * @return 単位数コンテナ
   */
  protected ACLabelContainer getServiceUnitContainer(){
    if(serviceUnitContainer==null){
      serviceUnitContainer = new ACLabelContainer();
      serviceUnitContainer.setFollowChildEnabled(true);
      serviceUnitContainer.setVAlignment(VRLayout.CENTER);
      serviceUnitContainer.add(getServiceUnit(), null);
    }
    return serviceUnitContainer;
  }

  /**
   * 調整額を取得します。
   * @return 調整額
   */
  public ACTextField getServiceAdjustUnit(){
    if(serviceAdjustUnit==null){

      serviceAdjustUnit = new ACTextField();

      getServiceAdjustUnitContainer().setText("利用者負担単位数");

      serviceAdjustUnit.setBindPath("REGULATION_RATE");

      serviceAdjustUnit.setColumns(5);

      serviceAdjustUnit.setCharType(VRCharType.ONLY_DIGIT);

      serviceAdjustUnit.setHorizontalAlignment(SwingConstants.RIGHT);

      serviceAdjustUnit.setIMEMode(InputSubset.LATIN);

      serviceAdjustUnit.setMaxLength(6);

      addServiceAdjustUnit();
    }
    return serviceAdjustUnit;

  }

  /**
   * 調整額コンテナを取得します。
   * @return 調整額コンテナ
   */
  protected ACLabelContainer getServiceAdjustUnitContainer(){
    if(serviceAdjustUnitContainer==null){
      serviceAdjustUnitContainer = new ACLabelContainer();
      serviceAdjustUnitContainer.setFollowChildEnabled(true);
      serviceAdjustUnitContainer.setVAlignment(VRLayout.CENTER);
      serviceAdjustUnitContainer.add(getServiceAdjustUnit(), null);
    }
    return serviceAdjustUnitContainer;
  }

  /**
   * 全額自己負担を取得します。
   * @return 全額自己負担
   */
  public ACIntegerCheckBox getServiceIndependence(){
    if(serviceIndependence==null){

      serviceIndependence = new ACIntegerCheckBox();

      getServiceIndependenceContainer().setText("全額自己負担");

      addServiceIndependence();
    }
    return serviceIndependence;

  }

  /**
   * 全額自己負担コンテナを取得します。
   * @return 全額自己負担コンテナ
   */
  protected ACLabelContainer getServiceIndependenceContainer(){
    if(serviceIndependenceContainer==null){
      serviceIndependenceContainer = new ACLabelContainer();
      serviceIndependenceContainer.setFollowChildEnabled(true);
      serviceIndependenceContainer.setVAlignment(VRLayout.CENTER);
      serviceIndependenceContainer.add(getServiceIndependence(), null);
    }
    return serviceIndependenceContainer;
  }

  /**
   * 調整後単位数を取得します。
   * @return 調整後単位数
   */
  public ACTextField getServiceResultUnit(){
    if(serviceResultUnit==null){

      serviceResultUnit = new ACTextField();

      getServiceResultUnitContainer().setText("保険者負担単位数");

      serviceResultUnit.setEditable(false);

      serviceResultUnit.setColumns(5);

      serviceResultUnit.setHorizontalAlignment(SwingConstants.RIGHT);

      addServiceResultUnit();
    }
    return serviceResultUnit;

  }

  /**
   * 調整後単位数コンテナを取得します。
   * @return 調整後単位数コンテナ
   */
  protected ACLabelContainer getServiceResultUnitContainer(){
    if(serviceResultUnitContainer==null){
      serviceResultUnitContainer = new ACLabelContainer();
      serviceResultUnitContainer.setFollowChildEnabled(true);
      serviceResultUnitContainer.setVAlignment(VRLayout.CENTER);
      serviceResultUnitContainer.add(getServiceResultUnit(), null);
    }
    return serviceResultUnitContainer;
  }

  /**
   * ボタン領域を取得します。
   * @return ボタン領域
   */
  public ACPanel getButtons(){
    if(buttons==null){

      buttons = new ACPanel();

      addButtons();
    }
    return buttons;

  }

  /**
   * 決定を取得します。
   * @return 決定
   */
  public ACButton getSubmit(){
    if(submit==null){

      submit = new ACButton();

      submit.setText("OK");

      submit.setToolTipText("入力された情報で調整額を更新します。");

      submit.setMnemonic('O');

      submit.setIconPath(ACConstants.ICON_PATH_OK_16);

      addSubmit();
    }
    return submit;

  }

  /**
   * 閉じるを取得します。
   * @return 閉じる
   */
  public ACButton getClose(){
    if(close==null){

      close = new ACButton();

      close.setText("キャンセル(C)");

      close.setToolTipText("調整額の更新は行わず、前の画面に戻ります。");

      close.setMnemonic('C');

      close.setIconPath(ACConstants.ICON_PATH_CANCEL_16);

      addClose();
    }
    return close;

  }

  /**
   * コンストラクタです。
   */
  public QS001029Design() {

    super(ACFrame.getInstance(), true);
    this.getContentPane().setLayout(new VRLayout());
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    try {
      initialize();

      setSize(380, 230);

      // ウィンドウを中央に配置
      Point pos = ACFrame.getInstance().getLocationOnScreen();
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
   * 限度額超過調整画面領域に内部項目を追加します。
   */
  protected void addContents(){

    contents.add(getServiceDateContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    contents.add(getServiceTime(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    contents.add(getProviderNamesContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    contents.add(getServiceNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    contents.add(getServiceUnitContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    contents.add(getServiceAdjustUnitContainer(), VRLayout.FLOW_INSETLINE);

    contents.add(getServiceIndependenceContainer(), VRLayout.FLOW_RETURN);

    contents.add(getServiceResultUnitContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    contents.add(getButtons(), VRLayout.SOUTH);
  }

  /**
   * 日付に内部項目を追加します。
   */
  protected void addServiceDate(){

  }

  /**
   * 時刻に内部項目を追加します。
   */
  protected void addServiceTime(){

    serviceTime.add(getServiceStartTimeContainer(), VRLayout.FLOW);

    serviceTime.add(getServiceMidCode(), VRLayout.FLOW);

    serviceTime.add(getServiceEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * 開始時刻に内部項目を追加します。
   */
  protected void addServiceStartTime(){

  }

  /**
   * ～ラベルに内部項目を追加します。
   */
  protected void addServiceMidCode(){

  }

  /**
   * 終了時刻に内部項目を追加します。
   */
  protected void addServiceEndTime(){

  }

  /**
   * 事業所名称に内部項目を追加します。
   */
  protected void addProviderNames(){

  }

  /**
   * サービス名称に内部項目を追加します。
   */
  protected void addServiceName(){

  }

  /**
   * 単位数に内部項目を追加します。
   */
  protected void addServiceUnit(){

  }

  /**
   * 調整額に内部項目を追加します。
   */
  protected void addServiceAdjustUnit(){

  }

  /**
   * 全額自己負担に内部項目を追加します。
   */
  protected void addServiceIndependence(){

  }

  /**
   * 調整後単位数に内部項目を追加します。
   */
  protected void addServiceResultUnit(){

  }

  /**
   * ボタン領域に内部項目を追加します。
   */
  protected void addButtons(){

    buttons.add(getClose(), VRLayout.EAST);
    buttons.add(getSubmit(), VRLayout.EAST);
  }

  /**
   * 決定に内部項目を追加します。
   */
  protected void addSubmit(){

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
      new QS001029Design().setVisible(true);
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001029Design getThis() {
    return this;
  }
}
