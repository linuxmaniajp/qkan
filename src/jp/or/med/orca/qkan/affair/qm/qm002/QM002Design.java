
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
 * 開発者: 堤 瑞樹
 * 作成日: 2008/03/05  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム メニュー (M)
 * プロセス メインメニュー (002)
 * プログラム メインメニュー (QM002)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qm.qm002;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACButton;
import jp.nichicom.ac.component.ACEditorPane;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.mainmenu.ACFilterableMainMenuTree;
import jp.nichicom.ac.component.mainmenu.ACMainMenuTreeNodePanelFactory;
import jp.nichicom.ac.component.mainmenu.ACMainMenuTreeRenderer;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACAffairable;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanAffairContainer;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
/**
 * メインメニュー画面項目デザイン(QM002) 
 */
public class QM002Design extends QkanAffairContainer implements ACAffairable {
  //GUIコンポーネント

  private ACPanel contents;

  private ACPanel picts;

  private ACLabel pict;

  private ACPanel menus;

  private ACPanel menuMains;

  private ACFilterableMainMenuTree menuTree;

  private ACMainMenuTreeNodePanelFactory menuList;

  private ACGroupBox infomations;

  private ACLabel informationTitle;

  private ACLabel information;

  private ACPanel versionContents;

  private ACEditorPane editor;

  private ACPanel buttons;

  private ACButton showVersion;

  private ACButton logout;

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
   * 画像領域を取得します。
   * @return 画像領域
   */
  public ACPanel getPicts(){
    if(picts==null){

      picts = new ACPanel();

      picts.setBackground(Color.blue);

      addPicts();
    }
    return picts;

  }

  /**
   * タイトル画像を取得します。
   * @return タイトル画像
   */
  public ACLabel getPict(){
    if(pict==null){

      pict = new ACLabel();

      pict.setOpaque(true);
      pict.setBackground(Color.blue);

      addPict();
    }
    return pict;

  }

  /**
   * メニュー領域を取得します。
   * @return メニュー領域
   */
  public ACPanel getMenus(){
    if(menus==null){

      menus = new ACPanel();

      addMenus();
    }
    return menus;

  }

  /**
   * メニューメイン領域を取得します。
   * @return メニューメイン領域
   */
  public ACPanel getMenuMains(){
    if(menuMains==null){

      menuMains = new ACPanel();

      addMenuMains();
    }
    return menuMains;

  }

  /**
   * メニューツリーを取得します。
   * @return メニューツリー
   */
  public ACFilterableMainMenuTree getMenuTree(){
    if(menuTree==null){

      menuTree = new ACFilterableMainMenuTree();

      menuTree.setPreferredSize(new Dimension(200,560));

      menuTree.setCellRenderer(new ACMainMenuTreeRenderer());

      addMenuTree();
    }
    return menuTree;

  }

  /**
   * メニューリストを取得します。
   * @return メニューリスト
   */
  public ACMainMenuTreeNodePanelFactory getMenuList(){
    if(menuList==null){

      menuList = new ACMainMenuTreeNodePanelFactory();

      addMenuList();
    }
    return menuList;

  }

  /**
   * 説明領域を取得します。
   * @return 説明領域
   */
  public ACGroupBox getInfomations(){
    if(infomations==null){

      infomations = new ACGroupBox();

      infomations.setText("操作の手引き");

      addInfomations();
    }
    return infomations;

  }

  /**
   * 説明タイトルを取得します。
   * @return 説明タイトル
   */
  public ACLabel getInformationTitle(){
    if(informationTitle==null){

      informationTitle = new ACLabel();

      informationTitle.setText("メニュー画面の使い方");

      informationTitle.setIconPath(ACConstants.ICON_PATH_INFORMATION_16);

      addInformationTitle();
    }
    return informationTitle;

  }

  /**
   * 説明を取得します。
   * @return 説明
   */
  public ACLabel getInformation(){
    if(information==null){

      information = new ACLabel();

      information.setText("(1)画面左側のアイコンを選択すると右側に詳細なメニューが表示されます。" + ACConstants.LINE_SEPARATOR + "(2)請求先の「保険者」とサービスを提供する「事業所」は、「その他機能」から登録して下さい。" + ACConstants.LINE_SEPARATOR + "(3)サービスを受ける利用者は「利用者管理」から登録して下さい。");

      information.setAutoWrap(true);

      addInformation();
    }
    return information;

  }

