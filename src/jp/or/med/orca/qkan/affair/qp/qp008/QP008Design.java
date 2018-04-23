
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
 * 開発者: 藤原　伸
 * 作成日: 2018/04/12  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 実績確定／請求書出力 (P)
 * プロセス CSV出力 (008)
 * プログラム フォルダ選択 (QP008)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp008;
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
 * フォルダ選択画面項目デザイン(QP008) 
 */
public class QP008Design extends QkanAffairDialog {
  //GUIコンポーネント

  private ACPanel contents;

  private ACPanel errorPanel;

  private ACLabel errorSpacer1;

  private ACLabel comment;

  private ACLabel errorSpacer2;

  private ACPanel fileSelects;

  private VRLayout fileSelectLayout;

  private ACLabel fileSelectLabel;

  private ACPanel saveButtons;

  private VRLayout saveButtonLayout;

  private ACButton saveStandardButton;

  private ACButton saveOptionButton;

  private ACTextField filePath;

  private ACIntegerCheckBox fileFormCheckBox;

  private ACPanel operation;

  private ACPanel mediumDivisions;

  private ACClearableRadioButtonGroup mediumDivisionRadio;

  private ACLabelContainer mediumDivisionRadioContainer;

  private ACListModelAdapter mediumDivisionRadioModel;

  private ACRadioButtonItem mediumDivisionRadioItem1;

  private ACRadioButtonItem mediumDivisionRadioItem2;

  private ACRadioButtonItem mediumDivisionRadioItem3;

  private ACRadioButtonItem mediumDivisionRadioItem4;

  private ACPanel buttons;

  private ACPanel buttonsDetail;

  private ACButton ok;

  private ACButton goBack;

  private ACButton cancel;

  //getter

  /**
   * クライアント領域を取得します。
   * @return クライアント領域
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      contents.setAutoWrap(false);

      addContents();
    }
    return contents;

  }

  /**
   * エラー表示領域を取得します。
   * @return エラー表示領域
   */
  public ACPanel getErrorPanel(){
    if(errorPanel==null){

      errorPanel = new ACPanel();

      errorPanel.setVisible(false);

      errorPanel.setFollowChildEnabled(true);

      addErrorPanel();
    }
    return errorPanel;

  }

  /**
   * スペーサーを取得します。
   * @return スペーサー
   */
  public ACLabel getErrorSpacer1(){
    if(errorSpacer1==null){

      errorSpacer1 = new ACLabel();

      errorSpacer1.setText("　" + ACConstants.LINE_SEPARATOR + "　");

      addErrorSpacer1();
    }
    return errorSpacer1;

  }

  /**
   * 説明文を取得します。
   * @return 説明文
   */
  public ACLabel getComment(){
    if(comment==null){

      comment = new ACLabel();

      comment.setText("      ディスクをドライブに挿入して、OKボタンをクリックしてください。");

      addComment();
    }
    return comment;

  }

  /**
   * スペーサーを取得します。
   * @return スペーサー
   */
  public ACLabel getErrorSpacer2(){
    if(errorSpacer2==null){

      errorSpacer2 = new ACLabel();

      errorSpacer2.setText("　" + ACConstants.LINE_SEPARATOR + "　");

      addErrorSpacer2();
    }
    return errorSpacer2;

  }

  /**
   * フォルダ選択領域を取得します。
   * @return フォルダ選択領域
   */
  public ACPanel getFileSelects(){
    if(fileSelects==null){

      fileSelects = new ACPanel();

      fileSelects.setLayout(getFileSelectLayout());

      fileSelects.setVisible(true);

      fileSelects.setFollowChildEnabled(true);

      addFileSelects();
    }
    return fileSelects;

  }

  /**
   * フォルダ選択領域・レイアウトを取得します。
   * @return フォルダ選択領域・レイアウト
   */
  public VRLayout getFileSelectLayout(){
    if(fileSelectLayout==null){

      fileSelectLayout = new VRLayout();

      fileSelectLayout.setAutoWrap(false);

      addFileSelectLayout();
    }
    return fileSelectLayout;

  }

  /**
   * フォルダ選択コメント・ラベルを取得します。
   * @return フォルダ選択コメント・ラベル
   */
  public ACLabel getFileSelectLabel(){
    if(fileSelectLabel==null){

      fileSelectLabel = new ACLabel();

      fileSelectLabel.setText("データを書き込むドライブを選択して、OKボタンをクリックしてください。");

      addFileSelectLabel();
    }
    return fileSelectLabel;

  }

  /**
   * 保存先決定・パネルを取得します。
   * @return 保存先決定・パネル
   */
  public ACPanel getSaveButtons(){
    if(saveButtons==null){

      saveButtons = new ACPanel();

      saveButtons.setLayout(getSaveButtonLayout());

      addSaveButtons();
    }
    return saveButtons;

  }

