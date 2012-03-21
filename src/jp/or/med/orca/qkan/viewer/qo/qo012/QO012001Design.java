
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
 * 開発者: 廣瀬 一海
 * 作成日: 2006/04/17  日本コンピューター株式会社 廣瀬 一海 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム CSVビューア (O)
 * プロセス CSVビューア (012)
 * プログラム CSV結合画面 (QO012001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.viewer.qo.qo012;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACButton;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanAffairDialog;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
/**
 * CSV結合画面画面項目デザイン(QO012001) 
 */
public class QO012001Design extends QkanAffairDialog {
  //GUIコンポーネント

  private ACPanel contents;

  private ACPanel fileInfoPanel;

  private ACLabel helpText;

  private ACGroupBox csvFile1Group;

  private ACLabelContainer file1Container;

  private ACTextField file1Text;

  private ACButton file1Button;

  private ACLabelContainer file1InfoContainer;

  private ACTextField file1InfoText;

  private ACGroupBox csvFile2Group;

  private ACLabelContainer file2Container;

  private ACTextField file2Text;

  private ACButton file2Button;

  private ACLabelContainer file2InfoContainer;

  private ACTextField file2InfoText;

  private ACGroupBox csvFile3Group;

  private ACLabelContainer file3Container;

  private ACTextField file3Text;

  private ACButton file3Button;

  private ACLabelContainer file4Container;

  private ACTextField file4Text;

  private ACPanel buttonPanel;

  private ACButton unitButton;

  private ACButton closeButton;

  //getter

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
   * 共通領域を取得します。
   * @return 共通領域
   */
  public ACPanel getFileInfoPanel(){
    if(fileInfoPanel==null){

      fileInfoPanel = new ACPanel();

      fileInfoPanel.setAutoWrap(false);

      addFileInfoPanel();
    }
    return fileInfoPanel;

  }

  /**
   * 説明テキストを取得します。
   * @return 説明テキスト
   */
  public ACLabel getHelpText(){
    if(helpText==null){

      helpText = new ACLabel();

      helpText.setText("結合元ファイル１と結合元ファイル２をそれぞれ選択して、出力先を確認したら「ファイル結合」ボタンを押してください。キャンセルの場合は閉じるボタンを押してください。");

      helpText.setIconPath(ACConstants.ICON_PATH_INFORMATION_16);

      helpText.setAutoWrap(true);

      addHelpText();
    }
    return helpText;

  }

  /**
   * CSVファイル1グループを取得します。
   * @return CSVファイル1グループ
   */
  public ACGroupBox getCsvFile1Group(){
    if(csvFile1Group==null){

      csvFile1Group = new ACGroupBox();

      csvFile1Group.setText("結合元CSVファイル1");

      csvFile1Group.setAutoWrap(true);

      addCsvFile1Group();
    }
    return csvFile1Group;

  }

  /**
   * ファイル1コンテナを取得します。
   * @return ファイル1コンテナ
   */
  public ACLabelContainer getFile1Container(){
    if(file1Container==null){

      file1Container = new ACLabelContainer();

      file1Container.setText("ファイル");

      file1Container.setAutoWrap(false);

      file1Container.setFollowChildEnabled(true);

      file1Container.setLabelMargin(0);

      addFile1Container();
    }
    return file1Container;

  }

  /**
   * ファイル1テキストを取得します。
   * @return ファイル1テキスト
   */
  public ACTextField getFile1Text(){
    if(file1Text==null){

      file1Text = new ACTextField();

      file1Text.setEditable(false);

      file1Text.setColumns(30);

      addFile1Text();
    }
    return file1Text;

  }

  /**
   * ファイル1ボタンを取得します。
   * @return ファイル1ボタン
   */
  public ACButton getFile1Button(){
    if(file1Button==null){

      file1Button = new ACButton();

      file1Button.setText("参照");

      addFile1Button();
    }
    return file1Button;

  }

  /**
   * ファイル1情報コンテナを取得します。
   * @return ファイル1情報コンテナ
   */
  public ACLabelContainer getFile1InfoContainer(){
    if(file1InfoContainer==null){

      file1InfoContainer = new ACLabelContainer();

      file1InfoContainer.setText("ファイル種類");

      addFile1InfoContainer();
    }
    return file1InfoContainer;

  }

  /**
   * ファイル1情報テキストを取得します。
   * @return ファイル1情報テキスト
   */
  public ACTextField getFile1InfoText(){
    if(file1InfoText==null){

      file1InfoText = new ACTextField();

      file1InfoText.setEditable(false);

      file1InfoText.setColumns(30);

      addFile1InfoText();
    }
    return file1InfoText;

  }

  /**
   * CSVファイル2グループを取得します。
   * @return CSVファイル2グループ
   */
  public ACGroupBox getCsvFile2Group(){
    if(csvFile2Group==null){

      csvFile2Group = new ACGroupBox();

      csvFile2Group.setText("結合元CSVファイル2");

      csvFile2Group.setAutoWrap(true);

      addCsvFile2Group();
    }
    return csvFile2Group;

  }

  /**
   * ファイル2コンテナを取得します。
   * @return ファイル2コンテナ
   */
  public ACLabelContainer getFile2Container(){
    if(file2Container==null){

      file2Container = new ACLabelContainer();

      file2Container.setText("ファイル");

      file2Container.setAutoWrap(false);

      file2Container.setFollowChildEnabled(true);

      file2Container.setLabelMargin(0);

      addFile2Container();
    }
    return file2Container;

  }

  /**
   * ファイル2テキストを取得します。
   * @return ファイル2テキスト
   */
  public ACTextField getFile2Text(){
    if(file2Text==null){

      file2Text = new ACTextField();

      file2Text.setEditable(false);

      file2Text.setColumns(30);

      addFile2Text();
    }
    return file2Text;

  }

  /**
   * ファイル2ボタンを取得します。
   * @return ファイル2ボタン
   */
  public ACButton getFile2Button(){
    if(file2Button==null){

      file2Button = new ACButton();

      file2Button.setText("参照");

      addFile2Button();
    }
    return file2Button;

  }

  /**
   * ファイル2情報コンテナを取得します。
   * @return ファイル2情報コンテナ
   */
  public ACLabelContainer getFile2InfoContainer(){
    if(file2InfoContainer==null){

      file2InfoContainer = new ACLabelContainer();

      file2InfoContainer.setText("ファイル種類");

      addFile2InfoContainer();
    }
    return file2InfoContainer;

  }

  /**
   * ファイル2情報テキストを取得します。
   * @return ファイル2情報テキスト
   */
  public ACTextField getFile2InfoText(){
    if(file2InfoText==null){

      file2InfoText = new ACTextField();

      file2InfoText.setEditable(false);

      file2InfoText.setColumns(30);

      addFile2InfoText();
    }
    return file2InfoText;

  }

  /**
   * CSVファイル3グループを取得します。
   * @return CSVファイル3グループ
   */
  public ACGroupBox getCsvFile3Group(){
    if(csvFile3Group==null){

      csvFile3Group = new ACGroupBox();

      csvFile3Group.setText("出力先CSVファイル");

      csvFile3Group.setAutoWrap(true);

      addCsvFile3Group();
    }
    return csvFile3Group;

  }

  /**
   * ファイル3コンテナを取得します。
   * @return ファイル3コンテナ
   */
  public ACLabelContainer getFile3Container(){
    if(file3Container==null){

      file3Container = new ACLabelContainer();

      file3Container.setText("フォルダ");

      file3Container.setAutoWrap(false);

      file3Container.setFollowChildEnabled(true);

      file3Container.setLabelMargin(0);

      addFile3Container();
    }
    return file3Container;

  }

  /**
   * ファイル3テキストを取得します。
   * @return ファイル3テキスト
   */
  public ACTextField getFile3Text(){
    if(file3Text==null){

      file3Text = new ACTextField();

      file3Text.setEditable(false);

      file3Text.setColumns(30);

      addFile3Text();
    }
    return file3Text;

  }

  /**
   * ファイル3ボタンを取得します。
   * @return ファイル3ボタン
   */
  public ACButton getFile3Button(){
    if(file3Button==null){

      file3Button = new ACButton();

      file3Button.setText("参照");

      addFile3Button();
    }
    return file3Button;

  }

  /**
   * ファイル4コンテナを取得します。
   * @return ファイル4コンテナ
   */
  public ACLabelContainer getFile4Container(){
    if(file4Container==null){

      file4Container = new ACLabelContainer();

      file4Container.setText("ファイル");

      addFile4Container();
    }
    return file4Container;

  }

  /**
   * ファイル4テキストを取得します。
   * @return ファイル4テキスト
   */
  public ACTextField getFile4Text(){
    if(file4Text==null){

      file4Text = new ACTextField();

      file4Text.setEditable(false);

      file4Text.setColumns(30);

      addFile4Text();
    }
    return file4Text;

  }

  /**
   * ボタン領域を取得します。
   * @return ボタン領域
   */
  public ACPanel getButtonPanel(){
    if(buttonPanel==null){

      buttonPanel = new ACPanel();

      addButtonPanel();
    }
    return buttonPanel;

  }

  /**
   * 結合実行ボタンを取得します。
   * @return 結合実行ボタン
   */
  public ACButton getUnitButton(){
    if(unitButton==null){

      unitButton = new ACButton();

      unitButton.setText("ファイル結合(E)");

      unitButton.setMnemonic('E');

      addUnitButton();
    }
    return unitButton;

  }

  /**
   * 終了ボタンを取得します。
   * @return 終了ボタン
   */
  public ACButton getCloseButton(){
    if(closeButton==null){

      closeButton = new ACButton();

      closeButton.setText("閉じる(C)");

      closeButton.setMnemonic('C');

      addCloseButton();
    }
    return closeButton;

  }

  /**
   * コンストラクタです。
   */
  public QO012001Design() {

    super(ACFrame.getInstance(), true);
    this.getContentPane().setLayout(new VRLayout());
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    try {
      initialize();

      setSize(600, 350);

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

    contents.add(getFileInfoPanel(), VRLayout.CLIENT);

    contents.add(getButtonPanel(), VRLayout.SOUTH);
  }

  /**
   * 共通領域に内部項目を追加します。
   */
  protected void addFileInfoPanel(){

    fileInfoPanel.add(getHelpText(), VRLayout.NORTH);

    fileInfoPanel.add(getCsvFile1Group(), VRLayout.NORTH);

    fileInfoPanel.add(getCsvFile2Group(), VRLayout.NORTH);

    fileInfoPanel.add(getCsvFile3Group(), VRLayout.NORTH);

  }

  /**
   * 説明テキストに内部項目を追加します。
   */
  protected void addHelpText(){

  }

  /**
   * CSVファイル1グループに内部項目を追加します。
   */
  protected void addCsvFile1Group(){

    csvFile1Group.add(getFile1Container(), VRLayout.FLOW_INSETLINE_RETURN);

    csvFile1Group.add(getFile1InfoContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * ファイル1コンテナに内部項目を追加します。
   */
  protected void addFile1Container(){

    file1Container.add(getFile1Text(), null);

    file1Container.add(getFile1Button(), null);

  }

  /**
   * ファイル1テキストに内部項目を追加します。
   */
  protected void addFile1Text(){

  }

  /**
   * ファイル1ボタンに内部項目を追加します。
   */
  protected void addFile1Button(){

  }

  /**
   * ファイル1情報コンテナに内部項目を追加します。
   */
  protected void addFile1InfoContainer(){

    file1InfoContainer.add(getFile1InfoText(), null);

  }

  /**
   * ファイル1情報テキストに内部項目を追加します。
   */
  protected void addFile1InfoText(){

  }

  /**
   * CSVファイル2グループに内部項目を追加します。
   */
  protected void addCsvFile2Group(){

    csvFile2Group.add(getFile2Container(), VRLayout.FLOW_INSETLINE_RETURN);

    csvFile2Group.add(getFile2InfoContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * ファイル2コンテナに内部項目を追加します。
   */
  protected void addFile2Container(){

    file2Container.add(getFile2Text(), null);

    file2Container.add(getFile2Button(), null);

  }

  /**
   * ファイル2テキストに内部項目を追加します。
   */
  protected void addFile2Text(){

  }

  /**
   * ファイル2ボタンに内部項目を追加します。
   */
  protected void addFile2Button(){

  }

  /**
   * ファイル2情報コンテナに内部項目を追加します。
   */
  protected void addFile2InfoContainer(){

    file2InfoContainer.add(getFile2InfoText(), null);

  }

  /**
   * ファイル2情報テキストに内部項目を追加します。
   */
  protected void addFile2InfoText(){

  }

  /**
   * CSVファイル3グループに内部項目を追加します。
   */
  protected void addCsvFile3Group(){

    csvFile3Group.add(getFile3Container(), VRLayout.FLOW_INSETLINE_RETURN);

    csvFile3Group.add(getFile4Container(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * ファイル3コンテナに内部項目を追加します。
   */
  protected void addFile3Container(){

    file3Container.add(getFile3Text(), null);

    file3Container.add(getFile3Button(), null);

  }

  /**
   * ファイル3テキストに内部項目を追加します。
   */
  protected void addFile3Text(){

  }

  /**
   * ファイル3ボタンに内部項目を追加します。
   */
  protected void addFile3Button(){

  }

  /**
   * ファイル4コンテナに内部項目を追加します。
   */
  protected void addFile4Container(){

    file4Container.add(getFile4Text(), null);

  }

  /**
   * ファイル4テキストに内部項目を追加します。
   */
  protected void addFile4Text(){

  }

  /**
   * ボタン領域に内部項目を追加します。
   */
  protected void addButtonPanel(){

    buttonPanel.add(getCloseButton(), VRLayout.EAST);
    buttonPanel.add(getUnitButton(), VRLayout.EAST);
  }

  /**
   * 結合実行ボタンに内部項目を追加します。
   */
  protected void addUnitButton(){

  }

  /**
   * 終了ボタンに内部項目を追加します。
   */
  protected void addCloseButton(){

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

    return getFile1Text();

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
      new QO012001Design().setVisible(true);
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO012001Design getThis() {
    return this;
  }
}
