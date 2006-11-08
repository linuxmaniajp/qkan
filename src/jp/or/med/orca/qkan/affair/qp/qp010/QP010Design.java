
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
 * 作成日: 2006/09/15  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求データ作成 (P)
 * プロセス 利用者一覧(訪問看護療養費領収書) (010)
 * プログラム 利用者一覧(訪問看護療養費領収書) (QP010)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp010;
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
 * 利用者一覧(訪問看護療養費領収書)画面項目デザイン(QP010) 
 */
public class QP010Design extends QkanAffairContainer implements ACAffairable {
  //GUIコンポーネント

  private ACAffairButtonBar buttons;

  private ACAffairButton find;

  private ACAffairButton detail;

  private ACPanel contents;

  private ACLabel loginProviderInfo;

  private ACGroupBox findCondition;

  private QkanYearDateTextField targetDate;

  private ACLabelContainer targetDateContainer;

  private ACIntegerCheckBox onlyExistsResult;

  private ACLabelContainer insurerContainer;

  private ACTextField insurerID;

  private ACComboBox insurerName;

  private ACComboBoxModelAdapter insurerNameModel;

  private ACTextField patientCode;

  private ACLabelContainer patientCodeContainer;

  private ACTextField patientKana;

  private ACLabelContainer patientKanaContainer;

  private ACTextField patientInsuredID;

  private ACLabelContainer patientInsuredIDContainer;

  private ACTable patients;

  private VRTableColumnModel patientsColumnModel;

  private ACTableColumn patinetNoColumn;

  private ACTableColumn patientInsurerIDColumn;

  private ACTableColumn patientInsurerNameColumn;

  private ACTableColumn patientCodeColumn;

  private ACTableColumn patientInsuredIDColumn;

  private ACTableColumn patientNameColumn;

  private ACTableColumn patientKanaColumn;

  private ACTableColumn patientSexColumn;

  private ACTableColumn patientAgeColumn;

  private ACTableColumn patientInsureTypeColumn;

  //getter

  /**
   * ボタンバーを取得します。
   * @return ボタンバー
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("利用者一覧");

      addButtons();
    }
    return buttons;

  }

  /**
   * 検索を取得します。
   * @return 検索
   */
  public ACAffairButton getFind(){
    if(find==null){

      find = new ACAffairButton();

      find.setText("検索(F)");

      find.setToolTipText("対象年月に有効な利用者を検索します。");

      find.setMnemonic('F');

      find.setIconPath(ACConstants.ICON_PATH_FIND_24);

      addFind();
    }
    return find;

  }

  /**
   * 詳細を取得します。
   * @return 詳細
   */
  public ACAffairButton getDetail(){
    if(detail==null){

      detail = new ACAffairButton();

      detail.setText("詳細(E)");

      detail.setToolTipText("選択した利用者の領収書を詳細表示します。");

      detail.setMnemonic('E');

      detail.setIconPath(ACConstants.ICON_PATH_DETAIL_24);

      addDetail();
    }
    return detail;

  }

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
   * ログイン事業所を取得します。
   * @return ログイン事業所
   */
  public ACLabel getLoginProviderInfo(){
    if(loginProviderInfo==null){

      loginProviderInfo = new ACLabel();

      loginProviderInfo.setText("ログイン事業所 に関する領収書作成処理を行ないます。他の事業所を対象とする場合は、ログアウトを行い事業所を選択しなおしてください。");

      loginProviderInfo.setIconPath(ACConstants.ICON_PATH_INFORMATION_16);

      loginProviderInfo.setAutoWrap(true);

      addLoginProviderInfo();
    }
    return loginProviderInfo;

  }

  /**
   * 抽出条件領域を取得します。
   * @return 抽出条件領域
   */
  public ACGroupBox getFindCondition(){
    if(findCondition==null){

      findCondition = new ACGroupBox();

      findCondition.setText("抽出条件");

      findCondition.setAutoWrap(false);

      findCondition.setHgap(0);

      addFindCondition();
    }
    return findCondition;

  }

  /**
   * 対象年月を取得します。
   * @return 対象年月
   */
  public QkanYearDateTextField getTargetDate(){
    if(targetDate==null){

      targetDate = new QkanYearDateTextField();

      getTargetDateContainer().setText("対象年月");

      targetDate.setBindPath("TARGET_DATE");

      targetDate.setAllowedBlank(false);

      try{
        targetDate.setMinimumDate(ACCastUtilities.toDate("2006/04/01"));
      }catch(Throwable ex){
        ACCommon.getInstance().showExceptionMessage(new IllegalArgumentException("targetDate の最小年月日に不正な日付が指定されています。"));
      }

      addTargetDate();
    }
    return targetDate;

  }