  /**
   * 保存先決定・レイアウトを取得します。
   * @return 保存先決定・レイアウト
   */
  public VRLayout getSaveButtonLayout(){
    if(saveButtonLayout==null){

      saveButtonLayout = new VRLayout();

      saveButtonLayout.setAutoWrap(false);

      saveButtonLayout.setHgap(0);

      saveButtonLayout.setVgap(5);

      addSaveButtonLayout();
    }
    return saveButtonLayout;

  }

  /**
   * 保存先決定(基準)ボタンを取得します。
   * @return 保存先決定(基準)ボタン
   */
  public ACButton getSaveStandardButton(){
    if(saveStandardButton==null){

      saveStandardButton = new ACButton();

      saveStandardButton.setText("A:");

      addSaveStandardButton();
    }
    return saveStandardButton;

  }

  /**
   * 保存先決定(任意)ボタンを取得します。
   * @return 保存先決定(任意)ボタン
   */
  public ACButton getSaveOptionButton(){
    if(saveOptionButton==null){

      saveOptionButton = new ACButton();

      saveOptionButton.setText("任意のフォルダ:");

      addSaveOptionButton();
    }
    return saveOptionButton;

  }

  /**
   * ファイルパス・テキストを取得します。
   * @return ファイルパス・テキスト
   */
  public ACTextField getFilePath(){
    if(filePath==null){

      filePath = new ACTextField();

      filePath.setBindPath("FILE_PATH");

      filePath.setColumns(30);

      addFilePath();
    }
    return filePath;

  }

  /**
   * 保存形式・チェックボックスを取得します。
   * @return 保存形式・チェックボックス
   */
  public ACIntegerCheckBox getFileFormCheckBox(){
    if(fileFormCheckBox==null){

      fileFormCheckBox = new ACIntegerCheckBox();

      fileFormCheckBox.setText("デフォルトとして保存(V)");

      fileFormCheckBox.setBindPath("FILE_FORM_CHECK");

      fileFormCheckBox.setMnemonic('V');

      addFileFormCheckBox();
    }
    return fileFormCheckBox;

  }

  /**
   * 操作領域を取得します。
   * @return 操作領域
   */
  public ACPanel getOperation(){
    if(operation==null){

      operation = new ACPanel();

      operation.setHgap(0);

      operation.setLabelMargin(0);

      addOperation();
    }
    return operation;

  }

  /**
   * 媒体区分領域を取得します。
   * @return 媒体区分領域
   */
  public ACPanel getMediumDivisions(){
    if(mediumDivisions==null){

      mediumDivisions = new ACPanel();

      mediumDivisions.setHgap(0);

      mediumDivisions.setLabelMargin(0);

      addMediumDivisions();
    }
    return mediumDivisions;

  }

  /**
   * 媒体区分領域・ラジオグループを取得します。
   * @return 媒体区分領域・ラジオグループ
   */
  public ACClearableRadioButtonGroup getMediumDivisionRadio(){
    if(mediumDivisionRadio==null){

      mediumDivisionRadio = new ACClearableRadioButtonGroup();

      getMediumDivisionRadioContainer().setText("媒体区分");

      mediumDivisionRadio.setBindPath("MEDIUM_DIVISION");

      mediumDivisionRadio.setUseClearButton(false);

      mediumDivisionRadio.setModel(getMediumDivisionRadioModel());

      addMediumDivisionRadio();
    }
    return mediumDivisionRadio;

  }

  /**
   * 媒体区分領域・ラジオグループコンテナを取得します。
   * @return 媒体区分領域・ラジオグループコンテナ
   */
  protected ACLabelContainer getMediumDivisionRadioContainer(){
    if(mediumDivisionRadioContainer==null){
      mediumDivisionRadioContainer = new ACLabelContainer();
      mediumDivisionRadioContainer.setFollowChildEnabled(true);
      mediumDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      mediumDivisionRadioContainer.add(getMediumDivisionRadio(), null);
    }
    return mediumDivisionRadioContainer;
  }

  /**
   * 媒体区分領域・ラジオグループモデルを取得します。
   * @return 媒体区分領域・ラジオグループモデル
   */
  protected ACListModelAdapter getMediumDivisionRadioModel(){
    if(mediumDivisionRadioModel==null){
      mediumDivisionRadioModel = new ACListModelAdapter();
      addMediumDivisionRadioModel();
    }
    return mediumDivisionRadioModel;
  }

