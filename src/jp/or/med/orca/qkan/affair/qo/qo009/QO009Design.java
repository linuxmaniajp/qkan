
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
 * 開発者: 樋口 雅彦
 * 作成日: 2006/03/06  日本コンピューター株式会社 樋口 雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 医療機関管理 (009)
 * プログラム 医療機関一覧 (QO009)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo009;
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
 * 医療機関一覧画面項目デザイン(QO009) 
 */
public class QO009Design extends QkanAffairContainer implements ACAffairable {
  //GUIコンポーネント

  private ACAffairButtonBar buttons;

  private ACAffairButton find;

  private ACAffairButton detail;

  private ACAffairButton insert;

  private ACAffairButton delete;

  private ACGroupBox medicalFacilityFind;

  private ACTextField medicalFacilityName;

  private ACLabelContainer medicalFacilityNameContainer;

  private ACPanel medicalFacilityInfo;

  private ACTable medicalFacilityTable;

  private VRTableColumnModel medicalFacilityTableColumnModel;

  private ACTableColumn medicalFacilityTableColumn0;

  private ACTableColumn medicalFacilityTableColumn1;

  private ACTableColumn medicalFacilityTableColumn2;

  private ACTableColumn medicalFacilityTableColumn3;

  private ACTableColumn medicalFacilityTableColumn4;

  private ACTableColumn medicalFacilityTableColumn5;

  //getter

  /**
   * ボタンバーを取得します。
   * @return ボタンバー
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("医療機関一覧");

      addButtons();
    }
    return buttons;

  }

  /**
   * 検索(F)を取得します。
   * @return 検索(F)
   */
  public ACAffairButton getFind(){
    if(find==null){

      find = new ACAffairButton();

      find.setText("検索(F)");

      find.setToolTipText("医療機関を検索します。");

      find.setMnemonic('F');

      find.setIconPath(ACConstants.ICON_PATH_FIND_24);

      addFind();
    }
    return find;

  }

  /**
   * 詳細(E)を取得します。
   * @return 詳細(E)
   */
  public ACAffairButton getDetail(){
    if(detail==null){

      detail = new ACAffairButton();

      detail.setText("詳細(E)");

      detail.setToolTipText("選択された医療機関の編集画面移ります。");

      detail.setMnemonic('E');

      detail.setIconPath(ACConstants.ICON_PATH_DETAIL_24);

      addDetail();
    }
    return detail;

  }

  /**
   * 新規(N)を取得します。
   * @return 新規(N)
   */
  public ACAffairButton getInsert(){
    if(insert==null){

      insert = new ACAffairButton();

      insert.setText("新規(N)");

      insert.setToolTipText("医療機関を新規に作成します。");

      insert.setMnemonic('N');

      insert.setIconPath(ACConstants.ICON_PATH_NEW_24);

      addInsert();
    }
    return insert;

  }

  /**
   * 削除(D)を取得します。
   * @return 削除(D)
   */
  public ACAffairButton getDelete(){
    if(delete==null){

      delete = new ACAffairButton();

      delete.setText("削除(D)");

      delete.setToolTipText("選択された医療機関の全情報を削除します。");

      delete.setMnemonic('D');

      delete.setIconPath(ACConstants.ICON_PATH_DELETE_24);

      addDelete();
    }
    return delete;

  }

  /**
   * 医療機関情報検索領域を取得します。
   * @return 医療機関情報検索領域
   */
  public ACGroupBox getMedicalFacilityFind(){
    if(medicalFacilityFind==null){

      medicalFacilityFind = new ACGroupBox();

      medicalFacilityFind.setText("表示条件");

      medicalFacilityFind.setVgap(2);

      addMedicalFacilityFind();
    }
    return medicalFacilityFind;

  }

  /**
   * 医療機関名称を取得します。
   * @return 医療機関名称
   */
  public ACTextField getMedicalFacilityName(){
    if(medicalFacilityName==null){

      medicalFacilityName = new ACTextField();

      getMedicalFacilityNameContainer().setText("医療機関名称");

      medicalFacilityName.setColumns(25);

      medicalFacilityName.setIMEMode(InputSubset.KANJI);

      medicalFacilityName.setMaxLength(64);

      addMedicalFacilityName();
    }
    return medicalFacilityName;

  }

