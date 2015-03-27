
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
 * 開発者: 日高　しのぶ
 * 作成日: 2014/12/19  MIS九州株式会社 日高　しのぶ 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 帳票管理 (C)
 * プロセス 居宅療養管理指導書 (006)
 * プログラム 居宅療養管理指導書一覧 (QC006)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qc.qc006;
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
 * 居宅療養管理指導書一覧画面項目デザイン(QC006) 
 */
public class QC006Design extends QkanAffairContainer implements ACAffairable {
  //GUIコンポーネント

  private ACAffairButtonBar buttons;

  private ACAffairButton detail;

  private ACAffairButton insert;

  private ACAffairButton delete;

  private ACPanel contents;

  private ACPanel patientPanel;

  private ACLabel targetDateCaption;

  private ACLabel targetDateLabel;

  private ACLabel patinetNameLabel;

  private ACTextField patientName;

  private ACLabel patientNoLabel1;

  private ACTextField patientNo;

  private ACLabel PatientNoLabel2;

  private ACPanel kyotakuPanel;

  private ACTable kyotakuTable;

  private VRTableColumnModel kyotakuTableColumnModel;

  private ACTableColumn kyotakuTableColumn1;

  private ACTableColumn kyotakuTableColumn2;

  private ACTableColumn kyotakuTableColumn3;

  private ACTableColumn kyotakuTableColumn4;

  private ACTableColumn kyotakuTableColumn5;

  private ACTableColumn kyotakuTableColumn6;

  private ACTableColumn kyotakuTableColumn7;

  private ACTableColumn kyotakuTableColumn8;

  //getter

