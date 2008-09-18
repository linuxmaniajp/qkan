
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
 * 作成日: 2007/12/17  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム パターン名称変更 (QS001033)
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
 * パターン名称変更画面項目デザイン(QS001033) 
 */
public class QS001033Design extends QkanAffairDialog {
  //GUIコンポーネント

  private ACPanel contents;

  private ACPanel changePanel;

  private ACTextField afterServiceText;

  private ACLabelContainer afterServiceTextContainer;

  private ACPanel buttonsPanel;

  private ACButton okButton;

  private ACButton cancelButton;

  //getter

  /**
   * サービスパターン名称変更領域を取得します。
   * @return サービスパターン名称変更領域
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      contents.setBackground(Color.blue);

      addContents();
    }
    return contents;

  }

  /**
   * テキスト領域を取得します。
   * @return テキスト領域
   */
  public ACPanel getChangePanel(){
    if(changePanel==null){

      changePanel = new ACPanel();

      changePanel.setVisible(true);

      addChangePanel();
    }
    return changePanel;

  }

  /**
   * 変更後テキストを取得します。
   * @return 変更後テキスト
   */
  public ACTextField getAfterServiceText(){
    if(afterServiceText==null){

      afterServiceText = new ACTextField();

      getAfterServiceTextContainer().setText("変更後サービスパターン名");

      afterServiceText.setBindPath("11");

      afterServiceText.setVisible(true);

      afterServiceText.setEnabled(true);

      afterServiceText.setEditable(true);

      afterServiceText.setColumns(21);

      afterServiceText.setHorizontalAlignment(SwingConstants.LEFT);

      afterServiceText.setIMEMode(InputSubset.KANJI);

      afterServiceText.setMaxLength(20);

      addAfterServiceText();
    }
    return afterServiceText;

  }

  /**
   * 変更後テキストコンテナを取得します。
   * @return 変更後テキストコンテナ
   */
  protected ACLabelContainer getAfterServiceTextContainer(){
    if(afterServiceTextContainer==null){
      afterServiceTextContainer = new ACLabelContainer();
      afterServiceTextContainer.setFollowChildEnabled(true);
      afterServiceTextContainer.setVAlignment(VRLayout.CENTER);
      afterServiceTextContainer.add(getAfterServiceText(), null);
    }
    return afterServiceTextContainer;
  }

  /**
   * ボタン領域を取得します。
   * @return ボタン領域
   */
  public ACPanel getButtonsPanel(){
    if(buttonsPanel==null){

      buttonsPanel = new ACPanel();

      buttonsPanel.setVisible(true);

      addButtonsPanel();
    }
    return buttonsPanel;

  }

  /**
   * OKボタンを取得します。
   * @return OKボタン
   */
  public ACButton getOkButton(){
    if(okButton==null){

      okButton = new ACButton();

      okButton.setText("OK");

      okButton.setVisible(true);

      okButton.setEnabled(true);

      okButton.setMnemonic('O');

      okButton.setIconPath(ACConstants.ICON_PATH_OK_16);

      addOkButton();
    }
    return okButton;

  }

  /**
   * キャンセルボタンを取得します。
   * @return キャンセルボタン
   */
  public ACButton getCancelButton(){
    if(cancelButton==null){

      cancelButton = new ACButton();

      cancelButton.setText("キャンセル(C)");

      cancelButton.setVisible(true);

      cancelButton.setEnabled(true);

      cancelButton.setMnemonic('C');

      cancelButton.setIconPath(ACConstants.ICON_PATH_CANCEL_16);

      addCancelButton();
    }
    return cancelButton;

  }

  /**
   * コンストラクタです。
   */
  public QS001033Design() {

    super(ACFrame.getInstance(), true);
    this.getContentPane().setLayout(new VRLayout());
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    try {
      initialize();

      setSize(450, 85);

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
   * サービスパターン名称変更領域に内部項目を追加します。
   */
  protected void addContents(){

    contents.add(getChangePanel(), VRLayout.CLIENT);

    contents.add(getButtonsPanel(), VRLayout.SOUTH);
  }

  /**
   * テキスト領域に内部項目を追加します。
   */
  protected void addChangePanel(){

    changePanel.add(getAfterServiceTextContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 変更後テキストに内部項目を追加します。
   */
  protected void addAfterServiceText(){

  }

  /**
   * ボタン領域に内部項目を追加します。
   */
  protected void addButtonsPanel(){

    buttonsPanel.add(getCancelButton(), VRLayout.EAST);
    buttonsPanel.add(getOkButton(), VRLayout.EAST);
  }

  /**
   * OKボタンに内部項目を追加します。
   */
  protected void addOkButton(){

  }

  /**
   * キャンセルボタンに内部項目を追加します。
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
      new QS001033Design().setVisible(true);
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001033Design getThis() {
    return this;
  }
}
