
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
 * 開発者: 小笠　貴志
 * 作成日: 2011/03/02  日本コンピューター株式会社 小笠　貴志 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 利用者登録／修正 (O)
 * プロセス 事業者一覧 (003)
 * プログラム 事業者一覧 (QO003)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo003;
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
 * 事業者一覧画面項目デザイン(QO003) 
 */
public class QO003Design extends QkanAffairContainer implements ACAffairable {
  //GUIコンポーネント

  private ACAffairButtonBar buttons;

  private ACAffairButton find;

  private ACAffairButton detail;

  private ACAffairButton insert;

  private ACAffairButton delete;

  private ACAffairButton print;

  private ACPanel contents;

  private VRLayout contentsLayout;

  private ACGroupBox findContens;

  private VRLayout findContensLayout;

  private ACComboBox findContentproviderType;

  private ACLabelContainer findContentproviderTypeContainer;

  private ACComboBoxModelAdapter findContentproviderTypeModel;

  private ACTextField findContentproviderId;

  private ACLabelContainer findContentproviderIdContainer;

  private ACTextField findContentproviderName;

  private ACLabelContainer findContentproviderNameContainer;

  private ACTable providerTable;

  private VRTableColumnModel providerTableColumnModel;

  private ACTableColumn providerNoColumn;

  private ACTableColumn providerTypeColumn;

  private ACTableColumn providerIdColumn;

  private ACTableColumn providerNameColumn;

  private ACTableColumn providerZipColumn;

  private ACTableColumn providerAddressColumn;

  private ACTableColumn providerTelColumn;

  private ACTableColumn providerFaxColumn;

  private ACTableColumn providerDivisionColumn;

  private ACTableColumn providerRegionColumn;

  private ACTableColumn providerChargeColumn;

  //getter

  /**
   * ボタンバーを取得します。
   * @return ボタンバー
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("事業所一覧");

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

      find.setToolTipText("事業所の情報を検索します。");

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

      detail.setToolTipText("選択された事業所の編集画面に移ります。");

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

      insert.setToolTipText("事業所を新規に作成します。");

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

      delete.setToolTipText("事業所の全情報を削除します。");

      delete.setMnemonic('D');

      delete.setIconPath(ACConstants.ICON_PATH_DELETE_24);

      addDelete();
    }
    return delete;

  }

  /**
   * 印刷ボタンを取得します。
   * @return 印刷ボタン
   */
  public ACAffairButton getPrint(){
    if(print==null){

      print = new ACAffairButton();

      print.setText("印刷(P)");

      print.setToolTipText("事業所一覧の印刷を実行します。");

      print.setMnemonic('P');

      print.setIconPath(ACConstants.ICON_PATH_PRINT_24);

      addPrint();
    }
    return print;

  }

  /**
   * クライアント領域を取得します。
   * @return クライアント領域
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      contents.setLayout(getContentsLayout());

      addContents();
    }
    return contents;

  }

  /**
   * クライアント領域レイアウトを取得します。
   * @return クライアント領域レイアウト
   */
  public VRLayout getContentsLayout(){
    if(contentsLayout==null){

      contentsLayout = new VRLayout();

      addContentsLayout();
    }
    return contentsLayout;

  }

  /**
   * 検索条件領域を取得します。
   * @return 検索条件領域
   */
  public ACGroupBox getFindContens(){
    if(findContens==null){

      findContens = new ACGroupBox();

      findContens.setText("表示条件");

      findContens.setLayout(getFindContensLayout());

      addFindContens();
    }
    return findContens;

  }

  /**
   * 検索条件領域レイアウトを取得します。
   * @return 検索条件領域レイアウト
   */
  public VRLayout getFindContensLayout(){
    if(findContensLayout==null){

      findContensLayout = new VRLayout();

      addFindContensLayout();
    }
    return findContensLayout;

  }

  /**
   * 事業所種別を取得します。
   * @return 事業所種別
   */
  public ACComboBox getFindContentproviderType(){
    if(findContentproviderType==null){

      findContentproviderType = new ACComboBox();

      getFindContentproviderTypeContainer().setText("事業所種別");

      findContentproviderType.setBindPath("PROVIDER_TYPE");

      findContentproviderType.setEditable(false);

      findContentproviderType.setModelBindPath("PROVIDER_TYPE");

      findContentproviderType.setRenderBindPath("CONTENT");

      findContentproviderType.setBlankable(true);

      findContentproviderType.setModel(getFindContentproviderTypeModel());

      addFindContentproviderType();
    }
    return findContentproviderType;

  }