  /**
   * 対象年月コンテナを取得します。
   * @return 対象年月コンテナ
   */
  protected ACLabelContainer getTargetDateContainer(){
    if(targetDateContainer==null){
      targetDateContainer = new ACLabelContainer();
      targetDateContainer.setFollowChildEnabled(true);
      targetDateContainer.setVAlignment(VRLayout.CENTER);
      targetDateContainer.add(getTargetDate(), null);
    }
    return targetDateContainer;
  }

  /**
   * 実績有無判別を取得します。
   * @return 実績有無判別
   */
  public ACIntegerCheckBox getOnlyExistsResult(){
    if(onlyExistsResult==null){

      onlyExistsResult = new ACIntegerCheckBox();

      onlyExistsResult.setText("実績のある利用者だけを表示(V)");

      onlyExistsResult.setBindPath("ONLY_EXISTS_RESULT");

      onlyExistsResult.setMnemonic('V');

      addOnlyExistsResult();
    }
    return onlyExistsResult;

  }

  /**
   * 保険者番号コンテナを取得します。
   * @return 保険者番号コンテナ
   */
  public ACLabelContainer getInsurerContainer(){
    if(insurerContainer==null){

      insurerContainer = new ACLabelContainer();

      insurerContainer.setText("保険者番号");

      addInsurerContainer();
    }
    return insurerContainer;

  }

  /**
   * 保険者番号を取得します。
   * @return 保険者番号
   */
  public ACTextField getInsurerID(){
    if(insurerID==null){

      insurerID = new ACTextField();

      insurerID.setBindPath("INSURER_NO");

      insurerID.setColumns(8);

      insurerID.setCharType(VRCharType.ONLY_DIGIT);

      insurerID.setIMEMode(InputSubset.LATIN);

      insurerID.setMaxLength(8);

      addInsurerID();
    }
    return insurerID;

  }

  /**
   * 保険者名を取得します。
   * @return 保険者名
   */
  public ACComboBox getInsurerName(){
    if(insurerName==null){

      insurerName = new ACComboBox();

      insurerName.setBindPath("INSURER_NAME");

      insurerName.setEditable(false);

      insurerName.setRenderBindPath("INSURER_NAME");

      insurerName.setBlankable(true);

      insurerName.setModel(getInsurerNameModel());

      addInsurerName();
    }
    return insurerName;

  }

  /**
   * 保険者名モデルを取得します。
   * @return 保険者名モデル
   */
  protected ACComboBoxModelAdapter getInsurerNameModel(){
    if(insurerNameModel==null){
      insurerNameModel = new ACComboBoxModelAdapter();
      addInsurerNameModel();
    }
    return insurerNameModel;
  }

  /**
   * 利用者コードを取得します。
   * @return 利用者コード
   */
  public ACTextField getPatientCode(){
    if(patientCode==null){

      patientCode = new ACTextField();

      getPatientCodeContainer().setText("利用者コード");

      patientCode.setBindPath("PATIENT_CODE");

      patientCode.setColumns(15);

      patientCode.setCharType(VRCharType.ONLY_HALF_CHAR);

      patientCode.setIMEMode(InputSubset.LATIN);

      patientCode.setMaxLength(15);

      addPatientCode();
    }
    return patientCode;

  }

  /**
   * 利用者コードコンテナを取得します。
   * @return 利用者コードコンテナ
   */
  protected ACLabelContainer getPatientCodeContainer(){
    if(patientCodeContainer==null){
      patientCodeContainer = new ACLabelContainer();
      patientCodeContainer.setFollowChildEnabled(true);
      patientCodeContainer.setVAlignment(VRLayout.CENTER);
      patientCodeContainer.add(getPatientCode(), null);
    }
    return patientCodeContainer;
  }

  /**
   * 利用者ふりがなを取得します。
   * @return 利用者ふりがな
   */
  public ACTextField getPatientKana(){
    if(patientKana==null){

      patientKana = new ACTextField();

      getPatientKanaContainer().setText("利用者ふりがな");

      patientKana.setBindPath("PATIENT_KANA");

      patientKana.setColumns(40);

      patientKana.setIMEMode(InputSubset.KANJI);

      patientKana.setMaxLength(40);

      addPatientKana();
    }
    return patientKana;

  }

