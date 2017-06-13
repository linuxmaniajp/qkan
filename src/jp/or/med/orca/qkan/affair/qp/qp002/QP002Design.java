
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
 * 作成日: 2016/02/03  日本コンピューター株式会社 樋口雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求データ作成 (P)
 * プロセス 確認・修正 (002)
 * プログラム 帳票(様式)選択 (QP002)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp002;
import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.table.TableColumn;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACAffairButton;
import jp.nichicom.ac.component.ACAffairButtonBar;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.table.ACCheckBoxTableColumnPopupMenu;
import jp.nichicom.ac.component.table.ACTable;
import jp.nichicom.ac.component.table.ACTableCellViewer;
import jp.nichicom.ac.component.table.ACTableColumn;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACAffairable;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.text.ACBorderBlankDateFormat;
import jp.nichicom.vr.component.table.VRTableCellViewer;
import jp.nichicom.vr.component.table.VRTableColumnModel;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanAffairContainer;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
/**
 * 帳票(様式)選択画面項目デザイン(QP002) 
 */
public class QP002Design extends QkanAffairContainer implements ACAffairable {
  //GUIコンポーネント

  private ACPanel contents;

  private ACAffairButtonBar buttons;

  private ACAffairButton seikyu;

  private ACAffairButton delete;

  private ACAffairButton select;

  private ACPanel patientNames;

  private ACLabel patinetNameLabel;

  private ACTextField patientName;

  private ACLabel patientNoLabel1;

  private ACTextField patientNo;

  private ACLabel PatientNoLabel2;

  private ACPanel providerPanel;

  private ACTable providerTable;

  private VRTableColumnModel providerTableColumnModel;

  private ACTableColumn providerTableColumn1;

  private ACTableColumn providerTableColumn9;

  private ACTableColumn providerTableColumn2;

  private ACTableColumn providerTableColumn7;

  private ACTableColumn providerTableColumn8;

  private ACTableColumn providerTableColumn3;

  private ACTableColumn providerTableColumn4;

  private ACTableColumn providerTableColumn5;

  private ACTableColumn providerTableColumn6;

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
   * ボタンバーを取得します。
   * @return ボタンバー
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("帳票(様式)・事業所選択");