  /**
   * 事業所種別コンテナを取得します。
   * @return 事業所種別コンテナ
   */
  protected ACLabelContainer getFindContentproviderTypeContainer(){
    if(findContentproviderTypeContainer==null){
      findContentproviderTypeContainer = new ACLabelContainer();
      findContentproviderTypeContainer.setFollowChildEnabled(true);
      findContentproviderTypeContainer.setVAlignment(VRLayout.CENTER);
      findContentproviderTypeContainer.add(getFindContentproviderType(), VRLayout.CLIENT);
    }
    return findContentproviderTypeContainer;
  }

  /**
   * 事業所種別モデルを取得します。
   * @return 事業所種別モデル
   */
  protected ACComboBoxModelAdapter getFindContentproviderTypeModel(){
    if(findContentproviderTypeModel==null){
      findContentproviderTypeModel = new ACComboBoxModelAdapter();
      addFindContentproviderTypeModel();
    }
    return findContentproviderTypeModel;
  }

  /**
   * 事業所番号を取得します。
   * @return 事業所番号
   */
  public ACTextField getFindContentproviderId(){
    if(findContentproviderId==null){

      findContentproviderId = new ACTextField();

      getFindContentproviderIdContainer().setText("事業所番号");

      findContentproviderId.setBindPath("PROVIDER_ID");

      findContentproviderId.setColumns(9);

      findContentproviderId.setHorizontalAlignment(SwingConstants.LEFT);

      findContentproviderId.setMaxLength(10);

      addFindContentproviderId();
    }
    return findContentproviderId;

  }

  /**
   * 事業所番号コンテナを取得します。
   * @return 事業所番号コンテナ
   */
  protected ACLabelContainer getFindContentproviderIdContainer(){
    if(findContentproviderIdContainer==null){
      findContentproviderIdContainer = new ACLabelContainer();
      findContentproviderIdContainer.setFollowChildEnabled(true);
      findContentproviderIdContainer.setVAlignment(VRLayout.CENTER);
      findContentproviderIdContainer.add(getFindContentproviderId(), VRLayout.CLIENT);
    }
    return findContentproviderIdContainer;
  }

  /**
   * 事業所名称を取得します。
   * @return 事業所名称
   */
  public ACTextField getFindContentproviderName(){
    if(findContentproviderName==null){

      findContentproviderName = new ACTextField();

      getFindContentproviderNameContainer().setText("事業所名称");

      findContentproviderName.setBindPath("PROVIDER_NAME");

      findContentproviderName.setColumns(30);

      findContentproviderName.setHorizontalAlignment(SwingConstants.LEFT);

      findContentproviderName.setIMEMode(InputSubset.KANJI);

      findContentproviderName.setMaxLength(128);

      addFindContentproviderName();
    }
    return findContentproviderName;

  }

  /**
   * 事業所名称コンテナを取得します。
   * @return 事業所名称コンテナ
   */
  protected ACLabelContainer getFindContentproviderNameContainer(){
    if(findContentproviderNameContainer==null){
      findContentproviderNameContainer = new ACLabelContainer();
      findContentproviderNameContainer.setFollowChildEnabled(true);
      findContentproviderNameContainer.setVAlignment(VRLayout.CENTER);
      findContentproviderNameContainer.add(getFindContentproviderName(), VRLayout.CLIENT);
    }
    return findContentproviderNameContainer;
  }

  /**
   * 事業所一覧を取得します。
   * @return 事業所一覧
   */
  public ACTable getProviderTable(){
    if(providerTable==null){

      providerTable = new ACTable();

      providerTable.setColumnModel(getProviderTableColumnModel());

      providerTable.setExtendLastColumn(false);

      addProviderTable();
    }
    return providerTable;

  }

  /**
   * 事業所一覧カラムモデルを取得します。
   * @return 事業所一覧カラムモデル
   */
  protected VRTableColumnModel getProviderTableColumnModel(){
    if(providerTableColumnModel==null){
      providerTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addProviderTableColumnModel();
    }
    return providerTableColumnModel;
  }

  /**
   * 一覧：No.を取得します。
   * @return 一覧：No.
   */
  public ACTableColumn getProviderNoColumn(){
    if(providerNoColumn==null){

      providerNoColumn = new ACTableColumn(0);

      providerNoColumn.setHeaderValue("No.");

      providerNoColumn.setColumns(3);

      providerNoColumn.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      providerNoColumn.setSortable(false);

      addProviderNoColumn();
    }
    return providerNoColumn;

  }

