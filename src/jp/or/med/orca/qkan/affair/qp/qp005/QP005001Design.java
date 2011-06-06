
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
 * 作成日: 2009/07/09  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 実績データ作成 (P)
 * プロセス 明細書詳細編集 (005)
 * プログラム 特定診療費レコード追加 (QP005001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp005;
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
 * 特定診療費レコード追加画面項目デザイン(QP005001) 
 */
public class QP005001Design extends QkanAffairDialog {
  //GUIコンポーネント

  private ACPanel contents;

  private ACPanel inputPanel;

  private ACLabelContainer serviceCodeContainer;

  private ACLabel serviceCodeKindLabel;

  private ACTextField serviceCodeDetailText;

  private ACLabelContainer serviceNameContainer;

  private ACTextField serviceNameText;

  private ACLabelContainer costContainer;

  private ACTextField costText;

  private ACLabel costUnitLabel;

  private ACLabelContainer costLimitContainer;

  private ACTextField costLimitText;

  private ACLabel costLimitUnitLabel;

  private ACLabelContainer dayContainer;

  private ACTextField dayText;

  private ACLabel dayUnitLabel;

  private ACPanel buttons;

  private ACButton addButton;

  private ACButton cancelButton;

  //getter

  /**
   * 特定診療費レコード設定領域を取得します。
   * @return 特定診療費レコード設定領域
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      addContents();
    }
    return contents;

  }

  /**
   * 入力領域を取得します。
   * @return 入力領域
   */
  public ACPanel getInputPanel(){
    if(inputPanel==null){

      inputPanel = new ACPanel();

      inputPanel.setAutoWrap(false);

      inputPanel.setHgap(5);

      inputPanel.setLabelMargin(0);

      inputPanel.setVgap(3);

      addInputPanel();
    }
    return inputPanel;

  }

  /**
   * サービスコードコンテナを取得します。
   * @return サービスコードコンテナ
   */
  public ACLabelContainer getServiceCodeContainer(){
    if(serviceCodeContainer==null){

      serviceCodeContainer = new ACLabelContainer();

      serviceCodeContainer.setText("サービスコード");

      serviceCodeContainer.setVisible(true);

      serviceCodeContainer.setAutoWrap(false);

      serviceCodeContainer.setHgap(5);

      serviceCodeContainer.setLabelMargin(2);

      serviceCodeContainer.setVgap(0);

      addServiceCodeContainer();
    }
    return serviceCodeContainer;

  }

  /**
   * サービスコード種類ラベルを取得します。
   * @return サービスコード種類ラベル
   */
  public ACLabel getServiceCodeKindLabel(){
    if(serviceCodeKindLabel==null){

      serviceCodeKindLabel = new ACLabel();

      serviceCodeKindLabel.setText("59");

      serviceCodeKindLabel.setBindPath("801008");

      serviceCodeKindLabel.setAutoWrap(false);

      addServiceCodeKindLabel();
    }
    return serviceCodeKindLabel;

  }

  /**
   * サービスコード項目テキストを取得します。
   * @return サービスコード項目テキスト
   */
  public ACTextField getServiceCodeDetailText(){
    if(serviceCodeDetailText==null){

      serviceCodeDetailText = new ACTextField();

      serviceCodeDetailText.setBindPath("801009");

      serviceCodeDetailText.setColumns(3);

      serviceCodeDetailText.setCharType(VRCharType.ONLY_DIGIT);

      serviceCodeDetailText.setHorizontalAlignment(SwingConstants.RIGHT);

      serviceCodeDetailText.setIMEMode(InputSubset.LATIN);

      serviceCodeDetailText.setMaxLength(4);

      addServiceCodeDetailText();
    }
    return serviceCodeDetailText;

  }

  /**
   * サービス名称コンテナを取得します。
   * @return サービス名称コンテナ
   */
  public ACLabelContainer getServiceNameContainer(){
    if(serviceNameContainer==null){

      serviceNameContainer = new ACLabelContainer();

      serviceNameContainer.setText("サービス名称");

      serviceNameContainer.setAutoWrap(false);

      serviceNameContainer.setHgap(5);

      serviceNameContainer.setLabelMargin(0);

      serviceNameContainer.setVgap(0);

      addServiceNameContainer();
    }
    return serviceNameContainer;

  }

  /**
   * サービス名称テキストを取得します。
   * @return サービス名称テキスト
   */
  public ACTextField getServiceNameText(){
    if(serviceNameText==null){

      serviceNameText = new ACTextField();

      serviceNameText.setBindPath("801034");

      serviceNameText.setEditable(false);

      serviceNameText.setColumns(25);

      serviceNameText.setMaxLength(50);

      addServiceNameText();
    }
    return serviceNameText;

  }

  /**
   * 費用単価コンテナを取得します。
   * @return 費用単価コンテナ
   */
  public ACLabelContainer getCostContainer(){
    if(costContainer==null){

      costContainer = new ACLabelContainer();

      costContainer.setText("費用単価");

      costContainer.setAutoWrap(false);

      costContainer.setHgap(5);

      costContainer.setLabelMargin(0);

      costContainer.setVgap(0);

      addCostContainer();
    }
    return costContainer;

  }

  /**
   * 費用単価テキストを取得します。
   * @return 費用単価テキスト
   */
  public ACTextField getCostText(){
    if(costText==null){

      costText = new ACTextField();

      costText.setBindPath("801010");

      costText.setColumns(3);

      costText.setCharType(VRCharType.ONLY_DIGIT);

      costText.setHorizontalAlignment(SwingConstants.RIGHT);

      costText.setIMEMode(InputSubset.LATIN);

      costText.setMaxLength(4);

      addCostText();
    }
    return costText;

  }

  /**
   * 費用単価ラベルを取得します。
   * @return 費用単価ラベル
   */
  public ACLabel getCostUnitLabel(){
    if(costUnitLabel==null){

      costUnitLabel = new ACLabel();

      costUnitLabel.setText("円");

      costUnitLabel.setAutoWrap(false);

      addCostUnitLabel();
    }
    return costUnitLabel;

  }

  /**
   * 費用限度額コンテナを取得します。
   * @return 費用限度額コンテナ
   */
  public ACLabelContainer getCostLimitContainer(){
    if(costLimitContainer==null){

      costLimitContainer = new ACLabelContainer();

      costLimitContainer.setText("費用限度額");

      costLimitContainer.setAutoWrap(false);

      costLimitContainer.setHgap(5);

      costLimitContainer.setLabelMargin(0);

      costLimitContainer.setVgap(0);

      addCostLimitContainer();
    }
    return costLimitContainer;

  }

  /**
   * 費用限度額テキストを取得します。
   * @return 費用限度額テキスト
   */
  public ACTextField getCostLimitText(){
    if(costLimitText==null){

      costLimitText = new ACTextField();

      costLimitText.setBindPath("801011");

      costLimitText.setColumns(3);

      costLimitText.setCharType(VRCharType.ONLY_NUMBER);

      costLimitText.setHorizontalAlignment(SwingConstants.RIGHT);

      costLimitText.setIMEMode(InputSubset.LATIN);

      costLimitText.setMaxLength(4);

      addCostLimitText();
    }
    return costLimitText;

  }

  /**
   * 費用限度額ラベルを取得します。
   * @return 費用限度額ラベル
   */
  public ACLabel getCostLimitUnitLabel(){
    if(costLimitUnitLabel==null){

      costLimitUnitLabel = new ACLabel();

      costLimitUnitLabel.setText("円");

      addCostLimitUnitLabel();
    }
    return costLimitUnitLabel;

  }

  /**
   * 日数コンテナを取得します。
   * @return 日数コンテナ
   */
  public ACLabelContainer getDayContainer(){
    if(dayContainer==null){

      dayContainer = new ACLabelContainer();

      dayContainer.setText("日数");

      dayContainer.setAutoWrap(false);

      dayContainer.setHgap(5);

      dayContainer.setLabelMargin(0);

      dayContainer.setVgap(0);

      addDayContainer();
    }
    return dayContainer;

  }

  /**
   * 日数テキストを取得します。
   * @return 日数テキスト
   */
  public ACTextField getDayText(){
    if(dayText==null){

      dayText = new ACTextField();

      dayText.setBindPath("801012");

      dayText.setColumns(2);

      dayText.setCharType(VRCharType.ONLY_DIGIT);

      dayText.setHorizontalAlignment(SwingConstants.RIGHT);

      dayText.setIMEMode(InputSubset.LATIN);

      dayText.setMaxLength(2);

      addDayText();
    }
    return dayText;

  }

  /**
   * 日数ラベルを取得します。
   * @return 日数ラベル
   */
  public ACLabel getDayUnitLabel(){
    if(dayUnitLabel==null){

      dayUnitLabel = new ACLabel();

      dayUnitLabel.setText("日");

      addDayUnitLabel();
    }
    return dayUnitLabel;

  }

  /**
   * ボタン領域を取得します。
   * @return ボタン領域
   */
  public ACPanel getButtons(){
    if(buttons==null){

      buttons = new ACPanel();

      buttons.setAutoWrap(false);

      buttons.setHgap(0);

      buttons.setLabelMargin(0);

      buttons.setVgap(0);

      addButtons();
    }
    return buttons;

  }

  /**
   * 追加を取得します。
   * @return 追加
   */
  public ACButton getAddButton(){
    if(addButton==null){

      addButton = new ACButton();

      addButton.setText("追加(A)");

      addButton.setMnemonic('A');

      addButton.setIconPath(ACConstants.ICON_PATH_RECORD_DOWNLOAD_16);

      addAddButton();
    }
    return addButton;

  }

  /**
   * キャンセルを取得します。
   * @return キャンセル
   */
  public ACButton getCancelButton(){
    if(cancelButton==null){

      cancelButton = new ACButton();

      cancelButton.setText("キャンセル(C)");

      cancelButton.setMnemonic('C');

      cancelButton.setIconPath(ACConstants.ICON_PATH_CANCEL_16);

      addCancelButton();
    }
    return cancelButton;

  }

  /**
   * コンストラクタです。
   */
  public QP005001Design() {

    super(ACFrame.getInstance(), true);
    this.getContentPane().setLayout(new VRLayout());
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    try {
      initialize();

      setSize(430, 190);

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
   * 特定診療費レコード設定領域に内部項目を追加します。
   */
  protected void addContents(){

    contents.add(getInputPanel(), VRLayout.NORTH);

    contents.add(getButtons(), VRLayout.NORTH);

  }

  /**
   * 入力領域に内部項目を追加します。
   */
  protected void addInputPanel(){

    inputPanel.add(getServiceCodeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    inputPanel.add(getServiceNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    inputPanel.add(getCostContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    inputPanel.add(getCostLimitContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    inputPanel.add(getDayContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * サービスコードコンテナに内部項目を追加します。
   */
  protected void addServiceCodeContainer(){

    serviceCodeContainer.add(getServiceCodeKindLabel(), VRLayout.FLOW);

    serviceCodeContainer.add(getServiceCodeDetailText(), VRLayout.FLOW);

  }

  /**
   * サービスコード種類ラベルに内部項目を追加します。
   */
  protected void addServiceCodeKindLabel(){

  }

  /**
   * サービスコード項目テキストに内部項目を追加します。
   */
  protected void addServiceCodeDetailText(){

  }

  /**
   * サービス名称コンテナに内部項目を追加します。
   */
  protected void addServiceNameContainer(){

    serviceNameContainer.add(getServiceNameText(), VRLayout.FLOW);

  }

  /**
   * サービス名称テキストに内部項目を追加します。
   */
  protected void addServiceNameText(){

  }

  /**
   * 費用単価コンテナに内部項目を追加します。
   */
  protected void addCostContainer(){

    costContainer.add(getCostText(), VRLayout.FLOW);

    costContainer.add(getCostUnitLabel(), VRLayout.FLOW);

  }

  /**
   * 費用単価テキストに内部項目を追加します。
   */
  protected void addCostText(){

  }

  /**
   * 費用単価ラベルに内部項目を追加します。
   */
  protected void addCostUnitLabel(){

  }

  /**
   * 費用限度額コンテナに内部項目を追加します。
   */
  protected void addCostLimitContainer(){

    costLimitContainer.add(getCostLimitText(), VRLayout.FLOW);

    costLimitContainer.add(getCostLimitUnitLabel(), VRLayout.FLOW);

  }

  /**
   * 費用限度額テキストに内部項目を追加します。
   */
  protected void addCostLimitText(){

  }

  /**
   * 費用限度額ラベルに内部項目を追加します。
   */
  protected void addCostLimitUnitLabel(){

  }

  /**
   * 日数コンテナに内部項目を追加します。
   */
  protected void addDayContainer(){

    dayContainer.add(getDayText(), VRLayout.FLOW);

    dayContainer.add(getDayUnitLabel(), VRLayout.FLOW);

  }

  /**
   * 日数テキストに内部項目を追加します。
   */
  protected void addDayText(){

  }

  /**
   * 日数ラベルに内部項目を追加します。
   */
  protected void addDayUnitLabel(){

  }

  /**
   * ボタン領域に内部項目を追加します。
   */
  protected void addButtons(){

    buttons.add(getCancelButton(), VRLayout.EAST);
    buttons.add(getAddButton(), VRLayout.EAST);
  }

  /**
   * 追加に内部項目を追加します。
   */
  protected void addAddButton(){

  }

  /**
   * キャンセルに内部項目を追加します。
   */
  protected void addCancelButton(){

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
      new QP005001Design().setVisible(true);
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QP005001Design getThis() {
    return this;
  }
}