  /**
   * FD/CD-Rを取得します。
   * @return FD/CD-R
   */
  public ACRadioButtonItem getMediumDivisionRadioItem1(){
    if(mediumDivisionRadioItem1==null){

      mediumDivisionRadioItem1 = new ACRadioButtonItem();

      mediumDivisionRadioItem1.setText("FD/CD-R");

      mediumDivisionRadioItem1.setGroup(getMediumDivisionRadio());

      mediumDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addMediumDivisionRadioItem1();
    }
    return mediumDivisionRadioItem1;

  }

  /**
   * MOを取得します。
   * @return MO
   */
  public ACRadioButtonItem getMediumDivisionRadioItem2(){
    if(mediumDivisionRadioItem2==null){

      mediumDivisionRadioItem2 = new ACRadioButtonItem();

      mediumDivisionRadioItem2.setText("MO");

      mediumDivisionRadioItem2.setGroup(getMediumDivisionRadio());

      mediumDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addMediumDivisionRadioItem2();
    }
    return mediumDivisionRadioItem2;

  }

  /**
   * 伝送ソフト受渡し用（ＩＳＤＮ）を取得します。
   * @return 伝送ソフト受渡し用（ＩＳＤＮ）
   */
  public ACRadioButtonItem getMediumDivisionRadioItem3(){
    if(mediumDivisionRadioItem3==null){

      mediumDivisionRadioItem3 = new ACRadioButtonItem();

      mediumDivisionRadioItem3.setText("伝送ソフト受渡し用（ＩＳＤＮ）");

      mediumDivisionRadioItem3.setGroup(getMediumDivisionRadio());

      mediumDivisionRadioItem3.setConstraints(VRLayout.FLOW);

      addMediumDivisionRadioItem3();
    }
    return mediumDivisionRadioItem3;

  }

  /**
   * 伝送ソフト受渡し用（インターネット）を取得します。
   * @return 伝送ソフト受渡し用（インターネット）
   */
  public ACRadioButtonItem getMediumDivisionRadioItem4(){
    if(mediumDivisionRadioItem4==null){

      mediumDivisionRadioItem4 = new ACRadioButtonItem();

      mediumDivisionRadioItem4.setText("伝送ソフト受渡し用（インターネット）");

      mediumDivisionRadioItem4.setGroup(getMediumDivisionRadio());

      mediumDivisionRadioItem4.setConstraints(VRLayout.FLOW);

      addMediumDivisionRadioItem4();
    }
    return mediumDivisionRadioItem4;

  }

  /**
   * ボタン領域を取得します。
   * @return ボタン領域
   */
  public ACPanel getButtons(){
    if(buttons==null){

      buttons = new ACPanel();

      buttons.setAutoWrap(false);

      buttons.setHgap(1);

      buttons.setLabelMargin(0);

      addButtons();
    }
    return buttons;

  }

  /**
   * 調整領域を取得します。
   * @return 調整領域
   */
  public ACPanel getButtonsDetail(){
    if(buttonsDetail==null){

      buttonsDetail = new ACPanel();

      buttonsDetail.setAutoWrap(false);

      buttonsDetail.setHgap(1);

      buttonsDetail.setLabelMargin(0);

      addButtonsDetail();
    }
    return buttonsDetail;

  }

  /**
   * OKボタンを取得します。
   * @return OKボタン
   */
  public ACButton getOk(){
    if(ok==null){

      ok = new ACButton();

      ok.setText("OK");

      ok.setMnemonic('O');

      addOk();
    }
    return ok;

  }

  /**
   * 戻るを取得します。
   * @return 戻る
   */
  public ACButton getGoBack(){
    if(goBack==null){

      goBack = new ACButton();

      goBack.setText("戻る(R)");

      goBack.setMnemonic('R');

      addGoBack();
    }
    return goBack;

  }

  /**
   * 中止ボタンを取得します。
   * @return 中止ボタン
   */
  public ACButton getCancel(){
    if(cancel==null){

      cancel = new ACButton();

      cancel.setText("中止(C)");

      cancel.setMnemonic('C');

      addCancel();
    }
    return cancel;

  }