  /**
   * 一覧：事業所種別を取得します。
   * @return 一覧：事業所種別
   */
  public ACTableColumn getProviderTypeColumn(){
    if(providerTypeColumn==null){

      providerTypeColumn = new ACTableColumn(0);

      providerTypeColumn.setHeaderValue("事業所種別");

      providerTypeColumn.setColumns(6);

      providerTypeColumn.setHorizontalAlignment(SwingConstants.LEFT);

      addProviderTypeColumn();
    }
    return providerTypeColumn;

  }

  /**
   * 一覧：事業所番号を取得します。
   * @return 一覧：事業所番号
   */
  public ACTableColumn getProviderIdColumn(){
    if(providerIdColumn==null){

      providerIdColumn = new ACTableColumn(1);

      providerIdColumn.setHeaderValue("事業所番号");

      providerIdColumn.setColumns(7);

      providerIdColumn.setHorizontalAlignment(SwingConstants.LEFT);

      addProviderIdColumn();
    }
    return providerIdColumn;

  }

  /**
   * 一覧：事業所名称を取得します。
   * @return 一覧：事業所名称
   */
  public ACTableColumn getProviderNameColumn(){
    if(providerNameColumn==null){

      providerNameColumn = new ACTableColumn(2);

      providerNameColumn.setHeaderValue("事業所名称");

      providerNameColumn.setColumns(14);

      providerNameColumn.setHorizontalAlignment(SwingConstants.LEFT);

      addProviderNameColumn();
    }
    return providerNameColumn;

  }

  /**
   * 一覧：郵便番号を取得します。
   * @return 一覧：郵便番号
   */
  public ACTableColumn getProviderZipColumn(){
    if(providerZipColumn==null){

      providerZipColumn = new ACTableColumn(3);

      providerZipColumn.setHeaderValue("郵便番号");

      providerZipColumn.setColumns(6);

      providerZipColumn.setHorizontalAlignment(SwingConstants.LEFT);

      addProviderZipColumn();
    }
    return providerZipColumn;

  }

  /**
   * 一覧：所在地を取得します。
   * @return 一覧：所在地
   */
  public ACTableColumn getProviderAddressColumn(){
    if(providerAddressColumn==null){

      providerAddressColumn = new ACTableColumn(4);

      providerAddressColumn.setHeaderValue("所在地");

      providerAddressColumn.setColumns(10);

      providerAddressColumn.setHorizontalAlignment(SwingConstants.LEFT);

      addProviderAddressColumn();
    }
    return providerAddressColumn;

  }

  /**
   * 一覧：電話番号を取得します。
   * @return 一覧：電話番号
   */
  public ACTableColumn getProviderTelColumn(){
    if(providerTelColumn==null){

      providerTelColumn = new ACTableColumn(5);

      providerTelColumn.setHeaderValue("電話番号");

      providerTelColumn.setColumns(9);

      providerTelColumn.setHorizontalAlignment(SwingConstants.LEFT);

      addProviderTelColumn();
    }
    return providerTelColumn;

  }

  /**
   * 一覧：FAX番号を取得します。
   * @return 一覧：FAX番号
   */
  public ACTableColumn getProviderFaxColumn(){
    if(providerFaxColumn==null){

      providerFaxColumn = new ACTableColumn(6);

      providerFaxColumn.setHeaderValue("FAX番号");

      providerFaxColumn.setColumns(9);

      providerFaxColumn.setHorizontalAlignment(SwingConstants.LEFT);

      addProviderFaxColumn();
    }
    return providerFaxColumn;

  }

  /**
   * 一覧：事業区分を取得します。
   * @return 一覧：事業区分
   */
  public ACTableColumn getProviderDivisionColumn(){
    if(providerDivisionColumn==null){

      providerDivisionColumn = new ACTableColumn(7);

      providerDivisionColumn.setHeaderValue("事業区分");

      providerDivisionColumn.setColumns(5);

      providerDivisionColumn.setHorizontalAlignment(SwingConstants.LEFT);

      addProviderDivisionColumn();
    }
    return providerDivisionColumn;

  }

  /**
   * 一覧：地域区分を取得します。
   * @return 一覧：地域区分
   */
  public ACTableColumn getProviderRegionColumn(){
    if(providerRegionColumn==null){

      providerRegionColumn = new ACTableColumn(8);

      providerRegionColumn.setHeaderValue("地域区分");

      providerRegionColumn.setColumns(5);

      providerRegionColumn.setHorizontalAlignment(SwingConstants.LEFT);

      addProviderRegionColumn();
    }
    return providerRegionColumn;

  }