      addButtons();
    }
    return buttons;

  }

  /**
   * 利用請求を取得します。
   * @return 利用請求
   */
  public ACAffairButton getSeikyu(){
    if(seikyu==null){

      seikyu = new ACAffairButton();

      seikyu.setText("利用請求(B)");

      seikyu.setToolTipText("利用者向け請求詳細画面に遷移します。");

      seikyu.setMnemonic('B');

      seikyu.setIconPath(QkanConstants.ICON_PATH_PATIENT_BILL_24);

      addSeikyu();
    }
    return seikyu;

  }

  /**
   * 削除ボタンを取得します。
   * @return 削除ボタン
   */
  public ACAffairButton getDelete(){
    if(delete==null){

      delete = new ACAffairButton();

      delete.setText("削除(D)");

      delete.setEnabled(false);

      delete.setToolTipText("明細書情報を削除します。");

      delete.setMnemonic('D');

      delete.setIconPath(ACConstants.ICON_PATH_DELETE_24);

      addDelete();
    }
    return delete;

  }

  /**
   * 詳細ボタンを取得します。
   * @return 詳細ボタン
   */
  public ACAffairButton getSelect(){
    if(select==null){

      select = new ACAffairButton();

      select.setText("詳細(E)");

      select.setToolTipText("明細書情報画面に遷移します。");

      select.setMnemonic('E');

      select.setIconPath(QkanConstants.ICON_PATH_PROVIDER_BILL_24);

      addSelect();
    }
    return select;

  }

  /**
   * 利用者名領域を取得します。
   * @return 利用者名領域
   */
  public ACPanel getPatientNames(){
    if(patientNames==null){

      patientNames = new ACPanel();

      patientNames.setHgap(3);

      patientNames.setVgap(3);

      addPatientNames();
    }
    return patientNames;

  }

  /**
   * 利用者名・ラベルを取得します。
   * @return 利用者名・ラベル
   */
  public ACLabel getPatinetNameLabel(){
    if(patinetNameLabel==null){

      patinetNameLabel = new ACLabel();

      patinetNameLabel.setText("利用者名");

      addPatinetNameLabel();
    }
    return patinetNameLabel;

  }

  /**
   * 利用者名を取得します。
   * @return 利用者名
   */
  public ACTextField getPatientName(){
    if(patientName==null){

      patientName = new ACTextField();

      patientName.setBindPath("PATIENT_NAME");

      patientName.setEditable(false);

      patientName.setColumns(35);

      patientName.setMaxLength(34);

      addPatientName();
    }
    return patientName;

  }

  /**
   * 利用者コード・ラベル1を取得します。
   * @return 利用者コード・ラベル1
   */
  public ACLabel getPatientNoLabel1(){
    if(patientNoLabel1==null){

      patientNoLabel1 = new ACLabel();

      patientNoLabel1.setText("（利用者コード");

      addPatientNoLabel1();
    }
    return patientNoLabel1;

  }

  /**
   * 利用者コードを取得します。
   * @return 利用者コード
   */
  public ACTextField getPatientNo(){
    if(patientNo==null){

      patientNo = new ACTextField();

      patientNo.setBindPath("PATIENT_CODE");

      patientNo.setEditable(false);

      patientNo.setColumns(15);

      patientNo.setMaxLength(20);

      addPatientNo();
    }
    return patientNo;

  }

  /**
   * 利用者コード・ラベル2を取得します。
   * @return 利用者コード・ラベル2
   */
  public ACLabel getPatientNoLabel2(){
    if(PatientNoLabel2==null){

      PatientNoLabel2 = new ACLabel();

      PatientNoLabel2.setText("）");

      addPatientNoLabel2();
    }
    return PatientNoLabel2;

  }

  /**
   * テーブル領域を取得します。
   * @return テーブル領域
   */
  public ACPanel getProviderPanel(){
    if(providerPanel==null){

      providerPanel = new ACPanel();

      addProviderPanel();
    }
    return providerPanel;

  }

  /**
   * 事業所一覧を取得します。
   * @return 事業所一覧
   */
  public ACTable getProviderTable(){
    if(providerTable==null){

      providerTable = new ACTable();

      providerTable.setColumnModel(getProviderTableColumnModel());

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
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getProviderTableColumn1(){
    if(providerTableColumn1==null){

      providerTableColumn1 = new ACTableColumn();

      providerTableColumn1.setHeaderValue("No.");

      providerTableColumn1.setColumnName("NO");

      providerTableColumn1.setColumns(3);

      providerTableColumn1.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      providerTableColumn1.setSortable(false);

      addProviderTableColumn1();
    }
    return providerTableColumn1;

  }

  /**
   * 削除(列を取得します。
   * @return 削除(列
   */
  public ACTableColumn getProviderTableColumn9(){
    if(providerTableColumn9==null){

      providerTableColumn9 = new ACTableColumn();

      providerTableColumn9.setHeaderValue("削除");

      providerTableColumn9.setColumnName("DELETE");

      providerTableColumn9.setEditable(true);

      providerTableColumn9.setColumns(4);

      providerTableColumn9.setHorizontalAlignment(SwingConstants.CENTER);

      providerTableColumn9.setRendererType(VRTableCellViewer.RENDERER_TYPE_CHECK_BOX);

      providerTableColumn9.setEditorType(VRTableCellViewer.EDITOR_TYPE_CHECK_BOX);

      providerTableColumn9.setHeaderPopupMenu( new ACCheckBoxTableColumnPopupMenu(getProviderTable(), "DELETE", new Boolean(true), new Boolean(false)) );

      addProviderTableColumn9();
    }
    return providerTableColumn9;

  }

  /**
   * 年月度を取得します。
   * @return 年月度
   */
  public ACTableColumn getProviderTableColumn2(){
    if(providerTableColumn2==null){

      providerTableColumn2 = new ACTableColumn();

      providerTableColumn2.setHeaderValue("年月度");

      providerTableColumn2.setColumnName("TARGET_DATE");

      providerTableColumn2.setColumns(8);

      providerTableColumn2.setFormat(new ACBorderBlankDateFormat("gggee年MM月"));

      addProviderTableColumn2();
    }
    return providerTableColumn2;

  }

  /**
   * 保険者番号を取得します。
   * @return 保険者番号
   */
  public ACTableColumn getProviderTableColumn7(){
    if(providerTableColumn7==null){

      providerTableColumn7 = new ACTableColumn();

      providerTableColumn7.setHeaderValue("保険者番号");

      providerTableColumn7.setColumnName("INSURER_ID");

      providerTableColumn7.setColumns(6);

      addProviderTableColumn7();
    }
    return providerTableColumn7;

  }

  /**
   * 被保険者番号を取得します。
   * @return 被保険者番号
   */
  public ACTableColumn getProviderTableColumn8(){
    if(providerTableColumn8==null){

      providerTableColumn8 = new ACTableColumn();

      providerTableColumn8.setHeaderValue("被保険者番号");

      providerTableColumn8.setColumnName("UNIT_INSURED_ID");

      providerTableColumn8.setColumns(8);

      addProviderTableColumn8();
    }
    return providerTableColumn8;

  }

  /**
   * 事業所番号を取得します。
   * @return 事業所番号
   */
  public ACTableColumn getProviderTableColumn3(){
    if(providerTableColumn3==null){

      providerTableColumn3 = new ACTableColumn();

      providerTableColumn3.setHeaderValue("事業所番号");

      providerTableColumn3.setColumnName("PROVIDER_ID");

      providerTableColumn3.setColumns(8);

      addProviderTableColumn3();
    }
    return providerTableColumn3;

  }

  /**
   * 事業所名称を取得します。
   * @return 事業所名称
   */
  public ACTableColumn getProviderTableColumn4(){
    if(providerTableColumn4==null){

      providerTableColumn4 = new ACTableColumn();

      providerTableColumn4.setHeaderValue("事業所名称");

      providerTableColumn4.setColumnName("PROVIDER_NAME");

      providerTableColumn4.setColumns(20);

      addProviderTableColumn4();
    }
    return providerTableColumn4;

  }

  /**
   * 保険種類を取得します。
   * @return 保険種類
   */
  public ACTableColumn getProviderTableColumn5(){
    if(providerTableColumn5==null){

      providerTableColumn5 = new ACTableColumn();

      providerTableColumn5.setHeaderValue("保険種類");

      providerTableColumn5.setColumnName("INSURED_ID");

      providerTableColumn5.setColumns(6);

      addProviderTableColumn5();
    }
    return providerTableColumn5;

  }

  /**
   * 様式を取得します。
   * @return 様式
   */
  public ACTableColumn getProviderTableColumn6(){
    if(providerTableColumn6==null){

      providerTableColumn6 = new ACTableColumn();

      providerTableColumn6.setHeaderValue("様式");

      providerTableColumn6.setColumnName("CLAIM_STYLE_TYPE");

      providerTableColumn6.setColumns(6);

      addProviderTableColumn6();
    }
    return providerTableColumn6;

  }

  /**
   * コンストラクタです。
   */
  public QP002Design() {

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

    contents.add(getButtons(), VRLayout.NORTH);

    contents.add(getPatientNames(), VRLayout.NORTH);

    contents.add(getProviderPanel(), VRLayout.CLIENT);

  }

  /**
   * ボタンバーに内部項目を追加します。
   */
  protected void addButtons(){

    buttons.add(getSelect(), VRLayout.EAST);
    buttons.add(getDelete(), VRLayout.EAST);
    buttons.add(getSeikyu(), VRLayout.EAST);
  }

  /**
   * 利用請求に内部項目を追加します。
   */
  protected void addSeikyu(){

  }

  /**
   * 削除ボタンに内部項目を追加します。
   */
  protected void addDelete(){

  }

  /**
   * 詳細ボタンに内部項目を追加します。
   */
  protected void addSelect(){

  }

  /**
   * 利用者名領域に内部項目を追加します。
   */
  protected void addPatientNames(){

    patientNames.add(getPatinetNameLabel(), VRLayout.FLOW);

    patientNames.add(getPatientName(), VRLayout.FLOW);

    patientNames.add(getPatientNoLabel1(), VRLayout.FLOW);

    patientNames.add(getPatientNo(), VRLayout.FLOW);

    patientNames.add(getPatientNoLabel2(), VRLayout.FLOW);

  }

  /**
   * 利用者名・ラベルに内部項目を追加します。
   */
  protected void addPatinetNameLabel(){

  }

  /**
   * 利用者名に内部項目を追加します。
   */
  protected void addPatientName(){

  }

  /**
   * 利用者コード・ラベル1に内部項目を追加します。
   */
  protected void addPatientNoLabel1(){

  }

  /**
   * 利用者コードに内部項目を追加します。
   */
  protected void addPatientNo(){

  }

  /**
   * 利用者コード・ラベル2に内部項目を追加します。
   */
  protected void addPatientNoLabel2(){

  }

  /**
   * テーブル領域に内部項目を追加します。
   */
  protected void addProviderPanel(){

    providerPanel.add(getProviderTable(), VRLayout.CLIENT);

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

    getProviderTableColumnModel().addColumn(getProviderTableColumn1());

    getProviderTableColumnModel().addColumn(getProviderTableColumn9());

    getProviderTableColumnModel().addColumn(getProviderTableColumn2());

    getProviderTableColumnModel().addColumn(getProviderTableColumn7());

    getProviderTableColumnModel().addColumn(getProviderTableColumn8());

    getProviderTableColumnModel().addColumn(getProviderTableColumn3());

    getProviderTableColumnModel().addColumn(getProviderTableColumn4());

    getProviderTableColumnModel().addColumn(getProviderTableColumn5());

    getProviderTableColumnModel().addColumn(getProviderTableColumn6());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addProviderTableColumn1(){

  }

  /**
   * 削除(列に内部項目を追加します。
   */
  protected void addProviderTableColumn9(){

  }

  /**
   * 年月度に内部項目を追加します。
   */
  protected void addProviderTableColumn2(){

  }

  /**
   * 保険者番号に内部項目を追加します。
   */
  protected void addProviderTableColumn7(){

  }

  /**
   * 被保険者番号に内部項目を追加します。
   */
  protected void addProviderTableColumn8(){

  }

  /**
   * 事業所番号に内部項目を追加します。
   */
  protected void addProviderTableColumn3(){

  }

  /**
   * 事業所名称に内部項目を追加します。
   */
  protected void addProviderTableColumn4(){

  }

  /**
   * 保険種類に内部項目を追加します。
   */
  protected void addProviderTableColumn5(){

  }

  /**
   * 様式に内部項目を追加します。
   */
  protected void addProviderTableColumn6(){

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

    return getProviderTable();

  }
  public void initAffair(ACAffairInfo affair) throws Exception {
  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    try {
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QP002Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QP002Design getThis() {
    return this;
  }
}
