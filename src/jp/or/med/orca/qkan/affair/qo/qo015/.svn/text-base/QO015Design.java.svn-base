
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
 * 開発者: 
 * 作成日: 2016/09/02  日本コンピューター株式会社  新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 総合事業サービスコード取込 (015)
 * プログラム 総合事業サービスコード取込 (QO015)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo015;
import java.awt.*;
import java.awt.im.*;
import javax.swing.*;
import javax.swing.table.TableColumn;

import jp.nichicom.ac.*;
import jp.nichicom.ac.component.*;
import jp.nichicom.ac.component.table.ACTable;
import jp.nichicom.ac.component.table.ACTableCellViewer;
import jp.nichicom.ac.component.table.ACTableColumn;
import jp.nichicom.ac.container.*;
import jp.nichicom.ac.core.*;
import jp.nichicom.vr.component.table.VRTableColumnModel;
import jp.nichicom.vr.layout.*;
import jp.nichicom.vr.text.*;
import jp.nichicom.vr.util.*;
import jp.or.med.orca.qkan.affair.*;
/**
 * 総合事業サービスコード取込画面項目デザイン(QO015) 
 */
public class QO015Design extends QkanAffairContainer implements ACAffairable {
  //GUIコンポーネント

  private ACAffairButtonBar buttons;

  private ACAffairButton importButton;

  private ACAffairButton editButton;

  private ACPanel contents;

  private ACGroupBox imports;

  private ACPanel importFileSelects;

  private ACTextField importFileSelectFileName;

  private ACLabelContainer importFileSelectFileNameContainer;

  private ACButton csvFileSelectFileCompareButton;

  private ACPanel importContents;

  private ACGroupBox importInfoGroup;

  private ACLabelContainer insurerContena;

  private ACTextField insurerId;

  private ACTextField insurerName;

  private ACTextField recordCnt;

  private ACLabelContainer recordCntContainer;

  private ACPanel comment;

  private ACLabel importComment1;

  private ACLabel importComment2;

  private ACLabel importComment3;

  private ACPanel historyInfos;

  private ACTable historyInfoTable;

  private VRTableColumnModel historyInfoTableColumnModel;

  private ACTableColumn insurerNoColumn;

  private ACTableColumn insurerIdColumn;

  private ACTableColumn insurerNameColumn;

  private ACTableColumn recordCntColumn;

  private ACTableColumn importDateColumn;

  //getter

  /**
   * ボタンバーを取得します。
   * @return ボタンバー
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("総合事業サービスコード取込");

      addButtons();
    }
    return buttons;

  }

  /**
   * 取込ボタンを取得します。
   * @return 取込ボタン
   */
  public ACAffairButton getImportButton(){
    if(importButton==null){

      importButton = new ACAffairButton();

      importButton.setText("取込(I)");

      importButton.setToolTipText("指定したファイルを取り込みます。");

      importButton.setMnemonic('I');

      importButton.setIconPath(ACConstants.ICON_PATH_UPDATE_24);

      addImportButton();
    }
    return importButton;

  }

  /**
   * 編集ボタンを取得します。
   * @return 編集ボタン
   */
  public ACAffairButton getEditButton(){
    if(editButton==null){

      editButton = new ACAffairButton();

      editButton.setText("編集(E)");

      editButton.setToolTipText("総合事業サービスコード一覧に移ります。");

      editButton.setMnemonic('E');

      editButton.setIconPath(ACConstants.ICON_PATH_DETAIL_24);

      addEditButton();
    }
    return editButton;

  }

  /**
   * クライアント領域を取得します。
   * @return クライアント領域
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      contents.setAutoWrap(false);

      addContents();
    }
    return contents;

  }

  /**
   * 取込設定領域を取得します。
   * @return 取込設定領域
   */
  public ACGroupBox getImports(){
    if(imports==null){

      imports = new ACGroupBox();

      addImports();
    }
    return imports;

  }

  /**
   * ファイル選択領域を取得します。
   * @return ファイル選択領域
   */
  public ACPanel getImportFileSelects(){
    if(importFileSelects==null){

      importFileSelects = new ACPanel();

      addImportFileSelects();
    }
    return importFileSelects;

  }

