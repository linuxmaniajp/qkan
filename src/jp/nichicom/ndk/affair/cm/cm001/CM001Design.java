
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
 * 開発者: 田中　統蔵
 * 作成日: 2005/12/08  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム CodeWall (C)
 * サブシステム CodeWall (M)
 * プロセス メインメニュー (001)
 * プログラム メインメニュー (CM001)
 *
 *****************************************************************
 */
package jp.nichicom.ndk.affair.cm.cm001;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.mainmenu.ACMainMenuButton;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRMap;
/**
 * メインメニュー画面項目デザイン(CM001) 
 */
@SuppressWarnings("serial")
public class CM001Design extends ACPanel {
  //GUIコンポーネント

  private ACLabel systemTitle;

  private ACMainMenuButton encode;

  private ACMainMenuButton createExecute;

  private ACMainMenuButton systemExit;

  //getter

  /**
   * タイトルを取得します。
   * @return タイトル
   */
  public ACLabel getSystemTitle(){
    if(systemTitle==null){

      systemTitle = new ACLabel();

      systemTitle.setText("Code Wall 2005");

      systemTitle.setForeground(Color.blue);

      Font font = systemTitle.getFont();
      if(font!=null){
        systemTitle.setFont(new Font(font.getName(), font.getStyle(), 20));
      }

      systemTitle.setRows(3);

      addSystemTitle();
    }
    return systemTitle;

  }

  /**
   * 暗号化を取得します。
   * @return 暗号化
   */
  public ACMainMenuButton getEncode(){
    if(encode==null){

      encode = new ACMainMenuButton();

      encode.setText("暗号化(E)");

    encode.setMnemonic('E');

      addEncode();
    }
    return encode;

  }

  /**
   * 起動コード生成を取得します。
   * @return 起動コード生成
   */
  public ACMainMenuButton getCreateExecute(){
    if(createExecute==null){

      createExecute = new ACMainMenuButton();

      createExecute.setText("起動コード生成(C)");

    createExecute.setMnemonic('C');

      addCreateExecute();
    }
    return createExecute;

  }

  /**
   * 終了を取得します。
   * @return 終了
   */
  public ACMainMenuButton getSystemExit(){
    if(systemExit==null){

      systemExit = new ACMainMenuButton();

      systemExit.setText("終了(X)");

    systemExit.setMnemonic('X');

      addSystemExit();
    }
    return systemExit;

  }

  /**
   * コンストラクタです。
   */
  public CM001Design() {

    try {
      jbInit();
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

    this.add(getSystemTitle(), VRLayout.NORTH);

    this.add(getEncode(), VRLayout.NORTH);

    this.add(getCreateExecute(), VRLayout.NORTH);

    this.add(getSystemExit(), VRLayout.NORTH);

  }

  /**
   * タイトルに内部項目を追加します。
   */
  protected void addSystemTitle(){

  }

  /**
   * 暗号化に内部項目を追加します。
   */
  protected void addEncode(){

  }

  /**
   * 起動コード生成に内部項目を追加します。
   */
  protected void addCreateExecute(){

  }

  /**
   * 終了に内部項目を追加します。
   */
  protected void addSystemExit(){

  }

  /**
   * コンポーネントを初期化します。
   * @throws Exception 初期化例外
   */
  private void jbInit() throws Exception {
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

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    try {
        ACFrame.setVRLookAndFeel();
      ACFrame.getInstance().getContentPane().add(new CM001Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