  /**
   * 利用者ふりがなコンテナを取得します。
   * @return 利用者ふりがなコンテナ
   */
  protected ACLabelContainer getPatientKanaContainer(){
    if(patientKanaContainer==null){
      patientKanaContainer = new ACLabelContainer();
      patientKanaContainer.setFollowChildEnabled(true);
      patientKanaContainer.setVAlignment(VRLayout.CENTER);
      patientKanaContainer.add(getPatientKana(), null);
    }
    return patientKanaContainer;
  }

  /**
   * 記号・番号を取得します。
   * @return 記号・番号
   */
  public ACTextField getPatientInsuredID(){
    if(patientInsuredID==null){

      patientInsuredID = new ACTextField();

      getPatientInsuredIDContainer().setText("記号・番号");

      patientInsuredID.setBindPath("MEDICAL_INSURE_ID");

      patientInsuredID.setColumns(16);

      patientInsuredID.setIMEMode(InputSubset.KANJI);

      patientInsuredID.setMaxLength(16);

      addPatientInsuredID();
    }
    return patientInsuredID;

  }

  /**
   * 記号・番号コンテナを取得します。
   * @return 記号・番号コンテナ
   */
  protected ACLabelContainer getPatientInsuredIDContainer(){
    if(patientInsuredIDContainer==null){
      patientInsuredIDContainer = new ACLabelContainer();
      patientInsuredIDContainer.setFollowChildEnabled(true);
      patientInsuredIDContainer.setVAlignment(VRLayout.CENTER);
      patientInsuredIDContainer.add(getPatientInsuredID(), null);
    }
    return patientInsuredIDContainer;
  }

  /**
   * 利用者一覧を取得します。
   * @return 利用者一覧
   */
  public ACTable getPatients(){
    if(patients==null){

      patients = new ACTable();

      patients.setColumnModel(getPatientsColumnModel());

      addPatients();
    }
    return patients;

  }

  /**
   * 利用者一覧カラムモデルを取得します。
   * @return 利用者一覧カラムモデル
   */
  protected VRTableColumnModel getPatientsColumnModel(){
    if(patientsColumnModel==null){
      patientsColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addPatientsColumnModel();
    }
    return patientsColumnModel;
  }

  /**
   * 利用者一覧：No.を取得します。
   * @return 利用者一覧：No.
   */
  public ACTableColumn getPatinetNoColumn(){
    if(patinetNoColumn==null){

      patinetNoColumn = new ACTableColumn();

      patinetNoColumn.setHeaderValue("No.");

      patinetNoColumn.setColumnName("INSURER_ID");

      patinetNoColumn.setColumns(3);

      patinetNoColumn.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      patinetNoColumn.setSortable(false);

      addPatinetNoColumn();
    }
    return patinetNoColumn;

  }

  /**
   * 利用者一覧：保険者番号を取得します。
   * @return 利用者一覧：保険者番号
   */
  public ACTableColumn getPatientInsurerIDColumn(){
    if(patientInsurerIDColumn==null){

      patientInsurerIDColumn = new ACTableColumn();

      patientInsurerIDColumn.setHeaderValue("保険者番号");

      patientInsurerIDColumn.setColumnName("INSURER_ID");

      patientInsurerIDColumn.setColumns(8);

      addPatientInsurerIDColumn();
    }
    return patientInsurerIDColumn;

  }

  /**
   * 利用者一覧：保険者名称を取得します。
   * @return 利用者一覧：保険者名称
   */
  public ACTableColumn getPatientInsurerNameColumn(){
    if(patientInsurerNameColumn==null){

      patientInsurerNameColumn = new ACTableColumn();

      patientInsurerNameColumn.setHeaderValue("保険者名称");

      patientInsurerNameColumn.setColumnName("INSURER_ID");

      patientInsurerNameColumn.setColumns(10);

      addPatientInsurerNameColumn();
    }
    return patientInsurerNameColumn;

  }