  /**
   * バージョンアップ領域を取得します。
   * @return バージョンアップ領域
   */
  public ACPanel getVersionContents(){
    if(versionContents==null){

      versionContents = new ACPanel();

      versionContents.setVisible(true);

      versionContents.setAutoWrap(false);

      addVersionContents();
    }
    return versionContents;

  }

  /**
   * バージョンアップお知らせ領域を取得します。
   * @return バージョンアップお知らせ領域
   */
  public ACEditorPane getEditor(){
    if(editor==null){

      editor = new ACEditorPane();

      editor.setVisible(true);

      editor.setEnabled(false);

      editor.setEditable(false);

      editor.setPreferredSize(new Dimension(0,180));

      addEditor();
    }
    return editor;

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
   * バージョン情報を取得します。
   * @return バージョン情報
   */
  public ACButton getShowVersion(){
    if(showVersion==null){

      showVersion = new ACButton();

      showVersion.setText("バージョン情報(V)");

      showVersion.setToolTipText("バージョン情報を表示します。");

      showVersion.setMnemonic('V');

      showVersion.setIconPath(ACConstants.ICON_PATH_INFORMATION_16);

      addShowVersion();
    }
    return showVersion;

  }

  /**
   * ログアウトを取得します。
   * @return ログアウト
   */
  public ACButton getLogout(){
    if(logout==null){

      logout = new ACButton();

      logout.setText("ログアウト(E)");

      logout.setToolTipText("ログイン画面に戻ります。");

      logout.setMnemonic('E');

      logout.setIconPath(ACConstants.ICON_PATH_BACK_16);

      addLogout();
    }
    return logout;

  }

  /**
   * コンストラクタです。
   */
  public QM002Design() {

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

    this.add(getContents(), VRLayout.CLIENT);

  }

  /**
   * クライアント領域に内部項目を追加します。
   */
  protected void addContents(){

    contents.add(getPicts(), VRLayout.WEST);

    contents.add(getMenus(), VRLayout.CLIENT);

    contents.add(getVersionContents(), VRLayout.SOUTH);
  }

  /**
   * 画像領域に内部項目を追加します。
   */
  protected void addPicts(){

    picts.add(getPict(), VRLayout.NORTH);

  }

  /**
   * タイトル画像に内部項目を追加します。
   */
  protected void addPict(){

  }

  /**
   * メニュー領域に内部項目を追加します。
   */
  protected void addMenus(){

    menus.add(getMenuMains(), VRLayout.CLIENT);

    menus.add(getInfomations(), VRLayout.SOUTH);
  }

  /**
   * メニューメイン領域に内部項目を追加します。
   */
  protected void addMenuMains(){

    menuMains.add(getMenuTree(), VRLayout.WEST);

    menuMains.add(getMenuList(), VRLayout.CLIENT);

  }

  /**
   * メニューツリーに内部項目を追加します。
   */
  protected void addMenuTree(){

  }

  /**
   * メニューリストに内部項目を追加します。
   */
  protected void addMenuList(){

  }

  /**
   * 説明領域に内部項目を追加します。
   */
  protected void addInfomations(){

    infomations.add(getInformationTitle(), VRLayout.NORTH);

    infomations.add(getInformation(), VRLayout.CLIENT);

  }

  /**
   * 説明タイトルに内部項目を追加します。
   */
  protected void addInformationTitle(){

  }

  /**
   * 説明に内部項目を追加します。
   */
  protected void addInformation(){

  }

  /**
   * バージョンアップ領域に内部項目を追加します。
   */
  protected void addVersionContents(){

    versionContents.add(getEditor(), VRLayout.CLIENT);

    versionContents.add(getButtons(), VRLayout.SOUTH);
  }

  /**
   * バージョンアップお知らせ領域に内部項目を追加します。
   */
  protected void addEditor(){

  }

  /**
   * ボタン領域に内部項目を追加します。
   */
  protected void addButtons(){

    buttons.add(getLogout(), VRLayout.EAST);
    buttons.add(getShowVersion(), VRLayout.EAST);
  }

  /**
   * バージョン情報に内部項目を追加します。
   */
  protected void addShowVersion(){

  }

  /**
   * ログアウトに内部項目を追加します。
   */
  protected void addLogout(){

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

    return getMenuTree();

  }
  public void initAffair(ACAffairInfo affair) throws Exception {
  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    try {
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QM002Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QM002Design getThis() {
    return this;
  }
}