  /**
   * ファイル名入力領域を取得します。
   * @return ファイル名入力領域
   */
  public ACTextField getImportFileSelectFileName(){
    if(importFileSelectFileName==null){

      importFileSelectFileName = new ACTextField();

      getImportFileSelectFileNameContainer().setText("取込ファイル");

      importFileSelectFileName.setBindPath("IMPORT_FILE_SELECT_FILE_NAME");

      importFileSelectFileName.setEditable(false);

      importFileSelectFileName.setColumns(60);

      importFileSelectFileName.setIMEMode(InputSubset.LATIN);

      importFileSelectFileName.setMaxLength(320);

      addImportFileSelectFileName();
    }
    return importFileSelectFileName;

  }

  /**
   * ファイル名入力領域コンテナを取得します。
   * @return ファイル名入力領域コンテナ
   */
  protected ACLabelContainer getImportFileSelectFileNameContainer(){
    if(importFileSelectFileNameContainer==null){
      importFileSelectFileNameContainer = new ACLabelContainer();
      importFileSelectFileNameContainer.setFollowChildEnabled(true);
      importFileSelectFileNameContainer.setVAlignment(VRLayout.CENTER);
      importFileSelectFileNameContainer.add(getImportFileSelectFileName(), null);
    }
    return importFileSelectFileNameContainer;
  }

  /**
   * ファイル参照ボタンを取得します。
   * @return ファイル参照ボタン
   */
  public ACButton getCsvFileSelectFileCompareButton(){
    if(csvFileSelectFileCompareButton==null){

      csvFileSelectFileCompareButton = new ACButton();

      csvFileSelectFileCompareButton.setText("参照(L)");

      csvFileSelectFileCompareButton.setToolTipText("取込ファイル選択画面を表示します。");

      csvFileSelectFileCompareButton.setMnemonic('L');

      addCsvFileSelectFileCompareButton();
    }
    return csvFileSelectFileCompareButton;

  }

  /**
   * 取込内容パネルを取得します。
   * @return 取込内容パネル
   */
  public ACPanel getImportContents(){
    if(importContents==null){

      importContents = new ACPanel();

      addImportContents();
    }
    return importContents;

  }

  /**
   * 取込内容領域を取得します。
   * @return 取込内容領域
   */
  public ACGroupBox getImportInfoGroup(){
    if(importInfoGroup==null){

      importInfoGroup = new ACGroupBox();

      importInfoGroup.setText("取込内容");

      addImportInfoGroup();
    }
    return importInfoGroup;

  }

  /**
   * 保険者コンテナを取得します。
   * @return 保険者コンテナ
   */
  public ACLabelContainer getInsurerContena(){
    if(insurerContena==null){

      insurerContena = new ACLabelContainer();

      insurerContena.setText("保険者番号");

      addInsurerContena();
    }
    return insurerContena;

  }

  /**
   * 保険者番号を取得します。
   * @return 保険者番号
   */
  public ACTextField getInsurerId(){
    if(insurerId==null){

      insurerId = new ACTextField();

      insurerId.setBindPath("INSURER_ID");

      insurerId.setEditable(false);

      insurerId.setColumns(5);

      insurerId.setCharType(VRCharType.ONLY_DIGIT);

      insurerId.setHorizontalAlignment(SwingConstants.LEFT);

      insurerId.setIMEMode(InputSubset.LATIN);

      insurerId.setMaxLength(6);

      addInsurerId();
    }
    return insurerId;

  }

  /**
   * 保険者名称を取得します。
   * @return 保険者名称
   */
  public ACTextField getInsurerName(){
    if(insurerName==null){

      insurerName = new ACTextField();

      insurerName.setBindPath("INSURER_NAME");

      insurerName.setEditable(false);

      insurerName.setColumns(32);

      insurerName.setHorizontalAlignment(SwingConstants.LEFT);

      insurerName.setIMEMode(InputSubset.KANJI);

      insurerName.setMaxLength(32);

      addInsurerName();
    }
    return insurerName;

  }

  /**
   * レコード件数を取得します。
   * @return レコード件数
   */
  public ACTextField getRecordCnt(){
    if(recordCnt==null){

      recordCnt = new ACTextField();

      getRecordCntContainer().setText("レコード件数");

      recordCnt.setBindPath("RECORD_CNT");

      recordCnt.setEditable(false);

      recordCnt.setColumns(5);

      recordCnt.setCharType(VRCharType.ONLY_DIGIT);

      recordCnt.setHorizontalAlignment(SwingConstants.LEFT);

      recordCnt.setIMEMode(InputSubset.LATIN);

      recordCnt.setMaxLength(6);

      addRecordCnt();
    }
    return recordCnt;

  }