  /**
   * コンストラクタです。
   */
  public QP008Design() {

    super(ACFrame.getInstance(), true);
    this.getContentPane().setLayout(new VRLayout());
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    try {
      initialize();

      setSize(600, 200);

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

    contents.add(getErrorPanel(), VRLayout.NORTH);

    contents.add(getFileSelects(), VRLayout.NORTH);

    contents.add(getOperation(), VRLayout.SOUTH);
  }

  /**
   * エラー表示領域に内部項目を追加します。
   */
  protected void addErrorPanel(){

    errorPanel.add(getErrorSpacer1(), VRLayout.NORTH);

    errorPanel.add(getComment(), VRLayout.NORTH);

    errorPanel.add(getErrorSpacer2(), VRLayout.NORTH);

  }

  /**
   * スペーサーに内部項目を追加します。
   */
  protected void addErrorSpacer1(){

  }

  /**
   * 説明文に内部項目を追加します。
   */
  protected void addComment(){

  }

  /**
   * スペーサーに内部項目を追加します。
   */
  protected void addErrorSpacer2(){

  }

  /**
   * フォルダ選択領域に内部項目を追加します。
   */
  protected void addFileSelects(){

    fileSelects.add(getFileSelectLabel(), VRLayout.FLOW_RETURN);

    fileSelects.add(getSaveButtons(), VRLayout.FLOW_RETURN);

  }

  /**
   * フォルダ選択領域・レイアウトに内部項目を追加します。
   */
  protected void addFileSelectLayout(){

  }

  /**
   * フォルダ選択コメント・ラベルに内部項目を追加します。
   */
  protected void addFileSelectLabel(){

  }

  /**
   * 保存先決定・パネルに内部項目を追加します。
   */
  protected void addSaveButtons(){

    saveButtons.add(getSaveStandardButton(), VRLayout.FLOW);

    saveButtons.add(getSaveOptionButton(), VRLayout.FLOW_RETURN);

    saveButtons.add(getFilePath(), VRLayout.FLOW);

    saveButtons.add(getFileFormCheckBox(), VRLayout.FLOW);

  }

  /**
   * 保存先決定・レイアウトに内部項目を追加します。
   */
  protected void addSaveButtonLayout(){

  }

  /**
   * 保存先決定(基準)ボタンに内部項目を追加します。
   */
  protected void addSaveStandardButton(){

  }

  /**
   * 保存先決定(任意)ボタンに内部項目を追加します。
   */
  protected void addSaveOptionButton(){

  }

  /**
   * ファイルパス・テキストに内部項目を追加します。
   */
  protected void addFilePath(){

  }

  /**
   * 保存形式・チェックボックスに内部項目を追加します。
   */
  protected void addFileFormCheckBox(){

  }

  /**
   * 操作領域に内部項目を追加します。
   */
  protected void addOperation(){

    operation.add(getMediumDivisions(), VRLayout.FLOW);

    operation.add(getButtons(), VRLayout.FLOW);

  }

  /**
   * 媒体区分領域に内部項目を追加します。
   */
  protected void addMediumDivisions(){

    mediumDivisions.add(getMediumDivisionRadioContainer(), VRLayout.FLOW);

  }

  /**
   * 媒体区分領域・ラジオグループに内部項目を追加します。
   */
  protected void addMediumDivisionRadio(){

  }

  /**
   * 媒体区分領域・ラジオグループモデルに内部項目を追加します。
   */
  protected void addMediumDivisionRadioModel(){

    getMediumDivisionRadioItem1().setButtonIndex(1);

    getMediumDivisionRadioModel().add(getMediumDivisionRadioItem1());

    getMediumDivisionRadioItem2().setButtonIndex(2);

    getMediumDivisionRadioModel().add(getMediumDivisionRadioItem2());

    getMediumDivisionRadioItem3().setButtonIndex(3);

    getMediumDivisionRadioModel().add(getMediumDivisionRadioItem3());

    getMediumDivisionRadioItem4().setButtonIndex(4);

    getMediumDivisionRadioModel().add(getMediumDivisionRadioItem4());

  }

  /**
   * FD/CD-Rに内部項目を追加します。
   */
  protected void addMediumDivisionRadioItem1(){

  }

  /**
   * MOに内部項目を追加します。
   */
  protected void addMediumDivisionRadioItem2(){

  }

  /**
   * 伝送ソフト受渡し用（ＩＳＤＮ）に内部項目を追加します。
   */
  protected void addMediumDivisionRadioItem3(){

  }

  /**
   * 伝送ソフト受渡し用（インターネット）に内部項目を追加します。
   */
  protected void addMediumDivisionRadioItem4(){

  }

  /**
   * ボタン領域に内部項目を追加します。
   */
  protected void addButtons(){

    buttons.add(getButtonsDetail(), VRLayout.FLOW);

  }

  /**
   * 調整領域に内部項目を追加します。
   */
  protected void addButtonsDetail(){

    buttonsDetail.add(getOk(), VRLayout.FLOW);

    buttonsDetail.add(getGoBack(), VRLayout.FLOW);

    buttonsDetail.add(getCancel(), VRLayout.FLOW);

  }

  /**
   * OKボタンに内部項目を追加します。
   */
  protected void addOk(){

  }

  /**
   * 戻るに内部項目を追加します。
   */
  protected void addGoBack(){

  }

  /**
   * 中止ボタンに内部項目を追加します。
   */
  protected void addCancel(){

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
      new QP008Design().setVisible(true);
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QP008Design getThis() {
    return this;
  }
}