  /**
   * 利用者一覧：利用者コードを取得します。
   * @return 利用者一覧：利用者コード
   */
  public ACTableColumn getPatientCodeColumn(){
    if(patientCodeColumn==null){

      patientCodeColumn = new ACTableColumn();

      patientCodeColumn.setHeaderValue("利用者コード");

      patientCodeColumn.setColumnName("PATIENT_CODE");

      patientCodeColumn.setColumns(10);

      addPatientCodeColumn();
    }
    return patientCodeColumn;

  }

  /**
   * 利用者一覧：記号・番号を取得します。
   * @return 利用者一覧：記号・番号
   */
  public ACTableColumn getPatientInsuredIDColumn(){
    if(patientInsuredIDColumn==null){

      patientInsuredIDColumn = new ACTableColumn();

      patientInsuredIDColumn.setHeaderValue("記号・番号");

      patientInsuredIDColumn.setColumnName("MEDICAL_INSURE_ID");

      patientInsuredIDColumn.setColumns(16);

      addPatientInsuredIDColumn();
    }
    return patientInsuredIDColumn;

  }

  /**
   * 利用者一覧：利用者氏名を取得します。
   * @return 利用者一覧：利用者氏名
   */
  public ACTableColumn getPatientNameColumn(){
    if(patientNameColumn==null){

      patientNameColumn = new ACTableColumn();

      patientNameColumn.setHeaderValue("利用者氏名");

      patientNameColumn.setColumnName("PATIENT_FAMILY_NAME+'　'+PATIENT_FIRST_NAME");

      patientNameColumn.setColumns(10);

      addPatientNameColumn();
    }
    return patientNameColumn;

  }

  /**
   * 利用者一覧：ふりがなを取得します。
   * @return 利用者一覧：ふりがな
   */
  public ACTableColumn getPatientKanaColumn(){
    if(patientKanaColumn==null){

      patientKanaColumn = new ACTableColumn();

      patientKanaColumn.setHeaderValue("ふりがな");

      patientKanaColumn.setColumnName("PATIENT_FAMILY_KANA+'　'+PATIENT_FIRST_KANA");

      patientKanaColumn.setColumns(10);

      addPatientKanaColumn();
    }
    return patientKanaColumn;

  }

  /**
   * 利用者一覧：性別を取得します。
   * @return 利用者一覧：性別
   */
  public ACTableColumn getPatientSexColumn(){
    if(patientSexColumn==null){

      patientSexColumn = new ACTableColumn();

      patientSexColumn.setHeaderValue("性別");

      patientSexColumn.setColumnName("PATIENT_SEX");

      patientSexColumn.setColumns(4);

      patientSexColumn.setFormat(QkanConstants.FORMAT_SEX);

      addPatientSexColumn();
    }
    return patientSexColumn;

  }

  /**
   * 利用者一覧：年齢を取得します。
   * @return 利用者一覧：年齢
   */
  public ACTableColumn getPatientAgeColumn(){
    if(patientAgeColumn==null){

      patientAgeColumn = new ACTableColumn();

      patientAgeColumn.setHeaderValue("年齢");

      patientAgeColumn.setColumnName("PATIENT_BIRTHDAY");

      patientAgeColumn.setColumns(4);

      patientAgeColumn.setFormat(QkanConstants.FORMAT_NOW_AGE);

      addPatientAgeColumn();
    }
    return patientAgeColumn;

  }

  /**
   * 利用者一覧：保険区分を取得します。
   * @return 利用者一覧：保険区分
   */
  public ACTableColumn getPatientInsureTypeColumn(){
    if(patientInsureTypeColumn==null){

      patientInsureTypeColumn = new ACTableColumn();

      patientInsureTypeColumn.setHeaderValue("保険区分");

      patientInsureTypeColumn.setColumnName("INSURE_TYPE");

      patientInsureTypeColumn.setColumns(6);

      patientInsureTypeColumn.setFormat(QkanInsureTypeFormat.getInstance());

      addPatientInsureTypeColumn();
    }
    return patientInsureTypeColumn;

  }

  /**
   * コンストラクタです。
   */
  public QP010Design() {

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

    buttons.add(getDetail(), VRLayout.EAST);
    buttons.add(getFind(), VRLayout.EAST);
  }

  /**
   * 検索に内部項目を追加します。
   */
  protected void addFind(){

  }

  /**
   * 詳細に内部項目を追加します。
   */
  protected void addDetail(){

  }

  /**
   * クライアント領域に内部項目を追加します。
   */
  protected void addContents(){

    contents.add(getLoginProviderInfo(), VRLayout.NORTH);

    contents.add(getFindCondition(), VRLayout.NORTH);

    contents.add(getPatients(), VRLayout.CLIENT);

  }