  /**
   * 医療機関名称コンテナを取得します。
   * @return 医療機関名称コンテナ
   */
  protected ACLabelContainer getMedicalFacilityNameContainer(){
    if(medicalFacilityNameContainer==null){
      medicalFacilityNameContainer = new ACLabelContainer();
      medicalFacilityNameContainer.setFollowChildEnabled(true);
      medicalFacilityNameContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityNameContainer.add(getMedicalFacilityName(), null);
    }
    return medicalFacilityNameContainer;
  }

  /**
   * 医療機関情報表示領域を取得します。
   * @return 医療機関情報表示領域
   */
  public ACPanel getMedicalFacilityInfo(){
    if(medicalFacilityInfo==null){

      medicalFacilityInfo = new ACPanel();

      addMedicalFacilityInfo();
    }
    return medicalFacilityInfo;

  }

  /**
   * 医療機関情報テーブルを取得します。
   * @return 医療機関情報テーブル
   */
  public ACTable getMedicalFacilityTable(){
    if(medicalFacilityTable==null){

      medicalFacilityTable = new ACTable();

      medicalFacilityTable.setColumnModel(getMedicalFacilityTableColumnModel());

      addMedicalFacilityTable();
    }
    return medicalFacilityTable;

  }

  /**
   * 医療機関情報テーブルカラムモデルを取得します。
   * @return 医療機関情報テーブルカラムモデル
   */
  protected VRTableColumnModel getMedicalFacilityTableColumnModel(){
    if(medicalFacilityTableColumnModel==null){
      medicalFacilityTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addMedicalFacilityTableColumnModel();
    }
    return medicalFacilityTableColumnModel;
  }

  /**
   * 一覧：No.を取得します。
   * @return 一覧：No.
   */
  public ACTableColumn getMedicalFacilityTableColumn0(){
    if(medicalFacilityTableColumn0==null){

      medicalFacilityTableColumn0 = new ACTableColumn(0);

      medicalFacilityTableColumn0.setHeaderValue("No.");

      medicalFacilityTableColumn0.setColumns(3);

      medicalFacilityTableColumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      medicalFacilityTableColumn0.setSortable(false);

      addMedicalFacilityTableColumn0();
    }
    return medicalFacilityTableColumn0;

  }

  /**
   * 一覧：医療機関名称を取得します。
   * @return 一覧：医療機関名称
   */
  public ACTableColumn getMedicalFacilityTableColumn1(){
    if(medicalFacilityTableColumn1==null){

      medicalFacilityTableColumn1 = new ACTableColumn(0);

      medicalFacilityTableColumn1.setHeaderValue("医療機関名称");

      medicalFacilityTableColumn1.setColumns(20);

      medicalFacilityTableColumn1.setHorizontalAlignment(SwingConstants.LEFT);

      addMedicalFacilityTableColumn1();
    }
    return medicalFacilityTableColumn1;

  }

  /**
   * 一覧：医療機関郵便番号を取得します。
   * @return 一覧：医療機関郵便番号
   */
  public ACTableColumn getMedicalFacilityTableColumn2(){
    if(medicalFacilityTableColumn2==null){

      medicalFacilityTableColumn2 = new ACTableColumn(1);

      medicalFacilityTableColumn2.setHeaderValue("郵便番号");

      medicalFacilityTableColumn2.setColumns(7);

      medicalFacilityTableColumn2.setHorizontalAlignment(SwingConstants.LEFT);

      addMedicalFacilityTableColumn2();
    }
    return medicalFacilityTableColumn2;

  }

  /**
   * 一覧：医療機関所在地を取得します。
   * @return 一覧：医療機関所在地
   */
  public ACTableColumn getMedicalFacilityTableColumn3(){
    if(medicalFacilityTableColumn3==null){

      medicalFacilityTableColumn3 = new ACTableColumn(2);

      medicalFacilityTableColumn3.setHeaderValue("所在地");

      medicalFacilityTableColumn3.setColumns(37);

      medicalFacilityTableColumn3.setHorizontalAlignment(SwingConstants.LEFT);

      addMedicalFacilityTableColumn3();
    }
    return medicalFacilityTableColumn3;

  }

  /**
   * 一覧：医療機関電話番号を取得します。
   * @return 一覧：医療機関電話番号
   */
  public ACTableColumn getMedicalFacilityTableColumn4(){
    if(medicalFacilityTableColumn4==null){

      medicalFacilityTableColumn4 = new ACTableColumn(3);

      medicalFacilityTableColumn4.setHeaderValue("電話番号");

      medicalFacilityTableColumn4.setColumns(9);

      medicalFacilityTableColumn4.setHorizontalAlignment(SwingConstants.LEFT);

      addMedicalFacilityTableColumn4();
    }
    return medicalFacilityTableColumn4;

  }

