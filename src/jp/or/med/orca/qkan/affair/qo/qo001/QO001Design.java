
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
 * 作成日: 2006/03/30  日本コンピューター株式会社 小笠　貴志 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他 (O)
 * プロセス 保険者一覧登録 (001)
 * プログラム 保険者一覧登録 (QO001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo001;
import java.awt.Component;
import java.awt.im.InputSubset;

import javax.swing.SwingConstants;
import javax.swing.table.TableColumn;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACAffairButton;
import jp.nichicom.ac.component.ACAffairButtonBar;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.table.ACTable;
import jp.nichicom.ac.component.table.ACTableCellViewer;
import jp.nichicom.ac.component.table.ACTableColumn;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACAffairable;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.vr.component.table.VRTableColumnModel;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanAffairContainer;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.text.QkanInsurerTypeFormat;
/**
 * 保険者一覧登録画面項目デザイン(QO001) 
 */
public class QO001Design extends QkanAffairContainer implements ACAffairable {
  //GUIコンポーネント

  private ACAffairButtonBar buttons;

  private ACAffairButton find;

  private ACAffairButton detail;

  private ACAffairButton insert;

  private ACAffairButton delete;

  private ACPanel insurerInfoFind;

  private ACTextField insurerName;

  private ACLabelContainer insurerNameContainer;

  private ACPanel insurerInfos;

  private ACTable insurerInfoTable;

  private VRTableColumnModel insurerInfoTableColumnModel;

  private ACTableColumn insurerNoColumn;

  private ACTableColumn insurerIdColumn;

  private ACTableColumn insurerNameColumn;

  private ACTableColumn insurerTypeColumn;

  private ACTableColumn insurerZipcdColumn;

  private ACTableColumn insurerAddressColumn;

  private ACTableColumn insurerTelColumn;

  //getter

  /**
   * ボタンバーを取得します。
   * @return ボタンバー
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("保険者一覧");

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

      find.setToolTipText("保険者を検索します。");

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

      detail.setToolTipText("選択された保険者の編集画面移ります。");

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

      insert.setToolTipText("保険者を新規に作成します。");

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

      delete.setToolTipText("選択された保険者の全情報を削除します。");

      delete.setMnemonic('D');

      delete.setIconPath(ACConstants.ICON_PATH_DELETE_24);

      addDelete();
    }
    return delete;

  }

  /**
   * 保険者情報検索領域を取得します。
   * @return 保険者情報検索領域
   */
  public ACPanel getInsurerInfoFind(){
    if(insurerInfoFind==null){

      insurerInfoFind = new ACPanel();

      insurerInfoFind.setVgap(4);

      addInsurerInfoFind();
    }
    return insurerInfoFind;

  }

  /**
   * 保険者名称を取得します。
   * @return 保険者名称
   */
  public ACTextField getInsurerName(){
    if(insurerName==null){

      insurerName = new ACTextField();

      getInsurerNameContainer().setText("保険者名称");

      insurerName.setBindPath("INSURER_NAME_FIND");

      insurerName.setColumns(25);

      insurerName.setIMEMode(InputSubset.KANJI);

      insurerName.setMaxLength(64);

      addInsurerName();
    }
    return insurerName;

  }

  /**
   * 保険者名称コンテナを取得します。
   * @return 保険者名称コンテナ
   */
  protected ACLabelContainer getInsurerNameContainer(){
    if(insurerNameContainer==null){
      insurerNameContainer = new ACLabelContainer();
      insurerNameContainer.setFollowChildEnabled(true);
      insurerNameContainer.setVAlignment(VRLayout.CENTER);
      insurerNameContainer.add(getInsurerName(), null);
    }
    return insurerNameContainer;
  }

  /**
   * 保険者情報表示領域を取得します。
   * @return 保険者情報表示領域
   */
  public ACPanel getInsurerInfos(){
    if(insurerInfos==null){

      insurerInfos = new ACPanel();

      addInsurerInfos();
    }
    return insurerInfos;

  }

  /**
   * 保険者情報テーブルを取得します。
   * @return 保険者情報テーブル
   */
  public ACTable getInsurerInfoTable(){
    if(insurerInfoTable==null){

      insurerInfoTable = new ACTable();

      insurerInfoTable.setColumnModel(getInsurerInfoTableColumnModel());

      addInsurerInfoTable();
    }
    return insurerInfoTable;

  }

  /**
   * 保険者情報テーブルカラムモデルを取得します。
   * @return 保険者情報テーブルカラムモデル
   */
  protected VRTableColumnModel getInsurerInfoTableColumnModel(){
    if(insurerInfoTableColumnModel==null){
      insurerInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addInsurerInfoTableColumnModel();
    }
    return insurerInfoTableColumnModel;
  }

  /**
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getInsurerNoColumn(){
    if(insurerNoColumn==null){

      insurerNoColumn = new ACTableColumn();

      insurerNoColumn.setHeaderValue("No.");

      insurerNoColumn.setColumnName("INSURER_ID");

      insurerNoColumn.setColumns(3);

      insurerNoColumn.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      insurerNoColumn.setSortable(false);

      addInsurerNoColumn();
    }
    return insurerNoColumn;

  }

  /**
   * 保険者番号を取得します。
   * @return 保険者番号
   */
  public ACTableColumn getInsurerIdColumn(){
    if(insurerIdColumn==null){

      insurerIdColumn = new ACTableColumn();

      insurerIdColumn.setHeaderValue("保険者番号");

      insurerIdColumn.setColumnName("INSURER_ID");

      insurerIdColumn.setColumns(7);

      insurerIdColumn.setHorizontalAlignment(SwingConstants.LEFT);

      addInsurerIdColumn();
    }
    return insurerIdColumn;

  }

  /**
   * 保険者名称を取得します。
   * @return 保険者名称
   */
  public ACTableColumn getInsurerNameColumn(){
    if(insurerNameColumn==null){

      insurerNameColumn = new ACTableColumn();

      insurerNameColumn.setHeaderValue("保険者名称");

      insurerNameColumn.setColumnName("INSURER_NAME");

      insurerNameColumn.setColumns(20);

      insurerNameColumn.setHorizontalAlignment(SwingConstants.LEFT);

      addInsurerNameColumn();
    }
    return insurerNameColumn;

  }

  /**
   * 保険者区分を取得します。
   * @return 保険者区分
   */
  public ACTableColumn getInsurerTypeColumn(){
    if(insurerTypeColumn==null){

      insurerTypeColumn = new ACTableColumn();

      insurerTypeColumn.setHeaderValue("保険者区分");

      insurerTypeColumn.setColumnName("INSURER_TYPE");

      insurerTypeColumn.setColumns(7);

      insurerTypeColumn.setHorizontalAlignment(SwingConstants.LEFT);

      insurerTypeColumn.setFormat(QkanInsurerTypeFormat.getInstance());

      addInsurerTypeColumn();
    }
    return insurerTypeColumn;

  }

  /**
   * 保険者郵便番号を取得します。
   * @return 保険者郵便番号
   */
  public ACTableColumn getInsurerZipcdColumn(){
    if(insurerZipcdColumn==null){

      insurerZipcdColumn = new ACTableColumn();

      insurerZipcdColumn.setHeaderValue("郵便番号");

      insurerZipcdColumn.setColumnName("INSURER_ZIP_FIRST+'-'+INSURER_ZIP_SECOND");

      insurerZipcdColumn.setColumns(6);

      insurerZipcdColumn.setHorizontalAlignment(SwingConstants.LEFT);

      addInsurerZipcdColumn();
    }
    return insurerZipcdColumn;

  }

  /**
   * 保険者所在地を取得します。
   * @return 保険者所在地
   */
  public ACTableColumn getInsurerAddressColumn(){
    if(insurerAddressColumn==null){

      insurerAddressColumn = new ACTableColumn();

      insurerAddressColumn.setHeaderValue("所在地");

      insurerAddressColumn.setColumnName("INSURER_ADDRESS");

      insurerAddressColumn.setColumns(25);

      insurerAddressColumn.setHorizontalAlignment(SwingConstants.LEFT);

      addInsurerAddressColumn();
    }
    return insurerAddressColumn;

  }

  /**
   * 保険者電話番号を取得します。
   * @return 保険者電話番号
   */
  public ACTableColumn getInsurerTelColumn(){
    if(insurerTelColumn==null){

      insurerTelColumn = new ACTableColumn();

      insurerTelColumn.setHeaderValue("電話番号");

      insurerTelColumn.setColumnName("INSURER_TEL_FIRST+'-'+INSURER_TEL_SECOND+'-'+INSURER_TEL_THIRD");

      insurerTelColumn.setColumns(8);

      insurerTelColumn.setHorizontalAlignment(SwingConstants.LEFT);

      addInsurerTelColumn();
    }
    return insurerTelColumn;

  }

  /**
   * コンストラクタです。
   */
  public QO001Design() {

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

    this.add(getInsurerInfoFind(), VRLayout.NORTH);

    this.add(getInsurerInfos(), VRLayout.CLIENT);

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
   * 保険者情報検索領域に内部項目を追加します。
   */
  protected void addInsurerInfoFind(){

    insurerInfoFind.add(getInsurerNameContainer(), VRLayout.FLOW);

  }

  /**
   * 保険者名称に内部項目を追加します。
   */
  protected void addInsurerName(){

  }

  /**
   * 保険者情報表示領域に内部項目を追加します。
   */
  protected void addInsurerInfos(){

    insurerInfos.add(getInsurerInfoTable(), VRLayout.CLIENT);

  }

  /**
   * 保険者情報テーブルに内部項目を追加します。
   */
  protected void addInsurerInfoTable(){

  }

  /**
   * 保険者情報テーブルカラムモデルに内部項目を追加します。
   */
  protected void addInsurerInfoTableColumnModel(){

    getInsurerInfoTableColumnModel().addColumn(getInsurerNoColumn());

    getInsurerInfoTableColumnModel().addColumn(getInsurerIdColumn());

    getInsurerInfoTableColumnModel().addColumn(getInsurerNameColumn());

    getInsurerInfoTableColumnModel().addColumn(getInsurerTypeColumn());

    getInsurerInfoTableColumnModel().addColumn(getInsurerZipcdColumn());

    getInsurerInfoTableColumnModel().addColumn(getInsurerAddressColumn());

    getInsurerInfoTableColumnModel().addColumn(getInsurerTelColumn());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addInsurerNoColumn(){

  }

  /**
   * 保険者番号に内部項目を追加します。
   */
  protected void addInsurerIdColumn(){

  }

  /**
   * 保険者名称に内部項目を追加します。
   */
  protected void addInsurerNameColumn(){

  }

  /**
   * 保険者区分に内部項目を追加します。
   */
  protected void addInsurerTypeColumn(){

  }

  /**
   * 保険者郵便番号に内部項目を追加します。
   */
  protected void addInsurerZipcdColumn(){

  }

  /**
   * 保険者所在地に内部項目を追加します。
   */
  protected void addInsurerAddressColumn(){

  }

  /**
   * 保険者電話番号に内部項目を追加します。
   */
  protected void addInsurerTelColumn(){

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

    return getInsurerName();

  }
  public void initAffair(ACAffairInfo affair) throws Exception {
  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    try {
      ACFrame.setVRLookAndFeel();
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QO001Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO001Design getThis() {
    return this;
  }
}
