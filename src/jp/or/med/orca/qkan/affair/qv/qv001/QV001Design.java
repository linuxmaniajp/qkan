
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
 * 作成日: 2006/03/10  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム バージョン (V)
 * プロセス バージョン情報 (001)
 * プログラム バージョン情報 (QV001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qv.qv001;
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
import jp.or.med.orca.qkan.lib.*;
import jp.or.med.orca.qkan.text.*;
/**
 * バージョン情報画面項目デザイン(QV001) 
 */
public class QV001Design extends QkanAffairDialog {
  //GUIコンポーネント

  private ACPanel contents;

  private ACPanel qkanInfo;

  private ACTextArea qkanInfoText;

  private JTabbedPane tabs;

  private ACPanel versionArea;

  private ACPanel comments;

  private ACLabel warningCommetn;

  private ACPanel buttons;

  private ACButton close;

  private ACLabel spacer;

  //getter

  /**
   * バージョン情報領域を取得します。
   * @return バージョン情報領域
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      addContents();
    }
    return contents;

  }

  /**
   * 給管帳詳細情報領域を取得します。
   * @return 給管帳詳細情報領域
   */
  public ACPanel getQkanInfo(){
    if(qkanInfo==null){

      qkanInfo = new ACPanel();

      addQkanInfo();
    }
    return qkanInfo;

  }

  /**
   * 給管帳詳細テキストエリアを取得します。
   * @return 給管帳詳細テキストエリア
   */
  public ACTextArea getQkanInfoText(){
    if(qkanInfoText==null){

      qkanInfoText = new ACTextArea();

      qkanInfoText.setText("給付管理台帳Ver45" + ACConstants.LINE_SEPARATOR + "バージョン 4.5" + ACConstants.LINE_SEPARATOR + "「給付管理/介護報酬請求支援ソフト」" + ACConstants.LINE_SEPARATOR + "　発行元：社団法人日本医師会" + ACConstants.LINE_SEPARATOR + "　企画・開発：日本医師会総合政策研究機構" + ACConstants.LINE_SEPARATOR + "　開発元：日本コンピューター株式会社" + ACConstants.LINE_SEPARATOR + "" + ACConstants.LINE_SEPARATOR + "　　Copyright（社）日本医師会 2006");

      qkanInfoText.setEditable(false);

      qkanInfoText.setColumns(35);

      qkanInfoText.setRows(9);

      addQkanInfoText();
    }
    return qkanInfoText;

  }

  /**
   * タブを取得します。
   * @return タブ
   */
  public JTabbedPane getTabs(){
    if(tabs==null){

      tabs = new JTabbedPane();

      addTabs();
    }
    return tabs;

  }

  /**
   * バージョン情報領域を取得します。
   * @return バージョン情報領域
   */
  public ACPanel getVersionArea(){
    if(versionArea==null){

      versionArea = new ACPanel();

      versionArea.setAutoWrap(false);

      addVersionArea();
    }
    return versionArea;

  }

  /**
   * コメント領域を取得します。
   * @return コメント領域
   */
  public ACPanel getComments(){
    if(comments==null){

      comments = new ACPanel();

      comments.setAutoWrap(true);

      addComments();
    }
    return comments;

  }

  /**
   * 注意書きラベルを取得します。
   * @return 注意書きラベル
   */
  public ACLabel getWarningCommetn(){
    if(warningCommetn==null){

      warningCommetn = new ACLabel();

      warningCommetn.setText("本プログラムの使用により発生したいかなる損害について当方は責任を負いません。");

      warningCommetn.setRows(2);

      warningCommetn.setAutoWrap(true);

      addWarningCommetn();
    }
    return warningCommetn;

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
   * ボタンを取得します。
   * @return ボタン
   */
  public ACButton getClose(){
    if(close==null){

      close = new ACButton();

      close.setText("閉じる(C)");

      close.setToolTipText("バージョン情報を閉じます。");

      close.setMnemonic('C');

      addClose();
    }
    return close;

  }

  /**
   * スペーサーを取得します。
   * @return スペーサー
   */
  public ACLabel getSpacer(){
    if(spacer==null){

      spacer = new ACLabel();

      spacer.setText("　");

      addSpacer();
    }
    return spacer;

  }

  /**
   * コンストラクタです。
   */
  public QV001Design() {

    super(ACFrame.getInstance(), true);
    this.getContentPane().setLayout(new VRLayout());
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    try {
      initialize();

      setSize(450, 500);

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
   * バージョン情報領域に内部項目を追加します。
   */
  protected void addContents(){

    contents.add(getQkanInfo(), VRLayout.NORTH);

    contents.add(getTabs(), VRLayout.CLIENT);

    contents.add(getVersionArea(), VRLayout.SOUTH);
  }

  /**
   * 給管帳詳細情報領域に内部項目を追加します。
   */
  protected void addQkanInfo(){

    qkanInfo.add(getQkanInfoText(), VRLayout.CLIENT);

  }

  /**
   * 給管帳詳細テキストエリアに内部項目を追加します。
   */
  protected void addQkanInfoText(){

  }

  /**
   * タブに内部項目を追加します。
   */
  protected void addTabs(){

  }

  /**
   * バージョン情報領域に内部項目を追加します。
   */
  protected void addVersionArea(){

    versionArea.add(getComments(), VRLayout.CLIENT);

    versionArea.add(getButtons(), VRLayout.EAST);
    versionArea.add(getSpacer(), VRLayout.SOUTH);
  }

  /**
   * コメント領域に内部項目を追加します。
   */
  protected void addComments(){

    comments.add(getWarningCommetn(), VRLayout.CLIENT);

  }

  /**
   * 注意書きラベルに内部項目を追加します。
   */
  protected void addWarningCommetn(){

  }

  /**
   * ボタン領域に内部項目を追加します。
   */
  protected void addButtons(){

    buttons.add(getClose(), VRLayout.FLOW);

  }

  /**
   * ボタンに内部項目を追加します。
   */
  protected void addClose(){

  }

  /**
   * スペーサーに内部項目を追加します。
   */
  protected void addSpacer(){

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
      new QV001Design().setVisible(true);
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QV001Design getThis() {
    return this;
  }
}