  /**
   * 一覧：介護支援専門員名を取得します。
   * @return 一覧：介護支援専門員名
   */
  public ACTableColumn getProviderChargeColumn(){
    if(providerChargeColumn==null){

      providerChargeColumn = new ACTableColumn(9);

      providerChargeColumn.setHeaderValue("担当者");

      providerChargeColumn.setColumns(50);

      providerChargeColumn.setHorizontalAlignment(SwingConstants.LEFT);

      addProviderChargeColumn();
    }
    return providerChargeColumn;

  }

  /**
   * コンストラクタです。
   */
  public QO003Design() {

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

    this.add(getContents(), VRLayout.CLIENT);

  }

  /**
   * ボタンバーに内部項目を追加します。
   */
  protected void addButtons(){

    buttons.add(getPrint(), VRLayout.EAST);
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
   * 印刷ボタンに内部項目を追加します。
   */
  protected void addPrint(){

  }

  /**
   * クライアント領域に内部項目を追加します。
   */
  protected void addContents(){

    contents.add(getFindContens(), VRLayout.NORTH);

    contents.add(getProviderTable(), VRLayout.CLIENT);

  }

  /**
   * クライアント領域レイアウトに内部項目を追加します。
   */
  protected void addContentsLayout(){

  }

  /**
   * 検索条件領域に内部項目を追加します。
   */
  protected void addFindContens(){

    findContens.add(getFindContentproviderTypeContainer(), VRLayout.WEST);

    findContens.add(getFindContentproviderIdContainer(), VRLayout.WEST);

    findContens.add(getFindContentproviderNameContainer(), VRLayout.WEST);

  }

  /**
   * 検索条件領域レイアウトに内部項目を追加します。
   */
  protected void addFindContensLayout(){

  }

  /**
   * 事業所種別に内部項目を追加します。
   */
  protected void addFindContentproviderType(){

  }

  /**
   * 事業所種別モデルに内部項目を追加します。
   */
  protected void addFindContentproviderTypeModel(){

  }

  /**
   * 事業所番号に内部項目を追加します。
   */
  protected void addFindContentproviderId(){

  }

  /**
   * 事業所名称に内部項目を追加します。
   */
  protected void addFindContentproviderName(){

  }

  /**
   * 事業所一覧に内部項目を追加します。
   */
  protected void addProviderTable(){

  }

  /**
   * 事業所一覧カラムモデルに内部項目を追加します。
   */
  protected void addProviderTableColumnModel(){

    getProviderTableColumnModel().addColumn(getProviderNoColumn());

    getProviderTableColumnModel().addColumn(getProviderTypeColumn());

    getProviderTableColumnModel().addColumn(getProviderIdColumn());

    getProviderTableColumnModel().addColumn(getProviderNameColumn());

    getProviderTableColumnModel().addColumn(getProviderZipColumn());

    getProviderTableColumnModel().addColumn(getProviderAddressColumn());

    getProviderTableColumnModel().addColumn(getProviderTelColumn());

    getProviderTableColumnModel().addColumn(getProviderFaxColumn());

    getProviderTableColumnModel().addColumn(getProviderDivisionColumn());

    getProviderTableColumnModel().addColumn(getProviderRegionColumn());

    getProviderTableColumnModel().addColumn(getProviderChargeColumn());

  }

  /**
   * 一覧：No.に内部項目を追加します。
   */
  protected void addProviderNoColumn(){

  }

  /**
   * 一覧：事業所種別に内部項目を追加します。
   */
  protected void addProviderTypeColumn(){

  }

  /**
   * 一覧：事業所番号に内部項目を追加します。
   */
  protected void addProviderIdColumn(){

  }

  /**
   * 一覧：事業所名称に内部項目を追加します。
   */
  protected void addProviderNameColumn(){

  }

  /**
   * 一覧：郵便番号に内部項目を追加します。
   */
  protected void addProviderZipColumn(){

  }

  /**
   * 一覧：所在地に内部項目を追加します。
   */
  protected void addProviderAddressColumn(){

  }

  /**
   * 一覧：電話番号に内部項目を追加します。
   */
  protected void addProviderTelColumn(){

  }

  /**
   * 一覧：FAX番号に内部項目を追加します。
   */
  protected void addProviderFaxColumn(){

  }

  /**
   * 一覧：事業区分に内部項目を追加します。
   */
  protected void addProviderDivisionColumn(){

  }

  /**
   * 一覧：地域区分に内部項目を追加します。
   */
  protected void addProviderRegionColumn(){

  }

  /**
   * 一覧：介護支援専門員名に内部項目を追加します。
   */
  protected void addProviderChargeColumn(){

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

    return getFindContentproviderType();

  }
  public void initAffair(ACAffairInfo affair) throws Exception {
  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    try {
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QO003Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO003Design getThis() {
    return this;
  }
}