  /**
   * レコード件数コンテナを取得します。
   * @return レコード件数コンテナ
   */
  protected ACLabelContainer getRecordCntContainer(){
    if(recordCntContainer==null){
      recordCntContainer = new ACLabelContainer();
      recordCntContainer.setFollowChildEnabled(true);
      recordCntContainer.setVAlignment(VRLayout.CENTER);
      recordCntContainer.add(getRecordCnt(), null);
    }
    return recordCntContainer;
  }

  /**
   * コメント領域を取得します。
   * @return コメント領域
   */
  public ACPanel getComment(){
    if(comment==null){

      comment = new ACPanel();

      addComment();
    }
    return comment;

  }

  /**
   * 取込コメントを取得します。
   * @return 取込コメント
   */
  public ACLabel getImportComment1(){
    if(importComment1==null){

      importComment1 = new ACLabel();

      importComment1.setText("※対象の保険者の、登録されているデータを全て削除して取り込みを行います。");

      importComment1.setForeground(Color.red);

      importComment1.setAutoWrap(true);

      addImportComment1();
    }
    return importComment1;

  }

  /**
   * 取込コメントを取得します。
   * @return 取込コメント
   */
  public ACLabel getImportComment2(){
    if(importComment2==null){

      importComment2 = new ACLabel();

      importComment2.setText("※多様なサービス（X1、X2、X3）は取込対象外となります。");

      importComment2.setForeground(Color.red);

      importComment2.setAutoWrap(true);

      addImportComment2();
    }
    return importComment2;

  }

  /**
   * 取込コメントを取得します。
   * @return 取込コメント
   */
  public ACLabel getImportComment3(){
    if(importComment3==null){

      importComment3 = new ACLabel();

      importComment3.setText("※保険者情報詳細画面で「総合事業単位数単価」の設定を必ず行ってください。" + ACConstants.LINE_SEPARATOR + "　単位数単価の設定を行わないと予定管理、実績管理、実績確定・請求データ作成が正しく処理されません。");

      importComment3.setForeground(Color.red);

      importComment3.setAutoWrap(true);

      addImportComment3();
    }
    return importComment3;

  }

  /**
   * 履歴情報表示領域を取得します。
   * @return 履歴情報表示領域
   */
  public ACPanel getHistoryInfos(){
    if(historyInfos==null){

      historyInfos = new ACPanel();

      addHistoryInfos();
    }
    return historyInfos;

  }

  /**
   * 履歴情報テーブルを取得します。
   * @return 履歴情報テーブル
   */
  public ACTable getHistoryInfoTable(){
    if(historyInfoTable==null){

      historyInfoTable = new ACTable();

      historyInfoTable.setColumnModel(getHistoryInfoTableColumnModel());

      addHistoryInfoTable();
    }
    return historyInfoTable;

  }

  /**
   * 履歴情報テーブルカラムモデルを取得します。
   * @return 履歴情報テーブルカラムモデル
   */
  protected VRTableColumnModel getHistoryInfoTableColumnModel(){
    if(historyInfoTableColumnModel==null){
      historyInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addHistoryInfoTableColumnModel();
    }
    return historyInfoTableColumnModel;
  }

  /**
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getInsurerNoColumn(){
    if(insurerNoColumn==null){

      insurerNoColumn = new ACTableColumn();

      insurerNoColumn.setHeaderValue("No.");

      insurerNoColumn.setColumnName("SJ_SERVICE_CODE_HISTORY_ID");

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
   * 件数を取得します。
   * @return 件数
   */
  public ACTableColumn getRecordCntColumn(){
    if(recordCntColumn==null){

      recordCntColumn = new ACTableColumn();

      recordCntColumn.setHeaderValue("件数");

      recordCntColumn.setColumnName("RECORD_CNT");

      recordCntColumn.setColumns(6);

      recordCntColumn.setHorizontalAlignment(SwingConstants.LEFT);

      addRecordCntColumn();
    }
    return recordCntColumn;

  }

  /**
   * 取込日を取得します。
   * @return 取込日
   */
  public ACTableColumn getImportDateColumn(){
    if(importDateColumn==null){

      importDateColumn = new ACTableColumn();

      importDateColumn.setHeaderValue("取込日");

      importDateColumn.setColumnName("IMPORT_TIME");

      importDateColumn.setColumns(6);

      importDateColumn.setHorizontalAlignment(SwingConstants.LEFT);

      importDateColumn.setFormat(ACConstants.FORMAT_FULL_YMD_HMS);

      addImportDateColumn();
    }
    return importDateColumn;

  }

