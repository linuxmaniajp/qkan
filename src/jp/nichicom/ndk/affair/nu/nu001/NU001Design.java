
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
 * 作成日: 2006/09/13  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム nichicom (N)
 * サブシステム ユーティリティ (U)
 * プロセス PDF比較 (001)
 * プログラム ××画面 (NU001)
 *
 *****************************************************************
 */
package jp.nichicom.ndk.affair.nu.nu001;
import java.awt.Component;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACAffairButton;
import jp.nichicom.ac.component.ACAffairButtonBar;
import jp.nichicom.ac.component.ACButton;
import jp.nichicom.ac.component.ACTextArea;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.core.ACAffairContainer;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACAffairable;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRMap;
/**
 * ××画面画面項目デザイン(NU001) 
 */
@SuppressWarnings("serial")
public class NU001Design extends ACAffairContainer implements ACAffairable {
  //GUIコンポーネント

  private ACAffairButtonBar buttons;

  private ACAffairButton compare;

  private ACAffairButton exit;

  private ACGroupBox settings;

  private ACLabelContainer pdf1Container;

  private ACTextField pdf1;

  private ACButton pdf1Browse;

  private ACLabelContainer pdf2Container;

  private ACTextField pdf2;

  private ACButton pdf2Browse;

  private ACGroupBox results;

  private ACTextArea result;

  //getter

  /**
   * 業務ボタンバーを取得します。
   * @return 業務ボタンバー
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setBackVisible(false);
      
      buttons.setText("PDF比較ツール");

      addButtons();
    }
    return buttons;

  }

  /**
   * 比較を取得します。
   * @return 比較
   */
  public ACAffairButton getCompare(){
    if(compare==null){

      compare = new ACAffairButton();

      compare.setText("比較(C)");

      compare.setMnemonic('C');

      compare.setIconPath(ACConstants.ICON_PATH_START_24);

      addCompare();
    }
    return compare;

  }

  /**
   * 終了を取得します。
   * @return 終了
   */
  public ACAffairButton getExit(){
    if(exit==null){

      exit = new ACAffairButton();

      exit.setText("終了(X)");

      exit.setMnemonic('X');

      exit.setIconPath(ACConstants.ICON_PATH_EXIT_24);

      addExit();
    }
    return exit;

  }

  /**
   * 設定を取得します。
   * @return 設定
   */
  public ACGroupBox getSettings(){
    if(settings==null){

      settings = new ACGroupBox();

      settings.setText("設定");

      addSettings();
    }
    return settings;

  }

  /**
   * 比較するPDF1コンテナを取得します。
   * @return 比較するPDF1コンテナ
   */
  public ACLabelContainer getPdf1Container(){
    if(pdf1Container==null){

      pdf1Container = new ACLabelContainer();

      pdf1Container.setText("比較するPDF1");

      pdf1Container.setAutoWrap(false);

      addPdf1Container();
    }
    return pdf1Container;

  }

  /**
   * 比較するPDF1を取得します。
   * @return 比較するPDF1
   */
  public ACTextField getPdf1(){
    if(pdf1==null){

      pdf1 = new ACTextField();

      pdf1.setColumns(45);

      addPdf1();
    }
    return pdf1;

  }

  /**
   * 比較するPDF1参照を取得します。
   * @return 比較するPDF1参照
   */
  public ACButton getPdf1Browse(){
    if(pdf1Browse==null){

      pdf1Browse = new ACButton();

      pdf1Browse.setText("参照..");

      addPdf1Browse();
    }
    return pdf1Browse;

  }

  /**
   * 比較するPDF2を取得します。
   * @return 比較するPDF2
   */
  public ACLabelContainer getPdf2Container(){
    if(pdf2Container==null){

      pdf2Container = new ACLabelContainer();

      pdf2Container.setText("比較するPDF2");

      addPdf2Container();
    }
    return pdf2Container;

  }

  /**
   * 比較するPDF2を取得します。
   * @return 比較するPDF2
   */
  public ACTextField getPdf2(){
    if(pdf2==null){

      pdf2 = new ACTextField();

      pdf2.setColumns(45);

      addPdf2();
    }
    return pdf2;

  }

  /**
   * 比較するPDF2参照を取得します。
   * @return 比較するPDF2参照
   */
  public ACButton getPdf2Browse(){
    if(pdf2Browse==null){

      pdf2Browse = new ACButton();

      pdf2Browse.setText("参照..");

      addPdf2Browse();
    }
    return pdf2Browse;

  }

  /**
   * 結果を取得します。
   * @return 結果
   */
  public ACGroupBox getResults(){
    if(results==null){

      results = new ACGroupBox();

      results.setText("比較結果");

      addResults();
    }
    return results;

  }

  /**
   * 比較結果を取得します。
   * @return 比較結果
   */
  public ACTextArea getResult(){
    if(result==null){

      result = new ACTextArea();

      result.setEditable(false);

      addResult();
    }
    return result;

  }

  /**
   * コンストラクタです。
   */
  public NU001Design() {

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

    this.add(getButtons(), VRLayout.NORTH);

    this.add(getSettings(), VRLayout.NORTH);

    this.add(getResults(), VRLayout.CLIENT);

  }

  /**
   * 業務ボタンバーに内部項目を追加します。
   */
  protected void addButtons(){

    buttons.add(getExit(), VRLayout.EAST);
    buttons.add(getCompare(), VRLayout.EAST);
  }

  /**
   * 比較に内部項目を追加します。
   */
  protected void addCompare(){

  }

  /**
   * 終了に内部項目を追加します。
   */
  protected void addExit(){

  }

  /**
   * 設定に内部項目を追加します。
   */
  protected void addSettings(){

    settings.add(getPdf1Container(), VRLayout.FLOW_INSETLINE_RETURN);

    settings.add(getPdf2Container(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 比較するPDF1コンテナに内部項目を追加します。
   */
  protected void addPdf1Container(){

    pdf1Container.add(getPdf1(), VRLayout.FLOW);

    pdf1Container.add(getPdf1Browse(), VRLayout.FLOW);

  }

  /**
   * 比較するPDF1に内部項目を追加します。
   */
  protected void addPdf1(){

  }

  /**
   * 比較するPDF1参照に内部項目を追加します。
   */
  protected void addPdf1Browse(){

  }

  /**
   * 比較するPDF2に内部項目を追加します。
   */
  protected void addPdf2Container(){

    pdf2Container.add(getPdf2(), VRLayout.FLOW);

    pdf2Container.add(getPdf2Browse(), VRLayout.FLOW);

  }

  /**
   * 比較するPDF2に内部項目を追加します。
   */
  protected void addPdf2(){

  }

  /**
   * 比較するPDF2参照に内部項目を追加します。
   */
  protected void addPdf2Browse(){

  }

  /**
   * 結果に内部項目を追加します。
   */
  protected void addResults(){

    results.add(getResult(), VRLayout.CLIENT);

  }

  /**
   * 比較結果に内部項目を追加します。
   */
  protected void addResult(){

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

    return getPdf1();

  }
  public void initAffair(ACAffairInfo affair) throws Exception {
  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    try {
      ACFrame.debugStart(new ACAffairInfo(NU001Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected NU001Design getThis() {
    return this;
  }
}
