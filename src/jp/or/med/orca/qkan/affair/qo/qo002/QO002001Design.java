
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
 * 作成日: 2009/07/13  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (O)
 * プロセス サービス予定 (002)
 * プログラム 保険者選択 (QO002001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo002;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.im.InputSubset;

import javax.swing.table.TableColumn;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.component.ACButton;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.table.ACTable;
import jp.nichicom.ac.component.table.ACTableColumn;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.vr.component.table.VRTableColumnModel;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanAffairDialog;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
/**
 * 保険者選択画面項目デザイン(QO002001) 
 */
public class QO002001Design extends QkanAffairDialog {
  //GUIコンポーネント

  private ACPanel contents;

  private ACPanel contentsFind;

  private ACTextField insurerText;

  private ACLabelContainer insurerTextContainer;

  private ACGroupBox insurerGroup;

  private ACTable detailsTable;

  private VRTableColumnModel detailsTableColumnModel;

  private ACTableColumn detailsTableColumn2;

  private ACTableColumn detailsTableColumn3;

  private ACPanel buttons;

  private ACButton apply;

  private ACButton close;

  //getter

  /**
   * クライアント領域を取得します。
   * @return クライアント領域
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      contents.setAutoWrap(false);

      contents.setHgap(0);

      contents.setLabelMargin(0);

      contents.setVgap(0);

      addContents();
    }
    return contents;

  }

  /**
   * 検索領域を取得します。
   * @return 検索領域
   */
  public ACPanel getContentsFind(){
    if(contentsFind==null){

      contentsFind = new ACPanel();

      contentsFind.setAutoWrap(false);

      contentsFind.setHgap(2);

      addContentsFind();
    }
    return contentsFind;

  }

  /**
   * 保険者名を取得します。
   * @return 保険者名
   */
  public ACTextField getInsurerText(){
    if(insurerText==null){

      insurerText = new ACTextField();

      getInsurerTextContainer().setText("保険者名称");

      insurerText.setBindPath("FIND_INSURER_NAME");

      insurerText.setColumns(26);

      insurerText.setIMEMode(InputSubset.KANJI);

      insurerText.setMaxLength(25);

      addInsurerText();
    }
    return insurerText;

  }

  /**
   * 保険者名コンテナを取得します。
   * @return 保険者名コンテナ
   */
  protected ACLabelContainer getInsurerTextContainer(){
    if(insurerTextContainer==null){
      insurerTextContainer = new ACLabelContainer();
      insurerTextContainer.setFollowChildEnabled(true);
      insurerTextContainer.setVAlignment(VRLayout.CENTER);
      insurerTextContainer.add(getInsurerText(), null);
    }
    return insurerTextContainer;
  }

  /**
   * 保険者テーブル領域を取得します。
   * @return 保険者テーブル領域
   */
  public ACGroupBox getInsurerGroup(){
    if(insurerGroup==null){

      insurerGroup = new ACGroupBox();

      addInsurerGroup();
    }
    return insurerGroup;

  }

  /**
   * 保険者テーブルを取得します。
   * @return 保険者テーブル
   */
  public ACTable getDetailsTable(){
    if(detailsTable==null){

      detailsTable = new ACTable();

      detailsTable.setColumnModel(getDetailsTableColumnModel());

      detailsTable.setMinimumSize(new Dimension(500, 200));

      addDetailsTable();
    }
    return detailsTable;

  }

  /**
   * 保険者テーブルカラムモデルを取得します。
   * @return 保険者テーブルカラムモデル
   */
  protected VRTableColumnModel getDetailsTableColumnModel(){
    if(detailsTableColumnModel==null){
      detailsTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addDetailsTableColumnModel();
    }
    return detailsTableColumnModel;
  }

  /**
   * 保険者番号を取得します。
   * @return 保険者番号
   */
  public ACTableColumn getDetailsTableColumn2(){
    if(detailsTableColumn2==null){

      detailsTableColumn2 = new ACTableColumn();

      detailsTableColumn2.setHeaderValue("保険者番号");

      detailsTableColumn2.setColumnName("INSURER_NO");

      detailsTableColumn2.setColumns(6);

      addDetailsTableColumn2();
    }
    return detailsTableColumn2;

  }

  /**
   * 保険者名称を取得します。
   * @return 保険者名称
   */
  public ACTableColumn getDetailsTableColumn3(){
    if(detailsTableColumn3==null){

      detailsTableColumn3 = new ACTableColumn();

      detailsTableColumn3.setHeaderValue("保険者名称");

      detailsTableColumn3.setColumnName("INSURER_NAME");

      detailsTableColumn3.setColumns(30);

      addDetailsTableColumn3();
    }
    return detailsTableColumn3;

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
   * 反映ボタンを取得します。
   * @return 反映ボタン
   */
  public ACButton getApply(){
    if(apply==null){

      apply = new ACButton();

      apply.setText("設定(S)");

      apply.setMnemonic('S');

      addApply();
    }
    return apply;

  }

  /**
   * 閉じるボタンを取得します。
   * @return 閉じるボタン
   */
  public ACButton getClose(){
    if(close==null){

      close = new ACButton();

      close.setText("閉じる(C)");

      close.setMnemonic('C');

      addClose();
    }
    return close;

  }

  /**
   * コンストラクタです。
   */
  public QO002001Design() {

    super(ACFrame.getInstance(), true);
    this.getContentPane().setLayout(new VRLayout());
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    try {
      initialize();

      setSize(500, 250);

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

    contents.add(getContentsFind(), VRLayout.NORTH);

    contents.add(getInsurerGroup(), VRLayout.CLIENT);

    contents.add(getButtons(), VRLayout.SOUTH);
  }

  /**
   * 検索領域に内部項目を追加します。
   */
  protected void addContentsFind(){

    contentsFind.add(getInsurerTextContainer(), VRLayout.FLOW_RETURN);

  }

  /**
   * 保険者名に内部項目を追加します。
   */
  protected void addInsurerText(){

  }

  /**
   * 保険者テーブル領域に内部項目を追加します。
   */
  protected void addInsurerGroup(){

    insurerGroup.add(getDetailsTable(), VRLayout.CLIENT);

  }

  /**
   * 保険者テーブルに内部項目を追加します。
   */
  protected void addDetailsTable(){

  }

  /**
   * 保険者テーブルカラムモデルに内部項目を追加します。
   */
  protected void addDetailsTableColumnModel(){

    getDetailsTableColumnModel().addColumn(getDetailsTableColumn2());

    getDetailsTableColumnModel().addColumn(getDetailsTableColumn3());

  }

  /**
   * 保険者番号に内部項目を追加します。
   */
  protected void addDetailsTableColumn2(){

  }

  /**
   * 保険者名称に内部項目を追加します。
   */
  protected void addDetailsTableColumn3(){

  }

  /**
   * ボタン領域に内部項目を追加します。
   */
  protected void addButtons(){

    buttons.add(getClose(), VRLayout.EAST);
    buttons.add(getApply(), VRLayout.EAST);
  }

  /**
   * 反映ボタンに内部項目を追加します。
   */
  protected void addApply(){

  }

  /**
   * 閉じるボタンに内部項目を追加します。
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
      new QO002001Design().setVisible(true);
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO002001Design getThis() {
    return this;
  }
}