  /**
   * コンストラクタです。
   */
  public QO015Design() {

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

    buttons.add(getEditButton(), VRLayout.EAST);
    buttons.add(getImportButton(), VRLayout.EAST);
  }

  /**
   * 取込ボタンに内部項目を追加します。
   */
  protected void addImportButton(){

  }

  /**
   * 編集ボタンに内部項目を追加します。
   */
  protected void addEditButton(){

  }

  /**
   * クライアント領域に内部項目を追加します。
   */
  protected void addContents(){

    contents.add(getImports(), VRLayout.NORTH);

    contents.add(getHistoryInfos(), VRLayout.CLIENT);

  }

  /**
   * 取込設定領域に内部項目を追加します。
   */
  protected void addImports(){

    imports.add(getImportFileSelects(), VRLayout.NORTH);

    imports.add(getImportContents(), VRLayout.FLOW_RETURN);

    imports.add(getComment(), VRLayout.FLOW_RETURN);

  }

  /**
   * ファイル選択領域に内部項目を追加します。
   */
  protected void addImportFileSelects(){

    importFileSelects.add(getImportFileSelectFileNameContainer(), VRLayout.FLOW);

    importFileSelects.add(getCsvFileSelectFileCompareButton(), VRLayout.FLOW);

  }

  /**
   * ファイル名入力領域に内部項目を追加します。
   */
  protected void addImportFileSelectFileName(){

  }

  /**
   * ファイル参照ボタンに内部項目を追加します。
   */
  protected void addCsvFileSelectFileCompareButton(){

  }

  /**
   * 取込内容パネルに内部項目を追加します。
   */
  protected void addImportContents(){

    importContents.add(getImportInfoGroup(), VRLayout.FLOW_RETURN);

  }

  /**
   * 取込内容領域に内部項目を追加します。
   */
  protected void addImportInfoGroup(){

    importInfoGroup.add(getInsurerContena(), VRLayout.FLOW_INSETLINE_RETURN);

    importInfoGroup.add(getRecordCntContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 保険者コンテナに内部項目を追加します。
   */
  protected void addInsurerContena(){

    insurerContena.add(getInsurerId(), VRLayout.FLOW);

    insurerContena.add(getInsurerName(), VRLayout.FLOW);

  }

  /**
   * 保険者番号に内部項目を追加します。
   */
  protected void addInsurerId(){

  }

  /**
   * 保険者名称に内部項目を追加します。
   */
  protected void addInsurerName(){

  }

  /**
   * レコード件数に内部項目を追加します。
   */
  protected void addRecordCnt(){

  }

  /**
   * コメント領域に内部項目を追加します。
   */
  protected void addComment(){

    comment.add(getImportComment1(), VRLayout.NORTH);

    comment.add(getImportComment2(), VRLayout.NORTH);

    comment.add(getImportComment3(), VRLayout.NORTH);

  }

  /**
   * 取込コメントに内部項目を追加します。
   */
  protected void addImportComment1(){

  }

  /**
   * 取込コメントに内部項目を追加します。
   */
  protected void addImportComment2(){

  }

  /**
   * 取込コメントに内部項目を追加します。
   */
  protected void addImportComment3(){

  }

  /**
   * 履歴情報表示領域に内部項目を追加します。
   */
  protected void addHistoryInfos(){

    historyInfos.add(getHistoryInfoTable(), VRLayout.CLIENT);

  }

  /**
   * 履歴情報テーブルに内部項目を追加します。
   */
  protected void addHistoryInfoTable(){

  }

  /**
   * 履歴情報テーブルカラムモデルに内部項目を追加します。
   */
  protected void addHistoryInfoTableColumnModel(){

    getHistoryInfoTableColumnModel().addColumn(getInsurerNoColumn());

    getHistoryInfoTableColumnModel().addColumn(getInsurerIdColumn());

    getHistoryInfoTableColumnModel().addColumn(getInsurerNameColumn());

    getHistoryInfoTableColumnModel().addColumn(getRecordCntColumn());

    getHistoryInfoTableColumnModel().addColumn(getImportDateColumn());

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
   * 件数に内部項目を追加します。
   */
  protected void addRecordCntColumn(){

  }

  /**
   * 取込日に内部項目を追加します。
   */
  protected void addImportDateColumn(){

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

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    try {
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QO015Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO015Design getThis() {
    return this;
  }
}