  /**
   * ログイン事業所に内部項目を追加します。
   */
  protected void addLoginProviderInfo(){

  }

  /**
   * 抽出条件領域に内部項目を追加します。
   */
  protected void addFindCondition(){

    findCondition.add(getTargetDateContainer(), VRLayout.FLOW);

    findCondition.add(getOnlyExistsResult(), VRLayout.FLOW_RETURN);

    findCondition.add(getInsurerContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    findCondition.add(getPatientCodeContainer(), VRLayout.FLOW_INSETLINE);

    findCondition.add(getPatientKanaContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    findCondition.add(getPatientInsuredIDContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 対象年月に内部項目を追加します。
   */
  protected void addTargetDate(){

  }

  /**
   * 実績有無判別に内部項目を追加します。
   */
  protected void addOnlyExistsResult(){

  }

  /**
   * 保険者番号コンテナに内部項目を追加します。
   */
  protected void addInsurerContainer(){

    insurerContainer.add(getInsurerID(), VRLayout.FLOW);

    insurerContainer.add(getInsurerName(), VRLayout.FLOW);

  }

  /**
   * 保険者番号に内部項目を追加します。
   */
  protected void addInsurerID(){

  }

  /**
   * 保険者名に内部項目を追加します。
   */
  protected void addInsurerName(){

  }

  /**
   * 保険者名モデルに内部項目を追加します。
   */
  protected void addInsurerNameModel(){

  }

  /**
   * 利用者コードに内部項目を追加します。
   */
  protected void addPatientCode(){

  }

  /**
   * 利用者ふりがなに内部項目を追加します。
   */
  protected void addPatientKana(){

  }

  /**
   * 記号・番号に内部項目を追加します。
   */
  protected void addPatientInsuredID(){

  }

  /**
   * 利用者一覧に内部項目を追加します。
   */
  protected void addPatients(){

  }

  /**
   * 利用者一覧カラムモデルに内部項目を追加します。
   */
  protected void addPatientsColumnModel(){

    getPatientsColumnModel().addColumn(getPatinetNoColumn());

    getPatientsColumnModel().addColumn(getPatientInsurerIDColumn());

    getPatientsColumnModel().addColumn(getPatientInsurerNameColumn());

    getPatientsColumnModel().addColumn(getPatientCodeColumn());

    getPatientsColumnModel().addColumn(getPatientInsuredIDColumn());

    getPatientsColumnModel().addColumn(getPatientNameColumn());

    getPatientsColumnModel().addColumn(getPatientKanaColumn());

    getPatientsColumnModel().addColumn(getPatientSexColumn());

    getPatientsColumnModel().addColumn(getPatientAgeColumn());

    getPatientsColumnModel().addColumn(getPatientInsureTypeColumn());

  }

  /**
   * 利用者一覧：No.に内部項目を追加します。
   */
  protected void addPatinetNoColumn(){

  }

  /**
   * 利用者一覧：保険者番号に内部項目を追加します。
   */
  protected void addPatientInsurerIDColumn(){

  }

  /**
   * 利用者一覧：保険者名称に内部項目を追加します。
   */
  protected void addPatientInsurerNameColumn(){

  }

  /**
   * 利用者一覧：利用者コードに内部項目を追加します。
   */
  protected void addPatientCodeColumn(){

  }

  /**
   * 利用者一覧：記号・番号に内部項目を追加します。
   */
  protected void addPatientInsuredIDColumn(){

  }

  /**
   * 利用者一覧：利用者氏名に内部項目を追加します。
   */
  protected void addPatientNameColumn(){

  }

  /**
   * 利用者一覧：ふりがなに内部項目を追加します。
   */
  protected void addPatientKanaColumn(){

  }

  /**
   * 利用者一覧：性別に内部項目を追加します。
   */
  protected void addPatientSexColumn(){

  }

  /**
   * 利用者一覧：年齢に内部項目を追加します。
   */
  protected void addPatientAgeColumn(){

  }

  /**
   * 利用者一覧：保険区分に内部項目を追加します。
   */
  protected void addPatientInsureTypeColumn(){

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

    return getTargetDate();

  }
  public void initAffair(ACAffairInfo affair) throws Exception {
  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    try {
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QP010Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QP010Design getThis() {
    return this;
  }
}