  /**
   * 一覧：医療機関FAXを取得します。
   * @return 一覧：医療機関FAX
   */
  public ACTableColumn getMedicalFacilityTableColumn5(){
    if(medicalFacilityTableColumn5==null){

      medicalFacilityTableColumn5 = new ACTableColumn(4);

      medicalFacilityTableColumn5.setHeaderValue("FAX");

      medicalFacilityTableColumn5.setColumns(9);

      medicalFacilityTableColumn5.setHorizontalAlignment(SwingConstants.LEFT);

      addMedicalFacilityTableColumn5();
    }
    return medicalFacilityTableColumn5;

  }

  /**
   * コンストラクタです。
   */
  public QO009Design() {

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

    this.add(getMedicalFacilityFind(), VRLayout.NORTH);

    this.add(getMedicalFacilityInfo(), VRLayout.CLIENT);

  }

  /**
   * ボタンバーに内部項目を追加します。
   */
  protected void addButtons(){

    buttons.add(getDelete(), VRLayout.EAST);
    buttons.add(getInsert(), VRLayout.EAST);
    buttons.add(getDetail(), VRLayout.EAST);
    buttons.add(getFind(), VRLayout.EAST);
  }

  /**
   * 検索(F)に内部項目を追加します。
   */
  protected void addFind(){

  }

  /**
   * 詳細(E)に内部項目を追加します。
   */
  protected void addDetail(){

  }

  /**
   * 新規(N)に内部項目を追加します。
   */
  protected void addInsert(){

  }

  /**
   * 削除(D)に内部項目を追加します。
   */
  protected void addDelete(){

  }

  /**
   * 医療機関情報検索領域に内部項目を追加します。
   */
  protected void addMedicalFacilityFind(){

    medicalFacilityFind.add(getMedicalFacilityNameContainer(), VRLayout.FLOW);

  }

  /**
   * 医療機関名称に内部項目を追加します。
   */
  protected void addMedicalFacilityName(){

  }

  /**
   * 医療機関情報表示領域に内部項目を追加します。
   */
  protected void addMedicalFacilityInfo(){

    medicalFacilityInfo.add(getMedicalFacilityTable(), VRLayout.CLIENT);

  }

  /**
   * 医療機関情報テーブルに内部項目を追加します。
   */
  protected void addMedicalFacilityTable(){

  }

  /**
   * 医療機関情報テーブルカラムモデルに内部項目を追加します。
   */
  protected void addMedicalFacilityTableColumnModel(){

    getMedicalFacilityTableColumnModel().addColumn(getMedicalFacilityTableColumn0());

    getMedicalFacilityTableColumnModel().addColumn(getMedicalFacilityTableColumn1());

    getMedicalFacilityTableColumnModel().addColumn(getMedicalFacilityTableColumn2());

    getMedicalFacilityTableColumnModel().addColumn(getMedicalFacilityTableColumn3());

    getMedicalFacilityTableColumnModel().addColumn(getMedicalFacilityTableColumn4());

    getMedicalFacilityTableColumnModel().addColumn(getMedicalFacilityTableColumn5());

  }

  /**
   * 一覧：No.に内部項目を追加します。
   */
  protected void addMedicalFacilityTableColumn0(){

  }

  /**
   * 一覧：医療機関名称に内部項目を追加します。
   */
  protected void addMedicalFacilityTableColumn1(){

  }

  /**
   * 一覧：医療機関郵便番号に内部項目を追加します。
   */
  protected void addMedicalFacilityTableColumn2(){

  }

  /**
   * 一覧：医療機関所在地に内部項目を追加します。
   */
  protected void addMedicalFacilityTableColumn3(){

  }

  /**
   * 一覧：医療機関電話番号に内部項目を追加します。
   */
  protected void addMedicalFacilityTableColumn4(){

  }

  /**
   * 一覧：医療機関FAXに内部項目を追加します。
   */
  protected void addMedicalFacilityTableColumn5(){

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

    return getMedicalFacilityName();

  }
  public void initAffair(ACAffairInfo affair) throws Exception {
  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    try {
      ACFrame.setVRLookAndFeel();
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QO009Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO009Design getThis() {
    return this;
  }
}
