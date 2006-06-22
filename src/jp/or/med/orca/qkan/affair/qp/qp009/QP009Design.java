
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
 * 開発者: 樋口雅彦
 * 作成日: 2006/03/19  日本コンピューター株式会社 樋口雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 実績確定／請求書出力 (P)
 * プロセス CSV出力 (009)
 * プログラム 伝送確認 (QP009)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp009;
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
 * 伝送確認画面項目デザイン(QP009) 
 */
public class QP009Design extends QkanAffairDialog {
  //GUIコンポーネント

  private ACPanel contents;

  private ACPanel buttons;

  private ACLabel spacer1;

  private ACLabel infoLabel1;

  private ACLabel infoLabel2;

  private ACLabel spacer2;

  private ACPanel panelNextCheck;

  private ACIntegerCheckBox nextCheck;

  private ACButton ok;

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
   * ラベル表示を取得します。
   * @return ラベル表示
   */
  public ACPanel getButtons(){
    if(buttons==null){

      buttons = new ACPanel();

      addButtons();
    }
    return buttons;

  }

  /**
   * スペーサー１を取得します。
   * @return スペーサー１
   */
  public ACLabel getSpacer1(){
    if(spacer1==null){

      spacer1 = new ACLabel();

      spacer1.setText("　");

      addSpacer1();
    }
    return spacer1;

  }

  /**
   * 出力確認１を取得します。
   * @return 出力確認１
   */
  public ACLabel getInfoLabel1(){
    if(infoLabel1==null){

      infoLabel1 = new ACLabel();

      infoLabel1.setText("　　伝送用のＣＳＶファイルを出力します。");

      addInfoLabel1();
    }
    return infoLabel1;

  }

  /**
   * 出力確認２を取得します。
   * @return 出力確認２
   */
  public ACLabel getInfoLabel2(){
    if(infoLabel2==null){

      infoLabel2 = new ACLabel();

      infoLabel2.setText("　　この作業で伝送が行われるわけではありません。");

      addInfoLabel2();
    }
    return infoLabel2;

  }

  /**
   * スペーサー２を取得します。
   * @return スペーサー２
   */
  public ACLabel getSpacer2(){
    if(spacer2==null){

      spacer2 = new ACLabel();

      spacer2.setText("　");

      addSpacer2();
    }
    return spacer2;

  }

  /**
   * 次回表示を取得します。
   * @return 次回表示
   */
  public ACPanel getPanelNextCheck(){
    if(panelNextCheck==null){

      panelNextCheck = new ACPanel();

      addPanelNextCheck();
    }
    return panelNextCheck;

  }

  /**
   * 次回表示確認チェックボックスを取得します。
   * @return 次回表示確認チェックボックス
   */
  public ACIntegerCheckBox getNextCheck(){
    if(nextCheck==null){

      nextCheck = new ACIntegerCheckBox();

      nextCheck.setText("次回以降はこのメッセージを表示しない。");

      addNextCheck();
    }
    return nextCheck;

  }

  /**
   * ＯＫボタンを取得します。
   * @return ＯＫボタン
   */
  public ACButton getOk(){
    if(ok==null){

      ok = new ACButton();

      ok.setText("ＯＫ");

      addOk();
    }
    return ok;

  }

  /**
   * コンストラクタです。
   */
  public QP009Design() {

    super(ACFrame.getInstance(), true);
    this.getContentPane().setLayout(new VRLayout());
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    try {
      initialize();

      setSize(420, 160);

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
   * クライアント領域に内部項目を追加します。
   */
  protected void addContents(){

    contents.add(getButtons(), VRLayout.NORTH);

    contents.add(getPanelNextCheck(), VRLayout.NORTH);

  }

  /**
   * ラベル表示に内部項目を追加します。
   */
  protected void addButtons(){

    buttons.add(getSpacer1(), VRLayout.NORTH);

    buttons.add(getInfoLabel1(), VRLayout.NORTH);

    buttons.add(getInfoLabel2(), VRLayout.NORTH);

    buttons.add(getSpacer2(), VRLayout.NORTH);

  }

  /**
   * スペーサー１に内部項目を追加します。
   */
  protected void addSpacer1(){

  }

  /**
   * 出力確認１に内部項目を追加します。
   */
  protected void addInfoLabel1(){

  }

  /**
   * 出力確認２に内部項目を追加します。
   */
  protected void addInfoLabel2(){

  }

  /**
   * スペーサー２に内部項目を追加します。
   */
  protected void addSpacer2(){

  }

  /**
   * 次回表示に内部項目を追加します。
   */
  protected void addPanelNextCheck(){

    panelNextCheck.add(getNextCheck(), VRLayout.FLOW);

    panelNextCheck.add(getOk(), VRLayout.FLOW);

  }

  /**
   * 次回表示確認チェックボックスに内部項目を追加します。
   */
  protected void addNextCheck(){

  }

  /**
   * ＯＫボタンに内部項目を追加します。
   */
  protected void addOk(){

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
      new QP009Design().setVisible(true);
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QP009Design getThis() {
    return this;
  }
}