  /**
   * ボタンバーを取得します。
   * @return ボタンバー
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("居宅療養管理指導書一覧");

      addButtons();
    }
    return buttons;

  }

  /**
   * 詳細(E)を取得します。
   * @return 詳細(E)
   */
  public ACAffairButton getDetail(){
    if(detail==null){

      detail = new ACAffairButton();

      detail.setText("詳細(E)");

      detail.setToolTipText("選択された居宅療養管理指導書の編集画面移ります。");

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

      insert.setToolTipText("居宅療養管理指導書を新規に作成します。");

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

      delete.setToolTipText("選択された居宅療養管理指導書を削除します。");

      delete.setMnemonic('D');

      delete.setIconPath(ACConstants.ICON_PATH_DELETE_24);

      addDelete();
    }
    return delete;

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
   * 利用者名領域を取得します。
   * @return 利用者名領域
   */
  public ACPanel getPatientPanel(){
    if(patientPanel==null){

      patientPanel = new ACPanel();

      patientPanel.setHgap(3);

      patientPanel.setVgap(3);

      addPatientPanel();
    }
    return patientPanel;

  }

  /**
   * 対象年月・ラベルを取得します。
   * @return 対象年月・ラベル
   */
  public ACLabel getTargetDateCaption(){
    if(targetDateCaption==null){

      targetDateCaption = new ACLabel();

      targetDateCaption.setText("　対象年月：");

      targetDateCaption.setForeground(Color.blue);

      addTargetDateCaption();
    }
    return targetDateCaption;

  }

  /**
   * 対象年月を取得します。
   * @return 対象年月
   */
  public ACLabel getTargetDateLabel(){
    if(targetDateLabel==null){

      targetDateLabel = new ACLabel();

      targetDateLabel.setBindPath("TARGET_DATE");

      targetDateLabel.setForeground(Color.blue);

      addTargetDateLabel();
    }
    return targetDateLabel;

  }

  /**
   * 利用者名・ラベルを取得します。
   * @return 利用者名・ラベル
   */
  public ACLabel getPatinetNameLabel(){
    if(patinetNameLabel==null){

      patinetNameLabel = new ACLabel();

      patinetNameLabel.setText("　利用者名：");

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
  public ACPanel getKyotakuPanel(){
    if(kyotakuPanel==null){

      kyotakuPanel = new ACPanel();

      addKyotakuPanel();
    }
    return kyotakuPanel;

  }

  /**
   * 居宅療養管理指導書情報テーブルを取得します。
   * @return 居宅療養管理指導書情報テーブル
   */
  public ACTable getKyotakuTable(){
    if(kyotakuTable==null){

      kyotakuTable = new ACTable();

      kyotakuTable.setColumnModel(getKyotakuTableColumnModel());

      addKyotakuTable();
    }
    return kyotakuTable;

  }

  /**
   * 居宅療養管理指導書情報テーブルカラムモデルを取得します。
   * @return 居宅療養管理指導書情報テーブルカラムモデル
   */
  protected VRTableColumnModel getKyotakuTableColumnModel(){
    if(kyotakuTableColumnModel==null){
      kyotakuTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addKyotakuTableColumnModel();
    }
    return kyotakuTableColumnModel;
  }

  /**
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getKyotakuTableColumn1(){
    if(kyotakuTableColumn1==null){

      kyotakuTableColumn1 = new ACTableColumn();

      kyotakuTableColumn1.setHeaderValue("No.");

      kyotakuTableColumn1.setColumnName("NO");

      kyotakuTableColumn1.setColumns(3);

      kyotakuTableColumn1.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      kyotakuTableColumn1.setSortable(false);

      addKyotakuTableColumn1();
    }
    return kyotakuTableColumn1;

  }

  /**
   * 印刷を取得します。
   * @return 印刷
   */
  public ACTableColumn getKyotakuTableColumn2(){
    if(kyotakuTableColumn2==null){

      kyotakuTableColumn2 = new ACTableColumn();

      kyotakuTableColumn2.setHeaderValue("印刷");

      kyotakuTableColumn2.setColumnName("FINISH_FLAG");

      kyotakuTableColumn2.setColumns(3);

      kyotakuTableColumn2.setHorizontalAlignment(SwingConstants.LEFT);

      addKyotakuTableColumn2();
    }
    return kyotakuTableColumn2;

  }

  /**
   * 作成年月日を取得します。
   * @return 作成年月日
   */
  public ACTableColumn getKyotakuTableColumn3(){
    if(kyotakuTableColumn3==null){

      kyotakuTableColumn3 = new ACTableColumn();

      kyotakuTableColumn3.setHeaderValue("作成年月日");

      kyotakuTableColumn3.setColumnName("CREATE_DATE_KYOTAKU");

      kyotakuTableColumn3.setColumns(7);

      kyotakuTableColumn3.setHorizontalAlignment(SwingConstants.LEFT);

      addKyotakuTableColumn3();
    }
    return kyotakuTableColumn3;

  }

  /**
   * 医療機関名を取得します。
   * @return 医療機関名
   */
  public ACTableColumn getKyotakuTableColumn4(){
    if(kyotakuTableColumn4==null){

      kyotakuTableColumn4 = new ACTableColumn();

      kyotakuTableColumn4.setHeaderValue("医療機関名");

      kyotakuTableColumn4.setColumnName("MEDICAL_FACILITY_NAME");

      kyotakuTableColumn4.setColumns(10);

      kyotakuTableColumn4.setHorizontalAlignment(SwingConstants.LEFT);

      addKyotakuTableColumn4();
    }
    return kyotakuTableColumn4;

  }

  /**
   * 担当医氏名を取得します。
   * @return 担当医氏名
   */
  public ACTableColumn getKyotakuTableColumn5(){
    if(kyotakuTableColumn5==null){

      kyotakuTableColumn5 = new ACTableColumn();

      kyotakuTableColumn5.setHeaderValue("担当医氏名");

      kyotakuTableColumn5.setColumnName("DOCTOR_NAME");

      kyotakuTableColumn5.setColumns(8);

      kyotakuTableColumn5.setHorizontalAlignment(SwingConstants.LEFT);

      addKyotakuTableColumn5();
    }
    return kyotakuTableColumn5;

  }

  /**
   * 介護支援専門員を取得します。
   * @return 介護支援専門員
   */
  public ACTableColumn getKyotakuTableColumn6(){
    if(kyotakuTableColumn6==null){

      kyotakuTableColumn6 = new ACTableColumn();

      kyotakuTableColumn6.setHeaderValue("介護支援専門員");

      kyotakuTableColumn6.setColumnName("SENMONIN");

      kyotakuTableColumn6.setColumns(8);

      kyotakuTableColumn6.setHorizontalAlignment(SwingConstants.LEFT);

      addKyotakuTableColumn6();
    }
    return kyotakuTableColumn6;

  }

  /**
   * 事業所名を取得します。
   * @return 事業所名
   */
  public ACTableColumn getKyotakuTableColumn7(){
    if(kyotakuTableColumn7==null){

      kyotakuTableColumn7 = new ACTableColumn();

      kyotakuTableColumn7.setHeaderValue("事業所名");

      kyotakuTableColumn7.setColumnName("PROVIDER_NAME");

      kyotakuTableColumn7.setColumns(10);

      kyotakuTableColumn7.setHorizontalAlignment(SwingConstants.LEFT);

      addKyotakuTableColumn7();
    }
    return kyotakuTableColumn7;

  }

  /**
   * 病状を取得します。
   * @return 病状
   */
  public ACTableColumn getKyotakuTableColumn8(){
    if(kyotakuTableColumn8==null){

      kyotakuTableColumn8 = new ACTableColumn();

      kyotakuTableColumn8.setHeaderValue("病状");

      kyotakuTableColumn8.setColumnName("CONDITION");

      kyotakuTableColumn8.setColumns(20);

      kyotakuTableColumn8.setHorizontalAlignment(SwingConstants.LEFT);

      addKyotakuTableColumn8();
    }
    return kyotakuTableColumn8;

  }

  /**
   * コンストラクタです。
   */
  public QC006Design() {

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

    buttons.add(getDelete(), VRLayout.EAST);
    buttons.add(getInsert(), VRLayout.EAST);
    buttons.add(getDetail(), VRLayout.EAST);
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
   * クライアント領域に内部項目を追加します。
   */
  protected void addContents(){

    contents.add(getPatientPanel(), VRLayout.NORTH);

    contents.add(getKyotakuPanel(), VRLayout.CLIENT);

  }

  /**
   * 利用者名領域に内部項目を追加します。
   */
  protected void addPatientPanel(){

    patientPanel.add(getTargetDateCaption(), VRLayout.FLOW);

    patientPanel.add(getTargetDateLabel(), VRLayout.FLOW_RETURN);

    patientPanel.add(getPatinetNameLabel(), VRLayout.FLOW);

    patientPanel.add(getPatientName(), VRLayout.FLOW);

    patientPanel.add(getPatientNoLabel1(), VRLayout.FLOW);

    patientPanel.add(getPatientNo(), VRLayout.FLOW);

    patientPanel.add(getPatientNoLabel2(), VRLayout.FLOW);

  }

  /**
   * 対象年月・ラベルに内部項目を追加します。
   */
  protected void addTargetDateCaption(){

  }

  /**
   * 対象年月に内部項目を追加します。
   */
  protected void addTargetDateLabel(){

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
  protected void addKyotakuPanel(){

    kyotakuPanel.add(getKyotakuTable(), VRLayout.CLIENT);

  }

  /**
   * 居宅療養管理指導書情報テーブルに内部項目を追加します。
   */
  protected void addKyotakuTable(){

  }

  /**
   * 居宅療養管理指導書情報テーブルカラムモデルに内部項目を追加します。
   */
  protected void addKyotakuTableColumnModel(){

    getKyotakuTableColumnModel().addColumn(getKyotakuTableColumn1());

    getKyotakuTableColumnModel().addColumn(getKyotakuTableColumn2());

    getKyotakuTableColumnModel().addColumn(getKyotakuTableColumn3());

    getKyotakuTableColumnModel().addColumn(getKyotakuTableColumn4());

    getKyotakuTableColumnModel().addColumn(getKyotakuTableColumn5());

    getKyotakuTableColumnModel().addColumn(getKyotakuTableColumn6());

    getKyotakuTableColumnModel().addColumn(getKyotakuTableColumn7());

    getKyotakuTableColumnModel().addColumn(getKyotakuTableColumn8());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addKyotakuTableColumn1(){

  }

  /**
   * 印刷に内部項目を追加します。
   */
  protected void addKyotakuTableColumn2(){

  }

  /**
   * 作成年月日に内部項目を追加します。
   */
  protected void addKyotakuTableColumn3(){

  }

  /**
   * 医療機関名に内部項目を追加します。
   */
  protected void addKyotakuTableColumn4(){

  }

  /**
   * 担当医氏名に内部項目を追加します。
   */
  protected void addKyotakuTableColumn5(){

  }

  /**
   * 介護支援専門員に内部項目を追加します。
   */
  protected void addKyotakuTableColumn6(){

  }

  /**
   * 事業所名に内部項目を追加します。
   */
  protected void addKyotakuTableColumn7(){

  }

  /**
   * 病状に内部項目を追加します。
   */
  protected void addKyotakuTableColumn8(){

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
      ACFrame.debugStart(new ACAffairInfo(QC006Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QC006Design getThis() {
    return this;
  }
}
